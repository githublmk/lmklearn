package com.boot.ln.duridln.controller;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.function.ServerResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
public class EnterMailController {

    @Autowired
    private JavaMailSender jms;
    @Value("${spring.mail.username}")
    private String form;

    @Autowired
    private TemplateEngine templateEngine;
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendSimpleEmail(){
        try {
            SimpleMailMessage message =new SimpleMailMessage();
            message.setFrom(form);
            message.setTo("1127711906@qq.com");
            message.setSubject("一封简单的邮件");
            message.setText("使用springboot发送简单的邮件");
            jms.send(message);
            return "successs";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @ResponseBody
    @RequestMapping("/send")
    public String send(String code){
        MimeMessage mimeMessage =null;
        try{
            mimeMessage = jms.createMimeMessage();
            MimeMessageHelper helper =new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(form);
            helper.setTo("1127711906@qq.com");
            helper.setSubject("邮件测试模板");
            Context context =new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("emailTemp",context);
            helper.setText(template);
            jms.send(mimeMessage);
            return "success";
        } catch (MessagingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
