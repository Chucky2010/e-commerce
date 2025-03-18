package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopagopedidoswc", "/com.mujermorena.tipopagopedidoswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopagopedidoswc extends GXWebObjectStub
{
   public tipopagopedidoswc( )
   {
   }

   public tipopagopedidoswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopagopedidoswc.class ));
   }

   public tipopagopedidoswc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopagopedidoswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopagopedidoswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Pago Pedidos WC";
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

