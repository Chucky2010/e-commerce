package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPGetUnicodeFromHex")
public final  class wwpgetunicodefromhex_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV8HexaUnicode;
      AV8HexaUnicode = entity.getHexaUnicode() ;
      String [] AV9UnicodeCharacter = new String[] { "" };
      permissionPrefix = "wwpgetunicodefromhex_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpgetunicodefromhex",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex_impl(remoteHandle, context);
         worker.execute_int(AV8HexaUnicode,AV9UnicodeCharacter );
         com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex_RESTInterfaceOUT();
         data.setUnicodeCharacter(AV9UnicodeCharacter[0]);
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

