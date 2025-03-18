package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tipopagoprompt", "/com.mujermorena.tipopagoprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tipopagoprompt extends GXWebObjectStub
{
   public tipopagoprompt( )
   {
   }

   public tipopagoprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipopagoprompt.class ));
   }

   public tipopagoprompt( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipopagoprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipopagoprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Tipo Pago";
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
      return "tipopagoprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

