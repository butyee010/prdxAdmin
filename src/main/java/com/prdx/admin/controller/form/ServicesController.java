package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.DummyBean;
import com.prdx.admin.bean.form.ServicesForm;

@RequestMapping(value = "services")
@Controller
public class ServicesController {

	/*@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest x, @RequestParam("fileImage") MultipartFile[] file, HttpServletResponse response) {
		System.out.println("file "+file.length);
	}*/
	
	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("servicesForm") DummyBean servicesForm, HttpServletResponse response) {
		if (servicesForm != null) {
			System.out.println(servicesForm.toString());
			for  (ServicesForm o : servicesForm.getServiceForm()) {
				System.out.println("file: "+o.getFile());
				if (o.getFile() != null) {
					System.out.println("fileName: "+o.getFileName());
					System.out.println("file size: "+o.getFile().getSize());					
				}
			}
		}
		
		else {
			System.out.println("servicesForm is null");
		}
	}
	
}
