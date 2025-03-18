package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.opcionenviowwexportreport", "/com.mujermorena.opcionenviowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class opcionenviowwexportreport extends GXWebObjectStub
{
   public opcionenviowwexportreport( )
   {
   }

   public opcionenviowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( opcionenviowwexportreport.class ));
   }

   public opcionenviowwexportreport( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new opcionenviowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new opcionenviowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Opcion Envio WWExport Report";
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

