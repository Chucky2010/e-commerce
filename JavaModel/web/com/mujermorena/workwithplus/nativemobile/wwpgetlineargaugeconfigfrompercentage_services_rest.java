package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPGetLinearGaugeConfigFromPercentage")
public final  class wwpgetlineargaugeconfigfrompercentage_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      short AV9Percentage;
      AV9Percentage = entity.getPercentage() ;
      String [] AV8GaugeData = new String[] { "" };
      permissionPrefix = "wwpgetlineargaugeconfigfrompercentage_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_impl(remoteHandle, context);
         worker.execute_int(AV9Percentage,AV8GaugeData );
         com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage_RESTInterfaceOUT();
         data.setGaugeData(AV8GaugeData[0]);
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

