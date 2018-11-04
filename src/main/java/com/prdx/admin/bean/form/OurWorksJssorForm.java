package com.prdx.admin.bean.form;

import java.util.List;

import com.prdx.admin.bean.MultipartFileForm;

import lombok.Data;

@Data
public class OurWorksJssorForm {

	private String topic;
	private String service;
	
	private List<MultipartFileForm> fileImageList;
	
}
