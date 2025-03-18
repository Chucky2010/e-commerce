package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwrolepermissions", "/com.mujermorena.gamwwrolepermissions"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwrolepermissions extends GXWebObjectStub
{
   public gamwwrolepermissions( )
   {
   }

   public gamwwrolepermissions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwrolepermissions.class ));
   }

   public gamwwrolepermissions( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwrolepermissions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwrolepermissions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_RolePermissions";
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
      return "gamwwrolepermissions_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

