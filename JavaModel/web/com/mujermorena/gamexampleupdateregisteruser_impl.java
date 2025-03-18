package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamexampleupdateregisteruser_impl extends GXWebPanel
{
   public gamexampleupdateregisteruser_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamexampleupdateregisteruser_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamexampleupdateregisteruser_impl.class ));
   }

   public gamexampleupdateregisteruser_impl( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavGender = new HTMLChoice();
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
            AV23IDP_State = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23IDP_State", AV23IDP_State);
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23IDP_State, ""))));
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
         pa1W2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws1W2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we1W2( ) ;
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
      httpContext.writeValue( httpContext.getMessage( "Update register user", "")) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamexampleupdateregisteruser", new String[] {GXutil.URLEncode(GXutil.rtrim(AV23IDP_State))}, new String[] {"IDP_State"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23IDP_State, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV23IDP_State));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23IDP_State, ""))));
   }

   public void renderHtmlCloseForm1W2( )
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
      return "GAMExampleUpdateRegisterUser" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Update register user", "") ;
   }

   public void wb1W0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-8 col-lg-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-md-10 col-md-offset-1 col-lg-11", "Center", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-8 col-lg-offset-2", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTbtitle_Internalname, httpContext.getMessage( "UPDATE REGISTRATION", ""), "", "", lblTbtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "BigTitle", 0, "", 1, 1, 0, (short)(0), "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "USERNAME", ""), "col-sm-3 RegistrationAttributeLabel RequiredAttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, AV18Name, GXutil.rtrim( localUtil.format( AV18Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "RegistrationAttribute RequiredAttribute", "", "", "", "", 1, edtavName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmail_Internalname, httpContext.getMessage( "EMAIL", ""), "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmail_Internalname, AV8EMail, GXutil.rtrim( localUtil.format( AV8EMail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmail_Jsonclick, 0, edtavEmail_Class, "", "", "", "", 1, edtavEmail_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEMail", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFirstname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFirstname_Internalname, httpContext.getMessage( "FIRST NAME", ""), "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFirstname_Internalname, GXutil.rtrim( AV11FirstName), GXutil.rtrim( localUtil.format( AV11FirstName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFirstname_Jsonclick, 0, edtavFirstname_Class, "", "", "", "", 1, edtavFirstname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLastname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavLastname_Internalname, httpContext.getMessage( "LAST NAME", ""), "col-sm-3 RegistrationAttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavLastname_Internalname, GXutil.rtrim( AV15LastName), GXutil.rtrim( localUtil.format( AV15LastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLastname_Jsonclick, 0, edtavLastname_Class, "", "", "", "", 1, edtavLastname_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavBirthday_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavBirthday_Internalname, httpContext.getMessage( "BIRTHDAY", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavBirthday_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavBirthday_Internalname, localUtil.format(AV5Birthday, "99/99/9999"), localUtil.format( AV5Birthday, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBirthday_Jsonclick, 0, edtavBirthday_Class, "", "", "", "", 1, edtavBirthday_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDate", "right", false, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavBirthday_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavBirthday_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMExampleUpdateRegisterUser.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavGender.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavGender.getInternalname(), httpContext.getMessage( "GENDER", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavGender, cmbavGender.getInternalname(), GXutil.rtrim( AV12Gender), 1, cmbavGender.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavGender.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", cmbavGender.getThemeClass(), "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "", true, (byte)(0), "HLP_GAMExampleUpdateRegisterUser.htm");
         cmbavGender.setValue( GXutil.rtrim( AV12Gender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Values", cmbavGender.ToJavascriptSource(), true);
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         ClassString = "BtnCancel" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttButton1_Internalname, "", httpContext.getMessage( "Go to Login", ""), bttButton1_Jsonclick, 5, httpContext.getMessage( "Go to Login", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'RETURNTOLOGIN\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
         ClassString = "BtnEnter" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttButton2_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttButton2_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMExampleUpdateRegisterUser.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1W2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Update register user", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1W0( ) ;
   }

   public void ws1W2( )
   {
      start1W2( ) ;
      evt1W2( ) ;
   }

   public void evt1W2( )
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
                        e111W2 ();
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
                              e121W2 ();
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else if ( GXutil.strcmp(sEvt, "'RETURNTOLOGIN'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'ReturnToLogin' */
                        e131W2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e141W2 ();
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

   public void we1W2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm1W2( ) ;
         }
      }
   }

   public void pa1W2( )
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
            GX_FocusControl = edtavName_Internalname ;
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
      if ( cmbavGender.getItemCount() > 0 )
      {
         AV12Gender = cmbavGender.getValidValue(AV12Gender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12Gender", AV12Gender);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavGender.setValue( GXutil.rtrim( AV12Gender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Values", cmbavGender.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf1W2( ) ;
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

   public void rf1W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e141W2 ();
         wb1W0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1W2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vIDP_STATE", GXutil.rtrim( AV23IDP_State));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23IDP_State, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV18Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Name", AV18Name);
         AV8EMail = httpContext.cgiGet( edtavEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EMail", AV8EMail);
         AV11FirstName = httpContext.cgiGet( edtavFirstname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11FirstName", AV11FirstName);
         AV15LastName = httpContext.cgiGet( edtavLastname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15LastName", AV15LastName);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavBirthday_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vBIRTHDAY");
            GX_FocusControl = edtavBirthday_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV5Birthday = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5Birthday", localUtil.format(AV5Birthday, "99/99/9999"));
         }
         else
         {
            AV5Birthday = localUtil.ctod( httpContext.cgiGet( edtavBirthday_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5Birthday", localUtil.format(AV5Birthday, "99/99/9999"));
         }
         cmbavGender.setValue( httpContext.cgiGet( cmbavGender.getInternalname()) );
         AV12Gender = httpContext.cgiGet( cmbavGender.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12Gender", AV12Gender);
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
      e111W2 ();
      if (returnInSub) return;
   }

   public void e111W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'MARKREQUIEREDUSERDATA' */
      S112 ();
      if (returnInSub) return;
      GXv_objcol_SdtGAMError1[0] = AV10Errors ;
      AV22User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getuserbykeytocompleteuserdata(GXv_objcol_SdtGAMError1);
      AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV10Errors.size() > 0 )
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S122 ();
         if (returnInSub) return;
      }
      else
      {
         AV10Errors = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S122 ();
         if (returnInSub) return;
         AV18Name = AV22User.getgxTv_SdtGAMUser_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Name", AV18Name);
         AV8EMail = AV22User.getgxTv_SdtGAMUser_Email() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EMail", AV8EMail);
         AV11FirstName = AV22User.getgxTv_SdtGAMUser_Firstname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11FirstName", AV11FirstName);
         AV15LastName = AV22User.getgxTv_SdtGAMUser_Lastname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15LastName", AV15LastName);
         AV5Birthday = AV22User.getgxTv_SdtGAMUser_Birthday() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5Birthday", localUtil.format(AV5Birthday, "99/99/9999"));
         AV12Gender = AV22User.getgxTv_SdtGAMUser_Gender() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12Gender", AV12Gender);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e121W2 ();
      if (returnInSub) return;
   }

   public void e121W2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError1[0] = AV10Errors ;
      AV22User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getuserbykeytocompleteuserdata(GXv_objcol_SdtGAMError1);
      AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      AV22User.setgxTv_SdtGAMUser_Name( AV18Name );
      AV22User.setgxTv_SdtGAMUser_Email( AV8EMail );
      AV22User.setgxTv_SdtGAMUser_Firstname( AV11FirstName );
      AV22User.setgxTv_SdtGAMUser_Lastname( AV15LastName );
      AV22User.setgxTv_SdtGAMUser_Birthday( AV5Birthday );
      AV22User.setgxTv_SdtGAMUser_Gender( AV12Gender );
      GXv_objcol_SdtGAMError1[0] = AV10Errors ;
      AV14isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).updateuserbykeytocompleteuserdata(AV22User, GXv_objcol_SdtGAMError1) ;
      AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( AV14isOK )
      {
         if ( AV10Errors.size() > 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "Your data has been updated successfully!.", ""));
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S122 ();
            if (returnInSub) return;
         }
         else
         {
            if ( new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isremoteauthentication(AV23IDP_State) )
            {
               new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).redirecttoremoteauthentication(AV23IDP_State) ;
            }
            else
            {
               AV21URL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrorsurl() ;
               if ( (GXutil.strcmp("", AV21URL)==0) )
               {
                  callWebObject(formatLink("com.mujermorena.gamhome", new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(1) ;
               }
               else
               {
                  callWebObject(formatLink(AV21URL, new String[] {}, new String[] {}) );
                  httpContext.wjLocDisableFrm = (byte)(0) ;
               }
            }
         }
      }
      else
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S122 ();
         if (returnInSub) return;
      }
   }

   public void S122( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV26GXV1 = 1 ;
      while ( AV26GXV1 <= AV10Errors.size() )
      {
         AV9Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV10Errors.elementAt(-1+AV26GXV1));
         httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV9Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV9Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         AV26GXV1 = (int)(AV26GXV1+1) ;
      }
   }

   public void S112( )
   {
      /* 'MARKREQUIEREDUSERDATA' Routine */
      returnInSub = false ;
      AV19Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredemail() )
      {
         edtavEmail_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmail_Internalname, "Class", edtavEmail_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredfirstname() )
      {
         edtavFirstname_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFirstname_Internalname, "Class", edtavFirstname_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredlastname() )
      {
         edtavLastname_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLastname_Internalname, "Class", edtavLastname_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredbirthday() )
      {
         edtavBirthday_Class = "RequiredAttribute"+" "+"RegistrationAttribute" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBirthday_Internalname, "Class", edtavBirthday_Class, true);
      }
      if ( AV19Repository.getgxTv_SdtGAMRepository_Requiredgender() )
      {
         cmbavGender.setThemeClass( "RequiredAttribute"+" "+"RegistrationAttribute" );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Class", cmbavGender.getThemeClass(), true);
      }
   }

   public void e131W2( )
   {
      /* 'ReturnToLogin' Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError1[0] = AV10Errors ;
      AV14isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).logout(GXv_objcol_SdtGAMError1) ;
      AV10Errors = GXv_objcol_SdtGAMError1[0] ;
      callWebObject(formatLink("com.mujermorena.gamexamplelogin", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   protected void nextLoad( )
   {
   }

   protected void e141W2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV23IDP_State = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23IDP_State", AV23IDP_State);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDP_STATE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23IDP_State, ""))));
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
      pa1W2( ) ;
      ws1W2( ) ;
      we1W2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111162651", true, true);
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
      httpContext.AddJavascriptSource("gamexampleupdateregisteruser.js", "?202412111162659", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      divTable3_Internalname = "TABLE3" ;
      lblTbtitle_Internalname = "TBTITLE" ;
      edtavName_Internalname = "vNAME" ;
      edtavEmail_Internalname = "vEMAIL" ;
      edtavFirstname_Internalname = "vFIRSTNAME" ;
      edtavLastname_Internalname = "vLASTNAME" ;
      edtavBirthday_Internalname = "vBIRTHDAY" ;
      cmbavGender.setInternalname( "vGENDER" );
      divTable2_Internalname = "TABLE2" ;
      bttButton1_Internalname = "BUTTON1" ;
      bttButton2_Internalname = "BUTTON2" ;
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
      cmbavGender.setJsonclick( "" );
      cmbavGender.setEnabled( 1 );
      cmbavGender.setThemeClass( "Attribute" );
      edtavBirthday_Jsonclick = "" ;
      edtavBirthday_Class = "Attribute" ;
      edtavBirthday_Enabled = 1 ;
      edtavLastname_Jsonclick = "" ;
      edtavLastname_Class = "RegistrationAttribute" ;
      edtavLastname_Enabled = 1 ;
      edtavFirstname_Jsonclick = "" ;
      edtavFirstname_Class = "RegistrationAttribute" ;
      edtavFirstname_Enabled = 1 ;
      edtavEmail_Jsonclick = "" ;
      edtavEmail_Class = "RegistrationAttribute" ;
      edtavEmail_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavGender.setName( "vGENDER" );
      cmbavGender.setWebtags( "" );
      cmbavGender.addItem("N", httpContext.getMessage( "Not Specified", ""), (short)(0));
      cmbavGender.addItem("F", httpContext.getMessage( "Female", ""), (short)(0));
      cmbavGender.addItem("M", httpContext.getMessage( "Male", ""), (short)(0));
      if ( cmbavGender.getItemCount() > 0 )
      {
         AV12Gender = cmbavGender.getValidValue(AV12Gender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12Gender", AV12Gender);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV23IDP_State',fld:'vIDP_STATE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e121W2',iparms:[{av:'AV18Name',fld:'vNAME',pic:''},{av:'AV8EMail',fld:'vEMAIL',pic:''},{av:'AV11FirstName',fld:'vFIRSTNAME',pic:''},{av:'AV15LastName',fld:'vLASTNAME',pic:''},{av:'AV5Birthday',fld:'vBIRTHDAY',pic:''},{av:'cmbavGender'},{av:'AV12Gender',fld:'vGENDER',pic:''},{av:'AV23IDP_State',fld:'vIDP_STATE',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("'RETURNTOLOGIN'","{handler:'e131W2',iparms:[]");
      setEventMetadata("'RETURNTOLOGIN'",",oparms:[]}");
      setEventMetadata("VALIDV_BIRTHDAY","{handler:'validv_Birthday',iparms:[]");
      setEventMetadata("VALIDV_BIRTHDAY",",oparms:[]}");
      setEventMetadata("VALIDV_GENDER","{handler:'validv_Gender',iparms:[]");
      setEventMetadata("VALIDV_GENDER",",oparms:[]}");
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
      wcpOAV23IDP_State = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV23IDP_State = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTbtitle_Jsonclick = "" ;
      TempTags = "" ;
      AV18Name = "" ;
      AV8EMail = "" ;
      AV11FirstName = "" ;
      AV15LastName = "" ;
      AV5Birthday = GXutil.nullDate() ;
      AV12Gender = "" ;
      bttButton1_Jsonclick = "" ;
      bttButton2_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV22User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV10Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV21URL = "" ;
      AV9Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      AV19Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavName_Enabled ;
   private int edtavEmail_Enabled ;
   private int edtavFirstname_Enabled ;
   private int edtavLastname_Enabled ;
   private int edtavBirthday_Enabled ;
   private int AV26GXV1 ;
   private int idxLst ;
   private String wcpOAV23IDP_State ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV23IDP_State ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTable2_Internalname ;
   private String lblTbtitle_Internalname ;
   private String lblTbtitle_Jsonclick ;
   private String edtavName_Internalname ;
   private String TempTags ;
   private String edtavName_Jsonclick ;
   private String edtavEmail_Internalname ;
   private String edtavEmail_Jsonclick ;
   private String edtavEmail_Class ;
   private String edtavFirstname_Internalname ;
   private String AV11FirstName ;
   private String edtavFirstname_Jsonclick ;
   private String edtavFirstname_Class ;
   private String edtavLastname_Internalname ;
   private String AV15LastName ;
   private String edtavLastname_Jsonclick ;
   private String edtavLastname_Class ;
   private String edtavBirthday_Internalname ;
   private String edtavBirthday_Jsonclick ;
   private String edtavBirthday_Class ;
   private String AV12Gender ;
   private String bttButton1_Internalname ;
   private String bttButton1_Jsonclick ;
   private String bttButton2_Internalname ;
   private String bttButton2_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private java.util.Date AV5Birthday ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV14isOK ;
   private String AV18Name ;
   private String AV8EMail ;
   private String AV21URL ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private HTMLChoice cmbavGender ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV10Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMError AV9Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV19Repository ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV22User ;
}

