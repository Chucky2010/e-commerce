package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stockwwexportreport", "/com.mujermorena.stockwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stockwwexportreport extends GXWebObjectStub
{
   public stockwwexportreport( )
   {
   }

   public stockwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stockwwexportreport.class ));
   }

   public stockwwexportreport( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stockwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stockwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Stock WWExport Report";
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

