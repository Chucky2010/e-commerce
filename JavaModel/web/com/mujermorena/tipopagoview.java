package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopagoview", "/com.mujermorena.tipopagoview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopagoview extends GXWebObjectStub
{
   public tipopagoview( )
   {
   }

   public tipopagoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopagoview.class ));
   }

   public tipopagoview( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopagoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopagoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Pago View";
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
      return "tipopagoview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

