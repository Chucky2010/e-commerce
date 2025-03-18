package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwp_cartdetaildropdown", "/com.mujermorena.wwp_cartdetaildropdown"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwp_cartdetaildropdown extends GXWebObjectStub
{
   public wwp_cartdetaildropdown( )
   {
   }

   public wwp_cartdetaildropdown( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_cartdetaildropdown.class ));
   }

   public wwp_cartdetaildropdown( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_cartdetaildropdown_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_cartdetaildropdown_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Cart Detail Drop Down";
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

