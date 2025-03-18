package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwuserpermissions", "/com.mujermorena.gamwwuserpermissions"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwuserpermissions extends GXWebObjectStub
{
   public gamwwuserpermissions( )
   {
   }

   public gamwwuserpermissions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwuserpermissions.class ));
   }

   public gamwwuserpermissions( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwuserpermissions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwuserpermissions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_UserPermissions";
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
      return "gamwwuserpermissions_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

