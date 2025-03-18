package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamappmenuoptionentry_impl extends GXDataArea
{
   public gamappmenuoptionentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamappmenuoptionentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamappmenuoptionentry_impl.class ));
   }

   public gamappmenuoptionentry_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavType = new HTMLChoice();
      cmbavMenusid = new HTMLChoice();
      cmbavRelresid = new HTMLChoice();
      cmbavLink = new HTMLChoice();
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
               AV7ApplicationId = GXutil.lval( httpContext.GetPar( "ApplicationId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV7ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ApplicationId), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
               AV16MenuId = GXutil.lval( httpContext.GetPar( "MenuId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16MenuId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16MenuId), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16MenuId), "ZZZZZZZZZZZ9")));
               AV14Id = GXutil.lval( httpContext.GetPar( "Id")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Id), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
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
      pa3L2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start3L2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamappmenuoptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ApplicationId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16MenuId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14Id,12,0))}, new String[] {"Gx_mode","ApplicationId","MenuId","Id"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16MenuId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV7ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMENUID", GXutil.ltrim( localUtil.ntoc( AV16MenuId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16MenuId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV14Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISOK", AV6isOK);
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
         we3L2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt3L2( ) ;
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
      return formatLink("com.mujermorena.gamappmenuoptionentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ApplicationId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV16MenuId,12,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14Id,12,0))}, new String[] {"Gx_mode","ApplicationId","MenuId","Id"})  ;
   }

   public String getPgmname( )
   {
      return "GAMAppMenuOptionEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_MenuOption", "") ;
   }

   public void wb3L0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-lg-6", "left", "top", "", "", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamapplication_name_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamapplication_name_Internalname, httpContext.getMessage( "WWP_GAM_Application", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavGamapplication_name_Internalname, GXutil.rtrim( AV5GAMApplication.getgxTv_SdtGAMApplication_Name()), "", "", (short)(0), 1, edtavGamapplication_name_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "254", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavApplicationmenu_name_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavApplicationmenu_name_Internalname, httpContext.getMessage( "WWP_GAM_Menu", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavApplicationmenu_name_Internalname, GXutil.rtrim( AV8ApplicationMenu.getgxTv_SdtGAMApplicationMenu_Name()), "", "", (short)(0), 1, edtavApplicationmenu_name_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "254", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGuid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGuid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGuid_Internalname, GXutil.rtrim( AV13GUID), GXutil.rtrim( localUtil.format( AV13GUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGuid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavGuid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV18Name), GXutil.rtrim( localUtil.format( AV18Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDsc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDsc_Internalname, httpContext.getMessage( "WWP_GAM_Description", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV10Dsc), GXutil.rtrim( localUtil.format( AV10Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavType.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavType.getInternalname(), httpContext.getMessage( "WWP_GAM_Type", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavType, cmbavType.getInternalname(), GXutil.rtrim( AV24Type), 1, cmbavType.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVTYPE.CLICK."+"'", "char", "", 1, cmbavType.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "", true, (byte)(0), "HLP_GAMAppMenuOptionEntry.htm");
         cmbavType.setValue( GXutil.rtrim( AV24Type) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavType.getInternalname(), "Values", cmbavType.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divMenusid_cell_Internalname, 1, 0, "px", 0, "px", divMenusid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavMenusid.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMenusid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavMenusid.getInternalname(), httpContext.getMessage( "WWP_GAM_Submenu", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMenusid, cmbavMenusid.getInternalname(), GXutil.trim( GXutil.str( AV17MenusId, 12, 0)), 1, cmbavMenusid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavMenusid.getVisible(), cmbavMenusid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "", true, (byte)(0), "HLP_GAMAppMenuOptionEntry.htm");
         cmbavMenusid.setValue( GXutil.trim( GXutil.str( AV17MenusId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMenusid.getInternalname(), "Values", cmbavMenusid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divRelresid_cell_Internalname, 1, 0, "px", 0, "px", divRelresid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavRelresid.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavRelresid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavRelresid.getInternalname(), httpContext.getMessage( "WWP_GAM_Permission", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavRelresid, cmbavRelresid.getInternalname(), GXutil.rtrim( AV21RelResId), 1, cmbavRelresid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavRelresid.getVisible(), cmbavRelresid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(0), "HLP_GAMAppMenuOptionEntry.htm");
         cmbavRelresid.setValue( GXutil.rtrim( AV21RelResId) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRelresid.getInternalname(), "Values", cmbavRelresid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavResource_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavResource_Internalname, httpContext.getMessage( "WWP_GAM_Resource", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavResource_Internalname, AV22Resource, GXutil.rtrim( localUtil.format( AV22Resource, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavResource_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavResource_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavResourceparameters_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavResourceparameters_Internalname, httpContext.getMessage( "WWP_GAM_ResourceParameters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavResourceparameters_Internalname, AV23ResourceParameters, GXutil.rtrim( localUtil.format( AV23ResourceParameters, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavResourceparameters_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavResourceparameters_Enabled, 1, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMURL", "left", true, "", "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavIconclass_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavIconclass_Internalname, httpContext.getMessage( "WWP_GAM_IconClass", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavIconclass_Internalname, AV30IconClass, GXutil.rtrim( localUtil.format( AV30IconClass, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavIconclass_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavIconclass_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLink.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavLink.getInternalname(), httpContext.getMessage( "WWP_GAM_LinkTarget", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLink, cmbavLink.getInternalname(), GXutil.rtrim( AV31Link), 1, cmbavLink.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavLink.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,71);\"", "", true, (byte)(0), "HLP_GAMAppMenuOptionEntry.htm");
         cmbavLink.setValue( GXutil.rtrim( AV31Link) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLink.getInternalname(), "Values", cmbavLink.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMAppMenuOptionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMAppMenuOptionEntry.htm");
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

   public void start3L2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_MenuOption", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup3L0( ) ;
   }

   public void ws3L2( )
   {
      start3L2( ) ;
      evt3L2( ) ;
   }

   public void evt3L2( )
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
                           e113L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VTYPE.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e123L2 ();
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
                                 e133L2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VRELRESID.ISVALID") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e143L2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e153L2 ();
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

   public void we3L2( )
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

   public void pa3L2( )
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
            GX_FocusControl = edtavGamapplication_name_Internalname ;
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
      if ( cmbavType.getItemCount() > 0 )
      {
         AV24Type = cmbavType.getValidValue(AV24Type) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Type", AV24Type);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavType.setValue( GXutil.rtrim( AV24Type) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavType.getInternalname(), "Values", cmbavType.ToJavascriptSource(), true);
      }
      if ( cmbavMenusid.getItemCount() > 0 )
      {
         AV17MenusId = GXutil.lval( cmbavMenusid.getValidValue(GXutil.trim( GXutil.str( AV17MenusId, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17MenusId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17MenusId), 12, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMenusid.setValue( GXutil.trim( GXutil.str( AV17MenusId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMenusid.getInternalname(), "Values", cmbavMenusid.ToJavascriptSource(), true);
      }
      if ( cmbavRelresid.getItemCount() > 0 )
      {
         AV21RelResId = cmbavRelresid.getValidValue(AV21RelResId) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21RelResId", AV21RelResId);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavRelresid.setValue( GXutil.rtrim( AV21RelResId) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRelresid.getInternalname(), "Values", cmbavRelresid.ToJavascriptSource(), true);
      }
      if ( cmbavLink.getItemCount() > 0 )
      {
         AV31Link = cmbavLink.getValidValue(AV31Link) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Link", AV31Link);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLink.setValue( GXutil.rtrim( AV31Link) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLink.getInternalname(), "Values", cmbavLink.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3L2( ) ;
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
      edtavGamapplication_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamapplication_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamapplication_name_Enabled), 5, 0), true);
      edtavApplicationmenu_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavApplicationmenu_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApplicationmenu_name_Enabled), 5, 0), true);
   }

   public void rf3L2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e153L2 ();
         wb3L0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3L2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV7ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMENUID", GXutil.ltrim( localUtil.ntoc( AV16MenuId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16MenuId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV14Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavGamapplication_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamapplication_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamapplication_name_Enabled), 5, 0), true);
      edtavApplicationmenu_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavApplicationmenu_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavApplicationmenu_name_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup3L0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e113L2 ();
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
         AV5GAMApplication.setgxTv_SdtGAMApplication_Name( httpContext.cgiGet( edtavGamapplication_name_Internalname) );
         AV8ApplicationMenu.setgxTv_SdtGAMApplicationMenu_Name( httpContext.cgiGet( edtavApplicationmenu_name_Internalname) );
         AV13GUID = httpContext.cgiGet( edtavGuid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13GUID", AV13GUID);
         AV18Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Name", AV18Name);
         AV10Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10Dsc", AV10Dsc);
         cmbavType.setValue( httpContext.cgiGet( cmbavType.getInternalname()) );
         AV24Type = httpContext.cgiGet( cmbavType.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Type", AV24Type);
         cmbavMenusid.setValue( httpContext.cgiGet( cmbavMenusid.getInternalname()) );
         AV17MenusId = GXutil.lval( httpContext.cgiGet( cmbavMenusid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17MenusId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17MenusId), 12, 0));
         cmbavRelresid.setValue( httpContext.cgiGet( cmbavRelresid.getInternalname()) );
         AV21RelResId = httpContext.cgiGet( cmbavRelresid.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21RelResId", AV21RelResId);
         AV22Resource = httpContext.cgiGet( edtavResource_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Resource", AV22Resource);
         AV23ResourceParameters = httpContext.cgiGet( edtavResourceparameters_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ResourceParameters", AV23ResourceParameters);
         AV30IconClass = httpContext.cgiGet( edtavIconclass_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30IconClass", AV30IconClass);
         cmbavLink.setValue( httpContext.cgiGet( cmbavLink.getInternalname()) );
         AV31Link = httpContext.cgiGet( cmbavLink.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Link", AV31Link);
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
      e113L2 ();
      if (returnInSub) return;
   }

   public void e113L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV5GAMApplication.load(AV7ApplicationId);
      GXv_objcol_SdtGAMError1[0] = AV12Errors ;
      AV8ApplicationMenu = AV5GAMApplication.getmenu(AV16MenuId, GXv_objcol_SdtGAMError1);
      AV12Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         GXv_objcol_SdtGAMError1[0] = AV12Errors ;
         AV9ApplicationMenuOption = AV8ApplicationMenu.getmenuoptionbyid(AV7ApplicationId, AV14Id, GXv_objcol_SdtGAMError1);
         AV12Errors = GXv_objcol_SdtGAMError1[0] ;
         AV18Name = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Name", AV18Name);
         AV10Dsc = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Description() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10Dsc", AV10Dsc);
         AV13GUID = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Guid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13GUID", AV13GUID);
         AV24Type = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Type() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Type", AV24Type);
         AV17MenusId = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Submenuid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17MenusId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17MenusId), 12, 0));
         AV21RelResId = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Permissionresourceguid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21RelResId", AV21RelResId);
         AV22Resource = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Resource() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Resource", AV22Resource);
         AV23ResourceParameters = AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Resourceparameters() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ResourceParameters", AV23ResourceParameters);
         if ( AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Properties().size() > 0 )
         {
            AV30IconClass = ((genexus.security.api.genexussecurity.SdtGAMProperty)AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Properties().elementAt(-1+1)).getgxTv_SdtGAMProperty_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30IconClass", AV30IconClass);
            AV31Link = ((genexus.security.api.genexussecurity.SdtGAMProperty)AV9ApplicationMenuOption.getgxTv_SdtGAMApplicationMenuOption_Properties().elementAt(-1+2)).getgxTv_SdtGAMProperty_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31Link", AV31Link);
         }
         edtavGuid_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
         if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
         {
            if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
            {
               bttBtnenter_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
            }
            edtavName_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
            edtavDsc_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavDsc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDsc_Enabled), 5, 0), true);
            cmbavType.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavType.getEnabled(), 5, 0), true);
            cmbavMenusid.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavMenusid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMenusid.getEnabled(), 5, 0), true);
            cmbavRelresid.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavRelresid.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavRelresid.getEnabled(), 5, 0), true);
            edtavResource_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavResource_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResource_Enabled), 5, 0), true);
            edtavResourceparameters_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavResourceparameters_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResourceparameters_Enabled), 5, 0), true);
            bttBtnenter_Caption = httpContext.getMessage( "Delete", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
            cmbavLink.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavLink.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavLink.getEnabled(), 5, 0), true);
            edtavIconclass_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavIconclass_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconclass_Enabled), 5, 0), true);
         }
      }
      if ( GXutil.strcmp(AV24Type, "S") == 0 )
      {
         AV40GXV4 = 1 ;
         GXv_objcol_SdtGAMError1[0] = AV12Errors ;
         AV39GXV3 = AV5GAMApplication.getpermissions(AV20PermissionFilter, GXv_objcol_SdtGAMError1) ;
         AV12Errors = GXv_objcol_SdtGAMError1[0] ;
         while ( AV40GXV4 <= AV39GXV3.size() )
         {
            AV19Permission = (genexus.security.api.genexussecurity.SdtGAMApplicationPermission)((genexus.security.api.genexussecurity.SdtGAMApplicationPermission)AV39GXV3.elementAt(-1+AV40GXV4));
            cmbavRelresid.addItem(AV19Permission.getgxTv_SdtGAMApplicationPermission_Guid(), AV19Permission.getgxTv_SdtGAMApplicationPermission_Name(), (short)(0));
            AV40GXV4 = (int)(AV40GXV4+1) ;
         }
      }
      else
      {
         AV42GXV6 = 1 ;
         GXv_objcol_SdtGAMError1[0] = AV12Errors ;
         AV41GXV5 = AV5GAMApplication.getsubmenus(AV16MenuId, GXv_objcol_SdtGAMError1) ;
         AV12Errors = GXv_objcol_SdtGAMError1[0] ;
         while ( AV42GXV6 <= AV41GXV5.size() )
         {
            AV15Menu = (genexus.security.api.genexussecurity.SdtGAMApplicationMenu)((genexus.security.api.genexussecurity.SdtGAMApplicationMenu)AV41GXV5.elementAt(-1+AV42GXV6));
            cmbavMenusid.addItem(GXutil.trim( GXutil.str( AV15Menu.getgxTv_SdtGAMApplicationMenu_Id(), 12, 0)), AV15Menu.getgxTv_SdtGAMApplicationMenu_Name(), (short)(0));
            AV42GXV6 = (int)(AV42GXV6+1) ;
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
      if ( ! ( ( GXutil.strcmp(AV24Type, "M") == 0 ) ) )
      {
         cmbavMenusid.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMenusid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMenusid.getVisible(), 5, 0), true);
         divMenusid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenusid_cell_Internalname, "Class", divMenusid_cell_Class, true);
      }
      else
      {
         cmbavMenusid.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMenusid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavMenusid.getVisible(), 5, 0), true);
         divMenusid_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divMenusid_cell_Internalname, "Class", divMenusid_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(AV24Type, "S") == 0 ) ) )
      {
         cmbavRelresid.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRelresid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavRelresid.getVisible(), 5, 0), true);
         divRelresid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divRelresid_cell_Internalname, "Class", divRelresid_cell_Class, true);
      }
      else
      {
         cmbavRelresid.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRelresid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavRelresid.getVisible(), 5, 0), true);
         divRelresid_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divRelresid_cell_Internalname, "Class", divRelresid_cell_Class, true);
      }
   }

   public void e123L2( )
   {
      /* Type_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      if ( GXutil.strcmp(AV24Type, "S") == 0 )
      {
         if ( (GXutil.strcmp("", AV21RelResId)==0) )
         {
            AV5GAMApplication.load(AV7ApplicationId);
            AV44GXV8 = 1 ;
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV43GXV7 = AV5GAMApplication.getpermissions(AV20PermissionFilter, GXv_objcol_SdtGAMError1) ;
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
            while ( AV44GXV8 <= AV43GXV7.size() )
            {
               AV19Permission = (genexus.security.api.genexussecurity.SdtGAMApplicationPermission)((genexus.security.api.genexussecurity.SdtGAMApplicationPermission)AV43GXV7.elementAt(-1+AV44GXV8));
               cmbavRelresid.addItem(AV19Permission.getgxTv_SdtGAMApplicationPermission_Guid(), AV19Permission.getgxTv_SdtGAMApplicationPermission_Name(), (short)(0));
               AV44GXV8 = (int)(AV44GXV8+1) ;
            }
         }
      }
      else
      {
         if ( (0==AV17MenusId) )
         {
            AV5GAMApplication.load(AV7ApplicationId);
            AV46GXV10 = 1 ;
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV45GXV9 = AV5GAMApplication.getsubmenus(AV16MenuId, GXv_objcol_SdtGAMError1) ;
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
            while ( AV46GXV10 <= AV45GXV9.size() )
            {
               AV15Menu = (genexus.security.api.genexussecurity.SdtGAMApplicationMenu)((genexus.security.api.genexussecurity.SdtGAMApplicationMenu)AV45GXV9.elementAt(-1+AV46GXV10));
               cmbavMenusid.addItem(GXutil.trim( GXutil.str( AV15Menu.getgxTv_SdtGAMApplicationMenu_Id(), 12, 0)), AV15Menu.getgxTv_SdtGAMApplicationMenu_Name(), (short)(0));
               AV46GXV10 = (int)(AV46GXV10+1) ;
            }
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5GAMApplication", AV5GAMApplication);
      cmbavRelresid.setValue( GXutil.rtrim( AV21RelResId) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavRelresid.getInternalname(), "Values", cmbavRelresid.ToJavascriptSource(), true);
      cmbavMenusid.setValue( GXutil.trim( GXutil.str( AV17MenusId, 12, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavMenusid.getInternalname(), "Values", cmbavMenusid.ToJavascriptSource(), true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e133L2 ();
      if (returnInSub) return;
   }

   public void e133L2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV5GAMApplication.load(AV7ApplicationId);
      if ( ! (GXutil.strcmp("", AV18Name)==0) )
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            /* Execute user subroutine: 'LOAD_APPLICATIONMENUOPTION' */
            S122 ();
            if (returnInSub) return;
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV6isOK = AV5GAMApplication.addmenuoption(AV16MenuId, AV9ApplicationMenuOption, GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
         }
         else if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
         {
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV9ApplicationMenuOption = AV5GAMApplication.getmenuoption(AV16MenuId, AV14Id, GXv_objcol_SdtGAMError1);
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
            /* Execute user subroutine: 'LOAD_APPLICATIONMENUOPTION' */
            S122 ();
            if (returnInSub) return;
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV6isOK = AV5GAMApplication.updatemenuoption(AV16MenuId, AV9ApplicationMenuOption, GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
         }
         else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV9ApplicationMenuOption = AV5GAMApplication.getmenuoption(AV16MenuId, AV14Id, GXv_objcol_SdtGAMError1);
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
            GXv_objcol_SdtGAMError1[0] = AV12Errors ;
            AV6isOK = AV5GAMApplication.deletemenuoption(AV16MenuId, AV9ApplicationMenuOption, GXv_objcol_SdtGAMError1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
            AV12Errors = GXv_objcol_SdtGAMError1[0] ;
         }
      }
      else
      {
         AV6isOK = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
         AV11Error = (genexus.security.api.genexussecurity.SdtGAMError)new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
         AV11Error.setgxTv_SdtGAMError_Code( 239 );
         AV11Error.setgxTv_SdtGAMError_Message( genexus.security.api.genexussecuritycommon.gxdomaingamerrormessages.getDescription(httpContext,(long)AV11Error.getgxTv_SdtGAMError_Code()) );
         AV12Errors.add(AV11Error, 0);
      }
      if ( AV6isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamappmenuoptionentry");
         httpContext.setWebReturnParms(new Object[] {Gx_mode,Long.valueOf(AV7ApplicationId),Long.valueOf(AV16MenuId),Long.valueOf(AV14Id)});
         httpContext.setWebReturnParmsMetadata(new Object[] {"Gx_mode","AV7ApplicationId","AV16MenuId","AV14Id"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         AV47GXV11 = 1 ;
         while ( AV47GXV11 <= AV12Errors.size() )
         {
            AV11Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV12Errors.elementAt(-1+AV47GXV11));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV11Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV11Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV47GXV11 = (int)(AV47GXV11+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5GAMApplication", AV5GAMApplication);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV9ApplicationMenuOption", AV9ApplicationMenuOption);
   }

   public void e143L2( )
   {
      /* Relresid_Isvalid Routine */
      returnInSub = false ;
      AV5GAMApplication.load(AV7ApplicationId);
      GXv_objcol_SdtGAMError1[0] = AV12Errors ;
      AV19Permission = AV5GAMApplication.getpermissionbyguid(AV21RelResId, GXv_objcol_SdtGAMError1);
      AV12Errors = GXv_objcol_SdtGAMError1[0] ;
      AV22Resource = AV19Permission.getgxTv_SdtGAMApplicationPermission_Resource() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Resource", AV22Resource);
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5GAMApplication", AV5GAMApplication);
   }

   public void S122( )
   {
      /* 'LOAD_APPLICATIONMENUOPTION' Routine */
      returnInSub = false ;
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Guid( AV13GUID );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Name( AV18Name );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Description( AV10Dsc );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Type( AV24Type );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Submenuid( AV17MenusId );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Permissionresourceguid( AV21RelResId );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Resource( AV22Resource );
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Resourceparameters( AV23ResourceParameters );
      AV33GAMPropertyCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMProperty>(genexus.security.api.genexussecurity.SdtGAMProperty.class, "GAMProperty", "http://tempuri.org/", remoteHandle) ;
      AV32GAMProperty = (genexus.security.api.genexussecurity.SdtGAMProperty)new genexus.security.api.genexussecurity.SdtGAMProperty(remoteHandle, context);
      AV32GAMProperty.setgxTv_SdtGAMProperty_Id( httpContext.getMessage( "IconClass", "") );
      AV32GAMProperty.setgxTv_SdtGAMProperty_Value( AV30IconClass );
      AV33GAMPropertyCollection.add(AV32GAMProperty, 0);
      AV32GAMProperty = (genexus.security.api.genexussecurity.SdtGAMProperty)new genexus.security.api.genexussecurity.SdtGAMProperty(remoteHandle, context);
      AV32GAMProperty.setgxTv_SdtGAMProperty_Id( httpContext.getMessage( "Link", "") );
      AV32GAMProperty.setgxTv_SdtGAMProperty_Value( AV31Link );
      AV33GAMPropertyCollection.add(AV32GAMProperty, 0);
      AV9ApplicationMenuOption.setgxTv_SdtGAMApplicationMenuOption_Properties( AV33GAMPropertyCollection );
   }

   protected void nextLoad( )
   {
   }

   protected void e153L2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV7ApplicationId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7ApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7ApplicationId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
      AV16MenuId = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16MenuId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16MenuId), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV16MenuId), "ZZZZZZZZZZZ9")));
      AV14Id = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Id), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14Id), "ZZZZZZZZZZZ9")));
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
      pa3L2( ) ;
      ws3L2( ) ;
      we3L2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211122269", true, true);
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
      httpContext.AddJavascriptSource("gamappmenuoptionentry.js", "?20241211122272", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavGamapplication_name_Internalname = "GAMAPPLICATION_NAME" ;
      edtavApplicationmenu_name_Internalname = "APPLICATIONMENU_NAME" ;
      edtavGuid_Internalname = "vGUID" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavType.setInternalname( "vTYPE" );
      cmbavMenusid.setInternalname( "vMENUSID" );
      divMenusid_cell_Internalname = "MENUSID_CELL" ;
      cmbavRelresid.setInternalname( "vRELRESID" );
      divRelresid_cell_Internalname = "RELRESID_CELL" ;
      edtavResource_Internalname = "vRESOURCE" ;
      edtavResourceparameters_Internalname = "vRESOURCEPARAMETERS" ;
      edtavIconclass_Internalname = "vICONCLASS" ;
      cmbavLink.setInternalname( "vLINK" );
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
      edtavApplicationmenu_name_Enabled = -1 ;
      edtavGamapplication_name_Enabled = -1 ;
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      cmbavLink.setJsonclick( "" );
      cmbavLink.setEnabled( 1 );
      edtavIconclass_Jsonclick = "" ;
      edtavIconclass_Enabled = 1 ;
      edtavResourceparameters_Jsonclick = "" ;
      edtavResourceparameters_Enabled = 1 ;
      edtavResource_Jsonclick = "" ;
      edtavResource_Enabled = 1 ;
      cmbavRelresid.setJsonclick( "" );
      cmbavRelresid.setEnabled( 1 );
      cmbavRelresid.setVisible( 1 );
      divRelresid_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavMenusid.setJsonclick( "" );
      cmbavMenusid.setEnabled( 1 );
      cmbavMenusid.setVisible( 1 );
      divMenusid_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavType.setJsonclick( "" );
      cmbavType.setEnabled( 1 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      edtavGuid_Jsonclick = "" ;
      edtavGuid_Enabled = 1 ;
      edtavApplicationmenu_name_Enabled = 0 ;
      edtavGamapplication_name_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "Menu Option", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_GAM_MenuOption", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavType.setName( "vTYPE" );
      cmbavType.setWebtags( "" );
      cmbavType.addItem("S", httpContext.getMessage( "WWP_GAM_Simple", ""), (short)(0));
      cmbavType.addItem("M", httpContext.getMessage( "WWP_GAM_Menu", ""), (short)(0));
      if ( cmbavType.getItemCount() > 0 )
      {
         AV24Type = cmbavType.getValidValue(AV24Type) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Type", AV24Type);
      }
      cmbavMenusid.setName( "vMENUSID" );
      cmbavMenusid.setWebtags( "" );
      if ( cmbavMenusid.getItemCount() > 0 )
      {
         AV17MenusId = GXutil.lval( cmbavMenusid.getValidValue(GXutil.trim( GXutil.str( AV17MenusId, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17MenusId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17MenusId), 12, 0));
      }
      cmbavRelresid.setName( "vRELRESID" );
      cmbavRelresid.setWebtags( "" );
      if ( cmbavRelresid.getItemCount() > 0 )
      {
         AV21RelResId = cmbavRelresid.getValidValue(AV21RelResId) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21RelResId", AV21RelResId);
      }
      cmbavLink.setName( "vLINK" );
      cmbavLink.setWebtags( "" );
      cmbavLink.addItem("", httpContext.getMessage( "", ""), (short)(0));
      cmbavLink.addItem("_blank", httpContext.getMessage( "Blank", ""), (short)(0));
      if ( cmbavLink.getItemCount() > 0 )
      {
         AV31Link = cmbavLink.getValidValue(AV31Link) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31Link", AV31Link);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV7ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV16MenuId',fld:'vMENUID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV14Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VTYPE.CLICK","{handler:'e123L2',iparms:[{av:'cmbavType'},{av:'AV24Type',fld:'vTYPE',pic:''},{av:'cmbavRelresid'},{av:'AV21RelResId',fld:'vRELRESID',pic:''},{av:'AV7ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'cmbavMenusid'},{av:'AV17MenusId',fld:'vMENUSID',pic:'ZZZZZZZZZZZ9'},{av:'AV16MenuId',fld:'vMENUID',pic:'ZZZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("VTYPE.CLICK",",oparms:[{av:'cmbavRelresid'},{av:'AV21RelResId',fld:'vRELRESID',pic:''},{av:'cmbavMenusid'},{av:'AV17MenusId',fld:'vMENUSID',pic:'ZZZZZZZZZZZ9'},{av:'divMenusid_cell_Class',ctrl:'MENUSID_CELL',prop:'Class'},{av:'divRelresid_cell_Class',ctrl:'RELRESID_CELL',prop:'Class'}]}");
      setEventMetadata("ENTER","{handler:'e133L2',iparms:[{av:'AV7ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV18Name',fld:'vNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV16MenuId',fld:'vMENUID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV14Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV6isOK',fld:'vISOK',pic:''},{av:'AV13GUID',fld:'vGUID',pic:''},{av:'AV10Dsc',fld:'vDSC',pic:''},{av:'cmbavType'},{av:'AV24Type',fld:'vTYPE',pic:''},{av:'cmbavMenusid'},{av:'AV17MenusId',fld:'vMENUSID',pic:'ZZZZZZZZZZZ9'},{av:'cmbavRelresid'},{av:'AV21RelResId',fld:'vRELRESID',pic:''},{av:'AV22Resource',fld:'vRESOURCE',pic:''},{av:'AV23ResourceParameters',fld:'vRESOURCEPARAMETERS',pic:''},{av:'AV30IconClass',fld:'vICONCLASS',pic:''},{av:'cmbavLink'},{av:'AV31Link',fld:'vLINK',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV6isOK',fld:'vISOK',pic:''}]}");
      setEventMetadata("VRELRESID.ISVALID","{handler:'e143L2',iparms:[{av:'AV7ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'cmbavRelresid'},{av:'AV21RelResId',fld:'vRELRESID',pic:''}]");
      setEventMetadata("VRELRESID.ISVALID",",oparms:[{av:'AV22Resource',fld:'vRESOURCE',pic:''}]}");
      setEventMetadata("VALIDV_TYPE","{handler:'validv_Type',iparms:[]");
      setEventMetadata("VALIDV_TYPE",",oparms:[]}");
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
      return "gamappmenuoptionentry_Execute";
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
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      AV5GAMApplication = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV8ApplicationMenu = new genexus.security.api.genexussecurity.SdtGAMApplicationMenu(remoteHandle, context);
      TempTags = "" ;
      AV13GUID = "" ;
      AV18Name = "" ;
      AV10Dsc = "" ;
      AV24Type = "" ;
      AV21RelResId = "" ;
      AV22Resource = "" ;
      AV23ResourceParameters = "" ;
      AV30IconClass = "" ;
      AV31Link = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV12Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV9ApplicationMenuOption = new genexus.security.api.genexussecurity.SdtGAMApplicationMenuOption(remoteHandle, context);
      AV39GXV3 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationPermission>(genexus.security.api.genexussecurity.SdtGAMApplicationPermission.class, "GAMApplicationPermission", "http://tempuri.org/", remoteHandle);
      AV20PermissionFilter = new genexus.security.api.genexussecurity.SdtGAMApplicationPermissionFilter(remoteHandle, context);
      AV19Permission = new genexus.security.api.genexussecurity.SdtGAMApplicationPermission(remoteHandle, context);
      AV41GXV5 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationMenu>(genexus.security.api.genexussecurity.SdtGAMApplicationMenu.class, "GAMApplicationMenu", "http://tempuri.org/", remoteHandle);
      AV15Menu = new genexus.security.api.genexussecurity.SdtGAMApplicationMenu(remoteHandle, context);
      AV43GXV7 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationPermission>(genexus.security.api.genexussecurity.SdtGAMApplicationPermission.class, "GAMApplicationPermission", "http://tempuri.org/", remoteHandle);
      AV45GXV9 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationMenu>(genexus.security.api.genexussecurity.SdtGAMApplicationMenu.class, "GAMApplicationMenu", "http://tempuri.org/", remoteHandle);
      AV11Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV33GAMPropertyCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMProperty>(genexus.security.api.genexussecurity.SdtGAMProperty.class, "GAMProperty", "http://tempuri.org/", remoteHandle);
      AV32GAMProperty = new genexus.security.api.genexussecurity.SdtGAMProperty(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamappmenuoptionentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamappmenuoptionentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavGamapplication_name_Enabled = 0 ;
      edtavApplicationmenu_name_Enabled = 0 ;
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
   private int edtavGamapplication_name_Enabled ;
   private int edtavApplicationmenu_name_Enabled ;
   private int edtavGuid_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavResource_Enabled ;
   private int edtavResourceparameters_Enabled ;
   private int edtavIconclass_Enabled ;
   private int bttBtnenter_Visible ;
   private int AV40GXV4 ;
   private int AV42GXV6 ;
   private int AV44GXV8 ;
   private int AV46GXV10 ;
   private int AV47GXV11 ;
   private int idxLst ;
   private long wcpOAV7ApplicationId ;
   private long wcpOAV16MenuId ;
   private long wcpOAV14Id ;
   private long AV7ApplicationId ;
   private long AV16MenuId ;
   private long AV14Id ;
   private long AV17MenusId ;
   private String wcpOGx_mode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
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
   private String edtavGamapplication_name_Internalname ;
   private String edtavApplicationmenu_name_Internalname ;
   private String edtavGuid_Internalname ;
   private String TempTags ;
   private String AV13GUID ;
   private String edtavGuid_Jsonclick ;
   private String edtavName_Internalname ;
   private String AV18Name ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Internalname ;
   private String AV10Dsc ;
   private String edtavDsc_Jsonclick ;
   private String AV24Type ;
   private String divMenusid_cell_Internalname ;
   private String divMenusid_cell_Class ;
   private String divRelresid_cell_Internalname ;
   private String divRelresid_cell_Class ;
   private String AV21RelResId ;
   private String edtavResource_Internalname ;
   private String edtavResource_Jsonclick ;
   private String edtavResourceparameters_Internalname ;
   private String edtavResourceparameters_Jsonclick ;
   private String edtavIconclass_Internalname ;
   private String edtavIconclass_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV6isOK ;
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
   private String AV22Resource ;
   private String AV23ResourceParameters ;
   private String AV30IconClass ;
   private String AV31Link ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV5GAMApplication ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationMenu AV8ApplicationMenu ;
   private HTMLChoice cmbavType ;
   private HTMLChoice cmbavMenusid ;
   private HTMLChoice cmbavRelresid ;
   private HTMLChoice cmbavLink ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMProperty> AV33GAMPropertyCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV12Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationPermission> AV39GXV3 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationPermission> AV43GXV7 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationMenu> AV41GXV5 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMApplicationMenu> AV45GXV9 ;
   private genexus.security.api.genexussecurity.SdtGAMProperty AV32GAMProperty ;
   private genexus.security.api.genexussecurity.SdtGAMError AV11Error ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationPermission AV19Permission ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationPermissionFilter AV20PermissionFilter ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationMenu AV15Menu ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationMenuOption AV9ApplicationMenuOption ;
}

final  class gamappmenuoptionentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamappmenuoptionentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

