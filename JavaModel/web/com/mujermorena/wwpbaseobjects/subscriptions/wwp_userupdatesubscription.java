package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_userupdatesubscription extends GXProcedure
{
   public wwp_userupdatesubscription( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_userupdatesubscription.class ), "" );
   }

   public wwp_userupdatesubscription( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( boolean aP0 ,
                        long[] aP1 ,
                        long aP2 ,
                        String aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( boolean aP0 ,
                             long[] aP1 ,
                             long aP2 ,
                             String aP3 ,
                             String aP4 )
   {
      wwp_userupdatesubscription.this.AV12Subscribe = aP0;
      wwp_userupdatesubscription.this.AV8WWPSubscriptionId = aP1[0];
      this.aP1 = aP1;
      wwp_userupdatesubscription.this.AV9WWPNotificationDefinitionId = aP2;
      wwp_userupdatesubscription.this.AV10WWPSubscriptionEntityRecordId = aP3;
      wwp_userupdatesubscription.this.AV11WWPSubscriptionEntityRecordDescription = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV12Subscribe )
      {
         AV13WWPSubscription.Load(AV8WWPSubscriptionId);
         if ( AV13WWPSubscription.Success() )
         {
            AV13WWPSubscription.Delete();
            AV8WWPSubscriptionId = 0 ;
         }
         else
         {
            AV13WWPSubscription = (com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription)new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription( remoteHandle, context);
            AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid( AV9WWPNotificationDefinitionId );
            AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid( AV10WWPSubscriptionEntityRecordId );
            AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription( AV11WWPSubscriptionEntityRecordDescription );
            AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed( true );
            GXt_char1 = "" ;
            GXv_char2[0] = GXt_char1 ;
            new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).execute( GXv_char2) ;
            wwp_userupdatesubscription.this.GXt_char1 = GXv_char2[0] ;
            AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpuserextendedid( GXt_char1 );
            AV13WWPSubscription.Save();
            AV8WWPSubscriptionId = AV13WWPSubscription.getgxTv_SdtWWP_Subscription_Wwpsubscriptionid() ;
         }
      }
      else
      {
         if ( AV8WWPSubscriptionId == 0 )
         {
            /* Execute user subroutine: 'CREATESUBSCRIPTIONNOTSUBSCRIBED' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            AV13WWPSubscription.Load(AV8WWPSubscriptionId);
            if ( GXutil.strcmp(AV13WWPSubscription.getgxTv_SdtWWP_Subscription_Wwpuserextendedid(), new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( )) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV13WWPSubscription.Delete();
            }
            else
            {
               /* Execute user subroutine: 'CREATESUBSCRIPTIONNOTSUBSCRIBED' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
      }
      if ( AV13WWPSubscription.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_userupdatesubscription");
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CREATESUBSCRIPTIONNOTSUBSCRIBED' Routine */
      returnInSub = false ;
      AV13WWPSubscription = (com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription)new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription( remoteHandle, context);
      AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid( AV9WWPNotificationDefinitionId );
      AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid( AV10WWPSubscriptionEntityRecordId );
      AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription( AV11WWPSubscriptionEntityRecordDescription );
      AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed( false );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).execute( GXv_char2) ;
      wwp_userupdatesubscription.this.GXt_char1 = GXv_char2[0] ;
      AV13WWPSubscription.setgxTv_SdtWWP_Subscription_Wwpuserextendedid( GXt_char1 );
      AV13WWPSubscription.Save();
      AV8WWPSubscriptionId = AV13WWPSubscription.getgxTv_SdtWWP_Subscription_Wwpsubscriptionid() ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_userupdatesubscription.this.AV8WWPSubscriptionId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13WWPSubscription = new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription(remoteHandle);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_userupdatesubscription__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_userupdatesubscription__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV8WWPSubscriptionId ;
   private long AV9WWPNotificationDefinitionId ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV12Subscribe ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String AV10WWPSubscriptionEntityRecordId ;
   private String AV11WWPSubscriptionEntityRecordDescription ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription AV13WWPSubscription ;
}

final  class wwp_userupdatesubscription__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_userupdatesubscription__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

}

