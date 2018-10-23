package com.prdx.admin.bean.contact;

import java.util.LinkedHashMap;
import java.util.Map;

import com.prdx.admin.constant.PortalConstants;

import lombok.Data;

@Data
public class OurWorksSubBean {
	
	public String ourWorksName = PortalConstants.OUR_WORKS;
	public String subOurWorksName;
	
	public Map<String, ItemSubOurWorks> itemSubOurWorksMap = new LinkedHashMap<>();
}