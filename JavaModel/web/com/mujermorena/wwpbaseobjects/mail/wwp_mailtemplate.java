package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate", "/com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_mailtemplate extends GXWebObjectStub
{
   public wwp_mailtemplate( )
   {
   }

   public wwp_mailtemplate( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_mailtemplate.class ));
   }

   public wwp_mailtemplate( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_mailtemplate_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_mailtemplate_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Mail Template";
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
      return "wwpmailtemplate_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

