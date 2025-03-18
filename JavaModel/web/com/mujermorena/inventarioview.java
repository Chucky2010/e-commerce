package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventarioview", "/com.mujermorena.inventarioview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventarioview extends GXWebObjectStub
{
   public inventarioview( )
   {
   }

   public inventarioview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventarioview.class ));
   }

   public inventarioview( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventarioview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventarioview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Inventario View";
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
      return "inventarioview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

