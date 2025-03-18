package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage", "/com.mujermorena.workwithplus.nativemobile.wwpgetlineargaugeconfigfrompercentage"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetlineargaugeconfigfrompercentage extends GXWebObjectStub
{
   public wwpgetlineargaugeconfigfrompercentage( )
   {
   }

   public wwpgetlineargaugeconfigfrompercentage( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetlineargaugeconfigfrompercentage.class ));
   }

   public wwpgetlineargaugeconfigfrompercentage( int remoteHandle ,
                                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetlineargaugeconfigfrompercentage_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetlineargaugeconfigfrompercentage_impl(context).cleanup();
   }

   public void execute( short aP0 ,
                        String[] aP1 )
   {
      new wwpgetlineargaugeconfigfrompercentage_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 )
   {
      String[] aP1 = new String[] {""};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Get Linear Gauge Config From Percentage";
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

