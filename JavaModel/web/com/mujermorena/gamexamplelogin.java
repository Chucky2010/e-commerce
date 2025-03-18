package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexamplelogin", "/com.mujermorena.gamexamplelogin"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexamplelogin extends GXWebObjectStub
{
   public gamexamplelogin( )
   {
   }

   public gamexamplelogin( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexamplelogin.class ));
   }

   public gamexamplelogin( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexamplelogin_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexamplelogin_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Login";
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

