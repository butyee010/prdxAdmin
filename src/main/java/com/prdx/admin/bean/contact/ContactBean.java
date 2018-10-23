package com.prdx.admin.bean.contact;

import lombok.Data;

@Data
public class ContactBean {
	
	public String locationName;
	public String locationInfo;
	
	public String address;
	public String tel;
	public String email;
	
	public String directUrl;
	public String directLargeMapUrl;
	
	public String latitude;
	public String longitude;
	public Integer mapZoom = 15;
	
}
