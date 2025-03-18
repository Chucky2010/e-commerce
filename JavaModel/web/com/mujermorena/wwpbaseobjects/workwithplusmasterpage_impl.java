package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class workwithplusmasterpage_impl extends GXMasterPage
{
   public workwithplusmasterpage_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public workwithplusmasterpage_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( workwithplusmasterpage_impl.class ));
   }

   public workwithplusmasterpage_impl( int remoteHandle ,
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
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa092( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws092( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we092( ) ;
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         GXWebForm.addResponsiveMetaHeaders((getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getMeta());
         getDataAreaObject().renderHtmlHeaders();
      }
   }

   public void renderHtmlOpenForm( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlOpenForm();
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
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vLANGUAGESICONSDATA_MPAGE", AV29LanguagesIconsData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLANGUAGESICONSDATA_MPAGE", AV29LanguagesIconsData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vDVELOP_MENU_MPAGE", AV25DVelop_Menu);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_MENU_MPAGE", AV25DVelop_Menu);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vSEARCHAUX_MPAGE", AV17SearchAux);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vNOTIFICATIONINFO_MPAGE", AV13NotificationInfo);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vNOTIFICATIONINFO_MPAGE", AV13NotificationInfo);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUSEREXTENDEDID_MPAGE", GXutil.rtrim( A32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vUDPARG1_MPAGE", GXutil.rtrim( AV40Udparg1));
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "WWPNOTIFICATIONISREAD_MPAGE", A203WWPNotificationIsRead);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Caption", GXutil.rtrim( Ddo_languagesicons_Caption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Cls", GXutil.rtrim( Ddo_languagesicons_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Titlecontrolalign", GXutil.rtrim( Ddo_languagesicons_Titlecontrolalign));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_NOTIFICATIONSWC_MPAGE_Icontype", GXutil.rtrim( Ddc_notificationswc_Icontype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_NOTIFICATIONSWC_MPAGE_Icon", GXutil.rtrim( Ddc_notificationswc_Icon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_NOTIFICATIONSWC_MPAGE_Caption", GXutil.rtrim( Ddc_notificationswc_Caption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_NOTIFICATIONSWC_MPAGE_Cls", GXutil.rtrim( Ddc_notificationswc_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_CARTINFOBTN_MPAGE_Icontype", GXutil.rtrim( Ddc_cartinfobtn_Icontype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_CARTINFOBTN_MPAGE_Icon", GXutil.rtrim( Ddc_cartinfobtn_Icon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_CARTINFOBTN_MPAGE_Cls", GXutil.rtrim( Ddc_cartinfobtn_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_CARTINFOBTN_MPAGE_Componentwidth", GXutil.ltrim( localUtil.ntoc( Ddc_cartinfobtn_Componentwidth, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_CARTINFOBTN_MPAGE_Visible", GXutil.booltostr( Ddc_cartinfobtn_Visible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Cls", GXutil.rtrim( Ucmenu_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Collapsedtitle", GXutil.rtrim( Ucmenu_Collapsedtitle));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Menutype", GXutil.rtrim( Ucmenu_Menutype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Moreoptionenabled", GXutil.booltostr( Ucmenu_Moreoptionenabled));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Moreoptiontype", GXutil.rtrim( Ucmenu_Moreoptiontype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Moreoptioncaption", GXutil.rtrim( Ucmenu_Moreoptioncaption));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "UCMESSAGE_MPAGE_Stoponerror", GXutil.booltostr( Ucmessage_Stoponerror));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enablefixobjectfitcover", GXutil.booltostr( Wwputilities_Enablefixobjectfitcover));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Empowertabs", GXutil.booltostr( Wwputilities_Empowertabs));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus", GXutil.booltostr( Wwputilities_Enableupdaterowselectionstatus));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect", GXutil.booltostr( Wwputilities_Enableconvertcombotobootstrapselect));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnresizing", GXutil.booltostr( Wwputilities_Allowcolumnresizing));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnreordering", GXutil.booltostr( Wwputilities_Allowcolumnreordering));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumndragging", GXutil.booltostr( Wwputilities_Allowcolumndragging));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnsrestore", GXutil.booltostr( Wwputilities_Allowcolumnsrestore));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Pagbarincludegoto", GXutil.booltostr( Wwputilities_Pagbarincludegoto));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Comboloadtype", GXutil.rtrim( Wwputilities_Comboloadtype));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Iteminternalname", GXutil.rtrim( Popover_search_Iteminternalname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Trigger", GXutil.rtrim( Popover_search_Trigger));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Triggerelement", GXutil.rtrim( Popover_search_Triggerelement));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Popoverwidth", GXutil.ltrim( localUtil.ntoc( Popover_search_Popoverwidth, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Position", GXutil.rtrim( Popover_search_Position));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Keepopened", GXutil.booltostr( Popover_search_Keepopened));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Reloadonkeychange", GXutil.booltostr( Popover_search_Reloadonkeychange));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "POPOVER_SEARCH_MPAGE_Minimumcharacters", GXutil.ltrim( localUtil.ntoc( Popover_search_Minimumcharacters, (byte)(9), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vNOTIFICATIONINFO_MPAGE_Message", AV13NotificationInfo.getgxTv_SdtNotificationInfo_Message());
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_NOTIFICATIONSWC_MPAGE_Icon", GXutil.rtrim( Ddc_notificationswc_Icon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDC_NOTIFICATIONSWC_MPAGE_Icon", GXutil.rtrim( Ddc_notificationswc_Icon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DDO_LANGUAGESICONS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_languagesicons_Activeeventkey));
   }

   public void renderHtmlCloseForm092( )
   {
      sendCloseFormHiddens( ) ;
      sendSecurityToken(sPrefix);
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlCloseForm();
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         WebComp_Wwpaux_wc.componentjscripts();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/slimmenu/jquery.slimmenu.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVHorizontalMenu/DVHorizontalMenuRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpage.js", "?2025310138411", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WorkWithPlusMasterPage" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Master Page", "") ;
   }

   public void wb090( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         if ( ! ShowMPWhenPopUp( ) && httpContext.isPopUpObject( ) )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            /* Content placeholder */
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
            httpContext.writeText( ">") ;
            if ( ! isFullAjaxMode( ) )
            {
               getDataAreaObject().renderHtmlContent();
            }
            httpContext.writeText( "</div>") ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
            wbLoad = true ;
            return  ;
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
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellNoPaddingRight", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "TableContentECommerce", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 col-sm-4 CellNoPaddingHorizontal", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablerightheader_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-1 CellHorizontalMenuLogo", "left", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "ImageTopECommerce" + " " + ((GXutil.strcmp(imgLogoheader_gximage, "")==0) ? "GX_Image_LOGO_MMorena_Class" : "GX_Image_"+imgLogoheader_gximage+"_Class") ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "96e3e978-cac4-4e25-9a90-c43eb18787be", "", context.getHttpContext().getTheme( )) ;
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgLogoheader_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 hidden-xs col-sm-8 CellECommerceTopRightActions", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableuserrole_Internalname, 1, 0, "px", 0, "px", "TableTopRightECommerce", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellAttributeSearch", "left", "top", "", "align-self:center;", "div");
         wb_table1_19_092( true) ;
      }
      else
      {
         wb_table1_19_092( false) ;
      }
      return  ;
   }

   public void wb_table1_19_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',true,'',0)\"" ;
         ClassString = "ButtonAsLinkHeaderECommerce" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnmyaccount_Internalname, "", bttBtnmyaccount_Caption, bttBtnmyaccount_Jsonclick, 7, httpContext.getMessage( "UserName", ""), "", StyleString, ClassString, bttBtnmyaccount_Visible, 1, "standard", "'"+""+"'"+",true,"+"'"+"e11091_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',true,'',0)\"" ;
         ClassString = "ButtonAsLinkHeaderECommerce" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnactionlogin_Internalname, "", httpContext.getMessage( "WWP_MasterPage_Login", ""), bttBtnactionlogin_Jsonclick, 7, httpContext.getMessage( "WWP_MasterPage_Login", ""), "", StyleString, ClassString, bttBtnactionlogin_Visible, 1, "standard", "'"+""+"'"+",true,"+"'"+"e12091_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',true,'',0)\"" ;
         ClassString = "ButtonAsLinkHeaderECommerce" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnactionregister_Internalname, "", httpContext.getMessage( "WWP_MasterPage_Register", ""), bttBtnactionregister_Jsonclick, 7, httpContext.getMessage( "WWP_MasterPage_Register", ""), "", StyleString, ClassString, bttBtnactionregister_Visible, 1, "standard", "'"+""+"'"+",true,"+"'"+"e13091_client"+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',true,'',0)\"" ;
         ClassString = "ButtonAsLinkHeaderECommerce" ;
         StyleString = "" ;
         com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtnsalir_Internalname, "", httpContext.getMessage( "Salir", ""), bttBtnsalir_Jsonclick, 5, httpContext.getMessage( "Salir", ""), "", StyleString, ClassString, bttBtnsalir_Visible, 1, "standard", "'"+""+"'"+",true,"+"'"+"EDOSALIR_MPAGE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_languagesicons.setProperty("Caption", Ddo_languagesicons_Caption);
         ucDdo_languagesicons.setProperty("Cls", Ddo_languagesicons_Cls);
         ucDdo_languagesicons.setProperty("DropDownOptionsData", AV29LanguagesIconsData);
         ucDdo_languagesicons.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_languagesicons_Internalname, "DDO_LANGUAGESICONS_MPAGEContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdc_notificationswc.setProperty("IconType", Ddc_notificationswc_Icontype);
         ucDdc_notificationswc.setProperty("Icon", Ddc_notificationswc_Icon);
         ucDdc_notificationswc.setProperty("Caption", Ddc_notificationswc_Caption);
         ucDdc_notificationswc.setProperty("Cls", Ddc_notificationswc_Cls);
         ucDdc_notificationswc.render(context, "dvelop.gxbootstrap.ddcomponent", Ddc_notificationswc_Internalname, "DDC_NOTIFICATIONSWC_MPAGEContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table2_41_092( true) ;
      }
      else
      {
         wb_table2_41_092( false) ;
      }
      return  ;
   }

   public void wb_table2_41_092e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMenuECommerce", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcmenu.setProperty("Cls", Ucmenu_Cls);
         ucUcmenu.setProperty("Menu", AV25DVelop_Menu);
         ucUcmenu.setProperty("CollapsedTitle", Ucmenu_Collapsedtitle);
         ucUcmenu.setProperty("MenuType", Ucmenu_Menutype);
         ucUcmenu.setProperty("MoreOptionEnabled", Ucmenu_Moreoptionenabled);
         ucUcmenu.setProperty("MoreOptionType", Ucmenu_Moreoptiontype);
         ucUcmenu.setProperty("MoreOptionCaption", Ucmenu_Moreoptioncaption);
         ucUcmenu.render(context, "dvelop.dvhorizontalmenu", Ucmenu_Internalname, "UCMENU_MPAGEContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellTableContentWithFooter", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentECommerce", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellECommerceContent", "left", "top", "", "", "div");
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         /* Content placeholder */
         httpContext.writeText( "<div") ;
         com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
         httpContext.writeText( ">") ;
         if ( ! isFullAjaxMode( ) )
         {
            getDataAreaObject().renderHtmlContent();
         }
         httpContext.writeText( "</div>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MasterFooterCellHM", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablefooter_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:center;", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblockfooter_Internalname, httpContext.getMessage( "Mujer Morena - copyright", ""), "", "", lblTextblockfooter_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "FooterText", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcmessage.setProperty("StopOnError", Ucmessage_Stoponerror);
         ucUcmessage.render(context, "dvelop.dvmessage", Ucmessage_Internalname, "UCMESSAGE_MPAGEContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUctooltip.render(context, "dvelop.gxbootstrap.tooltip", Uctooltip_Internalname, "UCTOOLTIP_MPAGEContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucWwputilities.setProperty("EnableFixObjectFitCover", Wwputilities_Enablefixobjectfitcover);
         ucWwputilities.setProperty("EmpowerTabs", Wwputilities_Empowertabs);
         ucWwputilities.setProperty("EnableUpdateRowSelectionStatus", Wwputilities_Enableupdaterowselectionstatus);
         ucWwputilities.setProperty("EnableConvertComboToBootstrapSelect", Wwputilities_Enableconvertcombotobootstrapselect);
         ucWwputilities.setProperty("AllowColumnResizing", Wwputilities_Allowcolumnresizing);
         ucWwputilities.setProperty("AllowColumnReordering", Wwputilities_Allowcolumnreordering);
         ucWwputilities.setProperty("AllowColumnDragging", Wwputilities_Allowcolumndragging);
         ucWwputilities.setProperty("AllowColumnsRestore", Wwputilities_Allowcolumnsrestore);
         ucWwputilities.setProperty("PagBarIncludeGoTo", Wwputilities_Pagbarincludegoto);
         ucWwputilities.setProperty("ComboLoadType", Wwputilities_Comboloadtype);
         ucWwputilities.render(context, "wwp.workwithplusutilities_fal", Wwputilities_Internalname, "WWPUTILITIES_MPAGEContainer");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucWwpdatepicker.render(context, "wwp.datepicker", Wwpdatepicker_Internalname, "WWPDATEPICKER_MPAGEContainer");
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
         /* User Defined Control */
         ucPopover_search.setProperty("Trigger", Popover_search_Trigger);
         ucPopover_search.setProperty("TriggerElement", Popover_search_Triggerelement);
         ucPopover_search.setProperty("PopoverWidth", Popover_search_Popoverwidth);
         ucPopover_search.setProperty("Position", Popover_search_Position);
         ucPopover_search.setProperty("KeepOpened", Popover_search_Keepopened);
         ucPopover_search.setProperty("ReloadOnKeyChange", Popover_search_Reloadonkeychange);
         ucPopover_search.setProperty("MinimumCharacters", Popover_search_Minimumcharacters);
         ucPopover_search.render(context, "dvelop.wwppopover", Popover_search_Internalname, "POPOVER_SEARCH_MPAGEContainer");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',true,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavPickerdummyvariable_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavPickerdummyvariable_Internalname, localUtil.format(AV34PickerDummyVariable, "99/99/99"), localUtil.format( AV34PickerDummyVariable, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "", edtavPickerdummyvariable_Jsonclick, 0, "Invisible", "", "", "", "", 1, 1, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtavPickerdummyvariable_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(1==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         httpContext.writeTextNL( "</div>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, divDiv_wwpauxwc_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "MPW0079"+"", GXutil.rtrim( WebComp_Wwpaux_wc_Component));
            httpContext.writeText( "<div") ;
            com.mujermorena.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpMPW0079"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpMPW0079"+"");
               }
               WebComp_Wwpaux_wc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldWwpaux_wc), GXutil.lower( WebComp_Wwpaux_wc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start092( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup090( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( getDataAreaObject().executeStartEvent() != 0 )
         {
            httpContext.setAjaxCallMode();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void ws092( )
   {
      start092( ) ;
      evt092( ) ;
   }

   public void evt092( )
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
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "RFR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e14092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e15092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Refresh */
                        e16092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "DOSALIR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoSalir' */
                        e17092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Onmessage_gx1 */
                        e18092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS_MPAGE.CARTCHANGED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e19092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e20092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
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
                     else if ( GXutil.strcmp(sEvt, "ONMESSAGE_GX1_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Onmessage_gx1 */
                        e18092 ();
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                  }
               }
               else if ( GXutil.strcmp(sEvtType, "M") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, GXutil.len( sEvt)-2) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-6) ;
                  nCmpId = (short)(GXutil.lval( sEvtType)) ;
                  if ( nCmpId == 79 )
                  {
                     OldWwpaux_wc = httpContext.cgiGet( "MPW0079") ;
                     if ( ( GXutil.len( OldWwpaux_wc) == 0 ) || ( GXutil.strcmp(OldWwpaux_wc, WebComp_Wwpaux_wc_Component) != 0 ) )
                     {
                        WebComp_Wwpaux_wc = WebUtils.getWebComponent(getClass(), "com.mujermorena." + OldWwpaux_wc + "_impl", remoteHandle, context);
                        WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                     }
                     if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
                     {
                        WebComp_Wwpaux_wc.componentprocess("MPW0079", "", sEvt);
                     }
                     WebComp_Wwpaux_wc_Component = OldWwpaux_wc ;
                  }
               }
               if ( httpContext.wbHandled == 0 )
               {
                  getDataAreaObject().dispatchEvents();
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we092( )
   {
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm092( ) ;
         }
      }
   }

   public void pa092( )
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
            GX_FocusControl = edtavSearch_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
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
      rf092( ) ;
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
      edtavQty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, edtavQty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavQty_Enabled), 5, 0), true);
   }

   public void rf092( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         /* Execute user event: Refresh */
         e16092 ();
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
         {
            if ( 1 != 0 )
            {
               if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
               {
                  WebComp_Wwpaux_wc.componentstart();
               }
            }
         }
         gxdyncontrolsrefreshing = true ;
         fix_multi_value_controls( ) ;
         gxdyncontrolsrefreshing = false ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e20092 ();
         wb090( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
   }

   public void send_integrity_lvl_hashes092( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavQty_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, edtavQty_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavQty_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup090( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e15092 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLANGUAGESICONSDATA_MPAGE"), AV29LanguagesIconsData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDVELOP_MENU_MPAGE"), AV25DVelop_Menu);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vNOTIFICATIONINFO_MPAGE"), AV13NotificationInfo);
         /* Read saved values. */
         AV17SearchAux = httpContext.cgiGet( "vSEARCHAUX_MPAGE") ;
         Ddo_languagesicons_Caption = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Caption") ;
         Ddo_languagesicons_Cls = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Cls") ;
         Ddo_languagesicons_Titlecontrolalign = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Titlecontrolalign") ;
         Ddc_notificationswc_Icontype = httpContext.cgiGet( "DDC_NOTIFICATIONSWC_MPAGE_Icontype") ;
         Ddc_notificationswc_Icon = httpContext.cgiGet( "DDC_NOTIFICATIONSWC_MPAGE_Icon") ;
         Ddc_notificationswc_Caption = httpContext.cgiGet( "DDC_NOTIFICATIONSWC_MPAGE_Caption") ;
         Ddc_notificationswc_Cls = httpContext.cgiGet( "DDC_NOTIFICATIONSWC_MPAGE_Cls") ;
         Ddc_cartinfobtn_Icontype = httpContext.cgiGet( "DDC_CARTINFOBTN_MPAGE_Icontype") ;
         Ddc_cartinfobtn_Icon = httpContext.cgiGet( "DDC_CARTINFOBTN_MPAGE_Icon") ;
         Ddc_cartinfobtn_Cls = httpContext.cgiGet( "DDC_CARTINFOBTN_MPAGE_Cls") ;
         Ddc_cartinfobtn_Componentwidth = (int)(localUtil.ctol( httpContext.cgiGet( "DDC_CARTINFOBTN_MPAGE_Componentwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddc_cartinfobtn_Visible = GXutil.strtobool( httpContext.cgiGet( "DDC_CARTINFOBTN_MPAGE_Visible")) ;
         Ucmenu_Cls = httpContext.cgiGet( "UCMENU_MPAGE_Cls") ;
         Ucmenu_Collapsedtitle = httpContext.cgiGet( "UCMENU_MPAGE_Collapsedtitle") ;
         Ucmenu_Menutype = httpContext.cgiGet( "UCMENU_MPAGE_Menutype") ;
         Ucmenu_Moreoptionenabled = GXutil.strtobool( httpContext.cgiGet( "UCMENU_MPAGE_Moreoptionenabled")) ;
         Ucmenu_Moreoptiontype = httpContext.cgiGet( "UCMENU_MPAGE_Moreoptiontype") ;
         Ucmenu_Moreoptioncaption = httpContext.cgiGet( "UCMENU_MPAGE_Moreoptioncaption") ;
         Ucmessage_Stoponerror = GXutil.strtobool( httpContext.cgiGet( "UCMESSAGE_MPAGE_Stoponerror")) ;
         Wwputilities_Enablefixobjectfitcover = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enablefixobjectfitcover")) ;
         Wwputilities_Empowertabs = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Empowertabs")) ;
         Wwputilities_Enableupdaterowselectionstatus = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus")) ;
         Wwputilities_Enableconvertcombotobootstrapselect = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect")) ;
         Wwputilities_Allowcolumnresizing = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnresizing")) ;
         Wwputilities_Allowcolumnreordering = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnreordering")) ;
         Wwputilities_Allowcolumndragging = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumndragging")) ;
         Wwputilities_Allowcolumnsrestore = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnsrestore")) ;
         Wwputilities_Pagbarincludegoto = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Pagbarincludegoto")) ;
         Wwputilities_Comboloadtype = httpContext.cgiGet( "WWPUTILITIES_MPAGE_Comboloadtype") ;
         Popover_search_Iteminternalname = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Iteminternalname") ;
         Popover_search_Trigger = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Trigger") ;
         Popover_search_Triggerelement = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Triggerelement") ;
         Popover_search_Popoverwidth = (int)(localUtil.ctol( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Popoverwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Popover_search_Position = httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Position") ;
         Popover_search_Keepopened = GXutil.strtobool( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Keepopened")) ;
         Popover_search_Reloadonkeychange = GXutil.strtobool( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Reloadonkeychange")) ;
         Popover_search_Minimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "POPOVER_SEARCH_MPAGE_Minimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Ddc_notificationswc_Icon = httpContext.cgiGet( "DDC_NOTIFICATIONSWC_MPAGE_Icon") ;
         Ddo_languagesicons_Activeeventkey = httpContext.cgiGet( "DDO_LANGUAGESICONS_MPAGE_Activeeventkey") ;
         /* Read variables values. */
         AV21Search = httpContext.cgiGet( edtavSearch_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV21Search", AV21Search);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavQty_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavQty_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vQTY_MPAGE");
            GX_FocusControl = edtavQty_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Qty = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV12Qty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Qty), 4, 0));
         }
         else
         {
            AV12Qty = (short)(localUtil.ctol( httpContext.cgiGet( edtavQty_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV12Qty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Qty), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vPICKERDUMMYVARIABLE_MPAGE");
            GX_FocusControl = edtavPickerdummyvariable_Internalname ;
            httpContext.ajax_rsp_assign_attri("", true, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV34PickerDummyVariable = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", true, "AV34PickerDummyVariable", localUtil.format(AV34PickerDummyVariable, "99/99/99"));
         }
         else
         {
            AV34PickerDummyVariable = localUtil.ctod( httpContext.cgiGet( edtavPickerdummyvariable_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV34PickerDummyVariable", localUtil.format(AV34PickerDummyVariable, "99/99/99"));
         }
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
      e15092 ();
      if (returnInSub) return;
   }

   public void e15092( )
   {
      /* Start Routine */
      returnInSub = false ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\""+httpContext.convertURL( context.getHttpContext().getImagePath( "cceab8ff-208f-4395-99fd-7fe799e0d69c", "", context.getHttpContext().getTheme( )))+"\">" );
      divLayoutmaintable_Class = "MainContainerWithFooter" ;
      httpContext.ajax_rsp_assign_prop("", true, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXt_objcol_SdtDVelop_Menu_Item1 = AV25DVelop_Menu ;
      GXv_objcol_SdtDVelop_Menu_Item2[0] = GXt_objcol_SdtDVelop_Menu_Item1 ;
      new com.mujermorena.wwpbaseobjects.menuoptionsdata(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item2) ;
      GXt_objcol_SdtDVelop_Menu_Item1 = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
      AV25DVelop_Menu = GXt_objcol_SdtDVelop_Menu_Item1 ;
      GXv_objcol_SdtDVelop_Menu_Item2[0] = AV25DVelop_Menu ;
      new com.mujermorena.wwpbaseobjects.getmenuauthorizedoptions(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item2) ;
      AV25DVelop_Menu = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
      Popover_search_Iteminternalname = edtavSearch_Internalname ;
      ucPopover_search.sendProperty(context, "", true, Popover_search_Internalname, "ItemInternalName", Popover_search_Iteminternalname);
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      AV29LanguagesIconsData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV30LanguagesIconsDataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "Spanish", "") );
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( httpContext.convertURL( context.getHttpContext().getImagePath( "673a1d61-33cb-4f10-916b-7c9fb6391c49", "", context.getHttpContext().getTheme( ))) );
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('"SpanishIcon"',3) ]
         Target    : [ t([ t('Languagesiconsdataitem',23),t('Icon',3) ],29),t(gximage,3) ]
         ForType   : 29
         Type      : []
      */
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "SpanishOption" );
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV29LanguagesIconsData.add(AV30LanguagesIconsDataItem, 0);
      AV30LanguagesIconsDataItem = (com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( httpContext.getMessage( "English", "") );
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( httpContext.convertURL( context.getHttpContext().getImagePath( "d17b971e-903f-42c1-8eac-c1f10bd50994", "", context.getHttpContext().getTheme( ))) );
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /* * Property gximage not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('"EnglishIcon"',3) ]
         Target    : [ t([ t('Languagesiconsdataitem',23),t('Icon',3) ],29),t(gximage,3) ]
         ForType   : 29
         Type      : []
      */
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "EnglishOption" );
      AV30LanguagesIconsDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV29LanguagesIconsData.add(AV30LanguagesIconsDataItem, 0);
      AV7GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV26UserName = ((GXutil.strcmp("", AV7GAMUser.getgxTv_SdtGAMUser_Firstname())==0) ? AV7GAMUser.getgxTv_SdtGAMUser_Name() : GXutil.trim( AV7GAMUser.getgxTv_SdtGAMUser_Firstname())+" "+GXutil.trim( AV7GAMUser.getgxTv_SdtGAMUser_Lastname())) ;
      bttBtnmyaccount_Caption = AV26UserName ;
      httpContext.ajax_rsp_assign_prop("", true, bttBtnmyaccount_Internalname, "Caption", bttBtnmyaccount_Caption, true);
      AV9CartData.removeItem(1);
      if ( GXutil.strcmp(AV31Httprequest.getMethod(), "GET") == 0 )
      {
         /* Execute user subroutine: 'UPDATECARTINFORMATION' */
         S122 ();
         if (returnInSub) return;
      }
      GXv_char3[0] = AV27Language ;
      if ( new com.mujermorena.wwpbaseobjects.wwp_loadlanguageandtheme(remoteHandle, context).executeUdp( GXv_char3) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      workwithplusmasterpage_impl.this.AV27Language = GXv_char3[0] ;
      if ( Cond_result )
      {
         httpContext.doAjaxRefresh();
      }
      Ddo_languagesicons_Titlecontrolalign = "Left" ;
      ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "TitleControlAlign", Ddo_languagesicons_Titlecontrolalign);
      if ( GXutil.strcmp(AV27Language, "Spanish") == 0 )
      {
         Ddo_languagesicons_Caption = httpContext.getMessage( "ES", "") ;
         ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "Caption", Ddo_languagesicons_Caption);
      }
      else if ( GXutil.strcmp(AV27Language, "English") == 0 )
      {
         Ddo_languagesicons_Caption = httpContext.getMessage( "EN", "") ;
         ucDdo_languagesicons.sendProperty(context, "", true, Ddo_languagesicons_Internalname, "Caption", Ddo_languagesicons_Caption);
      }
      if ( GXutil.strcmp(AV28WebSession.getValue(httpContext.getMessage( "ClientInformationSaved", "")), httpContext.getMessage( "Y", "")) != 0 )
      {
         new com.mujermorena.wwpbaseobjects.notifications.web.wwp_registerwebclient(remoteHandle, context).execute( new com.genexuscore.genexus.client.SdtClientInformation(remoteHandle, context).getgxTv_SdtClientInformation_Id(), (short)(httpContext.getBrowserType( )), httpContext.getBrowserVersion( ), new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( )) ;
         AV28WebSession.setValue(httpContext.getMessage( "ClientInformationSaved", ""), httpContext.getMessage( "Y", ""));
      }
      /* Execute user subroutine: 'LOADNOTIFICATIONS' */
      S132 ();
      if (returnInSub) return;
      lblActionsearch_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", true, lblActionsearch_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblActionsearch_Enabled), 5, 0), true);
      if ( GXutil.strcmp(AV31Httprequest.getMethod(), "GET") == 0 )
      {
         GXt_SdtWWP_DesignSystemSettings4 = AV18WWP_DesignSystemSettings;
         GXv_SdtWWP_DesignSystemSettings5[0] = GXt_SdtWWP_DesignSystemSettings4;
         new com.mujermorena.wwpbaseobjects.wwp_getdesignsystemsettings(remoteHandle, context).execute( GXv_SdtWWP_DesignSystemSettings5) ;
         GXt_SdtWWP_DesignSystemSettings4 = GXv_SdtWWP_DesignSystemSettings5[0] ;
         AV18WWP_DesignSystemSettings = GXt_SdtWWP_DesignSystemSettings4;
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"base-color",AV18WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Basecolor()}, false);
         this.executeExternalObjectMethod("", true, "gx.core.ds", "setOption", new Object[] {"background-color",AV18WWP_DesignSystemSettings.getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle()}, false);
         this.executeExternalObjectMethod("", true, "WWPActions", "EmpoweredGrids_Refresh", new Object[] {}, false);
      }
      AV36RolIdBOO = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).checkrolebyid(4) ;
      if ( AV36RolIdBOO )
      {
         GXt_objcol_SdtDVelop_Menu_Item1 = AV25DVelop_Menu ;
         GXv_objcol_SdtDVelop_Menu_Item2[0] = GXt_objcol_SdtDVelop_Menu_Item1 ;
         new com.mujermorena.wwpbaseobjects.menuoptionsdatacliente(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item2) ;
         GXt_objcol_SdtDVelop_Menu_Item1 = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
         AV25DVelop_Menu = GXt_objcol_SdtDVelop_Menu_Item1 ;
         GXv_objcol_SdtDVelop_Menu_Item2[0] = AV25DVelop_Menu ;
         new com.mujermorena.wwpbaseobjects.getmenuauthorizedoptions(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item2) ;
         AV25DVelop_Menu = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
      }
   }

   public void e16092( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'CHECKSECURITYFORACTIONS' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e17092( )
   {
      /* 'DoSalir' Routine */
      returnInSub = false ;
      AV27Language = httpContext.getLanguage( ) ;
      httpContext.ajax_rsp_assign_attri("", true, "AV27Language", AV27Language);
      GXv_objcol_SdtGAMError6[0] = AV5GAMErrorCollection ;
      AV6isOk = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).logout(GXv_objcol_SdtGAMError6) ;
      AV5GAMErrorCollection = GXv_objcol_SdtGAMError6[0] ;
      AV28WebSession.clear();
      AV28WebSession.setValue("isLangLoaded", "true");
      callWebObject(formatLink("com.mujermorena.home", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void e14092( )
   {
      /* Ddo_languagesicons_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_languagesicons_Activeeventkey, "SpanishOption") == 0 )
      {
         /* Execute user subroutine: 'DO SPANISHOPTION' */
         S152 ();
         if (returnInSub) return;
      }
      else if ( GXutil.strcmp(Ddo_languagesicons_Activeeventkey, "EnglishOption") == 0 )
      {
         /* Execute user subroutine: 'DO ENGLISHOPTION' */
         S162 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'CHECKSECURITYFORACTIONS' Routine */
      returnInSub = false ;
      if ( ! ( ! new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).isanonymous() ) )
      {
         bttBtnmyaccount_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, bttBtnmyaccount_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnmyaccount_Visible), 5, 0), true);
      }
      if ( ! ( new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).isanonymous() ) )
      {
         bttBtnactionlogin_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, bttBtnactionlogin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnactionlogin_Visible), 5, 0), true);
      }
      if ( ! ( new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).isanonymous() ) )
      {
         bttBtnactionregister_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, bttBtnactionregister_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnactionregister_Visible), 5, 0), true);
      }
      if ( ! ( ! new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).isanonymous() ) )
      {
         bttBtnsalir_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, bttBtnsalir_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnsalir_Visible), 5, 0), true);
      }
      if ( ! ( GXutil.strcmp(Contentholder.getPgmname(), httpContext.getMessage( "WWPBaseObjects.CartDetail", "")) == 0 ) )
      {
         Ddc_cartinfobtn_Visible = true ;
         ucDdc_cartinfobtn.sendProperty(context, "", true, Ddc_cartinfobtn_Internalname, "Visible", GXutil.booltostr( Ddc_cartinfobtn_Visible));
      }
      else
      {
         Ddc_cartinfobtn_Visible = false ;
         ucDdc_cartinfobtn.sendProperty(context, "", true, Ddc_cartinfobtn_Internalname, "Visible", GXutil.booltostr( Ddc_cartinfobtn_Visible));
      }
   }

   public void S152( )
   {
      /* 'DO SPANISHOPTION' Routine */
      returnInSub = false ;
      if ( setLanguage( "Spanish") == 0 )
      {
         AV28WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
   }

   public void S162( )
   {
      /* 'DO ENGLISHOPTION' Routine */
      returnInSub = false ;
      if ( setLanguage( "English") == 0 )
      {
         AV28WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( ! ( ! ( GXutil.strcmp(Contentholder.getPgmname(), httpContext.getMessage( "WWPBaseObjects.CartDetail", "")) == 0 ) ) )
      {
         edtavQty_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", true, edtavQty_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavQty_Visible), 5, 0), true);
         cellQty_cell_Class = "Invisible" ;
         httpContext.ajax_rsp_assign_prop("", true, cellQty_cell_Internalname, "Class", cellQty_cell_Class, true);
      }
      else
      {
         edtavQty_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", true, edtavQty_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavQty_Visible), 5, 0), true);
         cellQty_cell_Class = "QtyCartCell" ;
         httpContext.ajax_rsp_assign_prop("", true, cellQty_cell_Internalname, "Class", cellQty_cell_Class, true);
      }
   }

   public void e18092( )
   {
      /* Onmessage_gx1 Routine */
      returnInSub = false ;
      if ( GXutil.startsWith( AV13NotificationInfo.getgxTv_SdtNotificationInfo_Id(), "WebNotification#") )
      {
         AV14WWP_WebNotification.fromJSonString(AV13NotificationInfo.getgxTv_SdtNotificationInfo_Message(), null);
         if ( ! new com.mujermorena.wwpbaseobjects.notifications.web.wwp_isreceivedwebnotification(remoteHandle, context).executeUdp( AV14WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid()) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new com.mujermorena.wwpbaseobjects.notifications.web.wwp_setwebnotificationreceived(remoteHandle, context).execute( AV14WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationid()) ;
            AV15WWP_UserExtended.Load(new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ));
            if ( AV15WWP_UserExtended.getgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif() )
            {
               httpContext.GX_msglist.addItem(new com.mujermorena.wwpbaseobjects.dvmessagegetdesktopnotificationmsg(remoteHandle, context).executeUdp( AV14WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtitle(), AV14WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationtext(), AV14WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Wwpwebnotificationicon(), formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizenotification", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14WWP_WebNotification.getgxTv_SdtWWP_WebNotification_Wwpnotificationid(),10,0))}, new String[] {"WWPNotificationId"}) ));
            }
         }
      }
      /* Execute user subroutine: 'LOADNOTIFICATIONS' */
      S132 ();
      if (returnInSub) return;
   }

   public void e19092( )
   {
      /* GlobalEvents_Cartchanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'UPDATECARTINFORMATION' */
      S122 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'LOADNOTIFICATIONS' Routine */
      returnInSub = false ;
      AV16NotificationsCount = (short)(0) ;
      AV40Udparg1 = new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).executeUdp( ) ;
      /* Optimized group. */
      /* Using cursor H00092 */
      pr_default.execute(0, new Object[] {AV40Udparg1});
      cV16NotificationsCount = H00092_AV16NotificationsCount[0] ;
      pr_default.close(0);
      AV16NotificationsCount = (short)(AV16NotificationsCount+cV16NotificationsCount*1) ;
      /* End optimized group. */
      this.executeUsercontrolMethod("", true, "DDC_NOTIFICATIONSWC_MPAGEContainer", "Update", "", new Object[] {((AV16NotificationsCount>0) ? GXutil.trim( GXutil.str( AV16NotificationsCount, 4, 0)) : ""),Ddc_notificationswc_Icon});
   }

   public void S122( )
   {
      /* 'UPDATECARTINFORMATION' Routine */
      returnInSub = false ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item7 = AV8Cart ;
      GXv_objcol_SdtDVelop_ECommerceCart_Item8[0] = GXt_objcol_SdtDVelop_ECommerceCart_Item7 ;
      new com.mujermorena.wwpbaseobjects.getcartcontent(remoteHandle, context).execute( GXv_objcol_SdtDVelop_ECommerceCart_Item8) ;
      GXt_objcol_SdtDVelop_ECommerceCart_Item7 = GXv_objcol_SdtDVelop_ECommerceCart_Item8[0] ;
      AV8Cart = GXt_objcol_SdtDVelop_ECommerceCart_Item7 ;
      AV12Qty = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", true, "AV12Qty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Qty), 4, 0));
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV8Cart.size() )
      {
         AV11CartItem = (com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)((com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item)AV8Cart.elementAt(-1+AV41GXV1));
         AV12Qty = (short)(AV12Qty+(AV11CartItem.getgxTv_SdtDVelop_ECommerceCart_Item_Productqty())) ;
         httpContext.ajax_rsp_assign_attri("", true, "AV12Qty", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Qty), 4, 0));
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e20092( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_41_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblTablemergedddc_cartinfobtn_Internalname, tblTablemergedddc_cartinfobtn_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='MergeDataCell'>") ;
         /* User Defined Control */
         ucDdc_cartinfobtn.setProperty("IconType", Ddc_cartinfobtn_Icontype);
         ucDdc_cartinfobtn.setProperty("Icon", Ddc_cartinfobtn_Icon);
         ucDdc_cartinfobtn.setProperty("Caption", Ddc_cartinfobtn_Caption);
         ucDdc_cartinfobtn.setProperty("Cls", Ddc_cartinfobtn_Cls);
         ucDdc_cartinfobtn.setProperty("ComponentWidth", Ddc_cartinfobtn_Componentwidth);
         ucDdc_cartinfobtn.render(context, "dvelop.gxbootstrap.ddcomponent", Ddc_cartinfobtn_Internalname, "DDC_CARTINFOBTN_MPAGEContainer");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td id=\""+cellQty_cell_Internalname+"\"  class='"+cellQty_cell_Class+"'>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavQty_Internalname, httpContext.getMessage( "Qty", ""), "gx-form-item ActionGroupColoredActionsLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',true,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavQty_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Qty, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavQty_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV12Qty), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV12Qty), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", "", edtavQty_Jsonclick, 0, "ActionGroupColoredActions", "", "", "", "", edtavQty_Visible, edtavQty_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_41_092e( true) ;
      }
      else
      {
         wb_table2_41_092e( false) ;
      }
   }

   public void wb_table1_19_092( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.mujermorena.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.mujermorena.GxWebStd.gx_label_element( httpContext, edtavSearch_Internalname, httpContext.getMessage( "Search", ""), "gx-form-item AttributeSearchLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',true,'',0)\"" ;
         com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtavSearch_Internalname, AV21Search, GXutil.rtrim( localUtil.format( AV21Search, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,23);\"", "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "", "", httpContext.getMessage( "WWP_MasterPage_Search", ""), edtavSearch_Jsonclick, 0, "AttributeSearch", "", "", "", "", 1, edtavSearch_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblActionsearch_Internalname, httpContext.getMessage( "<i class=\"fas fa-search ImageSearchIcon\"></i>", ""), "", "", lblActionsearch_Jsonclick, "'"+""+"'"+",true,"+"'"+"e21091_client"+"'", "", "TextBlock", 7, "", 1, lblActionsearch_Enabled, 1, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPage.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_19_092e( true) ;
      }
      else
      {
         wb_table1_19_092e( false) ;
      }
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
      pa092( ) ;
      ws092( ) ;
      we092( ) ;
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

   public void master_styles( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVHorizontalMenu/DVHorizontalMenu.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome_vlatest/css/all.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Wwpaux_wc == null ) )
      {
         if ( GXutil.len( WebComp_Wwpaux_wc_Component) != 0 )
         {
            WebComp_Wwpaux_wc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?20253101383129", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpage.js", "?20253101383139", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/slimmenu/jquery.slimmenu.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVHorizontalMenu/DVHorizontalMenuRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgLogoheader_Internalname = "LOGOHEADER_MPAGE" ;
      divTablerightheader_Internalname = "TABLERIGHTHEADER_MPAGE" ;
      edtavSearch_Internalname = "vSEARCH_MPAGE" ;
      lblActionsearch_Internalname = "ACTIONSEARCH_MPAGE" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1_MPAGE" ;
      bttBtnmyaccount_Internalname = "BTNMYACCOUNT_MPAGE" ;
      bttBtnactionlogin_Internalname = "BTNACTIONLOGIN_MPAGE" ;
      bttBtnactionregister_Internalname = "BTNACTIONREGISTER_MPAGE" ;
      bttBtnsalir_Internalname = "BTNSALIR_MPAGE" ;
      Ddo_languagesicons_Internalname = "DDO_LANGUAGESICONS_MPAGE" ;
      Ddc_notificationswc_Internalname = "DDC_NOTIFICATIONSWC_MPAGE" ;
      Ddc_cartinfobtn_Internalname = "DDC_CARTINFOBTN_MPAGE" ;
      edtavQty_Internalname = "vQTY_MPAGE" ;
      cellQty_cell_Internalname = "QTY_CELL_MPAGE" ;
      tblTablemergedddc_cartinfobtn_Internalname = "TABLEMERGEDDDC_CARTINFOBTN_MPAGE" ;
      divTableuserrole_Internalname = "TABLEUSERROLE_MPAGE" ;
      Ucmenu_Internalname = "UCMENU_MPAGE" ;
      divTableheader_Internalname = "TABLEHEADER_MPAGE" ;
      divTablecontent_Internalname = "TABLECONTENT_MPAGE" ;
      lblTextblockfooter_Internalname = "TEXTBLOCKFOOTER_MPAGE" ;
      divTablefooter_Internalname = "TABLEFOOTER_MPAGE" ;
      Ucmessage_Internalname = "UCMESSAGE_MPAGE" ;
      Uctooltip_Internalname = "UCTOOLTIP_MPAGE" ;
      Wwputilities_Internalname = "WWPUTILITIES_MPAGE" ;
      Wwpdatepicker_Internalname = "WWPDATEPICKER_MPAGE" ;
      divTablemain_Internalname = "TABLEMAIN_MPAGE" ;
      Popover_search_Internalname = "POPOVER_SEARCH_MPAGE" ;
      edtavPickerdummyvariable_Internalname = "vPICKERDUMMYVARIABLE_MPAGE" ;
      divDiv_wwpauxwc_Internalname = "DIV_WWPAUXWC_MPAGE" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS_MPAGE" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE_MPAGE" ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setInternalname( "FORM_MPAGE" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      lblActionsearch_Enabled = 1 ;
      edtavSearch_Jsonclick = "" ;
      edtavSearch_Enabled = 1 ;
      edtavQty_Jsonclick = "" ;
      edtavQty_Enabled = 1 ;
      cellQty_cell_Class = "" ;
      Ddc_cartinfobtn_Caption = "" ;
      edtavQty_Visible = 1 ;
      edtavPickerdummyvariable_Jsonclick = "" ;
      bttBtnsalir_Visible = 1 ;
      bttBtnactionregister_Visible = 1 ;
      bttBtnactionlogin_Visible = 1 ;
      bttBtnmyaccount_Caption = httpContext.getMessage( "UserName", "") ;
      bttBtnmyaccount_Visible = 1 ;
      divLayoutmaintable_Class = "Table" ;
      Popover_search_Minimumcharacters = 2 ;
      Popover_search_Reloadonkeychange = GXutil.toBoolean( -1) ;
      Popover_search_Keepopened = GXutil.toBoolean( 0) ;
      Popover_search_Position = "Bottom" ;
      Popover_search_Popoverwidth = 400 ;
      Popover_search_Triggerelement = "Value" ;
      Popover_search_Trigger = "Click" ;
      Popover_search_Iteminternalname = "" ;
      Wwputilities_Comboloadtype = "InfiniteScrolling" ;
      Wwputilities_Pagbarincludegoto = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnsrestore = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumndragging = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnreordering = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnresizing = GXutil.toBoolean( -1) ;
      Wwputilities_Enableconvertcombotobootstrapselect = GXutil.toBoolean( -1) ;
      Wwputilities_Enableupdaterowselectionstatus = GXutil.toBoolean( -1) ;
      Wwputilities_Empowertabs = GXutil.toBoolean( -1) ;
      Wwputilities_Enablefixobjectfitcover = GXutil.toBoolean( -1) ;
      Ucmessage_Stoponerror = GXutil.toBoolean( -1) ;
      Ucmenu_Moreoptioncaption = "WWP_More" ;
      Ucmenu_Moreoptiontype = "Slider" ;
      Ucmenu_Moreoptionenabled = GXutil.toBoolean( -1) ;
      Ucmenu_Menutype = "Mega" ;
      Ucmenu_Collapsedtitle = " " ;
      Ucmenu_Cls = "MegaMenu" ;
      Ddc_cartinfobtn_Visible = GXutil.toBoolean( -1) ;
      Ddc_cartinfobtn_Componentwidth = 700 ;
      Ddc_cartinfobtn_Cls = "TextButtonCart" ;
      Ddc_cartinfobtn_Icon = "TextBlockWizardDescriptionCell fas fa-cart-plus" ;
      Ddc_cartinfobtn_Icontype = "FontIcon" ;
      Ddc_notificationswc_Cls = "DropDownNotification" ;
      Ddc_notificationswc_Caption = "999" ;
      Ddc_notificationswc_Icon = "far fa-bell" ;
      Ddc_notificationswc_Icontype = "FontIcon" ;
      Ddo_languagesicons_Titlecontrolalign = "Automatic" ;
      Ddo_languagesicons_Cls = "DropDownOptionsHeader" ;
      Contentholder.setDataArea(getDataAreaObject());
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
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[{ctrl:'BTNMYACCOUNT_MPAGE',prop:'Visible'},{ctrl:'BTNACTIONLOGIN_MPAGE',prop:'Visible'},{ctrl:'BTNACTIONREGISTER_MPAGE',prop:'Visible'},{ctrl:'BTNSALIR_MPAGE',prop:'Visible'},{av:'Ddc_cartinfobtn_Visible',ctrl:'DDC_CARTINFOBTN_MPAGE',prop:'Visible'}]}");
      setEventMetadata("DOMYACCOUNT_MPAGE","{handler:'e11091',iparms:[]");
      setEventMetadata("DOMYACCOUNT_MPAGE",",oparms:[]}");
      setEventMetadata("DOACTIONLOGIN_MPAGE","{handler:'e12091',iparms:[]");
      setEventMetadata("DOACTIONLOGIN_MPAGE",",oparms:[]}");
      setEventMetadata("DOACTIONREGISTER_MPAGE","{handler:'e13091',iparms:[]");
      setEventMetadata("DOACTIONREGISTER_MPAGE",",oparms:[]}");
      setEventMetadata("DOSALIR_MPAGE","{handler:'e17092',iparms:[]");
      setEventMetadata("DOSALIR_MPAGE",",oparms:[{av:'AV27Language',fld:'vLANGUAGE_MPAGE',pic:''}]}");
      setEventMetadata("DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE","{handler:'e14092',iparms:[{av:'Ddo_languagesicons_Activeeventkey',ctrl:'DDO_LANGUAGESICONS_MPAGE',prop:'ActiveEventKey'}]");
      setEventMetadata("DDO_LANGUAGESICONS_MPAGE.ONOPTIONCLICKED_MPAGE",",oparms:[]}");
      setEventMetadata("DOACTIONSEARCH_MPAGE","{handler:'e21091',iparms:[{av:'AV17SearchAux',fld:'vSEARCHAUX_MPAGE',pic:''}]");
      setEventMetadata("DOACTIONSEARCH_MPAGE",",oparms:[]}");
      setEventMetadata("GLOBALEVENTS_MPAGE.CARTCHANGED_MPAGE","{handler:'e19092',iparms:[]");
      setEventMetadata("GLOBALEVENTS_MPAGE.CARTCHANGED_MPAGE",",oparms:[{av:'AV12Qty',fld:'vQTY_MPAGE',pic:'ZZZ9'}]}");
      setEventMetadata("ONMESSAGE_GX1_MPAGE","{handler:'e18092',iparms:[{av:'AV13NotificationInfo',fld:'vNOTIFICATIONINFO_MPAGE',pic:''},{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID_MPAGE',pic:''},{av:'AV40Udparg1',fld:'vUDPARG1_MPAGE',pic:''},{av:'A203WWPNotificationIsRead',fld:'WWPNOTIFICATIONISREAD_MPAGE',pic:''},{av:'Ddc_notificationswc_Icon',ctrl:'DDC_NOTIFICATIONSWC_MPAGE',prop:'Icon'}]");
      setEventMetadata("ONMESSAGE_GX1_MPAGE",",oparms:[]}");
      setEventMetadata("VALIDV_PICKERDUMMYVARIABLE","{handler:'validv_Pickerdummyvariable',iparms:[]");
      setEventMetadata("VALIDV_PICKERDUMMYVARIABLE",",oparms:[]}");
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
      Contentholder = new com.genexus.webpanels.GXDataAreaControl();
      Ddo_languagesicons_Activeeventkey = "" ;
      AV13NotificationInfo = new com.genexuscore.genexus.server.SdtNotificationInfo(remoteHandle, context);
      Form = new com.genexus.webpanels.GXWebForm();
      GXKey = "" ;
      AV29LanguagesIconsData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV25DVelop_Menu = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Mujer_Morena", remoteHandle);
      AV17SearchAux = "" ;
      A32WWPUserExtendedId = "" ;
      AV40Udparg1 = "" ;
      Ddo_languagesicons_Caption = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      imgLogoheader_gximage = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      TempTags = "" ;
      bttBtnmyaccount_Jsonclick = "" ;
      bttBtnactionlogin_Jsonclick = "" ;
      bttBtnactionregister_Jsonclick = "" ;
      bttBtnsalir_Jsonclick = "" ;
      ucDdo_languagesicons = new com.genexus.webpanels.GXUserControl();
      ucDdc_notificationswc = new com.genexus.webpanels.GXUserControl();
      ucUcmenu = new com.genexus.webpanels.GXUserControl();
      lblTextblockfooter_Jsonclick = "" ;
      ucUcmessage = new com.genexus.webpanels.GXUserControl();
      ucUctooltip = new com.genexus.webpanels.GXUserControl();
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      ucWwpdatepicker = new com.genexus.webpanels.GXUserControl();
      ucPopover_search = new com.genexus.webpanels.GXUserControl();
      AV34PickerDummyVariable = GXutil.nullDate() ;
      WebComp_Wwpaux_wc_Component = "" ;
      OldWwpaux_wc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GX_FocusControl = "" ;
      AV21Search = "" ;
      AV30LanguagesIconsDataItem = new com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV7GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV26UserName = "" ;
      AV9CartData = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV31Httprequest = httpContext.getHttpRequest();
      AV27Language = "" ;
      GXv_char3 = new String[1] ;
      AV28WebSession = httpContext.getWebSession();
      AV18WWP_DesignSystemSettings = new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXt_SdtWWP_DesignSystemSettings4 = new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      GXv_SdtWWP_DesignSystemSettings5 = new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings[1] ;
      GXt_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtDVelop_Menu_Item2 = new GXBaseCollection[1] ;
      AV5GAMErrorCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError6 = new GXExternalCollection[1] ;
      ucDdc_cartinfobtn = new com.genexus.webpanels.GXUserControl();
      AV14WWP_WebNotification = new com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification(remoteHandle);
      AV15WWP_UserExtended = new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended(remoteHandle);
      scmdbuf = "" ;
      H00092_AV16NotificationsCount = new short[1] ;
      AV8Cart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXt_objcol_SdtDVelop_ECommerceCart_Item7 = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      GXv_objcol_SdtDVelop_ECommerceCart_Item8 = new GXBaseCollection[1] ;
      AV11CartItem = new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(remoteHandle, context);
      sStyleString = "" ;
      lblActionsearch_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.workwithplusmasterpage__default(),
         new Object[] {
             new Object[] {
            H00092_AV16NotificationsCount
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavQty_Enabled = 0 ;
      WebComp_Wwpaux_wc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV12Qty ;
   private short AV16NotificationsCount ;
   private short cV16NotificationsCount ;
   private int Ddc_cartinfobtn_Componentwidth ;
   private int Popover_search_Popoverwidth ;
   private int Popover_search_Minimumcharacters ;
   private int bttBtnmyaccount_Visible ;
   private int bttBtnactionlogin_Visible ;
   private int bttBtnactionregister_Visible ;
   private int bttBtnsalir_Visible ;
   private int edtavQty_Enabled ;
   private int lblActionsearch_Enabled ;
   private int edtavQty_Visible ;
   private int AV41GXV1 ;
   private int edtavSearch_Enabled ;
   private int idxLst ;
   private String Ddo_languagesicons_Activeeventkey ;
   private String Ddc_notificationswc_Icon ;
   private String GXKey ;
   private String A32WWPUserExtendedId ;
   private String AV40Udparg1 ;
   private String Ddo_languagesicons_Caption ;
   private String Ddo_languagesicons_Cls ;
   private String Ddo_languagesicons_Titlecontrolalign ;
   private String Ddc_notificationswc_Icontype ;
   private String Ddc_notificationswc_Caption ;
   private String Ddc_notificationswc_Cls ;
   private String Ddc_cartinfobtn_Icontype ;
   private String Ddc_cartinfobtn_Icon ;
   private String Ddc_cartinfobtn_Cls ;
   private String Ucmenu_Cls ;
   private String Ucmenu_Collapsedtitle ;
   private String Ucmenu_Menutype ;
   private String Ucmenu_Moreoptiontype ;
   private String Ucmenu_Moreoptioncaption ;
   private String Wwputilities_Comboloadtype ;
   private String Popover_search_Iteminternalname ;
   private String Popover_search_Trigger ;
   private String Popover_search_Triggerelement ;
   private String Popover_search_Position ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTablerightheader_Internalname ;
   private String ClassString ;
   private String imgLogoheader_gximage ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgLogoheader_Internalname ;
   private String divTableuserrole_Internalname ;
   private String TempTags ;
   private String bttBtnmyaccount_Internalname ;
   private String bttBtnmyaccount_Caption ;
   private String bttBtnmyaccount_Jsonclick ;
   private String bttBtnactionlogin_Internalname ;
   private String bttBtnactionlogin_Jsonclick ;
   private String bttBtnactionregister_Internalname ;
   private String bttBtnactionregister_Jsonclick ;
   private String bttBtnsalir_Internalname ;
   private String bttBtnsalir_Jsonclick ;
   private String Ddo_languagesicons_Internalname ;
   private String Ddc_notificationswc_Internalname ;
   private String Ucmenu_Internalname ;
   private String divTablecontent_Internalname ;
   private String divTablefooter_Internalname ;
   private String lblTextblockfooter_Internalname ;
   private String lblTextblockfooter_Jsonclick ;
   private String Ucmessage_Internalname ;
   private String Uctooltip_Internalname ;
   private String Wwputilities_Internalname ;
   private String Wwpdatepicker_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Popover_search_Internalname ;
   private String edtavPickerdummyvariable_Internalname ;
   private String edtavPickerdummyvariable_Jsonclick ;
   private String divDiv_wwpauxwc_Internalname ;
   private String WebComp_Wwpaux_wc_Component ;
   private String OldWwpaux_wc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GX_FocusControl ;
   private String edtavSearch_Internalname ;
   private String edtavQty_Internalname ;
   private String GXv_char3[] ;
   private String lblActionsearch_Internalname ;
   private String Ddc_cartinfobtn_Internalname ;
   private String cellQty_cell_Class ;
   private String cellQty_cell_Internalname ;
   private String scmdbuf ;
   private String sStyleString ;
   private String tblTablemergedddc_cartinfobtn_Internalname ;
   private String Ddc_cartinfobtn_Caption ;
   private String edtavQty_Jsonclick ;
   private String tblUnnamedtable1_Internalname ;
   private String edtavSearch_Jsonclick ;
   private String lblActionsearch_Jsonclick ;
   private String sDynURL ;
   private java.util.Date AV34PickerDummyVariable ;
   private boolean A203WWPNotificationIsRead ;
   private boolean Ddc_cartinfobtn_Visible ;
   private boolean Ucmenu_Moreoptionenabled ;
   private boolean Ucmessage_Stoponerror ;
   private boolean Wwputilities_Enablefixobjectfitcover ;
   private boolean Wwputilities_Empowertabs ;
   private boolean Wwputilities_Enableupdaterowselectionstatus ;
   private boolean Wwputilities_Enableconvertcombotobootstrapselect ;
   private boolean Wwputilities_Allowcolumnresizing ;
   private boolean Wwputilities_Allowcolumnreordering ;
   private boolean Wwputilities_Allowcolumndragging ;
   private boolean Wwputilities_Allowcolumnsrestore ;
   private boolean Wwputilities_Pagbarincludegoto ;
   private boolean Popover_search_Keepopened ;
   private boolean Popover_search_Reloadonkeychange ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV36RolIdBOO ;
   private boolean AV6isOk ;
   private String AV17SearchAux ;
   private String AV21Search ;
   private String AV26UserName ;
   private String AV27Language ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Wwpaux_wc ;
   private com.genexus.internet.HttpRequest AV31Httprequest ;
   private com.genexus.webpanels.WebSession AV28WebSession ;
   private com.genexus.webpanels.GXUserControl ucDdo_languagesicons ;
   private com.genexus.webpanels.GXUserControl ucDdc_notificationswc ;
   private com.genexus.webpanels.GXUserControl ucUcmenu ;
   private com.genexus.webpanels.GXUserControl ucUcmessage ;
   private com.genexus.webpanels.GXUserControl ucUctooltip ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.webpanels.GXUserControl ucWwpdatepicker ;
   private com.genexus.webpanels.GXUserControl ucPopover_search ;
   private com.genexus.webpanels.GXUserControl ucDdc_cartinfobtn ;
   private com.genexuscore.genexus.server.SdtNotificationInfo AV13NotificationInfo ;
   private com.genexus.webpanels.GXDataAreaControl Contentholder ;
   private IDataStoreProvider pr_default ;
   private short[] H00092_AV16NotificationsCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV5GAMErrorCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError6[] ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> AV8Cart ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXt_objcol_SdtDVelop_ECommerceCart_Item7 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> GXv_objcol_SdtDVelop_ECommerceCart_Item8[] ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV29LanguagesIconsData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV9CartData ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> AV25DVelop_Menu ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item1 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item2[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV7GAMUser ;
   private com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item AV11CartItem ;
   private com.mujermorena.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV30LanguagesIconsDataItem ;
   private com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification AV14WWP_WebNotification ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended AV15WWP_UserExtended ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings AV18WWP_DesignSystemSettings ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings GXt_SdtWWP_DesignSystemSettings4 ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings GXv_SdtWWP_DesignSystemSettings5[] ;
}

final  class workwithplusmasterpage__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00092", "SELECT COUNT(*) FROM [WWP_Notification] WHERE ([WWPUserExtendedId] = ?) AND (Not [WWPNotificationIsRead] = 1) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               return;
      }
   }

}

