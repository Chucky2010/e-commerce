package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_webclient_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_webclient_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_webclient_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_webclient_bc.class ));
   }

   public wwp_webclient_bc( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0X35( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0X35( ) ;
      standaloneModal( ) ;
      addRow0X35( ) ;
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
            Z39WWPWebClientId = A39WWPWebClientId ;
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

   public void confirm_0X0( )
   {
      beforeValidate0X35( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0X35( ) ;
         }
         else
         {
            checkExtendedTable0X35( ) ;
            if ( AnyError == 0 )
            {
               zm0X35( 7) ;
            }
            closeExtendedTableCursors0X35( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0X35( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z171WWPWebClientBrowserId = A171WWPWebClientBrowserId ;
         Z173WWPWebClientFirstRegistered = A173WWPWebClientFirstRegistered ;
         Z174WWPWebClientLastRegistered = A174WWPWebClientLastRegistered ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -6 )
      {
         Z39WWPWebClientId = A39WWPWebClientId ;
         Z171WWPWebClientBrowserId = A171WWPWebClientBrowserId ;
         Z172WWPWebClientBrowserVersion = A172WWPWebClientBrowserVersion ;
         Z173WWPWebClientFirstRegistered = A173WWPWebClientFirstRegistered ;
         Z174WWPWebClientLastRegistered = A174WWPWebClientLastRegistered ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A173WWPWebClientFirstRegistered) && ( Gx_BScreen == 0 ) )
      {
         A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A174WWPWebClientLastRegistered) && ( Gx_BScreen == 0 ) )
      {
         A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0X35( )
   {
      /* Using cursor BC000X5 */
      pr_default.execute(3, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A171WWPWebClientBrowserId = BC000X5_A171WWPWebClientBrowserId[0] ;
         A172WWPWebClientBrowserVersion = BC000X5_A172WWPWebClientBrowserVersion[0] ;
         A173WWPWebClientFirstRegistered = BC000X5_A173WWPWebClientFirstRegistered[0] ;
         A174WWPWebClientLastRegistered = BC000X5_A174WWPWebClientLastRegistered[0] ;
         A32WWPUserExtendedId = BC000X5_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000X5_n32WWPUserExtendedId[0] ;
         zm0X35( -6) ;
      }
      pr_default.close(3);
      onLoadActions0X35( ) ;
   }

   public void onLoadActions0X35( )
   {
   }

   public void checkExtendedTable0X35( )
   {
      nIsDirty_35 = (short)(0) ;
      standaloneModal( ) ;
      if ( ! ( ( A171WWPWebClientBrowserId == 0 ) || ( A171WWPWebClientBrowserId == 1 ) || ( A171WWPWebClientBrowserId == 2 ) || ( A171WWPWebClientBrowserId == 3 ) || ( A171WWPWebClientBrowserId == 5 ) || ( A171WWPWebClientBrowserId == 6 ) || ( A171WWPWebClientBrowserId == 7 ) || ( A171WWPWebClientBrowserId == 8 ) || ( A171WWPWebClientBrowserId == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Client Browser Id", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A173WWPWebClientFirstRegistered) || (( A173WWPWebClientFirstRegistered.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A173WWPWebClientFirstRegistered, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Client First Registered", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A174WWPWebClientLastRegistered) || (( A174WWPWebClientLastRegistered.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A174WWPWebClientLastRegistered, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Client Last Registered", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC000X6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors0X35( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0X35( )
   {
      /* Using cursor BC000X7 */
      pr_default.execute(5, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound35 = (short)(1) ;
      }
      else
      {
         RcdFound35 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000X8 */
      pr_default.execute(6, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0X35( 6) ;
         RcdFound35 = (short)(1) ;
         A39WWPWebClientId = BC000X8_A39WWPWebClientId[0] ;
         A171WWPWebClientBrowserId = BC000X8_A171WWPWebClientBrowserId[0] ;
         A172WWPWebClientBrowserVersion = BC000X8_A172WWPWebClientBrowserVersion[0] ;
         A173WWPWebClientFirstRegistered = BC000X8_A173WWPWebClientFirstRegistered[0] ;
         A174WWPWebClientLastRegistered = BC000X8_A174WWPWebClientLastRegistered[0] ;
         A32WWPUserExtendedId = BC000X8_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000X8_n32WWPUserExtendedId[0] ;
         Z39WWPWebClientId = A39WWPWebClientId ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0X35( ) ;
         if ( AnyError == 1 )
         {
            RcdFound35 = (short)(0) ;
            initializeNonKey0X35( ) ;
         }
         Gx_mode = sMode35 ;
      }
      else
      {
         RcdFound35 = (short)(0) ;
         initializeNonKey0X35( ) ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode35 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0X35( ) ;
      if ( RcdFound35 == 0 )
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
      confirm_0X0( ) ;
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

   public void checkOptimisticConcurrency0X35( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000X9 */
         pr_default.execute(7, new Object[] {A39WWPWebClientId});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebClient"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( Z171WWPWebClientBrowserId != BC000X9_A171WWPWebClientBrowserId[0] ) || !( GXutil.dateCompare(Z173WWPWebClientFirstRegistered, BC000X9_A173WWPWebClientFirstRegistered[0]) ) || !( GXutil.dateCompare(Z174WWPWebClientLastRegistered, BC000X9_A174WWPWebClientLastRegistered[0]) ) || ( GXutil.strcmp(Z32WWPUserExtendedId, BC000X9_A32WWPUserExtendedId[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_WebClient"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0X35( )
   {
      beforeValidate0X35( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0X35( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0X35( 0) ;
         checkOptimisticConcurrency0X35( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0X35( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0X35( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000X10 */
                  pr_default.execute(8, new Object[] {A39WWPWebClientId, Short.valueOf(A171WWPWebClientBrowserId), A172WWPWebClientBrowserVersion, A173WWPWebClientFirstRegistered, A174WWPWebClientLastRegistered, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebClient");
                  if ( (pr_default.getStatus(8) == 1) )
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
            load0X35( ) ;
         }
         endLevel0X35( ) ;
      }
      closeExtendedTableCursors0X35( ) ;
   }

   public void update0X35( )
   {
      beforeValidate0X35( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0X35( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0X35( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0X35( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0X35( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000X11 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A171WWPWebClientBrowserId), A172WWPWebClientBrowserVersion, A173WWPWebClientFirstRegistered, A174WWPWebClientLastRegistered, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, A39WWPWebClientId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebClient");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebClient"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0X35( ) ;
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
         endLevel0X35( ) ;
      }
      closeExtendedTableCursors0X35( ) ;
   }

   public void deferredUpdate0X35( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0X35( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0X35( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0X35( ) ;
         afterConfirm0X35( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0X35( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000X12 */
               pr_default.execute(10, new Object[] {A39WWPWebClientId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebClient");
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
      sMode35 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0X35( ) ;
      Gx_mode = sMode35 ;
   }

   public void onDeleteControls0X35( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0X35( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0X35( ) ;
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

   public void scanKeyStart0X35( )
   {
      /* Using cursor BC000X13 */
      pr_default.execute(11, new Object[] {A39WWPWebClientId});
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A39WWPWebClientId = BC000X13_A39WWPWebClientId[0] ;
         A171WWPWebClientBrowserId = BC000X13_A171WWPWebClientBrowserId[0] ;
         A172WWPWebClientBrowserVersion = BC000X13_A172WWPWebClientBrowserVersion[0] ;
         A173WWPWebClientFirstRegistered = BC000X13_A173WWPWebClientFirstRegistered[0] ;
         A174WWPWebClientLastRegistered = BC000X13_A174WWPWebClientLastRegistered[0] ;
         A32WWPUserExtendedId = BC000X13_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000X13_n32WWPUserExtendedId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0X35( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound35 = (short)(0) ;
      scanKeyLoad0X35( ) ;
   }

   public void scanKeyLoad0X35( )
   {
      sMode35 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A39WWPWebClientId = BC000X13_A39WWPWebClientId[0] ;
         A171WWPWebClientBrowserId = BC000X13_A171WWPWebClientBrowserId[0] ;
         A172WWPWebClientBrowserVersion = BC000X13_A172WWPWebClientBrowserVersion[0] ;
         A173WWPWebClientFirstRegistered = BC000X13_A173WWPWebClientFirstRegistered[0] ;
         A174WWPWebClientLastRegistered = BC000X13_A174WWPWebClientLastRegistered[0] ;
         A32WWPUserExtendedId = BC000X13_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = BC000X13_n32WWPUserExtendedId[0] ;
      }
      Gx_mode = sMode35 ;
   }

   public void scanKeyEnd0X35( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0X35( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0X35( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0X35( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0X35( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0X35( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0X35( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0X35( )
   {
   }

   public void send_integrity_lvl_hashes0X35( )
   {
   }

   public void addRow0X35( )
   {
      VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
   }

   public void readRow0X35( )
   {
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
   }

   public void initializeNonKey0X35( )
   {
      A171WWPWebClientBrowserId = (short)(0) ;
      A172WWPWebClientBrowserVersion = "" ;
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z171WWPWebClientBrowserId = (short)(0) ;
      Z173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z32WWPUserExtendedId = "" ;
   }

   public void initAll0X35( )
   {
      A39WWPWebClientId = "" ;
      initializeNonKey0X35( ) ;
   }

   public void standaloneModalInsert( )
   {
      A173WWPWebClientFirstRegistered = i173WWPWebClientFirstRegistered ;
      A174WWPWebClientLastRegistered = i174WWPWebClientLastRegistered ;
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

   public void VarsToRow35( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient obj35 )
   {
      obj35.setgxTv_SdtWWP_WebClient_Mode( Gx_mode );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid( A171WWPWebClientBrowserId );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion( A172WWPWebClientBrowserVersion );
      obj35.setgxTv_SdtWWP_WebClient_Wwpuserextendedid( A32WWPUserExtendedId );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered( A173WWPWebClientFirstRegistered );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered( A174WWPWebClientLastRegistered );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientid( A39WWPWebClientId );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientid_Z( Z39WWPWebClientId );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z( Z171WWPWebClientBrowserId );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z( Z173WWPWebClientFirstRegistered );
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z( Z174WWPWebClientLastRegistered );
      obj35.setgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z( Z32WWPUserExtendedId );
      obj35.setgxTv_SdtWWP_WebClient_Wwpuserextendedid_N( (byte)((byte)((n32WWPUserExtendedId)?1:0)) );
      obj35.setgxTv_SdtWWP_WebClient_Mode( Gx_mode );
   }

   public void KeyVarsToRow35( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient obj35 )
   {
      obj35.setgxTv_SdtWWP_WebClient_Wwpwebclientid( A39WWPWebClientId );
   }

   public void RowToVars35( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient obj35 ,
                            int forceLoad )
   {
      Gx_mode = obj35.getgxTv_SdtWWP_WebClient_Mode() ;
      A171WWPWebClientBrowserId = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid() ;
      A172WWPWebClientBrowserVersion = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserversion() ;
      A32WWPUserExtendedId = obj35.getgxTv_SdtWWP_WebClient_Wwpuserextendedid() ;
      n32WWPUserExtendedId = false ;
      A173WWPWebClientFirstRegistered = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered() ;
      A174WWPWebClientLastRegistered = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered() ;
      A39WWPWebClientId = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientid() ;
      Z39WWPWebClientId = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientid_Z() ;
      Z171WWPWebClientBrowserId = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientbrowserid_Z() ;
      Z173WWPWebClientFirstRegistered = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientfirstregistered_Z() ;
      Z174WWPWebClientLastRegistered = obj35.getgxTv_SdtWWP_WebClient_Wwpwebclientlastregistered_Z() ;
      Z32WWPUserExtendedId = obj35.getgxTv_SdtWWP_WebClient_Wwpuserextendedid_Z() ;
      n32WWPUserExtendedId = (boolean)((obj35.getgxTv_SdtWWP_WebClient_Wwpuserextendedid_N()==0)?false:true) ;
      Gx_mode = obj35.getgxTv_SdtWWP_WebClient_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A39WWPWebClientId = (String)getParm(obj,0) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0X35( ) ;
      scanKeyStart0X35( ) ;
      if ( RcdFound35 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z39WWPWebClientId = A39WWPWebClientId ;
      }
      zm0X35( -6) ;
      onLoadActions0X35( ) ;
      addRow0X35( ) ;
      scanKeyEnd0X35( ) ;
      if ( RcdFound35 == 0 )
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
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 0) ;
      scanKeyStart0X35( ) ;
      if ( RcdFound35 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z39WWPWebClientId = A39WWPWebClientId ;
      }
      zm0X35( -6) ;
      onLoadActions0X35( ) ;
      addRow0X35( ) ;
      scanKeyEnd0X35( ) ;
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0X35( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0X35( ) ;
      }
      else
      {
         if ( RcdFound35 == 1 )
         {
            if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
            {
               A39WWPWebClientId = Z39WWPWebClientId ;
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
               update0X35( ) ;
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
               if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
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
                     insert0X35( ) ;
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
                     insert0X35( ) ;
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
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
      saveImpl( ) ;
      VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0X35( ) ;
      afterTrn( ) ;
      VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
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
         com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient auxBC = new com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A39WWPWebClientId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_notifications_web_WWP_WebClient);
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
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
      updateImpl( ) ;
      VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
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
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0X35( ) ;
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
      VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0X35( ) ;
      if ( RcdFound35 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
         {
            A39WWPWebClientId = Z39WWPWebClientId ;
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
         if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
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
      pr_default.close(2);
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_webclient_bc");
      VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
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
      Gx_mode = bcwwpbaseobjects_notifications_web_WWP_WebClient.getgxTv_SdtWWP_WebClient_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_notifications_web_WWP_WebClient.setgxTv_SdtWWP_WebClient_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_notifications_web_WWP_WebClient )
      {
         bcwwpbaseobjects_notifications_web_WWP_WebClient = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_web_WWP_WebClient.getgxTv_SdtWWP_WebClient_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_web_WWP_WebClient.setgxTv_SdtWWP_WebClient_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow35( bcwwpbaseobjects_notifications_web_WWP_WebClient) ;
         }
         else
         {
            RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_notifications_web_WWP_WebClient.getgxTv_SdtWWP_WebClient_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_notifications_web_WWP_WebClient.setgxTv_SdtWWP_WebClient_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars35( bcwwpbaseobjects_notifications_web_WWP_WebClient, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_WebClient getWWP_WebClient_BC( )
   {
      return bcwwpbaseobjects_notifications_web_WWP_WebClient ;
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
      Z39WWPWebClientId = "" ;
      A39WWPWebClientId = "" ;
      Z173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      A173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      A174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z32WWPUserExtendedId = "" ;
      A32WWPUserExtendedId = "" ;
      Z172WWPWebClientBrowserVersion = "" ;
      A172WWPWebClientBrowserVersion = "" ;
      BC000X5_A39WWPWebClientId = new String[] {""} ;
      BC000X5_A171WWPWebClientBrowserId = new short[1] ;
      BC000X5_A172WWPWebClientBrowserVersion = new String[] {""} ;
      BC000X5_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X5_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X5_A32WWPUserExtendedId = new String[] {""} ;
      BC000X5_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000X6_A32WWPUserExtendedId = new String[] {""} ;
      BC000X6_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000X7_A39WWPWebClientId = new String[] {""} ;
      BC000X8_A39WWPWebClientId = new String[] {""} ;
      BC000X8_A171WWPWebClientBrowserId = new short[1] ;
      BC000X8_A172WWPWebClientBrowserVersion = new String[] {""} ;
      BC000X8_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X8_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X8_A32WWPUserExtendedId = new String[] {""} ;
      BC000X8_n32WWPUserExtendedId = new boolean[] {false} ;
      sMode35 = "" ;
      BC000X9_A39WWPWebClientId = new String[] {""} ;
      BC000X9_A171WWPWebClientBrowserId = new short[1] ;
      BC000X9_A172WWPWebClientBrowserVersion = new String[] {""} ;
      BC000X9_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X9_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X9_A32WWPUserExtendedId = new String[] {""} ;
      BC000X9_n32WWPUserExtendedId = new boolean[] {false} ;
      BC000X13_A39WWPWebClientId = new String[] {""} ;
      BC000X13_A171WWPWebClientBrowserId = new short[1] ;
      BC000X13_A172WWPWebClientBrowserVersion = new String[] {""} ;
      BC000X13_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X13_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      BC000X13_A32WWPUserExtendedId = new String[] {""} ;
      BC000X13_n32WWPUserExtendedId = new boolean[] {false} ;
      i173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      i174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient_bc__default(),
         new Object[] {
             new Object[] {
            BC000X2_A39WWPWebClientId, BC000X2_A171WWPWebClientBrowserId, BC000X2_A172WWPWebClientBrowserVersion, BC000X2_A173WWPWebClientFirstRegistered, BC000X2_A174WWPWebClientLastRegistered, BC000X2_A32WWPUserExtendedId, BC000X2_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000X3_A39WWPWebClientId, BC000X3_A171WWPWebClientBrowserId, BC000X3_A172WWPWebClientBrowserVersion, BC000X3_A173WWPWebClientFirstRegistered, BC000X3_A174WWPWebClientLastRegistered, BC000X3_A32WWPUserExtendedId, BC000X3_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000X4_A32WWPUserExtendedId
            }
            , new Object[] {
            BC000X5_A39WWPWebClientId, BC000X5_A171WWPWebClientBrowserId, BC000X5_A172WWPWebClientBrowserVersion, BC000X5_A173WWPWebClientFirstRegistered, BC000X5_A174WWPWebClientLastRegistered, BC000X5_A32WWPUserExtendedId, BC000X5_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000X6_A32WWPUserExtendedId
            }
            , new Object[] {
            BC000X7_A39WWPWebClientId
            }
            , new Object[] {
            BC000X8_A39WWPWebClientId, BC000X8_A171WWPWebClientBrowserId, BC000X8_A172WWPWebClientBrowserVersion, BC000X8_A173WWPWebClientFirstRegistered, BC000X8_A174WWPWebClientLastRegistered, BC000X8_A32WWPUserExtendedId, BC000X8_n32WWPUserExtendedId
            }
            , new Object[] {
            BC000X9_A39WWPWebClientId, BC000X9_A171WWPWebClientBrowserId, BC000X9_A172WWPWebClientBrowserVersion, BC000X9_A173WWPWebClientFirstRegistered, BC000X9_A174WWPWebClientLastRegistered, BC000X9_A32WWPUserExtendedId, BC000X9_n32WWPUserExtendedId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000X13_A39WWPWebClientId, BC000X13_A171WWPWebClientBrowserId, BC000X13_A172WWPWebClientBrowserVersion, BC000X13_A173WWPWebClientFirstRegistered, BC000X13_A174WWPWebClientLastRegistered, BC000X13_A32WWPUserExtendedId, BC000X13_n32WWPUserExtendedId
            }
         }
      );
      Z174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z171WWPWebClientBrowserId ;
   private short A171WWPWebClientBrowserId ;
   private short RcdFound35 ;
   private short nIsDirty_35 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z39WWPWebClientId ;
   private String A39WWPWebClientId ;
   private String Z32WWPUserExtendedId ;
   private String A32WWPUserExtendedId ;
   private String sMode35 ;
   private java.util.Date Z173WWPWebClientFirstRegistered ;
   private java.util.Date A173WWPWebClientFirstRegistered ;
   private java.util.Date Z174WWPWebClientLastRegistered ;
   private java.util.Date A174WWPWebClientLastRegistered ;
   private java.util.Date i173WWPWebClientFirstRegistered ;
   private java.util.Date i174WWPWebClientLastRegistered ;
   private boolean n32WWPUserExtendedId ;
   private boolean mustCommit ;
   private String Z172WWPWebClientBrowserVersion ;
   private String A172WWPWebClientBrowserVersion ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient bcwwpbaseobjects_notifications_web_WWP_WebClient ;
   private IDataStoreProvider pr_default ;
   private String[] BC000X5_A39WWPWebClientId ;
   private short[] BC000X5_A171WWPWebClientBrowserId ;
   private String[] BC000X5_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] BC000X5_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] BC000X5_A174WWPWebClientLastRegistered ;
   private String[] BC000X5_A32WWPUserExtendedId ;
   private boolean[] BC000X5_n32WWPUserExtendedId ;
   private String[] BC000X6_A32WWPUserExtendedId ;
   private boolean[] BC000X6_n32WWPUserExtendedId ;
   private String[] BC000X7_A39WWPWebClientId ;
   private String[] BC000X8_A39WWPWebClientId ;
   private short[] BC000X8_A171WWPWebClientBrowserId ;
   private String[] BC000X8_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] BC000X8_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] BC000X8_A174WWPWebClientLastRegistered ;
   private String[] BC000X8_A32WWPUserExtendedId ;
   private boolean[] BC000X8_n32WWPUserExtendedId ;
   private String[] BC000X9_A39WWPWebClientId ;
   private short[] BC000X9_A171WWPWebClientBrowserId ;
   private String[] BC000X9_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] BC000X9_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] BC000X9_A174WWPWebClientLastRegistered ;
   private String[] BC000X9_A32WWPUserExtendedId ;
   private boolean[] BC000X9_n32WWPUserExtendedId ;
   private String[] BC000X13_A39WWPWebClientId ;
   private short[] BC000X13_A171WWPWebClientBrowserId ;
   private String[] BC000X13_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] BC000X13_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] BC000X13_A174WWPWebClientLastRegistered ;
   private String[] BC000X13_A32WWPUserExtendedId ;
   private boolean[] BC000X13_n32WWPUserExtendedId ;
   private IDataStoreProvider pr_gam ;
   private String[] BC000X2_A39WWPWebClientId ;
   private short[] BC000X2_A171WWPWebClientBrowserId ;
   private String[] BC000X2_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] BC000X2_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] BC000X2_A174WWPWebClientLastRegistered ;
   private String[] BC000X2_A32WWPUserExtendedId ;
   private String[] BC000X3_A39WWPWebClientId ;
   private short[] BC000X3_A171WWPWebClientBrowserId ;
   private String[] BC000X3_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] BC000X3_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] BC000X3_A174WWPWebClientLastRegistered ;
   private String[] BC000X3_A32WWPUserExtendedId ;
   private String[] BC000X4_A32WWPUserExtendedId ;
   private boolean[] BC000X2_n32WWPUserExtendedId ;
   private boolean[] BC000X3_n32WWPUserExtendedId ;
}

final  class wwp_webclient_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_webclient_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000X2", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WITH (UPDLOCK) WHERE [WWPWebClientId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X3", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WHERE [WWPWebClientId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X4", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X5", "SELECT TM1.[WWPWebClientId], TM1.[WWPWebClientBrowserId], TM1.[WWPWebClientBrowserVersion], TM1.[WWPWebClientFirstRegistered], TM1.[WWPWebClientLastRegistered], TM1.[WWPUserExtendedId] FROM [WWP_WebClient] TM1 WHERE TM1.[WWPWebClientId] = ? ORDER BY TM1.[WWPWebClientId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X6", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X7", "SELECT [WWPWebClientId] FROM [WWP_WebClient] WHERE [WWPWebClientId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X8", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WHERE [WWPWebClientId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000X9", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WITH (UPDLOCK) WHERE [WWPWebClientId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000X10", "INSERT INTO [WWP_WebClient]([WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC000X11", "UPDATE [WWP_WebClient] SET [WWPWebClientBrowserId]=?, [WWPWebClientBrowserVersion]=?, [WWPWebClientFirstRegistered]=?, [WWPWebClientLastRegistered]=?, [WWPUserExtendedId]=?  WHERE [WWPWebClientId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000X12", "DELETE FROM [WWP_WebClient]  WHERE [WWPWebClientId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000X13", "SELECT TM1.[WWPWebClientId], TM1.[WWPWebClientBrowserId], TM1.[WWPWebClientBrowserVersion], TM1.[WWPWebClientFirstRegistered], TM1.[WWPWebClientLastRegistered], TM1.[WWPUserExtendedId] FROM [WWP_WebClient] TM1 WHERE TM1.[WWPWebClientId] = ? ORDER BY TM1.[WWPWebClientId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5, true);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5, true);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5, true);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5, true);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5, true);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5, true);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               stmt.setString(1, (String)parms[0], 100);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 100);
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
               stmt.setString(1, (String)parms[0], 100);
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
               stmt.setString(1, (String)parms[0], 100);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 100);
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 100);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 100);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setDateTime(4, (java.util.Date)parms[3], false, true);
               stmt.setDateTime(5, (java.util.Date)parms[4], false, true);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 40);
               }
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setDateTime(3, (java.util.Date)parms[2], false, true);
               stmt.setDateTime(4, (java.util.Date)parms[3], false, true);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 40);
               }
               stmt.setString(6, (String)parms[6], 100);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 100);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 100);
               return;
      }
   }

}

