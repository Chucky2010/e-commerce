package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.wwp_masterpagetopactionswc", "/com.mujermorena.wwpbaseobjects.wwp_masterpagetopactionswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_masterpagetopactionswc extends GXWebObjectStub
{
   public wwp_masterpagetopactionswc( )
   {
   }

   public wwp_masterpagetopactionswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_masterpagetopactionswc.class ));
   }

   public wwp_masterpagetopactionswc( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_masterpagetopactionswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_masterpagetopactionswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Master Page Top Actions WC";
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

