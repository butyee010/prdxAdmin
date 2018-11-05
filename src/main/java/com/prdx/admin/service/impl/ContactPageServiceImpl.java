package com.prdx.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdx.admin.bean.contact.ContactBean;
import com.prdx.admin.bean.form.ContactForm;
import com.prdx.admin.dao.ContactPageDAO;
import com.prdx.admin.service.ContactPageService;

@Service
public class ContactPageServiceImpl implements ContactPageService{
	
	@Autowired
	private ContactPageDAO contactPageDAO;

	@Override
	public ContactBean getContactPage() throws Exception {
		ContactBean contactBean = new ContactBean();
		contactBean.setAddress(contactPageDAO.getValue("ADDRESS"));
		contactBean.setDirectLargeMapUrl(contactPageDAO.getValue("DIRECT_LARGE_MAP_URL"));
		contactBean.setDirectUrl(contactPageDAO.getValue("DIRECT_URL"));
		contactBean.setEmail(contactPageDAO.getValue("EMAIL"));
		contactBean.setLatitude(contactPageDAO.getValue("LATITUDE"));
		contactBean.setLongitude(contactPageDAO.getValue("LONGITUDE"));
		contactBean.setLocationInfo(contactPageDAO.getValue("COMPANY_INFO"));
		contactBean.setLocationName(contactPageDAO.getValue("COMPANY_NAME"));
		contactBean.setTel(contactPageDAO.getValue("PHONE"));
		return contactBean;
	}

	@Override
	public void editContactPage(ContactForm contactForm) throws Exception {
		contactPageDAO.setValue("ADDRESS", contactForm.getAddress());
		contactPageDAO.setValue("DIRECT_LARGE_MAP_URL", contactForm.getDirectLargeMapUrl());
		contactPageDAO.setValue("DIRECT_URL", contactForm.getDirectUrl());
		contactPageDAO.setValue("EMAIL", contactForm.getEmail());
		contactPageDAO.setValue("LATITUDE", contactForm.getLatitude());
		contactPageDAO.setValue("LONGITUDE", contactForm.getLongitude());
		contactPageDAO.setValue("COMPANY_INFO", contactForm.getLocationInfo());
		contactPageDAO.setValue("COMPANY_NAME", contactForm.getLocationName());
		contactPageDAO.setValue("PHONE", contactForm.getTel());
	}

}
