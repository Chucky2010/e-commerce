package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.usuariowwexportreport", "/com.mujermorena.usuariowwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class usuariowwexportreport extends GXWebObjectStub
{
   public usuariowwexportreport( )
   {
   }

   public usuariowwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( usuariowwexportreport.class ));
   }

   public usuariowwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new usuariowwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new usuariowwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Usuario WWExport Report";
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

