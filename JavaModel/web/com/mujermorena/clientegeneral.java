package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clientegeneral", "/com.mujermorena.clientegeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clientegeneral extends GXWebObjectStub
{
   public clientegeneral( )
   {
   }

   public clientegeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientegeneral.class ));
   }

   public clientegeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientegeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientegeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente General";
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

