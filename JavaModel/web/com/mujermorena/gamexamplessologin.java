package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexamplessologin", "/com.mujermorena.gamexamplessologin"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexamplessologin extends GXWebObjectStub
{
   public gamexamplessologin( )
   {
   }

   public gamexamplessologin( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexamplessologin.class ));
   }

   public gamexamplessologin( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexamplessologin_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexamplessologin_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Single Sign-On";
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

