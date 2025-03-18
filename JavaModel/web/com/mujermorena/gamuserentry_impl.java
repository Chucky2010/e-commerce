package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamuserentry_impl extends GXDataArea
{
   public gamuserentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamuserentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamuserentry_impl.class ));
   }

   public gamuserentry_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavAuthenticationtypename = new HTMLChoice();
      cmbavGender = new HTMLChoice();
      chkavIsactive = UIFactory.getCheckbox(this);
      chkavDontreceiveinformation = UIFactory.getCheckbox(this);
      chkavCannotchangepassword = UIFactory.getCheckbox(this);
      chkavMustchangepassword = UIFactory.getCheckbox(this);
      chkavPasswordneverexpires = UIFactory.getCheckbox(this);
      chkavIsblocked = UIFactory.getCheckbox(this);
      cmbavSecuritypolicyid = new HTMLChoice();
      chkavIsenabledinrepository = UIFactory.getCheckbox(this);
      chkavEnabletwofactorauthentication = UIFactory.getCheckbox(this);
      chkavUser_isenabledinrepository = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
            Gx_mode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV55UserId = httpContext.GetPar( "UserId") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55UserId", AV55UserId);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55UserId, ""))));
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
      pa3C2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start3C2( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV55UserId))}, new String[] {"Gx_mode","UserId"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55UserId, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV59CheckRequiredFieldsResult);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPHOTO", AV46Photo);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAUTHTYPEID", GXutil.rtrim( AV10AuthTypeId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
         we3C2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt3C2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.mujermorena.gamuserentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV55UserId))}, new String[] {"Gx_mode","UserId"})  ;
   }

   public String getPgmname( )
   {
      return "GAMUserEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "User ", "") ;
   }

   public void wb3C0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
         ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserid_Internalname, GXutil.rtrim( AV55UserId), GXutil.rtrim( localUtil.format( AV55UserId, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUserid_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUsernamespace_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUsernamespace_Internalname, httpContext.getMessage( "WWP_GAM_Namespace", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUsernamespace_Internalname, GXutil.rtrim( AV56UserNameSpace), GXutil.rtrim( localUtil.format( AV56UserNameSpace, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUsernamespace_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavUsernamespace_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMRepositoryNameSpace", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAuthenticationtypename_cell_Internalname, 1, 0, "px", 0, "px", divAuthenticationtypename_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavAuthenticationtypename.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavAuthenticationtypename.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavAuthenticationtypename.getInternalname(), httpContext.getMessage( "WWP_GAM_AuthType", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavAuthenticationtypename, cmbavAuthenticationtypename.getInternalname(), GXutil.rtrim( AV7AuthenticationTypeName), 1, cmbavAuthenticationtypename.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavAuthenticationtypename.getVisible(), cmbavAuthenticationtypename.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "", true, (byte)(0), "HLP_GAMUserEntry.htm");
         cmbavAuthenticationtypename.setValue( GXutil.rtrim( AV7AuthenticationTypeName) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Values", cmbavAuthenticationtypename.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 RequiredDataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "WWP_GAM_UserName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, AV36Name, GXutil.rtrim( localUtil.format( AV36Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,36);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmail_cell_Internalname, 1, 0, "px", 0, "px", divEmail_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmail_Internalname, httpContext.getMessage( "WWP_GAM_Email", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmail_Internalname, AV16Email, GXutil.rtrim( localUtil.format( AV16Email, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmail_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEmail_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEMail", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPassword_cell_Internalname, 1, 0, "px", 0, "px", divPassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavPassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavPassword_Internalname, httpContext.getMessage( "WWP_GAM_Password", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPassword_Internalname, GXutil.rtrim( AV41Password), GXutil.rtrim( localUtil.format( AV41Password, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavPassword_Visible, edtavPassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPasswordconf_cell_Internalname, 1, 0, "px", 0, "px", divPasswordconf_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavPasswordconf_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPasswordconf_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavPasswordconf_Internalname, httpContext.getMessage( "WWP_GAM_ConfPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPasswordconf_Internalname, GXutil.rtrim( AV42PasswordConf), GXutil.rtrim( localUtil.format( AV42PasswordConf, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPasswordconf_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavPasswordconf_Visible, edtavPasswordconf_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divFirstname_cell_Internalname, 1, 0, "px", 0, "px", divFirstname_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFirstname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavFirstname_Internalname, httpContext.getMessage( "WWP_GAM_FirstName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFirstname_Internalname, GXutil.rtrim( AV22FirstName), GXutil.rtrim( localUtil.format( AV22FirstName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFirstname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavFirstname_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLastname_cell_Internalname, 1, 0, "px", 0, "px", divLastname_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLastname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavLastname_Internalname, httpContext.getMessage( "WWP_GAM_LastName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavLastname_Internalname, GXutil.rtrim( AV31LastName), GXutil.rtrim( localUtil.format( AV31LastName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLastname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavLastname_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavExternalid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavExternalid_Internalname, httpContext.getMessage( "WWP_GAM_ExternalId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavExternalid_Internalname, AV20ExternalId, GXutil.rtrim( localUtil.format( AV20ExternalId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavExternalid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavExternalid_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divBirthday_cell_Internalname, 1, 0, "px", 0, "px", divBirthday_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavBirthday_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavBirthday_Internalname, httpContext.getMessage( "WWP_GAM_Birthday", ""), " AttributeRealWidthDateLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavBirthday_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavBirthday_Internalname, localUtil.format(AV11Birthday, "99/99/9999"), localUtil.format( AV11Birthday, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavBirthday_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtavBirthday_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDate", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavBirthday_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavBirthday_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMUserEntry.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGender_cell_Internalname, 1, 0, "px", 0, "px", divGender_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavGender.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavGender.getInternalname(), httpContext.getMessage( "WWP_GAM_Gender", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavGender, cmbavGender.getInternalname(), GXutil.rtrim( AV24Gender), 1, cmbavGender.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavGender.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "", true, (byte)(0), "HLP_GAMUserEntry.htm");
         cmbavGender.setValue( GXutil.rtrim( AV24Gender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Values", cmbavGender.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPhone_cell_Internalname, 1, 0, "px", 0, "px", divPhone_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPhone_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavPhone_Internalname, httpContext.getMessage( "WWP_GAM_Phone", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPhone_Internalname, GXutil.rtrim( AV45Phone), GXutil.rtrim( localUtil.format( AV45Phone, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPhone_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavPhone_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMAddress", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUrlprofile_cell_Internalname, 1, 0, "px", 0, "px", divUrlprofile_cell_Class, "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtableurlprofile_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockurlprofile_Internalname, httpContext.getMessage( "WWP_GAM_URLprofile", ""), "", "", lblTextblockurlprofile_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUrlprofile_Internalname, httpContext.getMessage( "URLProfile", ""), "col-sm-3 AttributeRealWidthLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUrlprofile_Internalname, AV52URLProfile, GXutil.rtrim( localUtil.format( AV52URLProfile, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUrlprofile_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavUrlprofile_Visible, edtavUrlprofile_Enabled, 1, "text", "", 80, "chr", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
         ClassString = "Button ButtonMaterialGAM" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnurlprofilego_Internalname, "", httpContext.getMessage( "WWP_GAM_Go", ""), bttBtnurlprofilego_Jsonclick, 7, httpContext.getMessage( "WWP_GAM_Go", ""), "", StyleString, ClassString, bttBtnurlprofilego_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e113c1_client"+"'", TempTags, "", 2, "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divImage_cell_Internalname, 1, 0, "px", 0, "px", divImage_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", imgavImage_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgavImage_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "WWP_GAM_URLimage", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "AttributeRealWidth" + " " + ((GXutil.strcmp(imgavImage_gximage, "")==0) ? "" : "GX_Image_"+imgavImage_gximage+"_Class") ;
         StyleString = "" ;
         AV25Image_IsBlob = (boolean)(((GXutil.strcmp("", AV25Image)==0)&&(GXutil.strcmp("", AV66Image_GXI)==0))||!(GXutil.strcmp("", AV25Image)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV25Image)==0) ? AV66Image_GXI : httpContext.getResourceRelative(AV25Image)) ;
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgavImage_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), imgavImage_Visible, imgavImage_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV25Image_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divIsactive_cell_Internalname, 1, 0, "px", 0, "px", divIsactive_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavIsactive.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsactive.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsactive.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsactive.getInternalname(), GXutil.booltostr( AV26IsActive), "", " ", chkavIsactive.getVisible(), chkavIsactive.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_AccountIsActive", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(98, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,98);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divActivationdate_cell_Internalname, 1, 0, "px", 0, "px", divActivationdate_cell_Class, "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtableactivationdate_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockactivationdate_Internalname, httpContext.getMessage( "WWP_GAM_ActivationDate", ""), "", "", lblTextblockactivationdate_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavActivationdate_Internalname, httpContext.getMessage( "Activation Date", ""), "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavActivationdate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavActivationdate_Internalname, localUtil.ttoc( AV5ActivationDate, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( AV5ActivationDate, "99/99/9999 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,108);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavActivationdate_Jsonclick, 0, "Attribute", "", "", "", "", edtavActivationdate_Visible, edtavActivationdate_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDateTime", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavActivationdate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavActivationdate_Visible==0)||(edtavActivationdate_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMUserEntry.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
         ClassString = "Button ButtonMaterialGAM" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnsendactivationemail_Internalname, "", httpContext.getMessage( "WWP_GAM_SendActivationEmail", ""), bttBtnsendactivationemail_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_SendActivationEmail", ""), "", StyleString, ClassString, bttBtnsendactivationemail_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSENDACTIVATIONEMAIL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavDontreceiveinformation.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavDontreceiveinformation.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 115,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavDontreceiveinformation.getInternalname(), GXutil.booltostr( AV15DontReceiveInformation), "", " ", 1, chkavDontreceiveinformation.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_DontReceiveInformation", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(115, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,115);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCannotchangepassword.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavCannotchangepassword.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCannotchangepassword.getInternalname(), GXutil.booltostr( AV13CannotChangePassword), "", " ", 1, chkavCannotchangepassword.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CannotChangePassword", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(119, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,119);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavMustchangepassword.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavMustchangepassword.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavMustchangepassword.getInternalname(), GXutil.booltostr( AV35MustChangePassword), "", " ", 1, chkavMustchangepassword.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Mustchangepassword", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(124, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,124);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavPasswordneverexpires.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavPasswordneverexpires.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavPasswordneverexpires.getInternalname(), GXutil.booltostr( AV44PasswordNeverExpires), "", " ", 1, chkavPasswordneverexpires.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_PasswordNeverExpires", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(128, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,128);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsblocked.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsblocked.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsblocked.getInternalname(), GXutil.booltostr( AV27IsBlocked), "", " ", 1, chkavIsblocked.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IsBlocked", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(133, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,133);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSecuritypolicyid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavSecuritypolicyid.getInternalname(), httpContext.getMessage( "WWP_GAM_SecurityPolicy", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 137,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSecuritypolicyid, cmbavSecuritypolicyid.getInternalname(), GXutil.trim( GXutil.str( AV50SecurityPolicyId, 9, 0)), 1, cmbavSecuritypolicyid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavSecuritypolicyid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,137);\"", "", true, (byte)(0), "HLP_GAMUserEntry.htm");
         cmbavSecuritypolicyid.setValue( GXutil.trim( GXutil.str( AV50SecurityPolicyId, 9, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecuritypolicyid.getInternalname(), "Values", cmbavSecuritypolicyid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divIsenabledinrepository_cell_Internalname, 1, 0, "px", 0, "px", divIsenabledinrepository_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavIsenabledinrepository.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsenabledinrepository.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsenabledinrepository.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsenabledinrepository.getInternalname(), GXutil.booltostr( AV28IsEnabledInRepository), "", " ", chkavIsenabledinrepository.getVisible(), chkavIsenabledinrepository.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Isenabledinrepository", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(142, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,142);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divDatelastauthentication_cell_Internalname, 1, 0, "px", 0, "px", divDatelastauthentication_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavDatelastauthentication_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDatelastauthentication_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDatelastauthentication_Internalname, httpContext.getMessage( "WWP_GAM_DateLastAuth", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 146,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDatelastauthentication_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDatelastauthentication_Internalname, localUtil.ttoc( AV14DateLastAuthentication, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( AV14DateLastAuthentication, "99/99/9999 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,146);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDatelastauthentication_Jsonclick, 0, "Attribute", "", "", "", "", edtavDatelastauthentication_Visible, edtavDatelastauthentication_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDateTime", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavDatelastauthentication_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavDatelastauthentication_Visible==0)||(edtavDatelastauthentication_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMUserEntry.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEnabletwofactorauthentication_cell_Internalname, 1, 0, "px", 0, "px", divEnabletwofactorauthentication_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavEnabletwofactorauthentication.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEnabletwofactorauthentication.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEnabletwofactorauthentication.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEnabletwofactorauthentication.getInternalname(), GXutil.booltostr( AV17EnableTwoFactorAuthentication), "", " ", chkavEnabletwofactorauthentication.getVisible(), chkavEnabletwofactorauthentication.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_EnableTwoFactorAuthentication", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(151, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,151);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtpnumberlocked_cell_Internalname, 1, 0, "px", 0, "px", divOtpnumberlocked_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavOtpnumberlocked_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpnumberlocked_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpnumberlocked_Internalname, httpContext.getMessage( "WWP_GAM_NumberOfLockedOTPCodes", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpnumberlocked_Internalname, GXutil.ltrim( localUtil.ntoc( AV40OTPNumberLocked, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV40OTPNumberLocked), "ZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,156);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpnumberlocked_Jsonclick, 0, "Attribute", "", "", "", "", edtavOtpnumberlocked_Visible, edtavOtpnumberlocked_Enabled, 1, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtplastlockeddate_cell_Internalname, 1, 0, "px", 0, "px", divOtplastlockeddate_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavOtplastlockeddate_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtplastlockeddate_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtplastlockeddate_Internalname, httpContext.getMessage( "WWP_GAM_LastTimeOTPLocked", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavOtplastlockeddate_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtplastlockeddate_Internalname, localUtil.ttoc( AV39OTPLastLockedDate, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( AV39OTPLastLockedDate, "99/99/9999 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,160);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtplastlockeddate_Jsonclick, 0, "Attribute", "", "", "", "", edtavOtplastlockeddate_Visible, edtavOtplastlockeddate_Enabled, 1, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDateTime", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavOtplastlockeddate_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavOtplastlockeddate_Visible==0)||(edtavOtplastlockeddate_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMUserEntry.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtpdailynumbercodes_cell_Internalname, 1, 0, "px", 0, "px", divOtpdailynumbercodes_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavOtpdailynumbercodes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtpdailynumbercodes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtpdailynumbercodes_Internalname, httpContext.getMessage( "WWP_GAM_NumberDailyOTPCodesRequested", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 165,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtpdailynumbercodes_Internalname, GXutil.ltrim( localUtil.ntoc( AV37OTPDailyNumberCodes, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV37OTPDailyNumberCodes), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,165);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtpdailynumbercodes_Jsonclick, 0, "Attribute", "", "", "", "", edtavOtpdailynumbercodes_Visible, edtavOtpdailynumbercodes_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOtplastdaterequestcode_cell_Internalname, 1, 0, "px", 0, "px", divOtplastdaterequestcode_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavOtplastdaterequestcode_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavOtplastdaterequestcode_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavOtplastdaterequestcode_Internalname, httpContext.getMessage( "WWP_GAM_LastDateRequestedOTPCode", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavOtplastdaterequestcode_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavOtplastdaterequestcode_Internalname, localUtil.format(AV38OTPLastDateRequestCode, "99/99/9999"), localUtil.format( AV38OTPLastDateRequestCode, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavOtplastdaterequestcode_Jsonclick, 0, "Attribute", "", "", "", "", edtavOtplastdaterequestcode_Visible, edtavOtplastdaterequestcode_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDate", "right", false, "", "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavOtplastdaterequestcode_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavOtplastdaterequestcode_Visible==0)||(edtavOtplastdaterequestcode_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMUserEntry.htm");
         httpContext.writeTextNL( "</div>") ;
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 174,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMUserEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 176,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMUserEntry.htm");
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
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 180,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUser_isenabledinrepository.getInternalname(), GXutil.booltostr( AV53User.getgxTv_SdtGAMUser_Isenabledinrepository()), "", "", chkavUser_isenabledinrepository.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(180, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,180);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start3C2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "User ", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup3C0( ) ;
   }

   public void ws3C2( )
   {
      start3C2( ) ;
      evt3C2( ) ;
   }

   public void evt3C2( )
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
                           e123C2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Refresh */
                           e133C2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSENDACTIVATIONEMAIL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSendActivationEmail' */
                           e143C2 ();
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
                                 e153C2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VAUTHENTICATIONTYPENAME.ISVALID") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e163C2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e173C2 ();
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
   }

   public void we3C2( )
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

   public void pa3C2( )
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
            GX_FocusControl = edtavUsernamespace_Internalname ;
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
      if ( cmbavAuthenticationtypename.getItemCount() > 0 )
      {
         AV7AuthenticationTypeName = cmbavAuthenticationtypename.getValidValue(AV7AuthenticationTypeName) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AuthenticationTypeName", AV7AuthenticationTypeName);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavAuthenticationtypename.setValue( GXutil.rtrim( AV7AuthenticationTypeName) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Values", cmbavAuthenticationtypename.ToJavascriptSource(), true);
      }
      if ( cmbavGender.getItemCount() > 0 )
      {
         AV24Gender = cmbavGender.getValidValue(AV24Gender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Gender", AV24Gender);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavGender.setValue( GXutil.rtrim( AV24Gender) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Values", cmbavGender.ToJavascriptSource(), true);
      }
      AV26IsActive = GXutil.strtobool( GXutil.booltostr( AV26IsActive)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26IsActive", AV26IsActive);
      AV15DontReceiveInformation = GXutil.strtobool( GXutil.booltostr( AV15DontReceiveInformation)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15DontReceiveInformation", AV15DontReceiveInformation);
      AV13CannotChangePassword = GXutil.strtobool( GXutil.booltostr( AV13CannotChangePassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13CannotChangePassword", AV13CannotChangePassword);
      AV35MustChangePassword = GXutil.strtobool( GXutil.booltostr( AV35MustChangePassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35MustChangePassword", AV35MustChangePassword);
      AV44PasswordNeverExpires = GXutil.strtobool( GXutil.booltostr( AV44PasswordNeverExpires)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44PasswordNeverExpires", AV44PasswordNeverExpires);
      AV27IsBlocked = GXutil.strtobool( GXutil.booltostr( AV27IsBlocked)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27IsBlocked", AV27IsBlocked);
      if ( cmbavSecuritypolicyid.getItemCount() > 0 )
      {
         AV50SecurityPolicyId = (int)(GXutil.lval( cmbavSecuritypolicyid.getValidValue(GXutil.trim( GXutil.str( AV50SecurityPolicyId, 9, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50SecurityPolicyId), 9, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSecuritypolicyid.setValue( GXutil.trim( GXutil.str( AV50SecurityPolicyId, 9, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecuritypolicyid.getInternalname(), "Values", cmbavSecuritypolicyid.ToJavascriptSource(), true);
      }
      AV28IsEnabledInRepository = GXutil.strtobool( GXutil.booltostr( AV28IsEnabledInRepository)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28IsEnabledInRepository", AV28IsEnabledInRepository);
      AV17EnableTwoFactorAuthentication = GXutil.strtobool( GXutil.booltostr( AV17EnableTwoFactorAuthentication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17EnableTwoFactorAuthentication", AV17EnableTwoFactorAuthentication);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3C2( ) ;
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
      edtavUserid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUserid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserid_Enabled), 5, 0), true);
      edtavUsernamespace_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUsernamespace_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsernamespace_Enabled), 5, 0), true);
      edtavActivationdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavActivationdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActivationdate_Enabled), 5, 0), true);
      edtavDatelastauthentication_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDatelastauthentication_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDatelastauthentication_Enabled), 5, 0), true);
      edtavOtpnumberlocked_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtpnumberlocked_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberlocked_Enabled), 5, 0), true);
      edtavOtplastlockeddate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtplastlockeddate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastlockeddate_Enabled), 5, 0), true);
      edtavOtpdailynumbercodes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtpdailynumbercodes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpdailynumbercodes_Enabled), 5, 0), true);
      edtavOtplastdaterequestcode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtplastdaterequestcode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastdaterequestcode_Enabled), 5, 0), true);
   }

   public void rf3C2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      /* Execute user event: Refresh */
      e133C2 ();
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e173C2 ();
         wb3C0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3C2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55UserId, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavUserid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUserid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserid_Enabled), 5, 0), true);
      edtavUsernamespace_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUsernamespace_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsernamespace_Enabled), 5, 0), true);
      edtavActivationdate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavActivationdate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActivationdate_Enabled), 5, 0), true);
      edtavDatelastauthentication_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDatelastauthentication_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDatelastauthentication_Enabled), 5, 0), true);
      edtavOtpnumberlocked_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtpnumberlocked_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberlocked_Enabled), 5, 0), true);
      edtavOtplastlockeddate_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtplastlockeddate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastlockeddate_Enabled), 5, 0), true);
      edtavOtpdailynumbercodes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtpdailynumbercodes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpdailynumbercodes_Enabled), 5, 0), true);
      edtavOtplastdaterequestcode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOtplastdaterequestcode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastdaterequestcode_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup3C0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e123C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
         Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
         Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
         Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
         Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
         Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
         Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
         Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
         Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
         Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
         /* Read variables values. */
         AV55UserId = httpContext.cgiGet( edtavUserid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55UserId", AV55UserId);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55UserId, ""))));
         AV56UserNameSpace = httpContext.cgiGet( edtavUsernamespace_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56UserNameSpace", AV56UserNameSpace);
         cmbavAuthenticationtypename.setValue( httpContext.cgiGet( cmbavAuthenticationtypename.getInternalname()) );
         AV7AuthenticationTypeName = httpContext.cgiGet( cmbavAuthenticationtypename.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AuthenticationTypeName", AV7AuthenticationTypeName);
         AV36Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36Name", AV36Name);
         AV16Email = httpContext.cgiGet( edtavEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Email", AV16Email);
         AV41Password = httpContext.cgiGet( edtavPassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41Password", AV41Password);
         AV42PasswordConf = httpContext.cgiGet( edtavPasswordconf_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42PasswordConf", AV42PasswordConf);
         AV22FirstName = httpContext.cgiGet( edtavFirstname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22FirstName", AV22FirstName);
         AV31LastName = httpContext.cgiGet( edtavLastname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31LastName", AV31LastName);
         AV20ExternalId = httpContext.cgiGet( edtavExternalid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ExternalId", AV20ExternalId);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavBirthday_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vBIRTHDAY");
            GX_FocusControl = edtavBirthday_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11Birthday = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11Birthday", localUtil.format(AV11Birthday, "99/99/9999"));
         }
         else
         {
            AV11Birthday = localUtil.ctod( httpContext.cgiGet( edtavBirthday_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11Birthday", localUtil.format(AV11Birthday, "99/99/9999"));
         }
         cmbavGender.setValue( httpContext.cgiGet( cmbavGender.getInternalname()) );
         AV24Gender = httpContext.cgiGet( cmbavGender.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Gender", AV24Gender);
         AV45Phone = httpContext.cgiGet( edtavPhone_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45Phone", AV45Phone);
         AV52URLProfile = httpContext.cgiGet( edtavUrlprofile_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52URLProfile", AV52URLProfile);
         AV25Image = httpContext.cgiGet( imgavImage_Internalname) ;
         AV26IsActive = GXutil.strtobool( httpContext.cgiGet( chkavIsactive.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26IsActive", AV26IsActive);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavActivationdate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vACTIVATIONDATE");
            GX_FocusControl = edtavActivationdate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV5ActivationDate = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "AV5ActivationDate", localUtil.ttoc( AV5ActivationDate, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            AV5ActivationDate = localUtil.ctot( httpContext.cgiGet( edtavActivationdate_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5ActivationDate", localUtil.ttoc( AV5ActivationDate, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         AV15DontReceiveInformation = GXutil.strtobool( httpContext.cgiGet( chkavDontreceiveinformation.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15DontReceiveInformation", AV15DontReceiveInformation);
         AV13CannotChangePassword = GXutil.strtobool( httpContext.cgiGet( chkavCannotchangepassword.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13CannotChangePassword", AV13CannotChangePassword);
         AV35MustChangePassword = GXutil.strtobool( httpContext.cgiGet( chkavMustchangepassword.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35MustChangePassword", AV35MustChangePassword);
         AV44PasswordNeverExpires = GXutil.strtobool( httpContext.cgiGet( chkavPasswordneverexpires.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44PasswordNeverExpires", AV44PasswordNeverExpires);
         AV27IsBlocked = GXutil.strtobool( httpContext.cgiGet( chkavIsblocked.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27IsBlocked", AV27IsBlocked);
         cmbavSecuritypolicyid.setValue( httpContext.cgiGet( cmbavSecuritypolicyid.getInternalname()) );
         AV50SecurityPolicyId = (int)(GXutil.lval( httpContext.cgiGet( cmbavSecuritypolicyid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50SecurityPolicyId), 9, 0));
         AV28IsEnabledInRepository = GXutil.strtobool( httpContext.cgiGet( chkavIsenabledinrepository.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28IsEnabledInRepository", AV28IsEnabledInRepository);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavDatelastauthentication_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vDATELASTAUTHENTICATION");
            GX_FocusControl = edtavDatelastauthentication_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV14DateLastAuthentication = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "AV14DateLastAuthentication", localUtil.ttoc( AV14DateLastAuthentication, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            AV14DateLastAuthentication = localUtil.ctot( httpContext.cgiGet( edtavDatelastauthentication_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14DateLastAuthentication", localUtil.ttoc( AV14DateLastAuthentication, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         AV17EnableTwoFactorAuthentication = GXutil.strtobool( httpContext.cgiGet( chkavEnabletwofactorauthentication.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17EnableTwoFactorAuthentication", AV17EnableTwoFactorAuthentication);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpnumberlocked_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpnumberlocked_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPNUMBERLOCKED");
            GX_FocusControl = edtavOtpnumberlocked_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV40OTPNumberLocked = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40OTPNumberLocked", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40OTPNumberLocked), 3, 0));
         }
         else
         {
            AV40OTPNumberLocked = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtpnumberlocked_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40OTPNumberLocked", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40OTPNumberLocked), 3, 0));
         }
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavOtplastlockeddate_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vOTPLASTLOCKEDDATE");
            GX_FocusControl = edtavOtplastlockeddate_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV39OTPLastLockedDate = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "AV39OTPLastLockedDate", localUtil.ttoc( AV39OTPLastLockedDate, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            AV39OTPLastLockedDate = localUtil.ctot( httpContext.cgiGet( edtavOtplastlockeddate_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39OTPLastLockedDate", localUtil.ttoc( AV39OTPLastLockedDate, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpdailynumbercodes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavOtpdailynumbercodes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vOTPDAILYNUMBERCODES");
            GX_FocusControl = edtavOtpdailynumbercodes_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV37OTPDailyNumberCodes = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37OTPDailyNumberCodes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37OTPDailyNumberCodes), 4, 0));
         }
         else
         {
            AV37OTPDailyNumberCodes = (short)(localUtil.ctol( httpContext.cgiGet( edtavOtpdailynumbercodes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37OTPDailyNumberCodes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37OTPDailyNumberCodes), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavOtplastdaterequestcode_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vOTPLASTDATEREQUESTCODE");
            GX_FocusControl = edtavOtplastdaterequestcode_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV38OTPLastDateRequestCode = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38OTPLastDateRequestCode", localUtil.format(AV38OTPLastDateRequestCode, "99/99/9999"));
         }
         else
         {
            AV38OTPLastDateRequestCode = localUtil.ctod( httpContext.cgiGet( edtavOtplastdaterequestcode_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38OTPLastDateRequestCode", localUtil.format(AV38OTPLastDateRequestCode, "99/99/9999"));
         }
         AV53User.setgxTv_SdtGAMUser_Isenabledinrepository( GXutil.strtobool( httpContext.cgiGet( chkavUser_isenabledinrepository.getInternalname())) );
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
      e123C2 ();
      if (returnInSub) return;
   }

   public void e123C2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV23GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( (0==AV23GAMRepository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
      {
         cmbavAuthenticationtypename.removeAllItems();
         GXv_objcol_SdtGAMError1[0] = AV19Errors ;
         AV8AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV30Language, GXv_objcol_SdtGAMError1) ;
         AV19Errors = GXv_objcol_SdtGAMError1[0] ;
         AV64GXV2 = 1 ;
         while ( AV64GXV2 <= AV8AuthenticationTypes.size() )
         {
            AV9AuthenticationTypesIns = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV8AuthenticationTypes.elementAt(-1+AV64GXV2));
            cmbavAuthenticationtypename.addItem(AV9AuthenticationTypesIns.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV9AuthenticationTypesIns.getgxTv_SdtGAMAuthenticationTypeSimple_Description(), (short)(0));
            AV64GXV2 = (int)(AV64GXV2+1) ;
         }
      }
      else
      {
         cmbavAuthenticationtypename.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavAuthenticationtypename.getVisible(), 5, 0), true);
      }
      GXv_objcol_SdtGAMError1[0] = AV19Errors ;
      AV48SecurityPolicies = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getsecuritypolicies(AV21FilterSecPol, GXv_objcol_SdtGAMError1) ;
      AV19Errors = GXv_objcol_SdtGAMError1[0] ;
      cmbavSecuritypolicyid.addItem("0", httpContext.getMessage( "(None)", ""), (short)(0));
      AV65GXV3 = 1 ;
      while ( AV65GXV3 <= AV48SecurityPolicies.size() )
      {
         AV49SecurityPolicy = (genexus.security.api.genexussecurity.SdtGAMSecurityPolicy)((genexus.security.api.genexussecurity.SdtGAMSecurityPolicy)AV48SecurityPolicies.elementAt(-1+AV65GXV3));
         cmbavSecuritypolicyid.addItem(GXutil.trim( GXutil.str( AV49SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Id(), 9, 0)), AV49SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Name(), (short)(0));
         AV65GXV3 = (int)(AV65GXV3+1) ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         chkavIsenabledinrepository.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsenabledinrepository.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsenabledinrepository.getEnabled(), 5, 0), true);
         cmbavAuthenticationtypename.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAuthenticationtypename.getEnabled(), 5, 0), true);
         AV7AuthenticationTypeName = "local" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AuthenticationTypeName", AV7AuthenticationTypeName);
         GXv_objcol_SdtGAMError1[0] = AV19Errors ;
         AV10AuthTypeId = AV6AuthenticationType.gettypebyname(AV7AuthenticationTypeName, GXv_objcol_SdtGAMError1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10AuthTypeId", AV10AuthTypeId);
         AV19Errors = GXv_objcol_SdtGAMError1[0] ;
         AV47Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         AV56UserNameSpace = AV47Repository.getgxTv_SdtGAMRepository_Namespace() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56UserNameSpace", AV56UserNameSpace);
         AV17EnableTwoFactorAuthentication = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17EnableTwoFactorAuthentication", AV17EnableTwoFactorAuthentication);
      }
      else
      {
         AV53User.load(AV55UserId);
         cmbavAuthenticationtypename.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAuthenticationtypename.getEnabled(), 5, 0), true);
         AV7AuthenticationTypeName = AV53User.getgxTv_SdtGAMUser_Authenticationtypename() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AuthenticationTypeName", AV7AuthenticationTypeName);
         GXv_objcol_SdtGAMError1[0] = AV19Errors ;
         AV10AuthTypeId = AV6AuthenticationType.gettypebyname(AV7AuthenticationTypeName, GXv_objcol_SdtGAMError1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10AuthTypeId", AV10AuthTypeId);
         AV19Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 )
         {
            edtavName_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
            imgavImage_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavImage_Enabled), 5, 0), true);
            edtavUrlprofile_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavUrlprofile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrlprofile_Enabled), 5, 0), true);
         }
         else
         {
            edtavName_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
            imgavImage_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavImage_Enabled), 5, 0), true);
            edtavUrlprofile_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavUrlprofile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrlprofile_Enabled), 5, 0), true);
         }
         AV55UserId = AV53User.getgxTv_SdtGAMUser_Guid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55UserId", AV55UserId);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55UserId, ""))));
         AV56UserNameSpace = AV53User.getgxTv_SdtGAMUser_Namespace() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56UserNameSpace", AV56UserNameSpace);
         AV36Name = AV53User.getgxTv_SdtGAMUser_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36Name", AV36Name);
         AV16Email = AV53User.getgxTv_SdtGAMUser_Email() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Email", AV16Email);
         AV22FirstName = AV53User.getgxTv_SdtGAMUser_Firstname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22FirstName", AV22FirstName);
         AV31LastName = AV53User.getgxTv_SdtGAMUser_Lastname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31LastName", AV31LastName);
         if ( ! (GXutil.strcmp("", AV53User.getgxTv_SdtGAMUser_Urlimage())==0) )
         {
            AV25Image = AV53User.getgxTv_SdtGAMUser_Urlimage() ;
            httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "Bitmap", ((GXutil.strcmp("", AV25Image)==0) ? AV66Image_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV25Image))), true);
            httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV25Image), true);
            AV66Image_GXI = GXDbFile.pathToUrl( AV53User.getgxTv_SdtGAMUser_Urlimage(), context.getHttpContext()) ;
            httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "Bitmap", ((GXutil.strcmp("", AV25Image)==0) ? AV66Image_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV25Image))), true);
            httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV25Image), true);
         }
         AV20ExternalId = AV53User.getgxTv_SdtGAMUser_Externalid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ExternalId", AV20ExternalId);
         AV11Birthday = AV53User.getgxTv_SdtGAMUser_Birthday() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11Birthday", localUtil.format(AV11Birthday, "99/99/9999"));
         AV24Gender = AV53User.getgxTv_SdtGAMUser_Gender() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Gender", AV24Gender);
         AV45Phone = AV53User.getgxTv_SdtGAMUser_Phone() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45Phone", AV45Phone);
         AV26IsActive = AV53User.getgxTv_SdtGAMUser_Isactive() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26IsActive", AV26IsActive);
         AV5ActivationDate = AV53User.getgxTv_SdtGAMUser_Activationdate() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5ActivationDate", localUtil.ttoc( AV5ActivationDate, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         AV15DontReceiveInformation = AV53User.getgxTv_SdtGAMUser_Dontreceiveinformation() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15DontReceiveInformation", AV15DontReceiveInformation);
         AV13CannotChangePassword = AV53User.getgxTv_SdtGAMUser_Cannotchangepassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13CannotChangePassword", AV13CannotChangePassword);
         AV35MustChangePassword = AV53User.getgxTv_SdtGAMUser_Mustchangepassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35MustChangePassword", AV35MustChangePassword);
         AV44PasswordNeverExpires = AV53User.getgxTv_SdtGAMUser_Passwordneverexpires() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44PasswordNeverExpires", AV44PasswordNeverExpires);
         AV27IsBlocked = AV53User.getgxTv_SdtGAMUser_Isblocked() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27IsBlocked", AV27IsBlocked);
         AV50SecurityPolicyId = AV53User.getgxTv_SdtGAMUser_Securitypolicyid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50SecurityPolicyId), 9, 0));
         AV28IsEnabledInRepository = AV53User.getgxTv_SdtGAMUser_Isenabledinrepository() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28IsEnabledInRepository", AV28IsEnabledInRepository);
         AV14DateLastAuthentication = AV53User.getgxTv_SdtGAMUser_Datelastauthentication() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14DateLastAuthentication", localUtil.ttoc( AV14DateLastAuthentication, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         AV17EnableTwoFactorAuthentication = AV53User.getgxTv_SdtGAMUser_Enabletwofactorauthentication() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17EnableTwoFactorAuthentication", AV17EnableTwoFactorAuthentication);
         AV37OTPDailyNumberCodes = AV53User.getgxTv_SdtGAMUser_Otpdailynumbercodes() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37OTPDailyNumberCodes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37OTPDailyNumberCodes), 4, 0));
         AV38OTPLastDateRequestCode = AV53User.getgxTv_SdtGAMUser_Otplastdaterequestcode() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38OTPLastDateRequestCode", localUtil.format(AV38OTPLastDateRequestCode, "99/99/9999"));
         AV39OTPLastLockedDate = GXutil.resetTime( AV53User.getgxTv_SdtGAMUser_Otplastlockeddate() );
         httpContext.ajax_rsp_assign_attri("", false, "AV39OTPLastLockedDate", localUtil.ttoc( AV39OTPLastLockedDate, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         AV40OTPNumberLocked = AV53User.getgxTv_SdtGAMUser_Otpnumberlocked() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40OTPNumberLocked", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40OTPNumberLocked), 3, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         edtavName_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
         edtavEmail_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmail_Enabled), 5, 0), true);
         edtavFirstname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFirstname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFirstname_Enabled), 5, 0), true);
         edtavLastname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLastname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLastname_Enabled), 5, 0), true);
         edtavUrlprofile_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUrlprofile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrlprofile_Enabled), 5, 0), true);
         edtavExternalid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavExternalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavExternalid_Enabled), 5, 0), true);
         edtavBirthday_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavBirthday_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavBirthday_Enabled), 5, 0), true);
         cmbavGender.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGender.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavGender.getEnabled(), 5, 0), true);
         edtavPhone_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPhone_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPhone_Enabled), 5, 0), true);
         chkavIsactive.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsactive.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsactive.getEnabled(), 5, 0), true);
         chkavDontreceiveinformation.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavDontreceiveinformation.getInternalname(), "Enabled", GXutil.ltrimstr( chkavDontreceiveinformation.getEnabled(), 5, 0), true);
         chkavCannotchangepassword.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavCannotchangepassword.getInternalname(), "Enabled", GXutil.ltrimstr( chkavCannotchangepassword.getEnabled(), 5, 0), true);
         chkavMustchangepassword.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavMustchangepassword.getInternalname(), "Enabled", GXutil.ltrimstr( chkavMustchangepassword.getEnabled(), 5, 0), true);
         chkavIsblocked.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsblocked.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsblocked.getEnabled(), 5, 0), true);
         chkavPasswordneverexpires.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavPasswordneverexpires.getInternalname(), "Enabled", GXutil.ltrimstr( chkavPasswordneverexpires.getEnabled(), 5, 0), true);
         cmbavSecuritypolicyid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecuritypolicyid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSecuritypolicyid.getEnabled(), 5, 0), true);
         chkavIsenabledinrepository.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsenabledinrepository.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsenabledinrepository.getEnabled(), 5, 0), true);
         if ( AV17EnableTwoFactorAuthentication )
         {
            chkavEnabletwofactorauthentication.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, chkavEnabletwofactorauthentication.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEnabletwofactorauthentication.getEnabled(), 5, 0), true);
            edtavOtpdailynumbercodes_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavOtpdailynumbercodes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpdailynumbercodes_Enabled), 5, 0), true);
            edtavOtplastdaterequestcode_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavOtplastdaterequestcode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastdaterequestcode_Enabled), 5, 0), true);
            edtavOtplastlockeddate_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavOtplastlockeddate_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastlockeddate_Enabled), 5, 0), true);
            edtavOtpnumberlocked_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavOtpnumberlocked_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberlocked_Enabled), 5, 0), true);
         }
         if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            bttBtnenter_Caption = httpContext.getMessage( "WWP_GAM_Delete", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
         }
         else
         {
            bttBtnenter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
         }
      }
      if ( AV26IsActive )
      {
         chkavIsactive.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsactive.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsactive.getEnabled(), 5, 0), true);
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      chkavUser_isenabledinrepository.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavUser_isenabledinrepository.getInternalname(), "Visible", GXutil.ltrimstr( chkavUser_isenabledinrepository.getVisible(), 5, 0), true);
   }

   public void e133C2( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e143C2( )
   {
      /* 'DoSendActivationEmail' Routine */
      returnInSub = false ;
      AV53User.load(AV55UserId);
      if ( ! AV53User.getgxTv_SdtGAMUser_Isactive() )
      {
         GXv_objcol_SdtGAMError1[0] = AV19Errors ;
         AV54UserActivationKey = AV53User.getnewactivationkey(GXv_objcol_SdtGAMError1) ;
         AV19Errors = GXv_objcol_SdtGAMError1[0] ;
         Application.commitDataStores(context, remoteHandle, pr_default, "gamuserentry");
         AV32LinkURL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).applicationgetaccountactivationurl("") ;
         GXv_objcol_SdtMessages_Message2[0] = AV34Messages ;
         new com.mujermorena.gamcheckuseractivationmethod(remoteHandle, context).execute( AV55UserId, AV32LinkURL, GXv_objcol_SdtMessages_Message2) ;
         AV34Messages = GXv_objcol_SdtMessages_Message2[0] ;
         AV67GXV4 = 1 ;
         while ( AV67GXV4 <= AV34Messages.size() )
         {
            AV33Message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV34Messages.elementAt(-1+AV67GXV4));
            httpContext.GX_msglist.addItem(AV33Message.getgxTv_SdtMessages_Message_Description());
            AV67GXV4 = (int)(AV67GXV4+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53User", AV53User);
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ! AV26IsActive && AV23GAMRepository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Sendemailwhenuseractivateaccount() ) )
      {
         bttBtnsendactivationemail_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnsendactivationemail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnsendactivationemail_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) && ( ! (GXutil.strcmp("", AV53User.getgxTv_SdtGAMUser_Urlprofile())==0) && ( GXutil.strcmp(AV53User.getgxTv_SdtGAMUser_Authenticationtypename(), "GAMLocal") != 0 ) ) ) )
      {
         bttBtnurlprofilego_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnurlprofilego_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnurlprofilego_Visible), 5, 0), true);
      }
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS' Routine */
      returnInSub = false ;
      AV59CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      if ( (GXutil.strcmp("", AV36Name)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_UserName", ""), "", "", "", "", "", "", "", ""), "error", edtavName_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredemail() ) && (GXutil.strcmp("", AV16Email)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Email", ""), "", "", "", "", "", "", "", ""), "error", edtavEmail_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredpassword() && ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 ) ) && (GXutil.strcmp("", AV41Password)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Password", ""), "", "", "", "", "", "", "", ""), "error", edtavPassword_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredpassword() && ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 ) ) && (GXutil.strcmp("", AV42PasswordConf)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_ConfPassword", ""), "", "", "", "", "", "", "", ""), "error", edtavPasswordconf_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredfirstname() ) && (GXutil.strcmp("", AV22FirstName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_FirstName", ""), "", "", "", "", "", "", "", ""), "error", edtavFirstname_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredlastname() ) && (GXutil.strcmp("", AV31LastName)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_LastName", ""), "", "", "", "", "", "", "", ""), "error", edtavLastname_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredbirthday() ) && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11Birthday)) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Birthday", ""), "", "", "", "", "", "", "", ""), "error", edtavBirthday_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredgender() ) && (GXutil.strcmp("", AV24Gender)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Gender", ""), "", "", "", "", "", "", "", ""), "error", cmbavGender.getInternalname(), "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
      if ( ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredphone() ) && (GXutil.strcmp("", AV45Phone)==0) )
      {
         httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( "", GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "WWP_GAM_Phone", ""), "", "", "", "", "", "", "", ""), "error", edtavPhone_Internalname, "true", ""));
         AV59CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59CheckRequiredFieldsResult", AV59CheckRequiredFieldsResult);
      }
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ( cmbavAuthenticationtypename.getItemCount() > 1 ) ) )
      {
         cmbavAuthenticationtypename.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavAuthenticationtypename.getVisible(), 5, 0), true);
         divAuthenticationtypename_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divAuthenticationtypename_cell_Internalname, "Class", divAuthenticationtypename_cell_Class, true);
      }
      else
      {
         cmbavAuthenticationtypename.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAuthenticationtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavAuthenticationtypename.getVisible(), 5, 0), true);
         divAuthenticationtypename_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divAuthenticationtypename_cell_Internalname, "Class", divAuthenticationtypename_cell_Class, true);
      }
      if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredemail() )
      {
         divEmail_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmail_cell_Internalname, "Class", divEmail_cell_Class, true);
      }
      else
      {
         divEmail_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmail_cell_Internalname, "Class", divEmail_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) )
      {
         edtavPassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPassword_Visible), 5, 0), true);
         divPassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divPassword_cell_Internalname, "Class", divPassword_cell_Class, true);
      }
      else
      {
         edtavPassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPassword_Visible), 5, 0), true);
         if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredpassword() && ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 ) )
         {
            divPassword_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
            httpContext.ajax_rsp_assign_prop("", false, divPassword_cell_Internalname, "Class", divPassword_cell_Class, true);
         }
         else
         {
            divPassword_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
            httpContext.ajax_rsp_assign_prop("", false, divPassword_cell_Internalname, "Class", divPassword_cell_Class, true);
         }
      }
      if ( ! ( ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) )
      {
         edtavPasswordconf_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPasswordconf_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPasswordconf_Visible), 5, 0), true);
         divPasswordconf_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divPasswordconf_cell_Internalname, "Class", divPasswordconf_cell_Class, true);
      }
      else
      {
         edtavPasswordconf_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavPasswordconf_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPasswordconf_Visible), 5, 0), true);
         if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredpassword() && ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 ) )
         {
            divPasswordconf_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
            httpContext.ajax_rsp_assign_prop("", false, divPasswordconf_cell_Internalname, "Class", divPasswordconf_cell_Class, true);
         }
         else
         {
            divPasswordconf_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
            httpContext.ajax_rsp_assign_prop("", false, divPasswordconf_cell_Internalname, "Class", divPasswordconf_cell_Class, true);
         }
      }
      if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredfirstname() )
      {
         divFirstname_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divFirstname_cell_Internalname, "Class", divFirstname_cell_Class, true);
      }
      else
      {
         divFirstname_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divFirstname_cell_Internalname, "Class", divFirstname_cell_Class, true);
      }
      if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredlastname() )
      {
         divLastname_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divLastname_cell_Internalname, "Class", divLastname_cell_Class, true);
      }
      else
      {
         divLastname_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divLastname_cell_Internalname, "Class", divLastname_cell_Class, true);
      }
      if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredbirthday() )
      {
         divBirthday_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divBirthday_cell_Internalname, "Class", divBirthday_cell_Class, true);
      }
      else
      {
         divBirthday_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divBirthday_cell_Internalname, "Class", divBirthday_cell_Class, true);
      }
      if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredgender() )
      {
         divGender_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divGender_cell_Internalname, "Class", divGender_cell_Class, true);
      }
      else
      {
         divGender_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divGender_cell_Internalname, "Class", divGender_cell_Class, true);
      }
      if ( AV23GAMRepository.getgxTv_SdtGAMRepository_Requiredphone() )
      {
         divPhone_cell_Class = "col-xs-12 col-sm-6 RequiredDataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divPhone_cell_Internalname, "Class", divPhone_cell_Class, true);
      }
      else
      {
         divPhone_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divPhone_cell_Internalname, "Class", divPhone_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) && ! (GXutil.strcmp("", AV53User.getgxTv_SdtGAMUser_Urlimage())==0) ) )
      {
         imgavImage_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavImage_Visible), 5, 0), true);
         divImage_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divImage_cell_Internalname, "Class", divImage_cell_Class, true);
      }
      else
      {
         imgavImage_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, imgavImage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgavImage_Visible), 5, 0), true);
         divImage_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divImage_cell_Internalname, "Class", divImage_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) ) )
      {
         chkavIsactive.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsactive.getInternalname(), "Visible", GXutil.ltrimstr( chkavIsactive.getVisible(), 5, 0), true);
         divIsactive_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divIsactive_cell_Internalname, "Class", divIsactive_cell_Class, true);
      }
      else
      {
         chkavIsactive.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsactive.getInternalname(), "Visible", GXutil.ltrimstr( chkavIsactive.getVisible(), 5, 0), true);
         divIsactive_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divIsactive_cell_Internalname, "Class", divIsactive_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) ) )
      {
         chkavIsenabledinrepository.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsenabledinrepository.getInternalname(), "Visible", GXutil.ltrimstr( chkavIsenabledinrepository.getVisible(), 5, 0), true);
         divIsenabledinrepository_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divIsenabledinrepository_cell_Internalname, "Class", divIsenabledinrepository_cell_Class, true);
      }
      else
      {
         chkavIsenabledinrepository.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavIsenabledinrepository.getInternalname(), "Visible", GXutil.ltrimstr( chkavIsenabledinrepository.getVisible(), 5, 0), true);
         divIsenabledinrepository_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divIsenabledinrepository_cell_Internalname, "Class", divIsenabledinrepository_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) ) )
      {
         edtavDatelastauthentication_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDatelastauthentication_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDatelastauthentication_Visible), 5, 0), true);
         divDatelastauthentication_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divDatelastauthentication_cell_Internalname, "Class", divDatelastauthentication_cell_Class, true);
      }
      else
      {
         edtavDatelastauthentication_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDatelastauthentication_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDatelastauthentication_Visible), 5, 0), true);
         divDatelastauthentication_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divDatelastauthentication_cell_Internalname, "Class", divDatelastauthentication_cell_Class, true);
      }
      if ( ! ( AV23GAMRepository.istwofactorauthenticationenabled() ) )
      {
         chkavEnabletwofactorauthentication.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavEnabletwofactorauthentication.getInternalname(), "Visible", GXutil.ltrimstr( chkavEnabletwofactorauthentication.getVisible(), 5, 0), true);
         divEnabletwofactorauthentication_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEnabletwofactorauthentication_cell_Internalname, "Class", divEnabletwofactorauthentication_cell_Class, true);
      }
      else
      {
         chkavEnabletwofactorauthentication.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavEnabletwofactorauthentication.getInternalname(), "Visible", GXutil.ltrimstr( chkavEnabletwofactorauthentication.getVisible(), 5, 0), true);
         divEnabletwofactorauthentication_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEnabletwofactorauthentication_cell_Internalname, "Class", divEnabletwofactorauthentication_cell_Class, true);
      }
      if ( ! ( AV23GAMRepository.isonetimepasswordenabled() ) )
      {
         edtavOtpnumberlocked_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtpnumberlocked_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberlocked_Visible), 5, 0), true);
         divOtpnumberlocked_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtpnumberlocked_cell_Internalname, "Class", divOtpnumberlocked_cell_Class, true);
      }
      else
      {
         edtavOtpnumberlocked_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtpnumberlocked_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpnumberlocked_Visible), 5, 0), true);
         divOtpnumberlocked_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtpnumberlocked_cell_Internalname, "Class", divOtpnumberlocked_cell_Class, true);
      }
      if ( ! ( AV23GAMRepository.isonetimepasswordenabled() ) )
      {
         edtavOtplastlockeddate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtplastlockeddate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastlockeddate_Visible), 5, 0), true);
         divOtplastlockeddate_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtplastlockeddate_cell_Internalname, "Class", divOtplastlockeddate_cell_Class, true);
      }
      else
      {
         edtavOtplastlockeddate_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtplastlockeddate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastlockeddate_Visible), 5, 0), true);
         divOtplastlockeddate_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtplastlockeddate_cell_Internalname, "Class", divOtplastlockeddate_cell_Class, true);
      }
      if ( ! ( AV23GAMRepository.isonetimepasswordenabled() ) )
      {
         edtavOtpdailynumbercodes_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtpdailynumbercodes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpdailynumbercodes_Visible), 5, 0), true);
         divOtpdailynumbercodes_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtpdailynumbercodes_cell_Internalname, "Class", divOtpdailynumbercodes_cell_Class, true);
      }
      else
      {
         edtavOtpdailynumbercodes_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtpdailynumbercodes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtpdailynumbercodes_Visible), 5, 0), true);
         divOtpdailynumbercodes_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtpdailynumbercodes_cell_Internalname, "Class", divOtpdailynumbercodes_cell_Class, true);
      }
      if ( ! ( AV23GAMRepository.isonetimepasswordenabled() ) )
      {
         edtavOtplastdaterequestcode_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtplastdaterequestcode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastdaterequestcode_Visible), 5, 0), true);
         divOtplastdaterequestcode_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtplastdaterequestcode_cell_Internalname, "Class", divOtplastdaterequestcode_cell_Class, true);
      }
      else
      {
         edtavOtplastdaterequestcode_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavOtplastdaterequestcode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOtplastdaterequestcode_Visible), 5, 0), true);
         divOtplastdaterequestcode_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divOtplastdaterequestcode_cell_Internalname, "Class", divOtplastdaterequestcode_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) ) )
      {
         edtavActivationdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavActivationdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActivationdate_Visible), 5, 0), true);
         divActivationdate_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divActivationdate_cell_Internalname, "Class", divActivationdate_cell_Class, true);
      }
      else
      {
         edtavActivationdate_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavActivationdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavActivationdate_Visible), 5, 0), true);
         divActivationdate_cell_Class = "DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divActivationdate_cell_Internalname, "Class", divActivationdate_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) && ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") != 0 ) ) )
      {
         edtavUrlprofile_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUrlprofile_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrlprofile_Visible), 5, 0), true);
         divUrlprofile_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divUrlprofile_cell_Internalname, "Class", divUrlprofile_cell_Class, true);
      }
      else
      {
         edtavUrlprofile_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUrlprofile_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUrlprofile_Visible), 5, 0), true);
         divUrlprofile_cell_Class = "DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divUrlprofile_cell_Internalname, "Class", divUrlprofile_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e153C2 ();
      if (returnInSub) return;
   }

   public void e153C2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKREQUIREDFIELDS' */
      S132 ();
      if (returnInSub) return;
      if ( AV59CheckRequiredFieldsResult )
      {
         if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
         {
            AV53User.load(AV55UserId);
         }
         AV43PasswordIsOK = true ;
         if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
         {
            if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
            {
               GXv_objcol_SdtGAMError1[0] = AV19Errors ;
               AV10AuthTypeId = AV6AuthenticationType.gettypebyname(AV7AuthenticationTypeName, GXv_objcol_SdtGAMError1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10AuthTypeId", AV10AuthTypeId);
               AV19Errors = GXv_objcol_SdtGAMError1[0] ;
               AV28IsEnabledInRepository = true ;
               httpContext.ajax_rsp_assign_attri("", false, "AV28IsEnabledInRepository", AV28IsEnabledInRepository);
               if ( GXutil.strcmp(AV10AuthTypeId, "GAMLocal") == 0 )
               {
                  if ( GXutil.strcmp(AV41Password, AV42PasswordConf) != 0 )
                  {
                     AV43PasswordIsOK = false ;
                     httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_GAM_PasswordNotMatch", ""));
                  }
               }
               else
               {
                  AV41Password = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV41Password", AV41Password);
               }
            }
            if ( AV43PasswordIsOK )
            {
               AV53User.setgxTv_SdtGAMUser_Authenticationtypename( AV7AuthenticationTypeName );
               AV53User.setgxTv_SdtGAMUser_Name( AV36Name );
               AV53User.setgxTv_SdtGAMUser_Email( AV16Email );
               AV53User.setgxTv_SdtGAMUser_Firstname( AV22FirstName );
               AV53User.setgxTv_SdtGAMUser_Lastname( AV31LastName );
               AV53User.setgxTv_SdtGAMUser_Password( AV41Password );
               AV53User.setgxTv_SdtGAMUser_Externalid( AV20ExternalId );
               AV53User.setgxTv_SdtGAMUser_Birthday( AV11Birthday );
               AV53User.setgxTv_SdtGAMUser_Phone( AV45Phone );
               AV53User.setgxTv_SdtGAMUser_Gender( AV24Gender );
               AV53User.setgxTv_SdtGAMUser_Isactive( AV26IsActive );
               AV12BlobPhoto = AV46Photo ;
               AV53User.setgxTv_SdtGAMUser_Urlprofile( AV52URLProfile );
               AV53User.setgxTv_SdtGAMUser_Dontreceiveinformation( AV15DontReceiveInformation );
               AV53User.setgxTv_SdtGAMUser_Cannotchangepassword( AV13CannotChangePassword );
               AV53User.setgxTv_SdtGAMUser_Mustchangepassword( AV35MustChangePassword );
               AV53User.setgxTv_SdtGAMUser_Isblocked( AV27IsBlocked );
               AV53User.setgxTv_SdtGAMUser_Passwordneverexpires( AV44PasswordNeverExpires );
               AV53User.setgxTv_SdtGAMUser_Securitypolicyid( AV50SecurityPolicyId );
               AV53User.setgxTv_SdtGAMUser_Enabletwofactorauthentication( AV17EnableTwoFactorAuthentication );
               AV53User.save();
            }
         }
         else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            AV53User.delete();
         }
         if ( AV43PasswordIsOK )
         {
            if ( AV53User.success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamuserentry");
               AV29isOK = true ;
               if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
               {
                  if ( AV28IsEnabledInRepository != AV53User.getgxTv_SdtGAMUser_Isenabledinrepository() )
                  {
                     if ( AV28IsEnabledInRepository )
                     {
                        GXv_objcol_SdtGAMError1[0] = AV19Errors ;
                        AV29isOK = AV53User.repositoryenable(GXv_objcol_SdtGAMError1) ;
                        AV19Errors = GXv_objcol_SdtGAMError1[0] ;
                     }
                     else
                     {
                        GXv_objcol_SdtGAMError1[0] = AV19Errors ;
                        AV29isOK = AV53User.repositorydisable(GXv_objcol_SdtGAMError1) ;
                        AV19Errors = GXv_objcol_SdtGAMError1[0] ;
                     }
                  }
               }
               if ( AV29isOK )
               {
                  Application.commitDataStores(context, remoteHandle, pr_default, "gamuserentry");
                  if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
                  {
                     callWebObject(formatLink("com.mujermorena.gamwwusers", new String[] {}, new String[] {}) );
                     httpContext.wjLocDisableFrm = (byte)(1) ;
                  }
                  else
                  {
                     httpContext.setWebReturnParms(new Object[] {Gx_mode,AV55UserId});
                     httpContext.setWebReturnParmsMetadata(new Object[] {"Gx_mode","AV55UserId"});
                     httpContext.wjLocDisableFrm = (byte)(1) ;
                     httpContext.nUserReturn = (byte)(1) ;
                     returnInSub = true;
                     if (true) return;
                  }
               }
               else
               {
                  AV68GXV5 = 1 ;
                  while ( AV68GXV5 <= AV19Errors.size() )
                  {
                     AV18Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV19Errors.elementAt(-1+AV68GXV5));
                     httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV18Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV18Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
                     AV68GXV5 = (int)(AV68GXV5+1) ;
                  }
               }
            }
            else
            {
               AV19Errors = AV53User.geterrors() ;
               AV69GXV6 = 1 ;
               while ( AV69GXV6 <= AV19Errors.size() )
               {
                  AV18Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV19Errors.elementAt(-1+AV69GXV6));
                  httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV18Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV18Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
                  AV69GXV6 = (int)(AV69GXV6+1) ;
               }
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV53User", AV53User);
   }

   public void e163C2( )
   {
      /* Authenticationtypename_Isvalid Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError1[0] = AV19Errors ;
      AV10AuthTypeId = AV6AuthenticationType.gettypebyname(AV7AuthenticationTypeName, GXv_objcol_SdtGAMError1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10AuthTypeId", AV10AuthTypeId);
      AV19Errors = GXv_objcol_SdtGAMError1[0] ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e173C2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV55UserId = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55UserId", AV55UserId);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV55UserId, ""))));
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
      pa3C2( ) ;
      ws3C2( ) ;
      we3C2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111205953", true, true);
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
      httpContext.AddJavascriptSource("gamuserentry.js", "?202412111205961", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavUserid_Internalname = "vUSERID" ;
      edtavUsernamespace_Internalname = "vUSERNAMESPACE" ;
      cmbavAuthenticationtypename.setInternalname( "vAUTHENTICATIONTYPENAME" );
      divAuthenticationtypename_cell_Internalname = "AUTHENTICATIONTYPENAME_CELL" ;
      edtavName_Internalname = "vNAME" ;
      edtavEmail_Internalname = "vEMAIL" ;
      divEmail_cell_Internalname = "EMAIL_CELL" ;
      edtavPassword_Internalname = "vPASSWORD" ;
      divPassword_cell_Internalname = "PASSWORD_CELL" ;
      edtavPasswordconf_Internalname = "vPASSWORDCONF" ;
      divPasswordconf_cell_Internalname = "PASSWORDCONF_CELL" ;
      edtavFirstname_Internalname = "vFIRSTNAME" ;
      divFirstname_cell_Internalname = "FIRSTNAME_CELL" ;
      edtavLastname_Internalname = "vLASTNAME" ;
      divLastname_cell_Internalname = "LASTNAME_CELL" ;
      edtavExternalid_Internalname = "vEXTERNALID" ;
      edtavBirthday_Internalname = "vBIRTHDAY" ;
      divBirthday_cell_Internalname = "BIRTHDAY_CELL" ;
      cmbavGender.setInternalname( "vGENDER" );
      divGender_cell_Internalname = "GENDER_CELL" ;
      edtavPhone_Internalname = "vPHONE" ;
      divPhone_cell_Internalname = "PHONE_CELL" ;
      lblTextblockurlprofile_Internalname = "TEXTBLOCKURLPROFILE" ;
      edtavUrlprofile_Internalname = "vURLPROFILE" ;
      divUnnamedtableurlprofile_Internalname = "UNNAMEDTABLEURLPROFILE" ;
      divUrlprofile_cell_Internalname = "URLPROFILE_CELL" ;
      bttBtnurlprofilego_Internalname = "BTNURLPROFILEGO" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      imgavImage_Internalname = "vIMAGE" ;
      divImage_cell_Internalname = "IMAGE_CELL" ;
      chkavIsactive.setInternalname( "vISACTIVE" );
      divIsactive_cell_Internalname = "ISACTIVE_CELL" ;
      lblTextblockactivationdate_Internalname = "TEXTBLOCKACTIVATIONDATE" ;
      edtavActivationdate_Internalname = "vACTIVATIONDATE" ;
      divUnnamedtableactivationdate_Internalname = "UNNAMEDTABLEACTIVATIONDATE" ;
      divActivationdate_cell_Internalname = "ACTIVATIONDATE_CELL" ;
      bttBtnsendactivationemail_Internalname = "BTNSENDACTIVATIONEMAIL" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      chkavDontreceiveinformation.setInternalname( "vDONTRECEIVEINFORMATION" );
      chkavCannotchangepassword.setInternalname( "vCANNOTCHANGEPASSWORD" );
      chkavMustchangepassword.setInternalname( "vMUSTCHANGEPASSWORD" );
      chkavPasswordneverexpires.setInternalname( "vPASSWORDNEVEREXPIRES" );
      chkavIsblocked.setInternalname( "vISBLOCKED" );
      cmbavSecuritypolicyid.setInternalname( "vSECURITYPOLICYID" );
      chkavIsenabledinrepository.setInternalname( "vISENABLEDINREPOSITORY" );
      divIsenabledinrepository_cell_Internalname = "ISENABLEDINREPOSITORY_CELL" ;
      edtavDatelastauthentication_Internalname = "vDATELASTAUTHENTICATION" ;
      divDatelastauthentication_cell_Internalname = "DATELASTAUTHENTICATION_CELL" ;
      chkavEnabletwofactorauthentication.setInternalname( "vENABLETWOFACTORAUTHENTICATION" );
      divEnabletwofactorauthentication_cell_Internalname = "ENABLETWOFACTORAUTHENTICATION_CELL" ;
      edtavOtpnumberlocked_Internalname = "vOTPNUMBERLOCKED" ;
      divOtpnumberlocked_cell_Internalname = "OTPNUMBERLOCKED_CELL" ;
      edtavOtplastlockeddate_Internalname = "vOTPLASTLOCKEDDATE" ;
      divOtplastlockeddate_cell_Internalname = "OTPLASTLOCKEDDATE_CELL" ;
      edtavOtpdailynumbercodes_Internalname = "vOTPDAILYNUMBERCODES" ;
      divOtpdailynumbercodes_cell_Internalname = "OTPDAILYNUMBERCODES_CELL" ;
      edtavOtplastdaterequestcode_Internalname = "vOTPLASTDATEREQUESTCODE" ;
      divOtplastdaterequestcode_cell_Internalname = "OTPLASTDATEREQUESTCODE_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      chkavUser_isenabledinrepository.setInternalname( "USER_ISENABLEDINREPOSITORY" );
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
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
      chkavUser_isenabledinrepository.setVisible( 1 );
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      edtavOtplastdaterequestcode_Jsonclick = "" ;
      edtavOtplastdaterequestcode_Enabled = 1 ;
      edtavOtplastdaterequestcode_Visible = 1 ;
      divOtplastdaterequestcode_cell_Class = "col-xs-12 col-sm-6" ;
      edtavOtpdailynumbercodes_Jsonclick = "" ;
      edtavOtpdailynumbercodes_Enabled = 1 ;
      edtavOtpdailynumbercodes_Visible = 1 ;
      divOtpdailynumbercodes_cell_Class = "col-xs-12 col-sm-6" ;
      edtavOtplastlockeddate_Jsonclick = "" ;
      edtavOtplastlockeddate_Enabled = 1 ;
      edtavOtplastlockeddate_Visible = 1 ;
      divOtplastlockeddate_cell_Class = "col-xs-12 col-sm-6" ;
      edtavOtpnumberlocked_Jsonclick = "" ;
      edtavOtpnumberlocked_Enabled = 1 ;
      edtavOtpnumberlocked_Visible = 1 ;
      divOtpnumberlocked_cell_Class = "col-xs-12 col-sm-6" ;
      chkavEnabletwofactorauthentication.setEnabled( 1 );
      chkavEnabletwofactorauthentication.setVisible( 1 );
      divEnabletwofactorauthentication_cell_Class = "col-xs-12 col-sm-6" ;
      edtavDatelastauthentication_Jsonclick = "" ;
      edtavDatelastauthentication_Enabled = 1 ;
      edtavDatelastauthentication_Visible = 1 ;
      divDatelastauthentication_cell_Class = "col-xs-12 col-sm-6" ;
      chkavIsenabledinrepository.setEnabled( 1 );
      chkavIsenabledinrepository.setVisible( 1 );
      divIsenabledinrepository_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavSecuritypolicyid.setJsonclick( "" );
      cmbavSecuritypolicyid.setEnabled( 1 );
      chkavIsblocked.setEnabled( 1 );
      chkavPasswordneverexpires.setEnabled( 1 );
      chkavMustchangepassword.setEnabled( 1 );
      chkavCannotchangepassword.setEnabled( 1 );
      chkavDontreceiveinformation.setEnabled( 1 );
      bttBtnsendactivationemail_Visible = 1 ;
      edtavActivationdate_Jsonclick = "" ;
      edtavActivationdate_Enabled = 1 ;
      edtavActivationdate_Visible = 1 ;
      divActivationdate_cell_Class = "" ;
      chkavIsactive.setEnabled( 1 );
      chkavIsactive.setVisible( 1 );
      divIsactive_cell_Class = "col-xs-12 col-sm-6" ;
      imgavImage_gximage = "" ;
      imgavImage_Enabled = 0 ;
      imgavImage_Visible = 1 ;
      divImage_cell_Class = "col-xs-12 col-sm-6" ;
      bttBtnurlprofilego_Visible = 1 ;
      edtavUrlprofile_Jsonclick = "" ;
      edtavUrlprofile_Enabled = 1 ;
      edtavUrlprofile_Visible = 1 ;
      divUrlprofile_cell_Class = "" ;
      edtavPhone_Jsonclick = "" ;
      edtavPhone_Enabled = 1 ;
      divPhone_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavGender.setJsonclick( "" );
      cmbavGender.setEnabled( 1 );
      divGender_cell_Class = "col-xs-12 col-sm-6" ;
      edtavBirthday_Jsonclick = "" ;
      edtavBirthday_Enabled = 1 ;
      divBirthday_cell_Class = "col-xs-12 col-sm-6" ;
      edtavExternalid_Jsonclick = "" ;
      edtavExternalid_Enabled = 1 ;
      edtavLastname_Jsonclick = "" ;
      edtavLastname_Enabled = 1 ;
      divLastname_cell_Class = "col-xs-12 col-sm-6" ;
      edtavFirstname_Jsonclick = "" ;
      edtavFirstname_Enabled = 1 ;
      divFirstname_cell_Class = "col-xs-12 col-sm-6" ;
      edtavPasswordconf_Jsonclick = "" ;
      edtavPasswordconf_Enabled = 1 ;
      edtavPasswordconf_Visible = 1 ;
      divPasswordconf_cell_Class = "col-xs-12 col-sm-6" ;
      edtavPassword_Jsonclick = "" ;
      edtavPassword_Enabled = 1 ;
      edtavPassword_Visible = 1 ;
      divPassword_cell_Class = "col-xs-12 col-sm-6" ;
      edtavEmail_Jsonclick = "" ;
      edtavEmail_Enabled = 1 ;
      divEmail_cell_Class = "col-xs-12 col-sm-6" ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      cmbavAuthenticationtypename.setJsonclick( "" );
      cmbavAuthenticationtypename.setEnabled( 1 );
      cmbavAuthenticationtypename.setVisible( 1 );
      divAuthenticationtypename_cell_Class = "col-xs-12 col-sm-6" ;
      edtavUsernamespace_Jsonclick = "" ;
      edtavUsernamespace_Enabled = 1 ;
      edtavUserid_Jsonclick = "" ;
      edtavUserid_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_GAM_User", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "User ", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavAuthenticationtypename.setName( "vAUTHENTICATIONTYPENAME" );
      cmbavAuthenticationtypename.setWebtags( "" );
      if ( cmbavAuthenticationtypename.getItemCount() > 0 )
      {
         AV7AuthenticationTypeName = cmbavAuthenticationtypename.getValidValue(AV7AuthenticationTypeName) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AuthenticationTypeName", AV7AuthenticationTypeName);
      }
      cmbavGender.setName( "vGENDER" );
      cmbavGender.setWebtags( "" );
      cmbavGender.addItem("N", httpContext.getMessage( "WWP_GAM_NotSpecified", ""), (short)(0));
      cmbavGender.addItem("F", httpContext.getMessage( "WWP_GAM_Female", ""), (short)(0));
      cmbavGender.addItem("M", httpContext.getMessage( "WWP_GAM_Male", ""), (short)(0));
      if ( cmbavGender.getItemCount() > 0 )
      {
         AV24Gender = cmbavGender.getValidValue(AV24Gender) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Gender", AV24Gender);
      }
      chkavIsactive.setName( "vISACTIVE" );
      chkavIsactive.setWebtags( "" );
      chkavIsactive.setCaption( httpContext.getMessage( "WWP_GAM_AccountIsActive", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsactive.getInternalname(), "TitleCaption", chkavIsactive.getCaption(), true);
      chkavIsactive.setCheckedValue( "false" );
      AV26IsActive = GXutil.strtobool( GXutil.booltostr( AV26IsActive)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26IsActive", AV26IsActive);
      chkavDontreceiveinformation.setName( "vDONTRECEIVEINFORMATION" );
      chkavDontreceiveinformation.setWebtags( "" );
      chkavDontreceiveinformation.setCaption( httpContext.getMessage( "WWP_GAM_DontReceiveInformation", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavDontreceiveinformation.getInternalname(), "TitleCaption", chkavDontreceiveinformation.getCaption(), true);
      chkavDontreceiveinformation.setCheckedValue( "false" );
      AV15DontReceiveInformation = GXutil.strtobool( GXutil.booltostr( AV15DontReceiveInformation)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15DontReceiveInformation", AV15DontReceiveInformation);
      chkavCannotchangepassword.setName( "vCANNOTCHANGEPASSWORD" );
      chkavCannotchangepassword.setWebtags( "" );
      chkavCannotchangepassword.setCaption( httpContext.getMessage( "WWP_GAM_CannotChangePassword", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCannotchangepassword.getInternalname(), "TitleCaption", chkavCannotchangepassword.getCaption(), true);
      chkavCannotchangepassword.setCheckedValue( "false" );
      AV13CannotChangePassword = GXutil.strtobool( GXutil.booltostr( AV13CannotChangePassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13CannotChangePassword", AV13CannotChangePassword);
      chkavMustchangepassword.setName( "vMUSTCHANGEPASSWORD" );
      chkavMustchangepassword.setWebtags( "" );
      chkavMustchangepassword.setCaption( httpContext.getMessage( "WWP_GAM_Mustchangepassword", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavMustchangepassword.getInternalname(), "TitleCaption", chkavMustchangepassword.getCaption(), true);
      chkavMustchangepassword.setCheckedValue( "false" );
      AV35MustChangePassword = GXutil.strtobool( GXutil.booltostr( AV35MustChangePassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35MustChangePassword", AV35MustChangePassword);
      chkavPasswordneverexpires.setName( "vPASSWORDNEVEREXPIRES" );
      chkavPasswordneverexpires.setWebtags( "" );
      chkavPasswordneverexpires.setCaption( httpContext.getMessage( "WWP_GAM_PasswordNeverExpires", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavPasswordneverexpires.getInternalname(), "TitleCaption", chkavPasswordneverexpires.getCaption(), true);
      chkavPasswordneverexpires.setCheckedValue( "false" );
      AV44PasswordNeverExpires = GXutil.strtobool( GXutil.booltostr( AV44PasswordNeverExpires)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44PasswordNeverExpires", AV44PasswordNeverExpires);
      chkavIsblocked.setName( "vISBLOCKED" );
      chkavIsblocked.setWebtags( "" );
      chkavIsblocked.setCaption( httpContext.getMessage( "WWP_GAM_IsBlocked", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsblocked.getInternalname(), "TitleCaption", chkavIsblocked.getCaption(), true);
      chkavIsblocked.setCheckedValue( "false" );
      AV27IsBlocked = GXutil.strtobool( GXutil.booltostr( AV27IsBlocked)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27IsBlocked", AV27IsBlocked);
      cmbavSecuritypolicyid.setName( "vSECURITYPOLICYID" );
      cmbavSecuritypolicyid.setWebtags( "" );
      if ( cmbavSecuritypolicyid.getItemCount() > 0 )
      {
         AV50SecurityPolicyId = (int)(GXutil.lval( cmbavSecuritypolicyid.getValidValue(GXutil.trim( GXutil.str( AV50SecurityPolicyId, 9, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50SecurityPolicyId), 9, 0));
      }
      chkavIsenabledinrepository.setName( "vISENABLEDINREPOSITORY" );
      chkavIsenabledinrepository.setWebtags( "" );
      chkavIsenabledinrepository.setCaption( httpContext.getMessage( "WWP_GAM_Isenabledinrepository", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsenabledinrepository.getInternalname(), "TitleCaption", chkavIsenabledinrepository.getCaption(), true);
      chkavIsenabledinrepository.setCheckedValue( "false" );
      AV28IsEnabledInRepository = GXutil.strtobool( GXutil.booltostr( AV28IsEnabledInRepository)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28IsEnabledInRepository", AV28IsEnabledInRepository);
      chkavEnabletwofactorauthentication.setName( "vENABLETWOFACTORAUTHENTICATION" );
      chkavEnabletwofactorauthentication.setWebtags( "" );
      chkavEnabletwofactorauthentication.setCaption( httpContext.getMessage( "WWP_GAM_EnableTwoFactorAuthentication", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEnabletwofactorauthentication.getInternalname(), "TitleCaption", chkavEnabletwofactorauthentication.getCaption(), true);
      chkavEnabletwofactorauthentication.setCheckedValue( "false" );
      AV17EnableTwoFactorAuthentication = GXutil.strtobool( GXutil.booltostr( AV17EnableTwoFactorAuthentication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17EnableTwoFactorAuthentication", AV17EnableTwoFactorAuthentication);
      chkavUser_isenabledinrepository.setName( "USER_ISENABLEDINREPOSITORY" );
      chkavUser_isenabledinrepository.setWebtags( "" );
      chkavUser_isenabledinrepository.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavUser_isenabledinrepository.getInternalname(), "TitleCaption", chkavUser_isenabledinrepository.getCaption(), true);
      chkavUser_isenabledinrepository.setCheckedValue( "false" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV26IsActive',fld:'vISACTIVE',pic:''},{av:'AV15DontReceiveInformation',fld:'vDONTRECEIVEINFORMATION',pic:''},{av:'AV13CannotChangePassword',fld:'vCANNOTCHANGEPASSWORD',pic:''},{av:'AV35MustChangePassword',fld:'vMUSTCHANGEPASSWORD',pic:''},{av:'AV44PasswordNeverExpires',fld:'vPASSWORDNEVEREXPIRES',pic:''},{av:'AV27IsBlocked',fld:'vISBLOCKED',pic:''},{av:'AV28IsEnabledInRepository',fld:'vISENABLEDINREPOSITORY',pic:''},{av:'AV17EnableTwoFactorAuthentication',fld:'vENABLETWOFACTORAUTHENTICATION',pic:''},{av:'GXV1',fld:'USER_ISENABLEDINREPOSITORY',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV55UserId',fld:'vUSERID',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNSENDACTIVATIONEMAIL',prop:'Visible'},{ctrl:'BTNURLPROFILEGO',prop:'Visible'}]}");
      setEventMetadata("'DOSENDACTIVATIONEMAIL'","{handler:'e143C2',iparms:[{av:'AV55UserId',fld:'vUSERID',pic:'',hsh:true}]");
      setEventMetadata("'DOSENDACTIVATIONEMAIL'",",oparms:[]}");
      setEventMetadata("'DOURLPROFILEGO'","{handler:'e113C1',iparms:[{av:'AV52URLProfile',fld:'vURLPROFILE',pic:''}]");
      setEventMetadata("'DOURLPROFILEGO'",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e153C2',iparms:[{av:'AV59CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV55UserId',fld:'vUSERID',pic:'',hsh:true},{av:'cmbavAuthenticationtypename'},{av:'AV7AuthenticationTypeName',fld:'vAUTHENTICATIONTYPENAME',pic:''},{av:'AV41Password',fld:'vPASSWORD',pic:''},{av:'AV42PasswordConf',fld:'vPASSWORDCONF',pic:''},{av:'AV36Name',fld:'vNAME',pic:''},{av:'AV16Email',fld:'vEMAIL',pic:''},{av:'AV22FirstName',fld:'vFIRSTNAME',pic:''},{av:'AV31LastName',fld:'vLASTNAME',pic:''},{av:'AV20ExternalId',fld:'vEXTERNALID',pic:''},{av:'AV11Birthday',fld:'vBIRTHDAY',pic:''},{av:'AV45Phone',fld:'vPHONE',pic:''},{av:'cmbavGender'},{av:'AV24Gender',fld:'vGENDER',pic:''},{av:'AV26IsActive',fld:'vISACTIVE',pic:''},{av:'AV46Photo',fld:'vPHOTO',pic:''},{av:'AV52URLProfile',fld:'vURLPROFILE',pic:''},{av:'AV15DontReceiveInformation',fld:'vDONTRECEIVEINFORMATION',pic:''},{av:'AV13CannotChangePassword',fld:'vCANNOTCHANGEPASSWORD',pic:''},{av:'AV35MustChangePassword',fld:'vMUSTCHANGEPASSWORD',pic:''},{av:'AV27IsBlocked',fld:'vISBLOCKED',pic:''},{av:'AV44PasswordNeverExpires',fld:'vPASSWORDNEVEREXPIRES',pic:''},{av:'cmbavSecuritypolicyid'},{av:'AV50SecurityPolicyId',fld:'vSECURITYPOLICYID',pic:'ZZZZZZZZ9'},{av:'AV17EnableTwoFactorAuthentication',fld:'vENABLETWOFACTORAUTHENTICATION',pic:''},{av:'AV28IsEnabledInRepository',fld:'vISENABLEDINREPOSITORY',pic:''},{av:'AV10AuthTypeId',fld:'vAUTHTYPEID',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV10AuthTypeId',fld:'vAUTHTYPEID',pic:''},{av:'AV28IsEnabledInRepository',fld:'vISENABLEDINREPOSITORY',pic:''},{av:'AV41Password',fld:'vPASSWORD',pic:''},{av:'AV59CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''}]}");
      setEventMetadata("VAUTHENTICATIONTYPENAME.ISVALID","{handler:'e163C2',iparms:[{av:'cmbavAuthenticationtypename'},{av:'AV7AuthenticationTypeName',fld:'vAUTHENTICATIONTYPENAME',pic:''},{av:'AV10AuthTypeId',fld:'vAUTHTYPEID',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("VAUTHENTICATIONTYPENAME.ISVALID",",oparms:[{av:'AV10AuthTypeId',fld:'vAUTHTYPEID',pic:''},{av:'cmbavAuthenticationtypename'},{av:'divAuthenticationtypename_cell_Class',ctrl:'AUTHENTICATIONTYPENAME_CELL',prop:'Class'},{av:'divEmail_cell_Class',ctrl:'EMAIL_CELL',prop:'Class'},{av:'edtavPassword_Visible',ctrl:'vPASSWORD',prop:'Visible'},{av:'divPassword_cell_Class',ctrl:'PASSWORD_CELL',prop:'Class'},{av:'edtavPasswordconf_Visible',ctrl:'vPASSWORDCONF',prop:'Visible'},{av:'divPasswordconf_cell_Class',ctrl:'PASSWORDCONF_CELL',prop:'Class'},{av:'divFirstname_cell_Class',ctrl:'FIRSTNAME_CELL',prop:'Class'},{av:'divLastname_cell_Class',ctrl:'LASTNAME_CELL',prop:'Class'},{av:'divBirthday_cell_Class',ctrl:'BIRTHDAY_CELL',prop:'Class'},{av:'divGender_cell_Class',ctrl:'GENDER_CELL',prop:'Class'},{av:'divPhone_cell_Class',ctrl:'PHONE_CELL',prop:'Class'},{av:'imgavImage_Visible',ctrl:'vIMAGE',prop:'Visible'},{av:'divImage_cell_Class',ctrl:'IMAGE_CELL',prop:'Class'},{av:'chkavIsactive.getVisible()',ctrl:'vISACTIVE',prop:'Visible'},{av:'divIsactive_cell_Class',ctrl:'ISACTIVE_CELL',prop:'Class'},{av:'chkavIsenabledinrepository.getVisible()',ctrl:'vISENABLEDINREPOSITORY',prop:'Visible'},{av:'divIsenabledinrepository_cell_Class',ctrl:'ISENABLEDINREPOSITORY_CELL',prop:'Class'},{av:'edtavDatelastauthentication_Visible',ctrl:'vDATELASTAUTHENTICATION',prop:'Visible'},{av:'divDatelastauthentication_cell_Class',ctrl:'DATELASTAUTHENTICATION_CELL',prop:'Class'},{av:'chkavEnabletwofactorauthentication.getVisible()',ctrl:'vENABLETWOFACTORAUTHENTICATION',prop:'Visible'},{av:'divEnabletwofactorauthentication_cell_Class',ctrl:'ENABLETWOFACTORAUTHENTICATION_CELL',prop:'Class'},{av:'edtavOtpnumberlocked_Visible',ctrl:'vOTPNUMBERLOCKED',prop:'Visible'},{av:'divOtpnumberlocked_cell_Class',ctrl:'OTPNUMBERLOCKED_CELL',prop:'Class'},{av:'edtavOtplastlockeddate_Visible',ctrl:'vOTPLASTLOCKEDDATE',prop:'Visible'},{av:'divOtplastlockeddate_cell_Class',ctrl:'OTPLASTLOCKEDDATE_CELL',prop:'Class'},{av:'edtavOtpdailynumbercodes_Visible',ctrl:'vOTPDAILYNUMBERCODES',prop:'Visible'},{av:'divOtpdailynumbercodes_cell_Class',ctrl:'OTPDAILYNUMBERCODES_CELL',prop:'Class'},{av:'edtavOtplastdaterequestcode_Visible',ctrl:'vOTPLASTDATEREQUESTCODE',prop:'Visible'},{av:'divOtplastdaterequestcode_cell_Class',ctrl:'OTPLASTDATEREQUESTCODE_CELL',prop:'Class'},{av:'edtavActivationdate_Visible',ctrl:'vACTIVATIONDATE',prop:'Visible'},{av:'divActivationdate_cell_Class',ctrl:'ACTIVATIONDATE_CELL',prop:'Class'},{av:'edtavUrlprofile_Visible',ctrl:'vURLPROFILE',prop:'Visible'},{av:'divUrlprofile_cell_Class',ctrl:'URLPROFILE_CELL',prop:'Class'}]}");
      setEventMetadata("VALIDV_BIRTHDAY","{handler:'validv_Birthday',iparms:[]");
      setEventMetadata("VALIDV_BIRTHDAY",",oparms:[]}");
      setEventMetadata("VALIDV_GENDER","{handler:'validv_Gender',iparms:[]");
      setEventMetadata("VALIDV_GENDER",",oparms:[]}");
      setEventMetadata("VALIDV_ACTIVATIONDATE","{handler:'validv_Activationdate',iparms:[]");
      setEventMetadata("VALIDV_ACTIVATIONDATE",",oparms:[]}");
      setEventMetadata("VALIDV_DATELASTAUTHENTICATION","{handler:'validv_Datelastauthentication',iparms:[]");
      setEventMetadata("VALIDV_DATELASTAUTHENTICATION",",oparms:[]}");
      setEventMetadata("VALIDV_OTPLASTLOCKEDDATE","{handler:'validv_Otplastlockeddate',iparms:[]");
      setEventMetadata("VALIDV_OTPLASTLOCKEDDATE",",oparms:[]}");
      setEventMetadata("VALIDV_OTPLASTDATEREQUESTCODE","{handler:'validv_Otplastdaterequestcode',iparms:[]");
      setEventMetadata("VALIDV_OTPLASTDATEREQUESTCODE",",oparms:[]}");
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
      return "gamuserentry_Execute";
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
      wcpOGx_mode = "" ;
      wcpOAV55UserId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV55UserId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV46Photo = "" ;
      AV10AuthTypeId = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV56UserNameSpace = "" ;
      AV7AuthenticationTypeName = "" ;
      AV36Name = "" ;
      AV16Email = "" ;
      AV41Password = "" ;
      AV42PasswordConf = "" ;
      AV22FirstName = "" ;
      AV31LastName = "" ;
      AV20ExternalId = "" ;
      AV11Birthday = GXutil.nullDate() ;
      AV24Gender = "" ;
      AV45Phone = "" ;
      lblTextblockurlprofile_Jsonclick = "" ;
      AV52URLProfile = "" ;
      bttBtnurlprofilego_Jsonclick = "" ;
      AV25Image = "" ;
      AV66Image_GXI = "" ;
      sImgUrl = "" ;
      lblTextblockactivationdate_Jsonclick = "" ;
      AV5ActivationDate = GXutil.resetTime( GXutil.nullDate() );
      bttBtnsendactivationemail_Jsonclick = "" ;
      AV14DateLastAuthentication = GXutil.resetTime( GXutil.nullDate() );
      AV39OTPLastLockedDate = GXutil.resetTime( GXutil.nullDate() );
      AV38OTPLastDateRequestCode = GXutil.nullDate() ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      AV53User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV23GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV8AuthenticationTypes = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple>(genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple.class, "GAMAuthenticationTypeSimple", "http://tempuri.org/", remoteHandle);
      AV30Language = "" ;
      AV19Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV9AuthenticationTypesIns = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple(remoteHandle, context);
      AV48SecurityPolicies = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSecurityPolicy>(genexus.security.api.genexussecurity.SdtGAMSecurityPolicy.class, "GAMSecurityPolicy", "http://tempuri.org/", remoteHandle);
      AV21FilterSecPol = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicyFilter(remoteHandle, context);
      AV49SecurityPolicy = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicy(remoteHandle, context);
      AV6AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationType(remoteHandle, context);
      AV47Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV54UserActivationKey = "" ;
      AV32LinkURL = "" ;
      AV34Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      AV33Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV12BlobPhoto = "" ;
      AV18Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamuserentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamuserentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavUserid_Enabled = 0 ;
      edtavUsernamespace_Enabled = 0 ;
      edtavActivationdate_Enabled = 0 ;
      edtavDatelastauthentication_Enabled = 0 ;
      edtavOtpnumberlocked_Enabled = 0 ;
      edtavOtplastlockeddate_Enabled = 0 ;
      edtavOtpdailynumbercodes_Enabled = 0 ;
      edtavOtplastdaterequestcode_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV40OTPNumberLocked ;
   private short AV37OTPDailyNumberCodes ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavUserid_Enabled ;
   private int edtavUsernamespace_Enabled ;
   private int edtavName_Enabled ;
   private int edtavEmail_Enabled ;
   private int edtavPassword_Visible ;
   private int edtavPassword_Enabled ;
   private int edtavPasswordconf_Visible ;
   private int edtavPasswordconf_Enabled ;
   private int edtavFirstname_Enabled ;
   private int edtavLastname_Enabled ;
   private int edtavExternalid_Enabled ;
   private int edtavBirthday_Enabled ;
   private int edtavPhone_Enabled ;
   private int edtavUrlprofile_Visible ;
   private int edtavUrlprofile_Enabled ;
   private int bttBtnurlprofilego_Visible ;
   private int imgavImage_Visible ;
   private int imgavImage_Enabled ;
   private int edtavActivationdate_Visible ;
   private int edtavActivationdate_Enabled ;
   private int bttBtnsendactivationemail_Visible ;
   private int AV50SecurityPolicyId ;
   private int edtavDatelastauthentication_Visible ;
   private int edtavDatelastauthentication_Enabled ;
   private int edtavOtpnumberlocked_Visible ;
   private int edtavOtpnumberlocked_Enabled ;
   private int edtavOtplastlockeddate_Visible ;
   private int edtavOtplastlockeddate_Enabled ;
   private int edtavOtpdailynumbercodes_Visible ;
   private int edtavOtpdailynumbercodes_Enabled ;
   private int edtavOtplastdaterequestcode_Visible ;
   private int edtavOtplastdaterequestcode_Enabled ;
   private int bttBtnenter_Visible ;
   private int AV64GXV2 ;
   private int AV65GXV3 ;
   private int AV67GXV4 ;
   private int AV68GXV5 ;
   private int AV69GXV6 ;
   private int idxLst ;
   private String wcpOGx_mode ;
   private String wcpOAV55UserId ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV55UserId ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV10AuthTypeId ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtavUserid_Internalname ;
   private String edtavUserid_Jsonclick ;
   private String edtavUsernamespace_Internalname ;
   private String TempTags ;
   private String AV56UserNameSpace ;
   private String edtavUsernamespace_Jsonclick ;
   private String divAuthenticationtypename_cell_Internalname ;
   private String divAuthenticationtypename_cell_Class ;
   private String AV7AuthenticationTypeName ;
   private String edtavName_Internalname ;
   private String edtavName_Jsonclick ;
   private String divEmail_cell_Internalname ;
   private String divEmail_cell_Class ;
   private String edtavEmail_Internalname ;
   private String edtavEmail_Jsonclick ;
   private String divPassword_cell_Internalname ;
   private String divPassword_cell_Class ;
   private String edtavPassword_Internalname ;
   private String AV41Password ;
   private String edtavPassword_Jsonclick ;
   private String divPasswordconf_cell_Internalname ;
   private String divPasswordconf_cell_Class ;
   private String edtavPasswordconf_Internalname ;
   private String AV42PasswordConf ;
   private String edtavPasswordconf_Jsonclick ;
   private String divFirstname_cell_Internalname ;
   private String divFirstname_cell_Class ;
   private String edtavFirstname_Internalname ;
   private String AV22FirstName ;
   private String edtavFirstname_Jsonclick ;
   private String divLastname_cell_Internalname ;
   private String divLastname_cell_Class ;
   private String edtavLastname_Internalname ;
   private String AV31LastName ;
   private String edtavLastname_Jsonclick ;
   private String edtavExternalid_Internalname ;
   private String edtavExternalid_Jsonclick ;
   private String divBirthday_cell_Internalname ;
   private String divBirthday_cell_Class ;
   private String edtavBirthday_Internalname ;
   private String edtavBirthday_Jsonclick ;
   private String divGender_cell_Internalname ;
   private String divGender_cell_Class ;
   private String AV24Gender ;
   private String divPhone_cell_Internalname ;
   private String divPhone_cell_Class ;
   private String edtavPhone_Internalname ;
   private String AV45Phone ;
   private String edtavPhone_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String divUrlprofile_cell_Internalname ;
   private String divUrlprofile_cell_Class ;
   private String divUnnamedtableurlprofile_Internalname ;
   private String lblTextblockurlprofile_Internalname ;
   private String lblTextblockurlprofile_Jsonclick ;
   private String edtavUrlprofile_Internalname ;
   private String edtavUrlprofile_Jsonclick ;
   private String bttBtnurlprofilego_Internalname ;
   private String bttBtnurlprofilego_Jsonclick ;
   private String divImage_cell_Internalname ;
   private String divImage_cell_Class ;
   private String imgavImage_Internalname ;
   private String imgavImage_gximage ;
   private String sImgUrl ;
   private String divIsactive_cell_Internalname ;
   private String divIsactive_cell_Class ;
   private String divUnnamedtable2_Internalname ;
   private String divActivationdate_cell_Internalname ;
   private String divActivationdate_cell_Class ;
   private String divUnnamedtableactivationdate_Internalname ;
   private String lblTextblockactivationdate_Internalname ;
   private String lblTextblockactivationdate_Jsonclick ;
   private String edtavActivationdate_Internalname ;
   private String edtavActivationdate_Jsonclick ;
   private String bttBtnsendactivationemail_Internalname ;
   private String bttBtnsendactivationemail_Jsonclick ;
   private String divIsenabledinrepository_cell_Internalname ;
   private String divIsenabledinrepository_cell_Class ;
   private String divDatelastauthentication_cell_Internalname ;
   private String divDatelastauthentication_cell_Class ;
   private String edtavDatelastauthentication_Internalname ;
   private String edtavDatelastauthentication_Jsonclick ;
   private String divEnabletwofactorauthentication_cell_Internalname ;
   private String divEnabletwofactorauthentication_cell_Class ;
   private String divOtpnumberlocked_cell_Internalname ;
   private String divOtpnumberlocked_cell_Class ;
   private String edtavOtpnumberlocked_Internalname ;
   private String edtavOtpnumberlocked_Jsonclick ;
   private String divOtplastlockeddate_cell_Internalname ;
   private String divOtplastlockeddate_cell_Class ;
   private String edtavOtplastlockeddate_Internalname ;
   private String edtavOtplastlockeddate_Jsonclick ;
   private String divOtpdailynumbercodes_cell_Internalname ;
   private String divOtpdailynumbercodes_cell_Class ;
   private String edtavOtpdailynumbercodes_Internalname ;
   private String edtavOtpdailynumbercodes_Jsonclick ;
   private String divOtplastdaterequestcode_cell_Internalname ;
   private String divOtplastdaterequestcode_cell_Class ;
   private String edtavOtplastdaterequestcode_Internalname ;
   private String edtavOtplastdaterequestcode_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV30Language ;
   private String AV54UserActivationKey ;
   private java.util.Date AV5ActivationDate ;
   private java.util.Date AV14DateLastAuthentication ;
   private java.util.Date AV39OTPLastLockedDate ;
   private java.util.Date AV11Birthday ;
   private java.util.Date AV38OTPLastDateRequestCode ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV59CheckRequiredFieldsResult ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean wbLoad ;
   private boolean AV25Image_IsBlob ;
   private boolean AV26IsActive ;
   private boolean AV15DontReceiveInformation ;
   private boolean AV13CannotChangePassword ;
   private boolean AV35MustChangePassword ;
   private boolean AV44PasswordNeverExpires ;
   private boolean AV27IsBlocked ;
   private boolean AV28IsEnabledInRepository ;
   private boolean AV17EnableTwoFactorAuthentication ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV43PasswordIsOK ;
   private boolean AV29isOK ;
   private String AV12BlobPhoto ;
   private String AV36Name ;
   private String AV16Email ;
   private String AV20ExternalId ;
   private String AV52URLProfile ;
   private String AV66Image_GXI ;
   private String AV32LinkURL ;
   private String AV46Photo ;
   private String AV25Image ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationType AV6AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV53User ;
   private HTMLChoice cmbavAuthenticationtypename ;
   private HTMLChoice cmbavGender ;
   private ICheckbox chkavIsactive ;
   private ICheckbox chkavDontreceiveinformation ;
   private ICheckbox chkavCannotchangepassword ;
   private ICheckbox chkavMustchangepassword ;
   private ICheckbox chkavPasswordneverexpires ;
   private ICheckbox chkavIsblocked ;
   private HTMLChoice cmbavSecuritypolicyid ;
   private ICheckbox chkavIsenabledinrepository ;
   private ICheckbox chkavEnabletwofactorauthentication ;
   private ICheckbox chkavUser_isenabledinrepository ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV19Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple> AV8AuthenticationTypes ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSecurityPolicy> AV48SecurityPolicies ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV34Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private com.genexus.SdtMessages_Message AV33Message ;
   private genexus.security.api.genexussecurity.SdtGAMError AV18Error ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple AV9AuthenticationTypesIns ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicyFilter AV21FilterSecPol ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV23GAMRepository ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV47Repository ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicy AV49SecurityPolicy ;
}

final  class gamuserentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public String getDataStoreName( )
   {
      return "GAM";
   }

}

final  class gamuserentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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

