package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification", "/com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_visualizenotification extends GXWebObjectStub
{
   public wwp_visualizenotification( )
   {
   }

   public wwp_visualizenotification( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_visualizenotification.class ));
   }

   public wwp_visualizenotification( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_visualizenotification_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_visualizenotification_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Visualize one notification";
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
      return "wwpvisualizenotification_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

