package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stockdetalleprompt", "/com.mujermorena.stockdetalleprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stockdetalleprompt extends GXWebObjectStub
{
   public stockdetalleprompt( )
   {
   }

   public stockdetalleprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stockdetalleprompt.class ));
   }

   public stockdetalleprompt( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stockdetalleprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stockdetalleprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Detalle";
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
      return "stockdetalleprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

