package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_notification_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_6") == 0 )
      {
         A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_6( A35WWPNotificationDefinitionId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_7") == 0 )
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
         gxload_7( A32WWPUserExtendedId) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Notification", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_notification_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_notification_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_notification_impl.class ));
   }

   public wwp_notification_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkWWPNotificationIsRead = UIFactory.getCheckbox(this);
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
      A203WWPNotificationIsRead = GXutil.strtobool( GXutil.booltostr( A203WWPNotificationIsRead)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Notification", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationId_Internalname, GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionId_Internalname, GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationDefinitionId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionName_Internalname, A181WWPNotificationDefinitionName, GXutil.rtrim( localUtil.format( A181WWPNotificationDefinitionName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationCreated_Internalname, httpContext.getMessage( "Created Date", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPNotificationCreated_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationCreated_Internalname, localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A40WWPNotificationCreated, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationCreated_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPNotificationCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPNotificationCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationIcon_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationIcon_Internalname, httpContext.getMessage( "Icon", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationIcon_Internalname, A198WWPNotificationIcon, GXutil.rtrim( localUtil.format( A198WWPNotificationIcon, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationIcon_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationIcon_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationTitle_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationTitle_Internalname, httpContext.getMessage( "Title", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationTitle_Internalname, A199WWPNotificationTitle, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", (short)(0), 1, edtWWPNotificationTitle_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationShortDescriptio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationShortDescriptio_Internalname, httpContext.getMessage( "Short Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationShortDescriptio_Internalname, A200WWPNotificationShortDescriptio, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", (short)(0), 1, edtWWPNotificationShortDescriptio_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationLink_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationLink_Internalname, httpContext.getMessage( "Link", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationLink_Internalname, A201WWPNotificationLink, GXutil.rtrim( localUtil.format( A201WWPNotificationLink, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", A201WWPNotificationLink, "_blank", "", "", edtWWPNotificationLink_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationLink_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPNotificationIsRead.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPNotificationIsRead.getInternalname(), httpContext.getMessage( "Is Read", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPNotificationIsRead.getInternalname(), GXutil.booltostr( A203WWPNotificationIsRead), "", httpContext.getMessage( "Is Read", ""), 1, chkWWPNotificationIsRead.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(74, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,74);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedId_Internalname, GXutil.rtrim( A32WWPUserExtendedId), GXutil.rtrim( localUtil.format( A32WWPUserExtendedId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedId_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_GAMGUID", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedFullName_Internalname, A138WWPUserExtendedFullName, GXutil.rtrim( localUtil.format( A138WWPUserExtendedFullName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedFullName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationMetadata_Internalname, httpContext.getMessage( "Metadata", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationMetadata_Internalname, A182WWPNotificationMetadata, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", (short)(0), 1, edtWWPNotificationMetadata_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_Notification.htm");
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
         Z37WWPNotificationId = localUtil.ctol( httpContext.cgiGet( "Z37WWPNotificationId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z40WWPNotificationCreated = localUtil.ctot( httpContext.cgiGet( "Z40WWPNotificationCreated"), 0) ;
         Z198WWPNotificationIcon = httpContext.cgiGet( "Z198WWPNotificationIcon") ;
         Z199WWPNotificationTitle = httpContext.cgiGet( "Z199WWPNotificationTitle") ;
         Z200WWPNotificationShortDescriptio = httpContext.cgiGet( "Z200WWPNotificationShortDescriptio") ;
         Z201WWPNotificationLink = httpContext.cgiGet( "Z201WWPNotificationLink") ;
         Z203WWPNotificationIsRead = GXutil.strtobool( httpContext.cgiGet( "Z203WWPNotificationIsRead")) ;
         Z35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( "Z35WWPNotificationDefinitionId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z32WWPUserExtendedId = httpContext.cgiGet( "Z32WWPUserExtendedId") ;
         n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
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
         A181WWPNotificationDefinitionName = httpContext.cgiGet( edtWWPNotificationDefinitionName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPNotificationCreated_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPNOTIFICATIONCREATED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPNotificationCreated_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A40WWPNotificationCreated = localUtil.ctot( httpContext.cgiGet( edtWWPNotificationCreated_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         A198WWPNotificationIcon = httpContext.cgiGet( edtWWPNotificationIcon_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A198WWPNotificationIcon", A198WWPNotificationIcon);
         A199WWPNotificationTitle = httpContext.cgiGet( edtWWPNotificationTitle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
         A200WWPNotificationShortDescriptio = httpContext.cgiGet( edtWWPNotificationShortDescriptio_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
         A201WWPNotificationLink = httpContext.cgiGet( edtWWPNotificationLink_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A201WWPNotificationLink", A201WWPNotificationLink);
         A203WWPNotificationIsRead = GXutil.strtobool( httpContext.cgiGet( chkWWPNotificationIsRead.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
         A32WWPUserExtendedId = httpContext.cgiGet( edtWWPUserExtendedId_Internalname) ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
         A138WWPUserExtendedFullName = httpContext.cgiGet( edtWWPUserExtendedFullName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A182WWPNotificationMetadata = httpContext.cgiGet( edtWWPNotificationMetadata_Internalname) ;
         n182WWPNotificationMetadata = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
         n182WWPNotificationMetadata = ((GXutil.strcmp("", A182WWPNotificationMetadata)==0) ? true : false) ;
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
            A37WWPNotificationId = GXutil.lval( httpContext.GetPar( "WWPNotificationId")) ;
            n37WWPNotificationId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
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
            initAll0Z37( ) ;
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
      disableAttributes0Z37( ) ;
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

   public void resetCaption0Z0( )
   {
   }

   public void zm0Z37( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z40WWPNotificationCreated = T000Z3_A40WWPNotificationCreated[0] ;
            Z198WWPNotificationIcon = T000Z3_A198WWPNotificationIcon[0] ;
            Z199WWPNotificationTitle = T000Z3_A199WWPNotificationTitle[0] ;
            Z200WWPNotificationShortDescriptio = T000Z3_A200WWPNotificationShortDescriptio[0] ;
            Z201WWPNotificationLink = T000Z3_A201WWPNotificationLink[0] ;
            Z203WWPNotificationIsRead = T000Z3_A203WWPNotificationIsRead[0] ;
            Z35WWPNotificationDefinitionId = T000Z3_A35WWPNotificationDefinitionId[0] ;
            Z32WWPUserExtendedId = T000Z3_A32WWPUserExtendedId[0] ;
         }
         else
         {
            Z40WWPNotificationCreated = A40WWPNotificationCreated ;
            Z198WWPNotificationIcon = A198WWPNotificationIcon ;
            Z199WWPNotificationTitle = A199WWPNotificationTitle ;
            Z200WWPNotificationShortDescriptio = A200WWPNotificationShortDescriptio ;
            Z201WWPNotificationLink = A201WWPNotificationLink ;
            Z203WWPNotificationIsRead = A203WWPNotificationIsRead ;
            Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
            Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z37WWPNotificationId = A37WWPNotificationId ;
         Z40WWPNotificationCreated = A40WWPNotificationCreated ;
         Z198WWPNotificationIcon = A198WWPNotificationIcon ;
         Z199WWPNotificationTitle = A199WWPNotificationTitle ;
         Z200WWPNotificationShortDescriptio = A200WWPNotificationShortDescriptio ;
         Z201WWPNotificationLink = A201WWPNotificationLink ;
         Z203WWPNotificationIsRead = A203WWPNotificationIsRead ;
         Z182WWPNotificationMetadata = A182WWPNotificationMetadata ;
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A40WWPNotificationCreated) && ( Gx_BScreen == 0 ) )
      {
         A40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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

   public void load0Z37( )
   {
      /* Using cursor T000Z6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A181WWPNotificationDefinitionName = T000Z6_A181WWPNotificationDefinitionName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         A40WWPNotificationCreated = T000Z6_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A198WWPNotificationIcon = T000Z6_A198WWPNotificationIcon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A198WWPNotificationIcon", A198WWPNotificationIcon);
         A199WWPNotificationTitle = T000Z6_A199WWPNotificationTitle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
         A200WWPNotificationShortDescriptio = T000Z6_A200WWPNotificationShortDescriptio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
         A201WWPNotificationLink = T000Z6_A201WWPNotificationLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A201WWPNotificationLink", A201WWPNotificationLink);
         A203WWPNotificationIsRead = T000Z6_A203WWPNotificationIsRead[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
         A138WWPUserExtendedFullName = T000Z6_A138WWPUserExtendedFullName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A182WWPNotificationMetadata = T000Z6_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = T000Z6_n182WWPNotificationMetadata[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
         A35WWPNotificationDefinitionId = T000Z6_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         A32WWPUserExtendedId = T000Z6_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000Z6_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         zm0Z37( -5) ;
      }
      pr_default.close(4);
      onLoadActions0Z37( ) ;
   }

   public void onLoadActions0Z37( )
   {
   }

   public void checkExtendedTable0Z37( )
   {
      nIsDirty_37 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      /* Using cursor T000Z4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A181WWPNotificationDefinitionName = T000Z4_A181WWPNotificationDefinitionName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      pr_default.close(2);
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A40WWPNotificationCreated) || (( A40WWPNotificationCreated.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A40WWPNotificationCreated, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Notification Created Date", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPNOTIFICATIONCREATED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationCreated_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A201WWPNotificationLink,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Notification Link", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPNOTIFICATIONLINK");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationLink_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000Z5 */
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
      A138WWPUserExtendedFullName = T000Z5_A138WWPUserExtendedFullName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      pr_default.close(3);
   }

   public void closeExtendedTableCursors0Z37( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_6( long A35WWPNotificationDefinitionId )
   {
      /* Using cursor T000Z7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A181WWPNotificationDefinitionName = T000Z7_A181WWPNotificationDefinitionName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A181WWPNotificationDefinitionName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_7( String A32WWPUserExtendedId )
   {
      /* Using cursor T000Z8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A138WWPUserExtendedFullName = T000Z8_A138WWPUserExtendedFullName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A138WWPUserExtendedFullName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0Z37( )
   {
      /* Using cursor T000Z9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound37 = (short)(1) ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Z3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Z37( 5) ;
         RcdFound37 = (short)(1) ;
         A37WWPNotificationId = T000Z3_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000Z3_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         A40WWPNotificationCreated = T000Z3_A40WWPNotificationCreated[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A198WWPNotificationIcon = T000Z3_A198WWPNotificationIcon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A198WWPNotificationIcon", A198WWPNotificationIcon);
         A199WWPNotificationTitle = T000Z3_A199WWPNotificationTitle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
         A200WWPNotificationShortDescriptio = T000Z3_A200WWPNotificationShortDescriptio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
         A201WWPNotificationLink = T000Z3_A201WWPNotificationLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A201WWPNotificationLink", A201WWPNotificationLink);
         A203WWPNotificationIsRead = T000Z3_A203WWPNotificationIsRead[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
         A182WWPNotificationMetadata = T000Z3_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = T000Z3_n182WWPNotificationMetadata[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
         A35WWPNotificationDefinitionId = T000Z3_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         A32WWPUserExtendedId = T000Z3_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000Z3_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         Z37WWPNotificationId = A37WWPNotificationId ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0Z37( ) ;
         if ( AnyError == 1 )
         {
            RcdFound37 = (short)(0) ;
            initializeNonKey0Z37( ) ;
         }
         Gx_mode = sMode37 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound37 = (short)(0) ;
         initializeNonKey0Z37( ) ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode37 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Z37( ) ;
      if ( RcdFound37 == 0 )
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
      RcdFound37 = (short)(0) ;
      /* Using cursor T000Z10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000Z10_A37WWPNotificationId[0] < A37WWPNotificationId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000Z10_A37WWPNotificationId[0] > A37WWPNotificationId ) ) )
         {
            A37WWPNotificationId = T000Z10_A37WWPNotificationId[0] ;
            n37WWPNotificationId = T000Z10_n37WWPNotificationId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
            RcdFound37 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound37 = (short)(0) ;
      /* Using cursor T000Z11 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000Z11_A37WWPNotificationId[0] > A37WWPNotificationId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000Z11_A37WWPNotificationId[0] < A37WWPNotificationId ) ) )
         {
            A37WWPNotificationId = T000Z11_A37WWPNotificationId[0] ;
            n37WWPNotificationId = T000Z11_n37WWPNotificationId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
            RcdFound37 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Z37( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Z37( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound37 == 1 )
         {
            if ( A37WWPNotificationId != Z37WWPNotificationId )
            {
               A37WWPNotificationId = Z37WWPNotificationId ;
               n37WWPNotificationId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPNOTIFICATIONID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0Z37( ) ;
               GX_FocusControl = edtWWPNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A37WWPNotificationId != Z37WWPNotificationId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPNotificationId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Z37( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPNOTIFICATIONID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPNotificationId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPNotificationId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Z37( ) ;
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
      if ( A37WWPNotificationId != Z37WWPNotificationId )
      {
         A37WWPNotificationId = Z37WWPNotificationId ;
         n37WWPNotificationId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPNOTIFICATIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPNotificationId_Internalname ;
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
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPNOTIFICATIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationId_Internalname ;
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
      scanStart0Z37( ) ;
      if ( RcdFound37 == 0 )
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
      scanEnd0Z37( ) ;
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
      if ( RcdFound37 == 0 )
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
      if ( RcdFound37 == 0 )
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
      scanStart0Z37( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound37 != 0 )
         {
            scanNext0Z37( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0Z37( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0Z37( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Z2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Notification"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(Z40WWPNotificationCreated, T000Z2_A40WWPNotificationCreated[0]) ) || ( GXutil.strcmp(Z198WWPNotificationIcon, T000Z2_A198WWPNotificationIcon[0]) != 0 ) || ( GXutil.strcmp(Z199WWPNotificationTitle, T000Z2_A199WWPNotificationTitle[0]) != 0 ) || ( GXutil.strcmp(Z200WWPNotificationShortDescriptio, T000Z2_A200WWPNotificationShortDescriptio[0]) != 0 ) || ( GXutil.strcmp(Z201WWPNotificationLink, T000Z2_A201WWPNotificationLink[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z203WWPNotificationIsRead != T000Z2_A203WWPNotificationIsRead[0] ) || ( Z35WWPNotificationDefinitionId != T000Z2_A35WWPNotificationDefinitionId[0] ) || ( GXutil.strcmp(Z32WWPUserExtendedId, T000Z2_A32WWPUserExtendedId[0]) != 0 ) )
         {
            if ( !( GXutil.dateCompare(Z40WWPNotificationCreated, T000Z2_A40WWPNotificationCreated[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationCreated");
               GXutil.writeLogRaw("Old: ",Z40WWPNotificationCreated);
               GXutil.writeLogRaw("Current: ",T000Z2_A40WWPNotificationCreated[0]);
            }
            if ( GXutil.strcmp(Z198WWPNotificationIcon, T000Z2_A198WWPNotificationIcon[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationIcon");
               GXutil.writeLogRaw("Old: ",Z198WWPNotificationIcon);
               GXutil.writeLogRaw("Current: ",T000Z2_A198WWPNotificationIcon[0]);
            }
            if ( GXutil.strcmp(Z199WWPNotificationTitle, T000Z2_A199WWPNotificationTitle[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationTitle");
               GXutil.writeLogRaw("Old: ",Z199WWPNotificationTitle);
               GXutil.writeLogRaw("Current: ",T000Z2_A199WWPNotificationTitle[0]);
            }
            if ( GXutil.strcmp(Z200WWPNotificationShortDescriptio, T000Z2_A200WWPNotificationShortDescriptio[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationShortDescriptio");
               GXutil.writeLogRaw("Old: ",Z200WWPNotificationShortDescriptio);
               GXutil.writeLogRaw("Current: ",T000Z2_A200WWPNotificationShortDescriptio[0]);
            }
            if ( GXutil.strcmp(Z201WWPNotificationLink, T000Z2_A201WWPNotificationLink[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationLink");
               GXutil.writeLogRaw("Old: ",Z201WWPNotificationLink);
               GXutil.writeLogRaw("Current: ",T000Z2_A201WWPNotificationLink[0]);
            }
            if ( Z203WWPNotificationIsRead != T000Z2_A203WWPNotificationIsRead[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationIsRead");
               GXutil.writeLogRaw("Old: ",Z203WWPNotificationIsRead);
               GXutil.writeLogRaw("Current: ",T000Z2_A203WWPNotificationIsRead[0]);
            }
            if ( Z35WWPNotificationDefinitionId != T000Z2_A35WWPNotificationDefinitionId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPNotificationDefinitionId");
               GXutil.writeLogRaw("Old: ",Z35WWPNotificationDefinitionId);
               GXutil.writeLogRaw("Current: ",T000Z2_A35WWPNotificationDefinitionId[0]);
            }
            if ( GXutil.strcmp(Z32WWPUserExtendedId, T000Z2_A32WWPUserExtendedId[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notification:[seudo value changed for attri]"+"WWPUserExtendedId");
               GXutil.writeLogRaw("Old: ",Z32WWPUserExtendedId);
               GXutil.writeLogRaw("Current: ",T000Z2_A32WWPUserExtendedId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_Notification"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Z37( )
   {
      if ( ! IsAuthorized("wwp_notification_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Z37( 0) ;
         checkOptimisticConcurrency0Z37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Z37( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Z37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Z12 */
                  pr_default.execute(10, new Object[] {A40WWPNotificationCreated, A198WWPNotificationIcon, A199WWPNotificationTitle, A200WWPNotificationShortDescriptio, A201WWPNotificationLink, Boolean.valueOf(A203WWPNotificationIsRead), Boolean.valueOf(n182WWPNotificationMetadata), A182WWPNotificationMetadata, Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  A37WWPNotificationId = T000Z12_A37WWPNotificationId[0] ;
                  n37WWPNotificationId = T000Z12_n37WWPNotificationId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0Z0( ) ;
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
            load0Z37( ) ;
         }
         endLevel0Z37( ) ;
      }
      closeExtendedTableCursors0Z37( ) ;
   }

   public void update0Z37( )
   {
      if ( ! IsAuthorized("wwp_notification_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Z37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Z37( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Z37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Z13 */
                  pr_default.execute(11, new Object[] {A40WWPNotificationCreated, A198WWPNotificationIcon, A199WWPNotificationTitle, A200WWPNotificationShortDescriptio, A201WWPNotificationLink, Boolean.valueOf(A203WWPNotificationIsRead), Boolean.valueOf(n182WWPNotificationMetadata), A182WWPNotificationMetadata, Long.valueOf(A35WWPNotificationDefinitionId), Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_Notification"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Z37( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0Z0( ) ;
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
         endLevel0Z37( ) ;
      }
      closeExtendedTableCursors0Z37( ) ;
   }

   public void deferredUpdate0Z37( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("wwp_notification_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0Z37( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Z37( ) ;
         afterConfirm0Z37( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Z37( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Z14 */
               pr_default.execute(12, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_Notification");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound37 == 0 )
                     {
                        initAll0Z37( ) ;
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
                     resetCaption0Z0( ) ;
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
      sMode37 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Z37( ) ;
      Gx_mode = sMode37 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Z37( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000Z15 */
         pr_default.execute(13, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         A181WWPNotificationDefinitionName = T000Z15_A181WWPNotificationDefinitionName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         pr_default.close(13);
         /* Using cursor T000Z16 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         A138WWPUserExtendedFullName = T000Z16_A138WWPUserExtendedFullName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         pr_default.close(14);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000Z17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Mail", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T000Z18 */
         pr_default.execute(16, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_WebNotification", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T000Z19 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n37WWPNotificationId), Long.valueOf(A37WWPNotificationId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_SMS", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void endLevel0Z37( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Z37( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_notification");
         if ( AnyError == 0 )
         {
            confirmValues0Z0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_notification");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Z37( )
   {
      /* Using cursor T000Z20 */
      pr_default.execute(18);
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A37WWPNotificationId = T000Z20_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000Z20_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Z37( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A37WWPNotificationId = T000Z20_A37WWPNotificationId[0] ;
         n37WWPNotificationId = T000Z20_n37WWPNotificationId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
      }
   }

   public void scanEnd0Z37( )
   {
      pr_default.close(18);
   }

   public void afterConfirm0Z37( )
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

   public void beforeInsert0Z37( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Z37( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Z37( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Z37( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Z37( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Z37( )
   {
      edtWWPNotificationId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionId_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionName_Enabled), 5, 0), true);
      edtWWPNotificationCreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationCreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationCreated_Enabled), 5, 0), true);
      edtWWPNotificationIcon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationIcon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationIcon_Enabled), 5, 0), true);
      edtWWPNotificationTitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationTitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationTitle_Enabled), 5, 0), true);
      edtWWPNotificationShortDescriptio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationShortDescriptio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationShortDescriptio_Enabled), 5, 0), true);
      edtWWPNotificationLink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationLink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationLink_Enabled), 5, 0), true);
      chkWWPNotificationIsRead.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPNotificationIsRead.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPNotificationIsRead.getEnabled(), 5, 0), true);
      edtWWPUserExtendedId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedId_Enabled), 5, 0), true);
      edtWWPUserExtendedFullName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedFullName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedFullName_Enabled), 5, 0), true);
      edtWWPNotificationMetadata_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationMetadata_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationMetadata_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Z37( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Z0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40WWPNotificationCreated", localUtil.ttoc( Z40WWPNotificationCreated, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z198WWPNotificationIcon", Z198WWPNotificationIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z199WWPNotificationTitle", Z199WWPNotificationTitle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z200WWPNotificationShortDescriptio", Z200WWPNotificationShortDescriptio);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z201WWPNotificationLink", Z201WWPNotificationLink);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z203WWPNotificationIsRead", Z203WWPNotificationIsRead);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
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
      return formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Common.WWP_Notification" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Notification", "") ;
   }

   public void initializeNonKey0Z37( )
   {
      A35WWPNotificationDefinitionId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
      A181WWPNotificationDefinitionName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      A198WWPNotificationIcon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A198WWPNotificationIcon", A198WWPNotificationIcon);
      A199WWPNotificationTitle = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
      A200WWPNotificationShortDescriptio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
      A201WWPNotificationLink = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A201WWPNotificationLink", A201WWPNotificationLink);
      A203WWPNotificationIsRead = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
      A138WWPUserExtendedFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      A182WWPNotificationMetadata = "" ;
      n182WWPNotificationMetadata = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      n182WWPNotificationMetadata = ((GXutil.strcmp("", A182WWPNotificationMetadata)==0) ? true : false) ;
      A40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z198WWPNotificationIcon = "" ;
      Z199WWPNotificationTitle = "" ;
      Z200WWPNotificationShortDescriptio = "" ;
      Z201WWPNotificationLink = "" ;
      Z203WWPNotificationIsRead = false ;
      Z35WWPNotificationDefinitionId = 0 ;
      Z32WWPUserExtendedId = "" ;
   }

   public void initAll0Z37( )
   {
      A37WWPNotificationId = 0 ;
      n37WWPNotificationId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A37WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37WWPNotificationId), 10, 0));
      initializeNonKey0Z37( ) ;
   }

   public void standaloneModalInsert( )
   {
      A40WWPNotificationCreated = i40WWPNotificationCreated ;
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111103139", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/notifications/common/wwp_notification.js", "?202412111103139", false, true);
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
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID" ;
      edtWWPNotificationDefinitionId_Internalname = "WWPNOTIFICATIONDEFINITIONID" ;
      edtWWPNotificationDefinitionName_Internalname = "WWPNOTIFICATIONDEFINITIONNAME" ;
      edtWWPNotificationCreated_Internalname = "WWPNOTIFICATIONCREATED" ;
      edtWWPNotificationIcon_Internalname = "WWPNOTIFICATIONICON" ;
      edtWWPNotificationTitle_Internalname = "WWPNOTIFICATIONTITLE" ;
      edtWWPNotificationShortDescriptio_Internalname = "WWPNOTIFICATIONSHORTDESCRIPTIO" ;
      edtWWPNotificationLink_Internalname = "WWPNOTIFICATIONLINK" ;
      chkWWPNotificationIsRead.setInternalname( "WWPNOTIFICATIONISREAD" );
      edtWWPUserExtendedId_Internalname = "WWPUSEREXTENDEDID" ;
      edtWWPUserExtendedFullName_Internalname = "WWPUSEREXTENDEDFULLNAME" ;
      edtWWPNotificationMetadata_Internalname = "WWPNOTIFICATIONMETADATA" ;
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
      Form.setCaption( httpContext.getMessage( "Notification", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtWWPNotificationMetadata_Enabled = 1 ;
      edtWWPUserExtendedFullName_Jsonclick = "" ;
      edtWWPUserExtendedFullName_Enabled = 0 ;
      edtWWPUserExtendedId_Jsonclick = "" ;
      edtWWPUserExtendedId_Enabled = 1 ;
      chkWWPNotificationIsRead.setEnabled( 1 );
      edtWWPNotificationLink_Jsonclick = "" ;
      edtWWPNotificationLink_Enabled = 1 ;
      edtWWPNotificationShortDescriptio_Enabled = 1 ;
      edtWWPNotificationTitle_Enabled = 1 ;
      edtWWPNotificationIcon_Jsonclick = "" ;
      edtWWPNotificationIcon_Enabled = 1 ;
      edtWWPNotificationCreated_Jsonclick = "" ;
      edtWWPNotificationCreated_Enabled = 1 ;
      edtWWPNotificationDefinitionName_Jsonclick = "" ;
      edtWWPNotificationDefinitionName_Enabled = 0 ;
      edtWWPNotificationDefinitionId_Jsonclick = "" ;
      edtWWPNotificationDefinitionId_Enabled = 1 ;
      edtWWPNotificationId_Jsonclick = "" ;
      edtWWPNotificationId_Enabled = 1 ;
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
      chkWWPNotificationIsRead.setName( "WWPNOTIFICATIONISREAD" );
      chkWWPNotificationIsRead.setWebtags( "" );
      chkWWPNotificationIsRead.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPNotificationIsRead.getInternalname(), "TitleCaption", chkWWPNotificationIsRead.getCaption(), true);
      chkWWPNotificationIsRead.setCheckedValue( "false" );
      A203WWPNotificationIsRead = GXutil.strtobool( GXutil.booltostr( A203WWPNotificationIsRead)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
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

   public void valid_Wwpnotificationid( )
   {
      n37WWPNotificationId = false ;
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      A203WWPNotificationIsRead = GXutil.strtobool( GXutil.booltostr( A203WWPNotificationIsRead)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A198WWPNotificationIcon", A198WWPNotificationIcon);
      httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
      httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
      httpContext.ajax_rsp_assign_attri("", false, "A201WWPNotificationLink", A201WWPNotificationLink);
      httpContext.ajax_rsp_assign_attri("", false, "A203WWPNotificationIsRead", A203WWPNotificationIsRead);
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", GXutil.rtrim( A32WWPUserExtendedId));
      httpContext.ajax_rsp_assign_attri("", false, "A182WWPNotificationMetadata", A182WWPNotificationMetadata);
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z37WWPNotificationId", GXutil.ltrim( localUtil.ntoc( Z37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40WWPNotificationCreated", localUtil.ttoc( Z40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z198WWPNotificationIcon", Z198WWPNotificationIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z199WWPNotificationTitle", Z199WWPNotificationTitle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z200WWPNotificationShortDescriptio", Z200WWPNotificationShortDescriptio);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z201WWPNotificationLink", Z201WWPNotificationLink);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z203WWPNotificationIsRead", GXutil.booltostr( Z203WWPNotificationIsRead));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z182WWPNotificationMetadata", Z182WWPNotificationMetadata);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z181WWPNotificationDefinitionName", Z181WWPNotificationDefinitionName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z138WWPUserExtendedFullName", Z138WWPUserExtendedFullName);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpnotificationdefinitionid( )
   {
      /* Using cursor T000Z15 */
      pr_default.execute(13, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_NotificationDefinition", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
      }
      A181WWPNotificationDefinitionName = T000Z15_A181WWPNotificationDefinitionName[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
   }

   public void valid_Wwpuserextendedid( )
   {
      n32WWPUserExtendedId = false ;
      /* Using cursor T000Z16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         }
      }
      A138WWPUserExtendedFullName = T000Z16_A138WWPUserExtendedFullName[0] ;
      pr_default.close(14);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONID","{handler:'valid_Wwpnotificationid',iparms:[{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONID",",oparms:[{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A198WWPNotificationIcon',fld:'WWPNOTIFICATIONICON',pic:''},{av:'A199WWPNotificationTitle',fld:'WWPNOTIFICATIONTITLE',pic:''},{av:'A200WWPNotificationShortDescriptio',fld:'WWPNOTIFICATIONSHORTDESCRIPTIO',pic:''},{av:'A201WWPNotificationLink',fld:'WWPNOTIFICATIONLINK',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A182WWPNotificationMetadata',fld:'WWPNOTIFICATIONMETADATA',pic:''},{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z37WWPNotificationId'},{av:'Z35WWPNotificationDefinitionId'},{av:'Z40WWPNotificationCreated'},{av:'Z198WWPNotificationIcon'},{av:'Z199WWPNotificationTitle'},{av:'Z200WWPNotificationShortDescriptio'},{av:'Z201WWPNotificationLink'},{av:'Z203WWPNotificationIsRead'},{av:'Z32WWPUserExtendedId'},{av:'Z182WWPNotificationMetadata'},{av:'Z181WWPNotificationDefinitionName'},{av:'Z138WWPUserExtendedFullName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONID","{handler:'valid_Wwpnotificationdefinitionid',iparms:[{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONID",",oparms:[{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONCREATED","{handler:'valid_Wwpnotificationcreated',iparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONCREATED",",oparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONLINK","{handler:'valid_Wwpnotificationlink',iparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONLINK",",oparms:[{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
      setEventMetadata("VALID_WWPUSEREXTENDEDID","{handler:'valid_Wwpuserextendedid',iparms:[{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("VALID_WWPUSEREXTENDEDID",",oparms:[{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]}");
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
      return "wwp_notification_Execute";
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
      Z40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      Z198WWPNotificationIcon = "" ;
      Z199WWPNotificationTitle = "" ;
      Z200WWPNotificationShortDescriptio = "" ;
      Z201WWPNotificationLink = "" ;
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
      A181WWPNotificationDefinitionName = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A198WWPNotificationIcon = "" ;
      A199WWPNotificationTitle = "" ;
      A200WWPNotificationShortDescriptio = "" ;
      A201WWPNotificationLink = "" ;
      A138WWPUserExtendedFullName = "" ;
      A182WWPNotificationMetadata = "" ;
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
      Z182WWPNotificationMetadata = "" ;
      Z181WWPNotificationDefinitionName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      T000Z6_A37WWPNotificationId = new long[1] ;
      T000Z6_n37WWPNotificationId = new boolean[] {false} ;
      T000Z6_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Z6_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000Z6_A198WWPNotificationIcon = new String[] {""} ;
      T000Z6_A199WWPNotificationTitle = new String[] {""} ;
      T000Z6_A200WWPNotificationShortDescriptio = new String[] {""} ;
      T000Z6_A201WWPNotificationLink = new String[] {""} ;
      T000Z6_A203WWPNotificationIsRead = new boolean[] {false} ;
      T000Z6_A138WWPUserExtendedFullName = new String[] {""} ;
      T000Z6_A182WWPNotificationMetadata = new String[] {""} ;
      T000Z6_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000Z6_A35WWPNotificationDefinitionId = new long[1] ;
      T000Z6_A32WWPUserExtendedId = new String[] {""} ;
      T000Z6_n32WWPUserExtendedId = new boolean[] {false} ;
      T000Z4_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Z5_A138WWPUserExtendedFullName = new String[] {""} ;
      T000Z7_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Z8_A138WWPUserExtendedFullName = new String[] {""} ;
      T000Z9_A37WWPNotificationId = new long[1] ;
      T000Z9_n37WWPNotificationId = new boolean[] {false} ;
      T000Z3_A37WWPNotificationId = new long[1] ;
      T000Z3_n37WWPNotificationId = new boolean[] {false} ;
      T000Z3_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000Z3_A198WWPNotificationIcon = new String[] {""} ;
      T000Z3_A199WWPNotificationTitle = new String[] {""} ;
      T000Z3_A200WWPNotificationShortDescriptio = new String[] {""} ;
      T000Z3_A201WWPNotificationLink = new String[] {""} ;
      T000Z3_A203WWPNotificationIsRead = new boolean[] {false} ;
      T000Z3_A182WWPNotificationMetadata = new String[] {""} ;
      T000Z3_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000Z3_A35WWPNotificationDefinitionId = new long[1] ;
      T000Z3_A32WWPUserExtendedId = new String[] {""} ;
      T000Z3_n32WWPUserExtendedId = new boolean[] {false} ;
      sMode37 = "" ;
      T000Z10_A37WWPNotificationId = new long[1] ;
      T000Z10_n37WWPNotificationId = new boolean[] {false} ;
      T000Z11_A37WWPNotificationId = new long[1] ;
      T000Z11_n37WWPNotificationId = new boolean[] {false} ;
      T000Z2_A37WWPNotificationId = new long[1] ;
      T000Z2_n37WWPNotificationId = new boolean[] {false} ;
      T000Z2_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      T000Z2_A198WWPNotificationIcon = new String[] {""} ;
      T000Z2_A199WWPNotificationTitle = new String[] {""} ;
      T000Z2_A200WWPNotificationShortDescriptio = new String[] {""} ;
      T000Z2_A201WWPNotificationLink = new String[] {""} ;
      T000Z2_A203WWPNotificationIsRead = new boolean[] {false} ;
      T000Z2_A182WWPNotificationMetadata = new String[] {""} ;
      T000Z2_n182WWPNotificationMetadata = new boolean[] {false} ;
      T000Z2_A35WWPNotificationDefinitionId = new long[1] ;
      T000Z2_A32WWPUserExtendedId = new String[] {""} ;
      T000Z2_n32WWPUserExtendedId = new boolean[] {false} ;
      T000Z12_A37WWPNotificationId = new long[1] ;
      T000Z12_n37WWPNotificationId = new boolean[] {false} ;
      T000Z15_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Z16_A138WWPUserExtendedFullName = new String[] {""} ;
      T000Z17_A42WWPMailId = new long[1] ;
      T000Z18_A38WWPWebNotificationId = new long[1] ;
      T000Z19_A36WWPSMSId = new long[1] ;
      T000Z20_A37WWPNotificationId = new long[1] ;
      T000Z20_n37WWPNotificationId = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      ZZ40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      ZZ198WWPNotificationIcon = "" ;
      ZZ199WWPNotificationTitle = "" ;
      ZZ200WWPNotificationShortDescriptio = "" ;
      ZZ201WWPNotificationLink = "" ;
      ZZ32WWPUserExtendedId = "" ;
      ZZ182WWPNotificationMetadata = "" ;
      ZZ181WWPNotificationDefinitionName = "" ;
      ZZ138WWPUserExtendedFullName = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notification__default(),
         new Object[] {
             new Object[] {
            T000Z2_A37WWPNotificationId, T000Z2_A40WWPNotificationCreated, T000Z2_A198WWPNotificationIcon, T000Z2_A199WWPNotificationTitle, T000Z2_A200WWPNotificationShortDescriptio, T000Z2_A201WWPNotificationLink, T000Z2_A203WWPNotificationIsRead, T000Z2_A182WWPNotificationMetadata, T000Z2_n182WWPNotificationMetadata, T000Z2_A35WWPNotificationDefinitionId,
            T000Z2_A32WWPUserExtendedId, T000Z2_n32WWPUserExtendedId
            }
            , new Object[] {
            T000Z3_A37WWPNotificationId, T000Z3_A40WWPNotificationCreated, T000Z3_A198WWPNotificationIcon, T000Z3_A199WWPNotificationTitle, T000Z3_A200WWPNotificationShortDescriptio, T000Z3_A201WWPNotificationLink, T000Z3_A203WWPNotificationIsRead, T000Z3_A182WWPNotificationMetadata, T000Z3_n182WWPNotificationMetadata, T000Z3_A35WWPNotificationDefinitionId,
            T000Z3_A32WWPUserExtendedId, T000Z3_n32WWPUserExtendedId
            }
            , new Object[] {
            T000Z4_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            T000Z5_A138WWPUserExtendedFullName
            }
            , new Object[] {
            T000Z6_A37WWPNotificationId, T000Z6_A181WWPNotificationDefinitionName, T000Z6_A40WWPNotificationCreated, T000Z6_A198WWPNotificationIcon, T000Z6_A199WWPNotificationTitle, T000Z6_A200WWPNotificationShortDescriptio, T000Z6_A201WWPNotificationLink, T000Z6_A203WWPNotificationIsRead, T000Z6_A138WWPUserExtendedFullName, T000Z6_A182WWPNotificationMetadata,
            T000Z6_n182WWPNotificationMetadata, T000Z6_A35WWPNotificationDefinitionId, T000Z6_A32WWPUserExtendedId, T000Z6_n32WWPUserExtendedId
            }
            , new Object[] {
            T000Z7_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            T000Z8_A138WWPUserExtendedFullName
            }
            , new Object[] {
            T000Z9_A37WWPNotificationId
            }
            , new Object[] {
            T000Z10_A37WWPNotificationId
            }
            , new Object[] {
            T000Z11_A37WWPNotificationId
            }
            , new Object[] {
            T000Z12_A37WWPNotificationId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Z15_A181WWPNotificationDefinitionName
            }
            , new Object[] {
            T000Z16_A138WWPUserExtendedFullName
            }
            , new Object[] {
            T000Z17_A42WWPMailId
            }
            , new Object[] {
            T000Z18_A38WWPWebNotificationId
            }
            , new Object[] {
            T000Z19_A36WWPSMSId
            }
            , new Object[] {
            T000Z20_A37WWPNotificationId
            }
         }
      );
      Z40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i40WWPNotificationCreated = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound37 ;
   private short nIsDirty_37 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPNotificationId_Enabled ;
   private int edtWWPNotificationDefinitionId_Enabled ;
   private int edtWWPNotificationDefinitionName_Enabled ;
   private int edtWWPNotificationCreated_Enabled ;
   private int edtWWPNotificationIcon_Enabled ;
   private int edtWWPNotificationTitle_Enabled ;
   private int edtWWPNotificationShortDescriptio_Enabled ;
   private int edtWWPNotificationLink_Enabled ;
   private int edtWWPUserExtendedId_Enabled ;
   private int edtWWPUserExtendedFullName_Enabled ;
   private int edtWWPNotificationMetadata_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private long Z37WWPNotificationId ;
   private long Z35WWPNotificationDefinitionId ;
   private long A35WWPNotificationDefinitionId ;
   private long A37WWPNotificationId ;
   private long ZZ37WWPNotificationId ;
   private long ZZ35WWPNotificationDefinitionId ;
   private String sPrefix ;
   private String Z32WWPUserExtendedId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A32WWPUserExtendedId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPNotificationId_Internalname ;
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
   private String edtWWPNotificationId_Jsonclick ;
   private String edtWWPNotificationDefinitionId_Internalname ;
   private String edtWWPNotificationDefinitionId_Jsonclick ;
   private String edtWWPNotificationDefinitionName_Internalname ;
   private String edtWWPNotificationDefinitionName_Jsonclick ;
   private String edtWWPNotificationCreated_Internalname ;
   private String edtWWPNotificationCreated_Jsonclick ;
   private String edtWWPNotificationIcon_Internalname ;
   private String edtWWPNotificationIcon_Jsonclick ;
   private String edtWWPNotificationTitle_Internalname ;
   private String edtWWPNotificationShortDescriptio_Internalname ;
   private String edtWWPNotificationLink_Internalname ;
   private String edtWWPNotificationLink_Jsonclick ;
   private String edtWWPUserExtendedId_Internalname ;
   private String edtWWPUserExtendedId_Jsonclick ;
   private String edtWWPUserExtendedFullName_Internalname ;
   private String edtWWPUserExtendedFullName_Jsonclick ;
   private String edtWWPNotificationMetadata_Internalname ;
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
   private String sMode37 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ32WWPUserExtendedId ;
   private java.util.Date Z40WWPNotificationCreated ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date i40WWPNotificationCreated ;
   private java.util.Date ZZ40WWPNotificationCreated ;
   private boolean Z203WWPNotificationIsRead ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n32WWPUserExtendedId ;
   private boolean wbErr ;
   private boolean A203WWPNotificationIsRead ;
   private boolean n37WWPNotificationId ;
   private boolean n182WWPNotificationMetadata ;
   private boolean Gx_longc ;
   private boolean ZZ203WWPNotificationIsRead ;
   private String A182WWPNotificationMetadata ;
   private String Z182WWPNotificationMetadata ;
   private String ZZ182WWPNotificationMetadata ;
   private String Z198WWPNotificationIcon ;
   private String Z199WWPNotificationTitle ;
   private String Z200WWPNotificationShortDescriptio ;
   private String Z201WWPNotificationLink ;
   private String A181WWPNotificationDefinitionName ;
   private String A198WWPNotificationIcon ;
   private String A199WWPNotificationTitle ;
   private String A200WWPNotificationShortDescriptio ;
   private String A201WWPNotificationLink ;
   private String A138WWPUserExtendedFullName ;
   private String Z181WWPNotificationDefinitionName ;
   private String Z138WWPUserExtendedFullName ;
   private String ZZ198WWPNotificationIcon ;
   private String ZZ199WWPNotificationTitle ;
   private String ZZ200WWPNotificationShortDescriptio ;
   private String ZZ201WWPNotificationLink ;
   private String ZZ181WWPNotificationDefinitionName ;
   private String ZZ138WWPUserExtendedFullName ;
   private ICheckbox chkWWPNotificationIsRead ;
   private IDataStoreProvider pr_default ;
   private long[] T000Z6_A37WWPNotificationId ;
   private boolean[] T000Z6_n37WWPNotificationId ;
   private String[] T000Z6_A181WWPNotificationDefinitionName ;
   private java.util.Date[] T000Z6_A40WWPNotificationCreated ;
   private String[] T000Z6_A198WWPNotificationIcon ;
   private String[] T000Z6_A199WWPNotificationTitle ;
   private String[] T000Z6_A200WWPNotificationShortDescriptio ;
   private String[] T000Z6_A201WWPNotificationLink ;
   private boolean[] T000Z6_A203WWPNotificationIsRead ;
   private String[] T000Z6_A138WWPUserExtendedFullName ;
   private String[] T000Z6_A182WWPNotificationMetadata ;
   private boolean[] T000Z6_n182WWPNotificationMetadata ;
   private long[] T000Z6_A35WWPNotificationDefinitionId ;
   private String[] T000Z6_A32WWPUserExtendedId ;
   private boolean[] T000Z6_n32WWPUserExtendedId ;
   private String[] T000Z4_A181WWPNotificationDefinitionName ;
   private String[] T000Z5_A138WWPUserExtendedFullName ;
   private String[] T000Z7_A181WWPNotificationDefinitionName ;
   private String[] T000Z8_A138WWPUserExtendedFullName ;
   private long[] T000Z9_A37WWPNotificationId ;
   private boolean[] T000Z9_n37WWPNotificationId ;
   private long[] T000Z3_A37WWPNotificationId ;
   private boolean[] T000Z3_n37WWPNotificationId ;
   private java.util.Date[] T000Z3_A40WWPNotificationCreated ;
   private String[] T000Z3_A198WWPNotificationIcon ;
   private String[] T000Z3_A199WWPNotificationTitle ;
   private String[] T000Z3_A200WWPNotificationShortDescriptio ;
   private String[] T000Z3_A201WWPNotificationLink ;
   private boolean[] T000Z3_A203WWPNotificationIsRead ;
   private String[] T000Z3_A182WWPNotificationMetadata ;
   private boolean[] T000Z3_n182WWPNotificationMetadata ;
   private long[] T000Z3_A35WWPNotificationDefinitionId ;
   private String[] T000Z3_A32WWPUserExtendedId ;
   private boolean[] T000Z3_n32WWPUserExtendedId ;
   private long[] T000Z10_A37WWPNotificationId ;
   private boolean[] T000Z10_n37WWPNotificationId ;
   private long[] T000Z11_A37WWPNotificationId ;
   private boolean[] T000Z11_n37WWPNotificationId ;
   private long[] T000Z2_A37WWPNotificationId ;
   private boolean[] T000Z2_n37WWPNotificationId ;
   private java.util.Date[] T000Z2_A40WWPNotificationCreated ;
   private String[] T000Z2_A198WWPNotificationIcon ;
   private String[] T000Z2_A199WWPNotificationTitle ;
   private String[] T000Z2_A200WWPNotificationShortDescriptio ;
   private String[] T000Z2_A201WWPNotificationLink ;
   private boolean[] T000Z2_A203WWPNotificationIsRead ;
   private String[] T000Z2_A182WWPNotificationMetadata ;
   private boolean[] T000Z2_n182WWPNotificationMetadata ;
   private long[] T000Z2_A35WWPNotificationDefinitionId ;
   private String[] T000Z2_A32WWPUserExtendedId ;
   private boolean[] T000Z2_n32WWPUserExtendedId ;
   private long[] T000Z12_A37WWPNotificationId ;
   private boolean[] T000Z12_n37WWPNotificationId ;
   private String[] T000Z15_A181WWPNotificationDefinitionName ;
   private String[] T000Z16_A138WWPUserExtendedFullName ;
   private long[] T000Z17_A42WWPMailId ;
   private long[] T000Z18_A38WWPWebNotificationId ;
   private long[] T000Z19_A36WWPSMSId ;
   private long[] T000Z20_A37WWPNotificationId ;
   private boolean[] T000Z20_n37WWPNotificationId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_notification__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_notification__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Z2", "SELECT [WWPNotificationId], [WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Notification] WITH (UPDLOCK) WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z3", "SELECT [WWPNotificationId], [WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z4", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z5", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z6", "SELECT TM1.[WWPNotificationId], T2.[WWPNotificationDefinitionName], TM1.[WWPNotificationCreated], TM1.[WWPNotificationIcon], TM1.[WWPNotificationTitle], TM1.[WWPNotificationShortDescriptio], TM1.[WWPNotificationLink], TM1.[WWPNotificationIsRead], T3.[WWPUserExtendedFullName], TM1.[WWPNotificationMetadata], TM1.[WWPNotificationDefinitionId], TM1.[WWPUserExtendedId] FROM (([WWP_Notification] TM1 INNER JOIN [WWP_NotificationDefinition] T2 ON T2.[WWPNotificationDefinitionId] = TM1.[WWPNotificationDefinitionId]) LEFT JOIN [WWP_UserExtended] T3 ON T3.[WWPUserExtendedId] = TM1.[WWPUserExtendedId]) WHERE TM1.[WWPNotificationId] = ? ORDER BY TM1.[WWPNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z7", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z8", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z9", "SELECT [WWPNotificationId] FROM [WWP_Notification] WHERE [WWPNotificationId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z10", "SELECT TOP 1 [WWPNotificationId] FROM [WWP_Notification] WHERE ( [WWPNotificationId] > ?) ORDER BY [WWPNotificationId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z11", "SELECT TOP 1 [WWPNotificationId] FROM [WWP_Notification] WHERE ( [WWPNotificationId] < ?) ORDER BY [WWPNotificationId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z12", "INSERT INTO [WWP_Notification]([WWPNotificationCreated], [WWPNotificationIcon], [WWPNotificationTitle], [WWPNotificationShortDescriptio], [WWPNotificationLink], [WWPNotificationIsRead], [WWPNotificationMetadata], [WWPNotificationDefinitionId], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000Z13", "UPDATE [WWP_Notification] SET [WWPNotificationCreated]=?, [WWPNotificationIcon]=?, [WWPNotificationTitle]=?, [WWPNotificationShortDescriptio]=?, [WWPNotificationLink]=?, [WWPNotificationIsRead]=?, [WWPNotificationMetadata]=?, [WWPNotificationDefinitionId]=?, [WWPUserExtendedId]=?  WHERE [WWPNotificationId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Z14", "DELETE FROM [WWP_Notification]  WHERE [WWPNotificationId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000Z15", "SELECT [WWPNotificationDefinitionName] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z16", "SELECT [WWPUserExtendedFullName] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z17", "SELECT TOP 1 [WWPMailId] FROM [WWP_Mail] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z18", "SELECT TOP 1 [WWPWebNotificationId] FROM [WWP_WebNotification] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z19", "SELECT TOP 1 [WWPSMSId] FROM [WWP_SMS] WHERE [WWPNotificationId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z20", "SELECT [WWPNotificationId] FROM [WWP_Notification] ORDER BY [WWPNotificationId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDateTime(2, true);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((long[]) buf[9])[0] = rslt.getLong(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3, true);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((long[]) buf[11])[0] = rslt.getLong(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 17 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 10 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false, true);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 1000, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(7, (String)parms[7]);
               }
               stmt.setLong(8, ((Number) parms[8]).longValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 40);
               }
               return;
            case 11 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false, true);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 200, false);
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 1000, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(7, (String)parms[7]);
               }
               stmt.setLong(8, ((Number) parms[8]).longValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 40);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(10, ((Number) parms[12]).longValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 17 :
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

