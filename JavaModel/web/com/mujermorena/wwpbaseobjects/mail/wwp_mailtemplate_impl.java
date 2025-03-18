package com.mujermorena.wwpbaseobjects.mail ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_mailtemplate_impl extends GXDataArea
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Mail Template", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtWWPMailTemplateName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public wwp_mailtemplate_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwp_mailtemplate_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_mailtemplate_impl.class ));
   }

   public wwp_mailtemplate_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Mail Template", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTemplateName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTemplateName_Internalname, httpContext.getMessage( "Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailTemplateName_Internalname, A41WWPMailTemplateName, GXutil.rtrim( localUtil.format( A41WWPMailTemplateName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailTemplateName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailTemplateName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTemplateDescription_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTemplateDescription_Internalname, httpContext.getMessage( "Description", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailTemplateDescription_Internalname, A209WWPMailTemplateDescription, GXutil.rtrim( localUtil.format( A209WWPMailTemplateDescription, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailTemplateDescription_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailTemplateDescription_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTemplateSubject_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTemplateSubject_Internalname, httpContext.getMessage( "Subject", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtWWPMailTemplateSubject_Internalname, A210WWPMailTemplateSubject, GXutil.rtrim( localUtil.format( A210WWPMailTemplateSubject, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtWWPMailTemplateSubject_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtWWPMailTemplateSubject_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTemplateBody_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTemplateBody_Internalname, httpContext.getMessage( "Body", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailTemplateBody_Internalname, A195WWPMailTemplateBody, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", (short)(1), 1, edtWWPMailTemplateBody_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "GeneXus\\Html", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTemplateSenderAddress_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTemplateSenderAddress_Internalname, httpContext.getMessage( "Sender Address", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailTemplateSenderAddress_Internalname, A196WWPMailTemplateSenderAddress, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", (short)(0), 1, edtWWPMailTemplateSenderAddress_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtWWPMailTemplateSenderName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtWWPMailTemplateSenderName_Internalname, httpContext.getMessage( "Sender Name", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtWWPMailTemplateSenderName_Internalname, A197WWPMailTemplateSenderName, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", (short)(0), 1, edtWWPMailTemplateSenderName_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\Mail\\WWP_MailTemplate.htm");
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
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11102 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z41WWPMailTemplateName = httpContext.cgiGet( "Z41WWPMailTemplateName") ;
            Z209WWPMailTemplateDescription = httpContext.cgiGet( "Z209WWPMailTemplateDescription") ;
            Z210WWPMailTemplateSubject = httpContext.cgiGet( "Z210WWPMailTemplateSubject") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            /* Read variables values. */
            A41WWPMailTemplateName = httpContext.cgiGet( edtWWPMailTemplateName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
            A209WWPMailTemplateDescription = httpContext.cgiGet( edtWWPMailTemplateDescription_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A209WWPMailTemplateDescription", A209WWPMailTemplateDescription);
            A210WWPMailTemplateSubject = httpContext.cgiGet( edtWWPMailTemplateSubject_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A210WWPMailTemplateSubject", A210WWPMailTemplateSubject);
            A195WWPMailTemplateBody = httpContext.cgiGet( edtWWPMailTemplateBody_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A195WWPMailTemplateBody", A195WWPMailTemplateBody);
            A196WWPMailTemplateSenderAddress = httpContext.cgiGet( edtWWPMailTemplateSenderAddress_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A196WWPMailTemplateSenderAddress", A196WWPMailTemplateSenderAddress);
            A197WWPMailTemplateSenderName = httpContext.cgiGet( edtWWPMailTemplateSenderName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A197WWPMailTemplateSenderName", A197WWPMailTemplateSenderName);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
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
               A41WWPMailTemplateName = httpContext.GetPar( "WWPMailTemplateName") ;
               httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11102 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12102 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
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
         /* Execute user event: After Trn */
         e12102 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1038( ) ;
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
      disableAttributes1038( ) ;
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

   public void resetCaption100( )
   {
   }

   public void e11102( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e12102( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1038( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z209WWPMailTemplateDescription = T00103_A209WWPMailTemplateDescription[0] ;
            Z210WWPMailTemplateSubject = T00103_A210WWPMailTemplateSubject[0] ;
         }
         else
         {
            Z209WWPMailTemplateDescription = A209WWPMailTemplateDescription ;
            Z210WWPMailTemplateSubject = A210WWPMailTemplateSubject ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z41WWPMailTemplateName = A41WWPMailTemplateName ;
         Z209WWPMailTemplateDescription = A209WWPMailTemplateDescription ;
         Z210WWPMailTemplateSubject = A210WWPMailTemplateSubject ;
         Z195WWPMailTemplateBody = A195WWPMailTemplateBody ;
         Z196WWPMailTemplateSenderAddress = A196WWPMailTemplateSenderAddress ;
         Z197WWPMailTemplateSenderName = A197WWPMailTemplateSenderName ;
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

   public void load1038( )
   {
      /* Using cursor T00104 */
      pr_default.execute(2, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A209WWPMailTemplateDescription = T00104_A209WWPMailTemplateDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A209WWPMailTemplateDescription", A209WWPMailTemplateDescription);
         A210WWPMailTemplateSubject = T00104_A210WWPMailTemplateSubject[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A210WWPMailTemplateSubject", A210WWPMailTemplateSubject);
         A195WWPMailTemplateBody = T00104_A195WWPMailTemplateBody[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A195WWPMailTemplateBody", A195WWPMailTemplateBody);
         A196WWPMailTemplateSenderAddress = T00104_A196WWPMailTemplateSenderAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A196WWPMailTemplateSenderAddress", A196WWPMailTemplateSenderAddress);
         A197WWPMailTemplateSenderName = T00104_A197WWPMailTemplateSenderName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A197WWPMailTemplateSenderName", A197WWPMailTemplateSenderName);
         zm1038( -1) ;
      }
      pr_default.close(2);
      onLoadActions1038( ) ;
   }

   public void onLoadActions1038( )
   {
   }

   public void checkExtendedTable1038( )
   {
      nIsDirty_38 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors1038( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1038( )
   {
      /* Using cursor T00105 */
      pr_default.execute(3, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound38 = (short)(1) ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00103 */
      pr_default.execute(1, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1038( 1) ;
         RcdFound38 = (short)(1) ;
         A41WWPMailTemplateName = T00103_A41WWPMailTemplateName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
         A209WWPMailTemplateDescription = T00103_A209WWPMailTemplateDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A209WWPMailTemplateDescription", A209WWPMailTemplateDescription);
         A210WWPMailTemplateSubject = T00103_A210WWPMailTemplateSubject[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A210WWPMailTemplateSubject", A210WWPMailTemplateSubject);
         A195WWPMailTemplateBody = T00103_A195WWPMailTemplateBody[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A195WWPMailTemplateBody", A195WWPMailTemplateBody);
         A196WWPMailTemplateSenderAddress = T00103_A196WWPMailTemplateSenderAddress[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A196WWPMailTemplateSenderAddress", A196WWPMailTemplateSenderAddress);
         A197WWPMailTemplateSenderName = T00103_A197WWPMailTemplateSenderName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A197WWPMailTemplateSenderName", A197WWPMailTemplateSenderName);
         Z41WWPMailTemplateName = A41WWPMailTemplateName ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1038( ) ;
         if ( AnyError == 1 )
         {
            RcdFound38 = (short)(0) ;
            initializeNonKey1038( ) ;
         }
         Gx_mode = sMode38 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound38 = (short)(0) ;
         initializeNonKey1038( ) ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode38 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1038( ) ;
      if ( RcdFound38 == 0 )
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
      RcdFound38 = (short)(0) ;
      /* Using cursor T00106 */
      pr_default.execute(4, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T00106_A41WWPMailTemplateName[0], A41WWPMailTemplateName) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T00106_A41WWPMailTemplateName[0], A41WWPMailTemplateName) > 0 ) ) )
         {
            A41WWPMailTemplateName = T00106_A41WWPMailTemplateName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
            RcdFound38 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound38 = (short)(0) ;
      /* Using cursor T00107 */
      pr_default.execute(5, new Object[] {A41WWPMailTemplateName});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T00107_A41WWPMailTemplateName[0], A41WWPMailTemplateName) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T00107_A41WWPMailTemplateName[0], A41WWPMailTemplateName) < 0 ) ) )
         {
            A41WWPMailTemplateName = T00107_A41WWPMailTemplateName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
            RcdFound38 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1038( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtWWPMailTemplateName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1038( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound38 == 1 )
         {
            if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
            {
               A41WWPMailTemplateName = Z41WWPMailTemplateName ;
               httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "WWPMAILTEMPLATENAME");
               AnyError = (short)(1) ;
               GX_FocusControl = edtWWPMailTemplateName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtWWPMailTemplateName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1038( ) ;
               GX_FocusControl = edtWWPMailTemplateName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtWWPMailTemplateName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1038( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "WWPMAILTEMPLATENAME");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtWWPMailTemplateName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtWWPMailTemplateName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1038( ) ;
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
      if ( GXutil.strcmp(A41WWPMailTemplateName, Z41WWPMailTemplateName) != 0 )
      {
         A41WWPMailTemplateName = Z41WWPMailTemplateName ;
         httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "WWPMAILTEMPLATENAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailTemplateName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtWWPMailTemplateName_Internalname ;
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
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "WWPMAILTEMPLATENAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtWWPMailTemplateName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtWWPMailTemplateDescription_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart1038( ) ;
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailTemplateDescription_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1038( ) ;
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
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailTemplateDescription_Internalname ;
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
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailTemplateDescription_Internalname ;
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
      scanStart1038( ) ;
      if ( RcdFound38 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound38 != 0 )
         {
            scanNext1038( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtWWPMailTemplateDescription_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1038( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1038( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00102 */
         pr_default.execute(0, new Object[] {A41WWPMailTemplateName});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailTemplate"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z209WWPMailTemplateDescription, T00102_A209WWPMailTemplateDescription[0]) != 0 ) || ( GXutil.strcmp(Z210WWPMailTemplateSubject, T00102_A210WWPMailTemplateSubject[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z209WWPMailTemplateDescription, T00102_A209WWPMailTemplateDescription[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mailtemplate:[seudo value changed for attri]"+"WWPMailTemplateDescription");
               GXutil.writeLogRaw("Old: ",Z209WWPMailTemplateDescription);
               GXutil.writeLogRaw("Current: ",T00102_A209WWPMailTemplateDescription[0]);
            }
            if ( GXutil.strcmp(Z210WWPMailTemplateSubject, T00102_A210WWPMailTemplateSubject[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.mail.wwp_mailtemplate:[seudo value changed for attri]"+"WWPMailTemplateSubject");
               GXutil.writeLogRaw("Old: ",Z210WWPMailTemplateSubject);
               GXutil.writeLogRaw("Current: ",T00102_A210WWPMailTemplateSubject[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"WWP_MailTemplate"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1038( )
   {
      if ( ! IsAuthorized("wwpmailtemplate_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1038( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1038( 0) ;
         checkOptimisticConcurrency1038( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1038( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1038( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00108 */
                  pr_default.execute(6, new Object[] {A41WWPMailTemplateName, A209WWPMailTemplateDescription, A210WWPMailTemplateSubject, A195WWPMailTemplateBody, A196WWPMailTemplateSenderAddress, A197WWPMailTemplateSenderName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailTemplate");
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
                        resetCaption100( ) ;
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
            load1038( ) ;
         }
         endLevel1038( ) ;
      }
      closeExtendedTableCursors1038( ) ;
   }

   public void update1038( )
   {
      if ( ! IsAuthorized("wwpmailtemplate_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1038( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1038( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1038( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1038( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00109 */
                  pr_default.execute(7, new Object[] {A209WWPMailTemplateDescription, A210WWPMailTemplateSubject, A195WWPMailTemplateBody, A196WWPMailTemplateSenderAddress, A197WWPMailTemplateSenderName, A41WWPMailTemplateName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailTemplate");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"WWP_MailTemplate"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1038( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption100( ) ;
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
         endLevel1038( ) ;
      }
      closeExtendedTableCursors1038( ) ;
   }

   public void deferredUpdate1038( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("wwpmailtemplate_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1038( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1038( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1038( ) ;
         afterConfirm1038( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1038( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001010 */
               pr_default.execute(8, new Object[] {A41WWPMailTemplateName});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("WWP_MailTemplate");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound38 == 0 )
                     {
                        initAll1038( ) ;
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
                     resetCaption100( ) ;
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
      sMode38 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1038( ) ;
      Gx_mode = sMode38 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1038( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1038( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1038( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.mail.wwp_mailtemplate");
         if ( AnyError == 0 )
         {
            confirmValues100( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.mail.wwp_mailtemplate");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1038( )
   {
      /* Using cursor T001011 */
      pr_default.execute(9);
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A41WWPMailTemplateName = T001011_A41WWPMailTemplateName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1038( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A41WWPMailTemplateName = T001011_A41WWPMailTemplateName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
      }
   }

   public void scanEnd1038( )
   {
      pr_default.close(9);
   }

   public void afterConfirm1038( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1038( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1038( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1038( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1038( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1038( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1038( )
   {
      edtWWPMailTemplateName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTemplateName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTemplateName_Enabled), 5, 0), true);
      edtWWPMailTemplateDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTemplateDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTemplateDescription_Enabled), 5, 0), true);
      edtWWPMailTemplateSubject_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTemplateSubject_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTemplateSubject_Enabled), 5, 0), true);
      edtWWPMailTemplateBody_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTemplateBody_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTemplateBody_Enabled), 5, 0), true);
      edtWWPMailTemplateSenderAddress_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTemplateSenderAddress_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTemplateSenderAddress_Enabled), 5, 0), true);
      edtWWPMailTemplateSenderName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtWWPMailTemplateSenderName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtWWPMailTemplateSenderName_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1038( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues100( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z41WWPMailTemplateName", Z41WWPMailTemplateName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z209WWPMailTemplateDescription", Z209WWPMailTemplateDescription);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z210WWPMailTemplateSubject", Z210WWPMailTemplateSubject);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
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
      return formatLink("com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.Mail.WWP_MailTemplate" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Mail Template", "") ;
   }

   public void initializeNonKey1038( )
   {
      A209WWPMailTemplateDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A209WWPMailTemplateDescription", A209WWPMailTemplateDescription);
      A210WWPMailTemplateSubject = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A210WWPMailTemplateSubject", A210WWPMailTemplateSubject);
      A195WWPMailTemplateBody = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A195WWPMailTemplateBody", A195WWPMailTemplateBody);
      A196WWPMailTemplateSenderAddress = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A196WWPMailTemplateSenderAddress", A196WWPMailTemplateSenderAddress);
      A197WWPMailTemplateSenderName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A197WWPMailTemplateSenderName", A197WWPMailTemplateSenderName);
      Z209WWPMailTemplateDescription = "" ;
      Z210WWPMailTemplateSubject = "" ;
   }

   public void initAll1038( )
   {
      A41WWPMailTemplateName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A41WWPMailTemplateName", A41WWPMailTemplateName);
      initializeNonKey1038( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111102456", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/mail/wwp_mailtemplate.js", "?202412111102457", false, true);
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
      edtWWPMailTemplateName_Internalname = "WWPMAILTEMPLATENAME" ;
      edtWWPMailTemplateDescription_Internalname = "WWPMAILTEMPLATEDESCRIPTION" ;
      edtWWPMailTemplateSubject_Internalname = "WWPMAILTEMPLATESUBJECT" ;
      edtWWPMailTemplateBody_Internalname = "WWPMAILTEMPLATEBODY" ;
      edtWWPMailTemplateSenderAddress_Internalname = "WWPMAILTEMPLATESENDERADDRESS" ;
      edtWWPMailTemplateSenderName_Internalname = "WWPMAILTEMPLATESENDERNAME" ;
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
      Form.setCaption( httpContext.getMessage( "Mail Template", "") );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtWWPMailTemplateSenderName_Enabled = 1 ;
      edtWWPMailTemplateSenderAddress_Enabled = 1 ;
      edtWWPMailTemplateBody_Enabled = 1 ;
      edtWWPMailTemplateSubject_Jsonclick = "" ;
      edtWWPMailTemplateSubject_Enabled = 1 ;
      edtWWPMailTemplateDescription_Jsonclick = "" ;
      edtWWPMailTemplateDescription_Enabled = 1 ;
      edtWWPMailTemplateName_Jsonclick = "" ;
      edtWWPMailTemplateName_Enabled = 1 ;
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
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtWWPMailTemplateDescription_Internalname ;
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

   public void valid_Wwpmailtemplatename( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A209WWPMailTemplateDescription", A209WWPMailTemplateDescription);
      httpContext.ajax_rsp_assign_attri("", false, "A210WWPMailTemplateSubject", A210WWPMailTemplateSubject);
      httpContext.ajax_rsp_assign_attri("", false, "A195WWPMailTemplateBody", A195WWPMailTemplateBody);
      httpContext.ajax_rsp_assign_attri("", false, "A196WWPMailTemplateSenderAddress", A196WWPMailTemplateSenderAddress);
      httpContext.ajax_rsp_assign_attri("", false, "A197WWPMailTemplateSenderName", A197WWPMailTemplateSenderName);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z41WWPMailTemplateName", Z41WWPMailTemplateName);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z209WWPMailTemplateDescription", Z209WWPMailTemplateDescription);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z210WWPMailTemplateSubject", Z210WWPMailTemplateSubject);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z195WWPMailTemplateBody", Z195WWPMailTemplateBody);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z196WWPMailTemplateSenderAddress", Z196WWPMailTemplateSenderAddress);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z197WWPMailTemplateSenderName", Z197WWPMailTemplateSenderName);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12102',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_WWPMAILTEMPLATENAME","{handler:'valid_Wwpmailtemplatename',iparms:[{av:'A41WWPMailTemplateName',fld:'WWPMAILTEMPLATENAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_WWPMAILTEMPLATENAME",",oparms:[{av:'A209WWPMailTemplateDescription',fld:'WWPMAILTEMPLATEDESCRIPTION',pic:''},{av:'A210WWPMailTemplateSubject',fld:'WWPMAILTEMPLATESUBJECT',pic:''},{av:'A195WWPMailTemplateBody',fld:'WWPMAILTEMPLATEBODY',pic:''},{av:'A196WWPMailTemplateSenderAddress',fld:'WWPMAILTEMPLATESENDERADDRESS',pic:''},{av:'A197WWPMailTemplateSenderName',fld:'WWPMAILTEMPLATESENDERNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z41WWPMailTemplateName'},{av:'Z209WWPMailTemplateDescription'},{av:'Z210WWPMailTemplateSubject'},{av:'Z195WWPMailTemplateBody'},{av:'Z196WWPMailTemplateSenderAddress'},{av:'Z197WWPMailTemplateSenderName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
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
      return "wwpmailtemplate_Execute";
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
      Z41WWPMailTemplateName = "" ;
      Z209WWPMailTemplateDescription = "" ;
      Z210WWPMailTemplateSubject = "" ;
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
      A41WWPMailTemplateName = "" ;
      A209WWPMailTemplateDescription = "" ;
      A210WWPMailTemplateSubject = "" ;
      A195WWPMailTemplateBody = "" ;
      A196WWPMailTemplateSenderAddress = "" ;
      A197WWPMailTemplateSenderName = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z195WWPMailTemplateBody = "" ;
      Z196WWPMailTemplateSenderAddress = "" ;
      Z197WWPMailTemplateSenderName = "" ;
      T00104_A41WWPMailTemplateName = new String[] {""} ;
      T00104_A209WWPMailTemplateDescription = new String[] {""} ;
      T00104_A210WWPMailTemplateSubject = new String[] {""} ;
      T00104_A195WWPMailTemplateBody = new String[] {""} ;
      T00104_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      T00104_A197WWPMailTemplateSenderName = new String[] {""} ;
      T00105_A41WWPMailTemplateName = new String[] {""} ;
      T00103_A41WWPMailTemplateName = new String[] {""} ;
      T00103_A209WWPMailTemplateDescription = new String[] {""} ;
      T00103_A210WWPMailTemplateSubject = new String[] {""} ;
      T00103_A195WWPMailTemplateBody = new String[] {""} ;
      T00103_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      T00103_A197WWPMailTemplateSenderName = new String[] {""} ;
      sMode38 = "" ;
      T00106_A41WWPMailTemplateName = new String[] {""} ;
      T00107_A41WWPMailTemplateName = new String[] {""} ;
      T00102_A41WWPMailTemplateName = new String[] {""} ;
      T00102_A209WWPMailTemplateDescription = new String[] {""} ;
      T00102_A210WWPMailTemplateSubject = new String[] {""} ;
      T00102_A195WWPMailTemplateBody = new String[] {""} ;
      T00102_A196WWPMailTemplateSenderAddress = new String[] {""} ;
      T00102_A197WWPMailTemplateSenderName = new String[] {""} ;
      T001011_A41WWPMailTemplateName = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ41WWPMailTemplateName = "" ;
      ZZ209WWPMailTemplateDescription = "" ;
      ZZ210WWPMailTemplateSubject = "" ;
      ZZ195WWPMailTemplateBody = "" ;
      ZZ196WWPMailTemplateSenderAddress = "" ;
      ZZ197WWPMailTemplateSenderName = "" ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.mail.wwp_mailtemplate__default(),
         new Object[] {
             new Object[] {
            T00102_A41WWPMailTemplateName, T00102_A209WWPMailTemplateDescription, T00102_A210WWPMailTemplateSubject, T00102_A195WWPMailTemplateBody, T00102_A196WWPMailTemplateSenderAddress, T00102_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            T00103_A41WWPMailTemplateName, T00103_A209WWPMailTemplateDescription, T00103_A210WWPMailTemplateSubject, T00103_A195WWPMailTemplateBody, T00103_A196WWPMailTemplateSenderAddress, T00103_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            T00104_A41WWPMailTemplateName, T00104_A209WWPMailTemplateDescription, T00104_A210WWPMailTemplateSubject, T00104_A195WWPMailTemplateBody, T00104_A196WWPMailTemplateSenderAddress, T00104_A197WWPMailTemplateSenderName
            }
            , new Object[] {
            T00105_A41WWPMailTemplateName
            }
            , new Object[] {
            T00106_A41WWPMailTemplateName
            }
            , new Object[] {
            T00107_A41WWPMailTemplateName
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001011_A41WWPMailTemplateName
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
   private short RcdFound38 ;
   private short nIsDirty_38 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtWWPMailTemplateName_Enabled ;
   private int edtWWPMailTemplateDescription_Enabled ;
   private int edtWWPMailTemplateSubject_Enabled ;
   private int edtWWPMailTemplateBody_Enabled ;
   private int edtWWPMailTemplateSenderAddress_Enabled ;
   private int edtWWPMailTemplateSenderName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtWWPMailTemplateName_Internalname ;
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
   private String edtWWPMailTemplateName_Jsonclick ;
   private String edtWWPMailTemplateDescription_Internalname ;
   private String edtWWPMailTemplateDescription_Jsonclick ;
   private String edtWWPMailTemplateSubject_Internalname ;
   private String edtWWPMailTemplateSubject_Jsonclick ;
   private String edtWWPMailTemplateBody_Internalname ;
   private String edtWWPMailTemplateSenderAddress_Internalname ;
   private String edtWWPMailTemplateSenderName_Internalname ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode38 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean returnInSub ;
   private String A195WWPMailTemplateBody ;
   private String A196WWPMailTemplateSenderAddress ;
   private String A197WWPMailTemplateSenderName ;
   private String Z195WWPMailTemplateBody ;
   private String Z196WWPMailTemplateSenderAddress ;
   private String Z197WWPMailTemplateSenderName ;
   private String ZZ195WWPMailTemplateBody ;
   private String ZZ196WWPMailTemplateSenderAddress ;
   private String ZZ197WWPMailTemplateSenderName ;
   private String Z41WWPMailTemplateName ;
   private String Z209WWPMailTemplateDescription ;
   private String Z210WWPMailTemplateSubject ;
   private String A41WWPMailTemplateName ;
   private String A209WWPMailTemplateDescription ;
   private String A210WWPMailTemplateSubject ;
   private String ZZ41WWPMailTemplateName ;
   private String ZZ209WWPMailTemplateDescription ;
   private String ZZ210WWPMailTemplateSubject ;
   private IDataStoreProvider pr_default ;
   private String[] T00104_A41WWPMailTemplateName ;
   private String[] T00104_A209WWPMailTemplateDescription ;
   private String[] T00104_A210WWPMailTemplateSubject ;
   private String[] T00104_A195WWPMailTemplateBody ;
   private String[] T00104_A196WWPMailTemplateSenderAddress ;
   private String[] T00104_A197WWPMailTemplateSenderName ;
   private String[] T00105_A41WWPMailTemplateName ;
   private String[] T00103_A41WWPMailTemplateName ;
   private String[] T00103_A209WWPMailTemplateDescription ;
   private String[] T00103_A210WWPMailTemplateSubject ;
   private String[] T00103_A195WWPMailTemplateBody ;
   private String[] T00103_A196WWPMailTemplateSenderAddress ;
   private String[] T00103_A197WWPMailTemplateSenderName ;
   private String[] T00106_A41WWPMailTemplateName ;
   private String[] T00107_A41WWPMailTemplateName ;
   private String[] T00102_A41WWPMailTemplateName ;
   private String[] T00102_A209WWPMailTemplateDescription ;
   private String[] T00102_A210WWPMailTemplateSubject ;
   private String[] T00102_A195WWPMailTemplateBody ;
   private String[] T00102_A196WWPMailTemplateSenderAddress ;
   private String[] T00102_A197WWPMailTemplateSenderName ;
   private String[] T001011_A41WWPMailTemplateName ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class wwp_mailtemplate__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class wwp_mailtemplate__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00102", "SELECT [WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName] FROM [WWP_MailTemplate] WITH (UPDLOCK) WHERE [WWPMailTemplateName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00103", "SELECT [WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName] FROM [WWP_MailTemplate] WHERE [WWPMailTemplateName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00104", "SELECT TM1.[WWPMailTemplateName], TM1.[WWPMailTemplateDescription], TM1.[WWPMailTemplateSubject], TM1.[WWPMailTemplateBody], TM1.[WWPMailTemplateSenderAddress], TM1.[WWPMailTemplateSenderName] FROM [WWP_MailTemplate] TM1 WHERE TM1.[WWPMailTemplateName] = ? ORDER BY TM1.[WWPMailTemplateName]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00105", "SELECT [WWPMailTemplateName] FROM [WWP_MailTemplate] WHERE [WWPMailTemplateName] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00106", "SELECT TOP 1 [WWPMailTemplateName] FROM [WWP_MailTemplate] WHERE ( [WWPMailTemplateName] > ?) ORDER BY [WWPMailTemplateName]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00107", "SELECT TOP 1 [WWPMailTemplateName] FROM [WWP_MailTemplate] WHERE ( [WWPMailTemplateName] < ?) ORDER BY [WWPMailTemplateName] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T00108", "INSERT INTO [WWP_MailTemplate]([WWPMailTemplateName], [WWPMailTemplateDescription], [WWPMailTemplateSubject], [WWPMailTemplateBody], [WWPMailTemplateSenderAddress], [WWPMailTemplateSenderName]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T00109", "UPDATE [WWP_MailTemplate] SET [WWPMailTemplateDescription]=?, [WWPMailTemplateSubject]=?, [WWPMailTemplateBody]=?, [WWPMailTemplateSenderAddress]=?, [WWPMailTemplateSenderName]=?  WHERE [WWPMailTemplateName] = ?", GX_NOMASK)
         ,new UpdateCursor("T001010", "DELETE FROM [WWP_MailTemplate]  WHERE [WWPMailTemplateName] = ?", GX_NOMASK)
         ,new ForEachCursor("T001011", "SELECT [WWPMailTemplateName] FROM [WWP_MailTemplate] ORDER BY [WWPMailTemplateName]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 80, false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 80, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
      }
   }

}

