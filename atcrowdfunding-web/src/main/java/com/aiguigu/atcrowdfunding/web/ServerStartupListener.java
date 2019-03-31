package com.aiguigu.atcrowdfunding.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ServerStartupListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {
        //将web应用名称（路径）保存到application范围中
        ServletContext application = sce.getServletContext();
        String path = application.getContextPath();
        application.setAttribute("APP_PATH", path);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

}
