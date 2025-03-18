package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_setwebnotificationreceived extends GXProcedure
{
   public wwp_setwebnotificationreceived( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_setwebnotificationreceived.class ), "" );
   }

   public wwp_setwebnotificationreceived( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( long aP0 )
   {
      wwp_setwebnotificationreceived.this.AV8WebNotificationId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      n179WWPWebNotificationReceived = false ;
      /* Optimized UPDATE. */
      /* Using cursor P00382 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8WebNotificationId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
      /* End optimized UPDATE. */
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_setwebnotificationreceived");
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
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_setwebnotificationreceived__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_setwebnotificationreceived__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV8WebNotificationId ;
   private boolean n179WWPWebNotificationReceived ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
}

final  class wwp_setwebnotificationreceived__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public String getDataStoreName( )
   {
      return "GAM";
   }

}

final  class wwp_setwebnotificationreceived__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00382", "UPDATE [WWP_WebNotification] SET [WWPWebNotificationReceived]=CONVERT(BIT, 1)  WHERE [WWPWebNotificationId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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

