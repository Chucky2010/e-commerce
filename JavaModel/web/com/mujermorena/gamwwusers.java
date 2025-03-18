package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwusers", "/com.mujermorena.gamwwusers"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwusers extends GXWebObjectStub
{
   public gamwwusers( )
   {
   }

   public gamwwusers( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwusers.class ));
   }

   public gamwwusers( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwusers_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwusers_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_Users";
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
      return "gamwwusers_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

