package com.mujermorena.wwpbaseobjects.subscriptions ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_subscription_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A35WWPNotificationDefinitionId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
      {
         A33WWPEntityId = GXutil.lval( httpContext.GetPar( "WWPEntityId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A33WWPEntityId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A32WWPUserExtendedId = httpContext.GetPar( "WWPUserExtendedId") ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A32WWPUserExtendedId) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_Subscription", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPSubscriptionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_subscription_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_subscription_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_subscription_impl.class ));
   }

   public wwp_subscription_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkWWPSubscriptionSubscribed = UIFactory.getCheckbox(this);
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
      A152WWPSubscriptionSubscribed = GXutil.strtobool( GXutil.booltostr( A152WWPSubscriptionSubscribed)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "WWP_Subscription", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSubscriptionId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSubscriptionId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPSubscriptionId_Internalname, GXutil.ltrim( localUtil.ntoc( A34WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPSubscriptionId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A34WWPSubscriptionId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A34WWPSubscriptionId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPSubscriptionId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPSubscriptionId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionId_Internalname, httpContext.getMessage( "Notification Definition Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionId_Internalname, GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationDefinitionId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionDescr_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionDescr_Internalname, httpContext.getMessage( "Notification Definition Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationDefinitionDescr_Internalname, A154WWPNotificationDefinitionDescr, "", "", (short)(0), 1, edtWWPNotificationDefinitionDescr_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPEntityName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPEntityName_Internalname, httpContext.getMessage( "Entity Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPEntityName_Internalname, A150WWPEntityName, GXutil.rtrim( localUtil.format( A150WWPEntityName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPEntityName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPEntityName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedId_Internalname, httpContext.getMessage( "User Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedId_Internalname, GXutil.rtrim( A32WWPUserExtendedId), GXutil.rtrim( localUtil.format( A32WWPUserExtendedId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedId_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_GAMGUID", "left", true, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedFullName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedFullName_Internalname, httpContext.getMessage( "User Full Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedFullName_Internalname, A138WWPUserExtendedFullName, GXutil.rtrim( localUtil.format( A138WWPUserExtendedFullName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedFullName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSubscriptionEntityRecordId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSubscriptionEntityRecordId_Internalname, httpContext.getMessage( "Record Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPSubscriptionEntityRecordId_Internalname, A151WWPSubscriptionEntityRecordId, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", (short)(0), 1, edtWWPSubscriptionEntityRecordId_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSubscriptionEntityRecordDes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSubscriptionEntityRecordDes_Internalname, httpContext.getMessage( "Record Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPSubscriptionEntityRecordDes_Internalname, A153WWPSubscriptionEntityRecordDes, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtWWPSubscriptionEntityRecordDes_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPSubscriptionRoleId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPSubscriptionRoleId_Internalname, httpContext.getMessage( "Role Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPSubscriptionRoleId_Internalname, GXutil.rtrim( A149WWPSubscriptionRoleId), GXutil.rtrim( localUtil.format( A149WWPSubscriptionRoleId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPSubscriptionRoleId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPSubscriptionRoleId_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_GAMGUID", "left", true, "", "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPSubscriptionSubscribed.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPSubscriptionSubscribed.getInternalname(), httpContext.getMessage( "Subscribed", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPSubscriptionSubscribed.getInternalname(), GXutil.booltostr( A152WWPSubscriptionSubscribed), "", httpContext.getMessage( "Subscribed", ""), 1, chkWWPSubscriptionSubscribed.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(79, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,79);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Subscriptions\\WWP_Subscription.htm");
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
         Z34WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( "Z34WWPSubscriptionId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z151WWPSubscriptionEntityRecordId = httpContext.cgiGet( "Z151WWPSubscriptionEntityRecordId") ;
         Z153WWPSubscriptionEntityRecordDes = httpContext.cgiGet( "Z153WWPSubscriptionEntityRecordDes") ;
         Z149WWPSubscriptionRoleId = httpContext.cgiGet( "Z149WWPSubscriptionRoleId") ;
         n149WWPSubscriptionRoleId = ((GXutil.strcmp("", A149WWPSubscriptionRoleId)==0) ? true : false) ;
         Z152WWPSubscriptionSubscribed = GXutil.strtobool( httpContext.cgiGet( "Z152WWPSubscriptionSubscribed")) ;
         Z35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( "Z35WWPNotificationDefinitionId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z32WWPUserExtendedId = httpContext.cgiGet( "Z32WWPUserExtendedId") ;
         n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A33WWPEntityId = localUtil.ctol( httpContext.cgiGet( "WWPENTITYID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPSubscriptionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPSubscriptionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPSUBSCRIPTIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPSubscriptionId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A34WWPSubscriptionId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
         }
         else
         {
            A34WWPSubscriptionId = localUtil.ctol( httpContext.cgiGet( edtWWPSubscriptionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPNotificationDefinitionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPNotificationDefinitionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPNOTIFICATIONDEFINITIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A35WWPNotificationDefinitionId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         }
         else
         {
            A35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( edtWWPNotificationDefinitionId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         }
         A154WWPNotificationDefinitionDescr = httpContext.cgiGet( edtWWPNotificationDefinitionDescr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
         A150WWPEntityName = httpContext.cgiGet( edtWWPEntityName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
         A32WWPUserExtendedId = httpContext.cgiGet( edtWWPUserExtendedId_Internalname) ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
         A138WWPUserExtendedFullName = httpContext.cgiGet( edtWWPUserExtendedFullName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A151WWPSubscriptionEntityRecordId = httpContext.cgiGet( edtWWPSubscriptionEntityRecordId_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A151WWPSubscriptionEntityRecordId", A151WWPSubscriptionEntityRecordId);
         A153WWPSubscriptionEntityRecordDes = httpContext.cgiGet( edtWWPSubscriptionEntityRecordDes_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A153WWPSubscriptionEntityRecordDes", A153WWPSubscriptionEntityRecordDes);
         A149WWPSubscriptionRoleId = httpContext.cgiGet( edtWWPSubscriptionRoleId_Internalname) ;
         n149WWPSubscriptionRoleId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A149WWPSubscriptionRoleId", A149WWPSubscriptionRoleId);
         n149WWPSubscriptionRoleId = ((GXutil.strcmp("", A149WWPSubscriptionRoleId)==0) ? true : false) ;
         A152WWPSubscriptionSubscribed = GXutil.strtobool( httpContext.cgiGet( chkWWPSubscriptionSubscribed.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
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
            A34WWPSubscriptionId = GXutil.lval( httpContext.GetPar( "WWPSubscriptionId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
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
            initAll0U32( ) ;
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
      disableAttributes0U32( ) ;
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

   public void resetCaption0U0( )
   {
   }

   public void zm0U32( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z151WWPSubscriptionEntityRecordId = T000U3_A151WWPSubscriptionEntityRecordId[0] ;
            Z153WWPSubscriptionEntityRecordDes = T000U3_A153WWPSubscriptionEntityRecordDes[0] ;
            Z149WWPSubscriptionRoleId = T000U3_A149WWPSubscriptionRoleId[0] ;
            Z152WWPSubscriptionSubscribed = T000U3_A152WWPSubscriptionSubscribed[0] ;
            Z35WWPNotificationDefinitionId = T000U3_A35WWPNotificationDefinitionId[0] ;
            Z32WWPUserExtendedId = T000U3_A32WWPUserExtendedId[0] ;
         }
         else
         {
            Z151WWPSubscriptionEntityRecordId = A151WWPSubscriptionEntityRecordId ;
            Z153WWPSubscriptionEntityRecordDes = A153WWPSubscriptionEntityRecordDes ;
            Z149WWPSubscriptionRoleId = A149WWPSubscriptionRoleId ;
            Z152WWPSubscriptionSubscribed = A152WWPSubscriptionSubscribed ;
            Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
            Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z34WWPSubscriptionId = A34WWPSubscriptionId ;
         Z151WWPSubscriptionEntityRecordId = A151WWPSubscriptionEntityRecordId ;
         Z153WWPSubscriptionEntityRecordDes = A153WWPSubscriptionEntityRecordDes ;
         Z149WWPSubscriptionRoleId = A149WWPSubscriptionRoleId ;
         Z152WWPSubscriptionSubscribed = A152WWPSubscriptionSubscribed ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         Z33WWPEntityId = A33WWPEntityId ;
         Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
         Z150WWPEntityName = A150WWPEntityName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
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
   }

   public void load0U32( )
   {
      /* Using cursor T000U7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A33WWPEntityId = T000U7_A33WWPEntityId[0] ;
         A154WWPNotificationDefinitionDescr = T000U7_A154WWPNotificationDefinitionDescr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
         A150WWPEntityName = T000U7_A150WWPEntityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
         A138WWPUserExtendedFullName = T000U7_A138WWPUserExtendedFullName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A151WWPSubscriptionEntityRecordId = T000U7_A151WWPSubscriptionEntityRecordId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A151WWPSubscriptionEntityRecordId", A151WWPSubscriptionEntityRecordId);
         A153WWPSubscriptionEntityRecordDes = T000U7_A153WWPSubscriptionEntityRecordDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153WWPSubscriptionEntityRecordDes", A153WWPSubscriptionEntityRecordDes);
         A149WWPSubscriptionRoleId = T000U7_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = T000U7_n149WWPSubscriptionRoleId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A149WWPSubscriptionRoleId", A149WWPSubscriptionRoleId);
         A152WWPSubscriptionSubscribed = T000U7_A152WWPSubscriptionSubscribed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
         A35WWPNotificationDefinitionId = T000U7_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         A32WWPUserExtendedId = T000U7_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000U7_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         zm0U32( -2) ;
      }
      pr_default.close(5);
      onLoadActions0U32( ) ;
   }

   public void onLoadActions0U32( )
   {
   }

   public void checkExtendedTable0U32( )
   {
      nIsDirty_32 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000U4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A33WWPEntityId = T000U4_A33WWPEntityId[0] ;
      A154WWPNotificationDefinitionDescr = T000U4_A154WWPNotificationDefinitionDescr[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      pr_default.close(2);
      /* Using cursor T000U6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
      }
      A150WWPEntityName = T000U6_A150WWPEntityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      pr_default.close(4);
      /* Using cursor T000U5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A138WWPUserExtendedFullName = T000U5_A138WWPUserExtendedFullName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      pr_default.close(3);
   }

   public void closeExtendedTableCursors0U32( )
   {
      pr_default.close(2);
      pr_default.close(4);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( long A35WWPNotificationDefinitionId )
   {
      /* Using cursor T000U8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A33WWPEntityId = T000U8_A33WWPEntityId[0] ;
      A154WWPNotificationDefinitionDescr = T000U8_A154WWPNotificationDefinitionDescr[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A154WWPNotificationDefinitionDescr)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_5( long A33WWPEntityId )
   {
      /* Using cursor T000U9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
      }
      A150WWPEntityName = T000U9_A150WWPEntityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A150WWPEntityName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_4( String A32WWPUserExtendedId )
   {
      /* Using cursor T000U10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A138WWPUserExtendedFullName = T000U10_A138WWPUserExtendedFullName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A138WWPUserExtendedFullName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey0U32( )
   {
      /* Using cursor T000U11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound32 = (short)(1) ;
      }
      else
      {
         RcdFound32 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000U3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0U32( 2) ;
         RcdFound32 = (short)(1) ;
         A34WWPSubscriptionId = T000U3_A34WWPSubscriptionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
         A151WWPSubscriptionEntityRecordId = T000U3_A151WWPSubscriptionEntityRecordId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A151WWPSubscriptionEntityRecordId", A151WWPSubscriptionEntityRecordId);
         A153WWPSubscriptionEntityRecordDes = T000U3_A153WWPSubscriptionEntityRecordDes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153WWPSubscriptionEntityRecordDes", A153WWPSubscriptionEntityRecordDes);
         A149WWPSubscriptionRoleId = T000U3_A149WWPSubscriptionRoleId[0] ;
         n149WWPSubscriptionRoleId = T000U3_n149WWPSubscriptionRoleId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A149WWPSubscriptionRoleId", A149WWPSubscriptionRoleId);
         A152WWPSubscriptionSubscribed = T000U3_A152WWPSubscriptionSubscribed[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
         A35WWPNotificationDefinitionId = T000U3_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         A32WWPUserExtendedId = T000U3_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000U3_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         Z34WWPSubscriptionId = A34WWPSubscriptionId ;
         sMode32 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0U32( ) ;
         if ( AnyError == 1 )
         {
            RcdFound32 = (short)(0) ;
            initializeNonKey0U32( ) ;
         }
         Gx_mode = sMode32 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound32 = (short)(0) ;
         initializeNonKey0U32( ) ;
         sMode32 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode32 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0U32( ) ;
      if ( RcdFound32 == 0 )
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
      RcdFound32 = (short)(0) ;
      /* Using cursor T000U12 */
      pr_default.execute(10, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000U12_A34WWPSubscriptionId[0] < A34WWPSubscriptionId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000U12_A34WWPSubscriptionId[0] > A34WWPSubscriptionId ) ) )
         {
            A34WWPSubscriptionId = T000U12_A34WWPSubscriptionId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
            RcdFound32 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound32 = (short)(0) ;
      /* Using cursor T000U13 */
      pr_default.execute(11, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000U13_A34WWPSubscriptionId[0] > A34WWPSubscriptionId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000U13_A34WWPSubscriptionId[0] < A34WWPSubscriptionId ) ) )
         {
            A34WWPSubscriptionId = T000U13_A34WWPSubscriptionId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
            RcdFound32 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0U32( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPSubscriptionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0U32( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound32 == 1 )
         {
            if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
            {
               A34WWPSubscriptionId = Z34WWPSubscriptionId ;
               httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPSUBSCRIPTIONID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPSubscriptionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPSubscriptionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0U32( ) ;
               GX_FocusControl = edtWWPSubscriptionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPSubscriptionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0U32( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPSUBSCRIPTIONID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPSubscriptionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPSubscriptionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0U32( ) ;
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
      if ( A34WWPSubscriptionId != Z34WWPSubscriptionId )
      {
         A34WWPSubscriptionId = Z34WWPSubscriptionId ;
         httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPSUBSCRIPTIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSubscriptionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPSubscriptionId_Internalname ;
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
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPSUBSCRIPTIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPSubscriptionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0U32( ) ;
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
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
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
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
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
      scanStart0U32( ) ;
      if ( RcdFound32 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound32 != 0 )
         {
            scanNext0U32( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0U32( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0U32( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000U2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Subscription"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z151WWPSubscriptionEntityRecordId, T000U2_A151WWPSubscriptionEntityRecordId[0]) != 0 ) || ( GXutil.strcmp(Z153WWPSubscriptionEntityRecordDes, T000U2_A153WWPSubscriptionEntityRecordDes[0]) != 0 ) || ( GXutil.strcmp(Z149WWPSubscriptionRoleId, T000U2_A149WWPSubscriptionRoleId[0]) != 0 ) || ( Z152WWPSubscriptionSubscribed != T000U2_A152WWPSubscriptionSubscribed[0] ) || ( Z35WWPNotificationDefinitionId != T000U2_A35WWPNotificationDefinitionId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z32WWPUserExtendedId, T000U2_A32WWPUserExtendedId[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z151WWPSubscriptionEntityRecordId, T000U2_A151WWPSubscriptionEntityRecordId[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.subscriptions.wwp_subscription:[seudo value changed for attri]"+"WWPSubscriptionEntityRecordId");
               GXutil.writeLogRaw("Old: ",Z151WWPSubscriptionEntityRecordId);
               GXutil.writeLogRaw("Current: ",T000U2_A151WWPSubscriptionEntityRecordId[0]);
            }
            if ( GXutil.strcmp(Z153WWPSubscriptionEntityRecordDes, T000U2_A153WWPSubscriptionEntityRecordDes[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.subscriptions.wwp_subscription:[seudo value changed for attri]"+"WWPSubscriptionEntityRecordDes");
               GXutil.writeLogRaw("Old: ",Z153WWPSubscriptionEntityRecordDes);
               GXutil.writeLogRaw("Current: ",T000U2_A153WWPSubscriptionEntityRecordDes[0]);
            }
            if ( GXutil.strcmp(Z149WWPSubscriptionRoleId, T000U2_A149WWPSubscriptionRoleId[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.subscriptions.wwp_subscription:[seudo value changed for attri]"+"WWPSubscriptionRoleId");
               GXutil.writeLogRaw("Old: ",Z149WWPSubscriptionRoleId);
               GXutil.writeLogRaw("Current: ",T000U2_A149WWPSubscriptionRoleId[0]);
            }
            if ( Z152WWPSubscriptionSubscribed != T000U2_A152WWPSubscriptionSubscribed[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.subscriptions.wwp_subscription:[seudo value changed for attri]"+"WWPSubscriptionSubscribed");
               GXutil.writeLogRaw("Old: ",Z152WWPSubscriptionSubscribed);
               GXutil.writeLogRaw("Current: ",T000U2_A152WWPSubscriptionSubscribed[0]);
            }
            if ( Z35WWPNotificationDefinitionId != T000U2_A35WWPNotificationDefinitionId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.subscriptions.wwp_subscription:[seudo value changed for attri]"+"WWPNotificationDefinitionId");
               GXutil.writeLogRaw("Old: ",Z35WWPNotificationDefinitionId);
               GXutil.writeLogRaw("Current: ",T000U2_A35WWPNotificationDefinitionId[0]);
            }
            if ( GXutil.strcmp(Z32WWPUserExtendedId, T000U2_A32WWPUserExtendedId[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.subscriptions.wwp_subscription:[seudo value changed for attri]"+"WWPUserExtendedId");
               GXutil.writeLogRaw("Old: ",Z32WWPUserExtendedId);
               GXutil.writeLogRaw("Current: ",T000U2_A32WWPUserExtendedId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Subscription"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0U32( )
   {
      if ( ! IsAuthorized("wwpsubscription_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0U32( 0) ;
         checkOptimisticConcurrency0U32( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0U32( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0U32( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000U14 */
                  pr_default.execute(12, new Object[] {A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, Boolean.valueOf(n149WWPSubscriptionRoleId), A149WWPSubscriptionRoleId, Boolean.valueOf(A152WWPSubscriptionSubscribed), Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  A34WWPSubscriptionId = T000U14_A34WWPSubscriptionId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
                  pr_default.close(12);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0U0( ) ;
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
            load0U32( ) ;
         }
         endLevel0U32( ) ;
      }
      closeExtendedTableCursors0U32( ) ;
   }

   public void update0U32( )
   {
      if ( ! IsAuthorized("wwpsubscription_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0U32( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0U32( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0U32( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000U15 */
                  pr_default.execute(13, new Object[] {A151WWPSubscriptionEntityRecordId, A153WWPSubscriptionEntityRecordDes, Boolean.valueOf(n149WWPSubscriptionRoleId), A149WWPSubscriptionRoleId, Boolean.valueOf(A152WWPSubscriptionSubscribed), Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, Long.valueOf(A34WWPSubscriptionId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Subscription"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0U32( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0U0( ) ;
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
         endLevel0U32( ) ;
      }
      closeExtendedTableCursors0U32( ) ;
   }

   public void deferredUpdate0U32( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("wwpsubscription_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0U32( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0U32( ) ;
         afterConfirm0U32( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0U32( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000U16 */
               pr_default.execute(14, new Object[] {Long.valueOf(A34WWPSubscriptionId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Subscription");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound32 == 0 )
                     {
                        initAll0U32( ) ;
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
                     resetCaption0U0( ) ;
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
      sMode32 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0U32( ) ;
      Gx_mode = sMode32 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0U32( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000U17 */
         pr_default.execute(15, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         A33WWPEntityId = T000U17_A33WWPEntityId[0] ;
         A154WWPNotificationDefinitionDescr = T000U17_A154WWPNotificationDefinitionDescr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
         pr_default.close(15);
         /* Using cursor T000U18 */
         pr_default.execute(16, new Object[] {Long.valueOf(A33WWPEntityId)});
         A150WWPEntityName = T000U18_A150WWPEntityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
         pr_default.close(16);
         /* Using cursor T000U19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         A138WWPUserExtendedFullName = T000U19_A138WWPUserExtendedFullName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         pr_default.close(17);
      }
   }

   public void endLevel0U32( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0U32( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(15);
         pr_default.close(17);
         pr_default.close(16);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscription");
         if ( AnyError == 0 )
         {
            confirmValues0U0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(15);
         pr_default.close(17);
         pr_default.close(16);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.subscriptions.wwp_subscription");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0U32( )
   {
      /* Using cursor T000U20 */
      pr_default.execute(18);
      RcdFound32 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A34WWPSubscriptionId = T000U20_A34WWPSubscriptionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0U32( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound32 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A34WWPSubscriptionId = T000U20_A34WWPSubscriptionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
      }
   }

   public void scanEnd0U32( )
   {
      pr_default.close(18);
   }

   public void afterConfirm0U32( )
   {
      /* After Confirm Rules */
      if ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) )
      {
         A32WWPUserExtendedId = "" ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         n32WWPUserExtendedId = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      }
   }

   public void beforeInsert0U32( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0U32( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0U32( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0U32( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0U32( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0U32( )
   {
      edtWWPSubscriptionId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSubscriptionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSubscriptionId_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionId_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionDescr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionDescr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionDescr_Enabled), 5, 0), true);
      edtWWPEntityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPEntityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPEntityName_Enabled), 5, 0), true);
      edtWWPUserExtendedId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedId_Enabled), 5, 0), true);
      edtWWPUserExtendedFullName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedFullName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedFullName_Enabled), 5, 0), true);
      edtWWPSubscriptionEntityRecordId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSubscriptionEntityRecordId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSubscriptionEntityRecordId_Enabled), 5, 0), true);
      edtWWPSubscriptionEntityRecordDes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSubscriptionEntityRecordDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSubscriptionEntityRecordDes_Enabled), 5, 0), true);
      edtWWPSubscriptionRoleId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPSubscriptionRoleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPSubscriptionRoleId_Enabled), 5, 0), true);
      chkWWPSubscriptionSubscribed.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPSubscriptionSubscribed.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPSubscriptionSubscribed.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0U32( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0U0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z34WWPSubscriptionId", GXutil.ltrim( localUtil.ntoc( Z34WWPSubscriptionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z151WWPSubscriptionEntityRecordId", Z151WWPSubscriptionEntityRecordId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z153WWPSubscriptionEntityRecordDes", Z153WWPSubscriptionEntityRecordDes);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z149WWPSubscriptionRoleId", GXutil.rtrim( Z149WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z152WWPSubscriptionSubscribed", Z152WWPSubscriptionSubscribed);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPENTITYID", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Subscriptions.WWP_Subscription" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_Subscription", "") ;
   }

   public void initializeNonKey0U32( )
   {
      A33WWPEntityId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
      A35WWPNotificationDefinitionId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
      A154WWPNotificationDefinitionDescr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      A150WWPEntityName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
      A138WWPUserExtendedFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      A151WWPSubscriptionEntityRecordId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A151WWPSubscriptionEntityRecordId", A151WWPSubscriptionEntityRecordId);
      A153WWPSubscriptionEntityRecordDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A153WWPSubscriptionEntityRecordDes", A153WWPSubscriptionEntityRecordDes);
      A149WWPSubscriptionRoleId = "" ;
      n149WWPSubscriptionRoleId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A149WWPSubscriptionRoleId", A149WWPSubscriptionRoleId);
      n149WWPSubscriptionRoleId = ((GXutil.strcmp("", A149WWPSubscriptionRoleId)==0) ? true : false) ;
      A152WWPSubscriptionSubscribed = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
      Z151WWPSubscriptionEntityRecordId = "" ;
      Z153WWPSubscriptionEntityRecordDes = "" ;
      Z149WWPSubscriptionRoleId = "" ;
      Z152WWPSubscriptionSubscribed = false ;
      Z35WWPNotificationDefinitionId = 0 ;
      Z32WWPUserExtendedId = "" ;
   }

   public void initAll0U32( )
   {
      A34WWPSubscriptionId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A34WWPSubscriptionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34WWPSubscriptionId), 10, 0));
      initializeNonKey0U32( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211110197", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/subscriptions/wwp_subscription.js", "?20241211110197", false, true);
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
      edtWWPSubscriptionId_Internalname = "WWPSUBSCRIPTIONID" ;
      edtWWPNotificationDefinitionId_Internalname = "WWPNOTIFICATIONDEFINITIONID" ;
      edtWWPNotificationDefinitionDescr_Internalname = "WWPNOTIFICATIONDEFINITIONDESCR" ;
      edtWWPEntityName_Internalname = "WWPENTITYNAME" ;
      edtWWPUserExtendedId_Internalname = "WWPUSEREXTENDEDID" ;
      edtWWPUserExtendedFullName_Internalname = "WWPUSEREXTENDEDFULLNAME" ;
      edtWWPSubscriptionEntityRecordId_Internalname = "WWPSUBSCRIPTIONENTITYRECORDID" ;
      edtWWPSubscriptionEntityRecordDes_Internalname = "WWPSUBSCRIPTIONENTITYRECORDDES" ;
      edtWWPSubscriptionRoleId_Internalname = "WWPSUBSCRIPTIONROLEID" ;
      chkWWPSubscriptionSubscribed.setInternalname( "WWPSUBSCRIPTIONSUBSCRIBED" );
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
      Form.setCaption( httpContext.getMessage( "WWP_Subscription", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      chkWWPSubscriptionSubscribed.setEnabled( 1 );
      edtWWPSubscriptionRoleId_Jsonclick = "" ;
      edtWWPSubscriptionRoleId_Enabled = 1 ;
      edtWWPSubscriptionEntityRecordDes_Enabled = 1 ;
      edtWWPSubscriptionEntityRecordId_Enabled = 1 ;
      edtWWPUserExtendedFullName_Jsonclick = "" ;
      edtWWPUserExtendedFullName_Enabled = 0 ;
      edtWWPUserExtendedId_Jsonclick = "" ;
      edtWWPUserExtendedId_Enabled = 1 ;
      edtWWPEntityName_Jsonclick = "" ;
      edtWWPEntityName_Enabled = 0 ;
      edtWWPNotificationDefinitionDescr_Enabled = 0 ;
      edtWWPNotificationDefinitionId_Jsonclick = "" ;
      edtWWPNotificationDefinitionId_Enabled = 1 ;
      edtWWPSubscriptionId_Jsonclick = "" ;
      edtWWPSubscriptionId_Enabled = 1 ;
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
      chkWWPSubscriptionSubscribed.setName( "WWPSUBSCRIPTIONSUBSCRIBED" );
      chkWWPSubscriptionSubscribed.setWebtags( "" );
      chkWWPSubscriptionSubscribed.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPSubscriptionSubscribed.getInternalname(), "TitleCaption", chkWWPSubscriptionSubscribed.getCaption(), true);
      chkWWPSubscriptionSubscribed.setCheckedValue( "false" );
      A152WWPSubscriptionSubscribed = GXutil.strtobool( GXutil.booltostr( A152WWPSubscriptionSubscribed)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
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

   public void valid_Wwpsubscriptionid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      A152WWPSubscriptionSubscribed = GXutil.strtobool( GXutil.booltostr( A152WWPSubscriptionSubscribed)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", GXutil.rtrim( A32WWPUserExtendedId));
      httpContext.ajax_rsp_assign_attri("", false, "A151WWPSubscriptionEntityRecordId", A151WWPSubscriptionEntityRecordId);
      httpContext.ajax_rsp_assign_attri("", false, "A153WWPSubscriptionEntityRecordDes", A153WWPSubscriptionEntityRecordDes);
      httpContext.ajax_rsp_assign_attri("", false, "A149WWPSubscriptionRoleId", GXutil.rtrim( A149WWPSubscriptionRoleId));
      httpContext.ajax_rsp_assign_attri("", false, "A152WWPSubscriptionSubscribed", A152WWPSubscriptionSubscribed);
      httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z34WWPSubscriptionId", GXutil.ltrim( localUtil.ntoc( Z34WWPSubscriptionId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z151WWPSubscriptionEntityRecordId", Z151WWPSubscriptionEntityRecordId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z153WWPSubscriptionEntityRecordDes", Z153WWPSubscriptionEntityRecordDes);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z149WWPSubscriptionRoleId", GXutil.rtrim( Z149WWPSubscriptionRoleId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z152WWPSubscriptionSubscribed", GXutil.booltostr( Z152WWPSubscriptionSubscribed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z33WWPEntityId", GXutil.ltrim( localUtil.ntoc( Z33WWPEntityId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z154WWPNotificationDefinitionDescr", Z154WWPNotificationDefinitionDescr);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z150WWPEntityName", Z150WWPEntityName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z138WWPUserExtendedFullName", Z138WWPUserExtendedFullName);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpnotificationdefinitionid( )
   {
      /* Using cursor T000U17 */
      pr_default.execute(15, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
      }
      A33WWPEntityId = T000U17_A33WWPEntityId[0] ;
      A154WWPNotificationDefinitionDescr = T000U17_A154WWPNotificationDefinitionDescr[0] ;
      pr_default.close(15);
      /* Using cursor T000U18 */
      pr_default.execute(16, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
      }
      A150WWPEntityName = T000U18_A150WWPEntityName[0] ;
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
   }

   public void valid_Wwpuserextendedid( )
   {
      n32WWPUserExtendedId = false ;
      /* Using cursor T000U19 */
      pr_default.execute(17, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(17) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         }
      }
      A138WWPUserExtendedFullName = T000U19_A138WWPUserExtendedFullName[0] ;
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]}");
      setEventMetadata("VALID_WWPSUBSCRIPTIONID","{handler:'valid_Wwpsubscriptionid',iparms:[{av:'A34WWPSubscriptionId',fld:'WWPSUBSCRIPTIONID',pic:'ZZZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]");
      setEventMetadata("VALID_WWPSUBSCRIPTIONID",",oparms:[{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A151WWPSubscriptionEntityRecordId',fld:'WWPSUBSCRIPTIONENTITYRECORDID',pic:''},{av:'A153WWPSubscriptionEntityRecordDes',fld:'WWPSUBSCRIPTIONENTITYRECORDDES',pic:''},{av:'A149WWPSubscriptionRoleId',fld:'WWPSUBSCRIPTIONROLEID',pic:''},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z34WWPSubscriptionId'},{av:'Z35WWPNotificationDefinitionId'},{av:'Z32WWPUserExtendedId'},{av:'Z151WWPSubscriptionEntityRecordId'},{av:'Z153WWPSubscriptionEntityRecordDes'},{av:'Z149WWPSubscriptionRoleId'},{av:'Z152WWPSubscriptionSubscribed'},{av:'Z33WWPEntityId'},{av:'Z154WWPNotificationDefinitionDescr'},{av:'Z150WWPEntityName'},{av:'Z138WWPUserExtendedFullName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONID","{handler:'valid_Wwpnotificationdefinitionid',iparms:[{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONID",",oparms:[{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]}");
      setEventMetadata("VALID_WWPUSEREXTENDEDID","{handler:'valid_Wwpuserextendedid',iparms:[{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]");
      setEventMetadata("VALID_WWPUSEREXTENDEDID",",oparms:[{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'A152WWPSubscriptionSubscribed',fld:'WWPSUBSCRIPTIONSUBSCRIBED',pic:''}]}");
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
      return "wwpsubscription_Execute";
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
      pr_default.close(15);
      pr_default.close(17);
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z151WWPSubscriptionEntityRecordId = "" ;
      Z153WWPSubscriptionEntityRecordDes = "" ;
      Z149WWPSubscriptionRoleId = "" ;
      Z32WWPUserExtendedId = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A32WWPUserExtendedId = "" ;
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
      A154WWPNotificationDefinitionDescr = "" ;
      A150WWPEntityName = "" ;
      A138WWPUserExtendedFullName = "" ;
      A151WWPSubscriptionEntityRecordId = "" ;
      A153WWPSubscriptionEntityRecordDes = "" ;
      A149WWPSubscriptionRoleId = "" ;
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
      Z154WWPNotificationDefinitionDescr = "" ;
      Z150WWPEntityName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      T000U7_A33WWPEntityId = new long[1] ;
      T000U7_A34WWPSubscriptionId = new long[1] ;
      T000U7_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000U7_A150WWPEntityName = new String[] {""} ;
      T000U7_A138WWPUserExtendedFullName = new String[] {""} ;
      T000U7_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      T000U7_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      T000U7_A149WWPSubscriptionRoleId = new String[] {""} ;
      T000U7_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      T000U7_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      T000U7_A35WWPNotificationDefinitionId = new long[1] ;
      T000U7_A32WWPUserExtendedId = new String[] {""} ;
      T000U7_n32WWPUserExtendedId = new boolean[] {false} ;
      T000U4_A33WWPEntityId = new long[1] ;
      T000U4_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000U6_A150WWPEntityName = new String[] {""} ;
      T000U5_A138WWPUserExtendedFullName = new String[] {""} ;
      T000U8_A33WWPEntityId = new long[1] ;
      T000U8_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000U9_A150WWPEntityName = new String[] {""} ;
      T000U10_A138WWPUserExtendedFullName = new String[] {""} ;
      T000U11_A34WWPSubscriptionId = new long[1] ;
      T000U3_A34WWPSubscriptionId = new long[1] ;
      T000U3_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      T000U3_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      T000U3_A149WWPSubscriptionRoleId = new String[] {""} ;
      T000U3_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      T000U3_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      T000U3_A35WWPNotificationDefinitionId = new long[1] ;
      T000U3_A32WWPUserExtendedId = new String[] {""} ;
      T000U3_n32WWPUserExtendedId = new boolean[] {false} ;
      sMode32 = "" ;
      T000U12_A34WWPSubscriptionId = new long[1] ;
      T000U13_A34WWPSubscriptionId = new long[1] ;
      T000U2_A34WWPSubscriptionId = new long[1] ;
      T000U2_A151WWPSubscriptionEntityRecordId = new String[] {""} ;
      T000U2_A153WWPSubscriptionEntityRecordDes = new String[] {""} ;
      T000U2_A149WWPSubscriptionRoleId = new String[] {""} ;
      T000U2_n149WWPSubscriptionRoleId = new boolean[] {false} ;
      T000U2_A152WWPSubscriptionSubscribed = new boolean[] {false} ;
      T000U2_A35WWPNotificationDefinitionId = new long[1] ;
      T000U2_A32WWPUserExtendedId = new String[] {""} ;
      T000U2_n32WWPUserExtendedId = new boolean[] {false} ;
      T000U14_A34WWPSubscriptionId = new long[1] ;
      T000U17_A33WWPEntityId = new long[1] ;
      T000U17_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000U18_A150WWPEntityName = new String[] {""} ;
      T000U19_A138WWPUserExtendedFullName = new String[] {""} ;
      T000U20_A34WWPSubscriptionId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ32WWPUserExtendedId = "" ;
      ZZ151WWPSubscriptionEntityRecordId = "" ;
      ZZ153WWPSubscriptionEntityRecordDes = "" ;
      ZZ149WWPSubscriptionRoleId = "" ;
      ZZ154WWPNotificationDefinitionDescr = "" ;
      ZZ150WWPEntityName = "" ;
      ZZ138WWPUserExtendedFullName = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscription__default(),
         new Object[] {
             new Object[] {
            T000U2_A34WWPSubscriptionId, T000U2_A151WWPSubscriptionEntityRecordId, T000U2_A153WWPSubscriptionEntityRecordDes, T000U2_A149WWPSubscriptionRoleId, T000U2_n149WWPSubscriptionRoleId, T000U2_A152WWPSubscriptionSubscribed, T000U2_A35WWPNotificationDefinitionId, T000U2_A32WWPUserExtendedId, T000U2_n32WWPUserExtendedId
            }
            , new Object[] {
            T000U3_A34WWPSubscriptionId, T000U3_A151WWPSubscriptionEntityRecordId, T000U3_A153WWPSubscriptionEntityRecordDes, T000U3_A149WWPSubscriptionRoleId, T000U3_n149WWPSubscriptionRoleId, T000U3_A152WWPSubscriptionSubscribed, T000U3_A35WWPNotificationDefinitionId, T000U3_A32WWPUserExtendedId, T000U3_n32WWPUserExtendedId
            }
            , new Object[] {
            T000U4_A33WWPEntityId, T000U4_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            T000U5_A138WWPUserExtendedFullName
            }
            , new Object[] {
            T000U6_A150WWPEntityName
            }
            , new Object[] {
            T000U7_A33WWPEntityId, T000U7_A34WWPSubscriptionId, T000U7_A154WWPNotificationDefinitionDescr, T000U7_A150WWPEntityName, T000U7_A138WWPUserExtendedFullName, T000U7_A151WWPSubscriptionEntityRecordId, T000U7_A153WWPSubscriptionEntityRecordDes, T000U7_A149WWPSubscriptionRoleId, T000U7_n149WWPSubscriptionRoleId, T000U7_A152WWPSubscriptionSubscribed,
            T000U7_A35WWPNotificationDefinitionId, T000U7_A32WWPUserExtendedId, T000U7_n32WWPUserExtendedId
            }
            , new Object[] {
            T000U8_A33WWPEntityId, T000U8_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            T000U9_A150WWPEntityName
            }
            , new Object[] {
            T000U10_A138WWPUserExtendedFullName
            }
            , new Object[] {
            T000U11_A34WWPSubscriptionId
            }
            , new Object[] {
            T000U12_A34WWPSubscriptionId
            }
            , new Object[] {
            T000U13_A34WWPSubscriptionId
            }
            , new Object[] {
            T000U14_A34WWPSubscriptionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000U17_A33WWPEntityId, T000U17_A154WWPNotificationDefinitionDescr
            }
            , new Object[] {
            T000U18_A150WWPEntityName
            }
            , new Object[] {
            T000U19_A138WWPUserExtendedFullName
            }
            , new Object[] {
            T000U20_A34WWPSubscriptionId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound32 ;
   private short nIsDirty_32 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPSubscriptionId_Enabled ;
   private int edtWWPNotificationDefinitionId_Enabled ;
   private int edtWWPNotificationDefinitionDescr_Enabled ;
   private int edtWWPEntityName_Enabled ;
   private int edtWWPUserExtendedId_Enabled ;
   private int edtWWPUserExtendedFullName_Enabled ;
   private int edtWWPSubscriptionEntityRecordId_Enabled ;
   private int edtWWPSubscriptionEntityRecordDes_Enabled ;
   private int edtWWPSubscriptionRoleId_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private long Z34WWPSubscriptionId ;
   private long Z35WWPNotificationDefinitionId ;
   private long A35WWPNotificationDefinitionId ;
   private long A33WWPEntityId ;
   private long A34WWPSubscriptionId ;
   private long Z33WWPEntityId ;
   private long ZZ34WWPSubscriptionId ;
   private long ZZ35WWPNotificationDefinitionId ;
   private long ZZ33WWPEntityId ;
   private String sPrefix ;
   private String Z149WWPSubscriptionRoleId ;
   private String Z32WWPUserExtendedId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A32WWPUserExtendedId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPSubscriptionId_Internalname ;
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
   private String edtWWPSubscriptionId_Jsonclick ;
   private String edtWWPNotificationDefinitionId_Internalname ;
   private String edtWWPNotificationDefinitionId_Jsonclick ;
   private String edtWWPNotificationDefinitionDescr_Internalname ;
   private String edtWWPEntityName_Internalname ;
   private String edtWWPEntityName_Jsonclick ;
   private String edtWWPUserExtendedId_Internalname ;
   private String edtWWPUserExtendedId_Jsonclick ;
   private String edtWWPUserExtendedFullName_Internalname ;
   private String edtWWPUserExtendedFullName_Jsonclick ;
   private String edtWWPSubscriptionEntityRecordId_Internalname ;
   private String edtWWPSubscriptionEntityRecordDes_Internalname ;
   private String edtWWPSubscriptionRoleId_Internalname ;
   private String A149WWPSubscriptionRoleId ;
   private String edtWWPSubscriptionRoleId_Jsonclick ;
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
   private String sMode32 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ32WWPUserExtendedId ;
   private String ZZ149WWPSubscriptionRoleId ;
   private boolean Z152WWPSubscriptionSubscribed ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n32WWPUserExtendedId ;
   private boolean wbErr ;
   private boolean A152WWPSubscriptionSubscribed ;
   private boolean n149WWPSubscriptionRoleId ;
   private boolean Gx_longc ;
   private boolean ZZ152WWPSubscriptionSubscribed ;
   private String Z151WWPSubscriptionEntityRecordId ;
   private String Z153WWPSubscriptionEntityRecordDes ;
   private String A154WWPNotificationDefinitionDescr ;
   private String A150WWPEntityName ;
   private String A138WWPUserExtendedFullName ;
   private String A151WWPSubscriptionEntityRecordId ;
   private String A153WWPSubscriptionEntityRecordDes ;
   private String Z154WWPNotificationDefinitionDescr ;
   private String Z150WWPEntityName ;
   private String Z138WWPUserExtendedFullName ;
   private String ZZ151WWPSubscriptionEntityRecordId ;
   private String ZZ153WWPSubscriptionEntityRecordDes ;
   private String ZZ154WWPNotificationDefinitionDescr ;
   private String ZZ150WWPEntityName ;
   private String ZZ138WWPUserExtendedFullName ;
   private ICheckbox chkWWPSubscriptionSubscribed ;
   private IDataStoreProvider pr_default ;
   private long[] T000U7_A33WWPEntityId ;
   private long[] T000U7_A34WWPSubscriptionId ;
   private String[] T000U7_A154WWPNotificationDefinitionDescr ;
   private String[] T000U7_A150WWPEntityName ;
   private String[] T000U7_A138WWPUserExtendedFullName ;
   private String[] T000U7_A151WWPSubscriptionEntityRecordId ;
   private String[] T000U7_A153WWPSubscriptionEntityRecordDes ;
   private String[] T000U7_A149WWPSubscriptionRoleId ;
   private boolean[] T000U7_n149WWPSubscriptionRoleId ;
   private boolean[] T000U7_A152WWPSubscriptionSubscribed ;
   private long[] T000U7_A35WWPNotificationDefinitionId ;
   private String[] T000U7_A32WWPUserExtendedId ;
   private boolean[] T000U7_n32WWPUserExtendedId ;
   private long[] T000U4_A33WWPEntityId ;
   private String[] T000U4_A154WWPNotificationDefinitionDescr ;
   private String[] T000U6_A150WWPEntityName ;
   private String[] T000U5_A138WWPUserExtendedFullName ;
   private long[] T000U8_A33WWPEntityId ;
   private String[] T000U8_A154WWPNotificationDefinitionDescr ;
   private String[] T000U9_A150WWPEntityName ;
   private String[] T000U10_A138WWPUserExtendedFullName ;
   private long[] T000U11_A34WWPSubscriptionId ;
   private long[] T000U3_A34WWPSubscriptionId ;
   private String[] T000U3_A151WWPSubscriptionEntityRecordId ;
   private String[] T000U3_A153WWPSubscriptionEntityRecordDes ;
   private String[] T000U3_A149WWPSubscriptionRoleId ;
   private boolean[] T000U3_n149WWPSubscriptionRoleId ;
   private boolean[] T000U3_A152WWPSubscriptionSubscribed ;
   private long[] T000U3_A35WWPNotificationDefinitionId ;
   private String[] T000U3_A32WWPUserExtendedId ;
   private boolean[] T000U3_n32WWPUserExtendedId ;
   private long[] T000U12_A34WWPSubscriptionId ;
   private long[] T000U13_A34WWPSubscriptionId ;
   private long[] T000U2_A34WWPSubscriptionId ;
   private String[] T000U2_A151WWPSubscriptionEntityRecordId ;
   private String[] T000U2_A153WWPSubscriptionEntityRecordDes ;
   private String[] T000U2_A149WWPSubscriptionRoleId ;
   private boolean[] T000U2_n149WWPSubscriptionRoleId ;
   private boolean[] T000U2_A152WWPSubscriptionSubscribed ;
   private long[] T000U2_A35WWPNotificationDefinitionId ;
   private String[] T000U2_A32WWPUserExtendedId ;
   private boolean[] T000U2_n32WWPUserExtendedId ;
   private long[] T000U14_A34WWPSubscriptionId ;
   private long[] T000U17_A33WWPEntityId ;
   private String[] T000U17_A154WWPNotificationDefinitionDescr ;
   private String[] T000U18_A150WWPEntityName ;
   private String[] T000U19_A138WWPUserExtendedFullName ;
   private long[] T000U20_A34WWPSubscriptionId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_subscription__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_subscription__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000U2", "SELECT [WWPSubscriptionId], [WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Subscription] WITH (UPDLOCK) WHERE [WWPSubscriptionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U3", "SELECT [WWPSubscriptionId], [WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Subscription] WHERE [WWPSubscriptionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U4", "SELECT [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U5", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U6", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U7", "SELECT T2.[WWPEntityId], TM1.[WWPSubscriptionId], T2.[WWPNotificationDefinitionDescr], T3.[WWPEntityName], T4.[WWPUserExtendedFullName], TM1.[WWPSubscriptionEntityRecordId], TM1.[WWPSubscriptionEntityRecordDes], TM1.[WWPSubscriptionRoleId], TM1.[WWPSubscriptionSubscribed], TM1.[WWPNotificationDefinitionId], TM1.[WWPUserExtendedId] FROM ((([WWP_Subscription] TM1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = TM1.[WWPNotificationDefinitionId]) INNER JOIN [WWP_Entity] T3 ON T3.[WWPEntityId] = T2.[WWPEntityId]) LEFT JOIN [WWP_UserExtended] T4 ON T4.[WWPUserExtendedId] = TM1.[WWPUserExtendedId]) WHERE TM1.[WWPSubscriptionId] = ? ORDER BY TM1.[WWPSubscriptionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U8", "SELECT [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U9", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U10", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U11", "SELECT [WWPSubscriptionId] FROM [WWP_Subscription] WHERE [WWPSubscriptionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U12", "SELECT TOP 1 [WWPSubscriptionId] FROM [WWP_Subscription] WHERE ( [WWPSubscriptionId] > ?) ORDER BY [WWPSubscriptionId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000U13", "SELECT TOP 1 [WWPSubscriptionId] FROM [WWP_Subscription] WHERE ( [WWPSubscriptionId] < ?) ORDER BY [WWPSubscriptionId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000U14", "INSERT INTO [WWP_Subscription]([WWPSubscriptionEntityRecordId], [WWPSubscriptionEntityRecordDes], [WWPSubscriptionRoleId], [WWPSubscriptionSubscribed], [WWPNotificationDefinitionId], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000U15", "UPDATE [WWP_Subscription] SET [WWPSubscriptionEntityRecordId]=?, [WWPSubscriptionEntityRecordDes]=?, [WWPSubscriptionRoleId]=?, [WWPSubscriptionSubscribed]=?, [WWPNotificationDefinitionId]=?, [WWPUserExtendedId]=?  WHERE [WWPSubscriptionId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000U16", "DELETE FROM [WWP_Subscription]  WHERE [WWPSubscriptionId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000U17", "SELECT [WWPEntityId], [WWPNotificationDefinitionDescr] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U18", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U19", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000U20", "SELECT [WWPSubscriptionId] FROM [WWP_Subscription] ORDER BY [WWPSubscriptionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 40);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((boolean[]) buf[9])[0] = rslt.getBoolean(9);
               ((long[]) buf[10])[0] = rslt.getLong(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 40);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 2000, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setLong(5, ((Number) parms[5]).longValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 40);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 2000, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setLong(5, ((Number) parms[5]).longValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 40);
               }
               stmt.setLong(7, ((Number) parms[8]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
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

