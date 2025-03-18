package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.roles", "/com.mujermorena.roles"})
@jakarta.servlet.annotation.MultipartConfig
public final  class roles extends GXWebObjectStub
{
   public roles( )
   {
   }

   public roles( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( roles.class ));
   }

   public roles( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new roles_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new roles_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Roles";
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
      return "roles_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

