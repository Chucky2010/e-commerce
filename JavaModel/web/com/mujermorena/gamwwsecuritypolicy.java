package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwsecuritypolicy", "/com.mujermorena.gamwwsecuritypolicy"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwsecuritypolicy extends GXWebObjectStub
{
   public gamwwsecuritypolicy( )
   {
   }

   public gamwwsecuritypolicy( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwsecuritypolicy.class ));
   }

   public gamwwsecuritypolicy( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwsecuritypolicy_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwsecuritypolicy_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SecurityPolicies";
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
      return "gamwwsecuritypolicy_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

