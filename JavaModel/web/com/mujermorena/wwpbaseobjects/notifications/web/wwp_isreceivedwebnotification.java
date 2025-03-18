package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_isreceivedwebnotification extends GXProcedure
{
   public wwp_isreceivedwebnotification( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_isreceivedwebnotification.class ), "" );
   }

   public wwp_isreceivedwebnotification( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( long aP0 )
   {
      wwp_isreceivedwebnotification.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( long aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( long aP0 ,
                             boolean[] aP1 )
   {
      wwp_isreceivedwebnotification.this.AV8WebNotificationId = aP0;
      wwp_isreceivedwebnotification.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9IsRecived = false ;
      /* Using cursor P00372 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8WebNotificationId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38WWPWebNotificationId = P00372_A38WWPWebNotificationId[0] ;
         A179WWPWebNotificationReceived = P00372_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = P00372_n179WWPWebNotificationReceived[0] ;
         if ( A179WWPWebNotificationReceived )
         {
            AV9IsRecived = true ;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_isreceivedwebnotification.this.AV9IsRecived;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00372_A38WWPWebNotificationId = new long[1] ;
      P00372_A179WWPWebNotificationReceived = new boolean[] {false} ;
      P00372_n179WWPWebNotificationReceived = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_isreceivedwebnotification__default(),
         new Object[] {
             new Object[] {
            P00372_A38WWPWebNotificationId, P00372_A179WWPWebNotificationReceived, P00372_n179WWPWebNotificationReceived
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV8WebNotificationId ;
   private long A38WWPWebNotificationId ;
   private String scmdbuf ;
   private boolean AV9IsRecived ;
   private boolean A179WWPWebNotificationReceived ;
   private boolean n179WWPWebNotificationReceived ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P00372_A38WWPWebNotificationId ;
   private boolean[] P00372_A179WWPWebNotificationReceived ;
   private boolean[] P00372_n179WWPWebNotificationReceived ;
}

final  class wwp_isreceivedwebnotification__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00372", "SELECT TOP 1 [WWPWebNotificationId], [WWPWebNotificationReceived] FROM [WWP_WebNotification] WHERE [WWPWebNotificationId] = ? ORDER BY [WWPWebNotificationId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

