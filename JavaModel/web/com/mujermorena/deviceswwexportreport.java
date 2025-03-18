package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.deviceswwexportreport", "/com.mujermorena.deviceswwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class deviceswwexportreport extends GXWebObjectStub
{
   public deviceswwexportreport( )
   {
   }

   public deviceswwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( deviceswwexportreport.class ));
   }

   public deviceswwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new deviceswwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new deviceswwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Devices WWExport Report";
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

