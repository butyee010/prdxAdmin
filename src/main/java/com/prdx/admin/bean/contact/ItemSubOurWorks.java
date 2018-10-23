package com.prdx.admin.bean.contact;

import com.prdx.admin.constant.PortalConstants;

import lombok.Data;

@Data
public class ItemSubOurWorks {
	
	public String topicName;
	public String content;
	public String imgPath;
	public String imgName = PortalConstants.IMAGE_NAME_DEFUALT;

}
