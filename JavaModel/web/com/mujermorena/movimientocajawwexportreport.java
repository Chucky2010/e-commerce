package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.movimientocajawwexportreport", "/com.mujermorena.movimientocajawwexportreport"})
@jakarta.servlet.annotation.MultipartConfig
public final  class movimientocajawwexportreport extends GXWebObjectStub
{
   public movimientocajawwexportreport( )
   {
   }

   public movimientocajawwexportreport( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( movimientocajawwexportreport.class ));
   }

   public movimientocajawwexportreport( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new movimientocajawwexportreport_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new movimientocajawwexportreport_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Movimiento Caja WWExport Report";
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

