package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex", "/com.mujermorena.workwithplus.nativemobile.wwpgetdecimalfromhex"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetdecimalfromhex extends GXWebObjectStub
{
   public wwpgetdecimalfromhex( )
   {
   }

   public wwpgetdecimalfromhex( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetdecimalfromhex.class ));
   }

   public wwpgetdecimalfromhex( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetdecimalfromhex_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetdecimalfromhex_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        int[] aP1 )
   {
      new wwpgetdecimalfromhex_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( String aP0 )
   {
      int[] aP1 = new int[] {0};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Get Decimal From Hex";
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

