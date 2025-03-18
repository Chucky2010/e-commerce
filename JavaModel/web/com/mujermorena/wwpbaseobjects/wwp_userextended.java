package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.wwp_userextended", "/com.mujermorena.wwpbaseobjects.wwp_userextended"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_userextended extends GXWebObjectStub
{
   public wwp_userextended( )
   {
   }

   public wwp_userextended( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_userextended.class ));
   }

   public wwp_userextended( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_userextended_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_userextended_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Extended User from GAMUser";
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
      return "wwpuserextended_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

