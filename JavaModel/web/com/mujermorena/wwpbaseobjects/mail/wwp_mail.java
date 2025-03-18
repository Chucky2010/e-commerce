package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.mail.wwp_mail", "/com.mujermorena.wwpbaseobjects.mail.wwp_mail"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_mail extends GXWebObjectStub
{
   public wwp_mail( )
   {
   }

   public wwp_mail( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_mail.class ));
   }

   public wwp_mail( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_mail_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_mail_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Mail";
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
      return "wwpmail_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

