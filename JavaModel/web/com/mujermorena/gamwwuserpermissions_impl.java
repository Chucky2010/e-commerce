package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwwuserpermissions_impl extends GXDataArea
{
   public gamwwuserpermissions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwwuserpermissions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwwuserpermissions_impl.class ));
   }

   public gamwwuserpermissions_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavApplicationid = new HTMLChoice();
      cmbavPermissionaccesstype = new HTMLChoice();
      cmbavBoolenfilter = new HTMLChoice();
      cmbavAccesstype = new HTMLChoice();
      chkavInherited = UIFactory.getCheckbox(this);
      cmbavOld_accesstype = new HTMLChoice();
      chkavOld_inherited = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "UserId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "UserId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "UserId") ;
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
            AV31UserId = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31UserId", AV31UserId);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31UserId, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV24pApplicationId = GXutil.lval( httpContext.GetPar( "pApplicationId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24pApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24pApplicationId), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24pApplicationId), "ZZZZZZZZZZZ9")));
            }
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
      AV47ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV60Pgmname = httpContext.GetPar( "Pgmname") ;
      cmbavApplicationid.fromJSonString( httpContext.GetNextPar( ));
      AV10ApplicationId = GXutil.lval( httpContext.GetPar( "ApplicationId")) ;
      AV16FilName = httpContext.GetPar( "FilName") ;
      cmbavPermissionaccesstype.fromJSonString( httpContext.GetNextPar( ));
      AV26PermissionAccessType = httpContext.GetPar( "PermissionAccessType") ;
      cmbavBoolenfilter.fromJSonString( httpContext.GetNextPar( ));
      AV11BoolenFilter = httpContext.GetPar( "BoolenFilter") ;
      AV31UserId = httpContext.GetPar( "UserId") ;
      AV30SearchFilter = httpContext.GetPar( "SearchFilter") ;
      AV52IsAuthorized_Back = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Back")) ;
      AV53IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      AV24pApplicationId = GXutil.lval( httpContext.GetPar( "pApplicationId")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
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
      pa3E2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start3E2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwwuserpermissions", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31UserId)),GXutil.URLEncode(GXutil.ltrimstr(AV24pApplicationId,12,0))}, new String[] {"UserId","pApplicationId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV60Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31UserId, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEARCHFILTER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30SearchFilter, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV52IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV53IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24pApplicationId), "ZZZZZZZZZZZ9")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV45ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV45ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV49GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV50GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV55GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV47ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV60Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV60Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERID", GXutil.rtrim( AV31UserId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31UserId, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSEARCHFILTER", GXutil.rtrim( AV30SearchFilter));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEARCHFILTER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30SearchFilter, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV42GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV42GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BACK", AV52IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV52IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV53IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV53IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISOK", AV20isOK);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV24pApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24pApplicationId), "ZZZZZZZZZZZ9")));
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
         we3E2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt3E2( ) ;
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
      return formatLink("com.mujermorena.gamwwuserpermissions", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31UserId)),GXutil.URLEncode(GXutil.ltrimstr(AV24pApplicationId,12,0))}, new String[] {"UserId","pApplicationId"})  ;
   }

   public String getPgmname( )
   {
      return "GAMWWUserPermissions" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_UserPermissions", "") ;
   }

   public void wb3E0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 17,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnback_Internalname, "gx.evt.setGridEvt("+GXutil.str( 56, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_Back", ""), bttBtnback_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_Back", ""), "", StyleString, ClassString, bttBtnback_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBACK\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWWUserPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_GAMWWUserPermissions.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnsave_Internalname, "gx.evt.setGridEvt("+GXutil.str( 56, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_SaveChanges", ""), bttBtnsave_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_SaveChanges", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSAVE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWWUserPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6 CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_22_3E2( true) ;
      }
      else
      {
         wb_table1_22_3E2( false) ;
      }
      return  ;
   }

   public void wb_table1_22_3E2e( boolean wbgen )
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
         ucGridpaginationbar.setProperty("CurrentPage", AV49GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV50GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV55GridAppliedFilters);
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

   public void start3E2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_UserPermissions", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup3E0( ) ;
   }

   public void ws3E2( )
   {
      start3E2( ) ;
      evt3E2( ) ;
   }

   public void evt3E2( )
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
                           e113E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e123E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e133E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBACK'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBack' */
                           e143E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e153E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSAVE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSave' */
                           e163E2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VDELETE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 13), "VDELETE.CLICK") == 0 ) )
                        {
                           nGXsfl_56_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_562( ) ;
                           AV51Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV51Delete);
                           AV21Name = httpContext.cgiGet( edtavName_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV21Name);
                           AV13Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV13Dsc);
                           cmbavAccesstype.setName( cmbavAccesstype.getInternalname() );
                           cmbavAccesstype.setValue( httpContext.cgiGet( cmbavAccesstype.getInternalname()) );
                           AV7AccessType = httpContext.cgiGet( cmbavAccesstype.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV7AccessType);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV7AccessType, ""))));
                           AV19Inherited = GXutil.strtobool( httpContext.cgiGet( chkavInherited.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV19Inherited));
                           AV12BtnDlt = httpContext.cgiGet( edtavBtndlt_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtndlt_Internalname, AV12BtnDlt);
                           cmbavOld_accesstype.setName( cmbavOld_accesstype.getInternalname() );
                           cmbavOld_accesstype.setValue( httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) );
                           AV22old_AccessType = httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV22old_AccessType);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV22old_AccessType, ""))));
                           AV23old_Inherited = GXutil.strtobool( httpContext.cgiGet( chkavOld_inherited.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV23old_Inherited);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV23old_Inherited));
                           AV18Id = httpContext.cgiGet( edtavId_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV18Id);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV18Id, ""))));
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e173E2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e183E2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e193E2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e203E2 ();
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

   public void we3E2( )
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

   public void pa3E2( )
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
            GX_FocusControl = cmbavApplicationid.getInternalname() ;
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
                                 byte AV47ManageFiltersExecutionStep ,
                                 String AV60Pgmname ,
                                 long AV10ApplicationId ,
                                 String AV16FilName ,
                                 String AV26PermissionAccessType ,
                                 String AV11BoolenFilter ,
                                 String AV31UserId ,
                                 String AV30SearchFilter ,
                                 boolean AV52IsAuthorized_Back ,
                                 boolean AV53IsAuthorized_Insert ,
                                 long AV24pApplicationId )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e183E2 ();
      GRID_nCurrentRecord = 0 ;
      rf3E2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vACCESSTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7AccessType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vACCESSTYPE", GXutil.rtrim( AV7AccessType));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22old_AccessType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vOLD_ACCESSTYPE", GXutil.rtrim( AV22old_AccessType));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINHERITED", getSecureSignedToken( "", AV19Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINHERITED", GXutil.booltostr( AV19Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED", getSecureSignedToken( "", AV23old_Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vOLD_INHERITED", GXutil.booltostr( AV23old_Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18Id, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.rtrim( AV18Id));
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
      if ( cmbavApplicationid.getItemCount() > 0 )
      {
         AV10ApplicationId = GXutil.lval( cmbavApplicationid.getValidValue(GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavApplicationid.setValue( GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavApplicationid.getInternalname(), "Values", cmbavApplicationid.ToJavascriptSource(), true);
      }
      if ( cmbavPermissionaccesstype.getItemCount() > 0 )
      {
         AV26PermissionAccessType = cmbavPermissionaccesstype.getValidValue(AV26PermissionAccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26PermissionAccessType", AV26PermissionAccessType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV26PermissionAccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
      }
      if ( cmbavBoolenfilter.getItemCount() > 0 )
      {
         AV11BoolenFilter = cmbavBoolenfilter.getValidValue(AV11BoolenFilter) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavBoolenfilter.setValue( GXutil.rtrim( AV11BoolenFilter) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavBoolenfilter.getInternalname(), "Values", cmbavBoolenfilter.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3E2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV60Pgmname = "GAMWWUserPermissions" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      cmbavAccesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAccesstype.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      chkavInherited.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavInherited.getInternalname(), "Enabled", GXutil.ltrimstr( chkavInherited.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      edtavBtndlt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtndlt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtndlt_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      cmbavOld_accesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavOld_accesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOld_accesstype.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      chkavOld_inherited.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOld_inherited.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_56_Refreshing);
   }

   public void rf3E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(56) ;
      /* Execute user event: Refresh */
      e183E2 ();
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
         e193E2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_56_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e193E2 ();
         }
         wbEnd = (short)(56) ;
         wb3E0( ) ;
      }
      bGXsfl_56_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes3E2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV60Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV60Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERID", GXutil.rtrim( AV31UserId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31UserId, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSEARCHFILTER", GXutil.rtrim( AV30SearchFilter));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEARCHFILTER", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30SearchFilter, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BACK", AV52IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV52IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV53IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV53IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV7AccessType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV22old_AccessType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV19Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV23old_Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV18Id, ""))));
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
         gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV60Pgmname = "GAMWWUserPermissions" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      cmbavAccesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAccesstype.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      chkavInherited.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavInherited.getInternalname(), "Enabled", GXutil.ltrimstr( chkavInherited.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      edtavBtndlt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtndlt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtndlt_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      cmbavOld_accesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavOld_accesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOld_accesstype.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      chkavOld_inherited.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOld_inherited.getEnabled(), 5, 0), !bGXsfl_56_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_56_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup3E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e173E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV45ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_56 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_56"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV49GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV50GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV55GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         cmbavApplicationid.setName( cmbavApplicationid.getInternalname() );
         cmbavApplicationid.setValue( httpContext.cgiGet( cmbavApplicationid.getInternalname()) );
         AV10ApplicationId = GXutil.lval( httpContext.cgiGet( cmbavApplicationid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
         AV16FilName = httpContext.cgiGet( edtavFilname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16FilName", AV16FilName);
         cmbavPermissionaccesstype.setName( cmbavPermissionaccesstype.getInternalname() );
         cmbavPermissionaccesstype.setValue( httpContext.cgiGet( cmbavPermissionaccesstype.getInternalname()) );
         AV26PermissionAccessType = httpContext.cgiGet( cmbavPermissionaccesstype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26PermissionAccessType", AV26PermissionAccessType);
         cmbavBoolenfilter.setName( cmbavBoolenfilter.getInternalname() );
         cmbavBoolenfilter.setValue( httpContext.cgiGet( cmbavBoolenfilter.getInternalname()) );
         AV11BoolenFilter = httpContext.cgiGet( cmbavBoolenfilter.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
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
      e173E2 ();
      if (returnInSub) return;
   }

   public void e173E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      cmbavApplicationid.removeAllItems();
      cmbavApplicationid.addItem("0", httpContext.getMessage( "(Select)", ""), (short)(0));
      AV59GXV2 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV15Errors ;
      AV58GXV1 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getapplications(AV9ApplicationFilter, GXv_objcol_SdtGAMError1) ;
      AV15Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV59GXV2 <= AV58GXV1.size() )
      {
         AV8Application = (genexus.security.api.genexussecurity.SdtGAMApplication)((genexus.security.api.genexussecurity.SdtGAMApplication)AV58GXV1.elementAt(-1+AV59GXV2));
         cmbavApplicationid.addItem(GXutil.trim( GXutil.str( AV8Application.getgxTv_SdtGAMApplication_Id(), 12, 0)), AV8Application.getgxTv_SdtGAMApplication_Name(), (short)(0));
         AV59GXV2 = (int)(AV59GXV2+1) ;
      }
      if ( cmbavApplicationid.getItemCount() == 2 )
      {
         AV10ApplicationId = AV8Application.getgxTv_SdtGAMApplication_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      }
      else
      {
         AV10ApplicationId = AV24pApplicationId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      }
      AV32GAMUser.load(AV31UserId);
      AV35UserName = GXutil.trim( AV32GAMUser.getgxTv_SdtGAMUser_Firstname()) + " " + GXutil.trim( AV32GAMUser.getgxTv_SdtGAMUser_Lastname()) ;
      if ( (GXutil.strcmp("", AV35UserName)==0) )
      {
         AV35UserName = GXutil.trim( AV32GAMUser.getgxTv_SdtGAMUser_Login()) ;
      }
      Form.setCaption( GXutil.format( httpContext.getMessage( "WWP_GAM_PermissionsOfUser", ""), AV35UserName, "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV39HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      lblBtninsert_Caption = GXutil.format( "<i class='fas fa-plus' title='%1'></i>", httpContext.getMessage( "GXM_insert", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Caption", lblBtninsert_Caption, true);
      Form.setCaption( httpContext.getMessage( "WWP_GAM_UserPermissions", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e183E2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext2[0] = AV37WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext2) ;
      AV37WWPContext = GXv_SdtWWPContext2[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      if ( AV47ManageFiltersExecutionStep == 1 )
      {
         AV47ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ManageFiltersExecutionStep", GXutil.str( AV47ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV47ManageFiltersExecutionStep == 2 )
      {
         AV47ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ManageFiltersExecutionStep", GXutil.str( AV47ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV49GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49GridCurrentPage), 10, 0));
      GXt_char3 = AV55GridAppliedFilters ;
      GXv_char4[0] = GXt_char3 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV60Pgmname, GXv_char4) ;
      gamwwuserpermissions_impl.this.GXt_char3 = GXv_char4[0] ;
      AV55GridAppliedFilters = GXt_char3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55GridAppliedFilters", AV55GridAppliedFilters);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV45ManageFiltersData", AV45ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42GridState", AV42GridState);
   }

   public void e123E2( )
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
         AV48PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV48PageToGo) ;
      }
   }

   public void e133E2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e193E2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV6GridPageSize = subGrid_Rows ;
      AV32GAMUser.load(AV31UserId);
      AV33GAMUserName = AV32GAMUser.getgxTv_SdtGAMUser_Name() ;
      AV34UserPermissionFilter.setgxTv_SdtGAMPermissionFilter_Applicationid( AV10ApplicationId );
      if ( ! (GXutil.strcmp("", AV16FilName)==0) )
      {
         AV34UserPermissionFilter.setgxTv_SdtGAMPermissionFilter_Name( "%"+AV16FilName );
      }
      else
      {
         AV34UserPermissionFilter.setgxTv_SdtGAMPermissionFilter_Name( "%"+AV30SearchFilter );
      }
      AV34UserPermissionFilter.setgxTv_SdtGAMPermissionFilter_Accesstype( AV26PermissionAccessType );
      AV34UserPermissionFilter.setgxTv_SdtGAMPermissionFilter_Inherited( AV11BoolenFilter );
      if ( ! (0==AV10ApplicationId) )
      {
         GXv_objcol_SdtGAMError1[0] = AV15Errors ;
         AV54Permissions = AV32GAMUser.getpermissions(AV34UserPermissionFilter, GXv_objcol_SdtGAMError1) ;
         AV15Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV54Permissions.size() == 0 )
         {
            AV50GridPageCount = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50GridPageCount), 10, 0));
         }
         else
         {
            AV50GridPageCount = (long)((AV54Permissions.size()/ (double) (AV6GridPageSize))+((((int)((AV54Permissions.size()) % (AV6GridPageSize)))>0) ? 1 : 0)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50GridPageCount), 10, 0));
         }
         AV5GridRecordCount = AV54Permissions.size() ;
         AV61GXV3 = 1 ;
         while ( AV61GXV3 <= AV54Permissions.size() )
         {
            AV25Permission = (genexus.security.api.genexussecurity.SdtGAMPermission)((genexus.security.api.genexussecurity.SdtGAMPermission)AV54Permissions.elementAt(-1+AV61GXV3));
            AV12BtnDlt = "Delete" ;
            httpContext.ajax_rsp_assign_attri("", false, edtavBtndlt_Internalname, AV12BtnDlt);
            AV18Id = AV25Permission.getgxTv_SdtGAMPermission_Guid() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV18Id);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV18Id, ""))));
            AV21Name = AV25Permission.getgxTv_SdtGAMPermission_Name() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV21Name);
            AV13Dsc = AV25Permission.getgxTv_SdtGAMPermission_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV13Dsc);
            AV7AccessType = AV25Permission.getgxTv_SdtGAMPermission_Type() ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV7AccessType);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV7AccessType, ""))));
            AV19Inherited = AV25Permission.getgxTv_SdtGAMPermission_Inherited() ;
            httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV19Inherited));
            AV22old_AccessType = AV25Permission.getgxTv_SdtGAMPermission_Type() ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV22old_AccessType);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV22old_AccessType, ""))));
            AV23old_Inherited = AV25Permission.getgxTv_SdtGAMPermission_Inherited() ;
            httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV23old_Inherited);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV23old_Inherited));
            AV51Delete = "<i class=\"fa fa-times\"></i>" ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV51Delete);
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
            AV61GXV3 = (int)(AV61GXV3+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34UserPermissionFilter", AV34UserPermissionFilter);
      cmbavAccesstype.setValue( GXutil.rtrim( AV7AccessType) );
      cmbavOld_accesstype.setValue( GXutil.rtrim( AV22old_AccessType) );
   }

   public void e113E2( )
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
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWUserPermissionsFilters")),GXutil.URLEncode(GXutil.rtrim(AV60Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV47ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ManageFiltersExecutionStep", GXutil.str( AV47ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWUserPermissionsFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV47ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ManageFiltersExecutionStep", GXutil.str( AV47ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char3 = AV46ManageFiltersXml ;
         GXv_char4[0] = GXt_char3 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "GAMWWUserPermissionsFilters", Ddo_managefilters_Activeeventkey, GXv_char4) ;
         gamwwuserpermissions_impl.this.GXt_char3 = GXv_char4[0] ;
         AV46ManageFiltersXml = GXt_char3 ;
         if ( (GXutil.strcmp("", AV46ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S152 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV60Pgmname+"GridState", AV46ManageFiltersXml) ;
            AV42GridState.fromxml(AV46ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S162 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42GridState", AV42GridState);
      cmbavApplicationid.setValue( GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavApplicationid.getInternalname(), "Values", cmbavApplicationid.ToJavascriptSource(), true);
      cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV26PermissionAccessType) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
      cmbavBoolenfilter.setValue( GXutil.rtrim( AV11BoolenFilter) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavBoolenfilter.getInternalname(), "Values", cmbavBoolenfilter.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV45ManageFiltersData", AV45ManageFiltersData);
   }

   public void e143E2( )
   {
      /* 'DoBack' Routine */
      returnInSub = false ;
      if ( AV52IsAuthorized_Back )
      {
         callWebObject(formatLink("com.mujermorena.gamwwusers", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV45ManageFiltersData", AV45ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42GridState", AV42GridState);
   }

   public void e153E2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( ! (0==AV10ApplicationId) )
      {
         if ( AV53IsAuthorized_Insert )
         {
            callWebObject(formatLink("com.mujermorena.gamuserpermissionselect", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31UserId)),GXutil.URLEncode(GXutil.ltrimstr(AV10ApplicationId,12,0))}, new String[] {"UserId","ApplicationId"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
            httpContext.doAjaxRefresh();
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_GAM_SelectApplication", ""));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV45ManageFiltersData", AV45ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42GridState", AV42GridState);
   }

   public void e163E2( )
   {
      /* 'DoSave' Routine */
      returnInSub = false ;
      AV32GAMUser.load(AV31UserId);
      /* Start For Each Line */
      nRC_GXsfl_56 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_56"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_56_fel_idx = 0 ;
      while ( nGXsfl_56_fel_idx < nRC_GXsfl_56 )
      {
         nGXsfl_56_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_56_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_56_fel_idx+1) ;
         sGXsfl_56_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_562( ) ;
         AV51Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
         AV21Name = httpContext.cgiGet( edtavName_Internalname) ;
         AV13Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         cmbavAccesstype.setName( cmbavAccesstype.getInternalname() );
         cmbavAccesstype.setValue( httpContext.cgiGet( cmbavAccesstype.getInternalname()) );
         AV7AccessType = httpContext.cgiGet( cmbavAccesstype.getInternalname()) ;
         AV19Inherited = GXutil.strtobool( httpContext.cgiGet( chkavInherited.getInternalname())) ;
         AV12BtnDlt = httpContext.cgiGet( edtavBtndlt_Internalname) ;
         cmbavOld_accesstype.setName( cmbavOld_accesstype.getInternalname() );
         cmbavOld_accesstype.setValue( httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) );
         AV22old_AccessType = httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) ;
         AV23old_Inherited = GXutil.strtobool( httpContext.cgiGet( chkavOld_inherited.getInternalname())) ;
         AV18Id = httpContext.cgiGet( edtavId_Internalname) ;
         if ( ( GXutil.strcmp(AV7AccessType, AV22old_AccessType) != 0 ) || ( AV19Inherited != AV23old_Inherited ) )
         {
            AV27PermissionUpd.setgxTv_SdtGAMPermission_Applicationid( AV10ApplicationId );
            AV27PermissionUpd.setgxTv_SdtGAMPermission_Guid( AV18Id );
            AV27PermissionUpd.setgxTv_SdtGAMPermission_Type( AV7AccessType );
            AV27PermissionUpd.setgxTv_SdtGAMPermission_Inherited( AV19Inherited );
            GXv_objcol_SdtGAMError1[0] = AV15Errors ;
            AV20isOK = AV32GAMUser.updatepermission(AV27PermissionUpd, GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20isOK", AV20isOK);
            AV15Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( ! AV20isOK )
            {
               AV63GXV4 = 1 ;
               while ( AV63GXV4 <= AV15Errors.size() )
               {
                  AV14Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV15Errors.elementAt(-1+AV63GXV4));
                  httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV14Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV14Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
                  AV63GXV4 = (int)(AV63GXV4+1) ;
               }
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         /* End For Each Line */
      }
      if ( nGXsfl_56_fel_idx == 0 )
      {
         nGXsfl_56_idx = 1 ;
         sGXsfl_56_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_56_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_562( ) ;
      }
      nGXsfl_56_fel_idx = 1 ;
      if ( AV20isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwwuserpermissions");
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Changes saved successfully.", ""));
      }
      else
      {
         AV64GXV5 = 1 ;
         while ( AV64GXV5 <= AV15Errors.size() )
         {
            AV14Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV15Errors.elementAt(-1+AV64GXV5));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV14Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV14Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV64GXV5 = (int)(AV64GXV5+1) ;
         }
      }
      gxgrgrid_refresh( subGrid_Rows, AV47ManageFiltersExecutionStep, AV60Pgmname, AV10ApplicationId, AV16FilName, AV26PermissionAccessType, AV11BoolenFilter, AV31UserId, AV30SearchFilter, AV52IsAuthorized_Back, AV53IsAuthorized_Insert, AV24pApplicationId) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27PermissionUpd", AV27PermissionUpd);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV45ManageFiltersData", AV45ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42GridState", AV42GridState);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean5 = AV52IsAuthorized_Back ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamwwusers_Execute", GXv_boolean6) ;
      gamwwuserpermissions_impl.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV52IsAuthorized_Back = GXt_boolean5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52IsAuthorized_Back", AV52IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV52IsAuthorized_Back));
      if ( ! ( AV52IsAuthorized_Back ) )
      {
         bttBtnback_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnback_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnback_Visible), 5, 0), true);
      }
      GXt_boolean5 = AV53IsAuthorized_Insert ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamuserpermissionselect_Execute", GXv_boolean6) ;
      gamwwuserpermissions_impl.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV53IsAuthorized_Insert = GXt_boolean5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53IsAuthorized_Insert", AV53IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV53IsAuthorized_Insert));
      if ( ! ( AV53IsAuthorized_Insert ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = AV45ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "GAMWWUserPermissionsFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] ;
      AV45ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   }

   public void S152( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV10ApplicationId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      AV16FilName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16FilName", AV16FilName);
      AV26PermissionAccessType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26PermissionAccessType", AV26PermissionAccessType);
      AV11BoolenFilter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV44Session.getValue(AV60Pgmname+"GridState"), "") == 0 )
      {
         AV42GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV60Pgmname+"GridState"), null, null);
      }
      else
      {
         AV42GridState.fromxml(AV44Session.getValue(AV60Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV42GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV42GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV42GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S162( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV65GXV6 = 1 ;
      while ( AV65GXV6 <= AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV43GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV65GXV6));
         if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "APPLICATIONID") == 0 )
         {
            AV10ApplicationId = GXutil.lval( AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILNAME") == 0 )
         {
            AV16FilName = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16FilName", AV16FilName);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PERMISSIONACCESSTYPE") == 0 )
         {
            AV26PermissionAccessType = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26PermissionAccessType", AV26PermissionAccessType);
         }
         else if ( GXutil.strcmp(AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "BOOLENFILTER") == 0 )
         {
            AV11BoolenFilter = AV43GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
         }
         AV65GXV6 = (int)(AV65GXV6+1) ;
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV42GridState.fromxml(AV44Session.getValue(AV60Pgmname+"GridState"), null, null);
      AV42GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV42GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "APPLICATIONID", httpContext.getMessage( "WWP_GAM_Application", ""), !(0==AV10ApplicationId), (short)(0), GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)), "") ;
      AV42GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV42GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILNAME", httpContext.getMessage( "WWP_GAM_Search", ""), !(GXutil.strcmp("", AV16FilName)==0), (short)(0), AV16FilName, "") ;
      AV42GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV42GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "PERMISSIONACCESSTYPE", httpContext.getMessage( "WWP_GAM_AccessType", ""), !(GXutil.strcmp("", AV26PermissionAccessType)==0), (short)(0), AV26PermissionAccessType, "") ;
      AV42GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV42GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "BOOLENFILTER", httpContext.getMessage( "WWP_GAM_Inherited", ""), !(GXutil.strcmp("", AV11BoolenFilter)==0), (short)(0), AV11BoolenFilter, "") ;
      AV42GridState = GXv_SdtWWPGridState9[0] ;
      AV42GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV42GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV60Pgmname+"GridState", AV42GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e203E2( )
   {
      /* Delete_Click Routine */
      returnInSub = false ;
      AV32GAMUser.load(AV31UserId);
      GXv_objcol_SdtGAMError1[0] = AV15Errors ;
      AV20isOK = AV32GAMUser.deletepermissionbyid(AV10ApplicationId, AV18Id, GXv_objcol_SdtGAMError1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20isOK", AV20isOK);
      AV15Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV20isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwwuserpermissions");
      }
      else
      {
         AV66GXV7 = 1 ;
         while ( AV66GXV7 <= AV15Errors.size() )
         {
            AV14Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV15Errors.elementAt(-1+AV66GXV7));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV14Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV14Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV66GXV7 = (int)(AV66GXV7+1) ;
         }
      }
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV45ManageFiltersData", AV45ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42GridState", AV42GridState);
   }

   public void wb_table1_22_3E2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV45ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablefilters_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavApplicationid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavApplicationid.getInternalname(), httpContext.getMessage( "WWP_GAM_Application", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavApplicationid, cmbavApplicationid.getInternalname(), GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)), 1, cmbavApplicationid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavApplicationid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_GAMWWUserPermissions.htm");
         cmbavApplicationid.setValue( GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavApplicationid.getInternalname(), "Values", cmbavApplicationid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFilname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFilname_Internalname, httpContext.getMessage( "WWP_GAM_Search", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilname_Internalname, AV16FilName, GXutil.rtrim( localUtil.format( AV16FilName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFilname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilname_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMWWUserPermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPermissionaccesstype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavPermissionaccesstype.getInternalname(), httpContext.getMessage( "WWP_GAM_AccessType", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPermissionaccesstype, cmbavPermissionaccesstype.getInternalname(), GXutil.rtrim( AV26PermissionAccessType), 1, cmbavPermissionaccesstype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPermissionaccesstype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_GAMWWUserPermissions.htm");
         cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV26PermissionAccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavBoolenfilter.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavBoolenfilter.getInternalname(), httpContext.getMessage( "WWP_GAM_Inherited", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_56_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavBoolenfilter, cmbavBoolenfilter.getInternalname(), GXutil.rtrim( AV11BoolenFilter), 1, cmbavBoolenfilter.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavBoolenfilter.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_GAMWWUserPermissions.htm");
         cmbavBoolenfilter.setValue( GXutil.rtrim( AV11BoolenFilter) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavBoolenfilter.getInternalname(), "Values", cmbavBoolenfilter.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_3E2e( true) ;
      }
      else
      {
         wb_table1_22_3E2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV31UserId = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31UserId", AV31UserId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV31UserId, ""))));
      AV24pApplicationId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24pApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24pApplicationId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV24pApplicationId), "ZZZZZZZZZZZ9")));
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
      pa3E2( ) ;
      ws3E2( ) ;
      we3E2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211122127", true, true);
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
      httpContext.AddJavascriptSource("gamwwuserpermissions.js", "?20241211122137", false, true);
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
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_56_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_56_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_56_idx ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE_"+sGXsfl_56_idx );
      chkavInherited.setInternalname( "vINHERITED_"+sGXsfl_56_idx );
      edtavBtndlt_Internalname = "vBTNDLT_"+sGXsfl_56_idx ;
      cmbavOld_accesstype.setInternalname( "vOLD_ACCESSTYPE_"+sGXsfl_56_idx );
      chkavOld_inherited.setInternalname( "vOLD_INHERITED_"+sGXsfl_56_idx );
      edtavId_Internalname = "vID_"+sGXsfl_56_idx ;
   }

   public void subsflControlProps_fel_562( )
   {
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_56_fel_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_56_fel_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_56_fel_idx ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE_"+sGXsfl_56_fel_idx );
      chkavInherited.setInternalname( "vINHERITED_"+sGXsfl_56_fel_idx );
      edtavBtndlt_Internalname = "vBTNDLT_"+sGXsfl_56_fel_idx ;
      cmbavOld_accesstype.setInternalname( "vOLD_ACCESSTYPE_"+sGXsfl_56_fel_idx );
      chkavOld_inherited.setInternalname( "vOLD_INHERITED_"+sGXsfl_56_fel_idx );
      edtavId_Internalname = "vID_"+sGXsfl_56_fel_idx ;
   }

   public void sendrow_562( )
   {
      subsflControlProps_562( ) ;
      wb3E0( ) ;
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
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 57,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV51Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,57);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDELETE.CLICK."+sGXsfl_56_idx+"'","","",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 58,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavName_Internalname,GXutil.rtrim( AV21Name),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,58);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavName_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(120),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionMedium","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDsc_Enabled!=0)&&(edtavDsc_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 59,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDsc_Internalname,GXutil.rtrim( AV13Dsc),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDsc_Enabled!=0)&&(edtavDsc_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,59);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDsc_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDsc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavAccesstype.getEnabled()!=0)&&(cmbavAccesstype.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 60,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         if ( ( cmbavAccesstype.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vACCESSTYPE_" + sGXsfl_56_idx ;
            cmbavAccesstype.setName( GXCCtl );
            cmbavAccesstype.setWebtags( "" );
            cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
            cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
            if ( cmbavAccesstype.getItemCount() > 0 )
            {
               AV7AccessType = cmbavAccesstype.getValidValue(AV7AccessType) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV7AccessType);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV7AccessType, ""))));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavAccesstype,cmbavAccesstype.getInternalname(),GXutil.rtrim( AV7AccessType),Integer.valueOf(1),cmbavAccesstype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavAccesstype.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavAccesstype.getEnabled()!=0)&&(cmbavAccesstype.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,60);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavAccesstype.setValue( GXutil.rtrim( AV7AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Values", cmbavAccesstype.ToJavascriptSource(), !bGXsfl_56_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavInherited.getEnabled()!=0)&&(chkavInherited.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 61,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vINHERITED_" + sGXsfl_56_idx ;
         chkavInherited.setName( GXCCtl );
         chkavInherited.setWebtags( "" );
         chkavInherited.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavInherited.getInternalname(), "TitleCaption", chkavInherited.getCaption(), !bGXsfl_56_Refreshing);
         chkavInherited.setCheckedValue( "false" );
         AV19Inherited = GXutil.strtobool( GXutil.booltostr( AV19Inherited)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV19Inherited));
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavInherited.getInternalname(),GXutil.booltostr( AV19Inherited),"","",Integer.valueOf(-1),Integer.valueOf(chkavInherited.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(61, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavInherited.getEnabled()!=0)&&(chkavInherited.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,61);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavBtndlt_Enabled!=0)&&(edtavBtndlt_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 62,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtndlt_Internalname,GXutil.rtrim( AV12BtnDlt),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavBtndlt_Enabled!=0)&&(edtavBtndlt_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,62);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavBtndlt_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavBtndlt_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         TempTags = " " + ((cmbavOld_accesstype.getEnabled()!=0)&&(cmbavOld_accesstype.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 63,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         if ( ( cmbavOld_accesstype.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vOLD_ACCESSTYPE_" + sGXsfl_56_idx ;
            cmbavOld_accesstype.setName( GXCCtl );
            cmbavOld_accesstype.setWebtags( "" );
            cmbavOld_accesstype.addItem("A", httpContext.getMessage( "Allow", ""), (short)(0));
            cmbavOld_accesstype.addItem("D", httpContext.getMessage( "Deny", ""), (short)(0));
            cmbavOld_accesstype.addItem("R", httpContext.getMessage( "Restricted", ""), (short)(0));
            if ( cmbavOld_accesstype.getItemCount() > 0 )
            {
               AV22old_AccessType = cmbavOld_accesstype.getValidValue(AV22old_AccessType) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV22old_AccessType);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV22old_AccessType, ""))));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavOld_accesstype,cmbavOld_accesstype.getInternalname(),GXutil.rtrim( AV22old_AccessType),Integer.valueOf(1),cmbavOld_accesstype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(cmbavOld_accesstype.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavOld_accesstype.getEnabled()!=0)&&(cmbavOld_accesstype.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,63);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavOld_accesstype.setValue( GXutil.rtrim( AV22old_AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavOld_accesstype.getInternalname(), "Values", cmbavOld_accesstype.ToJavascriptSource(), !bGXsfl_56_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavOld_inherited.getEnabled()!=0)&&(chkavOld_inherited.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 64,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vOLD_INHERITED_" + sGXsfl_56_idx ;
         chkavOld_inherited.setName( GXCCtl );
         chkavOld_inherited.setWebtags( "" );
         chkavOld_inherited.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "TitleCaption", chkavOld_inherited.getCaption(), !bGXsfl_56_Refreshing);
         chkavOld_inherited.setCheckedValue( "false" );
         AV23old_Inherited = GXutil.strtobool( GXutil.booltostr( AV23old_Inherited)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV23old_Inherited);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV23old_Inherited));
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavOld_inherited.getInternalname(),GXutil.booltostr( AV23old_Inherited),"","",Integer.valueOf(0),Integer.valueOf(chkavOld_inherited.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(64, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavOld_inherited.getEnabled()!=0)&&(chkavOld_inherited.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,64);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 65,'',false,'"+sGXsfl_56_idx+"',56)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavId_Internalname,GXutil.rtrim( AV18Id),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,65);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavId_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(56),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes3E2( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_PermissionName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Description", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_AccessType", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidthCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Inherited", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Revoke", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "old_Access Type", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidthCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "old_Inherited", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV51Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV21Name));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavName_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV13Dsc));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDsc_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV7AccessType));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavAccesstype.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV19Inherited));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavInherited.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12BtnDlt));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtndlt_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV22old_AccessType));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavOld_accesstype.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV23old_Inherited));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavOld_inherited.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18Id));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavId_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      bttBtnback_Internalname = "BTNBACK" ;
      lblBtninsert_Internalname = "BTNINSERT" ;
      bttBtnsave_Internalname = "BTNSAVE" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      cmbavApplicationid.setInternalname( "vAPPLICATIONID" );
      edtavFilname_Internalname = "vFILNAME" ;
      cmbavPermissionaccesstype.setInternalname( "vPERMISSIONACCESSTYPE" );
      cmbavBoolenfilter.setInternalname( "vBOOLENFILTER" );
      divTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE" );
      chkavInherited.setInternalname( "vINHERITED" );
      edtavBtndlt_Internalname = "vBTNDLT" ;
      cmbavOld_accesstype.setInternalname( "vOLD_ACCESSTYPE" );
      chkavOld_inherited.setInternalname( "vOLD_INHERITED" );
      edtavId_Internalname = "vID" ;
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
      edtavId_Jsonclick = "" ;
      edtavId_Visible = 0 ;
      edtavId_Enabled = 1 ;
      chkavOld_inherited.setCaption( "" );
      chkavOld_inherited.setVisible( 0 );
      chkavOld_inherited.setEnabled( 1 );
      cmbavOld_accesstype.setJsonclick( "" );
      cmbavOld_accesstype.setVisible( 0 );
      cmbavOld_accesstype.setEnabled( 1 );
      edtavBtndlt_Jsonclick = "" ;
      edtavBtndlt_Visible = -1 ;
      edtavBtndlt_Enabled = 1 ;
      chkavInherited.setCaption( "" );
      chkavInherited.setVisible( -1 );
      chkavInherited.setEnabled( 1 );
      cmbavAccesstype.setJsonclick( "" );
      cmbavAccesstype.setVisible( -1 );
      cmbavAccesstype.setEnabled( 1 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Visible = -1 ;
      edtavDsc_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Visible = -1 ;
      edtavName_Enabled = 1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Visible = -1 ;
      edtavDelete_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      cmbavBoolenfilter.setJsonclick( "" );
      cmbavBoolenfilter.setEnabled( 1 );
      cmbavPermissionaccesstype.setJsonclick( "" );
      cmbavPermissionaccesstype.setEnabled( 1 );
      edtavFilname_Jsonclick = "" ;
      edtavFilname_Enabled = 1 ;
      cmbavApplicationid.setJsonclick( "" );
      cmbavApplicationid.setEnabled( 1 );
      lblBtninsert_Caption = httpContext.getMessage( "<i class='fas fa-plus' title='Agregar'></i>", "") ;
      lblBtninsert_Visible = 1 ;
      bttBtnback_Visible = 1 ;
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
      Form.setCaption( httpContext.getMessage( "WWP_GAM_UserPermissions", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavApplicationid.setName( "vAPPLICATIONID" );
      cmbavApplicationid.setWebtags( "" );
      if ( cmbavApplicationid.getItemCount() > 0 )
      {
         AV10ApplicationId = GXutil.lval( cmbavApplicationid.getValidValue(GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      }
      cmbavPermissionaccesstype.setName( "vPERMISSIONACCESSTYPE" );
      cmbavPermissionaccesstype.setWebtags( "" );
      cmbavPermissionaccesstype.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("A", httpContext.getMessage( "Allow", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("D", httpContext.getMessage( "Deny", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("R", httpContext.getMessage( "Restricted", ""), (short)(0));
      if ( cmbavPermissionaccesstype.getItemCount() > 0 )
      {
         AV26PermissionAccessType = cmbavPermissionaccesstype.getValidValue(AV26PermissionAccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26PermissionAccessType", AV26PermissionAccessType);
      }
      cmbavBoolenfilter.setName( "vBOOLENFILTER" );
      cmbavBoolenfilter.setWebtags( "" );
      cmbavBoolenfilter.addItem("A", httpContext.getMessage( "All", ""), (short)(0));
      cmbavBoolenfilter.addItem("T", httpContext.getMessage( "Yes", ""), (short)(0));
      cmbavBoolenfilter.addItem("F", httpContext.getMessage( "No", ""), (short)(0));
      if ( cmbavBoolenfilter.getItemCount() > 0 )
      {
         AV11BoolenFilter = cmbavBoolenfilter.getValidValue(AV11BoolenFilter) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
      }
      GXCCtl = "vACCESSTYPE_" + sGXsfl_56_idx ;
      cmbavAccesstype.setName( GXCCtl );
      cmbavAccesstype.setWebtags( "" );
      cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavAccesstype.getItemCount() > 0 )
      {
         AV7AccessType = cmbavAccesstype.getValidValue(AV7AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV7AccessType);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV7AccessType, ""))));
      }
      GXCCtl = "vINHERITED_" + sGXsfl_56_idx ;
      chkavInherited.setName( GXCCtl );
      chkavInherited.setWebtags( "" );
      chkavInherited.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavInherited.getInternalname(), "TitleCaption", chkavInherited.getCaption(), !bGXsfl_56_Refreshing);
      chkavInherited.setCheckedValue( "false" );
      AV19Inherited = GXutil.strtobool( GXutil.booltostr( AV19Inherited)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV19Inherited));
      GXCCtl = "vOLD_ACCESSTYPE_" + sGXsfl_56_idx ;
      cmbavOld_accesstype.setName( GXCCtl );
      cmbavOld_accesstype.setWebtags( "" );
      cmbavOld_accesstype.addItem("A", httpContext.getMessage( "Allow", ""), (short)(0));
      cmbavOld_accesstype.addItem("D", httpContext.getMessage( "Deny", ""), (short)(0));
      cmbavOld_accesstype.addItem("R", httpContext.getMessage( "Restricted", ""), (short)(0));
      if ( cmbavOld_accesstype.getItemCount() > 0 )
      {
         AV22old_AccessType = cmbavOld_accesstype.getValidValue(AV22old_AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV22old_AccessType);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, GXutil.rtrim( localUtil.format( AV22old_AccessType, ""))));
      }
      GXCCtl = "vOLD_INHERITED_" + sGXsfl_56_idx ;
      chkavOld_inherited.setName( GXCCtl );
      chkavOld_inherited.setWebtags( "" );
      chkavOld_inherited.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "TitleCaption", chkavOld_inherited.getCaption(), !bGXsfl_56_Refreshing);
      chkavOld_inherited.setCheckedValue( "false" );
      AV23old_Inherited = GXutil.strtobool( GXutil.booltostr( AV23old_Inherited)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV23old_Inherited);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_56_idx, getSecureSignedToken( sGXsfl_56_idx, AV23old_Inherited));
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV45ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e123E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e133E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e193E2',iparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV50GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV12BtnDlt',fld:'vBTNDLT',pic:''},{av:'AV18Id',fld:'vID',pic:'',hsh:true},{av:'AV21Name',fld:'vNAME',pic:''},{av:'AV13Dsc',fld:'vDSC',pic:''},{av:'cmbavAccesstype'},{av:'AV7AccessType',fld:'vACCESSTYPE',pic:'',hsh:true},{av:'AV19Inherited',fld:'vINHERITED',pic:'',hsh:true},{av:'cmbavOld_accesstype'},{av:'AV22old_AccessType',fld:'vOLD_ACCESSTYPE',pic:'',hsh:true},{av:'AV23old_Inherited',fld:'vOLD_INHERITED',pic:'',hsh:true},{av:'AV51Delete',fld:'vDELETE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e113E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV45ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOBACK'","{handler:'e143E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOBACK'",",oparms:[{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV45ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e153E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV45ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOSAVE'","{handler:'e163E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV7AccessType',fld:'vACCESSTYPE',grid:56,pic:'',hsh:true},{av:'nRC_GXsfl_56',ctrl:'GRID',grid:56,prop:'GridRC',grid:56},{av:'AV22old_AccessType',fld:'vOLD_ACCESSTYPE',grid:56,pic:'',hsh:true},{av:'AV19Inherited',fld:'vINHERITED',grid:56,pic:'',hsh:true},{av:'AV23old_Inherited',fld:'vOLD_INHERITED',grid:56,pic:'',hsh:true},{av:'AV18Id',fld:'vID',grid:56,pic:'',hsh:true},{av:'AV20isOK',fld:'vISOK',pic:''}]");
      setEventMetadata("'DOSAVE'",",oparms:[{av:'AV20isOK',fld:'vISOK',pic:''},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV45ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VDELETE.CLICK","{handler:'e203E2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV60Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV16FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV26PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV31UserId',fld:'vUSERID',pic:'',hsh:true},{av:'AV30SearchFilter',fld:'vSEARCHFILTER',pic:'',hsh:true},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV24pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV18Id',fld:'vID',pic:'',hsh:true}]");
      setEventMetadata("VDELETE.CLICK",",oparms:[{av:'AV20isOK',fld:'vISOK',pic:''},{av:'AV47ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV49GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV55GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV52IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV53IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV45ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV42GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VALIDV_PERMISSIONACCESSTYPE","{handler:'validv_Permissionaccesstype',iparms:[]");
      setEventMetadata("VALIDV_PERMISSIONACCESSTYPE",",oparms:[]}");
      setEventMetadata("VALIDV_BOOLENFILTER","{handler:'validv_Boolenfilter',iparms:[]");
      setEventMetadata("VALIDV_BOOLENFILTER",",oparms:[]}");
      setEventMetadata("VALIDV_ACCESSTYPE","{handler:'validv_Accesstype',iparms:[]");
      setEventMetadata("VALIDV_ACCESSTYPE",",oparms:[]}");
      setEventMetadata("VALIDV_OLD_ACCESSTYPE","{handler:'validv_Old_accesstype',iparms:[]");
      setEventMetadata("VALIDV_OLD_ACCESSTYPE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Id',iparms:[]");
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
      return "gamwwuserpermissions_Execute";
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
      wcpOAV31UserId = "" ;
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV31UserId = "" ;
      AV60Pgmname = "" ;
      AV16FilName = "" ;
      AV26PermissionAccessType = "" ;
      AV11BoolenFilter = "" ;
      AV30SearchFilter = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV45ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV55GridAppliedFilters = "" ;
      AV42GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnback_Jsonclick = "" ;
      lblBtninsert_Jsonclick = "" ;
      bttBtnsave_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV51Delete = "" ;
      AV21Name = "" ;
      AV13Dsc = "" ;
      AV7AccessType = "" ;
      AV12BtnDlt = "" ;
      AV22old_AccessType = "" ;
      AV18Id = "" ;
      AV58GXV1 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplication>(genexus.security.api.genexussecurity.SdtGAMApplication.class, "GAMApplication", "http://tempuri.org/", remoteHandle);
      AV9ApplicationFilter = new genexus.security.api.genexussecurity.SdtGAMApplicationFilter(remoteHandle, context);
      AV15Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV8Application = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV32GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV35UserName = "" ;
      AV39HTTPRequest = httpContext.getHttpRequest();
      AV37WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext2 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV33GAMUserName = "" ;
      AV34UserPermissionFilter = new genexus.security.api.genexussecurity.SdtGAMPermissionFilter(remoteHandle, context);
      AV54Permissions = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMPermission>(genexus.security.api.genexussecurity.SdtGAMPermission.class, "GAMPermission", "http://tempuri.org/", remoteHandle);
      AV25Permission = new genexus.security.api.genexussecurity.SdtGAMPermission(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV46ManageFiltersXml = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      AV27PermissionUpd = new genexus.security.api.genexussecurity.SdtGAMPermission(remoteHandle, context);
      AV14Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_boolean6 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection[1] ;
      AV44Session = httpContext.getWebSession();
      AV43GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState9 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwuserpermissions__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwuserpermissions__default(),
         new Object[] {
         }
      );
      AV60Pgmname = "GAMWWUserPermissions" ;
      /* GeneXus formulas. */
      AV60Pgmname = "GAMWWUserPermissions" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      edtavName_Enabled = 0 ;
      edtavDsc_Enabled = 0 ;
      cmbavAccesstype.setEnabled( 0 );
      chkavInherited.setEnabled( 0 );
      edtavBtndlt_Enabled = 0 ;
      cmbavOld_accesstype.setEnabled( 0 );
      chkavOld_inherited.setEnabled( 0 );
      edtavId_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV47ManageFiltersExecutionStep ;
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
   private int edtavDelete_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavBtndlt_Enabled ;
   private int edtavId_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV59GXV2 ;
   private int AV48PageToGo ;
   private int AV61GXV3 ;
   private int nGXsfl_56_fel_idx=1 ;
   private int AV63GXV4 ;
   private int AV64GXV5 ;
   private int AV65GXV6 ;
   private int AV66GXV7 ;
   private int edtavFilname_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavDelete_Visible ;
   private int edtavName_Visible ;
   private int edtavDsc_Visible ;
   private int edtavBtndlt_Visible ;
   private int edtavId_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV24pApplicationId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV24pApplicationId ;
   private long AV10ApplicationId ;
   private long AV49GridCurrentPage ;
   private long AV50GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long AV6GridPageSize ;
   private long AV5GridRecordCount ;
   private String wcpOAV31UserId ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV31UserId ;
   private String sGXsfl_56_idx="0001" ;
   private String AV60Pgmname ;
   private String AV26PermissionAccessType ;
   private String AV11BoolenFilter ;
   private String AV30SearchFilter ;
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
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnback_Internalname ;
   private String bttBtnback_Jsonclick ;
   private String lblBtninsert_Internalname ;
   private String lblBtninsert_Caption ;
   private String lblBtninsert_Jsonclick ;
   private String bttBtnsave_Internalname ;
   private String bttBtnsave_Jsonclick ;
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
   private String AV51Delete ;
   private String edtavDelete_Internalname ;
   private String AV21Name ;
   private String edtavName_Internalname ;
   private String AV13Dsc ;
   private String edtavDsc_Internalname ;
   private String AV7AccessType ;
   private String AV12BtnDlt ;
   private String edtavBtndlt_Internalname ;
   private String AV22old_AccessType ;
   private String AV18Id ;
   private String edtavId_Internalname ;
   private String edtavFilname_Internalname ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String sGXsfl_56_fel_idx="0001" ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String divTablefilters_Internalname ;
   private String edtavFilname_Jsonclick ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDelete_Jsonclick ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Jsonclick ;
   private String GXCCtl ;
   private String edtavBtndlt_Jsonclick ;
   private String edtavId_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV52IsAuthorized_Back ;
   private boolean AV53IsAuthorized_Insert ;
   private boolean AV20isOK ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV19Inherited ;
   private boolean AV23old_Inherited ;
   private boolean bGXsfl_56_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private String AV46ManageFiltersXml ;
   private String AV16FilName ;
   private String AV55GridAppliedFilters ;
   private String AV35UserName ;
   private String AV33GAMUserName ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV39HTTPRequest ;
   private com.genexus.webpanels.WebSession AV44Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private genexus.security.api.genexussecurity.SdtGAMPermission AV27PermissionUpd ;
   private genexus.security.api.genexussecurity.SdtGAMPermissionFilter AV34UserPermissionFilter ;
   private HTMLChoice cmbavApplicationid ;
   private HTMLChoice cmbavPermissionaccesstype ;
   private HTMLChoice cmbavBoolenfilter ;
   private HTMLChoice cmbavAccesstype ;
   private ICheckbox chkavInherited ;
   private HTMLChoice cmbavOld_accesstype ;
   private ICheckbox chkavOld_inherited ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplication> AV58GXV1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV15Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMPermission> AV54Permissions ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV45ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[] ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV8Application ;
   private genexus.security.api.genexussecurity.SdtGAMError AV14Error ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV32GAMUser ;
   private genexus.security.api.genexussecurity.SdtGAMPermission AV25Permission ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationFilter AV9ApplicationFilter ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV37WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV42GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV43GridStateFilterValue ;
}

final  class gamwwuserpermissions__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwwuserpermissions__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

