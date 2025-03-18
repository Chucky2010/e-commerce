package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamuserpermissionselect", "/com.mujermorena.gamuserpermissionselect"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamuserpermissionselect extends GXWebObjectStub
{
   public gamuserpermissionselect( )
   {
   }

   public gamuserpermissionselect( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamuserpermissionselect.class ));
   }

   public gamuserpermissionselect( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamuserpermissionselect_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamuserpermissionselect_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SelectPermissionsUser";
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
      return "gamuserpermissionselect_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

