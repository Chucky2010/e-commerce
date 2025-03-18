package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.departamentogeneral", "/com.mujermorena.departamentogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class departamentogeneral extends GXWebObjectStub
{
   public departamentogeneral( )
   {
   }

   public departamentogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( departamentogeneral.class ));
   }

   public departamentogeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new departamentogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new departamentogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Departamento General";
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

