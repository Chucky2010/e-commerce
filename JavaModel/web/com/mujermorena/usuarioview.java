package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.usuarioview", "/com.mujermorena.usuarioview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usuarioview extends GXWebObjectStub
{
   public usuarioview( )
   {
   }

   public usuarioview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usuarioview.class ));
   }

   public usuarioview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usuarioview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usuarioview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Usuario View";
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
      return "usuarioview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

