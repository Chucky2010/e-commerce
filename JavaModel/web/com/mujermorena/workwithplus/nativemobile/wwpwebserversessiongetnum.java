package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpwebserversessiongetnum", "/com.mujermorena.workwithplus.nativemobile.wwpwebserversessiongetnum"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpwebserversessiongetnum extends GXWebObjectStub
{
   public wwpwebserversessiongetnum( )
   {
   }

   public wwpwebserversessiongetnum( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpwebserversessiongetnum.class ));
   }

   public wwpwebserversessiongetnum( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpwebserversessiongetnum_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpwebserversessiongetnum_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        java.math.BigDecimal[] aP1 )
   {
      new wwpwebserversessiongetnum_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 )
   {
      java.math.BigDecimal[] aP1 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Web Server Session Get Num";
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

