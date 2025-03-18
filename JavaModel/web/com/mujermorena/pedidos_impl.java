package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pedidos_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"PEDIDOSID") == 0 )
      {
         AV18Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asapedidosid1647( AV18Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
      {
         A51PedidosID = GXutil.lval( httpContext.GetPar( "PedidosID")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_10( A51PedidosID) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_7") == 0 )
      {
         A4ClienteId = GXutil.lval( httpContext.GetPar( "ClienteId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_7( A4ClienteId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A9TipoPagoId = GXutil.lval( httpContext.GetPar( "TipoPagoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A9TipoPagoId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
      {
         A283OpcionEnvioId = GXutil.lval( httpContext.GetPar( "OpcionEnvioId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A283OpcionEnvioId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A283OpcionEnvioId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A13ArticuloId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A18ImpuestoId = GXutil.lval( httpContext.GetPar( "ImpuestoId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A18ImpuestoId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_detalle") == 0 )
      {
         gxnrgridlevel_detalle_newrow_invoke( ) ;
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Pedidos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPedidosID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_detalle_newrow_invoke( )
   {
      nRC_GXsfl_76 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_76"))) ;
      nGXsfl_76_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_76_idx"))) ;
      sGXsfl_76_idx = httpContext.GetPar( "sGXsfl_76_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_detalle_newrow( ) ;
      /* End function gxnrGridlevel_detalle_newrow_invoke */
   }

   public pedidos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pedidos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pedidos_impl.class ));
   }

   public pedidos_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPedidosEstado = new HTMLChoice();
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
      if ( cmbPedidosEstado.getItemCount() > 0 )
      {
         A247PedidosEstado = cmbPedidosEstado.getValidValue(A247PedidosEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", A247PedidosEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPedidosEstado.setValue( GXutil.rtrim( A247PedidosEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPedidosEstado.getInternalname(), "Values", cmbPedidosEstado.ToJavascriptSource(), true);
      }
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
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
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Pedidos", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Pedidos.htm");
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
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "CellMarginTop10", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPedidosID_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPedidosID_Internalname, httpContext.getMessage( "ID", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPedidosID_Internalname, GXutil.ltrim( localUtil.ntoc( A51PedidosID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPedidosID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A51PedidosID), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A51PedidosID), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPedidosID_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPedidosID_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteId_Internalname, httpContext.getMessage( "Cliente Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtClienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtClienteId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPedidosFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPedidosFecha_Internalname, httpContext.getMessage( "Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtPedidosFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPedidosFecha_Internalname, localUtil.format(A246PedidosFecha, "99/99/99"), localUtil.format( A246PedidosFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPedidosFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtPedidosFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtPedidosFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPedidosFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Pedidos.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPedidosEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, cmbPedidosEstado.getInternalname(), httpContext.getMessage( "Estado", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      /* ComboBox */
      com.mujermorena.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPedidosEstado, cmbPedidosEstado.getInternalname(), GXutil.rtrim( A247PedidosEstado), 1, cmbPedidosEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPedidosEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRealWidth", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "", true, (byte)(0), "HLP_Pedidos.htm");
      cmbPedidosEstado.setValue( GXutil.rtrim( A247PedidosEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPedidosEstado.getInternalname(), "Values", cmbPedidosEstado.ToJavascriptSource(), true);
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPedidosSubTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPedidosSubTotal_Internalname, httpContext.getMessage( "Sub Total", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPedidosSubTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A250PedidosSubTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPedidosSubTotal_Enabled!=0) ? localUtil.format( A250PedidosSubTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A250PedidosSubTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPedidosSubTotal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPedidosSubTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPedidosTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPedidosTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtPedidosTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A248PedidosTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtPedidosTotal_Enabled!=0) ? localUtil.format( A248PedidosTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A248PedidosTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPedidosTotal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtPedidosTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoPagoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoPagoId_Internalname, httpContext.getMessage( "Tipo Pago Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoPagoId_Internalname, GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoPagoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoPagoId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTipoPagoId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpcionEnvioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtOpcionEnvioId_Internalname, httpContext.getMessage( "Opcion Envio Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtOpcionEnvioId_Internalname, GXutil.ltrim( localUtil.ntoc( A283OpcionEnvioId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtOpcionEnvioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A283OpcionEnvioId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A283OpcionEnvioId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpcionEnvioId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtOpcionEnvioId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpcionEnvioDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtOpcionEnvioDescripcion_Internalname, httpContext.getMessage( "Opcion Envio Descripcion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtOpcionEnvioDescripcion_Internalname, A284OpcionEnvioDescripcion, GXutil.rtrim( localUtil.format( A284OpcionEnvioDescripcion, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpcionEnvioDescripcion_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtOpcionEnvioDescripcion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPedidosComprobanteObs_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtPedidosComprobanteObs_Internalname, httpContext.getMessage( "Comprobante Obs", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtPedidosComprobanteObs_Internalname, A295PedidosComprobanteObs, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,65);\"", (short)(0), 1, edtPedidosComprobanteObs_Enabled, 0, 80, "chr", 7, "row", (byte)(0), StyleString, ClassString, "", "", "512", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgPedidosImagenComprobante_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, "", httpContext.getMessage( "Imagen Comprobante", ""), " AttributeLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A296PedidosImagenComprobante_IsBlob = (boolean)(((GXutil.strcmp("", A296PedidosImagenComprobante)==0)&&(GXutil.strcmp("", A40000PedidosImagenComprobante_GXI)==0))||!(GXutil.strcmp("", A296PedidosImagenComprobante)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.getResourceRelative(A296PedidosImagenComprobante)) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgPedidosImagenComprobante_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgPedidosImagenComprobante_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,70);\"", "", "", "", 0, A296PedidosImagenComprobante_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Pedidos.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "URL", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.getResourceRelative(A296PedidosImagenComprobante)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "IsBlob", GXutil.booltostr( A296PedidosImagenComprobante_IsBlob), true);
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, divTableleaflevel_detalle_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell GridFixedColumnBorders", "left", "top", "", "", "div");
      gxdraw_gridlevel_detalle( ) ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pedidos.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pedidos.htm");
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

   public void gxdraw_gridlevel_detalle( )
   {
      /*  Grid Control  */
      startgridcontrol76( ) ;
      nGXsfl_76_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount48 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_48 = (short)(1) ;
            scanStart1648( ) ;
            while ( RcdFound48 != 0 )
            {
               init_level_properties48( ) ;
               getByPrimaryKey1648( ) ;
               addRow1648( ) ;
               scanNext1648( ) ;
            }
            scanEnd1648( ) ;
            nBlankRcdCount48 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B248PedidosTotal = A248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         B250PedidosSubTotal = A250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         standaloneNotModal1648( ) ;
         standaloneModal1648( ) ;
         sMode48 = Gx_mode ;
         while ( nGXsfl_76_idx < nRC_GXsfl_76 )
         {
            bGXsfl_76_Refreshing = true ;
            readRow1648( ) ;
            edtPedidosDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLEID_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtImpuestoPorcentaje_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "IMPUESTOPORCENTAJE_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtArticuloPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOPRECIOVENTA_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtPedidosDetalleCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleCantidad_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtPedidosDetalleTotal_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLETOTAL_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleTotal_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            edtPedidosDetalleTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLETALLAID_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleTallaID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
            if ( ( nRcdExists_48 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1648( ) ;
            }
            sendRow1648( ) ;
            bGXsfl_76_Refreshing = false ;
         }
         Gx_mode = sMode48 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A248PedidosTotal = B248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         A250PedidosSubTotal = B250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount48 = (short)(5) ;
         nRcdExists_48 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1648( ) ;
            while ( RcdFound48 != 0 )
            {
               sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_7648( ) ;
               init_level_properties48( ) ;
               standaloneNotModal1648( ) ;
               getByPrimaryKey1648( ) ;
               standaloneModal1648( ) ;
               addRow1648( ) ;
               scanNext1648( ) ;
            }
            scanEnd1648( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode48 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_7648( ) ;
      initAll1648( ) ;
      init_level_properties48( ) ;
      B248PedidosTotal = A248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      B250PedidosSubTotal = A250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      nRcdExists_48 = (short)(0) ;
      nIsMod_48 = (short)(0) ;
      nRcdDeleted_48 = (short)(0) ;
      nBlankRcdCount48 = (short)(nBlankRcdUsr48+nBlankRcdCount48) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount48 > 0 )
      {
         standaloneNotModal1648( ) ;
         standaloneModal1648( ) ;
         addRow1648( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtPedidosDetalleID_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount48 = (short)(nBlankRcdCount48-1) ;
      }
      Gx_mode = sMode48 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      A248PedidosTotal = B248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      A250PedidosSubTotal = B250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_detalleContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_detalle", Gridlevel_detalleContainer, subGridlevel_detalle_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_detalleContainerData", Gridlevel_detalleContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_detalleContainerData"+"V", Gridlevel_detalleContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_detalleContainerData"+"V"+"\" value='"+Gridlevel_detalleContainer.GridValuesHidden()+"'/>") ;
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
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11162 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z51PedidosID = localUtil.ctol( httpContext.cgiGet( "Z51PedidosID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z246PedidosFecha = localUtil.ctod( httpContext.cgiGet( "Z246PedidosFecha"), 0) ;
            Z247PedidosEstado = httpContext.cgiGet( "Z247PedidosEstado") ;
            Z295PedidosComprobanteObs = httpContext.cgiGet( "Z295PedidosComprobanteObs") ;
            Z312PedidosUbicacion = httpContext.cgiGet( "Z312PedidosUbicacion") ;
            Z4ClienteId = localUtil.ctol( httpContext.cgiGet( "Z4ClienteId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z9TipoPagoId = localUtil.ctol( httpContext.cgiGet( "Z9TipoPagoId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z283OpcionEnvioId = localUtil.ctol( httpContext.cgiGet( "Z283OpcionEnvioId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            A312PedidosUbicacion = httpContext.cgiGet( "Z312PedidosUbicacion") ;
            O248PedidosTotal = localUtil.ctond( httpContext.cgiGet( "O248PedidosTotal")) ;
            O250PedidosSubTotal = localUtil.ctond( httpContext.cgiGet( "O250PedidosSubTotal")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_76 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_76"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV18Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A40000PedidosImagenComprobante_GXI = httpContext.cgiGet( "PEDIDOSIMAGENCOMPROBANTE_GXI") ;
            A312PedidosUbicacion = httpContext.cgiGet( "PEDIDOSUBICACION") ;
            A18ImpuestoId = localUtil.ctol( httpContext.cgiGet( "IMPUESTOID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PEDIDOSID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPedidosID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A51PedidosID = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
            }
            else
            {
               A51PedidosID = localUtil.ctol( httpContext.cgiGet( edtPedidosID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
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
            if ( localUtil.vcdate( httpContext.cgiGet( edtPedidosFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "PEDIDOSFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPedidosFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A246PedidosFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A246PedidosFecha", localUtil.format(A246PedidosFecha, "99/99/99"));
            }
            else
            {
               A246PedidosFecha = localUtil.ctod( httpContext.cgiGet( edtPedidosFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A246PedidosFecha", localUtil.format(A246PedidosFecha, "99/99/99"));
            }
            cmbPedidosEstado.setName( cmbPedidosEstado.getInternalname() );
            cmbPedidosEstado.setValue( httpContext.cgiGet( cmbPedidosEstado.getInternalname()) );
            A247PedidosEstado = httpContext.cgiGet( cmbPedidosEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", A247PedidosEstado);
            A250PedidosSubTotal = localUtil.ctond( httpContext.cgiGet( edtPedidosSubTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            A248PedidosTotal = localUtil.ctond( httpContext.cgiGet( edtPedidosTotal_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "TIPOPAGOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtTipoPagoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A9TipoPagoId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
            }
            else
            {
               A9TipoPagoId = localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtOpcionEnvioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtOpcionEnvioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "OPCIONENVIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtOpcionEnvioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A283OpcionEnvioId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A283OpcionEnvioId), 11, 0));
            }
            else
            {
               A283OpcionEnvioId = localUtil.ctol( httpContext.cgiGet( edtOpcionEnvioId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A283OpcionEnvioId), 11, 0));
            }
            A284OpcionEnvioDescripcion = httpContext.cgiGet( edtOpcionEnvioDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
            A295PedidosComprobanteObs = httpContext.cgiGet( edtPedidosComprobanteObs_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A295PedidosComprobanteObs", A295PedidosComprobanteObs);
            A296PedidosImagenComprobante = httpContext.cgiGet( imgPedidosImagenComprobante_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A296PedidosImagenComprobante", A296PedidosImagenComprobante);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A296PedidosImagenComprobante ;
            GXv_char2[0] = A40000PedidosImagenComprobante_GXI ;
            httpContext.getMultimediaValue(imgPedidosImagenComprobante_Internalname, GXv_char1, GXv_char2);
            pedidos_impl.this.A296PedidosImagenComprobante = GXv_char1[0] ;
            pedidos_impl.this.A40000PedidosImagenComprobante_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Pedidos");
            forbiddenHiddens.add("PedidosUbicacion", GXutil.rtrim( localUtil.format( A312PedidosUbicacion, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A51PedidosID != Z51PedidosID ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("pedidos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
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
               A51PedidosID = GXutil.lval( httpContext.GetPar( "PedidosID")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons_dsp( ) ;
               standaloneModal( ) ;
            }
            else
            {
               getEqualNoModal( ) ;
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
                        e11162 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12162 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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
         /* Execute user event: After Trn */
         e12162 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1647( ) ;
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
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtntrn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
      }
      disableAttributes1647( ) ;
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

   public void confirm_1648( )
   {
      s248PedidosTotal = O248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      s250PedidosSubTotal = O250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      nGXsfl_76_idx = 0 ;
      while ( nGXsfl_76_idx < nRC_GXsfl_76 )
      {
         readRow1648( ) ;
         if ( ( nRcdExists_48 != 0 ) || ( nIsMod_48 != 0 ) )
         {
            getKey1648( ) ;
            if ( ( nRcdExists_48 == 0 ) && ( nRcdDeleted_48 == 0 ) )
            {
               if ( RcdFound48 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1648( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1648( ) ;
                     closeExtendedTableCursors1648( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                     O248PedidosTotal = A248PedidosTotal ;
                     httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
                     O250PedidosSubTotal = A250PedidosSubTotal ;
                     httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
                  }
               }
               else
               {
                  GXCCtl = "PEDIDOSDETALLEID_" + sGXsfl_76_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPedidosDetalleID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound48 != 0 )
               {
                  if ( nRcdDeleted_48 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1648( ) ;
                     load1648( ) ;
                     beforeValidate1648( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1648( ) ;
                        O248PedidosTotal = A248PedidosTotal ;
                        httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
                        O250PedidosSubTotal = A250PedidosSubTotal ;
                        httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
                     }
                  }
                  else
                  {
                     if ( nIsMod_48 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1648( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1648( ) ;
                           closeExtendedTableCursors1648( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                           O248PedidosTotal = A248PedidosTotal ;
                           httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
                           O250PedidosSubTotal = A250PedidosSubTotal ;
                           httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_48 == 0 )
                  {
                     GXCCtl = "PEDIDOSDETALLEID_" + sGXsfl_76_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPedidosDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtPedidosDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A52PedidosDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtPedidosDetalleCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A245PedidosDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtPedidosDetalleTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A249PedidosDetalleTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtPedidosDetalleTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A293PedidosDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z52PedidosDetalleID_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z52PedidosDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z293PedidosDetalleTallaID_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z293PedidosDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z245PedidosDetalleCantidad_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z245PedidosDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T249PedidosDetalleTotal_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( O249PedidosDetalleTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_48_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_48_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_48_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_48 != 0 )
         {
            httpContext.changePostValue( "PEDIDOSDETALLEID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "IMPUESTOPORCENTAJE_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOPRECIOVENTA_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PEDIDOSDETALLETOTAL_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PEDIDOSDETALLETALLAID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      O248PedidosTotal = s248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      O250PedidosSubTotal = s250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption160( )
   {
   }

   public void e11162( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_char3 = AV15CajaEstado ;
      GXv_char2[0] = GXt_char3 ;
      new com.mujermorena.validarcajaabierta(remoteHandle, context).execute( GXv_char2) ;
      pedidos_impl.this.GXt_char3 = GXv_char2[0] ;
      AV15CajaEstado = GXt_char3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15CajaEstado", AV15CajaEstado);
   }

   public void e12162( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1647( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z246PedidosFecha = T00167_A246PedidosFecha[0] ;
            Z247PedidosEstado = T00167_A247PedidosEstado[0] ;
            Z295PedidosComprobanteObs = T00167_A295PedidosComprobanteObs[0] ;
            Z312PedidosUbicacion = T00167_A312PedidosUbicacion[0] ;
            Z4ClienteId = T00167_A4ClienteId[0] ;
            Z9TipoPagoId = T00167_A9TipoPagoId[0] ;
            Z283OpcionEnvioId = T00167_A283OpcionEnvioId[0] ;
         }
         else
         {
            Z246PedidosFecha = A246PedidosFecha ;
            Z247PedidosEstado = A247PedidosEstado ;
            Z295PedidosComprobanteObs = A295PedidosComprobanteObs ;
            Z312PedidosUbicacion = A312PedidosUbicacion ;
            Z4ClienteId = A4ClienteId ;
            Z9TipoPagoId = A9TipoPagoId ;
            Z283OpcionEnvioId = A283OpcionEnvioId ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z51PedidosID = A51PedidosID ;
         Z246PedidosFecha = A246PedidosFecha ;
         Z247PedidosEstado = A247PedidosEstado ;
         Z296PedidosImagenComprobante = A296PedidosImagenComprobante ;
         Z40000PedidosImagenComprobante_GXI = A40000PedidosImagenComprobante_GXI ;
         Z295PedidosComprobanteObs = A295PedidosComprobanteObs ;
         Z312PedidosUbicacion = A312PedidosUbicacion ;
         Z4ClienteId = A4ClienteId ;
         Z9TipoPagoId = A9TipoPagoId ;
         Z283OpcionEnvioId = A283OpcionEnvioId ;
         Z250PedidosSubTotal = A250PedidosSubTotal ;
         Z248PedidosTotal = A248PedidosTotal ;
         Z284OpcionEnvioDescripcion = A284OpcionEnvioDescripcion ;
      }
   }

   public void standaloneNotModal( )
   {
      AV18Pgmname = "Pedidos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int4 = A51PedidosID ;
         GXv_int5[0] = GXt_int4 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV18Pgmname), GXv_int5) ;
         pedidos_impl.this.GXt_int4 = GXv_int5[0] ;
         A51PedidosID = GXt_int4 ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T001612 */
         pr_default.execute(9, new Object[] {Long.valueOf(A51PedidosID)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            A250PedidosSubTotal = T001612_A250PedidosSubTotal[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            A248PedidosTotal = T001612_A248PedidosTotal[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         else
         {
            A250PedidosSubTotal = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            A248PedidosTotal = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         O250PedidosSubTotal = A250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         O248PedidosTotal = A248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         pr_default.close(9);
      }
   }

   public void load1647( )
   {
      /* Using cursor T001614 */
      pr_default.execute(10, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A246PedidosFecha = T001614_A246PedidosFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A246PedidosFecha", localUtil.format(A246PedidosFecha, "99/99/99"));
         A247PedidosEstado = T001614_A247PedidosEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", A247PedidosEstado);
         A284OpcionEnvioDescripcion = T001614_A284OpcionEnvioDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
         A296PedidosImagenComprobante = T001614_A296PedidosImagenComprobante[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A296PedidosImagenComprobante", A296PedidosImagenComprobante);
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
         A40000PedidosImagenComprobante_GXI = T001614_A40000PedidosImagenComprobante_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
         A295PedidosComprobanteObs = T001614_A295PedidosComprobanteObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A295PedidosComprobanteObs", A295PedidosComprobanteObs);
         A312PedidosUbicacion = T001614_A312PedidosUbicacion[0] ;
         A4ClienteId = T001614_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T001614_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         A283OpcionEnvioId = T001614_A283OpcionEnvioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A283OpcionEnvioId), 11, 0));
         A250PedidosSubTotal = T001614_A250PedidosSubTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         A248PedidosTotal = T001614_A248PedidosTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         zm1647( -6) ;
      }
      pr_default.close(10);
      onLoadActions1647( ) ;
   }

   public void onLoadActions1647( )
   {
      O248PedidosTotal = A248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      O250PedidosSubTotal = A250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
   }

   public void checkExtendedTable1647( )
   {
      nIsDirty_47 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T001612 */
      pr_default.execute(9, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A250PedidosSubTotal = T001612_A250PedidosSubTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         A248PedidosTotal = T001612_A248PedidosTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      }
      else
      {
         nIsDirty_47 = (short)(1) ;
         A250PedidosSubTotal = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         nIsDirty_47 = (short)(1) ;
         A248PedidosTotal = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      }
      pr_default.close(9);
      /* Using cursor T00168 */
      pr_default.execute(6, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(6);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A246PedidosFecha)) || (( GXutil.resetTime(A246PedidosFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A246PedidosFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Pedidos Fecha", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "PEDIDOSFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPedidosFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00169 */
      pr_default.execute(7, new Object[] {Long.valueOf(A9TipoPagoId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoPagoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(7);
      /* Using cursor T001610 */
      pr_default.execute(8, new Object[] {Long.valueOf(A283OpcionEnvioId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Opcion Envio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPCIONENVIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOpcionEnvioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A284OpcionEnvioDescripcion = T001610_A284OpcionEnvioDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
      pr_default.close(8);
   }

   public void closeExtendedTableCursors1647( )
   {
      pr_default.close(9);
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void gxload_10( long A51PedidosID )
   {
      /* Using cursor T001616 */
      pr_default.execute(11, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         A250PedidosSubTotal = T001616_A250PedidosSubTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         A248PedidosTotal = T001616_A248PedidosTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      }
      else
      {
         A250PedidosSubTotal = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         A248PedidosTotal = DecimalUtil.doubleToDec(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A250PedidosSubTotal, (byte)(17), (byte)(2), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A248PedidosTotal, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_7( long A4ClienteId )
   {
      /* Using cursor T001617 */
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

   public void gxload_8( long A9TipoPagoId )
   {
      /* Using cursor T001618 */
      pr_default.execute(13, new Object[] {Long.valueOf(A9TipoPagoId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoPagoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_9( long A283OpcionEnvioId )
   {
      /* Using cursor T001619 */
      pr_default.execute(14, new Object[] {Long.valueOf(A283OpcionEnvioId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Opcion Envio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPCIONENVIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOpcionEnvioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A284OpcionEnvioDescripcion = T001619_A284OpcionEnvioDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A284OpcionEnvioDescripcion)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey1647( )
   {
      /* Using cursor T001620 */
      pr_default.execute(15, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound47 = (short)(1) ;
      }
      else
      {
         RcdFound47 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00167 */
      pr_default.execute(5, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm1647( 6) ;
         RcdFound47 = (short)(1) ;
         A51PedidosID = T00167_A51PedidosID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
         A246PedidosFecha = T00167_A246PedidosFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A246PedidosFecha", localUtil.format(A246PedidosFecha, "99/99/99"));
         A247PedidosEstado = T00167_A247PedidosEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", A247PedidosEstado);
         A296PedidosImagenComprobante = T00167_A296PedidosImagenComprobante[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A296PedidosImagenComprobante", A296PedidosImagenComprobante);
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
         A40000PedidosImagenComprobante_GXI = T00167_A40000PedidosImagenComprobante_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
         A295PedidosComprobanteObs = T00167_A295PedidosComprobanteObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A295PedidosComprobanteObs", A295PedidosComprobanteObs);
         A312PedidosUbicacion = T00167_A312PedidosUbicacion[0] ;
         A4ClienteId = T00167_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T00167_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         A283OpcionEnvioId = T00167_A283OpcionEnvioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A283OpcionEnvioId), 11, 0));
         Z51PedidosID = A51PedidosID ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1647( ) ;
         if ( AnyError == 1 )
         {
            RcdFound47 = (short)(0) ;
            initializeNonKey1647( ) ;
         }
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound47 = (short)(0) ;
         initializeNonKey1647( ) ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(5);
   }

   public void getEqualNoModal( )
   {
      getKey1647( ) ;
      if ( RcdFound47 == 0 )
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
      RcdFound47 = (short)(0) ;
      /* Using cursor T001621 */
      pr_default.execute(16, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T001621_A51PedidosID[0] < A51PedidosID ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T001621_A51PedidosID[0] > A51PedidosID ) ) )
         {
            A51PedidosID = T001621_A51PedidosID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
            RcdFound47 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void move_previous( )
   {
      RcdFound47 = (short)(0) ;
      /* Using cursor T001622 */
      pr_default.execute(17, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         while ( (pr_default.getStatus(17) != 101) && ( ( T001622_A51PedidosID[0] > A51PedidosID ) ) )
         {
            pr_default.readNext(17);
         }
         if ( (pr_default.getStatus(17) != 101) && ( ( T001622_A51PedidosID[0] < A51PedidosID ) ) )
         {
            A51PedidosID = T001622_A51PedidosID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
            RcdFound47 = (short)(1) ;
         }
      }
      pr_default.close(17);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1647( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         A248PedidosTotal = O248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         A250PedidosSubTotal = O250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         GX_FocusControl = edtPedidosID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1647( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound47 == 1 )
         {
            if ( A51PedidosID != Z51PedidosID )
            {
               A51PedidosID = Z51PedidosID ;
               httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PEDIDOSID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPedidosID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               A248PedidosTotal = O248PedidosTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
               A250PedidosSubTotal = O250PedidosSubTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPedidosID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               A248PedidosTotal = O248PedidosTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
               A250PedidosSubTotal = O250PedidosSubTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
               update1647( ) ;
               GX_FocusControl = edtPedidosID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A51PedidosID != Z51PedidosID )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               A248PedidosTotal = O248PedidosTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
               A250PedidosSubTotal = O250PedidosSubTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
               GX_FocusControl = edtPedidosID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1647( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PEDIDOSID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPedidosID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  A248PedidosTotal = O248PedidosTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
                  A250PedidosSubTotal = O250PedidosSubTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
                  GX_FocusControl = edtPedidosID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1647( ) ;
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
      if ( A51PedidosID != Z51PedidosID )
      {
         A51PedidosID = Z51PedidosID ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PEDIDOSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPedidosID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         A248PedidosTotal = O248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         A250PedidosSubTotal = O250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPedidosID_Internalname ;
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
      if ( RcdFound47 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "PEDIDOSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPedidosID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtClienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart1647( ) ;
      if ( RcdFound47 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtClienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1647( ) ;
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
      if ( RcdFound47 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtClienteId_Internalname ;
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
      if ( RcdFound47 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtClienteId_Internalname ;
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
      scanStart1647( ) ;
      if ( RcdFound47 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound47 != 0 )
         {
            scanNext1647( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtClienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1647( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1647( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00166 */
         pr_default.execute(4, new Object[] {Long.valueOf(A51PedidosID)});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pedidos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(4) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z246PedidosFecha), GXutil.resetTime(T00166_A246PedidosFecha[0])) ) || ( GXutil.strcmp(Z247PedidosEstado, T00166_A247PedidosEstado[0]) != 0 ) || ( GXutil.strcmp(Z295PedidosComprobanteObs, T00166_A295PedidosComprobanteObs[0]) != 0 ) || ( GXutil.strcmp(Z312PedidosUbicacion, T00166_A312PedidosUbicacion[0]) != 0 ) || ( Z4ClienteId != T00166_A4ClienteId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z9TipoPagoId != T00166_A9TipoPagoId[0] ) || ( Z283OpcionEnvioId != T00166_A283OpcionEnvioId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z246PedidosFecha), GXutil.resetTime(T00166_A246PedidosFecha[0])) ) )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"PedidosFecha");
               GXutil.writeLogRaw("Old: ",Z246PedidosFecha);
               GXutil.writeLogRaw("Current: ",T00166_A246PedidosFecha[0]);
            }
            if ( GXutil.strcmp(Z247PedidosEstado, T00166_A247PedidosEstado[0]) != 0 )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"PedidosEstado");
               GXutil.writeLogRaw("Old: ",Z247PedidosEstado);
               GXutil.writeLogRaw("Current: ",T00166_A247PedidosEstado[0]);
            }
            if ( GXutil.strcmp(Z295PedidosComprobanteObs, T00166_A295PedidosComprobanteObs[0]) != 0 )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"PedidosComprobanteObs");
               GXutil.writeLogRaw("Old: ",Z295PedidosComprobanteObs);
               GXutil.writeLogRaw("Current: ",T00166_A295PedidosComprobanteObs[0]);
            }
            if ( GXutil.strcmp(Z312PedidosUbicacion, T00166_A312PedidosUbicacion[0]) != 0 )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"PedidosUbicacion");
               GXutil.writeLogRaw("Old: ",Z312PedidosUbicacion);
               GXutil.writeLogRaw("Current: ",T00166_A312PedidosUbicacion[0]);
            }
            if ( Z4ClienteId != T00166_A4ClienteId[0] )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"ClienteId");
               GXutil.writeLogRaw("Old: ",Z4ClienteId);
               GXutil.writeLogRaw("Current: ",T00166_A4ClienteId[0]);
            }
            if ( Z9TipoPagoId != T00166_A9TipoPagoId[0] )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"TipoPagoId");
               GXutil.writeLogRaw("Old: ",Z9TipoPagoId);
               GXutil.writeLogRaw("Current: ",T00166_A9TipoPagoId[0]);
            }
            if ( Z283OpcionEnvioId != T00166_A283OpcionEnvioId[0] )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"OpcionEnvioId");
               GXutil.writeLogRaw("Old: ",Z283OpcionEnvioId);
               GXutil.writeLogRaw("Current: ",T00166_A283OpcionEnvioId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pedidos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1647( )
   {
      if ( ! IsAuthorized("pedidos_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1647( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1647( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1647( 0) ;
         checkOptimisticConcurrency1647( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1647( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1647( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001623 */
                  pr_default.execute(18, new Object[] {Long.valueOf(A51PedidosID), A246PedidosFecha, A247PedidosEstado, A296PedidosImagenComprobante, A40000PedidosImagenComprobante_GXI, A295PedidosComprobanteObs, A312PedidosUbicacion, Long.valueOf(A4ClienteId), Long.valueOf(A9TipoPagoId), Long.valueOf(A283OpcionEnvioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
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
                        processLevel1647( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption160( ) ;
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
            load1647( ) ;
         }
         endLevel1647( ) ;
      }
      closeExtendedTableCursors1647( ) ;
   }

   public void update1647( )
   {
      if ( ! IsAuthorized("pedidos_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1647( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1647( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1647( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1647( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1647( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001624 */
                  pr_default.execute(19, new Object[] {A246PedidosFecha, A247PedidosEstado, A295PedidosComprobanteObs, A312PedidosUbicacion, Long.valueOf(A4ClienteId), Long.valueOf(A9TipoPagoId), Long.valueOf(A283OpcionEnvioId), Long.valueOf(A51PedidosID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pedidos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1647( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1647( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                           resetCaption160( ) ;
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
         endLevel1647( ) ;
      }
      closeExtendedTableCursors1647( ) ;
   }

   public void deferredUpdate1647( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T001625 */
         pr_default.execute(20, new Object[] {A296PedidosImagenComprobante, A40000PedidosImagenComprobante_GXI, Long.valueOf(A51PedidosID)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
      }
   }

   public void delete( )
   {
      if ( ! IsAuthorized("pedidos_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1647( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1647( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1647( ) ;
         afterConfirm1647( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1647( ) ;
            if ( AnyError == 0 )
            {
               A248PedidosTotal = O248PedidosTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
               A250PedidosSubTotal = O250PedidosSubTotal ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
               scanStart1648( ) ;
               while ( RcdFound48 != 0 )
               {
                  getByPrimaryKey1648( ) ;
                  delete1648( ) ;
                  scanNext1648( ) ;
                  O248PedidosTotal = A248PedidosTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
                  O250PedidosSubTotal = A250PedidosSubTotal ;
                  httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
               }
               scanEnd1648( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001626 */
                  pr_default.execute(21, new Object[] {Long.valueOf(A51PedidosID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pedidos");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound47 == 0 )
                        {
                           initAll1647( ) ;
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
                        resetCaption160( ) ;
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
      sMode47 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1647( ) ;
      Gx_mode = sMode47 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1647( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001628 */
         pr_default.execute(22, new Object[] {Long.valueOf(A51PedidosID)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            A250PedidosSubTotal = T001628_A250PedidosSubTotal[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            A248PedidosTotal = T001628_A248PedidosTotal[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         else
         {
            A250PedidosSubTotal = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            A248PedidosTotal = DecimalUtil.doubleToDec(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         pr_default.close(22);
         /* Using cursor T001629 */
         pr_default.execute(23, new Object[] {Long.valueOf(A283OpcionEnvioId)});
         A284OpcionEnvioDescripcion = T001629_A284OpcionEnvioDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
         pr_default.close(23);
      }
   }

   public void processNestedLevel1648( )
   {
      s248PedidosTotal = O248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      s250PedidosSubTotal = O250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      nGXsfl_76_idx = 0 ;
      while ( nGXsfl_76_idx < nRC_GXsfl_76 )
      {
         readRow1648( ) ;
         if ( ( nRcdExists_48 != 0 ) || ( nIsMod_48 != 0 ) )
         {
            standaloneNotModal1648( ) ;
            getKey1648( ) ;
            if ( ( nRcdExists_48 == 0 ) && ( nRcdDeleted_48 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1648( ) ;
            }
            else
            {
               if ( RcdFound48 != 0 )
               {
                  if ( ( nRcdDeleted_48 != 0 ) && ( nRcdExists_48 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1648( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_48 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1648( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_48 == 0 )
                  {
                     GXCCtl = "PEDIDOSDETALLEID_" + sGXsfl_76_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPedidosDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
            O248PedidosTotal = A248PedidosTotal ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
            O250PedidosSubTotal = A250PedidosSubTotal ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         }
         httpContext.changePostValue( edtPedidosDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A52PedidosDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtImpuestoPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtPedidosDetalleCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A245PedidosDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtPedidosDetalleTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A249PedidosDetalleTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtPedidosDetalleTallaID_Internalname, GXutil.ltrim( localUtil.ntoc( A293PedidosDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z52PedidosDetalleID_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z52PedidosDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z293PedidosDetalleTallaID_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z293PedidosDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z245PedidosDetalleCantidad_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z245PedidosDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T249PedidosDetalleTotal_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( O249PedidosDetalleTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_48_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_48_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_48_"+sGXsfl_76_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_48 != 0 )
         {
            httpContext.changePostValue( "PEDIDOSDETALLEID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "IMPUESTOPORCENTAJE_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOPRECIOVENTA_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PEDIDOSDETALLETOTAL_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PEDIDOSDETALLETALLAID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1648( ) ;
      if ( AnyError != 0 )
      {
         O248PedidosTotal = s248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         O250PedidosSubTotal = s250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      }
      nRcdExists_48 = (short)(0) ;
      nIsMod_48 = (short)(0) ;
      nRcdDeleted_48 = (short)(0) ;
   }

   public void processLevel1647( )
   {
      /* Save parent mode. */
      sMode47 = Gx_mode ;
      processNestedLevel1648( ) ;
      if ( AnyError != 0 )
      {
         O248PedidosTotal = s248PedidosTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         O250PedidosSubTotal = s250PedidosSubTotal ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      }
      /* Restore parent mode. */
      Gx_mode = sMode47 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1647( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1647( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(23);
         pr_default.close(22);
         pr_default.close(2);
         pr_default.close(3);
         Application.commitDataStores(context, remoteHandle, pr_default, "pedidos");
         if ( AnyError == 0 )
         {
            confirmValues160( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(23);
         pr_default.close(22);
         pr_default.close(2);
         pr_default.close(3);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "pedidos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1647( )
   {
      /* Scan By routine */
      /* Using cursor T001630 */
      pr_default.execute(24);
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A51PedidosID = T001630_A51PedidosID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1647( )
   {
      /* Scan next routine */
      pr_default.readNext(24);
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A51PedidosID = T001630_A51PedidosID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
      }
   }

   public void scanEnd1647( )
   {
      pr_default.close(24);
   }

   public void afterConfirm1647( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1647( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1647( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1647( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1647( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1647( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1647( )
   {
      edtPedidosID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosID_Enabled), 5, 0), true);
      edtClienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      edtPedidosFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosFecha_Enabled), 5, 0), true);
      cmbPedidosEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPedidosEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPedidosEstado.getEnabled(), 5, 0), true);
      edtPedidosSubTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosSubTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosSubTotal_Enabled), 5, 0), true);
      edtPedidosTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosTotal_Enabled), 5, 0), true);
      edtTipoPagoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoPagoId_Enabled), 5, 0), true);
      edtOpcionEnvioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpcionEnvioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpcionEnvioId_Enabled), 5, 0), true);
      edtOpcionEnvioDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpcionEnvioDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpcionEnvioDescripcion_Enabled), 5, 0), true);
      edtPedidosComprobanteObs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosComprobanteObs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosComprobanteObs_Enabled), 5, 0), true);
      imgPedidosImagenComprobante_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgPedidosImagenComprobante_Enabled), 5, 0), true);
   }

   public void zm1648( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z293PedidosDetalleTallaID = T00163_A293PedidosDetalleTallaID[0] ;
            Z245PedidosDetalleCantidad = T00163_A245PedidosDetalleCantidad[0] ;
            Z13ArticuloId = T00163_A13ArticuloId[0] ;
         }
         else
         {
            Z293PedidosDetalleTallaID = A293PedidosDetalleTallaID ;
            Z245PedidosDetalleCantidad = A245PedidosDetalleCantidad ;
            Z13ArticuloId = A13ArticuloId ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z51PedidosID = A51PedidosID ;
         Z52PedidosDetalleID = A52PedidosDetalleID ;
         Z293PedidosDetalleTallaID = A293PedidosDetalleTallaID ;
         Z245PedidosDetalleCantidad = A245PedidosDetalleCantidad ;
         Z13ArticuloId = A13ArticuloId ;
         Z18ImpuestoId = A18ImpuestoId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
         Z78ArticuloPrecioVenta = A78ArticuloPrecioVenta ;
         Z83ImpuestoPorcentaje = A83ImpuestoPorcentaje ;
      }
   }

   public void standaloneNotModal1648( )
   {
   }

   public void standaloneModal1648( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtPedidosDetalleID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      }
      else
      {
         edtPedidosDetalleID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      }
   }

   public void load1648( )
   {
      /* Using cursor T001631 */
      pr_default.execute(25, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID)});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound48 = (short)(1) ;
         A18ImpuestoId = T001631_A18ImpuestoId[0] ;
         A76ArticuloNombre = T001631_A76ArticuloNombre[0] ;
         A83ImpuestoPorcentaje = T001631_A83ImpuestoPorcentaje[0] ;
         A78ArticuloPrecioVenta = T001631_A78ArticuloPrecioVenta[0] ;
         A293PedidosDetalleTallaID = T001631_A293PedidosDetalleTallaID[0] ;
         A245PedidosDetalleCantidad = T001631_A245PedidosDetalleCantidad[0] ;
         A13ArticuloId = T001631_A13ArticuloId[0] ;
         zm1648( -11) ;
      }
      pr_default.close(25);
      onLoadActions1648( ) ;
   }

   public void onLoadActions1648( )
   {
      A249PedidosDetalleTotal = A78ArticuloPrecioVenta.multiply(DecimalUtil.doubleToDec(A245PedidosDetalleCantidad)) ;
      O249PedidosDetalleTotal = A249PedidosDetalleTotal ;
      if ( isIns( )  )
      {
         A250PedidosSubTotal = O250PedidosSubTotal.add(A249PedidosDetalleTotal) ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A250PedidosSubTotal = O250PedidosSubTotal.add(A249PedidosDetalleTotal).subtract(O249PedidosDetalleTotal) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A250PedidosSubTotal = O250PedidosSubTotal.subtract(O249PedidosDetalleTotal) ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            }
         }
      }
      if ( isIns( )  )
      {
         A248PedidosTotal = O248PedidosTotal.add(A249PedidosDetalleTotal) ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A248PedidosTotal = O248PedidosTotal.add(A249PedidosDetalleTotal).subtract(O249PedidosDetalleTotal) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A248PedidosTotal = O248PedidosTotal.subtract(O249PedidosDetalleTotal) ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
            }
         }
      }
   }

   public void checkExtendedTable1648( )
   {
      nIsDirty_48 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1648( ) ;
      /* Using cursor T00164 */
      pr_default.execute(2, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_76_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18ImpuestoId = T00164_A18ImpuestoId[0] ;
      A76ArticuloNombre = T00164_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T00164_A78ArticuloPrecioVenta[0] ;
      pr_default.close(2);
      /* Using cursor T00165 */
      pr_default.execute(3, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T00165_A83ImpuestoPorcentaje[0] ;
      pr_default.close(3);
      nIsDirty_48 = (short)(1) ;
      A249PedidosDetalleTotal = A78ArticuloPrecioVenta.multiply(DecimalUtil.doubleToDec(A245PedidosDetalleCantidad)) ;
      if ( isIns( )  )
      {
         nIsDirty_48 = (short)(1) ;
         A250PedidosSubTotal = O250PedidosSubTotal.add(A249PedidosDetalleTotal) ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_48 = (short)(1) ;
            A250PedidosSubTotal = O250PedidosSubTotal.add(A249PedidosDetalleTotal).subtract(O249PedidosDetalleTotal) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_48 = (short)(1) ;
               A250PedidosSubTotal = O250PedidosSubTotal.subtract(O249PedidosDetalleTotal) ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            }
         }
      }
      if ( isIns( )  )
      {
         nIsDirty_48 = (short)(1) ;
         A248PedidosTotal = O248PedidosTotal.add(A249PedidosDetalleTotal) ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_48 = (short)(1) ;
            A248PedidosTotal = O248PedidosTotal.add(A249PedidosDetalleTotal).subtract(O249PedidosDetalleTotal) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_48 = (short)(1) ;
               A248PedidosTotal = O248PedidosTotal.subtract(O249PedidosDetalleTotal) ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
            }
         }
      }
   }

   public void closeExtendedTableCursors1648( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable1648( )
   {
   }

   public void gxload_12( long A13ArticuloId )
   {
      /* Using cursor T001632 */
      pr_default.execute(26, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(26) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_76_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A18ImpuestoId = T001632_A18ImpuestoId[0] ;
      A76ArticuloNombre = T001632_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T001632_A78ArticuloPrecioVenta[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A76ArticuloNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(26) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(26);
   }

   public void gxload_13( long A18ImpuestoId )
   {
      /* Using cursor T001633 */
      pr_default.execute(27, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T001633_A83ImpuestoPorcentaje[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(27) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(27);
   }

   public void getKey1648( )
   {
      /* Using cursor T001634 */
      pr_default.execute(28, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID)});
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound48 = (short)(1) ;
      }
      else
      {
         RcdFound48 = (short)(0) ;
      }
      pr_default.close(28);
   }

   public void getByPrimaryKey1648( )
   {
      /* Using cursor T00163 */
      pr_default.execute(1, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1648( 11) ;
         RcdFound48 = (short)(1) ;
         initializeNonKey1648( ) ;
         A52PedidosDetalleID = T00163_A52PedidosDetalleID[0] ;
         A293PedidosDetalleTallaID = T00163_A293PedidosDetalleTallaID[0] ;
         A245PedidosDetalleCantidad = T00163_A245PedidosDetalleCantidad[0] ;
         A13ArticuloId = T00163_A13ArticuloId[0] ;
         Z51PedidosID = A51PedidosID ;
         Z52PedidosDetalleID = A52PedidosDetalleID ;
         sMode48 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1648( ) ;
         load1648( ) ;
         Gx_mode = sMode48 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound48 = (short)(0) ;
         initializeNonKey1648( ) ;
         sMode48 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1648( ) ;
         Gx_mode = sMode48 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1648( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1648( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00162 */
         pr_default.execute(0, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PedidosDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z293PedidosDetalleTallaID != T00162_A293PedidosDetalleTallaID[0] ) || ( Z245PedidosDetalleCantidad != T00162_A245PedidosDetalleCantidad[0] ) || ( Z13ArticuloId != T00162_A13ArticuloId[0] ) )
         {
            if ( Z293PedidosDetalleTallaID != T00162_A293PedidosDetalleTallaID[0] )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"PedidosDetalleTallaID");
               GXutil.writeLogRaw("Old: ",Z293PedidosDetalleTallaID);
               GXutil.writeLogRaw("Current: ",T00162_A293PedidosDetalleTallaID[0]);
            }
            if ( Z245PedidosDetalleCantidad != T00162_A245PedidosDetalleCantidad[0] )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"PedidosDetalleCantidad");
               GXutil.writeLogRaw("Old: ",Z245PedidosDetalleCantidad);
               GXutil.writeLogRaw("Current: ",T00162_A245PedidosDetalleCantidad[0]);
            }
            if ( Z13ArticuloId != T00162_A13ArticuloId[0] )
            {
               GXutil.writeLogln("pedidos:[seudo value changed for attri]"+"ArticuloId");
               GXutil.writeLogRaw("Old: ",Z13ArticuloId);
               GXutil.writeLogRaw("Current: ",T00162_A13ArticuloId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PedidosDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1648( )
   {
      if ( ! IsAuthorized("pedidos_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1648( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1648( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1648( 0) ;
         checkOptimisticConcurrency1648( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1648( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1648( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001635 */
                  pr_default.execute(29, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID), Long.valueOf(A293PedidosDetalleTallaID), Integer.valueOf(A245PedidosDetalleCantidad), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PedidosDetalle");
                  if ( (pr_default.getStatus(29) == 1) )
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
            load1648( ) ;
         }
         endLevel1648( ) ;
      }
      closeExtendedTableCursors1648( ) ;
   }

   public void update1648( )
   {
      if ( ! IsAuthorized("pedidos_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1648( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1648( ) ;
      }
      if ( ( nIsMod_48 != 0 ) || ( nIsDirty_48 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1648( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1648( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1648( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001636 */
                     pr_default.execute(30, new Object[] {Long.valueOf(A293PedidosDetalleTallaID), Integer.valueOf(A245PedidosDetalleCantidad), Long.valueOf(A13ArticuloId), Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("PedidosDetalle");
                     if ( (pr_default.getStatus(30) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PedidosDetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1648( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1648( ) ;
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
            endLevel1648( ) ;
         }
      }
      closeExtendedTableCursors1648( ) ;
   }

   public void deferredUpdate1648( )
   {
   }

   public void delete1648( )
   {
      if ( ! IsAuthorized("pedidos_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1648( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1648( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1648( ) ;
         afterConfirm1648( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1648( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001637 */
               pr_default.execute(31, new Object[] {Long.valueOf(A51PedidosID), Long.valueOf(A52PedidosDetalleID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PedidosDetalle");
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
      sMode48 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1648( ) ;
      Gx_mode = sMode48 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1648( )
   {
      standaloneModal1648( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001638 */
         pr_default.execute(32, new Object[] {Long.valueOf(A13ArticuloId)});
         A18ImpuestoId = T001638_A18ImpuestoId[0] ;
         A76ArticuloNombre = T001638_A76ArticuloNombre[0] ;
         A78ArticuloPrecioVenta = T001638_A78ArticuloPrecioVenta[0] ;
         pr_default.close(32);
         /* Using cursor T001639 */
         pr_default.execute(33, new Object[] {Long.valueOf(A18ImpuestoId)});
         A83ImpuestoPorcentaje = T001639_A83ImpuestoPorcentaje[0] ;
         pr_default.close(33);
         A249PedidosDetalleTotal = A78ArticuloPrecioVenta.multiply(DecimalUtil.doubleToDec(A245PedidosDetalleCantidad)) ;
         if ( isIns( )  )
         {
            A250PedidosSubTotal = O250PedidosSubTotal.add(A249PedidosDetalleTotal) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A250PedidosSubTotal = O250PedidosSubTotal.add(A249PedidosDetalleTotal).subtract(O249PedidosDetalleTotal) ;
               httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A250PedidosSubTotal = O250PedidosSubTotal.subtract(O249PedidosDetalleTotal) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
               }
            }
         }
         if ( isIns( )  )
         {
            A248PedidosTotal = O248PedidosTotal.add(A249PedidosDetalleTotal) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A248PedidosTotal = O248PedidosTotal.add(A249PedidosDetalleTotal).subtract(O249PedidosDetalleTotal) ;
               httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A248PedidosTotal = O248PedidosTotal.subtract(O249PedidosDetalleTotal) ;
                  httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
               }
            }
         }
      }
   }

   public void endLevel1648( )
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

   public void scanStart1648( )
   {
      /* Scan By routine */
      /* Using cursor T001640 */
      pr_default.execute(34, new Object[] {Long.valueOf(A51PedidosID)});
      RcdFound48 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound48 = (short)(1) ;
         A52PedidosDetalleID = T001640_A52PedidosDetalleID[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1648( )
   {
      /* Scan next routine */
      pr_default.readNext(34);
      RcdFound48 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound48 = (short)(1) ;
         A52PedidosDetalleID = T001640_A52PedidosDetalleID[0] ;
      }
   }

   public void scanEnd1648( )
   {
      pr_default.close(34);
   }

   public void afterConfirm1648( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1648( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1648( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1648( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1648( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1648( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1648( )
   {
      edtPedidosDetalleID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtImpuestoPorcentaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtImpuestoPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtImpuestoPorcentaje_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtArticuloPrecioVenta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtPedidosDetalleCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleCantidad_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtPedidosDetalleTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleTotal_Enabled), 5, 0), !bGXsfl_76_Refreshing);
      edtPedidosDetalleTallaID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleTallaID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleTallaID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
   }

   public void send_integrity_lvl_hashes1648( )
   {
   }

   public void send_integrity_lvl_hashes1647( )
   {
   }

   public void subsflControlProps_7648( )
   {
      edtPedidosDetalleID_Internalname = "PEDIDOSDETALLEID_"+sGXsfl_76_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_76_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_76_idx ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE_"+sGXsfl_76_idx ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA_"+sGXsfl_76_idx ;
      edtPedidosDetalleCantidad_Internalname = "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_idx ;
      edtPedidosDetalleTotal_Internalname = "PEDIDOSDETALLETOTAL_"+sGXsfl_76_idx ;
      edtPedidosDetalleTallaID_Internalname = "PEDIDOSDETALLETALLAID_"+sGXsfl_76_idx ;
   }

   public void subsflControlProps_fel_7648( )
   {
      edtPedidosDetalleID_Internalname = "PEDIDOSDETALLEID_"+sGXsfl_76_fel_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_76_fel_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_76_fel_idx ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE_"+sGXsfl_76_fel_idx ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA_"+sGXsfl_76_fel_idx ;
      edtPedidosDetalleCantidad_Internalname = "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_fel_idx ;
      edtPedidosDetalleTotal_Internalname = "PEDIDOSDETALLETOTAL_"+sGXsfl_76_fel_idx ;
      edtPedidosDetalleTallaID_Internalname = "PEDIDOSDETALLETALLAID_"+sGXsfl_76_fel_idx ;
   }

   public void addRow1648( )
   {
      nGXsfl_76_idx = (int)(nGXsfl_76_idx+1) ;
      sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7648( ) ;
      sendRow1648( ) ;
   }

   public void sendRow1648( )
   {
      Gridlevel_detalleRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_detalle_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(0) ;
         subGridlevel_detalle_Backcolor = subGridlevel_detalle_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
         {
            subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
         }
         subGridlevel_detalle_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_detalle_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_detalle_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_76_idx) % (2))) == 0 )
         {
            subGridlevel_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
            {
               subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_detalle_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_detalle_Class, "") != 0 )
            {
               subGridlevel_detalle_Linesclass = subGridlevel_detalle_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_48_" + sGXsfl_76_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 77,'',false,'" + sGXsfl_76_idx + "',76)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosDetalleID_Internalname,GXutil.ltrim( localUtil.ntoc( A52PedidosDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A52PedidosDetalleID), "ZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,77);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosDetalleID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtPedidosDetalleID_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_48_" + sGXsfl_76_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 78,'',false,'" + sGXsfl_76_idx + "',76)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloId_Internalname,GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,78);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloNombre_Internalname,GXutil.rtrim( A76ArticuloNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpuestoPorcentaje_Internalname,GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtImpuestoPorcentaje_Enabled!=0) ? localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99") : localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtImpuestoPorcentaje_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtImpuestoPorcentaje_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(9),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Porcentaje","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloPrecioVenta_Internalname,GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloPrecioVenta_Enabled!=0) ? localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloPrecioVenta_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloPrecioVenta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_48_" + sGXsfl_76_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 82,'',false,'" + sGXsfl_76_idx + "',76)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosDetalleCantidad_Internalname,GXutil.ltrim( localUtil.ntoc( A245PedidosDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtPedidosDetalleCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A245PedidosDetalleCantidad), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A245PedidosDetalleCantidad), "ZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,82);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosDetalleCantidad_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtPedidosDetalleCantidad_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cantidad","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosDetalleTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A249PedidosDetalleTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtPedidosDetalleTotal_Enabled!=0) ? localUtil.format( A249PedidosDetalleTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A249PedidosDetalleTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosDetalleTotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtPedidosDetalleTotal_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_48_" + sGXsfl_76_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 84,'',false,'" + sGXsfl_76_idx + "',76)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPedidosDetalleTallaID_Internalname,GXutil.ltrim( localUtil.ntoc( A293PedidosDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtPedidosDetalleTallaID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A293PedidosDetalleTallaID), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A293PedidosDetalleTallaID), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,84);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPedidosDetalleTallaID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtPedidosDetalleTallaID_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(76),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes1648( ) ;
      GXCCtl = "Z52PedidosDetalleID_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z52PedidosDetalleID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z293PedidosDetalleTallaID_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z293PedidosDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z245PedidosDetalleCantidad_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z245PedidosDetalleCantidad, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z13ArticuloId_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O249PedidosDetalleTotal_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O249PedidosDetalleTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_48_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_48_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_48_" + sGXsfl_76_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_48, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PEDIDOSDETALLEID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULONOMBRE_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IMPUESTOPORCENTAJE_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOPRECIOVENTA_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PEDIDOSDETALLETOTAL_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PEDIDOSDETALLETALLAID_"+sGXsfl_76_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow1648( )
   {
      nGXsfl_76_idx = (int)(nGXsfl_76_idx+1) ;
      sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7648( ) ;
      edtPedidosDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLEID_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtImpuestoPorcentaje_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "IMPUESTOPORCENTAJE_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOPRECIOVENTA_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtPedidosDetalleCantidad_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLECANTIDAD_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtPedidosDetalleTotal_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLETOTAL_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtPedidosDetalleTallaID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PEDIDOSDETALLETALLAID_"+sGXsfl_76_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "PEDIDOSDETALLEID_" + sGXsfl_76_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtPedidosDetalleID_Internalname ;
         wbErr = true ;
         A52PedidosDetalleID = 0 ;
      }
      else
      {
         A52PedidosDetalleID = localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_76_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         wbErr = true ;
         A13ArticuloId = 0 ;
      }
      else
      {
         A13ArticuloId = localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      A76ArticuloNombre = httpContext.cgiGet( edtArticuloNombre_Internalname) ;
      A83ImpuestoPorcentaje = localUtil.ctond( httpContext.cgiGet( edtImpuestoPorcentaje_Internalname)) ;
      A78ArticuloPrecioVenta = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
      {
         GXCCtl = "PEDIDOSDETALLECANTIDAD_" + sGXsfl_76_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtPedidosDetalleCantidad_Internalname ;
         wbErr = true ;
         A245PedidosDetalleCantidad = 0 ;
      }
      else
      {
         A245PedidosDetalleCantidad = (int)(localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleCantidad_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A249PedidosDetalleTotal = localUtil.ctond( httpContext.cgiGet( edtPedidosDetalleTotal_Internalname)) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "PEDIDOSDETALLETALLAID_" + sGXsfl_76_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtPedidosDetalleTallaID_Internalname ;
         wbErr = true ;
         A293PedidosDetalleTallaID = 0 ;
      }
      else
      {
         A293PedidosDetalleTallaID = localUtil.ctol( httpContext.cgiGet( edtPedidosDetalleTallaID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      GXCCtl = "Z52PedidosDetalleID_" + sGXsfl_76_idx ;
      Z52PedidosDetalleID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z293PedidosDetalleTallaID_" + sGXsfl_76_idx ;
      Z293PedidosDetalleTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z245PedidosDetalleCantidad_" + sGXsfl_76_idx ;
      Z245PedidosDetalleCantidad = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z13ArticuloId_" + sGXsfl_76_idx ;
      Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "O249PedidosDetalleTotal_" + sGXsfl_76_idx ;
      O249PedidosDetalleTotal = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_48_" + sGXsfl_76_idx ;
      nRcdDeleted_48 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_48_" + sGXsfl_76_idx ;
      nRcdExists_48 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_48_" + sGXsfl_76_idx ;
      nIsMod_48 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtPedidosDetalleID_Enabled = edtPedidosDetalleID_Enabled ;
   }

   public void confirmValues160( )
   {
      nGXsfl_76_idx = 0 ;
      sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7648( ) ;
      while ( nGXsfl_76_idx < nRC_GXsfl_76 )
      {
         nGXsfl_76_idx = (int)(nGXsfl_76_idx+1) ;
         sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7648( ) ;
         httpContext.changePostValue( "Z52PedidosDetalleID_"+sGXsfl_76_idx, httpContext.cgiGet( "ZT_"+"Z52PedidosDetalleID_"+sGXsfl_76_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z52PedidosDetalleID_"+sGXsfl_76_idx) ;
         httpContext.changePostValue( "Z293PedidosDetalleTallaID_"+sGXsfl_76_idx, httpContext.cgiGet( "ZT_"+"Z293PedidosDetalleTallaID_"+sGXsfl_76_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z293PedidosDetalleTallaID_"+sGXsfl_76_idx) ;
         httpContext.changePostValue( "Z245PedidosDetalleCantidad_"+sGXsfl_76_idx, httpContext.cgiGet( "ZT_"+"Z245PedidosDetalleCantidad_"+sGXsfl_76_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z245PedidosDetalleCantidad_"+sGXsfl_76_idx) ;
         httpContext.changePostValue( "Z13ArticuloId_"+sGXsfl_76_idx, httpContext.cgiGet( "ZT_"+"Z13ArticuloId_"+sGXsfl_76_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_76_idx) ;
      }
      httpContext.changePostValue( "O249PedidosDetalleTotal", httpContext.cgiGet( "T249PedidosDetalleTotal")) ;
      httpContext.deletePostValue( "T249PedidosDetalleTotal") ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.pedidos", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Pedidos");
      forbiddenHiddens.add("PedidosUbicacion", GXutil.rtrim( localUtil.format( A312PedidosUbicacion, "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("pedidos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z51PedidosID", GXutil.ltrim( localUtil.ntoc( Z51PedidosID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z246PedidosFecha", localUtil.dtoc( Z246PedidosFecha, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z247PedidosEstado", GXutil.rtrim( Z247PedidosEstado));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z295PedidosComprobanteObs", Z295PedidosComprobanteObs);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z312PedidosUbicacion", GXutil.rtrim( Z312PedidosUbicacion));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z4ClienteId", GXutil.ltrim( localUtil.ntoc( Z4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z9TipoPagoId", GXutil.ltrim( localUtil.ntoc( Z9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z283OpcionEnvioId", GXutil.ltrim( localUtil.ntoc( Z283OpcionEnvioId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O248PedidosTotal", GXutil.ltrim( localUtil.ntoc( O248PedidosTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O250PedidosSubTotal", GXutil.ltrim( localUtil.ntoc( O250PedidosSubTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_76", GXutil.ltrim( localUtil.ntoc( nGXsfl_76_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV18Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PEDIDOSIMAGENCOMPROBANTE_GXI", A40000PedidosImagenComprobante_GXI);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PEDIDOSUBICACION", GXutil.rtrim( A312PedidosUbicacion));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IMPUESTOID", GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtlgxBlob = "PEDIDOSIMAGENCOMPROBANTE" + "_gxBlob" ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A296PedidosImagenComprobante);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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
      return formatLink("com.mujermorena.pedidos", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Pedidos" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Pedidos", "") ;
   }

   public void initializeNonKey1647( )
   {
      A4ClienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      A246PedidosFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A246PedidosFecha", localUtil.format(A246PedidosFecha, "99/99/99"));
      A247PedidosEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", A247PedidosEstado);
      A9TipoPagoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
      A283OpcionEnvioId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A283OpcionEnvioId), 11, 0));
      A284OpcionEnvioDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
      A296PedidosImagenComprobante = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A296PedidosImagenComprobante", A296PedidosImagenComprobante);
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
      A40000PedidosImagenComprobante_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "Bitmap", ((GXutil.strcmp("", A296PedidosImagenComprobante)==0) ? A40000PedidosImagenComprobante_GXI : httpContext.convertURL( httpContext.getResourceRelative(A296PedidosImagenComprobante))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgPedidosImagenComprobante_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A296PedidosImagenComprobante), true);
      A295PedidosComprobanteObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A295PedidosComprobanteObs", A295PedidosComprobanteObs);
      A312PedidosUbicacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A312PedidosUbicacion", A312PedidosUbicacion);
      A250PedidosSubTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      A248PedidosTotal = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      O248PedidosTotal = A248PedidosTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrimstr( A248PedidosTotal, 17, 2));
      O250PedidosSubTotal = A250PedidosSubTotal ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrimstr( A250PedidosSubTotal, 17, 2));
      Z246PedidosFecha = GXutil.nullDate() ;
      Z247PedidosEstado = "" ;
      Z295PedidosComprobanteObs = "" ;
      Z312PedidosUbicacion = "" ;
      Z4ClienteId = 0 ;
      Z9TipoPagoId = 0 ;
      Z283OpcionEnvioId = 0 ;
   }

   public void initAll1647( )
   {
      A51PedidosID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
      initializeNonKey1647( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey1648( )
   {
      A18ImpuestoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A18ImpuestoId), 11, 0));
      A249PedidosDetalleTotal = DecimalUtil.ZERO ;
      A13ArticuloId = 0 ;
      A76ArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A293PedidosDetalleTallaID = 0 ;
      A245PedidosDetalleCantidad = 0 ;
      O249PedidosDetalleTotal = A249PedidosDetalleTotal ;
      Z293PedidosDetalleTallaID = 0 ;
      Z245PedidosDetalleCantidad = 0 ;
      Z13ArticuloId = 0 ;
   }

   public void initAll1648( )
   {
      A52PedidosDetalleID = 0 ;
      initializeNonKey1648( ) ;
   }

   public void standaloneModalInsert1648( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20241211111529", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("pedidos.js", "?20241211111529", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties48( )
   {
      edtPedidosDetalleID_Enabled = defedtPedidosDetalleID_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtPedidosDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPedidosDetalleID_Enabled), 5, 0), !bGXsfl_76_Refreshing);
   }

   public void startgridcontrol76( )
   {
      Gridlevel_detalleContainer.AddObjectProperty("GridName", "Gridlevel_detalle");
      Gridlevel_detalleContainer.AddObjectProperty("Header", subGridlevel_detalle_Header);
      Gridlevel_detalleContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_detalleContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_detalleContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A52PedidosDetalleID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.rtrim( A76ArticuloNombre));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtImpuestoPorcentaje_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A245PedidosDetalleCantidad, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleCantidad_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A249PedidosDetalleTotal, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A293PedidosDetalleTallaID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPedidosDetalleTallaID_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_detalle_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE" ;
      edtPedidosID_Internalname = "PEDIDOSID" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtPedidosFecha_Internalname = "PEDIDOSFECHA" ;
      cmbPedidosEstado.setInternalname( "PEDIDOSESTADO" );
      edtPedidosSubTotal_Internalname = "PEDIDOSSUBTOTAL" ;
      edtPedidosTotal_Internalname = "PEDIDOSTOTAL" ;
      edtTipoPagoId_Internalname = "TIPOPAGOID" ;
      edtOpcionEnvioId_Internalname = "OPCIONENVIOID" ;
      edtOpcionEnvioDescripcion_Internalname = "OPCIONENVIODESCRIPCION" ;
      edtPedidosComprobanteObs_Internalname = "PEDIDOSCOMPROBANTEOBS" ;
      imgPedidosImagenComprobante_Internalname = "PEDIDOSIMAGENCOMPROBANTE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtPedidosDetalleID_Internalname = "PEDIDOSDETALLEID" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtImpuestoPorcentaje_Internalname = "IMPUESTOPORCENTAJE" ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA" ;
      edtPedidosDetalleCantidad_Internalname = "PEDIDOSDETALLECANTIDAD" ;
      edtPedidosDetalleTotal_Internalname = "PEDIDOSDETALLETOTAL" ;
      edtPedidosDetalleTallaID_Internalname = "PEDIDOSDETALLETALLAID" ;
      divTableleaflevel_detalle_Internalname = "TABLELEAFLEVEL_DETALLE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_detalle_Internalname = "GRIDLEVEL_DETALLE" ;
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
      subGridlevel_detalle_Allowcollapsing = (byte)(0) ;
      subGridlevel_detalle_Allowselection = (byte)(0) ;
      subGridlevel_detalle_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Pedidos", "") );
      edtPedidosDetalleTallaID_Jsonclick = "" ;
      edtPedidosDetalleTotal_Jsonclick = "" ;
      edtPedidosDetalleCantidad_Jsonclick = "" ;
      edtArticuloPrecioVenta_Jsonclick = "" ;
      edtImpuestoPorcentaje_Jsonclick = "" ;
      edtArticuloNombre_Jsonclick = "" ;
      edtArticuloId_Jsonclick = "" ;
      edtPedidosDetalleID_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      edtPedidosDetalleTallaID_Enabled = 1 ;
      edtPedidosDetalleTotal_Enabled = 0 ;
      edtPedidosDetalleCantidad_Enabled = 1 ;
      edtArticuloPrecioVenta_Enabled = 0 ;
      edtImpuestoPorcentaje_Enabled = 0 ;
      edtArticuloNombre_Enabled = 0 ;
      edtArticuloId_Enabled = 1 ;
      edtPedidosDetalleID_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 1 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      imgPedidosImagenComprobante_Enabled = 1 ;
      edtPedidosComprobanteObs_Enabled = 1 ;
      edtOpcionEnvioDescripcion_Jsonclick = "" ;
      edtOpcionEnvioDescripcion_Enabled = 0 ;
      edtOpcionEnvioId_Jsonclick = "" ;
      edtOpcionEnvioId_Enabled = 1 ;
      edtTipoPagoId_Jsonclick = "" ;
      edtTipoPagoId_Enabled = 1 ;
      edtPedidosTotal_Jsonclick = "" ;
      edtPedidosTotal_Enabled = 0 ;
      edtPedidosSubTotal_Jsonclick = "" ;
      edtPedidosSubTotal_Enabled = 0 ;
      cmbPedidosEstado.setJsonclick( "" );
      cmbPedidosEstado.setEnabled( 1 );
      edtPedidosFecha_Jsonclick = "" ;
      edtPedidosFecha_Enabled = 1 ;
      edtClienteId_Jsonclick = "" ;
      edtClienteId_Enabled = 1 ;
      edtPedidosID_Jsonclick = "" ;
      edtPedidosID_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelFilled Panel_BaseColor" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
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

   public void gx2asapedidosid1647( String AV18Pgmname )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int4 = A51PedidosID ;
         GXv_int5[0] = GXt_int4 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV18Pgmname), GXv_int5) ;
         pedidos_impl.this.GXt_int4 = GXv_int5[0] ;
         A51PedidosID = GXt_int4 ;
         httpContext.ajax_rsp_assign_attri("", false, "A51PedidosID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A51PedidosID), 11, 0));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A51PedidosID, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_detalle_newrow( )
   {
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_7648( ) ;
      while ( nGXsfl_76_idx <= nRC_GXsfl_76 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1648( ) ;
         standaloneModal1648( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1648( ) ;
         nGXsfl_76_idx = (int)(nGXsfl_76_idx+1) ;
         sGXsfl_76_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_76_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7648( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_detalleContainer)) ;
      /* End function gxnrGridlevel_detalle_newrow */
   }

   public void init_web_controls( )
   {
      cmbPedidosEstado.setName( "PEDIDOSESTADO" );
      cmbPedidosEstado.setWebtags( "" );
      cmbPedidosEstado.addItem("PEN", httpContext.getMessage( "Pendiente", ""), (short)(0));
      cmbPedidosEstado.addItem("FIN", httpContext.getMessage( "Confirmado", ""), (short)(0));
      cmbPedidosEstado.addItem("CAN", httpContext.getMessage( "Cancelado", ""), (short)(0));
      if ( cmbPedidosEstado.getItemCount() > 0 )
      {
         A247PedidosEstado = cmbPedidosEstado.getValidValue(A247PedidosEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", A247PedidosEstado);
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtClienteId_Internalname ;
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

   public void valid_Pedidosid( )
   {
      A247PedidosEstado = cmbPedidosEstado.getValue() ;
      cmbPedidosEstado.setValue( A247PedidosEstado );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      /* Using cursor T001628 */
      pr_default.execute(22, new Object[] {Long.valueOf(A51PedidosID)});
      if ( (pr_default.getStatus(22) != 101) )
      {
         A250PedidosSubTotal = T001628_A250PedidosSubTotal[0] ;
         A248PedidosTotal = T001628_A248PedidosTotal[0] ;
      }
      else
      {
         A250PedidosSubTotal = DecimalUtil.doubleToDec(0) ;
         A248PedidosTotal = DecimalUtil.doubleToDec(0) ;
      }
      pr_default.close(22);
      dynload_actions( ) ;
      if ( cmbPedidosEstado.getItemCount() > 0 )
      {
         A247PedidosEstado = cmbPedidosEstado.getValidValue(A247PedidosEstado) ;
         cmbPedidosEstado.setValue( A247PedidosEstado );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPedidosEstado.setValue( GXutil.rtrim( A247PedidosEstado) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A246PedidosFecha", localUtil.format(A246PedidosFecha, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A247PedidosEstado", GXutil.rtrim( A247PedidosEstado));
      cmbPedidosEstado.setValue( GXutil.rtrim( A247PedidosEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPedidosEstado.getInternalname(), "Values", cmbPedidosEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A283OpcionEnvioId", GXutil.ltrim( localUtil.ntoc( A283OpcionEnvioId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A296PedidosImagenComprobante", httpContext.getResourceRelative(A296PedidosImagenComprobante));
      GXCCtlgxBlob = "PEDIDOSIMAGENCOMPROBANTE" + "_gxBlob" ;
      httpContext.ajax_rsp_assign_attri("", false, "GXCCtlgxBlob", GXCCtlgxBlob);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, httpContext.getResourceRelative(A296PedidosImagenComprobante));
      httpContext.ajax_rsp_assign_attri("", false, "A40000PedidosImagenComprobante_GXI", A40000PedidosImagenComprobante_GXI);
      httpContext.ajax_rsp_assign_attri("", false, "A295PedidosComprobanteObs", A295PedidosComprobanteObs);
      httpContext.ajax_rsp_assign_attri("", false, "A312PedidosUbicacion", GXutil.rtrim( A312PedidosUbicacion));
      httpContext.ajax_rsp_assign_attri("", false, "A250PedidosSubTotal", GXutil.ltrim( localUtil.ntoc( A250PedidosSubTotal, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A248PedidosTotal", GXutil.ltrim( localUtil.ntoc( A248PedidosTotal, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z51PedidosID", GXutil.ltrim( localUtil.ntoc( Z51PedidosID, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z4ClienteId", GXutil.ltrim( localUtil.ntoc( Z4ClienteId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z246PedidosFecha", localUtil.format(Z246PedidosFecha, "99/99/99"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z247PedidosEstado", GXutil.rtrim( Z247PedidosEstado));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z9TipoPagoId", GXutil.ltrim( localUtil.ntoc( Z9TipoPagoId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z283OpcionEnvioId", GXutil.ltrim( localUtil.ntoc( Z283OpcionEnvioId, (byte)(11), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z296PedidosImagenComprobante", httpContext.getResourceRelative(Z296PedidosImagenComprobante));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z40000PedidosImagenComprobante_GXI", Z40000PedidosImagenComprobante_GXI);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z295PedidosComprobanteObs", Z295PedidosComprobanteObs);
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z312PedidosUbicacion", GXutil.rtrim( Z312PedidosUbicacion));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z250PedidosSubTotal", GXutil.ltrim( localUtil.ntoc( Z250PedidosSubTotal, (byte)(17), (byte)(2), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z248PedidosTotal", GXutil.ltrim( localUtil.ntoc( Z248PedidosTotal, (byte)(17), (byte)(2), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z284OpcionEnvioDescripcion", Z284OpcionEnvioDescripcion);
      httpContext.ajax_rsp_assign_attri("", false, "O248PedidosTotal", GXutil.ltrim( localUtil.ntoc( O248PedidosTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      httpContext.ajax_rsp_assign_attri("", false, "O250PedidosSubTotal", GXutil.ltrim( localUtil.ntoc( O250PedidosSubTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Clienteid( )
   {
      /* Using cursor T001641 */
      pr_default.execute(35, new Object[] {Long.valueOf(A4ClienteId)});
      if ( (pr_default.getStatus(35) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClienteId_Internalname ;
      }
      pr_default.close(35);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Tipopagoid( )
   {
      /* Using cursor T001642 */
      pr_default.execute(36, new Object[] {Long.valueOf(A9TipoPagoId)});
      if ( (pr_default.getStatus(36) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Pago", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TIPOPAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtTipoPagoId_Internalname ;
      }
      pr_default.close(36);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Opcionenvioid( )
   {
      /* Using cursor T001629 */
      pr_default.execute(23, new Object[] {Long.valueOf(A283OpcionEnvioId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Opcion Envio", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPCIONENVIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtOpcionEnvioId_Internalname ;
      }
      A284OpcionEnvioDescripcion = T001629_A284OpcionEnvioDescripcion[0] ;
      pr_default.close(23);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A284OpcionEnvioDescripcion", A284OpcionEnvioDescripcion);
   }

   public void valid_Articuloid( )
   {
      /* Using cursor T001638 */
      pr_default.execute(32, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(32) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
      }
      A18ImpuestoId = T001638_A18ImpuestoId[0] ;
      A76ArticuloNombre = T001638_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T001638_A78ArticuloPrecioVenta[0] ;
      pr_default.close(32);
      /* Using cursor T001639 */
      pr_default.execute(33, new Object[] {Long.valueOf(A18ImpuestoId)});
      if ( (pr_default.getStatus(33) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Impuesto", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPUESTOID");
         AnyError = (short)(1) ;
      }
      A83ImpuestoPorcentaje = T001639_A83ImpuestoPorcentaje[0] ;
      pr_default.close(33);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A18ImpuestoId", GXutil.ltrim( localUtil.ntoc( A18ImpuestoId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", GXutil.rtrim( A76ArticuloNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(17), (byte)(2), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A83ImpuestoPorcentaje", GXutil.ltrim( localUtil.ntoc( A83ImpuestoPorcentaje, (byte)(9), (byte)(2), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A312PedidosUbicacion',fld:'PEDIDOSUBICACION',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12162',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PEDIDOSID","{handler:'valid_Pedidosid',iparms:[{av:'A312PedidosUbicacion',fld:'PEDIDOSUBICACION',pic:''},{av:'cmbPedidosEstado'},{av:'A247PedidosEstado',fld:'PEDIDOSESTADO',pic:''},{av:'A51PedidosID',fld:'PEDIDOSID',pic:'ZZZZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV18Pgmname',fld:'vPGMNAME',pic:''}]");
      setEventMetadata("VALID_PEDIDOSID",",oparms:[{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'A246PedidosFecha',fld:'PEDIDOSFECHA',pic:''},{av:'cmbPedidosEstado'},{av:'A247PedidosEstado',fld:'PEDIDOSESTADO',pic:''},{av:'A9TipoPagoId',fld:'TIPOPAGOID',pic:'ZZZZZZZZZZ9'},{av:'A283OpcionEnvioId',fld:'OPCIONENVIOID',pic:'ZZZZZZZZZZ9'},{av:'A296PedidosImagenComprobante',fld:'PEDIDOSIMAGENCOMPROBANTE',pic:''},{av:'A40000PedidosImagenComprobante_GXI',fld:'PEDIDOSIMAGENCOMPROBANTE_GXI',pic:''},{av:'A295PedidosComprobanteObs',fld:'PEDIDOSCOMPROBANTEOBS',pic:''},{av:'A312PedidosUbicacion',fld:'PEDIDOSUBICACION',pic:''},{av:'A250PedidosSubTotal',fld:'PEDIDOSSUBTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A248PedidosTotal',fld:'PEDIDOSTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A284OpcionEnvioDescripcion',fld:'OPCIONENVIODESCRIPCION',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z51PedidosID'},{av:'Z4ClienteId'},{av:'Z246PedidosFecha'},{av:'Z247PedidosEstado'},{av:'Z9TipoPagoId'},{av:'Z283OpcionEnvioId'},{av:'Z296PedidosImagenComprobante'},{av:'Z40000PedidosImagenComprobante_GXI'},{av:'Z295PedidosComprobanteObs'},{av:'Z312PedidosUbicacion'},{av:'Z250PedidosSubTotal'},{av:'Z248PedidosTotal'},{av:'Z284OpcionEnvioDescripcion'},{av:'O248PedidosTotal'},{av:'O250PedidosSubTotal'},{ctrl:'BTNTRN_DELETE',prop:'Enabled'},{ctrl:'BTNTRN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_CLIENTEID","{handler:'valid_Clienteid',iparms:[{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_CLIENTEID",",oparms:[]}");
      setEventMetadata("VALID_PEDIDOSFECHA","{handler:'valid_Pedidosfecha',iparms:[]");
      setEventMetadata("VALID_PEDIDOSFECHA",",oparms:[]}");
      setEventMetadata("VALID_TIPOPAGOID","{handler:'valid_Tipopagoid',iparms:[{av:'A9TipoPagoId',fld:'TIPOPAGOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_TIPOPAGOID",",oparms:[]}");
      setEventMetadata("VALID_OPCIONENVIOID","{handler:'valid_Opcionenvioid',iparms:[{av:'A283OpcionEnvioId',fld:'OPCIONENVIOID',pic:'ZZZZZZZZZZ9'},{av:'A284OpcionEnvioDescripcion',fld:'OPCIONENVIODESCRIPCION',pic:''}]");
      setEventMetadata("VALID_OPCIONENVIOID",",oparms:[{av:'A284OpcionEnvioDescripcion',fld:'OPCIONENVIODESCRIPCION',pic:''}]}");
      setEventMetadata("VALID_PEDIDOSDETALLEID","{handler:'valid_Pedidosdetalleid',iparms:[]");
      setEventMetadata("VALID_PEDIDOSDETALLEID",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A78ArticuloPrecioVenta',fld:'ARTICULOPRECIOVENTA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[{av:'A18ImpuestoId',fld:'IMPUESTOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A78ArticuloPrecioVenta',fld:'ARTICULOPRECIOVENTA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'},{av:'A83ImpuestoPorcentaje',fld:'IMPUESTOPORCENTAJE',pic:'ZZZZZ9.99'}]}");
      setEventMetadata("VALID_ARTICULOPRECIOVENTA","{handler:'valid_Articuloprecioventa',iparms:[]");
      setEventMetadata("VALID_ARTICULOPRECIOVENTA",",oparms:[]}");
      setEventMetadata("VALID_PEDIDOSDETALLECANTIDAD","{handler:'valid_Pedidosdetallecantidad',iparms:[]");
      setEventMetadata("VALID_PEDIDOSDETALLECANTIDAD",",oparms:[]}");
      setEventMetadata("VALID_PEDIDOSDETALLETOTAL","{handler:'valid_Pedidosdetalletotal',iparms:[]");
      setEventMetadata("VALID_PEDIDOSDETALLETOTAL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Pedidosdetalletallaid',iparms:[]");
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
      return "pedidos_Execute";
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
      pr_default.close(32);
      pr_default.close(33);
      pr_default.close(35);
      pr_default.close(36);
      pr_default.close(23);
      pr_default.close(22);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z246PedidosFecha = GXutil.nullDate() ;
      Z247PedidosEstado = "" ;
      Z295PedidosComprobanteObs = "" ;
      Z312PedidosUbicacion = "" ;
      O248PedidosTotal = DecimalUtil.ZERO ;
      O250PedidosSubTotal = DecimalUtil.ZERO ;
      O249PedidosDetalleTotal = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV18Pgmname = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      Gx_mode = "" ;
      A247PedidosEstado = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A246PedidosFecha = GXutil.nullDate() ;
      A250PedidosSubTotal = DecimalUtil.ZERO ;
      A248PedidosTotal = DecimalUtil.ZERO ;
      A284OpcionEnvioDescripcion = "" ;
      A295PedidosComprobanteObs = "" ;
      A296PedidosImagenComprobante = "" ;
      A40000PedidosImagenComprobante_GXI = "" ;
      sImgUrl = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      B248PedidosTotal = DecimalUtil.ZERO ;
      B250PedidosSubTotal = DecimalUtil.ZERO ;
      sMode48 = "" ;
      sStyleString = "" ;
      A312PedidosUbicacion = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXv_char1 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      s248PedidosTotal = DecimalUtil.ZERO ;
      s250PedidosSubTotal = DecimalUtil.ZERO ;
      GXCCtl = "" ;
      A76ArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A249PedidosDetalleTotal = DecimalUtil.ZERO ;
      T249PedidosDetalleTotal = DecimalUtil.ZERO ;
      AV15CajaEstado = "" ;
      GXt_char3 = "" ;
      GXv_char2 = new String[1] ;
      Z296PedidosImagenComprobante = "" ;
      Z40000PedidosImagenComprobante_GXI = "" ;
      Z250PedidosSubTotal = DecimalUtil.ZERO ;
      Z248PedidosTotal = DecimalUtil.ZERO ;
      Z284OpcionEnvioDescripcion = "" ;
      T001612_A250PedidosSubTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001612_A248PedidosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001614_A51PedidosID = new long[1] ;
      T001614_A246PedidosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T001614_A247PedidosEstado = new String[] {""} ;
      T001614_A284OpcionEnvioDescripcion = new String[] {""} ;
      T001614_A296PedidosImagenComprobante = new String[] {""} ;
      T001614_A40000PedidosImagenComprobante_GXI = new String[] {""} ;
      T001614_A295PedidosComprobanteObs = new String[] {""} ;
      T001614_A312PedidosUbicacion = new String[] {""} ;
      T001614_A4ClienteId = new long[1] ;
      T001614_A9TipoPagoId = new long[1] ;
      T001614_A283OpcionEnvioId = new long[1] ;
      T001614_A250PedidosSubTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001614_A248PedidosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00168_A4ClienteId = new long[1] ;
      T00169_A9TipoPagoId = new long[1] ;
      T001610_A284OpcionEnvioDescripcion = new String[] {""} ;
      T001616_A250PedidosSubTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001616_A248PedidosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001617_A4ClienteId = new long[1] ;
      T001618_A9TipoPagoId = new long[1] ;
      T001619_A284OpcionEnvioDescripcion = new String[] {""} ;
      T001620_A51PedidosID = new long[1] ;
      T00167_A51PedidosID = new long[1] ;
      T00167_A246PedidosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00167_A247PedidosEstado = new String[] {""} ;
      T00167_A296PedidosImagenComprobante = new String[] {""} ;
      T00167_A40000PedidosImagenComprobante_GXI = new String[] {""} ;
      T00167_A295PedidosComprobanteObs = new String[] {""} ;
      T00167_A312PedidosUbicacion = new String[] {""} ;
      T00167_A4ClienteId = new long[1] ;
      T00167_A9TipoPagoId = new long[1] ;
      T00167_A283OpcionEnvioId = new long[1] ;
      sMode47 = "" ;
      T001621_A51PedidosID = new long[1] ;
      T001622_A51PedidosID = new long[1] ;
      T00166_A51PedidosID = new long[1] ;
      T00166_A246PedidosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00166_A247PedidosEstado = new String[] {""} ;
      T00166_A296PedidosImagenComprobante = new String[] {""} ;
      T00166_A40000PedidosImagenComprobante_GXI = new String[] {""} ;
      T00166_A295PedidosComprobanteObs = new String[] {""} ;
      T00166_A312PedidosUbicacion = new String[] {""} ;
      T00166_A4ClienteId = new long[1] ;
      T00166_A9TipoPagoId = new long[1] ;
      T00166_A283OpcionEnvioId = new long[1] ;
      T001628_A250PedidosSubTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001628_A248PedidosTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001629_A284OpcionEnvioDescripcion = new String[] {""} ;
      T001630_A51PedidosID = new long[1] ;
      Z76ArticuloNombre = "" ;
      Z78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      Z83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      T001631_A18ImpuestoId = new long[1] ;
      T001631_A51PedidosID = new long[1] ;
      T001631_A52PedidosDetalleID = new long[1] ;
      T001631_A76ArticuloNombre = new String[] {""} ;
      T001631_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001631_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001631_A293PedidosDetalleTallaID = new long[1] ;
      T001631_A245PedidosDetalleCantidad = new int[1] ;
      T001631_A13ArticuloId = new long[1] ;
      T00164_A18ImpuestoId = new long[1] ;
      T00164_A76ArticuloNombre = new String[] {""} ;
      T00164_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00165_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001632_A18ImpuestoId = new long[1] ;
      T001632_A76ArticuloNombre = new String[] {""} ;
      T001632_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001633_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001634_A51PedidosID = new long[1] ;
      T001634_A52PedidosDetalleID = new long[1] ;
      T00163_A51PedidosID = new long[1] ;
      T00163_A52PedidosDetalleID = new long[1] ;
      T00163_A293PedidosDetalleTallaID = new long[1] ;
      T00163_A245PedidosDetalleCantidad = new int[1] ;
      T00163_A13ArticuloId = new long[1] ;
      T00162_A51PedidosID = new long[1] ;
      T00162_A52PedidosDetalleID = new long[1] ;
      T00162_A293PedidosDetalleTallaID = new long[1] ;
      T00162_A245PedidosDetalleCantidad = new int[1] ;
      T00162_A13ArticuloId = new long[1] ;
      T001638_A18ImpuestoId = new long[1] ;
      T001638_A76ArticuloNombre = new String[] {""} ;
      T001638_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001639_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001640_A51PedidosID = new long[1] ;
      T001640_A52PedidosDetalleID = new long[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int5 = new long[1] ;
      ZZ246PedidosFecha = GXutil.nullDate() ;
      ZZ247PedidosEstado = "" ;
      ZZ296PedidosImagenComprobante = "" ;
      ZZ40000PedidosImagenComprobante_GXI = "" ;
      ZZ295PedidosComprobanteObs = "" ;
      ZZ312PedidosUbicacion = "" ;
      ZZ250PedidosSubTotal = DecimalUtil.ZERO ;
      ZZ248PedidosTotal = DecimalUtil.ZERO ;
      ZZ284OpcionEnvioDescripcion = "" ;
      ZO248PedidosTotal = DecimalUtil.ZERO ;
      ZO250PedidosSubTotal = DecimalUtil.ZERO ;
      T001641_A4ClienteId = new long[1] ;
      T001642_A9TipoPagoId = new long[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.pedidos__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.pedidos__default(),
         new Object[] {
             new Object[] {
            T00162_A51PedidosID, T00162_A52PedidosDetalleID, T00162_A293PedidosDetalleTallaID, T00162_A245PedidosDetalleCantidad, T00162_A13ArticuloId
            }
            , new Object[] {
            T00163_A51PedidosID, T00163_A52PedidosDetalleID, T00163_A293PedidosDetalleTallaID, T00163_A245PedidosDetalleCantidad, T00163_A13ArticuloId
            }
            , new Object[] {
            T00164_A18ImpuestoId, T00164_A76ArticuloNombre, T00164_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T00165_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T00166_A51PedidosID, T00166_A246PedidosFecha, T00166_A247PedidosEstado, T00166_A296PedidosImagenComprobante, T00166_A40000PedidosImagenComprobante_GXI, T00166_A295PedidosComprobanteObs, T00166_A312PedidosUbicacion, T00166_A4ClienteId, T00166_A9TipoPagoId, T00166_A283OpcionEnvioId
            }
            , new Object[] {
            T00167_A51PedidosID, T00167_A246PedidosFecha, T00167_A247PedidosEstado, T00167_A296PedidosImagenComprobante, T00167_A40000PedidosImagenComprobante_GXI, T00167_A295PedidosComprobanteObs, T00167_A312PedidosUbicacion, T00167_A4ClienteId, T00167_A9TipoPagoId, T00167_A283OpcionEnvioId
            }
            , new Object[] {
            T00168_A4ClienteId
            }
            , new Object[] {
            T00169_A9TipoPagoId
            }
            , new Object[] {
            T001610_A284OpcionEnvioDescripcion
            }
            , new Object[] {
            T001612_A250PedidosSubTotal, T001612_A248PedidosTotal
            }
            , new Object[] {
            T001614_A51PedidosID, T001614_A246PedidosFecha, T001614_A247PedidosEstado, T001614_A284OpcionEnvioDescripcion, T001614_A296PedidosImagenComprobante, T001614_A40000PedidosImagenComprobante_GXI, T001614_A295PedidosComprobanteObs, T001614_A312PedidosUbicacion, T001614_A4ClienteId, T001614_A9TipoPagoId,
            T001614_A283OpcionEnvioId, T001614_A250PedidosSubTotal, T001614_A248PedidosTotal
            }
            , new Object[] {
            T001616_A250PedidosSubTotal, T001616_A248PedidosTotal
            }
            , new Object[] {
            T001617_A4ClienteId
            }
            , new Object[] {
            T001618_A9TipoPagoId
            }
            , new Object[] {
            T001619_A284OpcionEnvioDescripcion
            }
            , new Object[] {
            T001620_A51PedidosID
            }
            , new Object[] {
            T001621_A51PedidosID
            }
            , new Object[] {
            T001622_A51PedidosID
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
            T001628_A250PedidosSubTotal, T001628_A248PedidosTotal
            }
            , new Object[] {
            T001629_A284OpcionEnvioDescripcion
            }
            , new Object[] {
            T001630_A51PedidosID
            }
            , new Object[] {
            T001631_A18ImpuestoId, T001631_A51PedidosID, T001631_A52PedidosDetalleID, T001631_A76ArticuloNombre, T001631_A83ImpuestoPorcentaje, T001631_A78ArticuloPrecioVenta, T001631_A293PedidosDetalleTallaID, T001631_A245PedidosDetalleCantidad, T001631_A13ArticuloId
            }
            , new Object[] {
            T001632_A18ImpuestoId, T001632_A76ArticuloNombre, T001632_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T001633_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T001634_A51PedidosID, T001634_A52PedidosDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001638_A18ImpuestoId, T001638_A76ArticuloNombre, T001638_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T001639_A83ImpuestoPorcentaje
            }
            , new Object[] {
            T001640_A51PedidosID, T001640_A52PedidosDetalleID
            }
            , new Object[] {
            T001641_A4ClienteId
            }
            , new Object[] {
            T001642_A9TipoPagoId
            }
         }
      );
      AV18Pgmname = "Pedidos" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_detalle_Backcolorstyle ;
   private byte subGridlevel_detalle_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_detalle_Allowselection ;
   private byte subGridlevel_detalle_Allowhovering ;
   private byte subGridlevel_detalle_Allowcollapsing ;
   private byte subGridlevel_detalle_Collapsed ;
   private short nRcdDeleted_48 ;
   private short nRcdExists_48 ;
   private short nIsMod_48 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount48 ;
   private short RcdFound48 ;
   private short nBlankRcdUsr48 ;
   private short RcdFound47 ;
   private short nIsDirty_47 ;
   private short nIsDirty_48 ;
   private int nRC_GXsfl_76 ;
   private int nGXsfl_76_idx=1 ;
   private int Z245PedidosDetalleCantidad ;
   private int trnEnded ;
   private int edtPedidosID_Enabled ;
   private int edtClienteId_Enabled ;
   private int edtPedidosFecha_Enabled ;
   private int edtPedidosSubTotal_Enabled ;
   private int edtPedidosTotal_Enabled ;
   private int edtTipoPagoId_Enabled ;
   private int edtOpcionEnvioId_Enabled ;
   private int edtOpcionEnvioDescripcion_Enabled ;
   private int edtPedidosComprobanteObs_Enabled ;
   private int imgPedidosImagenComprobante_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPedidosDetalleID_Enabled ;
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtImpuestoPorcentaje_Enabled ;
   private int edtArticuloPrecioVenta_Enabled ;
   private int edtPedidosDetalleCantidad_Enabled ;
   private int edtPedidosDetalleTotal_Enabled ;
   private int edtPedidosDetalleTallaID_Enabled ;
   private int fRowAdded ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A245PedidosDetalleCantidad ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int defedtPedidosDetalleID_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private long Z51PedidosID ;
   private long Z4ClienteId ;
   private long Z9TipoPagoId ;
   private long Z283OpcionEnvioId ;
   private long Z52PedidosDetalleID ;
   private long Z293PedidosDetalleTallaID ;
   private long Z13ArticuloId ;
   private long A51PedidosID ;
   private long A4ClienteId ;
   private long A9TipoPagoId ;
   private long A283OpcionEnvioId ;
   private long A13ArticuloId ;
   private long A18ImpuestoId ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private long A52PedidosDetalleID ;
   private long A293PedidosDetalleTallaID ;
   private long Z18ImpuestoId ;
   private long GXt_int4 ;
   private long GXv_int5[] ;
   private long ZZ51PedidosID ;
   private long ZZ4ClienteId ;
   private long ZZ9TipoPagoId ;
   private long ZZ283OpcionEnvioId ;
   private java.math.BigDecimal O248PedidosTotal ;
   private java.math.BigDecimal O250PedidosSubTotal ;
   private java.math.BigDecimal O249PedidosDetalleTotal ;
   private java.math.BigDecimal A250PedidosSubTotal ;
   private java.math.BigDecimal A248PedidosTotal ;
   private java.math.BigDecimal B248PedidosTotal ;
   private java.math.BigDecimal B250PedidosSubTotal ;
   private java.math.BigDecimal s248PedidosTotal ;
   private java.math.BigDecimal s250PedidosSubTotal ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A249PedidosDetalleTotal ;
   private java.math.BigDecimal T249PedidosDetalleTotal ;
   private java.math.BigDecimal Z250PedidosSubTotal ;
   private java.math.BigDecimal Z248PedidosTotal ;
   private java.math.BigDecimal Z78ArticuloPrecioVenta ;
   private java.math.BigDecimal Z83ImpuestoPorcentaje ;
   private java.math.BigDecimal ZZ250PedidosSubTotal ;
   private java.math.BigDecimal ZZ248PedidosTotal ;
   private java.math.BigDecimal ZO248PedidosTotal ;
   private java.math.BigDecimal ZO250PedidosSubTotal ;
   private String sPrefix ;
   private String Z247PedidosEstado ;
   private String Z312PedidosUbicacion ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV18Pgmname ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPedidosID_Internalname ;
   private String sGXsfl_76_idx="0001" ;
   private String Gx_mode ;
   private String A247PedidosEstado ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String lblTextblocktitle_Internalname ;
   private String lblTextblocktitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtPedidosID_Jsonclick ;
   private String edtClienteId_Internalname ;
   private String edtClienteId_Jsonclick ;
   private String edtPedidosFecha_Internalname ;
   private String edtPedidosFecha_Jsonclick ;
   private String edtPedidosSubTotal_Internalname ;
   private String edtPedidosSubTotal_Jsonclick ;
   private String edtPedidosTotal_Internalname ;
   private String edtPedidosTotal_Jsonclick ;
   private String edtTipoPagoId_Internalname ;
   private String edtTipoPagoId_Jsonclick ;
   private String edtOpcionEnvioId_Internalname ;
   private String edtOpcionEnvioId_Jsonclick ;
   private String edtOpcionEnvioDescripcion_Internalname ;
   private String edtOpcionEnvioDescripcion_Jsonclick ;
   private String edtPedidosComprobanteObs_Internalname ;
   private String imgPedidosImagenComprobante_Internalname ;
   private String sImgUrl ;
   private String divTableleaflevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode48 ;
   private String edtPedidosDetalleID_Internalname ;
   private String edtArticuloId_Internalname ;
   private String edtArticuloNombre_Internalname ;
   private String edtImpuestoPorcentaje_Internalname ;
   private String edtArticuloPrecioVenta_Internalname ;
   private String edtPedidosDetalleCantidad_Internalname ;
   private String edtPedidosDetalleTotal_Internalname ;
   private String edtPedidosDetalleTallaID_Internalname ;
   private String sStyleString ;
   private String subGridlevel_detalle_Internalname ;
   private String A312PedidosUbicacion ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String GXv_char1[] ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A76ArticuloNombre ;
   private String AV15CajaEstado ;
   private String GXt_char3 ;
   private String GXv_char2[] ;
   private String sMode47 ;
   private String Z76ArticuloNombre ;
   private String sGXsfl_76_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String ROClassString ;
   private String edtPedidosDetalleID_Jsonclick ;
   private String edtArticuloId_Jsonclick ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtImpuestoPorcentaje_Jsonclick ;
   private String edtArticuloPrecioVenta_Jsonclick ;
   private String edtPedidosDetalleCantidad_Jsonclick ;
   private String edtPedidosDetalleTotal_Jsonclick ;
   private String edtPedidosDetalleTallaID_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private String subGridlevel_detalle_Header ;
   private String ZZ247PedidosEstado ;
   private String ZZ312PedidosUbicacion ;
   private java.util.Date Z246PedidosFecha ;
   private java.util.Date A246PedidosFecha ;
   private java.util.Date ZZ246PedidosFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A296PedidosImagenComprobante_IsBlob ;
   private boolean bGXsfl_76_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private String Z295PedidosComprobanteObs ;
   private String A284OpcionEnvioDescripcion ;
   private String A295PedidosComprobanteObs ;
   private String A40000PedidosImagenComprobante_GXI ;
   private String Z40000PedidosImagenComprobante_GXI ;
   private String Z284OpcionEnvioDescripcion ;
   private String ZZ40000PedidosImagenComprobante_GXI ;
   private String ZZ295PedidosComprobanteObs ;
   private String ZZ284OpcionEnvioDescripcion ;
   private String A296PedidosImagenComprobante ;
   private String Z296PedidosImagenComprobante ;
   private String ZZ296PedidosImagenComprobante ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPedidosEstado ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T001612_A250PedidosSubTotal ;
   private java.math.BigDecimal[] T001612_A248PedidosTotal ;
   private long[] T001614_A51PedidosID ;
   private java.util.Date[] T001614_A246PedidosFecha ;
   private String[] T001614_A247PedidosEstado ;
   private String[] T001614_A284OpcionEnvioDescripcion ;
   private String[] T001614_A296PedidosImagenComprobante ;
   private String[] T001614_A40000PedidosImagenComprobante_GXI ;
   private String[] T001614_A295PedidosComprobanteObs ;
   private String[] T001614_A312PedidosUbicacion ;
   private long[] T001614_A4ClienteId ;
   private long[] T001614_A9TipoPagoId ;
   private long[] T001614_A283OpcionEnvioId ;
   private java.math.BigDecimal[] T001614_A250PedidosSubTotal ;
   private java.math.BigDecimal[] T001614_A248PedidosTotal ;
   private long[] T00168_A4ClienteId ;
   private long[] T00169_A9TipoPagoId ;
   private String[] T001610_A284OpcionEnvioDescripcion ;
   private java.math.BigDecimal[] T001616_A250PedidosSubTotal ;
   private java.math.BigDecimal[] T001616_A248PedidosTotal ;
   private long[] T001617_A4ClienteId ;
   private long[] T001618_A9TipoPagoId ;
   private String[] T001619_A284OpcionEnvioDescripcion ;
   private long[] T001620_A51PedidosID ;
   private long[] T00167_A51PedidosID ;
   private java.util.Date[] T00167_A246PedidosFecha ;
   private String[] T00167_A247PedidosEstado ;
   private String[] T00167_A296PedidosImagenComprobante ;
   private String[] T00167_A40000PedidosImagenComprobante_GXI ;
   private String[] T00167_A295PedidosComprobanteObs ;
   private String[] T00167_A312PedidosUbicacion ;
   private long[] T00167_A4ClienteId ;
   private long[] T00167_A9TipoPagoId ;
   private long[] T00167_A283OpcionEnvioId ;
   private long[] T001621_A51PedidosID ;
   private long[] T001622_A51PedidosID ;
   private long[] T00166_A51PedidosID ;
   private java.util.Date[] T00166_A246PedidosFecha ;
   private String[] T00166_A247PedidosEstado ;
   private String[] T00166_A296PedidosImagenComprobante ;
   private String[] T00166_A40000PedidosImagenComprobante_GXI ;
   private String[] T00166_A295PedidosComprobanteObs ;
   private String[] T00166_A312PedidosUbicacion ;
   private long[] T00166_A4ClienteId ;
   private long[] T00166_A9TipoPagoId ;
   private long[] T00166_A283OpcionEnvioId ;
   private java.math.BigDecimal[] T001628_A250PedidosSubTotal ;
   private java.math.BigDecimal[] T001628_A248PedidosTotal ;
   private String[] T001629_A284OpcionEnvioDescripcion ;
   private long[] T001630_A51PedidosID ;
   private long[] T001631_A18ImpuestoId ;
   private long[] T001631_A51PedidosID ;
   private long[] T001631_A52PedidosDetalleID ;
   private String[] T001631_A76ArticuloNombre ;
   private java.math.BigDecimal[] T001631_A83ImpuestoPorcentaje ;
   private java.math.BigDecimal[] T001631_A78ArticuloPrecioVenta ;
   private long[] T001631_A293PedidosDetalleTallaID ;
   private int[] T001631_A245PedidosDetalleCantidad ;
   private long[] T001631_A13ArticuloId ;
   private long[] T00164_A18ImpuestoId ;
   private String[] T00164_A76ArticuloNombre ;
   private java.math.BigDecimal[] T00164_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T00165_A83ImpuestoPorcentaje ;
   private long[] T001632_A18ImpuestoId ;
   private String[] T001632_A76ArticuloNombre ;
   private java.math.BigDecimal[] T001632_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T001633_A83ImpuestoPorcentaje ;
   private long[] T001634_A51PedidosID ;
   private long[] T001634_A52PedidosDetalleID ;
   private long[] T00163_A51PedidosID ;
   private long[] T00163_A52PedidosDetalleID ;
   private long[] T00163_A293PedidosDetalleTallaID ;
   private int[] T00163_A245PedidosDetalleCantidad ;
   private long[] T00163_A13ArticuloId ;
   private long[] T00162_A51PedidosID ;
   private long[] T00162_A52PedidosDetalleID ;
   private long[] T00162_A293PedidosDetalleTallaID ;
   private int[] T00162_A245PedidosDetalleCantidad ;
   private long[] T00162_A13ArticuloId ;
   private long[] T001638_A18ImpuestoId ;
   private String[] T001638_A76ArticuloNombre ;
   private java.math.BigDecimal[] T001638_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] T001639_A83ImpuestoPorcentaje ;
   private long[] T001640_A51PedidosID ;
   private long[] T001640_A52PedidosDetalleID ;
   private long[] T001641_A4ClienteId ;
   private long[] T001642_A9TipoPagoId ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class pedidos__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class pedidos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00162", "SELECT [PedidosID], [PedidosDetalleID], [PedidosDetalleTallaID], [PedidosDetalleCantidad], [ArticuloId] FROM [PedidosDetalle] WITH (UPDLOCK) WHERE [PedidosID] = ? AND [PedidosDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00163", "SELECT [PedidosID], [PedidosDetalleID], [PedidosDetalleTallaID], [PedidosDetalleCantidad], [ArticuloId] FROM [PedidosDetalle] WHERE [PedidosID] = ? AND [PedidosDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00164", "SELECT [ImpuestoId], [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00165", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00166", "SELECT [PedidosID], [PedidosFecha], [PedidosEstado], [PedidosImagenComprobante], [PedidosImagenComprobante_GXI], [PedidosComprobanteObs], [PedidosUbicacion], [ClienteId], [TipoPagoId], [OpcionEnvioId] FROM [Pedidos] WITH (UPDLOCK) WHERE [PedidosID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00167", "SELECT [PedidosID], [PedidosFecha], [PedidosEstado], [PedidosImagenComprobante], [PedidosImagenComprobante_GXI], [PedidosComprobanteObs], [PedidosUbicacion], [ClienteId], [TipoPagoId], [OpcionEnvioId] FROM [Pedidos] WHERE [PedidosID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00168", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00169", "SELECT [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001610", "SELECT [OpcionEnvioDescripcion] FROM [OpcionEnvio] WHERE [OpcionEnvioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001612", "SELECT COALESCE( T1.[PedidosSubTotal], 0) AS PedidosSubTotal, COALESCE( T1.[PedidosSubTotal], 0) AS PedidosTotal FROM (SELECT T2.[PedidosID], SUM(T3.[ArticuloPrecioVenta] * CAST(T2.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosSubTotal FROM ([PedidosDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) GROUP BY T2.[PedidosID] ) T1 WHERE T1.[PedidosID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001614", "SELECT TM1.[PedidosID], TM1.[PedidosFecha], TM1.[PedidosEstado], T3.[OpcionEnvioDescripcion], TM1.[PedidosImagenComprobante], TM1.[PedidosImagenComprobante_GXI], TM1.[PedidosComprobanteObs], TM1.[PedidosUbicacion], TM1.[ClienteId], TM1.[TipoPagoId], TM1.[OpcionEnvioId], COALESCE( T2.[PedidosSubTotal], 0) AS PedidosSubTotal, COALESCE( T2.[PedidosSubTotal], 0) AS PedidosTotal FROM (([Pedidos] TM1 LEFT JOIN (SELECT T4.[PedidosID], SUM(T5.[ArticuloPrecioVenta] * CAST(T4.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosSubTotal FROM ([PedidosDetalle] T4 INNER JOIN [Articulo] T5 ON T5.[ArticuloId] = T4.[ArticuloId]) GROUP BY T4.[PedidosID] ) T2 ON T2.[PedidosID] = TM1.[PedidosID]) INNER JOIN [OpcionEnvio] T3 ON T3.[OpcionEnvioId] = TM1.[OpcionEnvioId]) WHERE TM1.[PedidosID] = ? ORDER BY TM1.[PedidosID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001616", "SELECT COALESCE( T1.[PedidosSubTotal], 0) AS PedidosSubTotal, COALESCE( T1.[PedidosSubTotal], 0) AS PedidosTotal FROM (SELECT T2.[PedidosID], SUM(T3.[ArticuloPrecioVenta] * CAST(T2.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosSubTotal FROM ([PedidosDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) GROUP BY T2.[PedidosID] ) T1 WHERE T1.[PedidosID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001617", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001618", "SELECT [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001619", "SELECT [OpcionEnvioDescripcion] FROM [OpcionEnvio] WHERE [OpcionEnvioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001620", "SELECT [PedidosID] FROM [Pedidos] WHERE [PedidosID] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001621", "SELECT TOP 1 [PedidosID] FROM [Pedidos] WHERE ( [PedidosID] > ?) ORDER BY [PedidosID]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001622", "SELECT TOP 1 [PedidosID] FROM [Pedidos] WHERE ( [PedidosID] < ?) ORDER BY [PedidosID] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001623", "INSERT INTO [Pedidos]([PedidosID], [PedidosFecha], [PedidosEstado], [PedidosImagenComprobante], [PedidosImagenComprobante_GXI], [PedidosComprobanteObs], [PedidosUbicacion], [ClienteId], [TipoPagoId], [OpcionEnvioId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001624", "UPDATE [Pedidos] SET [PedidosFecha]=?, [PedidosEstado]=?, [PedidosComprobanteObs]=?, [PedidosUbicacion]=?, [ClienteId]=?, [TipoPagoId]=?, [OpcionEnvioId]=?  WHERE [PedidosID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001625", "UPDATE [Pedidos] SET [PedidosImagenComprobante]=?, [PedidosImagenComprobante_GXI]=?  WHERE [PedidosID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001626", "DELETE FROM [Pedidos]  WHERE [PedidosID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001628", "SELECT COALESCE( T1.[PedidosSubTotal], 0) AS PedidosSubTotal, COALESCE( T1.[PedidosSubTotal], 0) AS PedidosTotal FROM (SELECT T2.[PedidosID], SUM(T3.[ArticuloPrecioVenta] * CAST(T2.[PedidosDetalleCantidad] AS decimal( 27, 10))) AS PedidosSubTotal FROM ([PedidosDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) GROUP BY T2.[PedidosID] ) T1 WHERE T1.[PedidosID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001629", "SELECT [OpcionEnvioDescripcion] FROM [OpcionEnvio] WHERE [OpcionEnvioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001630", "SELECT [PedidosID] FROM [Pedidos] ORDER BY [PedidosID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001631", "SELECT T2.[ImpuestoId], T1.[PedidosID], T1.[PedidosDetalleID], T2.[ArticuloNombre], T3.[ImpuestoPorcentaje], T2.[ArticuloPrecioVenta], T1.[PedidosDetalleTallaID], T1.[PedidosDetalleCantidad], T1.[ArticuloId] FROM (([PedidosDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) INNER JOIN [Impuesto] T3 ON T3.[ImpuestoId] = T2.[ImpuestoId]) WHERE T1.[PedidosID] = ? and T1.[PedidosDetalleID] = ? ORDER BY T1.[PedidosID], T1.[PedidosDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001632", "SELECT [ImpuestoId], [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001633", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001634", "SELECT [PedidosID], [PedidosDetalleID] FROM [PedidosDetalle] WHERE [PedidosID] = ? AND [PedidosDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001635", "INSERT INTO [PedidosDetalle]([PedidosID], [PedidosDetalleID], [PedidosDetalleTallaID], [PedidosDetalleCantidad], [ArticuloId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001636", "UPDATE [PedidosDetalle] SET [PedidosDetalleTallaID]=?, [PedidosDetalleCantidad]=?, [ArticuloId]=?  WHERE [PedidosID] = ? AND [PedidosDetalleID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001637", "DELETE FROM [PedidosDetalle]  WHERE [PedidosID] = ? AND [PedidosDetalleID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001638", "SELECT [ImpuestoId], [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001639", "SELECT [ImpuestoPorcentaje] FROM [Impuesto] WHERE [ImpuestoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001640", "SELECT [PedidosID], [PedidosDetalleID] FROM [PedidosDetalle] WHERE [PedidosID] = ? ORDER BY [PedidosID], [PedidosDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001641", "SELECT [ClienteId] FROM [Cliente] WHERE [ClienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001642", "SELECT [TipoPagoId] FROM [TipoPago] WHERE [TipoPagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 3 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(5));
               ((String[]) buf[4])[0] = rslt.getMultimediaUri(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 50);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(5));
               ((String[]) buf[4])[0] = rslt.getMultimediaUri(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 50);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               return;
            case 10 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 50);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               return;
            case 11 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
            case 22 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 24 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 25 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               return;
            case 26 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 27 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 28 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 32 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 80);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               return;
            case 33 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 34 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 35 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 36 :
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setBLOBFile(4, (String)parms[3], true);
               stmt.setGXDbFileURI(5, (String)parms[4], (String)parms[3], 2048,"Pedidos","PedidosImagenComprobante");
               stmt.setVarchar(6, (String)parms[5], 512, false);
               stmt.setString(7, (String)parms[6], 50);
               stmt.setLong(8, ((Number) parms[7]).longValue());
               stmt.setLong(9, ((Number) parms[8]).longValue());
               stmt.setLong(10, ((Number) parms[9]).longValue());
               return;
            case 19 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 512, false);
               stmt.setString(4, (String)parms[3], 50);
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setLong(7, ((Number) parms[6]).longValue());
               stmt.setLong(8, ((Number) parms[7]).longValue());
               return;
            case 20 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Pedidos","PedidosImagenComprobante");
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 21 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 22 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 23 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 25 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 26 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 27 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 28 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 29 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
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
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 31 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 32 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 33 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 34 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 35 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 36 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

