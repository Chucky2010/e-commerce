package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.opcionenviogeneral", "/com.mujermorena.opcionenviogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class opcionenviogeneral extends GXWebObjectStub
{
   public opcionenviogeneral( )
   {
   }

   public opcionenviogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( opcionenviogeneral.class ));
   }

   public opcionenviogeneral( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new opcionenviogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new opcionenviogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Opcion Envio General";
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

