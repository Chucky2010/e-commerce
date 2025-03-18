package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.proveedorww", "/com.mujermorena.proveedorww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class proveedorww extends GXWebObjectStub
{
   public proveedorww( )
   {
   }

   public proveedorww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( proveedorww.class ));
   }

   public proveedorww( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new proveedorww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new proveedorww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Proveedor";
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
      return "proveedorww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

