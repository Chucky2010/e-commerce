package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPMapPointFromString")
public final  class wwpmappointfromstring_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpmappointfromstring_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV12SelectedItem;
      AV12SelectedItem = entity.getSelectedItem() ;
      GXGeospatial [] AV8Geopoint = new GXGeospatial[] { new GXGeospatial() };
      permissionPrefix = "wwpmappointfromstring_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpmappointfromstring",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpmappointfromstring worker = new com.mujermorena.workwithplus.nativemobile.wwpmappointfromstring(remoteHandle, context);
         worker.execute(AV12SelectedItem,AV8Geopoint );
         com.mujermorena.workwithplus.nativemobile.wwpmappointfromstring_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpmappointfromstring_RESTInterfaceOUT();
         data.setGeopoint(AV8Geopoint[0].toWKT());
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

