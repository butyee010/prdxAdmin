package com.prdx.admin.bean;

import java.util.ArrayList;
import java.util.List;

import com.prdx.admin.bean.form.GalleryForm;
import com.prdx.admin.bean.form.ServicesForm;

import lombok.Data;

@Data
public class DummyBean {
	List<ServicesForm> serviceForm = new ArrayList<>();
	List<GalleryForm> galleryForm = new ArrayList<>();
	
}
