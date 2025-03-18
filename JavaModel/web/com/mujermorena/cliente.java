package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cliente", "/com.mujermorena.cliente"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cliente extends GXWebObjectStub
{
   public cliente( )
   {
   }

   public cliente( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cliente.class ));
   }

   public cliente( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cliente_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cliente_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente";
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
      return "cliente_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

