package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamappmenuentry", "/com.mujermorena.gamappmenuentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamappmenuentry extends GXWebObjectStub
{
   public gamappmenuentry( )
   {
   }

   public gamappmenuentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamappmenuentry.class ));
   }

   public gamappmenuentry( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamappmenuentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamappmenuentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_AppMenuEntry";
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
      return "gamappmenuentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

