package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_checkuserisnotunsubscribed extends GXProcedure
{
   public wwp_checkuserisnotunsubscribed( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_checkuserisnotunsubscribed.class ), "" );
   }

   public wwp_checkuserisnotunsubscribed( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( long aP0 ,
                              long[] aP1 )
   {
      wwp_checkuserisnotunsubscribed.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( long aP0 ,
                        long[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             long[] aP1 ,
                             boolean[] aP2 )
   {
      wwp_checkuserisnotunsubscribed.this.AV9WWPNotificationDefinitionId = aP0;
      wwp_checkuserisnotunsubscribed.this.AV10WWPSubscriptionId = aP1[0];
      this.aP1 = aP1;
      wwp_checkuserisnotunsubscribed.this.AV8IncludeNotification = aP2[0];
      this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /* Using cursor P002T2 */
      pr_default.execute(0, new Object[] {AV14Udparg1, Long.valueOf(AV9WWPNotificationDefinitionId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A152WWPSubscriptionSubscribed = P002T2_A152WWPSubscriptionSubscribed[0] ;
         A32WWPUserExtendedId = P002T2_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = P002T2_n32WWPUserExtendedId[0] ;
         A35WWPNotificationDefinitionId = P002T2_A35WWPNotificationDefinitionId[0] ;
         A34WWPSubscriptionId = P002T2_A34WWPSubscriptionId[0] ;
         AV8IncludeNotification = false ;
         AV10WWPSubscriptionId = A34WWPSubscriptionId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_checkuserisnotunsubscribed.this.AV10WWPSubscriptionId;
      this.aP2[0] = wwp_checkuserisnotunsubscribed.this.AV8IncludeNotification;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Udparg1 = "" ;
      scmdbuf = "" ;
      P002T2_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      P002T2_A32WWPUserExtendedId = new String[] {""} ;
      P002T2_n32WWPUserExtendedId = new boolean[] {false} ;
      P002T2_A35WWPNotificationDefinitionId = new long[1] ;
      P002T2_A34WWPSubscriptionId = new long[1] ;
      A32WWPUserExtendedId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_checkuserisnotunsubscribed__default(),
         new Object[] {
             new Object[] {
            P002T2_A152WWPSubscriptionSubscribed, P002T2_A32WWPUserExtendedId, P002T2_n32WWPUserExtendedId, P002T2_A35WWPNotificationDefinitionId, P002T2_A34WWPSubscriptionId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV9WWPNotificationDefinitionId ;
   private long AV10WWPSubscriptionId ;
   private long A35WWPNotificationDefinitionId ;
   private long A34WWPSubscriptionId ;
   private String AV14Udparg1 ;
   private String scmdbuf ;
   private String A32WWPUserExtendedId ;
   private boolean AV8IncludeNotification ;
   private boolean A152WWPSubscriptionSubscribed ;
   private boolean n32WWPUserExtendedId ;
   private boolean[] aP2 ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P002T2_A152WWPSubscriptionSubscribed ;
   private String[] P002T2_A32WWPUserExtendedId ;
   private boolean[] P002T2_n32WWPUserExtendedId ;
   private long[] P002T2_A35WWPNotificationDefinitionId ;
   private long[] P002T2_A34WWPSubscriptionId ;
}

final  class wwp_checkuserisnotunsubscribed__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002T2", "SELECT TOP 1 [WWPSubscriptionSubscribed], [WWPUserExtendedId], [WWPNotificationDefinitionId], [WWPSubscriptionId] FROM [WWP_Subscription] WHERE ([WWPUserExtendedId] = ?) AND ([WWPNotificationDefinitionId] = ?) AND ([WWPSubscriptionSubscribed] = 0) ORDER BY [WWPUserExtendedId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((long[]) buf[3])[0] = rslt.getLong(3);
               ((long[]) buf[4])[0] = rslt.getLong(4);
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
               stmt.setString(1, (String)parms[0], 40);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

