package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.wwpbaseobjects.workwithplusmasterpageempty", "/com.mujermorena.wwpbaseobjects.workwithplusmasterpageempty"})
@jakarta.servlet.annotation.MultipartConfig
public final  class workwithplusmasterpageempty extends GXWebObjectStub
{
   public workwithplusmasterpageempty( )
   {
   }

   public workwithplusmasterpageempty( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( workwithplusmasterpageempty.class ));
   }

   public workwithplusmasterpageempty( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new workwithplusmasterpageempty_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new workwithplusmasterpageempty_impl(context).cleanup();
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

