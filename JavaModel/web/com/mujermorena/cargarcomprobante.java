package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cargarcomprobante", "/com.mujermorena.cargarcomprobante"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cargarcomprobante extends GXWebObjectStub
{
   public cargarcomprobante( )
   {
   }

   public cargarcomprobante( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cargarcomprobante.class ));
   }

   public cargarcomprobante( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cargarcomprobante_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cargarcomprobante_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cargar Comprobante";
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
      return "cargarcomprobante_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

