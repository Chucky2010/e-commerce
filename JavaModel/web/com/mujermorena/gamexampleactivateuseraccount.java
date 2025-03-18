package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexampleactivateuseraccount", "/com.mujermorena.gamexampleactivateuseraccount"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexampleactivateuseraccount extends GXWebObjectStub
{
   public gamexampleactivateuseraccount( )
   {
   }

   public gamexampleactivateuseraccount( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexampleactivateuseraccount.class ));
   }

   public gamexampleactivateuseraccount( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexampleactivateuseraccount_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexampleactivateuseraccount_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "GAM_Activate User Account";
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

