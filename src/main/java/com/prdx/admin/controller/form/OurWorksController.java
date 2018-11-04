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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.prdx.admin.bean.DummyBean;
import com.prdx.admin.bean.MultipartFileForm;
import com.prdx.admin.bean.contact.ItemSubOurWorks;
import com.prdx.admin.bean.contact.OurWorksSubBean;
import com.prdx.admin.bean.contact.OurWorksSubJssorBean;
import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.bean.form.OurWorksForm;
import com.prdx.admin.bean.form.OurWorksJssorForm;
import com.prdx.admin.bean.form.OurWorksSubGroupForm;
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
	
	@RequestMapping(value = "submitEditOurWorksGroup", method = { RequestMethod.POST })
	public void submitEditOurWorksGroup(HttpServletRequest request, @ModelAttribute("ourWorksForm") DummyBean ourWorksForm, HttpServletResponse response) {
		if (ourWorksForm != null) {
			System.out.println(ourWorksForm.toString());
			for  (OurWorksForm o : ourWorksForm.getOurWorksForm()) {
				System.out.println("file: "+o.getFile());
				if (o.getFile() != null) {
					System.out.println("fileName: "+o.getFileName());
					System.out.println("file size: "+o.getFile().getSize());					
				}
			}
		}
		else {
			System.out.println("ourWorksForm is null");
		}
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
	
	//change group
	@RequestMapping(value = "changeOurWorksSubGroup", method = { RequestMethod.POST })
	public ModelAndView changeOurWorksSubGroup(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/sub/subEditOurWorksSubGroup");
		OurWorksSubBean ourWorksSubBean = new OurWorksSubBean();
		try {
			String topic = reqServlet.getParameter("topic");
			ourWorksSubBean = ourWorksPageService.getOurWorksSubBean(topic);
			modelAndView.addObject("ourWorksSubBean", ourWorksSubBean);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "submitEditOurWorksSubGroup", method = { RequestMethod.POST })
	public void submitEditOurWorksSubGroup(HttpServletRequest request, @ModelAttribute("ourWorksSubGroupForm") OurWorksSubGroupForm ourWorksSubGroupForm, HttpServletResponse response) {
		if (ourWorksSubGroupForm != null) {
			System.out.println(ourWorksSubGroupForm.toString());
			if (ourWorksSubGroupForm.getFileImageList() != null && !ourWorksSubGroupForm.getFileImageList().isEmpty()) {
				for  (MultipartFileForm o : ourWorksSubGroupForm.getFileImageList()) {
					System.out.println("file: "+o.getFileName());
					if (o.getFile() != null)
						System.out.println("file size: "+o.getFile().getSize());					
				}
			}
		}
		
		else {
			System.out.println("ourWorksSubGroupForm is null");
		}
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
	
 	@RequestMapping(value = "changeOurWorksJssorGroup", method = { RequestMethod.POST })
	public @ResponseBody Map<String, ItemSubOurWorks> changeOurWorksJssorGroup(HttpServletRequest reqServlet) {
		OurWorksSubBean ourWorksSubBean = new OurWorksSubBean();
		try {
			String topic = reqServlet.getParameter("topic");
			ourWorksSubBean = ourWorksPageService.getOurWorksSubBean(topic);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return ourWorksSubBean.getItemSubOurWorksMap();
	}
	
	@RequestMapping(value = "changeOurWorksJssorSubGroup", method = { RequestMethod.POST })
	public ModelAndView changeOurWorksSpecificSubGroup(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/sub/subEditOurWorksSubGroup");
		OurWorksSubJssorBean ourWorksSubJssorBean = new OurWorksSubJssorBean();
		try {
			String serviceName = reqServlet.getParameter("serviceName");
			String topic = reqServlet.getParameter("topic");
			ourWorksSubJssorBean = ourWorksPageService.getOurWorksSubJssorBean(serviceName, topic);
			modelAndView.addObject("carouselList", ourWorksSubJssorBean.getCarouselList());
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "submitEditOurWorksJssor", method = { RequestMethod.POST })
	public void submitEditOurWorksJssor(HttpServletRequest request, @ModelAttribute("ourWorksJssorForm") OurWorksJssorForm ourWorksJssorForm, HttpServletResponse response) {
		if (ourWorksJssorForm != null) {
			System.out.println(ourWorksJssorForm.toString());
			if (ourWorksJssorForm.getFileImageList() != null && !ourWorksJssorForm.getFileImageList().isEmpty()) {
				for  (MultipartFileForm o : ourWorksJssorForm.getFileImageList()) {
					System.out.println("file: "+o.getFileName());
					if (o.getFile() != null)
						System.out.println("file size: "+o.getFile().getSize());					
				}
			}
		}
		
		else {
			System.out.println("ourWorksJssorForm is null");
		}
	}
}
