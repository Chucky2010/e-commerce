package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwweventsubscriptions", "/com.mujermorena.gamwweventsubscriptions"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwweventsubscriptions extends GXWebObjectStub
{
   public gamwweventsubscriptions( )
   {
   }

   public gamwweventsubscriptions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwweventsubscriptions.class ));
   }

   public gamwweventsubscriptions( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwweventsubscriptions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwweventsubscriptions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_EventSubscriptions";
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
      return "gamwweventsubscriptions_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

