package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_roleupdatesubscription extends GXProcedure
{
   public wwp_roleupdatesubscription( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_roleupdatesubscription.class ), "" );
   }

   public wwp_roleupdatesubscription( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( boolean aP0 ,
                        long[] aP1 ,
                        long aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( boolean aP0 ,
                             long[] aP1 ,
                             long aP2 ,
                             String aP3 )
   {
      wwp_roleupdatesubscription.this.AV8Subscribe = aP0;
      wwp_roleupdatesubscription.this.AV11WWPSubscriptionId = aP1[0];
      this.aP1 = aP1;
      wwp_roleupdatesubscription.this.AV9WWPNotificationDefinitionId = aP2;
      wwp_roleupdatesubscription.this.AV12WWPSubscriptionRoleId = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8Subscribe )
      {
         AV10WWPSubscription = (com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription)new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription( remoteHandle, context);
         AV10WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid( AV9WWPNotificationDefinitionId );
         AV10WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed( true );
         AV10WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid( AV12WWPSubscriptionRoleId );
         AV10WWPSubscription.Save();
         AV11WWPSubscriptionId = AV10WWPSubscription.getgxTv_SdtWWP_Subscription_Wwpsubscriptionid() ;
         GXt_objcol_char1 = AV13WWPUserExtendedIdCollection ;
         GXv_objcol_char2[0] = GXt_objcol_char1 ;
         new com.mujermorena.wwpbaseobjects.wwp_getusersfromrole(remoteHandle, context).execute( AV12WWPSubscriptionRoleId, GXv_objcol_char2) ;
         GXt_objcol_char1 = GXv_objcol_char2[0] ;
         AV13WWPUserExtendedIdCollection = GXt_objcol_char1 ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A32WWPUserExtendedId ,
                                              AV13WWPUserExtendedIdCollection ,
                                              Long.valueOf(AV9WWPNotificationDefinitionId) ,
                                              Long.valueOf(A35WWPNotificationDefinitionId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.LONG
                                              }
         });
         /* Using cursor P002V2 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV9WWPNotificationDefinitionId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A32WWPUserExtendedId = P002V2_A32WWPUserExtendedId[0] ;
            n32WWPUserExtendedId = P002V2_n32WWPUserExtendedId[0] ;
            A35WWPNotificationDefinitionId = P002V2_A35WWPNotificationDefinitionId[0] ;
            A34WWPSubscriptionId = P002V2_A34WWPSubscriptionId[0] ;
            /* Using cursor P002V3 */
            pr_default.execute(1, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         AV10WWPSubscription.Load(AV11WWPSubscriptionId);
         AV10WWPSubscription.Delete();
      }
      if ( AV10WWPSubscription.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_roleupdatesubscription");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_roleupdatesubscription.this.AV11WWPSubscriptionId;
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_roleupdatesubscription");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10WWPSubscription = new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription(remoteHandle);
      AV13WWPUserExtendedIdCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_objcol_char1 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char2 = new GXSimpleCollection[1] ;
      scmdbuf = "" ;
      A32WWPUserExtendedId = "" ;
      P002V2_A32WWPUserExtendedId = new String[] {""} ;
      P002V2_n32WWPUserExtendedId = new boolean[] {false} ;
      P002V2_A35WWPNotificationDefinitionId = new long[1] ;
      P002V2_A34WWPSubscriptionId = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_roleupdatesubscription__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_roleupdatesubscription__default(),
         new Object[] {
             new Object[] {
            P002V2_A32WWPUserExtendedId, P002V2_n32WWPUserExtendedId, P002V2_A35WWPNotificationDefinitionId, P002V2_A34WWPSubscriptionId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV11WWPSubscriptionId ;
   private long AV9WWPNotificationDefinitionId ;
   private long A35WWPNotificationDefinitionId ;
   private long A34WWPSubscriptionId ;
   private String AV12WWPSubscriptionRoleId ;
   private String scmdbuf ;
   private String A32WWPUserExtendedId ;
   private boolean AV8Subscribe ;
   private boolean n32WWPUserExtendedId ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P002V2_A32WWPUserExtendedId ;
   private boolean[] P002V2_n32WWPUserExtendedId ;
   private long[] P002V2_A35WWPNotificationDefinitionId ;
   private long[] P002V2_A34WWPSubscriptionId ;
   private IDataStoreProvider pr_gam ;
   private GXSimpleCollection<String> AV13WWPUserExtendedIdCollection ;
   private GXSimpleCollection<String> GXt_objcol_char1 ;
   private GXSimpleCollection<String> GXv_objcol_char2[] ;
   private com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription AV10WWPSubscription ;
}

final  class wwp_roleupdatesubscription__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_roleupdatesubscription__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A32WWPUserExtendedId ,
                                          GXSimpleCollection<String> AV13WWPUserExtendedIdCollection ,
                                          long AV9WWPNotificationDefinitionId ,
                                          long A35WWPNotificationDefinitionId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[1];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT [WWPUserExtendedId], [WWPNotificationDefinitionId], [WWPSubscriptionId] FROM [WWP_Subscription] WITH (UPDLOCK)" ;
      addWhere(sWhereString, "([WWPNotificationDefinitionId] = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV13WWPUserExtendedIdCollection, "[WWPUserExtendedId] IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY [WWPNotificationDefinitionId]" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P002V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002V2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P002V3", "DELETE FROM [WWP_Subscription]  WHERE [WWPSubscriptionId] = ?", GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
               ((long[]) buf[3])[0] = rslt.getLong(3);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[1]).longValue());
               }
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

