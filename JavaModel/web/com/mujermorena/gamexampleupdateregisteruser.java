package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexampleupdateregisteruser", "/com.mujermorena.gamexampleupdateregisteruser"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexampleupdateregisteruser extends GXWebObjectStub
{
   public gamexampleupdateregisteruser( )
   {
   }

   public gamexampleupdateregisteruser( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexampleupdateregisteruser.class ));
   }

   public gamexampleupdateregisteruser( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexampleupdateregisteruser_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexampleupdateregisteruser_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Update register user";
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

