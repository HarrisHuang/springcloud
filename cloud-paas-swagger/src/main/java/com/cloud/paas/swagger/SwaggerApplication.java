/**     
 * @FileName: SwaggerApplication.java   
 * @Package:com.cloud.paas.swagger   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月13日 下午12:05:31   
 */
package com.cloud.paas.swagger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**  
 * @ClassName: SwaggerApplication   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月13日 下午12:05:31     
 */
@SpringBootApplication
//@EnableWebMvc
@EnableDiscoveryClient
public class SwaggerApplication {

	/**   
	 * @Title: main   
	 * @Description: TODO  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(SwaggerApplication.class).web(true).run(args);

	}

}
