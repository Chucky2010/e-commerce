package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamapplicationentry_impl extends GXDataArea
{
   public gamapplicationentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamapplicationentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamapplicationentry_impl.class ));
   }

   public gamapplicationentry_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavUseabsoluteurlbyenvironment = UIFactory.getCheckbox(this);
      cmbavMainmenu = new HTMLChoice();
      chkavAccessrequirespermission = UIFactory.getCheckbox(this);
      chkavClientallowremoteauth = UIFactory.getCheckbox(this);
      chkavClientallowgetuserroles = UIFactory.getCheckbox(this);
      chkavClientallowgetuseradddata = UIFactory.getCheckbox(this);
      chkavClientallowgetsessioniniprop = UIFactory.getCheckbox(this);
      chkavClientcallbackurliscustom = UIFactory.getCheckbox(this);
      chkavClientallowremoterestauth = UIFactory.getCheckbox(this);
      chkavClientallowgetuserrolesrest = UIFactory.getCheckbox(this);
      chkavClientallowgetuseradddatarest = UIFactory.getCheckbox(this);
      chkavClientallowgetsessioniniproprest = UIFactory.getCheckbox(this);
      chkavClientaccessuniquebyuser = UIFactory.getCheckbox(this);
      chkavSsorestenable = UIFactory.getCheckbox(this);
      cmbavSsorestmode = new HTMLChoice();
      chkavStsprotocolenable = UIFactory.getCheckbox(this);
      cmbavStsmode = new HTMLChoice();
      chkavEnvironmentsecureprotocol = UIFactory.getCheckbox(this);
      chkavAutoregisteranomymoususer = UIFactory.getCheckbox(this);
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
               AV43Id = GXutil.lval( httpContext.GetPar( "Id")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV43Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43Id), 12, 0));
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
      pa2Q2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2Q2( ) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamapplicationentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV43Id,12,0))}, new String[] {"Gx_mode","Id"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Width", GXutil.rtrim( Dvpanel_unnamedtable5_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable5_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable5_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Cls", GXutil.rtrim( Dvpanel_unnamedtable5_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Title", GXutil.rtrim( Dvpanel_unnamedtable5_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable5_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable5_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable5_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable5_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE5_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable5_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Width", GXutil.rtrim( Dvpanel_unnamedtable6_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable6_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable6_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Cls", GXutil.rtrim( Dvpanel_unnamedtable6_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Title", GXutil.rtrim( Dvpanel_unnamedtable6_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable6_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable6_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable6_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable6_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE6_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable6_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Width", GXutil.rtrim( Dvpanel_unnamedtable7_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable7_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable7_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Cls", GXutil.rtrim( Dvpanel_unnamedtable7_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Title", GXutil.rtrim( Dvpanel_unnamedtable7_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable7_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable7_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable7_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable7_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE7_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable7_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Class", GXutil.rtrim( Gxuitabspanel_tabs_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABS_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabs_Historymanagement));
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
         we2Q2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2Q2( ) ;
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
      return formatLink("com.mujermorena.gamapplicationentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV43Id,12,0))}, new String[] {"Gx_mode","Id"})  ;
   }

   public String getPgmname( )
   {
      return "GAMApplicationEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Application", "") ;
   }

   public void wb2Q0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "WWP_GAM_General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable8_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavId_Internalname, httpContext.getMessage( "WWP_GAM_Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavId_Internalname, GXutil.ltrim( localUtil.ntoc( AV43Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV43Id), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV43Id), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavId_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMKeyNumLong", "right", false, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGuid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGuid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGuid_Internalname, GXutil.rtrim( AV41GUID), GXutil.rtrim( localUtil.format( AV41GUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGuid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGuid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV49Name), GXutil.rtrim( localUtil.format( AV49Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDsc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDsc_Internalname, httpContext.getMessage( "WWP_GAM_Description", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV30Dsc), GXutil.rtrim( localUtil.format( AV30Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavVersion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavVersion_Internalname, httpContext.getMessage( "WWP_GAM_Version", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavVersion_Internalname, GXutil.rtrim( AV64Version), GXutil.rtrim( localUtil.format( AV64Version, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavVersion_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavVersion_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCompany_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCompany_Internalname, httpContext.getMessage( "WWP_GAM_Company", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCompany_Internalname, GXutil.rtrim( AV28Company), GXutil.rtrim( localUtil.format( AV28Company, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCompany_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCompany_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCopyright_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCopyright_Internalname, httpContext.getMessage( "WWP_GAM_Copyright", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCopyright_Internalname, GXutil.rtrim( AV29Copyright), GXutil.rtrim( localUtil.format( AV29Copyright, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCopyright_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavCopyright_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUseabsoluteurlbyenvironment.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUseabsoluteurlbyenvironment.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUseabsoluteurlbyenvironment.getInternalname(), GXutil.booltostr( AV61UseAbsoluteUrlByEnvironment), "", " ", 1, chkavUseabsoluteurlbyenvironment.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_UseAbsoluteURLByEnvironment", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(63, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,63);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavHomeobject_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavHomeobject_Internalname, httpContext.getMessage( "WWP_GAM_HomeObject", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavHomeobject_Internalname, AV42HomeObject, GXutil.rtrim( localUtil.format( AV42HomeObject, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavHomeobject_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavHomeobject_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAccountactivationobject_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAccountactivationobject_Internalname, httpContext.getMessage( "WWP_GAM_AccountActivationObject", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAccountactivationobject_Internalname, AV66AccountActivationObject, GXutil.rtrim( localUtil.format( AV66AccountActivationObject, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAccountactivationobject_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAccountactivationobject_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLogoutobject_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavLogoutobject_Internalname, httpContext.getMessage( "WWP_GAM_LocalLogoutObject", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavLogoutobject_Internalname, AV45LogoutObject, GXutil.rtrim( localUtil.format( AV45LogoutObject, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLogoutobject_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavLogoutobject_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMainmenu.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavMainmenu.getInternalname(), httpContext.getMessage( "WWP_GAM_MainMenu", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMainmenu, cmbavMainmenu.getInternalname(), GXutil.trim( GXutil.str( AV46MainMenu, 12, 0)), 1, cmbavMainmenu.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavMainmenu.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "", true, (byte)(0), "HLP_GAMApplicationEntry.htm");
         cmbavMainmenu.setValue( GXutil.trim( GXutil.str( AV46MainMenu, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMainmenu.getInternalname(), "Values", cmbavMainmenu.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedclientrevoked_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclientrevoked_Internalname, httpContext.getMessage( "WWP_GAM_Revoked", ""), "", "", lblTextblockclientrevoked_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_91_2Q2( true) ;
      }
      else
      {
         wb_table1_91_2Q2( false) ;
      }
      return  ;
   }

   public void wb_table1_91_2Q2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAccessrequirespermission.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAccessrequirespermission.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAccessrequirespermission.getInternalname(), GXutil.booltostr( AV5AccessRequiresPermission), "", " ", 1, chkavAccessrequirespermission.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_RequiresPermissions", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(102, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,102);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblRemoteauthentication_title_Internalname, httpContext.getMessage( "WWP_GAM_RemoteAuthentication", ""), "", "", lblRemoteauthentication_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "RemoteAuthentication") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientid_Internalname, httpContext.getMessage( "WWP_GAM_ClientId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientid_Internalname, GXutil.rtrim( AV22ClientId), GXutil.rtrim( localUtil.format( AV22ClientId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMClientApplicationId", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientsecret_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientsecret_Internalname, httpContext.getMessage( "WWP_GAM_ClientSecret", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientsecret_Internalname, GXutil.rtrim( AV27ClientSecret), GXutil.rtrim( localUtil.format( AV27ClientSecret, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientsecret_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientsecret_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMClientApplicationSecret", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable5.setProperty("Width", Dvpanel_unnamedtable5_Width);
         ucDvpanel_unnamedtable5.setProperty("AutoWidth", Dvpanel_unnamedtable5_Autowidth);
         ucDvpanel_unnamedtable5.setProperty("AutoHeight", Dvpanel_unnamedtable5_Autoheight);
         ucDvpanel_unnamedtable5.setProperty("Cls", Dvpanel_unnamedtable5_Cls);
         ucDvpanel_unnamedtable5.setProperty("Title", Dvpanel_unnamedtable5_Title);
         ucDvpanel_unnamedtable5.setProperty("Collapsible", Dvpanel_unnamedtable5_Collapsible);
         ucDvpanel_unnamedtable5.setProperty("Collapsed", Dvpanel_unnamedtable5_Collapsed);
         ucDvpanel_unnamedtable5.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable5_Showcollapseicon);
         ucDvpanel_unnamedtable5.setProperty("IconPosition", Dvpanel_unnamedtable5_Iconposition);
         ucDvpanel_unnamedtable5.setProperty("AutoScroll", Dvpanel_unnamedtable5_Autoscroll);
         ucDvpanel_unnamedtable5.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable5_Internalname, "DVPANEL_UNNAMEDTABLE5Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE5Container"+"UnnamedTable5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable5_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowremoteauth.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowremoteauth.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowremoteauth.getInternalname(), GXutil.booltostr( AV17ClientAllowRemoteAuth), "", " ", 1, chkavClientallowremoteauth.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_AllowRemoteAuthentication", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,127);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblwebauth_Internalname, divTblwebauth_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowgetuserroles.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowgetuserroles.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowgetuserroles.getInternalname(), GXutil.booltostr( AV15ClientAllowGetUserRoles), "", " ", 1, chkavClientallowgetuserroles.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanGetUserRoles", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(135, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,135);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowgetuseradddata.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowgetuseradddata.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowgetuseradddata.getInternalname(), GXutil.booltostr( AV13ClientAllowGetUserAddData), "", " ", 1, chkavClientallowgetuseradddata.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanGetUserAdditionalData", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(140, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,140);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowgetsessioniniprop.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowgetsessioniniprop.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 145,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowgetsessioniniprop.getInternalname(), GXutil.booltostr( AV11ClientAllowGetSessionIniProp), "", " ", 1, chkavClientallowgetsessioniniprop.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanGetSessionInitialProperties", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(145, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,145);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientimageurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientimageurl_Internalname, httpContext.getMessage( "WWP_GAM_ImageUrl	", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 150,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientimageurl_Internalname, AV23ClientImageURL, GXutil.rtrim( localUtil.format( AV23ClientImageURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,150);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientimageurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientimageurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientlocalloginurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientlocalloginurl_Internalname, httpContext.getMessage( "WWP_GAM_LocalLoginURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientlocalloginurl_Internalname, AV24ClientLocalLoginURL, GXutil.rtrim( localUtil.format( AV24ClientLocalLoginURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,155);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientlocalloginurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientlocalloginurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientcallbackurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientcallbackurl_Internalname, httpContext.getMessage( "WWP_GAM_CallbackURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientcallbackurl_Internalname, AV19ClientCallbackURL, GXutil.rtrim( localUtil.format( AV19ClientCallbackURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,160);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientcallbackurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientcallbackurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientcallbackurliscustom.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientcallbackurliscustom.getInternalname(), httpContext.getMessage( "WWP_GAM_CallbackURLIsCustom", ""), " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 165,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientcallbackurliscustom.getInternalname(), GXutil.booltostr( AV20ClientCallbackURLisCustom), "", httpContext.getMessage( "WWP_GAM_CallbackURLIsCustom", ""), 1, chkavClientcallbackurliscustom.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(165, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,165);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientcallbackurlstatename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientcallbackurlstatename_Internalname, httpContext.getMessage( "WWP_GAM_CallbackURLState", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 170,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientcallbackurlstatename_Internalname, GXutil.rtrim( AV65ClientCallbackURLStateName), GXutil.rtrim( localUtil.format( AV65ClientCallbackURLStateName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,170);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientcallbackurlstatename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientcallbackurlstatename_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable6.setProperty("Width", Dvpanel_unnamedtable6_Width);
         ucDvpanel_unnamedtable6.setProperty("AutoWidth", Dvpanel_unnamedtable6_Autowidth);
         ucDvpanel_unnamedtable6.setProperty("AutoHeight", Dvpanel_unnamedtable6_Autoheight);
         ucDvpanel_unnamedtable6.setProperty("Cls", Dvpanel_unnamedtable6_Cls);
         ucDvpanel_unnamedtable6.setProperty("Title", Dvpanel_unnamedtable6_Title);
         ucDvpanel_unnamedtable6.setProperty("Collapsible", Dvpanel_unnamedtable6_Collapsible);
         ucDvpanel_unnamedtable6.setProperty("Collapsed", Dvpanel_unnamedtable6_Collapsed);
         ucDvpanel_unnamedtable6.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable6_Showcollapseicon);
         ucDvpanel_unnamedtable6.setProperty("IconPosition", Dvpanel_unnamedtable6_Iconposition);
         ucDvpanel_unnamedtable6.setProperty("AutoScroll", Dvpanel_unnamedtable6_Autoscroll);
         ucDvpanel_unnamedtable6.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable6_Internalname, "DVPANEL_UNNAMEDTABLE6Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE6Container"+"UnnamedTable6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable6_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowremoterestauth.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowremoterestauth.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 180,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowremoterestauth.getInternalname(), GXutil.booltostr( AV18ClientAllowRemoteRestAuth), "", " ", 1, chkavClientallowremoterestauth.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_AllowAuthenticationV20", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,180);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblrestauth_Internalname, divTblrestauth_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowgetuserrolesrest.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowgetuserrolesrest.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 188,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowgetuserrolesrest.getInternalname(), GXutil.booltostr( AV16ClientAllowGetUserRolesRest), "", " ", 1, chkavClientallowgetuserrolesrest.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanGetUserRoles", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(188, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,188);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowgetuseradddatarest.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowgetuseradddatarest.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 193,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowgetuseradddatarest.getInternalname(), GXutil.booltostr( AV14ClientAllowGetUserAddDataRest), "", " ", 1, chkavClientallowgetuseradddatarest.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanGetUserAdditionalData", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(193, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,193);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientallowgetsessioniniproprest.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientallowgetsessioniniproprest.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 198,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientallowgetsessioniniproprest.getInternalname(), GXutil.booltostr( AV12ClientAllowGetSessionIniPropRest), "", " ", 1, chkavClientallowgetsessioniniproprest.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanGetSessionInitialProperties", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(198, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,198);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblgeneralauth_Internalname, divTblgeneralauth_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable7.setProperty("Width", Dvpanel_unnamedtable7_Width);
         ucDvpanel_unnamedtable7.setProperty("AutoWidth", Dvpanel_unnamedtable7_Autowidth);
         ucDvpanel_unnamedtable7.setProperty("AutoHeight", Dvpanel_unnamedtable7_Autoheight);
         ucDvpanel_unnamedtable7.setProperty("Cls", Dvpanel_unnamedtable7_Cls);
         ucDvpanel_unnamedtable7.setProperty("Title", Dvpanel_unnamedtable7_Title);
         ucDvpanel_unnamedtable7.setProperty("Collapsible", Dvpanel_unnamedtable7_Collapsible);
         ucDvpanel_unnamedtable7.setProperty("Collapsed", Dvpanel_unnamedtable7_Collapsed);
         ucDvpanel_unnamedtable7.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable7_Showcollapseicon);
         ucDvpanel_unnamedtable7.setProperty("IconPosition", Dvpanel_unnamedtable7_Iconposition);
         ucDvpanel_unnamedtable7.setProperty("AutoScroll", Dvpanel_unnamedtable7_Autoscroll);
         ucDvpanel_unnamedtable7.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable7_Internalname, "DVPANEL_UNNAMEDTABLE7Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE7Container"+"UnnamedTable7"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable7_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavClientaccessuniquebyuser.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavClientaccessuniquebyuser.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 211,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavClientaccessuniquebyuser.getInternalname(), GXutil.booltostr( AV8ClientAccessUniqueByUser), "", " ", 1, chkavClientaccessuniquebyuser.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_SingleUserAccess", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(211, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,211);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedclientencryptionkey_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclientencryptionkey_Internalname, httpContext.getMessage( "WWP_GAM_PrivateEncryptionKey", ""), "", "", lblTextblockclientencryptionkey_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table2_219_2Q2( true) ;
      }
      else
      {
         wb_table2_219_2Q2( false) ;
      }
      return  ;
   }

   public void wb_table2_219_2Q2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavClientrepositoryguid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientrepositoryguid_Internalname, httpContext.getMessage( "WWP_GAM_RepositoryGUID", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 230,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientrepositoryguid_Internalname, GXutil.rtrim( AV25ClientRepositoryGUID), GXutil.rtrim( localUtil.format( AV25ClientRepositoryGUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,230);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientrepositoryguid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientrepositoryguid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMApplicationEntry.htm");
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblSsorest_title_Internalname, httpContext.getMessage( "WWP_GAM_SSORest", ""), "", "", lblSsorest_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "SSORest") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavSsorestenable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavSsorestenable.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 240,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSsorestenable.getInternalname(), GXutil.booltostr( AV50SSORestEnable), "", " ", 1, chkavSsorestenable.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_EnableSSORestServices", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,240);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablessorest_Internalname, divTablessorest_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSsorestmode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavSsorestmode.getInternalname(), httpContext.getMessage( "WWP_GAM_ModeSSORest", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 248,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSsorestmode, cmbavSsorestmode.getInternalname(), GXutil.rtrim( AV51SSORestMode), 1, cmbavSsorestmode.getJsonclick(), 7, "'"+""+"'"+",false,"+"'"+"e112q1_client"+"'", "char", "", 1, cmbavSsorestmode.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,248);\"", "", true, (byte)(0), "HLP_GAMApplicationEntry.htm");
         cmbavSsorestmode.setValue( GXutil.rtrim( AV51SSORestMode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSsorestmode.getInternalname(), "Values", cmbavSsorestmode.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblssorestmodeclient_Internalname, divTblssorestmodeclient_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSsorestuserauthtypename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSsorestuserauthtypename_Internalname, httpContext.getMessage( "WWP_GAM_UserAuthenticationTypeNameInServer", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSsorestuserauthtypename_Internalname, GXutil.rtrim( AV53SSORestUserAuthTypeName), GXutil.rtrim( localUtil.format( AV53SSORestUserAuthTypeName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,256);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSsorestuserauthtypename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSsorestuserauthtypename_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMAuthenticationTypeName", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSsorestserverurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSsorestserverurl_Internalname, httpContext.getMessage( "WWP_GAM_ServerURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 261,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSsorestserverurl_Internalname, AV52SSORestServerURL, GXutil.rtrim( localUtil.format( AV52SSORestServerURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,261);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSsorestserverurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSsorestserverurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
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
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblSts_title_Internalname, httpContext.getMessage( "WWP_GAM_STS", ""), "", "", lblSts_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "STS") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavStsprotocolenable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavStsprotocolenable.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 271,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavStsprotocolenable.getInternalname(), GXutil.booltostr( AV57STSProtocolEnable), "", " ", 1, chkavStsprotocolenable.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_EnableSTSProtocol", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,271);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablests_Internalname, divTablests_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavStsmode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavStsmode.getInternalname(), httpContext.getMessage( "WWP_GAM_STSMode", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 279,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavStsmode, cmbavStsmode.getInternalname(), GXutil.rtrim( AV56STSMode), 1, cmbavStsmode.getJsonclick(), 7, "'"+""+"'"+",false,"+"'"+"e122q1_client"+"'", "char", "", 1, cmbavStsmode.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,279);\"", "", true, (byte)(0), "HLP_GAMApplicationEntry.htm");
         cmbavStsmode.setValue( GXutil.rtrim( AV56STSMode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavStsmode.getInternalname(), "Values", cmbavStsmode.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablestsserverchecktoken_Internalname, divTablestsserverchecktoken_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavStsauthorizationusername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavStsauthorizationusername_Internalname, httpContext.getMessage( "WWP_GAM_UserName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 287,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavStsauthorizationusername_Internalname, AV55STSAuthorizationUserName, GXutil.rtrim( localUtil.format( AV55STSAuthorizationUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,287);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavStsauthorizationusername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavStsauthorizationusername_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMUserIdentification", "left", true, "", "HLP_GAMApplicationEntry.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divStsserverclientpassword_cell_Internalname, 1, 0, "px", 0, "px", divStsserverclientpassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavStsserverclientpassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavStsserverclientpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavStsserverclientpassword_Internalname, httpContext.getMessage( "WWP_GAM_ClientPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 292,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavStsserverclientpassword_Internalname, GXutil.rtrim( AV58STSServerClientPassword), GXutil.rtrim( localUtil.format( AV58STSServerClientPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,292);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavStsserverclientpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavStsserverclientpassword_Visible, edtavStsserverclientpassword_Enabled, 1, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablestsclient_Internalname, divTablestsclient_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavStsserverurl_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavStsserverurl_Internalname, httpContext.getMessage( "WWP_GAM_ServerURL", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 300,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavStsserverurl_Internalname, AV60STSServerURL, GXutil.rtrim( localUtil.format( AV60STSServerURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,300);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavStsserverurl_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavStsserverurl_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavStsserverrepositoryguid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavStsserverrepositoryguid_Internalname, httpContext.getMessage( "WWP_GAM_RepositoryGUID", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 305,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavStsserverrepositoryguid_Internalname, GXutil.rtrim( AV59STSServerRepositoryGUID), GXutil.rtrim( localUtil.format( AV59STSServerRepositoryGUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,305);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavStsserverrepositoryguid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavStsserverrepositoryguid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMApplicationEntry.htm");
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
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblEnvironmentsettings_title_Internalname, httpContext.getMessage( "WWP_GAM_EnvironmentSettings", ""), "", "", lblEnvironmentsettings_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMApplicationEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "EnvironmentSettings") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEnvironmentname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEnvironmentname_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 315,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEnvironmentname_Internalname, GXutil.rtrim( AV32EnvironmentName), GXutil.rtrim( localUtil.format( AV32EnvironmentName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,315);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEnvironmentname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEnvironmentname_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEnvironmentsecureprotocol.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEnvironmentsecureprotocol.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 320,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEnvironmentsecureprotocol.getInternalname(), GXutil.booltostr( AV36EnvironmentSecureProtocol), "", " ", 1, chkavEnvironmentsecureprotocol.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IsHttps", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(320, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,320);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEnvironmenthost_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEnvironmenthost_Internalname, httpContext.getMessage( "WWP_GAM_Host", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 325,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEnvironmenthost_Internalname, GXutil.rtrim( AV31EnvironmentHost), GXutil.rtrim( localUtil.format( AV31EnvironmentHost, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,325);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEnvironmenthost_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEnvironmenthost_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEnvironmentport_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEnvironmentport_Internalname, httpContext.getMessage( "WWP_GAM_Port", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 330,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEnvironmentport_Internalname, GXutil.ltrim( localUtil.ntoc( AV33EnvironmentPort, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV33EnvironmentPort), "ZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,330);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEnvironmentport_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEnvironmentport_Enabled, 1, "text", "1", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEnvironmentvirtualdirectory_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEnvironmentvirtualdirectory_Internalname, httpContext.getMessage( "WWP_GAM_VirtualDirectory", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 335,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEnvironmentvirtualdirectory_Internalname, GXutil.rtrim( AV37EnvironmentVirtualDirectory), GXutil.rtrim( localUtil.format( AV37EnvironmentVirtualDirectory, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,335);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEnvironmentvirtualdirectory_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEnvironmentvirtualdirectory_Enabled, 1, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEnvironmentprogrampackage_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEnvironmentprogrampackage_Internalname, httpContext.getMessage( "WWP_GAM_Package", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 340,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEnvironmentprogrampackage_Internalname, GXutil.rtrim( AV35EnvironmentProgramPackage), GXutil.rtrim( localUtil.format( AV35EnvironmentProgramPackage, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,340);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEnvironmentprogrampackage_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEnvironmentprogrampackage_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEnvironmentprogramextension_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEnvironmentprogramextension_Internalname, httpContext.getMessage( "WWP_GAM_Extension", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 345,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEnvironmentprogramextension_Internalname, GXutil.rtrim( AV34EnvironmentProgramExtension), GXutil.rtrim( localUtil.format( AV34EnvironmentProgramExtension, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,345);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEnvironmentprogramextension_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEnvironmentprogramextension_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMApplicationEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 350,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 352,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMApplicationEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 356,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAutoregisteranomymoususer.getInternalname(), GXutil.booltostr( AV7AutoRegisterAnomymousUser), "", "", chkavAutoregisteranomymoususer.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(356, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,356);\"");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 357,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavStsauthorizationuserguid_Internalname, GXutil.rtrim( AV54STSAuthorizationUserGUID), GXutil.rtrim( localUtil.format( AV54STSAuthorizationUserGUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,357);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavStsauthorizationuserguid_Jsonclick, 0, "Attribute", "", "", "", "", edtavStsauthorizationuserguid_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start2Q2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Application", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2Q0( ) ;
   }

   public void ws2Q2( )
   {
      start2Q2( ) ;
      evt2Q2( ) ;
   }

   public void evt2Q2( )
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
                           e132Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENERATEKEYGAMREMOTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGenerateKeyGAMRemote' */
                           e142Q2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOREVOKEALLOW'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoRevokeAllow' */
                           e152Q2 ();
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
                                 e162Q2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e172Q2 ();
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

   public void we2Q2( )
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

   public void pa2Q2( )
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
            GX_FocusControl = edtavGuid_Internalname ;
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
      AV61UseAbsoluteUrlByEnvironment = GXutil.strtobool( GXutil.booltostr( AV61UseAbsoluteUrlByEnvironment)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61UseAbsoluteUrlByEnvironment", AV61UseAbsoluteUrlByEnvironment);
      if ( cmbavMainmenu.getItemCount() > 0 )
      {
         AV46MainMenu = GXutil.lval( cmbavMainmenu.getValidValue(GXutil.trim( GXutil.str( AV46MainMenu, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MainMenu", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MainMenu), 12, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMainmenu.setValue( GXutil.trim( GXutil.str( AV46MainMenu, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMainmenu.getInternalname(), "Values", cmbavMainmenu.ToJavascriptSource(), true);
      }
      AV5AccessRequiresPermission = GXutil.strtobool( GXutil.booltostr( AV5AccessRequiresPermission)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AccessRequiresPermission", AV5AccessRequiresPermission);
      AV17ClientAllowRemoteAuth = GXutil.strtobool( GXutil.booltostr( AV17ClientAllowRemoteAuth)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ClientAllowRemoteAuth", AV17ClientAllowRemoteAuth);
      AV15ClientAllowGetUserRoles = GXutil.strtobool( GXutil.booltostr( AV15ClientAllowGetUserRoles)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15ClientAllowGetUserRoles", AV15ClientAllowGetUserRoles);
      AV13ClientAllowGetUserAddData = GXutil.strtobool( GXutil.booltostr( AV13ClientAllowGetUserAddData)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13ClientAllowGetUserAddData", AV13ClientAllowGetUserAddData);
      AV11ClientAllowGetSessionIniProp = GXutil.strtobool( GXutil.booltostr( AV11ClientAllowGetSessionIniProp)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11ClientAllowGetSessionIniProp", AV11ClientAllowGetSessionIniProp);
      AV20ClientCallbackURLisCustom = GXutil.strtobool( GXutil.booltostr( AV20ClientCallbackURLisCustom)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ClientCallbackURLisCustom", AV20ClientCallbackURLisCustom);
      AV18ClientAllowRemoteRestAuth = GXutil.strtobool( GXutil.booltostr( AV18ClientAllowRemoteRestAuth)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ClientAllowRemoteRestAuth", AV18ClientAllowRemoteRestAuth);
      AV16ClientAllowGetUserRolesRest = GXutil.strtobool( GXutil.booltostr( AV16ClientAllowGetUserRolesRest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ClientAllowGetUserRolesRest", AV16ClientAllowGetUserRolesRest);
      AV14ClientAllowGetUserAddDataRest = GXutil.strtobool( GXutil.booltostr( AV14ClientAllowGetUserAddDataRest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ClientAllowGetUserAddDataRest", AV14ClientAllowGetUserAddDataRest);
      AV12ClientAllowGetSessionIniPropRest = GXutil.strtobool( GXutil.booltostr( AV12ClientAllowGetSessionIniPropRest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12ClientAllowGetSessionIniPropRest", AV12ClientAllowGetSessionIniPropRest);
      AV8ClientAccessUniqueByUser = GXutil.strtobool( GXutil.booltostr( AV8ClientAccessUniqueByUser)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8ClientAccessUniqueByUser", AV8ClientAccessUniqueByUser);
      AV50SSORestEnable = GXutil.strtobool( GXutil.booltostr( AV50SSORestEnable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50SSORestEnable", AV50SSORestEnable);
      if ( cmbavSsorestmode.getItemCount() > 0 )
      {
         AV51SSORestMode = cmbavSsorestmode.getValidValue(AV51SSORestMode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51SSORestMode", AV51SSORestMode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSsorestmode.setValue( GXutil.rtrim( AV51SSORestMode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSsorestmode.getInternalname(), "Values", cmbavSsorestmode.ToJavascriptSource(), true);
      }
      AV57STSProtocolEnable = GXutil.strtobool( GXutil.booltostr( AV57STSProtocolEnable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57STSProtocolEnable", AV57STSProtocolEnable);
      if ( cmbavStsmode.getItemCount() > 0 )
      {
         AV56STSMode = cmbavStsmode.getValidValue(AV56STSMode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56STSMode", AV56STSMode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavStsmode.setValue( GXutil.rtrim( AV56STSMode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavStsmode.getInternalname(), "Values", cmbavStsmode.ToJavascriptSource(), true);
      }
      AV36EnvironmentSecureProtocol = GXutil.strtobool( GXutil.booltostr( AV36EnvironmentSecureProtocol)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36EnvironmentSecureProtocol", AV36EnvironmentSecureProtocol);
      AV7AutoRegisterAnomymousUser = GXutil.strtobool( GXutil.booltostr( AV7AutoRegisterAnomymousUser)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7AutoRegisterAnomymousUser", AV7AutoRegisterAnomymousUser);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2Q2( ) ;
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
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), true);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
      edtavClientrevoked_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClientrevoked_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientrevoked_Enabled), 5, 0), true);
   }

   public void rf2Q2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e172Q2 ();
         wb2Q0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2Q2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavId_Enabled), 5, 0), true);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
      edtavClientrevoked_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClientrevoked_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientrevoked_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup2Q0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e132Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Dvpanel_unnamedtable5_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Width") ;
         Dvpanel_unnamedtable5_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Autowidth")) ;
         Dvpanel_unnamedtable5_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Autoheight")) ;
         Dvpanel_unnamedtable5_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Cls") ;
         Dvpanel_unnamedtable5_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Title") ;
         Dvpanel_unnamedtable5_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Collapsible")) ;
         Dvpanel_unnamedtable5_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Collapsed")) ;
         Dvpanel_unnamedtable5_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Showcollapseicon")) ;
         Dvpanel_unnamedtable5_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Iconposition") ;
         Dvpanel_unnamedtable5_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE5_Autoscroll")) ;
         Dvpanel_unnamedtable6_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Width") ;
         Dvpanel_unnamedtable6_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Autowidth")) ;
         Dvpanel_unnamedtable6_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Autoheight")) ;
         Dvpanel_unnamedtable6_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Cls") ;
         Dvpanel_unnamedtable6_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Title") ;
         Dvpanel_unnamedtable6_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Collapsible")) ;
         Dvpanel_unnamedtable6_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Collapsed")) ;
         Dvpanel_unnamedtable6_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Showcollapseicon")) ;
         Dvpanel_unnamedtable6_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Iconposition") ;
         Dvpanel_unnamedtable6_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE6_Autoscroll")) ;
         Dvpanel_unnamedtable7_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Width") ;
         Dvpanel_unnamedtable7_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Autowidth")) ;
         Dvpanel_unnamedtable7_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Autoheight")) ;
         Dvpanel_unnamedtable7_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Cls") ;
         Dvpanel_unnamedtable7_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Title") ;
         Dvpanel_unnamedtable7_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Collapsible")) ;
         Dvpanel_unnamedtable7_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Collapsed")) ;
         Dvpanel_unnamedtable7_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Showcollapseicon")) ;
         Dvpanel_unnamedtable7_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Iconposition") ;
         Dvpanel_unnamedtable7_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE7_Autoscroll")) ;
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         /* Read variables values. */
         AV43Id = localUtil.ctol( httpContext.cgiGet( edtavId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43Id), 12, 0));
         AV41GUID = httpContext.cgiGet( edtavGuid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41GUID", AV41GUID);
         AV49Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49Name", AV49Name);
         AV30Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Dsc", AV30Dsc);
         AV64Version = httpContext.cgiGet( edtavVersion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64Version", AV64Version);
         AV28Company = httpContext.cgiGet( edtavCompany_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Company", AV28Company);
         AV29Copyright = httpContext.cgiGet( edtavCopyright_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Copyright", AV29Copyright);
         AV61UseAbsoluteUrlByEnvironment = GXutil.strtobool( httpContext.cgiGet( chkavUseabsoluteurlbyenvironment.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV61UseAbsoluteUrlByEnvironment", AV61UseAbsoluteUrlByEnvironment);
         AV42HomeObject = httpContext.cgiGet( edtavHomeobject_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42HomeObject", AV42HomeObject);
         AV66AccountActivationObject = httpContext.cgiGet( edtavAccountactivationobject_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66AccountActivationObject", AV66AccountActivationObject);
         AV45LogoutObject = httpContext.cgiGet( edtavLogoutobject_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45LogoutObject", AV45LogoutObject);
         cmbavMainmenu.setValue( httpContext.cgiGet( cmbavMainmenu.getInternalname()) );
         AV46MainMenu = GXutil.lval( httpContext.cgiGet( cmbavMainmenu.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MainMenu", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MainMenu), 12, 0));
         if ( localUtil.vcdtime( httpContext.cgiGet( edtavClientrevoked_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vCLIENTREVOKED");
            GX_FocusControl = edtavClientrevoked_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV26ClientRevoked = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "AV26ClientRevoked", localUtil.ttoc( AV26ClientRevoked, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            AV26ClientRevoked = localUtil.ctot( httpContext.cgiGet( edtavClientrevoked_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ClientRevoked", localUtil.ttoc( AV26ClientRevoked, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         AV5AccessRequiresPermission = GXutil.strtobool( httpContext.cgiGet( chkavAccessrequirespermission.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AccessRequiresPermission", AV5AccessRequiresPermission);
         AV22ClientId = httpContext.cgiGet( edtavClientid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22ClientId", AV22ClientId);
         AV27ClientSecret = httpContext.cgiGet( edtavClientsecret_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ClientSecret", AV27ClientSecret);
         AV17ClientAllowRemoteAuth = GXutil.strtobool( httpContext.cgiGet( chkavClientallowremoteauth.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17ClientAllowRemoteAuth", AV17ClientAllowRemoteAuth);
         AV15ClientAllowGetUserRoles = GXutil.strtobool( httpContext.cgiGet( chkavClientallowgetuserroles.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15ClientAllowGetUserRoles", AV15ClientAllowGetUserRoles);
         AV13ClientAllowGetUserAddData = GXutil.strtobool( httpContext.cgiGet( chkavClientallowgetuseradddata.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ClientAllowGetUserAddData", AV13ClientAllowGetUserAddData);
         AV11ClientAllowGetSessionIniProp = GXutil.strtobool( httpContext.cgiGet( chkavClientallowgetsessioniniprop.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11ClientAllowGetSessionIniProp", AV11ClientAllowGetSessionIniProp);
         AV23ClientImageURL = httpContext.cgiGet( edtavClientimageurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ClientImageURL", AV23ClientImageURL);
         AV24ClientLocalLoginURL = httpContext.cgiGet( edtavClientlocalloginurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ClientLocalLoginURL", AV24ClientLocalLoginURL);
         AV19ClientCallbackURL = httpContext.cgiGet( edtavClientcallbackurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19ClientCallbackURL", AV19ClientCallbackURL);
         AV20ClientCallbackURLisCustom = GXutil.strtobool( httpContext.cgiGet( chkavClientcallbackurliscustom.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ClientCallbackURLisCustom", AV20ClientCallbackURLisCustom);
         AV65ClientCallbackURLStateName = httpContext.cgiGet( edtavClientcallbackurlstatename_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ClientCallbackURLStateName", AV65ClientCallbackURLStateName);
         AV18ClientAllowRemoteRestAuth = GXutil.strtobool( httpContext.cgiGet( chkavClientallowremoterestauth.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18ClientAllowRemoteRestAuth", AV18ClientAllowRemoteRestAuth);
         AV16ClientAllowGetUserRolesRest = GXutil.strtobool( httpContext.cgiGet( chkavClientallowgetuserrolesrest.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16ClientAllowGetUserRolesRest", AV16ClientAllowGetUserRolesRest);
         AV14ClientAllowGetUserAddDataRest = GXutil.strtobool( httpContext.cgiGet( chkavClientallowgetuseradddatarest.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14ClientAllowGetUserAddDataRest", AV14ClientAllowGetUserAddDataRest);
         AV12ClientAllowGetSessionIniPropRest = GXutil.strtobool( httpContext.cgiGet( chkavClientallowgetsessioniniproprest.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12ClientAllowGetSessionIniPropRest", AV12ClientAllowGetSessionIniPropRest);
         AV8ClientAccessUniqueByUser = GXutil.strtobool( httpContext.cgiGet( chkavClientaccessuniquebyuser.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ClientAccessUniqueByUser", AV8ClientAccessUniqueByUser);
         AV21ClientEncryptionKey = httpContext.cgiGet( edtavClientencryptionkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ClientEncryptionKey", AV21ClientEncryptionKey);
         AV25ClientRepositoryGUID = httpContext.cgiGet( edtavClientrepositoryguid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ClientRepositoryGUID", AV25ClientRepositoryGUID);
         AV50SSORestEnable = GXutil.strtobool( httpContext.cgiGet( chkavSsorestenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50SSORestEnable", AV50SSORestEnable);
         cmbavSsorestmode.setValue( httpContext.cgiGet( cmbavSsorestmode.getInternalname()) );
         AV51SSORestMode = httpContext.cgiGet( cmbavSsorestmode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51SSORestMode", AV51SSORestMode);
         AV53SSORestUserAuthTypeName = httpContext.cgiGet( edtavSsorestuserauthtypename_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53SSORestUserAuthTypeName", AV53SSORestUserAuthTypeName);
         AV52SSORestServerURL = httpContext.cgiGet( edtavSsorestserverurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52SSORestServerURL", AV52SSORestServerURL);
         AV57STSProtocolEnable = GXutil.strtobool( httpContext.cgiGet( chkavStsprotocolenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57STSProtocolEnable", AV57STSProtocolEnable);
         cmbavStsmode.setValue( httpContext.cgiGet( cmbavStsmode.getInternalname()) );
         AV56STSMode = httpContext.cgiGet( cmbavStsmode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56STSMode", AV56STSMode);
         AV55STSAuthorizationUserName = httpContext.cgiGet( edtavStsauthorizationusername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55STSAuthorizationUserName", AV55STSAuthorizationUserName);
         AV58STSServerClientPassword = httpContext.cgiGet( edtavStsserverclientpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58STSServerClientPassword", AV58STSServerClientPassword);
         AV60STSServerURL = httpContext.cgiGet( edtavStsserverurl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60STSServerURL", AV60STSServerURL);
         AV59STSServerRepositoryGUID = httpContext.cgiGet( edtavStsserverrepositoryguid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59STSServerRepositoryGUID", AV59STSServerRepositoryGUID);
         AV32EnvironmentName = httpContext.cgiGet( edtavEnvironmentname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32EnvironmentName", AV32EnvironmentName);
         AV36EnvironmentSecureProtocol = GXutil.strtobool( httpContext.cgiGet( chkavEnvironmentsecureprotocol.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36EnvironmentSecureProtocol", AV36EnvironmentSecureProtocol);
         AV31EnvironmentHost = httpContext.cgiGet( edtavEnvironmenthost_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31EnvironmentHost", AV31EnvironmentHost);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEnvironmentport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEnvironmentport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vENVIRONMENTPORT");
            GX_FocusControl = edtavEnvironmentport_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV33EnvironmentPort = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33EnvironmentPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33EnvironmentPort), 5, 0));
         }
         else
         {
            AV33EnvironmentPort = (int)(localUtil.ctol( httpContext.cgiGet( edtavEnvironmentport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33EnvironmentPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33EnvironmentPort), 5, 0));
         }
         AV37EnvironmentVirtualDirectory = httpContext.cgiGet( edtavEnvironmentvirtualdirectory_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37EnvironmentVirtualDirectory", AV37EnvironmentVirtualDirectory);
         AV35EnvironmentProgramPackage = httpContext.cgiGet( edtavEnvironmentprogrampackage_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35EnvironmentProgramPackage", AV35EnvironmentProgramPackage);
         AV34EnvironmentProgramExtension = httpContext.cgiGet( edtavEnvironmentprogramextension_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34EnvironmentProgramExtension", AV34EnvironmentProgramExtension);
         AV7AutoRegisterAnomymousUser = GXutil.strtobool( httpContext.cgiGet( chkavAutoregisteranomymoususer.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AutoRegisterAnomymousUser", AV7AutoRegisterAnomymousUser);
         AV54STSAuthorizationUserGUID = httpContext.cgiGet( edtavStsauthorizationuserguid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54STSAuthorizationUserGUID", AV54STSAuthorizationUserGUID);
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
      e132Q2 ();
      if (returnInSub) return;
   }

   public void e132Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavStsauthorizationuserguid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavStsauthorizationuserguid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsauthorizationuserguid_Visible), 5, 0), true);
      chkavAutoregisteranomymoususer.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavAutoregisteranomymoususer.getInternalname(), "Visible", GXutil.ltrimstr( chkavAutoregisteranomymoususer.getVisible(), 5, 0), true);
      AV62User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         AV6Application.load(AV43Id);
         AV43Id = AV6Application.getgxTv_SdtGAMApplication_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43Id), 12, 0));
         AV41GUID = AV6Application.getgxTv_SdtGAMApplication_Guid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41GUID", AV41GUID);
         AV49Name = AV6Application.getgxTv_SdtGAMApplication_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49Name", AV49Name);
         AV30Dsc = AV6Application.getgxTv_SdtGAMApplication_Description() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Dsc", AV30Dsc);
         AV64Version = AV6Application.getgxTv_SdtGAMApplication_Version() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64Version", AV64Version);
         AV29Copyright = AV6Application.getgxTv_SdtGAMApplication_Copyright() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Copyright", AV29Copyright);
         AV28Company = AV6Application.getgxTv_SdtGAMApplication_Companyname() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Company", AV28Company);
         AV61UseAbsoluteUrlByEnvironment = AV6Application.getgxTv_SdtGAMApplication_Useabsoluteurlbyenvironment() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV61UseAbsoluteUrlByEnvironment", AV61UseAbsoluteUrlByEnvironment);
         AV42HomeObject = AV6Application.getgxTv_SdtGAMApplication_Homeobject() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42HomeObject", AV42HomeObject);
         AV66AccountActivationObject = AV6Application.getgxTv_SdtGAMApplication_Accountactivationobject() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66AccountActivationObject", AV66AccountActivationObject);
         AV45LogoutObject = AV6Application.getgxTv_SdtGAMApplication_Logoutobject() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45LogoutObject", AV45LogoutObject);
         cmbavMainmenu.addItem("0", httpContext.getMessage( "(none)", ""), (short)(0));
         AV73GXV2 = 1 ;
         GXv_objcol_SdtGAMError1[0] = AV39Errors ;
         AV72GXV1 = AV6Application.getmenus(AV48MenuFilter, GXv_objcol_SdtGAMError1) ;
         AV39Errors = GXv_objcol_SdtGAMError1[0] ;
         while ( AV73GXV2 <= AV72GXV1.size() )
         {
            AV47Menu = (genexus.security.api.genexussecurity.SdtGAMApplicationMenu)((genexus.security.api.genexussecurity.SdtGAMApplicationMenu)AV72GXV1.elementAt(-1+AV73GXV2));
            cmbavMainmenu.addItem(GXutil.trim( GXutil.str( AV47Menu.getgxTv_SdtGAMApplicationMenu_Id(), 12, 0)), AV47Menu.getgxTv_SdtGAMApplicationMenu_Name(), (short)(0));
            AV73GXV2 = (int)(AV73GXV2+1) ;
         }
         AV46MainMenu = AV6Application.getgxTv_SdtGAMApplication_Mainmenuid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MainMenu", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MainMenu), 12, 0));
         AV5AccessRequiresPermission = AV6Application.getgxTv_SdtGAMApplication_Accessrequirespermission() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AccessRequiresPermission", AV5AccessRequiresPermission);
         AV7AutoRegisterAnomymousUser = AV6Application.getgxTv_SdtGAMApplication_Clientautoregisteranomymoususer() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AutoRegisterAnomymousUser", AV7AutoRegisterAnomymousUser);
         AV22ClientId = AV6Application.getgxTv_SdtGAMApplication_Clientid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22ClientId", AV22ClientId);
         AV27ClientSecret = AV6Application.getgxTv_SdtGAMApplication_Clientsecret() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ClientSecret", AV27ClientSecret);
         AV8ClientAccessUniqueByUser = AV6Application.getgxTv_SdtGAMApplication_Clientaccessuniquebyuser() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ClientAccessUniqueByUser", AV8ClientAccessUniqueByUser);
         AV26ClientRevoked = AV6Application.getgxTv_SdtGAMApplication_Clientrevoked() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ClientRevoked", localUtil.ttoc( AV26ClientRevoked, 10, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         AV17ClientAllowRemoteAuth = AV6Application.getgxTv_SdtGAMApplication_Clientallowremoteauthentication() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17ClientAllowRemoteAuth", AV17ClientAllowRemoteAuth);
         AV15ClientAllowGetUserRoles = AV6Application.getgxTv_SdtGAMApplication_Clientallowgetuserroles() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15ClientAllowGetUserRoles", AV15ClientAllowGetUserRoles);
         AV13ClientAllowGetUserAddData = AV6Application.getgxTv_SdtGAMApplication_Clientallowgetuseradditionaldata() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ClientAllowGetUserAddData", AV13ClientAllowGetUserAddData);
         AV11ClientAllowGetSessionIniProp = AV6Application.getgxTv_SdtGAMApplication_Clientallowgetsessioninitialproperties() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11ClientAllowGetSessionIniProp", AV11ClientAllowGetSessionIniProp);
         AV23ClientImageURL = AV6Application.getgxTv_SdtGAMApplication_Clientimageurl() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ClientImageURL", AV23ClientImageURL);
         AV24ClientLocalLoginURL = AV6Application.getgxTv_SdtGAMApplication_Clientlocalloginurl() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24ClientLocalLoginURL", AV24ClientLocalLoginURL);
         AV19ClientCallbackURL = AV6Application.getgxTv_SdtGAMApplication_Clientcallbackurl() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19ClientCallbackURL", AV19ClientCallbackURL);
         AV20ClientCallbackURLisCustom = AV6Application.getgxTv_SdtGAMApplication_Clientcallbackurliscustom() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20ClientCallbackURLisCustom", AV20ClientCallbackURLisCustom);
         AV65ClientCallbackURLStateName = AV6Application.getgxTv_SdtGAMApplication_Clientcallbackurlstatename() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65ClientCallbackURLStateName", AV65ClientCallbackURLStateName);
         AV18ClientAllowRemoteRestAuth = AV6Application.getgxTv_SdtGAMApplication_Clientallowremoterestauthentication() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18ClientAllowRemoteRestAuth", AV18ClientAllowRemoteRestAuth);
         AV16ClientAllowGetUserRolesRest = AV6Application.getgxTv_SdtGAMApplication_Clientallowgetuserrolesrest() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16ClientAllowGetUserRolesRest", AV16ClientAllowGetUserRolesRest);
         AV14ClientAllowGetUserAddDataRest = AV6Application.getgxTv_SdtGAMApplication_Clientallowgetuseradditionaldatarest() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14ClientAllowGetUserAddDataRest", AV14ClientAllowGetUserAddDataRest);
         AV12ClientAllowGetSessionIniPropRest = AV6Application.getgxTv_SdtGAMApplication_Clientallowgetsessioninitialpropertiesrest() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12ClientAllowGetSessionIniPropRest", AV12ClientAllowGetSessionIniPropRest);
         AV21ClientEncryptionKey = AV6Application.getgxTv_SdtGAMApplication_Clientencryptionkey() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21ClientEncryptionKey", AV21ClientEncryptionKey);
         AV25ClientRepositoryGUID = AV6Application.getgxTv_SdtGAMApplication_Clientrepositoryguid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ClientRepositoryGUID", AV25ClientRepositoryGUID);
         AV50SSORestEnable = AV6Application.getgxTv_SdtGAMApplication_Ssorestenable() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50SSORestEnable", AV50SSORestEnable);
         AV51SSORestMode = AV6Application.getgxTv_SdtGAMApplication_Ssorestmode() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51SSORestMode", AV51SSORestMode);
         AV53SSORestUserAuthTypeName = AV6Application.getgxTv_SdtGAMApplication_Ssorestuserauthenticationtypename() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53SSORestUserAuthTypeName", AV53SSORestUserAuthTypeName);
         AV52SSORestServerURL = AV6Application.getgxTv_SdtGAMApplication_Ssorestserverurl() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52SSORestServerURL", AV52SSORestServerURL);
         AV57STSProtocolEnable = AV6Application.getgxTv_SdtGAMApplication_Stsprotocolenable() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57STSProtocolEnable", AV57STSProtocolEnable);
         AV40GAMUser.load(AV6Application.getgxTv_SdtGAMApplication_Stsauthorizationuserguid());
         AV55STSAuthorizationUserName = AV40GAMUser.getgxTv_SdtGAMUser_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55STSAuthorizationUserName", AV55STSAuthorizationUserName);
         AV56STSMode = AV6Application.getgxTv_SdtGAMApplication_Stsmode() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56STSMode", AV56STSMode);
         AV60STSServerURL = AV6Application.getgxTv_SdtGAMApplication_Stsserverurl() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60STSServerURL", AV60STSServerURL);
         AV58STSServerClientPassword = AV6Application.getgxTv_SdtGAMApplication_Stsserverclientpassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58STSServerClientPassword", AV58STSServerClientPassword);
         AV59STSServerRepositoryGUID = AV6Application.getgxTv_SdtGAMApplication_Stsserverrepositoryguid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59STSServerRepositoryGUID", AV59STSServerRepositoryGUID);
         AV32EnvironmentName = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32EnvironmentName", AV32EnvironmentName);
         AV36EnvironmentSecureProtocol = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Secureprotocol() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36EnvironmentSecureProtocol", AV36EnvironmentSecureProtocol);
         AV31EnvironmentHost = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Host() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31EnvironmentHost", AV31EnvironmentHost);
         AV33EnvironmentPort = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Port() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33EnvironmentPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33EnvironmentPort), 5, 0));
         AV37EnvironmentVirtualDirectory = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Virtualdirectory() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37EnvironmentVirtualDirectory", AV37EnvironmentVirtualDirectory);
         AV35EnvironmentProgramPackage = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Programpackage() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35EnvironmentProgramPackage", AV35EnvironmentProgramPackage);
         AV34EnvironmentProgramExtension = AV6Application.getgxTv_SdtGAMApplication_Environment().getgxTv_SdtGAMApplicationEnvironment_Programextension() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34EnvironmentProgramExtension", AV34EnvironmentProgramExtension);
         if ( GXutil.dateCompare(GXutil.nullDate(), AV6Application.getgxTv_SdtGAMApplication_Clientrevoked()) )
         {
            bttBtnrevokeallow_Caption = httpContext.getMessage( "WWP_GAM_Revoke", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnrevokeallow_Internalname, "Caption", bttBtnrevokeallow_Caption, true);
         }
         else
         {
            bttBtnrevokeallow_Caption = httpContext.getMessage( "WWP_GAM_Authorize", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnrevokeallow_Internalname, "Caption", bttBtnrevokeallow_Caption, true);
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         edtavGuid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
         edtavName_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
         edtavDsc_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), true);
         edtavVersion_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavVersion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavVersion_Enabled), 5, 0), true);
         edtavCopyright_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCopyright_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCopyright_Enabled), 5, 0), true);
         edtavCompany_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCompany_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCompany_Enabled), 5, 0), true);
         chkavUseabsoluteurlbyenvironment.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavUseabsoluteurlbyenvironment.getInternalname(), "Enabled", GXutil.ltrimstr( chkavUseabsoluteurlbyenvironment.getEnabled(), 5, 0), true);
         edtavHomeobject_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavHomeobject_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavHomeobject_Enabled), 5, 0), true);
         edtavAccountactivationobject_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAccountactivationobject_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAccountactivationobject_Enabled), 5, 0), true);
         edtavLogoutobject_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLogoutobject_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLogoutobject_Enabled), 5, 0), true);
         cmbavMainmenu.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMainmenu.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMainmenu.getEnabled(), 5, 0), true);
         chkavAccessrequirespermission.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavAccessrequirespermission.getInternalname(), "Enabled", GXutil.ltrimstr( chkavAccessrequirespermission.getEnabled(), 5, 0), true);
         edtavClientid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientid_Enabled), 5, 0), true);
         edtavClientsecret_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientsecret_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientsecret_Enabled), 5, 0), true);
         chkavClientaccessuniquebyuser.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientaccessuniquebyuser.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientaccessuniquebyuser.getEnabled(), 5, 0), true);
         edtavClientrevoked_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientrevoked_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientrevoked_Enabled), 5, 0), true);
         chkavClientallowremoteauth.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowremoteauth.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowremoteauth.getEnabled(), 5, 0), true);
         chkavClientallowgetuserroles.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuserroles.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowgetuserroles.getEnabled(), 5, 0), true);
         chkavClientallowgetuseradddata.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuseradddata.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowgetuseradddata.getEnabled(), 5, 0), true);
         chkavClientallowgetsessioniniprop.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetsessioniniprop.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowgetsessioniniprop.getEnabled(), 5, 0), true);
         chkavClientallowremoterestauth.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowremoterestauth.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowremoterestauth.getEnabled(), 5, 0), true);
         chkavClientallowgetuserrolesrest.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuserrolesrest.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowgetuserrolesrest.getEnabled(), 5, 0), true);
         chkavClientallowgetuseradddatarest.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuseradddatarest.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowgetuseradddatarest.getEnabled(), 5, 0), true);
         chkavClientallowgetsessioniniproprest.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetsessioniniproprest.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientallowgetsessioniniproprest.getEnabled(), 5, 0), true);
         edtavClientlocalloginurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientlocalloginurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientlocalloginurl_Enabled), 5, 0), true);
         edtavClientcallbackurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientcallbackurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientcallbackurl_Enabled), 5, 0), true);
         chkavClientcallbackurliscustom.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavClientcallbackurliscustom.getInternalname(), "Enabled", GXutil.ltrimstr( chkavClientcallbackurliscustom.getEnabled(), 5, 0), true);
         edtavClientcallbackurlstatename_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientcallbackurlstatename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientcallbackurlstatename_Enabled), 5, 0), true);
         edtavClientimageurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientimageurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientimageurl_Enabled), 5, 0), true);
         edtavClientencryptionkey_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientencryptionkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientencryptionkey_Enabled), 5, 0), true);
         edtavClientrepositoryguid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavClientrepositoryguid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClientrepositoryguid_Enabled), 5, 0), true);
         chkavSsorestenable.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavSsorestenable.getInternalname(), "Enabled", GXutil.ltrimstr( chkavSsorestenable.getEnabled(), 5, 0), true);
         cmbavSsorestmode.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSsorestmode.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSsorestmode.getEnabled(), 5, 0), true);
         edtavSsorestuserauthtypename_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSsorestuserauthtypename_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSsorestuserauthtypename_Enabled), 5, 0), true);
         edtavSsorestserverurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSsorestserverurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSsorestserverurl_Enabled), 5, 0), true);
         chkavStsprotocolenable.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavStsprotocolenable.getInternalname(), "Enabled", GXutil.ltrimstr( chkavStsprotocolenable.getEnabled(), 5, 0), true);
         edtavStsauthorizationusername_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavStsauthorizationusername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsauthorizationusername_Enabled), 5, 0), true);
         cmbavStsmode.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavStsmode.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavStsmode.getEnabled(), 5, 0), true);
         edtavStsserverurl_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavStsserverurl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsserverurl_Enabled), 5, 0), true);
         edtavStsserverclientpassword_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavStsserverclientpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsserverclientpassword_Enabled), 5, 0), true);
         edtavStsserverrepositoryguid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavStsserverrepositoryguid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsserverrepositoryguid_Enabled), 5, 0), true);
         edtavEnvironmentname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEnvironmentname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEnvironmentname_Enabled), 5, 0), true);
         chkavEnvironmentsecureprotocol.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavEnvironmentsecureprotocol.getInternalname(), "Enabled", GXutil.ltrimstr( chkavEnvironmentsecureprotocol.getEnabled(), 5, 0), true);
         edtavEnvironmenthost_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEnvironmenthost_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEnvironmenthost_Enabled), 5, 0), true);
         edtavEnvironmentport_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEnvironmentport_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEnvironmentport_Enabled), 5, 0), true);
         edtavEnvironmentvirtualdirectory_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEnvironmentvirtualdirectory_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEnvironmentvirtualdirectory_Enabled), 5, 0), true);
         edtavEnvironmentprogrampackage_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEnvironmentprogrampackage_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEnvironmentprogrampackage_Enabled), 5, 0), true);
         edtavEnvironmentprogramextension_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEnvironmentprogramextension_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEnvironmentprogramextension_Enabled), 5, 0), true);
         bttBtngeneratekeygamremote_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtngeneratekeygamremote_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtngeneratekeygamremote_Visible), 5, 0), true);
         bttBtnenter_Caption = httpContext.getMessage( "WWP_GAM_Delete", "") ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
      }
      /* Execute user subroutine: 'UI_REMOTEAUTHENTICATIONWEB' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UI_REMOTEAUTHENTICATIONREST' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UI_SSOREST' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'UI_STSPROTOCOL' */
      S142 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S152 ();
      if (returnInSub) return;
      chkavAutoregisteranomymoususer.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavAutoregisteranomymoususer.getInternalname(), "Visible", GXutil.ltrimstr( chkavAutoregisteranomymoususer.getVisible(), 5, 0), true);
      edtavStsauthorizationuserguid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavStsauthorizationuserguid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsauthorizationuserguid_Visible), 5, 0), true);
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void e142Q2( )
   {
      /* 'DoGenerateKeyGAMRemote' Routine */
      returnInSub = false ;
      AV21ClientEncryptionKey = com.genexus.util.Encryption.getNewKey( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ClientEncryptionKey", AV21ClientEncryptionKey);
      /*  Sending Event outputs  */
   }

   public void e152Q2( )
   {
      /* 'DoRevokeAllow' Routine */
      returnInSub = false ;
      AV6Application.load(AV43Id);
      if ( GXutil.dateCompare(GXutil.nullDate(), AV6Application.getgxTv_SdtGAMApplication_Clientrevoked()) )
      {
         GXv_objcol_SdtGAMError1[0] = AV39Errors ;
         AV44isOk = AV6Application.revokeclient(GXv_objcol_SdtGAMError1) ;
         AV39Errors = GXv_objcol_SdtGAMError1[0] ;
      }
      else
      {
         GXv_objcol_SdtGAMError1[0] = AV39Errors ;
         AV44isOk = AV6Application.authorizeclient(GXv_objcol_SdtGAMError1) ;
         AV39Errors = GXv_objcol_SdtGAMError1[0] ;
      }
      if ( AV44isOk )
      {
         if ( GXutil.dateCompare(GXutil.nullDate(), AV6Application.getgxTv_SdtGAMApplication_Clientrevoked()) )
         {
            bttBtnrevokeallow_Caption = httpContext.getMessage( "WWP_GAM_Revoke", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnrevokeallow_Internalname, "Caption", bttBtnrevokeallow_Caption, true);
         }
         else
         {
            bttBtnrevokeallow_Caption = httpContext.getMessage( "WWP_GAM_Authorize", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnrevokeallow_Internalname, "Caption", bttBtnrevokeallow_Caption, true);
         }
         Application.commitDataStores(context, remoteHandle, pr_default, "gamapplicationentry");
         httpContext.doAjaxRefresh();
      }
      else
      {
         /* Execute user subroutine: 'ERRORS' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6Application", AV6Application);
   }

   public void S152( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(AV56STSMode, "fulltoken") == 0 ) || ( GXutil.strcmp(AV56STSMode, "gettoken") == 0 ) ) )
      {
         edtavStsserverclientpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavStsserverclientpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsserverclientpassword_Visible), 5, 0), true);
         divStsserverclientpassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divStsserverclientpassword_cell_Internalname, "Class", divStsserverclientpassword_cell_Class, true);
      }
      else
      {
         edtavStsserverclientpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavStsserverclientpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavStsserverclientpassword_Visible), 5, 0), true);
         divStsserverclientpassword_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divStsserverclientpassword_cell_Internalname, "Class", divStsserverclientpassword_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e162Q2 ();
      if (returnInSub) return;
   }

   public void e162Q2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         AV6Application.load(AV43Id);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
      {
         AV6Application.setgxTv_SdtGAMApplication_Name( AV49Name );
         AV6Application.setgxTv_SdtGAMApplication_Description( AV30Dsc );
         AV6Application.setgxTv_SdtGAMApplication_Version( AV64Version );
         AV6Application.setgxTv_SdtGAMApplication_Copyright( AV29Copyright );
         AV6Application.setgxTv_SdtGAMApplication_Companyname( AV28Company );
         AV6Application.setgxTv_SdtGAMApplication_Useabsoluteurlbyenvironment( AV61UseAbsoluteUrlByEnvironment );
         AV6Application.setgxTv_SdtGAMApplication_Homeobject( AV42HomeObject );
         AV6Application.setgxTv_SdtGAMApplication_Accountactivationobject( AV66AccountActivationObject );
         AV6Application.setgxTv_SdtGAMApplication_Logoutobject( AV45LogoutObject );
         AV6Application.setgxTv_SdtGAMApplication_Mainmenuid( AV46MainMenu );
         AV6Application.setgxTv_SdtGAMApplication_Accessrequirespermission( AV5AccessRequiresPermission );
         AV6Application.setgxTv_SdtGAMApplication_Clientautoregisteranomymoususer( AV7AutoRegisterAnomymousUser );
         AV6Application.setgxTv_SdtGAMApplication_Clientid( AV22ClientId );
         AV6Application.setgxTv_SdtGAMApplication_Clientsecret( AV27ClientSecret );
         AV6Application.setgxTv_SdtGAMApplication_Clientaccessuniquebyuser( AV8ClientAccessUniqueByUser );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowremoteauthentication( AV17ClientAllowRemoteAuth );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowgetuserroles( AV15ClientAllowGetUserRoles );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowgetuseradditionaldata( AV13ClientAllowGetUserAddData );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowgetsessioninitialproperties( AV11ClientAllowGetSessionIniProp );
         AV6Application.setgxTv_SdtGAMApplication_Clientlocalloginurl( AV24ClientLocalLoginURL );
         AV6Application.setgxTv_SdtGAMApplication_Clientcallbackurl( AV19ClientCallbackURL );
         AV6Application.setgxTv_SdtGAMApplication_Clientcallbackurliscustom( AV20ClientCallbackURLisCustom );
         AV6Application.setgxTv_SdtGAMApplication_Clientcallbackurlstatename( AV65ClientCallbackURLStateName );
         AV6Application.setgxTv_SdtGAMApplication_Clientimageurl( AV23ClientImageURL );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowremoterestauthentication( AV18ClientAllowRemoteRestAuth );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowgetuserrolesrest( AV16ClientAllowGetUserRolesRest );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowgetuseradditionaldatarest( AV14ClientAllowGetUserAddDataRest );
         AV6Application.setgxTv_SdtGAMApplication_Clientallowgetsessioninitialpropertiesrest( AV12ClientAllowGetSessionIniPropRest );
         AV6Application.setgxTv_SdtGAMApplication_Clientencryptionkey( AV21ClientEncryptionKey );
         AV6Application.setgxTv_SdtGAMApplication_Clientrepositoryguid( AV25ClientRepositoryGUID );
         AV6Application.setgxTv_SdtGAMApplication_Ssorestenable( AV50SSORestEnable );
         AV6Application.setgxTv_SdtGAMApplication_Ssorestmode( AV51SSORestMode );
         AV6Application.setgxTv_SdtGAMApplication_Ssorestuserauthenticationtypename( AV53SSORestUserAuthTypeName );
         AV6Application.setgxTv_SdtGAMApplication_Ssorestserverurl( AV52SSORestServerURL );
         AV6Application.setgxTv_SdtGAMApplication_Stsprotocolenable( AV57STSProtocolEnable );
         if ( ! (GXutil.strcmp("", AV55STSAuthorizationUserName)==0) )
         {
            GXv_objcol_SdtGAMError1[0] = AV63UserErrors ;
            AV40GAMUser = AV40GAMUser.getbylogin("local", AV55STSAuthorizationUserName, GXv_objcol_SdtGAMError1);
            AV63UserErrors = GXv_objcol_SdtGAMError1[0] ;
            AV54STSAuthorizationUserGUID = AV40GAMUser.getgxTv_SdtGAMUser_Guid() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54STSAuthorizationUserGUID", AV54STSAuthorizationUserGUID);
         }
         AV6Application.setgxTv_SdtGAMApplication_Stsauthorizationuserguid( AV54STSAuthorizationUserGUID );
         AV6Application.setgxTv_SdtGAMApplication_Stsmode( AV56STSMode );
         AV6Application.setgxTv_SdtGAMApplication_Stsserverurl( AV60STSServerURL );
         AV6Application.setgxTv_SdtGAMApplication_Stsserverclientpassword( AV58STSServerClientPassword );
         AV6Application.setgxTv_SdtGAMApplication_Stsserverrepositoryguid( AV59STSServerRepositoryGUID );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Name( AV32EnvironmentName );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Secureprotocol( AV36EnvironmentSecureProtocol );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Host( AV31EnvironmentHost );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Port( AV33EnvironmentPort );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Virtualdirectory( AV37EnvironmentVirtualDirectory );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Programpackage( AV35EnvironmentProgramPackage );
         AV6Application.getgxTv_SdtGAMApplication_Environment().setgxTv_SdtGAMApplicationEnvironment_Programextension( AV34EnvironmentProgramExtension );
         AV6Application.save();
      }
      else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         AV6Application.delete();
      }
      if ( AV6Application.success() && ( AV63UserErrors.size() == 0 ) )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamapplicationentry");
         callWebObject(formatLink("com.mujermorena.gamwwapplications", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         AV39Errors = AV6Application.geterrors() ;
         /* Execute user subroutine: 'ERRORS' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6Application", AV6Application);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40GAMUser", AV40GAMUser);
   }

   public void S162( )
   {
      /* 'ERRORS' Routine */
      returnInSub = false ;
      if ( AV39Errors.size() > 0 )
      {
         AV74GXV3 = 1 ;
         while ( AV74GXV3 <= AV39Errors.size() )
         {
            AV38Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV39Errors.elementAt(-1+AV74GXV3));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV38Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV38Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV74GXV3 = (int)(AV74GXV3+1) ;
         }
      }
      if ( AV63UserErrors.size() > 0 )
      {
         AV75GXV4 = 1 ;
         while ( AV75GXV4 <= AV63UserErrors.size() )
         {
            AV38Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV63UserErrors.elementAt(-1+AV75GXV4));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV38Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV38Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV75GXV4 = (int)(AV75GXV4+1) ;
         }
      }
   }

   public void S112( )
   {
      /* 'UI_REMOTEAUTHENTICATIONWEB' Routine */
      returnInSub = false ;
      if ( AV17ClientAllowRemoteAuth )
      {
         divTblwebauth_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblwebauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblwebauth_Visible), 5, 0), true);
         divTblgeneralauth_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblgeneralauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblgeneralauth_Visible), 5, 0), true);
      }
      else
      {
         divTblwebauth_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblwebauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblwebauth_Visible), 5, 0), true);
         if ( ! AV18ClientAllowRemoteRestAuth )
         {
            divTblgeneralauth_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTblgeneralauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblgeneralauth_Visible), 5, 0), true);
         }
      }
   }

   public void S122( )
   {
      /* 'UI_REMOTEAUTHENTICATIONREST' Routine */
      returnInSub = false ;
      if ( AV18ClientAllowRemoteRestAuth )
      {
         divTblrestauth_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblrestauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblrestauth_Visible), 5, 0), true);
         divTblgeneralauth_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblgeneralauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblgeneralauth_Visible), 5, 0), true);
      }
      else
      {
         divTblrestauth_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblrestauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblrestauth_Visible), 5, 0), true);
         if ( ! AV17ClientAllowRemoteAuth )
         {
            divTblgeneralauth_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTblgeneralauth_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblgeneralauth_Visible), 5, 0), true);
         }
      }
   }

   public void S132( )
   {
      /* 'UI_SSOREST' Routine */
      returnInSub = false ;
      if ( AV50SSORestEnable )
      {
         divTablessorest_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablessorest_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablessorest_Visible), 5, 0), true);
         if ( GXutil.strcmp(AV51SSORestMode, "server") == 0 )
         {
            divTblssorestmodeclient_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTblssorestmodeclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblssorestmodeclient_Visible), 5, 0), true);
         }
         else if ( GXutil.strcmp(AV51SSORestMode, "client") == 0 )
         {
            divTblssorestmodeclient_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTblssorestmodeclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblssorestmodeclient_Visible), 5, 0), true);
         }
      }
      else
      {
         divTablessorest_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablessorest_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablessorest_Visible), 5, 0), true);
      }
   }

   public void S142( )
   {
      /* 'UI_STSPROTOCOL' Routine */
      returnInSub = false ;
      if ( AV57STSProtocolEnable )
      {
         divTablests_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablests_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablests_Visible), 5, 0), true);
         if ( GXutil.strcmp(AV56STSMode, "server") == 0 )
         {
            divTablestsserverchecktoken_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsserverchecktoken_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsserverchecktoken_Visible), 5, 0), true);
            divTablestsclient_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsclient_Visible), 5, 0), true);
         }
         else if ( GXutil.strcmp(AV56STSMode, "gettoken") == 0 )
         {
            divTablestsserverchecktoken_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsserverchecktoken_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsserverchecktoken_Visible), 5, 0), true);
            divTablestsclient_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsclient_Visible), 5, 0), true);
         }
         else if ( GXutil.strcmp(AV56STSMode, "checktoken") == 0 )
         {
            divTablestsserverchecktoken_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsserverchecktoken_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsserverchecktoken_Visible), 5, 0), true);
            divTablestsclient_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsclient_Visible), 5, 0), true);
         }
         else if ( GXutil.strcmp(AV56STSMode, "fulltoken") == 0 )
         {
            divTablestsserverchecktoken_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsserverchecktoken_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsserverchecktoken_Visible), 5, 0), true);
            divTablestsclient_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTablestsclient_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablestsclient_Visible), 5, 0), true);
         }
      }
      else
      {
         divTablests_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablests_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablests_Visible), 5, 0), true);
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S152 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e172Q2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_219_2Q2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedclientencryptionkey_Internalname, tblTablemergedclientencryptionkey_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientencryptionkey_Internalname, httpContext.getMessage( "Client Encryption Key", ""), "gx-form-item AttributeRealWidthLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientencryptionkey_Internalname, GXutil.rtrim( AV21ClientEncryptionKey), GXutil.rtrim( localUtil.format( AV21ClientEncryptionKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,223);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientencryptionkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavClientencryptionkey_Enabled, 1, "text", "", 32, "chr", 1, "row", 32, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEncryptionKey", "left", true, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 225,'',false,'',0)\"" ;
         ClassString = "Button ButtonMaterialGAM" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtngeneratekeygamremote_Internalname, "", httpContext.getMessage( "WWP_GAM_GenerateKeyGAMRemote", ""), bttBtngeneratekeygamremote_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_GenerateKeyGAMRemote", ""), "", StyleString, ClassString, bttBtngeneratekeygamremote_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGENERATEKEYGAMREMOTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMApplicationEntry.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_219_2Q2e( true) ;
      }
      else
      {
         wb_table2_219_2Q2e( false) ;
      }
   }

   public void wb_table1_91_2Q2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedclientrevoked_Internalname, tblTablemergedclientrevoked_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavClientrevoked_Internalname, httpContext.getMessage( "Client Revoked", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavClientrevoked_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavClientrevoked_Internalname, localUtil.ttoc( AV26ClientRevoked, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( AV26ClientRevoked, "99/99/9999 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,95);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClientrevoked_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavClientrevoked_Enabled, 1, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMDateTime", "right", false, "", "HLP_GAMApplicationEntry.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavClientrevoked_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavClientrevoked_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_GAMApplicationEntry.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
         ClassString = "Button ButtonMaterialGAM" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnrevokeallow_Internalname, "", bttBtnrevokeallow_Caption, bttBtnrevokeallow_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_Revoke", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOREVOKEALLOW\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMApplicationEntry.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_91_2Q2e( true) ;
      }
      else
      {
         wb_table1_91_2Q2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV43Id = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV43Id), 12, 0));
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
      pa2Q2( ) ;
      ws2Q2( ) ;
      we2Q2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211118554", true, true);
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
      httpContext.AddJavascriptSource("gamapplicationentry.js", "?20241211118556", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      edtavId_Internalname = "vID" ;
      edtavGuid_Internalname = "vGUID" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      edtavVersion_Internalname = "vVERSION" ;
      edtavCompany_Internalname = "vCOMPANY" ;
      edtavCopyright_Internalname = "vCOPYRIGHT" ;
      chkavUseabsoluteurlbyenvironment.setInternalname( "vUSEABSOLUTEURLBYENVIRONMENT" );
      edtavHomeobject_Internalname = "vHOMEOBJECT" ;
      edtavAccountactivationobject_Internalname = "vACCOUNTACTIVATIONOBJECT" ;
      edtavLogoutobject_Internalname = "vLOGOUTOBJECT" ;
      cmbavMainmenu.setInternalname( "vMAINMENU" );
      lblTextblockclientrevoked_Internalname = "TEXTBLOCKCLIENTREVOKED" ;
      edtavClientrevoked_Internalname = "vCLIENTREVOKED" ;
      bttBtnrevokeallow_Internalname = "BTNREVOKEALLOW" ;
      tblTablemergedclientrevoked_Internalname = "TABLEMERGEDCLIENTREVOKED" ;
      divTablesplittedclientrevoked_Internalname = "TABLESPLITTEDCLIENTREVOKED" ;
      chkavAccessrequirespermission.setInternalname( "vACCESSREQUIRESPERMISSION" );
      divUnnamedtable8_Internalname = "UNNAMEDTABLE8" ;
      lblRemoteauthentication_title_Internalname = "REMOTEAUTHENTICATION_TITLE" ;
      edtavClientid_Internalname = "vCLIENTID" ;
      edtavClientsecret_Internalname = "vCLIENTSECRET" ;
      chkavClientallowremoteauth.setInternalname( "vCLIENTALLOWREMOTEAUTH" );
      chkavClientallowgetuserroles.setInternalname( "vCLIENTALLOWGETUSERROLES" );
      chkavClientallowgetuseradddata.setInternalname( "vCLIENTALLOWGETUSERADDDATA" );
      chkavClientallowgetsessioniniprop.setInternalname( "vCLIENTALLOWGETSESSIONINIPROP" );
      edtavClientimageurl_Internalname = "vCLIENTIMAGEURL" ;
      edtavClientlocalloginurl_Internalname = "vCLIENTLOCALLOGINURL" ;
      edtavClientcallbackurl_Internalname = "vCLIENTCALLBACKURL" ;
      chkavClientcallbackurliscustom.setInternalname( "vCLIENTCALLBACKURLISCUSTOM" );
      edtavClientcallbackurlstatename_Internalname = "vCLIENTCALLBACKURLSTATENAME" ;
      divTblwebauth_Internalname = "TBLWEBAUTH" ;
      divUnnamedtable5_Internalname = "UNNAMEDTABLE5" ;
      Dvpanel_unnamedtable5_Internalname = "DVPANEL_UNNAMEDTABLE5" ;
      chkavClientallowremoterestauth.setInternalname( "vCLIENTALLOWREMOTERESTAUTH" );
      chkavClientallowgetuserrolesrest.setInternalname( "vCLIENTALLOWGETUSERROLESREST" );
      chkavClientallowgetuseradddatarest.setInternalname( "vCLIENTALLOWGETUSERADDDATAREST" );
      chkavClientallowgetsessioniniproprest.setInternalname( "vCLIENTALLOWGETSESSIONINIPROPREST" );
      divTblrestauth_Internalname = "TBLRESTAUTH" ;
      divUnnamedtable6_Internalname = "UNNAMEDTABLE6" ;
      Dvpanel_unnamedtable6_Internalname = "DVPANEL_UNNAMEDTABLE6" ;
      chkavClientaccessuniquebyuser.setInternalname( "vCLIENTACCESSUNIQUEBYUSER" );
      lblTextblockclientencryptionkey_Internalname = "TEXTBLOCKCLIENTENCRYPTIONKEY" ;
      edtavClientencryptionkey_Internalname = "vCLIENTENCRYPTIONKEY" ;
      bttBtngeneratekeygamremote_Internalname = "BTNGENERATEKEYGAMREMOTE" ;
      tblTablemergedclientencryptionkey_Internalname = "TABLEMERGEDCLIENTENCRYPTIONKEY" ;
      divTablesplittedclientencryptionkey_Internalname = "TABLESPLITTEDCLIENTENCRYPTIONKEY" ;
      edtavClientrepositoryguid_Internalname = "vCLIENTREPOSITORYGUID" ;
      divUnnamedtable7_Internalname = "UNNAMEDTABLE7" ;
      Dvpanel_unnamedtable7_Internalname = "DVPANEL_UNNAMEDTABLE7" ;
      divTblgeneralauth_Internalname = "TBLGENERALAUTH" ;
      divUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      lblSsorest_title_Internalname = "SSOREST_TITLE" ;
      chkavSsorestenable.setInternalname( "vSSORESTENABLE" );
      cmbavSsorestmode.setInternalname( "vSSORESTMODE" );
      edtavSsorestuserauthtypename_Internalname = "vSSORESTUSERAUTHTYPENAME" ;
      edtavSsorestserverurl_Internalname = "vSSORESTSERVERURL" ;
      divTblssorestmodeclient_Internalname = "TBLSSORESTMODECLIENT" ;
      divTablessorest_Internalname = "TABLESSOREST" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      lblSts_title_Internalname = "STS_TITLE" ;
      chkavStsprotocolenable.setInternalname( "vSTSPROTOCOLENABLE" );
      cmbavStsmode.setInternalname( "vSTSMODE" );
      edtavStsauthorizationusername_Internalname = "vSTSAUTHORIZATIONUSERNAME" ;
      divTablestsserverchecktoken_Internalname = "TABLESTSSERVERCHECKTOKEN" ;
      edtavStsserverclientpassword_Internalname = "vSTSSERVERCLIENTPASSWORD" ;
      divStsserverclientpassword_cell_Internalname = "STSSERVERCLIENTPASSWORD_CELL" ;
      edtavStsserverurl_Internalname = "vSTSSERVERURL" ;
      edtavStsserverrepositoryguid_Internalname = "vSTSSERVERREPOSITORYGUID" ;
      divTablestsclient_Internalname = "TABLESTSCLIENT" ;
      divTablests_Internalname = "TABLESTS" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      lblEnvironmentsettings_title_Internalname = "ENVIRONMENTSETTINGS_TITLE" ;
      edtavEnvironmentname_Internalname = "vENVIRONMENTNAME" ;
      chkavEnvironmentsecureprotocol.setInternalname( "vENVIRONMENTSECUREPROTOCOL" );
      edtavEnvironmenthost_Internalname = "vENVIRONMENTHOST" ;
      edtavEnvironmentport_Internalname = "vENVIRONMENTPORT" ;
      edtavEnvironmentvirtualdirectory_Internalname = "vENVIRONMENTVIRTUALDIRECTORY" ;
      edtavEnvironmentprogrampackage_Internalname = "vENVIRONMENTPROGRAMPACKAGE" ;
      edtavEnvironmentprogramextension_Internalname = "vENVIRONMENTPROGRAMEXTENSION" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      chkavAutoregisteranomymoususer.setInternalname( "vAUTOREGISTERANOMYMOUSUSER" );
      edtavStsauthorizationuserguid_Internalname = "vSTSAUTHORIZATIONUSERGUID" ;
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
      edtavClientrevoked_Jsonclick = "" ;
      bttBtngeneratekeygamremote_Visible = 1 ;
      edtavClientencryptionkey_Jsonclick = "" ;
      edtavClientencryptionkey_Enabled = 1 ;
      edtavClientrevoked_Enabled = 1 ;
      bttBtnrevokeallow_Caption = httpContext.getMessage( "WWP_GAM_Revoke", "") ;
      edtavStsauthorizationuserguid_Jsonclick = "" ;
      edtavStsauthorizationuserguid_Visible = 1 ;
      chkavAutoregisteranomymoususer.setVisible( 1 );
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      edtavEnvironmentprogramextension_Jsonclick = "" ;
      edtavEnvironmentprogramextension_Enabled = 1 ;
      edtavEnvironmentprogrampackage_Jsonclick = "" ;
      edtavEnvironmentprogrampackage_Enabled = 1 ;
      edtavEnvironmentvirtualdirectory_Jsonclick = "" ;
      edtavEnvironmentvirtualdirectory_Enabled = 1 ;
      edtavEnvironmentport_Jsonclick = "" ;
      edtavEnvironmentport_Enabled = 1 ;
      edtavEnvironmenthost_Jsonclick = "" ;
      edtavEnvironmenthost_Enabled = 1 ;
      chkavEnvironmentsecureprotocol.setEnabled( 1 );
      edtavEnvironmentname_Jsonclick = "" ;
      edtavEnvironmentname_Enabled = 1 ;
      edtavStsserverrepositoryguid_Jsonclick = "" ;
      edtavStsserverrepositoryguid_Enabled = 1 ;
      edtavStsserverurl_Jsonclick = "" ;
      edtavStsserverurl_Enabled = 1 ;
      divTablestsclient_Visible = 1 ;
      edtavStsserverclientpassword_Jsonclick = "" ;
      edtavStsserverclientpassword_Enabled = 1 ;
      edtavStsserverclientpassword_Visible = 1 ;
      divStsserverclientpassword_cell_Class = "col-xs-12" ;
      edtavStsauthorizationusername_Jsonclick = "" ;
      edtavStsauthorizationusername_Enabled = 1 ;
      divTablestsserverchecktoken_Visible = 1 ;
      cmbavStsmode.setJsonclick( "" );
      cmbavStsmode.setEnabled( 1 );
      divTablests_Visible = 1 ;
      chkavStsprotocolenable.setEnabled( 1 );
      edtavSsorestserverurl_Jsonclick = "" ;
      edtavSsorestserverurl_Enabled = 1 ;
      edtavSsorestuserauthtypename_Jsonclick = "" ;
      edtavSsorestuserauthtypename_Enabled = 1 ;
      divTblssorestmodeclient_Visible = 1 ;
      cmbavSsorestmode.setJsonclick( "" );
      cmbavSsorestmode.setEnabled( 1 );
      divTablessorest_Visible = 1 ;
      chkavSsorestenable.setEnabled( 1 );
      edtavClientrepositoryguid_Jsonclick = "" ;
      edtavClientrepositoryguid_Enabled = 1 ;
      chkavClientaccessuniquebyuser.setEnabled( 1 );
      divTblgeneralauth_Visible = 1 ;
      chkavClientallowgetsessioniniproprest.setEnabled( 1 );
      chkavClientallowgetuseradddatarest.setEnabled( 1 );
      chkavClientallowgetuserrolesrest.setEnabled( 1 );
      divTblrestauth_Visible = 1 ;
      chkavClientallowremoterestauth.setEnabled( 1 );
      edtavClientcallbackurlstatename_Jsonclick = "" ;
      edtavClientcallbackurlstatename_Enabled = 1 ;
      chkavClientcallbackurliscustom.setEnabled( 1 );
      edtavClientcallbackurl_Jsonclick = "" ;
      edtavClientcallbackurl_Enabled = 1 ;
      edtavClientlocalloginurl_Jsonclick = "" ;
      edtavClientlocalloginurl_Enabled = 1 ;
      edtavClientimageurl_Jsonclick = "" ;
      edtavClientimageurl_Enabled = 1 ;
      chkavClientallowgetsessioniniprop.setEnabled( 1 );
      chkavClientallowgetuseradddata.setEnabled( 1 );
      chkavClientallowgetuserroles.setEnabled( 1 );
      divTblwebauth_Visible = 1 ;
      chkavClientallowremoteauth.setEnabled( 1 );
      edtavClientsecret_Jsonclick = "" ;
      edtavClientsecret_Enabled = 1 ;
      edtavClientid_Jsonclick = "" ;
      edtavClientid_Enabled = 1 ;
      chkavAccessrequirespermission.setEnabled( 1 );
      cmbavMainmenu.setJsonclick( "" );
      cmbavMainmenu.setEnabled( 1 );
      edtavLogoutobject_Jsonclick = "" ;
      edtavLogoutobject_Enabled = 1 ;
      edtavAccountactivationobject_Jsonclick = "" ;
      edtavAccountactivationobject_Enabled = 1 ;
      edtavHomeobject_Jsonclick = "" ;
      edtavHomeobject_Enabled = 1 ;
      chkavUseabsoluteurlbyenvironment.setEnabled( 1 );
      edtavCopyright_Jsonclick = "" ;
      edtavCopyright_Enabled = 1 ;
      edtavCompany_Jsonclick = "" ;
      edtavCompany_Enabled = 1 ;
      edtavVersion_Jsonclick = "" ;
      edtavVersion_Enabled = 1 ;
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      edtavGuid_Jsonclick = "" ;
      edtavGuid_Enabled = 1 ;
      edtavId_Jsonclick = "" ;
      edtavId_Enabled = 0 ;
      lblTextblocktitle_Caption = httpContext.getMessage( "Title", "") ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "" ;
      Gxuitabspanel_tabs_Pagecount = 5 ;
      Dvpanel_unnamedtable7_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Iconposition = "Right" ;
      Dvpanel_unnamedtable7_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable7_Title = httpContext.getMessage( "WWP_GAM_General", "") ;
      Dvpanel_unnamedtable7_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable7_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable7_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable7_Width = "100%" ;
      Dvpanel_unnamedtable6_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Iconposition = "Right" ;
      Dvpanel_unnamedtable6_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable6_Title = httpContext.getMessage( "WWP_GAM_RestOAuthMobileRemoteRest", "") ;
      Dvpanel_unnamedtable6_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable6_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable6_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable6_Width = "100%" ;
      Dvpanel_unnamedtable5_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Iconposition = "Right" ;
      Dvpanel_unnamedtable5_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable5_Title = httpContext.getMessage( " WWP_GAM_WebIdentityProviderSSO", "") ;
      Dvpanel_unnamedtable5_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable5_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable5_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable5_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Application", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavUseabsoluteurlbyenvironment.setName( "vUSEABSOLUTEURLBYENVIRONMENT" );
      chkavUseabsoluteurlbyenvironment.setWebtags( "" );
      chkavUseabsoluteurlbyenvironment.setCaption( httpContext.getMessage( "WWP_GAM_UseAbsoluteURLByEnvironment", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavUseabsoluteurlbyenvironment.getInternalname(), "TitleCaption", chkavUseabsoluteurlbyenvironment.getCaption(), true);
      chkavUseabsoluteurlbyenvironment.setCheckedValue( "false" );
      AV61UseAbsoluteUrlByEnvironment = GXutil.strtobool( GXutil.booltostr( AV61UseAbsoluteUrlByEnvironment)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61UseAbsoluteUrlByEnvironment", AV61UseAbsoluteUrlByEnvironment);
      cmbavMainmenu.setName( "vMAINMENU" );
      cmbavMainmenu.setWebtags( "" );
      if ( cmbavMainmenu.getItemCount() > 0 )
      {
         AV46MainMenu = GXutil.lval( cmbavMainmenu.getValidValue(GXutil.trim( GXutil.str( AV46MainMenu, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MainMenu", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MainMenu), 12, 0));
      }
      chkavAccessrequirespermission.setName( "vACCESSREQUIRESPERMISSION" );
      chkavAccessrequirespermission.setWebtags( "" );
      chkavAccessrequirespermission.setCaption( httpContext.getMessage( "WWP_GAM_RequiresPermissions", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavAccessrequirespermission.getInternalname(), "TitleCaption", chkavAccessrequirespermission.getCaption(), true);
      chkavAccessrequirespermission.setCheckedValue( "false" );
      AV5AccessRequiresPermission = GXutil.strtobool( GXutil.booltostr( AV5AccessRequiresPermission)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AccessRequiresPermission", AV5AccessRequiresPermission);
      chkavClientallowremoteauth.setName( "vCLIENTALLOWREMOTEAUTH" );
      chkavClientallowremoteauth.setWebtags( "" );
      chkavClientallowremoteauth.setCaption( httpContext.getMessage( "WWP_GAM_AllowRemoteAuthentication", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowremoteauth.getInternalname(), "TitleCaption", chkavClientallowremoteauth.getCaption(), true);
      chkavClientallowremoteauth.setCheckedValue( "false" );
      AV17ClientAllowRemoteAuth = GXutil.strtobool( GXutil.booltostr( AV17ClientAllowRemoteAuth)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17ClientAllowRemoteAuth", AV17ClientAllowRemoteAuth);
      chkavClientallowgetuserroles.setName( "vCLIENTALLOWGETUSERROLES" );
      chkavClientallowgetuserroles.setWebtags( "" );
      chkavClientallowgetuserroles.setCaption( httpContext.getMessage( "WWP_GAM_CanGetUserRoles", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuserroles.getInternalname(), "TitleCaption", chkavClientallowgetuserroles.getCaption(), true);
      chkavClientallowgetuserroles.setCheckedValue( "false" );
      AV15ClientAllowGetUserRoles = GXutil.strtobool( GXutil.booltostr( AV15ClientAllowGetUserRoles)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15ClientAllowGetUserRoles", AV15ClientAllowGetUserRoles);
      chkavClientallowgetuseradddata.setName( "vCLIENTALLOWGETUSERADDDATA" );
      chkavClientallowgetuseradddata.setWebtags( "" );
      chkavClientallowgetuseradddata.setCaption( httpContext.getMessage( "WWP_GAM_CanGetUserAdditionalData", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuseradddata.getInternalname(), "TitleCaption", chkavClientallowgetuseradddata.getCaption(), true);
      chkavClientallowgetuseradddata.setCheckedValue( "false" );
      AV13ClientAllowGetUserAddData = GXutil.strtobool( GXutil.booltostr( AV13ClientAllowGetUserAddData)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13ClientAllowGetUserAddData", AV13ClientAllowGetUserAddData);
      chkavClientallowgetsessioniniprop.setName( "vCLIENTALLOWGETSESSIONINIPROP" );
      chkavClientallowgetsessioniniprop.setWebtags( "" );
      chkavClientallowgetsessioniniprop.setCaption( httpContext.getMessage( "WWP_GAM_CanGetSessionInitialProperties", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetsessioniniprop.getInternalname(), "TitleCaption", chkavClientallowgetsessioniniprop.getCaption(), true);
      chkavClientallowgetsessioniniprop.setCheckedValue( "false" );
      AV11ClientAllowGetSessionIniProp = GXutil.strtobool( GXutil.booltostr( AV11ClientAllowGetSessionIniProp)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11ClientAllowGetSessionIniProp", AV11ClientAllowGetSessionIniProp);
      chkavClientcallbackurliscustom.setName( "vCLIENTCALLBACKURLISCUSTOM" );
      chkavClientcallbackurliscustom.setWebtags( "" );
      chkavClientcallbackurliscustom.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientcallbackurliscustom.getInternalname(), "TitleCaption", chkavClientcallbackurliscustom.getCaption(), true);
      chkavClientcallbackurliscustom.setCheckedValue( "false" );
      AV20ClientCallbackURLisCustom = GXutil.strtobool( GXutil.booltostr( AV20ClientCallbackURLisCustom)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ClientCallbackURLisCustom", AV20ClientCallbackURLisCustom);
      chkavClientallowremoterestauth.setName( "vCLIENTALLOWREMOTERESTAUTH" );
      chkavClientallowremoterestauth.setWebtags( "" );
      chkavClientallowremoterestauth.setCaption( httpContext.getMessage( "WWP_GAM_AllowAuthenticationV20", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowremoterestauth.getInternalname(), "TitleCaption", chkavClientallowremoterestauth.getCaption(), true);
      chkavClientallowremoterestauth.setCheckedValue( "false" );
      AV18ClientAllowRemoteRestAuth = GXutil.strtobool( GXutil.booltostr( AV18ClientAllowRemoteRestAuth)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ClientAllowRemoteRestAuth", AV18ClientAllowRemoteRestAuth);
      chkavClientallowgetuserrolesrest.setName( "vCLIENTALLOWGETUSERROLESREST" );
      chkavClientallowgetuserrolesrest.setWebtags( "" );
      chkavClientallowgetuserrolesrest.setCaption( httpContext.getMessage( "WWP_GAM_CanGetUserRoles", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuserrolesrest.getInternalname(), "TitleCaption", chkavClientallowgetuserrolesrest.getCaption(), true);
      chkavClientallowgetuserrolesrest.setCheckedValue( "false" );
      AV16ClientAllowGetUserRolesRest = GXutil.strtobool( GXutil.booltostr( AV16ClientAllowGetUserRolesRest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ClientAllowGetUserRolesRest", AV16ClientAllowGetUserRolesRest);
      chkavClientallowgetuseradddatarest.setName( "vCLIENTALLOWGETUSERADDDATAREST" );
      chkavClientallowgetuseradddatarest.setWebtags( "" );
      chkavClientallowgetuseradddatarest.setCaption( httpContext.getMessage( "WWP_GAM_CanGetUserAdditionalData", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetuseradddatarest.getInternalname(), "TitleCaption", chkavClientallowgetuseradddatarest.getCaption(), true);
      chkavClientallowgetuseradddatarest.setCheckedValue( "false" );
      AV14ClientAllowGetUserAddDataRest = GXutil.strtobool( GXutil.booltostr( AV14ClientAllowGetUserAddDataRest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ClientAllowGetUserAddDataRest", AV14ClientAllowGetUserAddDataRest);
      chkavClientallowgetsessioniniproprest.setName( "vCLIENTALLOWGETSESSIONINIPROPREST" );
      chkavClientallowgetsessioniniproprest.setWebtags( "" );
      chkavClientallowgetsessioniniproprest.setCaption( httpContext.getMessage( "WWP_GAM_CanGetSessionInitialProperties", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientallowgetsessioniniproprest.getInternalname(), "TitleCaption", chkavClientallowgetsessioniniproprest.getCaption(), true);
      chkavClientallowgetsessioniniproprest.setCheckedValue( "false" );
      AV12ClientAllowGetSessionIniPropRest = GXutil.strtobool( GXutil.booltostr( AV12ClientAllowGetSessionIniPropRest)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12ClientAllowGetSessionIniPropRest", AV12ClientAllowGetSessionIniPropRest);
      chkavClientaccessuniquebyuser.setName( "vCLIENTACCESSUNIQUEBYUSER" );
      chkavClientaccessuniquebyuser.setWebtags( "" );
      chkavClientaccessuniquebyuser.setCaption( httpContext.getMessage( "WWP_GAM_SingleUserAccess", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavClientaccessuniquebyuser.getInternalname(), "TitleCaption", chkavClientaccessuniquebyuser.getCaption(), true);
      chkavClientaccessuniquebyuser.setCheckedValue( "false" );
      AV8ClientAccessUniqueByUser = GXutil.strtobool( GXutil.booltostr( AV8ClientAccessUniqueByUser)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8ClientAccessUniqueByUser", AV8ClientAccessUniqueByUser);
      chkavSsorestenable.setName( "vSSORESTENABLE" );
      chkavSsorestenable.setWebtags( "" );
      chkavSsorestenable.setCaption( httpContext.getMessage( "WWP_GAM_EnableSSORestServices", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavSsorestenable.getInternalname(), "TitleCaption", chkavSsorestenable.getCaption(), true);
      chkavSsorestenable.setCheckedValue( "false" );
      AV50SSORestEnable = GXutil.strtobool( GXutil.booltostr( AV50SSORestEnable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50SSORestEnable", AV50SSORestEnable);
      cmbavSsorestmode.setName( "vSSORESTMODE" );
      cmbavSsorestmode.setWebtags( "" );
      cmbavSsorestmode.addItem("server", httpContext.getMessage( "Server", ""), (short)(0));
      cmbavSsorestmode.addItem("client", httpContext.getMessage( "Client", ""), (short)(0));
      if ( cmbavSsorestmode.getItemCount() > 0 )
      {
         AV51SSORestMode = cmbavSsorestmode.getValidValue(AV51SSORestMode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51SSORestMode", AV51SSORestMode);
      }
      chkavStsprotocolenable.setName( "vSTSPROTOCOLENABLE" );
      chkavStsprotocolenable.setWebtags( "" );
      chkavStsprotocolenable.setCaption( httpContext.getMessage( "WWP_GAM_EnableSTSProtocol", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavStsprotocolenable.getInternalname(), "TitleCaption", chkavStsprotocolenable.getCaption(), true);
      chkavStsprotocolenable.setCheckedValue( "false" );
      AV57STSProtocolEnable = GXutil.strtobool( GXutil.booltostr( AV57STSProtocolEnable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57STSProtocolEnable", AV57STSProtocolEnable);
      cmbavStsmode.setName( "vSTSMODE" );
      cmbavStsmode.setWebtags( "" );
      cmbavStsmode.addItem("server", httpContext.getMessage( "Server", ""), (short)(0));
      cmbavStsmode.addItem("gettoken", httpContext.getMessage( "Get token", ""), (short)(0));
      cmbavStsmode.addItem("checktoken", httpContext.getMessage( "Check token", ""), (short)(0));
      cmbavStsmode.addItem("fulltoken", httpContext.getMessage( "Get and check token", ""), (short)(0));
      if ( cmbavStsmode.getItemCount() > 0 )
      {
         AV56STSMode = cmbavStsmode.getValidValue(AV56STSMode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56STSMode", AV56STSMode);
      }
      chkavEnvironmentsecureprotocol.setName( "vENVIRONMENTSECUREPROTOCOL" );
      chkavEnvironmentsecureprotocol.setWebtags( "" );
      chkavEnvironmentsecureprotocol.setCaption( httpContext.getMessage( "WWP_GAM_IsHttps", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEnvironmentsecureprotocol.getInternalname(), "TitleCaption", chkavEnvironmentsecureprotocol.getCaption(), true);
      chkavEnvironmentsecureprotocol.setCheckedValue( "false" );
      AV36EnvironmentSecureProtocol = GXutil.strtobool( GXutil.booltostr( AV36EnvironmentSecureProtocol)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36EnvironmentSecureProtocol", AV36EnvironmentSecureProtocol);
      chkavAutoregisteranomymoususer.setName( "vAUTOREGISTERANOMYMOUSUSER" );
      chkavAutoregisteranomymoususer.setWebtags( "" );
      chkavAutoregisteranomymoususer.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavAutoregisteranomymoususer.getInternalname(), "TitleCaption", chkavAutoregisteranomymoususer.getCaption(), true);
      chkavAutoregisteranomymoususer.setCheckedValue( "false" );
      AV7AutoRegisterAnomymousUser = GXutil.strtobool( GXutil.booltostr( AV7AutoRegisterAnomymousUser)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7AutoRegisterAnomymousUser", AV7AutoRegisterAnomymousUser);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV61UseAbsoluteUrlByEnvironment',fld:'vUSEABSOLUTEURLBYENVIRONMENT',pic:''},{av:'AV5AccessRequiresPermission',fld:'vACCESSREQUIRESPERMISSION',pic:''},{av:'AV17ClientAllowRemoteAuth',fld:'vCLIENTALLOWREMOTEAUTH',pic:''},{av:'AV15ClientAllowGetUserRoles',fld:'vCLIENTALLOWGETUSERROLES',pic:''},{av:'AV13ClientAllowGetUserAddData',fld:'vCLIENTALLOWGETUSERADDDATA',pic:''},{av:'AV11ClientAllowGetSessionIniProp',fld:'vCLIENTALLOWGETSESSIONINIPROP',pic:''},{av:'AV20ClientCallbackURLisCustom',fld:'vCLIENTCALLBACKURLISCUSTOM',pic:''},{av:'AV18ClientAllowRemoteRestAuth',fld:'vCLIENTALLOWREMOTERESTAUTH',pic:''},{av:'AV16ClientAllowGetUserRolesRest',fld:'vCLIENTALLOWGETUSERROLESREST',pic:''},{av:'AV14ClientAllowGetUserAddDataRest',fld:'vCLIENTALLOWGETUSERADDDATAREST',pic:''},{av:'AV12ClientAllowGetSessionIniPropRest',fld:'vCLIENTALLOWGETSESSIONINIPROPREST',pic:''},{av:'AV8ClientAccessUniqueByUser',fld:'vCLIENTACCESSUNIQUEBYUSER',pic:''},{av:'AV50SSORestEnable',fld:'vSSORESTENABLE',pic:''},{av:'AV57STSProtocolEnable',fld:'vSTSPROTOCOLENABLE',pic:''},{av:'AV36EnvironmentSecureProtocol',fld:'vENVIRONMENTSECUREPROTOCOL',pic:''},{av:'AV7AutoRegisterAnomymousUser',fld:'vAUTOREGISTERANOMYMOUSUSER',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOGENERATEKEYGAMREMOTE'","{handler:'e142Q2',iparms:[]");
      setEventMetadata("'DOGENERATEKEYGAMREMOTE'",",oparms:[{av:'AV21ClientEncryptionKey',fld:'vCLIENTENCRYPTIONKEY',pic:''}]}");
      setEventMetadata("'DOREVOKEALLOW'","{handler:'e152Q2',iparms:[{av:'AV43Id',fld:'vID',pic:'ZZZZZZZZZZZ9'}]");
      setEventMetadata("'DOREVOKEALLOW'",",oparms:[{ctrl:'BTNREVOKEALLOW',prop:'Caption'}]}");
      setEventMetadata("ENTER","{handler:'e162Q2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV43Id',fld:'vID',pic:'ZZZZZZZZZZZ9'},{av:'AV49Name',fld:'vNAME',pic:''},{av:'AV30Dsc',fld:'vDSC',pic:''},{av:'AV64Version',fld:'vVERSION',pic:''},{av:'AV29Copyright',fld:'vCOPYRIGHT',pic:''},{av:'AV28Company',fld:'vCOMPANY',pic:''},{av:'AV61UseAbsoluteUrlByEnvironment',fld:'vUSEABSOLUTEURLBYENVIRONMENT',pic:''},{av:'AV42HomeObject',fld:'vHOMEOBJECT',pic:''},{av:'AV66AccountActivationObject',fld:'vACCOUNTACTIVATIONOBJECT',pic:''},{av:'AV45LogoutObject',fld:'vLOGOUTOBJECT',pic:''},{av:'cmbavMainmenu'},{av:'AV46MainMenu',fld:'vMAINMENU',pic:'ZZZZZZZZZZZ9'},{av:'AV5AccessRequiresPermission',fld:'vACCESSREQUIRESPERMISSION',pic:''},{av:'AV7AutoRegisterAnomymousUser',fld:'vAUTOREGISTERANOMYMOUSUSER',pic:''},{av:'AV22ClientId',fld:'vCLIENTID',pic:''},{av:'AV27ClientSecret',fld:'vCLIENTSECRET',pic:''},{av:'AV8ClientAccessUniqueByUser',fld:'vCLIENTACCESSUNIQUEBYUSER',pic:''},{av:'AV17ClientAllowRemoteAuth',fld:'vCLIENTALLOWREMOTEAUTH',pic:''},{av:'AV15ClientAllowGetUserRoles',fld:'vCLIENTALLOWGETUSERROLES',pic:''},{av:'AV13ClientAllowGetUserAddData',fld:'vCLIENTALLOWGETUSERADDDATA',pic:''},{av:'AV11ClientAllowGetSessionIniProp',fld:'vCLIENTALLOWGETSESSIONINIPROP',pic:''},{av:'AV24ClientLocalLoginURL',fld:'vCLIENTLOCALLOGINURL',pic:''},{av:'AV19ClientCallbackURL',fld:'vCLIENTCALLBACKURL',pic:''},{av:'AV20ClientCallbackURLisCustom',fld:'vCLIENTCALLBACKURLISCUSTOM',pic:''},{av:'AV65ClientCallbackURLStateName',fld:'vCLIENTCALLBACKURLSTATENAME',pic:''},{av:'AV23ClientImageURL',fld:'vCLIENTIMAGEURL',pic:''},{av:'AV18ClientAllowRemoteRestAuth',fld:'vCLIENTALLOWREMOTERESTAUTH',pic:''},{av:'AV16ClientAllowGetUserRolesRest',fld:'vCLIENTALLOWGETUSERROLESREST',pic:''},{av:'AV14ClientAllowGetUserAddDataRest',fld:'vCLIENTALLOWGETUSERADDDATAREST',pic:''},{av:'AV12ClientAllowGetSessionIniPropRest',fld:'vCLIENTALLOWGETSESSIONINIPROPREST',pic:''},{av:'AV21ClientEncryptionKey',fld:'vCLIENTENCRYPTIONKEY',pic:''},{av:'AV25ClientRepositoryGUID',fld:'vCLIENTREPOSITORYGUID',pic:''},{av:'AV50SSORestEnable',fld:'vSSORESTENABLE',pic:''},{av:'cmbavSsorestmode'},{av:'AV51SSORestMode',fld:'vSSORESTMODE',pic:''},{av:'AV53SSORestUserAuthTypeName',fld:'vSSORESTUSERAUTHTYPENAME',pic:''},{av:'AV52SSORestServerURL',fld:'vSSORESTSERVERURL',pic:''},{av:'AV57STSProtocolEnable',fld:'vSTSPROTOCOLENABLE',pic:''},{av:'AV55STSAuthorizationUserName',fld:'vSTSAUTHORIZATIONUSERNAME',pic:''},{av:'AV54STSAuthorizationUserGUID',fld:'vSTSAUTHORIZATIONUSERGUID',pic:''},{av:'cmbavStsmode'},{av:'AV56STSMode',fld:'vSTSMODE',pic:''},{av:'AV60STSServerURL',fld:'vSTSSERVERURL',pic:''},{av:'AV58STSServerClientPassword',fld:'vSTSSERVERCLIENTPASSWORD',pic:''},{av:'AV59STSServerRepositoryGUID',fld:'vSTSSERVERREPOSITORYGUID',pic:''},{av:'AV32EnvironmentName',fld:'vENVIRONMENTNAME',pic:''},{av:'AV36EnvironmentSecureProtocol',fld:'vENVIRONMENTSECUREPROTOCOL',pic:''},{av:'AV31EnvironmentHost',fld:'vENVIRONMENTHOST',pic:''},{av:'AV33EnvironmentPort',fld:'vENVIRONMENTPORT',pic:'ZZZZ9'},{av:'AV37EnvironmentVirtualDirectory',fld:'vENVIRONMENTVIRTUALDIRECTORY',pic:''},{av:'AV35EnvironmentProgramPackage',fld:'vENVIRONMENTPROGRAMPACKAGE',pic:''},{av:'AV34EnvironmentProgramExtension',fld:'vENVIRONMENTPROGRAMEXTENSION',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV54STSAuthorizationUserGUID',fld:'vSTSAUTHORIZATIONUSERGUID',pic:''}]}");
      setEventMetadata("VSSORESTMODE.CLICK","{handler:'e112Q1',iparms:[{av:'AV50SSORestEnable',fld:'vSSORESTENABLE',pic:''},{av:'cmbavSsorestmode'},{av:'AV51SSORestMode',fld:'vSSORESTMODE',pic:''}]");
      setEventMetadata("VSSORESTMODE.CLICK",",oparms:[{av:'divTblssorestmodeclient_Visible',ctrl:'TBLSSORESTMODECLIENT',prop:'Visible'},{av:'divTablessorest_Visible',ctrl:'TABLESSOREST',prop:'Visible'}]}");
      setEventMetadata("VSTSMODE.CLICK","{handler:'e122Q1',iparms:[{av:'cmbavStsmode'},{av:'AV56STSMode',fld:'vSTSMODE',pic:''}]");
      setEventMetadata("VSTSMODE.CLICK",",oparms:[{av:'divTablestsserverchecktoken_Visible',ctrl:'TABLESTSSERVERCHECKTOKEN',prop:'Visible'},{av:'divTablestsclient_Visible',ctrl:'TABLESTSCLIENT',prop:'Visible'},{av:'edtavStsserverclientpassword_Visible',ctrl:'vSTSSERVERCLIENTPASSWORD',prop:'Visible'},{av:'divStsserverclientpassword_cell_Class',ctrl:'STSSERVERCLIENTPASSWORD_CELL',prop:'Class'}]}");
      setEventMetadata("VALIDV_CLIENTREVOKED","{handler:'validv_Clientrevoked',iparms:[]");
      setEventMetadata("VALIDV_CLIENTREVOKED",",oparms:[]}");
      setEventMetadata("VALIDV_SSORESTMODE","{handler:'validv_Ssorestmode',iparms:[]");
      setEventMetadata("VALIDV_SSORESTMODE",",oparms:[]}");
      setEventMetadata("VALIDV_STSMODE","{handler:'validv_Stsmode',iparms:[]");
      setEventMetadata("VALIDV_STSMODE",",oparms:[]}");
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
      return "gamapplicationentry_Execute";
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      TempTags = "" ;
      AV41GUID = "" ;
      AV49Name = "" ;
      AV30Dsc = "" ;
      AV64Version = "" ;
      AV28Company = "" ;
      AV29Copyright = "" ;
      AV42HomeObject = "" ;
      AV66AccountActivationObject = "" ;
      AV45LogoutObject = "" ;
      lblTextblockclientrevoked_Jsonclick = "" ;
      lblRemoteauthentication_title_Jsonclick = "" ;
      AV22ClientId = "" ;
      AV27ClientSecret = "" ;
      ucDvpanel_unnamedtable5 = new com.genexus.webpanels.GXUserControl();
      AV23ClientImageURL = "" ;
      AV24ClientLocalLoginURL = "" ;
      AV19ClientCallbackURL = "" ;
      AV65ClientCallbackURLStateName = "" ;
      ucDvpanel_unnamedtable6 = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_unnamedtable7 = new com.genexus.webpanels.GXUserControl();
      lblTextblockclientencryptionkey_Jsonclick = "" ;
      AV25ClientRepositoryGUID = "" ;
      lblSsorest_title_Jsonclick = "" ;
      AV51SSORestMode = "" ;
      AV53SSORestUserAuthTypeName = "" ;
      AV52SSORestServerURL = "" ;
      lblSts_title_Jsonclick = "" ;
      AV56STSMode = "" ;
      AV55STSAuthorizationUserName = "" ;
      AV58STSServerClientPassword = "" ;
      AV60STSServerURL = "" ;
      AV59STSServerRepositoryGUID = "" ;
      lblEnvironmentsettings_title_Jsonclick = "" ;
      AV32EnvironmentName = "" ;
      AV31EnvironmentHost = "" ;
      AV37EnvironmentVirtualDirectory = "" ;
      AV35EnvironmentProgramPackage = "" ;
      AV34EnvironmentProgramExtension = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      AV54STSAuthorizationUserGUID = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV26ClientRevoked = GXutil.resetTime( GXutil.nullDate() );
      AV21ClientEncryptionKey = "" ;
      AV62User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV6Application = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV72GXV1 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationMenu>(genexus.security.api.genexussecurity.SdtGAMApplicationMenu.class, "GAMApplicationMenu", "http://tempuri.org/", remoteHandle);
      AV48MenuFilter = new genexus.security.api.genexussecurity.SdtGAMApplicationMenuFilter(remoteHandle, context);
      AV39Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV47Menu = new genexus.security.api.genexussecurity.SdtGAMApplicationMenu(remoteHandle, context);
      AV40GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV63UserErrors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV38Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      sStyleString = "" ;
      bttBtngeneratekeygamremote_Jsonclick = "" ;
      bttBtnrevokeallow_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamapplicationentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamapplicationentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavId_Enabled = 0 ;
      edtavGuid_Enabled = 0 ;
      edtavClientrevoked_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtavId_Enabled ;
   private int edtavGuid_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavVersion_Enabled ;
   private int edtavCompany_Enabled ;
   private int edtavCopyright_Enabled ;
   private int edtavHomeobject_Enabled ;
   private int edtavAccountactivationobject_Enabled ;
   private int edtavLogoutobject_Enabled ;
   private int edtavClientid_Enabled ;
   private int edtavClientsecret_Enabled ;
   private int divTblwebauth_Visible ;
   private int edtavClientimageurl_Enabled ;
   private int edtavClientlocalloginurl_Enabled ;
   private int edtavClientcallbackurl_Enabled ;
   private int edtavClientcallbackurlstatename_Enabled ;
   private int divTblrestauth_Visible ;
   private int divTblgeneralauth_Visible ;
   private int edtavClientrepositoryguid_Enabled ;
   private int divTablessorest_Visible ;
   private int divTblssorestmodeclient_Visible ;
   private int edtavSsorestuserauthtypename_Enabled ;
   private int edtavSsorestserverurl_Enabled ;
   private int divTablests_Visible ;
   private int divTablestsserverchecktoken_Visible ;
   private int edtavStsauthorizationusername_Enabled ;
   private int edtavStsserverclientpassword_Visible ;
   private int edtavStsserverclientpassword_Enabled ;
   private int divTablestsclient_Visible ;
   private int edtavStsserverurl_Enabled ;
   private int edtavStsserverrepositoryguid_Enabled ;
   private int edtavEnvironmentname_Enabled ;
   private int edtavEnvironmenthost_Enabled ;
   private int AV33EnvironmentPort ;
   private int edtavEnvironmentport_Enabled ;
   private int edtavEnvironmentvirtualdirectory_Enabled ;
   private int edtavEnvironmentprogrampackage_Enabled ;
   private int edtavEnvironmentprogramextension_Enabled ;
   private int bttBtnenter_Visible ;
   private int edtavStsauthorizationuserguid_Visible ;
   private int edtavClientrevoked_Enabled ;
   private int AV73GXV2 ;
   private int edtavClientencryptionkey_Enabled ;
   private int bttBtngeneratekeygamremote_Visible ;
   private int AV74GXV3 ;
   private int AV75GXV4 ;
   private int idxLst ;
   private long wcpOAV43Id ;
   private long AV43Id ;
   private long AV46MainMenu ;
   private String wcpOGx_mode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_unnamedtable5_Width ;
   private String Dvpanel_unnamedtable5_Cls ;
   private String Dvpanel_unnamedtable5_Title ;
   private String Dvpanel_unnamedtable5_Iconposition ;
   private String Dvpanel_unnamedtable6_Width ;
   private String Dvpanel_unnamedtable6_Cls ;
   private String Dvpanel_unnamedtable6_Title ;
   private String Dvpanel_unnamedtable6_Iconposition ;
   private String Dvpanel_unnamedtable7_Width ;
   private String Dvpanel_unnamedtable7_Cls ;
   private String Dvpanel_unnamedtable7_Title ;
   private String Dvpanel_unnamedtable7_Iconposition ;
   private String Gxuitabspanel_tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtable8_Internalname ;
   private String edtavId_Internalname ;
   private String edtavId_Jsonclick ;
   private String edtavGuid_Internalname ;
   private String TempTags ;
   private String AV41GUID ;
   private String edtavGuid_Jsonclick ;
   private String edtavName_Internalname ;
   private String AV49Name ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Internalname ;
   private String AV30Dsc ;
   private String edtavDsc_Jsonclick ;
   private String edtavVersion_Internalname ;
   private String AV64Version ;
   private String edtavVersion_Jsonclick ;
   private String edtavCompany_Internalname ;
   private String AV28Company ;
   private String edtavCompany_Jsonclick ;
   private String edtavCopyright_Internalname ;
   private String AV29Copyright ;
   private String edtavCopyright_Jsonclick ;
   private String edtavHomeobject_Internalname ;
   private String edtavHomeobject_Jsonclick ;
   private String edtavAccountactivationobject_Internalname ;
   private String edtavAccountactivationobject_Jsonclick ;
   private String edtavLogoutobject_Internalname ;
   private String edtavLogoutobject_Jsonclick ;
   private String divTablesplittedclientrevoked_Internalname ;
   private String lblTextblockclientrevoked_Internalname ;
   private String lblTextblockclientrevoked_Jsonclick ;
   private String lblRemoteauthentication_title_Internalname ;
   private String lblRemoteauthentication_title_Jsonclick ;
   private String divUnnamedtable4_Internalname ;
   private String edtavClientid_Internalname ;
   private String AV22ClientId ;
   private String edtavClientid_Jsonclick ;
   private String edtavClientsecret_Internalname ;
   private String AV27ClientSecret ;
   private String edtavClientsecret_Jsonclick ;
   private String Dvpanel_unnamedtable5_Internalname ;
   private String divUnnamedtable5_Internalname ;
   private String divTblwebauth_Internalname ;
   private String edtavClientimageurl_Internalname ;
   private String edtavClientimageurl_Jsonclick ;
   private String edtavClientlocalloginurl_Internalname ;
   private String edtavClientlocalloginurl_Jsonclick ;
   private String edtavClientcallbackurl_Internalname ;
   private String edtavClientcallbackurl_Jsonclick ;
   private String edtavClientcallbackurlstatename_Internalname ;
   private String AV65ClientCallbackURLStateName ;
   private String edtavClientcallbackurlstatename_Jsonclick ;
   private String Dvpanel_unnamedtable6_Internalname ;
   private String divUnnamedtable6_Internalname ;
   private String divTblrestauth_Internalname ;
   private String divTblgeneralauth_Internalname ;
   private String Dvpanel_unnamedtable7_Internalname ;
   private String divUnnamedtable7_Internalname ;
   private String divTablesplittedclientencryptionkey_Internalname ;
   private String lblTextblockclientencryptionkey_Internalname ;
   private String lblTextblockclientencryptionkey_Jsonclick ;
   private String edtavClientrepositoryguid_Internalname ;
   private String AV25ClientRepositoryGUID ;
   private String edtavClientrepositoryguid_Jsonclick ;
   private String lblSsorest_title_Internalname ;
   private String lblSsorest_title_Jsonclick ;
   private String divUnnamedtable3_Internalname ;
   private String divTablessorest_Internalname ;
   private String AV51SSORestMode ;
   private String divTblssorestmodeclient_Internalname ;
   private String edtavSsorestuserauthtypename_Internalname ;
   private String AV53SSORestUserAuthTypeName ;
   private String edtavSsorestuserauthtypename_Jsonclick ;
   private String edtavSsorestserverurl_Internalname ;
   private String edtavSsorestserverurl_Jsonclick ;
   private String lblSts_title_Internalname ;
   private String lblSts_title_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String divTablests_Internalname ;
   private String AV56STSMode ;
   private String divTablestsserverchecktoken_Internalname ;
   private String edtavStsauthorizationusername_Internalname ;
   private String edtavStsauthorizationusername_Jsonclick ;
   private String divStsserverclientpassword_cell_Internalname ;
   private String divStsserverclientpassword_cell_Class ;
   private String edtavStsserverclientpassword_Internalname ;
   private String AV58STSServerClientPassword ;
   private String edtavStsserverclientpassword_Jsonclick ;
   private String divTablestsclient_Internalname ;
   private String edtavStsserverurl_Internalname ;
   private String edtavStsserverurl_Jsonclick ;
   private String edtavStsserverrepositoryguid_Internalname ;
   private String AV59STSServerRepositoryGUID ;
   private String edtavStsserverrepositoryguid_Jsonclick ;
   private String lblEnvironmentsettings_title_Internalname ;
   private String lblEnvironmentsettings_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String edtavEnvironmentname_Internalname ;
   private String AV32EnvironmentName ;
   private String edtavEnvironmentname_Jsonclick ;
   private String edtavEnvironmenthost_Internalname ;
   private String AV31EnvironmentHost ;
   private String edtavEnvironmenthost_Jsonclick ;
   private String edtavEnvironmentport_Internalname ;
   private String edtavEnvironmentport_Jsonclick ;
   private String edtavEnvironmentvirtualdirectory_Internalname ;
   private String AV37EnvironmentVirtualDirectory ;
   private String edtavEnvironmentvirtualdirectory_Jsonclick ;
   private String edtavEnvironmentprogrampackage_Internalname ;
   private String AV35EnvironmentProgramPackage ;
   private String edtavEnvironmentprogrampackage_Jsonclick ;
   private String edtavEnvironmentprogramextension_Internalname ;
   private String AV34EnvironmentProgramExtension ;
   private String edtavEnvironmentprogramextension_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavStsauthorizationuserguid_Internalname ;
   private String AV54STSAuthorizationUserGUID ;
   private String edtavStsauthorizationuserguid_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavClientrevoked_Internalname ;
   private String AV21ClientEncryptionKey ;
   private String edtavClientencryptionkey_Internalname ;
   private String bttBtnrevokeallow_Caption ;
   private String bttBtnrevokeallow_Internalname ;
   private String bttBtngeneratekeygamremote_Internalname ;
   private String sStyleString ;
   private String tblTablemergedclientencryptionkey_Internalname ;
   private String edtavClientencryptionkey_Jsonclick ;
   private String bttBtngeneratekeygamremote_Jsonclick ;
   private String tblTablemergedclientrevoked_Internalname ;
   private String edtavClientrevoked_Jsonclick ;
   private String bttBtnrevokeallow_Jsonclick ;
   private java.util.Date AV26ClientRevoked ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_unnamedtable5_Autowidth ;
   private boolean Dvpanel_unnamedtable5_Autoheight ;
   private boolean Dvpanel_unnamedtable5_Collapsible ;
   private boolean Dvpanel_unnamedtable5_Collapsed ;
   private boolean Dvpanel_unnamedtable5_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable5_Autoscroll ;
   private boolean Dvpanel_unnamedtable6_Autowidth ;
   private boolean Dvpanel_unnamedtable6_Autoheight ;
   private boolean Dvpanel_unnamedtable6_Collapsible ;
   private boolean Dvpanel_unnamedtable6_Collapsed ;
   private boolean Dvpanel_unnamedtable6_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable6_Autoscroll ;
   private boolean Dvpanel_unnamedtable7_Autowidth ;
   private boolean Dvpanel_unnamedtable7_Autoheight ;
   private boolean Dvpanel_unnamedtable7_Collapsible ;
   private boolean Dvpanel_unnamedtable7_Collapsed ;
   private boolean Dvpanel_unnamedtable7_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable7_Autoscroll ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV61UseAbsoluteUrlByEnvironment ;
   private boolean AV5AccessRequiresPermission ;
   private boolean AV17ClientAllowRemoteAuth ;
   private boolean AV15ClientAllowGetUserRoles ;
   private boolean AV13ClientAllowGetUserAddData ;
   private boolean AV11ClientAllowGetSessionIniProp ;
   private boolean AV20ClientCallbackURLisCustom ;
   private boolean AV18ClientAllowRemoteRestAuth ;
   private boolean AV16ClientAllowGetUserRolesRest ;
   private boolean AV14ClientAllowGetUserAddDataRest ;
   private boolean AV12ClientAllowGetSessionIniPropRest ;
   private boolean AV8ClientAccessUniqueByUser ;
   private boolean AV50SSORestEnable ;
   private boolean AV57STSProtocolEnable ;
   private boolean AV36EnvironmentSecureProtocol ;
   private boolean AV7AutoRegisterAnomymousUser ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV44isOk ;
   private String AV42HomeObject ;
   private String AV66AccountActivationObject ;
   private String AV45LogoutObject ;
   private String AV23ClientImageURL ;
   private String AV24ClientLocalLoginURL ;
   private String AV19ClientCallbackURL ;
   private String AV52SSORestServerURL ;
   private String AV55STSAuthorizationUserName ;
   private String AV60STSServerURL ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable5 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable6 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable7 ;
   private ICheckbox chkavUseabsoluteurlbyenvironment ;
   private HTMLChoice cmbavMainmenu ;
   private ICheckbox chkavAccessrequirespermission ;
   private ICheckbox chkavClientallowremoteauth ;
   private ICheckbox chkavClientallowgetuserroles ;
   private ICheckbox chkavClientallowgetuseradddata ;
   private ICheckbox chkavClientallowgetsessioniniprop ;
   private ICheckbox chkavClientcallbackurliscustom ;
   private ICheckbox chkavClientallowremoterestauth ;
   private ICheckbox chkavClientallowgetuserrolesrest ;
   private ICheckbox chkavClientallowgetuseradddatarest ;
   private ICheckbox chkavClientallowgetsessioniniproprest ;
   private ICheckbox chkavClientaccessuniquebyuser ;
   private ICheckbox chkavSsorestenable ;
   private HTMLChoice cmbavSsorestmode ;
   private ICheckbox chkavStsprotocolenable ;
   private HTMLChoice cmbavStsmode ;
   private ICheckbox chkavEnvironmentsecureprotocol ;
   private ICheckbox chkavAutoregisteranomymoususer ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV39Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV63UserErrors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationMenu> AV72GXV1 ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV6Application ;
   private genexus.security.api.genexussecurity.SdtGAMError AV38Error ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationMenu AV47Menu ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationMenuFilter AV48MenuFilter ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV62User ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV40GAMUser ;
}

final  class gamapplicationentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamapplicationentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

