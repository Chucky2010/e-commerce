package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clienteview", "/com.mujermorena.clienteview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clienteview extends GXWebObjectStub
{
   public clienteview( )
   {
   }

   public clienteview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteview.class ));
   }

   public clienteview( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente View";
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
      return "clienteview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

