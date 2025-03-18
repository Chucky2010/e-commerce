package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson", "/com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldstojson"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpdynamicfieldstojson extends GXWebObjectStub
{
   public wwpdynamicfieldstojson( )
   {
   }

   public wwpdynamicfieldstojson( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpdynamicfieldstojson.class ));
   }

   public wwpdynamicfieldstojson( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpdynamicfieldstojson_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpdynamicfieldstojson_impl(context).cleanup();
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> aP0 ,
                        String[] aP1 )
   {
      new wwpdynamicfieldstojson_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> aP0 )
   {
      String[] aP1 = new String[] {""};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Dynamic Fields To JSON";
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

