/**     
 * @FileName: ApiGatewayApplication.java   
 * @Package:com.cloud.paas.apigateway   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年8月29日 下午4:36:44   
 */
package com.cloud.paas.apigateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**  
 * @ClassName: ApiGatewayApplication   
 * @Description: 入口
 * @author: huangyan  
 * @date:2017年8月29日 下午4:36:44     
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableDiscoveryClient //开启服务发现
@EnableCircuitBreaker //开启熔断器
@EnableFeignClients //开启声明式的web service客户端
@EnableZuulProxy
@ComponentScan(basePackages={"com.cloud.paas"})
@ServletComponentScan
public class ApiGatewayApplication {

	/**   
	 * @Title: main   
	 * @Description: 入口方法  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);

	}

}
