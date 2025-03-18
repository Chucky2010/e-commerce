package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.stockprompt", "/com.mujermorena.stockprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class stockprompt extends GXWebObjectStub
{
   public stockprompt( )
   {
   }

   public stockprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( stockprompt.class ));
   }

   public stockprompt( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new stockprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new stockprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Stock";
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
      return "stockprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

