package com.prdx.admin.bean.contact;

import java.util.ArrayList;
import java.util.List;

import com.prdx.admin.constant.PortalConstants;

import lombok.Data;

@Data
public class HomeBean {
	
	public List<CarouselBean> carouselList = new ArrayList<>();
	
	//start block
	public String headerRef1;
	public String contentRef1;
	//end block
	
	//start block
	public String imgPathRef2;
	public String imgNameRef2 = PortalConstants.IMAGE_NAME_DEFUALT;
	public String imgHightSizeRef2 = "300px";
	//end block
	
	//start block
	public String imgPathRef3;
	public String imgNameRef3 = PortalConstants.IMAGE_NAME_DEFUALT;
	
	public String headerRef3;
	public String contentRef3;
	//end block
}
