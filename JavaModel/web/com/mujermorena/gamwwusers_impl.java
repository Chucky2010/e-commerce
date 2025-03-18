package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwwusers_impl extends GXDataArea
{
   public gamwwusers_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwwusers_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwwusers_impl.class ));
   }

   public gamwwusers_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavFilusergender = new HTMLChoice();
      cmbavFilauttype = new HTMLChoice();
      cmbavFilrol = new HTMLChoice();
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
      nRC_GXsfl_54 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_54"))) ;
      nGXsfl_54_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_54_idx"))) ;
      sGXsfl_54_idx = httpContext.GetPar( "sGXsfl_54_idx") ;
      edtavBtnrole_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnrole_Internalname, "Title", edtavBtnrole_Title, !bGXsfl_54_Refreshing);
      edtavBtnsetpwd_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsetpwd_Internalname, "Title", edtavBtnsetpwd_Title, !bGXsfl_54_Refreshing);
      edtavBtnpermissions_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnpermissions_Internalname, "Title", edtavBtnpermissions_Title, !bGXsfl_54_Refreshing);
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
      AV76ManageFiltersExecutionStep = (byte)(GXutil.lval( httpContext.GetPar( "ManageFiltersExecutionStep"))) ;
      AV100Pgmname = httpContext.GetPar( "Pgmname") ;
      cmbavFilusergender.fromJSonString( httpContext.GetNextPar( ));
      AV21FilUserGender = httpContext.GetPar( "FilUserGender") ;
      cmbavFilauttype.fromJSonString( httpContext.GetNextPar( ));
      AV18FilAutType = httpContext.GetPar( "FilAutType") ;
      AV40Search = httpContext.GetPar( "Search") ;
      cmbavFilrol.fromJSonString( httpContext.GetNextPar( ));
      AV41FilRol = GXutil.lval( httpContext.GetPar( "FilRol")) ;
      edtavBtnrole_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnrole_Internalname, "Title", edtavBtnrole_Title, !bGXsfl_54_Refreshing);
      edtavBtnsetpwd_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsetpwd_Internalname, "Title", edtavBtnsetpwd_Title, !bGXsfl_54_Refreshing);
      edtavBtnpermissions_Title = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnpermissions_Internalname, "Title", edtavBtnpermissions_Title, !bGXsfl_54_Refreshing);
      AV83FirstIndex = (short)(GXutil.lval( httpContext.GetPar( "FirstIndex"))) ;
      AV88IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV89IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV90IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV24GAMUserIsDeleted = GXutil.strtobool( httpContext.GetPar( "GAMUserIsDeleted")) ;
      AV30IsAuthorized_BtnRole = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_BtnRole")) ;
      AV91IsAuthorized_BtnPermissions = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_BtnPermissions")) ;
      AV31IsAuthorized_BtnSetPwd = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_BtnSetPwd")) ;
      AV23GAMUserIsAutoRegisteredUser = GXutil.strtobool( httpContext.GetPar( "GAMUserIsAutoRegisteredUser")) ;
      AV44IsAuthorized_Name = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Name")) ;
      AV92IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV100Pgmname, AV21FilUserGender, AV18FilAutType, AV40Search, AV41FilRol, AV83FirstIndex, AV88IsAuthorized_Display, AV89IsAuthorized_Update, AV90IsAuthorized_Delete, AV24GAMUserIsDeleted, AV30IsAuthorized_BtnRole, AV91IsAuthorized_BtnPermissions, AV31IsAuthorized_BtnSetPwd, AV23GAMUserIsAutoRegisteredUser, AV44IsAuthorized_Name, AV92IsAuthorized_Insert) ;
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
      pa1S2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1S2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwwusers", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFIRSTINDEX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV83FirstIndex), "ZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV88IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV89IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV90IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMUSERISDELETED", getSecureSignedToken( "", AV24GAMUserIsDeleted));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNROLE", getSecureSignedToken( "", AV30IsAuthorized_BtnRole));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNPERMISSIONS", getSecureSignedToken( "", AV91IsAuthorized_BtnPermissions));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNSETPWD", getSecureSignedToken( "", AV31IsAuthorized_BtnSetPwd));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMUSERISAUTOREGISTEREDUSER", getSecureSignedToken( "", AV23GAMUserIsAutoRegisteredUser));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV44IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV92IsAuthorized_Insert));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_54", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_54, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMANAGEFILTERSDATA", AV80ManageFiltersData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMANAGEFILTERSDATA", AV80ManageFiltersData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV26GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV27GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV85GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMANAGEFILTERSEXECUTIONSTEP", GXutil.ltrim( localUtil.ntoc( AV76ManageFiltersExecutionStep, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vFIRSTINDEX", GXutil.ltrim( localUtil.ntoc( AV83FirstIndex, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFIRSTINDEX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV83FirstIndex), "ZZZ9")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV88IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV88IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV89IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV89IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV90IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV90IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vGAMUSERISDELETED", AV24GAMUserIsDeleted);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMUSERISDELETED", getSecureSignedToken( "", AV24GAMUserIsDeleted));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNROLE", AV30IsAuthorized_BtnRole);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNROLE", getSecureSignedToken( "", AV30IsAuthorized_BtnRole));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNPERMISSIONS", AV91IsAuthorized_BtnPermissions);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNPERMISSIONS", getSecureSignedToken( "", AV91IsAuthorized_BtnPermissions));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNSETPWD", AV31IsAuthorized_BtnSetPwd);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNSETPWD", getSecureSignedToken( "", AV31IsAuthorized_BtnSetPwd));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vGAMUSERISAUTOREGISTEREDUSER", AV23GAMUserIsAutoRegisteredUser);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMUSERISAUTOREGISTEREDUSER", getSecureSignedToken( "", AV23GAMUserIsAutoRegisteredUser));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV44IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV44IsAuthorized_Name));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vGRIDSTATE", AV53GridState);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vGRIDSTATE", AV53GridState);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV92IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV92IsAuthorized_Insert));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vBTNROLE_Title", GXutil.rtrim( edtavBtnrole_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vBTNSETPWD_Title", GXutil.rtrim( edtavBtnsetpwd_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vBTNPERMISSIONS_Title", GXutil.rtrim( edtavBtnpermissions_Title));
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
         we1S2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1S2( ) ;
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
      return formatLink("com.mujermorena.gamwwusers", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "GAMWWUsers" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_Users", "") ;
   }

   public void wb1S0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingBottom", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableactions_Internalname, 1, 0, "px", 0, "px", "TableCellsWidthAuto", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWWUsers.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_GAMWWUsers.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-8", "Right", "top", "", "", "div");
         wb_table1_23_1S2( true) ;
      }
      else
      {
         wb_table1_23_1S2( false) ;
      }
      return  ;
   }

   public void wb_table1_23_1S2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         startgridcontrol54( ) ;
      }
      if ( wbEnd == 54 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_54 = (int)(nGXsfl_54_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV26GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV27GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV85GridAppliedFilters);
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
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'" + sGXsfl_54_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamuserscount_Internalname, GXutil.ltrim( localUtil.ntoc( AV39GAMUsersCount, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV39GAMUsersCount), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamuserscount_Jsonclick, 0, "Attribute", "", "", "", "", edtavGamuserscount_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMWWUsers.htm");
         /* User Defined Control */
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 54 )
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

   public void start1S2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_Users", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1S0( ) ;
   }

   public void ws1S2( )
   {
      start1S2( ) ;
      evt1S2( ) ;
   }

   public void evt1S2( )
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
                           e111S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e131S2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e141S2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "VBTNUNBLOCKOTPCODES.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 25), "VBTNUNBLOCKOTPCODES.CLICK") == 0 ) )
                        {
                           nGXsfl_54_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_54_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_54_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_542( ) ;
                           AV86Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV86Display);
                           AV87Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV87Update);
                           AV5Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
                           AV12BtnRole = httpContext.cgiGet( edtavBtnrole_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtnrole_Internalname, AV12BtnRole);
                           AV14BtnPermissions = httpContext.cgiGet( edtavBtnpermissions_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtnpermissions_Internalname, AV14BtnPermissions);
                           AV13BtnSetPwd = httpContext.cgiGet( edtavBtnsetpwd_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtnsetpwd_Internalname, AV13BtnSetPwd);
                           AV94BtnUnblockOTPCodes = httpContext.cgiGet( edtavBtnunblockotpcodes_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavBtnunblockotpcodes_Internalname, AV94BtnUnblockOTPCodes);
                           AV34Name = httpContext.cgiGet( edtavName_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV34Name);
                           AV22FirstName = httpContext.cgiGet( edtavFirstname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavFirstname_Internalname, AV22FirstName);
                           AV33LastName = httpContext.cgiGet( edtavLastname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavLastname_Internalname, AV33LastName);
                           AV9AuthenticationTypeName = httpContext.cgiGet( edtavAuthenticationtypename_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavAuthenticationtypename_Internalname, AV9AuthenticationTypeName);
                           AV28GUID = httpContext.cgiGet( edtavGuid_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavGuid_Internalname, AV28GUID);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGUID"+"_"+sGXsfl_54_idx, getSecureSignedToken( sGXsfl_54_idx, GXutil.rtrim( localUtil.format( AV28GUID, ""))));
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e151S2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e161S2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e171S2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VBTNUNBLOCKOTPCODES.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e181S2 ();
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

   public void we1S2( )
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

   public void pa1S2( )
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
            GX_FocusControl = edtavSearch_Internalname ;
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
      subsflControlProps_542( ) ;
      while ( nGXsfl_54_idx <= nRC_GXsfl_54 )
      {
         sendrow_542( ) ;
         nGXsfl_54_idx = ((subGrid_Islastpage==1)&&(nGXsfl_54_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_54_idx+1) ;
         sGXsfl_54_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_54_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_542( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 byte AV76ManageFiltersExecutionStep ,
                                 String AV100Pgmname ,
                                 String AV21FilUserGender ,
                                 String AV18FilAutType ,
                                 String AV40Search ,
                                 long AV41FilRol ,
                                 short AV83FirstIndex ,
                                 boolean AV88IsAuthorized_Display ,
                                 boolean AV89IsAuthorized_Update ,
                                 boolean AV90IsAuthorized_Delete ,
                                 boolean AV24GAMUserIsDeleted ,
                                 boolean AV30IsAuthorized_BtnRole ,
                                 boolean AV91IsAuthorized_BtnPermissions ,
                                 boolean AV31IsAuthorized_BtnSetPwd ,
                                 boolean AV23GAMUserIsAutoRegisteredUser ,
                                 boolean AV44IsAuthorized_Name ,
                                 boolean AV92IsAuthorized_Insert )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e161S2 ();
      GRID_nCurrentRecord = 0 ;
      rf1S2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGUID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV28GUID, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGUID", GXutil.rtrim( AV28GUID));
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
      if ( cmbavFilusergender.getItemCount() > 0 )
      {
         AV21FilUserGender = cmbavFilusergender.getValidValue(AV21FilUserGender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21FilUserGender", AV21FilUserGender);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFilusergender.setValue( GXutil.rtrim( AV21FilUserGender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFilusergender.getInternalname(), "Values", cmbavFilusergender.ToJavascriptSource(), true);
      }
      if ( cmbavFilauttype.getItemCount() > 0 )
      {
         AV18FilAutType = cmbavFilauttype.getValidValue(AV18FilAutType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18FilAutType", AV18FilAutType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFilauttype.setValue( GXutil.rtrim( AV18FilAutType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFilauttype.getInternalname(), "Values", cmbavFilauttype.ToJavascriptSource(), true);
      }
      if ( cmbavFilrol.getItemCount() > 0 )
      {
         AV41FilRol = GXutil.lval( cmbavFilrol.getValidValue(GXutil.trim( GXutil.str( AV41FilRol, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41FilRol", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41FilRol), 12, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFilrol.setValue( GXutil.trim( GXutil.str( AV41FilRol, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFilrol.getInternalname(), "Values", cmbavFilrol.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1S2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV100Pgmname = "GAMWWUsers" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnrole_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnrole_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnrole_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnpermissions_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnpermissions_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnpermissions_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnsetpwd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsetpwd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnsetpwd_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnunblockotpcodes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnunblockotpcodes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnunblockotpcodes_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavFirstname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFirstname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFirstname_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavLastname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLastname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLastname_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavAuthenticationtypename_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAuthenticationtypename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthenticationtypename_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), !bGXsfl_54_Refreshing);
   }

   public void rf1S2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(54) ;
      /* Execute user event: Refresh */
      e161S2 ();
      nGXsfl_54_idx = 1 ;
      sGXsfl_54_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_54_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_542( ) ;
      bGXsfl_54_Refreshing = true ;
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
         subsflControlProps_542( ) ;
         e171S2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_54_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e171S2 ();
         }
         wbEnd = (short)(54) ;
         wb1S0( ) ;
      }
      bGXsfl_54_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1S2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV100Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV100Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vFIRSTINDEX", GXutil.ltrim( localUtil.ntoc( AV83FirstIndex, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFIRSTINDEX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV83FirstIndex), "ZZZ9")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV88IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV88IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV89IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV89IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV90IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV90IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vGAMUSERISDELETED", AV24GAMUserIsDeleted);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMUSERISDELETED", getSecureSignedToken( "", AV24GAMUserIsDeleted));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNROLE", AV30IsAuthorized_BtnRole);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNROLE", getSecureSignedToken( "", AV30IsAuthorized_BtnRole));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNPERMISSIONS", AV91IsAuthorized_BtnPermissions);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNPERMISSIONS", getSecureSignedToken( "", AV91IsAuthorized_BtnPermissions));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_BTNSETPWD", AV31IsAuthorized_BtnSetPwd);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNSETPWD", getSecureSignedToken( "", AV31IsAuthorized_BtnSetPwd));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vGAMUSERISAUTOREGISTEREDUSER", AV23GAMUserIsAutoRegisteredUser);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGAMUSERISAUTOREGISTEREDUSER", getSecureSignedToken( "", AV23GAMUserIsAutoRegisteredUser));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_NAME", AV44IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV44IsAuthorized_Name));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV92IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV92IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGUID"+"_"+sGXsfl_54_idx, getSecureSignedToken( sGXsfl_54_idx, GXutil.rtrim( localUtil.format( AV28GUID, ""))));
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV100Pgmname, AV21FilUserGender, AV18FilAutType, AV40Search, AV41FilRol, AV83FirstIndex, AV88IsAuthorized_Display, AV89IsAuthorized_Update, AV90IsAuthorized_Delete, AV24GAMUserIsDeleted, AV30IsAuthorized_BtnRole, AV91IsAuthorized_BtnPermissions, AV31IsAuthorized_BtnSetPwd, AV23GAMUserIsAutoRegisteredUser, AV44IsAuthorized_Name, AV92IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV100Pgmname, AV21FilUserGender, AV18FilAutType, AV40Search, AV41FilRol, AV83FirstIndex, AV88IsAuthorized_Display, AV89IsAuthorized_Update, AV90IsAuthorized_Delete, AV24GAMUserIsDeleted, AV30IsAuthorized_BtnRole, AV91IsAuthorized_BtnPermissions, AV31IsAuthorized_BtnSetPwd, AV23GAMUserIsAutoRegisteredUser, AV44IsAuthorized_Name, AV92IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV100Pgmname, AV21FilUserGender, AV18FilAutType, AV40Search, AV41FilRol, AV83FirstIndex, AV88IsAuthorized_Display, AV89IsAuthorized_Update, AV90IsAuthorized_Delete, AV24GAMUserIsDeleted, AV30IsAuthorized_BtnRole, AV91IsAuthorized_BtnPermissions, AV31IsAuthorized_BtnSetPwd, AV23GAMUserIsAutoRegisteredUser, AV44IsAuthorized_Name, AV92IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV100Pgmname, AV21FilUserGender, AV18FilAutType, AV40Search, AV41FilRol, AV83FirstIndex, AV88IsAuthorized_Display, AV89IsAuthorized_Update, AV90IsAuthorized_Delete, AV24GAMUserIsDeleted, AV30IsAuthorized_BtnRole, AV91IsAuthorized_BtnPermissions, AV31IsAuthorized_BtnSetPwd, AV23GAMUserIsAutoRegisteredUser, AV44IsAuthorized_Name, AV92IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV76ManageFiltersExecutionStep, AV100Pgmname, AV21FilUserGender, AV18FilAutType, AV40Search, AV41FilRol, AV83FirstIndex, AV88IsAuthorized_Display, AV89IsAuthorized_Update, AV90IsAuthorized_Delete, AV24GAMUserIsDeleted, AV30IsAuthorized_BtnRole, AV91IsAuthorized_BtnPermissions, AV31IsAuthorized_BtnSetPwd, AV23GAMUserIsAutoRegisteredUser, AV44IsAuthorized_Name, AV92IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV100Pgmname = "GAMWWUsers" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnrole_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnrole_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnrole_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnpermissions_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnpermissions_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnpermissions_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnsetpwd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsetpwd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnsetpwd_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavBtnunblockotpcodes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnunblockotpcodes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnunblockotpcodes_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavFirstname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFirstname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFirstname_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavLastname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLastname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLastname_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavAuthenticationtypename_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAuthenticationtypename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthenticationtypename_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), !bGXsfl_54_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1S0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e151S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMANAGEFILTERSDATA"), AV80ManageFiltersData);
         /* Read saved values. */
         nRC_GXsfl_54 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_54"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV26GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV27GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV85GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         AV40Search = httpContext.cgiGet( edtavSearch_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40Search", AV40Search);
         cmbavFilusergender.setName( cmbavFilusergender.getInternalname() );
         cmbavFilusergender.setValue( httpContext.cgiGet( cmbavFilusergender.getInternalname()) );
         AV21FilUserGender = httpContext.cgiGet( cmbavFilusergender.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21FilUserGender", AV21FilUserGender);
         cmbavFilauttype.setName( cmbavFilauttype.getInternalname() );
         cmbavFilauttype.setValue( httpContext.cgiGet( cmbavFilauttype.getInternalname()) );
         AV18FilAutType = httpContext.cgiGet( cmbavFilauttype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18FilAutType", AV18FilAutType);
         cmbavFilrol.setName( cmbavFilrol.getInternalname() );
         cmbavFilrol.setValue( httpContext.cgiGet( cmbavFilrol.getInternalname()) );
         AV41FilRol = GXutil.lval( httpContext.cgiGet( cmbavFilrol.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41FilRol", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41FilRol), 12, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGamuserscount_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGamuserscount_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGAMUSERSCOUNT");
            GX_FocusControl = edtavGamuserscount_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV39GAMUsersCount = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39GAMUsersCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GAMUsersCount), 4, 0));
         }
         else
         {
            AV39GAMUsersCount = (short)(localUtil.ctol( httpContext.cgiGet( edtavGamuserscount_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39GAMUsersCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39GAMUsersCount), 4, 0));
         }
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
      e151S2 ();
      if (returnInSub) return;
   }

   public void e151S2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Gridpaginationbar_Caption = httpContext.getMessage( "WWP_GAM_WWUsers_PagingCaption", "") ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "Caption", Gridpaginationbar_Caption);
      Gridpaginationbar_Pagestoshow = 0 ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "PagesToShow", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Pagestoshow), 9, 0));
      Gridpaginationbar_Showlast = false ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "ShowLast", GXutil.booltostr( Gridpaginationbar_Showlast));
      edtavGamuserscount_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamuserscount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamuserscount_Visible), 5, 0), true);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      if ( GXutil.strcmp(AV49HTTPRequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      lblBtninsert_Caption = GXutil.format( "<i class='fas fa-plus' title='%1'></i>", httpContext.getMessage( "GXM_insert", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Caption", lblBtninsert_Caption, true);
      GXt_boolean1 = AV44IsAuthorized_Name ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamuserentry_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV44IsAuthorized_Name = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44IsAuthorized_Name", AV44IsAuthorized_Name);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_NAME", getSecureSignedToken( "", AV44IsAuthorized_Name));
      Form.setCaption( httpContext.getMessage( "WWP_GAM_Users", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      cmbavFilauttype.removeAllItems();
      cmbavFilauttype.addItem("", httpContext.getMessage( "WWP_GAM_All", ""), (short)(0));
      GXv_objcol_SdtGAMError3[0] = AV17Errors ;
      AV10AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getauthenticationtypes(AV20FilterAutType, GXv_objcol_SdtGAMError3) ;
      AV17Errors = GXv_objcol_SdtGAMError3[0] ;
      AV98GXV1 = 1 ;
      while ( AV98GXV1 <= AV10AuthenticationTypes.size() )
      {
         AV8AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationType)((genexus.security.api.genexussecurity.SdtGAMAuthenticationType)AV10AuthenticationTypes.elementAt(-1+AV98GXV1));
         cmbavFilauttype.addItem(AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Name(), AV8AuthenticationType.getgxTv_SdtGAMAuthenticationType_Description(), (short)(0));
         AV98GXV1 = (int)(AV98GXV1+1) ;
      }
      cmbavFilrol.removeAllItems();
      cmbavFilrol.addItem("0", httpContext.getMessage( "WWP_GAM_All", ""), (short)(0));
      cmbavFilrol.addItem("-1", httpContext.getMessage( "WWP_GAM_NoRole", ""), (short)(0));
      GXv_objcol_SdtGAMError3[0] = AV17Errors ;
      AV45Roles = AV36Repository.getroles(AV43FilterRoles, GXv_objcol_SdtGAMError3) ;
      AV17Errors = GXv_objcol_SdtGAMError3[0] ;
      AV99GXV2 = 1 ;
      while ( AV99GXV2 <= AV45Roles.size() )
      {
         AV42Role = (genexus.security.api.genexussecurity.SdtGAMRole)((genexus.security.api.genexussecurity.SdtGAMRole)AV45Roles.elementAt(-1+AV99GXV2));
         cmbavFilrol.addItem(GXutil.trim( GXutil.str( AV42Role.getgxTv_SdtGAMRole_Id(), 12, 0)), AV42Role.getgxTv_SdtGAMRole_Name(), (short)(0));
         AV99GXV2 = (int)(AV99GXV2+1) ;
      }
      edtavBtnrole_Title = httpContext.getMessage( "WWP_GAM_Roles", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnrole_Internalname, "Title", edtavBtnrole_Title, !bGXsfl_54_Refreshing);
      edtavBtnsetpwd_Title = httpContext.getMessage( "WWP_GAM_Password", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnsetpwd_Internalname, "Title", edtavBtnsetpwd_Title, !bGXsfl_54_Refreshing);
      edtavBtnpermissions_Title = httpContext.getMessage( "WWP_GAM_Permissions", "") ;
      httpContext.ajax_rsp_assign_prop("", false, edtavBtnpermissions_Internalname, "Title", edtavBtnpermissions_Title, !bGXsfl_54_Refreshing);
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
      AV36Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
   }

   public void e161S2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext4[0] = AV50WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext4) ;
      AV50WWPContext = GXv_SdtWWPContext4[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      if ( AV76ManageFiltersExecutionStep == 1 )
      {
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
      }
      else if ( AV76ManageFiltersExecutionStep == 2 )
      {
         AV76ManageFiltersExecutionStep = (byte)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         /* Execute user subroutine: 'LOADSAVEDFILTERS' */
         S112 ();
         if (returnInSub) return;
      }
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV26GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GridCurrentPage), 10, 0));
      GXt_char5 = AV85GridAppliedFilters ;
      GXv_char6[0] = GXt_char5 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV100Pgmname, GXv_char6) ;
      gamwwusers_impl.this.GXt_char5 = GXv_char6[0] ;
      AV85GridAppliedFilters = GXt_char5 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85GridAppliedFilters", AV85GridAppliedFilters);
      AV26GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GridCurrentPage), 10, 0));
      AV6GridPageSize = subGrid_Rows ;
      AV19Filter.setgxTv_SdtGAMUserFilter_Gender( AV21FilUserGender );
      AV19Filter.setgxTv_SdtGAMUserFilter_Authenticationtypename( AV18FilAutType );
      AV19Filter.setgxTv_SdtGAMUserFilter_Loadcustomattributes( false );
      AV19Filter.setgxTv_SdtGAMUserFilter_Returnanonymoususer( false );
      AV19Filter.setgxTv_SdtGAMUserFilter_Limit( (int)(AV6GridPageSize+1) );
      AV83FirstIndex = (short)((AV26GridCurrentPage-1)*AV6GridPageSize+1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83FirstIndex", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83FirstIndex), 4, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFIRSTINDEX", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV83FirstIndex), "ZZZ9")));
      AV19Filter.setgxTv_SdtGAMUserFilter_Start( (int)(AV83FirstIndex-1) );
      if ( ! (GXutil.strcmp("", AV40Search)==0) )
      {
         AV19Filter.setgxTv_SdtGAMUserFilter_Searchable( "%"+AV40Search );
      }
      if ( AV41FilRol == -1 )
      {
         AV19Filter.setgxTv_SdtGAMUserFilter_Withoutroles( true );
      }
      else
      {
         AV19Filter.setgxTv_SdtGAMUserFilter_Roleid( AV41FilRol );
      }
      GXv_objcol_SdtGAMError3[0] = AV17Errors ;
      AV25GAMUsers = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getusersorderby(AV19Filter, (byte)(0), GXv_objcol_SdtGAMError3) ;
      AV17Errors = GXv_objcol_SdtGAMError3[0] ;
      if ( cmbavFilauttype.getItemCount() == 2 )
      {
         edtavAuthenticationtypename_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAuthenticationtypename_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthenticationtypename_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      if ( AV25GAMUsers.size() == AV19Filter.getgxTv_SdtGAMUserFilter_Limit() )
      {
         AV7GridRecordCount = (long)(AV26GridCurrentPage*AV6GridPageSize+1) ;
         AV27GridPageCount = (long)(AV26GridCurrentPage+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GridPageCount), 10, 0));
      }
      else
      {
         AV7GridRecordCount = (long)((AV26GridCurrentPage-1)*AV6GridPageSize+AV25GAMUsers.size()) ;
         AV27GridPageCount = AV26GridCurrentPage ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GridPageCount), 10, 0));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Filter", AV19Filter);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53GridState", AV53GridState);
   }

   public void e121S2( )
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
         AV35PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV35PageToGo) ;
      }
   }

   public void e131S2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e171S2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV64i = 1 ;
      while ( AV64i <= AV83FirstIndex - 1 )
      {
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(54) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_542( ) ;
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
         if ( isFullAjaxMode( ) && ! bGXsfl_54_Refreshing )
         {
            httpContext.doAjaxLoad(54, GridRow);
         }
         AV64i = (long)(AV64i+1) ;
      }
      AV101GXV3 = 1 ;
      while ( AV101GXV3 <= AV25GAMUsers.size() )
      {
         AV38User = (genexus.security.api.genexussecurity.SdtGAMUser)((genexus.security.api.genexussecurity.SdtGAMUser)AV25GAMUsers.elementAt(-1+AV101GXV3));
         AV9AuthenticationTypeName = AV38User.getgxTv_SdtGAMUser_Authenticationtypename() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavAuthenticationtypename_Internalname, AV9AuthenticationTypeName);
         AV28GUID = AV38User.getgxTv_SdtGAMUser_Guid() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavGuid_Internalname, AV28GUID);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGUID"+"_"+sGXsfl_54_idx, getSecureSignedToken( sGXsfl_54_idx, GXutil.rtrim( localUtil.format( AV28GUID, ""))));
         AV34Name = AV38User.getgxTv_SdtGAMUser_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavName_Internalname, AV34Name);
         AV22FirstName = AV38User.getgxTv_SdtGAMUser_Firstname() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavFirstname_Internalname, AV22FirstName);
         AV33LastName = AV38User.getgxTv_SdtGAMUser_Lastname() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavLastname_Internalname, AV33LastName);
         if ( AV38User.getgxTv_SdtGAMUser_Isenabledinrepository() )
         {
            edtavName_Class = "ReadonlyAttribute" ;
            edtavFirstname_Class = "ReadonlyAttribute" ;
            edtavLastname_Class = "ReadonlyAttribute" ;
            edtavAuthenticationtypename_Class = "ReadonlyAttribute" ;
         }
         else
         {
            edtavName_Class = "AttributeInactive" ;
            edtavFirstname_Class = "AttributeInactive" ;
            edtavLastname_Class = "AttributeInactive" ;
            edtavAuthenticationtypename_Class = "AttributeInactive" ;
         }
         AV86Display = "<i class=\"fa fa-search\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV86Display);
         if ( AV88IsAuthorized_Display )
         {
            edtavDisplay_Link = formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID)))}, new String[] {"Mode","UserId"})  ;
         }
         AV87Update = "<i class=\"fa fa-pen\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV87Update);
         if ( AV89IsAuthorized_Update )
         {
            if ( ! ( ( GXutil.strcmp(GXutil.trim( AV28GUID), GXutil.trim( AV36Repository.getgxTv_SdtGAMRepository_Anonymoususerguid())) == 0 ) || AV38User.getgxTv_SdtGAMUser_Isautoregistereduser() ) )
            {
               edtavUpdate_Link = formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID)))}, new String[] {"Mode","UserId"})  ;
               edtavUpdate_Class = "Attribute" ;
            }
            else
            {
               edtavUpdate_Link = "" ;
               edtavUpdate_Class = "Invisible" ;
            }
         }
         AV5Delete = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
         if ( AV90IsAuthorized_Delete )
         {
            if ( ! ( ( GXutil.strcmp(GXutil.trim( AV28GUID), GXutil.trim( AV36Repository.getgxTv_SdtGAMRepository_Anonymoususerguid())) == 0 ) || AV24GAMUserIsDeleted ) )
            {
               edtavDelete_Link = formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID)))}, new String[] {"Mode","UserId"})  ;
               edtavDelete_Class = "Attribute" ;
            }
            else
            {
               edtavDelete_Link = "" ;
               edtavDelete_Class = "Invisible" ;
            }
         }
         AV12BtnRole = "<i class=\"fa fa-cog\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavBtnrole_Internalname, AV12BtnRole);
         if ( AV30IsAuthorized_BtnRole )
         {
            edtavBtnrole_Link = formatLink("com.mujermorena.gamwwuserroles", new String[] {GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID)))}, new String[] {"UserId"})  ;
         }
         AV14BtnPermissions = "<i class=\"fa fa-lock\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavBtnpermissions_Internalname, AV14BtnPermissions);
         if ( AV91IsAuthorized_BtnPermissions )
         {
            edtavBtnpermissions_Link = formatLink("com.mujermorena.gamwwuserpermissions", new String[] {GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID))),GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"UserId","pApplicationId"})  ;
         }
         AV13BtnSetPwd = "<i class=\"fa fa-key\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavBtnsetpwd_Internalname, AV13BtnSetPwd);
         if ( AV31IsAuthorized_BtnSetPwd )
         {
            if ( ! ( ( GXutil.strcmp(GXutil.trim( AV28GUID), GXutil.trim( AV36Repository.getgxTv_SdtGAMRepository_Anonymoususerguid())) == 0 ) || AV23GAMUserIsAutoRegisteredUser ) )
            {
               edtavBtnsetpwd_Link = formatLink("com.mujermorena.gamsetpassword", new String[] {GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID)))}, new String[] {"UserId"})  ;
               edtavBtnsetpwd_Class = "Attribute" ;
            }
            else
            {
               edtavBtnsetpwd_Link = "" ;
               edtavBtnsetpwd_Class = "Invisible" ;
            }
         }
         AV94BtnUnblockOTPCodes = "<i class=\"fas fa-unlock\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavBtnunblockotpcodes_Internalname, AV94BtnUnblockOTPCodes);
         if ( AV36Repository.isonetimepasswordenabled() )
         {
            edtavBtnunblockotpcodes_Class = "Attribute" ;
         }
         else
         {
            edtavBtnunblockotpcodes_Class = "Invisible" ;
         }
         if ( AV44IsAuthorized_Name )
         {
            edtavName_Link = formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.rtrim(GXutil.trim( AV28GUID)))}, new String[] {"Mode","UserId"})  ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(54) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_542( ) ;
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
         if ( isFullAjaxMode( ) && ! bGXsfl_54_Refreshing )
         {
            httpContext.doAjaxLoad(54, GridRow);
         }
         AV101GXV3 = (int)(AV101GXV3+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e111S2( )
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
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.savefilteras", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWUsersFilters")),GXutil.URLEncode(GXutil.rtrim(AV100Pgmname+"GridState"))}, new String[] {"UserKey","GridStateKey"}) , new Object[] {});
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else if ( GXutil.strcmp(Ddo_managefilters_Activeeventkey, "<#Manage#>") == 0 )
      {
         httpContext.popup(formatLink("com.mujermorena.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("GAMWWUsersFilters"))}, new String[] {"UserKey"}) , new Object[] {});
         AV76ManageFiltersExecutionStep = (byte)(2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76ManageFiltersExecutionStep", GXutil.str( AV76ManageFiltersExecutionStep, 1, 0));
         httpContext.doAjaxRefresh();
      }
      else
      {
         GXt_char5 = AV77ManageFiltersXml ;
         GXv_char6[0] = GXt_char5 ;
         new com.mujermorena.wwpbaseobjects.getfilterbyname(remoteHandle, context).execute( "GAMWWUsersFilters", Ddo_managefilters_Activeeventkey, GXv_char6) ;
         gamwwusers_impl.this.GXt_char5 = GXv_char6[0] ;
         AV77ManageFiltersXml = GXt_char5 ;
         if ( (GXutil.strcmp("", AV77ManageFiltersXml)==0) )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_FilterNotExist", ""));
         }
         else
         {
            /* Execute user subroutine: 'CLEANFILTERS' */
            S152 ();
            if (returnInSub) return;
            new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV77ManageFiltersXml) ;
            AV53GridState.fromxml(AV77ManageFiltersXml, null, null);
            /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
            S162 ();
            if (returnInSub) return;
            subgrid_firstpage( ) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53GridState", AV53GridState);
      cmbavFilusergender.setValue( GXutil.rtrim( AV21FilUserGender) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavFilusergender.getInternalname(), "Values", cmbavFilusergender.ToJavascriptSource(), true);
      cmbavFilauttype.setValue( GXutil.rtrim( AV18FilAutType) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavFilauttype.getInternalname(), "Values", cmbavFilauttype.ToJavascriptSource(), true);
      cmbavFilrol.setValue( GXutil.trim( GXutil.str( AV41FilRol, 12, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavFilrol.getInternalname(), "Values", cmbavFilrol.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Filter", AV19Filter);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
   }

   public void e141S2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( AV92IsAuthorized_Insert )
      {
         callWebObject(formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","UserId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV19Filter", AV19Filter);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV80ManageFiltersData", AV80ManageFiltersData);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53GridState", AV53GridState);
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV88IsAuthorized_Display ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamuserentry_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV88IsAuthorized_Display = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV88IsAuthorized_Display", AV88IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV88IsAuthorized_Display));
      if ( ! ( AV88IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      GXt_boolean1 = AV89IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamuserentry_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV89IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV89IsAuthorized_Update", AV89IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV89IsAuthorized_Update));
      if ( ! ( AV89IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      GXt_boolean1 = AV90IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamuserentry_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV90IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV90IsAuthorized_Delete", AV90IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV90IsAuthorized_Delete));
      if ( ! ( AV90IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      GXt_boolean1 = AV30IsAuthorized_BtnRole ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamwwuserroles_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV30IsAuthorized_BtnRole = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30IsAuthorized_BtnRole", AV30IsAuthorized_BtnRole);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNROLE", getSecureSignedToken( "", AV30IsAuthorized_BtnRole));
      if ( ! ( AV30IsAuthorized_BtnRole ) )
      {
         edtavBtnrole_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBtnrole_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnrole_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      GXt_boolean1 = AV91IsAuthorized_BtnPermissions ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamwwuserpermissions_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV91IsAuthorized_BtnPermissions = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV91IsAuthorized_BtnPermissions", AV91IsAuthorized_BtnPermissions);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNPERMISSIONS", getSecureSignedToken( "", AV91IsAuthorized_BtnPermissions));
      if ( ! ( AV91IsAuthorized_BtnPermissions ) )
      {
         edtavBtnpermissions_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBtnpermissions_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnpermissions_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      GXt_boolean1 = AV31IsAuthorized_BtnSetPwd ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamsetpassword_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV31IsAuthorized_BtnSetPwd = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31IsAuthorized_BtnSetPwd", AV31IsAuthorized_BtnSetPwd);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_BTNSETPWD", getSecureSignedToken( "", AV31IsAuthorized_BtnSetPwd));
      if ( ! ( AV31IsAuthorized_BtnSetPwd ) )
      {
         edtavBtnsetpwd_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBtnsetpwd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBtnsetpwd_Visible), 5, 0), !bGXsfl_54_Refreshing);
      }
      GXt_boolean1 = AV92IsAuthorized_Insert ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gamuserentry_Execute", GXv_boolean2) ;
      gamwwusers_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV92IsAuthorized_Insert = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV92IsAuthorized_Insert", AV92IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV92IsAuthorized_Insert));
      if ( ! ( AV92IsAuthorized_Insert && ( (0==AV36Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) ) ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADSAVEDFILTERS' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = AV80ManageFiltersData ;
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
      new com.mujermorena.wwpbaseobjects.wwp_managefiltersloadsavedfilters(remoteHandle, context).execute( "GAMWWUsersFilters", "", "", false, GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8) ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[0] ;
      AV80ManageFiltersData = GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   }

   public void S152( )
   {
      /* 'CLEANFILTERS' Routine */
      returnInSub = false ;
      AV40Search = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40Search", AV40Search);
      AV21FilUserGender = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21FilUserGender", AV21FilUserGender);
      AV18FilAutType = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18FilAutType", AV18FilAutType);
      AV41FilRol = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41FilRol", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41FilRol), 12, 0));
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV72Session.getValue(AV100Pgmname+"GridState"), "") == 0 )
      {
         AV53GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV100Pgmname+"GridState"), null, null);
      }
      else
      {
         AV53GridState.fromxml(AV72Session.getValue(AV100Pgmname+"GridState"), null, null);
      }
      /* Execute user subroutine: 'LOADREGFILTERSSTATE' */
      S162 ();
      if (returnInSub) return;
      if ( ! (GXutil.strcmp("", GXutil.trim( AV53GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV53GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV53GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S162( )
   {
      /* 'LOADREGFILTERSSTATE' Routine */
      returnInSub = false ;
      AV102GXV4 = 1 ;
      while ( AV102GXV4 <= AV53GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV54GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV53GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV102GXV4));
         if ( GXutil.strcmp(AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "SEARCH") == 0 )
         {
            AV40Search = AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40Search", AV40Search);
         }
         else if ( GXutil.strcmp(AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILUSERGENDER") == 0 )
         {
            AV21FilUserGender = AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21FilUserGender", AV21FilUserGender);
         }
         else if ( GXutil.strcmp(AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILAUTTYPE") == 0 )
         {
            AV18FilAutType = AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18FilAutType", AV18FilAutType);
         }
         else if ( GXutil.strcmp(AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILROL") == 0 )
         {
            AV41FilRol = GXutil.lval( AV54GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41FilRol", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41FilRol), 12, 0));
         }
         AV102GXV4 = (int)(AV102GXV4+1) ;
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV53GridState.fromxml(AV72Session.getValue(AV100Pgmname+"GridState"), null, null);
      AV53GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState9[0] = AV53GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "SEARCH", httpContext.getMessage( "WWP_GAM_Search", ""), !(GXutil.strcmp("", AV40Search)==0), (short)(0), AV40Search, "") ;
      AV53GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV53GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILUSERGENDER", httpContext.getMessage( "WWP_GAM_Gender", ""), !(GXutil.strcmp("", AV21FilUserGender)==0), (short)(0), AV21FilUserGender, "") ;
      AV53GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV53GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILAUTTYPE", httpContext.getMessage( "WWP_GAM_Authentication", ""), !(GXutil.strcmp("", AV18FilAutType)==0), (short)(0), AV18FilAutType, "") ;
      AV53GridState = GXv_SdtWWPGridState9[0] ;
      GXv_SdtWWPGridState9[0] = AV53GridState;
      new com.mujermorena.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState9, "FILROL", httpContext.getMessage( "WWP_GAM_Role", ""), !(0==AV41FilRol), (short)(0), GXutil.trim( GXutil.str( AV41FilRol, 12, 0)), "") ;
      AV53GridState = GXv_SdtWWPGridState9[0] ;
      AV53GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV53GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV100Pgmname+"GridState", AV53GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e181S2( )
   {
      /* Btnunblockotpcodes_Click Routine */
      returnInSub = false ;
      AV38User.load(AV28GUID);
      GXv_objcol_SdtGAMError3[0] = AV17Errors ;
      if ( AV38User.unblockotpcodes(GXv_objcol_SdtGAMError3) )
      {
         AV17Errors = GXv_objcol_SdtGAMError3[0] ;
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwwusers");
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_GAM_UserSuccessfullyUnlockOTPCodes", ""));
      }
      else
      {
         AV103GXV5 = 1 ;
         while ( AV103GXV5 <= AV17Errors.size() )
         {
            AV95Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV17Errors.elementAt(-1+AV103GXV5));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV95Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV95Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV103GXV5 = (int)(AV103GXV5+1) ;
         }
      }
   }

   public void wb_table1_23_1S2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "Table100x100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='CellAlignTopPaddingTop2'>") ;
         /* User Defined Control */
         ucDdo_managefilters.setProperty("IconType", Ddo_managefilters_Icontype);
         ucDdo_managefilters.setProperty("Icon", Ddo_managefilters_Icon);
         ucDdo_managefilters.setProperty("Caption", Ddo_managefilters_Caption);
         ucDdo_managefilters.setProperty("Tooltip", Ddo_managefilters_Tooltip);
         ucDdo_managefilters.setProperty("Cls", Ddo_managefilters_Cls);
         ucDdo_managefilters.setProperty("DropDownOptionsData", AV80ManageFiltersData);
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSearch_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSearch_Internalname, httpContext.getMessage( "WWP_GAM_Search", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'" + sGXsfl_54_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSearch_Internalname, AV40Search, GXutil.rtrim( localUtil.format( AV40Search, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "Login/Name/Email", ""), edtavSearch_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSearch_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMWWUsers.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFilusergender.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavFilusergender.getInternalname(), httpContext.getMessage( "WWP_GAM_Gender", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'" + sGXsfl_54_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFilusergender, cmbavFilusergender.getInternalname(), GXutil.rtrim( AV21FilUserGender), 1, cmbavFilusergender.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFilusergender.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_GAMWWUsers.htm");
         cmbavFilusergender.setValue( GXutil.rtrim( AV21FilUserGender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFilusergender.getInternalname(), "Values", cmbavFilusergender.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFilauttype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavFilauttype.getInternalname(), httpContext.getMessage( "WWP_GAM_Authentication", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_54_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFilauttype, cmbavFilauttype.getInternalname(), GXutil.rtrim( AV18FilAutType), 1, cmbavFilauttype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFilauttype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_GAMWWUsers.htm");
         cmbavFilauttype.setValue( GXutil.rtrim( AV18FilAutType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFilauttype.getInternalname(), "Values", cmbavFilauttype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellFormGroupMarginBottom5", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFilrol.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavFilrol.getInternalname(), httpContext.getMessage( "WWP_GAM_Role", ""), "col-sm-6 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'" + sGXsfl_54_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFilrol, cmbavFilrol.getInternalname(), GXutil.trim( GXutil.str( AV41FilRol, 12, 0)), 1, cmbavFilrol.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavFilrol.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "", true, (byte)(0), "HLP_GAMWWUsers.htm");
         cmbavFilrol.setValue( GXutil.trim( GXutil.str( AV41FilRol, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavFilrol.getInternalname(), "Values", cmbavFilrol.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_23_1S2e( true) ;
      }
      else
      {
         wb_table1_23_1S2e( false) ;
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
      pa1S2( ) ;
      ws1S2( ) ;
      we1S2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111164764", true, true);
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
      httpContext.AddJavascriptSource("gamwwusers.js", "?202412111164776", false, true);
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

   public void subsflControlProps_542( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_54_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_54_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_54_idx ;
      edtavBtnrole_Internalname = "vBTNROLE_"+sGXsfl_54_idx ;
      edtavBtnpermissions_Internalname = "vBTNPERMISSIONS_"+sGXsfl_54_idx ;
      edtavBtnsetpwd_Internalname = "vBTNSETPWD_"+sGXsfl_54_idx ;
      edtavBtnunblockotpcodes_Internalname = "vBTNUNBLOCKOTPCODES_"+sGXsfl_54_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_54_idx ;
      edtavFirstname_Internalname = "vFIRSTNAME_"+sGXsfl_54_idx ;
      edtavLastname_Internalname = "vLASTNAME_"+sGXsfl_54_idx ;
      edtavAuthenticationtypename_Internalname = "vAUTHENTICATIONTYPENAME_"+sGXsfl_54_idx ;
      edtavGuid_Internalname = "vGUID_"+sGXsfl_54_idx ;
   }

   public void subsflControlProps_fel_542( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_54_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_54_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_54_fel_idx ;
      edtavBtnrole_Internalname = "vBTNROLE_"+sGXsfl_54_fel_idx ;
      edtavBtnpermissions_Internalname = "vBTNPERMISSIONS_"+sGXsfl_54_fel_idx ;
      edtavBtnsetpwd_Internalname = "vBTNSETPWD_"+sGXsfl_54_fel_idx ;
      edtavBtnunblockotpcodes_Internalname = "vBTNUNBLOCKOTPCODES_"+sGXsfl_54_fel_idx ;
      edtavName_Internalname = "vNAME_"+sGXsfl_54_fel_idx ;
      edtavFirstname_Internalname = "vFIRSTNAME_"+sGXsfl_54_fel_idx ;
      edtavLastname_Internalname = "vLASTNAME_"+sGXsfl_54_fel_idx ;
      edtavAuthenticationtypename_Internalname = "vAUTHENTICATIONTYPENAME_"+sGXsfl_54_fel_idx ;
      edtavGuid_Internalname = "vGUID_"+sGXsfl_54_fel_idx ;
   }

   public void sendrow_542( )
   {
      subsflControlProps_542( ) ;
      wb1S0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_54_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_54_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_54_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 55,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV86Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,55);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 56,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavUpdate_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV87Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,56);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),edtavUpdate_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 57,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavDelete_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV5Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,57);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),edtavDelete_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavBtnrole_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavBtnrole_Enabled!=0)&&(edtavBtnrole_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 58,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtnrole_Internalname,GXutil.rtrim( AV12BtnRole),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavBtnrole_Enabled!=0)&&(edtavBtnrole_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,58);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavBtnrole_Link,"",httpContext.getMessage( "WWP_GAM_Roles", ""),"",edtavBtnrole_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn hidden-xs","",Integer.valueOf(edtavBtnrole_Visible),Integer.valueOf(edtavBtnrole_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavBtnpermissions_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavBtnpermissions_Enabled!=0)&&(edtavBtnpermissions_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 59,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtnpermissions_Internalname,GXutil.rtrim( AV14BtnPermissions),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavBtnpermissions_Enabled!=0)&&(edtavBtnpermissions_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,59);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavBtnpermissions_Link,"",httpContext.getMessage( "WWP_GAM_Permissions", ""),"",edtavBtnpermissions_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn hidden-xs","",Integer.valueOf(edtavBtnpermissions_Visible),Integer.valueOf(edtavBtnpermissions_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavBtnsetpwd_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavBtnsetpwd_Enabled!=0)&&(edtavBtnsetpwd_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 60,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavBtnsetpwd_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtnsetpwd_Internalname,GXutil.rtrim( AV13BtnSetPwd),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavBtnsetpwd_Enabled!=0)&&(edtavBtnsetpwd_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,60);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavBtnsetpwd_Link,"",httpContext.getMessage( "WWP_GAM_SetNewPassword", ""),"",edtavBtnsetpwd_Jsonclick,Integer.valueOf(0),edtavBtnsetpwd_Class,"",ROClassString,"WWIconActionColumn hidden-xs","",Integer.valueOf(edtavBtnsetpwd_Visible),Integer.valueOf(edtavBtnsetpwd_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavBtnunblockotpcodes_Enabled!=0)&&(edtavBtnunblockotpcodes_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 61,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavBtnunblockotpcodes_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavBtnunblockotpcodes_Internalname,GXutil.rtrim( AV94BtnUnblockOTPCodes),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavBtnunblockotpcodes_Enabled!=0)&&(edtavBtnunblockotpcodes_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,61);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVBTNUNBLOCKOTPCODES.CLICK."+sGXsfl_54_idx+"'","","",httpContext.getMessage( "WWP_GAM_UnblockOTPCodes", ""),"",edtavBtnunblockotpcodes_Jsonclick,Integer.valueOf(5),edtavBtnunblockotpcodes_Class,"",ROClassString,"WWIconActionColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(edtavBtnunblockotpcodes_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 62,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavName_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavName_Internalname,AV34Name,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavName_Enabled!=0)&&(edtavName_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,62);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavName_Link,"","","",edtavName_Jsonclick,Integer.valueOf(0),edtavName_Class,"",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMUserIdentification","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavFirstname_Enabled!=0)&&(edtavFirstname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 63,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavFirstname_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavFirstname_Internalname,GXutil.rtrim( AV22FirstName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavFirstname_Enabled!=0)&&(edtavFirstname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,63);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavFirstname_Jsonclick,Integer.valueOf(0),edtavFirstname_Class,"",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(edtavFirstname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionShort","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavLastname_Enabled!=0)&&(edtavLastname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 64,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavLastname_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavLastname_Internalname,GXutil.rtrim( AV33LastName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavLastname_Enabled!=0)&&(edtavLastname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,64);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavLastname_Jsonclick,Integer.valueOf(0),edtavLastname_Class,"",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(edtavLastname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionShort","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavAuthenticationtypename_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavAuthenticationtypename_Enabled!=0)&&(edtavAuthenticationtypename_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 65,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = edtavAuthenticationtypename_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavAuthenticationtypename_Internalname,GXutil.rtrim( AV9AuthenticationTypeName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavAuthenticationtypename_Enabled!=0)&&(edtavAuthenticationtypename_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,65);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavAuthenticationtypename_Jsonclick,Integer.valueOf(0),edtavAuthenticationtypename_Class,"",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(edtavAuthenticationtypename_Visible),Integer.valueOf(edtavAuthenticationtypename_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMAuthenticationTypeName","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavGuid_Enabled!=0)&&(edtavGuid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 66,'',false,'"+sGXsfl_54_idx+"',54)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavGuid_Internalname,GXutil.rtrim( AV28GUID),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavGuid_Enabled!=0)&&(edtavGuid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,66);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavGuid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavGuid_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(54),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1S2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_54_idx = ((subGrid_Islastpage==1)&&(nGXsfl_54_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_54_idx+1) ;
         sGXsfl_54_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_54_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_542( ) ;
      }
      /* End function sendrow_542 */
   }

   public void startgridcontrol54( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"54\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavUpdate_Class+"\" "+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavDelete_Class+"\" "+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavBtnrole_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtavBtnrole_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+((edtavBtnpermissions_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtavBtnpermissions_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavBtnsetpwd_Class+"\" "+" style=\""+((edtavBtnsetpwd_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( edtavBtnsetpwd_Title) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavBtnunblockotpcodes_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavName_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Name", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavFirstname_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_FirstName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavLastname_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_LastName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavAuthenticationtypename_Class+"\" "+" style=\""+((edtavAuthenticationtypename_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Authentication", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV86Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV87Update));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavUpdate_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavUpdate_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavUpdate_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV5Delete));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavDelete_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDelete_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDelete_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDelete_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV12BtnRole));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavBtnrole_Title));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtnrole_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavBtnrole_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavBtnrole_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV14BtnPermissions));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavBtnpermissions_Title));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtnpermissions_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavBtnpermissions_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavBtnpermissions_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV13BtnSetPwd));
         GridColumn.AddObjectProperty("Title", GXutil.rtrim( edtavBtnsetpwd_Title));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavBtnsetpwd_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtnsetpwd_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavBtnsetpwd_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavBtnsetpwd_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV94BtnUnblockOTPCodes));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavBtnunblockotpcodes_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavBtnunblockotpcodes_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV34Name);
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavName_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavName_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavName_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV22FirstName));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavFirstname_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavFirstname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV33LastName));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavLastname_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavLastname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV9AuthenticationTypeName));
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavAuthenticationtypename_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavAuthenticationtypename_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavAuthenticationtypename_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV28GUID));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavGuid_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      edtavSearch_Internalname = "vSEARCH" ;
      cmbavFilusergender.setInternalname( "vFILUSERGENDER" );
      cmbavFilauttype.setInternalname( "vFILAUTTYPE" );
      cmbavFilrol.setInternalname( "vFILROL" );
      divTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavBtnrole_Internalname = "vBTNROLE" ;
      edtavBtnpermissions_Internalname = "vBTNPERMISSIONS" ;
      edtavBtnsetpwd_Internalname = "vBTNSETPWD" ;
      edtavBtnunblockotpcodes_Internalname = "vBTNUNBLOCKOTPCODES" ;
      edtavName_Internalname = "vNAME" ;
      edtavFirstname_Internalname = "vFIRSTNAME" ;
      edtavLastname_Internalname = "vLASTNAME" ;
      edtavAuthenticationtypename_Internalname = "vAUTHENTICATIONTYPENAME" ;
      edtavGuid_Internalname = "vGUID" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavGamuserscount_Internalname = "vGAMUSERSCOUNT" ;
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
      edtavGuid_Jsonclick = "" ;
      edtavGuid_Visible = 0 ;
      edtavGuid_Enabled = 1 ;
      edtavAuthenticationtypename_Jsonclick = "" ;
      edtavAuthenticationtypename_Class = "AttributeRealWidth" ;
      edtavAuthenticationtypename_Enabled = 1 ;
      edtavLastname_Jsonclick = "" ;
      edtavLastname_Class = "AttributeRealWidth" ;
      edtavLastname_Visible = -1 ;
      edtavLastname_Enabled = 1 ;
      edtavFirstname_Jsonclick = "" ;
      edtavFirstname_Class = "AttributeRealWidth" ;
      edtavFirstname_Visible = -1 ;
      edtavFirstname_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Class = "AttributeRealWidth" ;
      edtavName_Visible = -1 ;
      edtavName_Link = "" ;
      edtavName_Enabled = 1 ;
      edtavBtnunblockotpcodes_Jsonclick = "" ;
      edtavBtnunblockotpcodes_Class = "Attribute" ;
      edtavBtnunblockotpcodes_Visible = -1 ;
      edtavBtnunblockotpcodes_Enabled = 1 ;
      edtavBtnsetpwd_Jsonclick = "" ;
      edtavBtnsetpwd_Class = "Attribute" ;
      edtavBtnsetpwd_Link = "" ;
      edtavBtnsetpwd_Enabled = 1 ;
      edtavBtnpermissions_Jsonclick = "" ;
      edtavBtnpermissions_Link = "" ;
      edtavBtnpermissions_Enabled = 1 ;
      edtavBtnrole_Jsonclick = "" ;
      edtavBtnrole_Link = "" ;
      edtavBtnrole_Enabled = 1 ;
      edtavDelete_Jsonclick = "" ;
      edtavDelete_Class = "Attribute" ;
      edtavDelete_Link = "" ;
      edtavDelete_Enabled = 1 ;
      edtavUpdate_Jsonclick = "" ;
      edtavUpdate_Class = "Attribute" ;
      edtavUpdate_Link = "" ;
      edtavUpdate_Enabled = 1 ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Link = "" ;
      edtavDisplay_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      cmbavFilrol.setJsonclick( "" );
      cmbavFilrol.setEnabled( 1 );
      cmbavFilauttype.setJsonclick( "" );
      cmbavFilauttype.setEnabled( 1 );
      cmbavFilusergender.setJsonclick( "" );
      cmbavFilusergender.setEnabled( 1 );
      edtavSearch_Jsonclick = "" ;
      edtavSearch_Enabled = 1 ;
      edtavBtnsetpwd_Visible = -1 ;
      edtavBtnpermissions_Visible = -1 ;
      edtavBtnrole_Visible = -1 ;
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
      edtavAuthenticationtypename_Visible = -1 ;
      edtavGamuserscount_Jsonclick = "" ;
      edtavGamuserscount_Visible = 1 ;
      lblBtninsert_Caption = httpContext.getMessage( "<i class='fas fa-plus' title='Agregar'></i>", "") ;
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
      Form.setCaption( httpContext.getMessage( "WWP_GAM_Users", "") );
      edtavBtnpermissions_Title = "" ;
      edtavBtnsetpwd_Title = "" ;
      edtavBtnrole_Title = "" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavFilusergender.setName( "vFILUSERGENDER" );
      cmbavFilusergender.setWebtags( "" );
      cmbavFilusergender.addItem("", httpContext.getMessage( "All", ""), (short)(0));
      cmbavFilusergender.addItem("N", httpContext.getMessage( "WWP_GAM_NotSpecified", ""), (short)(0));
      cmbavFilusergender.addItem("F", httpContext.getMessage( "WWP_GAM_Female", ""), (short)(0));
      cmbavFilusergender.addItem("M", httpContext.getMessage( "WWP_GAM_Male", ""), (short)(0));
      if ( cmbavFilusergender.getItemCount() > 0 )
      {
         AV21FilUserGender = cmbavFilusergender.getValidValue(AV21FilUserGender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21FilUserGender", AV21FilUserGender);
      }
      cmbavFilauttype.setName( "vFILAUTTYPE" );
      cmbavFilauttype.setWebtags( "" );
      if ( cmbavFilauttype.getItemCount() > 0 )
      {
         AV18FilAutType = cmbavFilauttype.getValidValue(AV18FilAutType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18FilAutType", AV18FilAutType);
      }
      cmbavFilrol.setName( "vFILROL" );
      cmbavFilrol.setWebtags( "" );
      if ( cmbavFilrol.getItemCount() > 0 )
      {
         AV41FilRol = GXutil.lval( cmbavFilrol.getValidValue(GXutil.trim( GXutil.str( AV41FilRol, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41FilRol", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41FilRol), 12, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'edtavBtnrole_Title',ctrl:'vBTNROLE',prop:'Title'},{av:'edtavBtnsetpwd_Title',ctrl:'vBTNSETPWD',prop:'Title'},{av:'edtavBtnpermissions_Title',ctrl:'vBTNPERMISSIONS',prop:'Title'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavFilusergender'},{av:'AV21FilUserGender',fld:'vFILUSERGENDER',pic:''},{av:'cmbavFilauttype'},{av:'AV18FilAutType',fld:'vFILAUTTYPE',pic:''},{av:'AV40Search',fld:'vSEARCH',pic:''},{av:'cmbavFilrol'},{av:'AV41FilRol',fld:'vFILROL',pic:'ZZZZZZZZZZZ9'},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV24GAMUserIsDeleted',fld:'vGAMUSERISDELETED',pic:'',hsh:true},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'AV23GAMUserIsAutoRegisteredUser',fld:'vGAMUSERISAUTOREGISTEREDUSER',pic:'',hsh:true},{av:'AV44IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV26GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV85GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'edtavAuthenticationtypename_Visible',ctrl:'vAUTHENTICATIONTYPENAME',prop:'Visible'},{av:'AV27GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'edtavBtnrole_Visible',ctrl:'vBTNROLE',prop:'Visible'},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'edtavBtnpermissions_Visible',ctrl:'vBTNPERMISSIONS',prop:'Visible'},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'edtavBtnsetpwd_Visible',ctrl:'vBTNSETPWD',prop:'Visible'},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV53GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e121S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavFilusergender'},{av:'AV21FilUserGender',fld:'vFILUSERGENDER',pic:''},{av:'cmbavFilauttype'},{av:'AV18FilAutType',fld:'vFILAUTTYPE',pic:''},{av:'AV40Search',fld:'vSEARCH',pic:''},{av:'cmbavFilrol'},{av:'AV41FilRol',fld:'vFILROL',pic:'ZZZZZZZZZZZ9'},{av:'edtavBtnrole_Title',ctrl:'vBTNROLE',prop:'Title'},{av:'edtavBtnsetpwd_Title',ctrl:'vBTNSETPWD',prop:'Title'},{av:'edtavBtnpermissions_Title',ctrl:'vBTNPERMISSIONS',prop:'Title'},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV24GAMUserIsDeleted',fld:'vGAMUSERISDELETED',pic:'',hsh:true},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'AV23GAMUserIsAutoRegisteredUser',fld:'vGAMUSERISAUTOREGISTEREDUSER',pic:'',hsh:true},{av:'AV44IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e131S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavFilusergender'},{av:'AV21FilUserGender',fld:'vFILUSERGENDER',pic:''},{av:'cmbavFilauttype'},{av:'AV18FilAutType',fld:'vFILAUTTYPE',pic:''},{av:'AV40Search',fld:'vSEARCH',pic:''},{av:'cmbavFilrol'},{av:'AV41FilRol',fld:'vFILROL',pic:'ZZZZZZZZZZZ9'},{av:'edtavBtnrole_Title',ctrl:'vBTNROLE',prop:'Title'},{av:'edtavBtnsetpwd_Title',ctrl:'vBTNSETPWD',prop:'Title'},{av:'edtavBtnpermissions_Title',ctrl:'vBTNPERMISSIONS',prop:'Title'},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV24GAMUserIsDeleted',fld:'vGAMUSERISDELETED',pic:'',hsh:true},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'AV23GAMUserIsAutoRegisteredUser',fld:'vGAMUSERISAUTOREGISTEREDUSER',pic:'',hsh:true},{av:'AV44IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e171S2',iparms:[{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV24GAMUserIsDeleted',fld:'vGAMUSERISDELETED',pic:'',hsh:true},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'AV23GAMUserIsAutoRegisteredUser',fld:'vGAMUSERISAUTOREGISTEREDUSER',pic:'',hsh:true},{av:'AV44IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV9AuthenticationTypeName',fld:'vAUTHENTICATIONTYPENAME',pic:''},{av:'AV28GUID',fld:'vGUID',pic:'',hsh:true},{av:'AV34Name',fld:'vNAME',pic:''},{av:'AV22FirstName',fld:'vFIRSTNAME',pic:''},{av:'AV33LastName',fld:'vLASTNAME',pic:''},{av:'edtavName_Class',ctrl:'vNAME',prop:'Class'},{av:'edtavFirstname_Class',ctrl:'vFIRSTNAME',prop:'Class'},{av:'edtavLastname_Class',ctrl:'vLASTNAME',prop:'Class'},{av:'edtavAuthenticationtypename_Class',ctrl:'vAUTHENTICATIONTYPENAME',prop:'Class'},{av:'AV86Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV87Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'edtavUpdate_Class',ctrl:'vUPDATE',prop:'Class'},{av:'AV5Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'edtavDelete_Class',ctrl:'vDELETE',prop:'Class'},{av:'AV12BtnRole',fld:'vBTNROLE',pic:''},{av:'edtavBtnrole_Link',ctrl:'vBTNROLE',prop:'Link'},{av:'AV14BtnPermissions',fld:'vBTNPERMISSIONS',pic:''},{av:'edtavBtnpermissions_Link',ctrl:'vBTNPERMISSIONS',prop:'Link'},{av:'AV13BtnSetPwd',fld:'vBTNSETPWD',pic:''},{av:'edtavBtnsetpwd_Link',ctrl:'vBTNSETPWD',prop:'Link'},{av:'edtavBtnsetpwd_Class',ctrl:'vBTNSETPWD',prop:'Class'},{av:'AV94BtnUnblockOTPCodes',fld:'vBTNUNBLOCKOTPCODES',pic:''},{av:'edtavBtnunblockotpcodes_Class',ctrl:'vBTNUNBLOCKOTPCODES',prop:'Class'},{av:'edtavName_Link',ctrl:'vNAME',prop:'Link'}]}");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED","{handler:'e111S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavFilusergender'},{av:'AV21FilUserGender',fld:'vFILUSERGENDER',pic:''},{av:'cmbavFilauttype'},{av:'AV18FilAutType',fld:'vFILAUTTYPE',pic:''},{av:'AV40Search',fld:'vSEARCH',pic:''},{av:'cmbavFilrol'},{av:'AV41FilRol',fld:'vFILROL',pic:'ZZZZZZZZZZZ9'},{av:'edtavBtnrole_Title',ctrl:'vBTNROLE',prop:'Title'},{av:'edtavBtnsetpwd_Title',ctrl:'vBTNSETPWD',prop:'Title'},{av:'edtavBtnpermissions_Title',ctrl:'vBTNPERMISSIONS',prop:'Title'},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV24GAMUserIsDeleted',fld:'vGAMUSERISDELETED',pic:'',hsh:true},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'AV23GAMUserIsAutoRegisteredUser',fld:'vGAMUSERISAUTOREGISTEREDUSER',pic:'',hsh:true},{av:'AV44IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Ddo_managefilters_Activeeventkey',ctrl:'DDO_MANAGEFILTERS',prop:'ActiveEventKey'},{av:'AV53GridState',fld:'vGRIDSTATE',pic:''}]");
      setEventMetadata("DDO_MANAGEFILTERS.ONOPTIONCLICKED",",oparms:[{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV53GridState',fld:'vGRIDSTATE',pic:''},{av:'AV40Search',fld:'vSEARCH',pic:''},{av:'cmbavFilusergender'},{av:'AV21FilUserGender',fld:'vFILUSERGENDER',pic:''},{av:'cmbavFilauttype'},{av:'AV18FilAutType',fld:'vFILAUTTYPE',pic:''},{av:'cmbavFilrol'},{av:'AV41FilRol',fld:'vFILROL',pic:'ZZZZZZZZZZZ9'},{av:'AV26GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV85GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'edtavAuthenticationtypename_Visible',ctrl:'vAUTHENTICATIONTYPENAME',prop:'Visible'},{av:'AV27GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'edtavBtnrole_Visible',ctrl:'vBTNROLE',prop:'Visible'},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'edtavBtnpermissions_Visible',ctrl:'vBTNPERMISSIONS',prop:'Visible'},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'edtavBtnsetpwd_Visible',ctrl:'vBTNSETPWD',prop:'Visible'},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''}]}");
      setEventMetadata("'DOINSERT'","{handler:'e141S2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV100Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'cmbavFilusergender'},{av:'AV21FilUserGender',fld:'vFILUSERGENDER',pic:''},{av:'cmbavFilauttype'},{av:'AV18FilAutType',fld:'vFILAUTTYPE',pic:''},{av:'AV40Search',fld:'vSEARCH',pic:''},{av:'cmbavFilrol'},{av:'AV41FilRol',fld:'vFILROL',pic:'ZZZZZZZZZZZ9'},{av:'edtavBtnrole_Title',ctrl:'vBTNROLE',prop:'Title'},{av:'edtavBtnsetpwd_Title',ctrl:'vBTNSETPWD',prop:'Title'},{av:'edtavBtnpermissions_Title',ctrl:'vBTNPERMISSIONS',prop:'Title'},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV24GAMUserIsDeleted',fld:'vGAMUSERISDELETED',pic:'',hsh:true},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'AV23GAMUserIsAutoRegisteredUser',fld:'vGAMUSERISAUTOREGISTEREDUSER',pic:'',hsh:true},{av:'AV44IsAuthorized_Name',fld:'vISAUTHORIZED_NAME',pic:'',hsh:true},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV76ManageFiltersExecutionStep',fld:'vMANAGEFILTERSEXECUTIONSTEP',pic:'9'},{av:'AV26GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV85GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV83FirstIndex',fld:'vFIRSTINDEX',pic:'ZZZ9',hsh:true},{av:'edtavAuthenticationtypename_Visible',ctrl:'vAUTHENTICATIONTYPENAME',prop:'Visible'},{av:'AV27GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV88IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV89IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV90IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV30IsAuthorized_BtnRole',fld:'vISAUTHORIZED_BTNROLE',pic:'',hsh:true},{av:'edtavBtnrole_Visible',ctrl:'vBTNROLE',prop:'Visible'},{av:'AV91IsAuthorized_BtnPermissions',fld:'vISAUTHORIZED_BTNPERMISSIONS',pic:'',hsh:true},{av:'edtavBtnpermissions_Visible',ctrl:'vBTNPERMISSIONS',prop:'Visible'},{av:'AV31IsAuthorized_BtnSetPwd',fld:'vISAUTHORIZED_BTNSETPWD',pic:'',hsh:true},{av:'edtavBtnsetpwd_Visible',ctrl:'vBTNSETPWD',prop:'Visible'},{av:'AV92IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'},{av:'AV80ManageFiltersData',fld:'vMANAGEFILTERSDATA',pic:''},{av:'AV53GridState',fld:'vGRIDSTATE',pic:''}]}");
      setEventMetadata("VBTNUNBLOCKOTPCODES.CLICK","{handler:'e181S2',iparms:[{av:'AV28GUID',fld:'vGUID',pic:'',hsh:true}]");
      setEventMetadata("VBTNUNBLOCKOTPCODES.CLICK",",oparms:[]}");
      setEventMetadata("VALIDV_FILUSERGENDER","{handler:'validv_Filusergender',iparms:[]");
      setEventMetadata("VALIDV_FILUSERGENDER",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Guid',iparms:[]");
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
      return "gamwwusers_Execute";
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
      AV100Pgmname = "" ;
      AV21FilUserGender = "" ;
      AV18FilAutType = "" ;
      AV40Search = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV80ManageFiltersData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV85GridAppliedFilters = "" ;
      AV53GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      lblBtninsert_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV86Display = "" ;
      AV87Update = "" ;
      AV5Delete = "" ;
      AV12BtnRole = "" ;
      AV14BtnPermissions = "" ;
      AV13BtnSetPwd = "" ;
      AV94BtnUnblockOTPCodes = "" ;
      AV34Name = "" ;
      AV22FirstName = "" ;
      AV33LastName = "" ;
      AV9AuthenticationTypeName = "" ;
      AV28GUID = "" ;
      AV49HTTPRequest = httpContext.getHttpRequest();
      AV10AuthenticationTypes = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationType>(genexus.security.api.genexussecurity.SdtGAMAuthenticationType.class, "GAMAuthenticationType", "http://tempuri.org/", remoteHandle);
      AV20FilterAutType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeFilter(remoteHandle, context);
      AV17Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV8AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationType(remoteHandle, context);
      AV45Roles = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRole>(genexus.security.api.genexussecurity.SdtGAMRole.class, "GAMRole", "http://tempuri.org/", remoteHandle);
      AV43FilterRoles = new genexus.security.api.genexussecurity.SdtGAMRoleFilter(remoteHandle, context);
      AV36Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV42Role = new genexus.security.api.genexussecurity.SdtGAMRole(remoteHandle, context);
      AV50WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext4 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV19Filter = new genexus.security.api.genexussecurity.SdtGAMUserFilter(remoteHandle, context);
      AV25GAMUsers = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMUser>(genexus.security.api.genexussecurity.SdtGAMUser.class, "GAMUser", "http://tempuri.org/", remoteHandle);
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV38User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV77ManageFiltersXml = "" ;
      GXt_char5 = "" ;
      GXv_char6 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8 = new GXBaseCollection[1] ;
      AV72Session = httpContext.getWebSession();
      AV54GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_SdtWWPGridState9 = new com.mujermorena.wwpbaseobjects.SdtWWPGridState[1] ;
      GXv_objcol_SdtGAMError3 = new GXExternalCollection[1] ;
      AV95Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      ucDdo_managefilters = new com.genexus.webpanels.GXUserControl();
      Ddo_managefilters_Caption = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwusers__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwwusers__default(),
         new Object[] {
         }
      );
      AV100Pgmname = "GAMWWUsers" ;
      /* GeneXus formulas. */
      AV100Pgmname = "GAMWWUsers" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavBtnrole_Enabled = 0 ;
      edtavBtnpermissions_Enabled = 0 ;
      edtavBtnsetpwd_Enabled = 0 ;
      edtavBtnunblockotpcodes_Enabled = 0 ;
      edtavName_Enabled = 0 ;
      edtavFirstname_Enabled = 0 ;
      edtavLastname_Enabled = 0 ;
      edtavAuthenticationtypename_Enabled = 0 ;
      edtavGuid_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV76ManageFiltersExecutionStep ;
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
   private short AV83FirstIndex ;
   private short wbEnd ;
   private short wbStart ;
   private short AV39GAMUsersCount ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_54 ;
   private int nGXsfl_54_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int lblBtninsert_Visible ;
   private int edtavGamuserscount_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavBtnrole_Enabled ;
   private int edtavBtnpermissions_Enabled ;
   private int edtavBtnsetpwd_Enabled ;
   private int edtavBtnunblockotpcodes_Enabled ;
   private int edtavName_Enabled ;
   private int edtavFirstname_Enabled ;
   private int edtavLastname_Enabled ;
   private int edtavAuthenticationtypename_Enabled ;
   private int edtavGuid_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV98GXV1 ;
   private int AV99GXV2 ;
   private int edtavAuthenticationtypename_Visible ;
   private int AV35PageToGo ;
   private int AV101GXV3 ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int edtavBtnrole_Visible ;
   private int edtavBtnpermissions_Visible ;
   private int edtavBtnsetpwd_Visible ;
   private int AV102GXV4 ;
   private int AV103GXV5 ;
   private int edtavSearch_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavBtnunblockotpcodes_Visible ;
   private int edtavName_Visible ;
   private int edtavFirstname_Visible ;
   private int edtavLastname_Visible ;
   private int edtavGuid_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV41FilRol ;
   private long AV26GridCurrentPage ;
   private long AV27GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long AV6GridPageSize ;
   private long AV7GridRecordCount ;
   private long AV64i ;
   private String edtavBtnrole_Title ;
   private String edtavBtnsetpwd_Title ;
   private String edtavBtnpermissions_Title ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_managefilters_Activeeventkey ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_54_idx="0001" ;
   private String edtavBtnrole_Internalname ;
   private String edtavBtnsetpwd_Internalname ;
   private String edtavBtnpermissions_Internalname ;
   private String AV100Pgmname ;
   private String AV21FilUserGender ;
   private String AV18FilAutType ;
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
   private String ClassString ;
   private String StyleString ;
   private String divTableheader_Internalname ;
   private String divTableactions_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Jsonclick ;
   private String lblBtninsert_Internalname ;
   private String lblBtninsert_Caption ;
   private String lblBtninsert_Jsonclick ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavGamuserscount_Internalname ;
   private String edtavGamuserscount_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV86Display ;
   private String edtavDisplay_Internalname ;
   private String AV87Update ;
   private String edtavUpdate_Internalname ;
   private String AV5Delete ;
   private String edtavDelete_Internalname ;
   private String AV12BtnRole ;
   private String AV14BtnPermissions ;
   private String AV13BtnSetPwd ;
   private String AV94BtnUnblockOTPCodes ;
   private String edtavBtnunblockotpcodes_Internalname ;
   private String edtavName_Internalname ;
   private String AV22FirstName ;
   private String edtavFirstname_Internalname ;
   private String AV33LastName ;
   private String edtavLastname_Internalname ;
   private String AV9AuthenticationTypeName ;
   private String edtavAuthenticationtypename_Internalname ;
   private String AV28GUID ;
   private String edtavGuid_Internalname ;
   private String edtavSearch_Internalname ;
   private String edtavName_Class ;
   private String edtavFirstname_Class ;
   private String edtavLastname_Class ;
   private String edtavAuthenticationtypename_Class ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavUpdate_Class ;
   private String edtavDelete_Link ;
   private String edtavDelete_Class ;
   private String edtavBtnrole_Link ;
   private String edtavBtnpermissions_Link ;
   private String edtavBtnsetpwd_Link ;
   private String edtavBtnsetpwd_Class ;
   private String edtavBtnunblockotpcodes_Class ;
   private String edtavName_Link ;
   private String GXt_char5 ;
   private String GXv_char6[] ;
   private String tblTablerightheader_Internalname ;
   private String Ddo_managefilters_Caption ;
   private String Ddo_managefilters_Internalname ;
   private String divTablefilters_Internalname ;
   private String edtavSearch_Jsonclick ;
   private String sGXsfl_54_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavBtnrole_Jsonclick ;
   private String edtavBtnpermissions_Jsonclick ;
   private String edtavBtnsetpwd_Jsonclick ;
   private String edtavBtnunblockotpcodes_Jsonclick ;
   private String edtavName_Jsonclick ;
   private String edtavFirstname_Jsonclick ;
   private String edtavLastname_Jsonclick ;
   private String edtavAuthenticationtypename_Jsonclick ;
   private String edtavGuid_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_54_Refreshing=false ;
   private boolean AV88IsAuthorized_Display ;
   private boolean AV89IsAuthorized_Update ;
   private boolean AV90IsAuthorized_Delete ;
   private boolean AV24GAMUserIsDeleted ;
   private boolean AV30IsAuthorized_BtnRole ;
   private boolean AV91IsAuthorized_BtnPermissions ;
   private boolean AV31IsAuthorized_BtnSetPwd ;
   private boolean AV23GAMUserIsAutoRegisteredUser ;
   private boolean AV44IsAuthorized_Name ;
   private boolean AV92IsAuthorized_Insert ;
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
   private String AV77ManageFiltersXml ;
   private String AV40Search ;
   private String AV85GridAppliedFilters ;
   private String AV34Name ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV49HTTPRequest ;
   private com.genexus.webpanels.WebSession AV72Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucDdo_managefilters ;
   private genexus.security.api.genexussecurity.SdtGAMUserFilter AV19Filter ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV36Repository ;
   private HTMLChoice cmbavFilusergender ;
   private HTMLChoice cmbavFilauttype ;
   private HTMLChoice cmbavFilrol ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationType> AV10AuthenticationTypes ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV17Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError3[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMUser> AV25GAMUsers ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRole> AV45Roles ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV80ManageFiltersData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXt_objcol_SdtDVB_SDTDropDownOptionsData_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> GXv_objcol_SdtDVB_SDTDropDownOptionsData_Item8[] ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationType AV8AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMError AV95Error ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeFilter AV20FilterAutType ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV38User ;
   private genexus.security.api.genexussecurity.SdtGAMRole AV42Role ;
   private genexus.security.api.genexussecurity.SdtGAMRoleFilter AV43FilterRoles ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV50WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext4[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV53GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState9[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV54GridStateFilterValue ;
}

final  class gamwwusers__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwwusers__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

