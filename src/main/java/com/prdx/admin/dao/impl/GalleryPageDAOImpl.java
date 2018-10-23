package com.prdx.admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.prdx.admin.bean.contact.CarouselBean;
import com.prdx.admin.bean.contact.GalleryBean;
import com.prdx.admin.constant.SQLConstants;
import com.prdx.admin.dao.GalleryPageDAO;

@Repository
public class GalleryPageDAOImpl implements GalleryPageDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GalleryBean> getGalleryBeanList() throws Exception {
		String sql = SQLConstants.SQL_GET_GALLERY_BEAN_LIST;
		List<GalleryBean> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<GalleryBean>(GalleryBean.class));
		return result;
	}

	@Override
	public List<CarouselBean> getCarouselList(String topic) throws Exception {
		String sql = SQLConstants.SQL_GET_GALLERY_SUB_BEAN_CAROUSEL;
		List<CarouselBean> result = jdbcTemplate.query(sql, new Object[]{topic}, new BeanPropertyRowMapper<CarouselBean>(CarouselBean.class));
		return result;
	}

	@Override
	public Integer getTotalImageJssor(String topic) throws Exception {
		String sql = SQLConstants.SQL_GET_TOTAL_IMAGE_JSSOR_GALLERY;
		Integer result = 0;
		List<Integer> temp = jdbcTemplate.queryForList(sql, new Object[]{topic},Integer.class);
		if(temp != null && temp.size() > 0) {
			result = temp.get(0);
		}
		return result;
	}
}
