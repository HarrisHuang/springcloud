/**     
 * @FileName: MonitorApplication.java   
 * @Package:com.cloud.paas.monitor   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月13日 上午10:01:14   
 */
package com.cloud.paas.monitor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**  
 * @ClassName: MonitorApplication   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月13日 上午10:01:14     
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.cloud.paas"})
public class MonitorApplication {

	
	@Bean
	public HystrixCommandAspect hystrixAspect() {
		return new HystrixCommandAspect();
	}
	
	
	/**   
	 * @Title: main   
	 * @Description: TODO  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(MonitorApplication.class).web(true).run(args);

	}

}
