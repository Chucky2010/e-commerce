package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clienteww", "/com.mujermorena.clienteww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clienteww extends GXWebObjectStub
{
   public clienteww( )
   {
   }

   public clienteww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteww.class ));
   }

   public clienteww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Cliente";
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
      return "clienteww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

