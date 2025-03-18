package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devicesview", "/com.mujermorena.devicesview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devicesview extends GXWebObjectStub
{
   public devicesview( )
   {
   }

   public devicesview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devicesview.class ));
   }

   public devicesview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devicesview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devicesview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devices View";
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
      return "devicesview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

