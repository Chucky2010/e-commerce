package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.empresaww", "/com.mujermorena.empresaww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class empresaww extends GXWebObjectStub
{
   public empresaww( )
   {
   }

   public empresaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresaww.class ));
   }

   public empresaww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Empresa";
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
      return "empresaww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

