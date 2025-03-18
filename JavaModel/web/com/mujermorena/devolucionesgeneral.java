package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devolucionesgeneral", "/com.mujermorena.devolucionesgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devolucionesgeneral extends GXWebObjectStub
{
   public devolucionesgeneral( )
   {
   }

   public devolucionesgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devolucionesgeneral.class ));
   }

   public devolucionesgeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devolucionesgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devolucionesgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devoluciones General";
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

