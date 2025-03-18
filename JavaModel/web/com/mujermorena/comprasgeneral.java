package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.comprasgeneral", "/com.mujermorena.comprasgeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class comprasgeneral extends GXWebObjectStub
{
   public comprasgeneral( )
   {
   }

   public comprasgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( comprasgeneral.class ));
   }

   public comprasgeneral( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new comprasgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new comprasgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Compras General";
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

