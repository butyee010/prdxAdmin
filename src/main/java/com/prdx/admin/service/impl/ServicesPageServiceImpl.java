package com.prdx.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.dao.ServicesPageDAO;
import com.prdx.admin.service.ServicesPageService;

@Service
public class ServicesPageServiceImpl implements ServicesPageService{

	@Autowired
	private ServicesPageDAO servicesPageDAO;
	@Override
	public List<ServicesBean> getAllServices() throws Exception {
		List<ServicesBean> servicesBeanList = new ArrayList<ServicesBean>();
		
		ServicesBean servicesBeanPC = new ServicesBean();
		servicesBeanPC.setHeader(servicesPageDAO.getValue("SERVICE_HEADER_PC"));
		servicesBeanPC.setContent(servicesPageDAO.getValue("SERVICE_CONTENT_PC"));
		servicesBeanPC.setImgPath(servicesPageDAO.getValue("SERVICE_IMAGE_PC"));
		servicesBeanList.add(servicesBeanPC);
		
		ServicesBean servicesBeanMer = new ServicesBean();
		servicesBeanMer.setHeader(servicesPageDAO.getValue("SERVICE_HEADER_MERCHAND"));
		servicesBeanMer.setContent(servicesPageDAO.getValue("SERVICE_CONTENT_MERCHAND"));
		servicesBeanMer.setImgPath(servicesPageDAO.getValue("SERVICE_IMAGE_MERCHAND"));
		servicesBeanList.add(servicesBeanMer);
		
		ServicesBean servicesBeanEvent = new ServicesBean();
		servicesBeanEvent.setHeader(servicesPageDAO.getValue("SERVICE_HEADER_EVENT"));
		servicesBeanEvent.setContent(servicesPageDAO.getValue("SERVICE_CONTENT_EVENT"));
		servicesBeanEvent.setImgPath(servicesPageDAO.getValue("SERVICE_IMAGE_EVENT"));
		servicesBeanList.add(servicesBeanEvent);
		
		ServicesBean servicesBeanShelf = new ServicesBean();
		servicesBeanShelf.setHeader(servicesPageDAO.getValue("SERVICE_HEADER_SHELF"));
		servicesBeanShelf.setContent(servicesPageDAO.getValue("SERVICE_CONTENT_SHELF"));
		servicesBeanShelf.setImgPath(servicesPageDAO.getValue("SERVICE_IMAGE_SHELF"));
		servicesBeanList.add(servicesBeanShelf);
		
		ServicesBean servicesBeanApp = new ServicesBean();
		servicesBeanApp.setHeader(servicesPageDAO.getValue("SERVICE_HEADER_APP"));
		servicesBeanApp.setContent(servicesPageDAO.getValue("SERVICE_CONTENT_APP"));
		servicesBeanApp.setImgPath(servicesPageDAO.getValue("SERVICE_IMAGE_APP"));
		servicesBeanList.add(servicesBeanApp);
		
		ServicesBean servicesBeanPun = new ServicesBean();
		servicesBeanPun.setHeader(servicesPageDAO.getValue("SERVICE_HEADER_PUNGUN"));
		servicesBeanPun.setContent(servicesPageDAO.getValue("SERVICE_CONTENT_PUNGUN"));
		servicesBeanPun.setImgPath(servicesPageDAO.getValue("SERVICE_IMAGE_PUNGUN"));
		servicesBeanList.add(servicesBeanPun);
		
		return servicesBeanList;
	}

}
