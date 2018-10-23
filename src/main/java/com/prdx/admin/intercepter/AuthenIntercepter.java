package com.prdx.admin.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenIntercepter implements HandlerInterceptor {
	

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*try {
            ModelAndView modelViewTimeOut = new ModelAndView("timeout");
            ModelAndView modelViewTerminate = new ModelAndView("terminate");

        	HttpSession session = request.getSession();
        	String sessionKey = (String) request.getParameter("sessId");

//        	System.out.println("path: "+request.getServletPath());
//        	System.out.println("sessionKey: "+StringUtil.decodeUrl(sessionKey, PortalConstants.ENCODING_UTF_8)+ "   user: "+RepositoryHelper.getUserInfo(session));
        	
        	if (RepositoryHelper.getUserInfo(session) != null && StringUtils.isNotBlank(sessionKey)) {
        		UserInfo user = RepositoryHelper.getUserInfo(session);
        		sessionKey = StringUtils.isNotBlank(sessionKey) ? StringUtil.decodeUrl(sessionKey, PortalConstants.ENCODING_UTF_8) : user.getSessionId();
        		
        		if (!authenService.validateSessionAuthen(sessionKey, request)) {
                    throw new ModelAndViewDefiningException(modelViewTerminate);
        		}
        		
        		if (!authenService.authenUserLogin(user.getUserId(), sessionKey)) {
                    throw new ModelAndViewDefiningException(modelViewTimeOut);
        		}
        		return true;
        	}
        	else if (RepositoryHelper.getUserInfo(session) != null 
        			 	&& request.getServletPath().contains("upload_form")) {
        		return true;
        	}
        	
        	if ((request.getServletPath().contains("login")) ||
        			(request.getServletPath().contains("pageNotFound")) ||
        			(request.getServletPath().contains("timeout")) ||
        			(request.getServletPath().contains("terminate"))) {
        		return true;
        	}

            throw new ModelAndViewDefiningException(modelViewTimeOut);
		}
		catch (ModelAndViewDefiningException e) {
			throw e;
		}
		catch (Exception e) {
			ModelAndView modelViewTimeOut = new ModelAndView("terminate");
			throw new ModelAndViewDefiningException(modelViewTimeOut);
    	}*/
		return true;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}
}
