package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.cajawwexportreport", "/com.mujermorena.cajawwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class cajawwexportreport extends GXWebObjectStub
{
   public cajawwexportreport( )
   {
   }

   public cajawwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( cajawwexportreport.class ));
   }

   public cajawwexportreport( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new cajawwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new cajawwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Caja WWExport Report";
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

