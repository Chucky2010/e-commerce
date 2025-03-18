package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_masterpagenotificationswc_impl extends GXWebComponent
{
   public wwp_masterpagenotificationswc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_masterpagenotificationswc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_masterpagenotificationswc_impl.class ));
   }

   public wwp_masterpagenotificationswc_impl( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtnotificationsdatas") == 0 )
            {
               gxnrgridsdtnotificationsdatas_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtnotificationsdatas") == 0 )
            {
               gxgrgridsdtnotificationsdatas_refresh_invoke( ) ;
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
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgridsdtnotificationsdatas_newrow_invoke( )
   {
      nRC_GXsfl_15 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_15"))) ;
      nGXsfl_15_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_15_idx"))) ;
      sGXsfl_15_idx = httpContext.GetPar( "sGXsfl_15_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridsdtnotificationsdatas_newrow( ) ;
      /* End function gxnrGridsdtnotificationsdatas_newrow_invoke */
   }

   public void gxgrgridsdtnotificationsdatas_refresh_invoke( )
   {
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV6SDTNotificationsData);
      AV5IsAuthorized_CheckAllNotif = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_CheckAllNotif")) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridsdtnotificationsdatas_refresh( AV6SDTNotificationsData, AV5IsAuthorized_CheckAllNotif, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridsdtnotificationsdatas_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa3R2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
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
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      com.mujermorena.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Master Page Notifications", "")) ;
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_masterpagenotificationswc", new String[] {}, new String[] {}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_CHECKALLNOTIF", getSecureSignedToken( sPrefix, AV5IsAuthorized_CheckAllNotif));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"Sdtnotificationsdata", AV6SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"Sdtnotificationsdata", AV6SDTNotificationsData);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_15", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_15, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vSDTNOTIFICATIONSDATA", AV6SDTNotificationsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vSDTNOTIFICATIONSDATA", AV6SDTNotificationsData);
      }
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_CHECKALLNOTIF", AV5IsAuthorized_CheckAllNotif);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_CHECKALLNOTIF", getSecureSignedToken( sPrefix, AV5IsAuthorized_CheckAllNotif));
   }

   public void renderHtmlCloseForm3R2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Common.WWP_MasterPageNotificationsWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Master Page Notifications", "") ;
   }

   public void wb3R0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.mujermorena.wwpbaseobjects.notifications.common.wwp_masterpagenotificationswc");
         }
         com.mujermorena.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divNotificationcontent_Internalname, 1, 0, "px", 0, "px", "NotificationContent", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop CellMarginBottom15", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblNotificationtitle_Internalname, lblNotificationtitle_Caption, "", "", lblNotificationtitle_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "NotificationTitle", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_MasterPageNotificationsWC.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtnotificationsdatasContainer.SetIsFreestyle(true);
         GridsdtnotificationsdatasContainer.SetWrapped(nGXWrapped);
         startgridcontrol15( ) ;
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_15 = (int)(nGXsfl_15_idx-1) ;
         if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV11GXV1 = nGXsfl_15_idx ;
            if ( subGridsdtnotificationsdatas_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+sPrefix+"GridsdtnotificationsdatasContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridsdtnotificationsdatas", GridsdtnotificationsdatasContainer, subGridsdtnotificationsdatas_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsdtnotificationsdatasContainerData", GridsdtnotificationsdatasContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsdtnotificationsdatasContainerData"+"V", GridsdtnotificationsdatasContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridsdtnotificationsdatasContainerData"+"V"+"\" value='"+GridsdtnotificationsdatasContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonNotificationCheckAll" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtncheckallnotif_Internalname, "gx.evt.setGridEvt("+GXutil.str( 15, 2, 0)+","+"null"+");", httpContext.getMessage( "Check all notifications >", ""), bttBtncheckallnotif_Jsonclick, 5, httpContext.getMessage( "Check all notifications >", ""), "", StyleString, ClassString, bttBtncheckallnotif_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'DOCHECKALLNOTIF\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_MasterPageNotificationsWC.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 15 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV11GXV1 = nGXsfl_15_idx ;
               if ( subGridsdtnotificationsdatas_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+sPrefix+"GridsdtnotificationsdatasContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Gridsdtnotificationsdatas", GridsdtnotificationsdatasContainer, subGridsdtnotificationsdatas_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsdtnotificationsdatasContainerData", GridsdtnotificationsdatasContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GridsdtnotificationsdatasContainerData"+"V", GridsdtnotificationsdatasContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"GridsdtnotificationsdatasContainerData"+"V"+"\" value='"+GridsdtnotificationsdatasContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start3R2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Master Page Notifications", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup3R0( ) ;
         }
      }
   }

   public void ws3R2( )
   {
      start3R2( ) ;
      evt3R2( ) ;
   }

   public void evt3R2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3R0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCHECKALLNOTIF'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3R0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoCheckAllNotif' */
                                 e113R2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "NOTIFICATIONITEM.CLICK") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3R0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e123R2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3R0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 30), "GRIDSDTNOTIFICATIONSDATAS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 22), "NOTIFICATIONITEM.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3R0( ) ;
                           }
                           nGXsfl_15_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_152( ) ;
                           AV11GXV1 = nGXsfl_15_idx ;
                           if ( ( AV6SDTNotificationsData.size() >= AV11GXV1 ) && ( AV11GXV1 > 0 ) )
                           {
                              AV6SDTNotificationsData.currentItem( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Start */
                                       e133R2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       /* Execute user event: Refresh */
                                       e143R2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDSDTNOTIFICATIONSDATAS.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e153R2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "NOTIFICATIONITEM.CLICK") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       e123R2 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strup3R0( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                    }
                                 }
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

   public void we3R2( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3R2( ) ;
         }
      }
   }

   public void pa3R2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
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

   public void gxnrgridsdtnotificationsdatas_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_152( ) ;
      while ( nGXsfl_15_idx <= nRC_GXsfl_15 )
      {
         sendrow_152( ) ;
         nGXsfl_15_idx = ((subGridsdtnotificationsdatas_Islastpage==1)&&(nGXsfl_15_idx+1>subgridsdtnotificationsdatas_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
         sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_152( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtnotificationsdatasContainer)) ;
      /* End function gxnrGridsdtnotificationsdatas_newrow */
   }

   public void gxgrgridsdtnotificationsdatas_refresh( GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> AV6SDTNotificationsData ,
                                                      boolean AV5IsAuthorized_CheckAllNotif ,
                                                      String sPrefix )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e143R2 ();
      GRIDSDTNOTIFICATIONSDATAS_nCurrentRecord = 0 ;
      rf3R2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtnotificationsdatas_refresh */
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
      rf3R2( ) ;
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
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationtitle_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavSdtnotificationsdata__notificationdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdescription_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationdatetime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdatetime_Enabled), 5, 0), !bGXsfl_15_Refreshing);
   }

   public void rf3R2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtnotificationsdatasContainer.ClearRows();
      }
      wbStart = (short)(15) ;
      /* Execute user event: Refresh */
      e143R2 ();
      nGXsfl_15_idx = 1 ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      bGXsfl_15_Refreshing = true ;
      GridsdtnotificationsdatasContainer.AddObjectProperty("GridName", "Gridsdtnotificationsdatas");
      GridsdtnotificationsdatasContainer.AddObjectProperty("CmpContext", sPrefix);
      GridsdtnotificationsdatasContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtnotificationsdatasContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Visible, (byte)(5), (byte)(0), ".", "")));
      GridsdtnotificationsdatasContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridsdtnotificationsdatasContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridsdtnotificationsdatasContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtnotificationsdatasContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtnotificationsdatasContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtnotificationsdatasContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Visible, (byte)(5), (byte)(0), ".", "")));
      GridsdtnotificationsdatasContainer.setPageSize( subgridsdtnotificationsdatas_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_152( ) ;
         e153R2 ();
         wbEnd = (short)(15) ;
         wb3R0( ) ;
      }
      bGXsfl_15_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes3R2( )
   {
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, sPrefix+"vISAUTHORIZED_CHECKALLNOTIF", AV5IsAuthorized_CheckAllNotif);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_CHECKALLNOTIF", getSecureSignedToken( sPrefix, AV5IsAuthorized_CheckAllNotif));
   }

   public int subgridsdtnotificationsdatas_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridsdtnotificationsdatas_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridsdtnotificationsdatas_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridsdtnotificationsdatas_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationtitle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationtitle_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavSdtnotificationsdata__notificationdescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationdescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdescription_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationdatetime_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationdatetime_Enabled), 5, 0), !bGXsfl_15_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup3R0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e133R2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( sPrefix+"Sdtnotificationsdata"), AV6SDTNotificationsData);
         /* Read saved values. */
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_15"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_15 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_15"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_15_fel_idx = 0 ;
         while ( nGXsfl_15_fel_idx < nRC_GXsfl_15 )
         {
            nGXsfl_15_fel_idx = ((subGridsdtnotificationsdatas_Islastpage==1)&&(nGXsfl_15_fel_idx+1>subgridsdtnotificationsdatas_fnc_recordsperpage( )) ? 1 : nGXsfl_15_fel_idx+1) ;
            sGXsfl_15_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_152( ) ;
            AV11GXV1 = nGXsfl_15_fel_idx ;
            if ( ( AV6SDTNotificationsData.size() >= AV11GXV1 ) && ( AV11GXV1 > 0 ) )
            {
               AV6SDTNotificationsData.currentItem( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)) );
            }
         }
         if ( nGXsfl_15_fel_idx == 0 )
         {
            nGXsfl_15_idx = 1 ;
            sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_152( ) ;
         }
         nGXsfl_15_fel_idx = 1 ;
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
      e133R2 ();
      if (returnInSub) return;
   }

   public void e133R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavSdtnotificationsdata__notificationid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavSdtnotificationsdata__notificationid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtnotificationsdata__notificationid_Visible), 5, 0), !bGXsfl_15_Refreshing);
      GXt_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem1 = AV6SDTNotificationsData ;
      GXv_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem2[0] = GXt_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem1 ;
      new com.mujermorena.wwpbaseobjects.notifications.common.wwp_getnotificationsforuser(remoteHandle, context).execute( GXv_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem2) ;
      GXt_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem1 = GXv_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem2[0] ;
      AV6SDTNotificationsData = GXt_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem1 ;
      gx_BV15 = true ;
   }

   public void e143R2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      if ( AV6SDTNotificationsData.size() == 0 )
      {
         lblNotificationtitle_Caption = httpContext.getMessage( "WWP_Notifications_NoNewNotifications", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblNotificationtitle_Internalname, "Caption", lblNotificationtitle_Caption, true);
         subGridsdtnotificationsdatas_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, sPrefix+"GridsdtnotificationsdatasContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridsdtnotificationsdatas_Visible), 5, 0), true);
      }
      else if ( AV6SDTNotificationsData.size() == 1 )
      {
         lblNotificationtitle_Caption = httpContext.getMessage( "WWP_Notifications_OneNewNotification", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblNotificationtitle_Internalname, "Caption", lblNotificationtitle_Caption, true);
         subGridsdtnotificationsdatas_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, sPrefix+"GridsdtnotificationsdatasContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridsdtnotificationsdatas_Visible), 5, 0), true);
      }
      else
      {
         subGridsdtnotificationsdatas_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, sPrefix+"GridsdtnotificationsdatasContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridsdtnotificationsdatas_Visible), 5, 0), true);
         lblNotificationtitle_Caption = GXutil.format( httpContext.getMessage( "WWP_Notifications_NewNotifications", ""), GXutil.trim( GXutil.str( AV6SDTNotificationsData.size(), 9, 0)), "", "", "", "", "", "", "", "") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, lblNotificationtitle_Internalname, "Caption", lblNotificationtitle_Caption, true);
      }
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   private void e153R2( )
   {
      /* Gridsdtnotificationsdatas_Load Routine */
      returnInSub = false ;
      AV11GXV1 = 1 ;
      while ( AV11GXV1 <= AV6SDTNotificationsData.size() )
      {
         AV6SDTNotificationsData.currentItem( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)) );
         lblNotificationitemicon_Caption = GXutil.format( "<i class='%1'></i>", ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)(AV6SDTNotificationsData.currentItem())).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationiconclass(), "", "", "", "", "", "", "", "") ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(15) ;
         }
         sendrow_152( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_15_Refreshing )
         {
            httpContext.doAjaxLoad(15, GridsdtnotificationsdatasRow);
         }
         AV11GXV1 = (int)(AV11GXV1+1) ;
      }
      /*  Sending Event outputs  */
   }

   public void e113R2( )
   {
      /* 'DoCheckAllNotif' Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "DropDownComponent_Close", new Object[] {bttBtncheckallnotif_Internalname}, false);
      if ( AV5IsAuthorized_CheckAllNotif )
      {
         callWebObject(formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefreshCmp(sPrefix);
      }
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV5IsAuthorized_CheckAllNotif ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "wwpvisualizeallnotifications_Execute", GXv_boolean4) ;
      wwp_masterpagenotificationswc_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV5IsAuthorized_CheckAllNotif = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5IsAuthorized_CheckAllNotif", AV5IsAuthorized_CheckAllNotif);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vISAUTHORIZED_CHECKALLNOTIF", getSecureSignedToken( sPrefix, AV5IsAuthorized_CheckAllNotif));
      if ( ! ( AV5IsAuthorized_CheckAllNotif ) )
      {
         bttBtncheckallnotif_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtncheckallnotif_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtncheckallnotif_Visible), 5, 0), true);
      }
   }

   public void e123R2( )
   {
      AV11GXV1 = nGXsfl_15_idx ;
      if ( ( AV11GXV1 > 0 ) && ( AV6SDTNotificationsData.size() >= AV11GXV1 ) )
      {
         AV6SDTNotificationsData.currentItem( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)) );
      }
      /* Notificationitem_Click Routine */
      returnInSub = false ;
      this.executeExternalObjectMethod(sPrefix, false, "WWPActions", "DropDownComponent_Close", new Object[] {divLayoutmaintable_Internalname}, false);
      callWebObject(formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)(AV6SDTNotificationsData.currentItem())).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid(),5,0))}, new String[] {"WWPNotificationId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV6SDTNotificationsData", AV6SDTNotificationsData);
      nGXsfl_15_bak_idx = nGXsfl_15_idx ;
      gxgrgridsdtnotificationsdatas_refresh( AV6SDTNotificationsData, AV5IsAuthorized_CheckAllNotif, sPrefix) ;
      nGXsfl_15_idx = nGXsfl_15_bak_idx ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
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
      pa3R2( ) ;
      ws3R2( ) ;
      we3R2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3R2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wwpbaseobjects\\notifications\\common\\wwp_masterpagenotificationswc", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3R2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa3R2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3R2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws3R2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we3R2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211161431", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/notifications/common/wwp_masterpagenotificationswc.js", "?20241211161431", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_152( )
   {
      lblNotificationitemicon_Internalname = sPrefix+"NOTIFICATIONITEMICON_"+sGXsfl_15_idx ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE_"+sGXsfl_15_idx ;
      edtavSdtnotificationsdata__notificationdescription_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONDESCRIPTION_"+sGXsfl_15_idx ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME_"+sGXsfl_15_idx ;
      edtavSdtnotificationsdata__notificationid_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONID_"+sGXsfl_15_idx ;
   }

   public void subsflControlProps_fel_152( )
   {
      lblNotificationitemicon_Internalname = sPrefix+"NOTIFICATIONITEMICON_"+sGXsfl_15_fel_idx ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE_"+sGXsfl_15_fel_idx ;
      edtavSdtnotificationsdata__notificationdescription_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONDESCRIPTION_"+sGXsfl_15_fel_idx ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME_"+sGXsfl_15_fel_idx ;
      edtavSdtnotificationsdata__notificationid_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONID_"+sGXsfl_15_fel_idx ;
   }

   public void sendrow_152( )
   {
      subsflControlProps_152( ) ;
      wb3R0( ) ;
      GridsdtnotificationsdatasRow = GXWebRow.GetNew(context,GridsdtnotificationsdatasContainer) ;
      if ( subGridsdtnotificationsdatas_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridsdtnotificationsdatas_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridsdtnotificationsdatas_Class, "") != 0 )
         {
            subGridsdtnotificationsdatas_Linesclass = subGridsdtnotificationsdatas_Class+"Odd" ;
         }
      }
      else if ( subGridsdtnotificationsdatas_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridsdtnotificationsdatas_Backstyle = (byte)(0) ;
         subGridsdtnotificationsdatas_Backcolor = subGridsdtnotificationsdatas_Allbackcolor ;
         if ( GXutil.strcmp(subGridsdtnotificationsdatas_Class, "") != 0 )
         {
            subGridsdtnotificationsdatas_Linesclass = subGridsdtnotificationsdatas_Class+"Uniform" ;
         }
      }
      else if ( subGridsdtnotificationsdatas_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridsdtnotificationsdatas_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridsdtnotificationsdatas_Class, "") != 0 )
         {
            subGridsdtnotificationsdatas_Linesclass = subGridsdtnotificationsdatas_Class+"Odd" ;
         }
         subGridsdtnotificationsdatas_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridsdtnotificationsdatas_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridsdtnotificationsdatas_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_15_idx) % (2))) == 0 )
         {
            subGridsdtnotificationsdatas_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridsdtnotificationsdatas_Class, "") != 0 )
            {
               subGridsdtnotificationsdatas_Linesclass = subGridsdtnotificationsdatas_Class+"Even" ;
            }
         }
         else
         {
            subGridsdtnotificationsdatas_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridsdtnotificationsdatas_Class, "") != 0 )
            {
               subGridsdtnotificationsdatas_Linesclass = subGridsdtnotificationsdatas_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridsdtnotificationsdatas_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_15_idx+"\">") ;
      }
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgridsdtnotificationsdatas_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divNotificationitem_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","NotificationItemContent","left","top"," "+"data-gx-flex"+" ","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","align-self:center;","div"});
      /* Text block */
      GridsdtnotificationsdatasRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblNotificationitemicon_Internalname,lblNotificationitemicon_Caption,"","",lblNotificationitemicon_Jsonclick,"'"+sPrefix+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable2_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","NotificationItemRight","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridsdtnotificationsdatasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationtitle_Internalname,httpContext.getMessage( "Notification Title", ""),"col-sm-3 NotificationItemTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "NotificationItemTitle" ;
      StyleString = "" ;
      ClassString = "NotificationItemTitle" ;
      StyleString = "" ;
      GridsdtnotificationsdatasRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationtitle_Internalname,((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationtitle(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtnotificationsdata__notificationtitle_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridsdtnotificationsdatasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationdescription_Internalname,httpContext.getMessage( "Notification Description", ""),"col-sm-3 NotificationItemDescriptionLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "NotificationItemDescription" ;
      StyleString = "" ;
      ClassString = "NotificationItemDescription" ;
      StyleString = "" ;
      GridsdtnotificationsdatasRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationdescription_Internalname,((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdescription(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtnotificationsdata__notificationdescription_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+sPrefix+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridsdtnotificationsdatasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationdatetime_Internalname,httpContext.getMessage( "Notification Datetime", ""),"col-sm-3 NotificationItemDatetimeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "NotificationItemDatetime" ;
      GridsdtnotificationsdatasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationdatetime_Internalname,localUtil.ttoc( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime(), 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "),localUtil.format( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationdatetime(), "99/99/99 99:99"),"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationdatetime_Jsonclick,Integer.valueOf(0),"NotificationItemDatetime","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtnotificationsdata__notificationdatetime_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(14),"chr",Integer.valueOf(1),"row",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 Invisible","left","top","","","div"});
      /* Table start */
      GridsdtnotificationsdatasRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgridsdtnotificationsdatas_Internalname+"_"+sGXsfl_15_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      GridsdtnotificationsdatasRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridsdtnotificationsdatasRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridsdtnotificationsdatasRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationid_Internalname,httpContext.getMessage( "Notification Id", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtnotificationsdata__notificationid_Enabled!=0)&&(edtavSdtnotificationsdata__notificationid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'"+sPrefix+"',false,'"+sGXsfl_15_idx+"',15)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridsdtnotificationsdatasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtnotificationsdata__notificationid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid(), (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem)AV6SDTNotificationsData.elementAt(-1+AV11GXV1)).getgxTv_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem_Notificationid()), "ZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavSdtnotificationsdata__notificationid_Enabled!=0)&&(edtavSdtnotificationsdata__notificationid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"" : " "),"'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtavSdtnotificationsdata__notificationid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavSdtnotificationsdata__notificationid_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(5),"chr",Integer.valueOf(1),"row",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
      {
         GridsdtnotificationsdatasContainer.CloseTag("cell");
      }
      if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
      {
         GridsdtnotificationsdatasContainer.CloseTag("row");
      }
      if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
      {
         GridsdtnotificationsdatasContainer.CloseTag("table");
      }
      /* End of table */
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridsdtnotificationsdatasRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes3R2( ) ;
      /* End of Columns property logic. */
      GridsdtnotificationsdatasContainer.AddRow(GridsdtnotificationsdatasRow);
      nGXsfl_15_idx = ((subGridsdtnotificationsdatas_Islastpage==1)&&(nGXsfl_15_idx+1>subgridsdtnotificationsdatas_fnc_recordsperpage( )) ? 1 : nGXsfl_15_idx+1) ;
      sGXsfl_15_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_15_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_152( ) ;
      /* End function sendrow_152 */
   }

   public void startgridcontrol15( )
   {
      if ( GridsdtnotificationsdatasContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"GridsdtnotificationsdatasContainer"+"DivS\" data-gxgridid=\"15\">") ;
         sStyleString = "" ;
         if ( subGridsdtnotificationsdatas_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGridsdtnotificationsdatas_Internalname, subGridsdtnotificationsdatas_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridsdtnotificationsdatasContainer.AddObjectProperty("GridName", "Gridsdtnotificationsdatas");
      }
      else
      {
         GridsdtnotificationsdatasContainer.AddObjectProperty("GridName", "Gridsdtnotificationsdatas");
         GridsdtnotificationsdatasContainer.AddObjectProperty("Header", subGridsdtnotificationsdatas_Header);
         GridsdtnotificationsdatasContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Visible, (byte)(5), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Class", "FreeStyleGrid");
         GridsdtnotificationsdatasContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Visible, (byte)(5), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("CmpContext", sPrefix);
         GridsdtnotificationsdatasContainer.AddObjectProperty("InMasterPage", "false");
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasColumn.AddObjectProperty("Value", lblNotificationitemicon_Caption);
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationtitle_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationdescription_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationdatetime_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsdtnotificationsdatasColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtnotificationsdata__notificationid_Visible, (byte)(5), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddColumnProperties(GridsdtnotificationsdatasColumn);
         GridsdtnotificationsdatasContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridsdtnotificationsdatasContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtnotificationsdatas_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblNotificationtitle_Internalname = sPrefix+"NOTIFICATIONTITLE" ;
      lblNotificationitemicon_Internalname = sPrefix+"NOTIFICATIONITEMICON" ;
      edtavSdtnotificationsdata__notificationtitle_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONTITLE" ;
      edtavSdtnotificationsdata__notificationdescription_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONDESCRIPTION" ;
      edtavSdtnotificationsdata__notificationdatetime_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONDATETIME" ;
      divUnnamedtable2_Internalname = sPrefix+"UNNAMEDTABLE2" ;
      divNotificationitem_Internalname = sPrefix+"NOTIFICATIONITEM" ;
      edtavSdtnotificationsdata__notificationid_Internalname = sPrefix+"SDTNOTIFICATIONSDATA__NOTIFICATIONID" ;
      tblUnnamedtablecontentfsgridsdtnotificationsdatas_Internalname = sPrefix+"UNNAMEDTABLECONTENTFSGRIDSDTNOTIFICATIONSDATAS" ;
      divUnnamedtablefsgridsdtnotificationsdatas_Internalname = sPrefix+"UNNAMEDTABLEFSGRIDSDTNOTIFICATIONSDATAS" ;
      divNotificationcontent_Internalname = sPrefix+"NOTIFICATIONCONTENT" ;
      bttBtncheckallnotif_Internalname = sPrefix+"BTNCHECKALLNOTIF" ;
      divUnnamedtable1_Internalname = sPrefix+"UNNAMEDTABLE1" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGridsdtnotificationsdatas_Internalname = sPrefix+"GRIDSDTNOTIFICATIONSDATAS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGridsdtnotificationsdatas_Allowcollapsing = (byte)(0) ;
      lblNotificationitemicon_Caption = httpContext.getMessage( "<i class='fas fa-pencil-alt NotificationFontIconSuccess'></i>", "") ;
      edtavSdtnotificationsdata__notificationid_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationid_Enabled = 1 ;
      edtavSdtnotificationsdata__notificationid_Visible = 1 ;
      edtavSdtnotificationsdata__notificationdatetime_Jsonclick = "" ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationdescription_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      lblNotificationitemicon_Caption = httpContext.getMessage( "<i class='fas fa-pencil-alt NotificationFontIconSuccess'></i>", "") ;
      subGridsdtnotificationsdatas_Class = "FreeStyleGrid" ;
      subGridsdtnotificationsdatas_Backcolorstyle = (byte)(0) ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = -1 ;
      edtavSdtnotificationsdata__notificationdescription_Enabled = -1 ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = -1 ;
      bttBtncheckallnotif_Visible = 1 ;
      subGridsdtnotificationsdatas_Visible = 1 ;
      lblNotificationtitle_Caption = httpContext.getMessage( "Tienes 5 notificaciones nuevas", "") ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTNOTIFICATIONSDATAS_nFirstRecordOnPage'},{av:'GRIDSDTNOTIFICATIONSDATAS_nEOF'},{av:'sPrefix'},{av:'AV6SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:15,pic:''},{av:'nGXsfl_15_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'GridRC',grid:15},{av:'AV5IsAuthorized_CheckAllNotif',fld:'vISAUTHORIZED_CHECKALLNOTIF',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'lblNotificationtitle_Caption',ctrl:'NOTIFICATIONTITLE',prop:'Caption'},{av:'subGridsdtnotificationsdatas_Visible',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'Visible'},{av:'AV5IsAuthorized_CheckAllNotif',fld:'vISAUTHORIZED_CHECKALLNOTIF',pic:'',hsh:true},{ctrl:'BTNCHECKALLNOTIF',prop:'Visible'}]}");
      setEventMetadata("GRIDSDTNOTIFICATIONSDATAS.LOAD","{handler:'e153R2',iparms:[{av:'AV6SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:15,pic:''},{av:'nGXsfl_15_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:15},{av:'GRIDSDTNOTIFICATIONSDATAS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'GridRC',grid:15}]");
      setEventMetadata("GRIDSDTNOTIFICATIONSDATAS.LOAD",",oparms:[{av:'lblNotificationitemicon_Caption',ctrl:'NOTIFICATIONITEMICON',prop:'Caption'}]}");
      setEventMetadata("'DOCHECKALLNOTIF'","{handler:'e113R2',iparms:[{av:'GRIDSDTNOTIFICATIONSDATAS_nFirstRecordOnPage'},{av:'GRIDSDTNOTIFICATIONSDATAS_nEOF'},{av:'AV6SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:15,pic:''},{av:'nGXsfl_15_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:15},{av:'nRC_GXsfl_15',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'GridRC',grid:15},{av:'AV5IsAuthorized_CheckAllNotif',fld:'vISAUTHORIZED_CHECKALLNOTIF',pic:'',hsh:true},{av:'sPrefix'}]");
      setEventMetadata("'DOCHECKALLNOTIF'",",oparms:[{av:'lblNotificationtitle_Caption',ctrl:'NOTIFICATIONTITLE',prop:'Caption'},{av:'subGridsdtnotificationsdatas_Visible',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'Visible'},{av:'AV5IsAuthorized_CheckAllNotif',fld:'vISAUTHORIZED_CHECKALLNOTIF',pic:'',hsh:true},{ctrl:'BTNCHECKALLNOTIF',prop:'Visible'}]}");
      setEventMetadata("NOTIFICATIONITEM.CLICK","{handler:'e123R2',iparms:[{av:'AV6SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:15,pic:''},{av:'nGXsfl_15_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:15},{av:'GRIDSDTNOTIFICATIONSDATAS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'GridRC',grid:15},{av:'GRIDSDTNOTIFICATIONSDATAS_nEOF'},{av:'sPrefix'},{av:'AV5IsAuthorized_CheckAllNotif',fld:'vISAUTHORIZED_CHECKALLNOTIF',pic:'',hsh:true}]");
      setEventMetadata("NOTIFICATIONITEM.CLICK",",oparms:[{av:'AV6SDTNotificationsData',fld:'vSDTNOTIFICATIONSDATA',grid:15,pic:''},{av:'nGXsfl_15_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:15},{av:'GRIDSDTNOTIFICATIONSDATAS_nFirstRecordOnPage'},{av:'nRC_GXsfl_15',ctrl:'GRIDSDTNOTIFICATIONSDATAS',prop:'GridRC',grid:15}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv5',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
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
      sPrefix = "" ;
      AV6SDTNotificationsData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>(com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem.class, "WWP_SDTNotificationsDataItem", "Mujer_Morena", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      lblNotificationtitle_Jsonclick = "" ;
      GridsdtnotificationsdatasContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtncheckallnotif_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXt_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem>(com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem.class, "WWP_SDTNotificationsDataItem", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem2 = new GXBaseCollection[1] ;
      GridsdtnotificationsdatasRow = new com.genexus.webpanels.GXWebRow();
      GXv_boolean4 = new boolean[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridsdtnotificationsdatas_Linesclass = "" ;
      lblNotificationitemicon_Jsonclick = "" ;
      ROClassString = "" ;
      subGridsdtnotificationsdatas_Header = "" ;
      GridsdtnotificationsdatasColumn = new com.genexus.webpanels.GXWebColumn();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSdtnotificationsdata__notificationtitle_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationdescription_Enabled = 0 ;
      edtavSdtnotificationsdata__notificationdatetime_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGridsdtnotificationsdatas_Backcolorstyle ;
   private byte GRIDSDTNOTIFICATIONSDATAS_nEOF ;
   private byte nGXWrapped ;
   private byte subGridsdtnotificationsdatas_Backstyle ;
   private byte subGridsdtnotificationsdatas_Allowselection ;
   private byte subGridsdtnotificationsdatas_Allowhovering ;
   private byte subGridsdtnotificationsdatas_Allowcollapsing ;
   private byte subGridsdtnotificationsdatas_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_15 ;
   private int nGXsfl_15_idx=1 ;
   private int AV11GXV1 ;
   private int subGridsdtnotificationsdatas_Visible ;
   private int bttBtncheckallnotif_Visible ;
   private int subGridsdtnotificationsdatas_Islastpage ;
   private int edtavSdtnotificationsdata__notificationtitle_Enabled ;
   private int edtavSdtnotificationsdata__notificationdescription_Enabled ;
   private int edtavSdtnotificationsdata__notificationdatetime_Enabled ;
   private int nGXsfl_15_fel_idx=1 ;
   private int edtavSdtnotificationsdata__notificationid_Visible ;
   private int nGXsfl_15_bak_idx=1 ;
   private int idxLst ;
   private int subGridsdtnotificationsdatas_Backcolor ;
   private int subGridsdtnotificationsdatas_Allbackcolor ;
   private int edtavSdtnotificationsdata__notificationid_Enabled ;
   private int subGridsdtnotificationsdatas_Selectedindex ;
   private int subGridsdtnotificationsdatas_Selectioncolor ;
   private int subGridsdtnotificationsdatas_Hoveringcolor ;
   private long GRIDSDTNOTIFICATIONSDATAS_nCurrentRecord ;
   private long GRIDSDTNOTIFICATIONSDATAS_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_15_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String divNotificationcontent_Internalname ;
   private String lblNotificationtitle_Internalname ;
   private String lblNotificationtitle_Caption ;
   private String lblNotificationtitle_Jsonclick ;
   private String sStyleString ;
   private String subGridsdtnotificationsdatas_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtncheckallnotif_Internalname ;
   private String bttBtncheckallnotif_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSdtnotificationsdata__notificationtitle_Internalname ;
   private String edtavSdtnotificationsdata__notificationdescription_Internalname ;
   private String edtavSdtnotificationsdata__notificationdatetime_Internalname ;
   private String sGXsfl_15_fel_idx="0001" ;
   private String edtavSdtnotificationsdata__notificationid_Internalname ;
   private String lblNotificationitemicon_Caption ;
   private String lblNotificationitemicon_Internalname ;
   private String subGridsdtnotificationsdatas_Class ;
   private String subGridsdtnotificationsdatas_Linesclass ;
   private String divUnnamedtablefsgridsdtnotificationsdatas_Internalname ;
   private String divNotificationitem_Internalname ;
   private String lblNotificationitemicon_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String ROClassString ;
   private String edtavSdtnotificationsdata__notificationdatetime_Jsonclick ;
   private String tblUnnamedtablecontentfsgridsdtnotificationsdatas_Internalname ;
   private String edtavSdtnotificationsdata__notificationid_Jsonclick ;
   private String subGridsdtnotificationsdatas_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV5IsAuthorized_CheckAllNotif ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_15_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV15 ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private com.genexus.webpanels.GXWebGrid GridsdtnotificationsdatasContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtnotificationsdatasRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtnotificationsdatasColumn ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> AV6SDTNotificationsData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> GXt_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem> GXv_objcol_SdtWWP_SDTNotificationsData_WWP_SDTNotificationsDataItem2[] ;
}

