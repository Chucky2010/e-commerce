package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwauthtypes", "/com.mujermorena.gamwwauthtypes"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwauthtypes extends GXWebObjectStub
{
   public gamwwauthtypes( )
   {
   }

   public gamwwauthtypes( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwauthtypes.class ));
   }

   public gamwwauthtypes( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwauthtypes_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwauthtypes_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_AuthenticationTypes";
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
      return "gamwwauthtypes_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

