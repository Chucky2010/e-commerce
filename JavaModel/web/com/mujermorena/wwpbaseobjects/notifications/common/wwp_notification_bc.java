package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_notification_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_notification_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_notification_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_notification_bc.class ));
   }

   public wwp_notification_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0Z37( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0Z37( ) ;
      standaloneModal( ) ;
      addRow0Z37( ) ;
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
            Z37WWPNotificationId = A37WWPNotificationId ;
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

   public void confirm_0Z0( )
   {
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Z37( ) ;
         }
         else
         {
            checkExtendedTable0Z37( ) ;
            if ( AnyError == 0 )
            {
               zm0Z37( 6) ;
               zm0Z37( 7) ;
            }
            closeExtendedTableCursors0Z37( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0Z37( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
         Z198WWPNotificationIcon = A198WWPNotificationIcon ;
         Z199WWPNotificationTitle = A199WWPNotificationTitle ;
         Z200WWPNotificationShortDescriptio = A200WWPNotificationShortDescriptio ;
         Z201WWPNotificationLink = A201WWPNotificationLink ;
         Z203WWPNotificationIsRead = A203WWPNotificationIsRead ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
      }
      if ( GX_JID == -5 )
      {
         Z37WWPNotificationId = A37WWPNotificationId ;
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
         Z198WWPNotificationIcon = A198WWPNotificationIcon ;
         Z199WWPNotificationTitle = A199WWPNotificationTitle ;
         Z200WWPNotificationShortDescriptio = A200WWPNotificationShortDescriptio ;
         Z201WWPNotificationLink = A201WWPNotificationLink ;
         Z203WWPNotificationIsRead = A203WWPNotificationIsRead ;
         Z182WWPNotificationMetadata = A182WWPNotificationMetadata ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A40WWPNotificationCreated) && ( Gx_BScreen == 0 ) )
      {
         A40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0Z37( )
   {
      /* Using cursor BC000Z6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A181WWPNotificationDefinitionName = BC000Z6_A181WWPNotificationDefinitionName[0] ;
         A40WWPNotificationCreated = BC000Z6_A40WWPNotificationCreated[0] ;
         A198WWPNotificationIcon = BC000Z6_A198WWPNotificationIcon[0] ;
         A199WWPNotificationTitle = BC000Z6_A199WWPNotificationTitle[0] ;
         A200WWPNotificationShortDescriptio = BC000Z6_A200WWPNotificationShortDescriptio[0] ;
         A201WWPNotificationLink = BC000Z6_A201WWPNotificationLink[0] ;
         A203WWPNotificationIsRead = BC000Z6_A203WWPNotificationIsRead[0] ;
         A138WWPUserExtendedFullName = BC000Z6_A138WWPUserExtendedFullName[0] ;
         A182WWPNotificationMetadata = BC000Z6_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000Z6_n182WWPNotificationMetadata[0] ;
         A35WWPNotificationDefinitionId = BC000Z6_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000Z6_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000Z6_n32WWPUserExtendedId[0] ;
         zm0Z37( -5) ;
      }
      pr_default.close(4);
      onLoadActions0Z37( ) ;
   }

   public void onLoadActions0Z37( )
   {
   }

   public void checkExtendedTable0Z37( )
   {
      nIsDirty_37 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000Z7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
      }
      A181WWPNotificationDefinitionName = BC000Z7_A181WWPNotificationDefinitionName[0] ;
      pr_default.close(5);
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A40WWPNotificationCreated) || (( A40WWPNotificationCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A40WWPNotificationCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Notification Created Date", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A201WWPNotificationLink,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Notification Link", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000Z8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
         }
      }
      A138WWPUserExtendedFullName = BC000Z8_A138WWPUserExtendedFullName[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0Z37( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey0Z37( )
   {
      /* Using cursor BC000Z9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound37 = (short)(1) ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000Z10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm0Z37( 5) ;
         RcdFound37 = (short)(1) ;
         A37WWPNotificationId = BC000Z10_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000Z10_n37WWPNotificationId[0] ;
         A40WWPNotificationCreated = BC000Z10_A40WWPNotificationCreated[0] ;
         A198WWPNotificationIcon = BC000Z10_A198WWPNotificationIcon[0] ;
         A199WWPNotificationTitle = BC000Z10_A199WWPNotificationTitle[0] ;
         A200WWPNotificationShortDescriptio = BC000Z10_A200WWPNotificationShortDescriptio[0] ;
         A201WWPNotificationLink = BC000Z10_A201WWPNotificationLink[0] ;
         A203WWPNotificationIsRead = BC000Z10_A203WWPNotificationIsRead[0] ;
         A182WWPNotificationMetadata = BC000Z10_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000Z10_n182WWPNotificationMetadata[0] ;
         A35WWPNotificationDefinitionId = BC000Z10_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000Z10_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000Z10_n32WWPUserExtendedId[0] ;
         Z37WWPNotificationId = A37WWPNotificationId ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0Z37( ) ;
         if ( AnyError == 1 )
         {
            RcdFound37 = (short)(0) ;
            initializeNonKey0Z37( ) ;
         }
         Gx_mode = sMode37 ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
         initializeNonKey0Z37( ) ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode37 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey0Z37( ) ;
      if ( RcdFound37 == 0 )
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
      confirm_0Z0( ) ;
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

   public void checkOptimisticConcurrency0Z37( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000Z11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Notification"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || !( GXutil.dateCompare(Z40WWPNotificationCreated, BC000Z11_A40WWPNotificationCreated[0]) ) || ( GXutil.strcmp(Z198WWPNotificationIcon, BC000Z11_A198WWPNotificationIcon[0]) != 0 ) || ( GXutil.strcmp(Z199WWPNotificationTitle, BC000Z11_A199WWPNotificationTitle[0]) != 0 ) || ( GXutil.strcmp(Z200WWPNotificationShortDescriptio, BC000Z11_A200WWPNotificationShortDescriptio[0]) != 0 ) || ( GXutil.strcmp(Z201WWPNotificationLink, BC000Z11_A201WWPNotificationLink[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z203WWPNotificationIsRead != BC000Z11_A203WWPNotificationIsRead[0] ) || ( Z35WWPNotificationDefinitionId != BC000Z11_A35WWPNotificationDefinitionId[0] ) || ( GXutil.strcmp(Z32WWPUserExtendedId, BC000Z11_A32WWPUserExtendedId[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Notification"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Z37( )
   {
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Z37( 0) ;
         checkOptimisticConcurrency0Z37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Z37( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Z37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Z12 */
                  pr_default.execute(10, new Object[] {A40WWPNotificationCreated, A198WWPNotificationIcon, A199WWPNotificationTitle, A200WWPNotificationShortDescriptio, A201WWPNotificationLink, Boolean.valueOf(A203WWPNotificationIsRead), Boolean.valueOf(n182WWPNotificationMetadata), A182WWPNotificationMetadata, Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  A37WWPNotificationId = BC000Z12_A37WWPNotificationId[0] ;
                  n37WWPNotificationId = BC000Z12_n37WWPNotificationId[0] ;
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
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
            load0Z37( ) ;
         }
         endLevel0Z37( ) ;
      }
      closeExtendedTableCursors0Z37( ) ;
   }

   public void update0Z37( )
   {
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Z37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Z37( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Z37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Z13 */
                  pr_default.execute(11, new Object[] {A40WWPNotificationCreated, A198WWPNotificationIcon, A199WWPNotificationTitle, A200WWPNotificationShortDescriptio, A201WWPNotificationLink, Boolean.valueOf(A203WWPNotificationIsRead), Boolean.valueOf(n182WWPNotificationMetadata), A182WWPNotificationMetadata, Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Notification"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Z37( ) ;
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
         endLevel0Z37( ) ;
      }
      closeExtendedTableCursors0Z37( ) ;
   }

   public void deferredUpdate0Z37( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Z37( ) ;
         afterConfirm0Z37( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Z37( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000Z14 */
               pr_default.execute(12, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
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
      sMode37 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0Z37( ) ;
      Gx_mode = sMode37 ;
   }

   public void onDeleteControls0Z37( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000Z15 */
         pr_default.execute(13, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         A181WWPNotificationDefinitionName = BC000Z15_A181WWPNotificationDefinitionName[0] ;
         pr_default.close(13);
         /* Using cursor BC000Z16 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         A138WWPUserExtendedFullName = BC000Z16_A138WWPUserExtendedFullName[0] ;
         pr_default.close(14);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000Z17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Mail", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC000Z18 */
         pr_default.execute(16, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_WebNotification", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor BC000Z19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_SMS", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void endLevel0Z37( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Z37( ) ;
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

   public void scanKeyStart0Z37( )
   {
      /* Using cursor BC000Z20 */
      pr_default.execute(18, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A37WWPNotificationId = BC000Z20_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000Z20_n37WWPNotificationId[0] ;
         A181WWPNotificationDefinitionName = BC000Z20_A181WWPNotificationDefinitionName[0] ;
         A40WWPNotificationCreated = BC000Z20_A40WWPNotificationCreated[0] ;
         A198WWPNotificationIcon = BC000Z20_A198WWPNotificationIcon[0] ;
         A199WWPNotificationTitle = BC000Z20_A199WWPNotificationTitle[0] ;
         A200WWPNotificationShortDescriptio = BC000Z20_A200WWPNotificationShortDescriptio[0] ;
         A201WWPNotificationLink = BC000Z20_A201WWPNotificationLink[0] ;
         A203WWPNotificationIsRead = BC000Z20_A203WWPNotificationIsRead[0] ;
         A138WWPUserExtendedFullName = BC000Z20_A138WWPUserExtendedFullName[0] ;
         A182WWPNotificationMetadata = BC000Z20_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000Z20_n182WWPNotificationMetadata[0] ;
         A35WWPNotificationDefinitionId = BC000Z20_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000Z20_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000Z20_n32WWPUserExtendedId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0Z37( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound37 = (short)(0) ;
      scanKeyLoad0Z37( ) ;
   }

   public void scanKeyLoad0Z37( )
   {
      sMode37 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A37WWPNotificationId = BC000Z20_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC000Z20_n37WWPNotificationId[0] ;
         A181WWPNotificationDefinitionName = BC000Z20_A181WWPNotificationDefinitionName[0] ;
         A40WWPNotificationCreated = BC000Z20_A40WWPNotificationCreated[0] ;
         A198WWPNotificationIcon = BC000Z20_A198WWPNotificationIcon[0] ;
         A199WWPNotificationTitle = BC000Z20_A199WWPNotificationTitle[0] ;
         A200WWPNotificationShortDescriptio = BC000Z20_A200WWPNotificationShortDescriptio[0] ;
         A201WWPNotificationLink = BC000Z20_A201WWPNotificationLink[0] ;
         A203WWPNotificationIsRead = BC000Z20_A203WWPNotificationIsRead[0] ;
         A138WWPUserExtendedFullName = BC000Z20_A138WWPUserExtendedFullName[0] ;
         A182WWPNotificationMetadata = BC000Z20_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = BC000Z20_n182WWPNotificationMetadata[0] ;
         A35WWPNotificationDefinitionId = BC000Z20_A35WWPNotificationDefinitionId[0] ;
         A32WWPUserExtendedId = BC000Z20_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000Z20_n32WWPUserExtendedId[0] ;
      }
      Gx_mode = sMode37 ;
   }

   public void scanKeyEnd0Z37( )
   {
      pr_default.close(18);
   }

   public void afterConfirm0Z37( )
   {
      /* After Confirm Rules */
      if ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) )
      {
         A32WWPUserExtendedId = "" ;
         n32WWPUserExtendedId = false ;
         n32WWPUserExtendedId = true ;
      }
   }

   public void beforeInsert0Z37( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Z37( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Z37( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Z37( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Z37( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Z37( )
   {
   }

   public void send_integrity_lvl_hashes0Z37( )
   {
   }

   public void addRow0Z37( )
   {
      VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
   }

   public void readRow0Z37( )
   {
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
   }

   public void initializeNonKey0Z37( )
   {
      A35WWPNotificationDefinitionId = 0 ;
      A181WWPNotificationDefinitionName = "" ;
      A198WWPNotificationIcon = "" ;
      A199WWPNotificationTitle = "" ;
      A200WWPNotificationShortDescriptio = "" ;
      A201WWPNotificationLink = "" ;
      A203WWPNotificationIsRead = false ;
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      A138WWPUserExtendedFullName = "" ;
      A182WWPNotificationMetadata = "" ;
      n182WWPNotificationMetadata = false ;
      A40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z198WWPNotificationIcon = "" ;
      Z199WWPNotificationTitle = "" ;
      Z200WWPNotificationShortDescriptio = "" ;
      Z201WWPNotificationLink = "" ;
      Z203WWPNotificationIsRead = false ;
      Z35WWPNotificationDefinitionId = 0 ;
      Z32WWPUserExtendedId = "" ;
   }

   public void initAll0Z37( )
   {
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      initializeNonKey0Z37( ) ;
   }

   public void standaloneModalInsert( )
   {
      A40WWPNotificationCreated = i40WWPNotificationCreated ;
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

   public void VarsToRow37( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification obj37 )
   {
      obj37.setgxTv_SdtWWP_Notification_Mode( Gx_mode );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid( A35WWPNotificationDefinitionId );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname( A181WWPNotificationDefinitionName );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationicon( A198WWPNotificationIcon );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationtitle( A199WWPNotificationTitle );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription( A200WWPNotificationShortDescriptio );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationlink( A201WWPNotificationLink );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationisread( A203WWPNotificationIsRead );
      obj37.setgxTv_SdtWWP_Notification_Wwpuserextendedid( A32WWPUserExtendedId );
      obj37.setgxTv_SdtWWP_Notification_Wwpuserextendedfullname( A138WWPUserExtendedFullName );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationmetadata( A182WWPNotificationMetadata );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationcreated( A40WWPNotificationCreated );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationid( A37WWPNotificationId );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationid_Z( Z37WWPNotificationId );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z( Z35WWPNotificationDefinitionId );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z( Z181WWPNotificationDefinitionName );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z( Z40WWPNotificationCreated );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationicon_Z( Z198WWPNotificationIcon );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z( Z199WWPNotificationTitle );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z( Z200WWPNotificationShortDescriptio );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationlink_Z( Z201WWPNotificationLink );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationisread_Z( Z203WWPNotificationIsRead );
      obj37.setgxTv_SdtWWP_Notification_Wwpuserextendedid_Z( Z32WWPUserExtendedId );
      obj37.setgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z( Z138WWPUserExtendedFullName );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationid_N( (byte)((byte)((n37WWPNotificationId)?1:0)) );
      obj37.setgxTv_SdtWWP_Notification_Wwpuserextendedid_N( (byte)((byte)((n32WWPUserExtendedId)?1:0)) );
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N( (byte)((byte)((n182WWPNotificationMetadata)?1:0)) );
      obj37.setgxTv_SdtWWP_Notification_Mode( Gx_mode );
   }

   public void KeyVarsToRow37( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification obj37 )
   {
      obj37.setgxTv_SdtWWP_Notification_Wwpnotificationid( A37WWPNotificationId );
   }

   public void RowToVars37( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification obj37 ,
                            int forceLoad )
   {
      Gx_mode = obj37.getgxTv_SdtWWP_Notification_Mode() ;
      A35WWPNotificationDefinitionId = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid() ;
      A181WWPNotificationDefinitionName = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname() ;
      A198WWPNotificationIcon = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationicon() ;
      A199WWPNotificationTitle = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationtitle() ;
      A200WWPNotificationShortDescriptio = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription() ;
      A201WWPNotificationLink = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationlink() ;
      A203WWPNotificationIsRead = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationisread() ;
      A32WWPUserExtendedId = obj37.getgxTv_SdtWWP_Notification_Wwpuserextendedid() ;
      n32WWPUserExtendedId = false ;
      A138WWPUserExtendedFullName = obj37.getgxTv_SdtWWP_Notification_Wwpuserextendedfullname() ;
      A182WWPNotificationMetadata = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationmetadata() ;
      n182WWPNotificationMetadata = false ;
      A40WWPNotificationCreated = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationcreated() ;
      A37WWPNotificationId = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationid() ;
      n37WWPNotificationId = false ;
      Z37WWPNotificationId = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationid_Z() ;
      Z35WWPNotificationDefinitionId = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionid_Z() ;
      Z181WWPNotificationDefinitionName = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationdefinitionname_Z() ;
      Z40WWPNotificationCreated = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationcreated_Z() ;
      Z198WWPNotificationIcon = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationicon_Z() ;
      Z199WWPNotificationTitle = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationtitle_Z() ;
      Z200WWPNotificationShortDescriptio = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationshortdescription_Z() ;
      Z201WWPNotificationLink = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationlink_Z() ;
      Z203WWPNotificationIsRead = obj37.getgxTv_SdtWWP_Notification_Wwpnotificationisread_Z() ;
      Z32WWPUserExtendedId = obj37.getgxTv_SdtWWP_Notification_Wwpuserextendedid_Z() ;
      Z138WWPUserExtendedFullName = obj37.getgxTv_SdtWWP_Notification_Wwpuserextendedfullname_Z() ;
      n37WWPNotificationId = (boolean)((obj37.getgxTv_SdtWWP_Notification_Wwpnotificationid_N()==0)?false:true) ;
      n32WWPUserExtendedId = (boolean)((obj37.getgxTv_SdtWWP_Notification_Wwpuserextendedid_N()==0)?false:true) ;
      n182WWPNotificationMetadata = (boolean)((obj37.getgxTv_SdtWWP_Notification_Wwpnotificationmetadata_N()==0)?false:true) ;
      Gx_mode = obj37.getgxTv_SdtWWP_Notification_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A37WWPNotificationId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      n37WWPNotificationId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0Z37( ) ;
      scanKeyStart0Z37( ) ;
      if ( RcdFound37 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z37WWPNotificationId = A37WWPNotificationId ;
      }
      zm0Z37( -5) ;
      onLoadActions0Z37( ) ;
      addRow0Z37( ) ;
      scanKeyEnd0Z37( ) ;
      if ( RcdFound37 == 0 )
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
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 0) ;
      scanKeyStart0Z37( ) ;
      if ( RcdFound37 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z37WWPNotificationId = A37WWPNotificationId ;
      }
      zm0Z37( -5) ;
      onLoadActions0Z37( ) ;
      addRow0Z37( ) ;
      scanKeyEnd0Z37( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Z37( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0Z37( ) ;
      }
      else
      {
         if ( RcdFound37 == 1 )
         {
            if ( A37WWPNotificationId != Z37WWPNotificationId )
            {
               A37WWPNotificationId = Z37WWPNotificationId ;
               n37WWPNotificationId = false ;
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
               update0Z37( ) ;
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
               if ( A37WWPNotificationId != Z37WWPNotificationId )
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
                     insert0Z37( ) ;
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
                     insert0Z37( ) ;
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
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
      saveImpl( ) ;
      VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Z37( ) ;
      afterTrn( ) ;
      VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
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
         com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification auxBC = new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A37WWPNotificationId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_notifications_common_WWP_Notification);
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
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
      updateImpl( ) ;
      VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
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
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Z37( ) ;
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
      VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0Z37( ) ;
      if ( RcdFound37 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A37WWPNotificationId != Z37WWPNotificationId )
         {
            A37WWPNotificationId = Z37WWPNotificationId ;
            n37WWPNotificationId = false ;
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
         if ( A37WWPNotificationId != Z37WWPNotificationId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_notification_bc");
      VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
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
      Gx_mode = bcwwpbaseobjects_notifications_common_WWP_Notification.getgxTv_SdtWWP_Notification_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_notifications_common_WWP_Notification.setgxTv_SdtWWP_Notification_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_notifications_common_WWP_Notification )
      {
         bcwwpbaseobjects_notifications_common_WWP_Notification = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_common_WWP_Notification.getgxTv_SdtWWP_Notification_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_common_WWP_Notification.setgxTv_SdtWWP_Notification_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow37( bcwwpbaseobjects_notifications_common_WWP_Notification) ;
         }
         else
         {
            RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_common_WWP_Notification.getgxTv_SdtWWP_Notification_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_common_WWP_Notification.setgxTv_SdtWWP_Notification_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars37( bcwwpbaseobjects_notifications_common_WWP_Notification, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_Notification getWWP_Notification_BC( )
   {
      return bcwwpbaseobjects_notifications_common_WWP_Notification ;
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
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z198WWPNotificationIcon = "" ;
      A198WWPNotificationIcon = "" ;
      Z199WWPNotificationTitle = "" ;
      A199WWPNotificationTitle = "" ;
      Z200WWPNotificationShortDescriptio = "" ;
      A200WWPNotificationShortDescriptio = "" ;
      Z201WWPNotificationLink = "" ;
      A201WWPNotificationLink = "" ;
      Z32WWPUserExtendedId = "" ;
      A32WWPUserExtendedId = "" ;
      Z181WWPNotificationDefinitionName = "" ;
      A181WWPNotificationDefinitionName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      A138WWPUserExtendedFullName = "" ;
      Z182WWPNotificationMetadata = "" ;
      A182WWPNotificationMetadata = "" ;
      BC000Z6_A37WWPNotificationId = new long[1] ;
      BC000Z6_n37WWPNotificationId = new boolean[] {false} ;
      BC000Z6_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Z6_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Z6_A198WWPNotificationIcon = new String[] {""} ;
      BC000Z6_A199WWPNotificationTitle = new String[] {""} ;
      BC000Z6_A200WWPNotificationShortDescriptio = new String[] {""} ;
      BC000Z6_A201WWPNotificationLink = new String[] {""} ;
      BC000Z6_A203WWPNotificationIsRead = new boolean[] {false} ;
      BC000Z6_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000Z6_A182WWPNotificationMetadata = new String[] {""} ;
      BC000Z6_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000Z6_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Z6_A32WWPUserExtendedId = new String[] {""} ;
      BC000Z6_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000Z7_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Z8_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000Z9_A37WWPNotificationId = new long[1] ;
      BC000Z9_n37WWPNotificationId = new boolean[] {false} ;
      BC000Z10_A37WWPNotificationId = new long[1] ;
      BC000Z10_n37WWPNotificationId = new boolean[] {false} ;
      BC000Z10_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Z10_A198WWPNotificationIcon = new String[] {""} ;
      BC000Z10_A199WWPNotificationTitle = new String[] {""} ;
      BC000Z10_A200WWPNotificationShortDescriptio = new String[] {""} ;
      BC000Z10_A201WWPNotificationLink = new String[] {""} ;
      BC000Z10_A203WWPNotificationIsRead = new boolean[] {false} ;
      BC000Z10_A182WWPNotificationMetadata = new String[] {""} ;
      BC000Z10_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000Z10_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Z10_A32WWPUserExtendedId = new String[] {""} ;
      BC000Z10_n32WWPUserExtendedId = new boolean[] {false} ;
      sMode37 = "" ;
      BC000Z11_A37WWPNotificationId = new long[1] ;
      BC000Z11_n37WWPNotificationId = new boolean[] {false} ;
      BC000Z11_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Z11_A198WWPNotificationIcon = new String[] {""} ;
      BC000Z11_A199WWPNotificationTitle = new String[] {""} ;
      BC000Z11_A200WWPNotificationShortDescriptio = new String[] {""} ;
      BC000Z11_A201WWPNotificationLink = new String[] {""} ;
      BC000Z11_A203WWPNotificationIsRead = new boolean[] {false} ;
      BC000Z11_A182WWPNotificationMetadata = new String[] {""} ;
      BC000Z11_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000Z11_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Z11_A32WWPUserExtendedId = new String[] {""} ;
      BC000Z11_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000Z12_A37WWPNotificationId = new long[1] ;
      BC000Z12_n37WWPNotificationId = new boolean[] {false} ;
      BC000Z15_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Z16_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000Z17_A42WWPMailId = new long[1] ;
      BC000Z18_A38WWPWebNotificationId = new long[1] ;
      BC000Z19_A36WWPSMSId = new long[1] ;
      BC000Z20_A37WWPNotificationId = new long[1] ;
      BC000Z20_n37WWPNotificationId = new boolean[] {false} ;
      BC000Z20_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Z20_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC000Z20_A198WWPNotificationIcon = new String[] {""} ;
      BC000Z20_A199WWPNotificationTitle = new String[] {""} ;
      BC000Z20_A200WWPNotificationShortDescriptio = new String[] {""} ;
      BC000Z20_A201WWPNotificationLink = new String[] {""} ;
      BC000Z20_A203WWPNotificationIsRead = new boolean[] {false} ;
      BC000Z20_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000Z20_A182WWPNotificationMetadata = new String[] {""} ;
      BC000Z20_n182WWPNotificationMetadata = new boolean[] {false} ;
      BC000Z20_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Z20_A32WWPUserExtendedId = new String[] {""} ;
      BC000Z20_n32WWPUserExtendedId = new boolean[] {false} ;
      i40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification_bc__default(),
         new Object[] {
             new Object[] {
            BC000Z2_A37WWPNotificationId, BC000Z2_A40WWPNotificationCreated, BC000Z2_A198WWPNotificationIcon, BC000Z2_A199WWPNotificationTitle, BC000Z2_A200WWPNotificationShortDescriptio, BC000Z2_A201WWPNotificationLink, BC000Z2_A203WWPNotificationIsRead, BC000Z2_A182WWPNotificationMetadata, BC000Z2_n182WWPNotificationMetadata, BC000Z2_A35WWPNotificationDefinitionId,
            BC000Z2_A32WWPUserExtendedId, BC000Z2_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000Z3_A37WWPNotificationId, BC000Z3_A40WWPNotificationCreated, BC000Z3_A198WWPNotificationIcon, BC000Z3_A199WWPNotificationTitle, BC000Z3_A200WWPNotificationShortDescriptio, BC000Z3_A201WWPNotificationLink, BC000Z3_A203WWPNotificationIsRead, BC000Z3_A182WWPNotificationMetadata, BC000Z3_n182WWPNotificationMetadata, BC000Z3_A35WWPNotificationDefinitionId,
            BC000Z3_A32WWPUserExtendedId, BC000Z3_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000Z4_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            BC000Z5_A138WWPUserExtendedFullName
            }
            , new Object[] {
            BC000Z6_A37WWPNotificationId, BC000Z6_A181WWPNotificationDefinitionName, BC000Z6_A40WWPNotificationCreated, BC000Z6_A198WWPNotificationIcon, BC000Z6_A199WWPNotificationTitle, BC000Z6_A200WWPNotificationShortDescriptio, BC000Z6_A201WWPNotificationLink, BC000Z6_A203WWPNotificationIsRead, BC000Z6_A138WWPUserExtendedFullName, BC000Z6_A182WWPNotificationMetadata,
            BC000Z6_n182WWPNotificationMetadata, BC000Z6_A35WWPNotificationDefinitionId, BC000Z6_A32WWPUserExtendedId, BC000Z6_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000Z7_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            BC000Z8_A138WWPUserExtendedFullName
            }
            , new Object[] {
            BC000Z9_A37WWPNotificationId
            }
            , new Object[] {
            BC000Z10_A37WWPNotificationId, BC000Z10_A40WWPNotificationCreated, BC000Z10_A198WWPNotificationIcon, BC000Z10_A199WWPNotificationTitle, BC000Z10_A200WWPNotificationShortDescriptio, BC000Z10_A201WWPNotificationLink, BC000Z10_A203WWPNotificationIsRead, BC000Z10_A182WWPNotificationMetadata, BC000Z10_n182WWPNotificationMetadata, BC000Z10_A35WWPNotificationDefinitionId,
            BC000Z10_A32WWPUserExtendedId, BC000Z10_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000Z11_A37WWPNotificationId, BC000Z11_A40WWPNotificationCreated, BC000Z11_A198WWPNotificationIcon, BC000Z11_A199WWPNotificationTitle, BC000Z11_A200WWPNotificationShortDescriptio, BC000Z11_A201WWPNotificationLink, BC000Z11_A203WWPNotificationIsRead, BC000Z11_A182WWPNotificationMetadata, BC000Z11_n182WWPNotificationMetadata, BC000Z11_A35WWPNotificationDefinitionId,
            BC000Z11_A32WWPUserExtendedId, BC000Z11_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000Z12_A37WWPNotificationId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000Z15_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            BC000Z16_A138WWPUserExtendedFullName
            }
            , new Object[] {
            BC000Z17_A42WWPMailId
            }
            , new Object[] {
            BC000Z18_A38WWPWebNotificationId
            }
            , new Object[] {
            BC000Z19_A36WWPSMSId
            }
            , new Object[] {
            BC000Z20_A37WWPNotificationId, BC000Z20_A181WWPNotificationDefinitionName, BC000Z20_A40WWPNotificationCreated, BC000Z20_A198WWPNotificationIcon, BC000Z20_A199WWPNotificationTitle, BC000Z20_A200WWPNotificationShortDescriptio, BC000Z20_A201WWPNotificationLink, BC000Z20_A203WWPNotificationIsRead, BC000Z20_A138WWPUserExtendedFullName, BC000Z20_A182WWPNotificationMetadata,
            BC000Z20_n182WWPNotificationMetadata, BC000Z20_A35WWPNotificationDefinitionId, BC000Z20_A32WWPUserExtendedId, BC000Z20_n32WWPUserExtendedId
            }
         }
      );
      Z40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound37 ;
   private short nIsDirty_37 ;
   private int trnEnded ;
   private int GX_JID ;
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
   private String Z32WWPUserExtendedId ;
   private String A32WWPUserExtendedId ;
   private String sMode37 ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date i40WWPNotificationCreated ;
   private boolean Z203WWPNotificationIsRead ;
   private boolean A203WWPNotificationIsRead ;
   private boolean n37WWPNotificationId ;
   private boolean n182WWPNotificationMetadata ;
   private boolean n32WWPUserExtendedId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z182WWPNotificationMetadata ;
   private String A182WWPNotificationMetadata ;
   private String Z198WWPNotificationIcon ;
   private String A198WWPNotificationIcon ;
   private String Z199WWPNotificationTitle ;
   private String A199WWPNotificationTitle ;
   private String Z200WWPNotificationShortDescriptio ;
   private String A200WWPNotificationShortDescriptio ;
   private String Z201WWPNotificationLink ;
   private String A201WWPNotificationLink ;
   private String Z181WWPNotificationDefinitionName ;
   private String A181WWPNotificationDefinitionName ;
   private String Z138WWPUserExtendedFullName ;
   private String A138WWPUserExtendedFullName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification bcwwpbaseobjects_notifications_common_WWP_Notification ;
   private IDataStoreProvider pr_default ;
   private long[] BC000Z6_A37WWPNotificationId ;
   private boolean[] BC000Z6_n37WWPNotificationId ;
   private String[] BC000Z6_A181WWPNotificationDefinitionName ;
   private java.util.Date[] BC000Z6_A40WWPNotificationCreated ;
   private String[] BC000Z6_A198WWPNotificationIcon ;
   private String[] BC000Z6_A199WWPNotificationTitle ;
   private String[] BC000Z6_A200WWPNotificationShortDescriptio ;
   private String[] BC000Z6_A201WWPNotificationLink ;
   private boolean[] BC000Z6_A203WWPNotificationIsRead ;
   private String[] BC000Z6_A138WWPUserExtendedFullName ;
   private String[] BC000Z6_A182WWPNotificationMetadata ;
   private boolean[] BC000Z6_n182WWPNotificationMetadata ;
   private long[] BC000Z6_A35WWPNotificationDefinitionId ;
   private String[] BC000Z6_A32WWPUserExtendedId ;
   private boolean[] BC000Z6_n32WWPUserExtendedId ;
   private String[] BC000Z7_A181WWPNotificationDefinitionName ;
   private String[] BC000Z8_A138WWPUserExtendedFullName ;
   private long[] BC000Z9_A37WWPNotificationId ;
   private boolean[] BC000Z9_n37WWPNotificationId ;
   private long[] BC000Z10_A37WWPNotificationId ;
   private boolean[] BC000Z10_n37WWPNotificationId ;
   private java.util.Date[] BC000Z10_A40WWPNotificationCreated ;
   private String[] BC000Z10_A198WWPNotificationIcon ;
   private String[] BC000Z10_A199WWPNotificationTitle ;
   private String[] BC000Z10_A200WWPNotificationShortDescriptio ;
   private String[] BC000Z10_A201WWPNotificationLink ;
   private boolean[] BC000Z10_A203WWPNotificationIsRead ;
   private String[] BC000Z10_A182WWPNotificationMetadata ;
   private boolean[] BC000Z10_n182WWPNotificationMetadata ;
   private long[] BC000Z10_A35WWPNotificationDefinitionId ;
   private String[] BC000Z10_A32WWPUserExtendedId ;
   private boolean[] BC000Z10_n32WWPUserExtendedId ;
   private long[] BC000Z11_A37WWPNotificationId ;
   private boolean[] BC000Z11_n37WWPNotificationId ;
   private java.util.Date[] BC000Z11_A40WWPNotificationCreated ;
   private String[] BC000Z11_A198WWPNotificationIcon ;
   private String[] BC000Z11_A199WWPNotificationTitle ;
   private String[] BC000Z11_A200WWPNotificationShortDescriptio ;
   private String[] BC000Z11_A201WWPNotificationLink ;
   private boolean[] BC000Z11_A203WWPNotificationIsRead ;
   private String[] BC000Z11_A182WWPNotificationMetadata ;
   private boolean[] BC000Z11_n182WWPNotificationMetadata ;
   private long[] BC000Z11_A35WWPNotificationDefinitionId ;
   private String[] BC000Z11_A32WWPUserExtendedId ;
   private boolean[] BC000Z11_n32WWPUserExtendedId ;
   private long[] BC000Z12_A37WWPNotificationId ;
   private boolean[] BC000Z12_n37WWPNotificationId ;
   private String[] BC000Z15_A181WWPNotificationDefinitionName ;
   private String[] BC000Z16_A138WWPUserExtendedFullName ;
   private long[] BC000Z17_A42WWPMailId ;
   private long[] BC000Z18_A38WWPWebNotificationId ;
   private long[] BC000Z19_A36WWPSMSId ;
   private long[] BC000Z20_A37WWPNotificationId ;
   private boolean[] BC000Z20_n37WWPNotificationId ;
   private String[] BC000Z20_A181WWPNotificationDefinitionName ;
   private java.util.Date[] BC000Z20_A40WWPNotificationCreated ;
   private String[] BC000Z20_A198WWPNotificationIcon ;
   private String[] BC000Z20_A199WWPNotificationTitle ;
   private String[] BC000Z20_A200WWPNotificationShortDescriptio ;
   private String[] BC000Z20_A201WWPNotificationLink ;
   private boolean[] BC000Z20_A203WWPNotificationIsRead ;
   private String[] BC000Z20_A138WWPUserExtendedFullName ;
   private String[] BC000Z20_A182WWPNotificationMetadata ;
   private boolean[] BC000Z20_n182WWPNotificationMetadata ;
   private long[] BC000Z20_A35WWPNotificationDefinitionId ;
   private String[] BC000Z20_A32WWPUserExtendedId ;
   private boolean[] BC000Z20_n32WWPUserExtendedId ;
   private IDataStoreProvider pr_gam ;
   private long[] BC000Z2_A37WWPNotificationId ;
   private java.util.Date[] BC000Z2_A40WWPNotificationCreated ;
   private String[] BC000Z2_A198WWPNotificationIcon ;
   private String[] BC000Z2_A199WWPNotificationTitle ;
   private String[] BC000Z2_A200WWPNotificationShortDescriptio ;
   private String[] BC000Z2_A201WWPNotificationLink ;
   private boolean[] BC000Z2_A203WWPNotificationIsRead ;
   private String[] BC000Z2_A182WWPNotificationMetadata ;
   private long[] BC000Z2_A35WWPNotificationDefinitionId ;
   private String[] BC000Z2_A32WWPUserExtendedId ;
   private long[] BC000Z3_A37WWPNotificationId ;
   private java.util.Date[] BC000Z3_A40WWPNotificationCreated ;
   private String[] BC000Z3_A198WWPNotificationIcon ;
   private String[] BC000Z3_A199WWPNotificationTitle ;
   private String[] BC000Z3_A200WWPNotificationShortDescriptio ;
   private String[] BC000Z3_A201WWPNotificationLink ;
   private boolean[] BC000Z3_A203WWPNotificationIsRead ;
   private String[] BC000Z3_A182WWPNotificationMetadata ;
   private long[] BC000Z3_A35WWPNotificationDefinitionId ;
   private String[] BC000Z3_A32WWPUserExtendedId ;
   private String[] BC000Z4_A181WWPNotificationDefinitionName ;
   private String[] BC000Z5_A138WWPUserExtendedFullName ;
   private boolean[] BC000Z2_n182WWPNotificationMetadata ;
   private boolean[] BC000Z2_n32WWPUserExtendedId ;
   private boolean[] BC000Z3_n182WWPNotificationMetadata ;
   private boolean[] BC000Z3_n32WWPUserExtendedId ;
}

final  class wwp_notification_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_notification_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000Z2", "SELECT [WWPNotificationId], [WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Notification] WITH (UPDLOCK) WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z3", "SELECT [WWPNotificationId], [WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z4", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z5", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z6", "SELECT TM1.[WWPNotificationId], T2.[WWPNotificationDefinitionName], TM1.[WWPNotificationCreated], TM1.[WWPNotificationIcon], TM1.[WWPNotificationTitle], TM1.[WWPNotificationShortDescriptio], TM1.[WWPNotificationLink], TM1.[WWPNotificationIsRead], T3.[WWPUserExtendedFullName], TM1.[WWPNotificationMetadata], TM1.[WWPNotificationDefinitionId], TM1.[WWPUserExtendedId] FROM (([WWP_Notification] TM1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = TM1.[WWPNotificationDefinitionId]) LEFT JOIN [WWP_UserExtended] T3 ON T3.[WWPUserExtendedId] = TM1.[WWPUserExtendedId]) WHERE TM1.[WWPNotificationId] = ? ORDER BY TM1.[WWPNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z7", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z8", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z9", "SELECT [WWPNotificationId] FROM [WWP_Notification] WHERE [WWPNotificationId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z10", "SELECT [WWPNotificationId], [WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z11", "SELECT [WWPNotificationId], [WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Notification] WITH (UPDLOCK) WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z12", "INSERT INTO [WWP_Notification]([WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC000Z13", "UPDATE [WWP_Notification] SET [WWPNotificationCreated]=?, [WWPNotificationIcon]=?, [WWPNotificationTitle]=?, [WWPNotificationShortDescriptio]=?, [WWPNotificationLink]=?, [WWPNotificationIsRead]=?, [WWPNotificationMetadata]=?, [WWPNotificationDefinitionId]=?, [WWPUserExtendedId]=?  WHERE [WWPNotificationId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000Z14", "DELETE FROM [WWP_Notification]  WHERE [WWPNotificationId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000Z15", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z16", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Z17", "SELECT TOP 1 [WWPMailId] FROM [WWP_Mail] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000Z18", "SELECT TOP 1 [WWPWebNotificationId] FROM [WWP_WebNotification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000Z19", "SELECT TOP 1 [WWPSMSId] FROM [WWP_SMS] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000Z20", "SELECT TM1.[WWPNotificationId], T2.[WWPNotificationDefinitionName], TM1.[WWPNotificationCreated], TM1.[WWPNotificationIcon], TM1.[WWPNotificationTitle], TM1.[WWPNotificationShortDescriptio], TM1.[WWPNotificationLink], TM1.[WWPNotificationIsRead], T3.[WWPUserExtendedFullName], TM1.[WWPNotificationMetadata], TM1.[WWPNotificationDefinitionId], TM1.[WWPUserExtendedId] FROM (([WWP_Notification] TM1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = TM1.[WWPNotificationDefinitionId]) LEFT JOIN [WWP_UserExtended] T3 ON T3.[WWPUserExtendedId] = TM1.[WWPUserExtendedId]) WHERE TM1.[WWPNotificationId] = ? ORDER BY TM1.[WWPNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3, true);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 17 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3, true);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 40);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 10 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false, true);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 1000, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(7, (String)parms[7]);
               }
               stmt.setLong(8, ((Number) parms[8]).longValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 40);
               }
               return;
            case 11 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false, true);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 1000, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(7, (String)parms[7]);
               }
               stmt.setLong(8, ((Number) parms[8]).longValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 40);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(10, ((Number) parms[12]).longValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 18 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
      }
   }

}

