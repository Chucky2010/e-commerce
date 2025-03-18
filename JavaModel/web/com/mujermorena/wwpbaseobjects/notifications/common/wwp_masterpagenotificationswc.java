package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.notifications.common.wwp_masterpagenotificationswc", "/com.mujermorena.wwpbaseobjects.notifications.common.wwp_masterpagenotificationswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_masterpagenotificationswc extends GXWebObjectStub
{
   public wwp_masterpagenotificationswc( )
   {
   }

   public wwp_masterpagenotificationswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_masterpagenotificationswc.class ));
   }

   public wwp_masterpagenotificationswc( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_masterpagenotificationswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_masterpagenotificationswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Master Page Notifications";
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

