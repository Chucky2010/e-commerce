package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.gamexampleotpauthentication", "/com.mujermorena.gamexampleotpauthentication"})
@jakarta.servlet.annotation.MultipartConfig
public final  class gamexampleotpauthentication extends GXWebObjectStub
{
   public gamexampleotpauthentication( )
   {
   }

   public gamexampleotpauthentication( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( gamexampleotpauthentication.class ));
   }

   public gamexampleotpauthentication( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new gamexampleotpauthentication_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new gamexampleotpauthentication_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "GAM_Auth OTP";
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

