package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipoarticuloview", "/com.mujermorena.tipoarticuloview"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipoarticuloview extends GXWebObjectStub
{
   public tipoarticuloview( )
   {
   }

   public tipoarticuloview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoarticuloview.class ));
   }

   public tipoarticuloview( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoarticuloview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoarticuloview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Articulo View";
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
      return "tipoarticuloview_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

