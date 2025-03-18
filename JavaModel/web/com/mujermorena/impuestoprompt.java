package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.impuestoprompt", "/com.mujermorena.impuestoprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class impuestoprompt extends GXWebObjectStub
{
   public impuestoprompt( )
   {
   }

   public impuestoprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( impuestoprompt.class ));
   }

   public impuestoprompt( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new impuestoprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new impuestoprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Impuesto";
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
      return "impuestoprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

