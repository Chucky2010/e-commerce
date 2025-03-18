package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuestoww", "/com.mujermorena.impuestoww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuestoww extends GXWebObjectStub
{
   public impuestoww( )
   {
   }

   public impuestoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuestoww.class ));
   }

   public impuestoww( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuestoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuestoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Impuesto";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "impuestoww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

