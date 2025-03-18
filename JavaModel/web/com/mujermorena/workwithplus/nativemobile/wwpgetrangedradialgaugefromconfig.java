package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetrangedradialgaugefromconfig", "/com.mujermorena.workwithplus.nativemobile.wwpgetrangedradialgaugefromconfig"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetrangedradialgaugefromconfig extends GXWebObjectStub
{
   public wwpgetrangedradialgaugefromconfig( )
   {
   }

   public wwpgetrangedradialgaugefromconfig( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetrangedradialgaugefromconfig.class ));
   }

   public wwpgetrangedradialgaugefromconfig( int remoteHandle ,
                                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetrangedradialgaugefromconfig_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetrangedradialgaugefromconfig_impl(context).cleanup();
   }

   public void execute( com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig aP0 ,
                        String[] aP1 )
   {
      new wwpgetrangedradialgaugefromconfig_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( com.mujermorena.workwithplus.nativemobile.SdtRangedRadialGaugeConfig aP0 )
   {
      String[] aP1 = new String[] {""};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Get Ranged Radial Gauge From Config";
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

