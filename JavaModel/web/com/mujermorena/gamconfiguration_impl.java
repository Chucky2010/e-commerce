package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamconfiguration_impl extends GXDataArea
{
   public gamconfiguration_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamconfiguration_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamconfiguration_impl.class ));
   }

   public gamconfiguration_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavDefaultrepository = new HTMLChoice();
      cmbavEnabletracing = new HTMLChoice();
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
      pa3N2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start3N2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamconfiguration", new String[] {}, new String[] {}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"GAMConfiguration");
      forbiddenHiddens.add("GAMDatabaseVersion", GXutil.rtrim( localUtil.format( AV12GAMDatabaseVersion, "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("gamconfiguration:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
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
         we3N2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt3N2( ) ;
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
      return formatLink("com.mujermorena.gamconfiguration", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "GAMConfiguration" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "GAM Configuration", "") ;
   }

   public void wb3N0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamdatabaseversion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamdatabaseversion_Internalname, httpContext.getMessage( "Database version", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamdatabaseversion_Internalname, GXutil.rtrim( AV12GAMDatabaseVersion), GXutil.rtrim( localUtil.format( AV12GAMDatabaseVersion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamdatabaseversion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGamdatabaseversion_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamapiversion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamapiversion_Internalname, httpContext.getMessage( "API version", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamapiversion_Internalname, GXutil.rtrim( AV11GAMAPIVersion), GXutil.rtrim( localUtil.format( AV11GAMAPIVersion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamapiversion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGamapiversion_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divDefaultrepository_cell_Internalname, 1, 0, "px", 0, "px", divDefaultrepository_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavDefaultrepository.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDefaultrepository.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavDefaultrepository.getInternalname(), httpContext.getMessage( "Default repository", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDefaultrepository, cmbavDefaultrepository.getInternalname(), GXutil.rtrim( AV5DefaultRepository), 1, cmbavDefaultrepository.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavDefaultrepository.getVisible(), cmbavDefaultrepository.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_GAMConfiguration.htm");
         cmbavDefaultrepository.setValue( GXutil.rtrim( AV5DefaultRepository) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultrepository.getInternalname(), "Values", cmbavDefaultrepository.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailregularexpression_cell_Internalname, 1, 0, "px", 0, "px", divEmailregularexpression_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailregularexpression_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailregularexpression_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailregularexpression_Internalname, httpContext.getMessage( "Custom email regular expression", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailregularexpression_Internalname, AV6EmailRegularExpression, GXutil.rtrim( localUtil.format( AV6EmailRegularExpression, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailregularexpression_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailregularexpression_Visible, edtavEmailregularexpression_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEnabletracing.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavEnabletracing.getInternalname(), httpContext.getMessage( "Enable tracing", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEnabletracing, cmbavEnabletracing.getInternalname(), GXutil.trim( GXutil.str( AV7EnableTracing, 4, 0)), 1, cmbavEnabletracing.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavEnabletracing.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_GAMConfiguration.htm");
         cmbavEnabletracing.setValue( GXutil.trim( GXutil.str( AV7EnableTracing, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEnabletracing.getInternalname(), "Values", cmbavEnabletracing.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConfiguration.htm");
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

   public void start3N2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "GAM Configuration", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup3N0( ) ;
   }

   public void ws3N2( )
   {
      start3N2( ) ;
      evt3N2( ) ;
   }

   public void evt3N2( )
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
                           e113N2 ();
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
                                 e123N2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e133N2 ();
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

   public void we3N2( )
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

   public void pa3N2( )
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
            GX_FocusControl = edtavGamdatabaseversion_Internalname ;
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
      if ( cmbavDefaultrepository.getItemCount() > 0 )
      {
         AV5DefaultRepository = cmbavDefaultrepository.getValidValue(AV5DefaultRepository) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5DefaultRepository", AV5DefaultRepository);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDefaultrepository.setValue( GXutil.rtrim( AV5DefaultRepository) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultrepository.getInternalname(), "Values", cmbavDefaultrepository.ToJavascriptSource(), true);
      }
      if ( cmbavEnabletracing.getItemCount() > 0 )
      {
         AV7EnableTracing = (short)(GXutil.lval( cmbavEnabletracing.getValidValue(GXutil.trim( GXutil.str( AV7EnableTracing, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EnableTracing", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EnableTracing), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEnabletracing.setValue( GXutil.trim( GXutil.str( AV7EnableTracing, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEnabletracing.getInternalname(), "Values", cmbavEnabletracing.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3N2( ) ;
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
      edtavGamdatabaseversion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamdatabaseversion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamdatabaseversion_Enabled), 5, 0), true);
      edtavGamapiversion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamapiversion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamapiversion_Enabled), 5, 0), true);
   }

   public void rf3N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e133N2 ();
         wb3N0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3N2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavGamdatabaseversion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamdatabaseversion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamdatabaseversion_Enabled), 5, 0), true);
      edtavGamapiversion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamapiversion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamapiversion_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup3N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e113N2 ();
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
         AV12GAMDatabaseVersion = httpContext.cgiGet( edtavGamdatabaseversion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12GAMDatabaseVersion", AV12GAMDatabaseVersion);
         AV11GAMAPIVersion = httpContext.cgiGet( edtavGamapiversion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11GAMAPIVersion", AV11GAMAPIVersion);
         cmbavDefaultrepository.setValue( httpContext.cgiGet( cmbavDefaultrepository.getInternalname()) );
         AV5DefaultRepository = httpContext.cgiGet( cmbavDefaultrepository.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5DefaultRepository", AV5DefaultRepository);
         AV6EmailRegularExpression = httpContext.cgiGet( edtavEmailregularexpression_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6EmailRegularExpression", AV6EmailRegularExpression);
         cmbavEnabletracing.setValue( httpContext.cgiGet( cmbavEnabletracing.getInternalname()) );
         AV7EnableTracing = (short)(GXutil.lval( httpContext.cgiGet( cmbavEnabletracing.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EnableTracing", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EnableTracing), 4, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"GAMConfiguration");
         AV12GAMDatabaseVersion = httpContext.cgiGet( edtavGamdatabaseversion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12GAMDatabaseVersion", AV12GAMDatabaseVersion);
         forbiddenHiddens.add("GAMDatabaseVersion", GXutil.rtrim( localUtil.format( AV12GAMDatabaseVersion, "")));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("gamconfiguration:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e113N2 ();
      if (returnInSub) return;
   }

   public void e113N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV24GXV2 = 1 ;
      AV23GXV1 = genexus.security.api.genexussecuritycommon.gxdomaingamversion.getValues() ;
      while ( AV24GXV2 <= AV23GXV1.size() )
      {
         AV11GAMAPIVersion = (String)AV23GXV1.elementAt(-1+AV24GXV2) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11GAMAPIVersion", AV11GAMAPIVersion);
         if (true) break;
         AV24GXV2 = (int)(AV24GXV2+1) ;
      }
      GXv_char1[0] = AV12GAMDatabaseVersion ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdatabaseversion(GXv_char1) ;
      gamconfiguration_impl.this.AV12GAMDatabaseVersion = GXv_char1[0] ;
      GXv_int2[0] = AV7EnableTracing ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getenabletracing(GXv_int2) ;
      gamconfiguration_impl.this.AV7EnableTracing = GXv_int2[0] ;
      GXv_char1[0] = AV5DefaultRepository ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getdefaultrepository(GXv_char1) ;
      gamconfiguration_impl.this.AV5DefaultRepository = GXv_char1[0] ;
      GXv_char1[0] = AV6EmailRegularExpression ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getregularexpressiontovalidateemail(GXv_char1) ;
      gamconfiguration_impl.this.AV6EmailRegularExpression = GXv_char1[0] ;
      GXv_objcol_SdtGAMError3[0] = AV9Errors ;
      AV17isAdminGAM = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isgamadministrator(GXv_objcol_SdtGAMError3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17isAdminGAM", AV17isAdminGAM);
      AV9Errors = GXv_objcol_SdtGAMError3[0] ;
      cmbavDefaultrepository.removeAllItems();
      if ( ! (GXutil.strcmp("", AV5DefaultRepository)==0) || new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).ismultitenant() )
      {
         if ( AV17isAdminGAM )
         {
            cmbavDefaultrepository.addItem("", "(none)", (short)(0));
         }
         AV18LoadDefaultOK = false ;
         GXv_objcol_SdtGAMError3[0] = AV9Errors ;
         AV14GAMRepositoryCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getallrepositories(AV10Filter, GXv_objcol_SdtGAMError3) ;
         AV9Errors = GXv_objcol_SdtGAMError3[0] ;
         if ( AV14GAMRepositoryCollection.size() > 0 )
         {
            AV25GXV3 = 1 ;
            while ( AV25GXV3 <= AV14GAMRepositoryCollection.size() )
            {
               AV15GAMRepositoryItem = (genexus.security.api.genexussecurity.SdtGAMRepository)((genexus.security.api.genexussecurity.SdtGAMRepository)AV14GAMRepositoryCollection.elementAt(-1+AV25GXV3));
               if ( (0==AV15GAMRepositoryItem.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
               {
                  if ( GXutil.strcmp(AV15GAMRepositoryItem.getgxTv_SdtGAMRepository_Guid(), AV5DefaultRepository) == 0 )
                  {
                     AV18LoadDefaultOK = true ;
                  }
                  cmbavDefaultrepository.addItem(AV15GAMRepositoryItem.getgxTv_SdtGAMRepository_Guid(), AV15GAMRepositoryItem.getgxTv_SdtGAMRepository_Name(), (short)(0));
               }
               AV25GXV3 = (int)(AV25GXV3+1) ;
            }
         }
         if ( ! AV18LoadDefaultOK && ! (GXutil.strcmp("", AV5DefaultRepository)==0) )
         {
            cmbavDefaultrepository.removeAllItems();
            cmbavDefaultrepository.addItem(AV5DefaultRepository, AV5DefaultRepository, (short)(0));
         }
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ! (GXutil.strcmp("", AV5DefaultRepository)==0) || new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).ismultitenant() ) )
      {
         cmbavDefaultrepository.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultrepository.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultrepository.getVisible(), 5, 0), true);
         divDefaultrepository_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultrepository_cell_Internalname, "Class", divDefaultrepository_cell_Class, true);
      }
      else
      {
         cmbavDefaultrepository.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultrepository.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultrepository.getVisible(), 5, 0), true);
         divDefaultrepository_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultrepository_cell_Internalname, "Class", divDefaultrepository_cell_Class, true);
      }
      if ( ! ( AV17isAdminGAM ) )
      {
         edtavEmailregularexpression_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailregularexpression_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailregularexpression_Visible), 5, 0), true);
         divEmailregularexpression_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailregularexpression_cell_Internalname, "Class", divEmailregularexpression_cell_Class, true);
      }
      else
      {
         edtavEmailregularexpression_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailregularexpression_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailregularexpression_Visible), 5, 0), true);
         divEmailregularexpression_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailregularexpression_cell_Internalname, "Class", divEmailregularexpression_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e123N2 ();
      if (returnInSub) return;
   }

   public void e123N2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setenabletracing(AV7EnableTracing) ;
      if ( AV16isOk )
      {
         AV13GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
         GXv_objcol_SdtGAMError3[0] = AV9Errors ;
         if ( new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).isgamadministrator(GXv_objcol_SdtGAMError3) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV9Errors = GXv_objcol_SdtGAMError3[0] ;
         if ( Cond_result )
         {
            AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setregularexpressiontovalidateemail(AV6EmailRegularExpression) ;
            AV9Errors = GXv_objcol_SdtGAMError3[0] ;
            AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).setdefaultrepository(AV5DefaultRepository) ;
            if ( AV16isOk )
            {
               httpContext.GX_msglist.addItem(httpContext.getMessage( httpContext.getMessage( "GXM_sucupdated", ""), ""));
            }
            else
            {
               httpContext.GX_msglist.addItem("Default repository could not be saved");
            }
         }
         else
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( httpContext.getMessage( "GXM_sucupdated", ""), ""));
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("Tracing status could not be saved");
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e133N2( )
   {
      /* Load Routine */
      returnInSub = false ;
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
      pa3N2( ) ;
      ws3N2( ) ;
      we3N2( ) ;
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
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211121526", true, true);
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
      httpContext.AddJavascriptSource("gamconfiguration.js", "?202412111215218", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavGamdatabaseversion_Internalname = "vGAMDATABASEVERSION" ;
      edtavGamapiversion_Internalname = "vGAMAPIVERSION" ;
      cmbavDefaultrepository.setInternalname( "vDEFAULTREPOSITORY" );
      divDefaultrepository_cell_Internalname = "DEFAULTREPOSITORY_CELL" ;
      edtavEmailregularexpression_Internalname = "vEMAILREGULAREXPRESSION" ;
      divEmailregularexpression_cell_Internalname = "EMAILREGULAREXPRESSION_CELL" ;
      cmbavEnabletracing.setInternalname( "vENABLETRACING" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      cmbavEnabletracing.setJsonclick( "" );
      cmbavEnabletracing.setEnabled( 1 );
      edtavEmailregularexpression_Jsonclick = "" ;
      edtavEmailregularexpression_Enabled = 1 ;
      edtavEmailregularexpression_Visible = 1 ;
      divEmailregularexpression_cell_Class = "col-xs-12" ;
      cmbavDefaultrepository.setJsonclick( "" );
      cmbavDefaultrepository.setEnabled( 1 );
      cmbavDefaultrepository.setVisible( 1 );
      divDefaultrepository_cell_Class = "col-xs-12" ;
      edtavGamapiversion_Jsonclick = "" ;
      edtavGamapiversion_Enabled = 1 ;
      edtavGamdatabaseversion_Jsonclick = "" ;
      edtavGamdatabaseversion_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "GAM Configuration", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "GAM Configuration", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavDefaultrepository.setName( "vDEFAULTREPOSITORY" );
      cmbavDefaultrepository.setWebtags( "" );
      if ( cmbavDefaultrepository.getItemCount() > 0 )
      {
         AV5DefaultRepository = cmbavDefaultrepository.getValidValue(AV5DefaultRepository) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5DefaultRepository", AV5DefaultRepository);
      }
      cmbavEnabletracing.setName( "vENABLETRACING" );
      cmbavEnabletracing.setWebtags( "" );
      cmbavEnabletracing.addItem("0", httpContext.getMessage( "0 - Off", ""), (short)(0));
      cmbavEnabletracing.addItem("1", httpContext.getMessage( "1 - Debug", ""), (short)(0));
      if ( cmbavEnabletracing.getItemCount() > 0 )
      {
         AV7EnableTracing = (short)(GXutil.lval( cmbavEnabletracing.getValidValue(GXutil.trim( GXutil.str( AV7EnableTracing, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7EnableTracing", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7EnableTracing), 4, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV12GAMDatabaseVersion',fld:'vGAMDATABASEVERSION',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e123N2',iparms:[{av:'cmbavEnabletracing'},{av:'AV7EnableTracing',fld:'vENABLETRACING',pic:'ZZZ9'},{av:'AV6EmailRegularExpression',fld:'vEMAILREGULAREXPRESSION',pic:''},{av:'cmbavDefaultrepository'},{av:'AV5DefaultRepository',fld:'vDEFAULTREPOSITORY',pic:''}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("VALIDV_ENABLETRACING","{handler:'validv_Enabletracing',iparms:[]");
      setEventMetadata("VALIDV_ENABLETRACING",",oparms:[]}");
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
      return "gamconfiguration_Execute";
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
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV12GAMDatabaseVersion = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV11GAMAPIVersion = "" ;
      AV5DefaultRepository = "" ;
      AV6EmailRegularExpression = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      hsh = "" ;
      AV23GXV1 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int2 = new short[1] ;
      GXv_char1 = new String[1] ;
      AV9Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV14GAMRepositoryCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRepository>(genexus.security.api.genexussecurity.SdtGAMRepository.class, "GAMRepository", "http://tempuri.org/", remoteHandle);
      AV10Filter = new genexus.security.api.genexussecurity.SdtGAMRepositoryFilter(remoteHandle, context);
      AV15GAMRepositoryItem = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV13GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      GXv_objcol_SdtGAMError3 = new GXExternalCollection[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavGamdatabaseversion_Enabled = 0 ;
      edtavGamapiversion_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV7EnableTracing ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short GXv_int2[] ;
   private int edtavGamdatabaseversion_Enabled ;
   private int edtavGamapiversion_Enabled ;
   private int edtavEmailregularexpression_Visible ;
   private int edtavEmailregularexpression_Enabled ;
   private int AV24GXV2 ;
   private int AV25GXV3 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV12GAMDatabaseVersion ;
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
   private String edtavGamdatabaseversion_Internalname ;
   private String TempTags ;
   private String edtavGamdatabaseversion_Jsonclick ;
   private String edtavGamapiversion_Internalname ;
   private String AV11GAMAPIVersion ;
   private String edtavGamapiversion_Jsonclick ;
   private String divDefaultrepository_cell_Internalname ;
   private String divDefaultrepository_cell_Class ;
   private String AV5DefaultRepository ;
   private String divEmailregularexpression_cell_Internalname ;
   private String divEmailregularexpression_cell_Class ;
   private String edtavEmailregularexpression_Internalname ;
   private String edtavEmailregularexpression_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String hsh ;
   private String GXv_char1[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
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
   private boolean AV16isOk ;
   private boolean AV17isAdminGAM ;
   private boolean AV18LoadDefaultOK ;
   private boolean Cond_result ;
   private String AV6EmailRegularExpression ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavDefaultrepository ;
   private HTMLChoice cmbavEnabletracing ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV23GXV1 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV9Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError3[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRepository> AV14GAMRepositoryCollection ;
   private genexus.security.api.genexussecurity.SdtGAMRepositoryFilter AV10Filter ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV15GAMRepositoryItem ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV13GAMRepository ;
}

