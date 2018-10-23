package com.prdx.admin.dao;

import java.util.List;

import com.prdx.admin.bean.contact.CarouselBean;
import com.prdx.admin.bean.contact.GalleryBean;

public interface GalleryPageDAO {

	public List<GalleryBean> getGalleryBeanList() throws Exception;

	public List<CarouselBean> getCarouselList(String topic) throws Exception;

	public Integer getTotalImageJssor(String topic)throws Exception;

}
