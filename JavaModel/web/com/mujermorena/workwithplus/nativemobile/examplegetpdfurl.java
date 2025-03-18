package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.examplegetpdfurl", "/com.mujermorena.workwithplus.nativemobile.examplegetpdfurl"})
@jakarta.servlet.annotation.MultipartConfig
public final  class examplegetpdfurl extends GXWebObjectStub
{
   public examplegetpdfurl( )
   {
   }

   public examplegetpdfurl( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( examplegetpdfurl.class ));
   }

   public examplegetpdfurl( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new examplegetpdfurl_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new examplegetpdfurl_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      new examplegetpdfurl_impl(remoteHandle, context).execute_int(aP0, aP1, aP2);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             short aP1 )
   {
      String[] aP2 = new String[] {""};
      execute(aP0, aP1, aP2);
      return aP2[0];
   }

   public String getServletInfo( )
   {
      return "Example Get PDFUrl";
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

