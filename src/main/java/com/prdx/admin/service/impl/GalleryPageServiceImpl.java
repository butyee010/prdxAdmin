package com.prdx.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdx.admin.bean.contact.GalleryBean;
import com.prdx.admin.bean.contact.GallerySubBean;
import com.prdx.admin.bean.contact.GallerySubJssorBean;
import com.prdx.admin.dao.GalleryPageDAO;
import com.prdx.admin.service.GalleryPageService;

@Service
public class GalleryPageServiceImpl implements GalleryPageService{
	
	@Autowired
	private GalleryPageDAO galleryPageDAO;

	@Override
	public List<GalleryBean> getGalleryBeanList() throws Exception {
		
		return galleryPageDAO.getGalleryBeanList();
	}

	@Override
	public GallerySubBean getGallerySubBean(String topic) throws Exception {
		GallerySubBean gallerySubBean = new GallerySubBean();
		gallerySubBean.setSubGalleryName(topic);
		gallerySubBean.setCarouselList(galleryPageDAO.getCarouselList(topic));
		
		return gallerySubBean;
	}

	@Override
	public GallerySubJssorBean getGallerySubJssorBean(String topic) throws Exception {
		GallerySubJssorBean gallerySubJssorBean = new GallerySubJssorBean();
		gallerySubJssorBean.setCarouselList(galleryPageDAO.getCarouselList(topic));
		
		return gallerySubJssorBean;
	}

	@Override
	public Integer getTotalImageJssor(String topic) throws Exception {
		
		return galleryPageDAO.getTotalImageJssor(topic);
	}

}
