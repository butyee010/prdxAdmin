package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.form.AboutForm;

@RequestMapping(value = "about")
@Controller
public class AboutController {

	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("aboutForm") AboutForm aboutForm, HttpServletResponse response) {
		if (aboutForm != null) {
			System.out.println(aboutForm.toString());
		}
		else {
			System.out.println("aboutForm is null");
		}
	}
	
}
