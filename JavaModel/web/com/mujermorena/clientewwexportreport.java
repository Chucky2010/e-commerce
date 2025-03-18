package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.clientewwexportreport", "/com.mujermorena.clientewwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class clientewwexportreport extends GXWebObjectStub
{
   public clientewwexportreport( )
   {
   }

   public clientewwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientewwexportreport.class ));
   }

   public clientewwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientewwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientewwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Cliente WWExport Report";
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

