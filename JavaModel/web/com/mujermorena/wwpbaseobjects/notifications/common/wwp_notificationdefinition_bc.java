package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_notificationdefinition_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_notificationdefinition_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_notificationdefinition_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_notificationdefinition_bc.class ));
   }

   public wwp_notificationdefinition_bc( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0Y36( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0Y36( ) ;
      standaloneModal( ) ;
      addRow0Y36( ) ;
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
            Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
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

   public void confirm_0Y0( )
   {
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Y36( ) ;
         }
         else
         {
            checkExtendedTable0Y36( ) ;
            if ( AnyError == 0 )
            {
               zm0Y36( 5) ;
            }
            closeExtendedTableCursors0Y36( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0Y36( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
         Z155WWPNotificationDefinitionAppli = A155WWPNotificationDefinitionAppli ;
         Z156WWPNotificationDefinitionAllow = A156WWPNotificationDefinitionAllow ;
         Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
         Z184WWPNotificationDefinitionIcon = A184WWPNotificationDefinitionIcon ;
         Z185WWPNotificationDefinitionTitle = A185WWPNotificationDefinitionTitle ;
         Z186WWPNotificationDefinitionShort = A186WWPNotificationDefinitionShort ;
         Z187WWPNotificationDefinitionLongD = A187WWPNotificationDefinitionLongD ;
         Z188WWPNotificationDefinitionLink = A188WWPNotificationDefinitionLink ;
         Z189WWPNotificationDefinitionSecFu = A189WWPNotificationDefinitionSecFu ;
         Z33WWPEntityId = A33WWPEntityId ;
         Z190WWPNotificationDefinitionIsAut = A190WWPNotificationDefinitionIsAut ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z150WWPEntityName = A150WWPEntityName ;
         Z190WWPNotificationDefinitionIsAut = A190WWPNotificationDefinitionIsAut ;
      }
      if ( GX_JID == -4 )
      {
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
         Z155WWPNotificationDefinitionAppli = A155WWPNotificationDefinitionAppli ;
         Z156WWPNotificationDefinitionAllow = A156WWPNotificationDefinitionAllow ;
         Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
         Z184WWPNotificationDefinitionIcon = A184WWPNotificationDefinitionIcon ;
         Z185WWPNotificationDefinitionTitle = A185WWPNotificationDefinitionTitle ;
         Z186WWPNotificationDefinitionShort = A186WWPNotificationDefinitionShort ;
         Z187WWPNotificationDefinitionLongD = A187WWPNotificationDefinitionLongD ;
         Z188WWPNotificationDefinitionLink = A188WWPNotificationDefinitionLink ;
         Z189WWPNotificationDefinitionSecFu = A189WWPNotificationDefinitionSecFu ;
         Z33WWPEntityId = A33WWPEntityId ;
         Z150WWPEntityName = A150WWPEntityName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0Y36( )
   {
      /* Using cursor BC000Y5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A181WWPNotificationDefinitionName = BC000Y5_A181WWPNotificationDefinitionName[0] ;
         A155WWPNotificationDefinitionAppli = BC000Y5_A155WWPNotificationDefinitionAppli[0] ;
         A156WWPNotificationDefinitionAllow = BC000Y5_A156WWPNotificationDefinitionAllow[0] ;
         A154WWPNotificationDefinitionDescr = BC000Y5_A154WWPNotificationDefinitionDescr[0] ;
         A184WWPNotificationDefinitionIcon = BC000Y5_A184WWPNotificationDefinitionIcon[0] ;
         A185WWPNotificationDefinitionTitle = BC000Y5_A185WWPNotificationDefinitionTitle[0] ;
         A186WWPNotificationDefinitionShort = BC000Y5_A186WWPNotificationDefinitionShort[0] ;
         A187WWPNotificationDefinitionLongD = BC000Y5_A187WWPNotificationDefinitionLongD[0] ;
         A188WWPNotificationDefinitionLink = BC000Y5_A188WWPNotificationDefinitionLink[0] ;
         A150WWPEntityName = BC000Y5_A150WWPEntityName[0] ;
         A189WWPNotificationDefinitionSecFu = BC000Y5_A189WWPNotificationDefinitionSecFu[0] ;
         A33WWPEntityId = BC000Y5_A33WWPEntityId[0] ;
         zm0Y36( -4) ;
      }
      pr_default.close(3);
      onLoadActions0Y36( ) ;
   }

   public void onLoadActions0Y36( )
   {
      if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
      {
         A190WWPNotificationDefinitionIsAut = true ;
      }
      else
      {
         GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
         wwp_notificationdefinition_bc.this.GXt_boolean1 = GXv_boolean2[0] ;
         A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
      }
   }

   public void checkExtendedTable0Y36( )
   {
      nIsDirty_36 = (short)(0) ;
      standaloneModal( ) ;
      if ( ! ( ( A155WWPNotificationDefinitionAppli == 1 ) || ( A155WWPNotificationDefinitionAppli == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Notification Definition Applies To", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GxRegex.IsMatch(A188WWPNotificationDefinitionLink,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Notification Definition Default Link", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000Y6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
      }
      A150WWPEntityName = BC000Y6_A150WWPEntityName[0] ;
      pr_default.close(4);
      if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
      {
         nIsDirty_36 = (short)(1) ;
         A190WWPNotificationDefinitionIsAut = true ;
      }
      else
      {
         nIsDirty_36 = (short)(1) ;
         GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
         wwp_notificationdefinition_bc.this.GXt_boolean1 = GXv_boolean2[0] ;
         A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
      }
   }

   public void closeExtendedTableCursors0Y36( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0Y36( )
   {
      /* Using cursor BC000Y7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound36 = (short)(1) ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000Y8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0Y36( 4) ;
         RcdFound36 = (short)(1) ;
         A35WWPNotificationDefinitionId = BC000Y8_A35WWPNotificationDefinitionId[0] ;
         A181WWPNotificationDefinitionName = BC000Y8_A181WWPNotificationDefinitionName[0] ;
         A155WWPNotificationDefinitionAppli = BC000Y8_A155WWPNotificationDefinitionAppli[0] ;
         A156WWPNotificationDefinitionAllow = BC000Y8_A156WWPNotificationDefinitionAllow[0] ;
         A154WWPNotificationDefinitionDescr = BC000Y8_A154WWPNotificationDefinitionDescr[0] ;
         A184WWPNotificationDefinitionIcon = BC000Y8_A184WWPNotificationDefinitionIcon[0] ;
         A185WWPNotificationDefinitionTitle = BC000Y8_A185WWPNotificationDefinitionTitle[0] ;
         A186WWPNotificationDefinitionShort = BC000Y8_A186WWPNotificationDefinitionShort[0] ;
         A187WWPNotificationDefinitionLongD = BC000Y8_A187WWPNotificationDefinitionLongD[0] ;
         A188WWPNotificationDefinitionLink = BC000Y8_A188WWPNotificationDefinitionLink[0] ;
         A189WWPNotificationDefinitionSecFu = BC000Y8_A189WWPNotificationDefinitionSecFu[0] ;
         A33WWPEntityId = BC000Y8_A33WWPEntityId[0] ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0Y36( ) ;
         if ( AnyError == 1 )
         {
            RcdFound36 = (short)(0) ;
            initializeNonKey0Y36( ) ;
         }
         Gx_mode = sMode36 ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
         initializeNonKey0Y36( ) ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode36 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0Y36( ) ;
      if ( RcdFound36 == 0 )
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
      confirm_0Y0( ) ;
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

   public void checkOptimisticConcurrency0Y36( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000Y9 */
         pr_default.execute(7, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_NotificationDefinition"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z181WWPNotificationDefinitionName, BC000Y9_A181WWPNotificationDefinitionName[0]) != 0 ) || ( Z155WWPNotificationDefinitionAppli != BC000Y9_A155WWPNotificationDefinitionAppli[0] ) || ( Z156WWPNotificationDefinitionAllow != BC000Y9_A156WWPNotificationDefinitionAllow[0] ) || ( GXutil.strcmp(Z154WWPNotificationDefinitionDescr, BC000Y9_A154WWPNotificationDefinitionDescr[0]) != 0 ) || ( GXutil.strcmp(Z184WWPNotificationDefinitionIcon, BC000Y9_A184WWPNotificationDefinitionIcon[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z185WWPNotificationDefinitionTitle, BC000Y9_A185WWPNotificationDefinitionTitle[0]) != 0 ) || ( GXutil.strcmp(Z186WWPNotificationDefinitionShort, BC000Y9_A186WWPNotificationDefinitionShort[0]) != 0 ) || ( GXutil.strcmp(Z187WWPNotificationDefinitionLongD, BC000Y9_A187WWPNotificationDefinitionLongD[0]) != 0 ) || ( GXutil.strcmp(Z188WWPNotificationDefinitionLink, BC000Y9_A188WWPNotificationDefinitionLink[0]) != 0 ) || ( GXutil.strcmp(Z189WWPNotificationDefinitionSecFu, BC000Y9_A189WWPNotificationDefinitionSecFu[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z33WWPEntityId != BC000Y9_A33WWPEntityId[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_NotificationDefinition"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Y36( )
   {
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Y36( 0) ;
         checkOptimisticConcurrency0Y36( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y36( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Y36( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Y10 */
                  pr_default.execute(8, new Object[] {A181WWPNotificationDefinitionName, Byte.valueOf(A155WWPNotificationDefinitionAppli), Boolean.valueOf(A156WWPNotificationDefinitionAllow), A154WWPNotificationDefinitionDescr, A184WWPNotificationDefinitionIcon, A185WWPNotificationDefinitionTitle, A186WWPNotificationDefinitionShort, A187WWPNotificationDefinitionLongD, A188WWPNotificationDefinitionLink, A189WWPNotificationDefinitionSecFu, Long.valueOf(A33WWPEntityId)});
                  A35WWPNotificationDefinitionId = BC000Y10_A35WWPNotificationDefinitionId[0] ;
                  pr_default.close(8);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_NotificationDefinition");
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
            load0Y36( ) ;
         }
         endLevel0Y36( ) ;
      }
      closeExtendedTableCursors0Y36( ) ;
   }

   public void update0Y36( )
   {
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y36( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y36( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Y36( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000Y11 */
                  pr_default.execute(9, new Object[] {A181WWPNotificationDefinitionName, Byte.valueOf(A155WWPNotificationDefinitionAppli), Boolean.valueOf(A156WWPNotificationDefinitionAllow), A154WWPNotificationDefinitionDescr, A184WWPNotificationDefinitionIcon, A185WWPNotificationDefinitionTitle, A186WWPNotificationDefinitionShort, A187WWPNotificationDefinitionLongD, A188WWPNotificationDefinitionLink, A189WWPNotificationDefinitionSecFu, Long.valueOf(A33WWPEntityId), Long.valueOf(A35WWPNotificationDefinitionId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_NotificationDefinition");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_NotificationDefinition"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Y36( ) ;
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
         endLevel0Y36( ) ;
      }
      closeExtendedTableCursors0Y36( ) ;
   }

   public void deferredUpdate0Y36( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Y36( ) ;
         afterConfirm0Y36( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Y36( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000Y12 */
               pr_default.execute(10, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_NotificationDefinition");
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
      sMode36 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0Y36( ) ;
      Gx_mode = sMode36 ;
   }

   public void onDeleteControls0Y36( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000Y13 */
         pr_default.execute(11, new Object[] {Long.valueOf(A33WWPEntityId)});
         A150WWPEntityName = BC000Y13_A150WWPEntityName[0] ;
         pr_default.close(11);
         if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
         {
            A190WWPNotificationDefinitionIsAut = true ;
         }
         else
         {
            GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
            wwp_notificationdefinition_bc.this.GXt_boolean1 = GXv_boolean2[0] ;
            A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000Y14 */
         pr_default.execute(12, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Notification", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor BC000Y15 */
         pr_default.execute(13, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Subscription", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel0Y36( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Y36( ) ;
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

   public void scanKeyStart0Y36( )
   {
      /* Using cursor BC000Y16 */
      pr_default.execute(14, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A35WWPNotificationDefinitionId = BC000Y16_A35WWPNotificationDefinitionId[0] ;
         A181WWPNotificationDefinitionName = BC000Y16_A181WWPNotificationDefinitionName[0] ;
         A155WWPNotificationDefinitionAppli = BC000Y16_A155WWPNotificationDefinitionAppli[0] ;
         A156WWPNotificationDefinitionAllow = BC000Y16_A156WWPNotificationDefinitionAllow[0] ;
         A154WWPNotificationDefinitionDescr = BC000Y16_A154WWPNotificationDefinitionDescr[0] ;
         A184WWPNotificationDefinitionIcon = BC000Y16_A184WWPNotificationDefinitionIcon[0] ;
         A185WWPNotificationDefinitionTitle = BC000Y16_A185WWPNotificationDefinitionTitle[0] ;
         A186WWPNotificationDefinitionShort = BC000Y16_A186WWPNotificationDefinitionShort[0] ;
         A187WWPNotificationDefinitionLongD = BC000Y16_A187WWPNotificationDefinitionLongD[0] ;
         A188WWPNotificationDefinitionLink = BC000Y16_A188WWPNotificationDefinitionLink[0] ;
         A150WWPEntityName = BC000Y16_A150WWPEntityName[0] ;
         A189WWPNotificationDefinitionSecFu = BC000Y16_A189WWPNotificationDefinitionSecFu[0] ;
         A33WWPEntityId = BC000Y16_A33WWPEntityId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0Y36( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound36 = (short)(0) ;
      scanKeyLoad0Y36( ) ;
   }

   public void scanKeyLoad0Y36( )
   {
      sMode36 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A35WWPNotificationDefinitionId = BC000Y16_A35WWPNotificationDefinitionId[0] ;
         A181WWPNotificationDefinitionName = BC000Y16_A181WWPNotificationDefinitionName[0] ;
         A155WWPNotificationDefinitionAppli = BC000Y16_A155WWPNotificationDefinitionAppli[0] ;
         A156WWPNotificationDefinitionAllow = BC000Y16_A156WWPNotificationDefinitionAllow[0] ;
         A154WWPNotificationDefinitionDescr = BC000Y16_A154WWPNotificationDefinitionDescr[0] ;
         A184WWPNotificationDefinitionIcon = BC000Y16_A184WWPNotificationDefinitionIcon[0] ;
         A185WWPNotificationDefinitionTitle = BC000Y16_A185WWPNotificationDefinitionTitle[0] ;
         A186WWPNotificationDefinitionShort = BC000Y16_A186WWPNotificationDefinitionShort[0] ;
         A187WWPNotificationDefinitionLongD = BC000Y16_A187WWPNotificationDefinitionLongD[0] ;
         A188WWPNotificationDefinitionLink = BC000Y16_A188WWPNotificationDefinitionLink[0] ;
         A150WWPEntityName = BC000Y16_A150WWPEntityName[0] ;
         A189WWPNotificationDefinitionSecFu = BC000Y16_A189WWPNotificationDefinitionSecFu[0] ;
         A33WWPEntityId = BC000Y16_A33WWPEntityId[0] ;
      }
      Gx_mode = sMode36 ;
   }

   public void scanKeyEnd0Y36( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0Y36( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Y36( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Y36( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Y36( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Y36( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Y36( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Y36( )
   {
   }

   public void send_integrity_lvl_hashes0Y36( )
   {
   }

   public void addRow0Y36( )
   {
      VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
   }

   public void readRow0Y36( )
   {
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
   }

   public void initializeNonKey0Y36( )
   {
      A190WWPNotificationDefinitionIsAut = false ;
      A181WWPNotificationDefinitionName = "" ;
      A155WWPNotificationDefinitionAppli = (byte)(0) ;
      A156WWPNotificationDefinitionAllow = false ;
      A154WWPNotificationDefinitionDescr = "" ;
      A184WWPNotificationDefinitionIcon = "" ;
      A185WWPNotificationDefinitionTitle = "" ;
      A186WWPNotificationDefinitionShort = "" ;
      A187WWPNotificationDefinitionLongD = "" ;
      A188WWPNotificationDefinitionLink = "" ;
      A33WWPEntityId = 0 ;
      A150WWPEntityName = "" ;
      A189WWPNotificationDefinitionSecFu = "" ;
      Z181WWPNotificationDefinitionName = "" ;
      Z155WWPNotificationDefinitionAppli = (byte)(0) ;
      Z156WWPNotificationDefinitionAllow = false ;
      Z154WWPNotificationDefinitionDescr = "" ;
      Z184WWPNotificationDefinitionIcon = "" ;
      Z185WWPNotificationDefinitionTitle = "" ;
      Z186WWPNotificationDefinitionShort = "" ;
      Z187WWPNotificationDefinitionLongD = "" ;
      Z188WWPNotificationDefinitionLink = "" ;
      Z189WWPNotificationDefinitionSecFu = "" ;
      Z33WWPEntityId = 0 ;
   }

   public void initAll0Y36( )
   {
      A35WWPNotificationDefinitionId = 0 ;
      initializeNonKey0Y36( ) ;
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

   public void VarsToRow36( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition obj36 )
   {
      obj36.setgxTv_SdtWWP_NotificationDefinition_Mode( Gx_mode );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized( A190WWPNotificationDefinitionIsAut );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname( A181WWPNotificationDefinitionName );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto( A155WWPNotificationDefinitionAppli );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription( A156WWPNotificationDefinitionAllow );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription( A154WWPNotificationDefinitionDescr );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon( A184WWPNotificationDefinitionIcon );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle( A185WWPNotificationDefinitionTitle );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription( A186WWPNotificationDefinitionShort );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription( A187WWPNotificationDefinitionLongD );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink( A188WWPNotificationDefinitionLink );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpentityid( A33WWPEntityId );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpentityname( A150WWPEntityName );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality( A189WWPNotificationDefinitionSecFu );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid( A35WWPNotificationDefinitionId );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z( Z35WWPNotificationDefinitionId );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z( Z181WWPNotificationDefinitionName );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z( Z155WWPNotificationDefinitionAppli );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z( Z156WWPNotificationDefinitionAllow );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z( Z154WWPNotificationDefinitionDescr );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z( Z184WWPNotificationDefinitionIcon );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z( Z185WWPNotificationDefinitionTitle );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z( Z186WWPNotificationDefinitionShort );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z( Z187WWPNotificationDefinitionLongD );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z( Z188WWPNotificationDefinitionLink );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z( Z33WWPEntityId );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z( Z150WWPEntityName );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z( Z189WWPNotificationDefinitionSecFu );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z( Z190WWPNotificationDefinitionIsAut );
      obj36.setgxTv_SdtWWP_NotificationDefinition_Mode( Gx_mode );
   }

   public void KeyVarsToRow36( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition obj36 )
   {
      obj36.setgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid( A35WWPNotificationDefinitionId );
   }

   public void RowToVars36( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition obj36 ,
                            int forceLoad )
   {
      Gx_mode = obj36.getgxTv_SdtWWP_NotificationDefinition_Mode() ;
      A190WWPNotificationDefinitionIsAut = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized() ;
      A181WWPNotificationDefinitionName = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname() ;
      A155WWPNotificationDefinitionAppli = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto() ;
      A156WWPNotificationDefinitionAllow = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription() ;
      A154WWPNotificationDefinitionDescr = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription() ;
      A184WWPNotificationDefinitionIcon = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon() ;
      A185WWPNotificationDefinitionTitle = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle() ;
      A186WWPNotificationDefinitionShort = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription() ;
      A187WWPNotificationDefinitionLongD = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription() ;
      A188WWPNotificationDefinitionLink = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink() ;
      A33WWPEntityId = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpentityid() ;
      A150WWPEntityName = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpentityname() ;
      A189WWPNotificationDefinitionSecFu = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality() ;
      A35WWPNotificationDefinitionId = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid() ;
      Z35WWPNotificationDefinitionId = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionid_Z() ;
      Z181WWPNotificationDefinitionName = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionname_Z() ;
      Z155WWPNotificationDefinitionAppli = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionappliesto_Z() ;
      Z156WWPNotificationDefinitionAllow = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionallowusersubscription_Z() ;
      Z154WWPNotificationDefinitionDescr = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiondescription_Z() ;
      Z184WWPNotificationDefinitionIcon = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionicon_Z() ;
      Z185WWPNotificationDefinitionTitle = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitiontitle_Z() ;
      Z186WWPNotificationDefinitionShort = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionshortdescription_Z() ;
      Z187WWPNotificationDefinitionLongD = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlongdescription_Z() ;
      Z188WWPNotificationDefinitionLink = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionlink_Z() ;
      Z33WWPEntityId = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpentityid_Z() ;
      Z150WWPEntityName = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpentityname_Z() ;
      Z189WWPNotificationDefinitionSecFu = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionsecfuncionality_Z() ;
      Z190WWPNotificationDefinitionIsAut = obj36.getgxTv_SdtWWP_NotificationDefinition_Wwpnotificationdefinitionisauthorized_Z() ;
      Gx_mode = obj36.getgxTv_SdtWWP_NotificationDefinition_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A35WWPNotificationDefinitionId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0Y36( ) ;
      scanKeyStart0Y36( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
      }
      zm0Y36( -4) ;
      onLoadActions0Y36( ) ;
      addRow0Y36( ) ;
      scanKeyEnd0Y36( ) ;
      if ( RcdFound36 == 0 )
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
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 0) ;
      scanKeyStart0Y36( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
      }
      zm0Y36( -4) ;
      onLoadActions0Y36( ) ;
      addRow0Y36( ) ;
      scanKeyEnd0Y36( ) ;
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Y36( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0Y36( ) ;
      }
      else
      {
         if ( RcdFound36 == 1 )
         {
            if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
            {
               A35WWPNotificationDefinitionId = Z35WWPNotificationDefinitionId ;
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
               update0Y36( ) ;
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
               if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
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
                     insert0Y36( ) ;
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
                     insert0Y36( ) ;
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
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
      saveImpl( ) ;
      VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Y36( ) ;
      afterTrn( ) ;
      VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
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
         com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition auxBC = new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A35WWPNotificationDefinitionId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition);
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
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
      updateImpl( ) ;
      VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
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
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0Y36( ) ;
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
      VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0Y36( ) ;
      if ( RcdFound36 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
         {
            A35WWPNotificationDefinitionId = Z35WWPNotificationDefinitionId ;
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
         if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc");
      VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
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
      Gx_mode = bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition.getgxTv_SdtWWP_NotificationDefinition_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition.setgxTv_SdtWWP_NotificationDefinition_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition )
      {
         bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition.getgxTv_SdtWWP_NotificationDefinition_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition.setgxTv_SdtWWP_NotificationDefinition_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition) ;
         }
         else
         {
            RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition.getgxTv_SdtWWP_NotificationDefinition_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition.setgxTv_SdtWWP_NotificationDefinition_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars36( bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_NotificationDefinition getWWP_NotificationDefinition_BC( )
   {
      return bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition ;
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
      Z181WWPNotificationDefinitionName = "" ;
      A181WWPNotificationDefinitionName = "" ;
      Z154WWPNotificationDefinitionDescr = "" ;
      A154WWPNotificationDefinitionDescr = "" ;
      Z184WWPNotificationDefinitionIcon = "" ;
      A184WWPNotificationDefinitionIcon = "" ;
      Z185WWPNotificationDefinitionTitle = "" ;
      A185WWPNotificationDefinitionTitle = "" ;
      Z186WWPNotificationDefinitionShort = "" ;
      A186WWPNotificationDefinitionShort = "" ;
      Z187WWPNotificationDefinitionLongD = "" ;
      A187WWPNotificationDefinitionLongD = "" ;
      Z188WWPNotificationDefinitionLink = "" ;
      A188WWPNotificationDefinitionLink = "" ;
      Z189WWPNotificationDefinitionSecFu = "" ;
      A189WWPNotificationDefinitionSecFu = "" ;
      Z150WWPEntityName = "" ;
      A150WWPEntityName = "" ;
      BC000Y5_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Y5_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Y5_A155WWPNotificationDefinitionAppli = new byte[1] ;
      BC000Y5_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      BC000Y5_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000Y5_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      BC000Y5_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      BC000Y5_A186WWPNotificationDefinitionShort = new String[] {""} ;
      BC000Y5_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      BC000Y5_A188WWPNotificationDefinitionLink = new String[] {""} ;
      BC000Y5_A150WWPEntityName = new String[] {""} ;
      BC000Y5_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      BC000Y5_A33WWPEntityId = new long[1] ;
      BC000Y6_A150WWPEntityName = new String[] {""} ;
      BC000Y7_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Y8_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Y8_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Y8_A155WWPNotificationDefinitionAppli = new byte[1] ;
      BC000Y8_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      BC000Y8_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000Y8_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      BC000Y8_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      BC000Y8_A186WWPNotificationDefinitionShort = new String[] {""} ;
      BC000Y8_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      BC000Y8_A188WWPNotificationDefinitionLink = new String[] {""} ;
      BC000Y8_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      BC000Y8_A33WWPEntityId = new long[1] ;
      sMode36 = "" ;
      BC000Y9_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Y9_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Y9_A155WWPNotificationDefinitionAppli = new byte[1] ;
      BC000Y9_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      BC000Y9_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000Y9_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      BC000Y9_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      BC000Y9_A186WWPNotificationDefinitionShort = new String[] {""} ;
      BC000Y9_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      BC000Y9_A188WWPNotificationDefinitionLink = new String[] {""} ;
      BC000Y9_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      BC000Y9_A33WWPEntityId = new long[1] ;
      BC000Y10_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Y13_A150WWPEntityName = new String[] {""} ;
      GXv_boolean2 = new boolean[1] ;
      BC000Y14_A37WWPNotificationId = new long[1] ;
      BC000Y15_A34WWPSubscriptionId = new long[1] ;
      BC000Y16_A35WWPNotificationDefinitionId = new long[1] ;
      BC000Y16_A181WWPNotificationDefinitionName = new String[] {""} ;
      BC000Y16_A155WWPNotificationDefinitionAppli = new byte[1] ;
      BC000Y16_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      BC000Y16_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      BC000Y16_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      BC000Y16_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      BC000Y16_A186WWPNotificationDefinitionShort = new String[] {""} ;
      BC000Y16_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      BC000Y16_A188WWPNotificationDefinitionLink = new String[] {""} ;
      BC000Y16_A150WWPEntityName = new String[] {""} ;
      BC000Y16_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      BC000Y16_A33WWPEntityId = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition_bc__default(),
         new Object[] {
             new Object[] {
            BC000Y2_A35WWPNotificationDefinitionId, BC000Y2_A181WWPNotificationDefinitionName, BC000Y2_A155WWPNotificationDefinitionAppli, BC000Y2_A156WWPNotificationDefinitionAllow, BC000Y2_A154WWPNotificationDefinitionDescr, BC000Y2_A184WWPNotificationDefinitionIcon, BC000Y2_A185WWPNotificationDefinitionTitle, BC000Y2_A186WWPNotificationDefinitionShort, BC000Y2_A187WWPNotificationDefinitionLongD, BC000Y2_A188WWPNotificationDefinitionLink,
            BC000Y2_A189WWPNotificationDefinitionSecFu, BC000Y2_A33WWPEntityId
            }
            , new Object[] {
            BC000Y3_A35WWPNotificationDefinitionId, BC000Y3_A181WWPNotificationDefinitionName, BC000Y3_A155WWPNotificationDefinitionAppli, BC000Y3_A156WWPNotificationDefinitionAllow, BC000Y3_A154WWPNotificationDefinitionDescr, BC000Y3_A184WWPNotificationDefinitionIcon, BC000Y3_A185WWPNotificationDefinitionTitle, BC000Y3_A186WWPNotificationDefinitionShort, BC000Y3_A187WWPNotificationDefinitionLongD, BC000Y3_A188WWPNotificationDefinitionLink,
            BC000Y3_A189WWPNotificationDefinitionSecFu, BC000Y3_A33WWPEntityId
            }
            , new Object[] {
            BC000Y4_A150WWPEntityName
            }
            , new Object[] {
            BC000Y5_A35WWPNotificationDefinitionId, BC000Y5_A181WWPNotificationDefinitionName, BC000Y5_A155WWPNotificationDefinitionAppli, BC000Y5_A156WWPNotificationDefinitionAllow, BC000Y5_A154WWPNotificationDefinitionDescr, BC000Y5_A184WWPNotificationDefinitionIcon, BC000Y5_A185WWPNotificationDefinitionTitle, BC000Y5_A186WWPNotificationDefinitionShort, BC000Y5_A187WWPNotificationDefinitionLongD, BC000Y5_A188WWPNotificationDefinitionLink,
            BC000Y5_A150WWPEntityName, BC000Y5_A189WWPNotificationDefinitionSecFu, BC000Y5_A33WWPEntityId
            }
            , new Object[] {
            BC000Y6_A150WWPEntityName
            }
            , new Object[] {
            BC000Y7_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            BC000Y8_A35WWPNotificationDefinitionId, BC000Y8_A181WWPNotificationDefinitionName, BC000Y8_A155WWPNotificationDefinitionAppli, BC000Y8_A156WWPNotificationDefinitionAllow, BC000Y8_A154WWPNotificationDefinitionDescr, BC000Y8_A184WWPNotificationDefinitionIcon, BC000Y8_A185WWPNotificationDefinitionTitle, BC000Y8_A186WWPNotificationDefinitionShort, BC000Y8_A187WWPNotificationDefinitionLongD, BC000Y8_A188WWPNotificationDefinitionLink,
            BC000Y8_A189WWPNotificationDefinitionSecFu, BC000Y8_A33WWPEntityId
            }
            , new Object[] {
            BC000Y9_A35WWPNotificationDefinitionId, BC000Y9_A181WWPNotificationDefinitionName, BC000Y9_A155WWPNotificationDefinitionAppli, BC000Y9_A156WWPNotificationDefinitionAllow, BC000Y9_A154WWPNotificationDefinitionDescr, BC000Y9_A184WWPNotificationDefinitionIcon, BC000Y9_A185WWPNotificationDefinitionTitle, BC000Y9_A186WWPNotificationDefinitionShort, BC000Y9_A187WWPNotificationDefinitionLongD, BC000Y9_A188WWPNotificationDefinitionLink,
            BC000Y9_A189WWPNotificationDefinitionSecFu, BC000Y9_A33WWPEntityId
            }
            , new Object[] {
            BC000Y10_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000Y13_A150WWPEntityName
            }
            , new Object[] {
            BC000Y14_A37WWPNotificationId
            }
            , new Object[] {
            BC000Y15_A34WWPSubscriptionId
            }
            , new Object[] {
            BC000Y16_A35WWPNotificationDefinitionId, BC000Y16_A181WWPNotificationDefinitionName, BC000Y16_A155WWPNotificationDefinitionAppli, BC000Y16_A156WWPNotificationDefinitionAllow, BC000Y16_A154WWPNotificationDefinitionDescr, BC000Y16_A184WWPNotificationDefinitionIcon, BC000Y16_A185WWPNotificationDefinitionTitle, BC000Y16_A186WWPNotificationDefinitionShort, BC000Y16_A187WWPNotificationDefinitionLongD, BC000Y16_A188WWPNotificationDefinitionLink,
            BC000Y16_A150WWPEntityName, BC000Y16_A189WWPNotificationDefinitionSecFu, BC000Y16_A33WWPEntityId
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z155WWPNotificationDefinitionAppli ;
   private byte A155WWPNotificationDefinitionAppli ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound36 ;
   private short nIsDirty_36 ;
   private int trnEnded ;
   private int GX_JID ;
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
   private String sMode36 ;
   private boolean Z156WWPNotificationDefinitionAllow ;
   private boolean A156WWPNotificationDefinitionAllow ;
   private boolean Z190WWPNotificationDefinitionIsAut ;
   private boolean A190WWPNotificationDefinitionIsAut ;
   private boolean Gx_longc ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean mustCommit ;
   private String Z181WWPNotificationDefinitionName ;
   private String A181WWPNotificationDefinitionName ;
   private String Z154WWPNotificationDefinitionDescr ;
   private String A154WWPNotificationDefinitionDescr ;
   private String Z184WWPNotificationDefinitionIcon ;
   private String A184WWPNotificationDefinitionIcon ;
   private String Z185WWPNotificationDefinitionTitle ;
   private String A185WWPNotificationDefinitionTitle ;
   private String Z186WWPNotificationDefinitionShort ;
   private String A186WWPNotificationDefinitionShort ;
   private String Z187WWPNotificationDefinitionLongD ;
   private String A187WWPNotificationDefinitionLongD ;
   private String Z188WWPNotificationDefinitionLink ;
   private String A188WWPNotificationDefinitionLink ;
   private String Z189WWPNotificationDefinitionSecFu ;
   private String A189WWPNotificationDefinitionSecFu ;
   private String Z150WWPEntityName ;
   private String A150WWPEntityName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition bcwwpbaseobjects_notifications_common_WWP_NotificationDefinition ;
   private IDataStoreProvider pr_default ;
   private long[] BC000Y5_A35WWPNotificationDefinitionId ;
   private String[] BC000Y5_A181WWPNotificationDefinitionName ;
   private byte[] BC000Y5_A155WWPNotificationDefinitionAppli ;
   private boolean[] BC000Y5_A156WWPNotificationDefinitionAllow ;
   private String[] BC000Y5_A154WWPNotificationDefinitionDescr ;
   private String[] BC000Y5_A184WWPNotificationDefinitionIcon ;
   private String[] BC000Y5_A185WWPNotificationDefinitionTitle ;
   private String[] BC000Y5_A186WWPNotificationDefinitionShort ;
   private String[] BC000Y5_A187WWPNotificationDefinitionLongD ;
   private String[] BC000Y5_A188WWPNotificationDefinitionLink ;
   private String[] BC000Y5_A150WWPEntityName ;
   private String[] BC000Y5_A189WWPNotificationDefinitionSecFu ;
   private long[] BC000Y5_A33WWPEntityId ;
   private String[] BC000Y6_A150WWPEntityName ;
   private long[] BC000Y7_A35WWPNotificationDefinitionId ;
   private long[] BC000Y8_A35WWPNotificationDefinitionId ;
   private String[] BC000Y8_A181WWPNotificationDefinitionName ;
   private byte[] BC000Y8_A155WWPNotificationDefinitionAppli ;
   private boolean[] BC000Y8_A156WWPNotificationDefinitionAllow ;
   private String[] BC000Y8_A154WWPNotificationDefinitionDescr ;
   private String[] BC000Y8_A184WWPNotificationDefinitionIcon ;
   private String[] BC000Y8_A185WWPNotificationDefinitionTitle ;
   private String[] BC000Y8_A186WWPNotificationDefinitionShort ;
   private String[] BC000Y8_A187WWPNotificationDefinitionLongD ;
   private String[] BC000Y8_A188WWPNotificationDefinitionLink ;
   private String[] BC000Y8_A189WWPNotificationDefinitionSecFu ;
   private long[] BC000Y8_A33WWPEntityId ;
   private long[] BC000Y9_A35WWPNotificationDefinitionId ;
   private String[] BC000Y9_A181WWPNotificationDefinitionName ;
   private byte[] BC000Y9_A155WWPNotificationDefinitionAppli ;
   private boolean[] BC000Y9_A156WWPNotificationDefinitionAllow ;
   private String[] BC000Y9_A154WWPNotificationDefinitionDescr ;
   private String[] BC000Y9_A184WWPNotificationDefinitionIcon ;
   private String[] BC000Y9_A185WWPNotificationDefinitionTitle ;
   private String[] BC000Y9_A186WWPNotificationDefinitionShort ;
   private String[] BC000Y9_A187WWPNotificationDefinitionLongD ;
   private String[] BC000Y9_A188WWPNotificationDefinitionLink ;
   private String[] BC000Y9_A189WWPNotificationDefinitionSecFu ;
   private long[] BC000Y9_A33WWPEntityId ;
   private long[] BC000Y10_A35WWPNotificationDefinitionId ;
   private String[] BC000Y13_A150WWPEntityName ;
   private long[] BC000Y14_A37WWPNotificationId ;
   private long[] BC000Y15_A34WWPSubscriptionId ;
   private long[] BC000Y16_A35WWPNotificationDefinitionId ;
   private String[] BC000Y16_A181WWPNotificationDefinitionName ;
   private byte[] BC000Y16_A155WWPNotificationDefinitionAppli ;
   private boolean[] BC000Y16_A156WWPNotificationDefinitionAllow ;
   private String[] BC000Y16_A154WWPNotificationDefinitionDescr ;
   private String[] BC000Y16_A184WWPNotificationDefinitionIcon ;
   private String[] BC000Y16_A185WWPNotificationDefinitionTitle ;
   private String[] BC000Y16_A186WWPNotificationDefinitionShort ;
   private String[] BC000Y16_A187WWPNotificationDefinitionLongD ;
   private String[] BC000Y16_A188WWPNotificationDefinitionLink ;
   private String[] BC000Y16_A150WWPEntityName ;
   private String[] BC000Y16_A189WWPNotificationDefinitionSecFu ;
   private long[] BC000Y16_A33WWPEntityId ;
   private IDataStoreProvider pr_gam ;
   private long[] BC000Y2_A35WWPNotificationDefinitionId ;
   private String[] BC000Y2_A181WWPNotificationDefinitionName ;
   private byte[] BC000Y2_A155WWPNotificationDefinitionAppli ;
   private boolean[] BC000Y2_A156WWPNotificationDefinitionAllow ;
   private String[] BC000Y2_A154WWPNotificationDefinitionDescr ;
   private String[] BC000Y2_A184WWPNotificationDefinitionIcon ;
   private String[] BC000Y2_A185WWPNotificationDefinitionTitle ;
   private String[] BC000Y2_A186WWPNotificationDefinitionShort ;
   private String[] BC000Y2_A187WWPNotificationDefinitionLongD ;
   private String[] BC000Y2_A188WWPNotificationDefinitionLink ;
   private String[] BC000Y2_A189WWPNotificationDefinitionSecFu ;
   private long[] BC000Y2_A33WWPEntityId ;
   private long[] BC000Y3_A35WWPNotificationDefinitionId ;
   private String[] BC000Y3_A181WWPNotificationDefinitionName ;
   private byte[] BC000Y3_A155WWPNotificationDefinitionAppli ;
   private boolean[] BC000Y3_A156WWPNotificationDefinitionAllow ;
   private String[] BC000Y3_A154WWPNotificationDefinitionDescr ;
   private String[] BC000Y3_A184WWPNotificationDefinitionIcon ;
   private String[] BC000Y3_A185WWPNotificationDefinitionTitle ;
   private String[] BC000Y3_A186WWPNotificationDefinitionShort ;
   private String[] BC000Y3_A187WWPNotificationDefinitionLongD ;
   private String[] BC000Y3_A188WWPNotificationDefinitionLink ;
   private String[] BC000Y3_A189WWPNotificationDefinitionSecFu ;
   private long[] BC000Y3_A33WWPEntityId ;
   private String[] BC000Y4_A150WWPEntityName ;
}

final  class wwp_notificationdefinition_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_notificationdefinition_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000Y2", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId] FROM [WWP_NotificationDefinition] WITH (UPDLOCK) WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y3", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y4", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y5", "SELECT TM1.[WWPNotificationDefinitionId], TM1.[WWPNotificationDefinitionName], TM1.[WWPNotificationDefinitionAppli], TM1.[WWPNotificationDefinitionAllow], TM1.[WWPNotificationDefinitionDescr], TM1.[WWPNotificationDefinitionIcon], TM1.[WWPNotificationDefinitionTitle], TM1.[WWPNotificationDefinitionShort], TM1.[WWPNotificationDefinitionLongD], TM1.[WWPNotificationDefinitionLink], T2.[WWPEntityName], TM1.[WWPNotificationDefinitionSecFu], TM1.[WWPEntityId] FROM ([WWP_NotificationDefinition] TM1 INNER JOIN [WWP_Entity] T2 ON T2.[WWPEntityId] = TM1.[WWPEntityId]) WHERE TM1.[WWPNotificationDefinitionId] = ? ORDER BY TM1.[WWPNotificationDefinitionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y6", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y7", "SELECT [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y8", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y9", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId] FROM [WWP_NotificationDefinition] WITH (UPDLOCK) WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y10", "INSERT INTO [WWP_NotificationDefinition]([WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC000Y11", "UPDATE [WWP_NotificationDefinition] SET [WWPNotificationDefinitionName]=?, [WWPNotificationDefinitionAppli]=?, [WWPNotificationDefinitionAllow]=?, [WWPNotificationDefinitionDescr]=?, [WWPNotificationDefinitionIcon]=?, [WWPNotificationDefinitionTitle]=?, [WWPNotificationDefinitionShort]=?, [WWPNotificationDefinitionLongD]=?, [WWPNotificationDefinitionLink]=?, [WWPNotificationDefinitionSecFu]=?, [WWPEntityId]=?  WHERE [WWPNotificationDefinitionId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000Y12", "DELETE FROM [WWP_NotificationDefinition]  WHERE [WWPNotificationDefinitionId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000Y13", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000Y14", "SELECT TOP 1 [WWPNotificationId] FROM [WWP_Notification] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000Y15", "SELECT TOP 1 [WWPSubscriptionId] FROM [WWP_Subscription] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000Y16", "SELECT TM1.[WWPNotificationDefinitionId], TM1.[WWPNotificationDefinitionName], TM1.[WWPNotificationDefinitionAppli], TM1.[WWPNotificationDefinitionAllow], TM1.[WWPNotificationDefinitionDescr], TM1.[WWPNotificationDefinitionIcon], TM1.[WWPNotificationDefinitionTitle], TM1.[WWPNotificationDefinitionShort], TM1.[WWPNotificationDefinitionLongD], TM1.[WWPNotificationDefinitionLink], T2.[WWPEntityName], TM1.[WWPNotificationDefinitionSecFu], TM1.[WWPEntityId] FROM ([WWP_NotificationDefinition] TM1 INNER JOIN [WWP_Entity] T2 ON T2.[WWPEntityId] = TM1.[WWPEntityId]) WHERE TM1.[WWPNotificationDefinitionId] = ? ORDER BY TM1.[WWPNotificationDefinitionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 200, false);
               stmt.setVarchar(7, (String)parms[6], 200, false);
               stmt.setVarchar(8, (String)parms[7], 1000, false);
               stmt.setVarchar(9, (String)parms[8], 1000, false);
               stmt.setVarchar(10, (String)parms[9], 200, false);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 200, false);
               stmt.setVarchar(7, (String)parms[6], 200, false);
               stmt.setVarchar(8, (String)parms[7], 1000, false);
               stmt.setVarchar(9, (String)parms[8], 1000, false);
               stmt.setVarchar(10, (String)parms[9], 200, false);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

