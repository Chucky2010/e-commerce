package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ventasdevolucioneswc", "/com.mujermorena.ventasdevolucioneswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ventasdevolucioneswc extends GXWebObjectStub
{
   public ventasdevolucioneswc( )
   {
   }

   public ventasdevolucioneswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ventasdevolucioneswc.class ));
   }

   public ventasdevolucioneswc( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ventasdevolucioneswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ventasdevolucioneswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ventas Devoluciones WC";
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

