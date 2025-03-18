package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamsetpassword", "/com.mujermorena.gamsetpassword"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamsetpassword extends GXWebObjectStub
{
   public gamsetpassword( )
   {
   }

   public gamsetpassword( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamsetpassword.class ));
   }

   public gamsetpassword( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamsetpassword_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamsetpassword_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_GAM_SetNewPassword";
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
      return "gamsetpassword_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

