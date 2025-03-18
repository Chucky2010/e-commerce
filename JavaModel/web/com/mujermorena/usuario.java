package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.usuario", "/com.mujermorena.usuario"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usuario extends GXWebObjectStub
{
   public usuario( )
   {
   }

   public usuario( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usuario.class ));
   }

   public usuario( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usuario_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usuario_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Usuario";
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
      return "usuario_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

