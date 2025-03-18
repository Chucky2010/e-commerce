package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamwweventsubscriptions_impl extends GXDataArea
{
   public gamwweventsubscriptions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamwweventsubscriptions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamwweventsubscriptions_impl.class ));
   }

   public gamwweventsubscriptions_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavStatus = new HTMLChoice();
      cmbavEvent = new HTMLChoice();
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
      nRC_GXsfl_31 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_31"))) ;
      nGXsfl_31_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_31_idx"))) ;
      sGXsfl_31_idx = httpContext.GetPar( "sGXsfl_31_idx") ;
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
      AV69Pgmname = httpContext.GetPar( "Pgmname") ;
      AV63IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV64IsAuthorized_Update = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Update")) ;
      AV65IsAuthorized_Delete = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Delete")) ;
      AV29IsAuthorized_Description = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Description")) ;
      AV66IsAuthorized_Insert = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Insert")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
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
      pa1P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1P2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamwweventsubscriptions", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV69Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV63IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV65IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DESCRIPTION", getSecureSignedToken( "", AV29IsAuthorized_Description));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV66IsAuthorized_Insert));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_31", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_31, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV57GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV58GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV60GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV69Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV69Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV63IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV63IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV64IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV65IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV65IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DESCRIPTION", AV29IsAuthorized_Description);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DESCRIPTION", getSecureSignedToken( "", AV29IsAuthorized_Description));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV66IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV66IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
         we1P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1P2( ) ;
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
      return formatLink("com.mujermorena.gamwweventsubscriptions", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "GAMWWEventSubscriptions" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_EventSubscriptions", "") ;
   }

   public void wb1P0( )
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMWWEventSubscriptions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtninsert_Internalname, lblBtninsert_Caption, "", "", lblBtninsert_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOINSERT\\'."+"'", "", "MenuOption", 5, "", lblBtninsert_Visible, 1, 0, (short)(1), "HLP_GAMWWEventSubscriptions.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6 CellFloatRight CellWidthAuto", "left", "top", "", "", "div");
         wb_table1_20_1P2( true) ;
      }
      else
      {
         wb_table1_20_1P2( false) ;
      }
      return  ;
   }

   public void wb_table1_20_1P2e( boolean wbgen )
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
         startgridcontrol31( ) ;
      }
      if ( wbEnd == 31 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_31 = (int)(nGXsfl_31_idx-1) ;
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
         ucGridpaginationbar.setProperty("CurrentPage", AV57GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV58GridPageCount);
         ucGridpaginationbar.setProperty("AppliedFilters", AV60GridAppliedFilters);
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
      if ( wbEnd == 31 )
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

   public void start1P2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_EventSubscriptions", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1P0( ) ;
   }

   public void ws1P2( )
   {
      start1P2( ) ;
      evt1P2( ) ;
   }

   public void evt1P2( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e111P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e121P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOINSERT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoInsert' */
                           e131P2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "VSUBSCRIBE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "VSUBSCRIBE.CLICK") == 0 ) )
                        {
                           nGXsfl_31_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_312( ) ;
                           AV61Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV61Display);
                           AV62Update = httpContext.cgiGet( edtavUpdate_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV62Update);
                           AV5Delete = httpContext.cgiGet( edtavDelete_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
                           AV8Description = httpContext.cgiGet( edtavDescription_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDescription_Internalname, AV8Description);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDESCRIPTION"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, GXutil.rtrim( localUtil.format( AV8Description, ""))));
                           cmbavStatus.setName( cmbavStatus.getInternalname() );
                           cmbavStatus.setValue( httpContext.cgiGet( cmbavStatus.getInternalname()) );
                           AV16Status = httpContext.cgiGet( cmbavStatus.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavStatus.getInternalname(), AV16Status);
                           AV24Subscribe = httpContext.cgiGet( edtavSubscribe_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavSubscribe_Internalname, AV24Subscribe);
                           cmbavEvent.setName( cmbavEvent.getInternalname() );
                           cmbavEvent.setValue( httpContext.cgiGet( cmbavEvent.getInternalname()) );
                           AV10Event = httpContext.cgiGet( cmbavEvent.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavEvent.getInternalname(), AV10Event);
                           AV13FileName = httpContext.cgiGet( edtavFilename_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavFilename_Internalname, AV13FileName);
                           AV7ClassName = httpContext.cgiGet( edtavClassname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavClassname_Internalname, AV7ClassName);
                           AV15MethodName = httpContext.cgiGet( edtavMethodname_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavMethodname_Internalname, AV15MethodName);
                           AV14Id = httpContext.cgiGet( edtavId_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV14Id);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, GXutil.rtrim( localUtil.format( AV14Id, ""))));
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e141P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e151P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e161P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VSUBSCRIBE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e171P2 ();
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

   public void we1P2( )
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

   public void pa1P2( )
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
      subsflControlProps_312( ) ;
      while ( nGXsfl_31_idx <= nRC_GXsfl_31 )
      {
         sendrow_312( ) ;
         nGXsfl_31_idx = ((subGrid_Islastpage==1)&&(nGXsfl_31_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_31_idx+1) ;
         sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_312( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV69Pgmname ,
                                 boolean AV63IsAuthorized_Display ,
                                 boolean AV64IsAuthorized_Update ,
                                 boolean AV65IsAuthorized_Delete ,
                                 boolean AV29IsAuthorized_Description ,
                                 boolean AV66IsAuthorized_Insert )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e151P2 ();
      GRID_nCurrentRecord = 0 ;
      rf1P2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV14Id, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.rtrim( AV14Id));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDESCRIPTION", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8Description, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vDESCRIPTION", GXutil.rtrim( AV8Description));
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
      rf1P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV69Pgmname = "GAMWWEventSubscriptions" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDescription_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      cmbavStatus.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavStatus.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavStatus.getEnabled(), 5, 0), !bGXsfl_31_Refreshing);
      edtavSubscribe_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSubscribe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSubscribe_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      cmbavEvent.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavEvent.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEvent.getEnabled(), 5, 0), !bGXsfl_31_Refreshing);
      edtavFilename_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFilename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFilename_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavClassname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClassname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClassname_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavMethodname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMethodname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMethodname_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_31_Refreshing);
   }

   public void rf1P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(31) ;
      /* Execute user event: Refresh */
      e151P2 ();
      nGXsfl_31_idx = 1 ;
      sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_312( ) ;
      bGXsfl_31_Refreshing = true ;
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
         subsflControlProps_312( ) ;
         e161P2 ();
         if ( ( GRID_nCurrentRecord > 0 ) && ( GRID_nGridOutOfScope == 0 ) && ( nGXsfl_31_idx == 1 ) )
         {
            GRID_nCurrentRecord = 0 ;
            GRID_nGridOutOfScope = 1 ;
            subgrid_firstpage( ) ;
            e161P2 ();
         }
         wbEnd = (short)(31) ;
         wb1P0( ) ;
      }
      bGXsfl_31_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1P2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV69Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV69Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV63IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV63IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_UPDATE", AV64IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DELETE", AV65IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV65IsAuthorized_Delete));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DESCRIPTION", AV29IsAuthorized_Description);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DESCRIPTION", getSecureSignedToken( "", AV29IsAuthorized_Description));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_INSERT", AV66IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV66IsAuthorized_Insert));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, GXutil.rtrim( localUtil.format( AV14Id, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDESCRIPTION"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, GXutil.rtrim( localUtil.format( AV8Description, ""))));
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
         gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      subGrid_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV69Pgmname = "GAMWWEventSubscriptions" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavUpdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavDelete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDescription_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      cmbavStatus.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavStatus.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavStatus.getEnabled(), 5, 0), !bGXsfl_31_Refreshing);
      edtavSubscribe_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSubscribe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSubscribe_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      cmbavEvent.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavEvent.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavEvent.getEnabled(), 5, 0), !bGXsfl_31_Refreshing);
      edtavFilename_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFilename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFilename_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavClassname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClassname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClassname_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavMethodname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavMethodname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavMethodname_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), !bGXsfl_31_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e141P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_31 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_31"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV57GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV58GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV60GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
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
         /* Read variables values. */
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
      e141P2 ();
      if (returnInSub) return;
   }

   public void e141P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      lblBtninsert_Caption = GXutil.format( "<i class='fas fa-plus' title='%1'></i>", httpContext.getMessage( "GXM_insert", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Caption", lblBtninsert_Caption, true);
      GXt_boolean1 = AV29IsAuthorized_Description ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gameventsubscriptionentry_Execute", GXv_boolean2) ;
      gamwweventsubscriptions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV29IsAuthorized_Description = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29IsAuthorized_Description", AV29IsAuthorized_Description);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DESCRIPTION", getSecureSignedToken( "", AV29IsAuthorized_Description));
      Form.setCaption( httpContext.getMessage( "WWP_GAM_EventSubscriptions", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S112 ();
      if (returnInSub) return;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void e151P2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV33WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV33WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      AV57GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV57GridCurrentPage), 10, 0));
      GXt_char4 = AV60GridAppliedFilters ;
      GXv_char5[0] = GXt_char4 ;
      new com.mujermorena.wwpbaseobjects.wwp_getappliedfiltersdescription(remoteHandle, context).execute( AV69Pgmname, GXv_char5) ;
      gamwweventsubscriptions_impl.this.GXt_char4 = GXv_char5[0] ;
      AV60GridAppliedFilters = GXt_char4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV60GridAppliedFilters", AV60GridAppliedFilters);
      /*  Sending Event outputs  */
   }

   public void e111P2( )
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
         AV18PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV18PageToGo) ;
      }
   }

   public void e121P2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   private void e161P2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV28GridPageSize = (short)(subGrid_Rows) ;
      GXv_objcol_SdtGAMError6[0] = AV9Errors ;
      AV23GAMEventSubscriptions = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).geteventsubscriptions(AV11EventSubscriptionFilter, GXv_objcol_SdtGAMError6) ;
      AV9Errors = GXv_objcol_SdtGAMError6[0] ;
      if ( AV23GAMEventSubscriptions.size() == 0 )
      {
         AV58GridPageCount = 0 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58GridPageCount), 10, 0));
      }
      else
      {
         AV58GridPageCount = (long)((AV23GAMEventSubscriptions.size()/ (double) (AV28GridPageSize))+((((int)((AV23GAMEventSubscriptions.size()) % (AV28GridPageSize)))>0) ? 1 : 0)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58GridPageCount), 10, 0));
      }
      AV27GridRecordCount = AV23GAMEventSubscriptions.size() ;
      AV70GXV1 = 1 ;
      while ( AV70GXV1 <= AV23GAMEventSubscriptions.size() )
      {
         AV12EventSuscription = (genexus.security.api.genexussecurity.SdtGAMEventSubscription)((genexus.security.api.genexussecurity.SdtGAMEventSubscription)AV23GAMEventSubscriptions.elementAt(-1+AV70GXV1));
         AV14Id = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavId_Internalname, AV14Id);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, GXutil.rtrim( localUtil.format( AV14Id, ""))));
         AV8Description = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Description() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDescription_Internalname, AV8Description);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDESCRIPTION"+"_"+sGXsfl_31_idx, getSecureSignedToken( sGXsfl_31_idx, GXutil.rtrim( localUtil.format( AV8Description, ""))));
         AV16Status = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Status() ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavStatus.getInternalname(), AV16Status);
         AV10Event = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Event() ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavEvent.getInternalname(), AV10Event);
         AV13FileName = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Filename() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavFilename_Internalname, AV13FileName);
         AV7ClassName = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Classname() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavClassname_Internalname, AV7ClassName);
         AV15MethodName = AV12EventSuscription.getgxTv_SdtGAMEventSubscription_Methodname() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavMethodname_Internalname, AV15MethodName);
         AV61Display = "<i class=\"fa fa-search\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV61Display);
         if ( AV63IsAuthorized_Display )
         {
            edtavDisplay_Link = formatLink("com.mujermorena.gameventsubscriptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.rtrim(AV14Id))}, new String[] {"Mode","Id"})  ;
         }
         AV62Update = "<i class=\"fa fa-pen\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavUpdate_Internalname, AV62Update);
         if ( AV64IsAuthorized_Update )
         {
            edtavUpdate_Link = formatLink("com.mujermorena.gameventsubscriptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("UPD")),GXutil.URLEncode(GXutil.rtrim(AV14Id))}, new String[] {"Mode","Id"})  ;
         }
         AV5Delete = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDelete_Internalname, AV5Delete);
         if ( AV65IsAuthorized_Delete )
         {
            edtavDelete_Link = formatLink("com.mujermorena.gameventsubscriptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DLT")),GXutil.URLEncode(GXutil.rtrim(AV14Id))}, new String[] {"Mode","Id"})  ;
         }
         AV24Subscribe = "<i class=\"fa fa-plus\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavSubscribe_Internalname, AV24Subscribe);
         if ( AV29IsAuthorized_Description )
         {
            edtavDescription_Link = formatLink("com.mujermorena.gameventsubscriptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("DSP")),GXutil.URLEncode(GXutil.rtrim(AV14Id))}, new String[] {"Mode","Id"})  ;
         }
         if ( GXutil.strcmp(AV16Status, "s") == 0 )
         {
            AV24Subscribe = "<i class=\"fa fa-minus\"></i>" ;
            httpContext.ajax_rsp_assign_attri("", false, edtavSubscribe_Internalname, AV24Subscribe);
            edtavSubscribe_Tooltiptext = httpContext.getMessage( "Unsubscribe", "") ;
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(31) ;
         }
         if ( ( subGrid_Islastpage == 1 ) || ( subGrid_Rows == 0 ) || ( ( GRID_nCurrentRecord >= GRID_nFirstRecordOnPage ) && ( GRID_nCurrentRecord < GRID_nFirstRecordOnPage + subgrid_fnc_recordsperpage( ) ) ) )
         {
            sendrow_312( ) ;
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
         if ( isFullAjaxMode( ) && ! bGXsfl_31_Refreshing )
         {
            httpContext.doAjaxLoad(31, GridRow);
         }
         AV70GXV1 = (int)(AV70GXV1+1) ;
      }
      /*  Sending Event outputs  */
      cmbavStatus.setValue( GXutil.rtrim( AV16Status) );
      cmbavEvent.setValue( GXutil.rtrim( AV10Event) );
   }

   public void e131P2( )
   {
      /* 'DoInsert' Routine */
      returnInSub = false ;
      if ( AV66IsAuthorized_Insert )
      {
         callWebObject(formatLink("com.mujermorena.gameventsubscriptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("INS")),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"Mode","Id"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV63IsAuthorized_Display ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gameventsubscriptionentry_Execute", GXv_boolean2) ;
      gamwweventsubscriptions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV63IsAuthorized_Display = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63IsAuthorized_Display", AV63IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV63IsAuthorized_Display));
      if ( ! ( AV63IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_31_Refreshing);
      }
      GXt_boolean1 = AV64IsAuthorized_Update ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gameventsubscriptionentry_Execute", GXv_boolean2) ;
      gamwweventsubscriptions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV64IsAuthorized_Update = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64IsAuthorized_Update", AV64IsAuthorized_Update);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_UPDATE", getSecureSignedToken( "", AV64IsAuthorized_Update));
      if ( ! ( AV64IsAuthorized_Update ) )
      {
         edtavUpdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUpdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUpdate_Visible), 5, 0), !bGXsfl_31_Refreshing);
      }
      GXt_boolean1 = AV65IsAuthorized_Delete ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gameventsubscriptionentry_Execute", GXv_boolean2) ;
      gamwweventsubscriptions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV65IsAuthorized_Delete = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65IsAuthorized_Delete", AV65IsAuthorized_Delete);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DELETE", getSecureSignedToken( "", AV65IsAuthorized_Delete));
      if ( ! ( AV65IsAuthorized_Delete ) )
      {
         edtavDelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDelete_Visible), 5, 0), !bGXsfl_31_Refreshing);
      }
      GXt_boolean1 = AV66IsAuthorized_Insert ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "gameventsubscriptionentry_Execute", GXv_boolean2) ;
      gamwweventsubscriptions_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV66IsAuthorized_Insert = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66IsAuthorized_Insert", AV66IsAuthorized_Insert);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_INSERT", getSecureSignedToken( "", AV66IsAuthorized_Insert));
      if ( ! ( AV66IsAuthorized_Insert ) )
      {
         lblBtninsert_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtninsert_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtninsert_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV55Session.getValue(AV69Pgmname+"GridState"), "") == 0 )
      {
         AV36GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV69Pgmname+"GridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV55Session.getValue(AV69Pgmname+"GridState"), null, null);
      }
      if ( ! (GXutil.strcmp("", GXutil.trim( AV36GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV36GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV36GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S132( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV36GridState.fromxml(AV55Session.getValue(AV69Pgmname+"GridState"), null, null);
      AV36GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV36GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV69Pgmname+"GridState", AV36GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void e171P2( )
   {
      /* Subscribe_Click Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV16Status, "u") == 0 )
      {
         GXv_objcol_SdtGAMError6[0] = AV9Errors ;
         AV26isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).subscribeevent(AV14Id, GXv_objcol_SdtGAMError6) ;
         AV9Errors = GXv_objcol_SdtGAMError6[0] ;
         AV16Status = "s" ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavStatus.getInternalname(), AV16Status);
      }
      else
      {
         GXv_objcol_SdtGAMError6[0] = AV9Errors ;
         AV26isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).unsubscribeevent(AV14Id, GXv_objcol_SdtGAMError6) ;
         AV9Errors = GXv_objcol_SdtGAMError6[0] ;
         AV16Status = "u" ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavStatus.getInternalname(), AV16Status);
      }
      if ( ! AV26isOK )
      {
         AV71GXV2 = 1 ;
         while ( AV71GXV2 <= AV9Errors.size() )
         {
            AV25Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV9Errors.elementAt(-1+AV71GXV2));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV25Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV25Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV71GXV2 = (int)(AV71GXV2+1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(AV16Status, "u") == 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "Event ", "")+AV8Description+httpContext.getMessage( " Unsubscription success", ""));
         }
         else
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "Event ", "")+AV8Description+httpContext.getMessage( " subscription success", ""));
         }
         Application.commitDataStores(context, remoteHandle, pr_default, "gamwweventsubscriptions");
         gxgrgrid_refresh( subGrid_Rows, AV69Pgmname, AV63IsAuthorized_Display, AV64IsAuthorized_Update, AV65IsAuthorized_Delete, AV29IsAuthorized_Description, AV66IsAuthorized_Insert) ;
      }
      /*  Sending Event outputs  */
      cmbavStatus.setValue( GXutil.rtrim( AV16Status) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavStatus.getInternalname(), "Values", cmbavStatus.ToJavascriptSource(), true);
   }

   public void wb_table1_20_1P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_20_1P2e( true) ;
      }
      else
      {
         wb_table1_20_1P2e( false) ;
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
      pa1P2( ) ;
      ws1P2( ) ;
      we1P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111161093", true, true);
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
      httpContext.AddJavascriptSource("gamwweventsubscriptions.js", "?20241211116113", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_312( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_31_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_31_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_31_idx ;
      edtavDescription_Internalname = "vDESCRIPTION_"+sGXsfl_31_idx ;
      cmbavStatus.setInternalname( "vSTATUS_"+sGXsfl_31_idx );
      edtavSubscribe_Internalname = "vSUBSCRIBE_"+sGXsfl_31_idx ;
      cmbavEvent.setInternalname( "vEVENT_"+sGXsfl_31_idx );
      edtavFilename_Internalname = "vFILENAME_"+sGXsfl_31_idx ;
      edtavClassname_Internalname = "vCLASSNAME_"+sGXsfl_31_idx ;
      edtavMethodname_Internalname = "vMETHODNAME_"+sGXsfl_31_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_31_idx ;
   }

   public void subsflControlProps_fel_312( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_31_fel_idx ;
      edtavUpdate_Internalname = "vUPDATE_"+sGXsfl_31_fel_idx ;
      edtavDelete_Internalname = "vDELETE_"+sGXsfl_31_fel_idx ;
      edtavDescription_Internalname = "vDESCRIPTION_"+sGXsfl_31_fel_idx ;
      cmbavStatus.setInternalname( "vSTATUS_"+sGXsfl_31_fel_idx );
      edtavSubscribe_Internalname = "vSUBSCRIBE_"+sGXsfl_31_fel_idx ;
      cmbavEvent.setInternalname( "vEVENT_"+sGXsfl_31_fel_idx );
      edtavFilename_Internalname = "vFILENAME_"+sGXsfl_31_fel_idx ;
      edtavClassname_Internalname = "vCLASSNAME_"+sGXsfl_31_fel_idx ;
      edtavMethodname_Internalname = "vMETHODNAME_"+sGXsfl_31_fel_idx ;
      edtavId_Internalname = "vID_"+sGXsfl_31_fel_idx ;
   }

   public void sendrow_312( )
   {
      subsflControlProps_312( ) ;
      wb1P0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_31_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_31_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_31_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 32,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV61Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,32);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavUpdate_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 33,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavUpdate_Internalname,GXutil.rtrim( AV62Update),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavUpdate_Enabled!=0)&&(edtavUpdate_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,33);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavUpdate_Link,"",httpContext.getMessage( "GXM_update", ""),"",edtavUpdate_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavUpdate_Visible),Integer.valueOf(edtavUpdate_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDelete_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 34,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDelete_Internalname,GXutil.rtrim( AV5Delete),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDelete_Enabled!=0)&&(edtavDelete_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,34);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDelete_Link,"",httpContext.getMessage( "GX_BtnDelete", ""),"",edtavDelete_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDelete_Visible),Integer.valueOf(edtavDelete_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDescription_Enabled!=0)&&(edtavDescription_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 35,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDescription_Internalname,GXutil.rtrim( AV8Description),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDescription_Enabled!=0)&&(edtavDescription_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,35);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDescription_Link,"","","",edtavDescription_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDescription_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavStatus.getEnabled()!=0)&&(cmbavStatus.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 36,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         if ( ( cmbavStatus.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vSTATUS_" + sGXsfl_31_idx ;
            cmbavStatus.setName( GXCCtl );
            cmbavStatus.setWebtags( "" );
            cmbavStatus.addItem("u", httpContext.getMessage( "WWP_GAM_Unsubscribed", ""), (short)(0));
            cmbavStatus.addItem("s", httpContext.getMessage( "WWP_GAM_Subscribed", ""), (short)(0));
            if ( cmbavStatus.getItemCount() > 0 )
            {
               AV16Status = cmbavStatus.getValidValue(AV16Status) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavStatus.getInternalname(), AV16Status);
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavStatus,cmbavStatus.getInternalname(),GXutil.rtrim( AV16Status),Integer.valueOf(1),cmbavStatus.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavStatus.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavStatus.getEnabled()!=0)&&(cmbavStatus.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,36);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavStatus.setValue( GXutil.rtrim( AV16Status) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavStatus.getInternalname(), "Values", cmbavStatus.ToJavascriptSource(), !bGXsfl_31_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavSubscribe_Enabled!=0)&&(edtavSubscribe_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 37,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSubscribe_Internalname,GXutil.rtrim( AV24Subscribe),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSubscribe_Enabled!=0)&&(edtavSubscribe_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,37);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVSUBSCRIBE.CLICK."+sGXsfl_31_idx+"'","","",edtavSubscribe_Tooltiptext,"",edtavSubscribe_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSubscribe_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavEvent.getEnabled()!=0)&&(cmbavEvent.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 38,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         if ( ( cmbavEvent.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vEVENT_" + sGXsfl_31_idx ;
            cmbavEvent.setName( GXCCtl );
            cmbavEvent.setWebtags( "" );
            cmbavEvent.addItem("user-update", httpContext.getMessage( "WWP_GAM_UserUpdate", ""), (short)(0));
            cmbavEvent.addItem("user-insert", httpContext.getMessage( "WWP_GAM_UserInsert", ""), (short)(0));
            cmbavEvent.addItem("user-delete", httpContext.getMessage( "WWP_GAM_UserDelete", ""), (short)(0));
            cmbavEvent.addItem("user-updateroles", httpContext.getMessage( "WWP_GAM_UserUpdateRoles", ""), (short)(0));
            cmbavEvent.addItem("user-getcustominfo", httpContext.getMessage( "WWP_GAM_UserGetCustomInfo", ""), (short)(0));
            cmbavEvent.addItem("user-savecustominfo", httpContext.getMessage( "WWP_GAM_UserSaveCustomInfo", ""), (short)(0));
            cmbavEvent.addItem("role-insert", httpContext.getMessage( "WWP_GAM_RoleInsert", ""), (short)(0));
            cmbavEvent.addItem("role-update", httpContext.getMessage( "WWP_GAM_RoleUpdate", ""), (short)(0));
            cmbavEvent.addItem("role-delete", httpContext.getMessage( "WWP_GAM_RoleDelete", ""), (short)(0));
            cmbavEvent.addItem("repository-login", httpContext.getMessage( "WWP_GAM_RepositoryLogin", ""), (short)(0));
            cmbavEvent.addItem("repository-logout", httpContext.getMessage( "WWP_GAM_RepositoryLogout", ""), (short)(0));
            cmbavEvent.addItem("application-checkprmfail", httpContext.getMessage( "WWP_GAM_AppCheckFail", ""), (short)(0));
            cmbavEvent.addItem("externalauthentication-response", httpContext.getMessage( "WWP_GAM_ExternalAuthResponse", ""), (short)(0));
            if ( cmbavEvent.getItemCount() > 0 )
            {
               AV10Event = cmbavEvent.getValidValue(AV10Event) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavEvent.getInternalname(), AV10Event);
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavEvent,cmbavEvent.getInternalname(),GXutil.rtrim( AV10Event),Integer.valueOf(1),cmbavEvent.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavEvent.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavEvent.getEnabled()!=0)&&(cmbavEvent.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,38);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavEvent.setValue( GXutil.rtrim( AV10Event) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEvent.getInternalname(), "Values", cmbavEvent.ToJavascriptSource(), !bGXsfl_31_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavFilename_Enabled!=0)&&(edtavFilename_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 39,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavFilename_Internalname,GXutil.rtrim( AV13FileName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavFilename_Enabled!=0)&&(edtavFilename_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,39);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavFilename_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavFilename_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(570),"px",Integer.valueOf(17),"px",Integer.valueOf(254),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionLong","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavClassname_Enabled!=0)&&(edtavClassname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 40,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavClassname_Internalname,GXutil.rtrim( AV7ClassName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavClassname_Enabled!=0)&&(edtavClassname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,40);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavClassname_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavClassname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionShort","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavMethodname_Enabled!=0)&&(edtavMethodname_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 41,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavMethodname_Internalname,GXutil.rtrim( AV15MethodName),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavMethodname_Enabled!=0)&&(edtavMethodname_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,41);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavMethodname_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavMethodname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMDescriptionShort","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'',false,'"+sGXsfl_31_idx+"',31)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavId_Internalname,GXutil.rtrim( AV14Id),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavId_Enabled!=0)&&(edtavId_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,42);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavId_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(31),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes1P2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_31_idx = ((subGrid_Islastpage==1)&&(nGXsfl_31_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_31_idx+1) ;
         sGXsfl_31_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_31_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_312( ) ;
      }
      /* End function sendrow_312 */
   }

   public void startgridcontrol31( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"31\">") ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_EventDescription", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Status", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_Entity", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(570), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_FileName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_ClassName", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_MethodName", "")) ;
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV61Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV62Update));
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
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV8Description));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDescription_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDescription_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV16Status));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavStatus.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV24Subscribe));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSubscribe_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavSubscribe_Tooltiptext));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV10Event));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavEvent.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV13FileName));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavFilename_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV7ClassName));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavClassname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV15MethodName));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavMethodname_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV14Id));
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
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavUpdate_Internalname = "vUPDATE" ;
      edtavDelete_Internalname = "vDELETE" ;
      edtavDescription_Internalname = "vDESCRIPTION" ;
      cmbavStatus.setInternalname( "vSTATUS" );
      edtavSubscribe_Internalname = "vSUBSCRIBE" ;
      cmbavEvent.setInternalname( "vEVENT" );
      edtavFilename_Internalname = "vFILENAME" ;
      edtavClassname_Internalname = "vCLASSNAME" ;
      edtavMethodname_Internalname = "vMETHODNAME" ;
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
      edtavMethodname_Jsonclick = "" ;
      edtavMethodname_Visible = -1 ;
      edtavMethodname_Enabled = 1 ;
      edtavClassname_Jsonclick = "" ;
      edtavClassname_Visible = -1 ;
      edtavClassname_Enabled = 1 ;
      edtavFilename_Jsonclick = "" ;
      edtavFilename_Visible = -1 ;
      edtavFilename_Enabled = 1 ;
      cmbavEvent.setJsonclick( "" );
      cmbavEvent.setVisible( -1 );
      cmbavEvent.setEnabled( 1 );
      edtavSubscribe_Jsonclick = "" ;
      edtavSubscribe_Visible = -1 ;
      edtavSubscribe_Tooltiptext = httpContext.getMessage( "Subscribe", "") ;
      edtavSubscribe_Enabled = 1 ;
      cmbavStatus.setJsonclick( "" );
      cmbavStatus.setVisible( -1 );
      cmbavStatus.setEnabled( 1 );
      edtavDescription_Jsonclick = "" ;
      edtavDescription_Visible = -1 ;
      edtavDescription_Link = "" ;
      edtavDescription_Enabled = 1 ;
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
      edtavDelete_Visible = -1 ;
      edtavUpdate_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_GAM_EventSubscriptions", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "vSTATUS_" + sGXsfl_31_idx ;
      cmbavStatus.setName( GXCCtl );
      cmbavStatus.setWebtags( "" );
      cmbavStatus.addItem("u", httpContext.getMessage( "WWP_GAM_Unsubscribed", ""), (short)(0));
      cmbavStatus.addItem("s", httpContext.getMessage( "WWP_GAM_Subscribed", ""), (short)(0));
      if ( cmbavStatus.getItemCount() > 0 )
      {
         AV16Status = cmbavStatus.getValidValue(AV16Status) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavStatus.getInternalname(), AV16Status);
      }
      GXCCtl = "vEVENT_" + sGXsfl_31_idx ;
      cmbavEvent.setName( GXCCtl );
      cmbavEvent.setWebtags( "" );
      cmbavEvent.addItem("user-update", httpContext.getMessage( "WWP_GAM_UserUpdate", ""), (short)(0));
      cmbavEvent.addItem("user-insert", httpContext.getMessage( "WWP_GAM_UserInsert", ""), (short)(0));
      cmbavEvent.addItem("user-delete", httpContext.getMessage( "WWP_GAM_UserDelete", ""), (short)(0));
      cmbavEvent.addItem("user-updateroles", httpContext.getMessage( "WWP_GAM_UserUpdateRoles", ""), (short)(0));
      cmbavEvent.addItem("user-getcustominfo", httpContext.getMessage( "WWP_GAM_UserGetCustomInfo", ""), (short)(0));
      cmbavEvent.addItem("user-savecustominfo", httpContext.getMessage( "WWP_GAM_UserSaveCustomInfo", ""), (short)(0));
      cmbavEvent.addItem("role-insert", httpContext.getMessage( "WWP_GAM_RoleInsert", ""), (short)(0));
      cmbavEvent.addItem("role-update", httpContext.getMessage( "WWP_GAM_RoleUpdate", ""), (short)(0));
      cmbavEvent.addItem("role-delete", httpContext.getMessage( "WWP_GAM_RoleDelete", ""), (short)(0));
      cmbavEvent.addItem("repository-login", httpContext.getMessage( "WWP_GAM_RepositoryLogin", ""), (short)(0));
      cmbavEvent.addItem("repository-logout", httpContext.getMessage( "WWP_GAM_RepositoryLogout", ""), (short)(0));
      cmbavEvent.addItem("application-checkprmfail", httpContext.getMessage( "WWP_GAM_AppCheckFail", ""), (short)(0));
      cmbavEvent.addItem("externalauthentication-response", httpContext.getMessage( "WWP_GAM_ExternalAuthResponse", ""), (short)(0));
      if ( cmbavEvent.getItemCount() > 0 )
      {
         AV10Event = cmbavEvent.getValidValue(AV10Event) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavEvent.getInternalname(), AV10Event);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV69Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29IsAuthorized_Description',fld:'vISAUTHORIZED_DESCRIPTION',pic:'',hsh:true},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV57GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV60GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e111P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV69Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29IsAuthorized_Description',fld:'vISAUTHORIZED_DESCRIPTION',pic:'',hsh:true},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e121P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV69Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29IsAuthorized_Description',fld:'vISAUTHORIZED_DESCRIPTION',pic:'',hsh:true},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e161P2',iparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29IsAuthorized_Description',fld:'vISAUTHORIZED_DESCRIPTION',pic:'',hsh:true}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV58GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV14Id',fld:'vID',pic:'',hsh:true},{av:'AV8Description',fld:'vDESCRIPTION',pic:'',hsh:true},{av:'cmbavStatus'},{av:'AV16Status',fld:'vSTATUS',pic:''},{av:'cmbavEvent'},{av:'AV10Event',fld:'vEVENT',pic:''},{av:'AV13FileName',fld:'vFILENAME',pic:''},{av:'AV7ClassName',fld:'vCLASSNAME',pic:''},{av:'AV15MethodName',fld:'vMETHODNAME',pic:''},{av:'AV61Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV62Update',fld:'vUPDATE',pic:''},{av:'edtavUpdate_Link',ctrl:'vUPDATE',prop:'Link'},{av:'AV5Delete',fld:'vDELETE',pic:''},{av:'edtavDelete_Link',ctrl:'vDELETE',prop:'Link'},{av:'AV24Subscribe',fld:'vSUBSCRIBE',pic:''},{av:'edtavDescription_Link',ctrl:'vDESCRIPTION',prop:'Link'},{av:'edtavSubscribe_Tooltiptext',ctrl:'vSUBSCRIBE',prop:'Tooltiptext'}]}");
      setEventMetadata("'DOINSERT'","{handler:'e131P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV69Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29IsAuthorized_Description',fld:'vISAUTHORIZED_DESCRIPTION',pic:'',hsh:true},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true}]");
      setEventMetadata("'DOINSERT'",",oparms:[{av:'AV57GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV60GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'}]}");
      setEventMetadata("VSUBSCRIBE.CLICK","{handler:'e171P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV69Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'AV29IsAuthorized_Description',fld:'vISAUTHORIZED_DESCRIPTION',pic:'',hsh:true},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'cmbavStatus'},{av:'AV16Status',fld:'vSTATUS',pic:''},{av:'AV14Id',fld:'vID',pic:'',hsh:true},{av:'AV8Description',fld:'vDESCRIPTION',pic:'',hsh:true}]");
      setEventMetadata("VSUBSCRIBE.CLICK",",oparms:[{av:'cmbavStatus'},{av:'AV16Status',fld:'vSTATUS',pic:''},{av:'AV57GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV60GridAppliedFilters',fld:'vGRIDAPPLIEDFILTERS',pic:''},{av:'AV63IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV64IsAuthorized_Update',fld:'vISAUTHORIZED_UPDATE',pic:'',hsh:true},{av:'edtavUpdate_Visible',ctrl:'vUPDATE',prop:'Visible'},{av:'AV65IsAuthorized_Delete',fld:'vISAUTHORIZED_DELETE',pic:'',hsh:true},{av:'edtavDelete_Visible',ctrl:'vDELETE',prop:'Visible'},{av:'AV66IsAuthorized_Insert',fld:'vISAUTHORIZED_INSERT',pic:'',hsh:true},{av:'lblBtninsert_Visible',ctrl:'BTNINSERT',prop:'Visible'}]}");
      setEventMetadata("VALIDV_EVENT","{handler:'validv_Event',iparms:[]");
      setEventMetadata("VALIDV_EVENT",",oparms:[]}");
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
      return "gamwweventsubscriptions_Execute";
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV69Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV60GridAppliedFilters = "" ;
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
      AV61Display = "" ;
      AV62Update = "" ;
      AV5Delete = "" ;
      AV8Description = "" ;
      AV16Status = "" ;
      AV24Subscribe = "" ;
      AV10Event = "" ;
      AV13FileName = "" ;
      AV7ClassName = "" ;
      AV15MethodName = "" ;
      AV14Id = "" ;
      AV33WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV23GAMEventSubscriptions = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription>(genexus.security.api.genexussecurity.SdtGAMEventSubscription.class, "GAMEventSubscription", "http://tempuri.org/", remoteHandle);
      AV11EventSubscriptionFilter = new genexus.security.api.genexussecurity.SdtGAMEventSubscriptionFilter(remoteHandle, context);
      AV9Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV12EventSuscription = new genexus.security.api.genexussecurity.SdtGAMEventSubscription(remoteHandle, context);
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_boolean2 = new boolean[1] ;
      AV55Session = httpContext.getWebSession();
      AV36GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      GXv_objcol_SdtGAMError6 = new GXExternalCollection[1] ;
      AV25Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      TempTags = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwweventsubscriptions__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamwweventsubscriptions__default(),
         new Object[] {
         }
      );
      AV69Pgmname = "GAMWWEventSubscriptions" ;
      /* GeneXus formulas. */
      AV69Pgmname = "GAMWWEventSubscriptions" ;
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavUpdate_Enabled = 0 ;
      edtavDelete_Enabled = 0 ;
      edtavDescription_Enabled = 0 ;
      cmbavStatus.setEnabled( 0 );
      edtavSubscribe_Enabled = 0 ;
      cmbavEvent.setEnabled( 0 );
      edtavFilename_Enabled = 0 ;
      edtavClassname_Enabled = 0 ;
      edtavMethodname_Enabled = 0 ;
      edtavId_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
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
   private short AV28GridPageSize ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_31 ;
   private int nGXsfl_31_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int lblBtninsert_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavUpdate_Enabled ;
   private int edtavDelete_Enabled ;
   private int edtavDescription_Enabled ;
   private int edtavSubscribe_Enabled ;
   private int edtavFilename_Enabled ;
   private int edtavClassname_Enabled ;
   private int edtavMethodname_Enabled ;
   private int edtavId_Enabled ;
   private int GRID_nGridOutOfScope ;
   private int subGrid_Recordcount ;
   private int AV18PageToGo ;
   private int AV70GXV1 ;
   private int edtavDisplay_Visible ;
   private int edtavUpdate_Visible ;
   private int edtavDelete_Visible ;
   private int AV71GXV2 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavDescription_Visible ;
   private int edtavSubscribe_Visible ;
   private int edtavFilename_Visible ;
   private int edtavClassname_Visible ;
   private int edtavMethodname_Visible ;
   private int edtavId_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV57GridCurrentPage ;
   private long AV58GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long AV27GridRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_31_idx="0001" ;
   private String AV69Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
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
   private String AV61Display ;
   private String edtavDisplay_Internalname ;
   private String AV62Update ;
   private String edtavUpdate_Internalname ;
   private String AV5Delete ;
   private String edtavDelete_Internalname ;
   private String AV8Description ;
   private String edtavDescription_Internalname ;
   private String AV16Status ;
   private String AV24Subscribe ;
   private String edtavSubscribe_Internalname ;
   private String AV10Event ;
   private String AV13FileName ;
   private String edtavFilename_Internalname ;
   private String AV7ClassName ;
   private String edtavClassname_Internalname ;
   private String AV15MethodName ;
   private String edtavMethodname_Internalname ;
   private String AV14Id ;
   private String edtavId_Internalname ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String edtavDisplay_Link ;
   private String edtavUpdate_Link ;
   private String edtavDelete_Link ;
   private String edtavDescription_Link ;
   private String edtavSubscribe_Tooltiptext ;
   private String tblTablerightheader_Internalname ;
   private String sGXsfl_31_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String TempTags ;
   private String ROClassString ;
   private String edtavDisplay_Jsonclick ;
   private String edtavUpdate_Jsonclick ;
   private String edtavDelete_Jsonclick ;
   private String edtavDescription_Jsonclick ;
   private String GXCCtl ;
   private String edtavSubscribe_Jsonclick ;
   private String edtavFilename_Jsonclick ;
   private String edtavClassname_Jsonclick ;
   private String edtavMethodname_Jsonclick ;
   private String edtavId_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV63IsAuthorized_Display ;
   private boolean AV64IsAuthorized_Update ;
   private boolean AV65IsAuthorized_Delete ;
   private boolean AV29IsAuthorized_Description ;
   private boolean AV66IsAuthorized_Insert ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_31_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean AV26isOK ;
   private String AV60GridAppliedFilters ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV55Session ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbavStatus ;
   private HTMLChoice cmbavEvent ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV9Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError6[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMEventSubscription> AV23GAMEventSubscriptions ;
   private genexus.security.api.genexussecurity.SdtGAMError AV25Error ;
   private genexus.security.api.genexussecurity.SdtGAMEventSubscriptionFilter AV11EventSubscriptionFilter ;
   private genexus.security.api.genexussecurity.SdtGAMEventSubscription AV12EventSuscription ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV33WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV36GridState ;
}

final  class gamwweventsubscriptions__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamwweventsubscriptions__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

