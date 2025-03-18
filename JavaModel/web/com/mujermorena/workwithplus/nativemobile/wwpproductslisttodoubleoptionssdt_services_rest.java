package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/WorkWithPlus/NativeMobile/WWPProductsListToDoubleOptionsSDT")
public final  class wwpproductslisttodoubleoptionssdt_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> AV14ProductDataList ;
      AV14ProductDataList= SdtWWPProductData_RESTInterfacetoGXObjectCollection(entity.getProductDataList());
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem> [] AV11DoubleMenuOptions = new GXBaseCollection[] { new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>() };
      permissionPrefix = "wwpproductslisttodoubleoptionssdt_Services_Execute";
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
      if ( ! processHeaders("workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_impl worker = new com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_impl(remoteHandle, context);
         worker.execute_int(AV14ProductDataList,AV11DoubleMenuOptions );
         com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_RESTInterfaceOUT data = new com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt_RESTInterfaceOUT();
         data.setDoubleMenuOptions(SdtDoubleItemListData_DoubleItemListDataItem_RESTInterfacefromGXObjectCollection(AV11DoubleMenuOptions[0]));
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

   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Path("gxobject")
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response Upload( ) throws Exception
   {
      super.init( "POST" );
      permissionPrefix = "wwpproductslisttodoubleoptionssdt_Services_Execute";
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
      try
      {
         builder = new com.genexus.webpanels.GXObjectUploadServices().doInternalRestExecute(restHttpContext);
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> SdtWWPProductData_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> result = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.workwithplus.nativemobile.SdtWWPProductData)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> SdtDoubleItemListData_DoubleItemListDataItem_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem> collection )
   {
      Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface> result = new Vector<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem_RESTInterface((com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem)collection.elementAt(i)));
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

