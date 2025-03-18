package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamsecuritypolicyentry_impl extends GXDataArea
{
   public gamsecuritypolicyentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamsecuritypolicyentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsecuritypolicyentry_impl.class ));
   }

   public gamsecuritypolicyentry_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions = new HTMLChoice();
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
               AV7Id = GXutil.lval( httpContext.GetPar( "Id")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV7Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Id), 12, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7Id), "ZZZZZZZZZZZ9")));
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
      pa3A2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start3A2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7Id,12,0))}, new String[] {"Gx_mode","Id"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7Id), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"GAMSecurityPolicyEntry");
      forbiddenHiddens.add("SecurityPolicyGUID", GXutil.rtrim( localUtil.format( AV20SecurityPolicyGUID, "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("gamsecuritypolicyentry:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV7Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7Id), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Width", GXutil.rtrim( Dvpanel_onlyweb_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Autowidth", GXutil.booltostr( Dvpanel_onlyweb_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Autoheight", GXutil.booltostr( Dvpanel_onlyweb_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Cls", GXutil.rtrim( Dvpanel_onlyweb_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Title", GXutil.rtrim( Dvpanel_onlyweb_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Collapsible", GXutil.booltostr( Dvpanel_onlyweb_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Collapsed", GXutil.booltostr( Dvpanel_onlyweb_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Showcollapseicon", GXutil.booltostr( Dvpanel_onlyweb_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Iconposition", GXutil.rtrim( Dvpanel_onlyweb_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYWEB_Autoscroll", GXutil.booltostr( Dvpanel_onlyweb_Autoscroll));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Width", GXutil.rtrim( Dvpanel_onlysd_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Autowidth", GXutil.booltostr( Dvpanel_onlysd_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Autoheight", GXutil.booltostr( Dvpanel_onlysd_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Cls", GXutil.rtrim( Dvpanel_onlysd_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Title", GXutil.rtrim( Dvpanel_onlysd_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Collapsible", GXutil.booltostr( Dvpanel_onlysd_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Collapsed", GXutil.booltostr( Dvpanel_onlysd_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Showcollapseicon", GXutil.booltostr( Dvpanel_onlysd_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Iconposition", GXutil.rtrim( Dvpanel_onlysd_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_ONLYSD_Autoscroll", GXutil.booltostr( Dvpanel_onlysd_Autoscroll));
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
         we3A2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt3A2( ) ;
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
      return formatLink("com.mujermorena.gamsecuritypolicyentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7Id,12,0))}, new String[] {"Gx_mode","Id"})  ;
   }

   public String getPgmname( )
   {
      return "GAMSecurityPolicyEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "WWP_GAM_SecurityPolicy", "") ;
   }

   public void wb3A0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyid_Internalname, httpContext.getMessage( "WWP_GAM_Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyid_Internalname, GXutil.ltrim( localUtil.ntoc( AV19SecurityPolicyId, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavSecuritypolicyid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19SecurityPolicyId), "ZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19SecurityPolicyId), "ZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuritypolicyid_Enabled, 0, "text", "1", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMKeyNumShort", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyguid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyguid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyguid_Internalname, GXutil.rtrim( AV20SecurityPolicyGUID), GXutil.rtrim( localUtil.format( AV20SecurityPolicyGUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyguid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSecuritypolicyguid_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyname_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyname_Internalname, httpContext.getMessage( "WWP_GAM_Name", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyname_Internalname, GXutil.rtrim( AV21SecurityPolicyName), GXutil.rtrim( localUtil.format( AV21SecurityPolicyName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyname_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyname_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMSecurityPolicyEntry.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyperiodchangepassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyperiodchangepassword_Internalname, httpContext.getMessage( "WWP_GAM_Periodtochangeitdays", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyperiodchangepassword_Internalname, GXutil.ltrim( localUtil.ntoc( AV12SecurityPolicyPeriodChangePassword, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12SecurityPolicyPeriodChangePassword), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,41);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyperiodchangepassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyperiodchangepassword_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyminimumtimetochangepasswords_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyminimumtimetochangepasswords_Internalname, httpContext.getMessage( "WWP_GAM_Mintimetochangepasswordminutes", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyminimumtimetochangepasswords_Internalname, GXutil.ltrim( localUtil.ntoc( AV13SecurityPolicyMinimumTimeToChangePasswords, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV13SecurityPolicyMinimumTimeToChangePasswords), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyminimumtimetochangepasswords_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyminimumtimetochangepasswords_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyminimumlengthpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyminimumlengthpassword_Internalname, httpContext.getMessage( "WWP_GAM_Minpasswordlength", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyminimumlengthpassword_Internalname, GXutil.ltrim( localUtil.ntoc( AV14SecurityPolicyMinimumLengthPassword, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV14SecurityPolicyMinimumLengthPassword), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyminimumlengthpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyminimumlengthpassword_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyminimumnumericcharacterspassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyminimumnumericcharacterspassword_Internalname, httpContext.getMessage( "WWP_GAM_Minnumericcharacters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyminimumnumericcharacterspassword_Internalname, GXutil.ltrim( localUtil.ntoc( AV15SecurityPolicyMinimumNumericCharactersPassword, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV15SecurityPolicyMinimumNumericCharactersPassword), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyminimumnumericcharacterspassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyminimumnumericcharacterspassword_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname, httpContext.getMessage( "WWP_GAM_Minuppercasecharacters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname, GXutil.ltrim( localUtil.ntoc( AV16SecurityPolicyMinimumUpperCaseCharactersPassword, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV16SecurityPolicyMinimumUpperCaseCharactersPassword), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyminimumuppercasecharacterspassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyminimumuppercasecharacterspassword_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyminimumspecialcharacterspassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyminimumspecialcharacterspassword_Internalname, httpContext.getMessage( "WWP_GAM_Minspecialcharacters", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyminimumspecialcharacterspassword_Internalname, GXutil.ltrim( localUtil.ntoc( AV17SecurityPolicyMinimumSpecialCharactersPassword, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV17SecurityPolicyMinimumSpecialCharactersPassword), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyminimumspecialcharacterspassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyminimumspecialcharacterspassword_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicymaximumpasswordhistoryentries_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicymaximumpasswordhistoryentries_Internalname, httpContext.getMessage( "WWP_GAM_Maxpasswordhistoryentries", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicymaximumpasswordhistoryentries_Internalname, GXutil.ltrim( localUtil.ntoc( AV18SecurityPolicyMaximumPasswordHistoryEntries, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV18SecurityPolicyMaximumPasswordHistoryEntries), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicymaximumpasswordhistoryentries_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicymaximumpasswordhistoryentries_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
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
         ucDvpanel_onlyweb.setProperty("Width", Dvpanel_onlyweb_Width);
         ucDvpanel_onlyweb.setProperty("AutoWidth", Dvpanel_onlyweb_Autowidth);
         ucDvpanel_onlyweb.setProperty("AutoHeight", Dvpanel_onlyweb_Autoheight);
         ucDvpanel_onlyweb.setProperty("Cls", Dvpanel_onlyweb_Cls);
         ucDvpanel_onlyweb.setProperty("Title", Dvpanel_onlyweb_Title);
         ucDvpanel_onlyweb.setProperty("Collapsible", Dvpanel_onlyweb_Collapsible);
         ucDvpanel_onlyweb.setProperty("Collapsed", Dvpanel_onlyweb_Collapsed);
         ucDvpanel_onlyweb.setProperty("ShowCollapseIcon", Dvpanel_onlyweb_Showcollapseicon);
         ucDvpanel_onlyweb.setProperty("IconPosition", Dvpanel_onlyweb_Iconposition);
         ucDvpanel_onlyweb.setProperty("AutoScroll", Dvpanel_onlyweb_Autoscroll);
         ucDvpanel_onlyweb.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_onlyweb_Internalname, "DVPANEL_ONLYWEBContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_ONLYWEBContainer"+"OnlyWeb"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOnlyweb_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname(), httpContext.getMessage( "WWP_GAM_AllowMultipleConcurrentWebsessions", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSecuritypolicyallowmultipleconcurrentwebsessions, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname(), GXutil.trim( GXutil.str( AV10SecurityPolicyAllowMultipleConcurrentWebSessions, 4, 0)), 1, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "", true, (byte)(0), "HLP_GAMSecurityPolicyEntry.htm");
         cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setValue( GXutil.trim( GXutil.str( AV10SecurityPolicyAllowMultipleConcurrentWebSessions, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname(), "Values", cmbavSecuritypolicyallowmultipleconcurrentwebsessions.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicywebsessiontimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicywebsessiontimeout_Internalname, httpContext.getMessage( "WWP_GAM_Sessiontimeoutminutes", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicywebsessiontimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV11SecurityPolicyWebSessionTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV11SecurityPolicyWebSessionTimeout), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicywebsessiontimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicywebsessiontimeout_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
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
         ucDvpanel_onlysd.setProperty("Width", Dvpanel_onlysd_Width);
         ucDvpanel_onlysd.setProperty("AutoWidth", Dvpanel_onlysd_Autowidth);
         ucDvpanel_onlysd.setProperty("AutoHeight", Dvpanel_onlysd_Autoheight);
         ucDvpanel_onlysd.setProperty("Cls", Dvpanel_onlysd_Cls);
         ucDvpanel_onlysd.setProperty("Title", Dvpanel_onlysd_Title);
         ucDvpanel_onlysd.setProperty("Collapsible", Dvpanel_onlysd_Collapsible);
         ucDvpanel_onlysd.setProperty("Collapsed", Dvpanel_onlysd_Collapsed);
         ucDvpanel_onlysd.setProperty("ShowCollapseIcon", Dvpanel_onlysd_Showcollapseicon);
         ucDvpanel_onlysd.setProperty("IconPosition", Dvpanel_onlysd_Iconposition);
         ucDvpanel_onlysd.setProperty("AutoScroll", Dvpanel_onlysd_Autoscroll);
         ucDvpanel_onlysd.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_onlysd_Internalname, "DVPANEL_ONLYSDContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_ONLYSDContainer"+"OnlySD"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divOnlysd_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyoauthtokenexpire_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyoauthtokenexpire_Internalname, httpContext.getMessage( "WWP_GAM_Oauthtokenexpireminutes", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyoauthtokenexpire_Internalname, GXutil.ltrim( localUtil.ntoc( AV9SecurityPolicyOauthTokenExpire, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV9SecurityPolicyOauthTokenExpire), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,93);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyoauthtokenexpire_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyoauthtokenexpire_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname, httpContext.getMessage( "WWP_GAM_Maxtokenrenovations", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname, GXutil.ltrim( localUtil.ntoc( AV22SecurityPolicyOauthTokenMaximumRenovations, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV22SecurityPolicyOauthTokenMaximumRenovations), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,98);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSecuritypolicyoauthtokenmaximumrenovations_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavSecuritypolicyoauthtokenmaximumrenovations_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMSecurityPolicyEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMSecurityPolicyEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMSecurityPolicyEntry.htm");
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

   public void start3A2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "WWP_GAM_SecurityPolicy", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup3A0( ) ;
   }

   public void ws3A2( )
   {
      start3A2( ) ;
      evt3A2( ) ;
   }

   public void evt3A2( )
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
                           e113A2 ();
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
                                 e123A2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e133A2 ();
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

   public void we3A2( )
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

   public void pa3A2( )
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
            GX_FocusControl = edtavSecuritypolicyid_Internalname ;
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
      if ( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getItemCount() > 0 )
      {
         AV10SecurityPolicyAllowMultipleConcurrentWebSessions = (short)(GXutil.lval( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getValidValue(GXutil.trim( GXutil.str( AV10SecurityPolicyAllowMultipleConcurrentWebSessions, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10SecurityPolicyAllowMultipleConcurrentWebSessions", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10SecurityPolicyAllowMultipleConcurrentWebSessions), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setValue( GXutil.trim( GXutil.str( AV10SecurityPolicyAllowMultipleConcurrentWebSessions, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname(), "Values", cmbavSecuritypolicyallowmultipleconcurrentwebsessions.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3A2( ) ;
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
      edtavSecuritypolicyid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyid_Enabled), 5, 0), true);
      edtavSecuritypolicyguid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyguid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyguid_Enabled), 5, 0), true);
   }

   public void rf3A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e133A2 ();
         wb3A0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3A2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV7Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7Id), "ZZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSecuritypolicyid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyid_Enabled), 5, 0), true);
      edtavSecuritypolicyguid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyguid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyguid_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup3A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e113A2 ();
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
         Dvpanel_onlyweb_Width = httpContext.cgiGet( "DVPANEL_ONLYWEB_Width") ;
         Dvpanel_onlyweb_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYWEB_Autowidth")) ;
         Dvpanel_onlyweb_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYWEB_Autoheight")) ;
         Dvpanel_onlyweb_Cls = httpContext.cgiGet( "DVPANEL_ONLYWEB_Cls") ;
         Dvpanel_onlyweb_Title = httpContext.cgiGet( "DVPANEL_ONLYWEB_Title") ;
         Dvpanel_onlyweb_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYWEB_Collapsible")) ;
         Dvpanel_onlyweb_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYWEB_Collapsed")) ;
         Dvpanel_onlyweb_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYWEB_Showcollapseicon")) ;
         Dvpanel_onlyweb_Iconposition = httpContext.cgiGet( "DVPANEL_ONLYWEB_Iconposition") ;
         Dvpanel_onlyweb_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYWEB_Autoscroll")) ;
         Dvpanel_onlysd_Width = httpContext.cgiGet( "DVPANEL_ONLYSD_Width") ;
         Dvpanel_onlysd_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYSD_Autowidth")) ;
         Dvpanel_onlysd_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYSD_Autoheight")) ;
         Dvpanel_onlysd_Cls = httpContext.cgiGet( "DVPANEL_ONLYSD_Cls") ;
         Dvpanel_onlysd_Title = httpContext.cgiGet( "DVPANEL_ONLYSD_Title") ;
         Dvpanel_onlysd_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYSD_Collapsible")) ;
         Dvpanel_onlysd_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYSD_Collapsed")) ;
         Dvpanel_onlysd_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYSD_Showcollapseicon")) ;
         Dvpanel_onlysd_Iconposition = httpContext.cgiGet( "DVPANEL_ONLYSD_Iconposition") ;
         Dvpanel_onlysd_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_ONLYSD_Autoscroll")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYID");
            GX_FocusControl = edtavSecuritypolicyid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19SecurityPolicyId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19SecurityPolicyId), 9, 0));
         }
         else
         {
            AV19SecurityPolicyId = (int)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19SecurityPolicyId), 9, 0));
         }
         AV20SecurityPolicyGUID = httpContext.cgiGet( edtavSecuritypolicyguid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20SecurityPolicyGUID", AV20SecurityPolicyGUID);
         AV21SecurityPolicyName = httpContext.cgiGet( edtavSecuritypolicyname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21SecurityPolicyName", AV21SecurityPolicyName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyperiodchangepassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyperiodchangepassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYPERIODCHANGEPASSWORD");
            GX_FocusControl = edtavSecuritypolicyperiodchangepassword_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12SecurityPolicyPeriodChangePassword = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12SecurityPolicyPeriodChangePassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SecurityPolicyPeriodChangePassword), 4, 0));
         }
         else
         {
            AV12SecurityPolicyPeriodChangePassword = (short)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyperiodchangepassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12SecurityPolicyPeriodChangePassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SecurityPolicyPeriodChangePassword), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumtimetochangepasswords_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumtimetochangepasswords_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYMINIMUMTIMETOCHANGEPASSWORDS");
            GX_FocusControl = edtavSecuritypolicyminimumtimetochangepasswords_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV13SecurityPolicyMinimumTimeToChangePasswords = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13SecurityPolicyMinimumTimeToChangePasswords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SecurityPolicyMinimumTimeToChangePasswords), 4, 0));
         }
         else
         {
            AV13SecurityPolicyMinimumTimeToChangePasswords = (short)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumtimetochangepasswords_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13SecurityPolicyMinimumTimeToChangePasswords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SecurityPolicyMinimumTimeToChangePasswords), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumlengthpassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumlengthpassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYMINIMUMLENGTHPASSWORD");
            GX_FocusControl = edtavSecuritypolicyminimumlengthpassword_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV14SecurityPolicyMinimumLengthPassword = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14SecurityPolicyMinimumLengthPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecurityPolicyMinimumLengthPassword), 2, 0));
         }
         else
         {
            AV14SecurityPolicyMinimumLengthPassword = (byte)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumlengthpassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14SecurityPolicyMinimumLengthPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecurityPolicyMinimumLengthPassword), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumnumericcharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumnumericcharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYMINIMUMNUMERICCHARACTERSPASSWORD");
            GX_FocusControl = edtavSecuritypolicyminimumnumericcharacterspassword_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV15SecurityPolicyMinimumNumericCharactersPassword = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15SecurityPolicyMinimumNumericCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecurityPolicyMinimumNumericCharactersPassword), 2, 0));
         }
         else
         {
            AV15SecurityPolicyMinimumNumericCharactersPassword = (byte)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumnumericcharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15SecurityPolicyMinimumNumericCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecurityPolicyMinimumNumericCharactersPassword), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYMINIMUMUPPERCASECHARACTERSPASSWORD");
            GX_FocusControl = edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16SecurityPolicyMinimumUpperCaseCharactersPassword = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16SecurityPolicyMinimumUpperCaseCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16SecurityPolicyMinimumUpperCaseCharactersPassword), 2, 0));
         }
         else
         {
            AV16SecurityPolicyMinimumUpperCaseCharactersPassword = (byte)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16SecurityPolicyMinimumUpperCaseCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16SecurityPolicyMinimumUpperCaseCharactersPassword), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumspecialcharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumspecialcharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYMINIMUMSPECIALCHARACTERSPASSWORD");
            GX_FocusControl = edtavSecuritypolicyminimumspecialcharacterspassword_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17SecurityPolicyMinimumSpecialCharactersPassword = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17SecurityPolicyMinimumSpecialCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17SecurityPolicyMinimumSpecialCharactersPassword), 2, 0));
         }
         else
         {
            AV17SecurityPolicyMinimumSpecialCharactersPassword = (byte)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyminimumspecialcharacterspassword_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17SecurityPolicyMinimumSpecialCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17SecurityPolicyMinimumSpecialCharactersPassword), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicymaximumpasswordhistoryentries_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicymaximumpasswordhistoryentries_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYMAXIMUMPASSWORDHISTORYENTRIES");
            GX_FocusControl = edtavSecuritypolicymaximumpasswordhistoryentries_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18SecurityPolicyMaximumPasswordHistoryEntries = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18SecurityPolicyMaximumPasswordHistoryEntries", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18SecurityPolicyMaximumPasswordHistoryEntries), 4, 0));
         }
         else
         {
            AV18SecurityPolicyMaximumPasswordHistoryEntries = (short)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicymaximumpasswordhistoryentries_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18SecurityPolicyMaximumPasswordHistoryEntries", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18SecurityPolicyMaximumPasswordHistoryEntries), 4, 0));
         }
         cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setValue( httpContext.cgiGet( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname()) );
         AV10SecurityPolicyAllowMultipleConcurrentWebSessions = (short)(GXutil.lval( httpContext.cgiGet( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10SecurityPolicyAllowMultipleConcurrentWebSessions", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10SecurityPolicyAllowMultipleConcurrentWebSessions), 4, 0));
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicywebsessiontimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicywebsessiontimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYWEBSESSIONTIMEOUT");
            GX_FocusControl = edtavSecuritypolicywebsessiontimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11SecurityPolicyWebSessionTimeout = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11SecurityPolicyWebSessionTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11SecurityPolicyWebSessionTimeout), 4, 0));
         }
         else
         {
            AV11SecurityPolicyWebSessionTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicywebsessiontimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11SecurityPolicyWebSessionTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11SecurityPolicyWebSessionTimeout), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyoauthtokenexpire_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyoauthtokenexpire_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYOAUTHTOKENEXPIRE");
            GX_FocusControl = edtavSecuritypolicyoauthtokenexpire_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9SecurityPolicyOauthTokenExpire = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9SecurityPolicyOauthTokenExpire", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecurityPolicyOauthTokenExpire), 6, 0));
         }
         else
         {
            AV9SecurityPolicyOauthTokenExpire = (int)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyoauthtokenexpire_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9SecurityPolicyOauthTokenExpire", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecurityPolicyOauthTokenExpire), 6, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vSECURITYPOLICYOAUTHTOKENMAXIMUMRENOVATIONS");
            GX_FocusControl = edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV22SecurityPolicyOauthTokenMaximumRenovations = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22SecurityPolicyOauthTokenMaximumRenovations", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22SecurityPolicyOauthTokenMaximumRenovations), 6, 0));
         }
         else
         {
            AV22SecurityPolicyOauthTokenMaximumRenovations = (int)(localUtil.ctol( httpContext.cgiGet( edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22SecurityPolicyOauthTokenMaximumRenovations", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22SecurityPolicyOauthTokenMaximumRenovations), 6, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"GAMSecurityPolicyEntry");
         AV20SecurityPolicyGUID = httpContext.cgiGet( edtavSecuritypolicyguid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20SecurityPolicyGUID", AV20SecurityPolicyGUID);
         forbiddenHiddens.add("SecurityPolicyGUID", GXutil.rtrim( localUtil.format( AV20SecurityPolicyGUID, "")));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("gamsecuritypolicyentry:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e113A2 ();
      if (returnInSub) return;
   }

   public void e113A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         AV8SecurityPolicy.load((int)(AV7Id));
         AV19SecurityPolicyId = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19SecurityPolicyId), 9, 0));
         AV20SecurityPolicyGUID = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Guid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20SecurityPolicyGUID", AV20SecurityPolicyGUID);
         AV21SecurityPolicyName = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Name() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21SecurityPolicyName", AV21SecurityPolicyName);
         AV12SecurityPolicyPeriodChangePassword = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Periodchangepassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SecurityPolicyPeriodChangePassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12SecurityPolicyPeriodChangePassword), 4, 0));
         AV13SecurityPolicyMinimumTimeToChangePasswords = (short)(AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Minimumtimetochangepasswords()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13SecurityPolicyMinimumTimeToChangePasswords", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13SecurityPolicyMinimumTimeToChangePasswords), 4, 0));
         AV14SecurityPolicyMinimumLengthPassword = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Minimumlengthpassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14SecurityPolicyMinimumLengthPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14SecurityPolicyMinimumLengthPassword), 2, 0));
         AV15SecurityPolicyMinimumNumericCharactersPassword = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Minimumnumericcharacterspassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15SecurityPolicyMinimumNumericCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15SecurityPolicyMinimumNumericCharactersPassword), 2, 0));
         AV16SecurityPolicyMinimumUpperCaseCharactersPassword = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Minimumuppercasecharacterspassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16SecurityPolicyMinimumUpperCaseCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16SecurityPolicyMinimumUpperCaseCharactersPassword), 2, 0));
         AV17SecurityPolicyMinimumSpecialCharactersPassword = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Minimumspecialcharacterspassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17SecurityPolicyMinimumSpecialCharactersPassword", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17SecurityPolicyMinimumSpecialCharactersPassword), 2, 0));
         AV18SecurityPolicyMaximumPasswordHistoryEntries = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Maximumpasswordhistoryentries() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18SecurityPolicyMaximumPasswordHistoryEntries", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18SecurityPolicyMaximumPasswordHistoryEntries), 4, 0));
         AV10SecurityPolicyAllowMultipleConcurrentWebSessions = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Allowmultipleconcurrentwebsessions() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10SecurityPolicyAllowMultipleConcurrentWebSessions", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10SecurityPolicyAllowMultipleConcurrentWebSessions), 4, 0));
         AV11SecurityPolicyWebSessionTimeout = (short)(AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Websessiontimeout()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11SecurityPolicyWebSessionTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11SecurityPolicyWebSessionTimeout), 4, 0));
         AV9SecurityPolicyOauthTokenExpire = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Oauthtokenexpire() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9SecurityPolicyOauthTokenExpire", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9SecurityPolicyOauthTokenExpire), 6, 0));
         AV22SecurityPolicyOauthTokenMaximumRenovations = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Oauthtokenmaximumrenovations() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22SecurityPolicyOauthTokenMaximumRenovations", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22SecurityPolicyOauthTokenMaximumRenovations), 6, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtnenter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         edtavSecuritypolicyname_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyname_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyname_Enabled), 5, 0), true);
         cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getEnabled(), 5, 0), true);
         edtavSecuritypolicywebsessiontimeout_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicywebsessiontimeout_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicywebsessiontimeout_Enabled), 5, 0), true);
         edtavSecuritypolicyoauthtokenexpire_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyoauthtokenexpire_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyoauthtokenexpire_Enabled), 5, 0), true);
         edtavSecuritypolicyoauthtokenmaximumrenovations_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyoauthtokenmaximumrenovations_Enabled), 5, 0), true);
         edtavSecuritypolicyperiodchangepassword_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyperiodchangepassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyperiodchangepassword_Enabled), 5, 0), true);
         edtavSecuritypolicyminimumtimetochangepasswords_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyminimumtimetochangepasswords_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyminimumtimetochangepasswords_Enabled), 5, 0), true);
         edtavSecuritypolicyminimumlengthpassword_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyminimumlengthpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyminimumlengthpassword_Enabled), 5, 0), true);
         edtavSecuritypolicyminimumnumericcharacterspassword_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyminimumnumericcharacterspassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyminimumnumericcharacterspassword_Enabled), 5, 0), true);
         edtavSecuritypolicyminimumuppercasecharacterspassword_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyminimumuppercasecharacterspassword_Enabled), 5, 0), true);
         edtavSecuritypolicyminimumspecialcharacterspassword_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicyminimumspecialcharacterspassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicyminimumspecialcharacterspassword_Enabled), 5, 0), true);
         edtavSecuritypolicymaximumpasswordhistoryentries_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavSecuritypolicymaximumpasswordhistoryentries_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSecuritypolicymaximumpasswordhistoryentries_Enabled), 5, 0), true);
         bttBtnenter_Caption = httpContext.getMessage( "Delete", "") ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e123A2 ();
      if (returnInSub) return;
   }

   public void e123A2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV8SecurityPolicy.load((int)(AV7Id));
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) || ( GXutil.strcmp(Gx_mode, "UPD") == 0 ) )
      {
         AV19SecurityPolicyId = AV8SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Id() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19SecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19SecurityPolicyId), 9, 0));
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Guid( AV20SecurityPolicyGUID );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Name( AV21SecurityPolicyName );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Periodchangepassword( AV12SecurityPolicyPeriodChangePassword );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Minimumtimetochangepasswords( AV13SecurityPolicyMinimumTimeToChangePasswords );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Minimumlengthpassword( AV14SecurityPolicyMinimumLengthPassword );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Minimumnumericcharacterspassword( AV15SecurityPolicyMinimumNumericCharactersPassword );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Minimumuppercasecharacterspassword( AV16SecurityPolicyMinimumUpperCaseCharactersPassword );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Minimumspecialcharacterspassword( AV17SecurityPolicyMinimumSpecialCharactersPassword );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Maximumpasswordhistoryentries( AV18SecurityPolicyMaximumPasswordHistoryEntries );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Allowmultipleconcurrentwebsessions( (byte)(GXutil.lval( GXutil.str( AV10SecurityPolicyAllowMultipleConcurrentWebSessions, 4, 0))) );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Websessiontimeout( AV11SecurityPolicyWebSessionTimeout );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Oauthtokenexpire( AV9SecurityPolicyOauthTokenExpire );
         AV8SecurityPolicy.setgxTv_SdtGAMSecurityPolicy_Oauthtokenmaximumrenovations( (short)(AV22SecurityPolicyOauthTokenMaximumRenovations) );
         AV8SecurityPolicy.save();
      }
      else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         AV8SecurityPolicy.delete();
      }
      if ( AV8SecurityPolicy.success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamsecuritypolicyentry");
         httpContext.setWebReturnParms(new Object[] {Gx_mode,Long.valueOf(AV7Id)});
         httpContext.setWebReturnParmsMetadata(new Object[] {"Gx_mode","AV7Id"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         AV6Errors = AV8SecurityPolicy.geterrors() ;
         AV31GXV1 = 1 ;
         while ( AV31GXV1 <= AV6Errors.size() )
         {
            AV5Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV6Errors.elementAt(-1+AV31GXV1));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV5Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV5Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV31GXV1 = (int)(AV31GXV1+1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e133A2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV7Id = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Id), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7Id), "ZZZZZZZZZZZ9")));
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
      pa3A2( ) ;
      ws3A2( ) ;
      we3A2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2024121111980", true, true);
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
      httpContext.AddJavascriptSource("gamsecuritypolicyentry.js", "?2024121111982", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      edtavSecuritypolicyid_Internalname = "vSECURITYPOLICYID" ;
      edtavSecuritypolicyguid_Internalname = "vSECURITYPOLICYGUID" ;
      edtavSecuritypolicyname_Internalname = "vSECURITYPOLICYNAME" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtavSecuritypolicyperiodchangepassword_Internalname = "vSECURITYPOLICYPERIODCHANGEPASSWORD" ;
      edtavSecuritypolicyminimumtimetochangepasswords_Internalname = "vSECURITYPOLICYMINIMUMTIMETOCHANGEPASSWORDS" ;
      edtavSecuritypolicyminimumlengthpassword_Internalname = "vSECURITYPOLICYMINIMUMLENGTHPASSWORD" ;
      edtavSecuritypolicyminimumnumericcharacterspassword_Internalname = "vSECURITYPOLICYMINIMUMNUMERICCHARACTERSPASSWORD" ;
      edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname = "vSECURITYPOLICYMINIMUMUPPERCASECHARACTERSPASSWORD" ;
      edtavSecuritypolicyminimumspecialcharacterspassword_Internalname = "vSECURITYPOLICYMINIMUMSPECIALCHARACTERSPASSWORD" ;
      edtavSecuritypolicymaximumpasswordhistoryentries_Internalname = "vSECURITYPOLICYMAXIMUMPASSWORDHISTORYENTRIES" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setInternalname( "vSECURITYPOLICYALLOWMULTIPLECONCURRENTWEBSESSIONS" );
      edtavSecuritypolicywebsessiontimeout_Internalname = "vSECURITYPOLICYWEBSESSIONTIMEOUT" ;
      divOnlyweb_Internalname = "ONLYWEB" ;
      Dvpanel_onlyweb_Internalname = "DVPANEL_ONLYWEB" ;
      edtavSecuritypolicyoauthtokenexpire_Internalname = "vSECURITYPOLICYOAUTHTOKENEXPIRE" ;
      edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname = "vSECURITYPOLICYOAUTHTOKENMAXIMUMRENOVATIONS" ;
      divOnlysd_Internalname = "ONLYSD" ;
      Dvpanel_onlysd_Internalname = "DVPANEL_ONLYSD" ;
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
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      bttBtnenter_Visible = 1 ;
      edtavSecuritypolicyoauthtokenmaximumrenovations_Jsonclick = "" ;
      edtavSecuritypolicyoauthtokenmaximumrenovations_Enabled = 1 ;
      edtavSecuritypolicyoauthtokenexpire_Jsonclick = "" ;
      edtavSecuritypolicyoauthtokenexpire_Enabled = 1 ;
      edtavSecuritypolicywebsessiontimeout_Jsonclick = "" ;
      edtavSecuritypolicywebsessiontimeout_Enabled = 1 ;
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setJsonclick( "" );
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setEnabled( 1 );
      edtavSecuritypolicymaximumpasswordhistoryentries_Jsonclick = "" ;
      edtavSecuritypolicymaximumpasswordhistoryentries_Enabled = 1 ;
      edtavSecuritypolicyminimumspecialcharacterspassword_Jsonclick = "" ;
      edtavSecuritypolicyminimumspecialcharacterspassword_Enabled = 1 ;
      edtavSecuritypolicyminimumuppercasecharacterspassword_Jsonclick = "" ;
      edtavSecuritypolicyminimumuppercasecharacterspassword_Enabled = 1 ;
      edtavSecuritypolicyminimumnumericcharacterspassword_Jsonclick = "" ;
      edtavSecuritypolicyminimumnumericcharacterspassword_Enabled = 1 ;
      edtavSecuritypolicyminimumlengthpassword_Jsonclick = "" ;
      edtavSecuritypolicyminimumlengthpassword_Enabled = 1 ;
      edtavSecuritypolicyminimumtimetochangepasswords_Jsonclick = "" ;
      edtavSecuritypolicyminimumtimetochangepasswords_Enabled = 1 ;
      edtavSecuritypolicyperiodchangepassword_Jsonclick = "" ;
      edtavSecuritypolicyperiodchangepassword_Enabled = 1 ;
      edtavSecuritypolicyname_Jsonclick = "" ;
      edtavSecuritypolicyname_Enabled = 1 ;
      edtavSecuritypolicyguid_Jsonclick = "" ;
      edtavSecuritypolicyguid_Enabled = 1 ;
      edtavSecuritypolicyid_Jsonclick = "" ;
      edtavSecuritypolicyid_Enabled = 1 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Dvpanel_onlysd_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_onlysd_Iconposition = "Right" ;
      Dvpanel_onlysd_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_onlysd_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_onlysd_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_onlysd_Title = httpContext.getMessage( "WWP_GAM_OnlySmartDevices", "") ;
      Dvpanel_onlysd_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_onlysd_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_onlysd_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_onlysd_Width = "100%" ;
      Dvpanel_onlyweb_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_onlyweb_Iconposition = "Right" ;
      Dvpanel_onlyweb_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_onlyweb_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_onlyweb_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_onlyweb_Title = httpContext.getMessage( "WWP_GAM_OnlyWeb", "") ;
      Dvpanel_onlyweb_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_onlyweb_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_onlyweb_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_onlyweb_Width = "100%" ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "WWP_GAM_PasswordConfigurations", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_GAM_SecurityPolicy", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "WWP_GAM_SecurityPolicy", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setName( "vSECURITYPOLICYALLOWMULTIPLECONCURRENTWEBSESSIONS" );
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.setWebtags( "" );
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.addItem("1", httpContext.getMessage( "WWP_GAM_DifferentIP", ""), (short)(0));
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.addItem("2", httpContext.getMessage( "WWP_GAM_SameIP", ""), (short)(0));
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.addItem("3", httpContext.getMessage( "WWP_GAM_Unique", ""), (short)(0));
      cmbavSecuritypolicyallowmultipleconcurrentwebsessions.addItem("4", httpContext.getMessage( "WWP_GAM_No", ""), (short)(0));
      if ( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getItemCount() > 0 )
      {
         AV10SecurityPolicyAllowMultipleConcurrentWebSessions = (short)(GXutil.lval( cmbavSecuritypolicyallowmultipleconcurrentwebsessions.getValidValue(GXutil.trim( GXutil.str( AV10SecurityPolicyAllowMultipleConcurrentWebSessions, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10SecurityPolicyAllowMultipleConcurrentWebSessions", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10SecurityPolicyAllowMultipleConcurrentWebSessions), 4, 0));
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV7Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20SecurityPolicyGUID',fld:'vSECURITYPOLICYGUID',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e123A2',iparms:[{av:'AV7Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20SecurityPolicyGUID',fld:'vSECURITYPOLICYGUID',pic:''},{av:'AV21SecurityPolicyName',fld:'vSECURITYPOLICYNAME',pic:''},{av:'AV12SecurityPolicyPeriodChangePassword',fld:'vSECURITYPOLICYPERIODCHANGEPASSWORD',pic:'ZZZ9'},{av:'AV13SecurityPolicyMinimumTimeToChangePasswords',fld:'vSECURITYPOLICYMINIMUMTIMETOCHANGEPASSWORDS',pic:'ZZZ9'},{av:'AV14SecurityPolicyMinimumLengthPassword',fld:'vSECURITYPOLICYMINIMUMLENGTHPASSWORD',pic:'Z9'},{av:'AV15SecurityPolicyMinimumNumericCharactersPassword',fld:'vSECURITYPOLICYMINIMUMNUMERICCHARACTERSPASSWORD',pic:'Z9'},{av:'AV16SecurityPolicyMinimumUpperCaseCharactersPassword',fld:'vSECURITYPOLICYMINIMUMUPPERCASECHARACTERSPASSWORD',pic:'Z9'},{av:'AV17SecurityPolicyMinimumSpecialCharactersPassword',fld:'vSECURITYPOLICYMINIMUMSPECIALCHARACTERSPASSWORD',pic:'Z9'},{av:'AV18SecurityPolicyMaximumPasswordHistoryEntries',fld:'vSECURITYPOLICYMAXIMUMPASSWORDHISTORYENTRIES',pic:'ZZZ9'},{av:'cmbavSecuritypolicyallowmultipleconcurrentwebsessions'},{av:'AV10SecurityPolicyAllowMultipleConcurrentWebSessions',fld:'vSECURITYPOLICYALLOWMULTIPLECONCURRENTWEBSESSIONS',pic:'ZZZ9'},{av:'AV11SecurityPolicyWebSessionTimeout',fld:'vSECURITYPOLICYWEBSESSIONTIMEOUT',pic:'ZZZ9'},{av:'AV9SecurityPolicyOauthTokenExpire',fld:'vSECURITYPOLICYOAUTHTOKENEXPIRE',pic:'ZZZZZ9'},{av:'AV22SecurityPolicyOauthTokenMaximumRenovations',fld:'vSECURITYPOLICYOAUTHTOKENMAXIMUMRENOVATIONS',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV19SecurityPolicyId',fld:'vSECURITYPOLICYID',pic:'ZZZZZZZZ9'}]}");
      setEventMetadata("VALIDV_SECURITYPOLICYALLOWMULTIPLECONCURRENTWEBSESSIONS","{handler:'validv_Securitypolicyallowmultipleconcurrentwebsessions',iparms:[]");
      setEventMetadata("VALIDV_SECURITYPOLICYALLOWMULTIPLECONCURRENTWEBSESSIONS",",oparms:[]}");
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
      return "gamsecuritypolicyentry_Execute";
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
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV20SecurityPolicyGUID = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV21SecurityPolicyName = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_onlyweb = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_onlysd = new com.genexus.webpanels.GXUserControl();
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      hsh = "" ;
      AV8SecurityPolicy = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicy(remoteHandle, context);
      AV6Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV5Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamsecuritypolicyentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamsecuritypolicyentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSecuritypolicyid_Enabled = 0 ;
      edtavSecuritypolicyguid_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV14SecurityPolicyMinimumLengthPassword ;
   private byte AV15SecurityPolicyMinimumNumericCharactersPassword ;
   private byte AV16SecurityPolicyMinimumUpperCaseCharactersPassword ;
   private byte AV17SecurityPolicyMinimumSpecialCharactersPassword ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV12SecurityPolicyPeriodChangePassword ;
   private short AV13SecurityPolicyMinimumTimeToChangePasswords ;
   private short AV18SecurityPolicyMaximumPasswordHistoryEntries ;
   private short AV10SecurityPolicyAllowMultipleConcurrentWebSessions ;
   private short AV11SecurityPolicyWebSessionTimeout ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int AV19SecurityPolicyId ;
   private int edtavSecuritypolicyid_Enabled ;
   private int edtavSecuritypolicyguid_Enabled ;
   private int edtavSecuritypolicyname_Enabled ;
   private int edtavSecuritypolicyperiodchangepassword_Enabled ;
   private int edtavSecuritypolicyminimumtimetochangepasswords_Enabled ;
   private int edtavSecuritypolicyminimumlengthpassword_Enabled ;
   private int edtavSecuritypolicyminimumnumericcharacterspassword_Enabled ;
   private int edtavSecuritypolicyminimumuppercasecharacterspassword_Enabled ;
   private int edtavSecuritypolicyminimumspecialcharacterspassword_Enabled ;
   private int edtavSecuritypolicymaximumpasswordhistoryentries_Enabled ;
   private int edtavSecuritypolicywebsessiontimeout_Enabled ;
   private int AV9SecurityPolicyOauthTokenExpire ;
   private int edtavSecuritypolicyoauthtokenexpire_Enabled ;
   private int AV22SecurityPolicyOauthTokenMaximumRenovations ;
   private int edtavSecuritypolicyoauthtokenmaximumrenovations_Enabled ;
   private int bttBtnenter_Visible ;
   private int AV31GXV1 ;
   private int idxLst ;
   private long wcpOAV7Id ;
   private long AV7Id ;
   private String wcpOGx_mode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV20SecurityPolicyGUID ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_onlyweb_Width ;
   private String Dvpanel_onlyweb_Cls ;
   private String Dvpanel_onlyweb_Title ;
   private String Dvpanel_onlyweb_Iconposition ;
   private String Dvpanel_onlysd_Width ;
   private String Dvpanel_onlysd_Cls ;
   private String Dvpanel_onlysd_Title ;
   private String Dvpanel_onlysd_Iconposition ;
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
   private String edtavSecuritypolicyid_Internalname ;
   private String TempTags ;
   private String edtavSecuritypolicyid_Jsonclick ;
   private String edtavSecuritypolicyguid_Internalname ;
   private String edtavSecuritypolicyguid_Jsonclick ;
   private String edtavSecuritypolicyname_Internalname ;
   private String AV21SecurityPolicyName ;
   private String edtavSecuritypolicyname_Jsonclick ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String edtavSecuritypolicyperiodchangepassword_Internalname ;
   private String edtavSecuritypolicyperiodchangepassword_Jsonclick ;
   private String edtavSecuritypolicyminimumtimetochangepasswords_Internalname ;
   private String edtavSecuritypolicyminimumtimetochangepasswords_Jsonclick ;
   private String edtavSecuritypolicyminimumlengthpassword_Internalname ;
   private String edtavSecuritypolicyminimumlengthpassword_Jsonclick ;
   private String edtavSecuritypolicyminimumnumericcharacterspassword_Internalname ;
   private String edtavSecuritypolicyminimumnumericcharacterspassword_Jsonclick ;
   private String edtavSecuritypolicyminimumuppercasecharacterspassword_Internalname ;
   private String edtavSecuritypolicyminimumuppercasecharacterspassword_Jsonclick ;
   private String edtavSecuritypolicyminimumspecialcharacterspassword_Internalname ;
   private String edtavSecuritypolicyminimumspecialcharacterspassword_Jsonclick ;
   private String edtavSecuritypolicymaximumpasswordhistoryentries_Internalname ;
   private String edtavSecuritypolicymaximumpasswordhistoryentries_Jsonclick ;
   private String Dvpanel_onlyweb_Internalname ;
   private String divOnlyweb_Internalname ;
   private String edtavSecuritypolicywebsessiontimeout_Internalname ;
   private String edtavSecuritypolicywebsessiontimeout_Jsonclick ;
   private String Dvpanel_onlysd_Internalname ;
   private String divOnlysd_Internalname ;
   private String edtavSecuritypolicyoauthtokenexpire_Internalname ;
   private String edtavSecuritypolicyoauthtokenexpire_Jsonclick ;
   private String edtavSecuritypolicyoauthtokenmaximumrenovations_Internalname ;
   private String edtavSecuritypolicyoauthtokenmaximumrenovations_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String hsh ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean Dvpanel_onlyweb_Autowidth ;
   private boolean Dvpanel_onlyweb_Autoheight ;
   private boolean Dvpanel_onlyweb_Collapsible ;
   private boolean Dvpanel_onlyweb_Collapsed ;
   private boolean Dvpanel_onlyweb_Showcollapseicon ;
   private boolean Dvpanel_onlyweb_Autoscroll ;
   private boolean Dvpanel_onlysd_Autowidth ;
   private boolean Dvpanel_onlysd_Autoheight ;
   private boolean Dvpanel_onlysd_Collapsible ;
   private boolean Dvpanel_onlysd_Collapsed ;
   private boolean Dvpanel_onlysd_Showcollapseicon ;
   private boolean Dvpanel_onlysd_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_onlyweb ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_onlysd ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavSecuritypolicyallowmultipleconcurrentwebsessions ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV6Errors ;
   private genexus.security.api.genexussecurity.SdtGAMError AV5Error ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicy AV8SecurityPolicy ;
}

final  class gamsecuritypolicyentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamsecuritypolicyentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

