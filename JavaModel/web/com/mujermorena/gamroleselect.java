package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamroleselect", "/com.mujermorena.gamroleselect"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamroleselect extends GXWebObjectStub
{
   public gamroleselect( )
   {
   }

   public gamroleselect( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamroleselect.class ));
   }

   public gamroleselect( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamroleselect_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamroleselect_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SelectRolesRole";
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
      return "gamroleselect_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

