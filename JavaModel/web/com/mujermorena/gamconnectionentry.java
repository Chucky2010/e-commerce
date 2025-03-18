package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamconnectionentry", "/com.mujermorena.gamconnectionentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamconnectionentry extends GXWebObjectStub
{
   public gamconnectionentry( )
   {
   }

   public gamconnectionentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamconnectionentry.class ));
   }

   public gamconnectionentry( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamconnectionentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamconnectionentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Connection";
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
      return "gamconnectionentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

