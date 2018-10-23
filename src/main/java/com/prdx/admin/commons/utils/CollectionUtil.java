package com.prdx.admin.commons.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionUtil {

	public static Boolean isEmpty(List<?> list) {
		boolean isEmpty = true;
		if (list != null && !list.isEmpty())
			isEmpty = false;
		return isEmpty;
	}
	
	public static Boolean isNotEmpty(List<?> list) {
		return list != null && !list.isEmpty();
	}
	
	public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
	    List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
	    Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
	        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
	            return (o1.getKey()).compareTo(o2.getKey());
	        }
	    });
	
	    Map<K, V> result = new LinkedHashMap<K, V>();
	    for (Map.Entry<K, V> entry : list) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
	
}
