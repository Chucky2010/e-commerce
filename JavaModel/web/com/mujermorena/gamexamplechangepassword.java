package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexamplechangepassword", "/com.mujermorena.gamexamplechangepassword"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexamplechangepassword extends GXWebObjectStub
{
   public gamexamplechangepassword( )
   {
   }

   public gamexamplechangepassword( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexamplechangepassword.class ));
   }

   public gamexamplechangepassword( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexamplechangepassword_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexamplechangepassword_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Change password";
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

