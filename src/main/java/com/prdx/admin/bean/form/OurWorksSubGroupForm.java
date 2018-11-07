package com.prdx.admin.bean.form;

import java.util.List;

import com.prdx.admin.bean.MultipartFileForm;

import lombok.Data;

@Data
public class OurWorksSubGroupForm {

	private String topic;
	
	
	private List<MultipartFileForm> fileImageList;
	private List<TopicForm> topicList;
}
