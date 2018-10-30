package com.prdx.admin.bean;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MultipartFileForm {

	private String fileName;
	private MultipartFile file;
}
