package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_subscription_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_subscription_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_subscription_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_subscription_bc.class ));
   }

   public wwp_subscription_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0U32( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0U32( ) ;
      standaloneModal( ) ;
      addRow0U32( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z34WWPSubscriptionId = A34WWPSubscriptionId ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0U0( )
   {
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0U32( ) ;
         }
         else
         {
            checkExtendedTable0U32( ) ;
            if ( AnyError == 0 )
            {
               zm0U32( 3) ;
               zm0U32( 4) ;
               zm0U32( 5) ;
            }
            closeExtendedTableCursors0U32( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0U32( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z151WWPSubscriptionEntityRecordId = A151WWPSubscriptionEntityRecordId ;
         Z153WWPSubscriptionEntityRecordDes = A153WWPSubscriptionEntityRecordDes ;
         Z149WWPSubscriptionRoleId = A149WWPSubscriptionRoleId ;
         Z152WWPSubscriptionSubscribed = A152WWPSubscriptionSubscribed ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z33WWPEntityId = A33WWPEntityId ;
         Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z150WWPEntityName = A150WWPEntityName ;
      }
      if ( GX_JID == -2 )
      {
         Z34WWPSubscriptionId = A34WWPSubscriptionId ;
         Z151WWPSubscriptionEntityRecordId = A151WWPSubscriptionEntityRecordId ;
         Z153WWPSubscriptionEntityRecordDes = A153WWPSubscriptionEntityRecordDes ;
         Z149WWPSubscriptionRoleId = A149WWPSubscriptionRoleId ;
         Z152WWPSubscriptionSubscribed = A152WWPSubscriptionSubscribed ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         Z33WWPEntityId = A33WWPEntityId ;
         Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
         Z150WWPEntityName = A150WWPEntityName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0U32( )
   {
      /* Using cursor BC000U7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A33WWPEntityId = BC000U7_A33WWPEntityId[0] ;
         A154WWPNotificationDefinitionDescr = BC000U7_A154WWPNotificationDefinitionDescr[0] ;
         A150WWPEntityName = BC000U7_A150WWPEntityName[0] ;
         A138WWPUserExtendedFullName = BC000U7_A138WWPUserExtendedFullName[0] ;
         A151WWPSubscriptionEntityRecordId = BC000U7_A151WWPSubscriptionEntityRecordId[0] ;
         A153WWPSubscriptionEntityRecordDes = BC000U7_A153WWPSubscriptionEntityRecordDes[0] ;
         A149WWPSubscriptionRoleId = BC000U7_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = BC000U7_n149WWPSubscriptionRoleId[0] ;
         A152WWPSubscriptionSubscribed = BC000U7_A152WWPSubscriptionSubscribed[0] ;
         A35WWPNotificationDefinitionId = BC000U7_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000U7_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000U7_n32WWPUserExtendedId[0] ;
         zm0U32( -2) ;
      }
      pr_default.close(5);
      onLoadActions0U32( ) ;
   }

   public void onLoadActions0U32( )
   {
   }

   public void checkExtendedTable0U32( )
   {
      nIsDirty_32 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000U8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
      }
      A33WWPEntityId = BC000U8_A33WWPEntityId[0] ;
      A154WWPNotificationDefinitionDescr = BC000U8_A154WWPNotificationDefinitionDescr[0] ;
      pr_default.close(6);
      /* Using cursor BC000U9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
      }
      A150WWPEntityName = BC000U9_A150WWPEntityName[0] ;
      pr_default.close(7);
      /* Using cursor BC000U10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
         }
      }
      A138WWPUserExtendedFullName = BC000U10_A138WWPUserExtendedFullName[0] ;
      pr_default.close(8);
   }

   public void closeExtendedTableCursors0U32( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey0U32( )
   {
      /* Using cursor BC000U11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound32 = (short)(1) ;
      }
      else
      {
         RcdFound32 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000U12 */
      pr_default.execute(10, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm0U32( 2) ;
         RcdFound32 = (short)(1) ;
         A34WWPSubscriptionId = BC000U12_A34WWPSubscriptionId[0] ;
         A151WWPSubscriptionEntityRecordId = BC000U12_A151WWPSubscriptionEntityRecordId[0] ;
         A153WWPSubscriptionEntityRecordDes = BC000U12_A153WWPSubscriptionEntityRecordDes[0] ;
         A149WWPSubscriptionRoleId = BC000U12_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = BC000U12_n149WWPSubscriptionRoleId[0] ;
         A152WWPSubscriptionSubscribed = BC000U12_A152WWPSubscriptionSubscribed[0] ;
         A35WWPNotificationDefinitionId = BC000U12_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000U12_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000U12_n32WWPUserExtendedId[0] ;
         Z34WWPSubscriptionId = A34WWPSubscriptionId ;
         sMode32 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0U32( ) ;
         if ( AnyError == 1 )
         {
            RcdFound32 = (short)(0) ;
            initializeNonKey0U32( ) ;
         }
         Gx_mode = sMode32 ;
      }
      else
      {
         RcdFound32 = (short)(0) ;
         initializeNonKey0U32( ) ;
         sMode32 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode32 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0U0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0U32( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000U13 */
         pr_default.execute(11, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Subscription"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( GXutil.strcmp(Z151WWPSubscriptionEntityRecordId, BC000U13_A151WWPSubscriptionEntityRecordId[0]) != 0 ) || ( GXutil.strcmp(Z153WWPSubscriptionEntityRecordDes, BC000U13_A153WWPSubscriptionEntityRecordDes[0]) != 0 ) || ( GXutil.strcmp(Z149WWPSubscriptionRoleId, BC000U13_A149WWPSubscriptionRoleId[0]) != 0 ) || ( Z152WWPSubscriptionSubscribed != BC000U13_A152WWPSubscriptionSubscribed[0] ) || ( Z35WWPNotificationDefinitionId != BC000U13_A35WWPNotificationDefinitionId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z32WWPUserExtendedId, BC000U13_A32WWPUserExtendedId[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Subscription"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0U32( )
   {
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0U32( 0) ;
         checkOptimisticConcurrency0U32( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0U32( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0U32( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000U14 */
                  pr_default.execute(12, new Object[] {A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, Boolean.valueOf(n149WWPSubscriptionRoleId), A149WWPSubscriptionRoleId, Boolean.valueOf(A152WWPSubscriptionSubscribed), Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  A34WWPSubscriptionId = BC000U14_A34WWPSubscriptionId[0] ;
                  pr_default.close(12);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0U32( ) ;
         }
         endLevel0U32( ) ;
      }
      closeExtendedTableCursors0U32( ) ;
   }

   public void update0U32( )
   {
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0U32( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0U32( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0U32( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000U15 */
                  pr_default.execute(13, new Object[] {A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, Boolean.valueOf(n149WWPSubscriptionRoleId), A149WWPSubscriptionRoleId, Boolean.valueOf(A152WWPSubscriptionSubscribed), Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, Long.valueOf(A34WWPSubscriptionId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Subscription"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0U32( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0U32( ) ;
      }
      closeExtendedTableCursors0U32( ) ;
   }

   public void deferredUpdate0U32( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0U32( ) ;
         afterConfirm0U32( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0U32( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000U16 */
               pr_default.execute(14, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode32 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0U32( ) ;
      Gx_mode = sMode32 ;
   }

   public void onDeleteControls0U32( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000U17 */
         pr_default.execute(15, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         A33WWPEntityId = BC000U17_A33WWPEntityId[0] ;
         A154WWPNotificationDefinitionDescr = BC000U17_A154WWPNotificationDefinitionDescr[0] ;
         pr_default.close(15);
         /* Using cursor BC000U18 */
         pr_default.execute(16, new Object[] {Long.valueOf(A33WWPEntityId)});
         A150WWPEntityName = BC000U18_A150WWPEntityName[0] ;
         pr_default.close(16);
         /* Using cursor BC000U19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         A138WWPUserExtendedFullName = BC000U19_A138WWPUserExtendedFullName[0] ;
         pr_default.close(17);
      }
   }

   public void endLevel0U32( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0U32( )
   {
      /* Using cursor BC000U20 */
      pr_default.execute(18, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      RcdFound32 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A33WWPEntityId = BC000U20_A33WWPEntityId[0] ;
         A34WWPSubscriptionId = BC000U20_A34WWPSubscriptionId[0] ;
         A154WWPNotificationDefinitionDescr = BC000U20_A154WWPNotificationDefinitionDescr[0] ;
         A150WWPEntityName = BC000U20_A150WWPEntityName[0] ;
         A138WWPUserExtendedFullName = BC000U20_A138WWPUserExtendedFullName[0] ;
         A151WWPSubscriptionEntityRecordId = BC000U20_A151WWPSubscriptionEntityRecordId[0] ;
         A153WWPSubscriptionEntityRecordDes = BC000U20_A153WWPSubscriptionEntityRecordDes[0] ;
         A149WWPSubscriptionRoleId = BC000U20_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = BC000U20_n149WWPSubscriptionRoleId[0] ;
         A152WWPSubscriptionSubscribed = BC000U20_A152WWPSubscriptionSubscribed[0] ;
         A35WWPNotificationDefinitionId = BC000U20_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000U20_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000U20_n32WWPUserExtendedId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0U32( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound32 = (short)(0) ;
      scanKeyLoad0U32( ) ;
   }

   public void scanKeyLoad0U32( )
   {
      sMode32 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A33WWPEntityId = BC000U20_A33WWPEntityId[0] ;
         A34WWPSubscriptionId = BC000U20_A34WWPSubscriptionId[0] ;
         A154WWPNotificationDefinitionDescr = BC000U20_A154WWPNotificationDefinitionDescr[0] ;
         A150WWPEntityName = BC000U20_A150WWPEntityName[0] ;
         A138WWPUserExtendedFullName = BC000U20_A138WWPUserExtendedFullName[0] ;
         A151WWPSubscriptionEntityRecordId = BC000U20_A151WWPSubscriptionEntityRecordId[0] ;
         A153WWPSubscriptionEntityRecordDes = BC000U20_A153WWPSubscriptionEntityRecordDes[0] ;
         A149WWPSubscriptionRoleId = BC000U20_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = BC000U20_n149WWPSubscriptionRoleId[0] ;
         A152WWPSubscriptionSubscribed = BC000U20_A152WWPSubscriptionSubscribed[0] ;
         A35WWPNotificationDefinitionId = BC000U20_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000U20_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000U20_n32WWPUserExtendedId[0] ;
      }
      Gx_mode = sMode32 ;
   }

   public void scanKeyEnd0U32( )
   {
      pr_default.close(18);
   }

   public void afterConfirm0U32( )
   {
      /* After Confirm Rules */
      if ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) )
      {
         A32WWPUserExtendedId = "" ;
         n32WWPUserExtendedId = false ;
         n32WWPUserExtendedId = true ;
      }
   }

   public void beforeInsert0U32( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0U32( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0U32( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0U32( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0U32( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0U32( )
   {
   }

   public void send_integrity_lvl_hashes0U32( )
   {
   }

   public void addRow0U32( )
   {
      VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
   }

   public void readRow0U32( )
   {
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
   }

   public void initializeNonKey0U32( )
   {
      A33WWPEntityId = 0 ;
      A35WWPNotificationDefinitionId = 0 ;
      A154WWPNotificationDefinitionDescr = "" ;
      A150WWPEntityName = "" ;
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      A138WWPUserExtendedFullName = "" ;
      A151WWPSubscriptionEntityRecordId = "" ;
      A153WWPSubscriptionEntityRecordDes = "" ;
      A149WWPSubscriptionRoleId = "" ;
      n149WWPSubscriptionRoleId = false ;
      A152WWPSubscriptionSubscribed = false ;
      Z151WWPSubscriptionEntityRecordId = "" ;
      Z153WWPSubscriptionEntityRecordDes = "" ;
      Z149WWPSubscriptionRoleId = "" ;
      Z152WWPSubscriptionSubscribed = false ;
      Z35WWPNotificationDefinitionId = 0 ;
      Z32WWPUserExtendedId = "" ;
   }

   public void initAll0U32( )
   {
      A34WWPSubscriptionId = 0 ;
      initializeNonKey0U32( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow32( com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription obj32 )
   {
      obj32.setgxTv_SdtWWP_Subscription_Mode( Gx_mode );
      obj32.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid( A35WWPNotificationDefinitionId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription( A154WWPNotificationDefinitionDescr );
      obj32.setgxTv_SdtWWP_Subscription_Wwpentityname( A150WWPEntityName );
      obj32.setgxTv_SdtWWP_Subscription_Wwpuserextendedid( A32WWPUserExtendedId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname( A138WWPUserExtendedFullName );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid( A151WWPSubscriptionEntityRecordId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription( A153WWPSubscriptionEntityRecordDes );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid( A149WWPSubscriptionRoleId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed( A152WWPSubscriptionSubscribed );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionid( A34WWPSubscriptionId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z( Z34WWPSubscriptionId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z( Z35WWPNotificationDefinitionId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z( Z154WWPNotificationDefinitionDescr );
      obj32.setgxTv_SdtWWP_Subscription_Wwpentityname_Z( Z150WWPEntityName );
      obj32.setgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z( Z32WWPUserExtendedId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z( Z138WWPUserExtendedFullName );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z( Z151WWPSubscriptionEntityRecordId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z( Z153WWPSubscriptionEntityRecordDes );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z( Z149WWPSubscriptionRoleId );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z( Z152WWPSubscriptionSubscribed );
      obj32.setgxTv_SdtWWP_Subscription_Wwpuserextendedid_N( (byte)((byte)((n32WWPUserExtendedId)?1:0)) );
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N( (byte)((byte)((n149WWPSubscriptionRoleId)?1:0)) );
      obj32.setgxTv_SdtWWP_Subscription_Mode( Gx_mode );
   }

   public void KeyVarsToRow32( com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription obj32 )
   {
      obj32.setgxTv_SdtWWP_Subscription_Wwpsubscriptionid( A34WWPSubscriptionId );
   }

   public void RowToVars32( com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription obj32 ,
                            int forceLoad )
   {
      Gx_mode = obj32.getgxTv_SdtWWP_Subscription_Mode() ;
      A35WWPNotificationDefinitionId = obj32.getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid() ;
      A154WWPNotificationDefinitionDescr = obj32.getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription() ;
      A150WWPEntityName = obj32.getgxTv_SdtWWP_Subscription_Wwpentityname() ;
      A32WWPUserExtendedId = obj32.getgxTv_SdtWWP_Subscription_Wwpuserextendedid() ;
      n32WWPUserExtendedId = false ;
      A138WWPUserExtendedFullName = obj32.getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname() ;
      A151WWPSubscriptionEntityRecordId = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid() ;
      A153WWPSubscriptionEntityRecordDes = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription() ;
      A149WWPSubscriptionRoleId = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid() ;
      n149WWPSubscriptionRoleId = false ;
      A152WWPSubscriptionSubscribed = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed() ;
      A34WWPSubscriptionId = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionid() ;
      Z34WWPSubscriptionId = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionid_Z() ;
      Z35WWPNotificationDefinitionId = obj32.getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitionid_Z() ;
      Z154WWPNotificationDefinitionDescr = obj32.getgxTv_SdtWWP_Subscription_Wwpnotificationdefinitiondescription_Z() ;
      Z150WWPEntityName = obj32.getgxTv_SdtWWP_Subscription_Wwpentityname_Z() ;
      Z32WWPUserExtendedId = obj32.getgxTv_SdtWWP_Subscription_Wwpuserextendedid_Z() ;
      Z138WWPUserExtendedFullName = obj32.getgxTv_SdtWWP_Subscription_Wwpuserextendedfullname_Z() ;
      Z151WWPSubscriptionEntityRecordId = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecordid_Z() ;
      Z153WWPSubscriptionEntityRecordDes = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionentityrecorddescription_Z() ;
      Z149WWPSubscriptionRoleId = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_Z() ;
      Z152WWPSubscriptionSubscribed = obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionsubscribed_Z() ;
      n32WWPUserExtendedId = (boolean)((obj32.getgxTv_SdtWWP_Subscription_Wwpuserextendedid_N()==0)?false:true) ;
      n149WWPSubscriptionRoleId = (boolean)((obj32.getgxTv_SdtWWP_Subscription_Wwpsubscriptionroleid_N()==0)?false:true) ;
      Gx_mode = obj32.getgxTv_SdtWWP_Subscription_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A34WWPSubscriptionId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0U32( ) ;
      scanKeyStart0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z34WWPSubscriptionId = A34WWPSubscriptionId ;
      }
      zm0U32( -2) ;
      onLoadActions0U32( ) ;
      addRow0U32( ) ;
      scanKeyEnd0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 0) ;
      scanKeyStart0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z34WWPSubscriptionId = A34WWPSubscriptionId ;
      }
      zm0U32( -2) ;
      onLoadActions0U32( ) ;
      addRow0U32( ) ;
      scanKeyEnd0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0U32( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0U32( ) ;
      }
      else
      {
         if ( RcdFound32 == 1 )
         {
            if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
            {
               A34WWPSubscriptionId = Z34WWPSubscriptionId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0U32( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0U32( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0U32( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
      saveImpl( ) ;
      VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0U32( ) ;
      afterTrn( ) ;
      VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription auxBC = new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A34WWPSubscriptionId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_subscriptions_WWP_Subscription);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
      updateImpl( ) ;
      VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0U32( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0U32( ) ;
      if ( RcdFound32 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
         {
            A34WWPSubscriptionId = Z34WWPSubscriptionId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(15);
      pr_default.close(2);
      pr_default.close(17);
      pr_default.close(3);
      pr_default.close(16);
      pr_default.close(4);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscription_bc");
      VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcwwpbaseobjects_subscriptions_WWP_Subscription.getgxTv_SdtWWP_Subscription_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_subscriptions_WWP_Subscription.setgxTv_SdtWWP_Subscription_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_subscriptions_WWP_Subscription )
      {
         bcwwpbaseobjects_subscriptions_WWP_Subscription = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_subscriptions_WWP_Subscription.getgxTv_SdtWWP_Subscription_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_subscriptions_WWP_Subscription.setgxTv_SdtWWP_Subscription_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow32( bcwwpbaseobjects_subscriptions_WWP_Subscription) ;
         }
         else
         {
            RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_subscriptions_WWP_Subscription.getgxTv_SdtWWP_Subscription_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_subscriptions_WWP_Subscription.setgxTv_SdtWWP_Subscription_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars32( bcwwpbaseobjects_subscriptions_WWP_Subscription, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_Subscription getWWP_Subscription_BC( )
   {
      return bcwwpbaseobjects_subscriptions_WWP_Subscription ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z151WWPSubscriptionEntityRecordId = "" ;
      A151WWPSubscriptionEntityRecordId = "" ;
      Z153WWPSubscriptionEntityRecordDes = "" ;
      A153WWPSubscriptionEntityRecordDes = "" ;
      Z149WWPSubscriptionRoleId = "" ;
      A149WWPSubscriptionRoleId = "" ;
      Z32WWPUserExtendedId = "" ;
      A32WWPUserExtendedId = "" ;
      Z154WWPNotificationDefinitionDescr = "" ;
      A154WWPNotificationDefinitionDescr = "" ;
      Z138WWPUserExtendedFullName = "" ;
      A138WWPUserExtendedFullName = "" ;
      Z150WWPEntityName = "" ;
      A150WWPEntityName = "" ;
      BC000U7_A33WWPEntityId = new long[1] ;
      BC000U7_A34WWPSubscriptionId = new long[1] ;
      BC000U7_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000U7_A150WWPEntityName = new String[] {""} ;
      BC000U7_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000U7_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      BC000U7_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      BC000U7_A149WWPSubscriptionRoleId = new String[] {""} ;
      BC000U7_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      BC000U7_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      BC000U7_A35WWPNotificationDefinitionId = new long[1] ;
      BC000U7_A32WWPUserExtendedId = new String[] {""} ;
      BC000U7_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000U8_A33WWPEntityId = new long[1] ;
      BC000U8_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000U9_A150WWPEntityName = new String[] {""} ;
      BC000U10_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000U11_A34WWPSubscriptionId = new long[1] ;
      BC000U12_A34WWPSubscriptionId = new long[1] ;
      BC000U12_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      BC000U12_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      BC000U12_A149WWPSubscriptionRoleId = new String[] {""} ;
      BC000U12_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      BC000U12_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      BC000U12_A35WWPNotificationDefinitionId = new long[1] ;
      BC000U12_A32WWPUserExtendedId = new String[] {""} ;
      BC000U12_n32WWPUserExtendedId = new boolean[] {false} ;
      sMode32 = "" ;
      BC000U13_A34WWPSubscriptionId = new long[1] ;
      BC000U13_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      BC000U13_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      BC000U13_A149WWPSubscriptionRoleId = new String[] {""} ;
      BC000U13_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      BC000U13_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      BC000U13_A35WWPNotificationDefinitionId = new long[1] ;
      BC000U13_A32WWPUserExtendedId = new String[] {""} ;
      BC000U13_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000U14_A34WWPSubscriptionId = new long[1] ;
      BC000U17_A33WWPEntityId = new long[1] ;
      BC000U17_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000U18_A150WWPEntityName = new String[] {""} ;
      BC000U19_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000U20_A33WWPEntityId = new long[1] ;
      BC000U20_A34WWPSubscriptionId = new long[1] ;
      BC000U20_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000U20_A150WWPEntityName = new String[] {""} ;
      BC000U20_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000U20_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      BC000U20_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      BC000U20_A149WWPSubscriptionRoleId = new String[] {""} ;
      BC000U20_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      BC000U20_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      BC000U20_A35WWPNotificationDefinitionId = new long[1] ;
      BC000U20_A32WWPUserExtendedId = new String[] {""} ;
      BC000U20_n32WWPUserExtendedId = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription_bc__default(),
         new Object[] {
             new Object[] {
            BC000U2_A34WWPSubscriptionId, BC000U2_A151WWPSubscriptionEntityRecordId, BC000U2_A153WWPSubscriptionEntityRecordDes, BC000U2_A149WWPSubscriptionRoleId, BC000U2_n149WWPSubscriptionRoleId, BC000U2_A152WWPSubscriptionSubscribed, BC000U2_A35WWPNotificationDefinitionId, BC000U2_A32WWPUserExtendedId, BC000U2_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000U3_A34WWPSubscriptionId, BC000U3_A151WWPSubscriptionEntityRecordId, BC000U3_A153WWPSubscriptionEntityRecordDes, BC000U3_A149WWPSubscriptionRoleId, BC000U3_n149WWPSubscriptionRoleId, BC000U3_A152WWPSubscriptionSubscribed, BC000U3_A35WWPNotificationDefinitionId, BC000U3_A32WWPUserExtendedId, BC000U3_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000U4_A33WWPEntityId, BC000U4_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            BC000U5_A138WWPUserExtendedFullName
            }
            , new Object[] {
            BC000U6_A150WWPEntityName
            }
            , new Object[] {
            BC000U7_A33WWPEntityId, BC000U7_A34WWPSubscriptionId, BC000U7_A154WWPNotificationDefinitionDescr, BC000U7_A150WWPEntityName, BC000U7_A138WWPUserExtendedFullName, BC000U7_A151WWPSubscriptionEntityRecordId, BC000U7_A153WWPSubscriptionEntityRecordDes, BC000U7_A149WWPSubscriptionRoleId, BC000U7_n149WWPSubscriptionRoleId, BC000U7_A152WWPSubscriptionSubscribed,
            BC000U7_A35WWPNotificationDefinitionId, BC000U7_A32WWPUserExtendedId, BC000U7_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000U8_A33WWPEntityId, BC000U8_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            BC000U9_A150WWPEntityName
            }
            , new Object[] {
            BC000U10_A138WWPUserExtendedFullName
            }
            , new Object[] {
            BC000U11_A34WWPSubscriptionId
            }
            , new Object[] {
            BC000U12_A34WWPSubscriptionId, BC000U12_A151WWPSubscriptionEntityRecordId, BC000U12_A153WWPSubscriptionEntityRecordDes, BC000U12_A149WWPSubscriptionRoleId, BC000U12_n149WWPSubscriptionRoleId, BC000U12_A152WWPSubscriptionSubscribed, BC000U12_A35WWPNotificationDefinitionId, BC000U12_A32WWPUserExtendedId, BC000U12_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000U13_A34WWPSubscriptionId, BC000U13_A151WWPSubscriptionEntityRecordId, BC000U13_A153WWPSubscriptionEntityRecordDes, BC000U13_A149WWPSubscriptionRoleId, BC000U13_n149WWPSubscriptionRoleId, BC000U13_A152WWPSubscriptionSubscribed, BC000U13_A35WWPNotificationDefinitionId, BC000U13_A32WWPUserExtendedId, BC000U13_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000U14_A34WWPSubscriptionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000U17_A33WWPEntityId, BC000U17_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            BC000U18_A150WWPEntityName
            }
            , new Object[] {
            BC000U19_A138WWPUserExtendedFullName
            }
            , new Object[] {
            BC000U20_A33WWPEntityId, BC000U20_A34WWPSubscriptionId, BC000U20_A154WWPNotificationDefinitionDescr, BC000U20_A150WWPEntityName, BC000U20_A138WWPUserExtendedFullName, BC000U20_A151WWPSubscriptionEntityRecordId, BC000U20_A153WWPSubscriptionEntityRecordDes, BC000U20_A149WWPSubscriptionRoleId, BC000U20_n149WWPSubscriptionRoleId, BC000U20_A152WWPSubscriptionSubscribed,
            BC000U20_A35WWPNotificationDefinitionId, BC000U20_A32WWPUserExtendedId, BC000U20_n32WWPUserExtendedId
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound32 ;
   private short nIsDirty_32 ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z34WWPSubscriptionId ;
   private long A34WWPSubscriptionId ;
   private long Z35WWPNotificationDefinitionId ;
   private long A35WWPNotificationDefinitionId ;
   private long Z33WWPEntityId ;
   private long A33WWPEntityId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z149WWPSubscriptionRoleId ;
   private String A149WWPSubscriptionRoleId ;
   private String Z32WWPUserExtendedId ;
   private String A32WWPUserExtendedId ;
   private String sMode32 ;
   private boolean Z152WWPSubscriptionSubscribed ;
   private boolean A152WWPSubscriptionSubscribed ;
   private boolean n149WWPSubscriptionRoleId ;
   private boolean n32WWPUserExtendedId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z151WWPSubscriptionEntityRecordId ;
   private String A151WWPSubscriptionEntityRecordId ;
   private String Z153WWPSubscriptionEntityRecordDes ;
   private String A153WWPSubscriptionEntityRecordDes ;
   private String Z154WWPNotificationDefinitionDescr ;
   private String A154WWPNotificationDefinitionDescr ;
   private String Z138WWPUserExtendedFullName ;
   private String A138WWPUserExtendedFullName ;
   private String Z150WWPEntityName ;
   private String A150WWPEntityName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription bcwwpbaseobjects_subscriptions_WWP_Subscription ;
   private IDataStoreProvider pr_default ;
   private long[] BC000U7_A33WWPEntityId ;
   private long[] BC000U7_A34WWPSubscriptionId ;
   private String[] BC000U7_A154WWPNotificationDefinitionDescr ;
   private String[] BC000U7_A150WWPEntityName ;
   private String[] BC000U7_A138WWPUserExtendedFullName ;
   private String[] BC000U7_A151WWPSubscriptionEntityRecordId ;
   private String[] BC000U7_A153WWPSubscriptionEntityRecordDes ;
   private String[] BC000U7_A149WWPSubscriptionRoleId ;
   private boolean[] BC000U7_n149WWPSubscriptionRoleId ;
   private boolean[] BC000U7_A152WWPSubscriptionSubscribed ;
   private long[] BC000U7_A35WWPNotificationDefinitionId ;
   private String[] BC000U7_A32WWPUserExtendedId ;
   private boolean[] BC000U7_n32WWPUserExtendedId ;
   private long[] BC000U8_A33WWPEntityId ;
   private String[] BC000U8_A154WWPNotificationDefinitionDescr ;
   private String[] BC000U9_A150WWPEntityName ;
   private String[] BC000U10_A138WWPUserExtendedFullName ;
   private long[] BC000U11_A34WWPSubscriptionId ;
   private long[] BC000U12_A34WWPSubscriptionId ;
   private String[] BC000U12_A151WWPSubscriptionEntityRecordId ;
   private String[] BC000U12_A153WWPSubscriptionEntityRecordDes ;
   private String[] BC000U12_A149WWPSubscriptionRoleId ;
   private boolean[] BC000U12_n149WWPSubscriptionRoleId ;
   private boolean[] BC000U12_A152WWPSubscriptionSubscribed ;
   private long[] BC000U12_A35WWPNotificationDefinitionId ;
   private String[] BC000U12_A32WWPUserExtendedId ;
   private boolean[] BC000U12_n32WWPUserExtendedId ;
   private long[] BC000U13_A34WWPSubscriptionId ;
   private String[] BC000U13_A151WWPSubscriptionEntityRecordId ;
   private String[] BC000U13_A153WWPSubscriptionEntityRecordDes ;
   private String[] BC000U13_A149WWPSubscriptionRoleId ;
   private boolean[] BC000U13_n149WWPSubscriptionRoleId ;
   private boolean[] BC000U13_A152WWPSubscriptionSubscribed ;
   private long[] BC000U13_A35WWPNotificationDefinitionId ;
   private String[] BC000U13_A32WWPUserExtendedId ;
   private boolean[] BC000U13_n32WWPUserExtendedId ;
   private long[] BC000U14_A34WWPSubscriptionId ;
   private long[] BC000U17_A33WWPEntityId ;
   private String[] BC000U17_A154WWPNotificationDefinitionDescr ;
   private String[] BC000U18_A150WWPEntityName ;
   private String[] BC000U19_A138WWPUserExtendedFullName ;
   private long[] BC000U20_A33WWPEntityId ;
   private long[] BC000U20_A34WWPSubscriptionId ;
   private String[] BC000U20_A154WWPNotificationDefinitionDescr ;
   private String[] BC000U20_A150WWPEntityName ;
   private String[] BC000U20_A138WWPUserExtendedFullName ;
   private String[] BC000U20_A151WWPSubscriptionEntityRecordId ;
   private String[] BC000U20_A153WWPSubscriptionEntityRecordDes ;
   private String[] BC000U20_A149WWPSubscriptionRoleId ;
   private boolean[] BC000U20_n149WWPSubscriptionRoleId ;
   private boolean[] BC000U20_A152WWPSubscriptionSubscribed ;
   private long[] BC000U20_A35WWPNotificationDefinitionId ;
   private String[] BC000U20_A32WWPUserExtendedId ;
   private boolean[] BC000U20_n32WWPUserExtendedId ;
   private IDataStoreProvider pr_gam ;
   private long[] BC000U2_A34WWPSubscriptionId ;
   private String[] BC000U2_A151WWPSubscriptionEntityRecordId ;
   private String[] BC000U2_A153WWPSubscriptionEntityRecordDes ;
   private String[] BC000U2_A149WWPSubscriptionRoleId ;
   private boolean[] BC000U2_A152WWPSubscriptionSubscribed ;
   private long[] BC000U2_A35WWPNotificationDefinitionId ;
   private String[] BC000U2_A32WWPUserExtendedId ;
   private long[] BC000U3_A34WWPSubscriptionId ;
   private String[] BC000U3_A151WWPSubscriptionEntityRecordId ;
   private String[] BC000U3_A153WWPSubscriptionEntityRecordDes ;
   private String[] BC000U3_A149WWPSubscriptionRoleId ;
   private boolean[] BC000U3_A152WWPSubscriptionSubscribed ;
   private long[] BC000U3_A35WWPNotificationDefinitionId ;
   private String[] BC000U3_A32WWPUserExtendedId ;
   private long[] BC000U4_A33WWPEntityId ;
   private String[] BC000U4_A154WWPNotificationDefinitionDescr ;
   private String[] BC000U5_A138WWPUserExtendedFullName ;
   private String[] BC000U6_A150WWPEntityName ;
   private boolean[] BC000U2_n149WWPSubscriptionRoleId ;
   private boolean[] BC000U2_n32WWPUserExtendedId ;
   private boolean[] BC000U3_n149WWPSubscriptionRoleId ;
   private boolean[] BC000U3_n32WWPUserExtendedId ;
}

final  class wwp_subscription_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_subscription_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000U2", "SELECT [WWPSubscriptionId], [WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Subscription] WITH (UPDLOCK) WHERE [WWPSubscriptionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U3", "SELECT [WWPSubscriptionId], [WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Subscription] WHERE [WWPSubscriptionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U4", "SELECT [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U5", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U6", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U7", "SELECT T2.[WWPEntityId], TM1.[WWPSubscriptionId], T2.[WWPNotificationDefinitionDescr], T3.[WWPEntityName], T4.[WWPUserExtendedFullName], TM1.[WWPSubscriptionEntityRecordId], TM1.[WWPSubscriptionEntityRecordDes], TM1.[WWPSubscriptionRoleId], TM1.[WWPSubscriptionSubscribed], TM1.[WWPNotificationDefinitionId], TM1.[WWPUserExtendedId] FROM ((([WWP_Subscription] TM1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = TM1.[WWPNotificationDefinitionId]) INNER JOIN [WWP_Entity] T3 ON T3.[WWPEntityId] = T2.[WWPEntityId]) LEFT JOIN [WWP_UserExtended] T4 ON T4.[WWPUserExtendedId] = TM1.[WWPUserExtendedId]) WHERE TM1.[WWPSubscriptionId] = ? ORDER BY TM1.[WWPSubscriptionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U8", "SELECT [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U9", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U10", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U11", "SELECT [WWPSubscriptionId] FROM [WWP_Subscription] WHERE [WWPSubscriptionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U12", "SELECT [WWPSubscriptionId], [WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Subscription] WHERE [WWPSubscriptionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U13", "SELECT [WWPSubscriptionId], [WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Subscription] WITH (UPDLOCK) WHERE [WWPSubscriptionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U14", "INSERT INTO [WWP_Subscription]([WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC000U15", "UPDATE [WWP_Subscription] SET [WWPSubscriptionEntityRecordId]=?, [WWPSubscriptionEntityRecordDes]=?, [WWPSubscriptionRoleId]=?, [WWPSubscriptionSubscribed]=?, [WWPNotificationDefinitionId]=?, [WWPUserExtendedId]=?  WHERE [WWPSubscriptionId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000U16", "DELETE FROM [WWP_Subscription]  WHERE [WWPSubscriptionId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000U17", "SELECT [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U18", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U19", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000U20", "SELECT T2.[WWPEntityId], TM1.[WWPSubscriptionId], T2.[WWPNotificationDefinitionDescr], T3.[WWPEntityName], T4.[WWPUserExtendedFullName], TM1.[WWPSubscriptionEntityRecordId], TM1.[WWPSubscriptionEntityRecordDes], TM1.[WWPSubscriptionRoleId], TM1.[WWPSubscriptionSubscribed], TM1.[WWPNotificationDefinitionId], TM1.[WWPUserExtendedId] FROM ((([WWP_Subscription] TM1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = TM1.[WWPNotificationDefinitionId]) INNER JOIN [WWP_Entity] T3 ON T3.[WWPEntityId] = T2.[WWPEntityId]) LEFT JOIN [WWP_UserExtended] T4 ON T4.[WWPUserExtendedId] = TM1.[WWPUserExtendedId]) WHERE TM1.[WWPSubscriptionId] = ? ORDER BY TM1.[WWPSubscriptionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(9);
               ((long[]) buf[10])[0] = rslt.getLong(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 40);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(9);
               ((long[]) buf[10])[0] = rslt.getLong(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 40);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 2000, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setLong(5, ((Number) parms[5]).longValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 40);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 2000, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setLong(5, ((Number) parms[5]).longValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 40);
               }
               stmt.setLong(7, ((Number) parms[8]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

