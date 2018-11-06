package com.prdx.admin.dao;

import java.util.List;

import com.prdx.admin.bean.contact.CarouselBean;

public interface HomePageDAO {

	public List<CarouselBean> getCarouselList()throws Exception;
	
	public String getValue(String key)throws Exception;
	
	public void setValue(String key, String value, boolean insert)throws Exception;

}
