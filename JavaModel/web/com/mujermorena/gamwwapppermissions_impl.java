package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwwapppermissions_impl extends GXDataArea
{
   public gamwwapppermissions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwwapppermissions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwwapppermissions_impl.class ));
   }

   public gamwwapppermissions_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavPermissionaccesstypedefault = new HTMLChoice();
      cmbavPermissiontypefilter = new HTMLChoice();
      cmbavIsautomaticpermission = new HTMLChoice();
      cmbavAccesstype = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "ApplicationId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ApplicationId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ApplicationId") ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV9ApplicationId = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9ApplicationId), 12, 0));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_56 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_56"))) ;
      nGXsfl_56_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_56_idx"))) ;
      sGXsfl_56_idx = httpContext.GetPar( "sGXsfl_56_idx") ;
      edtavBtnchildren_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnchildren_Internalname, "Title", edtavBtnchildren_Title, !bGXsfl_56_Refreshing);
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
      AV60ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV79Pgmname = httpContext.GetPar( "Pgmname") ;
      AV16FilName = httpContext.GetPar( "FilName") ;
      cmbavPermissionaccesstypedefault.fromJSonString( httpContext.GetNextPar( ));
      AV27PermissionAccessTypeDefault = httpContext.GetPar( "PermissionAccessTypeDefault") ;
      cmbavPermissiontypefilter.fromJSonString( httpContext.GetNextPar( ));
      AV28PermissionTypeFilter = httpContext.GetPar( "PermissionTypeFilter") ;
      cmbavIsautomaticpermission.fromJSonString( httpContext.GetNextPar( ));
      AV24isAutomaticPermission = httpContext.GetPar( "isAutomaticPermission") ;
      edtavBtnchildren_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnchildren_Internalname, "Title", edtavBtnchildren_Title, !bGXsfl_56_Refreshing);
      AV9ApplicationId = GXutil.lval( httpContext.GetPar( "ApplicationId")) ;
      AV72IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV73IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV74IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV20IsAuthorized_BtnChildren = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_BtnChildren")) ;
      AV23IsAuthorized_Name = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Name")) ;
      AV75IsAuthorized_Back = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Back")) ;
      AV76IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV60ManageFiltersExecutionStep, AV79Pgmname, AV16FilName, AV27PermissionAccessTypeDefault, AV28PermissionTypeFilter, AV24isAutomaticPermission, AV9ApplicationId, AV72IsAuthorized_Display, AV73IsAuthorized_Update, AV74IsAuthorized_Delete, AV20IsAuthorized_BtnChildren, AV23IsAuthorized_Name, AV75IsAuthorized_Back, AV76IsAuthorized_Insert) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
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

   public byte executeStartEvent( )
   {
      pa2R2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2R2( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwwapppermissions", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0))}, new String[] {"ApplicationId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV72IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV73IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV74IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNCHILDREN", getSecureSignedToken( "", AV20IsAuthorized_BtnChildren));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV23IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV75IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV76IsAuthorized_Insert));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_56", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_56, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV64ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV64ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV67GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV18GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV69GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV60ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV79Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV9ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV72IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV72IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV73IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV73IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV74IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV74IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNCHILDREN", AV20IsAuthorized_BtnChildren);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNCHILDREN", getSecureSignedToken( "", AV20IsAuthorized_BtnChildren));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV23IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV23IsAuthorized_Name));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV40GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV40GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BACK", AV75IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV75IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV76IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV76IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icontype", GXutil.rtrim( Ddo_managefilters_Icontype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Icon", GXutil.rtrim( Ddo_managefilters_Icon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Tooltip", GXutil.rtrim( Ddo_managefilters_Tooltip));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Cls", GXutil.rtrim( Ddo_managefilters_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vBTNCHILDREN_Title", GXutil.rtrim( edtavBtnchildren_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we2R2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2R2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.mujermorena.gamwwapppermissions", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0))}, new String[] {"ApplicationId"})  ;
   }

   public String getPgmname( )
   {
      return "GAMWWAppPermissions" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_PermissionsApplication", "") ;
   }

   public void wb2R0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 CellWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "TableCellsWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWWAppPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         ClassString = "BtnImage BtnBackImage" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnback_Internalname, "gx.evt.setGridEvt("+GXutil.str( 56, 2, 0)+","+"null"+");", " ", bttBtnback_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_Back", ""), "", StyleString, ClassString, bttBtnback_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBACK\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWWAppPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_GAMWWAppPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6 CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_22_2R2( true) ;
      }
      else
      {
         wb_table1_22_2R2( false) ;
      }
      return  ;
   }

   public void wb_table1_22_2R2e( boolean wbgen )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol56( ) ;
      }
      if ( wbEnd == 56 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_56 = (int)(nGXsfl_56_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV67GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV18GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV69GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 56 )
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
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2R2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_PermissionsApplication", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2R0( ) ;
   }

   public void ws2R2( )
   {
      start2R2( ) ;
      evt2R2( ) ;
   }

   public void evt2R2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_MANAGEFILTERS.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e112R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBACK'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBack' */
                           e142R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e152R2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_56_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_562( ) ;
                           AV70Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV70Display);
                           AV71Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV71Update);
                           AV5Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
                           AV11BtnChildren = httpContext.cgiGet( edtavBtnchildren_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtnchildren_Internalname, AV11BtnChildren);
                           AV19Id = httpContext.cgiGet( edtavId_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV19Id);
                           AV25Name = httpContext.cgiGet( edtavName_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV25Name);
                           AV14Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV14Dsc);
                           cmbavAccesstype.setName( cmbavAccesstype.getInternalname() );
                           cmbavAccesstype.setValue( httpContext.cgiGet( cmbavAccesstype.getInternalname()) );
                           AV6AccessType = httpContext.cgiGet( cmbavAccesstype.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
                           AV7AppId = localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7AppId), 12, 0));
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e162R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e172R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e182R2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
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

   public void we2R2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa2R2( )
   {
      if ( nDonePA == 0 )
      {
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavFilname_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      subsflControlProps_562( ) ;
      while ( nGXsfl_56_idx <= nRC_GXsfl_56 )
      {
         sendrow_562( ) ;
         nGXsfl_56_idx = ((subGrid_Islastpage==1)&&(nGXsfl_56_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_56_idx+1) ;
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_562( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV60ManageFiltersExecutionStep ,
                                 String AV79Pgmname ,
                                 String AV16FilName ,
                                 String AV27PermissionAccessTypeDefault ,
                                 String AV28PermissionTypeFilter ,
                                 String AV24isAutomaticPermission ,
                                 long AV9ApplicationId ,
                                 boolean AV72IsAuthorized_Display ,
                                 boolean AV73IsAuthorized_Update ,
                                 boolean AV74IsAuthorized_Delete ,
                                 boolean AV20IsAuthorized_BtnChildren ,
                                 boolean AV23IsAuthorized_Name ,
                                 boolean AV75IsAuthorized_Back ,
                                 boolean AV76IsAuthorized_Insert )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e172R2 ();
      GRID_nCurrentRecord = 0 ;
      rf2R2( ) ;
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
      if ( cmbavPermissionaccesstypedefault.getItemCount() > 0 )
      {
         AV27PermissionAccessTypeDefault = cmbavPermissionaccesstypedefault.getValidValue(AV27PermissionAccessTypeDefault) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PermissionAccessTypeDefault", AV27PermissionAccessTypeDefault);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPermissionaccesstypedefault.setValue( GXutil.rtrim( AV27PermissionAccessTypeDefault) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstypedefault.getInternalname(), "Values", cmbavPermissionaccesstypedefault.ToJavascriptSource(), true);
      }
      if ( cmbavPermissiontypefilter.getItemCount() > 0 )
      {
         AV28PermissionTypeFilter = cmbavPermissiontypefilter.getValidValue(AV28PermissionTypeFilter) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionTypeFilter", AV28PermissionTypeFilter);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPermissiontypefilter.setValue( GXutil.rtrim( AV28PermissionTypeFilter) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissiontypefilter.getInternalname(), "Values", cmbavPermissiontypefilter.ToJavascriptSource(), true);
      }
      if ( cmbavIsautomaticpermission.getItemCount() > 0 )
      {
         AV24isAutomaticPermission = cmbavIsautomaticpermission.getValidValue(AV24isAutomaticPermission) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24isAutomaticPermission", AV24isAutomaticPermission);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavIsautomaticpermission.setValue( GXutil.rtrim( AV24isAutomaticPermission) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIsautomaticpermission.getInternalname(), "Values", cmbavIsautomaticpermission.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2R2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV79Pgmname = "GAMWWAppPermissions" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavBtnchildren_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnchildren_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnchildren_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      cmbavAccesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAccesstype.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      edtavAppid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAppid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAppid_Enabled), 5, 0), !bGXsfl_56_Refreshing);
   }

   public void rf2R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(56) ;
      /* Execute user event: Refresh */
      e172R2 ();
      nGXsfl_56_idx = 1 ;
      sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_562( ) ;
      bGXsfl_56_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      if ( subGrid_Islastpage != 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordcount( )-subgrid_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_562( ) ;
         e182R2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_56_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e182R2 ();
         }
         wbEnd = (short)(56) ;
         wb2R0( ) ;
      }
      bGXsfl_56_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2R2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV79Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV72IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV72IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV73IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV73IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV74IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV74IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNCHILDREN", AV20IsAuthorized_BtnChildren);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNCHILDREN", getSecureSignedToken( "", AV20IsAuthorized_BtnChildren));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV23IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV23IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BACK", AV75IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV75IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV76IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV76IsAuthorized_Insert));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV60ManageFiltersExecutionStep, AV79Pgmname, AV16FilName, AV27PermissionAccessTypeDefault, AV28PermissionTypeFilter, AV24isAutomaticPermission, AV9ApplicationId, AV72IsAuthorized_Display, AV73IsAuthorized_Update, AV74IsAuthorized_Delete, AV20IsAuthorized_BtnChildren, AV23IsAuthorized_Name, AV75IsAuthorized_Back, AV76IsAuthorized_Insert) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV60ManageFiltersExecutionStep, AV79Pgmname, AV16FilName, AV27PermissionAccessTypeDefault, AV28PermissionTypeFilter, AV24isAutomaticPermission, AV9ApplicationId, AV72IsAuthorized_Display, AV73IsAuthorized_Update, AV74IsAuthorized_Delete, AV20IsAuthorized_BtnChildren, AV23IsAuthorized_Name, AV75IsAuthorized_Back, AV76IsAuthorized_Insert) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV60ManageFiltersExecutionStep, AV79Pgmname, AV16FilName, AV27PermissionAccessTypeDefault, AV28PermissionTypeFilter, AV24isAutomaticPermission, AV9ApplicationId, AV72IsAuthorized_Display, AV73IsAuthorized_Update, AV74IsAuthorized_Delete, AV20IsAuthorized_BtnChildren, AV23IsAuthorized_Name, AV75IsAuthorized_Back, AV76IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV60ManageFiltersExecutionStep, AV79Pgmname, AV16FilName, AV27PermissionAccessTypeDefault, AV28PermissionTypeFilter, AV24isAutomaticPermission, AV9ApplicationId, AV72IsAuthorized_Display, AV73IsAuthorized_Update, AV74IsAuthorized_Delete, AV20IsAuthorized_BtnChildren, AV23IsAuthorized_Name, AV75IsAuthorized_Back, AV76IsAuthorized_Insert) ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV60ManageFiltersExecutionStep, AV79Pgmname, AV16FilName, AV27PermissionAccessTypeDefault, AV28PermissionTypeFilter, AV24isAutomaticPermission, AV9ApplicationId, AV72IsAuthorized_Display, AV73IsAuthorized_Update, AV74IsAuthorized_Delete, AV20IsAuthorized_BtnChildren, AV23IsAuthorized_Name, AV75IsAuthorized_Back, AV76IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV79Pgmname = "GAMWWAppPermissions" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavBtnchildren_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnchildren_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnchildren_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      cmbavAccesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAccesstype.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      edtavAppid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAppid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAppid_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e162R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV64ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_56 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_56"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV67GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV18GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV69GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_managefilters_Icontype = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icontype") ;
         Ddo_managefilters_Icon = httpContext.cgiGet( "DDO_MANAGEFILTERS_Icon") ;
         Ddo_managefilters_Tooltip = httpContext.cgiGet( "DDO_MANAGEFILTERS_Tooltip") ;
         Ddo_managefilters_Cls = httpContext.cgiGet( "DDO_MANAGEFILTERS_Cls") ;
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
         AV16FilName = httpContext.cgiGet( edtavFilname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16FilName", AV16FilName);
         cmbavPermissionaccesstypedefault.setName( cmbavPermissionaccesstypedefault.getInternalname() );
         cmbavPermissionaccesstypedefault.setValue( httpContext.cgiGet( cmbavPermissionaccesstypedefault.getInternalname()) );
         AV27PermissionAccessTypeDefault = httpContext.cgiGet( cmbavPermissionaccesstypedefault.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PermissionAccessTypeDefault", AV27PermissionAccessTypeDefault);
         cmbavPermissiontypefilter.setName( cmbavPermissiontypefilter.getInternalname() );
         cmbavPermissiontypefilter.setValue( httpContext.cgiGet( cmbavPermissiontypefilter.getInternalname()) );
         AV28PermissionTypeFilter = httpContext.cgiGet( cmbavPermissiontypefilter.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionTypeFilter", AV28PermissionTypeFilter);
         cmbavIsautomaticpermission.setName( cmbavIsautomaticpermission.getInternalname() );
         cmbavIsautomaticpermission.setValue( httpContext.cgiGet( cmbavIsautomaticpermission.getInternalname()) );
         AV24isAutomaticPermission = httpContext.cgiGet( cmbavIsautomaticpermission.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24isAutomaticPermission", AV24isAutomaticPermission);
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
      e162R2 ();
      if (returnInSub) return;
   }

   public void e162R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV36HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      lblBtninsert_Caption = GXutil.format( "<i class='fas fa-plus' title='%1'></i>", httpContext.getMessage( "GXM_insert", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Caption", lblBtninsert_Caption, true);
      GXt_boolean1 = AV23IsAuthorized_Name ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionentry_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV23IsAuthorized_Name = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23IsAuthorized_Name", AV23IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV23IsAuthorized_Name));
      Form.setCaption( httpContext.getMessage( "WWP_GAM_PermissionsApplication", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      edtavBtnchildren_Title = httpContext.getMessage( "WWP_GAM_Children", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnchildren_Internalname, "Title", edtavBtnchildren_Title, !bGXsfl_56_Refreshing);
      AV8Application.load(AV9ApplicationId);
      Form.setCaption( GXutil.format( httpContext.getMessage( "WWP_GAM_PermissionsOfApplication", ""), AV8Application.getgxTv_SdtGAMApplication_Name(), "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void e172R2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV37WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV37WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      if ( AV60ManageFiltersExecutionStep == 1 )
      {
         AV60ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV60ManageFiltersExecutionStep == 2 )
      {
         AV60ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV67GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67GridCurrentPage), 10, 0));
      GXt_char4 = AV69GridAppliedFilters ;
      GXv_char5[0] = GXt_char4 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV79Pgmname, GXv_char5) ;
      gamwwapppermissions_impl.this.GXt_char4 = GXv_char5[0] ;
      AV69GridAppliedFilters = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69GridAppliedFilters", AV69GridAppliedFilters);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40GridState", AV40GridState);
   }

   public void e122R2( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV26PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV26PageToGo) ;
      }
   }

   public void e132R2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e182R2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV31GridPageSize = subGrid_Rows ;
      AV8Application.load(AV9ApplicationId);
      AV7AppId = AV9ApplicationId ;
      httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7AppId), 12, 0));
      AV17Filter.setgxTv_SdtGAMApplicationPermissionFilter_Name( "%"+AV16FilName );
      AV17Filter.setgxTv_SdtGAMApplicationPermissionFilter_Accesstypedefault( AV27PermissionAccessTypeDefault );
      AV17Filter.setgxTv_SdtGAMApplicationPermissionFilter_Typefilter( AV28PermissionTypeFilter );
      AV17Filter.setgxTv_SdtGAMApplicationPermissionFilter_Isautomaticpermission( AV24isAutomaticPermission );
      GXv_objcol_SdtGAMError6[0] = AV15Errors ;
      AV30Permissions = AV8Application.getpermissions(AV17Filter, GXv_objcol_SdtGAMError6) ;
      AV15Errors = GXv_objcol_SdtGAMError6[0] ;
      if ( AV30Permissions.size() == 0 )
      {
         AV18GridPageCount = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18GridPageCount), 10, 0));
      }
      else
      {
         AV18GridPageCount = (long)((AV30Permissions.size()/ (double) (AV31GridPageSize))+((((int)((AV30Permissions.size()) % (AV31GridPageSize)))>0) ? 1 : 0)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18GridPageCount), 10, 0));
      }
      AV32GridRecordCount = AV30Permissions.size() ;
      AV80GXV1 = 1 ;
      while ( AV80GXV1 <= AV30Permissions.size() )
      {
         AV10AppPermission = (genexus.security.api.genexussecurity.SdtGAMApplicationPermission)((genexus.security.api.genexussecurity.SdtGAMApplicationPermission)AV30Permissions.elementAt(-1+AV80GXV1));
         AV19Id = AV10AppPermission.getgxTv_SdtGAMApplicationPermission_Guid() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV19Id);
         AV25Name = AV10AppPermission.getgxTv_SdtGAMApplicationPermission_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV25Name);
         AV14Dsc = httpContext.getMessage( AV10AppPermission.getgxTv_SdtGAMApplicationPermission_Description(), "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV14Dsc);
         AV6AccessType = AV10AppPermission.getgxTv_SdtGAMApplicationPermission_Accesstype() ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
         AV70Display = "<i class=\"fa fa-search\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV70Display);
         if ( AV72IsAuthorized_Display )
         {
            edtavDisplay_Link = formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV19Id))}, new String[] {"Mode","ApplicationId","GUID"})  ;
         }
         AV71Update = "<i class=\"fa fa-pen\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV71Update);
         if ( AV73IsAuthorized_Update )
         {
            edtavUpdate_Link = formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV19Id))}, new String[] {"Mode","ApplicationId","GUID"})  ;
         }
         AV5Delete = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
         if ( AV74IsAuthorized_Delete )
         {
            edtavDelete_Link = formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV19Id))}, new String[] {"Mode","ApplicationId","GUID"})  ;
         }
         AV11BtnChildren = "<i class=\"fa fa-lock\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavBtnchildren_Internalname, AV11BtnChildren);
         if ( AV20IsAuthorized_BtnChildren )
         {
            edtavBtnchildren_Link = formatLink("com.mujermorena.gamapppermissionchildren", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV19Id))}, new String[] {"ApplicationId","PermissionId"})  ;
         }
         if ( AV23IsAuthorized_Name )
         {
            edtavName_Link = formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV19Id))}, new String[] {"Mode","ApplicationId","GUID"})  ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(56) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_562( ) ;
            GRID_nEOF = (byte)(1) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( ( subGrid_Islastpage == 1 ) && ( ((int)((GRID_nCurrentRecord) % (subgrid_fnc_recordsperpage( )))) == 0 ) )
            {
               GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
            }
         }
         if ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) )
         {
            GRID_nEOF = (byte)(0) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         }
         GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_56_Refreshing )
         {
            httpContext.doAjaxLoad(56, GridRow);
         }
         AV80GXV1 = (int)(AV80GXV1+1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV17Filter", AV17Filter);
      cmbavAccesstype.setValue( GXutil.rtrim( AV6AccessType) );
   }

   public void e112R2( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S152 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S142 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWAppPermissionsFilters")),GXutil.URLEncode(GXutil.rtrim(AV79Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV60ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWAppPermissionsFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV60ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60ManageFiltersExecutionStep", GXutil.str( AV60ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV61ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "GAMWWAppPermissionsFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         gamwwapppermissions_impl.this.GXt_char4 = GXv_char5[0] ;
         AV61ManageFiltersXml = GXt_char4 ;
         if ( (GXutil.strcmp("", AV61ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S152 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV79Pgmname+"GridState", AV61ManageFiltersXml) ;
            AV40GridState.fromxml(AV61ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S162 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40GridState", AV40GridState);
      cmbavPermissionaccesstypedefault.setValue( GXutil.rtrim( AV27PermissionAccessTypeDefault) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstypedefault.getInternalname(), "Values", cmbavPermissionaccesstypedefault.ToJavascriptSource(), true);
      cmbavPermissiontypefilter.setValue( GXutil.rtrim( AV28PermissionTypeFilter) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPermissiontypefilter.getInternalname(), "Values", cmbavPermissiontypefilter.ToJavascriptSource(), true);
      cmbavIsautomaticpermission.setValue( GXutil.rtrim( AV24isAutomaticPermission) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavIsautomaticpermission.getInternalname(), "Values", cmbavIsautomaticpermission.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
   }

   public void e142R2( )
   {
      /* 'DoBack' Routine */
      returnInSub = false ;
      if ( AV75IsAuthorized_Back )
      {
         callWebObject(formatLink("com.mujermorena.gamwwapplications", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40GridState", AV40GridState);
   }

   public void e152R2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( AV76IsAuthorized_Insert )
      {
         callWebObject(formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(AV9ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","ApplicationId","GUID"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV64ManageFiltersData", AV64ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40GridState", AV40GridState);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV72IsAuthorized_Display ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionentry_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV72IsAuthorized_Display = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72IsAuthorized_Display", AV72IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV72IsAuthorized_Display));
      if ( ! ( AV72IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_56_Refreshing);
      }
      GXt_boolean1 = AV73IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionentry_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV73IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73IsAuthorized_Update", AV73IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV73IsAuthorized_Update));
      if ( ! ( AV73IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_56_Refreshing);
      }
      GXt_boolean1 = AV74IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionentry_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV74IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74IsAuthorized_Delete", AV74IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV74IsAuthorized_Delete));
      if ( ! ( AV74IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_56_Refreshing);
      }
      GXt_boolean1 = AV20IsAuthorized_BtnChildren ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionchildren_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV20IsAuthorized_BtnChildren = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20IsAuthorized_BtnChildren", AV20IsAuthorized_BtnChildren);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNCHILDREN", getSecureSignedToken( "", AV20IsAuthorized_BtnChildren));
      if ( ! ( AV20IsAuthorized_BtnChildren ) )
      {
         edtavBtnchildren_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBtnchildren_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnchildren_Visible), 5, 0), !bGXsfl_56_Refreshing);
      }
      GXt_boolean1 = AV75IsAuthorized_Back ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamwwapplications_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV75IsAuthorized_Back = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75IsAuthorized_Back", AV75IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV75IsAuthorized_Back));
      if ( ! ( AV75IsAuthorized_Back ) )
      {
         bttBtnback_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnback_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnback_Visible), 5, 0), true);
      }
      GXt_boolean1 = AV76IsAuthorized_Insert ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionentry_Execute", GXv_boolean2) ;
      gamwwapppermissions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV76IsAuthorized_Insert = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76IsAuthorized_Insert", AV76IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV76IsAuthorized_Insert));
      if ( ! ( AV76IsAuthorized_Insert ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = AV64ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "GAMWWAppPermissionsFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] ;
      AV64ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   }

   public void S152( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV16FilName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilName", AV16FilName);
      AV27PermissionAccessTypeDefault = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27PermissionAccessTypeDefault", AV27PermissionAccessTypeDefault);
      AV28PermissionTypeFilter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionTypeFilter", AV28PermissionTypeFilter);
      AV24isAutomaticPermission = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24isAutomaticPermission", AV24isAutomaticPermission);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV59Session.getValue(AV79Pgmname+"GridState"), "") == 0 )
      {
         AV40GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV79Pgmname+"GridState"), null, null);
      }
      else
      {
         AV40GridState.fromxml(AV59Session.getValue(AV79Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV40GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV40GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV40GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S162( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV81GXV2 = 1 ;
      while ( AV81GXV2 <= AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV41GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV81GXV2));
         if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILNAME") == 0 )
         {
            AV16FilName = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilName", AV16FilName);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PERMISSIONACCESSTYPEDEFAULT") == 0 )
         {
            AV27PermissionAccessTypeDefault = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27PermissionAccessTypeDefault", AV27PermissionAccessTypeDefault);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PERMISSIONTYPEFILTER") == 0 )
         {
            AV28PermissionTypeFilter = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionTypeFilter", AV28PermissionTypeFilter);
         }
         else if ( GXutil.strcmp(AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "ISAUTOMATICPERMISSION") == 0 )
         {
            AV24isAutomaticPermission = AV41GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24isAutomaticPermission", AV24isAutomaticPermission);
         }
         AV81GXV2 = (int)(AV81GXV2+1) ;
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV40GridState.fromxml(AV59Session.getValue(AV79Pgmname+"GridState"), null, null);
      AV40GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV40GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILNAME", httpContext.getMessage( "WWP_GAM_Name", ""), !(GXutil.strcmp("", AV16FilName)==0), (short)(0), AV16FilName, "") ;
      AV40GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV40GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "PERMISSIONACCESSTYPEDEFAULT", httpContext.getMessage( "WWP_GAM_DefaultAccess", ""), !(GXutil.strcmp("", AV27PermissionAccessTypeDefault)==0), (short)(0), AV27PermissionAccessTypeDefault, "") ;
      AV40GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV40GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "PERMISSIONTYPEFILTER", httpContext.getMessage( "WWP_GAM_FilterBy", ""), !(GXutil.strcmp("", AV28PermissionTypeFilter)==0), (short)(0), AV28PermissionTypeFilter, "") ;
      AV40GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV40GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "ISAUTOMATICPERMISSION", httpContext.getMessage( "WWP_GAM_OnlyAutomaticPermissions", ""), !(GXutil.strcmp("", AV24isAutomaticPermission)==0), (short)(0), AV24isAutomaticPermission, "") ;
      AV40GridState = GXv_SdtWWPGridState9[0] ;
      AV40GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV40GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV79Pgmname+"GridState", AV40GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void wb_table1_22_2R2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTopPaddingTop2'>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV64ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_27_2R2( true) ;
      }
      else
      {
         wb_table2_27_2R2( false) ;
      }
      return  ;
   }

   public void wb_table2_27_2R2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_2R2e( true) ;
      }
      else
      {
         wb_table1_22_2R2e( false) ;
      }
   }

   public void wb_table2_27_2R2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavFilname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFilname_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilname_Internalname, GXutil.rtrim( AV16FilName), GXutil.rtrim( localUtil.format( AV16FilName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFilname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWWAppPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPermissionaccesstypedefault.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavPermissionaccesstypedefault.getInternalname(), httpContext.getMessage( "WWP_GAM_DefaultAccess", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPermissionaccesstypedefault, cmbavPermissionaccesstypedefault.getInternalname(), GXutil.rtrim( AV27PermissionAccessTypeDefault), 1, cmbavPermissionaccesstypedefault.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPermissionaccesstypedefault.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_GAMWWAppPermissions.htm");
         cmbavPermissionaccesstypedefault.setValue( GXutil.rtrim( AV27PermissionAccessTypeDefault) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstypedefault.getInternalname(), "Values", cmbavPermissionaccesstypedefault.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPermissiontypefilter.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavPermissiontypefilter.getInternalname(), httpContext.getMessage( "WWP_GAM_FilterBy", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPermissiontypefilter, cmbavPermissiontypefilter.getInternalname(), GXutil.rtrim( AV28PermissionTypeFilter), 1, cmbavPermissiontypefilter.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPermissiontypefilter.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_GAMWWAppPermissions.htm");
         cmbavPermissiontypefilter.setValue( GXutil.rtrim( AV28PermissionTypeFilter) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissiontypefilter.getInternalname(), "Values", cmbavPermissiontypefilter.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavIsautomaticpermission.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavIsautomaticpermission.getInternalname(), httpContext.getMessage( "WWP_GAM_OnlyAutomaticPermissions", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavIsautomaticpermission, cmbavIsautomaticpermission.getInternalname(), GXutil.rtrim( AV24isAutomaticPermission), 1, cmbavIsautomaticpermission.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavIsautomaticpermission.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_GAMWWAppPermissions.htm");
         cmbavIsautomaticpermission.setValue( GXutil.rtrim( AV24isAutomaticPermission) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIsautomaticpermission.getInternalname(), "Values", cmbavIsautomaticpermission.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_27_2R2e( true) ;
      }
      else
      {
         wb_table2_27_2R2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV9ApplicationId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9ApplicationId), 12, 0));
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
      pa2R2( ) ;
      ws2R2( ) ;
      we2R2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111181851", true, true);
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
      httpContext.AddJavascriptSource("gamwwapppermissions.js", "?202412111181853", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_562( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_56_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_56_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_56_idx ;
      edtavBtnchildren_Internalname = "vBTNCHILDREN_"+sGXsfl_56_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_56_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_56_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_56_idx ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE_"+sGXsfl_56_idx );
      edtavAppid_Internalname = "vAPPID_"+sGXsfl_56_idx ;
   }

   public void subsflControlProps_fel_562( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_56_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_56_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_56_fel_idx ;
      edtavBtnchildren_Internalname = "vBTNCHILDREN_"+sGXsfl_56_fel_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_56_fel_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_56_fel_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_56_fel_idx ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE_"+sGXsfl_56_fel_idx );
      edtavAppid_Internalname = "vAPPID_"+sGXsfl_56_fel_idx ;
   }

   public void sendrow_562( )
   {
      subsflControlProps_562( ) ;
      wb2R0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_56_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_56_idx) % (2))) == 0 )
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
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_56_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV70Display),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV71Update),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV5Delete),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavBtnchildren_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtnchildren_Internalname,GXutil.rtrim( AV11BtnChildren),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavBtnchildren_Link,"",httpContext.getMessage( "Children", ""),"",edtavBtnchildren_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavBtnchildren_Visible),Integer.valueOf(edtavBtnchildren_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavId_Internalname,GXutil.rtrim( AV19Id),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavId_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavName_Internalname,GXutil.rtrim( AV25Name),"","","'"+""+"'"+",false,"+"'"+""+"'",edtavName_Link,"","","",edtavName_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(120),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionMedium","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDsc_Internalname,GXutil.rtrim( AV14Dsc),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDsc_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDsc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbavAccesstype.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vACCESSTYPE_" + sGXsfl_56_idx ;
            cmbavAccesstype.setName( GXCCtl );
            cmbavAccesstype.setWebtags( "" );
            cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
            cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
            if ( cmbavAccesstype.getItemCount() > 0 )
            {
               AV6AccessType = cmbavAccesstype.getValidValue(AV6AccessType) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavAccesstype,cmbavAccesstype.getInternalname(),GXutil.rtrim( AV6AccessType),Integer.valueOf(1),cmbavAccesstype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavAccesstype.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavAccesstype.setValue( GXutil.rtrim( AV6AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Values", cmbavAccesstype.ToJavascriptSource(), !bGXsfl_56_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavAppid_Internalname,GXutil.ltrim( localUtil.ntoc( AV7AppId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavAppid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV7AppId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV7AppId), "ZZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavAppid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavAppid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMKeyNumLong","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2R2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_56_idx = ((subGrid_Islastpage==1)&&(nGXsfl_56_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_56_idx+1) ;
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_562( ) ;
      }
      /* End function sendrow_562 */
   }

   public void startgridcontrol56( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"56\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavBtnchildren_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtavBtnchildren_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_GUID", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_PermissionName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Description", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_DefaultAccess", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "AppId", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV70Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV71Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV5Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV11BtnChildren));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavBtnchildren_Title));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtnchildren_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavBtnchildren_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavBtnchildren_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV19Id));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavId_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV25Name));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavName_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV14Dsc));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDsc_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV6AccessType));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavAccesstype.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV7AppId, (byte)(12), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavAppid_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      bttBtnback_Internalname = "BTNBACK" ;
      lblBtninsert_Internalname = "BTNINSERT" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      edtavFilname_Internalname = "vFILNAME" ;
      cmbavPermissionaccesstypedefault.setInternalname( "vPERMISSIONACCESSTYPEDEFAULT" );
      cmbavPermissiontypefilter.setInternalname( "vPERMISSIONTYPEFILTER" );
      cmbavIsautomaticpermission.setInternalname( "vISAUTOMATICPERMISSION" );
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavBtnchildren_Internalname = "vBTNCHILDREN" ;
      edtavId_Internalname = "vID" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE" );
      edtavAppid_Internalname = "vAPPID" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtavAppid_Jsonclick = "" ;
      edtavAppid_Enabled = 0 ;
      cmbavAccesstype.setJsonclick( "" );
      cmbavAccesstype.setEnabled( 0 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 0 ;
      edtavName_Jsonclick = "" ;
      edtavName_Link = "" ;
      edtavName_Enabled = 0 ;
      edtavId_Jsonclick = "" ;
      edtavId_Enabled = 0 ;
      edtavBtnchildren_Jsonclick = "" ;
      edtavBtnchildren_Link = "" ;
      edtavBtnchildren_Enabled = 0 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 0 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 0 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Link = "" ;
      edtavDisplay_Enabled = 0 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      cmbavIsautomaticpermission.setJsonclick( "" );
      cmbavIsautomaticpermission.setEnabled( 1 );
      cmbavPermissiontypefilter.setJsonclick( "" );
      cmbavPermissiontypefilter.setEnabled( 1 );
      cmbavPermissionaccesstypedefault.setJsonclick( "" );
      cmbavPermissionaccesstypedefault.setEnabled( 1 );
      edtavFilname_Jsonclick = "" ;
      edtavFilname_Enabled = 1 ;
      edtavBtnchildren_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
      lblBtninsert_Caption = httpContext.getMessage( "<i class='fas fa-plus' title='Agregar'></i>", "") ;
      lblBtninsert_Visible = 1 ;
      bttBtnback_Visible = 1 ;
      lblTextblocktitle_Caption = httpContext.getMessage( "Title", "") ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      Ddo_managefilters_Cls = "ManageFilters" ;
      Ddo_managefilters_Tooltip = "WWP_ManageFiltersTooltip" ;
      Ddo_managefilters_Icon = "fas fa-filter" ;
      Ddo_managefilters_Icontype = "FontIcon" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_GAM_PermissionsApplication", "") );
      edtavBtnchildren_Title = "" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavPermissionaccesstypedefault.setName( "vPERMISSIONACCESSTYPEDEFAULT" );
      cmbavPermissionaccesstypedefault.setWebtags( "" );
      cmbavPermissionaccesstypedefault.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbavPermissionaccesstypedefault.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavPermissionaccesstypedefault.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavPermissionaccesstypedefault.getItemCount() > 0 )
      {
         AV27PermissionAccessTypeDefault = cmbavPermissionaccesstypedefault.getValidValue(AV27PermissionAccessTypeDefault) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27PermissionAccessTypeDefault", AV27PermissionAccessTypeDefault);
      }
      cmbavPermissiontypefilter.setName( "vPERMISSIONTYPEFILTER" );
      cmbavPermissiontypefilter.setWebtags( "" );
      cmbavPermissiontypefilter.addItem("A", httpContext.getMessage( "WWP_GAM_All", ""), (short)(0));
      cmbavPermissiontypefilter.addItem("F", httpContext.getMessage( "WWP_GAM_FirstLevel", ""), (short)(0));
      cmbavPermissiontypefilter.addItem("P", httpContext.getMessage( "WWP_GAM_Parents", ""), (short)(0));
      cmbavPermissiontypefilter.addItem("C", httpContext.getMessage( "WWP_GAM_AllChildren", ""), (short)(0));
      if ( cmbavPermissiontypefilter.getItemCount() > 0 )
      {
         AV28PermissionTypeFilter = cmbavPermissiontypefilter.getValidValue(AV28PermissionTypeFilter) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionTypeFilter", AV28PermissionTypeFilter);
      }
      cmbavIsautomaticpermission.setName( "vISAUTOMATICPERMISSION" );
      cmbavIsautomaticpermission.setWebtags( "" );
      cmbavIsautomaticpermission.addItem("A", httpContext.getMessage( "WWP_GAM_All", ""), (short)(0));
      cmbavIsautomaticpermission.addItem("T", httpContext.getMessage( "WWP_GAM_Yes", ""), (short)(0));
      cmbavIsautomaticpermission.addItem("F", httpContext.getMessage( "WWP_GAM_No", ""), (short)(0));
      if ( cmbavIsautomaticpermission.getItemCount() > 0 )
      {
         AV24isAutomaticPermission = cmbavIsautomaticpermission.getValidValue(AV24isAutomaticPermission) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24isAutomaticPermission", AV24isAutomaticPermission);
      }
      GXCCtl = "vACCESSTYPE_" + sGXsfl_56_idx ;
      cmbavAccesstype.setName( GXCCtl );
      cmbavAccesstype.setWebtags( "" );
      cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavAccesstype.getItemCount() > 0 )
      {
         AV6AccessType = cmbavAccesstype.getValidValue(AV6AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavBtnchildren_Title',ctrl:'vBTNCHILDREN',prop:'Title'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV67GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV69GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'edtavBtnchildren_Visible',ctrl:'vBTNCHILDREN',prop:'Visible'},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV40GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e122R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'edtavBtnchildren_Title',ctrl:'vBTNCHILDREN',prop:'Title'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'edtavBtnchildren_Title',ctrl:'vBTNCHILDREN',prop:'Title'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e182R2',iparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV7AppId',fld:'vAPPID',pic:'ZZZZZZZZZZZ9'},{av:'AV18GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV19Id',fld:'vID',pic:''},{av:'AV25Name',fld:'vNAME',pic:''},{av:'AV14Dsc',fld:'vDSC',pic:''},{av:'cmbavAccesstype'},{av:'AV6AccessType',fld:'vACCESSTYPE',pic:''},{av:'AV70Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV71Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV5Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV11BtnChildren',fld:'vBTNCHILDREN',pic:''},{av:'edtavBtnchildren_Link',ctrl:'vBTNCHILDREN',prop:'Link'},{av:'edtavName_Link',ctrl:'vNAME',prop:'Link'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e112R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'edtavBtnchildren_Title',ctrl:'vBTNCHILDREN',prop:'Title'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV40GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV40GridState',fld:'vGRIDSTATE',pic:''},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'AV67GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV69GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'edtavBtnchildren_Visible',ctrl:'vBTNCHILDREN',prop:'Visible'},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOBACK'","{handler:'e142R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'edtavBtnchildren_Title',ctrl:'vBTNCHILDREN',prop:'Title'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("'DOBACK'",",oparms:[{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV67GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV69GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'edtavBtnchildren_Visible',ctrl:'vBTNCHILDREN',prop:'Visible'},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV40GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e152R2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstypedefault'},{av:'AV27PermissionAccessTypeDefault',fld:'vPERMISSIONACCESSTYPEDEFAULT',pic:''},{av:'cmbavPermissiontypefilter'},{av:'AV28PermissionTypeFilter',fld:'vPERMISSIONTYPEFILTER',pic:''},{av:'cmbavIsautomaticpermission'},{av:'AV24isAutomaticPermission',fld:'vISAUTOMATICPERMISSION',pic:''},{av:'edtavBtnchildren_Title',ctrl:'vBTNCHILDREN',prop:'Title'},{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'AV23IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV9ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV60ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV67GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV69GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV72IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV73IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV74IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV20IsAuthorized_BtnChildren',fld:'vISAUTHORIZED_BTNCHILDREN',pic:'',hsh:true},{av:'edtavBtnchildren_Visible',ctrl:'vBTNCHILDREN',prop:'Visible'},{av:'AV75IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV76IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV64ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV40GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VALIDV_PERMISSIONTYPEFILTER","{handler:'validv_Permissiontypefilter',iparms:[]");
      setEventMetadata("VALIDV_PERMISSIONTYPEFILTER",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Appid',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      return "gamwwapppermissions_Execute";
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
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV79Pgmname = "" ;
      AV16FilName = "" ;
      AV27PermissionAccessTypeDefault = "" ;
      AV28PermissionTypeFilter = "" ;
      AV24isAutomaticPermission = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV64ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV69GridAppliedFilters = "" ;
      AV40GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnback_Jsonclick = "" ;
      lblBtninsert_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV70Display = "" ;
      AV71Update = "" ;
      AV5Delete = "" ;
      AV11BtnChildren = "" ;
      AV19Id = "" ;
      AV25Name = "" ;
      AV14Dsc = "" ;
      AV6AccessType = "" ;
      AV36HTTPRequest = httpContext.getHttpRequest();
      AV8Application = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV37WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV17Filter = new genexus.security.api.genexussecurity.SdtGAMApplicationPermissionFilter(remoteHandle, context);
      AV30Permissions = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationPermission>(genexus.security.api.genexussecurity.SdtGAMApplicationPermission.class, "GAMApplicationPermission", "http://tempuri.org/", remoteHandle);
      AV15Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError6 = new GXExternalCollection[1] ;
      AV10AppPermission = new genexus.security.api.genexussecurity.SdtGAMApplicationPermission(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV61ManageFiltersXml = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection[1] ;
      AV59Session = httpContext.getWebSession();
      AV41GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState9 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      AV79Pgmname = "GAMWWAppPermissions" ;
      /* GeneXus formulas. */
      AV79Pgmname = "GAMWWAppPermissions" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavBtnchildren_Enabled = 0 ;
      edtavId_Enabled = 0 ;
      edtavName_Enabled = 0 ;
      edtavDsc_Enabled = 0 ;
      cmbavAccesstype.setEnabled( 0 );
      edtavAppid_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV60ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
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
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_56 ;
   private int nGXsfl_56_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtnback_Visible ;
   private int lblBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavBtnchildren_Enabled ;
   private int edtavId_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavAppid_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV26PageToGo ;
   private int AV80GXV1 ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtavBtnchildren_Visible ;
   private int AV81GXV2 ;
   private int edtavFilname_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV9ApplicationId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV9ApplicationId ;
   private long AV67GridCurrentPage ;
   private long AV18GridPageCount ;
   private long AV7AppId ;
   private long GRID_nCurrentRecord ;
   private long AV31GridPageSize ;
   private long AV32GridRecordCount ;
   private String edtavBtnchildren_Title ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_56_idx="0001" ;
   private String edtavBtnchildren_Internalname ;
   private String AV79Pgmname ;
   private String AV16FilName ;
   private String AV27PermissionAccessTypeDefault ;
   private String AV28PermissionTypeFilter ;
   private String AV24isAutomaticPermission ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ddo_managefilters_Icontype ;
   private String Ddo_managefilters_Icon ;
   private String Ddo_managefilters_Tooltip ;
   private String Ddo_managefilters_Cls ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableactions_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnback_Internalname ;
   private String bttBtnback_Jsonclick ;
   private String lblBtninsert_Internalname ;
   private String lblBtninsert_Caption ;
   private String lblBtninsert_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV70Display ;
   private String edtavDisplay_Internalname ;
   private String AV71Update ;
   private String edtavUpdate_Internalname ;
   private String AV5Delete ;
   private String edtavDelete_Internalname ;
   private String AV11BtnChildren ;
   private String AV19Id ;
   private String edtavId_Internalname ;
   private String AV25Name ;
   private String edtavName_Internalname ;
   private String AV14Dsc ;
   private String edtavDsc_Internalname ;
   private String AV6AccessType ;
   private String edtavAppid_Internalname ;
   private String edtavFilname_Internalname ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavBtnchildren_Link ;
   private String edtavName_Link ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilname_Jsonclick ;
   private String sGXsfl_56_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavBtnchildren_Jsonclick ;
   private String edtavId_Jsonclick ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Jsonclick ;
   private String GXCCtl ;
   private String edtavAppid_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_56_Refreshing=false ;
   private boolean AV72IsAuthorized_Display ;
   private boolean AV73IsAuthorized_Update ;
   private boolean AV74IsAuthorized_Delete ;
   private boolean AV20IsAuthorized_BtnChildren ;
   private boolean AV23IsAuthorized_Name ;
   private boolean AV75IsAuthorized_Back ;
   private boolean AV76IsAuthorized_Insert ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV61ManageFiltersXml ;
   private String AV69GridAppliedFilters ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV36HTTPRequest ;
   private com.genexus.webpanels.WebSession AV59Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationPermissionFilter AV17Filter ;
   private HTMLChoice cmbavPermissionaccesstypedefault ;
   private HTMLChoice cmbavPermissiontypefilter ;
   private HTMLChoice cmbavIsautomaticpermission ;
   private HTMLChoice cmbavAccesstype ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV15Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError6[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationPermission> AV30Permissions ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV64ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[] ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV8Application ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationPermission AV10AppPermission ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV37WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV40GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV41GridStateFilterValue ;
}

