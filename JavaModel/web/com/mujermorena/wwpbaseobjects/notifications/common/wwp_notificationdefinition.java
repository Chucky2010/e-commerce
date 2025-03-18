package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition", "/com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_notificationdefinition extends GXWebObjectStub
{
   public wwp_notificationdefinition( )
   {
   }

   public wwp_notificationdefinition( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_notificationdefinition.class ));
   }

   public wwp_notificationdefinition( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_notificationdefinition_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_notificationdefinition_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Notification Definition";
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
      return "wwpnotificationdefinition_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

