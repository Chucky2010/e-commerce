package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulo", "/com.mujermorena.articulo"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulo extends GXWebObjectStub
{
   public articulo( )
   {
   }

   public articulo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulo.class ));
   }

   public articulo( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo";
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
      return "articulo_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

