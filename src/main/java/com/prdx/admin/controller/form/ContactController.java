package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.form.ContactForm;
import com.prdx.admin.service.ContactPageService;

@RequestMapping(value = "contact")
@Controller
public class ContactController {
	
	@Autowired
	private ContactPageService contactPageService;

	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("contactForm") ContactForm contactForm, HttpServletResponse response) {
		try {
			if (contactForm != null) {
				contactPageService.editContactPage(contactForm);
			}
			else {
				System.out.println("contactForm is null");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
