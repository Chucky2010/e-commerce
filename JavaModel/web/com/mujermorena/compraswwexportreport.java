package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.compraswwexportreport", "/com.mujermorena.compraswwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class compraswwexportreport extends GXWebObjectStub
{
   public compraswwexportreport( )
   {
   }

   public compraswwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( compraswwexportreport.class ));
   }

   public compraswwexportreport( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new compraswwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new compraswwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Compras WWExport Report";
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

