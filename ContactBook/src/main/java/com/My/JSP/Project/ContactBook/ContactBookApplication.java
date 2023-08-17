package com.My.JSP.Project.ContactBook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class ContactBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactBookApplication.class, args);
	}
	
	List<VendorExtension> venderExtensions=new ArrayList<VendorExtension>();
	//to provide the contact details for the project
	Contact contact=new Contact("Subrata","https://www.facebook.com/login","subratamohanty4@gmail.com");
	
	//to provide the details bout the project
	
	ApiInfo apiInfo=new ApiInfo("ContactBook API",
			                    "it allows to uplod the contct into the DB from excelfile,also save,deleteand update into the database",
			        
			                     "snapchat-0.01","https://www.qspiders.com/", contact,
			                      "terms and conditions", "https://www.qspiders.com/", venderExtensions);
	@Bean
	
	
	public Docket getApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.My.JSP.Project.ContactBook"))
				.build()
				.apiInfo(apiInfo);
	}


}
