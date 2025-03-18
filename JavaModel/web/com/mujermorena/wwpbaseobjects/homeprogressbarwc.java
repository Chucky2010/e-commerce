package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.homeprogressbarwc", "/com.mujermorena.wwpbaseobjects.homeprogressbarwc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class homeprogressbarwc extends GXWebObjectStub
{
   public homeprogressbarwc( )
   {
   }

   public homeprogressbarwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( homeprogressbarwc.class ));
   }

   public homeprogressbarwc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new homeprogressbarwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new homeprogressbarwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Home Progress Bar WC";
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

