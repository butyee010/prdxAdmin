package com.prdx.admin.bean.form;

import java.util.List;

import com.prdx.admin.bean.MultipartFileForm;

import lombok.Data;

@Data
public class HomeForm {

	List<MultipartFileForm> imageRef1List;

	public String headerRef1;
	public String contentRef1;
	
	public MultipartFileForm imageRef2;

	public String headerRef3;
	public String contentRef3;
	public MultipartFileForm imageRef3;

}
