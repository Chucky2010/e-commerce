package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.pedidos", "/com.mujermorena.pedidos"})
@jakarta.servlet.annotation.MultipartConfig
public final  class pedidos extends GXWebObjectStub
{
   public pedidos( )
   {
   }

   public pedidos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( pedidos.class ));
   }

   public pedidos( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pedidos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pedidos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pedidos";
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
      return "pedidos_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

