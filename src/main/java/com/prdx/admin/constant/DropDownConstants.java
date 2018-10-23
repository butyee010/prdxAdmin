package com.prdx.admin.constant;

import java.util.Map;

import com.prdx.admin.helper.DropDownConfigHelper;

public class DropDownConstants {

	public static Map<String , String> getImageMapping() {
		return DropDownConfigHelper.getConfigValue("IMAGE_MAPPING");
	}
	
}
