package com.prdx.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prdx.admin.constant.PortalConstants;
import com.prdx.admin.helper.DropDownConfigHelper;
import com.prdx.admin.helper.PropertyConfigHelper;

@Controller
@RequestMapping("/reload")
public class ClearConfigController {

	private Logger logger = LogManager.getLogger(PortalController.class);


	@RequestMapping(value = "config", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String reloadConfig(HttpServletRequest reqServlet) throws Exception {
		String response = "<div style='color: red;'>"+"Reload Config: "+PortalConstants.FAILED+"</div>";
		try {
			logger.info("ReloadConfig start");
			//Clear
			PropertyConfigHelper.clear();
			DropDownConfigHelper.clear();
			
			//Reload
			PropertyConfigHelper.init();
			DropDownConfigHelper.init();
			
			response = "<div style='color: green;'>"+"Reload Config: "+PortalConstants.SUCCESS+"</div>";
			logger.info("ReloadConfig Success");
		}
		catch (Exception e) {
			logger.error("ReloadConfig Exception", e);
		}
		return response;
	}
}
