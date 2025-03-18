package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.motivodevolucionview", "/com.mujermorena.motivodevolucionview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class motivodevolucionview extends GXWebObjectStub
{
   public motivodevolucionview( )
   {
   }

   public motivodevolucionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivodevolucionview.class ));
   }

   public motivodevolucionview( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivodevolucionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivodevolucionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Devolucion View";
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
      return "motivodevolucionview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

