/**     
 * @FileName: MessageCenterApplication.java   
 * @Package:com.cloud.paas.messagecenter   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月3日 上午1:34:27   
 */
package com.cloud.paas.messagecenter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**  
 * @ClassName: MessageCenterApplication   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月3日 上午1:34:27     
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务发现
@EnableFeignClients //开启声明式的web service客户端
@EnableTransactionManagement //开启声名式事务
@ComponentScan(basePackages={"com.cloud.paas"})
//@MapperScan("com.cloud.paas.messagecenter.persistence") //扫描Mapper
//@EnableJms
public class MessageCenterApplication {

	/**   
	 * @Title: main   
	 * @Description: TODO  
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(MessageCenterApplication.class).web(true).run(args);

	}

}
