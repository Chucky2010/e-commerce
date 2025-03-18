package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/sdsvc_MyProductsCartCheckout_Level_Detail")
public final  class sdsvc_myproductscartcheckout_level_detail_services_rest extends GxRestService
{
   @jakarta.ws.rs.GET
   @jakarta.ws.rs.Path("/Cartproductcollection__talla")
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response Cartproductcollection__talla( ) throws Exception
   {
      super.init( "GET" );
      permissionPrefix = "myproductscartcheckout_Execute";
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
      if ( ! processHeaders("sdsvc_myproductscartcheckout_level_detail",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.sdsvc_myproductscartcheckout_level_detail worker = new com.mujermorena.sdsvc_myproductscartcheckout_level_detail(remoteHandle, context);
         builder = Response.okWrapped( worker.cartproductcollection__talladl( ).toJson());
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

