package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.paisgeneral", "/com.mujermorena.paisgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class paisgeneral extends GXWebObjectStub
{
   public paisgeneral( )
   {
   }

   public paisgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisgeneral.class ));
   }

   public paisgeneral( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais General";
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

