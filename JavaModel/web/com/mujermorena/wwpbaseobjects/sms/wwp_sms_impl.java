package com.mujermorena.wwpbaseobjects.sms ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_sms_impl extends GXDataArea
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_SMS", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPSMSId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_sms_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_sms_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_sms_impl.class ));
   }

   public wwp_sms_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbWWPSMSStatus = new HTMLChoice();
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
      if ( cmbWWPSMSStatus.getItemCount() > 0 )
      {
         A158WWPSMSStatus = (short)(GXutil.lval( cmbWWPSMSStatus.getValidValue(GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPSMSStatus.setValue( GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbWWPSMSStatus.getInternalname(), "Values", cmbWWPSMSStatus.ToJavascriptSource(), true);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "WWP_SMS", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPSMSId_Internalname, GXutil.ltrim( localUtil.ntoc( A36WWPSMSId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPSMSId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A36WWPSMSId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A36WWPSMSId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPSMSId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPSMSId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSMessage_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSMessage_Internalname, httpContext.getMessage( "Message", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPSMSMessage_Internalname, A161WWPSMSMessage, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", (short)(0), 1, edtWWPSMSMessage_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSSenderNumber_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSSenderNumber_Internalname, httpContext.getMessage( "Sender Number", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPSMSSenderNumber_Internalname, A162WWPSMSSenderNumber, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", (short)(0), 1, edtWWPSMSSenderNumber_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSRecipientNumbers_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSRecipientNumbers_Internalname, httpContext.getMessage( "Recipient Numbers", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPSMSRecipientNumbers_Internalname, A163WWPSMSRecipientNumbers, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", (short)(0), 1, edtWWPSMSRecipientNumbers_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbWWPSMSStatus.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbWWPSMSStatus.getInternalname(), httpContext.getMessage( "Status", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbWWPSMSStatus, cmbWWPSMSStatus.getInternalname(), GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0)), 1, cmbWWPSMSStatus.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbWWPSMSStatus.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      cmbWWPSMSStatus.setValue( GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPSMSStatus.getInternalname(), "Values", cmbWWPSMSStatus.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSCreated_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSCreated_Internalname, httpContext.getMessage( "Created", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPSMSCreated_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPSMSCreated_Internalname, localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A164WWPSMSCreated, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPSMSCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPSMSCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPSMSCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPSMSCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSScheduled_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSScheduled_Internalname, httpContext.getMessage( "Scheduled", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPSMSScheduled_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPSMSScheduled_Internalname, localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A165WWPSMSScheduled, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPSMSScheduled_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPSMSScheduled_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPSMSScheduled_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPSMSScheduled_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSProcessed_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSProcessed_Internalname, httpContext.getMessage( "Processed", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPSMSProcessed_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPSMSProcessed_Internalname, localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A159WWPSMSProcessed, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPSMSProcessed_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPSMSProcessed_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPSMSProcessed_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPSMSProcessed_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSMSDetail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSMSDetail_Internalname, httpContext.getMessage( "Detail", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPSMSDetail_Internalname, A160WWPSMSDetail, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", (short)(0), 1, edtWWPSMSDetail_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationId_Internalname, GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationCreated_Internalname, localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A40WWPNotificationCreated, "99/99/9999 99:99:99.999"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPNotificationCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPNotificationCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      httpContext.writeTextNL( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SMS\\WWP_SMS.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         Z36WWPSMSId = localUtil.ctol( httpContext.cgiGet( "Z36WWPSMSId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z158WWPSMSStatus = (short)(localUtil.ctol( httpContext.cgiGet( "Z158WWPSMSStatus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z164WWPSMSCreated = localUtil.ctot( httpContext.cgiGet( "Z164WWPSMSCreated"), 0) ;
         Z165WWPSMSScheduled = localUtil.ctot( httpContext.cgiGet( "Z165WWPSMSScheduled"), 0) ;
         Z159WWPSMSProcessed = localUtil.ctot( httpContext.cgiGet( "Z159WWPSMSProcessed"), 0) ;
         n159WWPSMSProcessed = (GXutil.dateCompare(GXutil.nullDate(), A159WWPSMSProcessed) ? true : false) ;
         Z37WWPNotificationId = localUtil.ctol( httpContext.cgiGet( "Z37WWPNotificationId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPSMSId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPSMSId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPSMSID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPSMSId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A36WWPSMSId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
         }
         else
         {
            A36WWPSMSId = localUtil.ctol( httpContext.cgiGet( edtWWPSMSId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
         }
         A161WWPSMSMessage = httpContext.cgiGet( edtWWPSMSMessage_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A161WWPSMSMessage", A161WWPSMSMessage);
         A162WWPSMSSenderNumber = httpContext.cgiGet( edtWWPSMSSenderNumber_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A162WWPSMSSenderNumber", A162WWPSMSSenderNumber);
         A163WWPSMSRecipientNumbers = httpContext.cgiGet( edtWWPSMSRecipientNumbers_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A163WWPSMSRecipientNumbers", A163WWPSMSRecipientNumbers);
         cmbWWPSMSStatus.setValue( httpContext.cgiGet( cmbWWPSMSStatus.getInternalname()) );
         A158WWPSMSStatus = (short)(GXutil.lval( httpContext.cgiGet( cmbWWPSMSStatus.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPSMSCreated_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPSMSCREATED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPSMSCreated_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A164WWPSMSCreated = localUtil.ctot( httpContext.cgiGet( edtWWPSMSCreated_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPSMSScheduled_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPSMSSCHEDULED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPSMSScheduled_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A165WWPSMSScheduled = localUtil.ctot( httpContext.cgiGet( edtWWPSMSScheduled_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPSMSProcessed_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPSMSPROCESSED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPSMSProcessed_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
            n159WWPSMSProcessed = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A159WWPSMSProcessed", localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A159WWPSMSProcessed = localUtil.ctot( httpContext.cgiGet( edtWWPSMSProcessed_Internalname)) ;
            n159WWPSMSProcessed = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A159WWPSMSProcessed", localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         n159WWPSMSProcessed = (GXutil.dateCompare(GXutil.nullDate(), A159WWPSMSProcessed) ? true : false) ;
         A160WWPSMSDetail = httpContext.cgiGet( edtWWPSMSDetail_Internalname) ;
         n160WWPSMSDetail = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A160WWPSMSDetail", A160WWPSMSDetail);
         n160WWPSMSDetail = ((GXutil.strcmp("", A160WWPSMSDetail)==0) ? true : false) ;
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
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A36WWPSMSId = GXutil.lval( httpContext.GetPar( "WWPSMSId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
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
            initAll0V33( ) ;
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
      disableAttributes0V33( ) ;
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

   public void resetCaption0V0( )
   {
   }

   public void zm0V33( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z158WWPSMSStatus = T000V3_A158WWPSMSStatus[0] ;
            Z164WWPSMSCreated = T000V3_A164WWPSMSCreated[0] ;
            Z165WWPSMSScheduled = T000V3_A165WWPSMSScheduled[0] ;
            Z159WWPSMSProcessed = T000V3_A159WWPSMSProcessed[0] ;
            Z37WWPNotificationId = T000V3_A37WWPNotificationId[0] ;
         }
         else
         {
            Z158WWPSMSStatus = A158WWPSMSStatus ;
            Z164WWPSMSCreated = A164WWPSMSCreated ;
            Z165WWPSMSScheduled = A165WWPSMSScheduled ;
            Z159WWPSMSProcessed = A159WWPSMSProcessed ;
            Z37WWPNotificationId = A37WWPNotificationId ;
         }
      }
      if ( GX_JID == -8 )
      {
         Z36WWPSMSId = A36WWPSMSId ;
         Z161WWPSMSMessage = A161WWPSMSMessage ;
         Z162WWPSMSSenderNumber = A162WWPSMSSenderNumber ;
         Z163WWPSMSRecipientNumbers = A163WWPSMSRecipientNumbers ;
         Z158WWPSMSStatus = A158WWPSMSStatus ;
         Z164WWPSMSCreated = A164WWPSMSCreated ;
         Z165WWPSMSScheduled = A165WWPSMSScheduled ;
         Z159WWPSMSProcessed = A159WWPSMSProcessed ;
         Z160WWPSMSDetail = A160WWPSMSDetail ;
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
      if ( isIns( )  && (0==A158WWPSMSStatus) && ( Gx_BScreen == 0 ) )
      {
         A158WWPSMSStatus = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A164WWPSMSCreated) && ( Gx_BScreen == 0 ) )
      {
         A164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A165WWPSMSScheduled) && ( Gx_BScreen == 0 ) )
      {
         A165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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

   public void load0V33( )
   {
      /* Using cursor T000V5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A161WWPSMSMessage = T000V5_A161WWPSMSMessage[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A161WWPSMSMessage", A161WWPSMSMessage);
         A162WWPSMSSenderNumber = T000V5_A162WWPSMSSenderNumber[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162WWPSMSSenderNumber", A162WWPSMSSenderNumber);
         A163WWPSMSRecipientNumbers = T000V5_A163WWPSMSRecipientNumbers[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A163WWPSMSRecipientNumbers", A163WWPSMSRecipientNumbers);
         A158WWPSMSStatus = T000V5_A158WWPSMSStatus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
         A164WWPSMSCreated = T000V5_A164WWPSMSCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A165WWPSMSScheduled = T000V5_A165WWPSMSScheduled[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A159WWPSMSProcessed = T000V5_A159WWPSMSProcessed[0] ;
         n159WWPSMSProcessed = T000V5_n159WWPSMSProcessed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A159WWPSMSProcessed", localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A160WWPSMSDetail = T000V5_A160WWPSMSDetail[0] ;
         n160WWPSMSDetail = T000V5_n160WWPSMSDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A160WWPSMSDetail", A160WWPSMSDetail);
         A40WWPNotificationCreated = T000V5_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A37WWPNotificationId = T000V5_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000V5_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         zm0V33( -8) ;
      }
      pr_default.close(3);
      onLoadActions0V33( ) ;
   }

   public void onLoadActions0V33( )
   {
   }

   public void checkExtendedTable0V33( )
   {
      nIsDirty_33 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      if ( ! ( ( A158WWPSMSStatus == 1 ) || ( A158WWPSMSStatus == 2 ) || ( A158WWPSMSStatus == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Status", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPSMSSTATUS");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbWWPSMSStatus.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A164WWPSMSCreated) || (( A164WWPSMSCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A164WWPSMSCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Created", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPSMSCREATED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSMSCreated_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A165WWPSMSScheduled) || (( A165WWPSMSScheduled.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A165WWPSMSScheduled, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Scheduled", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPSMSSCHEDULED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSMSScheduled_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A159WWPSMSProcessed) || (( A159WWPSMSProcessed.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A159WWPSMSProcessed, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SMS Processed", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPSMSPROCESSED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSMSProcessed_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000V4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A40WWPNotificationCreated = T000V4_A40WWPNotificationCreated[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0V33( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( long A37WWPNotificationId )
   {
      /* Using cursor T000V6 */
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
      A40WWPNotificationCreated = T000V6_A40WWPNotificationCreated[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey0V33( )
   {
      /* Using cursor T000V7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound33 = (short)(1) ;
      }
      else
      {
         RcdFound33 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000V3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0V33( 8) ;
         RcdFound33 = (short)(1) ;
         A36WWPSMSId = T000V3_A36WWPSMSId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
         A161WWPSMSMessage = T000V3_A161WWPSMSMessage[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A161WWPSMSMessage", A161WWPSMSMessage);
         A162WWPSMSSenderNumber = T000V3_A162WWPSMSSenderNumber[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162WWPSMSSenderNumber", A162WWPSMSSenderNumber);
         A163WWPSMSRecipientNumbers = T000V3_A163WWPSMSRecipientNumbers[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A163WWPSMSRecipientNumbers", A163WWPSMSRecipientNumbers);
         A158WWPSMSStatus = T000V3_A158WWPSMSStatus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
         A164WWPSMSCreated = T000V3_A164WWPSMSCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A165WWPSMSScheduled = T000V3_A165WWPSMSScheduled[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A159WWPSMSProcessed = T000V3_A159WWPSMSProcessed[0] ;
         n159WWPSMSProcessed = T000V3_n159WWPSMSProcessed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A159WWPSMSProcessed", localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A160WWPSMSDetail = T000V3_A160WWPSMSDetail[0] ;
         n160WWPSMSDetail = T000V3_n160WWPSMSDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A160WWPSMSDetail", A160WWPSMSDetail);
         A37WWPNotificationId = T000V3_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000V3_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         Z36WWPSMSId = A36WWPSMSId ;
         sMode33 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0V33( ) ;
         if ( AnyError == 1 )
         {
            RcdFound33 = (short)(0) ;
            initializeNonKey0V33( ) ;
         }
         Gx_mode = sMode33 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound33 = (short)(0) ;
         initializeNonKey0V33( ) ;
         sMode33 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode33 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0V33( ) ;
      if ( RcdFound33 == 0 )
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
      RcdFound33 = (short)(0) ;
      /* Using cursor T000V8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T000V8_A36WWPSMSId[0] < A36WWPSMSId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T000V8_A36WWPSMSId[0] > A36WWPSMSId ) ) )
         {
            A36WWPSMSId = T000V8_A36WWPSMSId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
            RcdFound33 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound33 = (short)(0) ;
      /* Using cursor T000V9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A36WWPSMSId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000V9_A36WWPSMSId[0] > A36WWPSMSId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000V9_A36WWPSMSId[0] < A36WWPSMSId ) ) )
         {
            A36WWPSMSId = T000V9_A36WWPSMSId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
            RcdFound33 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0V33( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPSMSId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0V33( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound33 == 1 )
         {
            if ( A36WWPSMSId != Z36WWPSMSId )
            {
               A36WWPSMSId = Z36WWPSMSId ;
               httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPSMSID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPSMSId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPSMSId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0V33( ) ;
               GX_FocusControl = edtWWPSMSId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A36WWPSMSId != Z36WWPSMSId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPSMSId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0V33( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPSMSID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPSMSId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPSMSId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0V33( ) ;
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
      if ( A36WWPSMSId != Z36WWPSMSId )
      {
         A36WWPSMSId = Z36WWPSMSId ;
         httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPSMSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSMSId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPSMSId_Internalname ;
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
      if ( RcdFound33 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPSMSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSMSId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtWWPSMSMessage_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0V33( ) ;
      if ( RcdFound33 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPSMSMessage_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0V33( ) ;
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
      if ( RcdFound33 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPSMSMessage_Internalname ;
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
      if ( RcdFound33 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPSMSMessage_Internalname ;
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
      scanStart0V33( ) ;
      if ( RcdFound33 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound33 != 0 )
         {
            scanNext0V33( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPSMSMessage_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0V33( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0V33( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000V2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A36WWPSMSId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_SMS"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z158WWPSMSStatus != T000V2_A158WWPSMSStatus[0] ) || !( GXutil.dateCompare(Z164WWPSMSCreated, T000V2_A164WWPSMSCreated[0]) ) || !( GXutil.dateCompare(Z165WWPSMSScheduled, T000V2_A165WWPSMSScheduled[0]) ) || !( GXutil.dateCompare(Z159WWPSMSProcessed, T000V2_A159WWPSMSProcessed[0]) ) || ( Z37WWPNotificationId != T000V2_A37WWPNotificationId[0] ) )
         {
            if ( Z158WWPSMSStatus != T000V2_A158WWPSMSStatus[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.sms.wwp_sms:[seudo value changed for attri]"+"WWPSMSStatus");
               GXutil.writeLogRaw("Old: ",Z158WWPSMSStatus);
               GXutil.writeLogRaw("Current: ",T000V2_A158WWPSMSStatus[0]);
            }
            if ( !( GXutil.dateCompare(Z164WWPSMSCreated, T000V2_A164WWPSMSCreated[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.sms.wwp_sms:[seudo value changed for attri]"+"WWPSMSCreated");
               GXutil.writeLogRaw("Old: ",Z164WWPSMSCreated);
               GXutil.writeLogRaw("Current: ",T000V2_A164WWPSMSCreated[0]);
            }
            if ( !( GXutil.dateCompare(Z165WWPSMSScheduled, T000V2_A165WWPSMSScheduled[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.sms.wwp_sms:[seudo value changed for attri]"+"WWPSMSScheduled");
               GXutil.writeLogRaw("Old: ",Z165WWPSMSScheduled);
               GXutil.writeLogRaw("Current: ",T000V2_A165WWPSMSScheduled[0]);
            }
            if ( !( GXutil.dateCompare(Z159WWPSMSProcessed, T000V2_A159WWPSMSProcessed[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.sms.wwp_sms:[seudo value changed for attri]"+"WWPSMSProcessed");
               GXutil.writeLogRaw("Old: ",Z159WWPSMSProcessed);
               GXutil.writeLogRaw("Current: ",T000V2_A159WWPSMSProcessed[0]);
            }
            if ( Z37WWPNotificationId != T000V2_A37WWPNotificationId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.sms.wwp_sms:[seudo value changed for attri]"+"WWPNotificationId");
               GXutil.writeLogRaw("Old: ",Z37WWPNotificationId);
               GXutil.writeLogRaw("Current: ",T000V2_A37WWPNotificationId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_SMS"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0V33( )
   {
      if ( ! IsAuthorized("sms_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0V33( 0) ;
         checkOptimisticConcurrency0V33( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V33( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0V33( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000V10 */
                  pr_default.execute(8, new Object[] {A161WWPSMSMessage, A162WWPSMSSenderNumber, A163WWPSMSRecipientNumbers, Short.valueOf(A158WWPSMSStatus), A164WWPSMSCreated, A165WWPSMSScheduled, Boolean.valueOf(n159WWPSMSProcessed), A159WWPSMSProcessed, Boolean.valueOf(n160WWPSMSDetail), A160WWPSMSDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  A36WWPSMSId = T000V10_A36WWPSMSId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
                  pr_default.close(8);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_SMS");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0V0( ) ;
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
            load0V33( ) ;
         }
         endLevel0V33( ) ;
      }
      closeExtendedTableCursors0V33( ) ;
   }

   public void update0V33( )
   {
      if ( ! IsAuthorized("sms_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V33( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V33( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0V33( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000V11 */
                  pr_default.execute(9, new Object[] {A161WWPSMSMessage, A162WWPSMSSenderNumber, A163WWPSMSRecipientNumbers, Short.valueOf(A158WWPSMSStatus), A164WWPSMSCreated, A165WWPSMSScheduled, Boolean.valueOf(n159WWPSMSProcessed), A159WWPSMSProcessed, Boolean.valueOf(n160WWPSMSDetail), A160WWPSMSDetail, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId), Long.valueOf(A36WWPSMSId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_SMS");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_SMS"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0V33( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0V0( ) ;
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
         endLevel0V33( ) ;
      }
      closeExtendedTableCursors0V33( ) ;
   }

   public void deferredUpdate0V33( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("sms_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0V33( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0V33( ) ;
         afterConfirm0V33( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0V33( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000V12 */
               pr_default.execute(10, new Object[] {Long.valueOf(A36WWPSMSId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_SMS");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound33 == 0 )
                     {
                        initAll0V33( ) ;
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
                     resetCaption0V0( ) ;
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
      sMode33 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0V33( ) ;
      Gx_mode = sMode33 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0V33( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000V13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         A40WWPNotificationCreated = T000V13_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         pr_default.close(11);
      }
   }

   public void endLevel0V33( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0V33( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(11);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.sms.wwp_sms");
         if ( AnyError == 0 )
         {
            confirmValues0V0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(11);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.sms.wwp_sms");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0V33( )
   {
      /* Using cursor T000V14 */
      pr_default.execute(12);
      RcdFound33 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A36WWPSMSId = T000V14_A36WWPSMSId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0V33( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound33 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A36WWPSMSId = T000V14_A36WWPSMSId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
      }
   }

   public void scanEnd0V33( )
   {
      pr_default.close(12);
   }

   public void afterConfirm0V33( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0V33( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0V33( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0V33( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0V33( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0V33( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0V33( )
   {
      edtWWPSMSId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSId_Enabled), 5, 0), true);
      edtWWPSMSMessage_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSMessage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSMessage_Enabled), 5, 0), true);
      edtWWPSMSSenderNumber_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSSenderNumber_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSSenderNumber_Enabled), 5, 0), true);
      edtWWPSMSRecipientNumbers_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSRecipientNumbers_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSRecipientNumbers_Enabled), 5, 0), true);
      cmbWWPSMSStatus.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPSMSStatus.getInternalname(), "Enabled", GXutil.ltrimstr( cmbWWPSMSStatus.getEnabled(), 5, 0), true);
      edtWWPSMSCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSCreated_Enabled), 5, 0), true);
      edtWWPSMSScheduled_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSScheduled_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSScheduled_Enabled), 5, 0), true);
      edtWWPSMSProcessed_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSProcessed_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSProcessed_Enabled), 5, 0), true);
      edtWWPSMSDetail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSMSDetail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSMSDetail_Enabled), 5, 0), true);
      edtWWPNotificationId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Enabled), 5, 0), true);
      edtWWPNotificationCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationCreated_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0V33( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0V0( )
   {
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.sms.wwp_sms", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z36WWPSMSId", GXutil.ltrim( localUtil.ntoc( Z36WWPSMSId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z158WWPSMSStatus", GXutil.ltrim( localUtil.ntoc( Z158WWPSMSStatus, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z164WWPSMSCreated", localUtil.ttoc( Z164WWPSMSCreated, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z165WWPSMSScheduled", localUtil.ttoc( Z165WWPSMSScheduled, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z159WWPSMSProcessed", localUtil.ttoc( Z159WWPSMSProcessed, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
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
      return formatLink("com.mujermorena.wwpbaseobjects.sms.wwp_sms", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SMS.WWP_SMS" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_SMS", "") ;
   }

   public void initializeNonKey0V33( )
   {
      A161WWPSMSMessage = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A161WWPSMSMessage", A161WWPSMSMessage);
      A162WWPSMSSenderNumber = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A162WWPSMSSenderNumber", A162WWPSMSSenderNumber);
      A163WWPSMSRecipientNumbers = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A163WWPSMSRecipientNumbers", A163WWPSMSRecipientNumbers);
      A159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      n159WWPSMSProcessed = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A159WWPSMSProcessed", localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      n159WWPSMSProcessed = (GXutil.dateCompare(GXutil.nullDate(), A159WWPSMSProcessed) ? true : false) ;
      A160WWPSMSDetail = "" ;
      n160WWPSMSDetail = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A160WWPSMSDetail", A160WWPSMSDetail);
      n160WWPSMSDetail = ((GXutil.strcmp("", A160WWPSMSDetail)==0) ? true : false) ;
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
      n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A158WWPSMSStatus = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
      A164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      Z158WWPSMSStatus = (short)(0) ;
      Z164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      Z165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z37WWPNotificationId = 0 ;
   }

   public void initAll0V33( )
   {
      A36WWPSMSId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A36WWPSMSId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36WWPSMSId), 10, 0));
      initializeNonKey0V33( ) ;
   }

   public void standaloneModalInsert( )
   {
      A158WWPSMSStatus = i158WWPSMSStatus ;
      httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
      A164WWPSMSCreated = i164WWPSMSCreated ;
      httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A165WWPSMSScheduled = i165WWPSMSScheduled ;
      httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111102143", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/sms/wwp_sms.js", "?202412111102145", false, true);
      /* End function include_jscripts */
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
      edtWWPSMSId_Internalname = "WWPSMSID" ;
      edtWWPSMSMessage_Internalname = "WWPSMSMESSAGE" ;
      edtWWPSMSSenderNumber_Internalname = "WWPSMSSENDERNUMBER" ;
      edtWWPSMSRecipientNumbers_Internalname = "WWPSMSRECIPIENTNUMBERS" ;
      cmbWWPSMSStatus.setInternalname( "WWPSMSSTATUS" );
      edtWWPSMSCreated_Internalname = "WWPSMSCREATED" ;
      edtWWPSMSScheduled_Internalname = "WWPSMSSCHEDULED" ;
      edtWWPSMSProcessed_Internalname = "WWPSMSPROCESSED" ;
      edtWWPSMSDetail_Internalname = "WWPSMSDETAIL" ;
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID" ;
      edtWWPNotificationCreated_Internalname = "WWPNOTIFICATIONCREATED" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_SMS", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtWWPNotificationCreated_Jsonclick = "" ;
      edtWWPNotificationCreated_Enabled = 0 ;
      edtWWPNotificationId_Jsonclick = "" ;
      edtWWPNotificationId_Enabled = 1 ;
      edtWWPSMSDetail_Enabled = 1 ;
      edtWWPSMSProcessed_Jsonclick = "" ;
      edtWWPSMSProcessed_Enabled = 1 ;
      edtWWPSMSScheduled_Jsonclick = "" ;
      edtWWPSMSScheduled_Enabled = 1 ;
      edtWWPSMSCreated_Jsonclick = "" ;
      edtWWPSMSCreated_Enabled = 1 ;
      cmbWWPSMSStatus.setJsonclick( "" );
      cmbWWPSMSStatus.setEnabled( 1 );
      edtWWPSMSRecipientNumbers_Enabled = 1 ;
      edtWWPSMSSenderNumber_Enabled = 1 ;
      edtWWPSMSMessage_Enabled = 1 ;
      edtWWPSMSId_Jsonclick = "" ;
      edtWWPSMSId_Enabled = 1 ;
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

   public void init_web_controls( )
   {
      cmbWWPSMSStatus.setName( "WWPSMSSTATUS" );
      cmbWWPSMSStatus.setWebtags( "" );
      cmbWWPSMSStatus.addItem("1", httpContext.getMessage( "Pending", ""), (short)(0));
      cmbWWPSMSStatus.addItem("2", httpContext.getMessage( "Sent", ""), (short)(0));
      cmbWWPSMSStatus.addItem("3", httpContext.getMessage( "Error", ""), (short)(0));
      if ( cmbWWPSMSStatus.getItemCount() > 0 )
      {
         if ( isIns( ) && (0==A158WWPSMSStatus) )
         {
            A158WWPSMSStatus = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0));
         }
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtWWPSMSMessage_Internalname ;
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

   public void valid_Wwpsmsid( )
   {
      A158WWPSMSStatus = (short)(GXutil.lval( cmbWWPSMSStatus.getValue())) ;
      cmbWWPSMSStatus.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0) );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbWWPSMSStatus.getItemCount() > 0 )
      {
         A158WWPSMSStatus = (short)(GXutil.lval( cmbWWPSMSStatus.getValidValue(GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0))))) ;
         cmbWWPSMSStatus.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A158WWPSMSStatus), 4, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPSMSStatus.setValue( GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A161WWPSMSMessage", A161WWPSMSMessage);
      httpContext.ajax_rsp_assign_attri("", false, "A162WWPSMSSenderNumber", A162WWPSMSSenderNumber);
      httpContext.ajax_rsp_assign_attri("", false, "A163WWPSMSRecipientNumbers", A163WWPSMSRecipientNumbers);
      httpContext.ajax_rsp_assign_attri("", false, "A158WWPSMSStatus", GXutil.ltrim( localUtil.ntoc( A158WWPSMSStatus, (byte)(4), (byte)(0), ".", "")));
      cmbWWPSMSStatus.setValue( GXutil.trim( GXutil.str( A158WWPSMSStatus, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPSMSStatus.getInternalname(), "Values", cmbWWPSMSStatus.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A164WWPSMSCreated", localUtil.ttoc( A164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A165WWPSMSScheduled", localUtil.ttoc( A165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A159WWPSMSProcessed", localUtil.ttoc( A159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A160WWPSMSDetail", A160WWPSMSDetail);
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z36WWPSMSId", GXutil.ltrim( localUtil.ntoc( Z36WWPSMSId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z161WWPSMSMessage", Z161WWPSMSMessage);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z162WWPSMSSenderNumber", Z162WWPSMSSenderNumber);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z163WWPSMSRecipientNumbers", Z163WWPSMSRecipientNumbers);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z158WWPSMSStatus", GXutil.ltrim( localUtil.ntoc( Z158WWPSMSStatus, (byte)(4), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z164WWPSMSCreated", localUtil.ttoc( Z164WWPSMSCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z165WWPSMSScheduled", localUtil.ttoc( Z165WWPSMSScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z159WWPSMSProcessed", localUtil.ttoc( Z159WWPSMSProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z160WWPSMSDetail", Z160WWPSMSDetail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40WWPNotificationCreated", localUtil.ttoc( Z40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpnotificationid( )
   {
      n37WWPNotificationId = false ;
      /* Using cursor T000V13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
         }
      }
      A40WWPNotificationCreated = T000V13_A40WWPNotificationCreated[0] ;
      pr_default.close(11);
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
      setEventMetadata("VALID_WWPSMSID","{handler:'valid_Wwpsmsid',iparms:[{av:'A36WWPSMSId',fld:'WWPSMSID',pic:'ZZZZZZZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbWWPSMSStatus'},{av:'A158WWPSMSStatus',fld:'WWPSMSSTATUS',pic:'ZZZ9'},{av:'A164WWPSMSCreated',fld:'WWPSMSCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A165WWPSMSScheduled',fld:'WWPSMSSCHEDULED',pic:'99/99/9999 99:99:99.999'}]");
      setEventMetadata("VALID_WWPSMSID",",oparms:[{av:'A161WWPSMSMessage',fld:'WWPSMSMESSAGE',pic:''},{av:'A162WWPSMSSenderNumber',fld:'WWPSMSSENDERNUMBER',pic:''},{av:'A163WWPSMSRecipientNumbers',fld:'WWPSMSRECIPIENTNUMBERS',pic:''},{av:'cmbWWPSMSStatus'},{av:'A158WWPSMSStatus',fld:'WWPSMSSTATUS',pic:'ZZZ9'},{av:'A164WWPSMSCreated',fld:'WWPSMSCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A165WWPSMSScheduled',fld:'WWPSMSSCHEDULED',pic:'99/99/9999 99:99:99.999'},{av:'A159WWPSMSProcessed',fld:'WWPSMSPROCESSED',pic:'99/99/9999 99:99:99.999'},{av:'A160WWPSMSDetail',fld:'WWPSMSDETAIL',pic:''},{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z36WWPSMSId'},{av:'Z161WWPSMSMessage'},{av:'Z162WWPSMSSenderNumber'},{av:'Z163WWPSMSRecipientNumbers'},{av:'Z158WWPSMSStatus'},{av:'Z164WWPSMSCreated'},{av:'Z165WWPSMSScheduled'},{av:'Z159WWPSMSProcessed'},{av:'Z160WWPSMSDetail'},{av:'Z37WWPNotificationId'},{av:'Z40WWPNotificationCreated'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_WWPSMSSTATUS","{handler:'valid_Wwpsmsstatus',iparms:[]");
      setEventMetadata("VALID_WWPSMSSTATUS",",oparms:[]}");
      setEventMetadata("VALID_WWPSMSCREATED","{handler:'valid_Wwpsmscreated',iparms:[]");
      setEventMetadata("VALID_WWPSMSCREATED",",oparms:[]}");
      setEventMetadata("VALID_WWPSMSSCHEDULED","{handler:'valid_Wwpsmsscheduled',iparms:[]");
      setEventMetadata("VALID_WWPSMSSCHEDULED",",oparms:[]}");
      setEventMetadata("VALID_WWPSMSPROCESSED","{handler:'valid_Wwpsmsprocessed',iparms:[]");
      setEventMetadata("VALID_WWPSMSPROCESSED",",oparms:[]}");
      setEventMetadata("VALID_WWPNOTIFICATIONID","{handler:'valid_Wwpnotificationid',iparms:[{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'}]");
      setEventMetadata("VALID_WWPNOTIFICATIONID",",oparms:[{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'}]}");
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
      return "sms_Execute";
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
      pr_default.close(11);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      Z165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A161WWPSMSMessage = "" ;
      A162WWPSMSSenderNumber = "" ;
      A163WWPSMSRecipientNumbers = "" ;
      A164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      A165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      A159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      A160WWPSMSDetail = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z161WWPSMSMessage = "" ;
      Z162WWPSMSSenderNumber = "" ;
      Z163WWPSMSRecipientNumbers = "" ;
      Z160WWPSMSDetail = "" ;
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      T000V5_A36WWPSMSId = new long[1] ;
      T000V5_A161WWPSMSMessage = new String[] {""} ;
      T000V5_A162WWPSMSSenderNumber = new String[] {""} ;
      T000V5_A163WWPSMSRecipientNumbers = new String[] {""} ;
      T000V5_A158WWPSMSStatus = new short[1] ;
      T000V5_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V5_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T000V5_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T000V5_n159WWPSMSProcessed = new boolean[] {false} ;
      T000V5_A160WWPSMSDetail = new String[] {""} ;
      T000V5_n160WWPSMSDetail = new boolean[] {false} ;
      T000V5_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V5_A37WWPNotificationId = new long[1] ;
      T000V5_n37WWPNotificationId = new boolean[] {false} ;
      T000V4_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V6_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V7_A36WWPSMSId = new long[1] ;
      T000V3_A36WWPSMSId = new long[1] ;
      T000V3_A161WWPSMSMessage = new String[] {""} ;
      T000V3_A162WWPSMSSenderNumber = new String[] {""} ;
      T000V3_A163WWPSMSRecipientNumbers = new String[] {""} ;
      T000V3_A158WWPSMSStatus = new short[1] ;
      T000V3_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T000V3_n159WWPSMSProcessed = new boolean[] {false} ;
      T000V3_A160WWPSMSDetail = new String[] {""} ;
      T000V3_n160WWPSMSDetail = new boolean[] {false} ;
      T000V3_A37WWPNotificationId = new long[1] ;
      T000V3_n37WWPNotificationId = new boolean[] {false} ;
      sMode33 = "" ;
      T000V8_A36WWPSMSId = new long[1] ;
      T000V9_A36WWPSMSId = new long[1] ;
      T000V2_A36WWPSMSId = new long[1] ;
      T000V2_A161WWPSMSMessage = new String[] {""} ;
      T000V2_A162WWPSMSSenderNumber = new String[] {""} ;
      T000V2_A163WWPSMSRecipientNumbers = new String[] {""} ;
      T000V2_A158WWPSMSStatus = new short[1] ;
      T000V2_A164WWPSMSCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_A165WWPSMSScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_A159WWPSMSProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T000V2_n159WWPSMSProcessed = new boolean[] {false} ;
      T000V2_A160WWPSMSDetail = new String[] {""} ;
      T000V2_n160WWPSMSDetail = new boolean[] {false} ;
      T000V2_A37WWPNotificationId = new long[1] ;
      T000V2_n37WWPNotificationId = new boolean[] {false} ;
      T000V10_A36WWPSMSId = new long[1] ;
      T000V13_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000V14_A36WWPSMSId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      i165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      ZZ161WWPSMSMessage = "" ;
      ZZ162WWPSMSSenderNumber = "" ;
      ZZ163WWPSMSRecipientNumbers = "" ;
      ZZ164WWPSMSCreated = GXutil.resetTime( GXutil.nullDate() );
      ZZ165WWPSMSScheduled = GXutil.resetTime( GXutil.nullDate() );
      ZZ159WWPSMSProcessed = GXutil.resetTime( GXutil.nullDate() );
      ZZ160WWPSMSDetail = "" ;
      ZZ40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.sms.wwp_sms__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.sms.wwp_sms__default(),
         new Object[] {
             new Object[] {
            T000V2_A36WWPSMSId, T000V2_A161WWPSMSMessage, T000V2_A162WWPSMSSenderNumber, T000V2_A163WWPSMSRecipientNumbers, T000V2_A158WWPSMSStatus, T000V2_A164WWPSMSCreated, T000V2_A165WWPSMSScheduled, T000V2_A159WWPSMSProcessed, T000V2_n159WWPSMSProcessed, T000V2_A160WWPSMSDetail,
            T000V2_n160WWPSMSDetail, T000V2_A37WWPNotificationId, T000V2_n37WWPNotificationId
            }
            , new Object[] {
            T000V3_A36WWPSMSId, T000V3_A161WWPSMSMessage, T000V3_A162WWPSMSSenderNumber, T000V3_A163WWPSMSRecipientNumbers, T000V3_A158WWPSMSStatus, T000V3_A164WWPSMSCreated, T000V3_A165WWPSMSScheduled, T000V3_A159WWPSMSProcessed, T000V3_n159WWPSMSProcessed, T000V3_A160WWPSMSDetail,
            T000V3_n160WWPSMSDetail, T000V3_A37WWPNotificationId, T000V3_n37WWPNotificationId
            }
            , new Object[] {
            T000V4_A40WWPNotificationCreated
            }
            , new Object[] {
            T000V5_A36WWPSMSId, T000V5_A161WWPSMSMessage, T000V5_A162WWPSMSSenderNumber, T000V5_A163WWPSMSRecipientNumbers, T000V5_A158WWPSMSStatus, T000V5_A164WWPSMSCreated, T000V5_A165WWPSMSScheduled, T000V5_A159WWPSMSProcessed, T000V5_n159WWPSMSProcessed, T000V5_A160WWPSMSDetail,
            T000V5_n160WWPSMSDetail, T000V5_A40WWPNotificationCreated, T000V5_A37WWPNotificationId, T000V5_n37WWPNotificationId
            }
            , new Object[] {
            T000V6_A40WWPNotificationCreated
            }
            , new Object[] {
            T000V7_A36WWPSMSId
            }
            , new Object[] {
            T000V8_A36WWPSMSId
            }
            , new Object[] {
            T000V9_A36WWPSMSId
            }
            , new Object[] {
            T000V10_A36WWPSMSId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000V13_A40WWPNotificationCreated
            }
            , new Object[] {
            T000V14_A36WWPSMSId
            }
         }
      );
      Z165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i165WWPSMSScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i164WWPSMSCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z158WWPSMSStatus = (short)(1) ;
      A158WWPSMSStatus = (short)(1) ;
      i158WWPSMSStatus = (short)(1) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z158WWPSMSStatus ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A158WWPSMSStatus ;
   private short RcdFound33 ;
   private short nIsDirty_33 ;
   private short i158WWPSMSStatus ;
   private short ZZ158WWPSMSStatus ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPSMSId_Enabled ;
   private int edtWWPSMSMessage_Enabled ;
   private int edtWWPSMSSenderNumber_Enabled ;
   private int edtWWPSMSRecipientNumbers_Enabled ;
   private int edtWWPSMSCreated_Enabled ;
   private int edtWWPSMSScheduled_Enabled ;
   private int edtWWPSMSProcessed_Enabled ;
   private int edtWWPSMSDetail_Enabled ;
   private int edtWWPNotificationId_Enabled ;
   private int edtWWPNotificationCreated_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private long Z36WWPSMSId ;
   private long Z37WWPNotificationId ;
   private long A37WWPNotificationId ;
   private long A36WWPSMSId ;
   private long ZZ36WWPSMSId ;
   private long ZZ37WWPNotificationId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPSMSId_Internalname ;
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
   private String edtWWPSMSId_Jsonclick ;
   private String edtWWPSMSMessage_Internalname ;
   private String edtWWPSMSSenderNumber_Internalname ;
   private String edtWWPSMSRecipientNumbers_Internalname ;
   private String edtWWPSMSCreated_Internalname ;
   private String edtWWPSMSCreated_Jsonclick ;
   private String edtWWPSMSScheduled_Internalname ;
   private String edtWWPSMSScheduled_Jsonclick ;
   private String edtWWPSMSProcessed_Internalname ;
   private String edtWWPSMSProcessed_Jsonclick ;
   private String edtWWPSMSDetail_Internalname ;
   private String edtWWPNotificationId_Internalname ;
   private String edtWWPNotificationId_Jsonclick ;
   private String edtWWPNotificationCreated_Internalname ;
   private String edtWWPNotificationCreated_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode33 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z164WWPSMSCreated ;
   private java.util.Date Z165WWPSMSScheduled ;
   private java.util.Date Z159WWPSMSProcessed ;
   private java.util.Date A164WWPSMSCreated ;
   private java.util.Date A165WWPSMSScheduled ;
   private java.util.Date A159WWPSMSProcessed ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date i164WWPSMSCreated ;
   private java.util.Date i165WWPSMSScheduled ;
   private java.util.Date ZZ164WWPSMSCreated ;
   private java.util.Date ZZ165WWPSMSScheduled ;
   private java.util.Date ZZ159WWPSMSProcessed ;
   private java.util.Date ZZ40WWPNotificationCreated ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n37WWPNotificationId ;
   private boolean wbErr ;
   private boolean n159WWPSMSProcessed ;
   private boolean n160WWPSMSDetail ;
   private String A161WWPSMSMessage ;
   private String A162WWPSMSSenderNumber ;
   private String A163WWPSMSRecipientNumbers ;
   private String A160WWPSMSDetail ;
   private String Z161WWPSMSMessage ;
   private String Z162WWPSMSSenderNumber ;
   private String Z163WWPSMSRecipientNumbers ;
   private String Z160WWPSMSDetail ;
   private String ZZ161WWPSMSMessage ;
   private String ZZ162WWPSMSSenderNumber ;
   private String ZZ163WWPSMSRecipientNumbers ;
   private String ZZ160WWPSMSDetail ;
   private HTMLChoice cmbWWPSMSStatus ;
   private IDataStoreProvider pr_default ;
   private long[] T000V5_A36WWPSMSId ;
   private String[] T000V5_A161WWPSMSMessage ;
   private String[] T000V5_A162WWPSMSSenderNumber ;
   private String[] T000V5_A163WWPSMSRecipientNumbers ;
   private short[] T000V5_A158WWPSMSStatus ;
   private java.util.Date[] T000V5_A164WWPSMSCreated ;
   private java.util.Date[] T000V5_A165WWPSMSScheduled ;
   private java.util.Date[] T000V5_A159WWPSMSProcessed ;
   private boolean[] T000V5_n159WWPSMSProcessed ;
   private String[] T000V5_A160WWPSMSDetail ;
   private boolean[] T000V5_n160WWPSMSDetail ;
   private java.util.Date[] T000V5_A40WWPNotificationCreated ;
   private long[] T000V5_A37WWPNotificationId ;
   private boolean[] T000V5_n37WWPNotificationId ;
   private java.util.Date[] T000V4_A40WWPNotificationCreated ;
   private java.util.Date[] T000V6_A40WWPNotificationCreated ;
   private long[] T000V7_A36WWPSMSId ;
   private long[] T000V3_A36WWPSMSId ;
   private String[] T000V3_A161WWPSMSMessage ;
   private String[] T000V3_A162WWPSMSSenderNumber ;
   private String[] T000V3_A163WWPSMSRecipientNumbers ;
   private short[] T000V3_A158WWPSMSStatus ;
   private java.util.Date[] T000V3_A164WWPSMSCreated ;
   private java.util.Date[] T000V3_A165WWPSMSScheduled ;
   private java.util.Date[] T000V3_A159WWPSMSProcessed ;
   private boolean[] T000V3_n159WWPSMSProcessed ;
   private String[] T000V3_A160WWPSMSDetail ;
   private boolean[] T000V3_n160WWPSMSDetail ;
   private long[] T000V3_A37WWPNotificationId ;
   private boolean[] T000V3_n37WWPNotificationId ;
   private long[] T000V8_A36WWPSMSId ;
   private long[] T000V9_A36WWPSMSId ;
   private long[] T000V2_A36WWPSMSId ;
   private String[] T000V2_A161WWPSMSMessage ;
   private String[] T000V2_A162WWPSMSSenderNumber ;
   private String[] T000V2_A163WWPSMSRecipientNumbers ;
   private short[] T000V2_A158WWPSMSStatus ;
   private java.util.Date[] T000V2_A164WWPSMSCreated ;
   private java.util.Date[] T000V2_A165WWPSMSScheduled ;
   private java.util.Date[] T000V2_A159WWPSMSProcessed ;
   private boolean[] T000V2_n159WWPSMSProcessed ;
   private String[] T000V2_A160WWPSMSDetail ;
   private boolean[] T000V2_n160WWPSMSDetail ;
   private long[] T000V2_A37WWPNotificationId ;
   private boolean[] T000V2_n37WWPNotificationId ;
   private long[] T000V10_A36WWPSMSId ;
   private java.util.Date[] T000V13_A40WWPNotificationCreated ;
   private long[] T000V14_A36WWPSMSId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_sms__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_sms__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000V2", "SELECT [WWPSMSId], [WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId] FROM [WWP_SMS] WITH (UPDLOCK) WHERE [WWPSMSId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V3", "SELECT [WWPSMSId], [WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId] FROM [WWP_SMS] WHERE [WWPSMSId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V4", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V5", "SELECT TM1.[WWPSMSId], TM1.[WWPSMSMessage], TM1.[WWPSMSSenderNumber], TM1.[WWPSMSRecipientNumbers], TM1.[WWPSMSStatus], TM1.[WWPSMSCreated], TM1.[WWPSMSScheduled], TM1.[WWPSMSProcessed], TM1.[WWPSMSDetail], T2.[WWPNotificationCreated], TM1.[WWPNotificationId] FROM ([WWP_SMS] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) WHERE TM1.[WWPSMSId] = ? ORDER BY TM1.[WWPSMSId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V6", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V7", "SELECT [WWPSMSId] FROM [WWP_SMS] WHERE [WWPSMSId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V8", "SELECT TOP 1 [WWPSMSId] FROM [WWP_SMS] WHERE ( [WWPSMSId] > ?) ORDER BY [WWPSMSId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V9", "SELECT TOP 1 [WWPSMSId] FROM [WWP_SMS] WHERE ( [WWPSMSId] < ?) ORDER BY [WWPSMSId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V10", "INSERT INTO [WWP_SMS]([WWPSMSMessage], [WWPSMSSenderNumber], [WWPSMSRecipientNumbers], [WWPSMSStatus], [WWPSMSCreated], [WWPSMSScheduled], [WWPSMSProcessed], [WWPSMSDetail], [WWPNotificationId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000V11", "UPDATE [WWP_SMS] SET [WWPSMSMessage]=?, [WWPSMSSenderNumber]=?, [WWPSMSRecipientNumbers]=?, [WWPSMSStatus]=?, [WWPSMSCreated]=?, [WWPSMSScheduled]=?, [WWPSMSProcessed]=?, [WWPSMSDetail]=?, [WWPNotificationId]=?  WHERE [WWPSMSId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000V12", "DELETE FROM [WWP_SMS]  WHERE [WWPSMSId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000V13", "SELECT [WWPNotificationCreated] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V14", "SELECT [WWPSMSId] FROM [WWP_SMS] ORDER BY [WWPSMSId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6, true);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(10, true);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1, true);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDateTime(5, (java.util.Date)parms[4], false, true);
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[7], false, true);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(8, (String)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(9, ((Number) parms[11]).longValue());
               }
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setDateTime(5, (java.util.Date)parms[4], false, true);
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[7], false, true);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(8, (String)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(9, ((Number) parms[11]).longValue());
               }
               stmt.setLong(10, ((Number) parms[12]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
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

