package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwcauthenticationtypeentryoauth20_impl extends GXWebComponent
{
   public gamwcauthenticationtypeentryoauth20_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwcauthenticationtypeentryoauth20_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwcauthenticationtypeentryoauth20_impl.class ));
   }

   public gamwcauthenticationtypeentryoauth20_impl( int remoteHandle ,
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
      chkavOauth20redirecturliscustom = UIFactory.getCheckbox(this);
      chkavOauth20redirecttoauthenticate = UIFactory.getCheckbox(this);
      chkavAuthresptypeinclude = UIFactory.getCheckbox(this);
      chkavAuthscopeinclude = UIFactory.getCheckbox(this);
      chkavAuthstateinclude = UIFactory.getCheckbox(this);
      chkavAuthclientidinclude = UIFactory.getCheckbox(this);
      chkavAuthclientsecretinclude = UIFactory.getCheckbox(this);
      chkavAuthredirurlinclude = UIFactory.getCheckbox(this);
      cmbavTokenmethod = new HTMLChoice();
      chkavTokenheaderauthenticationinclude = UIFactory.getCheckbox(this);
      cmbavTokenheaderauthenticationmethod = new HTMLChoice();
      chkavTokenheaderauthorizationbasicinclude = UIFactory.getCheckbox(this);
      chkavTokengranttypeinclude = UIFactory.getCheckbox(this);
      chkavTokenaccesscodeinclude = UIFactory.getCheckbox(this);
      chkavTokencliidinclude = UIFactory.getCheckbox(this);
      chkavTokenclisecretinclude = UIFactory.getCheckbox(this);
      chkavTokenredirecturlinclude = UIFactory.getCheckbox(this);
      chkavAutovalidateexternaltokenandrefresh = UIFactory.getCheckbox(this);
      cmbavUserinfomethod = new HTMLChoice();
      chkavUserinfoaccesstokeninclude = UIFactory.getCheckbox(this);
      chkavUserinfoclientidinclude = UIFactory.getCheckbox(this);
      chkavUserinfoclientsecretinclude = UIFactory.getCheckbox(this);
      chkavUserinfouseridinclude = UIFactory.getCheckbox(this);
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
               AV34Name = httpContext.GetPar( "Name") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Name", AV34Name);
               AV68TypeId = httpContext.GetPar( "TypeId") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TypeId", AV68TypeId);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Gx_mode,AV34Name,AV68TypeId});
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
      nRC_GXsfl_462 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_462"))) ;
      nGXsfl_462_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_462_idx"))) ;
      sGXsfl_462_idx = httpContext.GetPar( "sGXsfl_462_idx") ;
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
      AV33IsEnable = GXutil.strtobool( httpContext.GetPar( "IsEnable")) ;
      AV40Oauth20RedirectURLisCustom = GXutil.strtobool( httpContext.GetPar( "Oauth20RedirectURLisCustom")) ;
      AV39Oauth20RedirectToAuthenticate = GXutil.strtobool( httpContext.GetPar( "Oauth20RedirectToAuthenticate")) ;
      AV14AuthRespTypeInclude = GXutil.strtobool( httpContext.GetPar( "AuthRespTypeInclude")) ;
      AV17AuthScopeInclude = GXutil.strtobool( httpContext.GetPar( "AuthScopeInclude")) ;
      AV98AuthStateInclude = GXutil.strtobool( httpContext.GetPar( "AuthStateInclude")) ;
      AV7AuthClientIdInclude = GXutil.strtobool( httpContext.GetPar( "AuthClientIdInclude")) ;
      AV8AuthClientSecretInclude = GXutil.strtobool( httpContext.GetPar( "AuthClientSecretInclude")) ;
      AV99AuthRedirURLInclude = GXutil.strtobool( httpContext.GetPar( "AuthRedirURLInclude")) ;
      AV51TokenHeaderAuthenticationInclude = GXutil.strtobool( httpContext.GetPar( "TokenHeaderAuthenticationInclude")) ;
      AV54TokenHeaderAuthorizationBasicInclude = GXutil.strtobool( httpContext.GetPar( "TokenHeaderAuthorizationBasicInclude")) ;
      AV48TokenGrantTypeInclude = GXutil.strtobool( httpContext.GetPar( "TokenGrantTypeInclude")) ;
      AV44TokenAccessCodeInclude = GXutil.strtobool( httpContext.GetPar( "TokenAccessCodeInclude")) ;
      AV46TokenCliIdInclude = GXutil.strtobool( httpContext.GetPar( "TokenCliIdInclude")) ;
      AV47TokenCliSecretInclude = GXutil.strtobool( httpContext.GetPar( "TokenCliSecretInclude")) ;
      AV58TokenRedirectURLInclude = GXutil.strtobool( httpContext.GetPar( "TokenRedirectURLInclude")) ;
      AV22AutovalidateExternalTokenAndRefresh = GXutil.strtobool( httpContext.GetPar( "AutovalidateExternalTokenAndRefresh")) ;
      AV69UserInfoAccessTokenInclude = GXutil.strtobool( httpContext.GetPar( "UserInfoAccessTokenInclude")) ;
      AV72UserInfoClientIdInclude = GXutil.strtobool( httpContext.GetPar( "UserInfoClientIdInclude")) ;
      AV74UserInfoClientSecretInclude = GXutil.strtobool( httpContext.GetPar( "UserInfoClientSecretInclude")) ;
      AV95UserInfoUserIdInclude = GXutil.strtobool( httpContext.GetPar( "UserInfoUserIdInclude")) ;
      AV87UserInfoResponseUserLastNameGenAuto = GXutil.strtobool( httpContext.GetPar( "UserInfoResponseUserLastNameGenAuto")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV33IsEnable, AV40Oauth20RedirectURLisCustom, AV39Oauth20RedirectToAuthenticate, AV14AuthRespTypeInclude, AV17AuthScopeInclude, AV98AuthStateInclude, AV7AuthClientIdInclude, AV8AuthClientSecretInclude, AV99AuthRedirURLInclude, AV51TokenHeaderAuthenticationInclude, AV54TokenHeaderAuthorizationBasicInclude, AV48TokenGrantTypeInclude, AV44TokenAccessCodeInclude, AV46TokenCliIdInclude, AV47TokenCliSecretInclude, AV58TokenRedirectURLInclude, AV22AutovalidateExternalTokenAndRefresh, AV69UserInfoAccessTokenInclude, AV72UserInfoClientIdInclude, AV74UserInfoClientSecretInclude, AV95UserInfoUserIdInclude, AV87UserInfoResponseUserLastNameGenAuto, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa2W2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Authentication Type Entry Oauth20", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwcauthenticationtypeentryoauth20", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV34Name)),GXutil.URLEncode(GXutil.rtrim(AV68TypeId))}, new String[] {"Gx_mode","Name","TypeId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_462", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_462, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOGx_mode", GXutil.rtrim( wcpOGx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV34Name", GXutil.rtrim( wcpOAV34Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV68TypeId", GXutil.rtrim( wcpOAV68TypeId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCHECKREQUIREDFIELDSRESULT", AV105CheckRequiredFieldsResult);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTYPEID", GXutil.rtrim( AV68TypeId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Width", GXutil.rtrim( Dvpanel_unnamedtable11_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable11_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable11_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Cls", GXutil.rtrim( Dvpanel_unnamedtable11_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Title", GXutil.rtrim( Dvpanel_unnamedtable11_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable11_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable11_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable11_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable11_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE11_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable11_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Width", GXutil.rtrim( Dvpanel_unnamedtable10_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable10_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable10_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Cls", GXutil.rtrim( Dvpanel_unnamedtable10_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Title", GXutil.rtrim( Dvpanel_unnamedtable10_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable10_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable10_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable10_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable10_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE10_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable10_Autoscroll));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Width", GXutil.rtrim( Dvpanel_unnamedtable6_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable6_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable6_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Cls", GXutil.rtrim( Dvpanel_unnamedtable6_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Title", GXutil.rtrim( Dvpanel_unnamedtable6_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable6_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable6_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable6_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable6_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE6_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable6_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Width", GXutil.rtrim( Dvpanel_unnamedtable3_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable3_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable3_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Cls", GXutil.rtrim( Dvpanel_unnamedtable3_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Title", GXutil.rtrim( Dvpanel_unnamedtable3_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable3_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable3_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable3_Autoscroll));
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

   public void renderHtmlCloseForm2W2( )
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
      return "GAMWCAuthenticationTypeEntryOauth20" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Authentication Type Entry Oauth20", "") ;
   }

   public void wb2W0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.gamwcauthenticationtypeentryoauth20");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV34Name), GXutil.rtrim( localUtil.format( AV34Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 24,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFunctionid, cmbavFunctionid.getInternalname(), GXutil.rtrim( AV30FunctionId), 1, cmbavFunctionid.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFunctionid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,24);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         cmbavFunctionid.setValue( GXutil.rtrim( AV30FunctionId) );
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV25Dsc), GXutil.rtrim( localUtil.format( AV25Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsenable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsenable.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsenable.getInternalname(), GXutil.booltostr( AV33IsEnable), "", " ", 1, chkavIsenable.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Enabled", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(33, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,33);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavImpersonate_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavImpersonate_Internalname, httpContext.getMessage( "WWP_GAM_Impersonate", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavImpersonate_Internalname, GXutil.rtrim( AV32Impersonate), GXutil.rtrim( localUtil.format( AV32Impersonate, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavImpersonate_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavImpersonate_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMAuthenticationTypeName", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSmallimagename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSmallimagename_Internalname, httpContext.getMessage( "WWP_GAM_Smallimagename", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSmallimagename_Internalname, GXutil.rtrim( AV43SmallImageName), GXutil.rtrim( localUtil.format( AV43SmallImageName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSmallimagename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSmallimagename_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavBigimagename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavBigimagename_Internalname, httpContext.getMessage( "WWP_GAM_BigImageName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavBigimagename_Internalname, GXutil.rtrim( AV23BigImageName), GXutil.rtrim( localUtil.format( AV23BigImageName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBigimagename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavBigimagename_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "WWP_GAM_General", ""), "", "", lblGeneral_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable12_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOauth20clientidtag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOauth20clientidtag_Internalname, httpContext.getMessage( "WWP_GAM_ClientIdTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOauth20clientidtag_Internalname, GXutil.rtrim( AV35Oauth20ClientIdTag), GXutil.rtrim( localUtil.format( AV35Oauth20ClientIdTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOauth20clientidtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOauth20clientidtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOauth20clientidvalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOauth20clientidvalue_Internalname, httpContext.getMessage( "WWP_GAM_ClientIdValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOauth20clientidvalue_Internalname, AV36Oauth20ClientIdValue, GXutil.rtrim( localUtil.format( AV36Oauth20ClientIdValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOauth20clientidvalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOauth20clientidvalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOauth20clientsecrettag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOauth20clientsecrettag_Internalname, httpContext.getMessage( "WWP_GAM_ClientSecretTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOauth20clientsecrettag_Internalname, GXutil.rtrim( AV37Oauth20ClientSecretTag), GXutil.rtrim( localUtil.format( AV37Oauth20ClientSecretTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOauth20clientsecrettag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOauth20clientsecrettag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOauth20clientsecretvalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOauth20clientsecretvalue_Internalname, httpContext.getMessage( "WWP_GAM_ClientSecretValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOauth20clientsecretvalue_Internalname, AV38Oauth20ClientSecretValue, GXutil.rtrim( localUtil.format( AV38Oauth20ClientSecretValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOauth20clientsecretvalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOauth20clientsecretvalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOauth20redirecturltag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOauth20redirecturltag_Internalname, httpContext.getMessage( "WWP_GAM_RedirectURLTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOauth20redirecturltag_Internalname, GXutil.rtrim( AV41Oauth20RedirectURLTag), GXutil.rtrim( localUtil.format( AV41Oauth20RedirectURLTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOauth20redirecturltag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOauth20redirecturltag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOauth20redirecturlvalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOauth20redirecturlvalue_Internalname, httpContext.getMessage( "WWP_GAM_RedirectURLValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOauth20redirecturlvalue_Internalname, AV42Oauth20RedirectURLvalue, GXutil.rtrim( localUtil.format( AV42Oauth20RedirectURLvalue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOauth20redirecturlvalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavOauth20redirecturlvalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavOauth20redirecturliscustom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavOauth20redirecturliscustom.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavOauth20redirecturliscustom.getInternalname(), GXutil.booltostr( AV40Oauth20RedirectURLisCustom), "", " ", 1, chkavOauth20redirecturliscustom.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CustomRedirectURL", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(87, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,87);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavOauth20redirecttoauthenticate.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavOauth20redirecttoauthenticate.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavOauth20redirecttoauthenticate.getInternalname(), GXutil.booltostr( AV39Oauth20RedirectToAuthenticate), "", " ", 1, chkavOauth20redirecttoauthenticate.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_RedirectToAuthenticate", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(91, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,91);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblAuthorization_title_Internalname, httpContext.getMessage( "WWP_GAM_Authorization", ""), "", "", lblAuthorization_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Authorization") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable9_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthorizeurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthorizeurl_Internalname, httpContext.getMessage( "WWP_GAM_URL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthorizeurl_Internalname, AV10AuthorizeURL, GXutil.rtrim( localUtil.format( AV10AuthorizeURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,101);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthorizeurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthorizeurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable10.setProperty("Width", Dvpanel_unnamedtable10_Width);
         ucDvpanel_unnamedtable10.setProperty("AutoWidth", Dvpanel_unnamedtable10_Autowidth);
         ucDvpanel_unnamedtable10.setProperty("AutoHeight", Dvpanel_unnamedtable10_Autoheight);
         ucDvpanel_unnamedtable10.setProperty("Cls", Dvpanel_unnamedtable10_Cls);
         ucDvpanel_unnamedtable10.setProperty("Title", Dvpanel_unnamedtable10_Title);
         ucDvpanel_unnamedtable10.setProperty("Collapsible", Dvpanel_unnamedtable10_Collapsible);
         ucDvpanel_unnamedtable10.setProperty("Collapsed", Dvpanel_unnamedtable10_Collapsed);
         ucDvpanel_unnamedtable10.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable10_Showcollapseicon);
         ucDvpanel_unnamedtable10.setProperty("IconPosition", Dvpanel_unnamedtable10_Iconposition);
         ucDvpanel_unnamedtable10.setProperty("AutoScroll", Dvpanel_unnamedtable10_Autoscroll);
         ucDvpanel_unnamedtable10.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable10_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE10Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE10Container"+"UnnamedTable10"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable10_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAuthresptypeinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAuthresptypeinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAuthresptypeinclude.getInternalname(), GXutil.booltostr( AV14AuthRespTypeInclude), "", " ", 1, chkavAuthresptypeinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeResponseType", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(110, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,110);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthresptypetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthresptypetag_Internalname, httpContext.getMessage( "WWP_GAM_ResponseTypeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthresptypetag_Internalname, GXutil.rtrim( AV15AuthRespTypeTag), GXutil.rtrim( localUtil.format( AV15AuthRespTypeTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,114);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthresptypetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthresptypetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthresptypevalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthresptypevalue_Internalname, httpContext.getMessage( "WWP_GAM_ResponseTypeValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthresptypevalue_Internalname, AV16AuthRespTypeValue, GXutil.rtrim( localUtil.format( AV16AuthRespTypeValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthresptypevalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthresptypevalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAuthscopeinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAuthscopeinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAuthscopeinclude.getInternalname(), GXutil.booltostr( AV17AuthScopeInclude), "", " ", 1, chkavAuthscopeinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeScope", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(123, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,123);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthscopetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthscopetag_Internalname, httpContext.getMessage( "WWP_GAM_ScopeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthscopetag_Internalname, GXutil.rtrim( AV18AuthScopeTag), GXutil.rtrim( localUtil.format( AV18AuthScopeTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,127);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthscopetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthscopetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthscopevalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthscopevalue_Internalname, httpContext.getMessage( "WWP_GAM_ScopeValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthscopevalue_Internalname, AV19AuthScopeValue, GXutil.rtrim( localUtil.format( AV19AuthScopeValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,131);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthscopevalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthscopevalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAuthstateinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAuthstateinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 136,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAuthstateinclude.getInternalname(), GXutil.booltostr( AV98AuthStateInclude), "", " ", 1, chkavAuthstateinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeState", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(136, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,136);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthstatetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthstatetag_Internalname, httpContext.getMessage( "WWP_GAM_StateTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthstatetag_Internalname, GXutil.rtrim( AV21AuthStateTag), GXutil.rtrim( localUtil.format( AV21AuthStateTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,140);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthstatetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthstatetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAuthclientidinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAuthclientidinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 145,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAuthclientidinclude.getInternalname(), GXutil.booltostr( AV7AuthClientIdInclude), "", " ", 1, chkavAuthclientidinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeClientId", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(145, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,145);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAuthclientsecretinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAuthclientsecretinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAuthclientsecretinclude.getInternalname(), GXutil.booltostr( AV8AuthClientSecretInclude), "", " ", 1, chkavAuthclientsecretinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeClientSecret", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(149, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,149);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAuthredirurlinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAuthredirurlinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAuthredirurlinclude.getInternalname(), GXutil.booltostr( AV99AuthRedirURLInclude), "", " ", 1, chkavAuthredirurlinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeRedirectURL", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(153, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,153);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthadditionalparameters_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthadditionalparameters_Internalname, httpContext.getMessage( "WWP_GAM_AdditionalParameters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthadditionalparameters_Internalname, GXutil.rtrim( AV5AuthAdditionalParameters), GXutil.rtrim( localUtil.format( AV5AuthAdditionalParameters, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,158);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthadditionalparameters_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthadditionalparameters_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthadditionalparameterssd_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthadditionalparameterssd_Internalname, httpContext.getMessage( "WWP_GAM_AdditionalParametersforSmartDevices", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 162,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthadditionalparameterssd_Internalname, GXutil.rtrim( AV6AuthAdditionalParametersSD), GXutil.rtrim( localUtil.format( AV6AuthAdditionalParametersSD, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,162);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthadditionalparameterssd_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthadditionalparameterssd_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable11.setProperty("Width", Dvpanel_unnamedtable11_Width);
         ucDvpanel_unnamedtable11.setProperty("AutoWidth", Dvpanel_unnamedtable11_Autowidth);
         ucDvpanel_unnamedtable11.setProperty("AutoHeight", Dvpanel_unnamedtable11_Autoheight);
         ucDvpanel_unnamedtable11.setProperty("Cls", Dvpanel_unnamedtable11_Cls);
         ucDvpanel_unnamedtable11.setProperty("Title", Dvpanel_unnamedtable11_Title);
         ucDvpanel_unnamedtable11.setProperty("Collapsible", Dvpanel_unnamedtable11_Collapsible);
         ucDvpanel_unnamedtable11.setProperty("Collapsed", Dvpanel_unnamedtable11_Collapsed);
         ucDvpanel_unnamedtable11.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable11_Showcollapseicon);
         ucDvpanel_unnamedtable11.setProperty("IconPosition", Dvpanel_unnamedtable11_Iconposition);
         ucDvpanel_unnamedtable11.setProperty("AutoScroll", Dvpanel_unnamedtable11_Autoscroll);
         ucDvpanel_unnamedtable11.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable11_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE11Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE11Container"+"UnnamedTable11"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable11_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthresponseaccesscodetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthresponseaccesscodetag_Internalname, httpContext.getMessage( "WWP_GAM_AccessCodeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 172,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthresponseaccesscodetag_Internalname, GXutil.rtrim( AV12AuthResponseAccessCodeTag), GXutil.rtrim( localUtil.format( AV12AuthResponseAccessCodeTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,172);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthresponseaccesscodetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthresponseaccesscodetag_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthresponseerrordesctag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthresponseerrordesctag_Internalname, httpContext.getMessage( "WWP_GAM_ErrorDescriptionTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthresponseerrordesctag_Internalname, GXutil.rtrim( AV13AuthResponseErrorDescTag), GXutil.rtrim( localUtil.format( AV13AuthResponseErrorDescTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,177);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthresponseerrordesctag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthresponseerrordesctag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblToken_title_Internalname, httpContext.getMessage( "WWP_GAM_Token", ""), "", "", lblToken_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Token") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable5_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenurl_Internalname, httpContext.getMessage( "WWP_GAM_URL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 187,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenurl_Internalname, AV67TokenURL, GXutil.rtrim( localUtil.format( AV67TokenURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,187);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable6.setProperty("Width", Dvpanel_unnamedtable6_Width);
         ucDvpanel_unnamedtable6.setProperty("AutoWidth", Dvpanel_unnamedtable6_Autowidth);
         ucDvpanel_unnamedtable6.setProperty("AutoHeight", Dvpanel_unnamedtable6_Autoheight);
         ucDvpanel_unnamedtable6.setProperty("Cls", Dvpanel_unnamedtable6_Cls);
         ucDvpanel_unnamedtable6.setProperty("Title", Dvpanel_unnamedtable6_Title);
         ucDvpanel_unnamedtable6.setProperty("Collapsible", Dvpanel_unnamedtable6_Collapsible);
         ucDvpanel_unnamedtable6.setProperty("Collapsed", Dvpanel_unnamedtable6_Collapsed);
         ucDvpanel_unnamedtable6.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable6_Showcollapseicon);
         ucDvpanel_unnamedtable6.setProperty("IconPosition", Dvpanel_unnamedtable6_Iconposition);
         ucDvpanel_unnamedtable6.setProperty("AutoScroll", Dvpanel_unnamedtable6_Autoscroll);
         ucDvpanel_unnamedtable6.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable6_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE6Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE6Container"+"UnnamedTable6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable6_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavTokenmethod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavTokenmethod.getInternalname(), httpContext.getMessage( "WWP_GAM_TokenMethod", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 197,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavTokenmethod, cmbavTokenmethod.getInternalname(), GXutil.rtrim( AV57TokenMethod), 1, cmbavTokenmethod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavTokenmethod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,197);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         cmbavTokenmethod.setValue( GXutil.rtrim( AV57TokenMethod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTokenmethod.getInternalname(), "Values", cmbavTokenmethod.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenheaderkeytag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenheaderkeytag_Internalname, httpContext.getMessage( "WWP_GAM_HeaderTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 201,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenheaderkeytag_Internalname, GXutil.rtrim( AV55TokenHeaderKeyTag), GXutil.rtrim( localUtil.format( AV55TokenHeaderKeyTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,201);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenheaderkeytag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenheaderkeytag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenheaderkeyvalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenheaderkeyvalue_Internalname, httpContext.getMessage( "WWP_GAM_HeaderValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 205,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenheaderkeyvalue_Internalname, AV56TokenHeaderKeyValue, GXutil.rtrim( localUtil.format( AV56TokenHeaderKeyValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,205);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenheaderkeyvalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenheaderkeyvalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokenheaderauthenticationinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokenheaderauthenticationinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 210,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokenheaderauthenticationinclude.getInternalname(), GXutil.booltostr( AV51TokenHeaderAuthenticationInclude), "", " ", 1, chkavTokenheaderauthenticationinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_TokenHeaderAuthenticationInclude", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(210, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,210);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavTokenheaderauthenticationmethod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavTokenheaderauthenticationmethod.getInternalname(), httpContext.getMessage( "WWP_GAM_Method", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 214,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavTokenheaderauthenticationmethod, cmbavTokenheaderauthenticationmethod.getInternalname(), GXutil.trim( GXutil.str( AV52TokenHeaderAuthenticationMethod, 4, 0)), 1, cmbavTokenheaderauthenticationmethod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavTokenheaderauthenticationmethod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,214);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         cmbavTokenheaderauthenticationmethod.setValue( GXutil.trim( GXutil.str( AV52TokenHeaderAuthenticationMethod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTokenheaderauthenticationmethod.getInternalname(), "Values", cmbavTokenheaderauthenticationmethod.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenheaderauthenticationrealm_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenheaderauthenticationrealm_Internalname, httpContext.getMessage( "WWP_GAM_Realm", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 218,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenheaderauthenticationrealm_Internalname, GXutil.rtrim( AV53TokenHeaderAuthenticationRealm), GXutil.rtrim( localUtil.format( AV53TokenHeaderAuthenticationRealm, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,218);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenheaderauthenticationrealm_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenheaderauthenticationrealm_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokenheaderauthorizationbasicinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokenheaderauthorizationbasicinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokenheaderauthorizationbasicinclude.getInternalname(), GXutil.booltostr( AV54TokenHeaderAuthorizationBasicInclude), "", " ", 1, chkavTokenheaderauthorizationbasicinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeAuthorizationHeaderBasicValue", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(223, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,223);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokengranttypeinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokengranttypeinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 228,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokengranttypeinclude.getInternalname(), GXutil.booltostr( AV48TokenGrantTypeInclude), "", " ", 1, chkavTokengranttypeinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GrantType", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(228, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,228);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokengranttypetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokengranttypetag_Internalname, httpContext.getMessage( "WWP_GAM_GrantTypeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 232,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokengranttypetag_Internalname, GXutil.rtrim( AV49TokenGrantTypeTag), GXutil.rtrim( localUtil.format( AV49TokenGrantTypeTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,232);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokengranttypetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokengranttypetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokengranttypevalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokengranttypevalue_Internalname, httpContext.getMessage( "WWP_GAM_GrantTypeValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 236,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokengranttypevalue_Internalname, AV50TokenGrantTypeValue, GXutil.rtrim( localUtil.format( AV50TokenGrantTypeValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,236);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokengranttypevalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokengranttypevalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokenaccesscodeinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokenaccesscodeinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokenaccesscodeinclude.getInternalname(), GXutil.booltostr( AV44TokenAccessCodeInclude), "", " ", 1, chkavTokenaccesscodeinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeAccessCode", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(241, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,241);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokencliidinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokencliidinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 245,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokencliidinclude.getInternalname(), GXutil.booltostr( AV46TokenCliIdInclude), "", " ", 1, chkavTokencliidinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeClientId", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(245, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,245);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokenclisecretinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokenclisecretinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 249,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokenclisecretinclude.getInternalname(), GXutil.booltostr( AV47TokenCliSecretInclude), "", " ", 1, chkavTokenclisecretinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeClientSecret", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(249, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,249);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTokenredirecturlinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavTokenredirecturlinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 254,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTokenredirecturlinclude.getInternalname(), GXutil.booltostr( AV58TokenRedirectURLInclude), "", " ", 1, chkavTokenredirecturlinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeRedirectURL", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(254, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,254);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenadditionalparameters_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenadditionalparameters_Internalname, httpContext.getMessage( "WWP_GAM_AdditionalParameters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 258,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenadditionalparameters_Internalname, GXutil.rtrim( AV45TokenAdditionalParameters), GXutil.rtrim( localUtil.format( AV45TokenAdditionalParameters, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,258);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenadditionalparameters_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenadditionalparameters_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponseaccesstokentag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponseaccesstokentag_Internalname, httpContext.getMessage( "WWP_GAM_AccessCodeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 267,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponseaccesstokentag_Internalname, GXutil.rtrim( AV60TokenResponseAccessTokenTag), GXutil.rtrim( localUtil.format( AV60TokenResponseAccessTokenTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,267);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponseaccesstokentag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponseaccesstokentag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponsetokentypetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponsetokentypetag_Internalname, httpContext.getMessage( "WWP_GAM_TokenTypeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 271,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponsetokentypetag_Internalname, GXutil.rtrim( AV65TokenResponseTokenTypeTag), GXutil.rtrim( localUtil.format( AV65TokenResponseTokenTypeTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,271);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponsetokentypetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponsetokentypetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponseexpiresintag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponseexpiresintag_Internalname, httpContext.getMessage( "WWP_GAM_ExpiresinTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 276,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponseexpiresintag_Internalname, GXutil.rtrim( AV62TokenResponseExpiresInTag), GXutil.rtrim( localUtil.format( AV62TokenResponseExpiresInTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,276);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponseexpiresintag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponseexpiresintag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponsescopetag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponsescopetag_Internalname, httpContext.getMessage( "WWP_GAM_ScopeTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 280,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponsescopetag_Internalname, GXutil.rtrim( AV64TokenResponseScopeTag), GXutil.rtrim( localUtil.format( AV64TokenResponseScopeTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,280);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponsescopetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponsescopetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponseuseridtag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponseuseridtag_Internalname, httpContext.getMessage( "WWP_GAM_UserIdTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 285,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponseuseridtag_Internalname, GXutil.rtrim( AV66TokenResponseUserIdTag), GXutil.rtrim( localUtil.format( AV66TokenResponseUserIdTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,285);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponseuseridtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponseuseridtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponserefreshtokentag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponserefreshtokentag_Internalname, httpContext.getMessage( "WWP_GAM_RefreshTokenTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 289,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponserefreshtokentag_Internalname, GXutil.rtrim( AV63TokenResponseRefreshTokenTag), GXutil.rtrim( localUtil.format( AV63TokenResponseRefreshTokenTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,289);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponserefreshtokentag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponserefreshtokentag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenresponseerrordescriptiontag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenresponseerrordescriptiontag_Internalname, httpContext.getMessage( "WWP_GAM_ErrorDescriptionTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 294,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenresponseerrordescriptiontag_Internalname, GXutil.rtrim( AV61TokenResponseErrorDescriptionTag), GXutil.rtrim( localUtil.format( AV61TokenResponseErrorDescriptionTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,294);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenresponseerrordescriptiontag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenresponseerrordescriptiontag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAutovalidateexternaltokenandrefresh.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAutovalidateexternaltokenandrefresh.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 304,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAutovalidateexternaltokenandrefresh.getInternalname(), GXutil.booltostr( AV22AutovalidateExternalTokenAndRefresh), "", " ", 1, chkavAutovalidateexternaltokenandrefresh.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_ValidateExternalToken", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(304, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,304);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTokenrefreshtokenurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTokenrefreshtokenurl_Internalname, httpContext.getMessage( "WWP_GAM_RefreshTokenURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 308,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTokenrefreshtokenurl_Internalname, AV59TokenRefreshTokenURL, GXutil.rtrim( localUtil.format( AV59TokenRefreshTokenURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,308);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTokenrefreshtokenurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTokenrefreshtokenurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblUserinfo_title_Internalname, httpContext.getMessage( "WWP_GAM_UserInformation", ""), "", "", lblUserinfo_title_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "UserInfo") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"GXUITABSPANEL_TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfourl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfourl_Internalname, httpContext.getMessage( "WWP_GAM_URL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 318,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfourl_Internalname, AV94UserInfoURL, GXutil.rtrim( localUtil.format( AV94UserInfoURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,318);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfourl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfourl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavUserinfomethod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavUserinfomethod.getInternalname(), httpContext.getMessage( "WWP_GAM_UserInfoMethod", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 328,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavUserinfomethod, cmbavUserinfomethod.getInternalname(), GXutil.rtrim( AV78UserInfoMethod), 1, cmbavUserinfomethod.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavUserinfomethod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,328);\"", "", true, (byte)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         cmbavUserinfomethod.setValue( GXutil.rtrim( AV78UserInfoMethod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavUserinfomethod.getInternalname(), "Values", cmbavUserinfomethod.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfoheaderkeytag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfoheaderkeytag_Internalname, httpContext.getMessage( "WWP_GAM_HeaderTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 333,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfoheaderkeytag_Internalname, GXutil.rtrim( AV76UserInfoHeaderKeyTag), GXutil.rtrim( localUtil.format( AV76UserInfoHeaderKeyTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,333);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfoheaderkeytag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfoheaderkeytag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfoheaderkeyvalue_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfoheaderkeyvalue_Internalname, httpContext.getMessage( "WWP_GAM_HeaderValue", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 337,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfoheaderkeyvalue_Internalname, AV77UserInfoHeaderKeyValue, GXutil.rtrim( localUtil.format( AV77UserInfoHeaderKeyValue, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,337);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfoheaderkeyvalue_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfoheaderkeyvalue_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUserinfoaccesstokeninclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUserinfoaccesstokeninclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 342,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUserinfoaccesstokeninclude.getInternalname(), GXutil.booltostr( AV69UserInfoAccessTokenInclude), "", " ", 1, chkavUserinfoaccesstokeninclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeAccessToken", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(342, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,342);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfoaccesstokenname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfoaccesstokenname_Internalname, httpContext.getMessage( "WWP_GAM_AccessTokenTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 346,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfoaccesstokenname_Internalname, GXutil.rtrim( AV70UserInfoAccessTokenName), GXutil.rtrim( localUtil.format( AV70UserInfoAccessTokenName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,346);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfoaccesstokenname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfoaccesstokenname_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUserinfoclientidinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUserinfoclientidinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 351,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUserinfoclientidinclude.getInternalname(), GXutil.booltostr( AV72UserInfoClientIdInclude), "", " ", 1, chkavUserinfoclientidinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeClientId", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(351, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,351);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfoclientidname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfoclientidname_Internalname, httpContext.getMessage( "WWP_GAM_ClientIdTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 355,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfoclientidname_Internalname, GXutil.rtrim( AV73UserInfoClientIdName), GXutil.rtrim( localUtil.format( AV73UserInfoClientIdName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,355);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfoclientidname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfoclientidname_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUserinfoclientsecretinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUserinfoclientsecretinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 360,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUserinfoclientsecretinclude.getInternalname(), GXutil.booltostr( AV74UserInfoClientSecretInclude), "", " ", 1, chkavUserinfoclientsecretinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeClientSecret", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(360, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,360);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfoclientsecretname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfoclientsecretname_Internalname, httpContext.getMessage( "WWP_GAM_ClientSecretTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 364,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfoclientsecretname_Internalname, GXutil.rtrim( AV75UserInfoClientSecretName), GXutil.rtrim( localUtil.format( AV75UserInfoClientSecretName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,364);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfoclientsecretname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfoclientsecretname_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUserinfouseridinclude.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUserinfouseridinclude.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 369,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUserinfouseridinclude.getInternalname(), GXutil.booltostr( AV95UserInfoUserIdInclude), "", " ", 1, chkavUserinfouseridinclude.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IncludeUserId", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(369, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,369);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinfoadditionalparameters_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinfoadditionalparameters_Internalname, httpContext.getMessage( "WWP_GAM_AdditionalParameters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 373,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinfoadditionalparameters_Internalname, GXutil.rtrim( AV71UserInfoAdditionalParameters), GXutil.rtrim( localUtil.format( AV71UserInfoAdditionalParameters, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,373);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinfoadditionalparameters_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinfoadditionalparameters_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable3.setProperty("Width", Dvpanel_unnamedtable3_Width);
         ucDvpanel_unnamedtable3.setProperty("AutoWidth", Dvpanel_unnamedtable3_Autowidth);
         ucDvpanel_unnamedtable3.setProperty("AutoHeight", Dvpanel_unnamedtable3_Autoheight);
         ucDvpanel_unnamedtable3.setProperty("Cls", Dvpanel_unnamedtable3_Cls);
         ucDvpanel_unnamedtable3.setProperty("Title", Dvpanel_unnamedtable3_Title);
         ucDvpanel_unnamedtable3.setProperty("Collapsible", Dvpanel_unnamedtable3_Collapsible);
         ucDvpanel_unnamedtable3.setProperty("Collapsed", Dvpanel_unnamedtable3_Collapsed);
         ucDvpanel_unnamedtable3.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable3_Showcollapseicon);
         ucDvpanel_unnamedtable3.setProperty("IconPosition", Dvpanel_unnamedtable3_Iconposition);
         ucDvpanel_unnamedtable3.setProperty("AutoScroll", Dvpanel_unnamedtable3_Autoscroll);
         ucDvpanel_unnamedtable3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable3_Internalname, sPrefix+"DVPANEL_UNNAMEDTABLE3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_UNNAMEDTABLE3Container"+"UnnamedTable3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 383,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuseremailtag_Internalname, GXutil.rtrim( AV81UserInfoResponseUserEmailTag), GXutil.rtrim( localUtil.format( AV81UserInfoResponseUserEmailTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,383);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuseremailtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuseremailtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserverifiedemailtag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserverifiedemailtag_Internalname, httpContext.getMessage( "WWP_GAM_UserVerifiedEmailTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 387,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserverifiedemailtag_Internalname, GXutil.rtrim( AV93UserInfoResponseUserVerifiedEmailTag), GXutil.rtrim( localUtil.format( AV93UserInfoResponseUserVerifiedEmailTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,387);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserverifiedemailtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserverifiedemailtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserexternalidtag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserexternalidtag_Internalname, httpContext.getMessage( "WWP_GAM_ExternalIdTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 392,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserexternalidtag_Internalname, GXutil.rtrim( AV82UserInfoResponseUserExternalIdTag), GXutil.rtrim( localUtil.format( AV82UserInfoResponseUserExternalIdTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,392);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserexternalidtag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserexternalidtag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseusernametag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseusernametag_Internalname, httpContext.getMessage( "WWP_GAM_UserNameTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 396,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusernametag_Internalname, GXutil.rtrim( AV89UserInfoResponseUserNameTag), GXutil.rtrim( localUtil.format( AV89UserInfoResponseUserNameTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,396);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusernametag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusernametag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseuserfirstnametag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserfirstnametag_Internalname, httpContext.getMessage( "WWP_GAM_UserFirstNameTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 401,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserfirstnametag_Internalname, GXutil.rtrim( AV83UserInfoResponseUserFirstNameTag), GXutil.rtrim( localUtil.format( AV83UserInfoResponseUserFirstNameTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,401);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserfirstnametag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserfirstnametag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 406,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUserinforesponseuserlastnamegenauto.getInternalname(), GXutil.booltostr( AV87UserInfoResponseUserLastNameGenAuto), "", " ", 1, chkavUserinforesponseuserlastnamegenauto.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GenerateautomaticLastName", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,406);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplitteduserinforesponseuserlastnametag_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTextblockuserinforesponseuserlastnametag_cell_Internalname, 1, 0, "px", 0, "px", divTextblockuserinforesponseuserlastnametag_cell_Class, "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockuserinforesponseuserlastnametag_Internalname, httpContext.getMessage( "WWP_GAM_UserLastNameTag", ""), "", "", lblTextblockuserinforesponseuserlastnametag_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_413_2W2( true) ;
      }
      else
      {
         wb_table1_413_2W2( false) ;
      }
      return  ;
   }

   public void wb_table1_413_2W2e( boolean wbgen )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserinforesponseusergendertag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseusergendertag_Internalname, httpContext.getMessage( "WWP_GAM_UserGenderTag", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 424,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusergendertag_Internalname, GXutil.rtrim( AV84UserInfoResponseUserGenderTag), GXutil.rtrim( localUtil.format( AV84UserInfoResponseUserGenderTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,424);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusergendertag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusergendertag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 428,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusergendervalues_Internalname, AV85UserInfoResponseUserGenderValues, GXutil.rtrim( localUtil.format( AV85UserInfoResponseUserGenderValues, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,428);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusergendervalues_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusergendervalues_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 433,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserbirthdaytag_Internalname, GXutil.rtrim( AV80UserInfoResponseUserBirthdayTag), GXutil.rtrim( localUtil.format( AV80UserInfoResponseUserBirthdayTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,433);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserbirthdaytag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserbirthdaytag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 437,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserurlimagetag_Internalname, GXutil.rtrim( AV91UserInfoResponseUserURLImageTag), GXutil.rtrim( localUtil.format( AV91UserInfoResponseUserURLImageTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,437);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserurlimagetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserurlimagetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 442,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserurlprofiletag_Internalname, GXutil.rtrim( AV92UserInfoResponseUserURLProfileTag), GXutil.rtrim( localUtil.format( AV92UserInfoResponseUserURLProfileTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,442);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserurlprofiletag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserurlprofiletag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 446,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserlanguagetag_Internalname, GXutil.rtrim( AV86UserInfoResponseUserLanguageTag), GXutil.rtrim( localUtil.format( AV86UserInfoResponseUserLanguageTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,446);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserlanguagetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseuserlanguagetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 451,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseusertimezonetag_Internalname, GXutil.rtrim( AV90UserInfoResponseUserTimeZoneTag), GXutil.rtrim( localUtil.format( AV90UserInfoResponseUserTimeZoneTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,451);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseusertimezonetag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseusertimezonetag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 455,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseerrordescriptiontag_Internalname, GXutil.rtrim( AV79UserInfoResponseErrorDescriptionTag), GXutil.rtrim( localUtil.format( AV79UserInfoResponseErrorDescriptionTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,455);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseerrordescriptiontag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserinforesponseerrordescriptiontag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell CellMarginTop HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol462( ) ;
      }
      if ( wbEnd == 462 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_462 = (int)(nGXsfl_462_idx-1) ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 468,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAddNewRow" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnadd_Internalname, "gx.evt.setGridEvt("+GXutil.str( 462, 3, 0)+","+"null"+");", httpContext.getMessage( "GXM_insert", ""), bttBtnadd_Jsonclick, 5, httpContext.getMessage( "GXM_insert", ""), "", StyleString, ClassString, bttBtnadd_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOADD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 473,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 462, 3, 0)+","+"null"+");", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 475,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 462, 3, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
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
      if ( wbEnd == 462 )
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

   public void start2W2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Authentication Type Entry Oauth20", ""), (short)(0)) ;
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
            strup2W0( ) ;
         }
      }
   }

   public void ws2W2( )
   {
      start2W2( ) ;
      evt2W2( ) ;
   }

   public void evt2W2( )
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
                              strup2W0( ) ;
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
                              strup2W0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoAdd' */
                                 e112W2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2W0( ) ;
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
                                       e122W2 ();
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
                              strup2W0( ) ;
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
                              strup2W0( ) ;
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VDELETEPROPERTY.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VDELETEPROPERTY.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2W0( ) ;
                           }
                           nGXsfl_462_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_462_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_462_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_4622( ) ;
                           AV26DynamicPropName = httpContext.cgiGet( edtavDynamicpropname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicpropname_Internalname, AV26DynamicPropName);
                           AV27DynamicPropTag = httpContext.cgiGet( edtavDynamicproptag_Internalname) ;
                           httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicproptag_Internalname, AV27DynamicPropTag);
                           AV24DeleteProperty = httpContext.cgiGet( edtavDeleteproperty_Internalname) ;
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV24DeleteProperty)==0) ? AV110Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24DeleteProperty))), !bGXsfl_462_Refreshing);
                           httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24DeleteProperty), true);
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
                                       e132W2 ();
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
                                       e142W2 ();
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
                                       e152W2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup2W0( ) ;
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

   public void we2W2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2W2( ) ;
         }
      }
   }

   public void pa2W2( )
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
      subsflControlProps_4622( ) ;
      while ( nGXsfl_462_idx <= nRC_GXsfl_462 )
      {
         sendrow_4622( ) ;
         nGXsfl_462_idx = ((subGrid_Islastpage==1)&&(nGXsfl_462_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_462_idx+1) ;
         sGXsfl_462_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_462_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4622( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String Gx_mode ,
                                 boolean AV33IsEnable ,
                                 boolean AV40Oauth20RedirectURLisCustom ,
                                 boolean AV39Oauth20RedirectToAuthenticate ,
                                 boolean AV14AuthRespTypeInclude ,
                                 boolean AV17AuthScopeInclude ,
                                 boolean AV98AuthStateInclude ,
                                 boolean AV7AuthClientIdInclude ,
                                 boolean AV8AuthClientSecretInclude ,
                                 boolean AV99AuthRedirURLInclude ,
                                 boolean AV51TokenHeaderAuthenticationInclude ,
                                 boolean AV54TokenHeaderAuthorizationBasicInclude ,
                                 boolean AV48TokenGrantTypeInclude ,
                                 boolean AV44TokenAccessCodeInclude ,
                                 boolean AV46TokenCliIdInclude ,
                                 boolean AV47TokenCliSecretInclude ,
                                 boolean AV58TokenRedirectURLInclude ,
                                 boolean AV22AutovalidateExternalTokenAndRefresh ,
                                 boolean AV69UserInfoAccessTokenInclude ,
                                 boolean AV72UserInfoClientIdInclude ,
                                 boolean AV74UserInfoClientSecretInclude ,
                                 boolean AV95UserInfoUserIdInclude ,
                                 boolean AV87UserInfoResponseUserLastNameGenAuto ,
                                 String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID_nCurrentRecord = 0 ;
      rf2W2( ) ;
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
         AV30FunctionId = cmbavFunctionid.getValidValue(AV30FunctionId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30FunctionId", AV30FunctionId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFunctionid.setValue( GXutil.rtrim( AV30FunctionId) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Values", cmbavFunctionid.ToJavascriptSource(), true);
      }
      AV33IsEnable = GXutil.strtobool( GXutil.booltostr( AV33IsEnable)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33IsEnable", AV33IsEnable);
      AV40Oauth20RedirectURLisCustom = GXutil.strtobool( GXutil.booltostr( AV40Oauth20RedirectURLisCustom)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40Oauth20RedirectURLisCustom", AV40Oauth20RedirectURLisCustom);
      AV39Oauth20RedirectToAuthenticate = GXutil.strtobool( GXutil.booltostr( AV39Oauth20RedirectToAuthenticate)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Oauth20RedirectToAuthenticate", AV39Oauth20RedirectToAuthenticate);
      AV14AuthRespTypeInclude = GXutil.strtobool( GXutil.booltostr( AV14AuthRespTypeInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14AuthRespTypeInclude", AV14AuthRespTypeInclude);
      AV17AuthScopeInclude = GXutil.strtobool( GXutil.booltostr( AV17AuthScopeInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17AuthScopeInclude", AV17AuthScopeInclude);
      AV98AuthStateInclude = GXutil.strtobool( GXutil.booltostr( AV98AuthStateInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV98AuthStateInclude", AV98AuthStateInclude);
      AV7AuthClientIdInclude = GXutil.strtobool( GXutil.booltostr( AV7AuthClientIdInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AuthClientIdInclude", AV7AuthClientIdInclude);
      AV8AuthClientSecretInclude = GXutil.strtobool( GXutil.booltostr( AV8AuthClientSecretInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AuthClientSecretInclude", AV8AuthClientSecretInclude);
      AV99AuthRedirURLInclude = GXutil.strtobool( GXutil.booltostr( AV99AuthRedirURLInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV99AuthRedirURLInclude", AV99AuthRedirURLInclude);
      if ( cmbavTokenmethod.getItemCount() > 0 )
      {
         AV57TokenMethod = cmbavTokenmethod.getValidValue(AV57TokenMethod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TokenMethod", AV57TokenMethod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavTokenmethod.setValue( GXutil.rtrim( AV57TokenMethod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTokenmethod.getInternalname(), "Values", cmbavTokenmethod.ToJavascriptSource(), true);
      }
      AV51TokenHeaderAuthenticationInclude = GXutil.strtobool( GXutil.booltostr( AV51TokenHeaderAuthenticationInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TokenHeaderAuthenticationInclude", AV51TokenHeaderAuthenticationInclude);
      if ( cmbavTokenheaderauthenticationmethod.getItemCount() > 0 )
      {
         AV52TokenHeaderAuthenticationMethod = (short)(GXutil.lval( cmbavTokenheaderauthenticationmethod.getValidValue(GXutil.trim( GXutil.str( AV52TokenHeaderAuthenticationMethod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TokenHeaderAuthenticationMethod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TokenHeaderAuthenticationMethod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavTokenheaderauthenticationmethod.setValue( GXutil.trim( GXutil.str( AV52TokenHeaderAuthenticationMethod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTokenheaderauthenticationmethod.getInternalname(), "Values", cmbavTokenheaderauthenticationmethod.ToJavascriptSource(), true);
      }
      AV54TokenHeaderAuthorizationBasicInclude = GXutil.strtobool( GXutil.booltostr( AV54TokenHeaderAuthorizationBasicInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TokenHeaderAuthorizationBasicInclude", AV54TokenHeaderAuthorizationBasicInclude);
      AV48TokenGrantTypeInclude = GXutil.strtobool( GXutil.booltostr( AV48TokenGrantTypeInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TokenGrantTypeInclude", AV48TokenGrantTypeInclude);
      AV44TokenAccessCodeInclude = GXutil.strtobool( GXutil.booltostr( AV44TokenAccessCodeInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TokenAccessCodeInclude", AV44TokenAccessCodeInclude);
      AV46TokenCliIdInclude = GXutil.strtobool( GXutil.booltostr( AV46TokenCliIdInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TokenCliIdInclude", AV46TokenCliIdInclude);
      AV47TokenCliSecretInclude = GXutil.strtobool( GXutil.booltostr( AV47TokenCliSecretInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TokenCliSecretInclude", AV47TokenCliSecretInclude);
      AV58TokenRedirectURLInclude = GXutil.strtobool( GXutil.booltostr( AV58TokenRedirectURLInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TokenRedirectURLInclude", AV58TokenRedirectURLInclude);
      AV22AutovalidateExternalTokenAndRefresh = GXutil.strtobool( GXutil.booltostr( AV22AutovalidateExternalTokenAndRefresh)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22AutovalidateExternalTokenAndRefresh", AV22AutovalidateExternalTokenAndRefresh);
      if ( cmbavUserinfomethod.getItemCount() > 0 )
      {
         AV78UserInfoMethod = cmbavUserinfomethod.getValidValue(AV78UserInfoMethod) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78UserInfoMethod", AV78UserInfoMethod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavUserinfomethod.setValue( GXutil.rtrim( AV78UserInfoMethod) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavUserinfomethod.getInternalname(), "Values", cmbavUserinfomethod.ToJavascriptSource(), true);
      }
      AV69UserInfoAccessTokenInclude = GXutil.strtobool( GXutil.booltostr( AV69UserInfoAccessTokenInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69UserInfoAccessTokenInclude", AV69UserInfoAccessTokenInclude);
      AV72UserInfoClientIdInclude = GXutil.strtobool( GXutil.booltostr( AV72UserInfoClientIdInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72UserInfoClientIdInclude", AV72UserInfoClientIdInclude);
      AV74UserInfoClientSecretInclude = GXutil.strtobool( GXutil.booltostr( AV74UserInfoClientSecretInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74UserInfoClientSecretInclude", AV74UserInfoClientSecretInclude);
      AV95UserInfoUserIdInclude = GXutil.strtobool( GXutil.booltostr( AV95UserInfoUserIdInclude)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV95UserInfoUserIdInclude", AV95UserInfoUserIdInclude);
      AV87UserInfoResponseUserLastNameGenAuto = GXutil.strtobool( GXutil.booltostr( AV87UserInfoResponseUserLastNameGenAuto)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV87UserInfoResponseUserLastNameGenAuto", AV87UserInfoResponseUserLastNameGenAuto);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2W2( ) ;
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

   public void rf2W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(462) ;
      nGXsfl_462_idx = 1 ;
      sGXsfl_462_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_462_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4622( ) ;
      bGXsfl_462_Refreshing = true ;
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
         subsflControlProps_4622( ) ;
         e142W2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_462_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e142W2 ();
         }
         wbEnd = (short)(462) ;
         wb2W0( ) ;
      }
      bGXsfl_462_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2W2( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV33IsEnable, AV40Oauth20RedirectURLisCustom, AV39Oauth20RedirectToAuthenticate, AV14AuthRespTypeInclude, AV17AuthScopeInclude, AV98AuthStateInclude, AV7AuthClientIdInclude, AV8AuthClientSecretInclude, AV99AuthRedirURLInclude, AV51TokenHeaderAuthenticationInclude, AV54TokenHeaderAuthorizationBasicInclude, AV48TokenGrantTypeInclude, AV44TokenAccessCodeInclude, AV46TokenCliIdInclude, AV47TokenCliSecretInclude, AV58TokenRedirectURLInclude, AV22AutovalidateExternalTokenAndRefresh, AV69UserInfoAccessTokenInclude, AV72UserInfoClientIdInclude, AV74UserInfoClientSecretInclude, AV95UserInfoUserIdInclude, AV87UserInfoResponseUserLastNameGenAuto, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV33IsEnable, AV40Oauth20RedirectURLisCustom, AV39Oauth20RedirectToAuthenticate, AV14AuthRespTypeInclude, AV17AuthScopeInclude, AV98AuthStateInclude, AV7AuthClientIdInclude, AV8AuthClientSecretInclude, AV99AuthRedirURLInclude, AV51TokenHeaderAuthenticationInclude, AV54TokenHeaderAuthorizationBasicInclude, AV48TokenGrantTypeInclude, AV44TokenAccessCodeInclude, AV46TokenCliIdInclude, AV47TokenCliSecretInclude, AV58TokenRedirectURLInclude, AV22AutovalidateExternalTokenAndRefresh, AV69UserInfoAccessTokenInclude, AV72UserInfoClientIdInclude, AV74UserInfoClientSecretInclude, AV95UserInfoUserIdInclude, AV87UserInfoResponseUserLastNameGenAuto, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV33IsEnable, AV40Oauth20RedirectURLisCustom, AV39Oauth20RedirectToAuthenticate, AV14AuthRespTypeInclude, AV17AuthScopeInclude, AV98AuthStateInclude, AV7AuthClientIdInclude, AV8AuthClientSecretInclude, AV99AuthRedirURLInclude, AV51TokenHeaderAuthenticationInclude, AV54TokenHeaderAuthorizationBasicInclude, AV48TokenGrantTypeInclude, AV44TokenAccessCodeInclude, AV46TokenCliIdInclude, AV47TokenCliSecretInclude, AV58TokenRedirectURLInclude, AV22AutovalidateExternalTokenAndRefresh, AV69UserInfoAccessTokenInclude, AV72UserInfoClientIdInclude, AV74UserInfoClientSecretInclude, AV95UserInfoUserIdInclude, AV87UserInfoResponseUserLastNameGenAuto, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV33IsEnable, AV40Oauth20RedirectURLisCustom, AV39Oauth20RedirectToAuthenticate, AV14AuthRespTypeInclude, AV17AuthScopeInclude, AV98AuthStateInclude, AV7AuthClientIdInclude, AV8AuthClientSecretInclude, AV99AuthRedirURLInclude, AV51TokenHeaderAuthenticationInclude, AV54TokenHeaderAuthorizationBasicInclude, AV48TokenGrantTypeInclude, AV44TokenAccessCodeInclude, AV46TokenCliIdInclude, AV47TokenCliSecretInclude, AV58TokenRedirectURLInclude, AV22AutovalidateExternalTokenAndRefresh, AV69UserInfoAccessTokenInclude, AV72UserInfoClientIdInclude, AV74UserInfoClientSecretInclude, AV95UserInfoUserIdInclude, AV87UserInfoResponseUserLastNameGenAuto, sPrefix) ;
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
         gxgrgrid_refresh( subGrid_Rows, Gx_mode, AV33IsEnable, AV40Oauth20RedirectURLisCustom, AV39Oauth20RedirectToAuthenticate, AV14AuthRespTypeInclude, AV17AuthScopeInclude, AV98AuthStateInclude, AV7AuthClientIdInclude, AV8AuthClientSecretInclude, AV99AuthRedirURLInclude, AV51TokenHeaderAuthenticationInclude, AV54TokenHeaderAuthorizationBasicInclude, AV48TokenGrantTypeInclude, AV44TokenAccessCodeInclude, AV46TokenCliIdInclude, AV47TokenCliSecretInclude, AV58TokenRedirectURLInclude, AV22AutovalidateExternalTokenAndRefresh, AV69UserInfoAccessTokenInclude, AV72UserInfoClientIdInclude, AV74UserInfoClientSecretInclude, AV95UserInfoUserIdInclude, AV87UserInfoResponseUserLastNameGenAuto, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e132W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_462 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_462"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
         wcpOAV34Name = httpContext.cgiGet( sPrefix+"wcpOAV34Name") ;
         wcpOAV68TypeId = httpContext.cgiGet( sPrefix+"wcpOAV68TypeId") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_unnamedtable11_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Width") ;
         Dvpanel_unnamedtable11_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Autowidth")) ;
         Dvpanel_unnamedtable11_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Autoheight")) ;
         Dvpanel_unnamedtable11_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Cls") ;
         Dvpanel_unnamedtable11_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Title") ;
         Dvpanel_unnamedtable11_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Collapsible")) ;
         Dvpanel_unnamedtable11_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Collapsed")) ;
         Dvpanel_unnamedtable11_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Showcollapseicon")) ;
         Dvpanel_unnamedtable11_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Iconposition") ;
         Dvpanel_unnamedtable11_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE11_Autoscroll")) ;
         Dvpanel_unnamedtable10_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Width") ;
         Dvpanel_unnamedtable10_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Autowidth")) ;
         Dvpanel_unnamedtable10_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Autoheight")) ;
         Dvpanel_unnamedtable10_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Cls") ;
         Dvpanel_unnamedtable10_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Title") ;
         Dvpanel_unnamedtable10_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Collapsible")) ;
         Dvpanel_unnamedtable10_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Collapsed")) ;
         Dvpanel_unnamedtable10_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Showcollapseicon")) ;
         Dvpanel_unnamedtable10_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Iconposition") ;
         Dvpanel_unnamedtable10_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE10_Autoscroll")) ;
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
         Dvpanel_unnamedtable6_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Width") ;
         Dvpanel_unnamedtable6_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Autowidth")) ;
         Dvpanel_unnamedtable6_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Autoheight")) ;
         Dvpanel_unnamedtable6_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Cls") ;
         Dvpanel_unnamedtable6_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Title") ;
         Dvpanel_unnamedtable6_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Collapsible")) ;
         Dvpanel_unnamedtable6_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Collapsed")) ;
         Dvpanel_unnamedtable6_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Showcollapseicon")) ;
         Dvpanel_unnamedtable6_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Iconposition") ;
         Dvpanel_unnamedtable6_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE6_Autoscroll")) ;
         Dvpanel_unnamedtable3_Width = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Width") ;
         Dvpanel_unnamedtable3_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Autowidth")) ;
         Dvpanel_unnamedtable3_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoheight")) ;
         Dvpanel_unnamedtable3_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Cls") ;
         Dvpanel_unnamedtable3_Title = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Title") ;
         Dvpanel_unnamedtable3_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsible")) ;
         Dvpanel_unnamedtable3_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Collapsed")) ;
         Dvpanel_unnamedtable3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Showcollapseicon")) ;
         Dvpanel_unnamedtable3_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Iconposition") ;
         Dvpanel_unnamedtable3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_UNNAMEDTABLE3_Autoscroll")) ;
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
            AV34Name = httpContext.cgiGet( edtavName_Internalname) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Name", AV34Name);
         }
         cmbavFunctionid.setName( cmbavFunctionid.getInternalname() );
         cmbavFunctionid.setValue( httpContext.cgiGet( cmbavFunctionid.getInternalname()) );
         AV30FunctionId = httpContext.cgiGet( cmbavFunctionid.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30FunctionId", AV30FunctionId);
         AV25Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25Dsc", AV25Dsc);
         AV33IsEnable = GXutil.strtobool( httpContext.cgiGet( chkavIsenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33IsEnable", AV33IsEnable);
         AV32Impersonate = httpContext.cgiGet( edtavImpersonate_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Impersonate", AV32Impersonate);
         AV43SmallImageName = httpContext.cgiGet( edtavSmallimagename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43SmallImageName", AV43SmallImageName);
         AV23BigImageName = httpContext.cgiGet( edtavBigimagename_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23BigImageName", AV23BigImageName);
         AV35Oauth20ClientIdTag = httpContext.cgiGet( edtavOauth20clientidtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35Oauth20ClientIdTag", AV35Oauth20ClientIdTag);
         AV36Oauth20ClientIdValue = httpContext.cgiGet( edtavOauth20clientidvalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36Oauth20ClientIdValue", AV36Oauth20ClientIdValue);
         AV37Oauth20ClientSecretTag = httpContext.cgiGet( edtavOauth20clientsecrettag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37Oauth20ClientSecretTag", AV37Oauth20ClientSecretTag);
         AV38Oauth20ClientSecretValue = httpContext.cgiGet( edtavOauth20clientsecretvalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38Oauth20ClientSecretValue", AV38Oauth20ClientSecretValue);
         AV41Oauth20RedirectURLTag = httpContext.cgiGet( edtavOauth20redirecturltag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41Oauth20RedirectURLTag", AV41Oauth20RedirectURLTag);
         AV42Oauth20RedirectURLvalue = httpContext.cgiGet( edtavOauth20redirecturlvalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42Oauth20RedirectURLvalue", AV42Oauth20RedirectURLvalue);
         AV40Oauth20RedirectURLisCustom = GXutil.strtobool( httpContext.cgiGet( chkavOauth20redirecturliscustom.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40Oauth20RedirectURLisCustom", AV40Oauth20RedirectURLisCustom);
         AV39Oauth20RedirectToAuthenticate = GXutil.strtobool( httpContext.cgiGet( chkavOauth20redirecttoauthenticate.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Oauth20RedirectToAuthenticate", AV39Oauth20RedirectToAuthenticate);
         AV10AuthorizeURL = httpContext.cgiGet( edtavAuthorizeurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10AuthorizeURL", AV10AuthorizeURL);
         AV14AuthRespTypeInclude = GXutil.strtobool( httpContext.cgiGet( chkavAuthresptypeinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14AuthRespTypeInclude", AV14AuthRespTypeInclude);
         AV15AuthRespTypeTag = httpContext.cgiGet( edtavAuthresptypetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15AuthRespTypeTag", AV15AuthRespTypeTag);
         AV16AuthRespTypeValue = httpContext.cgiGet( edtavAuthresptypevalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AuthRespTypeValue", AV16AuthRespTypeValue);
         AV17AuthScopeInclude = GXutil.strtobool( httpContext.cgiGet( chkavAuthscopeinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17AuthScopeInclude", AV17AuthScopeInclude);
         AV18AuthScopeTag = httpContext.cgiGet( edtavAuthscopetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18AuthScopeTag", AV18AuthScopeTag);
         AV19AuthScopeValue = httpContext.cgiGet( edtavAuthscopevalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19AuthScopeValue", AV19AuthScopeValue);
         AV98AuthStateInclude = GXutil.strtobool( httpContext.cgiGet( chkavAuthstateinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV98AuthStateInclude", AV98AuthStateInclude);
         AV21AuthStateTag = httpContext.cgiGet( edtavAuthstatetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AuthStateTag", AV21AuthStateTag);
         AV7AuthClientIdInclude = GXutil.strtobool( httpContext.cgiGet( chkavAuthclientidinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AuthClientIdInclude", AV7AuthClientIdInclude);
         AV8AuthClientSecretInclude = GXutil.strtobool( httpContext.cgiGet( chkavAuthclientsecretinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AuthClientSecretInclude", AV8AuthClientSecretInclude);
         AV99AuthRedirURLInclude = GXutil.strtobool( httpContext.cgiGet( chkavAuthredirurlinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV99AuthRedirURLInclude", AV99AuthRedirURLInclude);
         AV5AuthAdditionalParameters = httpContext.cgiGet( edtavAuthadditionalparameters_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5AuthAdditionalParameters", AV5AuthAdditionalParameters);
         AV6AuthAdditionalParametersSD = httpContext.cgiGet( edtavAuthadditionalparameterssd_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AuthAdditionalParametersSD", AV6AuthAdditionalParametersSD);
         AV12AuthResponseAccessCodeTag = httpContext.cgiGet( edtavAuthresponseaccesscodetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12AuthResponseAccessCodeTag", AV12AuthResponseAccessCodeTag);
         AV13AuthResponseErrorDescTag = httpContext.cgiGet( edtavAuthresponseerrordesctag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13AuthResponseErrorDescTag", AV13AuthResponseErrorDescTag);
         AV67TokenURL = httpContext.cgiGet( edtavTokenurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TokenURL", AV67TokenURL);
         cmbavTokenmethod.setName( cmbavTokenmethod.getInternalname() );
         cmbavTokenmethod.setValue( httpContext.cgiGet( cmbavTokenmethod.getInternalname()) );
         AV57TokenMethod = httpContext.cgiGet( cmbavTokenmethod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TokenMethod", AV57TokenMethod);
         AV55TokenHeaderKeyTag = httpContext.cgiGet( edtavTokenheaderkeytag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TokenHeaderKeyTag", AV55TokenHeaderKeyTag);
         AV56TokenHeaderKeyValue = httpContext.cgiGet( edtavTokenheaderkeyvalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TokenHeaderKeyValue", AV56TokenHeaderKeyValue);
         AV51TokenHeaderAuthenticationInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokenheaderauthenticationinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TokenHeaderAuthenticationInclude", AV51TokenHeaderAuthenticationInclude);
         cmbavTokenheaderauthenticationmethod.setName( cmbavTokenheaderauthenticationmethod.getInternalname() );
         cmbavTokenheaderauthenticationmethod.setValue( httpContext.cgiGet( cmbavTokenheaderauthenticationmethod.getInternalname()) );
         AV52TokenHeaderAuthenticationMethod = (short)(GXutil.lval( httpContext.cgiGet( cmbavTokenheaderauthenticationmethod.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TokenHeaderAuthenticationMethod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TokenHeaderAuthenticationMethod), 4, 0));
         AV53TokenHeaderAuthenticationRealm = httpContext.cgiGet( edtavTokenheaderauthenticationrealm_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TokenHeaderAuthenticationRealm", AV53TokenHeaderAuthenticationRealm);
         AV54TokenHeaderAuthorizationBasicInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokenheaderauthorizationbasicinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TokenHeaderAuthorizationBasicInclude", AV54TokenHeaderAuthorizationBasicInclude);
         AV48TokenGrantTypeInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokengranttypeinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TokenGrantTypeInclude", AV48TokenGrantTypeInclude);
         AV49TokenGrantTypeTag = httpContext.cgiGet( edtavTokengranttypetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49TokenGrantTypeTag", AV49TokenGrantTypeTag);
         AV50TokenGrantTypeValue = httpContext.cgiGet( edtavTokengranttypevalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50TokenGrantTypeValue", AV50TokenGrantTypeValue);
         AV44TokenAccessCodeInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokenaccesscodeinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TokenAccessCodeInclude", AV44TokenAccessCodeInclude);
         AV46TokenCliIdInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokencliidinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TokenCliIdInclude", AV46TokenCliIdInclude);
         AV47TokenCliSecretInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokenclisecretinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TokenCliSecretInclude", AV47TokenCliSecretInclude);
         AV58TokenRedirectURLInclude = GXutil.strtobool( httpContext.cgiGet( chkavTokenredirecturlinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TokenRedirectURLInclude", AV58TokenRedirectURLInclude);
         AV45TokenAdditionalParameters = httpContext.cgiGet( edtavTokenadditionalparameters_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TokenAdditionalParameters", AV45TokenAdditionalParameters);
         AV60TokenResponseAccessTokenTag = httpContext.cgiGet( edtavTokenresponseaccesstokentag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TokenResponseAccessTokenTag", AV60TokenResponseAccessTokenTag);
         AV65TokenResponseTokenTypeTag = httpContext.cgiGet( edtavTokenresponsetokentypetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TokenResponseTokenTypeTag", AV65TokenResponseTokenTypeTag);
         AV62TokenResponseExpiresInTag = httpContext.cgiGet( edtavTokenresponseexpiresintag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62TokenResponseExpiresInTag", AV62TokenResponseExpiresInTag);
         AV64TokenResponseScopeTag = httpContext.cgiGet( edtavTokenresponsescopetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64TokenResponseScopeTag", AV64TokenResponseScopeTag);
         AV66TokenResponseUserIdTag = httpContext.cgiGet( edtavTokenresponseuseridtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TokenResponseUserIdTag", AV66TokenResponseUserIdTag);
         AV63TokenResponseRefreshTokenTag = httpContext.cgiGet( edtavTokenresponserefreshtokentag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63TokenResponseRefreshTokenTag", AV63TokenResponseRefreshTokenTag);
         AV61TokenResponseErrorDescriptionTag = httpContext.cgiGet( edtavTokenresponseerrordescriptiontag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TokenResponseErrorDescriptionTag", AV61TokenResponseErrorDescriptionTag);
         AV22AutovalidateExternalTokenAndRefresh = GXutil.strtobool( httpContext.cgiGet( chkavAutovalidateexternaltokenandrefresh.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22AutovalidateExternalTokenAndRefresh", AV22AutovalidateExternalTokenAndRefresh);
         AV59TokenRefreshTokenURL = httpContext.cgiGet( edtavTokenrefreshtokenurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TokenRefreshTokenURL", AV59TokenRefreshTokenURL);
         AV94UserInfoURL = httpContext.cgiGet( edtavUserinfourl_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94UserInfoURL", AV94UserInfoURL);
         cmbavUserinfomethod.setName( cmbavUserinfomethod.getInternalname() );
         cmbavUserinfomethod.setValue( httpContext.cgiGet( cmbavUserinfomethod.getInternalname()) );
         AV78UserInfoMethod = httpContext.cgiGet( cmbavUserinfomethod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78UserInfoMethod", AV78UserInfoMethod);
         AV76UserInfoHeaderKeyTag = httpContext.cgiGet( edtavUserinfoheaderkeytag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76UserInfoHeaderKeyTag", AV76UserInfoHeaderKeyTag);
         AV77UserInfoHeaderKeyValue = httpContext.cgiGet( edtavUserinfoheaderkeyvalue_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77UserInfoHeaderKeyValue", AV77UserInfoHeaderKeyValue);
         AV69UserInfoAccessTokenInclude = GXutil.strtobool( httpContext.cgiGet( chkavUserinfoaccesstokeninclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69UserInfoAccessTokenInclude", AV69UserInfoAccessTokenInclude);
         AV70UserInfoAccessTokenName = httpContext.cgiGet( edtavUserinfoaccesstokenname_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70UserInfoAccessTokenName", AV70UserInfoAccessTokenName);
         AV72UserInfoClientIdInclude = GXutil.strtobool( httpContext.cgiGet( chkavUserinfoclientidinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72UserInfoClientIdInclude", AV72UserInfoClientIdInclude);
         AV73UserInfoClientIdName = httpContext.cgiGet( edtavUserinfoclientidname_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73UserInfoClientIdName", AV73UserInfoClientIdName);
         AV74UserInfoClientSecretInclude = GXutil.strtobool( httpContext.cgiGet( chkavUserinfoclientsecretinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74UserInfoClientSecretInclude", AV74UserInfoClientSecretInclude);
         AV75UserInfoClientSecretName = httpContext.cgiGet( edtavUserinfoclientsecretname_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75UserInfoClientSecretName", AV75UserInfoClientSecretName);
         AV95UserInfoUserIdInclude = GXutil.strtobool( httpContext.cgiGet( chkavUserinfouseridinclude.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV95UserInfoUserIdInclude", AV95UserInfoUserIdInclude);
         AV71UserInfoAdditionalParameters = httpContext.cgiGet( edtavUserinfoadditionalparameters_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71UserInfoAdditionalParameters", AV71UserInfoAdditionalParameters);
         AV81UserInfoResponseUserEmailTag = httpContext.cgiGet( edtavUserinforesponseuseremailtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81UserInfoResponseUserEmailTag", AV81UserInfoResponseUserEmailTag);
         AV93UserInfoResponseUserVerifiedEmailTag = httpContext.cgiGet( edtavUserinforesponseuserverifiedemailtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93UserInfoResponseUserVerifiedEmailTag", AV93UserInfoResponseUserVerifiedEmailTag);
         AV82UserInfoResponseUserExternalIdTag = httpContext.cgiGet( edtavUserinforesponseuserexternalidtag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV82UserInfoResponseUserExternalIdTag", AV82UserInfoResponseUserExternalIdTag);
         AV89UserInfoResponseUserNameTag = httpContext.cgiGet( edtavUserinforesponseusernametag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV89UserInfoResponseUserNameTag", AV89UserInfoResponseUserNameTag);
         AV83UserInfoResponseUserFirstNameTag = httpContext.cgiGet( edtavUserinforesponseuserfirstnametag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83UserInfoResponseUserFirstNameTag", AV83UserInfoResponseUserFirstNameTag);
         AV87UserInfoResponseUserLastNameGenAuto = GXutil.strtobool( httpContext.cgiGet( chkavUserinforesponseuserlastnamegenauto.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV87UserInfoResponseUserLastNameGenAuto", AV87UserInfoResponseUserLastNameGenAuto);
         AV88UserInfoResponseUserLastNameTag = httpContext.cgiGet( edtavUserinforesponseuserlastnametag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV88UserInfoResponseUserLastNameTag", AV88UserInfoResponseUserLastNameTag);
         AV84UserInfoResponseUserGenderTag = httpContext.cgiGet( edtavUserinforesponseusergendertag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV84UserInfoResponseUserGenderTag", AV84UserInfoResponseUserGenderTag);
         AV85UserInfoResponseUserGenderValues = httpContext.cgiGet( edtavUserinforesponseusergendervalues_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV85UserInfoResponseUserGenderValues", AV85UserInfoResponseUserGenderValues);
         AV80UserInfoResponseUserBirthdayTag = httpContext.cgiGet( edtavUserinforesponseuserbirthdaytag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80UserInfoResponseUserBirthdayTag", AV80UserInfoResponseUserBirthdayTag);
         AV91UserInfoResponseUserURLImageTag = httpContext.cgiGet( edtavUserinforesponseuserurlimagetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV91UserInfoResponseUserURLImageTag", AV91UserInfoResponseUserURLImageTag);
         AV92UserInfoResponseUserURLProfileTag = httpContext.cgiGet( edtavUserinforesponseuserurlprofiletag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV92UserInfoResponseUserURLProfileTag", AV92UserInfoResponseUserURLProfileTag);
         AV86UserInfoResponseUserLanguageTag = httpContext.cgiGet( edtavUserinforesponseuserlanguagetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV86UserInfoResponseUserLanguageTag", AV86UserInfoResponseUserLanguageTag);
         AV90UserInfoResponseUserTimeZoneTag = httpContext.cgiGet( edtavUserinforesponseusertimezonetag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV90UserInfoResponseUserTimeZoneTag", AV90UserInfoResponseUserTimeZoneTag);
         AV79UserInfoResponseErrorDescriptionTag = httpContext.cgiGet( edtavUserinforesponseerrordescriptiontag_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79UserInfoResponseErrorDescriptionTag", AV79UserInfoResponseErrorDescriptionTag);
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
      e132W2 ();
      if (returnInSub) return;
   }

   public void e132W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'INITAUTHENTICATIONOAUTH20' */
      S112 ();
      if (returnInSub) return;
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
         {
            bttBtnenter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
         }
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
         bttBtnadd_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnadd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnadd_Visible), 5, 0), true);
         edtavName_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
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
         edtavOauth20clientidtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOauth20clientidtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOauth20clientidtag_Enabled), 5, 0), true);
         edtavOauth20clientidvalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOauth20clientidvalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOauth20clientidvalue_Enabled), 5, 0), true);
         edtavOauth20clientsecrettag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOauth20clientsecrettag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOauth20clientsecrettag_Enabled), 5, 0), true);
         edtavOauth20clientsecretvalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOauth20clientsecretvalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOauth20clientsecretvalue_Enabled), 5, 0), true);
         edtavOauth20redirecturltag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOauth20redirecturltag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOauth20redirecturltag_Enabled), 5, 0), true);
         edtavOauth20redirecturlvalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavOauth20redirecturlvalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOauth20redirecturlvalue_Enabled), 5, 0), true);
         chkavOauth20redirecturliscustom.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOauth20redirecturliscustom.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOauth20redirecturliscustom.getEnabled(), 5, 0), true);
         chkavOauth20redirecttoauthenticate.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOauth20redirecttoauthenticate.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOauth20redirecttoauthenticate.getEnabled(), 5, 0), true);
         edtavAuthorizeurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthorizeurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthorizeurl_Enabled), 5, 0), true);
         chkavAuthresptypeinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthresptypeinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAuthresptypeinclude.getEnabled(), 5, 0), true);
         edtavAuthresptypetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthresptypetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthresptypetag_Enabled), 5, 0), true);
         edtavAuthresptypevalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthresptypevalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthresptypevalue_Enabled), 5, 0), true);
         chkavAuthscopeinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthscopeinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAuthscopeinclude.getEnabled(), 5, 0), true);
         edtavAuthscopetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthscopetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthscopetag_Enabled), 5, 0), true);
         edtavAuthscopevalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthscopevalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthscopevalue_Enabled), 5, 0), true);
         chkavAuthstateinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthstateinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAuthstateinclude.getEnabled(), 5, 0), true);
         edtavAuthstatetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthstatetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthstatetag_Enabled), 5, 0), true);
         chkavAuthclientidinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthclientidinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAuthclientidinclude.getEnabled(), 5, 0), true);
         chkavAuthclientsecretinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthclientsecretinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAuthclientsecretinclude.getEnabled(), 5, 0), true);
         chkavAuthredirurlinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthredirurlinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAuthredirurlinclude.getEnabled(), 5, 0), true);
         edtavAuthadditionalparameters_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthadditionalparameters_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthadditionalparameters_Enabled), 5, 0), true);
         edtavAuthadditionalparameterssd_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthadditionalparameterssd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthadditionalparameterssd_Enabled), 5, 0), true);
         edtavAuthresponseaccesscodetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthresponseaccesscodetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthresponseaccesscodetag_Enabled), 5, 0), true);
         edtavAuthresponseerrordesctag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavAuthresponseerrordesctag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthresponseerrordesctag_Enabled), 5, 0), true);
         edtavTokenurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenurl_Enabled), 5, 0), true);
         cmbavTokenmethod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavTokenmethod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTokenmethod.getEnabled(), 5, 0), true);
         edtavTokenheaderkeytag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenheaderkeytag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenheaderkeytag_Enabled), 5, 0), true);
         edtavTokenheaderkeyvalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenheaderkeyvalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenheaderkeyvalue_Enabled), 5, 0), true);
         chkavTokenheaderauthorizationbasicinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenheaderauthorizationbasicinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTokenheaderauthorizationbasicinclude.getEnabled(), 5, 0), true);
         chkavTokengranttypeinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokengranttypeinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTokengranttypeinclude.getEnabled(), 5, 0), true);
         edtavTokengranttypetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokengranttypetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokengranttypetag_Enabled), 5, 0), true);
         edtavTokengranttypevalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokengranttypevalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokengranttypevalue_Enabled), 5, 0), true);
         chkavTokenaccesscodeinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenaccesscodeinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTokenaccesscodeinclude.getEnabled(), 5, 0), true);
         chkavTokencliidinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokencliidinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTokencliidinclude.getEnabled(), 5, 0), true);
         chkavTokenclisecretinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenclisecretinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTokenclisecretinclude.getEnabled(), 5, 0), true);
         chkavTokenredirecturlinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenredirecturlinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavTokenredirecturlinclude.getEnabled(), 5, 0), true);
         edtavTokenadditionalparameters_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenadditionalparameters_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenadditionalparameters_Enabled), 5, 0), true);
         edtavTokenresponseaccesstokentag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponseaccesstokentag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponseaccesstokentag_Enabled), 5, 0), true);
         edtavTokenresponsetokentypetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponsetokentypetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponsetokentypetag_Enabled), 5, 0), true);
         edtavTokenresponseexpiresintag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponseexpiresintag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponseexpiresintag_Enabled), 5, 0), true);
         edtavTokenresponsescopetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponsescopetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponsescopetag_Enabled), 5, 0), true);
         edtavTokenresponseuseridtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponseuseridtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponseuseridtag_Enabled), 5, 0), true);
         edtavTokenresponserefreshtokentag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponserefreshtokentag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponserefreshtokentag_Enabled), 5, 0), true);
         edtavTokenresponseerrordescriptiontag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenresponseerrordescriptiontag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenresponseerrordescriptiontag_Enabled), 5, 0), true);
         chkavAutovalidateexternaltokenandrefresh.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAutovalidateexternaltokenandrefresh.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAutovalidateexternaltokenandrefresh.getEnabled(), 5, 0), true);
         edtavTokenrefreshtokenurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTokenrefreshtokenurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTokenrefreshtokenurl_Enabled), 5, 0), true);
         edtavUserinfourl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfourl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfourl_Enabled), 5, 0), true);
         cmbavUserinfomethod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavUserinfomethod.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavUserinfomethod.getEnabled(), 5, 0), true);
         edtavUserinfoheaderkeytag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfoheaderkeytag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfoheaderkeytag_Enabled), 5, 0), true);
         edtavUserinfoheaderkeyvalue_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfoheaderkeyvalue_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfoheaderkeyvalue_Enabled), 5, 0), true);
         chkavUserinfoaccesstokeninclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfoaccesstokeninclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUserinfoaccesstokeninclude.getEnabled(), 5, 0), true);
         edtavUserinfoaccesstokenname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfoaccesstokenname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfoaccesstokenname_Enabled), 5, 0), true);
         chkavUserinfoclientidinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfoclientidinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUserinfoclientidinclude.getEnabled(), 5, 0), true);
         edtavUserinfoclientidname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfoclientidname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfoclientidname_Enabled), 5, 0), true);
         chkavUserinfoclientsecretinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfoclientsecretinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUserinfoclientsecretinclude.getEnabled(), 5, 0), true);
         edtavUserinfoclientsecretname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfoclientsecretname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfoclientsecretname_Enabled), 5, 0), true);
         chkavUserinfouseridinclude.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfouseridinclude.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUserinfouseridinclude.getEnabled(), 5, 0), true);
         edtavUserinfoadditionalparameters_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinfoadditionalparameters_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinfoadditionalparameters_Enabled), 5, 0), true);
         edtavUserinforesponseuseremailtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuseremailtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuseremailtag_Enabled), 5, 0), true);
         edtavUserinforesponseuserverifiedemailtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserverifiedemailtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserverifiedemailtag_Enabled), 5, 0), true);
         edtavUserinforesponseuserexternalidtag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserexternalidtag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserexternalidtag_Enabled), 5, 0), true);
         edtavUserinforesponseusernametag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusernametag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusernametag_Enabled), 5, 0), true);
         edtavUserinforesponseuserfirstnametag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserfirstnametag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserfirstnametag_Enabled), 5, 0), true);
         chkavUserinforesponseuserlastnamegenauto.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinforesponseuserlastnamegenauto.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUserinforesponseuserlastnamegenauto.getEnabled(), 5, 0), true);
         edtavUserinforesponseuserlastnametag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlastnametag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlastnametag_Enabled), 5, 0), true);
         edtavUserinforesponseusergendertag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusergendertag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusergendertag_Enabled), 5, 0), true);
         edtavUserinforesponseusergendervalues_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusergendervalues_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusergendervalues_Enabled), 5, 0), true);
         edtavUserinforesponseuserbirthdaytag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserbirthdaytag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserbirthdaytag_Enabled), 5, 0), true);
         edtavUserinforesponseuserurlimagetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserurlimagetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserurlimagetag_Enabled), 5, 0), true);
         edtavUserinforesponseuserurlprofiletag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserurlprofiletag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserurlprofiletag_Enabled), 5, 0), true);
         edtavUserinforesponseuserlanguagetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlanguagetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlanguagetag_Enabled), 5, 0), true);
         edtavUserinforesponseusertimezonetag_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseusertimezonetag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseusertimezonetag_Enabled), 5, 0), true);
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

   private void e142W2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV109GXV1 = 1 ;
      while ( AV109GXV1 <= AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserproperties().size() )
      {
         AV31GAMPropertySimple = (genexus.security.api.genexussecurity.SdtGAMPropertySimple)((genexus.security.api.genexussecurity.SdtGAMPropertySimple)AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserproperties().elementAt(-1+AV109GXV1));
         edtavDeleteproperty_gximage = "ActionCancel" ;
         AV24DeleteProperty = context.getHttpContext().getImagePath( "f454b006-8fb2-471d-b379-a84a77f89118", "", context.getHttpContext().getTheme( )) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeleteproperty_Internalname, AV24DeleteProperty);
         AV110Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "f454b006-8fb2-471d-b379-a84a77f89118", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
         AV26DynamicPropName = AV31GAMPropertySimple.getgxTv_SdtGAMPropertySimple_Id() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicpropname_Internalname, AV26DynamicPropName);
         AV27DynamicPropTag = AV31GAMPropertySimple.getgxTv_SdtGAMPropertySimple_Value() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicproptag_Internalname, AV27DynamicPropTag);
         if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
         {
            edtavDeleteproperty_Visible = 0 ;
            edtavDynamicpropname_Enabled = 0 ;
            edtavDynamicproptag_Enabled = 0 ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(462) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_4622( ) ;
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
         if ( isFullAjaxMode( ) && ! bGXsfl_462_Refreshing )
         {
            httpContext.doAjaxLoad(462, GridRow);
         }
         AV109GXV1 = (int)(AV109GXV1+1) ;
      }
      edtavDeleteproperty_gximage = "ActionDelete" ;
      AV24DeleteProperty = context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDeleteproperty_Internalname, AV24DeleteProperty);
      AV110Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavDeleteproperty_Tooltiptext = "" ;
      /*  Sending Event outputs  */
   }

   public void e112W2( )
   {
      /* 'DoAdd' Routine */
      returnInSub = false ;
      edtavDeleteproperty_gximage = "ActionCancel" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "gximage", edtavDeleteproperty_gximage, !bGXsfl_462_Refreshing);
      AV24DeleteProperty = context.getHttpContext().getImagePath( "f454b006-8fb2-471d-b379-a84a77f89118", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV24DeleteProperty)==0) ? AV110Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24DeleteProperty))), !bGXsfl_462_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24DeleteProperty), true);
      AV110Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "f454b006-8fb2-471d-b379-a84a77f89118", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV24DeleteProperty)==0) ? AV110Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24DeleteProperty))), !bGXsfl_462_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24DeleteProperty), true);
      edtavDeleteproperty_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteproperty_Visible), 5, 0), !bGXsfl_462_Refreshing);
      edtavDynamicpropname_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicpropname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicpropname_Enabled), 5, 0), !bGXsfl_462_Refreshing);
      edtavDynamicpropname_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicpropname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicpropname_Visible), 5, 0), !bGXsfl_462_Refreshing);
      edtavDynamicproptag_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicproptag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicproptag_Enabled), 5, 0), !bGXsfl_462_Refreshing);
      edtavDynamicproptag_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicproptag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicproptag_Visible), 5, 0), !bGXsfl_462_Refreshing);
      if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
      {
         sendrow_4622( ) ;
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
      if ( isFullAjaxMode( ) && ! bGXsfl_462_Refreshing )
      {
         httpContext.doAjaxLoad(462, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV105CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV105CheckRequiredFieldsResult", AV105CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV34Name)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Name", ""), "", "", "", "", "", "", "", ""), "error", edtavName_Internalname, "true", ""));
         AV105CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV105CheckRequiredFieldsResult", AV105CheckRequiredFieldsResult);
      }
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ! AV87UserInfoResponseUserLastNameGenAuto ) )
      {
         edtavUserinforesponseuserlastnametag_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlastnametag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlastnametag_Visible), 5, 0), true);
         cellUserinforesponseuserlastnametag_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cellUserinforesponseuserlastnametag_cell_Internalname, "Class", cellUserinforesponseuserlastnametag_cell_Class, true);
         divTextblockuserinforesponseuserlastnametag_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTextblockuserinforesponseuserlastnametag_cell_Internalname, "Class", divTextblockuserinforesponseuserlastnametag_cell_Class, true);
      }
      else
      {
         edtavUserinforesponseuserlastnametag_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlastnametag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlastnametag_Visible), 5, 0), true);
         cellUserinforesponseuserlastnametag_cell_Class = "MergeDataCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cellUserinforesponseuserlastnametag_cell_Internalname, "Class", cellUserinforesponseuserlastnametag_cell_Class, true);
         divTextblockuserinforesponseuserlastnametag_cell_Class = "col-sm-12 MergeLabelCell" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, divTextblockuserinforesponseuserlastnametag_cell_Internalname, "Class", divTextblockuserinforesponseuserlastnametag_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e122W2 ();
      if (returnInSub) return;
   }

   public void e122W2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S132 ();
      if (returnInSub) return;
      if ( AV105CheckRequiredFieldsResult )
      {
         if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
         {
            /* Execute user subroutine: 'SAVEAUTHENTICATIONOAUTH20' */
            S142 ();
            if (returnInSub) return;
         }
         else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            AV9AuthenticationTypeOauth20.load(AV34Name);
            AV9AuthenticationTypeOauth20.delete();
         }
         if ( AV9AuthenticationTypeOauth20.success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "gamwcauthenticationtypeentryoauth20");
            callWebObject(formatLink("com.mujermorena.gamwwauthtypes", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            AV29Errors = AV9AuthenticationTypeOauth20.geterrors() ;
            AV111GXV2 = 1 ;
            while ( AV111GXV2 <= AV29Errors.size() )
            {
               AV28Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV29Errors.elementAt(-1+AV111GXV2));
               httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV28Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV28Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
               AV111GXV2 = (int)(AV111GXV2+1) ;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9AuthenticationTypeOauth20", AV9AuthenticationTypeOauth20);
   }

   public void e152W2( )
   {
      /* Deleteproperty_Click Routine */
      returnInSub = false ;
      edtavDeleteproperty_gximage = "ActionCancel" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "gximage", edtavDeleteproperty_gximage, !bGXsfl_462_Refreshing);
      AV24DeleteProperty = context.getHttpContext().getImagePath( "f454b006-8fb2-471d-b379-a84a77f89118", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV24DeleteProperty)==0) ? AV110Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24DeleteProperty))), !bGXsfl_462_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24DeleteProperty), true);
      AV110Deleteproperty_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "f454b006-8fb2-471d-b379-a84a77f89118", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Bitmap", ((GXutil.strcmp("", AV24DeleteProperty)==0) ? AV110Deleteproperty_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV24DeleteProperty))), !bGXsfl_462_Refreshing);
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV24DeleteProperty), true);
      edtavDeleteproperty_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDeleteproperty_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteproperty_Visible), 5, 0), !bGXsfl_462_Refreshing);
      edtavDynamicpropname_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicpropname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicpropname_Visible), 5, 0), !bGXsfl_462_Refreshing);
      edtavDynamicproptag_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDynamicproptag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDynamicproptag_Visible), 5, 0), !bGXsfl_462_Refreshing);
      AV26DynamicPropName = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicpropname_Internalname, AV26DynamicPropName);
      AV27DynamicPropTag = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavDynamicproptag_Internalname, AV27DynamicPropTag);
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Name( AV34Name );
      GXv_objcol_SdtGAMError1[0] = AV29Errors ;
      AV9AuthenticationTypeOauth20.removeuserinfoproperty(AV26DynamicPropName, GXv_objcol_SdtGAMError1);
      AV29Errors = GXv_objcol_SdtGAMError1[0] ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV9AuthenticationTypeOauth20", AV9AuthenticationTypeOauth20);
   }

   public void S112( )
   {
      /* 'INITAUTHENTICATIONOAUTH20' Routine */
      returnInSub = false ;
      AV9AuthenticationTypeOauth20.load(AV34Name);
      AV34Name = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Name", AV34Name);
      AV33IsEnable = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Isenable() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33IsEnable", AV33IsEnable);
      AV25Dsc = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Description() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV25Dsc", AV25Dsc);
      AV43SmallImageName = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Smallimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV43SmallImageName", AV43SmallImageName);
      AV23BigImageName = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Bigimagename() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23BigImageName", AV23BigImageName);
      AV32Impersonate = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Impersonate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32Impersonate", AV32Impersonate);
      AV35Oauth20ClientIdTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Clientid_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35Oauth20ClientIdTag", AV35Oauth20ClientIdTag);
      AV36Oauth20ClientIdValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Clientid_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV36Oauth20ClientIdValue", AV36Oauth20ClientIdValue);
      AV37Oauth20ClientSecretTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Clientsecret_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37Oauth20ClientSecretTag", AV37Oauth20ClientSecretTag);
      AV38Oauth20ClientSecretValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Clientsecret_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV38Oauth20ClientSecretValue", AV38Oauth20ClientSecretValue);
      AV41Oauth20RedirectURLTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Redirecturl_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV41Oauth20RedirectURLTag", AV41Oauth20RedirectURLTag);
      AV42Oauth20RedirectURLvalue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Redirecturl_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV42Oauth20RedirectURLvalue", AV42Oauth20RedirectURLvalue);
      AV40Oauth20RedirectURLisCustom = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Redirecturl_iscustom() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV40Oauth20RedirectURLisCustom", AV40Oauth20RedirectURLisCustom);
      AV39Oauth20RedirectToAuthenticate = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Redirecttoauthenticate() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV39Oauth20RedirectToAuthenticate", AV39Oauth20RedirectToAuthenticate);
      AV10AuthorizeURL = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Url() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10AuthorizeURL", AV10AuthorizeURL);
      AV14AuthRespTypeInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Responsetype_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14AuthRespTypeInclude", AV14AuthRespTypeInclude);
      AV15AuthRespTypeTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Responsetype_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15AuthRespTypeTag", AV15AuthRespTypeTag);
      AV16AuthRespTypeValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Responsetype_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16AuthRespTypeValue", AV16AuthRespTypeValue);
      AV17AuthScopeInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Scope_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17AuthScopeInclude", AV17AuthScopeInclude);
      AV18AuthScopeTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Scope_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18AuthScopeTag", AV18AuthScopeTag);
      AV19AuthScopeValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Scope_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19AuthScopeValue", AV19AuthScopeValue);
      AV98AuthStateInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_State_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV98AuthStateInclude", AV98AuthStateInclude);
      AV21AuthStateTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_State_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21AuthStateTag", AV21AuthStateTag);
      AV7AuthClientIdInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Clientid_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7AuthClientIdInclude", AV7AuthClientIdInclude);
      AV8AuthClientSecretInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Clientsecret_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8AuthClientSecretInclude", AV8AuthClientSecretInclude);
      AV99AuthRedirURLInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Redirecturl_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV99AuthRedirURLInclude", AV99AuthRedirURLInclude);
      AV5AuthAdditionalParameters = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Additionalparameters() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5AuthAdditionalParameters", AV5AuthAdditionalParameters);
      AV6AuthAdditionalParametersSD = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Additionalparametersnativesd() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6AuthAdditionalParametersSD", AV6AuthAdditionalParametersSD);
      AV12AuthResponseAccessCodeTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Responseaccesscode_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12AuthResponseAccessCodeTag", AV12AuthResponseAccessCodeTag);
      AV13AuthResponseErrorDescTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().getgxTv_SdtGAMAuthenticationOAuth20Authorize_Responseerrordescription_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13AuthResponseErrorDescTag", AV13AuthResponseErrorDescTag);
      AV67TokenURL = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Url() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV67TokenURL", AV67TokenURL);
      AV57TokenMethod = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Method() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV57TokenMethod", AV57TokenMethod);
      AV55TokenHeaderKeyTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Header_key() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV55TokenHeaderKeyTag", AV55TokenHeaderKeyTag);
      AV56TokenHeaderKeyValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Header_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV56TokenHeaderKeyValue", AV56TokenHeaderKeyValue);
      AV51TokenHeaderAuthenticationInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Header_authentication_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV51TokenHeaderAuthenticationInclude", AV51TokenHeaderAuthenticationInclude);
      AV52TokenHeaderAuthenticationMethod = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Header_authentication_method() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV52TokenHeaderAuthenticationMethod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV52TokenHeaderAuthenticationMethod), 4, 0));
      AV53TokenHeaderAuthenticationRealm = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Header_authentication_realm() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV53TokenHeaderAuthenticationRealm", AV53TokenHeaderAuthenticationRealm);
      AV54TokenHeaderAuthorizationBasicInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Header_authorizationbasic_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV54TokenHeaderAuthorizationBasicInclude", AV54TokenHeaderAuthorizationBasicInclude);
      AV48TokenGrantTypeInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Granttype_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV48TokenGrantTypeInclude", AV48TokenGrantTypeInclude);
      AV49TokenGrantTypeTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Granttype_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV49TokenGrantTypeTag", AV49TokenGrantTypeTag);
      AV50TokenGrantTypeValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Granttype_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV50TokenGrantTypeValue", AV50TokenGrantTypeValue);
      AV44TokenAccessCodeInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Accesscode_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44TokenAccessCodeInclude", AV44TokenAccessCodeInclude);
      AV46TokenCliIdInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Clientid_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV46TokenCliIdInclude", AV46TokenCliIdInclude);
      AV47TokenCliSecretInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Clientsecret_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV47TokenCliSecretInclude", AV47TokenCliSecretInclude);
      AV58TokenRedirectURLInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Redirecturl_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV58TokenRedirectURLInclude", AV58TokenRedirectURLInclude);
      AV45TokenAdditionalParameters = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Additionalparameters() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV45TokenAdditionalParameters", AV45TokenAdditionalParameters);
      AV60TokenResponseAccessTokenTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responseaccesstoken_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV60TokenResponseAccessTokenTag", AV60TokenResponseAccessTokenTag);
      AV65TokenResponseTokenTypeTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responsetokentype_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV65TokenResponseTokenTypeTag", AV65TokenResponseTokenTypeTag);
      AV62TokenResponseExpiresInTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responseexpiresin_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV62TokenResponseExpiresInTag", AV62TokenResponseExpiresInTag);
      AV64TokenResponseScopeTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responsescope_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV64TokenResponseScopeTag", AV64TokenResponseScopeTag);
      AV66TokenResponseUserIdTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responseuserid_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV66TokenResponseUserIdTag", AV66TokenResponseUserIdTag);
      AV63TokenResponseRefreshTokenTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responserefreshtoken_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV63TokenResponseRefreshTokenTag", AV63TokenResponseRefreshTokenTag);
      AV61TokenResponseErrorDescriptionTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Responseerrordescription_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV61TokenResponseErrorDescriptionTag", AV61TokenResponseErrorDescriptionTag);
      AV22AutovalidateExternalTokenAndRefresh = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Autovalidateexternaltokenandrefresh() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22AutovalidateExternalTokenAndRefresh", AV22AutovalidateExternalTokenAndRefresh);
      AV59TokenRefreshTokenURL = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().getgxTv_SdtGAMAuthenticationOAuth20Token_Refreshtoken_url() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV59TokenRefreshTokenURL", AV59TokenRefreshTokenURL);
      AV94UserInfoURL = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Url() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV94UserInfoURL", AV94UserInfoURL);
      AV78UserInfoMethod = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Method() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV78UserInfoMethod", AV78UserInfoMethod);
      AV76UserInfoHeaderKeyTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Header_key() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV76UserInfoHeaderKeyTag", AV76UserInfoHeaderKeyTag);
      AV77UserInfoHeaderKeyValue = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Header_value() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV77UserInfoHeaderKeyValue", AV77UserInfoHeaderKeyValue);
      AV69UserInfoAccessTokenInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Accesstoken_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV69UserInfoAccessTokenInclude", AV69UserInfoAccessTokenInclude);
      AV70UserInfoAccessTokenName = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Accesstoken_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV70UserInfoAccessTokenName", AV70UserInfoAccessTokenName);
      AV72UserInfoClientIdInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientid_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV72UserInfoClientIdInclude", AV72UserInfoClientIdInclude);
      AV73UserInfoClientIdName = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientid_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV73UserInfoClientIdName", AV73UserInfoClientIdName);
      AV74UserInfoClientSecretInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientsecret_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV74UserInfoClientSecretInclude", AV74UserInfoClientSecretInclude);
      AV75UserInfoClientSecretName = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientsecret_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV75UserInfoClientSecretName", AV75UserInfoClientSecretName);
      AV95UserInfoUserIdInclude = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Userid_include() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV95UserInfoUserIdInclude", AV95UserInfoUserIdInclude);
      AV71UserInfoAdditionalParameters = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Additionalparameters() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV71UserInfoAdditionalParameters", AV71UserInfoAdditionalParameters);
      AV81UserInfoResponseUserEmailTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuseremail_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV81UserInfoResponseUserEmailTag", AV81UserInfoResponseUserEmailTag);
      AV93UserInfoResponseUserVerifiedEmailTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserverifiedemail_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV93UserInfoResponseUserVerifiedEmailTag", AV93UserInfoResponseUserVerifiedEmailTag);
      AV82UserInfoResponseUserExternalIdTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserexternalid_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV82UserInfoResponseUserExternalIdTag", AV82UserInfoResponseUserExternalIdTag);
      AV89UserInfoResponseUserNameTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusername_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV89UserInfoResponseUserNameTag", AV89UserInfoResponseUserNameTag);
      AV83UserInfoResponseUserFirstNameTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserfirstname_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV83UserInfoResponseUserFirstNameTag", AV83UserInfoResponseUserFirstNameTag);
      AV87UserInfoResponseUserLastNameGenAuto = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserlastname_generateautomatic() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV87UserInfoResponseUserLastNameGenAuto", AV87UserInfoResponseUserLastNameGenAuto);
      AV88UserInfoResponseUserLastNameTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserlastname_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV88UserInfoResponseUserLastNameTag", AV88UserInfoResponseUserLastNameTag);
      AV84UserInfoResponseUserGenderTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusergender_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV84UserInfoResponseUserGenderTag", AV84UserInfoResponseUserGenderTag);
      AV85UserInfoResponseUserGenderValues = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusergender_values() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV85UserInfoResponseUserGenderValues", AV85UserInfoResponseUserGenderValues);
      AV80UserInfoResponseUserBirthdayTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserbirthday_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV80UserInfoResponseUserBirthdayTag", AV80UserInfoResponseUserBirthdayTag);
      AV91UserInfoResponseUserURLImageTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserurlimage_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV91UserInfoResponseUserURLImageTag", AV91UserInfoResponseUserURLImageTag);
      AV92UserInfoResponseUserURLProfileTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserurlprofile_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV92UserInfoResponseUserURLProfileTag", AV92UserInfoResponseUserURLProfileTag);
      AV86UserInfoResponseUserLanguageTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserlanguage_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV86UserInfoResponseUserLanguageTag", AV86UserInfoResponseUserLanguageTag);
      AV90UserInfoResponseUserTimeZoneTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusertimezone_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV90UserInfoResponseUserTimeZoneTag", AV90UserInfoResponseUserTimeZoneTag);
      AV79UserInfoResponseErrorDescriptionTag = AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().getgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseerrordescription_name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV79UserInfoResponseErrorDescriptionTag", AV79UserInfoResponseErrorDescriptionTag);
      AV30FunctionId = "OnlyAuthentication" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV30FunctionId", AV30FunctionId);
      cmbavFunctionid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFunctionid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavFunctionid.getEnabled(), 5, 0), true);
      /* Execute user subroutine: 'USERINFOLASTNAMEFIELDTAG' */
      S152 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         AV9AuthenticationTypeOauth20 = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOauth20)new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOauth20(remoteHandle, context);
      }
   }

   public void S142( )
   {
      /* 'SAVEAUTHENTICATIONOAUTH20' Routine */
      returnInSub = false ;
      AV9AuthenticationTypeOauth20.load(AV34Name);
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Name( AV34Name );
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Isenable( AV33IsEnable );
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Description( AV25Dsc );
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Smallimagename( AV43SmallImageName );
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Bigimagename( AV23BigImageName );
      AV9AuthenticationTypeOauth20.setgxTv_SdtGAMAuthenticationTypeOauth20_Impersonate( AV32Impersonate );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Clientid_name( AV35Oauth20ClientIdTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Clientid_value( AV36Oauth20ClientIdValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Clientsecret_name( AV37Oauth20ClientSecretTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Clientsecret_value( AV38Oauth20ClientSecretValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Redirecturl_name( AV41Oauth20RedirectURLTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Redirecturl_value( AV42Oauth20RedirectURLvalue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Redirecturl_iscustom( AV40Oauth20RedirectURLisCustom );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().setgxTv_SdtGAMAuthenticationOAuth20_Redirecttoauthenticate( AV39Oauth20RedirectToAuthenticate );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Url( AV10AuthorizeURL );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Responsetype_include( AV14AuthRespTypeInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Responsetype_name( AV15AuthRespTypeTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Responsetype_value( AV16AuthRespTypeValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Scope_include( AV17AuthScopeInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Scope_name( AV18AuthScopeTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Scope_value( AV19AuthScopeValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_State_include( AV98AuthStateInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_State_name( AV21AuthStateTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Clientid_include( AV7AuthClientIdInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Clientsecret_include( AV8AuthClientSecretInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Redirecturl_include( AV99AuthRedirURLInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Additionalparameters( AV5AuthAdditionalParameters );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Additionalparametersnativesd( AV6AuthAdditionalParametersSD );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Responseaccesscode_name( AV12AuthResponseAccessCodeTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Authorize().setgxTv_SdtGAMAuthenticationOAuth20Authorize_Responseerrordescription_name( AV13AuthResponseErrorDescTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Url( AV67TokenURL );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Method( AV57TokenMethod );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Header_key( AV55TokenHeaderKeyTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Header_value( AV56TokenHeaderKeyValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Header_authentication_include( AV51TokenHeaderAuthenticationInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Header_authentication_method( AV52TokenHeaderAuthenticationMethod );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Header_authentication_realm( AV53TokenHeaderAuthenticationRealm );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Header_authorizationbasic_include( AV54TokenHeaderAuthorizationBasicInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Granttype_include( AV48TokenGrantTypeInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Granttype_name( AV49TokenGrantTypeTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Granttype_value( AV50TokenGrantTypeValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Accesscode_include( AV44TokenAccessCodeInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Clientid_include( AV46TokenCliIdInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Clientsecret_include( AV47TokenCliSecretInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Redirecturl_include( AV58TokenRedirectURLInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Additionalparameters( AV45TokenAdditionalParameters );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responseaccesstoken_name( AV60TokenResponseAccessTokenTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responsetokentype_name( AV65TokenResponseTokenTypeTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responseexpiresin_name( AV62TokenResponseExpiresInTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responsescope_name( AV64TokenResponseScopeTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responseuserid_name( AV66TokenResponseUserIdTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responserefreshtoken_name( AV63TokenResponseRefreshTokenTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Responseerrordescription_name( AV61TokenResponseErrorDescriptionTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Autovalidateexternaltokenandrefresh( AV22AutovalidateExternalTokenAndRefresh );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Token().setgxTv_SdtGAMAuthenticationOAuth20Token_Refreshtoken_url( AV59TokenRefreshTokenURL );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Url( AV94UserInfoURL );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Method( AV78UserInfoMethod );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Header_key( AV76UserInfoHeaderKeyTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Header_value( AV77UserInfoHeaderKeyValue );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Accesstoken_include( AV69UserInfoAccessTokenInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Accesstoken_name( AV70UserInfoAccessTokenName );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientid_include( AV72UserInfoClientIdInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientid_name( AV73UserInfoClientIdName );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientsecret_include( AV74UserInfoClientSecretInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Clientsecret_name( AV75UserInfoClientSecretName );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Userid_include( AV95UserInfoUserIdInclude );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Additionalparameters( AV71UserInfoAdditionalParameters );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuseremail_name( AV81UserInfoResponseUserEmailTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserverifiedemail_name( AV93UserInfoResponseUserVerifiedEmailTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserexternalid_name( AV82UserInfoResponseUserExternalIdTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusername_name( AV89UserInfoResponseUserNameTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserfirstname_name( AV83UserInfoResponseUserFirstNameTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserlastname_generateautomatic( AV87UserInfoResponseUserLastNameGenAuto );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserlastname_name( AV88UserInfoResponseUserLastNameTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusergender_name( AV84UserInfoResponseUserGenderTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusergender_values( AV85UserInfoResponseUserGenderValues );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserbirthday_name( AV80UserInfoResponseUserBirthdayTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserurlimage_name( AV91UserInfoResponseUserURLImageTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserurlprofile_name( AV92UserInfoResponseUserURLProfileTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseuserlanguage_name( AV86UserInfoResponseUserLanguageTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseusertimezone_name( AV90UserInfoResponseUserTimeZoneTag );
      AV9AuthenticationTypeOauth20.getgxTv_SdtGAMAuthenticationTypeOauth20_Oauth20().getgxTv_SdtGAMAuthenticationOAuth20_Userinfo().setgxTv_SdtGAMAuthenticationOAuth20UserInfo_Responseerrordescription_name( AV79UserInfoResponseErrorDescriptionTag );
      AV9AuthenticationTypeOauth20.save();
      /* Start For Each Line */
      nRC_GXsfl_462 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_462"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_462_fel_idx = 0 ;
      while ( nGXsfl_462_fel_idx < nRC_GXsfl_462 )
      {
         nGXsfl_462_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_462_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_462_fel_idx+1) ;
         sGXsfl_462_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_462_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_4622( ) ;
         AV26DynamicPropName = httpContext.cgiGet( edtavDynamicpropname_Internalname) ;
         AV27DynamicPropTag = httpContext.cgiGet( edtavDynamicproptag_Internalname) ;
         AV24DeleteProperty = httpContext.cgiGet( edtavDeleteproperty_Internalname) ;
         if ( ! (GXutil.strcmp("", AV26DynamicPropName)==0) && ! (GXutil.strcmp("", AV27DynamicPropTag)==0) )
         {
            AV31GAMPropertySimple = (genexus.security.api.genexussecurity.SdtGAMPropertySimple)new genexus.security.api.genexussecurity.SdtGAMPropertySimple(remoteHandle, context);
            AV31GAMPropertySimple.setgxTv_SdtGAMPropertySimple_Id( AV26DynamicPropName );
            AV31GAMPropertySimple.setgxTv_SdtGAMPropertySimple_Value( AV27DynamicPropTag );
            GXv_objcol_SdtGAMError1[0] = AV29Errors ;
            if ( ! AV9AuthenticationTypeOauth20.setuserinfoproperty(AV31GAMPropertySimple, GXv_objcol_SdtGAMError1) )
            {
               AV29Errors = GXv_objcol_SdtGAMError1[0] ;
               AV113GXV3 = 1 ;
               while ( AV113GXV3 <= AV29Errors.size() )
               {
                  AV28Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV29Errors.elementAt(-1+AV113GXV3));
                  System.out.println( GXutil.format( "%1 (GAM%2)", AV28Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV28Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", "") );
                  AV113GXV3 = (int)(AV113GXV3+1) ;
               }
            }
         }
         /* End For Each Line */
      }
      if ( nGXsfl_462_fel_idx == 0 )
      {
         nGXsfl_462_idx = 1 ;
         sGXsfl_462_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_462_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4622( ) ;
      }
      nGXsfl_462_fel_idx = 1 ;
   }

   public void S152( )
   {
      /* 'USERINFOLASTNAMEFIELDTAG' Routine */
      returnInSub = false ;
      if ( AV87UserInfoResponseUserLastNameGenAuto )
      {
         edtavUserinforesponseuserlastnametag_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlastnametag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlastnametag_Visible), 5, 0), true);
         lblTbuserlastnamehelp_Caption = "*Generate Last Name automatically using the first name spaces" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTbuserlastnamehelp_Internalname, "Caption", lblTbuserlastnamehelp_Caption, true);
      }
      else
      {
         edtavUserinforesponseuserlastnametag_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavUserinforesponseuserlastnametag_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserinforesponseuserlastnametag_Visible), 5, 0), true);
         lblTbuserlastnamehelp_Caption = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTbuserlastnamehelp_Internalname, "Caption", lblTbuserlastnamehelp_Caption, true);
      }
   }

   public void wb_table1_413_2W2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergeduserinforesponseuserlastnametag_Internalname, tblTablemergeduserinforesponseuserlastnametag_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td id=\""+cellUserinforesponseuserlastnametag_cell_Internalname+"\"  class='"+cellUserinforesponseuserlastnametag_cell_Class+"'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserinforesponseuserlastnametag_Internalname, httpContext.getMessage( "User Info Response User Last Name Tag", ""), "gx-form-item AttributeRealWidthLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 417,'" + sPrefix + "',false,'" + sGXsfl_462_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserinforesponseuserlastnametag_Internalname, GXutil.rtrim( AV88UserInfoResponseUserLastNameTag), GXutil.rtrim( localUtil.format( AV88UserInfoResponseUserLastNameTag, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,417);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserinforesponseuserlastnametag_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavUserinforesponseuserlastnametag_Visible, edtavUserinforesponseuserlastnametag_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbuserlastnamehelp_Internalname, lblTbuserlastnamehelp_Caption, "", "", lblTbuserlastnamehelp_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWCAuthenticationTypeEntryOauth20.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_413_2W2e( true) ;
      }
      else
      {
         wb_table1_413_2W2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
      AV34Name = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Name", AV34Name);
      AV68TypeId = (String)getParm(obj,2,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TypeId", AV68TypeId);
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
      pa2W2( ) ;
      ws2W2( ) ;
      we2W2( ) ;
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
      sCtrlAV34Name = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV68TypeId = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa2W2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "gamwcauthenticationtypeentryoauth20", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa2W2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         Gx_mode = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "Gx_mode", Gx_mode);
         AV34Name = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Name", AV34Name);
         AV68TypeId = (String)getParm(obj,4,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TypeId", AV68TypeId);
      }
      wcpOGx_mode = httpContext.cgiGet( sPrefix+"wcpOGx_mode") ;
      wcpOAV34Name = httpContext.cgiGet( sPrefix+"wcpOAV34Name") ;
      wcpOAV68TypeId = httpContext.cgiGet( sPrefix+"wcpOAV68TypeId") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(Gx_mode, wcpOGx_mode) != 0 ) || ( GXutil.strcmp(AV34Name, wcpOAV34Name) != 0 ) || ( GXutil.strcmp(AV68TypeId, wcpOAV68TypeId) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOGx_mode = Gx_mode ;
      wcpOAV34Name = AV34Name ;
      wcpOAV68TypeId = AV68TypeId ;
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
      sCtrlAV34Name = httpContext.cgiGet( sPrefix+"AV34Name_CTRL") ;
      if ( GXutil.len( sCtrlAV34Name) > 0 )
      {
         AV34Name = httpContext.cgiGet( sCtrlAV34Name) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34Name", AV34Name);
      }
      else
      {
         AV34Name = httpContext.cgiGet( sPrefix+"AV34Name_PARM") ;
      }
      sCtrlAV68TypeId = httpContext.cgiGet( sPrefix+"AV68TypeId_CTRL") ;
      if ( GXutil.len( sCtrlAV68TypeId) > 0 )
      {
         AV68TypeId = httpContext.cgiGet( sCtrlAV68TypeId) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV68TypeId", AV68TypeId);
      }
      else
      {
         AV68TypeId = httpContext.cgiGet( sPrefix+"AV68TypeId_PARM") ;
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
      pa2W2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws2W2( ) ;
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
      ws2W2( ) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV34Name_PARM", GXutil.rtrim( AV34Name));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV34Name)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV34Name_CTRL", GXutil.rtrim( sCtrlAV34Name));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV68TypeId_PARM", GXutil.rtrim( AV68TypeId));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV68TypeId)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV68TypeId_CTRL", GXutil.rtrim( sCtrlAV68TypeId));
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
      we2W2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024121117792", true, true);
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
      httpContext.AddJavascriptSource("gamwcauthenticationtypeentryoauth20.js", "?2024121117792", false, true);
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

   public void subsflControlProps_4622( )
   {
      edtavDynamicpropname_Internalname = sPrefix+"vDYNAMICPROPNAME_"+sGXsfl_462_idx ;
      edtavDynamicproptag_Internalname = sPrefix+"vDYNAMICPROPTAG_"+sGXsfl_462_idx ;
      edtavDeleteproperty_Internalname = sPrefix+"vDELETEPROPERTY_"+sGXsfl_462_idx ;
   }

   public void subsflControlProps_fel_4622( )
   {
      edtavDynamicpropname_Internalname = sPrefix+"vDYNAMICPROPNAME_"+sGXsfl_462_fel_idx ;
      edtavDynamicproptag_Internalname = sPrefix+"vDYNAMICPROPTAG_"+sGXsfl_462_fel_idx ;
      edtavDeleteproperty_Internalname = sPrefix+"vDELETEPROPERTY_"+sGXsfl_462_fel_idx ;
   }

   public void sendrow_4622( )
   {
      subsflControlProps_4622( ) ;
      wb2W0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_462_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_462_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_462_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDynamicpropname_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDynamicpropname_Enabled!=0)&&(edtavDynamicpropname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 463,'"+sPrefix+"',false,'"+sGXsfl_462_idx+"',462)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDynamicpropname_Internalname,GXutil.rtrim( AV26DynamicPropName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDynamicpropname_Enabled!=0)&&(edtavDynamicpropname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,463);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDynamicpropname_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(edtavDynamicpropname_Visible),Integer.valueOf(edtavDynamicpropname_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(462),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMPropertyId","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDynamicproptag_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDynamicproptag_Enabled!=0)&&(edtavDynamicproptag_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 464,'"+sPrefix+"',false,'"+sGXsfl_462_idx+"',462)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDynamicproptag_Internalname,GXutil.rtrim( AV27DynamicPropTag),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDynamicproptag_Enabled!=0)&&(edtavDynamicproptag_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,464);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDynamicproptag_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(edtavDynamicproptag_Visible),Integer.valueOf(edtavDynamicproptag_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(462),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtavDeleteproperty_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavDeleteproperty_Enabled!=0)&&(edtavDeleteproperty_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 465,'"+sPrefix+"',false,'',462)\"" : " ") ;
         ClassString = "ActionBaseColorAttribute" + " " + ((GXutil.strcmp(edtavDeleteproperty_gximage, "")==0) ? "" : "GX_Image_"+edtavDeleteproperty_gximage+"_Class") ;
         StyleString = "" ;
         AV24DeleteProperty_IsBlob = (boolean)(((GXutil.strcmp("", AV24DeleteProperty)==0)&&(GXutil.strcmp("", AV110Deleteproperty_GXI)==0))||!(GXutil.strcmp("", AV24DeleteProperty)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV24DeleteProperty)==0) ? AV110Deleteproperty_GXI : httpContext.getResourceRelative(AV24DeleteProperty)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavDeleteproperty_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavDeleteproperty_Visible),Integer.valueOf(1),"",edtavDeleteproperty_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavDeleteproperty_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVDELETEPROPERTY.CLICK."+sGXsfl_462_idx+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV24DeleteProperty_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         send_integrity_lvl_hashes2W2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_462_idx = ((subGrid_Islastpage==1)&&(nGXsfl_462_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_462_idx+1) ;
         sGXsfl_462_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_462_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4622( ) ;
      }
      /* End function sendrow_4622 */
   }

   public void startgridcontrol462( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridContainer"+"DivS\" data-gxgridid=\"462\">") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV26DynamicPropName));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDynamicpropname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDynamicpropname_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV27DynamicPropTag));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDynamicproptag_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDynamicproptag_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV24DeleteProperty));
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
      edtavOauth20clientidtag_Internalname = sPrefix+"vOAUTH20CLIENTIDTAG" ;
      edtavOauth20clientidvalue_Internalname = sPrefix+"vOAUTH20CLIENTIDVALUE" ;
      edtavOauth20clientsecrettag_Internalname = sPrefix+"vOAUTH20CLIENTSECRETTAG" ;
      edtavOauth20clientsecretvalue_Internalname = sPrefix+"vOAUTH20CLIENTSECRETVALUE" ;
      edtavOauth20redirecturltag_Internalname = sPrefix+"vOAUTH20REDIRECTURLTAG" ;
      edtavOauth20redirecturlvalue_Internalname = sPrefix+"vOAUTH20REDIRECTURLVALUE" ;
      chkavOauth20redirecturliscustom.setInternalname( sPrefix+"vOAUTH20REDIRECTURLISCUSTOM" );
      chkavOauth20redirecttoauthenticate.setInternalname( sPrefix+"vOAUTH20REDIRECTTOAUTHENTICATE" );
      divUnnamedtable12_Internalname = sPrefix+"UNNAMEDTABLE12" ;
      lblAuthorization_title_Internalname = sPrefix+"AUTHORIZATION_TITLE" ;
      edtavAuthorizeurl_Internalname = sPrefix+"vAUTHORIZEURL" ;
      chkavAuthresptypeinclude.setInternalname( sPrefix+"vAUTHRESPTYPEINCLUDE" );
      edtavAuthresptypetag_Internalname = sPrefix+"vAUTHRESPTYPETAG" ;
      edtavAuthresptypevalue_Internalname = sPrefix+"vAUTHRESPTYPEVALUE" ;
      chkavAuthscopeinclude.setInternalname( sPrefix+"vAUTHSCOPEINCLUDE" );
      edtavAuthscopetag_Internalname = sPrefix+"vAUTHSCOPETAG" ;
      edtavAuthscopevalue_Internalname = sPrefix+"vAUTHSCOPEVALUE" ;
      chkavAuthstateinclude.setInternalname( sPrefix+"vAUTHSTATEINCLUDE" );
      edtavAuthstatetag_Internalname = sPrefix+"vAUTHSTATETAG" ;
      chkavAuthclientidinclude.setInternalname( sPrefix+"vAUTHCLIENTIDINCLUDE" );
      chkavAuthclientsecretinclude.setInternalname( sPrefix+"vAUTHCLIENTSECRETINCLUDE" );
      chkavAuthredirurlinclude.setInternalname( sPrefix+"vAUTHREDIRURLINCLUDE" );
      edtavAuthadditionalparameters_Internalname = sPrefix+"vAUTHADDITIONALPARAMETERS" ;
      edtavAuthadditionalparameterssd_Internalname = sPrefix+"vAUTHADDITIONALPARAMETERSSD" ;
      edtavAuthresponseaccesscodetag_Internalname = sPrefix+"vAUTHRESPONSEACCESSCODETAG" ;
      edtavAuthresponseerrordesctag_Internalname = sPrefix+"vAUTHRESPONSEERRORDESCTAG" ;
      divUnnamedtable11_Internalname = sPrefix+"UNNAMEDTABLE11" ;
      Dvpanel_unnamedtable11_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE11" ;
      divUnnamedtable10_Internalname = sPrefix+"UNNAMEDTABLE10" ;
      Dvpanel_unnamedtable10_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE10" ;
      divUnnamedtable9_Internalname = sPrefix+"UNNAMEDTABLE9" ;
      lblToken_title_Internalname = sPrefix+"TOKEN_TITLE" ;
      edtavTokenurl_Internalname = sPrefix+"vTOKENURL" ;
      cmbavTokenmethod.setInternalname( sPrefix+"vTOKENMETHOD" );
      edtavTokenheaderkeytag_Internalname = sPrefix+"vTOKENHEADERKEYTAG" ;
      edtavTokenheaderkeyvalue_Internalname = sPrefix+"vTOKENHEADERKEYVALUE" ;
      chkavTokenheaderauthenticationinclude.setInternalname( sPrefix+"vTOKENHEADERAUTHENTICATIONINCLUDE" );
      cmbavTokenheaderauthenticationmethod.setInternalname( sPrefix+"vTOKENHEADERAUTHENTICATIONMETHOD" );
      edtavTokenheaderauthenticationrealm_Internalname = sPrefix+"vTOKENHEADERAUTHENTICATIONREALM" ;
      chkavTokenheaderauthorizationbasicinclude.setInternalname( sPrefix+"vTOKENHEADERAUTHORIZATIONBASICINCLUDE" );
      chkavTokengranttypeinclude.setInternalname( sPrefix+"vTOKENGRANTTYPEINCLUDE" );
      edtavTokengranttypetag_Internalname = sPrefix+"vTOKENGRANTTYPETAG" ;
      edtavTokengranttypevalue_Internalname = sPrefix+"vTOKENGRANTTYPEVALUE" ;
      chkavTokenaccesscodeinclude.setInternalname( sPrefix+"vTOKENACCESSCODEINCLUDE" );
      chkavTokencliidinclude.setInternalname( sPrefix+"vTOKENCLIIDINCLUDE" );
      chkavTokenclisecretinclude.setInternalname( sPrefix+"vTOKENCLISECRETINCLUDE" );
      chkavTokenredirecturlinclude.setInternalname( sPrefix+"vTOKENREDIRECTURLINCLUDE" );
      edtavTokenadditionalparameters_Internalname = sPrefix+"vTOKENADDITIONALPARAMETERS" ;
      edtavTokenresponseaccesstokentag_Internalname = sPrefix+"vTOKENRESPONSEACCESSTOKENTAG" ;
      edtavTokenresponsetokentypetag_Internalname = sPrefix+"vTOKENRESPONSETOKENTYPETAG" ;
      edtavTokenresponseexpiresintag_Internalname = sPrefix+"vTOKENRESPONSEEXPIRESINTAG" ;
      edtavTokenresponsescopetag_Internalname = sPrefix+"vTOKENRESPONSESCOPETAG" ;
      edtavTokenresponseuseridtag_Internalname = sPrefix+"vTOKENRESPONSEUSERIDTAG" ;
      edtavTokenresponserefreshtokentag_Internalname = sPrefix+"vTOKENRESPONSEREFRESHTOKENTAG" ;
      edtavTokenresponseerrordescriptiontag_Internalname = sPrefix+"vTOKENRESPONSEERRORDESCRIPTIONTAG" ;
      divUnnamedtable7_Internalname = sPrefix+"UNNAMEDTABLE7" ;
      Dvpanel_unnamedtable7_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE7" ;
      chkavAutovalidateexternaltokenandrefresh.setInternalname( sPrefix+"vAUTOVALIDATEEXTERNALTOKENANDREFRESH" );
      edtavTokenrefreshtokenurl_Internalname = sPrefix+"vTOKENREFRESHTOKENURL" ;
      divUnnamedtable8_Internalname = sPrefix+"UNNAMEDTABLE8" ;
      Dvpanel_unnamedtable8_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE8" ;
      divUnnamedtable6_Internalname = sPrefix+"UNNAMEDTABLE6" ;
      Dvpanel_unnamedtable6_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE6" ;
      divUnnamedtable5_Internalname = sPrefix+"UNNAMEDTABLE5" ;
      lblUserinfo_title_Internalname = sPrefix+"USERINFO_TITLE" ;
      edtavUserinfourl_Internalname = sPrefix+"vUSERINFOURL" ;
      cmbavUserinfomethod.setInternalname( sPrefix+"vUSERINFOMETHOD" );
      edtavUserinfoheaderkeytag_Internalname = sPrefix+"vUSERINFOHEADERKEYTAG" ;
      edtavUserinfoheaderkeyvalue_Internalname = sPrefix+"vUSERINFOHEADERKEYVALUE" ;
      chkavUserinfoaccesstokeninclude.setInternalname( sPrefix+"vUSERINFOACCESSTOKENINCLUDE" );
      edtavUserinfoaccesstokenname_Internalname = sPrefix+"vUSERINFOACCESSTOKENNAME" ;
      chkavUserinfoclientidinclude.setInternalname( sPrefix+"vUSERINFOCLIENTIDINCLUDE" );
      edtavUserinfoclientidname_Internalname = sPrefix+"vUSERINFOCLIENTIDNAME" ;
      chkavUserinfoclientsecretinclude.setInternalname( sPrefix+"vUSERINFOCLIENTSECRETINCLUDE" );
      edtavUserinfoclientsecretname_Internalname = sPrefix+"vUSERINFOCLIENTSECRETNAME" ;
      chkavUserinfouseridinclude.setInternalname( sPrefix+"vUSERINFOUSERIDINCLUDE" );
      edtavUserinfoadditionalparameters_Internalname = sPrefix+"vUSERINFOADDITIONALPARAMETERS" ;
      edtavUserinforesponseuseremailtag_Internalname = sPrefix+"vUSERINFORESPONSEUSEREMAILTAG" ;
      edtavUserinforesponseuserverifiedemailtag_Internalname = sPrefix+"vUSERINFORESPONSEUSERVERIFIEDEMAILTAG" ;
      edtavUserinforesponseuserexternalidtag_Internalname = sPrefix+"vUSERINFORESPONSEUSEREXTERNALIDTAG" ;
      edtavUserinforesponseusernametag_Internalname = sPrefix+"vUSERINFORESPONSEUSERNAMETAG" ;
      edtavUserinforesponseuserfirstnametag_Internalname = sPrefix+"vUSERINFORESPONSEUSERFIRSTNAMETAG" ;
      chkavUserinforesponseuserlastnamegenauto.setInternalname( sPrefix+"vUSERINFORESPONSEUSERLASTNAMEGENAUTO" );
      lblTextblockuserinforesponseuserlastnametag_Internalname = sPrefix+"TEXTBLOCKUSERINFORESPONSEUSERLASTNAMETAG" ;
      divTextblockuserinforesponseuserlastnametag_cell_Internalname = sPrefix+"TEXTBLOCKUSERINFORESPONSEUSERLASTNAMETAG_CELL" ;
      edtavUserinforesponseuserlastnametag_Internalname = sPrefix+"vUSERINFORESPONSEUSERLASTNAMETAG" ;
      cellUserinforesponseuserlastnametag_cell_Internalname = sPrefix+"USERINFORESPONSEUSERLASTNAMETAG_CELL" ;
      lblTbuserlastnamehelp_Internalname = sPrefix+"TBUSERLASTNAMEHELP" ;
      tblTablemergeduserinforesponseuserlastnametag_Internalname = sPrefix+"TABLEMERGEDUSERINFORESPONSEUSERLASTNAMETAG" ;
      divTablesplitteduserinforesponseuserlastnametag_Internalname = sPrefix+"TABLESPLITTEDUSERINFORESPONSEUSERLASTNAMETAG" ;
      edtavUserinforesponseusergendertag_Internalname = sPrefix+"vUSERINFORESPONSEUSERGENDERTAG" ;
      edtavUserinforesponseusergendervalues_Internalname = sPrefix+"vUSERINFORESPONSEUSERGENDERVALUES" ;
      edtavUserinforesponseuserbirthdaytag_Internalname = sPrefix+"vUSERINFORESPONSEUSERBIRTHDAYTAG" ;
      edtavUserinforesponseuserurlimagetag_Internalname = sPrefix+"vUSERINFORESPONSEUSERURLIMAGETAG" ;
      edtavUserinforesponseuserurlprofiletag_Internalname = sPrefix+"vUSERINFORESPONSEUSERURLPROFILETAG" ;
      edtavUserinforesponseuserlanguagetag_Internalname = sPrefix+"vUSERINFORESPONSEUSERLANGUAGETAG" ;
      edtavUserinforesponseusertimezonetag_Internalname = sPrefix+"vUSERINFORESPONSEUSERTIMEZONETAG" ;
      edtavUserinforesponseerrordescriptiontag_Internalname = sPrefix+"vUSERINFORESPONSEERRORDESCRIPTIONTAG" ;
      divUnnamedtable3_Internalname = sPrefix+"UNNAMEDTABLE3" ;
      Dvpanel_unnamedtable3_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE3" ;
      edtavDynamicpropname_Internalname = sPrefix+"vDYNAMICPROPNAME" ;
      edtavDynamicproptag_Internalname = sPrefix+"vDYNAMICPROPTAG" ;
      edtavDeleteproperty_Internalname = sPrefix+"vDELETEPROPERTY" ;
      bttBtnadd_Internalname = sPrefix+"BTNADD" ;
      divUnnamedtable4_Internalname = sPrefix+"UNNAMEDTABLE4" ;
      Dvpanel_unnamedtable4_Internalname = sPrefix+"DVPANEL_UNNAMEDTABLE4" ;
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
      edtavDeleteproperty_Enabled = 1 ;
      edtavDeleteproperty_Tooltiptext = "" ;
      edtavDynamicproptag_Jsonclick = "" ;
      edtavDynamicpropname_Jsonclick = "" ;
      subGrid_Class = "WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavUserinforesponseuserlastnametag_Jsonclick = "" ;
      cellUserinforesponseuserlastnametag_cell_Class = "" ;
      lblTbuserlastnamehelp_Caption = httpContext.getMessage( "WWP_GAM_GenerateLastNameAutomatically", "") ;
      edtavUserinforesponseuserlastnametag_Visible = 1 ;
      edtavDynamicproptag_Visible = -1 ;
      edtavDynamicproptag_Enabled = 1 ;
      edtavDynamicpropname_Visible = -1 ;
      edtavDynamicpropname_Enabled = 1 ;
      edtavDeleteproperty_Visible = -1 ;
      edtavDeleteproperty_gximage = "" ;
      edtavUserinforesponseuserlastnametag_Enabled = 1 ;
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
      divTextblockuserinforesponseuserlastnametag_cell_Class = "col-xs-12" ;
      chkavUserinforesponseuserlastnamegenauto.setEnabled( 1 );
      edtavUserinforesponseuserfirstnametag_Jsonclick = "" ;
      edtavUserinforesponseuserfirstnametag_Enabled = 1 ;
      edtavUserinforesponseusernametag_Jsonclick = "" ;
      edtavUserinforesponseusernametag_Enabled = 1 ;
      edtavUserinforesponseuserexternalidtag_Jsonclick = "" ;
      edtavUserinforesponseuserexternalidtag_Enabled = 1 ;
      edtavUserinforesponseuserverifiedemailtag_Jsonclick = "" ;
      edtavUserinforesponseuserverifiedemailtag_Enabled = 1 ;
      edtavUserinforesponseuseremailtag_Jsonclick = "" ;
      edtavUserinforesponseuseremailtag_Enabled = 1 ;
      edtavUserinfoadditionalparameters_Jsonclick = "" ;
      edtavUserinfoadditionalparameters_Enabled = 1 ;
      chkavUserinfouseridinclude.setEnabled( 1 );
      edtavUserinfoclientsecretname_Jsonclick = "" ;
      edtavUserinfoclientsecretname_Enabled = 1 ;
      chkavUserinfoclientsecretinclude.setEnabled( 1 );
      edtavUserinfoclientidname_Jsonclick = "" ;
      edtavUserinfoclientidname_Enabled = 1 ;
      chkavUserinfoclientidinclude.setEnabled( 1 );
      edtavUserinfoaccesstokenname_Jsonclick = "" ;
      edtavUserinfoaccesstokenname_Enabled = 1 ;
      chkavUserinfoaccesstokeninclude.setEnabled( 1 );
      edtavUserinfoheaderkeyvalue_Jsonclick = "" ;
      edtavUserinfoheaderkeyvalue_Enabled = 1 ;
      edtavUserinfoheaderkeytag_Jsonclick = "" ;
      edtavUserinfoheaderkeytag_Enabled = 1 ;
      cmbavUserinfomethod.setJsonclick( "" );
      cmbavUserinfomethod.setEnabled( 1 );
      edtavUserinfourl_Jsonclick = "" ;
      edtavUserinfourl_Enabled = 1 ;
      edtavTokenrefreshtokenurl_Jsonclick = "" ;
      edtavTokenrefreshtokenurl_Enabled = 1 ;
      chkavAutovalidateexternaltokenandrefresh.setEnabled( 1 );
      edtavTokenresponseerrordescriptiontag_Jsonclick = "" ;
      edtavTokenresponseerrordescriptiontag_Enabled = 1 ;
      edtavTokenresponserefreshtokentag_Jsonclick = "" ;
      edtavTokenresponserefreshtokentag_Enabled = 1 ;
      edtavTokenresponseuseridtag_Jsonclick = "" ;
      edtavTokenresponseuseridtag_Enabled = 1 ;
      edtavTokenresponsescopetag_Jsonclick = "" ;
      edtavTokenresponsescopetag_Enabled = 1 ;
      edtavTokenresponseexpiresintag_Jsonclick = "" ;
      edtavTokenresponseexpiresintag_Enabled = 1 ;
      edtavTokenresponsetokentypetag_Jsonclick = "" ;
      edtavTokenresponsetokentypetag_Enabled = 1 ;
      edtavTokenresponseaccesstokentag_Jsonclick = "" ;
      edtavTokenresponseaccesstokentag_Enabled = 1 ;
      edtavTokenadditionalparameters_Jsonclick = "" ;
      edtavTokenadditionalparameters_Enabled = 1 ;
      chkavTokenredirecturlinclude.setEnabled( 1 );
      chkavTokenclisecretinclude.setEnabled( 1 );
      chkavTokencliidinclude.setEnabled( 1 );
      chkavTokenaccesscodeinclude.setEnabled( 1 );
      edtavTokengranttypevalue_Jsonclick = "" ;
      edtavTokengranttypevalue_Enabled = 1 ;
      edtavTokengranttypetag_Jsonclick = "" ;
      edtavTokengranttypetag_Enabled = 1 ;
      chkavTokengranttypeinclude.setEnabled( 1 );
      chkavTokenheaderauthorizationbasicinclude.setEnabled( 1 );
      edtavTokenheaderauthenticationrealm_Jsonclick = "" ;
      edtavTokenheaderauthenticationrealm_Enabled = 1 ;
      cmbavTokenheaderauthenticationmethod.setJsonclick( "" );
      cmbavTokenheaderauthenticationmethod.setEnabled( 1 );
      chkavTokenheaderauthenticationinclude.setEnabled( 1 );
      edtavTokenheaderkeyvalue_Jsonclick = "" ;
      edtavTokenheaderkeyvalue_Enabled = 1 ;
      edtavTokenheaderkeytag_Jsonclick = "" ;
      edtavTokenheaderkeytag_Enabled = 1 ;
      cmbavTokenmethod.setJsonclick( "" );
      cmbavTokenmethod.setEnabled( 1 );
      edtavTokenurl_Jsonclick = "" ;
      edtavTokenurl_Enabled = 1 ;
      edtavAuthresponseerrordesctag_Jsonclick = "" ;
      edtavAuthresponseerrordesctag_Enabled = 1 ;
      edtavAuthresponseaccesscodetag_Jsonclick = "" ;
      edtavAuthresponseaccesscodetag_Enabled = 1 ;
      edtavAuthadditionalparameterssd_Jsonclick = "" ;
      edtavAuthadditionalparameterssd_Enabled = 1 ;
      edtavAuthadditionalparameters_Jsonclick = "" ;
      edtavAuthadditionalparameters_Enabled = 1 ;
      chkavAuthredirurlinclude.setEnabled( 1 );
      chkavAuthclientsecretinclude.setEnabled( 1 );
      chkavAuthclientidinclude.setEnabled( 1 );
      edtavAuthstatetag_Jsonclick = "" ;
      edtavAuthstatetag_Enabled = 1 ;
      chkavAuthstateinclude.setEnabled( 1 );
      edtavAuthscopevalue_Jsonclick = "" ;
      edtavAuthscopevalue_Enabled = 1 ;
      edtavAuthscopetag_Jsonclick = "" ;
      edtavAuthscopetag_Enabled = 1 ;
      chkavAuthscopeinclude.setEnabled( 1 );
      edtavAuthresptypevalue_Jsonclick = "" ;
      edtavAuthresptypevalue_Enabled = 1 ;
      edtavAuthresptypetag_Jsonclick = "" ;
      edtavAuthresptypetag_Enabled = 1 ;
      chkavAuthresptypeinclude.setEnabled( 1 );
      edtavAuthorizeurl_Jsonclick = "" ;
      edtavAuthorizeurl_Enabled = 1 ;
      chkavOauth20redirecttoauthenticate.setEnabled( 1 );
      chkavOauth20redirecturliscustom.setEnabled( 1 );
      edtavOauth20redirecturlvalue_Jsonclick = "" ;
      edtavOauth20redirecturlvalue_Enabled = 1 ;
      edtavOauth20redirecturltag_Jsonclick = "" ;
      edtavOauth20redirecturltag_Enabled = 1 ;
      edtavOauth20clientsecretvalue_Jsonclick = "" ;
      edtavOauth20clientsecretvalue_Enabled = 1 ;
      edtavOauth20clientsecrettag_Jsonclick = "" ;
      edtavOauth20clientsecrettag_Enabled = 1 ;
      edtavOauth20clientidvalue_Jsonclick = "" ;
      edtavOauth20clientidvalue_Enabled = 1 ;
      edtavOauth20clientidtag_Jsonclick = "" ;
      edtavOauth20clientidtag_Enabled = 1 ;
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
      Gxuitabspanel_tabs_Pagecount = 4 ;
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Title = httpContext.getMessage( "WWP_GAM_AdvancedConfiguration", "") ;
      Dvpanel_unnamedtable2_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      Dvpanel_unnamedtable4_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Iconposition = "Right" ;
      Dvpanel_unnamedtable4_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Title = httpContext.getMessage( "WWP_GAM_CustomUserAttributes", "") ;
      Dvpanel_unnamedtable4_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable4_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable4_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable4_Width = "100%" ;
      Dvpanel_unnamedtable3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Iconposition = "Right" ;
      Dvpanel_unnamedtable3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Title = httpContext.getMessage( "WWP_GAM_Response", "") ;
      Dvpanel_unnamedtable3_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Width = "100%" ;
      Dvpanel_unnamedtable6_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Iconposition = "Right" ;
      Dvpanel_unnamedtable6_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_unnamedtable6_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable6_Title = httpContext.getMessage( "WWP_GAM_AdvancedConfiguration", "") ;
      Dvpanel_unnamedtable6_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable6_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable6_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Width = "100%" ;
      Dvpanel_unnamedtable8_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Iconposition = "Right" ;
      Dvpanel_unnamedtable8_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable8_Title = httpContext.getMessage( "WWP_GAM_RefreshToken", "") ;
      Dvpanel_unnamedtable8_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable8_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable8_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable8_Width = "100%" ;
      Dvpanel_unnamedtable7_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Iconposition = "Right" ;
      Dvpanel_unnamedtable7_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable7_Title = httpContext.getMessage( "WWP_GAM_Response", "") ;
      Dvpanel_unnamedtable7_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable7_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable7_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Width = "100%" ;
      Dvpanel_unnamedtable10_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable10_Iconposition = "Right" ;
      Dvpanel_unnamedtable10_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable10_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_unnamedtable10_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable10_Title = httpContext.getMessage( "WWP_GAM_AdvancedConfiguration", "") ;
      Dvpanel_unnamedtable10_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable10_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable10_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable10_Width = "100%" ;
      Dvpanel_unnamedtable11_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable11_Iconposition = "Right" ;
      Dvpanel_unnamedtable11_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable11_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable11_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable11_Title = httpContext.getMessage( "WWP_GAM_Response", "") ;
      Dvpanel_unnamedtable11_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable11_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable11_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable11_Width = "100%" ;
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
      chkavIsenable.setCaption( httpContext.getMessage( "WWP_GAM_Enabled", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavIsenable.getInternalname(), "TitleCaption", chkavIsenable.getCaption(), true);
      chkavIsenable.setCheckedValue( "false" );
      chkavOauth20redirecturliscustom.setName( "vOAUTH20REDIRECTURLISCUSTOM" );
      chkavOauth20redirecturliscustom.setWebtags( "" );
      chkavOauth20redirecturliscustom.setCaption( httpContext.getMessage( "WWP_GAM_CustomRedirectURL", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOauth20redirecturliscustom.getInternalname(), "TitleCaption", chkavOauth20redirecturliscustom.getCaption(), true);
      chkavOauth20redirecturliscustom.setCheckedValue( "false" );
      chkavOauth20redirecttoauthenticate.setName( "vOAUTH20REDIRECTTOAUTHENTICATE" );
      chkavOauth20redirecttoauthenticate.setWebtags( "" );
      chkavOauth20redirecttoauthenticate.setCaption( httpContext.getMessage( "WWP_GAM_RedirectToAuthenticate", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavOauth20redirecttoauthenticate.getInternalname(), "TitleCaption", chkavOauth20redirecttoauthenticate.getCaption(), true);
      chkavOauth20redirecttoauthenticate.setCheckedValue( "false" );
      chkavAuthresptypeinclude.setName( "vAUTHRESPTYPEINCLUDE" );
      chkavAuthresptypeinclude.setWebtags( "" );
      chkavAuthresptypeinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeResponseType", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthresptypeinclude.getInternalname(), "TitleCaption", chkavAuthresptypeinclude.getCaption(), true);
      chkavAuthresptypeinclude.setCheckedValue( "false" );
      chkavAuthscopeinclude.setName( "vAUTHSCOPEINCLUDE" );
      chkavAuthscopeinclude.setWebtags( "" );
      chkavAuthscopeinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeScope", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthscopeinclude.getInternalname(), "TitleCaption", chkavAuthscopeinclude.getCaption(), true);
      chkavAuthscopeinclude.setCheckedValue( "false" );
      chkavAuthstateinclude.setName( "vAUTHSTATEINCLUDE" );
      chkavAuthstateinclude.setWebtags( "" );
      chkavAuthstateinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeState", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthstateinclude.getInternalname(), "TitleCaption", chkavAuthstateinclude.getCaption(), true);
      chkavAuthstateinclude.setCheckedValue( "false" );
      chkavAuthclientidinclude.setName( "vAUTHCLIENTIDINCLUDE" );
      chkavAuthclientidinclude.setWebtags( "" );
      chkavAuthclientidinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeClientId", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthclientidinclude.getInternalname(), "TitleCaption", chkavAuthclientidinclude.getCaption(), true);
      chkavAuthclientidinclude.setCheckedValue( "false" );
      chkavAuthclientsecretinclude.setName( "vAUTHCLIENTSECRETINCLUDE" );
      chkavAuthclientsecretinclude.setWebtags( "" );
      chkavAuthclientsecretinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeClientSecret", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthclientsecretinclude.getInternalname(), "TitleCaption", chkavAuthclientsecretinclude.getCaption(), true);
      chkavAuthclientsecretinclude.setCheckedValue( "false" );
      chkavAuthredirurlinclude.setName( "vAUTHREDIRURLINCLUDE" );
      chkavAuthredirurlinclude.setWebtags( "" );
      chkavAuthredirurlinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeRedirectURL", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAuthredirurlinclude.getInternalname(), "TitleCaption", chkavAuthredirurlinclude.getCaption(), true);
      chkavAuthredirurlinclude.setCheckedValue( "false" );
      cmbavTokenmethod.setName( "vTOKENMETHOD" );
      cmbavTokenmethod.setWebtags( "" );
      cmbavTokenmethod.addItem("POST", httpContext.getMessage( "WWP_GAM_Post", ""), (short)(0));
      cmbavTokenmethod.addItem("GET", httpContext.getMessage( "WWP_GAM_Get", ""), (short)(0));
      if ( cmbavTokenmethod.getItemCount() > 0 )
      {
      }
      chkavTokenheaderauthenticationinclude.setName( "vTOKENHEADERAUTHENTICATIONINCLUDE" );
      chkavTokenheaderauthenticationinclude.setWebtags( "" );
      chkavTokenheaderauthenticationinclude.setCaption( httpContext.getMessage( "WWP_GAM_TokenHeaderAuthenticationInclude", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenheaderauthenticationinclude.getInternalname(), "TitleCaption", chkavTokenheaderauthenticationinclude.getCaption(), true);
      chkavTokenheaderauthenticationinclude.setCheckedValue( "false" );
      cmbavTokenheaderauthenticationmethod.setName( "vTOKENHEADERAUTHENTICATIONMETHOD" );
      cmbavTokenheaderauthenticationmethod.setWebtags( "" );
      cmbavTokenheaderauthenticationmethod.addItem("0", httpContext.getMessage( "Basic", ""), (short)(0));
      cmbavTokenheaderauthenticationmethod.addItem("1", httpContext.getMessage( "Digest", ""), (short)(0));
      cmbavTokenheaderauthenticationmethod.addItem("2", httpContext.getMessage( "NTLM", ""), (short)(0));
      cmbavTokenheaderauthenticationmethod.addItem("3", httpContext.getMessage( "Kerberos", ""), (short)(0));
      if ( cmbavTokenheaderauthenticationmethod.getItemCount() > 0 )
      {
      }
      chkavTokenheaderauthorizationbasicinclude.setName( "vTOKENHEADERAUTHORIZATIONBASICINCLUDE" );
      chkavTokenheaderauthorizationbasicinclude.setWebtags( "" );
      chkavTokenheaderauthorizationbasicinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeAuthorizationHeaderBasicValue", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenheaderauthorizationbasicinclude.getInternalname(), "TitleCaption", chkavTokenheaderauthorizationbasicinclude.getCaption(), true);
      chkavTokenheaderauthorizationbasicinclude.setCheckedValue( "false" );
      chkavTokengranttypeinclude.setName( "vTOKENGRANTTYPEINCLUDE" );
      chkavTokengranttypeinclude.setWebtags( "" );
      chkavTokengranttypeinclude.setCaption( httpContext.getMessage( "WWP_GAM_GrantType", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokengranttypeinclude.getInternalname(), "TitleCaption", chkavTokengranttypeinclude.getCaption(), true);
      chkavTokengranttypeinclude.setCheckedValue( "false" );
      chkavTokenaccesscodeinclude.setName( "vTOKENACCESSCODEINCLUDE" );
      chkavTokenaccesscodeinclude.setWebtags( "" );
      chkavTokenaccesscodeinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeAccessCode", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenaccesscodeinclude.getInternalname(), "TitleCaption", chkavTokenaccesscodeinclude.getCaption(), true);
      chkavTokenaccesscodeinclude.setCheckedValue( "false" );
      chkavTokencliidinclude.setName( "vTOKENCLIIDINCLUDE" );
      chkavTokencliidinclude.setWebtags( "" );
      chkavTokencliidinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeClientId", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokencliidinclude.getInternalname(), "TitleCaption", chkavTokencliidinclude.getCaption(), true);
      chkavTokencliidinclude.setCheckedValue( "false" );
      chkavTokenclisecretinclude.setName( "vTOKENCLISECRETINCLUDE" );
      chkavTokenclisecretinclude.setWebtags( "" );
      chkavTokenclisecretinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeClientSecret", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenclisecretinclude.getInternalname(), "TitleCaption", chkavTokenclisecretinclude.getCaption(), true);
      chkavTokenclisecretinclude.setCheckedValue( "false" );
      chkavTokenredirecturlinclude.setName( "vTOKENREDIRECTURLINCLUDE" );
      chkavTokenredirecturlinclude.setWebtags( "" );
      chkavTokenredirecturlinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeRedirectURL", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavTokenredirecturlinclude.getInternalname(), "TitleCaption", chkavTokenredirecturlinclude.getCaption(), true);
      chkavTokenredirecturlinclude.setCheckedValue( "false" );
      chkavAutovalidateexternaltokenandrefresh.setName( "vAUTOVALIDATEEXTERNALTOKENANDREFRESH" );
      chkavAutovalidateexternaltokenandrefresh.setWebtags( "" );
      chkavAutovalidateexternaltokenandrefresh.setCaption( httpContext.getMessage( "WWP_GAM_ValidateExternalToken", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavAutovalidateexternaltokenandrefresh.getInternalname(), "TitleCaption", chkavAutovalidateexternaltokenandrefresh.getCaption(), true);
      chkavAutovalidateexternaltokenandrefresh.setCheckedValue( "false" );
      cmbavUserinfomethod.setName( "vUSERINFOMETHOD" );
      cmbavUserinfomethod.setWebtags( "" );
      cmbavUserinfomethod.addItem("POST", httpContext.getMessage( "WWP_GAM_Post", ""), (short)(0));
      cmbavUserinfomethod.addItem("GET", httpContext.getMessage( "WWP_GAM_Get", ""), (short)(0));
      if ( cmbavUserinfomethod.getItemCount() > 0 )
      {
      }
      chkavUserinfoaccesstokeninclude.setName( "vUSERINFOACCESSTOKENINCLUDE" );
      chkavUserinfoaccesstokeninclude.setWebtags( "" );
      chkavUserinfoaccesstokeninclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeAccessToken", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfoaccesstokeninclude.getInternalname(), "TitleCaption", chkavUserinfoaccesstokeninclude.getCaption(), true);
      chkavUserinfoaccesstokeninclude.setCheckedValue( "false" );
      chkavUserinfoclientidinclude.setName( "vUSERINFOCLIENTIDINCLUDE" );
      chkavUserinfoclientidinclude.setWebtags( "" );
      chkavUserinfoclientidinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeClientId", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfoclientidinclude.getInternalname(), "TitleCaption", chkavUserinfoclientidinclude.getCaption(), true);
      chkavUserinfoclientidinclude.setCheckedValue( "false" );
      chkavUserinfoclientsecretinclude.setName( "vUSERINFOCLIENTSECRETINCLUDE" );
      chkavUserinfoclientsecretinclude.setWebtags( "" );
      chkavUserinfoclientsecretinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeClientSecret", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfoclientsecretinclude.getInternalname(), "TitleCaption", chkavUserinfoclientsecretinclude.getCaption(), true);
      chkavUserinfoclientsecretinclude.setCheckedValue( "false" );
      chkavUserinfouseridinclude.setName( "vUSERINFOUSERIDINCLUDE" );
      chkavUserinfouseridinclude.setWebtags( "" );
      chkavUserinfouseridinclude.setCaption( httpContext.getMessage( "WWP_GAM_IncludeUserId", "") );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavUserinfouseridinclude.getInternalname(), "TitleCaption", chkavUserinfouseridinclude.getCaption(), true);
      chkavUserinfouseridinclude.setCheckedValue( "false" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'sPrefix'},{av:'AV33IsEnable',fld:'vISENABLE',pic:''},{av:'AV40Oauth20RedirectURLisCustom',fld:'vOAUTH20REDIRECTURLISCUSTOM',pic:''},{av:'AV39Oauth20RedirectToAuthenticate',fld:'vOAUTH20REDIRECTTOAUTHENTICATE',pic:''},{av:'AV14AuthRespTypeInclude',fld:'vAUTHRESPTYPEINCLUDE',pic:''},{av:'AV17AuthScopeInclude',fld:'vAUTHSCOPEINCLUDE',pic:''},{av:'AV98AuthStateInclude',fld:'vAUTHSTATEINCLUDE',pic:''},{av:'AV7AuthClientIdInclude',fld:'vAUTHCLIENTIDINCLUDE',pic:''},{av:'AV8AuthClientSecretInclude',fld:'vAUTHCLIENTSECRETINCLUDE',pic:''},{av:'AV99AuthRedirURLInclude',fld:'vAUTHREDIRURLINCLUDE',pic:''},{av:'AV51TokenHeaderAuthenticationInclude',fld:'vTOKENHEADERAUTHENTICATIONINCLUDE',pic:''},{av:'AV54TokenHeaderAuthorizationBasicInclude',fld:'vTOKENHEADERAUTHORIZATIONBASICINCLUDE',pic:''},{av:'AV48TokenGrantTypeInclude',fld:'vTOKENGRANTTYPEINCLUDE',pic:''},{av:'AV44TokenAccessCodeInclude',fld:'vTOKENACCESSCODEINCLUDE',pic:''},{av:'AV46TokenCliIdInclude',fld:'vTOKENCLIIDINCLUDE',pic:''},{av:'AV47TokenCliSecretInclude',fld:'vTOKENCLISECRETINCLUDE',pic:''},{av:'AV58TokenRedirectURLInclude',fld:'vTOKENREDIRECTURLINCLUDE',pic:''},{av:'AV22AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV69UserInfoAccessTokenInclude',fld:'vUSERINFOACCESSTOKENINCLUDE',pic:''},{av:'AV72UserInfoClientIdInclude',fld:'vUSERINFOCLIENTIDINCLUDE',pic:''},{av:'AV74UserInfoClientSecretInclude',fld:'vUSERINFOCLIENTSECRETINCLUDE',pic:''},{av:'AV95UserInfoUserIdInclude',fld:'vUSERINFOUSERIDINCLUDE',pic:''},{av:'AV87UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("GRID.LOAD","{handler:'e142W2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV24DeleteProperty',fld:'vDELETEPROPERTY',pic:''},{av:'AV26DynamicPropName',fld:'vDYNAMICPROPNAME',pic:''},{av:'AV27DynamicPropTag',fld:'vDYNAMICPROPTAG',pic:''},{av:'edtavDeleteproperty_Visible',ctrl:'vDELETEPROPERTY',prop:'Visible'},{av:'edtavDynamicpropname_Enabled',ctrl:'vDYNAMICPROPNAME',prop:'Enabled'},{av:'edtavDynamicproptag_Enabled',ctrl:'vDYNAMICPROPTAG',prop:'Enabled'},{av:'edtavDeleteproperty_Tooltiptext',ctrl:'vDELETEPROPERTY',prop:'Tooltiptext'}]}");
      setEventMetadata("'DOADD'","{handler:'e112W2',iparms:[]");
      setEventMetadata("'DOADD'",",oparms:[{av:'AV24DeleteProperty',fld:'vDELETEPROPERTY',pic:''},{av:'edtavDeleteproperty_Visible',ctrl:'vDELETEPROPERTY',prop:'Visible'},{av:'edtavDynamicpropname_Enabled',ctrl:'vDYNAMICPROPNAME',prop:'Enabled'},{av:'edtavDynamicpropname_Visible',ctrl:'vDYNAMICPROPNAME',prop:'Visible'},{av:'edtavDynamicproptag_Enabled',ctrl:'vDYNAMICPROPTAG',prop:'Enabled'},{av:'edtavDynamicproptag_Visible',ctrl:'vDYNAMICPROPTAG',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e122W2',iparms:[{av:'AV105CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV34Name',fld:'vNAME',pic:''},{av:'AV33IsEnable',fld:'vISENABLE',pic:''},{av:'AV25Dsc',fld:'vDSC',pic:''},{av:'AV43SmallImageName',fld:'vSMALLIMAGENAME',pic:''},{av:'AV23BigImageName',fld:'vBIGIMAGENAME',pic:''},{av:'AV32Impersonate',fld:'vIMPERSONATE',pic:''},{av:'AV35Oauth20ClientIdTag',fld:'vOAUTH20CLIENTIDTAG',pic:''},{av:'AV36Oauth20ClientIdValue',fld:'vOAUTH20CLIENTIDVALUE',pic:''},{av:'AV37Oauth20ClientSecretTag',fld:'vOAUTH20CLIENTSECRETTAG',pic:''},{av:'AV38Oauth20ClientSecretValue',fld:'vOAUTH20CLIENTSECRETVALUE',pic:''},{av:'AV41Oauth20RedirectURLTag',fld:'vOAUTH20REDIRECTURLTAG',pic:''},{av:'AV42Oauth20RedirectURLvalue',fld:'vOAUTH20REDIRECTURLVALUE',pic:''},{av:'AV40Oauth20RedirectURLisCustom',fld:'vOAUTH20REDIRECTURLISCUSTOM',pic:''},{av:'AV39Oauth20RedirectToAuthenticate',fld:'vOAUTH20REDIRECTTOAUTHENTICATE',pic:''},{av:'AV10AuthorizeURL',fld:'vAUTHORIZEURL',pic:''},{av:'AV14AuthRespTypeInclude',fld:'vAUTHRESPTYPEINCLUDE',pic:''},{av:'AV15AuthRespTypeTag',fld:'vAUTHRESPTYPETAG',pic:''},{av:'AV16AuthRespTypeValue',fld:'vAUTHRESPTYPEVALUE',pic:''},{av:'AV17AuthScopeInclude',fld:'vAUTHSCOPEINCLUDE',pic:''},{av:'AV18AuthScopeTag',fld:'vAUTHSCOPETAG',pic:''},{av:'AV19AuthScopeValue',fld:'vAUTHSCOPEVALUE',pic:''},{av:'AV98AuthStateInclude',fld:'vAUTHSTATEINCLUDE',pic:''},{av:'AV21AuthStateTag',fld:'vAUTHSTATETAG',pic:''},{av:'AV7AuthClientIdInclude',fld:'vAUTHCLIENTIDINCLUDE',pic:''},{av:'AV8AuthClientSecretInclude',fld:'vAUTHCLIENTSECRETINCLUDE',pic:''},{av:'AV99AuthRedirURLInclude',fld:'vAUTHREDIRURLINCLUDE',pic:''},{av:'AV5AuthAdditionalParameters',fld:'vAUTHADDITIONALPARAMETERS',pic:''},{av:'AV6AuthAdditionalParametersSD',fld:'vAUTHADDITIONALPARAMETERSSD',pic:''},{av:'AV12AuthResponseAccessCodeTag',fld:'vAUTHRESPONSEACCESSCODETAG',pic:''},{av:'AV13AuthResponseErrorDescTag',fld:'vAUTHRESPONSEERRORDESCTAG',pic:''},{av:'AV67TokenURL',fld:'vTOKENURL',pic:''},{av:'cmbavTokenmethod'},{av:'AV57TokenMethod',fld:'vTOKENMETHOD',pic:''},{av:'AV55TokenHeaderKeyTag',fld:'vTOKENHEADERKEYTAG',pic:''},{av:'AV56TokenHeaderKeyValue',fld:'vTOKENHEADERKEYVALUE',pic:''},{av:'AV51TokenHeaderAuthenticationInclude',fld:'vTOKENHEADERAUTHENTICATIONINCLUDE',pic:''},{av:'cmbavTokenheaderauthenticationmethod'},{av:'AV52TokenHeaderAuthenticationMethod',fld:'vTOKENHEADERAUTHENTICATIONMETHOD',pic:'ZZZ9'},{av:'AV53TokenHeaderAuthenticationRealm',fld:'vTOKENHEADERAUTHENTICATIONREALM',pic:''},{av:'AV54TokenHeaderAuthorizationBasicInclude',fld:'vTOKENHEADERAUTHORIZATIONBASICINCLUDE',pic:''},{av:'AV48TokenGrantTypeInclude',fld:'vTOKENGRANTTYPEINCLUDE',pic:''},{av:'AV49TokenGrantTypeTag',fld:'vTOKENGRANTTYPETAG',pic:''},{av:'AV50TokenGrantTypeValue',fld:'vTOKENGRANTTYPEVALUE',pic:''},{av:'AV44TokenAccessCodeInclude',fld:'vTOKENACCESSCODEINCLUDE',pic:''},{av:'AV46TokenCliIdInclude',fld:'vTOKENCLIIDINCLUDE',pic:''},{av:'AV47TokenCliSecretInclude',fld:'vTOKENCLISECRETINCLUDE',pic:''},{av:'AV58TokenRedirectURLInclude',fld:'vTOKENREDIRECTURLINCLUDE',pic:''},{av:'AV45TokenAdditionalParameters',fld:'vTOKENADDITIONALPARAMETERS',pic:''},{av:'AV60TokenResponseAccessTokenTag',fld:'vTOKENRESPONSEACCESSTOKENTAG',pic:''},{av:'AV65TokenResponseTokenTypeTag',fld:'vTOKENRESPONSETOKENTYPETAG',pic:''},{av:'AV62TokenResponseExpiresInTag',fld:'vTOKENRESPONSEEXPIRESINTAG',pic:''},{av:'AV64TokenResponseScopeTag',fld:'vTOKENRESPONSESCOPETAG',pic:''},{av:'AV66TokenResponseUserIdTag',fld:'vTOKENRESPONSEUSERIDTAG',pic:''},{av:'AV63TokenResponseRefreshTokenTag',fld:'vTOKENRESPONSEREFRESHTOKENTAG',pic:''},{av:'AV61TokenResponseErrorDescriptionTag',fld:'vTOKENRESPONSEERRORDESCRIPTIONTAG',pic:''},{av:'AV22AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV59TokenRefreshTokenURL',fld:'vTOKENREFRESHTOKENURL',pic:''},{av:'AV94UserInfoURL',fld:'vUSERINFOURL',pic:''},{av:'cmbavUserinfomethod'},{av:'AV78UserInfoMethod',fld:'vUSERINFOMETHOD',pic:''},{av:'AV76UserInfoHeaderKeyTag',fld:'vUSERINFOHEADERKEYTAG',pic:''},{av:'AV77UserInfoHeaderKeyValue',fld:'vUSERINFOHEADERKEYVALUE',pic:''},{av:'AV69UserInfoAccessTokenInclude',fld:'vUSERINFOACCESSTOKENINCLUDE',pic:''},{av:'AV70UserInfoAccessTokenName',fld:'vUSERINFOACCESSTOKENNAME',pic:''},{av:'AV72UserInfoClientIdInclude',fld:'vUSERINFOCLIENTIDINCLUDE',pic:''},{av:'AV73UserInfoClientIdName',fld:'vUSERINFOCLIENTIDNAME',pic:''},{av:'AV74UserInfoClientSecretInclude',fld:'vUSERINFOCLIENTSECRETINCLUDE',pic:''},{av:'AV75UserInfoClientSecretName',fld:'vUSERINFOCLIENTSECRETNAME',pic:''},{av:'AV95UserInfoUserIdInclude',fld:'vUSERINFOUSERIDINCLUDE',pic:''},{av:'AV71UserInfoAdditionalParameters',fld:'vUSERINFOADDITIONALPARAMETERS',pic:''},{av:'AV81UserInfoResponseUserEmailTag',fld:'vUSERINFORESPONSEUSEREMAILTAG',pic:''},{av:'AV93UserInfoResponseUserVerifiedEmailTag',fld:'vUSERINFORESPONSEUSERVERIFIEDEMAILTAG',pic:''},{av:'AV82UserInfoResponseUserExternalIdTag',fld:'vUSERINFORESPONSEUSEREXTERNALIDTAG',pic:''},{av:'AV89UserInfoResponseUserNameTag',fld:'vUSERINFORESPONSEUSERNAMETAG',pic:''},{av:'AV83UserInfoResponseUserFirstNameTag',fld:'vUSERINFORESPONSEUSERFIRSTNAMETAG',pic:''},{av:'AV87UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''},{av:'AV88UserInfoResponseUserLastNameTag',fld:'vUSERINFORESPONSEUSERLASTNAMETAG',pic:''},{av:'AV84UserInfoResponseUserGenderTag',fld:'vUSERINFORESPONSEUSERGENDERTAG',pic:''},{av:'AV85UserInfoResponseUserGenderValues',fld:'vUSERINFORESPONSEUSERGENDERVALUES',pic:''},{av:'AV80UserInfoResponseUserBirthdayTag',fld:'vUSERINFORESPONSEUSERBIRTHDAYTAG',pic:''},{av:'AV91UserInfoResponseUserURLImageTag',fld:'vUSERINFORESPONSEUSERURLIMAGETAG',pic:''},{av:'AV92UserInfoResponseUserURLProfileTag',fld:'vUSERINFORESPONSEUSERURLPROFILETAG',pic:''},{av:'AV86UserInfoResponseUserLanguageTag',fld:'vUSERINFORESPONSEUSERLANGUAGETAG',pic:''},{av:'AV90UserInfoResponseUserTimeZoneTag',fld:'vUSERINFORESPONSEUSERTIMEZONETAG',pic:''},{av:'AV79UserInfoResponseErrorDescriptionTag',fld:'vUSERINFORESPONSEERRORDESCRIPTIONTAG',pic:''},{av:'AV26DynamicPropName',fld:'vDYNAMICPROPNAME',grid:462,pic:''},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_462',ctrl:'GRID',grid:462,prop:'GridRC',grid:462},{av:'AV27DynamicPropTag',fld:'vDYNAMICPROPTAG',grid:462,pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV105CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VDELETEPROPERTY.CLICK","{handler:'e152W2',iparms:[{av:'AV34Name',fld:'vNAME',pic:''}]");
      setEventMetadata("VDELETEPROPERTY.CLICK",",oparms:[{av:'AV24DeleteProperty',fld:'vDELETEPROPERTY',pic:''},{av:'edtavDeleteproperty_Visible',ctrl:'vDELETEPROPERTY',prop:'Visible'},{av:'edtavDynamicpropname_Visible',ctrl:'vDYNAMICPROPNAME',prop:'Visible'},{av:'edtavDynamicproptag_Visible',ctrl:'vDYNAMICPROPTAG',prop:'Visible'},{av:'AV26DynamicPropName',fld:'vDYNAMICPROPNAME',pic:''},{av:'AV27DynamicPropTag',fld:'vDYNAMICPROPTAG',pic:''}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'sPrefix'},{av:'AV33IsEnable',fld:'vISENABLE',pic:''},{av:'AV40Oauth20RedirectURLisCustom',fld:'vOAUTH20REDIRECTURLISCUSTOM',pic:''},{av:'AV39Oauth20RedirectToAuthenticate',fld:'vOAUTH20REDIRECTTOAUTHENTICATE',pic:''},{av:'AV14AuthRespTypeInclude',fld:'vAUTHRESPTYPEINCLUDE',pic:''},{av:'AV17AuthScopeInclude',fld:'vAUTHSCOPEINCLUDE',pic:''},{av:'AV98AuthStateInclude',fld:'vAUTHSTATEINCLUDE',pic:''},{av:'AV7AuthClientIdInclude',fld:'vAUTHCLIENTIDINCLUDE',pic:''},{av:'AV8AuthClientSecretInclude',fld:'vAUTHCLIENTSECRETINCLUDE',pic:''},{av:'AV99AuthRedirURLInclude',fld:'vAUTHREDIRURLINCLUDE',pic:''},{av:'AV51TokenHeaderAuthenticationInclude',fld:'vTOKENHEADERAUTHENTICATIONINCLUDE',pic:''},{av:'AV54TokenHeaderAuthorizationBasicInclude',fld:'vTOKENHEADERAUTHORIZATIONBASICINCLUDE',pic:''},{av:'AV48TokenGrantTypeInclude',fld:'vTOKENGRANTTYPEINCLUDE',pic:''},{av:'AV44TokenAccessCodeInclude',fld:'vTOKENACCESSCODEINCLUDE',pic:''},{av:'AV46TokenCliIdInclude',fld:'vTOKENCLIIDINCLUDE',pic:''},{av:'AV47TokenCliSecretInclude',fld:'vTOKENCLISECRETINCLUDE',pic:''},{av:'AV58TokenRedirectURLInclude',fld:'vTOKENREDIRECTURLINCLUDE',pic:''},{av:'AV22AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV69UserInfoAccessTokenInclude',fld:'vUSERINFOACCESSTOKENINCLUDE',pic:''},{av:'AV72UserInfoClientIdInclude',fld:'vUSERINFOCLIENTIDINCLUDE',pic:''},{av:'AV74UserInfoClientSecretInclude',fld:'vUSERINFOCLIENTSECRETINCLUDE',pic:''},{av:'AV95UserInfoUserIdInclude',fld:'vUSERINFOUSERIDINCLUDE',pic:''},{av:'AV87UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'sPrefix'},{av:'AV33IsEnable',fld:'vISENABLE',pic:''},{av:'AV40Oauth20RedirectURLisCustom',fld:'vOAUTH20REDIRECTURLISCUSTOM',pic:''},{av:'AV39Oauth20RedirectToAuthenticate',fld:'vOAUTH20REDIRECTTOAUTHENTICATE',pic:''},{av:'AV14AuthRespTypeInclude',fld:'vAUTHRESPTYPEINCLUDE',pic:''},{av:'AV17AuthScopeInclude',fld:'vAUTHSCOPEINCLUDE',pic:''},{av:'AV98AuthStateInclude',fld:'vAUTHSTATEINCLUDE',pic:''},{av:'AV7AuthClientIdInclude',fld:'vAUTHCLIENTIDINCLUDE',pic:''},{av:'AV8AuthClientSecretInclude',fld:'vAUTHCLIENTSECRETINCLUDE',pic:''},{av:'AV99AuthRedirURLInclude',fld:'vAUTHREDIRURLINCLUDE',pic:''},{av:'AV51TokenHeaderAuthenticationInclude',fld:'vTOKENHEADERAUTHENTICATIONINCLUDE',pic:''},{av:'AV54TokenHeaderAuthorizationBasicInclude',fld:'vTOKENHEADERAUTHORIZATIONBASICINCLUDE',pic:''},{av:'AV48TokenGrantTypeInclude',fld:'vTOKENGRANTTYPEINCLUDE',pic:''},{av:'AV44TokenAccessCodeInclude',fld:'vTOKENACCESSCODEINCLUDE',pic:''},{av:'AV46TokenCliIdInclude',fld:'vTOKENCLIIDINCLUDE',pic:''},{av:'AV47TokenCliSecretInclude',fld:'vTOKENCLISECRETINCLUDE',pic:''},{av:'AV58TokenRedirectURLInclude',fld:'vTOKENREDIRECTURLINCLUDE',pic:''},{av:'AV22AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV69UserInfoAccessTokenInclude',fld:'vUSERINFOACCESSTOKENINCLUDE',pic:''},{av:'AV72UserInfoClientIdInclude',fld:'vUSERINFOCLIENTIDINCLUDE',pic:''},{av:'AV74UserInfoClientSecretInclude',fld:'vUSERINFOCLIENTSECRETINCLUDE',pic:''},{av:'AV95UserInfoUserIdInclude',fld:'vUSERINFOUSERIDINCLUDE',pic:''},{av:'AV87UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'sPrefix'},{av:'AV33IsEnable',fld:'vISENABLE',pic:''},{av:'AV40Oauth20RedirectURLisCustom',fld:'vOAUTH20REDIRECTURLISCUSTOM',pic:''},{av:'AV39Oauth20RedirectToAuthenticate',fld:'vOAUTH20REDIRECTTOAUTHENTICATE',pic:''},{av:'AV14AuthRespTypeInclude',fld:'vAUTHRESPTYPEINCLUDE',pic:''},{av:'AV17AuthScopeInclude',fld:'vAUTHSCOPEINCLUDE',pic:''},{av:'AV98AuthStateInclude',fld:'vAUTHSTATEINCLUDE',pic:''},{av:'AV7AuthClientIdInclude',fld:'vAUTHCLIENTIDINCLUDE',pic:''},{av:'AV8AuthClientSecretInclude',fld:'vAUTHCLIENTSECRETINCLUDE',pic:''},{av:'AV99AuthRedirURLInclude',fld:'vAUTHREDIRURLINCLUDE',pic:''},{av:'AV51TokenHeaderAuthenticationInclude',fld:'vTOKENHEADERAUTHENTICATIONINCLUDE',pic:''},{av:'AV54TokenHeaderAuthorizationBasicInclude',fld:'vTOKENHEADERAUTHORIZATIONBASICINCLUDE',pic:''},{av:'AV48TokenGrantTypeInclude',fld:'vTOKENGRANTTYPEINCLUDE',pic:''},{av:'AV44TokenAccessCodeInclude',fld:'vTOKENACCESSCODEINCLUDE',pic:''},{av:'AV46TokenCliIdInclude',fld:'vTOKENCLIIDINCLUDE',pic:''},{av:'AV47TokenCliSecretInclude',fld:'vTOKENCLISECRETINCLUDE',pic:''},{av:'AV58TokenRedirectURLInclude',fld:'vTOKENREDIRECTURLINCLUDE',pic:''},{av:'AV22AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV69UserInfoAccessTokenInclude',fld:'vUSERINFOACCESSTOKENINCLUDE',pic:''},{av:'AV72UserInfoClientIdInclude',fld:'vUSERINFOCLIENTIDINCLUDE',pic:''},{av:'AV74UserInfoClientSecretInclude',fld:'vUSERINFOCLIENTSECRETINCLUDE',pic:''},{av:'AV95UserInfoUserIdInclude',fld:'vUSERINFOUSERIDINCLUDE',pic:''},{av:'AV87UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'sPrefix'},{av:'AV33IsEnable',fld:'vISENABLE',pic:''},{av:'AV40Oauth20RedirectURLisCustom',fld:'vOAUTH20REDIRECTURLISCUSTOM',pic:''},{av:'AV39Oauth20RedirectToAuthenticate',fld:'vOAUTH20REDIRECTTOAUTHENTICATE',pic:''},{av:'AV14AuthRespTypeInclude',fld:'vAUTHRESPTYPEINCLUDE',pic:''},{av:'AV17AuthScopeInclude',fld:'vAUTHSCOPEINCLUDE',pic:''},{av:'AV98AuthStateInclude',fld:'vAUTHSTATEINCLUDE',pic:''},{av:'AV7AuthClientIdInclude',fld:'vAUTHCLIENTIDINCLUDE',pic:''},{av:'AV8AuthClientSecretInclude',fld:'vAUTHCLIENTSECRETINCLUDE',pic:''},{av:'AV99AuthRedirURLInclude',fld:'vAUTHREDIRURLINCLUDE',pic:''},{av:'AV51TokenHeaderAuthenticationInclude',fld:'vTOKENHEADERAUTHENTICATIONINCLUDE',pic:''},{av:'AV54TokenHeaderAuthorizationBasicInclude',fld:'vTOKENHEADERAUTHORIZATIONBASICINCLUDE',pic:''},{av:'AV48TokenGrantTypeInclude',fld:'vTOKENGRANTTYPEINCLUDE',pic:''},{av:'AV44TokenAccessCodeInclude',fld:'vTOKENACCESSCODEINCLUDE',pic:''},{av:'AV46TokenCliIdInclude',fld:'vTOKENCLIIDINCLUDE',pic:''},{av:'AV47TokenCliSecretInclude',fld:'vTOKENCLISECRETINCLUDE',pic:''},{av:'AV58TokenRedirectURLInclude',fld:'vTOKENREDIRECTURLINCLUDE',pic:''},{av:'AV22AutovalidateExternalTokenAndRefresh',fld:'vAUTOVALIDATEEXTERNALTOKENANDREFRESH',pic:''},{av:'AV69UserInfoAccessTokenInclude',fld:'vUSERINFOACCESSTOKENINCLUDE',pic:''},{av:'AV72UserInfoClientIdInclude',fld:'vUSERINFOCLIENTIDINCLUDE',pic:''},{av:'AV74UserInfoClientSecretInclude',fld:'vUSERINFOCLIENTSECRETINCLUDE',pic:''},{av:'AV95UserInfoUserIdInclude',fld:'vUSERINFOUSERIDINCLUDE',pic:''},{av:'AV87UserInfoResponseUserLastNameGenAuto',fld:'vUSERINFORESPONSEUSERLASTNAMEGENAUTO',pic:''}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_FUNCTIONID","{handler:'validv_Functionid',iparms:[]");
      setEventMetadata("VALIDV_FUNCTIONID",",oparms:[]}");
      setEventMetadata("VALIDV_TOKENMETHOD","{handler:'validv_Tokenmethod',iparms:[]");
      setEventMetadata("VALIDV_TOKENMETHOD",",oparms:[]}");
      setEventMetadata("VALIDV_TOKENHEADERAUTHENTICATIONMETHOD","{handler:'validv_Tokenheaderauthenticationmethod',iparms:[]");
      setEventMetadata("VALIDV_TOKENHEADERAUTHENTICATIONMETHOD",",oparms:[]}");
      setEventMetadata("VALIDV_USERINFOMETHOD","{handler:'validv_Userinfomethod',iparms:[]");
      setEventMetadata("VALIDV_USERINFOMETHOD",",oparms:[]}");
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
      wcpOAV34Name = "" ;
      wcpOAV68TypeId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      Gx_mode = "" ;
      AV34Name = "" ;
      AV68TypeId = "" ;
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
      AV30FunctionId = "" ;
      AV25Dsc = "" ;
      AV32Impersonate = "" ;
      AV43SmallImageName = "" ;
      AV23BigImageName = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      AV35Oauth20ClientIdTag = "" ;
      AV36Oauth20ClientIdValue = "" ;
      AV37Oauth20ClientSecretTag = "" ;
      AV38Oauth20ClientSecretValue = "" ;
      AV41Oauth20RedirectURLTag = "" ;
      AV42Oauth20RedirectURLvalue = "" ;
      lblAuthorization_title_Jsonclick = "" ;
      AV10AuthorizeURL = "" ;
      ucDvpanel_unnamedtable10 = new com.genexus.webpanels.GXUserControl();
      AV15AuthRespTypeTag = "" ;
      AV16AuthRespTypeValue = "" ;
      AV18AuthScopeTag = "" ;
      AV19AuthScopeValue = "" ;
      AV21AuthStateTag = "" ;
      AV5AuthAdditionalParameters = "" ;
      AV6AuthAdditionalParametersSD = "" ;
      ucDvpanel_unnamedtable11 = new com.genexus.webpanels.GXUserControl();
      AV12AuthResponseAccessCodeTag = "" ;
      AV13AuthResponseErrorDescTag = "" ;
      lblToken_title_Jsonclick = "" ;
      AV67TokenURL = "" ;
      ucDvpanel_unnamedtable6 = new com.genexus.webpanels.GXUserControl();
      AV57TokenMethod = "" ;
      AV55TokenHeaderKeyTag = "" ;
      AV56TokenHeaderKeyValue = "" ;
      AV53TokenHeaderAuthenticationRealm = "" ;
      AV49TokenGrantTypeTag = "" ;
      AV50TokenGrantTypeValue = "" ;
      AV45TokenAdditionalParameters = "" ;
      ucDvpanel_unnamedtable7 = new com.genexus.webpanels.GXUserControl();
      AV60TokenResponseAccessTokenTag = "" ;
      AV65TokenResponseTokenTypeTag = "" ;
      AV62TokenResponseExpiresInTag = "" ;
      AV64TokenResponseScopeTag = "" ;
      AV66TokenResponseUserIdTag = "" ;
      AV63TokenResponseRefreshTokenTag = "" ;
      AV61TokenResponseErrorDescriptionTag = "" ;
      ucDvpanel_unnamedtable8 = new com.genexus.webpanels.GXUserControl();
      AV59TokenRefreshTokenURL = "" ;
      lblUserinfo_title_Jsonclick = "" ;
      AV94UserInfoURL = "" ;
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      AV78UserInfoMethod = "" ;
      AV76UserInfoHeaderKeyTag = "" ;
      AV77UserInfoHeaderKeyValue = "" ;
      AV70UserInfoAccessTokenName = "" ;
      AV73UserInfoClientIdName = "" ;
      AV75UserInfoClientSecretName = "" ;
      AV71UserInfoAdditionalParameters = "" ;
      ucDvpanel_unnamedtable3 = new com.genexus.webpanels.GXUserControl();
      AV81UserInfoResponseUserEmailTag = "" ;
      AV93UserInfoResponseUserVerifiedEmailTag = "" ;
      AV82UserInfoResponseUserExternalIdTag = "" ;
      AV89UserInfoResponseUserNameTag = "" ;
      AV83UserInfoResponseUserFirstNameTag = "" ;
      lblTextblockuserinforesponseuserlastnametag_Jsonclick = "" ;
      AV84UserInfoResponseUserGenderTag = "" ;
      AV85UserInfoResponseUserGenderValues = "" ;
      AV80UserInfoResponseUserBirthdayTag = "" ;
      AV91UserInfoResponseUserURLImageTag = "" ;
      AV92UserInfoResponseUserURLProfileTag = "" ;
      AV86UserInfoResponseUserLanguageTag = "" ;
      AV90UserInfoResponseUserTimeZoneTag = "" ;
      AV79UserInfoResponseErrorDescriptionTag = "" ;
      ucDvpanel_unnamedtable4 = new com.genexus.webpanels.GXUserControl();
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
      AV26DynamicPropName = "" ;
      AV27DynamicPropTag = "" ;
      AV24DeleteProperty = "" ;
      AV110Deleteproperty_GXI = "" ;
      AV88UserInfoResponseUserLastNameTag = "" ;
      AV9AuthenticationTypeOauth20 = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOauth20(remoteHandle, context);
      AV31GAMPropertySimple = new genexus.security.api.genexussecurity.SdtGAMPropertySimple(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV29Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV28Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      lblTbuserlastnamehelp_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlGx_mode = "" ;
      sCtrlAV34Name = "" ;
      sCtrlAV68TypeId = "" ;
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwcauthenticationtypeentryoauth20__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwcauthenticationtypeentryoauth20__default(),
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
   private short AV52TokenHeaderAuthenticationMethod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_462 ;
   private int subGrid_Rows ;
   private int nGXsfl_462_idx=1 ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavImpersonate_Enabled ;
   private int edtavSmallimagename_Enabled ;
   private int edtavBigimagename_Enabled ;
   private int edtavOauth20clientidtag_Enabled ;
   private int edtavOauth20clientidvalue_Enabled ;
   private int edtavOauth20clientsecrettag_Enabled ;
   private int edtavOauth20clientsecretvalue_Enabled ;
   private int edtavOauth20redirecturltag_Enabled ;
   private int edtavOauth20redirecturlvalue_Enabled ;
   private int edtavAuthorizeurl_Enabled ;
   private int edtavAuthresptypetag_Enabled ;
   private int edtavAuthresptypevalue_Enabled ;
   private int edtavAuthscopetag_Enabled ;
   private int edtavAuthscopevalue_Enabled ;
   private int edtavAuthstatetag_Enabled ;
   private int edtavAuthadditionalparameters_Enabled ;
   private int edtavAuthadditionalparameterssd_Enabled ;
   private int edtavAuthresponseaccesscodetag_Enabled ;
   private int edtavAuthresponseerrordesctag_Enabled ;
   private int edtavTokenurl_Enabled ;
   private int edtavTokenheaderkeytag_Enabled ;
   private int edtavTokenheaderkeyvalue_Enabled ;
   private int edtavTokenheaderauthenticationrealm_Enabled ;
   private int edtavTokengranttypetag_Enabled ;
   private int edtavTokengranttypevalue_Enabled ;
   private int edtavTokenadditionalparameters_Enabled ;
   private int edtavTokenresponseaccesstokentag_Enabled ;
   private int edtavTokenresponsetokentypetag_Enabled ;
   private int edtavTokenresponseexpiresintag_Enabled ;
   private int edtavTokenresponsescopetag_Enabled ;
   private int edtavTokenresponseuseridtag_Enabled ;
   private int edtavTokenresponserefreshtokentag_Enabled ;
   private int edtavTokenresponseerrordescriptiontag_Enabled ;
   private int edtavTokenrefreshtokenurl_Enabled ;
   private int edtavUserinfourl_Enabled ;
   private int edtavUserinfoheaderkeytag_Enabled ;
   private int edtavUserinfoheaderkeyvalue_Enabled ;
   private int edtavUserinfoaccesstokenname_Enabled ;
   private int edtavUserinfoclientidname_Enabled ;
   private int edtavUserinfoclientsecretname_Enabled ;
   private int edtavUserinfoadditionalparameters_Enabled ;
   private int edtavUserinforesponseuseremailtag_Enabled ;
   private int edtavUserinforesponseuserverifiedemailtag_Enabled ;
   private int edtavUserinforesponseuserexternalidtag_Enabled ;
   private int edtavUserinforesponseusernametag_Enabled ;
   private int edtavUserinforesponseuserfirstnametag_Enabled ;
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
   private int edtavUserinforesponseuserlastnametag_Enabled ;
   private int AV109GXV1 ;
   private int edtavDeleteproperty_Visible ;
   private int edtavDynamicpropname_Enabled ;
   private int edtavDynamicproptag_Enabled ;
   private int edtavDynamicpropname_Visible ;
   private int edtavDynamicproptag_Visible ;
   private int edtavUserinforesponseuserlastnametag_Visible ;
   private int AV111GXV2 ;
   private int nGXsfl_462_fel_idx=1 ;
   private int AV113GXV3 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavDeleteproperty_Enabled ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private String wcpOGx_mode ;
   private String wcpOAV34Name ;
   private String wcpOAV68TypeId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String Gx_mode ;
   private String AV34Name ;
   private String AV68TypeId ;
   private String sGXsfl_462_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_unnamedtable11_Width ;
   private String Dvpanel_unnamedtable11_Cls ;
   private String Dvpanel_unnamedtable11_Title ;
   private String Dvpanel_unnamedtable11_Iconposition ;
   private String Dvpanel_unnamedtable10_Width ;
   private String Dvpanel_unnamedtable10_Cls ;
   private String Dvpanel_unnamedtable10_Title ;
   private String Dvpanel_unnamedtable10_Iconposition ;
   private String Dvpanel_unnamedtable7_Width ;
   private String Dvpanel_unnamedtable7_Cls ;
   private String Dvpanel_unnamedtable7_Title ;
   private String Dvpanel_unnamedtable7_Iconposition ;
   private String Dvpanel_unnamedtable8_Width ;
   private String Dvpanel_unnamedtable8_Cls ;
   private String Dvpanel_unnamedtable8_Title ;
   private String Dvpanel_unnamedtable8_Iconposition ;
   private String Dvpanel_unnamedtable6_Width ;
   private String Dvpanel_unnamedtable6_Cls ;
   private String Dvpanel_unnamedtable6_Title ;
   private String Dvpanel_unnamedtable6_Iconposition ;
   private String Dvpanel_unnamedtable3_Width ;
   private String Dvpanel_unnamedtable3_Cls ;
   private String Dvpanel_unnamedtable3_Title ;
   private String Dvpanel_unnamedtable3_Iconposition ;
   private String Dvpanel_unnamedtable4_Width ;
   private String Dvpanel_unnamedtable4_Cls ;
   private String Dvpanel_unnamedtable4_Title ;
   private String Dvpanel_unnamedtable4_Iconposition ;
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
   private String AV30FunctionId ;
   private String edtavDsc_Internalname ;
   private String AV25Dsc ;
   private String edtavDsc_Jsonclick ;
   private String edtavImpersonate_Internalname ;
   private String AV32Impersonate ;
   private String edtavImpersonate_Jsonclick ;
   private String edtavSmallimagename_Internalname ;
   private String AV43SmallImageName ;
   private String edtavSmallimagename_Jsonclick ;
   private String edtavBigimagename_Internalname ;
   private String AV23BigImageName ;
   private String edtavBigimagename_Jsonclick ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtable12_Internalname ;
   private String edtavOauth20clientidtag_Internalname ;
   private String AV35Oauth20ClientIdTag ;
   private String edtavOauth20clientidtag_Jsonclick ;
   private String edtavOauth20clientidvalue_Internalname ;
   private String edtavOauth20clientidvalue_Jsonclick ;
   private String edtavOauth20clientsecrettag_Internalname ;
   private String AV37Oauth20ClientSecretTag ;
   private String edtavOauth20clientsecrettag_Jsonclick ;
   private String edtavOauth20clientsecretvalue_Internalname ;
   private String edtavOauth20clientsecretvalue_Jsonclick ;
   private String edtavOauth20redirecturltag_Internalname ;
   private String AV41Oauth20RedirectURLTag ;
   private String edtavOauth20redirecturltag_Jsonclick ;
   private String edtavOauth20redirecturlvalue_Internalname ;
   private String edtavOauth20redirecturlvalue_Jsonclick ;
   private String lblAuthorization_title_Internalname ;
   private String lblAuthorization_title_Jsonclick ;
   private String divUnnamedtable9_Internalname ;
   private String edtavAuthorizeurl_Internalname ;
   private String edtavAuthorizeurl_Jsonclick ;
   private String Dvpanel_unnamedtable10_Internalname ;
   private String divUnnamedtable10_Internalname ;
   private String edtavAuthresptypetag_Internalname ;
   private String AV15AuthRespTypeTag ;
   private String edtavAuthresptypetag_Jsonclick ;
   private String edtavAuthresptypevalue_Internalname ;
   private String edtavAuthresptypevalue_Jsonclick ;
   private String edtavAuthscopetag_Internalname ;
   private String AV18AuthScopeTag ;
   private String edtavAuthscopetag_Jsonclick ;
   private String edtavAuthscopevalue_Internalname ;
   private String edtavAuthscopevalue_Jsonclick ;
   private String edtavAuthstatetag_Internalname ;
   private String AV21AuthStateTag ;
   private String edtavAuthstatetag_Jsonclick ;
   private String edtavAuthadditionalparameters_Internalname ;
   private String AV5AuthAdditionalParameters ;
   private String edtavAuthadditionalparameters_Jsonclick ;
   private String edtavAuthadditionalparameterssd_Internalname ;
   private String AV6AuthAdditionalParametersSD ;
   private String edtavAuthadditionalparameterssd_Jsonclick ;
   private String Dvpanel_unnamedtable11_Internalname ;
   private String divUnnamedtable11_Internalname ;
   private String edtavAuthresponseaccesscodetag_Internalname ;
   private String AV12AuthResponseAccessCodeTag ;
   private String edtavAuthresponseaccesscodetag_Jsonclick ;
   private String edtavAuthresponseerrordesctag_Internalname ;
   private String AV13AuthResponseErrorDescTag ;
   private String edtavAuthresponseerrordesctag_Jsonclick ;
   private String lblToken_title_Internalname ;
   private String lblToken_title_Jsonclick ;
   private String divUnnamedtable5_Internalname ;
   private String edtavTokenurl_Internalname ;
   private String edtavTokenurl_Jsonclick ;
   private String Dvpanel_unnamedtable6_Internalname ;
   private String divUnnamedtable6_Internalname ;
   private String AV57TokenMethod ;
   private String edtavTokenheaderkeytag_Internalname ;
   private String AV55TokenHeaderKeyTag ;
   private String edtavTokenheaderkeytag_Jsonclick ;
   private String edtavTokenheaderkeyvalue_Internalname ;
   private String edtavTokenheaderkeyvalue_Jsonclick ;
   private String edtavTokenheaderauthenticationrealm_Internalname ;
   private String AV53TokenHeaderAuthenticationRealm ;
   private String edtavTokenheaderauthenticationrealm_Jsonclick ;
   private String edtavTokengranttypetag_Internalname ;
   private String AV49TokenGrantTypeTag ;
   private String edtavTokengranttypetag_Jsonclick ;
   private String edtavTokengranttypevalue_Internalname ;
   private String edtavTokengranttypevalue_Jsonclick ;
   private String edtavTokenadditionalparameters_Internalname ;
   private String AV45TokenAdditionalParameters ;
   private String edtavTokenadditionalparameters_Jsonclick ;
   private String Dvpanel_unnamedtable7_Internalname ;
   private String divUnnamedtable7_Internalname ;
   private String edtavTokenresponseaccesstokentag_Internalname ;
   private String AV60TokenResponseAccessTokenTag ;
   private String edtavTokenresponseaccesstokentag_Jsonclick ;
   private String edtavTokenresponsetokentypetag_Internalname ;
   private String AV65TokenResponseTokenTypeTag ;
   private String edtavTokenresponsetokentypetag_Jsonclick ;
   private String edtavTokenresponseexpiresintag_Internalname ;
   private String AV62TokenResponseExpiresInTag ;
   private String edtavTokenresponseexpiresintag_Jsonclick ;
   private String edtavTokenresponsescopetag_Internalname ;
   private String AV64TokenResponseScopeTag ;
   private String edtavTokenresponsescopetag_Jsonclick ;
   private String edtavTokenresponseuseridtag_Internalname ;
   private String AV66TokenResponseUserIdTag ;
   private String edtavTokenresponseuseridtag_Jsonclick ;
   private String edtavTokenresponserefreshtokentag_Internalname ;
   private String AV63TokenResponseRefreshTokenTag ;
   private String edtavTokenresponserefreshtokentag_Jsonclick ;
   private String edtavTokenresponseerrordescriptiontag_Internalname ;
   private String AV61TokenResponseErrorDescriptionTag ;
   private String edtavTokenresponseerrordescriptiontag_Jsonclick ;
   private String Dvpanel_unnamedtable8_Internalname ;
   private String divUnnamedtable8_Internalname ;
   private String edtavTokenrefreshtokenurl_Internalname ;
   private String edtavTokenrefreshtokenurl_Jsonclick ;
   private String lblUserinfo_title_Internalname ;
   private String lblUserinfo_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String edtavUserinfourl_Internalname ;
   private String edtavUserinfourl_Jsonclick ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String AV78UserInfoMethod ;
   private String edtavUserinfoheaderkeytag_Internalname ;
   private String AV76UserInfoHeaderKeyTag ;
   private String edtavUserinfoheaderkeytag_Jsonclick ;
   private String edtavUserinfoheaderkeyvalue_Internalname ;
   private String edtavUserinfoheaderkeyvalue_Jsonclick ;
   private String edtavUserinfoaccesstokenname_Internalname ;
   private String AV70UserInfoAccessTokenName ;
   private String edtavUserinfoaccesstokenname_Jsonclick ;
   private String edtavUserinfoclientidname_Internalname ;
   private String AV73UserInfoClientIdName ;
   private String edtavUserinfoclientidname_Jsonclick ;
   private String edtavUserinfoclientsecretname_Internalname ;
   private String AV75UserInfoClientSecretName ;
   private String edtavUserinfoclientsecretname_Jsonclick ;
   private String edtavUserinfoadditionalparameters_Internalname ;
   private String AV71UserInfoAdditionalParameters ;
   private String edtavUserinfoadditionalparameters_Jsonclick ;
   private String Dvpanel_unnamedtable3_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String edtavUserinforesponseuseremailtag_Internalname ;
   private String AV81UserInfoResponseUserEmailTag ;
   private String edtavUserinforesponseuseremailtag_Jsonclick ;
   private String edtavUserinforesponseuserverifiedemailtag_Internalname ;
   private String AV93UserInfoResponseUserVerifiedEmailTag ;
   private String edtavUserinforesponseuserverifiedemailtag_Jsonclick ;
   private String edtavUserinforesponseuserexternalidtag_Internalname ;
   private String AV82UserInfoResponseUserExternalIdTag ;
   private String edtavUserinforesponseuserexternalidtag_Jsonclick ;
   private String edtavUserinforesponseusernametag_Internalname ;
   private String AV89UserInfoResponseUserNameTag ;
   private String edtavUserinforesponseusernametag_Jsonclick ;
   private String edtavUserinforesponseuserfirstnametag_Internalname ;
   private String AV83UserInfoResponseUserFirstNameTag ;
   private String edtavUserinforesponseuserfirstnametag_Jsonclick ;
   private String divTablesplitteduserinforesponseuserlastnametag_Internalname ;
   private String divTextblockuserinforesponseuserlastnametag_cell_Internalname ;
   private String divTextblockuserinforesponseuserlastnametag_cell_Class ;
   private String lblTextblockuserinforesponseuserlastnametag_Internalname ;
   private String lblTextblockuserinforesponseuserlastnametag_Jsonclick ;
   private String edtavUserinforesponseusergendertag_Internalname ;
   private String AV84UserInfoResponseUserGenderTag ;
   private String edtavUserinforesponseusergendertag_Jsonclick ;
   private String edtavUserinforesponseusergendervalues_Internalname ;
   private String edtavUserinforesponseusergendervalues_Jsonclick ;
   private String edtavUserinforesponseuserbirthdaytag_Internalname ;
   private String AV80UserInfoResponseUserBirthdayTag ;
   private String edtavUserinforesponseuserbirthdaytag_Jsonclick ;
   private String edtavUserinforesponseuserurlimagetag_Internalname ;
   private String AV91UserInfoResponseUserURLImageTag ;
   private String edtavUserinforesponseuserurlimagetag_Jsonclick ;
   private String edtavUserinforesponseuserurlprofiletag_Internalname ;
   private String AV92UserInfoResponseUserURLProfileTag ;
   private String edtavUserinforesponseuserurlprofiletag_Jsonclick ;
   private String edtavUserinforesponseuserlanguagetag_Internalname ;
   private String AV86UserInfoResponseUserLanguageTag ;
   private String edtavUserinforesponseuserlanguagetag_Jsonclick ;
   private String edtavUserinforesponseusertimezonetag_Internalname ;
   private String AV90UserInfoResponseUserTimeZoneTag ;
   private String edtavUserinforesponseusertimezonetag_Jsonclick ;
   private String edtavUserinforesponseerrordescriptiontag_Internalname ;
   private String AV79UserInfoResponseErrorDescriptionTag ;
   private String edtavUserinforesponseerrordescriptiontag_Jsonclick ;
   private String Dvpanel_unnamedtable4_Internalname ;
   private String divUnnamedtable4_Internalname ;
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
   private String AV26DynamicPropName ;
   private String AV27DynamicPropTag ;
   private String edtavDynamicproptag_Internalname ;
   private String edtavDeleteproperty_Internalname ;
   private String AV88UserInfoResponseUserLastNameTag ;
   private String edtavUserinforesponseuserlastnametag_Internalname ;
   private String edtavDeleteproperty_gximage ;
   private String edtavDeleteproperty_Tooltiptext ;
   private String cellUserinforesponseuserlastnametag_cell_Class ;
   private String cellUserinforesponseuserlastnametag_cell_Internalname ;
   private String sGXsfl_462_fel_idx="0001" ;
   private String lblTbuserlastnamehelp_Caption ;
   private String lblTbuserlastnamehelp_Internalname ;
   private String tblTablemergeduserinforesponseuserlastnametag_Internalname ;
   private String edtavUserinforesponseuserlastnametag_Jsonclick ;
   private String lblTbuserlastnamehelp_Jsonclick ;
   private String sCtrlGx_mode ;
   private String sCtrlAV34Name ;
   private String sCtrlAV68TypeId ;
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
   private boolean AV33IsEnable ;
   private boolean AV40Oauth20RedirectURLisCustom ;
   private boolean AV39Oauth20RedirectToAuthenticate ;
   private boolean AV14AuthRespTypeInclude ;
   private boolean AV17AuthScopeInclude ;
   private boolean AV98AuthStateInclude ;
   private boolean AV7AuthClientIdInclude ;
   private boolean AV8AuthClientSecretInclude ;
   private boolean AV99AuthRedirURLInclude ;
   private boolean AV51TokenHeaderAuthenticationInclude ;
   private boolean AV54TokenHeaderAuthorizationBasicInclude ;
   private boolean AV48TokenGrantTypeInclude ;
   private boolean AV44TokenAccessCodeInclude ;
   private boolean AV46TokenCliIdInclude ;
   private boolean AV47TokenCliSecretInclude ;
   private boolean AV58TokenRedirectURLInclude ;
   private boolean AV22AutovalidateExternalTokenAndRefresh ;
   private boolean AV69UserInfoAccessTokenInclude ;
   private boolean AV72UserInfoClientIdInclude ;
   private boolean AV74UserInfoClientSecretInclude ;
   private boolean AV95UserInfoUserIdInclude ;
   private boolean AV87UserInfoResponseUserLastNameGenAuto ;
   private boolean AV105CheckRequiredFieldsResult ;
   private boolean Dvpanel_unnamedtable11_Autowidth ;
   private boolean Dvpanel_unnamedtable11_Autoheight ;
   private boolean Dvpanel_unnamedtable11_Collapsible ;
   private boolean Dvpanel_unnamedtable11_Collapsed ;
   private boolean Dvpanel_unnamedtable11_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable11_Autoscroll ;
   private boolean Dvpanel_unnamedtable10_Autowidth ;
   private boolean Dvpanel_unnamedtable10_Autoheight ;
   private boolean Dvpanel_unnamedtable10_Collapsible ;
   private boolean Dvpanel_unnamedtable10_Collapsed ;
   private boolean Dvpanel_unnamedtable10_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable10_Autoscroll ;
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
   private boolean Dvpanel_unnamedtable6_Autowidth ;
   private boolean Dvpanel_unnamedtable6_Autoheight ;
   private boolean Dvpanel_unnamedtable6_Collapsible ;
   private boolean Dvpanel_unnamedtable6_Collapsed ;
   private boolean Dvpanel_unnamedtable6_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable6_Autoscroll ;
   private boolean Dvpanel_unnamedtable3_Autowidth ;
   private boolean Dvpanel_unnamedtable3_Autoheight ;
   private boolean Dvpanel_unnamedtable3_Collapsible ;
   private boolean Dvpanel_unnamedtable3_Collapsed ;
   private boolean Dvpanel_unnamedtable3_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable3_Autoscroll ;
   private boolean Dvpanel_unnamedtable4_Autowidth ;
   private boolean Dvpanel_unnamedtable4_Autoheight ;
   private boolean Dvpanel_unnamedtable4_Collapsible ;
   private boolean Dvpanel_unnamedtable4_Collapsed ;
   private boolean Dvpanel_unnamedtable4_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable4_Autoscroll ;
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
   private boolean bGXsfl_462_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV24DeleteProperty_IsBlob ;
   private String AV36Oauth20ClientIdValue ;
   private String AV38Oauth20ClientSecretValue ;
   private String AV42Oauth20RedirectURLvalue ;
   private String AV10AuthorizeURL ;
   private String AV16AuthRespTypeValue ;
   private String AV19AuthScopeValue ;
   private String AV67TokenURL ;
   private String AV56TokenHeaderKeyValue ;
   private String AV50TokenGrantTypeValue ;
   private String AV59TokenRefreshTokenURL ;
   private String AV94UserInfoURL ;
   private String AV77UserInfoHeaderKeyValue ;
   private String AV85UserInfoResponseUserGenderValues ;
   private String AV110Deleteproperty_GXI ;
   private String AV24DeleteProperty ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable10 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable11 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable6 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable7 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable8 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable3 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable4 ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbavFunctionid ;
   private ICheckbox chkavIsenable ;
   private ICheckbox chkavOauth20redirecturliscustom ;
   private ICheckbox chkavOauth20redirecttoauthenticate ;
   private ICheckbox chkavAuthresptypeinclude ;
   private ICheckbox chkavAuthscopeinclude ;
   private ICheckbox chkavAuthstateinclude ;
   private ICheckbox chkavAuthclientidinclude ;
   private ICheckbox chkavAuthclientsecretinclude ;
   private ICheckbox chkavAuthredirurlinclude ;
   private HTMLChoice cmbavTokenmethod ;
   private ICheckbox chkavTokenheaderauthenticationinclude ;
   private HTMLChoice cmbavTokenheaderauthenticationmethod ;
   private ICheckbox chkavTokenheaderauthorizationbasicinclude ;
   private ICheckbox chkavTokengranttypeinclude ;
   private ICheckbox chkavTokenaccesscodeinclude ;
   private ICheckbox chkavTokencliidinclude ;
   private ICheckbox chkavTokenclisecretinclude ;
   private ICheckbox chkavTokenredirecturlinclude ;
   private ICheckbox chkavAutovalidateexternaltokenandrefresh ;
   private HTMLChoice cmbavUserinfomethod ;
   private ICheckbox chkavUserinfoaccesstokeninclude ;
   private ICheckbox chkavUserinfoclientidinclude ;
   private ICheckbox chkavUserinfoclientsecretinclude ;
   private ICheckbox chkavUserinfouseridinclude ;
   private ICheckbox chkavUserinforesponseuserlastnamegenauto ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV29Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOauth20 AV9AuthenticationTypeOauth20 ;
   private genexus.security.api.genexussecurity.SdtGAMPropertySimple AV31GAMPropertySimple ;
   private genexus.security.api.genexussecurity.SdtGAMError AV28Error ;
}

final  class gamwcauthenticationtypeentryoauth20__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwcauthenticationtypeentryoauth20__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

