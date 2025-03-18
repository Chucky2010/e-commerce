package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gamrepositoryconfiguration_impl extends GXDataArea
{
   public gamrepositoryconfiguration_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gamrepositoryconfiguration_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamrepositoryconfiguration_impl.class ));
   }

   public gamrepositoryconfiguration_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavEnabletracing = new HTMLChoice();
      cmbavDefaultauthtypename = new HTMLChoice();
      cmbavDefaultroleid = new HTMLChoice();
      cmbavDefaultsecuritypolicyid = new HTMLChoice();
      chkavAllowoauthaccess = UIFactory.getCheckbox(this);
      cmbavLogoutbehavior = new HTMLChoice();
      chkavEnableworkingasgammanagerrepo = UIFactory.getCheckbox(this);
      cmbavUseridentification = new HTMLChoice();
      chkavUseremailisunique = UIFactory.getCheckbox(this);
      cmbavUseractivationmethod = new HTMLChoice();
      cmbavUserremembermetype = new HTMLChoice();
      chkavRequiredemail = UIFactory.getCheckbox(this);
      chkavRequiredpassword = UIFactory.getCheckbox(this);
      chkavRequiredfirstname = UIFactory.getCheckbox(this);
      chkavRequiredlastname = UIFactory.getCheckbox(this);
      chkavRequiredbirthday = UIFactory.getCheckbox(this);
      chkavRequiredgender = UIFactory.getCheckbox(this);
      cmbavGeneratesessionstatistics = new HTMLChoice();
      chkavGiveanonymoussession = UIFactory.getCheckbox(this);
      chkavSessionexpiresonipchange = UIFactory.getCheckbox(this);
      chkavIntsecbydomainenable = UIFactory.getCheckbox(this);
      cmbavIntsecbydomainmode = new HTMLChoice();
      chkavEmailserversecure = UIFactory.getCheckbox(this);
      chkavEmailserverusesauthentication = UIFactory.getCheckbox(this);
      chkavEmailserver_sendemailwhenuseractivateaccount = UIFactory.getCheckbox(this);
      chkavEmailserver_sendemailwhenuserchangepassword = UIFactory.getCheckbox(this);
      chkavEmailserver_sendemailwhenuserchangeemail = UIFactory.getCheckbox(this);
      chkavEmailserver_sendemailforrecoverypassword = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "Id") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "Id") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "Id") ;
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
            AV45Id = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV45Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45Id), 12, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45Id), "ZZZZZZZZZZZ9")));
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
      pa342( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start342( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.gamrepositoryconfiguration", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV45Id,12,0))}, new String[] {"Id"}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECURITYADMINISTRATOREMAIL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71SecurityAdministratorEmail, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCANREGISTERUSERS", getSecureSignedToken( "", AV9CanRegisterUsers));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45Id), "ZZZZZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"GAMRepositoryConfiguration");
      forbiddenHiddens.add("RepoId", localUtil.format( DecimalUtil.doubleToDec(AV59RepoId), "ZZZZZZZZZZZ9"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("gamrepositoryconfiguration:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSECURITYADMINISTRATOREMAIL", AV71SecurityAdministratorEmail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECURITYADMINISTRATOREMAIL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71SecurityAdministratorEmail, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vCANREGISTERUSERS", AV9CanRegisterUsers);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCANREGISTERUSERS", getSecureSignedToken( "", AV9CanRegisterUsers));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vID", GXutil.ltrim( localUtil.ntoc( AV45Id, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45Id), "ZZZZZZZZZZZ9")));
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
         we342( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt342( ) ;
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
      return formatLink("com.mujermorena.gamrepositoryconfiguration", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV45Id,12,0))}, new String[] {"Id"})  ;
   }

   public String getPgmname( )
   {
      return "GAMRepositoryConfiguration" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Repository configuration ", "") ;
   }

   public void wb340( )
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryConfiguration.htm");
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
         /* User Defined Control */
         ucGxuitabspanel_tabs.setProperty("PageCount", Gxuitabspanel_tabs_Pagecount);
         ucGxuitabspanel_tabs.setProperty("Class", Gxuitabspanel_tabs_Class);
         ucGxuitabspanel_tabs.setProperty("HistoryManagement", Gxuitabspanel_tabs_Historymanagement);
         ucGxuitabspanel_tabs.render(context, "tab", Gxuitabspanel_tabs_Internalname, "GXUITABSPANEL_TABSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, httpContext.getMessage( "WWP_GAM_General", ""), "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryConfiguration.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRepoid_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavRepoid_Internalname, httpContext.getMessage( "WWP_GAM_Id", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavRepoid_Internalname, GXutil.ltrim( localUtil.ntoc( AV59RepoId, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavRepoid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV59RepoId), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV59RepoId), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRepoid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavRepoid_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMKeyNumLong", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGuid_Internalname, GXutil.rtrim( AV44GUID), GXutil.rtrim( localUtil.format( AV44GUID, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGuid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavGuid_Enabled, 0, "text", "", 32, "chr", 1, "row", 32, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavNamespace_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavNamespace_Internalname, httpContext.getMessage( "WWP_GAM_Namespace", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavNamespace_Internalname, GXutil.rtrim( AV58NameSpace), GXutil.rtrim( localUtil.format( AV58NameSpace, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavNamespace_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavNamespace_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMRepositoryNameSpace", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavName_Internalname, GXutil.rtrim( AV57Name), GXutil.rtrim( localUtil.format( AV57Name, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavName_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavName_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavDsc_Internalname, GXutil.rtrim( AV13Dsc), GXutil.rtrim( localUtil.format( AV13Dsc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDsc_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavDsc_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavEnabletracing.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavEnabletracing.getInternalname(), httpContext.getMessage( "WWP_GAM_EnableTracing", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEnabletracing, cmbavEnabletracing.getInternalname(), GXutil.rtrim( AV33EnableTracing), 1, cmbavEnabletracing.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavEnabletracing.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavEnabletracing.setValue( GXutil.rtrim( AV33EnableTracing) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEnabletracing.getInternalname(), "Values", cmbavEnabletracing.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divAuthenticationmasterrepository_cell_Internalname, 1, 0, "px", 0, "px", divAuthenticationmasterrepository_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavAuthenticationmasterrepository_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAuthenticationmasterrepository_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavAuthenticationmasterrepository_Internalname, httpContext.getMessage( "WWP_GAM_AuthenticationMasterRepository", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavAuthenticationmasterrepository_Internalname, GXutil.rtrim( AV6AuthenticationMasterRepository), GXutil.rtrim( localUtil.format( AV6AuthenticationMasterRepository, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAuthenticationmasterrepository_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavAuthenticationmasterrepository_Visible, edtavAuthenticationmasterrepository_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divDefaultauthtypename_cell_Internalname, 1, 0, "px", 0, "px", divDefaultauthtypename_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavDefaultauthtypename.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDefaultauthtypename.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavDefaultauthtypename.getInternalname(), httpContext.getMessage( "WWP_GAM_DefaultAuthenticationtype", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDefaultauthtypename, cmbavDefaultauthtypename.getInternalname(), GXutil.rtrim( AV10DefaultAuthTypeName), 1, cmbavDefaultauthtypename.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavDefaultauthtypename.getVisible(), cmbavDefaultauthtypename.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,56);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavDefaultauthtypename.setValue( GXutil.rtrim( AV10DefaultAuthTypeName) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultauthtypename.getInternalname(), "Values", cmbavDefaultauthtypename.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divDefaultroleid_cell_Internalname, 1, 0, "px", 0, "px", divDefaultroleid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavDefaultroleid.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDefaultroleid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavDefaultroleid.getInternalname(), httpContext.getMessage( "WWP_GAM_Defaultrole", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDefaultroleid, cmbavDefaultroleid.getInternalname(), GXutil.trim( GXutil.str( AV11DefaultRoleId, 12, 0)), 1, cmbavDefaultroleid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDefaultroleid.getVisible(), cmbavDefaultroleid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavDefaultroleid.setValue( GXutil.trim( GXutil.str( AV11DefaultRoleId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultroleid.getInternalname(), "Values", cmbavDefaultroleid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divDefaultsecuritypolicyid_cell_Internalname, 1, 0, "px", 0, "px", divDefaultsecuritypolicyid_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", cmbavDefaultsecuritypolicyid.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDefaultsecuritypolicyid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavDefaultsecuritypolicyid.getInternalname(), httpContext.getMessage( "WWP_GAM_DefaultSecurityPolicy", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDefaultsecuritypolicyid, cmbavDefaultsecuritypolicyid.getInternalname(), GXutil.trim( GXutil.str( AV12DefaultSecurityPolicyId, 9, 0)), 1, cmbavDefaultsecuritypolicyid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavDefaultsecuritypolicyid.getVisible(), cmbavDefaultsecuritypolicyid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavDefaultsecuritypolicyid.setValue( GXutil.trim( GXutil.str( AV12DefaultSecurityPolicyId, 9, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultsecuritypolicyid.getInternalname(), "Values", cmbavDefaultsecuritypolicyid.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavAllowoauthaccess.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavAllowoauthaccess.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAllowoauthaccess.getInternalname(), GXutil.booltostr( AV5AllowOauthAccess), "", " ", 1, chkavAllowoauthaccess.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_RepositoryAllowOauthAcess", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(70, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,70);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavLogoutbehavior.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavLogoutbehavior.getInternalname(), httpContext.getMessage( "WWP_GAM_GAMRemoteLogoutbehavior", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavLogoutbehavior, cmbavLogoutbehavior.getInternalname(), GXutil.rtrim( AV55LogoutBehavior), 1, cmbavLogoutbehavior.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavLogoutbehavior.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavLogoutbehavior.setValue( GXutil.rtrim( AV55LogoutBehavior) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogoutbehavior.getInternalname(), "Values", cmbavLogoutbehavior.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEnableworkingasgammanagerrepo_cell_Internalname, 1, 0, "px", 0, "px", divEnableworkingasgammanagerrepo_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavEnableworkingasgammanagerrepo.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEnableworkingasgammanagerrepo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEnableworkingasgammanagerrepo.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEnableworkingasgammanagerrepo.getInternalname(), GXutil.booltostr( AV35EnableWorkingAsGAMManagerRepo), "", " ", chkavEnableworkingasgammanagerrepo.getVisible(), chkavEnableworkingasgammanagerrepo.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_EnableWorkingAsGAMManagerRepo", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(79, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,79);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblUsers_title_Internalname, httpContext.getMessage( "WWP_GAM_Users", ""), "", "", lblUsers_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryConfiguration.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Users") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavUseridentification.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavUseridentification.getInternalname(), httpContext.getMessage( "WWP_GAM_UserIdentification", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavUseridentification, cmbavUseridentification.getInternalname(), GXutil.rtrim( AV80UserIdentification), 1, cmbavUseridentification.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavUseridentification.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavUseridentification.setValue( GXutil.rtrim( AV80UserIdentification) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUseridentification.getInternalname(), "Values", cmbavUseridentification.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUseremailisunique_cell_Internalname, 1, 0, "px", 0, "px", divUseremailisunique_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavUseremailisunique.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavUseremailisunique.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavUseremailisunique.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavUseremailisunique.getInternalname(), GXutil.booltostr( AV79UserEmailisUnique), "", " ", chkavUseremailisunique.getVisible(), chkavUseremailisunique.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_UserEmailIsUnique", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(93, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,93);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavUseractivationmethod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavUseractivationmethod.getInternalname(), httpContext.getMessage( "WWP_GAM_Useractivationmethod", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavUseractivationmethod, cmbavUseractivationmethod.getInternalname(), GXutil.rtrim( AV77UserActivationMethod), 1, cmbavUseractivationmethod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavUseractivationmethod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavUseractivationmethod.setValue( GXutil.rtrim( AV77UserActivationMethod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUseractivationmethod.getInternalname(), "Values", cmbavUseractivationmethod.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserautomaticactivationtimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserautomaticactivationtimeout_Internalname, httpContext.getMessage( "WWP_GAM_Userautomaticactivationtimeouthours", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserautomaticactivationtimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV78UserAutomaticActivationTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavUserautomaticactivationtimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV78UserAutomaticActivationTimeout), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV78UserAutomaticActivationTimeout), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,102);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserautomaticactivationtimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserautomaticactivationtimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserrecoverypasswordkeytimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserrecoverypasswordkeytimeout_Internalname, httpContext.getMessage( "WWP_GAM_UserRecoveryPasswordTimeout", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserrecoverypasswordkeytimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV81UserRecoveryPasswordKeyTimeOut, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavUserrecoverypasswordkeytimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV81UserRecoveryPasswordKeyTimeOut), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV81UserRecoveryPasswordKeyTimeOut), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserrecoverypasswordkeytimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserrecoverypasswordkeytimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserrecoverypasswordkeydailymaximum_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserrecoverypasswordkeydailymaximum_Internalname, httpContext.getMessage( "WWP_GAM_UserRecoveryPasswordKeyDailyMaximum", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 111,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserrecoverypasswordkeydailymaximum_Internalname, GXutil.ltrim( localUtil.ntoc( AV82UserRecoveryPasswordKeyDailyMaximum, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavUserrecoverypasswordkeydailymaximum_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV82UserRecoveryPasswordKeyDailyMaximum), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV82UserRecoveryPasswordKeyDailyMaximum), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,111);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserrecoverypasswordkeydailymaximum_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserrecoverypasswordkeydailymaximum_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserrecoverypasswordkeymonthlymaximum_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserrecoverypasswordkeymonthlymaximum_Internalname, httpContext.getMessage( "WWP_GAM_UserRecoveryPasswordKeyMonthlyMaximum", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserrecoverypasswordkeymonthlymaximum_Internalname, GXutil.ltrim( localUtil.ntoc( AV83UserRecoveryPasswordKeyMonthlyMaximum, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavUserrecoverypasswordkeymonthlymaximum_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV83UserRecoveryPasswordKeyMonthlyMaximum), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV83UserRecoveryPasswordKeyMonthlyMaximum), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,116);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserrecoverypasswordkeymonthlymaximum_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserrecoverypasswordkeymonthlymaximum_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLoginattemptstolockuser_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavLoginattemptstolockuser_Internalname, httpContext.getMessage( "WWP_GAM_LoginRetriesLockUser", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavLoginattemptstolockuser_Internalname, GXutil.ltrim( localUtil.ntoc( AV54LoginAttemptsToLockUser, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLoginattemptstolockuser_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV54LoginAttemptsToLockUser), "Z9") : localUtil.format( DecimalUtil.doubleToDec(AV54LoginAttemptsToLockUser), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLoginattemptstolockuser_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavLoginattemptstolockuser_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavGamunblockusertimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavGamunblockusertimeout_Internalname, httpContext.getMessage( "WWP_GAM_UnblockUserTimeout", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavGamunblockusertimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV41GAMUnblockUserTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavGamunblockusertimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV41GAMUnblockUserTimeout), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV41GAMUnblockUserTimeout), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,125);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGamunblockusertimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavGamunblockusertimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavUserremembermetype.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavUserremembermetype.getInternalname(), httpContext.getMessage( "WWP_GAM_UserRememberMeType", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavUserremembermetype, cmbavUserremembermetype.getInternalname(), GXutil.rtrim( AV85UserRememberMeType), 1, cmbavUserremembermetype.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavUserremembermetype.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,129);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavUserremembermetype.setValue( GXutil.rtrim( AV85UserRememberMeType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUserremembermetype.getInternalname(), "Values", cmbavUserremembermetype.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUserremembermetimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUserremembermetimeout_Internalname, httpContext.getMessage( "WWP_GAM_UserRememberMeTimeoutDays", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUserremembermetimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV84UserRememberMeTimeOut, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavUserremembermetimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV84UserRememberMeTimeOut), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV84UserRememberMeTimeOut), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUserremembermetimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUserremembermetimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTotpsecretkeylength_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavTotpsecretkeylength_Internalname, httpContext.getMessage( "WWP_GAM_TOTPSecretKeyLength", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavTotpsecretkeylength_Internalname, GXutil.ltrim( localUtil.ntoc( AV50TOTPSecretKeyLength, (byte)(12), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavTotpsecretkeylength_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV50TOTPSecretKeyLength), "ZZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV50TOTPSecretKeyLength), "ZZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,138);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTotpsecretkeylength_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavTotpsecretkeylength_Enabled, 0, "text", "1", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMKeyNumLong", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divRequiredemail_cell_Internalname, 1, 0, "px", 0, "px", divRequiredemail_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", chkavRequiredemail.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRequiredemail.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavRequiredemail.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRequiredemail.getInternalname(), GXutil.booltostr( AV64RequiredEmail), "", " ", chkavRequiredemail.getVisible(), chkavRequiredemail.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Requiredemail", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(143, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,143);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRequiredpassword.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavRequiredpassword.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRequiredpassword.getInternalname(), GXutil.booltostr( AV68RequiredPassword), "", " ", 1, chkavRequiredpassword.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Requiredpassword", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(147, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,147);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRequiredfirstname.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavRequiredfirstname.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 152,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRequiredfirstname.getInternalname(), GXutil.booltostr( AV65RequiredFirstName), "", " ", 1, chkavRequiredfirstname.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Requiredfirstname", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(152, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,152);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRequiredlastname.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavRequiredlastname.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRequiredlastname.getInternalname(), GXutil.booltostr( AV67RequiredLastName), "", " ", 1, chkavRequiredlastname.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Requiredlastname", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(156, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,156);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRequiredbirthday.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavRequiredbirthday.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 161,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRequiredbirthday.getInternalname(), GXutil.booltostr( AV63RequiredBirthday), "", " ", 1, chkavRequiredbirthday.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_RequiredBirthday", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(161, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,161);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavRequiredgender.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavRequiredgender.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 165,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavRequiredgender.getInternalname(), GXutil.booltostr( AV66RequiredGender), "", " ", 1, chkavRequiredgender.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_RequiredGender", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(165, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,165);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblSession_title_Internalname, httpContext.getMessage( "WWP_GAM_Session", ""), "", "", lblSession_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryConfiguration.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Session") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 175,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavGeneratesessionstatistics, cmbavGeneratesessionstatistics.getInternalname(), GXutil.rtrim( AV42GenerateSessionStatistics), 1, cmbavGeneratesessionstatistics.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavGeneratesessionstatistics.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,175);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavGeneratesessionstatistics.setValue( GXutil.rtrim( AV42GenerateSessionStatistics) );
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavUsersessioncachetimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavUsersessioncachetimeout_Internalname, httpContext.getMessage( "WWP_GAM_UserSessionCacheTimeoutSeconds", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 180,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavUsersessioncachetimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV86UserSessionCacheTimeout, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavUsersessioncachetimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV86UserSessionCacheTimeout), "ZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV86UserSessionCacheTimeout), "ZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,180);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavUsersessioncachetimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavUsersessioncachetimeout_Enabled, 0, "text", "1", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
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
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavGiveanonymoussession.getInternalname(), "  ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 185,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavGiveanonymoussession.getInternalname(), GXutil.booltostr( AV43GiveAnonymousSession), "", "  ", 1, chkavGiveanonymoussession.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GiveWebAnonymousSession", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(185, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,185);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavSessionexpiresonipchange.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavSessionexpiresonipchange.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 190,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSessionexpiresonipchange.getInternalname(), GXutil.booltostr( AV76SessionExpiresOnIPChange), "", " ", 1, chkavSessionexpiresonipchange.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_GAMsessionexpiresonIPchange", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(190, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,190);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavLoginattemptstolocksession_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavLoginattemptstolocksession_Internalname, httpContext.getMessage( "WWP_GAM_Loginretriestolocksession", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 195,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavLoginattemptstolocksession_Internalname, GXutil.ltrim( localUtil.ntoc( AV53LoginAttemptsToLockSession, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavLoginattemptstolocksession_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV53LoginAttemptsToLockSession), "Z9") : localUtil.format( DecimalUtil.doubleToDec(AV53LoginAttemptsToLockSession), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,195);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavLoginattemptstolocksession_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavLoginattemptstolocksession_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavMinimumamountcharactersinlogin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavMinimumamountcharactersinlogin_Internalname, httpContext.getMessage( "WWP_GAM_Minimumamountofcharactersinlogin", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 200,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavMinimumamountcharactersinlogin_Internalname, GXutil.ltrim( localUtil.ntoc( AV56MinimumAmountCharactersInLogin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavMinimumamountcharactersinlogin_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV56MinimumAmountCharactersInLogin), "Z9") : localUtil.format( DecimalUtil.doubleToDec(AV56MinimumAmountCharactersInLogin), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,200);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavMinimumamountcharactersinlogin_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavMinimumamountcharactersinlogin_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRepositorycachetimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavRepositorycachetimeout_Internalname, httpContext.getMessage( "WWP_GAM_CacheTimeoutMinutes", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 205,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavRepositorycachetimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV61RepositoryCacheTimeout, (byte)(9), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavRepositorycachetimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV61RepositoryCacheTimeout), "ZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV61RepositoryCacheTimeout), "ZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,205);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRepositorycachetimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavRepositorycachetimeout_Enabled, 0, "text", "1", 9, "chr", 1, "row", 9, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavIntsecbydomainenable.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavIntsecbydomainenable.getInternalname(), httpContext.getMessage( "WWP_GAM_EnableIntegratedSecurityByDomain", ""), " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 210,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavIntsecbydomainenable.getInternalname(), GXutil.booltostr( AV51IntSecByDomainEnable), "", httpContext.getMessage( "WWP_GAM_EnableIntegratedSecurityByDomain", ""), 1, chkavIntsecbydomainenable.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,210);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTblintsecbydomain_Internalname, divTblintsecbydomain_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavIntsecbydomainmode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbavIntsecbydomainmode.getInternalname(), httpContext.getMessage( "WWP_GAM_IntegratedSecurityByDomainMode", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 218,'',false,'',0)\"" ;
         /* ComboBox */
         com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavIntsecbydomainmode, cmbavIntsecbydomainmode.getInternalname(), GXutil.rtrim( AV49IntSecByDomainMode), 1, cmbavIntsecbydomainmode.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavIntsecbydomainmode.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,218);\"", "", true, (byte)(0), "HLP_GAMRepositoryConfiguration.htm");
         cmbavIntsecbydomainmode.setValue( GXutil.rtrim( AV49IntSecByDomainMode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIntsecbydomainmode.getInternalname(), "Values", cmbavIntsecbydomainmode.ToJavascriptSource(), true);
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavIntsecbydomainjwtsecret_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavIntsecbydomainjwtsecret_Internalname, httpContext.getMessage( "WWP_GAM_IntegratedSecurityByDomainSecret", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavIntsecbydomainjwtsecret_Internalname, AV48IntSecByDomainJWTSecret, GXutil.rtrim( localUtil.format( AV48IntSecByDomainJWTSecret, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,223);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavIntsecbydomainjwtsecret_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavIntsecbydomainjwtsecret_Enabled, 0, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavIntsecbydomainencryptionkey_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavIntsecbydomainencryptionkey_Internalname, httpContext.getMessage( "WWP_GAM_IntegratedSecurityByDomainEncriptionKey", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 228,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavIntsecbydomainencryptionkey_Internalname, AV47IntSecByDomainEncryptionKey, GXutil.rtrim( localUtil.format( AV47IntSecByDomainEncryptionKey, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,228);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavIntsecbydomainencryptionkey_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavIntsecbydomainencryptionkey_Enabled, 0, "text", "", 0, "px", 1, "row", 2048, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMPropertyValue", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
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
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTabemail_title_Internalname, httpContext.getMessage( "WWP_GAM_Email", ""), "", "", lblTabemail_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_GAMRepositoryConfiguration.htm");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabEmail") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserverhost_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserverhost_Internalname, httpContext.getMessage( "WWP_GAM_ServerHost", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 238,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserverhost_Internalname, GXutil.rtrim( AV28EmailServerHost), GXutil.rtrim( localUtil.format( AV28EmailServerHost, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,238);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserverhost_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEmailserverhost_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserverport_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserverport_Internalname, httpContext.getMessage( "WWP_GAM_Serverport", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 242,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserverport_Internalname, GXutil.ltrim( localUtil.ntoc( AV29EmailServerPort, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavEmailserverport_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV29EmailServerPort), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV29EmailServerPort), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,242);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserverport_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEmailserverport_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailservertimeout_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailservertimeout_Internalname, httpContext.getMessage( "WWP_GAM_TimeoutSeconds", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 247,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailservertimeout_Internalname, GXutil.ltrim( localUtil.ntoc( AV31EmailServerTimeout, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavEmailservertimeout_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV31EmailServerTimeout), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV31EmailServerTimeout), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,247);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailservertimeout_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavEmailservertimeout_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmailserversecure.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEmailserversecure.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 251,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmailserversecure.getInternalname(), GXutil.booltostr( AV30EmailServerSecure), "", " ", 1, chkavEmailserversecure.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_Secure", ""), StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(251, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,251);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavServersenderaddress_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavServersenderaddress_Internalname, httpContext.getMessage( "WWP_GAM_SenderEmailAddress", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 256,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavServersenderaddress_Internalname, AV74ServerSenderAddress, GXutil.rtrim( localUtil.format( AV74ServerSenderAddress, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,256);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavServersenderaddress_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavServersenderaddress_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXusSecurityCommon\\GAMEMail", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavServersendername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavServersendername_Internalname, httpContext.getMessage( "WWP_GAM_SenderName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 260,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavServersendername_Internalname, GXutil.rtrim( AV75ServerSenderName), GXutil.rtrim( localUtil.format( AV75ServerSenderName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,260);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavServersendername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtavServersendername_Enabled, 0, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionMedium", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmailserverusesauthentication.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEmailserverusesauthentication.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 265,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmailserverusesauthentication.getInternalname(), GXutil.booltostr( AV32EmailServerUsesAuthentication), "", " ", 1, chkavEmailserverusesauthentication.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_ServerRequireAudthentication", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,265);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserverauthenticationusername_cell_Internalname, 1, 0, "px", 0, "px", divEmailserverauthenticationusername_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserverauthenticationusername_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserverauthenticationusername_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserverauthenticationusername_Internalname, httpContext.getMessage( "WWP_GAM_UserName", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 270,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserverauthenticationusername_Internalname, GXutil.rtrim( AV26EmailServerAuthenticationUsername), GXutil.rtrim( localUtil.format( AV26EmailServerAuthenticationUsername, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,270);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserverauthenticationusername_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailserverauthenticationusername_Visible, edtavEmailserverauthenticationusername_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionShort", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserverauthenticationuserpassword_cell_Internalname, 1, 0, "px", 0, "px", divEmailserverauthenticationuserpassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserverauthenticationuserpassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserverauthenticationuserpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserverauthenticationuserpassword_Internalname, httpContext.getMessage( "WWP_GAM_Password", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 274,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserverauthenticationuserpassword_Internalname, GXutil.rtrim( AV27EmailServerAuthenticationUserPassword), GXutil.rtrim( localUtil.format( AV27EmailServerAuthenticationUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,274);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserverauthenticationuserpassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailserverauthenticationuserpassword_Visible, edtavEmailserverauthenticationuserpassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "GeneXusSecurityCommon\\GAMPassword", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmailserver_sendemailwhenuseractivateaccount.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEmailserver_sendemailwhenuseractivateaccount.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 279,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmailserver_sendemailwhenuseractivateaccount.getInternalname(), GXutil.booltostr( AV23EmailServer_SendEmailWhenUserActivateAccount), "", " ", 1, chkavEmailserver_sendemailwhenuseractivateaccount.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_SendEmailUserActivateAccount", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,279);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailsubjectwhenuseractivateaccount_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname, httpContext.getMessage( "WWP_GAM_EmailSubjectActivateUserAccount", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 283,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname, GXutil.rtrim( AV19EmailServer_EmailSubjectWhenUserActivateAccount), GXutil.rtrim( localUtil.format( AV19EmailServer_EmailSubjectWhenUserActivateAccount, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,283);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserver_emailsubjectwhenuseractivateaccount_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible, edtavEmailserver_emailsubjectwhenuseractivateaccount_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailbodywhenuseractivateaccount_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailbodywhenuseractivateaccount_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailbodywhenuseractivateaccount_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailbodywhenuseractivateaccount_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailbodywhenuseractivateaccount_Internalname, httpContext.getMessage( "WWP_GAM_EmailBodyActivateUserAccount", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 288,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavEmailserver_emailbodywhenuseractivateaccount_Internalname, AV15EmailServer_EmailBodyWhenUserActivateAccount, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,288);\"", (short)(0), edtavEmailserver_emailbodywhenuseractivateaccount_Visible, edtavEmailserver_emailbodywhenuseractivateaccount_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "800", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmailserver_sendemailwhenuserchangepassword.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEmailserver_sendemailwhenuserchangepassword.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 292,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmailserver_sendemailwhenuserchangepassword.getInternalname(), GXutil.booltostr( AV25EmailServer_SendEmailWhenUserChangePassword), "", " ", 1, chkavEmailserver_sendemailwhenuserchangepassword.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_SendEmailUserChangePassword", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,292);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailsubjectwhenuserchangepassword_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailsubjectwhenuserchangepassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailsubjectwhenuserchangepassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname, httpContext.getMessage( "WWP_GAM_EmailSubjectChangeUserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 297,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname, GXutil.rtrim( AV21EmailServer_EmailSubjectWhenUserChangePassword), GXutil.rtrim( localUtil.format( AV21EmailServer_EmailSubjectWhenUserChangePassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,297);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserver_emailsubjectwhenuserchangepassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailserver_emailsubjectwhenuserchangepassword_Visible, edtavEmailserver_emailsubjectwhenuserchangepassword_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailbodywhenuserchangepassword_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailbodywhenuserchangepassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailbodywhenuserchangepassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailbodywhenuserchangepassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailbodywhenuserchangepassword_Internalname, httpContext.getMessage( "WWP_GAM_EmailBodyChangeUserPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 301,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavEmailserver_emailbodywhenuserchangepassword_Internalname, AV17EmailServer_EmailBodyWhenUserChangePassword, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,301);\"", (short)(0), edtavEmailserver_emailbodywhenuserchangepassword_Visible, edtavEmailserver_emailbodywhenuserchangepassword_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "800", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmailserver_sendemailwhenuserchangeemail.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEmailserver_sendemailwhenuserchangeemail.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 306,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmailserver_sendemailwhenuserchangeemail.getInternalname(), GXutil.booltostr( AV24EmailServer_SendEmailWhenUserChangeEmail), "", " ", 1, chkavEmailserver_sendemailwhenuserchangeemail.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_SendEmailUserChangeEmailUsername", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,306);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailsubjectwhenuserchangeemail_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailsubjectwhenuserchangeemail_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailsubjectwhenuserchangeemail_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname, httpContext.getMessage( "WWP_GAM_EmailSubjectChangeEmailUsername", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 310,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname, GXutil.rtrim( AV20EmailServer_EmailSubjectWhenUserChangeEmail), GXutil.rtrim( localUtil.format( AV20EmailServer_EmailSubjectWhenUserChangeEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,310);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserver_emailsubjectwhenuserchangeemail_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailserver_emailsubjectwhenuserchangeemail_Visible, edtavEmailserver_emailsubjectwhenuserchangeemail_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailbodywhenuserchangeemail_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailbodywhenuserchangeemail_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailbodywhenuserchangeemail_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailbodywhenuserchangeemail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailbodywhenuserchangeemail_Internalname, httpContext.getMessage( "WWP_GAM_EmailBodyChangeEmailUsername", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 315,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavEmailserver_emailbodywhenuserchangeemail_Internalname, AV16EmailServer_EmailBodyWhenUserChangeEmail, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,315);\"", (short)(0), edtavEmailserver_emailbodywhenuserchangeemail_Visible, edtavEmailserver_emailbodywhenuserchangeemail_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "800", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavEmailserver_sendemailforrecoverypassword.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, chkavEmailserver_sendemailforrecoverypassword.getInternalname(), " ", " AttributeRealWidthCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 319,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidthCheckBox" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkavEmailserver_sendemailforrecoverypassword.getInternalname(), GXutil.booltostr( AV22EmailServer_SendEmailForRecoveryPassword), "", " ", 1, chkavEmailserver_sendemailforrecoverypassword.getEnabled(), "true", httpContext.getMessage( "WWP_GAM_SendEmailRecoveryPassword", ""), StyleString, ClassString, "", "", TempTags+" onblur=\""+""+";gx.evt.onblur(this,319);\"");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailsubjectforrecoverypassword_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailsubjectforrecoverypassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailsubjectforrecoverypassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailsubjectforrecoverypassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailsubjectforrecoverypassword_Internalname, httpContext.getMessage( "WWP_GAM_EmailSubjectRecoveryPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 324,'',false,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavEmailserver_emailsubjectforrecoverypassword_Internalname, GXutil.rtrim( AV18EmailServer_EmailSubjectForRecoveryPassword), GXutil.rtrim( localUtil.format( AV18EmailServer_EmailSubjectForRecoveryPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,324);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmailserver_emailsubjectforrecoverypassword_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", edtavEmailserver_emailsubjectforrecoverypassword_Visible, edtavEmailserver_emailsubjectforrecoverypassword_Enabled, 0, "text", "", 0, "px", 1, "row", 254, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "GeneXusSecurityCommon\\GAMDescriptionLong", "left", true, "", "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divEmailserver_emailbodyforrecoverypassword_cell_Internalname, 1, 0, "px", 0, "px", divEmailserver_emailbodyforrecoverypassword_cell_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", edtavEmailserver_emailbodyforrecoverypassword_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEmailserver_emailbodyforrecoverypassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavEmailserver_emailbodyforrecoverypassword_Internalname, httpContext.getMessage( "WWP_GAM_EmailBodyRecoveryPassword", ""), " AttributeRealWidthLabel", 1, true, "");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 328,'',false,'',0)\"" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         ClassString = "AttributeRealWidth" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtavEmailserver_emailbodyforrecoverypassword_Internalname, AV14EmailServer_EmailBodyForRecoveryPassword, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,328);\"", (short)(0), edtavEmailserver_emailbodyforrecoverypassword_Visible, edtavEmailserver_emailbodyforrecoverypassword_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "800", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_GAMRepositoryConfiguration.htm");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group CellMarginTop10", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 333,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtnenter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRepositoryConfiguration.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 335,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtncancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_GAMRepositoryConfiguration.htm");
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

   public void start342( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Repository configuration ", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup340( ) ;
   }

   public void ws342( )
   {
      start342( ) ;
      evt342( ) ;
   }

   public void evt342( )
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
                           e11342 ();
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
                                 e12342 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VUSERIDENTIFICATION.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13342 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VEMAILSERVERUSESAUTHENTICATION.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14342 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e15342 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e16342 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e17342 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18342 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e19342 ();
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

   public void we342( )
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

   public void pa342( )
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
            GX_FocusControl = edtavRepoid_Internalname ;
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
      if ( cmbavEnabletracing.getItemCount() > 0 )
      {
         AV33EnableTracing = cmbavEnabletracing.getValidValue(AV33EnableTracing) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33EnableTracing", AV33EnableTracing);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEnabletracing.setValue( GXutil.rtrim( AV33EnableTracing) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEnabletracing.getInternalname(), "Values", cmbavEnabletracing.ToJavascriptSource(), true);
      }
      if ( cmbavDefaultauthtypename.getItemCount() > 0 )
      {
         AV10DefaultAuthTypeName = cmbavDefaultauthtypename.getValidValue(AV10DefaultAuthTypeName) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10DefaultAuthTypeName", AV10DefaultAuthTypeName);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDefaultauthtypename.setValue( GXutil.rtrim( AV10DefaultAuthTypeName) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultauthtypename.getInternalname(), "Values", cmbavDefaultauthtypename.ToJavascriptSource(), true);
      }
      if ( cmbavDefaultroleid.getItemCount() > 0 )
      {
         AV11DefaultRoleId = GXutil.lval( cmbavDefaultroleid.getValidValue(GXutil.trim( GXutil.str( AV11DefaultRoleId, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11DefaultRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DefaultRoleId), 12, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDefaultroleid.setValue( GXutil.trim( GXutil.str( AV11DefaultRoleId, 12, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultroleid.getInternalname(), "Values", cmbavDefaultroleid.ToJavascriptSource(), true);
      }
      if ( cmbavDefaultsecuritypolicyid.getItemCount() > 0 )
      {
         AV12DefaultSecurityPolicyId = (int)(GXutil.lval( cmbavDefaultsecuritypolicyid.getValidValue(GXutil.trim( GXutil.str( AV12DefaultSecurityPolicyId, 9, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12DefaultSecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12DefaultSecurityPolicyId), 9, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDefaultsecuritypolicyid.setValue( GXutil.trim( GXutil.str( AV12DefaultSecurityPolicyId, 9, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultsecuritypolicyid.getInternalname(), "Values", cmbavDefaultsecuritypolicyid.ToJavascriptSource(), true);
      }
      AV5AllowOauthAccess = GXutil.strtobool( GXutil.booltostr( AV5AllowOauthAccess)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AllowOauthAccess", AV5AllowOauthAccess);
      if ( cmbavLogoutbehavior.getItemCount() > 0 )
      {
         AV55LogoutBehavior = cmbavLogoutbehavior.getValidValue(AV55LogoutBehavior) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55LogoutBehavior", AV55LogoutBehavior);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavLogoutbehavior.setValue( GXutil.rtrim( AV55LogoutBehavior) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavLogoutbehavior.getInternalname(), "Values", cmbavLogoutbehavior.ToJavascriptSource(), true);
      }
      AV35EnableWorkingAsGAMManagerRepo = GXutil.strtobool( GXutil.booltostr( AV35EnableWorkingAsGAMManagerRepo)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35EnableWorkingAsGAMManagerRepo", AV35EnableWorkingAsGAMManagerRepo);
      if ( cmbavUseridentification.getItemCount() > 0 )
      {
         AV80UserIdentification = cmbavUseridentification.getValidValue(AV80UserIdentification) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80UserIdentification", AV80UserIdentification);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavUseridentification.setValue( GXutil.rtrim( AV80UserIdentification) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUseridentification.getInternalname(), "Values", cmbavUseridentification.ToJavascriptSource(), true);
      }
      AV79UserEmailisUnique = GXutil.strtobool( GXutil.booltostr( AV79UserEmailisUnique)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79UserEmailisUnique", AV79UserEmailisUnique);
      if ( cmbavUseractivationmethod.getItemCount() > 0 )
      {
         AV77UserActivationMethod = cmbavUseractivationmethod.getValidValue(AV77UserActivationMethod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV77UserActivationMethod", AV77UserActivationMethod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavUseractivationmethod.setValue( GXutil.rtrim( AV77UserActivationMethod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUseractivationmethod.getInternalname(), "Values", cmbavUseractivationmethod.ToJavascriptSource(), true);
      }
      if ( cmbavUserremembermetype.getItemCount() > 0 )
      {
         AV85UserRememberMeType = cmbavUserremembermetype.getValidValue(AV85UserRememberMeType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85UserRememberMeType", AV85UserRememberMeType);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavUserremembermetype.setValue( GXutil.rtrim( AV85UserRememberMeType) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUserremembermetype.getInternalname(), "Values", cmbavUserremembermetype.ToJavascriptSource(), true);
      }
      AV64RequiredEmail = GXutil.strtobool( GXutil.booltostr( AV64RequiredEmail)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64RequiredEmail", AV64RequiredEmail);
      AV68RequiredPassword = GXutil.strtobool( GXutil.booltostr( AV68RequiredPassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68RequiredPassword", AV68RequiredPassword);
      AV65RequiredFirstName = GXutil.strtobool( GXutil.booltostr( AV65RequiredFirstName)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65RequiredFirstName", AV65RequiredFirstName);
      AV67RequiredLastName = GXutil.strtobool( GXutil.booltostr( AV67RequiredLastName)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67RequiredLastName", AV67RequiredLastName);
      AV63RequiredBirthday = GXutil.strtobool( GXutil.booltostr( AV63RequiredBirthday)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63RequiredBirthday", AV63RequiredBirthday);
      AV66RequiredGender = GXutil.strtobool( GXutil.booltostr( AV66RequiredGender)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66RequiredGender", AV66RequiredGender);
      if ( cmbavGeneratesessionstatistics.getItemCount() > 0 )
      {
         AV42GenerateSessionStatistics = cmbavGeneratesessionstatistics.getValidValue(AV42GenerateSessionStatistics) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42GenerateSessionStatistics", AV42GenerateSessionStatistics);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavGeneratesessionstatistics.setValue( GXutil.rtrim( AV42GenerateSessionStatistics) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavGeneratesessionstatistics.getInternalname(), "Values", cmbavGeneratesessionstatistics.ToJavascriptSource(), true);
      }
      AV43GiveAnonymousSession = GXutil.strtobool( GXutil.booltostr( AV43GiveAnonymousSession)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43GiveAnonymousSession", AV43GiveAnonymousSession);
      AV76SessionExpiresOnIPChange = GXutil.strtobool( GXutil.booltostr( AV76SessionExpiresOnIPChange)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76SessionExpiresOnIPChange", AV76SessionExpiresOnIPChange);
      AV51IntSecByDomainEnable = GXutil.strtobool( GXutil.booltostr( AV51IntSecByDomainEnable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51IntSecByDomainEnable", AV51IntSecByDomainEnable);
      if ( cmbavIntsecbydomainmode.getItemCount() > 0 )
      {
         AV49IntSecByDomainMode = cmbavIntsecbydomainmode.getValidValue(AV49IntSecByDomainMode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49IntSecByDomainMode", AV49IntSecByDomainMode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavIntsecbydomainmode.setValue( GXutil.rtrim( AV49IntSecByDomainMode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIntsecbydomainmode.getInternalname(), "Values", cmbavIntsecbydomainmode.ToJavascriptSource(), true);
      }
      AV30EmailServerSecure = GXutil.strtobool( GXutil.booltostr( AV30EmailServerSecure)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30EmailServerSecure", AV30EmailServerSecure);
      AV32EmailServerUsesAuthentication = GXutil.strtobool( GXutil.booltostr( AV32EmailServerUsesAuthentication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32EmailServerUsesAuthentication", AV32EmailServerUsesAuthentication);
      AV23EmailServer_SendEmailWhenUserActivateAccount = GXutil.strtobool( GXutil.booltostr( AV23EmailServer_SendEmailWhenUserActivateAccount)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23EmailServer_SendEmailWhenUserActivateAccount", AV23EmailServer_SendEmailWhenUserActivateAccount);
      AV25EmailServer_SendEmailWhenUserChangePassword = GXutil.strtobool( GXutil.booltostr( AV25EmailServer_SendEmailWhenUserChangePassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25EmailServer_SendEmailWhenUserChangePassword", AV25EmailServer_SendEmailWhenUserChangePassword);
      AV24EmailServer_SendEmailWhenUserChangeEmail = GXutil.strtobool( GXutil.booltostr( AV24EmailServer_SendEmailWhenUserChangeEmail)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24EmailServer_SendEmailWhenUserChangeEmail", AV24EmailServer_SendEmailWhenUserChangeEmail);
      AV22EmailServer_SendEmailForRecoveryPassword = GXutil.strtobool( GXutil.booltostr( AV22EmailServer_SendEmailForRecoveryPassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22EmailServer_SendEmailForRecoveryPassword", AV22EmailServer_SendEmailForRecoveryPassword);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf342( ) ;
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
      edtavRepoid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavRepoid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRepoid_Enabled), 5, 0), true);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
      edtavNamespace_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Enabled), 5, 0), true);
   }

   public void rf342( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e19342 ();
         wb340( ) ;
      }
   }

   public void send_integrity_lvl_hashes342( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSECURITYADMINISTRATOREMAIL", AV71SecurityAdministratorEmail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECURITYADMINISTRATOREMAIL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71SecurityAdministratorEmail, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vCANREGISTERUSERS", AV9CanRegisterUsers);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCANREGISTERUSERS", getSecureSignedToken( "", AV9CanRegisterUsers));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavRepoid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavRepoid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavRepoid_Enabled), 5, 0), true);
      edtavGuid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGuid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGuid_Enabled), 5, 0), true);
      edtavNamespace_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNamespace_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNamespace_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup340( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11342 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Gxuitabspanel_tabs_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABS_Pagecount"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gxuitabspanel_tabs_Class = httpContext.cgiGet( "GXUITABSPANEL_TABS_Class") ;
         Gxuitabspanel_tabs_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABS_Historymanagement")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavRepoid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavRepoid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vREPOID");
            GX_FocusControl = edtavRepoid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV59RepoId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59RepoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59RepoId), 12, 0));
         }
         else
         {
            AV59RepoId = localUtil.ctol( httpContext.cgiGet( edtavRepoid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59RepoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59RepoId), 12, 0));
         }
         AV44GUID = httpContext.cgiGet( edtavGuid_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44GUID", AV44GUID);
         AV58NameSpace = httpContext.cgiGet( edtavNamespace_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58NameSpace", AV58NameSpace);
         AV57Name = httpContext.cgiGet( edtavName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV57Name", AV57Name);
         AV13Dsc = httpContext.cgiGet( edtavDsc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Dsc", AV13Dsc);
         cmbavEnabletracing.setValue( httpContext.cgiGet( cmbavEnabletracing.getInternalname()) );
         AV33EnableTracing = httpContext.cgiGet( cmbavEnabletracing.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33EnableTracing", AV33EnableTracing);
         AV6AuthenticationMasterRepository = httpContext.cgiGet( edtavAuthenticationmasterrepository_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6AuthenticationMasterRepository", AV6AuthenticationMasterRepository);
         cmbavDefaultauthtypename.setValue( httpContext.cgiGet( cmbavDefaultauthtypename.getInternalname()) );
         AV10DefaultAuthTypeName = httpContext.cgiGet( cmbavDefaultauthtypename.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10DefaultAuthTypeName", AV10DefaultAuthTypeName);
         cmbavDefaultroleid.setValue( httpContext.cgiGet( cmbavDefaultroleid.getInternalname()) );
         AV11DefaultRoleId = GXutil.lval( httpContext.cgiGet( cmbavDefaultroleid.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11DefaultRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DefaultRoleId), 12, 0));
         cmbavDefaultsecuritypolicyid.setValue( httpContext.cgiGet( cmbavDefaultsecuritypolicyid.getInternalname()) );
         AV12DefaultSecurityPolicyId = (int)(GXutil.lval( httpContext.cgiGet( cmbavDefaultsecuritypolicyid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12DefaultSecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12DefaultSecurityPolicyId), 9, 0));
         AV5AllowOauthAccess = GXutil.strtobool( httpContext.cgiGet( chkavAllowoauthaccess.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AllowOauthAccess", AV5AllowOauthAccess);
         cmbavLogoutbehavior.setValue( httpContext.cgiGet( cmbavLogoutbehavior.getInternalname()) );
         AV55LogoutBehavior = httpContext.cgiGet( cmbavLogoutbehavior.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55LogoutBehavior", AV55LogoutBehavior);
         AV35EnableWorkingAsGAMManagerRepo = GXutil.strtobool( httpContext.cgiGet( chkavEnableworkingasgammanagerrepo.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35EnableWorkingAsGAMManagerRepo", AV35EnableWorkingAsGAMManagerRepo);
         cmbavUseridentification.setValue( httpContext.cgiGet( cmbavUseridentification.getInternalname()) );
         AV80UserIdentification = httpContext.cgiGet( cmbavUseridentification.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80UserIdentification", AV80UserIdentification);
         AV79UserEmailisUnique = GXutil.strtobool( httpContext.cgiGet( chkavUseremailisunique.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV79UserEmailisUnique", AV79UserEmailisUnique);
         cmbavUseractivationmethod.setValue( httpContext.cgiGet( cmbavUseractivationmethod.getInternalname()) );
         AV77UserActivationMethod = httpContext.cgiGet( cmbavUseractivationmethod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV77UserActivationMethod", AV77UserActivationMethod);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavUserautomaticactivationtimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavUserautomaticactivationtimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vUSERAUTOMATICACTIVATIONTIMEOUT");
            GX_FocusControl = edtavUserautomaticactivationtimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV78UserAutomaticActivationTimeout = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78UserAutomaticActivationTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78UserAutomaticActivationTimeout), 4, 0));
         }
         else
         {
            AV78UserAutomaticActivationTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtavUserautomaticactivationtimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV78UserAutomaticActivationTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78UserAutomaticActivationTimeout), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeytimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeytimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vUSERRECOVERYPASSWORDKEYTIMEOUT");
            GX_FocusControl = edtavUserrecoverypasswordkeytimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV81UserRecoveryPasswordKeyTimeOut = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81UserRecoveryPasswordKeyTimeOut", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81UserRecoveryPasswordKeyTimeOut), 4, 0));
         }
         else
         {
            AV81UserRecoveryPasswordKeyTimeOut = (short)(localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeytimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81UserRecoveryPasswordKeyTimeOut", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81UserRecoveryPasswordKeyTimeOut), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeydailymaximum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeydailymaximum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vUSERRECOVERYPASSWORDKEYDAILYMAXIMUM");
            GX_FocusControl = edtavUserrecoverypasswordkeydailymaximum_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV82UserRecoveryPasswordKeyDailyMaximum = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82UserRecoveryPasswordKeyDailyMaximum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82UserRecoveryPasswordKeyDailyMaximum), 4, 0));
         }
         else
         {
            AV82UserRecoveryPasswordKeyDailyMaximum = (short)(localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeydailymaximum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82UserRecoveryPasswordKeyDailyMaximum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82UserRecoveryPasswordKeyDailyMaximum), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeymonthlymaximum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeymonthlymaximum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vUSERRECOVERYPASSWORDKEYMONTHLYMAXIMUM");
            GX_FocusControl = edtavUserrecoverypasswordkeymonthlymaximum_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV83UserRecoveryPasswordKeyMonthlyMaximum = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83UserRecoveryPasswordKeyMonthlyMaximum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83UserRecoveryPasswordKeyMonthlyMaximum), 4, 0));
         }
         else
         {
            AV83UserRecoveryPasswordKeyMonthlyMaximum = (short)(localUtil.ctol( httpContext.cgiGet( edtavUserrecoverypasswordkeymonthlymaximum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83UserRecoveryPasswordKeyMonthlyMaximum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83UserRecoveryPasswordKeyMonthlyMaximum), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLoginattemptstolockuser_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLoginattemptstolockuser_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLOGINATTEMPTSTOLOCKUSER");
            GX_FocusControl = edtavLoginattemptstolockuser_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV54LoginAttemptsToLockUser = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54LoginAttemptsToLockUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54LoginAttemptsToLockUser), 2, 0));
         }
         else
         {
            AV54LoginAttemptsToLockUser = (byte)(localUtil.ctol( httpContext.cgiGet( edtavLoginattemptstolockuser_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV54LoginAttemptsToLockUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54LoginAttemptsToLockUser), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGamunblockusertimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGamunblockusertimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGAMUNBLOCKUSERTIMEOUT");
            GX_FocusControl = edtavGamunblockusertimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV41GAMUnblockUserTimeout = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41GAMUnblockUserTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41GAMUnblockUserTimeout), 4, 0));
         }
         else
         {
            AV41GAMUnblockUserTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtavGamunblockusertimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41GAMUnblockUserTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41GAMUnblockUserTimeout), 4, 0));
         }
         cmbavUserremembermetype.setValue( httpContext.cgiGet( cmbavUserremembermetype.getInternalname()) );
         AV85UserRememberMeType = httpContext.cgiGet( cmbavUserremembermetype.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85UserRememberMeType", AV85UserRememberMeType);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavUserremembermetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavUserremembermetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vUSERREMEMBERMETIMEOUT");
            GX_FocusControl = edtavUserremembermetimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV84UserRememberMeTimeOut = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84UserRememberMeTimeOut", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84UserRememberMeTimeOut), 4, 0));
         }
         else
         {
            AV84UserRememberMeTimeOut = (short)(localUtil.ctol( httpContext.cgiGet( edtavUserremembermetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84UserRememberMeTimeOut", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84UserRememberMeTimeOut), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTotpsecretkeylength_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTotpsecretkeylength_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTOTPSECRETKEYLENGTH");
            GX_FocusControl = edtavTotpsecretkeylength_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV50TOTPSecretKeyLength = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TOTPSecretKeyLength", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TOTPSecretKeyLength), 12, 0));
         }
         else
         {
            AV50TOTPSecretKeyLength = localUtil.ctol( httpContext.cgiGet( edtavTotpsecretkeylength_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV50TOTPSecretKeyLength", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TOTPSecretKeyLength), 12, 0));
         }
         AV64RequiredEmail = GXutil.strtobool( httpContext.cgiGet( chkavRequiredemail.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64RequiredEmail", AV64RequiredEmail);
         AV68RequiredPassword = GXutil.strtobool( httpContext.cgiGet( chkavRequiredpassword.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68RequiredPassword", AV68RequiredPassword);
         AV65RequiredFirstName = GXutil.strtobool( httpContext.cgiGet( chkavRequiredfirstname.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65RequiredFirstName", AV65RequiredFirstName);
         AV67RequiredLastName = GXutil.strtobool( httpContext.cgiGet( chkavRequiredlastname.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV67RequiredLastName", AV67RequiredLastName);
         AV63RequiredBirthday = GXutil.strtobool( httpContext.cgiGet( chkavRequiredbirthday.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63RequiredBirthday", AV63RequiredBirthday);
         AV66RequiredGender = GXutil.strtobool( httpContext.cgiGet( chkavRequiredgender.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV66RequiredGender", AV66RequiredGender);
         cmbavGeneratesessionstatistics.setValue( httpContext.cgiGet( cmbavGeneratesessionstatistics.getInternalname()) );
         AV42GenerateSessionStatistics = httpContext.cgiGet( cmbavGeneratesessionstatistics.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42GenerateSessionStatistics", AV42GenerateSessionStatistics);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavUsersessioncachetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavUsersessioncachetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vUSERSESSIONCACHETIMEOUT");
            GX_FocusControl = edtavUsersessioncachetimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV86UserSessionCacheTimeout = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86UserSessionCacheTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86UserSessionCacheTimeout), 9, 0));
         }
         else
         {
            AV86UserSessionCacheTimeout = (int)(localUtil.ctol( httpContext.cgiGet( edtavUsersessioncachetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV86UserSessionCacheTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86UserSessionCacheTimeout), 9, 0));
         }
         AV43GiveAnonymousSession = GXutil.strtobool( httpContext.cgiGet( chkavGiveanonymoussession.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43GiveAnonymousSession", AV43GiveAnonymousSession);
         AV76SessionExpiresOnIPChange = GXutil.strtobool( httpContext.cgiGet( chkavSessionexpiresonipchange.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV76SessionExpiresOnIPChange", AV76SessionExpiresOnIPChange);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavLoginattemptstolocksession_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavLoginattemptstolocksession_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vLOGINATTEMPTSTOLOCKSESSION");
            GX_FocusControl = edtavLoginattemptstolocksession_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV53LoginAttemptsToLockSession = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53LoginAttemptsToLockSession", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53LoginAttemptsToLockSession), 2, 0));
         }
         else
         {
            AV53LoginAttemptsToLockSession = (byte)(localUtil.ctol( httpContext.cgiGet( edtavLoginattemptstolocksession_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53LoginAttemptsToLockSession", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53LoginAttemptsToLockSession), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavMinimumamountcharactersinlogin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavMinimumamountcharactersinlogin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vMINIMUMAMOUNTCHARACTERSINLOGIN");
            GX_FocusControl = edtavMinimumamountcharactersinlogin_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV56MinimumAmountCharactersInLogin = (byte)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56MinimumAmountCharactersInLogin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56MinimumAmountCharactersInLogin), 2, 0));
         }
         else
         {
            AV56MinimumAmountCharactersInLogin = (byte)(localUtil.ctol( httpContext.cgiGet( edtavMinimumamountcharactersinlogin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV56MinimumAmountCharactersInLogin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56MinimumAmountCharactersInLogin), 2, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavRepositorycachetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavRepositorycachetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vREPOSITORYCACHETIMEOUT");
            GX_FocusControl = edtavRepositorycachetimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV61RepositoryCacheTimeout = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61RepositoryCacheTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61RepositoryCacheTimeout), 9, 0));
         }
         else
         {
            AV61RepositoryCacheTimeout = (int)(localUtil.ctol( httpContext.cgiGet( edtavRepositorycachetimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61RepositoryCacheTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61RepositoryCacheTimeout), 9, 0));
         }
         AV51IntSecByDomainEnable = GXutil.strtobool( httpContext.cgiGet( chkavIntsecbydomainenable.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51IntSecByDomainEnable", AV51IntSecByDomainEnable);
         cmbavIntsecbydomainmode.setValue( httpContext.cgiGet( cmbavIntsecbydomainmode.getInternalname()) );
         AV49IntSecByDomainMode = httpContext.cgiGet( cmbavIntsecbydomainmode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49IntSecByDomainMode", AV49IntSecByDomainMode);
         AV48IntSecByDomainJWTSecret = httpContext.cgiGet( edtavIntsecbydomainjwtsecret_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48IntSecByDomainJWTSecret", AV48IntSecByDomainJWTSecret);
         AV47IntSecByDomainEncryptionKey = httpContext.cgiGet( edtavIntsecbydomainencryptionkey_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47IntSecByDomainEncryptionKey", AV47IntSecByDomainEncryptionKey);
         AV28EmailServerHost = httpContext.cgiGet( edtavEmailserverhost_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28EmailServerHost", AV28EmailServerHost);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmailserverport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmailserverport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vEMAILSERVERPORT");
            GX_FocusControl = edtavEmailserverport_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV29EmailServerPort = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29EmailServerPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29EmailServerPort), 4, 0));
         }
         else
         {
            AV29EmailServerPort = (short)(localUtil.ctol( httpContext.cgiGet( edtavEmailserverport_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29EmailServerPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29EmailServerPort), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmailservertimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmailservertimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vEMAILSERVERTIMEOUT");
            GX_FocusControl = edtavEmailservertimeout_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV31EmailServerTimeout = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31EmailServerTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31EmailServerTimeout), 4, 0));
         }
         else
         {
            AV31EmailServerTimeout = (short)(localUtil.ctol( httpContext.cgiGet( edtavEmailservertimeout_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31EmailServerTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31EmailServerTimeout), 4, 0));
         }
         AV30EmailServerSecure = GXutil.strtobool( httpContext.cgiGet( chkavEmailserversecure.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30EmailServerSecure", AV30EmailServerSecure);
         AV74ServerSenderAddress = httpContext.cgiGet( edtavServersenderaddress_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV74ServerSenderAddress", AV74ServerSenderAddress);
         AV75ServerSenderName = httpContext.cgiGet( edtavServersendername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75ServerSenderName", AV75ServerSenderName);
         AV32EmailServerUsesAuthentication = GXutil.strtobool( httpContext.cgiGet( chkavEmailserverusesauthentication.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32EmailServerUsesAuthentication", AV32EmailServerUsesAuthentication);
         AV26EmailServerAuthenticationUsername = httpContext.cgiGet( edtavEmailserverauthenticationusername_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26EmailServerAuthenticationUsername", AV26EmailServerAuthenticationUsername);
         AV27EmailServerAuthenticationUserPassword = httpContext.cgiGet( edtavEmailserverauthenticationuserpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27EmailServerAuthenticationUserPassword", AV27EmailServerAuthenticationUserPassword);
         AV23EmailServer_SendEmailWhenUserActivateAccount = GXutil.strtobool( httpContext.cgiGet( chkavEmailserver_sendemailwhenuseractivateaccount.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23EmailServer_SendEmailWhenUserActivateAccount", AV23EmailServer_SendEmailWhenUserActivateAccount);
         AV19EmailServer_EmailSubjectWhenUserActivateAccount = httpContext.cgiGet( edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19EmailServer_EmailSubjectWhenUserActivateAccount", AV19EmailServer_EmailSubjectWhenUserActivateAccount);
         AV15EmailServer_EmailBodyWhenUserActivateAccount = httpContext.cgiGet( edtavEmailserver_emailbodywhenuseractivateaccount_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15EmailServer_EmailBodyWhenUserActivateAccount", AV15EmailServer_EmailBodyWhenUserActivateAccount);
         AV25EmailServer_SendEmailWhenUserChangePassword = GXutil.strtobool( httpContext.cgiGet( chkavEmailserver_sendemailwhenuserchangepassword.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25EmailServer_SendEmailWhenUserChangePassword", AV25EmailServer_SendEmailWhenUserChangePassword);
         AV21EmailServer_EmailSubjectWhenUserChangePassword = httpContext.cgiGet( edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21EmailServer_EmailSubjectWhenUserChangePassword", AV21EmailServer_EmailSubjectWhenUserChangePassword);
         AV17EmailServer_EmailBodyWhenUserChangePassword = httpContext.cgiGet( edtavEmailserver_emailbodywhenuserchangepassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17EmailServer_EmailBodyWhenUserChangePassword", AV17EmailServer_EmailBodyWhenUserChangePassword);
         AV24EmailServer_SendEmailWhenUserChangeEmail = GXutil.strtobool( httpContext.cgiGet( chkavEmailserver_sendemailwhenuserchangeemail.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24EmailServer_SendEmailWhenUserChangeEmail", AV24EmailServer_SendEmailWhenUserChangeEmail);
         AV20EmailServer_EmailSubjectWhenUserChangeEmail = httpContext.cgiGet( edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20EmailServer_EmailSubjectWhenUserChangeEmail", AV20EmailServer_EmailSubjectWhenUserChangeEmail);
         AV16EmailServer_EmailBodyWhenUserChangeEmail = httpContext.cgiGet( edtavEmailserver_emailbodywhenuserchangeemail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16EmailServer_EmailBodyWhenUserChangeEmail", AV16EmailServer_EmailBodyWhenUserChangeEmail);
         AV22EmailServer_SendEmailForRecoveryPassword = GXutil.strtobool( httpContext.cgiGet( chkavEmailserver_sendemailforrecoverypassword.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22EmailServer_SendEmailForRecoveryPassword", AV22EmailServer_SendEmailForRecoveryPassword);
         AV18EmailServer_EmailSubjectForRecoveryPassword = httpContext.cgiGet( edtavEmailserver_emailsubjectforrecoverypassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18EmailServer_EmailSubjectForRecoveryPassword", AV18EmailServer_EmailSubjectForRecoveryPassword);
         AV14EmailServer_EmailBodyForRecoveryPassword = httpContext.cgiGet( edtavEmailserver_emailbodyforrecoverypassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14EmailServer_EmailBodyForRecoveryPassword", AV14EmailServer_EmailBodyForRecoveryPassword);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"GAMRepositoryConfiguration");
         AV59RepoId = localUtil.ctol( httpContext.cgiGet( edtavRepoid_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59RepoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59RepoId), 12, 0));
         forbiddenHiddens.add("RepoId", localUtil.format( DecimalUtil.doubleToDec(AV59RepoId), "ZZZZZZZZZZZ9"));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("gamrepositoryconfiguration:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e11342 ();
      if (returnInSub) return;
   }

   public void e11342( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_objcol_SdtGAMError1[0] = AV37Errors ;
      AV8AuthenticationTypes = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getenabledauthenticationtypes(AV52Language, GXv_objcol_SdtGAMError1) ;
      AV37Errors = GXv_objcol_SdtGAMError1[0] ;
      AV92GXV1 = 1 ;
      while ( AV92GXV1 <= AV8AuthenticationTypes.size() )
      {
         AV7AuthenticationType = (genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)((genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple)AV8AuthenticationTypes.elementAt(-1+AV92GXV1));
         cmbavDefaultauthtypename.addItem(AV7AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Name(), AV7AuthenticationType.getgxTv_SdtGAMAuthenticationTypeSimple_Description(), (short)(0));
         AV92GXV1 = (int)(AV92GXV1+1) ;
      }
      GXv_objcol_SdtGAMError1[0] = AV37Errors ;
      AV72SecurityPolicies = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getsecuritypolicies(AV40FilterSecPol, GXv_objcol_SdtGAMError1) ;
      AV37Errors = GXv_objcol_SdtGAMError1[0] ;
      AV93GXV2 = 1 ;
      while ( AV93GXV2 <= AV72SecurityPolicies.size() )
      {
         AV73SecurityPolicy = (genexus.security.api.genexussecurity.SdtGAMSecurityPolicy)((genexus.security.api.genexussecurity.SdtGAMSecurityPolicy)AV72SecurityPolicies.elementAt(-1+AV93GXV2));
         cmbavDefaultsecuritypolicyid.addItem(GXutil.trim( GXutil.str( AV73SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Id(), 9, 0)), AV73SecurityPolicy.getgxTv_SdtGAMSecurityPolicy_Name(), (short)(0));
         AV93GXV2 = (int)(AV93GXV2+1) ;
      }
      GXv_objcol_SdtGAMError1[0] = AV37Errors ;
      AV70Roles = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getroles(AV39FilterRole, GXv_objcol_SdtGAMError1) ;
      AV37Errors = GXv_objcol_SdtGAMError1[0] ;
      AV94GXV3 = 1 ;
      while ( AV94GXV3 <= AV70Roles.size() )
      {
         AV69Role = (genexus.security.api.genexussecurity.SdtGAMRole)((genexus.security.api.genexussecurity.SdtGAMRole)AV70Roles.elementAt(-1+AV94GXV3));
         cmbavDefaultroleid.addItem(GXutil.trim( GXutil.str( AV69Role.getgxTv_SdtGAMRole_Id(), 12, 0)), AV69Role.getgxTv_SdtGAMRole_Name(), (short)(0));
         AV94GXV3 = (int)(AV94GXV3+1) ;
      }
      if ( (0==AV45Id) )
      {
         AV59RepoId = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getid() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59RepoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59RepoId), 12, 0));
      }
      else
      {
         AV59RepoId = AV45Id ;
         httpContext.ajax_rsp_assign_attri("", false, "AV59RepoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV59RepoId), 12, 0));
      }
      AV60Repository.load((int)(AV59RepoId));
      AV44GUID = AV60Repository.getgxTv_SdtGAMRepository_Guid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44GUID", AV44GUID);
      AV58NameSpace = AV60Repository.getgxTv_SdtGAMRepository_Namespace() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV58NameSpace", AV58NameSpace);
      AV57Name = AV60Repository.getgxTv_SdtGAMRepository_Name() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57Name", AV57Name);
      AV13Dsc = AV60Repository.getgxTv_SdtGAMRepository_Description() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Dsc", AV13Dsc);
      AV10DefaultAuthTypeName = AV60Repository.getgxTv_SdtGAMRepository_Defaultauthenticationtypename() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10DefaultAuthTypeName", AV10DefaultAuthTypeName);
      AV80UserIdentification = AV60Repository.getgxTv_SdtGAMRepository_Useridentification() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV80UserIdentification", AV80UserIdentification);
      AV42GenerateSessionStatistics = AV60Repository.getgxTv_SdtGAMRepository_Generatesessionstatistics() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42GenerateSessionStatistics", AV42GenerateSessionStatistics);
      AV77UserActivationMethod = AV60Repository.getgxTv_SdtGAMRepository_Useractivationmethod() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV77UserActivationMethod", AV77UserActivationMethod);
      AV78UserAutomaticActivationTimeout = (short)(AV60Repository.getgxTv_SdtGAMRepository_Userautomaticactivationtimeout()) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78UserAutomaticActivationTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV78UserAutomaticActivationTimeout), 4, 0));
      AV85UserRememberMeType = AV60Repository.getgxTv_SdtGAMRepository_Userremembermetype() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV85UserRememberMeType", AV85UserRememberMeType);
      AV84UserRememberMeTimeOut = AV60Repository.getgxTv_SdtGAMRepository_Userremembermetimeout() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV84UserRememberMeTimeOut", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV84UserRememberMeTimeOut), 4, 0));
      AV81UserRecoveryPasswordKeyTimeOut = (short)(AV60Repository.getgxTv_SdtGAMRepository_Userrecoverypasswordkeytimeout()) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81UserRecoveryPasswordKeyTimeOut", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV81UserRecoveryPasswordKeyTimeOut), 4, 0));
      AV82UserRecoveryPasswordKeyDailyMaximum = AV60Repository.getgxTv_SdtGAMRepository_Userrecoverypasswordkeydailymaximum() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV82UserRecoveryPasswordKeyDailyMaximum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV82UserRecoveryPasswordKeyDailyMaximum), 4, 0));
      AV83UserRecoveryPasswordKeyMonthlyMaximum = AV60Repository.getgxTv_SdtGAMRepository_Userrecoverypasswordkeymonthlymaximum() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83UserRecoveryPasswordKeyMonthlyMaximum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV83UserRecoveryPasswordKeyMonthlyMaximum), 4, 0));
      AV56MinimumAmountCharactersInLogin = AV60Repository.getgxTv_SdtGAMRepository_Minimumamountcharactersinlogin() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56MinimumAmountCharactersInLogin", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV56MinimumAmountCharactersInLogin), 2, 0));
      AV54LoginAttemptsToLockUser = AV60Repository.getgxTv_SdtGAMRepository_Loginattemptstolockuser() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54LoginAttemptsToLockUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV54LoginAttemptsToLockUser), 2, 0));
      AV41GAMUnblockUserTimeout = (short)(AV60Repository.getgxTv_SdtGAMRepository_Gamunblockusertimeout()) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41GAMUnblockUserTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV41GAMUnblockUserTimeout), 4, 0));
      AV53LoginAttemptsToLockSession = AV60Repository.getgxTv_SdtGAMRepository_Loginattemptstolocksession() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53LoginAttemptsToLockSession", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV53LoginAttemptsToLockSession), 2, 0));
      AV86UserSessionCacheTimeout = AV60Repository.getgxTv_SdtGAMRepository_Usersessioncachetimeout() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV86UserSessionCacheTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV86UserSessionCacheTimeout), 9, 0));
      AV51IntSecByDomainEnable = AV60Repository.getgxTv_SdtGAMRepository_Integratedsecuritybydomainenable() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51IntSecByDomainEnable", AV51IntSecByDomainEnable);
      AV49IntSecByDomainMode = AV60Repository.getgxTv_SdtGAMRepository_Integratedsecuritybydomainmode() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49IntSecByDomainMode", AV49IntSecByDomainMode);
      AV48IntSecByDomainJWTSecret = AV60Repository.getgxTv_SdtGAMRepository_Integratedsecuritybydomainjwtsecret() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48IntSecByDomainJWTSecret", AV48IntSecByDomainJWTSecret);
      AV47IntSecByDomainEncryptionKey = AV60Repository.getgxTv_SdtGAMRepository_Integratedsecuritybydomainencryptionkey() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47IntSecByDomainEncryptionKey", AV47IntSecByDomainEncryptionKey);
      AV61RepositoryCacheTimeout = AV60Repository.getgxTv_SdtGAMRepository_Cachetimeout() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61RepositoryCacheTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61RepositoryCacheTimeout), 9, 0));
      AV55LogoutBehavior = GXutil.trim( AV60Repository.getgxTv_SdtGAMRepository_Gamremotelogoutbehavior()) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55LogoutBehavior", AV55LogoutBehavior);
      AV71SecurityAdministratorEmail = AV60Repository.getgxTv_SdtGAMRepository_Securityadministratoremail() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71SecurityAdministratorEmail", AV71SecurityAdministratorEmail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECURITYADMINISTRATOREMAIL", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV71SecurityAdministratorEmail, ""))));
      AV43GiveAnonymousSession = AV60Repository.getgxTv_SdtGAMRepository_Giveanonymoussession() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43GiveAnonymousSession", AV43GiveAnonymousSession);
      AV9CanRegisterUsers = AV60Repository.getgxTv_SdtGAMRepository_Canregisterusers() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9CanRegisterUsers", AV9CanRegisterUsers);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCANREGISTERUSERS", getSecureSignedToken( "", AV9CanRegisterUsers));
      AV79UserEmailisUnique = AV60Repository.getgxTv_SdtGAMRepository_Useremailisunique() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79UserEmailisUnique", AV79UserEmailisUnique);
      AV11DefaultRoleId = AV60Repository.getgxTv_SdtGAMRepository_Defaultroleid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11DefaultRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DefaultRoleId), 12, 0));
      AV12DefaultSecurityPolicyId = AV60Repository.getgxTv_SdtGAMRepository_Defaultsecuritypolicyid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12DefaultSecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12DefaultSecurityPolicyId), 9, 0));
      AV35EnableWorkingAsGAMManagerRepo = AV60Repository.getgxTv_SdtGAMRepository_Enableworkingasgammanagerrepository() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35EnableWorkingAsGAMManagerRepo", AV35EnableWorkingAsGAMManagerRepo);
      AV34EnableTracingNumeric = AV60Repository.getgxTv_SdtGAMRepository_Enabletracing() ;
      AV33EnableTracing = GXutil.str( AV34EnableTracingNumeric, 4, 0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33EnableTracing", AV33EnableTracing);
      AV5AllowOauthAccess = AV60Repository.getgxTv_SdtGAMRepository_Allowoauthaccess() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AllowOauthAccess", AV5AllowOauthAccess);
      AV76SessionExpiresOnIPChange = AV60Repository.getgxTv_SdtGAMRepository_Sessionexpiresonipchange() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76SessionExpiresOnIPChange", AV76SessionExpiresOnIPChange);
      AV50TOTPSecretKeyLength = AV60Repository.getgxTv_SdtGAMRepository_Totpsecretkeylength() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50TOTPSecretKeyLength", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV50TOTPSecretKeyLength), 12, 0));
      AV68RequiredPassword = AV60Repository.getgxTv_SdtGAMRepository_Requiredpassword() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68RequiredPassword", AV68RequiredPassword);
      AV64RequiredEmail = AV60Repository.getgxTv_SdtGAMRepository_Requiredemail() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64RequiredEmail", AV64RequiredEmail);
      AV65RequiredFirstName = AV60Repository.getgxTv_SdtGAMRepository_Requiredfirstname() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65RequiredFirstName", AV65RequiredFirstName);
      AV67RequiredLastName = AV60Repository.getgxTv_SdtGAMRepository_Requiredlastname() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67RequiredLastName", AV67RequiredLastName);
      AV63RequiredBirthday = AV60Repository.getgxTv_SdtGAMRepository_Requiredbirthday() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63RequiredBirthday", AV63RequiredBirthday);
      AV66RequiredGender = AV60Repository.getgxTv_SdtGAMRepository_Requiredgender() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66RequiredGender", AV66RequiredGender);
      if ( ! (0==AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) )
      {
         GXv_objcol_SdtGAMError1[0] = AV37Errors ;
         AV62RepositoryCollection = new genexus.security.api.genexussecurity.SdtGAM(remoteHandle, context).getallrepositories(AV38Filter, GXv_objcol_SdtGAMError1) ;
         AV37Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV62RepositoryCollection.size() > 1 )
         {
            AV95GXV4 = 1 ;
            while ( AV95GXV4 <= AV62RepositoryCollection.size() )
            {
               AV87GAMRepositoryItem = (genexus.security.api.genexussecurity.SdtGAMRepository)((genexus.security.api.genexussecurity.SdtGAMRepository)AV62RepositoryCollection.elementAt(-1+AV95GXV4));
               if ( AV87GAMRepositoryItem.getgxTv_SdtGAMRepository_Id() == AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid() )
               {
                  AV6AuthenticationMasterRepository = GXutil.trim( AV87GAMRepositoryItem.getgxTv_SdtGAMRepository_Guid()) + " - " + GXutil.trim( AV87GAMRepositoryItem.getgxTv_SdtGAMRepository_Name()) ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV6AuthenticationMasterRepository", AV6AuthenticationMasterRepository);
                  if (true) break;
               }
               AV95GXV4 = (int)(AV95GXV4+1) ;
            }
         }
      }
      divTblintsecbydomain_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTblintsecbydomain_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblintsecbydomain_Visible), 5, 0), true);
      if ( AV51IntSecByDomainEnable )
      {
         divTblintsecbydomain_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTblintsecbydomain_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTblintsecbydomain_Visible), 5, 0), true);
      }
      AV28EmailServerHost = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serverhost() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28EmailServerHost", AV28EmailServerHost);
      AV29EmailServerPort = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serverport() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29EmailServerPort", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29EmailServerPort), 4, 0));
      AV30EmailServerSecure = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serversecure() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30EmailServerSecure", AV30EmailServerSecure);
      AV31EmailServerTimeout = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Servertimeout() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31EmailServerTimeout", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31EmailServerTimeout), 4, 0));
      AV32EmailServerUsesAuthentication = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serverusesauthentication() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32EmailServerUsesAuthentication", AV32EmailServerUsesAuthentication);
      AV74ServerSenderAddress = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serversenderaddress() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV74ServerSenderAddress", AV74ServerSenderAddress);
      AV75ServerSenderName = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serversendername() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75ServerSenderName", AV75ServerSenderName);
      if ( AV32EmailServerUsesAuthentication )
      {
         AV26EmailServerAuthenticationUsername = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serverauthenticationusername() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26EmailServerAuthenticationUsername", AV26EmailServerAuthenticationUsername);
         AV27EmailServerAuthenticationUserPassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Serverauthenticationuserpassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27EmailServerAuthenticationUserPassword", AV27EmailServerAuthenticationUserPassword);
      }
      AV23EmailServer_SendEmailWhenUserActivateAccount = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Sendemailwhenuseractivateaccount() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23EmailServer_SendEmailWhenUserActivateAccount", AV23EmailServer_SendEmailWhenUserActivateAccount);
      if ( AV23EmailServer_SendEmailWhenUserActivateAccount )
      {
         AV19EmailServer_EmailSubjectWhenUserActivateAccount = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Subjectwhenuseractivateaccount() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19EmailServer_EmailSubjectWhenUserActivateAccount", AV19EmailServer_EmailSubjectWhenUserActivateAccount);
         AV15EmailServer_EmailBodyWhenUserActivateAccount = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Bodywhenuseractivateaccount() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15EmailServer_EmailBodyWhenUserActivateAccount", AV15EmailServer_EmailBodyWhenUserActivateAccount);
      }
      AV25EmailServer_SendEmailWhenUserChangePassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Sendemailwhenuserchangepassword() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25EmailServer_SendEmailWhenUserChangePassword", AV25EmailServer_SendEmailWhenUserChangePassword);
      if ( AV25EmailServer_SendEmailWhenUserChangePassword )
      {
         AV21EmailServer_EmailSubjectWhenUserChangePassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Subjectwhenuserchangepassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21EmailServer_EmailSubjectWhenUserChangePassword", AV21EmailServer_EmailSubjectWhenUserChangePassword);
         AV17EmailServer_EmailBodyWhenUserChangePassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Bodywhenuserchangepassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17EmailServer_EmailBodyWhenUserChangePassword", AV17EmailServer_EmailBodyWhenUserChangePassword);
      }
      AV24EmailServer_SendEmailWhenUserChangeEmail = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Sendemailwhenuserchangeemail() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24EmailServer_SendEmailWhenUserChangeEmail", AV24EmailServer_SendEmailWhenUserChangeEmail);
      if ( AV24EmailServer_SendEmailWhenUserChangeEmail )
      {
         AV20EmailServer_EmailSubjectWhenUserChangeEmail = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Subjectwhenuserchangeemail() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20EmailServer_EmailSubjectWhenUserChangeEmail", AV20EmailServer_EmailSubjectWhenUserChangeEmail);
         AV16EmailServer_EmailBodyWhenUserChangeEmail = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Bodywhenuserchangeemail() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16EmailServer_EmailBodyWhenUserChangeEmail", AV16EmailServer_EmailBodyWhenUserChangeEmail);
      }
      AV22EmailServer_SendEmailForRecoveryPassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Sendemailtorecoveruserpassword() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22EmailServer_SendEmailForRecoveryPassword", AV22EmailServer_SendEmailForRecoveryPassword);
      if ( AV22EmailServer_SendEmailForRecoveryPassword )
      {
         AV18EmailServer_EmailSubjectForRecoveryPassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Subjecttorecoveruserpassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18EmailServer_EmailSubjectForRecoveryPassword", AV18EmailServer_EmailSubjectForRecoveryPassword);
         AV14EmailServer_EmailBodyForRecoveryPassword = AV60Repository.getgxTv_SdtGAMRepository_Email().getgxTv_SdtGAMRepositoryEmail_Bodytorecoveruserpassword() ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14EmailServer_EmailBodyForRecoveryPassword", AV14EmailServer_EmailBodyForRecoveryPassword);
      }
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      lblTextblocktitle_Caption = Form.getCaption() ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( AV32EmailServerUsesAuthentication ) )
      {
         edtavEmailserverauthenticationusername_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserverauthenticationusername_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserverauthenticationusername_Visible), 5, 0), true);
         divEmailserverauthenticationusername_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserverauthenticationusername_cell_Internalname, "Class", divEmailserverauthenticationusername_cell_Class, true);
      }
      else
      {
         edtavEmailserverauthenticationusername_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserverauthenticationusername_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserverauthenticationusername_Visible), 5, 0), true);
         divEmailserverauthenticationusername_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserverauthenticationusername_cell_Internalname, "Class", divEmailserverauthenticationusername_cell_Class, true);
      }
      if ( ! ( AV32EmailServerUsesAuthentication ) )
      {
         edtavEmailserverauthenticationuserpassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserverauthenticationuserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserverauthenticationuserpassword_Visible), 5, 0), true);
         divEmailserverauthenticationuserpassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserverauthenticationuserpassword_cell_Internalname, "Class", divEmailserverauthenticationuserpassword_cell_Class, true);
      }
      else
      {
         edtavEmailserverauthenticationuserpassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserverauthenticationuserpassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserverauthenticationuserpassword_Visible), 5, 0), true);
         divEmailserverauthenticationuserpassword_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserverauthenticationuserpassword_cell_Internalname, "Class", divEmailserverauthenticationuserpassword_cell_Class, true);
      }
      if ( ! ( AV23EmailServer_SendEmailWhenUserActivateAccount ) )
      {
         edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible), 5, 0), true);
         divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectwhenuseractivateaccount_cell_Internalname, "Class", divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible), 5, 0), true);
         divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectwhenuseractivateaccount_cell_Internalname, "Class", divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class, true);
      }
      if ( ! ( AV23EmailServer_SendEmailWhenUserActivateAccount ) )
      {
         edtavEmailserver_emailbodywhenuseractivateaccount_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodywhenuseractivateaccount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodywhenuseractivateaccount_Visible), 5, 0), true);
         divEmailserver_emailbodywhenuseractivateaccount_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodywhenuseractivateaccount_cell_Internalname, "Class", divEmailserver_emailbodywhenuseractivateaccount_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailbodywhenuseractivateaccount_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodywhenuseractivateaccount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodywhenuseractivateaccount_Visible), 5, 0), true);
         divEmailserver_emailbodywhenuseractivateaccount_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodywhenuseractivateaccount_cell_Internalname, "Class", divEmailserver_emailbodywhenuseractivateaccount_cell_Class, true);
      }
      if ( ! ( AV25EmailServer_SendEmailWhenUserChangePassword ) )
      {
         edtavEmailserver_emailsubjectwhenuserchangepassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectwhenuserchangepassword_Visible), 5, 0), true);
         divEmailserver_emailsubjectwhenuserchangepassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectwhenuserchangepassword_cell_Internalname, "Class", divEmailserver_emailsubjectwhenuserchangepassword_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailsubjectwhenuserchangepassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectwhenuserchangepassword_Visible), 5, 0), true);
         divEmailserver_emailsubjectwhenuserchangepassword_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectwhenuserchangepassword_cell_Internalname, "Class", divEmailserver_emailsubjectwhenuserchangepassword_cell_Class, true);
      }
      if ( ! ( AV25EmailServer_SendEmailWhenUserChangePassword ) )
      {
         edtavEmailserver_emailbodywhenuserchangepassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodywhenuserchangepassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodywhenuserchangepassword_Visible), 5, 0), true);
         divEmailserver_emailbodywhenuserchangepassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodywhenuserchangepassword_cell_Internalname, "Class", divEmailserver_emailbodywhenuserchangepassword_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailbodywhenuserchangepassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodywhenuserchangepassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodywhenuserchangepassword_Visible), 5, 0), true);
         divEmailserver_emailbodywhenuserchangepassword_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodywhenuserchangepassword_cell_Internalname, "Class", divEmailserver_emailbodywhenuserchangepassword_cell_Class, true);
      }
      if ( ! ( AV24EmailServer_SendEmailWhenUserChangeEmail ) )
      {
         edtavEmailserver_emailsubjectwhenuserchangeemail_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectwhenuserchangeemail_Visible), 5, 0), true);
         divEmailserver_emailsubjectwhenuserchangeemail_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectwhenuserchangeemail_cell_Internalname, "Class", divEmailserver_emailsubjectwhenuserchangeemail_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailsubjectwhenuserchangeemail_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectwhenuserchangeemail_Visible), 5, 0), true);
         divEmailserver_emailsubjectwhenuserchangeemail_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectwhenuserchangeemail_cell_Internalname, "Class", divEmailserver_emailsubjectwhenuserchangeemail_cell_Class, true);
      }
      if ( ! ( AV24EmailServer_SendEmailWhenUserChangeEmail ) )
      {
         edtavEmailserver_emailbodywhenuserchangeemail_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodywhenuserchangeemail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodywhenuserchangeemail_Visible), 5, 0), true);
         divEmailserver_emailbodywhenuserchangeemail_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodywhenuserchangeemail_cell_Internalname, "Class", divEmailserver_emailbodywhenuserchangeemail_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailbodywhenuserchangeemail_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodywhenuserchangeemail_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodywhenuserchangeemail_Visible), 5, 0), true);
         divEmailserver_emailbodywhenuserchangeemail_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodywhenuserchangeemail_cell_Internalname, "Class", divEmailserver_emailbodywhenuserchangeemail_cell_Class, true);
      }
      if ( ! ( AV22EmailServer_SendEmailForRecoveryPassword ) )
      {
         edtavEmailserver_emailsubjectforrecoverypassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectforrecoverypassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectforrecoverypassword_Visible), 5, 0), true);
         divEmailserver_emailsubjectforrecoverypassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectforrecoverypassword_cell_Internalname, "Class", divEmailserver_emailsubjectforrecoverypassword_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailsubjectforrecoverypassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailsubjectforrecoverypassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailsubjectforrecoverypassword_Visible), 5, 0), true);
         divEmailserver_emailsubjectforrecoverypassword_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailsubjectforrecoverypassword_cell_Internalname, "Class", divEmailserver_emailsubjectforrecoverypassword_cell_Class, true);
      }
      if ( ! ( AV22EmailServer_SendEmailForRecoveryPassword ) )
      {
         edtavEmailserver_emailbodyforrecoverypassword_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodyforrecoverypassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodyforrecoverypassword_Visible), 5, 0), true);
         divEmailserver_emailbodyforrecoverypassword_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodyforrecoverypassword_cell_Internalname, "Class", divEmailserver_emailbodyforrecoverypassword_cell_Class, true);
      }
      else
      {
         edtavEmailserver_emailbodyforrecoverypassword_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavEmailserver_emailbodyforrecoverypassword_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmailserver_emailbodyforrecoverypassword_Visible), 5, 0), true);
         divEmailserver_emailbodyforrecoverypassword_cell_Class = "col-xs-12 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEmailserver_emailbodyforrecoverypassword_cell_Internalname, "Class", divEmailserver_emailbodyforrecoverypassword_cell_Class, true);
      }
      if ( ! ( ! ( ( GXutil.strcmp(AV80UserIdentification, "email") == 0 ) || ( GXutil.strcmp(AV80UserIdentification, "namema") == 0 ) ) ) )
      {
         chkavUseremailisunique.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavUseremailisunique.getInternalname(), "Visible", GXutil.ltrimstr( chkavUseremailisunique.getVisible(), 5, 0), true);
         divUseremailisunique_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divUseremailisunique_cell_Internalname, "Class", divUseremailisunique_cell_Class, true);
      }
      else
      {
         chkavUseremailisunique.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavUseremailisunique.getInternalname(), "Visible", GXutil.ltrimstr( chkavUseremailisunique.getVisible(), 5, 0), true);
         divUseremailisunique_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divUseremailisunique_cell_Internalname, "Class", divUseremailisunique_cell_Class, true);
      }
      if ( ! ( ! ( ( GXutil.strcmp(AV80UserIdentification, "email") == 0 ) || ( GXutil.strcmp(AV80UserIdentification, "namema") == 0 ) ) ) )
      {
         chkavRequiredemail.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRequiredemail.getInternalname(), "Visible", GXutil.ltrimstr( chkavRequiredemail.getVisible(), 5, 0), true);
         divRequiredemail_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divRequiredemail_cell_Internalname, "Class", divRequiredemail_cell_Class, true);
      }
      else
      {
         chkavRequiredemail.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavRequiredemail.getInternalname(), "Visible", GXutil.ltrimstr( chkavRequiredemail.getVisible(), 5, 0), true);
         divRequiredemail_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divRequiredemail_cell_Internalname, "Class", divRequiredemail_cell_Class, true);
      }
      if ( ! ( ! (0==AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) && ( AV62RepositoryCollection.size() > 1 ) ) )
      {
         edtavAuthenticationmasterrepository_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAuthenticationmasterrepository_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthenticationmasterrepository_Visible), 5, 0), true);
         divAuthenticationmasterrepository_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divAuthenticationmasterrepository_cell_Internalname, "Class", divAuthenticationmasterrepository_cell_Class, true);
      }
      else
      {
         edtavAuthenticationmasterrepository_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavAuthenticationmasterrepository_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAuthenticationmasterrepository_Visible), 5, 0), true);
         divAuthenticationmasterrepository_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divAuthenticationmasterrepository_cell_Internalname, "Class", divAuthenticationmasterrepository_cell_Class, true);
      }
      if ( ! ( (0==AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) ) )
      {
         cmbavDefaultauthtypename.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultauthtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultauthtypename.getVisible(), 5, 0), true);
         divDefaultauthtypename_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultauthtypename_cell_Internalname, "Class", divDefaultauthtypename_cell_Class, true);
      }
      else
      {
         cmbavDefaultauthtypename.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultauthtypename.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultauthtypename.getVisible(), 5, 0), true);
         divDefaultauthtypename_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultauthtypename_cell_Internalname, "Class", divDefaultauthtypename_cell_Class, true);
      }
      if ( ! ( (0==AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) ) )
      {
         cmbavDefaultroleid.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultroleid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultroleid.getVisible(), 5, 0), true);
         divDefaultroleid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultroleid_cell_Internalname, "Class", divDefaultroleid_cell_Class, true);
      }
      else
      {
         cmbavDefaultroleid.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultroleid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultroleid.getVisible(), 5, 0), true);
         divDefaultroleid_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultroleid_cell_Internalname, "Class", divDefaultroleid_cell_Class, true);
      }
      if ( ! ( (0==AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) ) )
      {
         cmbavDefaultsecuritypolicyid.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultsecuritypolicyid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultsecuritypolicyid.getVisible(), 5, 0), true);
         divDefaultsecuritypolicyid_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultsecuritypolicyid_cell_Internalname, "Class", divDefaultsecuritypolicyid_cell_Class, true);
      }
      else
      {
         cmbavDefaultsecuritypolicyid.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDefaultsecuritypolicyid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDefaultsecuritypolicyid.getVisible(), 5, 0), true);
         divDefaultsecuritypolicyid_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divDefaultsecuritypolicyid_cell_Internalname, "Class", divDefaultsecuritypolicyid_cell_Class, true);
      }
      if ( ! ( (0==AV60Repository.getgxTv_SdtGAMRepository_Authenticationmasterrepositoryid()) ) )
      {
         chkavEnableworkingasgammanagerrepo.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, chkavEnableworkingasgammanagerrepo.getInternalname(), "Visible", GXutil.ltrimstr( chkavEnableworkingasgammanagerrepo.getVisible(), 5, 0), true);
         divEnableworkingasgammanagerrepo_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", false, divEnableworkingasgammanagerrepo_cell_Internalname, "Class", divEnableworkingasgammanagerrepo_cell_Class, true);
      }
      else
      {
         chkavEnableworkingasgammanagerrepo.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, chkavEnableworkingasgammanagerrepo.getInternalname(), "Visible", GXutil.ltrimstr( chkavEnableworkingasgammanagerrepo.getVisible(), 5, 0), true);
         divEnableworkingasgammanagerrepo_cell_Class = "col-xs-12 col-sm-6 DataContentCell DscTop" ;
         httpContext.ajax_rsp_assign_prop("", false, divEnableworkingasgammanagerrepo_cell_Internalname, "Class", divEnableworkingasgammanagerrepo_cell_Class, true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e12342 ();
      if (returnInSub) return;
   }

   public void e12342( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV60Repository.load((int)(AV59RepoId));
      AV60Repository.setgxTv_SdtGAMRepository_Name( AV57Name );
      AV60Repository.setgxTv_SdtGAMRepository_Description( AV13Dsc );
      AV60Repository.setgxTv_SdtGAMRepository_Defaultauthenticationtypename( AV10DefaultAuthTypeName );
      AV60Repository.setgxTv_SdtGAMRepository_Useridentification( AV80UserIdentification );
      AV60Repository.setgxTv_SdtGAMRepository_Generatesessionstatistics( AV42GenerateSessionStatistics );
      AV60Repository.setgxTv_SdtGAMRepository_Useractivationmethod( AV77UserActivationMethod );
      AV60Repository.setgxTv_SdtGAMRepository_Userautomaticactivationtimeout( AV78UserAutomaticActivationTimeout );
      AV60Repository.setgxTv_SdtGAMRepository_Gamunblockusertimeout( AV41GAMUnblockUserTimeout );
      AV60Repository.setgxTv_SdtGAMRepository_Userremembermetype( AV85UserRememberMeType );
      AV60Repository.setgxTv_SdtGAMRepository_Userremembermetimeout( AV84UserRememberMeTimeOut );
      AV60Repository.setgxTv_SdtGAMRepository_Userrecoverypasswordkeytimeout( AV81UserRecoveryPasswordKeyTimeOut );
      AV60Repository.setgxTv_SdtGAMRepository_Userrecoverypasswordkeydailymaximum( AV82UserRecoveryPasswordKeyDailyMaximum );
      AV60Repository.setgxTv_SdtGAMRepository_Userrecoverypasswordkeymonthlymaximum( AV83UserRecoveryPasswordKeyMonthlyMaximum );
      AV60Repository.setgxTv_SdtGAMRepository_Gamremotelogoutbehavior( AV55LogoutBehavior );
      AV60Repository.setgxTv_SdtGAMRepository_Minimumamountcharactersinlogin( AV56MinimumAmountCharactersInLogin );
      AV60Repository.setgxTv_SdtGAMRepository_Loginattemptstolockuser( AV54LoginAttemptsToLockUser );
      AV60Repository.setgxTv_SdtGAMRepository_Loginattemptstolocksession( AV53LoginAttemptsToLockSession );
      AV60Repository.setgxTv_SdtGAMRepository_Usersessioncachetimeout( AV86UserSessionCacheTimeout );
      AV60Repository.setgxTv_SdtGAMRepository_Cachetimeout( AV61RepositoryCacheTimeout );
      AV60Repository.setgxTv_SdtGAMRepository_Securityadministratoremail( AV71SecurityAdministratorEmail );
      AV60Repository.setgxTv_SdtGAMRepository_Giveanonymoussession( AV43GiveAnonymousSession );
      AV60Repository.setgxTv_SdtGAMRepository_Canregisterusers( AV9CanRegisterUsers );
      AV60Repository.setgxTv_SdtGAMRepository_Useremailisunique( AV79UserEmailisUnique );
      AV60Repository.setgxTv_SdtGAMRepository_Defaultroleid( AV11DefaultRoleId );
      AV60Repository.setgxTv_SdtGAMRepository_Defaultsecuritypolicyid( AV12DefaultSecurityPolicyId );
      AV60Repository.setgxTv_SdtGAMRepository_Enableworkingasgammanagerrepository( AV35EnableWorkingAsGAMManagerRepo );
      AV60Repository.setgxTv_SdtGAMRepository_Enabletracing( (short)(GXutil.lval( AV33EnableTracing)) );
      AV60Repository.setgxTv_SdtGAMRepository_Allowoauthaccess( AV5AllowOauthAccess );
      AV60Repository.setgxTv_SdtGAMRepository_Sessionexpiresonipchange( AV76SessionExpiresOnIPChange );
      AV60Repository.setgxTv_SdtGAMRepository_Integratedsecuritybydomainenable( AV51IntSecByDomainEnable );
      AV60Repository.setgxTv_SdtGAMRepository_Integratedsecuritybydomainmode( AV49IntSecByDomainMode );
      AV60Repository.setgxTv_SdtGAMRepository_Integratedsecuritybydomainjwtsecret( AV48IntSecByDomainJWTSecret );
      AV60Repository.setgxTv_SdtGAMRepository_Integratedsecuritybydomainencryptionkey( AV47IntSecByDomainEncryptionKey );
      AV60Repository.setgxTv_SdtGAMRepository_Totpsecretkeylength( AV50TOTPSecretKeyLength );
      AV60Repository.setgxTv_SdtGAMRepository_Requiredpassword( AV68RequiredPassword );
      AV60Repository.setgxTv_SdtGAMRepository_Requiredemail( AV64RequiredEmail );
      AV60Repository.setgxTv_SdtGAMRepository_Requiredfirstname( AV65RequiredFirstName );
      AV60Repository.setgxTv_SdtGAMRepository_Requiredlastname( AV67RequiredLastName );
      AV60Repository.setgxTv_SdtGAMRepository_Requiredbirthday( AV63RequiredBirthday );
      AV60Repository.setgxTv_SdtGAMRepository_Requiredgender( AV66RequiredGender );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serverhost( AV28EmailServerHost );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serverport( AV29EmailServerPort );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serversecure( AV30EmailServerSecure );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Servertimeout( AV31EmailServerTimeout );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serverusesauthentication( AV32EmailServerUsesAuthentication );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serversenderaddress( AV74ServerSenderAddress );
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serversendername( AV75ServerSenderName );
      if ( AV32EmailServerUsesAuthentication )
      {
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serverauthenticationusername( AV26EmailServerAuthenticationUsername );
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Serverauthenticationuserpassword( AV27EmailServerAuthenticationUserPassword );
      }
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Sendemailwhenuseractivateaccount( AV23EmailServer_SendEmailWhenUserActivateAccount );
      if ( AV23EmailServer_SendEmailWhenUserActivateAccount )
      {
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Subjectwhenuseractivateaccount( AV19EmailServer_EmailSubjectWhenUserActivateAccount );
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Bodywhenuseractivateaccount( AV15EmailServer_EmailBodyWhenUserActivateAccount );
      }
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Sendemailwhenuserchangepassword( AV25EmailServer_SendEmailWhenUserChangePassword );
      if ( AV25EmailServer_SendEmailWhenUserChangePassword )
      {
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Subjectwhenuserchangepassword( AV21EmailServer_EmailSubjectWhenUserChangePassword );
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Bodywhenuserchangepassword( AV17EmailServer_EmailBodyWhenUserChangePassword );
      }
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Sendemailwhenuserchangeemail( AV24EmailServer_SendEmailWhenUserChangeEmail );
      if ( AV24EmailServer_SendEmailWhenUserChangeEmail )
      {
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Subjectwhenuserchangeemail( AV20EmailServer_EmailSubjectWhenUserChangeEmail );
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Bodywhenuserchangeemail( AV16EmailServer_EmailBodyWhenUserChangeEmail );
      }
      AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Sendemailtorecoveruserpassword( AV22EmailServer_SendEmailForRecoveryPassword );
      if ( AV22EmailServer_SendEmailForRecoveryPassword )
      {
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Subjecttorecoveruserpassword( AV18EmailServer_EmailSubjectForRecoveryPassword );
         AV60Repository.getgxTv_SdtGAMRepository_Email().setgxTv_SdtGAMRepositoryEmail_Bodytorecoveruserpassword( AV14EmailServer_EmailBodyForRecoveryPassword );
      }
      AV60Repository.save();
      if ( AV60Repository.success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamrepositoryconfiguration");
         httpContext.GX_msglist.addItem(httpContext.getMessage( httpContext.getMessage( "GXM_sucupdated", ""), ""));
      }
      else
      {
         AV37Errors = AV60Repository.geterrors() ;
         AV96GXV5 = 1 ;
         while ( AV96GXV5 <= AV37Errors.size() )
         {
            AV36Error = (genexus.security.api.genexussecurity.SdtGAMError)((genexus.security.api.genexussecurity.SdtGAMError)AV37Errors.elementAt(-1+AV96GXV5));
            httpContext.GX_msglist.addItem(GXutil.format( "%1 (GAM%2)", AV36Error.getgxTv_SdtGAMError_Message(), GXutil.ltrimstr( AV36Error.getgxTv_SdtGAMError_Code(), 12, 0), "", "", "", "", "", "", ""));
            AV96GXV5 = (int)(AV96GXV5+1) ;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60Repository", AV60Repository);
   }

   public void e13342( )
   {
      /* Useridentification_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e14342( )
   {
      /* Emailserverusesauthentication_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e15342( )
   {
      /* Emailserver_sendemailwhenuseractivateaccount_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e16342( )
   {
      /* Emailserver_sendemailwhenuserchangepassword_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e17342( )
   {
      /* Emailserver_sendemailwhenuserchangeemail_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e18342( )
   {
      /* Emailserver_sendemailforrecoverypassword_Click Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   protected void nextLoad( )
   {
   }

   protected void e19342( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV45Id = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45Id", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV45Id), 12, 0));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV45Id), "ZZZZZZZZZZZ9")));
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
      pa342( ) ;
      ws342( ) ;
      we342( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111214323", true, true);
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
      httpContext.AddJavascriptSource("gamrepositoryconfiguration.js", "?202412111214331", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      edtavRepoid_Internalname = "vREPOID" ;
      edtavGuid_Internalname = "vGUID" ;
      edtavNamespace_Internalname = "vNAMESPACE" ;
      edtavName_Internalname = "vNAME" ;
      edtavDsc_Internalname = "vDSC" ;
      cmbavEnabletracing.setInternalname( "vENABLETRACING" );
      edtavAuthenticationmasterrepository_Internalname = "vAUTHENTICATIONMASTERREPOSITORY" ;
      divAuthenticationmasterrepository_cell_Internalname = "AUTHENTICATIONMASTERREPOSITORY_CELL" ;
      cmbavDefaultauthtypename.setInternalname( "vDEFAULTAUTHTYPENAME" );
      divDefaultauthtypename_cell_Internalname = "DEFAULTAUTHTYPENAME_CELL" ;
      cmbavDefaultroleid.setInternalname( "vDEFAULTROLEID" );
      divDefaultroleid_cell_Internalname = "DEFAULTROLEID_CELL" ;
      cmbavDefaultsecuritypolicyid.setInternalname( "vDEFAULTSECURITYPOLICYID" );
      divDefaultsecuritypolicyid_cell_Internalname = "DEFAULTSECURITYPOLICYID_CELL" ;
      chkavAllowoauthaccess.setInternalname( "vALLOWOAUTHACCESS" );
      cmbavLogoutbehavior.setInternalname( "vLOGOUTBEHAVIOR" );
      chkavEnableworkingasgammanagerrepo.setInternalname( "vENABLEWORKINGASGAMMANAGERREPO" );
      divEnableworkingasgammanagerrepo_cell_Internalname = "ENABLEWORKINGASGAMMANAGERREPO_CELL" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      lblUsers_title_Internalname = "USERS_TITLE" ;
      cmbavUseridentification.setInternalname( "vUSERIDENTIFICATION" );
      chkavUseremailisunique.setInternalname( "vUSEREMAILISUNIQUE" );
      divUseremailisunique_cell_Internalname = "USEREMAILISUNIQUE_CELL" ;
      cmbavUseractivationmethod.setInternalname( "vUSERACTIVATIONMETHOD" );
      edtavUserautomaticactivationtimeout_Internalname = "vUSERAUTOMATICACTIVATIONTIMEOUT" ;
      edtavUserrecoverypasswordkeytimeout_Internalname = "vUSERRECOVERYPASSWORDKEYTIMEOUT" ;
      edtavUserrecoverypasswordkeydailymaximum_Internalname = "vUSERRECOVERYPASSWORDKEYDAILYMAXIMUM" ;
      edtavUserrecoverypasswordkeymonthlymaximum_Internalname = "vUSERRECOVERYPASSWORDKEYMONTHLYMAXIMUM" ;
      edtavLoginattemptstolockuser_Internalname = "vLOGINATTEMPTSTOLOCKUSER" ;
      edtavGamunblockusertimeout_Internalname = "vGAMUNBLOCKUSERTIMEOUT" ;
      cmbavUserremembermetype.setInternalname( "vUSERREMEMBERMETYPE" );
      edtavUserremembermetimeout_Internalname = "vUSERREMEMBERMETIMEOUT" ;
      edtavTotpsecretkeylength_Internalname = "vTOTPSECRETKEYLENGTH" ;
      chkavRequiredemail.setInternalname( "vREQUIREDEMAIL" );
      divRequiredemail_cell_Internalname = "REQUIREDEMAIL_CELL" ;
      chkavRequiredpassword.setInternalname( "vREQUIREDPASSWORD" );
      chkavRequiredfirstname.setInternalname( "vREQUIREDFIRSTNAME" );
      chkavRequiredlastname.setInternalname( "vREQUIREDLASTNAME" );
      chkavRequiredbirthday.setInternalname( "vREQUIREDBIRTHDAY" );
      chkavRequiredgender.setInternalname( "vREQUIREDGENDER" );
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      lblSession_title_Internalname = "SESSION_TITLE" ;
      cmbavGeneratesessionstatistics.setInternalname( "vGENERATESESSIONSTATISTICS" );
      edtavUsersessioncachetimeout_Internalname = "vUSERSESSIONCACHETIMEOUT" ;
      chkavGiveanonymoussession.setInternalname( "vGIVEANONYMOUSSESSION" );
      chkavSessionexpiresonipchange.setInternalname( "vSESSIONEXPIRESONIPCHANGE" );
      edtavLoginattemptstolocksession_Internalname = "vLOGINATTEMPTSTOLOCKSESSION" ;
      edtavMinimumamountcharactersinlogin_Internalname = "vMINIMUMAMOUNTCHARACTERSINLOGIN" ;
      edtavRepositorycachetimeout_Internalname = "vREPOSITORYCACHETIMEOUT" ;
      chkavIntsecbydomainenable.setInternalname( "vINTSECBYDOMAINENABLE" );
      cmbavIntsecbydomainmode.setInternalname( "vINTSECBYDOMAINMODE" );
      edtavIntsecbydomainjwtsecret_Internalname = "vINTSECBYDOMAINJWTSECRET" ;
      edtavIntsecbydomainencryptionkey_Internalname = "vINTSECBYDOMAINENCRYPTIONKEY" ;
      divTblintsecbydomain_Internalname = "TBLINTSECBYDOMAIN" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      lblTabemail_title_Internalname = "TABEMAIL_TITLE" ;
      edtavEmailserverhost_Internalname = "vEMAILSERVERHOST" ;
      edtavEmailserverport_Internalname = "vEMAILSERVERPORT" ;
      edtavEmailservertimeout_Internalname = "vEMAILSERVERTIMEOUT" ;
      chkavEmailserversecure.setInternalname( "vEMAILSERVERSECURE" );
      edtavServersenderaddress_Internalname = "vSERVERSENDERADDRESS" ;
      edtavServersendername_Internalname = "vSERVERSENDERNAME" ;
      chkavEmailserverusesauthentication.setInternalname( "vEMAILSERVERUSESAUTHENTICATION" );
      edtavEmailserverauthenticationusername_Internalname = "vEMAILSERVERAUTHENTICATIONUSERNAME" ;
      divEmailserverauthenticationusername_cell_Internalname = "EMAILSERVERAUTHENTICATIONUSERNAME_CELL" ;
      edtavEmailserverauthenticationuserpassword_Internalname = "vEMAILSERVERAUTHENTICATIONUSERPASSWORD" ;
      divEmailserverauthenticationuserpassword_cell_Internalname = "EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL" ;
      chkavEmailserver_sendemailwhenuseractivateaccount.setInternalname( "vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT" );
      edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname = "vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT" ;
      divEmailserver_emailsubjectwhenuseractivateaccount_cell_Internalname = "EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL" ;
      edtavEmailserver_emailbodywhenuseractivateaccount_Internalname = "vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT" ;
      divEmailserver_emailbodywhenuseractivateaccount_cell_Internalname = "EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL" ;
      chkavEmailserver_sendemailwhenuserchangepassword.setInternalname( "vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD" );
      edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname = "vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD" ;
      divEmailserver_emailsubjectwhenuserchangepassword_cell_Internalname = "EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL" ;
      edtavEmailserver_emailbodywhenuserchangepassword_Internalname = "vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD" ;
      divEmailserver_emailbodywhenuserchangepassword_cell_Internalname = "EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL" ;
      chkavEmailserver_sendemailwhenuserchangeemail.setInternalname( "vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL" );
      edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname = "vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL" ;
      divEmailserver_emailsubjectwhenuserchangeemail_cell_Internalname = "EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL" ;
      edtavEmailserver_emailbodywhenuserchangeemail_Internalname = "vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL" ;
      divEmailserver_emailbodywhenuserchangeemail_cell_Internalname = "EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL" ;
      chkavEmailserver_sendemailforrecoverypassword.setInternalname( "vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD" );
      edtavEmailserver_emailsubjectforrecoverypassword_Internalname = "vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD" ;
      divEmailserver_emailsubjectforrecoverypassword_cell_Internalname = "EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL" ;
      edtavEmailserver_emailbodyforrecoverypassword_Internalname = "vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD" ;
      divEmailserver_emailbodyforrecoverypassword_cell_Internalname = "EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Gxuitabspanel_tabs_Internalname = "GXUITABSPANEL_TABS" ;
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
      edtavEmailserver_emailbodyforrecoverypassword_Enabled = 1 ;
      edtavEmailserver_emailbodyforrecoverypassword_Visible = 1 ;
      divEmailserver_emailbodyforrecoverypassword_cell_Class = "col-xs-12" ;
      edtavEmailserver_emailsubjectforrecoverypassword_Jsonclick = "" ;
      edtavEmailserver_emailsubjectforrecoverypassword_Enabled = 1 ;
      edtavEmailserver_emailsubjectforrecoverypassword_Visible = 1 ;
      divEmailserver_emailsubjectforrecoverypassword_cell_Class = "col-xs-12" ;
      chkavEmailserver_sendemailforrecoverypassword.setEnabled( 1 );
      edtavEmailserver_emailbodywhenuserchangeemail_Enabled = 1 ;
      edtavEmailserver_emailbodywhenuserchangeemail_Visible = 1 ;
      divEmailserver_emailbodywhenuserchangeemail_cell_Class = "col-xs-12" ;
      edtavEmailserver_emailsubjectwhenuserchangeemail_Jsonclick = "" ;
      edtavEmailserver_emailsubjectwhenuserchangeemail_Enabled = 1 ;
      edtavEmailserver_emailsubjectwhenuserchangeemail_Visible = 1 ;
      divEmailserver_emailsubjectwhenuserchangeemail_cell_Class = "col-xs-12" ;
      chkavEmailserver_sendemailwhenuserchangeemail.setEnabled( 1 );
      edtavEmailserver_emailbodywhenuserchangepassword_Enabled = 1 ;
      edtavEmailserver_emailbodywhenuserchangepassword_Visible = 1 ;
      divEmailserver_emailbodywhenuserchangepassword_cell_Class = "col-xs-12" ;
      edtavEmailserver_emailsubjectwhenuserchangepassword_Jsonclick = "" ;
      edtavEmailserver_emailsubjectwhenuserchangepassword_Enabled = 1 ;
      edtavEmailserver_emailsubjectwhenuserchangepassword_Visible = 1 ;
      divEmailserver_emailsubjectwhenuserchangepassword_cell_Class = "col-xs-12" ;
      chkavEmailserver_sendemailwhenuserchangepassword.setEnabled( 1 );
      edtavEmailserver_emailbodywhenuseractivateaccount_Enabled = 1 ;
      edtavEmailserver_emailbodywhenuseractivateaccount_Visible = 1 ;
      divEmailserver_emailbodywhenuseractivateaccount_cell_Class = "col-xs-12" ;
      edtavEmailserver_emailsubjectwhenuseractivateaccount_Jsonclick = "" ;
      edtavEmailserver_emailsubjectwhenuseractivateaccount_Enabled = 1 ;
      edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible = 1 ;
      divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class = "col-xs-12" ;
      chkavEmailserver_sendemailwhenuseractivateaccount.setEnabled( 1 );
      edtavEmailserverauthenticationuserpassword_Jsonclick = "" ;
      edtavEmailserverauthenticationuserpassword_Enabled = 1 ;
      edtavEmailserverauthenticationuserpassword_Visible = 1 ;
      divEmailserverauthenticationuserpassword_cell_Class = "col-xs-12 col-sm-6" ;
      edtavEmailserverauthenticationusername_Jsonclick = "" ;
      edtavEmailserverauthenticationusername_Enabled = 1 ;
      edtavEmailserverauthenticationusername_Visible = 1 ;
      divEmailserverauthenticationusername_cell_Class = "col-xs-12 col-sm-6" ;
      chkavEmailserverusesauthentication.setEnabled( 1 );
      edtavServersendername_Jsonclick = "" ;
      edtavServersendername_Enabled = 1 ;
      edtavServersenderaddress_Jsonclick = "" ;
      edtavServersenderaddress_Enabled = 1 ;
      chkavEmailserversecure.setEnabled( 1 );
      edtavEmailservertimeout_Jsonclick = "" ;
      edtavEmailservertimeout_Enabled = 1 ;
      edtavEmailserverport_Jsonclick = "" ;
      edtavEmailserverport_Enabled = 1 ;
      edtavEmailserverhost_Jsonclick = "" ;
      edtavEmailserverhost_Enabled = 1 ;
      edtavIntsecbydomainencryptionkey_Jsonclick = "" ;
      edtavIntsecbydomainencryptionkey_Enabled = 1 ;
      edtavIntsecbydomainjwtsecret_Jsonclick = "" ;
      edtavIntsecbydomainjwtsecret_Enabled = 1 ;
      cmbavIntsecbydomainmode.setJsonclick( "" );
      cmbavIntsecbydomainmode.setEnabled( 1 );
      divTblintsecbydomain_Visible = 1 ;
      chkavIntsecbydomainenable.setEnabled( 1 );
      edtavRepositorycachetimeout_Jsonclick = "" ;
      edtavRepositorycachetimeout_Enabled = 1 ;
      edtavMinimumamountcharactersinlogin_Jsonclick = "" ;
      edtavMinimumamountcharactersinlogin_Enabled = 1 ;
      edtavLoginattemptstolocksession_Jsonclick = "" ;
      edtavLoginattemptstolocksession_Enabled = 1 ;
      chkavSessionexpiresonipchange.setEnabled( 1 );
      chkavGiveanonymoussession.setEnabled( 1 );
      edtavUsersessioncachetimeout_Jsonclick = "" ;
      edtavUsersessioncachetimeout_Enabled = 1 ;
      cmbavGeneratesessionstatistics.setJsonclick( "" );
      cmbavGeneratesessionstatistics.setEnabled( 1 );
      chkavRequiredgender.setEnabled( 1 );
      chkavRequiredbirthday.setEnabled( 1 );
      chkavRequiredlastname.setEnabled( 1 );
      chkavRequiredfirstname.setEnabled( 1 );
      chkavRequiredpassword.setEnabled( 1 );
      chkavRequiredemail.setEnabled( 1 );
      chkavRequiredemail.setVisible( 1 );
      divRequiredemail_cell_Class = "col-xs-12 col-sm-6" ;
      edtavTotpsecretkeylength_Jsonclick = "" ;
      edtavTotpsecretkeylength_Enabled = 1 ;
      edtavUserremembermetimeout_Jsonclick = "" ;
      edtavUserremembermetimeout_Enabled = 1 ;
      cmbavUserremembermetype.setJsonclick( "" );
      cmbavUserremembermetype.setEnabled( 1 );
      edtavGamunblockusertimeout_Jsonclick = "" ;
      edtavGamunblockusertimeout_Enabled = 1 ;
      edtavLoginattemptstolockuser_Jsonclick = "" ;
      edtavLoginattemptstolockuser_Enabled = 1 ;
      edtavUserrecoverypasswordkeymonthlymaximum_Jsonclick = "" ;
      edtavUserrecoverypasswordkeymonthlymaximum_Enabled = 1 ;
      edtavUserrecoverypasswordkeydailymaximum_Jsonclick = "" ;
      edtavUserrecoverypasswordkeydailymaximum_Enabled = 1 ;
      edtavUserrecoverypasswordkeytimeout_Jsonclick = "" ;
      edtavUserrecoverypasswordkeytimeout_Enabled = 1 ;
      edtavUserautomaticactivationtimeout_Jsonclick = "" ;
      edtavUserautomaticactivationtimeout_Enabled = 1 ;
      cmbavUseractivationmethod.setJsonclick( "" );
      cmbavUseractivationmethod.setEnabled( 1 );
      chkavUseremailisunique.setEnabled( 1 );
      chkavUseremailisunique.setVisible( 1 );
      divUseremailisunique_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavUseridentification.setJsonclick( "" );
      cmbavUseridentification.setEnabled( 1 );
      chkavEnableworkingasgammanagerrepo.setEnabled( 1 );
      chkavEnableworkingasgammanagerrepo.setVisible( 1 );
      divEnableworkingasgammanagerrepo_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavLogoutbehavior.setJsonclick( "" );
      cmbavLogoutbehavior.setEnabled( 1 );
      chkavAllowoauthaccess.setEnabled( 1 );
      cmbavDefaultsecuritypolicyid.setJsonclick( "" );
      cmbavDefaultsecuritypolicyid.setEnabled( 1 );
      cmbavDefaultsecuritypolicyid.setVisible( 1 );
      divDefaultsecuritypolicyid_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavDefaultroleid.setJsonclick( "" );
      cmbavDefaultroleid.setEnabled( 1 );
      cmbavDefaultroleid.setVisible( 1 );
      divDefaultroleid_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavDefaultauthtypename.setJsonclick( "" );
      cmbavDefaultauthtypename.setEnabled( 1 );
      cmbavDefaultauthtypename.setVisible( 1 );
      divDefaultauthtypename_cell_Class = "col-xs-12 col-sm-6" ;
      edtavAuthenticationmasterrepository_Jsonclick = "" ;
      edtavAuthenticationmasterrepository_Enabled = 1 ;
      edtavAuthenticationmasterrepository_Visible = 1 ;
      divAuthenticationmasterrepository_cell_Class = "col-xs-12 col-sm-6" ;
      cmbavEnabletracing.setJsonclick( "" );
      cmbavEnabletracing.setEnabled( 1 );
      edtavDsc_Jsonclick = "" ;
      edtavDsc_Enabled = 1 ;
      edtavName_Jsonclick = "" ;
      edtavName_Enabled = 1 ;
      edtavNamespace_Jsonclick = "" ;
      edtavNamespace_Enabled = 1 ;
      edtavGuid_Jsonclick = "" ;
      edtavGuid_Enabled = 1 ;
      edtavRepoid_Jsonclick = "" ;
      edtavRepoid_Enabled = 1 ;
      lblTextblocktitle_Caption = httpContext.getMessage( "Title", "") ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Gxuitabspanel_tabs_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabs_Class = "" ;
      Gxuitabspanel_tabs_Pagecount = 4 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Repository configuration ", "") );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavEnabletracing.setName( "vENABLETRACING" );
      cmbavEnabletracing.setWebtags( "" );
      cmbavEnabletracing.addItem("0", httpContext.getMessage( "WWP_GAM_Tracing0", ""), (short)(0));
      cmbavEnabletracing.addItem("1", httpContext.getMessage( "WWP_GAM_Tracing1", ""), (short)(0));
      if ( cmbavEnabletracing.getItemCount() > 0 )
      {
         AV33EnableTracing = cmbavEnabletracing.getValidValue(AV33EnableTracing) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33EnableTracing", AV33EnableTracing);
      }
      cmbavDefaultauthtypename.setName( "vDEFAULTAUTHTYPENAME" );
      cmbavDefaultauthtypename.setWebtags( "" );
      if ( cmbavDefaultauthtypename.getItemCount() > 0 )
      {
         AV10DefaultAuthTypeName = cmbavDefaultauthtypename.getValidValue(AV10DefaultAuthTypeName) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10DefaultAuthTypeName", AV10DefaultAuthTypeName);
      }
      cmbavDefaultroleid.setName( "vDEFAULTROLEID" );
      cmbavDefaultroleid.setWebtags( "" );
      if ( cmbavDefaultroleid.getItemCount() > 0 )
      {
         AV11DefaultRoleId = GXutil.lval( cmbavDefaultroleid.getValidValue(GXutil.trim( GXutil.str( AV11DefaultRoleId, 12, 0)))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11DefaultRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DefaultRoleId), 12, 0));
      }
      cmbavDefaultsecuritypolicyid.setName( "vDEFAULTSECURITYPOLICYID" );
      cmbavDefaultsecuritypolicyid.setWebtags( "" );
      if ( cmbavDefaultsecuritypolicyid.getItemCount() > 0 )
      {
         AV12DefaultSecurityPolicyId = (int)(GXutil.lval( cmbavDefaultsecuritypolicyid.getValidValue(GXutil.trim( GXutil.str( AV12DefaultSecurityPolicyId, 9, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12DefaultSecurityPolicyId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12DefaultSecurityPolicyId), 9, 0));
      }
      chkavAllowoauthaccess.setName( "vALLOWOAUTHACCESS" );
      chkavAllowoauthaccess.setWebtags( "" );
      chkavAllowoauthaccess.setCaption( httpContext.getMessage( "WWP_GAM_RepositoryAllowOauthAcess", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavAllowoauthaccess.getInternalname(), "TitleCaption", chkavAllowoauthaccess.getCaption(), true);
      chkavAllowoauthaccess.setCheckedValue( "false" );
      AV5AllowOauthAccess = GXutil.strtobool( GXutil.booltostr( AV5AllowOauthAccess)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AllowOauthAccess", AV5AllowOauthAccess);
      cmbavLogoutbehavior.setName( "vLOGOUTBEHAVIOR" );
      cmbavLogoutbehavior.setWebtags( "" );
      cmbavLogoutbehavior.addItem("clionl", httpContext.getMessage( "WWP_GAM_ClientOnly", ""), (short)(0));
      cmbavLogoutbehavior.addItem("cliip", httpContext.getMessage( "WWP_GAM_IdentityProviderAndClient", ""), (short)(0));
      cmbavLogoutbehavior.addItem("all", httpContext.getMessage( "WWP_GAM_IdentityProviderAndAllClients", ""), (short)(0));
      if ( cmbavLogoutbehavior.getItemCount() > 0 )
      {
         AV55LogoutBehavior = cmbavLogoutbehavior.getValidValue(AV55LogoutBehavior) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55LogoutBehavior", AV55LogoutBehavior);
      }
      chkavEnableworkingasgammanagerrepo.setName( "vENABLEWORKINGASGAMMANAGERREPO" );
      chkavEnableworkingasgammanagerrepo.setWebtags( "" );
      chkavEnableworkingasgammanagerrepo.setCaption( httpContext.getMessage( "WWP_GAM_EnableWorkingAsGAMManagerRepo", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEnableworkingasgammanagerrepo.getInternalname(), "TitleCaption", chkavEnableworkingasgammanagerrepo.getCaption(), true);
      chkavEnableworkingasgammanagerrepo.setCheckedValue( "false" );
      AV35EnableWorkingAsGAMManagerRepo = GXutil.strtobool( GXutil.booltostr( AV35EnableWorkingAsGAMManagerRepo)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35EnableWorkingAsGAMManagerRepo", AV35EnableWorkingAsGAMManagerRepo);
      cmbavUseridentification.setName( "vUSERIDENTIFICATION" );
      cmbavUseridentification.setWebtags( "" );
      cmbavUseridentification.addItem("name", httpContext.getMessage( "WWP_GAM_Name", ""), (short)(0));
      cmbavUseridentification.addItem("email", httpContext.getMessage( "WWP_GAM_Email", ""), (short)(0));
      cmbavUseridentification.addItem("namema", httpContext.getMessage( "WWP_GAM_NameEmail", ""), (short)(0));
      if ( cmbavUseridentification.getItemCount() > 0 )
      {
         AV80UserIdentification = cmbavUseridentification.getValidValue(AV80UserIdentification) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV80UserIdentification", AV80UserIdentification);
      }
      chkavUseremailisunique.setName( "vUSEREMAILISUNIQUE" );
      chkavUseremailisunique.setWebtags( "" );
      chkavUseremailisunique.setCaption( httpContext.getMessage( "WWP_GAM_UserEmailIsUnique", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavUseremailisunique.getInternalname(), "TitleCaption", chkavUseremailisunique.getCaption(), true);
      chkavUseremailisunique.setCheckedValue( "false" );
      AV79UserEmailisUnique = GXutil.strtobool( GXutil.booltostr( AV79UserEmailisUnique)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV79UserEmailisUnique", AV79UserEmailisUnique);
      cmbavUseractivationmethod.setName( "vUSERACTIVATIONMETHOD" );
      cmbavUseractivationmethod.setWebtags( "" );
      cmbavUseractivationmethod.addItem("A", httpContext.getMessage( "WWP_GAM_Automatic", ""), (short)(0));
      cmbavUseractivationmethod.addItem("U", httpContext.getMessage( "WWP_GAM_User", ""), (short)(0));
      cmbavUseractivationmethod.addItem("D", httpContext.getMessage( "WWP_GAM_Administrator", ""), (short)(0));
      if ( cmbavUseractivationmethod.getItemCount() > 0 )
      {
         AV77UserActivationMethod = cmbavUseractivationmethod.getValidValue(AV77UserActivationMethod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV77UserActivationMethod", AV77UserActivationMethod);
      }
      cmbavUserremembermetype.setName( "vUSERREMEMBERMETYPE" );
      cmbavUserremembermetype.setWebtags( "" );
      cmbavUserremembermetype.addItem("None", httpContext.getMessage( "WWP_GAM_None", ""), (short)(0));
      cmbavUserremembermetype.addItem("Login", httpContext.getMessage( "WWP_GAM_Login", ""), (short)(0));
      cmbavUserremembermetype.addItem("Auth", httpContext.getMessage( "WWP_GAM_Authentication", ""), (short)(0));
      cmbavUserremembermetype.addItem("Both", httpContext.getMessage( "WWP_GAM_Both", ""), (short)(0));
      if ( cmbavUserremembermetype.getItemCount() > 0 )
      {
         AV85UserRememberMeType = cmbavUserremembermetype.getValidValue(AV85UserRememberMeType) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV85UserRememberMeType", AV85UserRememberMeType);
      }
      chkavRequiredemail.setName( "vREQUIREDEMAIL" );
      chkavRequiredemail.setWebtags( "" );
      chkavRequiredemail.setCaption( httpContext.getMessage( "WWP_GAM_Requiredemail", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRequiredemail.getInternalname(), "TitleCaption", chkavRequiredemail.getCaption(), true);
      chkavRequiredemail.setCheckedValue( "false" );
      AV64RequiredEmail = GXutil.strtobool( GXutil.booltostr( AV64RequiredEmail)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64RequiredEmail", AV64RequiredEmail);
      chkavRequiredpassword.setName( "vREQUIREDPASSWORD" );
      chkavRequiredpassword.setWebtags( "" );
      chkavRequiredpassword.setCaption( httpContext.getMessage( "WWP_GAM_Requiredpassword", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRequiredpassword.getInternalname(), "TitleCaption", chkavRequiredpassword.getCaption(), true);
      chkavRequiredpassword.setCheckedValue( "false" );
      AV68RequiredPassword = GXutil.strtobool( GXutil.booltostr( AV68RequiredPassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV68RequiredPassword", AV68RequiredPassword);
      chkavRequiredfirstname.setName( "vREQUIREDFIRSTNAME" );
      chkavRequiredfirstname.setWebtags( "" );
      chkavRequiredfirstname.setCaption( httpContext.getMessage( "WWP_GAM_Requiredfirstname", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRequiredfirstname.getInternalname(), "TitleCaption", chkavRequiredfirstname.getCaption(), true);
      chkavRequiredfirstname.setCheckedValue( "false" );
      AV65RequiredFirstName = GXutil.strtobool( GXutil.booltostr( AV65RequiredFirstName)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65RequiredFirstName", AV65RequiredFirstName);
      chkavRequiredlastname.setName( "vREQUIREDLASTNAME" );
      chkavRequiredlastname.setWebtags( "" );
      chkavRequiredlastname.setCaption( httpContext.getMessage( "WWP_GAM_Requiredlastname", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRequiredlastname.getInternalname(), "TitleCaption", chkavRequiredlastname.getCaption(), true);
      chkavRequiredlastname.setCheckedValue( "false" );
      AV67RequiredLastName = GXutil.strtobool( GXutil.booltostr( AV67RequiredLastName)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV67RequiredLastName", AV67RequiredLastName);
      chkavRequiredbirthday.setName( "vREQUIREDBIRTHDAY" );
      chkavRequiredbirthday.setWebtags( "" );
      chkavRequiredbirthday.setCaption( httpContext.getMessage( "WWP_GAM_RequiredBirthday", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRequiredbirthday.getInternalname(), "TitleCaption", chkavRequiredbirthday.getCaption(), true);
      chkavRequiredbirthday.setCheckedValue( "false" );
      AV63RequiredBirthday = GXutil.strtobool( GXutil.booltostr( AV63RequiredBirthday)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63RequiredBirthday", AV63RequiredBirthday);
      chkavRequiredgender.setName( "vREQUIREDGENDER" );
      chkavRequiredgender.setWebtags( "" );
      chkavRequiredgender.setCaption( httpContext.getMessage( "WWP_GAM_RequiredGender", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavRequiredgender.getInternalname(), "TitleCaption", chkavRequiredgender.getCaption(), true);
      chkavRequiredgender.setCheckedValue( "false" );
      AV66RequiredGender = GXutil.strtobool( GXutil.booltostr( AV66RequiredGender)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66RequiredGender", AV66RequiredGender);
      cmbavGeneratesessionstatistics.setName( "vGENERATESESSIONSTATISTICS" );
      cmbavGeneratesessionstatistics.setWebtags( "" );
      cmbavGeneratesessionstatistics.addItem("None", httpContext.getMessage( "WWP_GAM_None", ""), (short)(0));
      cmbavGeneratesessionstatistics.addItem("Minimum", httpContext.getMessage( "WWP_GAM_MinimumOnlyAuthUsers", ""), (short)(0));
      cmbavGeneratesessionstatistics.addItem("Detail", httpContext.getMessage( "WWP_GAM_DetailAuthAnonUsers", ""), (short)(0));
      cmbavGeneratesessionstatistics.addItem("Full", httpContext.getMessage( "WWP_GAM_FullLogAuthAndAnonUsers", ""), (short)(0));
      if ( cmbavGeneratesessionstatistics.getItemCount() > 0 )
      {
         AV42GenerateSessionStatistics = cmbavGeneratesessionstatistics.getValidValue(AV42GenerateSessionStatistics) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42GenerateSessionStatistics", AV42GenerateSessionStatistics);
      }
      chkavGiveanonymoussession.setName( "vGIVEANONYMOUSSESSION" );
      chkavGiveanonymoussession.setWebtags( "" );
      chkavGiveanonymoussession.setCaption( httpContext.getMessage( "WWP_GAM_GiveWebAnonymousSession", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavGiveanonymoussession.getInternalname(), "TitleCaption", chkavGiveanonymoussession.getCaption(), true);
      chkavGiveanonymoussession.setCheckedValue( "false" );
      AV43GiveAnonymousSession = GXutil.strtobool( GXutil.booltostr( AV43GiveAnonymousSession)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43GiveAnonymousSession", AV43GiveAnonymousSession);
      chkavSessionexpiresonipchange.setName( "vSESSIONEXPIRESONIPCHANGE" );
      chkavSessionexpiresonipchange.setWebtags( "" );
      chkavSessionexpiresonipchange.setCaption( httpContext.getMessage( "WWP_GAM_GAMsessionexpiresonIPchange", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavSessionexpiresonipchange.getInternalname(), "TitleCaption", chkavSessionexpiresonipchange.getCaption(), true);
      chkavSessionexpiresonipchange.setCheckedValue( "false" );
      AV76SessionExpiresOnIPChange = GXutil.strtobool( GXutil.booltostr( AV76SessionExpiresOnIPChange)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76SessionExpiresOnIPChange", AV76SessionExpiresOnIPChange);
      chkavIntsecbydomainenable.setName( "vINTSECBYDOMAINENABLE" );
      chkavIntsecbydomainenable.setWebtags( "" );
      chkavIntsecbydomainenable.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavIntsecbydomainenable.getInternalname(), "TitleCaption", chkavIntsecbydomainenable.getCaption(), true);
      chkavIntsecbydomainenable.setCheckedValue( "false" );
      AV51IntSecByDomainEnable = GXutil.strtobool( GXutil.booltostr( AV51IntSecByDomainEnable)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51IntSecByDomainEnable", AV51IntSecByDomainEnable);
      cmbavIntsecbydomainmode.setName( "vINTSECBYDOMAINMODE" );
      cmbavIntsecbydomainmode.setWebtags( "" );
      cmbavIntsecbydomainmode.addItem("server", httpContext.getMessage( "WWP_GAM_Server", ""), (short)(0));
      cmbavIntsecbydomainmode.addItem("client", httpContext.getMessage( "WWP_GAM_Client", ""), (short)(0));
      if ( cmbavIntsecbydomainmode.getItemCount() > 0 )
      {
         AV49IntSecByDomainMode = cmbavIntsecbydomainmode.getValidValue(AV49IntSecByDomainMode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49IntSecByDomainMode", AV49IntSecByDomainMode);
      }
      chkavEmailserversecure.setName( "vEMAILSERVERSECURE" );
      chkavEmailserversecure.setWebtags( "" );
      chkavEmailserversecure.setCaption( httpContext.getMessage( "WWP_GAM_Secure", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmailserversecure.getInternalname(), "TitleCaption", chkavEmailserversecure.getCaption(), true);
      chkavEmailserversecure.setCheckedValue( "false" );
      AV30EmailServerSecure = GXutil.strtobool( GXutil.booltostr( AV30EmailServerSecure)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30EmailServerSecure", AV30EmailServerSecure);
      chkavEmailserverusesauthentication.setName( "vEMAILSERVERUSESAUTHENTICATION" );
      chkavEmailserverusesauthentication.setWebtags( "" );
      chkavEmailserverusesauthentication.setCaption( httpContext.getMessage( "WWP_GAM_ServerRequireAudthentication", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmailserverusesauthentication.getInternalname(), "TitleCaption", chkavEmailserverusesauthentication.getCaption(), true);
      chkavEmailserverusesauthentication.setCheckedValue( "false" );
      AV32EmailServerUsesAuthentication = GXutil.strtobool( GXutil.booltostr( AV32EmailServerUsesAuthentication)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32EmailServerUsesAuthentication", AV32EmailServerUsesAuthentication);
      chkavEmailserver_sendemailwhenuseractivateaccount.setName( "vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT" );
      chkavEmailserver_sendemailwhenuseractivateaccount.setWebtags( "" );
      chkavEmailserver_sendemailwhenuseractivateaccount.setCaption( httpContext.getMessage( "WWP_GAM_SendEmailUserActivateAccount", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmailserver_sendemailwhenuseractivateaccount.getInternalname(), "TitleCaption", chkavEmailserver_sendemailwhenuseractivateaccount.getCaption(), true);
      chkavEmailserver_sendemailwhenuseractivateaccount.setCheckedValue( "false" );
      AV23EmailServer_SendEmailWhenUserActivateAccount = GXutil.strtobool( GXutil.booltostr( AV23EmailServer_SendEmailWhenUserActivateAccount)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23EmailServer_SendEmailWhenUserActivateAccount", AV23EmailServer_SendEmailWhenUserActivateAccount);
      chkavEmailserver_sendemailwhenuserchangepassword.setName( "vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD" );
      chkavEmailserver_sendemailwhenuserchangepassword.setWebtags( "" );
      chkavEmailserver_sendemailwhenuserchangepassword.setCaption( httpContext.getMessage( "WWP_GAM_SendEmailUserChangePassword", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmailserver_sendemailwhenuserchangepassword.getInternalname(), "TitleCaption", chkavEmailserver_sendemailwhenuserchangepassword.getCaption(), true);
      chkavEmailserver_sendemailwhenuserchangepassword.setCheckedValue( "false" );
      AV25EmailServer_SendEmailWhenUserChangePassword = GXutil.strtobool( GXutil.booltostr( AV25EmailServer_SendEmailWhenUserChangePassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25EmailServer_SendEmailWhenUserChangePassword", AV25EmailServer_SendEmailWhenUserChangePassword);
      chkavEmailserver_sendemailwhenuserchangeemail.setName( "vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL" );
      chkavEmailserver_sendemailwhenuserchangeemail.setWebtags( "" );
      chkavEmailserver_sendemailwhenuserchangeemail.setCaption( httpContext.getMessage( "WWP_GAM_SendEmailUserChangeEmailUsername", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmailserver_sendemailwhenuserchangeemail.getInternalname(), "TitleCaption", chkavEmailserver_sendemailwhenuserchangeemail.getCaption(), true);
      chkavEmailserver_sendemailwhenuserchangeemail.setCheckedValue( "false" );
      AV24EmailServer_SendEmailWhenUserChangeEmail = GXutil.strtobool( GXutil.booltostr( AV24EmailServer_SendEmailWhenUserChangeEmail)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24EmailServer_SendEmailWhenUserChangeEmail", AV24EmailServer_SendEmailWhenUserChangeEmail);
      chkavEmailserver_sendemailforrecoverypassword.setName( "vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD" );
      chkavEmailserver_sendemailforrecoverypassword.setWebtags( "" );
      chkavEmailserver_sendemailforrecoverypassword.setCaption( httpContext.getMessage( "WWP_GAM_SendEmailRecoveryPassword", "") );
      httpContext.ajax_rsp_assign_prop("", false, chkavEmailserver_sendemailforrecoverypassword.getInternalname(), "TitleCaption", chkavEmailserver_sendemailforrecoverypassword.getCaption(), true);
      chkavEmailserver_sendemailforrecoverypassword.setCheckedValue( "false" );
      AV22EmailServer_SendEmailForRecoveryPassword = GXutil.strtobool( GXutil.booltostr( AV22EmailServer_SendEmailForRecoveryPassword)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22EmailServer_SendEmailForRecoveryPassword", AV22EmailServer_SendEmailForRecoveryPassword);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV5AllowOauthAccess',fld:'vALLOWOAUTHACCESS',pic:''},{av:'AV35EnableWorkingAsGAMManagerRepo',fld:'vENABLEWORKINGASGAMMANAGERREPO',pic:''},{av:'AV79UserEmailisUnique',fld:'vUSEREMAILISUNIQUE',pic:''},{av:'AV64RequiredEmail',fld:'vREQUIREDEMAIL',pic:''},{av:'AV68RequiredPassword',fld:'vREQUIREDPASSWORD',pic:''},{av:'AV65RequiredFirstName',fld:'vREQUIREDFIRSTNAME',pic:''},{av:'AV67RequiredLastName',fld:'vREQUIREDLASTNAME',pic:''},{av:'AV63RequiredBirthday',fld:'vREQUIREDBIRTHDAY',pic:''},{av:'AV66RequiredGender',fld:'vREQUIREDGENDER',pic:''},{av:'AV43GiveAnonymousSession',fld:'vGIVEANONYMOUSSESSION',pic:''},{av:'AV76SessionExpiresOnIPChange',fld:'vSESSIONEXPIRESONIPCHANGE',pic:''},{av:'AV51IntSecByDomainEnable',fld:'vINTSECBYDOMAINENABLE',pic:''},{av:'AV30EmailServerSecure',fld:'vEMAILSERVERSECURE',pic:''},{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'AV71SecurityAdministratorEmail',fld:'vSECURITYADMINISTRATOREMAIL',pic:'',hsh:true},{av:'AV9CanRegisterUsers',fld:'vCANREGISTERUSERS',pic:'',hsh:true},{av:'AV45Id',fld:'vID',pic:'ZZZZZZZZZZZ9',hsh:true},{av:'AV59RepoId',fld:'vREPOID',pic:'ZZZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e12342',iparms:[{av:'AV59RepoId',fld:'vREPOID',pic:'ZZZZZZZZZZZ9'},{av:'AV57Name',fld:'vNAME',pic:''},{av:'AV13Dsc',fld:'vDSC',pic:''},{av:'cmbavDefaultauthtypename'},{av:'AV10DefaultAuthTypeName',fld:'vDEFAULTAUTHTYPENAME',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''},{av:'cmbavGeneratesessionstatistics'},{av:'AV42GenerateSessionStatistics',fld:'vGENERATESESSIONSTATISTICS',pic:''},{av:'cmbavUseractivationmethod'},{av:'AV77UserActivationMethod',fld:'vUSERACTIVATIONMETHOD',pic:''},{av:'AV78UserAutomaticActivationTimeout',fld:'vUSERAUTOMATICACTIVATIONTIMEOUT',pic:'ZZZ9'},{av:'AV41GAMUnblockUserTimeout',fld:'vGAMUNBLOCKUSERTIMEOUT',pic:'ZZZ9'},{av:'cmbavUserremembermetype'},{av:'AV85UserRememberMeType',fld:'vUSERREMEMBERMETYPE',pic:''},{av:'AV84UserRememberMeTimeOut',fld:'vUSERREMEMBERMETIMEOUT',pic:'ZZZ9'},{av:'AV81UserRecoveryPasswordKeyTimeOut',fld:'vUSERRECOVERYPASSWORDKEYTIMEOUT',pic:'ZZZ9'},{av:'AV82UserRecoveryPasswordKeyDailyMaximum',fld:'vUSERRECOVERYPASSWORDKEYDAILYMAXIMUM',pic:'ZZZ9'},{av:'AV83UserRecoveryPasswordKeyMonthlyMaximum',fld:'vUSERRECOVERYPASSWORDKEYMONTHLYMAXIMUM',pic:'ZZZ9'},{av:'cmbavLogoutbehavior'},{av:'AV55LogoutBehavior',fld:'vLOGOUTBEHAVIOR',pic:''},{av:'AV56MinimumAmountCharactersInLogin',fld:'vMINIMUMAMOUNTCHARACTERSINLOGIN',pic:'Z9'},{av:'AV54LoginAttemptsToLockUser',fld:'vLOGINATTEMPTSTOLOCKUSER',pic:'Z9'},{av:'AV53LoginAttemptsToLockSession',fld:'vLOGINATTEMPTSTOLOCKSESSION',pic:'Z9'},{av:'AV86UserSessionCacheTimeout',fld:'vUSERSESSIONCACHETIMEOUT',pic:'ZZZZZZZZ9'},{av:'AV61RepositoryCacheTimeout',fld:'vREPOSITORYCACHETIMEOUT',pic:'ZZZZZZZZ9'},{av:'AV71SecurityAdministratorEmail',fld:'vSECURITYADMINISTRATOREMAIL',pic:'',hsh:true},{av:'AV43GiveAnonymousSession',fld:'vGIVEANONYMOUSSESSION',pic:''},{av:'AV9CanRegisterUsers',fld:'vCANREGISTERUSERS',pic:'',hsh:true},{av:'AV79UserEmailisUnique',fld:'vUSEREMAILISUNIQUE',pic:''},{av:'cmbavDefaultroleid'},{av:'AV11DefaultRoleId',fld:'vDEFAULTROLEID',pic:'ZZZZZZZZZZZ9'},{av:'cmbavDefaultsecuritypolicyid'},{av:'AV12DefaultSecurityPolicyId',fld:'vDEFAULTSECURITYPOLICYID',pic:'ZZZZZZZZ9'},{av:'AV35EnableWorkingAsGAMManagerRepo',fld:'vENABLEWORKINGASGAMMANAGERREPO',pic:''},{av:'cmbavEnabletracing'},{av:'AV33EnableTracing',fld:'vENABLETRACING',pic:''},{av:'AV5AllowOauthAccess',fld:'vALLOWOAUTHACCESS',pic:''},{av:'AV76SessionExpiresOnIPChange',fld:'vSESSIONEXPIRESONIPCHANGE',pic:''},{av:'AV51IntSecByDomainEnable',fld:'vINTSECBYDOMAINENABLE',pic:''},{av:'cmbavIntsecbydomainmode'},{av:'AV49IntSecByDomainMode',fld:'vINTSECBYDOMAINMODE',pic:''},{av:'AV48IntSecByDomainJWTSecret',fld:'vINTSECBYDOMAINJWTSECRET',pic:''},{av:'AV47IntSecByDomainEncryptionKey',fld:'vINTSECBYDOMAINENCRYPTIONKEY',pic:''},{av:'AV50TOTPSecretKeyLength',fld:'vTOTPSECRETKEYLENGTH',pic:'ZZZZZZZZZZZ9'},{av:'AV68RequiredPassword',fld:'vREQUIREDPASSWORD',pic:''},{av:'AV64RequiredEmail',fld:'vREQUIREDEMAIL',pic:''},{av:'AV65RequiredFirstName',fld:'vREQUIREDFIRSTNAME',pic:''},{av:'AV67RequiredLastName',fld:'vREQUIREDLASTNAME',pic:''},{av:'AV63RequiredBirthday',fld:'vREQUIREDBIRTHDAY',pic:''},{av:'AV66RequiredGender',fld:'vREQUIREDGENDER',pic:''},{av:'AV28EmailServerHost',fld:'vEMAILSERVERHOST',pic:''},{av:'AV29EmailServerPort',fld:'vEMAILSERVERPORT',pic:'ZZZ9'},{av:'AV30EmailServerSecure',fld:'vEMAILSERVERSECURE',pic:''},{av:'AV31EmailServerTimeout',fld:'vEMAILSERVERTIMEOUT',pic:'ZZZ9'},{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV74ServerSenderAddress',fld:'vSERVERSENDERADDRESS',pic:''},{av:'AV75ServerSenderName',fld:'vSERVERSENDERNAME',pic:''},{av:'AV26EmailServerAuthenticationUsername',fld:'vEMAILSERVERAUTHENTICATIONUSERNAME',pic:''},{av:'AV27EmailServerAuthenticationUserPassword',fld:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV19EmailServer_EmailSubjectWhenUserActivateAccount',fld:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV15EmailServer_EmailBodyWhenUserActivateAccount',fld:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV21EmailServer_EmailSubjectWhenUserChangePassword',fld:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',pic:''},{av:'AV17EmailServer_EmailBodyWhenUserChangePassword',fld:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV20EmailServer_EmailSubjectWhenUserChangeEmail',fld:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',pic:''},{av:'AV16EmailServer_EmailBodyWhenUserChangeEmail',fld:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'AV18EmailServer_EmailSubjectForRecoveryPassword',fld:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',pic:''},{av:'AV14EmailServer_EmailBodyForRecoveryPassword',fld:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("VUSERIDENTIFICATION.CONTROLVALUECHANGED","{handler:'e13342',iparms:[{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''}]");
      setEventMetadata("VUSERIDENTIFICATION.CONTROLVALUECHANGED",",oparms:[{av:'edtavEmailserverauthenticationusername_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERNAME',prop:'Visible'},{av:'divEmailserverauthenticationusername_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERNAME_CELL',prop:'Class'},{av:'edtavEmailserverauthenticationuserpassword_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',prop:'Visible'},{av:'divEmailserverauthenticationuserpassword_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailbodywhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodyforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodyforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'chkavUseremailisunique.getVisible()',ctrl:'vUSEREMAILISUNIQUE',prop:'Visible'},{av:'divUseremailisunique_cell_Class',ctrl:'USEREMAILISUNIQUE_CELL',prop:'Class'},{av:'chkavRequiredemail.getVisible()',ctrl:'vREQUIREDEMAIL',prop:'Visible'},{av:'divRequiredemail_cell_Class',ctrl:'REQUIREDEMAIL_CELL',prop:'Class'},{av:'edtavAuthenticationmasterrepository_Visible',ctrl:'vAUTHENTICATIONMASTERREPOSITORY',prop:'Visible'},{av:'divAuthenticationmasterrepository_cell_Class',ctrl:'AUTHENTICATIONMASTERREPOSITORY_CELL',prop:'Class'},{av:'cmbavDefaultauthtypename'},{av:'divDefaultauthtypename_cell_Class',ctrl:'DEFAULTAUTHTYPENAME_CELL',prop:'Class'},{av:'cmbavDefaultroleid'},{av:'divDefaultroleid_cell_Class',ctrl:'DEFAULTROLEID_CELL',prop:'Class'},{av:'cmbavDefaultsecuritypolicyid'},{av:'divDefaultsecuritypolicyid_cell_Class',ctrl:'DEFAULTSECURITYPOLICYID_CELL',prop:'Class'},{av:'chkavEnableworkingasgammanagerrepo.getVisible()',ctrl:'vENABLEWORKINGASGAMMANAGERREPO',prop:'Visible'},{av:'divEnableworkingasgammanagerrepo_cell_Class',ctrl:'ENABLEWORKINGASGAMMANAGERREPO_CELL',prop:'Class'}]}");
      setEventMetadata("VEMAILSERVERUSESAUTHENTICATION.CLICK","{handler:'e14342',iparms:[{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''}]");
      setEventMetadata("VEMAILSERVERUSESAUTHENTICATION.CLICK",",oparms:[{av:'edtavEmailserverauthenticationusername_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERNAME',prop:'Visible'},{av:'divEmailserverauthenticationusername_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERNAME_CELL',prop:'Class'},{av:'edtavEmailserverauthenticationuserpassword_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',prop:'Visible'},{av:'divEmailserverauthenticationuserpassword_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailbodywhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodyforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodyforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'chkavUseremailisunique.getVisible()',ctrl:'vUSEREMAILISUNIQUE',prop:'Visible'},{av:'divUseremailisunique_cell_Class',ctrl:'USEREMAILISUNIQUE_CELL',prop:'Class'},{av:'chkavRequiredemail.getVisible()',ctrl:'vREQUIREDEMAIL',prop:'Visible'},{av:'divRequiredemail_cell_Class',ctrl:'REQUIREDEMAIL_CELL',prop:'Class'},{av:'edtavAuthenticationmasterrepository_Visible',ctrl:'vAUTHENTICATIONMASTERREPOSITORY',prop:'Visible'},{av:'divAuthenticationmasterrepository_cell_Class',ctrl:'AUTHENTICATIONMASTERREPOSITORY_CELL',prop:'Class'},{av:'cmbavDefaultauthtypename'},{av:'divDefaultauthtypename_cell_Class',ctrl:'DEFAULTAUTHTYPENAME_CELL',prop:'Class'},{av:'cmbavDefaultroleid'},{av:'divDefaultroleid_cell_Class',ctrl:'DEFAULTROLEID_CELL',prop:'Class'},{av:'cmbavDefaultsecuritypolicyid'},{av:'divDefaultsecuritypolicyid_cell_Class',ctrl:'DEFAULTSECURITYPOLICYID_CELL',prop:'Class'},{av:'chkavEnableworkingasgammanagerrepo.getVisible()',ctrl:'vENABLEWORKINGASGAMMANAGERREPO',prop:'Visible'},{av:'divEnableworkingasgammanagerrepo_cell_Class',ctrl:'ENABLEWORKINGASGAMMANAGERREPO_CELL',prop:'Class'}]}");
      setEventMetadata("VEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT.CLICK","{handler:'e15342',iparms:[{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''}]");
      setEventMetadata("VEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT.CLICK",",oparms:[{av:'edtavEmailserverauthenticationusername_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERNAME',prop:'Visible'},{av:'divEmailserverauthenticationusername_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERNAME_CELL',prop:'Class'},{av:'edtavEmailserverauthenticationuserpassword_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',prop:'Visible'},{av:'divEmailserverauthenticationuserpassword_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailbodywhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodyforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodyforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'chkavUseremailisunique.getVisible()',ctrl:'vUSEREMAILISUNIQUE',prop:'Visible'},{av:'divUseremailisunique_cell_Class',ctrl:'USEREMAILISUNIQUE_CELL',prop:'Class'},{av:'chkavRequiredemail.getVisible()',ctrl:'vREQUIREDEMAIL',prop:'Visible'},{av:'divRequiredemail_cell_Class',ctrl:'REQUIREDEMAIL_CELL',prop:'Class'},{av:'edtavAuthenticationmasterrepository_Visible',ctrl:'vAUTHENTICATIONMASTERREPOSITORY',prop:'Visible'},{av:'divAuthenticationmasterrepository_cell_Class',ctrl:'AUTHENTICATIONMASTERREPOSITORY_CELL',prop:'Class'},{av:'cmbavDefaultauthtypename'},{av:'divDefaultauthtypename_cell_Class',ctrl:'DEFAULTAUTHTYPENAME_CELL',prop:'Class'},{av:'cmbavDefaultroleid'},{av:'divDefaultroleid_cell_Class',ctrl:'DEFAULTROLEID_CELL',prop:'Class'},{av:'cmbavDefaultsecuritypolicyid'},{av:'divDefaultsecuritypolicyid_cell_Class',ctrl:'DEFAULTSECURITYPOLICYID_CELL',prop:'Class'},{av:'chkavEnableworkingasgammanagerrepo.getVisible()',ctrl:'vENABLEWORKINGASGAMMANAGERREPO',prop:'Visible'},{av:'divEnableworkingasgammanagerrepo_cell_Class',ctrl:'ENABLEWORKINGASGAMMANAGERREPO_CELL',prop:'Class'}]}");
      setEventMetadata("VEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD.CLICK","{handler:'e16342',iparms:[{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''}]");
      setEventMetadata("VEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD.CLICK",",oparms:[{av:'edtavEmailserverauthenticationusername_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERNAME',prop:'Visible'},{av:'divEmailserverauthenticationusername_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERNAME_CELL',prop:'Class'},{av:'edtavEmailserverauthenticationuserpassword_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',prop:'Visible'},{av:'divEmailserverauthenticationuserpassword_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailbodywhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodyforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodyforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'chkavUseremailisunique.getVisible()',ctrl:'vUSEREMAILISUNIQUE',prop:'Visible'},{av:'divUseremailisunique_cell_Class',ctrl:'USEREMAILISUNIQUE_CELL',prop:'Class'},{av:'chkavRequiredemail.getVisible()',ctrl:'vREQUIREDEMAIL',prop:'Visible'},{av:'divRequiredemail_cell_Class',ctrl:'REQUIREDEMAIL_CELL',prop:'Class'},{av:'edtavAuthenticationmasterrepository_Visible',ctrl:'vAUTHENTICATIONMASTERREPOSITORY',prop:'Visible'},{av:'divAuthenticationmasterrepository_cell_Class',ctrl:'AUTHENTICATIONMASTERREPOSITORY_CELL',prop:'Class'},{av:'cmbavDefaultauthtypename'},{av:'divDefaultauthtypename_cell_Class',ctrl:'DEFAULTAUTHTYPENAME_CELL',prop:'Class'},{av:'cmbavDefaultroleid'},{av:'divDefaultroleid_cell_Class',ctrl:'DEFAULTROLEID_CELL',prop:'Class'},{av:'cmbavDefaultsecuritypolicyid'},{av:'divDefaultsecuritypolicyid_cell_Class',ctrl:'DEFAULTSECURITYPOLICYID_CELL',prop:'Class'},{av:'chkavEnableworkingasgammanagerrepo.getVisible()',ctrl:'vENABLEWORKINGASGAMMANAGERREPO',prop:'Visible'},{av:'divEnableworkingasgammanagerrepo_cell_Class',ctrl:'ENABLEWORKINGASGAMMANAGERREPO_CELL',prop:'Class'}]}");
      setEventMetadata("VEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL.CLICK","{handler:'e17342',iparms:[{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''}]");
      setEventMetadata("VEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL.CLICK",",oparms:[{av:'edtavEmailserverauthenticationusername_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERNAME',prop:'Visible'},{av:'divEmailserverauthenticationusername_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERNAME_CELL',prop:'Class'},{av:'edtavEmailserverauthenticationuserpassword_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',prop:'Visible'},{av:'divEmailserverauthenticationuserpassword_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailbodywhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodyforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodyforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'chkavUseremailisunique.getVisible()',ctrl:'vUSEREMAILISUNIQUE',prop:'Visible'},{av:'divUseremailisunique_cell_Class',ctrl:'USEREMAILISUNIQUE_CELL',prop:'Class'},{av:'chkavRequiredemail.getVisible()',ctrl:'vREQUIREDEMAIL',prop:'Visible'},{av:'divRequiredemail_cell_Class',ctrl:'REQUIREDEMAIL_CELL',prop:'Class'},{av:'edtavAuthenticationmasterrepository_Visible',ctrl:'vAUTHENTICATIONMASTERREPOSITORY',prop:'Visible'},{av:'divAuthenticationmasterrepository_cell_Class',ctrl:'AUTHENTICATIONMASTERREPOSITORY_CELL',prop:'Class'},{av:'cmbavDefaultauthtypename'},{av:'divDefaultauthtypename_cell_Class',ctrl:'DEFAULTAUTHTYPENAME_CELL',prop:'Class'},{av:'cmbavDefaultroleid'},{av:'divDefaultroleid_cell_Class',ctrl:'DEFAULTROLEID_CELL',prop:'Class'},{av:'cmbavDefaultsecuritypolicyid'},{av:'divDefaultsecuritypolicyid_cell_Class',ctrl:'DEFAULTSECURITYPOLICYID_CELL',prop:'Class'},{av:'chkavEnableworkingasgammanagerrepo.getVisible()',ctrl:'vENABLEWORKINGASGAMMANAGERREPO',prop:'Visible'},{av:'divEnableworkingasgammanagerrepo_cell_Class',ctrl:'ENABLEWORKINGASGAMMANAGERREPO_CELL',prop:'Class'}]}");
      setEventMetadata("VEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD.CLICK","{handler:'e18342',iparms:[{av:'AV32EmailServerUsesAuthentication',fld:'vEMAILSERVERUSESAUTHENTICATION',pic:''},{av:'AV23EmailServer_SendEmailWhenUserActivateAccount',fld:'vEMAILSERVER_SENDEMAILWHENUSERACTIVATEACCOUNT',pic:''},{av:'AV25EmailServer_SendEmailWhenUserChangePassword',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEPASSWORD',pic:''},{av:'AV24EmailServer_SendEmailWhenUserChangeEmail',fld:'vEMAILSERVER_SENDEMAILWHENUSERCHANGEEMAIL',pic:''},{av:'AV22EmailServer_SendEmailForRecoveryPassword',fld:'vEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD',pic:''},{av:'cmbavUseridentification'},{av:'AV80UserIdentification',fld:'vUSERIDENTIFICATION',pic:''}]");
      setEventMetadata("VEMAILSERVER_SENDEMAILFORRECOVERYPASSWORD.CLICK",",oparms:[{av:'edtavEmailserverauthenticationusername_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERNAME',prop:'Visible'},{av:'divEmailserverauthenticationusername_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERNAME_CELL',prop:'Class'},{av:'edtavEmailserverauthenticationuserpassword_Visible',ctrl:'vEMAILSERVERAUTHENTICATIONUSERPASSWORD',prop:'Visible'},{av:'divEmailserverauthenticationuserpassword_cell_Class',ctrl:'EMAILSERVERAUTHENTICATIONUSERPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuseractivateaccount_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT',prop:'Visible'},{av:'divEmailserver_emailbodywhenuseractivateaccount_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERACTIVATEACCOUNT_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangepassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangepassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectwhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailsubjectwhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodywhenuserchangeemail_Visible',ctrl:'vEMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL',prop:'Visible'},{av:'divEmailserver_emailbodywhenuserchangeemail_cell_Class',ctrl:'EMAILSERVER_EMAILBODYWHENUSERCHANGEEMAIL_CELL',prop:'Class'},{av:'edtavEmailserver_emailsubjectforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailsubjectforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILSUBJECTFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'edtavEmailserver_emailbodyforrecoverypassword_Visible',ctrl:'vEMAILSERVER_EMAILBODYFORRECOVERYPASSWORD',prop:'Visible'},{av:'divEmailserver_emailbodyforrecoverypassword_cell_Class',ctrl:'EMAILSERVER_EMAILBODYFORRECOVERYPASSWORD_CELL',prop:'Class'},{av:'chkavUseremailisunique.getVisible()',ctrl:'vUSEREMAILISUNIQUE',prop:'Visible'},{av:'divUseremailisunique_cell_Class',ctrl:'USEREMAILISUNIQUE_CELL',prop:'Class'},{av:'chkavRequiredemail.getVisible()',ctrl:'vREQUIREDEMAIL',prop:'Visible'},{av:'divRequiredemail_cell_Class',ctrl:'REQUIREDEMAIL_CELL',prop:'Class'},{av:'edtavAuthenticationmasterrepository_Visible',ctrl:'vAUTHENTICATIONMASTERREPOSITORY',prop:'Visible'},{av:'divAuthenticationmasterrepository_cell_Class',ctrl:'AUTHENTICATIONMASTERREPOSITORY_CELL',prop:'Class'},{av:'cmbavDefaultauthtypename'},{av:'divDefaultauthtypename_cell_Class',ctrl:'DEFAULTAUTHTYPENAME_CELL',prop:'Class'},{av:'cmbavDefaultroleid'},{av:'divDefaultroleid_cell_Class',ctrl:'DEFAULTROLEID_CELL',prop:'Class'},{av:'cmbavDefaultsecuritypolicyid'},{av:'divDefaultsecuritypolicyid_cell_Class',ctrl:'DEFAULTSECURITYPOLICYID_CELL',prop:'Class'},{av:'chkavEnableworkingasgammanagerrepo.getVisible()',ctrl:'vENABLEWORKINGASGAMMANAGERREPO',prop:'Visible'},{av:'divEnableworkingasgammanagerrepo_cell_Class',ctrl:'ENABLEWORKINGASGAMMANAGERREPO_CELL',prop:'Class'}]}");
      setEventMetadata("VALIDV_LOGOUTBEHAVIOR","{handler:'validv_Logoutbehavior',iparms:[]");
      setEventMetadata("VALIDV_LOGOUTBEHAVIOR",",oparms:[]}");
      setEventMetadata("VALIDV_USERIDENTIFICATION","{handler:'validv_Useridentification',iparms:[]");
      setEventMetadata("VALIDV_USERIDENTIFICATION",",oparms:[]}");
      setEventMetadata("VALIDV_USERACTIVATIONMETHOD","{handler:'validv_Useractivationmethod',iparms:[]");
      setEventMetadata("VALIDV_USERACTIVATIONMETHOD",",oparms:[]}");
      setEventMetadata("VALIDV_USERREMEMBERMETYPE","{handler:'validv_Userremembermetype',iparms:[]");
      setEventMetadata("VALIDV_USERREMEMBERMETYPE",",oparms:[]}");
      setEventMetadata("VALIDV_GENERATESESSIONSTATISTICS","{handler:'validv_Generatesessionstatistics',iparms:[]");
      setEventMetadata("VALIDV_GENERATESESSIONSTATISTICS",",oparms:[]}");
      setEventMetadata("VALIDV_INTSECBYDOMAINMODE","{handler:'validv_Intsecbydomainmode',iparms:[]");
      setEventMetadata("VALIDV_INTSECBYDOMAINMODE",",oparms:[]}");
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
      return "gamrepositoryconfiguration_Execute";
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
      AV71SecurityAdministratorEmail = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGxuitabspanel_tabs = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      TempTags = "" ;
      AV44GUID = "" ;
      AV58NameSpace = "" ;
      AV57Name = "" ;
      AV13Dsc = "" ;
      AV33EnableTracing = "" ;
      AV6AuthenticationMasterRepository = "" ;
      AV10DefaultAuthTypeName = "" ;
      AV55LogoutBehavior = "" ;
      lblUsers_title_Jsonclick = "" ;
      AV80UserIdentification = "" ;
      AV77UserActivationMethod = "" ;
      AV85UserRememberMeType = "" ;
      lblSession_title_Jsonclick = "" ;
      AV42GenerateSessionStatistics = "" ;
      AV49IntSecByDomainMode = "" ;
      AV48IntSecByDomainJWTSecret = "" ;
      AV47IntSecByDomainEncryptionKey = "" ;
      lblTabemail_title_Jsonclick = "" ;
      AV28EmailServerHost = "" ;
      AV74ServerSenderAddress = "" ;
      AV75ServerSenderName = "" ;
      AV26EmailServerAuthenticationUsername = "" ;
      AV27EmailServerAuthenticationUserPassword = "" ;
      AV19EmailServer_EmailSubjectWhenUserActivateAccount = "" ;
      AV15EmailServer_EmailBodyWhenUserActivateAccount = "" ;
      AV21EmailServer_EmailSubjectWhenUserChangePassword = "" ;
      AV17EmailServer_EmailBodyWhenUserChangePassword = "" ;
      AV20EmailServer_EmailSubjectWhenUserChangeEmail = "" ;
      AV16EmailServer_EmailBodyWhenUserChangeEmail = "" ;
      AV18EmailServer_EmailSubjectForRecoveryPassword = "" ;
      AV14EmailServer_EmailBodyForRecoveryPassword = "" ;
      bttBtnenter_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      hsh = "" ;
      AV8AuthenticationTypes = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple>(genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple.class, "GAMAuthenticationTypeSimple", "http://tempuri.org/", remoteHandle);
      AV52Language = "" ;
      AV37Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV7AuthenticationType = new genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple(remoteHandle, context);
      AV72SecurityPolicies = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSecurityPolicy>(genexus.security.api.genexussecurity.SdtGAMSecurityPolicy.class, "GAMSecurityPolicy", "http://tempuri.org/", remoteHandle);
      AV40FilterSecPol = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicyFilter(remoteHandle, context);
      AV73SecurityPolicy = new genexus.security.api.genexussecurity.SdtGAMSecurityPolicy(remoteHandle, context);
      AV70Roles = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRole>(genexus.security.api.genexussecurity.SdtGAMRole.class, "GAMRole", "http://tempuri.org/", remoteHandle);
      AV39FilterRole = new genexus.security.api.genexussecurity.SdtGAMRoleFilter(remoteHandle, context);
      AV69Role = new genexus.security.api.genexussecurity.SdtGAMRole(remoteHandle, context);
      AV60Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV62RepositoryCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRepository>(genexus.security.api.genexussecurity.SdtGAMRepository.class, "GAMRepository", "http://tempuri.org/", remoteHandle);
      AV38Filter = new genexus.security.api.genexussecurity.SdtGAMRepositoryFilter(remoteHandle, context);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV87GAMRepositoryItem = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV36Error = new genexus.security.api.genexussecurity.SdtGAMError(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamrepositoryconfiguration__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamrepositoryconfiguration__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavRepoid_Enabled = 0 ;
      edtavGuid_Enabled = 0 ;
      edtavNamespace_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV54LoginAttemptsToLockUser ;
   private byte AV53LoginAttemptsToLockSession ;
   private byte AV56MinimumAmountCharactersInLogin ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV78UserAutomaticActivationTimeout ;
   private short AV81UserRecoveryPasswordKeyTimeOut ;
   private short AV82UserRecoveryPasswordKeyDailyMaximum ;
   private short AV83UserRecoveryPasswordKeyMonthlyMaximum ;
   private short AV41GAMUnblockUserTimeout ;
   private short AV84UserRememberMeTimeOut ;
   private short AV29EmailServerPort ;
   private short AV31EmailServerTimeout ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV34EnableTracingNumeric ;
   private int Gxuitabspanel_tabs_Pagecount ;
   private int edtavRepoid_Enabled ;
   private int edtavGuid_Enabled ;
   private int edtavNamespace_Enabled ;
   private int edtavName_Enabled ;
   private int edtavDsc_Enabled ;
   private int edtavAuthenticationmasterrepository_Visible ;
   private int edtavAuthenticationmasterrepository_Enabled ;
   private int AV12DefaultSecurityPolicyId ;
   private int edtavUserautomaticactivationtimeout_Enabled ;
   private int edtavUserrecoverypasswordkeytimeout_Enabled ;
   private int edtavUserrecoverypasswordkeydailymaximum_Enabled ;
   private int edtavUserrecoverypasswordkeymonthlymaximum_Enabled ;
   private int edtavLoginattemptstolockuser_Enabled ;
   private int edtavGamunblockusertimeout_Enabled ;
   private int edtavUserremembermetimeout_Enabled ;
   private int edtavTotpsecretkeylength_Enabled ;
   private int AV86UserSessionCacheTimeout ;
   private int edtavUsersessioncachetimeout_Enabled ;
   private int edtavLoginattemptstolocksession_Enabled ;
   private int edtavMinimumamountcharactersinlogin_Enabled ;
   private int AV61RepositoryCacheTimeout ;
   private int edtavRepositorycachetimeout_Enabled ;
   private int divTblintsecbydomain_Visible ;
   private int edtavIntsecbydomainjwtsecret_Enabled ;
   private int edtavIntsecbydomainencryptionkey_Enabled ;
   private int edtavEmailserverhost_Enabled ;
   private int edtavEmailserverport_Enabled ;
   private int edtavEmailservertimeout_Enabled ;
   private int edtavServersenderaddress_Enabled ;
   private int edtavServersendername_Enabled ;
   private int edtavEmailserverauthenticationusername_Visible ;
   private int edtavEmailserverauthenticationusername_Enabled ;
   private int edtavEmailserverauthenticationuserpassword_Visible ;
   private int edtavEmailserverauthenticationuserpassword_Enabled ;
   private int edtavEmailserver_emailsubjectwhenuseractivateaccount_Visible ;
   private int edtavEmailserver_emailsubjectwhenuseractivateaccount_Enabled ;
   private int edtavEmailserver_emailbodywhenuseractivateaccount_Visible ;
   private int edtavEmailserver_emailbodywhenuseractivateaccount_Enabled ;
   private int edtavEmailserver_emailsubjectwhenuserchangepassword_Visible ;
   private int edtavEmailserver_emailsubjectwhenuserchangepassword_Enabled ;
   private int edtavEmailserver_emailbodywhenuserchangepassword_Visible ;
   private int edtavEmailserver_emailbodywhenuserchangepassword_Enabled ;
   private int edtavEmailserver_emailsubjectwhenuserchangeemail_Visible ;
   private int edtavEmailserver_emailsubjectwhenuserchangeemail_Enabled ;
   private int edtavEmailserver_emailbodywhenuserchangeemail_Visible ;
   private int edtavEmailserver_emailbodywhenuserchangeemail_Enabled ;
   private int edtavEmailserver_emailsubjectforrecoverypassword_Visible ;
   private int edtavEmailserver_emailsubjectforrecoverypassword_Enabled ;
   private int edtavEmailserver_emailbodyforrecoverypassword_Visible ;
   private int edtavEmailserver_emailbodyforrecoverypassword_Enabled ;
   private int AV92GXV1 ;
   private int AV93GXV2 ;
   private int AV94GXV3 ;
   private int AV95GXV4 ;
   private int AV96GXV5 ;
   private int idxLst ;
   private long wcpOAV45Id ;
   private long AV45Id ;
   private long AV59RepoId ;
   private long AV11DefaultRoleId ;
   private long AV50TOTPSecretKeyLength ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
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
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String Gxuitabspanel_tabs_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divUnnamedtable3_Internalname ;
   private String edtavRepoid_Internalname ;
   private String TempTags ;
   private String edtavRepoid_Jsonclick ;
   private String edtavGuid_Internalname ;
   private String AV44GUID ;
   private String edtavGuid_Jsonclick ;
   private String edtavNamespace_Internalname ;
   private String AV58NameSpace ;
   private String edtavNamespace_Jsonclick ;
   private String edtavName_Internalname ;
   private String AV57Name ;
   private String edtavName_Jsonclick ;
   private String edtavDsc_Internalname ;
   private String AV13Dsc ;
   private String edtavDsc_Jsonclick ;
   private String AV33EnableTracing ;
   private String divAuthenticationmasterrepository_cell_Internalname ;
   private String divAuthenticationmasterrepository_cell_Class ;
   private String edtavAuthenticationmasterrepository_Internalname ;
   private String AV6AuthenticationMasterRepository ;
   private String edtavAuthenticationmasterrepository_Jsonclick ;
   private String divDefaultauthtypename_cell_Internalname ;
   private String divDefaultauthtypename_cell_Class ;
   private String AV10DefaultAuthTypeName ;
   private String divDefaultroleid_cell_Internalname ;
   private String divDefaultroleid_cell_Class ;
   private String divDefaultsecuritypolicyid_cell_Internalname ;
   private String divDefaultsecuritypolicyid_cell_Class ;
   private String AV55LogoutBehavior ;
   private String divEnableworkingasgammanagerrepo_cell_Internalname ;
   private String divEnableworkingasgammanagerrepo_cell_Class ;
   private String lblUsers_title_Internalname ;
   private String lblUsers_title_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String AV80UserIdentification ;
   private String divUseremailisunique_cell_Internalname ;
   private String divUseremailisunique_cell_Class ;
   private String AV77UserActivationMethod ;
   private String edtavUserautomaticactivationtimeout_Internalname ;
   private String edtavUserautomaticactivationtimeout_Jsonclick ;
   private String edtavUserrecoverypasswordkeytimeout_Internalname ;
   private String edtavUserrecoverypasswordkeytimeout_Jsonclick ;
   private String edtavUserrecoverypasswordkeydailymaximum_Internalname ;
   private String edtavUserrecoverypasswordkeydailymaximum_Jsonclick ;
   private String edtavUserrecoverypasswordkeymonthlymaximum_Internalname ;
   private String edtavUserrecoverypasswordkeymonthlymaximum_Jsonclick ;
   private String edtavLoginattemptstolockuser_Internalname ;
   private String edtavLoginattemptstolockuser_Jsonclick ;
   private String edtavGamunblockusertimeout_Internalname ;
   private String edtavGamunblockusertimeout_Jsonclick ;
   private String AV85UserRememberMeType ;
   private String edtavUserremembermetimeout_Internalname ;
   private String edtavUserremembermetimeout_Jsonclick ;
   private String edtavTotpsecretkeylength_Internalname ;
   private String edtavTotpsecretkeylength_Jsonclick ;
   private String divRequiredemail_cell_Internalname ;
   private String divRequiredemail_cell_Class ;
   private String lblSession_title_Internalname ;
   private String lblSession_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String AV42GenerateSessionStatistics ;
   private String edtavUsersessioncachetimeout_Internalname ;
   private String edtavUsersessioncachetimeout_Jsonclick ;
   private String edtavLoginattemptstolocksession_Internalname ;
   private String edtavLoginattemptstolocksession_Jsonclick ;
   private String edtavMinimumamountcharactersinlogin_Internalname ;
   private String edtavMinimumamountcharactersinlogin_Jsonclick ;
   private String edtavRepositorycachetimeout_Internalname ;
   private String edtavRepositorycachetimeout_Jsonclick ;
   private String divTblintsecbydomain_Internalname ;
   private String AV49IntSecByDomainMode ;
   private String edtavIntsecbydomainjwtsecret_Internalname ;
   private String edtavIntsecbydomainjwtsecret_Jsonclick ;
   private String edtavIntsecbydomainencryptionkey_Internalname ;
   private String edtavIntsecbydomainencryptionkey_Jsonclick ;
   private String lblTabemail_title_Internalname ;
   private String lblTabemail_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String edtavEmailserverhost_Internalname ;
   private String AV28EmailServerHost ;
   private String edtavEmailserverhost_Jsonclick ;
   private String edtavEmailserverport_Internalname ;
   private String edtavEmailserverport_Jsonclick ;
   private String edtavEmailservertimeout_Internalname ;
   private String edtavEmailservertimeout_Jsonclick ;
   private String edtavServersenderaddress_Internalname ;
   private String edtavServersenderaddress_Jsonclick ;
   private String edtavServersendername_Internalname ;
   private String AV75ServerSenderName ;
   private String edtavServersendername_Jsonclick ;
   private String divEmailserverauthenticationusername_cell_Internalname ;
   private String divEmailserverauthenticationusername_cell_Class ;
   private String edtavEmailserverauthenticationusername_Internalname ;
   private String AV26EmailServerAuthenticationUsername ;
   private String edtavEmailserverauthenticationusername_Jsonclick ;
   private String divEmailserverauthenticationuserpassword_cell_Internalname ;
   private String divEmailserverauthenticationuserpassword_cell_Class ;
   private String edtavEmailserverauthenticationuserpassword_Internalname ;
   private String AV27EmailServerAuthenticationUserPassword ;
   private String edtavEmailserverauthenticationuserpassword_Jsonclick ;
   private String divEmailserver_emailsubjectwhenuseractivateaccount_cell_Internalname ;
   private String divEmailserver_emailsubjectwhenuseractivateaccount_cell_Class ;
   private String edtavEmailserver_emailsubjectwhenuseractivateaccount_Internalname ;
   private String AV19EmailServer_EmailSubjectWhenUserActivateAccount ;
   private String edtavEmailserver_emailsubjectwhenuseractivateaccount_Jsonclick ;
   private String divEmailserver_emailbodywhenuseractivateaccount_cell_Internalname ;
   private String divEmailserver_emailbodywhenuseractivateaccount_cell_Class ;
   private String edtavEmailserver_emailbodywhenuseractivateaccount_Internalname ;
   private String divEmailserver_emailsubjectwhenuserchangepassword_cell_Internalname ;
   private String divEmailserver_emailsubjectwhenuserchangepassword_cell_Class ;
   private String edtavEmailserver_emailsubjectwhenuserchangepassword_Internalname ;
   private String AV21EmailServer_EmailSubjectWhenUserChangePassword ;
   private String edtavEmailserver_emailsubjectwhenuserchangepassword_Jsonclick ;
   private String divEmailserver_emailbodywhenuserchangepassword_cell_Internalname ;
   private String divEmailserver_emailbodywhenuserchangepassword_cell_Class ;
   private String edtavEmailserver_emailbodywhenuserchangepassword_Internalname ;
   private String divEmailserver_emailsubjectwhenuserchangeemail_cell_Internalname ;
   private String divEmailserver_emailsubjectwhenuserchangeemail_cell_Class ;
   private String edtavEmailserver_emailsubjectwhenuserchangeemail_Internalname ;
   private String AV20EmailServer_EmailSubjectWhenUserChangeEmail ;
   private String edtavEmailserver_emailsubjectwhenuserchangeemail_Jsonclick ;
   private String divEmailserver_emailbodywhenuserchangeemail_cell_Internalname ;
   private String divEmailserver_emailbodywhenuserchangeemail_cell_Class ;
   private String edtavEmailserver_emailbodywhenuserchangeemail_Internalname ;
   private String divEmailserver_emailsubjectforrecoverypassword_cell_Internalname ;
   private String divEmailserver_emailsubjectforrecoverypassword_cell_Class ;
   private String edtavEmailserver_emailsubjectforrecoverypassword_Internalname ;
   private String AV18EmailServer_EmailSubjectForRecoveryPassword ;
   private String edtavEmailserver_emailsubjectforrecoverypassword_Jsonclick ;
   private String divEmailserver_emailbodyforrecoverypassword_cell_Internalname ;
   private String divEmailserver_emailbodyforrecoverypassword_cell_Class ;
   private String edtavEmailserver_emailbodyforrecoverypassword_Internalname ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String hsh ;
   private String AV52Language ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV9CanRegisterUsers ;
   private boolean Gxuitabspanel_tabs_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV5AllowOauthAccess ;
   private boolean AV35EnableWorkingAsGAMManagerRepo ;
   private boolean AV79UserEmailisUnique ;
   private boolean AV64RequiredEmail ;
   private boolean AV68RequiredPassword ;
   private boolean AV65RequiredFirstName ;
   private boolean AV67RequiredLastName ;
   private boolean AV63RequiredBirthday ;
   private boolean AV66RequiredGender ;
   private boolean AV43GiveAnonymousSession ;
   private boolean AV76SessionExpiresOnIPChange ;
   private boolean AV51IntSecByDomainEnable ;
   private boolean AV30EmailServerSecure ;
   private boolean AV32EmailServerUsesAuthentication ;
   private boolean AV23EmailServer_SendEmailWhenUserActivateAccount ;
   private boolean AV25EmailServer_SendEmailWhenUserChangePassword ;
   private boolean AV24EmailServer_SendEmailWhenUserChangeEmail ;
   private boolean AV22EmailServer_SendEmailForRecoveryPassword ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV71SecurityAdministratorEmail ;
   private String AV48IntSecByDomainJWTSecret ;
   private String AV47IntSecByDomainEncryptionKey ;
   private String AV74ServerSenderAddress ;
   private String AV15EmailServer_EmailBodyWhenUserActivateAccount ;
   private String AV17EmailServer_EmailBodyWhenUserChangePassword ;
   private String AV16EmailServer_EmailBodyWhenUserChangeEmail ;
   private String AV14EmailServer_EmailBodyForRecoveryPassword ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabs ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavEnabletracing ;
   private HTMLChoice cmbavDefaultauthtypename ;
   private HTMLChoice cmbavDefaultroleid ;
   private HTMLChoice cmbavDefaultsecuritypolicyid ;
   private ICheckbox chkavAllowoauthaccess ;
   private HTMLChoice cmbavLogoutbehavior ;
   private ICheckbox chkavEnableworkingasgammanagerrepo ;
   private HTMLChoice cmbavUseridentification ;
   private ICheckbox chkavUseremailisunique ;
   private HTMLChoice cmbavUseractivationmethod ;
   private HTMLChoice cmbavUserremembermetype ;
   private ICheckbox chkavRequiredemail ;
   private ICheckbox chkavRequiredpassword ;
   private ICheckbox chkavRequiredfirstname ;
   private ICheckbox chkavRequiredlastname ;
   private ICheckbox chkavRequiredbirthday ;
   private ICheckbox chkavRequiredgender ;
   private HTMLChoice cmbavGeneratesessionstatistics ;
   private ICheckbox chkavGiveanonymoussession ;
   private ICheckbox chkavSessionexpiresonipchange ;
   private ICheckbox chkavIntsecbydomainenable ;
   private HTMLChoice cmbavIntsecbydomainmode ;
   private ICheckbox chkavEmailserversecure ;
   private ICheckbox chkavEmailserverusesauthentication ;
   private ICheckbox chkavEmailserver_sendemailwhenuseractivateaccount ;
   private ICheckbox chkavEmailserver_sendemailwhenuserchangepassword ;
   private ICheckbox chkavEmailserver_sendemailwhenuserchangeemail ;
   private ICheckbox chkavEmailserver_sendemailforrecoverypassword ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple> AV8AuthenticationTypes ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV37Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRepository> AV62RepositoryCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRole> AV70Roles ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMSecurityPolicy> AV72SecurityPolicies ;
   private genexus.security.api.genexussecurity.SdtGAMAuthenticationTypeSimple AV7AuthenticationType ;
   private genexus.security.api.genexussecurity.SdtGAMError AV36Error ;
   private genexus.security.api.genexussecurity.SdtGAMRepositoryFilter AV38Filter ;
   private genexus.security.api.genexussecurity.SdtGAMRoleFilter AV39FilterRole ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicyFilter AV40FilterSecPol ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV60Repository ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV87GAMRepositoryItem ;
   private genexus.security.api.genexussecurity.SdtGAMRole AV69Role ;
   private genexus.security.api.genexussecurity.SdtGAMSecurityPolicy AV73SecurityPolicy ;
}

final  class gamrepositoryconfiguration__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamrepositoryconfiguration__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

