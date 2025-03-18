package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.tallageneral", "/com.mujermorena.tallageneral"})
@jakarta.servlet.annotation.MultipartConfig
public final  class tallageneral extends GXWebObjectStub
{
   public tallageneral( )
   {
   }

   public tallageneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tallageneral.class ));
   }

   public tallageneral( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tallageneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tallageneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Talla General";
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

