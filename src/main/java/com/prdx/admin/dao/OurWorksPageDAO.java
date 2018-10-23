package com.prdx.admin.dao;

import java.util.List;

import com.prdx.admin.bean.contact.CarouselBean;
import com.prdx.admin.bean.contact.ItemSubOurWorks;

public interface OurWorksPageDAO {

	public List<ItemSubOurWorks> getItemSubOurWorkList(String serviceName)throws Exception;

	public List<CarouselBean> getCarouselList(String serviceName, String topic)throws Exception;

	public Integer getTotalImageJssorSubOurWorks(String serviceName, String topic)throws Exception;

}
