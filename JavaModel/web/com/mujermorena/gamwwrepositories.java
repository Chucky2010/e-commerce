package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwrepositories", "/com.mujermorena.gamwwrepositories"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwrepositories extends GXWebObjectStub
{
   public gamwwrepositories( )
   {
   }

   public gamwwrepositories( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwrepositories.class ));
   }

   public gamwwrepositories( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwrepositories_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwrepositories_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_Repositories";
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
      return "gamwwrepositories_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

