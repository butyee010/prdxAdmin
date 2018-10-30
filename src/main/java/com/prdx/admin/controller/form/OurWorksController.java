package com.prdx.admin.controller.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prdx.admin.bean.DummyBean;
import com.prdx.admin.bean.MultipartFileForm;
import com.prdx.admin.bean.contact.GalleryBean;
import com.prdx.admin.bean.contact.GallerySubJssorBean;
import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.bean.form.GalleryJssorForm;
import com.prdx.admin.bean.form.ServicesForm;
import com.prdx.admin.service.GalleryPageService;
import com.prdx.admin.service.OurWorksPageService;
import com.prdx.admin.service.ServicesPageService;

@RequestMapping(value = "ourWorks")
@Controller
public class OurWorksController {

	private Logger logger = LogManager.getLogger(OurWorksController.class);
	
	@Autowired
	private OurWorksPageService ourWorksPageService;
	
	@Autowired
	private ServicesPageService servicesPageService;

	@RequestMapping(value = "editOurWorksGroup", method = { RequestMethod.POST })
	public ModelAndView editOurWorksGroup(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/editOurWorksGroup");
		List<ServicesBean> servicesBeanList = new ArrayList<ServicesBean>();
		try {
			servicesBeanList = servicesPageService.getAllServices();
			Map<String, List<ServicesBean>> ourWorksMap = ourWorksPageService.customizeOurworksDisplay(servicesBeanList);
			modelAndView.addObject("ourWorksMap", ourWorksMap);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "editOurWorksSubGroup", method = { RequestMethod.POST })
	public ModelAndView editOurWorksSubGroup(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/editOurWorksSubGroup");
		List<ServicesBean> servicesBeanList = new ArrayList<ServicesBean>();
		try {
			servicesBeanList = servicesPageService.getAllServices();
			Map<String, List<ServicesBean>> ourWorksMap = ourWorksPageService.customizeOurworksDisplay(servicesBeanList);
			modelAndView.addObject("ourWorksMap", ourWorksMap);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "editOurWorksJssor", method = { RequestMethod.POST })
	public ModelAndView editOurWorksJssor(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/editOurWorksJssor");
		List<ServicesBean> servicesBeanList = new ArrayList<ServicesBean>();
		try {
			servicesBeanList = servicesPageService.getAllServices();
			Map<String, List<ServicesBean>> ourWorksMap = ourWorksPageService.customizeOurworksDisplay(servicesBeanList);
			modelAndView.addObject("ourWorksMap", ourWorksMap);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
}
