package com.shcherbinina.cinemapark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import static java.util.Collections.singletonList;

@SpringBootApplication
public class CinemaparkApplication {

	public CinemaparkApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
		freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(singletonList("/META-INF/security.tld"));
	}


	public static void main(String[] args) {
		SpringApplication.run(CinemaparkApplication.class, args);
	}

}
