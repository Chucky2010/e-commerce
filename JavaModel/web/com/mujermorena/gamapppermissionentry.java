package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamapppermissionentry", "/com.mujermorena.gamapppermissionentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamapppermissionentry extends GXWebObjectStub
{
   public gamapppermissionentry( )
   {
   }

   public gamapppermissionentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamapppermissionentry.class ));
   }

   public gamapppermissionentry( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamapppermissionentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamapppermissionentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_Permission";
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
      return "gamapppermissionentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

