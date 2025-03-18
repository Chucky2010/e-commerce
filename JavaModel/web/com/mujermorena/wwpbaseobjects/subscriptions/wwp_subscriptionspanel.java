package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionspanel", "/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionspanel"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_subscriptionspanel extends GXWebObjectStub
{
   public wwp_subscriptionspanel( )
   {
   }

   public wwp_subscriptionspanel( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_subscriptionspanel.class ));
   }

   public wwp_subscriptionspanel( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_subscriptionspanel_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_subscriptionspanel_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Subscriptions of an Entity/Record";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
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

