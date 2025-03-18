package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.cartcheckoutcompleted", "/com.mujermorena.wwpbaseobjects.cartcheckoutcompleted"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cartcheckoutcompleted extends GXWebObjectStub
{
   public cartcheckoutcompleted( )
   {
   }

   public cartcheckoutcompleted( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cartcheckoutcompleted.class ));
   }

   public cartcheckoutcompleted( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cartcheckoutcompleted_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cartcheckoutcompleted_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cart Checkout Completed";
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

