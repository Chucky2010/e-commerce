package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamrepositoryentry", "/com.mujermorena.gamrepositoryentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamrepositoryentry extends GXWebObjectStub
{
   public gamrepositoryentry( )
   {
   }

   public gamrepositoryentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamrepositoryentry.class ));
   }

   public gamrepositoryentry( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamrepositoryentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamrepositoryentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Repository ";
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
      return "gamrepositoryentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

