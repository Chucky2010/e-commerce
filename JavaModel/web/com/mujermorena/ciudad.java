package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ciudad", "/com.mujermorena.ciudad"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ciudad extends GXWebObjectStub
{
   public ciudad( )
   {
   }

   public ciudad( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ciudad.class ));
   }

   public ciudad( int remoteHandle ,
                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ciudad_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ciudad_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ciudad";
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
      return "ciudad_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

