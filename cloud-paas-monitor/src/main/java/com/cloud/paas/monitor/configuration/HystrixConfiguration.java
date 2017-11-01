/**     
 * @FileName: HystrixConfiguration.java   
 * @Package:com.cloud.paas.monitor.configuration   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月13日 上午10:09:43   
 */
package com.cloud.paas.monitor.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
 * @ClassName: HystrixConfiguration   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月13日 上午10:09:43     
 */
public class HystrixConfiguration  extends WebMvcConfigurerAdapter{

	/* (non-Javadoc)   
	 * @param registry   
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)   
	 */  
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/hystrix/**").addResourceLocations("classpath:/static/hystrix/");
	}

	
}
