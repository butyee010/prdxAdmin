package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.MultipartFileForm;
import com.prdx.admin.bean.form.HomeForm;
import com.prdx.admin.commons.utils.CollectionUtil;
import com.prdx.admin.service.HomePageService;

@RequestMapping(value = "home")
@Controller
public class HomeController {
	
	@Autowired
	private HomePageService homePageService;

	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("homeForm") HomeForm homeForm, HttpServletResponse response) {
		try{
			if (homeForm != null) {
				homePageService.editHomePage(homeForm);
			}
			else {
				System.out.println("homeForm is null");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
