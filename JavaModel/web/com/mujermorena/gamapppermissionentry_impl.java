package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamapppermissionentry_impl extends GXDataArea
{
   public gamapppermissionentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamapppermissionentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamapppermissionentry_impl.class ));
   }

   public gamapppermissionentry_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavAccesstype = new HTMLChoice();
      chkavIsparent = UIFactory.getCheckbox(this);
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
               AV12GUID = httpContext.GetPar( "GUID") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12GUID", AV12GUID);
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
      pa2U2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2U2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV12GUID))}, new String[] {"Gx_mode","ApplicationId","GUID"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV7ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
         we2U2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2U2( ) ;
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
      return formatLink("com.mujermorena.gamapppermissionentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7ApplicationId,12,0)),GXutil.URLEncode(GXutil.rtrim(AV12GUID))}, new String[] {"Gx_mode","ApplicationId","GUID"})  ;
   }

   public String getPgmname( )
   {
      return "GAMAppPermissionEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_Permission", "") ;
   }

   public void wb2U0( )
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
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavGamapplication_name_Internalname, GXutil.rtrim( AV5GAMApplication.getgxTv_SdtGAMApplication_Name()), "", "", (short)(0), 1, edtavGamapplication_name_Enabled, 0, 80, "chr", 4, "row", (byte)(0), StyleString, ClassString, "", "", "254", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMAppPermissionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGuid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGuid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGuid_Internalname, GXutil.rtrim( AV12GUID), GXutil.rtrim( localUtil.format( AV12GUID, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGuid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGuid_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMAppPermissionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavName_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV14Name), GXutil.rtrim( localUtil.format( AV14Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMAppPermissionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDsc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDsc_Internalname, httpContext.getMessage( "WWP_GAM_Description", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV9Dsc), GXutil.rtrim( localUtil.format( AV9Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMAppPermissionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavAccesstype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavAccesstype.getInternalname(), httpContext.getMessage( "WWP_GAM_AccessType", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavAccesstype, cmbavAccesstype.getInternalname(), GXutil.rtrim( AV15AccessType), 1, cmbavAccesstype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavAccesstype.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "", true, (byte)(0), "HLP_GAMAppPermissionEntry.htm");
         cmbavAccesstype.setValue( GXutil.rtrim( AV15AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Values", cmbavAccesstype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsparent.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsparent.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsparent.getInternalname(), GXutil.booltostr( AV13IsParent), "", " ", 1, chkavIsparent.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IsaParentPermission", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(44, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,44);\"");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMAppPermissionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMAppPermissionEntry.htm");
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

   public void start2U2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_Permission", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2U0( ) ;
   }

   public void ws2U2( )
   {
      start2U2( ) ;
      evt2U2( ) ;
   }

   public void evt2U2( )
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
                           e112U2 ();
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
                                 e122U2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e132U2 ();
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

   public void we2U2( )
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

   public void pa2U2( )
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
      if ( cmbavAccesstype.getItemCount() > 0 )
      {
         AV15AccessType = cmbavAccesstype.getValidValue(AV15AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15AccessType", AV15AccessType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavAccesstype.setValue( GXutil.rtrim( AV15AccessType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Values", cmbavAccesstype.ToJavascriptSource(), true);
      }
      AV13IsParent = GXutil.strtobool( GXutil.booltostr( AV13IsParent)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsParent", AV13IsParent);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2U2( ) ;
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
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
   }

   public void rf2U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e132U2 ();
         wb2U0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2U2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vAPPLICATIONID", GXutil.ltrim( localUtil.ntoc( AV7ApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vAPPLICATIONID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7ApplicationId), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavGamapplication_name_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGamapplication_name_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGamapplication_name_Enabled), 5, 0), true);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup2U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112U2 ();
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
         AV14Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Name", AV14Name);
         AV9Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9Dsc", AV9Dsc);
         cmbavAccesstype.setValue( httpContext.cgiGet( cmbavAccesstype.getInternalname()) );
         AV15AccessType = httpContext.cgiGet( cmbavAccesstype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15AccessType", AV15AccessType);
         AV13IsParent = GXutil.strtobool( httpContext.cgiGet( chkavIsparent.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsParent", AV13IsParent);
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
      e112U2 ();
      if (returnInSub) return;
   }

   public void e112U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV5GAMApplication.load(AV7ApplicationId);
      chkavIsparent.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsparent.getInternalname(), "Enabled", GXutil.ltrimstr( chkavIsparent.getEnabled(), 5, 0), true);
      GXv_objcol_SdtGAMError1[0] = AV11Errors ;
      AV8ApplicationPermission = AV5GAMApplication.getpermissionbyguid(AV12GUID, GXv_objcol_SdtGAMError1);
      AV11Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         AV14Name = AV8ApplicationPermission.getgxTv_SdtGAMApplicationPermission_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14Name", AV14Name);
         AV9Dsc = AV8ApplicationPermission.getgxTv_SdtGAMApplicationPermission_Description() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9Dsc", AV9Dsc);
         AV15AccessType = AV8ApplicationPermission.getgxTv_SdtGAMApplicationPermission_Accesstype() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15AccessType", AV15AccessType);
         AV13IsParent = AV8ApplicationPermission.getgxTv_SdtGAMApplicationPermission_Isparent() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsParent", AV13IsParent);
      }
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
         cmbavAccesstype.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAccesstype.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAccesstype.getEnabled(), 5, 0), true);
         bttBtnenter_Caption = "Delete" ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e122U2 ();
      if (returnInSub) return;
   }

   public void e122U2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV5GAMApplication.load(AV7ApplicationId);
      GXv_objcol_SdtGAMError1[0] = AV11Errors ;
      AV8ApplicationPermission = AV5GAMApplication.getpermissionbyguid(AV12GUID, GXv_objcol_SdtGAMError1);
      AV11Errors = GXv_objcol_SdtGAMError1[0] ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         AV8ApplicationPermission.setgxTv_SdtGAMApplicationPermission_Name( AV14Name );
         AV8ApplicationPermission.setgxTv_SdtGAMApplicationPermission_Description( AV9Dsc );
         AV8ApplicationPermission.setgxTv_SdtGAMApplicationPermission_Accesstype( AV15AccessType );
         GXv_objcol_SdtGAMError1[0] = AV11Errors ;
         AV6isOK = AV5GAMApplication.addpermission(AV8ApplicationPermission, GXv_objcol_SdtGAMError1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
         AV11Errors = GXv_objcol_SdtGAMError1[0] ;
      }
      else if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         AV8ApplicationPermission.setgxTv_SdtGAMApplicationPermission_Name( AV14Name );
         AV8ApplicationPermission.setgxTv_SdtGAMApplicationPermission_Description( AV9Dsc );
         AV8ApplicationPermission.setgxTv_SdtGAMApplicationPermission_Accesstype( AV15AccessType );
         GXv_objcol_SdtGAMError1[0] = AV11Errors ;
         AV6isOK = AV5GAMApplication.updatepermission(AV8ApplicationPermission, GXv_objcol_SdtGAMError1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
         AV11Errors = GXv_objcol_SdtGAMError1[0] ;
      }
      else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXv_objcol_SdtGAMError1[0] = AV11Errors ;
         AV6isOK = AV5GAMApplication.deletepermission(AV8ApplicationPermission, GXv_objcol_SdtGAMError1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6isOK", AV6isOK);
         AV11Errors = GXv_objcol_SdtGAMError1[0] ;
      }
      if ( AV6isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamapppermissionentry");
         httpContext.setWebReturnParms(new Object[] {Gx_mode,Long.valueOf(AV7ApplicationId),AV12GUID});
         httpContext.setWebReturnParmsMetadata(new Object[] {"Gx_mode","AV7ApplicationId","AV12GUID"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         AV25GXV2 = 1 ;
         while ( AV25GXV2 <= AV11Errors.size() )
         {
            AV10Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV11Errors.elementAt(-1+AV25GXV2));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV10Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV10Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV25GXV2 = (int)(AV25GXV2+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5GAMApplication", AV5GAMApplication);
   }

   protected void nextLoad( )
   {
   }

   protected void e132U2( )
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
      AV12GUID = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12GUID", AV12GUID);
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
      pa2U2( ) ;
      ws2U2( ) ;
      we2U2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211117335", true, true);
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
      httpContext.AddJavascriptSource("gamapppermissionentry.js", "?20241211117339", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavGamapplication_name_Internalname = "GAMAPPLICATION_NAME" ;
      edtavGuid_Internalname = "vGUID" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavAccesstype.setInternalname( "vACCESSTYPE" );
      chkavIsparent.setInternalname( "vISPARENT" );
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
      edtavGamapplication_name_Enabled = -1 ;
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      chkavIsparent.setEnabled( 1 );
      cmbavAccesstype.setJsonclick( "" );
      cmbavAccesstype.setEnabled( 1 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      edtavGuid_Jsonclick = "" ;
      edtavGuid_Enabled = 0 ;
      edtavGamapplication_name_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_GAM_Permission", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_GAM_Permission", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavAccesstype.setName( "vACCESSTYPE" );
      cmbavAccesstype.setWebtags( "" );
      cmbavAccesstype.addItem("A", httpContext.getMessage( "WWP_GAM_Allow", ""), (short)(0));
      cmbavAccesstype.addItem("R", httpContext.getMessage( "WWP_GAM_Restricted", ""), (short)(0));
      if ( cmbavAccesstype.getItemCount() > 0 )
      {
         AV15AccessType = cmbavAccesstype.getValidValue(AV15AccessType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15AccessType", AV15AccessType);
      }
      chkavIsparent.setName( "vISPARENT" );
      chkavIsparent.setWebtags( "" );
      chkavIsparent.setCaption( httpContext.getMessage( "WWP_GAM_IsaParentPermission", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsparent.getInternalname(), "TitleCaption", chkavIsparent.getCaption(), true);
      chkavIsparent.setCheckedValue( "false" );
      AV13IsParent = GXutil.strtobool( GXutil.booltostr( AV13IsParent)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsParent", AV13IsParent);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13IsParent',fld:'vISPARENT',pic:''},{av:'AV7ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e122U2',iparms:[{av:'AV7ApplicationId',fld:'vAPPLICATIONID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV12GUID',fld:'vGUID',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV14Name',fld:'vNAME',pic:''},{av:'AV9Dsc',fld:'vDSC',pic:''},{av:'cmbavAccesstype'},{av:'AV15AccessType',fld:'vACCESSTYPE',pic:''},{av:'AV6isOK',fld:'vISOK',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV6isOK',fld:'vISOK',pic:''}]}");
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
      return "gamapppermissionentry_Execute";
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
      wcpOAV12GUID = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV12GUID = "" ;
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
      TempTags = "" ;
      AV14Name = "" ;
      AV9Dsc = "" ;
      AV15AccessType = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV8ApplicationPermission = new genexus.security.api.genexussecurity.SdtGAMApplicationPermission(remoteHandle, context);
      AV11Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV10Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamapppermissionentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamapppermissionentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavGamapplication_name_Enabled = 0 ;
      edtavGuid_Enabled = 0 ;
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
   private int edtavGuid_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int bttBtnenter_Visible ;
   private int AV25GXV2 ;
   private int idxLst ;
   private long wcpOAV7ApplicationId ;
   private long AV7ApplicationId ;
   private String wcpOGx_mode ;
   private String wcpOAV12GUID ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV12GUID ;
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
   private String edtavGuid_Internalname ;
   private String edtavGuid_Jsonclick ;
   private String edtavName_Internalname ;
   private String TempTags ;
   private String AV14Name ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Internalname ;
   private String AV9Dsc ;
   private String edtavDsc_Jsonclick ;
   private String AV15AccessType ;
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
   private boolean AV13IsParent ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV5GAMApplication ;
   private HTMLChoice cmbavAccesstype ;
   private ICheckbox chkavIsparent ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV11Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMError AV10Error ;
   private genexus.security.api.genexussecurity.SdtGAMApplicationPermission AV8ApplicationPermission ;
}

final  class gamapppermissionentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamapppermissionentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

