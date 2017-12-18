package com.education.teacher.swagger;

import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket getDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		@SuppressWarnings("deprecation")
		ApiInfo apiInfro = new ApiInfo("ResetFul api", "ApiDocument 管理", "v3.8.0", "www.baidu.com", "我的邮箱", "", "");
		docket.apiInfo(apiInfro);
		return docket;

	}
}