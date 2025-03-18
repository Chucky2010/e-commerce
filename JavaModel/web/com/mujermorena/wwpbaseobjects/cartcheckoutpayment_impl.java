package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cartcheckoutpayment_impl extends GXWebComponent
{
   public cartcheckoutpayment_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cartcheckoutpayment_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cartcheckoutpayment_impl.class ));
   }

   public cartcheckoutpayment_impl( int remoteHandle ,
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

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa252( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Cart Checkout Payment", "")) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.cartcheckoutpayment", new String[] {GXutil.URLEncode(GXutil.rtrim(AV6WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV8PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV7GoingBack))}, new String[] {"WebSessionKey","PreviousStep","GoingBack"}) +"\">") ;
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
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vPAYMENTDATA_DATA", AV14PaymentData_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vPAYMENTDATA_DATA", AV14PaymentData_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vPAYMENTDATA2_DATA", AV18PaymentData2_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vPAYMENTDATA2_DATA", AV18PaymentData2_Data);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV6WebSessionKey", wcpOAV6WebSessionKey);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV8PreviousStep", wcpOAV8PreviousStep);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV7GoingBack", wcpOAV7GoingBack);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCHECKREQUIREDFIELDSRESULT", AV13CheckRequiredFieldsResult);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV6WebSessionKey);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TIPOPAGOID", GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TIPOPAGONOMBRE", GXutil.rtrim( A71TipoPagoNombre));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"TIPOPAGODATO", GXutil.rtrim( A297TipoPagoDato));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV8PreviousStep);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV7GoingBack);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Cls", GXutil.rtrim( Combo_paymentdata_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Selectedvalue_set", GXutil.rtrim( Combo_paymentdata_Selectedvalue_set));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Emptyitemtext", GXutil.rtrim( Combo_paymentdata_Emptyitemtext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Cls", GXutil.rtrim( Combo_paymentdata2_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Selectedvalue_set", GXutil.rtrim( Combo_paymentdata2_Selectedvalue_set));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Emptyitemtext", GXutil.rtrim( Combo_paymentdata2_Emptyitemtext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Ddointernalname", GXutil.rtrim( Combo_paymentdata_Ddointernalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Ddointernalname", GXutil.rtrim( Combo_paymentdata2_Ddointernalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Selectedtext_get", GXutil.rtrim( Combo_paymentdata_Selectedtext_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Selectedtext_get", GXutil.rtrim( Combo_paymentdata2_Selectedtext_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Selectedvalue_get", GXutil.rtrim( Combo_paymentdata2_Selectedvalue_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Selectedvalue_get", GXutil.rtrim( Combo_paymentdata_Selectedvalue_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Ddointernalname", GXutil.rtrim( Combo_paymentdata_Ddointernalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Ddointernalname", GXutil.rtrim( Combo_paymentdata2_Ddointernalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Selectedtext_get", GXutil.rtrim( Combo_paymentdata_Selectedtext_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA2_Selectedtext_get", GXutil.rtrim( Combo_paymentdata2_Selectedtext_get));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"COMBO_PAYMENTDATA_Selectedvalue_get", GXutil.rtrim( Combo_paymentdata_Selectedvalue_get));
   }

   public void renderHtmlCloseForm252( )
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
      return "WWPBaseObjects.CartCheckoutPayment" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cart Checkout Payment", "") ;
   }

   public void wb250( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.cartcheckoutpayment");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContent", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
         ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
         ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
         ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
         ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
         ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
         ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
         ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
         ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
         ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, sPrefix+"DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+sPrefix+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedpaymentdata_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_paymentdata_Internalname, httpContext.getMessage( "Forma de Pago", ""), "", "", lblTextblockcombo_paymentdata_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_paymentdata.setProperty("Caption", Combo_paymentdata_Caption);
         ucCombo_paymentdata.setProperty("Cls", Combo_paymentdata_Cls);
         ucCombo_paymentdata.setProperty("EmptyItemText", Combo_paymentdata_Emptyitemtext);
         ucCombo_paymentdata.setProperty("DropDownOptionsData", AV14PaymentData_Data);
         ucCombo_paymentdata.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paymentdata_Internalname, sPrefix+"COMBO_PAYMENTDATAContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedpaymentdata2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_paymentdata2_Internalname, httpContext.getMessage( "Condicion de Entrega", ""), "", "", lblTextblockcombo_paymentdata2_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_paymentdata2.setProperty("Caption", Combo_paymentdata2_Caption);
         ucCombo_paymentdata2.setProperty("Cls", Combo_paymentdata2_Cls);
         ucCombo_paymentdata2.setProperty("EmptyItemText", Combo_paymentdata2_Emptyitemtext);
         ucCombo_paymentdata2.setProperty("DropDownOptionsData", AV18PaymentData2_Data);
         ucCombo_paymentdata2.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paymentdata2_Internalname, sPrefix+"COMBO_PAYMENTDATA2Container");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavPaymentdata3_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPaymentdata3_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavPaymentdata3_Internalname, httpContext.getMessage( "Datos para Pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPaymentdata3_Internalname, GXutil.rtrim( AV19PaymentData3), GXutil.rtrim( localUtil.format( AV19PaymentData3, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPaymentdata3_Jsonclick, 0, "Attribute", "", "", "", "", edtavPaymentdata3_Visible, edtavPaymentdata3_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault ButtonWizard" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardprevious_Internalname, "", httpContext.getMessage( "GXM_previous", ""), bttBtnwizardprevious_Jsonclick, 5, httpContext.getMessage( "GXM_previous", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'WIZARDPREVIOUS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial ButtonWizard" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardnext_Internalname, "", bttBtnwizardnext_Caption, bttBtnwizardnext_Jsonclick, 5, httpContext.getMessage( "GXM_next", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPaymentdata_Internalname, AV12PaymentData, GXutil.rtrim( localUtil.format( AV12PaymentData, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPaymentdata_Jsonclick, 0, "Attribute", "", "", "", "", edtavPaymentdata_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPaymentdata2_Internalname, GXutil.ltrim( localUtil.ntoc( AV17PaymentData2, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV17PaymentData2), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,50);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPaymentdata2_Jsonclick, 0, "Attribute", "", "", "", "", edtavPaymentdata2_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\CartCheckoutPayment.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start252( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Cart Checkout Payment", ""), (short)(0)) ;
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
            strup250( ) ;
         }
      }
   }

   public void ws252( )
   {
      start252( ) ;
      evt252( ) ;
   }

   public void evt252( )
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
                              strup250( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "COMBO_PAYMENTDATA.ONOPTIONCLICKED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup250( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11252 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup250( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12252 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup250( ) ;
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
                                       e13252 ();
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
                              strup250( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'WizardPrevious' */
                                 e14252 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup250( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e15252 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup250( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavPaymentdata3_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we252( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm252( ) ;
         }
      }
   }

   public void pa252( )
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
            GX_FocusControl = edtavPaymentdata3_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      rf252( ) ;
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
      edtavPaymentdata3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata3_Enabled), 5, 0), true);
   }

   public void rf252( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e15252 ();
         wb250( ) ;
      }
   }

   public void send_integrity_lvl_hashes252( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV10HasValidationErrors);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV10HasValidationErrors));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavPaymentdata3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata3_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup250( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12252 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vPAYMENTDATA_DATA"), AV14PaymentData_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"vPAYMENTDATA2_DATA"), AV18PaymentData2_Data);
         /* Read saved values. */
         wcpOAV6WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV6WebSessionKey") ;
         wcpOAV8PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV8PreviousStep") ;
         wcpOAV7GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV7GoingBack")) ;
         Combo_paymentdata_Cls = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA_Cls") ;
         Combo_paymentdata_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA_Selectedvalue_set") ;
         Combo_paymentdata_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA_Emptyitemtext") ;
         Combo_paymentdata2_Cls = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA2_Cls") ;
         Combo_paymentdata2_Selectedvalue_set = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA2_Selectedvalue_set") ;
         Combo_paymentdata2_Emptyitemtext = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA2_Emptyitemtext") ;
         Dvpanel_tableattributes_Width = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( sPrefix+"DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         Combo_paymentdata_Ddointernalname = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA_Ddointernalname") ;
         Combo_paymentdata2_Ddointernalname = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA2_Ddointernalname") ;
         Combo_paymentdata_Selectedtext_get = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA_Selectedtext_get") ;
         Combo_paymentdata2_Selectedtext_get = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA2_Selectedtext_get") ;
         Combo_paymentdata_Selectedvalue_get = httpContext.cgiGet( sPrefix+"COMBO_PAYMENTDATA_Selectedvalue_get") ;
         /* Read variables values. */
         AV19PaymentData3 = httpContext.cgiGet( edtavPaymentdata3_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19PaymentData3", AV19PaymentData3);
         AV12PaymentData = httpContext.cgiGet( edtavPaymentdata_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PaymentData", AV12PaymentData);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavPaymentdata2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavPaymentdata2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPAYMENTDATA2");
            GX_FocusControl = edtavPaymentdata2_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17PaymentData2 = (short)(0) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PaymentData2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PaymentData2), 4, 0));
         }
         else
         {
            AV17PaymentData2 = (short)(localUtil.ctol( httpContext.cgiGet( edtavPaymentdata2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PaymentData2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PaymentData2), 4, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e12252 ();
      if (returnInSub) return;
   }

   public void e12252( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      edtavPaymentdata2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata2_Visible), 5, 0), true);
      edtavPaymentdata_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPAYMENTDATA' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADCOMBOPAYMENTDATA2' */
      S132 ();
      if (returnInSub) return;
      if ( AV7GoingBack && ( GXutil.strcmp(AV8PreviousStep, "PlaceOrder") == 0 ) )
      {
         bttBtnwizardnext_Caption = httpContext.getMessage( "WWP_WizardReturnToSummary", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnwizardnext_Internalname, "Caption", bttBtnwizardnext_Caption, true);
      }
      edtavPaymentdata3_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata3_Visible), 5, 0), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13252 ();
      if (returnInSub) return;
   }

   public void e13252( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S142 ();
      if (returnInSub) return;
      if ( AV13CheckRequiredFieldsResult && ! AV10HasValidationErrors )
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S152 ();
         if (returnInSub) return;
         callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("Payment")),GXutil.URLEncode(GXutil.rtrim("PlaceOrder")),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e14252( )
   {
      /* 'WizardPrevious' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
      S152 ();
      if (returnInSub) return;
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("Payment")),GXutil.URLEncode(GXutil.rtrim("Address")),GXutil.URLEncode(GXutil.booltostr(true))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
   }

   public void e11252( )
   {
      /* Combo_paymentdata_Onoptionclicked Routine */
      returnInSub = false ;
      AV12PaymentData = Combo_paymentdata_Selectedvalue_get ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PaymentData", AV12PaymentData);
      /* Using cursor H00252 */
      pr_default.execute(0, new Object[] {AV12PaymentData});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A71TipoPagoNombre = H00252_A71TipoPagoNombre[0] ;
         A297TipoPagoDato = H00252_A297TipoPagoDato[0] ;
         A9TipoPagoId = H00252_A9TipoPagoId[0] ;
         AV19PaymentData3 = A297TipoPagoDato ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19PaymentData3", AV19PaymentData3);
         if ( GXutil.strcmp(AV19PaymentData3, "") != 0 )
         {
            edtavPaymentdata3_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata3_Visible), 5, 0), true);
         }
         else
         {
            edtavPaymentdata3_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPaymentdata3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPaymentdata3_Visible), 5, 0), true);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV12PaymentData = AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12PaymentData", AV12PaymentData);
      AV17PaymentData2 = AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata2() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PaymentData2", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PaymentData2), 4, 0));
      AV19PaymentData3 = AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().getgxTv_SdtCartCheckoutData_Payment_Paymentdata3() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19PaymentData3", AV19PaymentData3);
   }

   public void S152( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV11WizardData.fromJSonString(AV5WebSession.getValue(AV6WebSessionKey), null);
      AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata_description( Combo_paymentdata_Selectedtext_get );
      AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata( AV12PaymentData );
      AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description( Combo_paymentdata2_Selectedtext_get );
      AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata2( AV17PaymentData2 );
      AV11WizardData.getgxTv_SdtCartCheckoutData_Payment().setgxTv_SdtCartCheckoutData_Payment_Paymentdata3( AV19PaymentData3 );
      AV5WebSession.setValue(AV6WebSessionKey, AV11WizardData.toJSonString(false, true));
   }

   public void S142( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV13CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13CheckRequiredFieldsResult", AV13CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV12PaymentData)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Forma de Pago", ""), "", "", "", "", "", "", "", ""), "error", Combo_paymentdata_Ddointernalname, "true", ""));
         AV13CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13CheckRequiredFieldsResult", AV13CheckRequiredFieldsResult);
      }
      if ( (0==AV17PaymentData2) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Condicion de Entrega", ""), "", "", "", "", "", "", "", ""), "error", Combo_paymentdata2_Ddointernalname, "true", ""));
         AV13CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13CheckRequiredFieldsResult", AV13CheckRequiredFieldsResult);
      }
   }

   public void S132( )
   {
      /* 'LOADCOMBOPAYMENTDATA2' Routine */
      returnInSub = false ;
      /* Using cursor H00253 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         A283OpcionEnvioId = H00253_A283OpcionEnvioId[0] ;
         A284OpcionEnvioDescripcion = H00253_A284OpcionEnvioDescripcion[0] ;
         AV16Combo_DataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV16Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A283OpcionEnvioId, 11, 0)) );
         AV16Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A284OpcionEnvioDescripcion );
         AV18PaymentData2_Data.add(AV16Combo_DataItem, 0);
         pr_default.readNext(1);
      }
      pr_default.close(1);
      Combo_paymentdata2_Selectedvalue_set = ((0==AV17PaymentData2) ? "" : GXutil.trim( GXutil.str( AV17PaymentData2, 4, 0))) ;
      ucCombo_paymentdata2.sendProperty(context, sPrefix, false, Combo_paymentdata2_Internalname, "SelectedValue_set", Combo_paymentdata2_Selectedvalue_set);
   }

   public void S122( )
   {
      /* 'LOADCOMBOPAYMENTDATA' Routine */
      returnInSub = false ;
      /* Using cursor H00254 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A71TipoPagoNombre = H00254_A71TipoPagoNombre[0] ;
         AV16Combo_DataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV16Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A71TipoPagoNombre );
         AV16Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A71TipoPagoNombre );
         AV14PaymentData_Data.add(AV16Combo_DataItem, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      Combo_paymentdata_Selectedvalue_set = AV12PaymentData ;
      ucCombo_paymentdata.sendProperty(context, sPrefix, false, Combo_paymentdata_Internalname, "SelectedValue_set", Combo_paymentdata_Selectedvalue_set);
   }

   protected void nextLoad( )
   {
   }

   protected void e15252( )
   {
      /* Load Routine */
      returnInSub = false ;
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
      pa252( ) ;
      ws252( ) ;
      we252( ) ;
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
      pa252( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\cartcheckoutpayment", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa252( ) ;
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
      pa252( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws252( ) ;
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
      ws252( ) ;
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
      we252( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211164535", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/cartcheckoutpayment.js", "?20241211164536", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockcombo_paymentdata_Internalname = sPrefix+"TEXTBLOCKCOMBO_PAYMENTDATA" ;
      Combo_paymentdata_Internalname = sPrefix+"COMBO_PAYMENTDATA" ;
      divTablesplittedpaymentdata_Internalname = sPrefix+"TABLESPLITTEDPAYMENTDATA" ;
      lblTextblockcombo_paymentdata2_Internalname = sPrefix+"TEXTBLOCKCOMBO_PAYMENTDATA2" ;
      Combo_paymentdata2_Internalname = sPrefix+"COMBO_PAYMENTDATA2" ;
      divTablesplittedpaymentdata2_Internalname = sPrefix+"TABLESPLITTEDPAYMENTDATA2" ;
      edtavPaymentdata3_Internalname = sPrefix+"vPAYMENTDATA3" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnwizardprevious_Internalname = sPrefix+"BTNWIZARDPREVIOUS" ;
      bttBtnwizardnext_Internalname = sPrefix+"BTNWIZARDNEXT" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      edtavPaymentdata_Internalname = sPrefix+"vPAYMENTDATA" ;
      edtavPaymentdata2_Internalname = sPrefix+"vPAYMENTDATA2" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
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
      edtavPaymentdata2_Jsonclick = "" ;
      edtavPaymentdata2_Visible = 1 ;
      edtavPaymentdata_Jsonclick = "" ;
      edtavPaymentdata_Visible = 1 ;
      bttBtnwizardnext_Caption = httpContext.getMessage( "GXM_next", "") ;
      edtavPaymentdata3_Jsonclick = "" ;
      edtavPaymentdata3_Enabled = 1 ;
      edtavPaymentdata3_Visible = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelLine_Gray" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Combo_paymentdata2_Emptyitemtext = "::SeleccionarOpcionEnvio::" ;
      Combo_paymentdata2_Cls = "ExtendedCombo AttributeRealWidth" ;
      Combo_paymentdata_Emptyitemtext = "::SeleccionarTipoPago::" ;
      Combo_paymentdata_Cls = "ExtendedCombo AttributeRealWidth" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e13252',iparms:[{av:'AV13CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV10HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV12PaymentData',fld:'vPAYMENTDATA',pic:''},{av:'Combo_paymentdata_Ddointernalname',ctrl:'COMBO_PAYMENTDATA',prop:'DDOInternalName'},{av:'AV17PaymentData2',fld:'vPAYMENTDATA2',pic:'ZZZ9'},{av:'Combo_paymentdata2_Ddointernalname',ctrl:'COMBO_PAYMENTDATA2',prop:'DDOInternalName'},{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'Combo_paymentdata_Selectedtext_get',ctrl:'COMBO_PAYMENTDATA',prop:'SelectedText_get'},{av:'Combo_paymentdata2_Selectedtext_get',ctrl:'COMBO_PAYMENTDATA2',prop:'SelectedText_get'},{av:'AV19PaymentData3',fld:'vPAYMENTDATA3',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV13CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e14252',iparms:[{av:'AV6WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'Combo_paymentdata_Selectedtext_get',ctrl:'COMBO_PAYMENTDATA',prop:'SelectedText_get'},{av:'AV12PaymentData',fld:'vPAYMENTDATA',pic:''},{av:'Combo_paymentdata2_Selectedtext_get',ctrl:'COMBO_PAYMENTDATA2',prop:'SelectedText_get'},{av:'AV17PaymentData2',fld:'vPAYMENTDATA2',pic:'ZZZ9'},{av:'AV19PaymentData3',fld:'vPAYMENTDATA3',pic:''}]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[]}");
      setEventMetadata("COMBO_PAYMENTDATA.ONOPTIONCLICKED","{handler:'e11252',iparms:[{av:'Combo_paymentdata_Selectedvalue_get',ctrl:'COMBO_PAYMENTDATA',prop:'SelectedValue_get'},{av:'A9TipoPagoId',fld:'TIPOPAGOID',pic:'ZZZZZZZZZZ9'},{av:'A71TipoPagoNombre',fld:'TIPOPAGONOMBRE',pic:''},{av:'A297TipoPagoDato',fld:'TIPOPAGODATO',pic:''}]");
      setEventMetadata("COMBO_PAYMENTDATA.ONOPTIONCLICKED",",oparms:[{av:'AV12PaymentData',fld:'vPAYMENTDATA',pic:''},{av:'AV19PaymentData3',fld:'vPAYMENTDATA3',pic:''},{av:'edtavPaymentdata3_Visible',ctrl:'vPAYMENTDATA3',prop:'Visible'}]}");
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
      Combo_paymentdata_Ddointernalname = "" ;
      Combo_paymentdata2_Ddointernalname = "" ;
      Combo_paymentdata_Selectedtext_get = "" ;
      Combo_paymentdata2_Selectedtext_get = "" ;
      Combo_paymentdata2_Selectedvalue_get = "" ;
      Combo_paymentdata_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV6WebSessionKey = "" ;
      AV8PreviousStep = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV14PaymentData_Data = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV18PaymentData2_Data = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A71TipoPagoNombre = "" ;
      A297TipoPagoDato = "" ;
      Combo_paymentdata_Selectedvalue_set = "" ;
      Combo_paymentdata2_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_paymentdata_Jsonclick = "" ;
      ucCombo_paymentdata = new com.genexus.webpanels.GXUserControl();
      Combo_paymentdata_Caption = "" ;
      lblTextblockcombo_paymentdata2_Jsonclick = "" ;
      ucCombo_paymentdata2 = new com.genexus.webpanels.GXUserControl();
      Combo_paymentdata2_Caption = "" ;
      TempTags = "" ;
      AV19PaymentData3 = "" ;
      bttBtnwizardprevious_Jsonclick = "" ;
      bttBtnwizardnext_Jsonclick = "" ;
      AV12PaymentData = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H00252_A71TipoPagoNombre = new String[] {""} ;
      H00252_A297TipoPagoDato = new String[] {""} ;
      H00252_A9TipoPagoId = new long[1] ;
      AV11WizardData = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData(remoteHandle, context);
      AV5WebSession = httpContext.getWebSession();
      H00253_A283OpcionEnvioId = new long[1] ;
      H00253_A284OpcionEnvioDescripcion = new String[] {""} ;
      A284OpcionEnvioDescripcion = "" ;
      AV16Combo_DataItem = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      H00254_A9TipoPagoId = new long[1] ;
      H00254_A71TipoPagoNombre = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV6WebSessionKey = "" ;
      sCtrlAV8PreviousStep = "" ;
      sCtrlAV7GoingBack = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.cartcheckoutpayment__default(),
         new Object[] {
             new Object[] {
            H00252_A71TipoPagoNombre, H00252_A297TipoPagoDato, H00252_A9TipoPagoId
            }
            , new Object[] {
            H00253_A283OpcionEnvioId, H00253_A284OpcionEnvioDescripcion
            }
            , new Object[] {
            H00254_A9TipoPagoId, H00254_A71TipoPagoNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavPaymentdata3_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short AV17PaymentData2 ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavPaymentdata3_Visible ;
   private int edtavPaymentdata3_Enabled ;
   private int edtavPaymentdata_Visible ;
   private int edtavPaymentdata2_Visible ;
   private int idxLst ;
   private long A9TipoPagoId ;
   private long A283OpcionEnvioId ;
   private String Combo_paymentdata_Ddointernalname ;
   private String Combo_paymentdata2_Ddointernalname ;
   private String Combo_paymentdata_Selectedtext_get ;
   private String Combo_paymentdata2_Selectedtext_get ;
   private String Combo_paymentdata2_Selectedvalue_get ;
   private String Combo_paymentdata_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A71TipoPagoNombre ;
   private String A297TipoPagoDato ;
   private String Combo_paymentdata_Cls ;
   private String Combo_paymentdata_Selectedvalue_set ;
   private String Combo_paymentdata_Emptyitemtext ;
   private String Combo_paymentdata2_Cls ;
   private String Combo_paymentdata2_Selectedvalue_set ;
   private String Combo_paymentdata2_Emptyitemtext ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String divTablesplittedpaymentdata_Internalname ;
   private String lblTextblockcombo_paymentdata_Internalname ;
   private String lblTextblockcombo_paymentdata_Jsonclick ;
   private String Combo_paymentdata_Caption ;
   private String Combo_paymentdata_Internalname ;
   private String divTablesplittedpaymentdata2_Internalname ;
   private String lblTextblockcombo_paymentdata2_Internalname ;
   private String lblTextblockcombo_paymentdata2_Jsonclick ;
   private String Combo_paymentdata2_Caption ;
   private String Combo_paymentdata2_Internalname ;
   private String edtavPaymentdata3_Internalname ;
   private String TempTags ;
   private String AV19PaymentData3 ;
   private String edtavPaymentdata3_Jsonclick ;
   private String bttBtnwizardprevious_Internalname ;
   private String bttBtnwizardprevious_Jsonclick ;
   private String bttBtnwizardnext_Internalname ;
   private String bttBtnwizardnext_Caption ;
   private String bttBtnwizardnext_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavPaymentdata_Internalname ;
   private String edtavPaymentdata_Jsonclick ;
   private String edtavPaymentdata2_Internalname ;
   private String edtavPaymentdata2_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String sCtrlAV6WebSessionKey ;
   private String sCtrlAV8PreviousStep ;
   private String sCtrlAV7GoingBack ;
   private boolean wcpOAV7GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV7GoingBack ;
   private boolean AV10HasValidationErrors ;
   private boolean AV13CheckRequiredFieldsResult ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String wcpOAV6WebSessionKey ;
   private String wcpOAV8PreviousStep ;
   private String AV6WebSessionKey ;
   private String AV8PreviousStep ;
   private String AV12PaymentData ;
   private String A284OpcionEnvioDescripcion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV5WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paymentdata ;
   private com.genexus.webpanels.GXUserControl ucCombo_paymentdata2 ;
   private IDataStoreProvider pr_default ;
   private String[] H00252_A71TipoPagoNombre ;
   private String[] H00252_A297TipoPagoDato ;
   private long[] H00252_A9TipoPagoId ;
   private long[] H00253_A283OpcionEnvioId ;
   private String[] H00253_A284OpcionEnvioDescripcion ;
   private long[] H00254_A9TipoPagoId ;
   private String[] H00254_A71TipoPagoNombre ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14PaymentData_Data ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV18PaymentData2_Data ;
   private com.mujermorena.wwpbaseobjects.SdtCartCheckoutData AV11WizardData ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item AV16Combo_DataItem ;
}

final  class cartcheckoutpayment__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00252", "SELECT [TipoPagoNombre], [TipoPagoDato], [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoNombre] = ? ORDER BY [TipoPagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00253", "SELECT [OpcionEnvioId], [OpcionEnvioDescripcion] FROM [OpcionEnvio] ORDER BY [OpcionEnvioDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00254", "SELECT [TipoPagoId], [TipoPagoNombre] FROM [TipoPago] ORDER BY [TipoPagoNombre] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
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
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
      }
   }

}

