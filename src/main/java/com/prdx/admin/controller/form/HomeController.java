package com.prdx.admin.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prdx.admin.bean.MultipartFileForm;
import com.prdx.admin.bean.form.HomeForm;
import com.prdx.admin.commons.utils.CollectionUtil;

@RequestMapping(value = "home")
@Controller
public class HomeController {

	@RequestMapping(value = "submitEdit", method = { RequestMethod.POST })
	public void submitEditServices(HttpServletRequest request, @ModelAttribute("homeForm") HomeForm homeForm, HttpServletResponse response) {
		if (homeForm != null) {
			System.out.println(homeForm.toString());
			if (CollectionUtil.isNotEmpty(homeForm.getImageRef1List())) {
				for  (MultipartFileForm o : homeForm.getImageRef1List()) {
					System.out.println("file: "+o.getFile());
					if (o.getFile() != null) {
						System.out.println("fileName: "+o.getFileName());
						System.out.println("file size: "+o.getFile().getSize());					
					}
				}
			}
		}
		
		else {
			System.out.println("servicesForm is null");
		}
	}
	
}
