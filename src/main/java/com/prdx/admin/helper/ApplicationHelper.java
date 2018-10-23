package com.prdx.admin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.prdx.admin.constant.ConfigConstants;
import com.prdx.admin.constant.DropDownConstants;
import com.prdx.admin.constant.PortalConstants;
import com.prdx.admin.exception.PortalException;

@Component
public class ApplicationHelper {

	private static MessageSource messageSource;
	
	@Autowired
	public void initMessageSource(MessageSource msg) {
		ApplicationHelper.messageSource = msg;
	}
	
	public static String getMessage(String key, Object[] args) {
		return messageSource.getMessage(key, args, new Locale(PortalConstants.LANG_TH, PortalConstants.COUNTRY_TH));
	}
	
	public static String getMessage(String key) {
		return getMessage(key, null);
	}
	
	public static String getNewSessionKey(String sessionId) {
		String sessionKey = RandomStringUtils.randomAlphanumeric(PortalConstants.SESSION_KEY_RANDOM_LENGTH);
		sessionKey += sessionId;
		return sessionKey;
	}
	
	/*public static boolean validateSesstionTimeOut(HttpServletRequest reqServlet){
		HttpSession session = reqServlet.getSession(false);// don't create if it doesn't exist
		if(session != null && !session.isNew() && RepositoryHelper.getApplicationForm(session) != null) {
			return false;
		} else {
			if(session != null){
				session.invalidate();
			}
			return true;
		}
	}*/

	public static ModelAndView errorManual(PortalException e){
		ModelAndView modelAndView = new ModelAndView("errorMessage");
		modelAndView.addObject("ERRORCODE",e.getStatusCode());
		modelAndView.addObject("ERRORDESC",e.getStatusDesc());
		return modelAndView;
	}
	
	public static ModelAndView errorDefault(){
		ModelAndView modelAndView = new ModelAndView("errorMessage");
		String desc = getMessage("errors.default");
		//modelAndView.addObject("ERRORCODE","errors.default");
		modelAndView.addObject("ERRORDESC",desc);
		return modelAndView;
	}
	
	/*public static String getErrorMsg(String code) {
		return getErrorMsg(code, null);
	}
	
	public static String getErrorMsg(String code, String[] args) {
		String result = code;
		String msg = ErrorMsgHelper.getErrorDesc(code);
		if (StringUtils.isNotBlank(msg)) {
			if (args != null) {
				result = CommonUtil.replaceParamInMessage(msg, args);
			}
			else {
				result = msg;
			}
		}
		return result;
	}*/
	
	public static void loadImages(HttpServletRequest reqServlet, HttpServletResponse response, Logger logger) {
		loadImages(reqServlet, response, logger, null);
	}
	
	public static void loadImages(HttpServletRequest reqServlet, HttpServletResponse response, Logger logger, String id) {
		try {
			response.setContentType("image/jpeg");  
			
			Map<String, String> imageMapping = DropDownConstants.getImageMapping();
			
			//find file by imageID
			String basePath = ConfigConstants.getBaseImages();
			
			String fileName = ConfigConstants.getDefualtImages();
			if (StringUtils.isNotBlank(id) 
					&& imageMapping != null 
					&& !imageMapping.isEmpty()
					&& imageMapping.containsKey(id)) {
				fileName = imageMapping.get(id);
			}
			
			File file = new File(basePath+fileName);
			InputStream inputStream;
			try {
				if(file.exists()){
					inputStream = new FileInputStream(file);
					IOUtils.copy(inputStream, response.getOutputStream());
				    response.flushBuffer();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
	}
	
}
