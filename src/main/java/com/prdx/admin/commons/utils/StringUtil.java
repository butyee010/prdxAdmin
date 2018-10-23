package com.prdx.admin.commons.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	public static List<String> getListFromFix(String fix) {
		List<String> respList = new ArrayList<String>();

		if (StringUtils.isBlank(fix))
			return respList;

		if (fix.startsWith("[") && fix.endsWith("]")) {
			fix = new String(fix.substring(1, fix.length() - 1));

			String tmpList[] = fix.split(",");
			for (String tmp : tmpList) {
				if (StringUtils.isBlank(tmp))
					continue;

				tmp = tmp.trim();

				respList.add(tmp);
			}

			return respList;
		} else {
			respList.add(fix);
			return respList;
		}
	}

	public static String[] getArrayFromFix(String fix) {
		if (StringUtils.isBlank(fix))
			return new String[] { "" };

		if (fix.startsWith("[") && fix.endsWith("]")) {
			fix = new String(fix.substring(1, fix.length() - 1));

			String tmpList[] = fix.split(",");
			List<String> respList = new ArrayList<String>();
			for (String tmp : tmpList) {
				if (StringUtils.isBlank(tmp))
					continue;
				tmp = CommonUtil.ltrim(tmp);
				tmp = CommonUtil.rtrim(tmp);

				respList.add(tmp);
			}

			return respList.toArray(new String[respList.size()]);
		} else {
			return new String[] { fix };
		}
	}
	
	public static String defaultText(String text) {
		return StringUtils.isNotBlank(text) ? text : "-";
	}
	
	public static String decodeUrl(String text, String encoding) {
		try {
			if (StringUtils.isNotBlank(text))
				text = URLDecoder.decode(text, encoding);
		} catch (UnsupportedEncodingException e) {
			//unimplement
			//e.printStackTrace();
		}
		return text;
	}
	
	public static List<String> convertArrayToList(String[] strArray) {
		List<String> strList = new ArrayList<String>();
		if (strArray != null) {
			strList = Arrays.asList(strArray); 
		}
		return strList;
	}
	
	
}
