package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/VerDisponSD")
public final  class verdisponsd_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.verdisponsd_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV8ProductId;
      AV8ProductId = entity.getProductId() ;
      short AV9ProductTalla;
      AV9ProductTalla = entity.getProductTalla() ;
      short [] AV10ProductDispon = new short[] { 0 };
      permissionPrefix = "verdisponsd_Services_Execute";
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
      if ( ! processHeaders("verdisponsd",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.verdisponsd worker = new com.mujermorena.verdisponsd(remoteHandle, context);
         worker.execute(AV8ProductId,AV9ProductTalla,AV10ProductDispon );
         com.mujermorena.verdisponsd_RESTInterfaceOUT data = new com.mujermorena.verdisponsd_RESTInterfaceOUT();
         data.setProductDispon(AV10ProductDispon[0]);
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

