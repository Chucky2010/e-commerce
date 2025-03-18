package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventariogeneral", "/com.mujermorena.inventariogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventariogeneral extends GXWebObjectStub
{
   public inventariogeneral( )
   {
   }

   public inventariogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventariogeneral.class ));
   }

   public inventariogeneral( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventariogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventariogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Inventario General";
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

