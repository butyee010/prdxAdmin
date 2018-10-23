package com.prdx.admin.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prdx.admin.bean.PropertiesConfigBean;
import com.prdx.admin.commons.utils.CommonUtil;
import com.prdx.admin.commons.utils.StringUtil;
import com.prdx.admin.dao.PropertiesConfigDAO;


@Component
public class PropertyConfigHelper {
	private static ConcurrentMap<String, String[]> configMap = null;

	private static boolean isCheckInstance = false;

	private static String instanceName = "";
	
	private static PropertiesConfigDAO propertiesConfigDAO;
	
	@Autowired
	public void initPropertyConfigHelper(PropertiesConfigDAO propertiesConfigDAO) {
		PropertyConfigHelper.propertiesConfigDAO = propertiesConfigDAO;
	}

	public static void init() {
		if (instanceName != null && !"".equalsIgnoreCase(instanceName.trim())) {
			isCheckInstance = true;
		}
		List<PropertiesConfigBean> propertyConfigList;
		try {
			propertyConfigList = propertiesConfigDAO.findAll();
			if (!CommonUtil.checkListIsNull(propertyConfigList)) {
				configMap = new ConcurrentHashMap<String, String[]>();
				for (PropertiesConfigBean config : propertyConfigList) {
					configMap.put(config.getKey(), StringUtil.getArrayFromFix(config.getValue()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*	public static String getSpecialConfig(String key) {
		try {
			String result = "";
			PortalAdminConfig portalAdminConfig = portalAdminConfigRepo.findOne(key);
			if (portalAdminConfig != null) {
				result = portalAdminConfig.getPamcConfigValue();
			}
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/

	public static String getConfigValue(String key) {
		if (configMap == null)
			init();

		if (isCheckInstance) {
			String instanceKey = instanceName + "." + key;

			if (configMap.containsKey(instanceKey)) {
				String[] _valList = configMap.get(instanceKey);
				if (_valList == null || _valList.length == 0) {
					return getConfigNotInstants(key);
				}
				return _valList[0];
			}
		}

		if (configMap.containsKey(key)) {
			String[] _valList = configMap.get(key);
			if (_valList == null || _valList.length == 0) {
				return null;
			}
			return _valList[0];
		}

		return null;
	}

	private static String getConfigNotInstants(String key) {
		if (configMap.containsKey(key)) {
			String[] _valList = configMap.get(key);
			if (_valList == null || _valList.length == 0) {
				return null;
			}
			return _valList[0];
		}
		return null;
	}

	public static String[] getConfigValueArray(String key) {

		if (configMap == null)
			init();

		if (isCheckInstance) {
			String instanceKey = instanceName + "." + key;
			if (configMap.containsKey(instanceKey)) {
				String[] _valList = configMap.get(instanceKey);
				if (_valList == null || _valList.length == 0) {
					return getConfigNotInstantList(key);
				}
				return _valList;
			}
		}

		if (configMap.containsKey(key)) {
			return configMap.get(key);
		}

		return null;
	}
	
	public static List<String> getConfigValueList(String key) {

		if (configMap == null)
			init();

		if (isCheckInstance) {
			String instanceKey = instanceName + "." + key;
			if (configMap.containsKey(instanceKey)) {
				String[] _valList = configMap.get(instanceKey);
				if (_valList == null || _valList.length == 0) {
					return StringUtil.convertArrayToList(getConfigNotInstantList(key));
				}
				return StringUtil.convertArrayToList(_valList);
			}
		}

		if (configMap.containsKey(key)) {
			return StringUtil.convertArrayToList(configMap.get(key));
		}

		return null;
	}

	private static String[] getConfigNotInstantList(String key) {
		if (configMap.containsKey(key)) {
			String[] _valList = configMap.get(key);
			if (_valList == null || _valList.length == 0) {
				return null;
			}
			return _valList;
		}
		return null;
	}

	public static synchronized void clear() {
		configMap = null;
	}

	public static void setConfigValue(String key, String[] value) {
		if (null == configMap) {
			init();
		}
		configMap.remove(key);
		configMap.put(key, value);
	}

	public static Map<String, String[]> getAllConfig() {
		return new HashMap<String, String[]>(configMap);
	}

	public static void deleteConfig(String key) {
		configMap.remove(key);
	}
	
}
