package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.wwp_search", "/com.mujermorena.wwpbaseobjects.wwp_search"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_search extends GXWebObjectStub
{
   public wwp_search( )
   {
   }

   public wwp_search( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_search.class ));
   }

   public wwp_search( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_search_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_search_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Search results";
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
      return "wwp_search_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

