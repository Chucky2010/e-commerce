package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.motivodevolucionwwexportreport", "/com.mujermorena.motivodevolucionwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class motivodevolucionwwexportreport extends GXWebObjectStub
{
   public motivodevolucionwwexportreport( )
   {
   }

   public motivodevolucionwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivodevolucionwwexportreport.class ));
   }

   public motivodevolucionwwexportreport( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivodevolucionwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivodevolucionwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Devolucion WWExport Report";
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

