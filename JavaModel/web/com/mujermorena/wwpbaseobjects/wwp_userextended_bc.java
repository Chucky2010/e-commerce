package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_userextended_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_userextended_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_userextended_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_userextended_bc.class ));
   }

   public wwp_userextended_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0S30( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0S30( ) ;
      standaloneModal( ) ;
      addRow0S30( ) ;
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
            Z32WWPUserExtendedId = A32WWPUserExtendedId ;
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

   public void confirm_0S0( )
   {
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0S30( ) ;
         }
         else
         {
            checkExtendedTable0S30( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0S30( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0S30( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z146WWPUserExtendedName = A146WWPUserExtendedName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
         Z145WWPUserExtendedPhone = A145WWPUserExtendedPhone ;
         Z139WWPUserExtendedEmail = A139WWPUserExtendedEmail ;
         Z141WWPUserExtendedEmaiNotif = A141WWPUserExtendedEmaiNotif ;
         Z142WWPUserExtendedSMSNotif = A142WWPUserExtendedSMSNotif ;
         Z143WWPUserExtendedMobileNotif = A143WWPUserExtendedMobileNotif ;
         Z144WWPUserExtendedDesktopNotif = A144WWPUserExtendedDesktopNotif ;
         Z147WWPUserExtendedDeleted = A147WWPUserExtendedDeleted ;
         Z148WWPUserExtendedDeletedIn = A148WWPUserExtendedDeletedIn ;
      }
      if ( GX_JID == -3 )
      {
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         Z140WWPUserExtendedPhoto = A140WWPUserExtendedPhoto ;
         Z40000WWPUserExtendedPhoto_GXI = A40000WWPUserExtendedPhoto_GXI ;
         Z146WWPUserExtendedName = A146WWPUserExtendedName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
         Z145WWPUserExtendedPhone = A145WWPUserExtendedPhone ;
         Z139WWPUserExtendedEmail = A139WWPUserExtendedEmail ;
         Z141WWPUserExtendedEmaiNotif = A141WWPUserExtendedEmaiNotif ;
         Z142WWPUserExtendedSMSNotif = A142WWPUserExtendedSMSNotif ;
         Z143WWPUserExtendedMobileNotif = A143WWPUserExtendedMobileNotif ;
         Z144WWPUserExtendedDesktopNotif = A144WWPUserExtendedDesktopNotif ;
         Z147WWPUserExtendedDeleted = A147WWPUserExtendedDeleted ;
         Z148WWPUserExtendedDeletedIn = A148WWPUserExtendedDeletedIn ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0S30( )
   {
      /* Using cursor BC000S4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A140WWPUserExtendedPhoto = BC000S4_A140WWPUserExtendedPhoto[0] ;
         A40000WWPUserExtendedPhoto_GXI = BC000S4_A40000WWPUserExtendedPhoto_GXI[0] ;
         A146WWPUserExtendedName = BC000S4_A146WWPUserExtendedName[0] ;
         A138WWPUserExtendedFullName = BC000S4_A138WWPUserExtendedFullName[0] ;
         A145WWPUserExtendedPhone = BC000S4_A145WWPUserExtendedPhone[0] ;
         A139WWPUserExtendedEmail = BC000S4_A139WWPUserExtendedEmail[0] ;
         A141WWPUserExtendedEmaiNotif = BC000S4_A141WWPUserExtendedEmaiNotif[0] ;
         A142WWPUserExtendedSMSNotif = BC000S4_A142WWPUserExtendedSMSNotif[0] ;
         A143WWPUserExtendedMobileNotif = BC000S4_A143WWPUserExtendedMobileNotif[0] ;
         A144WWPUserExtendedDesktopNotif = BC000S4_A144WWPUserExtendedDesktopNotif[0] ;
         A147WWPUserExtendedDeleted = BC000S4_A147WWPUserExtendedDeleted[0] ;
         A148WWPUserExtendedDeletedIn = BC000S4_A148WWPUserExtendedDeletedIn[0] ;
         n148WWPUserExtendedDeletedIn = BC000S4_n148WWPUserExtendedDeletedIn[0] ;
         zm0S30( -3) ;
      }
      pr_default.close(2);
      onLoadActions0S30( ) ;
   }

   public void onLoadActions0S30( )
   {
   }

   public void checkExtendedTable0S30( )
   {
      nIsDirty_30 = (short)(0) ;
      standaloneModal( ) ;
      if ( ! ( GxRegex.IsMatch(A139WWPUserExtendedEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "User Email", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A148WWPUserExtendedDeletedIn) || (( A148WWPUserExtendedDeletedIn.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A148WWPUserExtendedDeletedIn, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "WWPUser Extended Deleted In", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0S30( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0S30( )
   {
      /* Using cursor BC000S5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound30 = (short)(1) ;
      }
      else
      {
         RcdFound30 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000S6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0S30( 3) ;
         RcdFound30 = (short)(1) ;
         A32WWPUserExtendedId = BC000S6_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000S6_n32WWPUserExtendedId[0] ;
         A140WWPUserExtendedPhoto = BC000S6_A140WWPUserExtendedPhoto[0] ;
         A40000WWPUserExtendedPhoto_GXI = BC000S6_A40000WWPUserExtendedPhoto_GXI[0] ;
         A146WWPUserExtendedName = BC000S6_A146WWPUserExtendedName[0] ;
         A138WWPUserExtendedFullName = BC000S6_A138WWPUserExtendedFullName[0] ;
         A145WWPUserExtendedPhone = BC000S6_A145WWPUserExtendedPhone[0] ;
         A139WWPUserExtendedEmail = BC000S6_A139WWPUserExtendedEmail[0] ;
         A141WWPUserExtendedEmaiNotif = BC000S6_A141WWPUserExtendedEmaiNotif[0] ;
         A142WWPUserExtendedSMSNotif = BC000S6_A142WWPUserExtendedSMSNotif[0] ;
         A143WWPUserExtendedMobileNotif = BC000S6_A143WWPUserExtendedMobileNotif[0] ;
         A144WWPUserExtendedDesktopNotif = BC000S6_A144WWPUserExtendedDesktopNotif[0] ;
         A147WWPUserExtendedDeleted = BC000S6_A147WWPUserExtendedDeleted[0] ;
         A148WWPUserExtendedDeletedIn = BC000S6_A148WWPUserExtendedDeletedIn[0] ;
         n148WWPUserExtendedDeletedIn = BC000S6_n148WWPUserExtendedDeletedIn[0] ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0S30( ) ;
         if ( AnyError == 1 )
         {
            RcdFound30 = (short)(0) ;
            initializeNonKey0S30( ) ;
         }
         Gx_mode = sMode30 ;
      }
      else
      {
         RcdFound30 = (short)(0) ;
         initializeNonKey0S30( ) ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode30 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0S30( ) ;
      if ( RcdFound30 == 0 )
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
      confirm_0S0( ) ;
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

   public void checkOptimisticConcurrency0S30( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000S7 */
         pr_default.execute(5, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_UserExtended"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z146WWPUserExtendedName, BC000S7_A146WWPUserExtendedName[0]) != 0 ) || ( GXutil.strcmp(Z138WWPUserExtendedFullName, BC000S7_A138WWPUserExtendedFullName[0]) != 0 ) || ( GXutil.strcmp(Z145WWPUserExtendedPhone, BC000S7_A145WWPUserExtendedPhone[0]) != 0 ) || ( GXutil.strcmp(Z139WWPUserExtendedEmail, BC000S7_A139WWPUserExtendedEmail[0]) != 0 ) || ( Z141WWPUserExtendedEmaiNotif != BC000S7_A141WWPUserExtendedEmaiNotif[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z142WWPUserExtendedSMSNotif != BC000S7_A142WWPUserExtendedSMSNotif[0] ) || ( Z143WWPUserExtendedMobileNotif != BC000S7_A143WWPUserExtendedMobileNotif[0] ) || ( Z144WWPUserExtendedDesktopNotif != BC000S7_A144WWPUserExtendedDesktopNotif[0] ) || ( Z147WWPUserExtendedDeleted != BC000S7_A147WWPUserExtendedDeleted[0] ) || !( GXutil.dateCompare(Z148WWPUserExtendedDeletedIn, BC000S7_A148WWPUserExtendedDeletedIn[0]) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_UserExtended"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0S30( )
   {
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0S30( 0) ;
         checkOptimisticConcurrency0S30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S30( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0S30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000S8 */
                  pr_default.execute(6, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, A140WWPUserExtendedPhoto, A40000WWPUserExtendedPhoto_GXI, A146WWPUserExtendedName, A138WWPUserExtendedFullName, A145WWPUserExtendedPhone, A139WWPUserExtendedEmail, Boolean.valueOf(A141WWPUserExtendedEmaiNotif), Boolean.valueOf(A142WWPUserExtendedSMSNotif), Boolean.valueOf(A143WWPUserExtendedMobileNotif), Boolean.valueOf(A144WWPUserExtendedDesktopNotif), Boolean.valueOf(A147WWPUserExtendedDeleted), Boolean.valueOf(n148WWPUserExtendedDeletedIn), A148WWPUserExtendedDeletedIn});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
                  if ( (pr_default.getStatus(6) == 1) )
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
            load0S30( ) ;
         }
         endLevel0S30( ) ;
      }
      closeExtendedTableCursors0S30( ) ;
   }

   public void update0S30( )
   {
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S30( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0S30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000S9 */
                  pr_default.execute(7, new Object[] {A146WWPUserExtendedName, A138WWPUserExtendedFullName, A145WWPUserExtendedPhone, A139WWPUserExtendedEmail, Boolean.valueOf(A141WWPUserExtendedEmaiNotif), Boolean.valueOf(A142WWPUserExtendedSMSNotif), Boolean.valueOf(A143WWPUserExtendedMobileNotif), Boolean.valueOf(A144WWPUserExtendedDesktopNotif), Boolean.valueOf(A147WWPUserExtendedDeleted), Boolean.valueOf(n148WWPUserExtendedDeletedIn), A148WWPUserExtendedDeletedIn, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_UserExtended"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0S30( ) ;
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
         endLevel0S30( ) ;
      }
      closeExtendedTableCursors0S30( ) ;
   }

   public void deferredUpdate0S30( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000S10 */
         pr_default.execute(8, new Object[] {A140WWPUserExtendedPhoto, A40000WWPUserExtendedPhoto_GXI, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0S30( ) ;
         afterConfirm0S30( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0S30( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000S11 */
               pr_default.execute(9, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
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
      sMode30 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0S30( ) ;
      Gx_mode = sMode30 ;
   }

   public void onDeleteControls0S30( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000S12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Notification", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
         /* Using cursor BC000S13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_WebClient", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor BC000S14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Subscription", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel0S30( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0S30( ) ;
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

   public void scanKeyStart0S30( )
   {
      /* Using cursor BC000S15 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      RcdFound30 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32WWPUserExtendedId = BC000S15_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000S15_n32WWPUserExtendedId[0] ;
         A140WWPUserExtendedPhoto = BC000S15_A140WWPUserExtendedPhoto[0] ;
         A40000WWPUserExtendedPhoto_GXI = BC000S15_A40000WWPUserExtendedPhoto_GXI[0] ;
         A146WWPUserExtendedName = BC000S15_A146WWPUserExtendedName[0] ;
         A138WWPUserExtendedFullName = BC000S15_A138WWPUserExtendedFullName[0] ;
         A145WWPUserExtendedPhone = BC000S15_A145WWPUserExtendedPhone[0] ;
         A139WWPUserExtendedEmail = BC000S15_A139WWPUserExtendedEmail[0] ;
         A141WWPUserExtendedEmaiNotif = BC000S15_A141WWPUserExtendedEmaiNotif[0] ;
         A142WWPUserExtendedSMSNotif = BC000S15_A142WWPUserExtendedSMSNotif[0] ;
         A143WWPUserExtendedMobileNotif = BC000S15_A143WWPUserExtendedMobileNotif[0] ;
         A144WWPUserExtendedDesktopNotif = BC000S15_A144WWPUserExtendedDesktopNotif[0] ;
         A147WWPUserExtendedDeleted = BC000S15_A147WWPUserExtendedDeleted[0] ;
         A148WWPUserExtendedDeletedIn = BC000S15_A148WWPUserExtendedDeletedIn[0] ;
         n148WWPUserExtendedDeletedIn = BC000S15_n148WWPUserExtendedDeletedIn[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0S30( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound30 = (short)(0) ;
      scanKeyLoad0S30( ) ;
   }

   public void scanKeyLoad0S30( )
   {
      sMode30 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32WWPUserExtendedId = BC000S15_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000S15_n32WWPUserExtendedId[0] ;
         A140WWPUserExtendedPhoto = BC000S15_A140WWPUserExtendedPhoto[0] ;
         A40000WWPUserExtendedPhoto_GXI = BC000S15_A40000WWPUserExtendedPhoto_GXI[0] ;
         A146WWPUserExtendedName = BC000S15_A146WWPUserExtendedName[0] ;
         A138WWPUserExtendedFullName = BC000S15_A138WWPUserExtendedFullName[0] ;
         A145WWPUserExtendedPhone = BC000S15_A145WWPUserExtendedPhone[0] ;
         A139WWPUserExtendedEmail = BC000S15_A139WWPUserExtendedEmail[0] ;
         A141WWPUserExtendedEmaiNotif = BC000S15_A141WWPUserExtendedEmaiNotif[0] ;
         A142WWPUserExtendedSMSNotif = BC000S15_A142WWPUserExtendedSMSNotif[0] ;
         A143WWPUserExtendedMobileNotif = BC000S15_A143WWPUserExtendedMobileNotif[0] ;
         A144WWPUserExtendedDesktopNotif = BC000S15_A144WWPUserExtendedDesktopNotif[0] ;
         A147WWPUserExtendedDeleted = BC000S15_A147WWPUserExtendedDeleted[0] ;
         A148WWPUserExtendedDeletedIn = BC000S15_A148WWPUserExtendedDeletedIn[0] ;
         n148WWPUserExtendedDeletedIn = BC000S15_n148WWPUserExtendedDeletedIn[0] ;
      }
      Gx_mode = sMode30 ;
   }

   public void scanKeyEnd0S30( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0S30( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0S30( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0S30( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0S30( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0S30( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0S30( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0S30( )
   {
   }

   public void send_integrity_lvl_hashes0S30( )
   {
   }

   public void addRow0S30( )
   {
      VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
   }

   public void readRow0S30( )
   {
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
   }

   public void initializeNonKey0S30( )
   {
      A140WWPUserExtendedPhoto = "" ;
      A40000WWPUserExtendedPhoto_GXI = "" ;
      A146WWPUserExtendedName = "" ;
      A138WWPUserExtendedFullName = "" ;
      A145WWPUserExtendedPhone = "" ;
      A139WWPUserExtendedEmail = "" ;
      A141WWPUserExtendedEmaiNotif = false ;
      A142WWPUserExtendedSMSNotif = false ;
      A143WWPUserExtendedMobileNotif = false ;
      A144WWPUserExtendedDesktopNotif = false ;
      A147WWPUserExtendedDeleted = false ;
      A148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      n148WWPUserExtendedDeletedIn = false ;
      Z146WWPUserExtendedName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      Z145WWPUserExtendedPhone = "" ;
      Z139WWPUserExtendedEmail = "" ;
      Z141WWPUserExtendedEmaiNotif = false ;
      Z142WWPUserExtendedSMSNotif = false ;
      Z143WWPUserExtendedMobileNotif = false ;
      Z144WWPUserExtendedDesktopNotif = false ;
      Z147WWPUserExtendedDeleted = false ;
      Z148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
   }

   public void initAll0S30( )
   {
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      initializeNonKey0S30( ) ;
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

   public void VarsToRow30( com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended obj30 )
   {
      obj30.setgxTv_SdtWWP_UserExtended_Mode( Gx_mode );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto( A140WWPUserExtendedPhoto );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi( A40000WWPUserExtendedPhoto_GXI );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedname( A146WWPUserExtendedName );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname( A138WWPUserExtendedFullName );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone( A145WWPUserExtendedPhone );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail( A139WWPUserExtendedEmail );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif( A141WWPUserExtendedEmaiNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif( A142WWPUserExtendedSMSNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif( A143WWPUserExtendedMobileNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif( A144WWPUserExtendedDesktopNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted( A147WWPUserExtendedDeleted );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin( A148WWPUserExtendedDeletedIn );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid( A32WWPUserExtendedId );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z( Z32WWPUserExtendedId );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z( Z146WWPUserExtendedName );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z( Z138WWPUserExtendedFullName );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z( Z145WWPUserExtendedPhone );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z( Z139WWPUserExtendedEmail );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z( Z141WWPUserExtendedEmaiNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z( Z142WWPUserExtendedSMSNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z( Z143WWPUserExtendedMobileNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z( Z144WWPUserExtendedDesktopNotif );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z( Z147WWPUserExtendedDeleted );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z( Z148WWPUserExtendedDeletedIn );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z( Z40000WWPUserExtendedPhoto_GXI );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N( (byte)((byte)((n32WWPUserExtendedId)?1:0)) );
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N( (byte)((byte)((n148WWPUserExtendedDeletedIn)?1:0)) );
      obj30.setgxTv_SdtWWP_UserExtended_Mode( Gx_mode );
   }

   public void KeyVarsToRow30( com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended obj30 )
   {
      obj30.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid( A32WWPUserExtendedId );
   }

   public void RowToVars30( com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended obj30 ,
                            int forceLoad )
   {
      Gx_mode = obj30.getgxTv_SdtWWP_UserExtended_Mode() ;
      A140WWPUserExtendedPhoto = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto() ;
      A40000WWPUserExtendedPhoto_GXI = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi() ;
      A146WWPUserExtendedName = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedname() ;
      A138WWPUserExtendedFullName = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname() ;
      A145WWPUserExtendedPhone = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone() ;
      A139WWPUserExtendedEmail = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail() ;
      A141WWPUserExtendedEmaiNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif() ;
      A142WWPUserExtendedSMSNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif() ;
      A143WWPUserExtendedMobileNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif() ;
      A144WWPUserExtendedDesktopNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif() ;
      A147WWPUserExtendedDeleted = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted() ;
      A148WWPUserExtendedDeletedIn = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin() ;
      n148WWPUserExtendedDeletedIn = false ;
      A32WWPUserExtendedId = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedid() ;
      n32WWPUserExtendedId = false ;
      Z32WWPUserExtendedId = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_Z() ;
      Z146WWPUserExtendedName = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedname_Z() ;
      Z138WWPUserExtendedFullName = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname_Z() ;
      Z145WWPUserExtendedPhone = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphone_Z() ;
      Z139WWPUserExtendedEmail = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedemail_Z() ;
      Z141WWPUserExtendedEmaiNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif_Z() ;
      Z142WWPUserExtendedSMSNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif_Z() ;
      Z143WWPUserExtendedMobileNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif_Z() ;
      Z144WWPUserExtendedDesktopNotif = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif_Z() ;
      Z147WWPUserExtendedDeleted = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted_Z() ;
      Z148WWPUserExtendedDeletedIn = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_Z() ;
      Z40000WWPUserExtendedPhoto_GXI = obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedphoto_gxi_Z() ;
      n32WWPUserExtendedId = (boolean)((obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendedid_N()==0)?false:true) ;
      n148WWPUserExtendedDeletedIn = (boolean)((obj30.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_N()==0)?false:true) ;
      Gx_mode = obj30.getgxTv_SdtWWP_UserExtended_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A32WWPUserExtendedId = (String)getParm(obj,0) ;
      n32WWPUserExtendedId = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0S30( ) ;
      scanKeyStart0S30( ) ;
      if ( RcdFound30 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
      }
      zm0S30( -3) ;
      onLoadActions0S30( ) ;
      addRow0S30( ) ;
      scanKeyEnd0S30( ) ;
      if ( RcdFound30 == 0 )
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
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 0) ;
      scanKeyStart0S30( ) ;
      if ( RcdFound30 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
      }
      zm0S30( -3) ;
      onLoadActions0S30( ) ;
      addRow0S30( ) ;
      scanKeyEnd0S30( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0S30( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0S30( ) ;
      }
      else
      {
         if ( RcdFound30 == 1 )
         {
            if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
            {
               A32WWPUserExtendedId = Z32WWPUserExtendedId ;
               n32WWPUserExtendedId = false ;
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
               update0S30( ) ;
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
               if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
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
                     insert0S30( ) ;
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
                     insert0S30( ) ;
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
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
      saveImpl( ) ;
      VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0S30( ) ;
      afterTrn( ) ;
      VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
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
         com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended auxBC = new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A32WWPUserExtendedId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_WWP_UserExtended);
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
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
      updateImpl( ) ;
      VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
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
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0S30( ) ;
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
      VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0S30( ) ;
      if ( RcdFound30 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
         {
            A32WWPUserExtendedId = Z32WWPUserExtendedId ;
            n32WWPUserExtendedId = false ;
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
         if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.wwp_userextended_bc");
      VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
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
      Gx_mode = bcwwpbaseobjects_WWP_UserExtended.getgxTv_SdtWWP_UserExtended_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_WWP_UserExtended )
      {
         bcwwpbaseobjects_WWP_UserExtended = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_WWP_UserExtended.getgxTv_SdtWWP_UserExtended_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow30( bcwwpbaseobjects_WWP_UserExtended) ;
         }
         else
         {
            RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_WWP_UserExtended.getgxTv_SdtWWP_UserExtended_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars30( bcwwpbaseobjects_WWP_UserExtended, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_UserExtended getWWP_UserExtended_BC( )
   {
      return bcwwpbaseobjects_WWP_UserExtended ;
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
      Z32WWPUserExtendedId = "" ;
      A32WWPUserExtendedId = "" ;
      Z146WWPUserExtendedName = "" ;
      A146WWPUserExtendedName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      A138WWPUserExtendedFullName = "" ;
      Z145WWPUserExtendedPhone = "" ;
      A145WWPUserExtendedPhone = "" ;
      Z139WWPUserExtendedEmail = "" ;
      A139WWPUserExtendedEmail = "" ;
      Z148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      A148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      Z140WWPUserExtendedPhoto = "" ;
      A140WWPUserExtendedPhoto = "" ;
      Z40000WWPUserExtendedPhoto_GXI = "" ;
      A40000WWPUserExtendedPhoto_GXI = "" ;
      BC000S4_A32WWPUserExtendedId = new String[] {""} ;
      BC000S4_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000S4_A140WWPUserExtendedPhoto = new String[] {""} ;
      BC000S4_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      BC000S4_A146WWPUserExtendedName = new String[] {""} ;
      BC000S4_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000S4_A145WWPUserExtendedPhone = new String[] {""} ;
      BC000S4_A139WWPUserExtendedEmail = new String[] {""} ;
      BC000S4_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      BC000S4_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      BC000S4_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      BC000S4_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      BC000S4_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      BC000S4_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      BC000S4_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      BC000S5_A32WWPUserExtendedId = new String[] {""} ;
      BC000S5_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000S6_A32WWPUserExtendedId = new String[] {""} ;
      BC000S6_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000S6_A140WWPUserExtendedPhoto = new String[] {""} ;
      BC000S6_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      BC000S6_A146WWPUserExtendedName = new String[] {""} ;
      BC000S6_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000S6_A145WWPUserExtendedPhone = new String[] {""} ;
      BC000S6_A139WWPUserExtendedEmail = new String[] {""} ;
      BC000S6_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      BC000S6_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      BC000S6_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      BC000S6_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      BC000S6_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      BC000S6_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      BC000S6_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      sMode30 = "" ;
      BC000S7_A32WWPUserExtendedId = new String[] {""} ;
      BC000S7_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000S7_A140WWPUserExtendedPhoto = new String[] {""} ;
      BC000S7_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      BC000S7_A146WWPUserExtendedName = new String[] {""} ;
      BC000S7_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000S7_A145WWPUserExtendedPhone = new String[] {""} ;
      BC000S7_A139WWPUserExtendedEmail = new String[] {""} ;
      BC000S7_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      BC000S7_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      BC000S7_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      BC000S7_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      BC000S7_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      BC000S7_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      BC000S7_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      BC000S12_A37WWPNotificationId = new long[1] ;
      BC000S13_A39WWPWebClientId = new String[] {""} ;
      BC000S14_A34WWPSubscriptionId = new long[1] ;
      BC000S15_A32WWPUserExtendedId = new String[] {""} ;
      BC000S15_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000S15_A140WWPUserExtendedPhoto = new String[] {""} ;
      BC000S15_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      BC000S15_A146WWPUserExtendedName = new String[] {""} ;
      BC000S15_A138WWPUserExtendedFullName = new String[] {""} ;
      BC000S15_A145WWPUserExtendedPhone = new String[] {""} ;
      BC000S15_A139WWPUserExtendedEmail = new String[] {""} ;
      BC000S15_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      BC000S15_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      BC000S15_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      BC000S15_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      BC000S15_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      BC000S15_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      BC000S15_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_userextended_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_userextended_bc__default(),
         new Object[] {
             new Object[] {
            BC000S2_A32WWPUserExtendedId, BC000S2_A140WWPUserExtendedPhoto, BC000S2_A40000WWPUserExtendedPhoto_GXI, BC000S2_A146WWPUserExtendedName, BC000S2_A138WWPUserExtendedFullName, BC000S2_A145WWPUserExtendedPhone, BC000S2_A139WWPUserExtendedEmail, BC000S2_A141WWPUserExtendedEmaiNotif, BC000S2_A142WWPUserExtendedSMSNotif, BC000S2_A143WWPUserExtendedMobileNotif,
            BC000S2_A144WWPUserExtendedDesktopNotif, BC000S2_A147WWPUserExtendedDeleted, BC000S2_A148WWPUserExtendedDeletedIn, BC000S2_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            BC000S3_A32WWPUserExtendedId, BC000S3_A140WWPUserExtendedPhoto, BC000S3_A40000WWPUserExtendedPhoto_GXI, BC000S3_A146WWPUserExtendedName, BC000S3_A138WWPUserExtendedFullName, BC000S3_A145WWPUserExtendedPhone, BC000S3_A139WWPUserExtendedEmail, BC000S3_A141WWPUserExtendedEmaiNotif, BC000S3_A142WWPUserExtendedSMSNotif, BC000S3_A143WWPUserExtendedMobileNotif,
            BC000S3_A144WWPUserExtendedDesktopNotif, BC000S3_A147WWPUserExtendedDeleted, BC000S3_A148WWPUserExtendedDeletedIn, BC000S3_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            BC000S4_A32WWPUserExtendedId, BC000S4_A140WWPUserExtendedPhoto, BC000S4_A40000WWPUserExtendedPhoto_GXI, BC000S4_A146WWPUserExtendedName, BC000S4_A138WWPUserExtendedFullName, BC000S4_A145WWPUserExtendedPhone, BC000S4_A139WWPUserExtendedEmail, BC000S4_A141WWPUserExtendedEmaiNotif, BC000S4_A142WWPUserExtendedSMSNotif, BC000S4_A143WWPUserExtendedMobileNotif,
            BC000S4_A144WWPUserExtendedDesktopNotif, BC000S4_A147WWPUserExtendedDeleted, BC000S4_A148WWPUserExtendedDeletedIn, BC000S4_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            BC000S5_A32WWPUserExtendedId
            }
            , new Object[] {
            BC000S6_A32WWPUserExtendedId, BC000S6_A140WWPUserExtendedPhoto, BC000S6_A40000WWPUserExtendedPhoto_GXI, BC000S6_A146WWPUserExtendedName, BC000S6_A138WWPUserExtendedFullName, BC000S6_A145WWPUserExtendedPhone, BC000S6_A139WWPUserExtendedEmail, BC000S6_A141WWPUserExtendedEmaiNotif, BC000S6_A142WWPUserExtendedSMSNotif, BC000S6_A143WWPUserExtendedMobileNotif,
            BC000S6_A144WWPUserExtendedDesktopNotif, BC000S6_A147WWPUserExtendedDeleted, BC000S6_A148WWPUserExtendedDeletedIn, BC000S6_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            BC000S7_A32WWPUserExtendedId, BC000S7_A140WWPUserExtendedPhoto, BC000S7_A40000WWPUserExtendedPhoto_GXI, BC000S7_A146WWPUserExtendedName, BC000S7_A138WWPUserExtendedFullName, BC000S7_A145WWPUserExtendedPhone, BC000S7_A139WWPUserExtendedEmail, BC000S7_A141WWPUserExtendedEmaiNotif, BC000S7_A142WWPUserExtendedSMSNotif, BC000S7_A143WWPUserExtendedMobileNotif,
            BC000S7_A144WWPUserExtendedDesktopNotif, BC000S7_A147WWPUserExtendedDeleted, BC000S7_A148WWPUserExtendedDeletedIn, BC000S7_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000S12_A37WWPNotificationId
            }
            , new Object[] {
            BC000S13_A39WWPWebClientId
            }
            , new Object[] {
            BC000S14_A34WWPSubscriptionId
            }
            , new Object[] {
            BC000S15_A32WWPUserExtendedId, BC000S15_A140WWPUserExtendedPhoto, BC000S15_A40000WWPUserExtendedPhoto_GXI, BC000S15_A146WWPUserExtendedName, BC000S15_A138WWPUserExtendedFullName, BC000S15_A145WWPUserExtendedPhone, BC000S15_A139WWPUserExtendedEmail, BC000S15_A141WWPUserExtendedEmaiNotif, BC000S15_A142WWPUserExtendedSMSNotif, BC000S15_A143WWPUserExtendedMobileNotif,
            BC000S15_A144WWPUserExtendedDesktopNotif, BC000S15_A147WWPUserExtendedDeleted, BC000S15_A148WWPUserExtendedDeletedIn, BC000S15_n148WWPUserExtendedDeletedIn
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
   private short RcdFound30 ;
   private short nIsDirty_30 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z32WWPUserExtendedId ;
   private String A32WWPUserExtendedId ;
   private String Z145WWPUserExtendedPhone ;
   private String A145WWPUserExtendedPhone ;
   private String sMode30 ;
   private java.util.Date Z148WWPUserExtendedDeletedIn ;
   private java.util.Date A148WWPUserExtendedDeletedIn ;
   private boolean Z141WWPUserExtendedEmaiNotif ;
   private boolean A141WWPUserExtendedEmaiNotif ;
   private boolean Z142WWPUserExtendedSMSNotif ;
   private boolean A142WWPUserExtendedSMSNotif ;
   private boolean Z143WWPUserExtendedMobileNotif ;
   private boolean A143WWPUserExtendedMobileNotif ;
   private boolean Z144WWPUserExtendedDesktopNotif ;
   private boolean A144WWPUserExtendedDesktopNotif ;
   private boolean Z147WWPUserExtendedDeleted ;
   private boolean A147WWPUserExtendedDeleted ;
   private boolean n32WWPUserExtendedId ;
   private boolean n148WWPUserExtendedDeletedIn ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z146WWPUserExtendedName ;
   private String A146WWPUserExtendedName ;
   private String Z138WWPUserExtendedFullName ;
   private String A138WWPUserExtendedFullName ;
   private String Z139WWPUserExtendedEmail ;
   private String A139WWPUserExtendedEmail ;
   private String Z40000WWPUserExtendedPhoto_GXI ;
   private String A40000WWPUserExtendedPhoto_GXI ;
   private String Z140WWPUserExtendedPhoto ;
   private String A140WWPUserExtendedPhoto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended bcwwpbaseobjects_WWP_UserExtended ;
   private IDataStoreProvider pr_default ;
   private String[] BC000S4_A32WWPUserExtendedId ;
   private boolean[] BC000S4_n32WWPUserExtendedId ;
   private String[] BC000S4_A140WWPUserExtendedPhoto ;
   private String[] BC000S4_A40000WWPUserExtendedPhoto_GXI ;
   private String[] BC000S4_A146WWPUserExtendedName ;
   private String[] BC000S4_A138WWPUserExtendedFullName ;
   private String[] BC000S4_A145WWPUserExtendedPhone ;
   private String[] BC000S4_A139WWPUserExtendedEmail ;
   private boolean[] BC000S4_A141WWPUserExtendedEmaiNotif ;
   private boolean[] BC000S4_A142WWPUserExtendedSMSNotif ;
   private boolean[] BC000S4_A143WWPUserExtendedMobileNotif ;
   private boolean[] BC000S4_A144WWPUserExtendedDesktopNotif ;
   private boolean[] BC000S4_A147WWPUserExtendedDeleted ;
   private java.util.Date[] BC000S4_A148WWPUserExtendedDeletedIn ;
   private boolean[] BC000S4_n148WWPUserExtendedDeletedIn ;
   private String[] BC000S5_A32WWPUserExtendedId ;
   private boolean[] BC000S5_n32WWPUserExtendedId ;
   private String[] BC000S6_A32WWPUserExtendedId ;
   private boolean[] BC000S6_n32WWPUserExtendedId ;
   private String[] BC000S6_A140WWPUserExtendedPhoto ;
   private String[] BC000S6_A40000WWPUserExtendedPhoto_GXI ;
   private String[] BC000S6_A146WWPUserExtendedName ;
   private String[] BC000S6_A138WWPUserExtendedFullName ;
   private String[] BC000S6_A145WWPUserExtendedPhone ;
   private String[] BC000S6_A139WWPUserExtendedEmail ;
   private boolean[] BC000S6_A141WWPUserExtendedEmaiNotif ;
   private boolean[] BC000S6_A142WWPUserExtendedSMSNotif ;
   private boolean[] BC000S6_A143WWPUserExtendedMobileNotif ;
   private boolean[] BC000S6_A144WWPUserExtendedDesktopNotif ;
   private boolean[] BC000S6_A147WWPUserExtendedDeleted ;
   private java.util.Date[] BC000S6_A148WWPUserExtendedDeletedIn ;
   private boolean[] BC000S6_n148WWPUserExtendedDeletedIn ;
   private String[] BC000S7_A32WWPUserExtendedId ;
   private boolean[] BC000S7_n32WWPUserExtendedId ;
   private String[] BC000S7_A140WWPUserExtendedPhoto ;
   private String[] BC000S7_A40000WWPUserExtendedPhoto_GXI ;
   private String[] BC000S7_A146WWPUserExtendedName ;
   private String[] BC000S7_A138WWPUserExtendedFullName ;
   private String[] BC000S7_A145WWPUserExtendedPhone ;
   private String[] BC000S7_A139WWPUserExtendedEmail ;
   private boolean[] BC000S7_A141WWPUserExtendedEmaiNotif ;
   private boolean[] BC000S7_A142WWPUserExtendedSMSNotif ;
   private boolean[] BC000S7_A143WWPUserExtendedMobileNotif ;
   private boolean[] BC000S7_A144WWPUserExtendedDesktopNotif ;
   private boolean[] BC000S7_A147WWPUserExtendedDeleted ;
   private java.util.Date[] BC000S7_A148WWPUserExtendedDeletedIn ;
   private boolean[] BC000S7_n148WWPUserExtendedDeletedIn ;
   private long[] BC000S12_A37WWPNotificationId ;
   private String[] BC000S13_A39WWPWebClientId ;
   private long[] BC000S14_A34WWPSubscriptionId ;
   private String[] BC000S15_A32WWPUserExtendedId ;
   private boolean[] BC000S15_n32WWPUserExtendedId ;
   private String[] BC000S15_A140WWPUserExtendedPhoto ;
   private String[] BC000S15_A40000WWPUserExtendedPhoto_GXI ;
   private String[] BC000S15_A146WWPUserExtendedName ;
   private String[] BC000S15_A138WWPUserExtendedFullName ;
   private String[] BC000S15_A145WWPUserExtendedPhone ;
   private String[] BC000S15_A139WWPUserExtendedEmail ;
   private boolean[] BC000S15_A141WWPUserExtendedEmaiNotif ;
   private boolean[] BC000S15_A142WWPUserExtendedSMSNotif ;
   private boolean[] BC000S15_A143WWPUserExtendedMobileNotif ;
   private boolean[] BC000S15_A144WWPUserExtendedDesktopNotif ;
   private boolean[] BC000S15_A147WWPUserExtendedDeleted ;
   private java.util.Date[] BC000S15_A148WWPUserExtendedDeletedIn ;
   private boolean[] BC000S15_n148WWPUserExtendedDeletedIn ;
   private IDataStoreProvider pr_gam ;
   private String[] BC000S2_A32WWPUserExtendedId ;
   private String[] BC000S2_A140WWPUserExtendedPhoto ;
   private String[] BC000S2_A40000WWPUserExtendedPhoto_GXI ;
   private String[] BC000S2_A146WWPUserExtendedName ;
   private String[] BC000S2_A138WWPUserExtendedFullName ;
   private String[] BC000S2_A145WWPUserExtendedPhone ;
   private String[] BC000S2_A139WWPUserExtendedEmail ;
   private boolean[] BC000S2_A141WWPUserExtendedEmaiNotif ;
   private boolean[] BC000S2_A142WWPUserExtendedSMSNotif ;
   private boolean[] BC000S2_A143WWPUserExtendedMobileNotif ;
   private boolean[] BC000S2_A144WWPUserExtendedDesktopNotif ;
   private boolean[] BC000S2_A147WWPUserExtendedDeleted ;
   private java.util.Date[] BC000S2_A148WWPUserExtendedDeletedIn ;
   private String[] BC000S3_A32WWPUserExtendedId ;
   private String[] BC000S3_A140WWPUserExtendedPhoto ;
   private String[] BC000S3_A40000WWPUserExtendedPhoto_GXI ;
   private String[] BC000S3_A146WWPUserExtendedName ;
   private String[] BC000S3_A138WWPUserExtendedFullName ;
   private String[] BC000S3_A145WWPUserExtendedPhone ;
   private String[] BC000S3_A139WWPUserExtendedEmail ;
   private boolean[] BC000S3_A141WWPUserExtendedEmaiNotif ;
   private boolean[] BC000S3_A142WWPUserExtendedSMSNotif ;
   private boolean[] BC000S3_A143WWPUserExtendedMobileNotif ;
   private boolean[] BC000S3_A144WWPUserExtendedDesktopNotif ;
   private boolean[] BC000S3_A147WWPUserExtendedDeleted ;
   private java.util.Date[] BC000S3_A148WWPUserExtendedDeletedIn ;
   private boolean[] BC000S2_n148WWPUserExtendedDeletedIn ;
   private boolean[] BC000S3_n148WWPUserExtendedDeletedIn ;
}

final  class wwp_userextended_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_userextended_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000S2", "SELECT [WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] WITH (UPDLOCK) WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S3", "SELECT [WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S4", "SELECT TM1.[WWPUserExtendedId], TM1.[WWPUserExtendedPhoto], TM1.[WWPUserExtendedPhoto_GXI], TM1.[WWPUserExtendedName], TM1.[WWPUserExtendedFullName], TM1.[WWPUserExtendedPhone], TM1.[WWPUserExtendedEmail], TM1.[WWPUserExtendedEmaiNotif], TM1.[WWPUserExtendedSMSNotif], TM1.[WWPUserExtendedMobileNotif], TM1.[WWPUserExtendedDesktopNotif], TM1.[WWPUserExtendedDeleted], TM1.[WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] TM1 WHERE TM1.[WWPUserExtendedId] = ? ORDER BY TM1.[WWPUserExtendedId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S5", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S6", "SELECT [WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000S7", "SELECT [WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] WITH (UPDLOCK) WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000S8", "INSERT INTO [WWP_UserExtended]([WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000S9", "UPDATE [WWP_UserExtended] SET [WWPUserExtendedName]=?, [WWPUserExtendedFullName]=?, [WWPUserExtendedPhone]=?, [WWPUserExtendedEmail]=?, [WWPUserExtendedEmaiNotif]=?, [WWPUserExtendedSMSNotif]=?, [WWPUserExtendedMobileNotif]=?, [WWPUserExtendedDesktopNotif]=?, [WWPUserExtendedDeleted]=?, [WWPUserExtendedDeletedIn]=?  WHERE [WWPUserExtendedId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000S10", "UPDATE [WWP_UserExtended] SET [WWPUserExtendedPhoto]=?, [WWPUserExtendedPhoto_GXI]=?  WHERE [WWPUserExtendedId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000S11", "DELETE FROM [WWP_UserExtended]  WHERE [WWPUserExtendedId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000S12", "SELECT TOP 1 [WWPNotificationId] FROM [WWP_Notification] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000S13", "SELECT TOP 1 [WWPWebClientId] FROM [WWP_WebClient] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000S14", "SELECT TOP 1 [WWPSubscriptionId] FROM [WWP_Subscription] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000S15", "SELECT TM1.[WWPUserExtendedId], TM1.[WWPUserExtendedPhoto], TM1.[WWPUserExtendedPhoto_GXI], TM1.[WWPUserExtendedName], TM1.[WWPUserExtendedFullName], TM1.[WWPUserExtendedPhone], TM1.[WWPUserExtendedEmail], TM1.[WWPUserExtendedEmaiNotif], TM1.[WWPUserExtendedSMSNotif], TM1.[WWPUserExtendedMobileNotif], TM1.[WWPUserExtendedDesktopNotif], TM1.[WWPUserExtendedDeleted], TM1.[WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] TM1 WHERE TM1.[WWPUserExtendedId] = ? ORDER BY TM1.[WWPUserExtendedId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
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
               stmt.setBLOBFile(2, (String)parms[2], true);
               stmt.setGXDbFileURI(3, (String)parms[3], (String)parms[2], 2048,"WWP_UserExtended","WWPUserExtendedPhoto");
               stmt.setVarchar(4, (String)parms[4], 100, false);
               stmt.setVarchar(5, (String)parms[5], 100, false);
               stmt.setString(6, (String)parms[6], 20);
               stmt.setVarchar(7, (String)parms[7], 100, false);
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[11]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[12]).booleanValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(13, (java.util.Date)parms[14], false);
               }
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(10, (java.util.Date)parms[10], false);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[12], 40);
               }
               return;
            case 8 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"WWP_UserExtended","WWPUserExtendedPhoto");
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
      }
   }

}

