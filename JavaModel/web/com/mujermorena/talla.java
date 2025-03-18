package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.talla", "/com.mujermorena.talla"})
@jakarta.servlet.annotation.MultipartConfig
public final  class talla extends GXWebObjectStub
{
   public talla( )
   {
   }

   public talla( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( talla.class ));
   }

   public talla( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new talla_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new talla_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Talla";
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
      return "talla_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

