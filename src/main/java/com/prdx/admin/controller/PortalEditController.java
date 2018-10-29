package com.prdx.admin.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prdx.admin.bean.contact.AboutBean;
import com.prdx.admin.bean.contact.ContactBean;
import com.prdx.admin.bean.contact.GalleryBean;
import com.prdx.admin.bean.contact.HomeBean;
import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.service.AboutPageService;
import com.prdx.admin.service.ContactPageService;
import com.prdx.admin.service.GalleryPageService;
import com.prdx.admin.service.HomePageService;
import com.prdx.admin.service.OurWorksPageService;
import com.prdx.admin.service.ServicesPageService;

@RequestMapping(value = "edit")
@Controller
public class PortalEditController {

	public static final String PAGE_HOME = "editDisplay/editHome";
	public static final String PAGE_ABOUT = "editDisplay/editAbout";
	public static final String PAGE_CONTACT = "editDisplay/editContact";
	public static final String PAGE_SERVICES = "editDisplay/editServices";

	public static final String PAGE_GALLERY = "editDisplay/editGallery";
	public static final String PAGE_SUB_GALLERY = "sub_gallery";
	public static final String PAGE_JSSOR_SUB_GALLERY = "jssor_sub_gallery";

	public static final String PAGE_OUR_WORKS = "editDisplay/editOurWorks";
	public static final String PAGE_SUB_OUR_WORKS = "sub_our_works";
	public static final String PAGE_JSSOR_SUB_OUR_WORKS = "jssor_sub_our_works";

	private Logger logger = LogManager.getLogger(PortalEditController.class);
	
	@Autowired
	private AboutPageService aboutPageService;
	@Autowired
	private HomePageService homePageService;
	@Autowired
	private ContactPageService contactPageService;
	@Autowired
	private ServicesPageService servicesPageService;
	@Autowired
	private GalleryPageService galleryPageService;
	@Autowired
	private OurWorksPageService ourWorksPageService;

	@RequestMapping(value = "editHome", method = { RequestMethod.POST })
	public ModelAndView home(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_HOME);
		HomeBean homeBean = new HomeBean();
		try {
			homeBean = homePageService.getHomePage();
			modelAndView.addObject("homeBean", homeBean);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		
		return modelAndView;
	}

	@RequestMapping(value = "editAbout", method = { RequestMethod.POST })
	public ModelAndView about(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_ABOUT);
		AboutBean aboutBean = new AboutBean();
		try {
			aboutBean = aboutPageService.getAboutPage();
			modelAndView.addObject("aboutBean", aboutBean);
		} 
		catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}

	@RequestMapping(value = "editContact", method = { RequestMethod.POST })
	public ModelAndView contact(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_CONTACT);
		ContactBean contactBean = new ContactBean();
		try {
			contactBean = contactPageService.getContactPage();
			modelAndView.addObject("contactBean", contactBean);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}

	@RequestMapping(value = "editGallery", method = { RequestMethod.POST })
	public ModelAndView gallery(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_GALLERY);
		List<GalleryBean> galleryBeanList = new ArrayList<GalleryBean>();
		try {
			galleryBeanList = galleryPageService.getGalleryBeanList();
			modelAndView.addObject("galleryList", galleryBeanList);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}

	/*@RequestMapping(value = "gallery/sub", method = { RequestMethod.POST })
	public ModelAndView subGallery(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_SUB_GALLERY);
		GallerySubBean gallerySubBean = new GallerySubBean();
		String topic = "GallerySubBean.header";
		try {
			gallerySubBean = galleryPageService.getGallerySubBean(topic);
			modelAndView.addObject("gallerySubBean", gallerySubBean);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}*/

	/*@RequestMapping(value = "gallery/sub/jssor", method = { RequestMethod.POST })
	public ModelAndView jssorSubGallery(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_JSSOR_SUB_GALLERY);
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
	}*/

	@RequestMapping(value = "editOurWorks", method = { RequestMethod.POST })
	public ModelAndView ourWorks(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_OUR_WORKS);
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

	/*@RequestMapping(value = "ourWorks/sub", method = { RequestMethod.POST })
	public ModelAndView subOurWorks(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_SUB_OUR_WORKS);
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
*/
	/*@RequestMapping(value = "ourWorks/sub/jssor", method = { RequestMethod.POST })
	public ModelAndView jssorSubOurWorks(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_JSSOR_SUB_OUR_WORKS);
		OurWorksSubJssorBean ourWorksSubJssorBean = new OurWorksSubJssorBean();
		Integer totalImage = 0;
		try {
			String serviceName = reqServlet.getParameter("serviceName");
			String topic = reqServlet.getParameter("topic");
			ourWorksSubJssorBean = ourWorksPageService.getOurWorksSubJssorBean(serviceName, topic);
			totalImage = ourWorksPageService.getTotalImageJssorSubOurWorks(serviceName, topic);
			modelAndView.addObject("carouselList", ourWorksSubJssorBean.getCarouselList());
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}*/

	@RequestMapping(value = "editServices", method = { RequestMethod.POST })
	public ModelAndView services(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_SERVICES);
		List<ServicesBean> servicesBeanList = new ArrayList<ServicesBean>();
		try {
			servicesBeanList = servicesPageService.getAllServices();
			modelAndView.addObject("serviceList", servicesBeanList);

		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}
	
}
