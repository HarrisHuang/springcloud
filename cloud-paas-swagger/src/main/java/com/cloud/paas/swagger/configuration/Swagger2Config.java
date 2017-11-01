/**     
 * @FileName: Swagger2.java   
 * @Package:com.cloud.paas.swagger   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月13日 下午2:15:43   
 */
package com.cloud.paas.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**  
 * @ClassName: Swagger2   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月13日 下午2:15:43     
 */
@Configuration  
@ComponentScan(basePackages = { "com.cloud.paas.controller" })//配置controller路径
@EnableSwagger2
@SuppressWarnings({"unchecked","deprecation"})
public class Swagger2Config {
	@Bean  
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()
                .paths(Predicates.or(
                //这里添加你需要展示的接口
                        PathSelectors.ant("/account/**"),
                        PathSelectors.ant("/xxx/**"),
                        PathSelectors.ant("/user/**"),
                        PathSelectors.ant("/test/**")
                                    )
                        )
                .build();
        		
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()  
                .title("Spring Cloud")
                .description("说明RESTful APIs")
                .contact("Huang yan") 
                .version("1.0")
                .build();  
    }
}
