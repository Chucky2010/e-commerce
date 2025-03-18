package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/NMCartPaymentMethodsSetSelected")
public final  class nmcartpaymentmethodssetselected_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.nmcartpaymentmethodssetselected_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV8Selected;
      AV8Selected = entity.getSelected() ;
      permissionPrefix = "nmcartpaymentmethodssetselected_Services_Execute";
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
      if ( ! processHeaders("nmcartpaymentmethodssetselected",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.nmcartpaymentmethodssetselected worker = new com.mujermorena.nmcartpaymentmethodssetselected(remoteHandle, context);
         worker.execute(AV8Selected );
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

