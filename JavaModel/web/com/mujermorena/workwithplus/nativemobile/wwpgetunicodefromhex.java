package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@jakarta.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex", "/com.mujermorena.workwithplus.nativemobile.wwpgetunicodefromhex"})
@jakarta.servlet.annotation.MultipartConfig
public final  class wwpgetunicodefromhex extends GXWebObjectStub
{
   public wwpgetunicodefromhex( )
   {
   }

   public wwpgetunicodefromhex( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwpgetunicodefromhex.class ));
   }

   public wwpgetunicodefromhex( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwpgetunicodefromhex_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwpgetunicodefromhex_impl(context).cleanup();
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      new wwpgetunicodefromhex_impl(remoteHandle, context).execute_int(aP0, aP1);
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      String[] aP1 = new String[] {""};
      execute(aP0, aP1);
      return aP1[0];
   }

   public String getServletInfo( )
   {
      return "Get Unicode From Hex";
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
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

