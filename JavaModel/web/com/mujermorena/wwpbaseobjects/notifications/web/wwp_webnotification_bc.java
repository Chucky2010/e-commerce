package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_webnotification_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_webnotification_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_webnotification_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_webnotification_bc.class ));
   }

   public wwp_webnotification_bc( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0W34( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0W34( ) ;
      standaloneModal( ) ;
      addRow0W34( ) ;
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
            Z38WWPWebNotificationId = A38WWPWebNotificationId ;
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

   public void confirm_0W0( )
   {
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0W34( ) ;
         }
         else
         {
            checkExtendedTable0W34( ) ;
            if ( AnyError == 0 )
            {
               zm0W34( 10) ;
               zm0W34( 11) ;
            }
            closeExtendedTableCursors0W34( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0W34( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z166WWPWebNotificationTitle = A166WWPWebNotificationTitle ;
         Z167WWPWebNotificationText = A167WWPWebNotificationText ;
         Z168WWPWebNotificationIcon = A168WWPWebNotificationIcon ;
         Z176WWPWebNotificationStatus = A176WWPWebNotificationStatus ;
         Z169WWPWebNotificationCreated = A169WWPWebNotificationCreated ;
         Z180WWPWebNotificationScheduled = A180WWPWebNotificationScheduled ;
         Z177WWPWebNotificationProcessed = A177WWPWebNotificationProcessed ;
         Z170WWPWebNotificationRead = A170WWPWebNotificationRead ;
         Z179WWPWebNotificationReceived = A179WWPWebNotificationReceived ;
         Z37WWPNotificationId = A37WWPNotificationId ;
      }
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
      }
      if ( GX_JID == -9 )
      {
         Z38WWPWebNotificationId = A38WWPWebNotificationId ;
         Z166WWPWebNotificationTitle = A166WWPWebNotificationTitle ;
         Z167WWPWebNotificationText = A167WWPWebNotificationText ;
         Z168WWPWebNotificationIcon = A168WWPWebNotificationIcon ;
         Z175WWPWebNotificationClientId = A175WWPWebNotificationClientId ;
         Z176WWPWebNotificationStatus = A176WWPWebNotificationStatus ;
         Z169WWPWebNotificationCreated = A169WWPWebNotificationCreated ;
         Z180WWPWebNotificationScheduled = A180WWPWebNotificationScheduled ;
         Z177WWPWebNotificationProcessed = A177WWPWebNotificationProcessed ;
         Z170WWPWebNotificationRead = A170WWPWebNotificationRead ;
         Z178WWPWebNotificationDetail = A178WWPWebNotificationDetail ;
         Z179WWPWebNotificationReceived = A179WWPWebNotificationReceived ;
         Z37WWPNotificationId = A37WWPNotificationId ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
         Z182WWPNotificationMetadata = A182WWPNotificationMetadata ;
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (0==A176WWPWebNotificationStatus) && ( Gx_BScreen == 0 ) )
      {
         A176WWPWebNotificationStatus = (short)(1) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A169WWPWebNotificationCreated) && ( Gx_BScreen == 0 ) )
      {
         A169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A180WWPWebNotificationScheduled) && ( Gx_BScreen == 0 ) )
      {
         A180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0W34( )
   {
      /* Using cursor BC000W6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A35WWPNotificationDefinitionId = BC000W6_A35WWPNotificationDefinitionId[0] ;
         A166WWPWebNotificationTitle = BC000W6_A166WWPWebNotificationTitle[0] ;
         A40WWPNotificationCreated = BC000W6_A40WWPNotificationCreated[0] ;
         A182WWPNotificationMetadata = BC000W6_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000W6_n182WWPNotificationMetadata[0] ;
         A181WWPNotificationDefinitionName = BC000W6_A181WWPNotificationDefinitionName[0] ;
         A167WWPWebNotificationText = BC000W6_A167WWPWebNotificationText[0] ;
         A168WWPWebNotificationIcon = BC000W6_A168WWPWebNotificationIcon[0] ;
         A175WWPWebNotificationClientId = BC000W6_A175WWPWebNotificationClientId[0] ;
         A176WWPWebNotificationStatus = BC000W6_A176WWPWebNotificationStatus[0] ;
         A169WWPWebNotificationCreated = BC000W6_A169WWPWebNotificationCreated[0] ;
         A180WWPWebNotificationScheduled = BC000W6_A180WWPWebNotificationScheduled[0] ;
         A177WWPWebNotificationProcessed = BC000W6_A177WWPWebNotificationProcessed[0] ;
         A170WWPWebNotificationRead = BC000W6_A170WWPWebNotificationRead[0] ;
         n170WWPWebNotificationRead = BC000W6_n170WWPWebNotificationRead[0] ;
         A178WWPWebNotificationDetail = BC000W6_A178WWPWebNotificationDetail[0] ;
         n178WWPWebNotificationDetail = BC000W6_n178WWPWebNotificationDetail[0] ;
         A179WWPWebNotificationReceived = BC000W6_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = BC000W6_n179WWPWebNotificationReceived[0] ;
         A37WWPNotificationId = BC000W6_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000W6_n37WWPNotificationId[0] ;
         zm0W34( -9) ;
      }
      pr_default.close(4);
      onLoadActions0W34( ) ;
   }

   public void onLoadActions0W34( )
   {
   }

   public void checkExtendedTable0W34( )
   {
      nIsDirty_34 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000W7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
         }
      }
      A35WWPNotificationDefinitionId = BC000W7_A35WWPNotificationDefinitionId[0] ;
      A40WWPNotificationCreated = BC000W7_A40WWPNotificationCreated[0] ;
      A182WWPNotificationMetadata = BC000W7_A182WWPNotificationMetadata[0] ;
      n182WWPNotificationMetadata = BC000W7_n182WWPNotificationMetadata[0] ;
      pr_default.close(5);
      /* Using cursor BC000W8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A35WWPNotificationDefinitionId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
            AnyError = (short)(1) ;
         }
      }
      A181WWPNotificationDefinitionName = BC000W8_A181WWPNotificationDefinitionName[0] ;
      pr_default.close(6);
      if ( ! ( ( A176WWPWebNotificationStatus == 1 ) || ( A176WWPWebNotificationStatus == 2 ) || ( A176WWPWebNotificationStatus == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Status", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A169WWPWebNotificationCreated) || (( A169WWPWebNotificationCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A169WWPWebNotificationCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Created", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A180WWPWebNotificationScheduled) || (( A180WWPWebNotificationScheduled.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A180WWPWebNotificationScheduled, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Scheduled", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A177WWPWebNotificationProcessed) || (( A177WWPWebNotificationProcessed.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A177WWPWebNotificationProcessed, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Processed", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A170WWPWebNotificationRead) || (( A170WWPWebNotificationRead.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A170WWPWebNotificationRead, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Read", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0W34( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0W34( )
   {
      /* Using cursor BC000W9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound34 = (short)(1) ;
      }
      else
      {
         RcdFound34 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000W10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0W34( 9) ;
         RcdFound34 = (short)(1) ;
         A38WWPWebNotificationId = BC000W10_A38WWPWebNotificationId[0] ;
         A166WWPWebNotificationTitle = BC000W10_A166WWPWebNotificationTitle[0] ;
         A167WWPWebNotificationText = BC000W10_A167WWPWebNotificationText[0] ;
         A168WWPWebNotificationIcon = BC000W10_A168WWPWebNotificationIcon[0] ;
         A175WWPWebNotificationClientId = BC000W10_A175WWPWebNotificationClientId[0] ;
         A176WWPWebNotificationStatus = BC000W10_A176WWPWebNotificationStatus[0] ;
         A169WWPWebNotificationCreated = BC000W10_A169WWPWebNotificationCreated[0] ;
         A180WWPWebNotificationScheduled = BC000W10_A180WWPWebNotificationScheduled[0] ;
         A177WWPWebNotificationProcessed = BC000W10_A177WWPWebNotificationProcessed[0] ;
         A170WWPWebNotificationRead = BC000W10_A170WWPWebNotificationRead[0] ;
         n170WWPWebNotificationRead = BC000W10_n170WWPWebNotificationRead[0] ;
         A178WWPWebNotificationDetail = BC000W10_A178WWPWebNotificationDetail[0] ;
         n178WWPWebNotificationDetail = BC000W10_n178WWPWebNotificationDetail[0] ;
         A179WWPWebNotificationReceived = BC000W10_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = BC000W10_n179WWPWebNotificationReceived[0] ;
         A37WWPNotificationId = BC000W10_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000W10_n37WWPNotificationId[0] ;
         Z38WWPWebNotificationId = A38WWPWebNotificationId ;
         sMode34 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0W34( ) ;
         if ( AnyError == 1 )
         {
            RcdFound34 = (short)(0) ;
            initializeNonKey0W34( ) ;
         }
         Gx_mode = sMode34 ;
      }
      else
      {
         RcdFound34 = (short)(0) ;
         initializeNonKey0W34( ) ;
         sMode34 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode34 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0W34( ) ;
      if ( RcdFound34 == 0 )
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
      confirm_0W0( ) ;
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

   public void checkOptimisticConcurrency0W34( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000W11 */
         pr_default.execute(9, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebNotification"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z166WWPWebNotificationTitle, BC000W11_A166WWPWebNotificationTitle[0]) != 0 ) || ( GXutil.strcmp(Z167WWPWebNotificationText, BC000W11_A167WWPWebNotificationText[0]) != 0 ) || ( GXutil.strcmp(Z168WWPWebNotificationIcon, BC000W11_A168WWPWebNotificationIcon[0]) != 0 ) || ( Z176WWPWebNotificationStatus != BC000W11_A176WWPWebNotificationStatus[0] ) || !( GXutil.dateCompare(Z169WWPWebNotificationCreated, BC000W11_A169WWPWebNotificationCreated[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(Z180WWPWebNotificationScheduled, BC000W11_A180WWPWebNotificationScheduled[0]) ) || !( GXutil.dateCompare(Z177WWPWebNotificationProcessed, BC000W11_A177WWPWebNotificationProcessed[0]) ) || !( GXutil.dateCompare(Z170WWPWebNotificationRead, BC000W11_A170WWPWebNotificationRead[0]) ) || ( Z179WWPWebNotificationReceived != BC000W11_A179WWPWebNotificationReceived[0] ) || ( Z37WWPNotificationId != BC000W11_A37WWPNotificationId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_WebNotification"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0W34( )
   {
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0W34( 0) ;
         checkOptimisticConcurrency0W34( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0W34( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0W34( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000W12 */
                  pr_default.execute(10, new Object[] {A166WWPWebNotificationTitle, A167WWPWebNotificationText, A168WWPWebNotificationIcon, A175WWPWebNotificationClientId, Short.valueOf(A176WWPWebNotificationStatus), A169WWPWebNotificationCreated, A180WWPWebNotificationScheduled, A177WWPWebNotificationProcessed, Boolean.valueOf(n170WWPWebNotificationRead), A170WWPWebNotificationRead, Boolean.valueOf(n178WWPWebNotificationDetail), A178WWPWebNotificationDetail, Boolean.valueOf(n179WWPWebNotificationReceived), Boolean.valueOf(A179WWPWebNotificationReceived), Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  A38WWPWebNotificationId = BC000W12_A38WWPWebNotificationId[0] ;
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
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
            load0W34( ) ;
         }
         endLevel0W34( ) ;
      }
      closeExtendedTableCursors0W34( ) ;
   }

   public void update0W34( )
   {
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0W34( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0W34( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0W34( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000W13 */
                  pr_default.execute(11, new Object[] {A166WWPWebNotificationTitle, A167WWPWebNotificationText, A168WWPWebNotificationIcon, A175WWPWebNotificationClientId, Short.valueOf(A176WWPWebNotificationStatus), A169WWPWebNotificationCreated, A180WWPWebNotificationScheduled, A177WWPWebNotificationProcessed, Boolean.valueOf(n170WWPWebNotificationRead), A170WWPWebNotificationRead, Boolean.valueOf(n178WWPWebNotificationDetail), A178WWPWebNotificationDetail, Boolean.valueOf(n179WWPWebNotificationReceived), Boolean.valueOf(A179WWPWebNotificationReceived), Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId), Long.valueOf(A38WWPWebNotificationId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebNotification"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0W34( ) ;
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
         endLevel0W34( ) ;
      }
      closeExtendedTableCursors0W34( ) ;
   }

   public void deferredUpdate0W34( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0W34( ) ;
         afterConfirm0W34( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0W34( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000W14 */
               pr_default.execute(12, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
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
      sMode34 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0W34( ) ;
      Gx_mode = sMode34 ;
   }

   public void onDeleteControls0W34( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000W15 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         A35WWPNotificationDefinitionId = BC000W15_A35WWPNotificationDefinitionId[0] ;
         A40WWPNotificationCreated = BC000W15_A40WWPNotificationCreated[0] ;
         A182WWPNotificationMetadata = BC000W15_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000W15_n182WWPNotificationMetadata[0] ;
         pr_default.close(13);
         /* Using cursor BC000W16 */
         pr_default.execute(14, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         A181WWPNotificationDefinitionName = BC000W16_A181WWPNotificationDefinitionName[0] ;
         pr_default.close(14);
      }
   }

   public void endLevel0W34( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0W34( ) ;
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

   public void scanKeyStart0W34( )
   {
      /* Using cursor BC000W17 */
      pr_default.execute(15, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      RcdFound34 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A35WWPNotificationDefinitionId = BC000W17_A35WWPNotificationDefinitionId[0] ;
         A38WWPWebNotificationId = BC000W17_A38WWPWebNotificationId[0] ;
         A166WWPWebNotificationTitle = BC000W17_A166WWPWebNotificationTitle[0] ;
         A40WWPNotificationCreated = BC000W17_A40WWPNotificationCreated[0] ;
         A182WWPNotificationMetadata = BC000W17_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000W17_n182WWPNotificationMetadata[0] ;
         A181WWPNotificationDefinitionName = BC000W17_A181WWPNotificationDefinitionName[0] ;
         A167WWPWebNotificationText = BC000W17_A167WWPWebNotificationText[0] ;
         A168WWPWebNotificationIcon = BC000W17_A168WWPWebNotificationIcon[0] ;
         A175WWPWebNotificationClientId = BC000W17_A175WWPWebNotificationClientId[0] ;
         A176WWPWebNotificationStatus = BC000W17_A176WWPWebNotificationStatus[0] ;
         A169WWPWebNotificationCreated = BC000W17_A169WWPWebNotificationCreated[0] ;
         A180WWPWebNotificationScheduled = BC000W17_A180WWPWebNotificationScheduled[0] ;
         A177WWPWebNotificationProcessed = BC000W17_A177WWPWebNotificationProcessed[0] ;
         A170WWPWebNotificationRead = BC000W17_A170WWPWebNotificationRead[0] ;
         n170WWPWebNotificationRead = BC000W17_n170WWPWebNotificationRead[0] ;
         A178WWPWebNotificationDetail = BC000W17_A178WWPWebNotificationDetail[0] ;
         n178WWPWebNotificationDetail = BC000W17_n178WWPWebNotificationDetail[0] ;
         A179WWPWebNotificationReceived = BC000W17_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = BC000W17_n179WWPWebNotificationReceived[0] ;
         A37WWPNotificationId = BC000W17_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000W17_n37WWPNotificationId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0W34( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound34 = (short)(0) ;
      scanKeyLoad0W34( ) ;
   }

   public void scanKeyLoad0W34( )
   {
      sMode34 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A35WWPNotificationDefinitionId = BC000W17_A35WWPNotificationDefinitionId[0] ;
         A38WWPWebNotificationId = BC000W17_A38WWPWebNotificationId[0] ;
         A166WWPWebNotificationTitle = BC000W17_A166WWPWebNotificationTitle[0] ;
         A40WWPNotificationCreated = BC000W17_A40WWPNotificationCreated[0] ;
         A182WWPNotificationMetadata = BC000W17_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000W17_n182WWPNotificationMetadata[0] ;
         A181WWPNotificationDefinitionName = BC000W17_A181WWPNotificationDefinitionName[0] ;
         A167WWPWebNotificationText = BC000W17_A167WWPWebNotificationText[0] ;
         A168WWPWebNotificationIcon = BC000W17_A168WWPWebNotificationIcon[0] ;
         A175WWPWebNotificationClientId = BC000W17_A175WWPWebNotificationClientId[0] ;
         A176WWPWebNotificationStatus = BC000W17_A176WWPWebNotificationStatus[0] ;
         A169WWPWebNotificationCreated = BC000W17_A169WWPWebNotificationCreated[0] ;
         A180WWPWebNotificationScheduled = BC000W17_A180WWPWebNotificationScheduled[0] ;
         A177WWPWebNotificationProcessed = BC000W17_A177WWPWebNotificationProcessed[0] ;
         A170WWPWebNotificationRead = BC000W17_A170WWPWebNotificationRead[0] ;
         n170WWPWebNotificationRead = BC000W17_n170WWPWebNotificationRead[0] ;
         A178WWPWebNotificationDetail = BC000W17_A178WWPWebNotificationDetail[0] ;
         n178WWPWebNotificationDetail = BC000W17_n178WWPWebNotificationDetail[0] ;
         A179WWPWebNotificationReceived = BC000W17_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = BC000W17_n179WWPWebNotificationReceived[0] ;
         A37WWPNotificationId = BC000W17_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000W17_n37WWPNotificationId[0] ;
      }
      Gx_mode = sMode34 ;
   }

   public void scanKeyEnd0W34( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0W34( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0W34( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0W34( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0W34( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0W34( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0W34( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0W34( )
   {
   }

   public void send_integrity_lvl_hashes0W34( )
   {
   }

   public void addRow0W34( )
   {
      VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
   }

   public void readRow0W34( )
   {
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
   }

   public void initializeNonKey0W34( )
   {
      A35WWPNotificationDefinitionId = 0 ;
      A166WWPWebNotificationTitle = "" ;
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A182WWPNotificationMetadata = "" ;
      n182WWPNotificationMetadata = false ;
      A181WWPNotificationDefinitionName = "" ;
      A167WWPWebNotificationText = "" ;
      A168WWPWebNotificationIcon = "" ;
      A175WWPWebNotificationClientId = "" ;
      A177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      A170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      n170WWPWebNotificationRead = false ;
      A178WWPWebNotificationDetail = "" ;
      n178WWPWebNotificationDetail = false ;
      A179WWPWebNotificationReceived = false ;
      n179WWPWebNotificationReceived = false ;
      A176WWPWebNotificationStatus = (short)(1) ;
      A169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z166WWPWebNotificationTitle = "" ;
      Z167WWPWebNotificationText = "" ;
      Z168WWPWebNotificationIcon = "" ;
      Z176WWPWebNotificationStatus = (short)(0) ;
      Z169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      Z179WWPWebNotificationReceived = false ;
      Z37WWPNotificationId = 0 ;
   }

   public void initAll0W34( )
   {
      A38WWPWebNotificationId = 0 ;
      initializeNonKey0W34( ) ;
   }

   public void standaloneModalInsert( )
   {
      A176WWPWebNotificationStatus = i176WWPWebNotificationStatus ;
      A169WWPWebNotificationCreated = i169WWPWebNotificationCreated ;
      A180WWPWebNotificationScheduled = i180WWPWebNotificationScheduled ;
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

   public void VarsToRow34( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification obj34 )
   {
      obj34.setgxTv_SdtWWP_WebNotification_Mode( Gx_mode );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle( A166WWPWebNotificationTitle );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationid( A37WWPNotificationId );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated( A40WWPNotificationCreated );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata( A182WWPNotificationMetadata );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname( A181WWPNotificationDefinitionName );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext( A167WWPWebNotificationText );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon( A168WWPWebNotificationIcon );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid( A175WWPWebNotificationClientId );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed( A177WWPWebNotificationProcessed );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread( A170WWPWebNotificationRead );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail( A178WWPWebNotificationDetail );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived( A179WWPWebNotificationReceived );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus( A176WWPWebNotificationStatus );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated( A169WWPWebNotificationCreated );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled( A180WWPWebNotificationScheduled );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid( A38WWPWebNotificationId );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z( Z38WWPWebNotificationId );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z( Z166WWPWebNotificationTitle );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z( Z37WWPNotificationId );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z( Z40WWPNotificationCreated );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z( Z181WWPNotificationDefinitionName );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z( Z167WWPWebNotificationText );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z( Z168WWPWebNotificationIcon );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z( Z176WWPWebNotificationStatus );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z( Z169WWPWebNotificationCreated );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z( Z180WWPWebNotificationScheduled );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z( Z177WWPWebNotificationProcessed );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z( Z170WWPWebNotificationRead );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z( Z179WWPWebNotificationReceived );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationid_N( (byte)((byte)((n37WWPNotificationId)?1:0)) );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N( (byte)((byte)((n182WWPNotificationMetadata)?1:0)) );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N( (byte)((byte)((n170WWPWebNotificationRead)?1:0)) );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N( (byte)((byte)((n178WWPWebNotificationDetail)?1:0)) );
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N( (byte)((byte)((n179WWPWebNotificationReceived)?1:0)) );
      obj34.setgxTv_SdtWWP_WebNotification_Mode( Gx_mode );
   }

   public void KeyVarsToRow34( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification obj34 )
   {
      obj34.setgxTv_SdtWWP_WebNotification_Wwpwebnotificationid( A38WWPWebNotificationId );
   }

   public void RowToVars34( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification obj34 ,
                            int forceLoad )
   {
      Gx_mode = obj34.getgxTv_SdtWWP_WebNotification_Mode() ;
      A166WWPWebNotificationTitle = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle() ;
      A37WWPNotificationId = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationid() ;
      n37WWPNotificationId = false ;
      A40WWPNotificationCreated = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated() ;
      A182WWPNotificationMetadata = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata() ;
      n182WWPNotificationMetadata = false ;
      A181WWPNotificationDefinitionName = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname() ;
      A167WWPWebNotificationText = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext() ;
      A168WWPWebNotificationIcon = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon() ;
      A175WWPWebNotificationClientId = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationclientid() ;
      A177WWPWebNotificationProcessed = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed() ;
      A170WWPWebNotificationRead = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread() ;
      n170WWPWebNotificationRead = false ;
      A178WWPWebNotificationDetail = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail() ;
      n178WWPWebNotificationDetail = false ;
      A179WWPWebNotificationReceived = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived() ;
      n179WWPWebNotificationReceived = false ;
      A176WWPWebNotificationStatus = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus() ;
      A169WWPWebNotificationCreated = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated() ;
      A180WWPWebNotificationScheduled = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled() ;
      A38WWPWebNotificationId = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid() ;
      Z38WWPWebNotificationId = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid_Z() ;
      Z166WWPWebNotificationTitle = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle_Z() ;
      Z37WWPNotificationId = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationid_Z() ;
      Z40WWPNotificationCreated = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationcreated_Z() ;
      Z181WWPNotificationDefinitionName = obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationdefinitionname_Z() ;
      Z167WWPWebNotificationText = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext_Z() ;
      Z168WWPWebNotificationIcon = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon_Z() ;
      Z176WWPWebNotificationStatus = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationstatus_Z() ;
      Z169WWPWebNotificationCreated = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationcreated_Z() ;
      Z180WWPWebNotificationScheduled = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationscheduled_Z() ;
      Z177WWPWebNotificationProcessed = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationprocessed_Z() ;
      Z170WWPWebNotificationRead = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_Z() ;
      Z179WWPWebNotificationReceived = obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_Z() ;
      n37WWPNotificationId = (boolean)((obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationid_N()==0)?false:true) ;
      n182WWPNotificationMetadata = (boolean)((obj34.getgxTv_SdtWWP_WebNotification_Wwpnotificationmetadata_N()==0)?false:true) ;
      n170WWPWebNotificationRead = (boolean)((obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationread_N()==0)?false:true) ;
      n178WWPWebNotificationDetail = (boolean)((obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationdetail_N()==0)?false:true) ;
      n179WWPWebNotificationReceived = (boolean)((obj34.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationreceived_N()==0)?false:true) ;
      Gx_mode = obj34.getgxTv_SdtWWP_WebNotification_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A38WWPWebNotificationId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0W34( ) ;
      scanKeyStart0W34( ) ;
      if ( RcdFound34 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z38WWPWebNotificationId = A38WWPWebNotificationId ;
      }
      zm0W34( -9) ;
      onLoadActions0W34( ) ;
      addRow0W34( ) ;
      scanKeyEnd0W34( ) ;
      if ( RcdFound34 == 0 )
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
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 0) ;
      scanKeyStart0W34( ) ;
      if ( RcdFound34 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z38WWPWebNotificationId = A38WWPWebNotificationId ;
      }
      zm0W34( -9) ;
      onLoadActions0W34( ) ;
      addRow0W34( ) ;
      scanKeyEnd0W34( ) ;
      if ( RcdFound34 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0W34( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0W34( ) ;
      }
      else
      {
         if ( RcdFound34 == 1 )
         {
            if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
            {
               A38WWPWebNotificationId = Z38WWPWebNotificationId ;
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
               update0W34( ) ;
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
               if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
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
                     insert0W34( ) ;
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
                     insert0W34( ) ;
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
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
      saveImpl( ) ;
      VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0W34( ) ;
      afterTrn( ) ;
      VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
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
         com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification auxBC = new com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A38WWPWebNotificationId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_notifications_web_WWP_WebNotification);
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
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
      updateImpl( ) ;
      VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
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
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0W34( ) ;
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
      VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0W34( ) ;
      if ( RcdFound34 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
         {
            A38WWPWebNotificationId = Z38WWPWebNotificationId ;
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
         if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
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
      pr_default.close(13);
      pr_default.close(2);
      pr_default.close(14);
      pr_default.close(3);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_webnotification_bc");
      VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
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
      Gx_mode = bcwwpbaseobjects_notifications_web_WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_notifications_web_WWP_WebNotification.setgxTv_SdtWWP_WebNotification_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_notifications_web_WWP_WebNotification )
      {
         bcwwpbaseobjects_notifications_web_WWP_WebNotification = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_web_WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_web_WWP_WebNotification.setgxTv_SdtWWP_WebNotification_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow34( bcwwpbaseobjects_notifications_web_WWP_WebNotification) ;
         }
         else
         {
            RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_web_WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_web_WWP_WebNotification.setgxTv_SdtWWP_WebNotification_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars34( bcwwpbaseobjects_notifications_web_WWP_WebNotification, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_WebNotification getWWP_WebNotification_BC( )
   {
      return bcwwpbaseobjects_notifications_web_WWP_WebNotification ;
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
      Z166WWPWebNotificationTitle = "" ;
      A166WWPWebNotificationTitle = "" ;
      Z167WWPWebNotificationText = "" ;
      A167WWPWebNotificationText = "" ;
      Z168WWPWebNotificationIcon = "" ;
      A168WWPWebNotificationIcon = "" ;
      Z169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      A180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      A177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      A170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z181WWPNotificationDefinitionName = "" ;
      A181WWPNotificationDefinitionName = "" ;
      Z175WWPWebNotificationClientId = "" ;
      A175WWPWebNotificationClientId = "" ;
      Z178WWPWebNotificationDetail = "" ;
      A178WWPWebNotificationDetail = "" ;
      Z182WWPNotificationMetadata = "" ;
      A182WWPNotificationMetadata = "" ;
      BC000W6_A35WWPNotificationDefinitionId = new long[1] ;
      BC000W6_A38WWPWebNotificationId = new long[1] ;
      BC000W6_A166WWPWebNotificationTitle = new String[] {""} ;
      BC000W6_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W6_A182WWPNotificationMetadata = new String[] {""} ;
      BC000W6_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000W6_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000W6_A167WWPWebNotificationText = new String[] {""} ;
      BC000W6_A168WWPWebNotificationIcon = new String[] {""} ;
      BC000W6_A175WWPWebNotificationClientId = new String[] {""} ;
      BC000W6_A176WWPWebNotificationStatus = new short[1] ;
      BC000W6_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W6_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W6_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W6_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W6_n170WWPWebNotificationRead = new boolean[] {false} ;
      BC000W6_A178WWPWebNotificationDetail = new String[] {""} ;
      BC000W6_n178WWPWebNotificationDetail = new boolean[] {false} ;
      BC000W6_A179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W6_n179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W6_A37WWPNotificationId = new long[1] ;
      BC000W6_n37WWPNotificationId = new boolean[] {false} ;
      BC000W7_A35WWPNotificationDefinitionId = new long[1] ;
      BC000W7_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W7_A182WWPNotificationMetadata = new String[] {""} ;
      BC000W7_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000W8_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000W9_A38WWPWebNotificationId = new long[1] ;
      BC000W10_A38WWPWebNotificationId = new long[1] ;
      BC000W10_A166WWPWebNotificationTitle = new String[] {""} ;
      BC000W10_A167WWPWebNotificationText = new String[] {""} ;
      BC000W10_A168WWPWebNotificationIcon = new String[] {""} ;
      BC000W10_A175WWPWebNotificationClientId = new String[] {""} ;
      BC000W10_A176WWPWebNotificationStatus = new short[1] ;
      BC000W10_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W10_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W10_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W10_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W10_n170WWPWebNotificationRead = new boolean[] {false} ;
      BC000W10_A178WWPWebNotificationDetail = new String[] {""} ;
      BC000W10_n178WWPWebNotificationDetail = new boolean[] {false} ;
      BC000W10_A179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W10_n179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W10_A37WWPNotificationId = new long[1] ;
      BC000W10_n37WWPNotificationId = new boolean[] {false} ;
      sMode34 = "" ;
      BC000W11_A38WWPWebNotificationId = new long[1] ;
      BC000W11_A166WWPWebNotificationTitle = new String[] {""} ;
      BC000W11_A167WWPWebNotificationText = new String[] {""} ;
      BC000W11_A168WWPWebNotificationIcon = new String[] {""} ;
      BC000W11_A175WWPWebNotificationClientId = new String[] {""} ;
      BC000W11_A176WWPWebNotificationStatus = new short[1] ;
      BC000W11_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W11_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W11_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W11_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W11_n170WWPWebNotificationRead = new boolean[] {false} ;
      BC000W11_A178WWPWebNotificationDetail = new String[] {""} ;
      BC000W11_n178WWPWebNotificationDetail = new boolean[] {false} ;
      BC000W11_A179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W11_n179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W11_A37WWPNotificationId = new long[1] ;
      BC000W11_n37WWPNotificationId = new boolean[] {false} ;
      BC000W12_A38WWPWebNotificationId = new long[1] ;
      BC000W15_A35WWPNotificationDefinitionId = new long[1] ;
      BC000W15_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W15_A182WWPNotificationMetadata = new String[] {""} ;
      BC000W15_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000W16_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000W17_A35WWPNotificationDefinitionId = new long[1] ;
      BC000W17_A38WWPWebNotificationId = new long[1] ;
      BC000W17_A166WWPWebNotificationTitle = new String[] {""} ;
      BC000W17_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W17_A182WWPNotificationMetadata = new String[] {""} ;
      BC000W17_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000W17_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000W17_A167WWPWebNotificationText = new String[] {""} ;
      BC000W17_A168WWPWebNotificationIcon = new String[] {""} ;
      BC000W17_A175WWPWebNotificationClientId = new String[] {""} ;
      BC000W17_A176WWPWebNotificationStatus = new short[1] ;
      BC000W17_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W17_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W17_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W17_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      BC000W17_n170WWPWebNotificationRead = new boolean[] {false} ;
      BC000W17_A178WWPWebNotificationDetail = new String[] {""} ;
      BC000W17_n178WWPWebNotificationDetail = new boolean[] {false} ;
      BC000W17_A179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W17_n179WWPWebNotificationReceived = new boolean[] {false} ;
      BC000W17_A37WWPNotificationId = new long[1] ;
      BC000W17_n37WWPNotificationId = new boolean[] {false} ;
      i169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      i180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification_bc__default(),
         new Object[] {
             new Object[] {
            BC000W2_A38WWPWebNotificationId, BC000W2_A166WWPWebNotificationTitle, BC000W2_A167WWPWebNotificationText, BC000W2_A168WWPWebNotificationIcon, BC000W2_A175WWPWebNotificationClientId, BC000W2_A176WWPWebNotificationStatus, BC000W2_A169WWPWebNotificationCreated, BC000W2_A180WWPWebNotificationScheduled, BC000W2_A177WWPWebNotificationProcessed, BC000W2_A170WWPWebNotificationRead,
            BC000W2_n170WWPWebNotificationRead, BC000W2_A178WWPWebNotificationDetail, BC000W2_n178WWPWebNotificationDetail, BC000W2_A179WWPWebNotificationReceived, BC000W2_n179WWPWebNotificationReceived, BC000W2_A37WWPNotificationId, BC000W2_n37WWPNotificationId
            }
            , new Object[] {
            BC000W3_A38WWPWebNotificationId, BC000W3_A166WWPWebNotificationTitle, BC000W3_A167WWPWebNotificationText, BC000W3_A168WWPWebNotificationIcon, BC000W3_A175WWPWebNotificationClientId, BC000W3_A176WWPWebNotificationStatus, BC000W3_A169WWPWebNotificationCreated, BC000W3_A180WWPWebNotificationScheduled, BC000W3_A177WWPWebNotificationProcessed, BC000W3_A170WWPWebNotificationRead,
            BC000W3_n170WWPWebNotificationRead, BC000W3_A178WWPWebNotificationDetail, BC000W3_n178WWPWebNotificationDetail, BC000W3_A179WWPWebNotificationReceived, BC000W3_n179WWPWebNotificationReceived, BC000W3_A37WWPNotificationId, BC000W3_n37WWPNotificationId
            }
            , new Object[] {
            BC000W4_A35WWPNotificationDefinitionId, BC000W4_A40WWPNotificationCreated, BC000W4_A182WWPNotificationMetadata, BC000W4_n182WWPNotificationMetadata
            }
            , new Object[] {
            BC000W5_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            BC000W6_A35WWPNotificationDefinitionId, BC000W6_A38WWPWebNotificationId, BC000W6_A166WWPWebNotificationTitle, BC000W6_A40WWPNotificationCreated, BC000W6_A182WWPNotificationMetadata, BC000W6_n182WWPNotificationMetadata, BC000W6_A181WWPNotificationDefinitionName, BC000W6_A167WWPWebNotificationText, BC000W6_A168WWPWebNotificationIcon, BC000W6_A175WWPWebNotificationClientId,
            BC000W6_A176WWPWebNotificationStatus, BC000W6_A169WWPWebNotificationCreated, BC000W6_A180WWPWebNotificationScheduled, BC000W6_A177WWPWebNotificationProcessed, BC000W6_A170WWPWebNotificationRead, BC000W6_n170WWPWebNotificationRead, BC000W6_A178WWPWebNotificationDetail, BC000W6_n178WWPWebNotificationDetail, BC000W6_A179WWPWebNotificationReceived, BC000W6_n179WWPWebNotificationReceived,
            BC000W6_A37WWPNotificationId, BC000W6_n37WWPNotificationId
            }
            , new Object[] {
            BC000W7_A35WWPNotificationDefinitionId, BC000W7_A40WWPNotificationCreated, BC000W7_A182WWPNotificationMetadata, BC000W7_n182WWPNotificationMetadata
            }
            , new Object[] {
            BC000W8_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            BC000W9_A38WWPWebNotificationId
            }
            , new Object[] {
            BC000W10_A38WWPWebNotificationId, BC000W10_A166WWPWebNotificationTitle, BC000W10_A167WWPWebNotificationText, BC000W10_A168WWPWebNotificationIcon, BC000W10_A175WWPWebNotificationClientId, BC000W10_A176WWPWebNotificationStatus, BC000W10_A169WWPWebNotificationCreated, BC000W10_A180WWPWebNotificationScheduled, BC000W10_A177WWPWebNotificationProcessed, BC000W10_A170WWPWebNotificationRead,
            BC000W10_n170WWPWebNotificationRead, BC000W10_A178WWPWebNotificationDetail, BC000W10_n178WWPWebNotificationDetail, BC000W10_A179WWPWebNotificationReceived, BC000W10_n179WWPWebNotificationReceived, BC000W10_A37WWPNotificationId, BC000W10_n37WWPNotificationId
            }
            , new Object[] {
            BC000W11_A38WWPWebNotificationId, BC000W11_A166WWPWebNotificationTitle, BC000W11_A167WWPWebNotificationText, BC000W11_A168WWPWebNotificationIcon, BC000W11_A175WWPWebNotificationClientId, BC000W11_A176WWPWebNotificationStatus, BC000W11_A169WWPWebNotificationCreated, BC000W11_A180WWPWebNotificationScheduled, BC000W11_A177WWPWebNotificationProcessed, BC000W11_A170WWPWebNotificationRead,
            BC000W11_n170WWPWebNotificationRead, BC000W11_A178WWPWebNotificationDetail, BC000W11_n178WWPWebNotificationDetail, BC000W11_A179WWPWebNotificationReceived, BC000W11_n179WWPWebNotificationReceived, BC000W11_A37WWPNotificationId, BC000W11_n37WWPNotificationId
            }
            , new Object[] {
            BC000W12_A38WWPWebNotificationId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000W15_A35WWPNotificationDefinitionId, BC000W15_A40WWPNotificationCreated, BC000W15_A182WWPNotificationMetadata, BC000W15_n182WWPNotificationMetadata
            }
            , new Object[] {
            BC000W16_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            BC000W17_A35WWPNotificationDefinitionId, BC000W17_A38WWPWebNotificationId, BC000W17_A166WWPWebNotificationTitle, BC000W17_A40WWPNotificationCreated, BC000W17_A182WWPNotificationMetadata, BC000W17_n182WWPNotificationMetadata, BC000W17_A181WWPNotificationDefinitionName, BC000W17_A167WWPWebNotificationText, BC000W17_A168WWPWebNotificationIcon, BC000W17_A175WWPWebNotificationClientId,
            BC000W17_A176WWPWebNotificationStatus, BC000W17_A169WWPWebNotificationCreated, BC000W17_A180WWPWebNotificationScheduled, BC000W17_A177WWPWebNotificationProcessed, BC000W17_A170WWPWebNotificationRead, BC000W17_n170WWPWebNotificationRead, BC000W17_A178WWPWebNotificationDetail, BC000W17_n178WWPWebNotificationDetail, BC000W17_A179WWPWebNotificationReceived, BC000W17_n179WWPWebNotificationReceived,
            BC000W17_A37WWPNotificationId, BC000W17_n37WWPNotificationId
            }
         }
      );
      Z180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z176WWPWebNotificationStatus = (short)(1) ;
      A176WWPWebNotificationStatus = (short)(1) ;
      i176WWPWebNotificationStatus = (short)(1) ;
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z176WWPWebNotificationStatus ;
   private short A176WWPWebNotificationStatus ;
   private short RcdFound34 ;
   private short nIsDirty_34 ;
   private short i176WWPWebNotificationStatus ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z38WWPWebNotificationId ;
   private long A38WWPWebNotificationId ;
   private long Z37WWPNotificationId ;
   private long A37WWPNotificationId ;
   private long Z35WWPNotificationDefinitionId ;
   private long A35WWPNotificationDefinitionId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode34 ;
   private java.util.Date Z169WWPWebNotificationCreated ;
   private java.util.Date A169WWPWebNotificationCreated ;
   private java.util.Date Z180WWPWebNotificationScheduled ;
   private java.util.Date A180WWPWebNotificationScheduled ;
   private java.util.Date Z177WWPWebNotificationProcessed ;
   private java.util.Date A177WWPWebNotificationProcessed ;
   private java.util.Date Z170WWPWebNotificationRead ;
   private java.util.Date A170WWPWebNotificationRead ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date i169WWPWebNotificationCreated ;
   private java.util.Date i180WWPWebNotificationScheduled ;
   private boolean Z179WWPWebNotificationReceived ;
   private boolean A179WWPWebNotificationReceived ;
   private boolean n182WWPNotificationMetadata ;
   private boolean n170WWPWebNotificationRead ;
   private boolean n178WWPWebNotificationDetail ;
   private boolean n179WWPWebNotificationReceived ;
   private boolean n37WWPNotificationId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z175WWPWebNotificationClientId ;
   private String A175WWPWebNotificationClientId ;
   private String Z178WWPWebNotificationDetail ;
   private String A178WWPWebNotificationDetail ;
   private String Z182WWPNotificationMetadata ;
   private String A182WWPNotificationMetadata ;
   private String Z166WWPWebNotificationTitle ;
   private String A166WWPWebNotificationTitle ;
   private String Z167WWPWebNotificationText ;
   private String A167WWPWebNotificationText ;
   private String Z168WWPWebNotificationIcon ;
   private String A168WWPWebNotificationIcon ;
   private String Z181WWPNotificationDefinitionName ;
   private String A181WWPNotificationDefinitionName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification bcwwpbaseobjects_notifications_web_WWP_WebNotification ;
   private IDataStoreProvider pr_default ;
   private long[] BC000W6_A35WWPNotificationDefinitionId ;
   private long[] BC000W6_A38WWPWebNotificationId ;
   private String[] BC000W6_A166WWPWebNotificationTitle ;
   private java.util.Date[] BC000W6_A40WWPNotificationCreated ;
   private String[] BC000W6_A182WWPNotificationMetadata ;
   private boolean[] BC000W6_n182WWPNotificationMetadata ;
   private String[] BC000W6_A181WWPNotificationDefinitionName ;
   private String[] BC000W6_A167WWPWebNotificationText ;
   private String[] BC000W6_A168WWPWebNotificationIcon ;
   private String[] BC000W6_A175WWPWebNotificationClientId ;
   private short[] BC000W6_A176WWPWebNotificationStatus ;
   private java.util.Date[] BC000W6_A169WWPWebNotificationCreated ;
   private java.util.Date[] BC000W6_A180WWPWebNotificationScheduled ;
   private java.util.Date[] BC000W6_A177WWPWebNotificationProcessed ;
   private java.util.Date[] BC000W6_A170WWPWebNotificationRead ;
   private boolean[] BC000W6_n170WWPWebNotificationRead ;
   private String[] BC000W6_A178WWPWebNotificationDetail ;
   private boolean[] BC000W6_n178WWPWebNotificationDetail ;
   private boolean[] BC000W6_A179WWPWebNotificationReceived ;
   private boolean[] BC000W6_n179WWPWebNotificationReceived ;
   private long[] BC000W6_A37WWPNotificationId ;
   private boolean[] BC000W6_n37WWPNotificationId ;
   private long[] BC000W7_A35WWPNotificationDefinitionId ;
   private java.util.Date[] BC000W7_A40WWPNotificationCreated ;
   private String[] BC000W7_A182WWPNotificationMetadata ;
   private boolean[] BC000W7_n182WWPNotificationMetadata ;
   private String[] BC000W8_A181WWPNotificationDefinitionName ;
   private long[] BC000W9_A38WWPWebNotificationId ;
   private long[] BC000W10_A38WWPWebNotificationId ;
   private String[] BC000W10_A166WWPWebNotificationTitle ;
   private String[] BC000W10_A167WWPWebNotificationText ;
   private String[] BC000W10_A168WWPWebNotificationIcon ;
   private String[] BC000W10_A175WWPWebNotificationClientId ;
   private short[] BC000W10_A176WWPWebNotificationStatus ;
   private java.util.Date[] BC000W10_A169WWPWebNotificationCreated ;
   private java.util.Date[] BC000W10_A180WWPWebNotificationScheduled ;
   private java.util.Date[] BC000W10_A177WWPWebNotificationProcessed ;
   private java.util.Date[] BC000W10_A170WWPWebNotificationRead ;
   private boolean[] BC000W10_n170WWPWebNotificationRead ;
   private String[] BC000W10_A178WWPWebNotificationDetail ;
   private boolean[] BC000W10_n178WWPWebNotificationDetail ;
   private boolean[] BC000W10_A179WWPWebNotificationReceived ;
   private boolean[] BC000W10_n179WWPWebNotificationReceived ;
   private long[] BC000W10_A37WWPNotificationId ;
   private boolean[] BC000W10_n37WWPNotificationId ;
   private long[] BC000W11_A38WWPWebNotificationId ;
   private String[] BC000W11_A166WWPWebNotificationTitle ;
   private String[] BC000W11_A167WWPWebNotificationText ;
   private String[] BC000W11_A168WWPWebNotificationIcon ;
   private String[] BC000W11_A175WWPWebNotificationClientId ;
   private short[] BC000W11_A176WWPWebNotificationStatus ;
   private java.util.Date[] BC000W11_A169WWPWebNotificationCreated ;
   private java.util.Date[] BC000W11_A180WWPWebNotificationScheduled ;
   private java.util.Date[] BC000W11_A177WWPWebNotificationProcessed ;
   private java.util.Date[] BC000W11_A170WWPWebNotificationRead ;
   private boolean[] BC000W11_n170WWPWebNotificationRead ;
   private String[] BC000W11_A178WWPWebNotificationDetail ;
   private boolean[] BC000W11_n178WWPWebNotificationDetail ;
   private boolean[] BC000W11_A179WWPWebNotificationReceived ;
   private boolean[] BC000W11_n179WWPWebNotificationReceived ;
   private long[] BC000W11_A37WWPNotificationId ;
   private boolean[] BC000W11_n37WWPNotificationId ;
   private long[] BC000W12_A38WWPWebNotificationId ;
   private long[] BC000W15_A35WWPNotificationDefinitionId ;
   private java.util.Date[] BC000W15_A40WWPNotificationCreated ;
   private String[] BC000W15_A182WWPNotificationMetadata ;
   private boolean[] BC000W15_n182WWPNotificationMetadata ;
   private String[] BC000W16_A181WWPNotificationDefinitionName ;
   private long[] BC000W17_A35WWPNotificationDefinitionId ;
   private long[] BC000W17_A38WWPWebNotificationId ;
   private String[] BC000W17_A166WWPWebNotificationTitle ;
   private java.util.Date[] BC000W17_A40WWPNotificationCreated ;
   private String[] BC000W17_A182WWPNotificationMetadata ;
   private boolean[] BC000W17_n182WWPNotificationMetadata ;
   private String[] BC000W17_A181WWPNotificationDefinitionName ;
   private String[] BC000W17_A167WWPWebNotificationText ;
   private String[] BC000W17_A168WWPWebNotificationIcon ;
   private String[] BC000W17_A175WWPWebNotificationClientId ;
   private short[] BC000W17_A176WWPWebNotificationStatus ;
   private java.util.Date[] BC000W17_A169WWPWebNotificationCreated ;
   private java.util.Date[] BC000W17_A180WWPWebNotificationScheduled ;
   private java.util.Date[] BC000W17_A177WWPWebNotificationProcessed ;
   private java.util.Date[] BC000W17_A170WWPWebNotificationRead ;
   private boolean[] BC000W17_n170WWPWebNotificationRead ;
   private String[] BC000W17_A178WWPWebNotificationDetail ;
   private boolean[] BC000W17_n178WWPWebNotificationDetail ;
   private boolean[] BC000W17_A179WWPWebNotificationReceived ;
   private boolean[] BC000W17_n179WWPWebNotificationReceived ;
   private long[] BC000W17_A37WWPNotificationId ;
   private boolean[] BC000W17_n37WWPNotificationId ;
   private IDataStoreProvider pr_gam ;
   private long[] BC000W2_A38WWPWebNotificationId ;
   private String[] BC000W2_A166WWPWebNotificationTitle ;
   private String[] BC000W2_A167WWPWebNotificationText ;
   private String[] BC000W2_A168WWPWebNotificationIcon ;
   private String[] BC000W2_A175WWPWebNotificationClientId ;
   private short[] BC000W2_A176WWPWebNotificationStatus ;
   private java.util.Date[] BC000W2_A169WWPWebNotificationCreated ;
   private java.util.Date[] BC000W2_A180WWPWebNotificationScheduled ;
   private java.util.Date[] BC000W2_A177WWPWebNotificationProcessed ;
   private java.util.Date[] BC000W2_A170WWPWebNotificationRead ;
   private String[] BC000W2_A178WWPWebNotificationDetail ;
   private boolean[] BC000W2_A179WWPWebNotificationReceived ;
   private long[] BC000W2_A37WWPNotificationId ;
   private long[] BC000W3_A38WWPWebNotificationId ;
   private String[] BC000W3_A166WWPWebNotificationTitle ;
   private String[] BC000W3_A167WWPWebNotificationText ;
   private String[] BC000W3_A168WWPWebNotificationIcon ;
   private String[] BC000W3_A175WWPWebNotificationClientId ;
   private short[] BC000W3_A176WWPWebNotificationStatus ;
   private java.util.Date[] BC000W3_A169WWPWebNotificationCreated ;
   private java.util.Date[] BC000W3_A180WWPWebNotificationScheduled ;
   private java.util.Date[] BC000W3_A177WWPWebNotificationProcessed ;
   private java.util.Date[] BC000W3_A170WWPWebNotificationRead ;
   private String[] BC000W3_A178WWPWebNotificationDetail ;
   private boolean[] BC000W3_A179WWPWebNotificationReceived ;
   private long[] BC000W3_A37WWPNotificationId ;
   private long[] BC000W4_A35WWPNotificationDefinitionId ;
   private java.util.Date[] BC000W4_A40WWPNotificationCreated ;
   private String[] BC000W4_A182WWPNotificationMetadata ;
   private String[] BC000W5_A181WWPNotificationDefinitionName ;
   private boolean[] BC000W2_n170WWPWebNotificationRead ;
   private boolean[] BC000W2_n178WWPWebNotificationDetail ;
   private boolean[] BC000W2_n179WWPWebNotificationReceived ;
   private boolean[] BC000W2_n37WWPNotificationId ;
   private boolean[] BC000W3_n170WWPWebNotificationRead ;
   private boolean[] BC000W3_n178WWPWebNotificationDetail ;
   private boolean[] BC000W3_n179WWPWebNotificationReceived ;
   private boolean[] BC000W3_n37WWPNotificationId ;
   private boolean[] BC000W4_n182WWPNotificationMetadata ;
}

final  class wwp_webnotification_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_webnotification_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000W2", "SELECT [WWPWebNotificationId], [WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId] FROM [WWP_WebNotification] WITH (UPDLOCK) WHERE [WWPWebNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W3", "SELECT [WWPWebNotificationId], [WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId] FROM [WWP_WebNotification] WHERE [WWPWebNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W4", "SELECT [WWPNotificationDefinitionId], [WWPNotificationCreated], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W5", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W6", "SELECT T2.[WWPNotificationDefinitionId], TM1.[WWPWebNotificationId], TM1.[WWPWebNotificationTitle], T2.[WWPNotificationCreated], T2.[WWPNotificationMetadata], T3.[WWPNotificationDefinitionName], TM1.[WWPWebNotificationText], TM1.[WWPWebNotificationIcon], TM1.[WWPWebNotificationClientId], TM1.[WWPWebNotificationStatus], TM1.[WWPWebNotificationCreated], TM1.[WWPWebNotificationScheduled], TM1.[WWPWebNotificationProcessed], TM1.[WWPWebNotificationRead], TM1.[WWPWebNotificationDetail], TM1.[WWPWebNotificationReceived], TM1.[WWPNotificationId] FROM (([WWP_WebNotification] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) LEFT JOIN [WWP_NotificationDefinition] T3 ON T3.[WWPNotificationDefinitionId] = T2.[WWPNotificationDefinitionId]) WHERE TM1.[WWPWebNotificationId] = ? ORDER BY TM1.[WWPWebNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W7", "SELECT [WWPNotificationDefinitionId], [WWPNotificationCreated], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W8", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W9", "SELECT [WWPWebNotificationId] FROM [WWP_WebNotification] WHERE [WWPWebNotificationId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W10", "SELECT [WWPWebNotificationId], [WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId] FROM [WWP_WebNotification] WHERE [WWPWebNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W11", "SELECT [WWPWebNotificationId], [WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId] FROM [WWP_WebNotification] WITH (UPDLOCK) WHERE [WWPWebNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W12", "INSERT INTO [WWP_WebNotification]([WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC000W13", "UPDATE [WWP_WebNotification] SET [WWPWebNotificationTitle]=?, [WWPWebNotificationText]=?, [WWPWebNotificationIcon]=?, [WWPWebNotificationClientId]=?, [WWPWebNotificationStatus]=?, [WWPWebNotificationCreated]=?, [WWPWebNotificationScheduled]=?, [WWPWebNotificationProcessed]=?, [WWPWebNotificationRead]=?, [WWPWebNotificationDetail]=?, [WWPWebNotificationReceived]=?, [WWPNotificationId]=?  WHERE [WWPWebNotificationId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000W14", "DELETE FROM [WWP_WebNotification]  WHERE [WWPWebNotificationId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000W15", "SELECT [WWPNotificationDefinitionId], [WWPNotificationCreated], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W16", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000W17", "SELECT T2.[WWPNotificationDefinitionId], TM1.[WWPWebNotificationId], TM1.[WWPWebNotificationTitle], T2.[WWPNotificationCreated], T2.[WWPNotificationMetadata], T3.[WWPNotificationDefinitionName], TM1.[WWPWebNotificationText], TM1.[WWPWebNotificationIcon], TM1.[WWPWebNotificationClientId], TM1.[WWPWebNotificationStatus], TM1.[WWPWebNotificationCreated], TM1.[WWPWebNotificationScheduled], TM1.[WWPWebNotificationProcessed], TM1.[WWPWebNotificationRead], TM1.[WWPWebNotificationDetail], TM1.[WWPWebNotificationReceived], TM1.[WWPNotificationId] FROM (([WWP_WebNotification] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) LEFT JOIN [WWP_NotificationDefinition] T3 ON T3.[WWPNotificationDefinitionId] = T2.[WWPNotificationDefinitionId]) WHERE TM1.[WWPWebNotificationId] = ? ORDER BY TM1.[WWPWebNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(9, true);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDateTime(10, true);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((long[]) buf[15])[0] = rslt.getLong(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(9, true);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDateTime(10, true);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((long[]) buf[15])[0] = rslt.getLong(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(12, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(13, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(14, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(15);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((boolean[]) buf[18])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((long[]) buf[20])[0] = rslt.getLong(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(9, true);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDateTime(10, true);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((long[]) buf[15])[0] = rslt.getLong(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(9, true);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDateTime(10, true);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((long[]) buf[15])[0] = rslt.getLong(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(12, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(13, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(14, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(15);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((boolean[]) buf[18])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((long[]) buf[20])[0] = rslt.getLong(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               stmt.setVarchar(3, (String)parms[2], 255, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               stmt.setDateTime(7, (java.util.Date)parms[6], false, true);
               stmt.setDateTime(8, (java.util.Date)parms[7], false, true);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(9, (java.util.Date)parms[9], false, true);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(10, (String)parms[11]);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[13]).booleanValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(12, ((Number) parms[15]).longValue());
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               stmt.setVarchar(3, (String)parms[2], 255, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               stmt.setDateTime(7, (java.util.Date)parms[6], false, true);
               stmt.setDateTime(8, (java.util.Date)parms[7], false, true);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(9, (java.util.Date)parms[9], false, true);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(10, (String)parms[11]);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[13]).booleanValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(12, ((Number) parms[15]).longValue());
               }
               stmt.setLong(13, ((Number) parms[16]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

