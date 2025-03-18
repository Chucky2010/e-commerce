package com.mujermorena.wwpbaseobjects.notifications.web ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_webclient_impl extends GXDataArea
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_Web Client", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPWebClientId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_webclient_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_webclient_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_webclient_impl.class ));
   }

   public wwp_webclient_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbWWPWebClientBrowserId = new HTMLChoice();
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
      if ( cmbWWPWebClientBrowserId.getItemCount() > 0 )
      {
         A171WWPWebClientBrowserId = (short)(GXutil.lval( cmbWWPWebClientBrowserId.getValidValue(GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPWebClientBrowserId.setValue( GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebClientBrowserId.getInternalname(), "Values", cmbWWPWebClientBrowserId.ToJavascriptSource(), true);
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "WWP_Web Client", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebClientId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebClientId_Internalname, httpContext.getMessage( "Client Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebClientId_Internalname, GXutil.rtrim( A39WWPWebClientId), GXutil.rtrim( localUtil.format( A39WWPWebClientId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebClientId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebClientId_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbWWPWebClientBrowserId.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbWWPWebClientBrowserId.getInternalname(), httpContext.getMessage( "Browser Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbWWPWebClientBrowserId, cmbWWPWebClientBrowserId.getInternalname(), GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0)), 1, cmbWWPWebClientBrowserId.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbWWPWebClientBrowserId.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "", true, (byte)(0), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      cmbWWPWebClientBrowserId.setValue( GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebClientBrowserId.getInternalname(), "Values", cmbWWPWebClientBrowserId.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebClientBrowserVersion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebClientBrowserVersion_Internalname, httpContext.getMessage( "Browser Version", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPWebClientBrowserVersion_Internalname, A172WWPWebClientBrowserVersion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", (short)(0), 1, edtWWPWebClientBrowserVersion_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebClientFirstRegistered_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebClientFirstRegistered_Internalname, httpContext.getMessage( "First Registered", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPWebClientFirstRegistered_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebClientFirstRegistered_Internalname, localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A173WWPWebClientFirstRegistered, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebClientFirstRegistered_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebClientFirstRegistered_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPWebClientFirstRegistered_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPWebClientFirstRegistered_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPWebClientLastRegistered_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPWebClientLastRegistered_Internalname, httpContext.getMessage( "Last Registered", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPWebClientLastRegistered_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPWebClientLastRegistered_Internalname, localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A174WWPWebClientLastRegistered, "99/99/9999 99:99:99.999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',12,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPWebClientLastRegistered_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPWebClientLastRegistered_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPWebClientLastRegistered_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPWebClientLastRegistered_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedId_Internalname, httpContext.getMessage( "User Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedId_Internalname, GXutil.rtrim( A32WWPUserExtendedId), GXutil.rtrim( localUtil.format( A32WWPUserExtendedId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedId_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_GAMGUID", "left", true, "", "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Web\\WWP_WebClient.htm");
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
         Z39WWPWebClientId = httpContext.cgiGet( "Z39WWPWebClientId") ;
         Z171WWPWebClientBrowserId = (short)(localUtil.ctol( httpContext.cgiGet( "Z171WWPWebClientBrowserId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Z173WWPWebClientFirstRegistered = localUtil.ctot( httpContext.cgiGet( "Z173WWPWebClientFirstRegistered"), 0) ;
         Z174WWPWebClientLastRegistered = localUtil.ctot( httpContext.cgiGet( "Z174WWPWebClientLastRegistered"), 0) ;
         Z32WWPUserExtendedId = httpContext.cgiGet( "Z32WWPUserExtendedId") ;
         n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         A39WWPWebClientId = httpContext.cgiGet( edtWWPWebClientId_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
         cmbWWPWebClientBrowserId.setValue( httpContext.cgiGet( cmbWWPWebClientBrowserId.getInternalname()) );
         A171WWPWebClientBrowserId = (short)(GXutil.lval( httpContext.cgiGet( cmbWWPWebClientBrowserId.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0));
         A172WWPWebClientBrowserVersion = httpContext.cgiGet( edtWWPWebClientBrowserVersion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A172WWPWebClientBrowserVersion", A172WWPWebClientBrowserVersion);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPWebClientFirstRegistered_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPWEBCLIENTFIRSTREGISTERED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebClientFirstRegistered_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A173WWPWebClientFirstRegistered = localUtil.ctot( httpContext.cgiGet( edtWWPWebClientFirstRegistered_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPWebClientLastRegistered_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPWEBCLIENTLASTREGISTERED");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPWebClientLastRegistered_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A174WWPWebClientLastRegistered = localUtil.ctot( httpContext.cgiGet( edtWWPWebClientLastRegistered_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         A32WWPUserExtendedId = httpContext.cgiGet( edtWWPUserExtendedId_Internalname) ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
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
            A39WWPWebClientId = httpContext.GetPar( "WWPWebClientId") ;
            httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
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
            initAll0X35( ) ;
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
      disableAttributes0X35( ) ;
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

   public void resetCaption0X0( )
   {
   }

   public void zm0X35( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z171WWPWebClientBrowserId = T000X3_A171WWPWebClientBrowserId[0] ;
            Z173WWPWebClientFirstRegistered = T000X3_A173WWPWebClientFirstRegistered[0] ;
            Z174WWPWebClientLastRegistered = T000X3_A174WWPWebClientLastRegistered[0] ;
            Z32WWPUserExtendedId = T000X3_A32WWPUserExtendedId[0] ;
         }
         else
         {
            Z171WWPWebClientBrowserId = A171WWPWebClientBrowserId ;
            Z173WWPWebClientFirstRegistered = A173WWPWebClientFirstRegistered ;
            Z174WWPWebClientLastRegistered = A174WWPWebClientLastRegistered ;
            Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         }
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A173WWPWebClientFirstRegistered) && ( Gx_BScreen == 0 ) )
      {
         A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      }
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A174WWPWebClientLastRegistered) && ( Gx_BScreen == 0 ) )
      {
         A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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

   public void load0X35( )
   {
      /* Using cursor T000X5 */
      pr_default.execute(3, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A171WWPWebClientBrowserId = T000X5_A171WWPWebClientBrowserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0));
         A172WWPWebClientBrowserVersion = T000X5_A172WWPWebClientBrowserVersion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A172WWPWebClientBrowserVersion", A172WWPWebClientBrowserVersion);
         A173WWPWebClientFirstRegistered = T000X5_A173WWPWebClientFirstRegistered[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A174WWPWebClientLastRegistered = T000X5_A174WWPWebClientLastRegistered[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A32WWPUserExtendedId = T000X5_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000X5_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
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
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      if ( ! ( ( A171WWPWebClientBrowserId == 0 ) || ( A171WWPWebClientBrowserId == 1 ) || ( A171WWPWebClientBrowserId == 2 ) || ( A171WWPWebClientBrowserId == 3 ) || ( A171WWPWebClientBrowserId == 5 ) || ( A171WWPWebClientBrowserId == 6 ) || ( A171WWPWebClientBrowserId == 7 ) || ( A171WWPWebClientBrowserId == 8 ) || ( A171WWPWebClientBrowserId == 9 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Client Browser Id", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBCLIENTBROWSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A173WWPWebClientFirstRegistered) || (( A173WWPWebClientFirstRegistered.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A173WWPWebClientFirstRegistered, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Client First Registered", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBCLIENTFIRSTREGISTERED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebClientFirstRegistered_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A174WWPWebClientLastRegistered) || (( A174WWPWebClientLastRegistered.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A174WWPWebClientLastRegistered, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Web Client Last Registered", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPWEBCLIENTLASTREGISTERED");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebClientLastRegistered_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000X4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0X35( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_7( String A32WWPUserExtendedId )
   {
      /* Using cursor T000X6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey0X35( )
   {
      /* Using cursor T000X7 */
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
      /* Using cursor T000X3 */
      pr_default.execute(1, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0X35( 6) ;
         RcdFound35 = (short)(1) ;
         A39WWPWebClientId = T000X3_A39WWPWebClientId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
         A171WWPWebClientBrowserId = T000X3_A171WWPWebClientBrowserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0));
         A172WWPWebClientBrowserVersion = T000X3_A172WWPWebClientBrowserVersion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A172WWPWebClientBrowserVersion", A172WWPWebClientBrowserVersion);
         A173WWPWebClientFirstRegistered = T000X3_A173WWPWebClientFirstRegistered[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A174WWPWebClientLastRegistered = T000X3_A174WWPWebClientLastRegistered[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A32WWPUserExtendedId = T000X3_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000X3_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         Z39WWPWebClientId = A39WWPWebClientId ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0X35( ) ;
         if ( AnyError == 1 )
         {
            RcdFound35 = (short)(0) ;
            initializeNonKey0X35( ) ;
         }
         Gx_mode = sMode35 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound35 = (short)(0) ;
         initializeNonKey0X35( ) ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode35 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0X35( ) ;
      if ( RcdFound35 == 0 )
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
      RcdFound35 = (short)(0) ;
      /* Using cursor T000X8 */
      pr_default.execute(6, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( GXutil.strcmp(T000X8_A39WWPWebClientId[0], A39WWPWebClientId) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( GXutil.strcmp(T000X8_A39WWPWebClientId[0], A39WWPWebClientId) > 0 ) ) )
         {
            A39WWPWebClientId = T000X8_A39WWPWebClientId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
            RcdFound35 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound35 = (short)(0) ;
      /* Using cursor T000X9 */
      pr_default.execute(7, new Object[] {A39WWPWebClientId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( GXutil.strcmp(T000X9_A39WWPWebClientId[0], A39WWPWebClientId) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( GXutil.strcmp(T000X9_A39WWPWebClientId[0], A39WWPWebClientId) < 0 ) ) )
         {
            A39WWPWebClientId = T000X9_A39WWPWebClientId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
            RcdFound35 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0X35( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPWebClientId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0X35( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound35 == 1 )
         {
            if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
            {
               A39WWPWebClientId = Z39WWPWebClientId ;
               httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPWEBCLIENTID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPWebClientId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPWebClientId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0X35( ) ;
               GX_FocusControl = edtWWPWebClientId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPWebClientId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0X35( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPWEBCLIENTID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPWebClientId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPWebClientId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0X35( ) ;
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
      if ( GXutil.strcmp(A39WWPWebClientId, Z39WWPWebClientId) != 0 )
      {
         A39WWPWebClientId = Z39WWPWebClientId ;
         httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPWEBCLIENTID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebClientId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPWebClientId_Internalname ;
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
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPWEBCLIENTID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPWebClientId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0X35( ) ;
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0X35( ) ;
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
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
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
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
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
      scanStart0X35( ) ;
      if ( RcdFound35 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound35 != 0 )
         {
            scanNext0X35( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0X35( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0X35( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000X2 */
         pr_default.execute(0, new Object[] {A39WWPWebClientId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_WebClient"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z171WWPWebClientBrowserId != T000X2_A171WWPWebClientBrowserId[0] ) || !( GXutil.dateCompare(Z173WWPWebClientFirstRegistered, T000X2_A173WWPWebClientFirstRegistered[0]) ) || !( GXutil.dateCompare(Z174WWPWebClientLastRegistered, T000X2_A174WWPWebClientLastRegistered[0]) ) || ( GXutil.strcmp(Z32WWPUserExtendedId, T000X2_A32WWPUserExtendedId[0]) != 0 ) )
         {
            if ( Z171WWPWebClientBrowserId != T000X2_A171WWPWebClientBrowserId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webclient:[seudo value changed for attri]"+"WWPWebClientBrowserId");
               GXutil.writeLogRaw("Old: ",Z171WWPWebClientBrowserId);
               GXutil.writeLogRaw("Current: ",T000X2_A171WWPWebClientBrowserId[0]);
            }
            if ( !( GXutil.dateCompare(Z173WWPWebClientFirstRegistered, T000X2_A173WWPWebClientFirstRegistered[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webclient:[seudo value changed for attri]"+"WWPWebClientFirstRegistered");
               GXutil.writeLogRaw("Old: ",Z173WWPWebClientFirstRegistered);
               GXutil.writeLogRaw("Current: ",T000X2_A173WWPWebClientFirstRegistered[0]);
            }
            if ( !( GXutil.dateCompare(Z174WWPWebClientLastRegistered, T000X2_A174WWPWebClientLastRegistered[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webclient:[seudo value changed for attri]"+"WWPWebClientLastRegistered");
               GXutil.writeLogRaw("Old: ",Z174WWPWebClientLastRegistered);
               GXutil.writeLogRaw("Current: ",T000X2_A174WWPWebClientLastRegistered[0]);
            }
            if ( GXutil.strcmp(Z32WWPUserExtendedId, T000X2_A32WWPUserExtendedId[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.notifications.web.wwp_webclient:[seudo value changed for attri]"+"WWPUserExtendedId");
               GXutil.writeLogRaw("Old: ",Z32WWPUserExtendedId);
               GXutil.writeLogRaw("Current: ",T000X2_A32WWPUserExtendedId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_WebClient"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0X35( )
   {
      if ( ! IsAuthorized("webclient_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
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
                  /* Using cursor T000X10 */
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
                        resetCaption0X0( ) ;
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
      if ( ! IsAuthorized("webclient_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
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
                  /* Using cursor T000X11 */
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
                        resetCaption0X0( ) ;
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
      if ( ! IsAuthorized("webclient_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
               /* Using cursor T000X12 */
               pr_default.execute(10, new Object[] {A39WWPWebClientId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_WebClient");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound35 == 0 )
                     {
                        initAll0X35( ) ;
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
                     resetCaption0X0( ) ;
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
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0X35( ) ;
      Gx_mode = sMode35 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0X35( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_webclient");
         if ( AnyError == 0 )
         {
            confirmValues0X0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.notifications.web.wwp_webclient");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0X35( )
   {
      /* Using cursor T000X13 */
      pr_default.execute(11);
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A39WWPWebClientId = T000X13_A39WWPWebClientId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0X35( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A39WWPWebClientId = T000X13_A39WWPWebClientId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
      }
   }

   public void scanEnd0X35( )
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
      edtWWPWebClientId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebClientId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebClientId_Enabled), 5, 0), true);
      cmbWWPWebClientBrowserId.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebClientBrowserId.getInternalname(), "Enabled", GXutil.ltrimstr( cmbWWPWebClientBrowserId.getEnabled(), 5, 0), true);
      edtWWPWebClientBrowserVersion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebClientBrowserVersion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebClientBrowserVersion_Enabled), 5, 0), true);
      edtWWPWebClientFirstRegistered_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebClientFirstRegistered_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebClientFirstRegistered_Enabled), 5, 0), true);
      edtWWPWebClientLastRegistered_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPWebClientLastRegistered_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPWebClientLastRegistered_Enabled), 5, 0), true);
      edtWWPUserExtendedId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedId_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0X35( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0X0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z39WWPWebClientId", GXutil.rtrim( Z39WWPWebClientId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z171WWPWebClientBrowserId", GXutil.ltrim( localUtil.ntoc( Z171WWPWebClientBrowserId, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z173WWPWebClientFirstRegistered", localUtil.ttoc( Z173WWPWebClientFirstRegistered, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z174WWPWebClientLastRegistered", localUtil.ttoc( Z174WWPWebClientLastRegistered, 10, 12, 0, 0, "/", ":", " "));
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
      return formatLink("com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Web.WWP_WebClient" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_Web Client", "") ;
   }

   public void initializeNonKey0X35( )
   {
      A171WWPWebClientBrowserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0));
      A172WWPWebClientBrowserVersion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A172WWPWebClientBrowserVersion", A172WWPWebClientBrowserVersion);
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      n32WWPUserExtendedId = ((GXutil.strcmp("", A32WWPUserExtendedId)==0) ? true : false) ;
      A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      Z171WWPWebClientBrowserId = (short)(0) ;
      Z173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z32WWPUserExtendedId = "" ;
   }

   public void initAll0X35( )
   {
      A39WWPWebClientId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A39WWPWebClientId", A39WWPWebClientId);
      initializeNonKey0X35( ) ;
   }

   public void standaloneModalInsert( )
   {
      A173WWPWebClientFirstRegistered = i173WWPWebClientFirstRegistered ;
      httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      A174WWPWebClientLastRegistered = i174WWPWebClientLastRegistered ;
      httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111101876", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/notifications/web/wwp_webclient.js", "?202412111101876", false, true);
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
      edtWWPWebClientId_Internalname = "WWPWEBCLIENTID" ;
      cmbWWPWebClientBrowserId.setInternalname( "WWPWEBCLIENTBROWSERID" );
      edtWWPWebClientBrowserVersion_Internalname = "WWPWEBCLIENTBROWSERVERSION" ;
      edtWWPWebClientFirstRegistered_Internalname = "WWPWEBCLIENTFIRSTREGISTERED" ;
      edtWWPWebClientLastRegistered_Internalname = "WWPWEBCLIENTLASTREGISTERED" ;
      edtWWPUserExtendedId_Internalname = "WWPUSEREXTENDEDID" ;
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
      Form.setCaption( httpContext.getMessage( "WWP_Web Client", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtWWPUserExtendedId_Jsonclick = "" ;
      edtWWPUserExtendedId_Enabled = 1 ;
      edtWWPWebClientLastRegistered_Jsonclick = "" ;
      edtWWPWebClientLastRegistered_Enabled = 1 ;
      edtWWPWebClientFirstRegistered_Jsonclick = "" ;
      edtWWPWebClientFirstRegistered_Enabled = 1 ;
      edtWWPWebClientBrowserVersion_Enabled = 1 ;
      cmbWWPWebClientBrowserId.setJsonclick( "" );
      cmbWWPWebClientBrowserId.setEnabled( 1 );
      edtWWPWebClientId_Jsonclick = "" ;
      edtWWPWebClientId_Enabled = 1 ;
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
      cmbWWPWebClientBrowserId.setName( "WWPWEBCLIENTBROWSERID" );
      cmbWWPWebClientBrowserId.setWebtags( "" );
      cmbWWPWebClientBrowserId.addItem("0", httpContext.getMessage( "Unknown Agent", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("1", httpContext.getMessage( "Internet Explorer", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("2", httpContext.getMessage( "Netscape", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("3", httpContext.getMessage( "Opera", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("5", httpContext.getMessage( "Pocket IE", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("6", httpContext.getMessage( "Firefox", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("7", httpContext.getMessage( "Chrome", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("8", httpContext.getMessage( "Safari", ""), (short)(0));
      cmbWWPWebClientBrowserId.addItem("9", httpContext.getMessage( "Edge", ""), (short)(0));
      if ( cmbWWPWebClientBrowserId.getItemCount() > 0 )
      {
         A171WWPWebClientBrowserId = (short)(GXutil.lval( cmbWWPWebClientBrowserId.getValidValue(GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0));
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = cmbWWPWebClientBrowserId.getInternalname() ;
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

   public void valid_Wwpwebclientid( )
   {
      A171WWPWebClientBrowserId = (short)(GXutil.lval( cmbWWPWebClientBrowserId.getValue())) ;
      cmbWWPWebClientBrowserId.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0) );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbWWPWebClientBrowserId.getItemCount() > 0 )
      {
         A171WWPWebClientBrowserId = (short)(GXutil.lval( cmbWWPWebClientBrowserId.getValidValue(GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0))))) ;
         cmbWWPWebClientBrowserId.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A171WWPWebClientBrowserId), 4, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbWWPWebClientBrowserId.setValue( GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A171WWPWebClientBrowserId", GXutil.ltrim( localUtil.ntoc( A171WWPWebClientBrowserId, (byte)(4), (byte)(0), ".", "")));
      cmbWWPWebClientBrowserId.setValue( GXutil.trim( GXutil.str( A171WWPWebClientBrowserId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbWWPWebClientBrowserId.getInternalname(), "Values", cmbWWPWebClientBrowserId.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A172WWPWebClientBrowserVersion", A172WWPWebClientBrowserVersion);
      httpContext.ajax_rsp_assign_attri("", false, "A173WWPWebClientFirstRegistered", localUtil.ttoc( A173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A174WWPWebClientLastRegistered", localUtil.ttoc( A174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", GXutil.rtrim( A32WWPUserExtendedId));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z39WWPWebClientId", GXutil.rtrim( Z39WWPWebClientId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z171WWPWebClientBrowserId", GXutil.ltrim( localUtil.ntoc( Z171WWPWebClientBrowserId, (byte)(4), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z172WWPWebClientBrowserVersion", Z172WWPWebClientBrowserVersion);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z173WWPWebClientFirstRegistered", localUtil.ttoc( Z173WWPWebClientFirstRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z174WWPWebClientLastRegistered", localUtil.ttoc( Z174WWPWebClientLastRegistered, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Wwpuserextendedid( )
   {
      n32WWPUserExtendedId = false ;
      /* Using cursor T000X14 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A32WWPUserExtendedId)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "WWP_UserExtended", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "WWPUSEREXTENDEDID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         }
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
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
      setEventMetadata("VALID_WWPWEBCLIENTID","{handler:'valid_Wwpwebclientid',iparms:[{av:'cmbWWPWebClientBrowserId'},{av:'A171WWPWebClientBrowserId',fld:'WWPWEBCLIENTBROWSERID',pic:'ZZZ9'},{av:'A39WWPWebClientId',fld:'WWPWEBCLIENTID',pic:''},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A173WWPWebClientFirstRegistered',fld:'WWPWEBCLIENTFIRSTREGISTERED',pic:'99/99/9999 99:99:99.999'},{av:'A174WWPWebClientLastRegistered',fld:'WWPWEBCLIENTLASTREGISTERED',pic:'99/99/9999 99:99:99.999'}]");
      setEventMetadata("VALID_WWPWEBCLIENTID",",oparms:[{av:'cmbWWPWebClientBrowserId'},{av:'A171WWPWebClientBrowserId',fld:'WWPWEBCLIENTBROWSERID',pic:'ZZZ9'},{av:'A172WWPWebClientBrowserVersion',fld:'WWPWEBCLIENTBROWSERVERSION',pic:''},{av:'A173WWPWebClientFirstRegistered',fld:'WWPWEBCLIENTFIRSTREGISTERED',pic:'99/99/9999 99:99:99.999'},{av:'A174WWPWebClientLastRegistered',fld:'WWPWEBCLIENTLASTREGISTERED',pic:'99/99/9999 99:99:99.999'},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z39WWPWebClientId'},{av:'Z171WWPWebClientBrowserId'},{av:'Z172WWPWebClientBrowserVersion'},{av:'Z173WWPWebClientFirstRegistered'},{av:'Z174WWPWebClientLastRegistered'},{av:'Z32WWPUserExtendedId'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_WWPWEBCLIENTBROWSERID","{handler:'valid_Wwpwebclientbrowserid',iparms:[]");
      setEventMetadata("VALID_WWPWEBCLIENTBROWSERID",",oparms:[]}");
      setEventMetadata("VALID_WWPWEBCLIENTFIRSTREGISTERED","{handler:'valid_Wwpwebclientfirstregistered',iparms:[]");
      setEventMetadata("VALID_WWPWEBCLIENTFIRSTREGISTERED",",oparms:[]}");
      setEventMetadata("VALID_WWPWEBCLIENTLASTREGISTERED","{handler:'valid_Wwpwebclientlastregistered',iparms:[]");
      setEventMetadata("VALID_WWPWEBCLIENTLASTREGISTERED",",oparms:[]}");
      setEventMetadata("VALID_WWPUSEREXTENDEDID","{handler:'valid_Wwpuserextendedid',iparms:[{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''}]");
      setEventMetadata("VALID_WWPUSEREXTENDEDID",",oparms:[]}");
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
      return "webclient_Execute";
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z39WWPWebClientId = "" ;
      Z173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      Z174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
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
      A39WWPWebClientId = "" ;
      A172WWPWebClientBrowserVersion = "" ;
      A173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      A174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
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
      Z172WWPWebClientBrowserVersion = "" ;
      T000X5_A39WWPWebClientId = new String[] {""} ;
      T000X5_A171WWPWebClientBrowserId = new short[1] ;
      T000X5_A172WWPWebClientBrowserVersion = new String[] {""} ;
      T000X5_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      T000X5_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      T000X5_A32WWPUserExtendedId = new String[] {""} ;
      T000X5_n32WWPUserExtendedId = new boolean[] {false} ;
      T000X4_A32WWPUserExtendedId = new String[] {""} ;
      T000X4_n32WWPUserExtendedId = new boolean[] {false} ;
      T000X6_A32WWPUserExtendedId = new String[] {""} ;
      T000X6_n32WWPUserExtendedId = new boolean[] {false} ;
      T000X7_A39WWPWebClientId = new String[] {""} ;
      T000X3_A39WWPWebClientId = new String[] {""} ;
      T000X3_A171WWPWebClientBrowserId = new short[1] ;
      T000X3_A172WWPWebClientBrowserVersion = new String[] {""} ;
      T000X3_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      T000X3_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      T000X3_A32WWPUserExtendedId = new String[] {""} ;
      T000X3_n32WWPUserExtendedId = new boolean[] {false} ;
      sMode35 = "" ;
      T000X8_A39WWPWebClientId = new String[] {""} ;
      T000X9_A39WWPWebClientId = new String[] {""} ;
      T000X2_A39WWPWebClientId = new String[] {""} ;
      T000X2_A171WWPWebClientBrowserId = new short[1] ;
      T000X2_A172WWPWebClientBrowserVersion = new String[] {""} ;
      T000X2_A173WWPWebClientFirstRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      T000X2_A174WWPWebClientLastRegistered = new java.util.Date[] {GXutil.nullDate()} ;
      T000X2_A32WWPUserExtendedId = new String[] {""} ;
      T000X2_n32WWPUserExtendedId = new boolean[] {false} ;
      T000X13_A39WWPWebClientId = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      i174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      ZZ39WWPWebClientId = "" ;
      ZZ172WWPWebClientBrowserVersion = "" ;
      ZZ173WWPWebClientFirstRegistered = GXutil.resetTime( GXutil.nullDate() );
      ZZ174WWPWebClientLastRegistered = GXutil.resetTime( GXutil.nullDate() );
      ZZ32WWPUserExtendedId = "" ;
      T000X14_A32WWPUserExtendedId = new String[] {""} ;
      T000X14_n32WWPUserExtendedId = new boolean[] {false} ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.web.wwp_webclient__default(),
         new Object[] {
             new Object[] {
            T000X2_A39WWPWebClientId, T000X2_A171WWPWebClientBrowserId, T000X2_A172WWPWebClientBrowserVersion, T000X2_A173WWPWebClientFirstRegistered, T000X2_A174WWPWebClientLastRegistered, T000X2_A32WWPUserExtendedId, T000X2_n32WWPUserExtendedId
            }
            , new Object[] {
            T000X3_A39WWPWebClientId, T000X3_A171WWPWebClientBrowserId, T000X3_A172WWPWebClientBrowserVersion, T000X3_A173WWPWebClientFirstRegistered, T000X3_A174WWPWebClientLastRegistered, T000X3_A32WWPUserExtendedId, T000X3_n32WWPUserExtendedId
            }
            , new Object[] {
            T000X4_A32WWPUserExtendedId
            }
            , new Object[] {
            T000X5_A39WWPWebClientId, T000X5_A171WWPWebClientBrowserId, T000X5_A172WWPWebClientBrowserVersion, T000X5_A173WWPWebClientFirstRegistered, T000X5_A174WWPWebClientLastRegistered, T000X5_A32WWPUserExtendedId, T000X5_n32WWPUserExtendedId
            }
            , new Object[] {
            T000X6_A32WWPUserExtendedId
            }
            , new Object[] {
            T000X7_A39WWPWebClientId
            }
            , new Object[] {
            T000X8_A39WWPWebClientId
            }
            , new Object[] {
            T000X9_A39WWPWebClientId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000X13_A39WWPWebClientId
            }
            , new Object[] {
            T000X14_A32WWPUserExtendedId
            }
         }
      );
      Z174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i174WWPWebClientLastRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      Z173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      A173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      i173WWPWebClientFirstRegistered = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z171WWPWebClientBrowserId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A171WWPWebClientBrowserId ;
   private short RcdFound35 ;
   private short nIsDirty_35 ;
   private short ZZ171WWPWebClientBrowserId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPWebClientId_Enabled ;
   private int edtWWPWebClientBrowserVersion_Enabled ;
   private int edtWWPWebClientFirstRegistered_Enabled ;
   private int edtWWPWebClientLastRegistered_Enabled ;
   private int edtWWPUserExtendedId_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String Z39WWPWebClientId ;
   private String Z32WWPUserExtendedId ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A32WWPUserExtendedId ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPWebClientId_Internalname ;
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
   private String A39WWPWebClientId ;
   private String edtWWPWebClientId_Jsonclick ;
   private String edtWWPWebClientBrowserVersion_Internalname ;
   private String edtWWPWebClientFirstRegistered_Internalname ;
   private String edtWWPWebClientFirstRegistered_Jsonclick ;
   private String edtWWPWebClientLastRegistered_Internalname ;
   private String edtWWPWebClientLastRegistered_Jsonclick ;
   private String edtWWPUserExtendedId_Internalname ;
   private String edtWWPUserExtendedId_Jsonclick ;
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
   private String sMode35 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ39WWPWebClientId ;
   private String ZZ32WWPUserExtendedId ;
   private java.util.Date Z173WWPWebClientFirstRegistered ;
   private java.util.Date Z174WWPWebClientLastRegistered ;
   private java.util.Date A173WWPWebClientFirstRegistered ;
   private java.util.Date A174WWPWebClientLastRegistered ;
   private java.util.Date i173WWPWebClientFirstRegistered ;
   private java.util.Date i174WWPWebClientLastRegistered ;
   private java.util.Date ZZ173WWPWebClientFirstRegistered ;
   private java.util.Date ZZ174WWPWebClientLastRegistered ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n32WWPUserExtendedId ;
   private boolean wbErr ;
   private String A172WWPWebClientBrowserVersion ;
   private String Z172WWPWebClientBrowserVersion ;
   private String ZZ172WWPWebClientBrowserVersion ;
   private HTMLChoice cmbWWPWebClientBrowserId ;
   private IDataStoreProvider pr_default ;
   private String[] T000X5_A39WWPWebClientId ;
   private short[] T000X5_A171WWPWebClientBrowserId ;
   private String[] T000X5_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] T000X5_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] T000X5_A174WWPWebClientLastRegistered ;
   private String[] T000X5_A32WWPUserExtendedId ;
   private boolean[] T000X5_n32WWPUserExtendedId ;
   private String[] T000X4_A32WWPUserExtendedId ;
   private boolean[] T000X4_n32WWPUserExtendedId ;
   private String[] T000X6_A32WWPUserExtendedId ;
   private boolean[] T000X6_n32WWPUserExtendedId ;
   private String[] T000X7_A39WWPWebClientId ;
   private String[] T000X3_A39WWPWebClientId ;
   private short[] T000X3_A171WWPWebClientBrowserId ;
   private String[] T000X3_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] T000X3_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] T000X3_A174WWPWebClientLastRegistered ;
   private String[] T000X3_A32WWPUserExtendedId ;
   private boolean[] T000X3_n32WWPUserExtendedId ;
   private String[] T000X8_A39WWPWebClientId ;
   private String[] T000X9_A39WWPWebClientId ;
   private String[] T000X2_A39WWPWebClientId ;
   private short[] T000X2_A171WWPWebClientBrowserId ;
   private String[] T000X2_A172WWPWebClientBrowserVersion ;
   private java.util.Date[] T000X2_A173WWPWebClientFirstRegistered ;
   private java.util.Date[] T000X2_A174WWPWebClientLastRegistered ;
   private String[] T000X2_A32WWPUserExtendedId ;
   private boolean[] T000X2_n32WWPUserExtendedId ;
   private String[] T000X13_A39WWPWebClientId ;
   private String[] T000X14_A32WWPUserExtendedId ;
   private boolean[] T000X14_n32WWPUserExtendedId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_webclient__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_webclient__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000X2", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WITH (UPDLOCK) WHERE [WWPWebClientId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X3", "SELECT [WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId] FROM [WWP_WebClient] WHERE [WWPWebClientId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X4", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X5", "SELECT TM1.[WWPWebClientId], TM1.[WWPWebClientBrowserId], TM1.[WWPWebClientBrowserVersion], TM1.[WWPWebClientFirstRegistered], TM1.[WWPWebClientLastRegistered], TM1.[WWPUserExtendedId] FROM [WWP_WebClient] TM1 WHERE TM1.[WWPWebClientId] = ? ORDER BY TM1.[WWPWebClientId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X6", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X7", "SELECT [WWPWebClientId] FROM [WWP_WebClient] WHERE [WWPWebClientId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X8", "SELECT TOP 1 [WWPWebClientId] FROM [WWP_WebClient] WHERE ( [WWPWebClientId] > ?) ORDER BY [WWPWebClientId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000X9", "SELECT TOP 1 [WWPWebClientId] FROM [WWP_WebClient] WHERE ( [WWPWebClientId] < ?) ORDER BY [WWPWebClientId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000X10", "INSERT INTO [WWP_WebClient]([WWPWebClientId], [WWPWebClientBrowserId], [WWPWebClientBrowserVersion], [WWPWebClientFirstRegistered], [WWPWebClientLastRegistered], [WWPUserExtendedId]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000X11", "UPDATE [WWP_WebClient] SET [WWPWebClientBrowserId]=?, [WWPWebClientBrowserVersion]=?, [WWPWebClientFirstRegistered]=?, [WWPWebClientLastRegistered]=?, [WWPUserExtendedId]=?  WHERE [WWPWebClientId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000X12", "DELETE FROM [WWP_WebClient]  WHERE [WWPWebClientId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000X13", "SELECT [WWPWebClientId] FROM [WWP_WebClient] ORDER BY [WWPWebClientId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X14", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
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
            case 12 :
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

