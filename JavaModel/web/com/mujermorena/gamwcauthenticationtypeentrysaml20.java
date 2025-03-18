package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwcauthenticationtypeentrysaml20", "/com.mujermorena.gamwcauthenticationtypeentrysaml20"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwcauthenticationtypeentrysaml20 extends GXWebObjectStub
{
   public gamwcauthenticationtypeentrysaml20( )
   {
   }

   public gamwcauthenticationtypeentrysaml20( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwcauthenticationtypeentrysaml20.class ));
   }

   public gamwcauthenticationtypeentrysaml20( int remoteHandle ,
                                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwcauthenticationtypeentrysaml20_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwcauthenticationtypeentrysaml20_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "GAMWCAuthentication Type Entry Saml20";
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

