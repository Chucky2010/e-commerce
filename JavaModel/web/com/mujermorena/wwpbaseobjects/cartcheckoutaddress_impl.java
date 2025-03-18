package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cartcheckoutaddress_impl extends GXWebComponent
{
   public cartcheckoutaddress_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cartcheckoutaddress_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cartcheckoutaddress_impl.class ));
   }

   public cartcheckoutaddress_impl( int remoteHandle ,
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
               AV16WebSessionKey = httpContext.GetPar( "WebSessionKey") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WebSessionKey", AV16WebSessionKey);
               AV14PreviousStep = httpContext.GetPar( "PreviousStep") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14PreviousStep", AV14PreviousStep);
               AV10GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,AV16WebSessionKey,AV14PreviousStep,Boolean.valueOf(AV10GoingBack)});
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
         pa242( ) ;
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
         httpContext.writeValue( httpContext.getMessage( "Cart Checkout Address", "")) ;
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.cartcheckoutaddress", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16WebSessionKey)),GXutil.URLEncode(GXutil.rtrim(AV14PreviousStep)),GXutil.URLEncode(GXutil.booltostr(AV10GoingBack))}, new String[] {"WebSessionKey","PreviousStep","GoingBack"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV11HasValidationErrors));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV16WebSessionKey", wcpOAV16WebSessionKey);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV14PreviousStep", wcpOAV14PreviousStep);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"wcpOAV10GoingBack", wcpOAV10GoingBack);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vCHECKREQUIREDFIELDSRESULT", AV6CheckRequiredFieldsResult);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV11HasValidationErrors);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV11HasValidationErrors));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vGOINGBACK", AV10GoingBack);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPREVIOUSSTEP", AV14PreviousStep);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vWEBSESSIONKEY", AV16WebSessionKey);
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
   }

   public void renderHtmlCloseForm242( )
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
      return "WWPBaseObjects.CartCheckoutAddress" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cart Checkout Address", "") ;
   }

   public void wb240( )
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
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.cartcheckoutaddress");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "Nombre", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, AV12Name, GXutil.rtrim( localUtil.format( AV12Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPhone_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavPhone_Internalname, httpContext.getMessage( "Telefono", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPhone_Internalname, AV13Phone, GXutil.rtrim( localUtil.format( AV13Phone, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPhone_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavPhone_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCountry_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCountry_Internalname, httpContext.getMessage( "Pais", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCountry_Internalname, AV7Country, GXutil.rtrim( localUtil.format( AV7Country, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCountry_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCountry_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDepartment_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDepartment_Internalname, httpContext.getMessage( "Departamento", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'" + sPrefix + "',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDepartment_Internalname, AV9Department, GXutil.rtrim( localUtil.format( AV9Department, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDepartment_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDepartment_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAddress_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAddress_Internalname, httpContext.getMessage( "Direccion", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavAddress_Internalname, AV5Address, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", (short)(0), 1, edtavAddress_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault ButtonWizard" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardfirstprevious_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtnwizardfirstprevious_Jsonclick, 7, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11241_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial ButtonWizard" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardnext_Internalname, "", bttBtnwizardnext_Caption, bttBtnwizardnext_Jsonclick, 5, httpContext.getMessage( "GXM_next", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\CartCheckoutAddress.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start242( )
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
            Form.getMeta().addItem("description", httpContext.getMessage( "Cart Checkout Address", ""), (short)(0)) ;
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
            strup240( ) ;
         }
      }
   }

   public void ws242( )
   {
      start242( ) ;
      evt242( ) ;
   }

   public void evt242( )
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
                              strup240( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup240( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12242 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup240( ) ;
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
                                       e13242 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup240( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14242 ();
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup240( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavName_Internalname ;
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

   public void we242( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm242( ) ;
         }
      }
   }

   public void pa242( )
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
            GX_FocusControl = edtavName_Internalname ;
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
      rf242( ) ;
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
   }

   public void rf242( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e14242 ();
         wb240( ) ;
      }
   }

   public void send_integrity_lvl_hashes242( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vHASVALIDATIONERRORS", AV11HasValidationErrors);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vHASVALIDATIONERRORS", getSecureSignedToken( sPrefix, AV11HasValidationErrors));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup240( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12242 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV16WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV16WebSessionKey") ;
         wcpOAV14PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV14PreviousStep") ;
         wcpOAV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV10GoingBack")) ;
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
         /* Read variables values. */
         AV12Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Name", AV12Name);
         AV13Phone = httpContext.cgiGet( edtavPhone_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Phone", AV13Phone);
         AV7Country = httpContext.cgiGet( edtavCountry_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Country", AV7Country);
         AV9Department = httpContext.cgiGet( edtavDepartment_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9Department", AV9Department);
         AV5Address = httpContext.cgiGet( edtavAddress_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Address", AV5Address);
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
      e12242 ();
      if (returnInSub) return;
   }

   public void e12242( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'LOADVARIABLESFROMWIZARDDATA' */
      S112 ();
      if (returnInSub) return;
      if ( AV10GoingBack && ( GXutil.strcmp(AV14PreviousStep, "PlaceOrder") == 0 ) )
      {
         bttBtnwizardnext_Caption = httpContext.getMessage( "WWP_WizardReturnToSummary", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnwizardnext_Internalname, "Caption", bttBtnwizardnext_Caption, true);
      }
      AV18GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV19UserName = AV18GAMUser.getgxTv_SdtGAMUser_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19UserName", AV19UserName);
      /* Using cursor H00242 */
      pr_default.execute(0, new Object[] {AV19UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1PersonaId = H00242_A1PersonaId[0] ;
         A3LocalidadId = H00242_A3LocalidadId[0] ;
         A7CiudadId = H00242_A7CiudadId[0] ;
         A6DepartamentoId = H00242_A6DepartamentoId[0] ;
         A244ClienteUser = H00242_A244ClienteUser[0] ;
         A66PersonaTelefono = H00242_A66PersonaTelefono[0] ;
         A62CiudadNombre = H00242_A62CiudadNombre[0] ;
         A61DepartamentoNombre = H00242_A61DepartamentoNombre[0] ;
         A57PersonaDireccion = H00242_A57PersonaDireccion[0] ;
         A4ClienteId = H00242_A4ClienteId[0] ;
         A56PersonaApellido = H00242_A56PersonaApellido[0] ;
         A55PersonaNombre = H00242_A55PersonaNombre[0] ;
         A3LocalidadId = H00242_A3LocalidadId[0] ;
         A66PersonaTelefono = H00242_A66PersonaTelefono[0] ;
         A57PersonaDireccion = H00242_A57PersonaDireccion[0] ;
         A56PersonaApellido = H00242_A56PersonaApellido[0] ;
         A55PersonaNombre = H00242_A55PersonaNombre[0] ;
         A7CiudadId = H00242_A7CiudadId[0] ;
         A6DepartamentoId = H00242_A6DepartamentoId[0] ;
         A62CiudadNombre = H00242_A62CiudadNombre[0] ;
         A61DepartamentoNombre = H00242_A61DepartamentoNombre[0] ;
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A59PersonaNombreCompleto", A59PersonaNombreCompleto);
         AV12Name = A59PersonaNombreCompleto ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Name", AV12Name);
         AV13Phone = A66PersonaTelefono ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Phone", AV13Phone);
         AV7Country = A62CiudadNombre ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Country", AV7Country);
         AV9Department = A61DepartamentoNombre ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9Department", AV9Department);
         AV5Address = A57PersonaDireccion ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Address", AV5Address);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13242 ();
      if (returnInSub) return;
   }

   public void e13242( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S122 ();
      if (returnInSub) return;
      if ( AV6CheckRequiredFieldsResult && ! AV11HasValidationErrors )
      {
         /* Execute user subroutine: 'SAVEVARIABLESTOWIZARDDATA' */
         S132 ();
         if (returnInSub) return;
         if ( AV10GoingBack && ( GXutil.strcmp(AV14PreviousStep, "PlaceOrder") == 0 ) )
         {
            callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("Address")),GXutil.URLEncode(GXutil.rtrim(AV14PreviousStep)),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            callWebObject(formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim("Address")),GXutil.URLEncode(GXutil.rtrim("Payment")),GXutil.URLEncode(GXutil.booltostr(false))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'LOADVARIABLESFROMWIZARDDATA' Routine */
      returnInSub = false ;
      AV17WizardData.fromJSonString(AV15WebSession.getValue(AV16WebSessionKey), null);
      AV12Name = AV17WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Name() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Name", AV12Name);
      AV13Phone = AV17WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Phone() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Phone", AV13Phone);
      AV7Country = AV17WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Country() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Country", AV7Country);
      AV9Department = AV17WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Department() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9Department", AV9Department);
      AV5Address = AV17WizardData.getgxTv_SdtCartCheckoutData_Address().getgxTv_SdtCartCheckoutData_Address_Address() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Address", AV5Address);
   }

   public void S132( )
   {
      /* 'SAVEVARIABLESTOWIZARDDATA' Routine */
      returnInSub = false ;
      AV17WizardData.fromJSonString(AV15WebSession.getValue(AV16WebSessionKey), null);
      AV17WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Name( AV12Name );
      AV17WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Phone( AV13Phone );
      AV17WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Country( AV7Country );
      AV17WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Department( AV9Department );
      AV17WizardData.getgxTv_SdtCartCheckoutData_Address().setgxTv_SdtCartCheckoutData_Address_Address( AV5Address );
      AV15WebSession.setValue(AV16WebSessionKey, AV17WizardData.toJSonString(false, true));
   }

   public void S122( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV6CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CheckRequiredFieldsResult", AV6CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV12Name)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombre", ""), "", "", "", "", "", "", "", ""), "error", edtavName_Internalname, "true", ""));
         AV6CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CheckRequiredFieldsResult", AV6CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV7Country)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "error", edtavCountry_Internalname, "true", ""));
         AV6CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CheckRequiredFieldsResult", AV6CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV9Department)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Departamento", ""), "", "", "", "", "", "", "", ""), "error", edtavDepartment_Internalname, "true", ""));
         AV6CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CheckRequiredFieldsResult", AV6CheckRequiredFieldsResult);
      }
      if ( (GXutil.strcmp("", AV5Address)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Direccion", ""), "", "", "", "", "", "", "", ""), "error", edtavAddress_Internalname, "true", ""));
         AV6CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CheckRequiredFieldsResult", AV6CheckRequiredFieldsResult);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e14242( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV16WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WebSessionKey", AV16WebSessionKey);
      AV14PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14PreviousStep", AV14PreviousStep);
      AV10GoingBack = ((Boolean) getParm(obj,2,TypeConstants.BOOLEAN)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
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
      pa242( ) ;
      ws242( ) ;
      we242( ) ;
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
      sCtrlAV16WebSessionKey = (String)getParm(obj,0,TypeConstants.STRING) ;
      sCtrlAV14PreviousStep = (String)getParm(obj,1,TypeConstants.STRING) ;
      sCtrlAV10GoingBack = (String)getParm(obj,2,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa242( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\cartcheckoutaddress", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa242( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV16WebSessionKey = (String)getParm(obj,2,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WebSessionKey", AV16WebSessionKey);
         AV14PreviousStep = (String)getParm(obj,3,TypeConstants.STRING) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14PreviousStep", AV14PreviousStep);
         AV10GoingBack = ((Boolean) getParm(obj,4,TypeConstants.BOOLEAN)).booleanValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
      }
      wcpOAV16WebSessionKey = httpContext.cgiGet( sPrefix+"wcpOAV16WebSessionKey") ;
      wcpOAV14PreviousStep = httpContext.cgiGet( sPrefix+"wcpOAV14PreviousStep") ;
      wcpOAV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"wcpOAV10GoingBack")) ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(AV16WebSessionKey, wcpOAV16WebSessionKey) != 0 ) || ( GXutil.strcmp(AV14PreviousStep, wcpOAV14PreviousStep) != 0 ) || ( AV10GoingBack != wcpOAV10GoingBack ) ) )
      {
         setjustcreated();
      }
      wcpOAV16WebSessionKey = AV16WebSessionKey ;
      wcpOAV14PreviousStep = AV14PreviousStep ;
      wcpOAV10GoingBack = AV10GoingBack ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV16WebSessionKey = httpContext.cgiGet( sPrefix+"AV16WebSessionKey_CTRL") ;
      if ( GXutil.len( sCtrlAV16WebSessionKey) > 0 )
      {
         AV16WebSessionKey = httpContext.cgiGet( sCtrlAV16WebSessionKey) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16WebSessionKey", AV16WebSessionKey);
      }
      else
      {
         AV16WebSessionKey = httpContext.cgiGet( sPrefix+"AV16WebSessionKey_PARM") ;
      }
      sCtrlAV14PreviousStep = httpContext.cgiGet( sPrefix+"AV14PreviousStep_CTRL") ;
      if ( GXutil.len( sCtrlAV14PreviousStep) > 0 )
      {
         AV14PreviousStep = httpContext.cgiGet( sCtrlAV14PreviousStep) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14PreviousStep", AV14PreviousStep);
      }
      else
      {
         AV14PreviousStep = httpContext.cgiGet( sPrefix+"AV14PreviousStep_PARM") ;
      }
      sCtrlAV10GoingBack = httpContext.cgiGet( sPrefix+"AV10GoingBack_CTRL") ;
      if ( GXutil.len( sCtrlAV10GoingBack) > 0 )
      {
         AV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sCtrlAV10GoingBack)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10GoingBack", AV10GoingBack);
      }
      else
      {
         AV10GoingBack = GXutil.strtobool( httpContext.cgiGet( sPrefix+"AV10GoingBack_PARM")) ;
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
      pa242( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws242( ) ;
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
      ws242( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16WebSessionKey_PARM", AV16WebSessionKey);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV16WebSessionKey)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV16WebSessionKey_CTRL", GXutil.rtrim( sCtrlAV16WebSessionKey));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14PreviousStep_PARM", AV14PreviousStep);
      if ( GXutil.len( GXutil.rtrim( sCtrlAV14PreviousStep)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV14PreviousStep_CTRL", GXutil.rtrim( sCtrlAV14PreviousStep));
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10GoingBack_PARM", GXutil.booltostr( AV10GoingBack));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV10GoingBack)) > 0 )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV10GoingBack_CTRL", GXutil.rtrim( sCtrlAV10GoingBack));
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
      we242( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211165187", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/cartcheckoutaddress.js", "?20241211165191", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavName_Internalname = sPrefix+"vNAME" ;
      edtavPhone_Internalname = sPrefix+"vPHONE" ;
      edtavCountry_Internalname = sPrefix+"vCOUNTRY" ;
      edtavDepartment_Internalname = sPrefix+"vDEPARTMENT" ;
      edtavAddress_Internalname = sPrefix+"vADDRESS" ;
      divTableattributes_Internalname = sPrefix+"TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = sPrefix+"DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      bttBtnwizardfirstprevious_Internalname = sPrefix+"BTNWIZARDFIRSTPREVIOUS" ;
      bttBtnwizardnext_Internalname = sPrefix+"BTNWIZARDNEXT" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
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
      bttBtnwizardnext_Caption = httpContext.getMessage( "GXM_next", "") ;
      edtavAddress_Enabled = 1 ;
      edtavDepartment_Jsonclick = "" ;
      edtavDepartment_Enabled = 1 ;
      edtavCountry_Jsonclick = "" ;
      edtavCountry_Enabled = 1 ;
      edtavPhone_Jsonclick = "" ;
      edtavPhone_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Datos del Domicilio", "") ;
      Dvpanel_tableattributes_Cls = "PanelLine_Gray" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e13242',iparms:[{av:'AV6CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV11HasValidationErrors',fld:'vHASVALIDATIONERRORS',pic:'',hsh:true},{av:'AV10GoingBack',fld:'vGOINGBACK',pic:''},{av:'AV14PreviousStep',fld:'vPREVIOUSSTEP',pic:''},{av:'AV12Name',fld:'vNAME',pic:''},{av:'AV7Country',fld:'vCOUNTRY',pic:''},{av:'AV9Department',fld:'vDEPARTMENT',pic:''},{av:'AV5Address',fld:'vADDRESS',pic:''},{av:'AV16WebSessionKey',fld:'vWEBSESSIONKEY',pic:''},{av:'AV13Phone',fld:'vPHONE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV6CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e11241',iparms:[]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[]}");
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
      wcpOAV16WebSessionKey = "" ;
      wcpOAV14PreviousStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      AV16WebSessionKey = "" ;
      AV14PreviousStep = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV12Name = "" ;
      AV13Phone = "" ;
      AV7Country = "" ;
      AV9Department = "" ;
      AV5Address = "" ;
      bttBtnwizardfirstprevious_Jsonclick = "" ;
      bttBtnwizardnext_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV18GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV19UserName = "" ;
      scmdbuf = "" ;
      H00242_A1PersonaId = new long[1] ;
      H00242_A3LocalidadId = new long[1] ;
      H00242_A7CiudadId = new long[1] ;
      H00242_A6DepartamentoId = new long[1] ;
      H00242_A244ClienteUser = new String[] {""} ;
      H00242_A66PersonaTelefono = new String[] {""} ;
      H00242_A62CiudadNombre = new String[] {""} ;
      H00242_A61DepartamentoNombre = new String[] {""} ;
      H00242_A57PersonaDireccion = new String[] {""} ;
      H00242_A4ClienteId = new long[1] ;
      H00242_A56PersonaApellido = new String[] {""} ;
      H00242_A55PersonaNombre = new String[] {""} ;
      A244ClienteUser = "" ;
      A66PersonaTelefono = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A57PersonaDireccion = "" ;
      A56PersonaApellido = "" ;
      A55PersonaNombre = "" ;
      A59PersonaNombreCompleto = "" ;
      AV17WizardData = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV16WebSessionKey = "" ;
      sCtrlAV14PreviousStep = "" ;
      sCtrlAV10GoingBack = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.cartcheckoutaddress__default(),
         new Object[] {
             new Object[] {
            H00242_A1PersonaId, H00242_A3LocalidadId, H00242_A7CiudadId, H00242_A6DepartamentoId, H00242_A244ClienteUser, H00242_A66PersonaTelefono, H00242_A62CiudadNombre, H00242_A61DepartamentoNombre, H00242_A57PersonaDireccion, H00242_A4ClienteId,
            H00242_A56PersonaApellido, H00242_A55PersonaNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavName_Enabled ;
   private int edtavPhone_Enabled ;
   private int edtavCountry_Enabled ;
   private int edtavDepartment_Enabled ;
   private int edtavAddress_Enabled ;
   private int idxLst ;
   private long A1PersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private long A4ClienteId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
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
   private String edtavName_Internalname ;
   private String TempTags ;
   private String edtavName_Jsonclick ;
   private String edtavPhone_Internalname ;
   private String edtavPhone_Jsonclick ;
   private String edtavCountry_Internalname ;
   private String edtavCountry_Jsonclick ;
   private String edtavDepartment_Internalname ;
   private String edtavDepartment_Jsonclick ;
   private String edtavAddress_Internalname ;
   private String bttBtnwizardfirstprevious_Internalname ;
   private String bttBtnwizardfirstprevious_Jsonclick ;
   private String bttBtnwizardnext_Internalname ;
   private String bttBtnwizardnext_Caption ;
   private String bttBtnwizardnext_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV19UserName ;
   private String scmdbuf ;
   private String A244ClienteUser ;
   private String A66PersonaTelefono ;
   private String A62CiudadNombre ;
   private String A61DepartamentoNombre ;
   private String A56PersonaApellido ;
   private String A55PersonaNombre ;
   private String A59PersonaNombreCompleto ;
   private String sCtrlAV16WebSessionKey ;
   private String sCtrlAV14PreviousStep ;
   private String sCtrlAV10GoingBack ;
   private boolean wcpOAV10GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV10GoingBack ;
   private boolean AV11HasValidationErrors ;
   private boolean AV6CheckRequiredFieldsResult ;
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
   private String wcpOAV16WebSessionKey ;
   private String wcpOAV14PreviousStep ;
   private String AV16WebSessionKey ;
   private String AV14PreviousStep ;
   private String AV12Name ;
   private String AV13Phone ;
   private String AV7Country ;
   private String AV9Department ;
   private String AV5Address ;
   private String A57PersonaDireccion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private IDataStoreProvider pr_default ;
   private long[] H00242_A1PersonaId ;
   private long[] H00242_A3LocalidadId ;
   private long[] H00242_A7CiudadId ;
   private long[] H00242_A6DepartamentoId ;
   private String[] H00242_A244ClienteUser ;
   private String[] H00242_A66PersonaTelefono ;
   private String[] H00242_A62CiudadNombre ;
   private String[] H00242_A61DepartamentoNombre ;
   private String[] H00242_A57PersonaDireccion ;
   private long[] H00242_A4ClienteId ;
   private String[] H00242_A56PersonaApellido ;
   private String[] H00242_A55PersonaNombre ;
   private com.mujermorena.wwpbaseobjects.SdtCartCheckoutData AV17WizardData ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV18GAMUser ;
}

final  class cartcheckoutaddress__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00242", "SELECT T1.[PersonaId], T2.[LocalidadId], T3.[CiudadId], T4.[DepartamentoId], T1.[ClienteUser], T2.[PersonaTelefono], T4.[CiudadNombre], T5.[DepartamentoNombre], T2.[PersonaDireccion], T1.[ClienteId], T2.[PersonaApellido], T2.[PersonaNombre] FROM (((([Cliente] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = T1.[PersonaId]) INNER JOIN [Localidad] T3 ON T3.[LocalidadId] = T2.[LocalidadId]) INNER JOIN [Ciudad] T4 ON T4.[CiudadId] = T3.[CiudadId]) INNER JOIN [Departamento] T5 ON T5.[DepartamentoId] = T4.[DepartamentoId]) WHERE T1.[ClienteUser] = ? ORDER BY T1.[ClienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 25);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((String[]) buf[7])[0] = rslt.getString(8, 80);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 80);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

