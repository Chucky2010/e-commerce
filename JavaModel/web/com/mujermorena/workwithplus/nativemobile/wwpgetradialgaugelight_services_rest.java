package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPGetRadialGaugeLight")
public final  class wwpgetradialgaugelight_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      short AV10Value;
      AV10Value = entity.getValue() ;
      String AV9ProgressColor;
      AV9ProgressColor = entity.getProgressColor() ;
      String [] AV8HTML = new String[] { "" };
      permissionPrefix = "wwpgetradialgaugelight_Services_Execute";
      if ( ! isAuthenticated(myServletRequestWrapper) )
      {
         if ( forbidden )
         {
            builder = Response.forbidden();
         }
         else
         {
            setWWWAuthHeader(myServletRequestWrapper, myServletResponseWrapper);
            builder = Response.unauthorized();
         }
         builder.type("application/json");
         builder.entity(errorJson.toString());
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      if ( ! processHeaders("workwithplus.nativemobile.wwpgetradialgaugelight",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight_impl(remoteHandle, context);
         worker.execute_int(AV10Value,AV9ProgressColor,AV8HTML );
         com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight_RESTInterfaceOUT();
         data.setHTML(AV8HTML[0]);
         builder = Response.okWrapped(data);
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

}

