package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuestowwexportreport", "/com.mujermorena.impuestowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuestowwexportreport extends GXWebObjectStub
{
   public impuestowwexportreport( )
   {
   }

   public impuestowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuestowwexportreport.class ));
   }

   public impuestowwexportreport( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuestowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuestowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Impuesto WWExport Report";
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

