package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ventasdetallewc", "/com.mujermorena.ventasdetallewc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ventasdetallewc extends GXWebObjectStub
{
   public ventasdetallewc( )
   {
   }

   public ventasdetallewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ventasdetallewc.class ));
   }

   public ventasdetallewc( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ventasdetallewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ventasdetallewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ventas Detalle WC";
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

