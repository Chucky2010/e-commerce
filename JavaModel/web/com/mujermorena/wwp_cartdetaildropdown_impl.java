package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_cartdetaildropdown_impl extends GXWebComponent
{
   public wwp_cartdetaildropdown_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_cartdetaildropdown_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_cartdetaildropdown_impl.class ));
   }

   public wwp_cartdetaildropdown_impl( int remoteHandle ,
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
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix});
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Griddvelop_ecommercecarts") == 0 )
            {
               gxnrgriddvelop_ecommercecarts_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Griddvelop_ecommercecarts") == 0 )
            {
               gxgrgriddvelop_ecommercecarts_refresh_invoke( ) ;
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

   public void gxnrgriddvelop_ecommercecarts_newrow_invoke( )
   {
      nRC_GXsfl_24 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_24"))) ;
      nGXsfl_24_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_24_idx"))) ;
      sGXsfl_24_idx = httpContext.GetPar( "sGXsfl_24_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgriddvelop_ecommercecarts_newrow( ) ;
      /* End function gxnrGriddvelop_ecommercecarts_newrow_invoke */
   }

   public void gxgrgriddvelop_ecommercecarts_refresh_invoke( )
   {
      subGriddvelop_ecommercecarts_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGriddvelop_ecommercecarts_Rows"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV8DVelop_ECommerceCart);
      AV20Qty = (short)(GXutil.lval( httpContext.GetPar( "Qty"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGriddvelop_ecommercecarts_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa2N2( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "WWP_Cart Detail Drop Down", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwp_cartdetaildropdown", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQTY", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20Qty), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Dvelop_ecommercecart", AV8DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Dvelop_ecommercecart", AV8DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_24", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_24, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDVELOP_ECOMMERCECART", AV8DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDVELOP_ECOMMERCECART", AV8DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vQTY", GXutil.ltrim( localUtil.ntoc( AV20Qty, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQTY", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20Qty), "ZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_Rows", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_EMPOWERER_Gridinternalname", GXutil.rtrim( Griddvelop_ecommercecarts_empowerer_Gridinternalname));
   }

   public void renderHtmlCloseForm2N2( )
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
      return "WWP_CartDetailDropDown" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_Cart Detail Drop Down", "") ;
   }

   public void wb2N0( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwp_cartdetaildropdown");
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablefilters_Internalname, divTablefilters_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "WWP_CartEmpty", ""), "", "", lblTextblock1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "ActionAttribute", 0, "", 1, 1, 0, (short)(0), "HLP_WWP_CartDetailDropDown.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablegrid_Internalname, divTablegrid_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellGridCartECommerce HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGriddvelop_ecommercecartstablewithtotalizers_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Griddvelop_ecommercecartsContainer.SetWrapped(nGXWrapped);
         startgridcontrol24( ) ;
      }
      if ( wbEnd == 24 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_24 = (int)(nGXsfl_24_idx-1) ;
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Griddvelop_ecommercecartsContainer.AddObjectProperty("GRIDDVELOP_ECOMMERCECARTS_nEOF", GRIDDVELOP_ECOMMERCECARTS_nEOF);
            Griddvelop_ecommercecartsContainer.AddObjectProperty("GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage);
            AV23GXV1 = nGXsfl_24_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"Griddvelop_ecommercecartsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Griddvelop_ecommercecarts", Griddvelop_ecommercecartsContainer, subGriddvelop_ecommercecarts_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Griddvelop_ecommercecartsContainerData", Griddvelop_ecommercecartsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Griddvelop_ecommercecartsContainerData"+"V", Griddvelop_ecommercecartsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Griddvelop_ecommercecartsContainerData"+"V"+"\" value='"+Griddvelop_ecommercecartsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row Invisible", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_35_2N2( true) ;
      }
      else
      {
         wb_table1_35_2N2( false) ;
      }
      return  ;
   }

   public void wb_table1_35_2N2e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Right", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "Button ButtonWizard ButtonECommerce" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 24, 2, 0)+","+"null"+");", httpContext.getMessage( "Pasar por la Caja", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWP_CartDetailDropDown.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
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
         ucGriddvelop_ecommercecarts_empowerer.render(context, "wwp.gridempowerer", Griddvelop_ecommercecarts_empowerer_Internalname, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 24 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Griddvelop_ecommercecartsContainer.AddObjectProperty("GRIDDVELOP_ECOMMERCECARTS_nEOF", GRIDDVELOP_ECOMMERCECARTS_nEOF);
               Griddvelop_ecommercecartsContainer.AddObjectProperty("GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage);
               AV23GXV1 = nGXsfl_24_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"Griddvelop_ecommercecartsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Griddvelop_ecommercecarts", Griddvelop_ecommercecartsContainer, subGriddvelop_ecommercecarts_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Griddvelop_ecommercecartsContainerData", Griddvelop_ecommercecartsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Griddvelop_ecommercecartsContainerData"+"V", Griddvelop_ecommercecartsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Griddvelop_ecommercecartsContainerData"+"V"+"\" value='"+Griddvelop_ecommercecartsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2N2( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "WWP_Cart Detail Drop Down", ""), (short)(0)) ;
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
            strup2N0( ) ;
         }
      }
   }

   public void ws2N2( )
   {
      start2N2( ) ;
      evt2N2( ) ;
   }

   public void evt2N2( )
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
                              strup2N0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2N0( ) ;
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
                                       e112N2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2N0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDDVELOP_ECOMMERCECARTSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2N0( ) ;
                           }
                           sEvt = httpContext.cgiGet( sPrefix+"GRIDDVELOP_ECOMMERCECARTSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgriddvelop_ecommercecarts_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgriddvelop_ecommercecarts_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgriddvelop_ecommercecarts_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgriddvelop_ecommercecarts_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 30), "GRIDDVELOP_ECOMMERCECARTS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 40), "DVELOP_ECOMMERCECART__PRODUCTQTY.ISVALID") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 17), "VREMOVEITEM.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 17), "VREMOVEITEM.CLICK") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup2N0( ) ;
                           }
                           nGXsfl_24_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_242( ) ;
                           AV23GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
                           if ( ( AV8DVelop_ECommerceCart.size() >= AV23GXV1 ) && ( AV23GXV1 > 0 ) )
                           {
                              AV8DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)) );
                              AV7ProductImage = httpContext.cgiGet( edtavProductimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProductimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV7ProductImage)==0) ? AV30Productimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV7ProductImage))), !bGXsfl_24_Refreshing);
                              httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProductimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV7ProductImage), true);
                              if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
                              {
                                 httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTTOTAL");
                                 GX_FocusControl = edtavProducttotal_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                 wbErr = true ;
                                 AV10ProductTotal = DecimalUtil.ZERO ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProducttotal_Internalname, GXutil.ltrimstr( AV10ProductTotal, 8, 2));
                              }
                              else
                              {
                                 AV10ProductTotal = localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProducttotal_Internalname, GXutil.ltrimstr( AV10ProductTotal, 8, 2));
                              }
                              AV15RemoveItem = httpContext.cgiGet( edtavRemoveitem_Internalname) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavRemoveitem_Internalname, AV15RemoveItem);
                           }
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
                                       GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e122N2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e132N2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDDVELOP_ECOMMERCECARTS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e142N2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "DVELOP_ECOMMERCECART__PRODUCTQTY.ISVALID") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e152N2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "VREMOVEITEM.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e162N2 ();
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup2N0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavDvelop_ecommercecart__productid_Internalname ;
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

   public void we2N2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm2N2( ) ;
         }
      }
   }

   public void pa2N2( )
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
            GX_FocusControl = edtavTotvalueproducttotal_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgriddvelop_ecommercecarts_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_242( ) ;
      while ( nGXsfl_24_idx <= nRC_GXsfl_24 )
      {
         sendrow_242( ) ;
         nGXsfl_24_idx = ((subGriddvelop_ecommercecarts_Islastpage==1)&&(nGXsfl_24_idx+1>subgriddvelop_ecommercecarts_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Griddvelop_ecommercecartsContainer)) ;
      /* End function gxnrGriddvelop_ecommercecarts_newrow */
   }

   public void gxgrgriddvelop_ecommercecarts_refresh( int subGriddvelop_ecommercecarts_Rows ,
                                                      GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart ,
                                                      short AV20Qty ,
                                                      String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e132N2 ();
      GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord = 0 ;
      rf2N2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGriddvelop_ecommercecarts_refresh */
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
      rf2N2( ) ;
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
      edtavDvelop_ecommercecart__productid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productid_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productname_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productsim_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productprice_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productqty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productqty_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavProducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttotal_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavRemoveitem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRemoveitem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRemoveitem_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavTotvalueproducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueproducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueproducttotal_Enabled), 5, 0), true);
   }

   public void rf2N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Griddvelop_ecommercecartsContainer.ClearRows();
      }
      wbStart = (short)(24) ;
      /* Execute user event: Refresh */
      e132N2 ();
      nGXsfl_24_idx = 1 ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
      bGXsfl_24_Refreshing = true ;
      Griddvelop_ecommercecartsContainer.AddObjectProperty("GridName", "Griddvelop_ecommercecarts");
      Griddvelop_ecommercecartsContainer.AddObjectProperty("CmpContext", sPrefix);
      Griddvelop_ecommercecartsContainer.AddObjectProperty("InMasterPage", "false");
      Griddvelop_ecommercecartsContainer.AddObjectProperty("Class", "GridWithTotalizer WorkWith");
      Griddvelop_ecommercecartsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Griddvelop_ecommercecartsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Griddvelop_ecommercecartsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Griddvelop_ecommercecartsContainer.setPageSize( subgriddvelop_ecommercecarts_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_242( ) ;
         e142N2 ();
         if ( ( GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord > 0 ) && ( GRIDDVELOP_ECOMMERCECARTS_nGridOutOfScope == 0 ) && ( nGXsfl_24_idx == 1 ) )
         {
            GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord = 0 ;
            GRIDDVELOP_ECOMMERCECARTS_nGridOutOfScope = 1 ;
            subgriddvelop_ecommercecarts_firstpage( ) ;
            e142N2 ();
         }
         wbEnd = (short)(24) ;
         wb2N0( ) ;
      }
      bGXsfl_24_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2N2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vQTY", GXutil.ltrim( localUtil.ntoc( AV20Qty, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQTY", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20Qty), "ZZZ9")));
   }

   public int subgriddvelop_ecommercecarts_fnc_pagecount( )
   {
      GRIDDVELOP_ECOMMERCECARTS_nRecordCount = subgriddvelop_ecommercecarts_fnc_recordcount( ) ;
      if ( ((int)((GRIDDVELOP_ECOMMERCECARTS_nRecordCount) % (subgriddvelop_ecommercecarts_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDDVELOP_ECOMMERCECARTS_nRecordCount/ (double) (subgriddvelop_ecommercecarts_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDDVELOP_ECOMMERCECARTS_nRecordCount/ (double) (subgriddvelop_ecommercecarts_fnc_recordsperpage( )))+1) ;
   }

   public int subgriddvelop_ecommercecarts_fnc_recordcount( )
   {
      return AV8DVelop_ECommerceCart.size() ;
   }

   public int subgriddvelop_ecommercecarts_fnc_recordsperpage( )
   {
      if ( subGriddvelop_ecommercecarts_Rows > 0 )
      {
         return subGriddvelop_ecommercecarts_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgriddvelop_ecommercecarts_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage/ (double) (subgriddvelop_ecommercecarts_fnc_recordsperpage( )))+1) ;
   }

   public short subgriddvelop_ecommercecarts_firstpage( )
   {
      GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgriddvelop_ecommercecarts_nextpage( )
   {
      GRIDDVELOP_ECOMMERCECARTS_nRecordCount = subgriddvelop_ecommercecarts_fnc_recordcount( ) ;
      if ( ( GRIDDVELOP_ECOMMERCECARTS_nRecordCount >= subgriddvelop_ecommercecarts_fnc_recordsperpage( ) ) && ( GRIDDVELOP_ECOMMERCECARTS_nEOF == 0 ) )
      {
         GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = (long)(GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage+subgriddvelop_ecommercecarts_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Griddvelop_ecommercecartsContainer.AddObjectProperty("GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDDVELOP_ECOMMERCECARTS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgriddvelop_ecommercecarts_previouspage( )
   {
      if ( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage >= subgriddvelop_ecommercecarts_fnc_recordsperpage( ) )
      {
         GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = (long)(GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage-subgriddvelop_ecommercecarts_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgriddvelop_ecommercecarts_lastpage( )
   {
      GRIDDVELOP_ECOMMERCECARTS_nRecordCount = subgriddvelop_ecommercecarts_fnc_recordcount( ) ;
      if ( GRIDDVELOP_ECOMMERCECARTS_nRecordCount > subgriddvelop_ecommercecarts_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDDVELOP_ECOMMERCECARTS_nRecordCount) % (subgriddvelop_ecommercecarts_fnc_recordsperpage( )))) == 0 )
         {
            GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = (long)(GRIDDVELOP_ECOMMERCECARTS_nRecordCount-subgriddvelop_ecommercecarts_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = (long)(GRIDDVELOP_ECOMMERCECARTS_nRecordCount-((int)((GRIDDVELOP_ECOMMERCECARTS_nRecordCount) % (subgriddvelop_ecommercecarts_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgriddvelop_ecommercecarts_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = (long)(subgriddvelop_ecommercecarts_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavDvelop_ecommercecart__productid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productid_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productname_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productsim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productsim_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productprice_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productprice_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productqty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productqty_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavProducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttotal_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavRemoveitem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRemoveitem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRemoveitem_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavTotvalueproducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueproducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueproducttotal_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup2N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e122N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"Dvelop_ecommercecart"), AV8DVelop_ECommerceCart);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDVELOP_ECOMMERCECART"), AV8DVelop_ECommerceCart);
         /* Read saved values. */
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_24"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDDVELOP_ECOMMERCECARTS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGriddvelop_ecommercecarts_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRIDDVELOP_ECOMMERCECARTS_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_Rows", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Rows, (byte)(6), (byte)(0), ".", "")));
         Griddvelop_ecommercecarts_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRIDDVELOP_ECOMMERCECARTS_EMPOWERER_Gridinternalname") ;
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_24"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_24_fel_idx = 0 ;
         while ( nGXsfl_24_fel_idx < nRC_GXsfl_24 )
         {
            nGXsfl_24_fel_idx = ((subGriddvelop_ecommercecarts_Islastpage==1)&&(nGXsfl_24_fel_idx+1>subgriddvelop_ecommercecarts_fnc_recordsperpage( )) ? 1 : nGXsfl_24_fel_idx+1) ;
            sGXsfl_24_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_242( ) ;
            AV23GXV1 = (int)(nGXsfl_24_fel_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
            if ( ( AV8DVelop_ECommerceCart.size() >= AV23GXV1 ) && ( AV23GXV1 > 0 ) )
            {
               AV8DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)) );
               AV7ProductImage = httpContext.cgiGet( edtavProductimage_Internalname) ;
               if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTTOTAL");
                  GX_FocusControl = edtavProducttotal_Internalname ;
                  wbErr = true ;
                  AV10ProductTotal = DecimalUtil.ZERO ;
               }
               else
               {
                  AV10ProductTotal = localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)) ;
               }
               AV15RemoveItem = httpContext.cgiGet( edtavRemoveitem_Internalname) ;
            }
         }
         if ( nGXsfl_24_fel_idx == 0 )
         {
            nGXsfl_24_idx = 1 ;
            sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_242( ) ;
         }
         nGXsfl_24_fel_idx = 1 ;
         /* Read variables values. */
         AV12TotValueProductTotal = httpContext.cgiGet( edtavTotvalueproducttotal_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TotValueProductTotal", AV12TotValueProductTotal);
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
      e122N2 ();
      if (returnInSub) return;
   }

   public void e122N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Griddvelop_ecommercecarts_empowerer_Gridinternalname = subGriddvelop_ecommercecarts_Internalname ;
      ucGriddvelop_ecommercecarts_empowerer.sendProperty(context, sPrefix, false, Griddvelop_ecommercecarts_empowerer_Internalname, "GridInternalName", Griddvelop_ecommercecarts_empowerer_Gridinternalname);
      subGriddvelop_ecommercecarts_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_Rows", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Rows, (byte)(6), (byte)(0), ".", "")));
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = AV8DVelop_ECommerceCart ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      new com.mujermorena.wwpbaseobjects.getcartcontent(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item2) ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] ;
      AV8DVelop_ECommerceCart = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      gx_BV24 = true ;
   }

   public void e132N2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV11TotProductTotal = DecimalUtil.doubleToDec(0) ;
      AV29GXV7 = 1 ;
      while ( AV29GXV7 <= AV8DVelop_ECommerceCart.size() )
      {
         AV17DVelop_ECommerceCartItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV29GXV7));
         AV11TotProductTotal = AV11TotProductTotal.add((AV17DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productprice().multiply(DecimalUtil.doubleToDec(AV17DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty())))) ;
         AV29GXV7 = (int)(AV29GXV7+1) ;
      }
      AV12TotValueProductTotal = "Gs" + localUtil.format( AV11TotProductTotal, "ZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12TotValueProductTotal", AV12TotValueProductTotal);
      AV20Qty = (short)(AV8DVelop_ECommerceCart.size()) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Qty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20Qty), 4, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vQTY", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV20Qty), "ZZZ9")));
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   private void e142N2( )
   {
      /* Griddvelop_ecommercecarts_Load Routine */
      returnInSub = false ;
      AV23GXV1 = 1 ;
      while ( AV23GXV1 <= AV8DVelop_ECommerceCart.size() )
      {
         AV8DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)) );
         AV15RemoveItem = "<i class=\"fas fa-trash TrashColor fas fa-trash\"></i>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavRemoveitem_Internalname, AV15RemoveItem);
         edtavProductimage_Link = formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(),6,0))}, new String[] {"ProductId","ProductDispon"})  ;
         edtavDvelop_ecommercecart__productname_Link = formatLink("com.mujermorena.wwpbaseobjects.productdetail", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(),6,0))}, new String[] {"ProductId","ProductDispon"})  ;
         AV30Productimage_GXI = ((((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size()>0) ? ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+1) : "") ;
         AV7ProductImage = "" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProductimage_Internalname, AV7ProductImage);
         AV10ProductTotal = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice().multiply(DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV8DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProducttotal_Internalname, GXutil.ltrimstr( AV10ProductTotal, 8, 2));
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(24) ;
         }
         if ( ( subGriddvelop_ecommercecarts_Islastpage == 1 ) || ( subGriddvelop_ecommercecarts_Rows == 0 ) || ( ( GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord >= GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage ) && ( GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord < GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage + subgriddvelop_ecommercecarts_fnc_recordsperpage( ) ) ) )
         {
            sendrow_242( ) ;
            GRIDDVELOP_ECOMMERCECARTS_nEOF = (byte)(0) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord + 1 >= subgriddvelop_ecommercecarts_fnc_recordcount( ) )
            {
               GRIDDVELOP_ECOMMERCECARTS_nEOF = (byte)(1) ;
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord = (long)(GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_24_Refreshing )
         {
            httpContext.doAjaxLoad(24, Griddvelop_ecommercecartsRow);
         }
         AV23GXV1 = (int)(AV23GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( AV20Qty > 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
      divTablefilters_Visible = (((AV20Qty<1)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablefilters_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablefilters_Visible), 5, 0), true);
      divTablegrid_Visible = (((AV20Qty>0)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablegrid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablegrid_Visible), 5, 0), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e112N2 ();
      if (returnInSub) return;
   }

   public void e112N2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.rtrim("")),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e152N2( )
   {
      AV23GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV23GXV1 > 0 ) && ( AV8DVelop_ECommerceCart.size() >= AV23GXV1 ) )
      {
         AV8DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)) );
      }
      /* Dvelop_ecommercecart__productqty_Isvalid Routine */
      returnInSub = false ;
      new com.mujermorena.wwpbaseobjects.updatecart(remoteHandle, context).execute( AV8DVelop_ECommerceCart) ;
      this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "CartChanged", new Object[] {}, true);
   }

   public void e162N2( )
   {
      AV23GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV23GXV1 > 0 ) && ( AV8DVelop_ECommerceCart.size() >= AV23GXV1 ) )
      {
         AV8DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)) );
      }
      /* Removeitem_Click Routine */
      returnInSub = false ;
      AV8DVelop_ECommerceCart.removeItem(AV8DVelop_ECommerceCart.indexof(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.currentItem())));
      gx_BV24 = true ;
      new com.mujermorena.wwpbaseobjects.updatecart(remoteHandle, context).execute( AV8DVelop_ECommerceCart) ;
      this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "CartChanged", new Object[] {}, true);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV8DVelop_ECommerceCart", AV8DVelop_ECommerceCart);
      nGXsfl_24_bak_idx = nGXsfl_24_idx ;
      gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV8DVelop_ECommerceCart, AV20Qty, sPrefix) ;
      nGXsfl_24_idx = nGXsfl_24_bak_idx ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
   }

   public void wb_table1_35_2N2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblGriddvelop_ecommercecartstabletotalizer_Internalname, tblGriddvelop_ecommercecartstabletotalizer_Internalname, "", "TableTotalizerAl", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTotvalueproducttotal_Internalname, httpContext.getMessage( "Tot Value Product Total", ""), "gx-form-item AttributeRealWidthTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueproducttotal_Internalname, AV12TotValueProductTotal, GXutil.rtrim( localUtil.format( AV12TotValueProductTotal, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueproducttotal_Jsonclick, 0, "AttributeRealWidthTotalizer", "", "", "", "", 1, edtavTotvalueproducttotal_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWP_CartDetailDropDown.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_35_2N2e( true) ;
      }
      else
      {
         wb_table1_35_2N2e( false) ;
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
      pa2N2( ) ;
      ws2N2( ) ;
      we2N2( ) ;
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
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa2N2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwp_cartdetaildropdown", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa2N2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
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
      pa2N2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws2N2( ) ;
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
      ws2N2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
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
      we2N2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211162912", true, true);
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
      httpContext.AddJavascriptSource("wwp_cartdetaildropdown.js", "?20241211162913", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_242( )
   {
      edtavProductimage_Internalname = sPrefix+"vPRODUCTIMAGE_"+sGXsfl_24_idx ;
      edtavDvelop_ecommercecart__productid_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTID_"+sGXsfl_24_idx ;
      edtavDvelop_ecommercecart__productname_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTNAME_"+sGXsfl_24_idx ;
      edtavDvelop_ecommercecart__productsim_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTSIM_"+sGXsfl_24_idx ;
      edtavDvelop_ecommercecart__productprice_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTPRICE_"+sGXsfl_24_idx ;
      edtavDvelop_ecommercecart__productqty_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTQTY_"+sGXsfl_24_idx ;
      edtavProducttotal_Internalname = sPrefix+"vPRODUCTTOTAL_"+sGXsfl_24_idx ;
      edtavRemoveitem_Internalname = sPrefix+"vREMOVEITEM_"+sGXsfl_24_idx ;
   }

   public void subsflControlProps_fel_242( )
   {
      edtavProductimage_Internalname = sPrefix+"vPRODUCTIMAGE_"+sGXsfl_24_fel_idx ;
      edtavDvelop_ecommercecart__productid_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTID_"+sGXsfl_24_fel_idx ;
      edtavDvelop_ecommercecart__productname_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTNAME_"+sGXsfl_24_fel_idx ;
      edtavDvelop_ecommercecart__productsim_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTSIM_"+sGXsfl_24_fel_idx ;
      edtavDvelop_ecommercecart__productprice_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTPRICE_"+sGXsfl_24_fel_idx ;
      edtavDvelop_ecommercecart__productqty_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTQTY_"+sGXsfl_24_fel_idx ;
      edtavProducttotal_Internalname = sPrefix+"vPRODUCTTOTAL_"+sGXsfl_24_fel_idx ;
      edtavRemoveitem_Internalname = sPrefix+"vREMOVEITEM_"+sGXsfl_24_fel_idx ;
   }

   public void sendrow_242( )
   {
      subsflControlProps_242( ) ;
      wb2N0( ) ;
      if ( ( subGriddvelop_ecommercecarts_Rows * 1 == 0 ) || ( nGXsfl_24_idx <= subgriddvelop_ecommercecarts_fnc_recordsperpage( ) * 1 ) )
      {
         Griddvelop_ecommercecartsRow = GXWebRow.GetNew(context,Griddvelop_ecommercecartsContainer) ;
         if ( subGriddvelop_ecommercecarts_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGriddvelop_ecommercecarts_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGriddvelop_ecommercecarts_Class, "") != 0 )
            {
               subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Odd" ;
            }
         }
         else if ( subGriddvelop_ecommercecarts_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGriddvelop_ecommercecarts_Backstyle = (byte)(0) ;
            subGriddvelop_ecommercecarts_Backcolor = subGriddvelop_ecommercecarts_Allbackcolor ;
            if ( GXutil.strcmp(subGriddvelop_ecommercecarts_Class, "") != 0 )
            {
               subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Uniform" ;
            }
         }
         else if ( subGriddvelop_ecommercecarts_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGriddvelop_ecommercecarts_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGriddvelop_ecommercecarts_Class, "") != 0 )
            {
               subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Odd" ;
            }
            subGriddvelop_ecommercecarts_Backcolor = (int)(0x0) ;
         }
         else if ( subGriddvelop_ecommercecarts_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGriddvelop_ecommercecarts_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_24_idx) % (2))) == 0 )
            {
               subGriddvelop_ecommercecarts_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGriddvelop_ecommercecarts_Class, "") != 0 )
               {
                  subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Even" ;
               }
            }
            else
            {
               subGriddvelop_ecommercecarts_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGriddvelop_ecommercecarts_Class, "") != 0 )
               {
                  subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Odd" ;
               }
            }
         }
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithTotalizer WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_24_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "AttributeECommerceSmallImageWithMargins" + " " + ((GXutil.strcmp(edtavProductimage_gximage, "")==0) ? "" : "GX_Image_"+edtavProductimage_gximage+"_Class") ;
         StyleString = "" ;
         AV7ProductImage_IsBlob = (boolean)(((GXutil.strcmp("", AV7ProductImage)==0)&&(GXutil.strcmp("", AV30Productimage_GXI)==0))||!(GXutil.strcmp("", AV7ProductImage)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV7ProductImage)==0) ? AV30Productimage_GXI : httpContext.getResourceRelative(AV7ProductImage)) ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavProductimage_Internalname,sImgUrl,edtavProductimage_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(80),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV7ProductImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productid()), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productid()), "ZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavDvelop_ecommercecart__productid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeECommerceListDescription" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productname_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productname(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'",edtavDvelop_ecommercecart__productname_Link,"","","",edtavDvelop_ecommercecart__productname_Jsonclick,Integer.valueOf(0),"AttributeECommerceListDescription","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDvelop_ecommercecart__productname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productsim_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productsim(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productsim_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavDvelop_ecommercecart__productsim_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productprice_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productprice_Enabled!=0) ? localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99") : localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99"))),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productprice_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDvelop_ecommercecart__productprice_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(65),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeECommerceDetailQty" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productqty_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productqty_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8DVelop_ECommerceCart.elementAt(-1+AV23GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productqty_Jsonclick,Integer.valueOf(0),"AttributeECommerceDetailQty","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDvelop_ecommercecart__productqty_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(65),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavProducttotal_Enabled!=0)&&(edtavProducttotal_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 31,'"+sPrefix+"',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavProducttotal_Internalname,GXutil.ltrim( localUtil.ntoc( AV10ProductTotal, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavProducttotal_Enabled!=0) ? localUtil.format( AV10ProductTotal, "ZZ,ZZ9.99") : localUtil.format( AV10ProductTotal, "ZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+((edtavProducttotal_Enabled!=0)&&(edtavProducttotal_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,31);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavProducttotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavProducttotal_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(65),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"WWPBaseObjects\\WWPECommercePrice","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavRemoveitem_Enabled!=0)&&(edtavRemoveitem_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 32,'"+sPrefix+"',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
         ROClassString = "Attribute" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavRemoveitem_Internalname,GXutil.rtrim( AV15RemoveItem),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavRemoveitem_Enabled!=0)&&(edtavRemoveitem_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,32);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVREMOVEITEM.CLICK."+sGXsfl_24_idx+"'","","",httpContext.getMessage( "Remove item", ""),"",edtavRemoveitem_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavRemoveitem_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(52),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2N2( ) ;
         Griddvelop_ecommercecartsContainer.AddRow(Griddvelop_ecommercecartsRow);
         nGXsfl_24_idx = ((subGriddvelop_ecommercecarts_Islastpage==1)&&(nGXsfl_24_idx+1>subgriddvelop_ecommercecarts_fnc_recordsperpage( )) ? 1 : nGXsfl_24_idx+1) ;
         sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_242( ) ;
      }
      /* End function sendrow_242 */
   }

   public void startgridcontrol24( )
   {
      if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"Griddvelop_ecommercecartsContainer"+"DivS\" data-gxgridid=\"24\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGriddvelop_ecommercecarts_Internalname, subGriddvelop_ecommercecarts_Internalname, "", "GridWithTotalizer WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGriddvelop_ecommercecarts_Backcolorstyle == 0 )
         {
            subGriddvelop_ecommercecarts_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGriddvelop_ecommercecarts_Class) > 0 )
            {
               subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Title" ;
            }
         }
         else
         {
            subGriddvelop_ecommercecarts_Titlebackstyle = (byte)(1) ;
            if ( subGriddvelop_ecommercecarts_Backcolorstyle == 1 )
            {
               subGriddvelop_ecommercecarts_Titlebackcolor = subGriddvelop_ecommercecarts_Allbackcolor ;
               if ( GXutil.len( subGriddvelop_ecommercecarts_Class) > 0 )
               {
                  subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGriddvelop_ecommercecarts_Class) > 0 )
               {
                  subGriddvelop_ecommercecarts_Linesclass = subGriddvelop_ecommercecarts_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+""+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(80), 4, 0)+"px"+" class=\""+"AttributeECommerceSmallImageWithMargins"+" "+((GXutil.strcmp(edtavProductimage_gximage, "")==0) ? "" : "GX_Image_"+edtavProductimage_gximage+"_Class")+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Producto", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Product Id", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeECommerceListDescription"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Product Sim", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(65), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_CartPrice", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(65), 4, 0)+"px"+" class=\""+"AttributeECommerceDetailQty"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(65), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_CartTotal", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(52), 4, 0)+"px"+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Griddvelop_ecommercecartsContainer.AddObjectProperty("GridName", "Griddvelop_ecommercecarts");
      }
      else
      {
         Griddvelop_ecommercecartsContainer.AddObjectProperty("GridName", "Griddvelop_ecommercecarts");
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Header", subGriddvelop_ecommercecarts_Header);
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Class", "GridWithTotalizer WorkWith");
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("CmpContext", sPrefix);
         Griddvelop_ecommercecartsContainer.AddObjectProperty("InMasterPage", "false");
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Value", httpContext.convertURL( AV7ProductImage));
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Link", GXutil.rtrim( edtavProductimage_Link));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productid_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productname_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Link", GXutil.rtrim( edtavDvelop_ecommercecart__productname_Link));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productsim_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productprice_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productqty_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV10ProductTotal, (byte)(9), (byte)(2), ".", "")));
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavProducttotal_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Value", GXutil.rtrim( AV15RemoveItem));
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavRemoveitem_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = sPrefix+"TEXTBLOCK1" ;
      divTablefilters_Internalname = sPrefix+"TABLEFILTERS" ;
      edtavProductimage_Internalname = sPrefix+"vPRODUCTIMAGE" ;
      edtavDvelop_ecommercecart__productid_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTID" ;
      edtavDvelop_ecommercecart__productname_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTNAME" ;
      edtavDvelop_ecommercecart__productsim_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTSIM" ;
      edtavDvelop_ecommercecart__productprice_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTPRICE" ;
      edtavDvelop_ecommercecart__productqty_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTQTY" ;
      edtavProducttotal_Internalname = sPrefix+"vPRODUCTTOTAL" ;
      edtavRemoveitem_Internalname = sPrefix+"vREMOVEITEM" ;
      edtavTotvalueproducttotal_Internalname = sPrefix+"vTOTVALUEPRODUCTTOTAL" ;
      tblGriddvelop_ecommercecartstabletotalizer_Internalname = sPrefix+"GRIDDVELOP_ECOMMERCECARTSTABLETOTALIZER" ;
      divGriddvelop_ecommercecartstablewithtotalizers_Internalname = sPrefix+"GRIDDVELOP_ECOMMERCECARTSTABLEWITHTOTALIZERS" ;
      divTablegrid_Internalname = sPrefix+"TABLEGRID" ;
      bttBtnenter_Internalname = sPrefix+"BTNENTER" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      Griddvelop_ecommercecarts_empowerer_Internalname = sPrefix+"GRIDDVELOP_ECOMMERCECARTS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGriddvelop_ecommercecarts_Internalname = sPrefix+"GRIDDVELOP_ECOMMERCECARTS" ;
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
      subGriddvelop_ecommercecarts_Allowcollapsing = (byte)(0) ;
      subGriddvelop_ecommercecarts_Allowselection = (byte)(0) ;
      subGriddvelop_ecommercecarts_Header = "" ;
      edtavRemoveitem_Jsonclick = "" ;
      edtavRemoveitem_Visible = -1 ;
      edtavRemoveitem_Enabled = 1 ;
      edtavProducttotal_Jsonclick = "" ;
      edtavProducttotal_Visible = -1 ;
      edtavProducttotal_Enabled = 1 ;
      edtavDvelop_ecommercecart__productqty_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      edtavDvelop_ecommercecart__productprice_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productname_Link = "" ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart__productid_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productid_Enabled = 0 ;
      edtavProductimage_gximage = "" ;
      edtavProductimage_Link = "" ;
      subGriddvelop_ecommercecarts_Class = "GridWithTotalizer WorkWith" ;
      subGriddvelop_ecommercecarts_Backcolorstyle = (byte)(0) ;
      edtavTotvalueproducttotal_Jsonclick = "" ;
      edtavTotvalueproducttotal_Enabled = 1 ;
      edtavDvelop_ecommercecart__productqty_Enabled = -1 ;
      edtavDvelop_ecommercecart__productprice_Enabled = -1 ;
      edtavDvelop_ecommercecart__productsim_Enabled = -1 ;
      edtavDvelop_ecommercecart__productname_Enabled = -1 ;
      edtavDvelop_ecommercecart__productid_Enabled = -1 ;
      bttBtnenter_Visible = 1 ;
      divTablegrid_Visible = 1 ;
      divTablefilters_Visible = 1 ;
      subGriddvelop_ecommercecarts_Rows = 0 ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV12TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{ctrl:'BTNENTER',prop:'Visible'},{av:'divTablefilters_Visible',ctrl:'TABLEFILTERS',prop:'Visible'},{av:'divTablegrid_Visible',ctrl:'TABLEGRID',prop:'Visible'}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS.LOAD","{handler:'e142N2',iparms:[{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS.LOAD",",oparms:[{av:'AV15RemoveItem',fld:'vREMOVEITEM',pic:''},{av:'edtavProductimage_Link',ctrl:'vPRODUCTIMAGE',prop:'Link'},{ctrl:'DVELOP_ECOMMERCECART__PRODUCTNAME',prop:'Link'},{av:'AV7ProductImage',fld:'vPRODUCTIMAGE',pic:''},{av:'AV10ProductTotal',fld:'vPRODUCTTOTAL',pic:'ZZ,ZZ9.99'}]}");
      setEventMetadata("ENTER","{handler:'e112N2',iparms:[]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("DVELOP_ECOMMERCECART__PRODUCTQTY.ISVALID","{handler:'e152N2',iparms:[{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("DVELOP_ECOMMERCECART__PRODUCTQTY.ISVALID",",oparms:[]}");
      setEventMetadata("VREMOVEITEM.CLICK","{handler:'e162N2',iparms:[{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("VREMOVEITEM.CLICK",",oparms:[{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_FIRSTPAGE","{handler:'subgriddvelop_ecommercecarts_firstpage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_FIRSTPAGE",",oparms:[{av:'AV12TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{ctrl:'BTNENTER',prop:'Visible'},{av:'divTablefilters_Visible',ctrl:'TABLEFILTERS',prop:'Visible'},{av:'divTablegrid_Visible',ctrl:'TABLEGRID',prop:'Visible'}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_PREVPAGE","{handler:'subgriddvelop_ecommercecarts_previouspage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_PREVPAGE",",oparms:[{av:'AV12TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{ctrl:'BTNENTER',prop:'Visible'},{av:'divTablefilters_Visible',ctrl:'TABLEFILTERS',prop:'Visible'},{av:'divTablegrid_Visible',ctrl:'TABLEGRID',prop:'Visible'}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_NEXTPAGE","{handler:'subgriddvelop_ecommercecarts_nextpage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_NEXTPAGE",",oparms:[{av:'AV12TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{ctrl:'BTNENTER',prop:'Visible'},{av:'divTablefilters_Visible',ctrl:'TABLEFILTERS',prop:'Visible'},{av:'divTablegrid_Visible',ctrl:'TABLEGRID',prop:'Visible'}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_LASTPAGE","{handler:'subgriddvelop_ecommercecarts_lastpage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{av:'AV8DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_LASTPAGE",",oparms:[{av:'AV12TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''},{av:'AV20Qty',fld:'vQTY',pic:'ZZZ9',hsh:true},{ctrl:'BTNENTER',prop:'Visible'},{av:'divTablefilters_Visible',ctrl:'TABLEFILTERS',prop:'Visible'},{av:'divTablegrid_Visible',ctrl:'TABLEGRID',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Removeitem',iparms:[]");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV8DVelop_ECommerceCart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Griddvelop_ecommercecarts_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      Griddvelop_ecommercecartsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      TempTags = "" ;
      bttBtnenter_Jsonclick = "" ;
      ucGriddvelop_ecommercecarts_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV7ProductImage = "" ;
      AV30Productimage_GXI = "" ;
      AV10ProductTotal = DecimalUtil.ZERO ;
      AV15RemoveItem = "" ;
      AV12TotValueProductTotal = "" ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtDVelop_ECommerceCart_Item2 = new GXBaseCollection[1] ;
      AV11TotProductTotal = DecimalUtil.ZERO ;
      AV17DVelop_ECommerceCartItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      Griddvelop_ecommercecartsRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGriddvelop_ecommercecarts_Linesclass = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      Griddvelop_ecommercecartsColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavDvelop_ecommercecart__productid_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      edtavProducttotal_Enabled = 0 ;
      edtavRemoveitem_Enabled = 0 ;
      edtavTotvalueproducttotal_Enabled = 0 ;
   }

   private byte GRIDDVELOP_ECOMMERCECARTS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGriddvelop_ecommercecarts_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGriddvelop_ecommercecarts_Backstyle ;
   private byte subGriddvelop_ecommercecarts_Titlebackstyle ;
   private byte subGriddvelop_ecommercecarts_Allowselection ;
   private byte subGriddvelop_ecommercecarts_Allowhovering ;
   private byte subGriddvelop_ecommercecarts_Allowcollapsing ;
   private byte subGriddvelop_ecommercecarts_Collapsed ;
   private short AV20Qty ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_24 ;
   private int subGriddvelop_ecommercecarts_Rows ;
   private int nGXsfl_24_idx=1 ;
   private int divTablefilters_Visible ;
   private int divTablegrid_Visible ;
   private int AV23GXV1 ;
   private int bttBtnenter_Visible ;
   private int subGriddvelop_ecommercecarts_Islastpage ;
   private int edtavDvelop_ecommercecart__productid_Enabled ;
   private int edtavDvelop_ecommercecart__productname_Enabled ;
   private int edtavDvelop_ecommercecart__productsim_Enabled ;
   private int edtavDvelop_ecommercecart__productprice_Enabled ;
   private int edtavDvelop_ecommercecart__productqty_Enabled ;
   private int edtavProducttotal_Enabled ;
   private int edtavRemoveitem_Enabled ;
   private int edtavTotvalueproducttotal_Enabled ;
   private int GRIDDVELOP_ECOMMERCECARTS_nGridOutOfScope ;
   private int nGXsfl_24_fel_idx=1 ;
   private int AV29GXV7 ;
   private int nGXsfl_24_bak_idx=1 ;
   private int idxLst ;
   private int subGriddvelop_ecommercecarts_Backcolor ;
   private int subGriddvelop_ecommercecarts_Allbackcolor ;
   private int edtavProducttotal_Visible ;
   private int edtavRemoveitem_Visible ;
   private int subGriddvelop_ecommercecarts_Titlebackcolor ;
   private int subGriddvelop_ecommercecarts_Selectedindex ;
   private int subGriddvelop_ecommercecarts_Selectioncolor ;
   private int subGriddvelop_ecommercecarts_Hoveringcolor ;
   private long GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage ;
   private long GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord ;
   private long GRIDDVELOP_ECOMMERCECARTS_nRecordCount ;
   private java.math.BigDecimal AV10ProductTotal ;
   private java.math.BigDecimal AV11TotProductTotal ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_24_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Griddvelop_ecommercecarts_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablefilters_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String divTablegrid_Internalname ;
   private String divGriddvelop_ecommercecartstablewithtotalizers_Internalname ;
   private String sStyleString ;
   private String subGriddvelop_ecommercecarts_Internalname ;
   private String TempTags ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Griddvelop_ecommercecarts_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavDvelop_ecommercecart__productid_Internalname ;
   private String edtavProductimage_Internalname ;
   private String edtavProducttotal_Internalname ;
   private String AV15RemoveItem ;
   private String edtavRemoveitem_Internalname ;
   private String edtavTotvalueproducttotal_Internalname ;
   private String edtavDvelop_ecommercecart__productname_Internalname ;
   private String edtavDvelop_ecommercecart__productsim_Internalname ;
   private String edtavDvelop_ecommercecart__productprice_Internalname ;
   private String edtavDvelop_ecommercecart__productqty_Internalname ;
   private String sGXsfl_24_fel_idx="0001" ;
   private String edtavProductimage_Link ;
   private String edtavDvelop_ecommercecart__productname_Link ;
   private String tblGriddvelop_ecommercecartstabletotalizer_Internalname ;
   private String edtavTotvalueproducttotal_Jsonclick ;
   private String subGriddvelop_ecommercecarts_Class ;
   private String subGriddvelop_ecommercecarts_Linesclass ;
   private String edtavProductimage_gximage ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtavDvelop_ecommercecart__productid_Jsonclick ;
   private String edtavDvelop_ecommercecart__productname_Jsonclick ;
   private String edtavDvelop_ecommercecart__productsim_Jsonclick ;
   private String edtavDvelop_ecommercecart__productprice_Jsonclick ;
   private String edtavDvelop_ecommercecart__productqty_Jsonclick ;
   private String edtavProducttotal_Jsonclick ;
   private String edtavRemoveitem_Jsonclick ;
   private String subGriddvelop_ecommercecarts_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_24_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV24 ;
   private boolean gx_refresh_fired ;
   private boolean AV7ProductImage_IsBlob ;
   private String AV30Productimage_GXI ;
   private String AV12TotValueProductTotal ;
   private String AV7ProductImage ;
   private com.genexus.webpanels.GXWebGrid Griddvelop_ecommercecartsContainer ;
   private com.genexus.webpanels.GXWebRow Griddvelop_ecommercecartsRow ;
   private com.genexus.webpanels.GXWebColumn Griddvelop_ecommercecartsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGriddvelop_ecommercecarts_empowerer ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8DVelop_ECommerceCart ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXv_objcol_SdtDVelop_ECommerceCart_Item2[] ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV17DVelop_ECommerceCartItem ;
}

