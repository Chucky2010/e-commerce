package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.calificacionwwexportreport", "/com.mujermorena.calificacionwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class calificacionwwexportreport extends GXWebObjectStub
{
   public calificacionwwexportreport( )
   {
   }

   public calificacionwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calificacionwwexportreport.class ));
   }

   public calificacionwwexportreport( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calificacionwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calificacionwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calificacion WWExport Report";
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

