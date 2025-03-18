package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.generarfactura", "/com.mujermorena.generarfactura"})
@jakarta.servlet.annotation.MultipartConfig
public final  class generarfactura extends GXWebObjectStub
{
   public generarfactura( )
   {
   }

   public generarfactura( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( generarfactura.class ));
   }

   public generarfactura( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new generarfactura_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new generarfactura_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Generar Factura";
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

