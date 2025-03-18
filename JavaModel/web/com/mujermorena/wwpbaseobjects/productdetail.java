package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.productdetail", "/com.mujermorena.wwpbaseobjects.productdetail"})
@jakarta.servlet.annotation.MultipartConfig
public final  class productdetail extends GXWebObjectStub
{
   public productdetail( )
   {
   }

   public productdetail( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( productdetail.class ));
   }

   public productdetail( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.mujermorena.GXcfg.class);
      com.mujermorena.wwpbaseobjects.productdetail_impl pgm = new com.mujermorena.wwpbaseobjects.productdetail_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new productdetail_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new productdetail_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Product Detail";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
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

