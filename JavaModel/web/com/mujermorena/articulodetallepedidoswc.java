package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulodetallepedidoswc", "/com.mujermorena.articulodetallepedidoswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulodetallepedidoswc extends GXWebObjectStub
{
   public articulodetallepedidoswc( )
   {
   }

   public articulodetallepedidoswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulodetallepedidoswc.class ));
   }

   public articulodetallepedidoswc( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulodetallepedidoswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulodetallepedidoswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo Detalle Pedidos WC";
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

