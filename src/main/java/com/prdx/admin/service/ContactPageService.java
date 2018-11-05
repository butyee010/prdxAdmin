package com.prdx.admin.service;

import com.prdx.admin.bean.contact.ContactBean;
import com.prdx.admin.bean.form.ContactForm;

public interface ContactPageService {

	public ContactBean getContactPage()throws Exception;

	public void editContactPage(ContactForm contactForm)throws Exception;

}
