package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.pedidoswwcliente", "/com.mujermorena.pedidoswwcliente"})
@jakarta.servlet.annotation.MultipartConfig
public final  class pedidoswwcliente extends GXWebObjectStub
{
   public pedidoswwcliente( )
   {
   }

   public pedidoswwcliente( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( pedidoswwcliente.class ));
   }

   public pedidoswwcliente( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new pedidoswwcliente_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new pedidoswwcliente_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pedidos WWCliente";
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
      return "pedidoswwcliente_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

