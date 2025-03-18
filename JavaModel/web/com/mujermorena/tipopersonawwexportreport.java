package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopersonawwexportreport", "/com.mujermorena.tipopersonawwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopersonawwexportreport extends GXWebObjectStub
{
   public tipopersonawwexportreport( )
   {
   }

   public tipopersonawwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopersonawwexportreport.class ));
   }

   public tipopersonawwexportreport( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopersonawwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopersonawwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Persona WWExport Report";
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

