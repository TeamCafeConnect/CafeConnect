package com.yash.cafeconnect.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Root context configuration (for services, repositories, security)
        return new Class[] { SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Web context configuration (for controllers, view resolvers)
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // Maps DispatcherServlet to root "/"
        return new String[] { "/" };
    }

    @Override
    protected String getServletName() {
        return "dispatcher";
    }
}