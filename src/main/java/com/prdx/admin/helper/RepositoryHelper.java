package com.prdx.admin.helper;
/*package com.prdx.web.helper;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ktb.anyid.adjust.portal.bean.AdjustCbsFileHistBean;
import com.ktb.anyid.adjust.portal.bean.UserInfo;
import com.ktb.anyid.adjust.portal.bean.form.UnMatchedFileTxnHistoryForm;

public class RepositoryHelper {
	
	enum key {
		USER_INFO, ADJUST_FILE_INFO_TXN_MAP, UNMATCHED_FILE_TXN_HISTORY_FORM, ADJUST_CBS_FILE_HIST_MAP
	}

	//--------------------------
	public static void setUserInfo(HttpSession session, UserInfo userInfo) {
		session.setAttribute(key.USER_INFO.toString(), userInfo);
	}

	public static UserInfo getUserInfo(HttpSession session) {
		return (UserInfo) session.getAttribute(key.USER_INFO.toString());
	}

	public static void removeUserInfo(HttpSession session) {
		session.removeAttribute(key.USER_INFO.toString());
	}
	
	//--------------------------
	public static void setUnMatchedFileTxnHistoryForm(HttpSession session, UnMatchedFileTxnHistoryForm form) {
		session.setAttribute(key.UNMATCHED_FILE_TXN_HISTORY_FORM.toString(), form);
	}

	public static UnMatchedFileTxnHistoryForm getUnMatchedFileTxnHistoryForm(HttpSession session) {
		return (UnMatchedFileTxnHistoryForm) session.getAttribute(key.UNMATCHED_FILE_TXN_HISTORY_FORM.toString());
	}

	public static void removeUnMatchedFileTxnHistoryForm(HttpSession session) {
		session.removeAttribute(key.UNMATCHED_FILE_TXN_HISTORY_FORM.toString());
	}
	
	//-----------------------------
	public static void setAdjustCbsFileHistMap(HttpSession session, Map<String, AdjustCbsFileHistBean> map) {
		session.setAttribute(key.ADJUST_CBS_FILE_HIST_MAP.toString(), map);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, AdjustCbsFileHistBean> getAdjustCbsFileHistMap(HttpSession session) {
		return (Map<String, AdjustCbsFileHistBean>) session.getAttribute(key.ADJUST_CBS_FILE_HIST_MAP.toString());
	}

	public static void removeAdjustCbsFileHistMap(HttpSession session) {
		session.removeAttribute(key.ADJUST_CBS_FILE_HIST_MAP.toString());
	}
	
	//-----------------------------
}
*/