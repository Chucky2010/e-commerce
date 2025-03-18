package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.empresawwexportreport", "/com.mujermorena.empresawwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class empresawwexportreport extends GXWebObjectStub
{
   public empresawwexportreport( )
   {
   }

   public empresawwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresawwexportreport.class ));
   }

   public empresawwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresawwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresawwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresa WWExport Report";
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

