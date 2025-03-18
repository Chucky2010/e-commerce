package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.appmasterpage", "/com.mujermorena.appmasterpage"})
@jakarta.servlet.annotation.MultipartConfig
public final  class appmasterpage extends GXWebObjectStub
{
   public appmasterpage( )
   {
   }

   public appmasterpage( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( appmasterpage.class ));
   }

   public appmasterpage( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new appmasterpage_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new appmasterpage_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Application Master Page ";
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

