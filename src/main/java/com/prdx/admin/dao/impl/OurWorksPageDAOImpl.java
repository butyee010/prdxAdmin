package com.prdx.admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prdx.admin.bean.contact.CarouselBean;
import com.prdx.admin.bean.contact.ItemSubOurWorks;
import com.prdx.admin.constant.SQLConstants;
import com.prdx.admin.dao.OurWorksPageDAO;

@Repository
public class OurWorksPageDAOImpl implements OurWorksPageDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ItemSubOurWorks> getItemSubOurWorkList(String serviceName) throws Exception {
		String sql = SQLConstants.SQL_GET_ITEM_SUB_OUR_WORK;
		List<ItemSubOurWorks> result = jdbcTemplate.query(sql, new Object[]{serviceName}, new BeanPropertyRowMapper<ItemSubOurWorks>(ItemSubOurWorks.class));
		
		return result;
	}

	@Override
	public List<CarouselBean> getCarouselList(String serviceName, String topic) throws Exception {
		String sql = SQLConstants.SQL_GET_OUR_WORKS_SUB_BEAN_CAROUSEL;
		List<CarouselBean> result = jdbcTemplate.query(sql, new Object[]{serviceName, topic}, new BeanPropertyRowMapper<CarouselBean>(CarouselBean.class));
		return result;
	}

	@Override
	public Integer getTotalImageJssorSubOurWorks(String serviceName, String topic) throws Exception {
		String sql = SQLConstants.SQL_GET_TOTAL_IMAGE_JSSOR_OUR_WORK;
		Integer result = 0;
		List<Integer> temp = jdbcTemplate.queryForList(sql, new Object[]{serviceName, topic},Integer.class);
		if(temp != null && temp.size() > 0) {
			result = temp.get(0);
		}
		return result;
	}

}
