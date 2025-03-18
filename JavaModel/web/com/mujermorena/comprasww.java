package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.comprasww", "/com.mujermorena.comprasww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class comprasww extends GXWebObjectStub
{
   public comprasww( )
   {
   }

   public comprasww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( comprasww.class ));
   }

   public comprasww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new comprasww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new comprasww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Compras";
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
      return "comprasww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

