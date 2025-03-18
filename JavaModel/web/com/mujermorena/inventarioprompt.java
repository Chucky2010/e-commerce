package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventarioprompt", "/com.mujermorena.inventarioprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventarioprompt extends GXWebObjectStub
{
   public inventarioprompt( )
   {
   }

   public inventarioprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventarioprompt.class ));
   }

   public inventarioprompt( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventarioprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventarioprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Inventario";
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
      return "inventarioprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

