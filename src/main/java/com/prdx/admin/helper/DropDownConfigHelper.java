package com.prdx.admin.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prdx.admin.bean.PropertiesMappingBean;
import com.prdx.admin.commons.utils.CommonUtil;
import com.prdx.admin.dao.PropertyMappingDAO;

@Component
public class DropDownConfigHelper {
	private static ConcurrentMap<String, Map<String , String>> configMap = null;

	private static boolean isCheckInstance = false;

	private static String instanceName = "";

	private static PropertyMappingDAO propertyMappingDAO;
	
	@Autowired
	public void initDropDownConfigHelper(PropertyMappingDAO propertyMappingDAO) {
		DropDownConfigHelper.propertyMappingDAO = propertyMappingDAO;
	}
	
	public static void init() {
		if (instanceName != null && !"".equalsIgnoreCase(instanceName.trim())) {
			isCheckInstance = true;
		}
		List<PropertiesMappingBean> dropdownConfigList;
		try {
			dropdownConfigList = propertyMappingDAO.findAll();
			if (!CommonUtil.checkListIsNull(dropdownConfigList)) {
				configMap = new ConcurrentHashMap<String, Map<String , String>>();
				for (PropertiesMappingBean config : dropdownConfigList) {
					if (configMap.containsKey(config.getGroup())) {
						configMap.get(config.getGroup()).put(config.getKey(), config.getValue());
					}
					else {
						Map<String , String> groupMap = new HashMap<String , String>();
						groupMap.put(config.getKey(), config.getValue());
						configMap.put(config.getGroup(), groupMap);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String , String> getConfigValue(String key) {

		if (configMap == null)
			init();

		if (isCheckInstance) {
			String instanceKey = instanceName + "." + key;

			if (configMap.containsKey(instanceKey)) {
				return configMap.get(instanceKey);
			}
		}

		if (configMap.containsKey(key)) {
			return configMap.get(key);
		}

		return null;
	}

	private static Map<String , String> getConfigNotInstants(String key) {
		if (configMap.containsKey(key)) {
			return configMap.get(key);
		}
		return null;
	}

	public static synchronized void clear() {
		configMap = null;
	}

	public static void setConfigValue(String key, Map<String , String> value) {
		if (null == configMap) {
			init();
		}
		configMap.remove(key);
		configMap.put(key, value);
	}

	public static Map<String , Map<String, String>> getAllConfig() {
		return new HashMap<String, Map<String , String>>(configMap);
	}

	public static void deleteConfig(String key) {
		configMap.remove(key);
	}
	
}
