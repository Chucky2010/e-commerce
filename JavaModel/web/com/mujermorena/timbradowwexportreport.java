package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.timbradowwexportreport", "/com.mujermorena.timbradowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class timbradowwexportreport extends GXWebObjectStub
{
   public timbradowwexportreport( )
   {
   }

   public timbradowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( timbradowwexportreport.class ));
   }

   public timbradowwexportreport( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new timbradowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new timbradowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Timbrado WWExport Report";
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

