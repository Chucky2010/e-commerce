package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_mailtemplate_bc extends GXWebPanel implements IGxSilentTrn
{
   public wwp_mailtemplate_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_mailtemplate_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_mailtemplate_bc.class ));
   }

   public wwp_mailtemplate_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1038( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1038( ) ;
      standaloneModal( ) ;
      addRow1038( ) ;
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
         /* Execute user event: After Trn */
         e11102 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z41WWPMailTemplateName = A41WWPMailTemplateName ;
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

   public void confirm_100( )
   {
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1038( ) ;
         }
         else
         {
            checkExtendedTable1038( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors1038( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12102( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e11102( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1038( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z209WWPMailTemplateDescription = A209WWPMailTemplateDescription ;
         Z210WWPMailTemplateSubject = A210WWPMailTemplateSubject ;
      }
      if ( GX_JID == -1 )
      {
         Z41WWPMailTemplateName = A41WWPMailTemplateName ;
         Z209WWPMailTemplateDescription = A209WWPMailTemplateDescription ;
         Z210WWPMailTemplateSubject = A210WWPMailTemplateSubject ;
         Z195WWPMailTemplateBody = A195WWPMailTemplateBody ;
         Z196WWPMailTemplateSenderAddress = A196WWPMailTemplateSenderAddress ;
         Z197WWPMailTemplateSenderName = A197WWPMailTemplateSenderName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1038( )
   {
      /* Using cursor BC00104 */
      pr_default.execute(2, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A209WWPMailTemplateDescription = BC00104_A209WWPMailTemplateDescription[0] ;
         A210WWPMailTemplateSubject = BC00104_A210WWPMailTemplateSubject[0] ;
         A195WWPMailTemplateBody = BC00104_A195WWPMailTemplateBody[0] ;
         A196WWPMailTemplateSenderAddress = BC00104_A196WWPMailTemplateSenderAddress[0] ;
         A197WWPMailTemplateSenderName = BC00104_A197WWPMailTemplateSenderName[0] ;
         zm1038( -1) ;
      }
      pr_default.close(2);
      onLoadActions1038( ) ;
   }

   public void onLoadActions1038( )
   {
   }

   public void checkExtendedTable1038( )
   {
      nIsDirty_38 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors1038( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1038( )
   {
      /* Using cursor BC00105 */
      pr_default.execute(3, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound38 = (short)(1) ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00106 */
      pr_default.execute(4, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm1038( 1) ;
         RcdFound38 = (short)(1) ;
         A41WWPMailTemplateName = BC00106_A41WWPMailTemplateName[0] ;
         A209WWPMailTemplateDescription = BC00106_A209WWPMailTemplateDescription[0] ;
         A210WWPMailTemplateSubject = BC00106_A210WWPMailTemplateSubject[0] ;
         A195WWPMailTemplateBody = BC00106_A195WWPMailTemplateBody[0] ;
         A196WWPMailTemplateSenderAddress = BC00106_A196WWPMailTemplateSenderAddress[0] ;
         A197WWPMailTemplateSenderName = BC00106_A197WWPMailTemplateSenderName[0] ;
         Z41WWPMailTemplateName = A41WWPMailTemplateName ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1038( ) ;
         if ( AnyError == 1 )
         {
            RcdFound38 = (short)(0) ;
            initializeNonKey1038( ) ;
         }
         Gx_mode = sMode38 ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
         initializeNonKey1038( ) ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode38 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey1038( ) ;
      if ( RcdFound38 == 0 )
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
      confirm_100( ) ;
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

   public void checkOptimisticConcurrency1038( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00107 */
         pr_default.execute(5, new Object[] {A41WWPMailTemplateName});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailTemplate"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z209WWPMailTemplateDescription, BC00107_A209WWPMailTemplateDescription[0]) != 0 ) || ( GXutil.strcmp(Z210WWPMailTemplateSubject, BC00107_A210WWPMailTemplateSubject[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_MailTemplate"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1038( )
   {
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1038( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1038( 0) ;
         checkOptimisticConcurrency1038( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1038( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1038( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00108 */
                  pr_default.execute(6, new Object[] {A41WWPMailTemplateName, A209WWPMailTemplateDescription, A210WWPMailTemplateSubject, A195WWPMailTemplateBody, A196WWPMailTemplateSenderAddress, A197WWPMailTemplateSenderName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailTemplate");
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
            load1038( ) ;
         }
         endLevel1038( ) ;
      }
      closeExtendedTableCursors1038( ) ;
   }

   public void update1038( )
   {
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1038( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1038( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1038( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1038( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC00109 */
                  pr_default.execute(7, new Object[] {A209WWPMailTemplateDescription, A210WWPMailTemplateSubject, A195WWPMailTemplateBody, A196WWPMailTemplateSenderAddress, A197WWPMailTemplateSenderName, A41WWPMailTemplateName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailTemplate");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailTemplate"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1038( ) ;
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
         endLevel1038( ) ;
      }
      closeExtendedTableCursors1038( ) ;
   }

   public void deferredUpdate1038( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1038( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1038( ) ;
         afterConfirm1038( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1038( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001010 */
               pr_default.execute(8, new Object[] {A41WWPMailTemplateName});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailTemplate");
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
      sMode38 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1038( ) ;
      Gx_mode = sMode38 ;
   }

   public void onDeleteControls1038( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1038( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1038( ) ;
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

   public void scanKeyStart1038( )
   {
      /* Using cursor BC001011 */
      pr_default.execute(9, new Object[] {A41WWPMailTemplateName});
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A41WWPMailTemplateName = BC001011_A41WWPMailTemplateName[0] ;
         A209WWPMailTemplateDescription = BC001011_A209WWPMailTemplateDescription[0] ;
         A210WWPMailTemplateSubject = BC001011_A210WWPMailTemplateSubject[0] ;
         A195WWPMailTemplateBody = BC001011_A195WWPMailTemplateBody[0] ;
         A196WWPMailTemplateSenderAddress = BC001011_A196WWPMailTemplateSenderAddress[0] ;
         A197WWPMailTemplateSenderName = BC001011_A197WWPMailTemplateSenderName[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1038( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound38 = (short)(0) ;
      scanKeyLoad1038( ) ;
   }

   public void scanKeyLoad1038( )
   {
      sMode38 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A41WWPMailTemplateName = BC001011_A41WWPMailTemplateName[0] ;
         A209WWPMailTemplateDescription = BC001011_A209WWPMailTemplateDescription[0] ;
         A210WWPMailTemplateSubject = BC001011_A210WWPMailTemplateSubject[0] ;
         A195WWPMailTemplateBody = BC001011_A195WWPMailTemplateBody[0] ;
         A196WWPMailTemplateSenderAddress = BC001011_A196WWPMailTemplateSenderAddress[0] ;
         A197WWPMailTemplateSenderName = BC001011_A197WWPMailTemplateSenderName[0] ;
      }
      Gx_mode = sMode38 ;
   }

   public void scanKeyEnd1038( )
   {
      pr_default.close(9);
   }

   public void afterConfirm1038( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1038( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1038( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1038( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1038( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1038( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1038( )
   {
   }

   public void send_integrity_lvl_hashes1038( )
   {
   }

   public void addRow1038( )
   {
      VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
   }

   public void readRow1038( )
   {
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
   }

   public void initializeNonKey1038( )
   {
      A209WWPMailTemplateDescription = "" ;
      A210WWPMailTemplateSubject = "" ;
      A195WWPMailTemplateBody = "" ;
      A196WWPMailTemplateSenderAddress = "" ;
      A197WWPMailTemplateSenderName = "" ;
      Z209WWPMailTemplateDescription = "" ;
      Z210WWPMailTemplateSubject = "" ;
   }

   public void initAll1038( )
   {
      A41WWPMailTemplateName = "" ;
      initializeNonKey1038( ) ;
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

   public void VarsToRow38( com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate obj38 )
   {
      obj38.setgxTv_SdtWWP_MailTemplate_Mode( Gx_mode );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription( A209WWPMailTemplateDescription );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject( A210WWPMailTemplateSubject );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody( A195WWPMailTemplateBody );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress( A196WWPMailTemplateSenderAddress );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername( A197WWPMailTemplateSenderName );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename( A41WWPMailTemplateName );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z( Z41WWPMailTemplateName );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z( Z209WWPMailTemplateDescription );
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z( Z210WWPMailTemplateSubject );
      obj38.setgxTv_SdtWWP_MailTemplate_Mode( Gx_mode );
   }

   public void KeyVarsToRow38( com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate obj38 )
   {
      obj38.setgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename( A41WWPMailTemplateName );
   }

   public void RowToVars38( com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate obj38 ,
                            int forceLoad )
   {
      Gx_mode = obj38.getgxTv_SdtWWP_MailTemplate_Mode() ;
      A209WWPMailTemplateDescription = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription() ;
      A210WWPMailTemplateSubject = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject() ;
      A195WWPMailTemplateBody = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatebody() ;
      A196WWPMailTemplateSenderAddress = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesenderaddress() ;
      A197WWPMailTemplateSenderName = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesendername() ;
      A41WWPMailTemplateName = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename() ;
      Z41WWPMailTemplateName = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatename_Z() ;
      Z209WWPMailTemplateDescription = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatedescription_Z() ;
      Z210WWPMailTemplateSubject = obj38.getgxTv_SdtWWP_MailTemplate_Wwpmailtemplatesubject_Z() ;
      Gx_mode = obj38.getgxTv_SdtWWP_MailTemplate_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A41WWPMailTemplateName = (String)getParm(obj,0) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1038( ) ;
      scanKeyStart1038( ) ;
      if ( RcdFound38 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z41WWPMailTemplateName = A41WWPMailTemplateName ;
      }
      zm1038( -1) ;
      onLoadActions1038( ) ;
      addRow1038( ) ;
      scanKeyEnd1038( ) ;
      if ( RcdFound38 == 0 )
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
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 0) ;
      scanKeyStart1038( ) ;
      if ( RcdFound38 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z41WWPMailTemplateName = A41WWPMailTemplateName ;
      }
      zm1038( -1) ;
      onLoadActions1038( ) ;
      addRow1038( ) ;
      scanKeyEnd1038( ) ;
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1038( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1038( ) ;
      }
      else
      {
         if ( RcdFound38 == 1 )
         {
            if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
            {
               A41WWPMailTemplateName = Z41WWPMailTemplateName ;
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
               update1038( ) ;
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
               if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
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
                     insert1038( ) ;
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
                     insert1038( ) ;
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
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
      saveImpl( ) ;
      VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1038( ) ;
      afterTrn( ) ;
      VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
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
         com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate auxBC = new com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A41WWPMailTemplateName);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_mail_WWP_MailTemplate);
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
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
      updateImpl( ) ;
      VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
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
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1038( ) ;
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
      VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1038( ) ;
      if ( RcdFound38 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
         {
            A41WWPMailTemplateName = Z41WWPMailTemplateName ;
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
         if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.mail.wwp_mailtemplate_bc");
      VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
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
      Gx_mode = bcwwpbaseobjects_mail_WWP_MailTemplate.getgxTv_SdtWWP_MailTemplate_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_mail_WWP_MailTemplate.setgxTv_SdtWWP_MailTemplate_Mode( Gx_mode );
   }

   public void SetSDT( com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_mail_WWP_MailTemplate )
      {
         bcwwpbaseobjects_mail_WWP_MailTemplate = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_mail_WWP_MailTemplate.getgxTv_SdtWWP_MailTemplate_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_mail_WWP_MailTemplate.setgxTv_SdtWWP_MailTemplate_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow38( bcwwpbaseobjects_mail_WWP_MailTemplate) ;
         }
         else
         {
            RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_mail_WWP_MailTemplate.getgxTv_SdtWWP_MailTemplate_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_mail_WWP_MailTemplate.setgxTv_SdtWWP_MailTemplate_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars38( bcwwpbaseobjects_mail_WWP_MailTemplate, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtWWP_MailTemplate getWWP_MailTemplate_BC( )
   {
      return bcwwpbaseobjects_mail_WWP_MailTemplate ;
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
      Z41WWPMailTemplateName = "" ;
      A41WWPMailTemplateName = "" ;
      Z209WWPMailTemplateDescription = "" ;
      A209WWPMailTemplateDescription = "" ;
      Z210WWPMailTemplateSubject = "" ;
      A210WWPMailTemplateSubject = "" ;
      Z195WWPMailTemplateBody = "" ;
      A195WWPMailTemplateBody = "" ;
      Z196WWPMailTemplateSenderAddress = "" ;
      A196WWPMailTemplateSenderAddress = "" ;
      Z197WWPMailTemplateSenderName = "" ;
      A197WWPMailTemplateSenderName = "" ;
      BC00104_A41WWPMailTemplateName = new String[] {""} ;
      BC00104_A209WWPMailTemplateDescription = new String[] {""} ;
      BC00104_A210WWPMailTemplateSubject = new String[] {""} ;
      BC00104_A195WWPMailTemplateBody = new String[] {""} ;
      BC00104_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      BC00104_A197WWPMailTemplateSenderName = new String[] {""} ;
      BC00105_A41WWPMailTemplateName = new String[] {""} ;
      BC00106_A41WWPMailTemplateName = new String[] {""} ;
      BC00106_A209WWPMailTemplateDescription = new String[] {""} ;
      BC00106_A210WWPMailTemplateSubject = new String[] {""} ;
      BC00106_A195WWPMailTemplateBody = new String[] {""} ;
      BC00106_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      BC00106_A197WWPMailTemplateSenderName = new String[] {""} ;
      sMode38 = "" ;
      BC00107_A41WWPMailTemplateName = new String[] {""} ;
      BC00107_A209WWPMailTemplateDescription = new String[] {""} ;
      BC00107_A210WWPMailTemplateSubject = new String[] {""} ;
      BC00107_A195WWPMailTemplateBody = new String[] {""} ;
      BC00107_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      BC00107_A197WWPMailTemplateSenderName = new String[] {""} ;
      BC001011_A41WWPMailTemplateName = new String[] {""} ;
      BC001011_A209WWPMailTemplateDescription = new String[] {""} ;
      BC001011_A210WWPMailTemplateSubject = new String[] {""} ;
      BC001011_A195WWPMailTemplateBody = new String[] {""} ;
      BC001011_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      BC001011_A197WWPMailTemplateSenderName = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate_bc__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate_bc__default(),
         new Object[] {
             new Object[] {
            BC00102_A41WWPMailTemplateName, BC00102_A209WWPMailTemplateDescription, BC00102_A210WWPMailTemplateSubject, BC00102_A195WWPMailTemplateBody, BC00102_A196WWPMailTemplateSenderAddress, BC00102_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            BC00103_A41WWPMailTemplateName, BC00103_A209WWPMailTemplateDescription, BC00103_A210WWPMailTemplateSubject, BC00103_A195WWPMailTemplateBody, BC00103_A196WWPMailTemplateSenderAddress, BC00103_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            BC00104_A41WWPMailTemplateName, BC00104_A209WWPMailTemplateDescription, BC00104_A210WWPMailTemplateSubject, BC00104_A195WWPMailTemplateBody, BC00104_A196WWPMailTemplateSenderAddress, BC00104_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            BC00105_A41WWPMailTemplateName
            }
            , new Object[] {
            BC00106_A41WWPMailTemplateName, BC00106_A209WWPMailTemplateDescription, BC00106_A210WWPMailTemplateSubject, BC00106_A195WWPMailTemplateBody, BC00106_A196WWPMailTemplateSenderAddress, BC00106_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            BC00107_A41WWPMailTemplateName, BC00107_A209WWPMailTemplateDescription, BC00107_A210WWPMailTemplateSubject, BC00107_A195WWPMailTemplateBody, BC00107_A196WWPMailTemplateSenderAddress, BC00107_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001011_A41WWPMailTemplateName, BC001011_A209WWPMailTemplateDescription, BC001011_A210WWPMailTemplateSubject, BC001011_A195WWPMailTemplateBody, BC001011_A196WWPMailTemplateSenderAddress, BC001011_A197WWPMailTemplateSenderName
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12102 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound38 ;
   private short nIsDirty_38 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode38 ;
   private boolean returnInSub ;
   private boolean mustCommit ;
   private String Z195WWPMailTemplateBody ;
   private String A195WWPMailTemplateBody ;
   private String Z196WWPMailTemplateSenderAddress ;
   private String A196WWPMailTemplateSenderAddress ;
   private String Z197WWPMailTemplateSenderName ;
   private String A197WWPMailTemplateSenderName ;
   private String Z41WWPMailTemplateName ;
   private String A41WWPMailTemplateName ;
   private String Z209WWPMailTemplateDescription ;
   private String A209WWPMailTemplateDescription ;
   private String Z210WWPMailTemplateSubject ;
   private String A210WWPMailTemplateSubject ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate bcwwpbaseobjects_mail_WWP_MailTemplate ;
   private IDataStoreProvider pr_default ;
   private String[] BC00104_A41WWPMailTemplateName ;
   private String[] BC00104_A209WWPMailTemplateDescription ;
   private String[] BC00104_A210WWPMailTemplateSubject ;
   private String[] BC00104_A195WWPMailTemplateBody ;
   private String[] BC00104_A196WWPMailTemplateSenderAddress ;
   private String[] BC00104_A197WWPMailTemplateSenderName ;
   private String[] BC00105_A41WWPMailTemplateName ;
   private String[] BC00106_A41WWPMailTemplateName ;
   private String[] BC00106_A209WWPMailTemplateDescription ;
   private String[] BC00106_A210WWPMailTemplateSubject ;
   private String[] BC00106_A195WWPMailTemplateBody ;
   private String[] BC00106_A196WWPMailTemplateSenderAddress ;
   private String[] BC00106_A197WWPMailTemplateSenderName ;
   private String[] BC00107_A41WWPMailTemplateName ;
   private String[] BC00107_A209WWPMailTemplateDescription ;
   private String[] BC00107_A210WWPMailTemplateSubject ;
   private String[] BC00107_A195WWPMailTemplateBody ;
   private String[] BC00107_A196WWPMailTemplateSenderAddress ;
   private String[] BC00107_A197WWPMailTemplateSenderName ;
   private String[] BC001011_A41WWPMailTemplateName ;
   private String[] BC001011_A209WWPMailTemplateDescription ;
   private String[] BC001011_A210WWPMailTemplateSubject ;
   private String[] BC001011_A195WWPMailTemplateBody ;
   private String[] BC001011_A196WWPMailTemplateSenderAddress ;
   private String[] BC001011_A197WWPMailTemplateSenderName ;
   private IDataStoreProvider pr_gam ;
   private String[] BC00102_A41WWPMailTemplateName ;
   private String[] BC00102_A209WWPMailTemplateDescription ;
   private String[] BC00102_A210WWPMailTemplateSubject ;
   private String[] BC00102_A195WWPMailTemplateBody ;
   private String[] BC00102_A196WWPMailTemplateSenderAddress ;
   private String[] BC00102_A197WWPMailTemplateSenderName ;
   private String[] BC00103_A41WWPMailTemplateName ;
   private String[] BC00103_A209WWPMailTemplateDescription ;
   private String[] BC00103_A210WWPMailTemplateSubject ;
   private String[] BC00103_A195WWPMailTemplateBody ;
   private String[] BC00103_A196WWPMailTemplateSenderAddress ;
   private String[] BC00103_A197WWPMailTemplateSenderName ;
}

final  class wwp_mailtemplate_bc__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_mailtemplate_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00102", "SELECT [WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName] FROM [WWP_MailTemplate] WITH (UPDLOCK) WHERE [WWPMailTemplateName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00103", "SELECT [WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName] FROM [WWP_MailTemplate] WHERE [WWPMailTemplateName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00104", "SELECT TM1.[WWPMailTemplateName], TM1.[WWPMailTemplateDescription], TM1.[WWPMailTemplateSubject], TM1.[WWPMailTemplateBody], TM1.[WWPMailTemplateSenderAddress], TM1.[WWPMailTemplateSenderName] FROM [WWP_MailTemplate] TM1 WHERE TM1.[WWPMailTemplateName] = ? ORDER BY TM1.[WWPMailTemplateName]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00105", "SELECT [WWPMailTemplateName] FROM [WWP_MailTemplate] WHERE [WWPMailTemplateName] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00106", "SELECT [WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName] FROM [WWP_MailTemplate] WHERE [WWPMailTemplateName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00107", "SELECT [WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName] FROM [WWP_MailTemplate] WITH (UPDLOCK) WHERE [WWPMailTemplateName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC00108", "INSERT INTO [WWP_MailTemplate]([WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("BC00109", "UPDATE [WWP_MailTemplate] SET [WWPMailTemplateDescription]=?, [WWPMailTemplateSubject]=?, [WWPMailTemplateBody]=?, [WWPMailTemplateSenderAddress]=?, [WWPMailTemplateSenderName]=?  WHERE [WWPMailTemplateName] = ?", GX_NOMASK)
         ,new UpdateCursor("BC001010", "DELETE FROM [WWP_MailTemplate]  WHERE [WWPMailTemplateName] = ?", GX_NOMASK)
         ,new ForEachCursor("BC001011", "SELECT TM1.[WWPMailTemplateName], TM1.[WWPMailTemplateDescription], TM1.[WWPMailTemplateSubject], TM1.[WWPMailTemplateBody], TM1.[WWPMailTemplateSenderAddress], TM1.[WWPMailTemplateSenderName] FROM [WWP_MailTemplate] TM1 WHERE TM1.[WWPMailTemplateName] = ? ORDER BY TM1.[WWPMailTemplateName]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 80, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 80, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
      }
   }

}

