package com.prdx.admin.repo.builder;

import com.prdx.admin.constant.PortalConstants;

public class SqlMenuBuilder {
	
	public static String sqlGetMenuList() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT M.PADM_SEQ_ID AS menuKey, ");
		sql.append("        M.PADM_PMGS_SEQ_ID AS groupKey, ");
		sql.append("        M.PADM_PAMT_SEQ_ID AS subMenuKey, ");
		sql.append("        M.PADM_GOS_MENU_POSITION AS groupPos, ");
		sql.append("        M.PADM_TASK_MENU_POSITION AS subMenuPos, ");
		sql.append("        GS.PMGS_GROUP_NAME_EN AS groupNameEng, ");
		sql.append("        GS.PMGS_GROUP_NAME_TH AS groupNameTh, ");
		sql.append("        GS.PMGS_CSS AS groupCss, ");
		sql.append("        GS.PMGS_SCRIPT AS groupScript, ");
		sql.append("        T.PAMT_TASK_NAME_EN AS subMenuNameEn, ");
		sql.append("        T.PAMT_TASK_NAME_TH AS subMenuNameTh, ");
		sql.append("        T.PAMT_CSS AS subMenuCss, ");
		sql.append("        T.PAMT_SCRIPT AS subMenuScript ");
		sql.append(" FROM portal_admin_menu M ");
		sql.append(" LEFT JOIN portal_admin_menu_group_system GS ON GS.PMGS_SEQ_ID = M.PADM_PMGS_SEQ_ID ");
		sql.append(" LEFT JOIN portal_admin_menu_task T ON T.PAMT_SEQ_ID = M.PADM_PAMT_SEQ_ID ");
		sql.append(" WHERE M.PADM_ACTIVATE_FLAG = '"+PortalConstants.FLAG_Y+"'  ");
		sql.append(" ORDER BY M.PADM_GOS_MENU_POSITION , M.PADM_TASK_MENU_POSITION ");
		return sql.toString();
	}
	
}
