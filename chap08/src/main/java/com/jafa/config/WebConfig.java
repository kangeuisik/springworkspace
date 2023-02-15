package com.jafa.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// 디스패쳐 서블릿(뷰페이지로 보냄)
		return new String[] {"/"};
	}

	
	
}
