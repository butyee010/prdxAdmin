package com.prdx.admin.service.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.prdx.admin.bean.MultipartFileForm;
import com.prdx.admin.bean.contact.HomeBean;
import com.prdx.admin.bean.form.HomeForm;
import com.prdx.admin.dao.HomePageDAO;
import com.prdx.admin.helper.PropertyConfigHelper;
import com.prdx.admin.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService{

	@Autowired
	private HomePageDAO homePageDAO;
	
	@Override
	public HomeBean getHomePage() throws Exception {
		HomeBean homeBean = new HomeBean();
		homeBean.setCarouselList(homePageDAO.getCarouselList());
		
		homeBean.setHeaderRef1(homePageDAO.getValue("HEADER_REF_1"));
		homeBean.setContentRef1(homePageDAO.getValue("CONTENT_REF_1"));
		homeBean.setImgPathRef2(homePageDAO.getValue("IMAGE_REF_1"));
		
		homeBean.setHeaderRef3(homePageDAO.getValue("HEADER_REF_2"));
		homeBean.setContentRef3(homePageDAO.getValue("CONTENT_REF_2"));
		homeBean.setImgPathRef3(homePageDAO.getValue("IMAGE_REF_2"));
		
		return homeBean;
	}

	@Override
	public void editHomePage(HomeForm homeForm) throws Exception {
		String url = PropertyConfigHelper.getConfigValue("IMAGES_URL");
		String basePath = PropertyConfigHelper.getConfigValue("BASE_IMAGES_PATH");
		String servicePath = PropertyConfigHelper.getConfigValue("ABOUT_IMAGES_PATH");
		if(homeForm.getImageRef1List() != null && homeForm.getImageRef1List().size() > 0) {
			int i = 1;
			for (MultipartFileForm multipartFileForm : homeForm.getImageRef1List()) {
				if(multipartFileForm != null) {
					if(multipartFileForm.getFile() != null) {
						boolean insert = true;
						String remotePath = basePath + servicePath + File.separator + "SLIDE_"+i+".jpg" ;
						String fullUrl = url + servicePath + File.separator + "SLIDE_"+i+".jpg";
						convertFile(multipartFileForm.getFile(), remotePath);
						if(StringUtils.isNotBlank(homePageDAO.getValue("SLIDE_IMAGE_"+i))) {
							insert = false;
						}
						homePageDAO.setValue("SLIDE_IMAGE_"+i, fullUrl, insert);
					}
				}
				i++;
			}
		}
		homePageDAO.setValue("HEADER_REF_1", homeForm.getHeaderRef1(), false);
		homePageDAO.setValue("CONTENT_REF_1", homeForm.getContentRef1(), false);
		if(homeForm.getImageRef2().getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "IMAGE_REF_1.jpg" ;
			String fullUrl = url + servicePath + File.separator + "IMAGE_REF_1.jpg";
			convertFile(homeForm.getImageRef2().getFile(), remotePath);
			homePageDAO.setValue("IMAGE_REF_1", fullUrl, false);
		}
		
		homePageDAO.setValue("HEADER_REF_2", homeForm.getHeaderRef3(), false);
		homePageDAO.setValue("CONTENT_REF_2", homeForm.getContentRef3(), false);
		if(homeForm.getImageRef3().getFile() != null) {
			String remotePath = basePath + servicePath + File.separator + "IMAGE_REF_2.jpg" ;
			String fullUrl = url + servicePath + File.separator + "IMAGE_REF_2.jpg";
			convertFile(homeForm.getImageRef3().getFile(), remotePath);
			homePageDAO.setValue("IMAGE_REF_2", fullUrl, false);
		}
	}
	
	private File convertFile(MultipartFile file, String path) throws Exception
	{    
	    File convFile = new File(path);
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}

}
