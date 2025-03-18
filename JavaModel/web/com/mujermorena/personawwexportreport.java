package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.personawwexportreport", "/com.mujermorena.personawwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class personawwexportreport extends GXWebObjectStub
{
   public personawwexportreport( )
   {
   }

   public personawwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( personawwexportreport.class ));
   }

   public personawwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new personawwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new personawwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Persona WWExport Report";
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

