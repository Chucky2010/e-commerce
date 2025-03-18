package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.usercustomizations", "/com.mujermorena.wwpbaseobjects.usercustomizations"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usercustomizations extends GXWebObjectStub
{
   public usercustomizations( )
   {
   }

   public usercustomizations( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usercustomizations.class ));
   }

   public usercustomizations( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usercustomizations_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usercustomizations_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "User Custom";
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
      return "usercustomizations_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

