package com.prdx.admin.bean.contact;

import com.prdx.admin.constant.PortalConstants;

import lombok.Data;

@Data
public class GalleryBean {
	
	public String header;
	public String content;
	
	public String imgPath;
	public String imgName = PortalConstants.IMAGE_NAME_DEFUALT;
	
}
