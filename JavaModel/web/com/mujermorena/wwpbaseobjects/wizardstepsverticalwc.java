package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.wizardstepsverticalwc", "/com.mujermorena.wwpbaseobjects.wizardstepsverticalwc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wizardstepsverticalwc extends GXWebObjectStub
{
   public wizardstepsverticalwc( )
   {
   }

   public wizardstepsverticalwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wizardstepsverticalwc.class ));
   }

   public wizardstepsverticalwc( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wizardstepsverticalwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wizardstepsverticalwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Wizard Steps Vertical WC";
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

