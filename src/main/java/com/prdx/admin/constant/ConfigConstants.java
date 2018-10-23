package com.prdx.admin.constant;

import com.prdx.admin.helper.PropertyConfigHelper;

public class ConfigConstants {
	
	public static String getBaseImages() {
		return PropertyConfigHelper.getConfigValue("BASE_IMAGES");
	}
	
	public static String getFooterLabelLeft() {
		return PropertyConfigHelper.getConfigValue("FOOTER_LABEL_LEFT");
	}
	
	public static String getFooterLabelRight() {
		return PropertyConfigHelper.getConfigValue("FOOTER_LABEL_RIGHT");
	}
	
	public static String getFooterCenterRef1() {
		return PropertyConfigHelper.getConfigValue("FOOTER_CENTER_REF_1");
	}
	
	public static String getFooterCenterRef2() {
		return PropertyConfigHelper.getConfigValue("FOOTER_CENTER_REF_2");
	}
	
	public static String getDefualtImages() {
		return PropertyConfigHelper.getConfigValue("DEFUALT_IMAGES");
	}
}
