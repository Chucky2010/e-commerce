package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_entity_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_entity_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_entity_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_entity_bc.class ));
   }

   public wwp_entity_bc( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0T31( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0T31( ) ;
      standaloneModal( ) ;
      addRow0T31( ) ;
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
            Z33WWPEntityId = A33WWPEntityId ;
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

   public void confirm_0T0( )
   {
      beforeValidate0T31( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0T31( ) ;
         }
         else
         {
            checkExtendedTable0T31( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0T31( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0T31( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z150WWPEntityName = A150WWPEntityName ;
      }
      if ( GX_JID == -1 )
      {
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

   public void load0T31( )
   {
      /* Using cursor BC000T4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A150WWPEntityName = BC000T4_A150WWPEntityName[0] ;
         zm0T31( -1) ;
      }
      pr_default.close(2);
      onLoadActions0T31( ) ;
   }

   public void onLoadActions0T31( )
   {
   }

   public void checkExtendedTable0T31( )
   {
      nIsDirty_31 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors0T31( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0T31( )
   {
      /* Using cursor BC000T5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound31 = (short)(1) ;
      }
      else
      {
         RcdFound31 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000T6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0T31( 1) ;
         RcdFound31 = (short)(1) ;
         A33WWPEntityId = BC000T6_A33WWPEntityId[0] ;
         A150WWPEntityName = BC000T6_A150WWPEntityName[0] ;
         Z33WWPEntityId = A33WWPEntityId ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0T31( ) ;
         if ( AnyError == 1 )
         {
            RcdFound31 = (short)(0) ;
            initializeNonKey0T31( ) ;
         }
         Gx_mode = sMode31 ;
      }
      else
      {
         RcdFound31 = (short)(0) ;
         initializeNonKey0T31( ) ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode31 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0T31( ) ;
      if ( RcdFound31 == 0 )
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
      confirm_0T0( ) ;
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

   public void checkOptimisticConcurrency0T31( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000T7 */
         pr_default.execute(5, new Object[] {Long.valueOf(A33WWPEntityId)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Entity"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z150WWPEntityName, BC000T7_A150WWPEntityName[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Entity"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0T31( )
   {
      beforeValidate0T31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0T31( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0T31( 0) ;
         checkOptimisticConcurrency0T31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0T31( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0T31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000T8 */
                  pr_default.execute(6, new Object[] {A150WWPEntityName});
                  A33WWPEntityId = BC000T8_A33WWPEntityId[0] ;
                  pr_default.close(6);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Entity");
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
            load0T31( ) ;
         }
         endLevel0T31( ) ;
      }
      closeExtendedTableCursors0T31( ) ;
   }

   public void update0T31( )
   {
      beforeValidate0T31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0T31( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0T31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0T31( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0T31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000T9 */
                  pr_default.execute(7, new Object[] {A150WWPEntityName, Long.valueOf(A33WWPEntityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Entity");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Entity"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0T31( ) ;
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
         endLevel0T31( ) ;
      }
      closeExtendedTableCursors0T31( ) ;
   }

   public void deferredUpdate0T31( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0T31( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0T31( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0T31( ) ;
         afterConfirm0T31( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0T31( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000T10 */
               pr_default.execute(8, new Object[] {Long.valueOf(A33WWPEntityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Entity");
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
      sMode31 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0T31( ) ;
      Gx_mode = sMode31 ;
   }

   public void onDeleteControls0T31( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000T11 */
         pr_default.execute(9, new Object[] {Long.valueOf(A33WWPEntityId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_NotificationDefinition", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
      }
   }

   public void endLevel0T31( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0T31( ) ;
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

   public void scanKeyStart0T31( )
   {
      /* Using cursor BC000T12 */
      pr_default.execute(10, new Object[] {Long.valueOf(A33WWPEntityId)});
      RcdFound31 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A33WWPEntityId = BC000T12_A33WWPEntityId[0] ;
         A150WWPEntityName = BC000T12_A150WWPEntityName[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0T31( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound31 = (short)(0) ;
      scanKeyLoad0T31( ) ;
   }

   public void scanKeyLoad0T31( )
   {
      sMode31 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A33WWPEntityId = BC000T12_A33WWPEntityId[0] ;
         A150WWPEntityName = BC000T12_A150WWPEntityName[0] ;
      }
      Gx_mode = sMode31 ;
   }

   public void scanKeyEnd0T31( )
   {
      pr_default.close(10);
   }

   public void afterConfirm0T31( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0T31( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0T31( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0T31( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0T31( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0T31( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0T31( )
   {
   }

   public void send_integrity_lvl_hashes0T31( )
   {
   }

   public void addRow0T31( )
   {
      VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
   }

   public void readRow0T31( )
   {
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
   }

   public void initializeNonKey0T31( )
   {
      A150WWPEntityName = "" ;
      Z150WWPEntityName = "" ;
   }

   public void initAll0T31( )
   {
      A33WWPEntityId = 0 ;
      initializeNonKey0T31( ) ;
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

   public void VarsToRow31( com.mujermorena.wwpbaseobjects.SdtWWP_Entity obj31 )
   {
      obj31.setgxTv_SdtWWP_Entity_Mode( Gx_mode );
      obj31.setgxTv_SdtWWP_Entity_Wwpentityname( A150WWPEntityName );
      obj31.setgxTv_SdtWWP_Entity_Wwpentityid( A33WWPEntityId );
      obj31.setgxTv_SdtWWP_Entity_Wwpentityid_Z( Z33WWPEntityId );
      obj31.setgxTv_SdtWWP_Entity_Wwpentityname_Z( Z150WWPEntityName );
      obj31.setgxTv_SdtWWP_Entity_Mode( Gx_mode );
   }

   public void KeyVarsToRow31( com.mujermorena.wwpbaseobjects.SdtWWP_Entity obj31 )
   {
      obj31.setgxTv_SdtWWP_Entity_Wwpentityid( A33WWPEntityId );
   }

   public void RowToVars31( com.mujermorena.wwpbaseobjects.SdtWWP_Entity obj31 ,
                            int forceLoad )
   {
      Gx_mode = obj31.getgxTv_SdtWWP_Entity_Mode() ;
      A150WWPEntityName = obj31.getgxTv_SdtWWP_Entity_Wwpentityname() ;
      A33WWPEntityId = obj31.getgxTv_SdtWWP_Entity_Wwpentityid() ;
      Z33WWPEntityId = obj31.getgxTv_SdtWWP_Entity_Wwpentityid_Z() ;
      Z150WWPEntityName = obj31.getgxTv_SdtWWP_Entity_Wwpentityname_Z() ;
      Gx_mode = obj31.getgxTv_SdtWWP_Entity_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A33WWPEntityId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0T31( ) ;
      scanKeyStart0T31( ) ;
      if ( RcdFound31 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z33WWPEntityId = A33WWPEntityId ;
      }
      zm0T31( -1) ;
      onLoadActions0T31( ) ;
      addRow0T31( ) ;
      scanKeyEnd0T31( ) ;
      if ( RcdFound31 == 0 )
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
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 0) ;
      scanKeyStart0T31( ) ;
      if ( RcdFound31 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z33WWPEntityId = A33WWPEntityId ;
      }
      zm0T31( -1) ;
      onLoadActions0T31( ) ;
      addRow0T31( ) ;
      scanKeyEnd0T31( ) ;
      if ( RcdFound31 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0T31( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0T31( ) ;
      }
      else
      {
         if ( RcdFound31 == 1 )
         {
            if ( A33WWPEntityId != Z33WWPEntityId )
            {
               A33WWPEntityId = Z33WWPEntityId ;
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
               update0T31( ) ;
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
               if ( A33WWPEntityId != Z33WWPEntityId )
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
                     insert0T31( ) ;
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
                     insert0T31( ) ;
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
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
      saveImpl( ) ;
      VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0T31( ) ;
      afterTrn( ) ;
      VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
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
         com.mujermorena.wwpbaseobjects.SdtWWP_Entity auxBC = new com.mujermorena.wwpbaseobjects.SdtWWP_Entity( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A33WWPEntityId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_WWP_Entity);
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
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
      updateImpl( ) ;
      VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
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
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0T31( ) ;
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
      VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0T31( ) ;
      if ( RcdFound31 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A33WWPEntityId != Z33WWPEntityId )
         {
            A33WWPEntityId = Z33WWPEntityId ;
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
         if ( A33WWPEntityId != Z33WWPEntityId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.wwp_entity_bc");
      VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
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
      Gx_mode = bcwwpbaseobjects_WWP_Entity.getgxTv_SdtWWP_Entity_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_WWP_Entity.setgxTv_SdtWWP_Entity_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.SdtWWP_Entity sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_WWP_Entity )
      {
         bcwwpbaseobjects_WWP_Entity = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_WWP_Entity.getgxTv_SdtWWP_Entity_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_WWP_Entity.setgxTv_SdtWWP_Entity_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow31( bcwwpbaseobjects_WWP_Entity) ;
         }
         else
         {
            RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_WWP_Entity.getgxTv_SdtWWP_Entity_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_WWP_Entity.setgxTv_SdtWWP_Entity_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars31( bcwwpbaseobjects_WWP_Entity, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_Entity getWWP_Entity_BC( )
   {
      return bcwwpbaseobjects_WWP_Entity ;
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
      Z150WWPEntityName = "" ;
      A150WWPEntityName = "" ;
      BC000T4_A33WWPEntityId = new long[1] ;
      BC000T4_A150WWPEntityName = new String[] {""} ;
      BC000T5_A33WWPEntityId = new long[1] ;
      BC000T6_A33WWPEntityId = new long[1] ;
      BC000T6_A150WWPEntityName = new String[] {""} ;
      sMode31 = "" ;
      BC000T7_A33WWPEntityId = new long[1] ;
      BC000T7_A150WWPEntityName = new String[] {""} ;
      BC000T8_A33WWPEntityId = new long[1] ;
      BC000T11_A35WWPNotificationDefinitionId = new long[1] ;
      BC000T12_A33WWPEntityId = new long[1] ;
      BC000T12_A150WWPEntityName = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_entity_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_entity_bc__default(),
         new Object[] {
             new Object[] {
            BC000T2_A33WWPEntityId, BC000T2_A150WWPEntityName
            }
            , new Object[] {
            BC000T3_A33WWPEntityId, BC000T3_A150WWPEntityName
            }
            , new Object[] {
            BC000T4_A33WWPEntityId, BC000T4_A150WWPEntityName
            }
            , new Object[] {
            BC000T5_A33WWPEntityId
            }
            , new Object[] {
            BC000T6_A33WWPEntityId, BC000T6_A150WWPEntityName
            }
            , new Object[] {
            BC000T7_A33WWPEntityId, BC000T7_A150WWPEntityName
            }
            , new Object[] {
            BC000T8_A33WWPEntityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000T11_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            BC000T12_A33WWPEntityId, BC000T12_A150WWPEntityName
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
   private short RcdFound31 ;
   private short nIsDirty_31 ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z33WWPEntityId ;
   private long A33WWPEntityId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode31 ;
   private boolean mustCommit ;
   private String Z150WWPEntityName ;
   private String A150WWPEntityName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_Entity bcwwpbaseobjects_WWP_Entity ;
   private IDataStoreProvider pr_default ;
   private long[] BC000T4_A33WWPEntityId ;
   private String[] BC000T4_A150WWPEntityName ;
   private long[] BC000T5_A33WWPEntityId ;
   private long[] BC000T6_A33WWPEntityId ;
   private String[] BC000T6_A150WWPEntityName ;
   private long[] BC000T7_A33WWPEntityId ;
   private String[] BC000T7_A150WWPEntityName ;
   private long[] BC000T8_A33WWPEntityId ;
   private long[] BC000T11_A35WWPNotificationDefinitionId ;
   private long[] BC000T12_A33WWPEntityId ;
   private String[] BC000T12_A150WWPEntityName ;
   private IDataStoreProvider pr_gam ;
   private long[] BC000T2_A33WWPEntityId ;
   private String[] BC000T2_A150WWPEntityName ;
   private long[] BC000T3_A33WWPEntityId ;
   private String[] BC000T3_A150WWPEntityName ;
}

final  class wwp_entity_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_entity_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000T2", "SELECT [WWPEntityId], [WWPEntityName] FROM [WWP_Entity] WITH (UPDLOCK) WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T3", "SELECT [WWPEntityId], [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T4", "SELECT TM1.[WWPEntityId], TM1.[WWPEntityName] FROM [WWP_Entity] TM1 WHERE TM1.[WWPEntityId] = ? ORDER BY TM1.[WWPEntityId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T5", "SELECT [WWPEntityId] FROM [WWP_Entity] WHERE [WWPEntityId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T6", "SELECT [WWPEntityId], [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T7", "SELECT [WWPEntityId], [WWPEntityName] FROM [WWP_Entity] WITH (UPDLOCK) WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000T8", "INSERT INTO [WWP_Entity]([WWPEntityName]) VALUES(?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("BC000T9", "UPDATE [WWP_Entity] SET [WWPEntityName]=?  WHERE [WWPEntityId] = ?", GX_NOMASK)
         ,new UpdateCursor("BC000T10", "DELETE FROM [WWP_Entity]  WHERE [WWPEntityId] = ?", GX_NOMASK)
         ,new ForEachCursor("BC000T11", "SELECT TOP 1 [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000T12", "SELECT TM1.[WWPEntityId], TM1.[WWPEntityName] FROM [WWP_Entity] TM1 WHERE TM1.[WWPEntityId] = ? ORDER BY TM1.[WWPEntityId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setVarchar(1, (String)parms[0], 100, false);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

