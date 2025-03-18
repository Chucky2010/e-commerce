package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.recentlinks", "/com.mujermorena.recentlinks"})
@jakarta.servlet.annotation.MultipartConfig
public final  class recentlinks extends GXWebObjectStub
{
   public recentlinks( )
   {
   }

   public recentlinks( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( recentlinks.class ));
   }

   public recentlinks( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new recentlinks_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new recentlinks_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Recent Links web component";
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

