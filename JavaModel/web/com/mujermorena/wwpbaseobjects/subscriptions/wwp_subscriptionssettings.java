package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings", "/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_subscriptionssettings extends GXWebObjectStub
{
   public wwp_subscriptionssettings( )
   {
   }

   public wwp_subscriptionssettings( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_subscriptionssettings.class ));
   }

   public wwp_subscriptionssettings( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_subscriptionssettings_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_subscriptionssettings_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Manage my Subscriptions";
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
      return "wwpsubscriptionssettings_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

