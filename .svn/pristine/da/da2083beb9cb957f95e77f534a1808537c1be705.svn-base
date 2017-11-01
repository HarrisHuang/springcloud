/**     
 * @FileName: PortalApplication.java   
 * @Package:com.cloud.paas.portal   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年8月29日 下午3:12:22   
 */
package com.cloud.paas.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
 * @ClassName: PortalApplication   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年8月29日 下午3:12:22     
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
@EnableCircuitBreaker //开启熔断器
@EnableFeignClients //开启声明式的web service客户端
@EnableTransactionManagement //开启声名式事务
@EnableCaching //启用缓存
@ComponentScan(basePackages={"com.cloud.paas"})
@MapperScan("com.cloud.paas.portal.persistence") //扫描Mapper
public class PortalApplication {

	/**   
	 * @Title: main   
	 * @Description: TODO  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(PortalApplication.class).web(true).run(args);

	}

}
