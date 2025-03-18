package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.masterpageframe", "/com.mujermorena.wwpbaseobjects.masterpageframe"})
@jakarta.servlet.annotation.MultipartConfig
public final  class masterpageframe extends GXWebObjectStub
{
   public masterpageframe( )
   {
   }

   public masterpageframe( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( masterpageframe.class ));
   }

   public masterpageframe( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new masterpageframe_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new masterpageframe_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Master Page Frame";
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

