package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.articulowwexportreport", "/com.mujermorena.articulowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class articulowwexportreport extends GXWebObjectStub
{
   public articulowwexportreport( )
   {
   }

   public articulowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( articulowwexportreport.class ));
   }

   public articulowwexportreport( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new articulowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new articulowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Articulo WWExport Report";
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

