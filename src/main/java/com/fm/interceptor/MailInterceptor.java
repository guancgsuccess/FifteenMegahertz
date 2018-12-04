package com.fm.interceptor;

import com.fm.util.MySessionContext;
import com.fm.util.md5;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created on 2018/10/31.
 * 忘记密码拦截器
 * @author guochangji
 */
public class MailInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String newCode=request.getParameter("code");
        String token=request.getParameter("token");
        if(newCode!=null && token!=null){
            MySessionContext myc= MySessionContext.getInstance();
            HttpSession session = myc.getSession(md5.md5Decrypt(token));
            if(session==null){
                httpServletResponse.sendRedirect("/404.html");
                return false;
            }
            String oldCode= (String)session.getAttribute("code");
            if(newCode.equals(oldCode)){
                session.removeAttribute("code");
                return true;
            }else {
                httpServletResponse.sendRedirect("/404.html");
                return false;
            }
        }else{
            httpServletResponse.sendRedirect("/404.html");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
