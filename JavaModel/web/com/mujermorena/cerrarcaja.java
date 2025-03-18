package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cerrarcaja", "/com.mujermorena.cerrarcaja"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cerrarcaja extends GXWebObjectStub
{
   public cerrarcaja( )
   {
   }

   public cerrarcaja( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cerrarcaja.class ));
   }

   public cerrarcaja( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cerrarcaja_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cerrarcaja_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cerrar Caja";
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
      return "cerrarcaja_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

