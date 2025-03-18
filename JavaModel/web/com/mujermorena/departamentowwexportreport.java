package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.departamentowwexportreport", "/com.mujermorena.departamentowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class departamentowwexportreport extends GXWebObjectStub
{
   public departamentowwexportreport( )
   {
   }

   public departamentowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( departamentowwexportreport.class ));
   }

   public departamentowwexportreport( int remoteHandle ,
                                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new departamentowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new departamentowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Departamento WWExport Report";
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

