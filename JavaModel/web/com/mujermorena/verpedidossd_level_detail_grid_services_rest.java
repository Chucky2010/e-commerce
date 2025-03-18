package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/VerPedidosSD_Level_Detail_Grid")
public final  class verpedidossd_level_detail_grid_services_rest extends GxRestService
{
   @jakarta.ws.rs.GET
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( @jakarta.ws.rs.QueryParam("start") @jakarta.ws.rs.DefaultValue("0") String sAV22start ,
                                               @jakarta.ws.rs.QueryParam("count") @jakarta.ws.rs.DefaultValue("0") String sAV23count ,
                                               @jakarta.ws.rs.QueryParam("gxid") @jakarta.ws.rs.DefaultValue("") String sAV19gxid ) throws Exception
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
      if ( ! processHeaders("verpedidossd_level_detail_grid",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      long AV22start;
      AV22start = GXutil.lval( sAV22start) ;
      long AV23count;
      AV23count = GXutil.lval( sAV23count) ;
      int AV19gxid;
      AV19gxid = (int)(GXutil.lval( sAV19gxid)) ;
      GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item> data;
      try
      {
         com.mujermorena.verpedidossd_level_detail_grid worker = new com.mujermorena.verpedidossd_level_detail_grid(remoteHandle, context);
         data = worker.executeUdp(AV22start,AV23count,AV19gxid );
         if ( data.size() == 0 )
         {
            builder = Response.okWrapped("[]");
         }
         else
         {
            GenericEntity<Vector< com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface >> ge = new GenericEntity<Vector< com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface >>( SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterfacefromGXObjectCollection (data)) {};
            builder = Response.okWrapped(ge);
         }
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   private Vector<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface> SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item> collection )
   {
      Vector<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface> result = new Vector<com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item_RESTInterface((com.mujermorena.SdtVerPedidosSD_Level_Detail_GridSdt_Item)collection.elementAt(i)));
      }
      return result ;
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

