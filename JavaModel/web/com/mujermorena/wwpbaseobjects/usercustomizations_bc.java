package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class usercustomizations_bc extends GXWebPanel implements IGxSilentTrn
{
   public usercustomizations_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public usercustomizations_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( usercustomizations_bc.class ));
   }

   public usercustomizations_bc( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1241( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1241( ) ;
      standaloneModal( ) ;
      addRow1241( ) ;
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
            Z44UserCustomizationsId = A44UserCustomizationsId ;
            Z45UserCustomizationsKey = A45UserCustomizationsKey ;
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

   public void confirm_120( )
   {
      beforeValidate1241( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1241( ) ;
         }
         else
         {
            checkExtendedTable1241( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors1241( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm1241( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -1 )
      {
         Z44UserCustomizationsId = A44UserCustomizationsId ;
         Z45UserCustomizationsKey = A45UserCustomizationsKey ;
         Z213UserCustomizationsValue = A213UserCustomizationsValue ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1241( )
   {
      /* Using cursor BC00124 */
      pr_default.execute(2, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound41 = (short)(1) ;
         A213UserCustomizationsValue = BC00124_A213UserCustomizationsValue[0] ;
         zm1241( -1) ;
      }
      pr_default.close(2);
      onLoadActions1241( ) ;
   }

   public void onLoadActions1241( )
   {
   }

   public void checkExtendedTable1241( )
   {
      nIsDirty_41 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors1241( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1241( )
   {
      /* Using cursor BC00125 */
      pr_default.execute(3, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound41 = (short)(1) ;
      }
      else
      {
         RcdFound41 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00126 */
      pr_default.execute(4, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm1241( 1) ;
         RcdFound41 = (short)(1) ;
         A44UserCustomizationsId = BC00126_A44UserCustomizationsId[0] ;
         A45UserCustomizationsKey = BC00126_A45UserCustomizationsKey[0] ;
         A213UserCustomizationsValue = BC00126_A213UserCustomizationsValue[0] ;
         Z44UserCustomizationsId = A44UserCustomizationsId ;
         Z45UserCustomizationsKey = A45UserCustomizationsKey ;
         sMode41 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1241( ) ;
         if ( AnyError == 1 )
         {
            RcdFound41 = (short)(0) ;
            initializeNonKey1241( ) ;
         }
         Gx_mode = sMode41 ;
      }
      else
      {
         RcdFound41 = (short)(0) ;
         initializeNonKey1241( ) ;
         sMode41 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode41 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey1241( ) ;
      if ( RcdFound41 == 0 )
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
      confirm_120( ) ;
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

   public void checkOptimisticConcurrency1241( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00127 */
         pr_default.execute(5, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"UserCustomizations"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"UserCustomizations"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1241( )
   {
      beforeValidate1241( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1241( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1241( 0) ;
         checkOptimisticConcurrency1241( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1241( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1241( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00128 */
                  pr_default.execute(6, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey, A213UserCustomizationsValue});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustomizations");
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
            load1241( ) ;
         }
         endLevel1241( ) ;
      }
      closeExtendedTableCursors1241( ) ;
   }

   public void update1241( )
   {
      beforeValidate1241( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1241( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1241( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1241( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1241( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00129 */
                  pr_default.execute(7, new Object[] {A213UserCustomizationsValue, A44UserCustomizationsId, A45UserCustomizationsKey});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustomizations");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"UserCustomizations"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1241( ) ;
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
         endLevel1241( ) ;
      }
      closeExtendedTableCursors1241( ) ;
   }

   public void deferredUpdate1241( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1241( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1241( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1241( ) ;
         afterConfirm1241( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1241( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001210 */
               pr_default.execute(8, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustomizations");
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
      sMode41 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1241( ) ;
      Gx_mode = sMode41 ;
   }

   public void onDeleteControls1241( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1241( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1241( ) ;
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

   public void scanKeyStart1241( )
   {
      /* Using cursor BC001211 */
      pr_default.execute(9, new Object[] {A44UserCustomizationsId, A45UserCustomizationsKey});
      RcdFound41 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound41 = (short)(1) ;
         A44UserCustomizationsId = BC001211_A44UserCustomizationsId[0] ;
         A45UserCustomizationsKey = BC001211_A45UserCustomizationsKey[0] ;
         A213UserCustomizationsValue = BC001211_A213UserCustomizationsValue[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1241( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound41 = (short)(0) ;
      scanKeyLoad1241( ) ;
   }

   public void scanKeyLoad1241( )
   {
      sMode41 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound41 = (short)(1) ;
         A44UserCustomizationsId = BC001211_A44UserCustomizationsId[0] ;
         A45UserCustomizationsKey = BC001211_A45UserCustomizationsKey[0] ;
         A213UserCustomizationsValue = BC001211_A213UserCustomizationsValue[0] ;
      }
      Gx_mode = sMode41 ;
   }

   public void scanKeyEnd1241( )
   {
      pr_default.close(9);
   }

   public void afterConfirm1241( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1241( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1241( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1241( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1241( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1241( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1241( )
   {
   }

   public void send_integrity_lvl_hashes1241( )
   {
   }

   public void addRow1241( )
   {
      VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
   }

   public void readRow1241( )
   {
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
   }

   public void initializeNonKey1241( )
   {
      A213UserCustomizationsValue = "" ;
   }

   public void initAll1241( )
   {
      A44UserCustomizationsId = "" ;
      A45UserCustomizationsKey = "" ;
      initializeNonKey1241( ) ;
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

   public void VarsToRow41( com.mujermorena.wwpbaseobjects.SdtUserCustomizations obj41 )
   {
      obj41.setgxTv_SdtUserCustomizations_Mode( Gx_mode );
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationsvalue( A213UserCustomizationsValue );
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationsid( A44UserCustomizationsId );
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationskey( A45UserCustomizationsKey );
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationsid_Z( Z44UserCustomizationsId );
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationskey_Z( Z45UserCustomizationsKey );
      obj41.setgxTv_SdtUserCustomizations_Mode( Gx_mode );
   }

   public void KeyVarsToRow41( com.mujermorena.wwpbaseobjects.SdtUserCustomizations obj41 )
   {
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationsid( A44UserCustomizationsId );
      obj41.setgxTv_SdtUserCustomizations_Usercustomizationskey( A45UserCustomizationsKey );
   }

   public void RowToVars41( com.mujermorena.wwpbaseobjects.SdtUserCustomizations obj41 ,
                            int forceLoad )
   {
      Gx_mode = obj41.getgxTv_SdtUserCustomizations_Mode() ;
      A213UserCustomizationsValue = obj41.getgxTv_SdtUserCustomizations_Usercustomizationsvalue() ;
      A44UserCustomizationsId = obj41.getgxTv_SdtUserCustomizations_Usercustomizationsid() ;
      A45UserCustomizationsKey = obj41.getgxTv_SdtUserCustomizations_Usercustomizationskey() ;
      Z44UserCustomizationsId = obj41.getgxTv_SdtUserCustomizations_Usercustomizationsid_Z() ;
      Z45UserCustomizationsKey = obj41.getgxTv_SdtUserCustomizations_Usercustomizationskey_Z() ;
      Gx_mode = obj41.getgxTv_SdtUserCustomizations_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A44UserCustomizationsId = (String)getParm(obj,0) ;
      A45UserCustomizationsKey = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1241( ) ;
      scanKeyStart1241( ) ;
      if ( RcdFound41 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z44UserCustomizationsId = A44UserCustomizationsId ;
         Z45UserCustomizationsKey = A45UserCustomizationsKey ;
      }
      zm1241( -1) ;
      onLoadActions1241( ) ;
      addRow1241( ) ;
      scanKeyEnd1241( ) ;
      if ( RcdFound41 == 0 )
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
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 0) ;
      scanKeyStart1241( ) ;
      if ( RcdFound41 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z44UserCustomizationsId = A44UserCustomizationsId ;
         Z45UserCustomizationsKey = A45UserCustomizationsKey ;
      }
      zm1241( -1) ;
      onLoadActions1241( ) ;
      addRow1241( ) ;
      scanKeyEnd1241( ) ;
      if ( RcdFound41 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1241( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1241( ) ;
      }
      else
      {
         if ( RcdFound41 == 1 )
         {
            if ( ( GXutil.strcmp(A44UserCustomizationsId, Z44UserCustomizationsId) != 0 ) || ( GXutil.strcmp(A45UserCustomizationsKey, Z45UserCustomizationsKey) != 0 ) )
            {
               A44UserCustomizationsId = Z44UserCustomizationsId ;
               A45UserCustomizationsKey = Z45UserCustomizationsKey ;
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
               update1241( ) ;
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
               if ( ( GXutil.strcmp(A44UserCustomizationsId, Z44UserCustomizationsId) != 0 ) || ( GXutil.strcmp(A45UserCustomizationsKey, Z45UserCustomizationsKey) != 0 ) )
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
                     insert1241( ) ;
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
                     insert1241( ) ;
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
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
      saveImpl( ) ;
      VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1241( ) ;
      afterTrn( ) ;
      VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
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
         com.mujermorena.wwpbaseobjects.SdtUserCustomizations auxBC = new com.mujermorena.wwpbaseobjects.SdtUserCustomizations( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A44UserCustomizationsId, A45UserCustomizationsKey);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_UserCustomizations);
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
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
      updateImpl( ) ;
      VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
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
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1241( ) ;
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
      VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1241( ) ;
      if ( RcdFound41 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( GXutil.strcmp(A44UserCustomizationsId, Z44UserCustomizationsId) != 0 ) || ( GXutil.strcmp(A45UserCustomizationsKey, Z45UserCustomizationsKey) != 0 ) )
         {
            A44UserCustomizationsId = Z44UserCustomizationsId ;
            A45UserCustomizationsKey = Z45UserCustomizationsKey ;
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
         if ( ( GXutil.strcmp(A44UserCustomizationsId, Z44UserCustomizationsId) != 0 ) || ( GXutil.strcmp(A45UserCustomizationsKey, Z45UserCustomizationsKey) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.usercustomizations_bc");
      VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
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
      Gx_mode = bcwwpbaseobjects_UserCustomizations.getgxTv_SdtUserCustomizations_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_UserCustomizations.setgxTv_SdtUserCustomizations_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.SdtUserCustomizations sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_UserCustomizations )
      {
         bcwwpbaseobjects_UserCustomizations = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_UserCustomizations.getgxTv_SdtUserCustomizations_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_UserCustomizations.setgxTv_SdtUserCustomizations_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow41( bcwwpbaseobjects_UserCustomizations) ;
         }
         else
         {
            RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_UserCustomizations.getgxTv_SdtUserCustomizations_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_UserCustomizations.setgxTv_SdtUserCustomizations_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars41( bcwwpbaseobjects_UserCustomizations, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtUserCustomizations getUserCustomizations_BC( )
   {
      return bcwwpbaseobjects_UserCustomizations ;
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
      Z44UserCustomizationsId = "" ;
      A44UserCustomizationsId = "" ;
      Z45UserCustomizationsKey = "" ;
      A45UserCustomizationsKey = "" ;
      Z213UserCustomizationsValue = "" ;
      A213UserCustomizationsValue = "" ;
      BC00124_A44UserCustomizationsId = new String[] {""} ;
      BC00124_A45UserCustomizationsKey = new String[] {""} ;
      BC00124_A213UserCustomizationsValue = new String[] {""} ;
      BC00125_A44UserCustomizationsId = new String[] {""} ;
      BC00125_A45UserCustomizationsKey = new String[] {""} ;
      BC00126_A44UserCustomizationsId = new String[] {""} ;
      BC00126_A45UserCustomizationsKey = new String[] {""} ;
      BC00126_A213UserCustomizationsValue = new String[] {""} ;
      sMode41 = "" ;
      BC00127_A44UserCustomizationsId = new String[] {""} ;
      BC00127_A45UserCustomizationsKey = new String[] {""} ;
      BC00127_A213UserCustomizationsValue = new String[] {""} ;
      BC001211_A44UserCustomizationsId = new String[] {""} ;
      BC001211_A45UserCustomizationsKey = new String[] {""} ;
      BC001211_A213UserCustomizationsValue = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.usercustomizations_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.usercustomizations_bc__default(),
         new Object[] {
             new Object[] {
            BC00122_A44UserCustomizationsId, BC00122_A45UserCustomizationsKey, BC00122_A213UserCustomizationsValue
            }
            , new Object[] {
            BC00123_A44UserCustomizationsId, BC00123_A45UserCustomizationsKey, BC00123_A213UserCustomizationsValue
            }
            , new Object[] {
            BC00124_A44UserCustomizationsId, BC00124_A45UserCustomizationsKey, BC00124_A213UserCustomizationsValue
            }
            , new Object[] {
            BC00125_A44UserCustomizationsId, BC00125_A45UserCustomizationsKey
            }
            , new Object[] {
            BC00126_A44UserCustomizationsId, BC00126_A45UserCustomizationsKey, BC00126_A213UserCustomizationsValue
            }
            , new Object[] {
            BC00127_A44UserCustomizationsId, BC00127_A45UserCustomizationsKey, BC00127_A213UserCustomizationsValue
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001211_A44UserCustomizationsId, BC001211_A45UserCustomizationsKey, BC001211_A213UserCustomizationsValue
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
   private short RcdFound41 ;
   private short nIsDirty_41 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z44UserCustomizationsId ;
   private String A44UserCustomizationsId ;
   private String sMode41 ;
   private boolean mustCommit ;
   private String Z213UserCustomizationsValue ;
   private String A213UserCustomizationsValue ;
   private String Z45UserCustomizationsKey ;
   private String A45UserCustomizationsKey ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.SdtUserCustomizations bcwwpbaseobjects_UserCustomizations ;
   private IDataStoreProvider pr_default ;
   private String[] BC00124_A44UserCustomizationsId ;
   private String[] BC00124_A45UserCustomizationsKey ;
   private String[] BC00124_A213UserCustomizationsValue ;
   private String[] BC00125_A44UserCustomizationsId ;
   private String[] BC00125_A45UserCustomizationsKey ;
   private String[] BC00126_A44UserCustomizationsId ;
   private String[] BC00126_A45UserCustomizationsKey ;
   private String[] BC00126_A213UserCustomizationsValue ;
   private String[] BC00127_A44UserCustomizationsId ;
   private String[] BC00127_A45UserCustomizationsKey ;
   private String[] BC00127_A213UserCustomizationsValue ;
   private String[] BC001211_A44UserCustomizationsId ;
   private String[] BC001211_A45UserCustomizationsKey ;
   private String[] BC001211_A213UserCustomizationsValue ;
   private IDataStoreProvider pr_gam ;
   private String[] BC00122_A44UserCustomizationsId ;
   private String[] BC00122_A45UserCustomizationsKey ;
   private String[] BC00122_A213UserCustomizationsValue ;
   private String[] BC00123_A44UserCustomizationsId ;
   private String[] BC00123_A45UserCustomizationsKey ;
   private String[] BC00123_A213UserCustomizationsValue ;
}

final  class usercustomizations_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class usercustomizations_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00122", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WITH (UPDLOCK) WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00123", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00124", "SELECT TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey], TM1.[UserCustomizationsValue] FROM [UserCustomizations] TM1 WHERE TM1.[UserCustomizationsId] = ? and TM1.[UserCustomizationsKey] = ? ORDER BY TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00125", "SELECT [UserCustomizationsId], [UserCustomizationsKey] FROM [UserCustomizations] WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00126", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00127", "SELECT [UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue] FROM [UserCustomizations] WITH (UPDLOCK) WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC00128", "INSERT INTO [UserCustomizations]([UserCustomizationsId], [UserCustomizationsKey], [UserCustomizationsValue]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC00129", "UPDATE [UserCustomizations] SET [UserCustomizationsValue]=?  WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001210", "DELETE FROM [UserCustomizations]  WHERE [UserCustomizationsId] = ? AND [UserCustomizationsKey] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001211", "SELECT TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey], TM1.[UserCustomizationsValue] FROM [UserCustomizations] TM1 WHERE TM1.[UserCustomizationsId] = ? and TM1.[UserCustomizationsKey] = ? ORDER BY TM1.[UserCustomizationsId], TM1.[UserCustomizationsKey]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
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
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               return;
            case 7 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setString(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
      }
   }

}

