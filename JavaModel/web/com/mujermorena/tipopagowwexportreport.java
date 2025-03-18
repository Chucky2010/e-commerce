package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopagowwexportreport", "/com.mujermorena.tipopagowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopagowwexportreport extends GXWebObjectStub
{
   public tipopagowwexportreport( )
   {
   }

   public tipopagowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopagowwexportreport.class ));
   }

   public tipopagowwexportreport( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopagowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopagowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Pago WWExport Report";
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

