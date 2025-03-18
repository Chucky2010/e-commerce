package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamuserroleselect", "/com.mujermorena.gamuserroleselect"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamuserroleselect extends GXWebObjectStub
{
   public gamuserroleselect( )
   {
   }

   public gamuserroleselect( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamuserroleselect.class ));
   }

   public gamuserroleselect( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamuserroleselect_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamuserroleselect_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SelectRolesUser";
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
      return "gamuserroleselect_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

