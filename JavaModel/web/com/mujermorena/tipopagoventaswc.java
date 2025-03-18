package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopagoventaswc", "/com.mujermorena.tipopagoventaswc"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopagoventaswc extends GXWebObjectStub
{
   public tipopagoventaswc( )
   {
   }

   public tipopagoventaswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopagoventaswc.class ));
   }

   public tipopagoventaswc( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopagoventaswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopagoventaswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Pago Ventas WC";
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

