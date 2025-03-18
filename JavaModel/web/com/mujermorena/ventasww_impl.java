package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ventasww_impl extends GXDataArea
{
   public ventasww_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ventasww_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ventasww_impl.class ));
   }

   public ventasww_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
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
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_40 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_40"))) ;
      nGXsfl_40_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_40_idx"))) ;
      sGXsfl_40_idx = httpContext.GetPar( "sGXsfl_40_idx") ;
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
      AV21ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV41Pgmname = httpContext.GetPar( "Pgmname") ;
      AV15FilterFullText = httpContext.GetPar( "FilterFullText") ;
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV28IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV30IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV32IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV37IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV21ManageFiltersExecutionStep, AV41Pgmname, AV15FilterFullText, AV13OrderedBy, AV14OrderedDsc, AV28IsAuthorized_Display, AV30IsAuthorized_Update, AV32IsAuthorized_Delete, AV37IsAuthorized_Insert) ;
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
      pa122( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start122( ) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.ventasww", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV41Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV30IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV32IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV37IsAuthorized_Insert));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_40", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_40, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV19ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV19ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV24GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV25GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV26GridAppliedFilters);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vAGEXPORTDATA", AV35AGExportData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vAGEXPORTDATA", AV35AGExportData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV22DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV22DDO_TitleSettingsIcons);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV21ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV41Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV41Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV28IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV30IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV30IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV32IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV32IsAuthorized_Delete));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV11GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV11GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV37IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV37IsAuthorized_Insert));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Icontype", GXutil.rtrim( Ddo_agexport_Icontype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Icon", GXutil.rtrim( Ddo_agexport_Icon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Caption", GXutil.rtrim( Ddo_agexport_Caption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Cls", GXutil.rtrim( Ddo_agexport_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Titlecontrolidtoreplace", GXutil.rtrim( Ddo_agexport_Titlecontrolidtoreplace));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Width", GXutil.rtrim( Innewwindow1_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Height", GXutil.rtrim( Innewwindow1_Height));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "INNEWWINDOW1_Target", GXutil.rtrim( Innewwindow1_Target));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Activeeventkey", GXutil.rtrim( Ddo_agexport_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_MANAGEFILTERS_Activeeventkey", GXutil.rtrim( Ddo_managefilters_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_AGEXPORT_Activeeventkey", GXutil.rtrim( Ddo_agexport_Activeeventkey));
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
         we122( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt122( ) ;
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
      return formatLink("com.mujermorena.ventasww", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "VentasWW" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Ventas", "") ;
   }

   public void wb120( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-direction:column;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheadercontent_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "align-self:center;", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Ventas", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_VentasWW.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupFontIcons", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_VentasWW.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         ClassString = "ColumnsSelector" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnagexport_Internalname, "gx.evt.setGridEvt("+GXutil.str( 40, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_ExportData", ""), bttBtnagexport_Jsonclick, 0, httpContext.getMessage( "WWP_ExportData", ""), "", StyleString, ClassString, 1, 0, "standard", "'"+""+"'"+",false,"+"'"+""+"'", TempTags, "", httpContext.getButtonType( ), "HLP_VentasWW.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_22_122( true) ;
      }
      else
      {
         wb_table1_22_122( false) ;
      }
      return  ;
   }

   public void wb_table1_22_122e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridFixedColumnBorders HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol40( ) ;
      }
      if ( wbEnd == 40 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_40 = (int)(nGXsfl_40_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV24GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV25GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV26GridAppliedFilters);
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
         ucDdo_agexport.setProperty("IconType", Ddo_agexport_Icontype);
         ucDdo_agexport.setProperty("Icon", Ddo_agexport_Icon);
         ucDdo_agexport.setProperty("Caption", Ddo_agexport_Caption);
         ucDdo_agexport.setProperty("Cls", Ddo_agexport_Cls);
         ucDdo_agexport.setProperty("DropDownOptionsData", AV35AGExportData);
         ucDdo_agexport.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_agexport_Internalname, "DDO_AGEXPORTContainer");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV22DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucInnewwindow1.render(context, "innewwindow", Innewwindow1_Internalname, "INNEWWINDOW1Container");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 40 )
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

   public void start122( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Ventas", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup120( ) ;
   }

   public void ws122( )
   {
      start122( ) ;
      evt122( ) ;
   }

   public void evt122( )
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
                           e11122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_AGEXPORT.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15122 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e16122 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VIMPRIMIR.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VIMPRIMIR.CLICK") == 0 ) )
                        {
                           nGXsfl_40_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_402( ) ;
                           AV27Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV27Display);
                           AV29Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV29Update);
                           AV31Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV31Delete);
                           AV38Imprimir = httpContext.cgiGet( edtavImprimir_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavImprimir_Internalname, "Bitmap", ((GXutil.strcmp("", AV38Imprimir)==0) ? AV43Imprimir_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV38Imprimir))), !bGXsfl_40_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavImprimir_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV38Imprimir), true);
                           A19VentasId = localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A91VentasFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtVentasFecha_Internalname), 0)) ;
                           A4ClienteId = localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A251VentasPedido = localUtil.ctol( httpContext.cgiGet( edtVentasPedido_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A29TimbradoId = localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A125TimbradoNumero = localUtil.ctol( httpContext.cgiGet( edtTimbradoNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A309VentasSerie1 = (short)(localUtil.ctol( httpContext.cgiGet( edtVentasSerie1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A310VentasSerie2 = (short)(localUtil.ctol( httpContext.cgiGet( edtVentasSerie2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A311VentasNroFactura = localUtil.ctol( httpContext.cgiGet( edtVentasNroFactura_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A9TipoPagoId = localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A71TipoPagoNombre = httpContext.cgiGet( edtTipoPagoNombre_Internalname) ;
                           A242VentasSerial = localUtil.ctol( httpContext.cgiGet( edtVentasSerial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A239VentasTotalExento = localUtil.ctond( httpContext.cgiGet( edtVentasTotalExento_Internalname)) ;
                           n239VentasTotalExento = false ;
                           A236VentasTotal5 = localUtil.ctond( httpContext.cgiGet( edtVentasTotal5_Internalname)) ;
                           n236VentasTotal5 = false ;
                           A238VentasTotal10 = localUtil.ctond( httpContext.cgiGet( edtVentasTotal10_Internalname)) ;
                           n238VentasTotal10 = false ;
                           A240VentasTotal = localUtil.ctond( httpContext.cgiGet( edtVentasTotal_Internalname)) ;
                           n240VentasTotal = false ;
                           A235VentasTotalIva5 = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIva5_Internalname)) ;
                           n235VentasTotalIva5 = false ;
                           A237VentasTotalIva10 = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIva10_Internalname)) ;
                           n237VentasTotalIva10 = false ;
                           A241VentasTotalIVA = localUtil.ctond( httpContext.cgiGet( edtVentasTotalIVA_Internalname)) ;
                           n241VentasTotalIVA = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e17122 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e18122 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e19122 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VIMPRIMIR.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20122 ();
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

   public void we122( )
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

   public void pa122( )
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
            GX_FocusControl = edtavFilterfulltext_Internalname ;
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
      subsflControlProps_402( ) ;
      while ( nGXsfl_40_idx <= nRC_GXsfl_40 )
      {
         sendrow_402( ) ;
         nGXsfl_40_idx = ((subGrid_Islastpage==1)&&(nGXsfl_40_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_402( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV21ManageFiltersExecutionStep ,
                                 String AV41Pgmname ,
                                 String AV15FilterFullText ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 boolean AV28IsAuthorized_Display ,
                                 boolean AV30IsAuthorized_Update ,
                                 boolean AV32IsAuthorized_Delete ,
                                 boolean AV37IsAuthorized_Insert )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e18122 ();
      GRID_nCurrentRecord = 0 ;
      rf122( ) ;
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf122( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV41Pgmname = "VentasWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_40_Refreshing);
   }

   public void rf122( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(40) ;
      /* Execute user event: Refresh */
      e18122 ();
      nGXsfl_40_idx = 1 ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_402( ) ;
      bGXsfl_40_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_402( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              AV42Ventaswwds_1_filterfulltext ,
                                              Long.valueOf(A19VentasId) ,
                                              Long.valueOf(A4ClienteId) ,
                                              Long.valueOf(A251VentasPedido) ,
                                              Long.valueOf(A29TimbradoId) ,
                                              Long.valueOf(A125TimbradoNumero) ,
                                              Short.valueOf(A309VentasSerie1) ,
                                              Short.valueOf(A310VentasSerie2) ,
                                              Long.valueOf(A311VentasNroFactura) ,
                                              Long.valueOf(A9TipoPagoId) ,
                                              A71TipoPagoNombre ,
                                              Long.valueOf(A242VentasSerial) ,
                                              A239VentasTotalExento ,
                                              A236VentasTotal5 ,
                                              A238VentasTotal10 ,
                                              A240VentasTotal ,
                                              A235VentasTotalIva5 ,
                                              A237VentasTotalIva10 ,
                                              A241VentasTotalIVA } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT,
                                              TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN,
                                              TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN
                                              }
         });
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
         /* Using cursor H00128 */
         pr_default.execute(0, new Object[] {AV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_40_idx = 1 ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_402( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A237VentasTotalIva10 = H00128_A237VentasTotalIva10[0] ;
            n237VentasTotalIva10 = H00128_n237VentasTotalIva10[0] ;
            A235VentasTotalIva5 = H00128_A235VentasTotalIva5[0] ;
            n235VentasTotalIva5 = H00128_n235VentasTotalIva5[0] ;
            A242VentasSerial = H00128_A242VentasSerial[0] ;
            A71TipoPagoNombre = H00128_A71TipoPagoNombre[0] ;
            A9TipoPagoId = H00128_A9TipoPagoId[0] ;
            A311VentasNroFactura = H00128_A311VentasNroFactura[0] ;
            A310VentasSerie2 = H00128_A310VentasSerie2[0] ;
            A309VentasSerie1 = H00128_A309VentasSerie1[0] ;
            A125TimbradoNumero = H00128_A125TimbradoNumero[0] ;
            A29TimbradoId = H00128_A29TimbradoId[0] ;
            A251VentasPedido = H00128_A251VentasPedido[0] ;
            A4ClienteId = H00128_A4ClienteId[0] ;
            A91VentasFecha = H00128_A91VentasFecha[0] ;
            A19VentasId = H00128_A19VentasId[0] ;
            A241VentasTotalIVA = H00128_A241VentasTotalIVA[0] ;
            n241VentasTotalIVA = H00128_n241VentasTotalIVA[0] ;
            A238VentasTotal10 = H00128_A238VentasTotal10[0] ;
            n238VentasTotal10 = H00128_n238VentasTotal10[0] ;
            A236VentasTotal5 = H00128_A236VentasTotal5[0] ;
            n236VentasTotal5 = H00128_n236VentasTotal5[0] ;
            A240VentasTotal = H00128_A240VentasTotal[0] ;
            n240VentasTotal = H00128_n240VentasTotal[0] ;
            A239VentasTotalExento = H00128_A239VentasTotalExento[0] ;
            n239VentasTotalExento = H00128_n239VentasTotalExento[0] ;
            A71TipoPagoNombre = H00128_A71TipoPagoNombre[0] ;
            A125TimbradoNumero = H00128_A125TimbradoNumero[0] ;
            A237VentasTotalIva10 = H00128_A237VentasTotalIva10[0] ;
            n237VentasTotalIva10 = H00128_n237VentasTotalIva10[0] ;
            A235VentasTotalIva5 = H00128_A235VentasTotalIva5[0] ;
            n235VentasTotalIva5 = H00128_n235VentasTotalIva5[0] ;
            A238VentasTotal10 = H00128_A238VentasTotal10[0] ;
            n238VentasTotal10 = H00128_n238VentasTotal10[0] ;
            A236VentasTotal5 = H00128_A236VentasTotal5[0] ;
            n236VentasTotal5 = H00128_n236VentasTotal5[0] ;
            A239VentasTotalExento = H00128_A239VentasTotalExento[0] ;
            n239VentasTotalExento = H00128_n239VentasTotalExento[0] ;
            A241VentasTotalIVA = H00128_A241VentasTotalIVA[0] ;
            n241VentasTotalIVA = H00128_n241VentasTotalIVA[0] ;
            A240VentasTotal = H00128_A240VentasTotal[0] ;
            n240VentasTotal = H00128_n240VentasTotal[0] ;
            e19122 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(40) ;
         wb120( ) ;
      }
      bGXsfl_40_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes122( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV41Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV41Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV28IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV30IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV30IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV32IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV32IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV37IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV37IsAuthorized_Insert));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           AV42Ventaswwds_1_filterfulltext ,
                                           Long.valueOf(A19VentasId) ,
                                           Long.valueOf(A4ClienteId) ,
                                           Long.valueOf(A251VentasPedido) ,
                                           Long.valueOf(A29TimbradoId) ,
                                           Long.valueOf(A125TimbradoNumero) ,
                                           Short.valueOf(A309VentasSerie1) ,
                                           Short.valueOf(A310VentasSerie2) ,
                                           Long.valueOf(A311VentasNroFactura) ,
                                           Long.valueOf(A9TipoPagoId) ,
                                           A71TipoPagoNombre ,
                                           Long.valueOf(A242VentasSerial) ,
                                           A239VentasTotalExento ,
                                           A236VentasTotal5 ,
                                           A238VentasTotal10 ,
                                           A240VentasTotal ,
                                           A235VentasTotalIva5 ,
                                           A237VentasTotalIva10 ,
                                           A241VentasTotalIVA } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN
                                           }
      });
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      lV42Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV42Ventaswwds_1_filterfulltext), "%", "") ;
      /* Using cursor H001215 */
      pr_default.execute(1, new Object[] {AV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext, lV42Ventaswwds_1_filterfulltext});
      GRID_nRecordCount = H001215_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
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
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
      GRID_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV21ManageFiltersExecutionStep, AV41Pgmname, AV15FilterFullText, AV13OrderedBy, AV14OrderedDsc, AV28IsAuthorized_Display, AV30IsAuthorized_Update, AV32IsAuthorized_Delete, AV37IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV21ManageFiltersExecutionStep, AV41Pgmname, AV15FilterFullText, AV13OrderedBy, AV14OrderedDsc, AV28IsAuthorized_Display, AV30IsAuthorized_Update, AV32IsAuthorized_Delete, AV37IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
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
         gxgrgrid_refresh( subGrid_Rows, AV21ManageFiltersExecutionStep, AV41Pgmname, AV15FilterFullText, AV13OrderedBy, AV14OrderedDsc, AV28IsAuthorized_Display, AV30IsAuthorized_Update, AV32IsAuthorized_Delete, AV37IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV21ManageFiltersExecutionStep, AV41Pgmname, AV15FilterFullText, AV13OrderedBy, AV14OrderedDsc, AV28IsAuthorized_Display, AV30IsAuthorized_Update, AV32IsAuthorized_Delete, AV37IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
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
         gxgrgrid_refresh( subGrid_Rows, AV21ManageFiltersExecutionStep, AV41Pgmname, AV15FilterFullText, AV13OrderedBy, AV14OrderedDsc, AV28IsAuthorized_Display, AV30IsAuthorized_Update, AV32IsAuthorized_Delete, AV37IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV41Pgmname = "VentasWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup120( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e17122 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV19ManageFiltersData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vAGEXPORTDATA"), AV35AGExportData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV22DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_40 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_40"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV24GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV25GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV26GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         Ddo_agexport_Icontype = httpContext.cgiGet( "DDO_AGEXPORT_Icontype") ;
         Ddo_agexport_Icon = httpContext.cgiGet( "DDO_AGEXPORT_Icon") ;
         Ddo_agexport_Caption = httpContext.cgiGet( "DDO_AGEXPORT_Caption") ;
         Ddo_agexport_Cls = httpContext.cgiGet( "DDO_AGEXPORT_Cls") ;
         Ddo_agexport_Titlecontrolidtoreplace = httpContext.cgiGet( "DDO_AGEXPORT_Titlecontrolidtoreplace") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Innewwindow1_Width = httpContext.cgiGet( "INNEWWINDOW1_Width") ;
         Innewwindow1_Height = httpContext.cgiGet( "INNEWWINDOW1_Height") ;
         Innewwindow1_Target = httpContext.cgiGet( "INNEWWINDOW1_Target") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_managefilters_Activeeventkey = httpContext.cgiGet( "DDO_MANAGEFILTERS_Activeeventkey") ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_agexport_Activeeventkey = httpContext.cgiGet( "DDO_AGEXPORT_Activeeventkey") ;
         /* Read variables values. */
         AV15FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15FilterFullText", AV15FilterFullText);
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
      e17122 ();
      if (returnInSub) return;
   }

   public void e17122( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV8HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      lblBtninsert_Caption = GXutil.format( "<i class='fas fa-plus' title='%1'></i>", httpContext.getMessage( "GXM_insert", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Caption", lblBtninsert_Caption, true);
      Ddo_agexport_Titlecontrolidtoreplace = bttBtnagexport_Internalname ;
      ucDdo_agexport.sendProperty(context, "", false, Ddo_agexport_Internalname, "TitleControlIdToReplace", Ddo_agexport_Titlecontrolidtoreplace);
      AV35AGExportData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV36AGExportDataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_ExportCaption", "") );
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-file-excel" );
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "Export" );
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV35AGExportData.add(AV36AGExportDataItem, 0);
      AV36AGExportDataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "WWP_ExportReportCaption", "") );
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-file-pdf" );
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "ExportReport" );
      AV36AGExportDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV35AGExportData.add(AV36AGExportDataItem, 0);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Ventas", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV13OrderedBy < 1 )
      {
         AV13OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV22DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new com.mujermorena.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV22DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e18122( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S152 ();
      if (returnInSub) return;
      if ( AV21ManageFiltersExecutionStep == 1 )
      {
         AV21ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ManageFiltersExecutionStep", GXutil.str( AV21ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV21ManageFiltersExecutionStep == 2 )
      {
         AV21ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ManageFiltersExecutionStep", GXutil.str( AV21ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S162 ();
      if (returnInSub) return;
      AV24GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
      AV25GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GridPageCount), 10, 0));
      GXt_char4 = AV26GridAppliedFilters ;
      GXv_char5[0] = GXt_char4 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV41Pgmname, GXv_char5) ;
      ventasww_impl.this.GXt_char4 = GXv_char5[0] ;
      AV26GridAppliedFilters = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26GridAppliedFilters", AV26GridAppliedFilters);
      AV42Ventaswwds_1_filterfulltext = AV15FilterFullText ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ManageFiltersData", AV19ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e12122( )
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
         AV23PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV23PageToGo) ;
      }
   }

   public void e13122( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e15122( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV13OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
   }

   private void e19122( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV27Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV27Display);
      if ( AV28IsAuthorized_Display )
      {
         edtavDisplay_Link = formatLink("com.mujermorena.ventasview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19VentasId,11,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"VentasId","TabCode"})  ;
      }
      AV29Update = "<i class=\"fa fa-pen\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV29Update);
      if ( AV30IsAuthorized_Update )
      {
         edtavUpdate_Link = formatLink("com.mujermorena.ventas", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(A19VentasId,11,0))}, new String[] {"Mode","VentasId"})  ;
      }
      AV31Delete = "<i class=\"fa fa-times\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV31Delete);
      if ( AV32IsAuthorized_Delete )
      {
         edtavDelete_Link = formatLink("com.mujermorena.ventas", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(A19VentasId,11,0))}, new String[] {"Mode","VentasId"})  ;
      }
      edtavImprimir_gximage = "PageLast" ;
      AV38Imprimir = context.getHttpContext().getImagePath( "eb16c005-5a7d-48a8-a16c-d7dcc1909b6e", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavImprimir_Internalname, AV38Imprimir);
      AV43Imprimir_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "eb16c005-5a7d-48a8-a16c-d7dcc1909b6e", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavImprimir_Tooltiptext = httpContext.getMessage( "Imprimir", "") ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(40) ;
      }
      sendrow_402( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_40_Refreshing )
      {
         httpContext.doAjaxLoad(40, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e11122( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S172 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S162 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("VentasWWFilters")),GXutil.URLEncode(GXutil.rtrim(AV41Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV21ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ManageFiltersExecutionStep", GXutil.str( AV21ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("VentasWWFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV21ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ManageFiltersExecutionStep", GXutil.str( AV21ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV20ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "VentasWWFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         ventasww_impl.this.GXt_char4 = GXv_char5[0] ;
         AV20ManageFiltersXml = GXt_char4 ;
         if ( (GXutil.strcmp("", AV20ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S172 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV41Pgmname+"GridState", AV20ManageFiltersXml) ;
            AV11GridState.fromxml(AV20ManageFiltersXml, null, null);
            AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
            AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
            /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
            S142 ();
            if (returnInSub) return;
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S182 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ManageFiltersData", AV19ManageFiltersData);
   }

   public void e20122( )
   {
      /* Imprimir_Click Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.mujermorena.generarfactura", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19VentasId,11,0))}, new String[] {"VentasId"}) );
      httpContext.wjLocDisableFrm = (byte)(2) ;
      /*  Sending Event outputs  */
   }

   public void e16122( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( AV37IsAuthorized_Insert )
      {
         callWebObject(formatLink("com.mujermorena.ventas", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","VentasId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19ManageFiltersData", AV19ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void e14122( )
   {
      /* Ddo_agexport_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_agexport_Activeeventkey, "Export") == 0 )
      {
         /* Execute user subroutine: 'DOEXPORT' */
         S192 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(Ddo_agexport_Activeeventkey, "ExportReport") == 0 )
      {
         /* Execute user subroutine: 'DOEXPORTREPORT' */
         S202 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV11GridState", AV11GridState);
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV13OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean6 = AV28IsAuthorized_Display ;
      GXv_boolean7[0] = GXt_boolean6 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventasview_Execute", GXv_boolean7) ;
      ventasww_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
      AV28IsAuthorized_Display = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28IsAuthorized_Display", AV28IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      if ( ! ( AV28IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_40_Refreshing);
      }
      GXt_boolean6 = AV30IsAuthorized_Update ;
      GXv_boolean7[0] = GXt_boolean6 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventas_Update", GXv_boolean7) ;
      ventasww_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
      AV30IsAuthorized_Update = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30IsAuthorized_Update", AV30IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV30IsAuthorized_Update));
      if ( ! ( AV30IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_40_Refreshing);
      }
      GXt_boolean6 = AV32IsAuthorized_Delete ;
      GXv_boolean7[0] = GXt_boolean6 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventas_Delete", GXv_boolean7) ;
      ventasww_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
      AV32IsAuthorized_Delete = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32IsAuthorized_Delete", AV32IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV32IsAuthorized_Delete));
      if ( ! ( AV32IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_40_Refreshing);
      }
      GXt_boolean6 = AV37IsAuthorized_Insert ;
      GXv_boolean7[0] = GXt_boolean6 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "ventas_Insert", GXv_boolean7) ;
      ventasww_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
      AV37IsAuthorized_Insert = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37IsAuthorized_Insert", AV37IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV37IsAuthorized_Insert));
      if ( ! ( AV37IsAuthorized_Insert ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = AV19ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "VentasWWFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[0] ;
      AV19ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
   }

   public void S172( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV15FilterFullText = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15FilterFullText", AV15FilterFullText);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV18Session.getValue(AV41Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV41Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV18Session.getValue(AV41Pgmname+"GridState"), null, null);
      }
      AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
      AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S182 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S182( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV15FilterFullText = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15FilterFullText", AV15FilterFullText);
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S162( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV18Session.getValue(AV41Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState10[0] = AV11GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "FILTERFULLTEXT", httpContext.getMessage( "WWP_FullTextFilterDescription", ""), !(GXutil.strcmp("", AV15FilterFullText)==0), (short)(0), AV15FilterFullText, "") ;
      AV11GridState = GXv_SdtWWPGridState10[0] ;
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV41Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext)new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV41Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Ventas" );
      AV18Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
   }

   public void S192( )
   {
      /* 'DOEXPORT' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      GXv_char5[0] = AV16ExcelFilename ;
      GXv_char11[0] = AV17ErrorMessage ;
      new com.mujermorena.ventaswwexport(remoteHandle, context).execute( GXv_char5, GXv_char11) ;
      ventasww_impl.this.AV16ExcelFilename = GXv_char5[0] ;
      ventasww_impl.this.AV17ErrorMessage = GXv_char11[0] ;
      if ( GXutil.strcmp(AV16ExcelFilename, "") != 0 )
      {
         callWebObject(formatLink(AV16ExcelFilename, new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(0) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV17ErrorMessage);
      }
   }

   public void S202( )
   {
      /* 'DOEXPORTREPORT' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      Innewwindow1_Target = formatLink("com.mujermorena.ventaswwexportreport", new String[] {}, new String[] {})  ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Target", Innewwindow1_Target);
      Innewwindow1_Height = "600" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Height", Innewwindow1_Height);
      Innewwindow1_Width = "800" ;
      ucInnewwindow1.sendProperty(context, "", false, Innewwindow1_Internalname, "Width", Innewwindow1_Width);
      this.executeUsercontrolMethod("", false, "INNEWWINDOW1Container", "OpenWindow", "", new Object[] {});
   }

   public void wb_table1_22_122( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV19ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_27_122( true) ;
      }
      else
      {
         wb_table2_27_122( false) ;
      }
      return  ;
   }

   public void wb_table2_27_122e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_22_122e( true) ;
      }
      else
      {
         wb_table1_22_122e( false) ;
      }
   }

   public void wb_table2_27_122( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, httpContext.getMessage( "Filter Full Text", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'" + sGXsfl_40_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV15FilterFullText, GXutil.rtrim( localUtil.format( AV15FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "WWP_Search", ""), edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_VentasWW.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_27_122e( true) ;
      }
      else
      {
         wb_table2_27_122e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa122( ) ;
      ws122( ) ;
      we122( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111163551", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("ventasww.js", "?202412111163551", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("Window/InNewWindowRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_402( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_40_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_40_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_40_idx ;
      edtavImprimir_Internalname = "vIMPRIMIR_"+sGXsfl_40_idx ;
      edtVentasId_Internalname = "VENTASID_"+sGXsfl_40_idx ;
      edtVentasFecha_Internalname = "VENTASFECHA_"+sGXsfl_40_idx ;
      edtClienteId_Internalname = "CLIENTEID_"+sGXsfl_40_idx ;
      edtVentasPedido_Internalname = "VENTASPEDIDO_"+sGXsfl_40_idx ;
      edtTimbradoId_Internalname = "TIMBRADOID_"+sGXsfl_40_idx ;
      edtTimbradoNumero_Internalname = "TIMBRADONUMERO_"+sGXsfl_40_idx ;
      edtVentasSerie1_Internalname = "VENTASSERIE1_"+sGXsfl_40_idx ;
      edtVentasSerie2_Internalname = "VENTASSERIE2_"+sGXsfl_40_idx ;
      edtVentasNroFactura_Internalname = "VENTASNROFACTURA_"+sGXsfl_40_idx ;
      edtTipoPagoId_Internalname = "TIPOPAGOID_"+sGXsfl_40_idx ;
      edtTipoPagoNombre_Internalname = "TIPOPAGONOMBRE_"+sGXsfl_40_idx ;
      edtVentasSerial_Internalname = "VENTASSERIAL_"+sGXsfl_40_idx ;
      edtVentasTotalExento_Internalname = "VENTASTOTALEXENTO_"+sGXsfl_40_idx ;
      edtVentasTotal5_Internalname = "VENTASTOTAL5_"+sGXsfl_40_idx ;
      edtVentasTotal10_Internalname = "VENTASTOTAL10_"+sGXsfl_40_idx ;
      edtVentasTotal_Internalname = "VENTASTOTAL_"+sGXsfl_40_idx ;
      edtVentasTotalIva5_Internalname = "VENTASTOTALIVA5_"+sGXsfl_40_idx ;
      edtVentasTotalIva10_Internalname = "VENTASTOTALIVA10_"+sGXsfl_40_idx ;
      edtVentasTotalIVA_Internalname = "VENTASTOTALIVA_"+sGXsfl_40_idx ;
   }

   public void subsflControlProps_fel_402( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_40_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_40_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_40_fel_idx ;
      edtavImprimir_Internalname = "vIMPRIMIR_"+sGXsfl_40_fel_idx ;
      edtVentasId_Internalname = "VENTASID_"+sGXsfl_40_fel_idx ;
      edtVentasFecha_Internalname = "VENTASFECHA_"+sGXsfl_40_fel_idx ;
      edtClienteId_Internalname = "CLIENTEID_"+sGXsfl_40_fel_idx ;
      edtVentasPedido_Internalname = "VENTASPEDIDO_"+sGXsfl_40_fel_idx ;
      edtTimbradoId_Internalname = "TIMBRADOID_"+sGXsfl_40_fel_idx ;
      edtTimbradoNumero_Internalname = "TIMBRADONUMERO_"+sGXsfl_40_fel_idx ;
      edtVentasSerie1_Internalname = "VENTASSERIE1_"+sGXsfl_40_fel_idx ;
      edtVentasSerie2_Internalname = "VENTASSERIE2_"+sGXsfl_40_fel_idx ;
      edtVentasNroFactura_Internalname = "VENTASNROFACTURA_"+sGXsfl_40_fel_idx ;
      edtTipoPagoId_Internalname = "TIPOPAGOID_"+sGXsfl_40_fel_idx ;
      edtTipoPagoNombre_Internalname = "TIPOPAGONOMBRE_"+sGXsfl_40_fel_idx ;
      edtVentasSerial_Internalname = "VENTASSERIAL_"+sGXsfl_40_fel_idx ;
      edtVentasTotalExento_Internalname = "VENTASTOTALEXENTO_"+sGXsfl_40_fel_idx ;
      edtVentasTotal5_Internalname = "VENTASTOTAL5_"+sGXsfl_40_fel_idx ;
      edtVentasTotal10_Internalname = "VENTASTOTAL10_"+sGXsfl_40_fel_idx ;
      edtVentasTotal_Internalname = "VENTASTOTAL_"+sGXsfl_40_fel_idx ;
      edtVentasTotalIva5_Internalname = "VENTASTOTALIVA5_"+sGXsfl_40_fel_idx ;
      edtVentasTotalIva10_Internalname = "VENTASTOTALIVA10_"+sGXsfl_40_fel_idx ;
      edtVentasTotalIVA_Internalname = "VENTASTOTALIVA_"+sGXsfl_40_fel_idx ;
   }

   public void sendrow_402( )
   {
      subsflControlProps_402( ) ;
      wb120( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_40_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_40_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_40_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 41,'',false,'"+sGXsfl_40_idx+"',40)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV27Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,41);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'',false,'"+sGXsfl_40_idx+"',40)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV29Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,42);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 43,'',false,'"+sGXsfl_40_idx+"',40)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV31Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,43);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavImprimir_Enabled!=0)&&(edtavImprimir_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 44,'',false,'',40)\"" : " ") ;
         ClassString = "ActionBaseColorAttribute" + " " + ((GXutil.strcmp(edtavImprimir_gximage, "")==0) ? "" : "GX_Image_"+edtavImprimir_gximage+"_Class") ;
         StyleString = "" ;
         AV38Imprimir_IsBlob = (boolean)(((GXutil.strcmp("", AV38Imprimir)==0)&&(GXutil.strcmp("", AV43Imprimir_GXI)==0))||!(GXutil.strcmp("", AV38Imprimir)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV38Imprimir)==0) ? AV43Imprimir_GXI : httpContext.getResourceRelative(AV38Imprimir)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImprimir_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"",edtavImprimir_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavImprimir_Jsonclick,"'"+""+"'"+",false,"+"'"+"EVIMPRIMIR.CLICK."+sGXsfl_40_idx+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV38Imprimir_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasId_Internalname,GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasFecha_Internalname,localUtil.format(A91VentasFecha, "99/99/99"),localUtil.format( A91VentasFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasFecha_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClienteId_Internalname,GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClienteId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasPedido_Internalname,GXutil.ltrim( localUtil.ntoc( A251VentasPedido, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A251VentasPedido), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasPedido_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTimbradoId_Internalname,GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTimbradoId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTimbradoNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A125TimbradoNumero), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTimbradoNumero_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Numero","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasSerie1_Internalname,GXutil.ltrim( localUtil.ntoc( A309VentasSerie1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A309VentasSerie1), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasSerie1_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"SerieFac","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasSerie2_Internalname,GXutil.ltrim( localUtil.ntoc( A310VentasSerie2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A310VentasSerie2), "ZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasSerie2_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(3),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"SerieFac","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasNroFactura_Internalname,GXutil.ltrim( localUtil.ntoc( A311VentasNroFactura, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A311VentasNroFactura), "ZZZZZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasNroFactura_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Factura","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipoPagoId_Internalname,GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipoPagoId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipoPagoNombre_Internalname,GXutil.rtrim( A71TipoPagoNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipoPagoNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasSerial_Internalname,GXutil.ltrim( localUtil.ntoc( A242VentasSerial, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A242VentasSerial), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasSerial_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Serial","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotalExento_Internalname,GXutil.ltrim( localUtil.ntoc( A239VentasTotalExento, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A239VentasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotalExento_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotal5_Internalname,GXutil.ltrim( localUtil.ntoc( A236VentasTotal5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A236VentasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotal5_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotal10_Internalname,GXutil.ltrim( localUtil.ntoc( A238VentasTotal10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A238VentasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotal10_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A240VentasTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A240VentasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotalIva5_Internalname,GXutil.ltrim( localUtil.ntoc( A235VentasTotalIva5, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A235VentasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotalIva5_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotalIva10_Internalname,GXutil.ltrim( localUtil.ntoc( A237VentasTotalIva10, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A237VentasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotalIva10_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtVentasTotalIVA_Internalname,GXutil.ltrim( localUtil.ntoc( A241VentasTotalIVA, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A241VentasTotalIVA, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtVentasTotalIVA_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes122( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_40_idx = ((subGrid_Islastpage==1)&&(nGXsfl_40_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_402( ) ;
      }
      /* End function sendrow_402 */
   }

   public void startgridcontrol40( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"40\">") ;
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
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ActionBaseColorAttribute"+" "+((GXutil.strcmp(edtavImprimir_gximage, "")==0) ? "" : "GX_Image_"+edtavImprimir_gximage+"_Class")+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Pedido", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Timbrado Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Timbrado Numero", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Serie1", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Serie2", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Nro Factura", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo Pago Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo Pago Nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Serial", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total Exento", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total5", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total10", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total Iva5", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total Iva10", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total IVA", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV27Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV29Update));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV31Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV38Imprimir));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavImprimir_Tooltiptext));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A91VentasFecha, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A251VentasPedido, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A125TimbradoNumero, (byte)(10), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A309VentasSerie1, (byte)(3), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A310VentasSerie2, (byte)(3), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A311VentasNroFactura, (byte)(15), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A71TipoPagoNombre));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A242VentasSerial, (byte)(10), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A239VentasTotalExento, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A236VentasTotal5, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A238VentasTotal10, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A240VentasTotal, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A235VentasTotalIva5, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A237VentasTotalIva10, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A241VentasTotalIVA, (byte)(21), (byte)(2), ".", "")));
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
      lblBtninsert_Internalname = "BTNINSERT" ;
      bttBtnagexport_Internalname = "BTNAGEXPORT" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavImprimir_Internalname = "vIMPRIMIR" ;
      edtVentasId_Internalname = "VENTASID" ;
      edtVentasFecha_Internalname = "VENTASFECHA" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtVentasPedido_Internalname = "VENTASPEDIDO" ;
      edtTimbradoId_Internalname = "TIMBRADOID" ;
      edtTimbradoNumero_Internalname = "TIMBRADONUMERO" ;
      edtVentasSerie1_Internalname = "VENTASSERIE1" ;
      edtVentasSerie2_Internalname = "VENTASSERIE2" ;
      edtVentasNroFactura_Internalname = "VENTASNROFACTURA" ;
      edtTipoPagoId_Internalname = "TIPOPAGOID" ;
      edtTipoPagoNombre_Internalname = "TIPOPAGONOMBRE" ;
      edtVentasSerial_Internalname = "VENTASSERIAL" ;
      edtVentasTotalExento_Internalname = "VENTASTOTALEXENTO" ;
      edtVentasTotal5_Internalname = "VENTASTOTAL5" ;
      edtVentasTotal10_Internalname = "VENTASTOTAL10" ;
      edtVentasTotal_Internalname = "VENTASTOTAL" ;
      edtVentasTotalIva5_Internalname = "VENTASTOTALIVA5" ;
      edtVentasTotalIva10_Internalname = "VENTASTOTALIVA10" ;
      edtVentasTotalIVA_Internalname = "VENTASTOTALIVA" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_agexport_Internalname = "DDO_AGEXPORT" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Innewwindow1_Internalname = "INNEWWINDOW1" ;
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
      edtVentasTotalIVA_Jsonclick = "" ;
      edtVentasTotalIva10_Jsonclick = "" ;
      edtVentasTotalIva5_Jsonclick = "" ;
      edtVentasTotal_Jsonclick = "" ;
      edtVentasTotal10_Jsonclick = "" ;
      edtVentasTotal5_Jsonclick = "" ;
      edtVentasTotalExento_Jsonclick = "" ;
      edtVentasSerial_Jsonclick = "" ;
      edtTipoPagoNombre_Jsonclick = "" ;
      edtTipoPagoId_Jsonclick = "" ;
      edtVentasNroFactura_Jsonclick = "" ;
      edtVentasSerie2_Jsonclick = "" ;
      edtVentasSerie1_Jsonclick = "" ;
      edtTimbradoNumero_Jsonclick = "" ;
      edtTimbradoId_Jsonclick = "" ;
      edtVentasPedido_Jsonclick = "" ;
      edtClienteId_Jsonclick = "" ;
      edtVentasFecha_Jsonclick = "" ;
      edtVentasId_Jsonclick = "" ;
      edtavImprimir_Jsonclick = "" ;
      edtavImprimir_gximage = "" ;
      edtavImprimir_Visible = -1 ;
      edtavImprimir_Enabled = 1 ;
      edtavImprimir_Tooltiptext = httpContext.getMessage( "Imprimir", "") ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 1 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Link = "" ;
      edtavDisplay_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
      subGrid_Sortable = (byte)(0) ;
      lblBtninsert_Caption = httpContext.getMessage( "<i class='fas fa-plus' title='Agregar'></i>", "") ;
      lblBtninsert_Visible = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Innewwindow1_Target = "" ;
      Innewwindow1_Height = "50" ;
      Innewwindow1_Width = "50" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "1|2|3|4|5|6|7|8|9|10|11|12" ;
      Ddo_grid_Columnids = "4:VentasId|5:VentasFecha|6:ClienteId|7:VentasPedido|8:TimbradoId|9:TimbradoNumero|10:VentasSerie1|11:VentasSerie2|12:VentasNroFactura|13:TipoPagoId|14:TipoPagoNombre|15:VentasSerial" ;
      Ddo_grid_Gridinternalname = "" ;
      Ddo_agexport_Titlecontrolidtoreplace = "" ;
      Ddo_agexport_Cls = "ColumnsSelector" ;
      Ddo_agexport_Icon = "fas fa-download" ;
      Ddo_agexport_Icontype = "FontIcon" ;
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
      Form.setCaption( httpContext.getMessage( " Ventas", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV25GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV26GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12122',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13122',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e15122',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e19122',iparms:[{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV27Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV29Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV31Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV38Imprimir',fld:'vIMPRIMIR',pic:''},{av:'edtavImprimir_Tooltiptext',ctrl:'vIMPRIMIR',prop:'Tooltiptext'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11122',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV25GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV26GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("VIMPRIMIR.CLICK","{handler:'e20122',iparms:[{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VIMPRIMIR.CLICK",",oparms:[{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("'DOINSERT'","{handler:'e16122',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV25GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV26GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV19ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("DDO_AGEXPORT.ONOPTIONCLICKED","{handler:'e14122',iparms:[{av:'Ddo_agexport_Activeeventkey',ctrl:'DDO_AGEXPORT',prop:'ActiveEventKey'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_AGEXPORT.ONOPTIONCLICKED",",oparms:[{av:'Innewwindow1_Target',ctrl:'INNEWWINDOW1',prop:'Target'},{av:'Innewwindow1_Height',ctrl:'INNEWWINDOW1',prop:'Height'},{av:'Innewwindow1_Width',ctrl:'INNEWWINDOW1',prop:'Width'},{av:'AV11GridState',fld:'vGRIDSTATE',pic:''},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV21ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV41Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV30IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV32IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV37IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("VALID_VENTASID","{handler:'valid_Ventasid',iparms:[]");
      setEventMetadata("VALID_VENTASID",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOID","{handler:'valid_Timbradoid',iparms:[]");
      setEventMetadata("VALID_TIMBRADOID",",oparms:[]}");
      setEventMetadata("VALID_TIPOPAGOID","{handler:'valid_Tipopagoid',iparms:[]");
      setEventMetadata("VALID_TIPOPAGOID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Ventastotaliva',iparms:[]");
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
      return "ventasww_Execute";
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
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_managefilters_Activeeventkey = "" ;
      Ddo_agexport_Activeeventkey = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV41Pgmname = "" ;
      AV15FilterFullText = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV19ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV26GridAppliedFilters = "" ;
      AV35AGExportData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV22DDO_TitleSettingsIcons = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV11GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Ddo_agexport_Caption = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      lblBtninsert_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnagexport_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_agexport = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucInnewwindow1 = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV27Display = "" ;
      AV29Update = "" ;
      AV31Delete = "" ;
      AV38Imprimir = "" ;
      AV43Imprimir_GXI = "" ;
      A91VentasFecha = GXutil.nullDate() ;
      A71TipoPagoNombre = "" ;
      A239VentasTotalExento = DecimalUtil.ZERO ;
      A236VentasTotal5 = DecimalUtil.ZERO ;
      A238VentasTotal10 = DecimalUtil.ZERO ;
      A240VentasTotal = DecimalUtil.ZERO ;
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      A241VentasTotalIVA = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV42Ventaswwds_1_filterfulltext = "" ;
      AV42Ventaswwds_1_filterfulltext = "" ;
      H00128_A237VentasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n237VentasTotalIva10 = new boolean[] {false} ;
      H00128_A235VentasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n235VentasTotalIva5 = new boolean[] {false} ;
      H00128_A242VentasSerial = new long[1] ;
      H00128_A71TipoPagoNombre = new String[] {""} ;
      H00128_A9TipoPagoId = new long[1] ;
      H00128_A311VentasNroFactura = new long[1] ;
      H00128_A310VentasSerie2 = new short[1] ;
      H00128_A309VentasSerie1 = new short[1] ;
      H00128_A125TimbradoNumero = new long[1] ;
      H00128_A29TimbradoId = new long[1] ;
      H00128_A251VentasPedido = new long[1] ;
      H00128_A4ClienteId = new long[1] ;
      H00128_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00128_A19VentasId = new long[1] ;
      H00128_A241VentasTotalIVA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n241VentasTotalIVA = new boolean[] {false} ;
      H00128_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n238VentasTotal10 = new boolean[] {false} ;
      H00128_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n236VentasTotal5 = new boolean[] {false} ;
      H00128_A240VentasTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n240VentasTotal = new boolean[] {false} ;
      H00128_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00128_n239VentasTotalExento = new boolean[] {false} ;
      H001215_AGRID_nRecordCount = new long[1] ;
      AV8HTTPRequest = httpContext.getHttpRequest();
      AV36AGExportDataItem = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV20ManageFiltersXml = "" ;
      GXt_char4 = "" ;
      GXv_boolean7 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9 = new GXBaseCollection[1] ;
      AV18Session = httpContext.getWebSession();
      AV12GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState10 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      AV9TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16ExcelFilename = "" ;
      GXv_char5 = new String[1] ;
      AV17ErrorMessage = "" ;
      GXv_char11 = new String[1] ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ventasww__default(),
         new Object[] {
             new Object[] {
            H00128_A237VentasTotalIva10, H00128_n237VentasTotalIva10, H00128_A235VentasTotalIva5, H00128_n235VentasTotalIva5, H00128_A242VentasSerial, H00128_A71TipoPagoNombre, H00128_A9TipoPagoId, H00128_A311VentasNroFactura, H00128_A310VentasSerie2, H00128_A309VentasSerie1,
            H00128_A125TimbradoNumero, H00128_A29TimbradoId, H00128_A251VentasPedido, H00128_A4ClienteId, H00128_A91VentasFecha, H00128_A19VentasId, H00128_A241VentasTotalIVA, H00128_n241VentasTotalIVA, H00128_A238VentasTotal10, H00128_n238VentasTotal10,
            H00128_A236VentasTotal5, H00128_n236VentasTotal5, H00128_A240VentasTotal, H00128_n240VentasTotal, H00128_A239VentasTotalExento
            }
            , new Object[] {
            H001215_AGRID_nRecordCount
            }
         }
      );
      AV41Pgmname = "VentasWW" ;
      /* GeneXus formulas. */
      AV41Pgmname = "VentasWW" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV21ManageFiltersExecutionStep ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short AV13OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short A309VentasSerie1 ;
   private short A310VentasSerie2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_40 ;
   private int nGXsfl_40_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int lblBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV23PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int AV44GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavImprimir_Enabled ;
   private int edtavImprimir_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV24GridCurrentPage ;
   private long AV25GridPageCount ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A251VentasPedido ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A311VentasNroFactura ;
   private long A9TipoPagoId ;
   private long A242VentasSerial ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal A239VentasTotalExento ;
   private java.math.BigDecimal A236VentasTotal5 ;
   private java.math.BigDecimal A238VentasTotal10 ;
   private java.math.BigDecimal A240VentasTotal ;
   private java.math.BigDecimal A235VentasTotalIva5 ;
   private java.math.BigDecimal A237VentasTotalIva10 ;
   private java.math.BigDecimal A241VentasTotalIVA ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_managefilters_Activeeventkey ;
   private String Ddo_agexport_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_40_idx="0001" ;
   private String AV41Pgmname ;
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
   private String Ddo_agexport_Icontype ;
   private String Ddo_agexport_Icon ;
   private String Ddo_agexport_Caption ;
   private String Ddo_agexport_Cls ;
   private String Ddo_agexport_Titlecontrolidtoreplace ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Innewwindow1_Width ;
   private String Innewwindow1_Height ;
   private String Innewwindow1_Target ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String lblBtninsert_Internalname ;
   private String lblBtninsert_Caption ;
   private String lblBtninsert_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnagexport_Internalname ;
   private String bttBtnagexport_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_agexport_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Innewwindow1_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV27Display ;
   private String edtavDisplay_Internalname ;
   private String AV29Update ;
   private String edtavUpdate_Internalname ;
   private String AV31Delete ;
   private String edtavDelete_Internalname ;
   private String edtavImprimir_Internalname ;
   private String edtVentasId_Internalname ;
   private String edtVentasFecha_Internalname ;
   private String edtClienteId_Internalname ;
   private String edtVentasPedido_Internalname ;
   private String edtTimbradoId_Internalname ;
   private String edtTimbradoNumero_Internalname ;
   private String edtVentasSerie1_Internalname ;
   private String edtVentasSerie2_Internalname ;
   private String edtVentasNroFactura_Internalname ;
   private String edtTipoPagoId_Internalname ;
   private String A71TipoPagoNombre ;
   private String edtTipoPagoNombre_Internalname ;
   private String edtVentasSerial_Internalname ;
   private String edtVentasTotalExento_Internalname ;
   private String edtVentasTotal5_Internalname ;
   private String edtVentasTotal10_Internalname ;
   private String edtVentasTotal_Internalname ;
   private String edtVentasTotalIva5_Internalname ;
   private String edtVentasTotalIva10_Internalname ;
   private String edtVentasTotalIVA_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavImprimir_gximage ;
   private String edtavImprimir_Tooltiptext ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String GXv_char11[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_40_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String sImgUrl ;
   private String edtavImprimir_Jsonclick ;
   private String edtVentasId_Jsonclick ;
   private String edtVentasFecha_Jsonclick ;
   private String edtClienteId_Jsonclick ;
   private String edtVentasPedido_Jsonclick ;
   private String edtTimbradoId_Jsonclick ;
   private String edtTimbradoNumero_Jsonclick ;
   private String edtVentasSerie1_Jsonclick ;
   private String edtVentasSerie2_Jsonclick ;
   private String edtVentasNroFactura_Jsonclick ;
   private String edtTipoPagoId_Jsonclick ;
   private String edtTipoPagoNombre_Jsonclick ;
   private String edtVentasSerial_Jsonclick ;
   private String edtVentasTotalExento_Jsonclick ;
   private String edtVentasTotal5_Jsonclick ;
   private String edtVentasTotal10_Jsonclick ;
   private String edtVentasTotal_Jsonclick ;
   private String edtVentasTotalIva5_Jsonclick ;
   private String edtVentasTotalIva10_Jsonclick ;
   private String edtVentasTotalIVA_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A91VentasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean AV28IsAuthorized_Display ;
   private boolean AV30IsAuthorized_Update ;
   private boolean AV32IsAuthorized_Delete ;
   private boolean AV37IsAuthorized_Insert ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_40_Refreshing=false ;
   private boolean n239VentasTotalExento ;
   private boolean n236VentasTotal5 ;
   private boolean n238VentasTotal10 ;
   private boolean n240VentasTotal ;
   private boolean n235VentasTotalIva5 ;
   private boolean n237VentasTotalIva10 ;
   private boolean n241VentasTotalIVA ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean AV38Imprimir_IsBlob ;
   private String AV20ManageFiltersXml ;
   private String AV15FilterFullText ;
   private String AV26GridAppliedFilters ;
   private String AV43Imprimir_GXI ;
   private String lV42Ventaswwds_1_filterfulltext ;
   private String AV42Ventaswwds_1_filterfulltext ;
   private String AV16ExcelFilename ;
   private String AV17ErrorMessage ;
   private String AV38Imprimir ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV18Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_agexport ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucInnewwindow1 ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] H00128_A237VentasTotalIva10 ;
   private boolean[] H00128_n237VentasTotalIva10 ;
   private java.math.BigDecimal[] H00128_A235VentasTotalIva5 ;
   private boolean[] H00128_n235VentasTotalIva5 ;
   private long[] H00128_A242VentasSerial ;
   private String[] H00128_A71TipoPagoNombre ;
   private long[] H00128_A9TipoPagoId ;
   private long[] H00128_A311VentasNroFactura ;
   private short[] H00128_A310VentasSerie2 ;
   private short[] H00128_A309VentasSerie1 ;
   private long[] H00128_A125TimbradoNumero ;
   private long[] H00128_A29TimbradoId ;
   private long[] H00128_A251VentasPedido ;
   private long[] H00128_A4ClienteId ;
   private java.util.Date[] H00128_A91VentasFecha ;
   private long[] H00128_A19VentasId ;
   private java.math.BigDecimal[] H00128_A241VentasTotalIVA ;
   private boolean[] H00128_n241VentasTotalIVA ;
   private java.math.BigDecimal[] H00128_A238VentasTotal10 ;
   private boolean[] H00128_n238VentasTotal10 ;
   private java.math.BigDecimal[] H00128_A236VentasTotal5 ;
   private boolean[] H00128_n236VentasTotal5 ;
   private java.math.BigDecimal[] H00128_A240VentasTotal ;
   private boolean[] H00128_n240VentasTotal ;
   private java.math.BigDecimal[] H00128_A239VentasTotalExento ;
   private boolean[] H00128_n239VentasTotalExento ;
   private long[] H001215_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV19ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV35AGExportData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item8 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState10[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV36AGExportDataItem ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV22DDO_TitleSettingsIcons ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class ventasww__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00128( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          String AV42Ventaswwds_1_filterfulltext ,
                                          long A19VentasId ,
                                          long A4ClienteId ,
                                          long A251VentasPedido ,
                                          long A29TimbradoId ,
                                          long A125TimbradoNumero ,
                                          short A309VentasSerie1 ,
                                          short A310VentasSerie2 ,
                                          long A311VentasNroFactura ,
                                          long A9TipoPagoId ,
                                          String A71TipoPagoNombre ,
                                          long A242VentasSerial ,
                                          java.math.BigDecimal A239VentasTotalExento ,
                                          java.math.BigDecimal A236VentasTotal5 ,
                                          java.math.BigDecimal A238VentasTotal10 ,
                                          java.math.BigDecimal A240VentasTotal ,
                                          java.math.BigDecimal A235VentasTotalIva5 ,
                                          java.math.BigDecimal A237VentasTotalIva10 ,
                                          java.math.BigDecimal A241VentasTotalIVA )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[22];
      Object[] GXv_Object13 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIva10, ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27, 10)) /" ;
      sSelectString += " 21, 0) AS VentasTotalIva5, T1.[VentasSerial], T2.[TipoPagoNombre], T1.[TipoPagoId], T1.[VentasNroFactura], T1.[VentasSerie2], T1.[VentasSerie1], T3.[TimbradoNumero]," ;
      sSelectString += " T1.[TimbradoId], T1.[VentasPedido], T1.[ClienteId], T1.[VentasFecha], T1.[VentasId], COALESCE( T6.[VentasTotalIVA], 0) AS VentasTotalIVA, COALESCE( T5.[VentasTotal10]," ;
      sSelectString += " 0) AS VentasTotal10, COALESCE( T5.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T6.[VentasTotal], 0) AS VentasTotal, COALESCE( T5.[VentasTotalExento], 0) AS VentasTotalExento" ;
      sFromString = " FROM ((((([Ventas] T1 INNER JOIN [TipoPago] T2 ON T2.[TipoPagoId] = T1.[TipoPagoId]) INNER JOIN [Timbrado] T3 ON T3.[TimbradoId] = T1.[TimbradoId]) LEFT JOIN (SELECT" ;
      sFromString += " SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T7.[VentasId]" ;
      sFromString += " FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId] = T8.[ImpuestoId]) GROUP BY" ;
      sFromString += " T7.[VentasId] ) T4 ON T4.[VentasId] = T1.[VentasId]) LEFT JOIN (SELECT T7.[VentasId], SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad]" ;
      sFromString += " * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 5 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta]" ;
      sFromString += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 0 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal(" ;
      sFromString += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId]" ;
      sFromString += " = T8.[ImpuestoId]) GROUP BY T7.[VentasId] ) T5 ON T5.[VentasId] = T1.[VentasId]) INNER JOIN (SELECT COALESCE( T8.[VentasTotalExento], 0) + COALESCE( COALESCE( T9.[VentasTotal5]," ;
      sFromString += " 0), 0) + COALESCE( COALESCE( T10.[VentasTotal10], 0), 0) AS VentasTotal, T7.[VentasId], ROUND(CAST(( ( COALESCE( T9.[VentasTotal5], 0))) AS decimal( 27, 10)) /" ;
      sFromString += " 21, 0) + ROUND(CAST(( ( COALESCE( T10.[VentasTotal10], 0))) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIVA FROM ((([Ventas] T7 LEFT JOIN (SELECT SUM(CASE  WHEN" ;
      sFromString += " T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T11.[VentasId] FROM" ;
      sFromString += " (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP" ;
      sFromString += " BY T11.[VentasId] ) T8 ON T8.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT T11.[VentasId], SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      sFromString += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 5 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta]" ;
      sFromString += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal(" ;
      sFromString += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId]" ;
      sFromString += " = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T9 ON T9.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      sFromString += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T11.[VentasId] FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId]" ;
      sFromString += " = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T10 ON T10.[VentasId] = T7.[VentasId]) ) T6 ON T6.[VentasId]" ;
      sFromString += " = T1.[VentasId])" ;
      sOrderString = "" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(11), CAST(T1.[VentasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[VentasPedido] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TimbradoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T3.[TimbradoNumero] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie1] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie2] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(15), CAST(T1.[VentasNroFactura] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoPagoId] AS decimal(11,0))) like '%' + ?) or ( T2.[TipoPagoNombre] like '%' + ?) or ( CONVERT( char(10), CAST(T1.[VentasSerial] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotalExento], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal10], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotal], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27, 10)) / 21, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotalIVA], 0) AS decimal(17,2))) like '%' + ?)))");
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasId]" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasFecha]" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasFecha] DESC" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[ClienteId]" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[ClienteId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasPedido]" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasPedido] DESC" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[TimbradoId]" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[TimbradoId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[TimbradoNumero]" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[TimbradoNumero] DESC" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasSerie1]" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasSerie1] DESC" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasSerie2]" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasSerie2] DESC" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasNroFactura]" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasNroFactura] DESC" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[TipoPagoId]" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[TipoPagoId] DESC" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[TipoPagoNombre]" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[TipoPagoNombre] DESC" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[VentasSerial]" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[VentasSerial] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[VentasId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_H001215( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           short AV13OrderedBy ,
                                           boolean AV14OrderedDsc ,
                                           String AV42Ventaswwds_1_filterfulltext ,
                                           long A19VentasId ,
                                           long A4ClienteId ,
                                           long A251VentasPedido ,
                                           long A29TimbradoId ,
                                           long A125TimbradoNumero ,
                                           short A309VentasSerie1 ,
                                           short A310VentasSerie2 ,
                                           long A311VentasNroFactura ,
                                           long A9TipoPagoId ,
                                           String A71TipoPagoNombre ,
                                           long A242VentasSerial ,
                                           java.math.BigDecimal A239VentasTotalExento ,
                                           java.math.BigDecimal A236VentasTotal5 ,
                                           java.math.BigDecimal A238VentasTotal10 ,
                                           java.math.BigDecimal A240VentasTotal ,
                                           java.math.BigDecimal A235VentasTotalIva5 ,
                                           java.math.BigDecimal A237VentasTotalIva10 ,
                                           java.math.BigDecimal A241VentasTotalIVA )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[19];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((((([Ventas] T1 INNER JOIN [TipoPago] T2 ON T2.[TipoPagoId] = T1.[TipoPagoId]) INNER JOIN [Timbrado] T3 ON T3.[TimbradoId] = T1.[TimbradoId])" ;
      scmdbuf += " LEFT JOIN (SELECT SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10," ;
      scmdbuf += " T7.[VentasId] FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId] = T8.[ImpuestoId])" ;
      scmdbuf += " GROUP BY T7.[VentasId] ) T4 ON T4.[VentasId] = T1.[VentasId]) LEFT JOIN (SELECT T7.[VentasId], SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 5 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 0 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal(" ;
      scmdbuf += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId]" ;
      scmdbuf += " = T8.[ImpuestoId]) GROUP BY T7.[VentasId] ) T5 ON T5.[VentasId] = T1.[VentasId]) INNER JOIN (SELECT COALESCE( T8.[VentasTotalExento], 0) + COALESCE( COALESCE( T9.[VentasTotal5]," ;
      scmdbuf += " 0), 0) + COALESCE( COALESCE( T10.[VentasTotal10], 0), 0) AS VentasTotal, T7.[VentasId], ROUND(CAST(( ( COALESCE( T9.[VentasTotal5], 0))) AS decimal( 27, 10)) /" ;
      scmdbuf += " 21, 0) + ROUND(CAST(( ( COALESCE( T10.[VentasTotal10], 0))) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIVA FROM ((([Ventas] T7 LEFT JOIN (SELECT SUM(CASE  WHEN" ;
      scmdbuf += " T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T11.[VentasId] FROM" ;
      scmdbuf += " (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP" ;
      scmdbuf += " BY T11.[VentasId] ) T8 ON T8.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT T11.[VentasId], SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 5 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal(" ;
      scmdbuf += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId]" ;
      scmdbuf += " = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T9 ON T9.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T11.[VentasId] FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId]" ;
      scmdbuf += " = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T10 ON T10.[VentasId] = T7.[VentasId]) ) T6 ON T6.[VentasId]" ;
      scmdbuf += " = T1.[VentasId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(11), CAST(T1.[VentasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[VentasPedido] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TimbradoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T3.[TimbradoNumero] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie1] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie2] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(15), CAST(T1.[VentasNroFactura] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoPagoId] AS decimal(11,0))) like '%' + ?) or ( T2.[TipoPagoNombre] like '%' + ?) or ( CONVERT( char(10), CAST(T1.[VentasSerial] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotalExento], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal10], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotal], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27, 10)) / 21, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotalIVA], 0) AS decimal(17,2))) like '%' + ?)))");
      scmdbuf += sWhereString ;
      if ( ( AV13OrderedBy == 1 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 1 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 6 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 7 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 8 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 9 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 10 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 11 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 12 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H00128(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).longValue() , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).longValue() , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] );
            case 1 :
                  return conditional_H001215(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).longValue() , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).longValue() , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00128", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001215", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(3);
               ((String[]) buf[5])[0] = rslt.getString(4, 80);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((long[]) buf[7])[0] = rslt.getLong(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((short[]) buf[9])[0] = rslt.getShort(8);
               ((long[]) buf[10])[0] = rslt.getLong(9);
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((long[]) buf[13])[0] = rslt.getLong(12);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(13);
               ((long[]) buf[15])[0] = rslt.getLong(14);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(15,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(16,2);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(17,2);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(18,2);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(19,2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[41]).intValue());
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[42]).intValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[43]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               return;
      }
   }

}

