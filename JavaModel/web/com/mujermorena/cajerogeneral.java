package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajerogeneral", "/com.mujermorena.cajerogeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajerogeneral extends GXWebObjectStub
{
   public cajerogeneral( )
   {
   }

   public cajerogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajerogeneral.class ));
   }

   public cajerogeneral( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajerogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajerogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cajero General";
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

