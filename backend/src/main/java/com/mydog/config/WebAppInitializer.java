package com.mydog.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        WebApplicationContext rootContext = createRootContext(servletContext);

        configureSpringMvc(servletContext, rootContext);


//        AnnotationConfigWebApplicationContext dispatcherContext =
//            new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(WebConfig.class);
//
//        ServletRegistration.Dynamic dispatcher =
//            servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/api/*");
    }

    private void configureSpringMvc(ServletContext servletContext, WebApplicationContext rootContext) {
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebConfig.class);
        mvcContext.setParent(rootContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(mvcContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/api/*");
    }

    private WebApplicationContext createRootContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(CoreConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.setInitParameter("defaultHtmlEscape","true");
        return rootContext;
    }
}
