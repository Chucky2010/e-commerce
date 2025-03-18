package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_visualizeallnotifications_impl extends GXDataArea
{
   public wwp_visualizeallnotifications_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_visualizeallnotifications_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_visualizeallnotifications_impl.class ));
   }

   public wwp_visualizeallnotifications_impl( int remoteHandle ,
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
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
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_22 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_22"))) ;
      nGXsfl_22_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_22_idx"))) ;
      sGXsfl_22_idx = httpContext.GetPar( "sGXsfl_22_idx") ;
      edtWWPNotificationId_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtWWPNotificationLink_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationLink_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtWWPNotificationMetadata_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationMetadata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationMetadata_Visible), 5, 0), !bGXsfl_22_Refreshing);
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV22Pgmname = httpContext.GetPar( "Pgmname") ;
      edtWWPNotificationId_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtWWPNotificationLink_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationLink_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtWWPNotificationMetadata_Visible = (int)(GXutil.lval( httpContext.GetNextPar( ))) ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationMetadata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationMetadata_Visible), 5, 0), !bGXsfl_22_Refreshing);
      AV15IsAuthorized_ManageSubscriptions = GXutil.strtobool( httpContext.GetPar( "IsAuthorized_ManageSubscriptions")) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
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
      pa1N2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1N2( ) ;
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications", new String[] {}, new String[] {}) +"\">") ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MANAGESUBSCRIPTIONS", getSecureSignedToken( "", AV15IsAuthorized_ManageSubscriptions));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_22", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_22, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONICON", A198WWPNotificationIcon);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONCREATED", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "WWPNOTIFICATIONISREAD", A203WWPNotificationIsRead);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_MANAGESUBSCRIPTIONS", AV15IsAuthorized_ManageSubscriptions);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MANAGESUBSCRIPTIONS", getSecureSignedToken( "", AV15IsAuthorized_ManageSubscriptions));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONID_Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationId_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONLINK_Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationLink_Visible, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPNOTIFICATIONMETADATA_Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationMetadata_Visible, (byte)(5), (byte)(0), ".", "")));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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
         we1N2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1N2( ) ;
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
      return formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Common.WWP_VisualizeAllNotifications" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Visualize all notifications", "") ;
   }

   public void wb1N0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, divTablemain_Width, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtnmarkallasread_Internalname, lblBtnmarkallasread_Caption, "", "", lblBtnmarkallasread_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOMARKALLASREAD\\'."+"'", "", "MenuOption", 5, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeAllNotifications.htm");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblBtnmanagesubscriptions_Internalname, lblBtnmanagesubscriptions_Caption, "", "", lblBtnmanagesubscriptions_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOMANAGESUBSCRIPTIONS\\'."+"'", "", "MenuOption", 5, "", lblBtnmanagesubscriptions_Visible, 1, 0, (short)(1), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeAllNotifications.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblNonotifications_Internalname, httpContext.getMessage( "WWP_Notifications_NoNotificationsReceived", ""), "", "", lblNonotifications_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", lblNonotifications_Visible, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeAllNotifications.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol22( ) ;
      }
      if ( wbEnd == 22 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_22 = (int)(nGXsfl_22_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            if ( subGrid_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 22 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               if ( subGrid_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1N2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Visualize all notifications", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1N0( ) ;
   }

   public void ws1N2( )
   {
      start1N2( ) ;
      evt1N2( ) ;
   }

   public void evt1N2( )
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
                        else if ( GXutil.strcmp(sEvt, "'DOMARKALLASREAD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoMarkAllAsRead' */
                           e111N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOMANAGESUBSCRIPTIONS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoManageSubscriptions' */
                           e121N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "'DOMARKASREAD'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 14), "'DOMARKASREAD'") == 0 ) )
                        {
                           nGXsfl_22_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_222( ) ;
                           A199WWPNotificationTitle = httpContext.cgiGet( edtWWPNotificationTitle_Internalname) ;
                           if ( localUtil.vcdtime( httpContext.cgiGet( edtavWwpnotificationcreated_Internalname), (byte)(0), (byte)(0)) == 0 )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "vWWPNOTIFICATIONCREATED");
                              GX_FocusControl = edtavWwpnotificationcreated_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV18WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
                              httpContext.ajax_rsp_assign_attri("", false, edtavWwpnotificationcreated_Internalname, localUtil.ttoc( AV18WWPNotificationCreated, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
                           }
                           else
                           {
                              AV18WWPNotificationCreated = localUtil.ctot( httpContext.cgiGet( edtavWwpnotificationcreated_Internalname), 0) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavWwpnotificationcreated_Internalname, localUtil.ttoc( AV18WWPNotificationCreated, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
                           }
                           A200WWPNotificationShortDescriptio = httpContext.cgiGet( edtWWPNotificationShortDescriptio_Internalname) ;
                           A37WWPNotificationId = localUtil.ctol( httpContext.cgiGet( edtWWPNotificationId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           A201WWPNotificationLink = httpContext.cgiGet( edtWWPNotificationLink_Internalname) ;
                           A182WWPNotificationMetadata = httpContext.cgiGet( edtWWPNotificationMetadata_Internalname) ;
                           n182WWPNotificationMetadata = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e131N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e141N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e151N2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DOMARKASREAD'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoMarkAsRead' */
                                 e161N2 ();
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

   public void we1N2( )
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

   public void pa1N2( )
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

   public void gxnrgrid_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_222( ) ;
      while ( nGXsfl_22_idx <= nRC_GXsfl_22 )
      {
         sendrow_222( ) ;
         nGXsfl_22_idx = ((subGrid_Islastpage==1)&&(nGXsfl_22_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_22_idx+1) ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV22Pgmname ,
                                 boolean AV15IsAuthorized_ManageSubscriptions )
   {
      initialize_formulas( ) ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e141N2 ();
      GRID_nCurrentRecord = 0 ;
      rf1N2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
      GRID_nFirstRecordOnPage = 0 ;
      GRID_nCurrentRecord = 0 ;
      GXCCtl = "GRID_nFirstRecordOnPage_" + sGXsfl_22_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf1N2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV22Pgmname = "WWPBaseObjects.Notifications.Common.WWP_VisualizeAllNotifications" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationcreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavWwpnotificationcreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationcreated_Enabled), 5, 0), !bGXsfl_22_Refreshing);
   }

   public void rf1N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(22) ;
      /* Execute user event: Refresh */
      e141N2 ();
      nGXsfl_22_idx = (int)(1+GRID_nFirstRecordOnPage) ;
      sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_222( ) ;
      bGXsfl_22_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGrid_Visible, (byte)(5), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGrid_Visible, (byte)(5), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_222( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         /* Using cursor H001N2 */
         pr_default.execute(0, new Object[] {AV21Udparg1, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_22_idx = (int)(1+GRID_nFirstRecordOnPage) ;
         sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_222( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A32WWPUserExtendedId = H001N2_A32WWPUserExtendedId[0] ;
            n32WWPUserExtendedId = H001N2_n32WWPUserExtendedId[0] ;
            A198WWPNotificationIcon = H001N2_A198WWPNotificationIcon[0] ;
            A203WWPNotificationIsRead = H001N2_A203WWPNotificationIsRead[0] ;
            A40WWPNotificationCreated = H001N2_A40WWPNotificationCreated[0] ;
            A182WWPNotificationMetadata = H001N2_A182WWPNotificationMetadata[0] ;
            n182WWPNotificationMetadata = H001N2_n182WWPNotificationMetadata[0] ;
            A201WWPNotificationLink = H001N2_A201WWPNotificationLink[0] ;
            A37WWPNotificationId = H001N2_A37WWPNotificationId[0] ;
            A200WWPNotificationShortDescriptio = H001N2_A200WWPNotificationShortDescriptio[0] ;
            A199WWPNotificationTitle = H001N2_A199WWPNotificationTitle[0] ;
            e151N2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(22) ;
         wb1N0( ) ;
      }
      bGXsfl_22_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1N2( )
   {
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV22Pgmname, ""))));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "vISAUTHORIZED_MANAGESUBSCRIPTIONS", AV15IsAuthorized_ManageSubscriptions);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MANAGESUBSCRIPTIONS", getSecureSignedToken( "", AV15IsAuthorized_ManageSubscriptions));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV21Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /* Using cursor H001N3 */
      pr_default.execute(1, new Object[] {AV21Udparg1});
      GRID_nRecordCount = H001N3_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      GRID_nFirstRecordOnPage = 0 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRID_nEOF == 1 )
      {
         GRID_nFirstRecordOnPage = GRID_nCurrentRecord ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV22Pgmname = "WWPBaseObjects.Notifications.Common.WWP_VisualizeAllNotifications" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationcreated_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavWwpnotificationcreated_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavWwpnotificationcreated_Enabled), 5, 0), !bGXsfl_22_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup1N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e131N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_22 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_22"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         /* Read variables values. */
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
      e131N2 ();
      if (returnInSub) return;
   }

   public void e131N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divTablemain_Width = 700 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablemain_Internalname, "Width", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablemain_Width), 9, 0), true);
      edtWWPNotificationId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationId_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtWWPNotificationLink_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationLink_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationLink_Visible), 5, 0), !bGXsfl_22_Refreshing);
      edtWWPNotificationMetadata_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPNotificationMetadata_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPNotificationMetadata_Visible), 5, 0), !bGXsfl_22_Refreshing);
      subGrid_Rows = 10 ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      lblBtnmarkallasread_Caption = GXutil.format( "<i class='fas fa-envelope-open' title='%1'></i>", httpContext.getMessage( "WWP_Notifications_MarkAllAsRead", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtnmarkallasread_Internalname, "Caption", lblBtnmarkallasread_Caption, true);
      lblBtnmanagesubscriptions_Caption = GXutil.format( "<i class='fas fa-cog' title='%1'></i>", httpContext.getMessage( "WWP_Notifications_Manage", ""), "", "", "", "", "", "", "", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblBtnmanagesubscriptions_Internalname, "Caption", lblBtnmanagesubscriptions_Caption, true);
      Form.setCaption( httpContext.getMessage( "Visualize all notifications", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
   }

   public void e141N2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S132 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      lblNonotifications_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, lblNonotifications_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblNonotifications_Visible), 5, 0), true);
      subGrid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGrid_Visible), 5, 0), true);
      AV21Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /*  Sending Event outputs  */
   }

   private void e151N2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      lblNonotifications_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, lblNonotifications_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblNonotifications_Visible), 5, 0), true);
      subGrid_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGrid_Visible), 5, 0), true);
      if ( ! (GXutil.strcmp("", A201WWPNotificationLink)==0) )
      {
         lblVisualize_Visible = 1 ;
      }
      else
      {
         lblVisualize_Visible = 0 ;
      }
      lblNotificationitemicon_Caption = GXutil.format( "<i class='%1 %2'></i>", "NotificationFontIcon", A198WWPNotificationIcon, "", "", "", "", "", "", "") ;
      AV18WWPNotificationCreated = GXutil.resetMillis(A40WWPNotificationCreated) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavWwpnotificationcreated_Internalname, localUtil.ttoc( AV18WWPNotificationCreated, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      if ( A203WWPNotificationIsRead )
      {
         lblMarkasread_Caption = "<i class=\"fas fa-envelope DiscussionsSendIcon\"></i>" ;
         lblMarkasread_Tooltiptext = httpContext.getMessage( "Mark as unread", "") ;
         edtWWPNotificationTitle_Class = "SimpleCardAttributeTitleLight" ;
      }
      else
      {
         lblMarkasread_Caption = "<i class=\"fas fa-envelope-open DiscussionsSendIcon\"></i>" ;
         lblMarkasread_Tooltiptext = httpContext.getMessage( "Mark as read", "") ;
         edtWWPNotificationTitle_Class = "SimpleCardAttributeTitle" ;
      }
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(22) ;
      }
      sendrow_222( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_22_Refreshing )
      {
         httpContext.doAjaxLoad(22, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void e161N2( )
   {
      /* 'DoMarkAsRead' Routine */
      returnInSub = false ;
      GXv_int2[0] = A37WWPNotificationId ;
      new com.mujermorena.wwpbaseobjects.notifications.common.wwp_changenotificationstatus(remoteHandle, context).gxep_setnotificationreadunreadbyid( GXv_int2) ;
      wwp_visualizeallnotifications_impl.this.A37WWPNotificationId = GXv_int2[0] ;
      this.executeExternalObjectMethod("", false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
      GRID_nFirstRecordOnPage = 0 ;
      GRID_nCurrentRecord = 0 ;
      GXCCtl = "GRID_nFirstRecordOnPage_" + sGXsfl_22_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      /*  Sending Event outputs  */
   }

   public void e111N2( )
   {
      /* 'DoMarkAllAsRead' Routine */
      returnInSub = false ;
      new com.mujermorena.wwpbaseobjects.notifications.common.wwp_changenotificationstatus(remoteHandle, context).gxep_setallnotificationsofloggeduserread( ) ;
      this.executeExternalObjectMethod("", false, "GlobalEvents", "Master_RefreshHeader", new Object[] {}, true);
      GRID_nFirstRecordOnPage = 0 ;
      GRID_nCurrentRecord = 0 ;
      GXCCtl = "GRID_nFirstRecordOnPage_" + sGXsfl_22_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      gxgrgrid_refresh( subGrid_Rows, AV22Pgmname, AV15IsAuthorized_ManageSubscriptions) ;
      /*  Sending Event outputs  */
   }

   public void e121N2( )
   {
      /* 'DoManageSubscriptions' Routine */
      returnInSub = false ;
      if ( AV15IsAuthorized_ManageSubscriptions )
      {
         callWebObject(formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      else
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "WWP_ActionNoLongerAvailable", ""));
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      GXt_boolean3 = AV15IsAuthorized_ManageSubscriptions ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "wwpsubscriptionssettings_Execute", GXv_boolean4) ;
      wwp_visualizeallnotifications_impl.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV15IsAuthorized_ManageSubscriptions = GXt_boolean3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized_ManageSubscriptions", AV15IsAuthorized_ManageSubscriptions);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISAUTHORIZED_MANAGESUBSCRIPTIONS", getSecureSignedToken( "", AV15IsAuthorized_ManageSubscriptions));
      if ( ! ( AV15IsAuthorized_ManageSubscriptions ) )
      {
         lblBtnmanagesubscriptions_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblBtnmanagesubscriptions_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblBtnmanagesubscriptions_Visible), 5, 0), true);
      }
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV13Session.getValue(AV22Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV22Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV13Session.getValue(AV22Pgmname+"GridState"), null, null);
      }
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV13Session.getValue(AV22Pgmname+"GridState"), null, null);
      new com.mujermorena.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV22Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "Mujer_Morena")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext)new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV22Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "WWPBaseObjects.Notifications.Common.WWP_Notification" );
      AV13Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "Mujer_Morena"));
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
      pa1N2( ) ;
      ws1N2( ) ;
      we1N2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111144120", true, true);
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
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("wwpbaseobjects/notifications/common/wwp_visualizeallnotifications.js", "?202412111144120", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_222( )
   {
      lblNotificationitemicon_Internalname = "NOTIFICATIONITEMICON_"+sGXsfl_22_idx ;
      edtWWPNotificationTitle_Internalname = "WWPNOTIFICATIONTITLE_"+sGXsfl_22_idx ;
      edtavWwpnotificationcreated_Internalname = "vWWPNOTIFICATIONCREATED_"+sGXsfl_22_idx ;
      lblVisualize_Internalname = "VISUALIZE_"+sGXsfl_22_idx ;
      lblMarkasread_Internalname = "MARKASREAD_"+sGXsfl_22_idx ;
      edtWWPNotificationShortDescriptio_Internalname = "WWPNOTIFICATIONSHORTDESCRIPTIO_"+sGXsfl_22_idx ;
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID_"+sGXsfl_22_idx ;
      edtWWPNotificationLink_Internalname = "WWPNOTIFICATIONLINK_"+sGXsfl_22_idx ;
      edtWWPNotificationMetadata_Internalname = "WWPNOTIFICATIONMETADATA_"+sGXsfl_22_idx ;
   }

   public void subsflControlProps_fel_222( )
   {
      lblNotificationitemicon_Internalname = "NOTIFICATIONITEMICON_"+sGXsfl_22_fel_idx ;
      edtWWPNotificationTitle_Internalname = "WWPNOTIFICATIONTITLE_"+sGXsfl_22_fel_idx ;
      edtavWwpnotificationcreated_Internalname = "vWWPNOTIFICATIONCREATED_"+sGXsfl_22_fel_idx ;
      lblVisualize_Internalname = "VISUALIZE_"+sGXsfl_22_fel_idx ;
      lblMarkasread_Internalname = "MARKASREAD_"+sGXsfl_22_fel_idx ;
      edtWWPNotificationShortDescriptio_Internalname = "WWPNOTIFICATIONSHORTDESCRIPTIO_"+sGXsfl_22_fel_idx ;
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID_"+sGXsfl_22_fel_idx ;
      edtWWPNotificationLink_Internalname = "WWPNOTIFICATIONLINK_"+sGXsfl_22_fel_idx ;
      edtWWPNotificationMetadata_Internalname = "WWPNOTIFICATIONMETADATA_"+sGXsfl_22_fel_idx ;
   }

   public void sendrow_222( )
   {
      subsflControlProps_222( ) ;
      wb1N0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_22_idx - GRID_nFirstRecordOnPage <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0xFFFFFF) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_22_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0xFFFFFF) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         /* Start of Columns property logic. */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr"+" class=\""+subGrid_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_22_idx+"\">") ;
         }
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgrid_Internalname+"_"+sGXsfl_22_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 CellMarginTop","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablefscard_Internalname+"_"+sGXsfl_22_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","NotificationCardTable","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable1_Internalname+"_"+sGXsfl_22_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CellPaddingTop5","left","top","","","div"});
         /* Text block */
         GridRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblNotificationitemicon_Internalname,lblNotificationitemicon_Caption,"","",lblNotificationitemicon_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","flex-grow:1;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTablecontent_Internalname+"_"+sGXsfl_22_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtable2_Internalname+"_"+sGXsfl_22_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Flex","left","top"," "+"data-gx-flex"+" ","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationTitle_Internalname,httpContext.getMessage( "Notification Title", ""),"gx-form-item SimpleCardAttributeTitleLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Multiple line edit */
         ClassString = edtWWPNotificationTitle_Class ;
         StyleString = "" ;
         ClassString = edtWWPNotificationTitle_Class ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationTitle_Internalname,A199WWPNotificationTitle,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CellMarginLeft CellPaddingTop5","left","top","","flex-grow:1;","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationcreated_Internalname,httpContext.getMessage( "WWPNotification Created", ""),"gx-form-item NotificationItemDatetimeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
         /* Single line edit */
         TempTags = " " + ((edtavWwpnotificationcreated_Enabled!=0)&&(edtavWwpnotificationcreated_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 42,'',false,'"+sGXsfl_22_idx+"',22)\"" : " ") ;
         ROClassString = "NotificationItemDatetime" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavWwpnotificationcreated_Internalname,localUtil.ttoc( AV18WWPNotificationCreated, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "),localUtil.format( AV18WWPNotificationCreated, "99/99/99 99:99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+((edtavWwpnotificationcreated_Enabled!=0)&&(edtavWwpnotificationcreated_Visible!=0) ? " onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,42);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavWwpnotificationcreated_Jsonclick,Integer.valueOf(0),"NotificationItemDatetime","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavWwpnotificationcreated_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(14),"chr",Integer.valueOf(1),"row",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","left","top","","","div"});
         /* Text block */
         GridRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblVisualize_Internalname,httpContext.getMessage( "<i class=\"fas fa-search DiscussionsSendIcon\"></i>", ""),"","",lblVisualize_Jsonclick,"'"+""+"'"+",false,"+"'"+"e171n2_client"+"'","","TextBlock",Integer.valueOf(7),"",Integer.valueOf(lblVisualize_Visible),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(1)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","CellMarginLeft","left","top","","","div"});
         /* Text block */
         GridRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblMarkasread_Internalname,lblMarkasread_Caption,"","",lblMarkasread_Jsonclick,"'"+""+"'"+",false,"+"'"+"E\\'DOMARKASREAD\\'."+sGXsfl_22_idx+"'","","TextBlock",Integer.valueOf(5),lblMarkasread_Tooltiptext,Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(1)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
         /* Attribute/Variable Label */
         GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationShortDescriptio_Internalname,httpContext.getMessage( "Notification Short Description", ""),"col-sm-3 CardNotificationAttributeDescriptionLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
         /* Multiple line edit */
         ClassString = "CardNotificationAttributeDescription" ;
         StyleString = "" ;
         ClassString = "CardNotificationAttributeDescription" ;
         StyleString = "" ;
         GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationShortDescriptio_Internalname,A200WWPNotificationShortDescriptio,"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",Integer.valueOf(0),StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
         /* Div Control */
         GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 Invisible","left","top","","","div"});
         /* Table start */
         GridRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsgrid_Internalname+"_"+sGXsfl_22_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
         sendrow_22230( ) ;
      }
   }

   public void sendrow_22230( )
   {
      GridRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationId_Internalname,httpContext.getMessage( "Notification Id", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationId_Internalname,GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A37WWPNotificationId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtWWPNotificationId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtWWPNotificationId_Visible),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(10),"chr",Integer.valueOf(1),"row",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"WWPBaseObjects\\WWP_Id","right",Boolean.valueOf(false),""});
      GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( GridContainer.GetWrapped() == 1 )
      {
         GridContainer.CloseTag("cell");
      }
      GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationLink_Internalname,httpContext.getMessage( "Notification Link", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationLink_Internalname,A201WWPNotificationLink,"","","'"+""+"'"+",false,"+"'"+""+"'",A201WWPNotificationLink,"_blank","","",edtWWPNotificationLink_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtWWPNotificationLink_Visible),Integer.valueOf(0),Integer.valueOf(0),"url","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(1000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(22),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"GeneXus\\Url","left",Boolean.valueOf(true),""});
      GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( GridContainer.GetWrapped() == 1 )
      {
         GridContainer.CloseTag("cell");
      }
      GridRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      GridRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtWWPNotificationMetadata_Internalname,httpContext.getMessage( "WWPNotification Metadata", ""),"gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      GridRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtWWPNotificationMetadata_Internalname,A182WWPNotificationMetadata,"","",Integer.valueOf(0),Integer.valueOf(edtWWPNotificationMetadata_Visible),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",Integer.valueOf(0),StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( GridContainer.GetWrapped() == 1 )
      {
         GridContainer.CloseTag("cell");
      }
      if ( GridContainer.GetWrapped() == 1 )
      {
         GridContainer.CloseTag("row");
      }
      if ( GridContainer.GetWrapped() == 1 )
      {
         GridContainer.CloseTag("table");
      }
      /* End of table */
      GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes1N2( ) ;
      /* End of Columns property logic. */
      GridContainer.AddRow(GridRow);
      nGXsfl_22_idx = ((subGrid_Islastpage==1)&&(nGXsfl_22_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_22_idx+1) ;
      sGXsfl_22_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_22_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_222( ) ;
      /* End function sendrow_222 */
   }

   public void startgridcontrol22( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"22\">") ;
         sStyleString = "" ;
         if ( subGrid_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         com.mujermorena.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetIsFreestyle(true);
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGrid_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
         GridContainer.AddObjectProperty("Class", "FreeStyleGrid");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGrid_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", lblNotificationitemicon_Caption);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A199WWPNotificationTitle);
         GridColumn.AddObjectProperty("Class", GXutil.rtrim( edtWWPNotificationTitle_Class));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", localUtil.ttoc( AV18WWPNotificationCreated, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         GridColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavWwpnotificationcreated_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", lblVisualize_Caption);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", lblMarkasread_Caption);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A200WWPNotificationShortDescriptio);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A37WWPNotificationId, (byte)(10), (byte)(0), ".", "")));
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationId_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A201WWPNotificationLink);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationLink_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A182WWPNotificationMetadata);
         GridColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtWWPNotificationMetadata_Visible, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblBtnmarkallasread_Internalname = "BTNMARKALLASREAD" ;
      lblBtnmanagesubscriptions_Internalname = "BTNMANAGESUBSCRIPTIONS" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      lblNonotifications_Internalname = "NONOTIFICATIONS" ;
      lblNotificationitemicon_Internalname = "NOTIFICATIONITEMICON" ;
      edtWWPNotificationTitle_Internalname = "WWPNOTIFICATIONTITLE" ;
      edtavWwpnotificationcreated_Internalname = "vWWPNOTIFICATIONCREATED" ;
      lblVisualize_Internalname = "VISUALIZE" ;
      lblMarkasread_Internalname = "MARKASREAD" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      edtWWPNotificationShortDescriptio_Internalname = "WWPNOTIFICATIONSHORTDESCRIPTIO" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTablefscard_Internalname = "TABLEFSCARD" ;
      edtWWPNotificationId_Internalname = "WWPNOTIFICATIONID" ;
      edtWWPNotificationLink_Internalname = "WWPNOTIFICATIONLINK" ;
      edtWWPNotificationMetadata_Internalname = "WWPNOTIFICATIONMETADATA" ;
      tblUnnamedtablecontentfsgrid_Internalname = "UNNAMEDTABLECONTENTFSGRID" ;
      divUnnamedtablefsgrid_Internalname = "UNNAMEDTABLEFSGRID" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      lblMarkasread_Caption = httpContext.getMessage( "<i class=\"fas fa-envelope-open DiscussionsSendIcon\"></i>", "") ;
      lblVisualize_Caption = httpContext.getMessage( "<i class=\"fas fa-search DiscussionsSendIcon\"></i>", "") ;
      lblNotificationitemicon_Caption = httpContext.getMessage( "<i class='fas fa-pencil-alt NotificationFontIconSuccess'></i>", "") ;
      edtWWPNotificationLink_Jsonclick = "" ;
      edtWWPNotificationId_Jsonclick = "" ;
      lblMarkasread_Tooltiptext = "" ;
      lblMarkasread_Caption = httpContext.getMessage( "<i class=\"fas fa-envelope-open DiscussionsSendIcon\"></i>", "") ;
      lblVisualize_Visible = 1 ;
      edtavWwpnotificationcreated_Jsonclick = "" ;
      edtavWwpnotificationcreated_Visible = 1 ;
      edtavWwpnotificationcreated_Enabled = 1 ;
      edtWWPNotificationTitle_Class = "SimpleCardAttributeTitle" ;
      lblNotificationitemicon_Caption = httpContext.getMessage( "<i class='fas fa-pencil-alt NotificationFontIconSuccess'></i>", "") ;
      subGrid_Class = "FreeStyleGrid" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Visible = 1 ;
      lblNonotifications_Visible = 1 ;
      lblBtnmanagesubscriptions_Caption = httpContext.getMessage( "<i class='fas fa-cog' title='Administrar mis suscripciones'></i>", "") ;
      lblBtnmanagesubscriptions_Visible = 1 ;
      lblBtnmarkallasread_Caption = httpContext.getMessage( "<i class='fas fa-envelope-open' title='Marcar todo como leido'></i>", "") ;
      divTablemain_Width = 0 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Visualize all notifications", "") );
      edtWWPNotificationMetadata_Visible = 1 ;
      edtWWPNotificationLink_Visible = 1 ;
      edtWWPNotificationId_Visible = 1 ;
      subGrid_Rows = 50 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e151N2',iparms:[{av:'A201WWPNotificationLink',fld:'WWPNOTIFICATIONLINK',pic:''},{av:'A198WWPNotificationIcon',fld:'WWPNOTIFICATIONICON',pic:''},{av:'A40WWPNotificationCreated',fld:'WWPNOTIFICATIONCREATED',pic:'99/99/9999 99:99:99.999'},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'lblVisualize_Visible',ctrl:'VISUALIZE',prop:'Visible'},{av:'lblNotificationitemicon_Caption',ctrl:'NOTIFICATIONITEMICON',prop:'Caption'},{av:'AV18WWPNotificationCreated',fld:'vWWPNOTIFICATIONCREATED',pic:'99/99/99 99:99'},{av:'lblMarkasread_Caption',ctrl:'MARKASREAD',prop:'Caption'},{av:'lblMarkasread_Tooltiptext',ctrl:'MARKASREAD',prop:'Tooltiptext'},{av:'edtWWPNotificationTitle_Class',ctrl:'WWPNOTIFICATIONTITLE',prop:'Class'}]}");
      setEventMetadata("'DOVISUALIZE'","{handler:'e171N2',iparms:[{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("'DOVISUALIZE'",",oparms:[{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("'DOMARKASREAD'","{handler:'e161N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'A37WWPNotificationId',fld:'WWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("'DOMARKASREAD'",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("'DOMARKALLASREAD'","{handler:'e111N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true}]");
      setEventMetadata("'DOMARKALLASREAD'",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("'DOMANAGESUBSCRIPTIONS'","{handler:'e121N2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true}]");
      setEventMetadata("'DOMANAGESUBSCRIPTIONS'",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'edtWWPNotificationId_Visible',ctrl:'WWPNOTIFICATIONID',prop:'Visible'},{av:'edtWWPNotificationLink_Visible',ctrl:'WWPNOTIFICATIONLINK',prop:'Visible'},{av:'edtWWPNotificationMetadata_Visible',ctrl:'WWPNOTIFICATIONMETADATA',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'AV22Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[{av:'lblNonotifications_Visible',ctrl:'NONOTIFICATIONS',prop:'Visible'},{av:'subGrid_Visible',ctrl:'GRID',prop:'Visible'},{av:'AV15IsAuthorized_ManageSubscriptions',fld:'vISAUTHORIZED_MANAGESUBSCRIPTIONS',pic:'',hsh:true},{av:'lblBtnmanagesubscriptions_Visible',ctrl:'BTNMANAGESUBSCRIPTIONS',prop:'Visible'}]}");
      setEventMetadata("VALIDV_WWPNOTIFICATIONCREATED","{handler:'validv_Wwpnotificationcreated',iparms:[]");
      setEventMetadata("VALIDV_WWPNOTIFICATIONCREATED",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Wwpnotificationmetadata',iparms:[]");
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
      return "wwpvisualizeallnotifications_Execute";
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
      AV22Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      A198WWPNotificationIcon = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblBtnmarkallasread_Jsonclick = "" ;
      lblBtnmanagesubscriptions_Jsonclick = "" ;
      lblNonotifications_Jsonclick = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A199WWPNotificationTitle = "" ;
      AV18WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      A200WWPNotificationShortDescriptio = "" ;
      A201WWPNotificationLink = "" ;
      A182WWPNotificationMetadata = "" ;
      GXCCtl = "" ;
      scmdbuf = "" ;
      AV21Udparg1 = "" ;
      H001N2_A32WWPUserExtendedId = new String[] {""} ;
      H001N2_n32WWPUserExtendedId = new boolean[] {false} ;
      H001N2_A198WWPNotificationIcon = new String[] {""} ;
      H001N2_A203WWPNotificationIsRead = new boolean[] {false} ;
      H001N2_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      H001N2_A182WWPNotificationMetadata = new String[] {""} ;
      H001N2_n182WWPNotificationMetadata = new boolean[] {false} ;
      H001N2_A201WWPNotificationLink = new String[] {""} ;
      H001N2_A37WWPNotificationId = new long[1] ;
      H001N2_A200WWPNotificationShortDescriptio = new String[] {""} ;
      H001N2_A199WWPNotificationTitle = new String[] {""} ;
      A32WWPUserExtendedId = "" ;
      H001N3_AGRID_nRecordCount = new long[1] ;
      AV6WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      GXv_int2 = new long[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV13Session = httpContext.getWebSession();
      AV11GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV9TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8HTTPRequest = httpContext.getHttpRequest();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      lblNotificationitemicon_Jsonclick = "" ;
      TempTags = "" ;
      ROClassString = "" ;
      lblVisualize_Jsonclick = "" ;
      lblMarkasread_Jsonclick = "" ;
      subGrid_Header = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications__default(),
         new Object[] {
             new Object[] {
            H001N2_A32WWPUserExtendedId, H001N2_n32WWPUserExtendedId, H001N2_A198WWPNotificationIcon, H001N2_A203WWPNotificationIsRead, H001N2_A40WWPNotificationCreated, H001N2_A182WWPNotificationMetadata, H001N2_n182WWPNotificationMetadata, H001N2_A201WWPNotificationLink, H001N2_A37WWPNotificationId, H001N2_A200WWPNotificationShortDescriptio,
            H001N2_A199WWPNotificationTitle
            }
            , new Object[] {
            H001N3_AGRID_nRecordCount
            }
         }
      );
      AV22Pgmname = "WWPBaseObjects.Notifications.Common.WWP_VisualizeAllNotifications" ;
      /* GeneXus formulas. */
      AV22Pgmname = "WWPBaseObjects.Notifications.Common.WWP_VisualizeAllNotifications" ;
      Gx_err = (short)(0) ;
      edtavWwpnotificationcreated_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtWWPNotificationId_Visible ;
   private int edtWWPNotificationLink_Visible ;
   private int edtWWPNotificationMetadata_Visible ;
   private int nRC_GXsfl_22 ;
   private int subGrid_Rows ;
   private int nGXsfl_22_idx=1 ;
   private int divTablemain_Width ;
   private int lblBtnmanagesubscriptions_Visible ;
   private int lblNonotifications_Visible ;
   private int subGrid_Visible ;
   private int subGrid_Islastpage ;
   private int edtavWwpnotificationcreated_Enabled ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int lblVisualize_Visible ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int edtavWwpnotificationcreated_Visible ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long A37WWPNotificationId ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private long GXv_int2[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_22_idx="0001" ;
   private String edtWWPNotificationId_Internalname ;
   private String edtWWPNotificationLink_Internalname ;
   private String edtWWPNotificationMetadata_Internalname ;
   private String AV22Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTableheader_Internalname ;
   private String lblBtnmarkallasread_Internalname ;
   private String lblBtnmarkallasread_Caption ;
   private String lblBtnmarkallasread_Jsonclick ;
   private String lblBtnmanagesubscriptions_Internalname ;
   private String lblBtnmanagesubscriptions_Caption ;
   private String lblBtnmanagesubscriptions_Jsonclick ;
   private String lblNonotifications_Internalname ;
   private String lblNonotifications_Jsonclick ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtWWPNotificationTitle_Internalname ;
   private String edtavWwpnotificationcreated_Internalname ;
   private String edtWWPNotificationShortDescriptio_Internalname ;
   private String GXCCtl ;
   private String scmdbuf ;
   private String AV21Udparg1 ;
   private String A32WWPUserExtendedId ;
   private String lblNotificationitemicon_Caption ;
   private String lblMarkasread_Caption ;
   private String lblMarkasread_Tooltiptext ;
   private String edtWWPNotificationTitle_Class ;
   private String lblNotificationitemicon_Internalname ;
   private String lblVisualize_Internalname ;
   private String lblMarkasread_Internalname ;
   private String sGXsfl_22_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String divUnnamedtablefsgrid_Internalname ;
   private String divTablefscard_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String lblNotificationitemicon_Jsonclick ;
   private String divTablecontent_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String TempTags ;
   private String ROClassString ;
   private String edtavWwpnotificationcreated_Jsonclick ;
   private String lblVisualize_Jsonclick ;
   private String lblMarkasread_Jsonclick ;
   private String tblUnnamedtablecontentfsgrid_Internalname ;
   private String edtWWPNotificationId_Jsonclick ;
   private String edtWWPNotificationLink_Jsonclick ;
   private String subGrid_Header ;
   private String lblVisualize_Caption ;
   private java.util.Date A40WWPNotificationCreated ;
   private java.util.Date AV18WWPNotificationCreated ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_22_Refreshing=false ;
   private boolean AV15IsAuthorized_ManageSubscriptions ;
   private boolean A203WWPNotificationIsRead ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n182WWPNotificationMetadata ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n32WWPUserExtendedId ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private String A182WWPNotificationMetadata ;
   private String A198WWPNotificationIcon ;
   private String A199WWPNotificationTitle ;
   private String A200WWPNotificationShortDescriptio ;
   private String A201WWPNotificationLink ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV13Session ;
   private IDataStoreProvider pr_default ;
   private String[] H001N2_A32WWPUserExtendedId ;
   private boolean[] H001N2_n32WWPUserExtendedId ;
   private String[] H001N2_A198WWPNotificationIcon ;
   private boolean[] H001N2_A203WWPNotificationIsRead ;
   private java.util.Date[] H001N2_A40WWPNotificationCreated ;
   private String[] H001N2_A182WWPNotificationMetadata ;
   private boolean[] H001N2_n182WWPNotificationMetadata ;
   private String[] H001N2_A201WWPNotificationLink ;
   private long[] H001N2_A37WWPNotificationId ;
   private String[] H001N2_A200WWPNotificationShortDescriptio ;
   private String[] H001N2_A199WWPNotificationTitle ;
   private long[] H001N3_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV11GridState ;
}

final  class wwp_visualizeallnotifications__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001N2", "SELECT [WWPUserExtendedId], [WWPNotificationIcon], [WWPNotificationIsRead], [WWPNotificationCreated], [WWPNotificationMetadata], [WWPNotificationLink], [WWPNotificationId], [WWPNotificationShortDescriptio], [WWPNotificationTitle] FROM [WWP_Notification] WHERE [WWPUserExtendedId] = ? ORDER BY [WWPNotificationCreated] DESC  OFFSET ? ROWS FETCH NEXT CAST((SELECT CASE WHEN ? > 0 THEN ? ELSE 1e9 END) AS INTEGER) ROWS ONLY",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,51, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001N3", "SELECT COUNT(*) FROM [WWP_Notification] WHERE [WWPUserExtendedId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(3);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(4, true);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((long[]) buf[8])[0] = rslt.getLong(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               return;
            case 1 :
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
               stmt.setString(1, (String)parms[0], 40);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 40);
               return;
      }
   }

}

