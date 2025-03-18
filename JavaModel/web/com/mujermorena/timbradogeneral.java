package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.timbradogeneral", "/com.mujermorena.timbradogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class timbradogeneral extends GXWebObjectStub
{
   public timbradogeneral( )
   {
   }

   public timbradogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( timbradogeneral.class ));
   }

   public timbradogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new timbradogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new timbradogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Timbrado General";
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

