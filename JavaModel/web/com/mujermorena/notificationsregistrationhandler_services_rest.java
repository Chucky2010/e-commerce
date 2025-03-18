package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/NotificationsRegistrationHandler")
public final  class notificationsregistrationhandler_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.notificationsregistrationhandler_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      byte AV11DeviceType;
      AV11DeviceType = entity.getDeviceType() ;
      String AV8DeviceId;
      AV8DeviceId = entity.getDeviceId() ;
      String AV10DeviceToken;
      AV10DeviceToken = entity.getDeviceToken() ;
      String AV9DeviceName;
      AV9DeviceName = entity.getDeviceName() ;
      permissionPrefix = "notificationsregistrationhandler_Services_Execute";
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
      if ( ! processHeaders("notificationsregistrationhandler",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.notificationsregistrationhandler worker = new com.mujermorena.notificationsregistrationhandler(remoteHandle, context);
         worker.execute(AV11DeviceType,AV8DeviceId,AV10DeviceToken,AV9DeviceName );
         builder = Response.okWrapped();
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

