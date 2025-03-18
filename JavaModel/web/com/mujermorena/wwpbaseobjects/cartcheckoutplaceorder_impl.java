package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cartcheckoutplaceorder_impl extends GXWebComponent
{
   public cartcheckoutplaceorder_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cartcheckoutplaceorder_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cartcheckoutplaceorder_impl.class ));
   }

   public cartcheckoutplaceorder_impl( int remoteHandle ,
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
      dynavDvelop_ecommercecart__producttalle = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
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
               AV6WebSessionKey = httpContext.GetPar( "WebSessionKey") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
               AV8PreviousStep = httpContext.GetPar( "PreviousStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
               AV7GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV6WebSessionKey,AV8PreviousStep,Boolean.valueOf(AV7GoingBack)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "WebSessionKey") ;
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
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV15DVelop_ECommerceCart);
      AV10HasValidationErrors = GXutil.strtobool( httpContext.GetPar( "HasValidationErrors")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGriddvelop_ecommercecarts_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa262( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Cart Checkout Place Order", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.cartcheckoutplaceorder", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV8PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV7GoingBack))}, new String[] {"WebSessionKey","PreviousStep","GoingBack"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Dvelop_ecommercecart", AV15DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Dvelop_ecommercecart", AV15DVelop_ECommerceCart);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Wizarddata", AV11WizardData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Wizarddata", AV11WizardData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_24", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_24, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6WebSessionKey", wcpOAV6WebSessionKey);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8PreviousStep", wcpOAV8PreviousStep);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV7GoingBack", wcpOAV7GoingBack);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vDVELOP_ECOMMERCECART", AV15DVelop_ECommerceCart);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vDVELOP_ECOMMERCECART", AV15DVelop_ECommerceCart);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vRESP", GXutil.rtrim( AV24Resp));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV6WebSessionKey);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV8PreviousStep);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV7GoingBack);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDDVELOP_ECOMMERCECARTS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vWIZARDDATA", AV11WizardData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vWIZARDDATA", AV11WizardData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_Rows", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_EMPOWERER_Gridinternalname", GXutil.rtrim( Griddvelop_ecommercecarts_empowerer_Gridinternalname));
   }

   public void renderHtmlCloseForm262( )
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
      return "WWPBaseObjects.CartCheckoutPlaceOrder" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cart Checkout Place Order", "") ;
   }

   public void wb260( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.cartcheckoutplaceorder");
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         }
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divProducts_summarytable_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divProducts_summaryheadertable_Internalname, 1, 0, "px", 0, "px", "TableWizardSummaryStep", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblProducts_summarytitle_Internalname, httpContext.getMessage( "Productos", ""), "", "", lblProducts_summarytitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardStepDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divProducts_tablegrid_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
            AV27GXV1 = nGXsfl_24_idx ;
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
         wb_table1_36_262( true) ;
      }
      else
      {
         wb_table1_36_262( false) ;
      }
      return  ;
   }

   public void wb_table1_36_262e( boolean wbgen )
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAddress_summarytable_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAddress_summaryheadertable_Internalname, 1, 0, "px", 0, "px", "TableWizardSummaryStep", "left", "top", " "+"data-gx-flex"+" ", "justify-content:space-between;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblAddress_summarytitle_Internalname, httpContext.getMessage( "Datos del Domicilio", ""), "", "", lblAddress_summarytitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardStepDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAsLinkBasecolor" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardgotoaddress_Internalname, "gx.evt.setGridEvt("+GXutil.str( 24, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_WizardGoToCaption", ""), bttBtnwizardgotoaddress_Jsonclick, 5, httpContext.getMessage( "WWP_WizardGoToCaption", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'WIZARDGOTO ADDRESS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAddress_tableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_address_name_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_address_name_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_address_name_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Name(), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Name(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_address_name_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_address_name_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_address_phone_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_address_phone_Internalname, httpContext.getMessage( "Telefono", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_address_phone_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Phone(), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Phone(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_address_phone_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_address_phone_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_address_country_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_address_country_Internalname, httpContext.getMessage( "Pais", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_address_country_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Country(), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Country(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_address_country_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_address_country_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_address_department_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_address_department_Internalname, httpContext.getMessage( "Departamento", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_address_department_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Department(), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Department(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_address_department_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_address_department_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_address_address_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_address_address_Internalname, httpContext.getMessage( "Direccion", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavWizarddata_address_address_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Address(), "", "", (short)(0), 1, edtavWizarddata_address_address_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPayment_summarytable_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPayment_summaryheadertable_Internalname, 1, 0, "px", 0, "px", "TableWizardSummaryStep", "left", "top", " "+"data-gx-flex"+" ", "justify-content:space-between;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblPayment_summarytitle_Internalname, httpContext.getMessage( "Informacion del Pago", ""), "", "", lblPayment_summarytitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "WizardStepDescription", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonAsLinkBasecolor" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardgotopayment_Internalname, "gx.evt.setGridEvt("+GXutil.str( 24, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_WizardGoToCaption", ""), bttBtnwizardgotopayment_Jsonclick, 5, httpContext.getMessage( "WWP_WizardGoToCaption", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'WIZARDGOTO PAYMENT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPayment_tableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_payment_paymentdata_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_payment_paymentdata_description_Internalname, httpContext.getMessage( "Forma de Pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_payment_paymentdata_description_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata_description(), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata_description(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_payment_paymentdata_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_payment_paymentdata_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_payment_paymentdata2_description_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_payment_paymentdata2_description_Internalname, httpContext.getMessage( "Condicion de Entrega", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_payment_paymentdata2_description_Internalname, AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description(), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_payment_paymentdata2_description_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_payment_paymentdata2_description_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavWizarddata_payment_paymentdata3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavWizarddata_payment_paymentdata3_Internalname, httpContext.getMessage( "Datos para Pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavWizarddata_payment_paymentdata3_Internalname, GXutil.rtrim( AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata3()), GXutil.rtrim( localUtil.format( AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata3(), "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavWizarddata_payment_paymentdata3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavWizarddata_payment_paymentdata3_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TrnActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault ButtonWizard" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardprevious_Internalname, "gx.evt.setGridEvt("+GXutil.str( 24, 2, 0)+","+"null"+");", httpContext.getMessage( "GXM_previous", ""), bttBtnwizardprevious_Jsonclick, 5, httpContext.getMessage( "GXM_previous", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'WIZARDPREVIOUS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial ButtonWizard" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardnext_Internalname, "gx.evt.setGridEvt("+GXutil.str( 24, 2, 0)+","+"null"+");", httpContext.getMessage( "Realizar Pedido", ""), bttBtnwizardnext_Jsonclick, 5, httpContext.getMessage( "Realizar Pedido", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
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
               AV27GXV1 = nGXsfl_24_idx ;
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

   public void start262( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Cart Checkout Place Order", ""), (short)(0)) ;
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
            strup260( ) ;
         }
      }
   }

   public void ws262( )
   {
      start262( ) ;
      evt262( ) ;
   }

   public void evt262( )
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
                              strup260( ) ;
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
                              strup260( ) ;
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
                                       e11262 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'WIZARDPREVIOUS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup260( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardPrevious' */
                                 e12262 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'WIZARDGOTO PAYMENT'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup260( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardGoTo Payment' */
                                 e13262 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'WIZARDGOTO ADDRESS'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup260( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardGoTo Address' */
                                 e14262 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup260( ) ;
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
                              strup260( ) ;
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
                              strup260( ) ;
                           }
                           nGXsfl_24_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_242( ) ;
                           AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
                           if ( ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) && ( AV27GXV1 > 0 ) )
                           {
                              AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
                              AV13ProductImage = httpContext.cgiGet( edtavProductimage_Internalname) ;
                              httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProductimage_Internalname, "Bitmap", ((GXutil.strcmp("", AV13ProductImage)==0) ? AV43Productimage_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV13ProductImage))), !bGXsfl_24_Refreshing);
                              httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProductimage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV13ProductImage), true);
                              if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
                              {
                                 httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTTOTAL");
                                 GX_FocusControl = edtavProducttotal_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                 wbErr = true ;
                                 AV16ProductTotal = DecimalUtil.ZERO ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProducttotal_Internalname, GXutil.ltrimstr( AV16ProductTotal, 8, 2));
                              }
                              else
                              {
                                 AV16ProductTotal = localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)) ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProducttotal_Internalname, GXutil.ltrimstr( AV16ProductTotal, 8, 2));
                              }
                              AV21RemoveItem = httpContext.cgiGet( edtavRemoveitem_Internalname) ;
                              httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavRemoveitem_Internalname, AV21RemoveItem);
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
                                       e15262 ();
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
                                       e16262 ();
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
                                       e17262 ();
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
                                       e18262 ();
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
                                       e19262 ();
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup260( ) ;
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

   public void we262( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm262( ) ;
         }
      }
   }

   public void pa262( )
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
                                                      GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV15DVelop_ECommerceCart ,
                                                      boolean AV10HasValidationErrors ,
                                                      String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e16262 ();
      GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord = 0 ;
      rf262( ) ;
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
      rf262( ) ;
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
      dynavDvelop_ecommercecart__producttalle.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavDvelop_ecommercecart__producttalle.getInternalname(), "Enabled", GXutil.ltrimstr( dynavDvelop_ecommercecart__producttalle.getEnabled(), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productqty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productqty_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavProducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttotal_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavRemoveitem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRemoveitem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRemoveitem_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavTotvalueproducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueproducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueproducttotal_Enabled), 5, 0), true);
      edtavWizarddata_address_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_name_Enabled), 5, 0), true);
      edtavWizarddata_address_phone_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_phone_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_phone_Enabled), 5, 0), true);
      edtavWizarddata_address_country_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_country_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_country_Enabled), 5, 0), true);
      edtavWizarddata_address_department_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_department_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_department_Enabled), 5, 0), true);
      edtavWizarddata_address_address_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_address_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_address_Enabled), 5, 0), true);
      edtavWizarddata_payment_paymentdata_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_payment_paymentdata_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_payment_paymentdata_description_Enabled), 5, 0), true);
      edtavWizarddata_payment_paymentdata2_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_payment_paymentdata2_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_payment_paymentdata2_description_Enabled), 5, 0), true);
      edtavWizarddata_payment_paymentdata3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_payment_paymentdata3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_payment_paymentdata3_Enabled), 5, 0), true);
   }

   public void rf262( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Griddvelop_ecommercecartsContainer.ClearRows();
      }
      wbStart = (short)(24) ;
      /* Execute user event: Refresh */
      e16262 ();
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
         e17262 ();
         if ( ( GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord > 0 ) && ( GRIDDVELOP_ECOMMERCECARTS_nGridOutOfScope == 0 ) && ( nGXsfl_24_idx == 1 ) )
         {
            GRIDDVELOP_ECOMMERCECARTS_nCurrentRecord = 0 ;
            GRIDDVELOP_ECOMMERCECARTS_nGridOutOfScope = 1 ;
            subgriddvelop_ecommercecarts_firstpage( ) ;
            e17262 ();
         }
         wbEnd = (short)(24) ;
         wb260( ) ;
      }
      bGXsfl_24_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes262( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
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
      return AV15DVelop_ECommerceCart.size() ;
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
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
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
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
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
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
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
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
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
         gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
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
      dynavDvelop_ecommercecart__producttalle.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavDvelop_ecommercecart__producttalle.getInternalname(), "Enabled", GXutil.ltrimstr( dynavDvelop_ecommercecart__producttalle.getEnabled(), 5, 0), !bGXsfl_24_Refreshing);
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavDvelop_ecommercecart__productqty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDvelop_ecommercecart__productqty_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavProducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavProducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProducttotal_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavRemoveitem_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavRemoveitem_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRemoveitem_Enabled), 5, 0), !bGXsfl_24_Refreshing);
      edtavTotvalueproducttotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavTotvalueproducttotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTotvalueproducttotal_Enabled), 5, 0), true);
      edtavWizarddata_address_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_name_Enabled), 5, 0), true);
      edtavWizarddata_address_phone_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_phone_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_phone_Enabled), 5, 0), true);
      edtavWizarddata_address_country_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_country_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_country_Enabled), 5, 0), true);
      edtavWizarddata_address_department_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_department_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_department_Enabled), 5, 0), true);
      edtavWizarddata_address_address_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_address_address_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_address_address_Enabled), 5, 0), true);
      edtavWizarddata_payment_paymentdata_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_payment_paymentdata_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_payment_paymentdata_description_Enabled), 5, 0), true);
      edtavWizarddata_payment_paymentdata2_description_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_payment_paymentdata2_description_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_payment_paymentdata2_description_Enabled), 5, 0), true);
      edtavWizarddata_payment_paymentdata3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavWizarddata_payment_paymentdata3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWizarddata_payment_paymentdata3_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup260( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15262 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vWIZARDDATA"), AV11WizardData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"Dvelop_ecommercecart"), AV15DVelop_ECommerceCart);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"Wizarddata"), AV11WizardData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vDVELOP_ECOMMERCECART"), AV15DVelop_ECommerceCart);
         /* Read saved values. */
         nRC_GXsfl_24 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_24"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         wcpOAV6WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV6WebSessionKey") ;
         wcpOAV8PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV8PreviousStep") ;
         wcpOAV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV7GoingBack")) ;
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
            AV27GXV1 = (int)(nGXsfl_24_fel_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
            if ( ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) && ( AV27GXV1 > 0 ) )
            {
               AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
               AV13ProductImage = httpContext.cgiGet( edtavProductimage_Internalname) ;
               if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)), DecimalUtil.stringToDec("99999.99")) > 0 ) ) )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPRODUCTTOTAL");
                  GX_FocusControl = edtavProducttotal_Internalname ;
                  wbErr = true ;
                  AV16ProductTotal = DecimalUtil.ZERO ;
               }
               else
               {
                  AV16ProductTotal = localUtil.ctond( httpContext.cgiGet( edtavProducttotal_Internalname)) ;
               }
               AV21RemoveItem = httpContext.cgiGet( edtavRemoveitem_Internalname) ;
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
         AV18TotValueProductTotal = httpContext.cgiGet( edtavTotvalueproducttotal_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18TotValueProductTotal", AV18TotValueProductTotal);
         AV11WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Name( httpContext.cgiGet( edtavWizarddata_address_name_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Phone( httpContext.cgiGet( edtavWizarddata_address_phone_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Country( httpContext.cgiGet( edtavWizarddata_address_country_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Department( httpContext.cgiGet( edtavWizarddata_address_department_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Address( httpContext.cgiGet( edtavWizarddata_address_address_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata_description( httpContext.cgiGet( edtavWizarddata_payment_paymentdata_description_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description( httpContext.cgiGet( edtavWizarddata_payment_paymentdata2_description_Internalname) );
         AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata3( httpContext.cgiGet( edtavWizarddata_payment_paymentdata3_Internalname) );
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
      e15262 ();
      if (returnInSub) return;
   }

   public void e15262( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      Griddvelop_ecommercecarts_empowerer_Gridinternalname = subGriddvelop_ecommercecarts_Internalname ;
      ucGriddvelop_ecommercecarts_empowerer.sendProperty(context, sPrefix, false, Griddvelop_ecommercecarts_empowerer_Internalname, "GridInternalName", Griddvelop_ecommercecarts_empowerer_Gridinternalname);
      subGriddvelop_ecommercecarts_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRIDDVELOP_ECOMMERCECARTS_Rows", GXutil.ltrim( localUtil.ntoc( subGriddvelop_ecommercecarts_Rows, (byte)(6), (byte)(0), ".", "")));
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = AV15DVelop_ECommerceCart ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      new com.mujermorena.wwpbaseobjects.getcartcontent(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item2) ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] ;
      AV15DVelop_ECommerceCart = GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
      gx_BV24 = true ;
   }

   public void e16262( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV17TotProductTotal = DecimalUtil.doubleToDec(0) ;
      AV42GXV16 = 1 ;
      while ( AV42GXV16 <= AV15DVelop_ECommerceCart.size() )
      {
         AV22DVelop_ECommerceCartItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV42GXV16));
         AV17TotProductTotal = AV17TotProductTotal.add((AV22DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productprice().multiply(DecimalUtil.doubleToDec(AV22DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty())))) ;
         AV42GXV16 = (int)(AV42GXV16+1) ;
      }
      AV18TotValueProductTotal = httpContext.getMessage( "WWP_CartTotal", "") + ": " + "Gs" + localUtil.format( AV17TotProductTotal, "ZZ,ZZ9.99") ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18TotValueProductTotal", AV18TotValueProductTotal);
      /*  Sending Event outputs  */
   }

   private void e17262( )
   {
      /* Griddvelop_ecommercecarts_Load Routine */
      returnInSub = false ;
      AV27GXV1 = 1 ;
      while ( AV27GXV1 <= AV15DVelop_ECommerceCart.size() )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
         AV16ProductTotal = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV15DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice().multiply(DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV15DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProducttotal_Internalname, GXutil.ltrimstr( AV16ProductTotal, 8, 2));
         if ( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV15DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().size() > 0 )
         {
            AV43Productimage_GXI = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV15DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Images().elementAt(-1+1) ;
            AV13ProductImage = "" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavProductimage_Internalname, AV13ProductImage);
         }
         AV14ProductPrice = ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV15DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productsim() + " " + localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)(AV15DVelop_ECommerceCart.currentItem())).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99") ;
         AV21RemoveItem = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, edtavRemoveitem_Internalname, AV21RemoveItem);
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
         AV27GXV1 = (int)(AV27GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e11262 ();
      if (returnInSub) return;
   }

   public void e11262( )
   {
      AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      if ( ! AV10HasValidationErrors )
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S122 ();
         if (returnInSub) return;
         callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("PlaceOrder")),GXutil.URLEncode(GXutil.rtrim("Completed")),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV44GXV17 = 1 ;
      while ( AV44GXV17 <= AV15DVelop_ECommerceCart.size() )
      {
         AV22DVelop_ECommerceCartItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV44GXV17));
         GXv_int3[0] = AV22DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle() ;
         GXv_int4[0] = AV22DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty() ;
         GXv_char5[0] = AV24Resp ;
         new com.mujermorena.validarsaldo(remoteHandle, context).execute( AV22DVelop_ECommerceCartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productid(), GXv_int3, GXv_int4, GXv_char5) ;
         AV22DVelop_ECommerceCartItem.setgxTv_SdtDVelop_ECommerceCart_Item_Producttalle( (short)(GXv_int3[0]) );
         AV22DVelop_ECommerceCartItem.setgxTv_SdtDVelop_ECommerceCart_Item_Productqty( GXv_int4[0] );
         cartcheckoutplaceorder_impl.this.AV24Resp = GXv_char5[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24Resp", AV24Resp);
         AV44GXV17 = (int)(AV44GXV17+1) ;
      }
      if ( GXutil.strcmp(AV24Resp, httpContext.getMessage( "OK", "")) == 0 )
      {
         GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] = AV15DVelop_ECommerceCart ;
         GXv_SdtCartCheckoutData6[0] = AV11WizardData;
         new com.mujermorena.confirmarpedido(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item2, GXv_SdtCartCheckoutData6) ;
         AV15DVelop_ECommerceCart = GXv_objcol_SdtDVelop_ECommerceCart_Item2[0] ;
         AV11WizardData = GXv_SdtCartCheckoutData6[0] ;
         gx_BV24 = true ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Producto ya no esta disponible", "")+AV24Resp);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV11WizardData", AV11WizardData);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV15DVelop_ECommerceCart", AV15DVelop_ECommerceCart);
      nGXsfl_24_bak_idx = nGXsfl_24_idx ;
      gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
      nGXsfl_24_idx = nGXsfl_24_bak_idx ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
   }

   public void e12262( )
   {
      AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
      }
      /* 'WizardPrevious' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("PlaceOrder")),GXutil.URLEncode(GXutil.rtrim("Payment")),GXutil.URLEncode(GXutil.booltostr(true))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV11WizardData", AV11WizardData);
   }

   public void e13262( )
   {
      AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
      }
      /* 'WizardGoTo Payment' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("PlaceOrder")),GXutil.URLEncode(GXutil.rtrim("Payment")),GXutil.URLEncode(GXutil.booltostr(true))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV11WizardData", AV11WizardData);
   }

   public void e14262( )
   {
      AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
      }
      /* 'WizardGoTo Address' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S122 ();
      if (returnInSub) return;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("PlaceOrder")),GXutil.URLEncode(GXutil.rtrim("Address")),GXutil.URLEncode(GXutil.booltostr(true))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV11WizardData", AV11WizardData);
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV15DVelop_ECommerceCart = AV11WizardData.getgxTv_SdtCartCheckoutData_Placeorder().getgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart() ;
      gx_BV24 = true ;
   }

   public void S122( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV11WizardData.getgxTv_SdtCartCheckoutData_Placeorder().setgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart( AV15DVelop_ECommerceCart );
      AV5WebSession.setValue(AV6WebSessionKey, AV11WizardData.toJSonString(false, true));
   }

   public void e18262( )
   {
      AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
      }
      /* Dvelop_ecommercecart__productqty_Isvalid Routine */
      returnInSub = false ;
      new com.mujermorena.wwpbaseobjects.updatecart(remoteHandle, context).execute( AV15DVelop_ECommerceCart) ;
      this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "CartChanged", new Object[] {}, true);
   }

   public void e19262( )
   {
      AV27GXV1 = (int)(nGXsfl_24_idx+GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage) ;
      if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) )
      {
         AV15DVelop_ECommerceCart.currentItem( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)) );
      }
      /* Removeitem_Click Routine */
      returnInSub = false ;
      AV15DVelop_ECommerceCart.removeItem(AV15DVelop_ECommerceCart.indexof(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.currentItem())));
      gx_BV24 = true ;
      new com.mujermorena.wwpbaseobjects.updatecart(remoteHandle, context).execute( AV15DVelop_ECommerceCart) ;
      this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "CartChanged", new Object[] {}, true);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV15DVelop_ECommerceCart", AV15DVelop_ECommerceCart);
      nGXsfl_24_bak_idx = nGXsfl_24_idx ;
      gxgrgriddvelop_ecommercecarts_refresh( subGriddvelop_ecommercecarts_Rows, AV15DVelop_ECommerceCart, AV10HasValidationErrors, sPrefix) ;
      nGXsfl_24_idx = nGXsfl_24_bak_idx ;
      sGXsfl_24_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_24_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_242( ) ;
   }

   public void wb_table1_36_262( boolean wbgen )
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
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTotvalueproducttotal_Internalname, httpContext.getMessage( "Tot Value Product Total", ""), "gx-form-item AttributeRealWidthTotalizerLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'" + sPrefix + "',false,'" + sGXsfl_24_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTotvalueproducttotal_Internalname, AV18TotValueProductTotal, GXutil.rtrim( localUtil.format( AV18TotValueProductTotal, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotvalueproducttotal_Jsonclick, 0, "AttributeRealWidthTotalizer", "", "", "", "", 1, edtavTotvalueproducttotal_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPlaceOrder.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_36_262e( true) ;
      }
      else
      {
         wb_table1_36_262e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV6WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
      AV8PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
      AV7GoingBack = ((Boolean) getParm(obj,2,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
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
      pa262( ) ;
      ws262( ) ;
      we262( ) ;
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
      sCtrlAV6WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV8PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV7GoingBack = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa262( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\cartcheckoutplaceorder", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa262( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV6WebSessionKey = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
         AV8PreviousStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
         AV7GoingBack = ((Boolean) getParm(obj,4,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
      }
      wcpOAV6WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV6WebSessionKey") ;
      wcpOAV8PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV8PreviousStep") ;
      wcpOAV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV7GoingBack")) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV6WebSessionKey, wcpOAV6WebSessionKey) != 0 ) || ( GXutil.strcmp(AV8PreviousStep, wcpOAV8PreviousStep) != 0 ) || ( AV7GoingBack != wcpOAV7GoingBack ) ) )
      {
         setjustcreated();
      }
      wcpOAV6WebSessionKey = AV6WebSessionKey ;
      wcpOAV8PreviousStep = AV8PreviousStep ;
      wcpOAV7GoingBack = AV7GoingBack ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV6WebSessionKey = httpContext.cgiGet( sPrefix+"AV6WebSessionKey_CTRL") ;
      if ( GXutil.len( sCtrlAV6WebSessionKey) > 0 )
      {
         AV6WebSessionKey = httpContext.cgiGet( sCtrlAV6WebSessionKey) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6WebSessionKey", AV6WebSessionKey);
      }
      else
      {
         AV6WebSessionKey = httpContext.cgiGet( sPrefix+"AV6WebSessionKey_PARM") ;
      }
      sCtrlAV8PreviousStep = httpContext.cgiGet( sPrefix+"AV8PreviousStep_CTRL") ;
      if ( GXutil.len( sCtrlAV8PreviousStep) > 0 )
      {
         AV8PreviousStep = httpContext.cgiGet( sCtrlAV8PreviousStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8PreviousStep", AV8PreviousStep);
      }
      else
      {
         AV8PreviousStep = httpContext.cgiGet( sPrefix+"AV8PreviousStep_PARM") ;
      }
      sCtrlAV7GoingBack = httpContext.cgiGet( sPrefix+"AV7GoingBack_CTRL") ;
      if ( GXutil.len( sCtrlAV7GoingBack) > 0 )
      {
         AV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sCtrlAV7GoingBack)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7GoingBack", AV7GoingBack);
      }
      else
      {
         AV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV7GoingBack_PARM")) ;
      }
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
      pa262( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws262( ) ;
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
      ws262( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6WebSessionKey_PARM", AV6WebSessionKey);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV6WebSessionKey)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV6WebSessionKey_CTRL", GXutil.rtrim( sCtrlAV6WebSessionKey));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8PreviousStep_PARM", AV8PreviousStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV8PreviousStep)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV8PreviousStep_CTRL", GXutil.rtrim( sCtrlAV8PreviousStep));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7GoingBack_PARM", GXutil.booltostr( AV7GoingBack));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV7GoingBack)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV7GoingBack_CTRL", GXutil.rtrim( sCtrlAV7GoingBack));
      }
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
      we262( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024121116472", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/cartcheckoutplaceorder.js", "?2024121116472", false, true);
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
      dynavDvelop_ecommercecart__producttalle.setInternalname( sPrefix+"DVELOP_ECOMMERCECART__PRODUCTTALLE_"+sGXsfl_24_idx );
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
      dynavDvelop_ecommercecart__producttalle.setInternalname( sPrefix+"DVELOP_ECOMMERCECART__PRODUCTTALLE_"+sGXsfl_24_fel_idx );
      edtavDvelop_ecommercecart__productqty_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTQTY_"+sGXsfl_24_fel_idx ;
      edtavProducttotal_Internalname = sPrefix+"vPRODUCTTOTAL_"+sGXsfl_24_fel_idx ;
      edtavRemoveitem_Internalname = sPrefix+"vREMOVEITEM_"+sGXsfl_24_fel_idx ;
   }

   public void sendrow_242( )
   {
      subsflControlProps_242( ) ;
      wb260( ) ;
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
         AV13ProductImage_IsBlob = (boolean)(((GXutil.strcmp("", AV13ProductImage)==0)&&(GXutil.strcmp("", AV43Productimage_GXI)==0))||!(GXutil.strcmp("", AV13ProductImage)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV13ProductImage)==0) ? AV43Productimage_GXI : httpContext.getResourceRelative(AV13ProductImage)) ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavProductimage_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(80),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn hidden-xs","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV13ProductImage_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productid(), (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productid()), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productid()), "ZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productid_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavDvelop_ecommercecart__productid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productname_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productname(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productname_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDvelop_ecommercecart__productname_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productsim_Internalname,((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productsim(),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productsim_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavDvelop_ecommercecart__productsim_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productprice_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productprice_Enabled!=0) ? localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99") : localUtil.format( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productprice(), "ZZ,ZZ9.99"))),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productprice_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDvelop_ecommercecart__productprice_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(65),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( dynavDvelop_ecommercecart__producttalle.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DVELOP_ECOMMERCECART__PRODUCTTALLE_" + sGXsfl_24_idx ;
            dynavDvelop_ecommercecart__producttalle.setName( GXCCtl );
            dynavDvelop_ecommercecart__producttalle.setWebtags( "" );
            dynavDvelop_ecommercecart__producttalle.removeAllItems();
            /* Using cursor H00262 */
            pr_default.execute(0);
            while ( (pr_default.getStatus(0) != 101) )
            {
               dynavDvelop_ecommercecart__producttalle.addItem(GXutil.trim( GXutil.str( H00262_A286TallaID[0], 4, 0)), H00262_A287TallaNombre[0], (short)(0));
               pr_default.readNext(0);
            }
            pr_default.close(0);
            if ( dynavDvelop_ecommercecart__producttalle.getItemCount() > 0 )
            {
               if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) && (0==((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle()) )
               {
                  ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).setgxTv_SdtDVelop_ECommerceCart_Item_Producttalle( (short)(GXutil.lval( dynavDvelop_ecommercecart__producttalle.getValidValue(GXutil.trim( GXutil.str( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle(), 4, 0))))) );
               }
            }
         }
         /* ComboBox */
         Griddvelop_ecommercecartsRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynavDvelop_ecommercecart__producttalle,dynavDvelop_ecommercecart__producttalle.getInternalname(),GXutil.trim( GXutil.str( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle(), 4, 0)),Integer.valueOf(1),dynavDvelop_ecommercecart__producttalle.getJsonclick(),Integer.valueOf(0),"'"+sPrefix+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(dynavDvelop_ecommercecart__producttalle.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(65),"px",Integer.valueOf(0),"px","","AttributeRealWidth","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         dynavDvelop_ecommercecart__producttalle.setValue( GXutil.trim( GXutil.str( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle(), 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavDvelop_ecommercecart__producttalle.getInternalname(), "Values", dynavDvelop_ecommercecart__producttalle.ToJavascriptSource(), !bGXsfl_24_Refreshing);
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "AttributeECommerceDetailQty" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDvelop_ecommercecart__productqty_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty(), (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavDvelop_ecommercecart__productqty_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Productqty()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavDvelop_ecommercecart__productqty_Jsonclick,Integer.valueOf(0),"AttributeECommerceDetailQty","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDvelop_ecommercecart__productqty_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(65),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavProducttotal_Enabled!=0)&&(edtavProducttotal_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 32,'"+sPrefix+"',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavProducttotal_Internalname,GXutil.ltrim( localUtil.ntoc( AV16ProductTotal, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavProducttotal_Enabled!=0) ? localUtil.format( AV16ProductTotal, "ZZ,ZZ9.99") : localUtil.format( AV16ProductTotal, "ZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+((edtavProducttotal_Enabled!=0)&&(edtavProducttotal_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,32);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavProducttotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavProducttotal_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"WWPBaseObjects\\WWPECommercePrice","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Griddvelop_ecommercecartsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavRemoveitem_Enabled!=0)&&(edtavRemoveitem_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 33,'"+sPrefix+"',false,'"+sGXsfl_24_idx+"',24)\"" : " ") ;
         ROClassString = "Attribute" ;
         Griddvelop_ecommercecartsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavRemoveitem_Internalname,GXutil.rtrim( AV21RemoveItem),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavRemoveitem_Enabled!=0)&&(edtavRemoveitem_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,33);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EVREMOVEITEM.CLICK."+sGXsfl_24_idx+"'","","",httpContext.getMessage( "Remove item", ""),"",edtavRemoveitem_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavRemoveitem_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(24),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes262( ) ;
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
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Product Sim", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(65), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_CartPrice", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(65), 4, 0)+"px"+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Talla", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" width="+GXutil.ltrimstr( DecimalUtil.doubleToDec(65), 4, 0)+"px"+" class=\""+"AttributeECommerceDetailQty"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cantidad", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_CartTotal", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
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
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Value", httpContext.convertURL( AV13ProductImage));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productid_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productname_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productsim_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productprice_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynavDvelop_ecommercecart__producttalle.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDvelop_ecommercecart__productqty_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV16ProductTotal, (byte)(9), (byte)(2), ".", "")));
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavProducttotal_Enabled, (byte)(5), (byte)(0), ".", "")));
         Griddvelop_ecommercecartsContainer.AddColumnProperties(Griddvelop_ecommercecartsColumn);
         Griddvelop_ecommercecartsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Griddvelop_ecommercecartsColumn.AddObjectProperty("Value", GXutil.rtrim( AV21RemoveItem));
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
      lblProducts_summarytitle_Internalname = sPrefix+"PRODUCTS_SUMMARYTITLE" ;
      divProducts_summaryheadertable_Internalname = sPrefix+"PRODUCTS_SUMMARYHEADERTABLE" ;
      edtavProductimage_Internalname = sPrefix+"vPRODUCTIMAGE" ;
      edtavDvelop_ecommercecart__productid_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTID" ;
      edtavDvelop_ecommercecart__productname_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTNAME" ;
      edtavDvelop_ecommercecart__productsim_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTSIM" ;
      edtavDvelop_ecommercecart__productprice_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTPRICE" ;
      dynavDvelop_ecommercecart__producttalle.setInternalname( sPrefix+"DVELOP_ECOMMERCECART__PRODUCTTALLE" );
      edtavDvelop_ecommercecart__productqty_Internalname = sPrefix+"DVELOP_ECOMMERCECART__PRODUCTQTY" ;
      edtavProducttotal_Internalname = sPrefix+"vPRODUCTTOTAL" ;
      edtavRemoveitem_Internalname = sPrefix+"vREMOVEITEM" ;
      edtavTotvalueproducttotal_Internalname = sPrefix+"vTOTVALUEPRODUCTTOTAL" ;
      tblGriddvelop_ecommercecartstabletotalizer_Internalname = sPrefix+"GRIDDVELOP_ECOMMERCECARTSTABLETOTALIZER" ;
      divGriddvelop_ecommercecartstablewithtotalizers_Internalname = sPrefix+"GRIDDVELOP_ECOMMERCECARTSTABLEWITHTOTALIZERS" ;
      divProducts_tablegrid_Internalname = sPrefix+"PRODUCTS_TABLEGRID" ;
      divProducts_summarytable_Internalname = sPrefix+"PRODUCTS_SUMMARYTABLE" ;
      lblAddress_summarytitle_Internalname = sPrefix+"ADDRESS_SUMMARYTITLE" ;
      bttBtnwizardgotoaddress_Internalname = sPrefix+"BTNWIZARDGOTOADDRESS" ;
      divAddress_summaryheadertable_Internalname = sPrefix+"ADDRESS_SUMMARYHEADERTABLE" ;
      edtavWizarddata_address_name_Internalname = sPrefix+"WIZARDDATA_ADDRESS_NAME" ;
      edtavWizarddata_address_phone_Internalname = sPrefix+"WIZARDDATA_ADDRESS_PHONE" ;
      edtavWizarddata_address_country_Internalname = sPrefix+"WIZARDDATA_ADDRESS_COUNTRY" ;
      edtavWizarddata_address_department_Internalname = sPrefix+"WIZARDDATA_ADDRESS_DEPARTMENT" ;
      edtavWizarddata_address_address_Internalname = sPrefix+"WIZARDDATA_ADDRESS_ADDRESS" ;
      divAddress_tableattributes_Internalname = sPrefix+"ADDRESS_TABLEATTRIBUTES" ;
      divAddress_summarytable_Internalname = sPrefix+"ADDRESS_SUMMARYTABLE" ;
      lblPayment_summarytitle_Internalname = sPrefix+"PAYMENT_SUMMARYTITLE" ;
      bttBtnwizardgotopayment_Internalname = sPrefix+"BTNWIZARDGOTOPAYMENT" ;
      divPayment_summaryheadertable_Internalname = sPrefix+"PAYMENT_SUMMARYHEADERTABLE" ;
      edtavWizarddata_payment_paymentdata_description_Internalname = sPrefix+"WIZARDDATA_PAYMENT_PAYMENTDATA_DESCRIPTION" ;
      edtavWizarddata_payment_paymentdata2_description_Internalname = sPrefix+"WIZARDDATA_PAYMENT_PAYMENTDATA2_DESCRIPTION" ;
      edtavWizarddata_payment_paymentdata3_Internalname = sPrefix+"WIZARDDATA_PAYMENT_PAYMENTDATA3" ;
      divPayment_tableattributes_Internalname = sPrefix+"PAYMENT_TABLEATTRIBUTES" ;
      divPayment_summarytable_Internalname = sPrefix+"PAYMENT_SUMMARYTABLE" ;
      bttBtnwizardprevious_Internalname = sPrefix+"BTNWIZARDPREVIOUS" ;
      bttBtnwizardnext_Internalname = sPrefix+"BTNWIZARDNEXT" ;
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
      dynavDvelop_ecommercecart__producttalle.setJsonclick( "" );
      dynavDvelop_ecommercecart__producttalle.setEnabled( 0 );
      edtavDvelop_ecommercecart__productprice_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart__productid_Jsonclick = "" ;
      edtavDvelop_ecommercecart__productid_Enabled = 0 ;
      edtavProductimage_gximage = "" ;
      subGriddvelop_ecommercecarts_Class = "GridWithTotalizer WorkWith" ;
      subGriddvelop_ecommercecarts_Backcolorstyle = (byte)(0) ;
      edtavTotvalueproducttotal_Jsonclick = "" ;
      edtavTotvalueproducttotal_Enabled = 1 ;
      edtavWizarddata_payment_paymentdata3_Enabled = -1 ;
      edtavWizarddata_payment_paymentdata2_description_Enabled = -1 ;
      edtavWizarddata_payment_paymentdata_description_Enabled = -1 ;
      edtavWizarddata_address_address_Enabled = -1 ;
      edtavWizarddata_address_department_Enabled = -1 ;
      edtavWizarddata_address_country_Enabled = -1 ;
      edtavWizarddata_address_phone_Enabled = -1 ;
      edtavWizarddata_address_name_Enabled = -1 ;
      edtavDvelop_ecommercecart__productqty_Enabled = -1 ;
      dynavDvelop_ecommercecart__producttalle.setEnabled( -1 );
      edtavDvelop_ecommercecart__productprice_Enabled = -1 ;
      edtavDvelop_ecommercecart__productsim_Enabled = -1 ;
      edtavDvelop_ecommercecart__productname_Enabled = -1 ;
      edtavDvelop_ecommercecart__productid_Enabled = -1 ;
      edtavWizarddata_payment_paymentdata3_Jsonclick = "" ;
      edtavWizarddata_payment_paymentdata3_Enabled = 0 ;
      edtavWizarddata_payment_paymentdata2_description_Jsonclick = "" ;
      edtavWizarddata_payment_paymentdata2_description_Enabled = 0 ;
      edtavWizarddata_payment_paymentdata_description_Jsonclick = "" ;
      edtavWizarddata_payment_paymentdata_description_Enabled = 0 ;
      edtavWizarddata_address_address_Enabled = 0 ;
      edtavWizarddata_address_department_Jsonclick = "" ;
      edtavWizarddata_address_department_Enabled = 0 ;
      edtavWizarddata_address_country_Jsonclick = "" ;
      edtavWizarddata_address_country_Enabled = 0 ;
      edtavWizarddata_address_phone_Jsonclick = "" ;
      edtavWizarddata_address_phone_Enabled = 0 ;
      edtavWizarddata_address_name_Jsonclick = "" ;
      edtavWizarddata_address_name_Enabled = 0 ;
      subGriddvelop_ecommercecarts_Rows = 0 ;
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
      GXCCtl = "DVELOP_ECOMMERCECART__PRODUCTTALLE_" + sGXsfl_24_idx ;
      dynavDvelop_ecommercecart__producttalle.setName( GXCCtl );
      dynavDvelop_ecommercecart__producttalle.setWebtags( "" );
      dynavDvelop_ecommercecart__producttalle.removeAllItems();
      /* Using cursor H00263 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         dynavDvelop_ecommercecart__producttalle.addItem(GXutil.trim( GXutil.str( H00263_A286TallaID[0], 4, 0)), H00263_A287TallaNombre[0], (short)(0));
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( dynavDvelop_ecommercecart__producttalle.getItemCount() > 0 )
      {
         if ( ( AV27GXV1 > 0 ) && ( AV15DVelop_ECommerceCart.size() >= AV27GXV1 ) && (0==((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV15DVelop_ECommerceCart.elementAt(-1+AV27GXV1)).getgxTv_SdtDVelop_ECommerceCart_Item_Producttalle()) )
         {
         }
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV18TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS.LOAD","{handler:'e17262',iparms:[{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS.LOAD",",oparms:[{av:'AV16ProductTotal',fld:'vPRODUCTTOTAL',pic:'ZZ,ZZ9.99'},{av:'AV13ProductImage',fld:'vPRODUCTIMAGE',pic:''},{av:'AV21RemoveItem',fld:'vREMOVEITEM',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e11262',iparms:[{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24},{av:'AV24Resp',fld:'vRESP',pic:''},{av:'AV11WizardData',fld:'vWIZARDDATA',pic:''},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV24Resp',fld:'vRESP',pic:''},{av:'AV11WizardData',fld:'vWIZARDDATA',pic:''},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e12262',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[{av:'AV11WizardData',fld:'vWIZARDDATA',pic:''}]}");
      setEventMetadata("'WIZARDGOTO PAYMENT'","{handler:'e13262',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("'WIZARDGOTO PAYMENT'",",oparms:[{av:'AV11WizardData',fld:'vWIZARDDATA',pic:''}]}");
      setEventMetadata("'WIZARDGOTO ADDRESS'","{handler:'e14262',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("'WIZARDGOTO ADDRESS'",",oparms:[{av:'AV11WizardData',fld:'vWIZARDDATA',pic:''}]}");
      setEventMetadata("DVELOP_ECOMMERCECART__PRODUCTQTY.ISVALID","{handler:'e18262',iparms:[{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("DVELOP_ECOMMERCECART__PRODUCTQTY.ISVALID",",oparms:[]}");
      setEventMetadata("VREMOVEITEM.CLICK","{handler:'e19262',iparms:[{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'sPrefix'},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true}]");
      setEventMetadata("VREMOVEITEM.CLICK",",oparms:[{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_FIRSTPAGE","{handler:'subgriddvelop_ecommercecarts_firstpage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'sPrefix'},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_FIRSTPAGE",",oparms:[{av:'AV18TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_PREVPAGE","{handler:'subgriddvelop_ecommercecarts_previouspage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'sPrefix'},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_PREVPAGE",",oparms:[{av:'AV18TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_NEXTPAGE","{handler:'subgriddvelop_ecommercecarts_nextpage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'sPrefix'},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_NEXTPAGE",",oparms:[{av:'AV18TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''}]}");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_LASTPAGE","{handler:'subgriddvelop_ecommercecarts_lastpage',iparms:[{av:'GRIDDVELOP_ECOMMERCECARTS_nFirstRecordOnPage'},{av:'GRIDDVELOP_ECOMMERCECARTS_nEOF'},{av:'subGriddvelop_ecommercecarts_Rows',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'Rows'},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'sPrefix'},{av:'AV15DVelop_ECommerceCart',fld:'vDVELOP_ECOMMERCECART',grid:24,pic:''},{av:'nGXsfl_24_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:24},{av:'nRC_GXsfl_24',ctrl:'GRIDDVELOP_ECOMMERCECARTS',prop:'GridRC',grid:24}]");
      setEventMetadata("GRIDDVELOP_ECOMMERCECARTS_LASTPAGE",",oparms:[{av:'AV18TotValueProductTotal',fld:'vTOTVALUEPRODUCTTOTAL',pic:''}]}");
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
      wcpOAV6WebSessionKey = "" ;
      wcpOAV8PreviousStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV6WebSessionKey = "" ;
      AV8PreviousStep = "" ;
      AV15DVelop_ECommerceCart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV11WizardData = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData(remoteHandle, context);
      AV24Resp = "" ;
      Griddvelop_ecommercecarts_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      lblProducts_summarytitle_Jsonclick = "" ;
      Griddvelop_ecommercecartsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      lblAddress_summarytitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnwizardgotoaddress_Jsonclick = "" ;
      lblPayment_summarytitle_Jsonclick = "" ;
      bttBtnwizardgotopayment_Jsonclick = "" ;
      bttBtnwizardprevious_Jsonclick = "" ;
      bttBtnwizardnext_Jsonclick = "" ;
      ucGriddvelop_ecommercecarts_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV13ProductImage = "" ;
      AV43Productimage_GXI = "" ;
      AV16ProductTotal = DecimalUtil.ZERO ;
      AV21RemoveItem = "" ;
      AV18TotValueProductTotal = "" ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      AV17TotProductTotal = DecimalUtil.ZERO ;
      AV22DVelop_ECommerceCartItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      AV14ProductPrice = "" ;
      Griddvelop_ecommercecartsRow = new com.genexus.webpanels.GXWebRow();
      GXv_int3 = new long[1] ;
      GXv_int4 = new short[1] ;
      GXv_char5 = new String[1] ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item2 = new GXBaseCollection[1] ;
      GXv_SdtCartCheckoutData6 = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData[1] ;
      AV5WebSession = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6WebSessionKey = "" ;
      sCtrlAV8PreviousStep = "" ;
      sCtrlAV7GoingBack = "" ;
      subGriddvelop_ecommercecarts_Linesclass = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      scmdbuf = "" ;
      H00262_A286TallaID = new long[1] ;
      H00262_A287TallaNombre = new String[] {""} ;
      Griddvelop_ecommercecartsColumn = new com.genexus.webpanels.GXWebColumn();
      H00263_A286TallaID = new long[1] ;
      H00263_A287TallaNombre = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.cartcheckoutplaceorder__default(),
         new Object[] {
             new Object[] {
            H00262_A286TallaID, H00262_A287TallaNombre
            }
            , new Object[] {
            H00263_A286TallaID, H00263_A287TallaNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavDvelop_ecommercecart__productid_Enabled = 0 ;
      edtavDvelop_ecommercecart__productname_Enabled = 0 ;
      edtavDvelop_ecommercecart__productsim_Enabled = 0 ;
      edtavDvelop_ecommercecart__productprice_Enabled = 0 ;
      dynavDvelop_ecommercecart__producttalle.setEnabled( 0 );
      edtavDvelop_ecommercecart__productqty_Enabled = 0 ;
      edtavProducttotal_Enabled = 0 ;
      edtavRemoveitem_Enabled = 0 ;
      edtavTotvalueproducttotal_Enabled = 0 ;
      edtavWizarddata_address_name_Enabled = 0 ;
      edtavWizarddata_address_phone_Enabled = 0 ;
      edtavWizarddata_address_country_Enabled = 0 ;
      edtavWizarddata_address_department_Enabled = 0 ;
      edtavWizarddata_address_address_Enabled = 0 ;
      edtavWizarddata_payment_paymentdata_description_Enabled = 0 ;
      edtavWizarddata_payment_paymentdata2_description_Enabled = 0 ;
      edtavWizarddata_payment_paymentdata3_Enabled = 0 ;
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
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int4[] ;
   private int nRC_GXsfl_24 ;
   private int subGriddvelop_ecommercecarts_Rows ;
   private int nGXsfl_24_idx=1 ;
   private int AV27GXV1 ;
   private int edtavWizarddata_address_name_Enabled ;
   private int edtavWizarddata_address_phone_Enabled ;
   private int edtavWizarddata_address_country_Enabled ;
   private int edtavWizarddata_address_department_Enabled ;
   private int edtavWizarddata_address_address_Enabled ;
   private int edtavWizarddata_payment_paymentdata_description_Enabled ;
   private int edtavWizarddata_payment_paymentdata2_description_Enabled ;
   private int edtavWizarddata_payment_paymentdata3_Enabled ;
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
   private int AV42GXV16 ;
   private int AV44GXV17 ;
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
   private long GXv_int3[] ;
   private java.math.BigDecimal AV16ProductTotal ;
   private java.math.BigDecimal AV17TotProductTotal ;
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
   private String AV24Resp ;
   private String Griddvelop_ecommercecarts_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divProducts_summarytable_Internalname ;
   private String divProducts_summaryheadertable_Internalname ;
   private String lblProducts_summarytitle_Internalname ;
   private String lblProducts_summarytitle_Jsonclick ;
   private String divProducts_tablegrid_Internalname ;
   private String divGriddvelop_ecommercecartstablewithtotalizers_Internalname ;
   private String sStyleString ;
   private String subGriddvelop_ecommercecarts_Internalname ;
   private String divAddress_summarytable_Internalname ;
   private String divAddress_summaryheadertable_Internalname ;
   private String lblAddress_summarytitle_Internalname ;
   private String lblAddress_summarytitle_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnwizardgotoaddress_Internalname ;
   private String bttBtnwizardgotoaddress_Jsonclick ;
   private String divAddress_tableattributes_Internalname ;
   private String edtavWizarddata_address_name_Internalname ;
   private String edtavWizarddata_address_name_Jsonclick ;
   private String edtavWizarddata_address_phone_Internalname ;
   private String edtavWizarddata_address_phone_Jsonclick ;
   private String edtavWizarddata_address_country_Internalname ;
   private String edtavWizarddata_address_country_Jsonclick ;
   private String edtavWizarddata_address_department_Internalname ;
   private String edtavWizarddata_address_department_Jsonclick ;
   private String edtavWizarddata_address_address_Internalname ;
   private String divPayment_summarytable_Internalname ;
   private String divPayment_summaryheadertable_Internalname ;
   private String lblPayment_summarytitle_Internalname ;
   private String lblPayment_summarytitle_Jsonclick ;
   private String bttBtnwizardgotopayment_Internalname ;
   private String bttBtnwizardgotopayment_Jsonclick ;
   private String divPayment_tableattributes_Internalname ;
   private String edtavWizarddata_payment_paymentdata_description_Internalname ;
   private String edtavWizarddata_payment_paymentdata_description_Jsonclick ;
   private String edtavWizarddata_payment_paymentdata2_description_Internalname ;
   private String edtavWizarddata_payment_paymentdata2_description_Jsonclick ;
   private String edtavWizarddata_payment_paymentdata3_Internalname ;
   private String edtavWizarddata_payment_paymentdata3_Jsonclick ;
   private String bttBtnwizardprevious_Internalname ;
   private String bttBtnwizardprevious_Jsonclick ;
   private String bttBtnwizardnext_Internalname ;
   private String bttBtnwizardnext_Jsonclick ;
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
   private String AV21RemoveItem ;
   private String edtavRemoveitem_Internalname ;
   private String edtavTotvalueproducttotal_Internalname ;
   private String edtavDvelop_ecommercecart__productname_Internalname ;
   private String edtavDvelop_ecommercecart__productsim_Internalname ;
   private String edtavDvelop_ecommercecart__productprice_Internalname ;
   private String edtavDvelop_ecommercecart__productqty_Internalname ;
   private String sGXsfl_24_fel_idx="0001" ;
   private String GXv_char5[] ;
   private String tblGriddvelop_ecommercecartstabletotalizer_Internalname ;
   private String edtavTotvalueproducttotal_Jsonclick ;
   private String sCtrlAV6WebSessionKey ;
   private String sCtrlAV8PreviousStep ;
   private String sCtrlAV7GoingBack ;
   private String subGriddvelop_ecommercecarts_Class ;
   private String subGriddvelop_ecommercecarts_Linesclass ;
   private String edtavProductimage_gximage ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtavDvelop_ecommercecart__productid_Jsonclick ;
   private String edtavDvelop_ecommercecart__productname_Jsonclick ;
   private String edtavDvelop_ecommercecart__productsim_Jsonclick ;
   private String edtavDvelop_ecommercecart__productprice_Jsonclick ;
   private String GXCCtl ;
   private String scmdbuf ;
   private String edtavDvelop_ecommercecart__productqty_Jsonclick ;
   private String edtavProducttotal_Jsonclick ;
   private String edtavRemoveitem_Jsonclick ;
   private String subGriddvelop_ecommercecarts_Header ;
   private boolean wcpOAV7GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV7GoingBack ;
   private boolean AV10HasValidationErrors ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_24_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV24 ;
   private boolean gx_refresh_fired ;
   private boolean AV13ProductImage_IsBlob ;
   private String wcpOAV6WebSessionKey ;
   private String wcpOAV8PreviousStep ;
   private String AV6WebSessionKey ;
   private String AV8PreviousStep ;
   private String AV43Productimage_GXI ;
   private String AV18TotValueProductTotal ;
   private String AV14ProductPrice ;
   private String AV13ProductImage ;
   private com.genexus.webpanels.GXWebGrid Griddvelop_ecommercecartsContainer ;
   private com.genexus.webpanels.GXWebRow Griddvelop_ecommercecartsRow ;
   private com.genexus.webpanels.GXWebColumn Griddvelop_ecommercecartsColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV5WebSession ;
   private com.genexus.webpanels.GXUserControl ucGriddvelop_ecommercecarts_empowerer ;
   private HTMLChoice dynavDvelop_ecommercecart__producttalle ;
   private IDataStoreProvider pr_default ;
   private long[] H00262_A286TallaID ;
   private String[] H00262_A287TallaNombre ;
   private long[] H00263_A286TallaID ;
   private String[] H00263_A287TallaNombre ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV15DVelop_ECommerceCart ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXt_objcol_SdtDVelop_ECommerceCart_Item1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXv_objcol_SdtDVelop_ECommerceCart_Item2[] ;
   private com.mujermorena.wwpbaseobjects.SdtCartCheckoutData AV11WizardData ;
   private com.mujermorena.wwpbaseobjects.SdtCartCheckoutData GXv_SdtCartCheckoutData6[] ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV22DVelop_ECommerceCartItem ;
}

final  class cartcheckoutplaceorder__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00262", "SELECT [TallaID], [TallaNombre] FROM [Talla] ORDER BY [TallaNombre] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00263", "SELECT [TallaID], [TallaNombre] FROM [Talla] ORDER BY [TallaNombre] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               return;
      }
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

