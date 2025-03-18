package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.productosmasvendidos", "/com.mujermorena.productosmasvendidos"})
@jakarta.servlet.annotation.MultipartConfig
public final  class productosmasvendidos extends GXWebObjectStub
{
   public productosmasvendidos( )
   {
   }

   public productosmasvendidos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( productosmasvendidos.class ));
   }

   public productosmasvendidos( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new productosmasvendidos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new productosmasvendidos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Productos Mas Vendidos";
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

