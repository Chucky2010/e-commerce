package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tallawwexportreport", "/com.mujermorena.tallawwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tallawwexportreport extends GXWebObjectStub
{
   public tallawwexportreport( )
   {
   }

   public tallawwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tallawwexportreport.class ));
   }

   public tallawwexportreport( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tallawwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tallawwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Talla WWExport Report";
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

