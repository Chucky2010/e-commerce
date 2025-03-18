package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPGetDecimalFromHex")
public final  class wwpgetdecimalfromhex_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV12HexadecimalValueIn;
      AV12HexadecimalValueIn = entity.getHexadecimalValueIn() ;
      int [] AV9DecimalValue = new int[] { 0 };
      permissionPrefix = "wwpgetdecimalfromhex_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpgetdecimalfromhex",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex_impl(remoteHandle, context);
         worker.execute_int(AV12HexadecimalValueIn,AV9DecimalValue );
         com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex_RESTInterfaceOUT();
         data.setDecimalValue(AV9DecimalValue[0]);
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

