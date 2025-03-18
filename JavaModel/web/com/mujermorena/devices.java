package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devices", "/com.mujermorena.devices"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devices extends GXWebObjectStub
{
   public devices( )
   {
   }

   public devices( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devices.class ));
   }

   public devices( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devices_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devices_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devices";
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
      return "devices_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

