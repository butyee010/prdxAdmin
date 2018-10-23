package com.prdx.admin.service;

import java.util.List;
import java.util.Map;

import com.prdx.admin.bean.contact.OurWorksSubBean;
import com.prdx.admin.bean.contact.OurWorksSubJssorBean;
import com.prdx.admin.bean.contact.ServicesBean;

public interface OurWorksPageService {

	public OurWorksSubBean getOurWorksSubBean(String serviceName) throws Exception;

	public OurWorksSubJssorBean getOurWorksSubJssorBean(String serviceName, String topic) throws Exception;

	public Integer getTotalImageJssorSubOurWorks(String serviceName, String topic)throws Exception;

	public Map<String, List<ServicesBean>> customizeOurworksDisplay(List<ServicesBean> servicesBeanList);

}
