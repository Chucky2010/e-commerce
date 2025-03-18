package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt", "/com.mujermorena.workwithplus.nativemobile.wwpproductslisttodoubleoptionssdt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpproductslisttodoubleoptionssdt extends GXWebObjectStub
{
   public wwpproductslisttodoubleoptionssdt( )
   {
   }

   public wwpproductslisttodoubleoptionssdt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpproductslisttodoubleoptionssdt.class ));
   }

   public wwpproductslisttodoubleoptionssdt( int remoteHandle ,
                                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpproductslisttodoubleoptionssdt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpproductslisttodoubleoptionssdt_impl(context).cleanup();
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> aP0 ,
                        GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>[] aP1 )
   {
      new wwpproductslisttodoubleoptionssdt_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem> executeUdp( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> aP0 )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>[] aP1 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDoubleItemListData_DoubleItemListDataItem>()};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "WWPProducts List To Double Options SDT";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

