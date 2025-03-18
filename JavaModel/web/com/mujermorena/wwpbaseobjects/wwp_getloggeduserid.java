package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getloggeduserid extends GXProcedure
{
   public wwp_getloggeduserid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getloggeduserid.class ), "" );
   }

   public wwp_getloggeduserid( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      wwp_getloggeduserid.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      wwp_getloggeduserid.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8WWPUserExtendedId = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getid() ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_getloggeduserid.this.AV8WWPUserExtendedId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8WWPUserExtendedId = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8WWPUserExtendedId ;
   private String[] aP0 ;
}

