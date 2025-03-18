package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tallaww", "/com.mujermorena.tallaww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tallaww extends GXWebObjectStub
{
   public tallaww( )
   {
   }

   public tallaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tallaww.class ));
   }

   public tallaww( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tallaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tallaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Talla";
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
      return "tallaww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

