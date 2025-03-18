package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.localidadgeneral", "/com.mujermorena.localidadgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class localidadgeneral extends GXWebObjectStub
{
   public localidadgeneral( )
   {
   }

   public localidadgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidadgeneral.class ));
   }

   public localidadgeneral( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidadgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidadgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Localidad General";
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

