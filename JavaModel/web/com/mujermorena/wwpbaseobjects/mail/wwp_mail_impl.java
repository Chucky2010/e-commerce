package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_mail_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
      {
         A37WWPNotificationId = GXutil.lval( httpContext.GetPar( "WWPNotificationId")) ;
         n37WWPNotificationId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A37WWPNotificationId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridwwp_mail_attachments") == 0 )
      {
         gxnrgridwwp_mail_attachments_newrow_invoke( ) ;
         return  ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Mail", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPMailId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridwwp_mail_attachments_newrow_invoke( )
   {
      nRC_GXsfl_113 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_113"))) ;
      nGXsfl_113_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_113_idx"))) ;
      sGXsfl_113_idx = httpContext.GetPar( "sGXsfl_113_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridwwp_mail_attachments_newrow( ) ;
      /* End function gxnrGridwwp_mail_attachments_newrow_invoke */
   }

   public wwp_mail_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_mail_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_mail_impl.class ));
   }

   public wwp_mail_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbWWPMailStatus = new HTMLChoice();
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.mujermorena.wwpbaseobjects.workwithplusmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbWWPMailStatus.getItemCount() > 0 )
      {
         A202WWPMailStatus = (short)(GXutil.lval( cmbWWPMailStatus.getValidValue(GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPMailStatus.setValue( GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbWWPMailStatus.getInternalname(), "Values", cmbWWPMailStatus.ToJavascriptSource(), true);
      }
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "WWAdvancedContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Mail", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 ToolbarCellClass", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCellAdvanced", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailId_Internalname, GXutil.ltrim( localUtil.ntoc( A42WWPMailId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPMailId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A42WWPMailId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A42WWPMailId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailSubject_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailSubject_Internalname, httpContext.getMessage( "Subject", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailSubject_Internalname, A191WWPMailSubject, GXutil.rtrim( localUtil.format( A191WWPMailSubject, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailSubject_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailSubject_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailBody_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailBody_Internalname, httpContext.getMessage( "Body", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailBody_Internalname, A183WWPMailBody, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", (short)(1), 1, edtWWPMailBody_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "GeneXus\\Html", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTo_Internalname, httpContext.getMessage( "To", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailTo_Internalname, A192WWPMailTo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", (short)(0), 1, edtWWPMailTo_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailCC_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailCC_Internalname, httpContext.getMessage( "CC", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailCC_Internalname, A204WWPMailCC, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtWWPMailCC_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailBCC_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailBCC_Internalname, httpContext.getMessage( "BCC", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailBCC_Internalname, A205WWPMailBCC, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", (short)(0), 1, edtWWPMailBCC_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailSenderAddress_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailSenderAddress_Internalname, httpContext.getMessage( "Sender Address", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailSenderAddress_Internalname, A193WWPMailSenderAddress, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", (short)(0), 1, edtWWPMailSenderAddress_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailSenderName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailSenderName_Internalname, httpContext.getMessage( "Sender Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailSenderName_Internalname, A194WWPMailSenderName, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtWWPMailSenderName_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbWWPMailStatus.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbWWPMailStatus.getInternalname(), httpContext.getMessage( "Status", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbWWPMailStatus, cmbWWPMailStatus.getInternalname(), GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0)), 1, cmbWWPMailStatus.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbWWPMailStatus.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      cmbWWPMailStatus.setValue( GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPMailStatus.getInternalname(), "Values", cmbWWPMailStatus.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailCreated_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailCreated_Internalname, httpContext.getMessage( "Created", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPMailCreated_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailCreated_Internalname, localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A211WWPMailCreated, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPMailCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPMailCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailScheduled_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailScheduled_Internalname, httpContext.getMessage( "Scheduled", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPMailScheduled_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailScheduled_Internalname, localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A212WWPMailScheduled, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailScheduled_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailScheduled_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPMailScheduled_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPMailScheduled_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailProcessed_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailProcessed_Internalname, httpContext.getMessage( "Processed", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPMailProcessed_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailProcessed_Internalname, localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A207WWPMailProcessed, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailProcessed_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailProcessed_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPMailProcessed_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPMailProcessed_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailDetail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailDetail_Internalname, httpContext.getMessage( "Detail", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailDetail_Internalname, A208WWPMailDetail, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", (short)(0), 1, edtWWPMailDetail_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationId_Internalname, httpContext.getMessage( "Notification Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationId_Internalname, GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationCreated_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationCreated_Internalname, httpContext.getMessage( "Notification Created Date", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtWWPNotificationCreated_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationCreated_Internalname, localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A40WWPNotificationCreated, "99/99/9999 99:99:99.999"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPNotificationCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPNotificationCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divAttachmentstable_Internalname, 1, 0, "px", 0, "px", "LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitleattachments_Internalname, httpContext.getMessage( "Attachments", ""), "", "", lblTitleattachments_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridwwp_mail_attachments( ) ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_Mail.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridwwp_mail_attachments( )
   {
      /*  Grid Control  */
      startgridcontrol113( ) ;
      nGXsfl_113_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount40 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_40 = (short)(1) ;
            scanStart1140( ) ;
            while ( RcdFound40 != 0 )
            {
               init_level_properties40( ) ;
               getByPrimaryKey1140( ) ;
               addRow1140( ) ;
               scanNext1140( ) ;
            }
            scanEnd1140( ) ;
            nBlankRcdCount40 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal1140( ) ;
         standaloneModal1140( ) ;
         sMode40 = Gx_mode ;
         while ( nGXsfl_113_idx < nRC_GXsfl_113 )
         {
            bGXsfl_113_Refreshing = true ;
            readRow1140( ) ;
            edtWWPMailAttachmentName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "WWPMAILATTACHMENTNAME_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentName_Enabled), 5, 0), !bGXsfl_113_Refreshing);
            edtWWPMailAttachmentFile_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "WWPMAILATTACHMENTFILE_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentFile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentFile_Enabled), 5, 0), !bGXsfl_113_Refreshing);
            if ( ( nRcdExists_40 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1140( ) ;
            }
            sendRow1140( ) ;
            bGXsfl_113_Refreshing = false ;
         }
         Gx_mode = sMode40 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount40 = (short)(5) ;
         nRcdExists_40 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1140( ) ;
            while ( RcdFound40 != 0 )
            {
               sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_11340( ) ;
               init_level_properties40( ) ;
               standaloneNotModal1140( ) ;
               getByPrimaryKey1140( ) ;
               standaloneModal1140( ) ;
               addRow1140( ) ;
               scanNext1140( ) ;
            }
            scanEnd1140( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode40 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_11340( ) ;
      initAll1140( ) ;
      init_level_properties40( ) ;
      nRcdExists_40 = (short)(0) ;
      nIsMod_40 = (short)(0) ;
      nRcdDeleted_40 = (short)(0) ;
      nBlankRcdCount40 = (short)(nBlankRcdUsr40+nBlankRcdCount40) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount40 > 0 )
      {
         standaloneNotModal1140( ) ;
         standaloneModal1140( ) ;
         addRow1140( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtWWPMailAttachmentName_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount40 = (short)(nBlankRcdCount40-1) ;
      }
      Gx_mode = sMode40 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridwwp_mail_attachmentsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridwwp_mail_attachments", Gridwwp_mail_attachmentsContainer, subGridwwp_mail_attachments_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridwwp_mail_attachmentsContainerData", Gridwwp_mail_attachmentsContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridwwp_mail_attachmentsContainerData"+"V", Gridwwp_mail_attachmentsContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridwwp_mail_attachmentsContainerData"+"V"+"\" value='"+Gridwwp_mail_attachmentsContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z42WWPMailId = localUtil.ctol( httpContext.cgiGet( "Z42WWPMailId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z191WWPMailSubject = httpContext.cgiGet( "Z191WWPMailSubject") ;
         Z202WWPMailStatus = (short)(localUtil.ctol( httpContext.cgiGet( "Z202WWPMailStatus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z211WWPMailCreated = localUtil.ctot( httpContext.cgiGet( "Z211WWPMailCreated"), 0) ;
         Z212WWPMailScheduled = localUtil.ctot( httpContext.cgiGet( "Z212WWPMailScheduled"), 0) ;
         Z207WWPMailProcessed = localUtil.ctot( httpContext.cgiGet( "Z207WWPMailProcessed"), 0) ;
         n207WWPMailProcessed = (GXutil.dateCompare(GXutil.nullDate(), A207WWPMailProcessed) ? true : false) ;
         Z37WWPNotificationId = localUtil.ctol( httpContext.cgiGet( "Z37WWPNotificationId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         nRC_GXsfl_113 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_113"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPMailId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPMailId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPMAILID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPMailId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A42WWPMailId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
         }
         else
         {
            A42WWPMailId = localUtil.ctol( httpContext.cgiGet( edtWWPMailId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
         }
         A191WWPMailSubject = httpContext.cgiGet( edtWWPMailSubject_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A191WWPMailSubject", A191WWPMailSubject);
         A183WWPMailBody = httpContext.cgiGet( edtWWPMailBody_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A183WWPMailBody", A183WWPMailBody);
         A192WWPMailTo = httpContext.cgiGet( edtWWPMailTo_Internalname) ;
         n192WWPMailTo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A192WWPMailTo", A192WWPMailTo);
         n192WWPMailTo = ((GXutil.strcmp("", A192WWPMailTo)==0) ? true : false) ;
         A204WWPMailCC = httpContext.cgiGet( edtWWPMailCC_Internalname) ;
         n204WWPMailCC = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A204WWPMailCC", A204WWPMailCC);
         n204WWPMailCC = ((GXutil.strcmp("", A204WWPMailCC)==0) ? true : false) ;
         A205WWPMailBCC = httpContext.cgiGet( edtWWPMailBCC_Internalname) ;
         n205WWPMailBCC = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A205WWPMailBCC", A205WWPMailBCC);
         n205WWPMailBCC = ((GXutil.strcmp("", A205WWPMailBCC)==0) ? true : false) ;
         A193WWPMailSenderAddress = httpContext.cgiGet( edtWWPMailSenderAddress_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A193WWPMailSenderAddress", A193WWPMailSenderAddress);
         A194WWPMailSenderName = httpContext.cgiGet( edtWWPMailSenderName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A194WWPMailSenderName", A194WWPMailSenderName);
         cmbWWPMailStatus.setName( cmbWWPMailStatus.getInternalname() );
         cmbWWPMailStatus.setValue( httpContext.cgiGet( cmbWWPMailStatus.getInternalname()) );
         A202WWPMailStatus = (short)(GXutil.lval( httpContext.cgiGet( cmbWWPMailStatus.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPMailCreated_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPMAILCREATED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPMailCreated_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A211WWPMailCreated = localUtil.ctot( httpContext.cgiGet( edtWWPMailCreated_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPMailScheduled_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPMAILSCHEDULED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPMailScheduled_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A212WWPMailScheduled = localUtil.ctot( httpContext.cgiGet( edtWWPMailScheduled_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPMailProcessed_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPMAILPROCESSED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPMailProcessed_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
            n207WWPMailProcessed = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A207WWPMailProcessed", localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A207WWPMailProcessed = localUtil.ctot( httpContext.cgiGet( edtWWPMailProcessed_Internalname)) ;
            n207WWPMailProcessed = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A207WWPMailProcessed", localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         n207WWPMailProcessed = (GXutil.dateCompare(GXutil.nullDate(), A207WWPMailProcessed) ? true : false) ;
         A208WWPMailDetail = httpContext.cgiGet( edtWWPMailDetail_Internalname) ;
         n208WWPMailDetail = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A208WWPMailDetail", A208WWPMailDetail);
         n208WWPMailDetail = ((GXutil.strcmp("", A208WWPMailDetail)==0) ? true : false) ;
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A37WWPNotificationId = 0 ;
            n37WWPNotificationId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         }
         else
         {
            A37WWPNotificationId = localUtil.ctol( httpContext.cgiGet( edtWWPNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            n37WWPNotificationId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         }
         n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
         A40WWPNotificationCreated = localUtil.ctot( httpContext.cgiGet( edtWWPNotificationCreated_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A42WWPMailId = GXutil.lval( httpContext.GetPar( "WWPMailId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
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
            /* Clear variables for new insertion. */
            initAll1139( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
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

   public void disable_std_buttons( )
   {
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes1139( ) ;
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_1140( )
   {
      nGXsfl_113_idx = 0 ;
      while ( nGXsfl_113_idx < nRC_GXsfl_113 )
      {
         readRow1140( ) ;
         if ( ( nRcdExists_40 != 0 ) || ( nIsMod_40 != 0 ) )
         {
            getKey1140( ) ;
            if ( ( nRcdExists_40 == 0 ) && ( nRcdDeleted_40 == 0 ) )
            {
               if ( RcdFound40 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1140( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1140( ) ;
                     closeExtendedTableCursors1140( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "WWPMAILATTACHMENTNAME_" + sGXsfl_113_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPMailAttachmentName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound40 != 0 )
               {
                  if ( nRcdDeleted_40 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1140( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1140( ) ;
                           closeExtendedTableCursors1140( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_40 == 0 )
                  {
                     GXCCtl = "WWPMAILATTACHMENTNAME_" + sGXsfl_113_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtWWPMailAttachmentName_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtWWPMailAttachmentName_Internalname, A43WWPMailAttachmentName) ;
         httpContext.changePostValue( edtWWPMailAttachmentFile_Internalname, A206WWPMailAttachmentFile) ;
         httpContext.changePostValue( "ZT_"+"Z43WWPMailAttachmentName_"+sGXsfl_113_idx, Z43WWPMailAttachmentName) ;
         httpContext.changePostValue( "nRcdDeleted_40_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_40_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_40_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_40 != 0 )
         {
            httpContext.changePostValue( "WWPMAILATTACHMENTNAME_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "WWPMAILATTACHMENTFILE_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentFile_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption110( )
   {
   }

   public void zm1139( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z191WWPMailSubject = T00115_A191WWPMailSubject[0] ;
            Z202WWPMailStatus = T00115_A202WWPMailStatus[0] ;
            Z211WWPMailCreated = T00115_A211WWPMailCreated[0] ;
            Z212WWPMailScheduled = T00115_A212WWPMailScheduled[0] ;
            Z207WWPMailProcessed = T00115_A207WWPMailProcessed[0] ;
            Z37WWPNotificationId = T00115_A37WWPNotificationId[0] ;
         }
         else
         {
            Z191WWPMailSubject = A191WWPMailSubject ;
            Z202WWPMailStatus = A202WWPMailStatus ;
            Z211WWPMailCreated = A211WWPMailCreated ;
            Z212WWPMailScheduled = A212WWPMailScheduled ;
            Z207WWPMailProcessed = A207WWPMailProcessed ;
            Z37WWPNotificationId = A37WWPNotificationId ;
         }
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (0==A202WWPMailStatus) && ( Gx_BScreen == 0 ) )
      {
         A202WWPMailStatus = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A211WWPMailCreated) && ( Gx_BScreen == 0 ) )
      {
         A211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A212WWPMailScheduled) && ( Gx_BScreen == 0 ) )
      {
         A212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load1139( )
   {
      /* Using cursor T00117 */
      pr_default.execute(5, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A191WWPMailSubject = T00117_A191WWPMailSubject[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A191WWPMailSubject", A191WWPMailSubject);
         A183WWPMailBody = T00117_A183WWPMailBody[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A183WWPMailBody", A183WWPMailBody);
         A192WWPMailTo = T00117_A192WWPMailTo[0] ;
         n192WWPMailTo = T00117_n192WWPMailTo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A192WWPMailTo", A192WWPMailTo);
         A204WWPMailCC = T00117_A204WWPMailCC[0] ;
         n204WWPMailCC = T00117_n204WWPMailCC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A204WWPMailCC", A204WWPMailCC);
         A205WWPMailBCC = T00117_A205WWPMailBCC[0] ;
         n205WWPMailBCC = T00117_n205WWPMailBCC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A205WWPMailBCC", A205WWPMailBCC);
         A193WWPMailSenderAddress = T00117_A193WWPMailSenderAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A193WWPMailSenderAddress", A193WWPMailSenderAddress);
         A194WWPMailSenderName = T00117_A194WWPMailSenderName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A194WWPMailSenderName", A194WWPMailSenderName);
         A202WWPMailStatus = T00117_A202WWPMailStatus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
         A211WWPMailCreated = T00117_A211WWPMailCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A212WWPMailScheduled = T00117_A212WWPMailScheduled[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A207WWPMailProcessed = T00117_A207WWPMailProcessed[0] ;
         n207WWPMailProcessed = T00117_n207WWPMailProcessed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A207WWPMailProcessed", localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A208WWPMailDetail = T00117_A208WWPMailDetail[0] ;
         n208WWPMailDetail = T00117_n208WWPMailDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A208WWPMailDetail", A208WWPMailDetail);
         A40WWPNotificationCreated = T00117_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A37WWPNotificationId = T00117_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T00117_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
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
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      if ( ! ( ( A202WWPMailStatus == 1 ) || ( A202WWPMailStatus == 2 ) || ( A202WWPMailStatus == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Status", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPMAILSTATUS");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbWWPMailStatus.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A211WWPMailCreated) || (( A211WWPMailCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A211WWPMailCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Created", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPMAILCREATED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailCreated_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A212WWPMailScheduled) || (( A212WWPMailScheduled.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A212WWPMailScheduled, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Scheduled", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPMAILSCHEDULED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailScheduled_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A207WWPMailProcessed) || (( A207WWPMailProcessed.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A207WWPMailProcessed, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Mail Processed", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPMAILPROCESSED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailProcessed_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00116 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A40WWPNotificationCreated = T00116_A40WWPNotificationCreated[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      pr_default.close(4);
   }

   public void closeExtendedTableCursors1139( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( long A37WWPNotificationId )
   {
      /* Using cursor T00118 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A40WWPNotificationCreated = T00118_A40WWPNotificationCreated[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1139( )
   {
      /* Using cursor T00119 */
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
      /* Using cursor T00115 */
      pr_default.execute(3, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm1139( 8) ;
         RcdFound39 = (short)(1) ;
         A42WWPMailId = T00115_A42WWPMailId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
         A191WWPMailSubject = T00115_A191WWPMailSubject[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A191WWPMailSubject", A191WWPMailSubject);
         A183WWPMailBody = T00115_A183WWPMailBody[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A183WWPMailBody", A183WWPMailBody);
         A192WWPMailTo = T00115_A192WWPMailTo[0] ;
         n192WWPMailTo = T00115_n192WWPMailTo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A192WWPMailTo", A192WWPMailTo);
         A204WWPMailCC = T00115_A204WWPMailCC[0] ;
         n204WWPMailCC = T00115_n204WWPMailCC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A204WWPMailCC", A204WWPMailCC);
         A205WWPMailBCC = T00115_A205WWPMailBCC[0] ;
         n205WWPMailBCC = T00115_n205WWPMailBCC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A205WWPMailBCC", A205WWPMailBCC);
         A193WWPMailSenderAddress = T00115_A193WWPMailSenderAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A193WWPMailSenderAddress", A193WWPMailSenderAddress);
         A194WWPMailSenderName = T00115_A194WWPMailSenderName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A194WWPMailSenderName", A194WWPMailSenderName);
         A202WWPMailStatus = T00115_A202WWPMailStatus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
         A211WWPMailCreated = T00115_A211WWPMailCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A212WWPMailScheduled = T00115_A212WWPMailScheduled[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A207WWPMailProcessed = T00115_A207WWPMailProcessed[0] ;
         n207WWPMailProcessed = T00115_n207WWPMailProcessed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A207WWPMailProcessed", localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A208WWPMailDetail = T00115_A208WWPMailDetail[0] ;
         n208WWPMailDetail = T00115_n208WWPMailDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A208WWPMailDetail", A208WWPMailDetail);
         A37WWPNotificationId = T00115_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T00115_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         Z42WWPMailId = A42WWPMailId ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1139( ) ;
         if ( AnyError == 1 )
         {
            RcdFound39 = (short)(0) ;
            initializeNonKey1139( ) ;
         }
         Gx_mode = sMode39 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound39 = (short)(0) ;
         initializeNonKey1139( ) ;
         sMode39 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode39 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey1139( ) ;
      if ( RcdFound39 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound39 = (short)(0) ;
      /* Using cursor T001110 */
      pr_default.execute(8, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001110_A42WWPMailId[0] < A42WWPMailId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001110_A42WWPMailId[0] > A42WWPMailId ) ) )
         {
            A42WWPMailId = T001110_A42WWPMailId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
            RcdFound39 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound39 = (short)(0) ;
      /* Using cursor T001111 */
      pr_default.execute(9, new Object[] {Long.valueOf(A42WWPMailId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001111_A42WWPMailId[0] > A42WWPMailId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001111_A42WWPMailId[0] < A42WWPMailId ) ) )
         {
            A42WWPMailId = T001111_A42WWPMailId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
            RcdFound39 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1139( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPMailId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1139( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound39 == 1 )
         {
            if ( A42WWPMailId != Z42WWPMailId )
            {
               A42WWPMailId = Z42WWPMailId ;
               httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPMAILID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPMailId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPMailId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1139( ) ;
               GX_FocusControl = edtWWPMailId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A42WWPMailId != Z42WWPMailId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPMailId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1139( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPMAILID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPMailId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPMailId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1139( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void btn_delete( )
   {
      if ( A42WWPMailId != Z42WWPMailId )
      {
         A42WWPMailId = Z42WWPMailId ;
         httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPMAILID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPMailId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPMAILID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtWWPMailSubject_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart1139( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailSubject_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1139( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailSubject_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailSubject_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart1139( ) ;
      if ( RcdFound39 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound39 != 0 )
         {
            scanNext1139( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailSubject_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1139( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1139( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00114 */
         pr_default.execute(2, new Object[] {Long.valueOf(A42WWPMailId)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Mail"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z191WWPMailSubject, T00114_A191WWPMailSubject[0]) != 0 ) || ( Z202WWPMailStatus != T00114_A202WWPMailStatus[0] ) || !( GXutil.dateCompare(Z211WWPMailCreated, T00114_A211WWPMailCreated[0]) ) || !( GXutil.dateCompare(Z212WWPMailScheduled, T00114_A212WWPMailScheduled[0]) ) || !( GXutil.dateCompare(Z207WWPMailProcessed, T00114_A207WWPMailProcessed[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z37WWPNotificationId != T00114_A37WWPNotificationId[0] ) )
         {
            if ( GXutil.strcmp(Z191WWPMailSubject, T00114_A191WWPMailSubject[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mail:[seudo value changed for attri]"+"WWPMailSubject");
               GXutil.writeLogRaw("Old: ",Z191WWPMailSubject);
               GXutil.writeLogRaw("Current: ",T00114_A191WWPMailSubject[0]);
            }
            if ( Z202WWPMailStatus != T00114_A202WWPMailStatus[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mail:[seudo value changed for attri]"+"WWPMailStatus");
               GXutil.writeLogRaw("Old: ",Z202WWPMailStatus);
               GXutil.writeLogRaw("Current: ",T00114_A202WWPMailStatus[0]);
            }
            if ( !( GXutil.dateCompare(Z211WWPMailCreated, T00114_A211WWPMailCreated[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mail:[seudo value changed for attri]"+"WWPMailCreated");
               GXutil.writeLogRaw("Old: ",Z211WWPMailCreated);
               GXutil.writeLogRaw("Current: ",T00114_A211WWPMailCreated[0]);
            }
            if ( !( GXutil.dateCompare(Z212WWPMailScheduled, T00114_A212WWPMailScheduled[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mail:[seudo value changed for attri]"+"WWPMailScheduled");
               GXutil.writeLogRaw("Old: ",Z212WWPMailScheduled);
               GXutil.writeLogRaw("Current: ",T00114_A212WWPMailScheduled[0]);
            }
            if ( !( GXutil.dateCompare(Z207WWPMailProcessed, T00114_A207WWPMailProcessed[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mail:[seudo value changed for attri]"+"WWPMailProcessed");
               GXutil.writeLogRaw("Old: ",Z207WWPMailProcessed);
               GXutil.writeLogRaw("Current: ",T00114_A207WWPMailProcessed[0]);
            }
            if ( Z37WWPNotificationId != T00114_A37WWPNotificationId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mail:[seudo value changed for attri]"+"WWPNotificationId");
               GXutil.writeLogRaw("Old: ",Z37WWPNotificationId);
               GXutil.writeLogRaw("Current: ",T00114_A37WWPNotificationId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Mail"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1139( )
   {
      if ( ! IsAuthorized("wwpmail_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
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
                  /* Using cursor T001112 */
                  pr_default.execute(10, new Object[] {A191WWPMailSubject, A183WWPMailBody, Boolean.valueOf(n192WWPMailTo), A192WWPMailTo, Boolean.valueOf(n204WWPMailCC), A204WWPMailCC, Boolean.valueOf(n205WWPMailBCC), A205WWPMailBCC, A193WWPMailSenderAddress, A194WWPMailSenderName, Short.valueOf(A202WWPMailStatus), A211WWPMailCreated, A212WWPMailScheduled, Boolean.valueOf(n207WWPMailProcessed), A207WWPMailProcessed, Boolean.valueOf(n208WWPMailDetail), A208WWPMailDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  A42WWPMailId = T001112_A42WWPMailId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
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
                           resetCaption110( ) ;
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
      if ( ! IsAuthorized("wwpmail_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
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
                  /* Using cursor T001113 */
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
                           resetCaption110( ) ;
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
      if ( ! IsAuthorized("wwpmail_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
               scanStart1140( ) ;
               while ( RcdFound40 != 0 )
               {
                  getByPrimaryKey1140( ) ;
                  delete1140( ) ;
                  scanNext1140( ) ;
               }
               scanEnd1140( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001114 */
                  pr_default.execute(12, new Object[] {Long.valueOf(A42WWPMailId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Mail");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound39 == 0 )
                        {
                           initAll1139( ) ;
                           Gx_mode = "INS" ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        }
                        else
                        {
                           getByPrimaryKey( ) ;
                           Gx_mode = "UPD" ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        }
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                        endTrnMsgCod = "SuccessfullyDeleted" ;
                        resetCaption110( ) ;
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1139( ) ;
      Gx_mode = sMode39 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1139( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001115 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         A40WWPNotificationCreated = T001115_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         pr_default.close(13);
      }
   }

   public void processNestedLevel1140( )
   {
      nGXsfl_113_idx = 0 ;
      while ( nGXsfl_113_idx < nRC_GXsfl_113 )
      {
         readRow1140( ) ;
         if ( ( nRcdExists_40 != 0 ) || ( nIsMod_40 != 0 ) )
         {
            standaloneNotModal1140( ) ;
            getKey1140( ) ;
            if ( ( nRcdExists_40 == 0 ) && ( nRcdDeleted_40 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1140( ) ;
            }
            else
            {
               if ( RcdFound40 != 0 )
               {
                  if ( ( nRcdDeleted_40 != 0 ) && ( nRcdExists_40 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1140( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_40 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1140( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_40 == 0 )
                  {
                     GXCCtl = "WWPMAILATTACHMENTNAME_" + sGXsfl_113_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtWWPMailAttachmentName_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtWWPMailAttachmentName_Internalname, A43WWPMailAttachmentName) ;
         httpContext.changePostValue( edtWWPMailAttachmentFile_Internalname, A206WWPMailAttachmentFile) ;
         httpContext.changePostValue( "ZT_"+"Z43WWPMailAttachmentName_"+sGXsfl_113_idx, Z43WWPMailAttachmentName) ;
         httpContext.changePostValue( "nRcdDeleted_40_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_40_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_40_"+sGXsfl_113_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_40 != 0 )
         {
            httpContext.changePostValue( "WWPMAILATTACHMENTNAME_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "WWPMAILATTACHMENTFILE_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentFile_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
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
      nRcdDeleted_40 = (short)(0) ;
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1139( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1139( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(13);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.mail.wwp_mail");
         if ( AnyError == 0 )
         {
            confirmValues110( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(13);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.mail.wwp_mail");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1139( )
   {
      /* Using cursor T001116 */
      pr_default.execute(14);
      RcdFound39 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A42WWPMailId = T001116_A42WWPMailId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1139( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound39 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound39 = (short)(1) ;
         A42WWPMailId = T001116_A42WWPMailId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
      }
   }

   public void scanEnd1139( )
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
      edtWWPMailId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailId_Enabled), 5, 0), true);
      edtWWPMailSubject_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailSubject_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailSubject_Enabled), 5, 0), true);
      edtWWPMailBody_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailBody_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailBody_Enabled), 5, 0), true);
      edtWWPMailTo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTo_Enabled), 5, 0), true);
      edtWWPMailCC_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailCC_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailCC_Enabled), 5, 0), true);
      edtWWPMailBCC_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailBCC_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailBCC_Enabled), 5, 0), true);
      edtWWPMailSenderAddress_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailSenderAddress_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailSenderAddress_Enabled), 5, 0), true);
      edtWWPMailSenderName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailSenderName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailSenderName_Enabled), 5, 0), true);
      cmbWWPMailStatus.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPMailStatus.getInternalname(), "Enabled", GXutil.ltrimstr( cmbWWPMailStatus.getEnabled(), 5, 0), true);
      edtWWPMailCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailCreated_Enabled), 5, 0), true);
      edtWWPMailScheduled_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailScheduled_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailScheduled_Enabled), 5, 0), true);
      edtWWPMailProcessed_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailProcessed_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailProcessed_Enabled), 5, 0), true);
      edtWWPMailDetail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailDetail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailDetail_Enabled), 5, 0), true);
      edtWWPNotificationId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Enabled), 5, 0), true);
      edtWWPNotificationCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationCreated_Enabled), 5, 0), true);
   }

   public void zm1140( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
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
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtWWPMailAttachmentName_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentName_Enabled), 5, 0), !bGXsfl_113_Refreshing);
      }
      else
      {
         edtWWPMailAttachmentName_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentName_Enabled), 5, 0), !bGXsfl_113_Refreshing);
      }
   }

   public void load1140( )
   {
      /* Using cursor T001117 */
      pr_default.execute(15, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A206WWPMailAttachmentFile = T001117_A206WWPMailAttachmentFile[0] ;
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal1140( ) ;
   }

   public void closeExtendedTableCursors1140( )
   {
   }

   public void enableDisable1140( )
   {
   }

   public void getKey1140( )
   {
      /* Using cursor T001118 */
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
      /* Using cursor T00113 */
      pr_default.execute(1, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1140( 10) ;
         RcdFound40 = (short)(1) ;
         initializeNonKey1140( ) ;
         A43WWPMailAttachmentName = T00113_A43WWPMailAttachmentName[0] ;
         A206WWPMailAttachmentFile = T00113_A206WWPMailAttachmentFile[0] ;
         Z42WWPMailId = A42WWPMailId ;
         Z43WWPMailAttachmentName = A43WWPMailAttachmentName ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1140( ) ;
         load1140( ) ;
         Gx_mode = sMode40 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound40 = (short)(0) ;
         initializeNonKey1140( ) ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1140( ) ;
         Gx_mode = sMode40 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1140( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1140( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00112 */
         pr_default.execute(0, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailAttachments"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_MailAttachments"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1140( )
   {
      if ( ! IsAuthorized("wwpmail_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
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
                  /* Using cursor T001119 */
                  pr_default.execute(17, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName, A206WWPMailAttachmentFile});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailAttachments");
                  if ( (pr_default.getStatus(17) == 1) )
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
      if ( ! IsAuthorized("wwpmail_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1140( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1140( ) ;
      }
      if ( ( nIsMod_40 != 0 ) || ( nIsDirty_40 != 0 ) )
      {
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
                     /* Using cursor T001120 */
                     pr_default.execute(18, new Object[] {A206WWPMailAttachmentFile, Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailAttachments");
                     if ( (pr_default.getStatus(18) == 103) )
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
      }
      closeExtendedTableCursors1140( ) ;
   }

   public void deferredUpdate1140( )
   {
   }

   public void delete1140( )
   {
      if ( ! IsAuthorized("wwpmail_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
               /* Using cursor T001121 */
               pr_default.execute(19, new Object[] {Long.valueOf(A42WWPMailId), A43WWPMailAttachmentName});
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1140( ) ;
      Gx_mode = sMode40 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1140( )
   {
      /* Scan By routine */
      /* Using cursor T001122 */
      pr_default.execute(20, new Object[] {Long.valueOf(A42WWPMailId)});
      RcdFound40 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A43WWPMailAttachmentName = T001122_A43WWPMailAttachmentName[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1140( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound40 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A43WWPMailAttachmentName = T001122_A43WWPMailAttachmentName[0] ;
      }
   }

   public void scanEnd1140( )
   {
      pr_default.close(20);
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
      edtWWPMailAttachmentName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentName_Enabled), 5, 0), !bGXsfl_113_Refreshing);
      edtWWPMailAttachmentFile_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentFile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentFile_Enabled), 5, 0), !bGXsfl_113_Refreshing);
   }

   public void send_integrity_lvl_hashes1140( )
   {
   }

   public void send_integrity_lvl_hashes1139( )
   {
   }

   public void subsflControlProps_11340( )
   {
      edtWWPMailAttachmentName_Internalname = "WWPMAILATTACHMENTNAME_"+sGXsfl_113_idx ;
      edtWWPMailAttachmentFile_Internalname = "WWPMAILATTACHMENTFILE_"+sGXsfl_113_idx ;
   }

   public void subsflControlProps_fel_11340( )
   {
      edtWWPMailAttachmentName_Internalname = "WWPMAILATTACHMENTNAME_"+sGXsfl_113_fel_idx ;
      edtWWPMailAttachmentFile_Internalname = "WWPMAILATTACHMENTFILE_"+sGXsfl_113_fel_idx ;
   }

   public void addRow1140( )
   {
      nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_11340( ) ;
      sendRow1140( ) ;
   }

   public void sendRow1140( )
   {
      Gridwwp_mail_attachmentsRow = GXWebRow.GetNew(context) ;
      if ( subGridwwp_mail_attachments_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridwwp_mail_attachments_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridwwp_mail_attachments_Class, "") != 0 )
         {
            subGridwwp_mail_attachments_Linesclass = subGridwwp_mail_attachments_Class+"Odd" ;
         }
      }
      else if ( subGridwwp_mail_attachments_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridwwp_mail_attachments_Backstyle = (byte)(0) ;
         subGridwwp_mail_attachments_Backcolor = subGridwwp_mail_attachments_Allbackcolor ;
         if ( GXutil.strcmp(subGridwwp_mail_attachments_Class, "") != 0 )
         {
            subGridwwp_mail_attachments_Linesclass = subGridwwp_mail_attachments_Class+"Uniform" ;
         }
      }
      else if ( subGridwwp_mail_attachments_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridwwp_mail_attachments_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridwwp_mail_attachments_Class, "") != 0 )
         {
            subGridwwp_mail_attachments_Linesclass = subGridwwp_mail_attachments_Class+"Odd" ;
         }
         subGridwwp_mail_attachments_Backcolor = (int)(0x0) ;
      }
      else if ( subGridwwp_mail_attachments_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridwwp_mail_attachments_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_113_idx) % (2))) == 0 )
         {
            subGridwwp_mail_attachments_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridwwp_mail_attachments_Class, "") != 0 )
            {
               subGridwwp_mail_attachments_Linesclass = subGridwwp_mail_attachments_Class+"Even" ;
            }
         }
         else
         {
            subGridwwp_mail_attachments_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridwwp_mail_attachments_Class, "") != 0 )
            {
               subGridwwp_mail_attachments_Linesclass = subGridwwp_mail_attachments_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_40_" + sGXsfl_113_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 114,'',false,'" + sGXsfl_113_idx + "',113)\"" ;
      ROClassString = "Attribute" ;
      Gridwwp_mail_attachmentsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtWWPMailAttachmentName_Internalname,A43WWPMailAttachmentName,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,114);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtWWPMailAttachmentName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtWWPMailAttachmentName_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(113),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_40_" + sGXsfl_113_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 115,'',false,'" + sGXsfl_113_idx + "',113)\"" ;
      ROClassString = "Attribute" ;
      Gridwwp_mail_attachmentsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtWWPMailAttachmentFile_Internalname,A206WWPMailAttachmentFile,A206WWPMailAttachmentFile,TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,115);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtWWPMailAttachmentFile_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtWWPMailAttachmentFile_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(113),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridwwp_mail_attachmentsRow);
      send_integrity_lvl_hashes1140( ) ;
      GXCCtl = "Z43WWPMailAttachmentName_" + sGXsfl_113_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z43WWPMailAttachmentName);
      GXCCtl = "nRcdDeleted_40_" + sGXsfl_113_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_40_" + sGXsfl_113_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_40_" + sGXsfl_113_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_40, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPMAILATTACHMENTNAME_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentName_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPMAILATTACHMENTFILE_"+sGXsfl_113_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentFile_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridwwp_mail_attachmentsContainer.AddRow(Gridwwp_mail_attachmentsRow);
   }

   public void readRow1140( )
   {
      nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_11340( ) ;
      edtWWPMailAttachmentName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "WWPMAILATTACHMENTNAME_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtWWPMailAttachmentFile_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "WWPMAILATTACHMENTFILE_"+sGXsfl_113_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A43WWPMailAttachmentName = httpContext.cgiGet( edtWWPMailAttachmentName_Internalname) ;
      A206WWPMailAttachmentFile = httpContext.cgiGet( edtWWPMailAttachmentFile_Internalname) ;
      GXCCtl = "Z43WWPMailAttachmentName_" + sGXsfl_113_idx ;
      Z43WWPMailAttachmentName = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_40_" + sGXsfl_113_idx ;
      nRcdDeleted_40 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_40_" + sGXsfl_113_idx ;
      nRcdExists_40 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_40_" + sGXsfl_113_idx ;
      nIsMod_40 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtWWPMailAttachmentName_Enabled = edtWWPMailAttachmentName_Enabled ;
   }

   public void confirmValues110( )
   {
      nGXsfl_113_idx = 0 ;
      sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_11340( ) ;
      while ( nGXsfl_113_idx < nRC_GXsfl_113 )
      {
         nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
         sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_11340( ) ;
         httpContext.changePostValue( "Z43WWPMailAttachmentName_"+sGXsfl_113_idx, httpContext.cgiGet( "ZT_"+"Z43WWPMailAttachmentName_"+sGXsfl_113_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z43WWPMailAttachmentName_"+sGXsfl_113_idx) ;
      }
   }

   public void renderHtmlHeaders( )
   {
      com.mujermorena.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.mail.wwp_mail", new String[] {}, new String[] {}) +"\">") ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z42WWPMailId", GXutil.ltrim( localUtil.ntoc( Z42WWPMailId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z191WWPMailSubject", Z191WWPMailSubject);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z202WWPMailStatus", GXutil.ltrim( localUtil.ntoc( Z202WWPMailStatus, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z211WWPMailCreated", localUtil.ttoc( Z211WWPMailCreated, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z212WWPMailScheduled", localUtil.ttoc( Z212WWPMailScheduled, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z207WWPMailProcessed", localUtil.ttoc( Z207WWPMailProcessed, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_113", GXutil.ltrim( localUtil.ntoc( nGXsfl_113_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.mujermorena.wwpbaseobjects.mail.wwp_mail", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Mail.WWP_Mail" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Mail", "") ;
   }

   public void initializeNonKey1139( )
   {
      A191WWPMailSubject = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A191WWPMailSubject", A191WWPMailSubject);
      A183WWPMailBody = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A183WWPMailBody", A183WWPMailBody);
      A192WWPMailTo = "" ;
      n192WWPMailTo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A192WWPMailTo", A192WWPMailTo);
      n192WWPMailTo = ((GXutil.strcmp("", A192WWPMailTo)==0) ? true : false) ;
      A204WWPMailCC = "" ;
      n204WWPMailCC = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A204WWPMailCC", A204WWPMailCC);
      n204WWPMailCC = ((GXutil.strcmp("", A204WWPMailCC)==0) ? true : false) ;
      A205WWPMailBCC = "" ;
      n205WWPMailBCC = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A205WWPMailBCC", A205WWPMailBCC);
      n205WWPMailBCC = ((GXutil.strcmp("", A205WWPMailBCC)==0) ? true : false) ;
      A193WWPMailSenderAddress = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A193WWPMailSenderAddress", A193WWPMailSenderAddress);
      A194WWPMailSenderName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A194WWPMailSenderName", A194WWPMailSenderName);
      A207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      n207WWPMailProcessed = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A207WWPMailProcessed", localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      n207WWPMailProcessed = (GXutil.dateCompare(GXutil.nullDate(), A207WWPMailProcessed) ? true : false) ;
      A208WWPMailDetail = "" ;
      n208WWPMailDetail = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A208WWPMailDetail", A208WWPMailDetail);
      n208WWPMailDetail = ((GXutil.strcmp("", A208WWPMailDetail)==0) ? true : false) ;
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
      n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A202WWPMailStatus = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
      A211WWPMailCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A212WWPMailScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
      httpContext.ajax_rsp_assign_attri("", false, "A42WWPMailId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42WWPMailId), 10, 0));
      initializeNonKey1139( ) ;
   }

   public void standaloneModalInsert( )
   {
      A202WWPMailStatus = i202WWPMailStatus ;
      httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
      A211WWPMailCreated = i211WWPMailCreated ;
      httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A212WWPMailScheduled = i212WWPMailScheduled ;
      httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111104119", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/mail/wwp_mail.js", "?202412111104119", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties40( )
   {
      edtWWPMailAttachmentName_Enabled = defedtWWPMailAttachmentName_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailAttachmentName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailAttachmentName_Enabled), 5, 0), !bGXsfl_113_Refreshing);
   }

   public void startgridcontrol113( )
   {
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("GridName", "Gridwwp_mail_attachments");
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Header", subGridwwp_mail_attachments_Header);
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Class", "Grid");
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("CmpContext", "");
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("InMasterPage", "false");
      Gridwwp_mail_attachmentsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridwwp_mail_attachmentsColumn.AddObjectProperty("Value", A43WWPMailAttachmentName);
      Gridwwp_mail_attachmentsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddColumnProperties(Gridwwp_mail_attachmentsColumn);
      Gridwwp_mail_attachmentsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridwwp_mail_attachmentsColumn.AddObjectProperty("Value", A206WWPMailAttachmentFile);
      Gridwwp_mail_attachmentsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtWWPMailAttachmentFile_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddColumnProperties(Gridwwp_mail_attachmentsColumn);
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridwwp_mail_attachmentsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridwwp_mail_attachments_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtWWPMailId_Internalname = "WWPMAILID" ;
      edtWWPMailSubject_Internalname = "WWPMAILSUBJECT" ;
      edtWWPMailBody_Internalname = "WWPMAILBODY" ;
      edtWWPMailTo_Internalname = "WWPMAILTO" ;
      edtWWPMailCC_Internalname = "WWPMAILCC" ;
      edtWWPMailBCC_Internalname = "WWPMAILBCC" ;
      edtWWPMailSenderAddress_Internalname = "WWPMAILSENDERADDRESS" ;
      edtWWPMailSenderName_Internalname = "WWPMAILSENDERNAME" ;
      cmbWWPMailStatus.setInternalname( "WWPMAILSTATUS" );
      edtWWPMailCreated_Internalname = "WWPMAILCREATED" ;
      edtWWPMailScheduled_Internalname = "WWPMAILSCHEDULED" ;
      edtWWPMailProcessed_Internalname = "WWPMAILPROCESSED" ;
      edtWWPMailDetail_Internalname = "WWPMAILDETAIL" ;
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID" ;
      edtWWPNotificationCreated_Internalname = "WWPNOTIFICATIONCREATED" ;
      lblTitleattachments_Internalname = "TITLEATTACHMENTS" ;
      edtWWPMailAttachmentName_Internalname = "WWPMAILATTACHMENTNAME" ;
      edtWWPMailAttachmentFile_Internalname = "WWPMAILATTACHMENTFILE" ;
      divAttachmentstable_Internalname = "ATTACHMENTSTABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridwwp_mail_attachments_Internalname = "GRIDWWP_MAIL_ATTACHMENTS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridwwp_mail_attachments_Allowcollapsing = (byte)(0) ;
      subGridwwp_mail_attachments_Allowselection = (byte)(0) ;
      subGridwwp_mail_attachments_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Mail", "") );
      edtWWPMailAttachmentFile_Jsonclick = "" ;
      edtWWPMailAttachmentName_Jsonclick = "" ;
      subGridwwp_mail_attachments_Class = "Grid" ;
      subGridwwp_mail_attachments_Backcolorstyle = (byte)(0) ;
      edtWWPMailAttachmentFile_Enabled = 1 ;
      edtWWPMailAttachmentName_Enabled = 1 ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtWWPNotificationCreated_Jsonclick = "" ;
      edtWWPNotificationCreated_Enabled = 0 ;
      edtWWPNotificationId_Jsonclick = "" ;
      edtWWPNotificationId_Enabled = 1 ;
      edtWWPMailDetail_Enabled = 1 ;
      edtWWPMailProcessed_Jsonclick = "" ;
      edtWWPMailProcessed_Enabled = 1 ;
      edtWWPMailScheduled_Jsonclick = "" ;
      edtWWPMailScheduled_Enabled = 1 ;
      edtWWPMailCreated_Jsonclick = "" ;
      edtWWPMailCreated_Enabled = 1 ;
      cmbWWPMailStatus.setJsonclick( "" );
      cmbWWPMailStatus.setEnabled( 1 );
      edtWWPMailSenderName_Enabled = 1 ;
      edtWWPMailSenderAddress_Enabled = 1 ;
      edtWWPMailBCC_Enabled = 1 ;
      edtWWPMailCC_Enabled = 1 ;
      edtWWPMailTo_Enabled = 1 ;
      edtWWPMailBody_Enabled = 1 ;
      edtWWPMailSubject_Jsonclick = "" ;
      edtWWPMailSubject_Enabled = 1 ;
      edtWWPMailId_Jsonclick = "" ;
      edtWWPMailId_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridwwp_mail_attachments_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_11340( ) ;
      while ( nGXsfl_113_idx <= nRC_GXsfl_113 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1140( ) ;
         standaloneModal1140( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1140( ) ;
         nGXsfl_113_idx = (int)(nGXsfl_113_idx+1) ;
         sGXsfl_113_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_113_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_11340( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridwwp_mail_attachmentsContainer)) ;
      /* End function gxnrGridwwp_mail_attachments_newrow */
   }

   public void init_web_controls( )
   {
      cmbWWPMailStatus.setName( "WWPMAILSTATUS" );
      cmbWWPMailStatus.setWebtags( "" );
      cmbWWPMailStatus.addItem("1", httpContext.getMessage( "Pending", ""), (short)(0));
      cmbWWPMailStatus.addItem("2", httpContext.getMessage( "Sent", ""), (short)(0));
      cmbWWPMailStatus.addItem("3", httpContext.getMessage( "Error", ""), (short)(0));
      if ( cmbWWPMailStatus.getItemCount() > 0 )
      {
         if ( isIns( ) && (0==A202WWPMailStatus) )
         {
            A202WWPMailStatus = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0));
         }
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtWWPMailSubject_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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

   public void valid_Wwpmailid( )
   {
      A202WWPMailStatus = (short)(GXutil.lval( cmbWWPMailStatus.getValue())) ;
      cmbWWPMailStatus.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0) );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbWWPMailStatus.getItemCount() > 0 )
      {
         A202WWPMailStatus = (short)(GXutil.lval( cmbWWPMailStatus.getValidValue(GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0))))) ;
         cmbWWPMailStatus.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A202WWPMailStatus), 4, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPMailStatus.setValue( GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A191WWPMailSubject", A191WWPMailSubject);
      httpContext.ajax_rsp_assign_attri("", false, "A183WWPMailBody", A183WWPMailBody);
      httpContext.ajax_rsp_assign_attri("", false, "A192WWPMailTo", A192WWPMailTo);
      httpContext.ajax_rsp_assign_attri("", false, "A204WWPMailCC", A204WWPMailCC);
      httpContext.ajax_rsp_assign_attri("", false, "A205WWPMailBCC", A205WWPMailBCC);
      httpContext.ajax_rsp_assign_attri("", false, "A193WWPMailSenderAddress", A193WWPMailSenderAddress);
      httpContext.ajax_rsp_assign_attri("", false, "A194WWPMailSenderName", A194WWPMailSenderName);
      httpContext.ajax_rsp_assign_attri("", false, "A202WWPMailStatus", GXutil.ltrim( localUtil.ntoc( A202WWPMailStatus, (byte)(4), (byte)(0), ".", "")));
      cmbWWPMailStatus.setValue( GXutil.trim( GXutil.str( A202WWPMailStatus, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPMailStatus.getInternalname(), "Values", cmbWWPMailStatus.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A211WWPMailCreated", localUtil.ttoc( A211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A212WWPMailScheduled", localUtil.ttoc( A212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A207WWPMailProcessed", localUtil.ttoc( A207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A208WWPMailDetail", A208WWPMailDetail);
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z42WWPMailId", GXutil.ltrim( localUtil.ntoc( Z42WWPMailId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z191WWPMailSubject", Z191WWPMailSubject);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z183WWPMailBody", Z183WWPMailBody);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z192WWPMailTo", Z192WWPMailTo);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z204WWPMailCC", Z204WWPMailCC);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z205WWPMailBCC", Z205WWPMailBCC);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z193WWPMailSenderAddress", Z193WWPMailSenderAddress);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z194WWPMailSenderName", Z194WWPMailSenderName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z202WWPMailStatus", GXutil.ltrim( localUtil.ntoc( Z202WWPMailStatus, (byte)(4), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z211WWPMailCreated", localUtil.ttoc( Z211WWPMailCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z212WWPMailScheduled", localUtil.ttoc( Z212WWPMailScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z207WWPMailProcessed", localUtil.ttoc( Z207WWPMailProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z208WWPMailDetail", Z208WWPMailDetail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40WWPNotificationCreated", localUtil.ttoc( Z40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpnotificationid( )
   {
      n37WWPNotificationId = false ;
      /* Using cursor T001115 */
      pr_default.execute(13, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
         }
      }
      A40WWPNotificationCreated = T001115_A40WWPNotificationCreated[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_WWPMAILID","{handler:'valid_Wwpmailid',iparms:[{av:'A42WWPMailId',fld:'WWPMAILID',pic:'ZZZZZZZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbWWPMailStatus'},{av:'A202WWPMailStatus',fld:'WWPMAILSTATUS',pic:'ZZZ9'},{av:'A211WWPMailCreated',fld:'WWPMAILCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A212WWPMailScheduled',fld:'WWPMAILSCHEDULED',pic:'99/99/9999 99:99:99.999'}]");
      setEventMetadata("VALID_WWPMAILID",",oparms:[{av:'A191WWPMailSubject',fld:'WWPMAILSUBJECT',pic:''},{av:'A183WWPMailBody',fld:'WWPMAILBODY',pic:''},{av:'A192WWPMailTo',fld:'WWPMAILTO',pic:''},{av:'A204WWPMailCC',fld:'WWPMAILCC',pic:''},{av:'A205WWPMailBCC',fld:'WWPMAILBCC',pic:''},{av:'A193WWPMailSenderAddress',fld:'WWPMAILSENDERADDRESS',pic:''},{av:'A194WWPMailSenderName',fld:'WWPMAILSENDERNAME',pic:''},{av:'cmbWWPMailStatus'},{av:'A202WWPMailStatus',fld:'WWPMAILSTATUS',pic:'ZZZ9'},{av:'A211WWPMailCreated',fld:'WWPMAILCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A212WWPMailScheduled',fld:'WWPMAILSCHEDULED',pic:'99/99/9999 99:99:99.999'},{av:'A207WWPMailProcessed',fld:'WWPMAILPROCESSED',pic:'99/99/9999 99:99:99.999'},{av:'A208WWPMailDetail',fld:'WWPMAILDETAIL',pic:''},{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z42WWPMailId'},{av:'Z191WWPMailSubject'},{av:'Z183WWPMailBody'},{av:'Z192WWPMailTo'},{av:'Z204WWPMailCC'},{av:'Z205WWPMailBCC'},{av:'Z193WWPMailSenderAddress'},{av:'Z194WWPMailSenderName'},{av:'Z202WWPMailStatus'},{av:'Z211WWPMailCreated'},{av:'Z212WWPMailScheduled'},{av:'Z207WWPMailProcessed'},{av:'Z208WWPMailDetail'},{av:'Z37WWPNotificationId'},{av:'Z40WWPNotificationCreated'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_WWPMAILSTATUS","{handler:'valid_Wwpmailstatus',iparms:[]");
      setEventMetadata("VALID_WWPMAILSTATUS",",oparms:[]}");
      setEventMetadata("VALID_WWPMAILCREATED","{handler:'valid_Wwpmailcreated',iparms:[]");
      setEventMetadata("VALID_WWPMAILCREATED",",oparms:[]}");
      setEventMetadata("VALID_WWPMAILSCHEDULED","{handler:'valid_Wwpmailscheduled',iparms:[]");
      setEventMetadata("VALID_WWPMAILSCHEDULED",",oparms:[]}");
      setEventMetadata("VALID_WWPMAILPROCESSED","{handler:'valid_Wwpmailprocessed',iparms:[]");
      setEventMetadata("VALID_WWPMAILPROCESSED",",oparms:[]}");
      setEventMetadata("VALID_WWPNOTIFICATIONID","{handler:'valid_Wwpnotificationid',iparms:[{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'}]");
      setEventMetadata("VALID_WWPNOTIFICATIONID",",oparms:[{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'}]}");
      setEventMetadata("VALID_WWPMAILATTACHMENTNAME","{handler:'valid_Wwpmailattachmentname',iparms:[]");
      setEventMetadata("VALID_WWPMAILATTACHMENTNAME",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Wwpmailattachmentfile',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "wwpmail_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z191WWPMailSubject = "" ;
      Z211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      Z212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z43WWPMailAttachmentName = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      Gx_mode = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A191WWPMailSubject = "" ;
      A183WWPMailBody = "" ;
      A192WWPMailTo = "" ;
      A204WWPMailCC = "" ;
      A205WWPMailBCC = "" ;
      A193WWPMailSenderAddress = "" ;
      A194WWPMailSenderName = "" ;
      A211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      A212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      A207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      A208WWPMailDetail = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      lblTitleattachments_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridwwp_mail_attachmentsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode40 = "" ;
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A43WWPMailAttachmentName = "" ;
      A206WWPMailAttachmentFile = "" ;
      Z183WWPMailBody = "" ;
      Z192WWPMailTo = "" ;
      Z204WWPMailCC = "" ;
      Z205WWPMailBCC = "" ;
      Z193WWPMailSenderAddress = "" ;
      Z194WWPMailSenderName = "" ;
      Z208WWPMailDetail = "" ;
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      T00117_A42WWPMailId = new long[1] ;
      T00117_A191WWPMailSubject = new String[] {""} ;
      T00117_A183WWPMailBody = new String[] {""} ;
      T00117_A192WWPMailTo = new String[] {""} ;
      T00117_n192WWPMailTo = new boolean[] {false} ;
      T00117_A204WWPMailCC = new String[] {""} ;
      T00117_n204WWPMailCC = new boolean[] {false} ;
      T00117_A205WWPMailBCC = new String[] {""} ;
      T00117_n205WWPMailBCC = new boolean[] {false} ;
      T00117_A193WWPMailSenderAddress = new String[] {""} ;
      T00117_A194WWPMailSenderName = new String[] {""} ;
      T00117_A202WWPMailStatus = new short[1] ;
      T00117_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T00117_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T00117_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T00117_n207WWPMailProcessed = new boolean[] {false} ;
      T00117_A208WWPMailDetail = new String[] {""} ;
      T00117_n208WWPMailDetail = new boolean[] {false} ;
      T00117_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T00117_A37WWPNotificationId = new long[1] ;
      T00117_n37WWPNotificationId = new boolean[] {false} ;
      T00116_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T00118_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T00119_A42WWPMailId = new long[1] ;
      T00115_A42WWPMailId = new long[1] ;
      T00115_A191WWPMailSubject = new String[] {""} ;
      T00115_A183WWPMailBody = new String[] {""} ;
      T00115_A192WWPMailTo = new String[] {""} ;
      T00115_n192WWPMailTo = new boolean[] {false} ;
      T00115_A204WWPMailCC = new String[] {""} ;
      T00115_n204WWPMailCC = new boolean[] {false} ;
      T00115_A205WWPMailBCC = new String[] {""} ;
      T00115_n205WWPMailBCC = new boolean[] {false} ;
      T00115_A193WWPMailSenderAddress = new String[] {""} ;
      T00115_A194WWPMailSenderName = new String[] {""} ;
      T00115_A202WWPMailStatus = new short[1] ;
      T00115_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T00115_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T00115_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T00115_n207WWPMailProcessed = new boolean[] {false} ;
      T00115_A208WWPMailDetail = new String[] {""} ;
      T00115_n208WWPMailDetail = new boolean[] {false} ;
      T00115_A37WWPNotificationId = new long[1] ;
      T00115_n37WWPNotificationId = new boolean[] {false} ;
      sMode39 = "" ;
      T001110_A42WWPMailId = new long[1] ;
      T001111_A42WWPMailId = new long[1] ;
      T00114_A42WWPMailId = new long[1] ;
      T00114_A191WWPMailSubject = new String[] {""} ;
      T00114_A183WWPMailBody = new String[] {""} ;
      T00114_A192WWPMailTo = new String[] {""} ;
      T00114_n192WWPMailTo = new boolean[] {false} ;
      T00114_A204WWPMailCC = new String[] {""} ;
      T00114_n204WWPMailCC = new boolean[] {false} ;
      T00114_A205WWPMailBCC = new String[] {""} ;
      T00114_n205WWPMailBCC = new boolean[] {false} ;
      T00114_A193WWPMailSenderAddress = new String[] {""} ;
      T00114_A194WWPMailSenderName = new String[] {""} ;
      T00114_A202WWPMailStatus = new short[1] ;
      T00114_A211WWPMailCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T00114_A212WWPMailScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T00114_A207WWPMailProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T00114_n207WWPMailProcessed = new boolean[] {false} ;
      T00114_A208WWPMailDetail = new String[] {""} ;
      T00114_n208WWPMailDetail = new boolean[] {false} ;
      T00114_A37WWPNotificationId = new long[1] ;
      T00114_n37WWPNotificationId = new boolean[] {false} ;
      T001112_A42WWPMailId = new long[1] ;
      T001115_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T001116_A42WWPMailId = new long[1] ;
      Z206WWPMailAttachmentFile = "" ;
      T001117_A42WWPMailId = new long[1] ;
      T001117_A43WWPMailAttachmentName = new String[] {""} ;
      T001117_A206WWPMailAttachmentFile = new String[] {""} ;
      T001118_A42WWPMailId = new long[1] ;
      T001118_A43WWPMailAttachmentName = new String[] {""} ;
      T00113_A42WWPMailId = new long[1] ;
      T00113_A43WWPMailAttachmentName = new String[] {""} ;
      T00113_A206WWPMailAttachmentFile = new String[] {""} ;
      T00112_A42WWPMailId = new long[1] ;
      T00112_A43WWPMailAttachmentName = new String[] {""} ;
      T00112_A206WWPMailAttachmentFile = new String[] {""} ;
      T001122_A42WWPMailId = new long[1] ;
      T001122_A43WWPMailAttachmentName = new String[] {""} ;
      Gridwwp_mail_attachmentsRow = new com.genexus.webpanels.GXWebRow();
      subGridwwp_mail_attachments_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      i212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      Gridwwp_mail_attachmentsColumn = new com.genexus.webpanels.GXWebColumn();
      ZZ191WWPMailSubject = "" ;
      ZZ183WWPMailBody = "" ;
      ZZ192WWPMailTo = "" ;
      ZZ204WWPMailCC = "" ;
      ZZ205WWPMailBCC = "" ;
      ZZ193WWPMailSenderAddress = "" ;
      ZZ194WWPMailSenderName = "" ;
      ZZ211WWPMailCreated = GXutil.resetTime( GXutil.nullDate() );
      ZZ212WWPMailScheduled = GXutil.resetTime( GXutil.nullDate() );
      ZZ207WWPMailProcessed = GXutil.resetTime( GXutil.nullDate() );
      ZZ208WWPMailDetail = "" ;
      ZZ40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mail__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mail__default(),
         new Object[] {
             new Object[] {
            T00112_A42WWPMailId, T00112_A43WWPMailAttachmentName, T00112_A206WWPMailAttachmentFile
            }
            , new Object[] {
            T00113_A42WWPMailId, T00113_A43WWPMailAttachmentName, T00113_A206WWPMailAttachmentFile
            }
            , new Object[] {
            T00114_A42WWPMailId, T00114_A191WWPMailSubject, T00114_A183WWPMailBody, T00114_A192WWPMailTo, T00114_n192WWPMailTo, T00114_A204WWPMailCC, T00114_n204WWPMailCC, T00114_A205WWPMailBCC, T00114_n205WWPMailBCC, T00114_A193WWPMailSenderAddress,
            T00114_A194WWPMailSenderName, T00114_A202WWPMailStatus, T00114_A211WWPMailCreated, T00114_A212WWPMailScheduled, T00114_A207WWPMailProcessed, T00114_n207WWPMailProcessed, T00114_A208WWPMailDetail, T00114_n208WWPMailDetail, T00114_A37WWPNotificationId, T00114_n37WWPNotificationId
            }
            , new Object[] {
            T00115_A42WWPMailId, T00115_A191WWPMailSubject, T00115_A183WWPMailBody, T00115_A192WWPMailTo, T00115_n192WWPMailTo, T00115_A204WWPMailCC, T00115_n204WWPMailCC, T00115_A205WWPMailBCC, T00115_n205WWPMailBCC, T00115_A193WWPMailSenderAddress,
            T00115_A194WWPMailSenderName, T00115_A202WWPMailStatus, T00115_A211WWPMailCreated, T00115_A212WWPMailScheduled, T00115_A207WWPMailProcessed, T00115_n207WWPMailProcessed, T00115_A208WWPMailDetail, T00115_n208WWPMailDetail, T00115_A37WWPNotificationId, T00115_n37WWPNotificationId
            }
            , new Object[] {
            T00116_A40WWPNotificationCreated
            }
            , new Object[] {
            T00117_A42WWPMailId, T00117_A191WWPMailSubject, T00117_A183WWPMailBody, T00117_A192WWPMailTo, T00117_n192WWPMailTo, T00117_A204WWPMailCC, T00117_n204WWPMailCC, T00117_A205WWPMailBCC, T00117_n205WWPMailBCC, T00117_A193WWPMailSenderAddress,
            T00117_A194WWPMailSenderName, T00117_A202WWPMailStatus, T00117_A211WWPMailCreated, T00117_A212WWPMailScheduled, T00117_A207WWPMailProcessed, T00117_n207WWPMailProcessed, T00117_A208WWPMailDetail, T00117_n208WWPMailDetail, T00117_A40WWPNotificationCreated, T00117_A37WWPNotificationId,
            T00117_n37WWPNotificationId
            }
            , new Object[] {
            T00118_A40WWPNotificationCreated
            }
            , new Object[] {
            T00119_A42WWPMailId
            }
            , new Object[] {
            T001110_A42WWPMailId
            }
            , new Object[] {
            T001111_A42WWPMailId
            }
            , new Object[] {
            T001112_A42WWPMailId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001115_A40WWPNotificationCreated
            }
            , new Object[] {
            T001116_A42WWPMailId
            }
            , new Object[] {
            T001117_A42WWPMailId, T001117_A43WWPMailAttachmentName, T001117_A206WWPMailAttachmentFile
            }
            , new Object[] {
            T001118_A42WWPMailId, T001118_A43WWPMailAttachmentName
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001122_A42WWPMailId, T001122_A43WWPMailAttachmentName
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
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridwwp_mail_attachments_Backcolorstyle ;
   private byte subGridwwp_mail_attachments_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridwwp_mail_attachments_Allowselection ;
   private byte subGridwwp_mail_attachments_Allowhovering ;
   private byte subGridwwp_mail_attachments_Allowcollapsing ;
   private byte subGridwwp_mail_attachments_Collapsed ;
   private short Z202WWPMailStatus ;
   private short nRcdDeleted_40 ;
   private short nRcdExists_40 ;
   private short nIsMod_40 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A202WWPMailStatus ;
   private short nBlankRcdCount40 ;
   private short RcdFound40 ;
   private short nBlankRcdUsr40 ;
   private short RcdFound39 ;
   private short nIsDirty_39 ;
   private short nIsDirty_40 ;
   private short i202WWPMailStatus ;
   private short ZZ202WWPMailStatus ;
   private int nRC_GXsfl_113 ;
   private int nGXsfl_113_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPMailId_Enabled ;
   private int edtWWPMailSubject_Enabled ;
   private int edtWWPMailBody_Enabled ;
   private int edtWWPMailTo_Enabled ;
   private int edtWWPMailCC_Enabled ;
   private int edtWWPMailBCC_Enabled ;
   private int edtWWPMailSenderAddress_Enabled ;
   private int edtWWPMailSenderName_Enabled ;
   private int edtWWPMailCreated_Enabled ;
   private int edtWWPMailScheduled_Enabled ;
   private int edtWWPMailProcessed_Enabled ;
   private int edtWWPMailDetail_Enabled ;
   private int edtWWPNotificationId_Enabled ;
   private int edtWWPNotificationCreated_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtWWPMailAttachmentName_Enabled ;
   private int edtWWPMailAttachmentFile_Enabled ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridwwp_mail_attachments_Backcolor ;
   private int subGridwwp_mail_attachments_Allbackcolor ;
   private int defedtWWPMailAttachmentName_Enabled ;
   private int idxLst ;
   private int subGridwwp_mail_attachments_Selectedindex ;
   private int subGridwwp_mail_attachments_Selectioncolor ;
   private int subGridwwp_mail_attachments_Hoveringcolor ;
   private long Z42WWPMailId ;
   private long Z37WWPNotificationId ;
   private long A37WWPNotificationId ;
   private long A42WWPMailId ;
   private long GRIDWWP_MAIL_ATTACHMENTS_nFirstRecordOnPage ;
   private long ZZ42WWPMailId ;
   private long ZZ37WWPNotificationId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPMailId_Internalname ;
   private String sGXsfl_113_idx="0001" ;
   private String Gx_mode ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtWWPMailId_Jsonclick ;
   private String edtWWPMailSubject_Internalname ;
   private String edtWWPMailSubject_Jsonclick ;
   private String edtWWPMailBody_Internalname ;
   private String edtWWPMailTo_Internalname ;
   private String edtWWPMailCC_Internalname ;
   private String edtWWPMailBCC_Internalname ;
   private String edtWWPMailSenderAddress_Internalname ;
   private String edtWWPMailSenderName_Internalname ;
   private String edtWWPMailCreated_Internalname ;
   private String edtWWPMailCreated_Jsonclick ;
   private String edtWWPMailScheduled_Internalname ;
   private String edtWWPMailScheduled_Jsonclick ;
   private String edtWWPMailProcessed_Internalname ;
   private String edtWWPMailProcessed_Jsonclick ;
   private String edtWWPMailDetail_Internalname ;
   private String edtWWPNotificationId_Internalname ;
   private String edtWWPNotificationId_Jsonclick ;
   private String edtWWPNotificationCreated_Internalname ;
   private String edtWWPNotificationCreated_Jsonclick ;
   private String divAttachmentstable_Internalname ;
   private String lblTitleattachments_Internalname ;
   private String lblTitleattachments_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String sMode40 ;
   private String edtWWPMailAttachmentName_Internalname ;
   private String edtWWPMailAttachmentFile_Internalname ;
   private String sStyleString ;
   private String subGridwwp_mail_attachments_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sMode39 ;
   private String sGXsfl_113_fel_idx="0001" ;
   private String subGridwwp_mail_attachments_Class ;
   private String subGridwwp_mail_attachments_Linesclass ;
   private String ROClassString ;
   private String edtWWPMailAttachmentName_Jsonclick ;
   private String edtWWPMailAttachmentFile_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridwwp_mail_attachments_Header ;
   private java.util.Date Z211WWPMailCreated ;
   private java.util.Date Z212WWPMailScheduled ;
   private java.util.Date Z207WWPMailProcessed ;
   private java.util.Date A211WWPMailCreated ;
   private java.util.Date A212WWPMailScheduled ;
   private java.util.Date A207WWPMailProcessed ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date i211WWPMailCreated ;
   private java.util.Date i212WWPMailScheduled ;
   private java.util.Date ZZ211WWPMailCreated ;
   private java.util.Date ZZ212WWPMailScheduled ;
   private java.util.Date ZZ207WWPMailProcessed ;
   private java.util.Date ZZ40WWPNotificationCreated ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n37WWPNotificationId ;
   private boolean wbErr ;
   private boolean bGXsfl_113_Refreshing=false ;
   private boolean n207WWPMailProcessed ;
   private boolean n192WWPMailTo ;
   private boolean n204WWPMailCC ;
   private boolean n205WWPMailBCC ;
   private boolean n208WWPMailDetail ;
   private boolean Gx_longc ;
   private String A183WWPMailBody ;
   private String A192WWPMailTo ;
   private String A204WWPMailCC ;
   private String A205WWPMailBCC ;
   private String A193WWPMailSenderAddress ;
   private String A194WWPMailSenderName ;
   private String A208WWPMailDetail ;
   private String A206WWPMailAttachmentFile ;
   private String Z183WWPMailBody ;
   private String Z192WWPMailTo ;
   private String Z204WWPMailCC ;
   private String Z205WWPMailBCC ;
   private String Z193WWPMailSenderAddress ;
   private String Z194WWPMailSenderName ;
   private String Z208WWPMailDetail ;
   private String Z206WWPMailAttachmentFile ;
   private String ZZ183WWPMailBody ;
   private String ZZ192WWPMailTo ;
   private String ZZ204WWPMailCC ;
   private String ZZ205WWPMailBCC ;
   private String ZZ193WWPMailSenderAddress ;
   private String ZZ194WWPMailSenderName ;
   private String ZZ208WWPMailDetail ;
   private String Z191WWPMailSubject ;
   private String Z43WWPMailAttachmentName ;
   private String A191WWPMailSubject ;
   private String A43WWPMailAttachmentName ;
   private String ZZ191WWPMailSubject ;
   private com.genexus.webpanels.GXWebGrid Gridwwp_mail_attachmentsContainer ;
   private com.genexus.webpanels.GXWebRow Gridwwp_mail_attachmentsRow ;
   private com.genexus.webpanels.GXWebColumn Gridwwp_mail_attachmentsColumn ;
   private HTMLChoice cmbWWPMailStatus ;
   private IDataStoreProvider pr_default ;
   private long[] T00117_A42WWPMailId ;
   private String[] T00117_A191WWPMailSubject ;
   private String[] T00117_A183WWPMailBody ;
   private String[] T00117_A192WWPMailTo ;
   private boolean[] T00117_n192WWPMailTo ;
   private String[] T00117_A204WWPMailCC ;
   private boolean[] T00117_n204WWPMailCC ;
   private String[] T00117_A205WWPMailBCC ;
   private boolean[] T00117_n205WWPMailBCC ;
   private String[] T00117_A193WWPMailSenderAddress ;
   private String[] T00117_A194WWPMailSenderName ;
   private short[] T00117_A202WWPMailStatus ;
   private java.util.Date[] T00117_A211WWPMailCreated ;
   private java.util.Date[] T00117_A212WWPMailScheduled ;
   private java.util.Date[] T00117_A207WWPMailProcessed ;
   private boolean[] T00117_n207WWPMailProcessed ;
   private String[] T00117_A208WWPMailDetail ;
   private boolean[] T00117_n208WWPMailDetail ;
   private java.util.Date[] T00117_A40WWPNotificationCreated ;
   private long[] T00117_A37WWPNotificationId ;
   private boolean[] T00117_n37WWPNotificationId ;
   private java.util.Date[] T00116_A40WWPNotificationCreated ;
   private java.util.Date[] T00118_A40WWPNotificationCreated ;
   private long[] T00119_A42WWPMailId ;
   private long[] T00115_A42WWPMailId ;
   private String[] T00115_A191WWPMailSubject ;
   private String[] T00115_A183WWPMailBody ;
   private String[] T00115_A192WWPMailTo ;
   private boolean[] T00115_n192WWPMailTo ;
   private String[] T00115_A204WWPMailCC ;
   private boolean[] T00115_n204WWPMailCC ;
   private String[] T00115_A205WWPMailBCC ;
   private boolean[] T00115_n205WWPMailBCC ;
   private String[] T00115_A193WWPMailSenderAddress ;
   private String[] T00115_A194WWPMailSenderName ;
   private short[] T00115_A202WWPMailStatus ;
   private java.util.Date[] T00115_A211WWPMailCreated ;
   private java.util.Date[] T00115_A212WWPMailScheduled ;
   private java.util.Date[] T00115_A207WWPMailProcessed ;
   private boolean[] T00115_n207WWPMailProcessed ;
   private String[] T00115_A208WWPMailDetail ;
   private boolean[] T00115_n208WWPMailDetail ;
   private long[] T00115_A37WWPNotificationId ;
   private boolean[] T00115_n37WWPNotificationId ;
   private long[] T001110_A42WWPMailId ;
   private long[] T001111_A42WWPMailId ;
   private long[] T00114_A42WWPMailId ;
   private String[] T00114_A191WWPMailSubject ;
   private String[] T00114_A183WWPMailBody ;
   private String[] T00114_A192WWPMailTo ;
   private boolean[] T00114_n192WWPMailTo ;
   private String[] T00114_A204WWPMailCC ;
   private boolean[] T00114_n204WWPMailCC ;
   private String[] T00114_A205WWPMailBCC ;
   private boolean[] T00114_n205WWPMailBCC ;
   private String[] T00114_A193WWPMailSenderAddress ;
   private String[] T00114_A194WWPMailSenderName ;
   private short[] T00114_A202WWPMailStatus ;
   private java.util.Date[] T00114_A211WWPMailCreated ;
   private java.util.Date[] T00114_A212WWPMailScheduled ;
   private java.util.Date[] T00114_A207WWPMailProcessed ;
   private boolean[] T00114_n207WWPMailProcessed ;
   private String[] T00114_A208WWPMailDetail ;
   private boolean[] T00114_n208WWPMailDetail ;
   private long[] T00114_A37WWPNotificationId ;
   private boolean[] T00114_n37WWPNotificationId ;
   private long[] T001112_A42WWPMailId ;
   private java.util.Date[] T001115_A40WWPNotificationCreated ;
   private long[] T001116_A42WWPMailId ;
   private long[] T001117_A42WWPMailId ;
   private String[] T001117_A43WWPMailAttachmentName ;
   private String[] T001117_A206WWPMailAttachmentFile ;
   private long[] T001118_A42WWPMailId ;
   private String[] T001118_A43WWPMailAttachmentName ;
   private long[] T00113_A42WWPMailId ;
   private String[] T00113_A43WWPMailAttachmentName ;
   private String[] T00113_A206WWPMailAttachmentFile ;
   private long[] T00112_A42WWPMailId ;
   private String[] T00112_A43WWPMailAttachmentName ;
   private String[] T00112_A206WWPMailAttachmentFile ;
   private long[] T001122_A42WWPMailId ;
   private String[] T001122_A43WWPMailAttachmentName ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_mail__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_mail__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00112", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WITH (UPDLOCK) WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00113", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00114", "SELECT [WWPMailId], [WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId] FROM [WWP_Mail] WITH (UPDLOCK) WHERE [WWPMailId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00115", "SELECT [WWPMailId], [WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId] FROM [WWP_Mail] WHERE [WWPMailId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00116", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00117", "SELECT TM1.[WWPMailId], TM1.[WWPMailSubject], TM1.[WWPMailBody], TM1.[WWPMailTo], TM1.[WWPMailCC], TM1.[WWPMailBCC], TM1.[WWPMailSenderAddress], TM1.[WWPMailSenderName], TM1.[WWPMailStatus], TM1.[WWPMailCreated], TM1.[WWPMailScheduled], TM1.[WWPMailProcessed], TM1.[WWPMailDetail], T2.[WWPNotificationCreated], TM1.[WWPNotificationId] FROM ([WWP_Mail] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) WHERE TM1.[WWPMailId] = ? ORDER BY TM1.[WWPMailId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00118", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00119", "SELECT [WWPMailId] FROM [WWP_Mail] WHERE [WWPMailId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001110", "SELECT TOP 1 [WWPMailId] FROM [WWP_Mail] WHERE ( [WWPMailId] > ?) ORDER BY [WWPMailId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001111", "SELECT TOP 1 [WWPMailId] FROM [WWP_Mail] WHERE ( [WWPMailId] < ?) ORDER BY [WWPMailId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001112", "INSERT INTO [WWP_Mail]([WWPMailSubject], [WWPMailBody], [WWPMailTo], [WWPMailCC], [WWPMailBCC], [WWPMailSenderAddress], [WWPMailSenderName], [WWPMailStatus], [WWPMailCreated], [WWPMailScheduled], [WWPMailProcessed], [WWPMailDetail], [WWPNotificationId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001113", "UPDATE [WWP_Mail] SET [WWPMailSubject]=?, [WWPMailBody]=?, [WWPMailTo]=?, [WWPMailCC]=?, [WWPMailBCC]=?, [WWPMailSenderAddress]=?, [WWPMailSenderName]=?, [WWPMailStatus]=?, [WWPMailCreated]=?, [WWPMailScheduled]=?, [WWPMailProcessed]=?, [WWPMailDetail]=?, [WWPNotificationId]=?  WHERE [WWPMailId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001114", "DELETE FROM [WWP_Mail]  WHERE [WWPMailId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001115", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001116", "SELECT [WWPMailId] FROM [WWP_Mail] ORDER BY [WWPMailId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001117", "SELECT [WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? and [WWPMailAttachmentName] = ? ORDER BY [WWPMailId], [WWPMailAttachmentName] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001118", "SELECT [WWPMailId], [WWPMailAttachmentName] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001119", "INSERT INTO [WWP_MailAttachments]([WWPMailId], [WWPMailAttachmentName], [WWPMailAttachmentFile]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001120", "UPDATE [WWP_MailAttachments] SET [WWPMailAttachmentFile]=?  WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ?", GX_NOMASK)
         ,new UpdateCursor("T001121", "DELETE FROM [WWP_MailAttachments]  WHERE [WWPMailId] = ? AND [WWPMailAttachmentName] = ?", GX_NOMASK)
         ,new ForEachCursor("T001122", "SELECT [WWPMailId], [WWPMailAttachmentName] FROM [WWP_MailAttachments] WHERE [WWPMailId] = ? ORDER BY [WWPMailId], [WWPMailAttachmentName] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
            case 20 :
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
               stmt.setNLongVarchar(3, (String)parms[2], false);
               return;
            case 18 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

