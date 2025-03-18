package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pedidoswwcliente_impl extends GXDataArea
{
   public pedidoswwcliente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pedidoswwcliente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pedidoswwcliente_impl.class ));
   }

   public pedidoswwcliente_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPedidosEstado = new HTMLChoice();
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
      nRC_GXsfl_26 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_26"))) ;
      nGXsfl_26_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_26_idx"))) ;
      sGXsfl_26_idx = httpContext.GetPar( "sGXsfl_26_idx") ;
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
      AV40UserName = httpContext.GetPar( "UserName") ;
      AV41ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
      AV28IsAuthorized_Display = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Display")) ;
      AV42IsAuthorized_OpcionEnvioDescripcion = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_OpcionEnvioDescripcion")) ;
      AV44IsAuthorized_Comprobante = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_Comprobante")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
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
      pa7A2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start7A2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.pedidoswwcliente", new String[] {}, new String[] {}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_OPCIONENVIODESCRIPCION", getSecureSignedToken( "", AV42IsAuthorized_OpcionEnvioDescripcion));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_COMPROBANTE", getSecureSignedToken( "", AV44IsAuthorized_Comprobante));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_26", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_26, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV25GridPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vGRIDAPPLIEDFILTERS", AV26GridAppliedFilters);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV28IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_OPCIONENVIODESCRIPCION", AV42IsAuthorized_OpcionEnvioDescripcion);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_OPCIONENVIODESCRIPCION", getSecureSignedToken( "", AV42IsAuthorized_OpcionEnvioDescripcion));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_COMPROBANTE", AV44IsAuthorized_Comprobante);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_COMPROBANTE", getSecureSignedToken( "", AV44IsAuthorized_Comprobante));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERNAME", AV40UserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCLIENTEID", GXutil.ltrim( localUtil.ntoc( AV41ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         we7A2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt7A2( ) ;
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
      return formatLink("com.mujermorena.pedidoswwcliente", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "PedidosWWCliente" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pedidos WWCliente", "") ;
   }

   public void wb7A0( )
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Pedidos", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_PedidosWWCliente.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAdvancedfilterscontainer_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;justify-content:flex-end;", "div");
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
         startgridcontrol26( ) ;
      }
      if ( wbEnd == 26 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_26 = (int)(nGXsfl_26_idx-1) ;
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
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'" + sGXsfl_26_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGridcurrentpage_Internalname, GXutil.ltrim( localUtil.ntoc( AV24GridCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV24GridCurrentPage), "ZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGridcurrentpage_Jsonclick, 0, "Attribute", "", "", "", "", edtavGridcurrentpage_Visible, 1, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PedidosWWCliente.htm");
         /* User Defined Control */
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 26 )
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

   public void start7A2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Pedidos WWCliente", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup7A0( ) ;
   }

   public void ws7A2( )
   {
      start7A2( ) ;
      evt7A2( ) ;
   }

   public void evt7A2( )
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
                           e117A2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e127A2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "'DOCOMPROBANTE'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VCANCELAR.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "'DOCOMPROBANTE'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 15), "VCANCELAR.CLICK") == 0 ) )
                        {
                           nGXsfl_26_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_262( ) ;
                           AV27Display = httpContext.cgiGet( edtavDisplay_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV27Display);
                           AV43Comprobante = httpContext.cgiGet( edtavComprobante_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", AV43Comprobante)==0) ? AV51Comprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV43Comprobante))), !bGXsfl_26_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV43Comprobante), true);
                           AV46Cancelar = httpContext.cgiGet( edtavCancelar_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavCancelar_Internalname, "Bitmap", ((GXutil.strcmp("", AV46Cancelar)==0) ? AV52Cancelar_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV46Cancelar))), !bGXsfl_26_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavCancelar_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV46Cancelar), true);
                           A51PedidosID = localUtil.ctol( httpContext.cgiGet( edtPedidosID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A4ClienteId = localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A246PedidosFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtPedidosFecha_Internalname), 0)) ;
                           cmbPedidosEstado.setName( cmbPedidosEstado.getInternalname() );
                           cmbPedidosEstado.setValue( httpContext.cgiGet( cmbPedidosEstado.getInternalname()) );
                           A247PedidosEstado = httpContext.cgiGet( cmbPedidosEstado.getInternalname()) ;
                           A9TipoPagoId = localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A71TipoPagoNombre = httpContext.cgiGet( edtTipoPagoNombre_Internalname) ;
                           A283OpcionEnvioId = localUtil.ctol( httpContext.cgiGet( edtOpcionEnvioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A284OpcionEnvioDescripcion = httpContext.cgiGet( edtOpcionEnvioDescripcion_Internalname) ;
                           A296PedidosImagenComprobante = httpContext.cgiGet( edtPedidosImagenComprobante_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), !bGXsfl_26_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
                           A295PedidosComprobanteObs = httpContext.cgiGet( edtPedidosComprobanteObs_Internalname) ;
                           A250PedidosSubTotal = localUtil.ctond( httpContext.cgiGet( edtPedidosSubTotal_Internalname)) ;
                           A248PedidosTotal = localUtil.ctond( httpContext.cgiGet( edtPedidosTotal_Internalname)) ;
                           AV38GridBadge = httpContext.cgiGet( edtavGridbadge_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavGridbadge_Internalname, AV38GridBadge);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e137A2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e147A2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e157A2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DOCOMPROBANTE'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoComprobante' */
                                 e167A2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VCANCELAR.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e177A2 ();
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

   public void we7A2( )
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

   public void pa7A2( )
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
            GX_FocusControl = edtavGridcurrentpage_Internalname ;
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
      subsflControlProps_262( ) ;
      while ( nGXsfl_26_idx <= nRC_GXsfl_26 )
      {
         sendrow_262( ) ;
         nGXsfl_26_idx = ((subGrid_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV40UserName ,
                                 long AV41ClienteId ,
                                 boolean AV28IsAuthorized_Display ,
                                 boolean AV42IsAuthorized_OpcionEnvioDescripcion ,
                                 boolean AV44IsAuthorized_Comprobante )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e147A2 ();
      GRID_nCurrentRecord = 0 ;
      rf7A2( ) ;
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
      rf7A2( ) ;
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
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavGridbadge_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGridbadge_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGridbadge_Enabled), 5, 0), !bGXsfl_26_Refreshing);
   }

   public void rf7A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(26) ;
      /* Execute user event: Refresh */
      e147A2 ();
      nGXsfl_26_idx = 1 ;
      sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_262( ) ;
      bGXsfl_26_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_262( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV40UserName ,
                                              Long.valueOf(A4ClienteId) ,
                                              Long.valueOf(AV41ClienteId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG
                                              }
         });
         /* Using cursor H007A3 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV41ClienteId), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_26_idx = 1 ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A295PedidosComprobanteObs = H007A3_A295PedidosComprobanteObs[0] ;
            A296PedidosImagenComprobante = H007A3_A296PedidosImagenComprobante[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), !bGXsfl_26_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
            A40000PedidosImagenComprobante_GXI = H007A3_A40000PedidosImagenComprobante_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), !bGXsfl_26_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
            A284OpcionEnvioDescripcion = H007A3_A284OpcionEnvioDescripcion[0] ;
            A283OpcionEnvioId = H007A3_A283OpcionEnvioId[0] ;
            A71TipoPagoNombre = H007A3_A71TipoPagoNombre[0] ;
            A9TipoPagoId = H007A3_A9TipoPagoId[0] ;
            A247PedidosEstado = H007A3_A247PedidosEstado[0] ;
            A246PedidosFecha = H007A3_A246PedidosFecha[0] ;
            A4ClienteId = H007A3_A4ClienteId[0] ;
            A51PedidosID = H007A3_A51PedidosID[0] ;
            A248PedidosTotal = H007A3_A248PedidosTotal[0] ;
            A250PedidosSubTotal = H007A3_A250PedidosSubTotal[0] ;
            A284OpcionEnvioDescripcion = H007A3_A284OpcionEnvioDescripcion[0] ;
            A71TipoPagoNombre = H007A3_A71TipoPagoNombre[0] ;
            A248PedidosTotal = H007A3_A248PedidosTotal[0] ;
            A250PedidosSubTotal = H007A3_A250PedidosSubTotal[0] ;
            e157A2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(26) ;
         wb7A0( ) ;
      }
      bGXsfl_26_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes7A2( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_DISPLAY", AV28IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_OPCIONENVIODESCRIPCION", AV42IsAuthorized_OpcionEnvioDescripcion);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_OPCIONENVIODESCRIPCION", getSecureSignedToken( "", AV42IsAuthorized_OpcionEnvioDescripcion));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_COMPROBANTE", AV44IsAuthorized_Comprobante);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_COMPROBANTE", getSecureSignedToken( "", AV44IsAuthorized_Comprobante));
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
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV40UserName ,
                                           Long.valueOf(A4ClienteId) ,
                                           Long.valueOf(AV41ClienteId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG
                                           }
      });
      /* Using cursor H007A5 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV41ClienteId)});
      GRID_nRecordCount = H007A5_AGRID_nRecordCount[0] ;
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
      GRID_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
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
         gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
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
         gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      edtavGridbadge_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGridbadge_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGridbadge_Enabled), 5, 0), !bGXsfl_26_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup7A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e137A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_26 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_26"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV25GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV26GridAppliedFilters = httpContext.cgiGet( "vGRIDAPPLIEDFILTERS") ;
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
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGridcurrentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGridcurrentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGRIDCURRENTPAGE");
            GX_FocusControl = edtavGridcurrentpage_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV24GridCurrentPage = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
         }
         else
         {
            AV24GridCurrentPage = localUtil.ctol( httpContext.cgiGet( edtavGridcurrentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
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
      e137A2 ();
      if (returnInSub) return;
   }

   public void e137A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV39GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV40UserName = AV39GAMUser.getgxTv_SdtGAMUser_Name() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40UserName", AV40UserName);
      /* Using cursor H007A6 */
      pr_default.execute(2, new Object[] {AV40UserName});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A244ClienteUser = H007A6_A244ClienteUser[0] ;
         A4ClienteId = H007A6_A4ClienteId[0] ;
         AV41ClienteId = A4ClienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41ClienteId), 11, 0));
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      AV24GridCurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
      edtavGridcurrentpage_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGridcurrentpage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGridcurrentpage_Visible), 5, 0), true);
      AV25GridPageCount = -1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GridPageCount), 10, 0));
      GXt_boolean1 = AV42IsAuthorized_OpcionEnvioDescripcion ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "opcionenvioview_Execute", GXv_boolean2) ;
      pedidoswwcliente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV42IsAuthorized_OpcionEnvioDescripcion = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42IsAuthorized_OpcionEnvioDescripcion", AV42IsAuthorized_OpcionEnvioDescripcion);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_OPCIONENVIODESCRIPCION", getSecureSignedToken( "", AV42IsAuthorized_OpcionEnvioDescripcion));
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e147A2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   private void e157A2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      AV27Display = "<i class=\"fa fa-search\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavDisplay_Internalname, AV27Display);
      if ( AV28IsAuthorized_Display )
      {
         edtavDisplay_Link = formatLink("com.mujermorena.pedidos", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "DSP", ""))),GXutil.URLEncode(GXutil.ltrimstr(A51PedidosID,11,0))}, new String[] {})  ;
      }
      edtavComprobante_gximage = "DDOSortedASC" ;
      AV43Comprobante = context.getHttpContext().getImagePath( "b9f89e2f-f9e1-4533-b84e-c591709915f9", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavComprobante_Internalname, AV43Comprobante);
      AV51Comprobante_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "b9f89e2f-f9e1-4533-b84e-c591709915f9", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavComprobante_Tooltiptext = httpContext.getMessage( "Cargar Comprobante", "") ;
      edtavCancelar_gximage = "ErrorIcon" ;
      AV46Cancelar = context.getHttpContext().getImagePath( "b63f5646-3a80-45fa-b28f-1940d496304c", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCancelar_Internalname, AV46Cancelar);
      AV52Cancelar_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "b63f5646-3a80-45fa-b28f-1940d496304c", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      edtavCancelar_Tooltiptext = httpContext.getMessage( "Cancelar Pedido", "") ;
      if ( AV42IsAuthorized_OpcionEnvioDescripcion )
      {
         edtOpcionEnvioDescripcion_Link = formatLink("com.mujermorena.opcionenvioview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A283OpcionEnvioId,11,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"OpcionEnvioId","TabCode"})  ;
      }
      if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "PEN", "")) == 0 )
      {
         AV38GridBadge = httpContext.getMessage( "Pendiente", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavGridbadge_Internalname, AV38GridBadge);
         edtavGridbadge_Class = " AttributeTagWarning" ;
      }
      else if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "FIN", "")) == 0 )
      {
         AV38GridBadge = httpContext.getMessage( "Confirmado", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavGridbadge_Internalname, AV38GridBadge);
         edtavGridbadge_Class = " AttributeTagSuccess" ;
      }
      else if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "CAN", "")) == 0 )
      {
         AV38GridBadge = httpContext.getMessage( "Cancelado", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavGridbadge_Internalname, AV38GridBadge);
         edtavGridbadge_Class = " AttributeTagDanger" ;
      }
      else
      {
         AV38GridBadge = "" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavGridbadge_Internalname, AV38GridBadge);
         edtavGridbadge_Class = "" ;
      }
      if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "PEN", "")) == 0 )
      {
         edtavCancelar_Visible = 1 ;
      }
      else if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "FIN", "")) == 0 )
      {
         edtavCancelar_Visible = 0 ;
      }
      else if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "ENT", "")) == 0 )
      {
         edtavCancelar_Visible = 0 ;
      }
      else if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "ASD", "")) == 0 )
      {
         edtavCancelar_Visible = 0 ;
      }
      else if ( GXutil.strcmp(A247PedidosEstado, httpContext.getMessage( "CAN", "")) == 0 )
      {
         edtavCancelar_Visible = 0 ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(26) ;
      }
      sendrow_262( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_26_Refreshing )
      {
         httpContext.doAjaxLoad(26, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e117A2( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         AV24GridCurrentPage = (long)(AV24GridCurrentPage-1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         AV24GridCurrentPage = (long)(AV24GridCurrentPage+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
         subgrid_nextpage( ) ;
      }
      else
      {
         AV23PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         AV24GridCurrentPage = AV23PageToGo ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
         subgrid_gotopage( AV23PageToGo) ;
      }
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void e127A2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      AV24GridCurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e167A2( )
   {
      /* 'DoComprobante' Routine */
      returnInSub = false ;
      if ( AV44IsAuthorized_Comprobante )
      {
         httpContext.popup(formatLink("com.mujermorena.cargarcomprobante", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A51PedidosID,11,0))}, new String[] {"PedidosID"}) , new Object[] {"A51PedidosID"});
         httpContext.doAjaxRefresh();
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
   }

   public void e177A2( )
   {
      /* Cancelar_Click Routine */
      returnInSub = false ;
      GXv_int3[0] = A51PedidosID ;
      new com.mujermorena.estadocancelado(remoteHandle, context).execute( GXv_int3) ;
      pedidoswwcliente_impl.this.A51PedidosID = GXv_int3[0] ;
      gxgrgrid_refresh( subGrid_Rows, AV40UserName, AV41ClienteId, AV28IsAuthorized_Display, AV42IsAuthorized_OpcionEnvioDescripcion, AV44IsAuthorized_Comprobante) ;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean1 = AV28IsAuthorized_Display ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "pedidos_Execute", GXv_boolean2) ;
      pedidoswwcliente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV28IsAuthorized_Display = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28IsAuthorized_Display", AV28IsAuthorized_Display);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_DISPLAY", getSecureSignedToken( "", AV28IsAuthorized_Display));
      if ( ! ( AV28IsAuthorized_Display ) )
      {
         edtavDisplay_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDisplay_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDisplay_Visible), 5, 0), !bGXsfl_26_Refreshing);
      }
      GXt_boolean1 = AV44IsAuthorized_Comprobante ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "cargarcomprobante_Execute", GXv_boolean2) ;
      pedidoswwcliente_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV44IsAuthorized_Comprobante = GXt_boolean1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44IsAuthorized_Comprobante", AV44IsAuthorized_Comprobante);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_COMPROBANTE", getSecureSignedToken( "", AV44IsAuthorized_Comprobante));
      if ( ! ( AV44IsAuthorized_Comprobante ) )
      {
         edtavComprobante_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavComprobante_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComprobante_Visible), 5, 0), !bGXsfl_26_Refreshing);
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
      pa7A2( ) ;
      ws7A2( ) ;
      we7A2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111235718", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
         httpContext.AddJavascriptSource("pedidoswwcliente.js", "?202412111235720", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_262( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_26_idx ;
      edtavComprobante_Internalname = "vCOMPROBANTE_"+sGXsfl_26_idx ;
      edtavCancelar_Internalname = "vCANCELAR_"+sGXsfl_26_idx ;
      edtPedidosID_Internalname = "PEDIDOSID_"+sGXsfl_26_idx ;
      edtClienteId_Internalname = "CLIENTEID_"+sGXsfl_26_idx ;
      edtPedidosFecha_Internalname = "PEDIDOSFECHA_"+sGXsfl_26_idx ;
      cmbPedidosEstado.setInternalname( "PEDIDOSESTADO_"+sGXsfl_26_idx );
      edtTipoPagoId_Internalname = "TIPOPAGOID_"+sGXsfl_26_idx ;
      edtTipoPagoNombre_Internalname = "TIPOPAGONOMBRE_"+sGXsfl_26_idx ;
      edtOpcionEnvioId_Internalname = "OPCIONENVIOID_"+sGXsfl_26_idx ;
      edtOpcionEnvioDescripcion_Internalname = "OPCIONENVIODESCRIPCION_"+sGXsfl_26_idx ;
      edtPedidosImagenComprobante_Internalname = "PEDIDOSIMAGENCOMPROBANTE_"+sGXsfl_26_idx ;
      edtPedidosComprobanteObs_Internalname = "PEDIDOSCOMPROBANTEOBS_"+sGXsfl_26_idx ;
      edtPedidosSubTotal_Internalname = "PEDIDOSSUBTOTAL_"+sGXsfl_26_idx ;
      edtPedidosTotal_Internalname = "PEDIDOSTOTAL_"+sGXsfl_26_idx ;
      edtavGridbadge_Internalname = "vGRIDBADGE_"+sGXsfl_26_idx ;
   }

   public void subsflControlProps_fel_262( )
   {
      edtavDisplay_Internalname = "vDISPLAY_"+sGXsfl_26_fel_idx ;
      edtavComprobante_Internalname = "vCOMPROBANTE_"+sGXsfl_26_fel_idx ;
      edtavCancelar_Internalname = "vCANCELAR_"+sGXsfl_26_fel_idx ;
      edtPedidosID_Internalname = "PEDIDOSID_"+sGXsfl_26_fel_idx ;
      edtClienteId_Internalname = "CLIENTEID_"+sGXsfl_26_fel_idx ;
      edtPedidosFecha_Internalname = "PEDIDOSFECHA_"+sGXsfl_26_fel_idx ;
      cmbPedidosEstado.setInternalname( "PEDIDOSESTADO_"+sGXsfl_26_fel_idx );
      edtTipoPagoId_Internalname = "TIPOPAGOID_"+sGXsfl_26_fel_idx ;
      edtTipoPagoNombre_Internalname = "TIPOPAGONOMBRE_"+sGXsfl_26_fel_idx ;
      edtOpcionEnvioId_Internalname = "OPCIONENVIOID_"+sGXsfl_26_fel_idx ;
      edtOpcionEnvioDescripcion_Internalname = "OPCIONENVIODESCRIPCION_"+sGXsfl_26_fel_idx ;
      edtPedidosImagenComprobante_Internalname = "PEDIDOSIMAGENCOMPROBANTE_"+sGXsfl_26_fel_idx ;
      edtPedidosComprobanteObs_Internalname = "PEDIDOSCOMPROBANTEOBS_"+sGXsfl_26_fel_idx ;
      edtPedidosSubTotal_Internalname = "PEDIDOSSUBTOTAL_"+sGXsfl_26_fel_idx ;
      edtPedidosTotal_Internalname = "PEDIDOSTOTAL_"+sGXsfl_26_fel_idx ;
      edtavGridbadge_Internalname = "vGRIDBADGE_"+sGXsfl_26_fel_idx ;
   }

   public void sendrow_262( )
   {
      subsflControlProps_262( ) ;
      wb7A0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_26_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
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
            if ( ((int)((nGXsfl_26_idx) % (2))) == 0 )
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
            httpContext.writeText( " gxrow=\""+sGXsfl_26_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+((edtavDisplay_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 27,'',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDisplay_Internalname,GXutil.rtrim( AV27Display),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDisplay_Enabled!=0)&&(edtavDisplay_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,27);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'",edtavDisplay_Link,"",httpContext.getMessage( "GXM_display", ""),"",edtavDisplay_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(edtavDisplay_Visible),Integer.valueOf(edtavDisplay_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtavComprobante_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavComprobante_Enabled!=0)&&(edtavComprobante_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 28,'',false,'',26)\"" : " ") ;
         ClassString = "ActionBaseColorAttribute" + " " + ((GXutil.strcmp(edtavComprobante_gximage, "")==0) ? "" : "GX_Image_"+edtavComprobante_gximage+"_Class") ;
         StyleString = "" ;
         AV43Comprobante_IsBlob = (boolean)(((GXutil.strcmp("", AV43Comprobante)==0)&&(GXutil.strcmp("", AV51Comprobante_GXI)==0))||!(GXutil.strcmp("", AV43Comprobante)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV43Comprobante)==0) ? AV51Comprobante_GXI : httpContext.getResourceRelative(AV43Comprobante)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavComprobante_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavComprobante_Visible),Integer.valueOf(1),"",edtavComprobante_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavComprobante_Jsonclick,"'"+""+"'"+",false,"+"'"+"E\\'DOCOMPROBANTE\\'."+sGXsfl_26_idx+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV43Comprobante_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+((edtavCancelar_Visible==0) ? "display:none;" : "")+"\">") ;
         }
         /* Active Bitmap Variable */
         TempTags = " " + ((edtavCancelar_Enabled!=0)&&(edtavCancelar_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 29,'',false,'',26)\"" : " ") ;
         ClassString = "ActionBaseColorAttribute" + " " + ((GXutil.strcmp(edtavCancelar_gximage, "")==0) ? "" : "GX_Image_"+edtavCancelar_gximage+"_Class") ;
         StyleString = "" ;
         AV46Cancelar_IsBlob = (boolean)(((GXutil.strcmp("", AV46Cancelar)==0)&&(GXutil.strcmp("", AV52Cancelar_GXI)==0))||!(GXutil.strcmp("", AV46Cancelar)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV46Cancelar)==0) ? AV52Cancelar_GXI : httpContext.getResourceRelative(AV46Cancelar)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavCancelar_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(edtavCancelar_Visible),Integer.valueOf(1),"",edtavCancelar_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavCancelar_Jsonclick,"'"+""+"'"+",false,"+"'"+"EVCANCELAR.CLICK."+sGXsfl_26_idx+"'",StyleString,ClassString,"WWActionColumn","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV46Cancelar_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosID_Internalname,GXutil.ltrim( localUtil.ntoc( A51PedidosID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A51PedidosID), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClienteId_Internalname,GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClienteId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosFecha_Internalname,localUtil.format(A246PedidosFecha, "99/99/99"),localUtil.format( A246PedidosFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosFecha_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbPedidosEstado.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "PEDIDOSESTADO_" + sGXsfl_26_idx ;
            cmbPedidosEstado.setName( GXCCtl );
            cmbPedidosEstado.setWebtags( "" );
            cmbPedidosEstado.addItem("PEN", httpContext.getMessage( "Pendiente", ""), (short)(0));
            cmbPedidosEstado.addItem("FIN", httpContext.getMessage( "Confirmado", ""), (short)(0));
            cmbPedidosEstado.addItem("CAN", httpContext.getMessage( "Cancelado", ""), (short)(0));
            if ( cmbPedidosEstado.getItemCount() > 0 )
            {
               A247PedidosEstado = cmbPedidosEstado.getValidValue(A247PedidosEstado) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbPedidosEstado,cmbPedidosEstado.getInternalname(),GXutil.rtrim( A247PedidosEstado),Integer.valueOf(1),cmbPedidosEstado.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbPedidosEstado.setValue( GXutil.rtrim( A247PedidosEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPedidosEstado.getInternalname(), "Values", cmbPedidosEstado.ToJavascriptSource(), !bGXsfl_26_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipoPagoId_Internalname,GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipoPagoId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtTipoPagoNombre_Internalname,GXutil.rtrim( A71TipoPagoNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtTipoPagoNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpcionEnvioId_Internalname,GXutil.ltrim( localUtil.ntoc( A283OpcionEnvioId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A283OpcionEnvioId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtOpcionEnvioId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtOpcionEnvioDescripcion_Internalname,A284OpcionEnvioDescripcion,"","","'"+""+"'"+",false,"+"'"+""+"'",edtOpcionEnvioDescripcion_Link,"","","",edtOpcionEnvioDescripcion_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         A296PedidosImagenComprobante_IsBlob = (boolean)(((GXutil.strcmp("", A296PedidosImagenComprobante)==0)&&(GXutil.strcmp("", A40000PedidosImagenComprobante_GXI)==0))||!(GXutil.strcmp("", A296PedidosImagenComprobante)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.getResourceRelative(A296PedidosImagenComprobante)) ;
         GridRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtPedidosImagenComprobante_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(A296PedidosImagenComprobante_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosComprobanteObs_Internalname,A295PedidosComprobanteObs,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosComprobanteObs_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(512),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosSubTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A250PedidosSubTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A250PedidosSubTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosSubTotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A248PedidosTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A248PedidosTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosTotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavGridbadge_Enabled!=0)&&(edtavGridbadge_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'',false,'"+sGXsfl_26_idx+"',26)\"" : " ") ;
         ROClassString = edtavGridbadge_Class ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavGridbadge_Internalname,AV38GridBadge,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavGridbadge_Enabled!=0)&&(edtavGridbadge_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,42);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavGridbadge_Jsonclick,Integer.valueOf(0),edtavGridbadge_Class,"",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtavGridbadge_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(26),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes7A2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_26_idx = ((subGrid_Islastpage==1)&&(nGXsfl_26_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_26_idx+1) ;
         sGXsfl_26_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_26_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_262( ) ;
      }
      /* End function sendrow_262 */
   }

   public void startgridcontrol26( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"26\">") ;
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
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ActionBaseColorAttribute"+" "+((GXutil.strcmp(edtavComprobante_gximage, "")==0) ? "" : "GX_Image_"+edtavComprobante_gximage+"_Class")+"\" "+" style=\""+((edtavComprobante_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ActionBaseColorAttribute"+" "+((GXutil.strcmp(edtavCancelar_gximage, "")==0) ? "" : "GX_Image_"+edtavCancelar_gximage+"_Class")+"\" "+" style=\""+((edtavCancelar_Visible==0) ? "display:none;" : "")+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "ID", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Estado", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo Pago Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo Pago Nombre", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opcion Envio Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Opcion Envio Descripcion", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imagen Comprobante", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Comprobante Obs", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Sub Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Total", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavGridbadge_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
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
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( AV27Display));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDisplay_Link));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavDisplay_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV43Comprobante));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavComprobante_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavComprobante_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( AV46Cancelar));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavCancelar_Tooltiptext));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavCancelar_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A51PedidosID, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.format(A246PedidosFecha, "99/99/99"));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A247PedidosEstado));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A71TipoPagoNombre));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A283OpcionEnvioId, (byte)(11), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A284OpcionEnvioDescripcion);
         GridColumn.AddObjectProperty("Link", GXutil.rtrim( edtOpcionEnvioDescripcion_Link));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", httpContext.convertURL( A296PedidosImagenComprobante));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A295PedidosComprobanteObs);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A250PedidosSubTotal, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A248PedidosTotal, (byte)(21), (byte)(2), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", AV38GridBadge);
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtavGridbadge_Class));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavGridbadge_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      divTableactions_Internalname = "TABLEACTIONS" ;
      divTableheadercontent_Internalname = "TABLEHEADERCONTENT" ;
      divAdvancedfilterscontainer_Internalname = "ADVANCEDFILTERSCONTAINER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      edtavDisplay_Internalname = "vDISPLAY" ;
      edtavComprobante_Internalname = "vCOMPROBANTE" ;
      edtavCancelar_Internalname = "vCANCELAR" ;
      edtPedidosID_Internalname = "PEDIDOSID" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtPedidosFecha_Internalname = "PEDIDOSFECHA" ;
      cmbPedidosEstado.setInternalname( "PEDIDOSESTADO" );
      edtTipoPagoId_Internalname = "TIPOPAGOID" ;
      edtTipoPagoNombre_Internalname = "TIPOPAGONOMBRE" ;
      edtOpcionEnvioId_Internalname = "OPCIONENVIOID" ;
      edtOpcionEnvioDescripcion_Internalname = "OPCIONENVIODESCRIPCION" ;
      edtPedidosImagenComprobante_Internalname = "PEDIDOSIMAGENCOMPROBANTE" ;
      edtPedidosComprobanteObs_Internalname = "PEDIDOSCOMPROBANTEOBS" ;
      edtPedidosSubTotal_Internalname = "PEDIDOSSUBTOTAL" ;
      edtPedidosTotal_Internalname = "PEDIDOSTOTAL" ;
      edtavGridbadge_Internalname = "vGRIDBADGE" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavGridcurrentpage_Internalname = "vGRIDCURRENTPAGE" ;
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
      edtavGridbadge_Jsonclick = "" ;
      edtavGridbadge_Class = "Attribute" ;
      edtavGridbadge_Visible = -1 ;
      edtavGridbadge_Enabled = 1 ;
      edtPedidosTotal_Jsonclick = "" ;
      edtPedidosSubTotal_Jsonclick = "" ;
      edtPedidosComprobanteObs_Jsonclick = "" ;
      edtOpcionEnvioDescripcion_Jsonclick = "" ;
      edtOpcionEnvioDescripcion_Link = "" ;
      edtOpcionEnvioId_Jsonclick = "" ;
      edtTipoPagoNombre_Jsonclick = "" ;
      edtTipoPagoId_Jsonclick = "" ;
      cmbPedidosEstado.setJsonclick( "" );
      edtPedidosFecha_Jsonclick = "" ;
      edtClienteId_Jsonclick = "" ;
      edtPedidosID_Jsonclick = "" ;
      edtavCancelar_Jsonclick = "" ;
      edtavCancelar_gximage = "" ;
      edtavCancelar_Enabled = 1 ;
      edtavCancelar_Tooltiptext = httpContext.getMessage( "Cancelar Pedido", "") ;
      edtavCancelar_Visible = -1 ;
      edtavComprobante_Jsonclick = "" ;
      edtavComprobante_gximage = "" ;
      edtavComprobante_Enabled = 1 ;
      edtavComprobante_Tooltiptext = httpContext.getMessage( "Cargar Comprobante", "") ;
      edtavDisplay_Jsonclick = "" ;
      edtavDisplay_Link = "" ;
      edtavDisplay_Enabled = 1 ;
      subGrid_Class = "GridWithPaginationBar WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      edtavComprobante_Visible = -1 ;
      edtavDisplay_Visible = -1 ;
      edtavGridcurrentpage_Jsonclick = "" ;
      edtavGridcurrentpage_Visible = 1 ;
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
      Form.setCaption( httpContext.getMessage( "Pedidos WWCliente", "") );
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "PEDIDOSESTADO_" + sGXsfl_26_idx ;
      cmbPedidosEstado.setName( GXCCtl );
      cmbPedidosEstado.setWebtags( "" );
      cmbPedidosEstado.addItem("PEN", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbPedidosEstado.addItem("FIN", httpContext.getMessage( "Confirmado", ""), (short)(0));
      cmbPedidosEstado.addItem("CAN", httpContext.getMessage( "Cancelado", ""), (short)(0));
      if ( cmbPedidosEstado.getItemCount() > 0 )
      {
         A247PedidosEstado = cmbPedidosEstado.getValidValue(A247PedidosEstado) ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40UserName',fld:'vUSERNAME',pic:''},{av:'AV41ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV42IsAuthorized_OpcionEnvioDescripcion',fld:'vISAUTHORIZED_OPCIONENVIODESCRIPCION',pic:'',hsh:true},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'edtavComprobante_Visible',ctrl:'vCOMPROBANTE',prop:'Visible'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e157A2',iparms:[{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'A51PedidosID',fld:'PEDIDOSID',pic:'ZZZZZZZZZZ9'},{av:'AV42IsAuthorized_OpcionEnvioDescripcion',fld:'vISAUTHORIZED_OPCIONENVIODESCRIPCION',pic:'',hsh:true},{av:'A283OpcionEnvioId',fld:'OPCIONENVIOID',pic:'ZZZZZZZZZZ9'},{av:'cmbPedidosEstado'},{av:'A247PedidosEstado',fld:'PEDIDOSESTADO',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'AV27Display',fld:'vDISPLAY',pic:''},{av:'edtavDisplay_Link',ctrl:'vDISPLAY',prop:'Link'},{av:'AV43Comprobante',fld:'vCOMPROBANTE',pic:''},{av:'edtavComprobante_Tooltiptext',ctrl:'vCOMPROBANTE',prop:'Tooltiptext'},{av:'AV46Cancelar',fld:'vCANCELAR',pic:''},{av:'edtavCancelar_Tooltiptext',ctrl:'vCANCELAR',prop:'Tooltiptext'},{av:'edtOpcionEnvioDescripcion_Link',ctrl:'OPCIONENVIODESCRIPCION',prop:'Link'},{av:'AV38GridBadge',fld:'vGRIDBADGE',pic:''},{av:'edtavGridbadge_Class',ctrl:'vGRIDBADGE',prop:'Class'},{av:'edtavCancelar_Visible',ctrl:'vCANCELAR',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e117A2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40UserName',fld:'vUSERNAME',pic:''},{av:'AV41ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV42IsAuthorized_OpcionEnvioDescripcion',fld:'vISAUTHORIZED_OPCIONENVIODESCRIPCION',pic:'',hsh:true},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'edtavComprobante_Visible',ctrl:'vCOMPROBANTE',prop:'Visible'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e127A2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40UserName',fld:'vUSERNAME',pic:''},{av:'AV41ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV42IsAuthorized_OpcionEnvioDescripcion',fld:'vISAUTHORIZED_OPCIONENVIODESCRIPCION',pic:'',hsh:true},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("'DOCOMPROBANTE'","{handler:'e167A2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40UserName',fld:'vUSERNAME',pic:''},{av:'AV41ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV42IsAuthorized_OpcionEnvioDescripcion',fld:'vISAUTHORIZED_OPCIONENVIODESCRIPCION',pic:'',hsh:true},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'A51PedidosID',fld:'PEDIDOSID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("'DOCOMPROBANTE'",",oparms:[{av:'A51PedidosID',fld:'PEDIDOSID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'edtavComprobante_Visible',ctrl:'vCOMPROBANTE',prop:'Visible'}]}");
      setEventMetadata("VCANCELAR.CLICK","{handler:'e177A2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV40UserName',fld:'vUSERNAME',pic:''},{av:'AV41ClienteId',fld:'vCLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'AV42IsAuthorized_OpcionEnvioDescripcion',fld:'vISAUTHORIZED_OPCIONENVIODESCRIPCION',pic:'',hsh:true},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'A51PedidosID',fld:'PEDIDOSID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VCANCELAR.CLICK",",oparms:[{av:'A51PedidosID',fld:'PEDIDOSID',pic:'ZZZZZZZZZZ9'},{av:'AV28IsAuthorized_Display',fld:'vISAUTHORIZED_DISPLAY',pic:'',hsh:true},{av:'edtavDisplay_Visible',ctrl:'vDISPLAY',prop:'Visible'},{av:'AV44IsAuthorized_Comprobante',fld:'vISAUTHORIZED_COMPROBANTE',pic:'',hsh:true},{av:'edtavComprobante_Visible',ctrl:'vCOMPROBANTE',prop:'Visible'}]}");
      setEventMetadata("VALID_PEDIDOSID","{handler:'valid_Pedidosid',iparms:[]");
      setEventMetadata("VALID_PEDIDOSID",",oparms:[]}");
      setEventMetadata("VALID_TIPOPAGOID","{handler:'valid_Tipopagoid',iparms:[]");
      setEventMetadata("VALID_TIPOPAGOID",",oparms:[]}");
      setEventMetadata("VALID_OPCIONENVIOID","{handler:'valid_Opcionenvioid',iparms:[]");
      setEventMetadata("VALID_OPCIONENVIOID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gridbadge',iparms:[]");
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
      return "pedidoswwcliente_Execute";
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
      AV40UserName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV26GridAppliedFilters = "" ;
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
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV27Display = "" ;
      AV43Comprobante = "" ;
      AV51Comprobante_GXI = "" ;
      AV46Cancelar = "" ;
      AV52Cancelar_GXI = "" ;
      A246PedidosFecha = GXutil.nullDate() ;
      A247PedidosEstado = "" ;
      A71TipoPagoNombre = "" ;
      A284OpcionEnvioDescripcion = "" ;
      A296PedidosImagenComprobante = "" ;
      A40000PedidosImagenComprobante_GXI = "" ;
      A295PedidosComprobanteObs = "" ;
      A250PedidosSubTotal = DecimalUtil.ZERO ;
      A248PedidosTotal = DecimalUtil.ZERO ;
      AV38GridBadge = "" ;
      scmdbuf = "" ;
      H007A3_A295PedidosComprobanteObs = new String[] {""} ;
      H007A3_A296PedidosImagenComprobante = new String[] {""} ;
      H007A3_A40000PedidosImagenComprobante_GXI = new String[] {""} ;
      H007A3_A284OpcionEnvioDescripcion = new String[] {""} ;
      H007A3_A283OpcionEnvioId = new long[1] ;
      H007A3_A71TipoPagoNombre = new String[] {""} ;
      H007A3_A9TipoPagoId = new long[1] ;
      H007A3_A247PedidosEstado = new String[] {""} ;
      H007A3_A246PedidosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H007A3_A4ClienteId = new long[1] ;
      H007A3_A51PedidosID = new long[1] ;
      H007A3_A248PedidosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H007A3_A250PedidosSubTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H007A5_AGRID_nRecordCount = new long[1] ;
      AV39GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      H007A6_A244ClienteUser = new String[] {""} ;
      H007A6_A4ClienteId = new long[1] ;
      A244ClienteUser = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_int3 = new long[1] ;
      GXv_boolean2 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.pedidoswwcliente__default(),
         new Object[] {
             new Object[] {
            H007A3_A295PedidosComprobanteObs, H007A3_A296PedidosImagenComprobante, H007A3_A40000PedidosImagenComprobante_GXI, H007A3_A284OpcionEnvioDescripcion, H007A3_A283OpcionEnvioId, H007A3_A71TipoPagoNombre, H007A3_A9TipoPagoId, H007A3_A247PedidosEstado, H007A3_A246PedidosFecha, H007A3_A4ClienteId,
            H007A3_A51PedidosID, H007A3_A248PedidosTotal, H007A3_A250PedidosSubTotal
            }
            , new Object[] {
            H007A5_AGRID_nRecordCount
            }
            , new Object[] {
            H007A6_A244ClienteUser, H007A6_A4ClienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavDisplay_Enabled = 0 ;
      edtavGridbadge_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_26 ;
   private int subGrid_Rows ;
   private int nGXsfl_26_idx=1 ;
   private int Gridpaginationbar_Pagestoshow ;
   private int edtavGridcurrentpage_Visible ;
   private int subGrid_Islastpage ;
   private int edtavDisplay_Enabled ;
   private int edtavGridbadge_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int edtavCancelar_Visible ;
   private int AV23PageToGo ;
   private int edtavDisplay_Visible ;
   private int edtavComprobante_Visible ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavComprobante_Enabled ;
   private int edtavCancelar_Enabled ;
   private int edtavGridbadge_Visible ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV41ClienteId ;
   private long AV25GridPageCount ;
   private long AV24GridCurrentPage ;
   private long A51PedidosID ;
   private long A4ClienteId ;
   private long A9TipoPagoId ;
   private long A283OpcionEnvioId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long GXv_int3[] ;
   private java.math.BigDecimal A250PedidosSubTotal ;
   private java.math.BigDecimal A248PedidosTotal ;
   private String Gridpaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_26_idx="0001" ;
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
   private String divTableheadercontent_Internalname ;
   private String divTableactions_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String divAdvancedfilterscontainer_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavGridcurrentpage_Internalname ;
   private String edtavGridcurrentpage_Jsonclick ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV27Display ;
   private String edtavDisplay_Internalname ;
   private String edtavComprobante_Internalname ;
   private String edtavCancelar_Internalname ;
   private String edtPedidosID_Internalname ;
   private String edtClienteId_Internalname ;
   private String edtPedidosFecha_Internalname ;
   private String A247PedidosEstado ;
   private String edtTipoPagoId_Internalname ;
   private String A71TipoPagoNombre ;
   private String edtTipoPagoNombre_Internalname ;
   private String edtOpcionEnvioId_Internalname ;
   private String edtOpcionEnvioDescripcion_Internalname ;
   private String edtPedidosImagenComprobante_Internalname ;
   private String edtPedidosComprobanteObs_Internalname ;
   private String edtPedidosSubTotal_Internalname ;
   private String edtPedidosTotal_Internalname ;
   private String edtavGridbadge_Internalname ;
   private String scmdbuf ;
   private String A244ClienteUser ;
   private String edtavDisplay_Link ;
   private String edtavComprobante_gximage ;
   private String edtavComprobante_Tooltiptext ;
   private String edtavCancelar_gximage ;
   private String edtavCancelar_Tooltiptext ;
   private String edtOpcionEnvioDescripcion_Link ;
   private String edtavGridbadge_Class ;
   private String sGXsfl_26_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtavDisplay_Jsonclick ;
   private String sImgUrl ;
   private String edtavComprobante_Jsonclick ;
   private String edtavCancelar_Jsonclick ;
   private String edtPedidosID_Jsonclick ;
   private String edtClienteId_Jsonclick ;
   private String edtPedidosFecha_Jsonclick ;
   private String GXCCtl ;
   private String edtTipoPagoId_Jsonclick ;
   private String edtTipoPagoNombre_Jsonclick ;
   private String edtOpcionEnvioId_Jsonclick ;
   private String edtOpcionEnvioDescripcion_Jsonclick ;
   private String edtPedidosComprobanteObs_Jsonclick ;
   private String edtPedidosSubTotal_Jsonclick ;
   private String edtPedidosTotal_Jsonclick ;
   private String edtavGridbadge_Jsonclick ;
   private String subGrid_Header ;
   private java.util.Date A246PedidosFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV28IsAuthorized_Display ;
   private boolean AV42IsAuthorized_OpcionEnvioDescripcion ;
   private boolean AV44IsAuthorized_Comprobante ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_26_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean AV43Comprobante_IsBlob ;
   private boolean AV46Cancelar_IsBlob ;
   private boolean A296PedidosImagenComprobante_IsBlob ;
   private String AV40UserName ;
   private String AV26GridAppliedFilters ;
   private String AV51Comprobante_GXI ;
   private String AV52Cancelar_GXI ;
   private String A284OpcionEnvioDescripcion ;
   private String A40000PedidosImagenComprobante_GXI ;
   private String A295PedidosComprobanteObs ;
   private String AV38GridBadge ;
   private String AV43Comprobante ;
   private String AV46Cancelar ;
   private String A296PedidosImagenComprobante ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbPedidosEstado ;
   private IDataStoreProvider pr_default ;
   private String[] H007A3_A295PedidosComprobanteObs ;
   private String[] H007A3_A296PedidosImagenComprobante ;
   private String[] H007A3_A40000PedidosImagenComprobante_GXI ;
   private String[] H007A3_A284OpcionEnvioDescripcion ;
   private long[] H007A3_A283OpcionEnvioId ;
   private String[] H007A3_A71TipoPagoNombre ;
   private long[] H007A3_A9TipoPagoId ;
   private String[] H007A3_A247PedidosEstado ;
   private java.util.Date[] H007A3_A246PedidosFecha ;
   private long[] H007A3_A4ClienteId ;
   private long[] H007A3_A51PedidosID ;
   private java.math.BigDecimal[] H007A3_A248PedidosTotal ;
   private java.math.BigDecimal[] H007A3_A250PedidosSubTotal ;
   private long[] H007A5_AGRID_nRecordCount ;
   private String[] H007A6_A244ClienteUser ;
   private long[] H007A6_A4ClienteId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV39GAMUser ;
}

final  class pedidoswwcliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H007A3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV40UserName ,
                                          long A4ClienteId ,
                                          long AV41ClienteId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[PedidosComprobanteObs], T1.[PedidosImagenComprobante], T1.[PedidosImagenComprobante_GXI], T2.[OpcionEnvioDescripcion], T1.[OpcionEnvioId], T3.[TipoPagoNombre]," ;
      sSelectString += " T1.[TipoPagoId], T1.[PedidosEstado], T1.[PedidosFecha], T1.[ClienteId], T1.[PedidosID], COALESCE( T4.[PedidosTotal], 0) AS PedidosTotal, COALESCE( T4.[PedidosTotal]," ;
      sSelectString += " 0) AS PedidosSubTotal" ;
      sFromString = " FROM ((([Pedidos] T1 INNER JOIN [OpcionEnvio] T2 ON T2.[OpcionEnvioId] = T1.[OpcionEnvioId]) INNER JOIN [TipoPago] T3 ON T3.[TipoPagoId] = T1.[TipoPagoId]) LEFT" ;
      sFromString += " JOIN (SELECT T5.[PedidosID], SUM(T6.[ArticuloPrecioVenta] * CAST(T5.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosTotal FROM ([PedidosDetalle] T5 INNER" ;
      sFromString += " JOIN [Articulo] T6 ON T6.[ArticuloId] = T5.[ArticuloId]) GROUP BY T5.[PedidosID] ) T4 ON T4.[PedidosID] = T1.[PedidosID])" ;
      sOrderString = "" ;
      if ( ! ( GXutil.strcmp(AV40UserName, httpContext.getMessage( "admin", "")) == 0 ) )
      {
         addWhere(sWhereString, "(T1.[ClienteId] = ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      sOrderString += " ORDER BY T1.[PedidosID] DESC" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_H007A5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV40UserName ,
                                          long A4ClienteId ,
                                          long AV41ClienteId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((([Pedidos] T1 INNER JOIN [OpcionEnvio] T3 ON T3.[OpcionEnvioId] = T1.[OpcionEnvioId]) INNER JOIN [TipoPago] T2 ON T2.[TipoPagoId] = T1.[TipoPagoId])" ;
      scmdbuf += " LEFT JOIN (SELECT T5.[PedidosID], SUM(T6.[ArticuloPrecioVenta] * CAST(T5.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosTotal FROM ([PedidosDetalle] T5" ;
      scmdbuf += " INNER JOIN [Articulo] T6 ON T6.[ArticuloId] = T5.[ArticuloId]) GROUP BY T5.[PedidosID] ) T4 ON T4.[PedidosID] = T1.[PedidosID])" ;
      if ( ! ( GXutil.strcmp(AV40UserName, httpContext.getMessage( "admin", "")) == 0 ) )
      {
         addWhere(sWhereString, "(T1.[ClienteId] = ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_H007A3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).longValue() );
            case 1 :
                  return conditional_H007A5(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).longValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H007A3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007A5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007A6", "SELECT [ClienteUser], [ClienteId] FROM [Cliente] WHERE [ClienteUser] = ? ORDER BY [ClienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 80);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
                  stmt.setLong(sIdx, ((Number) parms[4]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[1]).longValue());
               }
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 80);
               return;
      }
   }

}

