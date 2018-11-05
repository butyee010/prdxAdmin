package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.form.AboutForm;
import com.prdx.admin.service.AboutPageService;

@RequestMapping(value = "about")
@Controller
public class AboutController {
	
	@Autowired
	private AboutPageService aboutPageService;

	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("aboutForm") AboutForm aboutForm, HttpServletResponse response) {
		try {
			if (aboutForm != null) {
				aboutPageService.editAboutPage(aboutForm);
			}
			else {
				System.out.println("aboutForm is null");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
