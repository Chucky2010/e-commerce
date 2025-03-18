package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamappmenuoptionentry", "/com.mujermorena.gamappmenuoptionentry"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamappmenuoptionentry extends GXWebObjectStub
{
   public gamappmenuoptionentry( )
   {
   }

   public gamappmenuoptionentry( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamappmenuoptionentry.class ));
   }

   public gamappmenuoptionentry( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamappmenuoptionentry_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamappmenuoptionentry_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_MenuOption";
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
      return "gamappmenuoptionentry_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

