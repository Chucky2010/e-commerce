package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwapppermissions", "/com.mujermorena.gamwwapppermissions"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwapppermissions extends GXWebObjectStub
{
   public gamwwapppermissions( )
   {
   }

   public gamwwapppermissions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwapppermissions.class ));
   }

   public gamwwapppermissions( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwapppermissions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwapppermissions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_PermissionsApplication";
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
      return "gamwwapppermissions_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

