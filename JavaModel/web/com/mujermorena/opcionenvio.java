package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.opcionenvio", "/com.mujermorena.opcionenvio"})
@jakarta.servlet.annotation.MultipartConfig
public final  class opcionenvio extends GXWebObjectStub
{
   public opcionenvio( )
   {
   }

   public opcionenvio( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( opcionenvio.class ));
   }

   public opcionenvio( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new opcionenvio_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new opcionenvio_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Opcion Envio";
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
      return "opcionenvio_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

