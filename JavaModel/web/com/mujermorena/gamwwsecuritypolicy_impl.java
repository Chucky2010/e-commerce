package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwwsecuritypolicy_impl extends GXDataArea
{
   public gamwwsecuritypolicy_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwwsecuritypolicy_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwwsecuritypolicy_impl.class ));
   }

   public gamwwsecuritypolicy_impl( int remoteHandle ,
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
      nRC_GXsfl_39 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_39"))) ;
      nGXsfl_39_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_39_idx"))) ;
      sGXsfl_39_idx = httpContext.GetPar( "sGXsfl_39_idx") ;
      edtavBtnsaveas_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsaveas_Internalname, "Title", edtavBtnsaveas_Title, !bGXsfl_39_Refreshing);
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
      AV37ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV54Pgmname = httpContext.GetPar( "Pgmname") ;
      AV11FilName = httpContext.GetPar( "FilName") ;
      edtavBtnsaveas_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsaveas_Internalname, "Title", edtavBtnsaveas_Title, !bGXsfl_39_Refreshing);
      AV48IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV49IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV50IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV17IsAuthorized_Name = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Name")) ;
      AV51IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV37ManageFiltersExecutionStep, AV54Pgmname, AV11FilName, AV48IsAuthorized_Display, AV49IsAuthorized_Update, AV50IsAuthorized_Delete, AV17IsAuthorized_Name, AV51IsAuthorized_Insert) ;
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
      pa1J2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1J2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwwsecuritypolicy", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV48IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV17IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV51IsAuthorized_Insert));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_39", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_39, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV41ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV41ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV43GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV13GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV45GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV37ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV54Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV48IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV48IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV49IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV50IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV17IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV17IsAuthorized_Name));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV34GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV34GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV51IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV51IsAuthorized_Insert));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vBTNSAVEAS_Title", GXutil.rtrim( edtavBtnsaveas_Title));
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
         we1J2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1J2( ) ;
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
      return formatLink("com.mujermorena.gamwwsecuritypolicy", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "GAMWWSecurityPolicy" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_SecurityPolicies", "") ;
   }

   public void wb1J0( )
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWWSecurityPolicy.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_GAMWWSecurityPolicy.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6 CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_20_1J2( true) ;
      }
      else
      {
         wb_table1_20_1J2( false) ;
      }
      return  ;
   }

   public void wb_table1_20_1J2e( boolean wbgen )
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
         startgridcontrol39( ) ;
      }
      if ( wbEnd == 39 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_39 = (int)(nGXsfl_39_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV43GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV13GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV45GridAppliedFilters);
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
      if ( wbEnd == 39 )
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

   public void start1J2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_SecurityPolicies", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1J0( ) ;
   }

   public void ws1J2( )
   {
      start1J2( ) ;
      evt1J2( ) ;
   }

   public void evt1J2( )
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
                           e111J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131J2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e141J2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "VBTNSAVEAS.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "VBTNSAVEAS.CLICK") == 0 ) )
                        {
                           nGXsfl_39_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_392( ) ;
                           AV46Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV46Display);
                           AV47Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV47Update);
                           AV5Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
                           AV25BtnSaveAs = httpContext.cgiGet( edtavBtnsaveas_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtnsaveas_Internalname, AV25BtnSaveAs);
                           AV18Name = httpContext.cgiGet( edtavName_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV18Name);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vID");
                              GX_FocusControl = edtavId_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV14Id = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Id), 12, 0));
                              com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_39_idx, getSecureSignedToken( sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
                           }
                           else
                           {
                              AV14Id = localUtil.ctol( httpContext.cgiGet( edtavId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Id), 12, 0));
                              com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_39_idx, getSecureSignedToken( sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e151J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e161J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e171J2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VBTNSAVEAS.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e181J2 ();
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

   public void we1J2( )
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

   public void pa1J2( )
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
      subsflControlProps_392( ) ;
      while ( nGXsfl_39_idx <= nRC_GXsfl_39 )
      {
         sendrow_392( ) ;
         nGXsfl_39_idx = ((subGrid_Islastpage==1)&&(nGXsfl_39_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_39_idx+1) ;
         sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_392( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV37ManageFiltersExecutionStep ,
                                 String AV54Pgmname ,
                                 String AV11FilName ,
                                 boolean AV48IsAuthorized_Display ,
                                 boolean AV49IsAuthorized_Update ,
                                 boolean AV50IsAuthorized_Delete ,
                                 boolean AV17IsAuthorized_Name ,
                                 boolean AV51IsAuthorized_Insert )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e161J2 ();
      GRID_nCurrentRecord = 0 ;
      rf1J2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV14Id, (byte)(12), (byte)(0), ".", "")));
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
      rf1J2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV54Pgmname = "GAMWWSecurityPolicy" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavBtnsaveas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsaveas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnsaveas_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_39_Refreshing);
   }

   public void rf1J2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(39) ;
      /* Execute user event: Refresh */
      e161J2 ();
      nGXsfl_39_idx = 1 ;
      sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_392( ) ;
      bGXsfl_39_Refreshing = true ;
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
         subsflControlProps_392( ) ;
         e171J2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_39_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e171J2 ();
         }
         wbEnd = (short)(39) ;
         wb1J0( ) ;
      }
      bGXsfl_39_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1J2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV54Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV54Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV48IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV48IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV49IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV50IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV17IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV17IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV51IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV51IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_39_idx, getSecureSignedToken( sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
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
         gxgrgrid_refresh( subGrid_Rows, AV37ManageFiltersExecutionStep, AV54Pgmname, AV11FilName, AV48IsAuthorized_Display, AV49IsAuthorized_Update, AV50IsAuthorized_Delete, AV17IsAuthorized_Name, AV51IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV37ManageFiltersExecutionStep, AV54Pgmname, AV11FilName, AV48IsAuthorized_Display, AV49IsAuthorized_Update, AV50IsAuthorized_Delete, AV17IsAuthorized_Name, AV51IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV37ManageFiltersExecutionStep, AV54Pgmname, AV11FilName, AV48IsAuthorized_Display, AV49IsAuthorized_Update, AV50IsAuthorized_Delete, AV17IsAuthorized_Name, AV51IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV37ManageFiltersExecutionStep, AV54Pgmname, AV11FilName, AV48IsAuthorized_Display, AV49IsAuthorized_Update, AV50IsAuthorized_Delete, AV17IsAuthorized_Name, AV51IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV37ManageFiltersExecutionStep, AV54Pgmname, AV11FilName, AV48IsAuthorized_Display, AV49IsAuthorized_Update, AV50IsAuthorized_Delete, AV17IsAuthorized_Name, AV51IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV54Pgmname = "GAMWWSecurityPolicy" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavBtnsaveas_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsaveas_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnsaveas_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_39_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1J0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e151J2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV41ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_39 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_39"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV43GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV13GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV45GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV11FilName = httpContext.cgiGet( edtavFilname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11FilName", AV11FilName);
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
      e151J2 ();
      if (returnInSub) return;
   }

   public void e151J2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV30HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      lblBtninsert_Caption = GXutil.format( "<i class='fas fa-plus' title='%1'></i>", httpContext.getMessage( "Add children", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Caption", lblBtninsert_Caption, true);
      GXt_boolean1 = AV17IsAuthorized_Name ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamsecuritypolicyentry_Execute", GXv_boolean2) ;
      gamwwsecuritypolicy_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV17IsAuthorized_Name = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17IsAuthorized_Name", AV17IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV17IsAuthorized_Name));
      Form.setCaption( httpContext.getMessage( "WWP_GAM_SecurityPolicies", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      edtavBtnsaveas_Title = httpContext.getMessage( "WWP_GAM_Copy", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsaveas_Internalname, "Title", edtavBtnsaveas_Title, !bGXsfl_39_Refreshing);
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void e161J2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV31WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV31WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      if ( AV37ManageFiltersExecutionStep == 1 )
      {
         AV37ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37ManageFiltersExecutionStep", GXutil.str( AV37ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV37ManageFiltersExecutionStep == 2 )
      {
         AV37ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37ManageFiltersExecutionStep", GXutil.str( AV37ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV43GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43GridCurrentPage), 10, 0));
      GXt_char4 = AV45GridAppliedFilters ;
      GXv_char5[0] = GXt_char4 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV54Pgmname, GXv_char5) ;
      gamwwsecuritypolicy_impl.this.GXt_char4 = GXv_char5[0] ;
      AV45GridAppliedFilters = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45GridAppliedFilters", AV45GridAppliedFilters);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41ManageFiltersData", AV41ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34GridState", AV34GridState);
   }

   public void e121J2( )
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
         AV19PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV19PageToGo) ;
      }
   }

   public void e131J2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e171J2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV23GridPageSize = subGrid_Rows ;
      AV12Filter.setgxTv_SdtGAMSecurityPolicyFilter_Name( "%"+AV11FilName );
      GXv_objcol_SdtGAMError6[0] = AV10Errors ;
      AV22GAMSecurityPolicies = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getsecuritypolicies(AV12Filter, GXv_objcol_SdtGAMError6) ;
      AV10Errors = GXv_objcol_SdtGAMError6[0] ;
      AV24GridRecordCount = AV22GAMSecurityPolicies.size() ;
      if ( AV22GAMSecurityPolicies.size() == 0 )
      {
         AV13GridPageCount = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13GridPageCount), 10, 0));
      }
      else
      {
         AV13GridPageCount = (long)((AV22GAMSecurityPolicies.size()/ (double) (AV23GridPageSize))+((((int)((AV22GAMSecurityPolicies.size()) % (AV23GridPageSize)))>0) ? 1 : 0)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13GridPageCount), 10, 0));
      }
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV22GAMSecurityPolicies.size() )
      {
         AV20SecurityPolicy = (genexus.security.api.genexussecurity.SdtGAMSecurityPolicy)((genexus.security.api.genexussecurity.SdtGAMSecurityPolicy)AV22GAMSecurityPolicies.elementAt(-1+AV55GXV1));
         AV14Id = AV20SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Id), 12, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_39_idx, getSecureSignedToken( sGXsfl_39_idx, localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
         AV18Name = AV20SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV18Name);
         AV46Display = "<i class=\"fa fa-search\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV46Display);
         if ( AV48IsAuthorized_Display )
         {
            edtavDisplay_Link = formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(AV14Id,12,0))}, new String[] {"Mode","Id"})  ;
         }
         AV47Update = "<i class=\"fa fa-pen\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV47Update);
         if ( AV49IsAuthorized_Update )
         {
            edtavUpdate_Link = formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.ltrimstr(AV14Id,12,0))}, new String[] {"Mode","Id"})  ;
         }
         AV5Delete = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
         if ( AV50IsAuthorized_Delete )
         {
            edtavDelete_Link = formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.ltrimstr(AV14Id,12,0))}, new String[] {"Mode","Id"})  ;
         }
         AV25BtnSaveAs = "<i class=\"fas fa-copy\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavBtnsaveas_Internalname, AV25BtnSaveAs);
         if ( AV17IsAuthorized_Name )
         {
            edtavName_Link = formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(AV14Id,12,0))}, new String[] {"Mode","Id"})  ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(39) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_392( ) ;
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
         if ( isFullAjaxMode( ) && ! bGXsfl_39_Refreshing )
         {
            httpContext.doAjaxLoad(39, GridRow);
         }
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV12Filter", AV12Filter);
   }

   public void e111J2( )
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
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWSecurityPolicyFilters")),GXutil.URLEncode(GXutil.rtrim(AV54Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV37ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37ManageFiltersExecutionStep", GXutil.str( AV37ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWSecurityPolicyFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV37ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37ManageFiltersExecutionStep", GXutil.str( AV37ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV38ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "GAMWWSecurityPolicyFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         gamwwsecuritypolicy_impl.this.GXt_char4 = GXv_char5[0] ;
         AV38ManageFiltersXml = GXt_char4 ;
         if ( (GXutil.strcmp("", AV38ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S152 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV54Pgmname+"GridState", AV38ManageFiltersXml) ;
            AV34GridState.fromxml(AV38ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S162 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34GridState", AV34GridState);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41ManageFiltersData", AV41ManageFiltersData);
   }

   public void e141J2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( AV51IsAuthorized_Insert )
      {
         callWebObject(formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"Mode","Id"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41ManageFiltersData", AV41ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34GridState", AV34GridState);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV48IsAuthorized_Display ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamsecuritypolicyentry_Execute", GXv_boolean2) ;
      gamwwsecuritypolicy_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV48IsAuthorized_Display = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48IsAuthorized_Display", AV48IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV48IsAuthorized_Display));
      if ( ! ( AV48IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_39_Refreshing);
      }
      GXt_boolean1 = AV49IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamsecuritypolicyentry_Execute", GXv_boolean2) ;
      gamwwsecuritypolicy_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV49IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49IsAuthorized_Update", AV49IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV49IsAuthorized_Update));
      if ( ! ( AV49IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_39_Refreshing);
      }
      GXt_boolean1 = AV50IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamsecuritypolicyentry_Execute", GXv_boolean2) ;
      gamwwsecuritypolicy_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV50IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50IsAuthorized_Delete", AV50IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV50IsAuthorized_Delete));
      if ( ! ( AV50IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_39_Refreshing);
      }
      GXt_boolean1 = AV51IsAuthorized_Insert ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamsecuritypolicyentry_Execute", GXv_boolean2) ;
      gamwwsecuritypolicy_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV51IsAuthorized_Insert = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51IsAuthorized_Insert", AV51IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV51IsAuthorized_Insert));
      if ( ! ( AV51IsAuthorized_Insert ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = AV41ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "GAMWWSecurityPolicyFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] ;
      AV41ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   }

   public void S152( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV11FilName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11FilName", AV11FilName);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV36Session.getValue(AV54Pgmname+"GridState"), "") == 0 )
      {
         AV34GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV54Pgmname+"GridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV36Session.getValue(AV54Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV34GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV34GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV34GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S162( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV56GXV2 = 1 ;
      while ( AV56GXV2 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV2));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILNAME") == 0 )
         {
            AV11FilName = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11FilName", AV11FilName);
         }
         AV56GXV2 = (int)(AV56GXV2+1) ;
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV34GridState.fromxml(AV36Session.getValue(AV54Pgmname+"GridState"), null, null);
      AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV34GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILNAME", httpContext.getMessage( "WWP_GAM_Name", ""), !(GXutil.strcmp("", AV11FilName)==0), (short)(0), AV11FilName, "") ;
      AV34GridState = GXv_SdtWWPGridState9[0] ;
      AV34GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV34GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV54Pgmname+"GridState", AV34GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e181J2( )
   {
      /* Btnsaveas_Click Routine */
      returnInSub = false ;
      AV20SecurityPolicy.load((int)(AV14Id));
      GXv_SdtGAMSecurityPolicy10[0] = AV27NewGAMSecurityPolicy;
      GXv_objcol_SdtGAMError6[0] = AV10Errors ;
      AV26isOK = AV20SecurityPolicy.saveas(GXv_SdtGAMSecurityPolicy10, GXv_objcol_SdtGAMError6) ;
      AV27NewGAMSecurityPolicy = GXv_SdtGAMSecurityPolicy10[0] ;
      AV10Errors = GXv_objcol_SdtGAMError6[0] ;
      if ( AV26isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwwsecuritypolicy");
         httpContext.doAjaxRefresh();
      }
      else
      {
         AV57GXV3 = 1 ;
         while ( AV57GXV3 <= AV10Errors.size() )
         {
            AV9Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+AV57GXV3));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV9Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV9Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV57GXV3 = (int)(AV57GXV3+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41ManageFiltersData", AV41ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34GridState", AV34GridState);
   }

   public void wb_table1_20_1J2( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV41ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_25_1J2( true) ;
      }
      else
      {
         wb_table2_25_1J2( false) ;
      }
      return  ;
   }

   public void wb_table2_25_1J2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_20_1J2e( true) ;
      }
      else
      {
         wb_table1_20_1J2e( false) ;
      }
   }

   public void wb_table2_25_1J2( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'" + sGXsfl_39_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilname_Internalname, GXutil.rtrim( AV11FilName), GXutil.rtrim( localUtil.format( AV11FilName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFilname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilname_Enabled, 0, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMWWSecurityPolicy.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_25_1J2e( true) ;
      }
      else
      {
         wb_table2_25_1J2e( false) ;
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
      pa1J2( ) ;
      ws1J2( ) ;
      we1J2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211115714", true, true);
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
      httpContext.AddJavascriptSource("gamwwsecuritypolicy.js", "?20241211115727", false, true);
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

   public void subsflControlProps_392( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_39_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_39_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_39_idx ;
      edtavBtnsaveas_Internalname = "vBTNSAVEAS_"+sGXsfl_39_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_39_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_39_idx ;
   }

   public void subsflControlProps_fel_392( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_39_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_39_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_39_fel_idx ;
      edtavBtnsaveas_Internalname = "vBTNSAVEAS_"+sGXsfl_39_fel_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_39_fel_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_39_fel_idx ;
   }

   public void sendrow_392( )
   {
      subsflControlProps_392( ) ;
      wb1J0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_39_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_39_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_39_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 40,'',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV46Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,40);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 41,'',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV47Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,41);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV5Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,42);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavBtnsaveas_Enabled!=0)&&(edtavBtnsaveas_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 43,'',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtnsaveas_Internalname,GXutil.rtrim( AV25BtnSaveAs),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavBtnsaveas_Enabled!=0)&&(edtavBtnsaveas_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,43);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVBTNSAVEAS.CLICK."+sGXsfl_39_idx+"'","","",httpContext.getMessage( "WWP_GAM_Copy", ""),"",edtavBtnsaveas_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(edtavBtnsaveas_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 44,'',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavName_Internalname,GXutil.rtrim( AV18Name),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,44);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavName_Link,"","","",edtavName_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 45,'',false,'"+sGXsfl_39_idx+"',39)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavId_Internalname,GXutil.ltrim( localUtil.ntoc( AV14Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,45);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(39),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMKeyNumLong","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes1J2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_39_idx = ((subGrid_Islastpage==1)&&(nGXsfl_39_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_39_idx+1) ;
         sGXsfl_39_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_39_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_392( ) ;
      }
      /* End function sendrow_392 */
   }

   public void startgridcontrol39( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"39\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( edtavBtnsaveas_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Name", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Id", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV46Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV47Update));
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV25BtnSaveAs));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavBtnsaveas_Title));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtnsaveas_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18Name));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavName_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV14Id, (byte)(12), (byte)(0), ".", "")));
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
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      lblBtninsert_Internalname = "BTNINSERT" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      edtavFilname_Internalname = "vFILNAME" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavBtnsaveas_Internalname = "vBTNSAVEAS" ;
      edtavName_Internalname = "vNAME" ;
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
      edtavName_Jsonclick = "" ;
      edtavName_Visible = -1 ;
      edtavName_Link = "" ;
      edtavName_Enabled = 1 ;
      edtavBtnsaveas_Jsonclick = "" ;
      edtavBtnsaveas_Visible = -1 ;
      edtavBtnsaveas_Enabled = 1 ;
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
      edtavFilname_Jsonclick = "" ;
      edtavFilname_Enabled = 1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
      lblBtninsert_Caption = httpContext.getMessage( "<i class='fas fa-plus' title='Add children'></i>", "") ;
      lblBtninsert_Visible = 1 ;
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
      Form.setCaption( httpContext.getMessage( "WWP_GAM_SecurityPolicies", "") );
      edtavBtnsaveas_Title = "" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavBtnsaveas_Title',ctrl:'vBTNSAVEAS',prop:'Title'},{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV54Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV41ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV34GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV54Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'edtavBtnsaveas_Title',ctrl:'vBTNSAVEAS',prop:'Title'},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV54Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'edtavBtnsaveas_Title',ctrl:'vBTNSAVEAS',prop:'Title'},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e171J2',iparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV13GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV14Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV18Name',fld:'vNAME',pic:''},{av:'AV46Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV47Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV5Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV25BtnSaveAs',fld:'vBTNSAVEAS',pic:''},{av:'edtavName_Link',ctrl:'vNAME',prop:'Link'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV54Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'edtavBtnsaveas_Title',ctrl:'vBTNSAVEAS',prop:'Title'},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV34GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV34GridState',fld:'vGRIDSTATE',pic:''},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV41ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e141J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV54Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'edtavBtnsaveas_Title',ctrl:'vBTNSAVEAS',prop:'Title'},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV41ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV34GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VBTNSAVEAS.CLICK","{handler:'e181J2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV54Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV11FilName',fld:'vFILNAME',pic:''},{av:'edtavBtnsaveas_Title',ctrl:'vBTNSAVEAS',prop:'Title'},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV17IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV14Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("VBTNSAVEAS.CLICK",",oparms:[{av:'AV37ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV43GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV45GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV48IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV49IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV50IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV51IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV41ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV34GridState',fld:'vGRIDSTATE',pic:''}]}");
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
      return "gamwwsecuritypolicy_Execute";
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
      AV54Pgmname = "" ;
      AV11FilName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV41ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV45GridAppliedFilters = "" ;
      AV34GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      lblBtninsert_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV46Display = "" ;
      AV47Update = "" ;
      AV5Delete = "" ;
      AV25BtnSaveAs = "" ;
      AV18Name = "" ;
      AV30HTTPRequest = httpContext.getHttpRequest();
      AV31WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV12Filter = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicyFilter(remoteHandle, context);
      AV22GAMSecurityPolicies = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSecurityPolicy>(genexus.security.api.genexussecurity.SdtGAMSecurityPolicy.class, "GAMSecurityPolicy", "http://tempuri.org/", remoteHandle);
      AV10Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV20SecurityPolicy = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicy(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV38ManageFiltersXml = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection[1] ;
      AV36Session = httpContext.getWebSession();
      AV35GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState9 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      AV27NewGAMSecurityPolicy = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicy(remoteHandle, context);
      GXv_SdtGAMSecurityPolicy10 = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicy[1] ;
      GXv_objcol_SdtGAMError6 = new GXExternalCollection[1] ;
      AV9Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      TempTags = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwsecuritypolicy__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwsecuritypolicy__default(),
         new Object[] {
         }
      );
      AV54Pgmname = "GAMWWSecurityPolicy" ;
      /* GeneXus formulas. */
      AV54Pgmname = "GAMWWSecurityPolicy" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavBtnsaveas_Enabled = 0 ;
      edtavName_Enabled = 0 ;
      edtavId_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV37ManageFiltersExecutionStep ;
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
   private int nRC_GXsfl_39 ;
   private int nGXsfl_39_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int lblBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavBtnsaveas_Enabled ;
   private int edtavName_Enabled ;
   private int edtavId_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV19PageToGo ;
   private int AV55GXV1 ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int AV56GXV2 ;
   private int AV57GXV3 ;
   private int edtavFilname_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavBtnsaveas_Visible ;
   private int edtavName_Visible ;
   private int edtavId_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV43GridCurrentPage ;
   private long AV13GridPageCount ;
   private long AV14Id ;
   private long GRID_nCurrentRecord ;
   private long AV23GridPageSize ;
   private long AV24GridRecordCount ;
   private String edtavBtnsaveas_Title ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_39_idx="0001" ;
   private String edtavBtnsaveas_Internalname ;
   private String AV54Pgmname ;
   private String AV11FilName ;
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
   private String lblBtninsert_Internalname ;
   private String lblBtninsert_Caption ;
   private String lblBtninsert_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
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
   private String AV46Display ;
   private String edtavDisplay_Internalname ;
   private String AV47Update ;
   private String edtavUpdate_Internalname ;
   private String AV5Delete ;
   private String edtavDelete_Internalname ;
   private String AV25BtnSaveAs ;
   private String AV18Name ;
   private String edtavName_Internalname ;
   private String edtavId_Internalname ;
   private String edtavFilname_Internalname ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavName_Link ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String TempTags ;
   private String edtavFilname_Jsonclick ;
   private String sGXsfl_39_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavBtnsaveas_Jsonclick ;
   private String edtavName_Jsonclick ;
   private String edtavId_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_39_Refreshing=false ;
   private boolean AV48IsAuthorized_Display ;
   private boolean AV49IsAuthorized_Update ;
   private boolean AV50IsAuthorized_Delete ;
   private boolean AV17IsAuthorized_Name ;
   private boolean AV51IsAuthorized_Insert ;
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
   private boolean AV26isOK ;
   private String AV38ManageFiltersXml ;
   private String AV45GridAppliedFilters ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV30HTTPRequest ;
   private com.genexus.webpanels.WebSession AV36Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicyFilter AV12Filter ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV10Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError6[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSecurityPolicy> AV22GAMSecurityPolicies ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV41ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV31WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private genexus.security.api.genexussecurity.SdtGAMError AV9Error ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicy AV20SecurityPolicy ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicy AV27NewGAMSecurityPolicy ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicy GXv_SdtGAMSecurityPolicy10[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class gamwwsecuritypolicy__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwwsecuritypolicy__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

