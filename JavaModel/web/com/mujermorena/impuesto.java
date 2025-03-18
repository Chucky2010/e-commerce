package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuesto", "/com.mujermorena.impuesto"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuesto extends GXWebObjectStub
{
   public impuesto( )
   {
   }

   public impuesto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuesto.class ));
   }

   public impuesto( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuesto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuesto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Impuesto";
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
      return "impuesto_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

