package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwcauthenticationtypeentrygeneral_impl extends GXWebComponent
{
   public gamwcauthenticationtypeentrygeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwcauthenticationtypeentrygeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwcauthenticationtypeentrygeneral_impl.class ));
   }

   public gamwcauthenticationtypeentrygeneral_impl( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
      cmbavFunctionid = new HTMLChoice();
      chkavIsenable = UIFactory.getCheckbox(this);
      cmbavImpersonate = new HTMLChoice();
      chkavTfaenable = UIFactory.getCheckbox(this);
      cmbavTfaauthenticationtypename = new HTMLChoice();
      chkavTfaforceforallusers = UIFactory.getCheckbox(this);
      chkavOtpuseforfirstfactorauthentication = UIFactory.getCheckbox(this);
      cmbavOtpeventvalidateuser = new HTMLChoice();
      cmbavOtpgenerationtype = new HTMLChoice();
      cmbavOtpgenerationtype_customeventgeneratecode = new HTMLChoice();
      chkavOtpgeneratecodeonlynumbers = UIFactory.getCheckbox(this);
      cmbavOtpeventsendcode = new HTMLChoice();
      cmbavOtpeventvalidatecode = new HTMLChoice();
      chkavSiteurlcallbackiscustom = UIFactory.getCheckbox(this);
      chkavAdduseradditionaldatascope = UIFactory.getCheckbox(this);
      chkavAddinitialpropertiesscope = UIFactory.getCheckbox(this);
      chkavAutovalidateexternaltokenandrefresh = UIFactory.getCheckbox(this);
      cmbavWsversion = new HTMLChoice();
      cmbavWsserversecureprotocol = new HTMLChoice();
      cmbavCusversion = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               Gx_mode = httpContext.GetPar( "Mode") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
               AV46Name = httpContext.GetPar( "Name") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
               AV69TypeId = httpContext.GetPar( "TypeId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TypeId", AV69TypeId);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Gx_mode,AV46Name,AV69TypeId});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa2Z2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.mujermorena.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Authentication Type Entry General", "")) ;
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
      }
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwcauthenticationtypeentrygeneral", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV46Name)),GXutil.URLEncode(GXutil.rtrim(AV69TypeId))}, new String[] {"Gx_mode","Name","TypeId"}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOGx_mode", GXutil.rtrim( wcpOGx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV46Name", GXutil.rtrim( wcpOAV46Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV69TypeId", GXutil.rtrim( wcpOAV69TypeId));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCHECKREQUIREDFIELDSRESULT", AV83CheckRequiredFieldsResult);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTYPEID", GXutil.rtrim( AV69TypeId));
   }

   public void renderHtmlCloseForm2Z2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "GAMWCAuthenticationTypeEntryGeneral" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Authentication Type Entry General", "") ;
   }

   public void wb2Z0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.gamwcauthenticationtypeentrygeneral");
         }
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
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV46Name), GXutil.rtrim( localUtil.format( AV46Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFunctionid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavFunctionid.getInternalname(), httpContext.getMessage( "WWP_GAM_Function", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFunctionid, cmbavFunctionid.getInternalname(), GXutil.rtrim( AV37FunctionId), 1, cmbavFunctionid.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFunctionid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,24);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavFunctionid.setValue( GXutil.rtrim( AV37FunctionId) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Values", cmbavFunctionid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsenable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsenable.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsenable.getInternalname(), GXutil.booltostr( AV45IsEnable), "", " ", 1, chkavIsenable.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Enabled", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(29, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,29);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDsc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDsc_Internalname, httpContext.getMessage( "WWP_GAM_Description", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV33Dsc), GXutil.rtrim( localUtil.format( AV33Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSmallimagename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSmallimagename_Internalname, httpContext.getMessage( "WWP_GAM_Smallimagename", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSmallimagename_Internalname, GXutil.rtrim( AV64SmallImageName), GXutil.rtrim( localUtil.format( AV64SmallImageName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSmallimagename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSmallimagename_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavBigimagename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavBigimagename_Internalname, httpContext.getMessage( "WWP_GAM_BigImageName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavBigimagename_Internalname, GXutil.rtrim( AV22BigImageName), GXutil.rtrim( localUtil.format( AV22BigImageName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBigimagename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBigimagename_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divImpersonate_cell_Internalname, 1, 0, "px", 0, "px", divImpersonate_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavImpersonate.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavImpersonate.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavImpersonate.getInternalname(), httpContext.getMessage( "WWP_GAM_Impersonate", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavImpersonate, cmbavImpersonate.getInternalname(), GXutil.rtrim( AV44Impersonate), 1, cmbavImpersonate.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavImpersonate.getVisible(), cmbavImpersonate.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavImpersonate.setValue( GXutil.rtrim( AV44Impersonate) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavImpersonate.getInternalname(), "Values", cmbavImpersonate.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTfaenable_cell_Internalname, 1, 0, "px", 0, "px", divTfaenable_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavTfaenable.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTfaenable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTfaenable.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTfaenable.getInternalname(), GXutil.booltostr( AV66TFAEnable), "", " ", chkavTfaenable.getVisible(), chkavTfaenable.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_EnableTwoFactorAuthentication", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,51);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTfaauthenticationtypename_cell_Internalname, 1, 0, "px", 0, "px", divTfaauthenticationtypename_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavTfaauthenticationtypename.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavTfaauthenticationtypename.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavTfaauthenticationtypename.getInternalname(), httpContext.getMessage( "WWP_GAM_AuthenticationTypeName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavTfaauthenticationtypename, cmbavTfaauthenticationtypename.getInternalname(), GXutil.rtrim( AV65TFAAuthenticationTypeName), 1, cmbavTfaauthenticationtypename.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavTfaauthenticationtypename.getVisible(), cmbavTfaauthenticationtypename.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,56);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavTfaauthenticationtypename.setValue( GXutil.rtrim( AV65TFAAuthenticationTypeName) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTfaauthenticationtypename.getInternalname(), "Values", cmbavTfaauthenticationtypename.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTfafirstfactorauthenticationexpiration_cell_Internalname, 1, 0, "px", 0, "px", divTfafirstfactorauthenticationexpiration_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavTfafirstfactorauthenticationexpiration_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTfafirstfactorauthenticationexpiration_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTfafirstfactorauthenticationexpiration_Internalname, httpContext.getMessage( "WWP_GAM_FirstFactorAuthExpiration", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTfafirstfactorauthenticationexpiration_Internalname, GXutil.ltrim( localUtil.ntoc( AV67TFAFirstFactorAuthenticationExpiration, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), "ZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,60);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTfafirstfactorauthenticationexpiration_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavTfafirstfactorauthenticationexpiration_Visible, edtavTfafirstfactorauthenticationexpiration_Enabled, 1, "text", "1", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTfaforceforallusers_cell_Internalname, 1, 0, "px", 0, "px", divTfaforceforallusers_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavTfaforceforallusers.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTfaforceforallusers.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTfaforceforallusers.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTfaforceforallusers.getInternalname(), GXutil.booltostr( AV68TFAForceForAllUsers), "", " ", chkavTfaforceforallusers.getVisible(), chkavTfaforceforallusers.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Force2FAAllUsers", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(65, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,65);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblotpauthentication_Internalname, divTblotpauthentication_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavOtpuseforfirstfactorauthentication.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavOtpuseforfirstfactorauthentication.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavOtpuseforfirstfactorauthentication.getInternalname(), GXutil.booltostr( AV61OTPUseForFirstFactorAuthentication), "", " ", 1, chkavOtpuseforfirstfactorauthentication.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_UseForFFA", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(73, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,73);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblotpconfiguration_Internalname, divTblotpconfiguration_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavOtpeventvalidateuser.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavOtpeventvalidateuser.getInternalname(), httpContext.getMessage( "WWP_GAM_UserValidationEvent", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOtpeventvalidateuser, cmbavOtpeventvalidateuser.getInternalname(), GXutil.rtrim( AV52OTPEventValidateUser), 1, cmbavOtpeventvalidateuser.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavOtpeventvalidateuser.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,81);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavOtpeventvalidateuser.setValue( GXutil.rtrim( AV52OTPEventValidateUser) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventvalidateuser.getInternalname(), "Values", cmbavOtpeventvalidateuser.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavOtpgenerationtype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavOtpgenerationtype.getInternalname(), httpContext.getMessage( "WWP_GAM_CodeGenerationType", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOtpgenerationtype, cmbavOtpgenerationtype.getInternalname(), GXutil.rtrim( AV54OTPGenerationType), 1, cmbavOtpgenerationtype.getJsonclick(), 5, "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVOTPGENERATIONTYPE.CLICK."+"'", "svchar", "", 1, cmbavOtpgenerationtype.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavOtpgenerationtype.setValue( GXutil.rtrim( AV54OTPGenerationType) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype.getInternalname(), "Values", cmbavOtpgenerationtype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtpgenerationtype_customeventgeneratecode_cell_Internalname, 1, 0, "px", 0, "px", divOtpgenerationtype_customeventgeneratecode_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavOtpgenerationtype_customeventgeneratecode.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavOtpgenerationtype_customeventgeneratecode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), httpContext.getMessage( "WWP_GAM_EventToGenerateOTPCustom", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOtpgenerationtype_customeventgeneratecode, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), GXutil.rtrim( AV55OTPGenerationType_CustomEventGenerateCode), 1, cmbavOtpgenerationtype_customeventgeneratecode.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", cmbavOtpgenerationtype_customeventgeneratecode.getVisible(), cmbavOtpgenerationtype_customeventgeneratecode.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavOtpgenerationtype_customeventgeneratecode.setValue( GXutil.rtrim( AV55OTPGenerationType_CustomEventGenerateCode) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), "Values", cmbavOtpgenerationtype_customeventgeneratecode.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtpautogeneratedcodelength_cell_Internalname, 1, 0, "px", 0, "px", divOtpautogeneratedcodelength_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavOtpautogeneratedcodelength_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpautogeneratedcodelength_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpautogeneratedcodelength_Internalname, httpContext.getMessage( "WWP_GAM_AutoheneratedOTPCodeLength", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpautogeneratedcodelength_Internalname, GXutil.ltrim( localUtil.ntoc( AV47OTPAutogeneratedCodeLength, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV47OTPAutogeneratedCodeLength), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,94);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpautogeneratedcodelength_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavOtpautogeneratedcodelength_Visible, edtavOtpautogeneratedcodelength_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtpgeneratecodeonlynumbers_cell_Internalname, 1, 0, "px", 0, "px", divOtpgeneratecodeonlynumbers_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavOtpgeneratecodeonlynumbers.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavOtpgeneratecodeonlynumbers.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavOtpgeneratecodeonlynumbers.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavOtpgeneratecodeonlynumbers.getInternalname(), GXutil.booltostr( AV53OTPGenerateCodeOnlyNumbers), "", " ", chkavOtpgeneratecodeonlynumbers.getVisible(), chkavOtpgeneratecodeonlynumbers.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GenerateCodeOnlyWithNumbers", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(99, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,99);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpcodeexpirationtimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpcodeexpirationtimeout_Internalname, httpContext.getMessage( "WWP_GAM_CodeExpirationTimeout", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpcodeexpirationtimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV49OTPCodeExpirationTimeout, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV49OTPCodeExpirationTimeout), "ZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,103);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpcodeexpirationtimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOtpcodeexpirationtimeout_Enabled, 1, "text", "1", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpmaximumdailynumbercodes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpmaximumdailynumbercodes_Internalname, httpContext.getMessage( "WWP_GAM_MaxDailyNumberCodes", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpmaximumdailynumbercodes_Internalname, GXutil.ltrim( localUtil.ntoc( AV58OTPMaximumDailyNumberCodes, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV58OTPMaximumDailyNumberCodes), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpmaximumdailynumbercodes_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOtpmaximumdailynumbercodes_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpnumberunsuccessfulretriestolockotp_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpnumberunsuccessfulretriestolockotp_Internalname, httpContext.getMessage( "WWP_GAM_NumberUnsuccessfullRetries", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpnumberunsuccessfulretriestolockotp_Internalname, GXutil.ltrim( localUtil.ntoc( AV60OTPNumberUnsuccessfulRetriesToLockOTP, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV60OTPNumberUnsuccessfulRetriesToLockOTP), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,112);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpnumberunsuccessfulretriestolockotp_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOtpnumberunsuccessfulretriestolockotp_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpautounlocktime_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpautounlocktime_Internalname, httpContext.getMessage( "WWP_GAM_AutomaticOTPUnlockTime", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpautounlocktime_Internalname, GXutil.ltrim( localUtil.ntoc( AV48OTPAutoUnlockTime, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV48OTPAutoUnlockTime), "ZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,117);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpautounlocktime_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOtpautounlocktime_Enabled, 1, "text", "1", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname, httpContext.getMessage( "WWP_GAM_NumberUnsuccessfulRetriesLockOTP", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname, GXutil.ltrim( localUtil.ntoc( AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,121);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblsendandvalidateotpcode_Internalname, divTblsendandvalidateotpcode_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavOtpeventsendcode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavOtpeventsendcode.getInternalname(), httpContext.getMessage( "WWP_GAM_SendCodeUsing", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOtpeventsendcode, cmbavOtpeventsendcode.getInternalname(), GXutil.rtrim( AV50OTPEventSendCode), 1, cmbavOtpeventsendcode.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavOtpeventsendcode.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,129);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavOtpeventsendcode.setValue( GXutil.rtrim( AV50OTPEventSendCode) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventsendcode.getInternalname(), "Values", cmbavOtpeventsendcode.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpmailmessagesubject_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpmailmessagesubject_Internalname, httpContext.getMessage( "WWP_GAM_MailMessageSubject", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpmailmessagesubject_Internalname, GXutil.rtrim( AV57OTPMailMessageSubject), GXutil.rtrim( localUtil.format( AV57OTPMailMessageSubject, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,134);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpmailmessagesubject_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOtpmailmessagesubject_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpmailmessagebodyhtml_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpmailmessagebodyhtml_Internalname, httpContext.getMessage( "WWP_GAM_MailMessageHTMLText", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavOtpmailmessagebodyhtml_Internalname, AV56OTPMailMessageBodyHTML, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,139);\"", (short)(0), 1, edtavOtpmailmessagebodyhtml_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavOtpeventvalidatecode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavOtpeventvalidatecode.getInternalname(), httpContext.getMessage( "WWP_GAM_ValidateCodeUsing", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavOtpeventvalidatecode, cmbavOtpeventvalidatecode.getInternalname(), GXutil.rtrim( AV51OTPEventValidateCode), 1, cmbavOtpeventvalidatecode.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavOtpeventvalidatecode.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,144);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavOtpeventvalidatecode.setValue( GXutil.rtrim( AV51OTPEventValidateCode) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventvalidatecode.getInternalname(), "Values", cmbavOtpeventvalidatecode.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divClientid_cell_Internalname, 1, 0, "px", 0, "px", divClientid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavClientid_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientid_Internalname, httpContext.getMessage( "WWP_GAM_ClientId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientid_Internalname, AV24ClientId, GXutil.rtrim( localUtil.format( AV24ClientId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,149);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavClientid_Visible, edtavClientid_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divClientsecret_cell_Internalname, 1, 0, "px", 0, "px", divClientsecret_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavClientsecret_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientsecret_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientsecret_Internalname, httpContext.getMessage( "WWP_GAM_ClientSecret", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientsecret_Internalname, AV25ClientSecret, GXutil.rtrim( localUtil.format( AV25ClientSecret, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,153);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientsecret_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavClientsecret_Visible, edtavClientsecret_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divVersionpath_cell_Internalname, 1, 0, "px", 0, "px", divVersionpath_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavVersionpath_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavVersionpath_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavVersionpath_Internalname, httpContext.getMessage( "WWP_GAM_VersionPath", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavVersionpath_Internalname, GXutil.rtrim( AV70VersionPath), GXutil.rtrim( localUtil.format( AV70VersionPath, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,158);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavVersionpath_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavVersionpath_Visible, edtavVersionpath_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divSiteurl_cell_Internalname, 1, 0, "px", 0, "px", divSiteurl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavSiteurl_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSiteurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSiteurl_Internalname, httpContext.getMessage( "WWP_GAM_LocalSiteURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 162,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSiteurl_Internalname, AV62SiteURL, GXutil.rtrim( localUtil.format( AV62SiteURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,162);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSiteurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavSiteurl_Visible, edtavSiteurl_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divSiteurlcallbackiscustom_cell_Internalname, 1, 0, "px", 0, "px", divSiteurlcallbackiscustom_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavSiteurlcallbackiscustom.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavSiteurlcallbackiscustom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavSiteurlcallbackiscustom.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 167,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSiteurlcallbackiscustom.getInternalname(), GXutil.booltostr( AV63SiteURLCallbackIsCustom), "", " ", chkavSiteurlcallbackiscustom.getVisible(), chkavSiteurlcallbackiscustom.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CustomCallbackURL", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(167, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,167);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divConsumerkey_cell_Internalname, 1, 0, "px", 0, "px", divConsumerkey_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavConsumerkey_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConsumerkey_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConsumerkey_Internalname, httpContext.getMessage( "WWP_GAM_ConsumerKey", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 171,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConsumerkey_Internalname, GXutil.rtrim( AV26ConsumerKey), GXutil.rtrim( localUtil.format( AV26ConsumerKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,171);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConsumerkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavConsumerkey_Visible, edtavConsumerkey_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divConsumersecret_cell_Internalname, 1, 0, "px", 0, "px", divConsumersecret_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavConsumersecret_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConsumersecret_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConsumersecret_Internalname, httpContext.getMessage( "WWP_GAM_ConsumerSecret", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 176,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConsumersecret_Internalname, GXutil.rtrim( AV27ConsumerSecret), GXutil.rtrim( localUtil.format( AV27ConsumerSecret, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,176);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConsumersecret_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavConsumersecret_Visible, edtavConsumersecret_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divCallbackurl_cell_Internalname, 1, 0, "px", 0, "px", divCallbackurl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavCallbackurl_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCallbackurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCallbackurl_Internalname, httpContext.getMessage( "WWP_GAM_CallbackURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 180,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCallbackurl_Internalname, AV23CallbackURL, GXutil.rtrim( localUtil.format( AV23CallbackURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,180);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCallbackurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavCallbackurl_Visible, edtavCallbackurl_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAdduseradditionaldatascope_cell_Internalname, 1, 0, "px", 0, "px", divAdduseradditionaldatascope_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavAdduseradditionaldatascope.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAdduseradditionaldatascope.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAdduseradditionaldatascope.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 185,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAdduseradditionaldatascope.getInternalname(), GXutil.booltostr( AV7AddUserAdditionalDataScope), "", " ", chkavAdduseradditionaldatascope.getVisible(), chkavAdduseradditionaldatascope.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_AddGAMUserAddDataScope", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(185, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,185);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAddinitialpropertiesscope_cell_Internalname, 1, 0, "px", 0, "px", divAddinitialpropertiesscope_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavAddinitialpropertiesscope.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAddinitialpropertiesscope.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAddinitialpropertiesscope.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAddinitialpropertiesscope.getInternalname(), GXutil.booltostr( AV5AddInitialPropertiesScope), "", " ", chkavAddinitialpropertiesscope.getVisible(), chkavAddinitialpropertiesscope.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_AddGAMSessionInitialPropScope", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(189, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,189);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAdditionalscope_cell_Internalname, 1, 0, "px", 0, "px", divAdditionalscope_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavAdditionalscope_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAdditionalscope_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAdditionalscope_Internalname, httpContext.getMessage( "WWP_GAM_AdditionalScope", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAdditionalscope_Internalname, AV6AdditionalScope, GXutil.rtrim( localUtil.format( AV6AdditionalScope, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,194);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAdditionalscope_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavAdditionalscope_Visible, edtavAdditionalscope_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGamrauthenticationtypename_cell_Internalname, 1, 0, "px", 0, "px", divGamrauthenticationtypename_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavGamrauthenticationtypename_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamrauthenticationtypename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamrauthenticationtypename_Internalname, httpContext.getMessage( "WWP_GAM_RAuthTypeName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 198,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamrauthenticationtypename_Internalname, GXutil.rtrim( AV40GAMRAuthenticationTypeName), GXutil.rtrim( localUtil.format( AV40GAMRAuthenticationTypeName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,198);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamrauthenticationtypename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavGamrauthenticationtypename_Visible, edtavGamrauthenticationtypename_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMAuthenticationTypeName", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblserverhost_Internalname, divTblserverhost_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGamrserverurl_cell_Internalname, 1, 0, "px", 0, "px", divGamrserverurl_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamrserverurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamrserverurl_Internalname, httpContext.getMessage( "WWP_GAM_RemoteServerURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 206,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamrserverurl_Internalname, AV43GAMRServerURL, GXutil.rtrim( localUtil.format( AV43GAMRServerURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,206);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamrserverurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavGamrserverurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGamrprivateencryptkey_cell_Internalname, 1, 0, "px", 0, "px", divGamrprivateencryptkey_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavGamrprivateencryptkey_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamrprivateencryptkey_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamrprivateencryptkey_Internalname, httpContext.getMessage( "WWP_GAM_PrivateEncryptionKey", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 210,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamrprivateencryptkey_Internalname, GXutil.rtrim( AV41GAMRPrivateEncryptKey), GXutil.rtrim( localUtil.format( AV41GAMRPrivateEncryptKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,210);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamrprivateencryptkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavGamrprivateencryptkey_Visible, edtavGamrprivateencryptkey_Enabled, 1, "text", "", 32, "chr", 1, "row", 32, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEncryptionKey", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGamrrepositoryguid_cell_Internalname, 1, 0, "px", 0, "px", divGamrrepositoryguid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavGamrrepositoryguid_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamrrepositoryguid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamrrepositoryguid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 215,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamrrepositoryguid_Internalname, GXutil.rtrim( AV42GAMRRepositoryGUID), GXutil.rtrim( localUtil.format( AV42GAMRRepositoryGUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,215);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamrrepositoryguid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavGamrrepositoryguid_Visible, edtavGamrrepositoryguid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAutovalidateexternaltokenandrefresh.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAutovalidateexternaltokenandrefresh.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAutovalidateexternaltokenandrefresh.getInternalname(), GXutil.booltostr( AV21AutovalidateExternalTokenAndRefresh), "", " ", 1, chkavAutovalidateexternaltokenandrefresh.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_ValidateExternalToken", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(219, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,219);\"");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblwebservice_Internalname, divTblwebservice_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavWsversion.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavWsversion.getInternalname(), httpContext.getMessage( "WWP_GAM_WebServiceversion", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 227,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavWsversion, cmbavWsversion.getInternalname(), GXutil.rtrim( AV80WSVersion), 1, cmbavWsversion.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavWsversion.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,227);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavWsversion.setValue( GXutil.rtrim( AV80WSVersion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavWsversion.getInternalname(), "Values", cmbavWsversion.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedwsprivateencryptkey_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockwsprivateencryptkey_Internalname, httpContext.getMessage( "WWP_GAM_PrivateEncryptionKey", ""), "", "", lblTextblockwsprivateencryptkey_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_234_2Z2( true) ;
      }
      else
      {
         wb_table1_234_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table1_234_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divWsservername_cell_Internalname, 1, 0, "px", 0, "px", divWsservername_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWsservername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWsservername_Internalname, httpContext.getMessage( "WWP_GAM_Servername", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 245,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWsservername_Internalname, GXutil.rtrim( AV76WSServerName), GXutil.rtrim( localUtil.format( AV76WSServerName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,245);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWsservername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWsservername_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divWsserverport_cell_Internalname, 1, 0, "px", 0, "px", divWsserverport_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWsserverport_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWsserverport_Internalname, httpContext.getMessage( "WWP_GAM_Serverport", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 249,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWsserverport_Internalname, GXutil.ltrim( localUtil.ntoc( AV77WSServerPort, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV77WSServerPort), "ZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,249);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWsserverport_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWsserverport_Enabled, 1, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWsserverbaseurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWsserverbaseurl_Internalname, httpContext.getMessage( "WWP_GAM_BaseURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 254,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWsserverbaseurl_Internalname, AV75WSServerBaseURL, GXutil.rtrim( localUtil.format( AV75WSServerBaseURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,254);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWsserverbaseurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWsserverbaseurl_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavWsserversecureprotocol.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavWsserversecureprotocol.getInternalname(), httpContext.getMessage( "WWP_GAM_Secureprotocol", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 258,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavWsserversecureprotocol, cmbavWsserversecureprotocol.getInternalname(), GXutil.trim( GXutil.str( AV78WSServerSecureProtocol, 1, 0)), 1, cmbavWsserversecureprotocol.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavWsserversecureprotocol.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,258);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavWsserversecureprotocol.setValue( GXutil.trim( GXutil.str( AV78WSServerSecureProtocol, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavWsserversecureprotocol.getInternalname(), "Values", cmbavWsserversecureprotocol.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWstimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWstimeout_Internalname, httpContext.getMessage( "WWP_GAM_Timeout", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 263,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWstimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV79WSTimeout, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV79WSTimeout), "ZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,263);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWstimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWstimeout_Enabled, 1, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWspackage_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWspackage_Internalname, httpContext.getMessage( "WWP_GAM_WebServicepackage", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 267,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWspackage_Internalname, GXutil.rtrim( AV73WSPackage), GXutil.rtrim( localUtil.format( AV73WSPackage, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,267);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWspackage_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWspackage_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divWsname_cell_Internalname, 1, 0, "px", 0, "px", divWsname_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWsname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWsname_Internalname, httpContext.getMessage( "WWP_GAM_WebServiceName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 272,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWsname_Internalname, GXutil.rtrim( AV72WSName), GXutil.rtrim( localUtil.format( AV72WSName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,272);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWsname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWsname_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWsextension_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWsextension_Internalname, httpContext.getMessage( "WWP_GAM_WebServiceExtension", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 276,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWsextension_Internalname, GXutil.rtrim( AV71WSExtension), GXutil.rtrim( localUtil.format( AV71WSExtension, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,276);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWsextension_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWsextension_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblexternal_Internalname, divTblexternal_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavCusversion.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavCusversion.getInternalname(), httpContext.getMessage( "WWP_GAM_JSONversion", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 283,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCusversion, cmbavCusversion.getInternalname(), GXutil.rtrim( AV32CusVersion), 1, cmbavCusversion.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavCusversion.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,283);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         cmbavCusversion.setValue( GXutil.rtrim( AV32CusVersion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavCusversion.getInternalname(), "Values", cmbavCusversion.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedcusprivateencryptkey_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcusprivateencryptkey_Internalname, httpContext.getMessage( "WWP_GAM_PrivateEncryptionKey", ""), "", "", lblTextblockcusprivateencryptkey_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_290_2Z2( true) ;
      }
      else
      {
         wb_table2_290_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table2_290_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divCusfilename_cell_Internalname, 1, 0, "px", 0, "px", divCusfilename_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCusfilename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCusfilename_Internalname, httpContext.getMessage( "WWP_GAM_FileName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 301,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCusfilename_Internalname, GXutil.rtrim( AV29CusFileName), GXutil.rtrim( localUtil.format( AV29CusFileName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,301);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCusfilename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCusfilename_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCuspackage_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCuspackage_Internalname, httpContext.getMessage( "WWP_GAM_Package", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 305,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCuspackage_Internalname, GXutil.rtrim( AV30CusPackage), GXutil.rtrim( localUtil.format( AV30CusPackage, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,305);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCuspackage_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCuspackage_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divCusclassname_cell_Internalname, 1, 0, "px", 0, "px", divCusclassname_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCusclassname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCusclassname_Internalname, httpContext.getMessage( "WWP_GAM_ClassName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 310,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCusclassname_Internalname, GXutil.rtrim( AV28CusClassName), GXutil.rtrim( localUtil.format( AV28CusClassName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,310);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCusclassname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCusclassname_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 315,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 317,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
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
      wbLoad = true ;
   }

   public void start2Z2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Authentication Type Entry General", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup2Z0( ) ;
         }
      }
   }

   public void ws2Z2( )
   {
      start2Z2( ) ;
      evt2Z2( ) ;
   }

   public void evt2Z2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e112Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENKEYCUSTOM'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoGenKeyCustom' */
                                 e122Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENKEY'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoGenKey' */
                                 e132Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e142Z2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VTFAENABLE.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e152Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VOTPGENERATIONTYPE.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e162Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e172Z2 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = cmbavFunctionid.getInternalname() ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
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
   }

   public void we2Z2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2Z2( ) ;
         }
      }
   }

   public void pa2Z2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = cmbavFunctionid.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavFunctionid.getItemCount() > 0 )
      {
         AV37FunctionId = cmbavFunctionid.getValidValue(AV37FunctionId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFunctionid.setValue( GXutil.rtrim( AV37FunctionId) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Values", cmbavFunctionid.ToJavascriptSource(), true);
      }
      AV45IsEnable = GXutil.strtobool( GXutil.booltostr( AV45IsEnable)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      if ( cmbavImpersonate.getItemCount() > 0 )
      {
         AV44Impersonate = cmbavImpersonate.getValidValue(AV44Impersonate) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavImpersonate.setValue( GXutil.rtrim( AV44Impersonate) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavImpersonate.getInternalname(), "Values", cmbavImpersonate.ToJavascriptSource(), true);
      }
      AV66TFAEnable = GXutil.strtobool( GXutil.booltostr( AV66TFAEnable)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFAEnable", AV66TFAEnable);
      if ( cmbavTfaauthenticationtypename.getItemCount() > 0 )
      {
         AV65TFAAuthenticationTypeName = cmbavTfaauthenticationtypename.getValidValue(AV65TFAAuthenticationTypeName) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavTfaauthenticationtypename.setValue( GXutil.rtrim( AV65TFAAuthenticationTypeName) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTfaauthenticationtypename.getInternalname(), "Values", cmbavTfaauthenticationtypename.ToJavascriptSource(), true);
      }
      AV68TFAForceForAllUsers = GXutil.strtobool( GXutil.booltostr( AV68TFAForceForAllUsers)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFAForceForAllUsers", AV68TFAForceForAllUsers);
      AV61OTPUseForFirstFactorAuthentication = GXutil.strtobool( GXutil.booltostr( AV61OTPUseForFirstFactorAuthentication)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61OTPUseForFirstFactorAuthentication", AV61OTPUseForFirstFactorAuthentication);
      if ( cmbavOtpeventvalidateuser.getItemCount() > 0 )
      {
         AV52OTPEventValidateUser = cmbavOtpeventvalidateuser.getValidValue(AV52OTPEventValidateUser) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52OTPEventValidateUser", AV52OTPEventValidateUser);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOtpeventvalidateuser.setValue( GXutil.rtrim( AV52OTPEventValidateUser) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventvalidateuser.getInternalname(), "Values", cmbavOtpeventvalidateuser.ToJavascriptSource(), true);
      }
      if ( cmbavOtpgenerationtype.getItemCount() > 0 )
      {
         AV54OTPGenerationType = cmbavOtpgenerationtype.getValidValue(AV54OTPGenerationType) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54OTPGenerationType", AV54OTPGenerationType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOtpgenerationtype.setValue( GXutil.rtrim( AV54OTPGenerationType) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype.getInternalname(), "Values", cmbavOtpgenerationtype.ToJavascriptSource(), true);
      }
      if ( cmbavOtpgenerationtype_customeventgeneratecode.getItemCount() > 0 )
      {
         AV55OTPGenerationType_CustomEventGenerateCode = cmbavOtpgenerationtype_customeventgeneratecode.getValidValue(AV55OTPGenerationType_CustomEventGenerateCode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55OTPGenerationType_CustomEventGenerateCode", AV55OTPGenerationType_CustomEventGenerateCode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOtpgenerationtype_customeventgeneratecode.setValue( GXutil.rtrim( AV55OTPGenerationType_CustomEventGenerateCode) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), "Values", cmbavOtpgenerationtype_customeventgeneratecode.ToJavascriptSource(), true);
      }
      AV53OTPGenerateCodeOnlyNumbers = GXutil.strtobool( GXutil.booltostr( AV53OTPGenerateCodeOnlyNumbers)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53OTPGenerateCodeOnlyNumbers", AV53OTPGenerateCodeOnlyNumbers);
      if ( cmbavOtpeventsendcode.getItemCount() > 0 )
      {
         AV50OTPEventSendCode = cmbavOtpeventsendcode.getValidValue(AV50OTPEventSendCode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50OTPEventSendCode", AV50OTPEventSendCode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOtpeventsendcode.setValue( GXutil.rtrim( AV50OTPEventSendCode) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventsendcode.getInternalname(), "Values", cmbavOtpeventsendcode.ToJavascriptSource(), true);
      }
      if ( cmbavOtpeventvalidatecode.getItemCount() > 0 )
      {
         AV51OTPEventValidateCode = cmbavOtpeventvalidatecode.getValidValue(AV51OTPEventValidateCode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51OTPEventValidateCode", AV51OTPEventValidateCode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavOtpeventvalidatecode.setValue( GXutil.rtrim( AV51OTPEventValidateCode) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventvalidatecode.getInternalname(), "Values", cmbavOtpeventvalidatecode.ToJavascriptSource(), true);
      }
      AV63SiteURLCallbackIsCustom = GXutil.strtobool( GXutil.booltostr( AV63SiteURLCallbackIsCustom)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63SiteURLCallbackIsCustom", AV63SiteURLCallbackIsCustom);
      AV7AddUserAdditionalDataScope = GXutil.strtobool( GXutil.booltostr( AV7AddUserAdditionalDataScope)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AddUserAdditionalDataScope", AV7AddUserAdditionalDataScope);
      AV5AddInitialPropertiesScope = GXutil.strtobool( GXutil.booltostr( AV5AddInitialPropertiesScope)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5AddInitialPropertiesScope", AV5AddInitialPropertiesScope);
      AV21AutovalidateExternalTokenAndRefresh = GXutil.strtobool( GXutil.booltostr( AV21AutovalidateExternalTokenAndRefresh)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AutovalidateExternalTokenAndRefresh", AV21AutovalidateExternalTokenAndRefresh);
      if ( cmbavWsversion.getItemCount() > 0 )
      {
         AV80WSVersion = cmbavWsversion.getValidValue(AV80WSVersion) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80WSVersion", AV80WSVersion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavWsversion.setValue( GXutil.rtrim( AV80WSVersion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavWsversion.getInternalname(), "Values", cmbavWsversion.ToJavascriptSource(), true);
      }
      if ( cmbavWsserversecureprotocol.getItemCount() > 0 )
      {
         AV78WSServerSecureProtocol = (byte)(GXutil.lval( cmbavWsserversecureprotocol.getValidValue(GXutil.trim( GXutil.str( AV78WSServerSecureProtocol, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78WSServerSecureProtocol", GXutil.str( AV78WSServerSecureProtocol, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavWsserversecureprotocol.setValue( GXutil.trim( GXutil.str( AV78WSServerSecureProtocol, 1, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavWsserversecureprotocol.getInternalname(), "Values", cmbavWsserversecureprotocol.ToJavascriptSource(), true);
      }
      if ( cmbavCusversion.getItemCount() > 0 )
      {
         AV32CusVersion = cmbavCusversion.getValidValue(AV32CusVersion) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CusVersion", AV32CusVersion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCusversion.setValue( GXutil.rtrim( AV32CusVersion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavCusversion.getInternalname(), "Values", cmbavCusversion.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2Z2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rf2Z2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e172Z2 ();
         wb2Z0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2Z2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2Z0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112Z2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
         wcpOAV46Name = httpContext.cgiGet( sPrefix+"wcpOAV46Name") ;
         wcpOAV69TypeId = httpContext.cgiGet( sPrefix+"wcpOAV69TypeId") ;
         /* Read variables values. */
         if ( GXutil.len( sPrefix) == 0 )
         {
            AV46Name = httpContext.cgiGet( edtavName_Internalname) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
         }
         cmbavFunctionid.setValue( httpContext.cgiGet( cmbavFunctionid.getInternalname()) );
         AV37FunctionId = httpContext.cgiGet( cmbavFunctionid.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
         AV45IsEnable = GXutil.strtobool( httpContext.cgiGet( chkavIsenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
         AV33Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
         AV64SmallImageName = httpContext.cgiGet( edtavSmallimagename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
         AV22BigImageName = httpContext.cgiGet( edtavBigimagename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
         cmbavImpersonate.setValue( httpContext.cgiGet( cmbavImpersonate.getInternalname()) );
         AV44Impersonate = httpContext.cgiGet( cmbavImpersonate.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
         AV66TFAEnable = GXutil.strtobool( httpContext.cgiGet( chkavTfaenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFAEnable", AV66TFAEnable);
         cmbavTfaauthenticationtypename.setValue( httpContext.cgiGet( cmbavTfaauthenticationtypename.getInternalname()) );
         AV65TFAAuthenticationTypeName = httpContext.cgiGet( cmbavTfaauthenticationtypename.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTfafirstfactorauthenticationexpiration_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTfafirstfactorauthenticationexpiration_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION");
            GX_FocusControl = edtavTfafirstfactorauthenticationexpiration_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV67TFAFirstFactorAuthenticationExpiration = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         }
         else
         {
            AV67TFAFirstFactorAuthenticationExpiration = (int)(localUtil.ctol( httpContext.cgiGet( edtavTfafirstfactorauthenticationexpiration_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         }
         AV68TFAForceForAllUsers = GXutil.strtobool( httpContext.cgiGet( chkavTfaforceforallusers.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFAForceForAllUsers", AV68TFAForceForAllUsers);
         AV61OTPUseForFirstFactorAuthentication = GXutil.strtobool( httpContext.cgiGet( chkavOtpuseforfirstfactorauthentication.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61OTPUseForFirstFactorAuthentication", AV61OTPUseForFirstFactorAuthentication);
         cmbavOtpeventvalidateuser.setValue( httpContext.cgiGet( cmbavOtpeventvalidateuser.getInternalname()) );
         AV52OTPEventValidateUser = httpContext.cgiGet( cmbavOtpeventvalidateuser.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52OTPEventValidateUser", AV52OTPEventValidateUser);
         cmbavOtpgenerationtype.setValue( httpContext.cgiGet( cmbavOtpgenerationtype.getInternalname()) );
         AV54OTPGenerationType = httpContext.cgiGet( cmbavOtpgenerationtype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54OTPGenerationType", AV54OTPGenerationType);
         cmbavOtpgenerationtype_customeventgeneratecode.setValue( httpContext.cgiGet( cmbavOtpgenerationtype_customeventgeneratecode.getInternalname()) );
         AV55OTPGenerationType_CustomEventGenerateCode = httpContext.cgiGet( cmbavOtpgenerationtype_customeventgeneratecode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55OTPGenerationType_CustomEventGenerateCode", AV55OTPGenerationType_CustomEventGenerateCode);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpautogeneratedcodelength_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpautogeneratedcodelength_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPAUTOGENERATEDCODELENGTH");
            GX_FocusControl = edtavOtpautogeneratedcodelength_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV47OTPAutogeneratedCodeLength = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47OTPAutogeneratedCodeLength", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47OTPAutogeneratedCodeLength), 4, 0));
         }
         else
         {
            AV47OTPAutogeneratedCodeLength = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtpautogeneratedcodelength_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47OTPAutogeneratedCodeLength", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47OTPAutogeneratedCodeLength), 4, 0));
         }
         AV53OTPGenerateCodeOnlyNumbers = GXutil.strtobool( httpContext.cgiGet( chkavOtpgeneratecodeonlynumbers.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53OTPGenerateCodeOnlyNumbers", AV53OTPGenerateCodeOnlyNumbers);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpcodeexpirationtimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpcodeexpirationtimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPCODEEXPIRATIONTIMEOUT");
            GX_FocusControl = edtavOtpcodeexpirationtimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV49OTPCodeExpirationTimeout = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49OTPCodeExpirationTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49OTPCodeExpirationTimeout), 9, 0));
         }
         else
         {
            AV49OTPCodeExpirationTimeout = (int)(localUtil.ctol( httpContext.cgiGet( edtavOtpcodeexpirationtimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49OTPCodeExpirationTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49OTPCodeExpirationTimeout), 9, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpmaximumdailynumbercodes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpmaximumdailynumbercodes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPMAXIMUMDAILYNUMBERCODES");
            GX_FocusControl = edtavOtpmaximumdailynumbercodes_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV58OTPMaximumDailyNumberCodes = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58OTPMaximumDailyNumberCodes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58OTPMaximumDailyNumberCodes), 4, 0));
         }
         else
         {
            AV58OTPMaximumDailyNumberCodes = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtpmaximumdailynumbercodes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58OTPMaximumDailyNumberCodes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58OTPMaximumDailyNumberCodes), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpnumberunsuccessfulretriestolockotp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpnumberunsuccessfulretriestolockotp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPNUMBERUNSUCCESSFULRETRIESTOLOCKOTP");
            GX_FocusControl = edtavOtpnumberunsuccessfulretriestolockotp_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV60OTPNumberUnsuccessfulRetriesToLockOTP = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60OTPNumberUnsuccessfulRetriesToLockOTP", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60OTPNumberUnsuccessfulRetriesToLockOTP), 4, 0));
         }
         else
         {
            AV60OTPNumberUnsuccessfulRetriesToLockOTP = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtpnumberunsuccessfulretriestolockotp_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60OTPNumberUnsuccessfulRetriesToLockOTP", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60OTPNumberUnsuccessfulRetriesToLockOTP), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpautounlocktime_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpautounlocktime_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPAUTOUNLOCKTIME");
            GX_FocusControl = edtavOtpautounlocktime_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV48OTPAutoUnlockTime = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48OTPAutoUnlockTime", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48OTPAutoUnlockTime), 9, 0));
         }
         else
         {
            AV48OTPAutoUnlockTime = (int)(localUtil.ctol( httpContext.cgiGet( edtavOtpautounlocktime_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48OTPAutoUnlockTime", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48OTPAutoUnlockTime), 9, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPNUMBERUNSUCCESSFULRETRIESTOBLOCKUSERBASEDOFOTPLOCKS");
            GX_FocusControl = edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks), 4, 0));
         }
         else
         {
            AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks), 4, 0));
         }
         cmbavOtpeventsendcode.setValue( httpContext.cgiGet( cmbavOtpeventsendcode.getInternalname()) );
         AV50OTPEventSendCode = httpContext.cgiGet( cmbavOtpeventsendcode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50OTPEventSendCode", AV50OTPEventSendCode);
         AV57OTPMailMessageSubject = httpContext.cgiGet( edtavOtpmailmessagesubject_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57OTPMailMessageSubject", AV57OTPMailMessageSubject);
         AV56OTPMailMessageBodyHTML = httpContext.cgiGet( edtavOtpmailmessagebodyhtml_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56OTPMailMessageBodyHTML", AV56OTPMailMessageBodyHTML);
         cmbavOtpeventvalidatecode.setValue( httpContext.cgiGet( cmbavOtpeventvalidatecode.getInternalname()) );
         AV51OTPEventValidateCode = httpContext.cgiGet( cmbavOtpeventvalidatecode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51OTPEventValidateCode", AV51OTPEventValidateCode);
         AV24ClientId = httpContext.cgiGet( edtavClientid_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
         AV25ClientSecret = httpContext.cgiGet( edtavClientsecret_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
         AV70VersionPath = httpContext.cgiGet( edtavVersionpath_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70VersionPath", AV70VersionPath);
         AV62SiteURL = httpContext.cgiGet( edtavSiteurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62SiteURL", AV62SiteURL);
         AV63SiteURLCallbackIsCustom = GXutil.strtobool( httpContext.cgiGet( chkavSiteurlcallbackiscustom.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63SiteURLCallbackIsCustom", AV63SiteURLCallbackIsCustom);
         AV26ConsumerKey = httpContext.cgiGet( edtavConsumerkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConsumerKey", AV26ConsumerKey);
         AV27ConsumerSecret = httpContext.cgiGet( edtavConsumersecret_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConsumerSecret", AV27ConsumerSecret);
         AV23CallbackURL = httpContext.cgiGet( edtavCallbackurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CallbackURL", AV23CallbackURL);
         AV7AddUserAdditionalDataScope = GXutil.strtobool( httpContext.cgiGet( chkavAdduseradditionaldatascope.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AddUserAdditionalDataScope", AV7AddUserAdditionalDataScope);
         AV5AddInitialPropertiesScope = GXutil.strtobool( httpContext.cgiGet( chkavAddinitialpropertiesscope.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5AddInitialPropertiesScope", AV5AddInitialPropertiesScope);
         AV6AdditionalScope = httpContext.cgiGet( edtavAdditionalscope_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
         AV40GAMRAuthenticationTypeName = httpContext.cgiGet( edtavGamrauthenticationtypename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40GAMRAuthenticationTypeName", AV40GAMRAuthenticationTypeName);
         AV43GAMRServerURL = httpContext.cgiGet( edtavGamrserverurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43GAMRServerURL", AV43GAMRServerURL);
         AV41GAMRPrivateEncryptKey = httpContext.cgiGet( edtavGamrprivateencryptkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41GAMRPrivateEncryptKey", AV41GAMRPrivateEncryptKey);
         AV42GAMRRepositoryGUID = httpContext.cgiGet( edtavGamrrepositoryguid_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42GAMRRepositoryGUID", AV42GAMRRepositoryGUID);
         AV21AutovalidateExternalTokenAndRefresh = GXutil.strtobool( httpContext.cgiGet( chkavAutovalidateexternaltokenandrefresh.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AutovalidateExternalTokenAndRefresh", AV21AutovalidateExternalTokenAndRefresh);
         cmbavWsversion.setValue( httpContext.cgiGet( cmbavWsversion.getInternalname()) );
         AV80WSVersion = httpContext.cgiGet( cmbavWsversion.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80WSVersion", AV80WSVersion);
         AV74WSPrivateEncryptKey = httpContext.cgiGet( edtavWsprivateencryptkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74WSPrivateEncryptKey", AV74WSPrivateEncryptKey);
         AV76WSServerName = httpContext.cgiGet( edtavWsservername_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76WSServerName", AV76WSServerName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWsserverport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWsserverport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWSSERVERPORT");
            GX_FocusControl = edtavWsserverport_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV77WSServerPort = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77WSServerPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77WSServerPort), 5, 0));
         }
         else
         {
            AV77WSServerPort = (int)(localUtil.ctol( httpContext.cgiGet( edtavWsserverport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77WSServerPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77WSServerPort), 5, 0));
         }
         AV75WSServerBaseURL = httpContext.cgiGet( edtavWsserverbaseurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75WSServerBaseURL", AV75WSServerBaseURL);
         cmbavWsserversecureprotocol.setValue( httpContext.cgiGet( cmbavWsserversecureprotocol.getInternalname()) );
         AV78WSServerSecureProtocol = (byte)(GXutil.lval( httpContext.cgiGet( cmbavWsserversecureprotocol.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78WSServerSecureProtocol", GXutil.str( AV78WSServerSecureProtocol, 1, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavWstimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavWstimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vWSTIMEOUT");
            GX_FocusControl = edtavWstimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV79WSTimeout = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79WSTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79WSTimeout), 5, 0));
         }
         else
         {
            AV79WSTimeout = (int)(localUtil.ctol( httpContext.cgiGet( edtavWstimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79WSTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79WSTimeout), 5, 0));
         }
         AV73WSPackage = httpContext.cgiGet( edtavWspackage_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73WSPackage", AV73WSPackage);
         AV72WSName = httpContext.cgiGet( edtavWsname_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72WSName", AV72WSName);
         AV71WSExtension = httpContext.cgiGet( edtavWsextension_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71WSExtension", AV71WSExtension);
         cmbavCusversion.setValue( httpContext.cgiGet( cmbavCusversion.getInternalname()) );
         AV32CusVersion = httpContext.cgiGet( cmbavCusversion.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CusVersion", AV32CusVersion);
         AV31CusPrivateEncryptKey = httpContext.cgiGet( edtavCusprivateencryptkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31CusPrivateEncryptKey", AV31CusPrivateEncryptKey);
         AV29CusFileName = httpContext.cgiGet( edtavCusfilename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29CusFileName", AV29CusFileName);
         AV30CusPackage = httpContext.cgiGet( edtavCuspackage_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30CusPackage", AV30CusPackage);
         AV28CusClassName = httpContext.cgiGet( edtavCusclassname_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28CusClassName", AV28CusClassName);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e112Z2 ();
      if (returnInSub) return;
   }

   public void e112Z2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         edtavName_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
      }
      else
      {
         edtavName_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
         AV37FunctionId = "OnlyAuthentication" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      }
      if ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEAPPLE' */
         S112 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPECUSTOM' */
         S122 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEEXTERNALWEBSERVICE' */
         S132 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEFACEBOOK' */
         S142 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEGAMLOCAL' */
         S152 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEGAMREMOTE' */
         S162 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEGAMREMOTEREST' */
         S172 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "Google") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEGOOGLE' */
         S182 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "OTP") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEOTP' */
         S192 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPETWITTER' */
         S202 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 )
      {
         /* Execute user subroutine: 'INITAUTHENTICATIONTYPEWECHAT' */
         S212 ();
         if (returnInSub) return;
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
         cmbavFunctionid.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         bttBtngenkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtngenkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtngenkey_Visible), 5, 0), true);
         bttBtngenkeycustom_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtngenkeycustom_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtngenkeycustom_Visible), 5, 0), true);
         cmbavFunctionid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
         chkavIsenable.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIsenable.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsenable.getEnabled(), 5, 0), true);
         edtavDsc_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), true);
         edtavSmallimagename_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSmallimagename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSmallimagename_Enabled), 5, 0), true);
         edtavBigimagename_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavBigimagename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBigimagename_Enabled), 5, 0), true);
         cmbavImpersonate.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavImpersonate.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavImpersonate.getEnabled(), 5, 0), true);
         cmbavWsversion.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavWsversion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavWsversion.getEnabled(), 5, 0), true);
         edtavWsprivateencryptkey_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWsprivateencryptkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWsprivateencryptkey_Enabled), 5, 0), true);
         edtavWsservername_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWsservername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWsservername_Enabled), 5, 0), true);
         edtavWsserverport_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWsserverport_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWsserverport_Enabled), 5, 0), true);
         edtavWsserverbaseurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWsserverbaseurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWsserverbaseurl_Enabled), 5, 0), true);
         cmbavWsserversecureprotocol.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavWsserversecureprotocol.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavWsserversecureprotocol.getEnabled(), 5, 0), true);
         edtavWstimeout_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWstimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWstimeout_Enabled), 5, 0), true);
         edtavWspackage_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWspackage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWspackage_Enabled), 5, 0), true);
         edtavWsname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWsname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWsname_Enabled), 5, 0), true);
         edtavWsextension_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWsextension_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWsextension_Enabled), 5, 0), true);
         edtavClientid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClientid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientid_Enabled), 5, 0), true);
         edtavClientsecret_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClientsecret_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientsecret_Enabled), 5, 0), true);
         edtavVersionpath_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersionpath_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersionpath_Enabled), 5, 0), true);
         edtavSiteurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSiteurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSiteurl_Enabled), 5, 0), true);
         chkavSiteurlcallbackiscustom.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavSiteurlcallbackiscustom.getInternalname(), "Enabled", GXutil.ltrimstr( chkavSiteurlcallbackiscustom.getEnabled(), 5, 0), true);
         edtavConsumerkey_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConsumerkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumerkey_Enabled), 5, 0), true);
         edtavConsumersecret_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConsumersecret_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumersecret_Enabled), 5, 0), true);
         edtavCallbackurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCallbackurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCallbackurl_Enabled), 5, 0), true);
         cmbavCusversion.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavCusversion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCusversion.getEnabled(), 5, 0), true);
         edtavCusprivateencryptkey_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCusprivateencryptkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCusprivateencryptkey_Enabled), 5, 0), true);
         edtavCusfilename_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCusfilename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCusfilename_Enabled), 5, 0), true);
         edtavCuspackage_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCuspackage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCuspackage_Enabled), 5, 0), true);
         edtavCusclassname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCusclassname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCusclassname_Enabled), 5, 0), true);
         chkavAdduseradditionaldatascope.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAdduseradditionaldatascope.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAdduseradditionaldatascope.getEnabled(), 5, 0), true);
         chkavAddinitialpropertiesscope.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAddinitialpropertiesscope.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAddinitialpropertiesscope.getEnabled(), 5, 0), true);
         edtavAdditionalscope_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAdditionalscope_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdditionalscope_Enabled), 5, 0), true);
         edtavGamrauthenticationtypename_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrauthenticationtypename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrauthenticationtypename_Enabled), 5, 0), true);
         edtavGamrserverurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrserverurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrserverurl_Enabled), 5, 0), true);
         edtavGamrprivateencryptkey_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrprivateencryptkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrprivateencryptkey_Enabled), 5, 0), true);
         edtavGamrrepositoryguid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrrepositoryguid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrrepositoryguid_Enabled), 5, 0), true);
         chkavAutovalidateexternaltokenandrefresh.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAutovalidateexternaltokenandrefresh.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAutovalidateexternaltokenandrefresh.getEnabled(), 5, 0), true);
         chkavOtpuseforfirstfactorauthentication.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOtpuseforfirstfactorauthentication.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOtpuseforfirstfactorauthentication.getEnabled(), 5, 0), true);
         chkavTfaenable.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaenable.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTfaenable.getEnabled(), 5, 0), true);
         cmbavTfaauthenticationtypename.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTfaauthenticationtypename.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTfaauthenticationtypename.getEnabled(), 5, 0), true);
         edtavTfafirstfactorauthenticationexpiration_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTfafirstfactorauthenticationexpiration_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTfafirstfactorauthenticationexpiration_Enabled), 5, 0), true);
         chkavTfaforceforallusers.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaforceforallusers.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTfaforceforallusers.getEnabled(), 5, 0), true);
         cmbavOtpeventvalidateuser.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventvalidateuser.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOtpeventvalidateuser.getEnabled(), 5, 0), true);
         cmbavOtpgenerationtype.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOtpgenerationtype.getEnabled(), 5, 0), true);
         cmbavOtpgenerationtype_customeventgeneratecode.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOtpgenerationtype_customeventgeneratecode.getEnabled(), 5, 0), true);
         edtavOtpcodeexpirationtimeout_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpcodeexpirationtimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpcodeexpirationtimeout_Enabled), 5, 0), true);
         edtavOtpmaximumdailynumbercodes_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpmaximumdailynumbercodes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpmaximumdailynumbercodes_Enabled), 5, 0), true);
         edtavOtpautogeneratedcodelength_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpautogeneratedcodelength_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpautogeneratedcodelength_Enabled), 5, 0), true);
         chkavOtpgeneratecodeonlynumbers.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOtpgeneratecodeonlynumbers.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOtpgeneratecodeonlynumbers.getEnabled(), 5, 0), true);
         edtavOtpnumberunsuccessfulretriestolockotp_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpnumberunsuccessfulretriestolockotp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberunsuccessfulretriestolockotp_Enabled), 5, 0), true);
         edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Enabled), 5, 0), true);
         edtavOtpautounlocktime_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpautounlocktime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpautounlocktime_Enabled), 5, 0), true);
         cmbavOtpeventsendcode.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventsendcode.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOtpeventsendcode.getEnabled(), 5, 0), true);
         edtavOtpmailmessagesubject_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpmailmessagesubject_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpmailmessagesubject_Enabled), 5, 0), true);
         edtavOtpmailmessagebodyhtml_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpmailmessagebodyhtml_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpmailmessagebodyhtml_Enabled), 5, 0), true);
         cmbavOtpeventvalidatecode.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpeventvalidatecode.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOtpeventvalidatecode.getEnabled(), 5, 0), true);
         bttBtnenter_Caption = httpContext.getMessage( "WWP_GAM_Delete", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
      }
      /* Execute user subroutine: 'REFRESHAUTHENTICATIONTYPE' */
      S222 ();
      if (returnInSub) return;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S232 ();
      if (returnInSub) return;
   }

   public void e122Z2( )
   {
      /* 'DoGenKeyCustom' Routine */
      returnInSub = false ;
      AV31CusPrivateEncryptKey = com.genexus.util.Encryption.getNewKey( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31CusPrivateEncryptKey", AV31CusPrivateEncryptKey);
      /*  Sending Event outputs  */
   }

   public void e132Z2( )
   {
      /* 'DoGenKey' Routine */
      returnInSub = false ;
      AV74WSPrivateEncryptKey = com.genexus.util.Encryption.getNewKey( ) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74WSPrivateEncryptKey", AV74WSPrivateEncryptKey);
      /*  Sending Event outputs  */
   }

   public void S242( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV83CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV46Name)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Name", ""), "", "", "", "", "", "", "", ""), "error", edtavName_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) && (GXutil.strcmp("", AV24ClientId)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_ClientId", ""), "", "", "", "", "", "", "", ""), "error", edtavClientid_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) && (GXutil.strcmp("", AV25ClientSecret)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_ClientSecret", ""), "", "", "", "", "", "", "", ""), "error", edtavClientsecret_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) ) && (GXutil.strcmp("", AV62SiteURL)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_LocalSiteURL", ""), "", "", "", "", "", "", "", ""), "error", edtavSiteurl_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) && (GXutil.strcmp("", AV43GAMRServerURL)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_RemoteServerURL", ""), "", "", "", "", "", "", "", ""), "error", edtavGamrserverurl_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) ) && (GXutil.strcmp("", AV76WSServerName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Servername", ""), "", "", "", "", "", "", "", ""), "error", edtavWsservername_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) ) && (0==AV77WSServerPort) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Serverport", ""), "", "", "", "", "", "", "", ""), "error", edtavWsserverport_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) ) && (GXutil.strcmp("", AV72WSName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_WebServiceName", ""), "", "", "", "", "", "", "", ""), "error", edtavWsname_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "Custom") == 0 ) ) && (GXutil.strcmp("", AV29CusFileName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_FileName", ""), "", "", "", "", "", "", "", ""), "error", edtavCusfilename_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
      if ( ( ( GXutil.strcmp(AV69TypeId, "Custom") == 0 ) ) && (GXutil.strcmp("", AV28CusClassName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_ClassName", ""), "", "", "", "", "", "", "", ""), "error", edtavCusclassname_Internalname, "true", ""));
         AV83CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83CheckRequiredFieldsResult", AV83CheckRequiredFieldsResult);
      }
   }

   public void S232( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ! ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 ) ) )
      {
         cmbavImpersonate.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavImpersonate.getInternalname(), "Visible", GXutil.ltrimstr( cmbavImpersonate.getVisible(), 5, 0), true);
         divImpersonate_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divImpersonate_cell_Internalname, "Class", divImpersonate_cell_Class, true);
      }
      else
      {
         cmbavImpersonate.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavImpersonate.getInternalname(), "Visible", GXutil.ltrimstr( cmbavImpersonate.getVisible(), 5, 0), true);
         divImpersonate_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divImpersonate_cell_Internalname, "Class", divImpersonate_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) || ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Custom") == 0 ) ) )
      {
         chkavTfaenable.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaenable.getInternalname(), "Visible", GXutil.ltrimstr( chkavTfaenable.getVisible(), 5, 0), true);
         divTfaenable_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfaenable_cell_Internalname, "Class", divTfaenable_cell_Class, true);
      }
      else
      {
         chkavTfaenable.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaenable.getInternalname(), "Visible", GXutil.ltrimstr( chkavTfaenable.getVisible(), 5, 0), true);
         divTfaenable_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfaenable_cell_Internalname, "Class", divTfaenable_cell_Class, true);
      }
      if ( ! ( ( ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) || ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Custom") == 0 ) ) && AV66TFAEnable ) )
      {
         cmbavTfaauthenticationtypename.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTfaauthenticationtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavTfaauthenticationtypename.getVisible(), 5, 0), true);
         divTfaauthenticationtypename_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfaauthenticationtypename_cell_Internalname, "Class", divTfaauthenticationtypename_cell_Class, true);
      }
      else
      {
         cmbavTfaauthenticationtypename.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTfaauthenticationtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavTfaauthenticationtypename.getVisible(), 5, 0), true);
         divTfaauthenticationtypename_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfaauthenticationtypename_cell_Internalname, "Class", divTfaauthenticationtypename_cell_Class, true);
      }
      if ( ! ( ( ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) || ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Custom") == 0 ) ) && AV66TFAEnable ) )
      {
         edtavTfafirstfactorauthenticationexpiration_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTfafirstfactorauthenticationexpiration_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTfafirstfactorauthenticationexpiration_Visible), 5, 0), true);
         divTfafirstfactorauthenticationexpiration_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfafirstfactorauthenticationexpiration_cell_Internalname, "Class", divTfafirstfactorauthenticationexpiration_cell_Class, true);
      }
      else
      {
         edtavTfafirstfactorauthenticationexpiration_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTfafirstfactorauthenticationexpiration_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTfafirstfactorauthenticationexpiration_Visible), 5, 0), true);
         divTfafirstfactorauthenticationexpiration_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfafirstfactorauthenticationexpiration_cell_Internalname, "Class", divTfafirstfactorauthenticationexpiration_cell_Class, true);
      }
      if ( ! ( ( ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) || ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Custom") == 0 ) ) && AV66TFAEnable ) )
      {
         chkavTfaforceforallusers.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaforceforallusers.getInternalname(), "Visible", GXutil.ltrimstr( chkavTfaforceforallusers.getVisible(), 5, 0), true);
         divTfaforceforallusers_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfaforceforallusers_cell_Internalname, "Class", divTfaforceforallusers_cell_Class, true);
      }
      else
      {
         chkavTfaforceforallusers.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaforceforallusers.getInternalname(), "Visible", GXutil.ltrimstr( chkavTfaforceforallusers.getVisible(), 5, 0), true);
         divTfaforceforallusers_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTfaforceforallusers_cell_Internalname, "Class", divTfaforceforallusers_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         edtavClientid_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClientid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientid_Visible), 5, 0), true);
         divClientid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divClientid_cell_Internalname, "Class", divClientid_cell_Class, true);
      }
      else
      {
         edtavClientid_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClientid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientid_Visible), 5, 0), true);
         divClientid_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divClientid_cell_Internalname, "Class", divClientid_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         edtavClientsecret_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClientsecret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientsecret_Visible), 5, 0), true);
         divClientsecret_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divClientsecret_cell_Internalname, "Class", divClientsecret_cell_Class, true);
      }
      else
      {
         edtavClientsecret_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavClientsecret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientsecret_Visible), 5, 0), true);
         divClientsecret_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divClientsecret_cell_Internalname, "Class", divClientsecret_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         edtavVersionpath_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersionpath_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersionpath_Visible), 5, 0), true);
         divVersionpath_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divVersionpath_cell_Internalname, "Class", divVersionpath_cell_Class, true);
      }
      else
      {
         edtavVersionpath_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersionpath_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersionpath_Visible), 5, 0), true);
         divVersionpath_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divVersionpath_cell_Internalname, "Class", divVersionpath_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) ) )
      {
         edtavSiteurl_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSiteurl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSiteurl_Visible), 5, 0), true);
         divSiteurl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSiteurl_cell_Internalname, "Class", divSiteurl_cell_Class, true);
      }
      else
      {
         edtavSiteurl_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSiteurl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSiteurl_Visible), 5, 0), true);
         divSiteurl_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSiteurl_cell_Internalname, "Class", divSiteurl_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) ) )
      {
         chkavSiteurlcallbackiscustom.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavSiteurlcallbackiscustom.getInternalname(), "Visible", GXutil.ltrimstr( chkavSiteurlcallbackiscustom.getVisible(), 5, 0), true);
         divSiteurlcallbackiscustom_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSiteurlcallbackiscustom_cell_Internalname, "Class", divSiteurlcallbackiscustom_cell_Class, true);
      }
      else
      {
         chkavSiteurlcallbackiscustom.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavSiteurlcallbackiscustom.getInternalname(), "Visible", GXutil.ltrimstr( chkavSiteurlcallbackiscustom.getVisible(), 5, 0), true);
         divSiteurlcallbackiscustom_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSiteurlcallbackiscustom_cell_Internalname, "Class", divSiteurlcallbackiscustom_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 ) ) )
      {
         edtavConsumerkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConsumerkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumerkey_Visible), 5, 0), true);
         divConsumerkey_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConsumerkey_cell_Internalname, "Class", divConsumerkey_cell_Class, true);
      }
      else
      {
         edtavConsumerkey_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConsumerkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumerkey_Visible), 5, 0), true);
         divConsumerkey_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConsumerkey_cell_Internalname, "Class", divConsumerkey_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 ) ) )
      {
         edtavConsumersecret_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConsumersecret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumersecret_Visible), 5, 0), true);
         divConsumersecret_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConsumersecret_cell_Internalname, "Class", divConsumersecret_cell_Class, true);
      }
      else
      {
         edtavConsumersecret_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavConsumersecret_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConsumersecret_Visible), 5, 0), true);
         divConsumersecret_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divConsumersecret_cell_Internalname, "Class", divConsumersecret_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 ) ) )
      {
         edtavCallbackurl_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCallbackurl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCallbackurl_Visible), 5, 0), true);
         divCallbackurl_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCallbackurl_cell_Internalname, "Class", divCallbackurl_cell_Class, true);
      }
      else
      {
         edtavCallbackurl_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavCallbackurl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCallbackurl_Visible), 5, 0), true);
         divCallbackurl_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCallbackurl_cell_Internalname, "Class", divCallbackurl_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         chkavAdduseradditionaldatascope.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAdduseradditionaldatascope.getInternalname(), "Visible", GXutil.ltrimstr( chkavAdduseradditionaldatascope.getVisible(), 5, 0), true);
         divAdduseradditionaldatascope_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divAdduseradditionaldatascope_cell_Internalname, "Class", divAdduseradditionaldatascope_cell_Class, true);
      }
      else
      {
         chkavAdduseradditionaldatascope.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAdduseradditionaldatascope.getInternalname(), "Visible", GXutil.ltrimstr( chkavAdduseradditionaldatascope.getVisible(), 5, 0), true);
         divAdduseradditionaldatascope_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divAdduseradditionaldatascope_cell_Internalname, "Class", divAdduseradditionaldatascope_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         chkavAddinitialpropertiesscope.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAddinitialpropertiesscope.getInternalname(), "Visible", GXutil.ltrimstr( chkavAddinitialpropertiesscope.getVisible(), 5, 0), true);
         divAddinitialpropertiesscope_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divAddinitialpropertiesscope_cell_Internalname, "Class", divAddinitialpropertiesscope_cell_Class, true);
      }
      else
      {
         chkavAddinitialpropertiesscope.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAddinitialpropertiesscope.getInternalname(), "Visible", GXutil.ltrimstr( chkavAddinitialpropertiesscope.getVisible(), 5, 0), true);
         divAddinitialpropertiesscope_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divAddinitialpropertiesscope_cell_Internalname, "Class", divAddinitialpropertiesscope_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         edtavAdditionalscope_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAdditionalscope_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdditionalscope_Visible), 5, 0), true);
         divAdditionalscope_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divAdditionalscope_cell_Internalname, "Class", divAdditionalscope_cell_Class, true);
      }
      else
      {
         edtavAdditionalscope_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAdditionalscope_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdditionalscope_Visible), 5, 0), true);
         divAdditionalscope_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divAdditionalscope_cell_Internalname, "Class", divAdditionalscope_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) ) )
      {
         edtavGamrauthenticationtypename_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrauthenticationtypename_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrauthenticationtypename_Visible), 5, 0), true);
         divGamrauthenticationtypename_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrauthenticationtypename_cell_Internalname, "Class", divGamrauthenticationtypename_cell_Class, true);
      }
      else
      {
         edtavGamrauthenticationtypename_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrauthenticationtypename_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrauthenticationtypename_Visible), 5, 0), true);
         divGamrauthenticationtypename_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrauthenticationtypename_cell_Internalname, "Class", divGamrauthenticationtypename_cell_Class, true);
      }
      if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
      {
         divCusfilename_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCusfilename_cell_Internalname, "Class", divCusfilename_cell_Class, true);
      }
      else
      {
         divCusfilename_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCusfilename_cell_Internalname, "Class", divCusfilename_cell_Class, true);
      }
      if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
      {
         divCusclassname_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCusclassname_cell_Internalname, "Class", divCusclassname_cell_Class, true);
      }
      else
      {
         divCusclassname_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divCusclassname_cell_Internalname, "Class", divCusclassname_cell_Class, true);
      }
      if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
      {
         divWsservername_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divWsservername_cell_Internalname, "Class", divWsservername_cell_Class, true);
      }
      else
      {
         divWsservername_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divWsservername_cell_Internalname, "Class", divWsservername_cell_Class, true);
      }
      if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
      {
         divWsserverport_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divWsserverport_cell_Internalname, "Class", divWsserverport_cell_Class, true);
      }
      else
      {
         divWsserverport_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divWsserverport_cell_Internalname, "Class", divWsserverport_cell_Class, true);
      }
      if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
      {
         divWsname_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divWsname_cell_Internalname, "Class", divWsname_cell_Class, true);
      }
      else
      {
         divWsname_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divWsname_cell_Internalname, "Class", divWsname_cell_Class, true);
      }
      if ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 ) )
      {
         divGamrserverurl_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrserverurl_cell_Internalname, "Class", divGamrserverurl_cell_Class, true);
      }
      else
      {
         divGamrserverurl_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrserverurl_cell_Internalname, "Class", divGamrserverurl_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) ) )
      {
         edtavGamrprivateencryptkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrprivateencryptkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrprivateencryptkey_Visible), 5, 0), true);
         divGamrprivateencryptkey_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrprivateencryptkey_cell_Internalname, "Class", divGamrprivateencryptkey_cell_Class, true);
      }
      else
      {
         edtavGamrprivateencryptkey_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrprivateencryptkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrprivateencryptkey_Visible), 5, 0), true);
         divGamrprivateencryptkey_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrprivateencryptkey_cell_Internalname, "Class", divGamrprivateencryptkey_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) ) )
      {
         edtavGamrrepositoryguid_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrrepositoryguid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrrepositoryguid_Visible), 5, 0), true);
         divGamrrepositoryguid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrrepositoryguid_cell_Internalname, "Class", divGamrrepositoryguid_cell_Class, true);
      }
      else
      {
         edtavGamrrepositoryguid_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGamrrepositoryguid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamrrepositoryguid_Visible), 5, 0), true);
         divGamrrepositoryguid_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divGamrrepositoryguid_cell_Internalname, "Class", divGamrrepositoryguid_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "OTP") == 0 ) && ( GXutil.strcmp(AV54OTPGenerationType, "custom") == 0 ) ) )
      {
         cmbavOtpgenerationtype_customeventgeneratecode.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), "Visible", GXutil.ltrimstr( cmbavOtpgenerationtype_customeventgeneratecode.getVisible(), 5, 0), true);
         divOtpgenerationtype_customeventgeneratecode_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOtpgenerationtype_customeventgeneratecode_cell_Internalname, "Class", divOtpgenerationtype_customeventgeneratecode_cell_Class, true);
      }
      else
      {
         cmbavOtpgenerationtype_customeventgeneratecode.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), "Visible", GXutil.ltrimstr( cmbavOtpgenerationtype_customeventgeneratecode.getVisible(), 5, 0), true);
         divOtpgenerationtype_customeventgeneratecode_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOtpgenerationtype_customeventgeneratecode_cell_Internalname, "Class", divOtpgenerationtype_customeventgeneratecode_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "OTP") == 0 ) && ( GXutil.strcmp(AV54OTPGenerationType, "gam") == 0 ) ) )
      {
         edtavOtpautogeneratedcodelength_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpautogeneratedcodelength_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpautogeneratedcodelength_Visible), 5, 0), true);
         divOtpautogeneratedcodelength_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOtpautogeneratedcodelength_cell_Internalname, "Class", divOtpautogeneratedcodelength_cell_Class, true);
      }
      else
      {
         edtavOtpautogeneratedcodelength_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOtpautogeneratedcodelength_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpautogeneratedcodelength_Visible), 5, 0), true);
         divOtpautogeneratedcodelength_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOtpautogeneratedcodelength_cell_Internalname, "Class", divOtpautogeneratedcodelength_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV69TypeId, "OTP") == 0 ) && ( GXutil.strcmp(AV54OTPGenerationType, "gam") == 0 ) ) )
      {
         chkavOtpgeneratecodeonlynumbers.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOtpgeneratecodeonlynumbers.getInternalname(), "Visible", GXutil.ltrimstr( chkavOtpgeneratecodeonlynumbers.getVisible(), 5, 0), true);
         divOtpgeneratecodeonlynumbers_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOtpgeneratecodeonlynumbers_cell_Internalname, "Class", divOtpgeneratecodeonlynumbers_cell_Class, true);
      }
      else
      {
         chkavOtpgeneratecodeonlynumbers.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOtpgeneratecodeonlynumbers.getInternalname(), "Visible", GXutil.ltrimstr( chkavOtpgeneratecodeonlynumbers.getVisible(), 5, 0), true);
         divOtpgeneratecodeonlynumbers_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divOtpgeneratecodeonlynumbers_cell_Internalname, "Class", divOtpgeneratecodeonlynumbers_cell_Class, true);
      }
      divTblsendandvalidateotpcode_Visible = (((GXutil.strcmp(AV69TypeId, "OTP")==0)&&((GXutil.strcmp(AV54OTPGenerationType, "custom")==0)||(GXutil.strcmp(AV54OTPGenerationType, "gam")==0))) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblsendandvalidateotpcode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblsendandvalidateotpcode_Visible), 5, 0), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e142Z2 ();
      if (returnInSub) return;
   }

   public void e142Z2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S242 ();
      if (returnInSub) return;
      if ( AV83CheckRequiredFieldsResult )
      {
         new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).clearlasterrors() ;
         if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
         {
            if ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV15AuthenticationTypeLocal.load(AV46Name);
               }
               AV15AuthenticationTypeLocal.setgxTv_SdtGAMAuthenticationTypeLocal_Name( AV46Name );
               AV15AuthenticationTypeLocal.setgxTv_SdtGAMAuthenticationTypeLocal_Functionid( AV37FunctionId );
               AV15AuthenticationTypeLocal.setgxTv_SdtGAMAuthenticationTypeLocal_Isenable( AV45IsEnable );
               AV15AuthenticationTypeLocal.setgxTv_SdtGAMAuthenticationTypeLocal_Description( AV33Dsc );
               AV15AuthenticationTypeLocal.setgxTv_SdtGAMAuthenticationTypeLocal_Smallimagename( AV64SmallImageName );
               AV15AuthenticationTypeLocal.setgxTv_SdtGAMAuthenticationTypeLocal_Bigimagename( AV22BigImageName );
               AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Enable( AV66TFAEnable );
               if ( AV66TFAEnable )
               {
                  AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename( GXutil.trim( AV65TFAAuthenticationTypeName) );
                  AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration( AV67TFAFirstFactorAuthenticationExpiration );
                  AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers( AV68TFAForceForAllUsers );
               }
               AV15AuthenticationTypeLocal.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV9AuthenticationTypeApple.load(AV46Name);
               }
               AV9AuthenticationTypeApple.setgxTv_SdtGAMAuthenticationTypeApple_Name( AV46Name );
               AV9AuthenticationTypeApple.setgxTv_SdtGAMAuthenticationTypeApple_Isenable( AV45IsEnable );
               AV9AuthenticationTypeApple.setgxTv_SdtGAMAuthenticationTypeApple_Description( AV33Dsc );
               AV9AuthenticationTypeApple.setgxTv_SdtGAMAuthenticationTypeApple_Smallimagename( AV64SmallImageName );
               AV9AuthenticationTypeApple.setgxTv_SdtGAMAuthenticationTypeApple_Bigimagename( AV22BigImageName );
               AV9AuthenticationTypeApple.setgxTv_SdtGAMAuthenticationTypeApple_Impersonate( AV44Impersonate );
               AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().setgxTv_SdtGAMAuthenticationApple_Clientid( AV24ClientId );
               AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().setgxTv_SdtGAMAuthenticationApple_Clientsecret( AV25ClientSecret );
               AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().setgxTv_SdtGAMAuthenticationApple_Siteurl( AV62SiteURL );
               AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().setgxTv_SdtGAMAuthenticationApple_Additionalscope( AV6AdditionalScope );
               AV9AuthenticationTypeApple.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV10AuthenticationTypeCustom.load(AV46Name);
               }
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Name( AV46Name );
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Functionid( AV37FunctionId );
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Isenable( AV45IsEnable );
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Description( AV33Dsc );
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Smallimagename( AV64SmallImageName );
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Bigimagename( AV22BigImageName );
               AV10AuthenticationTypeCustom.setgxTv_SdtGAMAuthenticationTypeCustom_Impersonate( AV44Impersonate );
               AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Enable( AV66TFAEnable );
               if ( AV66TFAEnable )
               {
                  AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename( AV65TFAAuthenticationTypeName );
                  AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration( AV67TFAFirstFactorAuthenticationExpiration );
                  AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers( AV68TFAForceForAllUsers );
               }
               AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().setgxTv_SdtGAMAuthenticationCustom_Version( AV32CusVersion );
               AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().setgxTv_SdtGAMAuthenticationCustom_Privateencryptkey( AV31CusPrivateEncryptKey );
               AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().setgxTv_SdtGAMAuthenticationCustom_Filename( AV29CusFileName );
               AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().setgxTv_SdtGAMAuthenticationCustom_Package( AV30CusPackage );
               AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().setgxTv_SdtGAMAuthenticationCustom_Classname( AV28CusClassName );
               AV10AuthenticationTypeCustom.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV19AuthenticationTypeWebService.load(AV46Name);
               }
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Name( AV46Name );
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Functionid( AV37FunctionId );
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Isenable( AV45IsEnable );
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Description( AV33Dsc );
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Smallimagename( AV64SmallImageName );
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Bigimagename( AV22BigImageName );
               AV19AuthenticationTypeWebService.setgxTv_SdtGAMAuthenticationTypeWebService_Impersonate( AV44Impersonate );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Enable( AV66TFAEnable );
               if ( AV66TFAEnable )
               {
                  AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename( AV65TFAAuthenticationTypeName );
                  AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration( AV67TFAFirstFactorAuthenticationExpiration );
                  AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers( AV68TFAForceForAllUsers );
               }
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().setgxTv_SdtGAMAuthenticationWebService_Version( AV80WSVersion );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().setgxTv_SdtGAMAuthenticationWebService_Privateencryptkey( AV74WSPrivateEncryptKey );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().setgxTv_SdtGAMAuthenticationWebService_Timeout( AV79WSTimeout );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().setgxTv_SdtGAMAuthenticationWebService_Package( AV73WSPackage );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().setgxTv_SdtGAMAuthenticationWebService_Name( AV72WSName );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().setgxTv_SdtGAMAuthenticationWebService_Extension( AV71WSExtension );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().setgxTv_SdtGAMAuthenticationWebServiceServer_Name( AV76WSServerName );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().setgxTv_SdtGAMAuthenticationWebServiceServer_Port( AV77WSServerPort );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().setgxTv_SdtGAMAuthenticationWebServiceServer_Baseurl( AV75WSServerBaseURL );
               AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().setgxTv_SdtGAMAuthenticationWebServiceServer_Secureprotocol( AV78WSServerSecureProtocol );
               AV19AuthenticationTypeWebService.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV11AuthenticationTypeFacebook.load(AV46Name);
               }
               AV11AuthenticationTypeFacebook.setgxTv_SdtGAMAuthenticationTypeFacebook_Name( AV46Name );
               AV11AuthenticationTypeFacebook.setgxTv_SdtGAMAuthenticationTypeFacebook_Isenable( AV45IsEnable );
               AV11AuthenticationTypeFacebook.setgxTv_SdtGAMAuthenticationTypeFacebook_Description( AV33Dsc );
               AV11AuthenticationTypeFacebook.setgxTv_SdtGAMAuthenticationTypeFacebook_Smallimagename( AV64SmallImageName );
               AV11AuthenticationTypeFacebook.setgxTv_SdtGAMAuthenticationTypeFacebook_Bigimagename( AV22BigImageName );
               AV11AuthenticationTypeFacebook.setgxTv_SdtGAMAuthenticationTypeFacebook_Impersonate( AV44Impersonate );
               AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().setgxTv_SdtGAMAuthenticationFacebook_Clientid( AV24ClientId );
               AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().setgxTv_SdtGAMAuthenticationFacebook_Clientsecret( AV25ClientSecret );
               AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().setgxTv_SdtGAMAuthenticationFacebook_Versionpath( AV70VersionPath );
               AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().setgxTv_SdtGAMAuthenticationFacebook_Siteurl( AV62SiteURL );
               AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().setgxTv_SdtGAMAuthenticationFacebook_Additionalscope( AV6AdditionalScope );
               AV11AuthenticationTypeFacebook.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV12AuthenticationTypeGAMRemote.load(AV46Name);
               }
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Name( AV46Name );
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Functionid( AV37FunctionId );
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Isenable( AV45IsEnable );
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Description( AV33Dsc );
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Smallimagename( AV64SmallImageName );
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Bigimagename( AV22BigImageName );
               AV12AuthenticationTypeGAMRemote.setgxTv_SdtGAMAuthenticationTypeGAMRemote_Impersonate( AV44Impersonate );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Clientid( AV24ClientId );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Clientsecret( AV25ClientSecret );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Siteurl( AV62SiteURL );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Siteurlcallbackiscustom( AV63SiteURLCallbackIsCustom );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Addsessioninitialpropertiesscope( AV5AddInitialPropertiesScope );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Adduseradditionaldatascope( AV7AddUserAdditionalDataScope );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Additionalscope( AV6AdditionalScope );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Remoteserverurl( AV43GAMRServerURL );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Remoteserverkey( AV41GAMRPrivateEncryptKey );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Remoterepositoryguid( AV42GAMRRepositoryGUID );
               AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().setgxTv_SdtGAMAuthenticationGAMRemote_Autovalidateexternaltokenandrefresh( AV21AutovalidateExternalTokenAndRefresh );
               AV12AuthenticationTypeGAMRemote.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV13AuthenticationTypeGAMRemoteRest.load(AV46Name);
               }
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Name( AV46Name );
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Functionid( AV37FunctionId );
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Isenable( AV45IsEnable );
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Description( AV33Dsc );
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Smallimagename( AV64SmallImageName );
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Bigimagename( AV22BigImageName );
               AV13AuthenticationTypeGAMRemoteRest.setgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Impersonate( AV44Impersonate );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Enable( AV66TFAEnable );
               if ( AV66TFAEnable )
               {
                  AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename( AV65TFAAuthenticationTypeName );
                  AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration( AV67TFAFirstFactorAuthenticationExpiration );
                  AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().setgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers( AV68TFAForceForAllUsers );
               }
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Clientid( AV24ClientId );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Clientsecret( AV25ClientSecret );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Versionpath( AV70VersionPath );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Addsessioninitialpropertiesscope( AV5AddInitialPropertiesScope );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Adduseradditionaldatascope( AV7AddUserAdditionalDataScope );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Additionalscope( AV6AdditionalScope );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoteauthenticationtypename( AV40GAMRAuthenticationTypeName );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoteserverurl( AV43GAMRServerURL );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoteserverkey( AV41GAMRPrivateEncryptKey );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoterepositoryguid( AV42GAMRRepositoryGUID );
               AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().setgxTv_SdtGAMAuthenticationGAMRemoteRest_Autovalidateexternaltokenandrefresh( AV21AutovalidateExternalTokenAndRefresh );
               AV13AuthenticationTypeGAMRemoteRest.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Google") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV14AuthenticationTypeGoogle.load(AV46Name);
               }
               AV14AuthenticationTypeGoogle.setgxTv_SdtGAMAuthenticationTypeGoogle_Name( AV46Name );
               AV14AuthenticationTypeGoogle.setgxTv_SdtGAMAuthenticationTypeGoogle_Isenable( AV45IsEnable );
               AV14AuthenticationTypeGoogle.setgxTv_SdtGAMAuthenticationTypeGoogle_Description( AV33Dsc );
               AV14AuthenticationTypeGoogle.setgxTv_SdtGAMAuthenticationTypeGoogle_Smallimagename( AV64SmallImageName );
               AV14AuthenticationTypeGoogle.setgxTv_SdtGAMAuthenticationTypeGoogle_Bigimagename( AV22BigImageName );
               AV14AuthenticationTypeGoogle.setgxTv_SdtGAMAuthenticationTypeGoogle_Impersonate( AV44Impersonate );
               AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().setgxTv_SdtGAMAuthenticationGoogle_Clientid( AV24ClientId );
               AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().setgxTv_SdtGAMAuthenticationGoogle_Clientsecret( AV25ClientSecret );
               AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().setgxTv_SdtGAMAuthenticationGoogle_Versionpath( AV70VersionPath );
               AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().setgxTv_SdtGAMAuthenticationGoogle_Siteurl( AV62SiteURL );
               AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().setgxTv_SdtGAMAuthenticationGoogle_Additionalscope( AV6AdditionalScope );
               AV14AuthenticationTypeGoogle.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "OTP") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV17AuthenticationTypeOTP.load(AV46Name);
               }
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Name( AV46Name );
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Isenable( AV45IsEnable );
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Description( AV33Dsc );
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Smallimagename( AV64SmallImageName );
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Bigimagename( AV22BigImageName );
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Impersonate( AV44Impersonate );
               AV17AuthenticationTypeOTP.setgxTv_SdtGAMAuthenticationTypeOTP_Useforfirstfactorauthentication( AV61OTPUseForFirstFactorAuthentication );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Eventvaliduser( AV52OTPEventValidateUser );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Generationtype( AV54OTPGenerationType );
               if ( GXutil.strcmp(AV54OTPGenerationType, "custom") == 0 )
               {
                  AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Generationtype_customeventgeneratecode( AV55OTPGenerationType_CustomEventGenerateCode );
               }
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Codeexpirationtimeout( AV49OTPCodeExpirationTimeout );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Maximumdailynumbercodes( AV58OTPMaximumDailyNumberCodes );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Autogeneratedcodelength( (byte)(AV47OTPAutogeneratedCodeLength) );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Generatecodeonlynumbers( AV53OTPGenerateCodeOnlyNumbers );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Numberunsuccessfulretriestolockotp( AV60OTPNumberUnsuccessfulRetriesToLockOTP );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Numberunsuccessfulretriestoblockuserbasedofotplocks( AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Automaticotpunlocktime( AV48OTPAutoUnlockTime );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Eventsendcode( AV50OTPEventSendCode );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Mailmessagesubject( AV57OTPMailMessageSubject );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Mailmessagebodyhtml( AV56OTPMailMessageBodyHTML );
               AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().setgxTv_SdtGAMAuthenticationOTP_Eventvalidatecode( AV51OTPEventValidateCode );
               AV17AuthenticationTypeOTP.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV18AuthenticationTypeTwitter.load(AV46Name);
               }
               AV18AuthenticationTypeTwitter.setgxTv_SdtGAMAuthenticationTypeTwitter_Name( AV46Name );
               AV18AuthenticationTypeTwitter.setgxTv_SdtGAMAuthenticationTypeTwitter_Isenable( AV45IsEnable );
               AV18AuthenticationTypeTwitter.setgxTv_SdtGAMAuthenticationTypeTwitter_Description( AV33Dsc );
               AV18AuthenticationTypeTwitter.setgxTv_SdtGAMAuthenticationTypeTwitter_Smallimagename( AV64SmallImageName );
               AV18AuthenticationTypeTwitter.setgxTv_SdtGAMAuthenticationTypeTwitter_Bigimagename( AV22BigImageName );
               AV18AuthenticationTypeTwitter.setgxTv_SdtGAMAuthenticationTypeTwitter_Impersonate( AV44Impersonate );
               AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().setgxTv_SdtGAMAuthenticationTwitter_Consumerkey( AV26ConsumerKey );
               AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().setgxTv_SdtGAMAuthenticationTwitter_Consumersecret( AV27ConsumerSecret );
               AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().setgxTv_SdtGAMAuthenticationTwitter_Callbackurl( AV23CallbackURL );
               AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().setgxTv_SdtGAMAuthenticationTwitter_Additionalscope( AV6AdditionalScope );
               AV18AuthenticationTypeTwitter.save();
            }
            else if ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 )
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  AV20AuthenticationTypeWeChat.load(AV46Name);
               }
               AV20AuthenticationTypeWeChat.setgxTv_SdtGAMAuthenticationTypeWeChat_Name( AV46Name );
               AV20AuthenticationTypeWeChat.setgxTv_SdtGAMAuthenticationTypeWeChat_Isenable( AV45IsEnable );
               AV20AuthenticationTypeWeChat.setgxTv_SdtGAMAuthenticationTypeWeChat_Description( AV33Dsc );
               AV20AuthenticationTypeWeChat.setgxTv_SdtGAMAuthenticationTypeWeChat_Smallimagename( AV64SmallImageName );
               AV20AuthenticationTypeWeChat.setgxTv_SdtGAMAuthenticationTypeWeChat_Bigimagename( AV22BigImageName );
               AV20AuthenticationTypeWeChat.setgxTv_SdtGAMAuthenticationTypeWeChat_Impersonate( AV44Impersonate );
               AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().setgxTv_SdtGAMAuthenticationWeChat_Clientid( AV24ClientId );
               AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().setgxTv_SdtGAMAuthenticationWeChat_Clientsecret( AV25ClientSecret );
               AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().setgxTv_SdtGAMAuthenticationWeChat_Versionpath( AV70VersionPath );
               AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().setgxTv_SdtGAMAuthenticationWeChat_Siteurl( AV62SiteURL );
               AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().setgxTv_SdtGAMAuthenticationWeChat_Additionalscope( AV6AdditionalScope );
               AV20AuthenticationTypeWeChat.save();
            }
         }
         else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            if ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 )
            {
               AV15AuthenticationTypeLocal.load(AV46Name);
               AV15AuthenticationTypeLocal.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 )
            {
               AV9AuthenticationTypeApple.load(AV46Name);
               AV9AuthenticationTypeApple.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
            {
               AV10AuthenticationTypeCustom.load(AV46Name);
               AV10AuthenticationTypeCustom.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
            {
               AV19AuthenticationTypeWebService.load(AV46Name);
               AV19AuthenticationTypeWebService.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 )
            {
               AV11AuthenticationTypeFacebook.load(AV46Name);
               AV11AuthenticationTypeFacebook.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 )
            {
               AV12AuthenticationTypeGAMRemote.load(AV46Name);
               AV12AuthenticationTypeGAMRemote.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 )
            {
               AV13AuthenticationTypeGAMRemoteRest.load(AV46Name);
               AV13AuthenticationTypeGAMRemoteRest.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Google") == 0 )
            {
               AV14AuthenticationTypeGoogle.load(AV46Name);
               AV14AuthenticationTypeGoogle.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Oauth20") == 0 )
            {
               AV16AuthenticationTypeOauth20.load(AV46Name);
               AV16AuthenticationTypeOauth20.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "OTP") == 0 )
            {
               AV17AuthenticationTypeOTP.load(AV46Name);
               AV17AuthenticationTypeOTP.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 )
            {
               AV18AuthenticationTypeTwitter.load(AV46Name);
               AV18AuthenticationTypeTwitter.delete();
            }
            else if ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 )
            {
               AV20AuthenticationTypeWeChat.load(AV46Name);
               AV20AuthenticationTypeWeChat.delete();
            }
         }
         if ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 )
         {
            if ( AV15AuthenticationTypeLocal.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 )
         {
            if ( AV9AuthenticationTypeApple.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
         {
            if ( AV10AuthenticationTypeCustom.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
         {
            if ( AV19AuthenticationTypeWebService.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 )
         {
            if ( AV11AuthenticationTypeFacebook.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 )
         {
            if ( AV12AuthenticationTypeGAMRemote.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 )
         {
            if ( AV13AuthenticationTypeGAMRemoteRest.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "Google") == 0 )
         {
            if ( AV14AuthenticationTypeGoogle.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "Oauth20") == 0 )
         {
            if ( AV16AuthenticationTypeOauth20.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "OTP") == 0 )
         {
            if ( AV17AuthenticationTypeOTP.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 )
         {
            if ( AV18AuthenticationTypeTwitter.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         else if ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 )
         {
            if ( AV20AuthenticationTypeWeChat.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrygeneral");
            }
         }
         AV35Errors = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
         if ( AV35Errors.size() == 0 )
         {
            callWebObject(formatLink("com.mujermorena.gamwwauthtypes", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            AV87GXV1 = 1 ;
            while ( AV87GXV1 <= AV35Errors.size() )
            {
               AV34Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV35Errors.elementAt(-1+AV87GXV1));
               httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV34Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV34Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
               AV87GXV1 = (int)(AV87GXV1+1) ;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV20AuthenticationTypeWeChat", AV20AuthenticationTypeWeChat);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV18AuthenticationTypeTwitter", AV18AuthenticationTypeTwitter);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV17AuthenticationTypeOTP", AV17AuthenticationTypeOTP);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV14AuthenticationTypeGoogle", AV14AuthenticationTypeGoogle);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV13AuthenticationTypeGAMRemoteRest", AV13AuthenticationTypeGAMRemoteRest);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12AuthenticationTypeGAMRemote", AV12AuthenticationTypeGAMRemote);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV11AuthenticationTypeFacebook", AV11AuthenticationTypeFacebook);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV19AuthenticationTypeWebService", AV19AuthenticationTypeWebService);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV10AuthenticationTypeCustom", AV10AuthenticationTypeCustom);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9AuthenticationTypeApple", AV9AuthenticationTypeApple);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV15AuthenticationTypeLocal", AV15AuthenticationTypeLocal);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV16AuthenticationTypeOauth20", AV16AuthenticationTypeOauth20);
   }

   public void e152Z2( )
   {
      /* Tfaenable_Click Routine */
      returnInSub = false ;
      if ( AV66TFAEnable )
      {
         if ( (0==AV67TFAFirstFactorAuthenticationExpiration) )
         {
            AV67TFAFirstFactorAuthenticationExpiration = 900 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         }
         /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEOTP' */
         S252 ();
         if (returnInSub) return;
      }
      else
      {
         AV65TFAAuthenticationTypeName = "" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S232 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavTfaauthenticationtypename.setValue( GXutil.rtrim( AV65TFAAuthenticationTypeName) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTfaauthenticationtypename.getInternalname(), "Values", cmbavTfaauthenticationtypename.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV38GAMAuthenticationTypeFilter", AV38GAMAuthenticationTypeFilter);
   }

   public void e162Z2( )
   {
      /* Otpgenerationtype_Click Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV54OTPGenerationType, "custom") == 0 )
      {
         /* Execute user subroutine: 'GETEVENTLISTGENERATECODE' */
         S262 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S232 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV39GAMEventSubscriptionFilter", AV39GAMEventSubscriptionFilter);
      cmbavOtpgenerationtype_customeventgeneratecode.setValue( GXutil.rtrim( AV55OTPGenerationType_CustomEventGenerateCode) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavOtpgenerationtype_customeventgeneratecode.getInternalname(), "Values", cmbavOtpgenerationtype_customeventgeneratecode.ToJavascriptSource(), true);
   }

   public void S222( )
   {
      /* 'REFRESHAUTHENTICATIONTYPE' Routine */
      returnInSub = false ;
      edtavSiteurl_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSiteurl_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSiteurl_Visible), 5, 0), true);
      divTblserverhost_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblserverhost_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblserverhost_Visible), 5, 0), true);
      divTblwebservice_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblwebservice_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblwebservice_Visible), 5, 0), true);
      divTblexternal_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblexternal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblexternal_Visible), 5, 0), true);
      divTblotpauthentication_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblotpauthentication_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblotpauthentication_Visible), 5, 0), true);
      divTblotpconfiguration_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblotpconfiguration_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblotpconfiguration_Visible), 5, 0), true);
      if ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "OTP") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 ) )
      {
         AV37FunctionId = "OnlyAuthentication" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
         cmbavFunctionid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbavFunctionid.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      }
      if ( GXutil.strcmp(AV69TypeId, "GAMLocal") == 0 )
      {
      }
      else if ( ( GXutil.strcmp(AV69TypeId, "AppleID") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Facebook") == 0 ) || ( GXutil.strcmp(AV69TypeId, "Google") == 0 ) || ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 ) || ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 ) )
      {
         if ( GXutil.strcmp(AV69TypeId, "WeChat") == 0 )
         {
            edtavVersionpath_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersionpath_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersionpath_Visible), 5, 0), true);
         }
         if ( GXutil.strcmp(AV69TypeId, "GAMRemote") == 0 )
         {
            edtavVersionpath_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavVersionpath_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersionpath_Visible), 5, 0), true);
            divTblserverhost_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblserverhost_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblserverhost_Visible), 5, 0), true);
         }
      }
      else if ( GXutil.strcmp(AV69TypeId, "GAMRemoteRest") == 0 )
      {
         divTblserverhost_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblserverhost_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblserverhost_Visible), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV69TypeId, "OTP") == 0 )
      {
         divTblotpauthentication_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblotpauthentication_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblotpauthentication_Visible), 5, 0), true);
         divTblotpconfiguration_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblotpconfiguration_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblotpconfiguration_Visible), 5, 0), true);
         if ( GXutil.strcmp(AV54OTPGenerationType, "custom") == 0 )
         {
            /* Execute user subroutine: 'GETEVENTLISTGENERATECODE' */
            S262 ();
            if (returnInSub) return;
         }
      }
      else if ( GXutil.strcmp(AV69TypeId, "Twitter") == 0 )
      {
         AV37FunctionId = "OnlyAuthentication" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
         cmbavFunctionid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV69TypeId, "ExternalWebService") == 0 )
      {
         divTblwebservice_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblwebservice_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblwebservice_Visible), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV69TypeId, "Custom") == 0 )
      {
         divTblexternal_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTblexternal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblexternal_Visible), 5, 0), true);
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S232 ();
      if (returnInSub) return;
   }

   public void S272( )
   {
      /* 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' Routine */
      returnInSub = false ;
      AV89GXV3 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV35Errors ;
      AV88GXV2 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getauthenticationtypes(AV38GAMAuthenticationTypeFilter, GXv_objcol_SdtGAMError1) ;
      AV35Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV89GXV3 <= AV88GXV2.size() )
      {
         AV8AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationType)((genexus.security.api.genexussecurity.SdtGAMAuthenticationType)AV88GXV2.elementAt(-1+AV89GXV3));
         if ( ( GXutil.strcmp(AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Name(), AV46Name) != 0 ) && ( GXutil.strcmp(AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Typeid(), "OTP") != 0 ) )
         {
            cmbavImpersonate.addItem(AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Name(), AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Name(), (short)(0));
         }
         AV89GXV3 = (int)(AV89GXV3+1) ;
      }
   }

   public void S252( )
   {
      /* 'GETLISTAUTHENTICATIONTYPEOTP' Routine */
      returnInSub = false ;
      AV38GAMAuthenticationTypeFilter.setgxTv_SdtGAMAuthenticationTypeFilter_Type( "OTP" );
      AV91GXV5 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV35Errors ;
      AV90GXV4 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getauthenticationtypes(AV38GAMAuthenticationTypeFilter, GXv_objcol_SdtGAMError1) ;
      AV35Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV91GXV5 <= AV90GXV4.size() )
      {
         AV8AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationType)((genexus.security.api.genexussecurity.SdtGAMAuthenticationType)AV90GXV4.elementAt(-1+AV91GXV5));
         cmbavTfaauthenticationtypename.addItem(AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Name(), AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Description(), (short)(0));
         AV91GXV5 = (int)(AV91GXV5+1) ;
      }
   }

   public void S282( )
   {
      /* 'GETEVENTLISTVALIDATEUSER' Routine */
      returnInSub = false ;
      AV39GAMEventSubscriptionFilter.setgxTv_SdtGAMEventSubscriptionFilter_Event( "user-otp-validateuser" );
      AV93GXV7 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV35Errors ;
      AV92GXV6 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).geteventsubscriptions(AV39GAMEventSubscriptionFilter, GXv_objcol_SdtGAMError1) ;
      AV35Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV93GXV7 <= AV92GXV6.size() )
      {
         AV36EventSuscription = (genexus.security.api.genexussecurity.SdtGAMEventSubscription)((genexus.security.api.genexussecurity.SdtGAMEventSubscription)AV92GXV6.elementAt(-1+AV93GXV7));
         cmbavOtpeventvalidateuser.addItem(AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Id(), AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Description(), (short)(0));
         AV93GXV7 = (int)(AV93GXV7+1) ;
      }
   }

   public void S262( )
   {
      /* 'GETEVENTLISTGENERATECODE' Routine */
      returnInSub = false ;
      AV39GAMEventSubscriptionFilter.setgxTv_SdtGAMEventSubscriptionFilter_Event( "user-otp-generatecode" );
      AV95GXV9 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV35Errors ;
      AV94GXV8 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).geteventsubscriptions(AV39GAMEventSubscriptionFilter, GXv_objcol_SdtGAMError1) ;
      AV35Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV95GXV9 <= AV94GXV8.size() )
      {
         AV36EventSuscription = (genexus.security.api.genexussecurity.SdtGAMEventSubscription)((genexus.security.api.genexussecurity.SdtGAMEventSubscription)AV94GXV8.elementAt(-1+AV95GXV9));
         cmbavOtpgenerationtype_customeventgeneratecode.addItem(AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Id(), AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Description(), (short)(0));
         AV95GXV9 = (int)(AV95GXV9+1) ;
      }
   }

   public void S292( )
   {
      /* 'GETEVENTLISTSENDCODE' Routine */
      returnInSub = false ;
      AV39GAMEventSubscriptionFilter.setgxTv_SdtGAMEventSubscriptionFilter_Event( "user-otp-sendcode" );
      AV97GXV11 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV35Errors ;
      AV96GXV10 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).geteventsubscriptions(AV39GAMEventSubscriptionFilter, GXv_objcol_SdtGAMError1) ;
      AV35Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV97GXV11 <= AV96GXV10.size() )
      {
         AV36EventSuscription = (genexus.security.api.genexussecurity.SdtGAMEventSubscription)((genexus.security.api.genexussecurity.SdtGAMEventSubscription)AV96GXV10.elementAt(-1+AV97GXV11));
         cmbavOtpeventsendcode.addItem(AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Id(), AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Description(), (short)(0));
         AV97GXV11 = (int)(AV97GXV11+1) ;
      }
   }

   public void S302( )
   {
      /* 'GETEVENTLISTVALIDATECODE' Routine */
      returnInSub = false ;
      AV39GAMEventSubscriptionFilter.setgxTv_SdtGAMEventSubscriptionFilter_Event( "user-otp-validatecode" );
      AV99GXV13 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV35Errors ;
      AV98GXV12 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).geteventsubscriptions(AV39GAMEventSubscriptionFilter, GXv_objcol_SdtGAMError1) ;
      AV35Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV99GXV13 <= AV98GXV12.size() )
      {
         AV36EventSuscription = (genexus.security.api.genexussecurity.SdtGAMEventSubscription)((genexus.security.api.genexussecurity.SdtGAMEventSubscription)AV98GXV12.elementAt(-1+AV99GXV13));
         cmbavOtpeventvalidatecode.addItem(AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Id(), AV36EventSuscription.getgxTv_SdtGAMEventSubscription_Description(), (short)(0));
         AV99GXV13 = (int)(AV99GXV13+1) ;
      }
   }

   public void S112( )
   {
      /* 'INITAUTHENTICATIONTYPEAPPLE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV9AuthenticationTypeApple.load(AV46Name);
      AV46Name = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV45IsEnable = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV24ClientId = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().getgxTv_SdtGAMAuthenticationApple_Clientid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
      AV25ClientSecret = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().getgxTv_SdtGAMAuthenticationApple_Clientsecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
      AV62SiteURL = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().getgxTv_SdtGAMAuthenticationApple_Siteurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62SiteURL", AV62SiteURL);
      AV6AdditionalScope = AV9AuthenticationTypeApple.getgxTv_SdtGAMAuthenticationTypeApple_Apple().getgxTv_SdtGAMAuthenticationApple_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
   }

   public void S122( )
   {
      /* 'INITAUTHENTICATIONTYPECUSTOM' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEOTP' */
      S252 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV10AuthenticationTypeCustom.load(AV46Name);
      AV46Name = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV37FunctionId = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Functionid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      AV45IsEnable = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV66TFAEnable = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Enable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFAEnable", AV66TFAEnable);
      if ( AV66TFAEnable )
      {
         AV65TFAAuthenticationTypeName = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
         AV67TFAFirstFactorAuthenticationExpiration = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         AV68TFAForceForAllUsers = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFAForceForAllUsers", AV68TFAForceForAllUsers);
      }
      AV32CusVersion = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().getgxTv_SdtGAMAuthenticationCustom_Version() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32CusVersion", AV32CusVersion);
      AV31CusPrivateEncryptKey = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().getgxTv_SdtGAMAuthenticationCustom_Privateencryptkey() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31CusPrivateEncryptKey", AV31CusPrivateEncryptKey);
      AV29CusFileName = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().getgxTv_SdtGAMAuthenticationCustom_Filename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29CusFileName", AV29CusFileName);
      AV30CusPackage = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().getgxTv_SdtGAMAuthenticationCustom_Package() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30CusPackage", AV30CusPackage);
      AV28CusClassName = AV10AuthenticationTypeCustom.getgxTv_SdtGAMAuthenticationTypeCustom_Custom().getgxTv_SdtGAMAuthenticationCustom_Classname() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28CusClassName", AV28CusClassName);
   }

   public void S132( )
   {
      /* 'INITAUTHENTICATIONTYPEEXTERNALWEBSERVICE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEOTP' */
      S252 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV19AuthenticationTypeWebService.load(AV46Name);
      AV46Name = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV37FunctionId = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Functionid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      AV45IsEnable = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV66TFAEnable = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Enable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFAEnable", AV66TFAEnable);
      if ( AV66TFAEnable )
      {
         AV65TFAAuthenticationTypeName = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
         AV67TFAFirstFactorAuthenticationExpiration = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         AV68TFAForceForAllUsers = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFAForceForAllUsers", AV68TFAForceForAllUsers);
      }
      AV80WSVersion = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Version() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80WSVersion", AV80WSVersion);
      AV74WSPrivateEncryptKey = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Privateencryptkey() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74WSPrivateEncryptKey", AV74WSPrivateEncryptKey);
      AV76WSServerName = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().getgxTv_SdtGAMAuthenticationWebServiceServer_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76WSServerName", AV76WSServerName);
      AV77WSServerPort = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().getgxTv_SdtGAMAuthenticationWebServiceServer_Port() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77WSServerPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV77WSServerPort), 5, 0));
      AV75WSServerBaseURL = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().getgxTv_SdtGAMAuthenticationWebServiceServer_Baseurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75WSServerBaseURL", AV75WSServerBaseURL);
      AV78WSServerSecureProtocol = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Server().getgxTv_SdtGAMAuthenticationWebServiceServer_Secureprotocol() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78WSServerSecureProtocol", GXutil.str( AV78WSServerSecureProtocol, 1, 0));
      AV79WSTimeout = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Timeout() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79WSTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV79WSTimeout), 5, 0));
      AV73WSPackage = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Package() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73WSPackage", AV73WSPackage);
      AV72WSName = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72WSName", AV72WSName);
      AV71WSExtension = AV19AuthenticationTypeWebService.getgxTv_SdtGAMAuthenticationTypeWebService_Webservice().getgxTv_SdtGAMAuthenticationWebService_Extension() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71WSExtension", AV71WSExtension);
   }

   public void S142( )
   {
      /* 'INITAUTHENTICATIONTYPEFACEBOOK' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV11AuthenticationTypeFacebook.load(AV46Name);
      AV46Name = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV45IsEnable = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV24ClientId = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().getgxTv_SdtGAMAuthenticationFacebook_Clientid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
      AV25ClientSecret = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().getgxTv_SdtGAMAuthenticationFacebook_Clientsecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
      AV70VersionPath = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().getgxTv_SdtGAMAuthenticationFacebook_Versionpath() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70VersionPath", AV70VersionPath);
      AV62SiteURL = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().getgxTv_SdtGAMAuthenticationFacebook_Siteurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62SiteURL", AV62SiteURL);
      AV6AdditionalScope = AV11AuthenticationTypeFacebook.getgxTv_SdtGAMAuthenticationTypeFacebook_Facebook().getgxTv_SdtGAMAuthenticationFacebook_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
   }

   public void S152( )
   {
      /* 'INITAUTHENTICATIONTYPEGAMLOCAL' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEOTP' */
      S252 ();
      if (returnInSub) return;
      AV15AuthenticationTypeLocal.load(AV46Name);
      AV46Name = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV37FunctionId = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Functionid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      AV45IsEnable = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV66TFAEnable = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Enable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFAEnable", AV66TFAEnable);
      if ( AV66TFAEnable )
      {
         AV65TFAAuthenticationTypeName = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
         AV67TFAFirstFactorAuthenticationExpiration = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         AV68TFAForceForAllUsers = AV15AuthenticationTypeLocal.getgxTv_SdtGAMAuthenticationTypeLocal_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFAForceForAllUsers", AV68TFAForceForAllUsers);
      }
   }

   public void S162( )
   {
      /* 'INITAUTHENTICATIONTYPEGAMREMOTE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV12AuthenticationTypeGAMRemote.load(AV46Name);
      AV46Name = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV37FunctionId = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Functionid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      AV45IsEnable = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV24ClientId = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Clientid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
      AV25ClientSecret = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Clientsecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
      AV62SiteURL = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Siteurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62SiteURL", AV62SiteURL);
      AV63SiteURLCallbackIsCustom = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Siteurlcallbackiscustom() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63SiteURLCallbackIsCustom", AV63SiteURLCallbackIsCustom);
      AV5AddInitialPropertiesScope = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Addsessioninitialpropertiesscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5AddInitialPropertiesScope", AV5AddInitialPropertiesScope);
      AV7AddUserAdditionalDataScope = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Adduseradditionaldatascope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AddUserAdditionalDataScope", AV7AddUserAdditionalDataScope);
      AV6AdditionalScope = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
      AV43GAMRServerURL = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Remoteserverurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43GAMRServerURL", AV43GAMRServerURL);
      AV41GAMRPrivateEncryptKey = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Remoteserverkey() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41GAMRPrivateEncryptKey", AV41GAMRPrivateEncryptKey);
      AV42GAMRRepositoryGUID = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Remoterepositoryguid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42GAMRRepositoryGUID", AV42GAMRRepositoryGUID);
      AV21AutovalidateExternalTokenAndRefresh = AV12AuthenticationTypeGAMRemote.getgxTv_SdtGAMAuthenticationTypeGAMRemote_Gamremote().getgxTv_SdtGAMAuthenticationGAMRemote_Autovalidateexternaltokenandrefresh() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AutovalidateExternalTokenAndRefresh", AV21AutovalidateExternalTokenAndRefresh);
   }

   public void S172( )
   {
      /* 'INITAUTHENTICATIONTYPEGAMREMOTEREST' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEOTP' */
      S252 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV13AuthenticationTypeGAMRemoteRest.load(AV46Name);
      AV46Name = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV37FunctionId = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Functionid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      AV45IsEnable = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV66TFAEnable = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Enable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TFAEnable", AV66TFAEnable);
      if ( AV66TFAEnable )
      {
         AV65TFAAuthenticationTypeName = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Authenticationtypename() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TFAAuthenticationTypeName", AV65TFAAuthenticationTypeName);
         AV67TFAFirstFactorAuthenticationExpiration = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Firstauthenticationfactorexpiration() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TFAFirstFactorAuthenticationExpiration", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFAFirstFactorAuthenticationExpiration), 9, 0));
         AV68TFAForceForAllUsers = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Twofactorauthentication().getgxTv_SdtGAMTwoFactorAuthentication_Forceforallusers() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TFAForceForAllUsers", AV68TFAForceForAllUsers);
      }
      AV24ClientId = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Clientid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
      AV25ClientSecret = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Clientsecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
      AV70VersionPath = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Versionpath() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70VersionPath", AV70VersionPath);
      AV5AddInitialPropertiesScope = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Addsessioninitialpropertiesscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5AddInitialPropertiesScope", AV5AddInitialPropertiesScope);
      AV7AddUserAdditionalDataScope = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Adduseradditionaldatascope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AddUserAdditionalDataScope", AV7AddUserAdditionalDataScope);
      AV6AdditionalScope = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
      AV40GAMRAuthenticationTypeName = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoteauthenticationtypename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40GAMRAuthenticationTypeName", AV40GAMRAuthenticationTypeName);
      AV43GAMRServerURL = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoteserverurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43GAMRServerURL", AV43GAMRServerURL);
      AV41GAMRPrivateEncryptKey = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoteserverkey() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41GAMRPrivateEncryptKey", AV41GAMRPrivateEncryptKey);
      AV42GAMRRepositoryGUID = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Remoterepositoryguid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42GAMRRepositoryGUID", AV42GAMRRepositoryGUID);
      AV21AutovalidateExternalTokenAndRefresh = AV13AuthenticationTypeGAMRemoteRest.getgxTv_SdtGAMAuthenticationTypeGAMRemoteRest_Gamremoterest().getgxTv_SdtGAMAuthenticationGAMRemoteRest_Autovalidateexternaltokenandrefresh() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AutovalidateExternalTokenAndRefresh", AV21AutovalidateExternalTokenAndRefresh);
   }

   public void S182( )
   {
      /* 'INITAUTHENTICATIONTYPEGOOGLE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV14AuthenticationTypeGoogle.load(AV46Name);
      AV46Name = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV45IsEnable = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV24ClientId = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().getgxTv_SdtGAMAuthenticationGoogle_Clientid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
      AV25ClientSecret = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().getgxTv_SdtGAMAuthenticationGoogle_Clientsecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
      AV70VersionPath = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().getgxTv_SdtGAMAuthenticationGoogle_Versionpath() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70VersionPath", AV70VersionPath);
      AV62SiteURL = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().getgxTv_SdtGAMAuthenticationGoogle_Siteurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62SiteURL", AV62SiteURL);
      AV6AdditionalScope = AV14AuthenticationTypeGoogle.getgxTv_SdtGAMAuthenticationTypeGoogle_Google().getgxTv_SdtGAMAuthenticationGoogle_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
   }

   public void S192( )
   {
      /* 'INITAUTHENTICATIONTYPEOTP' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'GETEVENTLISTVALIDATEUSER' */
      S282 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'GETEVENTLISTSENDCODE' */
      S292 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'GETEVENTLISTVALIDATECODE' */
      S302 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV37FunctionId = "OnlyAuthentication" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37FunctionId", AV37FunctionId);
      AV17AuthenticationTypeOTP.load(AV46Name);
      AV46Name = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV45IsEnable = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV61OTPUseForFirstFactorAuthentication = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Useforfirstfactorauthentication() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61OTPUseForFirstFactorAuthentication", AV61OTPUseForFirstFactorAuthentication);
      AV52OTPEventValidateUser = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Eventvaliduser() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52OTPEventValidateUser", AV52OTPEventValidateUser);
      AV54OTPGenerationType = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Generationtype() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54OTPGenerationType", AV54OTPGenerationType);
      AV55OTPGenerationType_CustomEventGenerateCode = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Generationtype_customeventgeneratecode() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55OTPGenerationType_CustomEventGenerateCode", AV55OTPGenerationType_CustomEventGenerateCode);
      AV49OTPCodeExpirationTimeout = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Codeexpirationtimeout() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49OTPCodeExpirationTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49OTPCodeExpirationTimeout), 9, 0));
      AV58OTPMaximumDailyNumberCodes = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Maximumdailynumbercodes() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58OTPMaximumDailyNumberCodes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58OTPMaximumDailyNumberCodes), 4, 0));
      AV47OTPAutogeneratedCodeLength = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Autogeneratedcodelength() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47OTPAutogeneratedCodeLength", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV47OTPAutogeneratedCodeLength), 4, 0));
      AV53OTPGenerateCodeOnlyNumbers = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Generatecodeonlynumbers() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53OTPGenerateCodeOnlyNumbers", AV53OTPGenerateCodeOnlyNumbers);
      AV60OTPNumberUnsuccessfulRetriesToLockOTP = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Numberunsuccessfulretriestolockotp() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60OTPNumberUnsuccessfulRetriesToLockOTP", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV60OTPNumberUnsuccessfulRetriesToLockOTP), 4, 0));
      AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Numberunsuccessfulretriestoblockuserbasedofotplocks() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks), 4, 0));
      AV48OTPAutoUnlockTime = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Automaticotpunlocktime() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48OTPAutoUnlockTime", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48OTPAutoUnlockTime), 9, 0));
      AV50OTPEventSendCode = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Eventsendcode() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50OTPEventSendCode", AV50OTPEventSendCode);
      AV57OTPMailMessageSubject = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Mailmessagesubject() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57OTPMailMessageSubject", AV57OTPMailMessageSubject);
      AV56OTPMailMessageBodyHTML = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Mailmessagebodyhtml() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56OTPMailMessageBodyHTML", AV56OTPMailMessageBodyHTML);
      AV51OTPEventValidateCode = AV17AuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Eventvalidatecode() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51OTPEventValidateCode", AV51OTPEventValidateCode);
   }

   public void S202( )
   {
      /* 'INITAUTHENTICATIONTYPETWITTER' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV18AuthenticationTypeTwitter.load(AV46Name);
      AV46Name = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV45IsEnable = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV26ConsumerKey = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().getgxTv_SdtGAMAuthenticationTwitter_Consumerkey() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26ConsumerKey", AV26ConsumerKey);
      AV27ConsumerSecret = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().getgxTv_SdtGAMAuthenticationTwitter_Consumersecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27ConsumerSecret", AV27ConsumerSecret);
      AV23CallbackURL = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().getgxTv_SdtGAMAuthenticationTwitter_Callbackurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23CallbackURL", AV23CallbackURL);
      AV6AdditionalScope = AV18AuthenticationTypeTwitter.getgxTv_SdtGAMAuthenticationTypeTwitter_Twitter().getgxTv_SdtGAMAuthenticationTwitter_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
   }

   public void S212( )
   {
      /* 'INITAUTHENTICATIONTYPEWECHAT' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GETLISTAUTHENTICATIONTYPEIMPERSONATE' */
      S272 ();
      if (returnInSub) return;
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      AV20AuthenticationTypeWeChat.load(AV46Name);
      AV46Name = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV45IsEnable = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45IsEnable", AV45IsEnable);
      AV33Dsc = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33Dsc", AV33Dsc);
      AV64SmallImageName = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64SmallImageName", AV64SmallImageName);
      AV22BigImageName = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22BigImageName", AV22BigImageName);
      AV44Impersonate = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44Impersonate", AV44Impersonate);
      AV24ClientId = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().getgxTv_SdtGAMAuthenticationWeChat_Clientid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24ClientId", AV24ClientId);
      AV25ClientSecret = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().getgxTv_SdtGAMAuthenticationWeChat_Clientsecret() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25ClientSecret", AV25ClientSecret);
      AV70VersionPath = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().getgxTv_SdtGAMAuthenticationWeChat_Versionpath() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70VersionPath", AV70VersionPath);
      AV62SiteURL = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().getgxTv_SdtGAMAuthenticationWeChat_Siteurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62SiteURL", AV62SiteURL);
      AV6AdditionalScope = AV20AuthenticationTypeWeChat.getgxTv_SdtGAMAuthenticationTypeWeChat_Wechat().getgxTv_SdtGAMAuthenticationWeChat_Additionalscope() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AdditionalScope", AV6AdditionalScope);
   }

   protected void nextLoad( )
   {
   }

   protected void e172Z2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_290_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedcusprivateencryptkey_Internalname, tblTablemergedcusprivateencryptkey_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCusprivateencryptkey_Internalname, httpContext.getMessage( "Cus Private Encrypt Key", ""), "gx-form-item AttributeRealWidthLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 294,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCusprivateencryptkey_Internalname, GXutil.rtrim( AV31CusPrivateEncryptKey), GXutil.rtrim( localUtil.format( AV31CusPrivateEncryptKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,294);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCusprivateencryptkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCusprivateencryptkey_Enabled, 1, "text", "", 32, "chr", 1, "row", 32, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='CellMarginLeft'>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 296,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button ButtonMaterialGAM" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtngenkeycustom_Internalname, "", httpContext.getMessage( "WWP_GAM_GenerateKey", ""), bttBtngenkeycustom_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_GenerateKey", ""), "", StyleString, ClassString, bttBtngenkeycustom_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOGENKEYCUSTOM\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_290_2Z2e( true) ;
      }
      else
      {
         wb_table2_290_2Z2e( false) ;
      }
   }

   public void wb_table1_234_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedwsprivateencryptkey_Internalname, tblTablemergedwsprivateencryptkey_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWsprivateencryptkey_Internalname, httpContext.getMessage( "WSPrivate Encrypt Key", ""), "gx-form-item AttributeRealWidthLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 238,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWsprivateencryptkey_Internalname, GXutil.rtrim( AV74WSPrivateEncryptKey), GXutil.rtrim( localUtil.format( AV74WSPrivateEncryptKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,238);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWsprivateencryptkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavWsprivateencryptkey_Enabled, 1, "text", "", 32, "chr", 1, "row", 32, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td class='CellMarginLeft'>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 240,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button ButtonMaterialGAM" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtngenkey_Internalname, "", httpContext.getMessage( "WWP_GAM_GenerateKey", ""), bttBtngenkey_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_GenerateKey", ""), "", StyleString, ClassString, bttBtngenkey_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOGENKEY\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryGeneral.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_234_2Z2e( true) ;
      }
      else
      {
         wb_table1_234_2Z2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      AV46Name = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      AV69TypeId = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TypeId", AV69TypeId);
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa2Z2( ) ;
      ws2Z2( ) ;
      we2Z2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlGx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV46Name = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV69TypeId = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa2Z2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "gamwcauthenticationtypeentrygeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa2Z2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         Gx_mode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         AV46Name = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
         AV69TypeId = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TypeId", AV69TypeId);
      }
      wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
      wcpOAV46Name = httpContext.cgiGet( sPrefix+"wcpOAV46Name") ;
      wcpOAV69TypeId = httpContext.cgiGet( sPrefix+"wcpOAV69TypeId") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(Gx_mode, wcpOGx_mode) != 0 ) || ( GXutil.strcmp(AV46Name, wcpOAV46Name) != 0 ) || ( GXutil.strcmp(AV69TypeId, wcpOAV69TypeId) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOGx_mode = Gx_mode ;
      wcpOAV46Name = AV46Name ;
      wcpOAV69TypeId = AV69TypeId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlGx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_CTRL") ;
      if ( GXutil.len( sCtrlGx_mode) > 0 )
      {
         Gx_mode = httpContext.cgiGet( sCtrlGx_mode) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = httpContext.cgiGet( sPrefix+"Gx_mode_PARM") ;
      }
      sCtrlAV46Name = httpContext.cgiGet( sPrefix+"AV46Name_CTRL") ;
      if ( GXutil.len( sCtrlAV46Name) > 0 )
      {
         AV46Name = httpContext.cgiGet( sCtrlAV46Name) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46Name", AV46Name);
      }
      else
      {
         AV46Name = httpContext.cgiGet( sPrefix+"AV46Name_PARM") ;
      }
      sCtrlAV69TypeId = httpContext.cgiGet( sPrefix+"AV69TypeId_CTRL") ;
      if ( GXutil.len( sCtrlAV69TypeId) > 0 )
      {
         AV69TypeId = httpContext.cgiGet( sCtrlAV69TypeId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69TypeId", AV69TypeId);
      }
      else
      {
         AV69TypeId = httpContext.cgiGet( sPrefix+"AV69TypeId_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa2Z2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws2Z2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws2Z2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_PARM", GXutil.rtrim( Gx_mode));
      if ( GXutil.len( GXutil.rtrim( sCtrlGx_mode)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Gx_mode_CTRL", GXutil.rtrim( sCtrlGx_mode));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV46Name_PARM", GXutil.rtrim( AV46Name));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV46Name)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV46Name_CTRL", GXutil.rtrim( sCtrlAV46Name));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV69TypeId_PARM", GXutil.rtrim( AV69TypeId));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV69TypeId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV69TypeId_CTRL", GXutil.rtrim( sCtrlAV69TypeId));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we2Z2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111153797", true, true);
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
      httpContext.AddJavascriptSource("gamwcauthenticationtypeentrygeneral.js", "?202412111153813", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavName_Internalname = sPrefix+"vNAME" ;
      cmbavFunctionid.setInternalname( sPrefix+"vFUNCTIONID" );
      chkavIsenable.setInternalname( sPrefix+"vISENABLE" );
      edtavDsc_Internalname = sPrefix+"vDSC" ;
      edtavSmallimagename_Internalname = sPrefix+"vSMALLIMAGENAME" ;
      edtavBigimagename_Internalname = sPrefix+"vBIGIMAGENAME" ;
      cmbavImpersonate.setInternalname( sPrefix+"vIMPERSONATE" );
      divImpersonate_cell_Internalname = sPrefix+"IMPERSONATE_CELL" ;
      chkavTfaenable.setInternalname( sPrefix+"vTFAENABLE" );
      divTfaenable_cell_Internalname = sPrefix+"TFAENABLE_CELL" ;
      cmbavTfaauthenticationtypename.setInternalname( sPrefix+"vTFAAUTHENTICATIONTYPENAME" );
      divTfaauthenticationtypename_cell_Internalname = sPrefix+"TFAAUTHENTICATIONTYPENAME_CELL" ;
      edtavTfafirstfactorauthenticationexpiration_Internalname = sPrefix+"vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION" ;
      divTfafirstfactorauthenticationexpiration_cell_Internalname = sPrefix+"TFAFIRSTFACTORAUTHENTICATIONEXPIRATION_CELL" ;
      chkavTfaforceforallusers.setInternalname( sPrefix+"vTFAFORCEFORALLUSERS" );
      divTfaforceforallusers_cell_Internalname = sPrefix+"TFAFORCEFORALLUSERS_CELL" ;
      chkavOtpuseforfirstfactorauthentication.setInternalname( sPrefix+"vOTPUSEFORFIRSTFACTORAUTHENTICATION" );
      cmbavOtpeventvalidateuser.setInternalname( sPrefix+"vOTPEVENTVALIDATEUSER" );
      cmbavOtpgenerationtype.setInternalname( sPrefix+"vOTPGENERATIONTYPE" );
      cmbavOtpgenerationtype_customeventgeneratecode.setInternalname( sPrefix+"vOTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE" );
      divOtpgenerationtype_customeventgeneratecode_cell_Internalname = sPrefix+"OTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE_CELL" ;
      edtavOtpautogeneratedcodelength_Internalname = sPrefix+"vOTPAUTOGENERATEDCODELENGTH" ;
      divOtpautogeneratedcodelength_cell_Internalname = sPrefix+"OTPAUTOGENERATEDCODELENGTH_CELL" ;
      chkavOtpgeneratecodeonlynumbers.setInternalname( sPrefix+"vOTPGENERATECODEONLYNUMBERS" );
      divOtpgeneratecodeonlynumbers_cell_Internalname = sPrefix+"OTPGENERATECODEONLYNUMBERS_CELL" ;
      edtavOtpcodeexpirationtimeout_Internalname = sPrefix+"vOTPCODEEXPIRATIONTIMEOUT" ;
      edtavOtpmaximumdailynumbercodes_Internalname = sPrefix+"vOTPMAXIMUMDAILYNUMBERCODES" ;
      edtavOtpnumberunsuccessfulretriestolockotp_Internalname = sPrefix+"vOTPNUMBERUNSUCCESSFULRETRIESTOLOCKOTP" ;
      edtavOtpautounlocktime_Internalname = sPrefix+"vOTPAUTOUNLOCKTIME" ;
      edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname = sPrefix+"vOTPNUMBERUNSUCCESSFULRETRIESTOBLOCKUSERBASEDOFOTPLOCKS" ;
      cmbavOtpeventsendcode.setInternalname( sPrefix+"vOTPEVENTSENDCODE" );
      edtavOtpmailmessagesubject_Internalname = sPrefix+"vOTPMAILMESSAGESUBJECT" ;
      edtavOtpmailmessagebodyhtml_Internalname = sPrefix+"vOTPMAILMESSAGEBODYHTML" ;
      cmbavOtpeventvalidatecode.setInternalname( sPrefix+"vOTPEVENTVALIDATECODE" );
      divTblsendandvalidateotpcode_Internalname = sPrefix+"TBLSENDANDVALIDATEOTPCODE" ;
      divTblotpconfiguration_Internalname = sPrefix+"TBLOTPCONFIGURATION" ;
      divTblotpauthentication_Internalname = sPrefix+"TBLOTPAUTHENTICATION" ;
      edtavClientid_Internalname = sPrefix+"vCLIENTID" ;
      divClientid_cell_Internalname = sPrefix+"CLIENTID_CELL" ;
      edtavClientsecret_Internalname = sPrefix+"vCLIENTSECRET" ;
      divClientsecret_cell_Internalname = sPrefix+"CLIENTSECRET_CELL" ;
      edtavVersionpath_Internalname = sPrefix+"vVERSIONPATH" ;
      divVersionpath_cell_Internalname = sPrefix+"VERSIONPATH_CELL" ;
      edtavSiteurl_Internalname = sPrefix+"vSITEURL" ;
      divSiteurl_cell_Internalname = sPrefix+"SITEURL_CELL" ;
      chkavSiteurlcallbackiscustom.setInternalname( sPrefix+"vSITEURLCALLBACKISCUSTOM" );
      divSiteurlcallbackiscustom_cell_Internalname = sPrefix+"SITEURLCALLBACKISCUSTOM_CELL" ;
      edtavConsumerkey_Internalname = sPrefix+"vCONSUMERKEY" ;
      divConsumerkey_cell_Internalname = sPrefix+"CONSUMERKEY_CELL" ;
      edtavConsumersecret_Internalname = sPrefix+"vCONSUMERSECRET" ;
      divConsumersecret_cell_Internalname = sPrefix+"CONSUMERSECRET_CELL" ;
      edtavCallbackurl_Internalname = sPrefix+"vCALLBACKURL" ;
      divCallbackurl_cell_Internalname = sPrefix+"CALLBACKURL_CELL" ;
      chkavAdduseradditionaldatascope.setInternalname( sPrefix+"vADDUSERADDITIONALDATASCOPE" );
      divAdduseradditionaldatascope_cell_Internalname = sPrefix+"ADDUSERADDITIONALDATASCOPE_CELL" ;
      chkavAddinitialpropertiesscope.setInternalname( sPrefix+"vADDINITIALPROPERTIESSCOPE" );
      divAddinitialpropertiesscope_cell_Internalname = sPrefix+"ADDINITIALPROPERTIESSCOPE_CELL" ;
      edtavAdditionalscope_Internalname = sPrefix+"vADDITIONALSCOPE" ;
      divAdditionalscope_cell_Internalname = sPrefix+"ADDITIONALSCOPE_CELL" ;
      edtavGamrauthenticationtypename_Internalname = sPrefix+"vGAMRAUTHENTICATIONTYPENAME" ;
      divGamrauthenticationtypename_cell_Internalname = sPrefix+"GAMRAUTHENTICATIONTYPENAME_CELL" ;
      edtavGamrserverurl_Internalname = sPrefix+"vGAMRSERVERURL" ;
      divGamrserverurl_cell_Internalname = sPrefix+"GAMRSERVERURL_CELL" ;
      edtavGamrprivateencryptkey_Internalname = sPrefix+"vGAMRPRIVATEENCRYPTKEY" ;
      divGamrprivateencryptkey_cell_Internalname = sPrefix+"GAMRPRIVATEENCRYPTKEY_CELL" ;
      edtavGamrrepositoryguid_Internalname = sPrefix+"vGAMRREPOSITORYGUID" ;
      divGamrrepositoryguid_cell_Internalname = sPrefix+"GAMRREPOSITORYGUID_CELL" ;
      chkavAutovalidateexternaltokenandrefresh.setInternalname( sPrefix+"vAUTOVALIDATEEXTERNALTOKENANDREFRESH" );
      divTblserverhost_Internalname = sPrefix+"TBLSERVERHOST" ;
      cmbavWsversion.setInternalname( sPrefix+"vWSVERSION" );
      lblTextblockwsprivateencryptkey_Internalname = sPrefix+"TEXTBLOCKWSPRIVATEENCRYPTKEY" ;
      edtavWsprivateencryptkey_Internalname = sPrefix+"vWSPRIVATEENCRYPTKEY" ;
      bttBtngenkey_Internalname = sPrefix+"BTNGENKEY" ;
      tblTablemergedwsprivateencryptkey_Internalname = sPrefix+"TABLEMERGEDWSPRIVATEENCRYPTKEY" ;
      divTablesplittedwsprivateencryptkey_Internalname = sPrefix+"TABLESPLITTEDWSPRIVATEENCRYPTKEY" ;
      edtavWsservername_Internalname = sPrefix+"vWSSERVERNAME" ;
      divWsservername_cell_Internalname = sPrefix+"WSSERVERNAME_CELL" ;
      edtavWsserverport_Internalname = sPrefix+"vWSSERVERPORT" ;
      divWsserverport_cell_Internalname = sPrefix+"WSSERVERPORT_CELL" ;
      edtavWsserverbaseurl_Internalname = sPrefix+"vWSSERVERBASEURL" ;
      cmbavWsserversecureprotocol.setInternalname( sPrefix+"vWSSERVERSECUREPROTOCOL" );
      edtavWstimeout_Internalname = sPrefix+"vWSTIMEOUT" ;
      edtavWspackage_Internalname = sPrefix+"vWSPACKAGE" ;
      edtavWsname_Internalname = sPrefix+"vWSNAME" ;
      divWsname_cell_Internalname = sPrefix+"WSNAME_CELL" ;
      edtavWsextension_Internalname = sPrefix+"vWSEXTENSION" ;
      divTblwebservice_Internalname = sPrefix+"TBLWEBSERVICE" ;
      cmbavCusversion.setInternalname( sPrefix+"vCUSVERSION" );
      lblTextblockcusprivateencryptkey_Internalname = sPrefix+"TEXTBLOCKCUSPRIVATEENCRYPTKEY" ;
      edtavCusprivateencryptkey_Internalname = sPrefix+"vCUSPRIVATEENCRYPTKEY" ;
      bttBtngenkeycustom_Internalname = sPrefix+"BTNGENKEYCUSTOM" ;
      tblTablemergedcusprivateencryptkey_Internalname = sPrefix+"TABLEMERGEDCUSPRIVATEENCRYPTKEY" ;
      divTablesplittedcusprivateencryptkey_Internalname = sPrefix+"TABLESPLITTEDCUSPRIVATEENCRYPTKEY" ;
      edtavCusfilename_Internalname = sPrefix+"vCUSFILENAME" ;
      divCusfilename_cell_Internalname = sPrefix+"CUSFILENAME_CELL" ;
      edtavCuspackage_Internalname = sPrefix+"vCUSPACKAGE" ;
      edtavCusclassname_Internalname = sPrefix+"vCUSCLASSNAME" ;
      divCusclassname_cell_Internalname = sPrefix+"CUSCLASSNAME_CELL" ;
      divTblexternal_Internalname = sPrefix+"TBLEXTERNAL" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtncancel_Internalname = sPrefix+"BTNCANCEL" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      bttBtngenkey_Visible = 1 ;
      edtavWsprivateencryptkey_Jsonclick = "" ;
      bttBtngenkeycustom_Visible = 1 ;
      edtavCusprivateencryptkey_Jsonclick = "" ;
      edtavCusprivateencryptkey_Enabled = 1 ;
      edtavWsprivateencryptkey_Enabled = 1 ;
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      edtavCusclassname_Jsonclick = "" ;
      edtavCusclassname_Enabled = 1 ;
      divCusclassname_cell_Class = "col-xs-12 col-sm-6" ;
      edtavCuspackage_Jsonclick = "" ;
      edtavCuspackage_Enabled = 1 ;
      edtavCusfilename_Jsonclick = "" ;
      edtavCusfilename_Enabled = 1 ;
      divCusfilename_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavCusversion.setJsonclick( "" );
      cmbavCusversion.setEnabled( 1 );
      divTblexternal_Visible = 1 ;
      edtavWsextension_Jsonclick = "" ;
      edtavWsextension_Enabled = 1 ;
      edtavWsname_Jsonclick = "" ;
      edtavWsname_Enabled = 1 ;
      divWsname_cell_Class = "col-xs-12 col-sm-6" ;
      edtavWspackage_Jsonclick = "" ;
      edtavWspackage_Enabled = 1 ;
      edtavWstimeout_Jsonclick = "" ;
      edtavWstimeout_Enabled = 1 ;
      cmbavWsserversecureprotocol.setJsonclick( "" );
      cmbavWsserversecureprotocol.setEnabled( 1 );
      edtavWsserverbaseurl_Jsonclick = "" ;
      edtavWsserverbaseurl_Enabled = 1 ;
      edtavWsserverport_Jsonclick = "" ;
      edtavWsserverport_Enabled = 1 ;
      divWsserverport_cell_Class = "col-xs-12 col-sm-6" ;
      edtavWsservername_Jsonclick = "" ;
      edtavWsservername_Enabled = 1 ;
      divWsservername_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavWsversion.setJsonclick( "" );
      cmbavWsversion.setEnabled( 1 );
      divTblwebservice_Visible = 1 ;
      chkavAutovalidateexternaltokenandrefresh.setEnabled( 1 );
      edtavGamrrepositoryguid_Jsonclick = "" ;
      edtavGamrrepositoryguid_Enabled = 1 ;
      edtavGamrrepositoryguid_Visible = 1 ;
      divGamrrepositoryguid_cell_Class = "col-xs-12 col-sm-6" ;
      edtavGamrprivateencryptkey_Jsonclick = "" ;
      edtavGamrprivateencryptkey_Enabled = 1 ;
      edtavGamrprivateencryptkey_Visible = 1 ;
      divGamrprivateencryptkey_cell_Class = "col-xs-12 col-sm-6" ;
      edtavGamrserverurl_Jsonclick = "" ;
      edtavGamrserverurl_Enabled = 1 ;
      divGamrserverurl_cell_Class = "col-xs-12 col-sm-6" ;
      divTblserverhost_Visible = 1 ;
      edtavGamrauthenticationtypename_Jsonclick = "" ;
      edtavGamrauthenticationtypename_Enabled = 1 ;
      edtavGamrauthenticationtypename_Visible = 1 ;
      divGamrauthenticationtypename_cell_Class = "col-xs-12 col-sm-6" ;
      edtavAdditionalscope_Jsonclick = "" ;
      edtavAdditionalscope_Enabled = 1 ;
      edtavAdditionalscope_Visible = 1 ;
      divAdditionalscope_cell_Class = "col-xs-12 col-sm-6" ;
      chkavAddinitialpropertiesscope.setEnabled( 1 );
      chkavAddinitialpropertiesscope.setVisible( 1 );
      divAddinitialpropertiesscope_cell_Class = "col-xs-12 col-sm-6" ;
      chkavAdduseradditionaldatascope.setEnabled( 1 );
      chkavAdduseradditionaldatascope.setVisible( 1 );
      divAdduseradditionaldatascope_cell_Class = "col-xs-12 col-sm-6" ;
      edtavCallbackurl_Jsonclick = "" ;
      edtavCallbackurl_Enabled = 1 ;
      edtavCallbackurl_Visible = 1 ;
      divCallbackurl_cell_Class = "col-xs-12 col-sm-6" ;
      edtavConsumersecret_Jsonclick = "" ;
      edtavConsumersecret_Enabled = 1 ;
      edtavConsumersecret_Visible = 1 ;
      divConsumersecret_cell_Class = "col-xs-12 col-sm-6" ;
      edtavConsumerkey_Jsonclick = "" ;
      edtavConsumerkey_Enabled = 1 ;
      edtavConsumerkey_Visible = 1 ;
      divConsumerkey_cell_Class = "col-xs-12 col-sm-6" ;
      chkavSiteurlcallbackiscustom.setEnabled( 1 );
      chkavSiteurlcallbackiscustom.setVisible( 1 );
      divSiteurlcallbackiscustom_cell_Class = "col-xs-12 col-sm-6" ;
      edtavSiteurl_Jsonclick = "" ;
      edtavSiteurl_Enabled = 1 ;
      edtavSiteurl_Visible = 1 ;
      divSiteurl_cell_Class = "col-xs-12 col-sm-6" ;
      edtavVersionpath_Jsonclick = "" ;
      edtavVersionpath_Enabled = 1 ;
      edtavVersionpath_Visible = 1 ;
      divVersionpath_cell_Class = "col-xs-12 col-sm-6" ;
      edtavClientsecret_Jsonclick = "" ;
      edtavClientsecret_Enabled = 1 ;
      edtavClientsecret_Visible = 1 ;
      divClientsecret_cell_Class = "col-xs-12 col-sm-6" ;
      edtavClientid_Jsonclick = "" ;
      edtavClientid_Enabled = 1 ;
      edtavClientid_Visible = 1 ;
      divClientid_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavOtpeventvalidatecode.setJsonclick( "" );
      cmbavOtpeventvalidatecode.setEnabled( 1 );
      edtavOtpmailmessagebodyhtml_Enabled = 1 ;
      edtavOtpmailmessagesubject_Jsonclick = "" ;
      edtavOtpmailmessagesubject_Enabled = 1 ;
      cmbavOtpeventsendcode.setJsonclick( "" );
      cmbavOtpeventsendcode.setEnabled( 1 );
      divTblsendandvalidateotpcode_Visible = 1 ;
      edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Jsonclick = "" ;
      edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Enabled = 1 ;
      edtavOtpautounlocktime_Jsonclick = "" ;
      edtavOtpautounlocktime_Enabled = 1 ;
      edtavOtpnumberunsuccessfulretriestolockotp_Jsonclick = "" ;
      edtavOtpnumberunsuccessfulretriestolockotp_Enabled = 1 ;
      edtavOtpmaximumdailynumbercodes_Jsonclick = "" ;
      edtavOtpmaximumdailynumbercodes_Enabled = 1 ;
      edtavOtpcodeexpirationtimeout_Jsonclick = "" ;
      edtavOtpcodeexpirationtimeout_Enabled = 1 ;
      chkavOtpgeneratecodeonlynumbers.setEnabled( 1 );
      chkavOtpgeneratecodeonlynumbers.setVisible( 1 );
      divOtpgeneratecodeonlynumbers_cell_Class = "col-xs-12 col-sm-6" ;
      edtavOtpautogeneratedcodelength_Jsonclick = "" ;
      edtavOtpautogeneratedcodelength_Enabled = 1 ;
      edtavOtpautogeneratedcodelength_Visible = 1 ;
      divOtpautogeneratedcodelength_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavOtpgenerationtype_customeventgeneratecode.setJsonclick( "" );
      cmbavOtpgenerationtype_customeventgeneratecode.setEnabled( 1 );
      cmbavOtpgenerationtype_customeventgeneratecode.setVisible( 1 );
      divOtpgenerationtype_customeventgeneratecode_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavOtpgenerationtype.setJsonclick( "" );
      cmbavOtpgenerationtype.setEnabled( 1 );
      cmbavOtpeventvalidateuser.setJsonclick( "" );
      cmbavOtpeventvalidateuser.setEnabled( 1 );
      divTblotpconfiguration_Visible = 1 ;
      chkavOtpuseforfirstfactorauthentication.setEnabled( 1 );
      divTblotpauthentication_Visible = 1 ;
      chkavTfaforceforallusers.setEnabled( 1 );
      chkavTfaforceforallusers.setVisible( 1 );
      divTfaforceforallusers_cell_Class = "col-xs-12 col-sm-6" ;
      edtavTfafirstfactorauthenticationexpiration_Jsonclick = "" ;
      edtavTfafirstfactorauthenticationexpiration_Enabled = 1 ;
      edtavTfafirstfactorauthenticationexpiration_Visible = 1 ;
      divTfafirstfactorauthenticationexpiration_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavTfaauthenticationtypename.setJsonclick( "" );
      cmbavTfaauthenticationtypename.setEnabled( 1 );
      cmbavTfaauthenticationtypename.setVisible( 1 );
      divTfaauthenticationtypename_cell_Class = "col-xs-12 col-sm-6" ;
      chkavTfaenable.setEnabled( 1 );
      chkavTfaenable.setVisible( 1 );
      divTfaenable_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavImpersonate.setJsonclick( "" );
      cmbavImpersonate.setEnabled( 1 );
      cmbavImpersonate.setVisible( 1 );
      divImpersonate_cell_Class = "col-xs-12 col-sm-6" ;
      edtavBigimagename_Jsonclick = "" ;
      edtavBigimagename_Enabled = 1 ;
      edtavSmallimagename_Jsonclick = "" ;
      edtavSmallimagename_Enabled = 1 ;
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 1 ;
      chkavIsenable.setEnabled( 1 );
      cmbavFunctionid.setJsonclick( "" );
      cmbavFunctionid.setEnabled( 1 );
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      cmbavFunctionid.setName( "vFUNCTIONID" );
      cmbavFunctionid.setWebtags( "" );
      cmbavFunctionid.addItem("AuthenticationAndRoles", httpContext.getMessage( "WWP_GAM_AuthAndRoles", ""), (short)(0));
      cmbavFunctionid.addItem("OnlyAuthentication", httpContext.getMessage( "WWP_GAM_OnlyAuth", ""), (short)(0));
      if ( cmbavFunctionid.getItemCount() > 0 )
      {
      }
      chkavIsenable.setName( "vISENABLE" );
      chkavIsenable.setWebtags( "" );
      chkavIsenable.setCaption( httpContext.getMessage( "WWP_GAM_Enabled", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIsenable.getInternalname(), "TitleCaption", chkavIsenable.getCaption(), true);
      chkavIsenable.setCheckedValue( "false" );
      cmbavImpersonate.setName( "vIMPERSONATE" );
      cmbavImpersonate.setWebtags( "" );
      cmbavImpersonate.addItem("0", httpContext.getMessage( "WWP_GAM_None", ""), (short)(0));
      if ( cmbavImpersonate.getItemCount() > 0 )
      {
      }
      chkavTfaenable.setName( "vTFAENABLE" );
      chkavTfaenable.setWebtags( "" );
      chkavTfaenable.setCaption( httpContext.getMessage( "WWP_GAM_EnableTwoFactorAuthentication", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaenable.getInternalname(), "TitleCaption", chkavTfaenable.getCaption(), true);
      chkavTfaenable.setCheckedValue( "false" );
      cmbavTfaauthenticationtypename.setName( "vTFAAUTHENTICATIONTYPENAME" );
      cmbavTfaauthenticationtypename.setWebtags( "" );
      if ( cmbavTfaauthenticationtypename.getItemCount() > 0 )
      {
      }
      chkavTfaforceforallusers.setName( "vTFAFORCEFORALLUSERS" );
      chkavTfaforceforallusers.setWebtags( "" );
      chkavTfaforceforallusers.setCaption( httpContext.getMessage( "WWP_GAM_Force2FAAllUsers", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTfaforceforallusers.getInternalname(), "TitleCaption", chkavTfaforceforallusers.getCaption(), true);
      chkavTfaforceforallusers.setCheckedValue( "false" );
      chkavOtpuseforfirstfactorauthentication.setName( "vOTPUSEFORFIRSTFACTORAUTHENTICATION" );
      chkavOtpuseforfirstfactorauthentication.setWebtags( "" );
      chkavOtpuseforfirstfactorauthentication.setCaption( httpContext.getMessage( "WWP_GAM_UseForFFA", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOtpuseforfirstfactorauthentication.getInternalname(), "TitleCaption", chkavOtpuseforfirstfactorauthentication.getCaption(), true);
      chkavOtpuseforfirstfactorauthentication.setCheckedValue( "false" );
      cmbavOtpeventvalidateuser.setName( "vOTPEVENTVALIDATEUSER" );
      cmbavOtpeventvalidateuser.setWebtags( "" );
      cmbavOtpeventvalidateuser.addItem("0", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      if ( cmbavOtpeventvalidateuser.getItemCount() > 0 )
      {
      }
      cmbavOtpgenerationtype.setName( "vOTPGENERATIONTYPE" );
      cmbavOtpgenerationtype.setWebtags( "" );
      cmbavOtpgenerationtype.addItem("gam", httpContext.getMessage( "OTP", ""), (short)(0));
      cmbavOtpgenerationtype.addItem("custom", httpContext.getMessage( "OTP custom", ""), (short)(0));
      cmbavOtpgenerationtype.addItem("totp", httpContext.getMessage( "TOTP Authenticator", ""), (short)(0));
      if ( cmbavOtpgenerationtype.getItemCount() > 0 )
      {
      }
      cmbavOtpgenerationtype_customeventgeneratecode.setName( "vOTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE" );
      cmbavOtpgenerationtype_customeventgeneratecode.setWebtags( "" );
      if ( cmbavOtpgenerationtype_customeventgeneratecode.getItemCount() > 0 )
      {
      }
      chkavOtpgeneratecodeonlynumbers.setName( "vOTPGENERATECODEONLYNUMBERS" );
      chkavOtpgeneratecodeonlynumbers.setWebtags( "" );
      chkavOtpgeneratecodeonlynumbers.setCaption( httpContext.getMessage( "WWP_GAM_GenerateCodeOnlyWithNumbers", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOtpgeneratecodeonlynumbers.getInternalname(), "TitleCaption", chkavOtpgeneratecodeonlynumbers.getCaption(), true);
      chkavOtpgeneratecodeonlynumbers.setCheckedValue( "false" );
      cmbavOtpeventsendcode.setName( "vOTPEVENTSENDCODE" );
      cmbavOtpeventsendcode.setWebtags( "" );
      cmbavOtpeventsendcode.addItem("0", httpContext.getMessage( "WWP_GAM_EmailByGAM", ""), (short)(0));
      if ( cmbavOtpeventsendcode.getItemCount() > 0 )
      {
      }
      cmbavOtpeventvalidatecode.setName( "vOTPEVENTVALIDATECODE" );
      cmbavOtpeventvalidatecode.setWebtags( "" );
      cmbavOtpeventvalidatecode.addItem("0", httpContext.getMessage( "GAM", ""), (short)(0));
      if ( cmbavOtpeventvalidatecode.getItemCount() > 0 )
      {
      }
      chkavSiteurlcallbackiscustom.setName( "vSITEURLCALLBACKISCUSTOM" );
      chkavSiteurlcallbackiscustom.setWebtags( "" );
      chkavSiteurlcallbackiscustom.setCaption( httpContext.getMessage( "WWP_GAM_CustomCallbackURL", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavSiteurlcallbackiscustom.getInternalname(), "TitleCaption", chkavSiteurlcallbackiscustom.getCaption(), true);
      chkavSiteurlcallbackiscustom.setCheckedValue( "false" );
      chkavAdduseradditionaldatascope.setName( "vADDUSERADDITIONALDATASCOPE" );
      chkavAdduseradditionaldatascope.setWebtags( "" );
      chkavAdduseradditionaldatascope.setCaption( httpContext.getMessage( "WWP_GAM_AddGAMUserAddDataScope", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAdduseradditionaldatascope.getInternalname(), "TitleCaption", chkavAdduseradditionaldatascope.getCaption(), true);
      chkavAdduseradditionaldatascope.setCheckedValue( "false" );
      chkavAddinitialpropertiesscope.setName( "vADDINITIALPROPERTIESSCOPE" );
      chkavAddinitialpropertiesscope.setWebtags( "" );
      chkavAddinitialpropertiesscope.setCaption( httpContext.getMessage( "WWP_GAM_AddGAMSessionInitialPropScope", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAddinitialpropertiesscope.getInternalname(), "TitleCaption", chkavAddinitialpropertiesscope.getCaption(), true);
      chkavAddinitialpropertiesscope.setCheckedValue( "false" );
      chkavAutovalidateexternaltokenandrefresh.setName( "vAUTOVALIDATEEXTERNALTOKENANDREFRESH" );
      chkavAutovalidateexternaltokenandrefresh.setWebtags( "" );
      chkavAutovalidateexternaltokenandrefresh.setCaption( httpContext.getMessage( "WWP_GAM_ValidateExternalToken", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAutovalidateexternaltokenandrefresh.getInternalname(), "TitleCaption", chkavAutovalidateexternaltokenandrefresh.getCaption(), true);
      chkavAutovalidateexternaltokenandrefresh.setCheckedValue( "false" );
      cmbavWsversion.setName( "vWSVERSION" );
      cmbavWsversion.setWebtags( "" );
      cmbavWsversion.addItem("GAM10", httpContext.getMessage( "WWP_GAM_Version10", ""), (short)(0));
      cmbavWsversion.addItem("GAM20", httpContext.getMessage( "WWP_GAM_Version20", ""), (short)(0));
      if ( cmbavWsversion.getItemCount() > 0 )
      {
      }
      cmbavWsserversecureprotocol.setName( "vWSSERVERSECUREPROTOCOL" );
      cmbavWsserversecureprotocol.setWebtags( "" );
      cmbavWsserversecureprotocol.addItem("0", httpContext.getMessage( "WWP_GAM_No", ""), (short)(0));
      cmbavWsserversecureprotocol.addItem("1", httpContext.getMessage( "WWP_GAM_Yes", ""), (short)(0));
      if ( cmbavWsserversecureprotocol.getItemCount() > 0 )
      {
      }
      cmbavCusversion.setName( "vCUSVERSION" );
      cmbavCusversion.setWebtags( "" );
      cmbavCusversion.addItem("GAM10", httpContext.getMessage( "WWP_GAM_Version10", ""), (short)(0));
      cmbavCusversion.addItem("GAM20", httpContext.getMessage( "WWP_GAM_Version20", ""), (short)(0));
      if ( cmbavCusversion.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV45IsEnable',fld:'vISENABLE',pic:''},{av:'AV66TFAEnable',fld:'vTFAENABLE',pic:''},{av:'AV68TFAForceForAllUsers',fld:'vTFAFORCEFORALLUSERS',pic:''},{av:'AV61OTPUseForFirstFactorAuthentication',fld:'vOTPUSEFORFIRSTFACTORAUTHENTICATION',pic:''},{av:'AV53OTPGenerateCodeOnlyNumbers',fld:'vOTPGENERATECODEONLYNUMBERS',pic:''},{av:'AV63SiteURLCallbackIsCustom',fld:'vSITEURLCALLBACKISCUSTOM',pic:''},{av:'AV7AddUserAdditionalDataScope',fld:'vADDUSERADDITIONALDATASCOPE',pic:''},{av:'AV5AddInitialPropertiesScope',fld:'vADDINITIALPROPERTIESSCOPE',pic:''},{av:'AV21AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOGENKEYCUSTOM'","{handler:'e122Z2',iparms:[]");
      setEventMetadata("'DOGENKEYCUSTOM'",",oparms:[{av:'AV31CusPrivateEncryptKey',fld:'vCUSPRIVATEENCRYPTKEY',pic:''}]}");
      setEventMetadata("'DOGENKEY'","{handler:'e132Z2',iparms:[]");
      setEventMetadata("'DOGENKEY'",",oparms:[{av:'AV74WSPrivateEncryptKey',fld:'vWSPRIVATEENCRYPTKEY',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e142Z2',iparms:[{av:'AV83CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV28CusClassName',fld:'vCUSCLASSNAME',pic:''},{av:'AV30CusPackage',fld:'vCUSPACKAGE',pic:''},{av:'AV29CusFileName',fld:'vCUSFILENAME',pic:''},{av:'AV31CusPrivateEncryptKey',fld:'vCUSPRIVATEENCRYPTKEY',pic:''},{av:'cmbavCusversion'},{av:'AV32CusVersion',fld:'vCUSVERSION',pic:''},{av:'cmbavWsserversecureprotocol'},{av:'AV78WSServerSecureProtocol',fld:'vWSSERVERSECUREPROTOCOL',pic:'9'},{av:'AV75WSServerBaseURL',fld:'vWSSERVERBASEURL',pic:''},{av:'AV77WSServerPort',fld:'vWSSERVERPORT',pic:'ZZZZ9'},{av:'AV76WSServerName',fld:'vWSSERVERNAME',pic:''},{av:'AV71WSExtension',fld:'vWSEXTENSION',pic:''},{av:'AV72WSName',fld:'vWSNAME',pic:''},{av:'AV73WSPackage',fld:'vWSPACKAGE',pic:''},{av:'AV79WSTimeout',fld:'vWSTIMEOUT',pic:'ZZZZ9'},{av:'AV74WSPrivateEncryptKey',fld:'vWSPRIVATEENCRYPTKEY',pic:''},{av:'cmbavWsversion'},{av:'AV80WSVersion',fld:'vWSVERSION',pic:''},{av:'AV63SiteURLCallbackIsCustom',fld:'vSITEURLCALLBACKISCUSTOM',pic:''},{av:'AV21AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV42GAMRRepositoryGUID',fld:'vGAMRREPOSITORYGUID',pic:''},{av:'AV41GAMRPrivateEncryptKey',fld:'vGAMRPRIVATEENCRYPTKEY',pic:''},{av:'AV43GAMRServerURL',fld:'vGAMRSERVERURL',pic:''},{av:'AV40GAMRAuthenticationTypeName',fld:'vGAMRAUTHENTICATIONTYPENAME',pic:''},{av:'AV7AddUserAdditionalDataScope',fld:'vADDUSERADDITIONALDATASCOPE',pic:''},{av:'AV5AddInitialPropertiesScope',fld:'vADDINITIALPROPERTIESSCOPE',pic:''},{av:'AV68TFAForceForAllUsers',fld:'vTFAFORCEFORALLUSERS',pic:''},{av:'AV67TFAFirstFactorAuthenticationExpiration',fld:'vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION',pic:'ZZZZZZZZ9'},{av:'cmbavTfaauthenticationtypename'},{av:'AV65TFAAuthenticationTypeName',fld:'vTFAAUTHENTICATIONTYPENAME',pic:''},{av:'AV66TFAEnable',fld:'vTFAENABLE',pic:''},{av:'cmbavFunctionid'},{av:'AV37FunctionId',fld:'vFUNCTIONID',pic:''},{av:'cmbavOtpeventvalidatecode'},{av:'AV51OTPEventValidateCode',fld:'vOTPEVENTVALIDATECODE',pic:''},{av:'AV56OTPMailMessageBodyHTML',fld:'vOTPMAILMESSAGEBODYHTML',pic:''},{av:'AV57OTPMailMessageSubject',fld:'vOTPMAILMESSAGESUBJECT',pic:''},{av:'cmbavOtpeventsendcode'},{av:'AV50OTPEventSendCode',fld:'vOTPEVENTSENDCODE',pic:''},{av:'AV48OTPAutoUnlockTime',fld:'vOTPAUTOUNLOCKTIME',pic:'ZZZZZZZZ9'},{av:'AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks',fld:'vOTPNUMBERUNSUCCESSFULRETRIESTOBLOCKUSERBASEDOFOTPLOCKS',pic:'ZZZ9'},{av:'AV60OTPNumberUnsuccessfulRetriesToLockOTP',fld:'vOTPNUMBERUNSUCCESSFULRETRIESTOLOCKOTP',pic:'ZZZ9'},{av:'AV53OTPGenerateCodeOnlyNumbers',fld:'vOTPGENERATECODEONLYNUMBERS',pic:''},{av:'AV47OTPAutogeneratedCodeLength',fld:'vOTPAUTOGENERATEDCODELENGTH',pic:'ZZZ9'},{av:'AV58OTPMaximumDailyNumberCodes',fld:'vOTPMAXIMUMDAILYNUMBERCODES',pic:'ZZZ9'},{av:'AV49OTPCodeExpirationTimeout',fld:'vOTPCODEEXPIRATIONTIMEOUT',pic:'ZZZZZZZZ9'},{av:'cmbavOtpgenerationtype_customeventgeneratecode'},{av:'AV55OTPGenerationType_CustomEventGenerateCode',fld:'vOTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE',pic:''},{av:'cmbavOtpgenerationtype'},{av:'AV54OTPGenerationType',fld:'vOTPGENERATIONTYPE',pic:''},{av:'cmbavOtpeventvalidateuser'},{av:'AV52OTPEventValidateUser',fld:'vOTPEVENTVALIDATEUSER',pic:''},{av:'AV61OTPUseForFirstFactorAuthentication',fld:'vOTPUSEFORFIRSTFACTORAUTHENTICATION',pic:''},{av:'AV23CallbackURL',fld:'vCALLBACKURL',pic:''},{av:'AV27ConsumerSecret',fld:'vCONSUMERSECRET',pic:''},{av:'AV26ConsumerKey',fld:'vCONSUMERKEY',pic:''},{av:'AV6AdditionalScope',fld:'vADDITIONALSCOPE',pic:''},{av:'AV62SiteURL',fld:'vSITEURL',pic:''},{av:'AV70VersionPath',fld:'vVERSIONPATH',pic:''},{av:'AV25ClientSecret',fld:'vCLIENTSECRET',pic:''},{av:'AV24ClientId',fld:'vCLIENTID',pic:''},{av:'cmbavImpersonate'},{av:'AV44Impersonate',fld:'vIMPERSONATE',pic:''},{av:'AV22BigImageName',fld:'vBIGIMAGENAME',pic:''},{av:'AV64SmallImageName',fld:'vSMALLIMAGENAME',pic:''},{av:'AV33Dsc',fld:'vDSC',pic:''},{av:'AV45IsEnable',fld:'vISENABLE',pic:''},{av:'AV46Name',fld:'vNAME',pic:''},{av:'AV69TypeId',fld:'vTYPEID',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV83CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VTFAENABLE.CLICK","{handler:'e152Z2',iparms:[{av:'AV66TFAEnable',fld:'vTFAENABLE',pic:''},{av:'AV67TFAFirstFactorAuthenticationExpiration',fld:'vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION',pic:'ZZZZZZZZ9'},{av:'cmbavTfaauthenticationtypename'},{av:'AV65TFAAuthenticationTypeName',fld:'vTFAAUTHENTICATIONTYPENAME',pic:''},{av:'AV69TypeId',fld:'vTYPEID',pic:''},{av:'cmbavOtpgenerationtype'},{av:'AV54OTPGenerationType',fld:'vOTPGENERATIONTYPE',pic:''}]");
      setEventMetadata("VTFAENABLE.CLICK",",oparms:[{av:'AV67TFAFirstFactorAuthenticationExpiration',fld:'vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION',pic:'ZZZZZZZZ9'},{av:'cmbavTfaauthenticationtypename'},{av:'AV65TFAAuthenticationTypeName',fld:'vTFAAUTHENTICATIONTYPENAME',pic:''},{av:'cmbavImpersonate'},{av:'divImpersonate_cell_Class',ctrl:'IMPERSONATE_CELL',prop:'Class'},{av:'chkavTfaenable.getVisible()',ctrl:'vTFAENABLE',prop:'Visible'},{av:'divTfaenable_cell_Class',ctrl:'TFAENABLE_CELL',prop:'Class'},{av:'divTfaauthenticationtypename_cell_Class',ctrl:'TFAAUTHENTICATIONTYPENAME_CELL',prop:'Class'},{av:'edtavTfafirstfactorauthenticationexpiration_Visible',ctrl:'vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION',prop:'Visible'},{av:'divTfafirstfactorauthenticationexpiration_cell_Class',ctrl:'TFAFIRSTFACTORAUTHENTICATIONEXPIRATION_CELL',prop:'Class'},{av:'chkavTfaforceforallusers.getVisible()',ctrl:'vTFAFORCEFORALLUSERS',prop:'Visible'},{av:'divTfaforceforallusers_cell_Class',ctrl:'TFAFORCEFORALLUSERS_CELL',prop:'Class'},{av:'edtavClientid_Visible',ctrl:'vCLIENTID',prop:'Visible'},{av:'divClientid_cell_Class',ctrl:'CLIENTID_CELL',prop:'Class'},{av:'edtavClientsecret_Visible',ctrl:'vCLIENTSECRET',prop:'Visible'},{av:'divClientsecret_cell_Class',ctrl:'CLIENTSECRET_CELL',prop:'Class'},{av:'edtavVersionpath_Visible',ctrl:'vVERSIONPATH',prop:'Visible'},{av:'divVersionpath_cell_Class',ctrl:'VERSIONPATH_CELL',prop:'Class'},{av:'edtavSiteurl_Visible',ctrl:'vSITEURL',prop:'Visible'},{av:'divSiteurl_cell_Class',ctrl:'SITEURL_CELL',prop:'Class'},{av:'chkavSiteurlcallbackiscustom.getVisible()',ctrl:'vSITEURLCALLBACKISCUSTOM',prop:'Visible'},{av:'divSiteurlcallbackiscustom_cell_Class',ctrl:'SITEURLCALLBACKISCUSTOM_CELL',prop:'Class'},{av:'edtavConsumerkey_Visible',ctrl:'vCONSUMERKEY',prop:'Visible'},{av:'divConsumerkey_cell_Class',ctrl:'CONSUMERKEY_CELL',prop:'Class'},{av:'edtavConsumersecret_Visible',ctrl:'vCONSUMERSECRET',prop:'Visible'},{av:'divConsumersecret_cell_Class',ctrl:'CONSUMERSECRET_CELL',prop:'Class'},{av:'edtavCallbackurl_Visible',ctrl:'vCALLBACKURL',prop:'Visible'},{av:'divCallbackurl_cell_Class',ctrl:'CALLBACKURL_CELL',prop:'Class'},{av:'chkavAdduseradditionaldatascope.getVisible()',ctrl:'vADDUSERADDITIONALDATASCOPE',prop:'Visible'},{av:'divAdduseradditionaldatascope_cell_Class',ctrl:'ADDUSERADDITIONALDATASCOPE_CELL',prop:'Class'},{av:'chkavAddinitialpropertiesscope.getVisible()',ctrl:'vADDINITIALPROPERTIESSCOPE',prop:'Visible'},{av:'divAddinitialpropertiesscope_cell_Class',ctrl:'ADDINITIALPROPERTIESSCOPE_CELL',prop:'Class'},{av:'edtavAdditionalscope_Visible',ctrl:'vADDITIONALSCOPE',prop:'Visible'},{av:'divAdditionalscope_cell_Class',ctrl:'ADDITIONALSCOPE_CELL',prop:'Class'},{av:'edtavGamrauthenticationtypename_Visible',ctrl:'vGAMRAUTHENTICATIONTYPENAME',prop:'Visible'},{av:'divGamrauthenticationtypename_cell_Class',ctrl:'GAMRAUTHENTICATIONTYPENAME_CELL',prop:'Class'},{av:'divCusfilename_cell_Class',ctrl:'CUSFILENAME_CELL',prop:'Class'},{av:'divCusclassname_cell_Class',ctrl:'CUSCLASSNAME_CELL',prop:'Class'},{av:'divWsservername_cell_Class',ctrl:'WSSERVERNAME_CELL',prop:'Class'},{av:'divWsserverport_cell_Class',ctrl:'WSSERVERPORT_CELL',prop:'Class'},{av:'divWsname_cell_Class',ctrl:'WSNAME_CELL',prop:'Class'},{av:'divGamrserverurl_cell_Class',ctrl:'GAMRSERVERURL_CELL',prop:'Class'},{av:'edtavGamrprivateencryptkey_Visible',ctrl:'vGAMRPRIVATEENCRYPTKEY',prop:'Visible'},{av:'divGamrprivateencryptkey_cell_Class',ctrl:'GAMRPRIVATEENCRYPTKEY_CELL',prop:'Class'},{av:'edtavGamrrepositoryguid_Visible',ctrl:'vGAMRREPOSITORYGUID',prop:'Visible'},{av:'divGamrrepositoryguid_cell_Class',ctrl:'GAMRREPOSITORYGUID_CELL',prop:'Class'},{av:'cmbavOtpgenerationtype_customeventgeneratecode'},{av:'divOtpgenerationtype_customeventgeneratecode_cell_Class',ctrl:'OTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE_CELL',prop:'Class'},{av:'edtavOtpautogeneratedcodelength_Visible',ctrl:'vOTPAUTOGENERATEDCODELENGTH',prop:'Visible'},{av:'divOtpautogeneratedcodelength_cell_Class',ctrl:'OTPAUTOGENERATEDCODELENGTH_CELL',prop:'Class'},{av:'chkavOtpgeneratecodeonlynumbers.getVisible()',ctrl:'vOTPGENERATECODEONLYNUMBERS',prop:'Visible'},{av:'divOtpgeneratecodeonlynumbers_cell_Class',ctrl:'OTPGENERATECODEONLYNUMBERS_CELL',prop:'Class'},{av:'divTblsendandvalidateotpcode_Visible',ctrl:'TBLSENDANDVALIDATEOTPCODE',prop:'Visible'}]}");
      setEventMetadata("VOTPGENERATIONTYPE.CLICK","{handler:'e162Z2',iparms:[{av:'cmbavOtpgenerationtype'},{av:'AV54OTPGenerationType',fld:'vOTPGENERATIONTYPE',pic:''},{av:'cmbavOtpgenerationtype_customeventgeneratecode'},{av:'AV55OTPGenerationType_CustomEventGenerateCode',fld:'vOTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE',pic:''},{av:'AV69TypeId',fld:'vTYPEID',pic:''},{av:'AV66TFAEnable',fld:'vTFAENABLE',pic:''}]");
      setEventMetadata("VOTPGENERATIONTYPE.CLICK",",oparms:[{av:'cmbavOtpgenerationtype_customeventgeneratecode'},{av:'AV55OTPGenerationType_CustomEventGenerateCode',fld:'vOTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE',pic:''},{av:'cmbavImpersonate'},{av:'divImpersonate_cell_Class',ctrl:'IMPERSONATE_CELL',prop:'Class'},{av:'chkavTfaenable.getVisible()',ctrl:'vTFAENABLE',prop:'Visible'},{av:'divTfaenable_cell_Class',ctrl:'TFAENABLE_CELL',prop:'Class'},{av:'cmbavTfaauthenticationtypename'},{av:'divTfaauthenticationtypename_cell_Class',ctrl:'TFAAUTHENTICATIONTYPENAME_CELL',prop:'Class'},{av:'edtavTfafirstfactorauthenticationexpiration_Visible',ctrl:'vTFAFIRSTFACTORAUTHENTICATIONEXPIRATION',prop:'Visible'},{av:'divTfafirstfactorauthenticationexpiration_cell_Class',ctrl:'TFAFIRSTFACTORAUTHENTICATIONEXPIRATION_CELL',prop:'Class'},{av:'chkavTfaforceforallusers.getVisible()',ctrl:'vTFAFORCEFORALLUSERS',prop:'Visible'},{av:'divTfaforceforallusers_cell_Class',ctrl:'TFAFORCEFORALLUSERS_CELL',prop:'Class'},{av:'edtavClientid_Visible',ctrl:'vCLIENTID',prop:'Visible'},{av:'divClientid_cell_Class',ctrl:'CLIENTID_CELL',prop:'Class'},{av:'edtavClientsecret_Visible',ctrl:'vCLIENTSECRET',prop:'Visible'},{av:'divClientsecret_cell_Class',ctrl:'CLIENTSECRET_CELL',prop:'Class'},{av:'edtavVersionpath_Visible',ctrl:'vVERSIONPATH',prop:'Visible'},{av:'divVersionpath_cell_Class',ctrl:'VERSIONPATH_CELL',prop:'Class'},{av:'edtavSiteurl_Visible',ctrl:'vSITEURL',prop:'Visible'},{av:'divSiteurl_cell_Class',ctrl:'SITEURL_CELL',prop:'Class'},{av:'chkavSiteurlcallbackiscustom.getVisible()',ctrl:'vSITEURLCALLBACKISCUSTOM',prop:'Visible'},{av:'divSiteurlcallbackiscustom_cell_Class',ctrl:'SITEURLCALLBACKISCUSTOM_CELL',prop:'Class'},{av:'edtavConsumerkey_Visible',ctrl:'vCONSUMERKEY',prop:'Visible'},{av:'divConsumerkey_cell_Class',ctrl:'CONSUMERKEY_CELL',prop:'Class'},{av:'edtavConsumersecret_Visible',ctrl:'vCONSUMERSECRET',prop:'Visible'},{av:'divConsumersecret_cell_Class',ctrl:'CONSUMERSECRET_CELL',prop:'Class'},{av:'edtavCallbackurl_Visible',ctrl:'vCALLBACKURL',prop:'Visible'},{av:'divCallbackurl_cell_Class',ctrl:'CALLBACKURL_CELL',prop:'Class'},{av:'chkavAdduseradditionaldatascope.getVisible()',ctrl:'vADDUSERADDITIONALDATASCOPE',prop:'Visible'},{av:'divAdduseradditionaldatascope_cell_Class',ctrl:'ADDUSERADDITIONALDATASCOPE_CELL',prop:'Class'},{av:'chkavAddinitialpropertiesscope.getVisible()',ctrl:'vADDINITIALPROPERTIESSCOPE',prop:'Visible'},{av:'divAddinitialpropertiesscope_cell_Class',ctrl:'ADDINITIALPROPERTIESSCOPE_CELL',prop:'Class'},{av:'edtavAdditionalscope_Visible',ctrl:'vADDITIONALSCOPE',prop:'Visible'},{av:'divAdditionalscope_cell_Class',ctrl:'ADDITIONALSCOPE_CELL',prop:'Class'},{av:'edtavGamrauthenticationtypename_Visible',ctrl:'vGAMRAUTHENTICATIONTYPENAME',prop:'Visible'},{av:'divGamrauthenticationtypename_cell_Class',ctrl:'GAMRAUTHENTICATIONTYPENAME_CELL',prop:'Class'},{av:'divCusfilename_cell_Class',ctrl:'CUSFILENAME_CELL',prop:'Class'},{av:'divCusclassname_cell_Class',ctrl:'CUSCLASSNAME_CELL',prop:'Class'},{av:'divWsservername_cell_Class',ctrl:'WSSERVERNAME_CELL',prop:'Class'},{av:'divWsserverport_cell_Class',ctrl:'WSSERVERPORT_CELL',prop:'Class'},{av:'divWsname_cell_Class',ctrl:'WSNAME_CELL',prop:'Class'},{av:'divGamrserverurl_cell_Class',ctrl:'GAMRSERVERURL_CELL',prop:'Class'},{av:'edtavGamrprivateencryptkey_Visible',ctrl:'vGAMRPRIVATEENCRYPTKEY',prop:'Visible'},{av:'divGamrprivateencryptkey_cell_Class',ctrl:'GAMRPRIVATEENCRYPTKEY_CELL',prop:'Class'},{av:'edtavGamrrepositoryguid_Visible',ctrl:'vGAMRREPOSITORYGUID',prop:'Visible'},{av:'divGamrrepositoryguid_cell_Class',ctrl:'GAMRREPOSITORYGUID_CELL',prop:'Class'},{av:'divOtpgenerationtype_customeventgeneratecode_cell_Class',ctrl:'OTPGENERATIONTYPE_CUSTOMEVENTGENERATECODE_CELL',prop:'Class'},{av:'edtavOtpautogeneratedcodelength_Visible',ctrl:'vOTPAUTOGENERATEDCODELENGTH',prop:'Visible'},{av:'divOtpautogeneratedcodelength_cell_Class',ctrl:'OTPAUTOGENERATEDCODELENGTH_CELL',prop:'Class'},{av:'chkavOtpgeneratecodeonlynumbers.getVisible()',ctrl:'vOTPGENERATECODEONLYNUMBERS',prop:'Visible'},{av:'divOtpgeneratecodeonlynumbers_cell_Class',ctrl:'OTPGENERATECODEONLYNUMBERS_CELL',prop:'Class'},{av:'divTblsendandvalidateotpcode_Visible',ctrl:'TBLSENDANDVALIDATEOTPCODE',prop:'Visible'}]}");
      setEventMetadata("VALIDV_FUNCTIONID","{handler:'validv_Functionid',iparms:[]");
      setEventMetadata("VALIDV_FUNCTIONID",",oparms:[]}");
      setEventMetadata("VALIDV_OTPGENERATIONTYPE","{handler:'validv_Otpgenerationtype',iparms:[]");
      setEventMetadata("VALIDV_OTPGENERATIONTYPE",",oparms:[]}");
      setEventMetadata("VALIDV_WSVERSION","{handler:'validv_Wsversion',iparms:[]");
      setEventMetadata("VALIDV_WSVERSION",",oparms:[]}");
      setEventMetadata("VALIDV_CUSVERSION","{handler:'validv_Cusversion',iparms:[]");
      setEventMetadata("VALIDV_CUSVERSION",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
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
      wcpOGx_mode = "" ;
      wcpOAV46Name = "" ;
      wcpOAV69TypeId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      Gx_mode = "" ;
      AV46Name = "" ;
      AV69TypeId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      AV37FunctionId = "" ;
      AV33Dsc = "" ;
      AV64SmallImageName = "" ;
      AV22BigImageName = "" ;
      AV44Impersonate = "" ;
      AV65TFAAuthenticationTypeName = "" ;
      AV52OTPEventValidateUser = "" ;
      AV54OTPGenerationType = "" ;
      AV55OTPGenerationType_CustomEventGenerateCode = "" ;
      AV50OTPEventSendCode = "" ;
      AV57OTPMailMessageSubject = "" ;
      AV56OTPMailMessageBodyHTML = "" ;
      AV51OTPEventValidateCode = "" ;
      AV24ClientId = "" ;
      AV25ClientSecret = "" ;
      AV70VersionPath = "" ;
      AV62SiteURL = "" ;
      AV26ConsumerKey = "" ;
      AV27ConsumerSecret = "" ;
      AV23CallbackURL = "" ;
      AV6AdditionalScope = "" ;
      AV40GAMRAuthenticationTypeName = "" ;
      AV43GAMRServerURL = "" ;
      AV41GAMRPrivateEncryptKey = "" ;
      AV42GAMRRepositoryGUID = "" ;
      AV80WSVersion = "" ;
      lblTextblockwsprivateencryptkey_Jsonclick = "" ;
      AV76WSServerName = "" ;
      AV75WSServerBaseURL = "" ;
      AV78WSServerSecureProtocol = (byte)(0) ;
      AV73WSPackage = "" ;
      AV72WSName = "" ;
      AV71WSExtension = "" ;
      AV32CusVersion = "" ;
      lblTextblockcusprivateencryptkey_Jsonclick = "" ;
      AV29CusFileName = "" ;
      AV30CusPackage = "" ;
      AV28CusClassName = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV74WSPrivateEncryptKey = "" ;
      AV31CusPrivateEncryptKey = "" ;
      AV15AuthenticationTypeLocal = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeLocal(remoteHandle, context);
      AV9AuthenticationTypeApple = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeApple(remoteHandle, context);
      AV10AuthenticationTypeCustom = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeCustom(remoteHandle, context);
      AV19AuthenticationTypeWebService = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeWebService(remoteHandle, context);
      AV11AuthenticationTypeFacebook = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeFacebook(remoteHandle, context);
      AV12AuthenticationTypeGAMRemote = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeGAMRemote(remoteHandle, context);
      AV13AuthenticationTypeGAMRemoteRest = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeGAMRemoteRest(remoteHandle, context);
      AV14AuthenticationTypeGoogle = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeGoogle(remoteHandle, context);
      AV17AuthenticationTypeOTP = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOTP(remoteHandle, context);
      AV18AuthenticationTypeTwitter = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeTwitter(remoteHandle, context);
      AV20AuthenticationTypeWeChat = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeWeChat(remoteHandle, context);
      AV16AuthenticationTypeOauth20 = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOauth20(remoteHandle, context);
      AV35Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV34Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      AV38GAMAuthenticationTypeFilter = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeFilter(remoteHandle, context);
      AV39GAMEventSubscriptionFilter = new genexus.security.api.genexussecurity.SdtGAMEventSubscriptionFilter(remoteHandle, context);
      AV88GXV2 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationType>(genexus.security.api.genexussecurity.SdtGAMAuthenticationType.class, "GAMAuthenticationType", "http://tempuri.org/", remoteHandle);
      AV8AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationType(remoteHandle, context);
      AV90GXV4 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationType>(genexus.security.api.genexussecurity.SdtGAMAuthenticationType.class, "GAMAuthenticationType", "http://tempuri.org/", remoteHandle);
      AV92GXV6 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription>(genexus.security.api.genexussecurity.SdtGAMEventSubscription.class, "GAMEventSubscription", "http://tempuri.org/", remoteHandle);
      AV36EventSuscription = new genexus.security.api.genexussecurity.SdtGAMEventSubscription(remoteHandle, context);
      AV94GXV8 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription>(genexus.security.api.genexussecurity.SdtGAMEventSubscription.class, "GAMEventSubscription", "http://tempuri.org/", remoteHandle);
      AV96GXV10 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription>(genexus.security.api.genexussecurity.SdtGAMEventSubscription.class, "GAMEventSubscription", "http://tempuri.org/", remoteHandle);
      AV98GXV12 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription>(genexus.security.api.genexussecurity.SdtGAMEventSubscription.class, "GAMEventSubscription", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      sStyleString = "" ;
      bttBtngenkeycustom_Jsonclick = "" ;
      bttBtngenkey_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlGx_mode = "" ;
      sCtrlAV46Name = "" ;
      sCtrlAV69TypeId = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwcauthenticationtypeentrygeneral__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwcauthenticationtypeentrygeneral__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte AV78WSServerSecureProtocol ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV47OTPAutogeneratedCodeLength ;
   private short AV58OTPMaximumDailyNumberCodes ;
   private short AV60OTPNumberUnsuccessfulRetriesToLockOTP ;
   private short AV59OTPNumberUnsuccessfulRetriesToBlockUserBasedOfOTPLocks ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavSmallimagename_Enabled ;
   private int edtavBigimagename_Enabled ;
   private int edtavTfafirstfactorauthenticationexpiration_Visible ;
   private int AV67TFAFirstFactorAuthenticationExpiration ;
   private int edtavTfafirstfactorauthenticationexpiration_Enabled ;
   private int divTblotpauthentication_Visible ;
   private int divTblotpconfiguration_Visible ;
   private int edtavOtpautogeneratedcodelength_Visible ;
   private int edtavOtpautogeneratedcodelength_Enabled ;
   private int AV49OTPCodeExpirationTimeout ;
   private int edtavOtpcodeexpirationtimeout_Enabled ;
   private int edtavOtpmaximumdailynumbercodes_Enabled ;
   private int edtavOtpnumberunsuccessfulretriestolockotp_Enabled ;
   private int AV48OTPAutoUnlockTime ;
   private int edtavOtpautounlocktime_Enabled ;
   private int edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Enabled ;
   private int divTblsendandvalidateotpcode_Visible ;
   private int edtavOtpmailmessagesubject_Enabled ;
   private int edtavOtpmailmessagebodyhtml_Enabled ;
   private int edtavClientid_Visible ;
   private int edtavClientid_Enabled ;
   private int edtavClientsecret_Visible ;
   private int edtavClientsecret_Enabled ;
   private int edtavVersionpath_Visible ;
   private int edtavVersionpath_Enabled ;
   private int edtavSiteurl_Visible ;
   private int edtavSiteurl_Enabled ;
   private int edtavConsumerkey_Visible ;
   private int edtavConsumerkey_Enabled ;
   private int edtavConsumersecret_Visible ;
   private int edtavConsumersecret_Enabled ;
   private int edtavCallbackurl_Visible ;
   private int edtavCallbackurl_Enabled ;
   private int edtavAdditionalscope_Visible ;
   private int edtavAdditionalscope_Enabled ;
   private int edtavGamrauthenticationtypename_Visible ;
   private int edtavGamrauthenticationtypename_Enabled ;
   private int divTblserverhost_Visible ;
   private int edtavGamrserverurl_Enabled ;
   private int edtavGamrprivateencryptkey_Visible ;
   private int edtavGamrprivateencryptkey_Enabled ;
   private int edtavGamrrepositoryguid_Visible ;
   private int edtavGamrrepositoryguid_Enabled ;
   private int divTblwebservice_Visible ;
   private int edtavWsservername_Enabled ;
   private int AV77WSServerPort ;
   private int edtavWsserverport_Enabled ;
   private int edtavWsserverbaseurl_Enabled ;
   private int AV79WSTimeout ;
   private int edtavWstimeout_Enabled ;
   private int edtavWspackage_Enabled ;
   private int edtavWsname_Enabled ;
   private int edtavWsextension_Enabled ;
   private int divTblexternal_Visible ;
   private int edtavCusfilename_Enabled ;
   private int edtavCuspackage_Enabled ;
   private int edtavCusclassname_Enabled ;
   private int bttBtnenter_Visible ;
   private int bttBtngenkey_Visible ;
   private int bttBtngenkeycustom_Visible ;
   private int edtavWsprivateencryptkey_Enabled ;
   private int edtavCusprivateencryptkey_Enabled ;
   private int AV87GXV1 ;
   private int AV89GXV3 ;
   private int AV91GXV5 ;
   private int AV93GXV7 ;
   private int AV95GXV9 ;
   private int AV97GXV11 ;
   private int AV99GXV13 ;
   private int idxLst ;
   private String wcpOGx_mode ;
   private String wcpOAV46Name ;
   private String wcpOAV69TypeId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String Gx_mode ;
   private String AV46Name ;
   private String AV69TypeId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavName_Internalname ;
   private String TempTags ;
   private String edtavName_Jsonclick ;
   private String AV37FunctionId ;
   private String edtavDsc_Internalname ;
   private String AV33Dsc ;
   private String edtavDsc_Jsonclick ;
   private String edtavSmallimagename_Internalname ;
   private String AV64SmallImageName ;
   private String edtavSmallimagename_Jsonclick ;
   private String edtavBigimagename_Internalname ;
   private String AV22BigImageName ;
   private String edtavBigimagename_Jsonclick ;
   private String divImpersonate_cell_Internalname ;
   private String divImpersonate_cell_Class ;
   private String AV44Impersonate ;
   private String divTfaenable_cell_Internalname ;
   private String divTfaenable_cell_Class ;
   private String divTfaauthenticationtypename_cell_Internalname ;
   private String divTfaauthenticationtypename_cell_Class ;
   private String AV65TFAAuthenticationTypeName ;
   private String divTfafirstfactorauthenticationexpiration_cell_Internalname ;
   private String divTfafirstfactorauthenticationexpiration_cell_Class ;
   private String edtavTfafirstfactorauthenticationexpiration_Internalname ;
   private String edtavTfafirstfactorauthenticationexpiration_Jsonclick ;
   private String divTfaforceforallusers_cell_Internalname ;
   private String divTfaforceforallusers_cell_Class ;
   private String divTblotpauthentication_Internalname ;
   private String divTblotpconfiguration_Internalname ;
   private String AV52OTPEventValidateUser ;
   private String divOtpgenerationtype_customeventgeneratecode_cell_Internalname ;
   private String divOtpgenerationtype_customeventgeneratecode_cell_Class ;
   private String AV55OTPGenerationType_CustomEventGenerateCode ;
   private String divOtpautogeneratedcodelength_cell_Internalname ;
   private String divOtpautogeneratedcodelength_cell_Class ;
   private String edtavOtpautogeneratedcodelength_Internalname ;
   private String edtavOtpautogeneratedcodelength_Jsonclick ;
   private String divOtpgeneratecodeonlynumbers_cell_Internalname ;
   private String divOtpgeneratecodeonlynumbers_cell_Class ;
   private String edtavOtpcodeexpirationtimeout_Internalname ;
   private String edtavOtpcodeexpirationtimeout_Jsonclick ;
   private String edtavOtpmaximumdailynumbercodes_Internalname ;
   private String edtavOtpmaximumdailynumbercodes_Jsonclick ;
   private String edtavOtpnumberunsuccessfulretriestolockotp_Internalname ;
   private String edtavOtpnumberunsuccessfulretriestolockotp_Jsonclick ;
   private String edtavOtpautounlocktime_Internalname ;
   private String edtavOtpautounlocktime_Jsonclick ;
   private String edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Internalname ;
   private String edtavOtpnumberunsuccessfulretriestoblockuserbasedofotplocks_Jsonclick ;
   private String divTblsendandvalidateotpcode_Internalname ;
   private String AV50OTPEventSendCode ;
   private String edtavOtpmailmessagesubject_Internalname ;
   private String AV57OTPMailMessageSubject ;
   private String edtavOtpmailmessagesubject_Jsonclick ;
   private String edtavOtpmailmessagebodyhtml_Internalname ;
   private String AV51OTPEventValidateCode ;
   private String divClientid_cell_Internalname ;
   private String divClientid_cell_Class ;
   private String edtavClientid_Internalname ;
   private String edtavClientid_Jsonclick ;
   private String divClientsecret_cell_Internalname ;
   private String divClientsecret_cell_Class ;
   private String edtavClientsecret_Internalname ;
   private String edtavClientsecret_Jsonclick ;
   private String divVersionpath_cell_Internalname ;
   private String divVersionpath_cell_Class ;
   private String edtavVersionpath_Internalname ;
   private String AV70VersionPath ;
   private String edtavVersionpath_Jsonclick ;
   private String divSiteurl_cell_Internalname ;
   private String divSiteurl_cell_Class ;
   private String edtavSiteurl_Internalname ;
   private String edtavSiteurl_Jsonclick ;
   private String divSiteurlcallbackiscustom_cell_Internalname ;
   private String divSiteurlcallbackiscustom_cell_Class ;
   private String divConsumerkey_cell_Internalname ;
   private String divConsumerkey_cell_Class ;
   private String edtavConsumerkey_Internalname ;
   private String AV26ConsumerKey ;
   private String edtavConsumerkey_Jsonclick ;
   private String divConsumersecret_cell_Internalname ;
   private String divConsumersecret_cell_Class ;
   private String edtavConsumersecret_Internalname ;
   private String AV27ConsumerSecret ;
   private String edtavConsumersecret_Jsonclick ;
   private String divCallbackurl_cell_Internalname ;
   private String divCallbackurl_cell_Class ;
   private String edtavCallbackurl_Internalname ;
   private String edtavCallbackurl_Jsonclick ;
   private String divAdduseradditionaldatascope_cell_Internalname ;
   private String divAdduseradditionaldatascope_cell_Class ;
   private String divAddinitialpropertiesscope_cell_Internalname ;
   private String divAddinitialpropertiesscope_cell_Class ;
   private String divAdditionalscope_cell_Internalname ;
   private String divAdditionalscope_cell_Class ;
   private String edtavAdditionalscope_Internalname ;
   private String edtavAdditionalscope_Jsonclick ;
   private String divGamrauthenticationtypename_cell_Internalname ;
   private String divGamrauthenticationtypename_cell_Class ;
   private String edtavGamrauthenticationtypename_Internalname ;
   private String AV40GAMRAuthenticationTypeName ;
   private String edtavGamrauthenticationtypename_Jsonclick ;
   private String divTblserverhost_Internalname ;
   private String divGamrserverurl_cell_Internalname ;
   private String divGamrserverurl_cell_Class ;
   private String edtavGamrserverurl_Internalname ;
   private String edtavGamrserverurl_Jsonclick ;
   private String divGamrprivateencryptkey_cell_Internalname ;
   private String divGamrprivateencryptkey_cell_Class ;
   private String edtavGamrprivateencryptkey_Internalname ;
   private String AV41GAMRPrivateEncryptKey ;
   private String edtavGamrprivateencryptkey_Jsonclick ;
   private String divGamrrepositoryguid_cell_Internalname ;
   private String divGamrrepositoryguid_cell_Class ;
   private String edtavGamrrepositoryguid_Internalname ;
   private String AV42GAMRRepositoryGUID ;
   private String edtavGamrrepositoryguid_Jsonclick ;
   private String divTblwebservice_Internalname ;
   private String AV80WSVersion ;
   private String divTablesplittedwsprivateencryptkey_Internalname ;
   private String lblTextblockwsprivateencryptkey_Internalname ;
   private String lblTextblockwsprivateencryptkey_Jsonclick ;
   private String divWsservername_cell_Internalname ;
   private String divWsservername_cell_Class ;
   private String edtavWsservername_Internalname ;
   private String AV76WSServerName ;
   private String edtavWsservername_Jsonclick ;
   private String divWsserverport_cell_Internalname ;
   private String divWsserverport_cell_Class ;
   private String edtavWsserverport_Internalname ;
   private String edtavWsserverport_Jsonclick ;
   private String edtavWsserverbaseurl_Internalname ;
   private String edtavWsserverbaseurl_Jsonclick ;
   private String edtavWstimeout_Internalname ;
   private String edtavWstimeout_Jsonclick ;
   private String edtavWspackage_Internalname ;
   private String AV73WSPackage ;
   private String edtavWspackage_Jsonclick ;
   private String divWsname_cell_Internalname ;
   private String divWsname_cell_Class ;
   private String edtavWsname_Internalname ;
   private String AV72WSName ;
   private String edtavWsname_Jsonclick ;
   private String edtavWsextension_Internalname ;
   private String AV71WSExtension ;
   private String edtavWsextension_Jsonclick ;
   private String divTblexternal_Internalname ;
   private String AV32CusVersion ;
   private String divTablesplittedcusprivateencryptkey_Internalname ;
   private String lblTextblockcusprivateencryptkey_Internalname ;
   private String lblTextblockcusprivateencryptkey_Jsonclick ;
   private String divCusfilename_cell_Internalname ;
   private String divCusfilename_cell_Class ;
   private String edtavCusfilename_Internalname ;
   private String AV29CusFileName ;
   private String edtavCusfilename_Jsonclick ;
   private String edtavCuspackage_Internalname ;
   private String AV30CusPackage ;
   private String edtavCuspackage_Jsonclick ;
   private String divCusclassname_cell_Internalname ;
   private String divCusclassname_cell_Class ;
   private String edtavCusclassname_Internalname ;
   private String AV28CusClassName ;
   private String edtavCusclassname_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV74WSPrivateEncryptKey ;
   private String edtavWsprivateencryptkey_Internalname ;
   private String AV31CusPrivateEncryptKey ;
   private String edtavCusprivateencryptkey_Internalname ;
   private String bttBtngenkey_Internalname ;
   private String bttBtngenkeycustom_Internalname ;
   private String sStyleString ;
   private String tblTablemergedcusprivateencryptkey_Internalname ;
   private String edtavCusprivateencryptkey_Jsonclick ;
   private String bttBtngenkeycustom_Jsonclick ;
   private String tblTablemergedwsprivateencryptkey_Internalname ;
   private String edtavWsprivateencryptkey_Jsonclick ;
   private String bttBtngenkey_Jsonclick ;
   private String sCtrlGx_mode ;
   private String sCtrlAV46Name ;
   private String sCtrlAV69TypeId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV83CheckRequiredFieldsResult ;
   private boolean wbLoad ;
   private boolean AV45IsEnable ;
   private boolean AV66TFAEnable ;
   private boolean AV68TFAForceForAllUsers ;
   private boolean AV61OTPUseForFirstFactorAuthentication ;
   private boolean AV53OTPGenerateCodeOnlyNumbers ;
   private boolean AV63SiteURLCallbackIsCustom ;
   private boolean AV7AddUserAdditionalDataScope ;
   private boolean AV5AddInitialPropertiesScope ;
   private boolean AV21AutovalidateExternalTokenAndRefresh ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV54OTPGenerationType ;
   private String AV56OTPMailMessageBodyHTML ;
   private String AV24ClientId ;
   private String AV25ClientSecret ;
   private String AV62SiteURL ;
   private String AV23CallbackURL ;
   private String AV6AdditionalScope ;
   private String AV43GAMRServerURL ;
   private String AV75WSServerBaseURL ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private HTMLChoice cmbavFunctionid ;
   private ICheckbox chkavIsenable ;
   private HTMLChoice cmbavImpersonate ;
   private ICheckbox chkavTfaenable ;
   private HTMLChoice cmbavTfaauthenticationtypename ;
   private ICheckbox chkavTfaforceforallusers ;
   private ICheckbox chkavOtpuseforfirstfactorauthentication ;
   private HTMLChoice cmbavOtpeventvalidateuser ;
   private HTMLChoice cmbavOtpgenerationtype ;
   private HTMLChoice cmbavOtpgenerationtype_customeventgeneratecode ;
   private ICheckbox chkavOtpgeneratecodeonlynumbers ;
   private HTMLChoice cmbavOtpeventsendcode ;
   private HTMLChoice cmbavOtpeventvalidatecode ;
   private ICheckbox chkavSiteurlcallbackiscustom ;
   private ICheckbox chkavAdduseradditionaldatascope ;
   private ICheckbox chkavAddinitialpropertiesscope ;
   private ICheckbox chkavAutovalidateexternaltokenandrefresh ;
   private HTMLChoice cmbavWsversion ;
   private HTMLChoice cmbavWsserversecureprotocol ;
   private HTMLChoice cmbavCusversion ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationType> AV88GXV2 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationType> AV90GXV4 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV35Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription> AV92GXV6 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription> AV94GXV8 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription> AV96GXV10 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription> AV98GXV12 ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationType AV8AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMError AV34Error ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeApple AV9AuthenticationTypeApple ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeCustom AV10AuthenticationTypeCustom ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeFacebook AV11AuthenticationTypeFacebook ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeGAMRemote AV12AuthenticationTypeGAMRemote ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeGAMRemoteRest AV13AuthenticationTypeGAMRemoteRest ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeGoogle AV14AuthenticationTypeGoogle ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeLocal AV15AuthenticationTypeLocal ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOauth20 AV16AuthenticationTypeOauth20 ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOTP AV17AuthenticationTypeOTP ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeTwitter AV18AuthenticationTypeTwitter ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeWebService AV19AuthenticationTypeWebService ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeWeChat AV20AuthenticationTypeWeChat ;
   private genexus.security.api.genexussecurity.SdtGAMEventSubscription AV36EventSuscription ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeFilter AV38GAMAuthenticationTypeFilter ;
   private genexus.security.api.genexussecurity.SdtGAMEventSubscriptionFilter AV39GAMEventSubscriptionFilter ;
}

final  class gamwcauthenticationtypeentrygeneral__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwcauthenticationtypeentrygeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

}

