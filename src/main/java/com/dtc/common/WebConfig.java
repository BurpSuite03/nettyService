package com.dtc.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WebConfig {
	
	public Docket creatRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//包路径
				.apis(RequestHandlerSelectors.basePackage(""))
				.paths(PathSelectors.any())
				.build()
				;
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("springboot使用swagger2构建RESTful API")
				//创建人信息
				.contact(new Contact("dtc", "http://dtc.com", "dtc@gmail.com"))
				//版本号
				.version("1.0")
				//描述
				.description("API 接口")
				.build()
				;
	}

}
