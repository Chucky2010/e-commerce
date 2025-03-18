package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class numerador_impl extends GXDataArea
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
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7NumeradorID = httpContext.GetPar( "NumeradorID") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7NumeradorID", AV7NumeradorID);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUMERADORID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7NumeradorID, ""))));
         }
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Numerador", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtNumeradorID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public numerador_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public numerador_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( numerador_impl.class ));
   }

   public numerador_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Numerador", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Numerador.htm");
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
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtNumeradorID_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtNumeradorID_Internalname, httpContext.getMessage( "ID", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtNumeradorID_Internalname, GXutil.rtrim( A49NumeradorID), GXutil.rtrim( localUtil.format( A49NumeradorID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtNumeradorID_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtNumeradorID_Enabled, 1, "text", "", 56, "chr", 1, "row", 56, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Numerador.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtNumeradorUltimoNRO_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtNumeradorUltimoNRO_Internalname, httpContext.getMessage( "Ultimo NRO", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtNumeradorUltimoNRO_Internalname, GXutil.ltrim( localUtil.ntoc( A232NumeradorUltimoNRO, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtNumeradorUltimoNRO_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtNumeradorUltimoNRO_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtNumeradorUltimoNRO_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Numerador.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Numerador.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Numerador.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Numerador.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11152 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z49NumeradorID = httpContext.cgiGet( "Z49NumeradorID") ;
            Z232NumeradorUltimoNRO = localUtil.ctol( httpContext.cgiGet( "Z232NumeradorUltimoNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7NumeradorID = httpContext.cgiGet( "vNUMERADORID") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A49NumeradorID = httpContext.cgiGet( edtNumeradorID_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtNumeradorUltimoNRO_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtNumeradorUltimoNRO_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "NUMERADORULTIMONRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtNumeradorUltimoNRO_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A232NumeradorUltimoNRO = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A232NumeradorUltimoNRO", GXutil.ltrimstr( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), 10, 0));
            }
            else
            {
               A232NumeradorUltimoNRO = localUtil.ctol( httpContext.cgiGet( edtNumeradorUltimoNRO_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A232NumeradorUltimoNRO", GXutil.ltrimstr( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), 10, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Numerador");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A49NumeradorID, Z49NumeradorID) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("numerador:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A49NumeradorID = httpContext.GetPar( "NumeradorID") ;
               httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode46 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode46 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound46 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_150( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "NUMERADORID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtNumeradorID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11152 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12152 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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
         /* Execute user event: After Trn */
         e12152 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1546( ) ;
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
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1546( ) ;
      }
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

   public void confirm_150( )
   {
      beforeValidate1546( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1546( ) ;
         }
         else
         {
            checkExtendedTable1546( ) ;
            closeExtendedTableCursors1546( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption150( )
   {
   }

   public void e11152( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e12152( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.numeradorww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1546( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z232NumeradorUltimoNRO = T00153_A232NumeradorUltimoNRO[0] ;
         }
         else
         {
            Z232NumeradorUltimoNRO = A232NumeradorUltimoNRO ;
         }
      }
      if ( GX_JID == -4 )
      {
         Z49NumeradorID = A49NumeradorID ;
         Z232NumeradorUltimoNRO = A232NumeradorUltimoNRO ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV7NumeradorID)==0) )
      {
         A49NumeradorID = AV7NumeradorID ;
         httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
      }
      if ( ! (GXutil.strcmp("", AV7NumeradorID)==0) )
      {
         edtNumeradorID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtNumeradorID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtNumeradorID_Enabled), 5, 0), true);
      }
      else
      {
         edtNumeradorID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtNumeradorID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtNumeradorID_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV7NumeradorID)==0) )
      {
         edtNumeradorID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtNumeradorID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtNumeradorID_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
   }

   public void load1546( )
   {
      /* Using cursor T00154 */
      pr_default.execute(2, new Object[] {A49NumeradorID});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A232NumeradorUltimoNRO = T00154_A232NumeradorUltimoNRO[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A232NumeradorUltimoNRO", GXutil.ltrimstr( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), 10, 0));
         zm1546( -4) ;
      }
      pr_default.close(2);
      onLoadActions1546( ) ;
   }

   public void onLoadActions1546( )
   {
   }

   public void checkExtendedTable1546( )
   {
      nIsDirty_46 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors1546( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1546( )
   {
      /* Using cursor T00155 */
      pr_default.execute(3, new Object[] {A49NumeradorID});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound46 = (short)(1) ;
      }
      else
      {
         RcdFound46 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00153 */
      pr_default.execute(1, new Object[] {A49NumeradorID});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1546( 4) ;
         RcdFound46 = (short)(1) ;
         A49NumeradorID = T00153_A49NumeradorID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
         A232NumeradorUltimoNRO = T00153_A232NumeradorUltimoNRO[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A232NumeradorUltimoNRO", GXutil.ltrimstr( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), 10, 0));
         Z49NumeradorID = A49NumeradorID ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1546( ) ;
         if ( AnyError == 1 )
         {
            RcdFound46 = (short)(0) ;
            initializeNonKey1546( ) ;
         }
         Gx_mode = sMode46 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound46 = (short)(0) ;
         initializeNonKey1546( ) ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode46 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1546( ) ;
      if ( RcdFound46 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound46 = (short)(0) ;
      /* Using cursor T00156 */
      pr_default.execute(4, new Object[] {A49NumeradorID});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T00156_A49NumeradorID[0], A49NumeradorID) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T00156_A49NumeradorID[0], A49NumeradorID) > 0 ) ) )
         {
            A49NumeradorID = T00156_A49NumeradorID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
            RcdFound46 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound46 = (short)(0) ;
      /* Using cursor T00157 */
      pr_default.execute(5, new Object[] {A49NumeradorID});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T00157_A49NumeradorID[0], A49NumeradorID) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T00157_A49NumeradorID[0], A49NumeradorID) < 0 ) ) )
         {
            A49NumeradorID = T00157_A49NumeradorID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
            RcdFound46 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1546( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtNumeradorID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1546( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound46 == 1 )
         {
            if ( GXutil.strcmp(A49NumeradorID, Z49NumeradorID) != 0 )
            {
               A49NumeradorID = Z49NumeradorID ;
               httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "NUMERADORID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtNumeradorID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtNumeradorID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1546( ) ;
               GX_FocusControl = edtNumeradorID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A49NumeradorID, Z49NumeradorID) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtNumeradorID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1546( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "NUMERADORID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtNumeradorID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtNumeradorID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1546( ) ;
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
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( GXutil.strcmp(A49NumeradorID, Z49NumeradorID) != 0 )
      {
         A49NumeradorID = Z49NumeradorID ;
         httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "NUMERADORID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtNumeradorID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtNumeradorID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1546( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00152 */
         pr_default.execute(0, new Object[] {A49NumeradorID});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Numerador"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z232NumeradorUltimoNRO != T00152_A232NumeradorUltimoNRO[0] ) )
         {
            if ( Z232NumeradorUltimoNRO != T00152_A232NumeradorUltimoNRO[0] )
            {
               GXutil.writeLogln("numerador:[seudo value changed for attri]"+"NumeradorUltimoNRO");
               GXutil.writeLogRaw("Old: ",Z232NumeradorUltimoNRO);
               GXutil.writeLogRaw("Current: ",T00152_A232NumeradorUltimoNRO[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Numerador"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1546( )
   {
      if ( ! IsAuthorized("numerador_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1546( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1546( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1546( 0) ;
         checkOptimisticConcurrency1546( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1546( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1546( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00158 */
                  pr_default.execute(6, new Object[] {A49NumeradorID, Long.valueOf(A232NumeradorUltimoNRO)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Numerador");
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
                        resetCaption150( ) ;
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
            load1546( ) ;
         }
         endLevel1546( ) ;
      }
      closeExtendedTableCursors1546( ) ;
   }

   public void update1546( )
   {
      if ( ! IsAuthorized("numerador_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1546( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1546( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1546( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1546( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1546( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00159 */
                  pr_default.execute(7, new Object[] {Long.valueOf(A232NumeradorUltimoNRO), A49NumeradorID});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Numerador");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Numerador"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1546( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
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
         }
         endLevel1546( ) ;
      }
      closeExtendedTableCursors1546( ) ;
   }

   public void deferredUpdate1546( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("numerador_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1546( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1546( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1546( ) ;
         afterConfirm1546( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1546( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001510 */
               pr_default.execute(8, new Object[] {A49NumeradorID});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Numerador");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
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
      }
      sMode46 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1546( ) ;
      Gx_mode = sMode46 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1546( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1546( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1546( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "numerador");
         if ( AnyError == 0 )
         {
            confirmValues150( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "numerador");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1546( )
   {
      /* Scan By routine */
      /* Using cursor T001511 */
      pr_default.execute(9);
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A49NumeradorID = T001511_A49NumeradorID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1546( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A49NumeradorID = T001511_A49NumeradorID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
      }
   }

   public void scanEnd1546( )
   {
      pr_default.close(9);
   }

   public void afterConfirm1546( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1546( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1546( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1546( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1546( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1546( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1546( )
   {
      edtNumeradorID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtNumeradorID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtNumeradorID_Enabled), 5, 0), true);
      edtNumeradorUltimoNRO_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtNumeradorUltimoNRO_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtNumeradorUltimoNRO_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1546( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues150( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.numerador", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7NumeradorID))}, new String[] {"Gx_mode","NumeradorID"}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Numerador");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("numerador:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z49NumeradorID", GXutil.rtrim( Z49NumeradorID));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z232NumeradorUltimoNRO", GXutil.ltrim( localUtil.ntoc( Z232NumeradorUltimoNRO, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV11TrnContext);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV11TrnContext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vNUMERADORID", GXutil.rtrim( AV7NumeradorID));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUMERADORID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7NumeradorID, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
      return formatLink("com.mujermorena.numerador", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV7NumeradorID))}, new String[] {"Gx_mode","NumeradorID"})  ;
   }

   public String getPgmname( )
   {
      return "Numerador" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Numerador", "") ;
   }

   public void initializeNonKey1546( )
   {
      A232NumeradorUltimoNRO = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A232NumeradorUltimoNRO", GXutil.ltrimstr( DecimalUtil.doubleToDec(A232NumeradorUltimoNRO), 10, 0));
      Z232NumeradorUltimoNRO = 0 ;
   }

   public void initAll1546( )
   {
      A49NumeradorID = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A49NumeradorID", A49NumeradorID);
      initializeNonKey1546( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211110485", true, true);
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
      httpContext.AddJavascriptSource("numerador.js", "?20241211110486", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtNumeradorID_Internalname = "NUMERADORID" ;
      edtNumeradorUltimoNRO_Internalname = "NUMERADORULTIMONRO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
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
      Form.setCaption( httpContext.getMessage( "Numerador", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtNumeradorUltimoNRO_Jsonclick = "" ;
      edtNumeradorUltimoNRO_Enabled = 1 ;
      edtNumeradorID_Jsonclick = "" ;
      edtNumeradorID_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
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
      /* End function init_web_controls */
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

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7NumeradorID',fld:'vNUMERADORID',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7NumeradorID',fld:'vNUMERADORID',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12152',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_NUMERADORID","{handler:'valid_Numeradorid',iparms:[]");
      setEventMetadata("VALID_NUMERADORID",",oparms:[]}");
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
      return "numerador_Execute";
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV7NumeradorID = "" ;
      Z49NumeradorID = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV7NumeradorID = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A49NumeradorID = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode46 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      T00154_A49NumeradorID = new String[] {""} ;
      T00154_A232NumeradorUltimoNRO = new long[1] ;
      T00155_A49NumeradorID = new String[] {""} ;
      T00153_A49NumeradorID = new String[] {""} ;
      T00153_A232NumeradorUltimoNRO = new long[1] ;
      T00156_A49NumeradorID = new String[] {""} ;
      T00157_A49NumeradorID = new String[] {""} ;
      T00152_A49NumeradorID = new String[] {""} ;
      T00152_A232NumeradorUltimoNRO = new long[1] ;
      T001511_A49NumeradorID = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.numerador__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.numerador__default(),
         new Object[] {
             new Object[] {
            T00152_A49NumeradorID, T00152_A232NumeradorUltimoNRO
            }
            , new Object[] {
            T00153_A49NumeradorID, T00153_A232NumeradorUltimoNRO
            }
            , new Object[] {
            T00154_A49NumeradorID, T00154_A232NumeradorUltimoNRO
            }
            , new Object[] {
            T00155_A49NumeradorID
            }
            , new Object[] {
            T00156_A49NumeradorID
            }
            , new Object[] {
            T00157_A49NumeradorID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001511_A49NumeradorID
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
   private short RcdFound46 ;
   private short nIsDirty_46 ;
   private int trnEnded ;
   private int edtNumeradorID_Enabled ;
   private int edtNumeradorUltimoNRO_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private long Z232NumeradorUltimoNRO ;
   private long A232NumeradorUltimoNRO ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV7NumeradorID ;
   private String Z49NumeradorID ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV7NumeradorID ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtNumeradorID_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A49NumeradorID ;
   private String edtNumeradorID_Jsonclick ;
   private String edtNumeradorUltimoNRO_Internalname ;
   private String edtNumeradorUltimoNRO_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode46 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00154_A49NumeradorID ;
   private long[] T00154_A232NumeradorUltimoNRO ;
   private String[] T00155_A49NumeradorID ;
   private String[] T00153_A49NumeradorID ;
   private long[] T00153_A232NumeradorUltimoNRO ;
   private String[] T00156_A49NumeradorID ;
   private String[] T00157_A49NumeradorID ;
   private String[] T00152_A49NumeradorID ;
   private long[] T00152_A232NumeradorUltimoNRO ;
   private String[] T001511_A49NumeradorID ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class numerador__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class numerador__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00152", "SELECT [NumeradorID], [NumeradorUltimoNRO] FROM [Numerador] WITH (UPDLOCK) WHERE [NumeradorID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00153", "SELECT [NumeradorID], [NumeradorUltimoNRO] FROM [Numerador] WHERE [NumeradorID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00154", "SELECT TM1.[NumeradorID], TM1.[NumeradorUltimoNRO] FROM [Numerador] TM1 WHERE TM1.[NumeradorID] = ? ORDER BY TM1.[NumeradorID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00155", "SELECT [NumeradorID] FROM [Numerador] WHERE [NumeradorID] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00156", "SELECT TOP 1 [NumeradorID] FROM [Numerador] WHERE ( [NumeradorID] > ?) ORDER BY [NumeradorID]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00157", "SELECT TOP 1 [NumeradorID] FROM [Numerador] WHERE ( [NumeradorID] < ?) ORDER BY [NumeradorID] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T00158", "INSERT INTO [Numerador]([NumeradorID], [NumeradorUltimoNRO]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T00159", "UPDATE [Numerador] SET [NumeradorUltimoNRO]=?  WHERE [NumeradorID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001510", "DELETE FROM [Numerador]  WHERE [NumeradorID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001511", "SELECT [NumeradorID] FROM [Numerador] ORDER BY [NumeradorID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 56);
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
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 56);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 56);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 56);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 56);
               return;
      }
   }

}

