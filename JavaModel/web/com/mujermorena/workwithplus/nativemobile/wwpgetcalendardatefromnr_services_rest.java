package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPGetCalendarDateFromNr")
public final  class wwpgetcalendardatefromnr_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      short AV12Year;
      AV12Year = entity.getYear() ;
      byte AV11Month;
      AV11Month = entity.getMonth() ;
      byte AV10Day;
      AV10Day = entity.getDay() ;
      String [] AV9DateJson = new String[] { "" };
      permissionPrefix = "wwpgetcalendardatefromnr_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpgetcalendardatefromnr",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr_impl(remoteHandle, context);
         worker.execute_int(AV12Year,AV11Month,AV10Day,AV9DateJson );
         com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr_RESTInterfaceOUT();
         data.setDateJson(AV9DateJson[0]);
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

