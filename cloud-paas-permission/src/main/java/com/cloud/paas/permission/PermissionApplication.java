/**     
 * @FileName: PermissionApplication.java   
 * @Package:com.cloud.paas.permission   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月14日 上午10:50:34   
 */
package com.cloud.paas.permission;

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
 * @ClassName: PermissionApplication   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月14日 上午10:50:34     
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //开启熔断器
@EnableFeignClients //开启声明式的web service客户端
@EnableTransactionManagement //开启声名式事务
@EnableCaching //启用缓存
@ComponentScan(basePackages={"com.cloud.paas"})
@MapperScan("com.cloud.paas.permission.persistence") //扫描Mapper
public class PermissionApplication {

	/**   
	 * @Title: main   
	 * @Description: TODO  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(PermissionApplication.class).web(true).run(args);

	}

}
