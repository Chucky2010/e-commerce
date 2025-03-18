package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge", "/com.mujermorena.workwithplus.nativemobile.wwpgetradialgauge"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetradialgauge extends GXWebObjectStub
{
   public wwpgetradialgauge( )
   {
   }

   public wwpgetradialgauge( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetradialgauge.class ));
   }

   public wwpgetradialgauge( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetradialgauge_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetradialgauge_impl(context).cleanup();
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        String[] aP6 )
   {
      new wwpgetradialgauge_impl(remoteHandle, context).execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 )
   {
      String[] aP6 = new String[] {""};
      execute(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public String getServletInfo( )
   {
      return "Get Radial Gauge Copy1";
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

