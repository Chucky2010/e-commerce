package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_changenotificationstatus extends GXProcedure
{
   public wwp_changenotificationstatus( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_changenotificationstatus.class ), "" );
   }

   public wwp_changenotificationstatus( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   public void gxep_setnotificationreadunreadbyid( long [] arr_AV8WWPNotificationId )
   {
      wwp_changenotificationstatus.this.AV8WWPNotificationId = arr_AV8WWPNotificationId[0];
      this.arr_AV8WWPNotificationId = arr_AV8WWPNotificationId;
      initialize();
      initialized = (short)(1) ;
      /* SetNotificationReadUnreadById Constructor */
      /* Using cursor P003I2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8WWPNotificationId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37WWPNotificationId = P003I2_A37WWPNotificationId[0] ;
         A203WWPNotificationIsRead = P003I2_A203WWPNotificationIsRead[0] ;
         if ( A203WWPNotificationIsRead )
         {
            A203WWPNotificationIsRead = false ;
         }
         else
         {
            A203WWPNotificationIsRead = true ;
         }
         /* Using cursor P003I3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A203WWPNotificationIsRead), Long.valueOf(A37WWPNotificationId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      privateExecute();
      this.arr_AV8WWPNotificationId[0] = wwp_changenotificationstatus.this.AV8WWPNotificationId;
      cleanup();
   }

   public void gxep_setnotificationreadbyid( long [] arr_AV8WWPNotificationId )
   {
      wwp_changenotificationstatus.this.AV8WWPNotificationId = arr_AV8WWPNotificationId[0];
      this.arr_AV8WWPNotificationId = arr_AV8WWPNotificationId;
      initialize();
      initialized = (short)(1) ;
      /* SetNotificationReadById Constructor */
      /* Optimized UPDATE. */
      /* Using cursor P003I4 */
      pr_default.execute(2, new Object[] {Long.valueOf(AV8WWPNotificationId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
      /* End optimized UPDATE. */
      privateExecute();
      this.arr_AV8WWPNotificationId[0] = wwp_changenotificationstatus.this.AV8WWPNotificationId;
      cleanup();
   }

   public void gxep_setallnotificationsofloggeduserread( )
   {
      initialize();
      initialized = (short)(1) ;
      /* SetAllNotificationsOfLoggedUserRead Constructor */
      AV14Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /* Optimized UPDATE. */
      /* Using cursor P003I5 */
      pr_default.execute(3, new Object[] {AV14Udparg1});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
      /* End optimized UPDATE. */
      privateExecute();
      cleanup();
   }

   protected void cleanup( )
   {
      if ( initialized != 1 )
      {
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_changenotificationstatus");
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
      P003I2_A37WWPNotificationId = new long[1] ;
      P003I2_A203WWPNotificationIsRead = new boolean[] {false} ;
      AV14Udparg1 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_changenotificationstatus__default(),
         new Object[] {
             new Object[] {
            P003I2_A37WWPNotificationId, P003I2_A203WWPNotificationIsRead
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short initialized ;
   private short Gx_err ;
   private long AV8WWPNotificationId ;
   private long A37WWPNotificationId ;
   private String scmdbuf ;
   private String AV14Udparg1 ;
   private boolean A203WWPNotificationIsRead ;
   private long[] arr_AV8WWPNotificationId ;
   private IDataStoreProvider pr_default ;
   private long[] P003I2_A37WWPNotificationId ;
   private boolean[] P003I2_A203WWPNotificationIsRead ;
}

final  class wwp_changenotificationstatus__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003I2", "SELECT [WWPNotificationId], [WWPNotificationIsRead] FROM [WWP_Notification] WITH (UPDLOCK) WHERE [WWPNotificationId] = ? ORDER BY [WWPNotificationId] ",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P003I3", "UPDATE [WWP_Notification] SET [WWPNotificationIsRead]=?  WHERE [WWPNotificationId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003I4", "UPDATE [WWP_Notification] SET [WWPNotificationIsRead]=CONVERT(BIT, 1)  WHERE [WWPNotificationId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P003I5", "UPDATE [WWP_Notification] SET [WWPNotificationIsRead]=CONVERT(BIT, 1)  WHERE [WWPUserExtendedId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
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
            case 1 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 40);
               return;
      }
   }

}

