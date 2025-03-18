package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.galeriaarticulo", "/com.mujermorena.galeriaarticulo"})
@jakarta.servlet.annotation.MultipartConfig
public final  class galeriaarticulo extends GXWebObjectStub
{
   public galeriaarticulo( )
   {
   }

   public galeriaarticulo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( galeriaarticulo.class ));
   }

   public galeriaarticulo( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new galeriaarticulo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new galeriaarticulo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Galeria Articulo";
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
      return "galeriaarticulo_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

