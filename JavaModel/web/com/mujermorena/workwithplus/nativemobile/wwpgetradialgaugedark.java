package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugedark", "/com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugedark"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetradialgaugedark extends GXWebObjectStub
{
   public wwpgetradialgaugedark( )
   {
   }

   public wwpgetradialgaugedark( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetradialgaugedark.class ));
   }

   public wwpgetradialgaugedark( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetradialgaugedark_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetradialgaugedark_impl(context).cleanup();
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      new wwpgetradialgaugedark_impl(remoteHandle, context).execute_int(aP0, aP1, aP2);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 )
   {
      String[] aP2 = new String[] {""};
      execute(aP0, aP1, aP2);
      return aP2[0];
   }

   public String getServletInfo( )
   {
      return "Get Radial Gauge Dark";
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

