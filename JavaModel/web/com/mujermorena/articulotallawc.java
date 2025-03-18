package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulotallawc", "/com.mujermorena.articulotallawc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulotallawc extends GXWebObjectStub
{
   public articulotallawc( )
   {
   }

   public articulotallawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulotallawc.class ));
   }

   public articulotallawc( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulotallawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulotallawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo Talla WC";
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

