package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamsecuritypolicyentry", "/com.mujermorena.gamsecuritypolicyentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamsecuritypolicyentry extends GXWebObjectStub
{
   public gamsecuritypolicyentry( )
   {
   }

   public gamsecuritypolicyentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamsecuritypolicyentry.class ));
   }

   public gamsecuritypolicyentry( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamsecuritypolicyentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamsecuritypolicyentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SecurityPolicy";
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
      return "gamsecuritypolicyentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

