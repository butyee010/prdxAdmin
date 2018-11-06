package com.prdx.admin.constant;

public class SQLConstants {

	public static final String SQL_GET_VALUE_ABOUT_PAGE_BY_KEY = " select AP_VALUE from about_page where AP_KEY = ? ";
	
	public static final String SQL_GET_ALL_MENU_LIST = " select menu_key AS 'key', menu_name AS name, menu_script AS script "
			+ " from menu_list order by menu_order asc ";
	
	public static final String SQL_GET_MENU_LIST_BY_KEY = " select menu_key AS key, menu_name AS name, menu_script AS script "
			+ " from menu_list where menu_key = ? ";
	
	public static final String SQL_GET_CAROUSEL_LIST = " select HP_VALUE AS imgPath from home_page "
			+ " where HP_KEY like 'SLIDE_IMAGE_%' order by HP_KEY ";
	
	public static final String SQL_GET_VALUE_HOME_PAGE_BY_KEY = " select HP_VALUE from home_page where HP_KEY = ? ";
	
	public static final String SQL_GET_VALUE_CONTACT_PAGE_BY_KEY = " select CP_VALUE from contact_page where CP_KEY = ? ";
	
	public static final String SQL_GET_VALUE_SERVICES_PAGE_BY_KEY = " select SP_VALUE from services_page where SP_KEY = ? ";
	
	public static final String SQL_GET_VALUE_PROPERTY_MAPPING = " select properties_value from properties_mapping "
			+ "where properties_key = ? and properties_group = ? ";
	
	public static final String SQL_GET_GALLERY_BEAN_LIST = " select gpm.GPM_TOPIC AS header, gpm.GPM_DESC AS content, "
			+ " (select gpd.GPD_PATH from gallery_page_detail gpd where gpd.GPD_GPM_TOPIC = gpm.GPM_TOPIC order by gpd.GPD_RECORD limit 1) imgPath "
			+ " from gallery_page_main gpm where gpm.GPM_ACT = 'A' order by gpm.GPM_DATE desc ";
	
	public static final String SQL_GET_GALLERY_SUB_BEAN_CAROUSEL = " select GPD_PATH AS imgPath from gallery_page_detail "
			+ "where GPD_GPM_TOPIC = ? order by GPD_RECORD ";
	
	public static final String SQL_GET_TOTAL_IMAGE_JSSOR_GALLERY = "select count(*) from gallery_page_detail gpd where gpd.GPD_GPM_TOPIC = ? ";
	
	
	public static final String SQL_GET_ITEM_SUB_OUR_WORK = " select owpm.OWPM_TOPIC AS topicName, owpm.OWPM_TOPIC AS header, owpm.OWPM_DESC AS content, "
			+ " (select owpd.OWPD_PATH from our_work_page_detail owpd where owpd.OWPD_OWPM_SERVICE = owpm.OWPM_SERVICE and owpd.OWPD_OWPM_TOPIC = owpm.OWPM_TOPIC order by owpd.OWPD_RECORD limit 1) imgPath  "
			+ " from our_work_page_main owpm where owpm.OWPM_SERVICE = ? ";
	
	public static final String SQL_GET_OUR_WORKS_SUB_BEAN_CAROUSEL = " select OWPD_PATH AS imgPath from our_work_page_detail "
			+ "where OWPD_OWPM_SERVICE = ? and OWPD_OWPM_TOPIC = ? order by OWPD_RECORD ";
	
	public static final String SQL_GET_TOTAL_IMAGE_JSSOR_OUR_WORK = "select count(*) from our_work_page_detail where OWPD_OWPM_SERVICE = ? and OWPD_OWPM_TOPIC = ? ";
	
	
	public static final String SQL_FIND_ALL_PROPERTIES_CONFIG = " select config_key AS 'key', config_value AS 'value' from properties_config ";

	public static final String SQL_FIND_ALL_PROPERTIES_MAPPING = " select properties_key AS 'key', properties_value AS 'value', properties_group as 'group' from properties_mapping ";

	//edit
	public static final String SQL_SET_VALUE_ABOUT_PAGE_BY_KEY = " update about_page set AP_VALUE = ? where AP_KEY = ? ";
	
	public static final String SQL_SET_VALUE_CONTACT_PAGE_BY_KEY = " update contact_page set CP_VALUE = ? where CP_KEY = ? ";
	
	public static final String SQL_SET_VALUE_SERVICES_PAGE_BY_KEY = " update services_page set SP_VALUE = ? where SP_KEY = ? ";
	
	public static final String SQL_SET_VALUE_HOME_PAGE_BY_KEY = " update home_page set HP_VALUE = ? where HP_KEY = ? ";
	
	public static final String SQL_SET_INSERT_VALUE_HOME_PAGE_BY_KEY = " insert into home_page (HP_VALUE, HP_KEY) values (?, ?) ";
}
