package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipoarticulowwexportreport", "/com.mujermorena.tipoarticulowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipoarticulowwexportreport extends GXWebObjectStub
{
   public tipoarticulowwexportreport( )
   {
   }

   public tipoarticulowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoarticulowwexportreport.class ));
   }

   public tipoarticulowwexportreport( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoarticulowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoarticulowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Articulo WWExport Report";
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

