package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetcalendardate", "/com.mujermorena.workwithplus.nativemobile.wwpgetcalendardate"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetcalendardate extends GXWebObjectStub
{
   public wwpgetcalendardate( )
   {
   }

   public wwpgetcalendardate( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetcalendardate.class ));
   }

   public wwpgetcalendardate( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetcalendardate_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetcalendardate_impl(context).cleanup();
   }

   public void execute( java.util.Date aP0 ,
                        String[] aP1 )
   {
      new wwpgetcalendardate_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.util.Date aP0 )
   {
      String[] aP1 = new String[] {""};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Get Calendar Date";
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

