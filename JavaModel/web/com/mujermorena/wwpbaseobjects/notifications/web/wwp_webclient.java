package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient", "/com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_webclient extends GXWebObjectStub
{
   public wwp_webclient( )
   {
   }

   public wwp_webclient( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_webclient.class ));
   }

   public wwp_webclient( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_webclient_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_webclient_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Web Client";
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
      return "webclient_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

