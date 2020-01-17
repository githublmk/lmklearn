package com.lmk.bootln2.jwt;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class JWTFilter extends BasicHttpAuthenticationFilter {

    /**
     * 如果带有token，则对token进行检查，否则直接通过
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
       //判断请求的请求头是否带上token
        if(isLoginAttempt(request,response)){
            //如果存在，进入exxcuteLogin方法执行登入，检查token是否正确
            try {
                executeLogin(request,response);
                return true;
            }catch (Exception e){
                responseError(response,e.getMessage());
            }

        }

        return true;
    }

    /**
     * 判断用户是否想要登入
     * 检测header中是否含有Token字段
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String token = servletRequest.getHeader("token");
        if(token==null){
            return false;
        }
        return true;
    }

    /**
     * 执行远程登陆
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

       HttpServletRequest servletRequest = (HttpServletRequest) request;
        String token = servletRequest.getHeader("token");
        JWTToken jwtToken = new JWTToken(token);
        Subject subject = getSubject(request, response);
        subject.login(jwtToken);
        return true;


    }

    /**
     * 跨域支持
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

      HttpServletRequest request1 = (HttpServletRequest) request;
      HttpServletResponse response1 = (HttpServletResponse) response;
      response1.setHeader("Access-control-Allow-Origin",request1.getHeader("Origin"));
      response1.setHeader("Access-control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
      response1.setHeader("Access-control-Allow-Headers",request1.getHeader("Access-Control-Request-Header"));
      // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
      if(request1.getMethod().equals(RequestMethod.OPTIONS.name())) {
          response1.setStatus(HttpStatus.OK.value());
          return false;
      }

      return super.preHandle(request, response);
    }

    private void responseError(ServletResponse response, String message) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            //设置编码，否则中文字符在重定向时会变为空字符串
            message = URLEncoder.encode(message, "UTF-8");
            httpServletResponse.sendRedirect("/unauthorized/" + message);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
