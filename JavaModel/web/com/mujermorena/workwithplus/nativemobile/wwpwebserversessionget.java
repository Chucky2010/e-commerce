package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpwebserversessionget", "/com.mujermorena.workwithplus.nativemobile.wwpwebserversessionget"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpwebserversessionget extends GXWebObjectStub
{
   public wwpwebserversessionget( )
   {
   }

   public wwpwebserversessionget( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpwebserversessionget.class ));
   }

   public wwpwebserversessionget( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpwebserversessionget_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpwebserversessionget_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      new wwpwebserversessionget_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      String[] aP1 = new String[] {""};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "WWPWeb Server Session Get";
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

