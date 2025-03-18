package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson", "/com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsfromjson"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpdynamicfieldsfromjson extends GXWebObjectStub
{
   public wwpdynamicfieldsfromjson( )
   {
   }

   public wwpdynamicfieldsfromjson( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpdynamicfieldsfromjson.class ));
   }

   public wwpdynamicfieldsfromjson( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpdynamicfieldsfromjson_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpdynamicfieldsfromjson_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>[] aP1 )
   {
      new wwpdynamicfieldsfromjson_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> executeUdp( String aP0 )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>[] aP1 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>()};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Dynamic Fields From JSON";
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

