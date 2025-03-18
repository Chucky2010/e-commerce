package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devolucionesdetallewc", "/com.mujermorena.devolucionesdetallewc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devolucionesdetallewc extends GXWebObjectStub
{
   public devolucionesdetallewc( )
   {
   }

   public devolucionesdetallewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devolucionesdetallewc.class ));
   }

   public devolucionesdetallewc( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devolucionesdetallewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devolucionesdetallewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devoluciones Detalle WC";
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

