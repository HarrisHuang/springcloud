/**     
 * @FileName: AdminApplication.java   
 * @Package:com.cloud.paas.admin   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年8月29日 下午5:37:32   
 */
package com.cloud.paas.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
 * @ClassName: AdminApplication   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年8月29日 下午5:37:32     
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
@EnableCircuitBreaker //开启熔断器
@EnableFeignClients //开启声明式的web service客户端
@EnableTransactionManagement //开启声名式事务
@EnableCaching //启用缓存
@ComponentScan(basePackages={"com.cloud.paas"})
public class AdminApplication {

	/**   
	 * @Title: main   
	 * @Description: TODO  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(AdminApplication.class).web(true).run(args);

	}

}
