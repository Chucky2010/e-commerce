package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwappmenus", "/com.mujermorena.gamwwappmenus"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwappmenus extends GXWebObjectStub
{
   public gamwwappmenus( )
   {
   }

   public gamwwappmenus( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwappmenus.class ));
   }

   public gamwwappmenus( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwappmenus_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwappmenus_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_MenusApplication";
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
      return "gamwwappmenus_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

