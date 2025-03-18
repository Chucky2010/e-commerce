package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.empresageneral", "/com.mujermorena.empresageneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class empresageneral extends GXWebObjectStub
{
   public empresageneral( )
   {
   }

   public empresageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresageneral.class ));
   }

   public empresageneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa General";
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

