package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamexampleotpauthentication_impl extends GXWebPanel
{
   public gamexampleotpauthentication_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamexampleotpauthentication_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamexampleotpauthentication_impl.class ));
   }

   public gamexampleotpauthentication_impl( int remoteHandle ,
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
            AV7IDP_State = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7IDP_State", AV7IDP_State);
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
         pa1X2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws1X2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we1X2( ) ;
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
      httpContext.writeValue( httpContext.getMessage( "GAM_Auth OTP", "")) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamexampleotpauthentication", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7IDP_State))}, new String[] {"IDP_State"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUTHENTICATIONTYPENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13AuthenticationTypeName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSETWOFACTORAUTHENTICATION", getSecureSignedToken( "", AV17UseTwoFactorAuthentication));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"GAMExampleOTPAuthentication");
      forbiddenHiddens.add("UserName", GXutil.rtrim( localUtil.format( AV11UserName, "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("gamexampleotpauthentication:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUTHENTICATIONTYPENAME", GXutil.rtrim( AV13AuthenticationTypeName));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUTHENTICATIONTYPENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13AuthenticationTypeName, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vUSETWOFACTORAUTHENTICATION", AV17UseTwoFactorAuthentication);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSETWOFACTORAUTHENTICATION", getSecureSignedToken( "", AV17UseTwoFactorAuthentication));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV7IDP_State));
   }

   public void renderHtmlCloseForm1X2( )
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
      return "GAMExampleOTPAuthentication" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "GAM_Auth OTP", "") ;
   }

   public void wb1X0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "LoginContainer", "left", "top", "", "", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableLogin", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbtitle_Internalname, httpContext.getMessage( "LOGIN", ""), "", "", lblTbtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleOTPAuthentication.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 50, "px", "col-xs-8 col-xs-offset-2", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, httpContext.getMessage( "User Name", ""), "col-sm-3 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 19,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, AV11UserName, GXutil.rtrim( localUtil.format( AV11UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,19);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUsername_Jsonclick, 0, "LoginAttribute", "", "", "", "", 1, edtavUsername_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMExampleOTPAuthentication.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-8 col-xs-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserpassword_Internalname, httpContext.getMessage( "User Password", ""), "col-sm-3 LoginAttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserpassword_Internalname, GXutil.rtrim( AV12UserPassword), GXutil.rtrim( localUtil.format( AV12UserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,23);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", httpContext.getMessage( "Code", ""), edtavUserpassword_Jsonclick, 0, "LoginAttribute", "", "", "", "", edtavUserpassword_Visible, edtavUserpassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMExampleOTPAuthentication.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-xs-offset-3 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         ClassString = "BtnLogin" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttEnter_Internalname, "", httpContext.getMessage( "VALIDATE CODE", ""), bttEnter_Jsonclick, 5, httpContext.getMessage( "VALIDATE CODE", ""), "", StyleString, ClassString, bttEnter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleOTPAuthentication.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "Bottom", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableButtons", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, httpContext.getMessage( "BACK TO LOGIN", ""), "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'LOGIN\\'."+"'", "", "PagingText TextLikeLink", 5, "", 1, 1, 0, (short)(0), "HLP_GAMExampleOTPAuthentication.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "Bottom", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1X2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "GAM_Auth OTP", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1X0( ) ;
   }

   public void ws1X2( )
   {
      start1X2( ) ;
      evt1X2( ) ;
   }

   public void evt1X2( )
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
                     else if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e111X2 ();
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
                              e121X2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "'LOGIN'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'Login' */
                        e131X2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e141X2 ();
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
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we1X2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm1X2( ) ;
         }
      }
   }

   public void pa1X2( )
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
            GX_FocusControl = edtavUsername_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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
      rf1X2( ) ;
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
      edtavUsername_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
   }

   public void rf1X2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e141X2 ();
         wb1X0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1X2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUTHENTICATIONTYPENAME", GXutil.rtrim( AV13AuthenticationTypeName));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAUTHENTICATIONTYPENAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13AuthenticationTypeName, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vUSETWOFACTORAUTHENTICATION", AV17UseTwoFactorAuthentication);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSETWOFACTORAUTHENTICATION", getSecureSignedToken( "", AV17UseTwoFactorAuthentication));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavUsername_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup1X0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV11UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11UserName", AV11UserName);
         AV12UserPassword = httpContext.cgiGet( edtavUserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12UserPassword", AV12UserPassword);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"GAMExampleOTPAuthentication");
         AV11UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11UserName", AV11UserName);
         forbiddenHiddens.add("UserName", GXutil.rtrim( localUtil.format( AV11UserName, "")));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("gamexampleotpauthentication:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e111X2 ();
      if (returnInSub) return;
   }

   public void e111X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_char1[0] = AV13AuthenticationTypeName ;
      GXv_boolean2[0] = AV17UseTwoFactorAuthentication ;
      GXv_objcol_SdtGAMError3[0] = AV6Errors ;
      AV9User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getusertootpauthentication(GXv_char1, GXv_boolean2, GXv_objcol_SdtGAMError3);
      gamexampleotpauthentication_impl.this.AV13AuthenticationTypeName = GXv_char1[0] ;
      gamexampleotpauthentication_impl.this.AV17UseTwoFactorAuthentication = GXv_boolean2[0] ;
      AV6Errors = GXv_objcol_SdtGAMError3[0] ;
      if ( AV6Errors.size() > 0 )
      {
         edtavUserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         bttEnter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttEnter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttEnter_Visible), 5, 0), true);
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S112 ();
         if (returnInSub) return;
      }
      else
      {
         AV20GAMAuthenticationTypeOTP.load(AV13AuthenticationTypeName);
         if ( GXutil.strcmp(AV20GAMAuthenticationTypeOTP.getgxTv_SdtGAMAuthenticationTypeOTP_Otp().getgxTv_SdtGAMAuthenticationOTP_Generationtype(), "totp") != 0 )
         {
            AV6Errors = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
            AV23GXV1 = 1 ;
            while ( AV23GXV1 <= AV6Errors.size() )
            {
               AV5Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV6Errors.elementAt(-1+AV23GXV1));
               httpContext.GX_msglist.addItem(AV5Error.getgxTv_SdtGAMError_Message());
               AV23GXV1 = (int)(AV23GXV1+1) ;
            }
         }
         AV11UserName = AV9User.getgxTv_SdtGAMUser_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11UserName", AV11UserName);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e121X2 ();
      if (returnInSub) return;
   }

   public void e121X2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      GXv_char1[0] = AV13AuthenticationTypeName ;
      GXv_boolean2[0] = AV17UseTwoFactorAuthentication ;
      GXv_objcol_SdtGAMError3[0] = AV6Errors ;
      AV9User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getusertootpauthentication(GXv_char1, GXv_boolean2, GXv_objcol_SdtGAMError3);
      gamexampleotpauthentication_impl.this.AV13AuthenticationTypeName = GXv_char1[0] ;
      gamexampleotpauthentication_impl.this.AV17UseTwoFactorAuthentication = GXv_boolean2[0] ;
      AV6Errors = GXv_objcol_SdtGAMError3[0] ;
      if ( AV6Errors.size() == 0 )
      {
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Authenticationtypename( AV13AuthenticationTypeName );
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Usetwofactorauthentication( AV17UseTwoFactorAuthentication );
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Otpstep( (byte)(2) );
         AV16AdditionalParameter.setgxTv_SdtGAMLoginAdditionalParameters_Idpstate( AV7IDP_State );
         GXv_objcol_SdtGAMError3[0] = AV6Errors ;
         AV14LoginOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).login(AV11UserName, AV12UserPassword, AV16AdditionalParameter, GXv_objcol_SdtGAMError3) ;
         AV6Errors = GXv_objcol_SdtGAMError3[0] ;
         if ( AV14LoginOK )
         {
            if ( (GXutil.strcmp("", AV7IDP_State)==0) )
            {
               AV15URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
               if ( (GXutil.strcmp("", AV15URL)==0) )
               {
                  callWebObject(formatLink("com.mujermorena.gamhome", new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(1) ;
               }
               else
               {
                  callWebObject(formatLink(AV15URL, new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(0) ;
               }
            }
         }
         else
         {
            if ( AV6Errors.size() > 0 )
            {
               if ( ((genexus.security.api.genexussecurity.SdtGAMError)AV6Errors.elementAt(-1+1)).getgxTv_SdtGAMError_Code() == 161 )
               {
                  callWebObject(formatLink("com.mujermorena.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7IDP_State))}, new String[] {"IDP_State"}) );
                  httpContext.wjLocDisableFrm = (byte)(1) ;
               }
               else
               {
                  AV12UserPassword = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV12UserPassword", AV12UserPassword);
                  /* Execute user subroutine: 'DISPLAYMESSAGES' */
                  S112 ();
                  if (returnInSub) return;
               }
            }
         }
      }
      else
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S112 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV16AdditionalParameter", AV16AdditionalParameter);
   }

   public void e131X2( )
   {
      /* 'Login' Routine */
      returnInSub = false ;
      if ( new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isremoteauthentication(AV7IDP_State) )
      {
         callWebObject(formatLink("com.mujermorena.gamremotelogin", new String[] {GXutil.URLEncode(GXutil.rtrim(AV7IDP_State))}, new String[] {"IDP_State"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.setWebReturnParms(new Object[] {AV7IDP_State});
         httpContext.setWebReturnParmsMetadata(new Object[] {"AV7IDP_State"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV24GXV2 = 1 ;
      while ( AV24GXV2 <= AV6Errors.size() )
      {
         AV5Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV6Errors.elementAt(-1+AV24GXV2));
         httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV5Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV5Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         AV24GXV2 = (int)(AV24GXV2+1) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e141X2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV7IDP_State = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7IDP_State", AV7IDP_State);
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
      pa1X2( ) ;
      ws1X2( ) ;
      we1X2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111165538", true, true);
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
      httpContext.AddJavascriptSource("gamexampleotpauthentication.js", "?202412111165549", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTbtitle_Internalname = "TBTITLE" ;
      edtavUsername_Internalname = "vUSERNAME" ;
      edtavUserpassword_Internalname = "vUSERPASSWORD" ;
      bttEnter_Internalname = "ENTER" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      divTable3_Internalname = "TABLE3" ;
      divTable1_Internalname = "TABLE1" ;
      divTable2_Internalname = "TABLE2" ;
      divMaintable_Internalname = "MAINTABLE" ;
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
      bttEnter_Visible = 1 ;
      edtavUserpassword_Jsonclick = "" ;
      edtavUserpassword_Enabled = 1 ;
      edtavUserpassword_Visible = 1 ;
      edtavUsername_Jsonclick = "" ;
      edtavUsername_Enabled = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13AuthenticationTypeName',fld:'vAUTHENTICATIONTYPENAME',pic:'',hsh:true},{av:'AV17UseTwoFactorAuthentication',fld:'vUSETWOFACTORAUTHENTICATION',pic:'',hsh:true},{av:'AV11UserName',fld:'vUSERNAME',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e121X2',iparms:[{av:'AV13AuthenticationTypeName',fld:'vAUTHENTICATIONTYPENAME',pic:'',hsh:true},{av:'AV17UseTwoFactorAuthentication',fld:'vUSETWOFACTORAUTHENTICATION',pic:'',hsh:true},{av:'AV7IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV11UserName',fld:'vUSERNAME',pic:''},{av:'AV12UserPassword',fld:'vUSERPASSWORD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7IDP_State',fld:'vIDP_STATE',pic:''},{av:'AV12UserPassword',fld:'vUSERPASSWORD',pic:''}]}");
      setEventMetadata("'LOGIN'","{handler:'e131X2',iparms:[{av:'AV7IDP_State',fld:'vIDP_STATE',pic:''}]");
      setEventMetadata("'LOGIN'",",oparms:[{av:'AV7IDP_State',fld:'vIDP_STATE',pic:''}]}");
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
      wcpOAV7IDP_State = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV7IDP_State = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV13AuthenticationTypeName = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV11UserName = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTbtitle_Jsonclick = "" ;
      TempTags = "" ;
      AV12UserPassword = "" ;
      bttEnter_Jsonclick = "" ;
      lblTextblock2_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      hsh = "" ;
      AV9User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV6Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV20GAMAuthenticationTypeOTP = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOTP(remoteHandle, context);
      AV5Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_char1 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV16AdditionalParameter = new genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters(remoteHandle, context);
      GXv_objcol_SdtGAMError3 = new GXExternalCollection[1] ;
      AV15URL = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavUsername_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavUsername_Enabled ;
   private int edtavUserpassword_Visible ;
   private int edtavUserpassword_Enabled ;
   private int bttEnter_Visible ;
   private int AV23GXV1 ;
   private int AV24GXV2 ;
   private int idxLst ;
   private String wcpOAV7IDP_State ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV7IDP_State ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String AV13AuthenticationTypeName ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable2_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTable1_Internalname ;
   private String lblTbtitle_Internalname ;
   private String lblTbtitle_Jsonclick ;
   private String edtavUsername_Internalname ;
   private String TempTags ;
   private String edtavUsername_Jsonclick ;
   private String edtavUserpassword_Internalname ;
   private String AV12UserPassword ;
   private String edtavUserpassword_Jsonclick ;
   private String bttEnter_Internalname ;
   private String bttEnter_Jsonclick ;
   private String divTable3_Internalname ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String hsh ;
   private String GXv_char1[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV17UseTwoFactorAuthentication ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean GXv_boolean2[] ;
   private boolean AV14LoginOK ;
   private String AV11UserName ;
   private String AV15URL ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private genexus.security.api.genexussecurity.SdtGAMLoginAdditionalParameters AV16AdditionalParameter ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV6Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError3[] ;
   private genexus.security.api.genexussecurity.SdtGAMError AV5Error ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV9User ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeOTP AV20GAMAuthenticationTypeOTP ;
}

