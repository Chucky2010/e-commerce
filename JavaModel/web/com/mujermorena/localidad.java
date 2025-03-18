package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.localidad", "/com.mujermorena.localidad"})
@jakarta.servlet.annotation.MultipartConfig
public final  class localidad extends GXWebObjectStub
{
   public localidad( )
   {
   }

   public localidad( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidad.class ));
   }

   public localidad( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidad_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidad_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Localidad";
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
      return "localidad_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

