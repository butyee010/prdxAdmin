package com.prdx.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prdx.admin.bean.contact.ItemSubOurWorks;
import com.prdx.admin.bean.contact.OurWorksSubBean;
import com.prdx.admin.bean.contact.OurWorksSubJssorBean;
import com.prdx.admin.bean.contact.ServicesBean;
import com.prdx.admin.commons.utils.CollectionUtil;
import com.prdx.admin.dao.OurWorksPageDAO;
import com.prdx.admin.service.OurWorksPageService;

@Service
public class OurWorksPageServiceImpl implements OurWorksPageService{
	@Autowired
	private OurWorksPageDAO ourWorksPageDAO;

	@Override
	public OurWorksSubBean getOurWorksSubBean(String serviceName) throws Exception {
		OurWorksSubBean ourWorksSubBean = new OurWorksSubBean();
		ourWorksSubBean.setSubOurWorksName(serviceName);
		
		Map<String, ItemSubOurWorks> itemSubOurWorksMap = new HashMap<String, ItemSubOurWorks>();
		List<ItemSubOurWorks> itemSubOurWorkList = ourWorksPageDAO.getItemSubOurWorkList(serviceName);
		if(itemSubOurWorkList != null && itemSubOurWorkList.size() > 0) 
		{
			for (ItemSubOurWorks itemSubOurWorks : itemSubOurWorkList) {
				itemSubOurWorksMap.put(itemSubOurWorks.getTopicName(), itemSubOurWorks);
			}
		}
		ourWorksSubBean.setItemSubOurWorksMap(itemSubOurWorksMap);
		
		return ourWorksSubBean;
	}

	@Override
	public OurWorksSubJssorBean getOurWorksSubJssorBean(String serviceName, String topic) throws Exception {
		OurWorksSubJssorBean ourWorksSubJssorBean = new OurWorksSubJssorBean();
		ourWorksSubJssorBean.setCarouselList(ourWorksPageDAO.getCarouselList(serviceName, topic));
		
		return ourWorksSubJssorBean;
	}

	@Override
	public Integer getTotalImageJssorSubOurWorks(String serviceName, String topic) throws Exception {
		return ourWorksPageDAO.getTotalImageJssorSubOurWorks(serviceName, topic);
	}
	
	@Override
	public Map<String, List<ServicesBean>> customizeOurworksDisplay(List<ServicesBean> servicesBeanList) {
		Map<String, List<ServicesBean>> servicesBeanMap = new LinkedHashMap<String, List<ServicesBean>>();
		if (CollectionUtil.isNotEmpty(servicesBeanList)) {
			int row = 1;
			List<ServicesBean> itemList = new ArrayList<>();
			itemList.add(servicesBeanList.get(0));
			for (int i=1; i<servicesBeanList.size(); i++) {
				
				if (i % 3 == 0) {
					servicesBeanMap.put(String.valueOf(row++), itemList);
					itemList = new ArrayList<>();
				}
				
				itemList.add(servicesBeanList.get(i));
				
				if (CollectionUtil.isNotEmpty(itemList) && i == (servicesBeanList.size() - 1)) 
					servicesBeanMap.put(String.valueOf(row++), itemList);
			}
		}
		return servicesBeanMap;
	}

}
