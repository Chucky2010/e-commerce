package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrole", "/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrole"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_subscriptionssettingsbyrole extends GXWebObjectStub
{
   public wwp_subscriptionssettingsbyrole( )
   {
   }

   public wwp_subscriptionssettingsbyrole( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_subscriptionssettingsbyrole.class ));
   }

   public wwp_subscriptionssettingsbyrole( int remoteHandle ,
                                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_subscriptionssettingsbyrole_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_subscriptionssettingsbyrole_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Manage Role's Subscriptions";
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
      return "wwpsubscriptionssettingsbyrole_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

