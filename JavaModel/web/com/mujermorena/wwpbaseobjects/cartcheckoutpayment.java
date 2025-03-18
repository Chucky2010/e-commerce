package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.cartcheckoutpayment", "/com.mujermorena.wwpbaseobjects.cartcheckoutpayment"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cartcheckoutpayment extends GXWebObjectStub
{
   public cartcheckoutpayment( )
   {
   }

   public cartcheckoutpayment( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cartcheckoutpayment.class ));
   }

   public cartcheckoutpayment( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cartcheckoutpayment_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cartcheckoutpayment_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cart Checkout Payment";
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

