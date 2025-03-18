package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.inventariowwexportreport", "/com.mujermorena.inventariowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class inventariowwexportreport extends GXWebObjectStub
{
   public inventariowwexportreport( )
   {
   }

   public inventariowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( inventariowwexportreport.class ));
   }

   public inventariowwexportreport( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new inventariowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new inventariowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Inventario WWExport Report";
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

