package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class factura_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A28EmpresaId = GXutil.lval( httpContext.GetPar( "EmpresaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28EmpresaId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A28EmpresaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A29TimbradoId = GXutil.lval( httpContext.GetPar( "TimbradoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A29TimbradoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
      {
         A4ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A4ClienteId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_6") == 0 )
      {
         A26CajeroId = GXutil.lval( httpContext.GetPar( "CajeroId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_6( A26CajeroId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_7") == 0 )
      {
         A31TipoFacturaId = GXutil.lval( httpContext.GetPar( "TipoFacturaId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31TipoFacturaId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_7( A31TipoFacturaId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridfactura_detalle") == 0 )
      {
         gxnrgridfactura_detalle_newrow_invoke( ) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Factura", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtFacturaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridfactura_detalle_newrow_invoke( )
   {
      nRC_GXsfl_78 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_78"))) ;
      nGXsfl_78_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_78_idx"))) ;
      sGXsfl_78_idx = httpContext.GetPar( "sGXsfl_78_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridfactura_detalle_newrow( ) ;
      /* End function gxnrGridfactura_detalle_newrow_invoke */
   }

   public factura_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public factura_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( factura_impl.class ));
   }

   public factura_impl( int remoteHandle ,
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
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, httpContext.getMessage( "Factura", ""), "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Factura.htm");
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
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", httpContext.getMessage( "GX_BtnSelect", ""), bttBtn_select_Jsonclick, 5, httpContext.getMessage( "GX_BtnSelect", ""), "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Factura.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFacturaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtFacturaId_Internalname, httpContext.getMessage( "Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtFacturaId_Internalname, GXutil.ltrim( localUtil.ntoc( A30FacturaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtFacturaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A30FacturaId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A30FacturaId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFacturaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFacturaId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFacturaEmision_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtFacturaEmision_Internalname, httpContext.getMessage( "Emision", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtFacturaEmision_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtFacturaEmision_Internalname, localUtil.format(A130FacturaEmision, "99/99/99"), localUtil.format( A130FacturaEmision, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFacturaEmision_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFacturaEmision_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtFacturaEmision_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtFacturaEmision_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Factura.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpresaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtEmpresaId_Internalname, httpContext.getMessage( "Empresa Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtEmpresaId_Internalname, GXutil.ltrim( localUtil.ntoc( A28EmpresaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpresaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A28EmpresaId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A28EmpresaId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpresaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpresaId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTimbradoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTimbradoId_Internalname, httpContext.getMessage( "Timbrado Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTimbradoId_Internalname, GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTimbradoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A29TimbradoId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTimbradoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTimbradoId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteId_Internalname, httpContext.getMessage( "Cliente Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtClienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,54);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClienteId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajeroId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajeroId_Internalname, httpContext.getMessage( "Cajero Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajeroId_Internalname, GXutil.ltrim( localUtil.ntoc( A26CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCajeroId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A26CajeroId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A26CajeroId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajeroId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCajeroId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCajeroNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtCajeroNombre_Internalname, httpContext.getMessage( "Cajero Nombre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtCajeroNombre_Internalname, GXutil.rtrim( A112CajeroNombre), GXutil.rtrim( localUtil.format( A112CajeroNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCajeroNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCajeroNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Nombre", "left", true, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoFacturaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoFacturaId_Internalname, httpContext.getMessage( "Tipo Factura Id", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoFacturaId_Internalname, GXutil.ltrim( localUtil.ntoc( A31TipoFacturaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoFacturaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31TipoFacturaId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31TipoFacturaId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoFacturaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtTipoFacturaId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divDetalletable_Internalname, 1, 0, "px", 0, "px", "LevelTable", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 FormCell", "left", "top", "", "", "div");
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTitledetalle_Internalname, httpContext.getMessage( "Detalle", ""), "", "", lblTitledetalle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridfactura_detalle( ) ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 86,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Factura.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridfactura_detalle( )
   {
      /*  Grid Control  */
      startgridcontrol78( ) ;
      nGXsfl_78_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount29 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_29 = (short)(1) ;
            scanStart0R29( ) ;
            while ( RcdFound29 != 0 )
            {
               init_level_properties29( ) ;
               getByPrimaryKey0R29( ) ;
               addRow0R29( ) ;
               scanNext0R29( ) ;
            }
            scanEnd0R29( ) ;
            nBlankRcdCount29 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0R29( ) ;
         standaloneModal0R29( ) ;
         sMode29 = Gx_mode ;
         while ( nGXsfl_78_idx < nRC_GXsfl_78 )
         {
            bGXsfl_78_Refreshing = true ;
            readRow0R29( ) ;
            edtFacturaDetalleId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "FACTURADETALLEID_"+sGXsfl_78_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtFacturaDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaDetalleId_Enabled), 5, 0), !bGXsfl_78_Refreshing);
            if ( ( nRcdExists_29 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0R29( ) ;
            }
            sendRow0R29( ) ;
            bGXsfl_78_Refreshing = false ;
         }
         Gx_mode = sMode29 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount29 = (short)(5) ;
         nRcdExists_29 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0R29( ) ;
            while ( RcdFound29 != 0 )
            {
               sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_7829( ) ;
               init_level_properties29( ) ;
               standaloneNotModal0R29( ) ;
               getByPrimaryKey0R29( ) ;
               standaloneModal0R29( ) ;
               addRow0R29( ) ;
               scanNext0R29( ) ;
            }
            scanEnd0R29( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode29 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_7829( ) ;
      initAll0R29( ) ;
      init_level_properties29( ) ;
      nRcdExists_29 = (short)(0) ;
      nIsMod_29 = (short)(0) ;
      nRcdDeleted_29 = (short)(0) ;
      nBlankRcdCount29 = (short)(nBlankRcdUsr29+nBlankRcdCount29) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount29 > 0 )
      {
         standaloneNotModal0R29( ) ;
         standaloneModal0R29( ) ;
         addRow0R29( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtFacturaDetalleId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount29 = (short)(nBlankRcdCount29-1) ;
      }
      Gx_mode = sMode29 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridfactura_detalleContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridfactura_detalle", Gridfactura_detalleContainer, subGridfactura_detalle_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridfactura_detalleContainerData", Gridfactura_detalleContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridfactura_detalleContainerData"+"V", Gridfactura_detalleContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridfactura_detalleContainerData"+"V"+"\" value='"+Gridfactura_detalleContainer.GridValuesHidden()+"'/>") ;
      }
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
         Z30FacturaId = localUtil.ctol( httpContext.cgiGet( "Z30FacturaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z130FacturaEmision = localUtil.ctod( httpContext.cgiGet( "Z130FacturaEmision"), 0) ;
         Z28EmpresaId = localUtil.ctol( httpContext.cgiGet( "Z28EmpresaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z29TimbradoId = localUtil.ctol( httpContext.cgiGet( "Z29TimbradoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z4ClienteId = localUtil.ctol( httpContext.cgiGet( "Z4ClienteId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z26CajeroId = localUtil.ctol( httpContext.cgiGet( "Z26CajeroId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         Z31TipoFacturaId = localUtil.ctol( httpContext.cgiGet( "Z31TipoFacturaId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         nRC_GXsfl_78 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_78"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtFacturaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtFacturaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "FACTURAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtFacturaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A30FacturaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
         }
         else
         {
            A30FacturaId = localUtil.ctol( httpContext.cgiGet( edtFacturaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtFacturaEmision_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "FACTURAEMISION");
            AnyError = (short)(1) ;
            GX_FocusControl = edtFacturaEmision_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A130FacturaEmision = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A130FacturaEmision", localUtil.format(A130FacturaEmision, "99/99/99"));
         }
         else
         {
            A130FacturaEmision = localUtil.ctod( httpContext.cgiGet( edtFacturaEmision_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A130FacturaEmision", localUtil.format(A130FacturaEmision, "99/99/99"));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpresaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpresaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPRESAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEmpresaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A28EmpresaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28EmpresaId), 11, 0));
         }
         else
         {
            A28EmpresaId = localUtil.ctol( httpContext.cgiGet( edtEmpresaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28EmpresaId), 11, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIMBRADOID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTimbradoId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A29TimbradoId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         }
         else
         {
            A29TimbradoId = localUtil.ctol( httpContext.cgiGet( edtTimbradoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIENTEID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtClienteId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A4ClienteId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         }
         else
         {
            A4ClienteId = localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CAJEROID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCajeroId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A26CajeroId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         }
         else
         {
            A26CajeroId = localUtil.ctol( httpContext.cgiGet( edtCajeroId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         }
         A112CajeroNombre = httpContext.cgiGet( edtCajeroNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoFacturaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoFacturaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOFACTURAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtTipoFacturaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A31TipoFacturaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31TipoFacturaId), 11, 0));
         }
         else
         {
            A31TipoFacturaId = localUtil.ctol( httpContext.cgiGet( edtTipoFacturaId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31TipoFacturaId), 11, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A30FacturaId = GXutil.lval( httpContext.GetPar( "FacturaId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
            initAll0R28( ) ;
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
      disableAttributes0R28( ) ;
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

   public void confirm_0R29( )
   {
      nGXsfl_78_idx = 0 ;
      while ( nGXsfl_78_idx < nRC_GXsfl_78 )
      {
         readRow0R29( ) ;
         if ( ( nRcdExists_29 != 0 ) || ( nIsMod_29 != 0 ) )
         {
            getKey0R29( ) ;
            if ( ( nRcdExists_29 == 0 ) && ( nRcdDeleted_29 == 0 ) )
            {
               if ( RcdFound29 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0R29( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0R29( ) ;
                     closeExtendedTableCursors0R29( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "FACTURADETALLEID_" + sGXsfl_78_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtFacturaDetalleId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound29 != 0 )
               {
                  if ( nRcdDeleted_29 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0R29( ) ;
                     load0R29( ) ;
                     beforeValidate0R29( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0R29( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_29 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0R29( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0R29( ) ;
                           closeExtendedTableCursors0R29( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_29 == 0 )
                  {
                     GXCCtl = "FACTURADETALLEID_" + sGXsfl_78_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtFacturaDetalleId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtFacturaDetalleId_Internalname, GXutil.ltrim( localUtil.ntoc( A47FacturaDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z47FacturaDetalleId_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( Z47FacturaDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_29_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_29_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_29_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_29 != 0 )
         {
            httpContext.changePostValue( "FACTURADETALLEID_"+sGXsfl_78_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtFacturaDetalleId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0R0( )
   {
   }

   public void zm0R28( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z130FacturaEmision = T000R5_A130FacturaEmision[0] ;
            Z28EmpresaId = T000R5_A28EmpresaId[0] ;
            Z29TimbradoId = T000R5_A29TimbradoId[0] ;
            Z4ClienteId = T000R5_A4ClienteId[0] ;
            Z26CajeroId = T000R5_A26CajeroId[0] ;
            Z31TipoFacturaId = T000R5_A31TipoFacturaId[0] ;
         }
         else
         {
            Z130FacturaEmision = A130FacturaEmision ;
            Z28EmpresaId = A28EmpresaId ;
            Z29TimbradoId = A29TimbradoId ;
            Z4ClienteId = A4ClienteId ;
            Z26CajeroId = A26CajeroId ;
            Z31TipoFacturaId = A31TipoFacturaId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z30FacturaId = A30FacturaId ;
         Z130FacturaEmision = A130FacturaEmision ;
         Z28EmpresaId = A28EmpresaId ;
         Z29TimbradoId = A29TimbradoId ;
         Z4ClienteId = A4ClienteId ;
         Z26CajeroId = A26CajeroId ;
         Z31TipoFacturaId = A31TipoFacturaId ;
         Z112CajeroNombre = A112CajeroNombre ;
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

   public void load0R28( )
   {
      /* Using cursor T000R11 */
      pr_default.execute(9, new Object[] {Long.valueOf(A30FacturaId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A130FacturaEmision = T000R11_A130FacturaEmision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A130FacturaEmision", localUtil.format(A130FacturaEmision, "99/99/99"));
         A112CajeroNombre = T000R11_A112CajeroNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
         A28EmpresaId = T000R11_A28EmpresaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28EmpresaId), 11, 0));
         A29TimbradoId = T000R11_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         A4ClienteId = T000R11_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A26CajeroId = T000R11_A26CajeroId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         A31TipoFacturaId = T000R11_A31TipoFacturaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31TipoFacturaId), 11, 0));
         zm0R28( -2) ;
      }
      pr_default.close(9);
      onLoadActions0R28( ) ;
   }

   public void onLoadActions0R28( )
   {
   }

   public void checkExtendedTable0R28( )
   {
      nIsDirty_28 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A130FacturaEmision)) || (( GXutil.resetTime(A130FacturaEmision).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A130FacturaEmision), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Factura Emision", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "FACTURAEMISION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFacturaEmision_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000R6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A28EmpresaId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRESAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpresaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T000R7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Timbrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
      /* Using cursor T000R8 */
      pr_default.execute(6, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(6);
      /* Using cursor T000R9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A26CajeroId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cajero", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJEROID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajeroId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A112CajeroNombre = T000R9_A112CajeroNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
      pr_default.close(7);
      /* Using cursor T000R10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A31TipoFacturaId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Factura", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOFACTURAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoFacturaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(8);
   }

   public void closeExtendedTableCursors0R28( )
   {
      pr_default.close(4);
      pr_default.close(5);
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( long A28EmpresaId )
   {
      /* Using cursor T000R12 */
      pr_default.execute(10, new Object[] {Long.valueOf(A28EmpresaId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRESAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpresaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_4( long A29TimbradoId )
   {
      /* Using cursor T000R13 */
      pr_default.execute(11, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Timbrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_5( long A4ClienteId )
   {
      /* Using cursor T000R14 */
      pr_default.execute(12, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_6( long A26CajeroId )
   {
      /* Using cursor T000R15 */
      pr_default.execute(13, new Object[] {Long.valueOf(A26CajeroId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cajero", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJEROID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajeroId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A112CajeroNombre = T000R15_A112CajeroNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A112CajeroNombre))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_7( long A31TipoFacturaId )
   {
      /* Using cursor T000R16 */
      pr_default.execute(14, new Object[] {Long.valueOf(A31TipoFacturaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Factura", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOFACTURAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoFacturaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey0R28( )
   {
      /* Using cursor T000R17 */
      pr_default.execute(15, new Object[] {Long.valueOf(A30FacturaId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound28 = (short)(1) ;
      }
      else
      {
         RcdFound28 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000R5 */
      pr_default.execute(3, new Object[] {Long.valueOf(A30FacturaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm0R28( 2) ;
         RcdFound28 = (short)(1) ;
         A30FacturaId = T000R5_A30FacturaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
         A130FacturaEmision = T000R5_A130FacturaEmision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A130FacturaEmision", localUtil.format(A130FacturaEmision, "99/99/99"));
         A28EmpresaId = T000R5_A28EmpresaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28EmpresaId), 11, 0));
         A29TimbradoId = T000R5_A29TimbradoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
         A4ClienteId = T000R5_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A26CajeroId = T000R5_A26CajeroId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
         A31TipoFacturaId = T000R5_A31TipoFacturaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31TipoFacturaId), 11, 0));
         Z30FacturaId = A30FacturaId ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0R28( ) ;
         if ( AnyError == 1 )
         {
            RcdFound28 = (short)(0) ;
            initializeNonKey0R28( ) ;
         }
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound28 = (short)(0) ;
         initializeNonKey0R28( ) ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey0R28( ) ;
      if ( RcdFound28 == 0 )
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
      RcdFound28 = (short)(0) ;
      /* Using cursor T000R18 */
      pr_default.execute(16, new Object[] {Long.valueOf(A30FacturaId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T000R18_A30FacturaId[0] < A30FacturaId ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T000R18_A30FacturaId[0] > A30FacturaId ) ) )
         {
            A30FacturaId = T000R18_A30FacturaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
            RcdFound28 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void move_previous( )
   {
      RcdFound28 = (short)(0) ;
      /* Using cursor T000R19 */
      pr_default.execute(17, new Object[] {Long.valueOf(A30FacturaId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         while ( (pr_default.getStatus(17) != 101) && ( ( T000R19_A30FacturaId[0] > A30FacturaId ) ) )
         {
            pr_default.readNext(17);
         }
         if ( (pr_default.getStatus(17) != 101) && ( ( T000R19_A30FacturaId[0] < A30FacturaId ) ) )
         {
            A30FacturaId = T000R19_A30FacturaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
            RcdFound28 = (short)(1) ;
         }
      }
      pr_default.close(17);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0R28( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtFacturaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0R28( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound28 == 1 )
         {
            if ( A30FacturaId != Z30FacturaId )
            {
               A30FacturaId = Z30FacturaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "FACTURAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFacturaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtFacturaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0R28( ) ;
               GX_FocusControl = edtFacturaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A30FacturaId != Z30FacturaId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtFacturaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0R28( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "FACTURAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtFacturaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtFacturaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0R28( ) ;
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
      if ( A30FacturaId != Z30FacturaId )
      {
         A30FacturaId = Z30FacturaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "FACTURAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFacturaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtFacturaId_Internalname ;
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
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "FACTURAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFacturaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtFacturaEmision_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0R28( ) ;
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtFacturaEmision_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0R28( ) ;
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
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtFacturaEmision_Internalname ;
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
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtFacturaEmision_Internalname ;
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
      scanStart0R28( ) ;
      if ( RcdFound28 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound28 != 0 )
         {
            scanNext0R28( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtFacturaEmision_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0R28( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0R28( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000R4 */
         pr_default.execute(2, new Object[] {Long.valueOf(A30FacturaId)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Factura"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z130FacturaEmision), GXutil.resetTime(T000R4_A130FacturaEmision[0])) ) || ( Z28EmpresaId != T000R4_A28EmpresaId[0] ) || ( Z29TimbradoId != T000R4_A29TimbradoId[0] ) || ( Z4ClienteId != T000R4_A4ClienteId[0] ) || ( Z26CajeroId != T000R4_A26CajeroId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z31TipoFacturaId != T000R4_A31TipoFacturaId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z130FacturaEmision), GXutil.resetTime(T000R4_A130FacturaEmision[0])) ) )
            {
               GXutil.writeLogln("factura:[seudo value changed for attri]"+"FacturaEmision");
               GXutil.writeLogRaw("Old: ",Z130FacturaEmision);
               GXutil.writeLogRaw("Current: ",T000R4_A130FacturaEmision[0]);
            }
            if ( Z28EmpresaId != T000R4_A28EmpresaId[0] )
            {
               GXutil.writeLogln("factura:[seudo value changed for attri]"+"EmpresaId");
               GXutil.writeLogRaw("Old: ",Z28EmpresaId);
               GXutil.writeLogRaw("Current: ",T000R4_A28EmpresaId[0]);
            }
            if ( Z29TimbradoId != T000R4_A29TimbradoId[0] )
            {
               GXutil.writeLogln("factura:[seudo value changed for attri]"+"TimbradoId");
               GXutil.writeLogRaw("Old: ",Z29TimbradoId);
               GXutil.writeLogRaw("Current: ",T000R4_A29TimbradoId[0]);
            }
            if ( Z4ClienteId != T000R4_A4ClienteId[0] )
            {
               GXutil.writeLogln("factura:[seudo value changed for attri]"+"ClienteId");
               GXutil.writeLogRaw("Old: ",Z4ClienteId);
               GXutil.writeLogRaw("Current: ",T000R4_A4ClienteId[0]);
            }
            if ( Z26CajeroId != T000R4_A26CajeroId[0] )
            {
               GXutil.writeLogln("factura:[seudo value changed for attri]"+"CajeroId");
               GXutil.writeLogRaw("Old: ",Z26CajeroId);
               GXutil.writeLogRaw("Current: ",T000R4_A26CajeroId[0]);
            }
            if ( Z31TipoFacturaId != T000R4_A31TipoFacturaId[0] )
            {
               GXutil.writeLogln("factura:[seudo value changed for attri]"+"TipoFacturaId");
               GXutil.writeLogRaw("Old: ",Z31TipoFacturaId);
               GXutil.writeLogRaw("Current: ",T000R4_A31TipoFacturaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Factura"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0R28( )
   {
      if ( ! IsAuthorized("factura_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0R28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R28( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0R28( 0) ;
         checkOptimisticConcurrency0R28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R28( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0R28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000R20 */
                  pr_default.execute(18, new Object[] {Long.valueOf(A30FacturaId), A130FacturaEmision, Long.valueOf(A28EmpresaId), Long.valueOf(A29TimbradoId), Long.valueOf(A4ClienteId), Long.valueOf(A26CajeroId), Long.valueOf(A31TipoFacturaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Factura");
                  if ( (pr_default.getStatus(18) == 1) )
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
                        processLevel0R28( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0R0( ) ;
                        }
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
            load0R28( ) ;
         }
         endLevel0R28( ) ;
      }
      closeExtendedTableCursors0R28( ) ;
   }

   public void update0R28( )
   {
      if ( ! IsAuthorized("factura_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0R28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R28( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R28( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0R28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000R21 */
                  pr_default.execute(19, new Object[] {A130FacturaEmision, Long.valueOf(A28EmpresaId), Long.valueOf(A29TimbradoId), Long.valueOf(A4ClienteId), Long.valueOf(A26CajeroId), Long.valueOf(A31TipoFacturaId), Long.valueOf(A30FacturaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Factura");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Factura"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0R28( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0R28( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                           resetCaption0R0( ) ;
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
         }
         endLevel0R28( ) ;
      }
      closeExtendedTableCursors0R28( ) ;
   }

   public void deferredUpdate0R28( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("factura_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0R28( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R28( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0R28( ) ;
         afterConfirm0R28( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0R28( ) ;
            if ( AnyError == 0 )
            {
               scanStart0R29( ) ;
               while ( RcdFound29 != 0 )
               {
                  getByPrimaryKey0R29( ) ;
                  delete0R29( ) ;
                  scanNext0R29( ) ;
               }
               scanEnd0R29( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000R22 */
                  pr_default.execute(20, new Object[] {Long.valueOf(A30FacturaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Factura");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound28 == 0 )
                        {
                           initAll0R28( ) ;
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
                        resetCaption0R0( ) ;
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
      }
      sMode28 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0R28( ) ;
      Gx_mode = sMode28 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0R28( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000R23 */
         pr_default.execute(21, new Object[] {Long.valueOf(A26CajeroId)});
         A112CajeroNombre = T000R23_A112CajeroNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
         pr_default.close(21);
      }
   }

   public void processNestedLevel0R29( )
   {
      nGXsfl_78_idx = 0 ;
      while ( nGXsfl_78_idx < nRC_GXsfl_78 )
      {
         readRow0R29( ) ;
         if ( ( nRcdExists_29 != 0 ) || ( nIsMod_29 != 0 ) )
         {
            standaloneNotModal0R29( ) ;
            getKey0R29( ) ;
            if ( ( nRcdExists_29 == 0 ) && ( nRcdDeleted_29 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0R29( ) ;
            }
            else
            {
               if ( RcdFound29 != 0 )
               {
                  if ( ( nRcdDeleted_29 != 0 ) && ( nRcdExists_29 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0R29( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_29 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0R29( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_29 == 0 )
                  {
                     GXCCtl = "FACTURADETALLEID_" + sGXsfl_78_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtFacturaDetalleId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtFacturaDetalleId_Internalname, GXutil.ltrim( localUtil.ntoc( A47FacturaDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z47FacturaDetalleId_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( Z47FacturaDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_29_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_29_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_29_"+sGXsfl_78_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_29 != 0 )
         {
            httpContext.changePostValue( "FACTURADETALLEID_"+sGXsfl_78_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtFacturaDetalleId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0R29( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_29 = (short)(0) ;
      nIsMod_29 = (short)(0) ;
      nRcdDeleted_29 = (short)(0) ;
   }

   public void processLevel0R28( )
   {
      /* Save parent mode. */
      sMode28 = Gx_mode ;
      processNestedLevel0R29( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode28 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0R28( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0R28( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(21);
         Application.commitDataStores(context, remoteHandle, pr_default, "factura");
         if ( AnyError == 0 )
         {
            confirmValues0R0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(21);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "factura");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0R28( )
   {
      /* Using cursor T000R24 */
      pr_default.execute(22);
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A30FacturaId = T000R24_A30FacturaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0R28( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A30FacturaId = T000R24_A30FacturaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
      }
   }

   public void scanEnd0R28( )
   {
      pr_default.close(22);
   }

   public void afterConfirm0R28( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0R28( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0R28( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0R28( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0R28( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0R28( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0R28( )
   {
      edtFacturaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFacturaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaId_Enabled), 5, 0), true);
      edtFacturaEmision_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFacturaEmision_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaEmision_Enabled), 5, 0), true);
      edtEmpresaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpresaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpresaId_Enabled), 5, 0), true);
      edtTimbradoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTimbradoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTimbradoId_Enabled), 5, 0), true);
      edtClienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      edtCajeroId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCajeroId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajeroId_Enabled), 5, 0), true);
      edtCajeroNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCajeroNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCajeroNombre_Enabled), 5, 0), true);
      edtTipoFacturaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoFacturaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoFacturaId_Enabled), 5, 0), true);
   }

   public void zm0R29( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -8 )
      {
         Z30FacturaId = A30FacturaId ;
         Z47FacturaDetalleId = A47FacturaDetalleId ;
      }
   }

   public void standaloneNotModal0R29( )
   {
   }

   public void standaloneModal0R29( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtFacturaDetalleId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFacturaDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaDetalleId_Enabled), 5, 0), !bGXsfl_78_Refreshing);
      }
      else
      {
         edtFacturaDetalleId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFacturaDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaDetalleId_Enabled), 5, 0), !bGXsfl_78_Refreshing);
      }
   }

   public void load0R29( )
   {
      /* Using cursor T000R25 */
      pr_default.execute(23, new Object[] {Long.valueOf(A30FacturaId), Long.valueOf(A47FacturaDetalleId)});
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound29 = (short)(1) ;
         zm0R29( -8) ;
      }
      pr_default.close(23);
      onLoadActions0R29( ) ;
   }

   public void onLoadActions0R29( )
   {
   }

   public void checkExtendedTable0R29( )
   {
      nIsDirty_29 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0R29( ) ;
   }

   public void closeExtendedTableCursors0R29( )
   {
   }

   public void enableDisable0R29( )
   {
   }

   public void getKey0R29( )
   {
      /* Using cursor T000R26 */
      pr_default.execute(24, new Object[] {Long.valueOf(A30FacturaId), Long.valueOf(A47FacturaDetalleId)});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound29 = (short)(1) ;
      }
      else
      {
         RcdFound29 = (short)(0) ;
      }
      pr_default.close(24);
   }

   public void getByPrimaryKey0R29( )
   {
      /* Using cursor T000R3 */
      pr_default.execute(1, new Object[] {Long.valueOf(A30FacturaId), Long.valueOf(A47FacturaDetalleId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0R29( 8) ;
         RcdFound29 = (short)(1) ;
         initializeNonKey0R29( ) ;
         A47FacturaDetalleId = T000R3_A47FacturaDetalleId[0] ;
         Z30FacturaId = A30FacturaId ;
         Z47FacturaDetalleId = A47FacturaDetalleId ;
         sMode29 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0R29( ) ;
         load0R29( ) ;
         Gx_mode = sMode29 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound29 = (short)(0) ;
         initializeNonKey0R29( ) ;
         sMode29 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0R29( ) ;
         Gx_mode = sMode29 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0R29( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0R29( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000R2 */
         pr_default.execute(0, new Object[] {Long.valueOf(A30FacturaId), Long.valueOf(A47FacturaDetalleId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"FacturaDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"FacturaDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0R29( )
   {
      if ( ! IsAuthorized("factura_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0R29( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R29( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0R29( 0) ;
         checkOptimisticConcurrency0R29( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R29( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0R29( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000R27 */
                  pr_default.execute(25, new Object[] {Long.valueOf(A30FacturaId), Long.valueOf(A47FacturaDetalleId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("FacturaDetalle");
                  if ( (pr_default.getStatus(25) == 1) )
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
            load0R29( ) ;
         }
         endLevel0R29( ) ;
      }
      closeExtendedTableCursors0R29( ) ;
   }

   public void update0R29( )
   {
      if ( ! IsAuthorized("factura_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate0R29( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R29( ) ;
      }
      if ( ( nIsMod_29 != 0 ) || ( nIsDirty_29 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0R29( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0R29( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0R29( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table [FacturaDetalle] */
                     deferredUpdate0R29( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0R29( ) ;
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
            endLevel0R29( ) ;
         }
      }
      closeExtendedTableCursors0R29( ) ;
   }

   public void deferredUpdate0R29( )
   {
   }

   public void delete0R29( )
   {
      if ( ! IsAuthorized("factura_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0R29( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R29( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0R29( ) ;
         afterConfirm0R29( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0R29( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000R28 */
               pr_default.execute(26, new Object[] {Long.valueOf(A30FacturaId), Long.valueOf(A47FacturaDetalleId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("FacturaDetalle");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode29 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0R29( ) ;
      Gx_mode = sMode29 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0R29( )
   {
      standaloneModal0R29( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0R29( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0R29( )
   {
      /* Scan By routine */
      /* Using cursor T000R29 */
      pr_default.execute(27, new Object[] {Long.valueOf(A30FacturaId)});
      RcdFound29 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A47FacturaDetalleId = T000R29_A47FacturaDetalleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0R29( )
   {
      /* Scan next routine */
      pr_default.readNext(27);
      RcdFound29 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A47FacturaDetalleId = T000R29_A47FacturaDetalleId[0] ;
      }
   }

   public void scanEnd0R29( )
   {
      pr_default.close(27);
   }

   public void afterConfirm0R29( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0R29( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0R29( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0R29( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0R29( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0R29( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0R29( )
   {
      edtFacturaDetalleId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFacturaDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaDetalleId_Enabled), 5, 0), !bGXsfl_78_Refreshing);
   }

   public void send_integrity_lvl_hashes0R29( )
   {
   }

   public void send_integrity_lvl_hashes0R28( )
   {
   }

   public void subsflControlProps_7829( )
   {
      edtFacturaDetalleId_Internalname = "FACTURADETALLEID_"+sGXsfl_78_idx ;
   }

   public void subsflControlProps_fel_7829( )
   {
      edtFacturaDetalleId_Internalname = "FACTURADETALLEID_"+sGXsfl_78_fel_idx ;
   }

   public void addRow0R29( )
   {
      nGXsfl_78_idx = (int)(nGXsfl_78_idx+1) ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7829( ) ;
      sendRow0R29( ) ;
   }

   public void sendRow0R29( )
   {
      Gridfactura_detalleRow = GXWebRow.GetNew(context) ;
      if ( subGridfactura_detalle_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridfactura_detalle_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridfactura_detalle_Class, "") != 0 )
         {
            subGridfactura_detalle_Linesclass = subGridfactura_detalle_Class+"Odd" ;
         }
      }
      else if ( subGridfactura_detalle_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridfactura_detalle_Backstyle = (byte)(0) ;
         subGridfactura_detalle_Backcolor = subGridfactura_detalle_Allbackcolor ;
         if ( GXutil.strcmp(subGridfactura_detalle_Class, "") != 0 )
         {
            subGridfactura_detalle_Linesclass = subGridfactura_detalle_Class+"Uniform" ;
         }
      }
      else if ( subGridfactura_detalle_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridfactura_detalle_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridfactura_detalle_Class, "") != 0 )
         {
            subGridfactura_detalle_Linesclass = subGridfactura_detalle_Class+"Odd" ;
         }
         subGridfactura_detalle_Backcolor = (int)(0x0) ;
      }
      else if ( subGridfactura_detalle_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridfactura_detalle_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_78_idx) % (2))) == 0 )
         {
            subGridfactura_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridfactura_detalle_Class, "") != 0 )
            {
               subGridfactura_detalle_Linesclass = subGridfactura_detalle_Class+"Even" ;
            }
         }
         else
         {
            subGridfactura_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridfactura_detalle_Class, "") != 0 )
            {
               subGridfactura_detalle_Linesclass = subGridfactura_detalle_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_29_" + sGXsfl_78_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 79,'',false,'" + sGXsfl_78_idx + "',78)\"" ;
      ROClassString = "Attribute" ;
      Gridfactura_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtFacturaDetalleId_Internalname,GXutil.ltrim( localUtil.ntoc( A47FacturaDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A47FacturaDetalleId), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,79);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtFacturaDetalleId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtFacturaDetalleId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(78),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridfactura_detalleRow);
      send_integrity_lvl_hashes0R29( ) ;
      GXCCtl = "Z47FacturaDetalleId_" + sGXsfl_78_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z47FacturaDetalleId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_29_" + sGXsfl_78_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_29_" + sGXsfl_78_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_29_" + sGXsfl_78_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_29, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "FACTURADETALLEID_"+sGXsfl_78_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtFacturaDetalleId_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridfactura_detalleContainer.AddRow(Gridfactura_detalleRow);
   }

   public void readRow0R29( )
   {
      nGXsfl_78_idx = (int)(nGXsfl_78_idx+1) ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7829( ) ;
      edtFacturaDetalleId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "FACTURADETALLEID_"+sGXsfl_78_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtFacturaDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtFacturaDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "FACTURADETALLEID_" + sGXsfl_78_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtFacturaDetalleId_Internalname ;
         wbErr = true ;
         A47FacturaDetalleId = 0 ;
      }
      else
      {
         A47FacturaDetalleId = localUtil.ctol( httpContext.cgiGet( edtFacturaDetalleId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      GXCCtl = "Z47FacturaDetalleId_" + sGXsfl_78_idx ;
      Z47FacturaDetalleId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "nRcdDeleted_29_" + sGXsfl_78_idx ;
      nRcdDeleted_29 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_29_" + sGXsfl_78_idx ;
      nRcdExists_29 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_29_" + sGXsfl_78_idx ;
      nIsMod_29 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtFacturaDetalleId_Enabled = edtFacturaDetalleId_Enabled ;
   }

   public void confirmValues0R0( )
   {
      nGXsfl_78_idx = 0 ;
      sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7829( ) ;
      while ( nGXsfl_78_idx < nRC_GXsfl_78 )
      {
         nGXsfl_78_idx = (int)(nGXsfl_78_idx+1) ;
         sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7829( ) ;
         httpContext.changePostValue( "Z47FacturaDetalleId_"+sGXsfl_78_idx, httpContext.cgiGet( "ZT_"+"Z47FacturaDetalleId_"+sGXsfl_78_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z47FacturaDetalleId_"+sGXsfl_78_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.factura", new String[] {}, new String[] {}) +"\">") ;
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
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z30FacturaId", GXutil.ltrim( localUtil.ntoc( Z30FacturaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z130FacturaEmision", localUtil.dtoc( Z130FacturaEmision, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z28EmpresaId", GXutil.ltrim( localUtil.ntoc( Z28EmpresaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z29TimbradoId", GXutil.ltrim( localUtil.ntoc( Z29TimbradoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z4ClienteId", GXutil.ltrim( localUtil.ntoc( Z4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z26CajeroId", GXutil.ltrim( localUtil.ntoc( Z26CajeroId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z31TipoFacturaId", GXutil.ltrim( localUtil.ntoc( Z31TipoFacturaId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_78", GXutil.ltrim( localUtil.ntoc( nGXsfl_78_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.factura", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Factura" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Factura", "") ;
   }

   public void initializeNonKey0R28( )
   {
      A130FacturaEmision = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A130FacturaEmision", localUtil.format(A130FacturaEmision, "99/99/99"));
      A28EmpresaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28EmpresaId), 11, 0));
      A29TimbradoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29TimbradoId), 11, 0));
      A4ClienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      A26CajeroId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CajeroId), 11, 0));
      A112CajeroNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", A112CajeroNombre);
      A31TipoFacturaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31TipoFacturaId), 11, 0));
      Z130FacturaEmision = GXutil.nullDate() ;
      Z28EmpresaId = 0 ;
      Z29TimbradoId = 0 ;
      Z4ClienteId = 0 ;
      Z26CajeroId = 0 ;
      Z31TipoFacturaId = 0 ;
   }

   public void initAll0R28( )
   {
      A30FacturaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A30FacturaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30FacturaId), 11, 0));
      initializeNonKey0R28( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0R29( )
   {
   }

   public void initAll0R29( )
   {
      A47FacturaDetalleId = 0 ;
      initializeNonKey0R29( ) ;
   }

   public void standaloneModalInsert0R29( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211110184", true, true);
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
      httpContext.AddJavascriptSource("factura.js", "?20241211110186", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties29( )
   {
      edtFacturaDetalleId_Enabled = defedtFacturaDetalleId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtFacturaDetalleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFacturaDetalleId_Enabled), 5, 0), !bGXsfl_78_Refreshing);
   }

   public void startgridcontrol78( )
   {
      Gridfactura_detalleContainer.AddObjectProperty("GridName", "Gridfactura_detalle");
      Gridfactura_detalleContainer.AddObjectProperty("Header", subGridfactura_detalle_Header);
      Gridfactura_detalleContainer.AddObjectProperty("Class", "Grid");
      Gridfactura_detalleContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("CmpContext", "");
      Gridfactura_detalleContainer.AddObjectProperty("InMasterPage", "false");
      Gridfactura_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridfactura_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A47FacturaDetalleId, (byte)(11), (byte)(0), ".", "")));
      Gridfactura_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtFacturaDetalleId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddColumnProperties(Gridfactura_detalleColumn);
      Gridfactura_detalleContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridfactura_detalleContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridfactura_detalle_Collapsed, (byte)(1), (byte)(0), ".", "")));
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
      edtFacturaId_Internalname = "FACTURAID" ;
      edtFacturaEmision_Internalname = "FACTURAEMISION" ;
      edtEmpresaId_Internalname = "EMPRESAID" ;
      edtTimbradoId_Internalname = "TIMBRADOID" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtCajeroId_Internalname = "CAJEROID" ;
      edtCajeroNombre_Internalname = "CAJERONOMBRE" ;
      edtTipoFacturaId_Internalname = "TIPOFACTURAID" ;
      lblTitledetalle_Internalname = "TITLEDETALLE" ;
      edtFacturaDetalleId_Internalname = "FACTURADETALLEID" ;
      divDetalletable_Internalname = "DETALLETABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridfactura_detalle_Internalname = "GRIDFACTURA_DETALLE" ;
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
      subGridfactura_detalle_Allowcollapsing = (byte)(0) ;
      subGridfactura_detalle_Allowselection = (byte)(0) ;
      subGridfactura_detalle_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Factura", "") );
      edtFacturaDetalleId_Jsonclick = "" ;
      subGridfactura_detalle_Class = "Grid" ;
      subGridfactura_detalle_Backcolorstyle = (byte)(0) ;
      edtFacturaDetalleId_Enabled = 1 ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtTipoFacturaId_Jsonclick = "" ;
      edtTipoFacturaId_Enabled = 1 ;
      edtCajeroNombre_Jsonclick = "" ;
      edtCajeroNombre_Enabled = 0 ;
      edtCajeroId_Jsonclick = "" ;
      edtCajeroId_Enabled = 1 ;
      edtClienteId_Jsonclick = "" ;
      edtClienteId_Enabled = 1 ;
      edtTimbradoId_Jsonclick = "" ;
      edtTimbradoId_Enabled = 1 ;
      edtEmpresaId_Jsonclick = "" ;
      edtEmpresaId_Enabled = 1 ;
      edtFacturaEmision_Jsonclick = "" ;
      edtFacturaEmision_Enabled = 1 ;
      edtFacturaId_Jsonclick = "" ;
      edtFacturaId_Enabled = 1 ;
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

   public void gxnrgridfactura_detalle_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_7829( ) ;
      while ( nGXsfl_78_idx <= nRC_GXsfl_78 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0R29( ) ;
         standaloneModal0R29( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0R29( ) ;
         nGXsfl_78_idx = (int)(nGXsfl_78_idx+1) ;
         sGXsfl_78_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_78_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7829( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridfactura_detalleContainer)) ;
      /* End function gxnrGridfactura_detalle_newrow */
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
      GX_FocusControl = edtFacturaEmision_Internalname ;
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

   public void valid_Facturaid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A130FacturaEmision", localUtil.format(A130FacturaEmision, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A28EmpresaId", GXutil.ltrim( localUtil.ntoc( A28EmpresaId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A29TimbradoId", GXutil.ltrim( localUtil.ntoc( A29TimbradoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A26CajeroId", GXutil.ltrim( localUtil.ntoc( A26CajeroId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A31TipoFacturaId", GXutil.ltrim( localUtil.ntoc( A31TipoFacturaId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", GXutil.rtrim( A112CajeroNombre));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z30FacturaId", GXutil.ltrim( localUtil.ntoc( Z30FacturaId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z130FacturaEmision", localUtil.format(Z130FacturaEmision, "99/99/99"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z28EmpresaId", GXutil.ltrim( localUtil.ntoc( Z28EmpresaId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z29TimbradoId", GXutil.ltrim( localUtil.ntoc( Z29TimbradoId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z4ClienteId", GXutil.ltrim( localUtil.ntoc( Z4ClienteId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z26CajeroId", GXutil.ltrim( localUtil.ntoc( Z26CajeroId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z31TipoFacturaId", GXutil.ltrim( localUtil.ntoc( Z31TipoFacturaId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z112CajeroNombre", GXutil.rtrim( Z112CajeroNombre));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Empresaid( )
   {
      /* Using cursor T000R30 */
      pr_default.execute(28, new Object[] {Long.valueOf(A28EmpresaId)});
      if ( (pr_default.getStatus(28) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRESAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEmpresaId_Internalname ;
      }
      pr_default.close(28);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Timbradoid( )
   {
      /* Using cursor T000R31 */
      pr_default.execute(29, new Object[] {Long.valueOf(A29TimbradoId)});
      if ( (pr_default.getStatus(29) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Timbrado", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIMBRADOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTimbradoId_Internalname ;
      }
      pr_default.close(29);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Clienteid( )
   {
      /* Using cursor T000R32 */
      pr_default.execute(30, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(30) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
      }
      pr_default.close(30);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Cajeroid( )
   {
      /* Using cursor T000R23 */
      pr_default.execute(21, new Object[] {Long.valueOf(A26CajeroId)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cajero", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CAJEROID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCajeroId_Internalname ;
      }
      A112CajeroNombre = T000R23_A112CajeroNombre[0] ;
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A112CajeroNombre", GXutil.rtrim( A112CajeroNombre));
   }

   public void valid_Tipofacturaid( )
   {
      /* Using cursor T000R33 */
      pr_default.execute(31, new Object[] {Long.valueOf(A31TipoFacturaId)});
      if ( (pr_default.getStatus(31) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Factura", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOFACTURAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoFacturaId_Internalname ;
      }
      pr_default.close(31);
      dynload_actions( ) ;
      /*  Sending validation outputs */
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
      setEventMetadata("VALID_FACTURAID","{handler:'valid_Facturaid',iparms:[{av:'A30FacturaId',fld:'FACTURAID',pic:'ZZZZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_FACTURAID",",oparms:[{av:'A130FacturaEmision',fld:'FACTURAEMISION',pic:''},{av:'A28EmpresaId',fld:'EMPRESAID',pic:'ZZZZZZZZZZ9'},{av:'A29TimbradoId',fld:'TIMBRADOID',pic:'ZZZZZZZZZZ9'},{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'A26CajeroId',fld:'CAJEROID',pic:'ZZZZZZZZZZ9'},{av:'A31TipoFacturaId',fld:'TIPOFACTURAID',pic:'ZZZZZZZZZZ9'},{av:'A112CajeroNombre',fld:'CAJERONOMBRE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z30FacturaId'},{av:'Z130FacturaEmision'},{av:'Z28EmpresaId'},{av:'Z29TimbradoId'},{av:'Z4ClienteId'},{av:'Z26CajeroId'},{av:'Z31TipoFacturaId'},{av:'Z112CajeroNombre'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_FACTURAEMISION","{handler:'valid_Facturaemision',iparms:[]");
      setEventMetadata("VALID_FACTURAEMISION",",oparms:[]}");
      setEventMetadata("VALID_EMPRESAID","{handler:'valid_Empresaid',iparms:[{av:'A28EmpresaId',fld:'EMPRESAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_EMPRESAID",",oparms:[]}");
      setEventMetadata("VALID_TIMBRADOID","{handler:'valid_Timbradoid',iparms:[{av:'A29TimbradoId',fld:'TIMBRADOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_TIMBRADOID",",oparms:[]}");
      setEventMetadata("VALID_CLIENTEID","{handler:'valid_Clienteid',iparms:[{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_CLIENTEID",",oparms:[]}");
      setEventMetadata("VALID_CAJEROID","{handler:'valid_Cajeroid',iparms:[{av:'A26CajeroId',fld:'CAJEROID',pic:'ZZZZZZZZZZ9'},{av:'A112CajeroNombre',fld:'CAJERONOMBRE',pic:''}]");
      setEventMetadata("VALID_CAJEROID",",oparms:[{av:'A112CajeroNombre',fld:'CAJERONOMBRE',pic:''}]}");
      setEventMetadata("VALID_TIPOFACTURAID","{handler:'valid_Tipofacturaid',iparms:[{av:'A31TipoFacturaId',fld:'TIPOFACTURAID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_TIPOFACTURAID",",oparms:[]}");
      setEventMetadata("VALID_FACTURADETALLEID","{handler:'valid_Facturadetalleid',iparms:[]");
      setEventMetadata("VALID_FACTURADETALLEID",",oparms:[]}");
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
      return "factura_Execute";
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
      pr_default.close(28);
      pr_default.close(29);
      pr_default.close(30);
      pr_default.close(21);
      pr_default.close(31);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z130FacturaEmision = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      Gx_mode = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A130FacturaEmision = GXutil.nullDate() ;
      A112CajeroNombre = "" ;
      lblTitledetalle_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridfactura_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode29 = "" ;
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      Z112CajeroNombre = "" ;
      T000R11_A30FacturaId = new long[1] ;
      T000R11_A130FacturaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      T000R11_A112CajeroNombre = new String[] {""} ;
      T000R11_A28EmpresaId = new long[1] ;
      T000R11_A29TimbradoId = new long[1] ;
      T000R11_A4ClienteId = new long[1] ;
      T000R11_A26CajeroId = new long[1] ;
      T000R11_A31TipoFacturaId = new long[1] ;
      T000R6_A28EmpresaId = new long[1] ;
      T000R7_A29TimbradoId = new long[1] ;
      T000R8_A4ClienteId = new long[1] ;
      T000R9_A112CajeroNombre = new String[] {""} ;
      T000R10_A31TipoFacturaId = new long[1] ;
      T000R12_A28EmpresaId = new long[1] ;
      T000R13_A29TimbradoId = new long[1] ;
      T000R14_A4ClienteId = new long[1] ;
      T000R15_A112CajeroNombre = new String[] {""} ;
      T000R16_A31TipoFacturaId = new long[1] ;
      T000R17_A30FacturaId = new long[1] ;
      T000R5_A30FacturaId = new long[1] ;
      T000R5_A130FacturaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      T000R5_A28EmpresaId = new long[1] ;
      T000R5_A29TimbradoId = new long[1] ;
      T000R5_A4ClienteId = new long[1] ;
      T000R5_A26CajeroId = new long[1] ;
      T000R5_A31TipoFacturaId = new long[1] ;
      sMode28 = "" ;
      T000R18_A30FacturaId = new long[1] ;
      T000R19_A30FacturaId = new long[1] ;
      T000R4_A30FacturaId = new long[1] ;
      T000R4_A130FacturaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      T000R4_A28EmpresaId = new long[1] ;
      T000R4_A29TimbradoId = new long[1] ;
      T000R4_A4ClienteId = new long[1] ;
      T000R4_A26CajeroId = new long[1] ;
      T000R4_A31TipoFacturaId = new long[1] ;
      T000R23_A112CajeroNombre = new String[] {""} ;
      T000R24_A30FacturaId = new long[1] ;
      T000R25_A30FacturaId = new long[1] ;
      T000R25_A47FacturaDetalleId = new long[1] ;
      T000R26_A30FacturaId = new long[1] ;
      T000R26_A47FacturaDetalleId = new long[1] ;
      T000R3_A30FacturaId = new long[1] ;
      T000R3_A47FacturaDetalleId = new long[1] ;
      T000R2_A30FacturaId = new long[1] ;
      T000R2_A47FacturaDetalleId = new long[1] ;
      T000R29_A30FacturaId = new long[1] ;
      T000R29_A47FacturaDetalleId = new long[1] ;
      Gridfactura_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridfactura_detalle_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridfactura_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      ZZ130FacturaEmision = GXutil.nullDate() ;
      ZZ112CajeroNombre = "" ;
      T000R30_A28EmpresaId = new long[1] ;
      T000R31_A29TimbradoId = new long[1] ;
      T000R32_A4ClienteId = new long[1] ;
      T000R33_A31TipoFacturaId = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.factura__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.factura__default(),
         new Object[] {
             new Object[] {
            T000R2_A30FacturaId, T000R2_A47FacturaDetalleId
            }
            , new Object[] {
            T000R3_A30FacturaId, T000R3_A47FacturaDetalleId
            }
            , new Object[] {
            T000R4_A30FacturaId, T000R4_A130FacturaEmision, T000R4_A28EmpresaId, T000R4_A29TimbradoId, T000R4_A4ClienteId, T000R4_A26CajeroId, T000R4_A31TipoFacturaId
            }
            , new Object[] {
            T000R5_A30FacturaId, T000R5_A130FacturaEmision, T000R5_A28EmpresaId, T000R5_A29TimbradoId, T000R5_A4ClienteId, T000R5_A26CajeroId, T000R5_A31TipoFacturaId
            }
            , new Object[] {
            T000R6_A28EmpresaId
            }
            , new Object[] {
            T000R7_A29TimbradoId
            }
            , new Object[] {
            T000R8_A4ClienteId
            }
            , new Object[] {
            T000R9_A112CajeroNombre
            }
            , new Object[] {
            T000R10_A31TipoFacturaId
            }
            , new Object[] {
            T000R11_A30FacturaId, T000R11_A130FacturaEmision, T000R11_A112CajeroNombre, T000R11_A28EmpresaId, T000R11_A29TimbradoId, T000R11_A4ClienteId, T000R11_A26CajeroId, T000R11_A31TipoFacturaId
            }
            , new Object[] {
            T000R12_A28EmpresaId
            }
            , new Object[] {
            T000R13_A29TimbradoId
            }
            , new Object[] {
            T000R14_A4ClienteId
            }
            , new Object[] {
            T000R15_A112CajeroNombre
            }
            , new Object[] {
            T000R16_A31TipoFacturaId
            }
            , new Object[] {
            T000R17_A30FacturaId
            }
            , new Object[] {
            T000R18_A30FacturaId
            }
            , new Object[] {
            T000R19_A30FacturaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000R23_A112CajeroNombre
            }
            , new Object[] {
            T000R24_A30FacturaId
            }
            , new Object[] {
            T000R25_A30FacturaId, T000R25_A47FacturaDetalleId
            }
            , new Object[] {
            T000R26_A30FacturaId, T000R26_A47FacturaDetalleId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000R29_A30FacturaId, T000R29_A47FacturaDetalleId
            }
            , new Object[] {
            T000R30_A28EmpresaId
            }
            , new Object[] {
            T000R31_A29TimbradoId
            }
            , new Object[] {
            T000R32_A4ClienteId
            }
            , new Object[] {
            T000R33_A31TipoFacturaId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridfactura_detalle_Backcolorstyle ;
   private byte subGridfactura_detalle_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridfactura_detalle_Allowselection ;
   private byte subGridfactura_detalle_Allowhovering ;
   private byte subGridfactura_detalle_Allowcollapsing ;
   private byte subGridfactura_detalle_Collapsed ;
   private short nRcdDeleted_29 ;
   private short nRcdExists_29 ;
   private short nIsMod_29 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount29 ;
   private short RcdFound29 ;
   private short nBlankRcdUsr29 ;
   private short RcdFound28 ;
   private short nIsDirty_28 ;
   private short nIsDirty_29 ;
   private int nRC_GXsfl_78 ;
   private int nGXsfl_78_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtFacturaId_Enabled ;
   private int edtFacturaEmision_Enabled ;
   private int edtEmpresaId_Enabled ;
   private int edtTimbradoId_Enabled ;
   private int edtClienteId_Enabled ;
   private int edtCajeroId_Enabled ;
   private int edtCajeroNombre_Enabled ;
   private int edtTipoFacturaId_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtFacturaDetalleId_Enabled ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridfactura_detalle_Backcolor ;
   private int subGridfactura_detalle_Allbackcolor ;
   private int defedtFacturaDetalleId_Enabled ;
   private int idxLst ;
   private int subGridfactura_detalle_Selectedindex ;
   private int subGridfactura_detalle_Selectioncolor ;
   private int subGridfactura_detalle_Hoveringcolor ;
   private long Z30FacturaId ;
   private long Z28EmpresaId ;
   private long Z29TimbradoId ;
   private long Z4ClienteId ;
   private long Z26CajeroId ;
   private long Z31TipoFacturaId ;
   private long Z47FacturaDetalleId ;
   private long A28EmpresaId ;
   private long A29TimbradoId ;
   private long A4ClienteId ;
   private long A26CajeroId ;
   private long A31TipoFacturaId ;
   private long A30FacturaId ;
   private long GRIDFACTURA_DETALLE_nFirstRecordOnPage ;
   private long A47FacturaDetalleId ;
   private long ZZ30FacturaId ;
   private long ZZ28EmpresaId ;
   private long ZZ29TimbradoId ;
   private long ZZ4ClienteId ;
   private long ZZ26CajeroId ;
   private long ZZ31TipoFacturaId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtFacturaId_Internalname ;
   private String sGXsfl_78_idx="0001" ;
   private String Gx_mode ;
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
   private String edtFacturaId_Jsonclick ;
   private String edtFacturaEmision_Internalname ;
   private String edtFacturaEmision_Jsonclick ;
   private String edtEmpresaId_Internalname ;
   private String edtEmpresaId_Jsonclick ;
   private String edtTimbradoId_Internalname ;
   private String edtTimbradoId_Jsonclick ;
   private String edtClienteId_Internalname ;
   private String edtClienteId_Jsonclick ;
   private String edtCajeroId_Internalname ;
   private String edtCajeroId_Jsonclick ;
   private String edtCajeroNombre_Internalname ;
   private String A112CajeroNombre ;
   private String edtCajeroNombre_Jsonclick ;
   private String edtTipoFacturaId_Internalname ;
   private String edtTipoFacturaId_Jsonclick ;
   private String divDetalletable_Internalname ;
   private String lblTitledetalle_Internalname ;
   private String lblTitledetalle_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String sMode29 ;
   private String edtFacturaDetalleId_Internalname ;
   private String sStyleString ;
   private String subGridfactura_detalle_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String Z112CajeroNombre ;
   private String sMode28 ;
   private String sGXsfl_78_fel_idx="0001" ;
   private String subGridfactura_detalle_Class ;
   private String subGridfactura_detalle_Linesclass ;
   private String ROClassString ;
   private String edtFacturaDetalleId_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridfactura_detalle_Header ;
   private String ZZ112CajeroNombre ;
   private java.util.Date Z130FacturaEmision ;
   private java.util.Date A130FacturaEmision ;
   private java.util.Date ZZ130FacturaEmision ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_78_Refreshing=false ;
   private boolean Gx_longc ;
   private com.genexus.webpanels.GXWebGrid Gridfactura_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridfactura_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridfactura_detalleColumn ;
   private IDataStoreProvider pr_default ;
   private long[] T000R11_A30FacturaId ;
   private java.util.Date[] T000R11_A130FacturaEmision ;
   private String[] T000R11_A112CajeroNombre ;
   private long[] T000R11_A28EmpresaId ;
   private long[] T000R11_A29TimbradoId ;
   private long[] T000R11_A4ClienteId ;
   private long[] T000R11_A26CajeroId ;
   private long[] T000R11_A31TipoFacturaId ;
   private long[] T000R6_A28EmpresaId ;
   private long[] T000R7_A29TimbradoId ;
   private long[] T000R8_A4ClienteId ;
   private String[] T000R9_A112CajeroNombre ;
   private long[] T000R10_A31TipoFacturaId ;
   private long[] T000R12_A28EmpresaId ;
   private long[] T000R13_A29TimbradoId ;
   private long[] T000R14_A4ClienteId ;
   private String[] T000R15_A112CajeroNombre ;
   private long[] T000R16_A31TipoFacturaId ;
   private long[] T000R17_A30FacturaId ;
   private long[] T000R5_A30FacturaId ;
   private java.util.Date[] T000R5_A130FacturaEmision ;
   private long[] T000R5_A28EmpresaId ;
   private long[] T000R5_A29TimbradoId ;
   private long[] T000R5_A4ClienteId ;
   private long[] T000R5_A26CajeroId ;
   private long[] T000R5_A31TipoFacturaId ;
   private long[] T000R18_A30FacturaId ;
   private long[] T000R19_A30FacturaId ;
   private long[] T000R4_A30FacturaId ;
   private java.util.Date[] T000R4_A130FacturaEmision ;
   private long[] T000R4_A28EmpresaId ;
   private long[] T000R4_A29TimbradoId ;
   private long[] T000R4_A4ClienteId ;
   private long[] T000R4_A26CajeroId ;
   private long[] T000R4_A31TipoFacturaId ;
   private String[] T000R23_A112CajeroNombre ;
   private long[] T000R24_A30FacturaId ;
   private long[] T000R25_A30FacturaId ;
   private long[] T000R25_A47FacturaDetalleId ;
   private long[] T000R26_A30FacturaId ;
   private long[] T000R26_A47FacturaDetalleId ;
   private long[] T000R3_A30FacturaId ;
   private long[] T000R3_A47FacturaDetalleId ;
   private long[] T000R2_A30FacturaId ;
   private long[] T000R2_A47FacturaDetalleId ;
   private long[] T000R29_A30FacturaId ;
   private long[] T000R29_A47FacturaDetalleId ;
   private long[] T000R30_A28EmpresaId ;
   private long[] T000R31_A29TimbradoId ;
   private long[] T000R32_A4ClienteId ;
   private long[] T000R33_A31TipoFacturaId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class factura__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class factura__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000R2", "SELECT [FacturaId], [FacturaDetalleId] FROM [FacturaDetalle] WITH (UPDLOCK) WHERE [FacturaId] = ? AND [FacturaDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R3", "SELECT [FacturaId], [FacturaDetalleId] FROM [FacturaDetalle] WHERE [FacturaId] = ? AND [FacturaDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R4", "SELECT [FacturaId], [FacturaEmision], [EmpresaId], [TimbradoId], [ClienteId], [CajeroId], [TipoFacturaId] FROM [Factura] WITH (UPDLOCK) WHERE [FacturaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R5", "SELECT [FacturaId], [FacturaEmision], [EmpresaId], [TimbradoId], [ClienteId], [CajeroId], [TipoFacturaId] FROM [Factura] WHERE [FacturaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R6", "SELECT [EmpresaId] FROM [Empresa] WHERE [EmpresaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R7", "SELECT [TimbradoId] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R8", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R9", "SELECT [CajeroNombre] FROM [Cajero] WHERE [CajeroId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R10", "SELECT [TipoFacturaId] FROM [TipoFactura] WHERE [TipoFacturaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R11", "SELECT TM1.[FacturaId], TM1.[FacturaEmision], T2.[CajeroNombre], TM1.[EmpresaId], TM1.[TimbradoId], TM1.[ClienteId], TM1.[CajeroId], TM1.[TipoFacturaId] FROM ([Factura] TM1 INNER JOIN [Cajero] T2 ON T2.[CajeroId] = TM1.[CajeroId]) WHERE TM1.[FacturaId] = ? ORDER BY TM1.[FacturaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R12", "SELECT [EmpresaId] FROM [Empresa] WHERE [EmpresaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R13", "SELECT [TimbradoId] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R14", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R15", "SELECT [CajeroNombre] FROM [Cajero] WHERE [CajeroId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R16", "SELECT [TipoFacturaId] FROM [TipoFactura] WHERE [TipoFacturaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R17", "SELECT [FacturaId] FROM [Factura] WHERE [FacturaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R18", "SELECT TOP 1 [FacturaId] FROM [Factura] WHERE ( [FacturaId] > ?) ORDER BY [FacturaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000R19", "SELECT TOP 1 [FacturaId] FROM [Factura] WHERE ( [FacturaId] < ?) ORDER BY [FacturaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000R20", "INSERT INTO [Factura]([FacturaId], [FacturaEmision], [EmpresaId], [TimbradoId], [ClienteId], [CajeroId], [TipoFacturaId]) VALUES(?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000R21", "UPDATE [Factura] SET [FacturaEmision]=?, [EmpresaId]=?, [TimbradoId]=?, [ClienteId]=?, [CajeroId]=?, [TipoFacturaId]=?  WHERE [FacturaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000R22", "DELETE FROM [Factura]  WHERE [FacturaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000R23", "SELECT [CajeroNombre] FROM [Cajero] WHERE [CajeroId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R24", "SELECT [FacturaId] FROM [Factura] ORDER BY [FacturaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R25", "SELECT [FacturaId], [FacturaDetalleId] FROM [FacturaDetalle] WHERE [FacturaId] = ? and [FacturaDetalleId] = ? ORDER BY [FacturaId], [FacturaDetalleId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R26", "SELECT [FacturaId], [FacturaDetalleId] FROM [FacturaDetalle] WHERE [FacturaId] = ? AND [FacturaDetalleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000R27", "INSERT INTO [FacturaDetalle]([FacturaId], [FacturaDetalleId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000R28", "DELETE FROM [FacturaDetalle]  WHERE [FacturaId] = ? AND [FacturaDetalleId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000R29", "SELECT [FacturaId], [FacturaDetalleId] FROM [FacturaDetalle] WHERE [FacturaId] = ? ORDER BY [FacturaId], [FacturaDetalleId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R30", "SELECT [EmpresaId] FROM [Empresa] WHERE [EmpresaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R31", "SELECT [TimbradoId] FROM [Timbrado] WHERE [TimbradoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R32", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000R33", "SELECT [TipoFacturaId] FROM [TipoFactura] WHERE [TipoFacturaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 11 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 17 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 23 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 24 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 27 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 28 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 29 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 31 :
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               return;
            case 19 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 21 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 23 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 24 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 25 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 26 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 27 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 28 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 29 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 31 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

