/**     
 * @FileName: RestTempletConfig.java   
 * @Package:com.cloud.paas.portal.configuration   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月14日 上午10:42:11   
 */
package com.cloud.paas.portal.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**  
 * @ClassName: RestTempletConfig   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月14日 上午10:42:11     
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
