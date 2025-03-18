package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devicesprompt", "/com.mujermorena.devicesprompt"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devicesprompt extends GXWebObjectStub
{
   public devicesprompt( )
   {
   }

   public devicesprompt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devicesprompt.class ));
   }

   public devicesprompt( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devicesprompt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devicesprompt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Selecciona Devices";
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
      return "devicesprompt_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

