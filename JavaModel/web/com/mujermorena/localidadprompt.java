package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.localidadprompt", "/com.mujermorena.localidadprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class localidadprompt extends GXWebObjectStub
{
   public localidadprompt( )
   {
   }

   public localidadprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidadprompt.class ));
   }

   public localidadprompt( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidadprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidadprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Localidad";
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
      return "localidadprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

