package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devicesgeneral", "/com.mujermorena.devicesgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devicesgeneral extends GXWebObjectStub
{
   public devicesgeneral( )
   {
   }

   public devicesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devicesgeneral.class ));
   }

   public devicesgeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devicesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devicesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devices General";
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

