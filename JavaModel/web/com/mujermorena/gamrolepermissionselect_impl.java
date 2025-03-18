package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamrolepermissionselect_impl extends GXDataArea
{
   public gamrolepermissionselect_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamrolepermissionselect_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamrolepermissionselect_impl.class ));
   }

   public gamrolepermissionselect_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavPermissionaccesstype = new HTMLChoice();
      cmbavBoolenfilter = new HTMLChoice();
      chkavSelect = UIFactory.getCheckbox(this);
      cmbavAccess = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "RoleId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "RoleId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "RoleId") ;
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
            AV27RoleId = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27RoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27RoleId), 12, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27RoleId), "ZZZZZZZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV10ApplicationId = GXutil.lval( httpContext.GetPar( "ApplicationId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ApplicationId), "ZZZZZZZZZZZ9")));
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
      nRC_GXsfl_46 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_46"))) ;
      nGXsfl_46_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_46_idx"))) ;
      sGXsfl_46_idx = httpContext.GetPar( "sGXsfl_46_idx") ;
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
      AV40ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV50Pgmname = httpContext.GetPar( "Pgmname") ;
      AV15FilName = httpContext.GetPar( "FilName") ;
      cmbavPermissionaccesstype.fromJSonString( httpContext.GetNextPar( ));
      AV24PermissionAccessType = httpContext.GetPar( "PermissionAccessType") ;
      cmbavBoolenfilter.fromJSonString( httpContext.GetNextPar( ));
      AV11BoolenFilter = httpContext.GetPar( "BoolenFilter") ;
      AV27RoleId = GXutil.lval( httpContext.GetPar( "RoleId")) ;
      AV10ApplicationId = GXutil.lval( httpContext.GetPar( "ApplicationId")) ;
      AV19IsAuthorized_Name = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Name")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV40ManageFiltersExecutionStep, AV50Pgmname, AV15FilName, AV24PermissionAccessType, AV11BoolenFilter, AV27RoleId, AV10ApplicationId, AV19IsAuthorized_Name) ;
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
      pa372( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start372( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamrolepermissionselect", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV27RoleId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10ApplicationId,12,0))}, new String[] {"RoleId","ApplicationId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV50Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27RoleId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV19IsAuthorized_Name));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_46", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_46, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV44ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV44ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV46GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV17GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV47GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV40ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV50Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV50Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vROLEID", GXutil.ltrim( localUtil.ntoc( AV27RoleId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27RoleId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV10ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV19IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV19IsAuthorized_Name));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV37GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV37GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISOK", AV20isOK);
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
         we372( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt372( ) ;
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
      return formatLink("com.mujermorena.gamrolepermissionselect", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV27RoleId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10ApplicationId,12,0))}, new String[] {"RoleId","ApplicationId"})  ;
   }

   public String getPgmname( )
   {
      return "GAMRolePermissionSelect" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_SelectPermissionsRole", "") ;
   }

   public void wb370( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "TableCellsWidthAuto", "left", "top", "", "", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRolePermissionSelect.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_17_372( true) ;
      }
      else
      {
         wb_table1_17_372( false) ;
      }
      return  ;
   }

   public void wb_table1_17_372e( boolean wbgen )
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
         startgridcontrol46( ) ;
      }
      if ( wbEnd == 46 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_46 = (int)(nGXsfl_46_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV46GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV17GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV47GridAppliedFilters);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnadd_Internalname, "gx.evt.setGridEvt("+GXutil.str( 46, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_AddSelected", ""), bttBtnadd_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_AddSelected", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOADD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRolePermissionSelect.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 46, 2, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRolePermissionSelect.htm");
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
      if ( wbEnd == 46 )
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

   public void start372( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_SelectPermissionsRole", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup370( ) ;
   }

   public void ws372( )
   {
      start372( ) ;
      evt372( ) ;
   }

   public void evt372( )
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
                           e11372 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12372 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13372 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOADD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoAdd' */
                           e14372 ();
                           /* No code required for Cancel button. It is implemented as the Reset button. */
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) )
                        {
                           nGXsfl_46_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_46_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_46_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_462( ) ;
                           AV28Select = GXutil.strtobool( httpContext.cgiGet( chkavSelect.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavSelect.getInternalname(), AV28Select);
                           AV21Name = httpContext.cgiGet( edtavName_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV21Name);
                           AV18ID = httpContext.cgiGet( edtavId_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV18ID);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, GXutil.rtrim( localUtil.format( AV18ID, ""))));
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAPPID");
                              GX_FocusControl = edtavAppid_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV9AppId = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9AppId), 12, 0));
                              com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9")));
                           }
                           else
                           {
                              AV9AppId = localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9AppId), 12, 0));
                              com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9")));
                           }
                           AV12Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV12Dsc);
                           cmbavAccess.setName( cmbavAccess.getInternalname() );
                           cmbavAccess.setValue( httpContext.cgiGet( cmbavAccess.getInternalname()) );
                           AV8Access = httpContext.cgiGet( cmbavAccess.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavAccess.getInternalname(), AV8Access);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e15372 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e16372 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17372 ();
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

   public void we372( )
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

   public void pa372( )
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
      subsflControlProps_462( ) ;
      while ( nGXsfl_46_idx <= nRC_GXsfl_46 )
      {
         sendrow_462( ) ;
         nGXsfl_46_idx = ((subGrid_Islastpage==1)&&(nGXsfl_46_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_46_idx+1) ;
         sGXsfl_46_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_46_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_462( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV40ManageFiltersExecutionStep ,
                                 String AV50Pgmname ,
                                 String AV15FilName ,
                                 String AV24PermissionAccessType ,
                                 String AV11BoolenFilter ,
                                 long AV27RoleId ,
                                 long AV10ApplicationId ,
                                 boolean AV19IsAuthorized_Name )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16372 ();
      GRID_nCurrentRecord = 0 ;
      rf372( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPID", GXutil.ltrim( localUtil.ntoc( AV9AppId, (byte)(12), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV18ID, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.rtrim( AV18ID));
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
      if ( cmbavPermissionaccesstype.getItemCount() > 0 )
      {
         AV24PermissionAccessType = cmbavPermissionaccesstype.getValidValue(AV24PermissionAccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PermissionAccessType", AV24PermissionAccessType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV24PermissionAccessType) );
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
      rf372( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV50Pgmname = "GAMRolePermissionSelect" ;
      Gx_err = (short)(0) ;
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      edtavAppid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAppid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAppid_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_46_Refreshing);
   }

   public void rf372( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(46) ;
      /* Execute user event: Refresh */
      e16372 ();
      nGXsfl_46_idx = 1 ;
      sGXsfl_46_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_46_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_462( ) ;
      bGXsfl_46_Refreshing = true ;
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
         subsflControlProps_462( ) ;
         e17372 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_46_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e17372 ();
         }
         wbEnd = (short)(46) ;
         wb370( ) ;
      }
      bGXsfl_46_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes372( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV50Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV50Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vROLEID", GXutil.ltrim( localUtil.ntoc( AV27RoleId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27RoleId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV10ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV19IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV19IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, GXutil.rtrim( localUtil.format( AV18ID, ""))));
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
         gxgrgrid_refresh( subGrid_Rows, AV40ManageFiltersExecutionStep, AV50Pgmname, AV15FilName, AV24PermissionAccessType, AV11BoolenFilter, AV27RoleId, AV10ApplicationId, AV19IsAuthorized_Name) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV40ManageFiltersExecutionStep, AV50Pgmname, AV15FilName, AV24PermissionAccessType, AV11BoolenFilter, AV27RoleId, AV10ApplicationId, AV19IsAuthorized_Name) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV40ManageFiltersExecutionStep, AV50Pgmname, AV15FilName, AV24PermissionAccessType, AV11BoolenFilter, AV27RoleId, AV10ApplicationId, AV19IsAuthorized_Name) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40ManageFiltersExecutionStep, AV50Pgmname, AV15FilName, AV24PermissionAccessType, AV11BoolenFilter, AV27RoleId, AV10ApplicationId, AV19IsAuthorized_Name) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV40ManageFiltersExecutionStep, AV50Pgmname, AV15FilName, AV24PermissionAccessType, AV11BoolenFilter, AV27RoleId, AV10ApplicationId, AV19IsAuthorized_Name) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV50Pgmname = "GAMRolePermissionSelect" ;
      Gx_err = (short)(0) ;
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      edtavAppid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAppid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAppid_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_46_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup370( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15372 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV44ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_46 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_46"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV46GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV17GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV47GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV15FilName = httpContext.cgiGet( edtavFilname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15FilName", AV15FilName);
         cmbavPermissionaccesstype.setName( cmbavPermissionaccesstype.getInternalname() );
         cmbavPermissionaccesstype.setValue( httpContext.cgiGet( cmbavPermissionaccesstype.getInternalname()) );
         AV24PermissionAccessType = httpContext.cgiGet( cmbavPermissionaccesstype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PermissionAccessType", AV24PermissionAccessType);
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
      e15372 ();
      if (returnInSub) return;
   }

   public void e15372( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( (0==AV27RoleId) || (0==AV10ApplicationId) )
      {
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV33HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      GXt_boolean1 = AV19IsAuthorized_Name ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamapppermissionentry_Execute", GXv_boolean2) ;
      gamrolepermissionselect_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV19IsAuthorized_Name = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19IsAuthorized_Name", AV19IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV19IsAuthorized_Name));
      Form.setCaption( httpContext.getMessage( "WWP_GAM_SelectPermissionsRole", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      AV16GAMRole.load(AV27RoleId);
      AV7GAMApplication.load(AV10ApplicationId);
      Form.setCaption( GXutil.format( httpContext.getMessage( "WWP_GAM_AddPermissionsToRole", ""), GXutil.trim( AV16GAMRole.getgxTv_SdtGAMRole_Name()), GXutil.trim( AV7GAMApplication.getgxTv_SdtGAMApplication_Name()), "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void e16372( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV34WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV34WWPContext = GXv_SdtWWPContext3[0] ;
      if ( AV40ManageFiltersExecutionStep == 1 )
      {
         AV40ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40ManageFiltersExecutionStep", GXutil.str( AV40ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV40ManageFiltersExecutionStep == 2 )
      {
         AV40ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40ManageFiltersExecutionStep", GXutil.str( AV40ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      AV46GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46GridCurrentPage), 10, 0));
      GXt_char4 = AV47GridAppliedFilters ;
      GXv_char5[0] = GXt_char4 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV50Pgmname, GXv_char5) ;
      gamrolepermissionselect_impl.this.GXt_char4 = GXv_char5[0] ;
      AV47GridAppliedFilters = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47GridAppliedFilters", AV47GridAppliedFilters);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44ManageFiltersData", AV44ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37GridState", AV37GridState);
   }

   public void e12372( )
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
         AV22PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV22PageToGo) ;
      }
   }

   public void e13372( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e17372( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV16GAMRole.load(AV27RoleId);
      AV9AppId = AV10ApplicationId ;
      httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9AppId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9")));
      AV26PermissionFilter.setgxTv_SdtGAMPermissionFilter_Applicationid( AV9AppId );
      AV26PermissionFilter.setgxTv_SdtGAMPermissionFilter_Name( AV15FilName );
      AV26PermissionFilter.setgxTv_SdtGAMPermissionFilter_Accesstype( AV24PermissionAccessType );
      AV26PermissionFilter.setgxTv_SdtGAMPermissionFilter_Inherited( AV11BoolenFilter );
      GXv_objcol_SdtGAMError6[0] = AV14Errors ;
      AV29GAMPermissions = AV16GAMRole.getunassignedpermissions(AV26PermissionFilter, GXv_objcol_SdtGAMError6) ;
      AV14Errors = GXv_objcol_SdtGAMError6[0] ;
      if ( AV29GAMPermissions.size() == 0 )
      {
         AV17GridPageCount = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GridPageCount), 10, 0));
      }
      else
      {
         AV17GridPageCount = (long)((AV29GAMPermissions.size()/ (double) (10))+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GridPageCount), 10, 0));
      }
      AV5GridRecordCount = AV29GAMPermissions.size() ;
      if ( ! (0==AV9AppId) )
      {
         AV51GXV1 = 1 ;
         while ( AV51GXV1 <= AV29GAMPermissions.size() )
         {
            AV23Permission = (genexus.security.api.genexussecurity.SdtGAMPermission)((genexus.security.api.genexussecurity.SdtGAMPermission)AV29GAMPermissions.elementAt(-1+AV51GXV1));
            AV28Select = false ;
            httpContext.ajax_rsp_assign_attri("", false, chkavSelect.getInternalname(), AV28Select);
            AV18ID = AV23Permission.getgxTv_SdtGAMPermission_Guid() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV18ID);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_46_idx, getSecureSignedToken( sGXsfl_46_idx, GXutil.rtrim( localUtil.format( AV18ID, ""))));
            AV21Name = AV23Permission.getgxTv_SdtGAMPermission_Name() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV21Name);
            AV12Dsc = AV23Permission.getgxTv_SdtGAMPermission_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV12Dsc);
            if ( AV19IsAuthorized_Name )
            {
               edtavName_Link = formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.ltrimstr(AV10ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV18ID))}, new String[] {"Mode","ApplicationId","GUID"})  ;
            }
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(46) ;
            }
            if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
            {
               sendrow_462( ) ;
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
            if ( isFullAjaxMode( ) && ! bGXsfl_46_Refreshing )
            {
               httpContext.doAjaxLoad(46, GridRow);
            }
            AV51GXV1 = (int)(AV51GXV1+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV26PermissionFilter", AV26PermissionFilter);
   }

   public void e11372( )
   {
      /* Ddo_managefilters_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Clean#>") == 0 )
      {
         /* Execute user subroutine: 'CLEANFILTERS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Save#>") == 0 )
      {
         /* Execute user subroutine: 'SAVEGRIDSTATE' */
         S132 ();
         if (returnInSub) return;
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMRolePermissionSelectFilters")),GXutil.URLEncode(GXutil.rtrim(AV50Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV40ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40ManageFiltersExecutionStep", GXutil.str( AV40ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMRolePermissionSelectFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV40ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40ManageFiltersExecutionStep", GXutil.str( AV40ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char4 = AV41ManageFiltersXml ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "GAMRolePermissionSelectFilters", Ddo_managefilters_Activeeventkey, GXv_char5) ;
         gamrolepermissionselect_impl.this.GXt_char4 = GXv_char5[0] ;
         AV41ManageFiltersXml = GXt_char4 ;
         if ( (GXutil.strcmp("", AV41ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S142 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV50Pgmname+"GridState", AV41ManageFiltersXml) ;
            AV37GridState.fromxml(AV41ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S152 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37GridState", AV37GridState);
      cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV24PermissionAccessType) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
      cmbavBoolenfilter.setValue( GXutil.rtrim( AV11BoolenFilter) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavBoolenfilter.getInternalname(), "Values", cmbavBoolenfilter.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV44ManageFiltersData", AV44ManageFiltersData);
   }

   public void e14372( )
   {
      /* 'DoAdd' Routine */
      returnInSub = false ;
      AV16GAMRole.load(AV27RoleId);
      /* Start For Each Line */
      nRC_GXsfl_46 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_46"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_46_fel_idx = 0 ;
      while ( nGXsfl_46_fel_idx < nRC_GXsfl_46 )
      {
         nGXsfl_46_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_46_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_46_fel_idx+1) ;
         sGXsfl_46_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_46_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_462( ) ;
         AV28Select = GXutil.strtobool( httpContext.cgiGet( chkavSelect.getInternalname())) ;
         AV21Name = httpContext.cgiGet( edtavName_Internalname) ;
         AV18ID = httpContext.cgiGet( edtavId_Internalname) ;
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAPPID");
            GX_FocusControl = edtavAppid_Internalname ;
            wbErr = true ;
            AV9AppId = 0 ;
         }
         else
         {
            AV9AppId = localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         }
         AV12Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         cmbavAccess.setName( cmbavAccess.getInternalname() );
         cmbavAccess.setValue( httpContext.cgiGet( cmbavAccess.getInternalname()) );
         AV8Access = httpContext.cgiGet( cmbavAccess.getInternalname()) ;
         if ( AV28Select )
         {
            AV25PermissionAdd.setgxTv_SdtGAMPermission_Applicationid( AV9AppId );
            AV25PermissionAdd.setgxTv_SdtGAMPermission_Guid( AV18ID );
            AV25PermissionAdd.setgxTv_SdtGAMPermission_Type( AV8Access );
            GXv_objcol_SdtGAMError6[0] = AV14Errors ;
            AV20isOK = AV16GAMRole.addpermission(AV25PermissionAdd, GXv_objcol_SdtGAMError6) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20isOK", AV20isOK);
            AV14Errors = GXv_objcol_SdtGAMError6[0] ;
            if ( ! AV20isOK )
            {
               AV53GXV2 = 1 ;
               while ( AV53GXV2 <= AV14Errors.size() )
               {
                  AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV53GXV2));
                  httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
                  AV53GXV2 = (int)(AV53GXV2+1) ;
               }
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         /* End For Each Line */
      }
      if ( nGXsfl_46_fel_idx == 0 )
      {
         nGXsfl_46_idx = 1 ;
         sGXsfl_46_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_46_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_462( ) ;
      }
      nGXsfl_46_fel_idx = 1 ;
      if ( AV20isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamrolepermissionselect");
         callWebObject(formatLink("com.mujermorena.gamwwrolepermissions", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV27RoleId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10ApplicationId,12,0))}, new String[] {"RoleId","pApplicationId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         AV54GXV3 = 1 ;
         while ( AV54GXV3 <= AV14Errors.size() )
         {
            AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV54GXV3));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV54GXV3 = (int)(AV54GXV3+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25PermissionAdd", AV25PermissionAdd);
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = AV44ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "GAMRolePermissionSelectFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] ;
      AV44ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   }

   public void S142( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV15FilName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15FilName", AV15FilName);
      AV24PermissionAccessType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24PermissionAccessType", AV24PermissionAccessType);
      AV11BoolenFilter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV39Session.getValue(AV50Pgmname+"GridState"), "") == 0 )
      {
         AV37GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV50Pgmname+"GridState"), null, null);
      }
      else
      {
         AV37GridState.fromxml(AV39Session.getValue(AV50Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S152 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV37GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV37GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV37GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S152( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV55GXV4 = 1 ;
      while ( AV55GXV4 <= AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV38GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV55GXV4));
         if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILNAME") == 0 )
         {
            AV15FilName = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15FilName", AV15FilName);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PERMISSIONACCESSTYPE") == 0 )
         {
            AV24PermissionAccessType = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24PermissionAccessType", AV24PermissionAccessType);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "BOOLENFILTER") == 0 )
         {
            AV11BoolenFilter = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
         }
         AV55GXV4 = (int)(AV55GXV4+1) ;
      }
   }

   public void S132( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV37GridState.fromxml(AV39Session.getValue(AV50Pgmname+"GridState"), null, null);
      AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV37GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILNAME", httpContext.getMessage( "WWP_GAM_Name", ""), !(GXutil.strcmp("", AV15FilName)==0), (short)(0), AV15FilName, "") ;
      AV37GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV37GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "PERMISSIONACCESSTYPE", httpContext.getMessage( "WWP_GAM_Type", ""), !(GXutil.strcmp("", AV24PermissionAccessType)==0), (short)(0), AV24PermissionAccessType, "") ;
      AV37GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV37GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "BOOLENFILTER", httpContext.getMessage( "WWP_GAM_IsInherited", ""), !(GXutil.strcmp("", AV11BoolenFilter)==0), (short)(0), AV11BoolenFilter, "") ;
      AV37GridState = GXv_SdtWWPGridState9[0] ;
      AV37GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV37GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV50Pgmname+"GridState", AV37GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void wb_table1_17_372( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV44ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_22_372( true) ;
      }
      else
      {
         wb_table2_22_372( false) ;
      }
      return  ;
   }

   public void wb_table2_22_372e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_17_372e( true) ;
      }
      else
      {
         wb_table1_17_372e( false) ;
      }
   }

   public void wb_table2_22_372( boolean wbgen )
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'" + sGXsfl_46_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilname_Internalname, GXutil.rtrim( AV15FilName), GXutil.rtrim( localUtil.format( AV15FilName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFilname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMRolePermissionSelect.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPermissionaccesstype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavPermissionaccesstype.getInternalname(), httpContext.getMessage( "WWP_GAM_Type", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_46_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPermissionaccesstype, cmbavPermissionaccesstype.getInternalname(), GXutil.rtrim( AV24PermissionAccessType), 1, cmbavPermissionaccesstype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPermissionaccesstype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_GAMRolePermissionSelect.htm");
         cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV24PermissionAccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavBoolenfilter.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavBoolenfilter.getInternalname(), httpContext.getMessage( "WWP_GAM_IsInherited", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_46_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavBoolenfilter, cmbavBoolenfilter.getInternalname(), GXutil.rtrim( AV11BoolenFilter), 1, cmbavBoolenfilter.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavBoolenfilter.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_GAMRolePermissionSelect.htm");
         cmbavBoolenfilter.setValue( GXutil.rtrim( AV11BoolenFilter) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavBoolenfilter.getInternalname(), "Values", cmbavBoolenfilter.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_22_372e( true) ;
      }
      else
      {
         wb_table2_22_372e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV27RoleId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27RoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27RoleId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27RoleId), "ZZZZZZZZZZZ9")));
      AV10ApplicationId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ApplicationId), "ZZZZZZZZZZZ9")));
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
      pa372( ) ;
      ws372( ) ;
      we372( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111185952", true, true);
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
      httpContext.AddJavascriptSource("gamrolepermissionselect.js", "?202412111185955", false, true);
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

   public void subsflControlProps_462( )
   {
      chkavSelect.setInternalname( "vSELECT_"+sGXsfl_46_idx );
      edtavName_Internalname = "vNAME_"+sGXsfl_46_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_46_idx ;
      edtavAppid_Internalname = "vAPPID_"+sGXsfl_46_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_46_idx ;
      cmbavAccess.setInternalname( "vACCESS_"+sGXsfl_46_idx );
   }

   public void subsflControlProps_fel_462( )
   {
      chkavSelect.setInternalname( "vSELECT_"+sGXsfl_46_fel_idx );
      edtavName_Internalname = "vNAME_"+sGXsfl_46_fel_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_46_fel_idx ;
      edtavAppid_Internalname = "vAPPID_"+sGXsfl_46_fel_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_46_fel_idx ;
      cmbavAccess.setInternalname( "vACCESS_"+sGXsfl_46_fel_idx );
   }

   public void sendrow_462( )
   {
      subsflControlProps_462( ) ;
      wb370( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_46_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_46_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_46_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavSelect.getEnabled()!=0)&&(chkavSelect.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 47,'',false,'"+sGXsfl_46_idx+"',46)\"" : " ") ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vSELECT_" + sGXsfl_46_idx ;
         chkavSelect.setName( GXCCtl );
         chkavSelect.setWebtags( "" );
         chkavSelect.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavSelect.getInternalname(), "TitleCaption", chkavSelect.getCaption(), !bGXsfl_46_Refreshing);
         chkavSelect.setCheckedValue( "false" );
         AV28Select = GXutil.strtobool( GXutil.booltostr( AV28Select)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavSelect.getInternalname(), AV28Select);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavSelect.getInternalname(),GXutil.booltostr( AV28Select),"","",Integer.valueOf(-1),Integer.valueOf(1),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(47, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavSelect.getEnabled()!=0)&&(chkavSelect.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,47);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 48,'',false,'"+sGXsfl_46_idx+"',46)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavName_Internalname,GXutil.rtrim( AV21Name),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,48);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavName_Link,"","","",edtavName_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(46),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 49,'',false,'"+sGXsfl_46_idx+"',46)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavId_Internalname,GXutil.rtrim( AV18ID),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,49);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavId_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(46),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavAppid_Enabled!=0)&&(edtavAppid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 50,'',false,'"+sGXsfl_46_idx+"',46)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavAppid_Internalname,GXutil.ltrim( localUtil.ntoc( AV9AppId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavAppid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV9AppId), "ZZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavAppid_Enabled!=0)&&(edtavAppid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,50);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavAppid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavAppid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(46),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMKeyNumLong","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDsc_Enabled!=0)&&(edtavDsc_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 51,'',false,'"+sGXsfl_46_idx+"',46)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDsc_Internalname,GXutil.rtrim( AV12Dsc),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDsc_Enabled!=0)&&(edtavDsc_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,51);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDsc_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDsc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(46),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavAccess.getEnabled()!=0)&&(cmbavAccess.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 52,'',false,'"+sGXsfl_46_idx+"',46)\"" : " ") ;
         if ( ( cmbavAccess.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vACCESS_" + sGXsfl_46_idx ;
            cmbavAccess.setName( GXCCtl );
            cmbavAccess.setWebtags( "" );
            cmbavAccess.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
            cmbavAccess.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
            cmbavAccess.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
            if ( cmbavAccess.getItemCount() > 0 )
            {
               AV8Access = cmbavAccess.getValidValue(AV8Access) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavAccess.getInternalname(), AV8Access);
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavAccess,cmbavAccess.getInternalname(),GXutil.rtrim( AV8Access),Integer.valueOf(1),cmbavAccess.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavAccess.getEnabled()!=0)&&(cmbavAccess.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,52);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavAccess.setValue( GXutil.rtrim( AV8Access) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccess.getInternalname(), "Values", cmbavAccess.ToJavascriptSource(), !bGXsfl_46_Refreshing);
         send_integrity_lvl_hashes372( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_46_idx = ((subGrid_Islastpage==1)&&(nGXsfl_46_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_46_idx+1) ;
         sGXsfl_46_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_46_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_462( ) ;
      }
      /* End function sendrow_462 */
   }

   public void startgridcontrol46( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"46\">") ;
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
         httpContext.writeText( "<th align=\""+""+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(50), 4, 0)+"px"+" class=\""+"AttributeRealWidthCheckBox"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_PermissionName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_GUID", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Key Numeric Long", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Description", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_AccessType", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV28Select));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV21Name));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavName_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV18ID));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavId_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV9AppId, (byte)(12), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavAppid_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12Dsc));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDsc_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV8Access));
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
      divTableactions_Internalname = "TABLEACTIONS" ;
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      edtavFilname_Internalname = "vFILNAME" ;
      cmbavPermissionaccesstype.setInternalname( "vPERMISSIONACCESSTYPE" );
      cmbavBoolenfilter.setInternalname( "vBOOLENFILTER" );
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      chkavSelect.setInternalname( "vSELECT" );
      edtavName_Internalname = "vNAME" ;
      edtavId_Internalname = "vID" ;
      edtavAppid_Internalname = "vAPPID" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavAccess.setInternalname( "vACCESS" );
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      bttBtnadd_Internalname = "BTNADD" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
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
      cmbavAccess.setJsonclick( "" );
      cmbavAccess.setVisible( -1 );
      cmbavAccess.setEnabled( 1 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Visible = -1 ;
      edtavDsc_Enabled = 1 ;
      edtavAppid_Jsonclick = "" ;
      edtavAppid_Visible = 0 ;
      edtavAppid_Enabled = 1 ;
      edtavId_Jsonclick = "" ;
      edtavId_Visible = 0 ;
      edtavId_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Visible = -1 ;
      edtavName_Link = "" ;
      edtavName_Enabled = 1 ;
      chkavSelect.setCaption( "" );
      chkavSelect.setVisible( -1 );
      chkavSelect.setEnabled( 1 );
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      cmbavBoolenfilter.setJsonclick( "" );
      cmbavBoolenfilter.setEnabled( 1 );
      cmbavPermissionaccesstype.setJsonclick( "" );
      cmbavPermissionaccesstype.setEnabled( 1 );
      edtavFilname_Jsonclick = "" ;
      edtavFilname_Enabled = 1 ;
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
      Form.setCaption( httpContext.getMessage( "WWP_GAM_SelectPermissionsRole", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavPermissionaccesstype.setName( "vPERMISSIONACCESSTYPE" );
      cmbavPermissionaccesstype.setWebtags( "" );
      cmbavPermissionaccesstype.addItem("", httpContext.getMessage( "GX_EmptyItemText", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavPermissionaccesstype.getItemCount() > 0 )
      {
         AV24PermissionAccessType = cmbavPermissionaccesstype.getValidValue(AV24PermissionAccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PermissionAccessType", AV24PermissionAccessType);
      }
      cmbavBoolenfilter.setName( "vBOOLENFILTER" );
      cmbavBoolenfilter.setWebtags( "" );
      cmbavBoolenfilter.addItem("A", httpContext.getMessage( "WWP_GAM_All", ""), (short)(0));
      cmbavBoolenfilter.addItem("T", httpContext.getMessage( "WWP_GAM_Yes", ""), (short)(0));
      cmbavBoolenfilter.addItem("F", httpContext.getMessage( "WWP_GAM_No", ""), (short)(0));
      if ( cmbavBoolenfilter.getItemCount() > 0 )
      {
         AV11BoolenFilter = cmbavBoolenfilter.getValidValue(AV11BoolenFilter) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11BoolenFilter", AV11BoolenFilter);
      }
      GXCCtl = "vSELECT_" + sGXsfl_46_idx ;
      chkavSelect.setName( GXCCtl );
      chkavSelect.setWebtags( "" );
      chkavSelect.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavSelect.getInternalname(), "TitleCaption", chkavSelect.getCaption(), !bGXsfl_46_Refreshing);
      chkavSelect.setCheckedValue( "false" );
      AV28Select = GXutil.strtobool( GXutil.booltostr( AV28Select)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavSelect.getInternalname(), AV28Select);
      GXCCtl = "vACCESS_" + sGXsfl_46_idx ;
      cmbavAccess.setName( GXCCtl );
      cmbavAccess.setWebtags( "" );
      cmbavAccess.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavAccess.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
      cmbavAccess.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavAccess.getItemCount() > 0 )
      {
         AV8Access = cmbavAccess.getValidValue(AV8Access) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavAccess.getInternalname(), AV8Access);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV40ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV50Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV24PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV27RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV19IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV40ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV46GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV47GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV44ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12372',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV50Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV24PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV27RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV19IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13372',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV50Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV24PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV27RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV19IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e17372',iparms:[{av:'AV27RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV24PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV19IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV9AppId',fld:'vAPPID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV17GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV28Select',fld:'vSELECT',pic:''},{av:'AV18ID',fld:'vID',pic:'',hsh:true},{av:'AV21Name',fld:'vNAME',pic:''},{av:'AV12Dsc',fld:'vDSC',pic:''},{av:'edtavName_Link',ctrl:'vNAME',prop:'Link'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11372',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV50Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV24PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV27RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV19IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV40ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV37GridState',fld:'vGRIDSTATE',pic:''},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV24PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavBoolenfilter'},{av:'AV11BoolenFilter',fld:'vBOOLENFILTER',pic:''},{av:'AV46GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV47GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV44ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOADD'","{handler:'e14372',iparms:[{av:'AV27RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV28Select',fld:'vSELECT',grid:46,pic:''},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_46',ctrl:'GRID',grid:46,prop:'GridRC',grid:46},{av:'AV9AppId',fld:'vAPPID',grid:46,pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV18ID',fld:'vID',grid:46,pic:'',hsh:true},{av:'AV8Access',fld:'vACCESS',grid:46,pic:''},{av:'AV20isOK',fld:'vISOK',pic:''},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOADD'",",oparms:[{av:'AV20isOK',fld:'vISOK',pic:''}]}");
      setEventMetadata("VALIDV_PERMISSIONACCESSTYPE","{handler:'validv_Permissionaccesstype',iparms:[]");
      setEventMetadata("VALIDV_PERMISSIONACCESSTYPE",",oparms:[]}");
      setEventMetadata("VALIDV_ACCESS","{handler:'validv_Access',iparms:[]");
      setEventMetadata("VALIDV_ACCESS",",oparms:[]}");
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
      return "gamrolepermissionselect_Execute";
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
      AV50Pgmname = "" ;
      AV15FilName = "" ;
      AV24PermissionAccessType = "" ;
      AV11BoolenFilter = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV44ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV47GridAppliedFilters = "" ;
      AV37GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      bttBtnadd_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV21Name = "" ;
      AV18ID = "" ;
      AV12Dsc = "" ;
      AV8Access = "" ;
      AV33HTTPRequest = httpContext.getHttpRequest();
      GXv_boolean2 = new boolean[1] ;
      AV16GAMRole = new genexus.security.api.genexussecurity.SdtGAMRole(remoteHandle, context);
      AV7GAMApplication = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV34WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV26PermissionFilter = new genexus.security.api.genexussecurity.SdtGAMPermissionFilter(remoteHandle, context);
      AV29GAMPermissions = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMPermission>(genexus.security.api.genexussecurity.SdtGAMPermission.class, "GAMPermission", "http://tempuri.org/", remoteHandle);
      AV14Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV23Permission = new genexus.security.api.genexussecurity.SdtGAMPermission(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV41ManageFiltersXml = "" ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV25PermissionAdd = new genexus.security.api.genexussecurity.SdtGAMPermission(remoteHandle, context);
      GXv_objcol_SdtGAMError6 = new GXExternalCollection[1] ;
      AV13Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection[1] ;
      AV39Session = httpContext.getWebSession();
      AV38GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState9 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamrolepermissionselect__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamrolepermissionselect__default(),
         new Object[] {
         }
      );
      AV50Pgmname = "GAMRolePermissionSelect" ;
      /* GeneXus formulas. */
      AV50Pgmname = "GAMRolePermissionSelect" ;
      Gx_err = (short)(0) ;
      edtavName_Enabled = 0 ;
      edtavId_Enabled = 0 ;
      edtavAppid_Enabled = 0 ;
      edtavDsc_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV40ManageFiltersExecutionStep ;
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
   private int nRC_GXsfl_46 ;
   private int nGXsfl_46_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Islastpage ;
   private int edtavName_Enabled ;
   private int edtavId_Enabled ;
   private int edtavAppid_Enabled ;
   private int edtavDsc_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV22PageToGo ;
   private int AV51GXV1 ;
   private int nGXsfl_46_fel_idx=1 ;
   private int AV53GXV2 ;
   private int AV54GXV3 ;
   private int AV55GXV4 ;
   private int edtavFilname_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavName_Visible ;
   private int edtavId_Visible ;
   private int edtavAppid_Visible ;
   private int edtavDsc_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV27RoleId ;
   private long wcpOAV10ApplicationId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV27RoleId ;
   private long AV10ApplicationId ;
   private long AV46GridCurrentPage ;
   private long AV17GridPageCount ;
   private long AV9AppId ;
   private long GRID_nCurrentRecord ;
   private long AV5GridRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_46_idx="0001" ;
   private String AV50Pgmname ;
   private String AV15FilName ;
   private String AV24PermissionAccessType ;
   private String AV11BoolenFilter ;
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
   private String ClassString ;
   private String StyleString ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String TempTags ;
   private String bttBtnadd_Internalname ;
   private String bttBtnadd_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV21Name ;
   private String edtavName_Internalname ;
   private String AV18ID ;
   private String edtavId_Internalname ;
   private String edtavAppid_Internalname ;
   private String AV12Dsc ;
   private String edtavDsc_Internalname ;
   private String AV8Access ;
   private String edtavFilname_Internalname ;
   private String edtavName_Link ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String sGXsfl_46_fel_idx="0001" ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilname_Jsonclick ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavName_Jsonclick ;
   private String edtavId_Jsonclick ;
   private String edtavAppid_Jsonclick ;
   private String edtavDsc_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV19IsAuthorized_Name ;
   private boolean AV20isOK ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV28Select ;
   private boolean bGXsfl_46_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean gx_refresh_fired ;
   private String AV41ManageFiltersXml ;
   private String AV47GridAppliedFilters ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV33HTTPRequest ;
   private com.genexus.webpanels.WebSession AV39Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private genexus.security.api.genexussecurity.SdtGAMPermission AV25PermissionAdd ;
   private genexus.security.api.genexussecurity.SdtGAMPermissionFilter AV26PermissionFilter ;
   private HTMLChoice cmbavPermissionaccesstype ;
   private HTMLChoice cmbavBoolenfilter ;
   private ICheckbox chkavSelect ;
   private HTMLChoice cmbavAccess ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV14Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError6[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMPermission> AV29GAMPermissions ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV44ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[] ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV7GAMApplication ;
   private genexus.security.api.genexussecurity.SdtGAMError AV13Error ;
   private genexus.security.api.genexussecurity.SdtGAMRole AV16GAMRole ;
   private genexus.security.api.genexussecurity.SdtGAMPermission AV23Permission ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV34WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV37GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV38GridStateFilterValue ;
}

final  class gamrolepermissionselect__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamrolepermissionselect__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

