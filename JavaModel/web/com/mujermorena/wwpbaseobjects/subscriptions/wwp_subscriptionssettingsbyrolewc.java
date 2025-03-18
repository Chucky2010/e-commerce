package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrolewc", "/com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettingsbyrolewc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_subscriptionssettingsbyrolewc extends GXWebObjectStub
{
   public wwp_subscriptionssettingsbyrolewc( )
   {
   }

   public wwp_subscriptionssettingsbyrolewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_subscriptionssettingsbyrolewc.class ));
   }

   public wwp_subscriptionssettingsbyrolewc( int remoteHandle ,
                                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_subscriptionssettingsbyrolewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_subscriptionssettingsbyrolewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Subscriptions Settings by Role";
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

