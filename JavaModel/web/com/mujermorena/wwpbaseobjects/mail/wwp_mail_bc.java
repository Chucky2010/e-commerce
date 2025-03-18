package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_mail_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_mail_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_mail_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_mail_bc.class ));
   }

   public wwp_mail_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1139( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1139( ) ;
      standaloneModal( ) ;
      addRow1139( ) ;
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
            Z42WWPMailId = A42WWPMailId ;
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

   public void confirm_110( )
   {
      beforeValidate1139( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1139( ) ;
         }
         else
         {
            checkExtendedTable1139( ) ;
            if ( AnyError == 0 )
            {
               zm1139( 9) ;
            }
            closeExtendedTableCursors1139( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode39 = Gx_mode ;
         confirm_1140( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode39 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode39 ;
      }
   }

   public void confirm_1140( )
   {
      nGXsfl_40_idx = 0 ;
      while ( nGXsfl_40_idx < bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().size() )
      {
         readRow1140( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound40 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_40 != 0 ) )
         {
            getKey1140( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound40 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate1140( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1140( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors1140( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound40 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey1140( ) ;
                     load1140( ) ;
                     beforeValidate1140( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1140( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_40 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate1140( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1140( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors1140( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow40( ((com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().elementAt(-1+nGXsfl_40_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void zm1139( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z191WWPMailSubject = A191WWPMailSubject ;
         Z202WWPMailStatus = A202WWPMailStatus ;
         Z211WWPMailCreated = A211WWPMailCreated ;
         Z212WWPMailScheduled = A212WWPMailScheduled ;
         Z207WWPMailProcessed = A207WWPMailProcessed ;
         Z37WWPNotificationId = A37WWPNotificationId ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
      }
      if ( GX_JID == -8 )
      {
         Z42WWPMailId = A42WWPMailId ;
         Z191WWPMailSubject = A191WWPMailSubject ;
         Z183WWPMailBody = A183WWPMailBody ;
         Z192WWPMailTo = A192WWPMailTo ;
         Z204WWPMailCC = A204WWPMailCC ;
         Z205WWPMailBCC = A205WWPMailBCC ;
         Z193WWPMailSenderAddress = A193WWPMailSenderAddress ;
         Z194WWPMailSenderName = A194WWPMailSenderName ;
         Z202WWPMailStatus = A202WWPMailStatus ;
         Z211WWPMailCreated = A211WWPMailCreated ;
         Z212WWPMailScheduled = A212WWPMailScheduled ;
         Z207WWPMailProcessed = A207WWPMailProcessed ;
         Z208WWPMailDetail = A208WWPMailDetail ;
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
      if ( isIns( )  && (0==A202WWPMailStatus) && ( Gx_BScreen == 0 ) )
      {
         A202WWPMailStatus = (short)(1) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A211WWPMailCreated) && ( Gx_BScreen == 0 ) )
      {
         A211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A212WWPMailScheduled) && ( Gx_BScreen == 0 ) )
      {
         A212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load1139( )
   {
      /* Using cursor BC00117 */
      pr_default.execute(5, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A191WWPMailSubject = BC00117_A191WWPMailSubject[0] ;
         A183WWPMailBody = BC00117_A183WWPMailBody[0] ;
         A192WWPMailTo = BC00117_A192WWPMailTo[0] ;
         n192WWPMailTo = BC00117_n192WWPMailTo[0] ;
         A204WWPMailCC = BC00117_A204WWPMailCC[0] ;
         n204WWPMailCC = BC00117_n204WWPMailCC[0] ;
         A205WWPMailBCC = BC00117_A205WWPMailBCC[0] ;
         n205WWPMailBCC = BC00117_n205WWPMailBCC[0] ;
         A193WWPMailSenderAddress = BC00117_A193WWPMailSenderAddress[0] ;
         A194WWPMailSenderName = BC00117_A194WWPMailSenderName[0] ;
         A202WWPMailStatus = BC00117_A202WWPMailStatus[0] ;
         A211WWPMailCreated = BC00117_A211WWPMailCreated[0] ;
         A212WWPMailScheduled = BC00117_A212WWPMailScheduled[0] ;
         A207WWPMailProcessed = BC00117_A207WWPMailProcessed[0] ;
         n207WWPMailProcessed = BC00117_n207WWPMailProcessed[0] ;
         A208WWPMailDetail = BC00117_A208WWPMailDetail[0] ;
         n208WWPMailDetail = BC00117_n208WWPMailDetail[0] ;
         A40WWPNotificationCreated = BC00117_A40WWPNotificationCreated[0] ;
         A37WWPNotificationId = BC00117_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC00117_n37WWPNotificationId[0] ;
         zm1139( -8) ;
      }
      pr_default.close(5);
      onLoadActions1139( ) ;
   }

   public void onLoadActions1139( )
   {
   }

   public void checkExtendedTable1139( )
   {
      nIsDirty_39 = (short)(0) ;
      standaloneModal( ) ;
      if ( ! ( ( A202WWPMailStatus == 1 ) || ( A202WWPMailStatus == 2 ) || ( A202WWPMailStatus == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Status", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A211WWPMailCreated) || (( A211WWPMailCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A211WWPMailCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Created", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A212WWPMailScheduled) || (( A212WWPMailScheduled.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A212WWPMailScheduled, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Scheduled", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A207WWPMailProcessed) || (( A207WWPMailProcessed.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A207WWPMailProcessed, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Processed", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC00118 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
         }
      }
      A40WWPNotificationCreated = BC00118_A40WWPNotificationCreated[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors1139( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1139( )
   {
      /* Using cursor BC00119 */
      pr_default.execute(7, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound39 = (short)(1) ;
      }
      else
      {
         RcdFound39 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001110 */
      pr_default.execute(8, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1139( 8) ;
         RcdFound39 = (short)(1) ;
         A42WWPMailId = BC001110_A42WWPMailId[0] ;
         A191WWPMailSubject = BC001110_A191WWPMailSubject[0] ;
         A183WWPMailBody = BC001110_A183WWPMailBody[0] ;
         A192WWPMailTo = BC001110_A192WWPMailTo[0] ;
         n192WWPMailTo = BC001110_n192WWPMailTo[0] ;
         A204WWPMailCC = BC001110_A204WWPMailCC[0] ;
         n204WWPMailCC = BC001110_n204WWPMailCC[0] ;
         A205WWPMailBCC = BC001110_A205WWPMailBCC[0] ;
         n205WWPMailBCC = BC001110_n205WWPMailBCC[0] ;
         A193WWPMailSenderAddress = BC001110_A193WWPMailSenderAddress[0] ;
         A194WWPMailSenderName = BC001110_A194WWPMailSenderName[0] ;
         A202WWPMailStatus = BC001110_A202WWPMailStatus[0] ;
         A211WWPMailCreated = BC001110_A211WWPMailCreated[0] ;
         A212WWPMailScheduled = BC001110_A212WWPMailScheduled[0] ;
         A207WWPMailProcessed = BC001110_A207WWPMailProcessed[0] ;
         n207WWPMailProcessed = BC001110_n207WWPMailProcessed[0] ;
         A208WWPMailDetail = BC001110_A208WWPMailDetail[0] ;
         n208WWPMailDetail = BC001110_n208WWPMailDetail[0] ;
         A37WWPNotificationId = BC001110_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC001110_n37WWPNotificationId[0] ;
         Z42WWPMailId = A42WWPMailId ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1139( ) ;
         if ( AnyError == 1 )
         {
            RcdFound39 = (short)(0) ;
            initializeNonKey1139( ) ;
         }
         Gx_mode = sMode39 ;
      }
      else
      {
         RcdFound39 = (short)(0) ;
         initializeNonKey1139( ) ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode39 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1139( ) ;
      if ( RcdFound39 == 0 )
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
      confirm_110( ) ;
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

   public void checkOptimisticConcurrency1139( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001111 */
         pr_default.execute(9, new Object[] {Long.valueOf(A42WWPMailId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Mail"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z191WWPMailSubject, BC001111_A191WWPMailSubject[0]) != 0 ) || ( Z202WWPMailStatus != BC001111_A202WWPMailStatus[0] ) || !( GXutil.dateCompare(Z211WWPMailCreated, BC001111_A211WWPMailCreated[0]) ) || !( GXutil.dateCompare(Z212WWPMailScheduled, BC001111_A212WWPMailScheduled[0]) ) || !( GXutil.dateCompare(Z207WWPMailProcessed, BC001111_A207WWPMailProcessed[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z37WWPNotificationId != BC001111_A37WWPNotificationId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Mail"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1139( )
   {
      beforeValidate1139( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1139( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1139( 0) ;
         checkOptimisticConcurrency1139( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1139( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1139( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001112 */
                  pr_default.execute(10, new Object[] {A191WWPMailSubject, A183WWPMailBody, Boolean.valueOf(n192WWPMailTo), A192WWPMailTo, Boolean.valueOf(n204WWPMailCC), A204WWPMailCC, Boolean.valueOf(n205WWPMailBCC), A205WWPMailBCC, A193WWPMailSenderAddress, A194WWPMailSenderName, Short.valueOf(A202WWPMailStatus), A211WWPMailCreated, A212WWPMailScheduled, Boolean.valueOf(n207WWPMailProcessed), A207WWPMailProcessed, Boolean.valueOf(n208WWPMailDetail), A208WWPMailDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  A42WWPMailId = BC001112_A42WWPMailId[0] ;
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Mail");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1139( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
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
            load1139( ) ;
         }
         endLevel1139( ) ;
      }
      closeExtendedTableCursors1139( ) ;
   }

   public void update1139( )
   {
      beforeValidate1139( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1139( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1139( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1139( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1139( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001113 */
                  pr_default.execute(11, new Object[] {A191WWPMailSubject, A183WWPMailBody, Boolean.valueOf(n192WWPMailTo), A192WWPMailTo, Boolean.valueOf(n204WWPMailCC), A204WWPMailCC, Boolean.valueOf(n205WWPMailBCC), A205WWPMailBCC, A193WWPMailSenderAddress, A194WWPMailSenderName, Short.valueOf(A202WWPMailStatus), A211WWPMailCreated, A212WWPMailScheduled, Boolean.valueOf(n207WWPMailProcessed), A207WWPMailProcessed, Boolean.valueOf(n208WWPMailDetail), A208WWPMailDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId), Long.valueOf(A42WWPMailId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Mail");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Mail"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1139( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1139( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
         }
         endLevel1139( ) ;
      }
      closeExtendedTableCursors1139( ) ;
   }

   public void deferredUpdate1139( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1139( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1139( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1139( ) ;
         afterConfirm1139( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1139( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart1140( ) ;
               while ( RcdFound40 != 0 )
               {
                  getByPrimaryKey1140( ) ;
                  delete1140( ) ;
                  scanKeyNext1140( ) ;
               }
               scanKeyEnd1140( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001114 */
                  pr_default.execute(12, new Object[] {Long.valueOf(A42WWPMailId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Mail");
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
      }
      sMode39 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1139( ) ;
      Gx_mode = sMode39 ;
   }

   public void onDeleteControls1139( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC001115 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         A40WWPNotificationCreated = BC001115_A40WWPNotificationCreated[0] ;
         pr_default.close(13);
      }
   }

   public void processNestedLevel1140( )
   {
      nGXsfl_40_idx = 0 ;
      while ( nGXsfl_40_idx < bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().size() )
      {
         readRow1140( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound40 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_40 != 0 ) )
         {
            standaloneNotModal1140( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert1140( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete1140( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update1140( ) ;
               }
            }
         }
         KeyVarsToRow40( ((com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().elementAt(-1+nGXsfl_40_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_40_idx = 0 ;
         while ( nGXsfl_40_idx < bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().size() )
         {
            readRow1140( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound40 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().removeElement(nGXsfl_40_idx);
               nGXsfl_40_idx = (int)(nGXsfl_40_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey1140( ) ;
               VarsToRow40( ((com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().elementAt(-1+nGXsfl_40_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1140( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_40 = (short)(0) ;
      nIsMod_40 = (short)(0) ;
      Gxremove40 = (byte)(0) ;
   }

   public void processLevel1139( )
   {
      /* Save parent mode. */
      sMode39 = Gx_mode ;
      processNestedLevel1140( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode39 ;
      /* ' Update level parameters */
   }

   public void endLevel1139( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1139( ) ;
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

   public void scanKeyStart1139( )
   {
      /* Using cursor BC001116 */
      pr_default.execute(14, new Object[] {Long.valueOf(A42WWPMailId)});
      RcdFound39 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A42WWPMailId = BC001116_A42WWPMailId[0] ;
         A191WWPMailSubject = BC001116_A191WWPMailSubject[0] ;
         A183WWPMailBody = BC001116_A183WWPMailBody[0] ;
         A192WWPMailTo = BC001116_A192WWPMailTo[0] ;
         n192WWPMailTo = BC001116_n192WWPMailTo[0] ;
         A204WWPMailCC = BC001116_A204WWPMailCC[0] ;
         n204WWPMailCC = BC001116_n204WWPMailCC[0] ;
         A205WWPMailBCC = BC001116_A205WWPMailBCC[0] ;
         n205WWPMailBCC = BC001116_n205WWPMailBCC[0] ;
         A193WWPMailSenderAddress = BC001116_A193WWPMailSenderAddress[0] ;
         A194WWPMailSenderName = BC001116_A194WWPMailSenderName[0] ;
         A202WWPMailStatus = BC001116_A202WWPMailStatus[0] ;
         A211WWPMailCreated = BC001116_A211WWPMailCreated[0] ;
         A212WWPMailScheduled = BC001116_A212WWPMailScheduled[0] ;
         A207WWPMailProcessed = BC001116_A207WWPMailProcessed[0] ;
         n207WWPMailProcessed = BC001116_n207WWPMailProcessed[0] ;
         A208WWPMailDetail = BC001116_A208WWPMailDetail[0] ;
         n208WWPMailDetail = BC001116_n208WWPMailDetail[0] ;
         A40WWPNotificationCreated = BC001116_A40WWPNotificationCreated[0] ;
         A37WWPNotificationId = BC001116_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC001116_n37WWPNotificationId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1139( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound39 = (short)(0) ;
      scanKeyLoad1139( ) ;
   }

   public void scanKeyLoad1139( )
   {
      sMode39 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A42WWPMailId = BC001116_A42WWPMailId[0] ;
         A191WWPMailSubject = BC001116_A191WWPMailSubject[0] ;
         A183WWPMailBody = BC001116_A183WWPMailBody[0] ;
         A192WWPMailTo = BC001116_A192WWPMailTo[0] ;
         n192WWPMailTo = BC001116_n192WWPMailTo[0] ;
         A204WWPMailCC = BC001116_A204WWPMailCC[0] ;
         n204WWPMailCC = BC001116_n204WWPMailCC[0] ;
         A205WWPMailBCC = BC001116_A205WWPMailBCC[0] ;
         n205WWPMailBCC = BC001116_n205WWPMailBCC[0] ;
         A193WWPMailSenderAddress = BC001116_A193WWPMailSenderAddress[0] ;
         A194WWPMailSenderName = BC001116_A194WWPMailSenderName[0] ;
         A202WWPMailStatus = BC001116_A202WWPMailStatus[0] ;
         A211WWPMailCreated = BC001116_A211WWPMailCreated[0] ;
         A212WWPMailScheduled = BC001116_A212WWPMailScheduled[0] ;
         A207WWPMailProcessed = BC001116_A207WWPMailProcessed[0] ;
         n207WWPMailProcessed = BC001116_n207WWPMailProcessed[0] ;
         A208WWPMailDetail = BC001116_A208WWPMailDetail[0] ;
         n208WWPMailDetail = BC001116_n208WWPMailDetail[0] ;
         A40WWPNotificationCreated = BC001116_A40WWPNotificationCreated[0] ;
         A37WWPNotificationId = BC001116_A37WWPNotificationId[0] ;
         n37WWPNotificationId = BC001116_n37WWPNotificationId[0] ;
      }
      Gx_mode = sMode39 ;
   }

   public void scanKeyEnd1139( )
   {
      pr_default.close(14);
   }

   public void afterConfirm1139( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1139( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1139( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1139( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1139( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1139( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1139( )
   {
   }

   public void zm1140( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -10 )
      {
         Z42WWPMailId = A42WWPMailId ;
         Z43WWPMailAttachmentName = A43WWPMailAttachmentName ;
         Z206WWPMailAttachmentFile = A206WWPMailAttachmentFile ;
      }
   }

   public void standaloneNotModal1140( )
   {
   }

   public void standaloneModal1140( )
   {
   }

   public void load1140( )
   {
      /* Using cursor BC001117 */
      pr_default.execute(15, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A206WWPMailAttachmentFile = BC001117_A206WWPMailAttachmentFile[0] ;
         zm1140( -10) ;
      }
      pr_default.close(15);
      onLoadActions1140( ) ;
   }

   public void onLoadActions1140( )
   {
   }

   public void checkExtendedTable1140( )
   {
      nIsDirty_40 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1140( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors1140( )
   {
   }

   public void enableDisable1140( )
   {
   }

   public void getKey1140( )
   {
      /* Using cursor BC001118 */
      pr_default.execute(16, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound40 = (short)(1) ;
      }
      else
      {
         RcdFound40 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey1140( )
   {
      /* Using cursor BC001119 */
      pr_default.execute(17, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
      if ( (pr_default.getStatus(17) != 101) )
      {
         zm1140( 10) ;
         RcdFound40 = (short)(1) ;
         initializeNonKey1140( ) ;
         A43WWPMailAttachmentName = BC001119_A43WWPMailAttachmentName[0] ;
         A206WWPMailAttachmentFile = BC001119_A206WWPMailAttachmentFile[0] ;
         Z42WWPMailId = A42WWPMailId ;
         Z43WWPMailAttachmentName = A43WWPMailAttachmentName ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal1140( ) ;
         load1140( ) ;
         Gx_mode = sMode40 ;
      }
      else
      {
         RcdFound40 = (short)(0) ;
         initializeNonKey1140( ) ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal1140( ) ;
         Gx_mode = sMode40 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1140( ) ;
      }
      pr_default.close(17);
   }

   public void checkOptimisticConcurrency1140( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001120 */
         pr_default.execute(18, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
         if ( (pr_default.getStatus(18) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailAttachments"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(18) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_MailAttachments"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1140( )
   {
      beforeValidate1140( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1140( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1140( 0) ;
         checkOptimisticConcurrency1140( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1140( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1140( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001121 */
                  pr_default.execute(19, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName, A206WWPMailAttachmentFile});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailAttachments");
                  if ( (pr_default.getStatus(19) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
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
            load1140( ) ;
         }
         endLevel1140( ) ;
      }
      closeExtendedTableCursors1140( ) ;
   }

   public void update1140( )
   {
      beforeValidate1140( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1140( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1140( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1140( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1140( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001122 */
                  pr_default.execute(20, new Object[] {A206WWPMailAttachmentFile, Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailAttachments");
                  if ( (pr_default.getStatus(20) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailAttachments"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1140( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey1140( ) ;
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
         endLevel1140( ) ;
      }
      closeExtendedTableCursors1140( ) ;
   }

   public void deferredUpdate1140( )
   {
   }

   public void delete1140( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1140( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1140( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1140( ) ;
         afterConfirm1140( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1140( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001123 */
               pr_default.execute(21, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailAttachments");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode40 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1140( ) ;
      Gx_mode = sMode40 ;
   }

   public void onDeleteControls1140( )
   {
      standaloneModal1140( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1140( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(18);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart1140( )
   {
      /* Scan By routine */
      /* Using cursor BC001124 */
      pr_default.execute(22, new Object[] {Long.valueOf(A42WWPMailId)});
      RcdFound40 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A43WWPMailAttachmentName = BC001124_A43WWPMailAttachmentName[0] ;
         A206WWPMailAttachmentFile = BC001124_A206WWPMailAttachmentFile[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1140( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound40 = (short)(0) ;
      scanKeyLoad1140( ) ;
   }

   public void scanKeyLoad1140( )
   {
      sMode40 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A43WWPMailAttachmentName = BC001124_A43WWPMailAttachmentName[0] ;
         A206WWPMailAttachmentFile = BC001124_A206WWPMailAttachmentFile[0] ;
      }
      Gx_mode = sMode40 ;
   }

   public void scanKeyEnd1140( )
   {
      pr_default.close(22);
   }

   public void afterConfirm1140( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1140( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1140( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1140( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1140( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1140( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1140( )
   {
   }

   public void send_integrity_lvl_hashes1140( )
   {
   }

   public void send_integrity_lvl_hashes1139( )
   {
   }

   public void addRow1139( )
   {
      VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
   }

   public void readRow1139( )
   {
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
   }

   public void addRow1140( )
   {
      com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments obj40;
      obj40 = new com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments(remoteHandle);
      VarsToRow40( obj40) ;
      bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().add(obj40, 0);
      obj40.setgxTv_SdtWWP_Mail_Attachments_Mode( "UPD" );
      obj40.setgxTv_SdtWWP_Mail_Attachments_Modified( (short)(0) );
   }

   public void readRow1140( )
   {
      nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
      RowToVars40( ((com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments)bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().elementAt(-1+nGXsfl_40_idx)), 1) ;
   }

   public void initializeNonKey1139( )
   {
      A191WWPMailSubject = "" ;
      A183WWPMailBody = "" ;
      A192WWPMailTo = "" ;
      n192WWPMailTo = false ;
      A204WWPMailCC = "" ;
      n204WWPMailCC = false ;
      A205WWPMailBCC = "" ;
      n205WWPMailBCC = false ;
      A193WWPMailSenderAddress = "" ;
      A194WWPMailSenderName = "" ;
      A207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      n207WWPMailProcessed = false ;
      A208WWPMailDetail = "" ;
      n208WWPMailDetail = false ;
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A202WWPMailStatus = (short)(1) ;
      A211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z191WWPMailSubject = "" ;
      Z202WWPMailStatus = (short)(0) ;
      Z211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      Z212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z37WWPNotificationId = 0 ;
   }

   public void initAll1139( )
   {
      A42WWPMailId = 0 ;
      initializeNonKey1139( ) ;
   }

   public void standaloneModalInsert( )
   {
      A202WWPMailStatus = i202WWPMailStatus ;
      A211WWPMailCreated = i211WWPMailCreated ;
      A212WWPMailScheduled = i212WWPMailScheduled ;
   }

   public void initializeNonKey1140( )
   {
      A206WWPMailAttachmentFile = "" ;
   }

   public void initAll1140( )
   {
      A43WWPMailAttachmentName = "" ;
      initializeNonKey1140( ) ;
   }

   public void standaloneModalInsert1140( )
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

   public void VarsToRow39( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail obj39 )
   {
      obj39.setgxTv_SdtWWP_Mail_Mode( Gx_mode );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailsubject( A191WWPMailSubject );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailbody( A183WWPMailBody );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailto( A192WWPMailTo );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailcc( A204WWPMailCC );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailbcc( A205WWPMailBCC );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailsenderaddress( A193WWPMailSenderAddress );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailsendername( A194WWPMailSenderName );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailprocessed( A207WWPMailProcessed );
      obj39.setgxTv_SdtWWP_Mail_Wwpmaildetail( A208WWPMailDetail );
      obj39.setgxTv_SdtWWP_Mail_Wwpnotificationid( A37WWPNotificationId );
      obj39.setgxTv_SdtWWP_Mail_Wwpnotificationcreated( A40WWPNotificationCreated );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailstatus( A202WWPMailStatus );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailcreated( A211WWPMailCreated );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailscheduled( A212WWPMailScheduled );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailid( A42WWPMailId );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailid_Z( Z42WWPMailId );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailsubject_Z( Z191WWPMailSubject );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailstatus_Z( Z202WWPMailStatus );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailcreated_Z( Z211WWPMailCreated );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailscheduled_Z( Z212WWPMailScheduled );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailprocessed_Z( Z207WWPMailProcessed );
      obj39.setgxTv_SdtWWP_Mail_Wwpnotificationid_Z( Z37WWPNotificationId );
      obj39.setgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z( Z40WWPNotificationCreated );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailto_N( (byte)((byte)((n192WWPMailTo)?1:0)) );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailcc_N( (byte)((byte)((n204WWPMailCC)?1:0)) );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailbcc_N( (byte)((byte)((n205WWPMailBCC)?1:0)) );
      obj39.setgxTv_SdtWWP_Mail_Wwpmailprocessed_N( (byte)((byte)((n207WWPMailProcessed)?1:0)) );
      obj39.setgxTv_SdtWWP_Mail_Wwpmaildetail_N( (byte)((byte)((n208WWPMailDetail)?1:0)) );
      obj39.setgxTv_SdtWWP_Mail_Wwpnotificationid_N( (byte)((byte)((n37WWPNotificationId)?1:0)) );
      obj39.setgxTv_SdtWWP_Mail_Mode( Gx_mode );
   }

   public void KeyVarsToRow39( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail obj39 )
   {
      obj39.setgxTv_SdtWWP_Mail_Wwpmailid( A42WWPMailId );
   }

   public void RowToVars39( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail obj39 ,
                            int forceLoad )
   {
      Gx_mode = obj39.getgxTv_SdtWWP_Mail_Mode() ;
      A191WWPMailSubject = obj39.getgxTv_SdtWWP_Mail_Wwpmailsubject() ;
      A183WWPMailBody = obj39.getgxTv_SdtWWP_Mail_Wwpmailbody() ;
      A192WWPMailTo = obj39.getgxTv_SdtWWP_Mail_Wwpmailto() ;
      n192WWPMailTo = false ;
      A204WWPMailCC = obj39.getgxTv_SdtWWP_Mail_Wwpmailcc() ;
      n204WWPMailCC = false ;
      A205WWPMailBCC = obj39.getgxTv_SdtWWP_Mail_Wwpmailbcc() ;
      n205WWPMailBCC = false ;
      A193WWPMailSenderAddress = obj39.getgxTv_SdtWWP_Mail_Wwpmailsenderaddress() ;
      A194WWPMailSenderName = obj39.getgxTv_SdtWWP_Mail_Wwpmailsendername() ;
      A207WWPMailProcessed = obj39.getgxTv_SdtWWP_Mail_Wwpmailprocessed() ;
      n207WWPMailProcessed = false ;
      A208WWPMailDetail = obj39.getgxTv_SdtWWP_Mail_Wwpmaildetail() ;
      n208WWPMailDetail = false ;
      A37WWPNotificationId = obj39.getgxTv_SdtWWP_Mail_Wwpnotificationid() ;
      n37WWPNotificationId = false ;
      A40WWPNotificationCreated = obj39.getgxTv_SdtWWP_Mail_Wwpnotificationcreated() ;
      A202WWPMailStatus = obj39.getgxTv_SdtWWP_Mail_Wwpmailstatus() ;
      A211WWPMailCreated = obj39.getgxTv_SdtWWP_Mail_Wwpmailcreated() ;
      A212WWPMailScheduled = obj39.getgxTv_SdtWWP_Mail_Wwpmailscheduled() ;
      A42WWPMailId = obj39.getgxTv_SdtWWP_Mail_Wwpmailid() ;
      Z42WWPMailId = obj39.getgxTv_SdtWWP_Mail_Wwpmailid_Z() ;
      Z191WWPMailSubject = obj39.getgxTv_SdtWWP_Mail_Wwpmailsubject_Z() ;
      Z202WWPMailStatus = obj39.getgxTv_SdtWWP_Mail_Wwpmailstatus_Z() ;
      Z211WWPMailCreated = obj39.getgxTv_SdtWWP_Mail_Wwpmailcreated_Z() ;
      Z212WWPMailScheduled = obj39.getgxTv_SdtWWP_Mail_Wwpmailscheduled_Z() ;
      Z207WWPMailProcessed = obj39.getgxTv_SdtWWP_Mail_Wwpmailprocessed_Z() ;
      Z37WWPNotificationId = obj39.getgxTv_SdtWWP_Mail_Wwpnotificationid_Z() ;
      Z40WWPNotificationCreated = obj39.getgxTv_SdtWWP_Mail_Wwpnotificationcreated_Z() ;
      n192WWPMailTo = (boolean)((obj39.getgxTv_SdtWWP_Mail_Wwpmailto_N()==0)?false:true) ;
      n204WWPMailCC = (boolean)((obj39.getgxTv_SdtWWP_Mail_Wwpmailcc_N()==0)?false:true) ;
      n205WWPMailBCC = (boolean)((obj39.getgxTv_SdtWWP_Mail_Wwpmailbcc_N()==0)?false:true) ;
      n207WWPMailProcessed = (boolean)((obj39.getgxTv_SdtWWP_Mail_Wwpmailprocessed_N()==0)?false:true) ;
      n208WWPMailDetail = (boolean)((obj39.getgxTv_SdtWWP_Mail_Wwpmaildetail_N()==0)?false:true) ;
      n37WWPNotificationId = (boolean)((obj39.getgxTv_SdtWWP_Mail_Wwpnotificationid_N()==0)?false:true) ;
      Gx_mode = obj39.getgxTv_SdtWWP_Mail_Mode() ;
   }

   public void VarsToRow40( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments obj40 )
   {
      obj40.setgxTv_SdtWWP_Mail_Attachments_Mode( Gx_mode );
      obj40.setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile( A206WWPMailAttachmentFile );
      obj40.setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname( A43WWPMailAttachmentName );
      obj40.setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z( Z43WWPMailAttachmentName );
      obj40.setgxTv_SdtWWP_Mail_Attachments_Modified( nIsMod_40 );
   }

   public void KeyVarsToRow40( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments obj40 )
   {
      obj40.setgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname( A43WWPMailAttachmentName );
   }

   public void RowToVars40( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail_Attachments obj40 ,
                            int forceLoad )
   {
      Gx_mode = obj40.getgxTv_SdtWWP_Mail_Attachments_Mode() ;
      A206WWPMailAttachmentFile = obj40.getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentfile() ;
      A43WWPMailAttachmentName = obj40.getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname() ;
      Z43WWPMailAttachmentName = obj40.getgxTv_SdtWWP_Mail_Attachments_Wwpmailattachmentname_Z() ;
      nIsMod_40 = obj40.getgxTv_SdtWWP_Mail_Attachments_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A42WWPMailId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1139( ) ;
      scanKeyStart1139( ) ;
      if ( RcdFound39 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z42WWPMailId = A42WWPMailId ;
      }
      zm1139( -8) ;
      onLoadActions1139( ) ;
      addRow1139( ) ;
      bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().clearCollection();
      if ( RcdFound39 == 1 )
      {
         scanKeyStart1140( ) ;
         nGXsfl_40_idx = 1 ;
         while ( RcdFound40 != 0 )
         {
            Z42WWPMailId = A42WWPMailId ;
            Z43WWPMailAttachmentName = A43WWPMailAttachmentName ;
            zm1140( -10) ;
            onLoadActions1140( ) ;
            nRcdExists_40 = (short)(1) ;
            nIsMod_40 = (short)(0) ;
            addRow1140( ) ;
            nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
            scanKeyNext1140( ) ;
         }
         scanKeyEnd1140( ) ;
      }
      scanKeyEnd1139( ) ;
      if ( RcdFound39 == 0 )
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
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 0) ;
      scanKeyStart1139( ) ;
      if ( RcdFound39 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z42WWPMailId = A42WWPMailId ;
      }
      zm1139( -8) ;
      onLoadActions1139( ) ;
      addRow1139( ) ;
      bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Attachments().clearCollection();
      if ( RcdFound39 == 1 )
      {
         scanKeyStart1140( ) ;
         nGXsfl_40_idx = 1 ;
         while ( RcdFound40 != 0 )
         {
            Z42WWPMailId = A42WWPMailId ;
            Z43WWPMailAttachmentName = A43WWPMailAttachmentName ;
            zm1140( -10) ;
            onLoadActions1140( ) ;
            nRcdExists_40 = (short)(1) ;
            nIsMod_40 = (short)(0) ;
            addRow1140( ) ;
            nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
            scanKeyNext1140( ) ;
         }
         scanKeyEnd1140( ) ;
      }
      scanKeyEnd1139( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1139( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1139( ) ;
      }
      else
      {
         if ( RcdFound39 == 1 )
         {
            if ( A42WWPMailId != Z42WWPMailId )
            {
               A42WWPMailId = Z42WWPMailId ;
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
               update1139( ) ;
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
               if ( A42WWPMailId != Z42WWPMailId )
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
                     insert1139( ) ;
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
                     insert1139( ) ;
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
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
      saveImpl( ) ;
      VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1139( ) ;
      afterTrn( ) ;
      VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
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
         com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail auxBC = new com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A42WWPMailId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_mail_WWP_Mail);
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
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
      updateImpl( ) ;
      VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
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
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1139( ) ;
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
      VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1139( ) ;
      if ( RcdFound39 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A42WWPMailId != Z42WWPMailId )
         {
            A42WWPMailId = Z42WWPMailId ;
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
         if ( A42WWPMailId != Z42WWPMailId )
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
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      pr_default.close(0);
      pr_default.close(13);
      pr_default.close(4);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.mail.wwp_mail_bc");
      VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
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
      Gx_mode = bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_mail_WWP_Mail.setgxTv_SdtWWP_Mail_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_mail_WWP_Mail )
      {
         bcwwpbaseobjects_mail_WWP_Mail = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_mail_WWP_Mail.setgxTv_SdtWWP_Mail_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow39( bcwwpbaseobjects_mail_WWP_Mail) ;
         }
         else
         {
            RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_mail_WWP_Mail.getgxTv_SdtWWP_Mail_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_mail_WWP_Mail.setgxTv_SdtWWP_Mail_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars39( bcwwpbaseobjects_mail_WWP_Mail, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_Mail getWWP_Mail_BC( )
   {
      return bcwwpbaseobjects_mail_WWP_Mail ;
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
      sMode39 = "" ;
      Z191WWPMailSubject = "" ;
      A191WWPMailSubject = "" ;
      Z211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      A211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      Z212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      A212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      A207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z183WWPMailBody = "" ;
      A183WWPMailBody = "" ;
      Z192WWPMailTo = "" ;
      A192WWPMailTo = "" ;
      Z204WWPMailCC = "" ;
      A204WWPMailCC = "" ;
      Z205WWPMailBCC = "" ;
      A205WWPMailBCC = "" ;
      Z193WWPMailSenderAddress = "" ;
      A193WWPMailSenderAddress = "" ;
      Z194WWPMailSenderName = "" ;
      A194WWPMailSenderName = "" ;
      Z208WWPMailDetail = "" ;
      A208WWPMailDetail = "" ;
      BC00117_A42WWPMailId = new long[1] ;
      BC00117_A191WWPMailSubject = new String[] {""} ;
      BC00117_A183WWPMailBody = new String[] {""} ;
      BC00117_A192WWPMailTo = new String[] {""} ;
      BC00117_n192WWPMailTo = new boolean[] {false} ;
      BC00117_A204WWPMailCC = new String[] {""} ;
      BC00117_n204WWPMailCC = new boolean[] {false} ;
      BC00117_A205WWPMailBCC = new String[] {""} ;
      BC00117_n205WWPMailBCC = new boolean[] {false} ;
      BC00117_A193WWPMailSenderAddress = new String[] {""} ;
      BC00117_A194WWPMailSenderName = new String[] {""} ;
      BC00117_A202WWPMailStatus = new short[1] ;
      BC00117_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC00117_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC00117_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC00117_n207WWPMailProcessed = new boolean[] {false} ;
      BC00117_A208WWPMailDetail = new String[] {""} ;
      BC00117_n208WWPMailDetail = new boolean[] {false} ;
      BC00117_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC00117_A37WWPNotificationId = new long[1] ;
      BC00117_n37WWPNotificationId = new boolean[] {false} ;
      BC00118_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC00119_A42WWPMailId = new long[1] ;
      BC001110_A42WWPMailId = new long[1] ;
      BC001110_A191WWPMailSubject = new String[] {""} ;
      BC001110_A183WWPMailBody = new String[] {""} ;
      BC001110_A192WWPMailTo = new String[] {""} ;
      BC001110_n192WWPMailTo = new boolean[] {false} ;
      BC001110_A204WWPMailCC = new String[] {""} ;
      BC001110_n204WWPMailCC = new boolean[] {false} ;
      BC001110_A205WWPMailBCC = new String[] {""} ;
      BC001110_n205WWPMailBCC = new boolean[] {false} ;
      BC001110_A193WWPMailSenderAddress = new String[] {""} ;
      BC001110_A194WWPMailSenderName = new String[] {""} ;
      BC001110_A202WWPMailStatus = new short[1] ;
      BC001110_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC001110_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC001110_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC001110_n207WWPMailProcessed = new boolean[] {false} ;
      BC001110_A208WWPMailDetail = new String[] {""} ;
      BC001110_n208WWPMailDetail = new boolean[] {false} ;
      BC001110_A37WWPNotificationId = new long[1] ;
      BC001110_n37WWPNotificationId = new boolean[] {false} ;
      BC001111_A42WWPMailId = new long[1] ;
      BC001111_A191WWPMailSubject = new String[] {""} ;
      BC001111_A183WWPMailBody = new String[] {""} ;
      BC001111_A192WWPMailTo = new String[] {""} ;
      BC001111_n192WWPMailTo = new boolean[] {false} ;
      BC001111_A204WWPMailCC = new String[] {""} ;
      BC001111_n204WWPMailCC = new boolean[] {false} ;
      BC001111_A205WWPMailBCC = new String[] {""} ;
      BC001111_n205WWPMailBCC = new boolean[] {false} ;
      BC001111_A193WWPMailSenderAddress = new String[] {""} ;
      BC001111_A194WWPMailSenderName = new String[] {""} ;
      BC001111_A202WWPMailStatus = new short[1] ;
      BC001111_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC001111_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC001111_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC001111_n207WWPMailProcessed = new boolean[] {false} ;
      BC001111_A208WWPMailDetail = new String[] {""} ;
      BC001111_n208WWPMailDetail = new boolean[] {false} ;
      BC001111_A37WWPNotificationId = new long[1] ;
      BC001111_n37WWPNotificationId = new boolean[] {false} ;
      BC001112_A42WWPMailId = new long[1] ;
      BC001115_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC001116_A42WWPMailId = new long[1] ;
      BC001116_A191WWPMailSubject = new String[] {""} ;
      BC001116_A183WWPMailBody = new String[] {""} ;
      BC001116_A192WWPMailTo = new String[] {""} ;
      BC001116_n192WWPMailTo = new boolean[] {false} ;
      BC001116_A204WWPMailCC = new String[] {""} ;
      BC001116_n204WWPMailCC = new boolean[] {false} ;
      BC001116_A205WWPMailBCC = new String[] {""} ;
      BC001116_n205WWPMailBCC = new boolean[] {false} ;
      BC001116_A193WWPMailSenderAddress = new String[] {""} ;
      BC001116_A194WWPMailSenderName = new String[] {""} ;
      BC001116_A202WWPMailStatus = new short[1] ;
      BC001116_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC001116_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      BC001116_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      BC001116_n207WWPMailProcessed = new boolean[] {false} ;
      BC001116_A208WWPMailDetail = new String[] {""} ;
      BC001116_n208WWPMailDetail = new boolean[] {false} ;
      BC001116_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      BC001116_A37WWPNotificationId = new long[1] ;
      BC001116_n37WWPNotificationId = new boolean[] {false} ;
      Z43WWPMailAttachmentName = "" ;
      A43WWPMailAttachmentName = "" ;
      Z206WWPMailAttachmentFile = "" ;
      A206WWPMailAttachmentFile = "" ;
      BC001117_A42WWPMailId = new long[1] ;
      BC001117_A43WWPMailAttachmentName = new String[] {""} ;
      BC001117_A206WWPMailAttachmentFile = new String[] {""} ;
      BC001118_A42WWPMailId = new long[1] ;
      BC001118_A43WWPMailAttachmentName = new String[] {""} ;
      BC001119_A42WWPMailId = new long[1] ;
      BC001119_A43WWPMailAttachmentName = new String[] {""} ;
      BC001119_A206WWPMailAttachmentFile = new String[] {""} ;
      sMode40 = "" ;
      BC001120_A42WWPMailId = new long[1] ;
      BC001120_A43WWPMailAttachmentName = new String[] {""} ;
      BC001120_A206WWPMailAttachmentFile = new String[] {""} ;
      BC001124_A42WWPMailId = new long[1] ;
      BC001124_A43WWPMailAttachmentName = new String[] {""} ;
      BC001124_A206WWPMailAttachmentFile = new String[] {""} ;
      i211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      i212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mail_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mail_bc__default(),
         new Object[] {
             new Object[] {
            BC00112_A42WWPMailId, BC00112_A43WWPMailAttachmentName, BC00112_A206WWPMailAttachmentFile
            }
            , new Object[] {
            BC00113_A42WWPMailId, BC00113_A43WWPMailAttachmentName, BC00113_A206WWPMailAttachmentFile
            }
            , new Object[] {
            BC00114_A42WWPMailId, BC00114_A191WWPMailSubject, BC00114_A183WWPMailBody, BC00114_A192WWPMailTo, BC00114_n192WWPMailTo, BC00114_A204WWPMailCC, BC00114_n204WWPMailCC, BC00114_A205WWPMailBCC, BC00114_n205WWPMailBCC, BC00114_A193WWPMailSenderAddress,
            BC00114_A194WWPMailSenderName, BC00114_A202WWPMailStatus, BC00114_A211WWPMailCreated, BC00114_A212WWPMailScheduled, BC00114_A207WWPMailProcessed, BC00114_n207WWPMailProcessed, BC00114_A208WWPMailDetail, BC00114_n208WWPMailDetail, BC00114_A37WWPNotificationId, BC00114_n37WWPNotificationId
            }
            , new Object[] {
            BC00115_A42WWPMailId, BC00115_A191WWPMailSubject, BC00115_A183WWPMailBody, BC00115_A192WWPMailTo, BC00115_n192WWPMailTo, BC00115_A204WWPMailCC, BC00115_n204WWPMailCC, BC00115_A205WWPMailBCC, BC00115_n205WWPMailBCC, BC00115_A193WWPMailSenderAddress,
            BC00115_A194WWPMailSenderName, BC00115_A202WWPMailStatus, BC00115_A211WWPMailCreated, BC00115_A212WWPMailScheduled, BC00115_A207WWPMailProcessed, BC00115_n207WWPMailProcessed, BC00115_A208WWPMailDetail, BC00115_n208WWPMailDetail, BC00115_A37WWPNotificationId, BC00115_n37WWPNotificationId
            }
            , new Object[] {
            BC00116_A40WWPNotificationCreated
            }
            , new Object[] {
            BC00117_A42WWPMailId, BC00117_A191WWPMailSubject, BC00117_A183WWPMailBody, BC00117_A192WWPMailTo, BC00117_n192WWPMailTo, BC00117_A204WWPMailCC, BC00117_n204WWPMailCC, BC00117_A205WWPMailBCC, BC00117_n205WWPMailBCC, BC00117_A193WWPMailSenderAddress,
            BC00117_A194WWPMailSenderName, BC00117_A202WWPMailStatus, BC00117_A211WWPMailCreated, BC00117_A212WWPMailScheduled, BC00117_A207WWPMailProcessed, BC00117_n207WWPMailProcessed, BC00117_A208WWPMailDetail, BC00117_n208WWPMailDetail, BC00117_A40WWPNotificationCreated, BC00117_A37WWPNotificationId,
            BC00117_n37WWPNotificationId
            }
            , new Object[] {
            BC00118_A40WWPNotificationCreated
            }
            , new Object[] {
            BC00119_A42WWPMailId
            }
            , new Object[] {
            BC001110_A42WWPMailId, BC001110_A191WWPMailSubject, BC001110_A183WWPMailBody, BC001110_A192WWPMailTo, BC001110_n192WWPMailTo, BC001110_A204WWPMailCC, BC001110_n204WWPMailCC, BC001110_A205WWPMailBCC, BC001110_n205WWPMailBCC, BC001110_A193WWPMailSenderAddress,
            BC001110_A194WWPMailSenderName, BC001110_A202WWPMailStatus, BC001110_A211WWPMailCreated, BC001110_A212WWPMailScheduled, BC001110_A207WWPMailProcessed, BC001110_n207WWPMailProcessed, BC001110_A208WWPMailDetail, BC001110_n208WWPMailDetail, BC001110_A37WWPNotificationId, BC001110_n37WWPNotificationId
            }
            , new Object[] {
            BC001111_A42WWPMailId, BC001111_A191WWPMailSubject, BC001111_A183WWPMailBody, BC001111_A192WWPMailTo, BC001111_n192WWPMailTo, BC001111_A204WWPMailCC, BC001111_n204WWPMailCC, BC001111_A205WWPMailBCC, BC001111_n205WWPMailBCC, BC001111_A193WWPMailSenderAddress,
            BC001111_A194WWPMailSenderName, BC001111_A202WWPMailStatus, BC001111_A211WWPMailCreated, BC001111_A212WWPMailScheduled, BC001111_A207WWPMailProcessed, BC001111_n207WWPMailProcessed, BC001111_A208WWPMailDetail, BC001111_n208WWPMailDetail, BC001111_A37WWPNotificationId, BC001111_n37WWPNotificationId
            }
            , new Object[] {
            BC001112_A42WWPMailId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001115_A40WWPNotificationCreated
            }
            , new Object[] {
            BC001116_A42WWPMailId, BC001116_A191WWPMailSubject, BC001116_A183WWPMailBody, BC001116_A192WWPMailTo, BC001116_n192WWPMailTo, BC001116_A204WWPMailCC, BC001116_n204WWPMailCC, BC001116_A205WWPMailBCC, BC001116_n205WWPMailBCC, BC001116_A193WWPMailSenderAddress,
            BC001116_A194WWPMailSenderName, BC001116_A202WWPMailStatus, BC001116_A211WWPMailCreated, BC001116_A212WWPMailScheduled, BC001116_A207WWPMailProcessed, BC001116_n207WWPMailProcessed, BC001116_A208WWPMailDetail, BC001116_n208WWPMailDetail, BC001116_A40WWPNotificationCreated, BC001116_A37WWPNotificationId,
            BC001116_n37WWPNotificationId
            }
            , new Object[] {
            BC001117_A42WWPMailId, BC001117_A43WWPMailAttachmentName, BC001117_A206WWPMailAttachmentFile
            }
            , new Object[] {
            BC001118_A42WWPMailId, BC001118_A43WWPMailAttachmentName
            }
            , new Object[] {
            BC001119_A42WWPMailId, BC001119_A43WWPMailAttachmentName, BC001119_A206WWPMailAttachmentFile
            }
            , new Object[] {
            BC001120_A42WWPMailId, BC001120_A43WWPMailAttachmentName, BC001120_A206WWPMailAttachmentFile
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001124_A42WWPMailId, BC001124_A43WWPMailAttachmentName, BC001124_A206WWPMailAttachmentFile
            }
         }
      );
      Z212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z202WWPMailStatus = (short)(1) ;
      A202WWPMailStatus = (short)(1) ;
      i202WWPMailStatus = (short)(1) ;
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove40 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nIsMod_40 ;
   private short RcdFound40 ;
   private short Z202WWPMailStatus ;
   private short A202WWPMailStatus ;
   private short RcdFound39 ;
   private short nIsDirty_39 ;
   private short nRcdExists_40 ;
   private short nIsDirty_40 ;
   private short i202WWPMailStatus ;
   private int trnEnded ;
   private int nGXsfl_40_idx=1 ;
   private int GX_JID ;
   private long Z42WWPMailId ;
   private long A42WWPMailId ;
   private long Z37WWPNotificationId ;
   private long A37WWPNotificationId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode39 ;
   private String sMode40 ;
   private java.util.Date Z211WWPMailCreated ;
   private java.util.Date A211WWPMailCreated ;
   private java.util.Date Z212WWPMailScheduled ;
   private java.util.Date A212WWPMailScheduled ;
   private java.util.Date Z207WWPMailProcessed ;
   private java.util.Date A207WWPMailProcessed ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date i211WWPMailCreated ;
   private java.util.Date i212WWPMailScheduled ;
   private boolean n192WWPMailTo ;
   private boolean n204WWPMailCC ;
   private boolean n205WWPMailBCC ;
   private boolean n207WWPMailProcessed ;
   private boolean n208WWPMailDetail ;
   private boolean n37WWPNotificationId ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z183WWPMailBody ;
   private String A183WWPMailBody ;
   private String Z192WWPMailTo ;
   private String A192WWPMailTo ;
   private String Z204WWPMailCC ;
   private String A204WWPMailCC ;
   private String Z205WWPMailBCC ;
   private String A205WWPMailBCC ;
   private String Z193WWPMailSenderAddress ;
   private String A193WWPMailSenderAddress ;
   private String Z194WWPMailSenderName ;
   private String A194WWPMailSenderName ;
   private String Z208WWPMailDetail ;
   private String A208WWPMailDetail ;
   private String Z206WWPMailAttachmentFile ;
   private String A206WWPMailAttachmentFile ;
   private String Z191WWPMailSubject ;
   private String A191WWPMailSubject ;
   private String Z43WWPMailAttachmentName ;
   private String A43WWPMailAttachmentName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail bcwwpbaseobjects_mail_WWP_Mail ;
   private IDataStoreProvider pr_default ;
   private long[] BC00117_A42WWPMailId ;
   private String[] BC00117_A191WWPMailSubject ;
   private String[] BC00117_A183WWPMailBody ;
   private String[] BC00117_A192WWPMailTo ;
   private boolean[] BC00117_n192WWPMailTo ;
   private String[] BC00117_A204WWPMailCC ;
   private boolean[] BC00117_n204WWPMailCC ;
   private String[] BC00117_A205WWPMailBCC ;
   private boolean[] BC00117_n205WWPMailBCC ;
   private String[] BC00117_A193WWPMailSenderAddress ;
   private String[] BC00117_A194WWPMailSenderName ;
   private short[] BC00117_A202WWPMailStatus ;
   private java.util.Date[] BC00117_A211WWPMailCreated ;
   private java.util.Date[] BC00117_A212WWPMailScheduled ;
   private java.util.Date[] BC00117_A207WWPMailProcessed ;
   private boolean[] BC00117_n207WWPMailProcessed ;
   private String[] BC00117_A208WWPMailDetail ;
   private boolean[] BC00117_n208WWPMailDetail ;
   private java.util.Date[] BC00117_A40WWPNotificationCreated ;
   private long[] BC00117_A37WWPNotificationId ;
   private boolean[] BC00117_n37WWPNotificationId ;
   private java.util.Date[] BC00118_A40WWPNotificationCreated ;
   private long[] BC00119_A42WWPMailId ;
   private long[] BC001110_A42WWPMailId ;
   private String[] BC001110_A191WWPMailSubject ;
   private String[] BC001110_A183WWPMailBody ;
   private String[] BC001110_A192WWPMailTo ;
   private boolean[] BC001110_n192WWPMailTo ;
   private String[] BC001110_A204WWPMailCC ;
   private boolean[] BC001110_n204WWPMailCC ;
   private String[] BC001110_A205WWPMailBCC ;
   private boolean[] BC001110_n205WWPMailBCC ;
   private String[] BC001110_A193WWPMailSenderAddress ;
   private String[] BC001110_A194WWPMailSenderName ;
   private short[] BC001110_A202WWPMailStatus ;
   private java.util.Date[] BC001110_A211WWPMailCreated ;
   private java.util.Date[] BC001110_A212WWPMailScheduled ;
   private java.util.Date[] BC001110_A207WWPMailProcessed ;
   private boolean[] BC001110_n207WWPMailProcessed ;
   private String[] BC001110_A208WWPMailDetail ;
   private boolean[] BC001110_n208WWPMailDetail ;
   private long[] BC001110_A37WWPNotificationId ;
   private boolean[] BC001110_n37WWPNotificationId ;
   private long[] BC001111_A42WWPMailId ;
   private String[] BC001111_A191WWPMailSubject ;
   private String[] BC001111_A183WWPMailBody ;
   private String[] BC001111_A192WWPMailTo ;
   private boolean[] BC001111_n192WWPMailTo ;
   private String[] BC001111_A204WWPMailCC ;
   private boolean[] BC001111_n204WWPMailCC ;
   private String[] BC001111_A205WWPMailBCC ;
   private boolean[] BC001111_n205WWPMailBCC ;
   private String[] BC001111_A193WWPMailSenderAddress ;
   private String[] BC001111_A194WWPMailSenderName ;
   private short[] BC001111_A202WWPMailStatus ;
   private java.util.Date[] BC001111_A211WWPMailCreated ;
   private java.util.Date[] BC001111_A212WWPMailScheduled ;
   private java.util.Date[] BC001111_A207WWPMailProcessed ;
   private boolean[] BC001111_n207WWPMailProcessed ;
   private String[] BC001111_A208WWPMailDetail ;
   private boolean[] BC001111_n208WWPMailDetail ;
   private long[] BC001111_A37WWPNotificationId ;
   private boolean[] BC001111_n37WWPNotificationId ;
   private long[] BC001112_A42WWPMailId ;
   private java.util.Date[] BC001115_A40WWPNotificationCreated ;
   private long[] BC001116_A42WWPMailId ;
   private String[] BC001116_A191WWPMailSubject ;
   private String[] BC001116_A183WWPMailBody ;
   private String[] BC001116_A192WWPMailTo ;
   private boolean[] BC001116_n192WWPMailTo ;
   private String[] BC001116_A204WWPMailCC ;
   private boolean[] BC001116_n204WWPMailCC ;
   private String[] BC001116_A205WWPMailBCC ;
   private boolean[] BC001116_n205WWPMailBCC ;
   private String[] BC001116_A193WWPMailSenderAddress ;
   private String[] BC001116_A194WWPMailSenderName ;
   private short[] BC001116_A202WWPMailStatus ;
   private java.util.Date[] BC001116_A211WWPMailCreated ;
   private java.util.Date[] BC001116_A212WWPMailScheduled ;
   private java.util.Date[] BC001116_A207WWPMailProcessed ;
   private boolean[] BC001116_n207WWPMailProcessed ;
   private String[] BC001116_A208WWPMailDetail ;
   private boolean[] BC001116_n208WWPMailDetail ;
   private java.util.Date[] BC001116_A40WWPNotificationCreated ;
   private long[] BC001116_A37WWPNotificationId ;
   private boolean[] BC001116_n37WWPNotificationId ;
   private long[] BC001117_A42WWPMailId ;
   private String[] BC001117_A43WWPMailAttachmentName ;
   private String[] BC001117_A206WWPMailAttachmentFile ;
   private long[] BC001118_A42WWPMailId ;
   private String[] BC001118_A43WWPMailAttachmentName ;
   private long[] BC001119_A42WWPMailId ;
   private String[] BC001119_A43WWPMailAttachmentName ;
   private String[] BC001119_A206WWPMailAttachmentFile ;
   private long[] BC001120_A42WWPMailId ;
   private String[] BC001120_A43WWPMailAttachmentName ;
   private String[] BC001120_A206WWPMailAttachmentFile ;
   private long[] BC001124_A42WWPMailId ;
   private String[] BC001124_A43WWPMailAttachmentName ;
   private String[] BC001124_A206WWPMailAttachmentFile ;
   private IDataStoreProvider pr_gam ;
   private long[] BC00112_A42WWPMailId ;
   private String[] BC00112_A43WWPMailAttachmentName ;
   private String[] BC00112_A206WWPMailAttachmentFile ;
   private long[] BC00113_A42WWPMailId ;
   private String[] BC00113_A43WWPMailAttachmentName ;
   private String[] BC00113_A206WWPMailAttachmentFile ;
   private long[] BC00114_A42WWPMailId ;
   private String[] BC00114_A191WWPMailSubject ;
   private String[] BC00114_A183WWPMailBody ;
   private String[] BC00114_A192WWPMailTo ;
   private String[] BC00114_A204WWPMailCC ;
   private String[] BC00114_A205WWPMailBCC ;
   private String[] BC00114_A193WWPMailSenderAddress ;
   private String[] BC00114_A194WWPMailSenderName ;
   private short[] BC00114_A202WWPMailStatus ;
   private java.util.Date[] BC00114_A211WWPMailCreated ;
   private java.util.Date[] BC00114_A212WWPMailScheduled ;
   private java.util.Date[] BC00114_A207WWPMailProcessed ;
   private String[] BC00114_A208WWPMailDetail ;
   private long[] BC00114_A37WWPNotificationId ;
   private long[] BC00115_A42WWPMailId ;
   private String[] BC00115_A191WWPMailSubject ;
   private String[] BC00115_A183WWPMailBody ;
   private String[] BC00115_A192WWPMailTo ;
   private String[] BC00115_A204WWPMailCC ;
   private String[] BC00115_A205WWPMailBCC ;
   private String[] BC00115_A193WWPMailSenderAddress ;
   private String[] BC00115_A194WWPMailSenderName ;
   private short[] BC00115_A202WWPMailStatus ;
   private java.util.Date[] BC00115_A211WWPMailCreated ;
   private java.util.Date[] BC00115_A212WWPMailScheduled ;
   private java.util.Date[] BC00115_A207WWPMailProcessed ;
   private String[] BC00115_A208WWPMailDetail ;
   private long[] BC00115_A37WWPNotificationId ;
   private java.util.Date[] BC00116_A40WWPNotificationCreated ;
   private boolean[] BC00114_n192WWPMailTo ;
   private boolean[] BC00114_n204WWPMailCC ;
   private boolean[] BC00114_n205WWPMailBCC ;
   private boolean[] BC00114_n207WWPMailProcessed ;
   private boolean[] BC00114_n208WWPMailDetail ;
   private boolean[] BC00114_n37WWPNotificationId ;
   private boolean[] BC00115_n192WWPMailTo ;
   private boolean[] BC00115_n204WWPMailCC ;
   private boolean[] BC00115_n205WWPMailBCC ;
   private boolean[] BC00115_n207WWPMailProcessed ;
   private boolean[] BC00115_n208WWPMailDetail ;
   private boolean[] BC00115_n37WWPNotificationId ;
}

final  class wwp_mail_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_mail_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00112", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WITH (UPDLOCK) WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00113", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00114", "SELECT [WWPMailId], [WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId] FROM [WWP_Mail] WITH (UPDLOCK) WHERE [WWPMailId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00115", "SELECT [WWPMailId], [WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId] FROM [WWP_Mail] WHERE [WWPMailId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00116", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00117", "SELECT TM1.[WWPMailId], TM1.[WWPMailSubject], TM1.[WWPMailBody], TM1.[WWPMailTo], TM1.[WWPMailCC], TM1.[WWPMailBCC], TM1.[WWPMailSenderAddress], TM1.[WWPMailSenderName], TM1.[WWPMailStatus], TM1.[WWPMailCreated], TM1.[WWPMailScheduled], TM1.[WWPMailProcessed], TM1.[WWPMailDetail], T2.[WWPNotificationCreated], TM1.[WWPNotificationId] FROM ([WWP_Mail] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) WHERE TM1.[WWPMailId] = ? ORDER BY TM1.[WWPMailId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00118", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00119", "SELECT [WWPMailId] FROM [WWP_Mail] WHERE [WWPMailId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001110", "SELECT [WWPMailId], [WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId] FROM [WWP_Mail] WHERE [WWPMailId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001111", "SELECT [WWPMailId], [WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId] FROM [WWP_Mail] WITH (UPDLOCK) WHERE [WWPMailId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001112", "INSERT INTO [WWP_Mail]([WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC001113", "UPDATE [WWP_Mail] SET [WWPMailSubject]=?, [WWPMailBody]=?, [WWPMailTo]=?, [WWPMailCC]=?, [WWPMailBCC]=?, [WWPMailSenderAddress]=?, [WWPMailSenderName]=?, [WWPMailStatus]=?, [WWPMailCreated]=?, [WWPMailScheduled]=?, [WWPMailProcessed]=?, [WWPMailDetail]=?, [WWPNotificationId]=?  WHERE [WWPMailId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001114", "DELETE FROM [WWP_Mail]  WHERE [WWPMailId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001115", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001116", "SELECT TM1.[WWPMailId], TM1.[WWPMailSubject], TM1.[WWPMailBody], TM1.[WWPMailTo], TM1.[WWPMailCC], TM1.[WWPMailBCC], TM1.[WWPMailSenderAddress], TM1.[WWPMailSenderName], TM1.[WWPMailStatus], TM1.[WWPMailCreated], TM1.[WWPMailScheduled], TM1.[WWPMailProcessed], TM1.[WWPMailDetail], T2.[WWPNotificationCreated], TM1.[WWPNotificationId] FROM ([WWP_Mail] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) WHERE TM1.[WWPMailId] = ? ORDER BY TM1.[WWPMailId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001117", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? and [WWPMailAttachmentName] = ? ORDER BY [WWPMailId], [WWPMailAttachmentName]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001118", "SELECT [WWPMailId], [WWPMailAttachmentName] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001119", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001120", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WITH (UPDLOCK) WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001121", "INSERT INTO [WWP_MailAttachments]([WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC001122", "UPDATE [WWP_MailAttachments] SET [WWPMailAttachmentFile]=?  WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001123", "DELETE FROM [WWP_MailAttachments]  WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001124", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? ORDER BY [WWPMailId], [WWPMailAttachmentName]  OPTION (FAST 11)",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(10, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(12, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((long[]) buf[18])[0] = rslt.getLong(14);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(10, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(12, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((long[]) buf[18])[0] = rslt.getLong(14);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(10, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(12, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[18])[0] = rslt.getGXDateTime(14, true);
               ((long[]) buf[19])[0] = rslt.getLong(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 6 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(10, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(12, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((long[]) buf[18])[0] = rslt.getLong(14);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(10, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(12, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((long[]) buf[18])[0] = rslt.getLong(14);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(10, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(12, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[18])[0] = rslt.getGXDateTime(14, true);
               ((long[]) buf[19])[0] = rslt.getLong(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 17 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 18 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
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
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[7]);
               }
               stmt.setNLongVarchar(6, (String)parms[8], false);
               stmt.setNLongVarchar(7, (String)parms[9], false);
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setDateTime(9, (java.util.Date)parms[11], false, true);
               stmt.setDateTime(10, (java.util.Date)parms[12], false, true);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(11, (java.util.Date)parms[14], false, true);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(12, (String)parms[16]);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(13, ((Number) parms[18]).longValue());
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[5]);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[7]);
               }
               stmt.setNLongVarchar(6, (String)parms[8], false);
               stmt.setNLongVarchar(7, (String)parms[9], false);
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setDateTime(9, (java.util.Date)parms[11], false, true);
               stmt.setDateTime(10, (java.util.Date)parms[12], false, true);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(11, (java.util.Date)parms[14], false, true);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(12, (String)parms[16]);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(13, ((Number) parms[18]).longValue());
               }
               stmt.setLong(14, ((Number) parms[19]).longValue());
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
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               return;
            case 20 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 21 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 22 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

