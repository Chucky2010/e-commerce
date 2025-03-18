package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck", "/com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpdynamicfieldsrequiredcheck extends GXWebObjectStub
{
   public wwpdynamicfieldsrequiredcheck( )
   {
   }

   public wwpdynamicfieldsrequiredcheck( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpdynamicfieldsrequiredcheck.class ));
   }

   public wwpdynamicfieldsrequiredcheck( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpdynamicfieldsrequiredcheck_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpdynamicfieldsrequiredcheck_impl(context).cleanup();
   }

   public void execute( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> aP0 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 )
   {
      new wwpdynamicfieldsrequiredcheck_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> aP0 )
   {
      GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Dynamic Fields Required Check";
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

