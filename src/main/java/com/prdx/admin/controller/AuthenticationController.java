package com.prdx.admin.controller;
/*package com.prdx.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ktb.anyid.adjust.portal.bean.MenuBean;
import com.ktb.anyid.adjust.portal.bean.UserInfo;
import com.ktb.anyid.adjust.portal.helper.ApplicationHelper;
import com.ktb.anyid.adjust.portal.helper.RepositoryHelper;
import com.ktb.anyid.adjust.portal.log.LogConstants;
import com.ktb.anyid.adjust.portal.log.LogUtil;
import com.ktb.anyid.adjust.portal.log.LogUtilImpl;
import com.ktb.anyid.adjust.portal.service.AuthenService;
import com.ktb.anyid.adjust.portal.service.MenuService;

@Controller
public class AuthenticationController {

	public static final String PAGE_LOGIN = "login";
	public static final String PAGE_MAIN = "main";
	
	private LogUtil logger = LogUtilImpl.getLogger(LogConstants.LOG_AUTHEN);
	
	@Autowired
	private AuthenService authenService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexGet(HttpServletRequest req) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new RedirectView(PAGE_LOGIN));
		return modelAndView;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest reqServlet) throws Exception {
		ModelAndView modelAndView = new ModelAndView(PAGE_LOGIN);
		return modelAndView;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest reqServlet) throws Exception {
//		ModelAndView modelAndView = new ModelAndView(new RedirectView(PAGE_MAIN));
		ModelAndView modelAndView = new ModelAndView(PAGE_MAIN);

		HttpSession session = reqServlet.getSession();
		String userName = "";
		try {
			userName = reqServlet.getParameter("username");
			String password = reqServlet.getParameter("password");
			
			String sessionKey = ApplicationHelper.getNewSessionKey(session.getId());
			UserInfo user = authenService.authen(userName, password, sessionKey);
			
			List<MenuBean> menus = menuService.getMenus();
			
			modelAndView.addObject("menus", menus);
			modelAndView.addObject("sessionKey", user.getSessionId());
			modelAndView.addObject("userInfo", user);
			
			RepositoryHelper.setUserInfo(session, user);
		}
        catch (Exception e) {
        	logger.error("AuthenticationController loginPost Exception userId: "+userName, e);
            return ApplicationHelper.errorDefault();
        }
		return modelAndView;
	}
	
	@RequestMapping(value = "logout", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView logout(HttpServletRequest reqServlet) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new RedirectView(PAGE_LOGIN));
		UserInfo user = RepositoryHelper.getUserInfo(reqServlet.getSession());
		try {
			authenService.logout(user.getUserId());
		}
        catch (Exception e) {
        	logger.error("AuthenticationController logout Exception: ", e);
        }
		
		return modelAndView;
	}

}
*/