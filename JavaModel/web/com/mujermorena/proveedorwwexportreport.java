package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.proveedorwwexportreport", "/com.mujermorena.proveedorwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class proveedorwwexportreport extends GXWebObjectStub
{
   public proveedorwwexportreport( )
   {
   }

   public proveedorwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( proveedorwwexportreport.class ));
   }

   public proveedorwwexportreport( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new proveedorwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new proveedorwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Proveedor WWExport Report";
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

