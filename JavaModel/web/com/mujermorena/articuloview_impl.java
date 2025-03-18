package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class articuloview_impl extends GXDataArea
{
   public articuloview_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public articuloview_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articuloview_impl.class ));
   }

   public articuloview_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "ArticuloId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ArticuloId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ArticuloId") ;
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
            AV10ArticuloId = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ArticuloId), 11, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ArticuloId), "ZZZZZZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV8TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      pa4I2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start4I2( ) ;
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
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.articuloview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10ArticuloId,11,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"ArticuloId","TabCode"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ArticuloId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV11LoadAllTabs);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV12SelectedTabCode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vARTICULOID", GXutil.ltrim( localUtil.ntoc( AV10ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ArticuloId), "ZZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV8TabCode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABS_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabs_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABS_Class", GXutil.rtrim( Tabs_Class));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABS_Historymanagement", GXutil.booltostr( Tabs_Historymanagement));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "TABS_Activepagecontrolname", GXutil.rtrim( Tabs_Activepagecontrolname));
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         WebComp_Generalwc.componentjscripts();
      }
      if ( ! ( WebComp_Tallawc == null ) )
      {
         WebComp_Tallawc.componentjscripts();
      }
      if ( ! ( WebComp_Galeriawc == null ) )
      {
         WebComp_Galeriawc.componentjscripts();
      }
      if ( ! ( WebComp_Detallepedidoswc == null ) )
      {
         WebComp_Detallepedidoswc.componentjscripts();
      }
      if ( ! ( WebComp_Detalleinventariowc == null ) )
      {
         WebComp_Detalleinventariowc.componentjscripts();
      }
      if ( ! ( WebComp_Detalledevolucioneswc == null ) )
      {
         WebComp_Detalledevolucioneswc.componentjscripts();
      }
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
         we4I2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt4I2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.mujermorena.articuloview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10ArticuloId,11,0)),GXutil.URLEncode(GXutil.rtrim(AV8TabCode))}, new String[] {"ArticuloId","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "ArticuloView" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Articulo View", "") ;
   }

   public void wb4I0( )
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
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ViewHeaderCell CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divHeader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTabletitle_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellViewTextBlockTitle", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblViewtitle_Internalname, httpContext.getMessage( "Articulo :: ", ""), "", "", lblViewtitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellWWLink", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableviewrightitems_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ViewCellRightItem", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblWorkwithlink_Internalname, httpContext.getMessage( "Ir a Articulo", ""), lblWorkwithlink_Link, "", lblWorkwithlink_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockLink", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTabsPosition", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtableviewcontainer_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellViewTab", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabs.setProperty("PageCount", Tabs_Pagecount);
         ucTabs.setProperty("Class", Tabs_Class);
         ucTabs.setProperty("HistoryManagement", Tabs_Historymanagement);
         ucTabs.render(context, "tab", Tabs_Internalname, "TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtablegeneral_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0031"+"", GXutil.rtrim( WebComp_Generalwc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0031"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
               }
               WebComp_Generalwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTalla_title_Internalname, httpContext.getMessage( "Talla", ""), "", "", lblTalla_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Talla") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtabletalla_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0039"+"", GXutil.rtrim( WebComp_Tallawc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0039"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Tallawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldTallawc), GXutil.lower( WebComp_Tallawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
               }
               WebComp_Tallawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldTallawc), GXutil.lower( WebComp_Tallawc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGaleria_title_Internalname, httpContext.getMessage( "Galeria", ""), "", "", lblGaleria_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Galeria") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtablegaleria_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0047"+"", GXutil.rtrim( WebComp_Galeriawc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0047"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Galeriawc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGaleriawc), GXutil.lower( WebComp_Galeriawc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0047"+"");
               }
               WebComp_Galeriawc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldGaleriawc), GXutil.lower( WebComp_Galeriawc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblDetallepedidos_title_Internalname, httpContext.getMessage( "Pedidos", ""), "", "", lblDetallepedidos_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "DetallePedidos") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtabledetallepedidos_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0055"+"", GXutil.rtrim( WebComp_Detallepedidoswc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0055"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Detallepedidoswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldDetallepedidoswc), GXutil.lower( WebComp_Detallepedidoswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0055"+"");
               }
               WebComp_Detallepedidoswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldDetallepedidoswc), GXutil.lower( WebComp_Detallepedidoswc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblDetalleinventario_title_Internalname, httpContext.getMessage( "Inventario", ""), "", "", lblDetalleinventario_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "DetalleInventario") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtabledetalleinventario_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0063"+"", GXutil.rtrim( WebComp_Detalleinventariowc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0063"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Detalleinventariowc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldDetalleinventariowc), GXutil.lower( WebComp_Detalleinventariowc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0063"+"");
               }
               WebComp_Detalleinventariowc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldDetalleinventariowc), GXutil.lower( WebComp_Detalleinventariowc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblDetalledevoluciones_title_Internalname, httpContext.getMessage( "Devoluciones", ""), "", "", lblDetalledevoluciones_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ArticuloView.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "DetalleDevoluciones") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABSContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtabledetalledevoluciones_Internalname, 1, 0, "px", 0, "px", "TableViewTab", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "W0071"+"", GXutil.rtrim( WebComp_Detalledevolucioneswc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0071"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Detalledevolucioneswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldDetalledevolucioneswc), GXutil.lower( WebComp_Detalledevolucioneswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0071"+"");
               }
               WebComp_Detalledevolucioneswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldDetalledevolucioneswc), GXutil.lower( WebComp_Detalledevolucioneswc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start4I2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Articulo View", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup4I0( ) ;
   }

   public void ws4I2( )
   {
      start4I2( ) ;
      evt4I2( ) ;
   }

   public void evt4I2( )
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
                           e114I2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e124I2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                              }
                              dynload_actions( ) ;
                           }
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 31 )
                     {
                        OldGeneralwc = httpContext.cgiGet( "W0031") ;
                        if ( ( GXutil.len( OldGeneralwc) == 0 ) || ( GXutil.strcmp(OldGeneralwc, WebComp_Generalwc_Component) != 0 ) )
                        {
                           WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldGeneralwc + "_impl", remoteHandle, context);
                           WebComp_Generalwc_Component = OldGeneralwc ;
                        }
                        if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
                        {
                           WebComp_Generalwc.componentprocess("W0031", "", sEvt);
                        }
                        WebComp_Generalwc_Component = OldGeneralwc ;
                     }
                     else if ( nCmpId == 39 )
                     {
                        OldTallawc = httpContext.cgiGet( "W0039") ;
                        if ( ( GXutil.len( OldTallawc) == 0 ) || ( GXutil.strcmp(OldTallawc, WebComp_Tallawc_Component) != 0 ) )
                        {
                           WebComp_Tallawc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldTallawc + "_impl", remoteHandle, context);
                           WebComp_Tallawc_Component = OldTallawc ;
                        }
                        if ( GXutil.len( WebComp_Tallawc_Component) != 0 )
                        {
                           WebComp_Tallawc.componentprocess("W0039", "", sEvt);
                        }
                        WebComp_Tallawc_Component = OldTallawc ;
                     }
                     else if ( nCmpId == 47 )
                     {
                        OldGaleriawc = httpContext.cgiGet( "W0047") ;
                        if ( ( GXutil.len( OldGaleriawc) == 0 ) || ( GXutil.strcmp(OldGaleriawc, WebComp_Galeriawc_Component) != 0 ) )
                        {
                           WebComp_Galeriawc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldGaleriawc + "_impl", remoteHandle, context);
                           WebComp_Galeriawc_Component = OldGaleriawc ;
                        }
                        if ( GXutil.len( WebComp_Galeriawc_Component) != 0 )
                        {
                           WebComp_Galeriawc.componentprocess("W0047", "", sEvt);
                        }
                        WebComp_Galeriawc_Component = OldGaleriawc ;
                     }
                     else if ( nCmpId == 55 )
                     {
                        OldDetallepedidoswc = httpContext.cgiGet( "W0055") ;
                        if ( ( GXutil.len( OldDetallepedidoswc) == 0 ) || ( GXutil.strcmp(OldDetallepedidoswc, WebComp_Detallepedidoswc_Component) != 0 ) )
                        {
                           WebComp_Detallepedidoswc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldDetallepedidoswc + "_impl", remoteHandle, context);
                           WebComp_Detallepedidoswc_Component = OldDetallepedidoswc ;
                        }
                        if ( GXutil.len( WebComp_Detallepedidoswc_Component) != 0 )
                        {
                           WebComp_Detallepedidoswc.componentprocess("W0055", "", sEvt);
                        }
                        WebComp_Detallepedidoswc_Component = OldDetallepedidoswc ;
                     }
                     else if ( nCmpId == 63 )
                     {
                        OldDetalleinventariowc = httpContext.cgiGet( "W0063") ;
                        if ( ( GXutil.len( OldDetalleinventariowc) == 0 ) || ( GXutil.strcmp(OldDetalleinventariowc, WebComp_Detalleinventariowc_Component) != 0 ) )
                        {
                           WebComp_Detalleinventariowc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldDetalleinventariowc + "_impl", remoteHandle, context);
                           WebComp_Detalleinventariowc_Component = OldDetalleinventariowc ;
                        }
                        if ( GXutil.len( WebComp_Detalleinventariowc_Component) != 0 )
                        {
                           WebComp_Detalleinventariowc.componentprocess("W0063", "", sEvt);
                        }
                        WebComp_Detalleinventariowc_Component = OldDetalleinventariowc ;
                     }
                     else if ( nCmpId == 71 )
                     {
                        OldDetalledevolucioneswc = httpContext.cgiGet( "W0071") ;
                        if ( ( GXutil.len( OldDetalledevolucioneswc) == 0 ) || ( GXutil.strcmp(OldDetalledevolucioneswc, WebComp_Detalledevolucioneswc_Component) != 0 ) )
                        {
                           WebComp_Detalledevolucioneswc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldDetalledevolucioneswc + "_impl", remoteHandle, context);
                           WebComp_Detalledevolucioneswc_Component = OldDetalledevolucioneswc ;
                        }
                        if ( GXutil.len( WebComp_Detalledevolucioneswc_Component) != 0 )
                        {
                           WebComp_Detalledevolucioneswc.componentprocess("W0071", "", sEvt);
                        }
                        WebComp_Detalledevolucioneswc_Component = OldDetalledevolucioneswc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we4I2( )
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

   public void pa4I2( )
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
      rf4I2( ) ;
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

   public void rf4I2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               WebComp_Generalwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Tallawc_Component) != 0 )
            {
               WebComp_Tallawc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Galeriawc_Component) != 0 )
            {
               WebComp_Galeriawc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Detallepedidoswc_Component) != 0 )
            {
               WebComp_Detallepedidoswc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Detalleinventariowc_Component) != 0 )
            {
               WebComp_Detalleinventariowc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Detalledevolucioneswc_Component) != 0 )
            {
               WebComp_Detalledevolucioneswc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e124I2 ();
         wb4I0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4I2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup4I0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e114I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV10ArticuloId = localUtil.ctol( httpContext.cgiGet( "vARTICULOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV11LoadAllTabs = GXutil.strtobool( httpContext.cgiGet( "vLOADALLTABS")) ;
         AV12SelectedTabCode = httpContext.cgiGet( "vSELECTEDTABCODE") ;
         Tabs_Activepagecontrolname = httpContext.cgiGet( "TABS_Activepagecontrolname") ;
         Tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Tabs_Class = httpContext.cgiGet( "TABS_Class") ;
         Tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABS_Historymanagement")) ;
         /* Read variables values. */
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
      e114I2 ();
      if (returnInSub) return;
   }

   public void e114I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      lblWorkwithlink_Link = formatLink("com.mujermorena.articuloww", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, lblWorkwithlink_Internalname, "Link", lblWorkwithlink_Link, true);
      AV16GXLvl9 = (byte)(0) ;
      /* Using cursor H004I2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV10ArticuloId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13ArticuloId = H004I2_A13ArticuloId[0] ;
         AV16GXLvl9 = (byte)(1) ;
         Form.setCaption( httpContext.getMessage( "Articulo", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV16GXLvl9 == 0 )
      {
         Form.setCaption( httpContext.getMessage( "WWP_RecordNotFound", "") );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         AV9Exists = false ;
      }
      if ( AV9Exists )
      {
         AV12SelectedTabCode = AV8TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12SelectedTabCode", AV12SelectedTabCode);
         Tabs_Activepagecontrolname = AV12SelectedTabCode ;
         ucTabs.sendProperty(context, "", false, Tabs_Internalname, "ActivePageControlName", Tabs_Activepagecontrolname);
         /* Execute user subroutine: 'LOADTABS' */
         S112 ();
         if (returnInSub) return;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e124I2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'LOADTABS' Routine */
      returnInSub = false ;
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV12SelectedTabCode, "General") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Generalwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "ArticuloGeneral")) != 0 )
         {
            WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "com.mujermorena.articulogeneral_impl", remoteHandle, context);
            WebComp_Generalwc_Component = "ArticuloGeneral" ;
         }
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.setjustcreated();
            WebComp_Generalwc.componentprepare(new Object[] {"W0031","",Long.valueOf(AV10ArticuloId)});
            WebComp_Generalwc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0031"+"");
            WebComp_Generalwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "Talla") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Tallawc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Tallawc_Component), GXutil.lower( "ArticuloTallaWC")) != 0 )
         {
            WebComp_Tallawc = WebUtils.getWebComponent(getClass(), "com.mujermorena.articulotallawc_impl", remoteHandle, context);
            WebComp_Tallawc_Component = "ArticuloTallaWC" ;
         }
         if ( GXutil.len( WebComp_Tallawc_Component) != 0 )
         {
            WebComp_Tallawc.setjustcreated();
            WebComp_Tallawc.componentprepare(new Object[] {"W0039","",Long.valueOf(AV10ArticuloId)});
            WebComp_Tallawc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Tallawc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0039"+"");
            WebComp_Tallawc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "Galeria") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Galeriawc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Galeriawc_Component), GXutil.lower( "ArticuloGaleriaWC")) != 0 )
         {
            WebComp_Galeriawc = WebUtils.getWebComponent(getClass(), "com.mujermorena.articulogaleriawc_impl", remoteHandle, context);
            WebComp_Galeriawc_Component = "ArticuloGaleriaWC" ;
         }
         if ( GXutil.len( WebComp_Galeriawc_Component) != 0 )
         {
            WebComp_Galeriawc.setjustcreated();
            WebComp_Galeriawc.componentprepare(new Object[] {"W0047","",Long.valueOf(AV10ArticuloId)});
            WebComp_Galeriawc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Galeriawc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0047"+"");
            WebComp_Galeriawc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "DetallePedidos") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Detallepedidoswc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Detallepedidoswc_Component), GXutil.lower( "ArticuloDetallePedidosWC")) != 0 )
         {
            WebComp_Detallepedidoswc = WebUtils.getWebComponent(getClass(), "com.mujermorena.articulodetallepedidoswc_impl", remoteHandle, context);
            WebComp_Detallepedidoswc_Component = "ArticuloDetallePedidosWC" ;
         }
         if ( GXutil.len( WebComp_Detallepedidoswc_Component) != 0 )
         {
            WebComp_Detallepedidoswc.setjustcreated();
            WebComp_Detallepedidoswc.componentprepare(new Object[] {"W0055","",Long.valueOf(AV10ArticuloId)});
            WebComp_Detallepedidoswc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Detallepedidoswc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0055"+"");
            WebComp_Detallepedidoswc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "DetalleInventario") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Detalleinventariowc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Detalleinventariowc_Component), GXutil.lower( "ArticuloDetalleInventarioWC")) != 0 )
         {
            WebComp_Detalleinventariowc = WebUtils.getWebComponent(getClass(), "com.mujermorena.articulodetalleinventariowc_impl", remoteHandle, context);
            WebComp_Detalleinventariowc_Component = "ArticuloDetalleInventarioWC" ;
         }
         if ( GXutil.len( WebComp_Detalleinventariowc_Component) != 0 )
         {
            WebComp_Detalleinventariowc.setjustcreated();
            WebComp_Detalleinventariowc.componentprepare(new Object[] {"W0063","",Long.valueOf(AV10ArticuloId)});
            WebComp_Detalleinventariowc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Detalleinventariowc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0063"+"");
            WebComp_Detalleinventariowc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV12SelectedTabCode, "DetalleDevoluciones") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Detalledevolucioneswc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Detalledevolucioneswc_Component), GXutil.lower( "ArticuloDetalleDevolucionesWC")) != 0 )
         {
            WebComp_Detalledevolucioneswc = WebUtils.getWebComponent(getClass(), "com.mujermorena.articulodetalledevolucioneswc_impl", remoteHandle, context);
            WebComp_Detalledevolucioneswc_Component = "ArticuloDetalleDevolucionesWC" ;
         }
         if ( GXutil.len( WebComp_Detalledevolucioneswc_Component) != 0 )
         {
            WebComp_Detalledevolucioneswc.setjustcreated();
            WebComp_Detalledevolucioneswc.componentprepare(new Object[] {"W0071","",Long.valueOf(AV10ArticuloId)});
            WebComp_Detalledevolucioneswc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Detalledevolucioneswc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0071"+"");
            WebComp_Detalledevolucioneswc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10ArticuloId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ArticuloId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10ArticuloId), 11, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vARTICULOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ArticuloId), "ZZZZZZZZZZ9")));
      AV8TabCode = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8TabCode", AV8TabCode);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8TabCode, ""))));
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
      pa4I2( ) ;
      ws4I2( ) ;
      we4I2( ) ;
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Tallawc == null ) )
      {
         if ( GXutil.len( WebComp_Tallawc_Component) != 0 )
         {
            WebComp_Tallawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Galeriawc == null ) )
      {
         if ( GXutil.len( WebComp_Galeriawc_Component) != 0 )
         {
            WebComp_Galeriawc.componentthemes();
         }
      }
      if ( ! ( WebComp_Detallepedidoswc == null ) )
      {
         if ( GXutil.len( WebComp_Detallepedidoswc_Component) != 0 )
         {
            WebComp_Detallepedidoswc.componentthemes();
         }
      }
      if ( ! ( WebComp_Detalleinventariowc == null ) )
      {
         if ( GXutil.len( WebComp_Detalleinventariowc_Component) != 0 )
         {
            WebComp_Detalleinventariowc.componentthemes();
         }
      }
      if ( ! ( WebComp_Detalledevolucioneswc == null ) )
      {
         if ( GXutil.len( WebComp_Detalledevolucioneswc_Component) != 0 )
         {
            WebComp_Detalledevolucioneswc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111221727", true, true);
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
      httpContext.AddJavascriptSource("articuloview.js", "?202412111221727", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblViewtitle_Internalname = "VIEWTITLE" ;
      divTabletitle_Internalname = "TABLETITLE" ;
      lblWorkwithlink_Internalname = "WORKWITHLINK" ;
      divTableviewrightitems_Internalname = "TABLEVIEWRIGHTITEMS" ;
      divHeader_Internalname = "HEADER" ;
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      divUnnamedtablegeneral_Internalname = "UNNAMEDTABLEGENERAL" ;
      lblTalla_title_Internalname = "TALLA_TITLE" ;
      divUnnamedtabletalla_Internalname = "UNNAMEDTABLETALLA" ;
      lblGaleria_title_Internalname = "GALERIA_TITLE" ;
      divUnnamedtablegaleria_Internalname = "UNNAMEDTABLEGALERIA" ;
      lblDetallepedidos_title_Internalname = "DETALLEPEDIDOS_TITLE" ;
      divUnnamedtabledetallepedidos_Internalname = "UNNAMEDTABLEDETALLEPEDIDOS" ;
      lblDetalleinventario_title_Internalname = "DETALLEINVENTARIO_TITLE" ;
      divUnnamedtabledetalleinventario_Internalname = "UNNAMEDTABLEDETALLEINVENTARIO" ;
      lblDetalledevoluciones_title_Internalname = "DETALLEDEVOLUCIONES_TITLE" ;
      divUnnamedtabledetalledevoluciones_Internalname = "UNNAMEDTABLEDETALLEDEVOLUCIONES" ;
      Tabs_Internalname = "TABS" ;
      divUnnamedtableviewcontainer_Internalname = "UNNAMEDTABLEVIEWCONTAINER" ;
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
      lblWorkwithlink_Link = "" ;
      Tabs_Historymanagement = GXutil.toBoolean( -1) ;
      Tabs_Class = "ViewTab Tab" ;
      Tabs_Pagecount = 6 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Articulo View", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV10ArticuloId',fld:'vARTICULOID',pic:'ZZZZZZZZZZ9',hsh:true},{av:'AV8TabCode',fld:'vTABCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      return "articuloview_Execute";
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
      wcpOAV8TabCode = "" ;
      Tabs_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV12SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblViewtitle_Jsonclick = "" ;
      lblWorkwithlink_Jsonclick = "" ;
      ucTabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      WebComp_Generalwc_Component = "" ;
      OldGeneralwc = "" ;
      lblTalla_title_Jsonclick = "" ;
      WebComp_Tallawc_Component = "" ;
      OldTallawc = "" ;
      lblGaleria_title_Jsonclick = "" ;
      WebComp_Galeriawc_Component = "" ;
      OldGaleriawc = "" ;
      lblDetallepedidos_title_Jsonclick = "" ;
      WebComp_Detallepedidoswc_Component = "" ;
      OldDetallepedidoswc = "" ;
      lblDetalleinventario_title_Jsonclick = "" ;
      WebComp_Detalleinventariowc_Component = "" ;
      OldDetalleinventariowc = "" ;
      lblDetalledevoluciones_title_Jsonclick = "" ;
      WebComp_Detalledevolucioneswc_Component = "" ;
      OldDetalledevolucioneswc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      H004I2_A13ArticuloId = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articuloview__default(),
         new Object[] {
             new Object[] {
            H004I2_A13ArticuloId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Tallawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Galeriawc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Detallepedidoswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Detalleinventariowc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Detalledevolucioneswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV16GXLvl9 ;
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Tabs_Pagecount ;
   private int idxLst ;
   private long wcpOAV10ArticuloId ;
   private long AV10ArticuloId ;
   private long A13ArticuloId ;
   private String wcpOAV8TabCode ;
   private String Tabs_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV8TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV12SelectedTabCode ;
   private String Tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divHeader_Internalname ;
   private String divTabletitle_Internalname ;
   private String lblViewtitle_Internalname ;
   private String lblViewtitle_Jsonclick ;
   private String divTableviewrightitems_Internalname ;
   private String lblWorkwithlink_Internalname ;
   private String lblWorkwithlink_Link ;
   private String lblWorkwithlink_Jsonclick ;
   private String divUnnamedtableviewcontainer_Internalname ;
   private String Tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtablegeneral_Internalname ;
   private String WebComp_Generalwc_Component ;
   private String OldGeneralwc ;
   private String lblTalla_title_Internalname ;
   private String lblTalla_title_Jsonclick ;
   private String divUnnamedtabletalla_Internalname ;
   private String WebComp_Tallawc_Component ;
   private String OldTallawc ;
   private String lblGaleria_title_Internalname ;
   private String lblGaleria_title_Jsonclick ;
   private String divUnnamedtablegaleria_Internalname ;
   private String WebComp_Galeriawc_Component ;
   private String OldGaleriawc ;
   private String lblDetallepedidos_title_Internalname ;
   private String lblDetallepedidos_title_Jsonclick ;
   private String divUnnamedtabledetallepedidos_Internalname ;
   private String WebComp_Detallepedidoswc_Component ;
   private String OldDetallepedidoswc ;
   private String lblDetalleinventario_title_Internalname ;
   private String lblDetalleinventario_title_Jsonclick ;
   private String divUnnamedtabledetalleinventario_Internalname ;
   private String WebComp_Detalleinventariowc_Component ;
   private String OldDetalleinventariowc ;
   private String lblDetalledevoluciones_title_Internalname ;
   private String lblDetalledevoluciones_title_Jsonclick ;
   private String divUnnamedtabledetalledevoluciones_Internalname ;
   private String WebComp_Detalledevolucioneswc_Component ;
   private String OldDetalledevolucioneswc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV11LoadAllTabs ;
   private boolean Tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV9Exists ;
   private boolean bDynCreated_Generalwc ;
   private boolean bDynCreated_Tallawc ;
   private boolean bDynCreated_Galeriawc ;
   private boolean bDynCreated_Detallepedidoswc ;
   private boolean bDynCreated_Detalleinventariowc ;
   private boolean bDynCreated_Detalledevolucioneswc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private GXWebComponent WebComp_Tallawc ;
   private GXWebComponent WebComp_Galeriawc ;
   private GXWebComponent WebComp_Detallepedidoswc ;
   private GXWebComponent WebComp_Detalleinventariowc ;
   private GXWebComponent WebComp_Detalledevolucioneswc ;
   private com.genexus.webpanels.GXUserControl ucTabs ;
   private IDataStoreProvider pr_default ;
   private long[] H004I2_A13ArticuloId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class articuloview__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004I2", "SELECT [ArticuloId] FROM [Articulo] WHERE [ArticuloId] = ? ORDER BY [ArticuloId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

