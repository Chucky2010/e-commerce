package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.workwithplusmasterpage", "/com.mujermorena.wwpbaseobjects.workwithplusmasterpage"})
@jakarta.servlet.annotation.MultipartConfig
public final  class workwithplusmasterpage extends GXWebObjectStub
{
   public workwithplusmasterpage( )
   {
   }

   public workwithplusmasterpage( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( workwithplusmasterpage.class ));
   }

   public workwithplusmasterpage( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new workwithplusmasterpage_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new workwithplusmasterpage_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Master Page";
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

