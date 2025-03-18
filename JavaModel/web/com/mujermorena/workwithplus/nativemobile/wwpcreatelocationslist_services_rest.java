package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPCreateLocationsList")
public final  class wwpcreatelocationslist_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV10SelectedItem;
      AV10SelectedItem = entity.getSelectedItem() ;
      String AV11SelectedItemText;
      AV11SelectedItemText = entity.getSelectedItemText() ;
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo> [] AV9MapItems = new GXBaseCollection[] { new GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo>() };
      permissionPrefix = "wwpcreatelocationslist_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpcreatelocationslist",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist_impl(remoteHandle, context);
         worker.execute_int(AV10SelectedItem,AV11SelectedItemText,AV9MapItems );
         com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpcreatelocationslist_RESTInterfaceOUT();
         data.setMapItems(SdtGeolocationInfo_RESTInterfacefromGXObjectCollection(AV9MapItems[0]));
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

   private Vector<com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface> SdtGeolocationInfo_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.genexuscore.genexus.common.SdtGeolocationInfo> collection )
   {
      Vector<com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface> result = new Vector<com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.genexuscore.genexus.common.SdtGeolocationInfo_RESTInterface((com.genexuscore.genexus.common.SdtGeolocationInfo)collection.elementAt(i)));
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

