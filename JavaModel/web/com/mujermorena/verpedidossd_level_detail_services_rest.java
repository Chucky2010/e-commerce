package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/VerPedidosSD_Level_Detail")
public final  class verpedidossd_level_detail_services_rest extends GxRestService
{
   @jakarta.ws.rs.GET
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( @jakarta.ws.rs.QueryParam("gxid") @jakarta.ws.rs.DefaultValue("") String sAV19gxid ) throws Exception
   {
      super.init( "GET" );
      permissionPrefix = "verpedidossd_Execute";
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
      if ( ! processHeaders("verpedidossd_level_detail",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      int AV19gxid;
      AV19gxid = (int)(GXutil.lval( sAV19gxid)) ;
      com.mujermorena.SdtVerPedidosSD_Level_DetailSdt data;
      try
      {
         com.mujermorena.verpedidossd_level_detail worker = new com.mujermorena.verpedidossd_level_detail(remoteHandle, context);
         data = worker.executeUdp(AV19gxid );
         builder = Response.okWrapped(new com.mujermorena.SdtVerPedidosSD_Level_DetailSdt_RESTInterface(data));
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

