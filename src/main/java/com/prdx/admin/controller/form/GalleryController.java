package com.prdx.admin.controller.form;

import java.util.ArrayList;
import java.util.List;

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
import com.prdx.admin.bean.form.GalleryJssorForm;
import com.prdx.admin.bean.form.ServicesForm;
import com.prdx.admin.service.GalleryPageService;

@RequestMapping(value = "gallery")
@Controller
public class GalleryController {

	private Logger logger = LogManager.getLogger(GalleryController.class);
	
	@Autowired
	private GalleryPageService galleryPageService;

	@RequestMapping(value = "editGalleryGroup", method = { RequestMethod.POST })
	public ModelAndView editGalleryGroup(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/editGalleryGroup");
		List<GalleryBean> galleryBeanList = new ArrayList<GalleryBean>();
		try {
			galleryBeanList = galleryPageService.getGalleryBeanList();
			modelAndView.addObject("galleryList", galleryBeanList);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "editGalleryJssor", method = { RequestMethod.POST })
	public ModelAndView editGalleryJssor(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/editGalleryJssor");
		List<GalleryBean> galleryBeanList = new ArrayList<GalleryBean>();
		try {
			galleryBeanList = galleryPageService.getGalleryBeanList();
			modelAndView.addObject("galleryList", galleryBeanList);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("galleryForm") DummyBean galleryForm, HttpServletResponse response) {
		if (galleryForm != null) {
			System.out.println(galleryForm.toString());
			for  (ServicesForm o : galleryForm.getServiceForm()) {
				System.out.println("file: "+o.getFile());
				if (o.getFile() != null) {
					System.out.println("fileName: "+o.getFileName());
					System.out.println("file size: "+o.getFile().getSize());					
				}
			}
		}
		
		else {
			System.out.println("galleryForm is null");
		}
	}
	
	@RequestMapping(value = "editGalleryJssorChangeGalleryGroup", method = { RequestMethod.POST })
	public ModelAndView editGalleryJssorChangeGalleryGroup(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("editDisplay/sub/subEditGalleryJssor");
		GallerySubJssorBean gallerySubJssorBean = new GallerySubJssorBean();
		Integer totalImage = 0;
		try {
			String topic = reqServlet.getParameter("topic");
			totalImage = galleryPageService.getTotalImageJssor(topic);
			gallerySubJssorBean = galleryPageService.getGallerySubJssorBean(topic);
			modelAndView.addObject("carouselList", gallerySubJssorBean.getCarouselList());
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "submitEditJssor", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("galleryJssorForm") GalleryJssorForm galleryJssorForm, HttpServletResponse response) {
		if (galleryJssorForm != null) {
			System.out.println(galleryJssorForm.toString());
			if (galleryJssorForm.getFileImageList() != null && !galleryJssorForm.getFileImageList().isEmpty()) {
				for  (MultipartFileForm o : galleryJssorForm.getFileImageList()) {
					System.out.println("file: "+o.getFileName());
					if (o.getFile() != null)
						System.out.println("file size: "+o.getFile().getSize());					
				}
			}
		}
		
		else {
			System.out.println("galleryForm is null");
		}
	}
}
