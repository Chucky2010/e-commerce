package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartpaymentmethodssetselected extends GXProcedure
{
   public nmcartpaymentmethodssetselected( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartpaymentmethodssetselected.class ), "" );
   }

   public nmcartpaymentmethodssetselected( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String aP0 )
   {
      nmcartpaymentmethodssetselected.this.AV8Selected = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new com.mujermorena.workwithplus.nativemobile.wwpwebserversessionset(remoteHandle, context).execute( "SelectedPayment", AV8Selected) ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8Selected ;
}

