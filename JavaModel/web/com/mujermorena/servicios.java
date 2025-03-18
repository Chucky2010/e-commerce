package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.servicios", "/com.mujermorena.servicios"})
@jakarta.servlet.annotation.MultipartConfig
public final  class servicios extends GXWebObjectStub
{
   public servicios( )
   {
   }

   public servicios( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( servicios.class ));
   }

   public servicios( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new servicios_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new servicios_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Servicios";
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
      return "servicios_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

