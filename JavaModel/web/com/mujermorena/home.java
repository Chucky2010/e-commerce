package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.home", "/com.mujermorena.home"})
@jakarta.servlet.annotation.MultipartConfig
public final  class home extends GXWebObjectStub
{
   public home( )
   {
   }

   public home( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( home.class ));
   }

   public home( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.mujermorena.GXcfg.class);
      com.mujermorena.home_impl pgm = new com.mujermorena.home_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXStaticWebPanel.copyFiles();
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new home_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new home_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_HomeTitle";
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

