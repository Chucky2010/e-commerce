package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.wizardstepslinewc", "/com.mujermorena.wwpbaseobjects.wizardstepslinewc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wizardstepslinewc extends GXWebObjectStub
{
   public wizardstepslinewc( )
   {
   }

   public wizardstepslinewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wizardstepslinewc.class ));
   }

   public wizardstepslinewc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wizardstepslinewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wizardstepslinewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Wizard Steps Bullet WC.";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

