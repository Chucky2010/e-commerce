package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articuloview", "/com.mujermorena.articuloview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articuloview extends GXWebObjectStub
{
   public articuloview( )
   {
   }

   public articuloview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articuloview.class ));
   }

   public articuloview( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articuloview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articuloview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo View";
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
      return "articuloview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

