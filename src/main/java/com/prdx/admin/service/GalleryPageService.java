package com.prdx.admin.service;

import java.util.List;

import com.prdx.admin.bean.contact.GalleryBean;
import com.prdx.admin.bean.contact.GallerySubBean;
import com.prdx.admin.bean.contact.GallerySubJssorBean;

public interface GalleryPageService {

	public List<GalleryBean> getGalleryBeanList() throws Exception;

	public GallerySubBean getGallerySubBean(String topic) throws Exception;

	public GallerySubJssorBean getGallerySubJssorBean(String topic) throws Exception;

	public Integer getTotalImageJssor(String topic)throws Exception;

}
