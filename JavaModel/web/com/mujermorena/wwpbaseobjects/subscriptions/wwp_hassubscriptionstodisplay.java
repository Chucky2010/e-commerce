package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_hassubscriptionstodisplay extends GXProcedure
{
   public wwp_hassubscriptionstodisplay( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_hassubscriptionstodisplay.class ), "" );
   }

   public wwp_hassubscriptionstodisplay( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              byte aP1 )
   {
      wwp_hassubscriptionstodisplay.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        byte aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             byte aP1 ,
                             boolean[] aP2 )
   {
      wwp_hassubscriptionstodisplay.this.AV11WWPEntityName = aP0;
      wwp_hassubscriptionstodisplay.this.AV10WWPNotificationAppliesTo = aP1;
      wwp_hassubscriptionstodisplay.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8WWPEntityId ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.wwpbaseobjects.wwp_getentitybyname(remoteHandle, context).execute( AV11WWPEntityName, GXv_int2) ;
      wwp_hassubscriptionstodisplay.this.GXt_int1 = GXv_int2[0] ;
      AV8WWPEntityId = GXt_int1 ;
      AV9HasSubscriptions = false ;
      /* Using cursor P003J2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV8WWPEntityId), Byte.valueOf(AV10WWPNotificationAppliesTo)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A33WWPEntityId = P003J2_A33WWPEntityId[0] ;
         A155WWPNotificationDefinitionAppli = P003J2_A155WWPNotificationDefinitionAppli[0] ;
         A156WWPNotificationDefinitionAllow = P003J2_A156WWPNotificationDefinitionAllow[0] ;
         A189WWPNotificationDefinitionSecFu = P003J2_A189WWPNotificationDefinitionSecFu[0] ;
         A35WWPNotificationDefinitionId = P003J2_A35WWPNotificationDefinitionId[0] ;
         if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
         {
            A190WWPNotificationDefinitionIsAut = true ;
         }
         else
         {
            GXt_boolean3 = A190WWPNotificationDefinitionIsAut ;
            GXv_boolean4[0] = GXt_boolean3 ;
            new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean4) ;
            wwp_hassubscriptionstodisplay.this.GXt_boolean3 = GXv_boolean4[0] ;
            A190WWPNotificationDefinitionIsAut = GXt_boolean3 ;
         }
         if ( A190WWPNotificationDefinitionIsAut )
         {
            AV9HasSubscriptions = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = wwp_hassubscriptionstodisplay.this.AV9HasSubscriptions;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new long[1] ;
      scmdbuf = "" ;
      P003J2_A33WWPEntityId = new long[1] ;
      P003J2_A155WWPNotificationDefinitionAppli = new byte[1] ;
      P003J2_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      P003J2_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      P003J2_A35WWPNotificationDefinitionId = new long[1] ;
      A189WWPNotificationDefinitionSecFu = "" ;
      GXv_boolean4 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_hassubscriptionstodisplay__default(),
         new Object[] {
             new Object[] {
            P003J2_A33WWPEntityId, P003J2_A155WWPNotificationDefinitionAppli, P003J2_A156WWPNotificationDefinitionAllow, P003J2_A189WWPNotificationDefinitionSecFu, P003J2_A35WWPNotificationDefinitionId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10WWPNotificationAppliesTo ;
   private byte A155WWPNotificationDefinitionAppli ;
   private short Gx_err ;
   private long AV8WWPEntityId ;
   private long GXt_int1 ;
   private long GXv_int2[] ;
   private long A33WWPEntityId ;
   private long A35WWPNotificationDefinitionId ;
   private String scmdbuf ;
   private boolean AV9HasSubscriptions ;
   private boolean A156WWPNotificationDefinitionAllow ;
   private boolean A190WWPNotificationDefinitionIsAut ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private String AV11WWPEntityName ;
   private String A189WWPNotificationDefinitionSecFu ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private long[] P003J2_A33WWPEntityId ;
   private byte[] P003J2_A155WWPNotificationDefinitionAppli ;
   private boolean[] P003J2_A156WWPNotificationDefinitionAllow ;
   private String[] P003J2_A189WWPNotificationDefinitionSecFu ;
   private long[] P003J2_A35WWPNotificationDefinitionId ;
}

final  class wwp_hassubscriptionstodisplay__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003J2", "SELECT [WWPEntityId], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionSecFu], [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] WHERE ([WWPEntityId] = ?) AND ([WWPNotificationDefinitionAllow] = 1) AND ([WWPNotificationDefinitionAppli] = ?) ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
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
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               return;
      }
   }

}

