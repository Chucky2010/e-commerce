package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.usuariogeneral", "/com.mujermorena.usuariogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usuariogeneral extends GXWebObjectStub
{
   public usuariogeneral( )
   {
   }

   public usuariogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usuariogeneral.class ));
   }

   public usuariogeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usuariogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usuariogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Usuario General";
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

