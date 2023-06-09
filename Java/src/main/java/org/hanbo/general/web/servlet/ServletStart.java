package org.hanbo.general.web.servlet;

import org.hanbo.general.web.config.RootConfig;
import org.hanbo.general.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletStart extends
AbstractAnnotationConfigDispatcherServletInitializer
{
   @Override
   protected Class<?>[] getRootConfigClasses()
   {
      return new Class[] { RootConfig.class, WebConfig.class };
   }
   
   @Override
   protected Class<?>[] getServletConfigClasses()
   {
      return null;
   }
   
   @Override
   protected String[] getServletMappings()
   {
      return new String[] { "/" };
   }
}