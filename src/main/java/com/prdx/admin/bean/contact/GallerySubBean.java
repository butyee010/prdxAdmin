package com.prdx.admin.bean.contact;

import java.util.ArrayList;
import java.util.List;

import com.prdx.admin.constant.PortalConstants;

import lombok.Data;

@Data
public class GallerySubBean {
	
	public String galleryName = PortalConstants.GALLERY;
	public String subGalleryName;
	public List<CarouselBean> carouselList = new ArrayList<>();
	
}
