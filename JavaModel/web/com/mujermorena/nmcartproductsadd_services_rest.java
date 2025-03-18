package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/NMCartProductsAdd")
public final  class nmcartproductsadd_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.nmcartproductsadd_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV10ProductId;
      AV10ProductId = entity.getProductId() ;
      short AV9Count;
      AV9Count = entity.getCount() ;
      short AV15Talle;
      AV15Talle = entity.getTalle() ;
      short AV20ProductDispon;
      AV20ProductDispon = entity.getProductDispon() ;
      short [] AV17Result = new short[] { 0 };
      short [] AV19Saldo = new short[] { 0 };
      permissionPrefix = "nmcartproductsadd_Services_Execute";
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
      if ( ! processHeaders("nmcartproductsadd",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.nmcartproductsadd worker = new com.mujermorena.nmcartproductsadd(remoteHandle, context);
         worker.execute(AV10ProductId,AV9Count,AV15Talle,AV20ProductDispon,AV17Result,AV19Saldo );
         com.mujermorena.nmcartproductsadd_RESTInterfaceOUT data = new com.mujermorena.nmcartproductsadd_RESTInterfaceOUT();
         data.setResult(AV17Result[0]);
         data.setSaldo(AV19Saldo[0]);
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

