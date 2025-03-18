package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.ciudadwwexportreport", "/com.mujermorena.ciudadwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class ciudadwwexportreport extends GXWebObjectStub
{
   public ciudadwwexportreport( )
   {
   }

   public ciudadwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ciudadwwexportreport.class ));
   }

   public ciudadwwexportreport( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ciudadwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ciudadwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Ciudad WWExport Report";
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

