package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.promptmasterpage", "/com.mujermorena.promptmasterpage"})
@jakarta.servlet.annotation.MultipartConfig
public final  class promptmasterpage extends GXWebObjectStub
{
   public promptmasterpage( )
   {
   }

   public promptmasterpage( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( promptmasterpage.class ));
   }

   public promptmasterpage( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new promptmasterpage_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new promptmasterpage_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Prompt Master Page ";
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

