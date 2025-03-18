package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuestogeneral", "/com.mujermorena.impuestogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuestogeneral extends GXWebObjectStub
{
   public impuestogeneral( )
   {
   }

   public impuestogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuestogeneral.class ));
   }

   public impuestogeneral( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuestogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuestogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Impuesto General";
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

