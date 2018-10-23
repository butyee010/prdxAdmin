package com.prdx.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdx.admin.bean.contact.HomeBean;
import com.prdx.admin.dao.HomePageDAO;
import com.prdx.admin.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService{

	@Autowired
	private HomePageDAO homePageDAO;
	
	@Override
	public HomeBean getHomePage() throws Exception {
		HomeBean homeBean = new HomeBean();
		homeBean.setCarouselList(homePageDAO.getCarouselList());
		
		homeBean.setHeaderRef1(homePageDAO.getValue("HEADER_REF_1"));
		homeBean.setContentRef1(homePageDAO.getValue("CONTENT_REF_1"));
		homeBean.setImgPathRef2(homePageDAO.getValue("IMAGE_REF_1"));
		
		homeBean.setHeaderRef3(homePageDAO.getValue("HEADER_REF_2"));
		homeBean.setContentRef3(homePageDAO.getValue("CONTENT_REF_2"));
		homeBean.setImgPathRef3(homePageDAO.getValue("IMAGE_REF_2"));
		
		return homeBean;
	}

}
