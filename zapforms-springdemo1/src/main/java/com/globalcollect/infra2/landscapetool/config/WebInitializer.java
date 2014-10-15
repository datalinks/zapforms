package com.globalcollect.infra2.landscapetool.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
  
public class WebInitializer implements WebApplicationInitializer {

	//@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/*
	public void onStartup(ServletContext servletContext) throws ServletException {  
          
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(Config.class);  
        ctx.setServletContext(servletContext);    
        
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);  
          
    }  
*/
}
