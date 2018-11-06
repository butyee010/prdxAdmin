package com.prdx.admin.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.bean.form.ServicesForm;
import com.prdx.admin.dao.ServicesPageDAO;
import com.prdx.admin.helper.PropertyConfigHelper;
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
	@Override
	public void editServicesPage(List<ServicesForm> serviceFormList) throws Exception {
		String url = PropertyConfigHelper.getConfigValue("IMAGES_URL");
		String basePath = PropertyConfigHelper.getConfigValue("BASE_IMAGES_PATH");
		String servicePath = PropertyConfigHelper.getConfigValue("SERVICES_IMAGES_PATH");
		
		servicesPageDAO.setValue("SERVICE_HEADER_PC", serviceFormList.get(0).getHeader());
		servicesPageDAO.setValue("SERVICE_CONTENT_PC", serviceFormList.get(0).getContent());
		if(serviceFormList.get(0).getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "PC.jpg" ;
			String fullUrl = url + servicePath + File.separator + "PC.jpg";
			convertFile(serviceFormList.get(0).getFile(), remotePath);
			servicesPageDAO.setValue("SERVICE_IMAGE_PC", fullUrl);
		}
		
		servicesPageDAO.setValue("SERVICE_HEADER_MERCHAND", serviceFormList.get(1).getHeader());
		servicesPageDAO.setValue("SERVICE_CONTENT_MERCHAND", serviceFormList.get(1).getContent());
		if(serviceFormList.get(1).getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "MERCHAND.jpg" ;
			String fullUrl = url + servicePath + File.separator + "MERCHAND.jpg";
			convertFile(serviceFormList.get(1).getFile(), remotePath);
			servicesPageDAO.setValue("SERVICE_IMAGE_MERCHAND", fullUrl);
		}
		
		servicesPageDAO.setValue("SERVICE_HEADER_EVENT", serviceFormList.get(2).getHeader());
		servicesPageDAO.setValue("SERVICE_CONTENT_EVENT", serviceFormList.get(2).getContent());
		if(serviceFormList.get(2).getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "EVENT.jpg" ;
			String fullUrl = url + servicePath + File.separator + "EVENT.jpg";
			convertFile(serviceFormList.get(2).getFile(), remotePath);
			servicesPageDAO.setValue("SERVICE_IMAGE_EVENT", fullUrl);
		}
		
		servicesPageDAO.setValue("SERVICE_HEADER_SHELF", serviceFormList.get(3).getHeader());
		servicesPageDAO.setValue("SERVICE_CONTENT_SHELF", serviceFormList.get(3).getContent());
		if(serviceFormList.get(3).getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "SHELF.jpg" ;
			String fullUrl = url + servicePath + File.separator + "SHELF.jpg";
			convertFile(serviceFormList.get(3).getFile(), remotePath);
			servicesPageDAO.setValue("SERVICE_IMAGE_SHELF", fullUrl);
		}
		
		servicesPageDAO.setValue("SERVICE_HEADER_APP", serviceFormList.get(4).getHeader());
		servicesPageDAO.setValue("SERVICE_CONTENT_APP", serviceFormList.get(4).getContent());
		if(serviceFormList.get(4).getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "APP.jpg" ;
			String fullUrl = url + servicePath + File.separator + "APP.jpg";
			convertFile(serviceFormList.get(4).getFile(), remotePath);
			servicesPageDAO.setValue("SERVICE_IMAGE_APP", fullUrl);
		}
		
		servicesPageDAO.setValue("SERVICE_HEADER_PUNGUN", serviceFormList.get(5).getHeader());
		servicesPageDAO.setValue("SERVICE_CONTENT_PUNGUN", serviceFormList.get(5).getContent());
		if(serviceFormList.get(5).getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "PUNGUN.jpg" ;
			String fullUrl = url + servicePath + File.separator + "PUNGUN.jpg";
			convertFile(serviceFormList.get(5).getFile(), remotePath);
			servicesPageDAO.setValue("SERVICE_IMAGE_PUNGUN", fullUrl);
		}
	}
	private File convertFile(MultipartFile file, String path) throws Exception
	{    
	    File convFile = new File(path);
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}

}
