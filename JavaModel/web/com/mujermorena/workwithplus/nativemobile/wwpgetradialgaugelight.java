package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight", "/com.mujermorena.workwithplus.nativemobile.wwpgetradialgaugelight"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetradialgaugelight extends GXWebObjectStub
{
   public wwpgetradialgaugelight( )
   {
   }

   public wwpgetradialgaugelight( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetradialgaugelight.class ));
   }

   public wwpgetradialgaugelight( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetradialgaugelight_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetradialgaugelight_impl(context).cleanup();
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      new wwpgetradialgaugelight_impl(remoteHandle, context).execute_int(aP0, aP1, aP2);
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
      return "Get Radial Gauge Light";
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

