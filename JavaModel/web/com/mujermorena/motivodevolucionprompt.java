package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.motivodevolucionprompt", "/com.mujermorena.motivodevolucionprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class motivodevolucionprompt extends GXWebObjectStub
{
   public motivodevolucionprompt( )
   {
   }

   public motivodevolucionprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivodevolucionprompt.class ));
   }

   public motivodevolucionprompt( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivodevolucionprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivodevolucionprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Motivo Devolucion";
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
      return "motivodevolucionprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

