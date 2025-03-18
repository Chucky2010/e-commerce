package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulodetalleinventariowc", "/com.mujermorena.articulodetalleinventariowc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulodetalleinventariowc extends GXWebObjectStub
{
   public articulodetalleinventariowc( )
   {
   }

   public articulodetalleinventariowc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulodetalleinventariowc.class ));
   }

   public articulodetalleinventariowc( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulodetalleinventariowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulodetalleinventariowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo Detalle Inventario WC";
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

