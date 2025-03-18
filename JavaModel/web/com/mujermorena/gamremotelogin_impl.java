package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamremotelogin_impl extends GXWebPanel
{
   public gamremotelogin_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamremotelogin_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamremotelogin_impl.class ));
   }

   public gamremotelogin_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavLogonto = new HTMLChoice();
      chkavKeepmeloggedin = UIFactory.getCheckbox(this);
      chkavRememberme = UIFactory.getCheckbox(this);
      cmbavTypeauthtype = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "IDP_State") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "IDP_State") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "IDP_State") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridauthtypes") == 0 )
         {
            gxnrgridauthtypes_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridauthtypes") == 0 )
         {
            gxgrgridauthtypes_refresh_invoke( ) ;
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
            AV15IDP_State = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15IDP_State", AV15IDP_State);
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

   public void gxnrgridauthtypes_newrow_invoke( )
   {
      nRC_GXsfl_59 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_59"))) ;
      nGXsfl_59_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_59_idx"))) ;
      sGXsfl_59_idx = httpContext.GetPar( "sGXsfl_59_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridauthtypes_newrow( ) ;
      /* End function gxnrGridauthtypes_newrow_invoke */
   }

   public void gxgrgridauthtypes_refresh_invoke( )
   {
      AV15IDP_State = httpContext.GetPar( "IDP_State") ;
      AV21Language = httpContext.GetPar( "Language") ;
      AV39AuxUserName = httpContext.GetPar( "AuxUserName") ;
      AV33UserRememberMe = (byte)(GXutil.lval( httpContext.GetPar( "UserRememberMe"))) ;
      AV20KeepMeLoggedIn = GXutil.strtobool( httpContext.GetPar( "KeepMeLoggedIn")) ;
      AV25RememberMe = GXutil.strtobool( httpContext.GetPar( "RememberMe")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridauthtypes_refresh( AV15IDP_State, AV21Language, AV39AuxUserName, AV33UserRememberMe, AV20KeepMeLoggedIn, AV25RememberMe) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridauthtypes_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa1Y2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws1Y2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we1Y2( ) ;
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
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( httpContext.getMessage( "Remote Login ", "")) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamremotelogin", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15IDP_State))}, new String[] {"IDP_State"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV21Language, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV39AuxUserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33UserRememberMe), "Z9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_59", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_59, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV15IDP_State));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vLANGUAGE", GXutil.rtrim( AV21Language));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV21Language, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUXUSERNAME", AV39AuxUserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV39AuxUserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV33UserRememberMe, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33UserRememberMe), "Z9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABLEBUTTONS_Visible", GXutil.ltrim( localUtil.ntoc( divTablebuttons_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABLEBUTTONS_Visible", GXutil.ltrim( localUtil.ntoc( divTablebuttons_Visible, (byte)(5), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm1Y2( )
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
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "GAMRemoteLogin" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Remote Login ", "") ;
   }

   public void wb1Y0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "BodyContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "LoginContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTbllogin_Internalname, divTbllogin_Visible, 0, "px", 0, "px", "TableLogin", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Identity Provider", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Logo App Client", ""), "col-sm-3 ImageLabel", 0, true, "");
         /* Static Bitmap Variable */
         ClassString = "Image" + " " + ((GXutil.strcmp(imgavLogoappclient_gximage, "")==0) ? "" : "GX_Image_"+imgavLogoappclient_gximage+"_Class") ;
         StyleString = "" ;
         AV23LogoAppClient_IsBlob = (boolean)(((GXutil.strcmp("", AV23LogoAppClient)==0)&&(GXutil.strcmp("", AV42Logoappclient_GXI)==0))||!(GXutil.strcmp("", AV23LogoAppClient)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV23LogoAppClient)==0) ? AV42Logoappclient_GXI : httpContext.getResourceRelative(AV23LogoAppClient)) ;
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgavLogoappclient_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgavLogoappclient_Visible, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV23LogoAppClient_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbappname_Internalname, lblTbappname_Caption, "", "", lblTbappname_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", lblTbappname_Visible, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavLogonto.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLogonto.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavLogonto.getInternalname(), httpContext.getMessage( "Log on to", ""), "col-sm-5 LoginComboAttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-7 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'" + sGXsfl_59_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLogonto, cmbavLogonto.getInternalname(), GXutil.rtrim( AV24LogOnTo), 1, cmbavLogonto.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVLOGONTO.CLICK."+"'", "char", "", cmbavLogonto.getVisible(), cmbavLogonto.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "LoginComboAttribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_GAMRemoteLogin.htm");
         cmbavLogonto.setValue( GXutil.rtrim( AV24LogOnTo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, httpContext.getMessage( "User Name", ""), "col-sm-3 col-lg-2 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'" + sGXsfl_59_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, AV31UserName, GXutil.rtrim( localUtil.format( AV31UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "User name", ""), edtavUsername_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUsername_Enabled, 0, "text", "", 50, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserpassword_Internalname, httpContext.getMessage( "User Password", ""), "col-sm-3 col-lg-2 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'" + sGXsfl_59_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserpassword_Internalname, GXutil.rtrim( AV32UserPassword), GXutil.rtrim( localUtil.format( AV32UserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", edtavUserpassword_Invitemessage, edtavUserpassword_Jsonclick, 0, "LoginAttribute", "", "", "", "", edtavUserpassword_Visible, edtavUserpassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-7 col-xs-offset-3 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavKeepmeloggedin.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavKeepmeloggedin.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'" + sGXsfl_59_idx + "',0)\"" ;
         ClassString = "checkbox Label" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavKeepmeloggedin.getInternalname(), GXutil.booltostr( AV20KeepMeLoggedIn), "", "", chkavKeepmeloggedin.getVisible(), chkavKeepmeloggedin.getEnabled(), "true", httpContext.getMessage( "Keep me signed in", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(40, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,40);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-7 col-xs-offset-3 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavRememberme.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRememberme.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_59_idx + "',0)\"" ;
         ClassString = "checkbox Label" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRememberme.getInternalname(), GXutil.booltostr( AV25RememberMe), "", "", chkavRememberme.getVisible(), chkavRememberme.getEnabled(), "true", httpContext.getMessage( "Remember Me", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(45, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,45);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
         ClassString = "BtnLogin" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttLogin_Internalname, "gx.evt.setGridEvt("+GXutil.str( 59, 2, 0)+","+"null"+");", bttLogin_Caption, bttLogin_Jsonclick, 5, httpContext.getMessage( "SIGN IN", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-xs-offset-1 col-sm-12 col-sm-offset-0", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbforgotpwd_Internalname, httpContext.getMessage( "FORGOT YOUR PASSWORD?", ""), "", "", lblTbforgotpwd_Jsonclick, "'"+""+"'"+",false,"+"'"+"e111y1_client"+"'", "", "PagingText TextLikeLink", 7, "", lblTbforgotpwd_Visible, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablebuttons_Internalname, divTablebuttons_Visible, 0, "px", 0, "px", "TableButtons", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 col-sm-offset-1", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbexternalauthentication_Internalname, httpContext.getMessage( "OR USE", ""), "", "", lblTbexternalauthentication_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRemoteLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-xs-offset-1 col-sm-8 col-sm-offset-0", "Center", "top", "", "", "div");
         /*  Grid Control  */
         GridauthtypesContainer.SetIsFreestyle(true);
         GridauthtypesContainer.SetWrapped(nGXWrapped);
         startgridcontrol59( ) ;
      }
      if ( wbEnd == 59 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_59 = (int)(nGXsfl_59_idx-1) ;
         if ( GridauthtypesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            if ( subGridauthtypes_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"GridauthtypesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridauthtypes", GridauthtypesContainer, subGridauthtypes_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridauthtypesContainerData", GridauthtypesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridauthtypesContainerData"+"V", GridauthtypesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridauthtypesContainerData"+"V"+"\" value='"+GridauthtypesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 59 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridauthtypesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               if ( subGridauthtypes_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"GridauthtypesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridauthtypes", GridauthtypesContainer, subGridauthtypes_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridauthtypesContainerData", GridauthtypesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridauthtypesContainerData"+"V", GridauthtypesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridauthtypesContainerData"+"V"+"\" value='"+GridauthtypesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1Y2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Remote Login ", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1Y0( ) ;
   }

   public void ws1Y2( )
   {
      start1Y2( ) ;
      evt1Y2( ) ;
   }

   public void evt1Y2( )
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
                     else if ( GXutil.strcmp(sEvt, "VLOGONTO.CLICK") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e121Y2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                              /* Execute user event: Enter */
                              e131Y2 ();
                           }
                           dynload_actions( ) ;
                        }
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
                     if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "GRIDAUTHTYPES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "'SELECTAUTHENTICATIONTYPE'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 26), "'SELECTAUTHENTICATIONTYPE'") == 0 ) )
                     {
                        nGXsfl_59_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_592( ) ;
                        AV36ImageAuthType = httpContext.cgiGet( edtavImageauthtype_Internalname) ;
                        httpContext.ajax_rsp_assign_prop("", false, edtavImageauthtype_Internalname, "Bitmap", ((GXutil.strcmp("", AV36ImageAuthType)==0) ? AV46Imageauthtype_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV36ImageAuthType))), !bGXsfl_59_Refreshing);
                        httpContext.ajax_rsp_assign_prop("", false, edtavImageauthtype_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV36ImageAuthType), true);
                        cmbavTypeauthtype.setName( cmbavTypeauthtype.getInternalname() );
                        cmbavTypeauthtype.setValue( httpContext.cgiGet( cmbavTypeauthtype.getInternalname()) );
                        AV37TypeAuthType = httpContext.cgiGet( cmbavTypeauthtype.getInternalname()) ;
                        httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV37TypeAuthType);
                        AV38NameAuthType = httpContext.cgiGet( edtavNameauthtype_Internalname) ;
                        httpContext.ajax_rsp_assign_attri("", false, edtavNameauthtype_Internalname, AV38NameAuthType);
                        com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE"+"_"+sGXsfl_59_idx, getSecureSignedToken( sGXsfl_59_idx, GXutil.rtrim( localUtil.format( AV38NameAuthType, ""))));
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e141Y2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e151Y2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDAUTHTYPES.LOAD") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e161Y2 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "'SELECTAUTHENTICATIONTYPE'") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: 'SelectAuthenticationType' */
                              e171Y2 ();
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

   public void we1Y2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm1Y2( ) ;
         }
      }
   }

   public void pa1Y2( )
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
            GX_FocusControl = cmbavLogonto.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridauthtypes_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_592( ) ;
      while ( nGXsfl_59_idx <= nRC_GXsfl_59 )
      {
         sendrow_592( ) ;
         nGXsfl_59_idx = ((subGridauthtypes_Islastpage==1)&&(nGXsfl_59_idx+1>subgridauthtypes_fnc_recordsperpage( )) ? 1 : nGXsfl_59_idx+1) ;
         sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_592( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridauthtypesContainer)) ;
      /* End function gxnrGridauthtypes_newrow */
   }

   public void gxgrgridauthtypes_refresh( String AV15IDP_State ,
                                          String AV21Language ,
                                          String AV39AuxUserName ,
                                          byte AV33UserRememberMe ,
                                          boolean AV20KeepMeLoggedIn ,
                                          boolean AV25RememberMe )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e151Y2 ();
      GRIDAUTHTYPES_nCurrentRecord = 0 ;
      rf1Y2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridauthtypes_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38NameAuthType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vNAMEAUTHTYPE", GXutil.rtrim( AV38NameAuthType));
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
      if ( cmbavLogonto.getItemCount() > 0 )
      {
         AV24LogOnTo = cmbavLogonto.getValidValue(AV24LogOnTo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24LogOnTo", AV24LogOnTo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLogonto.setValue( GXutil.rtrim( AV24LogOnTo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
      }
      AV20KeepMeLoggedIn = GXutil.strtobool( GXutil.booltostr( AV20KeepMeLoggedIn)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20KeepMeLoggedIn", AV20KeepMeLoggedIn);
      AV25RememberMe = GXutil.strtobool( GXutil.booltostr( AV25RememberMe)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25RememberMe", AV25RememberMe);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1Y2( ) ;
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
      cmbavTypeauthtype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavTypeauthtype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTypeauthtype.getEnabled(), 5, 0), !bGXsfl_59_Refreshing);
      edtavNameauthtype_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNameauthtype_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNameauthtype_Enabled), 5, 0), !bGXsfl_59_Refreshing);
   }

   public void rf1Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridauthtypesContainer.ClearRows();
      }
      wbStart = (short)(59) ;
      /* Execute user event: Refresh */
      e151Y2 ();
      nGXsfl_59_idx = 1 ;
      sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_592( ) ;
      bGXsfl_59_Refreshing = true ;
      GridauthtypesContainer.AddObjectProperty("GridName", "Gridauthtypes");
      GridauthtypesContainer.AddObjectProperty("CmpContext", "");
      GridauthtypesContainer.AddObjectProperty("InMasterPage", "false");
      GridauthtypesContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Visible, (byte)(5), (byte)(0), ".", "")));
      GridauthtypesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridauthtypesContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridauthtypesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridauthtypesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridauthtypesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridauthtypesContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Visible, (byte)(5), (byte)(0), ".", "")));
      GridauthtypesContainer.setPageSize( subgridauthtypes_fnc_recordsperpage( ) );
      if ( subGridauthtypes_Islastpage != 0 )
      {
         GRIDAUTHTYPES_nFirstRecordOnPage = (long)(subgridauthtypes_fnc_recordcount( )-subgridauthtypes_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDAUTHTYPES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDAUTHTYPES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("GRIDAUTHTYPES_nFirstRecordOnPage", GRIDAUTHTYPES_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_592( ) ;
         e161Y2 ();
         wbEnd = (short)(59) ;
         wb1Y0( ) ;
      }
      bGXsfl_59_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1Y2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vLANGUAGE", GXutil.rtrim( AV21Language));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV21Language, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUXUSERNAME", AV39AuxUserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV39AuxUserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV33UserRememberMe, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33UserRememberMe), "Z9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE"+"_"+sGXsfl_59_idx, getSecureSignedToken( sGXsfl_59_idx, GXutil.rtrim( localUtil.format( AV38NameAuthType, ""))));
   }

   public int subgridauthtypes_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridauthtypes_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridauthtypes_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridauthtypes_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      cmbavTypeauthtype.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavTypeauthtype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTypeauthtype.getEnabled(), 5, 0), !bGXsfl_59_Refreshing);
      edtavNameauthtype_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNameauthtype_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNameauthtype_Enabled), 5, 0), !bGXsfl_59_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e141Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_59 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_59"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV15IDP_State = httpContext.cgiGet( "vIDP_STATE") ;
         divTablebuttons_Visible = (int)(localUtil.ctol( httpContext.cgiGet( "TABLEBUTTONS_Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         AV23LogoAppClient = httpContext.cgiGet( imgavLogoappclient_Internalname) ;
         cmbavLogonto.setName( cmbavLogonto.getInternalname() );
         cmbavLogonto.setValue( httpContext.cgiGet( cmbavLogonto.getInternalname()) );
         AV24LogOnTo = httpContext.cgiGet( cmbavLogonto.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24LogOnTo", AV24LogOnTo);
         AV31UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31UserName", AV31UserName);
         AV32UserPassword = httpContext.cgiGet( edtavUserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32UserPassword", AV32UserPassword);
         AV20KeepMeLoggedIn = GXutil.strtobool( httpContext.cgiGet( chkavKeepmeloggedin.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20KeepMeLoggedIn", AV20KeepMeLoggedIn);
         AV25RememberMe = GXutil.strtobool( httpContext.cgiGet( chkavRememberme.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25RememberMe", AV25RememberMe);
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
      e141Y2 ();
      if (returnInSub) return;
   }

   public void e141Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).checkconnection() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
      if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).ismultitenant() )
      {
         /* Execute user subroutine: 'ISMULTITENANTINSTALLATION' */
         S112 ();
         if (returnInSub) return;
      }
      else
      {
         if ( ! AV16isConnectionOK )
         {
            GXv_char1[0] = AV27RepositoryGUID ;
            if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdefaultrepository(GXv_char1) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            gamremotelogin_impl.this.AV27RepositoryGUID = GXv_char1[0] ;
            if ( Cond_result )
            {
               GXv_objcol_SdtGAMError2[0] = AV10Errors ;
               AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryguid(AV27RepositoryGUID, GXv_objcol_SdtGAMError2) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
               gamremotelogin_impl.this.AV27RepositoryGUID = GXv_char1[0] ;
            }
            else
            {
               AV8ConnectionInfoCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnections() ;
               AV10Errors = GXv_objcol_SdtGAMError2[0] ;
               if ( AV8ConnectionInfoCollection.size() > 0 )
               {
                  GXv_objcol_SdtGAMError2[0] = AV10Errors ;
                  AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnection(((genexus.security.api.genexussecurity.SdtGAMConnectionInfo)AV8ConnectionInfoCollection.elementAt(-1+1)).getgxTv_SdtGAMConnectionInfo_Name(), GXv_objcol_SdtGAMError2) ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
                  AV10Errors = GXv_objcol_SdtGAMError2[0] ;
               }
            }
         }
      }
      GXv_objcol_SdtGAMError2[0] = AV10Errors ;
      AV12GAMApplication = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getremoteapplication(AV15IDP_State, GXv_objcol_SdtGAMError2);
      AV10Errors = GXv_objcol_SdtGAMError2[0] ;
      if ( ! (GXutil.strcmp("", AV12GAMApplication.getgxTv_SdtGAMApplication_Clientimageurl())==0) )
      {
         imgavLogoappclient_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, imgavLogoappclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavLogoappclient_Visible), 5, 0), true);
         lblTbappname_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbappname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbappname_Visible), 5, 0), true);
         AV23LogoAppClient = AV12GAMApplication.getgxTv_SdtGAMApplication_Clientimageurl() ;
         httpContext.ajax_rsp_assign_prop("", false, imgavLogoappclient_Internalname, "Bitmap", ((GXutil.strcmp("", AV23LogoAppClient)==0) ? AV42Logoappclient_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV23LogoAppClient))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavLogoappclient_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV23LogoAppClient), true);
         AV42Logoappclient_GXI = GXDbFile.pathToUrl( AV12GAMApplication.getgxTv_SdtGAMApplication_Clientimageurl(), context.getHttpContext()) ;
         httpContext.ajax_rsp_assign_prop("", false, imgavLogoappclient_Internalname, "Bitmap", ((GXutil.strcmp("", AV23LogoAppClient)==0) ? AV42Logoappclient_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV23LogoAppClient))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavLogoappclient_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV23LogoAppClient), true);
      }
      else
      {
         imgavLogoappclient_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, imgavLogoappclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavLogoappclient_Visible), 5, 0), true);
         lblTbappname_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbappname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbappname_Visible), 5, 0), true);
         lblTbappname_Caption = AV12GAMApplication.getgxTv_SdtGAMApplication_Name() ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbappname_Internalname, "Caption", lblTbappname_Caption, true);
      }
   }

   public void e151Y2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      subGridauthtypes_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridauthtypesContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridauthtypes_Visible), 5, 0), true);
      divTableauthtypeinfo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTableauthtypeinfo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableauthtypeinfo_Visible), 5, 0), !bGXsfl_59_Refreshing);
      AV19isRedirect = false ;
      AV11ErrorsLogin = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
      if ( AV11ErrorsLogin.size() > 0 )
      {
         if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 1 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 104 ) )
         {
         }
         else if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 24 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 23 ) )
         {
            callWebObject(formatLink("com.mujermorena.gamexamplechangepassword", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15IDP_State))}, new String[] {"IDP_State"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
            AV19isRedirect = true ;
         }
         else if ( ((genexus.security.api.genexussecurity.SdtGAMError)AV11ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 161 )
         {
            callWebObject(formatLink("com.mujermorena.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15IDP_State))}, new String[] {"IDP_State"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
            AV19isRedirect = true ;
         }
         else
         {
            AV32UserPassword = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32UserPassword", AV32UserPassword);
            AV10Errors = AV11ErrorsLogin ;
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S122 ();
            if (returnInSub) return;
            divTbllogin_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTbllogin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTbllogin_Visible), 5, 0), true);
         }
      }
      if ( ! AV19isRedirect )
      {
         GXv_SdtGAMSession3[0] = AV28Session;
         GXv_objcol_SdtGAMError2[0] = AV10Errors ;
         AV29SessionValid = new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context).isvalid(GXv_SdtGAMSession3, GXv_objcol_SdtGAMError2) ;
         AV28Session = GXv_SdtGAMSession3[0] ;
         AV10Errors = GXv_objcol_SdtGAMError2[0] ;
         if ( AV29SessionValid && ! AV28Session.getgxTv_SdtGAMSession_Isanonymous() )
         {
            if ( new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isremoteauthentication(AV15IDP_State) )
            {
               new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).redirecttoremoteauthentication(AV15IDP_State) ;
            }
            else
            {
               AV30URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
               if ( (GXutil.strcmp("", AV30URL)==0) )
               {
                  new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context).gohome() ;
               }
               else
               {
                  callWebObject(formatLink(AV30URL, new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(0) ;
               }
            }
         }
         else
         {
            cmbavLogonto.removeAllItems();
            GXv_objcol_SdtGAMError2[0] = AV10Errors ;
            AV7AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV21Language, GXv_objcol_SdtGAMError2) ;
            AV10Errors = GXv_objcol_SdtGAMError2[0] ;
            AV43GXV1 = 1 ;
            while ( AV43GXV1 <= AV7AuthenticationTypes.size() )
            {
               AV6AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV7AuthenticationTypes.elementAt(-1+AV43GXV1));
               if ( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Needusername() )
               {
                  cmbavLogonto.addItem(AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Description(), (short)(0));
               }
               else
               {
                  subGridauthtypes_Visible = 1 ;
                  httpContext.ajax_rsp_assign_prop("", false, "GridauthtypesContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridauthtypes_Visible), 5, 0), true);
               }
               AV43GXV1 = (int)(AV43GXV1+1) ;
            }
            if ( cmbavLogonto.getItemCount() <= 1 )
            {
               cmbavLogonto.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Visible", GXutil.ltrimstr( cmbavLogonto.getVisible(), 5, 0), true);
            }
            else
            {
               AV24LogOnTo = ((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV7AuthenticationTypes.elementAt(-1+1)).getgxTv_SdtGAMAuthenticationTypeSimple_Name() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24LogOnTo", AV24LogOnTo);
            }
            GXv_char1[0] = AV24LogOnTo ;
            GXv_char4[0] = AV39AuxUserName ;
            GXv_int5[0] = AV33UserRememberMe ;
            GXv_objcol_SdtGAMError2[0] = AV10Errors ;
            AV18isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getrememberlogin(GXv_char1, GXv_char4, GXv_int5, GXv_objcol_SdtGAMError2) ;
            gamremotelogin_impl.this.AV24LogOnTo = GXv_char1[0] ;
            gamremotelogin_impl.this.AV39AuxUserName = GXv_char4[0] ;
            gamremotelogin_impl.this.AV33UserRememberMe = GXv_int5[0] ;
            AV10Errors = GXv_objcol_SdtGAMError2[0] ;
            if ( ! (GXutil.strcmp("", AV39AuxUserName)==0) )
            {
               AV31UserName = AV39AuxUserName ;
               httpContext.ajax_rsp_assign_attri("", false, "AV31UserName", AV31UserName);
            }
            if ( AV33UserRememberMe == 2 )
            {
               AV25RememberMe = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25RememberMe", AV25RememberMe);
            }
            AV14GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
            if ( cmbavLogonto.getItemCount() > 1 )
            {
               AV24LogOnTo = AV14GAMRepository.getgxTv_SdtGAMRepository_Defaultauthenticationtypename() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV24LogOnTo", AV24LogOnTo);
            }
            /* Execute user subroutine: 'DISPLAYCHECKBOX' */
            S132 ();
            if (returnInSub) return;
            AV44GXV2 = 1 ;
            while ( AV44GXV2 <= AV7AuthenticationTypes.size() )
            {
               AV6AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV7AuthenticationTypes.elementAt(-1+AV44GXV2));
               if ( GXutil.strcmp(AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV24LogOnTo) == 0 )
               {
                  /* Execute user subroutine: 'VALIDLOGONTOOTP' */
                  S142 ();
                  if (returnInSub) return;
                  if (true) break;
               }
               AV44GXV2 = (int)(AV44GXV2+1) ;
            }
         }
      }
      /*  Sending Event outputs  */
      cmbavLogonto.setValue( GXutil.rtrim( AV24LogOnTo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6AuthenticationType", AV6AuthenticationType);
   }

   private void e161Y2( )
   {
      /* Gridauthtypes_Load Routine */
      returnInSub = false ;
      AV45GXV3 = 1 ;
      while ( AV45GXV3 <= AV7AuthenticationTypes.size() )
      {
         AV6AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV7AuthenticationTypes.elementAt(-1+AV45GXV3));
         if ( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Redirtoauthenticate() )
         {
            if ( ! (GXutil.strcmp("", AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Smallimagename())==0) )
            {
               AV36ImageAuthType = context.getHttpContext().getImagePath( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Smallimagename(), "", context.getHttpContext().getTheme( )) ;
               httpContext.ajax_rsp_assign_attri("", false, edtavImageauthtype_Internalname, AV36ImageAuthType);
               AV46Imageauthtype_GXI = GXDbFile.pathToUrl( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Smallimagename(), context.getHttpContext()) ;
            }
            else
            {
               edtavImageauthtype_gximage = "GAMButtonGAMRemoteSmall" ;
               AV36ImageAuthType = context.getHttpContext().getImagePath( "6cdd3e18-cc5b-44e0-bd22-3efaf48a6c40", "", context.getHttpContext().getTheme( )) ;
               httpContext.ajax_rsp_assign_attri("", false, edtavImageauthtype_Internalname, AV36ImageAuthType);
               AV46Imageauthtype_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "6cdd3e18-cc5b-44e0-bd22-3efaf48a6c40", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
            }
            AV37TypeAuthType = AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Type() ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV37TypeAuthType);
            AV38NameAuthType = GXutil.trim( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name()) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavNameauthtype_Internalname, AV38NameAuthType);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE"+"_"+sGXsfl_59_idx, getSecureSignedToken( sGXsfl_59_idx, GXutil.rtrim( localUtil.format( AV38NameAuthType, ""))));
            edtavImageauthtype_Tooltiptext = GXutil.format( httpContext.getMessage( "Sign in with %1", ""), GXutil.trim( AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Description()), "", "", "", "", "", "", "", "") ;
            if ( ( divTablebuttons_Visible == ( 0 )) )
            {
               divTablebuttons_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablebuttons_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablebuttons_Visible), 5, 0), true);
            }
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(59) ;
            }
            sendrow_592( ) ;
            if ( isFullAjaxMode( ) && ! bGXsfl_59_Refreshing )
            {
               httpContext.doAjaxLoad(59, GridauthtypesRow);
            }
         }
         AV45GXV3 = (int)(AV45GXV3+1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6AuthenticationType", AV6AuthenticationType);
      cmbavTypeauthtype.setValue( GXutil.rtrim( AV37TypeAuthType) );
   }

   public void e121Y2( )
   {
      /* Logonto_Click Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError2[0] = AV10Errors ;
      AV7AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV21Language, GXv_objcol_SdtGAMError2) ;
      AV10Errors = GXv_objcol_SdtGAMError2[0] ;
      AV17isModeOTP = false ;
      AV47GXV4 = 1 ;
      while ( AV47GXV4 <= AV7AuthenticationTypes.size() )
      {
         AV6AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV7AuthenticationTypes.elementAt(-1+AV47GXV4));
         if ( GXutil.strcmp(AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV24LogOnTo) == 0 )
         {
            /* Execute user subroutine: 'VALIDLOGONTOOTP' */
            S142 ();
            if (returnInSub) return;
            if (true) break;
         }
         AV47GXV4 = (int)(AV47GXV4+1) ;
      }
      if ( ! AV17isModeOTP )
      {
         edtavUserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         edtavUserpassword_Invitemessage = httpContext.getMessage( "Password", "") ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Invitemessage", edtavUserpassword_Invitemessage, true);
         bttLogin_Caption = httpContext.getMessage( "SING IN", "") ;
         httpContext.ajax_rsp_assign_prop("", false, bttLogin_Internalname, "Caption", bttLogin_Caption, true);
         lblTbforgotpwd_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbforgotpwd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbforgotpwd_Visible), 5, 0), true);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6AuthenticationType", AV6AuthenticationType);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e131Y2 ();
      if (returnInSub) return;
   }

   public void e131Y2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( AV20KeepMeLoggedIn )
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(3) );
      }
      else if ( AV25RememberMe )
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(2) );
      }
      else
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(1) );
      }
      AV13GAMProperties = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getgamremoteinitialproperties(AV15IDP_State) ;
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Properties( AV13GAMProperties );
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Authenticationtypename( AV24LogOnTo );
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Idpstate( AV15IDP_State );
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Otpstep( (byte)(1) );
      GXv_objcol_SdtGAMError2[0] = AV10Errors ;
      AV22LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV31UserName, AV32UserPassword, AV5AdditionalParameter, GXv_objcol_SdtGAMError2) ;
      AV10Errors = GXv_objcol_SdtGAMError2[0] ;
      if ( AV22LoginOK )
      {
      }
      else
      {
         if ( AV10Errors.size() > 0 )
         {
            if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 24 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 23 ) )
            {
               callWebObject(formatLink("com.mujermorena.gamexamplechangepassword", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else if ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 161 )
            {
               callWebObject(formatLink("com.mujermorena.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 400 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 410 ) )
            {
               callWebObject(formatLink("com.mujermorena.gamexampleotpauthentication", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else
            {
               AV32UserPassword = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV32UserPassword", AV32UserPassword);
               /* Execute user subroutine: 'DISPLAYMESSAGES' */
               S122 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdditionalParameter", AV5AdditionalParameter);
   }

   public void e171Y2( )
   {
      /* 'SelectAuthenticationType' Routine */
      returnInSub = false ;
      if ( AV20KeepMeLoggedIn )
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(3) );
      }
      else if ( AV25RememberMe )
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(2) );
      }
      else
      {
         AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(1) );
      }
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Authenticationtypename( AV38NameAuthType );
      AV5AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Idpstate( AV15IDP_State );
      GXv_objcol_SdtGAMError2[0] = AV10Errors ;
      AV22LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV31UserName, AV32UserPassword, AV5AdditionalParameter, GXv_objcol_SdtGAMError2) ;
      AV10Errors = GXv_objcol_SdtGAMError2[0] ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5AdditionalParameter", AV5AdditionalParameter);
   }

   public void S112( )
   {
      /* 'ISMULTITENANTINSTALLATION' Routine */
      returnInSub = false ;
      AV14GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( ! (0==AV14GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
      {
         GXv_objcol_SdtGAMError2[0] = AV10Errors ;
         AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryid(AV14GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid(), GXv_objcol_SdtGAMError2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
         AV10Errors = GXv_objcol_SdtGAMError2[0] ;
      }
      if ( ! AV16isConnectionOK )
      {
         GXv_char4[0] = AV27RepositoryGUID ;
         if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdefaultrepository(GXv_char4) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         gamremotelogin_impl.this.AV27RepositoryGUID = GXv_char4[0] ;
         if ( Cond_result )
         {
            GXv_objcol_SdtGAMError2[0] = AV10Errors ;
            AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryguid(AV27RepositoryGUID, GXv_objcol_SdtGAMError2) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
            gamremotelogin_impl.this.AV27RepositoryGUID = GXv_char4[0] ;
         }
         else
         {
            AV8ConnectionInfoCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnections() ;
            AV10Errors = GXv_objcol_SdtGAMError2[0] ;
            if ( AV8ConnectionInfoCollection.size() > 0 )
            {
               GXv_objcol_SdtGAMError2[0] = AV10Errors ;
               AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnection(((genexus.security.api.genexussecurity.SdtGAMConnectionInfo)AV8ConnectionInfoCollection.elementAt(-1+1)).getgxTv_SdtGAMConnectionInfo_Name(), GXv_objcol_SdtGAMError2) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
               AV10Errors = GXv_objcol_SdtGAMError2[0] ;
            }
         }
      }
      if ( AV16isConnectionOK )
      {
         AV14GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         if ( ! (0==AV14GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
         {
            GXv_objcol_SdtGAMError2[0] = AV10Errors ;
            AV16isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryid(AV14GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid(), GXv_objcol_SdtGAMError2) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16isConnectionOK", AV16isConnectionOK);
            AV10Errors = GXv_objcol_SdtGAMError2[0] ;
            AV14GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         }
      }
   }

   public void S132( )
   {
      /* 'DISPLAYCHECKBOX' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV26Repository.getgxTv_SdtGAMRepository_Userremembermetype(), "Login") == 0 )
      {
         chkavKeepmeloggedin.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV26Repository.getgxTv_SdtGAMRepository_Userremembermetype(), "Auth") == 0 )
      {
         chkavKeepmeloggedin.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV26Repository.getgxTv_SdtGAMRepository_Userremembermetype(), "Both") == 0 )
      {
         chkavKeepmeloggedin.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
      else
      {
         chkavKeepmeloggedin.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'VALIDLOGONTOOTP' Routine */
      returnInSub = false ;
      if ( ! AV6AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Needuserpassword() )
      {
         AV17isModeOTP = true ;
         edtavUserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         bttLogin_Caption = httpContext.getMessage( "SEND ME A CODE", "") ;
         httpContext.ajax_rsp_assign_prop("", false, bttLogin_Internalname, "Caption", bttLogin_Caption, true);
         lblTbforgotpwd_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbforgotpwd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbforgotpwd_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV48GXV5 = 1 ;
      while ( AV48GXV5 <= AV10Errors.size() )
      {
         AV9Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+AV48GXV5));
         if ( AV9Error.getgxTv_SdtGAMError_Code() != 13 )
         {
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV9Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV9Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         }
         AV48GXV5 = (int)(AV48GXV5+1) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV15IDP_State = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15IDP_State", AV15IDP_State);
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
      pa1Y2( ) ;
      ws1Y2( ) ;
      we1Y2( ) ;
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
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024121111805", true, true);
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
      httpContext.AddJavascriptSource("gamremotelogin.js", "?20241211118014", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_592( )
   {
      edtavImageauthtype_Internalname = "vIMAGEAUTHTYPE_"+sGXsfl_59_idx ;
      cmbavTypeauthtype.setInternalname( "vTYPEAUTHTYPE_"+sGXsfl_59_idx );
      edtavNameauthtype_Internalname = "vNAMEAUTHTYPE_"+sGXsfl_59_idx ;
   }

   public void subsflControlProps_fel_592( )
   {
      edtavImageauthtype_Internalname = "vIMAGEAUTHTYPE_"+sGXsfl_59_fel_idx ;
      cmbavTypeauthtype.setInternalname( "vTYPEAUTHTYPE_"+sGXsfl_59_fel_idx );
      edtavNameauthtype_Internalname = "vNAMEAUTHTYPE_"+sGXsfl_59_fel_idx ;
   }

   public void sendrow_592( )
   {
      subsflControlProps_592( ) ;
      wb1Y0( ) ;
      GridauthtypesRow = GXWebRow.GetNew(context,GridauthtypesContainer) ;
      if ( subGridauthtypes_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridauthtypes_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridauthtypes_Class, "") != 0 )
         {
            subGridauthtypes_Linesclass = subGridauthtypes_Class+"Odd" ;
         }
      }
      else if ( subGridauthtypes_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridauthtypes_Backstyle = (byte)(0) ;
         subGridauthtypes_Backcolor = subGridauthtypes_Allbackcolor ;
         if ( GXutil.strcmp(subGridauthtypes_Class, "") != 0 )
         {
            subGridauthtypes_Linesclass = subGridauthtypes_Class+"Uniform" ;
         }
      }
      else if ( subGridauthtypes_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridauthtypes_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridauthtypes_Class, "") != 0 )
         {
            subGridauthtypes_Linesclass = subGridauthtypes_Class+"Odd" ;
         }
         subGridauthtypes_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridauthtypes_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridauthtypes_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_59_idx) % (2))) == 0 )
         {
            subGridauthtypes_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridauthtypes_Class, "") != 0 )
            {
               subGridauthtypes_Linesclass = subGridauthtypes_Class+"Even" ;
            }
         }
         else
         {
            subGridauthtypes_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridauthtypes_Class, "") != 0 )
            {
               subGridauthtypes_Linesclass = subGridauthtypes_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridauthtypesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridauthtypes_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_59_idx+"\">") ;
      }
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGridauthtypestable1_Internalname+"_"+sGXsfl_59_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(45),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridauthtypesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image Auth Type", ""),"col-sm-3 Fixed30Label",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Active Bitmap Variable */
      TempTags = " " + ((edtavImageauthtype_Enabled!=0)&&(edtavImageauthtype_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 64,'',false,'',59)\"" : " ") ;
      ClassString = "Fixed30" + " " + ((GXutil.strcmp(edtavImageauthtype_gximage, "")==0) ? "" : "GX_Image_"+edtavImageauthtype_gximage+"_Class") ;
      StyleString = "" ;
      AV36ImageAuthType_IsBlob = (boolean)(((GXutil.strcmp("", AV36ImageAuthType)==0)&&(GXutil.strcmp("", AV46Imageauthtype_GXI)==0))||!(GXutil.strcmp("", AV36ImageAuthType)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV36ImageAuthType)==0) ? AV46Imageauthtype_GXI : httpContext.getResourceRelative(AV36ImageAuthType)) ;
      GridauthtypesRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImageauthtype_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(1),"",edtavImageauthtype_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavImageauthtype_Jsonclick,"'"+""+"'"+",false,"+"'"+"E\\'SELECTAUTHENTICATIONTYPE\\'."+sGXsfl_59_idx+"'",StyleString,ClassString,"","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV36ImageAuthType_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableauthtypeinfo_Internalname+"_"+sGXsfl_59_idx,Integer.valueOf(divTableauthtypeinfo_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridauthtypesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavTypeauthtype.getInternalname(),httpContext.getMessage( "Type Auth Type", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      TempTags = " " + ((cmbavTypeauthtype.getEnabled()!=0)&&(cmbavTypeauthtype.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 71,'',false,'"+sGXsfl_59_idx+"',59)\"" : " ") ;
      if ( ( cmbavTypeauthtype.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "vTYPEAUTHTYPE_" + sGXsfl_59_idx ;
         cmbavTypeauthtype.setName( GXCCtl );
         cmbavTypeauthtype.setWebtags( "" );
         cmbavTypeauthtype.addItem("AppleID", httpContext.getMessage( "Apple", ""), (short)(0));
         cmbavTypeauthtype.addItem("Custom", httpContext.getMessage( "Custom", ""), (short)(0));
         cmbavTypeauthtype.addItem("ExternalWebService", httpContext.getMessage( "External Web Service", ""), (short)(0));
         cmbavTypeauthtype.addItem("Facebook", httpContext.getMessage( "Facebook", ""), (short)(0));
         cmbavTypeauthtype.addItem("GAMLocal", httpContext.getMessage( "GAM Local", ""), (short)(0));
         cmbavTypeauthtype.addItem("GAMRemote", httpContext.getMessage( "GAM Remote", ""), (short)(0));
         cmbavTypeauthtype.addItem("GAMRemoteRest", httpContext.getMessage( "GAM Remote Rest", ""), (short)(0));
         cmbavTypeauthtype.addItem("Google", httpContext.getMessage( "Google", ""), (short)(0));
         cmbavTypeauthtype.addItem("Oauth20", httpContext.getMessage( "Oauth 2.0", ""), (short)(0));
         cmbavTypeauthtype.addItem("OTP", httpContext.getMessage( "One Time Password", ""), (short)(0));
         cmbavTypeauthtype.addItem("Saml20", httpContext.getMessage( "Saml 2.0", ""), (short)(0));
         cmbavTypeauthtype.addItem("Twitter", httpContext.getMessage( "Twitter", ""), (short)(0));
         cmbavTypeauthtype.addItem("WeChat", httpContext.getMessage( "WeChat", ""), (short)(0));
         if ( cmbavTypeauthtype.getItemCount() > 0 )
         {
            AV37TypeAuthType = cmbavTypeauthtype.getValidValue(AV37TypeAuthType) ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV37TypeAuthType);
         }
      }
      /* ComboBox */
      GridauthtypesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavTypeauthtype,cmbavTypeauthtype.getInternalname(),GXutil.rtrim( AV37TypeAuthType),Integer.valueOf(1),cmbavTypeauthtype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavTypeauthtype.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavTypeauthtype.getEnabled()!=0)&&(cmbavTypeauthtype.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,71);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbavTypeauthtype.setValue( GXutil.rtrim( AV37TypeAuthType) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavTypeauthtype.getInternalname(), "Values", cmbavTypeauthtype.ToJavascriptSource(), !bGXsfl_59_Refreshing);
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridauthtypesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavNameauthtype_Internalname,httpContext.getMessage( "Name Auth Type", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      TempTags = " " + ((edtavNameauthtype_Enabled!=0)&&(edtavNameauthtype_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 75,'',false,'"+sGXsfl_59_idx+"',59)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridauthtypesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavNameauthtype_Internalname,GXutil.rtrim( AV38NameAuthType),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavNameauthtype_Enabled!=0)&&(edtavNameauthtype_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,75);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavNameauthtype_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavNameauthtype_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(60),"chr",Integer.valueOf(1),"row",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(59),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMAuthenticationTypeName","left",Boolean.valueOf(true),""});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes1Y2( ) ;
      /* End of Columns property logic. */
      GridauthtypesContainer.AddRow(GridauthtypesRow);
      nGXsfl_59_idx = ((subGridauthtypes_Islastpage==1)&&(nGXsfl_59_idx+1>subgridauthtypes_fnc_recordsperpage( )) ? 1 : nGXsfl_59_idx+1) ;
      sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_592( ) ;
      /* End function sendrow_592 */
   }

   public void startgridcontrol59( )
   {
      if ( GridauthtypesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridauthtypesContainer"+"DivS\" data-gxgridid=\"59\">") ;
         sStyleString = "" ;
         if ( subGridauthtypes_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGridauthtypes_Internalname, subGridauthtypes_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridauthtypesContainer.AddObjectProperty("GridName", "Gridauthtypes");
      }
      else
      {
         GridauthtypesContainer.AddObjectProperty("GridName", "Gridauthtypes");
         GridauthtypesContainer.AddObjectProperty("Header", subGridauthtypes_Header);
         GridauthtypesContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         GridauthtypesContainer.AddObjectProperty("Class", "FreeStyleGrid");
         GridauthtypesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Visible, (byte)(5), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("CmpContext", "");
         GridauthtypesContainer.AddObjectProperty("InMasterPage", "false");
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesColumn.AddObjectProperty("Value", httpContext.convertURL( AV36ImageAuthType));
         GridauthtypesColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavImageauthtype_Tooltiptext));
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesColumn.AddObjectProperty("Value", GXutil.rtrim( AV37TypeAuthType));
         GridauthtypesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavTypeauthtype.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesColumn.AddObjectProperty("Value", GXutil.rtrim( AV38NameAuthType));
         GridauthtypesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavNameauthtype_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridauthtypesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridauthtypes_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      imgavLogoappclient_Internalname = "vLOGOAPPCLIENT" ;
      lblTbappname_Internalname = "TBAPPNAME" ;
      cmbavLogonto.setInternalname( "vLOGONTO" );
      edtavUsername_Internalname = "vUSERNAME" ;
      edtavUserpassword_Internalname = "vUSERPASSWORD" ;
      chkavKeepmeloggedin.setInternalname( "vKEEPMELOGGEDIN" );
      chkavRememberme.setInternalname( "vREMEMBERME" );
      bttLogin_Internalname = "LOGIN" ;
      lblTbforgotpwd_Internalname = "TBFORGOTPWD" ;
      lblTbexternalauthentication_Internalname = "TBEXTERNALAUTHENTICATION" ;
      edtavImageauthtype_Internalname = "vIMAGEAUTHTYPE" ;
      cmbavTypeauthtype.setInternalname( "vTYPEAUTHTYPE" );
      edtavNameauthtype_Internalname = "vNAMEAUTHTYPE" ;
      divTableauthtypeinfo_Internalname = "TABLEAUTHTYPEINFO" ;
      divGridauthtypestable1_Internalname = "GRIDAUTHTYPESTABLE1" ;
      divTablebuttons_Internalname = "TABLEBUTTONS" ;
      divTbllogin_Internalname = "TBLLOGIN" ;
      divTable1_Internalname = "TABLE1" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridauthtypes_Internalname = "GRIDAUTHTYPES" ;
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
      subGridauthtypes_Allowcollapsing = (byte)(0) ;
      edtavNameauthtype_Jsonclick = "" ;
      edtavNameauthtype_Visible = 1 ;
      edtavNameauthtype_Enabled = 1 ;
      cmbavTypeauthtype.setJsonclick( "" );
      cmbavTypeauthtype.setVisible( 1 );
      cmbavTypeauthtype.setEnabled( 1 );
      divTableauthtypeinfo_Visible = 1 ;
      edtavImageauthtype_Jsonclick = "" ;
      edtavImageauthtype_gximage = "" ;
      edtavImageauthtype_Visible = 1 ;
      edtavImageauthtype_Enabled = 1 ;
      edtavImageauthtype_Tooltiptext = "" ;
      subGridauthtypes_Class = "FreeStyleGrid" ;
      subGridauthtypes_Backcolorstyle = (byte)(0) ;
      subGridauthtypes_Visible = 1 ;
      divTablebuttons_Visible = 1 ;
      lblTbforgotpwd_Visible = 1 ;
      bttLogin_Caption = httpContext.getMessage( "SIGN IN", "") ;
      chkavRememberme.setEnabled( 1 );
      chkavRememberme.setVisible( 1 );
      chkavKeepmeloggedin.setEnabled( 1 );
      chkavKeepmeloggedin.setVisible( 1 );
      edtavUserpassword_Jsonclick = "" ;
      edtavUserpassword_Invitemessage = httpContext.getMessage( "Password", "") ;
      edtavUserpassword_Enabled = 1 ;
      edtavUserpassword_Visible = 1 ;
      edtavUsername_Jsonclick = "" ;
      edtavUsername_Enabled = 1 ;
      cmbavLogonto.setJsonclick( "" );
      cmbavLogonto.setEnabled( 1 );
      cmbavLogonto.setVisible( 1 );
      lblTbappname_Caption = httpContext.getMessage( "App Name", "") ;
      lblTbappname_Visible = 1 ;
      imgavLogoappclient_gximage = "" ;
      imgavLogoappclient_Visible = 1 ;
      divTbllogin_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavLogonto.setName( "vLOGONTO" );
      cmbavLogonto.setWebtags( "" );
      if ( cmbavLogonto.getItemCount() > 0 )
      {
         AV24LogOnTo = cmbavLogonto.getValidValue(AV24LogOnTo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24LogOnTo", AV24LogOnTo);
      }
      chkavKeepmeloggedin.setName( "vKEEPMELOGGEDIN" );
      chkavKeepmeloggedin.setWebtags( "" );
      chkavKeepmeloggedin.setCaption( httpContext.getMessage( "Keep me signed in", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "TitleCaption", chkavKeepmeloggedin.getCaption(), true);
      chkavKeepmeloggedin.setCheckedValue( "false" );
      AV20KeepMeLoggedIn = GXutil.strtobool( GXutil.booltostr( AV20KeepMeLoggedIn)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20KeepMeLoggedIn", AV20KeepMeLoggedIn);
      chkavRememberme.setName( "vREMEMBERME" );
      chkavRememberme.setWebtags( "" );
      chkavRememberme.setCaption( httpContext.getMessage( "Remember Me", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "TitleCaption", chkavRememberme.getCaption(), true);
      chkavRememberme.setCheckedValue( "false" );
      AV25RememberMe = GXutil.strtobool( GXutil.booltostr( AV25RememberMe)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25RememberMe", AV25RememberMe);
      GXCCtl = "vTYPEAUTHTYPE_" + sGXsfl_59_idx ;
      cmbavTypeauthtype.setName( GXCCtl );
      cmbavTypeauthtype.setWebtags( "" );
      cmbavTypeauthtype.addItem("AppleID", httpContext.getMessage( "Apple", ""), (short)(0));
      cmbavTypeauthtype.addItem("Custom", httpContext.getMessage( "Custom", ""), (short)(0));
      cmbavTypeauthtype.addItem("ExternalWebService", httpContext.getMessage( "External Web Service", ""), (short)(0));
      cmbavTypeauthtype.addItem("Facebook", httpContext.getMessage( "Facebook", ""), (short)(0));
      cmbavTypeauthtype.addItem("GAMLocal", httpContext.getMessage( "GAM Local", ""), (short)(0));
      cmbavTypeauthtype.addItem("GAMRemote", httpContext.getMessage( "GAM Remote", ""), (short)(0));
      cmbavTypeauthtype.addItem("GAMRemoteRest", httpContext.getMessage( "GAM Remote Rest", ""), (short)(0));
      cmbavTypeauthtype.addItem("Google", httpContext.getMessage( "Google", ""), (short)(0));
      cmbavTypeauthtype.addItem("Oauth20", httpContext.getMessage( "Oauth 2.0", ""), (short)(0));
      cmbavTypeauthtype.addItem("OTP", httpContext.getMessage( "One Time Password", ""), (short)(0));
      cmbavTypeauthtype.addItem("Saml20", httpContext.getMessage( "Saml 2.0", ""), (short)(0));
      cmbavTypeauthtype.addItem("Twitter", httpContext.getMessage( "Twitter", ""), (short)(0));
      cmbavTypeauthtype.addItem("WeChat", httpContext.getMessage( "WeChat", ""), (short)(0));
      if ( cmbavTypeauthtype.getItemCount() > 0 )
      {
         AV37TypeAuthType = cmbavTypeauthtype.getValidValue(AV37TypeAuthType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV37TypeAuthType);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDAUTHTYPES_nFirstRecordOnPage'},{av:'GRIDAUTHTYPES_nEOF'},{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV20KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV25RememberMe',fld:'vREMEMBERME',pic:''},{av:'AV21Language',fld:'vLANGUAGE',pic:'',hsh:true},{av:'AV39AuxUserName',fld:'vAUXUSERNAME',pic:'',hsh:true},{av:'AV33UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'subGridauthtypes_Visible',ctrl:'GRIDAUTHTYPES',prop:'Visible'},{av:'divTableauthtypeinfo_Visible',ctrl:'TABLEAUTHTYPEINFO',prop:'Visible'},{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV32UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'divTbllogin_Visible',ctrl:'TBLLOGIN',prop:'Visible'},{av:'cmbavLogonto'},{av:'AV24LogOnTo',fld:'vLOGONTO',pic:''},{av:'AV31UserName',fld:'vUSERNAME',pic:''},{av:'AV25RememberMe',fld:'vREMEMBERME',pic:''},{av:'chkavKeepmeloggedin.getVisible()',ctrl:'vKEEPMELOGGEDIN',prop:'Visible'},{av:'chkavRememberme.getVisible()',ctrl:'vREMEMBERME',prop:'Visible'},{av:'edtavUserpassword_Visible',ctrl:'vUSERPASSWORD',prop:'Visible'},{ctrl:'LOGIN',prop:'Caption'},{av:'lblTbforgotpwd_Visible',ctrl:'TBFORGOTPWD',prop:'Visible'}]}");
      setEventMetadata("GRIDAUTHTYPES.LOAD","{handler:'e161Y2',iparms:[{av:'divTablebuttons_Visible',ctrl:'TABLEBUTTONS',prop:'Visible'}]");
      setEventMetadata("GRIDAUTHTYPES.LOAD",",oparms:[{av:'AV36ImageAuthType',fld:'vIMAGEAUTHTYPE',pic:''},{av:'cmbavTypeauthtype'},{av:'AV37TypeAuthType',fld:'vTYPEAUTHTYPE',pic:''},{av:'AV38NameAuthType',fld:'vNAMEAUTHTYPE',pic:'',hsh:true},{av:'edtavImageauthtype_Tooltiptext',ctrl:'vIMAGEAUTHTYPE',prop:'Tooltiptext'},{av:'divTablebuttons_Visible',ctrl:'TABLEBUTTONS',prop:'Visible'}]}");
      setEventMetadata("VLOGONTO.CLICK","{handler:'e121Y2',iparms:[{av:'AV21Language',fld:'vLANGUAGE',pic:'',hsh:true},{av:'cmbavLogonto'},{av:'AV24LogOnTo',fld:'vLOGONTO',pic:''}]");
      setEventMetadata("VLOGONTO.CLICK",",oparms:[{av:'edtavUserpassword_Visible',ctrl:'vUSERPASSWORD',prop:'Visible'},{av:'edtavUserpassword_Invitemessage',ctrl:'vUSERPASSWORD',prop:'Invitemessage'},{ctrl:'LOGIN',prop:'Caption'},{av:'lblTbforgotpwd_Visible',ctrl:'TBFORGOTPWD',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e131Y2',iparms:[{av:'AV20KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV25RememberMe',fld:'vREMEMBERME',pic:''},{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''},{av:'cmbavLogonto'},{av:'AV24LogOnTo',fld:'vLOGONTO',pic:''},{av:'AV31UserName',fld:'vUSERNAME',pic:''},{av:'AV32UserPassword',fld:'vUSERPASSWORD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV32UserPassword',fld:'vUSERPASSWORD',pic:''}]}");
      setEventMetadata("'FORGOTPASSWORD'","{handler:'e111Y1',iparms:[{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''}]");
      setEventMetadata("'FORGOTPASSWORD'",",oparms:[{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''}]}");
      setEventMetadata("'SELECTAUTHENTICATIONTYPE'","{handler:'e171Y2',iparms:[{av:'AV20KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV25RememberMe',fld:'vREMEMBERME',pic:''},{av:'AV38NameAuthType',fld:'vNAMEAUTHTYPE',pic:'',hsh:true},{av:'AV15IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV31UserName',fld:'vUSERNAME',pic:''},{av:'AV32UserPassword',fld:'vUSERPASSWORD',pic:''}]");
      setEventMetadata("'SELECTAUTHENTICATIONTYPE'",",oparms:[]}");
      setEventMetadata("VALIDV_TYPEAUTHTYPE","{handler:'validv_Typeauthtype',iparms:[]");
      setEventMetadata("VALIDV_TYPEAUTHTYPE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Nameauthtype',iparms:[]");
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
      wcpOAV15IDP_State = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV15IDP_State = "" ;
      AV21Language = "" ;
      AV39AuxUserName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      AV23LogoAppClient = "" ;
      AV42Logoappclient_GXI = "" ;
      sImgUrl = "" ;
      lblTbappname_Jsonclick = "" ;
      TempTags = "" ;
      AV24LogOnTo = "" ;
      AV31UserName = "" ;
      AV32UserPassword = "" ;
      bttLogin_Jsonclick = "" ;
      lblTbforgotpwd_Jsonclick = "" ;
      lblTbexternalauthentication_Jsonclick = "" ;
      GridauthtypesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV36ImageAuthType = "" ;
      AV46Imageauthtype_GXI = "" ;
      AV37TypeAuthType = "" ;
      AV38NameAuthType = "" ;
      AV27RepositoryGUID = "" ;
      AV10Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV8ConnectionInfoCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMConnectionInfo>(genexus.security.api.genexussecurity.SdtGAMConnectionInfo.class, "GAMConnectionInfo", "http://tempuri.org/", remoteHandle);
      AV12GAMApplication = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV11ErrorsLogin = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV28Session = new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context);
      GXv_SdtGAMSession3 = new genexus.security.api.genexussecurity.SdtGAMSession[1] ;
      AV30URL = "" ;
      AV7AuthenticationTypes = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple>(genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple.class, "GAMAuthenticationTypeSimple", "http://tempuri.org/", remoteHandle);
      AV6AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple(remoteHandle, context);
      GXv_char1 = new String[1] ;
      GXv_int5 = new byte[1] ;
      AV14GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      GridauthtypesRow = new com.genexus.webpanels.GXWebRow();
      AV5AdditionalParameter = new genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters(remoteHandle, context);
      AV13GAMProperties = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMProperty>(genexus.security.api.genexussecurity.SdtGAMProperty.class, "GAMProperty", "http://tempuri.org/", remoteHandle);
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtGAMError2 = new GXExternalCollection[1] ;
      AV26Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV9Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridauthtypes_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      subGridauthtypes_Header = "" ;
      GridauthtypesColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      cmbavTypeauthtype.setEnabled( 0 );
      edtavNameauthtype_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV33UserRememberMe ;
   private byte nDonePA ;
   private byte subGridauthtypes_Backcolorstyle ;
   private byte GXv_int5[] ;
   private byte GRIDAUTHTYPES_nEOF ;
   private byte nGXWrapped ;
   private byte subGridauthtypes_Backstyle ;
   private byte subGridauthtypes_Allowselection ;
   private byte subGridauthtypes_Allowhovering ;
   private byte subGridauthtypes_Allowcollapsing ;
   private byte subGridauthtypes_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int divTablebuttons_Visible ;
   private int nRC_GXsfl_59 ;
   private int nGXsfl_59_idx=1 ;
   private int divTbllogin_Visible ;
   private int imgavLogoappclient_Visible ;
   private int lblTbappname_Visible ;
   private int edtavUsername_Enabled ;
   private int edtavUserpassword_Visible ;
   private int edtavUserpassword_Enabled ;
   private int lblTbforgotpwd_Visible ;
   private int subGridauthtypes_Visible ;
   private int subGridauthtypes_Islastpage ;
   private int edtavNameauthtype_Enabled ;
   private int divTableauthtypeinfo_Visible ;
   private int AV43GXV1 ;
   private int AV44GXV2 ;
   private int AV45GXV3 ;
   private int AV47GXV4 ;
   private int AV48GXV5 ;
   private int idxLst ;
   private int subGridauthtypes_Backcolor ;
   private int subGridauthtypes_Allbackcolor ;
   private int edtavImageauthtype_Enabled ;
   private int edtavImageauthtype_Visible ;
   private int edtavNameauthtype_Visible ;
   private int subGridauthtypes_Selectedindex ;
   private int subGridauthtypes_Selectioncolor ;
   private int subGridauthtypes_Hoveringcolor ;
   private long GRIDAUTHTYPES_nCurrentRecord ;
   private long GRIDAUTHTYPES_nFirstRecordOnPage ;
   private String wcpOAV15IDP_State ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV15IDP_State ;
   private String sGXsfl_59_idx="0001" ;
   private String AV21Language ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTbllogin_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String imgavLogoappclient_gximage ;
   private String sImgUrl ;
   private String imgavLogoappclient_Internalname ;
   private String lblTbappname_Internalname ;
   private String lblTbappname_Caption ;
   private String lblTbappname_Jsonclick ;
   private String TempTags ;
   private String AV24LogOnTo ;
   private String edtavUsername_Internalname ;
   private String edtavUsername_Jsonclick ;
   private String edtavUserpassword_Internalname ;
   private String AV32UserPassword ;
   private String edtavUserpassword_Invitemessage ;
   private String edtavUserpassword_Jsonclick ;
   private String bttLogin_Internalname ;
   private String bttLogin_Caption ;
   private String bttLogin_Jsonclick ;
   private String lblTbforgotpwd_Internalname ;
   private String lblTbforgotpwd_Jsonclick ;
   private String divTablebuttons_Internalname ;
   private String lblTbexternalauthentication_Internalname ;
   private String lblTbexternalauthentication_Jsonclick ;
   private String sStyleString ;
   private String subGridauthtypes_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavImageauthtype_Internalname ;
   private String AV37TypeAuthType ;
   private String AV38NameAuthType ;
   private String edtavNameauthtype_Internalname ;
   private String AV27RepositoryGUID ;
   private String divTableauthtypeinfo_Internalname ;
   private String GXv_char1[] ;
   private String edtavImageauthtype_gximage ;
   private String edtavImageauthtype_Tooltiptext ;
   private String GXv_char4[] ;
   private String sGXsfl_59_fel_idx="0001" ;
   private String subGridauthtypes_Class ;
   private String subGridauthtypes_Linesclass ;
   private String divGridauthtypestable1_Internalname ;
   private String edtavImageauthtype_Jsonclick ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavNameauthtype_Jsonclick ;
   private String subGridauthtypes_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV20KeepMeLoggedIn ;
   private boolean AV25RememberMe ;
   private boolean wbLoad ;
   private boolean AV23LogoAppClient_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_59_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV16isConnectionOK ;
   private boolean Cond_result ;
   private boolean gx_refresh_fired ;
   private boolean AV19isRedirect ;
   private boolean AV29SessionValid ;
   private boolean AV18isOK ;
   private boolean AV17isModeOTP ;
   private boolean AV22LoginOK ;
   private boolean AV36ImageAuthType_IsBlob ;
   private String AV39AuxUserName ;
   private String AV42Logoappclient_GXI ;
   private String AV31UserName ;
   private String AV46Imageauthtype_GXI ;
   private String AV30URL ;
   private String AV23LogoAppClient ;
   private String AV36ImageAuthType ;
   private com.genexus.webpanels.GXWebGrid GridauthtypesContainer ;
   private com.genexus.webpanels.GXWebRow GridauthtypesRow ;
   private com.genexus.webpanels.GXWebColumn GridauthtypesColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters AV5AdditionalParameter ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV26Repository ;
   private HTMLChoice cmbavLogonto ;
   private ICheckbox chkavKeepmeloggedin ;
   private ICheckbox chkavRememberme ;
   private HTMLChoice cmbavTypeauthtype ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMProperty> AV13GAMProperties ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple> AV7AuthenticationTypes ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMConnectionInfo> AV8ConnectionInfoCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV10Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV11ErrorsLogin ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError2[] ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple AV6AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMError AV9Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV14GAMRepository ;
   private genexus.security.api.genexussecurity.SdtGAMSession AV28Session ;
   private genexus.security.api.genexussecurity.SdtGAMSession GXv_SdtGAMSession3[] ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV12GAMApplication ;
}

