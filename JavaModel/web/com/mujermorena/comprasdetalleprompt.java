package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.comprasdetalleprompt", "/com.mujermorena.comprasdetalleprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class comprasdetalleprompt extends GXWebObjectStub
{
   public comprasdetalleprompt( )
   {
   }

   public comprasdetalleprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( comprasdetalleprompt.class ));
   }

   public comprasdetalleprompt( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new comprasdetalleprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new comprasdetalleprompt_impl(context).cleanup();
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
      return "comprasdetalleprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

