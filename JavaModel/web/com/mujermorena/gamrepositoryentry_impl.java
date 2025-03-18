package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamrepositoryentry_impl extends GXDataArea
{
   public gamrepositoryentry_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamrepositoryentry_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamrepositoryentry_impl.class ));
   }

   public gamrepositoryentry_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkavUsecurrentrepositorasmasterauthentication = UIFactory.getCheckbox(this);
      cmbavGeneratesessionstatistics = new HTMLChoice();
      chkavAllowoauthaccess = UIFactory.getCheckbox(this);
      chkavCanregisterusers = UIFactory.getCheckbox(this);
      chkavGiveanonymoussession = UIFactory.getCheckbox(this);
      chkavIsgamadminaccessrepository = UIFactory.getCheckbox(this);
      chkavCreategamapplication = UIFactory.getCheckbox(this);
      cmbavCopyfromrepositoryid = new HTMLChoice();
      chkavCopyroles = UIFactory.getCheckbox(this);
      chkavCopysecuritypolicies = UIFactory.getCheckbox(this);
      chkavCopyapplication = UIFactory.getCheckbox(this);
      chkavCopyapplicationrolepermissions = UIFactory.getCheckbox(this);
      chkavUpdateconnectionfile = UIFactory.getCheckbox(this);
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
               AV30Id = (int)(GXutil.lval( httpContext.GetPar( "Id"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV30Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30Id), 9, 0));
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30Id), "ZZZZZZZZ9")));
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
      pa352( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start352( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamrepositoryentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV30Id,9,0))}, new String[] {"Gx_mode","Id"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30Id), "ZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV30Id, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30Id), "ZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
         we352( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt352( ) ;
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
      return formatLink("com.mujermorena.gamrepositoryentry", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV30Id,9,0))}, new String[] {"Gx_mode","Id"})  ;
   }

   public String getPgmname( )
   {
      return "GAMRepositoryEntry" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Repository ", "") ;
   }

   public void wb350( )
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
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "WWP_GAM_General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divGuid_cell_Internalname, 1, 0, "px", 0, "px", divGuid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavGuid_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGuid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGuid_Internalname, httpContext.getMessage( "WWP_GAM_GUID", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGuid_Internalname, GXutil.rtrim( AV29GUID), GXutil.rtrim( localUtil.format( AV29GUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGuid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavGuid_Visible, edtavGuid_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMGUID", "left", true, "", "HLP_GAMRepositoryEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV33Name), GXutil.rtrim( localUtil.format( AV33Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavDescription_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavDescription_Internalname, httpContext.getMessage( "WWP_GAM_Description", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDescription_Internalname, GXutil.rtrim( AV21Description), GXutil.rtrim( localUtil.format( AV21Description, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDescription_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDescription_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUsecurrentrepositorasmasterauthentication_cell_Internalname, 1, 0, "px", 0, "px", divUsecurrentrepositorasmasterauthentication_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavUsecurrentrepositorasmasterauthentication.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUsecurrentrepositorasmasterauthentication.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUsecurrentrepositorasmasterauthentication.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUsecurrentrepositorasmasterauthentication.getInternalname(), GXutil.booltostr( AV42UseCurrentRepositorAsMasterAuthentication), "", " ", chkavUsecurrentrepositorasmasterauthentication.getVisible(), chkavUsecurrentrepositorasmasterauthentication.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_UseCurrentRepositoryAsAuthenticationMaster", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,40);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divNamespace_cell_Internalname, 1, 0, "px", 0, "px", divNamespace_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavNamespace_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavNamespace_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavNamespace_Internalname, httpContext.getMessage( "WWP_GAM_Namespace", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavNamespace_Internalname, GXutil.rtrim( AV34Namespace), GXutil.rtrim( localUtil.format( AV34Namespace, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNamespace_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavNamespace_Visible, edtavNamespace_Enabled, 1, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMRepositoryNameSpace", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavGeneratesessionstatistics.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavGeneratesessionstatistics.getInternalname(), httpContext.getMessage( "WWP_GAM_Generatesessionstatistics", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavGeneratesessionstatistics, cmbavGeneratesessionstatistics.getInternalname(), GXutil.rtrim( AV27GenerateSessionStatistics), 1, cmbavGeneratesessionstatistics.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavGeneratesessionstatistics.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "", true, (byte)(0), "HLP_GAMRepositoryEntry.htm");
         cmbavGeneratesessionstatistics.setValue( GXutil.rtrim( AV27GenerateSessionStatistics) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGeneratesessionstatistics.getInternalname(), "Values", cmbavGeneratesessionstatistics.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAllowoauthaccess.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAllowoauthaccess.getInternalname(), GXutil.booltostr( AV8AllowOauthAccess), "", "", 1, chkavAllowoauthaccess.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_AllowOauthAccess", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(55, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,55);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCanregisterusers.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCanregisterusers.getInternalname(), GXutil.booltostr( AV45CanRegisterUsers), "", "", 1, chkavCanregisterusers.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CanRegisterUsers", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(60, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,60);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavGiveanonymoussession.getInternalname()+"\"", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavGiveanonymoussession.getInternalname(), GXutil.booltostr( AV28GiveAnonymousSession), "", "", 1, chkavGiveanonymoussession.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GiveAnonymousSession", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(65, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,65);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTbluserssettings_Internalname, divTbluserssettings_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConnectionusername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConnectionusername_Internalname, httpContext.getMessage( "WWP_GAM_ConnectionUserName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConnectionusername_Internalname, GXutil.rtrim( AV12ConnectionUserName), GXutil.rtrim( localUtil.format( AV12ConnectionUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConnectionusername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavConnectionusername_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMConnectionUser", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConnectionuserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConnectionuserpassword_Internalname, httpContext.getMessage( "WWP_GAM_ConnectionUserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConnectionuserpassword_Internalname, GXutil.rtrim( AV13ConnectionUserPassword), GXutil.rtrim( localUtil.format( AV13ConnectionUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConnectionuserpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavConnectionuserpassword_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConfconnectionuserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConfconnectionuserpassword_Internalname, httpContext.getMessage( "WWP_GAM_ConfirmConnectionUserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConfconnectionuserpassword_Internalname, GXutil.rtrim( AV11ConfConnectionUserPassword), GXutil.rtrim( localUtil.format( AV11ConfConnectionUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConfconnectionuserpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavConfconnectionuserpassword_Enabled, 0, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthenticationmasterauthtypename_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthenticationmasterauthtypename_Internalname, httpContext.getMessage( "WWP_GAM_AuthenticationTypeNameInCurrentTenant", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthenticationmasterauthtypename_Internalname, GXutil.rtrim( AV9AuthenticationMasterAuthTypeName), GXutil.rtrim( localUtil.format( AV9AuthenticationMasterAuthTypeName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthenticationmasterauthtypename_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAuthenticationmasterauthtypename_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMAuthenticationTypeName", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAdministratorusername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAdministratorusername_Internalname, edtavAdministratorusername_Caption, " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAdministratorusername_Internalname, GXutil.rtrim( AV6AdministratorUserName), GXutil.rtrim( localUtil.format( AV6AdministratorUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAdministratorusername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavAdministratorusername_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMConnectionUser", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavAdministratoruserpassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAdministratoruserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAdministratoruserpassword_Internalname, httpContext.getMessage( "WWP_GAM_AdministratorUserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAdministratoruserpassword_Internalname, GXutil.rtrim( AV7AdministratorUserPassword), GXutil.rtrim( localUtil.format( AV7AdministratorUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAdministratoruserpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavAdministratoruserpassword_Visible, edtavAdministratoruserpassword_Enabled, 1, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavConfadministratoruserpassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavConfadministratoruserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavConfadministratoruserpassword_Internalname, httpContext.getMessage( "WWP_GAM_ConfirmAdministratorUserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavConfadministratoruserpassword_Internalname, GXutil.rtrim( AV10ConfAdministratorUserPassword), GXutil.rtrim( localUtil.format( AV10ConfAdministratorUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConfadministratoruserpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavConfadministratoruserpassword_Visible, edtavConfadministratoruserpassword_Enabled, 0, "text", "", 80, "chr", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMRepositoryEntry.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIsgamadminaccessrepository.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIsgamadminaccessrepository.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIsgamadminaccessrepository.getInternalname(), GXutil.booltostr( AV31isGAMAdminAccessRepository), "", " ", 1, chkavIsgamadminaccessrepository.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_IsCurrentUserAdminOfNewRepository", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(108, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,108);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCreategamapplication.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavCreategamapplication.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCreategamapplication.getInternalname(), GXutil.booltostr( AV20CreateGAMApplication), "", " ", 1, chkavCreategamapplication.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CreateGAMBackendApplication", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(113, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,113);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblCopyrepdata_title_Internalname, httpContext.getMessage( "WWP_GAM_CopyRepositoryData", ""), "", "", lblCopyrepdata_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryEntry.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "CopyRepData") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavCopyfromrepositoryid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavCopyfromrepositoryid.getInternalname(), httpContext.getMessage( "WWP_GAM_CopyFromRepositoryId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCopyfromrepositoryid, cmbavCopyfromrepositoryid.getInternalname(), GXutil.trim( GXutil.str( AV17CopyFromRepositoryId, 9, 0)), 1, cmbavCopyfromrepositoryid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavCopyfromrepositoryid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,123);\"", "", true, (byte)(0), "HLP_GAMRepositoryEntry.htm");
         cmbavCopyfromrepositoryid.setValue( GXutil.trim( GXutil.str( AV17CopyFromRepositoryId, 9, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCopyfromrepositoryid.getInternalname(), "Values", cmbavCopyfromrepositoryid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCopyroles.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavCopyroles.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCopyroles.getInternalname(), GXutil.booltostr( AV18CopyRoles), "", " ", 1, chkavCopyroles.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CopyRoles", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,128);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAdministratorroleid_cell_Internalname, 1, 0, "px", 0, "px", divAdministratorroleid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavAdministratorroleid_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAdministratorroleid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAdministratorroleid_Internalname, httpContext.getMessage( "WWP_GAM_AdministratorRoleId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAdministratorroleid_Internalname, GXutil.ltrim( localUtil.ntoc( AV5AdministratorRoleId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavAdministratorroleid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV5AdministratorRoleId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV5AdministratorRoleId), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,133);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAdministratorroleid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavAdministratorroleid_Visible, edtavAdministratorroleid_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMKeyNumLong", "right", false, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCopysecuritypolicies.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavCopysecuritypolicies.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCopysecuritypolicies.getInternalname(), GXutil.booltostr( AV19CopySecurityPolicies), "", " ", 1, chkavCopysecuritypolicies.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CopySecurityPolicies", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(138, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,138);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCopyapplication.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavCopyapplication.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCopyapplication.getInternalname(), GXutil.booltostr( AV14CopyApplication), "", " ", 1, chkavCopyapplication.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CopyApplicationMenusAndPermissions", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,143);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divCopyfromapplicationid_cell_Internalname, 1, 0, "px", 0, "px", divCopyfromapplicationid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavCopyfromapplicationid_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavCopyfromapplicationid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavCopyfromapplicationid_Internalname, httpContext.getMessage( "WWP_GAM_CopyFromAppId", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 148,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavCopyfromapplicationid_Internalname, GXutil.ltrim( localUtil.ntoc( AV16CopyFromApplicationId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavCopyfromapplicationid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV16CopyFromApplicationId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV16CopyFromApplicationId), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,148);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCopyfromapplicationid_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavCopyfromapplicationid_Visible, edtavCopyfromapplicationid_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMKeyNumLong", "right", false, "", "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCopyapplicationrolepermissions.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavCopyapplicationrolepermissions.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCopyapplicationrolepermissions.getInternalname(), GXutil.booltostr( AV15CopyApplicationRolePermissions), "", " ", 1, chkavCopyapplicationrolepermissions.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_CopyRolesPermissions", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,153);\"");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRepositoryEntry.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRepositoryEntry.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUpdateconnectionfile.getInternalname(), GXutil.booltostr( AV41UpdateConnectionFile), "", "", chkavUpdateconnectionfile.getVisible(), 1, "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(164, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,164);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start352( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Repository ", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup350( ) ;
   }

   public void ws352( )
   {
      start352( ) ;
      evt352( ) ;
   }

   public void evt352( )
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
                           e11352 ();
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
                                 e12352 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VUSECURRENTREPOSITORASMASTERAUTHENTICATION.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13352 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e14352 ();
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

   public void we352( )
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

   public void pa352( )
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
      AV42UseCurrentRepositorAsMasterAuthentication = GXutil.strtobool( GXutil.booltostr( AV42UseCurrentRepositorAsMasterAuthentication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42UseCurrentRepositorAsMasterAuthentication", AV42UseCurrentRepositorAsMasterAuthentication);
      if ( cmbavGeneratesessionstatistics.getItemCount() > 0 )
      {
         AV27GenerateSessionStatistics = cmbavGeneratesessionstatistics.getValidValue(AV27GenerateSessionStatistics) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GenerateSessionStatistics", AV27GenerateSessionStatistics);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavGeneratesessionstatistics.setValue( GXutil.rtrim( AV27GenerateSessionStatistics) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGeneratesessionstatistics.getInternalname(), "Values", cmbavGeneratesessionstatistics.ToJavascriptSource(), true);
      }
      AV8AllowOauthAccess = GXutil.strtobool( GXutil.booltostr( AV8AllowOauthAccess)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8AllowOauthAccess", AV8AllowOauthAccess);
      AV45CanRegisterUsers = GXutil.strtobool( GXutil.booltostr( AV45CanRegisterUsers)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45CanRegisterUsers", AV45CanRegisterUsers);
      AV28GiveAnonymousSession = GXutil.strtobool( GXutil.booltostr( AV28GiveAnonymousSession)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GiveAnonymousSession", AV28GiveAnonymousSession);
      AV31isGAMAdminAccessRepository = GXutil.strtobool( GXutil.booltostr( AV31isGAMAdminAccessRepository)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31isGAMAdminAccessRepository", AV31isGAMAdminAccessRepository);
      AV20CreateGAMApplication = GXutil.strtobool( GXutil.booltostr( AV20CreateGAMApplication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20CreateGAMApplication", AV20CreateGAMApplication);
      if ( cmbavCopyfromrepositoryid.getItemCount() > 0 )
      {
         AV17CopyFromRepositoryId = (int)(GXutil.lval( cmbavCopyfromrepositoryid.getValidValue(GXutil.trim( GXutil.str( AV17CopyFromRepositoryId, 9, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17CopyFromRepositoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17CopyFromRepositoryId), 9, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCopyfromrepositoryid.setValue( GXutil.trim( GXutil.str( AV17CopyFromRepositoryId, 9, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCopyfromrepositoryid.getInternalname(), "Values", cmbavCopyfromrepositoryid.ToJavascriptSource(), true);
      }
      AV18CopyRoles = GXutil.strtobool( GXutil.booltostr( AV18CopyRoles)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18CopyRoles", AV18CopyRoles);
      AV19CopySecurityPolicies = GXutil.strtobool( GXutil.booltostr( AV19CopySecurityPolicies)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19CopySecurityPolicies", AV19CopySecurityPolicies);
      AV14CopyApplication = GXutil.strtobool( GXutil.booltostr( AV14CopyApplication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14CopyApplication", AV14CopyApplication);
      AV15CopyApplicationRolePermissions = GXutil.strtobool( GXutil.booltostr( AV15CopyApplicationRolePermissions)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15CopyApplicationRolePermissions", AV15CopyApplicationRolePermissions);
      AV41UpdateConnectionFile = GXutil.strtobool( GXutil.booltostr( AV41UpdateConnectionFile)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41UpdateConnectionFile", AV41UpdateConnectionFile);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf352( ) ;
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

   public void rf352( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e14352 ();
         wb350( ) ;
      }
   }

   public void send_integrity_lvl_hashes352( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV30Id, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30Id), "ZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup350( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11352 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Gx_mode = httpContext.cgiGet( "vMODE") ;
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         /* Read variables values. */
         AV29GUID = httpContext.cgiGet( edtavGuid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29GUID", AV29GUID);
         AV33Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33Name", AV33Name);
         AV21Description = httpContext.cgiGet( edtavDescription_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Description", AV21Description);
         AV42UseCurrentRepositorAsMasterAuthentication = GXutil.strtobool( httpContext.cgiGet( chkavUsecurrentrepositorasmasterauthentication.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42UseCurrentRepositorAsMasterAuthentication", AV42UseCurrentRepositorAsMasterAuthentication);
         AV34Namespace = httpContext.cgiGet( edtavNamespace_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34Namespace", AV34Namespace);
         cmbavGeneratesessionstatistics.setValue( httpContext.cgiGet( cmbavGeneratesessionstatistics.getInternalname()) );
         AV27GenerateSessionStatistics = httpContext.cgiGet( cmbavGeneratesessionstatistics.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GenerateSessionStatistics", AV27GenerateSessionStatistics);
         AV8AllowOauthAccess = GXutil.strtobool( httpContext.cgiGet( chkavAllowoauthaccess.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8AllowOauthAccess", AV8AllowOauthAccess);
         AV45CanRegisterUsers = GXutil.strtobool( httpContext.cgiGet( chkavCanregisterusers.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45CanRegisterUsers", AV45CanRegisterUsers);
         AV28GiveAnonymousSession = GXutil.strtobool( httpContext.cgiGet( chkavGiveanonymoussession.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28GiveAnonymousSession", AV28GiveAnonymousSession);
         AV12ConnectionUserName = httpContext.cgiGet( edtavConnectionusername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12ConnectionUserName", AV12ConnectionUserName);
         AV13ConnectionUserPassword = httpContext.cgiGet( edtavConnectionuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13ConnectionUserPassword", AV13ConnectionUserPassword);
         AV11ConfConnectionUserPassword = httpContext.cgiGet( edtavConfconnectionuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11ConfConnectionUserPassword", AV11ConfConnectionUserPassword);
         AV9AuthenticationMasterAuthTypeName = httpContext.cgiGet( edtavAuthenticationmasterauthtypename_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9AuthenticationMasterAuthTypeName", AV9AuthenticationMasterAuthTypeName);
         AV6AdministratorUserName = httpContext.cgiGet( edtavAdministratorusername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6AdministratorUserName", AV6AdministratorUserName);
         AV7AdministratorUserPassword = httpContext.cgiGet( edtavAdministratoruserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AdministratorUserPassword", AV7AdministratorUserPassword);
         AV10ConfAdministratorUserPassword = httpContext.cgiGet( edtavConfadministratoruserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ConfAdministratorUserPassword", AV10ConfAdministratorUserPassword);
         AV31isGAMAdminAccessRepository = GXutil.strtobool( httpContext.cgiGet( chkavIsgamadminaccessrepository.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31isGAMAdminAccessRepository", AV31isGAMAdminAccessRepository);
         AV20CreateGAMApplication = GXutil.strtobool( httpContext.cgiGet( chkavCreategamapplication.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CreateGAMApplication", AV20CreateGAMApplication);
         cmbavCopyfromrepositoryid.setValue( httpContext.cgiGet( cmbavCopyfromrepositoryid.getInternalname()) );
         AV17CopyFromRepositoryId = (int)(GXutil.lval( httpContext.cgiGet( cmbavCopyfromrepositoryid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17CopyFromRepositoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17CopyFromRepositoryId), 9, 0));
         AV18CopyRoles = GXutil.strtobool( httpContext.cgiGet( chkavCopyroles.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18CopyRoles", AV18CopyRoles);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavAdministratorroleid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavAdministratorroleid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vADMINISTRATORROLEID");
            GX_FocusControl = edtavAdministratorroleid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV5AdministratorRoleId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5AdministratorRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5AdministratorRoleId), 12, 0));
         }
         else
         {
            AV5AdministratorRoleId = localUtil.ctol( httpContext.cgiGet( edtavAdministratorroleid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV5AdministratorRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5AdministratorRoleId), 12, 0));
         }
         AV19CopySecurityPolicies = GXutil.strtobool( httpContext.cgiGet( chkavCopysecuritypolicies.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19CopySecurityPolicies", AV19CopySecurityPolicies);
         AV14CopyApplication = GXutil.strtobool( httpContext.cgiGet( chkavCopyapplication.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14CopyApplication", AV14CopyApplication);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCopyfromapplicationid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCopyfromapplicationid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCOPYFROMAPPLICATIONID");
            GX_FocusControl = edtavCopyfromapplicationid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16CopyFromApplicationId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16CopyFromApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CopyFromApplicationId), 12, 0));
         }
         else
         {
            AV16CopyFromApplicationId = localUtil.ctol( httpContext.cgiGet( edtavCopyfromapplicationid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16CopyFromApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CopyFromApplicationId), 12, 0));
         }
         AV15CopyApplicationRolePermissions = GXutil.strtobool( httpContext.cgiGet( chkavCopyapplicationrolepermissions.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15CopyApplicationRolePermissions", AV15CopyApplicationRolePermissions);
         AV41UpdateConnectionFile = GXutil.strtobool( httpContext.cgiGet( chkavUpdateconnectionfile.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41UpdateConnectionFile", AV41UpdateConnectionFile);
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
      e11352 ();
      if (returnInSub) return;
   }

   public void e11352( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         AV37Repository.load(AV30Id);
         if ( AV37Repository.success() )
         {
            AV29GUID = AV37Repository.getgxTv_SdtGAMRepository_Guid() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29GUID", AV29GUID);
            AV33Name = AV37Repository.getgxTv_SdtGAMRepository_Name() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV33Name", AV33Name);
            AV34Namespace = AV37Repository.getgxTv_SdtGAMRepository_Namespace() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV34Namespace", AV34Namespace);
            AV21Description = AV37Repository.getgxTv_SdtGAMRepository_Description() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21Description", AV21Description);
            AV27GenerateSessionStatistics = AV37Repository.getgxTv_SdtGAMRepository_Generatesessionstatistics() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27GenerateSessionStatistics", AV27GenerateSessionStatistics);
            edtavGuid_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
            edtavName_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavName_Enabled), 5, 0), true);
            edtavNamespace_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Enabled), 5, 0), true);
            edtavDescription_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDescription_Enabled), 5, 0), true);
            edtavAdministratorusername_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavAdministratorusername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdministratorusername_Enabled), 5, 0), true);
            edtavAdministratoruserpassword_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavAdministratoruserpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdministratoruserpassword_Enabled), 5, 0), true);
            cmbavGeneratesessionstatistics.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbavGeneratesessionstatistics.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavGeneratesessionstatistics.getEnabled(), 5, 0), true);
            edtavConnectionusername_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavConnectionusername_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionusername_Enabled), 5, 0), true);
            edtavConnectionuserpassword_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavConnectionuserpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConnectionuserpassword_Enabled), 5, 0), true);
            divTbluserssettings_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, divTbluserssettings_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTbluserssettings_Visible), 5, 0), true);
            chkavUpdateconnectionfile.setVisible( 0 );
            httpContext.ajax_rsp_assign_prop("", false, chkavUpdateconnectionfile.getInternalname(), "Visible", GXutil.ltrimstr( chkavUpdateconnectionfile.getVisible(), 5, 0), true);
            bttBtnenter_Caption = httpContext.getMessage( "WWP_GAM_Delete", "") ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
         }
         else
         {
            AV23Errors = AV37Repository.geterrors() ;
            /* Execute user subroutine: 'DISPLAYERRORS' */
            S112 ();
            if (returnInSub) return;
         }
      }
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         AV27GenerateSessionStatistics = "Minimum" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GenerateSessionStatistics", AV27GenerateSessionStatistics);
         AV20CreateGAMApplication = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20CreateGAMApplication", AV20CreateGAMApplication);
         AV41UpdateConnectionFile = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41UpdateConnectionFile", AV41UpdateConnectionFile);
         GXv_objcol_SdtGAMError1[0] = AV23Errors ;
         AV36Repositories = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getallrepositories(AV39RepositoryFilter, GXv_objcol_SdtGAMError1) ;
         AV23Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV23Errors.size() == 0 )
         {
            AV49GXV1 = 1 ;
            while ( AV49GXV1 <= AV36Repositories.size() )
            {
               AV35Repo = (genexus.security.api.genexussecurity.SdtGAMRepository)((genexus.security.api.genexussecurity.SdtGAMRepository)AV36Repositories.elementAt(-1+AV49GXV1));
               cmbavCopyfromrepositoryid.addItem("0", httpContext.getMessage( "WWP_GAM_NoCopying", ""), (short)(0));
               cmbavCopyfromrepositoryid.addItem(GXutil.trim( GXutil.str( AV35Repo.getgxTv_SdtGAMRepository_Id(), 9, 0)), GXutil.str( AV35Repo.getgxTv_SdtGAMRepository_Id(), 9, 0)+" - "+GXutil.trim( AV35Repo.getgxTv_SdtGAMRepository_Name()), (short)(0));
               AV49GXV1 = (int)(AV49GXV1+1) ;
            }
         }
         else
         {
            /* Execute user subroutine: 'DISPLAYERRORS' */
            S112 ();
            if (returnInSub) return;
         }
         AV17CopyFromRepositoryId = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17CopyFromRepositoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17CopyFromRepositoryId), 9, 0));
         AV18CopyRoles = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18CopyRoles", AV18CopyRoles);
         AV5AdministratorRoleId = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AdministratorRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5AdministratorRoleId), 12, 0));
         AV19CopySecurityPolicies = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19CopySecurityPolicies", AV19CopySecurityPolicies);
         AV14CopyApplication = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14CopyApplication", AV14CopyApplication);
         AV16CopyFromApplicationId = 2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16CopyFromApplicationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16CopyFromApplicationId), 12, 0));
         AV15CopyApplicationRolePermissions = true ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15CopyApplicationRolePermissions", AV15CopyApplicationRolePermissions);
      }
      else
      {
         this.executeUsercontrolMethod("", false, "GXUITABSPANEL_TABSContainer", "HideTab", "", new Object[] {Integer.valueOf(2)});
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      chkavUpdateconnectionfile.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkavUpdateconnectionfile.getInternalname(), "Visible", GXutil.ltrimstr( chkavUpdateconnectionfile.getVisible(), 5, 0), true);
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( AV15CopyApplicationRolePermissions || AV18CopyRoles || ! AV14CopyApplication ) )
      {
         edtavAdministratorroleid_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAdministratorroleid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdministratorroleid_Visible), 5, 0), true);
         divAdministratorroleid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divAdministratorroleid_cell_Internalname, "Class", divAdministratorroleid_cell_Class, true);
      }
      else
      {
         edtavAdministratorroleid_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAdministratorroleid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdministratorroleid_Visible), 5, 0), true);
         divAdministratorroleid_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divAdministratorroleid_cell_Internalname, "Class", divAdministratorroleid_cell_Class, true);
      }
      if ( ! ( AV15CopyApplicationRolePermissions || AV18CopyRoles || ! AV14CopyApplication ) )
      {
         edtavCopyfromapplicationid_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCopyfromapplicationid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCopyfromapplicationid_Visible), 5, 0), true);
         divCopyfromapplicationid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divCopyfromapplicationid_cell_Internalname, "Class", divCopyfromapplicationid_cell_Class, true);
      }
      else
      {
         edtavCopyfromapplicationid_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavCopyfromapplicationid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCopyfromapplicationid_Visible), 5, 0), true);
         divCopyfromapplicationid_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divCopyfromapplicationid_cell_Internalname, "Class", divCopyfromapplicationid_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) ) )
      {
         edtavGuid_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Visible), 5, 0), true);
         divGuid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divGuid_cell_Internalname, "Class", divGuid_cell_Class, true);
      }
      else
      {
         edtavGuid_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Visible), 5, 0), true);
         divGuid_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divGuid_cell_Internalname, "Class", divGuid_cell_Class, true);
      }
      if ( ! ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) && AV42UseCurrentRepositorAsMasterAuthentication ) )
      {
         chkavUsecurrentrepositorasmasterauthentication.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavUsecurrentrepositorasmasterauthentication.getInternalname(), "Visible", GXutil.ltrimstr( chkavUsecurrentrepositorasmasterauthentication.getVisible(), 5, 0), true);
         divUsecurrentrepositorasmasterauthentication_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divUsecurrentrepositorasmasterauthentication_cell_Internalname, "Class", divUsecurrentrepositorasmasterauthentication_cell_Class, true);
      }
      else
      {
         chkavUsecurrentrepositorasmasterauthentication.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavUsecurrentrepositorasmasterauthentication.getInternalname(), "Visible", GXutil.ltrimstr( chkavUsecurrentrepositorasmasterauthentication.getVisible(), 5, 0), true);
         divUsecurrentrepositorasmasterauthentication_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divUsecurrentrepositorasmasterauthentication_cell_Internalname, "Class", divUsecurrentrepositorasmasterauthentication_cell_Class, true);
      }
      if ( ! ( ! AV42UseCurrentRepositorAsMasterAuthentication ) )
      {
         edtavNamespace_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Visible), 5, 0), true);
         divNamespace_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divNamespace_cell_Internalname, "Class", divNamespace_cell_Class, true);
      }
      else
      {
         edtavNamespace_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Visible), 5, 0), true);
         divNamespace_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divNamespace_cell_Internalname, "Class", divNamespace_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e12352 ();
      if (returnInSub) return;
   }

   public void e12352( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV37Repository.load(AV30Id);
      AV32isOK = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         if ( GXutil.strcmp(GXutil.trim( AV7AdministratorUserPassword), GXutil.trim( AV10ConfAdministratorUserPassword)) != 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_GAM_AdminPasswordConfNotMatch", ""));
            AV32isOK = false ;
         }
         if ( GXutil.strcmp(GXutil.trim( AV13ConnectionUserPassword), GXutil.trim( AV11ConfConnectionUserPassword)) != 0 )
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_GAM_ConnectionPasswordConfNotMatch", ""));
            AV32isOK = false ;
         }
      }
      if ( AV32isOK )
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            AV29GUID = java.util.UUID.randomUUID( ).toString() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29GUID", AV29GUID);
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Guid( AV29GUID );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Name( AV33Name );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Namespace( AV34Namespace );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Description( AV21Description );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Administratorusername( AV6AdministratorUserName );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Administratoruserpassword( AV7AdministratorUserPassword );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Allowoauthaccess( AV8AllowOauthAccess );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Connectionusername( AV12ConnectionUserName );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Connectionuserpassword( AV13ConnectionUserPassword );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Generatesessionstatistics( AV27GenerateSessionStatistics );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Giveanonymoussession( true );
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Allowoauthaccess( true );
            if ( AV42UseCurrentRepositorAsMasterAuthentication )
            {
               AV25GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Authenticationmasterrepositoryid( AV25GAMRepository.getgxTv_SdtGAMRepository_Id() );
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Authenticationmasterauthtypename( AV9AuthenticationMasterAuthTypeName );
            }
            AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Creategamapplication( AV20CreateGAMApplication );
            if ( ! (0==AV17CopyFromRepositoryId) )
            {
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Copyfromrepositoryid( AV17CopyFromRepositoryId );
               if ( AV18CopyRoles )
               {
                  AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Copyroles( AV18CopyRoles );
                  AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Administratorroleid( AV5AdministratorRoleId );
               }
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Copysecuritypolicies( AV19CopySecurityPolicies );
            }
            if ( AV14CopyApplication && ! (0==AV16CopyFromApplicationId) )
            {
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Copyapplication( AV14CopyApplication );
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Copyfromapplicationid( AV16CopyFromApplicationId );
               AV38RepositoryCreate.setgxTv_SdtGAMRepositoryCreate_Copyapplicationrolepermissions( AV15CopyApplicationRolePermissions );
            }
            GXv_objcol_SdtGAMError1[0] = AV23Errors ;
            AV32isOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).createrepository(AV38RepositoryCreate, AV41UpdateConnectionFile, GXv_objcol_SdtGAMError1) ;
            AV23Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( AV32isOK )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamrepositoryentry");
               if ( AV31isGAMAdminAccessRepository )
               {
                  GXv_objcol_SdtGAMError1[0] = AV23Errors ;
                  AV40RepositoryNew = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getbyguid(AV29GUID, GXv_objcol_SdtGAMError1);
                  AV23Errors = GXv_objcol_SdtGAMError1[0] ;
                  AV26GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
                  GXv_objcol_SdtGAMError1[0] = AV23Errors ;
                  AV32isOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).repositoryuserenable(AV40RepositoryNew.getgxTv_SdtGAMRepository_Id(), AV26GAMUser, AV5AdministratorRoleId, GXv_objcol_SdtGAMError1) ;
                  AV23Errors = GXv_objcol_SdtGAMError1[0] ;
                  if ( AV32isOK )
                  {
                     Application.commitDataStores(context, remoteHandle, pr_default, "gamrepositoryentry");
                  }
               }
            }
         }
         else if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
         {
            GXv_objcol_SdtGAMError1[0] = AV23Errors ;
            AV32isOK = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).deleterepository(AV37Repository.getgxTv_SdtGAMRepository_Guid(), GXv_objcol_SdtGAMError1) ;
            AV23Errors = GXv_objcol_SdtGAMError1[0] ;
            if ( AV32isOK )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "gamrepositoryentry");
            }
         }
      }
      if ( AV32isOK )
      {
         httpContext.setWebReturnParms(new Object[] {Gx_mode,Integer.valueOf(AV30Id)});
         httpContext.setWebReturnParmsMetadata(new Object[] {"Gx_mode","AV30Id"});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         returnInSub = true;
         if (true) return;
      }
      else
      {
         /* Execute user subroutine: 'DISPLAYERRORS' */
         S112 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV38RepositoryCreate", AV38RepositoryCreate);
   }

   public void e13352( )
   {
      /* Usecurrentrepositorasmasterauthentication_Click Routine */
      returnInSub = false ;
      AV25GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      AV34Namespace = AV25GAMRepository.getgxTv_SdtGAMRepository_Namespace() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34Namespace", AV34Namespace);
      if ( AV42UseCurrentRepositorAsMasterAuthentication )
      {
         edtavNamespace_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Visible), 5, 0), true);
         edtavAdministratorusername_Caption = httpContext.getMessage( "WWP_GAM_AdministratorUserNameUserExistCurrentTenant", "") ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAdministratorusername_Internalname, "Caption", edtavAdministratorusername_Caption, true);
         AV7AdministratorUserPassword = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AdministratorUserPassword", AV7AdministratorUserPassword);
         edtavAdministratoruserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAdministratoruserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdministratoruserpassword_Visible), 5, 0), true);
         AV10ConfAdministratorUserPassword = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10ConfAdministratorUserPassword", AV10ConfAdministratorUserPassword);
         edtavConfadministratoruserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavConfadministratoruserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConfadministratoruserpassword_Visible), 5, 0), true);
      }
      else
      {
         edtavNamespace_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Visible), 5, 0), true);
         edtavAdministratorusername_Caption = httpContext.getMessage( "WWP_GAM_AdministratorUserName", "") ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAdministratorusername_Internalname, "Caption", edtavAdministratorusername_Caption, true);
         edtavAdministratoruserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAdministratoruserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAdministratoruserpassword_Visible), 5, 0), true);
         edtavConfadministratoruserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavConfadministratoruserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConfadministratoruserpassword_Visible), 5, 0), true);
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'DISPLAYERRORS' Routine */
      returnInSub = false ;
      AV50GXV2 = 1 ;
      while ( AV50GXV2 <= AV23Errors.size() )
      {
         AV22Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV23Errors.elementAt(-1+AV50GXV2));
         httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV22Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV22Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
         AV50GXV2 = (int)(AV50GXV2+1) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e14352( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      Gx_mode = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      AV30Id = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30Id), 9, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30Id), "ZZZZZZZZ9")));
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
      pa352( ) ;
      ws352( ) ;
      we352( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111192966", true, true);
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
      httpContext.AddJavascriptSource("gamrepositoryentry.js", "?202412111192974", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      edtavGuid_Internalname = "vGUID" ;
      divGuid_cell_Internalname = "GUID_CELL" ;
      edtavName_Internalname = "vNAME" ;
      edtavDescription_Internalname = "vDESCRIPTION" ;
      chkavUsecurrentrepositorasmasterauthentication.setInternalname( "vUSECURRENTREPOSITORASMASTERAUTHENTICATION" );
      divUsecurrentrepositorasmasterauthentication_cell_Internalname = "USECURRENTREPOSITORASMASTERAUTHENTICATION_CELL" ;
      edtavNamespace_Internalname = "vNAMESPACE" ;
      divNamespace_cell_Internalname = "NAMESPACE_CELL" ;
      cmbavGeneratesessionstatistics.setInternalname( "vGENERATESESSIONSTATISTICS" );
      chkavAllowoauthaccess.setInternalname( "vALLOWOAUTHACCESS" );
      chkavCanregisterusers.setInternalname( "vCANREGISTERUSERS" );
      chkavGiveanonymoussession.setInternalname( "vGIVEANONYMOUSSESSION" );
      edtavConnectionusername_Internalname = "vCONNECTIONUSERNAME" ;
      edtavConnectionuserpassword_Internalname = "vCONNECTIONUSERPASSWORD" ;
      edtavConfconnectionuserpassword_Internalname = "vCONFCONNECTIONUSERPASSWORD" ;
      edtavAuthenticationmasterauthtypename_Internalname = "vAUTHENTICATIONMASTERAUTHTYPENAME" ;
      edtavAdministratorusername_Internalname = "vADMINISTRATORUSERNAME" ;
      edtavAdministratoruserpassword_Internalname = "vADMINISTRATORUSERPASSWORD" ;
      edtavConfadministratoruserpassword_Internalname = "vCONFADMINISTRATORUSERPASSWORD" ;
      divTbluserssettings_Internalname = "TBLUSERSSETTINGS" ;
      chkavIsgamadminaccessrepository.setInternalname( "vISGAMADMINACCESSREPOSITORY" );
      chkavCreategamapplication.setInternalname( "vCREATEGAMAPPLICATION" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      lblCopyrepdata_title_Internalname = "COPYREPDATA_TITLE" ;
      cmbavCopyfromrepositoryid.setInternalname( "vCOPYFROMREPOSITORYID" );
      chkavCopyroles.setInternalname( "vCOPYROLES" );
      edtavAdministratorroleid_Internalname = "vADMINISTRATORROLEID" ;
      divAdministratorroleid_cell_Internalname = "ADMINISTRATORROLEID_CELL" ;
      chkavCopysecuritypolicies.setInternalname( "vCOPYSECURITYPOLICIES" );
      chkavCopyapplication.setInternalname( "vCOPYAPPLICATION" );
      edtavCopyfromapplicationid_Internalname = "vCOPYFROMAPPLICATIONID" ;
      divCopyfromapplicationid_cell_Internalname = "COPYFROMAPPLICATIONID_CELL" ;
      chkavCopyapplicationrolepermissions.setInternalname( "vCOPYAPPLICATIONROLEPERMISSIONS" );
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      chkavUpdateconnectionfile.setInternalname( "vUPDATECONNECTIONFILE" );
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
      chkavUpdateconnectionfile.setVisible( 1 );
      bttBtnenter_Caption = httpContext.getMessage( "GX_BtnEnter", "") ;
      chkavCopyapplicationrolepermissions.setEnabled( 1 );
      edtavCopyfromapplicationid_Jsonclick = "" ;
      edtavCopyfromapplicationid_Enabled = 1 ;
      edtavCopyfromapplicationid_Visible = 1 ;
      divCopyfromapplicationid_cell_Class = "col-xs-12" ;
      chkavCopyapplication.setEnabled( 1 );
      chkavCopysecuritypolicies.setEnabled( 1 );
      edtavAdministratorroleid_Jsonclick = "" ;
      edtavAdministratorroleid_Enabled = 1 ;
      edtavAdministratorroleid_Visible = 1 ;
      divAdministratorroleid_cell_Class = "col-xs-12" ;
      chkavCopyroles.setEnabled( 1 );
      cmbavCopyfromrepositoryid.setJsonclick( "" );
      cmbavCopyfromrepositoryid.setEnabled( 1 );
      chkavCreategamapplication.setEnabled( 1 );
      chkavIsgamadminaccessrepository.setEnabled( 1 );
      edtavConfadministratoruserpassword_Jsonclick = "" ;
      edtavConfadministratoruserpassword_Enabled = 1 ;
      edtavConfadministratoruserpassword_Visible = 1 ;
      edtavAdministratoruserpassword_Jsonclick = "" ;
      edtavAdministratoruserpassword_Enabled = 1 ;
      edtavAdministratoruserpassword_Visible = 1 ;
      edtavAdministratorusername_Jsonclick = "" ;
      edtavAdministratorusername_Enabled = 1 ;
      edtavAdministratorusername_Caption = httpContext.getMessage( "WWP_GAM_AdministratorUserName", "") ;
      edtavAuthenticationmasterauthtypename_Jsonclick = "" ;
      edtavAuthenticationmasterauthtypename_Enabled = 1 ;
      edtavConfconnectionuserpassword_Jsonclick = "" ;
      edtavConfconnectionuserpassword_Enabled = 1 ;
      edtavConnectionuserpassword_Jsonclick = "" ;
      edtavConnectionuserpassword_Enabled = 1 ;
      edtavConnectionusername_Jsonclick = "" ;
      edtavConnectionusername_Enabled = 1 ;
      divTbluserssettings_Visible = 1 ;
      chkavGiveanonymoussession.setEnabled( 1 );
      chkavCanregisterusers.setEnabled( 1 );
      chkavAllowoauthaccess.setEnabled( 1 );
      cmbavGeneratesessionstatistics.setJsonclick( "" );
      cmbavGeneratesessionstatistics.setEnabled( 1 );
      edtavNamespace_Jsonclick = "" ;
      edtavNamespace_Enabled = 1 ;
      edtavNamespace_Visible = 1 ;
      divNamespace_cell_Class = "col-xs-12" ;
      chkavUsecurrentrepositorasmasterauthentication.setEnabled( 1 );
      chkavUsecurrentrepositorasmasterauthentication.setVisible( 1 );
      divUsecurrentrepositorasmasterauthentication_cell_Class = "col-xs-12" ;
      edtavDescription_Jsonclick = "" ;
      edtavDescription_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      edtavGuid_Jsonclick = "" ;
      edtavGuid_Enabled = 1 ;
      edtavGuid_Visible = 1 ;
      divGuid_cell_Class = "col-xs-12" ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "" ;
      Gxuitabspanel_tabs_Pagecount = 2 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Repository ", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavUsecurrentrepositorasmasterauthentication.setName( "vUSECURRENTREPOSITORASMASTERAUTHENTICATION" );
      chkavUsecurrentrepositorasmasterauthentication.setWebtags( "" );
      chkavUsecurrentrepositorasmasterauthentication.setCaption( httpContext.getMessage( "WWP_GAM_UseCurrentRepositoryAsAuthenticationMaster", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavUsecurrentrepositorasmasterauthentication.getInternalname(), "TitleCaption", chkavUsecurrentrepositorasmasterauthentication.getCaption(), true);
      chkavUsecurrentrepositorasmasterauthentication.setCheckedValue( "false" );
      AV42UseCurrentRepositorAsMasterAuthentication = GXutil.strtobool( GXutil.booltostr( AV42UseCurrentRepositorAsMasterAuthentication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42UseCurrentRepositorAsMasterAuthentication", AV42UseCurrentRepositorAsMasterAuthentication);
      cmbavGeneratesessionstatistics.setName( "vGENERATESESSIONSTATISTICS" );
      cmbavGeneratesessionstatistics.setWebtags( "" );
      cmbavGeneratesessionstatistics.addItem("None", httpContext.getMessage( "None", ""), (short)(0));
      cmbavGeneratesessionstatistics.addItem("Minimum", httpContext.getMessage( "Minimum (Only authenticated users)", ""), (short)(0));
      cmbavGeneratesessionstatistics.addItem("Detail", httpContext.getMessage( "Detail (Authenticated and anonymous users)", ""), (short)(0));
      cmbavGeneratesessionstatistics.addItem("Full", httpContext.getMessage( "Full log (Authenticated and anonymous users)", ""), (short)(0));
      if ( cmbavGeneratesessionstatistics.getItemCount() > 0 )
      {
         AV27GenerateSessionStatistics = cmbavGeneratesessionstatistics.getValidValue(AV27GenerateSessionStatistics) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GenerateSessionStatistics", AV27GenerateSessionStatistics);
      }
      chkavAllowoauthaccess.setName( "vALLOWOAUTHACCESS" );
      chkavAllowoauthaccess.setWebtags( "" );
      chkavAllowoauthaccess.setCaption( httpContext.getMessage( "WWP_GAM_AllowOauthAccess", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavAllowoauthaccess.getInternalname(), "TitleCaption", chkavAllowoauthaccess.getCaption(), true);
      chkavAllowoauthaccess.setCheckedValue( "false" );
      AV8AllowOauthAccess = GXutil.strtobool( GXutil.booltostr( AV8AllowOauthAccess)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8AllowOauthAccess", AV8AllowOauthAccess);
      chkavCanregisterusers.setName( "vCANREGISTERUSERS" );
      chkavCanregisterusers.setWebtags( "" );
      chkavCanregisterusers.setCaption( httpContext.getMessage( "WWP_GAM_CanRegisterUsers", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCanregisterusers.getInternalname(), "TitleCaption", chkavCanregisterusers.getCaption(), true);
      chkavCanregisterusers.setCheckedValue( "false" );
      AV45CanRegisterUsers = GXutil.strtobool( GXutil.booltostr( AV45CanRegisterUsers)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45CanRegisterUsers", AV45CanRegisterUsers);
      chkavGiveanonymoussession.setName( "vGIVEANONYMOUSSESSION" );
      chkavGiveanonymoussession.setWebtags( "" );
      chkavGiveanonymoussession.setCaption( httpContext.getMessage( "WWP_GAM_GiveAnonymousSession", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavGiveanonymoussession.getInternalname(), "TitleCaption", chkavGiveanonymoussession.getCaption(), true);
      chkavGiveanonymoussession.setCheckedValue( "false" );
      AV28GiveAnonymousSession = GXutil.strtobool( GXutil.booltostr( AV28GiveAnonymousSession)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GiveAnonymousSession", AV28GiveAnonymousSession);
      chkavIsgamadminaccessrepository.setName( "vISGAMADMINACCESSREPOSITORY" );
      chkavIsgamadminaccessrepository.setWebtags( "" );
      chkavIsgamadminaccessrepository.setCaption( httpContext.getMessage( "WWP_GAM_IsCurrentUserAdminOfNewRepository", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavIsgamadminaccessrepository.getInternalname(), "TitleCaption", chkavIsgamadminaccessrepository.getCaption(), true);
      chkavIsgamadminaccessrepository.setCheckedValue( "false" );
      AV31isGAMAdminAccessRepository = GXutil.strtobool( GXutil.booltostr( AV31isGAMAdminAccessRepository)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31isGAMAdminAccessRepository", AV31isGAMAdminAccessRepository);
      chkavCreategamapplication.setName( "vCREATEGAMAPPLICATION" );
      chkavCreategamapplication.setWebtags( "" );
      chkavCreategamapplication.setCaption( httpContext.getMessage( "WWP_GAM_CreateGAMBackendApplication", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCreategamapplication.getInternalname(), "TitleCaption", chkavCreategamapplication.getCaption(), true);
      chkavCreategamapplication.setCheckedValue( "false" );
      AV20CreateGAMApplication = GXutil.strtobool( GXutil.booltostr( AV20CreateGAMApplication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20CreateGAMApplication", AV20CreateGAMApplication);
      cmbavCopyfromrepositoryid.setName( "vCOPYFROMREPOSITORYID" );
      cmbavCopyfromrepositoryid.setWebtags( "" );
      if ( cmbavCopyfromrepositoryid.getItemCount() > 0 )
      {
         AV17CopyFromRepositoryId = (int)(GXutil.lval( cmbavCopyfromrepositoryid.getValidValue(GXutil.trim( GXutil.str( AV17CopyFromRepositoryId, 9, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17CopyFromRepositoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17CopyFromRepositoryId), 9, 0));
      }
      chkavCopyroles.setName( "vCOPYROLES" );
      chkavCopyroles.setWebtags( "" );
      chkavCopyroles.setCaption( httpContext.getMessage( "WWP_GAM_CopyRoles", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCopyroles.getInternalname(), "TitleCaption", chkavCopyroles.getCaption(), true);
      chkavCopyroles.setCheckedValue( "false" );
      AV18CopyRoles = GXutil.strtobool( GXutil.booltostr( AV18CopyRoles)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18CopyRoles", AV18CopyRoles);
      chkavCopysecuritypolicies.setName( "vCOPYSECURITYPOLICIES" );
      chkavCopysecuritypolicies.setWebtags( "" );
      chkavCopysecuritypolicies.setCaption( httpContext.getMessage( "WWP_GAM_CopySecurityPolicies", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCopysecuritypolicies.getInternalname(), "TitleCaption", chkavCopysecuritypolicies.getCaption(), true);
      chkavCopysecuritypolicies.setCheckedValue( "false" );
      AV19CopySecurityPolicies = GXutil.strtobool( GXutil.booltostr( AV19CopySecurityPolicies)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19CopySecurityPolicies", AV19CopySecurityPolicies);
      chkavCopyapplication.setName( "vCOPYAPPLICATION" );
      chkavCopyapplication.setWebtags( "" );
      chkavCopyapplication.setCaption( httpContext.getMessage( "WWP_GAM_CopyApplicationMenusAndPermissions", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCopyapplication.getInternalname(), "TitleCaption", chkavCopyapplication.getCaption(), true);
      chkavCopyapplication.setCheckedValue( "false" );
      AV14CopyApplication = GXutil.strtobool( GXutil.booltostr( AV14CopyApplication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14CopyApplication", AV14CopyApplication);
      chkavCopyapplicationrolepermissions.setName( "vCOPYAPPLICATIONROLEPERMISSIONS" );
      chkavCopyapplicationrolepermissions.setWebtags( "" );
      chkavCopyapplicationrolepermissions.setCaption( httpContext.getMessage( "WWP_GAM_CopyRolesPermissions", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavCopyapplicationrolepermissions.getInternalname(), "TitleCaption", chkavCopyapplicationrolepermissions.getCaption(), true);
      chkavCopyapplicationrolepermissions.setCheckedValue( "false" );
      AV15CopyApplicationRolePermissions = GXutil.strtobool( GXutil.booltostr( AV15CopyApplicationRolePermissions)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15CopyApplicationRolePermissions", AV15CopyApplicationRolePermissions);
      chkavUpdateconnectionfile.setName( "vUPDATECONNECTIONFILE" );
      chkavUpdateconnectionfile.setWebtags( "" );
      chkavUpdateconnectionfile.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavUpdateconnectionfile.getInternalname(), "TitleCaption", chkavUpdateconnectionfile.getCaption(), true);
      chkavUpdateconnectionfile.setCheckedValue( "false" );
      AV41UpdateConnectionFile = GXutil.strtobool( GXutil.booltostr( AV41UpdateConnectionFile)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41UpdateConnectionFile", AV41UpdateConnectionFile);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV42UseCurrentRepositorAsMasterAuthentication',fld:'vUSECURRENTREPOSITORASMASTERAUTHENTICATION',pic:''},{av:'AV8AllowOauthAccess',fld:'vALLOWOAUTHACCESS',pic:''},{av:'AV45CanRegisterUsers',fld:'vCANREGISTERUSERS',pic:''},{av:'AV28GiveAnonymousSession',fld:'vGIVEANONYMOUSSESSION',pic:''},{av:'AV31isGAMAdminAccessRepository',fld:'vISGAMADMINACCESSREPOSITORY',pic:''},{av:'AV20CreateGAMApplication',fld:'vCREATEGAMAPPLICATION',pic:''},{av:'AV18CopyRoles',fld:'vCOPYROLES',pic:''},{av:'AV19CopySecurityPolicies',fld:'vCOPYSECURITYPOLICIES',pic:''},{av:'AV14CopyApplication',fld:'vCOPYAPPLICATION',pic:''},{av:'AV15CopyApplicationRolePermissions',fld:'vCOPYAPPLICATIONROLEPERMISSIONS',pic:''},{av:'AV41UpdateConnectionFile',fld:'vUPDATECONNECTIONFILE',pic:''},{av:'AV30Id',fld:'vID',pic:'ZZZZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e12352',iparms:[{av:'AV30Id',fld:'vID',pic:'ZZZZZZZZ9',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7AdministratorUserPassword',fld:'vADMINISTRATORUSERPASSWORD',pic:''},{av:'AV10ConfAdministratorUserPassword',fld:'vCONFADMINISTRATORUSERPASSWORD',pic:''},{av:'AV13ConnectionUserPassword',fld:'vCONNECTIONUSERPASSWORD',pic:''},{av:'AV11ConfConnectionUserPassword',fld:'vCONFCONNECTIONUSERPASSWORD',pic:''},{av:'AV33Name',fld:'vNAME',pic:''},{av:'AV34Namespace',fld:'vNAMESPACE',pic:''},{av:'AV21Description',fld:'vDESCRIPTION',pic:''},{av:'AV6AdministratorUserName',fld:'vADMINISTRATORUSERNAME',pic:''},{av:'AV8AllowOauthAccess',fld:'vALLOWOAUTHACCESS',pic:''},{av:'AV12ConnectionUserName',fld:'vCONNECTIONUSERNAME',pic:''},{av:'cmbavGeneratesessionstatistics'},{av:'AV27GenerateSessionStatistics',fld:'vGENERATESESSIONSTATISTICS',pic:''},{av:'AV42UseCurrentRepositorAsMasterAuthentication',fld:'vUSECURRENTREPOSITORASMASTERAUTHENTICATION',pic:''},{av:'AV9AuthenticationMasterAuthTypeName',fld:'vAUTHENTICATIONMASTERAUTHTYPENAME',pic:''},{av:'AV20CreateGAMApplication',fld:'vCREATEGAMAPPLICATION',pic:''},{av:'cmbavCopyfromrepositoryid'},{av:'AV17CopyFromRepositoryId',fld:'vCOPYFROMREPOSITORYID',pic:'ZZZZZZZZ9'},{av:'AV18CopyRoles',fld:'vCOPYROLES',pic:''},{av:'AV5AdministratorRoleId',fld:'vADMINISTRATORROLEID',pic:'ZZZZZZZZZZZ9'},{av:'AV19CopySecurityPolicies',fld:'vCOPYSECURITYPOLICIES',pic:''},{av:'AV14CopyApplication',fld:'vCOPYAPPLICATION',pic:''},{av:'AV16CopyFromApplicationId',fld:'vCOPYFROMAPPLICATIONID',pic:'ZZZZZZZZZZZ9'},{av:'AV15CopyApplicationRolePermissions',fld:'vCOPYAPPLICATIONROLEPERMISSIONS',pic:''},{av:'AV41UpdateConnectionFile',fld:'vUPDATECONNECTIONFILE',pic:''},{av:'AV31isGAMAdminAccessRepository',fld:'vISGAMADMINACCESSREPOSITORY',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV29GUID',fld:'vGUID',pic:''}]}");
      setEventMetadata("VUSECURRENTREPOSITORASMASTERAUTHENTICATION.CLICK","{handler:'e13352',iparms:[{av:'AV42UseCurrentRepositorAsMasterAuthentication',fld:'vUSECURRENTREPOSITORASMASTERAUTHENTICATION',pic:''},{av:'AV15CopyApplicationRolePermissions',fld:'vCOPYAPPLICATIONROLEPERMISSIONS',pic:''},{av:'AV18CopyRoles',fld:'vCOPYROLES',pic:''},{av:'AV14CopyApplication',fld:'vCOPYAPPLICATION',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true}]");
      setEventMetadata("VUSECURRENTREPOSITORASMASTERAUTHENTICATION.CLICK",",oparms:[{av:'AV34Namespace',fld:'vNAMESPACE',pic:''},{av:'AV7AdministratorUserPassword',fld:'vADMINISTRATORUSERPASSWORD',pic:''},{av:'AV10ConfAdministratorUserPassword',fld:'vCONFADMINISTRATORUSERPASSWORD',pic:''},{av:'edtavNamespace_Visible',ctrl:'vNAMESPACE',prop:'Visible'},{av:'edtavAdministratorusername_Caption',ctrl:'vADMINISTRATORUSERNAME',prop:'Caption'},{av:'edtavAdministratoruserpassword_Visible',ctrl:'vADMINISTRATORUSERPASSWORD',prop:'Visible'},{av:'edtavConfadministratoruserpassword_Visible',ctrl:'vCONFADMINISTRATORUSERPASSWORD',prop:'Visible'},{av:'edtavAdministratorroleid_Visible',ctrl:'vADMINISTRATORROLEID',prop:'Visible'},{av:'divAdministratorroleid_cell_Class',ctrl:'ADMINISTRATORROLEID_CELL',prop:'Class'},{av:'edtavCopyfromapplicationid_Visible',ctrl:'vCOPYFROMAPPLICATIONID',prop:'Visible'},{av:'divCopyfromapplicationid_cell_Class',ctrl:'COPYFROMAPPLICATIONID_CELL',prop:'Class'},{av:'edtavGuid_Visible',ctrl:'vGUID',prop:'Visible'},{av:'divGuid_cell_Class',ctrl:'GUID_CELL',prop:'Class'},{av:'chkavUsecurrentrepositorasmasterauthentication.getVisible()',ctrl:'vUSECURRENTREPOSITORASMASTERAUTHENTICATION',prop:'Visible'},{av:'divUsecurrentrepositorasmasterauthentication_cell_Class',ctrl:'USECURRENTREPOSITORASMASTERAUTHENTICATION_CELL',prop:'Class'},{av:'divNamespace_cell_Class',ctrl:'NAMESPACE_CELL',prop:'Class'}]}");
      setEventMetadata("VALIDV_GENERATESESSIONSTATISTICS","{handler:'validv_Generatesessionstatistics',iparms:[]");
      setEventMetadata("VALIDV_GENERATESESSIONSTATISTICS",",oparms:[]}");
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
      return "gamrepositoryentry_Execute";
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
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      TempTags = "" ;
      AV29GUID = "" ;
      AV33Name = "" ;
      AV21Description = "" ;
      AV34Namespace = "" ;
      AV27GenerateSessionStatistics = "" ;
      AV12ConnectionUserName = "" ;
      AV13ConnectionUserPassword = "" ;
      AV11ConfConnectionUserPassword = "" ;
      AV9AuthenticationMasterAuthTypeName = "" ;
      AV6AdministratorUserName = "" ;
      AV7AdministratorUserPassword = "" ;
      AV10ConfAdministratorUserPassword = "" ;
      lblCopyrepdata_title_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV37Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV23Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV36Repositories = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRepository>(genexus.security.api.genexussecurity.SdtGAMRepository.class, "GAMRepository", "http://tempuri.org/", remoteHandle);
      AV39RepositoryFilter = new genexus.security.api.genexussecurity.SdtGAMRepositoryFilter(remoteHandle, context);
      AV35Repo = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV38RepositoryCreate = new genexus.security.api.genexussecurity.SdtGAMRepositoryCreate(remoteHandle, context);
      AV25GAMRepository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV40RepositoryNew = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV26GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV22Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamrepositoryentry__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamrepositoryentry__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
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
   private int wcpOAV30Id ;
   private int AV30Id ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtavGuid_Visible ;
   private int edtavGuid_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDescription_Enabled ;
   private int edtavNamespace_Visible ;
   private int edtavNamespace_Enabled ;
   private int divTbluserssettings_Visible ;
   private int edtavConnectionusername_Enabled ;
   private int edtavConnectionuserpassword_Enabled ;
   private int edtavConfconnectionuserpassword_Enabled ;
   private int edtavAuthenticationmasterauthtypename_Enabled ;
   private int edtavAdministratorusername_Enabled ;
   private int edtavAdministratoruserpassword_Visible ;
   private int edtavAdministratoruserpassword_Enabled ;
   private int edtavConfadministratoruserpassword_Visible ;
   private int edtavConfadministratoruserpassword_Enabled ;
   private int AV17CopyFromRepositoryId ;
   private int edtavAdministratorroleid_Visible ;
   private int edtavAdministratorroleid_Enabled ;
   private int edtavCopyfromapplicationid_Visible ;
   private int edtavCopyfromapplicationid_Enabled ;
   private int AV49GXV1 ;
   private int AV50GXV2 ;
   private int idxLst ;
   private long AV5AdministratorRoleId ;
   private long AV16CopyFromApplicationId ;
   private String wcpOGx_mode ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Gxuitabspanel_tabs_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String divGuid_cell_Internalname ;
   private String divGuid_cell_Class ;
   private String edtavGuid_Internalname ;
   private String TempTags ;
   private String AV29GUID ;
   private String edtavGuid_Jsonclick ;
   private String edtavName_Internalname ;
   private String AV33Name ;
   private String edtavName_Jsonclick ;
   private String edtavDescription_Internalname ;
   private String AV21Description ;
   private String edtavDescription_Jsonclick ;
   private String divUsecurrentrepositorasmasterauthentication_cell_Internalname ;
   private String divUsecurrentrepositorasmasterauthentication_cell_Class ;
   private String divNamespace_cell_Internalname ;
   private String divNamespace_cell_Class ;
   private String edtavNamespace_Internalname ;
   private String AV34Namespace ;
   private String edtavNamespace_Jsonclick ;
   private String AV27GenerateSessionStatistics ;
   private String divTbluserssettings_Internalname ;
   private String edtavConnectionusername_Internalname ;
   private String AV12ConnectionUserName ;
   private String edtavConnectionusername_Jsonclick ;
   private String edtavConnectionuserpassword_Internalname ;
   private String AV13ConnectionUserPassword ;
   private String edtavConnectionuserpassword_Jsonclick ;
   private String edtavConfconnectionuserpassword_Internalname ;
   private String AV11ConfConnectionUserPassword ;
   private String edtavConfconnectionuserpassword_Jsonclick ;
   private String edtavAuthenticationmasterauthtypename_Internalname ;
   private String AV9AuthenticationMasterAuthTypeName ;
   private String edtavAuthenticationmasterauthtypename_Jsonclick ;
   private String edtavAdministratorusername_Internalname ;
   private String edtavAdministratorusername_Caption ;
   private String AV6AdministratorUserName ;
   private String edtavAdministratorusername_Jsonclick ;
   private String edtavAdministratoruserpassword_Internalname ;
   private String AV7AdministratorUserPassword ;
   private String edtavAdministratoruserpassword_Jsonclick ;
   private String edtavConfadministratoruserpassword_Internalname ;
   private String AV10ConfAdministratorUserPassword ;
   private String edtavConfadministratoruserpassword_Jsonclick ;
   private String lblCopyrepdata_title_Internalname ;
   private String lblCopyrepdata_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String divAdministratorroleid_cell_Internalname ;
   private String divAdministratorroleid_cell_Class ;
   private String edtavAdministratorroleid_Internalname ;
   private String edtavAdministratorroleid_Jsonclick ;
   private String divCopyfromapplicationid_cell_Internalname ;
   private String divCopyfromapplicationid_cell_Class ;
   private String edtavCopyfromapplicationid_Internalname ;
   private String edtavCopyfromapplicationid_Jsonclick ;
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
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV42UseCurrentRepositorAsMasterAuthentication ;
   private boolean AV8AllowOauthAccess ;
   private boolean AV45CanRegisterUsers ;
   private boolean AV28GiveAnonymousSession ;
   private boolean AV31isGAMAdminAccessRepository ;
   private boolean AV20CreateGAMApplication ;
   private boolean AV18CopyRoles ;
   private boolean AV19CopySecurityPolicies ;
   private boolean AV14CopyApplication ;
   private boolean AV15CopyApplicationRolePermissions ;
   private boolean AV41UpdateConnectionFile ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV32isOK ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private genexus.security.api.genexussecurity.SdtGAMRepositoryCreate AV38RepositoryCreate ;
   private ICheckbox chkavUsecurrentrepositorasmasterauthentication ;
   private HTMLChoice cmbavGeneratesessionstatistics ;
   private ICheckbox chkavAllowoauthaccess ;
   private ICheckbox chkavCanregisterusers ;
   private ICheckbox chkavGiveanonymoussession ;
   private ICheckbox chkavIsgamadminaccessrepository ;
   private ICheckbox chkavCreategamapplication ;
   private HTMLChoice cmbavCopyfromrepositoryid ;
   private ICheckbox chkavCopyroles ;
   private ICheckbox chkavCopysecuritypolicies ;
   private ICheckbox chkavCopyapplication ;
   private ICheckbox chkavCopyapplicationrolepermissions ;
   private ICheckbox chkavUpdateconnectionfile ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV23Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRepository> AV36Repositories ;
   private genexus.security.api.genexussecurity.SdtGAMError AV22Error ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV26GAMUser ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV37Repository ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV35Repo ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV25GAMRepository ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV40RepositoryNew ;
   private genexus.security.api.genexussecurity.SdtGAMRepositoryFilter AV39RepositoryFilter ;
}

final  class gamrepositoryentry__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamrepositoryentry__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

