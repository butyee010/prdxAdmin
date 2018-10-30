package com.prdx.admin.bean.form;

import java.util.List;

import com.prdx.admin.bean.MultipartFileForm;

import lombok.Data;

@Data
public class GalleryJssorForm {

	private String topic;
	private List<MultipartFileForm> fileImageList;
	
}
