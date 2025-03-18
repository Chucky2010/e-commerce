package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwroles", "/com.mujermorena.gamwwroles"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwroles extends GXWebObjectStub
{
   public gamwwroles( )
   {
   }

   public gamwwroles( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwroles.class ));
   }

   public gamwwroles( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwroles_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwroles_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_Roles";
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
      return "gamwwroles_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

