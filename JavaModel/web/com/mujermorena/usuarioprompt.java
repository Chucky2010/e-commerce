package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.usuarioprompt", "/com.mujermorena.usuarioprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usuarioprompt extends GXWebObjectStub
{
   public usuarioprompt( )
   {
   }

   public usuarioprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usuarioprompt.class ));
   }

   public usuarioprompt( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usuarioprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usuarioprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Usuario";
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
      return "usuarioprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

