//package com.lmk.bootln2.serivce;
//
//import com.lmk.bootln2.model.User;
//import com.lmk.bootln2.model.UserOnline;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.mgt.eis.SessionDAO;
//import org.apache.shiro.subject.SimplePrincipalCollection;
//import org.apache.shiro.subject.support.DefaultSubjectContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class SessionService {
//
//    @Autowired
//    private SessionDAO sessionDAO;
//
//    public List<UserOnline> list(){
//        List<UserOnline> list =new ArrayList<>();
//        Collection<Session> activeSessions = null;
//        try {
//             activeSessions = sessionDAO.getActiveSessions();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        for(Session session:activeSessions){
//            UserOnline userOnline =new UserOnline();
//            User user =new User();
//            SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
//            if(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)==null){
//                continue;
//            }else{
//                principalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//                user = (User) principalCollection.getPrimaryPrincipal();
//                userOnline.setUsername(user.getUsername());
//                userOnline.setUserId(user.getId().toString());
//            }
//            userOnline.setHost(session.getHost());
//            userOnline.setId(session.getId().toString());
//            userOnline.setStartTimestamp(session.getStartTimestamp());
//            userOnline.setLastAccessTime(session.getLastAccessTime());
//            long timeout = session.getTimeout();
//            if(timeout ==0l){
//                userOnline.setStatus("离线");
//            }else{
//                userOnline.setStatus("在线");
//            }
//            userOnline.setTimeout(timeout);
//            list.add(userOnline);
//
//
//        }
//        System.out.println(list);
//        return list;
//    }
//
//    public boolean forceLogout(String seeionid){
//        Session session = sessionDAO.readSession(seeionid);
//        session.setTimeout(0l);
//        return true;
//    }
//}
