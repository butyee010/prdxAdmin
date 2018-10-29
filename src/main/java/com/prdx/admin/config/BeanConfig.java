package com.prdx.admin.config;

import javax.servlet.MultipartConfigElement;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import com.prdx.admin.constant.PortalConstants;

@Configuration
public class BeanConfig {

	public String BASE_NAME = "bundle";
	//Message
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("bundle");
		messageSource.setDefaultEncoding(PortalConstants.ENCODING_UTF_8);
		return messageSource;
	}
	
	@Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        String uploadSize = "52428800";
        if (StringUtils.isNotBlank(uploadSize))
        	resolver.setMaxUploadSizePerFile(Long.valueOf(uploadSize)); 
        return resolver;
    }

    @Bean
    public MultipartFilter multipartFilter() {
            MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("multipartResolver");
        return multipartFilter;
    }
}