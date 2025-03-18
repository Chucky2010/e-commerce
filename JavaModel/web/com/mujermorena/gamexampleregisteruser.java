package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexampleregisteruser", "/com.mujermorena.gamexampleregisteruser"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexampleregisteruser extends GXWebObjectStub
{
   public gamexampleregisteruser( )
   {
   }

   public gamexampleregisteruser( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexampleregisteruser.class ));
   }

   public gamexampleregisteruser( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexampleregisteruser_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexampleregisteruser_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Register user ";
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

