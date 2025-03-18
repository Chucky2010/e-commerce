package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.localidadwwexportreport", "/com.mujermorena.localidadwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class localidadwwexportreport extends GXWebObjectStub
{
   public localidadwwexportreport( )
   {
   }

   public localidadwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( localidadwwexportreport.class ));
   }

   public localidadwwexportreport( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new localidadwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new localidadwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Localidad WWExport Report";
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

