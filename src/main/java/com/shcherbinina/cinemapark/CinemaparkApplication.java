package com.shcherbinina.cinemapark;

import freemarker.ext.jsp.TaglibFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Arrays;
import java.util.regex.Pattern;

@SpringBootApplication
public class CinemaparkApplication {

	public CinemaparkApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
		TaglibFactory.ClasspathMetaInfTldSource classpathMetaInfTldSource =
				new TaglibFactory.ClasspathMetaInfTldSource(Pattern.compile(".*"));

		freeMarkerConfigurer.getTaglibFactory().setMetaInfTldSources(Arrays.asList(classpathMetaInfTldSource));
	}


	public static void main(String[] args) {
		SpringApplication.run(CinemaparkApplication.class, args);
	}

}
