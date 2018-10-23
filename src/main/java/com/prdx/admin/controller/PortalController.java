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
import org.springframework.web.servlet.view.RedirectView;

import com.prdx.admin.bean.contact.AboutBean;
import com.prdx.admin.bean.contact.ContactBean;
import com.prdx.admin.bean.contact.FooterBean;
import com.prdx.admin.bean.contact.GalleryBean;
import com.prdx.admin.bean.contact.GallerySubBean;
import com.prdx.admin.bean.contact.GallerySubJssorBean;
import com.prdx.admin.bean.contact.HomeBean;
import com.prdx.admin.bean.contact.MainBean;
import com.prdx.admin.bean.contact.OurWorksSubBean;
import com.prdx.admin.bean.contact.OurWorksSubJssorBean;
import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.constant.ConfigConstants;
import com.prdx.admin.helper.MenuListHelper;
import com.prdx.admin.service.AboutPageService;
import com.prdx.admin.service.ContactPageService;
import com.prdx.admin.service.GalleryPageService;
import com.prdx.admin.service.HomePageService;
import com.prdx.admin.service.OurWorksPageService;
import com.prdx.admin.service.ServicesPageService;

@Controller
public class PortalController {

	public static final String PAGE_MAIN = "main";
	public static final String PAGE_HOME = "home";
	public static final String PAGE_ABOUT = "about";
	public static final String PAGE_CONTACT = "contact";
	public static final String PAGE_SERVICES = "services";

	public static final String PAGE_GALLERY = "gallery";
	public static final String PAGE_SUB_GALLERY = "sub_gallery";
	public static final String PAGE_JSSOR_SUB_GALLERY = "jssor_sub_gallery";

	public static final String PAGE_OUR_WORKS = "ourWorks";
	public static final String PAGE_SUB_OUR_WORKS = "sub_our_works";
	public static final String PAGE_JSSOR_SUB_OUR_WORKS = "jssor_sub_our_works";

	private Logger logger = LogManager.getLogger(PortalController.class);
	
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(new RedirectView(PAGE_MAIN));
		return modelAndView;
	}

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView(PAGE_MAIN);
		MainBean mainBean = new MainBean();
		FooterBean footerBean = new FooterBean();
		try {
			//main service
			mainBean.setMenuList(MenuListHelper.findAll());
			
			footerBean.setLabelLeft(ConfigConstants.getFooterLabelLeft());
			footerBean.setLabelRight(ConfigConstants.getFooterLabelRight());
			footerBean.setCenterRef1(ConfigConstants.getFooterCenterRef1());
			footerBean.setCenterRef2(ConfigConstants.getFooterCenterRef2());
			
			modelAndView.addObject("menuList", mainBean.getMenuList());
			modelAndView.addObject("footerBean", footerBean);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}

	@RequestMapping(value = "home", method = { RequestMethod.POST })
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

	@RequestMapping(value = "about", method = { RequestMethod.POST })
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

	@RequestMapping(value = "contact", method = { RequestMethod.POST })
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

	@RequestMapping(value = "gallery", method = { RequestMethod.POST })
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

	@RequestMapping(value = "gallery/sub", method = { RequestMethod.POST })
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
	}

	@RequestMapping(value = "gallery/sub/jssor", method = { RequestMethod.POST })
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
	}

	@RequestMapping(value = "ourWorks", method = { RequestMethod.POST })
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

	@RequestMapping(value = "ourWorks/sub", method = { RequestMethod.POST })
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

	@RequestMapping(value = "ourWorks/sub/jssor", method = { RequestMethod.POST })
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
	}

	@RequestMapping(value = "services", method = { RequestMethod.POST })
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
	
	
	//FOR TEST
	/*@RequestMapping(value = "test", method = { RequestMethod.GET })
	public ModelAndView test(HttpServletRequest reqServlet) {
		ModelAndView modelAndView = new ModelAndView("test");
		try {

		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return modelAndView;
	}*/
	
	
	/*@RequestMapping(value = "image/**", method = { RequestMethod.GET, RequestMethod.POST })
	public void loadImageAll(HttpServletRequest reqServlet, HttpServletResponse response) {
		try {
			ApplicationHelper.loadImages(reqServlet, response, logger);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
	}
	
	@RequestMapping(value = "image/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public void loadImageByKey(HttpServletRequest reqServlet, HttpServletResponse response, @PathVariable("id") String id) {
		try {
			ApplicationHelper.loadImages(reqServlet, response, logger , id);
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
	}
*/
}
