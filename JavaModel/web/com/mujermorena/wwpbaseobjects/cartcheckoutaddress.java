package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.cartcheckoutaddress", "/com.mujermorena.wwpbaseobjects.cartcheckoutaddress"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cartcheckoutaddress extends GXWebObjectStub
{
   public cartcheckoutaddress( )
   {
   }

   public cartcheckoutaddress( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cartcheckoutaddress.class ));
   }

   public cartcheckoutaddress( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cartcheckoutaddress_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cartcheckoutaddress_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cart Checkout Address";
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

