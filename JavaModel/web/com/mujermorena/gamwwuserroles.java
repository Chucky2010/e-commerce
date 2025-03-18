package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwuserroles", "/com.mujermorena.gamwwuserroles"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwuserroles extends GXWebObjectStub
{
   public gamwwuserroles( )
   {
   }

   public gamwwuserroles( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwuserroles.class ));
   }

   public gamwwuserroles( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwuserroles_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwuserroles_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_UserRoles";
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
      return "gamwwuserroles_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

