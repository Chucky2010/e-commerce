package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexamplerecoverpasswordstep1", "/com.mujermorena.gamexamplerecoverpasswordstep1"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexamplerecoverpasswordstep1 extends GXWebObjectStub
{
   public gamexamplerecoverpasswordstep1( )
   {
   }

   public gamexamplerecoverpasswordstep1( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexamplerecoverpasswordstep1.class ));
   }

   public gamexamplerecoverpasswordstep1( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexamplerecoverpasswordstep1_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexamplerecoverpasswordstep1_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Recover Password";
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

