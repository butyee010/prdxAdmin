package com.prdx.admin.bean.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GalleryForm {

	private String header;
	private String content;
	private String fileName;
	private MultipartFile file;
	
}
