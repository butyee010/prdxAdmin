package com.prdx.admin.helper;
/*package com.prdx.web.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktb.anyid.adjust.portal.repo.ErrorMessageRepo;
import com.ktb.anyid.adjust.share.entity.ErrorMessage;
import com.ktb.anyid.adjust.share.utils.CommonUtil;

@Component
public class ErrorMsgHelper {
	private static ConcurrentMap<String, ErrorMessage> errorMap = null;
	private static ErrorMessageRepo errorMessageRepo;
	
	@Autowired
	public void initErrorMsgHelper(ErrorMessageRepo errorMessageRepo) {
		ErrorMsgHelper.errorMessageRepo = errorMessageRepo;
	}

	public static void init() {
		List<ErrorMessage> listErrorMsg;
		try {
			listErrorMsg = (List<ErrorMessage>) errorMessageRepo.findAll();
			if (!CommonUtil.checkListIsNull(listErrorMsg)) {
				errorMap = new ConcurrentHashMap<String, ErrorMessage>();
				for (ErrorMessage errorMsg : listErrorMsg) {
					errorMap.put(errorMsg.getErrorCode().toString(), errorMsg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getErrorDesc(String key) {
		String result = null;
		if (errorMap == null)
			init();

		if (errorMap.containsKey(key)) {
			result = errorMap.get(key).getEnUs();
		}

		return result;
	}

	public static synchronized void clear() {
		errorMap = null;
	}

	public static void setConfigValue(String key, ErrorMessage value) {
		if (null == errorMap) {
			init();
		}
		errorMap.remove(key);
		errorMap.put(key, value);
	}

	public static Map<String, ErrorMessage> getAllConfig() {
		return new HashMap<String, ErrorMessage>(errorMap);
	}

	public static void deleteConfig(String key) {
		errorMap.remove(key);
	}
	
}
*/