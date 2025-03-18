package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_userextended_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Extended User from GAMUser", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_userextended_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_userextended_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_userextended_impl.class ));
   }

   public wwp_userextended_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkWWPUserExtendedSMSNotif = UIFactory.getCheckbox(this);
      chkWWPUserExtendedMobileNotif = UIFactory.getCheckbox(this);
      chkWWPUserExtendedDesktopNotif = UIFactory.getCheckbox(this);
      chkWWPUserExtendedDeleted = UIFactory.getCheckbox(this);
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      A142WWPUserExtendedSMSNotif = GXutil.strtobool( GXutil.booltostr( A142WWPUserExtendedSMSNotif)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
      A143WWPUserExtendedMobileNotif = GXutil.strtobool( GXutil.booltostr( A143WWPUserExtendedMobileNotif)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
      A144WWPUserExtendedDesktopNotif = GXutil.strtobool( GXutil.booltostr( A144WWPUserExtendedDesktopNotif)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
      A147WWPUserExtendedDeleted = GXutil.strtobool( GXutil.booltostr( A147WWPUserExtendedDeleted)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.mujermorena.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "WWAdvancedContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "TableTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Extended User from GAMUser", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
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
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8 col-sm-offset-2", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 ToolbarCellClass", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCellAdvanced", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedId_Internalname, GXutil.rtrim( A32WWPUserExtendedId), GXutil.rtrim( localUtil.format( A32WWPUserExtendedId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedId_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_GAMGUID", "left", true, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgWWPUserExtendedPhoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Photo", ""), "col-sm-3 ImageAttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A140WWPUserExtendedPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0)&&(GXutil.strcmp("", A40000WWPUserExtendedPhoto_GXI)==0))||!(GXutil.strcmp("", A140WWPUserExtendedPhoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.getResourceRelative(A140WWPUserExtendedPhoto)) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgWWPUserExtendedPhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgWWPUserExtendedPhoto_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "", "", "", 0, A140WWPUserExtendedPhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "URL", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.getResourceRelative(A140WWPUserExtendedPhoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "IsBlob", GXutil.booltostr( A140WWPUserExtendedPhoto_IsBlob), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedName_Internalname, httpContext.getMessage( "Extended Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedName_Internalname, A146WWPUserExtendedName, GXutil.rtrim( localUtil.format( A146WWPUserExtendedName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedFullName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedFullName_Internalname, httpContext.getMessage( "Full Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedFullName_Internalname, A138WWPUserExtendedFullName, GXutil.rtrim( localUtil.format( A138WWPUserExtendedFullName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedFullName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedPhone_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedPhone_Internalname, httpContext.getMessage( "Phone", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      if ( httpContext.isSmartDevice( ) )
      {
         gxphoneLink = "tel:" + GXutil.rtrim( A145WWPUserExtendedPhone) ;
      }
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedPhone_Internalname, GXutil.rtrim( A145WWPUserExtendedPhone), GXutil.rtrim( localUtil.format( A145WWPUserExtendedPhone, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtWWPUserExtendedPhone_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedPhone_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedEmail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedEmail_Internalname, httpContext.getMessage( "Email", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedEmail_Internalname, A139WWPUserExtendedEmail, GXutil.rtrim( localUtil.format( A139WWPUserExtendedEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A139WWPUserExtendedEmail, "", "", "", edtWWPUserExtendedEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedEmail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedEmaiNotif_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedEmaiNotif_Internalname, httpContext.getMessage( "Email Notifications", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedEmaiNotif_Internalname, GXutil.booltostr( A141WWPUserExtendedEmaiNotif), GXutil.booltostr( A141WWPUserExtendedEmaiNotif), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedEmaiNotif_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedEmaiNotif_Enabled, 0, "text", "", 100, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPUserExtendedSMSNotif.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPUserExtendedSMSNotif.getInternalname(), httpContext.getMessage( "SMS Notifications", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPUserExtendedSMSNotif.getInternalname(), GXutil.booltostr( A142WWPUserExtendedSMSNotif), "", httpContext.getMessage( "SMS Notifications", ""), 1, chkWWPUserExtendedSMSNotif.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(69, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,69);\"");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPUserExtendedMobileNotif.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPUserExtendedMobileNotif.getInternalname(), httpContext.getMessage( "Mobile Notifications", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPUserExtendedMobileNotif.getInternalname(), GXutil.booltostr( A143WWPUserExtendedMobileNotif), "", httpContext.getMessage( "Mobile Notifications", ""), 1, chkWWPUserExtendedMobileNotif.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(74, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,74);\"");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPUserExtendedDesktopNotif.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPUserExtendedDesktopNotif.getInternalname(), httpContext.getMessage( "Destkop Notifications", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPUserExtendedDesktopNotif.getInternalname(), GXutil.booltostr( A144WWPUserExtendedDesktopNotif), "", httpContext.getMessage( "Destkop Notifications", ""), 1, chkWWPUserExtendedDesktopNotif.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(79, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,79);\"");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkWWPUserExtendedDeleted.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, chkWWPUserExtendedDeleted.getInternalname(), httpContext.getMessage( "Extended Deleted", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_checkbox_ctrl( httpContext, chkWWPUserExtendedDeleted.getInternalname(), GXutil.booltostr( A147WWPUserExtendedDeleted), "", httpContext.getMessage( "Extended Deleted", ""), 1, chkWWPUserExtendedDeleted.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(84, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,84);\"");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPUserExtendedDeletedIn_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPUserExtendedDeletedIn_Internalname, httpContext.getMessage( "Deleted In", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtWWPUserExtendedDeletedIn_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPUserExtendedDeletedIn_Internalname, localUtil.ttoc( A148WWPUserExtendedDeletedIn, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "), localUtil.format( A148WWPUserExtendedDeletedIn, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',5,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,89);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPUserExtendedDeletedIn_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPUserExtendedDeletedIn_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtWWPUserExtendedDeletedIn_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtWWPUserExtendedDeletedIn_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      httpContext.writeTextNL( "</div>") ;
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WWP_UserExtended.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z32WWPUserExtendedId = httpContext.cgiGet( "Z32WWPUserExtendedId") ;
         Z146WWPUserExtendedName = httpContext.cgiGet( "Z146WWPUserExtendedName") ;
         Z138WWPUserExtendedFullName = httpContext.cgiGet( "Z138WWPUserExtendedFullName") ;
         Z145WWPUserExtendedPhone = httpContext.cgiGet( "Z145WWPUserExtendedPhone") ;
         Z139WWPUserExtendedEmail = httpContext.cgiGet( "Z139WWPUserExtendedEmail") ;
         Z141WWPUserExtendedEmaiNotif = GXutil.strtobool( httpContext.cgiGet( "Z141WWPUserExtendedEmaiNotif")) ;
         Z142WWPUserExtendedSMSNotif = GXutil.strtobool( httpContext.cgiGet( "Z142WWPUserExtendedSMSNotif")) ;
         Z143WWPUserExtendedMobileNotif = GXutil.strtobool( httpContext.cgiGet( "Z143WWPUserExtendedMobileNotif")) ;
         Z144WWPUserExtendedDesktopNotif = GXutil.strtobool( httpContext.cgiGet( "Z144WWPUserExtendedDesktopNotif")) ;
         Z147WWPUserExtendedDeleted = GXutil.strtobool( httpContext.cgiGet( "Z147WWPUserExtendedDeleted")) ;
         Z148WWPUserExtendedDeletedIn = localUtil.ctot( httpContext.cgiGet( "Z148WWPUserExtendedDeletedIn"), 0) ;
         n148WWPUserExtendedDeletedIn = (GXutil.dateCompare(GXutil.nullDate(), A148WWPUserExtendedDeletedIn) ? true : false) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A40000WWPUserExtendedPhoto_GXI = httpContext.cgiGet( "WWPUSEREXTENDEDPHOTO_GXI") ;
         /* Read variables values. */
         A32WWPUserExtendedId = httpContext.cgiGet( edtWWPUserExtendedId_Internalname) ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         A140WWPUserExtendedPhoto = httpContext.cgiGet( imgWWPUserExtendedPhoto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A140WWPUserExtendedPhoto", A140WWPUserExtendedPhoto);
         A146WWPUserExtendedName = httpContext.cgiGet( edtWWPUserExtendedName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A146WWPUserExtendedName", A146WWPUserExtendedName);
         A138WWPUserExtendedFullName = httpContext.cgiGet( edtWWPUserExtendedFullName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A145WWPUserExtendedPhone = httpContext.cgiGet( edtWWPUserExtendedPhone_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A145WWPUserExtendedPhone", A145WWPUserExtendedPhone);
         A139WWPUserExtendedEmail = httpContext.cgiGet( edtWWPUserExtendedEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A139WWPUserExtendedEmail", A139WWPUserExtendedEmail);
         A141WWPUserExtendedEmaiNotif = GXutil.strtobool( httpContext.cgiGet( edtWWPUserExtendedEmaiNotif_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A141WWPUserExtendedEmaiNotif", A141WWPUserExtendedEmaiNotif);
         A142WWPUserExtendedSMSNotif = GXutil.strtobool( httpContext.cgiGet( chkWWPUserExtendedSMSNotif.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
         A143WWPUserExtendedMobileNotif = GXutil.strtobool( httpContext.cgiGet( chkWWPUserExtendedMobileNotif.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
         A144WWPUserExtendedDesktopNotif = GXutil.strtobool( httpContext.cgiGet( chkWWPUserExtendedDesktopNotif.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
         A147WWPUserExtendedDeleted = GXutil.strtobool( httpContext.cgiGet( chkWWPUserExtendedDeleted.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtWWPUserExtendedDeletedIn_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))), (byte)(((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "WWPUSEREXTENDEDDELETEDIN");
            AnyError = (short)(1) ;
            GX_FocusControl = edtWWPUserExtendedDeletedIn_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
            n148WWPUserExtendedDeletedIn = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A148WWPUserExtendedDeletedIn", localUtil.ttoc( A148WWPUserExtendedDeletedIn, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         else
         {
            A148WWPUserExtendedDeletedIn = localUtil.ctot( httpContext.cgiGet( edtWWPUserExtendedDeletedIn_Internalname)) ;
            n148WWPUserExtendedDeletedIn = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A148WWPUserExtendedDeletedIn", localUtil.ttoc( A148WWPUserExtendedDeletedIn, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         }
         n148WWPUserExtendedDeletedIn = (GXutil.dateCompare(GXutil.nullDate(), A148WWPUserExtendedDeletedIn) ? true : false) ;
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXv_char1[0] = A140WWPUserExtendedPhoto ;
         GXv_char2[0] = A40000WWPUserExtendedPhoto_GXI ;
         httpContext.getMultimediaValue(imgWWPUserExtendedPhoto_Internalname, GXv_char1, GXv_char2);
         wwp_userextended_impl.this.A140WWPUserExtendedPhoto = GXv_char1[0] ;
         wwp_userextended_impl.this.A40000WWPUserExtendedPhoto_GXI = GXv_char2[0] ;
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A32WWPUserExtendedId = httpContext.GetPar( "WWPUserExtendedId") ;
            n32WWPUserExtendedId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
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

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0S30( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes0S30( ) ;
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void resetCaption0S0( )
   {
   }

   public void zm0S30( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z146WWPUserExtendedName = T000S3_A146WWPUserExtendedName[0] ;
            Z138WWPUserExtendedFullName = T000S3_A138WWPUserExtendedFullName[0] ;
            Z145WWPUserExtendedPhone = T000S3_A145WWPUserExtendedPhone[0] ;
            Z139WWPUserExtendedEmail = T000S3_A139WWPUserExtendedEmail[0] ;
            Z141WWPUserExtendedEmaiNotif = T000S3_A141WWPUserExtendedEmaiNotif[0] ;
            Z142WWPUserExtendedSMSNotif = T000S3_A142WWPUserExtendedSMSNotif[0] ;
            Z143WWPUserExtendedMobileNotif = T000S3_A143WWPUserExtendedMobileNotif[0] ;
            Z144WWPUserExtendedDesktopNotif = T000S3_A144WWPUserExtendedDesktopNotif[0] ;
            Z147WWPUserExtendedDeleted = T000S3_A147WWPUserExtendedDeleted[0] ;
            Z148WWPUserExtendedDeletedIn = T000S3_A148WWPUserExtendedDeletedIn[0] ;
         }
         else
         {
            Z146WWPUserExtendedName = A146WWPUserExtendedName ;
            Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
            Z145WWPUserExtendedPhone = A145WWPUserExtendedPhone ;
            Z139WWPUserExtendedEmail = A139WWPUserExtendedEmail ;
            Z141WWPUserExtendedEmaiNotif = A141WWPUserExtendedEmaiNotif ;
            Z142WWPUserExtendedSMSNotif = A142WWPUserExtendedSMSNotif ;
            Z143WWPUserExtendedMobileNotif = A143WWPUserExtendedMobileNotif ;
            Z144WWPUserExtendedDesktopNotif = A144WWPUserExtendedDesktopNotif ;
            Z147WWPUserExtendedDeleted = A147WWPUserExtendedDeleted ;
            Z148WWPUserExtendedDeletedIn = A148WWPUserExtendedDeletedIn ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         Z140WWPUserExtendedPhoto = A140WWPUserExtendedPhoto ;
         Z40000WWPUserExtendedPhoto_GXI = A40000WWPUserExtendedPhoto_GXI ;
         Z146WWPUserExtendedName = A146WWPUserExtendedName ;
         Z138WWPUserExtendedFullName = A138WWPUserExtendedFullName ;
         Z145WWPUserExtendedPhone = A145WWPUserExtendedPhone ;
         Z139WWPUserExtendedEmail = A139WWPUserExtendedEmail ;
         Z141WWPUserExtendedEmaiNotif = A141WWPUserExtendedEmaiNotif ;
         Z142WWPUserExtendedSMSNotif = A142WWPUserExtendedSMSNotif ;
         Z143WWPUserExtendedMobileNotif = A143WWPUserExtendedMobileNotif ;
         Z144WWPUserExtendedDesktopNotif = A144WWPUserExtendedDesktopNotif ;
         Z147WWPUserExtendedDeleted = A147WWPUserExtendedDeleted ;
         Z148WWPUserExtendedDeletedIn = A148WWPUserExtendedDeletedIn ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load0S30( )
   {
      /* Using cursor T000S4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A140WWPUserExtendedPhoto = T000S4_A140WWPUserExtendedPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140WWPUserExtendedPhoto", A140WWPUserExtendedPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A140WWPUserExtendedPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A140WWPUserExtendedPhoto), true);
         A40000WWPUserExtendedPhoto_GXI = T000S4_A40000WWPUserExtendedPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A140WWPUserExtendedPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A140WWPUserExtendedPhoto), true);
         A146WWPUserExtendedName = T000S4_A146WWPUserExtendedName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146WWPUserExtendedName", A146WWPUserExtendedName);
         A138WWPUserExtendedFullName = T000S4_A138WWPUserExtendedFullName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A145WWPUserExtendedPhone = T000S4_A145WWPUserExtendedPhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A145WWPUserExtendedPhone", A145WWPUserExtendedPhone);
         A139WWPUserExtendedEmail = T000S4_A139WWPUserExtendedEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A139WWPUserExtendedEmail", A139WWPUserExtendedEmail);
         A141WWPUserExtendedEmaiNotif = T000S4_A141WWPUserExtendedEmaiNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A141WWPUserExtendedEmaiNotif", A141WWPUserExtendedEmaiNotif);
         A142WWPUserExtendedSMSNotif = T000S4_A142WWPUserExtendedSMSNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
         A143WWPUserExtendedMobileNotif = T000S4_A143WWPUserExtendedMobileNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
         A144WWPUserExtendedDesktopNotif = T000S4_A144WWPUserExtendedDesktopNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
         A147WWPUserExtendedDeleted = T000S4_A147WWPUserExtendedDeleted[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
         A148WWPUserExtendedDeletedIn = T000S4_A148WWPUserExtendedDeletedIn[0] ;
         n148WWPUserExtendedDeletedIn = T000S4_n148WWPUserExtendedDeletedIn[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148WWPUserExtendedDeletedIn", localUtil.ttoc( A148WWPUserExtendedDeletedIn, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         zm0S30( -3) ;
      }
      pr_default.close(2);
      onLoadActions0S30( ) ;
   }

   public void onLoadActions0S30( )
   {
   }

   public void checkExtendedTable0S30( )
   {
      nIsDirty_30 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( GxRegex.IsMatch(A139WWPUserExtendedEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "User Email", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPUSEREXTENDEDEMAIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPUserExtendedEmail_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A148WWPUserExtendedDeletedIn) || (( A148WWPUserExtendedDeletedIn.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A148WWPUserExtendedDeletedIn, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "WWPUser Extended Deleted In", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "WWPUSEREXTENDEDDELETEDIN");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPUserExtendedDeletedIn_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0S30( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0S30( )
   {
      /* Using cursor T000S5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound30 = (short)(1) ;
      }
      else
      {
         RcdFound30 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000S3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0S30( 3) ;
         RcdFound30 = (short)(1) ;
         A32WWPUserExtendedId = T000S3_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000S3_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         A140WWPUserExtendedPhoto = T000S3_A140WWPUserExtendedPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140WWPUserExtendedPhoto", A140WWPUserExtendedPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A140WWPUserExtendedPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A140WWPUserExtendedPhoto), true);
         A40000WWPUserExtendedPhoto_GXI = T000S3_A40000WWPUserExtendedPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A140WWPUserExtendedPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A140WWPUserExtendedPhoto), true);
         A146WWPUserExtendedName = T000S3_A146WWPUserExtendedName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146WWPUserExtendedName", A146WWPUserExtendedName);
         A138WWPUserExtendedFullName = T000S3_A138WWPUserExtendedFullName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
         A145WWPUserExtendedPhone = T000S3_A145WWPUserExtendedPhone[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A145WWPUserExtendedPhone", A145WWPUserExtendedPhone);
         A139WWPUserExtendedEmail = T000S3_A139WWPUserExtendedEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A139WWPUserExtendedEmail", A139WWPUserExtendedEmail);
         A141WWPUserExtendedEmaiNotif = T000S3_A141WWPUserExtendedEmaiNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A141WWPUserExtendedEmaiNotif", A141WWPUserExtendedEmaiNotif);
         A142WWPUserExtendedSMSNotif = T000S3_A142WWPUserExtendedSMSNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
         A143WWPUserExtendedMobileNotif = T000S3_A143WWPUserExtendedMobileNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
         A144WWPUserExtendedDesktopNotif = T000S3_A144WWPUserExtendedDesktopNotif[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
         A147WWPUserExtendedDeleted = T000S3_A147WWPUserExtendedDeleted[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
         A148WWPUserExtendedDeletedIn = T000S3_A148WWPUserExtendedDeletedIn[0] ;
         n148WWPUserExtendedDeletedIn = T000S3_n148WWPUserExtendedDeletedIn[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148WWPUserExtendedDeletedIn", localUtil.ttoc( A148WWPUserExtendedDeletedIn, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         Z32WWPUserExtendedId = A32WWPUserExtendedId ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0S30( ) ;
         if ( AnyError == 1 )
         {
            RcdFound30 = (short)(0) ;
            initializeNonKey0S30( ) ;
         }
         Gx_mode = sMode30 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound30 = (short)(0) ;
         initializeNonKey0S30( ) ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode30 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0S30( ) ;
      if ( RcdFound30 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound30 = (short)(0) ;
      /* Using cursor T000S6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T000S6_A32WWPUserExtendedId[0], A32WWPUserExtendedId) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T000S6_A32WWPUserExtendedId[0], A32WWPUserExtendedId) > 0 ) ) )
         {
            A32WWPUserExtendedId = T000S6_A32WWPUserExtendedId[0] ;
            n32WWPUserExtendedId = T000S6_n32WWPUserExtendedId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
            RcdFound30 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound30 = (short)(0) ;
      /* Using cursor T000S7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T000S7_A32WWPUserExtendedId[0], A32WWPUserExtendedId) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T000S7_A32WWPUserExtendedId[0], A32WWPUserExtendedId) < 0 ) ) )
         {
            A32WWPUserExtendedId = T000S7_A32WWPUserExtendedId[0] ;
            n32WWPUserExtendedId = T000S7_n32WWPUserExtendedId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
            RcdFound30 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0S30( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0S30( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound30 == 1 )
         {
            if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
            {
               A32WWPUserExtendedId = Z32WWPUserExtendedId ;
               n32WWPUserExtendedId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPUSEREXTENDEDID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPUserExtendedId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPUserExtendedId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0S30( ) ;
               GX_FocusControl = edtWWPUserExtendedId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPUserExtendedId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0S30( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPUSEREXTENDEDID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPUserExtendedId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPUserExtendedId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0S30( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void btn_delete( )
   {
      if ( GXutil.strcmp(A32WWPUserExtendedId, Z32WWPUserExtendedId) != 0 )
      {
         A32WWPUserExtendedId = Z32WWPUserExtendedId ;
         n32WWPUserExtendedId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPUSEREXTENDEDID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPUSEREXTENDEDID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPUserExtendedId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = imgWWPUserExtendedPhoto_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0S30( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = imgWWPUserExtendedPhoto_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0S30( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = imgWWPUserExtendedPhoto_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = imgWWPUserExtendedPhoto_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0S30( ) ;
      if ( RcdFound30 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound30 != 0 )
         {
            scanNext0S30( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = imgWWPUserExtendedPhoto_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0S30( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0S30( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000S2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_UserExtended"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z146WWPUserExtendedName, T000S2_A146WWPUserExtendedName[0]) != 0 ) || ( GXutil.strcmp(Z138WWPUserExtendedFullName, T000S2_A138WWPUserExtendedFullName[0]) != 0 ) || ( GXutil.strcmp(Z145WWPUserExtendedPhone, T000S2_A145WWPUserExtendedPhone[0]) != 0 ) || ( GXutil.strcmp(Z139WWPUserExtendedEmail, T000S2_A139WWPUserExtendedEmail[0]) != 0 ) || ( Z141WWPUserExtendedEmaiNotif != T000S2_A141WWPUserExtendedEmaiNotif[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z142WWPUserExtendedSMSNotif != T000S2_A142WWPUserExtendedSMSNotif[0] ) || ( Z143WWPUserExtendedMobileNotif != T000S2_A143WWPUserExtendedMobileNotif[0] ) || ( Z144WWPUserExtendedDesktopNotif != T000S2_A144WWPUserExtendedDesktopNotif[0] ) || ( Z147WWPUserExtendedDeleted != T000S2_A147WWPUserExtendedDeleted[0] ) || !( GXutil.dateCompare(Z148WWPUserExtendedDeletedIn, T000S2_A148WWPUserExtendedDeletedIn[0]) ) )
         {
            if ( GXutil.strcmp(Z146WWPUserExtendedName, T000S2_A146WWPUserExtendedName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedName");
               GXutil.writeLogRaw("Old: ",Z146WWPUserExtendedName);
               GXutil.writeLogRaw("Current: ",T000S2_A146WWPUserExtendedName[0]);
            }
            if ( GXutil.strcmp(Z138WWPUserExtendedFullName, T000S2_A138WWPUserExtendedFullName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedFullName");
               GXutil.writeLogRaw("Old: ",Z138WWPUserExtendedFullName);
               GXutil.writeLogRaw("Current: ",T000S2_A138WWPUserExtendedFullName[0]);
            }
            if ( GXutil.strcmp(Z145WWPUserExtendedPhone, T000S2_A145WWPUserExtendedPhone[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedPhone");
               GXutil.writeLogRaw("Old: ",Z145WWPUserExtendedPhone);
               GXutil.writeLogRaw("Current: ",T000S2_A145WWPUserExtendedPhone[0]);
            }
            if ( GXutil.strcmp(Z139WWPUserExtendedEmail, T000S2_A139WWPUserExtendedEmail[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedEmail");
               GXutil.writeLogRaw("Old: ",Z139WWPUserExtendedEmail);
               GXutil.writeLogRaw("Current: ",T000S2_A139WWPUserExtendedEmail[0]);
            }
            if ( Z141WWPUserExtendedEmaiNotif != T000S2_A141WWPUserExtendedEmaiNotif[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedEmaiNotif");
               GXutil.writeLogRaw("Old: ",Z141WWPUserExtendedEmaiNotif);
               GXutil.writeLogRaw("Current: ",T000S2_A141WWPUserExtendedEmaiNotif[0]);
            }
            if ( Z142WWPUserExtendedSMSNotif != T000S2_A142WWPUserExtendedSMSNotif[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedSMSNotif");
               GXutil.writeLogRaw("Old: ",Z142WWPUserExtendedSMSNotif);
               GXutil.writeLogRaw("Current: ",T000S2_A142WWPUserExtendedSMSNotif[0]);
            }
            if ( Z143WWPUserExtendedMobileNotif != T000S2_A143WWPUserExtendedMobileNotif[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedMobileNotif");
               GXutil.writeLogRaw("Old: ",Z143WWPUserExtendedMobileNotif);
               GXutil.writeLogRaw("Current: ",T000S2_A143WWPUserExtendedMobileNotif[0]);
            }
            if ( Z144WWPUserExtendedDesktopNotif != T000S2_A144WWPUserExtendedDesktopNotif[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedDesktopNotif");
               GXutil.writeLogRaw("Old: ",Z144WWPUserExtendedDesktopNotif);
               GXutil.writeLogRaw("Current: ",T000S2_A144WWPUserExtendedDesktopNotif[0]);
            }
            if ( Z147WWPUserExtendedDeleted != T000S2_A147WWPUserExtendedDeleted[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedDeleted");
               GXutil.writeLogRaw("Old: ",Z147WWPUserExtendedDeleted);
               GXutil.writeLogRaw("Current: ",T000S2_A147WWPUserExtendedDeleted[0]);
            }
            if ( !( GXutil.dateCompare(Z148WWPUserExtendedDeletedIn, T000S2_A148WWPUserExtendedDeletedIn[0]) ) )
            {
               GXutil.writeLogln("wwpbaseobjects.wwp_userextended:[seudo value changed for attri]"+"WWPUserExtendedDeletedIn");
               GXutil.writeLogRaw("Old: ",Z148WWPUserExtendedDeletedIn);
               GXutil.writeLogRaw("Current: ",T000S2_A148WWPUserExtendedDeletedIn[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_UserExtended"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0S30( )
   {
      if ( ! IsAuthorized("wwpuserextended_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0S30( 0) ;
         checkOptimisticConcurrency0S30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S30( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0S30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000S8 */
                  pr_default.execute(6, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId, A140WWPUserExtendedPhoto, A40000WWPUserExtendedPhoto_GXI, A146WWPUserExtendedName, A138WWPUserExtendedFullName, A145WWPUserExtendedPhone, A139WWPUserExtendedEmail, Boolean.valueOf(A141WWPUserExtendedEmaiNotif), Boolean.valueOf(A142WWPUserExtendedSMSNotif), Boolean.valueOf(A143WWPUserExtendedMobileNotif), Boolean.valueOf(A144WWPUserExtendedDesktopNotif), Boolean.valueOf(A147WWPUserExtendedDeleted), Boolean.valueOf(n148WWPUserExtendedDeletedIn), A148WWPUserExtendedDeletedIn});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
                  if ( (pr_default.getStatus(6) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0S0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0S30( ) ;
         }
         endLevel0S30( ) ;
      }
      closeExtendedTableCursors0S30( ) ;
   }

   public void update0S30( )
   {
      if ( ! IsAuthorized("wwpuserextended_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S30( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0S30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000S9 */
                  pr_default.execute(7, new Object[] {A146WWPUserExtendedName, A138WWPUserExtendedFullName, A145WWPUserExtendedPhone, A139WWPUserExtendedEmail, Boolean.valueOf(A141WWPUserExtendedEmaiNotif), Boolean.valueOf(A142WWPUserExtendedSMSNotif), Boolean.valueOf(A143WWPUserExtendedMobileNotif), Boolean.valueOf(A144WWPUserExtendedDesktopNotif), Boolean.valueOf(A147WWPUserExtendedDeleted), Boolean.valueOf(n148WWPUserExtendedDeletedIn), A148WWPUserExtendedDeletedIn, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_UserExtended"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0S30( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0S0( ) ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0S30( ) ;
      }
      closeExtendedTableCursors0S30( ) ;
   }

   public void deferredUpdate0S30( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000S10 */
         pr_default.execute(8, new Object[] {A140WWPUserExtendedPhoto, A40000WWPUserExtendedPhoto_GXI, Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
      }
   }

   public void delete( )
   {
      if ( ! IsAuthorized("wwpuserextended_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0S30( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0S30( ) ;
         afterConfirm0S30( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0S30( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000S11 */
               pr_default.execute(9, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_UserExtended");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound30 == 0 )
                     {
                        initAll0S30( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption0S0( ) ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode30 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0S30( ) ;
      Gx_mode = sMode30 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0S30( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T000S12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Notification", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
         /* Using cursor T000S13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_WebClient", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T000S14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n32WWPUserExtendedId), A32WWPUserExtendedId});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "WWP_Subscription", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel0S30( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0S30( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.wwp_userextended");
         if ( AnyError == 0 )
         {
            confirmValues0S0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.wwp_userextended");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0S30( )
   {
      /* Using cursor T000S15 */
      pr_default.execute(13);
      RcdFound30 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32WWPUserExtendedId = T000S15_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000S15_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0S30( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound30 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32WWPUserExtendedId = T000S15_A32WWPUserExtendedId[0] ;
         n32WWPUserExtendedId = T000S15_n32WWPUserExtendedId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      }
   }

   public void scanEnd0S30( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0S30( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0S30( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0S30( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0S30( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0S30( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0S30( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0S30( )
   {
      edtWWPUserExtendedId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedId_Enabled), 5, 0), true);
      imgWWPUserExtendedPhoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgWWPUserExtendedPhoto_Enabled), 5, 0), true);
      edtWWPUserExtendedName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedName_Enabled), 5, 0), true);
      edtWWPUserExtendedFullName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedFullName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedFullName_Enabled), 5, 0), true);
      edtWWPUserExtendedPhone_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedPhone_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedPhone_Enabled), 5, 0), true);
      edtWWPUserExtendedEmail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedEmail_Enabled), 5, 0), true);
      edtWWPUserExtendedEmaiNotif_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedEmaiNotif_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedEmaiNotif_Enabled), 5, 0), true);
      chkWWPUserExtendedSMSNotif.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedSMSNotif.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPUserExtendedSMSNotif.getEnabled(), 5, 0), true);
      chkWWPUserExtendedMobileNotif.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedMobileNotif.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPUserExtendedMobileNotif.getEnabled(), 5, 0), true);
      chkWWPUserExtendedDesktopNotif.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedDesktopNotif.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPUserExtendedDesktopNotif.getEnabled(), 5, 0), true);
      chkWWPUserExtendedDeleted.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedDeleted.getInternalname(), "Enabled", GXutil.ltrimstr( chkWWPUserExtendedDeleted.getEnabled(), 5, 0), true);
      edtWWPUserExtendedDeletedIn_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPUserExtendedDeletedIn_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPUserExtendedDeletedIn_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0S30( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0S0( )
   {
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
      MasterPageObj.master_styles();
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
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.wwp_userextended", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z146WWPUserExtendedName", Z146WWPUserExtendedName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z138WWPUserExtendedFullName", Z138WWPUserExtendedFullName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z145WWPUserExtendedPhone", GXutil.rtrim( Z145WWPUserExtendedPhone));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z139WWPUserExtendedEmail", Z139WWPUserExtendedEmail);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z141WWPUserExtendedEmaiNotif", Z141WWPUserExtendedEmaiNotif);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z142WWPUserExtendedSMSNotif", Z142WWPUserExtendedSMSNotif);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z143WWPUserExtendedMobileNotif", Z143WWPUserExtendedMobileNotif);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z144WWPUserExtendedDesktopNotif", Z144WWPUserExtendedDesktopNotif);
      com.mujermorena.GxWebStd.gx_boolean_hidden_field( httpContext, "Z147WWPUserExtendedDeleted", Z147WWPUserExtendedDeleted);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z148WWPUserExtendedDeletedIn", localUtil.ttoc( Z148WWPUserExtendedDeletedIn, 10, 8, 0, 0, "/", ":", " "));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "WWPUSEREXTENDEDPHOTO_GXI", A40000WWPUserExtendedPhoto_GXI);
      GXCCtlgxBlob = "WWPUSEREXTENDEDPHOTO" + "_gxBlob" ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A140WWPUserExtendedPhoto);
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.mujermorena.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
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
      return formatLink("com.mujermorena.wwpbaseobjects.wwp_userextended", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WWP_UserExtended" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Extended User from GAMUser", "") ;
   }

   public void initializeNonKey0S30( )
   {
      A140WWPUserExtendedPhoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A140WWPUserExtendedPhoto", A140WWPUserExtendedPhoto);
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A140WWPUserExtendedPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A140WWPUserExtendedPhoto), true);
      A40000WWPUserExtendedPhoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A140WWPUserExtendedPhoto)==0) ? A40000WWPUserExtendedPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A140WWPUserExtendedPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgWWPUserExtendedPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A140WWPUserExtendedPhoto), true);
      A146WWPUserExtendedName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A146WWPUserExtendedName", A146WWPUserExtendedName);
      A138WWPUserExtendedFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      A145WWPUserExtendedPhone = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A145WWPUserExtendedPhone", A145WWPUserExtendedPhone);
      A139WWPUserExtendedEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A139WWPUserExtendedEmail", A139WWPUserExtendedEmail);
      A141WWPUserExtendedEmaiNotif = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A141WWPUserExtendedEmaiNotif", A141WWPUserExtendedEmaiNotif);
      A142WWPUserExtendedSMSNotif = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
      A143WWPUserExtendedMobileNotif = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
      A144WWPUserExtendedDesktopNotif = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
      A147WWPUserExtendedDeleted = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
      A148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      n148WWPUserExtendedDeletedIn = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A148WWPUserExtendedDeletedIn", localUtil.ttoc( A148WWPUserExtendedDeletedIn, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      n148WWPUserExtendedDeletedIn = (GXutil.dateCompare(GXutil.nullDate(), A148WWPUserExtendedDeletedIn) ? true : false) ;
      Z146WWPUserExtendedName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      Z145WWPUserExtendedPhone = "" ;
      Z139WWPUserExtendedEmail = "" ;
      Z141WWPUserExtendedEmaiNotif = false ;
      Z142WWPUserExtendedSMSNotif = false ;
      Z143WWPUserExtendedMobileNotif = false ;
      Z144WWPUserExtendedDesktopNotif = false ;
      Z147WWPUserExtendedDeleted = false ;
      Z148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
   }

   public void initAll0S30( )
   {
      A32WWPUserExtendedId = "" ;
      n32WWPUserExtendedId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A32WWPUserExtendedId", A32WWPUserExtendedId);
      initializeNonKey0S30( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111101321", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/wwp_userextended.js", "?202412111101321", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtWWPUserExtendedId_Internalname = "WWPUSEREXTENDEDID" ;
      imgWWPUserExtendedPhoto_Internalname = "WWPUSEREXTENDEDPHOTO" ;
      edtWWPUserExtendedName_Internalname = "WWPUSEREXTENDEDNAME" ;
      edtWWPUserExtendedFullName_Internalname = "WWPUSEREXTENDEDFULLNAME" ;
      edtWWPUserExtendedPhone_Internalname = "WWPUSEREXTENDEDPHONE" ;
      edtWWPUserExtendedEmail_Internalname = "WWPUSEREXTENDEDEMAIL" ;
      edtWWPUserExtendedEmaiNotif_Internalname = "WWPUSEREXTENDEDEMAINOTIF" ;
      chkWWPUserExtendedSMSNotif.setInternalname( "WWPUSEREXTENDEDSMSNOTIF" );
      chkWWPUserExtendedMobileNotif.setInternalname( "WWPUSEREXTENDEDMOBILENOTIF" );
      chkWWPUserExtendedDesktopNotif.setInternalname( "WWPUSEREXTENDEDDESKTOPNOTIF" );
      chkWWPUserExtendedDeleted.setInternalname( "WWPUSEREXTENDEDDELETED" );
      edtWWPUserExtendedDeletedIn_Internalname = "WWPUSEREXTENDEDDELETEDIN" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Extended User from GAMUser", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtWWPUserExtendedDeletedIn_Jsonclick = "" ;
      edtWWPUserExtendedDeletedIn_Enabled = 1 ;
      chkWWPUserExtendedDeleted.setEnabled( 1 );
      chkWWPUserExtendedDesktopNotif.setEnabled( 1 );
      chkWWPUserExtendedMobileNotif.setEnabled( 1 );
      chkWWPUserExtendedSMSNotif.setEnabled( 1 );
      edtWWPUserExtendedEmaiNotif_Jsonclick = "" ;
      edtWWPUserExtendedEmaiNotif_Enabled = 1 ;
      edtWWPUserExtendedEmail_Jsonclick = "" ;
      edtWWPUserExtendedEmail_Enabled = 1 ;
      edtWWPUserExtendedPhone_Jsonclick = "" ;
      edtWWPUserExtendedPhone_Enabled = 1 ;
      edtWWPUserExtendedFullName_Jsonclick = "" ;
      edtWWPUserExtendedFullName_Enabled = 1 ;
      edtWWPUserExtendedName_Jsonclick = "" ;
      edtWWPUserExtendedName_Enabled = 1 ;
      imgWWPUserExtendedPhoto_Enabled = 1 ;
      edtWWPUserExtendedId_Jsonclick = "" ;
      edtWWPUserExtendedId_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void init_web_controls( )
   {
      chkWWPUserExtendedSMSNotif.setName( "WWPUSEREXTENDEDSMSNOTIF" );
      chkWWPUserExtendedSMSNotif.setWebtags( "" );
      chkWWPUserExtendedSMSNotif.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedSMSNotif.getInternalname(), "TitleCaption", chkWWPUserExtendedSMSNotif.getCaption(), true);
      chkWWPUserExtendedSMSNotif.setCheckedValue( "false" );
      A142WWPUserExtendedSMSNotif = GXutil.strtobool( GXutil.booltostr( A142WWPUserExtendedSMSNotif)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
      chkWWPUserExtendedMobileNotif.setName( "WWPUSEREXTENDEDMOBILENOTIF" );
      chkWWPUserExtendedMobileNotif.setWebtags( "" );
      chkWWPUserExtendedMobileNotif.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedMobileNotif.getInternalname(), "TitleCaption", chkWWPUserExtendedMobileNotif.getCaption(), true);
      chkWWPUserExtendedMobileNotif.setCheckedValue( "false" );
      A143WWPUserExtendedMobileNotif = GXutil.strtobool( GXutil.booltostr( A143WWPUserExtendedMobileNotif)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
      chkWWPUserExtendedDesktopNotif.setName( "WWPUSEREXTENDEDDESKTOPNOTIF" );
      chkWWPUserExtendedDesktopNotif.setWebtags( "" );
      chkWWPUserExtendedDesktopNotif.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedDesktopNotif.getInternalname(), "TitleCaption", chkWWPUserExtendedDesktopNotif.getCaption(), true);
      chkWWPUserExtendedDesktopNotif.setCheckedValue( "false" );
      A144WWPUserExtendedDesktopNotif = GXutil.strtobool( GXutil.booltostr( A144WWPUserExtendedDesktopNotif)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
      chkWWPUserExtendedDeleted.setName( "WWPUSEREXTENDEDDELETED" );
      chkWWPUserExtendedDeleted.setWebtags( "" );
      chkWWPUserExtendedDeleted.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkWWPUserExtendedDeleted.getInternalname(), "TitleCaption", chkWWPUserExtendedDeleted.getCaption(), true);
      chkWWPUserExtendedDeleted.setCheckedValue( "false" );
      A147WWPUserExtendedDeleted = GXutil.strtobool( GXutil.booltostr( A147WWPUserExtendedDeleted)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = imgWWPUserExtendedPhoto_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Wwpuserextendedid( )
   {
      n32WWPUserExtendedId = false ;
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      A142WWPUserExtendedSMSNotif = GXutil.strtobool( GXutil.booltostr( A142WWPUserExtendedSMSNotif)) ;
      A143WWPUserExtendedMobileNotif = GXutil.strtobool( GXutil.booltostr( A143WWPUserExtendedMobileNotif)) ;
      A144WWPUserExtendedDesktopNotif = GXutil.strtobool( GXutil.booltostr( A144WWPUserExtendedDesktopNotif)) ;
      A147WWPUserExtendedDeleted = GXutil.strtobool( GXutil.booltostr( A147WWPUserExtendedDeleted)) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A140WWPUserExtendedPhoto", httpContext.getResourceRelative(A140WWPUserExtendedPhoto));
      GXCCtlgxBlob = "WWPUSEREXTENDEDPHOTO" + "_gxBlob" ;
      httpContext.ajax_rsp_assign_attri("", false, "GXCCtlgxBlob", GXCCtlgxBlob);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, httpContext.getResourceRelative(A140WWPUserExtendedPhoto));
      httpContext.ajax_rsp_assign_attri("", false, "A40000WWPUserExtendedPhoto_GXI", A40000WWPUserExtendedPhoto_GXI);
      httpContext.ajax_rsp_assign_attri("", false, "A146WWPUserExtendedName", A146WWPUserExtendedName);
      httpContext.ajax_rsp_assign_attri("", false, "A138WWPUserExtendedFullName", A138WWPUserExtendedFullName);
      httpContext.ajax_rsp_assign_attri("", false, "A145WWPUserExtendedPhone", GXutil.rtrim( A145WWPUserExtendedPhone));
      httpContext.ajax_rsp_assign_attri("", false, "A139WWPUserExtendedEmail", A139WWPUserExtendedEmail);
      httpContext.ajax_rsp_assign_attri("", false, "A141WWPUserExtendedEmaiNotif", A141WWPUserExtendedEmaiNotif);
      httpContext.ajax_rsp_assign_attri("", false, "A142WWPUserExtendedSMSNotif", A142WWPUserExtendedSMSNotif);
      httpContext.ajax_rsp_assign_attri("", false, "A143WWPUserExtendedMobileNotif", A143WWPUserExtendedMobileNotif);
      httpContext.ajax_rsp_assign_attri("", false, "A144WWPUserExtendedDesktopNotif", A144WWPUserExtendedDesktopNotif);
      httpContext.ajax_rsp_assign_attri("", false, "A147WWPUserExtendedDeleted", A147WWPUserExtendedDeleted);
      httpContext.ajax_rsp_assign_attri("", false, "A148WWPUserExtendedDeletedIn", localUtil.ttoc( A148WWPUserExtendedDeletedIn, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z32WWPUserExtendedId", GXutil.rtrim( Z32WWPUserExtendedId));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z140WWPUserExtendedPhoto", httpContext.getResourceRelative(Z140WWPUserExtendedPhoto));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40000WWPUserExtendedPhoto_GXI", Z40000WWPUserExtendedPhoto_GXI);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z146WWPUserExtendedName", Z146WWPUserExtendedName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z138WWPUserExtendedFullName", Z138WWPUserExtendedFullName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z145WWPUserExtendedPhone", GXutil.rtrim( Z145WWPUserExtendedPhone));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z139WWPUserExtendedEmail", Z139WWPUserExtendedEmail);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z141WWPUserExtendedEmaiNotif", GXutil.booltostr( Z141WWPUserExtendedEmaiNotif));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z142WWPUserExtendedSMSNotif", GXutil.booltostr( Z142WWPUserExtendedSMSNotif));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z143WWPUserExtendedMobileNotif", GXutil.booltostr( Z143WWPUserExtendedMobileNotif));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z144WWPUserExtendedDesktopNotif", GXutil.booltostr( Z144WWPUserExtendedDesktopNotif));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z147WWPUserExtendedDeleted", GXutil.booltostr( Z147WWPUserExtendedDeleted));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z148WWPUserExtendedDeletedIn", localUtil.ttoc( Z148WWPUserExtendedDeletedIn, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]}");
      setEventMetadata("VALID_WWPUSEREXTENDEDID","{handler:'valid_Wwpuserextendedid',iparms:[{av:'A32WWPUserExtendedId',fld:'WWPUSEREXTENDEDID',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]");
      setEventMetadata("VALID_WWPUSEREXTENDEDID",",oparms:[{av:'A140WWPUserExtendedPhoto',fld:'WWPUSEREXTENDEDPHOTO',pic:''},{av:'A40000WWPUserExtendedPhoto_GXI',fld:'WWPUSEREXTENDEDPHOTO_GXI',pic:''},{av:'A146WWPUserExtendedName',fld:'WWPUSEREXTENDEDNAME',pic:''},{av:'A138WWPUserExtendedFullName',fld:'WWPUSEREXTENDEDFULLNAME',pic:''},{av:'A145WWPUserExtendedPhone',fld:'WWPUSEREXTENDEDPHONE',pic:''},{av:'A139WWPUserExtendedEmail',fld:'WWPUSEREXTENDEDEMAIL',pic:''},{av:'A141WWPUserExtendedEmaiNotif',fld:'WWPUSEREXTENDEDEMAINOTIF',pic:''},{av:'A148WWPUserExtendedDeletedIn',fld:'WWPUSEREXTENDEDDELETEDIN',pic:'99/99/99 99:99'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z32WWPUserExtendedId'},{av:'Z140WWPUserExtendedPhoto'},{av:'Z40000WWPUserExtendedPhoto_GXI'},{av:'Z146WWPUserExtendedName'},{av:'Z138WWPUserExtendedFullName'},{av:'Z145WWPUserExtendedPhone'},{av:'Z139WWPUserExtendedEmail'},{av:'Z141WWPUserExtendedEmaiNotif'},{av:'Z142WWPUserExtendedSMSNotif'},{av:'Z143WWPUserExtendedMobileNotif'},{av:'Z144WWPUserExtendedDesktopNotif'},{av:'Z147WWPUserExtendedDeleted'},{av:'Z148WWPUserExtendedDeletedIn'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]}");
      setEventMetadata("VALID_WWPUSEREXTENDEDEMAIL","{handler:'valid_Wwpuserextendedemail',iparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]");
      setEventMetadata("VALID_WWPUSEREXTENDEDEMAIL",",oparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]}");
      setEventMetadata("VALID_WWPUSEREXTENDEDDELETEDIN","{handler:'valid_Wwpuserextendeddeletedin',iparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]");
      setEventMetadata("VALID_WWPUSEREXTENDEDDELETEDIN",",oparms:[{av:'A142WWPUserExtendedSMSNotif',fld:'WWPUSEREXTENDEDSMSNOTIF',pic:''},{av:'A143WWPUserExtendedMobileNotif',fld:'WWPUSEREXTENDEDMOBILENOTIF',pic:''},{av:'A144WWPUserExtendedDesktopNotif',fld:'WWPUSEREXTENDEDDESKTOPNOTIF',pic:''},{av:'A147WWPUserExtendedDeleted',fld:'WWPUSEREXTENDEDDELETED',pic:''}]}");
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
      return "wwpuserextended_Execute";
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
      sPrefix = "" ;
      Z32WWPUserExtendedId = "" ;
      Z146WWPUserExtendedName = "" ;
      Z138WWPUserExtendedFullName = "" ;
      Z145WWPUserExtendedPhone = "" ;
      Z139WWPUserExtendedEmail = "" ;
      Z148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A32WWPUserExtendedId = "" ;
      A140WWPUserExtendedPhoto = "" ;
      A40000WWPUserExtendedPhoto_GXI = "" ;
      sImgUrl = "" ;
      A146WWPUserExtendedName = "" ;
      A138WWPUserExtendedFullName = "" ;
      gxphoneLink = "" ;
      A145WWPUserExtendedPhone = "" ;
      A139WWPUserExtendedEmail = "" ;
      A148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z140WWPUserExtendedPhoto = "" ;
      Z40000WWPUserExtendedPhoto_GXI = "" ;
      T000S4_A32WWPUserExtendedId = new String[] {""} ;
      T000S4_n32WWPUserExtendedId = new boolean[] {false} ;
      T000S4_A140WWPUserExtendedPhoto = new String[] {""} ;
      T000S4_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      T000S4_A146WWPUserExtendedName = new String[] {""} ;
      T000S4_A138WWPUserExtendedFullName = new String[] {""} ;
      T000S4_A145WWPUserExtendedPhone = new String[] {""} ;
      T000S4_A139WWPUserExtendedEmail = new String[] {""} ;
      T000S4_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      T000S4_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      T000S4_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      T000S4_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      T000S4_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      T000S4_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      T000S4_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      T000S5_A32WWPUserExtendedId = new String[] {""} ;
      T000S5_n32WWPUserExtendedId = new boolean[] {false} ;
      T000S3_A32WWPUserExtendedId = new String[] {""} ;
      T000S3_n32WWPUserExtendedId = new boolean[] {false} ;
      T000S3_A140WWPUserExtendedPhoto = new String[] {""} ;
      T000S3_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      T000S3_A146WWPUserExtendedName = new String[] {""} ;
      T000S3_A138WWPUserExtendedFullName = new String[] {""} ;
      T000S3_A145WWPUserExtendedPhone = new String[] {""} ;
      T000S3_A139WWPUserExtendedEmail = new String[] {""} ;
      T000S3_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      T000S3_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      T000S3_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      T000S3_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      T000S3_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      T000S3_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      T000S3_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      sMode30 = "" ;
      T000S6_A32WWPUserExtendedId = new String[] {""} ;
      T000S6_n32WWPUserExtendedId = new boolean[] {false} ;
      T000S7_A32WWPUserExtendedId = new String[] {""} ;
      T000S7_n32WWPUserExtendedId = new boolean[] {false} ;
      T000S2_A32WWPUserExtendedId = new String[] {""} ;
      T000S2_n32WWPUserExtendedId = new boolean[] {false} ;
      T000S2_A140WWPUserExtendedPhoto = new String[] {""} ;
      T000S2_A40000WWPUserExtendedPhoto_GXI = new String[] {""} ;
      T000S2_A146WWPUserExtendedName = new String[] {""} ;
      T000S2_A138WWPUserExtendedFullName = new String[] {""} ;
      T000S2_A145WWPUserExtendedPhone = new String[] {""} ;
      T000S2_A139WWPUserExtendedEmail = new String[] {""} ;
      T000S2_A141WWPUserExtendedEmaiNotif = new boolean[] {false} ;
      T000S2_A142WWPUserExtendedSMSNotif = new boolean[] {false} ;
      T000S2_A143WWPUserExtendedMobileNotif = new boolean[] {false} ;
      T000S2_A144WWPUserExtendedDesktopNotif = new boolean[] {false} ;
      T000S2_A147WWPUserExtendedDeleted = new boolean[] {false} ;
      T000S2_A148WWPUserExtendedDeletedIn = new java.util.Date[] {GXutil.nullDate()} ;
      T000S2_n148WWPUserExtendedDeletedIn = new boolean[] {false} ;
      T000S12_A37WWPNotificationId = new long[1] ;
      T000S13_A39WWPWebClientId = new String[] {""} ;
      T000S14_A34WWPSubscriptionId = new long[1] ;
      T000S15_A32WWPUserExtendedId = new String[] {""} ;
      T000S15_n32WWPUserExtendedId = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      ZZ32WWPUserExtendedId = "" ;
      ZZ140WWPUserExtendedPhoto = "" ;
      ZZ40000WWPUserExtendedPhoto_GXI = "" ;
      ZZ146WWPUserExtendedName = "" ;
      ZZ138WWPUserExtendedFullName = "" ;
      ZZ145WWPUserExtendedPhone = "" ;
      ZZ139WWPUserExtendedEmail = "" ;
      ZZ148WWPUserExtendedDeletedIn = GXutil.resetTime( GXutil.nullDate() );
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_userextended__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_userextended__default(),
         new Object[] {
             new Object[] {
            T000S2_A32WWPUserExtendedId, T000S2_A140WWPUserExtendedPhoto, T000S2_A40000WWPUserExtendedPhoto_GXI, T000S2_A146WWPUserExtendedName, T000S2_A138WWPUserExtendedFullName, T000S2_A145WWPUserExtendedPhone, T000S2_A139WWPUserExtendedEmail, T000S2_A141WWPUserExtendedEmaiNotif, T000S2_A142WWPUserExtendedSMSNotif, T000S2_A143WWPUserExtendedMobileNotif,
            T000S2_A144WWPUserExtendedDesktopNotif, T000S2_A147WWPUserExtendedDeleted, T000S2_A148WWPUserExtendedDeletedIn, T000S2_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            T000S3_A32WWPUserExtendedId, T000S3_A140WWPUserExtendedPhoto, T000S3_A40000WWPUserExtendedPhoto_GXI, T000S3_A146WWPUserExtendedName, T000S3_A138WWPUserExtendedFullName, T000S3_A145WWPUserExtendedPhone, T000S3_A139WWPUserExtendedEmail, T000S3_A141WWPUserExtendedEmaiNotif, T000S3_A142WWPUserExtendedSMSNotif, T000S3_A143WWPUserExtendedMobileNotif,
            T000S3_A144WWPUserExtendedDesktopNotif, T000S3_A147WWPUserExtendedDeleted, T000S3_A148WWPUserExtendedDeletedIn, T000S3_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            T000S4_A32WWPUserExtendedId, T000S4_A140WWPUserExtendedPhoto, T000S4_A40000WWPUserExtendedPhoto_GXI, T000S4_A146WWPUserExtendedName, T000S4_A138WWPUserExtendedFullName, T000S4_A145WWPUserExtendedPhone, T000S4_A139WWPUserExtendedEmail, T000S4_A141WWPUserExtendedEmaiNotif, T000S4_A142WWPUserExtendedSMSNotif, T000S4_A143WWPUserExtendedMobileNotif,
            T000S4_A144WWPUserExtendedDesktopNotif, T000S4_A147WWPUserExtendedDeleted, T000S4_A148WWPUserExtendedDeletedIn, T000S4_n148WWPUserExtendedDeletedIn
            }
            , new Object[] {
            T000S5_A32WWPUserExtendedId
            }
            , new Object[] {
            T000S6_A32WWPUserExtendedId
            }
            , new Object[] {
            T000S7_A32WWPUserExtendedId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000S12_A37WWPNotificationId
            }
            , new Object[] {
            T000S13_A39WWPWebClientId
            }
            , new Object[] {
            T000S14_A34WWPSubscriptionId
            }
            , new Object[] {
            T000S15_A32WWPUserExtendedId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound30 ;
   private short nIsDirty_30 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPUserExtendedId_Enabled ;
   private int imgWWPUserExtendedPhoto_Enabled ;
   private int edtWWPUserExtendedName_Enabled ;
   private int edtWWPUserExtendedFullName_Enabled ;
   private int edtWWPUserExtendedPhone_Enabled ;
   private int edtWWPUserExtendedEmail_Enabled ;
   private int edtWWPUserExtendedEmaiNotif_Enabled ;
   private int edtWWPUserExtendedDeletedIn_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String Z32WWPUserExtendedId ;
   private String Z145WWPUserExtendedPhone ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPUserExtendedId_Internalname ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String A32WWPUserExtendedId ;
   private String edtWWPUserExtendedId_Jsonclick ;
   private String imgWWPUserExtendedPhoto_Internalname ;
   private String sImgUrl ;
   private String edtWWPUserExtendedName_Internalname ;
   private String edtWWPUserExtendedName_Jsonclick ;
   private String edtWWPUserExtendedFullName_Internalname ;
   private String edtWWPUserExtendedFullName_Jsonclick ;
   private String edtWWPUserExtendedPhone_Internalname ;
   private String gxphoneLink ;
   private String A145WWPUserExtendedPhone ;
   private String edtWWPUserExtendedPhone_Jsonclick ;
   private String edtWWPUserExtendedEmail_Internalname ;
   private String edtWWPUserExtendedEmail_Jsonclick ;
   private String edtWWPUserExtendedEmaiNotif_Internalname ;
   private String edtWWPUserExtendedEmaiNotif_Jsonclick ;
   private String edtWWPUserExtendedDeletedIn_Internalname ;
   private String edtWWPUserExtendedDeletedIn_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode30 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private String ZZ32WWPUserExtendedId ;
   private String ZZ145WWPUserExtendedPhone ;
   private java.util.Date Z148WWPUserExtendedDeletedIn ;
   private java.util.Date A148WWPUserExtendedDeletedIn ;
   private java.util.Date ZZ148WWPUserExtendedDeletedIn ;
   private boolean Z141WWPUserExtendedEmaiNotif ;
   private boolean Z142WWPUserExtendedSMSNotif ;
   private boolean Z143WWPUserExtendedMobileNotif ;
   private boolean Z144WWPUserExtendedDesktopNotif ;
   private boolean Z147WWPUserExtendedDeleted ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A142WWPUserExtendedSMSNotif ;
   private boolean A143WWPUserExtendedMobileNotif ;
   private boolean A144WWPUserExtendedDesktopNotif ;
   private boolean A147WWPUserExtendedDeleted ;
   private boolean A140WWPUserExtendedPhoto_IsBlob ;
   private boolean A141WWPUserExtendedEmaiNotif ;
   private boolean n148WWPUserExtendedDeletedIn ;
   private boolean n32WWPUserExtendedId ;
   private boolean Gx_longc ;
   private boolean ZZ141WWPUserExtendedEmaiNotif ;
   private boolean ZZ142WWPUserExtendedSMSNotif ;
   private boolean ZZ143WWPUserExtendedMobileNotif ;
   private boolean ZZ144WWPUserExtendedDesktopNotif ;
   private boolean ZZ147WWPUserExtendedDeleted ;
   private String Z146WWPUserExtendedName ;
   private String Z138WWPUserExtendedFullName ;
   private String Z139WWPUserExtendedEmail ;
   private String A40000WWPUserExtendedPhoto_GXI ;
   private String A146WWPUserExtendedName ;
   private String A138WWPUserExtendedFullName ;
   private String A139WWPUserExtendedEmail ;
   private String Z40000WWPUserExtendedPhoto_GXI ;
   private String ZZ40000WWPUserExtendedPhoto_GXI ;
   private String ZZ146WWPUserExtendedName ;
   private String ZZ138WWPUserExtendedFullName ;
   private String ZZ139WWPUserExtendedEmail ;
   private String A140WWPUserExtendedPhoto ;
   private String Z140WWPUserExtendedPhoto ;
   private String ZZ140WWPUserExtendedPhoto ;
   private ICheckbox chkWWPUserExtendedSMSNotif ;
   private ICheckbox chkWWPUserExtendedMobileNotif ;
   private ICheckbox chkWWPUserExtendedDesktopNotif ;
   private ICheckbox chkWWPUserExtendedDeleted ;
   private IDataStoreProvider pr_default ;
   private String[] T000S4_A32WWPUserExtendedId ;
   private boolean[] T000S4_n32WWPUserExtendedId ;
   private String[] T000S4_A140WWPUserExtendedPhoto ;
   private String[] T000S4_A40000WWPUserExtendedPhoto_GXI ;
   private String[] T000S4_A146WWPUserExtendedName ;
   private String[] T000S4_A138WWPUserExtendedFullName ;
   private String[] T000S4_A145WWPUserExtendedPhone ;
   private String[] T000S4_A139WWPUserExtendedEmail ;
   private boolean[] T000S4_A141WWPUserExtendedEmaiNotif ;
   private boolean[] T000S4_A142WWPUserExtendedSMSNotif ;
   private boolean[] T000S4_A143WWPUserExtendedMobileNotif ;
   private boolean[] T000S4_A144WWPUserExtendedDesktopNotif ;
   private boolean[] T000S4_A147WWPUserExtendedDeleted ;
   private java.util.Date[] T000S4_A148WWPUserExtendedDeletedIn ;
   private boolean[] T000S4_n148WWPUserExtendedDeletedIn ;
   private String[] T000S5_A32WWPUserExtendedId ;
   private boolean[] T000S5_n32WWPUserExtendedId ;
   private String[] T000S3_A32WWPUserExtendedId ;
   private boolean[] T000S3_n32WWPUserExtendedId ;
   private String[] T000S3_A140WWPUserExtendedPhoto ;
   private String[] T000S3_A40000WWPUserExtendedPhoto_GXI ;
   private String[] T000S3_A146WWPUserExtendedName ;
   private String[] T000S3_A138WWPUserExtendedFullName ;
   private String[] T000S3_A145WWPUserExtendedPhone ;
   private String[] T000S3_A139WWPUserExtendedEmail ;
   private boolean[] T000S3_A141WWPUserExtendedEmaiNotif ;
   private boolean[] T000S3_A142WWPUserExtendedSMSNotif ;
   private boolean[] T000S3_A143WWPUserExtendedMobileNotif ;
   private boolean[] T000S3_A144WWPUserExtendedDesktopNotif ;
   private boolean[] T000S3_A147WWPUserExtendedDeleted ;
   private java.util.Date[] T000S3_A148WWPUserExtendedDeletedIn ;
   private boolean[] T000S3_n148WWPUserExtendedDeletedIn ;
   private String[] T000S6_A32WWPUserExtendedId ;
   private boolean[] T000S6_n32WWPUserExtendedId ;
   private String[] T000S7_A32WWPUserExtendedId ;
   private boolean[] T000S7_n32WWPUserExtendedId ;
   private String[] T000S2_A32WWPUserExtendedId ;
   private boolean[] T000S2_n32WWPUserExtendedId ;
   private String[] T000S2_A140WWPUserExtendedPhoto ;
   private String[] T000S2_A40000WWPUserExtendedPhoto_GXI ;
   private String[] T000S2_A146WWPUserExtendedName ;
   private String[] T000S2_A138WWPUserExtendedFullName ;
   private String[] T000S2_A145WWPUserExtendedPhone ;
   private String[] T000S2_A139WWPUserExtendedEmail ;
   private boolean[] T000S2_A141WWPUserExtendedEmaiNotif ;
   private boolean[] T000S2_A142WWPUserExtendedSMSNotif ;
   private boolean[] T000S2_A143WWPUserExtendedMobileNotif ;
   private boolean[] T000S2_A144WWPUserExtendedDesktopNotif ;
   private boolean[] T000S2_A147WWPUserExtendedDeleted ;
   private java.util.Date[] T000S2_A148WWPUserExtendedDeletedIn ;
   private boolean[] T000S2_n148WWPUserExtendedDeletedIn ;
   private long[] T000S12_A37WWPNotificationId ;
   private String[] T000S13_A39WWPWebClientId ;
   private long[] T000S14_A34WWPSubscriptionId ;
   private String[] T000S15_A32WWPUserExtendedId ;
   private boolean[] T000S15_n32WWPUserExtendedId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_userextended__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_userextended__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000S2", "SELECT [WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] WITH (UPDLOCK) WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S3", "SELECT [WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S4", "SELECT TM1.[WWPUserExtendedId], TM1.[WWPUserExtendedPhoto], TM1.[WWPUserExtendedPhoto_GXI], TM1.[WWPUserExtendedName], TM1.[WWPUserExtendedFullName], TM1.[WWPUserExtendedPhone], TM1.[WWPUserExtendedEmail], TM1.[WWPUserExtendedEmaiNotif], TM1.[WWPUserExtendedSMSNotif], TM1.[WWPUserExtendedMobileNotif], TM1.[WWPUserExtendedDesktopNotif], TM1.[WWPUserExtendedDeleted], TM1.[WWPUserExtendedDeletedIn] FROM [WWP_UserExtended] TM1 WHERE TM1.[WWPUserExtendedId] = ? ORDER BY TM1.[WWPUserExtendedId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S5", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S6", "SELECT TOP 1 [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE ( [WWPUserExtendedId] > ?) ORDER BY [WWPUserExtendedId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S7", "SELECT TOP 1 [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE ( [WWPUserExtendedId] < ?) ORDER BY [WWPUserExtendedId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000S8", "INSERT INTO [WWP_UserExtended]([WWPUserExtendedId], [WWPUserExtendedPhoto], [WWPUserExtendedPhoto_GXI], [WWPUserExtendedName], [WWPUserExtendedFullName], [WWPUserExtendedPhone], [WWPUserExtendedEmail], [WWPUserExtendedEmaiNotif], [WWPUserExtendedSMSNotif], [WWPUserExtendedMobileNotif], [WWPUserExtendedDesktopNotif], [WWPUserExtendedDeleted], [WWPUserExtendedDeletedIn]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000S9", "UPDATE [WWP_UserExtended] SET [WWPUserExtendedName]=?, [WWPUserExtendedFullName]=?, [WWPUserExtendedPhone]=?, [WWPUserExtendedEmail]=?, [WWPUserExtendedEmaiNotif]=?, [WWPUserExtendedSMSNotif]=?, [WWPUserExtendedMobileNotif]=?, [WWPUserExtendedDesktopNotif]=?, [WWPUserExtendedDeleted]=?, [WWPUserExtendedDeletedIn]=?  WHERE [WWPUserExtendedId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000S10", "UPDATE [WWP_UserExtended] SET [WWPUserExtendedPhoto]=?, [WWPUserExtendedPhoto_GXI]=?  WHERE [WWPUserExtendedId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000S11", "DELETE FROM [WWP_UserExtended]  WHERE [WWPUserExtendedId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000S12", "SELECT TOP 1 [WWPNotificationId] FROM [WWP_Notification] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S13", "SELECT TOP 1 [WWPWebClientId] FROM [WWP_WebClient] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S14", "SELECT TOP 1 [WWPSubscriptionId] FROM [WWP_Subscription] WHERE [WWPUserExtendedId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S15", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] ORDER BY [WWPUserExtendedId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getMultimediaFile(2, rslt.getVarchar(3));
               ((String[]) buf[2])[0] = rslt.getMultimediaUri(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 100);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               stmt.setBLOBFile(2, (String)parms[2], true);
               stmt.setGXDbFileURI(3, (String)parms[3], (String)parms[2], 2048,"WWP_UserExtended","WWPUserExtendedPhoto");
               stmt.setVarchar(4, (String)parms[4], 100, false);
               stmt.setVarchar(5, (String)parms[5], 100, false);
               stmt.setString(6, (String)parms[6], 20);
               stmt.setVarchar(7, (String)parms[7], 100, false);
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[11]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[12]).booleanValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(13, (java.util.Date)parms[14], false);
               }
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(10, (java.util.Date)parms[10], false);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[12], 40);
               }
               return;
            case 8 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"WWP_UserExtended","WWPUserExtendedPhoto");
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 40);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 40);
               }
               return;
      }
   }

}

