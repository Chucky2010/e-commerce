package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr", "/com.mujermorena.workwithplus.nativemobile.wwpgetcalendardatefromnr"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetcalendardatefromnr extends GXWebObjectStub
{
   public wwpgetcalendardatefromnr( )
   {
   }

   public wwpgetcalendardatefromnr( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetcalendardatefromnr.class ));
   }

   public wwpgetcalendardatefromnr( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetcalendardatefromnr_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetcalendardatefromnr_impl(context).cleanup();
   }

   public void execute( short aP0 ,
                        byte aP1 ,
                        byte aP2 ,
                        String[] aP3 )
   {
      new wwpgetcalendardatefromnr_impl(remoteHandle, context).execute_int(aP0, aP1, aP2, aP3);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             byte aP1 ,
                             byte aP2 )
   {
      String[] aP3 = new String[] {""};
      execute(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public String getServletInfo( )
   {
      return "Get Calendar Date From Nr";
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

