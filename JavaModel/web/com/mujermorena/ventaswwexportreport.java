package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ventaswwexportreport", "/com.mujermorena.ventaswwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ventaswwexportreport extends GXWebObjectStub
{
   public ventaswwexportreport( )
   {
   }

   public ventaswwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ventaswwexportreport.class ));
   }

   public ventaswwexportreport( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ventaswwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ventaswwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ventas WWExport Report";
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

