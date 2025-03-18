package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stock", "/com.mujermorena.stock"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stock extends GXWebObjectStub
{
   public stock( )
   {
   }

   public stock( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stock.class ));
   }

   public stock( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stock_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stock_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Stock";
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
      return "stock_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

