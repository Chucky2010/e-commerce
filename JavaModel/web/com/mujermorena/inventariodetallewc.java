package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventariodetallewc", "/com.mujermorena.inventariodetallewc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventariodetallewc extends GXWebObjectStub
{
   public inventariodetallewc( )
   {
   }

   public inventariodetallewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventariodetallewc.class ));
   }

   public inventariodetallewc( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventariodetallewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventariodetallewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Inventario Detalle WC";
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

