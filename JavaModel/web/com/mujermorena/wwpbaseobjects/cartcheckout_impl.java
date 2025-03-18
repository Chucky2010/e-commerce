package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cartcheckout_impl extends GXDataArea
{
   public cartcheckout_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cartcheckout_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cartcheckout_impl.class ));
   }

   public cartcheckout_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "PreviousStep") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "PreviousStep") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "PreviousStep") ;
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
            AV10PreviousStep = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10PreviousStep", AV10PreviousStep);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV11CurrentStep = httpContext.GetPar( "CurrentStep") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11CurrentStep", AV11CurrentStep);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
               AV9GoingBack = GXutil.strtobool( httpContext.GetPar( "GoingBack")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV9GoingBack", AV9GoingBack);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
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
      pa0E2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start0E2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10PreviousStep)),GXutil.URLEncode(GXutil.rtrim(AV11CurrentStep)),GXutil.URLEncode(GXutil.booltostr(AV9GoingBack))}, new String[] {"PreviousStep","CurrentStep","GoingBack"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPREVIOUSSTEP", AV10PreviousStep);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCURRENTSTEP", AV11CurrentStep);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vGOINGBACK", AV9GoingBack);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
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
      if ( ! ( WebComp_Steptitles == null ) )
      {
         WebComp_Steptitles.componentjscripts();
      }
      if ( ! ( WebComp_Wizardstepwc == null ) )
      {
         WebComp_Wizardstepwc.componentjscripts();
      }
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
         we0E2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt0E2( ) ;
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
      return formatLink("com.mujermorena.wwpbaseobjects.cartcheckout", new String[] {GXutil.URLEncode(GXutil.rtrim(AV10PreviousStep)),GXutil.URLEncode(GXutil.rtrim(AV11CurrentStep)),GXutil.URLEncode(GXutil.booltostr(AV9GoingBack))}, new String[] {"PreviousStep","CurrentStep","GoingBack"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.CartCheckout" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cart Checkout", "") ;
   }

   public void wb0E0( )
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
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_6_0E2( true) ;
      }
      else
      {
         wb_table1_6_0E2( false) ;
      }
      return  ;
   }

   public void wb_table1_6_0E2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start0E2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Cart Checkout", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup0E0( ) ;
   }

   public void ws0E2( )
   {
      start0E2( ) ;
      evt0E2( ) ;
   }

   public void evt0E2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e110E2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e120E2 ();
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
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 9 )
                     {
                        OldSteptitles = httpContext.cgiGet( "W0009") ;
                        if ( ( GXutil.len( OldSteptitles) == 0 ) || ( GXutil.strcmp(OldSteptitles, WebComp_Steptitles_Component) != 0 ) )
                        {
                           WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldSteptitles + "_impl", remoteHandle, context);
                           WebComp_Steptitles_Component = OldSteptitles ;
                        }
                        if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
                        {
                           WebComp_Steptitles.componentprocess("W0009", "", sEvt);
                        }
                        WebComp_Steptitles_Component = OldSteptitles ;
                     }
                     else if ( nCmpId == 12 )
                     {
                        OldWizardstepwc = httpContext.cgiGet( "W0012") ;
                        if ( ( GXutil.len( OldWizardstepwc) == 0 ) || ( GXutil.strcmp(OldWizardstepwc, WebComp_Wizardstepwc_Component) != 0 ) )
                        {
                           WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldWizardstepwc + "_impl", remoteHandle, context);
                           WebComp_Wizardstepwc_Component = OldWizardstepwc ;
                        }
                        if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
                        {
                           WebComp_Wizardstepwc.componentprocess("W0012", "", sEvt);
                        }
                        WebComp_Wizardstepwc_Component = OldWizardstepwc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we0E2( )
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

   public void pa0E2( )
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
      rf0E2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "WWPBaseObjects.CartCheckout" ;
      Gx_err = (short)(0) ;
   }

   public void rf0E2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
            {
               WebComp_Steptitles.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               WebComp_Wizardstepwc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e120E2 ();
         wb0E0( ) ;
      }
   }

   public void send_integrity_lvl_hashes0E2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "WWPBaseObjects.CartCheckout" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup0E0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
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
      e110E2 ();
      if (returnInSub) return;
   }

   public void e110E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV13WizardSteps = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Mujer_Morena", remoteHandle) ;
      AV14WizardStep = (com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Address" );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Datos del Domicilio", "") );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Datos del Domicilio", "") );
      AV13WizardSteps.add(AV14WizardStep, 0);
      AV14WizardStep = (com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Payment" );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Informacion del Pago", "") );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Informacion del Pago", "") );
      AV13WizardSteps.add(AV14WizardStep, 0);
      AV14WizardStep = (com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "PlaceOrder" );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Resumen", "") );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Resumen", "") );
      AV13WizardSteps.add(AV14WizardStep, 0);
      AV14WizardStep = (com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)new com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Code( "Completed" );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Title( httpContext.getMessage( "Terminado", "") );
      AV14WizardStep.setgxTv_SdtWizardSteps_WizardStepsItem_Description( httpContext.getMessage( "Terminado", "") );
      AV13WizardSteps.add(AV14WizardStep, 0);
      if ( (GXutil.strcmp("", AV11CurrentStep)==0) )
      {
         AV12CurrentStepAux = "Address" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12CurrentStepAux", AV12CurrentStepAux);
         AV7WebSession.remove(AV18Pgmname+"_Data");
      }
      else
      {
         AV12CurrentStepAux = AV11CurrentStep ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12CurrentStepAux", AV12CurrentStepAux);
      }
      /* Execute user subroutine: 'LOADWIZARDSTEPWC' */
      S112 ();
      if (returnInSub) return;
      /* Object Property */
      if ( true )
      {
         bDynCreated_Steptitles = true ;
      }
      if ( GXutil.strcmp(GXutil.lower( WebComp_Steptitles_Component), GXutil.lower( "WWPBaseObjects.WizardStepsBulletWC")) != 0 )
      {
         WebComp_Steptitles = WebUtils.getWebComponent(getClass(), "com.mujermorena.wwpbaseobjects.wizardstepsbulletwc_impl", remoteHandle, context);
         WebComp_Steptitles_Component = "WWPBaseObjects.WizardStepsBulletWC" ;
      }
      if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
      {
         WebComp_Steptitles.setjustcreated();
         WebComp_Steptitles.componentprepare(new Object[] {"W0009","",AV13WizardSteps,AV12CurrentStepAux});
         WebComp_Steptitles.componentbind(new Object[] {"",""});
      }
   }

   public void S112( )
   {
      /* 'LOADWIZARDSTEPWC' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV12CurrentStepAux, "Address") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "WWPBaseObjects.CartCheckoutAddress")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "com.mujermorena.wwpbaseobjects.cartcheckoutaddress_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "WWPBaseObjects.CartCheckoutAddress" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0012","",AV18Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0012"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      else if ( GXutil.strcmp(AV12CurrentStepAux, "Payment") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "WWPBaseObjects.CartCheckoutPayment")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "com.mujermorena.wwpbaseobjects.cartcheckoutpayment_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "WWPBaseObjects.CartCheckoutPayment" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0012","",AV18Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0012"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      else if ( GXutil.strcmp(AV12CurrentStepAux, "PlaceOrder") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "WWPBaseObjects.CartCheckoutPlaceOrder")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "com.mujermorena.wwpbaseobjects.cartcheckoutplaceorder_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "WWPBaseObjects.CartCheckoutPlaceOrder" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0012","",AV18Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0012"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      else if ( GXutil.strcmp(AV12CurrentStepAux, "Completed") == 0 )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Wizardstepwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Wizardstepwc_Component), GXutil.lower( "WWPBaseObjects.CartCheckoutCompleted")) != 0 )
         {
            WebComp_Wizardstepwc = WebUtils.getWebComponent(getClass(), "com.mujermorena.wwpbaseobjects.cartcheckoutcompleted_impl", remoteHandle, context);
            WebComp_Wizardstepwc_Component = "WWPBaseObjects.CartCheckoutCompleted" ;
         }
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.setjustcreated();
            WebComp_Wizardstepwc.componentprepare(new Object[] {"W0012","",AV18Pgmname+"_Data",AV10PreviousStep,Boolean.valueOf(AV9GoingBack)});
            WebComp_Wizardstepwc.componentbind(new Object[] {""+""+"","",""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Wizardstepwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0012"+"");
            WebComp_Wizardstepwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e120E2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table1_6_0E2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemain_Internalname, tblTablemain_Internalname, "", "TableWizardMainWithShadow", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\" class='WizardStepsCell'>") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0009"+"", GXutil.rtrim( WebComp_Steptitles_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0009"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldSteptitles), GXutil.lower( WebComp_Steptitles_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0009"+"");
               }
               WebComp_Steptitles.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldSteptitles), GXutil.lower( WebComp_Steptitles_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='WizardStepsPositionCell'>") ;
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0012"+"", GXutil.rtrim( WebComp_Wizardstepwc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0012"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWizardstepwc), GXutil.lower( WebComp_Wizardstepwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0012"+"");
               }
               WebComp_Wizardstepwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWizardstepwc), GXutil.lower( WebComp_Wizardstepwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_6_0E2e( true) ;
      }
      else
      {
         wb_table1_6_0E2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10PreviousStep = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10PreviousStep", AV10PreviousStep);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPREVIOUSSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10PreviousStep, ""))));
      AV11CurrentStep = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11CurrentStep", AV11CurrentStep);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTSTEP", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11CurrentStep, ""))));
      AV9GoingBack = ((Boolean) getParm(obj,2)).booleanValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9GoingBack", AV9GoingBack);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vGOINGBACK", getSecureSignedToken( "", AV9GoingBack));
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
      pa0E2( ) ;
      ws0E2( ) ;
      we0E2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Steptitles == null ) )
      {
         if ( GXutil.len( WebComp_Steptitles_Component) != 0 )
         {
            WebComp_Steptitles.componentthemes();
         }
      }
      if ( ! ( WebComp_Wizardstepwc == null ) )
      {
         if ( GXutil.len( WebComp_Wizardstepwc_Component) != 0 )
         {
            WebComp_Wizardstepwc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111112379", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/cartcheckout.js", "?202412111112380", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      tblTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Cart Checkout", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10PreviousStep',fld:'vPREVIOUSSTEP',pic:'',hsh:true},{av:'AV11CurrentStep',fld:'vCURRENTSTEP',pic:'',hsh:true},{av:'AV9GoingBack',fld:'vGOINGBACK',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      return "cartcheckout_Execute";
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
      wcpOAV10PreviousStep = "" ;
      wcpOAV11CurrentStep = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV10PreviousStep = "" ;
      AV11CurrentStep = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      OldSteptitles = "" ;
      WebComp_Steptitles_Component = "" ;
      OldWizardstepwc = "" ;
      WebComp_Wizardstepwc_Component = "" ;
      AV18Pgmname = "" ;
      AV13WizardSteps = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem>(com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem.class, "WizardStepsItem", "Mujer_Morena", remoteHandle);
      AV14WizardStep = new com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem(remoteHandle, context);
      AV12CurrentStepAux = "" ;
      AV7WebSession = httpContext.getWebSession();
      sStyleString = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      AV18Pgmname = "WWPBaseObjects.CartCheckout" ;
      /* GeneXus formulas. */
      AV18Pgmname = "WWPBaseObjects.CartCheckout" ;
      Gx_err = (short)(0) ;
      WebComp_Steptitles = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Wizardstepwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String OldSteptitles ;
   private String WebComp_Steptitles_Component ;
   private String OldWizardstepwc ;
   private String WebComp_Wizardstepwc_Component ;
   private String AV18Pgmname ;
   private String sStyleString ;
   private String tblTablemain_Internalname ;
   private boolean wcpOAV9GoingBack ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9GoingBack ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean bDynCreated_Steptitles ;
   private boolean bDynCreated_Wizardstepwc ;
   private String wcpOAV10PreviousStep ;
   private String wcpOAV11CurrentStep ;
   private String AV10PreviousStep ;
   private String AV11CurrentStep ;
   private String AV12CurrentStepAux ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Steptitles ;
   private GXWebComponent WebComp_Wizardstepwc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV7WebSession ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem> AV13WizardSteps ;
   private com.mujermorena.wwpbaseobjects.SdtWizardSteps_WizardStepsItem AV14WizardStep ;
}

