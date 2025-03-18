package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.motivodevoluciongeneral", "/com.mujermorena.motivodevoluciongeneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class motivodevoluciongeneral extends GXWebObjectStub
{
   public motivodevoluciongeneral( )
   {
   }

   public motivodevoluciongeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivodevoluciongeneral.class ));
   }

   public motivodevoluciongeneral( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivodevoluciongeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivodevoluciongeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Devolucion General";
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

