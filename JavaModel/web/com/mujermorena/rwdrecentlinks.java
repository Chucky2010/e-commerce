package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.rwdrecentlinks", "/com.mujermorena.rwdrecentlinks"})
@jakarta.servlet.annotation.MultipartConfig
public final  class rwdrecentlinks extends GXWebObjectStub
{
   public rwdrecentlinks( )
   {
   }

   public rwdrecentlinks( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( rwdrecentlinks.class ));
   }

   public rwdrecentlinks( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new rwdrecentlinks_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new rwdrecentlinks_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Responsive Recent Links";
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

