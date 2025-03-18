package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulogeneral", "/com.mujermorena.articulogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulogeneral extends GXWebObjectStub
{
   public articulogeneral( )
   {
   }

   public articulogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulogeneral.class ));
   }

   public articulogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo General";
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

