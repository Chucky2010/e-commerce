package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/VerDetallesPedidosSD_Level_Detail_grid")
public final  class verdetallespedidossd_level_detail_grid_services_rest extends GxRestService
{
   @jakarta.ws.rs.GET
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( @jakarta.ws.rs.QueryParam("Pedidosid") @jakarta.ws.rs.DefaultValue("") String sAV8PedidosID ,
                                               @jakarta.ws.rs.QueryParam("start") @jakarta.ws.rs.DefaultValue("0") String sAV20start ,
                                               @jakarta.ws.rs.QueryParam("count") @jakarta.ws.rs.DefaultValue("0") String sAV21count ,
                                               @jakarta.ws.rs.QueryParam("gxid") @jakarta.ws.rs.DefaultValue("") String sAV17gxid ) throws Exception
   {
      super.init( "GET" );
      permissionPrefix = "verdetallespedidossd_Execute";
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
      if ( ! processHeaders("verdetallespedidossd_level_detail_grid",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      long AV8PedidosID;
      AV8PedidosID = GXutil.lval( sAV8PedidosID) ;
      long AV20start;
      AV20start = GXutil.lval( sAV20start) ;
      long AV21count;
      AV21count = GXutil.lval( sAV21count) ;
      int AV17gxid;
      AV17gxid = (int)(GXutil.lval( sAV17gxid)) ;
      GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> data;
      try
      {
         com.mujermorena.verdetallespedidossd_level_detail_grid worker = new com.mujermorena.verdetallespedidossd_level_detail_grid(remoteHandle, context);
         data = worker.executeUdp(AV8PedidosID,AV20start,AV21count,AV17gxid );
         if ( data.size() == 0 )
         {
            builder = Response.okWrapped("[]");
         }
         else
         {
            GenericEntity<Vector< com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface >> ge = new GenericEntity<Vector< com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface >>( SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterfacefromGXObjectCollection (data)) {};
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

   private Vector<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface> SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item> collection )
   {
      Vector<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface> result = new Vector<com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item_RESTInterface((com.mujermorena.SdtVerDetallesPedidosSD_Level_Detail_gridSdt_Item)collection.elementAt(i)));
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

