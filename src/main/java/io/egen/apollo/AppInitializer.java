package io.egen.apollo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import io.egen.apollo.AppConfig;
import io.egen.apollo.JPAConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {	
		return new Class[]{AppConfig.class, SwaggerConfig.class, JPAConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		return null;
	}
 
	@Override
	protected String[] getServletMappings() {		
		return new String[]{"/"};
	}
}
