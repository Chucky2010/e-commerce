package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamconnectionentry_impl extends GXDataArea
{
   public gamconnectionentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamconnectionentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamconnectionentry_impl.class ));
   }

   public gamconnectionentry_impl( int remoteHandle ,
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridwwsysconns") == 0 )
         {
            gxnrgridwwsysconns_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridwwsysconns") == 0 )
         {
            gxgrgridwwsysconns_refresh_invoke( ) ;
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
            Gx_mode = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV19pConnectionName = httpContext.GetPar( "pConnectionName") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV19pConnectionName", AV19pConnectionName);
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

   public void gxnrgridwwsysconns_newrow_invoke( )
   {
      nRC_GXsfl_85 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_85"))) ;
      nGXsfl_85_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_85_idx"))) ;
      sGXsfl_85_idx = httpContext.GetPar( "sGXsfl_85_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridwwsysconns_newrow( ) ;
      /* End function gxnrGridwwsysconns_newrow_invoke */
   }

   public void gxgrgridwwsysconns_refresh_invoke( )
   {
      subGridwwsysconns_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridwwsysconns_Rows"))) ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV23CurrentConnectionKey = httpContext.GetPar( "CurrentConnectionKey") ;
      AV12FileXML = httpContext.GetPar( "FileXML") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridwwsysconns_refresh( subGridwwsysconns_Rows, Gx_mode, AV23CurrentConnectionKey, AV12FileXML) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridwwsysconns_refresh_invoke */
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
      pa332( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start332( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamconnectionentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV19pConnectionName))}, new String[] {"Gx_mode","pConnectionName"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTCONNECTIONKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23CurrentConnectionKey, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEXML", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12FileXML, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_85", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_85, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCURRENTCONNECTIONKEY", GXutil.rtrim( AV23CurrentConnectionKey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTCONNECTIONKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23CurrentConnectionKey, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vFILEXML", GXutil.rtrim( AV12FileXML));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEXML", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12FileXML, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_Rows", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Width", GXutil.rtrim( Dvpanel_unnamedtable3_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable3_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable3_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Cls", GXutil.rtrim( Dvpanel_unnamedtable3_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Title", GXutil.rtrim( Dvpanel_unnamedtable3_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable3_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable3_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable3_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Width", GXutil.rtrim( Dvpanel_tbladdconnkey_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Autowidth", GXutil.booltostr( Dvpanel_tbladdconnkey_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Autoheight", GXutil.booltostr( Dvpanel_tbladdconnkey_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Cls", GXutil.rtrim( Dvpanel_tbladdconnkey_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Title", GXutil.rtrim( Dvpanel_tbladdconnkey_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Collapsible", GXutil.booltostr( Dvpanel_tbladdconnkey_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Collapsed", GXutil.booltostr( Dvpanel_tbladdconnkey_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Showcollapseicon", GXutil.booltostr( Dvpanel_tbladdconnkey_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Iconposition", GXutil.rtrim( Dvpanel_tbladdconnkey_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TBLADDCONNKEY_Autoscroll", GXutil.booltostr( Dvpanel_tbladdconnkey_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridwwsysconns_empowerer_Gridinternalname));
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
         we332( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt332( ) ;
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
      return formatLink("com.mujermorena.gamconnectionentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV19pConnectionName))}, new String[] {"Gx_mode","pConnectionName"})  ;
   }

   public String getPgmname( )
   {
      return "GAMConnectionEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Connection", "") ;
   }

   public void wb330( )
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
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblmaindata_Internalname, divTblmaindata_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_unnamedtable3.setProperty("Width", Dvpanel_unnamedtable3_Width);
         ucDvpanel_unnamedtable3.setProperty("AutoWidth", Dvpanel_unnamedtable3_Autowidth);
         ucDvpanel_unnamedtable3.setProperty("AutoHeight", Dvpanel_unnamedtable3_Autoheight);
         ucDvpanel_unnamedtable3.setProperty("Cls", Dvpanel_unnamedtable3_Cls);
         ucDvpanel_unnamedtable3.setProperty("Title", Dvpanel_unnamedtable3_Title);
         ucDvpanel_unnamedtable3.setProperty("Collapsible", Dvpanel_unnamedtable3_Collapsible);
         ucDvpanel_unnamedtable3.setProperty("Collapsed", Dvpanel_unnamedtable3_Collapsed);
         ucDvpanel_unnamedtable3.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable3_Showcollapseicon);
         ucDvpanel_unnamedtable3.setProperty("IconPosition", Dvpanel_unnamedtable3_Iconposition);
         ucDvpanel_unnamedtable3.setProperty("AutoScroll", Dvpanel_unnamedtable3_Autoscroll);
         ucDvpanel_unnamedtable3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable3_Internalname, "DVPANEL_UNNAMEDTABLE3Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE3Container"+"UnnamedTable3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConnectionname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConnectionname_Internalname, httpContext.getMessage( "WWP_GAM_ConnectionName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConnectionname_Internalname, GXutil.rtrim( AV8ConnectionName), GXutil.rtrim( localUtil.format( AV8ConnectionName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConnectionname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavConnectionname_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUsername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUsername_Internalname, httpContext.getMessage( "WWP_GAM_UserName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUsername_Internalname, GXutil.rtrim( AV20UserName), GXutil.rtrim( localUtil.format( AV20UserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUsername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUsername_Enabled, 1, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUserpassword_cell_Internalname, 1, 0, "px", 0, "px", divUserpassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavUserpassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserpassword_Internalname, httpContext.getMessage( "WWP_GAM_UserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserpassword_Internalname, GXutil.rtrim( AV21UserPassword), GXutil.rtrim( localUtil.format( AV21UserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavUserpassword_Visible, edtavUserpassword_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablesplittedencryptionkey_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTextblockencryptionkey_cell_Internalname, 1, 0, "px", 0, "px", divTextblockencryptionkey_cell_Class, "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockencryptionkey_Internalname, httpContext.getMessage( "WWP_GAM_EncriptionKey", ""), "", "", lblTextblockencryptionkey_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         wb_table1_43_332( true) ;
      }
      else
      {
         wb_table1_43_332( false) ;
      }
      return  ;
   }

   public void wb_table1_43_332e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblconnkeys_Internalname, divTblconnkeys_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tbladdconnkey.setProperty("Width", Dvpanel_tbladdconnkey_Width);
         ucDvpanel_tbladdconnkey.setProperty("AutoWidth", Dvpanel_tbladdconnkey_Autowidth);
         ucDvpanel_tbladdconnkey.setProperty("AutoHeight", Dvpanel_tbladdconnkey_Autoheight);
         ucDvpanel_tbladdconnkey.setProperty("Cls", Dvpanel_tbladdconnkey_Cls);
         ucDvpanel_tbladdconnkey.setProperty("Title", Dvpanel_tbladdconnkey_Title);
         ucDvpanel_tbladdconnkey.setProperty("Collapsible", Dvpanel_tbladdconnkey_Collapsible);
         ucDvpanel_tbladdconnkey.setProperty("Collapsed", Dvpanel_tbladdconnkey_Collapsed);
         ucDvpanel_tbladdconnkey.setProperty("ShowCollapseIcon", Dvpanel_tbladdconnkey_Showcollapseicon);
         ucDvpanel_tbladdconnkey.setProperty("IconPosition", Dvpanel_tbladdconnkey_Iconposition);
         ucDvpanel_tbladdconnkey.setProperty("AutoScroll", Dvpanel_tbladdconnkey_Autoscroll);
         ucDvpanel_tbladdconnkey.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tbladdconnkey_Internalname, "DVPANEL_TBLADDCONNKEYContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TBLADDCONNKEYContainer"+"TblAddConnKey"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTbladdconnkey_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "DataContentCellFL DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtablenewconnectionkey_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocknewconnectionkey_Internalname, httpContext.getMessage( "WWP_GAM_AddConnectionKey", ""), "", "", lblTextblocknewconnectionkey_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavNewconnectionkey_Internalname, httpContext.getMessage( "New Connection Key", ""), "col-sm-3 AttributeRealWidthLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavNewconnectionkey_Internalname, GXutil.rtrim( AV18NewConnectionKey), GXutil.rtrim( localUtil.format( AV18NewConnectionKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNewconnectionkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavNewconnectionkey_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnsavekey_Internalname, "gx.evt.setGridEvt("+GXutil.str( 85, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_SaveKey", ""), bttBtnsavekey_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_SaveKey", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOSAVEKEY\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroupGrouped", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnuseautomatickey_Internalname, "gx.evt.setGridEvt("+GXutil.str( 85, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_UseAutomaticKey", ""), bttBtnuseautomatickey_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_UseAutomaticKey", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSEAUTOMATICKEY\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnusecurrentkey_Internalname, "gx.evt.setGridEvt("+GXutil.str( 85, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_UseCurrentKey", ""), bttBtnusecurrentkey_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_UseCurrentKey", ""), "", StyleString, ClassString, bttBtnusecurrentkey_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOUSECURRENTKEY\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConnectionEntry.htm");
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
         ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
         ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
         ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
         ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
         ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
         ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
         ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
         ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
         ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
         ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
         ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridwwsysconnsContainer.SetWrapped(nGXWrapped);
         startgridcontrol85( ) ;
      }
      if ( wbEnd == 85 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_85 = (int)(nGXsfl_85_idx-1) ;
         if ( GridwwsysconnsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridwwsysconnsContainer.AddObjectProperty("GRIDWWSYSCONNS_nEOF", GRIDWWSYSCONNS_nEOF);
            GridwwsysconnsContainer.AddObjectProperty("GRIDWWSYSCONNS_nFirstRecordOnPage", GRIDWWSYSCONNS_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridwwsysconnsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridwwsysconns", GridwwsysconnsContainer, subGridwwsysconns_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridwwsysconnsContainerData", GridwwsysconnsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridwwsysconnsContainerData"+"V", GridwwsysconnsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridwwsysconnsContainerData"+"V"+"\" value='"+GridwwsysconnsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellFL DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavConnectionfilexml_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConnectionfilexml_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConnectionfilexml_Internalname, httpContext.getMessage( "WWP_GAM_ConnectionFileXML", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavConnectionfilexml_Internalname, GXutil.rtrim( AV6ConnectionFileXML), "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", (short)(0), edtavConnectionfilexml_Visible, edtavConnectionfilexml_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMConnectionEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 99,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 85, 2, 0)+","+"null"+");", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnuacancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 85, 2, 0)+","+"null"+");", httpContext.getMessage( "GX_BtnCancel", ""), bttBtnuacancel_Jsonclick, 7, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11331_client"+"'", TempTags, "", 2, "HLP_GAMConnectionEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavFileconnectionkey_Internalname, GXutil.rtrim( AV25FileConnectionKey), GXutil.rtrim( localUtil.format( AV25FileConnectionKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,105);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFileconnectionkey_Jsonclick, 0, "Attribute", "", "", "", "", edtavFileconnectionkey_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMConnectionEntry.htm");
         /* Single line edit */
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPconnectionname_Internalname, GXutil.rtrim( AV19pConnectionName), GXutil.rtrim( localUtil.format( AV19pConnectionName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPconnectionname_Jsonclick, 0, "Attribute", "", "", "", "", edtavPconnectionname_Visible, 0, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMConnectionEntry.htm");
         /* User Defined Control */
         ucGridwwsysconns_empowerer.render(context, "wwp.gridempowerer", Gridwwsysconns_empowerer_Internalname, "GRIDWWSYSCONNS_EMPOWERERContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 85 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridwwsysconnsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridwwsysconnsContainer.AddObjectProperty("GRIDWWSYSCONNS_nEOF", GRIDWWSYSCONNS_nEOF);
               GridwwsysconnsContainer.AddObjectProperty("GRIDWWSYSCONNS_nFirstRecordOnPage", GRIDWWSYSCONNS_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridwwsysconnsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridwwsysconns", GridwwsysconnsContainer, subGridwwsysconns_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridwwsysconnsContainerData", GridwwsysconnsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridwwsysconnsContainerData"+"V", GridwwsysconnsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridwwsysconnsContainerData"+"V"+"\" value='"+GridwwsysconnsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start332( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Connection", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup330( ) ;
   }

   public void ws332( )
   {
      start332( ) ;
      evt332( ) ;
   }

   public void evt332( )
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
                        else if ( GXutil.strcmp(sEvt, "'DOUSEAUTOMATICKEY'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUseAutomaticKey' */
                           e12332 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOUSECURRENTKEY'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoUseCurrentKey' */
                           e13332 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOSAVEKEY'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoSaveKey' */
                           e14332 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOGENKEY'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoGenKey' */
                           e15332 ();
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
                                 e16332 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDWWSYSCONNSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDWWSYSCONNSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridwwsysconns_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridwwsysconns_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridwwsysconns_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridwwsysconns_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 19), "GRIDWWSYSCONNS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "VDELETECONNECTION.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VCONNECTIONFILE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 21), "VCONNECTIONFILE.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "VDELETECONNECTION.CLICK") == 0 ) )
                        {
                           nGXsfl_85_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_85_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_85_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_852( ) ;
                           AV7ConnectionKey = httpContext.cgiGet( edtavConnectionkey_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavConnectionkey_Internalname, AV7ConnectionKey);
                           com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONNECTIONKEY"+"_"+sGXsfl_85_idx, getSecureSignedToken( sGXsfl_85_idx, GXutil.rtrim( localUtil.format( AV7ConnectionKey, ""))));
                           AV24IsCurrentKey = httpContext.cgiGet( edtavIscurrentkey_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavIscurrentkey_Internalname, AV24IsCurrentKey);
                           AV32ConnectionFile = httpContext.cgiGet( edtavConnectionfile_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavConnectionfile_Internalname, AV32ConnectionFile);
                           AV33DeleteConnection = httpContext.cgiGet( edtavDeleteconnection_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavDeleteconnection_Internalname, AV33DeleteConnection);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e17332 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e18332 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDWWSYSCONNS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e19332 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VDELETECONNECTION.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20332 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VCONNECTIONFILE.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21332 ();
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
   }

   public void we332( )
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

   public void pa332( )
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
            GX_FocusControl = edtavConnectionname_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridwwsysconns_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_852( ) ;
      while ( nGXsfl_85_idx <= nRC_GXsfl_85 )
      {
         sendrow_852( ) ;
         nGXsfl_85_idx = ((subGridwwsysconns_Islastpage==1)&&(nGXsfl_85_idx+1>subgridwwsysconns_fnc_recordsperpage( )) ? 1 : nGXsfl_85_idx+1) ;
         sGXsfl_85_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_85_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_852( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridwwsysconnsContainer)) ;
      /* End function gxnrGridwwsysconns_newrow */
   }

   public void gxgrgridwwsysconns_refresh( int subGridwwsysconns_Rows ,
                                           String Gx_mode ,
                                           String AV23CurrentConnectionKey ,
                                           String AV12FileXML )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e18332 ();
      GRIDWWSYSCONNS_nCurrentRecord = 0 ;
      rf332( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridwwsysconns_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONNECTIONKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV7ConnectionKey, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCONNECTIONKEY", GXutil.rtrim( AV7ConnectionKey));
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
      rf332( ) ;
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
      edtavConnectionkey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConnectionkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionkey_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      edtavIscurrentkey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIscurrentkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIscurrentkey_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      edtavConnectionfile_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConnectionfile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionfile_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      edtavDeleteconnection_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDeleteconnection_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteconnection_Enabled), 5, 0), !bGXsfl_85_Refreshing);
   }

   public void rf332( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridwwsysconnsContainer.ClearRows();
      }
      wbStart = (short)(85) ;
      /* Execute user event: Refresh */
      e18332 ();
      nGXsfl_85_idx = 1 ;
      sGXsfl_85_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_85_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_852( ) ;
      bGXsfl_85_Refreshing = true ;
      GridwwsysconnsContainer.AddObjectProperty("GridName", "Gridwwsysconns");
      GridwwsysconnsContainer.AddObjectProperty("CmpContext", "");
      GridwwsysconnsContainer.AddObjectProperty("InMasterPage", "false");
      GridwwsysconnsContainer.AddObjectProperty("Class", "WorkWith");
      GridwwsysconnsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridwwsysconnsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridwwsysconnsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridwwsysconnsContainer.setPageSize( subgridwwsysconns_fnc_recordsperpage( ) );
      if ( subGridwwsysconns_Islastpage != 0 )
      {
         GRIDWWSYSCONNS_nFirstRecordOnPage = (long)(subgridwwsysconns_fnc_recordcount( )-subgridwwsysconns_fnc_recordsperpage( )) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("GRIDWWSYSCONNS_nFirstRecordOnPage", GRIDWWSYSCONNS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_852( ) ;
         e19332 ();
         if ( ( GRIDWWSYSCONNS_nCurrentRecord > 0 ) && ( GRIDWWSYSCONNS_nGridOutOfScope == 0 ) && ( nGXsfl_85_idx == 1 ) )
         {
            GRIDWWSYSCONNS_nCurrentRecord = 0 ;
            GRIDWWSYSCONNS_nGridOutOfScope = 1 ;
            subgridwwsysconns_firstpage( ) ;
            e19332 ();
         }
         wbEnd = (short)(85) ;
         wb330( ) ;
      }
      bGXsfl_85_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes332( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vCURRENTCONNECTIONKEY", GXutil.rtrim( AV23CurrentConnectionKey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTCONNECTIONKEY", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV23CurrentConnectionKey, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONNECTIONKEY"+"_"+sGXsfl_85_idx, getSecureSignedToken( sGXsfl_85_idx, GXutil.rtrim( localUtil.format( AV7ConnectionKey, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vFILEXML", GXutil.rtrim( AV12FileXML));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEXML", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12FileXML, ""))));
   }

   public int subgridwwsysconns_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridwwsysconns_fnc_recordcount( )
   {
      return (int)(((subGridwwsysconns_Recordcount==0) ? GRIDWWSYSCONNS_nFirstRecordOnPage+1 : subGridwwsysconns_Recordcount)) ;
   }

   public int subgridwwsysconns_fnc_recordsperpage( )
   {
      if ( subGridwwsysconns_Rows > 0 )
      {
         return subGridwwsysconns_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridwwsysconns_fnc_currentpage( )
   {
      return (int)(((subGridwwsysconns_Islastpage==1) ? subgridwwsysconns_fnc_recordcount( )/ (double) (subgridwwsysconns_fnc_recordsperpage( ))+((((int)((subgridwwsysconns_fnc_recordcount( )) % (subgridwwsysconns_fnc_recordsperpage( ))))==0) ? 0 : 1) : GXutil.Int( GRIDWWSYSCONNS_nFirstRecordOnPage/ (double) (subgridwwsysconns_fnc_recordsperpage( )))+1)) ;
   }

   public short subgridwwsysconns_firstpage( )
   {
      GRIDWWSYSCONNS_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridwwsysconns_refresh( subGridwwsysconns_Rows, Gx_mode, AV23CurrentConnectionKey, AV12FileXML) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridwwsysconns_nextpage( )
   {
      if ( GRIDWWSYSCONNS_nEOF == 0 )
      {
         GRIDWWSYSCONNS_nFirstRecordOnPage = (long)(GRIDWWSYSCONNS_nFirstRecordOnPage+subgridwwsysconns_fnc_recordsperpage( )) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridwwsysconnsContainer.AddObjectProperty("GRIDWWSYSCONNS_nFirstRecordOnPage", GRIDWWSYSCONNS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridwwsysconns_refresh( subGridwwsysconns_Rows, Gx_mode, AV23CurrentConnectionKey, AV12FileXML) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDWWSYSCONNS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridwwsysconns_previouspage( )
   {
      if ( GRIDWWSYSCONNS_nFirstRecordOnPage >= subgridwwsysconns_fnc_recordsperpage( ) )
      {
         GRIDWWSYSCONNS_nFirstRecordOnPage = (long)(GRIDWWSYSCONNS_nFirstRecordOnPage-subgridwwsysconns_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridwwsysconns_refresh( subGridwwsysconns_Rows, Gx_mode, AV23CurrentConnectionKey, AV12FileXML) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridwwsysconns_lastpage( )
   {
      subGridwwsysconns_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgridwwsysconns_refresh( subGridwwsysconns_Rows, Gx_mode, AV23CurrentConnectionKey, AV12FileXML) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridwwsysconns_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDWWSYSCONNS_nFirstRecordOnPage = (long)(subgridwwsysconns_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDWWSYSCONNS_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridwwsysconns_refresh( subGridwwsysconns_Rows, Gx_mode, AV23CurrentConnectionKey, AV12FileXML) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavConnectionkey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConnectionkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionkey_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      edtavIscurrentkey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIscurrentkey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIscurrentkey_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      edtavConnectionfile_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConnectionfile_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionfile_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      edtavDeleteconnection_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDeleteconnection_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDeleteconnection_Enabled), 5, 0), !bGXsfl_85_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup330( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e17332 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_85 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_85"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDWWSYSCONNS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDWWSYSCONNS_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDWWSYSCONNS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDWWSYSCONNS_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGridwwsysconns_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDWWSYSCONNS_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_Rows", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_unnamedtable3_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Width") ;
         Dvpanel_unnamedtable3_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autowidth")) ;
         Dvpanel_unnamedtable3_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autoheight")) ;
         Dvpanel_unnamedtable3_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Cls") ;
         Dvpanel_unnamedtable3_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Title") ;
         Dvpanel_unnamedtable3_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Collapsible")) ;
         Dvpanel_unnamedtable3_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Collapsed")) ;
         Dvpanel_unnamedtable3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Showcollapseicon")) ;
         Dvpanel_unnamedtable3_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Iconposition") ;
         Dvpanel_unnamedtable3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autoscroll")) ;
         Dvpanel_tbladdconnkey_Width = httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Width") ;
         Dvpanel_tbladdconnkey_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Autowidth")) ;
         Dvpanel_tbladdconnkey_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Autoheight")) ;
         Dvpanel_tbladdconnkey_Cls = httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Cls") ;
         Dvpanel_tbladdconnkey_Title = httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Title") ;
         Dvpanel_tbladdconnkey_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Collapsible")) ;
         Dvpanel_tbladdconnkey_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Collapsed")) ;
         Dvpanel_tbladdconnkey_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Showcollapseicon")) ;
         Dvpanel_tbladdconnkey_Iconposition = httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Iconposition") ;
         Dvpanel_tbladdconnkey_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TBLADDCONNKEY_Autoscroll")) ;
         Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
         Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
         Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
         Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
         Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
         Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
         Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
         Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
         Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
         Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
         Gridwwsysconns_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDWWSYSCONNS_EMPOWERER_Gridinternalname") ;
         /* Read variables values. */
         AV8ConnectionName = httpContext.cgiGet( edtavConnectionname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8ConnectionName", AV8ConnectionName);
         AV20UserName = httpContext.cgiGet( edtavUsername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20UserName", AV20UserName);
         AV21UserPassword = httpContext.cgiGet( edtavUserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21UserPassword", AV21UserPassword);
         AV9EncryptionKey = httpContext.cgiGet( edtavEncryptionkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9EncryptionKey", AV9EncryptionKey);
         AV18NewConnectionKey = httpContext.cgiGet( edtavNewconnectionkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18NewConnectionKey", AV18NewConnectionKey);
         AV6ConnectionFileXML = httpContext.cgiGet( edtavConnectionfilexml_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6ConnectionFileXML", AV6ConnectionFileXML);
         AV25FileConnectionKey = httpContext.cgiGet( edtavFileconnectionkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25FileConnectionKey", AV25FileConnectionKey);
         AV19pConnectionName = httpContext.cgiGet( edtavPconnectionname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19pConnectionName", AV19pConnectionName);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e17332 ();
      if (returnInSub) return;
   }

   public void e17332( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV8ConnectionName = AV19pConnectionName ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8ConnectionName", AV8ConnectionName);
      GX_FocusControl = edtavConnectionname_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      httpContext.doAjaxSetFocus(GX_FocusControl);
      edtavConnectionname_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConnectionname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionname_Enabled), 5, 0), true);
      edtavUsername_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
      divTblconnkeys_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTblconnkeys_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblconnkeys_Visible), 5, 0), true);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         edtavConnectionname_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavConnectionname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionname_Enabled), 5, 0), true);
         edtavUsername_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
      }
      else
      {
         AV13GAMRepositoryConnection.load(AV8ConnectionName);
         AV20UserName = AV13GAMRepositoryConnection.getgxTv_SdtGAMRepositoryConnection_Username() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20UserName", AV20UserName);
         AV21UserPassword = AV13GAMRepositoryConnection.getgxTv_SdtGAMRepositoryConnection_Userpassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21UserPassword", AV21UserPassword);
         AV9EncryptionKey = AV13GAMRepositoryConnection.getgxTv_SdtGAMRepositoryConnection_Key() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9EncryptionKey", AV9EncryptionKey);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         edtavUsername_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUsername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUsername_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         bttBtnenter_Caption = "Delete" ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
      }
      if ( GXutil.strcmp(Gx_mode, "KEY") == 0 )
      {
         Form.setCaption( GXutil.format( httpContext.getMessage( "WWP_GAM_ConnectionKeyList", ""), GXutil.upper( AV8ConnectionName), "", "", "", "", "", "", "", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         divTblmaindata_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblmaindata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblmaindata_Visible), 5, 0), true);
         divTblconnkeys_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblconnkeys_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblconnkeys_Visible), 5, 0), true);
         edtavConnectionfilexml_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavConnectionfilexml_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionfilexml_Visible), 5, 0), true);
         edtavFileconnectionkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFileconnectionkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFileconnectionkey_Visible), 5, 0), true);
      }
      else
      {
         Form.setCaption( httpContext.getMessage( "WWP_GAM_Connections", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      edtavFileconnectionkey_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFileconnectionkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFileconnectionkey_Visible), 5, 0), true);
      edtavPconnectionname_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavPconnectionname_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPconnectionname_Visible), 5, 0), true);
      Gridwwsysconns_empowerer_Gridinternalname = subGridwwsysconns_Internalname ;
      ucGridwwsysconns_empowerer.sendProperty(context, "", false, Gridwwsysconns_empowerer_Internalname, "GridInternalName", Gridwwsysconns_empowerer_Gridinternalname);
      subGridwwsysconns_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_Rows", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Rows, (byte)(6), (byte)(0), ".", "")));
   }

   public void e18332( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   private void e19332( )
   {
      /* Gridwwsysconns_Load Routine */
      returnInSub = false ;
      GXv_char1[0] = AV23CurrentConnectionKey ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnectionkey(GXv_char1) ;
      gamconnectionentry_impl.this.AV23CurrentConnectionKey = GXv_char1[0] ;
      AV27hasCurrentKey = false ;
      AV43GXV2 = 1 ;
      GXv_objcol_SdtGAMError2[0] = AV11Errors ;
      AV42GXV1 = AV13GAMRepositoryConnection.getkeys(GXv_objcol_SdtGAMError2) ;
      AV11Errors = GXv_objcol_SdtGAMError2[0] ;
      while ( AV43GXV2 <= AV42GXV1.size() )
      {
         AV14GAMSystemConnection = (genexus.security.api.genexussecurity.SdtGAMSystemConnection)((genexus.security.api.genexussecurity.SdtGAMSystemConnection)AV42GXV1.elementAt(-1+AV43GXV2));
         AV7ConnectionKey = AV14GAMSystemConnection.getgxTv_SdtGAMSystemConnection_Key() ;
         httpContext.ajax_rsp_assign_attri("", false, edtavConnectionkey_Internalname, AV7ConnectionKey);
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONNECTIONKEY"+"_"+sGXsfl_85_idx, getSecureSignedToken( sGXsfl_85_idx, GXutil.rtrim( localUtil.format( AV7ConnectionKey, ""))));
         if ( GXutil.strcmp(GXutil.trim( AV14GAMSystemConnection.getgxTv_SdtGAMSystemConnection_Key()), GXutil.trim( AV23CurrentConnectionKey)) == 0 )
         {
            AV27hasCurrentKey = true ;
            AV24IsCurrentKey = httpContext.getMessage( "WWP_GAM_Current", "") ;
            httpContext.ajax_rsp_assign_attri("", false, edtavIscurrentkey_Internalname, AV24IsCurrentKey);
         }
         else
         {
            AV24IsCurrentKey = "" ;
            httpContext.ajax_rsp_assign_attri("", false, edtavIscurrentkey_Internalname, AV24IsCurrentKey);
         }
         AV32ConnectionFile = "<i class=\"fa fa-file\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavConnectionfile_Internalname, AV32ConnectionFile);
         AV33DeleteConnection = "<i class=\"fa fa-times\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavDeleteconnection_Internalname, AV33DeleteConnection);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(85) ;
         }
         if ( ( subGridwwsysconns_Islastpage == 1 ) || ( subGridwwsysconns_Rows == 0 ) || ( ( GRIDWWSYSCONNS_nCurrentRecord >= GRIDWWSYSCONNS_nFirstRecordOnPage ) && ( GRIDWWSYSCONNS_nCurrentRecord < GRIDWWSYSCONNS_nFirstRecordOnPage + subgridwwsysconns_fnc_recordsperpage( ) ) ) )
         {
            sendrow_852( ) ;
            GRIDWWSYSCONNS_nEOF = (byte)(1) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( ( subGridwwsysconns_Islastpage == 1 ) && ( ((int)((GRIDWWSYSCONNS_nCurrentRecord) % (subgridwwsysconns_fnc_recordsperpage( )))) == 0 ) )
            {
               GRIDWWSYSCONNS_nFirstRecordOnPage = GRIDWWSYSCONNS_nCurrentRecord ;
            }
         }
         if ( GRIDWWSYSCONNS_nCurrentRecord >= GRIDWWSYSCONNS_nFirstRecordOnPage + subgridwwsysconns_fnc_recordsperpage( ) )
         {
            GRIDWWSYSCONNS_nEOF = (byte)(0) ;
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRIDWWSYSCONNS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDWWSYSCONNS_nEOF, (byte)(1), (byte)(0), ".", "")));
         }
         GRIDWWSYSCONNS_nCurrentRecord = (long)(GRIDWWSYSCONNS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_85_Refreshing )
         {
            httpContext.doAjaxLoad(85, GridwwsysconnsRow);
         }
         AV43GXV2 = (int)(AV43GXV2+1) ;
      }
      if ( AV27hasCurrentKey )
      {
         bttBtnusecurrentkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnusecurrentkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnusecurrentkey_Visible), 5, 0), true);
      }
      /*  Sending Event outputs  */
   }

   public void e12332( )
   {
      /* 'DoUseAutomaticKey' Routine */
      returnInSub = false ;
      AV15GXGUID = java.util.UUID.randomUUID( ) ;
      AV18NewConnectionKey = GXutil.trim( AV15GXGUID.toString()) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18NewConnectionKey", AV18NewConnectionKey);
      /*  Sending Event outputs  */
   }

   public void e13332( )
   {
      /* 'DoUseCurrentKey' Routine */
      returnInSub = false ;
      GXv_char1[0] = AV23CurrentConnectionKey ;
      AV16isOk = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnectionkey(GXv_char1) ;
      gamconnectionentry_impl.this.AV23CurrentConnectionKey = GXv_char1[0] ;
      AV18NewConnectionKey = GXutil.trim( AV23CurrentConnectionKey) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18NewConnectionKey", AV18NewConnectionKey);
      /*  Sending Event outputs  */
   }

   public void e14332( )
   {
      /* 'DoSaveKey' Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError2[0] = AV11Errors ;
      if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).addconnectiontofilekey(AV18NewConnectionKey, AV8ConnectionName, GXv_objcol_SdtGAMError2) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      AV11Errors = GXv_objcol_SdtGAMError2[0] ;
      if ( Cond_result )
      {
         callWebObject(formatLink("com.mujermorena.gamconnectionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("KEY")),GXutil.URLEncode(GXutil.rtrim(AV19pConnectionName))}, new String[] {"Mode","pConnectionName"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S132 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
   }

   public void e15332( )
   {
      /* 'DoGenKey' Routine */
      returnInSub = false ;
      AV9EncryptionKey = com.genexus.util.Encryption.getNewKey( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9EncryptionKey", AV9EncryptionKey);
      AV11Errors = GXv_objcol_SdtGAMError2[0] ;
      /*  Sending Event outputs  */
   }

   public void S122( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) ) )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) ) )
      {
         bttBtngenkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtngenkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtngenkey_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) ) )
      {
         edtavUserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         divUserpassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divUserpassword_cell_Internalname, "Class", divUserpassword_cell_Class, true);
      }
      else
      {
         edtavUserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavUserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavUserpassword_Visible), 5, 0), true);
         divUserpassword_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divUserpassword_cell_Internalname, "Class", divUserpassword_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) ) )
      {
         edtavEncryptionkey_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEncryptionkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEncryptionkey_Visible), 5, 0), true);
         cellEncryptionkey_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, cellEncryptionkey_cell_Internalname, "Class", cellEncryptionkey_cell_Class, true);
         divTextblockencryptionkey_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divTextblockencryptionkey_cell_Internalname, "Class", divTextblockencryptionkey_cell_Class, true);
      }
      else
      {
         edtavEncryptionkey_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEncryptionkey_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEncryptionkey_Visible), 5, 0), true);
         cellEncryptionkey_cell_Class = "MergeDataCell" ;
         httpContext.ajax_rsp_assign_prop("", false, cellEncryptionkey_cell_Internalname, "Class", cellEncryptionkey_cell_Class, true);
         divTextblockencryptionkey_cell_Class = "col-sm-12 MergeLabelCell" ;
         httpContext.ajax_rsp_assign_prop("", false, divTextblockencryptionkey_cell_Internalname, "Class", divTextblockencryptionkey_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e16332 ();
      if (returnInSub) return;
   }

   public void e16332( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV13GAMRepositoryConnection.load(AV8ConnectionName);
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
      {
         AV13GAMRepositoryConnection.setgxTv_SdtGAMRepositoryConnection_Username( AV20UserName );
         AV13GAMRepositoryConnection.setgxTv_SdtGAMRepositoryConnection_Userpassword( AV21UserPassword );
         AV13GAMRepositoryConnection.setgxTv_SdtGAMRepositoryConnection_Key( AV9EncryptionKey );
         AV13GAMRepositoryConnection.save();
         if ( AV13GAMRepositoryConnection.success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "gamconnectionentry");
            httpContext.setWebReturnParms(new Object[] {Gx_mode,AV19pConnectionName});
            httpContext.setWebReturnParmsMetadata(new Object[] {"Gx_mode","AV19pConnectionName"});
            httpContext.wjLocDisableFrm = (byte)(1) ;
            httpContext.nUserReturn = (byte)(1) ;
            returnInSub = true;
            if (true) return;
         }
         else
         {
            AV11Errors = AV13GAMRepositoryConnection.geterrors() ;
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S132 ();
            if (returnInSub) return;
         }
      }
      else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         AV13GAMRepositoryConnection.delete();
         if ( AV13GAMRepositoryConnection.success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "gamconnectionentry");
            callWebObject(formatLink("com.mujermorena.gamwwconnections", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            AV11Errors = AV13GAMRepositoryConnection.geterrors() ;
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S132 ();
            if (returnInSub) return;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13GAMRepositoryConnection", AV13GAMRepositoryConnection);
   }

   public void e20332( )
   {
      /* Deleteconnection_Click Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError2[0] = AV11Errors ;
      if ( new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).deleteconnectionfromfilekey(AV7ConnectionKey, AV8ConnectionName, GXv_objcol_SdtGAMError2) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      AV11Errors = GXv_objcol_SdtGAMError2[0] ;
      if ( Cond_result )
      {
         callWebObject(formatLink("com.mujermorena.gamconnectionentry", new String[] {GXutil.URLEncode(GXutil.rtrim("KEY")),GXutil.URLEncode(GXutil.rtrim(AV19pConnectionName))}, new String[] {"Mode","pConnectionName"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         /* Execute user subroutine: 'DISPLAYMESSAGES' */
         S132 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
   }

   public void e21332( )
   {
      /* Connectionfile_Click Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25FileConnectionKey, AV7ConnectionKey) == 0 )
      {
         AV11Errors = GXv_objcol_SdtGAMError2[0] ;
         AV25FileConnectionKey = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25FileConnectionKey", AV25FileConnectionKey);
         edtavConnectionfilexml_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavConnectionfilexml_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionfilexml_Visible), 5, 0), true);
      }
      else
      {
         AV25FileConnectionKey = AV7ConnectionKey ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25FileConnectionKey", AV25FileConnectionKey);
         edtavConnectionfilexml_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavConnectionfilexml_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionfilexml_Visible), 5, 0), true);
         AV6ConnectionFileXML = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6ConnectionFileXML", AV6ConnectionFileXML);
         GXv_char1[0] = AV12FileXML ;
         GXv_objcol_SdtGAMError2[0] = AV11Errors ;
         new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getconnectionxmlfromfilekey(AV8ConnectionName, AV7ConnectionKey, GXv_char1, GXv_objcol_SdtGAMError2) ;
         gamconnectionentry_impl.this.AV12FileXML = GXv_char1[0] ;
         AV11Errors = GXv_objcol_SdtGAMError2[0] ;
         if ( AV11Errors.size() == 0 )
         {
            AV6ConnectionFileXML = AV12FileXML ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6ConnectionFileXML", AV6ConnectionFileXML);
         }
         else
         {
            /* Execute user subroutine: 'DISPLAYMESSAGES' */
            S132 ();
            if (returnInSub) return;
         }
      }
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'DISPLAYMESSAGES' Routine */
      returnInSub = false ;
      AV44GXV3 = 1 ;
      while ( AV44GXV3 <= AV11Errors.size() )
      {
         AV10Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV11Errors.elementAt(-1+AV44GXV3));
         if ( AV10Error.getgxTv_SdtGAMError_Code() != 13 )
         {
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV10Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV10Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         }
         AV44GXV3 = (int)(AV44GXV3+1) ;
      }
   }

   public void wb_table1_43_332( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedencryptionkey_Internalname, tblTablemergedencryptionkey_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td id=\""+cellEncryptionkey_cell_Internalname+"\"  class='"+cellEncryptionkey_cell_Class+"'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEncryptionkey_Internalname, httpContext.getMessage( "Encryption Key", ""), "gx-form-item AttributeRealWidthLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'" + sGXsfl_85_idx + "',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEncryptionkey_Internalname, GXutil.rtrim( AV9EncryptionKey), GXutil.rtrim( localUtil.format( AV9EncryptionKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEncryptionkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEncryptionkey_Visible, edtavEncryptionkey_Enabled, 0, "text", "", 32, "chr", 1, "row", 32, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEncryptionKey", "left", true, "", "HLP_GAMConnectionEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtngenkey_Internalname, "gx.evt.setGridEvt("+GXutil.str( 85, 2, 0)+","+"null"+");", httpContext.getMessage( "WWP_GAM_GenerateKey", ""), bttBtngenkey_Jsonclick, 5, httpContext.getMessage( "WWP_GAM_GenerateKey", ""), "", StyleString, ClassString, bttBtngenkey_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOGENKEY\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMConnectionEntry.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_43_332e( true) ;
      }
      else
      {
         wb_table1_43_332e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV19pConnectionName = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19pConnectionName", AV19pConnectionName);
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
      pa332( ) ;
      ws332( ) ;
      we332( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211119357", true, true);
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
      httpContext.AddJavascriptSource("gamconnectionentry.js", "?202412111193514", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_852( )
   {
      edtavConnectionkey_Internalname = "vCONNECTIONKEY_"+sGXsfl_85_idx ;
      edtavIscurrentkey_Internalname = "vISCURRENTKEY_"+sGXsfl_85_idx ;
      edtavConnectionfile_Internalname = "vCONNECTIONFILE_"+sGXsfl_85_idx ;
      edtavDeleteconnection_Internalname = "vDELETECONNECTION_"+sGXsfl_85_idx ;
   }

   public void subsflControlProps_fel_852( )
   {
      edtavConnectionkey_Internalname = "vCONNECTIONKEY_"+sGXsfl_85_fel_idx ;
      edtavIscurrentkey_Internalname = "vISCURRENTKEY_"+sGXsfl_85_fel_idx ;
      edtavConnectionfile_Internalname = "vCONNECTIONFILE_"+sGXsfl_85_fel_idx ;
      edtavDeleteconnection_Internalname = "vDELETECONNECTION_"+sGXsfl_85_fel_idx ;
   }

   public void sendrow_852( )
   {
      subsflControlProps_852( ) ;
      wb330( ) ;
      if ( ( subGridwwsysconns_Rows * 1 == 0 ) || ( nGXsfl_85_idx <= subgridwwsysconns_fnc_recordsperpage( ) * 1 ) )
      {
         GridwwsysconnsRow = GXWebRow.GetNew(context,GridwwsysconnsContainer) ;
         if ( subGridwwsysconns_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridwwsysconns_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridwwsysconns_Class, "") != 0 )
            {
               subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Odd" ;
            }
         }
         else if ( subGridwwsysconns_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridwwsysconns_Backstyle = (byte)(0) ;
            subGridwwsysconns_Backcolor = subGridwwsysconns_Allbackcolor ;
            if ( GXutil.strcmp(subGridwwsysconns_Class, "") != 0 )
            {
               subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Uniform" ;
            }
         }
         else if ( subGridwwsysconns_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridwwsysconns_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridwwsysconns_Class, "") != 0 )
            {
               subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Odd" ;
            }
            subGridwwsysconns_Backcolor = (int)(0x0) ;
         }
         else if ( subGridwwsysconns_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridwwsysconns_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_85_idx) % (2))) == 0 )
            {
               subGridwwsysconns_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridwwsysconns_Class, "") != 0 )
               {
                  subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Even" ;
               }
            }
            else
            {
               subGridwwsysconns_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridwwsysconns_Class, "") != 0 )
               {
                  subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Odd" ;
               }
            }
         }
         if ( GridwwsysconnsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_85_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridwwsysconnsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavConnectionkey_Enabled!=0)&&(edtavConnectionkey_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 86,'',false,'"+sGXsfl_85_idx+"',85)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridwwsysconnsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConnectionkey_Internalname,GXutil.rtrim( AV7ConnectionKey),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavConnectionkey_Enabled!=0)&&(edtavConnectionkey_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,86);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavConnectionkey_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavConnectionkey_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(85),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXusSecurityCommon\\GAMGUID","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridwwsysconnsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavIscurrentkey_Enabled!=0)&&(edtavIscurrentkey_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 87,'',false,'"+sGXsfl_85_idx+"',85)\"" : " ") ;
         ROClassString = "AttributeRealWidth" ;
         GridwwsysconnsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavIscurrentkey_Internalname,AV24IsCurrentKey,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavIscurrentkey_Enabled!=0)&&(edtavIscurrentkey_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,87);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavIscurrentkey_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavIscurrentkey_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(85),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridwwsysconnsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavConnectionfile_Enabled!=0)&&(edtavConnectionfile_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 88,'',false,'"+sGXsfl_85_idx+"',85)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridwwsysconnsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavConnectionfile_Internalname,GXutil.rtrim( AV32ConnectionFile),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavConnectionfile_Enabled!=0)&&(edtavConnectionfile_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,88);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVCONNECTIONFILE.CLICK."+sGXsfl_85_idx+"'","","",httpContext.getMessage( "WWP_GAM_File", ""),"",edtavConnectionfile_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavConnectionfile_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(85),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridwwsysconnsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavDeleteconnection_Enabled!=0)&&(edtavDeleteconnection_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 89,'',false,'"+sGXsfl_85_idx+"',85)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridwwsysconnsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavDeleteconnection_Internalname,GXutil.rtrim( AV33DeleteConnection),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavDeleteconnection_Enabled!=0)&&(edtavDeleteconnection_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,89);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVDELETECONNECTION.CLICK."+sGXsfl_85_idx+"'","","",httpContext.getMessage( "WWP_GAM_Delete", ""),"",edtavDeleteconnection_Jsonclick,Integer.valueOf(5),"Attribute","",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavDeleteconnection_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(85),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes332( ) ;
         GridwwsysconnsContainer.AddRow(GridwwsysconnsRow);
         nGXsfl_85_idx = ((subGridwwsysconns_Islastpage==1)&&(nGXsfl_85_idx+1>subgridwwsysconns_fnc_recordsperpage( )) ? 1 : nGXsfl_85_idx+1) ;
         sGXsfl_85_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_85_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_852( ) ;
      }
      /* End function sendrow_852 */
   }

   public void startgridcontrol85( )
   {
      if ( GridwwsysconnsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridwwsysconnsContainer"+"DivS\" data-gxgridid=\"85\">") ;
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGridwwsysconns_Internalname, subGridwwsysconns_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridwwsysconns_Backcolorstyle == 0 )
         {
            subGridwwsysconns_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridwwsysconns_Class) > 0 )
            {
               subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Title" ;
            }
         }
         else
         {
            subGridwwsysconns_Titlebackstyle = (byte)(1) ;
            if ( subGridwwsysconns_Backcolorstyle == 1 )
            {
               subGridwwsysconns_Titlebackcolor = subGridwwsysconns_Allbackcolor ;
               if ( GXutil.len( subGridwwsysconns_Class) > 0 )
               {
                  subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridwwsysconns_Class) > 0 )
               {
                  subGridwwsysconns_Linesclass = subGridwwsysconns_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "WWP_GAM_ConnectionKey", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"AttributeRealWidth"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridwwsysconnsContainer.AddObjectProperty("GridName", "Gridwwsysconns");
      }
      else
      {
         GridwwsysconnsContainer.AddObjectProperty("GridName", "Gridwwsysconns");
         GridwwsysconnsContainer.AddObjectProperty("Header", subGridwwsysconns_Header);
         GridwwsysconnsContainer.AddObjectProperty("Class", "WorkWith");
         GridwwsysconnsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("CmpContext", "");
         GridwwsysconnsContainer.AddObjectProperty("InMasterPage", "false");
         GridwwsysconnsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwwsysconnsColumn.AddObjectProperty("Value", GXutil.rtrim( AV7ConnectionKey));
         GridwwsysconnsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConnectionkey_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddColumnProperties(GridwwsysconnsColumn);
         GridwwsysconnsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwwsysconnsColumn.AddObjectProperty("Value", AV24IsCurrentKey);
         GridwwsysconnsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavIscurrentkey_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddColumnProperties(GridwwsysconnsColumn);
         GridwwsysconnsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwwsysconnsColumn.AddObjectProperty("Value", GXutil.rtrim( AV32ConnectionFile));
         GridwwsysconnsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavConnectionfile_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddColumnProperties(GridwwsysconnsColumn);
         GridwwsysconnsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridwwsysconnsColumn.AddObjectProperty("Value", GXutil.rtrim( AV33DeleteConnection));
         GridwwsysconnsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavDeleteconnection_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddColumnProperties(GridwwsysconnsColumn);
         GridwwsysconnsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridwwsysconnsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridwwsysconns_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavConnectionname_Internalname = "vCONNECTIONNAME" ;
      edtavUsername_Internalname = "vUSERNAME" ;
      edtavUserpassword_Internalname = "vUSERPASSWORD" ;
      divUserpassword_cell_Internalname = "USERPASSWORD_CELL" ;
      lblTextblockencryptionkey_Internalname = "TEXTBLOCKENCRYPTIONKEY" ;
      divTextblockencryptionkey_cell_Internalname = "TEXTBLOCKENCRYPTIONKEY_CELL" ;
      edtavEncryptionkey_Internalname = "vENCRYPTIONKEY" ;
      cellEncryptionkey_cell_Internalname = "ENCRYPTIONKEY_CELL" ;
      bttBtngenkey_Internalname = "BTNGENKEY" ;
      tblTablemergedencryptionkey_Internalname = "TABLEMERGEDENCRYPTIONKEY" ;
      divTablesplittedencryptionkey_Internalname = "TABLESPLITTEDENCRYPTIONKEY" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      Dvpanel_unnamedtable3_Internalname = "DVPANEL_UNNAMEDTABLE3" ;
      divTblmaindata_Internalname = "TBLMAINDATA" ;
      lblTextblocknewconnectionkey_Internalname = "TEXTBLOCKNEWCONNECTIONKEY" ;
      edtavNewconnectionkey_Internalname = "vNEWCONNECTIONKEY" ;
      divUnnamedtablenewconnectionkey_Internalname = "UNNAMEDTABLENEWCONNECTIONKEY" ;
      bttBtnsavekey_Internalname = "BTNSAVEKEY" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      bttBtnuseautomatickey_Internalname = "BTNUSEAUTOMATICKEY" ;
      bttBtnusecurrentkey_Internalname = "BTNUSECURRENTKEY" ;
      divTbladdconnkey_Internalname = "TBLADDCONNKEY" ;
      Dvpanel_tbladdconnkey_Internalname = "DVPANEL_TBLADDCONNKEY" ;
      edtavConnectionkey_Internalname = "vCONNECTIONKEY" ;
      edtavIscurrentkey_Internalname = "vISCURRENTKEY" ;
      edtavConnectionfile_Internalname = "vCONNECTIONFILE" ;
      edtavDeleteconnection_Internalname = "vDELETECONNECTION" ;
      edtavConnectionfilexml_Internalname = "vCONNECTIONFILEXML" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      divTblconnkeys_Internalname = "TBLCONNKEYS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtnuacancel_Internalname = "BTNUACANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavFileconnectionkey_Internalname = "vFILECONNECTIONKEY" ;
      edtavPconnectionname_Internalname = "vPCONNECTIONNAME" ;
      Gridwwsysconns_empowerer_Internalname = "GRIDWWSYSCONNS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridwwsysconns_Internalname = "GRIDWWSYSCONNS" ;
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
      subGridwwsysconns_Allowcollapsing = (byte)(0) ;
      subGridwwsysconns_Allowselection = (byte)(0) ;
      subGridwwsysconns_Header = "" ;
      edtavDeleteconnection_Jsonclick = "" ;
      edtavDeleteconnection_Visible = -1 ;
      edtavDeleteconnection_Enabled = 1 ;
      edtavConnectionfile_Jsonclick = "" ;
      edtavConnectionfile_Visible = -1 ;
      edtavConnectionfile_Enabled = 1 ;
      edtavIscurrentkey_Jsonclick = "" ;
      edtavIscurrentkey_Visible = -1 ;
      edtavIscurrentkey_Enabled = 1 ;
      edtavConnectionkey_Jsonclick = "" ;
      edtavConnectionkey_Visible = -1 ;
      edtavConnectionkey_Enabled = 1 ;
      subGridwwsysconns_Class = "WorkWith" ;
      subGridwwsysconns_Backcolorstyle = (byte)(0) ;
      bttBtngenkey_Visible = 1 ;
      edtavEncryptionkey_Jsonclick = "" ;
      edtavEncryptionkey_Enabled = 1 ;
      cellEncryptionkey_cell_Class = "" ;
      edtavEncryptionkey_Visible = 1 ;
      edtavPconnectionname_Jsonclick = "" ;
      edtavPconnectionname_Visible = 1 ;
      edtavFileconnectionkey_Jsonclick = "" ;
      edtavFileconnectionkey_Visible = 1 ;
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      edtavConnectionfilexml_Enabled = 1 ;
      edtavConnectionfilexml_Visible = 1 ;
      bttBtnusecurrentkey_Visible = 1 ;
      edtavNewconnectionkey_Jsonclick = "" ;
      edtavNewconnectionkey_Enabled = 1 ;
      divTblconnkeys_Visible = 1 ;
      divTextblockencryptionkey_cell_Class = "col-xs-12" ;
      edtavUserpassword_Jsonclick = "" ;
      edtavUserpassword_Enabled = 1 ;
      edtavUserpassword_Visible = 1 ;
      divUserpassword_cell_Class = "col-xs-12" ;
      edtavUsername_Jsonclick = "" ;
      edtavUsername_Enabled = 1 ;
      edtavConnectionname_Jsonclick = "" ;
      edtavConnectionname_Enabled = 1 ;
      divTblmaindata_Visible = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = "" ;
      Dvpanel_unnamedtable1_Cls = "PanelNoHeader" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      Dvpanel_tbladdconnkey_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tbladdconnkey_Iconposition = "Right" ;
      Dvpanel_tbladdconnkey_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tbladdconnkey_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tbladdconnkey_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tbladdconnkey_Title = httpContext.getMessage( "WWP_GAM_ConnectionKey", "") ;
      Dvpanel_tbladdconnkey_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tbladdconnkey_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tbladdconnkey_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tbladdconnkey_Width = "100%" ;
      Dvpanel_unnamedtable3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Iconposition = "Right" ;
      Dvpanel_unnamedtable3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Title = httpContext.getMessage( "WWP_GAM_Connection", "") ;
      Dvpanel_unnamedtable3_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Connection", "") );
      subGridwwsysconns_Rows = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDWWSYSCONNS_nFirstRecordOnPage'},{av:'GRIDWWSYSCONNS_nEOF'},{av:'subGridwwsysconns_Rows',ctrl:'GRIDWWSYSCONNS',prop:'Rows'},{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true},{av:'AV12FileXML',fld:'vFILEXML',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNGENKEY',prop:'Visible'}]}");
      setEventMetadata("GRIDWWSYSCONNS.LOAD","{handler:'e19332',iparms:[{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true}]");
      setEventMetadata("GRIDWWSYSCONNS.LOAD",",oparms:[{av:'AV7ConnectionKey',fld:'vCONNECTIONKEY',pic:'',hsh:true},{av:'AV24IsCurrentKey',fld:'vISCURRENTKEY',pic:''},{av:'AV32ConnectionFile',fld:'vCONNECTIONFILE',pic:''},{av:'AV33DeleteConnection',fld:'vDELETECONNECTION',pic:''},{ctrl:'BTNUSECURRENTKEY',prop:'Visible'}]}");
      setEventMetadata("'DOUACANCEL'","{handler:'e11331',iparms:[]");
      setEventMetadata("'DOUACANCEL'",",oparms:[]}");
      setEventMetadata("'DOUSEAUTOMATICKEY'","{handler:'e12332',iparms:[]");
      setEventMetadata("'DOUSEAUTOMATICKEY'",",oparms:[{av:'AV18NewConnectionKey',fld:'vNEWCONNECTIONKEY',pic:''}]}");
      setEventMetadata("'DOUSECURRENTKEY'","{handler:'e13332',iparms:[{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true}]");
      setEventMetadata("'DOUSECURRENTKEY'",",oparms:[{av:'AV18NewConnectionKey',fld:'vNEWCONNECTIONKEY',pic:''}]}");
      setEventMetadata("'DOSAVEKEY'","{handler:'e14332',iparms:[{av:'AV18NewConnectionKey',fld:'vNEWCONNECTIONKEY',pic:''},{av:'AV8ConnectionName',fld:'vCONNECTIONNAME',pic:''},{av:'AV19pConnectionName',fld:'vPCONNECTIONNAME',pic:''}]");
      setEventMetadata("'DOSAVEKEY'",",oparms:[{av:'AV19pConnectionName',fld:'vPCONNECTIONNAME',pic:''}]}");
      setEventMetadata("'DOGENKEY'","{handler:'e15332',iparms:[]");
      setEventMetadata("'DOGENKEY'",",oparms:[{av:'AV9EncryptionKey',fld:'vENCRYPTIONKEY',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e16332',iparms:[{av:'AV8ConnectionName',fld:'vCONNECTIONNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20UserName',fld:'vUSERNAME',pic:''},{av:'AV21UserPassword',fld:'vUSERPASSWORD',pic:''},{av:'AV9EncryptionKey',fld:'vENCRYPTIONKEY',pic:''},{av:'AV19pConnectionName',fld:'vPCONNECTIONNAME',pic:''}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("VDELETECONNECTION.CLICK","{handler:'e20332',iparms:[{av:'AV7ConnectionKey',fld:'vCONNECTIONKEY',pic:'',hsh:true},{av:'AV8ConnectionName',fld:'vCONNECTIONNAME',pic:''},{av:'AV19pConnectionName',fld:'vPCONNECTIONNAME',pic:''}]");
      setEventMetadata("VDELETECONNECTION.CLICK",",oparms:[{av:'AV19pConnectionName',fld:'vPCONNECTIONNAME',pic:''}]}");
      setEventMetadata("VCONNECTIONFILE.CLICK","{handler:'e21332',iparms:[{av:'AV25FileConnectionKey',fld:'vFILECONNECTIONKEY',pic:''},{av:'AV7ConnectionKey',fld:'vCONNECTIONKEY',pic:'',hsh:true},{av:'AV8ConnectionName',fld:'vCONNECTIONNAME',pic:''},{av:'AV12FileXML',fld:'vFILEXML',pic:'',hsh:true}]");
      setEventMetadata("VCONNECTIONFILE.CLICK",",oparms:[{av:'AV6ConnectionFileXML',fld:'vCONNECTIONFILEXML',pic:''},{av:'AV25FileConnectionKey',fld:'vFILECONNECTIONKEY',pic:''},{av:'edtavConnectionfilexml_Visible',ctrl:'vCONNECTIONFILEXML',prop:'Visible'}]}");
      setEventMetadata("GRIDWWSYSCONNS_FIRSTPAGE","{handler:'subgridwwsysconns_firstpage',iparms:[{av:'GRIDWWSYSCONNS_nFirstRecordOnPage'},{av:'GRIDWWSYSCONNS_nEOF'},{av:'subGridwwsysconns_Rows',ctrl:'GRIDWWSYSCONNS',prop:'Rows'},{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true},{av:'AV12FileXML',fld:'vFILEXML',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("GRIDWWSYSCONNS_FIRSTPAGE",",oparms:[{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNGENKEY',prop:'Visible'}]}");
      setEventMetadata("GRIDWWSYSCONNS_PREVPAGE","{handler:'subgridwwsysconns_previouspage',iparms:[{av:'GRIDWWSYSCONNS_nFirstRecordOnPage'},{av:'GRIDWWSYSCONNS_nEOF'},{av:'subGridwwsysconns_Rows',ctrl:'GRIDWWSYSCONNS',prop:'Rows'},{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true},{av:'AV12FileXML',fld:'vFILEXML',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("GRIDWWSYSCONNS_PREVPAGE",",oparms:[{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNGENKEY',prop:'Visible'}]}");
      setEventMetadata("GRIDWWSYSCONNS_NEXTPAGE","{handler:'subgridwwsysconns_nextpage',iparms:[{av:'GRIDWWSYSCONNS_nFirstRecordOnPage'},{av:'GRIDWWSYSCONNS_nEOF'},{av:'subGridwwsysconns_Rows',ctrl:'GRIDWWSYSCONNS',prop:'Rows'},{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true},{av:'AV12FileXML',fld:'vFILEXML',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("GRIDWWSYSCONNS_NEXTPAGE",",oparms:[{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNGENKEY',prop:'Visible'}]}");
      setEventMetadata("GRIDWWSYSCONNS_LASTPAGE","{handler:'subgridwwsysconns_lastpage',iparms:[{av:'GRIDWWSYSCONNS_nFirstRecordOnPage'},{av:'GRIDWWSYSCONNS_nEOF'},{av:'subGridwwsysconns_Rows',ctrl:'GRIDWWSYSCONNS',prop:'Rows'},{av:'AV23CurrentConnectionKey',fld:'vCURRENTCONNECTIONKEY',pic:'',hsh:true},{av:'AV12FileXML',fld:'vFILEXML',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("GRIDWWSYSCONNS_LASTPAGE",",oparms:[{ctrl:'BTNENTER',prop:'Visible'},{ctrl:'BTNGENKEY',prop:'Visible'}]}");
      setEventMetadata("NULL","{handler:'validv_Deleteconnection',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      return "gamconnectionentry_Execute";
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
      wcpOAV19pConnectionName = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV19pConnectionName = "" ;
      AV23CurrentConnectionKey = "" ;
      AV12FileXML = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      Gridwwsysconns_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_unnamedtable3 = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV8ConnectionName = "" ;
      AV20UserName = "" ;
      AV21UserPassword = "" ;
      lblTextblockencryptionkey_Jsonclick = "" ;
      ucDvpanel_tbladdconnkey = new com.genexus.webpanels.GXUserControl();
      lblTextblocknewconnectionkey_Jsonclick = "" ;
      AV18NewConnectionKey = "" ;
      bttBtnsavekey_Jsonclick = "" ;
      bttBtnuseautomatickey_Jsonclick = "" ;
      bttBtnusecurrentkey_Jsonclick = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      GridwwsysconnsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      AV6ConnectionFileXML = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtnuacancel_Jsonclick = "" ;
      AV25FileConnectionKey = "" ;
      ucGridwwsysconns_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV7ConnectionKey = "" ;
      AV24IsCurrentKey = "" ;
      AV32ConnectionFile = "" ;
      AV33DeleteConnection = "" ;
      AV9EncryptionKey = "" ;
      AV13GAMRepositoryConnection = new genexus.security.api.genexussecurity.SdtGAMRepositoryConnection(remoteHandle, context);
      AV42GXV1 = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSystemConnection>(genexus.security.api.genexussecurity.SdtGAMSystemConnection.class, "GAMSystemConnection", "http://tempuri.org/", remoteHandle);
      AV11Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV14GAMSystemConnection = new genexus.security.api.genexussecurity.SdtGAMSystemConnection(remoteHandle, context);
      GridwwsysconnsRow = new com.genexus.webpanels.GXWebRow();
      AV15GXGUID = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      GXv_char1 = new String[1] ;
      GXv_objcol_SdtGAMError2 = new GXExternalCollection[1] ;
      AV10Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      bttBtngenkey_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridwwsysconns_Linesclass = "" ;
      ROClassString = "" ;
      GridwwsysconnsColumn = new com.genexus.webpanels.GXWebColumn();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamconnectionentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamconnectionentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavConnectionkey_Enabled = 0 ;
      edtavIscurrentkey_Enabled = 0 ;
      edtavConnectionfile_Enabled = 0 ;
      edtavDeleteconnection_Enabled = 0 ;
   }

   private byte GRIDWWSYSCONNS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGridwwsysconns_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGridwwsysconns_Backstyle ;
   private byte subGridwwsysconns_Titlebackstyle ;
   private byte subGridwwsysconns_Allowselection ;
   private byte subGridwwsysconns_Allowhovering ;
   private byte subGridwwsysconns_Allowcollapsing ;
   private byte subGridwwsysconns_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_85 ;
   private int subGridwwsysconns_Rows ;
   private int nGXsfl_85_idx=1 ;
   private int divTblmaindata_Visible ;
   private int edtavConnectionname_Enabled ;
   private int edtavUsername_Enabled ;
   private int edtavUserpassword_Visible ;
   private int edtavUserpassword_Enabled ;
   private int divTblconnkeys_Visible ;
   private int edtavNewconnectionkey_Enabled ;
   private int bttBtnusecurrentkey_Visible ;
   private int edtavConnectionfilexml_Visible ;
   private int edtavConnectionfilexml_Enabled ;
   private int bttBtnenter_Visible ;
   private int edtavFileconnectionkey_Visible ;
   private int edtavPconnectionname_Visible ;
   private int subGridwwsysconns_Islastpage ;
   private int edtavConnectionkey_Enabled ;
   private int edtavIscurrentkey_Enabled ;
   private int edtavConnectionfile_Enabled ;
   private int edtavDeleteconnection_Enabled ;
   private int GRIDWWSYSCONNS_nGridOutOfScope ;
   private int subGridwwsysconns_Recordcount ;
   private int AV43GXV2 ;
   private int bttBtngenkey_Visible ;
   private int edtavEncryptionkey_Visible ;
   private int AV44GXV3 ;
   private int edtavEncryptionkey_Enabled ;
   private int idxLst ;
   private int subGridwwsysconns_Backcolor ;
   private int subGridwwsysconns_Allbackcolor ;
   private int edtavConnectionkey_Visible ;
   private int edtavIscurrentkey_Visible ;
   private int edtavConnectionfile_Visible ;
   private int edtavDeleteconnection_Visible ;
   private int subGridwwsysconns_Titlebackcolor ;
   private int subGridwwsysconns_Selectedindex ;
   private int subGridwwsysconns_Selectioncolor ;
   private int subGridwwsysconns_Hoveringcolor ;
   private long GRIDWWSYSCONNS_nFirstRecordOnPage ;
   private long GRIDWWSYSCONNS_nCurrentRecord ;
   private String wcpOGx_mode ;
   private String wcpOAV19pConnectionName ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV19pConnectionName ;
   private String sGXsfl_85_idx="0001" ;
   private String AV23CurrentConnectionKey ;
   private String AV12FileXML ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvpanel_unnamedtable3_Width ;
   private String Dvpanel_unnamedtable3_Cls ;
   private String Dvpanel_unnamedtable3_Title ;
   private String Dvpanel_unnamedtable3_Iconposition ;
   private String Dvpanel_tbladdconnkey_Width ;
   private String Dvpanel_tbladdconnkey_Cls ;
   private String Dvpanel_tbladdconnkey_Title ;
   private String Dvpanel_tbladdconnkey_Iconposition ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Gridwwsysconns_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String divTblmaindata_Internalname ;
   private String Dvpanel_unnamedtable3_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String edtavConnectionname_Internalname ;
   private String TempTags ;
   private String AV8ConnectionName ;
   private String edtavConnectionname_Jsonclick ;
   private String edtavUsername_Internalname ;
   private String AV20UserName ;
   private String edtavUsername_Jsonclick ;
   private String divUserpassword_cell_Internalname ;
   private String divUserpassword_cell_Class ;
   private String edtavUserpassword_Internalname ;
   private String AV21UserPassword ;
   private String edtavUserpassword_Jsonclick ;
   private String divTablesplittedencryptionkey_Internalname ;
   private String divTextblockencryptionkey_cell_Internalname ;
   private String divTextblockencryptionkey_cell_Class ;
   private String lblTextblockencryptionkey_Internalname ;
   private String lblTextblockencryptionkey_Jsonclick ;
   private String divTblconnkeys_Internalname ;
   private String Dvpanel_tbladdconnkey_Internalname ;
   private String divTbladdconnkey_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String divUnnamedtablenewconnectionkey_Internalname ;
   private String lblTextblocknewconnectionkey_Internalname ;
   private String lblTextblocknewconnectionkey_Jsonclick ;
   private String edtavNewconnectionkey_Internalname ;
   private String AV18NewConnectionKey ;
   private String edtavNewconnectionkey_Jsonclick ;
   private String bttBtnsavekey_Internalname ;
   private String bttBtnsavekey_Jsonclick ;
   private String bttBtnuseautomatickey_Internalname ;
   private String bttBtnuseautomatickey_Jsonclick ;
   private String bttBtnusecurrentkey_Internalname ;
   private String bttBtnusecurrentkey_Jsonclick ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String sStyleString ;
   private String subGridwwsysconns_Internalname ;
   private String edtavConnectionfilexml_Internalname ;
   private String AV6ConnectionFileXML ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtnuacancel_Internalname ;
   private String bttBtnuacancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavFileconnectionkey_Internalname ;
   private String AV25FileConnectionKey ;
   private String edtavFileconnectionkey_Jsonclick ;
   private String edtavPconnectionname_Internalname ;
   private String edtavPconnectionname_Jsonclick ;
   private String Gridwwsysconns_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV7ConnectionKey ;
   private String edtavConnectionkey_Internalname ;
   private String edtavIscurrentkey_Internalname ;
   private String AV32ConnectionFile ;
   private String edtavConnectionfile_Internalname ;
   private String AV33DeleteConnection ;
   private String edtavDeleteconnection_Internalname ;
   private String AV9EncryptionKey ;
   private String edtavEncryptionkey_Internalname ;
   private String bttBtngenkey_Internalname ;
   private String cellEncryptionkey_cell_Class ;
   private String cellEncryptionkey_cell_Internalname ;
   private String GXv_char1[] ;
   private String tblTablemergedencryptionkey_Internalname ;
   private String edtavEncryptionkey_Jsonclick ;
   private String bttBtngenkey_Jsonclick ;
   private String sGXsfl_85_fel_idx="0001" ;
   private String subGridwwsysconns_Class ;
   private String subGridwwsysconns_Linesclass ;
   private String ROClassString ;
   private String edtavConnectionkey_Jsonclick ;
   private String edtavIscurrentkey_Jsonclick ;
   private String edtavConnectionfile_Jsonclick ;
   private String edtavDeleteconnection_Jsonclick ;
   private String subGridwwsysconns_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_unnamedtable3_Autowidth ;
   private boolean Dvpanel_unnamedtable3_Autoheight ;
   private boolean Dvpanel_unnamedtable3_Collapsible ;
   private boolean Dvpanel_unnamedtable3_Collapsed ;
   private boolean Dvpanel_unnamedtable3_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable3_Autoscroll ;
   private boolean Dvpanel_tbladdconnkey_Autowidth ;
   private boolean Dvpanel_tbladdconnkey_Autoheight ;
   private boolean Dvpanel_tbladdconnkey_Collapsible ;
   private boolean Dvpanel_tbladdconnkey_Collapsed ;
   private boolean Dvpanel_tbladdconnkey_Showcollapseicon ;
   private boolean Dvpanel_tbladdconnkey_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_85_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean AV16isOk ;
   private boolean AV27hasCurrentKey ;
   private boolean Cond_result ;
   private String AV24IsCurrentKey ;
   private java.util.UUID AV15GXGUID ;
   private com.genexus.webpanels.GXWebGrid GridwwsysconnsContainer ;
   private com.genexus.webpanels.GXWebRow GridwwsysconnsRow ;
   private com.genexus.webpanels.GXWebColumn GridwwsysconnsColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable3 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tbladdconnkey ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucGridwwsysconns_empowerer ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV11Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError2[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSystemConnection> AV42GXV1 ;
   private genexus.security.api.genexussecurity.SdtGAMError AV10Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepositoryConnection AV13GAMRepositoryConnection ;
   private genexus.security.api.genexussecurity.SdtGAMSystemConnection AV14GAMSystemConnection ;
}

final  class gamconnectionentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamconnectionentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

