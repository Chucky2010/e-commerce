package com.mujermorena.wwpbaseobjects.notifications.common ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_visualizenotification_impl extends GXDataArea
{
   public wwp_visualizenotification_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_visualizenotification_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_visualizenotification_impl.class ));
   }

   public wwp_visualizenotification_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "WWPNotificationId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "WWPNotificationId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "WWPNotificationId") ;
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
            AV7WWPNotificationId = GXutil.lval( gxfirstwebparm) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPNotificationId), 10, 0));
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
      pa1O2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1O2( ) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV7WWPNotificationId,10,0))}, new String[] {"WWPNotificationId"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vWWPNOTIFICATIONID", GXutil.ltrim( localUtil.ntoc( AV7WWPNotificationId, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
         we1O2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1O2( ) ;
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
      return formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV7WWPNotificationId,10,0))}, new String[] {"WWPNotificationId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Notifications.Common.WWP_VisualizeNotification" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Visualize one notification", "") ;
   }

   public void wb1O0( )
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, divTablemain_Width, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablefscard_Internalname, 1, 0, "px", 0, "px", "NotificationCardTable", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellPaddingTop5", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblNotificationitemicon_Internalname, httpContext.getMessage( "<i class='fas fa-pencil-alt NotificationFontIconSuccess'></i>", ""), "", "", lblNotificationitemicon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeNotification.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationTitle_Internalname, httpContext.getMessage( "Notification Title", ""), "gx-form-item SimpleCardAttributeTitleLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         ClassString = "SimpleCardAttributeTitle" ;
         StyleString = "" ;
         ClassString = "SimpleCardAttributeTitle" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationTitle_Internalname, A199WWPNotificationTitle, "", "", (short)(0), 1, edtWWPNotificationTitle_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeNotification.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellMarginLeft CellPaddingTop5", "left", "top", "", "flex-grow:1;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationCreated_Internalname, httpContext.getMessage( "Notification Created Date", ""), "gx-form-item NotificationItemDatetimeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtWWPNotificationCreated_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPNotificationCreated_Internalname, localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A40WWPNotificationCreated, "99/99/9999 99:99:99.999"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPNotificationCreated_Jsonclick, 0, "NotificationItemDatetime", "", "", "", "", 1, edtWWPNotificationCreated_Enabled, 0, "text", "", 24, "chr", 1, "row", 24, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "WWPBaseObjects\\WWP_DateTimeMillis", "right", false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeNotification.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPNotificationCreated_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPNotificationCreated_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeNotification.htm");
         httpContext.writeTextNL( "</div>") ;
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellMarginLeft", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblMarkasread_Internalname, lblMarkasread_Caption, "", "", lblMarkasread_Jsonclick, "'"+""+"'"+",false,"+"'"+"E\\'DOMARKASREAD\\'."+"'", "", "TextBlock", 5, lblMarkasread_Tooltiptext, 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeNotification.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPNotificationShortDescriptio_Internalname, httpContext.getMessage( "Notification Short Description", ""), "col-sm-3 CardNotificationAttributeDescriptionLabel", 0, true, "");
         /* Multiple line edit */
         ClassString = "CardNotificationAttributeDescription" ;
         StyleString = "" ;
         ClassString = "CardNotificationAttributeDescription" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPNotificationShortDescriptio_Internalname, A200WWPNotificationShortDescriptio, "", "", (short)(0), 1, edtWWPNotificationShortDescriptio_Enabled, 0, 80, "chr", 3, "row", (byte)(0), StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Notifications\\Common\\WWP_VisualizeNotification.htm");
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
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1O2( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Visualize one notification", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1O0( ) ;
   }

   public void ws1O2( )
   {
      start1O2( ) ;
      evt1O2( ) ;
   }

   public void evt1O2( )
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
                           e111O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOMARKASREAD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoMarkAsRead' */
                           e121O2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e131O2 ();
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
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1O2( )
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

   public void pa1O2( )
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
      rf1O2( ) ;
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

   public void rf1O2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H001O2 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV7WWPNotificationId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A37WWPNotificationId = H001O2_A37WWPNotificationId[0] ;
            A203WWPNotificationIsRead = H001O2_A203WWPNotificationIsRead[0] ;
            A200WWPNotificationShortDescriptio = H001O2_A200WWPNotificationShortDescriptio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
            A40WWPNotificationCreated = H001O2_A40WWPNotificationCreated[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
            A199WWPNotificationTitle = H001O2_A199WWPNotificationTitle[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
            /* Execute user event: Load */
            e131O2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb1O0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1O2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1O0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         A199WWPNotificationTitle = httpContext.cgiGet( edtWWPNotificationTitle_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A199WWPNotificationTitle", A199WWPNotificationTitle);
         A40WWPNotificationCreated = localUtil.ctot( httpContext.cgiGet( edtWWPNotificationCreated_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40WWPNotificationCreated", localUtil.ttoc( A40WWPNotificationCreated, 10, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         A200WWPNotificationShortDescriptio = httpContext.cgiGet( edtWWPNotificationShortDescriptio_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A200WWPNotificationShortDescriptio", A200WWPNotificationShortDescriptio);
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
      e111O2 ();
      if (returnInSub) return;
   }

   public void e111O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divTablemain_Width = 700 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablemain_Internalname, "Width", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablemain_Width), 9, 0), true);
      /* Using cursor H001O3 */
      pr_default.execute(1, new Object[] {Long.valueOf(AV7WWPNotificationId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A37WWPNotificationId = H001O3_A37WWPNotificationId[0] ;
         A32WWPUserExtendedId = H001O3_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = H001O3_n32WWPUserExtendedId[0] ;
         A201WWPNotificationLink = H001O3_A201WWPNotificationLink[0] ;
         A182WWPNotificationMetadata = H001O3_A182WWPNotificationMetadata[0] ;
         n182WWPNotificationMetadata = H001O3_n182WWPNotificationMetadata[0] ;
         if ( GXutil.strcmp(A32WWPUserExtendedId, new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( )) != 0 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            callWebObject(formatLink("com.mujermorena.gamexamplenotauthorized", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         GXv_int1[0] = A37WWPNotificationId ;
         new com.mujermorena.wwpbaseobjects.notifications.common.wwp_changenotificationstatus(remoteHandle, context).gxep_setnotificationreadbyid( GXv_int1) ;
         wwp_visualizenotification_impl.this.A37WWPNotificationId = GXv_int1[0] ;
         if ( ! (GXutil.strcmp("", A201WWPNotificationLink)==0) )
         {
            if ( ! (GXutil.strcmp("", A182WWPNotificationMetadata)==0) )
            {
               AV9WWPNotificationMetadataSDT.fromJSonString(A182WWPNotificationMetadata, null);
               AV8WebSession.setValue(AV9WWPNotificationMetadataSDT.getgxTv_SdtWWP_SDTNotificationMetadata_Sessionkey(), AV9WWPNotificationMetadataSDT.getgxTv_SdtWWP_SDTNotificationMetadata_Sessionvalue());
            }
            callWebObject(formatLink(A201WWPNotificationLink, new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(0) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
   }

   public void e121O2( )
   {
      /* 'DoMarkAsRead' Routine */
      returnInSub = false ;
      GXv_int1[0] = AV7WWPNotificationId ;
      new com.mujermorena.wwpbaseobjects.notifications.common.wwp_changenotificationstatus(remoteHandle, context).gxep_setnotificationreadunreadbyid( GXv_int1) ;
      wwp_visualizenotification_impl.this.AV7WWPNotificationId = GXv_int1[0] ;
      httpContext.doAjaxRefresh();
   }

   protected void nextLoad( )
   {
   }

   protected void e131O2( )
   {
      /* Load Routine */
      returnInSub = false ;
      if ( A203WWPNotificationIsRead )
      {
         lblMarkasread_Caption = "<i class=\"fas fa-envelope DiscussionsSendIcon\"></i>" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMarkasread_Internalname, "Caption", lblMarkasread_Caption, true);
         lblMarkasread_Tooltiptext = httpContext.getMessage( "Mark as unread", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblMarkasread_Internalname, "Tooltiptext", lblMarkasread_Tooltiptext, true);
      }
      else
      {
         lblMarkasread_Caption = "<i class=\"fas fa-envelope-open DiscussionsSendIcon\"></i>" ;
         httpContext.ajax_rsp_assign_prop("", false, lblMarkasread_Internalname, "Caption", lblMarkasread_Caption, true);
         lblMarkasread_Tooltiptext = httpContext.getMessage( "Mark as read", "") ;
         httpContext.ajax_rsp_assign_prop("", false, lblMarkasread_Internalname, "Tooltiptext", lblMarkasread_Tooltiptext, true);
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV7WWPNotificationId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7WWPNotificationId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7WWPNotificationId), 10, 0));
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
      pa1O2( ) ;
      ws1O2( ) ;
      we1O2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111143789", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/notifications/common/wwp_visualizenotification.js", "?202412111143789", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblNotificationitemicon_Internalname = "NOTIFICATIONITEMICON" ;
      edtWWPNotificationTitle_Internalname = "WWPNOTIFICATIONTITLE" ;
      edtWWPNotificationCreated_Internalname = "WWPNOTIFICATIONCREATED" ;
      lblMarkasread_Internalname = "MARKASREAD" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      edtWWPNotificationShortDescriptio_Internalname = "WWPNOTIFICATIONSHORTDESCRIPTIO" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      divTablefscard_Internalname = "TABLEFSCARD" ;
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
      edtWWPNotificationShortDescriptio_Enabled = 0 ;
      lblMarkasread_Tooltiptext = "" ;
      lblMarkasread_Caption = httpContext.getMessage( "<i class=\"fas fa-envelope-open DiscussionsSendIcon\"></i>", "") ;
      edtWWPNotificationCreated_Jsonclick = "" ;
      edtWWPNotificationCreated_Enabled = 0 ;
      edtWWPNotificationTitle_Enabled = 0 ;
      divTablemain_Width = 0 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Visualize one notification", "") );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV7WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOMARKASREAD'","{handler:'e121O2',iparms:[{av:'AV7WWPNotificationId',fld:'vWWPNOTIFICATIONID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("'DOMARKASREAD'",",oparms:[]}");
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
      return "wwpvisualizenotification_Execute";
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
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblNotificationitemicon_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A199WWPNotificationTitle = "" ;
      A40WWPNotificationCreated = GXutil.resetTime( GXutil.nullDate() );
      lblMarkasread_Jsonclick = "" ;
      A200WWPNotificationShortDescriptio = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H001O2_A37WWPNotificationId = new long[1] ;
      H001O2_A203WWPNotificationIsRead = new boolean[] {false} ;
      H001O2_A200WWPNotificationShortDescriptio = new String[] {""} ;
      H001O2_A40WWPNotificationCreated = new java.util.Date[] {GXutil.nullDate()} ;
      H001O2_A199WWPNotificationTitle = new String[] {""} ;
      H001O3_A37WWPNotificationId = new long[1] ;
      H001O3_A32WWPUserExtendedId = new String[] {""} ;
      H001O3_n32WWPUserExtendedId = new boolean[] {false} ;
      H001O3_A201WWPNotificationLink = new String[] {""} ;
      H001O3_A182WWPNotificationMetadata = new String[] {""} ;
      H001O3_n182WWPNotificationMetadata = new boolean[] {false} ;
      A32WWPUserExtendedId = "" ;
      A201WWPNotificationLink = "" ;
      A182WWPNotificationMetadata = "" ;
      AV9WWPNotificationMetadataSDT = new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationMetadata(remoteHandle, context);
      AV8WebSession = httpContext.getWebSession();
      GXv_int1 = new long[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification__default(),
         new Object[] {
             new Object[] {
            H001O2_A37WWPNotificationId, H001O2_A203WWPNotificationIsRead, H001O2_A200WWPNotificationShortDescriptio, H001O2_A40WWPNotificationCreated, H001O2_A199WWPNotificationTitle
            }
            , new Object[] {
            H001O3_A37WWPNotificationId, H001O3_A32WWPUserExtendedId, H001O3_n32WWPUserExtendedId, H001O3_A201WWPNotificationLink, H001O3_A182WWPNotificationMetadata, H001O3_n182WWPNotificationMetadata
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
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int divTablemain_Width ;
   private int edtWWPNotificationTitle_Enabled ;
   private int edtWWPNotificationCreated_Enabled ;
   private int edtWWPNotificationShortDescriptio_Enabled ;
   private int idxLst ;
   private long wcpOAV7WWPNotificationId ;
   private long AV7WWPNotificationId ;
   private long A37WWPNotificationId ;
   private long GXv_int1[] ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablefscard_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String lblNotificationitemicon_Internalname ;
   private String lblNotificationitemicon_Jsonclick ;
   private String divTablecontent_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String edtWWPNotificationTitle_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtWWPNotificationCreated_Internalname ;
   private String edtWWPNotificationCreated_Jsonclick ;
   private String lblMarkasread_Internalname ;
   private String lblMarkasread_Caption ;
   private String lblMarkasread_Jsonclick ;
   private String lblMarkasread_Tooltiptext ;
   private String edtWWPNotificationShortDescriptio_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String A32WWPUserExtendedId ;
   private java.util.Date A40WWPNotificationCreated ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean A203WWPNotificationIsRead ;
   private boolean returnInSub ;
   private boolean n32WWPUserExtendedId ;
   private boolean n182WWPNotificationMetadata ;
   private boolean Cond_result ;
   private String A182WWPNotificationMetadata ;
   private String A199WWPNotificationTitle ;
   private String A200WWPNotificationShortDescriptio ;
   private String A201WWPNotificationLink ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private long[] H001O2_A37WWPNotificationId ;
   private boolean[] H001O2_A203WWPNotificationIsRead ;
   private String[] H001O2_A200WWPNotificationShortDescriptio ;
   private java.util.Date[] H001O2_A40WWPNotificationCreated ;
   private String[] H001O2_A199WWPNotificationTitle ;
   private long[] H001O3_A37WWPNotificationId ;
   private String[] H001O3_A32WWPUserExtendedId ;
   private boolean[] H001O3_n32WWPUserExtendedId ;
   private String[] H001O3_A201WWPNotificationLink ;
   private String[] H001O3_A182WWPNotificationMetadata ;
   private boolean[] H001O3_n182WWPNotificationMetadata ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_SDTNotificationMetadata AV9WWPNotificationMetadataSDT ;
}

final  class wwp_visualizenotification__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001O2", "SELECT [WWPNotificationId], [WWPNotificationIsRead], [WWPNotificationShortDescriptio], [WWPNotificationCreated], [WWPNotificationTitle] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ORDER BY [WWPNotificationId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H001O3", "SELECT [WWPNotificationId], [WWPUserExtendedId], [WWPNotificationLink], [WWPNotificationMetadata] FROM [WWP_Notification] WHERE [WWPNotificationId] = ? ORDER BY [WWPNotificationId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDateTime(4, true);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

