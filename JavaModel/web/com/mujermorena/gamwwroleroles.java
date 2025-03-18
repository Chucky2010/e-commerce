package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamwwroleroles", "/com.mujermorena.gamwwroleroles"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamwwroleroles extends GXWebObjectStub
{
   public gamwwroleroles( )
   {
   }

   public gamwwroleroles( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamwwroleroles.class ));
   }

   public gamwwroleroles( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamwwroleroles_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamwwroleroles_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_RolesRole";
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
      return "gamwwroleroles_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

