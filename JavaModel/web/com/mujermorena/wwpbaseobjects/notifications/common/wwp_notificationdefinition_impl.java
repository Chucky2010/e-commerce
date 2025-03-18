package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_notificationdefinition_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"WWPNOTIFICATIONDEFINITIONISAUT") == 0 )
      {
         A189WWPNotificationDefinitionSecFu = httpContext.GetPar( "WWPNotificationDefinitionSecFu") ;
         httpContext.ajax_rsp_assign_attri("", false, "A189WWPNotificationDefinitionSecFu", A189WWPNotificationDefinitionSecFu);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asawwpnotificationdefinitionisaut0Y36( A189WWPNotificationDefinitionSecFu) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Notification Definition", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_notificationdefinition_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_notificationdefinition_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_notificationdefinition_impl.class ));
   }

   public wwp_notificationdefinition_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbWWPNotificationDefinitionAppli = new HTMLChoice();
      chkWWPNotificationDefinitionAllow = UIFactory.getCheckbox(this);
      chkWWPNotificationDefinitionIsAut = UIFactory.getCheckbox(this);
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
      if ( cmbWWPNotificationDefinitionAppli.getItemCount() > 0 )
      {
         A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( cmbWWPNotificationDefinitionAppli.getValidValue(GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPNotificationDefinitionAppli.setValue( GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbWWPNotificationDefinitionAppli.getInternalname(), "Values", cmbWWPNotificationDefinitionAppli.ToJavascriptSource(), true);
      }
      A156WWPNotificationDefinitionAllow = GXutil.strtobool( GXutil.booltostr( A156WWPNotificationDefinitionAllow)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
      A190WWPNotificationDefinitionIsAut = GXutil.strtobool( GXutil.booltostr( A190WWPNotificationDefinitionIsAut)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Notification Definition", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionId_Internalname, GXutil.ltrim( localUtil.ntoc( A35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPNotificationDefinitionId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
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
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionName_Internalname, httpContext.getMessage( "Internal Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionName_Internalname, A181WWPNotificationDefinitionName, GXutil.rtrim( localUtil.format( A181WWPNotificationDefinitionName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbWWPNotificationDefinitionAppli.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbWWPNotificationDefinitionAppli.getInternalname(), httpContext.getMessage( "Applies To", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbWWPNotificationDefinitionAppli, cmbWWPNotificationDefinitionAppli.getInternalname(), GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0)), 1, cmbWWPNotificationDefinitionAppli.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbWWPNotificationDefinitionAppli.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      cmbWWPNotificationDefinitionAppli.setValue( GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPNotificationDefinitionAppli.getInternalname(), "Values", cmbWWPNotificationDefinitionAppli.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPNotificationDefinitionAllow.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPNotificationDefinitionAllow.getInternalname(), httpContext.getMessage( "Allow User Subscription", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPNotificationDefinitionAllow.getInternalname(), GXutil.booltostr( A156WWPNotificationDefinitionAllow), "", httpContext.getMessage( "Allow User Subscription", ""), 1, chkWWPNotificationDefinitionAllow.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(49, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,49);\"");
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
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionDescr_Internalname, httpContext.getMessage( "Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationDefinitionDescr_Internalname, A154WWPNotificationDefinitionDescr, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtWWPNotificationDefinitionDescr_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionIcon_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionIcon_Internalname, httpContext.getMessage( "Default Icon", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionIcon_Internalname, A184WWPNotificationDefinitionIcon, GXutil.rtrim( localUtil.format( A184WWPNotificationDefinitionIcon, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationDefinitionIcon_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionIcon_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionTitle_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionTitle_Internalname, httpContext.getMessage( "Default Title", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationDefinitionTitle_Internalname, A185WWPNotificationDefinitionTitle, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", (short)(0), 1, edtWWPNotificationDefinitionTitle_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionShort_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionShort_Internalname, httpContext.getMessage( "Default Short Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationDefinitionShort_Internalname, A186WWPNotificationDefinitionShort, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", (short)(0), 1, edtWWPNotificationDefinitionShort_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionLongD_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionLongD_Internalname, httpContext.getMessage( "Default Long Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationDefinitionLongD_Internalname, A187WWPNotificationDefinitionLongD, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", (short)(0), 1, edtWWPNotificationDefinitionLongD_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionLink_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionLink_Internalname, httpContext.getMessage( "Default Link", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationDefinitionLink_Internalname, A188WWPNotificationDefinitionLink, GXutil.rtrim( localUtil.format( A188WWPNotificationDefinitionLink, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "'"+""+"'"+",false,"+"'"+""+"'", A188WWPNotificationDefinitionLink, "_blank", "", "", edtWWPNotificationDefinitionLink_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPNotificationDefinitionLink_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPEntityId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPEntityId_Internalname, httpContext.getMessage( "Entity Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPEntityId_Internalname, GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtWWPEntityId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A33WWPEntityId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A33WWPEntityId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPEntityId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPEntityId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_Id", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
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
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPEntityName_Internalname, A150WWPEntityName, GXutil.rtrim( localUtil.format( A150WWPEntityName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPEntityName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPEntityName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPNotificationDefinitionSecFu_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationDefinitionSecFu_Internalname, httpContext.getMessage( "Funcionality Key", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationDefinitionSecFu_Internalname, A189WWPNotificationDefinitionSecFu, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", (short)(0), 1, edtWWPNotificationDefinitionSecFu_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPNotificationDefinitionIsAut.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPNotificationDefinitionIsAut.getInternalname(), httpContext.getMessage( "User Authorized", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPNotificationDefinitionIsAut.getInternalname(), GXutil.booltostr( A190WWPNotificationDefinitionIsAut), "", httpContext.getMessage( "User Authorized", ""), 1, chkWWPNotificationDefinitionIsAut.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_NotificationDefinition.htm");
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
         Z35WWPNotificationDefinitionId = localUtil.ctol( httpContext.cgiGet( "Z35WWPNotificationDefinitionId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z181WWPNotificationDefinitionName = httpContext.cgiGet( "Z181WWPNotificationDefinitionName") ;
         Z155WWPNotificationDefinitionAppli = (byte)(localUtil.ctol( httpContext.cgiGet( "Z155WWPNotificationDefinitionAppli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z156WWPNotificationDefinitionAllow = GXutil.strtobool( httpContext.cgiGet( "Z156WWPNotificationDefinitionAllow")) ;
         Z154WWPNotificationDefinitionDescr = httpContext.cgiGet( "Z154WWPNotificationDefinitionDescr") ;
         Z184WWPNotificationDefinitionIcon = httpContext.cgiGet( "Z184WWPNotificationDefinitionIcon") ;
         Z185WWPNotificationDefinitionTitle = httpContext.cgiGet( "Z185WWPNotificationDefinitionTitle") ;
         Z186WWPNotificationDefinitionShort = httpContext.cgiGet( "Z186WWPNotificationDefinitionShort") ;
         Z187WWPNotificationDefinitionLongD = httpContext.cgiGet( "Z187WWPNotificationDefinitionLongD") ;
         Z188WWPNotificationDefinitionLink = httpContext.cgiGet( "Z188WWPNotificationDefinitionLink") ;
         Z189WWPNotificationDefinitionSecFu = httpContext.cgiGet( "Z189WWPNotificationDefinitionSecFu") ;
         Z33WWPEntityId = localUtil.ctol( httpContext.cgiGet( "Z33WWPEntityId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
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
         cmbWWPNotificationDefinitionAppli.setValue( httpContext.cgiGet( cmbWWPNotificationDefinitionAppli.getInternalname()) );
         A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( httpContext.cgiGet( cmbWWPNotificationDefinitionAppli.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0));
         A156WWPNotificationDefinitionAllow = GXutil.strtobool( httpContext.cgiGet( chkWWPNotificationDefinitionAllow.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
         A154WWPNotificationDefinitionDescr = httpContext.cgiGet( edtWWPNotificationDefinitionDescr_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
         A184WWPNotificationDefinitionIcon = httpContext.cgiGet( edtWWPNotificationDefinitionIcon_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A184WWPNotificationDefinitionIcon", A184WWPNotificationDefinitionIcon);
         A185WWPNotificationDefinitionTitle = httpContext.cgiGet( edtWWPNotificationDefinitionTitle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A185WWPNotificationDefinitionTitle", A185WWPNotificationDefinitionTitle);
         A186WWPNotificationDefinitionShort = httpContext.cgiGet( edtWWPNotificationDefinitionShort_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A186WWPNotificationDefinitionShort", A186WWPNotificationDefinitionShort);
         A187WWPNotificationDefinitionLongD = httpContext.cgiGet( edtWWPNotificationDefinitionLongD_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A187WWPNotificationDefinitionLongD", A187WWPNotificationDefinitionLongD);
         A188WWPNotificationDefinitionLink = httpContext.cgiGet( edtWWPNotificationDefinitionLink_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A188WWPNotificationDefinitionLink", A188WWPNotificationDefinitionLink);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtWWPEntityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtWWPEntityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "WWPENTITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPEntityId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A33WWPEntityId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
         }
         else
         {
            A33WWPEntityId = localUtil.ctol( httpContext.cgiGet( edtWWPEntityId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
         }
         A150WWPEntityName = httpContext.cgiGet( edtWWPEntityName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
         A189WWPNotificationDefinitionSecFu = httpContext.cgiGet( edtWWPNotificationDefinitionSecFu_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A189WWPNotificationDefinitionSecFu", A189WWPNotificationDefinitionSecFu);
         A190WWPNotificationDefinitionIsAut = GXutil.strtobool( httpContext.cgiGet( chkWWPNotificationDefinitionIsAut.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
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
            A35WWPNotificationDefinitionId = GXutil.lval( httpContext.GetPar( "WWPNotificationDefinitionId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
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
            initAll0Y36( ) ;
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
      disableAttributes0Y36( ) ;
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

   public void resetCaption0Y0( )
   {
   }

   public void zm0Y36( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z181WWPNotificationDefinitionName = T000Y3_A181WWPNotificationDefinitionName[0] ;
            Z155WWPNotificationDefinitionAppli = T000Y3_A155WWPNotificationDefinitionAppli[0] ;
            Z156WWPNotificationDefinitionAllow = T000Y3_A156WWPNotificationDefinitionAllow[0] ;
            Z154WWPNotificationDefinitionDescr = T000Y3_A154WWPNotificationDefinitionDescr[0] ;
            Z184WWPNotificationDefinitionIcon = T000Y3_A184WWPNotificationDefinitionIcon[0] ;
            Z185WWPNotificationDefinitionTitle = T000Y3_A185WWPNotificationDefinitionTitle[0] ;
            Z186WWPNotificationDefinitionShort = T000Y3_A186WWPNotificationDefinitionShort[0] ;
            Z187WWPNotificationDefinitionLongD = T000Y3_A187WWPNotificationDefinitionLongD[0] ;
            Z188WWPNotificationDefinitionLink = T000Y3_A188WWPNotificationDefinitionLink[0] ;
            Z189WWPNotificationDefinitionSecFu = T000Y3_A189WWPNotificationDefinitionSecFu[0] ;
            Z33WWPEntityId = T000Y3_A33WWPEntityId[0] ;
         }
         else
         {
            Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
            Z155WWPNotificationDefinitionAppli = A155WWPNotificationDefinitionAppli ;
            Z156WWPNotificationDefinitionAllow = A156WWPNotificationDefinitionAllow ;
            Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
            Z184WWPNotificationDefinitionIcon = A184WWPNotificationDefinitionIcon ;
            Z185WWPNotificationDefinitionTitle = A185WWPNotificationDefinitionTitle ;
            Z186WWPNotificationDefinitionShort = A186WWPNotificationDefinitionShort ;
            Z187WWPNotificationDefinitionLongD = A187WWPNotificationDefinitionLongD ;
            Z188WWPNotificationDefinitionLink = A188WWPNotificationDefinitionLink ;
            Z189WWPNotificationDefinitionSecFu = A189WWPNotificationDefinitionSecFu ;
            Z33WWPEntityId = A33WWPEntityId ;
         }
      }
      if ( GX_JID == -4 )
      {
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         Z181WWPNotificationDefinitionName = A181WWPNotificationDefinitionName ;
         Z155WWPNotificationDefinitionAppli = A155WWPNotificationDefinitionAppli ;
         Z156WWPNotificationDefinitionAllow = A156WWPNotificationDefinitionAllow ;
         Z154WWPNotificationDefinitionDescr = A154WWPNotificationDefinitionDescr ;
         Z184WWPNotificationDefinitionIcon = A184WWPNotificationDefinitionIcon ;
         Z185WWPNotificationDefinitionTitle = A185WWPNotificationDefinitionTitle ;
         Z186WWPNotificationDefinitionShort = A186WWPNotificationDefinitionShort ;
         Z187WWPNotificationDefinitionLongD = A187WWPNotificationDefinitionLongD ;
         Z188WWPNotificationDefinitionLink = A188WWPNotificationDefinitionLink ;
         Z189WWPNotificationDefinitionSecFu = A189WWPNotificationDefinitionSecFu ;
         Z33WWPEntityId = A33WWPEntityId ;
         Z150WWPEntityName = A150WWPEntityName ;
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

   public void load0Y36( )
   {
      /* Using cursor T000Y5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A181WWPNotificationDefinitionName = T000Y5_A181WWPNotificationDefinitionName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         A155WWPNotificationDefinitionAppli = T000Y5_A155WWPNotificationDefinitionAppli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0));
         A156WWPNotificationDefinitionAllow = T000Y5_A156WWPNotificationDefinitionAllow[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
         A154WWPNotificationDefinitionDescr = T000Y5_A154WWPNotificationDefinitionDescr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
         A184WWPNotificationDefinitionIcon = T000Y5_A184WWPNotificationDefinitionIcon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184WWPNotificationDefinitionIcon", A184WWPNotificationDefinitionIcon);
         A185WWPNotificationDefinitionTitle = T000Y5_A185WWPNotificationDefinitionTitle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A185WWPNotificationDefinitionTitle", A185WWPNotificationDefinitionTitle);
         A186WWPNotificationDefinitionShort = T000Y5_A186WWPNotificationDefinitionShort[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A186WWPNotificationDefinitionShort", A186WWPNotificationDefinitionShort);
         A187WWPNotificationDefinitionLongD = T000Y5_A187WWPNotificationDefinitionLongD[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A187WWPNotificationDefinitionLongD", A187WWPNotificationDefinitionLongD);
         A188WWPNotificationDefinitionLink = T000Y5_A188WWPNotificationDefinitionLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A188WWPNotificationDefinitionLink", A188WWPNotificationDefinitionLink);
         A150WWPEntityName = T000Y5_A150WWPEntityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
         A189WWPNotificationDefinitionSecFu = T000Y5_A189WWPNotificationDefinitionSecFu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A189WWPNotificationDefinitionSecFu", A189WWPNotificationDefinitionSecFu);
         A33WWPEntityId = T000Y5_A33WWPEntityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
         zm0Y36( -4) ;
      }
      pr_default.close(3);
      onLoadActions0Y36( ) ;
   }

   public void onLoadActions0Y36( )
   {
      if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
      {
         A190WWPNotificationDefinitionIsAut = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      }
      else
      {
         GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
         wwp_notificationdefinition_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      }
   }

   public void checkExtendedTable0Y36( )
   {
      nIsDirty_36 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( ( A155WWPNotificationDefinitionAppli == 1 ) || ( A155WWPNotificationDefinitionAppli == 2 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Notification Definition Applies To", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPNOTIFICATIONDEFINITIONAPPLI");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbWWPNotificationDefinitionAppli.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A188WWPNotificationDefinitionLink,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Notification Definition Default Link", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPNOTIFICATIONDEFINITIONLINK");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionLink_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000Y4 */
      pr_default.execute(2, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPEntityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A150WWPEntityName = T000Y4_A150WWPEntityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      pr_default.close(2);
      if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
      {
         nIsDirty_36 = (short)(1) ;
         A190WWPNotificationDefinitionIsAut = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      }
      else
      {
         nIsDirty_36 = (short)(1) ;
         GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
         wwp_notificationdefinition_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      }
   }

   public void closeExtendedTableCursors0Y36( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_5( long A33WWPEntityId )
   {
      /* Using cursor T000Y6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPEntityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A150WWPEntityName = T000Y6_A150WWPEntityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A150WWPEntityName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey0Y36( )
   {
      /* Using cursor T000Y7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound36 = (short)(1) ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Y3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Y36( 4) ;
         RcdFound36 = (short)(1) ;
         A35WWPNotificationDefinitionId = T000Y3_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         A181WWPNotificationDefinitionName = T000Y3_A181WWPNotificationDefinitionName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
         A155WWPNotificationDefinitionAppli = T000Y3_A155WWPNotificationDefinitionAppli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0));
         A156WWPNotificationDefinitionAllow = T000Y3_A156WWPNotificationDefinitionAllow[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
         A154WWPNotificationDefinitionDescr = T000Y3_A154WWPNotificationDefinitionDescr[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
         A184WWPNotificationDefinitionIcon = T000Y3_A184WWPNotificationDefinitionIcon[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184WWPNotificationDefinitionIcon", A184WWPNotificationDefinitionIcon);
         A185WWPNotificationDefinitionTitle = T000Y3_A185WWPNotificationDefinitionTitle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A185WWPNotificationDefinitionTitle", A185WWPNotificationDefinitionTitle);
         A186WWPNotificationDefinitionShort = T000Y3_A186WWPNotificationDefinitionShort[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A186WWPNotificationDefinitionShort", A186WWPNotificationDefinitionShort);
         A187WWPNotificationDefinitionLongD = T000Y3_A187WWPNotificationDefinitionLongD[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A187WWPNotificationDefinitionLongD", A187WWPNotificationDefinitionLongD);
         A188WWPNotificationDefinitionLink = T000Y3_A188WWPNotificationDefinitionLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A188WWPNotificationDefinitionLink", A188WWPNotificationDefinitionLink);
         A189WWPNotificationDefinitionSecFu = T000Y3_A189WWPNotificationDefinitionSecFu[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A189WWPNotificationDefinitionSecFu", A189WWPNotificationDefinitionSecFu);
         A33WWPEntityId = T000Y3_A33WWPEntityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
         Z35WWPNotificationDefinitionId = A35WWPNotificationDefinitionId ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0Y36( ) ;
         if ( AnyError == 1 )
         {
            RcdFound36 = (short)(0) ;
            initializeNonKey0Y36( ) ;
         }
         Gx_mode = sMode36 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound36 = (short)(0) ;
         initializeNonKey0Y36( ) ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode36 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Y36( ) ;
      if ( RcdFound36 == 0 )
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
      RcdFound36 = (short)(0) ;
      /* Using cursor T000Y8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T000Y8_A35WWPNotificationDefinitionId[0] < A35WWPNotificationDefinitionId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T000Y8_A35WWPNotificationDefinitionId[0] > A35WWPNotificationDefinitionId ) ) )
         {
            A35WWPNotificationDefinitionId = T000Y8_A35WWPNotificationDefinitionId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
            RcdFound36 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound36 = (short)(0) ;
      /* Using cursor T000Y9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000Y9_A35WWPNotificationDefinitionId[0] > A35WWPNotificationDefinitionId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000Y9_A35WWPNotificationDefinitionId[0] < A35WWPNotificationDefinitionId ) ) )
         {
            A35WWPNotificationDefinitionId = T000Y9_A35WWPNotificationDefinitionId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
            RcdFound36 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Y36( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Y36( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound36 == 1 )
         {
            if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
            {
               A35WWPNotificationDefinitionId = Z35WWPNotificationDefinitionId ;
               httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0Y36( ) ;
               GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Y36( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPNOTIFICATIONDEFINITIONID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Y36( ) ;
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
      if ( A35WWPNotificationDefinitionId != Z35WWPNotificationDefinitionId )
      {
         A35WWPNotificationDefinitionId = Z35WWPNotificationDefinitionId ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
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
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPNOTIFICATIONDEFINITIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPNotificationDefinitionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtWWPNotificationDefinitionName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0Y36( ) ;
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0Y36( ) ;
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
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionName_Internalname ;
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
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionName_Internalname ;
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
      scanStart0Y36( ) ;
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound36 != 0 )
         {
            scanNext0Y36( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPNotificationDefinitionName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0Y36( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0Y36( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Y2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_NotificationDefinition"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z181WWPNotificationDefinitionName, T000Y2_A181WWPNotificationDefinitionName[0]) != 0 ) || ( Z155WWPNotificationDefinitionAppli != T000Y2_A155WWPNotificationDefinitionAppli[0] ) || ( Z156WWPNotificationDefinitionAllow != T000Y2_A156WWPNotificationDefinitionAllow[0] ) || ( GXutil.strcmp(Z154WWPNotificationDefinitionDescr, T000Y2_A154WWPNotificationDefinitionDescr[0]) != 0 ) || ( GXutil.strcmp(Z184WWPNotificationDefinitionIcon, T000Y2_A184WWPNotificationDefinitionIcon[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z185WWPNotificationDefinitionTitle, T000Y2_A185WWPNotificationDefinitionTitle[0]) != 0 ) || ( GXutil.strcmp(Z186WWPNotificationDefinitionShort, T000Y2_A186WWPNotificationDefinitionShort[0]) != 0 ) || ( GXutil.strcmp(Z187WWPNotificationDefinitionLongD, T000Y2_A187WWPNotificationDefinitionLongD[0]) != 0 ) || ( GXutil.strcmp(Z188WWPNotificationDefinitionLink, T000Y2_A188WWPNotificationDefinitionLink[0]) != 0 ) || ( GXutil.strcmp(Z189WWPNotificationDefinitionSecFu, T000Y2_A189WWPNotificationDefinitionSecFu[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z33WWPEntityId != T000Y2_A33WWPEntityId[0] ) )
         {
            if ( GXutil.strcmp(Z181WWPNotificationDefinitionName, T000Y2_A181WWPNotificationDefinitionName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionName");
               GXutil.writeLogRaw("Old: ",Z181WWPNotificationDefinitionName);
               GXutil.writeLogRaw("Current: ",T000Y2_A181WWPNotificationDefinitionName[0]);
            }
            if ( Z155WWPNotificationDefinitionAppli != T000Y2_A155WWPNotificationDefinitionAppli[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionAppli");
               GXutil.writeLogRaw("Old: ",Z155WWPNotificationDefinitionAppli);
               GXutil.writeLogRaw("Current: ",T000Y2_A155WWPNotificationDefinitionAppli[0]);
            }
            if ( Z156WWPNotificationDefinitionAllow != T000Y2_A156WWPNotificationDefinitionAllow[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionAllow");
               GXutil.writeLogRaw("Old: ",Z156WWPNotificationDefinitionAllow);
               GXutil.writeLogRaw("Current: ",T000Y2_A156WWPNotificationDefinitionAllow[0]);
            }
            if ( GXutil.strcmp(Z154WWPNotificationDefinitionDescr, T000Y2_A154WWPNotificationDefinitionDescr[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionDescr");
               GXutil.writeLogRaw("Old: ",Z154WWPNotificationDefinitionDescr);
               GXutil.writeLogRaw("Current: ",T000Y2_A154WWPNotificationDefinitionDescr[0]);
            }
            if ( GXutil.strcmp(Z184WWPNotificationDefinitionIcon, T000Y2_A184WWPNotificationDefinitionIcon[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionIcon");
               GXutil.writeLogRaw("Old: ",Z184WWPNotificationDefinitionIcon);
               GXutil.writeLogRaw("Current: ",T000Y2_A184WWPNotificationDefinitionIcon[0]);
            }
            if ( GXutil.strcmp(Z185WWPNotificationDefinitionTitle, T000Y2_A185WWPNotificationDefinitionTitle[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionTitle");
               GXutil.writeLogRaw("Old: ",Z185WWPNotificationDefinitionTitle);
               GXutil.writeLogRaw("Current: ",T000Y2_A185WWPNotificationDefinitionTitle[0]);
            }
            if ( GXutil.strcmp(Z186WWPNotificationDefinitionShort, T000Y2_A186WWPNotificationDefinitionShort[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionShort");
               GXutil.writeLogRaw("Old: ",Z186WWPNotificationDefinitionShort);
               GXutil.writeLogRaw("Current: ",T000Y2_A186WWPNotificationDefinitionShort[0]);
            }
            if ( GXutil.strcmp(Z187WWPNotificationDefinitionLongD, T000Y2_A187WWPNotificationDefinitionLongD[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionLongD");
               GXutil.writeLogRaw("Old: ",Z187WWPNotificationDefinitionLongD);
               GXutil.writeLogRaw("Current: ",T000Y2_A187WWPNotificationDefinitionLongD[0]);
            }
            if ( GXutil.strcmp(Z188WWPNotificationDefinitionLink, T000Y2_A188WWPNotificationDefinitionLink[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionLink");
               GXutil.writeLogRaw("Old: ",Z188WWPNotificationDefinitionLink);
               GXutil.writeLogRaw("Current: ",T000Y2_A188WWPNotificationDefinitionLink[0]);
            }
            if ( GXutil.strcmp(Z189WWPNotificationDefinitionSecFu, T000Y2_A189WWPNotificationDefinitionSecFu[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPNotificationDefinitionSecFu");
               GXutil.writeLogRaw("Old: ",Z189WWPNotificationDefinitionSecFu);
               GXutil.writeLogRaw("Current: ",T000Y2_A189WWPNotificationDefinitionSecFu[0]);
            }
            if ( Z33WWPEntityId != T000Y2_A33WWPEntityId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.common.wwp_notificationdefinition:[seudo value changed for attri]"+"WWPEntityId");
               GXutil.writeLogRaw("Old: ",Z33WWPEntityId);
               GXutil.writeLogRaw("Current: ",T000Y2_A33WWPEntityId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_NotificationDefinition"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Y36( )
   {
      if ( ! IsAuthorized("wwpnotificationdefinition_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Y36( 0) ;
         checkOptimisticConcurrency0Y36( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y36( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Y36( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Y10 */
                  pr_default.execute(8, new Object[] {A181WWPNotificationDefinitionName, Byte.valueOf(A155WWPNotificationDefinitionAppli), Boolean.valueOf(A156WWPNotificationDefinitionAllow), A154WWPNotificationDefinitionDescr, A184WWPNotificationDefinitionIcon, A185WWPNotificationDefinitionTitle, A186WWPNotificationDefinitionShort, A187WWPNotificationDefinitionLongD, A188WWPNotificationDefinitionLink, A189WWPNotificationDefinitionSecFu, Long.valueOf(A33WWPEntityId)});
                  A35WWPNotificationDefinitionId = T000Y10_A35WWPNotificationDefinitionId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
                  pr_default.close(8);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_NotificationDefinition");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0Y0( ) ;
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
            load0Y36( ) ;
         }
         endLevel0Y36( ) ;
      }
      closeExtendedTableCursors0Y36( ) ;
   }

   public void update0Y36( )
   {
      if ( ! IsAuthorized("wwpnotificationdefinition_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y36( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y36( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Y36( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Y11 */
                  pr_default.execute(9, new Object[] {A181WWPNotificationDefinitionName, Byte.valueOf(A155WWPNotificationDefinitionAppli), Boolean.valueOf(A156WWPNotificationDefinitionAllow), A154WWPNotificationDefinitionDescr, A184WWPNotificationDefinitionIcon, A185WWPNotificationDefinitionTitle, A186WWPNotificationDefinitionShort, A187WWPNotificationDefinitionLongD, A188WWPNotificationDefinitionLink, A189WWPNotificationDefinitionSecFu, Long.valueOf(A33WWPEntityId), Long.valueOf(A35WWPNotificationDefinitionId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_NotificationDefinition");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_NotificationDefinition"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Y36( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0Y0( ) ;
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
         endLevel0Y36( ) ;
      }
      closeExtendedTableCursors0Y36( ) ;
   }

   public void deferredUpdate0Y36( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("wwpnotificationdefinition_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0Y36( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Y36( ) ;
         afterConfirm0Y36( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Y36( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Y12 */
               pr_default.execute(10, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_NotificationDefinition");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound36 == 0 )
                     {
                        initAll0Y36( ) ;
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
                     resetCaption0Y0( ) ;
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
      sMode36 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Y36( ) ;
      Gx_mode = sMode36 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Y36( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000Y13 */
         pr_default.execute(11, new Object[] {Long.valueOf(A33WWPEntityId)});
         A150WWPEntityName = T000Y13_A150WWPEntityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
         pr_default.close(11);
         if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
         {
            A190WWPNotificationDefinitionIsAut = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
         }
         else
         {
            GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
            GXv_boolean2[0] = GXt_boolean1 ;
            new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
            wwp_notificationdefinition_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
            A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000Y14 */
         pr_default.execute(12, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Notification", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T000Y15 */
         pr_default.execute(13, new Object[] {Long.valueOf(A35WWPNotificationDefinitionId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Subscription", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel0Y36( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Y36( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(11);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_notificationdefinition");
         if ( AnyError == 0 )
         {
            confirmValues0Y0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(11);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.common.wwp_notificationdefinition");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Y36( )
   {
      /* Using cursor T000Y16 */
      pr_default.execute(14);
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A35WWPNotificationDefinitionId = T000Y16_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Y36( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A35WWPNotificationDefinitionId = T000Y16_A35WWPNotificationDefinitionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
      }
   }

   public void scanEnd0Y36( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0Y36( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Y36( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Y36( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Y36( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Y36( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Y36( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Y36( )
   {
      edtWWPNotificationDefinitionId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionId_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionName_Enabled), 5, 0), true);
      cmbWWPNotificationDefinitionAppli.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPNotificationDefinitionAppli.getInternalname(), "Enabled", GXutil.ltrimstr( cmbWWPNotificationDefinitionAppli.getEnabled(), 5, 0), true);
      chkWWPNotificationDefinitionAllow.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPNotificationDefinitionAllow.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPNotificationDefinitionAllow.getEnabled(), 5, 0), true);
      edtWWPNotificationDefinitionDescr_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionDescr_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionDescr_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionIcon_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionIcon_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionIcon_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionTitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionTitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionTitle_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionShort_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionShort_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionShort_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionLongD_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionLongD_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionLongD_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionLink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionLink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionLink_Enabled), 5, 0), true);
      edtWWPEntityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPEntityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPEntityId_Enabled), 5, 0), true);
      edtWWPEntityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPEntityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPEntityName_Enabled), 5, 0), true);
      edtWWPNotificationDefinitionSecFu_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationDefinitionSecFu_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationDefinitionSecFu_Enabled), 5, 0), true);
      chkWWPNotificationDefinitionIsAut.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPNotificationDefinitionIsAut.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPNotificationDefinitionIsAut.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Y36( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Y0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z181WWPNotificationDefinitionName", Z181WWPNotificationDefinitionName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z155WWPNotificationDefinitionAppli", GXutil.ltrim( localUtil.ntoc( Z155WWPNotificationDefinitionAppli, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z156WWPNotificationDefinitionAllow", Z156WWPNotificationDefinitionAllow);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z154WWPNotificationDefinitionDescr", Z154WWPNotificationDefinitionDescr);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z184WWPNotificationDefinitionIcon", Z184WWPNotificationDefinitionIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z185WWPNotificationDefinitionTitle", Z185WWPNotificationDefinitionTitle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z186WWPNotificationDefinitionShort", Z186WWPNotificationDefinitionShort);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z187WWPNotificationDefinitionLongD", Z187WWPNotificationDefinitionLongD);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z188WWPNotificationDefinitionLink", Z188WWPNotificationDefinitionLink);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z189WWPNotificationDefinitionSecFu", Z189WWPNotificationDefinitionSecFu);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z33WWPEntityId", GXutil.ltrim( localUtil.ntoc( Z33WWPEntityId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
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
      return formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Common.WWP_NotificationDefinition" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Notification Definition", "") ;
   }

   public void initializeNonKey0Y36( )
   {
      A190WWPNotificationDefinitionIsAut = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      A181WWPNotificationDefinitionName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      A155WWPNotificationDefinitionAppli = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0));
      A156WWPNotificationDefinitionAllow = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
      A154WWPNotificationDefinitionDescr = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      A184WWPNotificationDefinitionIcon = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A184WWPNotificationDefinitionIcon", A184WWPNotificationDefinitionIcon);
      A185WWPNotificationDefinitionTitle = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A185WWPNotificationDefinitionTitle", A185WWPNotificationDefinitionTitle);
      A186WWPNotificationDefinitionShort = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A186WWPNotificationDefinitionShort", A186WWPNotificationDefinitionShort);
      A187WWPNotificationDefinitionLongD = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A187WWPNotificationDefinitionLongD", A187WWPNotificationDefinitionLongD);
      A188WWPNotificationDefinitionLink = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A188WWPNotificationDefinitionLink", A188WWPNotificationDefinitionLink);
      A33WWPEntityId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A33WWPEntityId), 10, 0));
      A150WWPEntityName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      A189WWPNotificationDefinitionSecFu = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A189WWPNotificationDefinitionSecFu", A189WWPNotificationDefinitionSecFu);
      Z181WWPNotificationDefinitionName = "" ;
      Z155WWPNotificationDefinitionAppli = (byte)(0) ;
      Z156WWPNotificationDefinitionAllow = false ;
      Z154WWPNotificationDefinitionDescr = "" ;
      Z184WWPNotificationDefinitionIcon = "" ;
      Z185WWPNotificationDefinitionTitle = "" ;
      Z186WWPNotificationDefinitionShort = "" ;
      Z187WWPNotificationDefinitionLongD = "" ;
      Z188WWPNotificationDefinitionLink = "" ;
      Z189WWPNotificationDefinitionSecFu = "" ;
      Z33WWPEntityId = 0 ;
   }

   public void initAll0Y36( )
   {
      A35WWPNotificationDefinitionId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A35WWPNotificationDefinitionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35WWPNotificationDefinitionId), 10, 0));
      initializeNonKey0Y36( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111102451", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/notifications/common/wwp_notificationdefinition.js", "?202412111102452", false, true);
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
      edtWWPNotificationDefinitionId_Internalname = "WWPNOTIFICATIONDEFINITIONID" ;
      edtWWPNotificationDefinitionName_Internalname = "WWPNOTIFICATIONDEFINITIONNAME" ;
      cmbWWPNotificationDefinitionAppli.setInternalname( "WWPNOTIFICATIONDEFINITIONAPPLI" );
      chkWWPNotificationDefinitionAllow.setInternalname( "WWPNOTIFICATIONDEFINITIONALLOW" );
      edtWWPNotificationDefinitionDescr_Internalname = "WWPNOTIFICATIONDEFINITIONDESCR" ;
      edtWWPNotificationDefinitionIcon_Internalname = "WWPNOTIFICATIONDEFINITIONICON" ;
      edtWWPNotificationDefinitionTitle_Internalname = "WWPNOTIFICATIONDEFINITIONTITLE" ;
      edtWWPNotificationDefinitionShort_Internalname = "WWPNOTIFICATIONDEFINITIONSHORT" ;
      edtWWPNotificationDefinitionLongD_Internalname = "WWPNOTIFICATIONDEFINITIONLONGD" ;
      edtWWPNotificationDefinitionLink_Internalname = "WWPNOTIFICATIONDEFINITIONLINK" ;
      edtWWPEntityId_Internalname = "WWPENTITYID" ;
      edtWWPEntityName_Internalname = "WWPENTITYNAME" ;
      edtWWPNotificationDefinitionSecFu_Internalname = "WWPNOTIFICATIONDEFINITIONSECFU" ;
      chkWWPNotificationDefinitionIsAut.setInternalname( "WWPNOTIFICATIONDEFINITIONISAUT" );
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
      Form.setCaption( httpContext.getMessage( "Notification Definition", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      chkWWPNotificationDefinitionIsAut.setEnabled( 0 );
      edtWWPNotificationDefinitionSecFu_Enabled = 1 ;
      edtWWPEntityName_Jsonclick = "" ;
      edtWWPEntityName_Enabled = 0 ;
      edtWWPEntityId_Jsonclick = "" ;
      edtWWPEntityId_Enabled = 1 ;
      edtWWPNotificationDefinitionLink_Jsonclick = "" ;
      edtWWPNotificationDefinitionLink_Enabled = 1 ;
      edtWWPNotificationDefinitionLongD_Enabled = 1 ;
      edtWWPNotificationDefinitionShort_Enabled = 1 ;
      edtWWPNotificationDefinitionTitle_Enabled = 1 ;
      edtWWPNotificationDefinitionIcon_Jsonclick = "" ;
      edtWWPNotificationDefinitionIcon_Enabled = 1 ;
      edtWWPNotificationDefinitionDescr_Enabled = 1 ;
      chkWWPNotificationDefinitionAllow.setEnabled( 1 );
      cmbWWPNotificationDefinitionAppli.setJsonclick( "" );
      cmbWWPNotificationDefinitionAppli.setEnabled( 1 );
      edtWWPNotificationDefinitionName_Jsonclick = "" ;
      edtWWPNotificationDefinitionName_Enabled = 1 ;
      edtWWPNotificationDefinitionId_Jsonclick = "" ;
      edtWWPNotificationDefinitionId_Enabled = 1 ;
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

   public void gx3asawwpnotificationdefinitionisaut0Y36( String A189WWPNotificationDefinitionSecFu )
   {
      if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
      {
         A190WWPNotificationDefinitionIsAut = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      }
      else
      {
         GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
         wwp_notificationdefinition_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( A190WWPNotificationDefinitionIsAut))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      cmbWWPNotificationDefinitionAppli.setName( "WWPNOTIFICATIONDEFINITIONAPPLI" );
      cmbWWPNotificationDefinitionAppli.setWebtags( "" );
      cmbWWPNotificationDefinitionAppli.addItem("1", httpContext.getMessage( "Any record", ""), (short)(0));
      cmbWWPNotificationDefinitionAppli.addItem("2", httpContext.getMessage( "Specific record", ""), (short)(0));
      if ( cmbWWPNotificationDefinitionAppli.getItemCount() > 0 )
      {
         A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( cmbWWPNotificationDefinitionAppli.getValidValue(GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0));
      }
      chkWWPNotificationDefinitionAllow.setName( "WWPNOTIFICATIONDEFINITIONALLOW" );
      chkWWPNotificationDefinitionAllow.setWebtags( "" );
      chkWWPNotificationDefinitionAllow.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPNotificationDefinitionAllow.getInternalname(), "TitleCaption", chkWWPNotificationDefinitionAllow.getCaption(), true);
      chkWWPNotificationDefinitionAllow.setCheckedValue( "false" );
      A156WWPNotificationDefinitionAllow = GXutil.strtobool( GXutil.booltostr( A156WWPNotificationDefinitionAllow)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
      chkWWPNotificationDefinitionIsAut.setName( "WWPNOTIFICATIONDEFINITIONISAUT" );
      chkWWPNotificationDefinitionIsAut.setWebtags( "" );
      chkWWPNotificationDefinitionIsAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPNotificationDefinitionIsAut.getInternalname(), "TitleCaption", chkWWPNotificationDefinitionIsAut.getCaption(), true);
      chkWWPNotificationDefinitionIsAut.setCheckedValue( "false" );
      A190WWPNotificationDefinitionIsAut = GXutil.strtobool( GXutil.booltostr( A190WWPNotificationDefinitionIsAut)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtWWPNotificationDefinitionName_Internalname ;
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

   public void valid_Wwpnotificationdefinitionid( )
   {
      A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( cmbWWPNotificationDefinitionAppli.getValue())) ;
      cmbWWPNotificationDefinitionAppli.setValue( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0) );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbWWPNotificationDefinitionAppli.getItemCount() > 0 )
      {
         A155WWPNotificationDefinitionAppli = (byte)(GXutil.lval( cmbWWPNotificationDefinitionAppli.getValidValue(GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0))))) ;
         cmbWWPNotificationDefinitionAppli.setValue( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPNotificationDefinitionAppli.setValue( GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0)) );
      }
      A156WWPNotificationDefinitionAllow = GXutil.strtobool( GXutil.booltostr( A156WWPNotificationDefinitionAllow)) ;
      A190WWPNotificationDefinitionIsAut = GXutil.strtobool( GXutil.booltostr( A190WWPNotificationDefinitionIsAut)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A181WWPNotificationDefinitionName", A181WWPNotificationDefinitionName);
      httpContext.ajax_rsp_assign_attri("", false, "A155WWPNotificationDefinitionAppli", GXutil.ltrim( localUtil.ntoc( A155WWPNotificationDefinitionAppli, (byte)(1), (byte)(0), ".", "")));
      cmbWWPNotificationDefinitionAppli.setValue( GXutil.trim( GXutil.str( A155WWPNotificationDefinitionAppli, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPNotificationDefinitionAppli.getInternalname(), "Values", cmbWWPNotificationDefinitionAppli.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A156WWPNotificationDefinitionAllow", A156WWPNotificationDefinitionAllow);
      httpContext.ajax_rsp_assign_attri("", false, "A154WWPNotificationDefinitionDescr", A154WWPNotificationDefinitionDescr);
      httpContext.ajax_rsp_assign_attri("", false, "A184WWPNotificationDefinitionIcon", A184WWPNotificationDefinitionIcon);
      httpContext.ajax_rsp_assign_attri("", false, "A185WWPNotificationDefinitionTitle", A185WWPNotificationDefinitionTitle);
      httpContext.ajax_rsp_assign_attri("", false, "A186WWPNotificationDefinitionShort", A186WWPNotificationDefinitionShort);
      httpContext.ajax_rsp_assign_attri("", false, "A187WWPNotificationDefinitionLongD", A187WWPNotificationDefinitionLongD);
      httpContext.ajax_rsp_assign_attri("", false, "A188WWPNotificationDefinitionLink", A188WWPNotificationDefinitionLink);
      httpContext.ajax_rsp_assign_attri("", false, "A33WWPEntityId", GXutil.ltrim( localUtil.ntoc( A33WWPEntityId, (byte)(10), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A189WWPNotificationDefinitionSecFu", A189WWPNotificationDefinitionSecFu);
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
      httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z35WWPNotificationDefinitionId", GXutil.ltrim( localUtil.ntoc( Z35WWPNotificationDefinitionId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z181WWPNotificationDefinitionName", Z181WWPNotificationDefinitionName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z155WWPNotificationDefinitionAppli", GXutil.ltrim( localUtil.ntoc( Z155WWPNotificationDefinitionAppli, (byte)(1), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z156WWPNotificationDefinitionAllow", GXutil.booltostr( Z156WWPNotificationDefinitionAllow));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z154WWPNotificationDefinitionDescr", Z154WWPNotificationDefinitionDescr);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z184WWPNotificationDefinitionIcon", Z184WWPNotificationDefinitionIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z185WWPNotificationDefinitionTitle", Z185WWPNotificationDefinitionTitle);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z186WWPNotificationDefinitionShort", Z186WWPNotificationDefinitionShort);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z187WWPNotificationDefinitionLongD", Z187WWPNotificationDefinitionLongD);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z188WWPNotificationDefinitionLink", Z188WWPNotificationDefinitionLink);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z33WWPEntityId", GXutil.ltrim( localUtil.ntoc( Z33WWPEntityId, (byte)(10), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z189WWPNotificationDefinitionSecFu", Z189WWPNotificationDefinitionSecFu);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z150WWPEntityName", Z150WWPEntityName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z190WWPNotificationDefinitionIsAut", GXutil.booltostr( Z190WWPNotificationDefinitionIsAut));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpentityid( )
   {
      /* Using cursor T000Y13 */
      pr_default.execute(11, new Object[] {Long.valueOf(A33WWPEntityId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_Entity", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPENTITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPEntityId_Internalname ;
      }
      A150WWPEntityName = T000Y13_A150WWPEntityName[0] ;
      pr_default.close(11);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A150WWPEntityName", A150WWPEntityName);
   }

   public void valid_Wwpnotificationdefinitionsecfu( )
   {
      if ( (GXutil.strcmp("", A189WWPNotificationDefinitionSecFu)==0) )
      {
         A190WWPNotificationDefinitionIsAut = true ;
      }
      else
      {
         GXt_boolean1 = A190WWPNotificationDefinitionIsAut ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( A189WWPNotificationDefinitionSecFu, GXv_boolean2) ;
         wwp_notificationdefinition_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         A190WWPNotificationDefinitionIsAut = GXt_boolean1 ;
      }
      dynload_actions( ) ;
      A190WWPNotificationDefinitionIsAut = GXutil.strtobool( GXutil.booltostr( A190WWPNotificationDefinitionIsAut)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A190WWPNotificationDefinitionIsAut", A190WWPNotificationDefinitionIsAut);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONID","{handler:'valid_Wwpnotificationdefinitionid',iparms:[{av:'cmbWWPNotificationDefinitionAppli'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A35WWPNotificationDefinitionId',fld:'WWPNOTIFICATIONDEFINITIONID',pic:'ZZZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONID",",oparms:[{av:'A181WWPNotificationDefinitionName',fld:'WWPNOTIFICATIONDEFINITIONNAME',pic:''},{av:'cmbWWPNotificationDefinitionAppli'},{av:'A155WWPNotificationDefinitionAppli',fld:'WWPNOTIFICATIONDEFINITIONAPPLI',pic:'9'},{av:'A154WWPNotificationDefinitionDescr',fld:'WWPNOTIFICATIONDEFINITIONDESCR',pic:''},{av:'A184WWPNotificationDefinitionIcon',fld:'WWPNOTIFICATIONDEFINITIONICON',pic:''},{av:'A185WWPNotificationDefinitionTitle',fld:'WWPNOTIFICATIONDEFINITIONTITLE',pic:''},{av:'A186WWPNotificationDefinitionShort',fld:'WWPNOTIFICATIONDEFINITIONSHORT',pic:''},{av:'A187WWPNotificationDefinitionLongD',fld:'WWPNOTIFICATIONDEFINITIONLONGD',pic:''},{av:'A188WWPNotificationDefinitionLink',fld:'WWPNOTIFICATIONDEFINITIONLINK',pic:''},{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A189WWPNotificationDefinitionSecFu',fld:'WWPNOTIFICATIONDEFINITIONSECFU',pic:''},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z35WWPNotificationDefinitionId'},{av:'Z181WWPNotificationDefinitionName'},{av:'Z155WWPNotificationDefinitionAppli'},{av:'Z156WWPNotificationDefinitionAllow'},{av:'Z154WWPNotificationDefinitionDescr'},{av:'Z184WWPNotificationDefinitionIcon'},{av:'Z185WWPNotificationDefinitionTitle'},{av:'Z186WWPNotificationDefinitionShort'},{av:'Z187WWPNotificationDefinitionLongD'},{av:'Z188WWPNotificationDefinitionLink'},{av:'Z33WWPEntityId'},{av:'Z189WWPNotificationDefinitionSecFu'},{av:'Z150WWPEntityName'},{av:'Z190WWPNotificationDefinitionIsAut'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONAPPLI","{handler:'valid_Wwpnotificationdefinitionappli',iparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONAPPLI",",oparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONLINK","{handler:'valid_Wwpnotificationdefinitionlink',iparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONLINK",",oparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
      setEventMetadata("VALID_WWPENTITYID","{handler:'valid_Wwpentityid',iparms:[{av:'A33WWPEntityId',fld:'WWPENTITYID',pic:'ZZZZZZZZZ9'},{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("VALID_WWPENTITYID",",oparms:[{av:'A150WWPEntityName',fld:'WWPENTITYNAME',pic:''},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONSECFU","{handler:'valid_Wwpnotificationdefinitionsecfu',iparms:[{av:'A189WWPNotificationDefinitionSecFu',fld:'WWPNOTIFICATIONDEFINITIONSECFU',pic:''},{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]");
      setEventMetadata("VALID_WWPNOTIFICATIONDEFINITIONSECFU",",oparms:[{av:'A156WWPNotificationDefinitionAllow',fld:'WWPNOTIFICATIONDEFINITIONALLOW',pic:''},{av:'A190WWPNotificationDefinitionIsAut',fld:'WWPNOTIFICATIONDEFINITIONISAUT',pic:''}]}");
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
      return "wwpnotificationdefinition_Execute";
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
      Z181WWPNotificationDefinitionName = "" ;
      Z154WWPNotificationDefinitionDescr = "" ;
      Z184WWPNotificationDefinitionIcon = "" ;
      Z185WWPNotificationDefinitionTitle = "" ;
      Z186WWPNotificationDefinitionShort = "" ;
      Z187WWPNotificationDefinitionLongD = "" ;
      Z188WWPNotificationDefinitionLink = "" ;
      Z189WWPNotificationDefinitionSecFu = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A189WWPNotificationDefinitionSecFu = "" ;
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
      A154WWPNotificationDefinitionDescr = "" ;
      A184WWPNotificationDefinitionIcon = "" ;
      A185WWPNotificationDefinitionTitle = "" ;
      A186WWPNotificationDefinitionShort = "" ;
      A187WWPNotificationDefinitionLongD = "" ;
      A188WWPNotificationDefinitionLink = "" ;
      A150WWPEntityName = "" ;
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
      Z150WWPEntityName = "" ;
      T000Y5_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y5_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Y5_A155WWPNotificationDefinitionAppli = new byte[1] ;
      T000Y5_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      T000Y5_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000Y5_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      T000Y5_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      T000Y5_A186WWPNotificationDefinitionShort = new String[] {""} ;
      T000Y5_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      T000Y5_A188WWPNotificationDefinitionLink = new String[] {""} ;
      T000Y5_A150WWPEntityName = new String[] {""} ;
      T000Y5_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      T000Y5_A33WWPEntityId = new long[1] ;
      T000Y4_A150WWPEntityName = new String[] {""} ;
      T000Y6_A150WWPEntityName = new String[] {""} ;
      T000Y7_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y3_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y3_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Y3_A155WWPNotificationDefinitionAppli = new byte[1] ;
      T000Y3_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      T000Y3_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000Y3_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      T000Y3_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      T000Y3_A186WWPNotificationDefinitionShort = new String[] {""} ;
      T000Y3_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      T000Y3_A188WWPNotificationDefinitionLink = new String[] {""} ;
      T000Y3_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      T000Y3_A33WWPEntityId = new long[1] ;
      sMode36 = "" ;
      T000Y8_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y9_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y2_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y2_A181WWPNotificationDefinitionName = new String[] {""} ;
      T000Y2_A155WWPNotificationDefinitionAppli = new byte[1] ;
      T000Y2_A156WWPNotificationDefinitionAllow = new boolean[] {false} ;
      T000Y2_A154WWPNotificationDefinitionDescr = new String[] {""} ;
      T000Y2_A184WWPNotificationDefinitionIcon = new String[] {""} ;
      T000Y2_A185WWPNotificationDefinitionTitle = new String[] {""} ;
      T000Y2_A186WWPNotificationDefinitionShort = new String[] {""} ;
      T000Y2_A187WWPNotificationDefinitionLongD = new String[] {""} ;
      T000Y2_A188WWPNotificationDefinitionLink = new String[] {""} ;
      T000Y2_A189WWPNotificationDefinitionSecFu = new String[] {""} ;
      T000Y2_A33WWPEntityId = new long[1] ;
      T000Y10_A35WWPNotificationDefinitionId = new long[1] ;
      T000Y13_A150WWPEntityName = new String[] {""} ;
      T000Y14_A37WWPNotificationId = new long[1] ;
      T000Y15_A34WWPSubscriptionId = new long[1] ;
      T000Y16_A35WWPNotificationDefinitionId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ181WWPNotificationDefinitionName = "" ;
      ZZ154WWPNotificationDefinitionDescr = "" ;
      ZZ184WWPNotificationDefinitionIcon = "" ;
      ZZ185WWPNotificationDefinitionTitle = "" ;
      ZZ186WWPNotificationDefinitionShort = "" ;
      ZZ187WWPNotificationDefinitionLongD = "" ;
      ZZ188WWPNotificationDefinitionLink = "" ;
      ZZ189WWPNotificationDefinitionSecFu = "" ;
      ZZ150WWPEntityName = "" ;
      GXv_boolean2 = new boolean[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_notificationdefinition__default(),
         new Object[] {
             new Object[] {
            T000Y2_A35WWPNotificationDefinitionId, T000Y2_A181WWPNotificationDefinitionName, T000Y2_A155WWPNotificationDefinitionAppli, T000Y2_A156WWPNotificationDefinitionAllow, T000Y2_A154WWPNotificationDefinitionDescr, T000Y2_A184WWPNotificationDefinitionIcon, T000Y2_A185WWPNotificationDefinitionTitle, T000Y2_A186WWPNotificationDefinitionShort, T000Y2_A187WWPNotificationDefinitionLongD, T000Y2_A188WWPNotificationDefinitionLink,
            T000Y2_A189WWPNotificationDefinitionSecFu, T000Y2_A33WWPEntityId
            }
            , new Object[] {
            T000Y3_A35WWPNotificationDefinitionId, T000Y3_A181WWPNotificationDefinitionName, T000Y3_A155WWPNotificationDefinitionAppli, T000Y3_A156WWPNotificationDefinitionAllow, T000Y3_A154WWPNotificationDefinitionDescr, T000Y3_A184WWPNotificationDefinitionIcon, T000Y3_A185WWPNotificationDefinitionTitle, T000Y3_A186WWPNotificationDefinitionShort, T000Y3_A187WWPNotificationDefinitionLongD, T000Y3_A188WWPNotificationDefinitionLink,
            T000Y3_A189WWPNotificationDefinitionSecFu, T000Y3_A33WWPEntityId
            }
            , new Object[] {
            T000Y4_A150WWPEntityName
            }
            , new Object[] {
            T000Y5_A35WWPNotificationDefinitionId, T000Y5_A181WWPNotificationDefinitionName, T000Y5_A155WWPNotificationDefinitionAppli, T000Y5_A156WWPNotificationDefinitionAllow, T000Y5_A154WWPNotificationDefinitionDescr, T000Y5_A184WWPNotificationDefinitionIcon, T000Y5_A185WWPNotificationDefinitionTitle, T000Y5_A186WWPNotificationDefinitionShort, T000Y5_A187WWPNotificationDefinitionLongD, T000Y5_A188WWPNotificationDefinitionLink,
            T000Y5_A150WWPEntityName, T000Y5_A189WWPNotificationDefinitionSecFu, T000Y5_A33WWPEntityId
            }
            , new Object[] {
            T000Y6_A150WWPEntityName
            }
            , new Object[] {
            T000Y7_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            T000Y8_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            T000Y9_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            T000Y10_A35WWPNotificationDefinitionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Y13_A150WWPEntityName
            }
            , new Object[] {
            T000Y14_A37WWPNotificationId
            }
            , new Object[] {
            T000Y15_A34WWPSubscriptionId
            }
            , new Object[] {
            T000Y16_A35WWPNotificationDefinitionId
            }
         }
      );
   }

   private byte Z155WWPNotificationDefinitionAppli ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A155WWPNotificationDefinitionAppli ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ155WWPNotificationDefinitionAppli ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound36 ;
   private short nIsDirty_36 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPNotificationDefinitionId_Enabled ;
   private int edtWWPNotificationDefinitionName_Enabled ;
   private int edtWWPNotificationDefinitionDescr_Enabled ;
   private int edtWWPNotificationDefinitionIcon_Enabled ;
   private int edtWWPNotificationDefinitionTitle_Enabled ;
   private int edtWWPNotificationDefinitionShort_Enabled ;
   private int edtWWPNotificationDefinitionLongD_Enabled ;
   private int edtWWPNotificationDefinitionLink_Enabled ;
   private int edtWWPEntityId_Enabled ;
   private int edtWWPEntityName_Enabled ;
   private int edtWWPNotificationDefinitionSecFu_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private long Z35WWPNotificationDefinitionId ;
   private long Z33WWPEntityId ;
   private long A33WWPEntityId ;
   private long A35WWPNotificationDefinitionId ;
   private long ZZ35WWPNotificationDefinitionId ;
   private long ZZ33WWPEntityId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPNotificationDefinitionId_Internalname ;
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
   private String edtWWPNotificationDefinitionId_Jsonclick ;
   private String edtWWPNotificationDefinitionName_Internalname ;
   private String edtWWPNotificationDefinitionName_Jsonclick ;
   private String edtWWPNotificationDefinitionDescr_Internalname ;
   private String edtWWPNotificationDefinitionIcon_Internalname ;
   private String edtWWPNotificationDefinitionIcon_Jsonclick ;
   private String edtWWPNotificationDefinitionTitle_Internalname ;
   private String edtWWPNotificationDefinitionShort_Internalname ;
   private String edtWWPNotificationDefinitionLongD_Internalname ;
   private String edtWWPNotificationDefinitionLink_Internalname ;
   private String edtWWPNotificationDefinitionLink_Jsonclick ;
   private String edtWWPEntityId_Internalname ;
   private String edtWWPEntityId_Jsonclick ;
   private String edtWWPEntityName_Internalname ;
   private String edtWWPEntityName_Jsonclick ;
   private String edtWWPNotificationDefinitionSecFu_Internalname ;
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
   private String sMode36 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z156WWPNotificationDefinitionAllow ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A156WWPNotificationDefinitionAllow ;
   private boolean A190WWPNotificationDefinitionIsAut ;
   private boolean Gx_longc ;
   private boolean Z190WWPNotificationDefinitionIsAut ;
   private boolean ZZ156WWPNotificationDefinitionAllow ;
   private boolean ZZ190WWPNotificationDefinitionIsAut ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String Z181WWPNotificationDefinitionName ;
   private String Z154WWPNotificationDefinitionDescr ;
   private String Z184WWPNotificationDefinitionIcon ;
   private String Z185WWPNotificationDefinitionTitle ;
   private String Z186WWPNotificationDefinitionShort ;
   private String Z187WWPNotificationDefinitionLongD ;
   private String Z188WWPNotificationDefinitionLink ;
   private String Z189WWPNotificationDefinitionSecFu ;
   private String A189WWPNotificationDefinitionSecFu ;
   private String A181WWPNotificationDefinitionName ;
   private String A154WWPNotificationDefinitionDescr ;
   private String A184WWPNotificationDefinitionIcon ;
   private String A185WWPNotificationDefinitionTitle ;
   private String A186WWPNotificationDefinitionShort ;
   private String A187WWPNotificationDefinitionLongD ;
   private String A188WWPNotificationDefinitionLink ;
   private String A150WWPEntityName ;
   private String Z150WWPEntityName ;
   private String ZZ181WWPNotificationDefinitionName ;
   private String ZZ154WWPNotificationDefinitionDescr ;
   private String ZZ184WWPNotificationDefinitionIcon ;
   private String ZZ185WWPNotificationDefinitionTitle ;
   private String ZZ186WWPNotificationDefinitionShort ;
   private String ZZ187WWPNotificationDefinitionLongD ;
   private String ZZ188WWPNotificationDefinitionLink ;
   private String ZZ189WWPNotificationDefinitionSecFu ;
   private String ZZ150WWPEntityName ;
   private HTMLChoice cmbWWPNotificationDefinitionAppli ;
   private ICheckbox chkWWPNotificationDefinitionAllow ;
   private ICheckbox chkWWPNotificationDefinitionIsAut ;
   private IDataStoreProvider pr_default ;
   private long[] T000Y5_A35WWPNotificationDefinitionId ;
   private String[] T000Y5_A181WWPNotificationDefinitionName ;
   private byte[] T000Y5_A155WWPNotificationDefinitionAppli ;
   private boolean[] T000Y5_A156WWPNotificationDefinitionAllow ;
   private String[] T000Y5_A154WWPNotificationDefinitionDescr ;
   private String[] T000Y5_A184WWPNotificationDefinitionIcon ;
   private String[] T000Y5_A185WWPNotificationDefinitionTitle ;
   private String[] T000Y5_A186WWPNotificationDefinitionShort ;
   private String[] T000Y5_A187WWPNotificationDefinitionLongD ;
   private String[] T000Y5_A188WWPNotificationDefinitionLink ;
   private String[] T000Y5_A150WWPEntityName ;
   private String[] T000Y5_A189WWPNotificationDefinitionSecFu ;
   private long[] T000Y5_A33WWPEntityId ;
   private String[] T000Y4_A150WWPEntityName ;
   private String[] T000Y6_A150WWPEntityName ;
   private long[] T000Y7_A35WWPNotificationDefinitionId ;
   private long[] T000Y3_A35WWPNotificationDefinitionId ;
   private String[] T000Y3_A181WWPNotificationDefinitionName ;
   private byte[] T000Y3_A155WWPNotificationDefinitionAppli ;
   private boolean[] T000Y3_A156WWPNotificationDefinitionAllow ;
   private String[] T000Y3_A154WWPNotificationDefinitionDescr ;
   private String[] T000Y3_A184WWPNotificationDefinitionIcon ;
   private String[] T000Y3_A185WWPNotificationDefinitionTitle ;
   private String[] T000Y3_A186WWPNotificationDefinitionShort ;
   private String[] T000Y3_A187WWPNotificationDefinitionLongD ;
   private String[] T000Y3_A188WWPNotificationDefinitionLink ;
   private String[] T000Y3_A189WWPNotificationDefinitionSecFu ;
   private long[] T000Y3_A33WWPEntityId ;
   private long[] T000Y8_A35WWPNotificationDefinitionId ;
   private long[] T000Y9_A35WWPNotificationDefinitionId ;
   private long[] T000Y2_A35WWPNotificationDefinitionId ;
   private String[] T000Y2_A181WWPNotificationDefinitionName ;
   private byte[] T000Y2_A155WWPNotificationDefinitionAppli ;
   private boolean[] T000Y2_A156WWPNotificationDefinitionAllow ;
   private String[] T000Y2_A154WWPNotificationDefinitionDescr ;
   private String[] T000Y2_A184WWPNotificationDefinitionIcon ;
   private String[] T000Y2_A185WWPNotificationDefinitionTitle ;
   private String[] T000Y2_A186WWPNotificationDefinitionShort ;
   private String[] T000Y2_A187WWPNotificationDefinitionLongD ;
   private String[] T000Y2_A188WWPNotificationDefinitionLink ;
   private String[] T000Y2_A189WWPNotificationDefinitionSecFu ;
   private long[] T000Y2_A33WWPEntityId ;
   private long[] T000Y10_A35WWPNotificationDefinitionId ;
   private String[] T000Y13_A150WWPEntityName ;
   private long[] T000Y14_A37WWPNotificationId ;
   private long[] T000Y15_A34WWPSubscriptionId ;
   private long[] T000Y16_A35WWPNotificationDefinitionId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_notificationdefinition__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_notificationdefinition__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Y2", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId] FROM [WWP_NotificationDefinition] WITH (UPDLOCK) WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y3", "SELECT [WWPNotificationDefinitionId], [WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y4", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y5", "SELECT TM1.[WWPNotificationDefinitionId], TM1.[WWPNotificationDefinitionName], TM1.[WWPNotificationDefinitionAppli], TM1.[WWPNotificationDefinitionAllow], TM1.[WWPNotificationDefinitionDescr], TM1.[WWPNotificationDefinitionIcon], TM1.[WWPNotificationDefinitionTitle], TM1.[WWPNotificationDefinitionShort], TM1.[WWPNotificationDefinitionLongD], TM1.[WWPNotificationDefinitionLink], T2.[WWPEntityName], TM1.[WWPNotificationDefinitionSecFu], TM1.[WWPEntityId] FROM ([WWP_NotificationDefinition] TM1 INNER JOIN [WWP_Entity] T2 ON T2.[WWPEntityId] = TM1.[WWPEntityId]) WHERE TM1.[WWPNotificationDefinitionId] = ? ORDER BY TM1.[WWPNotificationDefinitionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y6", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y7", "SELECT [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] WHERE [WWPNotificationDefinitionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y8", "SELECT TOP 1 [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] WHERE ( [WWPNotificationDefinitionId] > ?) ORDER BY [WWPNotificationDefinitionId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y9", "SELECT TOP 1 [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] WHERE ( [WWPNotificationDefinitionId] < ?) ORDER BY [WWPNotificationDefinitionId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y10", "INSERT INTO [WWP_NotificationDefinition]([WWPNotificationDefinitionName], [WWPNotificationDefinitionAppli], [WWPNotificationDefinitionAllow], [WWPNotificationDefinitionDescr], [WWPNotificationDefinitionIcon], [WWPNotificationDefinitionTitle], [WWPNotificationDefinitionShort], [WWPNotificationDefinitionLongD], [WWPNotificationDefinitionLink], [WWPNotificationDefinitionSecFu], [WWPEntityId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000Y11", "UPDATE [WWP_NotificationDefinition] SET [WWPNotificationDefinitionName]=?, [WWPNotificationDefinitionAppli]=?, [WWPNotificationDefinitionAllow]=?, [WWPNotificationDefinitionDescr]=?, [WWPNotificationDefinitionIcon]=?, [WWPNotificationDefinitionTitle]=?, [WWPNotificationDefinitionShort]=?, [WWPNotificationDefinitionLongD]=?, [WWPNotificationDefinitionLink]=?, [WWPNotificationDefinitionSecFu]=?, [WWPEntityId]=?  WHERE [WWPNotificationDefinitionId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Y12", "DELETE FROM [WWP_NotificationDefinition]  WHERE [WWPNotificationDefinitionId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000Y13", "SELECT [WWPEntityName] FROM [WWP_Entity] WHERE [WWPEntityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y14", "SELECT TOP 1 [WWPNotificationId] FROM [WWP_Notification] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y15", "SELECT TOP 1 [WWPSubscriptionId] FROM [WWP_Subscription] WHERE [WWPNotificationDefinitionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y16", "SELECT [WWPNotificationDefinitionId] FROM [WWP_NotificationDefinition] ORDER BY [WWPNotificationDefinitionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((long[]) buf[11])[0] = rslt.getLong(12);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((long[]) buf[12])[0] = rslt.getLong(13);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
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
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 200, false);
               stmt.setVarchar(7, (String)parms[6], 200, false);
               stmt.setVarchar(8, (String)parms[7], 1000, false);
               stmt.setVarchar(9, (String)parms[8], 1000, false);
               stmt.setVarchar(10, (String)parms[9], 200, false);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setVarchar(6, (String)parms[5], 200, false);
               stmt.setVarchar(7, (String)parms[6], 200, false);
               stmt.setVarchar(8, (String)parms[7], 1000, false);
               stmt.setVarchar(9, (String)parms[8], 1000, false);
               stmt.setVarchar(10, (String)parms[9], 200, false);
               stmt.setLong(11, ((Number) parms[10]).longValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

