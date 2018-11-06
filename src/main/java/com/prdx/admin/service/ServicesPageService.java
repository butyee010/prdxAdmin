package com.prdx.admin.service;

import java.util.List;

import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.bean.form.ServicesForm;

public interface ServicesPageService {

	public List<ServicesBean> getAllServices()throws Exception;

	public void editServicesPage(List<ServicesForm> serviceForm)throws Exception;

}
