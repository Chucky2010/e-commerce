package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamapplicationentry", "/com.mujermorena.gamapplicationentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamapplicationentry extends GXWebObjectStub
{
   public gamapplicationentry( )
   {
   }

   public gamapplicationentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamapplicationentry.class ));
   }

   public gamapplicationentry( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamapplicationentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamapplicationentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Application";
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
      return "gamapplicationentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

