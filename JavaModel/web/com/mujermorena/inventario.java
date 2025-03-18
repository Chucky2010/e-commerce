package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventario", "/com.mujermorena.inventario"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventario extends GXWebObjectStub
{
   public inventario( )
   {
   }

   public inventario( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventario.class ));
   }

   public inventario( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventario_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventario_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Inventario";
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
      return "inventario_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

