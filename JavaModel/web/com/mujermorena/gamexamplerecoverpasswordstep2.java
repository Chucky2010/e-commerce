package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexamplerecoverpasswordstep2", "/com.mujermorena.gamexamplerecoverpasswordstep2"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexamplerecoverpasswordstep2 extends GXWebObjectStub
{
   public gamexamplerecoverpasswordstep2( )
   {
   }

   public gamexamplerecoverpasswordstep2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexamplerecoverpasswordstep2.class ));
   }

   public gamexamplerecoverpasswordstep2( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexamplerecoverpasswordstep2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexamplerecoverpasswordstep2_impl(context).cleanup();
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

