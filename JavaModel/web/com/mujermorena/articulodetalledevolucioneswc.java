package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulodetalledevolucioneswc", "/com.mujermorena.articulodetalledevolucioneswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulodetalledevolucioneswc extends GXWebObjectStub
{
   public articulodetalledevolucioneswc( )
   {
   }

   public articulodetalledevolucioneswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulodetalledevolucioneswc.class ));
   }

   public articulodetalledevolucioneswc( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulodetalledevolucioneswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulodetalledevolucioneswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo Detalle Devoluciones WC";
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

