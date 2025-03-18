package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.cartcheckoutplaceorder", "/com.mujermorena.wwpbaseobjects.cartcheckoutplaceorder"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cartcheckoutplaceorder extends GXWebObjectStub
{
   public cartcheckoutplaceorder( )
   {
   }

   public cartcheckoutplaceorder( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cartcheckoutplaceorder.class ));
   }

   public cartcheckoutplaceorder( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cartcheckoutplaceorder_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cartcheckoutplaceorder_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cart Checkout Place Order";
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

