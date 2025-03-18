package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamrolepermissionselect", "/com.mujermorena.gamrolepermissionselect"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamrolepermissionselect extends GXWebObjectStub
{
   public gamrolepermissionselect( )
   {
   }

   public gamrolepermissionselect( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamrolepermissionselect.class ));
   }

   public gamrolepermissionselect( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamrolepermissionselect_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamrolepermissionselect_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SelectPermissionsRole";
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
      return "gamrolepermissionselect_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

