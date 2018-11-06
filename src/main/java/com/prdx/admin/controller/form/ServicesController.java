package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.DummyBean;
import com.prdx.admin.bean.form.ServicesForm;
import com.prdx.admin.service.ServicesPageService;

@RequestMapping(value = "services")
@Controller
public class ServicesController {

	/*@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest x, @RequestParam("fileImage") MultipartFile[] file, HttpServletResponse response) {
		System.out.println("file "+file.length);
	}*/
	
	@Autowired
	private ServicesPageService servicesPageService;
	
	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("servicesForm") DummyBean servicesForm, HttpServletResponse response) {
		try {
			if (servicesForm != null) {
				if(servicesForm.getServiceForm() != null) {
					servicesPageService.editServicesPage(servicesForm.getServiceForm());
				}else {
					System.out.println("servicesForm.getServiceForm() is null");
				}
			}
			else {
				System.out.println("servicesForm is null");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
