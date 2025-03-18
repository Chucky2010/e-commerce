package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.examplegetimagefrombase64", "/com.mujermorena.workwithplus.nativemobile.examplegetimagefrombase64"})
@jakarta.servlet.annotation.MultipartConfig
public final  class examplegetimagefrombase64 extends GXWebObjectStub
{
   public examplegetimagefrombase64( )
   {
   }

   public examplegetimagefrombase64( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( examplegetimagefrombase64.class ));
   }

   public examplegetimagefrombase64( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new examplegetimagefrombase64_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new examplegetimagefrombase64_impl(context).cleanup();
   }

   public void execute( String aP0 )
   {
      new examplegetimagefrombase64_impl(remoteHandle, context).execute_int(aP0);
   }

   public String getServletInfo( )
   {
      return "Get Image From Base64";
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
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

