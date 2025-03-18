package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.paiswwexportreport", "/com.mujermorena.paiswwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class paiswwexportreport extends GXWebObjectStub
{
   public paiswwexportreport( )
   {
   }

   public paiswwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paiswwexportreport.class ));
   }

   public paiswwexportreport( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paiswwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paiswwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Pais WWExport Report";
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

