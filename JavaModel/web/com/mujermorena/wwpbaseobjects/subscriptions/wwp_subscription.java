package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription", "/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_subscription extends GXWebObjectStub
{
   public wwp_subscription( )
   {
   }

   public wwp_subscription( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_subscription.class ));
   }

   public wwp_subscription( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_subscription_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_subscription_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Subscription";
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
      return "wwpsubscription_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

