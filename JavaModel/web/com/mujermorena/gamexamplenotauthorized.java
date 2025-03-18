package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexamplenotauthorized", "/com.mujermorena.gamexamplenotauthorized"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexamplenotauthorized extends GXWebObjectStub
{
   public gamexamplenotauthorized( )
   {
   }

   public gamexamplenotauthorized( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexamplenotauthorized.class ));
   }

   public gamexamplenotauthorized( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexamplenotauthorized_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexamplenotauthorized_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Not Authorized";
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

