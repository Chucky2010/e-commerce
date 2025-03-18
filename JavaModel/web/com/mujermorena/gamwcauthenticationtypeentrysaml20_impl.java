package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwcauthenticationtypeentrysaml20_impl extends GXWebComponent
{
   public gamwcauthenticationtypeentrysaml20_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwcauthenticationtypeentrysaml20_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwcauthenticationtypeentrysaml20_impl.class ));
   }

   public gamwcauthenticationtypeentrysaml20_impl( int remoteHandle ,
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
      chkavIsredirectbinding = UIFactory.getCheckbox(this);
      cmbavNameidpolicyformat = new HTMLChoice();
      chkavForceauthn = UIFactory.getCheckbox(this);
      chkavDisablesinglelogout = UIFactory.getCheckbox(this);
      chkavUserinforesponseuserlastnamegenauto = UIFactory.getCheckbox(this);
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
               AV32Name = httpContext.GetPar( "Name") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Name", AV32Name);
               AV41TypeId = httpContext.GetPar( "TypeId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TypeId", AV41TypeId);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Gx_mode,AV32Name,AV41TypeId});
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
            {
               gxnrgrid_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
            {
               gxgrgrid_refresh_invoke( ) ;
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_235 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_235"))) ;
      nGXsfl_235_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_235_idx"))) ;
      sGXsfl_235_idx = httpContext.GetPar( "sGXsfl_235_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV19IsEnable = GXutil.strtobool( httpContext.GetPar( "IsEnable")) ;
      AV20IsRedirectBinding = GXutil.strtobool( httpContext.GetPar( "IsRedirectBinding")) ;
      AV15ForceAuthn = GXutil.strtobool( httpContext.GetPar( "ForceAuthn")) ;
      AV67DisableSingleLogout = GXutil.strtobool( httpContext.GetPar( "DisableSingleLogout")) ;
      AV51UserInfoResponseUserLastNameGenAuto = GXutil.strtobool( httpContext.GetPar( "UserInfoResponseUserLastNameGenAuto")) ;
      AV45UserInfoResponseUserErrorDescriptionTag = httpContext.GetPar( "UserInfoResponseUserErrorDescriptionTag") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV19IsEnable, AV20IsRedirectBinding, AV15ForceAuthn, AV67DisableSingleLogout, AV51UserInfoResponseUserLastNameGenAuto, AV45UserInfoResponseUserErrorDescriptionTag, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa302( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "GAMWCAuthentication Type Entry Saml20", "")) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwcauthenticationtypeentrysaml20", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV32Name)),GXutil.URLEncode(GXutil.rtrim(AV41TypeId))}, new String[] {"Gx_mode","Name","TypeId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV45UserInfoResponseUserErrorDescriptionTag, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_235", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_235, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOGx_mode", GXutil.rtrim( wcpOGx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV32Name", GXutil.rtrim( wcpOAV32Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV41TypeId", GXutil.rtrim( wcpOAV41TypeId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCHECKREQUIREDFIELDSRESULT", AV70CheckRequiredFieldsResult);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG", GXutil.rtrim( AV45UserInfoResponseUserErrorDescriptionTag));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV45UserInfoResponseUserErrorDescriptionTag, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTYPEID", GXutil.rtrim( AV41TypeId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Width", GXutil.rtrim( Dvpanel_unnamedtable7_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable7_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable7_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Cls", GXutil.rtrim( Dvpanel_unnamedtable7_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Title", GXutil.rtrim( Dvpanel_unnamedtable7_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable7_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable7_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable7_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable7_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE7_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable7_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Width", GXutil.rtrim( Dvpanel_unnamedtable8_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable8_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable8_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Cls", GXutil.rtrim( Dvpanel_unnamedtable8_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Title", GXutil.rtrim( Dvpanel_unnamedtable8_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable8_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable8_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable8_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable8_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE8_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable8_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Width", GXutil.rtrim( Dvpanel_unnamedtable4_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable4_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable4_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Cls", GXutil.rtrim( Dvpanel_unnamedtable4_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Title", GXutil.rtrim( Dvpanel_unnamedtable4_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable4_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable4_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable4_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable4_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable4_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Width", GXutil.rtrim( Dvpanel_unnamedtable5_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable5_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable5_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Cls", GXutil.rtrim( Dvpanel_unnamedtable5_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Title", GXutil.rtrim( Dvpanel_unnamedtable5_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable5_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable5_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable5_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable5_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE5_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable5_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
   }

   public void renderHtmlCloseForm302( )
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
      return "GAMWCAuthenticationTypeEntrySaml20" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "GAMWCAuthentication Type Entry Saml20", "") ;
   }

   public void wb300( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.gamwcauthenticationtypeentrysaml20");
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
            httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
            httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV32Name), GXutil.rtrim( localUtil.format( AV32Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFunctionid, cmbavFunctionid.getInternalname(), GXutil.rtrim( AV16FunctionId), 1, cmbavFunctionid.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFunctionid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,24);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         cmbavFunctionid.setValue( GXutil.rtrim( AV16FunctionId) );
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDsc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDsc_Internalname, httpContext.getMessage( "WWP_GAM_Description", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV10Dsc), GXutil.rtrim( localUtil.format( AV10Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
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
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsenable.getInternalname(), httpContext.getMessage( "WWP_GAM_Enabled", ""), " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsenable.getInternalname(), GXutil.booltostr( AV19IsEnable), "", httpContext.getMessage( "WWP_GAM_Enabled", ""), 1, chkavIsenable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(34, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,34);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavImpersonate_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavImpersonate_Internalname, httpContext.getMessage( "WWP_GAM_Impersonate", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavImpersonate_Internalname, GXutil.rtrim( AV18Impersonate), GXutil.rtrim( localUtil.format( AV18Impersonate, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavImpersonate_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavImpersonate_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMAuthenticationTypeName", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSmallimagename_Internalname, GXutil.rtrim( AV40SmallImageName), GXutil.rtrim( localUtil.format( AV40SmallImageName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSmallimagename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSmallimagename_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavBigimagename_Internalname, GXutil.rtrim( AV7BigImageName), GXutil.rtrim( localUtil.format( AV7BigImageName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBigimagename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBigimagename_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, sPrefix+"GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "WWP_GAM_General", ""), "", "", lblGeneral_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable6_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLocalsiteurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavLocalsiteurl_Internalname, httpContext.getMessage( "WWP_GAM_LocalSiteURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavLocalsiteurl_Internalname, AV30LocalSiteURL, GXutil.rtrim( localUtil.format( AV30LocalSiteURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLocalsiteurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavLocalsiteurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavServiceproviderentityid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavServiceproviderentityid_Internalname, httpContext.getMessage( "WWP_GAM_ServiceProviderEntityID", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavServiceproviderentityid_Internalname, AV37ServiceProviderEntityId, GXutil.rtrim( localUtil.format( AV37ServiceProviderEntityId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavServiceproviderentityid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavServiceproviderentityid_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavIdentityproviderentityid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavIdentityproviderentityid_Internalname, httpContext.getMessage( "WWP_GAM_IdentityProviderEntityId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavIdentityproviderentityid_Internalname, AV38IdentityProviderEntityID, GXutil.rtrim( localUtil.format( AV38IdentityProviderEntityID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavIdentityproviderentityid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavIdentityproviderentityid_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsredirectbinding.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsredirectbinding.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsredirectbinding.getInternalname(), GXutil.booltostr( AV20IsRedirectBinding), "", " ", 1, chkavIsredirectbinding.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_ExecuteSAMLRequestsGET", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(73, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,73);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable7.setProperty("Width", Dvpanel_unnamedtable7_Width);
         ucDvpanel_unnamedtable7.setProperty("AutoWidth", Dvpanel_unnamedtable7_Autowidth);
         ucDvpanel_unnamedtable7.setProperty("AutoHeight", Dvpanel_unnamedtable7_Autoheight);
         ucDvpanel_unnamedtable7.setProperty("Cls", Dvpanel_unnamedtable7_Cls);
         ucDvpanel_unnamedtable7.setProperty("Title", Dvpanel_unnamedtable7_Title);
         ucDvpanel_unnamedtable7.setProperty("Collapsible", Dvpanel_unnamedtable7_Collapsible);
         ucDvpanel_unnamedtable7.setProperty("Collapsed", Dvpanel_unnamedtable7_Collapsed);
         ucDvpanel_unnamedtable7.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable7_Showcollapseicon);
         ucDvpanel_unnamedtable7.setProperty("IconPosition", Dvpanel_unnamedtable7_Iconposition);
         ucDvpanel_unnamedtable7.setProperty("AutoScroll", Dvpanel_unnamedtable7_Autoscroll);
         ucDvpanel_unnamedtable7.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable7_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE7Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE7Container"+"UnnamedTable7"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable7_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSamlendpointlocation_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSamlendpointlocation_Internalname, httpContext.getMessage( "WWP_GAM_SamlEndpointLocation", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSamlendpointlocation_Internalname, AV36SamlEndpointLocation, GXutil.rtrim( localUtil.format( AV36SamlEndpointLocation, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSamlendpointlocation_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSamlendpointlocation_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavNameidpolicyformat.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavNameidpolicyformat.getInternalname(), httpContext.getMessage( "WWP_GAM_NameIDPolicyFormat", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavNameidpolicyformat, cmbavNameidpolicyformat.getInternalname(), GXutil.rtrim( AV69NameIdPolicyFormat), 1, cmbavNameidpolicyformat.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavNameidpolicyformat.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         cmbavNameidpolicyformat.setValue( GXutil.rtrim( AV69NameIdPolicyFormat) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavNameidpolicyformat.getInternalname(), "Values", cmbavNameidpolicyformat.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavForceauthn.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavForceauthn.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavForceauthn.getInternalname(), GXutil.booltostr( AV15ForceAuthn), "", " ", 1, chkavForceauthn.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_ForceAuthentication", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(92, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,92);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthncontext_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthncontext_Internalname, httpContext.getMessage( "WWP_GAM_AuthenticationContext", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthncontext_Internalname, GXutil.rtrim( AV6AuthnContext), GXutil.rtrim( localUtil.format( AV6AuthnContext, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,96);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthncontext_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthncontext_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable8.setProperty("Width", Dvpanel_unnamedtable8_Width);
         ucDvpanel_unnamedtable8.setProperty("AutoWidth", Dvpanel_unnamedtable8_Autowidth);
         ucDvpanel_unnamedtable8.setProperty("AutoHeight", Dvpanel_unnamedtable8_Autoheight);
         ucDvpanel_unnamedtable8.setProperty("Cls", Dvpanel_unnamedtable8_Cls);
         ucDvpanel_unnamedtable8.setProperty("Title", Dvpanel_unnamedtable8_Title);
         ucDvpanel_unnamedtable8.setProperty("Collapsible", Dvpanel_unnamedtable8_Collapsible);
         ucDvpanel_unnamedtable8.setProperty("Collapsed", Dvpanel_unnamedtable8_Collapsed);
         ucDvpanel_unnamedtable8.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable8_Showcollapseicon);
         ucDvpanel_unnamedtable8.setProperty("IconPosition", Dvpanel_unnamedtable8_Iconposition);
         ucDvpanel_unnamedtable8.setProperty("AutoScroll", Dvpanel_unnamedtable8_Autoscroll);
         ucDvpanel_unnamedtable8.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable8_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE8Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE8Container"+"UnnamedTable8"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable8_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavDisablesinglelogout.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavDisablesinglelogout.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavDisablesinglelogout.getInternalname(), GXutil.booltostr( AV67DisableSingleLogout), "", " ", 1, chkavDisablesinglelogout.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_DisableSingleLogout", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,105);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divSinglelogoutendpoint_cell_Internalname, 1, 0, "px", 0, "px", divSinglelogoutendpoint_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavSinglelogoutendpoint_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSinglelogoutendpoint_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSinglelogoutendpoint_Internalname, httpContext.getMessage( "WWP_GAM_SingleLogoutEndpoint", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSinglelogoutendpoint_Internalname, AV39SingleLogoutendpoint, GXutil.rtrim( localUtil.format( AV39SingleLogoutendpoint, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSinglelogoutendpoint_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavSinglelogoutendpoint_Visible, edtavSinglelogoutendpoint_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblCredentials_title_Internalname, httpContext.getMessage( "WWP_GAM_Credentials", ""), "", "", lblCredentials_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Credentials") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable4.setProperty("Width", Dvpanel_unnamedtable4_Width);
         ucDvpanel_unnamedtable4.setProperty("AutoWidth", Dvpanel_unnamedtable4_Autowidth);
         ucDvpanel_unnamedtable4.setProperty("AutoHeight", Dvpanel_unnamedtable4_Autoheight);
         ucDvpanel_unnamedtable4.setProperty("Cls", Dvpanel_unnamedtable4_Cls);
         ucDvpanel_unnamedtable4.setProperty("Title", Dvpanel_unnamedtable4_Title);
         ucDvpanel_unnamedtable4.setProperty("Collapsible", Dvpanel_unnamedtable4_Collapsible);
         ucDvpanel_unnamedtable4.setProperty("Collapsed", Dvpanel_unnamedtable4_Collapsed);
         ucDvpanel_unnamedtable4.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable4_Showcollapseicon);
         ucDvpanel_unnamedtable4.setProperty("IconPosition", Dvpanel_unnamedtable4_Iconposition);
         ucDvpanel_unnamedtable4.setProperty("AutoScroll", Dvpanel_unnamedtable4_Autoscroll);
         ucDvpanel_unnamedtable4.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable4_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE4Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE4Container"+"UnnamedTable4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeystpathcredential_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeystpathcredential_Internalname, httpContext.getMessage( "WWP_GAM_KeyStorePath", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeystpathcredential_Internalname, AV28KeyStPathCredential, GXutil.rtrim( localUtil.format( AV28KeyStPathCredential, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,124);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeystpathcredential_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeystpathcredential_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeystpwdcredential_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeystpwdcredential_Internalname, httpContext.getMessage( "WWP_GAM_KeyStorePassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeystpwdcredential_Internalname, GXutil.rtrim( AV29KeyStPwdCredential), GXutil.rtrim( localUtil.format( AV29KeyStPwdCredential, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,128);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeystpwdcredential_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeystpwdcredential_Enabled, 1, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeyaliascredential_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeyaliascredential_Internalname, httpContext.getMessage( "WWP_GAM_CertificateAlias", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeyaliascredential_Internalname, GXutil.rtrim( AV21KeyAliasCredential), GXutil.rtrim( localUtil.format( AV21KeyAliasCredential, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,133);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeyaliascredential_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeyaliascredential_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeystorecredential_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeystorecredential_Internalname, httpContext.getMessage( "WWP_GAM_KeyStoreFormat", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 137,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeystorecredential_Internalname, GXutil.rtrim( AV24KeyStoreCredential), GXutil.rtrim( localUtil.format( AV24KeyStoreCredential, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,137);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeystorecredential_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeystorecredential_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable5.setProperty("Width", Dvpanel_unnamedtable5_Width);
         ucDvpanel_unnamedtable5.setProperty("AutoWidth", Dvpanel_unnamedtable5_Autowidth);
         ucDvpanel_unnamedtable5.setProperty("AutoHeight", Dvpanel_unnamedtable5_Autoheight);
         ucDvpanel_unnamedtable5.setProperty("Cls", Dvpanel_unnamedtable5_Cls);
         ucDvpanel_unnamedtable5.setProperty("Title", Dvpanel_unnamedtable5_Title);
         ucDvpanel_unnamedtable5.setProperty("Collapsible", Dvpanel_unnamedtable5_Collapsible);
         ucDvpanel_unnamedtable5.setProperty("Collapsed", Dvpanel_unnamedtable5_Collapsed);
         ucDvpanel_unnamedtable5.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable5_Showcollapseicon);
         ucDvpanel_unnamedtable5.setProperty("IconPosition", Dvpanel_unnamedtable5_Iconposition);
         ucDvpanel_unnamedtable5.setProperty("AutoScroll", Dvpanel_unnamedtable5_Autoscroll);
         ucDvpanel_unnamedtable5.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable5_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE5Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE5Container"+"UnnamedTable5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable5_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeystorefilepathtrustcred_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeystorefilepathtrustcred_Internalname, httpContext.getMessage( "WWP_GAM_TrustStorePath", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 146,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeystorefilepathtrustcred_Internalname, AV25KeyStoreFilePathTrustCred, GXutil.rtrim( localUtil.format( AV25KeyStoreFilePathTrustCred, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,146);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeystorefilepathtrustcred_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeystorefilepathtrustcred_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeystorepwdtrustcred_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeystorepwdtrustcred_Internalname, httpContext.getMessage( "WWP_GAM_TrustStorePassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 150,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeystorepwdtrustcred_Internalname, GXutil.rtrim( AV26KeyStorePwdTrustCred), GXutil.rtrim( localUtil.format( AV26KeyStorePwdTrustCred, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,150);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeystorepwdtrustcred_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeystorepwdtrustcred_Enabled, 1, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeyaliastrustcred_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeyaliastrustcred_Internalname, httpContext.getMessage( "WWP_GAM_CertificateAlias", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeyaliastrustcred_Internalname, GXutil.rtrim( AV22KeyAliasTrustCred), GXutil.rtrim( localUtil.format( AV22KeyAliasTrustCred, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,155);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeyaliastrustcred_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeyaliastrustcred_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavKeystoretrustcred_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavKeystoretrustcred_Internalname, httpContext.getMessage( "WWP_GAM_TrustStoreFormat", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavKeystoretrustcred_Internalname, GXutil.rtrim( AV27KeyStoreTrustCred), GXutil.rtrim( localUtil.format( AV27KeyStoreTrustCred, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,159);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavKeystoretrustcred_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavKeystoretrustcred_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblUserinfo_title_Internalname, httpContext.getMessage( "WWP_GAM_UserInformationResponse", ""), "", "", lblUserinfo_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "UserInfo") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuseremailtag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuseremailtag_Internalname, httpContext.getMessage( "WWP_GAM_UserEmailTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuseremailtag_Internalname, GXutil.rtrim( AV44UserInfoResponseUserEmailTag), GXutil.rtrim( localUtil.format( AV44UserInfoResponseUserEmailTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,169);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuseremailtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuseremailtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserexternalidtag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserexternalidtag_Internalname, httpContext.getMessage( "WWP_GAM_ExternalIdTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 173,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserexternalidtag_Internalname, GXutil.rtrim( AV46UserInfoResponseUserExternalIdTag), GXutil.rtrim( localUtil.format( AV46UserInfoResponseUserExternalIdTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,173);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserexternalidtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserexternalidtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseusernametag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseusernametag_Internalname, httpContext.getMessage( "WWP_GAM_UserNameTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 178,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusernametag_Internalname, GXutil.rtrim( AV53UserInfoResponseUserNameTag), GXutil.rtrim( localUtil.format( AV53UserInfoResponseUserNameTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,178);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusernametag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusernametag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserfirstnametag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserfirstnametag_Internalname, httpContext.getMessage( "WWP_GAM_UserFirstNameTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 182,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserfirstnametag_Internalname, GXutil.rtrim( AV47UserInfoResponseUserFirstNameTag), GXutil.rtrim( localUtil.format( AV47UserInfoResponseUserFirstNameTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,182);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserfirstnametag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserfirstnametag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUserinforesponseuserlastnamegenauto.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUserinforesponseuserlastnamegenauto.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 187,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUserinforesponseuserlastnamegenauto.getInternalname(), GXutil.booltostr( AV51UserInfoResponseUserLastNameGenAuto), "", " ", 1, chkavUserinforesponseuserlastnamegenauto.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GenerateautomaticLastName", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(187, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,187);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserlastnametag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserlastnametag_Internalname, httpContext.getMessage( "WWP_GAM_UserLastNameTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 191,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserlastnametag_Internalname, GXutil.rtrim( AV52UserInfoResponseUserLastNameTag), GXutil.rtrim( localUtil.format( AV52UserInfoResponseUserLastNameTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,191);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserlastnametag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserlastnametag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseusergendertag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseusergendertag_Internalname, httpContext.getMessage( "WWP_GAM_UserGenderTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusergendertag_Internalname, GXutil.rtrim( AV48UserInfoResponseUserGenderTag), GXutil.rtrim( localUtil.format( AV48UserInfoResponseUserGenderTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,196);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusergendertag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusergendertag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseusergendervalues_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseusergendervalues_Internalname, httpContext.getMessage( "WWP_GAM_UserGenderValues", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 200,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusergendervalues_Internalname, AV49UserInfoResponseUserGenderValues, GXutil.rtrim( localUtil.format( AV49UserInfoResponseUserGenderValues, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,200);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusergendervalues_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusergendervalues_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserbirthdaytag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserbirthdaytag_Internalname, httpContext.getMessage( "WWP_GAM_UserBirthdayTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 205,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserbirthdaytag_Internalname, GXutil.rtrim( AV43UserInfoResponseUserBirthdayTag), GXutil.rtrim( localUtil.format( AV43UserInfoResponseUserBirthdayTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,205);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserbirthdaytag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserbirthdaytag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserurlimagetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserurlimagetag_Internalname, httpContext.getMessage( "WWP_GAM_UserURLImageTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 209,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserurlimagetag_Internalname, GXutil.rtrim( AV55UserInfoResponseUserURLImageTag), GXutil.rtrim( localUtil.format( AV55UserInfoResponseUserURLImageTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,209);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserurlimagetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserurlimagetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserurlprofiletag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserurlprofiletag_Internalname, httpContext.getMessage( "WWP_GAM_UserURLProfileTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 214,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserurlprofiletag_Internalname, GXutil.rtrim( AV56UserInfoResponseUserURLProfileTag), GXutil.rtrim( localUtil.format( AV56UserInfoResponseUserURLProfileTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,214);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserurlprofiletag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserurlprofiletag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserlanguagetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserlanguagetag_Internalname, httpContext.getMessage( "WWP_GAM_UserLanguageTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 218,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserlanguagetag_Internalname, GXutil.rtrim( AV50UserInfoResponseUserLanguageTag), GXutil.rtrim( localUtil.format( AV50UserInfoResponseUserLanguageTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,218);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserlanguagetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserlanguagetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseusertimezonetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseusertimezonetag_Internalname, httpContext.getMessage( "WWP_GAM_UserTimezoneTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusertimezonetag_Internalname, GXutil.rtrim( AV54UserInfoResponseUserTimeZoneTag), GXutil.rtrim( localUtil.format( AV54UserInfoResponseUserTimeZoneTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,223);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusertimezonetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusertimezonetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseerrordescriptiontag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseerrordescriptiontag_Internalname, httpContext.getMessage( "WWP_GAM_ErrorDescriptionTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 227,'" + sPrefix + "',false,'" + sGXsfl_235_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseerrordescriptiontag_Internalname, GXutil.rtrim( AV42UserInfoResponseErrorDescriptionTag), GXutil.rtrim( localUtil.format( AV42UserInfoResponseErrorDescriptionTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,227);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseerrordescriptiontag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseerrordescriptiontag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable2.setProperty("Width", Dvpanel_unnamedtable2_Width);
         ucDvpanel_unnamedtable2.setProperty("AutoWidth", Dvpanel_unnamedtable2_Autowidth);
         ucDvpanel_unnamedtable2.setProperty("AutoHeight", Dvpanel_unnamedtable2_Autoheight);
         ucDvpanel_unnamedtable2.setProperty("Cls", Dvpanel_unnamedtable2_Cls);
         ucDvpanel_unnamedtable2.setProperty("Title", Dvpanel_unnamedtable2_Title);
         ucDvpanel_unnamedtable2.setProperty("Collapsible", Dvpanel_unnamedtable2_Collapsible);
         ucDvpanel_unnamedtable2.setProperty("Collapsed", Dvpanel_unnamedtable2_Collapsed);
         ucDvpanel_unnamedtable2.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable2_Showcollapseicon);
         ucDvpanel_unnamedtable2.setProperty("IconPosition", Dvpanel_unnamedtable2_Iconposition);
         ucDvpanel_unnamedtable2.setProperty("AutoScroll", Dvpanel_unnamedtable2_Autoscroll);
         ucDvpanel_unnamedtable2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable2_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE2Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE2Container"+"UnnamedTable2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell CellMarginTop HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol235( ) ;
      }
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_235 = (int)(nGXsfl_235_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAddNewRow" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnadd_Internalname, "gx.evt.setGridEvt("+GXutil.str( 235, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtnadd_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtnadd_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOADD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 246,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 235, 3, 0)+","+"null"+");", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 248,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 235, 3, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntrySaml20.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, sPrefix+"GRID_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start302( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "GAMWCAuthentication Type Entry Saml20", ""), (short)(0)) ;
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
            strup300( ) ;
         }
      }
   }

   public void ws302( )
   {
      start302( ) ;
      evt302( ) ;
   }

   public void evt302( )
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
                              strup300( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "'DOADD'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup300( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoAdd' */
                                 e11302 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup300( ) ;
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
                                       e12302 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup300( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavDynamicpropname_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup300( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VDELETEPROPERTY.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VDELETEPROPERTY.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup300( ) ;
                           }
                           nGXsfl_235_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2352( ) ;
                           AV11DynamicPropName = httpContext.cgiGet( edtavDynamicpropname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicpropname_Internalname, AV11DynamicPropName);
                           AV12DynamicPropTag = httpContext.cgiGet( edtavDynamicproptag_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicproptag_Internalname, AV12DynamicPropTag);
                           AV65DeleteProperty = httpContext.cgiGet( edtavDeleteproperty_Internalname) ;
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV65DeleteProperty)==0) ? AV75Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV65DeleteProperty))), !bGXsfl_235_Refreshing);
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV65DeleteProperty), true);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDynamicpropname_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e13302 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDynamicpropname_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e14302 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDynamicpropname_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e15302 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETEPROPERTY.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDynamicpropname_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e16302 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup300( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDynamicpropname_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we302( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm302( ) ;
         }
      }
   }

   public void pa302( )
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

   public void gxnrgrid_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2352( ) ;
      while ( nGXsfl_235_idx <= nRC_GXsfl_235 )
      {
         sendrow_2352( ) ;
         nGXsfl_235_idx = ((subGrid_Islastpage==1)&&(nGXsfl_235_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2352( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String Gx_mode ,
                                 boolean AV19IsEnable ,
                                 boolean AV20IsRedirectBinding ,
                                 boolean AV15ForceAuthn ,
                                 boolean AV67DisableSingleLogout ,
                                 boolean AV51UserInfoResponseUserLastNameGenAuto ,
                                 String AV45UserInfoResponseUserErrorDescriptionTag ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e15302 ();
      GRID_nCurrentRecord = 0 ;
      rf302( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
         AV16FunctionId = cmbavFunctionid.getValidValue(AV16FunctionId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FunctionId", AV16FunctionId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFunctionid.setValue( GXutil.rtrim( AV16FunctionId) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Values", cmbavFunctionid.ToJavascriptSource(), true);
      }
      AV19IsEnable = GXutil.strtobool( GXutil.booltostr( AV19IsEnable)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19IsEnable", AV19IsEnable);
      AV20IsRedirectBinding = GXutil.strtobool( GXutil.booltostr( AV20IsRedirectBinding)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20IsRedirectBinding", AV20IsRedirectBinding);
      if ( cmbavNameidpolicyformat.getItemCount() > 0 )
      {
         AV69NameIdPolicyFormat = cmbavNameidpolicyformat.getValidValue(AV69NameIdPolicyFormat) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69NameIdPolicyFormat", AV69NameIdPolicyFormat);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavNameidpolicyformat.setValue( GXutil.rtrim( AV69NameIdPolicyFormat) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavNameidpolicyformat.getInternalname(), "Values", cmbavNameidpolicyformat.ToJavascriptSource(), true);
      }
      AV15ForceAuthn = GXutil.strtobool( GXutil.booltostr( AV15ForceAuthn)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ForceAuthn", AV15ForceAuthn);
      AV67DisableSingleLogout = GXutil.strtobool( GXutil.booltostr( AV67DisableSingleLogout)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67DisableSingleLogout", AV67DisableSingleLogout);
      AV51UserInfoResponseUserLastNameGenAuto = GXutil.strtobool( GXutil.booltostr( AV51UserInfoResponseUserLastNameGenAuto)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51UserInfoResponseUserLastNameGenAuto", AV51UserInfoResponseUserLastNameGenAuto);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf302( ) ;
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

   public void rf302( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(235) ;
      /* Execute user event: Refresh */
      e15302 ();
      nGXsfl_235_idx = 1 ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2352( ) ;
      bGXsfl_235_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", sPrefix);
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( subGrid_Islastpage != 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordcount( )-subgrid_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2352( ) ;
         e14302 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_235_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e14302 ();
         }
         wbEnd = (short)(235) ;
         wb300( ) ;
      }
      bGXsfl_235_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes302( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG", GXutil.rtrim( AV45UserInfoResponseUserErrorDescriptionTag));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV45UserInfoResponseUserErrorDescriptionTag, ""))));
   }

   public int subgrid_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid_fnc_recordcount( )
   {
      return (int)(((subGrid_Recordcount==0) ? GRID_nFirstRecordOnPage+1 : subGrid_Recordcount)) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(((subGrid_Islastpage==1) ? subgrid_fnc_recordcount( )/ (double) (subgrid_fnc_recordsperpage( ))+((((int)((subgrid_fnc_recordcount( )) % (subgrid_fnc_recordsperpage( ))))==0) ? 0 : 1) : GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1)) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV19IsEnable, AV20IsRedirectBinding, AV15ForceAuthn, AV67DisableSingleLogout, AV51UserInfoResponseUserLastNameGenAuto, AV45UserInfoResponseUserErrorDescriptionTag, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      if ( GRID_nEOF == 0 )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV19IsEnable, AV20IsRedirectBinding, AV15ForceAuthn, AV67DisableSingleLogout, AV51UserInfoResponseUserLastNameGenAuto, AV45UserInfoResponseUserErrorDescriptionTag, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV19IsEnable, AV20IsRedirectBinding, AV15ForceAuthn, AV67DisableSingleLogout, AV51UserInfoResponseUserLastNameGenAuto, AV45UserInfoResponseUserErrorDescriptionTag, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV19IsEnable, AV20IsRedirectBinding, AV15ForceAuthn, AV67DisableSingleLogout, AV51UserInfoResponseUserLastNameGenAuto, AV45UserInfoResponseUserErrorDescriptionTag, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV19IsEnable, AV20IsRedirectBinding, AV15ForceAuthn, AV67DisableSingleLogout, AV51UserInfoResponseUserLastNameGenAuto, AV45UserInfoResponseUserErrorDescriptionTag, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup300( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13302 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_235"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
         wcpOAV32Name = httpContext.cgiGet( sPrefix+"wcpOAV32Name") ;
         wcpOAV41TypeId = httpContext.cgiGet( sPrefix+"wcpOAV41TypeId") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_unnamedtable7_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Width") ;
         Dvpanel_unnamedtable7_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Autowidth")) ;
         Dvpanel_unnamedtable7_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Autoheight")) ;
         Dvpanel_unnamedtable7_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Cls") ;
         Dvpanel_unnamedtable7_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Title") ;
         Dvpanel_unnamedtable7_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Collapsible")) ;
         Dvpanel_unnamedtable7_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Collapsed")) ;
         Dvpanel_unnamedtable7_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Showcollapseicon")) ;
         Dvpanel_unnamedtable7_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Iconposition") ;
         Dvpanel_unnamedtable7_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE7_Autoscroll")) ;
         Dvpanel_unnamedtable8_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Width") ;
         Dvpanel_unnamedtable8_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Autowidth")) ;
         Dvpanel_unnamedtable8_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Autoheight")) ;
         Dvpanel_unnamedtable8_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Cls") ;
         Dvpanel_unnamedtable8_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Title") ;
         Dvpanel_unnamedtable8_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Collapsible")) ;
         Dvpanel_unnamedtable8_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Collapsed")) ;
         Dvpanel_unnamedtable8_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Showcollapseicon")) ;
         Dvpanel_unnamedtable8_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Iconposition") ;
         Dvpanel_unnamedtable8_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE8_Autoscroll")) ;
         Dvpanel_unnamedtable4_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Width") ;
         Dvpanel_unnamedtable4_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Autowidth")) ;
         Dvpanel_unnamedtable4_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoheight")) ;
         Dvpanel_unnamedtable4_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Cls") ;
         Dvpanel_unnamedtable4_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Title") ;
         Dvpanel_unnamedtable4_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsible")) ;
         Dvpanel_unnamedtable4_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Collapsed")) ;
         Dvpanel_unnamedtable4_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Showcollapseicon")) ;
         Dvpanel_unnamedtable4_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Iconposition") ;
         Dvpanel_unnamedtable4_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE4_Autoscroll")) ;
         Dvpanel_unnamedtable5_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Width") ;
         Dvpanel_unnamedtable5_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Autowidth")) ;
         Dvpanel_unnamedtable5_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Autoheight")) ;
         Dvpanel_unnamedtable5_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Cls") ;
         Dvpanel_unnamedtable5_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Title") ;
         Dvpanel_unnamedtable5_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Collapsible")) ;
         Dvpanel_unnamedtable5_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Collapsed")) ;
         Dvpanel_unnamedtable5_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Showcollapseicon")) ;
         Dvpanel_unnamedtable5_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Iconposition") ;
         Dvpanel_unnamedtable5_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE5_Autoscroll")) ;
         Dvpanel_unnamedtable2_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Width") ;
         Dvpanel_unnamedtable2_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Autowidth")) ;
         Dvpanel_unnamedtable2_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Autoheight")) ;
         Dvpanel_unnamedtable2_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Cls") ;
         Dvpanel_unnamedtable2_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Title") ;
         Dvpanel_unnamedtable2_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Collapsible")) ;
         Dvpanel_unnamedtable2_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Collapsed")) ;
         Dvpanel_unnamedtable2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Showcollapseicon")) ;
         Dvpanel_unnamedtable2_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Iconposition") ;
         Dvpanel_unnamedtable2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE2_Autoscroll")) ;
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( sPrefix+"GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GXUITABSPANEL_TABS_Historymanagement")) ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID_EMPOWERER_Gridinternalname") ;
         /* Read variables values. */
         if ( GXutil.len( sPrefix) == 0 )
         {
            AV32Name = httpContext.cgiGet( edtavName_Internalname) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Name", AV32Name);
         }
         cmbavFunctionid.setName( cmbavFunctionid.getInternalname() );
         cmbavFunctionid.setValue( httpContext.cgiGet( cmbavFunctionid.getInternalname()) );
         AV16FunctionId = httpContext.cgiGet( cmbavFunctionid.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FunctionId", AV16FunctionId);
         AV10Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10Dsc", AV10Dsc);
         AV19IsEnable = GXutil.strtobool( httpContext.cgiGet( chkavIsenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19IsEnable", AV19IsEnable);
         AV18Impersonate = httpContext.cgiGet( edtavImpersonate_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18Impersonate", AV18Impersonate);
         AV40SmallImageName = httpContext.cgiGet( edtavSmallimagename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40SmallImageName", AV40SmallImageName);
         AV7BigImageName = httpContext.cgiGet( edtavBigimagename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7BigImageName", AV7BigImageName);
         AV30LocalSiteURL = httpContext.cgiGet( edtavLocalsiteurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30LocalSiteURL", AV30LocalSiteURL);
         AV37ServiceProviderEntityId = httpContext.cgiGet( edtavServiceproviderentityid_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37ServiceProviderEntityId", AV37ServiceProviderEntityId);
         AV38IdentityProviderEntityID = httpContext.cgiGet( edtavIdentityproviderentityid_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38IdentityProviderEntityID", AV38IdentityProviderEntityID);
         AV20IsRedirectBinding = GXutil.strtobool( httpContext.cgiGet( chkavIsredirectbinding.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20IsRedirectBinding", AV20IsRedirectBinding);
         AV36SamlEndpointLocation = httpContext.cgiGet( edtavSamlendpointlocation_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36SamlEndpointLocation", AV36SamlEndpointLocation);
         cmbavNameidpolicyformat.setName( cmbavNameidpolicyformat.getInternalname() );
         cmbavNameidpolicyformat.setValue( httpContext.cgiGet( cmbavNameidpolicyformat.getInternalname()) );
         AV69NameIdPolicyFormat = httpContext.cgiGet( cmbavNameidpolicyformat.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69NameIdPolicyFormat", AV69NameIdPolicyFormat);
         AV15ForceAuthn = GXutil.strtobool( httpContext.cgiGet( chkavForceauthn.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ForceAuthn", AV15ForceAuthn);
         AV6AuthnContext = httpContext.cgiGet( edtavAuthncontext_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AuthnContext", AV6AuthnContext);
         AV67DisableSingleLogout = GXutil.strtobool( httpContext.cgiGet( chkavDisablesinglelogout.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67DisableSingleLogout", AV67DisableSingleLogout);
         AV39SingleLogoutendpoint = httpContext.cgiGet( edtavSinglelogoutendpoint_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39SingleLogoutendpoint", AV39SingleLogoutendpoint);
         AV28KeyStPathCredential = httpContext.cgiGet( edtavKeystpathcredential_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28KeyStPathCredential", AV28KeyStPathCredential);
         AV29KeyStPwdCredential = httpContext.cgiGet( edtavKeystpwdcredential_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29KeyStPwdCredential", AV29KeyStPwdCredential);
         AV21KeyAliasCredential = httpContext.cgiGet( edtavKeyaliascredential_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21KeyAliasCredential", AV21KeyAliasCredential);
         AV24KeyStoreCredential = httpContext.cgiGet( edtavKeystorecredential_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24KeyStoreCredential", AV24KeyStoreCredential);
         AV25KeyStoreFilePathTrustCred = httpContext.cgiGet( edtavKeystorefilepathtrustcred_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25KeyStoreFilePathTrustCred", AV25KeyStoreFilePathTrustCred);
         AV26KeyStorePwdTrustCred = httpContext.cgiGet( edtavKeystorepwdtrustcred_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26KeyStorePwdTrustCred", AV26KeyStorePwdTrustCred);
         AV22KeyAliasTrustCred = httpContext.cgiGet( edtavKeyaliastrustcred_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22KeyAliasTrustCred", AV22KeyAliasTrustCred);
         AV27KeyStoreTrustCred = httpContext.cgiGet( edtavKeystoretrustcred_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27KeyStoreTrustCred", AV27KeyStoreTrustCred);
         AV44UserInfoResponseUserEmailTag = httpContext.cgiGet( edtavUserinforesponseuseremailtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44UserInfoResponseUserEmailTag", AV44UserInfoResponseUserEmailTag);
         AV46UserInfoResponseUserExternalIdTag = httpContext.cgiGet( edtavUserinforesponseuserexternalidtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46UserInfoResponseUserExternalIdTag", AV46UserInfoResponseUserExternalIdTag);
         AV53UserInfoResponseUserNameTag = httpContext.cgiGet( edtavUserinforesponseusernametag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53UserInfoResponseUserNameTag", AV53UserInfoResponseUserNameTag);
         AV47UserInfoResponseUserFirstNameTag = httpContext.cgiGet( edtavUserinforesponseuserfirstnametag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47UserInfoResponseUserFirstNameTag", AV47UserInfoResponseUserFirstNameTag);
         AV51UserInfoResponseUserLastNameGenAuto = GXutil.strtobool( httpContext.cgiGet( chkavUserinforesponseuserlastnamegenauto.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51UserInfoResponseUserLastNameGenAuto", AV51UserInfoResponseUserLastNameGenAuto);
         AV52UserInfoResponseUserLastNameTag = httpContext.cgiGet( edtavUserinforesponseuserlastnametag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52UserInfoResponseUserLastNameTag", AV52UserInfoResponseUserLastNameTag);
         AV48UserInfoResponseUserGenderTag = httpContext.cgiGet( edtavUserinforesponseusergendertag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48UserInfoResponseUserGenderTag", AV48UserInfoResponseUserGenderTag);
         AV49UserInfoResponseUserGenderValues = httpContext.cgiGet( edtavUserinforesponseusergendervalues_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49UserInfoResponseUserGenderValues", AV49UserInfoResponseUserGenderValues);
         AV43UserInfoResponseUserBirthdayTag = httpContext.cgiGet( edtavUserinforesponseuserbirthdaytag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43UserInfoResponseUserBirthdayTag", AV43UserInfoResponseUserBirthdayTag);
         AV55UserInfoResponseUserURLImageTag = httpContext.cgiGet( edtavUserinforesponseuserurlimagetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55UserInfoResponseUserURLImageTag", AV55UserInfoResponseUserURLImageTag);
         AV56UserInfoResponseUserURLProfileTag = httpContext.cgiGet( edtavUserinforesponseuserurlprofiletag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56UserInfoResponseUserURLProfileTag", AV56UserInfoResponseUserURLProfileTag);
         AV50UserInfoResponseUserLanguageTag = httpContext.cgiGet( edtavUserinforesponseuserlanguagetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50UserInfoResponseUserLanguageTag", AV50UserInfoResponseUserLanguageTag);
         AV54UserInfoResponseUserTimeZoneTag = httpContext.cgiGet( edtavUserinforesponseusertimezonetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54UserInfoResponseUserTimeZoneTag", AV54UserInfoResponseUserTimeZoneTag);
         AV42UserInfoResponseErrorDescriptionTag = httpContext.cgiGet( edtavUserinforesponseerrordescriptiontag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42UserInfoResponseErrorDescriptionTag", AV42UserInfoResponseErrorDescriptionTag);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13302 ();
      if (returnInSub) return;
   }

   public void e13302( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INITAUTHENTICATIONSAML' */
      S112 ();
      if (returnInSub) return;
      AV16FunctionId = "OnlyAuthentication" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FunctionId", AV16FunctionId);
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
         {
            bttBtnenter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
         }
         bttBtnadd_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnadd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnadd_Visible), 5, 0), true);
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
         edtavImpersonate_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavImpersonate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavImpersonate_Enabled), 5, 0), true);
         bttBtnenter_Caption = httpContext.getMessage( "WWP_GAM_Delete", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
         edtavServiceproviderentityid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavServiceproviderentityid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavServiceproviderentityid_Enabled), 5, 0), true);
         edtavIdentityproviderentityid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavIdentityproviderentityid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIdentityproviderentityid_Enabled), 5, 0), true);
         edtavSamlendpointlocation_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSamlendpointlocation_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSamlendpointlocation_Enabled), 5, 0), true);
         edtavSinglelogoutendpoint_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSinglelogoutendpoint_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSinglelogoutendpoint_Enabled), 5, 0), true);
         chkavDisablesinglelogout.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavDisablesinglelogout.getInternalname(), "Enabled", GXutil.ltrimstr( chkavDisablesinglelogout.getEnabled(), 5, 0), true);
         edtavLocalsiteurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavLocalsiteurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLocalsiteurl_Enabled), 5, 0), true);
         edtavKeystpathcredential_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeystpathcredential_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeystpathcredential_Enabled), 5, 0), true);
         edtavKeystpwdcredential_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeystpwdcredential_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeystpwdcredential_Enabled), 5, 0), true);
         edtavKeyaliascredential_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeyaliascredential_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeyaliascredential_Enabled), 5, 0), true);
         edtavKeystorecredential_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeystorecredential_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeystorecredential_Enabled), 5, 0), true);
         edtavKeystorefilepathtrustcred_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeystorefilepathtrustcred_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeystorefilepathtrustcred_Enabled), 5, 0), true);
         edtavKeystorepwdtrustcred_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeystorepwdtrustcred_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeystorepwdtrustcred_Enabled), 5, 0), true);
         edtavKeyaliastrustcred_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeyaliastrustcred_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeyaliastrustcred_Enabled), 5, 0), true);
         edtavKeystoretrustcred_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavKeystoretrustcred_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavKeystoretrustcred_Enabled), 5, 0), true);
         chkavIsredirectbinding.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIsredirectbinding.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsredirectbinding.getEnabled(), 5, 0), true);
         chkavForceauthn.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavForceauthn.getInternalname(), "Enabled", GXutil.ltrimstr( chkavForceauthn.getEnabled(), 5, 0), true);
         edtavAuthncontext_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthncontext_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthncontext_Enabled), 5, 0), true);
         cmbavNameidpolicyformat.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavNameidpolicyformat.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavNameidpolicyformat.getEnabled(), 5, 0), true);
         edtavUserinforesponseuserbirthdaytag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserbirthdaytag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserbirthdaytag_Enabled), 5, 0), true);
         edtavUserinforesponseuseremailtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuseremailtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuseremailtag_Enabled), 5, 0), true);
         edtavUserinforesponseuserexternalidtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserexternalidtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserexternalidtag_Enabled), 5, 0), true);
         edtavUserinforesponseuserfirstnametag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserfirstnametag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserfirstnametag_Enabled), 5, 0), true);
         edtavUserinforesponseusergendertag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusergendertag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusergendertag_Enabled), 5, 0), true);
         edtavUserinforesponseusergendervalues_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusergendervalues_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusergendervalues_Enabled), 5, 0), true);
         edtavUserinforesponseuserlanguagetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlanguagetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlanguagetag_Enabled), 5, 0), true);
         chkavUserinforesponseuserlastnamegenauto.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinforesponseuserlastnamegenauto.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUserinforesponseuserlastnamegenauto.getEnabled(), 5, 0), true);
         edtavUserinforesponseuserlastnametag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlastnametag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlastnametag_Enabled), 5, 0), true);
         edtavUserinforesponseusernametag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusernametag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusernametag_Enabled), 5, 0), true);
         edtavUserinforesponseusertimezonetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusertimezonetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusertimezonetag_Enabled), 5, 0), true);
         edtavUserinforesponseuserurlimagetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserurlimagetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserurlimagetag_Enabled), 5, 0), true);
         edtavUserinforesponseuserurlprofiletag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserurlprofiletag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserurlprofiletag_Enabled), 5, 0), true);
         edtavUserinforesponseerrordescriptiontag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseerrordescriptiontag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseerrordescriptiontag_Enabled), 5, 0), true);
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            edtavName_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
         }
         else
         {
            edtavName_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
         }
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, sPrefix, false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   private void e14302( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV74GXV1 = 1 ;
      while ( AV74GXV1 <= AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserproperties().size() )
      {
         AV17GAMPropertySimple = (genexus.security.api.genexussecurity.SdtGAMPropertySimple)((genexus.security.api.genexussecurity.SdtGAMPropertySimple)AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserproperties().elementAt(-1+AV74GXV1));
         edtavDeleteproperty_gximage = "ActionDelete" ;
         AV65DeleteProperty = context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeleteproperty_Internalname, AV65DeleteProperty);
         AV75Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
         edtavDeleteproperty_Tooltiptext = "" ;
         AV11DynamicPropName = AV17GAMPropertySimple.getgxTv_SdtGAMPropertySimple_Id() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicpropname_Internalname, AV11DynamicPropName);
         AV12DynamicPropTag = AV17GAMPropertySimple.getgxTv_SdtGAMPropertySimple_Value() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicproptag_Internalname, AV12DynamicPropTag);
         if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
         {
            edtavDeleteproperty_Visible = 0 ;
            edtavDynamicpropname_Enabled = 0 ;
            edtavDynamicproptag_Enabled = 0 ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(235) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2352( ) ;
            GRID_nEOF = (byte)(1) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
            {
               GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
            }
         }
         if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
         {
            GRID_nEOF = (byte)(0) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         }
         GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_235_Refreshing )
         {
            httpContext.doAjaxLoad(235, GridRow);
         }
         AV74GXV1 = (int)(AV74GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e11302( )
   {
      /* 'DoAdd' Routine */
      returnInSub = false ;
      edtavDeleteproperty_gximage = "ActionDelete" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "gximage", edtavDeleteproperty_gximage, !bGXsfl_235_Refreshing);
      AV65DeleteProperty = context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV65DeleteProperty)==0) ? AV75Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV65DeleteProperty))), !bGXsfl_235_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV65DeleteProperty), true);
      AV75Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV65DeleteProperty)==0) ? AV75Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV65DeleteProperty))), !bGXsfl_235_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV65DeleteProperty), true);
      edtavDeleteproperty_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteproperty_Visible), 5, 0), !bGXsfl_235_Refreshing);
      edtavDynamicpropname_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicpropname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicpropname_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavDynamicpropname_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicpropname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicpropname_Visible), 5, 0), !bGXsfl_235_Refreshing);
      edtavDynamicproptag_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicproptag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicproptag_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavDynamicproptag_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicproptag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicproptag_Visible), 5, 0), !bGXsfl_235_Refreshing);
      if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
      {
         sendrow_2352( ) ;
         GRID_nEOF = (byte)(1) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
         {
            GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
         }
      }
      if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
      {
         GRID_nEOF = (byte)(0) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
      }
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_235_Refreshing )
      {
         httpContext.doAjaxLoad(235, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV70CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70CheckRequiredFieldsResult", AV70CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV32Name)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Name", ""), "", "", "", "", "", "", "", ""), "error", edtavName_Internalname, "true", ""));
         AV70CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70CheckRequiredFieldsResult", AV70CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV30LocalSiteURL)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_LocalSiteURL", ""), "", "", "", "", "", "", "", ""), "error", edtavLocalsiteurl_Internalname, "true", ""));
         AV70CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70CheckRequiredFieldsResult", AV70CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV37ServiceProviderEntityId)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_ServiceProviderEntityID", ""), "", "", "", "", "", "", "", ""), "error", edtavServiceproviderentityid_Internalname, "true", ""));
         AV70CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70CheckRequiredFieldsResult", AV70CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV36SamlEndpointLocation)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_SamlEndpointLocation", ""), "", "", "", "", "", "", "", ""), "error", edtavSamlendpointlocation_Internalname, "true", ""));
         AV70CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70CheckRequiredFieldsResult", AV70CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV39SingleLogoutendpoint)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_SingleLogoutEndpoint", ""), "", "", "", "", "", "", "", ""), "error", edtavSinglelogoutendpoint_Internalname, "true", ""));
         AV70CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70CheckRequiredFieldsResult", AV70CheckRequiredFieldsResult);
      }
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ! AV67DisableSingleLogout ) )
      {
         edtavSinglelogoutendpoint_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSinglelogoutendpoint_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSinglelogoutendpoint_Visible), 5, 0), true);
         divSinglelogoutendpoint_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSinglelogoutendpoint_cell_Internalname, "Class", divSinglelogoutendpoint_cell_Class, true);
      }
      else
      {
         edtavSinglelogoutendpoint_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSinglelogoutendpoint_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSinglelogoutendpoint_Visible), 5, 0), true);
         divSinglelogoutendpoint_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divSinglelogoutendpoint_cell_Internalname, "Class", divSinglelogoutendpoint_cell_Class, true);
      }
   }

   public void e15302( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      edtavDeleteproperty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteproperty_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e12302 ();
      if (returnInSub) return;
   }

   public void e12302( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S132 ();
      if (returnInSub) return;
      if ( AV70CheckRequiredFieldsResult )
      {
         if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
         {
            /* Execute user subroutine: 'SAVEAUTHENTICATIONSAML' */
            S142 ();
            if (returnInSub) return;
         }
         else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            AV5AuthenticationTypeSaml20.load(AV32Name);
            AV5AuthenticationTypeSaml20.delete();
         }
         if ( AV5AuthenticationTypeSaml20.success() && ( AV14Errors.size() == 0 ) )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentrysaml20");
            callWebObject(formatLink("com.mujermorena.gamwwauthtypes", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            AV14Errors = AV5AuthenticationTypeSaml20.geterrors() ;
            AV76GXV2 = 1 ;
            while ( AV76GXV2 <= AV14Errors.size() )
            {
               AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV76GXV2));
               httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
               AV76GXV2 = (int)(AV76GXV2+1) ;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5AuthenticationTypeSaml20", AV5AuthenticationTypeSaml20);
   }

   public void e16302( )
   {
      /* Deleteproperty_Click Routine */
      returnInSub = false ;
      edtavDeleteproperty_gximage = "ActionDelete" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "gximage", edtavDeleteproperty_gximage, !bGXsfl_235_Refreshing);
      AV65DeleteProperty = context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV65DeleteProperty)==0) ? AV75Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV65DeleteProperty))), !bGXsfl_235_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV65DeleteProperty), true);
      AV75Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV65DeleteProperty)==0) ? AV75Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV65DeleteProperty))), !bGXsfl_235_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV65DeleteProperty), true);
      edtavDeleteproperty_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteproperty_Visible), 5, 0), !bGXsfl_235_Refreshing);
      edtavDynamicpropname_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicpropname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicpropname_Visible), 5, 0), !bGXsfl_235_Refreshing);
      edtavDynamicproptag_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicproptag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicproptag_Visible), 5, 0), !bGXsfl_235_Refreshing);
      AV11DynamicPropName = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicpropname_Internalname, AV11DynamicPropName);
      AV12DynamicPropTag = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicproptag_Internalname, AV12DynamicPropTag);
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Name( AV32Name );
      GXv_objcol_SdtGAMError1[0] = AV14Errors ;
      AV5AuthenticationTypeSaml20.removeuserinfoproperty(AV11DynamicPropName, GXv_objcol_SdtGAMError1);
      AV14Errors = GXv_objcol_SdtGAMError1[0] ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5AuthenticationTypeSaml20", AV5AuthenticationTypeSaml20);
   }

   public void S112( )
   {
      /* 'INITAUTHENTICATIONSAML' Routine */
      returnInSub = false ;
      AV5AuthenticationTypeSaml20.load(AV32Name);
      AV32Name = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Name", AV32Name);
      AV19IsEnable = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19IsEnable", AV19IsEnable);
      AV10Dsc = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10Dsc", AV10Dsc);
      AV40SmallImageName = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40SmallImageName", AV40SmallImageName);
      AV7BigImageName = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7BigImageName", AV7BigImageName);
      AV18Impersonate = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18Impersonate", AV18Impersonate);
      AV37ServiceProviderEntityId = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Serviceproviderentityid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37ServiceProviderEntityId", AV37ServiceProviderEntityId);
      AV38IdentityProviderEntityID = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Identityproviderentityid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38IdentityProviderEntityID", AV38IdentityProviderEntityID);
      AV6AuthnContext = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Authncontext() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AuthnContext", AV6AuthnContext);
      AV69NameIdPolicyFormat = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Nameidpolicyformat() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69NameIdPolicyFormat", AV69NameIdPolicyFormat);
      AV20IsRedirectBinding = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Isredirectbinding() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20IsRedirectBinding", AV20IsRedirectBinding);
      AV15ForceAuthn = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Forceauthn() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15ForceAuthn", AV15ForceAuthn);
      AV21KeyAliasCredential = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keyaliascredential() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21KeyAliasCredential", AV21KeyAliasCredential);
      AV22KeyAliasTrustCred = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keyaliastrustcred() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22KeyAliasTrustCred", AV22KeyAliasTrustCred);
      AV24KeyStoreCredential = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keystorecredential() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24KeyStoreCredential", AV24KeyStoreCredential);
      AV25KeyStoreFilePathTrustCred = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keystorefilepathtrustcred() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25KeyStoreFilePathTrustCred", AV25KeyStoreFilePathTrustCred);
      AV26KeyStorePwdTrustCred = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keystorepwdtrustcred() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV26KeyStorePwdTrustCred", AV26KeyStorePwdTrustCred);
      AV27KeyStoreTrustCred = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keystoretrustcred() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27KeyStoreTrustCred", AV27KeyStoreTrustCred);
      AV28KeyStPathCredential = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keystpathcredential() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28KeyStPathCredential", AV28KeyStPathCredential);
      AV29KeyStPwdCredential = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Keystpwdcredential() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29KeyStPwdCredential", AV29KeyStPwdCredential);
      AV36SamlEndpointLocation = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Samlendpointlocation() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36SamlEndpointLocation", AV36SamlEndpointLocation);
      AV30LocalSiteURL = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Localsiteurl() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30LocalSiteURL", AV30LocalSiteURL);
      AV67DisableSingleLogout = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Disablesinglelogout() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67DisableSingleLogout", AV67DisableSingleLogout);
      AV39SingleLogoutendpoint = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Singlelogoutendpoint() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39SingleLogoutendpoint", AV39SingleLogoutendpoint);
      AV45UserInfoResponseUserErrorDescriptionTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseerrordescription_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45UserInfoResponseUserErrorDescriptionTag", AV45UserInfoResponseUserErrorDescriptionTag);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV45UserInfoResponseUserErrorDescriptionTag, ""))));
      AV43UserInfoResponseUserBirthdayTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserbirthday_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43UserInfoResponseUserBirthdayTag", AV43UserInfoResponseUserBirthdayTag);
      AV44UserInfoResponseUserEmailTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuseremail_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44UserInfoResponseUserEmailTag", AV44UserInfoResponseUserEmailTag);
      AV46UserInfoResponseUserExternalIdTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserexternalid_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46UserInfoResponseUserExternalIdTag", AV46UserInfoResponseUserExternalIdTag);
      AV47UserInfoResponseUserFirstNameTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserfirstname_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47UserInfoResponseUserFirstNameTag", AV47UserInfoResponseUserFirstNameTag);
      AV48UserInfoResponseUserGenderTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusergender_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48UserInfoResponseUserGenderTag", AV48UserInfoResponseUserGenderTag);
      AV49UserInfoResponseUserGenderValues = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusergender_values() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49UserInfoResponseUserGenderValues", AV49UserInfoResponseUserGenderValues);
      AV50UserInfoResponseUserLanguageTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserlanguage_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50UserInfoResponseUserLanguageTag", AV50UserInfoResponseUserLanguageTag);
      AV51UserInfoResponseUserLastNameGenAuto = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserlastname_generateautomatic() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51UserInfoResponseUserLastNameGenAuto", AV51UserInfoResponseUserLastNameGenAuto);
      AV52UserInfoResponseUserLastNameTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserlastname_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52UserInfoResponseUserLastNameTag", AV52UserInfoResponseUserLastNameTag);
      AV53UserInfoResponseUserNameTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusername_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53UserInfoResponseUserNameTag", AV53UserInfoResponseUserNameTag);
      AV54UserInfoResponseUserTimeZoneTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusertimezone_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54UserInfoResponseUserTimeZoneTag", AV54UserInfoResponseUserTimeZoneTag);
      AV55UserInfoResponseUserURLImageTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserurlimage_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55UserInfoResponseUserURLImageTag", AV55UserInfoResponseUserURLImageTag);
      AV56UserInfoResponseUserURLProfileTag = AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().getgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserurlprofile_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56UserInfoResponseUserURLProfileTag", AV56UserInfoResponseUserURLProfileTag);
   }

   public void S142( )
   {
      /* 'SAVEAUTHENTICATIONSAML' Routine */
      returnInSub = false ;
      AV5AuthenticationTypeSaml20.load(AV32Name);
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Name( AV32Name );
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Isenable( AV19IsEnable );
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Description( AV10Dsc );
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Smallimagename( AV40SmallImageName );
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Bigimagename( AV7BigImageName );
      AV5AuthenticationTypeSaml20.setgxTv_SdtGAMAuthenticationTypeSaml20_Impersonate( AV18Impersonate );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Serviceproviderentityid( AV37ServiceProviderEntityId );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Identityproviderentityid( AV38IdentityProviderEntityID );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Authncontext( AV6AuthnContext );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Nameidpolicyformat( AV69NameIdPolicyFormat );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Isredirectbinding( AV20IsRedirectBinding );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Forceauthn( AV15ForceAuthn );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keyaliascredential( AV21KeyAliasCredential );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keyaliastrustcred( AV22KeyAliasTrustCred );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keystorecredential( AV24KeyStoreCredential );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keystorefilepathtrustcred( AV25KeyStoreFilePathTrustCred );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keystorepwdtrustcred( AV26KeyStorePwdTrustCred );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keystoretrustcred( AV27KeyStoreTrustCred );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keystpathcredential( AV28KeyStPathCredential );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Keystpwdcredential( AV29KeyStPwdCredential );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Samlendpointlocation( AV36SamlEndpointLocation );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Disablesinglelogout( AV67DisableSingleLogout );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Singlelogoutendpoint( AV39SingleLogoutendpoint );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().setgxTv_SdtGAMAuthenticationSaml20_Localsiteurl( AV30LocalSiteURL );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseerrordescription_name( AV45UserInfoResponseUserErrorDescriptionTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserbirthday_name( AV43UserInfoResponseUserBirthdayTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuseremail_name( AV44UserInfoResponseUserEmailTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserexternalid_name( AV46UserInfoResponseUserExternalIdTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserfirstname_name( AV47UserInfoResponseUserFirstNameTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusergender_name( AV48UserInfoResponseUserGenderTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusergender_values( AV49UserInfoResponseUserGenderValues );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserlanguage_name( AV50UserInfoResponseUserLanguageTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserlastname_generateautomatic( AV51UserInfoResponseUserLastNameGenAuto );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserlastname_name( AV52UserInfoResponseUserLastNameTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusername_name( AV53UserInfoResponseUserNameTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseusertimezone_name( AV54UserInfoResponseUserTimeZoneTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserurlimage_name( AV55UserInfoResponseUserURLImageTag );
      AV5AuthenticationTypeSaml20.getgxTv_SdtGAMAuthenticationTypeSaml20_Saml20().getgxTv_SdtGAMAuthenticationSaml20_Userinfo().setgxTv_SdtGAMAuthenticationSaml20UserInfo_Responseuserurlprofile_name( AV56UserInfoResponseUserURLProfileTag );
      AV5AuthenticationTypeSaml20.save();
      /* Start For Each Line */
      nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_235"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_235_fel_idx = 0 ;
      while ( nGXsfl_235_fel_idx < nRC_GXsfl_235 )
      {
         nGXsfl_235_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_235_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_235_fel_idx+1) ;
         sGXsfl_235_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_2352( ) ;
         AV11DynamicPropName = httpContext.cgiGet( edtavDynamicpropname_Internalname) ;
         AV12DynamicPropTag = httpContext.cgiGet( edtavDynamicproptag_Internalname) ;
         AV65DeleteProperty = httpContext.cgiGet( edtavDeleteproperty_Internalname) ;
         if ( ! (GXutil.strcmp("", AV11DynamicPropName)==0) && ! (GXutil.strcmp("", AV12DynamicPropTag)==0) )
         {
            AV17GAMPropertySimple = (genexus.security.api.genexussecurity.SdtGAMPropertySimple)new genexus.security.api.genexussecurity.SdtGAMPropertySimple(remoteHandle, context);
            AV17GAMPropertySimple.setgxTv_SdtGAMPropertySimple_Id( AV11DynamicPropName );
            AV17GAMPropertySimple.setgxTv_SdtGAMPropertySimple_Value( AV12DynamicPropTag );
            GXv_objcol_SdtGAMError1[0] = AV14Errors ;
            if ( ! AV5AuthenticationTypeSaml20.setuserinfoproperty(AV17GAMPropertySimple, GXv_objcol_SdtGAMError1) )
            {
               AV14Errors = GXv_objcol_SdtGAMError1[0] ;
               AV78GXV3 = 1 ;
               while ( AV78GXV3 <= AV14Errors.size() )
               {
                  AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV78GXV3));
                  System.out.println( GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", "") );
                  AV78GXV3 = (int)(AV78GXV3+1) ;
               }
            }
         }
         /* End For Each Line */
      }
      if ( nGXsfl_235_fel_idx == 0 )
      {
         nGXsfl_235_idx = 1 ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2352( ) ;
      }
      nGXsfl_235_fel_idx = 1 ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      AV32Name = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Name", AV32Name);
      AV41TypeId = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TypeId", AV41TypeId);
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
      pa302( ) ;
      ws302( ) ;
      we302( ) ;
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
      sCtrlAV32Name = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV41TypeId = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa302( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "gamwcauthenticationtypeentrysaml20", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa302( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         Gx_mode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         AV32Name = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Name", AV32Name);
         AV41TypeId = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TypeId", AV41TypeId);
      }
      wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
      wcpOAV32Name = httpContext.cgiGet( sPrefix+"wcpOAV32Name") ;
      wcpOAV41TypeId = httpContext.cgiGet( sPrefix+"wcpOAV41TypeId") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(Gx_mode, wcpOGx_mode) != 0 ) || ( GXutil.strcmp(AV32Name, wcpOAV32Name) != 0 ) || ( GXutil.strcmp(AV41TypeId, wcpOAV41TypeId) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOGx_mode = Gx_mode ;
      wcpOAV32Name = AV32Name ;
      wcpOAV41TypeId = AV41TypeId ;
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
      sCtrlAV32Name = httpContext.cgiGet( sPrefix+"AV32Name_CTRL") ;
      if ( GXutil.len( sCtrlAV32Name) > 0 )
      {
         AV32Name = httpContext.cgiGet( sCtrlAV32Name) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Name", AV32Name);
      }
      else
      {
         AV32Name = httpContext.cgiGet( sPrefix+"AV32Name_PARM") ;
      }
      sCtrlAV41TypeId = httpContext.cgiGet( sPrefix+"AV41TypeId_CTRL") ;
      if ( GXutil.len( sCtrlAV41TypeId) > 0 )
      {
         AV41TypeId = httpContext.cgiGet( sCtrlAV41TypeId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41TypeId", AV41TypeId);
      }
      else
      {
         AV41TypeId = httpContext.cgiGet( sPrefix+"AV41TypeId_PARM") ;
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
      pa302( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws302( ) ;
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
      ws302( ) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV32Name_PARM", GXutil.rtrim( AV32Name));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV32Name)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV32Name_CTRL", GXutil.rtrim( sCtrlAV32Name));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV41TypeId_PARM", GXutil.rtrim( AV41TypeId));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV41TypeId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV41TypeId_CTRL", GXutil.rtrim( sCtrlAV41TypeId));
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
      we302( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211163740", true, true);
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
      httpContext.AddJavascriptSource("gamwcauthenticationtypeentrysaml20.js", "?20241211163742", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_2352( )
   {
      edtavDynamicpropname_Internalname = sPrefix+"vDYNAMICPROPNAME_"+sGXsfl_235_idx ;
      edtavDynamicproptag_Internalname = sPrefix+"vDYNAMICPROPTAG_"+sGXsfl_235_idx ;
      edtavDeleteproperty_Internalname = sPrefix+"vDELETEPROPERTY_"+sGXsfl_235_idx ;
   }

   public void subsflControlProps_fel_2352( )
   {
      edtavDynamicpropname_Internalname = sPrefix+"vDYNAMICPROPNAME_"+sGXsfl_235_fel_idx ;
      edtavDynamicproptag_Internalname = sPrefix+"vDYNAMICPROPTAG_"+sGXsfl_235_fel_idx ;
      edtavDeleteproperty_Internalname = sPrefix+"vDELETEPROPERTY_"+sGXsfl_235_fel_idx ;
   }

   public void sendrow_2352( )
   {
      subsflControlProps_2352( ) ;
      wb300( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_235_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_235_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_235_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDynamicpropname_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDynamicpropname_Enabled!=0)&&(edtavDynamicpropname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 236,'"+sPrefix+"',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDynamicpropname_Internalname,GXutil.rtrim( AV11DynamicPropName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDynamicpropname_Enabled!=0)&&(edtavDynamicpropname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,236);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDynamicpropname_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(edtavDynamicpropname_Visible),Integer.valueOf(edtavDynamicpropname_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMPropertyId","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDynamicproptag_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDynamicproptag_Enabled!=0)&&(edtavDynamicproptag_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 237,'"+sPrefix+"',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDynamicproptag_Internalname,GXutil.rtrim( AV12DynamicPropTag),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDynamicproptag_Enabled!=0)&&(edtavDynamicproptag_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,237);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDynamicproptag_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(edtavDynamicproptag_Visible),Integer.valueOf(edtavDynamicproptag_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtavDeleteproperty_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavDeleteproperty_Enabled!=0)&&(edtavDeleteproperty_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 238,'"+sPrefix+"',false,'',235)\"" : " ") ;
         ClassString = "ActionBaseColorAttribute" + " " + ((GXutil.strcmp(edtavDeleteproperty_gximage, "")==0) ? "" : "GX_Image_"+edtavDeleteproperty_gximage+"_Class") ;
         StyleString = "" ;
         AV65DeleteProperty_IsBlob = (boolean)(((GXutil.strcmp("", AV65DeleteProperty)==0)&&(GXutil.strcmp("", AV75Deleteproperty_GXI)==0))||!(GXutil.strcmp("", AV65DeleteProperty)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV65DeleteProperty)==0) ? AV75Deleteproperty_GXI : httpContext.getResourceRelative(AV65DeleteProperty)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavDeleteproperty_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavDeleteproperty_Visible),Integer.valueOf(edtavDeleteproperty_Enabled),"",edtavDeleteproperty_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavDeleteproperty_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVDELETEPROPERTY.CLICK."+sGXsfl_235_idx+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV65DeleteProperty_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         send_integrity_lvl_hashes302( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_235_idx = ((subGrid_Islastpage==1)&&(nGXsfl_235_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2352( ) ;
      }
      /* End function sendrow_2352 */
   }

   public void startgridcontrol235( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"235\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+((edtavDynamicpropname_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_AttributeName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+((edtavDynamicproptag_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_AttributeTag", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ActionBaseColorAttribute"+" "+((GXutil.strcmp(edtavDeleteproperty_gximage, "")==0) ? "" : "GX_Image_"+edtavDeleteproperty_gximage+"_Class")+"\" "+" style=\""+((edtavDeleteproperty_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", sPrefix);
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV11DynamicPropName));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDynamicpropname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDynamicpropname_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12DynamicPropTag));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDynamicproptag_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDynamicproptag_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV65DeleteProperty));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDeleteproperty_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavDeleteproperty_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDeleteproperty_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavName_Internalname = sPrefix+"vNAME" ;
      cmbavFunctionid.setInternalname( sPrefix+"vFUNCTIONID" );
      edtavDsc_Internalname = sPrefix+"vDSC" ;
      chkavIsenable.setInternalname( sPrefix+"vISENABLE" );
      edtavImpersonate_Internalname = sPrefix+"vIMPERSONATE" ;
      edtavSmallimagename_Internalname = sPrefix+"vSMALLIMAGENAME" ;
      edtavBigimagename_Internalname = sPrefix+"vBIGIMAGENAME" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      lblGeneral_title_Internalname = sPrefix+"GENERAL_TITLE" ;
      edtavLocalsiteurl_Internalname = sPrefix+"vLOCALSITEURL" ;
      edtavServiceproviderentityid_Internalname = sPrefix+"vSERVICEPROVIDERENTITYID" ;
      edtavIdentityproviderentityid_Internalname = sPrefix+"vIDENTITYPROVIDERENTITYID" ;
      chkavIsredirectbinding.setInternalname( sPrefix+"vISREDIRECTBINDING" );
      edtavSamlendpointlocation_Internalname = sPrefix+"vSAMLENDPOINTLOCATION" ;
      cmbavNameidpolicyformat.setInternalname( sPrefix+"vNAMEIDPOLICYFORMAT" );
      chkavForceauthn.setInternalname( sPrefix+"vFORCEAUTHN" );
      edtavAuthncontext_Internalname = sPrefix+"vAUTHNCONTEXT" ;
      divUnnamedtable7_Internalname = sPrefix+"UNNAMEDTABLE7" ;
      Dvpanel_unnamedtable7_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE7" ;
      chkavDisablesinglelogout.setInternalname( sPrefix+"vDISABLESINGLELOGOUT" );
      edtavSinglelogoutendpoint_Internalname = sPrefix+"vSINGLELOGOUTENDPOINT" ;
      divSinglelogoutendpoint_cell_Internalname = sPrefix+"SINGLELOGOUTENDPOINT_CELL" ;
      divUnnamedtable8_Internalname = sPrefix+"UNNAMEDTABLE8" ;
      Dvpanel_unnamedtable8_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE8" ;
      divUnnamedtable6_Internalname = sPrefix+"UNNAMEDTABLE6" ;
      lblCredentials_title_Internalname = sPrefix+"CREDENTIALS_TITLE" ;
      edtavKeystpathcredential_Internalname = sPrefix+"vKEYSTPATHCREDENTIAL" ;
      edtavKeystpwdcredential_Internalname = sPrefix+"vKEYSTPWDCREDENTIAL" ;
      edtavKeyaliascredential_Internalname = sPrefix+"vKEYALIASCREDENTIAL" ;
      edtavKeystorecredential_Internalname = sPrefix+"vKEYSTORECREDENTIAL" ;
      divUnnamedtable4_Internalname = sPrefix+"UNNAMEDTABLE4" ;
      Dvpanel_unnamedtable4_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE4" ;
      edtavKeystorefilepathtrustcred_Internalname = sPrefix+"vKEYSTOREFILEPATHTRUSTCRED" ;
      edtavKeystorepwdtrustcred_Internalname = sPrefix+"vKEYSTOREPWDTRUSTCRED" ;
      edtavKeyaliastrustcred_Internalname = sPrefix+"vKEYALIASTRUSTCRED" ;
      edtavKeystoretrustcred_Internalname = sPrefix+"vKEYSTORETRUSTCRED" ;
      divUnnamedtable5_Internalname = sPrefix+"UNNAMEDTABLE5" ;
      Dvpanel_unnamedtable5_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE5" ;
      divUnnamedtable3_Internalname = sPrefix+"UNNAMEDTABLE3" ;
      lblUserinfo_title_Internalname = sPrefix+"USERINFO_TITLE" ;
      edtavUserinforesponseuseremailtag_Internalname = sPrefix+"vUSERINFORESPONSEUSEREMAILTAG" ;
      edtavUserinforesponseuserexternalidtag_Internalname = sPrefix+"vUSERINFORESPONSEUSEREXTERNALIDTAG" ;
      edtavUserinforesponseusernametag_Internalname = sPrefix+"vUSERINFORESPONSEUSERNAMETAG" ;
      edtavUserinforesponseuserfirstnametag_Internalname = sPrefix+"vUSERINFORESPONSEUSERFIRSTNAMETAG" ;
      chkavUserinforesponseuserlastnamegenauto.setInternalname( sPrefix+"vUSERINFORESPONSEUSERLASTNAMEGENAUTO" );
      edtavUserinforesponseuserlastnametag_Internalname = sPrefix+"vUSERINFORESPONSEUSERLASTNAMETAG" ;
      edtavUserinforesponseusergendertag_Internalname = sPrefix+"vUSERINFORESPONSEUSERGENDERTAG" ;
      edtavUserinforesponseusergendervalues_Internalname = sPrefix+"vUSERINFORESPONSEUSERGENDERVALUES" ;
      edtavUserinforesponseuserbirthdaytag_Internalname = sPrefix+"vUSERINFORESPONSEUSERBIRTHDAYTAG" ;
      edtavUserinforesponseuserurlimagetag_Internalname = sPrefix+"vUSERINFORESPONSEUSERURLIMAGETAG" ;
      edtavUserinforesponseuserurlprofiletag_Internalname = sPrefix+"vUSERINFORESPONSEUSERURLPROFILETAG" ;
      edtavUserinforesponseuserlanguagetag_Internalname = sPrefix+"vUSERINFORESPONSEUSERLANGUAGETAG" ;
      edtavUserinforesponseusertimezonetag_Internalname = sPrefix+"vUSERINFORESPONSEUSERTIMEZONETAG" ;
      edtavUserinforesponseerrordescriptiontag_Internalname = sPrefix+"vUSERINFORESPONSEERRORDESCRIPTIONTAG" ;
      edtavDynamicpropname_Internalname = sPrefix+"vDYNAMICPROPNAME" ;
      edtavDynamicproptag_Internalname = sPrefix+"vDYNAMICPROPTAG" ;
      edtavDeleteproperty_Internalname = sPrefix+"vDELETEPROPERTY" ;
      bttBtnadd_Internalname = sPrefix+"BTNADD" ;
      divUnnamedtable2_Internalname = sPrefix+"UNNAMEDTABLE2" ;
      Dvpanel_unnamedtable2_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE2" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      Gxuitabspanel_tabs_Internalname = sPrefix+"GXUITABSPANEL_TABS" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      bttBtncancel_Internalname = sPrefix+"BTNCANCEL" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Grid_empowerer_Internalname = sPrefix+"GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid_Internalname = sPrefix+"GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavDeleteproperty_Jsonclick = "" ;
      edtavDeleteproperty_Tooltiptext = "" ;
      edtavDynamicproptag_Jsonclick = "" ;
      edtavDynamicpropname_Jsonclick = "" ;
      subGrid_Class = "WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavDeleteproperty_Enabled = 1 ;
      edtavDynamicproptag_Visible = -1 ;
      edtavDynamicproptag_Enabled = 1 ;
      edtavDynamicpropname_Visible = -1 ;
      edtavDynamicpropname_Enabled = 1 ;
      edtavDeleteproperty_Visible = -1 ;
      edtavDeleteproperty_gximage = "" ;
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      bttBtnadd_Visible = 1 ;
      edtavUserinforesponseerrordescriptiontag_Jsonclick = "" ;
      edtavUserinforesponseerrordescriptiontag_Enabled = 1 ;
      edtavUserinforesponseusertimezonetag_Jsonclick = "" ;
      edtavUserinforesponseusertimezonetag_Enabled = 1 ;
      edtavUserinforesponseuserlanguagetag_Jsonclick = "" ;
      edtavUserinforesponseuserlanguagetag_Enabled = 1 ;
      edtavUserinforesponseuserurlprofiletag_Jsonclick = "" ;
      edtavUserinforesponseuserurlprofiletag_Enabled = 1 ;
      edtavUserinforesponseuserurlimagetag_Jsonclick = "" ;
      edtavUserinforesponseuserurlimagetag_Enabled = 1 ;
      edtavUserinforesponseuserbirthdaytag_Jsonclick = "" ;
      edtavUserinforesponseuserbirthdaytag_Enabled = 1 ;
      edtavUserinforesponseusergendervalues_Jsonclick = "" ;
      edtavUserinforesponseusergendervalues_Enabled = 1 ;
      edtavUserinforesponseusergendertag_Jsonclick = "" ;
      edtavUserinforesponseusergendertag_Enabled = 1 ;
      edtavUserinforesponseuserlastnametag_Jsonclick = "" ;
      edtavUserinforesponseuserlastnametag_Enabled = 1 ;
      chkavUserinforesponseuserlastnamegenauto.setEnabled( 1 );
      edtavUserinforesponseuserfirstnametag_Jsonclick = "" ;
      edtavUserinforesponseuserfirstnametag_Enabled = 1 ;
      edtavUserinforesponseusernametag_Jsonclick = "" ;
      edtavUserinforesponseusernametag_Enabled = 1 ;
      edtavUserinforesponseuserexternalidtag_Jsonclick = "" ;
      edtavUserinforesponseuserexternalidtag_Enabled = 1 ;
      edtavUserinforesponseuseremailtag_Jsonclick = "" ;
      edtavUserinforesponseuseremailtag_Enabled = 1 ;
      edtavKeystoretrustcred_Jsonclick = "" ;
      edtavKeystoretrustcred_Enabled = 1 ;
      edtavKeyaliastrustcred_Jsonclick = "" ;
      edtavKeyaliastrustcred_Enabled = 1 ;
      edtavKeystorepwdtrustcred_Jsonclick = "" ;
      edtavKeystorepwdtrustcred_Enabled = 1 ;
      edtavKeystorefilepathtrustcred_Jsonclick = "" ;
      edtavKeystorefilepathtrustcred_Enabled = 1 ;
      edtavKeystorecredential_Jsonclick = "" ;
      edtavKeystorecredential_Enabled = 1 ;
      edtavKeyaliascredential_Jsonclick = "" ;
      edtavKeyaliascredential_Enabled = 1 ;
      edtavKeystpwdcredential_Jsonclick = "" ;
      edtavKeystpwdcredential_Enabled = 1 ;
      edtavKeystpathcredential_Jsonclick = "" ;
      edtavKeystpathcredential_Enabled = 1 ;
      edtavSinglelogoutendpoint_Jsonclick = "" ;
      edtavSinglelogoutendpoint_Enabled = 1 ;
      edtavSinglelogoutendpoint_Visible = 1 ;
      divSinglelogoutendpoint_cell_Class = "col-xs-12 col-sm-6" ;
      chkavDisablesinglelogout.setEnabled( 1 );
      edtavAuthncontext_Jsonclick = "" ;
      edtavAuthncontext_Enabled = 1 ;
      chkavForceauthn.setEnabled( 1 );
      cmbavNameidpolicyformat.setJsonclick( "" );
      cmbavNameidpolicyformat.setEnabled( 1 );
      edtavSamlendpointlocation_Jsonclick = "" ;
      edtavSamlendpointlocation_Enabled = 1 ;
      chkavIsredirectbinding.setEnabled( 1 );
      edtavIdentityproviderentityid_Jsonclick = "" ;
      edtavIdentityproviderentityid_Enabled = 1 ;
      edtavServiceproviderentityid_Jsonclick = "" ;
      edtavServiceproviderentityid_Enabled = 1 ;
      edtavLocalsiteurl_Jsonclick = "" ;
      edtavLocalsiteurl_Enabled = 1 ;
      edtavBigimagename_Jsonclick = "" ;
      edtavBigimagename_Enabled = 1 ;
      edtavSmallimagename_Jsonclick = "" ;
      edtavSmallimagename_Enabled = 1 ;
      edtavImpersonate_Jsonclick = "" ;
      edtavImpersonate_Enabled = 1 ;
      chkavIsenable.setEnabled( 1 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 1 ;
      cmbavFunctionid.setJsonclick( "" );
      cmbavFunctionid.setEnabled( 1 );
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "" ;
      Gxuitabspanel_tabs_Pagecount = 3 ;
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Title = httpContext.getMessage( "WWP_GAM_CustomUserAttributes", "") ;
      Dvpanel_unnamedtable2_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      Dvpanel_unnamedtable5_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Iconposition = "Right" ;
      Dvpanel_unnamedtable5_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable5_Title = httpContext.getMessage( "WWP_GAM_Responsecredentials", "") ;
      Dvpanel_unnamedtable5_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable5_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable5_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Width = "100%" ;
      Dvpanel_unnamedtable4_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Iconposition = "Right" ;
      Dvpanel_unnamedtable4_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Title = httpContext.getMessage( "WWP_GAM_Requestcredentials", "") ;
      Dvpanel_unnamedtable4_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable4_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Width = "100%" ;
      Dvpanel_unnamedtable8_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Iconposition = "Right" ;
      Dvpanel_unnamedtable8_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable8_Title = httpContext.getMessage( "WWP_GAM_Logout", "") ;
      Dvpanel_unnamedtable8_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable8_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable8_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Width = "100%" ;
      Dvpanel_unnamedtable7_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Iconposition = "Right" ;
      Dvpanel_unnamedtable7_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable7_Title = httpContext.getMessage( "WWP_GAM_Login", "") ;
      Dvpanel_unnamedtable7_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable7_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable7_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Width = "100%" ;
      subGrid_Rows = 0 ;
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
      chkavIsenable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIsenable.getInternalname(), "TitleCaption", chkavIsenable.getCaption(), true);
      chkavIsenable.setCheckedValue( "false" );
      chkavIsredirectbinding.setName( "vISREDIRECTBINDING" );
      chkavIsredirectbinding.setWebtags( "" );
      chkavIsredirectbinding.setCaption( httpContext.getMessage( "WWP_GAM_ExecuteSAMLRequestsGET", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIsredirectbinding.getInternalname(), "TitleCaption", chkavIsredirectbinding.getCaption(), true);
      chkavIsredirectbinding.setCheckedValue( "false" );
      cmbavNameidpolicyformat.setName( "vNAMEIDPOLICYFORMAT" );
      cmbavNameidpolicyformat.setWebtags( "" );
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified", httpContext.getMessage( "UNSPECIFIED", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress", httpContext.getMessage( "EMAIL", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:2.0:nameid-format:encrypted", httpContext.getMessage( "ENCRYPTED", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:2.0:nameid-format:transient", httpContext.getMessage( "TRANSIENT", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:2.0:nameid-format:persistent", httpContext.getMessage( "PERSISTENT", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:2.0:nameid-format:entity", httpContext.getMessage( "ENTITY", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:2.0:nameid-format:kerberos", httpContext.getMessage( "KERBEROS", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:1.1:nameid-format:WindowsDomainQualifiedName", httpContext.getMessage( "WIN_DOMAIN_QUALIFIED", ""), (short)(0));
      cmbavNameidpolicyformat.addItem("urn:oasis:names:tc:SAML:1.1:nameid-format:X509SubjectName", httpContext.getMessage( "X509_SUBJECT", ""), (short)(0));
      if ( cmbavNameidpolicyformat.getItemCount() > 0 )
      {
      }
      chkavForceauthn.setName( "vFORCEAUTHN" );
      chkavForceauthn.setWebtags( "" );
      chkavForceauthn.setCaption( httpContext.getMessage( "WWP_GAM_ForceAuthentication", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavForceauthn.getInternalname(), "TitleCaption", chkavForceauthn.getCaption(), true);
      chkavForceauthn.setCheckedValue( "false" );
      chkavDisablesinglelogout.setName( "vDISABLESINGLELOGOUT" );
      chkavDisablesinglelogout.setWebtags( "" );
      chkavDisablesinglelogout.setCaption( httpContext.getMessage( "WWP_GAM_DisableSingleLogout", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavDisablesinglelogout.getInternalname(), "TitleCaption", chkavDisablesinglelogout.getCaption(), true);
      chkavDisablesinglelogout.setCheckedValue( "false" );
      chkavUserinforesponseuserlastnamegenauto.setName( "vUSERINFORESPONSEUSERLASTNAMEGENAUTO" );
      chkavUserinforesponseuserlastnamegenauto.setWebtags( "" );
      chkavUserinforesponseuserlastnamegenauto.setCaption( httpContext.getMessage( "WWP_GAM_GenerateautomaticLastName", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinforesponseuserlastnamegenauto.getInternalname(), "TitleCaption", chkavUserinforesponseuserlastnamegenauto.getCaption(), true);
      chkavUserinforesponseuserlastnamegenauto.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'sPrefix'},{av:'AV19IsEnable',fld:'vISENABLE',pic:''},{av:'AV20IsRedirectBinding',fld:'vISREDIRECTBINDING',pic:''},{av:'AV15ForceAuthn',fld:'vFORCEAUTHN',pic:''},{av:'AV67DisableSingleLogout',fld:'vDISABLESINGLELOGOUT',pic:''},{av:'AV51UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''},{av:'AV45UserInfoResponseUserErrorDescriptionTag',fld:'vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'edtavDeleteproperty_Enabled',ctrl:'vDELETEPROPERTY',prop:'Enabled'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e14302',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV65DeleteProperty',fld:'vDELETEPROPERTY',pic:''},{av:'edtavDeleteproperty_Tooltiptext',ctrl:'vDELETEPROPERTY',prop:'Tooltiptext'},{av:'AV11DynamicPropName',fld:'vDYNAMICPROPNAME',pic:''},{av:'AV12DynamicPropTag',fld:'vDYNAMICPROPTAG',pic:''},{av:'edtavDeleteproperty_Visible',ctrl:'vDELETEPROPERTY',prop:'Visible'},{av:'edtavDynamicpropname_Enabled',ctrl:'vDYNAMICPROPNAME',prop:'Enabled'},{av:'edtavDynamicproptag_Enabled',ctrl:'vDYNAMICPROPTAG',prop:'Enabled'}]}");
      setEventMetadata("'DOADD'","{handler:'e11302',iparms:[]");
      setEventMetadata("'DOADD'",",oparms:[{av:'AV65DeleteProperty',fld:'vDELETEPROPERTY',pic:''},{av:'edtavDeleteproperty_Visible',ctrl:'vDELETEPROPERTY',prop:'Visible'},{av:'edtavDynamicpropname_Enabled',ctrl:'vDYNAMICPROPNAME',prop:'Enabled'},{av:'edtavDynamicpropname_Visible',ctrl:'vDYNAMICPROPNAME',prop:'Visible'},{av:'edtavDynamicproptag_Enabled',ctrl:'vDYNAMICPROPTAG',prop:'Enabled'},{av:'edtavDynamicproptag_Visible',ctrl:'vDYNAMICPROPTAG',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e12302',iparms:[{av:'AV70CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV32Name',fld:'vNAME',pic:''},{av:'AV30LocalSiteURL',fld:'vLOCALSITEURL',pic:''},{av:'AV37ServiceProviderEntityId',fld:'vSERVICEPROVIDERENTITYID',pic:''},{av:'AV36SamlEndpointLocation',fld:'vSAMLENDPOINTLOCATION',pic:''},{av:'AV39SingleLogoutendpoint',fld:'vSINGLELOGOUTENDPOINT',pic:''},{av:'AV19IsEnable',fld:'vISENABLE',pic:''},{av:'AV10Dsc',fld:'vDSC',pic:''},{av:'AV40SmallImageName',fld:'vSMALLIMAGENAME',pic:''},{av:'AV7BigImageName',fld:'vBIGIMAGENAME',pic:''},{av:'AV18Impersonate',fld:'vIMPERSONATE',pic:''},{av:'AV38IdentityProviderEntityID',fld:'vIDENTITYPROVIDERENTITYID',pic:''},{av:'AV6AuthnContext',fld:'vAUTHNCONTEXT',pic:''},{av:'cmbavNameidpolicyformat'},{av:'AV69NameIdPolicyFormat',fld:'vNAMEIDPOLICYFORMAT',pic:''},{av:'AV20IsRedirectBinding',fld:'vISREDIRECTBINDING',pic:''},{av:'AV15ForceAuthn',fld:'vFORCEAUTHN',pic:''},{av:'AV21KeyAliasCredential',fld:'vKEYALIASCREDENTIAL',pic:''},{av:'AV22KeyAliasTrustCred',fld:'vKEYALIASTRUSTCRED',pic:''},{av:'AV24KeyStoreCredential',fld:'vKEYSTORECREDENTIAL',pic:''},{av:'AV25KeyStoreFilePathTrustCred',fld:'vKEYSTOREFILEPATHTRUSTCRED',pic:''},{av:'AV26KeyStorePwdTrustCred',fld:'vKEYSTOREPWDTRUSTCRED',pic:''},{av:'AV27KeyStoreTrustCred',fld:'vKEYSTORETRUSTCRED',pic:''},{av:'AV28KeyStPathCredential',fld:'vKEYSTPATHCREDENTIAL',pic:''},{av:'AV29KeyStPwdCredential',fld:'vKEYSTPWDCREDENTIAL',pic:''},{av:'AV67DisableSingleLogout',fld:'vDISABLESINGLELOGOUT',pic:''},{av:'AV45UserInfoResponseUserErrorDescriptionTag',fld:'vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG',pic:'',hsh:true},{av:'AV43UserInfoResponseUserBirthdayTag',fld:'vUSERINFORESPONSEUSERBIRTHDAYTAG',pic:''},{av:'AV44UserInfoResponseUserEmailTag',fld:'vUSERINFORESPONSEUSEREMAILTAG',pic:''},{av:'AV46UserInfoResponseUserExternalIdTag',fld:'vUSERINFORESPONSEUSEREXTERNALIDTAG',pic:''},{av:'AV47UserInfoResponseUserFirstNameTag',fld:'vUSERINFORESPONSEUSERFIRSTNAMETAG',pic:''},{av:'AV48UserInfoResponseUserGenderTag',fld:'vUSERINFORESPONSEUSERGENDERTAG',pic:''},{av:'AV49UserInfoResponseUserGenderValues',fld:'vUSERINFORESPONSEUSERGENDERVALUES',pic:''},{av:'AV50UserInfoResponseUserLanguageTag',fld:'vUSERINFORESPONSEUSERLANGUAGETAG',pic:''},{av:'AV51UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''},{av:'AV52UserInfoResponseUserLastNameTag',fld:'vUSERINFORESPONSEUSERLASTNAMETAG',pic:''},{av:'AV53UserInfoResponseUserNameTag',fld:'vUSERINFORESPONSEUSERNAMETAG',pic:''},{av:'AV54UserInfoResponseUserTimeZoneTag',fld:'vUSERINFORESPONSEUSERTIMEZONETAG',pic:''},{av:'AV55UserInfoResponseUserURLImageTag',fld:'vUSERINFORESPONSEUSERURLIMAGETAG',pic:''},{av:'AV56UserInfoResponseUserURLProfileTag',fld:'vUSERINFORESPONSEUSERURLPROFILETAG',pic:''},{av:'AV11DynamicPropName',fld:'vDYNAMICPROPNAME',grid:235,pic:''},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_235',ctrl:'GRID',grid:235,prop:'GridRC',grid:235},{av:'AV12DynamicPropTag',fld:'vDYNAMICPROPTAG',grid:235,pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV70CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VDELETEPROPERTY.CLICK","{handler:'e16302',iparms:[{av:'AV32Name',fld:'vNAME',pic:''}]");
      setEventMetadata("VDELETEPROPERTY.CLICK",",oparms:[{av:'AV65DeleteProperty',fld:'vDELETEPROPERTY',pic:''},{av:'edtavDeleteproperty_Visible',ctrl:'vDELETEPROPERTY',prop:'Visible'},{av:'edtavDynamicpropname_Visible',ctrl:'vDYNAMICPROPNAME',prop:'Visible'},{av:'edtavDynamicproptag_Visible',ctrl:'vDYNAMICPROPTAG',prop:'Visible'},{av:'AV11DynamicPropName',fld:'vDYNAMICPROPNAME',pic:''},{av:'AV12DynamicPropTag',fld:'vDYNAMICPROPTAG',pic:''}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV45UserInfoResponseUserErrorDescriptionTag',fld:'vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG',pic:'',hsh:true},{av:'sPrefix'},{av:'AV19IsEnable',fld:'vISENABLE',pic:''},{av:'AV20IsRedirectBinding',fld:'vISREDIRECTBINDING',pic:''},{av:'AV15ForceAuthn',fld:'vFORCEAUTHN',pic:''},{av:'AV67DisableSingleLogout',fld:'vDISABLESINGLELOGOUT',pic:''},{av:'AV51UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[{av:'edtavDeleteproperty_Enabled',ctrl:'vDELETEPROPERTY',prop:'Enabled'}]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV45UserInfoResponseUserErrorDescriptionTag',fld:'vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG',pic:'',hsh:true},{av:'sPrefix'},{av:'AV19IsEnable',fld:'vISENABLE',pic:''},{av:'AV20IsRedirectBinding',fld:'vISREDIRECTBINDING',pic:''},{av:'AV15ForceAuthn',fld:'vFORCEAUTHN',pic:''},{av:'AV67DisableSingleLogout',fld:'vDISABLESINGLELOGOUT',pic:''},{av:'AV51UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[{av:'edtavDeleteproperty_Enabled',ctrl:'vDELETEPROPERTY',prop:'Enabled'}]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV45UserInfoResponseUserErrorDescriptionTag',fld:'vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG',pic:'',hsh:true},{av:'sPrefix'},{av:'AV19IsEnable',fld:'vISENABLE',pic:''},{av:'AV20IsRedirectBinding',fld:'vISREDIRECTBINDING',pic:''},{av:'AV15ForceAuthn',fld:'vFORCEAUTHN',pic:''},{av:'AV67DisableSingleLogout',fld:'vDISABLESINGLELOGOUT',pic:''},{av:'AV51UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[{av:'edtavDeleteproperty_Enabled',ctrl:'vDELETEPROPERTY',prop:'Enabled'}]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV45UserInfoResponseUserErrorDescriptionTag',fld:'vUSERINFORESPONSEUSERERRORDESCRIPTIONTAG',pic:'',hsh:true},{av:'sPrefix'},{av:'AV19IsEnable',fld:'vISENABLE',pic:''},{av:'AV20IsRedirectBinding',fld:'vISREDIRECTBINDING',pic:''},{av:'AV15ForceAuthn',fld:'vFORCEAUTHN',pic:''},{av:'AV67DisableSingleLogout',fld:'vDISABLESINGLELOGOUT',pic:''},{av:'AV51UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[{av:'edtavDeleteproperty_Enabled',ctrl:'vDELETEPROPERTY',prop:'Enabled'}]}");
      setEventMetadata("VALIDV_FUNCTIONID","{handler:'validv_Functionid',iparms:[]");
      setEventMetadata("VALIDV_FUNCTIONID",",oparms:[]}");
      setEventMetadata("VALIDV_NAMEIDPOLICYFORMAT","{handler:'validv_Nameidpolicyformat',iparms:[]");
      setEventMetadata("VALIDV_NAMEIDPOLICYFORMAT",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Deleteproperty',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      wcpOAV32Name = "" ;
      wcpOAV41TypeId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      Gx_mode = "" ;
      AV32Name = "" ;
      AV41TypeId = "" ;
      AV45UserInfoResponseUserErrorDescriptionTag = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      AV16FunctionId = "" ;
      AV10Dsc = "" ;
      AV18Impersonate = "" ;
      AV40SmallImageName = "" ;
      AV7BigImageName = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      AV30LocalSiteURL = "" ;
      AV37ServiceProviderEntityId = "" ;
      AV38IdentityProviderEntityID = "" ;
      ucDvpanel_unnamedtable7 = new com.genexus.webpanels.GXUserControl();
      AV36SamlEndpointLocation = "" ;
      AV69NameIdPolicyFormat = "" ;
      AV6AuthnContext = "" ;
      ucDvpanel_unnamedtable8 = new com.genexus.webpanels.GXUserControl();
      AV39SingleLogoutendpoint = "" ;
      lblCredentials_title_Jsonclick = "" ;
      ucDvpanel_unnamedtable4 = new com.genexus.webpanels.GXUserControl();
      AV28KeyStPathCredential = "" ;
      AV29KeyStPwdCredential = "" ;
      AV21KeyAliasCredential = "" ;
      AV24KeyStoreCredential = "" ;
      ucDvpanel_unnamedtable5 = new com.genexus.webpanels.GXUserControl();
      AV25KeyStoreFilePathTrustCred = "" ;
      AV26KeyStorePwdTrustCred = "" ;
      AV22KeyAliasTrustCred = "" ;
      AV27KeyStoreTrustCred = "" ;
      lblUserinfo_title_Jsonclick = "" ;
      AV44UserInfoResponseUserEmailTag = "" ;
      AV46UserInfoResponseUserExternalIdTag = "" ;
      AV53UserInfoResponseUserNameTag = "" ;
      AV47UserInfoResponseUserFirstNameTag = "" ;
      AV52UserInfoResponseUserLastNameTag = "" ;
      AV48UserInfoResponseUserGenderTag = "" ;
      AV49UserInfoResponseUserGenderValues = "" ;
      AV43UserInfoResponseUserBirthdayTag = "" ;
      AV55UserInfoResponseUserURLImageTag = "" ;
      AV56UserInfoResponseUserURLProfileTag = "" ;
      AV50UserInfoResponseUserLanguageTag = "" ;
      AV54UserInfoResponseUserTimeZoneTag = "" ;
      AV42UserInfoResponseErrorDescriptionTag = "" ;
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      bttBtnadd_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV11DynamicPropName = "" ;
      AV12DynamicPropTag = "" ;
      AV65DeleteProperty = "" ;
      AV75Deleteproperty_GXI = "" ;
      AV5AuthenticationTypeSaml20 = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSaml20(remoteHandle, context);
      AV17GAMPropertySimple = new genexus.security.api.genexussecurity.SdtGAMPropertySimple(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV14Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV13Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlGx_mode = "" ;
      sCtrlAV32Name = "" ;
      sCtrlAV41TypeId = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwcauthenticationtypeentrysaml20__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwcauthenticationtypeentrysaml20__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_235 ;
   private int subGrid_Rows ;
   private int nGXsfl_235_idx=1 ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavImpersonate_Enabled ;
   private int edtavSmallimagename_Enabled ;
   private int edtavBigimagename_Enabled ;
   private int edtavLocalsiteurl_Enabled ;
   private int edtavServiceproviderentityid_Enabled ;
   private int edtavIdentityproviderentityid_Enabled ;
   private int edtavSamlendpointlocation_Enabled ;
   private int edtavAuthncontext_Enabled ;
   private int edtavSinglelogoutendpoint_Visible ;
   private int edtavSinglelogoutendpoint_Enabled ;
   private int edtavKeystpathcredential_Enabled ;
   private int edtavKeystpwdcredential_Enabled ;
   private int edtavKeyaliascredential_Enabled ;
   private int edtavKeystorecredential_Enabled ;
   private int edtavKeystorefilepathtrustcred_Enabled ;
   private int edtavKeystorepwdtrustcred_Enabled ;
   private int edtavKeyaliastrustcred_Enabled ;
   private int edtavKeystoretrustcred_Enabled ;
   private int edtavUserinforesponseuseremailtag_Enabled ;
   private int edtavUserinforesponseuserexternalidtag_Enabled ;
   private int edtavUserinforesponseusernametag_Enabled ;
   private int edtavUserinforesponseuserfirstnametag_Enabled ;
   private int edtavUserinforesponseuserlastnametag_Enabled ;
   private int edtavUserinforesponseusergendertag_Enabled ;
   private int edtavUserinforesponseusergendervalues_Enabled ;
   private int edtavUserinforesponseuserbirthdaytag_Enabled ;
   private int edtavUserinforesponseuserurlimagetag_Enabled ;
   private int edtavUserinforesponseuserurlprofiletag_Enabled ;
   private int edtavUserinforesponseuserlanguagetag_Enabled ;
   private int edtavUserinforesponseusertimezonetag_Enabled ;
   private int edtavUserinforesponseerrordescriptiontag_Enabled ;
   private int bttBtnadd_Visible ;
   private int bttBtnenter_Visible ;
   private int subGrid_Islastpage ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV74GXV1 ;
   private int edtavDeleteproperty_Visible ;
   private int edtavDynamicpropname_Enabled ;
   private int edtavDynamicproptag_Enabled ;
   private int edtavDynamicpropname_Visible ;
   private int edtavDynamicproptag_Visible ;
   private int edtavDeleteproperty_Enabled ;
   private int AV76GXV2 ;
   private int nGXsfl_235_fel_idx=1 ;
   private int AV78GXV3 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private String wcpOGx_mode ;
   private String wcpOAV32Name ;
   private String wcpOAV41TypeId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String Gx_mode ;
   private String AV32Name ;
   private String AV41TypeId ;
   private String sGXsfl_235_idx="0001" ;
   private String AV45UserInfoResponseUserErrorDescriptionTag ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_unnamedtable7_Width ;
   private String Dvpanel_unnamedtable7_Cls ;
   private String Dvpanel_unnamedtable7_Title ;
   private String Dvpanel_unnamedtable7_Iconposition ;
   private String Dvpanel_unnamedtable8_Width ;
   private String Dvpanel_unnamedtable8_Cls ;
   private String Dvpanel_unnamedtable8_Title ;
   private String Dvpanel_unnamedtable8_Iconposition ;
   private String Dvpanel_unnamedtable4_Width ;
   private String Dvpanel_unnamedtable4_Cls ;
   private String Dvpanel_unnamedtable4_Title ;
   private String Dvpanel_unnamedtable4_Iconposition ;
   private String Dvpanel_unnamedtable5_Width ;
   private String Dvpanel_unnamedtable5_Cls ;
   private String Dvpanel_unnamedtable5_Title ;
   private String Dvpanel_unnamedtable5_Iconposition ;
   private String Dvpanel_unnamedtable2_Width ;
   private String Dvpanel_unnamedtable2_Cls ;
   private String Dvpanel_unnamedtable2_Title ;
   private String Dvpanel_unnamedtable2_Iconposition ;
   private String Gxuitabspanel_tabs_Class ;
   private String Grid_empowerer_Gridinternalname ;
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
   private String AV16FunctionId ;
   private String edtavDsc_Internalname ;
   private String AV10Dsc ;
   private String edtavDsc_Jsonclick ;
   private String edtavImpersonate_Internalname ;
   private String AV18Impersonate ;
   private String edtavImpersonate_Jsonclick ;
   private String edtavSmallimagename_Internalname ;
   private String AV40SmallImageName ;
   private String edtavSmallimagename_Jsonclick ;
   private String edtavBigimagename_Internalname ;
   private String AV7BigImageName ;
   private String edtavBigimagename_Jsonclick ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtable6_Internalname ;
   private String edtavLocalsiteurl_Internalname ;
   private String edtavLocalsiteurl_Jsonclick ;
   private String edtavServiceproviderentityid_Internalname ;
   private String edtavServiceproviderentityid_Jsonclick ;
   private String edtavIdentityproviderentityid_Internalname ;
   private String edtavIdentityproviderentityid_Jsonclick ;
   private String Dvpanel_unnamedtable7_Internalname ;
   private String divUnnamedtable7_Internalname ;
   private String edtavSamlendpointlocation_Internalname ;
   private String edtavSamlendpointlocation_Jsonclick ;
   private String AV69NameIdPolicyFormat ;
   private String edtavAuthncontext_Internalname ;
   private String AV6AuthnContext ;
   private String edtavAuthncontext_Jsonclick ;
   private String Dvpanel_unnamedtable8_Internalname ;
   private String divUnnamedtable8_Internalname ;
   private String divSinglelogoutendpoint_cell_Internalname ;
   private String divSinglelogoutendpoint_cell_Class ;
   private String edtavSinglelogoutendpoint_Internalname ;
   private String edtavSinglelogoutendpoint_Jsonclick ;
   private String lblCredentials_title_Internalname ;
   private String lblCredentials_title_Jsonclick ;
   private String divUnnamedtable3_Internalname ;
   private String Dvpanel_unnamedtable4_Internalname ;
   private String divUnnamedtable4_Internalname ;
   private String edtavKeystpathcredential_Internalname ;
   private String edtavKeystpathcredential_Jsonclick ;
   private String edtavKeystpwdcredential_Internalname ;
   private String AV29KeyStPwdCredential ;
   private String edtavKeystpwdcredential_Jsonclick ;
   private String edtavKeyaliascredential_Internalname ;
   private String AV21KeyAliasCredential ;
   private String edtavKeyaliascredential_Jsonclick ;
   private String edtavKeystorecredential_Internalname ;
   private String AV24KeyStoreCredential ;
   private String edtavKeystorecredential_Jsonclick ;
   private String Dvpanel_unnamedtable5_Internalname ;
   private String divUnnamedtable5_Internalname ;
   private String edtavKeystorefilepathtrustcred_Internalname ;
   private String edtavKeystorefilepathtrustcred_Jsonclick ;
   private String edtavKeystorepwdtrustcred_Internalname ;
   private String AV26KeyStorePwdTrustCred ;
   private String edtavKeystorepwdtrustcred_Jsonclick ;
   private String edtavKeyaliastrustcred_Internalname ;
   private String AV22KeyAliasTrustCred ;
   private String edtavKeyaliastrustcred_Jsonclick ;
   private String edtavKeystoretrustcred_Internalname ;
   private String AV27KeyStoreTrustCred ;
   private String edtavKeystoretrustcred_Jsonclick ;
   private String lblUserinfo_title_Internalname ;
   private String lblUserinfo_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String edtavUserinforesponseuseremailtag_Internalname ;
   private String AV44UserInfoResponseUserEmailTag ;
   private String edtavUserinforesponseuseremailtag_Jsonclick ;
   private String edtavUserinforesponseuserexternalidtag_Internalname ;
   private String AV46UserInfoResponseUserExternalIdTag ;
   private String edtavUserinforesponseuserexternalidtag_Jsonclick ;
   private String edtavUserinforesponseusernametag_Internalname ;
   private String AV53UserInfoResponseUserNameTag ;
   private String edtavUserinforesponseusernametag_Jsonclick ;
   private String edtavUserinforesponseuserfirstnametag_Internalname ;
   private String AV47UserInfoResponseUserFirstNameTag ;
   private String edtavUserinforesponseuserfirstnametag_Jsonclick ;
   private String edtavUserinforesponseuserlastnametag_Internalname ;
   private String AV52UserInfoResponseUserLastNameTag ;
   private String edtavUserinforesponseuserlastnametag_Jsonclick ;
   private String edtavUserinforesponseusergendertag_Internalname ;
   private String AV48UserInfoResponseUserGenderTag ;
   private String edtavUserinforesponseusergendertag_Jsonclick ;
   private String edtavUserinforesponseusergendervalues_Internalname ;
   private String edtavUserinforesponseusergendervalues_Jsonclick ;
   private String edtavUserinforesponseuserbirthdaytag_Internalname ;
   private String AV43UserInfoResponseUserBirthdayTag ;
   private String edtavUserinforesponseuserbirthdaytag_Jsonclick ;
   private String edtavUserinforesponseuserurlimagetag_Internalname ;
   private String AV55UserInfoResponseUserURLImageTag ;
   private String edtavUserinforesponseuserurlimagetag_Jsonclick ;
   private String edtavUserinforesponseuserurlprofiletag_Internalname ;
   private String AV56UserInfoResponseUserURLProfileTag ;
   private String edtavUserinforesponseuserurlprofiletag_Jsonclick ;
   private String edtavUserinforesponseuserlanguagetag_Internalname ;
   private String AV50UserInfoResponseUserLanguageTag ;
   private String edtavUserinforesponseuserlanguagetag_Jsonclick ;
   private String edtavUserinforesponseusertimezonetag_Internalname ;
   private String AV54UserInfoResponseUserTimeZoneTag ;
   private String edtavUserinforesponseusertimezonetag_Jsonclick ;
   private String edtavUserinforesponseerrordescriptiontag_Internalname ;
   private String AV42UserInfoResponseErrorDescriptionTag ;
   private String edtavUserinforesponseerrordescriptiontag_Jsonclick ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String bttBtnadd_Internalname ;
   private String bttBtnadd_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavDynamicpropname_Internalname ;
   private String AV11DynamicPropName ;
   private String AV12DynamicPropTag ;
   private String edtavDynamicproptag_Internalname ;
   private String edtavDeleteproperty_Internalname ;
   private String edtavDeleteproperty_gximage ;
   private String edtavDeleteproperty_Tooltiptext ;
   private String sGXsfl_235_fel_idx="0001" ;
   private String sCtrlGx_mode ;
   private String sCtrlAV32Name ;
   private String sCtrlAV41TypeId ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDynamicpropname_Jsonclick ;
   private String edtavDynamicproptag_Jsonclick ;
   private String sImgUrl ;
   private String edtavDeleteproperty_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV19IsEnable ;
   private boolean AV20IsRedirectBinding ;
   private boolean AV15ForceAuthn ;
   private boolean AV67DisableSingleLogout ;
   private boolean AV51UserInfoResponseUserLastNameGenAuto ;
   private boolean AV70CheckRequiredFieldsResult ;
   private boolean Dvpanel_unnamedtable7_Autowidth ;
   private boolean Dvpanel_unnamedtable7_Autoheight ;
   private boolean Dvpanel_unnamedtable7_Collapsible ;
   private boolean Dvpanel_unnamedtable7_Collapsed ;
   private boolean Dvpanel_unnamedtable7_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable7_Autoscroll ;
   private boolean Dvpanel_unnamedtable8_Autowidth ;
   private boolean Dvpanel_unnamedtable8_Autoheight ;
   private boolean Dvpanel_unnamedtable8_Collapsible ;
   private boolean Dvpanel_unnamedtable8_Collapsed ;
   private boolean Dvpanel_unnamedtable8_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable8_Autoscroll ;
   private boolean Dvpanel_unnamedtable4_Autowidth ;
   private boolean Dvpanel_unnamedtable4_Autoheight ;
   private boolean Dvpanel_unnamedtable4_Collapsible ;
   private boolean Dvpanel_unnamedtable4_Collapsed ;
   private boolean Dvpanel_unnamedtable4_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable4_Autoscroll ;
   private boolean Dvpanel_unnamedtable5_Autowidth ;
   private boolean Dvpanel_unnamedtable5_Autoheight ;
   private boolean Dvpanel_unnamedtable5_Collapsible ;
   private boolean Dvpanel_unnamedtable5_Collapsed ;
   private boolean Dvpanel_unnamedtable5_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable5_Autoscroll ;
   private boolean Dvpanel_unnamedtable2_Autowidth ;
   private boolean Dvpanel_unnamedtable2_Autoheight ;
   private boolean Dvpanel_unnamedtable2_Collapsible ;
   private boolean Dvpanel_unnamedtable2_Collapsed ;
   private boolean Dvpanel_unnamedtable2_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable2_Autoscroll ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_235_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV65DeleteProperty_IsBlob ;
   private String AV30LocalSiteURL ;
   private String AV37ServiceProviderEntityId ;
   private String AV38IdentityProviderEntityID ;
   private String AV36SamlEndpointLocation ;
   private String AV39SingleLogoutendpoint ;
   private String AV28KeyStPathCredential ;
   private String AV25KeyStoreFilePathTrustCred ;
   private String AV49UserInfoResponseUserGenderValues ;
   private String AV75Deleteproperty_GXI ;
   private String AV65DeleteProperty ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable7 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable8 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable4 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable5 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV14Errors ;
   private HTMLChoice cmbavFunctionid ;
   private ICheckbox chkavIsenable ;
   private ICheckbox chkavIsredirectbinding ;
   private HTMLChoice cmbavNameidpolicyformat ;
   private ICheckbox chkavForceauthn ;
   private ICheckbox chkavDisablesinglelogout ;
   private ICheckbox chkavUserinforesponseuserlastnamegenauto ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSaml20 AV5AuthenticationTypeSaml20 ;
   private genexus.security.api.genexussecurity.SdtGAMPropertySimple AV17GAMPropertySimple ;
   private genexus.security.api.genexussecurity.SdtGAMError AV13Error ;
}

final  class gamwcauthenticationtypeentrysaml20__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwcauthenticationtypeentrysaml20__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

