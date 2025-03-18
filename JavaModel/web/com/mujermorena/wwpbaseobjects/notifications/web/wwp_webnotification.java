package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification", "/com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_webnotification extends GXWebObjectStub
{
   public wwp_webnotification( )
   {
   }

   public wwp_webnotification( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_webnotification.class ));
   }

   public wwp_webnotification( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_webnotification_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_webnotification_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Web Notification";
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
      return "webnotification_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

