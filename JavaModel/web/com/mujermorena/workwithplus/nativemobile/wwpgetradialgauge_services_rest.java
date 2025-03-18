package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPGetRadialGauge")
public final  class wwpgetradialgauge_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      short AV16Value;
      AV16Value = entity.getValue() ;
      String AV10InnerText;
      AV10InnerText = entity.getInnerText() ;
      String AV11ProgressColor;
      AV11ProgressColor = entity.getProgressColor() ;
      String AV15TextColor;
      AV15TextColor = entity.getTextColor() ;
      String AV14ShadowColor;
      AV14ShadowColor = entity.getShadowColor() ;
      boolean AV9AllowAnimation;
      AV9AllowAnimation = entity.getAllowAnimation() ;
      String [] AV8HTML = new String[] { "" };
      permissionPrefix = "wwpgetradialgauge_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpgetradialgauge",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge_impl(remoteHandle, context);
         worker.execute_int(AV16Value,AV10InnerText,AV11ProgressColor,AV15TextColor,AV14ShadowColor,AV9AllowAnimation,AV8HTML );
         com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge_RESTInterfaceOUT();
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

