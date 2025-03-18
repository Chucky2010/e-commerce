package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class asignarcaja_impl extends GXDataArea
{
   public asignarcaja_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public asignarcaja_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( asignarcaja_impl.class ));
   }

   public asignarcaja_impl( int remoteHandle ,
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
      pa572( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start572( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.asignarcaja", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11UserName, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCAJAID_DATA", AV8CajaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCAJAID_DATA", AV8CajaId_Data);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "CAJAID", GXutil.ltrim( localUtil.ntoc( A25CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "CAJAASIGANACION", GXutil.rtrim( A255CajaAsiganacion));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERNAME", AV11UserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11UserName, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "CAJAESTADO", GXutil.rtrim( A253CajaEstado));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_CAJAID_Cls", GXutil.rtrim( Combo_cajaid_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_CAJAID_Selectedvalue_set", GXutil.rtrim( Combo_cajaid_Selectedvalue_set));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_CAJAID_Emptyitemtext", GXutil.rtrim( Combo_cajaid_Emptyitemtext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Width", GXutil.rtrim( Dvpanel_panel1_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Autowidth", GXutil.booltostr( Dvpanel_panel1_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Autoheight", GXutil.booltostr( Dvpanel_panel1_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Cls", GXutil.rtrim( Dvpanel_panel1_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Title", GXutil.rtrim( Dvpanel_panel1_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Collapsible", GXutil.booltostr( Dvpanel_panel1_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Collapsed", GXutil.booltostr( Dvpanel_panel1_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Showcollapseicon", GXutil.booltostr( Dvpanel_panel1_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Iconposition", GXutil.rtrim( Dvpanel_panel1_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANEL1_Autoscroll", GXutil.booltostr( Dvpanel_panel1_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "COMBO_CAJAID_Selectedvalue_get", GXutil.rtrim( Combo_cajaid_Selectedvalue_get));
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
         we572( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt572( ) ;
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
      return formatLink("com.mujermorena.asignarcaja", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "AsignarCaja" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Asignar Caja", "") ;
   }

   public void wb570( )
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
         ucDvpanel_panel1.setProperty("Width", Dvpanel_panel1_Width);
         ucDvpanel_panel1.setProperty("AutoWidth", Dvpanel_panel1_Autowidth);
         ucDvpanel_panel1.setProperty("AutoHeight", Dvpanel_panel1_Autoheight);
         ucDvpanel_panel1.setProperty("Cls", Dvpanel_panel1_Cls);
         ucDvpanel_panel1.setProperty("Title", Dvpanel_panel1_Title);
         ucDvpanel_panel1.setProperty("Collapsible", Dvpanel_panel1_Collapsible);
         ucDvpanel_panel1.setProperty("Collapsed", Dvpanel_panel1_Collapsed);
         ucDvpanel_panel1.setProperty("ShowCollapseIcon", Dvpanel_panel1_Showcollapseicon);
         ucDvpanel_panel1.setProperty("IconPosition", Dvpanel_panel1_Iconposition);
         ucDvpanel_panel1.setProperty("AutoScroll", Dvpanel_panel1_Autoscroll);
         ucDvpanel_panel1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panel1_Internalname, "DVPANEL_PANEL1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANEL1Container"+"Panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divPanel1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop ExtendedComboCell", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedcajaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_cajaid_Internalname, httpContext.getMessage( "Caja Id", ""), "", "", lblTextblockcombo_cajaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_AsignarCaja.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_cajaid.setProperty("Caption", Combo_cajaid_Caption);
         ucCombo_cajaid.setProperty("Cls", Combo_cajaid_Cls);
         ucCombo_cajaid.setProperty("EmptyItemText", Combo_cajaid_Emptyitemtext);
         ucCombo_cajaid.setProperty("DropDownOptionsData", AV8CajaId_Data);
         ucCombo_cajaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_cajaid_Internalname, "COMBO_CAJAIDContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_AsignarCaja.htm");
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCajaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV7CajaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV7CajaId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCajaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCajaid_Visible, 1, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_AsignarCaja.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start572( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Asignar Caja", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup570( ) ;
   }

   public void ws572( )
   {
      start572( ) ;
      evt572( ) ;
   }

   public void evt572( )
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
                           e11572 ();
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
                                 e12572 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e13572 ();
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

   public void we572( )
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

   public void pa572( )
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
            GX_FocusControl = edtavCajaid_Internalname ;
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
      rf572( ) ;
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

   public void rf572( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e13572 ();
         wb570( ) ;
      }
   }

   public void send_integrity_lvl_hashes572( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUSERNAME", AV11UserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11UserName, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup570( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11572 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCAJAID_DATA"), AV8CajaId_Data);
         /* Read saved values. */
         Combo_cajaid_Cls = httpContext.cgiGet( "COMBO_CAJAID_Cls") ;
         Combo_cajaid_Selectedvalue_set = httpContext.cgiGet( "COMBO_CAJAID_Selectedvalue_set") ;
         Combo_cajaid_Emptyitemtext = httpContext.cgiGet( "COMBO_CAJAID_Emptyitemtext") ;
         Dvpanel_panel1_Width = httpContext.cgiGet( "DVPANEL_PANEL1_Width") ;
         Dvpanel_panel1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEL1_Autowidth")) ;
         Dvpanel_panel1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEL1_Autoheight")) ;
         Dvpanel_panel1_Cls = httpContext.cgiGet( "DVPANEL_PANEL1_Cls") ;
         Dvpanel_panel1_Title = httpContext.cgiGet( "DVPANEL_PANEL1_Title") ;
         Dvpanel_panel1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEL1_Collapsible")) ;
         Dvpanel_panel1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEL1_Collapsed")) ;
         Dvpanel_panel1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEL1_Showcollapseicon")) ;
         Dvpanel_panel1_Iconposition = httpContext.cgiGet( "DVPANEL_PANEL1_Iconposition") ;
         Dvpanel_panel1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANEL1_Autoscroll")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCajaid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCajaid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCAJAID");
            GX_FocusControl = edtavCajaid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7CajaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CajaId), 11, 0));
         }
         else
         {
            AV7CajaId = localUtil.ctol( httpContext.cgiGet( edtavCajaid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CajaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CajaId), 11, 0));
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
      e11572 ();
      if (returnInSub) return;
   }

   public void e11572( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV10GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV11UserName = AV10GAMUser.getgxTv_SdtGAMUser_Name() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11UserName", AV11UserName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUSERNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11UserName, ""))));
      edtavCajaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCajaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCajaid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCAJAID' */
      S112 ();
      if (returnInSub) return;
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e12572 ();
      if (returnInSub) return;
   }

   public void e12572( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV14Asig = (byte)(0) ;
      /* Using cursor H00572 */
      pr_default.execute(0, new Object[] {AV11UserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A253CajaEstado = H00572_A253CajaEstado[0] ;
         A255CajaAsiganacion = H00572_A255CajaAsiganacion[0] ;
         A25CajaId = H00572_A25CajaId[0] ;
         if ( GXutil.strcmp(A253CajaEstado, httpContext.getMessage( "ASIGNADO", "")) == 0 )
         {
            AV14Asig = (byte)(1) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV14Asig == 0 )
      {
         new com.mujermorena.prcasignarcaja(remoteHandle, context).execute( AV7CajaId) ;
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Caja Abierta con Exito", ""));
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El usuario ya tiene asignado una caja", ""));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCAJAID' Routine */
      returnInSub = false ;
      /* Using cursor H00573 */
      pr_default.execute(1);
      while ( (pr_default.getStatus(1) != 101) )
      {
         A253CajaEstado = H00573_A253CajaEstado[0] ;
         A25CajaId = H00573_A25CajaId[0] ;
         A111CajaNombreUsuario = H00573_A111CajaNombreUsuario[0] ;
         if ( GXutil.strcmp(A253CajaEstado, httpContext.getMessage( "LIBRE", "")) == 0 )
         {
            AV9Combo_DataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A25CajaId, 11, 0)) );
            AV9Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A111CajaNombreUsuario );
            AV8CajaId_Data.add(AV9Combo_DataItem, 0);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      Combo_cajaid_Selectedvalue_set = ((0==AV7CajaId) ? "" : GXutil.trim( GXutil.str( AV7CajaId, 11, 0))) ;
      ucCombo_cajaid.sendProperty(context, "", false, Combo_cajaid_Internalname, "SelectedValue_set", Combo_cajaid_Selectedvalue_set);
   }

   protected void nextLoad( )
   {
   }

   protected void e13572( )
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
      pa572( ) ;
      ws572( ) ;
      we572( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211122282", true, true);
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
      httpContext.AddJavascriptSource("asignarcaja.js", "?20241211122284", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblockcombo_cajaid_Internalname = "TEXTBLOCKCOMBO_CAJAID" ;
      Combo_cajaid_Internalname = "COMBO_CAJAID" ;
      divTablesplittedcajaid_Internalname = "TABLESPLITTEDCAJAID" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      divPanel1_Internalname = "PANEL1" ;
      Dvpanel_panel1_Internalname = "DVPANEL_PANEL1" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCajaid_Internalname = "vCAJAID" ;
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
      edtavCajaid_Jsonclick = "" ;
      edtavCajaid_Visible = 1 ;
      Dvpanel_panel1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panel1_Iconposition = "Right" ;
      Dvpanel_panel1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panel1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panel1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panel1_Title = httpContext.getMessage( "Asignar Caja", "") ;
      Dvpanel_panel1_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_panel1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panel1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panel1_Width = "100%" ;
      Combo_cajaid_Emptyitemtext = "::SeleccionarCaja::" ;
      Combo_cajaid_Cls = "ExtendedCombo AttributeRealWidth" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Asignar Caja", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV11UserName',fld:'vUSERNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e12572',iparms:[{av:'A25CajaId',fld:'CAJAID',pic:'ZZZZZZZZZZ9'},{av:'A255CajaAsiganacion',fld:'CAJAASIGANACION',pic:''},{av:'AV11UserName',fld:'vUSERNAME',pic:'',hsh:true},{av:'A253CajaEstado',fld:'CAJAESTADO',pic:''},{av:'AV7CajaId',fld:'vCAJAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[]}");
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
      return "asignarcaja_Execute";
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
      Combo_cajaid_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV11UserName = "" ;
      GXKey = "" ;
      AV8CajaId_Data = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A255CajaAsiganacion = "" ;
      A253CajaEstado = "" ;
      Combo_cajaid_Selectedvalue_set = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_panel1 = new com.genexus.webpanels.GXUserControl();
      lblTextblockcombo_cajaid_Jsonclick = "" ;
      ucCombo_cajaid = new com.genexus.webpanels.GXUserControl();
      Combo_cajaid_Caption = "" ;
      TempTags = "" ;
      bttBtnenter_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV10GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      scmdbuf = "" ;
      H00572_A253CajaEstado = new String[] {""} ;
      H00572_A255CajaAsiganacion = new String[] {""} ;
      H00572_A25CajaId = new long[1] ;
      H00573_A253CajaEstado = new String[] {""} ;
      H00573_A25CajaId = new long[1] ;
      H00573_A111CajaNombreUsuario = new String[] {""} ;
      A111CajaNombreUsuario = "" ;
      AV9Combo_DataItem = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.asignarcaja__default(),
         new Object[] {
             new Object[] {
            H00572_A253CajaEstado, H00572_A255CajaAsiganacion, H00572_A25CajaId
            }
            , new Object[] {
            H00573_A253CajaEstado, H00573_A25CajaId, H00573_A111CajaNombreUsuario
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV14Asig ;
   private byte nGXWrapped ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtavCajaid_Visible ;
   private int idxLst ;
   private long A25CajaId ;
   private long AV7CajaId ;
   private String Combo_cajaid_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String A255CajaAsiganacion ;
   private String A253CajaEstado ;
   private String Combo_cajaid_Cls ;
   private String Combo_cajaid_Selectedvalue_set ;
   private String Combo_cajaid_Emptyitemtext ;
   private String Dvpanel_panel1_Width ;
   private String Dvpanel_panel1_Cls ;
   private String Dvpanel_panel1_Title ;
   private String Dvpanel_panel1_Iconposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_panel1_Internalname ;
   private String divPanel1_Internalname ;
   private String divTablesplittedcajaid_Internalname ;
   private String lblTextblockcombo_cajaid_Internalname ;
   private String lblTextblockcombo_cajaid_Jsonclick ;
   private String Combo_cajaid_Caption ;
   private String Combo_cajaid_Internalname ;
   private String TempTags ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavCajaid_Internalname ;
   private String edtavCajaid_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String A111CajaNombreUsuario ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_panel1_Autowidth ;
   private boolean Dvpanel_panel1_Autoheight ;
   private boolean Dvpanel_panel1_Collapsible ;
   private boolean Dvpanel_panel1_Collapsed ;
   private boolean Dvpanel_panel1_Showcollapseicon ;
   private boolean Dvpanel_panel1_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV11UserName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panel1 ;
   private com.genexus.webpanels.GXUserControl ucCombo_cajaid ;
   private IDataStoreProvider pr_default ;
   private String[] H00572_A253CajaEstado ;
   private String[] H00572_A255CajaAsiganacion ;
   private long[] H00572_A25CajaId ;
   private String[] H00573_A253CajaEstado ;
   private long[] H00573_A25CajaId ;
   private String[] H00573_A111CajaNombreUsuario ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV8CajaId_Data ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTComboData_Item AV9Combo_DataItem ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV10GAMUser ;
}

final  class asignarcaja__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00572", "SELECT [CajaEstado], [CajaAsiganacion], [CajaId] FROM [Caja] WHERE [CajaAsiganacion] = ? ORDER BY [CajaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00573", "SELECT [CajaEstado], [CajaId], [CajaNombreUsuario] FROM [Caja] ORDER BY [CajaNombreUsuario] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
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

