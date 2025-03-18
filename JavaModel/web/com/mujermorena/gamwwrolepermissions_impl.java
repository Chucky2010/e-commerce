package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwwrolepermissions_impl extends GXDataArea
{
   public gamwwrolepermissions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwwrolepermissions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwwrolepermissions_impl.class ));
   }

   public gamwwrolepermissions_impl( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavApplicationid = new HTMLChoice();
      cmbavPermissionaccesstype = new HTMLChoice();
      cmbavIsinherited = new HTMLChoice();
      cmbavOld_accesstype = new HTMLChoice();
      chkavOld_inherited = UIFactory.getCheckbox(this);
      cmbavAccesstype = new HTMLChoice();
      chkavInherited = UIFactory.getCheckbox(this);
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
            AV30RoleId = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavRoleid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30RoleId), 12, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV26pApplicationId = GXutil.lval( httpContext.GetPar( "pApplicationId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26pApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26pApplicationId), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26pApplicationId), "ZZZZZZZZZZZ9")));
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
      nRC_GXsfl_58 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_58"))) ;
      nGXsfl_58_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_58_idx"))) ;
      sGXsfl_58_idx = httpContext.GetPar( "sGXsfl_58_idx") ;
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
      AV62ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV79Pgmname = httpContext.GetPar( "Pgmname") ;
      cmbavApplicationid.fromJSonString( httpContext.GetNextPar( ));
      AV10ApplicationId = GXutil.lval( httpContext.GetPar( "ApplicationId")) ;
      AV15FilName = httpContext.GetPar( "FilName") ;
      cmbavPermissionaccesstype.fromJSonString( httpContext.GetNextPar( ));
      AV28PermissionAccessType = httpContext.GetPar( "PermissionAccessType") ;
      cmbavIsinherited.fromJSonString( httpContext.GetNextPar( ));
      AV20IsInherited = httpContext.GetPar( "IsInherited") ;
      AV30RoleId = GXutil.lval( httpContext.GetPar( "RoleId")) ;
      AV73IsAuthorized_Back = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Back")) ;
      AV74IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      AV26pApplicationId = GXutil.lval( httpContext.GetPar( "pApplicationId")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV62ManageFiltersExecutionStep, AV79Pgmname, AV10ApplicationId, AV15FilName, AV28PermissionAccessType, AV20IsInherited, AV30RoleId, AV73IsAuthorized_Back, AV74IsAuthorized_Insert, AV26pApplicationId) ;
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
      pa382( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start382( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwwrolepermissions", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV30RoleId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV26pApplicationId,12,0))}, new String[] {"RoleId","pApplicationId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV73IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV74IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26pApplicationId), "ZZZZZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_58", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_58, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV66ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV66ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV69GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV17GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV72GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV62ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV79Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79Pgmname, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV43GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV43GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BACK", AV73IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV73IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV74IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV74IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISOK", AV21isOK);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV26pApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26pApplicationId), "ZZZZZZZZZZZ9")));
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
         we382( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt382( ) ;
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
      return formatLink("com.mujermorena.gamwwrolepermissions", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV30RoleId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV26pApplicationId,12,0))}, new String[] {"RoleId","pApplicationId"})  ;
   }

   public String getPgmname( )
   {
      return "GAMWWRolePermissions" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_RolePermissions", "") ;
   }

   public void wb380( )
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWWRolePermissions.htm");
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
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnback_Internalname, "gx.evt.setGridEvt("+GXutil.str( 58, 2, 0)+","+"null"+");", " ", bttBtnback_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_Back", ""), "", StyleString, ClassString, bttBtnback_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBACK\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWWRolePermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_GAMWWRolePermissions.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnsave_Internalname, "gx.evt.setGridEvt("+GXutil.str( 58, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_SaveChanges", ""), bttBtnsave_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_SaveChanges", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSAVE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMWWRolePermissions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6 CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_24_382( true) ;
      }
      else
      {
         wb_table1_24_382( false) ;
      }
      return  ;
   }

   public void wb_table1_24_382e( boolean wbgen )
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
         startgridcontrol58( ) ;
      }
      if ( wbEnd == 58 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_58 = (int)(nGXsfl_58_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV69GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV17GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV72GridAppliedFilters);
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
      if ( wbEnd == 58 )
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

   public void start382( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_RolePermissions", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup380( ) ;
   }

   public void ws382( )
   {
      start382( ) ;
      evt382( ) ;
   }

   public void evt382( )
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
                           e11382 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e12382 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13382 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBACK'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBack' */
                           e14382 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e15382 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSAVE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSave' */
                           e16382 ();
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
                           nGXsfl_58_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_58_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_58_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_582( ) ;
                           AV5Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
                           cmbavOld_accesstype.setName( cmbavOld_accesstype.getInternalname() );
                           cmbavOld_accesstype.setValue( httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) );
                           AV23old_AccessType = httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV23old_AccessType);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV23old_AccessType, ""))));
                           AV24Old_Inherited = GXutil.strtobool( httpContext.cgiGet( chkavOld_inherited.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV24Old_Inherited);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, AV24Old_Inherited));
                           AV30RoleId = localUtil.ctol( httpContext.cgiGet( edtavRoleid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavRoleid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30RoleId), 12, 0));
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9")));
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAPPID");
                              GX_FocusControl = edtavAppid_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV7AppId = 0 ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7AppId), 12, 0));
                           }
                           else
                           {
                              AV7AppId = localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavAppid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7AppId), 12, 0));
                           }
                           AV22Name = httpContext.cgiGet( edtavName_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV22Name);
                           AV12Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV12Dsc);
                           cmbavAccesstype.setName( cmbavAccesstype.getInternalname() );
                           cmbavAccesstype.setValue( httpContext.cgiGet( cmbavAccesstype.getInternalname()) );
                           AV6AccessType = httpContext.cgiGet( cmbavAccesstype.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
                           AV19Inherited = GXutil.strtobool( httpContext.cgiGet( chkavInherited.getInternalname())) ;
                           httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
                           AV18Id = httpContext.cgiGet( edtavId_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV18Id);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV18Id, ""))));
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e17382 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e18382 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e19382 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20382 ();
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

   public void we382( )
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

   public void pa382( )
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
      subsflControlProps_582( ) ;
      while ( nGXsfl_58_idx <= nRC_GXsfl_58 )
      {
         sendrow_582( ) ;
         nGXsfl_58_idx = ((subGrid_Islastpage==1)&&(nGXsfl_58_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_58_idx+1) ;
         sGXsfl_58_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_58_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_582( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV62ManageFiltersExecutionStep ,
                                 String AV79Pgmname ,
                                 long AV10ApplicationId ,
                                 String AV15FilName ,
                                 String AV28PermissionAccessType ,
                                 String AV20IsInherited ,
                                 long AV30RoleId ,
                                 boolean AV73IsAuthorized_Back ,
                                 boolean AV74IsAuthorized_Insert ,
                                 long AV26pApplicationId )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e18382 ();
      GRID_nCurrentRecord = 0 ;
      rf382( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vROLEID", GXutil.ltrim( localUtil.ntoc( AV30RoleId, (byte)(12), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23old_AccessType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vOLD_ACCESSTYPE", GXutil.rtrim( AV23old_AccessType));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED", getSecureSignedToken( "", AV24Old_Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vOLD_INHERITED", GXutil.booltostr( AV24Old_Inherited));
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
         AV28PermissionAccessType = cmbavPermissionaccesstype.getValidValue(AV28PermissionAccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionAccessType", AV28PermissionAccessType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV28PermissionAccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
      }
      if ( cmbavIsinherited.getItemCount() > 0 )
      {
         AV20IsInherited = cmbavIsinherited.getValidValue(AV20IsInherited) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20IsInherited", AV20IsInherited);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavIsinherited.setValue( GXutil.rtrim( AV20IsInherited) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIsinherited.getInternalname(), "Values", cmbavIsinherited.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf382( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV79Pgmname = "GAMWWRolePermissions" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      cmbavOld_accesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavOld_accesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOld_accesstype.getEnabled(), 5, 0), !bGXsfl_58_Refreshing);
      chkavOld_inherited.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOld_inherited.getEnabled(), 5, 0), !bGXsfl_58_Refreshing);
      edtavRoleid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavRoleid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRoleid_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavAppid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAppid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAppid_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_58_Refreshing);
   }

   public void rf382( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(58) ;
      /* Execute user event: Refresh */
      e18382 ();
      nGXsfl_58_idx = 1 ;
      sGXsfl_58_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_58_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_582( ) ;
      bGXsfl_58_Refreshing = true ;
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
         subsflControlProps_582( ) ;
         e19382 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_58_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e19382 ();
         }
         wbEnd = (short)(58) ;
         wb380( ) ;
      }
      bGXsfl_58_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes382( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV79Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV79Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BACK", AV73IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV73IsAuthorized_Back));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV74IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV74IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV23old_AccessType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, AV24Old_Inherited));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV18Id, ""))));
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
         gxgrgrid_refresh( subGrid_Rows, AV62ManageFiltersExecutionStep, AV79Pgmname, AV10ApplicationId, AV15FilName, AV28PermissionAccessType, AV20IsInherited, AV30RoleId, AV73IsAuthorized_Back, AV74IsAuthorized_Insert, AV26pApplicationId) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV62ManageFiltersExecutionStep, AV79Pgmname, AV10ApplicationId, AV15FilName, AV28PermissionAccessType, AV20IsInherited, AV30RoleId, AV73IsAuthorized_Back, AV74IsAuthorized_Insert, AV26pApplicationId) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV62ManageFiltersExecutionStep, AV79Pgmname, AV10ApplicationId, AV15FilName, AV28PermissionAccessType, AV20IsInherited, AV30RoleId, AV73IsAuthorized_Back, AV74IsAuthorized_Insert, AV26pApplicationId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV62ManageFiltersExecutionStep, AV79Pgmname, AV10ApplicationId, AV15FilName, AV28PermissionAccessType, AV20IsInherited, AV30RoleId, AV73IsAuthorized_Back, AV74IsAuthorized_Insert, AV26pApplicationId) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV62ManageFiltersExecutionStep, AV79Pgmname, AV10ApplicationId, AV15FilName, AV28PermissionAccessType, AV20IsInherited, AV30RoleId, AV73IsAuthorized_Back, AV74IsAuthorized_Insert, AV26pApplicationId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV79Pgmname = "GAMWWRolePermissions" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      cmbavOld_accesstype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavOld_accesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavOld_accesstype.getEnabled(), 5, 0), !bGXsfl_58_Refreshing);
      chkavOld_inherited.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "Enabled", GXutil.ltrimstr( chkavOld_inherited.getEnabled(), 5, 0), !bGXsfl_58_Refreshing);
      edtavRoleid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavRoleid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRoleid_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavAppid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAppid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAppid_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavDsc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_58_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup380( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e17382 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV66ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_58 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_58"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV69GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV17GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV72GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV15FilName = httpContext.cgiGet( edtavFilname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15FilName", AV15FilName);
         cmbavPermissionaccesstype.setName( cmbavPermissionaccesstype.getInternalname() );
         cmbavPermissionaccesstype.setValue( httpContext.cgiGet( cmbavPermissionaccesstype.getInternalname()) );
         AV28PermissionAccessType = httpContext.cgiGet( cmbavPermissionaccesstype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionAccessType", AV28PermissionAccessType);
         cmbavIsinherited.setName( cmbavIsinherited.getInternalname() );
         cmbavIsinherited.setValue( httpContext.cgiGet( cmbavIsinherited.getInternalname()) );
         AV20IsInherited = httpContext.cgiGet( cmbavIsinherited.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20IsInherited", AV20IsInherited);
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
      e17382 ();
      if (returnInSub) return;
   }

   public void e17382( )
   {
      /* Start Routine */
      returnInSub = false ;
      cmbavApplicationid.removeAllItems();
      cmbavApplicationid.addItem("0", httpContext.getMessage( "(Select)", ""), (short)(0));
      AV78GXV2 = 1 ;
      GXv_objcol_SdtGAMError1[0] = AV14Errors ;
      AV77GXV1 = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getapplications(AV9ApplicationFilter, GXv_objcol_SdtGAMError1) ;
      AV14Errors = GXv_objcol_SdtGAMError1[0] ;
      while ( AV78GXV2 <= AV77GXV1.size() )
      {
         AV8Application = (genexus.security.api.genexussecurity.SdtGAMApplication)((genexus.security.api.genexussecurity.SdtGAMApplication)AV77GXV1.elementAt(-1+AV78GXV2));
         cmbavApplicationid.addItem(GXutil.trim( GXutil.str( AV8Application.getgxTv_SdtGAMApplication_Id(), 12, 0)), AV8Application.getgxTv_SdtGAMApplication_Name(), (short)(0));
         AV78GXV2 = (int)(AV78GXV2+1) ;
      }
      if ( cmbavApplicationid.getItemCount() == 2 )
      {
         AV10ApplicationId = AV8Application.getgxTv_SdtGAMApplication_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      }
      else
      {
         AV10ApplicationId = AV26pApplicationId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      }
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
      Form.setCaption( httpContext.getMessage( "WWP_GAM_RolePermissions", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      AV16GAMRole.load(AV30RoleId);
      Form.setCaption( GXutil.format( httpContext.getMessage( "WWP_GAM_PermissionsOfRole", "")+AV16GAMRole.getgxTv_SdtGAMRole_Name(), "", "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void e18382( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext2[0] = AV40WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext2) ;
      AV40WWPContext = GXv_SdtWWPContext2[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      if ( AV62ManageFiltersExecutionStep == 1 )
      {
         AV62ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62ManageFiltersExecutionStep", GXutil.str( AV62ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV62ManageFiltersExecutionStep == 2 )
      {
         AV62ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62ManageFiltersExecutionStep", GXutil.str( AV62ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV69GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV69GridCurrentPage), 10, 0));
      GXt_char3 = AV72GridAppliedFilters ;
      GXv_char4[0] = GXt_char3 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV79Pgmname, GXv_char4) ;
      gamwwrolepermissions_impl.this.GXt_char3 = GXv_char4[0] ;
      AV72GridAppliedFilters = GXt_char3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72GridAppliedFilters", AV72GridAppliedFilters);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66ManageFiltersData", AV66ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43GridState", AV43GridState);
   }

   public void e12382( )
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
         AV25PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV25PageToGo) ;
      }
   }

   public void e13382( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e19382( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV34GridPageSize = subGrid_Rows ;
      AV16GAMRole.load(AV30RoleId);
      AV31RolePermissionFilter.setgxTv_SdtGAMPermissionFilter_Applicationid( AV10ApplicationId );
      AV31RolePermissionFilter.setgxTv_SdtGAMPermissionFilter_Name( "%"+AV15FilName );
      AV31RolePermissionFilter.setgxTv_SdtGAMPermissionFilter_Accesstype( AV28PermissionAccessType );
      if ( (GXutil.strcmp("", AV20IsInherited)==0) )
      {
         AV31RolePermissionFilter.setgxTv_SdtGAMPermissionFilter_Inherited( "A" );
      }
      else
      {
         AV31RolePermissionFilter.setgxTv_SdtGAMPermissionFilter_Inherited( AV20IsInherited );
      }
      AV17GridPageCount = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GridPageCount), 10, 0));
      AV35GridRecordCount = 0 ;
      if ( ! (0==AV10ApplicationId) )
      {
         GXv_objcol_SdtGAMError1[0] = AV14Errors ;
         AV33Permissions = AV16GAMRole.getpermissions(AV31RolePermissionFilter, GXv_objcol_SdtGAMError1) ;
         AV14Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV33Permissions.size() > 0 )
         {
            AV17GridPageCount = (long)((AV33Permissions.size()/ (double) (AV34GridPageSize))+((((int)((AV33Permissions.size()) % (AV34GridPageSize)))>0) ? 1 : 0)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GridPageCount), 10, 0));
         }
         AV35GridRecordCount = AV33Permissions.size() ;
         AV80GXV3 = 1 ;
         while ( AV80GXV3 <= AV33Permissions.size() )
         {
            AV27Permission = (genexus.security.api.genexussecurity.SdtGAMPermission)((genexus.security.api.genexussecurity.SdtGAMPermission)AV33Permissions.elementAt(-1+AV80GXV3));
            imgBtndlt_gximage = "ActionDelete" ;
            httpContext.ajax_rsp_assign_prop("", false, imgBtndlt_Internalname, "gximage", imgBtndlt_gximage, true);
            AV11BtnDlt = context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )) ;
            AV81Btndlt_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "7695fe89-52c9-4b7e-871e-0e11548f823e", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
            AV18Id = AV27Permission.getgxTv_SdtGAMPermission_Guid() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV18Id);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV18Id, ""))));
            AV22Name = AV27Permission.getgxTv_SdtGAMPermission_Name() ;
            httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV22Name);
            AV12Dsc = httpContext.getMessage( AV27Permission.getgxTv_SdtGAMPermission_Description(), "") ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDsc_Internalname, AV12Dsc);
            AV6AccessType = AV27Permission.getgxTv_SdtGAMPermission_Type() ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
            AV19Inherited = AV27Permission.getgxTv_SdtGAMPermission_Inherited() ;
            httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
            AV23old_AccessType = AV27Permission.getgxTv_SdtGAMPermission_Type() ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV23old_AccessType);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV23old_AccessType, ""))));
            AV24Old_Inherited = AV27Permission.getgxTv_SdtGAMPermission_Inherited() ;
            httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV24Old_Inherited);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, AV24Old_Inherited));
            AV5Delete = "<i class=\"fa fa-times\"></i>" ;
            httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(58) ;
            }
            if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
            {
               sendrow_582( ) ;
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
            if ( isFullAjaxMode( ) && ! bGXsfl_58_Refreshing )
            {
               httpContext.doAjaxLoad(58, GridRow);
            }
            AV80GXV3 = (int)(AV80GXV3+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV31RolePermissionFilter", AV31RolePermissionFilter);
      cmbavAccesstype.setValue( GXutil.rtrim( AV6AccessType) );
      cmbavOld_accesstype.setValue( GXutil.rtrim( AV23old_AccessType) );
   }

   public void e11382( )
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
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWRolePermissionsFilters")),GXutil.URLEncode(GXutil.rtrim(AV79Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV62ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62ManageFiltersExecutionStep", GXutil.str( AV62ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWRolePermissionsFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV62ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV62ManageFiltersExecutionStep", GXutil.str( AV62ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char3 = AV63ManageFiltersXml ;
         GXv_char4[0] = GXt_char3 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "GAMWWRolePermissionsFilters", Ddo_managefilters_Activeeventkey, GXv_char4) ;
         gamwwrolepermissions_impl.this.GXt_char3 = GXv_char4[0] ;
         AV63ManageFiltersXml = GXt_char3 ;
         if ( (GXutil.strcmp("", AV63ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S152 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV79Pgmname+"GridState", AV63ManageFiltersXml) ;
            AV43GridState.fromxml(AV63ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S162 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43GridState", AV43GridState);
      cmbavApplicationid.setValue( GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavApplicationid.getInternalname(), "Values", cmbavApplicationid.ToJavascriptSource(), true);
      cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV28PermissionAccessType) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
      cmbavIsinherited.setValue( GXutil.rtrim( AV20IsInherited) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavIsinherited.getInternalname(), "Values", cmbavIsinherited.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66ManageFiltersData", AV66ManageFiltersData);
   }

   public void e14382( )
   {
      /* 'DoBack' Routine */
      returnInSub = false ;
      if ( AV73IsAuthorized_Back )
      {
         callWebObject(formatLink("com.mujermorena.gamwwroles", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66ManageFiltersData", AV66ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43GridState", AV43GridState);
   }

   public void e15382( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( ! (0==AV10ApplicationId) )
      {
         if ( AV74IsAuthorized_Insert )
         {
            callWebObject(formatLink("com.mujermorena.gamrolepermissionselect", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV30RoleId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10ApplicationId,12,0))}, new String[] {"RoleId","ApplicationId"}) );
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
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66ManageFiltersData", AV66ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43GridState", AV43GridState);
   }

   public void e16382( )
   {
      /* 'DoSave' Routine */
      returnInSub = false ;
      AV16GAMRole.load(AV30RoleId);
      /* Start For Each Line */
      nRC_GXsfl_58 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_58"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      nGXsfl_58_fel_idx = 0 ;
      while ( nGXsfl_58_fel_idx < nRC_GXsfl_58 )
      {
         nGXsfl_58_fel_idx = ((subGrid_Islastpage==1)&&(nGXsfl_58_fel_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_58_fel_idx+1) ;
         sGXsfl_58_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_58_fel_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_fel_582( ) ;
         AV5Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
         cmbavOld_accesstype.setName( cmbavOld_accesstype.getInternalname() );
         cmbavOld_accesstype.setValue( httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) );
         AV23old_AccessType = httpContext.cgiGet( cmbavOld_accesstype.getInternalname()) ;
         AV24Old_Inherited = GXutil.strtobool( httpContext.cgiGet( chkavOld_inherited.getInternalname())) ;
         AV30RoleId = localUtil.ctol( httpContext.cgiGet( edtavRoleid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vAPPID");
            GX_FocusControl = edtavAppid_Internalname ;
            wbErr = true ;
            AV7AppId = 0 ;
         }
         else
         {
            AV7AppId = localUtil.ctol( httpContext.cgiGet( edtavAppid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         }
         AV22Name = httpContext.cgiGet( edtavName_Internalname) ;
         AV12Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         cmbavAccesstype.setName( cmbavAccesstype.getInternalname() );
         cmbavAccesstype.setValue( httpContext.cgiGet( cmbavAccesstype.getInternalname()) );
         AV6AccessType = httpContext.cgiGet( cmbavAccesstype.getInternalname()) ;
         AV19Inherited = GXutil.strtobool( httpContext.cgiGet( chkavInherited.getInternalname())) ;
         AV18Id = httpContext.cgiGet( edtavId_Internalname) ;
         if ( ( GXutil.strcmp(AV6AccessType, AV23old_AccessType) != 0 ) || ( AV19Inherited != AV24Old_Inherited ) )
         {
            AV29PermissionUpd.setgxTv_SdtGAMPermission_Applicationid( AV10ApplicationId );
            AV29PermissionUpd.setgxTv_SdtGAMPermission_Guid( AV18Id );
            AV29PermissionUpd.setgxTv_SdtGAMPermission_Type( AV6AccessType );
            AV29PermissionUpd.setgxTv_SdtGAMPermission_Inherited( AV19Inherited );
            GXv_objcol_SdtGAMError1[0] = AV14Errors ;
            AV21isOK = AV16GAMRole.updatepermission(AV29PermissionUpd, GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21isOK", AV21isOK);
            AV14Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( ! AV21isOK )
            {
               AV83GXV4 = 1 ;
               while ( AV83GXV4 <= AV14Errors.size() )
               {
                  AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV83GXV4));
                  httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
                  AV83GXV4 = (int)(AV83GXV4+1) ;
               }
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         /* End For Each Line */
      }
      if ( nGXsfl_58_fel_idx == 0 )
      {
         nGXsfl_58_idx = 1 ;
         sGXsfl_58_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_58_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_582( ) ;
      }
      nGXsfl_58_fel_idx = 1 ;
      if ( AV21isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwwrolepermissions");
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Changes saved successfully.", ""));
      }
      else
      {
         AV84GXV5 = 1 ;
         while ( AV84GXV5 <= AV14Errors.size() )
         {
            AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV84GXV5));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV84GXV5 = (int)(AV84GXV5+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV29PermissionUpd", AV29PermissionUpd);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean5 = AV73IsAuthorized_Back ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamwwroles_Execute", GXv_boolean6) ;
      gamwwrolepermissions_impl.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV73IsAuthorized_Back = GXt_boolean5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV73IsAuthorized_Back", AV73IsAuthorized_Back);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BACK", getSecureSignedToken( "", AV73IsAuthorized_Back));
      if ( ! ( AV73IsAuthorized_Back ) )
      {
         bttBtnback_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnback_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnback_Visible), 5, 0), true);
      }
      GXt_boolean5 = AV74IsAuthorized_Insert ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamrolepermissionselect_Execute", GXv_boolean6) ;
      gamwwrolepermissions_impl.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV74IsAuthorized_Insert = GXt_boolean5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74IsAuthorized_Insert", AV74IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV74IsAuthorized_Insert));
      if ( ! ( AV74IsAuthorized_Insert ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = AV66ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "GAMWWRolePermissionsFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] ;
      AV66ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   }

   public void S152( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV10ApplicationId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
      AV15FilName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15FilName", AV15FilName);
      AV28PermissionAccessType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionAccessType", AV28PermissionAccessType);
      AV20IsInherited = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20IsInherited", AV20IsInherited);
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV61Session.getValue(AV79Pgmname+"GridState"), "") == 0 )
      {
         AV43GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV79Pgmname+"GridState"), null, null);
      }
      else
      {
         AV43GridState.fromxml(AV61Session.getValue(AV79Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV43GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV43GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV43GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S162( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV85GXV6 = 1 ;
      while ( AV85GXV6 <= AV43GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV44GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV43GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV85GXV6));
         if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "APPLICATIONID") == 0 )
         {
            AV10ApplicationId = GXutil.lval( AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ApplicationId), 12, 0));
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILNAME") == 0 )
         {
            AV15FilName = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15FilName", AV15FilName);
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PERMISSIONACCESSTYPE") == 0 )
         {
            AV28PermissionAccessType = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionAccessType", AV28PermissionAccessType);
         }
         else if ( GXutil.strcmp(AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "ISINHERITED") == 0 )
         {
            AV20IsInherited = AV44GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20IsInherited", AV20IsInherited);
         }
         AV85GXV6 = (int)(AV85GXV6+1) ;
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV43GridState.fromxml(AV61Session.getValue(AV79Pgmname+"GridState"), null, null);
      AV43GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV43GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "APPLICATIONID", httpContext.getMessage( "WWP_GAM_Application", ""), !(0==AV10ApplicationId), (short)(0), GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)), "") ;
      AV43GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV43GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILNAME", httpContext.getMessage( "WWP_GAM_Name", ""), !(GXutil.strcmp("", AV15FilName)==0), (short)(0), AV15FilName, "") ;
      AV43GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV43GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "PERMISSIONACCESSTYPE", httpContext.getMessage( "WWP_GAM_Type", ""), !(GXutil.strcmp("", AV28PermissionAccessType)==0), (short)(0), AV28PermissionAccessType, "") ;
      AV43GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV43GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "ISINHERITED", httpContext.getMessage( "WWP_GAM_IsInherited", ""), !(GXutil.strcmp("", AV20IsInherited)==0), (short)(0), AV20IsInherited, "") ;
      AV43GridState = GXv_SdtWWPGridState9[0] ;
      AV43GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV43GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV79Pgmname+"GridState", AV43GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e20382( )
   {
      /* Delete_Click Routine */
      returnInSub = false ;
      AV16GAMRole.load(AV30RoleId);
      GXv_objcol_SdtGAMError1[0] = AV14Errors ;
      AV21isOK = AV16GAMRole.deletepermissionbyid(AV10ApplicationId, AV18Id, GXv_objcol_SdtGAMError1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21isOK", AV21isOK);
      AV14Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV21isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwwrolepermissions");
         httpContext.doAjaxRefresh();
      }
      else
      {
         AV86GXV7 = 1 ;
         while ( AV86GXV7 <= AV14Errors.size() )
         {
            AV13Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV14Errors.elementAt(-1+AV86GXV7));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV13Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV13Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV86GXV7 = (int)(AV86GXV7+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV66ManageFiltersData", AV66ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43GridState", AV43GridState);
   }

   public void wb_table1_24_382( boolean wbgen )
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
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV66ManageFiltersData);
         ucDdo_managefilters.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_managefilters_Internalname, "DDO_MANAGEFILTERSContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_29_382( true) ;
      }
      else
      {
         wb_table2_29_382( false) ;
      }
      return  ;
   }

   public void wb_table2_29_382e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_24_382e( true) ;
      }
      else
      {
         wb_table1_24_382e( false) ;
      }
   }

   public void wb_table2_29_382( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavApplicationid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavApplicationid.getInternalname(), httpContext.getMessage( "WWP_GAM_Application", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'" + sGXsfl_58_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavApplicationid, cmbavApplicationid.getInternalname(), GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)), 1, cmbavApplicationid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavApplicationid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "", true, (byte)(0), "HLP_GAMWWRolePermissions.htm");
         cmbavApplicationid.setValue( GXutil.trim( GXutil.str( AV10ApplicationId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavApplicationid.getInternalname(), "Values", cmbavApplicationid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+edtavFilname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFilname_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'" + sGXsfl_58_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFilname_Internalname, GXutil.rtrim( AV15FilName), GXutil.rtrim( localUtil.format( AV15FilName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFilname_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMWWRolePermissions.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'" + sGXsfl_58_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPermissionaccesstype, cmbavPermissionaccesstype.getInternalname(), GXutil.rtrim( AV28PermissionAccessType), 1, cmbavPermissionaccesstype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPermissionaccesstype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_GAMWWRolePermissions.htm");
         cmbavPermissionaccesstype.setValue( GXutil.rtrim( AV28PermissionAccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPermissionaccesstype.getInternalname(), "Values", cmbavPermissionaccesstype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellFormGroupMarginBottom5'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavIsinherited.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavIsinherited.getInternalname(), httpContext.getMessage( "WWP_GAM_IsInherited", ""), "gx-form-item AttributeLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_58_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavIsinherited, cmbavIsinherited.getInternalname(), GXutil.rtrim( AV20IsInherited), 1, cmbavIsinherited.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavIsinherited.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "", true, (byte)(0), "HLP_GAMWWRolePermissions.htm");
         cmbavIsinherited.setValue( GXutil.rtrim( AV20IsInherited) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIsinherited.getInternalname(), "Values", cmbavIsinherited.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_29_382e( true) ;
      }
      else
      {
         wb_table2_29_382e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV30RoleId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, edtavRoleid_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30RoleId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vROLEID"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9")));
      AV26pApplicationId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26pApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26pApplicationId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26pApplicationId), "ZZZZZZZZZZZ9")));
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
      pa382( ) ;
      ws382( ) ;
      we382( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211120227", true, true);
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
      httpContext.AddJavascriptSource("gamwwrolepermissions.js", "?202412111202219", false, true);
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

   public void subsflControlProps_582( )
   {
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_58_idx ;
      cmbavOld_accesstype.setInternalname( "vOLD_ACCESSTYPE_"+sGXsfl_58_idx );
      chkavOld_inherited.setInternalname( "vOLD_INHERITED_"+sGXsfl_58_idx );
      edtavRoleid_Internalname = "vROLEID_"+sGXsfl_58_idx ;
      edtavAppid_Internalname = "vAPPID_"+sGXsfl_58_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_58_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_58_idx ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE_"+sGXsfl_58_idx );
      chkavInherited.setInternalname( "vINHERITED_"+sGXsfl_58_idx );
      edtavId_Internalname = "vID_"+sGXsfl_58_idx ;
   }

   public void subsflControlProps_fel_582( )
   {
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_58_fel_idx ;
      cmbavOld_accesstype.setInternalname( "vOLD_ACCESSTYPE_"+sGXsfl_58_fel_idx );
      chkavOld_inherited.setInternalname( "vOLD_INHERITED_"+sGXsfl_58_fel_idx );
      edtavRoleid_Internalname = "vROLEID_"+sGXsfl_58_fel_idx ;
      edtavAppid_Internalname = "vAPPID_"+sGXsfl_58_fel_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_58_fel_idx ;
      edtavDsc_Internalname = "vDSC_"+sGXsfl_58_fel_idx ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE_"+sGXsfl_58_fel_idx );
      chkavInherited.setInternalname( "vINHERITED_"+sGXsfl_58_fel_idx );
      edtavId_Internalname = "vID_"+sGXsfl_58_fel_idx ;
   }

   public void sendrow_582( )
   {
      subsflControlProps_582( ) ;
      wb380( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_58_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_58_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_58_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 59,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV5Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,59);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDELETE.CLICK."+sGXsfl_58_idx+"'","","",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(58),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         TempTags = " " + ((cmbavOld_accesstype.getEnabled()!=0)&&(cmbavOld_accesstype.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 60,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         if ( ( cmbavOld_accesstype.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vOLD_ACCESSTYPE_" + sGXsfl_58_idx ;
            cmbavOld_accesstype.setName( GXCCtl );
            cmbavOld_accesstype.setWebtags( "" );
            cmbavOld_accesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
            cmbavOld_accesstype.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
            cmbavOld_accesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
            if ( cmbavOld_accesstype.getItemCount() > 0 )
            {
               AV23old_AccessType = cmbavOld_accesstype.getValidValue(AV23old_AccessType) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV23old_AccessType);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV23old_AccessType, ""))));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavOld_accesstype,cmbavOld_accesstype.getInternalname(),GXutil.rtrim( AV23old_AccessType),Integer.valueOf(1),cmbavOld_accesstype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(cmbavOld_accesstype.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavOld_accesstype.getEnabled()!=0)&&(cmbavOld_accesstype.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,60);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavOld_accesstype.setValue( GXutil.rtrim( AV23old_AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavOld_accesstype.getInternalname(), "Values", cmbavOld_accesstype.ToJavascriptSource(), !bGXsfl_58_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavOld_inherited.getEnabled()!=0)&&(chkavOld_inherited.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 61,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vOLD_INHERITED_" + sGXsfl_58_idx ;
         chkavOld_inherited.setName( GXCCtl );
         chkavOld_inherited.setWebtags( "" );
         chkavOld_inherited.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "TitleCaption", chkavOld_inherited.getCaption(), !bGXsfl_58_Refreshing);
         chkavOld_inherited.setCheckedValue( "false" );
         AV24Old_Inherited = GXutil.strtobool( GXutil.booltostr( AV24Old_Inherited)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV24Old_Inherited);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, AV24Old_Inherited));
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavOld_inherited.getInternalname(),GXutil.booltostr( AV24Old_Inherited),"","",Integer.valueOf(0),Integer.valueOf(chkavOld_inherited.getEnabled()),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(61, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavOld_inherited.getEnabled()!=0)&&(chkavOld_inherited.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,61);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavRoleid_Internalname,GXutil.ltrim( localUtil.ntoc( AV30RoleId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavRoleid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV30RoleId), "ZZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavRoleid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavRoleid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(58),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMKeyNumLong","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavAppid_Enabled!=0)&&(edtavAppid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 63,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavAppid_Internalname,GXutil.ltrim( localUtil.ntoc( AV7AppId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavAppid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV7AppId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV7AppId), "ZZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavAppid_Enabled!=0)&&(edtavAppid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,63);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavAppid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavAppid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(12),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(58),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMKeyNumLong","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 64,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavName_Internalname,GXutil.rtrim( AV22Name),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,64);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavName_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(120),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(58),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionMedium","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDsc_Enabled!=0)&&(edtavDsc_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 65,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDsc_Internalname,GXutil.rtrim( AV12Dsc),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDsc_Enabled!=0)&&(edtavDsc_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,65);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavDsc_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDsc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(58),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavAccesstype.getEnabled()!=0)&&(cmbavAccesstype.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 66,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         if ( ( cmbavAccesstype.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vACCESSTYPE_" + sGXsfl_58_idx ;
            cmbavAccesstype.setName( GXCCtl );
            cmbavAccesstype.setWebtags( "" );
            cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
            cmbavAccesstype.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
            cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
            if ( cmbavAccesstype.getItemCount() > 0 )
            {
               AV6AccessType = cmbavAccesstype.getValidValue(AV6AccessType) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavAccesstype,cmbavAccesstype.getInternalname(),GXutil.rtrim( AV6AccessType),Integer.valueOf(1),cmbavAccesstype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavAccesstype.getEnabled()!=0)&&(cmbavAccesstype.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,66);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavAccesstype.setValue( GXutil.rtrim( AV6AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Values", cmbavAccesstype.ToJavascriptSource(), !bGXsfl_58_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Check box */
         TempTags = " " + ((chkavInherited.getEnabled()!=0)&&(chkavInherited.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 67,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         GXCCtl = "vINHERITED_" + sGXsfl_58_idx ;
         chkavInherited.setName( GXCCtl );
         chkavInherited.setWebtags( "" );
         chkavInherited.setCaption( "" );
         httpContext.ajax_rsp_assign_prop("", false, chkavInherited.getInternalname(), "TitleCaption", chkavInherited.getCaption(), !bGXsfl_58_Refreshing);
         chkavInherited.setCheckedValue( "false" );
         AV19Inherited = GXutil.strtobool( GXutil.booltostr( AV19Inherited)) ;
         httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
         GridRow.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavInherited.getInternalname(),GXutil.booltostr( AV19Inherited),"","",Integer.valueOf(-1),Integer.valueOf(1),"true","",StyleString,ClassString,"WWColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(67, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavInherited.getEnabled()!=0)&&(chkavInherited.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,67);\"" : " ")});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 68,'',false,'"+sGXsfl_58_idx+"',58)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavId_Internalname,GXutil.rtrim( AV18Id),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,68);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavId_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(58),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes382( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_58_idx = ((subGrid_Islastpage==1)&&(nGXsfl_58_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_58_idx+1) ;
         sGXsfl_58_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_58_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_582( ) ;
      }
      /* End function sendrow_582 */
   }

   public void startgridcontrol58( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"58\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_OldAccessType", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidthCheckBox"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Boolean", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Key Numeric Long", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Key Numeric Long", "")) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_GUID", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV5Delete));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV23old_AccessType));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavOld_accesstype.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV24Old_Inherited));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkavOld_inherited.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV30RoleId, (byte)(12), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavRoleid_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV7AppId, (byte)(12), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavAppid_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV22Name));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavName_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12Dsc));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDsc_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV6AccessType));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.booltostr( AV19Inherited));
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
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      bttBtnback_Internalname = "BTNBACK" ;
      lblBtninsert_Internalname = "BTNINSERT" ;
      bttBtnsave_Internalname = "BTNSAVE" ;
      divTableactions_Internalname = "TABLEACTIONS" ;
      Ddo_managefilters_Internalname = "DDO_MANAGEFILTERS" ;
      cmbavApplicationid.setInternalname( "vAPPLICATIONID" );
      edtavFilname_Internalname = "vFILNAME" ;
      cmbavPermissionaccesstype.setInternalname( "vPERMISSIONACCESSTYPE" );
      cmbavIsinherited.setInternalname( "vISINHERITED" );
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDelete_Internalname = "vDELETE" ;
      cmbavOld_accesstype.setInternalname( "vOLD_ACCESSTYPE" );
      chkavOld_inherited.setInternalname( "vOLD_INHERITED" );
      edtavRoleid_Internalname = "vROLEID" ;
      edtavAppid_Internalname = "vAPPID" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE" );
      chkavInherited.setInternalname( "vINHERITED" );
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
      edtavAppid_Jsonclick = "" ;
      edtavAppid_Visible = 0 ;
      edtavAppid_Enabled = 1 ;
      edtavRoleid_Jsonclick = "" ;
      edtavRoleid_Enabled = 0 ;
      chkavOld_inherited.setCaption( "" );
      chkavOld_inherited.setVisible( 0 );
      chkavOld_inherited.setEnabled( 1 );
      cmbavOld_accesstype.setJsonclick( "" );
      cmbavOld_accesstype.setVisible( 0 );
      cmbavOld_accesstype.setEnabled( 1 );
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Visible = -1 ;
      edtavDelete_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      cmbavIsinherited.setJsonclick( "" );
      cmbavIsinherited.setEnabled( 1 );
      cmbavPermissionaccesstype.setJsonclick( "" );
      cmbavPermissionaccesstype.setEnabled( 1 );
      edtavFilname_Jsonclick = "" ;
      edtavFilname_Enabled = 1 ;
      cmbavApplicationid.setJsonclick( "" );
      cmbavApplicationid.setEnabled( 1 );
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
      Form.setCaption( httpContext.getMessage( "WWP_GAM_RolePermissions", "") );
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
      cmbavPermissionaccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
      cmbavPermissionaccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavPermissionaccesstype.getItemCount() > 0 )
      {
         AV28PermissionAccessType = cmbavPermissionaccesstype.getValidValue(AV28PermissionAccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PermissionAccessType", AV28PermissionAccessType);
      }
      cmbavIsinherited.setName( "vISINHERITED" );
      cmbavIsinherited.setWebtags( "" );
      cmbavIsinherited.addItem("", httpContext.getMessage( "WWP_GAM_All", ""), (short)(0));
      cmbavIsinherited.addItem("T", httpContext.getMessage( "WWP_GAM_Yes", ""), (short)(0));
      cmbavIsinherited.addItem("F", httpContext.getMessage( "WWP_GAM_No", ""), (short)(0));
      if ( cmbavIsinherited.getItemCount() > 0 )
      {
         AV20IsInherited = cmbavIsinherited.getValidValue(AV20IsInherited) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20IsInherited", AV20IsInherited);
      }
      GXCCtl = "vOLD_ACCESSTYPE_" + sGXsfl_58_idx ;
      cmbavOld_accesstype.setName( GXCCtl );
      cmbavOld_accesstype.setWebtags( "" );
      cmbavOld_accesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavOld_accesstype.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
      cmbavOld_accesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavOld_accesstype.getItemCount() > 0 )
      {
         AV23old_AccessType = cmbavOld_accesstype.getValidValue(AV23old_AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavOld_accesstype.getInternalname(), AV23old_AccessType);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_ACCESSTYPE"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, GXutil.rtrim( localUtil.format( AV23old_AccessType, ""))));
      }
      GXCCtl = "vOLD_INHERITED_" + sGXsfl_58_idx ;
      chkavOld_inherited.setName( GXCCtl );
      chkavOld_inherited.setWebtags( "" );
      chkavOld_inherited.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavOld_inherited.getInternalname(), "TitleCaption", chkavOld_inherited.getCaption(), !bGXsfl_58_Refreshing);
      chkavOld_inherited.setCheckedValue( "false" );
      AV24Old_Inherited = GXutil.strtobool( GXutil.booltostr( AV24Old_Inherited)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavOld_inherited.getInternalname(), AV24Old_Inherited);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOLD_INHERITED"+"_"+sGXsfl_58_idx, getSecureSignedToken( sGXsfl_58_idx, AV24Old_Inherited));
      GXCCtl = "vACCESSTYPE_" + sGXsfl_58_idx ;
      cmbavAccesstype.setName( GXCCtl );
      cmbavAccesstype.setWebtags( "" );
      cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavAccesstype.addItem("D", httpContext.getMessage( "WWP_GAM_Deny", ""), (short)(0));
      cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavAccesstype.getItemCount() > 0 )
      {
         AV6AccessType = cmbavAccesstype.getValidValue(AV6AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavAccesstype.getInternalname(), AV6AccessType);
      }
      GXCCtl = "vINHERITED_" + sGXsfl_58_idx ;
      chkavInherited.setName( GXCCtl );
      chkavInherited.setWebtags( "" );
      chkavInherited.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavInherited.getInternalname(), "TitleCaption", chkavInherited.getCaption(), !bGXsfl_58_Refreshing);
      chkavInherited.setCheckedValue( "false" );
      AV19Inherited = GXutil.strtobool( GXutil.booltostr( AV19Inherited)) ;
      httpContext.ajax_rsp_assign_attri("", false, chkavInherited.getInternalname(), AV19Inherited);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV69GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV66ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV43GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e12382',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e13382',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e19382',iparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV17GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV18Id',fld:'vID',pic:'',hsh:true},{av:'AV22Name',fld:'vNAME',pic:''},{av:'AV12Dsc',fld:'vDSC',pic:''},{av:'cmbavAccesstype'},{av:'AV6AccessType',fld:'vACCESSTYPE',pic:''},{av:'AV19Inherited',fld:'vINHERITED',pic:''},{av:'cmbavOld_accesstype'},{av:'AV23old_AccessType',fld:'vOLD_ACCESSTYPE',pic:'',hsh:true},{av:'AV24Old_Inherited',fld:'vOLD_INHERITED',pic:'',hsh:true},{av:'AV5Delete',fld:'vDELETE',pic:''}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e11382',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV43GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV43GridState',fld:'vGRIDSTATE',pic:''},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV69GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV66ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOBACK'","{handler:'e14382',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOBACK'",",oparms:[{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV69GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV66ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV43GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e15382',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV69GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV66ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV43GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("'DOSAVE'","{handler:'e16382',iparms:[{av:'AV30RoleId',fld:'vROLEID',grid:58,pic:'ZZZZZZZZZZZ9',hsh:true},{av:'GRID_nFirstRecordOnPage'},{av:'nRC_GXsfl_58',ctrl:'GRID',grid:58,prop:'GridRC',grid:58},{av:'AV6AccessType',fld:'vACCESSTYPE',grid:58,pic:''},{av:'AV23old_AccessType',fld:'vOLD_ACCESSTYPE',grid:58,pic:'',hsh:true},{av:'AV19Inherited',fld:'vINHERITED',grid:58,pic:''},{av:'AV24Old_Inherited',fld:'vOLD_INHERITED',grid:58,pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV18Id',fld:'vID',grid:58,pic:'',hsh:true},{av:'AV21isOK',fld:'vISOK',pic:''}]");
      setEventMetadata("'DOSAVE'",",oparms:[{av:'AV21isOK',fld:'vISOK',pic:''}]}");
      setEventMetadata("VDELETE.CLICK","{handler:'e20382',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV79Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavApplicationid'},{av:'AV10ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15FilName',fld:'vFILNAME',pic:''},{av:'cmbavPermissionaccesstype'},{av:'AV28PermissionAccessType',fld:'vPERMISSIONACCESSTYPE',pic:''},{av:'cmbavIsinherited'},{av:'AV20IsInherited',fld:'vISINHERITED',pic:''},{av:'AV30RoleId',fld:'vROLEID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'AV26pApplicationId',fld:'vPAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV18Id',fld:'vID',pic:'',hsh:true}]");
      setEventMetadata("VDELETE.CLICK",",oparms:[{av:'AV21isOK',fld:'vISOK',pic:''},{av:'AV62ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV69GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV72GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV73IsAuthorized_Back',fld:'vISAUTHORIZED_BACK',pic:'',hsh:true},{ctrl:'BTNBACK',prop:'Visible'},{av:'AV74IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV66ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV43GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VALIDV_PERMISSIONACCESSTYPE","{handler:'validv_Permissionaccesstype',iparms:[]");
      setEventMetadata("VALIDV_PERMISSIONACCESSTYPE",",oparms:[]}");
      setEventMetadata("VALIDV_OLD_ACCESSTYPE","{handler:'validv_Old_accesstype',iparms:[]");
      setEventMetadata("VALIDV_OLD_ACCESSTYPE",",oparms:[]}");
      setEventMetadata("VALIDV_ACCESSTYPE","{handler:'validv_Accesstype',iparms:[]");
      setEventMetadata("VALIDV_ACCESSTYPE",",oparms:[]}");
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
      return "gamwwrolepermissions_Execute";
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
      AV15FilName = "" ;
      AV28PermissionAccessType = "" ;
      AV20IsInherited = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV66ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV72GridAppliedFilters = "" ;
      AV43GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
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
      AV5Delete = "" ;
      AV23old_AccessType = "" ;
      AV22Name = "" ;
      AV12Dsc = "" ;
      AV6AccessType = "" ;
      AV18Id = "" ;
      AV77GXV1 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplication>(genexus.security.api.genexussecurity.SdtGAMApplication.class, "GAMApplication", "http://tempuri.org/", remoteHandle);
      AV9ApplicationFilter = new genexus.security.api.genexussecurity.SdtGAMApplicationFilter(remoteHandle, context);
      AV14Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV8Application = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV39HTTPRequest = httpContext.getHttpRequest();
      AV16GAMRole = new genexus.security.api.genexussecurity.SdtGAMRole(remoteHandle, context);
      AV40WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext2 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV31RolePermissionFilter = new genexus.security.api.genexussecurity.SdtGAMPermissionFilter(remoteHandle, context);
      AV33Permissions = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMPermission>(genexus.security.api.genexussecurity.SdtGAMPermission.class, "GAMPermission", "http://tempuri.org/", remoteHandle);
      AV27Permission = new genexus.security.api.genexussecurity.SdtGAMPermission(remoteHandle, context);
      AV11BtnDlt = "" ;
      imgBtndlt_gximage = "" ;
      imgBtndlt_Internalname = "" ;
      AV81Btndlt_GXI = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV63ManageFiltersXml = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      AV29PermissionUpd = new genexus.security.api.genexussecurity.SdtGAMPermission(remoteHandle, context);
      AV13Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_boolean6 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection[1] ;
      AV61Session = httpContext.getWebSession();
      AV44GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
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
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwrolepermissions__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwrolepermissions__default(),
         new Object[] {
         }
      );
      AV79Pgmname = "GAMWWRolePermissions" ;
      /* GeneXus formulas. */
      AV79Pgmname = "GAMWWRolePermissions" ;
      Gx_err = (short)(0) ;
      edtavDelete_Enabled = 0 ;
      cmbavOld_accesstype.setEnabled( 0 );
      chkavOld_inherited.setEnabled( 0 );
      edtavRoleid_Enabled = 0 ;
      edtavAppid_Enabled = 0 ;
      edtavName_Enabled = 0 ;
      edtavDsc_Enabled = 0 ;
      edtavId_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV62ManageFiltersExecutionStep ;
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
   private int nRC_GXsfl_58 ;
   private int nGXsfl_58_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int bttBtnback_Visible ;
   private int lblBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDelete_Enabled ;
   private int edtavRoleid_Enabled ;
   private int edtavAppid_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavId_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV78GXV2 ;
   private int AV25PageToGo ;
   private int AV80GXV3 ;
   private int nGXsfl_58_fel_idx=1 ;
   private int AV83GXV4 ;
   private int AV84GXV5 ;
   private int AV85GXV6 ;
   private int AV86GXV7 ;
   private int edtavFilname_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavDelete_Visible ;
   private int edtavAppid_Visible ;
   private int edtavName_Visible ;
   private int edtavDsc_Visible ;
   private int edtavId_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long wcpOAV30RoleId ;
   private long wcpOAV26pApplicationId ;
   private long GRID_nFirstRecordOnPage ;
   private long AV30RoleId ;
   private long AV26pApplicationId ;
   private long AV10ApplicationId ;
   private long AV69GridCurrentPage ;
   private long AV17GridPageCount ;
   private long AV7AppId ;
   private long GRID_nCurrentRecord ;
   private long AV34GridPageSize ;
   private long AV35GridRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String edtavRoleid_Internalname ;
   private String sGXsfl_58_idx="0001" ;
   private String AV79Pgmname ;
   private String AV15FilName ;
   private String AV28PermissionAccessType ;
   private String AV20IsInherited ;
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
   private String AV5Delete ;
   private String edtavDelete_Internalname ;
   private String AV23old_AccessType ;
   private String edtavAppid_Internalname ;
   private String AV22Name ;
   private String edtavName_Internalname ;
   private String AV12Dsc ;
   private String edtavDsc_Internalname ;
   private String AV6AccessType ;
   private String AV18Id ;
   private String edtavId_Internalname ;
   private String edtavFilname_Internalname ;
   private String imgBtndlt_gximage ;
   private String imgBtndlt_Internalname ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String sGXsfl_58_fel_idx="0001" ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilname_Jsonclick ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDelete_Jsonclick ;
   private String GXCCtl ;
   private String edtavRoleid_Jsonclick ;
   private String edtavAppid_Jsonclick ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Jsonclick ;
   private String edtavId_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV73IsAuthorized_Back ;
   private boolean AV74IsAuthorized_Insert ;
   private boolean AV21isOK ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean AV24Old_Inherited ;
   private boolean AV19Inherited ;
   private boolean bGXsfl_58_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private String AV63ManageFiltersXml ;
   private String AV72GridAppliedFilters ;
   private String AV81Btndlt_GXI ;
   private String AV11BtnDlt ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV39HTTPRequest ;
   private com.genexus.webpanels.WebSession AV61Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private genexus.security.api.genexussecurity.SdtGAMPermission AV29PermissionUpd ;
   private genexus.security.api.genexussecurity.SdtGAMPermissionFilter AV31RolePermissionFilter ;
   private HTMLChoice cmbavApplicationid ;
   private HTMLChoice cmbavPermissionaccesstype ;
   private HTMLChoice cmbavIsinherited ;
   private HTMLChoice cmbavOld_accesstype ;
   private ICheckbox chkavOld_inherited ;
   private HTMLChoice cmbavAccesstype ;
   private ICheckbox chkavInherited ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplication> AV77GXV1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV14Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMPermission> AV33Permissions ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV66ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[] ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV8Application ;
   private genexus.security.api.genexussecurity.SdtGAMError AV13Error ;
   private genexus.security.api.genexussecurity.SdtGAMRole AV16GAMRole ;
   private genexus.security.api.genexussecurity.SdtGAMPermission AV27Permission ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationFilter AV9ApplicationFilter ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV40WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV43GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV44GridStateFilterValue ;
}

final  class gamwwrolepermissions__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwwrolepermissions__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

