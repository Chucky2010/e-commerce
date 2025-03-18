package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamexamplelogin_impl extends GXWebPanel
{
   public gamexamplelogin_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamexamplelogin_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamexamplelogin_impl.class ));
   }

   public gamexamplelogin_impl( int remoteHandle ,
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
      nRC_GXsfl_63 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_63"))) ;
      nGXsfl_63_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_63_idx"))) ;
      sGXsfl_63_idx = httpContext.GetPar( "sGXsfl_63_idx") ;
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
      AV30Language = httpContext.GetPar( "Language") ;
      AV19AuxUserName = httpContext.GetPar( "AuxUserName") ;
      AV37UserRememberMe = (byte)(GXutil.lval( httpContext.GetPar( "UserRememberMe"))) ;
      AV14KeepMeLoggedIn = GXutil.strtobool( httpContext.GetPar( "KeepMeLoggedIn")) ;
      AV15RememberMe = GXutil.strtobool( httpContext.GetPar( "RememberMe")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridauthtypes_refresh( AV30Language, AV19AuxUserName, AV37UserRememberMe, AV14KeepMeLoggedIn, AV15RememberMe) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridauthtypes_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa072( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws072( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we072( ) ;
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
      httpContext.writeValue( httpContext.getMessage( "Login", "")) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamexamplelogin", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30Language, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19AuxUserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37UserRememberMe), "Z9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_63", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_63, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vLANGUAGE", GXutil.rtrim( AV30Language));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30Language, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUXUSERNAME", AV19AuxUserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19AuxUserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV37UserRememberMe, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37UserRememberMe), "Z9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV25IDP_State));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABLEBUTTONS_Visible", GXutil.ltrim( localUtil.ntoc( divTablebuttons_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABLEBUTTONS_Visible", GXutil.ltrim( localUtil.ntoc( divTablebuttons_Visible, (byte)(5), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm072( )
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
      return "GAMExampleLogin" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Login", "") ;
   }

   public void wb070( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablelogin_Internalname, 1, 0, "px", 0, "px", "TableLogin", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "LOGIN", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblCurrentrepository_Internalname, lblCurrentrepository_Caption, "", "", lblCurrentrepository_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "VersionText", 0, "", lblCurrentrepository_Visible, 1, 0, (short)(0), "HLP_GAMExampleLogin.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLogonto, cmbavLogonto.getInternalname(), GXutil.rtrim( AV11LogOnTo), 1, cmbavLogonto.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVLOGONTO.CLICK."+"'", "char", "", cmbavLogonto.getVisible(), cmbavLogonto.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "LoginComboAttribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,23);\"", "", true, (byte)(0), "HLP_GAMExampleLogin.htm");
         cmbavLogonto.setValue( GXutil.rtrim( AV11LogOnTo) );
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
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, httpContext.getMessage( "User Name", ""), "col-sm-3 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, AV12UserName, GXutil.rtrim( localUtil.format( AV12UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "User name", ""), edtavUsername_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUsername_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMExampleLogin.htm");
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
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserpassword_Internalname, httpContext.getMessage( "User Password", ""), "col-sm-3 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserpassword_Internalname, GXutil.rtrim( AV13UserPassword), GXutil.rtrim( localUtil.format( AV13UserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", edtavUserpassword_Invitemessage, edtavUserpassword_Jsonclick, 0, "LoginAttribute", "", "", "", "", edtavUserpassword_Visible, edtavUserpassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMExampleLogin.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "checkbox Label" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavKeepmeloggedin.getInternalname(), GXutil.booltostr( AV14KeepMeLoggedIn), "", "", chkavKeepmeloggedin.getVisible(), chkavKeepmeloggedin.getEnabled(), "true", httpContext.getMessage( "Keep me logged in", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(36, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,36);\"");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',false,'" + sGXsfl_63_idx + "',0)\"" ;
         ClassString = "checkbox Label" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRememberme.getInternalname(), GXutil.booltostr( AV15RememberMe), "", "", chkavRememberme.getVisible(), chkavRememberme.getEnabled(), "true", httpContext.getMessage( "Remember Me", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(41, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,41);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
         ClassString = "BtnLogin" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttLogin_Internalname, "gx.evt.setGridEvt("+GXutil.str( 63, 2, 0)+","+"null"+");", bttLogin_Caption, bttLogin_Jsonclick, 5, httpContext.getMessage( "SIGN IN", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-xs-offset-1 col-sm-12 col-sm-offset-0", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbforgotpwd_Internalname, httpContext.getMessage( "FORGOT YOUR PASSWORD?", ""), "", "", lblTbforgotpwd_Jsonclick, "'"+""+"'"+",false,"+"'"+"e11071_client"+"'", "", "PagingText TextLikeLink", 7, "", lblTbforgotpwd_Visible, 1, 0, (short)(0), "HLP_GAMExampleLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-xs-offset-1 col-sm-12 col-sm-offset-0", "Center", "top", "", "", "div");
         wb_table1_50_072( true) ;
      }
      else
      {
         wb_table1_50_072( false) ;
      }
      return  ;
   }

   public void wb_table1_50_072e( boolean wbgen )
   {
      if ( wbgen )
      {
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbexternalauthentication_Internalname, httpContext.getMessage( "OR USE", ""), "", "", lblTbexternalauthentication_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleLogin.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-xs-offset-1 col-sm-8 col-sm-offset-0", "Center", "top", "", "", "div");
         /*  Grid Control  */
         GridauthtypesContainer.SetIsFreestyle(true);
         GridauthtypesContainer.SetWrapped(nGXWrapped);
         startgridcontrol63( ) ;
      }
      if ( wbEnd == 63 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_63 = (int)(nGXsfl_63_idx-1) ;
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
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
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
      if ( wbEnd == 63 )
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

   public void start072( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Login", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup070( ) ;
   }

   public void ws072( )
   {
      start072( ) ;
      evt072( ) ;
   }

   public void evt072( )
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
                        e12072 ();
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
                              e13072 ();
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
                        nGXsfl_63_idx = (int)(GXutil.lval( sEvtType)) ;
                        sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
                        subsflControlProps_632( ) ;
                        AV8ImageAuthType = httpContext.cgiGet( edtavImageauthtype_Internalname) ;
                        httpContext.ajax_rsp_assign_prop("", false, edtavImageauthtype_Internalname, "Bitmap", ((GXutil.strcmp("", AV8ImageAuthType)==0) ? AV43Imageauthtype_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV8ImageAuthType))), !bGXsfl_63_Refreshing);
                        httpContext.ajax_rsp_assign_prop("", false, edtavImageauthtype_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV8ImageAuthType), true);
                        cmbavTypeauthtype.setName( cmbavTypeauthtype.getInternalname() );
                        cmbavTypeauthtype.setValue( httpContext.cgiGet( cmbavTypeauthtype.getInternalname()) );
                        AV9TypeAuthType = httpContext.cgiGet( cmbavTypeauthtype.getInternalname()) ;
                        httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV9TypeAuthType);
                        AV10NameAuthType = httpContext.cgiGet( edtavNameauthtype_Internalname) ;
                        httpContext.ajax_rsp_assign_attri("", false, edtavNameauthtype_Internalname, AV10NameAuthType);
                        com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE"+"_"+sGXsfl_63_idx, getSecureSignedToken( sGXsfl_63_idx, GXutil.rtrim( localUtil.format( AV10NameAuthType, ""))));
                        sEvtType = GXutil.right( sEvt, 1) ;
                        if ( GXutil.strcmp(sEvtType, ".") == 0 )
                        {
                           sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                           if ( GXutil.strcmp(sEvt, "START") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Start */
                              e14072 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: Refresh */
                              e15072 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "GRIDAUTHTYPES.LOAD") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              e16072 ();
                           }
                           else if ( GXutil.strcmp(sEvt, "'SELECTAUTHENTICATIONTYPE'") == 0 )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              dynload_actions( ) ;
                              /* Execute user event: 'SelectAuthenticationType' */
                              e17072 ();
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

   public void we072( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm072( ) ;
         }
      }
   }

   public void pa072( )
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
      subsflControlProps_632( ) ;
      while ( nGXsfl_63_idx <= nRC_GXsfl_63 )
      {
         sendrow_632( ) ;
         nGXsfl_63_idx = ((subGridauthtypes_Islastpage==1)&&(nGXsfl_63_idx+1>subgridauthtypes_fnc_recordsperpage( )) ? 1 : nGXsfl_63_idx+1) ;
         sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_632( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridauthtypesContainer)) ;
      /* End function gxnrGridauthtypes_newrow */
   }

   public void gxgrgridauthtypes_refresh( String AV30Language ,
                                          String AV19AuxUserName ,
                                          byte AV37UserRememberMe ,
                                          boolean AV14KeepMeLoggedIn ,
                                          boolean AV15RememberMe )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e15072 ();
      GRIDAUTHTYPES_nCurrentRecord = 0 ;
      rf072( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridauthtypes_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10NameAuthType, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vNAMEAUTHTYPE", GXutil.rtrim( AV10NameAuthType));
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
         AV11LogOnTo = cmbavLogonto.getValidValue(AV11LogOnTo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11LogOnTo", AV11LogOnTo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLogonto.setValue( GXutil.rtrim( AV11LogOnTo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
      }
      AV14KeepMeLoggedIn = GXutil.strtobool( GXutil.booltostr( AV14KeepMeLoggedIn)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14KeepMeLoggedIn", AV14KeepMeLoggedIn);
      AV15RememberMe = GXutil.strtobool( GXutil.booltostr( AV15RememberMe)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15RememberMe", AV15RememberMe);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf072( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, cmbavTypeauthtype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTypeauthtype.getEnabled(), 5, 0), !bGXsfl_63_Refreshing);
      edtavNameauthtype_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNameauthtype_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNameauthtype_Enabled), 5, 0), !bGXsfl_63_Refreshing);
   }

   public void rf072( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridauthtypesContainer.ClearRows();
      }
      wbStart = (short)(63) ;
      /* Execute user event: Refresh */
      e15072 ();
      nGXsfl_63_idx = 1 ;
      sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_632( ) ;
      bGXsfl_63_Refreshing = true ;
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
         subsflControlProps_632( ) ;
         e16072 ();
         wbEnd = (short)(63) ;
         wb070( ) ;
      }
      bGXsfl_63_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes072( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vLANGUAGE", GXutil.rtrim( AV30Language));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLANGUAGE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30Language, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUXUSERNAME", AV19AuxUserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUXUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV19AuxUserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERREMEMBERME", GXutil.ltrim( localUtil.ntoc( AV37UserRememberMe, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERREMEMBERME", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37UserRememberMe), "Z9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE"+"_"+sGXsfl_63_idx, getSecureSignedToken( sGXsfl_63_idx, GXutil.rtrim( localUtil.format( AV10NameAuthType, ""))));
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
      httpContext.ajax_rsp_assign_prop("", false, cmbavTypeauthtype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavTypeauthtype.getEnabled(), 5, 0), !bGXsfl_63_Refreshing);
      edtavNameauthtype_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNameauthtype_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNameauthtype_Enabled), 5, 0), !bGXsfl_63_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup070( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e14072 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_63 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_63"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV25IDP_State = httpContext.cgiGet( "vIDP_STATE") ;
         divTablebuttons_Visible = (int)(localUtil.ctol( httpContext.cgiGet( "TABLEBUTTONS_Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         cmbavLogonto.setName( cmbavLogonto.getInternalname() );
         cmbavLogonto.setValue( httpContext.cgiGet( cmbavLogonto.getInternalname()) );
         AV11LogOnTo = httpContext.cgiGet( cmbavLogonto.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11LogOnTo", AV11LogOnTo);
         AV12UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12UserName", AV12UserName);
         AV13UserPassword = httpContext.cgiGet( edtavUserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13UserPassword", AV13UserPassword);
         AV14KeepMeLoggedIn = GXutil.strtobool( httpContext.cgiGet( chkavKeepmeloggedin.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14KeepMeLoggedIn", AV14KeepMeLoggedIn);
         AV15RememberMe = GXutil.strtobool( httpContext.cgiGet( chkavRememberme.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15RememberMe", AV15RememberMe);
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
      e14072 ();
      if (returnInSub) return;
   }

   public void e14072( )
   {
      /* Start Routine */
      returnInSub = false ;
      lblCurrentrepository_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, lblCurrentrepository_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCurrentrepository_Visible), 5, 0), true);
      divTablebuttons_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablebuttons_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablebuttons_Visible), 5, 0), true);
      AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).checkconnection() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
      if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).ismultitenant() )
      {
         /* Execute user subroutine: 'ISMULTITENANTINSTALLATION' */
         S112 ();
         if (returnInSub) return;
      }
      else
      {
         if ( ! AV26isConnectionOK )
         {
            GXv_char1[0] = AV34RepositoryGUID ;
            if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdefaultrepository(GXv_char1) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            gamexamplelogin_impl.this.AV34RepositoryGUID = GXv_char1[0] ;
            if ( Cond_result )
            {
               GXv_objcol_SdtGAMError2[0] = AV22Errors ;
               AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryguid(AV34RepositoryGUID, GXv_objcol_SdtGAMError2) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
               gamexamplelogin_impl.this.AV34RepositoryGUID = GXv_char1[0] ;
            }
            else
            {
               AV20ConnectionInfoCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnections() ;
               AV22Errors = GXv_objcol_SdtGAMError2[0] ;
               if ( AV20ConnectionInfoCollection.size() > 0 )
               {
                  GXv_objcol_SdtGAMError2[0] = AV22Errors ;
                  AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnection(((genexus.security.api.genexussecurity.SdtGAMConnectionInfo)AV20ConnectionInfoCollection.elementAt(-1+1)).getgxTv_SdtGAMConnectionInfo_Name(), GXv_objcol_SdtGAMError2) ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
                  AV22Errors = GXv_objcol_SdtGAMError2[0] ;
               }
            }
         }
      }
   }

   public void e15072( )
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
      httpContext.ajax_rsp_assign_prop("", false, divTableauthtypeinfo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableauthtypeinfo_Visible), 5, 0), !bGXsfl_63_Refreshing);
      AV29isRedirect = false ;
      AV23ErrorsLogin = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
      if ( AV23ErrorsLogin.size() > 0 )
      {
         if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV23ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 1 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV23ErrorsLogin.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 104 ) )
         {
         }
         else
         {
            AV13UserPassword = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13UserPassword", AV13UserPassword);
            AV22Errors = AV23ErrorsLogin ;
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S122 ();
            if (returnInSub) return;
         }
      }
      if ( ! AV29isRedirect )
      {
         GXv_SdtGAMSession3[0] = AV35Session;
         GXv_objcol_SdtGAMError2[0] = AV22Errors ;
         AV36SessionValid = new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context).isvalid(GXv_SdtGAMSession3, GXv_objcol_SdtGAMError2) ;
         AV35Session = GXv_SdtGAMSession3[0] ;
         AV22Errors = GXv_objcol_SdtGAMError2[0] ;
         if ( AV36SessionValid && ! AV35Session.getgxTv_SdtGAMSession_Isanonymous() )
         {
            AV7URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
            if ( (GXutil.strcmp("", AV7URL)==0) )
            {
               callWebObject(formatLink("com.mujermorena.gamhome", new String[] {}, new String[] {}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else
            {
               callWebObject(formatLink(AV7URL, new String[] {}, new String[] {}) );
               httpContext.wjLocDisableFrm = (byte)(0) ;
            }
         }
         else
         {
            cmbavLogonto.removeAllItems();
            GXv_objcol_SdtGAMError2[0] = AV22Errors ;
            AV18AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV30Language, GXv_objcol_SdtGAMError2) ;
            AV22Errors = GXv_objcol_SdtGAMError2[0] ;
            AV40GXV1 = 1 ;
            while ( AV40GXV1 <= AV18AuthenticationTypes.size() )
            {
               AV17AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV18AuthenticationTypes.elementAt(-1+AV40GXV1));
               if ( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Needusername() )
               {
                  cmbavLogonto.addItem(AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Description(), (short)(0));
               }
               else
               {
                  subGridauthtypes_Visible = 1 ;
                  httpContext.ajax_rsp_assign_prop("", false, "GridauthtypesContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridauthtypes_Visible), 5, 0), true);
               }
               AV40GXV1 = (int)(AV40GXV1+1) ;
            }
            if ( cmbavLogonto.getItemCount() <= 1 )
            {
               cmbavLogonto.setVisible( 0 );
               httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Visible", GXutil.ltrimstr( cmbavLogonto.getVisible(), 5, 0), true);
            }
            else
            {
               AV11LogOnTo = ((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV18AuthenticationTypes.elementAt(-1+1)).getgxTv_SdtGAMAuthenticationTypeSimple_Name() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11LogOnTo", AV11LogOnTo);
            }
            GXv_char1[0] = AV11LogOnTo ;
            GXv_char4[0] = AV19AuxUserName ;
            GXv_int5[0] = AV37UserRememberMe ;
            GXv_objcol_SdtGAMError2[0] = AV22Errors ;
            AV28isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getrememberlogin(GXv_char1, GXv_char4, GXv_int5, GXv_objcol_SdtGAMError2) ;
            gamexamplelogin_impl.this.AV11LogOnTo = GXv_char1[0] ;
            gamexamplelogin_impl.this.AV19AuxUserName = GXv_char4[0] ;
            gamexamplelogin_impl.this.AV37UserRememberMe = GXv_int5[0] ;
            AV22Errors = GXv_objcol_SdtGAMError2[0] ;
            if ( ! (GXutil.strcmp("", AV19AuxUserName)==0) )
            {
               AV12UserName = AV19AuxUserName ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12UserName", AV12UserName);
            }
            if ( AV37UserRememberMe == 2 )
            {
               AV15RememberMe = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15RememberMe", AV15RememberMe);
            }
            AV24GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
            if ( cmbavLogonto.getItemCount() > 1 )
            {
               AV11LogOnTo = AV24GAMRepository.getgxTv_SdtGAMRepository_Defaultauthenticationtypename() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11LogOnTo", AV11LogOnTo);
            }
            /* Execute user subroutine: 'DISPLAYCHECKBOX' */
            S132 ();
            if (returnInSub) return;
            AV41GXV2 = 1 ;
            while ( AV41GXV2 <= AV18AuthenticationTypes.size() )
            {
               AV17AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV18AuthenticationTypes.elementAt(-1+AV41GXV2));
               if ( GXutil.strcmp(AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV11LogOnTo) == 0 )
               {
                  /* Execute user subroutine: 'VALIDLOGONTOOTP' */
                  S142 ();
                  if (returnInSub) return;
                  if (true) break;
               }
               AV41GXV2 = (int)(AV41GXV2+1) ;
            }
         }
      }
      /*  Sending Event outputs  */
      cmbavLogonto.setValue( GXutil.rtrim( AV11LogOnTo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavLogonto.getInternalname(), "Values", cmbavLogonto.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV17AuthenticationType", AV17AuthenticationType);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24GAMRepository", AV24GAMRepository);
   }

   private void e16072( )
   {
      /* Gridauthtypes_Load Routine */
      returnInSub = false ;
      AV42GXV3 = 1 ;
      while ( AV42GXV3 <= AV18AuthenticationTypes.size() )
      {
         AV17AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV18AuthenticationTypes.elementAt(-1+AV42GXV3));
         if ( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Redirtoauthenticate() )
         {
            if ( ! (GXutil.strcmp("", AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Smallimagename())==0) )
            {
               AV8ImageAuthType = context.getHttpContext().getImagePath( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Smallimagename(), "", context.getHttpContext().getTheme( )) ;
               httpContext.ajax_rsp_assign_attri("", false, edtavImageauthtype_Internalname, AV8ImageAuthType);
               AV43Imageauthtype_GXI = GXDbFile.pathToUrl( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Smallimagename(), context.getHttpContext()) ;
            }
            else
            {
               edtavImageauthtype_gximage = "GAMButtonGAMRemoteSmall" ;
               AV8ImageAuthType = context.getHttpContext().getImagePath( "6cdd3e18-cc5b-44e0-bd22-3efaf48a6c40", "", context.getHttpContext().getTheme( )) ;
               httpContext.ajax_rsp_assign_attri("", false, edtavImageauthtype_Internalname, AV8ImageAuthType);
               AV43Imageauthtype_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "6cdd3e18-cc5b-44e0-bd22-3efaf48a6c40", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
            }
            AV9TypeAuthType = AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Type() ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV9TypeAuthType);
            AV10NameAuthType = GXutil.trim( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name()) ;
            httpContext.ajax_rsp_assign_attri("", false, edtavNameauthtype_Internalname, AV10NameAuthType);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNAMEAUTHTYPE"+"_"+sGXsfl_63_idx, getSecureSignedToken( sGXsfl_63_idx, GXutil.rtrim( localUtil.format( AV10NameAuthType, ""))));
            edtavImageauthtype_Tooltiptext = GXutil.format( httpContext.getMessage( "Sign in with %1", ""), GXutil.trim( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Description()), "", "", "", "", "", "", "", "") ;
            if ( ( divTablebuttons_Visible == ( 0 )) )
            {
               divTablebuttons_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablebuttons_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablebuttons_Visible), 5, 0), true);
            }
            /* Load Method */
            if ( wbStart != -1 )
            {
               wbStart = (short)(63) ;
            }
            sendrow_632( ) ;
            if ( isFullAjaxMode( ) && ! bGXsfl_63_Refreshing )
            {
               httpContext.doAjaxLoad(63, GridauthtypesRow);
            }
         }
         AV42GXV3 = (int)(AV42GXV3+1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV17AuthenticationType", AV17AuthenticationType);
      cmbavTypeauthtype.setValue( GXutil.rtrim( AV9TypeAuthType) );
   }

   public void e12072( )
   {
      /* Logonto_Click Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError2[0] = AV22Errors ;
      AV18AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV30Language, GXv_objcol_SdtGAMError2) ;
      AV22Errors = GXv_objcol_SdtGAMError2[0] ;
      AV27isModeOTP = false ;
      AV44GXV4 = 1 ;
      while ( AV44GXV4 <= AV18AuthenticationTypes.size() )
      {
         AV17AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV18AuthenticationTypes.elementAt(-1+AV44GXV4));
         if ( GXutil.strcmp(AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV11LogOnTo) == 0 )
         {
            /* Execute user subroutine: 'VALIDLOGONTOOTP' */
            S142 ();
            if (returnInSub) return;
            if (true) break;
         }
         AV44GXV4 = (int)(AV44GXV4+1) ;
      }
      if ( ! AV27isModeOTP )
      {
         edtavUserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         edtavUserpassword_Invitemessage = httpContext.getMessage( "Password", "") ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Invitemessage", edtavUserpassword_Invitemessage, true);
         bttLogin_Caption = httpContext.getMessage( "SING IN", "") ;
         httpContext.ajax_rsp_assign_prop("", false, bttLogin_Internalname, "Caption", bttLogin_Caption, true);
         lblTbforgotpwd_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbforgotpwd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbforgotpwd_Visible), 5, 0), true);
         lblTbor_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbor_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbor_Visible), 5, 0), true);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV17AuthenticationType", AV17AuthenticationType);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e13072 ();
      if (returnInSub) return;
   }

   public void e13072( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( AV14KeepMeLoggedIn )
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(3) );
      }
      else if ( AV15RememberMe )
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(2) );
      }
      else
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(1) );
      }
      AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Authenticationtypename( AV11LogOnTo );
      AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Otpstep( (byte)(1) );
      GXv_objcol_SdtGAMError2[0] = AV22Errors ;
      AV32LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV12UserName, AV13UserPassword, AV16AdditionalParameter, GXv_objcol_SdtGAMError2) ;
      AV22Errors = GXv_objcol_SdtGAMError2[0] ;
      if ( AV32LoginOK )
      {
         AV7URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
         if ( (GXutil.strcmp("", AV7URL)==0) )
         {
            callWebObject(formatLink("com.mujermorena.gamhome", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            callWebObject(formatLink(AV7URL, new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(0) ;
         }
      }
      else
      {
         if ( AV22Errors.size() > 0 )
         {
            if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV22Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 24 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV22Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 23 ) )
            {
               callWebObject(formatLink("com.mujermorena.gamexamplechangepassword", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else if ( ((genexus.security.api.genexussecurity.SdtGAMError)AV22Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 161 )
            {
               callWebObject(formatLink("com.mujermorena.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else if ( ( ((genexus.security.api.genexussecurity.SdtGAMError)AV22Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 400 ) || ( ((genexus.security.api.genexussecurity.SdtGAMError)AV22Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 410 ) )
            {
               callWebObject(formatLink("com.mujermorena.gamexampleotpauthentication", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25IDP_State))}, new String[] {"IDP_State"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
            else
            {
               AV13UserPassword = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13UserPassword", AV13UserPassword);
               /* Execute user subroutine: 'DISPLAYMESSAGES' */
               S122 ();
               if (returnInSub) return;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16AdditionalParameter", AV16AdditionalParameter);
   }

   public void e17072( )
   {
      /* 'SelectAuthenticationType' Routine */
      returnInSub = false ;
      if ( AV14KeepMeLoggedIn )
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(3) );
      }
      else if ( AV15RememberMe )
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(2) );
      }
      else
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Rememberusertype( (byte)(1) );
      }
      AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Authenticationtypename( AV10NameAuthType );
      GXv_objcol_SdtGAMError2[0] = AV22Errors ;
      AV32LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV12UserName, AV13UserPassword, AV16AdditionalParameter, GXv_objcol_SdtGAMError2) ;
      AV22Errors = GXv_objcol_SdtGAMError2[0] ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16AdditionalParameter", AV16AdditionalParameter);
   }

   public void S112( )
   {
      /* 'ISMULTITENANTINSTALLATION' Routine */
      returnInSub = false ;
      AV24GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( ! (0==AV24GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
      {
         GXv_objcol_SdtGAMError2[0] = AV22Errors ;
         AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryid(AV24GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid(), GXv_objcol_SdtGAMError2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
         AV22Errors = GXv_objcol_SdtGAMError2[0] ;
      }
      if ( ! AV26isConnectionOK )
      {
         GXv_char4[0] = AV34RepositoryGUID ;
         if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdefaultrepository(GXv_char4) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         gamexamplelogin_impl.this.AV34RepositoryGUID = GXv_char4[0] ;
         if ( Cond_result )
         {
            GXv_objcol_SdtGAMError2[0] = AV22Errors ;
            AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryguid(AV34RepositoryGUID, GXv_objcol_SdtGAMError2) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
            gamexamplelogin_impl.this.AV34RepositoryGUID = GXv_char4[0] ;
         }
         else
         {
            AV20ConnectionInfoCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnections() ;
            AV22Errors = GXv_objcol_SdtGAMError2[0] ;
            if ( AV20ConnectionInfoCollection.size() > 0 )
            {
               GXv_objcol_SdtGAMError2[0] = AV22Errors ;
               AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnection(((genexus.security.api.genexussecurity.SdtGAMConnectionInfo)AV20ConnectionInfoCollection.elementAt(-1+1)).getgxTv_SdtGAMConnectionInfo_Name(), GXv_objcol_SdtGAMError2) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
               AV22Errors = GXv_objcol_SdtGAMError2[0] ;
            }
         }
      }
      if ( AV26isConnectionOK )
      {
         AV24GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         if ( ! (0==AV24GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
         {
            GXv_objcol_SdtGAMError2[0] = AV22Errors ;
            AV26isConnectionOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setconnectionbyrepositoryid(AV24GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid(), GXv_objcol_SdtGAMError2) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26isConnectionOK", AV26isConnectionOK);
            AV22Errors = GXv_objcol_SdtGAMError2[0] ;
            AV24GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         }
         lblCurrentrepository_Caption = httpContext.getMessage( "Repository: ", "")+AV24GAMRepository.getgxTv_SdtGAMRepository_Name() ;
         httpContext.ajax_rsp_assign_prop("", false, lblCurrentrepository_Internalname, "Caption", lblCurrentrepository_Caption, true);
         lblCurrentrepository_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblCurrentrepository_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblCurrentrepository_Visible), 5, 0), true);
      }
   }

   public void S132( )
   {
      /* 'DISPLAYCHECKBOX' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24GAMRepository.getgxTv_SdtGAMRepository_Userremembermetype(), "Login") == 0 )
      {
         chkavKeepmeloggedin.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV24GAMRepository.getgxTv_SdtGAMRepository_Userremembermetype(), "Auth") == 0 )
      {
         chkavKeepmeloggedin.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
      else if ( GXutil.strcmp(AV24GAMRepository.getgxTv_SdtGAMRepository_Userremembermetype(), "Both") == 0 )
      {
         chkavKeepmeloggedin.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
         chkavRememberme.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
      }
      else
      {
         chkavRememberme.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "Visible", GXutil.ltrimstr( chkavRememberme.getVisible(), 5, 0), true);
         chkavKeepmeloggedin.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "Visible", GXutil.ltrimstr( chkavKeepmeloggedin.getVisible(), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'VALIDLOGONTOOTP' Routine */
      returnInSub = false ;
      if ( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Needusername() && ! AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Needuserpassword() )
      {
         AV27isModeOTP = true ;
         edtavUserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         if ( AV17AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Istotp() )
         {
            bttLogin_Caption = "NEXT" ;
            httpContext.ajax_rsp_assign_prop("", false, bttLogin_Internalname, "Caption", bttLogin_Caption, true);
         }
         else
         {
            bttLogin_Caption = "SEND ME A CODE" ;
            httpContext.ajax_rsp_assign_prop("", false, bttLogin_Internalname, "Caption", bttLogin_Caption, true);
         }
         lblTbforgotpwd_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbforgotpwd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTbforgotpwd_Visible), 5, 0), true);
         tblTablecreateaccount_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, tblTablecreateaccount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTablecreateaccount_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV45GXV5 = 1 ;
      while ( AV45GXV5 <= AV22Errors.size() )
      {
         AV21Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV22Errors.elementAt(-1+AV45GXV5));
         if ( AV21Error.getgxTv_SdtGAMError_Code() != 13 )
         {
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV21Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV21Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         }
         AV45GXV5 = (int)(AV45GXV5+1) ;
      }
   }

   public void wb_table1_50_072( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTablecreateaccount_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablecreateaccount_Internalname, tblTablecreateaccount_Internalname, "", "Table", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Right\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Right;text-align:-moz-Right;text-align:-webkit-Right")+"\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbor_Internalname, httpContext.getMessage( "or", ""), "", "", lblTbor_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "SpecialText", 0, "", lblTbor_Visible, 1, 0, (short)(0), "HLP_GAMExampleLogin.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td data-align=\"Left\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Left;text-align:-moz-Left;text-align:-webkit-Left")+"\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbregister_Internalname, httpContext.getMessage( "create an account", ""), "", "", lblTbregister_Jsonclick, "'"+""+"'"+",false,"+"'"+"e18071_client"+"'", "", "ActionText TextLikeLink", 7, "", 1, 1, 0, (short)(0), "HLP_GAMExampleLogin.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_50_072e( true) ;
      }
      else
      {
         wb_table1_50_072e( false) ;
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
      pa072( ) ;
      ws072( ) ;
      we072( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111122698", true, true);
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
      httpContext.AddJavascriptSource("gamexamplelogin.js", "?20241211112277", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_632( )
   {
      edtavImageauthtype_Internalname = "vIMAGEAUTHTYPE_"+sGXsfl_63_idx ;
      cmbavTypeauthtype.setInternalname( "vTYPEAUTHTYPE_"+sGXsfl_63_idx );
      edtavNameauthtype_Internalname = "vNAMEAUTHTYPE_"+sGXsfl_63_idx ;
   }

   public void subsflControlProps_fel_632( )
   {
      edtavImageauthtype_Internalname = "vIMAGEAUTHTYPE_"+sGXsfl_63_fel_idx ;
      cmbavTypeauthtype.setInternalname( "vTYPEAUTHTYPE_"+sGXsfl_63_fel_idx );
      edtavNameauthtype_Internalname = "vNAMEAUTHTYPE_"+sGXsfl_63_fel_idx ;
   }

   public void sendrow_632( )
   {
      subsflControlProps_632( ) ;
      wb070( ) ;
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
         if ( ((int)((nGXsfl_63_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subGridauthtypes_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_63_idx+"\">") ;
      }
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid1table_Internalname+"_"+sGXsfl_63_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(45),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridauthtypesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"",httpContext.getMessage( "Image Auth Type", ""),"col-sm-3 Fixed30Label",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Active Bitmap Variable */
      TempTags = " " + ((edtavImageauthtype_Enabled!=0)&&(edtavImageauthtype_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 68,'',false,'',63)\"" : " ") ;
      ClassString = "Fixed30" + " " + ((GXutil.strcmp(edtavImageauthtype_gximage, "")==0) ? "" : "GX_Image_"+edtavImageauthtype_gximage+"_Class") ;
      StyleString = "" ;
      AV8ImageAuthType_IsBlob = (boolean)(((GXutil.strcmp("", AV8ImageAuthType)==0)&&(GXutil.strcmp("", AV43Imageauthtype_GXI)==0))||!(GXutil.strcmp("", AV8ImageAuthType)==0)) ;
      sImgUrl = ((GXutil.strcmp("", AV8ImageAuthType)==0) ? AV43Imageauthtype_GXI : httpContext.getResourceRelative(AV8ImageAuthType)) ;
      GridauthtypesRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavImageauthtype_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(1),"",edtavImageauthtype_Tooltiptext,Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(5),edtavImageauthtype_Jsonclick,"'"+""+"'"+",false,"+"'"+"E\\'SELECTAUTHENTICATIONTYPE\\'."+sGXsfl_63_idx+"'",StyleString,ClassString,"","","","",""+TempTags,"","",Integer.valueOf(1),Boolean.valueOf(AV8ImageAuthType_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTableauthtypeinfo_Internalname+"_"+sGXsfl_63_idx,Integer.valueOf(divTableauthtypeinfo_Visible),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridauthtypesRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridauthtypesRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavTypeauthtype.getInternalname(),httpContext.getMessage( "Type Auth Type", ""),"col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      TempTags = " " + ((cmbavTypeauthtype.getEnabled()!=0)&&(cmbavTypeauthtype.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 75,'',false,'"+sGXsfl_63_idx+"',63)\"" : " ") ;
      if ( ( cmbavTypeauthtype.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "vTYPEAUTHTYPE_" + sGXsfl_63_idx ;
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
            AV9TypeAuthType = cmbavTypeauthtype.getValidValue(AV9TypeAuthType) ;
            httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV9TypeAuthType);
         }
      }
      /* ComboBox */
      GridauthtypesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavTypeauthtype,cmbavTypeauthtype.getInternalname(),GXutil.rtrim( AV9TypeAuthType),Integer.valueOf(1),cmbavTypeauthtype.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavTypeauthtype.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavTypeauthtype.getEnabled()!=0)&&(cmbavTypeauthtype.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,75);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbavTypeauthtype.setValue( GXutil.rtrim( AV9TypeAuthType) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavTypeauthtype.getInternalname(), "Values", cmbavTypeauthtype.ToJavascriptSource(), !bGXsfl_63_Refreshing);
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
      TempTags = " " + ((edtavNameauthtype_Enabled!=0)&&(edtavNameauthtype_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 79,'',false,'"+sGXsfl_63_idx+"',63)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridauthtypesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavNameauthtype_Internalname,GXutil.rtrim( AV10NameAuthType),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavNameauthtype_Enabled!=0)&&(edtavNameauthtype_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,79);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavNameauthtype_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavNameauthtype_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(60),"chr",Integer.valueOf(1),"row",Integer.valueOf(60),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(63),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMAuthenticationTypeName","left",Boolean.valueOf(true),""});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridauthtypesRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes072( ) ;
      /* End of Columns property logic. */
      GridauthtypesContainer.AddRow(GridauthtypesRow);
      nGXsfl_63_idx = ((subGridauthtypes_Islastpage==1)&&(nGXsfl_63_idx+1>subgridauthtypes_fnc_recordsperpage( )) ? 1 : nGXsfl_63_idx+1) ;
      sGXsfl_63_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_63_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_632( ) ;
      /* End function sendrow_632 */
   }

   public void startgridcontrol63( )
   {
      if ( GridauthtypesContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridauthtypesContainer"+"DivS\" data-gxgridid=\"63\">") ;
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
         GridauthtypesColumn.AddObjectProperty("Value", httpContext.convertURL( AV8ImageAuthType));
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
         GridauthtypesColumn.AddObjectProperty("Value", GXutil.rtrim( AV9TypeAuthType));
         GridauthtypesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavTypeauthtype.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesContainer.AddColumnProperties(GridauthtypesColumn);
         GridauthtypesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridauthtypesColumn.AddObjectProperty("Value", GXutil.rtrim( AV10NameAuthType));
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
      lblCurrentrepository_Internalname = "CURRENTREPOSITORY" ;
      cmbavLogonto.setInternalname( "vLOGONTO" );
      edtavUsername_Internalname = "vUSERNAME" ;
      edtavUserpassword_Internalname = "vUSERPASSWORD" ;
      chkavKeepmeloggedin.setInternalname( "vKEEPMELOGGEDIN" );
      chkavRememberme.setInternalname( "vREMEMBERME" );
      bttLogin_Internalname = "LOGIN" ;
      lblTbforgotpwd_Internalname = "TBFORGOTPWD" ;
      lblTbor_Internalname = "TBOR" ;
      lblTbregister_Internalname = "TBREGISTER" ;
      tblTablecreateaccount_Internalname = "TABLECREATEACCOUNT" ;
      lblTbexternalauthentication_Internalname = "TBEXTERNALAUTHENTICATION" ;
      edtavImageauthtype_Internalname = "vIMAGEAUTHTYPE" ;
      cmbavTypeauthtype.setInternalname( "vTYPEAUTHTYPE" );
      edtavNameauthtype_Internalname = "vNAMEAUTHTYPE" ;
      divTableauthtypeinfo_Internalname = "TABLEAUTHTYPEINFO" ;
      divGrid1table_Internalname = "GRID1TABLE" ;
      divTablebuttons_Internalname = "TABLEBUTTONS" ;
      divTablelogin_Internalname = "TABLELOGIN" ;
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
      lblTbor_Visible = 1 ;
      tblTablecreateaccount_Visible = 1 ;
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
      lblCurrentrepository_Caption = httpContext.getMessage( "Text Block", "") ;
      lblCurrentrepository_Visible = 1 ;
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
         AV11LogOnTo = cmbavLogonto.getValidValue(AV11LogOnTo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11LogOnTo", AV11LogOnTo);
      }
      chkavKeepmeloggedin.setName( "vKEEPMELOGGEDIN" );
      chkavKeepmeloggedin.setWebtags( "" );
      chkavKeepmeloggedin.setCaption( httpContext.getMessage( "Keep me logged in", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavKeepmeloggedin.getInternalname(), "TitleCaption", chkavKeepmeloggedin.getCaption(), true);
      chkavKeepmeloggedin.setCheckedValue( "false" );
      AV14KeepMeLoggedIn = GXutil.strtobool( GXutil.booltostr( AV14KeepMeLoggedIn)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14KeepMeLoggedIn", AV14KeepMeLoggedIn);
      chkavRememberme.setName( "vREMEMBERME" );
      chkavRememberme.setWebtags( "" );
      chkavRememberme.setCaption( httpContext.getMessage( "Remember Me", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRememberme.getInternalname(), "TitleCaption", chkavRememberme.getCaption(), true);
      chkavRememberme.setCheckedValue( "false" );
      AV15RememberMe = GXutil.strtobool( GXutil.booltostr( AV15RememberMe)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15RememberMe", AV15RememberMe);
      GXCCtl = "vTYPEAUTHTYPE_" + sGXsfl_63_idx ;
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
         AV9TypeAuthType = cmbavTypeauthtype.getValidValue(AV9TypeAuthType) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavTypeauthtype.getInternalname(), AV9TypeAuthType);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDAUTHTYPES_nFirstRecordOnPage'},{av:'GRIDAUTHTYPES_nEOF'},{av:'AV14KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV15RememberMe',fld:'vREMEMBERME',pic:''},{av:'AV30Language',fld:'vLANGUAGE',pic:'',hsh:true},{av:'AV19AuxUserName',fld:'vAUXUSERNAME',pic:'',hsh:true},{av:'AV37UserRememberMe',fld:'vUSERREMEMBERME',pic:'Z9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'subGridauthtypes_Visible',ctrl:'GRIDAUTHTYPES',prop:'Visible'},{av:'divTableauthtypeinfo_Visible',ctrl:'TABLEAUTHTYPEINFO',prop:'Visible'},{av:'AV13UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'cmbavLogonto'},{av:'AV11LogOnTo',fld:'vLOGONTO',pic:''},{av:'AV12UserName',fld:'vUSERNAME',pic:''},{av:'AV15RememberMe',fld:'vREMEMBERME',pic:''},{av:'chkavKeepmeloggedin.getVisible()',ctrl:'vKEEPMELOGGEDIN',prop:'Visible'},{av:'chkavRememberme.getVisible()',ctrl:'vREMEMBERME',prop:'Visible'},{av:'edtavUserpassword_Visible',ctrl:'vUSERPASSWORD',prop:'Visible'},{ctrl:'LOGIN',prop:'Caption'},{av:'lblTbforgotpwd_Visible',ctrl:'TBFORGOTPWD',prop:'Visible'},{av:'tblTablecreateaccount_Visible',ctrl:'TABLECREATEACCOUNT',prop:'Visible'}]}");
      setEventMetadata("GRIDAUTHTYPES.LOAD","{handler:'e16072',iparms:[{av:'divTablebuttons_Visible',ctrl:'TABLEBUTTONS',prop:'Visible'}]");
      setEventMetadata("GRIDAUTHTYPES.LOAD",",oparms:[{av:'AV8ImageAuthType',fld:'vIMAGEAUTHTYPE',pic:''},{av:'cmbavTypeauthtype'},{av:'AV9TypeAuthType',fld:'vTYPEAUTHTYPE',pic:''},{av:'AV10NameAuthType',fld:'vNAMEAUTHTYPE',pic:'',hsh:true},{av:'edtavImageauthtype_Tooltiptext',ctrl:'vIMAGEAUTHTYPE',prop:'Tooltiptext'},{av:'divTablebuttons_Visible',ctrl:'TABLEBUTTONS',prop:'Visible'}]}");
      setEventMetadata("VLOGONTO.CLICK","{handler:'e12072',iparms:[{av:'AV30Language',fld:'vLANGUAGE',pic:'',hsh:true},{av:'cmbavLogonto'},{av:'AV11LogOnTo',fld:'vLOGONTO',pic:''}]");
      setEventMetadata("VLOGONTO.CLICK",",oparms:[{av:'edtavUserpassword_Visible',ctrl:'vUSERPASSWORD',prop:'Visible'},{av:'edtavUserpassword_Invitemessage',ctrl:'vUSERPASSWORD',prop:'Invitemessage'},{ctrl:'LOGIN',prop:'Caption'},{av:'lblTbforgotpwd_Visible',ctrl:'TBFORGOTPWD',prop:'Visible'},{av:'lblTbor_Visible',ctrl:'TBOR',prop:'Visible'},{av:'tblTablecreateaccount_Visible',ctrl:'TABLECREATEACCOUNT',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e13072',iparms:[{av:'AV14KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV15RememberMe',fld:'vREMEMBERME',pic:''},{av:'cmbavLogonto'},{av:'AV11LogOnTo',fld:'vLOGONTO',pic:''},{av:'AV12UserName',fld:'vUSERNAME',pic:''},{av:'AV13UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'AV25IDP_State',fld:'vIDP_STATE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV25IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV13UserPassword',fld:'vUSERPASSWORD',pic:''}]}");
      setEventMetadata("'FORGOTPASSWORD'","{handler:'e11071',iparms:[{av:'AV25IDP_State',fld:'vIDP_STATE',pic:''}]");
      setEventMetadata("'FORGOTPASSWORD'",",oparms:[{av:'AV25IDP_State',fld:'vIDP_STATE',pic:''}]}");
      setEventMetadata("'REGISTER'","{handler:'e18071',iparms:[]");
      setEventMetadata("'REGISTER'",",oparms:[]}");
      setEventMetadata("'SELECTAUTHENTICATIONTYPE'","{handler:'e17072',iparms:[{av:'AV14KeepMeLoggedIn',fld:'vKEEPMELOGGEDIN',pic:''},{av:'AV15RememberMe',fld:'vREMEMBERME',pic:''},{av:'AV10NameAuthType',fld:'vNAMEAUTHTYPE',pic:'',hsh:true},{av:'AV12UserName',fld:'vUSERNAME',pic:''},{av:'AV13UserPassword',fld:'vUSERPASSWORD',pic:''}]");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV30Language = "" ;
      AV19AuxUserName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV25IDP_State = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTextblock1_Jsonclick = "" ;
      lblCurrentrepository_Jsonclick = "" ;
      TempTags = "" ;
      AV11LogOnTo = "" ;
      AV12UserName = "" ;
      AV13UserPassword = "" ;
      bttLogin_Jsonclick = "" ;
      lblTbforgotpwd_Jsonclick = "" ;
      lblTbexternalauthentication_Jsonclick = "" ;
      GridauthtypesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8ImageAuthType = "" ;
      AV43Imageauthtype_GXI = "" ;
      AV9TypeAuthType = "" ;
      AV10NameAuthType = "" ;
      AV34RepositoryGUID = "" ;
      AV22Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV20ConnectionInfoCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMConnectionInfo>(genexus.security.api.genexussecurity.SdtGAMConnectionInfo.class, "GAMConnectionInfo", "http://tempuri.org/", remoteHandle);
      AV23ErrorsLogin = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV35Session = new genexus.security.api.genexussecurity.SdtGAMSession(remoteHandle, context);
      GXv_SdtGAMSession3 = new genexus.security.api.genexussecurity.SdtGAMSession[1] ;
      AV7URL = "" ;
      AV18AuthenticationTypes = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple>(genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple.class, "GAMAuthenticationTypeSimple", "http://tempuri.org/", remoteHandle);
      AV17AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple(remoteHandle, context);
      GXv_char1 = new String[1] ;
      GXv_int5 = new byte[1] ;
      AV24GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      GridauthtypesRow = new com.genexus.webpanels.GXWebRow();
      AV16AdditionalParameter = new genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters(remoteHandle, context);
      GXv_char4 = new String[1] ;
      GXv_objcol_SdtGAMError2 = new GXExternalCollection[1] ;
      AV21Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      lblTbor_Jsonclick = "" ;
      lblTbregister_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridauthtypes_Linesclass = "" ;
      sImgUrl = "" ;
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
   private byte AV37UserRememberMe ;
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
   private int nRC_GXsfl_63 ;
   private int nGXsfl_63_idx=1 ;
   private int lblCurrentrepository_Visible ;
   private int edtavUsername_Enabled ;
   private int edtavUserpassword_Visible ;
   private int edtavUserpassword_Enabled ;
   private int lblTbforgotpwd_Visible ;
   private int subGridauthtypes_Visible ;
   private int subGridauthtypes_Islastpage ;
   private int edtavNameauthtype_Enabled ;
   private int divTableauthtypeinfo_Visible ;
   private int AV40GXV1 ;
   private int AV41GXV2 ;
   private int AV42GXV3 ;
   private int AV44GXV4 ;
   private int lblTbor_Visible ;
   private int tblTablecreateaccount_Visible ;
   private int AV45GXV5 ;
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
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_63_idx="0001" ;
   private String AV30Language ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV25IDP_State ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablelogin_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String lblCurrentrepository_Internalname ;
   private String lblCurrentrepository_Caption ;
   private String lblCurrentrepository_Jsonclick ;
   private String TempTags ;
   private String AV11LogOnTo ;
   private String edtavUsername_Internalname ;
   private String edtavUsername_Jsonclick ;
   private String edtavUserpassword_Internalname ;
   private String AV13UserPassword ;
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
   private String AV9TypeAuthType ;
   private String AV10NameAuthType ;
   private String edtavNameauthtype_Internalname ;
   private String AV34RepositoryGUID ;
   private String divTableauthtypeinfo_Internalname ;
   private String GXv_char1[] ;
   private String edtavImageauthtype_gximage ;
   private String edtavImageauthtype_Tooltiptext ;
   private String lblTbor_Internalname ;
   private String GXv_char4[] ;
   private String tblTablecreateaccount_Internalname ;
   private String lblTbor_Jsonclick ;
   private String lblTbregister_Internalname ;
   private String lblTbregister_Jsonclick ;
   private String sGXsfl_63_fel_idx="0001" ;
   private String subGridauthtypes_Class ;
   private String subGridauthtypes_Linesclass ;
   private String divGrid1table_Internalname ;
   private String sImgUrl ;
   private String edtavImageauthtype_Jsonclick ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavNameauthtype_Jsonclick ;
   private String subGridauthtypes_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14KeepMeLoggedIn ;
   private boolean AV15RememberMe ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_63_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV26isConnectionOK ;
   private boolean Cond_result ;
   private boolean gx_refresh_fired ;
   private boolean AV29isRedirect ;
   private boolean AV36SessionValid ;
   private boolean AV28isOK ;
   private boolean AV27isModeOTP ;
   private boolean AV32LoginOK ;
   private boolean AV8ImageAuthType_IsBlob ;
   private String AV19AuxUserName ;
   private String AV12UserName ;
   private String AV43Imageauthtype_GXI ;
   private String AV7URL ;
   private String AV8ImageAuthType ;
   private com.genexus.webpanels.GXWebGrid GridauthtypesContainer ;
   private com.genexus.webpanels.GXWebRow GridauthtypesRow ;
   private com.genexus.webpanels.GXWebColumn GridauthtypesColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters AV16AdditionalParameter ;
   private HTMLChoice cmbavLogonto ;
   private ICheckbox chkavKeepmeloggedin ;
   private ICheckbox chkavRememberme ;
   private HTMLChoice cmbavTypeauthtype ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple> AV18AuthenticationTypes ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMConnectionInfo> AV20ConnectionInfoCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV22Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV23ErrorsLogin ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError2[] ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple AV17AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMError AV21Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV24GAMRepository ;
   private genexus.security.api.genexussecurity.SdtGAMSession AV35Session ;
   private genexus.security.api.genexussecurity.SdtGAMSession GXv_SdtGAMSession3[] ;
}

