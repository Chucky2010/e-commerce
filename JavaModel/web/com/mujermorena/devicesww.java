package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.devicesww", "/com.mujermorena.devicesww"})
@jakarta.servlet.annotation.MultipartConfig
public final  class devicesww extends GXWebObjectStub
{
   public devicesww( )
   {
   }

   public devicesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( devicesww.class ));
   }

   public devicesww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new devicesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new devicesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Devices";
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
      return "devicesww_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

