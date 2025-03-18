package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopersonaprompt", "/com.mujermorena.tipopersonaprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopersonaprompt extends GXWebObjectStub
{
   public tipopersonaprompt( )
   {
   }

   public tipopersonaprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopersonaprompt.class ));
   }

   public tipopersonaprompt( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopersonaprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopersonaprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Tipo Persona";
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
      return "tipopersonaprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

