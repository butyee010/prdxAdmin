package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.form.ContactForm;

@RequestMapping(value = "contact")
@Controller
public class ContactController {

	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("contactForm") ContactForm contactForm, HttpServletResponse response) {
		if (contactForm != null) {
			System.out.println(contactForm.toString());
		}
		else {
			System.out.println("contactForm is null");
		}
	}
	
}
