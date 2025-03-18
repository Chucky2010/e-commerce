package com.mujermorena.wwpbaseobjects.sms ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.sms.wwp_sms", "/com.mujermorena.wwpbaseobjects.sms.wwp_sms"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_sms extends GXWebObjectStub
{
   public wwp_sms( )
   {
   }

   public wwp_sms( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_sms.class ));
   }

   public wwp_sms( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_sms_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_sms_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_SMS";
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
      return "sms_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

