package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clientepedidoswc", "/com.mujermorena.clientepedidoswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clientepedidoswc extends GXWebObjectStub
{
   public clientepedidoswc( )
   {
   }

   public clientepedidoswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientepedidoswc.class ));
   }

   public clientepedidoswc( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientepedidoswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientepedidoswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente Pedidos WC";
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

