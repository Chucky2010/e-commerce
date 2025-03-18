package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications", "/com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_visualizeallnotifications extends GXWebObjectStub
{
   public wwp_visualizeallnotifications( )
   {
   }

   public wwp_visualizeallnotifications( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_visualizeallnotifications.class ));
   }

   public wwp_visualizeallnotifications( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_visualizeallnotifications_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_visualizeallnotifications_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Visualize all notifications";
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
      return "wwpvisualizeallnotifications_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

