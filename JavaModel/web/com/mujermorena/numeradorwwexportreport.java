package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.numeradorwwexportreport", "/com.mujermorena.numeradorwwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class numeradorwwexportreport extends GXWebObjectStub
{
   public numeradorwwexportreport( )
   {
   }

   public numeradorwwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( numeradorwwexportreport.class ));
   }

   public numeradorwwexportreport( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new numeradorwwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new numeradorwwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Numerador WWExport Report";
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

