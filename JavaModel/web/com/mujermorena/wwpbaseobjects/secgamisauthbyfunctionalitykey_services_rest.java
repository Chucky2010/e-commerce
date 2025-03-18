package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WWPBaseObjects/SecGAMIsAuthByFunctionalityKey")
public final  class secgamisauthbyfunctionalitykey_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV10SecGAMFunctionalityKey;
      AV10SecGAMFunctionalityKey = entity.getSecGAMFunctionalityKey() ;
      boolean [] AV9IsAuthorized = new boolean[] { false };
      permissionPrefix = "secisauthbyfunctionalitykey_Services_Execute";
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
      if ( ! processHeaders("wwpbaseobjects.secgamisauthbyfunctionalitykey",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey worker = new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context);
         worker.execute(AV10SecGAMFunctionalityKey,AV9IsAuthorized );
         com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey_RESTInterfaceOUT data = new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey_RESTInterfaceOUT();
         data.setIsAuthorized(AV9IsAuthorized[0]);
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

