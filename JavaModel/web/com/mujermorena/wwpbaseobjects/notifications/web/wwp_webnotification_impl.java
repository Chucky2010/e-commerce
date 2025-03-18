package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_webnotification_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
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
         gxload_10( A37WWPNotificationId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A35WWPNotificationDefinitionId) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_Web Notification", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPWebNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_webnotification_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_webnotification_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_webnotification_impl.class ));
   }

   public wwp_webnotification_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbWWPWebNotificationStatus = new HTMLChoice();
      chkWWPWebNotificationReceived = UIFactory.getCheckbox(this);
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
      if ( cmbWWPWebNotificationStatus.getItemCount() > 0 )
      {
         A176WWPWebNotificationStatus = (short)(GXutil.lval( cmbWWPWebNotificationStatus.getValidValue(GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPWebNotificationStatus.setValue( GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebNotificationStatus.getInternalname(), "Values", cmbWWPWebNotificationStatus.ToJavascriptSource(), true);
      }
      A179WWPWebNotificationReceived = GXutil.strtobool( GXutil.booltostr( A179WWPWebNotificationReceived)) ;
      n179WWPWebNotificationReceived = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "WWP_Web Notification", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationId_Internalname, httpContext.getMessage( "Notification Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationId_Internalname, GXutil.ltrim( localUtil.ntoc( A38WWPWebNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPWebNotificationId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A38WWPWebNotificationId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A38WWPWebNotificationId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationTitle_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationTitle_Internalname, httpContext.getMessage( "Notification Title", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationTitle_Internalname, A166WWPWebNotificationTitle, GXutil.rtrim( localUtil.format( A166WWPWebNotificationTitle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationTitle_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationTitle_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationId_Internalname, GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationCreated_Internalname, localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A40WWPNotificationCreated, "99/99/9999 99:99:99.999"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPNotificationCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPNotificationCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationMetadata_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationMetadata_Internalname, httpContext.getMessage( "WWPNotification Metadata", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationMetadata_Internalname, A182WWPNotificationMetadata, "", "", (short)(0), 1, edtWWPNotificationMetadata_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionName_Internalname, httpContext.getMessage( "Notification Definition Internal Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionName_Internalname, A181WWPNotificationDefinitionName, GXutil.rtrim( localUtil.format( A181WWPNotificationDefinitionName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationText_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationText_Internalname, httpContext.getMessage( "Notification Text", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationText_Internalname, A167WWPWebNotificationText, GXutil.rtrim( localUtil.format( A167WWPWebNotificationText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationText_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationText_Enabled, 0, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationIcon_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationIcon_Internalname, httpContext.getMessage( "Notification Icon", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPWebNotificationIcon_Internalname, A168WWPWebNotificationIcon, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtWWPWebNotificationIcon_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "255", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationClientId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationClientId_Internalname, httpContext.getMessage( "Client Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPWebNotificationClientId_Internalname, A175WWPWebNotificationClientId, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", (short)(0), 1, edtWWPWebNotificationClientId_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbWWPWebNotificationStatus.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbWWPWebNotificationStatus.getInternalname(), httpContext.getMessage( "Notification Status", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbWWPWebNotificationStatus, cmbWWPWebNotificationStatus.getInternalname(), GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0)), 1, cmbWWPWebNotificationStatus.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbWWPWebNotificationStatus.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      cmbWWPWebNotificationStatus.setValue( GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebNotificationStatus.getInternalname(), "Values", cmbWWPWebNotificationStatus.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationCreated_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationCreated_Internalname, httpContext.getMessage( "Notification Created", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPWebNotificationCreated_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationCreated_Internalname, localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A169WWPWebNotificationCreated, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPWebNotificationCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPWebNotificationCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationScheduled_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationScheduled_Internalname, httpContext.getMessage( "Notification Scheduled", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPWebNotificationScheduled_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationScheduled_Internalname, localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A180WWPWebNotificationScheduled, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationScheduled_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationScheduled_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPWebNotificationScheduled_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPWebNotificationScheduled_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationProcessed_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationProcessed_Internalname, httpContext.getMessage( "Notification Processed", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPWebNotificationProcessed_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationProcessed_Internalname, localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A177WWPWebNotificationProcessed, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationProcessed_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationProcessed_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPWebNotificationProcessed_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPWebNotificationProcessed_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationRead_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationRead_Internalname, httpContext.getMessage( "Notification Read", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPWebNotificationRead_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebNotificationRead_Internalname, localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A170WWPWebNotificationRead, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,99);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebNotificationRead_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebNotificationRead_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPWebNotificationRead_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPWebNotificationRead_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebNotificationDetail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebNotificationDetail_Internalname, httpContext.getMessage( "Notification Detail", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPWebNotificationDetail_Internalname, A178WWPWebNotificationDetail, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", (short)(0), 1, edtWWPWebNotificationDetail_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPWebNotificationReceived.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPWebNotificationReceived.getInternalname(), httpContext.getMessage( "Notification Received", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPWebNotificationReceived.getInternalname(), GXutil.booltostr( A179WWPWebNotificationReceived), "", httpContext.getMessage( "Notification Received", ""), 1, chkWWPWebNotificationReceived.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(109, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,109);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebNotification.htm");
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
         Z38WWPWebNotificationId = localUtil.ctol( httpContext.cgiGet( "Z38WWPWebNotificationId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z166WWPWebNotificationTitle = httpContext.cgiGet( "Z166WWPWebNotificationTitle") ;
         Z167WWPWebNotificationText = httpContext.cgiGet( "Z167WWPWebNotificationText") ;
         Z168WWPWebNotificationIcon = httpContext.cgiGet( "Z168WWPWebNotificationIcon") ;
         Z176WWPWebNotificationStatus = (short)(localUtil.ctol( httpContext.cgiGet( "Z176WWPWebNotificationStatus"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z169WWPWebNotificationCreated = localUtil.ctot( httpContext.cgiGet( "Z169WWPWebNotificationCreated"), 0) ;
         Z180WWPWebNotificationScheduled = localUtil.ctot( httpContext.cgiGet( "Z180WWPWebNotificationScheduled"), 0) ;
         Z177WWPWebNotificationProcessed = localUtil.ctot( httpContext.cgiGet( "Z177WWPWebNotificationProcessed"), 0) ;
         Z170WWPWebNotificationRead = localUtil.ctot( httpContext.cgiGet( "Z170WWPWebNotificationRead"), 0) ;
         n170WWPWebNotificationRead = (GXutil.dateCompare(GXutil.nullDate(), A170WWPWebNotificationRead) ? true : false) ;
         Z179WWPWebNotificationReceived = GXutil.strtobool( httpContext.cgiGet( "Z179WWPWebNotificationReceived")) ;
         n179WWPWebNotificationReceived = ((false==A179WWPWebNotificationReceived) ? true : false) ;
         Z37WWPNotificationId = localUtil.ctol( httpContext.cgiGet( "Z37WWPNotificationId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         A35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( "WWPNOTIFICATIONDEFINITIONID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPWebNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPWebNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPWEBNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebNotificationId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A38WWPWebNotificationId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
         }
         else
         {
            A38WWPWebNotificationId = localUtil.ctol( httpContext.cgiGet( edtWWPWebNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
         }
         A166WWPWebNotificationTitle = httpContext.cgiGet( edtWWPWebNotificationTitle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A166WWPWebNotificationTitle", A166WWPWebNotificationTitle);
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
         A182WWPNotificationMetadata = httpContext.cgiGet( edtWWPNotificationMetadata_Internalname) ;
         n182WWPNotificationMetadata = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
         A181WWPNotificationDefinitionName = httpContext.cgiGet( edtWWPNotificationDefinitionName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         A167WWPWebNotificationText = httpContext.cgiGet( edtWWPWebNotificationText_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A167WWPWebNotificationText", A167WWPWebNotificationText);
         A168WWPWebNotificationIcon = httpContext.cgiGet( edtWWPWebNotificationIcon_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A168WWPWebNotificationIcon", A168WWPWebNotificationIcon);
         A175WWPWebNotificationClientId = httpContext.cgiGet( edtWWPWebNotificationClientId_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A175WWPWebNotificationClientId", A175WWPWebNotificationClientId);
         cmbWWPWebNotificationStatus.setValue( httpContext.cgiGet( cmbWWPWebNotificationStatus.getInternalname()) );
         A176WWPWebNotificationStatus = (short)(GXutil.lval( httpContext.cgiGet( cmbWWPWebNotificationStatus.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPWebNotificationCreated_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPWEBNOTIFICATIONCREATED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebNotificationCreated_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A169WWPWebNotificationCreated = localUtil.ctot( httpContext.cgiGet( edtWWPWebNotificationCreated_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPWebNotificationScheduled_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPWEBNOTIFICATIONSCHEDULED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebNotificationScheduled_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A180WWPWebNotificationScheduled = localUtil.ctot( httpContext.cgiGet( edtWWPWebNotificationScheduled_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPWebNotificationProcessed_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPWEBNOTIFICATIONPROCESSED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebNotificationProcessed_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A177WWPWebNotificationProcessed", localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A177WWPWebNotificationProcessed = localUtil.ctot( httpContext.cgiGet( edtWWPWebNotificationProcessed_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A177WWPWebNotificationProcessed", localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPWebNotificationRead_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPWEBNOTIFICATIONREAD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebNotificationRead_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
            n170WWPWebNotificationRead = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A170WWPWebNotificationRead", localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A170WWPWebNotificationRead = localUtil.ctot( httpContext.cgiGet( edtWWPWebNotificationRead_Internalname)) ;
            n170WWPWebNotificationRead = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A170WWPWebNotificationRead", localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         n170WWPWebNotificationRead = (GXutil.dateCompare(GXutil.nullDate(), A170WWPWebNotificationRead) ? true : false) ;
         A178WWPWebNotificationDetail = httpContext.cgiGet( edtWWPWebNotificationDetail_Internalname) ;
         n178WWPWebNotificationDetail = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A178WWPWebNotificationDetail", A178WWPWebNotificationDetail);
         n178WWPWebNotificationDetail = ((GXutil.strcmp("", A178WWPWebNotificationDetail)==0) ? true : false) ;
         A179WWPWebNotificationReceived = GXutil.strtobool( httpContext.cgiGet( chkWWPWebNotificationReceived.getInternalname())) ;
         n179WWPWebNotificationReceived = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
         n179WWPWebNotificationReceived = ((false==A179WWPWebNotificationReceived) ? true : false) ;
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
            A38WWPWebNotificationId = GXutil.lval( httpContext.GetPar( "WWPWebNotificationId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
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
            initAll0W34( ) ;
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
      disableAttributes0W34( ) ;
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

   public void resetCaption0W0( )
   {
   }

   public void zm0W34( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z166WWPWebNotificationTitle = T000W3_A166WWPWebNotificationTitle[0] ;
            Z167WWPWebNotificationText = T000W3_A167WWPWebNotificationText[0] ;
            Z168WWPWebNotificationIcon = T000W3_A168WWPWebNotificationIcon[0] ;
            Z176WWPWebNotificationStatus = T000W3_A176WWPWebNotificationStatus[0] ;
            Z169WWPWebNotificationCreated = T000W3_A169WWPWebNotificationCreated[0] ;
            Z180WWPWebNotificationScheduled = T000W3_A180WWPWebNotificationScheduled[0] ;
            Z177WWPWebNotificationProcessed = T000W3_A177WWPWebNotificationProcessed[0] ;
            Z170WWPWebNotificationRead = T000W3_A170WWPWebNotificationRead[0] ;
            Z179WWPWebNotificationReceived = T000W3_A179WWPWebNotificationReceived[0] ;
            Z37WWPNotificationId = T000W3_A37WWPNotificationId[0] ;
         }
         else
         {
            Z166WWPWebNotificationTitle = A166WWPWebNotificationTitle ;
            Z167WWPWebNotificationText = A167WWPWebNotificationText ;
            Z168WWPWebNotificationIcon = A168WWPWebNotificationIcon ;
            Z176WWPWebNotificationStatus = A176WWPWebNotificationStatus ;
            Z169WWPWebNotificationCreated = A169WWPWebNotificationCreated ;
            Z180WWPWebNotificationScheduled = A180WWPWebNotificationScheduled ;
            Z177WWPWebNotificationProcessed = A177WWPWebNotificationProcessed ;
            Z170WWPWebNotificationRead = A170WWPWebNotificationRead ;
            Z179WWPWebNotificationReceived = A179WWPWebNotificationReceived ;
            Z37WWPNotificationId = A37WWPNotificationId ;
         }
      }
      if ( GX_JID == -9 )
      {
         Z38WWPWebNotificationId = A38WWPWebNotificationId ;
         Z166WWPWebNotificationTitle = A166WWPWebNotificationTitle ;
         Z167WWPWebNotificationText = A167WWPWebNotificationText ;
         Z168WWPWebNotificationIcon = A168WWPWebNotificationIcon ;
         Z175WWPWebNotificationClientId = A175WWPWebNotificationClientId ;
         Z176WWPWebNotificationStatus = A176WWPWebNotificationStatus ;
         Z169WWPWebNotificationCreated = A169WWPWebNotificationCreated ;
         Z180WWPWebNotificationScheduled = A180WWPWebNotificationScheduled ;
         Z177WWPWebNotificationProcessed = A177WWPWebNotificationProcessed ;
         Z170WWPWebNotificationRead = A170WWPWebNotificationRead ;
         Z178WWPWebNotificationDetail = A178WWPWebNotificationDetail ;
         Z179WWPWebNotificationReceived = A179WWPWebNotificationReceived ;
         Z37WWPNotificationId = A37WWPNotificationId ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
         Z182WWPNotificationMetadata = A182WWPNotificationMetadata ;
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (0==A176WWPWebNotificationStatus) && ( Gx_BScreen == 0 ) )
      {
         A176WWPWebNotificationStatus = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A169WWPWebNotificationCreated) && ( Gx_BScreen == 0 ) )
      {
         A169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A180WWPWebNotificationScheduled) && ( Gx_BScreen == 0 ) )
      {
         A180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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

   public void load0W34( )
   {
      /* Using cursor T000W6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A35WWPNotificationDefinitionId = T000W6_A35WWPNotificationDefinitionId[0] ;
         A166WWPWebNotificationTitle = T000W6_A166WWPWebNotificationTitle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A166WWPWebNotificationTitle", A166WWPWebNotificationTitle);
         A40WWPNotificationCreated = T000W6_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A182WWPNotificationMetadata = T000W6_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = T000W6_n182WWPNotificationMetadata[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
         A181WWPNotificationDefinitionName = T000W6_A181WWPNotificationDefinitionName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         A167WWPWebNotificationText = T000W6_A167WWPWebNotificationText[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A167WWPWebNotificationText", A167WWPWebNotificationText);
         A168WWPWebNotificationIcon = T000W6_A168WWPWebNotificationIcon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A168WWPWebNotificationIcon", A168WWPWebNotificationIcon);
         A175WWPWebNotificationClientId = T000W6_A175WWPWebNotificationClientId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A175WWPWebNotificationClientId", A175WWPWebNotificationClientId);
         A176WWPWebNotificationStatus = T000W6_A176WWPWebNotificationStatus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
         A169WWPWebNotificationCreated = T000W6_A169WWPWebNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A180WWPWebNotificationScheduled = T000W6_A180WWPWebNotificationScheduled[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A177WWPWebNotificationProcessed = T000W6_A177WWPWebNotificationProcessed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A177WWPWebNotificationProcessed", localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A170WWPWebNotificationRead = T000W6_A170WWPWebNotificationRead[0] ;
         n170WWPWebNotificationRead = T000W6_n170WWPWebNotificationRead[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A170WWPWebNotificationRead", localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A178WWPWebNotificationDetail = T000W6_A178WWPWebNotificationDetail[0] ;
         n178WWPWebNotificationDetail = T000W6_n178WWPWebNotificationDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A178WWPWebNotificationDetail", A178WWPWebNotificationDetail);
         A179WWPWebNotificationReceived = T000W6_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = T000W6_n179WWPWebNotificationReceived[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
         A37WWPNotificationId = T000W6_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000W6_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         zm0W34( -9) ;
      }
      pr_default.close(4);
      onLoadActions0W34( ) ;
   }

   public void onLoadActions0W34( )
   {
   }

   public void checkExtendedTable0W34( )
   {
      nIsDirty_34 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      /* Using cursor T000W4 */
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
      A35WWPNotificationDefinitionId = T000W4_A35WWPNotificationDefinitionId[0] ;
      A40WWPNotificationCreated = T000W4_A40WWPNotificationCreated[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A182WWPNotificationMetadata = T000W4_A182WWPNotificationMetadata[0] ;
      n182WWPNotificationMetadata = T000W4_n182WWPNotificationMetadata[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      pr_default.close(2);
      /* Using cursor T000W5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A35WWPNotificationDefinitionId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
            AnyError = (short)(1) ;
         }
      }
      A181WWPNotificationDefinitionName = T000W5_A181WWPNotificationDefinitionName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      pr_default.close(3);
      if ( ! ( ( A176WWPWebNotificationStatus == 1 ) || ( A176WWPWebNotificationStatus == 2 ) || ( A176WWPWebNotificationStatus == 3 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Status", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBNOTIFICATIONSTATUS");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbWWPWebNotificationStatus.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A169WWPWebNotificationCreated) || (( A169WWPWebNotificationCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A169WWPWebNotificationCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Created", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBNOTIFICATIONCREATED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebNotificationCreated_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A180WWPWebNotificationScheduled) || (( A180WWPWebNotificationScheduled.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A180WWPWebNotificationScheduled, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Scheduled", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBNOTIFICATIONSCHEDULED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebNotificationScheduled_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A177WWPWebNotificationProcessed) || (( A177WWPWebNotificationProcessed.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A177WWPWebNotificationProcessed, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Processed", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBNOTIFICATIONPROCESSED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebNotificationProcessed_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A170WWPWebNotificationRead) || (( A170WWPWebNotificationRead.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A170WWPWebNotificationRead, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Notification Read", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBNOTIFICATIONREAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebNotificationRead_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0W34( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_10( long A37WWPNotificationId )
   {
      /* Using cursor T000W7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A37WWPNotificationId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Notification", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A35WWPNotificationDefinitionId = T000W7_A35WWPNotificationDefinitionId[0] ;
      A40WWPNotificationCreated = T000W7_A40WWPNotificationCreated[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A182WWPNotificationMetadata = T000W7_A182WWPNotificationMetadata[0] ;
      n182WWPNotificationMetadata = T000W7_n182WWPNotificationMetadata[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A182WWPNotificationMetadata)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_11( long A35WWPNotificationDefinitionId )
   {
      /* Using cursor T000W8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A35WWPNotificationDefinitionId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
            AnyError = (short)(1) ;
         }
      }
      A181WWPNotificationDefinitionName = T000W8_A181WWPNotificationDefinitionName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A181WWPNotificationDefinitionName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0W34( )
   {
      /* Using cursor T000W9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound34 = (short)(1) ;
      }
      else
      {
         RcdFound34 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000W3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0W34( 9) ;
         RcdFound34 = (short)(1) ;
         A38WWPWebNotificationId = T000W3_A38WWPWebNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
         A166WWPWebNotificationTitle = T000W3_A166WWPWebNotificationTitle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A166WWPWebNotificationTitle", A166WWPWebNotificationTitle);
         A167WWPWebNotificationText = T000W3_A167WWPWebNotificationText[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A167WWPWebNotificationText", A167WWPWebNotificationText);
         A168WWPWebNotificationIcon = T000W3_A168WWPWebNotificationIcon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A168WWPWebNotificationIcon", A168WWPWebNotificationIcon);
         A175WWPWebNotificationClientId = T000W3_A175WWPWebNotificationClientId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A175WWPWebNotificationClientId", A175WWPWebNotificationClientId);
         A176WWPWebNotificationStatus = T000W3_A176WWPWebNotificationStatus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
         A169WWPWebNotificationCreated = T000W3_A169WWPWebNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A180WWPWebNotificationScheduled = T000W3_A180WWPWebNotificationScheduled[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A177WWPWebNotificationProcessed = T000W3_A177WWPWebNotificationProcessed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A177WWPWebNotificationProcessed", localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A170WWPWebNotificationRead = T000W3_A170WWPWebNotificationRead[0] ;
         n170WWPWebNotificationRead = T000W3_n170WWPWebNotificationRead[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A170WWPWebNotificationRead", localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A178WWPWebNotificationDetail = T000W3_A178WWPWebNotificationDetail[0] ;
         n178WWPWebNotificationDetail = T000W3_n178WWPWebNotificationDetail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A178WWPWebNotificationDetail", A178WWPWebNotificationDetail);
         A179WWPWebNotificationReceived = T000W3_A179WWPWebNotificationReceived[0] ;
         n179WWPWebNotificationReceived = T000W3_n179WWPWebNotificationReceived[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
         A37WWPNotificationId = T000W3_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000W3_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         Z38WWPWebNotificationId = A38WWPWebNotificationId ;
         sMode34 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0W34( ) ;
         if ( AnyError == 1 )
         {
            RcdFound34 = (short)(0) ;
            initializeNonKey0W34( ) ;
         }
         Gx_mode = sMode34 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound34 = (short)(0) ;
         initializeNonKey0W34( ) ;
         sMode34 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode34 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0W34( ) ;
      if ( RcdFound34 == 0 )
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
      RcdFound34 = (short)(0) ;
      /* Using cursor T000W10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000W10_A38WWPWebNotificationId[0] < A38WWPWebNotificationId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000W10_A38WWPWebNotificationId[0] > A38WWPWebNotificationId ) ) )
         {
            A38WWPWebNotificationId = T000W10_A38WWPWebNotificationId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
            RcdFound34 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound34 = (short)(0) ;
      /* Using cursor T000W11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000W11_A38WWPWebNotificationId[0] > A38WWPWebNotificationId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000W11_A38WWPWebNotificationId[0] < A38WWPWebNotificationId ) ) )
         {
            A38WWPWebNotificationId = T000W11_A38WWPWebNotificationId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
            RcdFound34 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0W34( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPWebNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0W34( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound34 == 1 )
         {
            if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
            {
               A38WWPWebNotificationId = Z38WWPWebNotificationId ;
               httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPWEBNOTIFICATIONID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPWebNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPWebNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0W34( ) ;
               GX_FocusControl = edtWWPWebNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPWebNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0W34( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPWEBNOTIFICATIONID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPWebNotificationId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPWebNotificationId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0W34( ) ;
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
      if ( A38WWPWebNotificationId != Z38WWPWebNotificationId )
      {
         A38WWPWebNotificationId = Z38WWPWebNotificationId ;
         httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPWEBNOTIFICATIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPWebNotificationId_Internalname ;
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
      if ( RcdFound34 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPWEBNOTIFICATIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtWWPWebNotificationTitle_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0W34( ) ;
      if ( RcdFound34 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPWebNotificationTitle_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0W34( ) ;
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
      if ( RcdFound34 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPWebNotificationTitle_Internalname ;
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
      if ( RcdFound34 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPWebNotificationTitle_Internalname ;
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
      scanStart0W34( ) ;
      if ( RcdFound34 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound34 != 0 )
         {
            scanNext0W34( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPWebNotificationTitle_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0W34( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0W34( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000W2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebNotification"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z166WWPWebNotificationTitle, T000W2_A166WWPWebNotificationTitle[0]) != 0 ) || ( GXutil.strcmp(Z167WWPWebNotificationText, T000W2_A167WWPWebNotificationText[0]) != 0 ) || ( GXutil.strcmp(Z168WWPWebNotificationIcon, T000W2_A168WWPWebNotificationIcon[0]) != 0 ) || ( Z176WWPWebNotificationStatus != T000W2_A176WWPWebNotificationStatus[0] ) || !( GXutil.dateCompare(Z169WWPWebNotificationCreated, T000W2_A169WWPWebNotificationCreated[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(Z180WWPWebNotificationScheduled, T000W2_A180WWPWebNotificationScheduled[0]) ) || !( GXutil.dateCompare(Z177WWPWebNotificationProcessed, T000W2_A177WWPWebNotificationProcessed[0]) ) || !( GXutil.dateCompare(Z170WWPWebNotificationRead, T000W2_A170WWPWebNotificationRead[0]) ) || ( Z179WWPWebNotificationReceived != T000W2_A179WWPWebNotificationReceived[0] ) || ( Z37WWPNotificationId != T000W2_A37WWPNotificationId[0] ) )
         {
            if ( GXutil.strcmp(Z166WWPWebNotificationTitle, T000W2_A166WWPWebNotificationTitle[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationTitle");
               GXutil.writeLogRaw("Old: ",Z166WWPWebNotificationTitle);
               GXutil.writeLogRaw("Current: ",T000W2_A166WWPWebNotificationTitle[0]);
            }
            if ( GXutil.strcmp(Z167WWPWebNotificationText, T000W2_A167WWPWebNotificationText[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationText");
               GXutil.writeLogRaw("Old: ",Z167WWPWebNotificationText);
               GXutil.writeLogRaw("Current: ",T000W2_A167WWPWebNotificationText[0]);
            }
            if ( GXutil.strcmp(Z168WWPWebNotificationIcon, T000W2_A168WWPWebNotificationIcon[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationIcon");
               GXutil.writeLogRaw("Old: ",Z168WWPWebNotificationIcon);
               GXutil.writeLogRaw("Current: ",T000W2_A168WWPWebNotificationIcon[0]);
            }
            if ( Z176WWPWebNotificationStatus != T000W2_A176WWPWebNotificationStatus[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationStatus");
               GXutil.writeLogRaw("Old: ",Z176WWPWebNotificationStatus);
               GXutil.writeLogRaw("Current: ",T000W2_A176WWPWebNotificationStatus[0]);
            }
            if ( !( GXutil.dateCompare(Z169WWPWebNotificationCreated, T000W2_A169WWPWebNotificationCreated[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationCreated");
               GXutil.writeLogRaw("Old: ",Z169WWPWebNotificationCreated);
               GXutil.writeLogRaw("Current: ",T000W2_A169WWPWebNotificationCreated[0]);
            }
            if ( !( GXutil.dateCompare(Z180WWPWebNotificationScheduled, T000W2_A180WWPWebNotificationScheduled[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationScheduled");
               GXutil.writeLogRaw("Old: ",Z180WWPWebNotificationScheduled);
               GXutil.writeLogRaw("Current: ",T000W2_A180WWPWebNotificationScheduled[0]);
            }
            if ( !( GXutil.dateCompare(Z177WWPWebNotificationProcessed, T000W2_A177WWPWebNotificationProcessed[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationProcessed");
               GXutil.writeLogRaw("Old: ",Z177WWPWebNotificationProcessed);
               GXutil.writeLogRaw("Current: ",T000W2_A177WWPWebNotificationProcessed[0]);
            }
            if ( !( GXutil.dateCompare(Z170WWPWebNotificationRead, T000W2_A170WWPWebNotificationRead[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationRead");
               GXutil.writeLogRaw("Old: ",Z170WWPWebNotificationRead);
               GXutil.writeLogRaw("Current: ",T000W2_A170WWPWebNotificationRead[0]);
            }
            if ( Z179WWPWebNotificationReceived != T000W2_A179WWPWebNotificationReceived[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPWebNotificationReceived");
               GXutil.writeLogRaw("Old: ",Z179WWPWebNotificationReceived);
               GXutil.writeLogRaw("Current: ",T000W2_A179WWPWebNotificationReceived[0]);
            }
            if ( Z37WWPNotificationId != T000W2_A37WWPNotificationId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webnotification:[seudo value changed for attri]"+"WWPNotificationId");
               GXutil.writeLogRaw("Old: ",Z37WWPNotificationId);
               GXutil.writeLogRaw("Current: ",T000W2_A37WWPNotificationId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_WebNotification"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0W34( )
   {
      if ( ! IsAuthorized("webnotification_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0W34( 0) ;
         checkOptimisticConcurrency0W34( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0W34( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0W34( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000W12 */
                  pr_default.execute(10, new Object[] {A166WWPWebNotificationTitle, A167WWPWebNotificationText, A168WWPWebNotificationIcon, A175WWPWebNotificationClientId, Short.valueOf(A176WWPWebNotificationStatus), A169WWPWebNotificationCreated, A180WWPWebNotificationScheduled, A177WWPWebNotificationProcessed, Boolean.valueOf(n170WWPWebNotificationRead), A170WWPWebNotificationRead, Boolean.valueOf(n178WWPWebNotificationDetail), A178WWPWebNotificationDetail, Boolean.valueOf(n179WWPWebNotificationReceived), Boolean.valueOf(A179WWPWebNotificationReceived), Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  A38WWPWebNotificationId = T000W12_A38WWPWebNotificationId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0W0( ) ;
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
            load0W34( ) ;
         }
         endLevel0W34( ) ;
      }
      closeExtendedTableCursors0W34( ) ;
   }

   public void update0W34( )
   {
      if ( ! IsAuthorized("webnotification_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0W34( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0W34( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0W34( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000W13 */
                  pr_default.execute(11, new Object[] {A166WWPWebNotificationTitle, A167WWPWebNotificationText, A168WWPWebNotificationIcon, A175WWPWebNotificationClientId, Short.valueOf(A176WWPWebNotificationStatus), A169WWPWebNotificationCreated, A180WWPWebNotificationScheduled, A177WWPWebNotificationProcessed, Boolean.valueOf(n170WWPWebNotificationRead), A170WWPWebNotificationRead, Boolean.valueOf(n178WWPWebNotificationDetail), A178WWPWebNotificationDetail, Boolean.valueOf(n179WWPWebNotificationReceived), Boolean.valueOf(A179WWPWebNotificationReceived), Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId), Long.valueOf(A38WWPWebNotificationId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebNotification"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0W34( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0W0( ) ;
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
         endLevel0W34( ) ;
      }
      closeExtendedTableCursors0W34( ) ;
   }

   public void deferredUpdate0W34( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("webnotification_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0W34( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0W34( ) ;
         afterConfirm0W34( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0W34( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000W14 */
               pr_default.execute(12, new Object[] {Long.valueOf(A38WWPWebNotificationId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebNotification");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound34 == 0 )
                     {
                        initAll0W34( ) ;
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
                     resetCaption0W0( ) ;
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
      sMode34 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0W34( ) ;
      Gx_mode = sMode34 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0W34( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000W15 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         A35WWPNotificationDefinitionId = T000W15_A35WWPNotificationDefinitionId[0] ;
         A40WWPNotificationCreated = T000W15_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A182WWPNotificationMetadata = T000W15_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = T000W15_n182WWPNotificationMetadata[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
         pr_default.close(13);
         /* Using cursor T000W16 */
         pr_default.execute(14, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         A181WWPNotificationDefinitionName = T000W16_A181WWPNotificationDefinitionName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         pr_default.close(14);
      }
   }

   public void endLevel0W34( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0W34( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_webnotification");
         if ( AnyError == 0 )
         {
            confirmValues0W0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_webnotification");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0W34( )
   {
      /* Using cursor T000W17 */
      pr_default.execute(15);
      RcdFound34 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A38WWPWebNotificationId = T000W17_A38WWPWebNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0W34( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound34 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A38WWPWebNotificationId = T000W17_A38WWPWebNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
      }
   }

   public void scanEnd0W34( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0W34( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0W34( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0W34( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0W34( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0W34( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0W34( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0W34( )
   {
      edtWWPWebNotificationId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationId_Enabled), 5, 0), true);
      edtWWPWebNotificationTitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationTitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationTitle_Enabled), 5, 0), true);
      edtWWPNotificationId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Enabled), 5, 0), true);
      edtWWPNotificationCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationCreated_Enabled), 5, 0), true);
      edtWWPNotificationMetadata_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationMetadata_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationMetadata_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionName_Enabled), 5, 0), true);
      edtWWPWebNotificationText_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationText_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationText_Enabled), 5, 0), true);
      edtWWPWebNotificationIcon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationIcon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationIcon_Enabled), 5, 0), true);
      edtWWPWebNotificationClientId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationClientId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationClientId_Enabled), 5, 0), true);
      cmbWWPWebNotificationStatus.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebNotificationStatus.getInternalname(), "Enabled", GXutil.ltrimstr( cmbWWPWebNotificationStatus.getEnabled(), 5, 0), true);
      edtWWPWebNotificationCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationCreated_Enabled), 5, 0), true);
      edtWWPWebNotificationScheduled_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationScheduled_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationScheduled_Enabled), 5, 0), true);
      edtWWPWebNotificationProcessed_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationProcessed_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationProcessed_Enabled), 5, 0), true);
      edtWWPWebNotificationRead_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationRead_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationRead_Enabled), 5, 0), true);
      edtWWPWebNotificationDetail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebNotificationDetail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebNotificationDetail_Enabled), 5, 0), true);
      chkWWPWebNotificationReceived.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPWebNotificationReceived.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPWebNotificationReceived.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0W34( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0W0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z38WWPWebNotificationId", GXutil.ltrim( localUtil.ntoc( Z38WWPWebNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z166WWPWebNotificationTitle", Z166WWPWebNotificationTitle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z167WWPWebNotificationText", Z167WWPWebNotificationText);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z168WWPWebNotificationIcon", Z168WWPWebNotificationIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z176WWPWebNotificationStatus", GXutil.ltrim( localUtil.ntoc( Z176WWPWebNotificationStatus, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z169WWPWebNotificationCreated", localUtil.ttoc( Z169WWPWebNotificationCreated, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z180WWPWebNotificationScheduled", localUtil.ttoc( Z180WWPWebNotificationScheduled, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z177WWPWebNotificationProcessed", localUtil.ttoc( Z177WWPWebNotificationProcessed, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z170WWPWebNotificationRead", localUtil.ttoc( Z170WWPWebNotificationRead, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z179WWPWebNotificationReceived", Z179WWPWebNotificationReceived);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONDEFINITIONID", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Web.WWP_WebNotification" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_Web Notification", "") ;
   }

   public void initializeNonKey0W34( )
   {
      A35WWPNotificationDefinitionId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
      A166WWPWebNotificationTitle = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A166WWPWebNotificationTitle", A166WWPWebNotificationTitle);
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
      n37WWPNotificationId = ((0==A37WWPNotificationId) ? true : false) ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A182WWPNotificationMetadata = "" ;
      n182WWPNotificationMetadata = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      A181WWPNotificationDefinitionName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      A167WWPWebNotificationText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A167WWPWebNotificationText", A167WWPWebNotificationText);
      A168WWPWebNotificationIcon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A168WWPWebNotificationIcon", A168WWPWebNotificationIcon);
      A175WWPWebNotificationClientId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A175WWPWebNotificationClientId", A175WWPWebNotificationClientId);
      A177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A177WWPWebNotificationProcessed", localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      n170WWPWebNotificationRead = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A170WWPWebNotificationRead", localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      n170WWPWebNotificationRead = (GXutil.dateCompare(GXutil.nullDate(), A170WWPWebNotificationRead) ? true : false) ;
      A178WWPWebNotificationDetail = "" ;
      n178WWPWebNotificationDetail = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A178WWPWebNotificationDetail", A178WWPWebNotificationDetail);
      n178WWPWebNotificationDetail = ((GXutil.strcmp("", A178WWPWebNotificationDetail)==0) ? true : false) ;
      A179WWPWebNotificationReceived = false ;
      n179WWPWebNotificationReceived = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
      n179WWPWebNotificationReceived = ((false==A179WWPWebNotificationReceived) ? true : false) ;
      A176WWPWebNotificationStatus = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
      A169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      Z166WWPWebNotificationTitle = "" ;
      Z167WWPWebNotificationText = "" ;
      Z168WWPWebNotificationIcon = "" ;
      Z176WWPWebNotificationStatus = (short)(0) ;
      Z169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      Z179WWPWebNotificationReceived = false ;
      Z37WWPNotificationId = 0 ;
   }

   public void initAll0W34( )
   {
      A38WWPWebNotificationId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A38WWPWebNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A38WWPWebNotificationId), 10, 0));
      initializeNonKey0W34( ) ;
   }

   public void standaloneModalInsert( )
   {
      A176WWPWebNotificationStatus = i176WWPWebNotificationStatus ;
      httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
      A169WWPWebNotificationCreated = i169WWPWebNotificationCreated ;
      httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A180WWPWebNotificationScheduled = i180WWPWebNotificationScheduled ;
      httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211110308", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/notifications/web/wwp_webnotification.js", "?20241211110308", false, true);
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
      edtWWPWebNotificationId_Internalname = "WWPWEBNOTIFICATIONID" ;
      edtWWPWebNotificationTitle_Internalname = "WWPWEBNOTIFICATIONTITLE" ;
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID" ;
      edtWWPNotificationCreated_Internalname = "WWPNOTIFICATIONCREATED" ;
      edtWWPNotificationMetadata_Internalname = "WWPNOTIFICATIONMETADATA" ;
      edtWWPNotificationDefinitionName_Internalname = "WWPNOTIFICATIONDEFINITIONNAME" ;
      edtWWPWebNotificationText_Internalname = "WWPWEBNOTIFICATIONTEXT" ;
      edtWWPWebNotificationIcon_Internalname = "WWPWEBNOTIFICATIONICON" ;
      edtWWPWebNotificationClientId_Internalname = "WWPWEBNOTIFICATIONCLIENTID" ;
      cmbWWPWebNotificationStatus.setInternalname( "WWPWEBNOTIFICATIONSTATUS" );
      edtWWPWebNotificationCreated_Internalname = "WWPWEBNOTIFICATIONCREATED" ;
      edtWWPWebNotificationScheduled_Internalname = "WWPWEBNOTIFICATIONSCHEDULED" ;
      edtWWPWebNotificationProcessed_Internalname = "WWPWEBNOTIFICATIONPROCESSED" ;
      edtWWPWebNotificationRead_Internalname = "WWPWEBNOTIFICATIONREAD" ;
      edtWWPWebNotificationDetail_Internalname = "WWPWEBNOTIFICATIONDETAIL" ;
      chkWWPWebNotificationReceived.setInternalname( "WWPWEBNOTIFICATIONRECEIVED" );
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
      Form.setCaption( httpContext.getMessage( "WWP_Web Notification", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      chkWWPWebNotificationReceived.setEnabled( 1 );
      edtWWPWebNotificationDetail_Enabled = 1 ;
      edtWWPWebNotificationRead_Jsonclick = "" ;
      edtWWPWebNotificationRead_Enabled = 1 ;
      edtWWPWebNotificationProcessed_Jsonclick = "" ;
      edtWWPWebNotificationProcessed_Enabled = 1 ;
      edtWWPWebNotificationScheduled_Jsonclick = "" ;
      edtWWPWebNotificationScheduled_Enabled = 1 ;
      edtWWPWebNotificationCreated_Jsonclick = "" ;
      edtWWPWebNotificationCreated_Enabled = 1 ;
      cmbWWPWebNotificationStatus.setJsonclick( "" );
      cmbWWPWebNotificationStatus.setEnabled( 1 );
      edtWWPWebNotificationClientId_Enabled = 1 ;
      edtWWPWebNotificationIcon_Enabled = 1 ;
      edtWWPWebNotificationText_Jsonclick = "" ;
      edtWWPWebNotificationText_Enabled = 1 ;
      edtWWPNotificationDefinitionName_Jsonclick = "" ;
      edtWWPNotificationDefinitionName_Enabled = 0 ;
      edtWWPNotificationMetadata_Enabled = 0 ;
      edtWWPNotificationCreated_Jsonclick = "" ;
      edtWWPNotificationCreated_Enabled = 0 ;
      edtWWPNotificationId_Jsonclick = "" ;
      edtWWPNotificationId_Enabled = 1 ;
      edtWWPWebNotificationTitle_Jsonclick = "" ;
      edtWWPWebNotificationTitle_Enabled = 1 ;
      edtWWPWebNotificationId_Jsonclick = "" ;
      edtWWPWebNotificationId_Enabled = 1 ;
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
      cmbWWPWebNotificationStatus.setName( "WWPWEBNOTIFICATIONSTATUS" );
      cmbWWPWebNotificationStatus.setWebtags( "" );
      cmbWWPWebNotificationStatus.addItem("1", httpContext.getMessage( "Pending", ""), (short)(0));
      cmbWWPWebNotificationStatus.addItem("2", httpContext.getMessage( "Sent", ""), (short)(0));
      cmbWWPWebNotificationStatus.addItem("3", httpContext.getMessage( "Error", ""), (short)(0));
      if ( cmbWWPWebNotificationStatus.getItemCount() > 0 )
      {
         if ( isIns( ) && (0==A176WWPWebNotificationStatus) )
         {
            A176WWPWebNotificationStatus = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0));
         }
      }
      chkWWPWebNotificationReceived.setName( "WWPWEBNOTIFICATIONRECEIVED" );
      chkWWPWebNotificationReceived.setWebtags( "" );
      chkWWPWebNotificationReceived.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPWebNotificationReceived.getInternalname(), "TitleCaption", chkWWPWebNotificationReceived.getCaption(), true);
      chkWWPWebNotificationReceived.setCheckedValue( "false" );
      A179WWPWebNotificationReceived = GXutil.strtobool( GXutil.booltostr( A179WWPWebNotificationReceived)) ;
      n179WWPWebNotificationReceived = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtWWPWebNotificationTitle_Internalname ;
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

   public void valid_Wwpwebnotificationid( )
   {
      A176WWPWebNotificationStatus = (short)(GXutil.lval( cmbWWPWebNotificationStatus.getValue())) ;
      cmbWWPWebNotificationStatus.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0) );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbWWPWebNotificationStatus.getItemCount() > 0 )
      {
         A176WWPWebNotificationStatus = (short)(GXutil.lval( cmbWWPWebNotificationStatus.getValidValue(GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0))))) ;
         cmbWWPWebNotificationStatus.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A176WWPWebNotificationStatus), 4, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPWebNotificationStatus.setValue( GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0)) );
      }
      A179WWPWebNotificationReceived = GXutil.strtobool( GXutil.booltostr( A179WWPWebNotificationReceived)) ;
      n179WWPWebNotificationReceived = false ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A166WWPWebNotificationTitle", A166WWPWebNotificationTitle);
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A167WWPWebNotificationText", A167WWPWebNotificationText);
      httpContext.ajax_rsp_assign_attri("", false, "A168WWPWebNotificationIcon", A168WWPWebNotificationIcon);
      httpContext.ajax_rsp_assign_attri("", false, "A175WWPWebNotificationClientId", A175WWPWebNotificationClientId);
      httpContext.ajax_rsp_assign_attri("", false, "A176WWPWebNotificationStatus", GXutil.ltrim( localUtil.ntoc( A176WWPWebNotificationStatus, (byte)(4), (byte)(0), ".", "")));
      cmbWWPWebNotificationStatus.setValue( GXutil.trim( GXutil.str( A176WWPWebNotificationStatus, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebNotificationStatus.getInternalname(), "Values", cmbWWPWebNotificationStatus.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A169WWPWebNotificationCreated", localUtil.ttoc( A169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A180WWPWebNotificationScheduled", localUtil.ttoc( A180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A177WWPWebNotificationProcessed", localUtil.ttoc( A177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A170WWPWebNotificationRead", localUtil.ttoc( A170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A178WWPWebNotificationDetail", A178WWPWebNotificationDetail);
      httpContext.ajax_rsp_assign_attri("", false, "A179WWPWebNotificationReceived", A179WWPWebNotificationReceived);
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z38WWPWebNotificationId", GXutil.ltrim( localUtil.ntoc( Z38WWPWebNotificationId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z166WWPWebNotificationTitle", Z166WWPWebNotificationTitle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z167WWPWebNotificationText", Z167WWPWebNotificationText);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z168WWPWebNotificationIcon", Z168WWPWebNotificationIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z175WWPWebNotificationClientId", Z175WWPWebNotificationClientId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z176WWPWebNotificationStatus", GXutil.ltrim( localUtil.ntoc( Z176WWPWebNotificationStatus, (byte)(4), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z169WWPWebNotificationCreated", localUtil.ttoc( Z169WWPWebNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z180WWPWebNotificationScheduled", localUtil.ttoc( Z180WWPWebNotificationScheduled, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z177WWPWebNotificationProcessed", localUtil.ttoc( Z177WWPWebNotificationProcessed, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z170WWPWebNotificationRead", localUtil.ttoc( Z170WWPWebNotificationRead, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z178WWPWebNotificationDetail", Z178WWPWebNotificationDetail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z179WWPWebNotificationReceived", GXutil.booltostr( Z179WWPWebNotificationReceived));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40WWPNotificationCreated", localUtil.ttoc( Z40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z182WWPNotificationMetadata", Z182WWPNotificationMetadata);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z181WWPNotificationDefinitionName", Z181WWPNotificationDefinitionName);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpnotificationid( )
   {
      n37WWPNotificationId = false ;
      n182WWPNotificationMetadata = false ;
      /* Using cursor T000W15 */
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
      A35WWPNotificationDefinitionId = T000W15_A35WWPNotificationDefinitionId[0] ;
      A40WWPNotificationCreated = T000W15_A40WWPNotificationCreated[0] ;
      A182WWPNotificationMetadata = T000W15_A182WWPNotificationMetadata[0] ;
      n182WWPNotificationMetadata = T000W15_n182WWPNotificationMetadata[0] ;
      pr_default.close(13);
      /* Using cursor T000W16 */
      pr_default.execute(14, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A35WWPNotificationDefinitionId) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
            AnyError = (short)(1) ;
         }
      }
      A181WWPNotificationDefinitionName = T000W16_A181WWPNotificationDefinitionName[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONID","{handler:'valid_Wwpwebnotificationid',iparms:[{av:'A38WWPWebNotificationId',fld:'WWPWEBNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbWWPWebNotificationStatus'},{av:'A176WWPWebNotificationStatus',fld:'WWPWEBNOTIFICATIONSTATUS',pic:'ZZZ9'},{av:'A169WWPWebNotificationCreated',fld:'WWPWEBNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A180WWPWebNotificationScheduled',fld:'WWPWEBNOTIFICATIONSCHEDULED',pic:'99/99/9999 99:99:99.999'},{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONID",",oparms:[{av:'A166WWPWebNotificationTitle',fld:'WWPWEBNOTIFICATIONTITLE',pic:''},{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'A167WWPWebNotificationText',fld:'WWPWEBNOTIFICATIONTEXT',pic:''},{av:'A168WWPWebNotificationIcon',fld:'WWPWEBNOTIFICATIONICON',pic:''},{av:'A175WWPWebNotificationClientId',fld:'WWPWEBNOTIFICATIONCLIENTID',pic:''},{av:'cmbWWPWebNotificationStatus'},{av:'A176WWPWebNotificationStatus',fld:'WWPWEBNOTIFICATIONSTATUS',pic:'ZZZ9'},{av:'A169WWPWebNotificationCreated',fld:'WWPWEBNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A180WWPWebNotificationScheduled',fld:'WWPWEBNOTIFICATIONSCHEDULED',pic:'99/99/9999 99:99:99.999'},{av:'A177WWPWebNotificationProcessed',fld:'WWPWEBNOTIFICATIONPROCESSED',pic:'99/99/9999 99:99:99.999'},{av:'A170WWPWebNotificationRead',fld:'WWPWEBNOTIFICATIONREAD',pic:'99/99/9999 99:99:99.999'},{av:'A178WWPWebNotificationDetail',fld:'WWPWEBNOTIFICATIONDETAIL',pic:''},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A182WWPNotificationMetadata',fld:'WWPNOTIFICATIONMETADATA',pic:''},{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z38WWPWebNotificationId'},{av:'Z166WWPWebNotificationTitle'},{av:'Z37WWPNotificationId'},{av:'Z167WWPWebNotificationText'},{av:'Z168WWPWebNotificationIcon'},{av:'Z175WWPWebNotificationClientId'},{av:'Z176WWPWebNotificationStatus'},{av:'Z169WWPWebNotificationCreated'},{av:'Z180WWPWebNotificationScheduled'},{av:'Z177WWPWebNotificationProcessed'},{av:'Z170WWPWebNotificationRead'},{av:'Z178WWPWebNotificationDetail'},{av:'Z179WWPWebNotificationReceived'},{av:'Z35WWPNotificationDefinitionId'},{av:'Z40WWPNotificationCreated'},{av:'Z182WWPNotificationMetadata'},{av:'Z181WWPNotificationDefinitionName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONID","{handler:'valid_Wwpnotificationid',iparms:[{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A182WWPNotificationMetadata',fld:'WWPNOTIFICATIONMETADATA',pic:''},{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONID",",oparms:[{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A182WWPNotificationMetadata',fld:'WWPNOTIFICATIONMETADATA',pic:''},{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONSTATUS","{handler:'valid_Wwpwebnotificationstatus',iparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONSTATUS",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONCREATED","{handler:'valid_Wwpwebnotificationcreated',iparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONCREATED",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONSCHEDULED","{handler:'valid_Wwpwebnotificationscheduled',iparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONSCHEDULED",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONPROCESSED","{handler:'valid_Wwpwebnotificationprocessed',iparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONPROCESSED",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONREAD","{handler:'valid_Wwpwebnotificationread',iparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]");
      setEventMetadata("VALID_WWPWEBNOTIFICATIONREAD",",oparms:[{av:'A179WWPWebNotificationReceived',fld:'WWPWEBNOTIFICATIONRECEIVED',pic:''}]}");
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
      return "webnotification_Execute";
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
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z166WWPWebNotificationTitle = "" ;
      Z167WWPWebNotificationText = "" ;
      Z168WWPWebNotificationIcon = "" ;
      Z169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      Z177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      Z170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
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
      A166WWPWebNotificationTitle = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A182WWPNotificationMetadata = "" ;
      A181WWPNotificationDefinitionName = "" ;
      A167WWPWebNotificationText = "" ;
      A168WWPWebNotificationIcon = "" ;
      A175WWPWebNotificationClientId = "" ;
      A169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      A177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      A170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      A178WWPWebNotificationDetail = "" ;
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
      Z175WWPWebNotificationClientId = "" ;
      Z178WWPWebNotificationDetail = "" ;
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z182WWPNotificationMetadata = "" ;
      Z181WWPNotificationDefinitionName = "" ;
      T000W6_A35WWPNotificationDefinitionId = new long[1] ;
      T000W6_A38WWPWebNotificationId = new long[1] ;
      T000W6_A166WWPWebNotificationTitle = new String[] {""} ;
      T000W6_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W6_A182WWPNotificationMetadata = new String[] {""} ;
      T000W6_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000W6_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000W6_A167WWPWebNotificationText = new String[] {""} ;
      T000W6_A168WWPWebNotificationIcon = new String[] {""} ;
      T000W6_A175WWPWebNotificationClientId = new String[] {""} ;
      T000W6_A176WWPWebNotificationStatus = new short[1] ;
      T000W6_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W6_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T000W6_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T000W6_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      T000W6_n170WWPWebNotificationRead = new boolean[] {false} ;
      T000W6_A178WWPWebNotificationDetail = new String[] {""} ;
      T000W6_n178WWPWebNotificationDetail = new boolean[] {false} ;
      T000W6_A179WWPWebNotificationReceived = new boolean[] {false} ;
      T000W6_n179WWPWebNotificationReceived = new boolean[] {false} ;
      T000W6_A37WWPNotificationId = new long[1] ;
      T000W6_n37WWPNotificationId = new boolean[] {false} ;
      T000W4_A35WWPNotificationDefinitionId = new long[1] ;
      T000W4_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W4_A182WWPNotificationMetadata = new String[] {""} ;
      T000W4_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000W5_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000W7_A35WWPNotificationDefinitionId = new long[1] ;
      T000W7_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W7_A182WWPNotificationMetadata = new String[] {""} ;
      T000W7_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000W8_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000W9_A38WWPWebNotificationId = new long[1] ;
      T000W3_A38WWPWebNotificationId = new long[1] ;
      T000W3_A166WWPWebNotificationTitle = new String[] {""} ;
      T000W3_A167WWPWebNotificationText = new String[] {""} ;
      T000W3_A168WWPWebNotificationIcon = new String[] {""} ;
      T000W3_A175WWPWebNotificationClientId = new String[] {""} ;
      T000W3_A176WWPWebNotificationStatus = new short[1] ;
      T000W3_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W3_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T000W3_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T000W3_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      T000W3_n170WWPWebNotificationRead = new boolean[] {false} ;
      T000W3_A178WWPWebNotificationDetail = new String[] {""} ;
      T000W3_n178WWPWebNotificationDetail = new boolean[] {false} ;
      T000W3_A179WWPWebNotificationReceived = new boolean[] {false} ;
      T000W3_n179WWPWebNotificationReceived = new boolean[] {false} ;
      T000W3_A37WWPNotificationId = new long[1] ;
      T000W3_n37WWPNotificationId = new boolean[] {false} ;
      sMode34 = "" ;
      T000W10_A38WWPWebNotificationId = new long[1] ;
      T000W11_A38WWPWebNotificationId = new long[1] ;
      T000W2_A38WWPWebNotificationId = new long[1] ;
      T000W2_A166WWPWebNotificationTitle = new String[] {""} ;
      T000W2_A167WWPWebNotificationText = new String[] {""} ;
      T000W2_A168WWPWebNotificationIcon = new String[] {""} ;
      T000W2_A175WWPWebNotificationClientId = new String[] {""} ;
      T000W2_A176WWPWebNotificationStatus = new short[1] ;
      T000W2_A169WWPWebNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W2_A180WWPWebNotificationScheduled = new java.util.Date[] {GXutil.nullDate()} ;
      T000W2_A177WWPWebNotificationProcessed = new java.util.Date[] {GXutil.nullDate()} ;
      T000W2_A170WWPWebNotificationRead = new java.util.Date[] {GXutil.nullDate()} ;
      T000W2_n170WWPWebNotificationRead = new boolean[] {false} ;
      T000W2_A178WWPWebNotificationDetail = new String[] {""} ;
      T000W2_n178WWPWebNotificationDetail = new boolean[] {false} ;
      T000W2_A179WWPWebNotificationReceived = new boolean[] {false} ;
      T000W2_n179WWPWebNotificationReceived = new boolean[] {false} ;
      T000W2_A37WWPNotificationId = new long[1] ;
      T000W2_n37WWPNotificationId = new boolean[] {false} ;
      T000W12_A38WWPWebNotificationId = new long[1] ;
      T000W15_A35WWPNotificationDefinitionId = new long[1] ;
      T000W15_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000W15_A182WWPNotificationMetadata = new String[] {""} ;
      T000W15_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000W16_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000W17_A38WWPWebNotificationId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      i180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      ZZ166WWPWebNotificationTitle = "" ;
      ZZ167WWPWebNotificationText = "" ;
      ZZ168WWPWebNotificationIcon = "" ;
      ZZ175WWPWebNotificationClientId = "" ;
      ZZ169WWPWebNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      ZZ180WWPWebNotificationScheduled = GXutil.resetTime( GXutil.nullDate() );
      ZZ177WWPWebNotificationProcessed = GXutil.resetTime( GXutil.nullDate() );
      ZZ170WWPWebNotificationRead = GXutil.resetTime( GXutil.nullDate() );
      ZZ178WWPWebNotificationDetail = "" ;
      ZZ40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      ZZ182WWPNotificationMetadata = "" ;
      ZZ181WWPNotificationDefinitionName = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webnotification__default(),
         new Object[] {
             new Object[] {
            T000W2_A38WWPWebNotificationId, T000W2_A166WWPWebNotificationTitle, T000W2_A167WWPWebNotificationText, T000W2_A168WWPWebNotificationIcon, T000W2_A175WWPWebNotificationClientId, T000W2_A176WWPWebNotificationStatus, T000W2_A169WWPWebNotificationCreated, T000W2_A180WWPWebNotificationScheduled, T000W2_A177WWPWebNotificationProcessed, T000W2_A170WWPWebNotificationRead,
            T000W2_n170WWPWebNotificationRead, T000W2_A178WWPWebNotificationDetail, T000W2_n178WWPWebNotificationDetail, T000W2_A179WWPWebNotificationReceived, T000W2_n179WWPWebNotificationReceived, T000W2_A37WWPNotificationId, T000W2_n37WWPNotificationId
            }
            , new Object[] {
            T000W3_A38WWPWebNotificationId, T000W3_A166WWPWebNotificationTitle, T000W3_A167WWPWebNotificationText, T000W3_A168WWPWebNotificationIcon, T000W3_A175WWPWebNotificationClientId, T000W3_A176WWPWebNotificationStatus, T000W3_A169WWPWebNotificationCreated, T000W3_A180WWPWebNotificationScheduled, T000W3_A177WWPWebNotificationProcessed, T000W3_A170WWPWebNotificationRead,
            T000W3_n170WWPWebNotificationRead, T000W3_A178WWPWebNotificationDetail, T000W3_n178WWPWebNotificationDetail, T000W3_A179WWPWebNotificationReceived, T000W3_n179WWPWebNotificationReceived, T000W3_A37WWPNotificationId, T000W3_n37WWPNotificationId
            }
            , new Object[] {
            T000W4_A35WWPNotificationDefinitionId, T000W4_A40WWPNotificationCreated, T000W4_A182WWPNotificationMetadata, T000W4_n182WWPNotificationMetadata
            }
            , new Object[] {
            T000W5_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            T000W6_A35WWPNotificationDefinitionId, T000W6_A38WWPWebNotificationId, T000W6_A166WWPWebNotificationTitle, T000W6_A40WWPNotificationCreated, T000W6_A182WWPNotificationMetadata, T000W6_n182WWPNotificationMetadata, T000W6_A181WWPNotificationDefinitionName, T000W6_A167WWPWebNotificationText, T000W6_A168WWPWebNotificationIcon, T000W6_A175WWPWebNotificationClientId,
            T000W6_A176WWPWebNotificationStatus, T000W6_A169WWPWebNotificationCreated, T000W6_A180WWPWebNotificationScheduled, T000W6_A177WWPWebNotificationProcessed, T000W6_A170WWPWebNotificationRead, T000W6_n170WWPWebNotificationRead, T000W6_A178WWPWebNotificationDetail, T000W6_n178WWPWebNotificationDetail, T000W6_A179WWPWebNotificationReceived, T000W6_n179WWPWebNotificationReceived,
            T000W6_A37WWPNotificationId, T000W6_n37WWPNotificationId
            }
            , new Object[] {
            T000W7_A35WWPNotificationDefinitionId, T000W7_A40WWPNotificationCreated, T000W7_A182WWPNotificationMetadata, T000W7_n182WWPNotificationMetadata
            }
            , new Object[] {
            T000W8_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            T000W9_A38WWPWebNotificationId
            }
            , new Object[] {
            T000W10_A38WWPWebNotificationId
            }
            , new Object[] {
            T000W11_A38WWPWebNotificationId
            }
            , new Object[] {
            T000W12_A38WWPWebNotificationId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000W15_A35WWPNotificationDefinitionId, T000W15_A40WWPNotificationCreated, T000W15_A182WWPNotificationMetadata, T000W15_n182WWPNotificationMetadata
            }
            , new Object[] {
            T000W16_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            T000W17_A38WWPWebNotificationId
            }
         }
      );
      Z180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i180WWPWebNotificationScheduled = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i169WWPWebNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z176WWPWebNotificationStatus = (short)(1) ;
      A176WWPWebNotificationStatus = (short)(1) ;
      i176WWPWebNotificationStatus = (short)(1) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z176WWPWebNotificationStatus ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A176WWPWebNotificationStatus ;
   private short RcdFound34 ;
   private short nIsDirty_34 ;
   private short i176WWPWebNotificationStatus ;
   private short ZZ176WWPWebNotificationStatus ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPWebNotificationId_Enabled ;
   private int edtWWPWebNotificationTitle_Enabled ;
   private int edtWWPNotificationId_Enabled ;
   private int edtWWPNotificationCreated_Enabled ;
   private int edtWWPNotificationMetadata_Enabled ;
   private int edtWWPNotificationDefinitionName_Enabled ;
   private int edtWWPWebNotificationText_Enabled ;
   private int edtWWPWebNotificationIcon_Enabled ;
   private int edtWWPWebNotificationClientId_Enabled ;
   private int edtWWPWebNotificationCreated_Enabled ;
   private int edtWWPWebNotificationScheduled_Enabled ;
   private int edtWWPWebNotificationProcessed_Enabled ;
   private int edtWWPWebNotificationRead_Enabled ;
   private int edtWWPWebNotificationDetail_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private long Z38WWPWebNotificationId ;
   private long Z37WWPNotificationId ;
   private long A37WWPNotificationId ;
   private long A35WWPNotificationDefinitionId ;
   private long A38WWPWebNotificationId ;
   private long Z35WWPNotificationDefinitionId ;
   private long ZZ38WWPWebNotificationId ;
   private long ZZ37WWPNotificationId ;
   private long ZZ35WWPNotificationDefinitionId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPWebNotificationId_Internalname ;
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
   private String edtWWPWebNotificationId_Jsonclick ;
   private String edtWWPWebNotificationTitle_Internalname ;
   private String edtWWPWebNotificationTitle_Jsonclick ;
   private String edtWWPNotificationId_Internalname ;
   private String edtWWPNotificationId_Jsonclick ;
   private String edtWWPNotificationCreated_Internalname ;
   private String edtWWPNotificationCreated_Jsonclick ;
   private String edtWWPNotificationMetadata_Internalname ;
   private String edtWWPNotificationDefinitionName_Internalname ;
   private String edtWWPNotificationDefinitionName_Jsonclick ;
   private String edtWWPWebNotificationText_Internalname ;
   private String edtWWPWebNotificationText_Jsonclick ;
   private String edtWWPWebNotificationIcon_Internalname ;
   private String edtWWPWebNotificationClientId_Internalname ;
   private String edtWWPWebNotificationCreated_Internalname ;
   private String edtWWPWebNotificationCreated_Jsonclick ;
   private String edtWWPWebNotificationScheduled_Internalname ;
   private String edtWWPWebNotificationScheduled_Jsonclick ;
   private String edtWWPWebNotificationProcessed_Internalname ;
   private String edtWWPWebNotificationProcessed_Jsonclick ;
   private String edtWWPWebNotificationRead_Internalname ;
   private String edtWWPWebNotificationRead_Jsonclick ;
   private String edtWWPWebNotificationDetail_Internalname ;
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
   private String sMode34 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z169WWPWebNotificationCreated ;
   private java.util.Date Z180WWPWebNotificationScheduled ;
   private java.util.Date Z177WWPWebNotificationProcessed ;
   private java.util.Date Z170WWPWebNotificationRead ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date A169WWPWebNotificationCreated ;
   private java.util.Date A180WWPWebNotificationScheduled ;
   private java.util.Date A177WWPWebNotificationProcessed ;
   private java.util.Date A170WWPWebNotificationRead ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date i169WWPWebNotificationCreated ;
   private java.util.Date i180WWPWebNotificationScheduled ;
   private java.util.Date ZZ169WWPWebNotificationCreated ;
   private java.util.Date ZZ180WWPWebNotificationScheduled ;
   private java.util.Date ZZ177WWPWebNotificationProcessed ;
   private java.util.Date ZZ170WWPWebNotificationRead ;
   private java.util.Date ZZ40WWPNotificationCreated ;
   private boolean Z179WWPWebNotificationReceived ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n37WWPNotificationId ;
   private boolean wbErr ;
   private boolean A179WWPWebNotificationReceived ;
   private boolean n179WWPWebNotificationReceived ;
   private boolean n170WWPWebNotificationRead ;
   private boolean n182WWPNotificationMetadata ;
   private boolean n178WWPWebNotificationDetail ;
   private boolean Gx_longc ;
   private boolean ZZ179WWPWebNotificationReceived ;
   private String A182WWPNotificationMetadata ;
   private String A175WWPWebNotificationClientId ;
   private String A178WWPWebNotificationDetail ;
   private String Z175WWPWebNotificationClientId ;
   private String Z178WWPWebNotificationDetail ;
   private String Z182WWPNotificationMetadata ;
   private String ZZ175WWPWebNotificationClientId ;
   private String ZZ178WWPWebNotificationDetail ;
   private String ZZ182WWPNotificationMetadata ;
   private String Z166WWPWebNotificationTitle ;
   private String Z167WWPWebNotificationText ;
   private String Z168WWPWebNotificationIcon ;
   private String A166WWPWebNotificationTitle ;
   private String A181WWPNotificationDefinitionName ;
   private String A167WWPWebNotificationText ;
   private String A168WWPWebNotificationIcon ;
   private String Z181WWPNotificationDefinitionName ;
   private String ZZ166WWPWebNotificationTitle ;
   private String ZZ167WWPWebNotificationText ;
   private String ZZ168WWPWebNotificationIcon ;
   private String ZZ181WWPNotificationDefinitionName ;
   private HTMLChoice cmbWWPWebNotificationStatus ;
   private ICheckbox chkWWPWebNotificationReceived ;
   private IDataStoreProvider pr_default ;
   private long[] T000W6_A35WWPNotificationDefinitionId ;
   private long[] T000W6_A38WWPWebNotificationId ;
   private String[] T000W6_A166WWPWebNotificationTitle ;
   private java.util.Date[] T000W6_A40WWPNotificationCreated ;
   private String[] T000W6_A182WWPNotificationMetadata ;
   private boolean[] T000W6_n182WWPNotificationMetadata ;
   private String[] T000W6_A181WWPNotificationDefinitionName ;
   private String[] T000W6_A167WWPWebNotificationText ;
   private String[] T000W6_A168WWPWebNotificationIcon ;
   private String[] T000W6_A175WWPWebNotificationClientId ;
   private short[] T000W6_A176WWPWebNotificationStatus ;
   private java.util.Date[] T000W6_A169WWPWebNotificationCreated ;
   private java.util.Date[] T000W6_A180WWPWebNotificationScheduled ;
   private java.util.Date[] T000W6_A177WWPWebNotificationProcessed ;
   private java.util.Date[] T000W6_A170WWPWebNotificationRead ;
   private boolean[] T000W6_n170WWPWebNotificationRead ;
   private String[] T000W6_A178WWPWebNotificationDetail ;
   private boolean[] T000W6_n178WWPWebNotificationDetail ;
   private boolean[] T000W6_A179WWPWebNotificationReceived ;
   private boolean[] T000W6_n179WWPWebNotificationReceived ;
   private long[] T000W6_A37WWPNotificationId ;
   private boolean[] T000W6_n37WWPNotificationId ;
   private long[] T000W4_A35WWPNotificationDefinitionId ;
   private java.util.Date[] T000W4_A40WWPNotificationCreated ;
   private String[] T000W4_A182WWPNotificationMetadata ;
   private boolean[] T000W4_n182WWPNotificationMetadata ;
   private String[] T000W5_A181WWPNotificationDefinitionName ;
   private long[] T000W7_A35WWPNotificationDefinitionId ;
   private java.util.Date[] T000W7_A40WWPNotificationCreated ;
   private String[] T000W7_A182WWPNotificationMetadata ;
   private boolean[] T000W7_n182WWPNotificationMetadata ;
   private String[] T000W8_A181WWPNotificationDefinitionName ;
   private long[] T000W9_A38WWPWebNotificationId ;
   private long[] T000W3_A38WWPWebNotificationId ;
   private String[] T000W3_A166WWPWebNotificationTitle ;
   private String[] T000W3_A167WWPWebNotificationText ;
   private String[] T000W3_A168WWPWebNotificationIcon ;
   private String[] T000W3_A175WWPWebNotificationClientId ;
   private short[] T000W3_A176WWPWebNotificationStatus ;
   private java.util.Date[] T000W3_A169WWPWebNotificationCreated ;
   private java.util.Date[] T000W3_A180WWPWebNotificationScheduled ;
   private java.util.Date[] T000W3_A177WWPWebNotificationProcessed ;
   private java.util.Date[] T000W3_A170WWPWebNotificationRead ;
   private boolean[] T000W3_n170WWPWebNotificationRead ;
   private String[] T000W3_A178WWPWebNotificationDetail ;
   private boolean[] T000W3_n178WWPWebNotificationDetail ;
   private boolean[] T000W3_A179WWPWebNotificationReceived ;
   private boolean[] T000W3_n179WWPWebNotificationReceived ;
   private long[] T000W3_A37WWPNotificationId ;
   private boolean[] T000W3_n37WWPNotificationId ;
   private long[] T000W10_A38WWPWebNotificationId ;
   private long[] T000W11_A38WWPWebNotificationId ;
   private long[] T000W2_A38WWPWebNotificationId ;
   private String[] T000W2_A166WWPWebNotificationTitle ;
   private String[] T000W2_A167WWPWebNotificationText ;
   private String[] T000W2_A168WWPWebNotificationIcon ;
   private String[] T000W2_A175WWPWebNotificationClientId ;
   private short[] T000W2_A176WWPWebNotificationStatus ;
   private java.util.Date[] T000W2_A169WWPWebNotificationCreated ;
   private java.util.Date[] T000W2_A180WWPWebNotificationScheduled ;
   private java.util.Date[] T000W2_A177WWPWebNotificationProcessed ;
   private java.util.Date[] T000W2_A170WWPWebNotificationRead ;
   private boolean[] T000W2_n170WWPWebNotificationRead ;
   private String[] T000W2_A178WWPWebNotificationDetail ;
   private boolean[] T000W2_n178WWPWebNotificationDetail ;
   private boolean[] T000W2_A179WWPWebNotificationReceived ;
   private boolean[] T000W2_n179WWPWebNotificationReceived ;
   private long[] T000W2_A37WWPNotificationId ;
   private boolean[] T000W2_n37WWPNotificationId ;
   private long[] T000W12_A38WWPWebNotificationId ;
   private long[] T000W15_A35WWPNotificationDefinitionId ;
   private java.util.Date[] T000W15_A40WWPNotificationCreated ;
   private String[] T000W15_A182WWPNotificationMetadata ;
   private boolean[] T000W15_n182WWPNotificationMetadata ;
   private String[] T000W16_A181WWPNotificationDefinitionName ;
   private long[] T000W17_A38WWPWebNotificationId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_webnotification__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_webnotification__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000W2", "SELECT [WWPWebNotificationId], [WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId] FROM [WWP_WebNotification] WITH (UPDLOCK) WHERE [WWPWebNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W3", "SELECT [WWPWebNotificationId], [WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId] FROM [WWP_WebNotification] WHERE [WWPWebNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W4", "SELECT [WWPNotificationDefinitionId], [WWPNotificationCreated], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W5", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W6", "SELECT T2.[WWPNotificationDefinitionId], TM1.[WWPWebNotificationId], TM1.[WWPWebNotificationTitle], T2.[WWPNotificationCreated], T2.[WWPNotificationMetadata], T3.[WWPNotificationDefinitionName], TM1.[WWPWebNotificationText], TM1.[WWPWebNotificationIcon], TM1.[WWPWebNotificationClientId], TM1.[WWPWebNotificationStatus], TM1.[WWPWebNotificationCreated], TM1.[WWPWebNotificationScheduled], TM1.[WWPWebNotificationProcessed], TM1.[WWPWebNotificationRead], TM1.[WWPWebNotificationDetail], TM1.[WWPWebNotificationReceived], TM1.[WWPNotificationId] FROM (([WWP_WebNotification] TM1 LEFT JOIN [WWP_Notification] T2 ON T2.[WWPNotificationId] = TM1.[WWPNotificationId]) LEFT JOIN [WWP_NotificationDefinition] T3 ON T3.[WWPNotificationDefinitionId] = T2.[WWPNotificationDefinitionId]) WHERE TM1.[WWPWebNotificationId] = ? ORDER BY TM1.[WWPWebNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W7", "SELECT [WWPNotificationDefinitionId], [WWPNotificationCreated], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W8", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W9", "SELECT [WWPWebNotificationId] FROM [WWP_WebNotification] WHERE [WWPWebNotificationId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W10", "SELECT TOP 1 [WWPWebNotificationId] FROM [WWP_WebNotification] WHERE ( [WWPWebNotificationId] > ?) ORDER BY [WWPWebNotificationId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000W11", "SELECT TOP 1 [WWPWebNotificationId] FROM [WWP_WebNotification] WHERE ( [WWPWebNotificationId] < ?) ORDER BY [WWPWebNotificationId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000W12", "INSERT INTO [WWP_WebNotification]([WWPWebNotificationTitle], [WWPWebNotificationText], [WWPWebNotificationIcon], [WWPWebNotificationClientId], [WWPWebNotificationStatus], [WWPWebNotificationCreated], [WWPWebNotificationScheduled], [WWPWebNotificationProcessed], [WWPWebNotificationRead], [WWPWebNotificationDetail], [WWPWebNotificationReceived], [WWPNotificationId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000W13", "UPDATE [WWP_WebNotification] SET [WWPWebNotificationTitle]=?, [WWPWebNotificationText]=?, [WWPWebNotificationIcon]=?, [WWPWebNotificationClientId]=?, [WWPWebNotificationStatus]=?, [WWPWebNotificationCreated]=?, [WWPWebNotificationScheduled]=?, [WWPWebNotificationProcessed]=?, [WWPWebNotificationRead]=?, [WWPWebNotificationDetail]=?, [WWPWebNotificationReceived]=?, [WWPNotificationId]=?  WHERE [WWPWebNotificationId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000W14", "DELETE FROM [WWP_WebNotification]  WHERE [WWPWebNotificationId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000W15", "SELECT [WWPNotificationDefinitionId], [WWPNotificationCreated], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W16", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000W17", "SELECT [WWPWebNotificationId] FROM [WWP_WebNotification] ORDER BY [WWPWebNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(9, true);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDateTime(10, true);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((long[]) buf[15])[0] = rslt.getLong(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7, true);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDateTime(8, true);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(9, true);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDateTime(10, true);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((boolean[]) buf[13])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((long[]) buf[15])[0] = rslt.getLong(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDateTime(11, true);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(12, true);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDateTime(13, true);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDateTime(14, true);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getLongVarchar(15);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((boolean[]) buf[18])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((long[]) buf[20])[0] = rslt.getLong(17);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               stmt.setVarchar(3, (String)parms[2], 255, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               stmt.setDateTime(7, (java.util.Date)parms[6], false, true);
               stmt.setDateTime(8, (java.util.Date)parms[7], false, true);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(9, (java.util.Date)parms[9], false, true);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(10, (String)parms[11]);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[13]).booleanValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(12, ((Number) parms[15]).longValue());
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               stmt.setVarchar(3, (String)parms[2], 255, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDateTime(6, (java.util.Date)parms[5], false, true);
               stmt.setDateTime(7, (java.util.Date)parms[6], false, true);
               stmt.setDateTime(8, (java.util.Date)parms[7], false, true);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(9, (java.util.Date)parms[9], false, true);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(10, (String)parms[11]);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[13]).booleanValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(12, ((Number) parms[15]).longValue());
               }
               stmt.setLong(13, ((Number) parms[16]).longValue());
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
      }
   }

}

