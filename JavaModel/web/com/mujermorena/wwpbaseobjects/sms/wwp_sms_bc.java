package com.mujermorena.wwpbaseobjects.sms ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_sms_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_sms_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_sms_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_sms_bc.class ));
   }

   public wwp_sms_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0V33( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0V33( ) ;
      standaloneModal( ) ;
      addRow0V33( ) ;
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
            Z36WWPSMSId = A36WWPSMSId ;
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

   public void confirm_0V0( )
   {
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0V33( ) ;
         }
         else
         {
            checkExtendedTable0V33( ) ;
            if ( AnyError == 0 )
            {
               zm0V33( 9) ;
            }
            closeExtendedTableCursors0V33( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0V33( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z158WWPSMSStatus = A158WWPSMSStatus ;
         Z164WWPSMSCreated = A164WWPSMSCreated ;
         Z165WWPSMSScheduled = A165WWPSMSScheduled ;
         Z159WWPSMSProcessed = A159WWPSMSProcessed ;
         Z37WWPNotificationId = A37WWPNotificationId ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
      }
      if ( GX_JID == -8 )
      {
         Z36WWPSMSId = A36WWPSMSId ;
         Z161WWPSMSMessage = A161WWPSMSMessage ;
         Z162WWPSMSSenderNumber = A162WWPSMSSenderNumber ;
         Z163WWPSMSRecipientNumbers = A163WWPSMSRecipientNumbers ;
         Z158WWPSMSStatus = A158WWPSMSStatus ;
         Z164WWPSMSCreated = A164WWPSMSCreated ;
         Z165WWPSMSScheduled = A165WWPSMSScheduled ;
         Z159WWPSMSProcessed = A159WWPSMSProcessed ;
         Z160WWPSMSDetail = A160WWPSMSDetail ;
         Z37WWPNotificationId = A37WWPNotificationId ;
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (0==A158WWPSMSStatus) && ( Gx_BScreen == 0 ) )
      {
         A158WWPSMSStatus = (short)(1) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A164WWPSMSCreated) && ( Gx_BScreen == 0 ) )
      {
         A164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A165WWPSMSScheduled) && ( Gx_BScreen == 0 ) )
      {
         A165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0V33( )
   {
      /* Using cursor BC000V5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A161WWPSMSMessage = BC000V5_A161WWPSMSMessage[0] ;
         A162WWPSMSSenderNumber = BC000V5_A162WWPSMSSenderNumber[0] ;
         A163WWPSMSRecipientNumbers = BC000V5_A163WWPSMSRecipientNumbers[0] ;
         A158WWPSMSStatus = BC000V5_A158WWPSMSStatus[0] ;
         A164WWPSMSCreated = BC000V5_A164WWPSMSCreated[0] ;
         A165WWPSMSScheduled = BC000V5_A165WWPSMSScheduled[0] ;
         A159WWPSMSProcessed = BC000V5_A159WWPSMSProcessed[0] ;
         n159WWPSMSProcessed = BC000V5_n159WWPSMSProcessed[0] ;
         A160WWPSMSDetail = BC000V5_A160WWPSMSDetail[0] ;
         n160WWPSMSDetail = BC000V5_n160WWPSMSDetail[0] ;
         A40WWPNotificationCreated = BC000V5_A40WWPNotificationCreated[0] ;
         A37WWPNotificationId = BC000V5_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000V5_n37WWPNotificationId[0] ;
         zm0V33( -8) ;
      }
      pr_default.close(3);
      onLoadActions0V33( ) ;
   }

   public void onLoadActions0V33( )
   {
   }

   public void checkExtendedTable0V33( )
   {
      nIsDirty_33 = (short)(0) ;
      standaloneModal( ) ;
      if ( ! ( ( A158WWPSMSStatus == 1 ) || ( A158WWPSMSStatus == 2 ) || ( A158WWPSMSStatus == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Status", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A164WWPSMSCreated) || (( A164WWPSMSCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A164WWPSMSCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Created", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A165WWPSMSScheduled) || (( A165WWPSMSScheduled.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A165WWPSMSScheduled, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Scheduled", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A159WWPSMSProcessed) || (( A159WWPSMSProcessed.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A159WWPSMSProcessed, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Processed", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000V6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
         }
      }
      A40WWPNotificationCreated = BC000V6_A40WWPNotificationCreated[0] ;
      pr_default.close(4);
   }

   public void closeExtendedTableCursors0V33( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0V33( )
   {
      /* Using cursor BC000V7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound33 = (short)(1) ;
      }
      else
      {
         RcdFound33 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000V8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0V33( 8) ;
         RcdFound33 = (short)(1) ;
         A36WWPSMSId = BC000V8_A36WWPSMSId[0] ;
         A161WWPSMSMessage = BC000V8_A161WWPSMSMessage[0] ;
         A162WWPSMSSenderNumber = BC000V8_A162WWPSMSSenderNumber[0] ;
         A163WWPSMSRecipientNumbers = BC000V8_A163WWPSMSRecipientNumbers[0] ;
         A158WWPSMSStatus = BC000V8_A158WWPSMSStatus[0] ;
         A164WWPSMSCreated = BC000V8_A164WWPSMSCreated[0] ;
         A165WWPSMSScheduled = BC000V8_A165WWPSMSScheduled[0] ;
         A159WWPSMSProcessed = BC000V8_A159WWPSMSProcessed[0] ;
         n159WWPSMSProcessed = BC000V8_n159WWPSMSProcessed[0] ;
         A160WWPSMSDetail = BC000V8_A160WWPSMSDetail[0] ;
         n160WWPSMSDetail = BC000V8_n160WWPSMSDetail[0] ;
         A37WWPNotificationId = BC000V8_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000V8_n37WWPNotificationId[0] ;
         Z36WWPSMSId = A36WWPSMSId ;
         sMode33 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0V33( ) ;
         if ( AnyError == 1 )
         {
            RcdFound33 = (short)(0) ;
            initializeNonKey0V33( ) ;
         }
         Gx_mode = sMode33 ;
      }
      else
      {
         RcdFound33 = (short)(0) ;
         initializeNonKey0V33( ) ;
         sMode33 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode33 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0V33( ) ;
      if ( RcdFound33 == 0 )
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
      confirm_0V0( ) ;
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

   public void checkOptimisticConcurrency0V33( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000V9 */
         pr_default.execute(7, new Object[] {Long.valueOf(A36WWPSMSId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_SMS"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( Z158WWPSMSStatus != BC000V9_A158WWPSMSStatus[0] ) || !( GXutil.dateCompare(Z164WWPSMSCreated, BC000V9_A164WWPSMSCreated[0]) ) || !( GXutil.dateCompare(Z165WWPSMSScheduled, BC000V9_A165WWPSMSScheduled[0]) ) || !( GXutil.dateCompare(Z159WWPSMSProcessed, BC000V9_A159WWPSMSProcessed[0]) ) || ( Z37WWPNotificationId != BC000V9_A37WWPNotificationId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_SMS"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0V33( )
   {
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0V33( 0) ;
         checkOptimisticConcurrency0V33( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V33( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0V33( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000V10 */
                  pr_default.execute(8, new Object[] {A161WWPSMSMessage, A162WWPSMSSenderNumber, A163WWPSMSRecipientNumbers, Short.valueOf(A158WWPSMSStatus), A164WWPSMSCreated, A165WWPSMSScheduled, Boolean.valueOf(n159WWPSMSProcessed), A159WWPSMSProcessed, Boolean.valueOf(n160WWPSMSDetail), A160WWPSMSDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  A36WWPSMSId = BC000V10_A36WWPSMSId[0] ;
                  pr_default.close(8);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_SMS");
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
            load0V33( ) ;
         }
         endLevel0V33( ) ;
      }
      closeExtendedTableCursors0V33( ) ;
   }

   public void update0V33( )
   {
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V33( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V33( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0V33( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000V11 */
                  pr_default.execute(9, new Object[] {A161WWPSMSMessage, A162WWPSMSSenderNumber, A163WWPSMSRecipientNumbers, Short.valueOf(A158WWPSMSStatus), A164WWPSMSCreated, A165WWPSMSScheduled, Boolean.valueOf(n159WWPSMSProcessed), A159WWPSMSProcessed, Boolean.valueOf(n160WWPSMSDetail), A160WWPSMSDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId), Long.valueOf(A36WWPSMSId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_SMS");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_SMS"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0V33( ) ;
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
         endLevel0V33( ) ;
      }
      closeExtendedTableCursors0V33( ) ;
   }

   public void deferredUpdate0V33( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0V33( ) ;
         afterConfirm0V33( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0V33( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000V12 */
               pr_default.execute(10, new Object[] {Long.valueOf(A36WWPSMSId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_SMS");
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
      sMode33 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0V33( ) ;
      Gx_mode = sMode33 ;
   }

   public void onDeleteControls0V33( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000V13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         A40WWPNotificationCreated = BC000V13_A40WWPNotificationCreated[0] ;
         pr_default.close(11);
      }
   }

   public void endLevel0V33( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0V33( ) ;
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

   public void scanKeyStart0V33( )
   {
      /* Using cursor BC000V14 */
      pr_default.execute(12, new Object[] {Long.valueOf(A36WWPSMSId)});
      RcdFound33 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A36WWPSMSId = BC000V14_A36WWPSMSId[0] ;
         A161WWPSMSMessage = BC000V14_A161WWPSMSMessage[0] ;
         A162WWPSMSSenderNumber = BC000V14_A162WWPSMSSenderNumber[0] ;
         A163WWPSMSRecipientNumbers = BC000V14_A163WWPSMSRecipientNumbers[0] ;
         A158WWPSMSStatus = BC000V14_A158WWPSMSStatus[0] ;
         A164WWPSMSCreated = BC000V14_A164WWPSMSCreated[0] ;
         A165WWPSMSScheduled = BC000V14_A165WWPSMSScheduled[0] ;
         A159WWPSMSProcessed = BC000V14_A159WWPSMSProcessed[0] ;
         n159WWPSMSProcessed = BC000V14_n159WWPSMSProcessed[0] ;
         A160WWPSMSDetail = BC000V14_A160WWPSMSDetail[0] ;
         n160WWPSMSDetail = BC000V14_n160WWPSMSDetail[0] ;
         A40WWPNotificationCreated = BC000V14_A40WWPNotificationCreated[0] ;
         A37WWPNotificationId = BC000V14_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000V14_n37WWPNotificationId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0V33( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound33 = (short)(0) ;
      scanKeyLoad0V33( ) ;
   }

   public void scanKeyLoad0V33( )
   {
      sMode33 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A36WWPSMSId = BC000V14_A36WWPSMSId[0] ;
         A161WWPSMSMessage = BC000V14_A161WWPSMSMessage[0] ;
         A162WWPSMSSenderNumber = BC000V14_A162WWPSMSSenderNumber[0] ;
         A163WWPSMSRecipientNumbers = BC000V14_A163WWPSMSRecipientNumbers[0] ;
         A158WWPSMSStatus = BC000V14_A158WWPSMSStatus[0] ;
         A164WWPSMSCreated = BC000V14_A164WWPSMSCreated[0] ;
         A165WWPSMSScheduled = BC000V14_A165WWPSMSScheduled[0] ;
         A159WWPSMSProcessed = BC000V14_A159WWPSMSProcessed[0] ;
         n159WWPSMSProcessed = BC000V14_n159WWPSMSProcessed[0] ;
         A160WWPSMSDetail = BC000V14_A160WWPSMSDetail[0] ;
         n160WWPSMSDetail = BC000V14_n160WWPSMSDetail[0] ;
         A40WWPNotificationCreated = BC000V14_A40WWPNotificationCreated[0] ;
         A37WWPNotificationId = BC000V14_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000V14_n37WWPNotificationId[0] ;
      }
      Gx_mode = sMode33 ;
   }

   public void scanKeyEnd0V33( )
   {
      pr_default.close(12);
   }

   public void afterConfirm0V33( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0V33( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0V33( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0V33( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0V33( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0V33( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0V33( )
   {
   }

   public void send_integrity_lvl_hashes0V33( )
   {
   }

   public void addRow0V33( )
   {
      VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
   }

   public void readRow0V33( )
   {
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
   }

   public void initializeNonKey0V33( )
   {
      A161WWPSMSMessage = "" ;
      A162WWPSMSSenderNumber = "" ;
      A163WWPSMSRecipientNumbers = "" ;
      A159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      n159WWPSMSProcessed = false ;
      A160WWPSMSDetail = "" ;
      n160WWPSMSDetail = false ;
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A158WWPSMSStatus = (short)(1) ;
      A164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z158WWPSMSStatus = (short)(0) ;
      Z164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      Z165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z37WWPNotificationId = 0 ;
   }

   public void initAll0V33( )
   {
      A36WWPSMSId = 0 ;
      initializeNonKey0V33( ) ;
   }

   public void standaloneModalInsert( )
   {
      A158WWPSMSStatus = i158WWPSMSStatus ;
      A164WWPSMSCreated = i164WWPSMSCreated ;
      A165WWPSMSScheduled = i165WWPSMSScheduled ;
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

   public void VarsToRow33( com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS obj33 )
   {
      obj33.setgxTv_SdtWWP_SMS_Mode( Gx_mode );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsmessage( A161WWPSMSMessage );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmssendernumber( A162WWPSMSSenderNumber );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers( A163WWPSMSRecipientNumbers );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsprocessed( A159WWPSMSProcessed );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsdetail( A160WWPSMSDetail );
      obj33.setgxTv_SdtWWP_SMS_Wwpnotificationid( A37WWPNotificationId );
      obj33.setgxTv_SdtWWP_SMS_Wwpnotificationcreated( A40WWPNotificationCreated );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsstatus( A158WWPSMSStatus );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmscreated( A164WWPSMSCreated );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsscheduled( A165WWPSMSScheduled );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsid( A36WWPSMSId );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsid_Z( Z36WWPSMSId );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsstatus_Z( Z158WWPSMSStatus );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmscreated_Z( Z164WWPSMSCreated );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z( Z165WWPSMSScheduled );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z( Z159WWPSMSProcessed );
      obj33.setgxTv_SdtWWP_SMS_Wwpnotificationid_Z( Z37WWPNotificationId );
      obj33.setgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z( Z40WWPNotificationCreated );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsprocessed_N( (byte)((byte)((n159WWPSMSProcessed)?1:0)) );
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsdetail_N( (byte)((byte)((n160WWPSMSDetail)?1:0)) );
      obj33.setgxTv_SdtWWP_SMS_Wwpnotificationid_N( (byte)((byte)((n37WWPNotificationId)?1:0)) );
      obj33.setgxTv_SdtWWP_SMS_Mode( Gx_mode );
   }

   public void KeyVarsToRow33( com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS obj33 )
   {
      obj33.setgxTv_SdtWWP_SMS_Wwpsmsid( A36WWPSMSId );
   }

   public void RowToVars33( com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS obj33 ,
                            int forceLoad )
   {
      Gx_mode = obj33.getgxTv_SdtWWP_SMS_Mode() ;
      A161WWPSMSMessage = obj33.getgxTv_SdtWWP_SMS_Wwpsmsmessage() ;
      A162WWPSMSSenderNumber = obj33.getgxTv_SdtWWP_SMS_Wwpsmssendernumber() ;
      A163WWPSMSRecipientNumbers = obj33.getgxTv_SdtWWP_SMS_Wwpsmsrecipientnumbers() ;
      A159WWPSMSProcessed = obj33.getgxTv_SdtWWP_SMS_Wwpsmsprocessed() ;
      n159WWPSMSProcessed = false ;
      A160WWPSMSDetail = obj33.getgxTv_SdtWWP_SMS_Wwpsmsdetail() ;
      n160WWPSMSDetail = false ;
      A37WWPNotificationId = obj33.getgxTv_SdtWWP_SMS_Wwpnotificationid() ;
      n37WWPNotificationId = false ;
      A40WWPNotificationCreated = obj33.getgxTv_SdtWWP_SMS_Wwpnotificationcreated() ;
      A158WWPSMSStatus = obj33.getgxTv_SdtWWP_SMS_Wwpsmsstatus() ;
      A164WWPSMSCreated = obj33.getgxTv_SdtWWP_SMS_Wwpsmscreated() ;
      A165WWPSMSScheduled = obj33.getgxTv_SdtWWP_SMS_Wwpsmsscheduled() ;
      A36WWPSMSId = obj33.getgxTv_SdtWWP_SMS_Wwpsmsid() ;
      Z36WWPSMSId = obj33.getgxTv_SdtWWP_SMS_Wwpsmsid_Z() ;
      Z158WWPSMSStatus = obj33.getgxTv_SdtWWP_SMS_Wwpsmsstatus_Z() ;
      Z164WWPSMSCreated = obj33.getgxTv_SdtWWP_SMS_Wwpsmscreated_Z() ;
      Z165WWPSMSScheduled = obj33.getgxTv_SdtWWP_SMS_Wwpsmsscheduled_Z() ;
      Z159WWPSMSProcessed = obj33.getgxTv_SdtWWP_SMS_Wwpsmsprocessed_Z() ;
      Z37WWPNotificationId = obj33.getgxTv_SdtWWP_SMS_Wwpnotificationid_Z() ;
      Z40WWPNotificationCreated = obj33.getgxTv_SdtWWP_SMS_Wwpnotificationcreated_Z() ;
      n159WWPSMSProcessed = (boolean)((obj33.getgxTv_SdtWWP_SMS_Wwpsmsprocessed_N()==0)?false:true) ;
      n160WWPSMSDetail = (boolean)((obj33.getgxTv_SdtWWP_SMS_Wwpsmsdetail_N()==0)?false:true) ;
      n37WWPNotificationId = (boolean)((obj33.getgxTv_SdtWWP_SMS_Wwpnotificationid_N()==0)?false:true) ;
      Gx_mode = obj33.getgxTv_SdtWWP_SMS_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A36WWPSMSId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0V33( ) ;
      scanKeyStart0V33( ) ;
      if ( RcdFound33 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z36WWPSMSId = A36WWPSMSId ;
      }
      zm0V33( -8) ;
      onLoadActions0V33( ) ;
      addRow0V33( ) ;
      scanKeyEnd0V33( ) ;
      if ( RcdFound33 == 0 )
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
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 0) ;
      scanKeyStart0V33( ) ;
      if ( RcdFound33 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z36WWPSMSId = A36WWPSMSId ;
      }
      zm0V33( -8) ;
      onLoadActions0V33( ) ;
      addRow0V33( ) ;
      scanKeyEnd0V33( ) ;
      if ( RcdFound33 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0V33( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0V33( ) ;
      }
      else
      {
         if ( RcdFound33 == 1 )
         {
            if ( A36WWPSMSId != Z36WWPSMSId )
            {
               A36WWPSMSId = Z36WWPSMSId ;
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
               update0V33( ) ;
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
               if ( A36WWPSMSId != Z36WWPSMSId )
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
                     insert0V33( ) ;
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
                     insert0V33( ) ;
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
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
      saveImpl( ) ;
      VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0V33( ) ;
      afterTrn( ) ;
      VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
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
         com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS auxBC = new com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A36WWPSMSId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_sms_WWP_SMS);
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
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
      updateImpl( ) ;
      VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
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
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0V33( ) ;
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
      VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0V33( ) ;
      if ( RcdFound33 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A36WWPSMSId != Z36WWPSMSId )
         {
            A36WWPSMSId = Z36WWPSMSId ;
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
         if ( A36WWPSMSId != Z36WWPSMSId )
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
      pr_default.close(11);
      pr_default.close(2);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.sms.wwp_sms_bc");
      VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
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
      Gx_mode = bcwwpbaseobjects_sms_WWP_SMS.getgxTv_SdtWWP_SMS_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_sms_WWP_SMS.setgxTv_SdtWWP_SMS_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_sms_WWP_SMS )
      {
         bcwwpbaseobjects_sms_WWP_SMS = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_sms_WWP_SMS.getgxTv_SdtWWP_SMS_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_sms_WWP_SMS.setgxTv_SdtWWP_SMS_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow33( bcwwpbaseobjects_sms_WWP_SMS) ;
         }
         else
         {
            RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_sms_WWP_SMS.getgxTv_SdtWWP_SMS_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_sms_WWP_SMS.setgxTv_SdtWWP_SMS_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars33( bcwwpbaseobjects_sms_WWP_SMS, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_SMS getWWP_SMS_BC( )
   {
      return bcwwpbaseobjects_sms_WWP_SMS ;
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
      Z164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      A164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      Z165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      A165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      A159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z161WWPSMSMessage = "" ;
      A161WWPSMSMessage = "" ;
      Z162WWPSMSSenderNumber = "" ;
      A162WWPSMSSenderNumber = "" ;
      Z163WWPSMSRecipientNumbers = "" ;
      A163WWPSMSRecipientNumbers = "" ;
      Z160WWPSMSDetail = "" ;
      A160WWPSMSDetail = "" ;
      BC000V5_A36WWPSMSId = new long[1] ;
      BC000V5_A161WWPSMSMessage = new String[] {""} ;
      BC000V5_A162WWPSMSSenderNumber = new String[] {""} ;
      BC000V5_A163WWPSMSRecipientNumbers = new String[] {""} ;
      BC000V5_A158WWPSMSStatus = new short[1] ;
      BC000V5_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V5_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V5_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V5_n159WWPSMSProcessed = new boolean[] {false} ;
      BC000V5_A160WWPSMSDetail = new String[] {""} ;
      BC000V5_n160WWPSMSDetail = new boolean[] {false} ;
      BC000V5_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V5_A37WWPNotificationId = new long[1] ;
      BC000V5_n37WWPNotificationId = new boolean[] {false} ;
      BC000V6_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V7_A36WWPSMSId = new long[1] ;
      BC000V8_A36WWPSMSId = new long[1] ;
      BC000V8_A161WWPSMSMessage = new String[] {""} ;
      BC000V8_A162WWPSMSSenderNumber = new String[] {""} ;
      BC000V8_A163WWPSMSRecipientNumbers = new String[] {""} ;
      BC000V8_A158WWPSMSStatus = new short[1] ;
      BC000V8_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V8_n159WWPSMSProcessed = new boolean[] {false} ;
      BC000V8_A160WWPSMSDetail = new String[] {""} ;
      BC000V8_n160WWPSMSDetail = new boolean[] {false} ;
      BC000V8_A37WWPNotificationId = new long[1] ;
      BC000V8_n37WWPNotificationId = new boolean[] {false} ;
      sMode33 = "" ;
      BC000V9_A36WWPSMSId = new long[1] ;
      BC000V9_A161WWPSMSMessage = new String[] {""} ;
      BC000V9_A162WWPSMSSenderNumber = new String[] {""} ;
      BC000V9_A163WWPSMSRecipientNumbers = new String[] {""} ;
      BC000V9_A158WWPSMSStatus = new short[1] ;
      BC000V9_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V9_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V9_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V9_n159WWPSMSProcessed = new boolean[] {false} ;
      BC000V9_A160WWPSMSDetail = new String[] {""} ;
      BC000V9_n160WWPSMSDetail = new boolean[] {false} ;
      BC000V9_A37WWPNotificationId = new long[1] ;
      BC000V9_n37WWPNotificationId = new boolean[] {false} ;
      BC000V10_A36WWPSMSId = new long[1] ;
      BC000V13_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V14_A36WWPSMSId = new long[1] ;
      BC000V14_A161WWPSMSMessage = new String[] {""} ;
      BC000V14_A162WWPSMSSenderNumber = new String[] {""} ;
      BC000V14_A163WWPSMSRecipientNumbers = new String[] {""} ;
      BC000V14_A158WWPSMSStatus = new short[1] ;
      BC000V14_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V14_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V14_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V14_n159WWPSMSProcessed = new boolean[] {false} ;
      BC000V14_A160WWPSMSDetail = new String[] {""} ;
      BC000V14_n160WWPSMSDetail = new boolean[] {false} ;
      BC000V14_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000V14_A37WWPNotificationId = new long[1] ;
      BC000V14_n37WWPNotificationId = new boolean[] {false} ;
      i164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      i165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.sms.wwp_sms_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.sms.wwp_sms_bc__default(),
         new Object[] {
             new Object[] {
            BC000V2_A36WWPSMSId, BC000V2_A161WWPSMSMessage, BC000V2_A162WWPSMSSenderNumber, BC000V2_A163WWPSMSRecipientNumbers, BC000V2_A158WWPSMSStatus, BC000V2_A164WWPSMSCreated, BC000V2_A165WWPSMSScheduled, BC000V2_A159WWPSMSProcessed, BC000V2_n159WWPSMSProcessed, BC000V2_A160WWPSMSDetail,
            BC000V2_n160WWPSMSDetail, BC000V2_A37WWPNotificationId, BC000V2_n37WWPNotificationId
            }
            , new Object[] {
            BC000V3_A36WWPSMSId, BC000V3_A161WWPSMSMessage, BC000V3_A162WWPSMSSenderNumber, BC000V3_A163WWPSMSRecipientNumbers, BC000V3_A158WWPSMSStatus, BC000V3_A164WWPSMSCreated, BC000V3_A165WWPSMSScheduled, BC000V3_A159WWPSMSProcessed, BC000V3_n159WWPSMSProcessed, BC000V3_A160WWPSMSDetail,
            BC000V3_n160WWPSMSDetail, BC000V3_A37WWPNotificationId, BC000V3_n37WWPNotificationId
            }
            , new Object[] {
            BC000V4_A40WWPNotificationCreated
            }
            , new Object[] {
            BC000V5_A36WWPSMSId, BC000V5_A161WWPSMSMessage, BC000V5_A162WWPSMSSenderNumber, BC000V5_A163WWPSMSRecipientNumbers, BC000V5_A158WWPSMSStatus, BC000V5_A164WWPSMSCreated, BC000V5_A165WWPSMSScheduled, BC000V5_A159WWPSMSProcessed, BC000V5_n159WWPSMSProcessed, BC000V5_A160WWPSMSDetail,
            BC000V5_n160WWPSMSDetail, BC000V5_A40WWPNotificationCreated, BC000V5_A37WWPNotificationId, BC000V5_n37WWPNotificationId
            }
            , new Object[] {
            BC000V6_A40WWPNotificationCreated
            }
            , new Object[] {
            BC000V7_A36WWPSMSId
            }
            , new Object[] {
            BC000V8_A36WWPSMSId, BC000V8_A161WWPSMSMessage, BC000V8_A162WWPSMSSenderNumber, BC000V8_A163WWPSMSRecipientNumbers, BC000V8_A158WWPSMSStatus, BC000V8_A164WWPSMSCreated, BC000V8_A165WWPSMSScheduled, BC000V8_A159WWPSMSProcessed, BC000V8_n159WWPSMSProcessed, BC000V8_A160WWPSMSDetail,
            BC000V8_n160WWPSMSDetail, BC000V8_A37WWPNotificationId, BC000V8_n37WWPNotificationId
            }
            , new Object[] {
            BC000V9_A36WWPSMSId, BC000V9_A161WWPSMSMessage, BC000V9_A162WWPSMSSenderNumber, BC000V9_A163WWPSMSRecipientNumbers, BC000V9_A158WWPSMSStatus, BC000V9_A164WWPSMSCreated, BC000V9_A165WWPSMSScheduled, BC000V9_A159WWPSMSProcessed, BC000V9_n159WWPSMSProcessed, BC000V9_A160WWPSMSDetail,
            BC000V9_n160WWPSMSDetail, BC000V9_A37WWPNotificationId, BC000V9_n37WWPNotificationId
            }
            , new Object[] {
            BC000V10_A36WWPSMSId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000V13_A40WWPNotificationCreated
            }
            , new Object[] {
            BC000V14_A36WWPSMSId, BC000V14_A161WWPSMSMessage, BC000V14_A162WWPSMSSenderNumber, BC000V14_A163WWPSMSRecipientNumbers, BC000V14_A158WWPSMSStatus, BC000V14_A164WWPSMSCreated, BC000V14_A165WWPSMSScheduled, BC000V14_A159WWPSMSProcessed, BC000V14_n159WWPSMSProcessed, BC000V14_A160WWPSMSDetail,
            BC000V14_n160WWPSMSDetail, BC000V14_A40WWPNotificationCreated, BC000V14_A37WWPNotificationId, BC000V14_n37WWPNotificationId
            }
         }
      );
      Z165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z158WWPSMSStatus = (short)(1) ;
      A158WWPSMSStatus = (short)(1) ;
      i158WWPSMSStatus = (short)(1) ;
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z158WWPSMSStatus ;
   private short A158WWPSMSStatus ;
   private short RcdFound33 ;
   private short nIsDirty_33 ;
   private short i158WWPSMSStatus ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z36WWPSMSId ;
   private long A36WWPSMSId ;
   private long Z37WWPNotificationId ;
   private long A37WWPNotificationId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode33 ;
   private java.util.Date Z164WWPSMSCreated ;
   private java.util.Date A164WWPSMSCreated ;
   private java.util.Date Z165WWPSMSScheduled ;
   private java.util.Date A165WWPSMSScheduled ;
   private java.util.Date Z159WWPSMSProcessed ;
   private java.util.Date A159WWPSMSProcessed ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date i164WWPSMSCreated ;
   private java.util.Date i165WWPSMSScheduled ;
   private boolean n159WWPSMSProcessed ;
   private boolean n160WWPSMSDetail ;
   private boolean n37WWPNotificationId ;
   private boolean mustCommit ;
   private String Z161WWPSMSMessage ;
   private String A161WWPSMSMessage ;
   private String Z162WWPSMSSenderNumber ;
   private String A162WWPSMSSenderNumber ;
   private String Z163WWPSMSRecipientNumbers ;
   private String A163WWPSMSRecipientNumbers ;
   private String Z160WWPSMSDetail ;
   private String A160WWPSMSDetail ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS bcwwpbaseobjects_sms_WWP_SMS ;
   private IDataStoreProvider pr_default ;
   private long[] BC000V5_A36WWPSMSId ;
   private String[] BC000V5_A161WWPSMSMessage ;
   private String[] BC000V5_A162WWPSMSSenderNumber ;
   private String[] BC000V5_A163WWPSMSRecipientNumbers ;
   private short[] BC000V5_A158WWPSMSStatus ;
   private java.util.Date[] BC000V5_A164WWPSMSCreated ;
   private java.util.Date[] BC000V5_A165WWPSMSScheduled ;
   private java.util.Date[] BC000V5_A159WWPSMSProcessed ;
   private boolean[] BC000V5_n159WWPSMSProcessed ;
   private String[] BC000V5_A160WWPSMSDetail ;
   private boolean[] BC000V5_n160WWPSMSDetail ;
   private java.util.Date[] BC000V5_A40WWPNotificationCreated ;
   private long[] BC000V5_A37WWPNotificationId ;
   private boolean[] BC000V5_n37WWPNotificationId ;
   private java.util.Date[] BC000V6_A40WWPNotificationCreated ;
   private long[] BC000V7_A36WWPSMSId ;
   private long[] BC000V8_A36WWPSMSId ;
   private String[] BC000V8_A161WWPSMSMessage ;
   private String[] BC000V8_A162WWPSMSSenderNumber ;
   private String[] BC000V8_A163WWPSMSRecipientNumbers ;
   private short[] BC000V8_A158WWPSMSStatus ;
   private java.util.Date[] BC000V8_A164WWPSMSCreated ;
   private java.util.Date[] BC000V8_A165WWPSMSScheduled ;
   private java.util.Date[] BC000V8_A159WWPSMSProcessed ;
   private boolean[] BC000V8_n159WWPSMSProcessed ;
   private String[] BC000V8_A160WWPSMSDetail ;
   private boolean[] BC000V8_n160WWPSMSDetail ;
   private long[] BC000V8_A37WWPNotificationId ;
   private boolean[] BC000V8_n37WWPNotificationId ;
   private long[] BC000V9_A36WWPSMSId ;
   private String[] BC000V9_A161WWPSMSMessage ;
   private String[] BC000V9_A162WWPSMSSenderNumber ;
   private String[] BC000V9_A163WWPSMSRecipientNumbers ;
   private short[] BC000V9_A158WWPSMSStatus ;
   private java.util.Date[] BC000V9_A164WWPSMSCreated ;
   private java.util.Date[] BC000V9_A165WWPSMSScheduled ;
   private java.util.Date[] BC000V9_A159WWPSMSProcessed ;
   private boolean[] BC000V9_n159WWPSMSProcessed ;
   private String[] BC000V9_A160WWPSMSDetail ;
   private boolean[] BC000V9_n160WWPSMSDetail ;
   private long[] BC000V9_A37WWPNotificationId ;
   private boolean[] BC000V9_n37WWPNotificationId ;
   private long[] BC000V10_A36WWPSMSId ;
   private java.util.Date[] BC000V13_A40WWPNotificationCreated ;
   private long[] BC000V14_A36WWPSMSId ;
   private String[] BC000V14_A161WWPSMSMessage ;
   private String[] BC000V14_A162WWPSMSSenderNumber ;
   private String[] BC000V14_A163WWPSMSRecipientNumbers ;
   private short[] BC000V14_A158WWPSMSStatus ;
   private java.util.Date[] BC000V14_A164WWPSMSCreated ;
   private java.util.Date[] BC000V14_A165WWPSMSScheduled ;
   private java.util.Date[] BC000V14_A159WWPSMSProcessed ;
   private boolean[] BC000V14_n159WWPSMSProcessed ;
   private String[] BC000V14_A160WWPSMSDetail ;
   private boolean[] BC000V14_n160WWPSMSDetail ;
   private java.util.Date[] BC000V14_A40WWPNotificationCreated ;
   private long[] BC000V14_A37WWPNotificationId ;
   private boolean[] BC000V14_n37WWPNotificationId ;
   private IDataStoreProvider pr_gam ;
   private long[] BC000V2_A36WWPSMSId ;
   private String[] BC000V2_A161WWPSMSMessage ;
   private String[] BC000V2_A162WWPSMSSenderNumber ;
   private String[] BC000V2_A163WWPSMSRecipientNumbers ;
   private short[] BC000V2_A158WWPSMSStatus ;
   private java.util.Date[] BC000V2_A164WWPSMSCreated ;
   private java.util.Date[] BC000V2_A165WWPSMSScheduled ;
   private java.util.Date[] BC000V2_A159WWPSMSProcessed ;
   private String[] BC000V2_A160WWPSMSDetail ;
   private long[] BC000V2_A37WWPNotificationId ;
   private long[] BC000V3_A36WWPSMSId ;
   private String[] BC000V3_A161WWPSMSMessage ;
   private String[] BC000V3_A162WWPSMSSenderNumber ;
   private String[] BC000V3_A163WWPSMSRecipientNumbers ;
   private short[] BC000V3_A158WWPSMSStatus ;
   private java.util.Date[] BC000V3_A164WWPSMSCreated ;
   private java.util.Date[] BC000V3_A165WWPSMSScheduled ;
   private java.util.Date[] BC000V3_A159WWPSMSProcessed ;
   private String[] BC000V3_A160WWPSMSDetail ;
   private long[] BC000V3_A37WWPNotificationId ;
   private java.util.Date[] BC000V4_A40WWPNotificationCreated ;
   private boolean[] BC000V2_n159WWPSMSProcessed ;
   private boolean[] BC000V2_n160WWPSMSDetail ;
   private boolean[] BC000V2_n37WWPNotificationId ;
   private boolean[] BC000V3_n159WWPSMSProcessed ;
   private boolean[] BC000V3_n160WWPSMSDetail ;
   private boolean[] BC000V3_n37WWPNotificationId ;
}

final  class wwp_sms_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_sms_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000V2", "SELECT [WWPSMSId], [WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId] FROM [WWP_SMS] WITH (UPDLOCK) WHERE [WWPSMSId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V3", "SELECT [WWPSMSId], [WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId] FROM [WWP_SMS] WHERE [WWPSMSId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V4", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V5", "SELECT TM1.[WWPSMSId], TM1.[WWPSMSMessage], TM1.[WWPSMSSenderNumber], TM1.[WWPSMSRecipientNumbers], TM1.[WWPSMSStatus], TM1.[WWPSMSCreated], TM1.[WWPSMSScheduled], TM1.[WWPSMSProcessed], TM1.[WWPSMSDetail], T2.[WWPNotificationCreated], TM1.[WWPNotificationId] FROM ([WWP_SMS] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) WHERE TM1.[WWPSMSId] = ? ORDER BY TM1.[WWPSMSId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V6", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V7", "SELECT [WWPSMSId] FROM [WWP_SMS] WHERE [WWPSMSId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V8", "SELECT [WWPSMSId], [WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId] FROM [WWP_SMS] WHERE [WWPSMSId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V9", "SELECT [WWPSMSId], [WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId] FROM [WWP_SMS] WITH (UPDLOCK) WHERE [WWPSMSId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V10", "INSERT INTO [WWP_SMS]([WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC000V11", "UPDATE [WWP_SMS] SET [WWPSMSMessage]=?, [WWPSMSSenderNumber]=?, [WWPSMSRecipientNumbers]=?, [WWPSMSStatus]=?, [WWPSMSCreated]=?, [WWPSMSScheduled]=?, [WWPSMSProcessed]=?, [WWPSMSDetail]=?, [WWPNotificationId]=?  WHERE [WWPSMSId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000V12", "DELETE FROM [WWP_SMS]  WHERE [WWPSMSId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000V13", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000V14", "SELECT TM1.[WWPSMSId], TM1.[WWPSMSMessage], TM1.[WWPSMSSenderNumber], TM1.[WWPSMSRecipientNumbers], TM1.[WWPSMSStatus], TM1.[WWPSMSCreated], TM1.[WWPSMSScheduled], TM1.[WWPSMSProcessed], TM1.[WWPSMSDetail], T2.[WWPNotificationCreated], TM1.[WWPNotificationId] FROM ([WWP_SMS] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) WHERE TM1.[WWPSMSId] = ? ORDER BY TM1.[WWPSMSId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(10, true);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(10, true);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
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
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDateTime(5, (java.util.Date)parms[4], false, true);
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[7], false, true);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(8, (String)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(9, ((Number) parms[11]).longValue());
               }
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDateTime(5, (java.util.Date)parms[4], false, true);
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[7], false, true);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(8, (String)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(9, ((Number) parms[11]).longValue());
               }
               stmt.setLong(10, ((Number) parms[12]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

