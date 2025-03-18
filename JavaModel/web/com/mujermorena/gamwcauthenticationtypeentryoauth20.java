package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwcauthenticationtypeentryoauth20", "/com.mujermorena.gamwcauthenticationtypeentryoauth20"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwcauthenticationtypeentryoauth20 extends GXWebObjectStub
{
   public gamwcauthenticationtypeentryoauth20( )
   {
   }

   public gamwcauthenticationtypeentryoauth20( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwcauthenticationtypeentryoauth20.class ));
   }

   public gamwcauthenticationtypeentryoauth20( int remoteHandle ,
                                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwcauthenticationtypeentryoauth20_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwcauthenticationtypeentryoauth20_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Authentication Type Entry Oauth20";
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

