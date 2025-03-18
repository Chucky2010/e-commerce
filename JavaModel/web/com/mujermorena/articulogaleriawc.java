package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulogaleriawc", "/com.mujermorena.articulogaleriawc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulogaleriawc extends GXWebObjectStub
{
   public articulogaleriawc( )
   {
   }

   public articulogaleriawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulogaleriawc.class ));
   }

   public articulogaleriawc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulogaleriawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulogaleriawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo Galeria WC";
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

