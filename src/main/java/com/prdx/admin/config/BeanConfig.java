package com.prdx.admin.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

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
	
	/*@Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        String uploadSize = ConfigConstants.getPromptpayAdjustUploadMaxSize();
        if (StringUtils.isNotBlank(uploadSize))
        	resolver.setMaxUploadSizePerFile(Long.valueOf(uploadSize)); 
        else 
        	resolver.setMaxUploadSizePerFile(PROMPT_PAY_ADJUST_UPLOAD_MAX_SIZE); 
        return resolver;
    }

    @Bean
    public MultipartFilter multipartFilter() {
            MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("multipartResolver");
        return multipartFilter;
    }*/
	
}