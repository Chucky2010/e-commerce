package com.mujermorena ;
import com.mujermorena.*;
import java.util.*;
import org.glassfish.jersey.jackson.JacksonFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.genexus.ws.RestReaderInterceptor;
import com.genexus.ws.GXContainerResponseFilter;
import com.genexus.ws.GXRestException;
import com.genexus.ws.GXRestJsonMappingException;
import com.genexus.util.GXServices;
import com.genexus.webpanels.WebUtils;
import com.genexus.ws.rs.core.Application;

public final  class GXApplication extends Application
{
   public Set<Class<?>> getClasses( )
   {
      Set<Class<?>> rrcs = new HashSet<Class<?>>();
      rrcs.add(RestReaderInterceptor.class);
      rrcs.add(GXContainerResponseFilter.class);
      rrcs.add(GXRestException.class);
      rrcs.add(GXRestJsonMappingException.class);
      rrcs.add(JacksonJaxbJsonProvider.class);
      rrcs.add(JacksonFeature.class);
      WebUtils.getGXApplicationClasses( getClass(), rrcs);
      WebUtils.AddExternalServices( getClass(), rrcs);
      return rrcs ;
   }

}

