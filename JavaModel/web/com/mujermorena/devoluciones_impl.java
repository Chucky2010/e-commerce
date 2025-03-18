package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class devoluciones_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"DEVOLUCIONESID") == 0 )
      {
         AV7DevolucionesID = GXutil.lval( httpContext.GetPar( "DevolucionesID")) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7DevolucionesID), 10, 0));
         com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEVOLUCIONESID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7DevolucionesID), "ZZZZZZZZZ9")));
         AV16Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asadevolucionesid1852( AV7DevolucionesID, AV16Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel15"+"_"+"DEVOLUCIONESDETALLEID") == 0 )
      {
         AV16Pgmname = httpContext.GetPar( "Pgmname") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx15asadevolucionesdetalleid1853( AV16Pgmname) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A272DevolucionesID = GXutil.lval( httpContext.GetPar( "DevolucionesID")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A272DevolucionesID) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A19VentasId = GXutil.lval( httpContext.GetPar( "VentasId")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A19VentasId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A273MotivoDevolucionID = GXutil.lval( httpContext.GetPar( "MotivoDevolucionID")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A273MotivoDevolucionID) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A13ArticuloId = GXutil.lval( httpContext.GetPar( "ArticuloId")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A13ArticuloId) ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7DevolucionesID = GXutil.lval( httpContext.GetPar( "DevolucionesID")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7DevolucionesID), 10, 0));
            com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEVOLUCIONESID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7DevolucionesID), "ZZZZZZZZZ9")));
         }
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Devoluciones", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtDevolucionesFecha_Internalname ;
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
      nRC_GXsfl_71 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_71"))) ;
      nGXsfl_71_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_71_idx"))) ;
      sGXsfl_71_idx = httpContext.GetPar( "sGXsfl_71_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      AV16Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_detalle_newrow( ) ;
      /* End function gxnrGridlevel_detalle_newrow_invoke */
   }

   public devoluciones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public devoluciones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devoluciones_impl.class ));
   }

   public devoluciones_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynDevolucionesDetalleTallaID = new HTMLChoice();
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
      /* Text block */
      com.mujermorena.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, httpContext.getMessage( "Devoluciones", ""), "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleWWP", 0, "", 1, 1, 0, (short)(0), "HLP_Devoluciones.htm");
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
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDevolucionesID_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDevolucionesID_Internalname, httpContext.getMessage( "ID", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDevolucionesID_Internalname, GXutil.ltrim( localUtil.ntoc( A272DevolucionesID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtDevolucionesID_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A272DevolucionesID), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A272DevolucionesID), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDevolucionesID_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtDevolucionesID_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDentificador", "right", false, "", "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDevolucionesFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDevolucionesFecha_Internalname, httpContext.getMessage( "Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtDevolucionesFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDevolucionesFecha_Internalname, localUtil.format(A275DevolucionesFecha, "99/99/99"), localUtil.format( A275DevolucionesFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDevolucionesFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtDevolucionesFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtDevolucionesFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDevolucionesFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Devoluciones.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasId_Internalname, httpContext.getMessage( "Ventas Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasId_Internalname, GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19VentasId), "ZZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtVentasId_Enabled, 1, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Devoluciones.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_19_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_19_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_19_Internalname, sImgUrl, imgprompt_19_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_19_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtVentasFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtVentasFecha_Internalname, httpContext.getMessage( "Ventas Fecha", ""), " AttributeRealWidthDateLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtVentasFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtVentasFecha_Internalname, localUtil.format(A91VentasFecha, "99/99/99"), localUtil.format( A91VentasFecha, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtVentasFecha_Jsonclick, 0, "AttributeRealWidthDate", "", "", "", "", 1, edtVentasFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, edtVentasFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtVentasFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Devoluciones.htm");
      httpContext.writeTextNL( "</div>") ;
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtClienteId_Internalname, httpContext.getMessage( "Cliente Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtClienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtClienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClienteId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtClienteId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtTipoPagoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtTipoPagoId_Internalname, httpContext.getMessage( "Tipo Pago Id", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtTipoPagoId_Internalname, GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtTipoPagoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A9TipoPagoId), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtTipoPagoId_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtTipoPagoId_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDN11", "right", false, "", "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMotivoDevolucionID_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMotivoDevolucionID_Internalname, httpContext.getMessage( "Motivo Devolucion ID", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMotivoDevolucionID_Internalname, GXutil.ltrim( localUtil.ntoc( A273MotivoDevolucionID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A273MotivoDevolucionID), "ZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMotivoDevolucionID_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMotivoDevolucionID_Enabled, 1, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "IDentificador", "right", false, "", "HLP_Devoluciones.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_273_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_273_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.mujermorena.GxWebStd.gx_bitmap( httpContext, imgprompt_273_Internalname, sImgUrl, imgprompt_273_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_273_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMotivoDevolucionDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtMotivoDevolucionDescripcion_Internalname, httpContext.getMessage( "Motivo Devolucion Descripcion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtMotivoDevolucionDescripcion_Internalname, A280MotivoDevolucionDescripcion, GXutil.rtrim( localUtil.format( A280MotivoDevolucionDescripcion, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMotivoDevolucionDescripcion_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtMotivoDevolucionDescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Descripcion", "left", true, "", "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDevolucionesObservacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDevolucionesObservacion_Internalname, httpContext.getMessage( "Observacion", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      ClassString = "AttributeRealWidth" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_html_textarea( httpContext, edtDevolucionesObservacion_Internalname, A279DevolucionesObservacion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", (short)(0), 1, edtDevolucionesObservacion_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", 1, 0, "", "", (byte)(-1), true, "Observacion", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDevolucionesTotal_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.mujermorena.GxWebStd.gx_label_element( httpContext, edtDevolucionesTotal_Internalname, httpContext.getMessage( "Total", ""), " AttributeRealWidthLabel", 1, true, "");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.mujermorena.GxWebStd.gx_single_line_edit( httpContext, edtDevolucionesTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A276DevolucionesTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtDevolucionesTotal_Enabled!=0) ? localUtil.format( A276DevolucionesTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A276DevolucionesTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDevolucionesTotal_Jsonclick, 0, "AttributeRealWidth", "", "", "", "", 1, edtDevolucionesTotal_Enabled, 0, "text", "", 21, "chr", 1, "row", 21, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Monto", "right", false, "", "HLP_Devoluciones.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Devoluciones.htm");
      com.mujermorena.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.mujermorena.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.mujermorena.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Devoluciones.htm");
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
      startgridcontrol71( ) ;
      nGXsfl_71_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount53 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_53 = (short)(1) ;
            scanStart1853( ) ;
            while ( RcdFound53 != 0 )
            {
               init_level_properties53( ) ;
               getByPrimaryKey1853( ) ;
               addRow1853( ) ;
               scanNext1853( ) ;
            }
            scanEnd1853( ) ;
            nBlankRcdCount53 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B276DevolucionesTotal = A276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         standaloneNotModal1853( ) ;
         standaloneModal1853( ) ;
         sMode53 = Gx_mode ;
         while ( nGXsfl_71_idx < nRC_GXsfl_71 )
         {
            bGXsfl_71_Refreshing = true ;
            readRow1853( ) ;
            edtDevolucionesDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLEID_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleID_Enabled), 5, 0), !bGXsfl_71_Refreshing);
            edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_71_Refreshing);
            edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_71_Refreshing);
            edtArticuloPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOPRECIOVENTA_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), !bGXsfl_71_Refreshing);
            edtDevolucionesDetalleCant_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleCant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleCant_Enabled), 5, 0), !bGXsfl_71_Refreshing);
            edtDevolucionesDetalleTotal_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleTotal_Enabled), 5, 0), !bGXsfl_71_Refreshing);
            dynDevolucionesDetalleTallaID.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynDevolucionesDetalleTallaID.getInternalname(), "Enabled", GXutil.ltrimstr( dynDevolucionesDetalleTallaID.getEnabled(), 5, 0), !bGXsfl_71_Refreshing);
            imgprompt_19_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_71_idx+"Link") ;
            if ( ( nRcdExists_53 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal1853( ) ;
            }
            sendRow1853( ) ;
            bGXsfl_71_Refreshing = false ;
         }
         Gx_mode = sMode53 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A276DevolucionesTotal = B276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount53 = (short)(5) ;
         nRcdExists_53 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart1853( ) ;
            while ( RcdFound53 != 0 )
            {
               sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_7153( ) ;
               init_level_properties53( ) ;
               standaloneNotModal1853( ) ;
               getByPrimaryKey1853( ) ;
               standaloneModal1853( ) ;
               addRow1853( ) ;
               scanNext1853( ) ;
            }
            scanEnd1853( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode53 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_7153( ) ;
         initAll1853( ) ;
         init_level_properties53( ) ;
         B276DevolucionesTotal = A276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         nRcdExists_53 = (short)(0) ;
         nIsMod_53 = (short)(0) ;
         nRcdDeleted_53 = (short)(0) ;
         nBlankRcdCount53 = (short)(nBlankRcdUsr53+nBlankRcdCount53) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount53 > 0 )
         {
            standaloneNotModal1853( ) ;
            standaloneModal1853( ) ;
            addRow1853( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtDevolucionesDetalleID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount53 = (short)(nBlankRcdCount53-1) ;
         }
         Gx_mode = sMode53 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A276DevolucionesTotal = B276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
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
      e11182 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z272DevolucionesID = localUtil.ctol( httpContext.cgiGet( "Z272DevolucionesID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z275DevolucionesFecha = localUtil.ctod( httpContext.cgiGet( "Z275DevolucionesFecha"), 0) ;
            Z19VentasId = localUtil.ctol( httpContext.cgiGet( "Z19VentasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z273MotivoDevolucionID = localUtil.ctol( httpContext.cgiGet( "Z273MotivoDevolucionID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            O276DevolucionesTotal = localUtil.ctond( httpContext.cgiGet( "O276DevolucionesTotal")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_71 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_71"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N19VentasId = localUtil.ctol( httpContext.cgiGet( "N19VentasId"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            N273MotivoDevolucionID = localUtil.ctol( httpContext.cgiGet( "N273MotivoDevolucionID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV7DevolucionesID = localUtil.ctol( httpContext.cgiGet( "vDEVOLUCIONESID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            AV13Insert_VentasId = localUtil.ctol( httpContext.cgiGet( "vINSERT_VENTASID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            AV14Insert_MotivoDevolucionID = localUtil.ctol( httpContext.cgiGet( "vINSERT_MOTIVODEVOLUCIONID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
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
            A272DevolucionesID = localUtil.ctol( httpContext.cgiGet( edtDevolucionesID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
            if ( localUtil.vcdate( httpContext.cgiGet( edtDevolucionesFecha_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "DEVOLUCIONESFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDevolucionesFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A275DevolucionesFecha = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A275DevolucionesFecha", localUtil.format(A275DevolucionesFecha, "99/99/99"));
            }
            else
            {
               A275DevolucionesFecha = localUtil.ctod( httpContext.cgiGet( edtDevolucionesFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A275DevolucionesFecha", localUtil.format(A275DevolucionesFecha, "99/99/99"));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "VENTASID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtVentasId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A19VentasId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
            }
            else
            {
               A19VentasId = localUtil.ctol( httpContext.cgiGet( edtVentasId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
            }
            A91VentasFecha = localUtil.ctod( httpContext.cgiGet( edtVentasFecha_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
            A4ClienteId = localUtil.ctol( httpContext.cgiGet( edtClienteId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
            A9TipoPagoId = localUtil.ctol( httpContext.cgiGet( edtTipoPagoId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMotivoDevolucionID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMotivoDevolucionID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MOTIVODEVOLUCIONID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMotivoDevolucionID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A273MotivoDevolucionID = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
            }
            else
            {
               A273MotivoDevolucionID = localUtil.ctol( httpContext.cgiGet( edtMotivoDevolucionID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
            }
            A280MotivoDevolucionDescripcion = httpContext.cgiGet( edtMotivoDevolucionDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
            A279DevolucionesObservacion = httpContext.cgiGet( edtDevolucionesObservacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A279DevolucionesObservacion", A279DevolucionesObservacion);
            A276DevolucionesTotal = localUtil.ctond( httpContext.cgiGet( edtDevolucionesTotal_Internalname)) ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Devoluciones");
            A272DevolucionesID = localUtil.ctol( httpContext.cgiGet( edtDevolucionesID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
            forbiddenHiddens.add("DevolucionesID", localUtil.format( DecimalUtil.doubleToDec(A272DevolucionesID), "ZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A272DevolucionesID != Z272DevolucionesID ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("devoluciones:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A272DevolucionesID = GXutil.lval( httpContext.GetPar( "DevolucionesID")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode52 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode52 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound52 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_180( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "DEVOLUCIONESID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtDevolucionesID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
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
                        e11182 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12182 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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
         e12182 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1852( ) ;
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
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes1852( ) ;
      }
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

   public void confirm_180( )
   {
      beforeValidate1852( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1852( ) ;
         }
         else
         {
            checkExtendedTable1852( ) ;
            closeExtendedTableCursors1852( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode52 = Gx_mode ;
         confirm_1853( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode52 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode52 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_1853( )
   {
      s276DevolucionesTotal = O276DevolucionesTotal ;
      n276DevolucionesTotal = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      nGXsfl_71_idx = 0 ;
      while ( nGXsfl_71_idx < nRC_GXsfl_71 )
      {
         readRow1853( ) ;
         if ( ( nRcdExists_53 != 0 ) || ( nIsMod_53 != 0 ) )
         {
            getKey1853( ) ;
            if ( ( nRcdExists_53 == 0 ) && ( nRcdDeleted_53 == 0 ) )
            {
               if ( RcdFound53 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate1853( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1853( ) ;
                     closeExtendedTableCursors1853( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                     O276DevolucionesTotal = A276DevolucionesTotal ;
                     n276DevolucionesTotal = false ;
                     httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
                  }
               }
               else
               {
                  GXCCtl = "DEVOLUCIONESDETALLEID_" + sGXsfl_71_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtDevolucionesDetalleID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound53 != 0 )
               {
                  if ( nRcdDeleted_53 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey1853( ) ;
                     load1853( ) ;
                     beforeValidate1853( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1853( ) ;
                        O276DevolucionesTotal = A276DevolucionesTotal ;
                        n276DevolucionesTotal = false ;
                        httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
                     }
                  }
                  else
                  {
                     if ( nIsMod_53 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate1853( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1853( ) ;
                           closeExtendedTableCursors1853( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                           O276DevolucionesTotal = A276DevolucionesTotal ;
                           n276DevolucionesTotal = false ;
                           httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_53 == 0 )
                  {
                     GXCCtl = "DEVOLUCIONESDETALLEID_" + sGXsfl_71_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtDevolucionesDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtDevolucionesDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A274DevolucionesDetalleID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtDevolucionesDetalleCant_Internalname, GXutil.ltrim( localUtil.ntoc( A278DevolucionesDetalleCant, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtDevolucionesDetalleTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A277DevolucionesDetalleTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynDevolucionesDetalleTallaID.getInternalname(), GXutil.ltrim( localUtil.ntoc( A303DevolucionesDetalleTallaID, (byte)(11), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z274DevolucionesDetalleID_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z274DevolucionesDetalleID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z303DevolucionesDetalleTallaID_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z303DevolucionesDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z278DevolucionesDetalleCant_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z278DevolucionesDetalleCant, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T277DevolucionesDetalleTotal_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( O277DevolucionesDetalleTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_53_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_53_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_53_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_53 != 0 )
         {
            httpContext.changePostValue( "DEVOLUCIONESDETALLEID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOPRECIOVENTA_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleCant_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynDevolucionesDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      O276DevolucionesTotal = s276DevolucionesTotal ;
      n276DevolucionesTotal = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption180( )
   {
   }

   public void e11182( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV16Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV17GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GXV1), 8, 0));
         while ( AV17GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV17GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "VentasId") == 0 )
            {
               AV13Insert_VentasId = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_VentasId), 11, 0));
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MotivoDevolucionID") == 0 )
            {
               AV14Insert_MotivoDevolucionID = GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_MotivoDevolucionID), 10, 0));
            }
            AV17GXV1 = (int)(AV17GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17GXV1), 8, 0));
         }
      }
   }

   public void e12182( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         new com.mujermorena.stockdevoluciones(remoteHandle, context).execute( A272DevolucionesID) ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.mujermorena.devolucionesww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm1852( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z275DevolucionesFecha = T00186_A275DevolucionesFecha[0] ;
            Z19VentasId = T00186_A19VentasId[0] ;
            Z273MotivoDevolucionID = T00186_A273MotivoDevolucionID[0] ;
         }
         else
         {
            Z275DevolucionesFecha = A275DevolucionesFecha ;
            Z19VentasId = A19VentasId ;
            Z273MotivoDevolucionID = A273MotivoDevolucionID ;
         }
      }
      if ( GX_JID == -16 )
      {
         Z272DevolucionesID = A272DevolucionesID ;
         Z275DevolucionesFecha = A275DevolucionesFecha ;
         Z279DevolucionesObservacion = A279DevolucionesObservacion ;
         Z19VentasId = A19VentasId ;
         Z273MotivoDevolucionID = A273MotivoDevolucionID ;
         Z276DevolucionesTotal = A276DevolucionesTotal ;
         Z91VentasFecha = A91VentasFecha ;
         Z4ClienteId = A4ClienteId ;
         Z9TipoPagoId = A9TipoPagoId ;
         Z280MotivoDevolucionDescripcion = A280MotivoDevolucionDescripcion ;
      }
   }

   public void standaloneNotModal( )
   {
      edtDevolucionesID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesID_Enabled), 5, 0), true);
      AV16Pgmname = "Devoluciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      imgprompt_19_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.ventasprompt"+"',["+"{Ctrl:gx.dom.el('"+"VENTASID"+"'), id:'"+"VENTASID"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_273_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.motivodevolucionprompt"+"',["+"{Ctrl:gx.dom.el('"+"MOTIVODEVOLUCIONID"+"'), id:'"+"MOTIVODEVOLUCIONID"+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"MOTIVODEVOLUCIONDESCRIPCION"+"'), id:'"+"MOTIVODEVOLUCIONDESCRIPCION"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtDevolucionesID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesID_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7DevolucionesID) )
      {
         A272DevolucionesID = AV7DevolucionesID ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A272DevolucionesID ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int3) ;
            devoluciones_impl.this.GXt_int2 = GXv_int3[0] ;
            A272DevolucionesID = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_VentasId) )
      {
         edtVentasId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      }
      else
      {
         edtVentasId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_MotivoDevolucionID) )
      {
         edtMotivoDevolucionID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMotivoDevolucionID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMotivoDevolucionID_Enabled), 5, 0), true);
      }
      else
      {
         edtMotivoDevolucionID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMotivoDevolucionID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMotivoDevolucionID_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         A275DevolucionesFecha = GXutil.serverDate( context, remoteHandle, pr_default) ;
         httpContext.ajax_rsp_assign_attri("", false, "A275DevolucionesFecha", localUtil.format(A275DevolucionesFecha, "99/99/99"));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_MotivoDevolucionID) )
      {
         A273MotivoDevolucionID = AV14Insert_MotivoDevolucionID ;
         httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_VentasId) )
      {
         A19VentasId = AV13Insert_VentasId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
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
         /* Using cursor T001810 */
         pr_default.execute(7, new Object[] {Long.valueOf(A272DevolucionesID)});
         if ( (pr_default.getStatus(7) != 101) )
         {
            A276DevolucionesTotal = T001810_A276DevolucionesTotal[0] ;
            n276DevolucionesTotal = T001810_n276DevolucionesTotal[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         else
         {
            A276DevolucionesTotal = DecimalUtil.doubleToDec(0) ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         O276DevolucionesTotal = A276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         pr_default.close(7);
         /* Using cursor T00188 */
         pr_default.execute(6, new Object[] {Long.valueOf(A273MotivoDevolucionID)});
         A280MotivoDevolucionDescripcion = T00188_A280MotivoDevolucionDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
         pr_default.close(6);
         /* Using cursor T00187 */
         pr_default.execute(5, new Object[] {Long.valueOf(A19VentasId)});
         A91VentasFecha = T00187_A91VentasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
         A4ClienteId = T00187_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T00187_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         pr_default.close(5);
      }
   }

   public void load1852( )
   {
      /* Using cursor T001812 */
      pr_default.execute(8, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A275DevolucionesFecha = T001812_A275DevolucionesFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A275DevolucionesFecha", localUtil.format(A275DevolucionesFecha, "99/99/99"));
         A91VentasFecha = T001812_A91VentasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
         A280MotivoDevolucionDescripcion = T001812_A280MotivoDevolucionDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
         A279DevolucionesObservacion = T001812_A279DevolucionesObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A279DevolucionesObservacion", A279DevolucionesObservacion);
         A19VentasId = T001812_A19VentasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         A273MotivoDevolucionID = T001812_A273MotivoDevolucionID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
         A4ClienteId = T001812_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T001812_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         A276DevolucionesTotal = T001812_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = T001812_n276DevolucionesTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         zm1852( -16) ;
      }
      pr_default.close(8);
      onLoadActions1852( ) ;
   }

   public void onLoadActions1852( )
   {
      O276DevolucionesTotal = A276DevolucionesTotal ;
      n276DevolucionesTotal = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
   }

   public void checkExtendedTable1852( )
   {
      nIsDirty_52 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T001810 */
      pr_default.execute(7, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         A276DevolucionesTotal = T001810_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = T001810_n276DevolucionesTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      else
      {
         nIsDirty_52 = (short)(1) ;
         A276DevolucionesTotal = DecimalUtil.doubleToDec(0) ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      pr_default.close(7);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A275DevolucionesFecha)) || (( GXutil.resetTime(A275DevolucionesFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A275DevolucionesFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Devoluciones Fecha", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "DEVOLUCIONESFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDevolucionesFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00187 */
      pr_default.execute(5, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ventas", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "VENTASID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A91VentasFecha = T00187_A91VentasFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
      A4ClienteId = T00187_A4ClienteId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      A9TipoPagoId = T00187_A9TipoPagoId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
      pr_default.close(5);
      /* Using cursor T00188 */
      pr_default.execute(6, new Object[] {Long.valueOf(A273MotivoDevolucionID)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Devolucion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MOTIVODEVOLUCIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMotivoDevolucionID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A280MotivoDevolucionDescripcion = T00188_A280MotivoDevolucionDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
      pr_default.close(6);
   }

   public void closeExtendedTableCursors1852( )
   {
      pr_default.close(7);
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_19( long A272DevolucionesID )
   {
      /* Using cursor T001814 */
      pr_default.execute(9, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A276DevolucionesTotal = T001814_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = T001814_n276DevolucionesTotal[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      else
      {
         A276DevolucionesTotal = DecimalUtil.doubleToDec(0) ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A276DevolucionesTotal, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_17( long A19VentasId )
   {
      /* Using cursor T001815 */
      pr_default.execute(10, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ventas", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "VENTASID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A91VentasFecha = T001815_A91VentasFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
      A4ClienteId = T001815_A4ClienteId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      A9TipoPagoId = T001815_A9TipoPagoId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.format(A91VentasFecha, "99/99/99"))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_18( long A273MotivoDevolucionID )
   {
      /* Using cursor T001816 */
      pr_default.execute(11, new Object[] {Long.valueOf(A273MotivoDevolucionID)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Devolucion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MOTIVODEVOLUCIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMotivoDevolucionID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A280MotivoDevolucionDescripcion = T001816_A280MotivoDevolucionDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A280MotivoDevolucionDescripcion)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void getKey1852( )
   {
      /* Using cursor T001817 */
      pr_default.execute(12, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound52 = (short)(1) ;
      }
      else
      {
         RcdFound52 = (short)(0) ;
      }
      pr_default.close(12);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00186 */
      pr_default.execute(4, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm1852( 16) ;
         RcdFound52 = (short)(1) ;
         A272DevolucionesID = T00186_A272DevolucionesID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
         A275DevolucionesFecha = T00186_A275DevolucionesFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A275DevolucionesFecha", localUtil.format(A275DevolucionesFecha, "99/99/99"));
         A279DevolucionesObservacion = T00186_A279DevolucionesObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A279DevolucionesObservacion", A279DevolucionesObservacion);
         A19VentasId = T00186_A19VentasId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
         A273MotivoDevolucionID = T00186_A273MotivoDevolucionID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
         Z272DevolucionesID = A272DevolucionesID ;
         sMode52 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1852( ) ;
         if ( AnyError == 1 )
         {
            RcdFound52 = (short)(0) ;
            initializeNonKey1852( ) ;
         }
         Gx_mode = sMode52 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound52 = (short)(0) ;
         initializeNonKey1852( ) ;
         sMode52 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode52 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey1852( ) ;
      if ( RcdFound52 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound52 = (short)(0) ;
      /* Using cursor T001818 */
      pr_default.execute(13, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T001818_A272DevolucionesID[0] < A272DevolucionesID ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T001818_A272DevolucionesID[0] > A272DevolucionesID ) ) )
         {
            A272DevolucionesID = T001818_A272DevolucionesID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
            RcdFound52 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void move_previous( )
   {
      RcdFound52 = (short)(0) ;
      /* Using cursor T001819 */
      pr_default.execute(14, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( T001819_A272DevolucionesID[0] > A272DevolucionesID ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( T001819_A272DevolucionesID[0] < A272DevolucionesID ) ) )
         {
            A272DevolucionesID = T001819_A272DevolucionesID[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
            RcdFound52 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1852( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         A276DevolucionesTotal = O276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         GX_FocusControl = edtDevolucionesFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1852( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound52 == 1 )
         {
            if ( A272DevolucionesID != Z272DevolucionesID )
            {
               A272DevolucionesID = Z272DevolucionesID ;
               httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "DEVOLUCIONESID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDevolucionesID_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               A276DevolucionesTotal = O276DevolucionesTotal ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtDevolucionesFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               A276DevolucionesTotal = O276DevolucionesTotal ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
               update1852( ) ;
               GX_FocusControl = edtDevolucionesFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A272DevolucionesID != Z272DevolucionesID )
            {
               /* Insert record */
               A276DevolucionesTotal = O276DevolucionesTotal ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
               GX_FocusControl = edtDevolucionesFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1852( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "DEVOLUCIONESID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtDevolucionesID_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  A276DevolucionesTotal = O276DevolucionesTotal ;
                  n276DevolucionesTotal = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
                  GX_FocusControl = edtDevolucionesFecha_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1852( ) ;
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
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( A272DevolucionesID != Z272DevolucionesID )
      {
         A272DevolucionesID = Z272DevolucionesID ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "DEVOLUCIONESID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDevolucionesID_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         A276DevolucionesTotal = O276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtDevolucionesFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1852( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00185 */
         pr_default.execute(3, new Object[] {Long.valueOf(A272DevolucionesID)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Devoluciones"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(3) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z275DevolucionesFecha), GXutil.resetTime(T00185_A275DevolucionesFecha[0])) ) || ( Z19VentasId != T00185_A19VentasId[0] ) || ( Z273MotivoDevolucionID != T00185_A273MotivoDevolucionID[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z275DevolucionesFecha), GXutil.resetTime(T00185_A275DevolucionesFecha[0])) ) )
            {
               GXutil.writeLogln("devoluciones:[seudo value changed for attri]"+"DevolucionesFecha");
               GXutil.writeLogRaw("Old: ",Z275DevolucionesFecha);
               GXutil.writeLogRaw("Current: ",T00185_A275DevolucionesFecha[0]);
            }
            if ( Z19VentasId != T00185_A19VentasId[0] )
            {
               GXutil.writeLogln("devoluciones:[seudo value changed for attri]"+"VentasId");
               GXutil.writeLogRaw("Old: ",Z19VentasId);
               GXutil.writeLogRaw("Current: ",T00185_A19VentasId[0]);
            }
            if ( Z273MotivoDevolucionID != T00185_A273MotivoDevolucionID[0] )
            {
               GXutil.writeLogln("devoluciones:[seudo value changed for attri]"+"MotivoDevolucionID");
               GXutil.writeLogRaw("Old: ",Z273MotivoDevolucionID);
               GXutil.writeLogRaw("Current: ",T00185_A273MotivoDevolucionID[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Devoluciones"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1852( )
   {
      if ( ! IsAuthorized("devoluciones_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1852( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1852( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1852( 0) ;
         checkOptimisticConcurrency1852( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1852( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1852( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001820 */
                  pr_default.execute(15, new Object[] {Long.valueOf(A272DevolucionesID), A275DevolucionesFecha, A279DevolucionesObservacion, Long.valueOf(A19VentasId), Long.valueOf(A273MotivoDevolucionID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Devoluciones");
                  if ( (pr_default.getStatus(15) == 1) )
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
                        processLevel1852( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption180( ) ;
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
            load1852( ) ;
         }
         endLevel1852( ) ;
      }
      closeExtendedTableCursors1852( ) ;
   }

   public void update1852( )
   {
      if ( ! IsAuthorized("devoluciones_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1852( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1852( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1852( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1852( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1852( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001821 */
                  pr_default.execute(16, new Object[] {A275DevolucionesFecha, A279DevolucionesObservacion, Long.valueOf(A19VentasId), Long.valueOf(A273MotivoDevolucionID), Long.valueOf(A272DevolucionesID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Devoluciones");
                  if ( (pr_default.getStatus(16) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Devoluciones"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1852( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1852( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
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
         }
         endLevel1852( ) ;
      }
      closeExtendedTableCursors1852( ) ;
   }

   public void deferredUpdate1852( )
   {
   }

   public void delete( )
   {
      if ( ! IsAuthorized("devoluciones_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1852( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1852( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1852( ) ;
         afterConfirm1852( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1852( ) ;
            if ( AnyError == 0 )
            {
               A276DevolucionesTotal = O276DevolucionesTotal ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
               scanStart1853( ) ;
               while ( RcdFound53 != 0 )
               {
                  getByPrimaryKey1853( ) ;
                  delete1853( ) ;
                  scanNext1853( ) ;
                  O276DevolucionesTotal = A276DevolucionesTotal ;
                  n276DevolucionesTotal = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
               }
               scanEnd1853( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001822 */
                  pr_default.execute(17, new Object[] {Long.valueOf(A272DevolucionesID)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Devoluciones");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
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
         }
      }
      sMode52 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1852( ) ;
      Gx_mode = sMode52 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1852( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001824 */
         pr_default.execute(18, new Object[] {Long.valueOf(A272DevolucionesID)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            A276DevolucionesTotal = T001824_A276DevolucionesTotal[0] ;
            n276DevolucionesTotal = T001824_n276DevolucionesTotal[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         else
         {
            A276DevolucionesTotal = DecimalUtil.doubleToDec(0) ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         pr_default.close(18);
         /* Using cursor T001825 */
         pr_default.execute(19, new Object[] {Long.valueOf(A19VentasId)});
         A91VentasFecha = T001825_A91VentasFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
         A4ClienteId = T001825_A4ClienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
         A9TipoPagoId = T001825_A9TipoPagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
         pr_default.close(19);
         /* Using cursor T001826 */
         pr_default.execute(20, new Object[] {Long.valueOf(A273MotivoDevolucionID)});
         A280MotivoDevolucionDescripcion = T001826_A280MotivoDevolucionDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
         pr_default.close(20);
      }
   }

   public void processNestedLevel1853( )
   {
      s276DevolucionesTotal = O276DevolucionesTotal ;
      n276DevolucionesTotal = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      nGXsfl_71_idx = 0 ;
      while ( nGXsfl_71_idx < nRC_GXsfl_71 )
      {
         readRow1853( ) ;
         if ( ( nRcdExists_53 != 0 ) || ( nIsMod_53 != 0 ) )
         {
            standaloneNotModal1853( ) ;
            getKey1853( ) ;
            if ( ( nRcdExists_53 == 0 ) && ( nRcdDeleted_53 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert1853( ) ;
            }
            else
            {
               if ( RcdFound53 != 0 )
               {
                  if ( ( nRcdDeleted_53 != 0 ) && ( nRcdExists_53 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete1853( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_53 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update1853( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_53 == 0 )
                  {
                     GXCCtl = "DEVOLUCIONESDETALLEID_" + sGXsfl_71_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtDevolucionesDetalleID_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
            O276DevolucionesTotal = A276DevolucionesTotal ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         httpContext.changePostValue( edtDevolucionesDetalleID_Internalname, GXutil.ltrim( localUtil.ntoc( A274DevolucionesDetalleID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloId_Internalname, GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtArticuloNombre_Internalname, GXutil.rtrim( A76ArticuloNombre)) ;
         httpContext.changePostValue( edtArticuloPrecioVenta_Internalname, GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtDevolucionesDetalleCant_Internalname, GXutil.ltrim( localUtil.ntoc( A278DevolucionesDetalleCant, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtDevolucionesDetalleTotal_Internalname, GXutil.ltrim( localUtil.ntoc( A277DevolucionesDetalleTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( dynDevolucionesDetalleTallaID.getInternalname(), GXutil.ltrim( localUtil.ntoc( A303DevolucionesDetalleTallaID, (byte)(11), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z274DevolucionesDetalleID_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z274DevolucionesDetalleID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z303DevolucionesDetalleTallaID_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z303DevolucionesDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z278DevolucionesDetalleCant_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z278DevolucionesDetalleCant, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T277DevolucionesDetalleTotal_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( O277DevolucionesDetalleTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_53_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_53_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_53_"+sGXsfl_71_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_53 != 0 )
         {
            httpContext.changePostValue( "DEVOLUCIONESDETALLEID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleID_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULONOMBRE_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ARTICULOPRECIOVENTA_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleCant_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynDevolucionesDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1853( ) ;
      if ( AnyError != 0 )
      {
         O276DevolucionesTotal = s276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      nRcdExists_53 = (short)(0) ;
      nIsMod_53 = (short)(0) ;
      nRcdDeleted_53 = (short)(0) ;
   }

   public void processLevel1852( )
   {
      /* Save parent mode. */
      sMode52 = Gx_mode ;
      processNestedLevel1853( ) ;
      if ( AnyError != 0 )
      {
         O276DevolucionesTotal = s276DevolucionesTotal ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      /* Restore parent mode. */
      Gx_mode = sMode52 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1852( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1852( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(19);
         pr_default.close(20);
         pr_default.close(18);
         pr_default.close(2);
         Application.commitDataStores(context, remoteHandle, pr_default, "devoluciones");
         if ( AnyError == 0 )
         {
            confirmValues180( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(19);
         pr_default.close(20);
         pr_default.close(18);
         pr_default.close(2);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "devoluciones");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1852( )
   {
      /* Scan By routine */
      /* Using cursor T001827 */
      pr_default.execute(21);
      RcdFound52 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A272DevolucionesID = T001827_A272DevolucionesID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1852( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound52 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A272DevolucionesID = T001827_A272DevolucionesID[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
      }
   }

   public void scanEnd1852( )
   {
      pr_default.close(21);
   }

   public void afterConfirm1852( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1852( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1852( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1852( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1852( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1852( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1852( )
   {
      edtDevolucionesID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesID_Enabled), 5, 0), true);
      edtDevolucionesFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesFecha_Enabled), 5, 0), true);
      edtVentasId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasId_Enabled), 5, 0), true);
      edtVentasFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtVentasFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtVentasFecha_Enabled), 5, 0), true);
      edtClienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClienteId_Enabled), 5, 0), true);
      edtTipoPagoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtTipoPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtTipoPagoId_Enabled), 5, 0), true);
      edtMotivoDevolucionID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMotivoDevolucionID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMotivoDevolucionID_Enabled), 5, 0), true);
      edtMotivoDevolucionDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMotivoDevolucionDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMotivoDevolucionDescripcion_Enabled), 5, 0), true);
      edtDevolucionesObservacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesObservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesObservacion_Enabled), 5, 0), true);
      edtDevolucionesTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesTotal_Enabled), 5, 0), true);
   }

   public void zm1853( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z303DevolucionesDetalleTallaID = T00183_A303DevolucionesDetalleTallaID[0] ;
            Z278DevolucionesDetalleCant = T00183_A278DevolucionesDetalleCant[0] ;
            Z13ArticuloId = T00183_A13ArticuloId[0] ;
         }
         else
         {
            Z303DevolucionesDetalleTallaID = A303DevolucionesDetalleTallaID ;
            Z278DevolucionesDetalleCant = A278DevolucionesDetalleCant ;
            Z13ArticuloId = A13ArticuloId ;
         }
      }
      if ( GX_JID == -20 )
      {
         Z272DevolucionesID = A272DevolucionesID ;
         Z274DevolucionesDetalleID = A274DevolucionesDetalleID ;
         Z303DevolucionesDetalleTallaID = A303DevolucionesDetalleTallaID ;
         Z278DevolucionesDetalleCant = A278DevolucionesDetalleCant ;
         Z13ArticuloId = A13ArticuloId ;
         Z76ArticuloNombre = A76ArticuloNombre ;
         Z78ArticuloPrecioVenta = A78ArticuloPrecioVenta ;
      }
   }

   public void standaloneNotModal1853( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A274DevolucionesDetalleID ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int3) ;
         devoluciones_impl.this.GXt_int2 = GXv_int3[0] ;
         A274DevolucionesDetalleID = GXt_int2 ;
      }
   }

   public void standaloneModal1853( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtDevolucionesDetalleID_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleID_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      }
      else
      {
         edtDevolucionesDetalleID_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleID_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      }
   }

   public void load1853( )
   {
      /* Using cursor T001828 */
      pr_default.execute(22, new Object[] {Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID)});
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A76ArticuloNombre = T001828_A76ArticuloNombre[0] ;
         A78ArticuloPrecioVenta = T001828_A78ArticuloPrecioVenta[0] ;
         A303DevolucionesDetalleTallaID = T001828_A303DevolucionesDetalleTallaID[0] ;
         A278DevolucionesDetalleCant = T001828_A278DevolucionesDetalleCant[0] ;
         A13ArticuloId = T001828_A13ArticuloId[0] ;
         zm1853( -20) ;
      }
      pr_default.close(22);
      onLoadActions1853( ) ;
   }

   public void onLoadActions1853( )
   {
      A277DevolucionesDetalleTotal = A78ArticuloPrecioVenta.multiply(DecimalUtil.doubleToDec(A278DevolucionesDetalleCant)) ;
      O277DevolucionesDetalleTotal = A277DevolucionesDetalleTotal ;
      if ( isIns( )  )
      {
         A276DevolucionesTotal = O276DevolucionesTotal.add(A277DevolucionesDetalleTotal) ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            A276DevolucionesTotal = O276DevolucionesTotal.add(A277DevolucionesDetalleTotal).subtract(O277DevolucionesDetalleTotal) ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               A276DevolucionesTotal = O276DevolucionesTotal.subtract(O277DevolucionesDetalleTotal) ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
            }
         }
      }
   }

   public void checkExtendedTable1853( )
   {
      nIsDirty_53 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1853( ) ;
      /* Using cursor T00184 */
      pr_default.execute(2, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_71_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A76ArticuloNombre = T00184_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T00184_A78ArticuloPrecioVenta[0] ;
      pr_default.close(2);
      nIsDirty_53 = (short)(1) ;
      A277DevolucionesDetalleTotal = A78ArticuloPrecioVenta.multiply(DecimalUtil.doubleToDec(A278DevolucionesDetalleCant)) ;
      if ( isIns( )  )
      {
         nIsDirty_53 = (short)(1) ;
         A276DevolucionesTotal = O276DevolucionesTotal.add(A277DevolucionesDetalleTotal) ;
         n276DevolucionesTotal = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      }
      else
      {
         if ( isUpd( )  )
         {
            nIsDirty_53 = (short)(1) ;
            A276DevolucionesTotal = O276DevolucionesTotal.add(A277DevolucionesDetalleTotal).subtract(O277DevolucionesDetalleTotal) ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         else
         {
            if ( isDlt( )  )
            {
               nIsDirty_53 = (short)(1) ;
               A276DevolucionesTotal = O276DevolucionesTotal.subtract(O277DevolucionesDetalleTotal) ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
            }
         }
      }
   }

   public void closeExtendedTableCursors1853( )
   {
      pr_default.close(2);
   }

   public void enableDisable1853( )
   {
   }

   public void gxload_21( long A13ArticuloId )
   {
      /* Using cursor T001829 */
      pr_default.execute(23, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_71_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A76ArticuloNombre = T001829_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T001829_A78ArticuloPrecioVenta[0] ;
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A76ArticuloNombre))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(17), (byte)(2), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(23) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(23);
   }

   public void getKey1853( )
   {
      /* Using cursor T001830 */
      pr_default.execute(24, new Object[] {Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID)});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound53 = (short)(1) ;
      }
      else
      {
         RcdFound53 = (short)(0) ;
      }
      pr_default.close(24);
   }

   public void getByPrimaryKey1853( )
   {
      /* Using cursor T00183 */
      pr_default.execute(1, new Object[] {Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1853( 20) ;
         RcdFound53 = (short)(1) ;
         initializeNonKey1853( ) ;
         A274DevolucionesDetalleID = T00183_A274DevolucionesDetalleID[0] ;
         A303DevolucionesDetalleTallaID = T00183_A303DevolucionesDetalleTallaID[0] ;
         A278DevolucionesDetalleCant = T00183_A278DevolucionesDetalleCant[0] ;
         A13ArticuloId = T00183_A13ArticuloId[0] ;
         Z272DevolucionesID = A272DevolucionesID ;
         Z274DevolucionesDetalleID = A274DevolucionesDetalleID ;
         sMode53 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1853( ) ;
         Gx_mode = sMode53 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound53 = (short)(0) ;
         initializeNonKey1853( ) ;
         sMode53 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal1853( ) ;
         Gx_mode = sMode53 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1853( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency1853( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00182 */
         pr_default.execute(0, new Object[] {Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"DevolucionesDetalle"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z303DevolucionesDetalleTallaID != T00182_A303DevolucionesDetalleTallaID[0] ) || ( Z278DevolucionesDetalleCant != T00182_A278DevolucionesDetalleCant[0] ) || ( Z13ArticuloId != T00182_A13ArticuloId[0] ) )
         {
            if ( Z303DevolucionesDetalleTallaID != T00182_A303DevolucionesDetalleTallaID[0] )
            {
               GXutil.writeLogln("devoluciones:[seudo value changed for attri]"+"DevolucionesDetalleTallaID");
               GXutil.writeLogRaw("Old: ",Z303DevolucionesDetalleTallaID);
               GXutil.writeLogRaw("Current: ",T00182_A303DevolucionesDetalleTallaID[0]);
            }
            if ( Z278DevolucionesDetalleCant != T00182_A278DevolucionesDetalleCant[0] )
            {
               GXutil.writeLogln("devoluciones:[seudo value changed for attri]"+"DevolucionesDetalleCant");
               GXutil.writeLogRaw("Old: ",Z278DevolucionesDetalleCant);
               GXutil.writeLogRaw("Current: ",T00182_A278DevolucionesDetalleCant[0]);
            }
            if ( Z13ArticuloId != T00182_A13ArticuloId[0] )
            {
               GXutil.writeLogln("devoluciones:[seudo value changed for attri]"+"ArticuloId");
               GXutil.writeLogRaw("Old: ",Z13ArticuloId);
               GXutil.writeLogRaw("Current: ",T00182_A13ArticuloId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"DevolucionesDetalle"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1853( )
   {
      if ( ! IsAuthorized("devoluciones_Insert") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1853( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1853( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1853( 0) ;
         checkOptimisticConcurrency1853( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1853( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1853( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001831 */
                  pr_default.execute(25, new Object[] {Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID), Long.valueOf(A303DevolucionesDetalleTallaID), Integer.valueOf(A278DevolucionesDetalleCant), Long.valueOf(A13ArticuloId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("DevolucionesDetalle");
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
            load1853( ) ;
         }
         endLevel1853( ) ;
      }
      closeExtendedTableCursors1853( ) ;
   }

   public void update1853( )
   {
      if ( ! IsAuthorized("devoluciones_Update") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      beforeValidate1853( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1853( ) ;
      }
      if ( ( nIsMod_53 != 0 ) || ( nIsDirty_53 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency1853( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm1853( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate1853( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001832 */
                     pr_default.execute(26, new Object[] {Long.valueOf(A303DevolucionesDetalleTallaID), Integer.valueOf(A278DevolucionesDetalleCant), Long.valueOf(A13ArticuloId), Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("DevolucionesDetalle");
                     if ( (pr_default.getStatus(26) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"DevolucionesDetalle"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate1853( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey1853( ) ;
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
            endLevel1853( ) ;
         }
      }
      closeExtendedTableCursors1853( ) ;
   }

   public void deferredUpdate1853( )
   {
   }

   public void delete1853( )
   {
      if ( ! IsAuthorized("devoluciones_Delete") )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_notauthorized"), 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1853( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1853( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1853( ) ;
         afterConfirm1853( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1853( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001833 */
               pr_default.execute(27, new Object[] {Long.valueOf(A272DevolucionesID), Long.valueOf(A274DevolucionesDetalleID)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("DevolucionesDetalle");
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
      sMode53 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1853( ) ;
      Gx_mode = sMode53 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1853( )
   {
      standaloneModal1853( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T001834 */
         pr_default.execute(28, new Object[] {Long.valueOf(A13ArticuloId)});
         A76ArticuloNombre = T001834_A76ArticuloNombre[0] ;
         A78ArticuloPrecioVenta = T001834_A78ArticuloPrecioVenta[0] ;
         pr_default.close(28);
         A277DevolucionesDetalleTotal = A78ArticuloPrecioVenta.multiply(DecimalUtil.doubleToDec(A278DevolucionesDetalleCant)) ;
         if ( isIns( )  )
         {
            A276DevolucionesTotal = O276DevolucionesTotal.add(A277DevolucionesDetalleTotal) ;
            n276DevolucionesTotal = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
         }
         else
         {
            if ( isUpd( )  )
            {
               A276DevolucionesTotal = O276DevolucionesTotal.add(A277DevolucionesDetalleTotal).subtract(O277DevolucionesDetalleTotal) ;
               n276DevolucionesTotal = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
            }
            else
            {
               if ( isDlt( )  )
               {
                  A276DevolucionesTotal = O276DevolucionesTotal.subtract(O277DevolucionesDetalleTotal) ;
                  n276DevolucionesTotal = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
               }
            }
         }
      }
   }

   public void endLevel1853( )
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

   public void scanStart1853( )
   {
      /* Scan By routine */
      /* Using cursor T001835 */
      pr_default.execute(29, new Object[] {Long.valueOf(A272DevolucionesID)});
      RcdFound53 = (short)(0) ;
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A274DevolucionesDetalleID = T001835_A274DevolucionesDetalleID[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1853( )
   {
      /* Scan next routine */
      pr_default.readNext(29);
      RcdFound53 = (short)(0) ;
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A274DevolucionesDetalleID = T001835_A274DevolucionesDetalleID[0] ;
      }
   }

   public void scanEnd1853( )
   {
      pr_default.close(29);
   }

   public void afterConfirm1853( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1853( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1853( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1853( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1853( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1853( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1853( )
   {
      edtDevolucionesDetalleID_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleID_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtArticuloId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloId_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtArticuloNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloNombre_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtArticuloPrecioVenta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtArticuloPrecioVenta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtArticuloPrecioVenta_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtDevolucionesDetalleCant_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleCant_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleCant_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      edtDevolucionesDetalleTotal_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleTotal_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleTotal_Enabled), 5, 0), !bGXsfl_71_Refreshing);
      dynDevolucionesDetalleTallaID.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynDevolucionesDetalleTallaID.getInternalname(), "Enabled", GXutil.ltrimstr( dynDevolucionesDetalleTallaID.getEnabled(), 5, 0), !bGXsfl_71_Refreshing);
   }

   public void send_integrity_lvl_hashes1853( )
   {
   }

   public void send_integrity_lvl_hashes1852( )
   {
   }

   public void subsflControlProps_7153( )
   {
      edtDevolucionesDetalleID_Internalname = "DEVOLUCIONESDETALLEID_"+sGXsfl_71_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_71_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_71_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_71_idx ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA_"+sGXsfl_71_idx ;
      edtDevolucionesDetalleCant_Internalname = "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_idx ;
      edtDevolucionesDetalleTotal_Internalname = "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_idx ;
      dynDevolucionesDetalleTallaID.setInternalname( "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_idx );
   }

   public void subsflControlProps_fel_7153( )
   {
      edtDevolucionesDetalleID_Internalname = "DEVOLUCIONESDETALLEID_"+sGXsfl_71_fel_idx ;
      edtArticuloId_Internalname = "ARTICULOID_"+sGXsfl_71_fel_idx ;
      imgprompt_13_Internalname = "PROMPT_13_"+sGXsfl_71_fel_idx ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE_"+sGXsfl_71_fel_idx ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA_"+sGXsfl_71_fel_idx ;
      edtDevolucionesDetalleCant_Internalname = "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_fel_idx ;
      edtDevolucionesDetalleTotal_Internalname = "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_fel_idx ;
      dynDevolucionesDetalleTallaID.setInternalname( "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_fel_idx );
   }

   public void addRow1853( )
   {
      nGXsfl_71_idx = (int)(nGXsfl_71_idx+1) ;
      sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7153( ) ;
      sendRow1853( ) ;
   }

   public void sendRow1853( )
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
         if ( ((int)((nGXsfl_71_idx) % (2))) == 0 )
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
      imgprompt_13_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.mujermorena.articuloprompt"+"',["+"{Ctrl:gx.dom.el('"+"ARTICULOID_"+sGXsfl_71_idx+"'), id:'"+"ARTICULOID_"+sGXsfl_71_idx+"'"+",IOType:'inout'}"+"],"+"gx.dom.form()."+"nIsMod_53_"+sGXsfl_71_idx+","+"'', false"+","+"false"+");") ;
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_53_" + sGXsfl_71_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 72,'',false,'" + sGXsfl_71_idx + "',71)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDevolucionesDetalleID_Internalname,GXutil.ltrim( localUtil.ntoc( A274DevolucionesDetalleID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A274DevolucionesDetalleID), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,72);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDevolucionesDetalleID_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtDevolucionesDetalleID_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDentificador","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_53_" + sGXsfl_71_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 73,'',false,'" + sGXsfl_71_idx + "',71)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloId_Internalname,GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloId_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloId_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(11),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"IDN11","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_13_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_13_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      Gridlevel_detalleRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {imgprompt_13_Internalname,sImgUrl,imgprompt_13_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(imgprompt_13_Visible),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloNombre_Internalname,GXutil.rtrim( A76ArticuloNombre),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloNombre_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Nombre","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtArticuloPrecioVenta_Internalname,GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtArticuloPrecioVenta_Enabled!=0) ? localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtArticuloPrecioVenta_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtArticuloPrecioVenta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_53_" + sGXsfl_71_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 76,'',false,'" + sGXsfl_71_idx + "',71)\"" ;
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDevolucionesDetalleCant_Internalname,GXutil.ltrim( localUtil.ntoc( A278DevolucionesDetalleCant, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtDevolucionesDetalleCant_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A278DevolucionesDetalleCant), "ZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A278DevolucionesDetalleCant), "ZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDevolucionesDetalleCant_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtDevolucionesDetalleCant_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Cantidad","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "AttributeRealWidth" ;
      Gridlevel_detalleRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDevolucionesDetalleTotal_Internalname,GXutil.ltrim( localUtil.ntoc( A277DevolucionesDetalleTotal, (byte)(21), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtDevolucionesDetalleTotal_Enabled!=0) ? localUtil.format( A277DevolucionesDetalleTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A277DevolucionesDetalleTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDevolucionesDetalleTotal_Jsonclick,Integer.valueOf(0),"AttributeRealWidth","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtDevolucionesDetalleTotal_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(21),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(71),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Monto","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_53_" + sGXsfl_71_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 78,'',false,'" + sGXsfl_71_idx + "',71)\"" ;
      if ( ( dynDevolucionesDetalleTallaID.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "DEVOLUCIONESDETALLETALLAID_" + sGXsfl_71_idx ;
         dynDevolucionesDetalleTallaID.setName( GXCCtl );
         dynDevolucionesDetalleTallaID.setWebtags( "" );
         dynDevolucionesDetalleTallaID.removeAllItems();
         /* Using cursor T001836 */
         pr_default.execute(30);
         while ( (pr_default.getStatus(30) != 101) )
         {
            dynDevolucionesDetalleTallaID.addItem(GXutil.trim( GXutil.str( T001836_A286TallaID[0], 11, 0)), GXutil.str( T001836_A288TallaNumero[0], 4, 0), (short)(0));
            pr_default.readNext(30);
         }
         pr_default.close(30);
         if ( dynDevolucionesDetalleTallaID.getItemCount() > 0 )
         {
            A303DevolucionesDetalleTallaID = GXutil.lval( dynDevolucionesDetalleTallaID.getValidValue(GXutil.trim( GXutil.str( A303DevolucionesDetalleTallaID, 11, 0)))) ;
         }
      }
      /* ComboBox */
      Gridlevel_detalleRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynDevolucionesDetalleTallaID,dynDevolucionesDetalleTallaID.getInternalname(),GXutil.trim( GXutil.str( A303DevolucionesDetalleTallaID, 11, 0)),Integer.valueOf(1),dynDevolucionesDetalleTallaID.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(dynDevolucionesDetalleTallaID.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","AttributeRealWidth","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynDevolucionesDetalleTallaID.setValue( GXutil.trim( GXutil.str( A303DevolucionesDetalleTallaID, 11, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynDevolucionesDetalleTallaID.getInternalname(), "Values", dynDevolucionesDetalleTallaID.ToJavascriptSource(), !bGXsfl_71_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel_detalleRow);
      send_integrity_lvl_hashes1853( ) ;
      GXCCtl = "Z274DevolucionesDetalleID_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z274DevolucionesDetalleID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z303DevolucionesDetalleTallaID_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z303DevolucionesDetalleTallaID, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z278DevolucionesDetalleCant_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z278DevolucionesDetalleCant, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z13ArticuloId_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z13ArticuloId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O277DevolucionesDetalleTotal_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O277DevolucionesDetalleTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_53_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_53_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_53_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_53, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_71_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV11TrnContext);
      }
      GXCCtl = "vDEVOLUCIONESID_" + sGXsfl_71_idx ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7DevolucionesID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DEVOLUCIONESDETALLEID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULONOMBRE_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "ARTICULOPRECIOVENTA_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleCant_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynDevolucionesDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "PROMPT_13_"+sGXsfl_71_idx+"Link", GXutil.rtrim( imgprompt_13_Link));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_detalleContainer.AddRow(Gridlevel_detalleRow);
   }

   public void readRow1853( )
   {
      nGXsfl_71_idx = (int)(nGXsfl_71_idx+1) ;
      sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7153( ) ;
      edtDevolucionesDetalleID_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLEID_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOID_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULONOMBRE_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtArticuloPrecioVenta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ARTICULOPRECIOVENTA_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtDevolucionesDetalleCant_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLECANT_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtDevolucionesDetalleTotal_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLETOTAL_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      dynDevolucionesDetalleTallaID.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "DEVOLUCIONESDETALLETALLAID_"+sGXsfl_71_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      imgprompt_19_Link = httpContext.cgiGet( "PROMPT_13_"+sGXsfl_71_idx+"Link") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDevolucionesDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDevolucionesDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
      {
         GXCCtl = "DEVOLUCIONESDETALLEID_" + sGXsfl_71_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtDevolucionesDetalleID_Internalname ;
         wbErr = true ;
         A274DevolucionesDetalleID = 0 ;
      }
      else
      {
         A274DevolucionesDetalleID = localUtil.ctol( httpContext.cgiGet( edtDevolucionesDetalleID_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtArticuloId_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
      {
         GXCCtl = "ARTICULOID_" + sGXsfl_71_idx ;
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
      A78ArticuloPrecioVenta = localUtil.ctond( httpContext.cgiGet( edtArticuloPrecioVenta_Internalname)) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDevolucionesDetalleCant_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDevolucionesDetalleCant_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999 ) ) )
      {
         GXCCtl = "DEVOLUCIONESDETALLECANT_" + sGXsfl_71_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtDevolucionesDetalleCant_Internalname ;
         wbErr = true ;
         A278DevolucionesDetalleCant = 0 ;
      }
      else
      {
         A278DevolucionesDetalleCant = (int)(localUtil.ctol( httpContext.cgiGet( edtDevolucionesDetalleCant_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A277DevolucionesDetalleTotal = localUtil.ctond( httpContext.cgiGet( edtDevolucionesDetalleTotal_Internalname)) ;
      dynDevolucionesDetalleTallaID.setName( dynDevolucionesDetalleTallaID.getInternalname() );
      dynDevolucionesDetalleTallaID.setValue( httpContext.cgiGet( dynDevolucionesDetalleTallaID.getInternalname()) );
      A303DevolucionesDetalleTallaID = GXutil.lval( httpContext.cgiGet( dynDevolucionesDetalleTallaID.getInternalname())) ;
      GXCCtl = "Z274DevolucionesDetalleID_" + sGXsfl_71_idx ;
      Z274DevolucionesDetalleID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z303DevolucionesDetalleTallaID_" + sGXsfl_71_idx ;
      Z303DevolucionesDetalleTallaID = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "Z278DevolucionesDetalleCant_" + sGXsfl_71_idx ;
      Z278DevolucionesDetalleCant = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z13ArticuloId_" + sGXsfl_71_idx ;
      Z13ArticuloId = localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
      GXCCtl = "O277DevolucionesDetalleTotal_" + sGXsfl_71_idx ;
      O277DevolucionesDetalleTotal = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_53_" + sGXsfl_71_idx ;
      nRcdDeleted_53 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_53_" + sGXsfl_71_idx ;
      nRcdExists_53 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_53_" + sGXsfl_71_idx ;
      nIsMod_53 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtDevolucionesDetalleID_Enabled = edtDevolucionesDetalleID_Enabled ;
   }

   public void confirmValues180( )
   {
      nGXsfl_71_idx = 0 ;
      sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_7153( ) ;
      while ( nGXsfl_71_idx < nRC_GXsfl_71 )
      {
         nGXsfl_71_idx = (int)(nGXsfl_71_idx+1) ;
         sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7153( ) ;
         httpContext.changePostValue( "Z274DevolucionesDetalleID_"+sGXsfl_71_idx, httpContext.cgiGet( "ZT_"+"Z274DevolucionesDetalleID_"+sGXsfl_71_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z274DevolucionesDetalleID_"+sGXsfl_71_idx) ;
         httpContext.changePostValue( "Z303DevolucionesDetalleTallaID_"+sGXsfl_71_idx, httpContext.cgiGet( "ZT_"+"Z303DevolucionesDetalleTallaID_"+sGXsfl_71_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z303DevolucionesDetalleTallaID_"+sGXsfl_71_idx) ;
         httpContext.changePostValue( "Z278DevolucionesDetalleCant_"+sGXsfl_71_idx, httpContext.cgiGet( "ZT_"+"Z278DevolucionesDetalleCant_"+sGXsfl_71_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z278DevolucionesDetalleCant_"+sGXsfl_71_idx) ;
         httpContext.changePostValue( "Z13ArticuloId_"+sGXsfl_71_idx, httpContext.cgiGet( "ZT_"+"Z13ArticuloId_"+sGXsfl_71_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z13ArticuloId_"+sGXsfl_71_idx) ;
      }
      httpContext.changePostValue( "O277DevolucionesDetalleTotal", httpContext.cgiGet( "T277DevolucionesDetalleTotal")) ;
      httpContext.deletePostValue( "T277DevolucionesDetalleTotal") ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.mujermorena.devoluciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7DevolucionesID,10,0))}, new String[] {"Gx_mode","DevolucionesID"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Devoluciones");
      forbiddenHiddens.add("DevolucionesID", localUtil.format( DecimalUtil.doubleToDec(A272DevolucionesID), "ZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("devoluciones:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z272DevolucionesID", GXutil.ltrim( localUtil.ntoc( Z272DevolucionesID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z275DevolucionesFecha", localUtil.dtoc( Z275DevolucionesFecha, 0, "/"));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z19VentasId", GXutil.ltrim( localUtil.ntoc( Z19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Z273MotivoDevolucionID", GXutil.ltrim( localUtil.ntoc( Z273MotivoDevolucionID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "O276DevolucionesTotal", GXutil.ltrim( localUtil.ntoc( O276DevolucionesTotal, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_71", GXutil.ltrim( localUtil.ntoc( nGXsfl_71_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N19VentasId", GXutil.ltrim( localUtil.ntoc( A19VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "N273MotivoDevolucionID", GXutil.ltrim( localUtil.ntoc( A273MotivoDevolucionID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV11TrnContext);
      }
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV11TrnContext));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vDEVOLUCIONESID", GXutil.ltrim( localUtil.ntoc( AV7DevolucionesID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDEVOLUCIONESID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7DevolucionesID), "ZZZZZZZZZ9")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_VENTASID", GXutil.ltrim( localUtil.ntoc( AV13Insert_VentasId, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      com.mujermorena.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MOTIVODEVOLUCIONID", GXutil.ltrim( localUtil.ntoc( AV14Insert_MotivoDevolucionID, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      return formatLink("com.mujermorena.devoluciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7DevolucionesID,10,0))}, new String[] {"Gx_mode","DevolucionesID"})  ;
   }

   public String getPgmname( )
   {
      return "Devoluciones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Devoluciones", "") ;
   }

   public void initializeNonKey1852( )
   {
      A19VentasId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A19VentasId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19VentasId), 11, 0));
      A273MotivoDevolucionID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A273MotivoDevolucionID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A273MotivoDevolucionID), 10, 0));
      A275DevolucionesFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A275DevolucionesFecha", localUtil.format(A275DevolucionesFecha, "99/99/99"));
      A91VentasFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
      A4ClienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4ClienteId), 11, 0));
      A9TipoPagoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9TipoPagoId), 11, 0));
      A280MotivoDevolucionDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
      A279DevolucionesObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A279DevolucionesObservacion", A279DevolucionesObservacion);
      A276DevolucionesTotal = DecimalUtil.ZERO ;
      n276DevolucionesTotal = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      O276DevolucionesTotal = A276DevolucionesTotal ;
      n276DevolucionesTotal = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrimstr( A276DevolucionesTotal, 17, 2));
      Z275DevolucionesFecha = GXutil.nullDate() ;
      Z19VentasId = 0 ;
      Z273MotivoDevolucionID = 0 ;
   }

   public void initAll1852( )
   {
      A272DevolucionesID = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
      initializeNonKey1852( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey1853( )
   {
      A277DevolucionesDetalleTotal = DecimalUtil.ZERO ;
      A13ArticuloId = 0 ;
      A76ArticuloNombre = "" ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A303DevolucionesDetalleTallaID = 0 ;
      A278DevolucionesDetalleCant = 0 ;
      O277DevolucionesDetalleTotal = A277DevolucionesDetalleTotal ;
      Z303DevolucionesDetalleTallaID = 0 ;
      Z278DevolucionesDetalleCant = 0 ;
      Z13ArticuloId = 0 ;
   }

   public void initAll1853( )
   {
      A274DevolucionesDetalleID = 0 ;
      initializeNonKey1853( ) ;
   }

   public void standaloneModalInsert1853( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412111111588", true, true);
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
      httpContext.AddJavascriptSource("devoluciones.js", "?202412111111588", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties53( )
   {
      edtDevolucionesDetalleID_Enabled = defedtDevolucionesDetalleID_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtDevolucionesDetalleID_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDevolucionesDetalleID_Enabled), 5, 0), !bGXsfl_71_Refreshing);
   }

   public void startgridcontrol71( )
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
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A274DevolucionesDetalleID, (byte)(10), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleID_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A13ArticuloId, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.rtrim( A76ArticuloNombre));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtArticuloPrecioVenta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A278DevolucionesDetalleCant, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleCant_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A277DevolucionesDetalleTotal, (byte)(21), (byte)(2), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtDevolucionesDetalleTotal_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_detalleContainer.AddColumnProperties(Gridlevel_detalleColumn);
      Gridlevel_detalleColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_detalleColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A303DevolucionesDetalleTallaID, (byte)(11), (byte)(0), ".", "")));
      Gridlevel_detalleColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynDevolucionesDetalleTallaID.getEnabled(), (byte)(5), (byte)(0), ".", "")));
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
      edtDevolucionesID_Internalname = "DEVOLUCIONESID" ;
      edtDevolucionesFecha_Internalname = "DEVOLUCIONESFECHA" ;
      edtVentasId_Internalname = "VENTASID" ;
      edtVentasFecha_Internalname = "VENTASFECHA" ;
      edtClienteId_Internalname = "CLIENTEID" ;
      edtTipoPagoId_Internalname = "TIPOPAGOID" ;
      edtMotivoDevolucionID_Internalname = "MOTIVODEVOLUCIONID" ;
      edtMotivoDevolucionDescripcion_Internalname = "MOTIVODEVOLUCIONDESCRIPCION" ;
      edtDevolucionesObservacion_Internalname = "DEVOLUCIONESOBSERVACION" ;
      edtDevolucionesTotal_Internalname = "DEVOLUCIONESTOTAL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtDevolucionesDetalleID_Internalname = "DEVOLUCIONESDETALLEID" ;
      edtArticuloId_Internalname = "ARTICULOID" ;
      edtArticuloNombre_Internalname = "ARTICULONOMBRE" ;
      edtArticuloPrecioVenta_Internalname = "ARTICULOPRECIOVENTA" ;
      edtDevolucionesDetalleCant_Internalname = "DEVOLUCIONESDETALLECANT" ;
      edtDevolucionesDetalleTotal_Internalname = "DEVOLUCIONESDETALLETOTAL" ;
      dynDevolucionesDetalleTallaID.setInternalname( "DEVOLUCIONESDETALLETALLAID" );
      divTableleaflevel_detalle_Internalname = "TABLELEAFLEVEL_DETALLE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_19_Internalname = "PROMPT_19" ;
      imgprompt_273_Internalname = "PROMPT_273" ;
      imgprompt_13_Internalname = "PROMPT_13" ;
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
      Form.setCaption( httpContext.getMessage( "Devoluciones", "") );
      dynDevolucionesDetalleTallaID.setJsonclick( "" );
      edtDevolucionesDetalleTotal_Jsonclick = "" ;
      edtDevolucionesDetalleCant_Jsonclick = "" ;
      edtArticuloPrecioVenta_Jsonclick = "" ;
      edtArticuloNombre_Jsonclick = "" ;
      imgprompt_13_Visible = 1 ;
      imgprompt_13_Link = "" ;
      imgprompt_19_Visible = 1 ;
      edtArticuloId_Jsonclick = "" ;
      edtDevolucionesDetalleID_Jsonclick = "" ;
      subGridlevel_detalle_Class = "WorkWith" ;
      subGridlevel_detalle_Backcolorstyle = (byte)(0) ;
      dynDevolucionesDetalleTallaID.setEnabled( 1 );
      edtDevolucionesDetalleTotal_Enabled = 0 ;
      edtDevolucionesDetalleCant_Enabled = 1 ;
      edtArticuloPrecioVenta_Enabled = 0 ;
      edtArticuloNombre_Enabled = 0 ;
      edtArticuloId_Enabled = 1 ;
      edtDevolucionesDetalleID_Enabled = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtDevolucionesTotal_Jsonclick = "" ;
      edtDevolucionesTotal_Enabled = 0 ;
      edtDevolucionesObservacion_Enabled = 1 ;
      edtMotivoDevolucionDescripcion_Jsonclick = "" ;
      edtMotivoDevolucionDescripcion_Enabled = 0 ;
      imgprompt_273_Visible = 1 ;
      imgprompt_273_Link = "" ;
      edtMotivoDevolucionID_Jsonclick = "" ;
      edtMotivoDevolucionID_Enabled = 1 ;
      edtTipoPagoId_Jsonclick = "" ;
      edtTipoPagoId_Enabled = 0 ;
      edtClienteId_Jsonclick = "" ;
      edtClienteId_Enabled = 0 ;
      edtVentasFecha_Jsonclick = "" ;
      edtVentasFecha_Enabled = 0 ;
      imgprompt_19_Visible = 1 ;
      imgprompt_19_Link = "" ;
      edtVentasId_Jsonclick = "" ;
      edtVentasId_Enabled = 1 ;
      edtDevolucionesFecha_Jsonclick = "" ;
      edtDevolucionesFecha_Enabled = 1 ;
      edtDevolucionesID_Jsonclick = "" ;
      edtDevolucionesID_Enabled = 0 ;
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
      divLayoutmaintable_Class = "Table" ;
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

   public void gx5asadevolucionesid1852( long AV7DevolucionesID ,
                                         String AV16Pgmname )
   {
      if ( ! (0==AV7DevolucionesID) )
      {
         A272DevolucionesID = AV7DevolucionesID ;
         httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
         {
            GXt_int2 = A272DevolucionesID ;
            GXv_int3[0] = GXt_int2 ;
            new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int3) ;
            devoluciones_impl.this.GXt_int2 = GXv_int3[0] ;
            A272DevolucionesID = GXt_int2 ;
            httpContext.ajax_rsp_assign_attri("", false, "A272DevolucionesID", GXutil.ltrimstr( DecimalUtil.doubleToDec(A272DevolucionesID), 10, 0));
         }
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A272DevolucionesID, (byte)(10), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx15asadevolucionesdetalleid1853( String AV16Pgmname )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_int2 = A274DevolucionesDetalleID ;
         GXv_int3[0] = GXt_int2 ;
         new com.mujermorena.numeradorids(remoteHandle, context).execute( GXutil.trim( AV16Pgmname), GXv_int3) ;
         devoluciones_impl.this.GXt_int2 = GXv_int3[0] ;
         A274DevolucionesDetalleID = GXt_int2 ;
      }
      com.mujermorena.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A274DevolucionesDetalleID, (byte)(10), (byte)(0), ".", "")))+"\"") ;
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
      subsflControlProps_7153( ) ;
      while ( nGXsfl_71_idx <= nRC_GXsfl_71 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal1853( ) ;
         standaloneModal1853( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow1853( ) ;
         nGXsfl_71_idx = (int)(nGXsfl_71_idx+1) ;
         sGXsfl_71_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_71_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_7153( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_detalleContainer)) ;
      /* End function gxnrGridlevel_detalle_newrow */
   }

   public void init_web_controls( )
   {
      GXCCtl = "DEVOLUCIONESDETALLETALLAID_" + sGXsfl_71_idx ;
      dynDevolucionesDetalleTallaID.setName( GXCCtl );
      dynDevolucionesDetalleTallaID.setWebtags( "" );
      dynDevolucionesDetalleTallaID.removeAllItems();
      /* Using cursor T001837 */
      pr_default.execute(31);
      while ( (pr_default.getStatus(31) != 101) )
      {
         dynDevolucionesDetalleTallaID.addItem(GXutil.trim( GXutil.str( T001837_A286TallaID[0], 11, 0)), GXutil.str( T001837_A288TallaNumero[0], 4, 0), (short)(0));
         pr_default.readNext(31);
      }
      pr_default.close(31);
      if ( dynDevolucionesDetalleTallaID.getItemCount() > 0 )
      {
         A303DevolucionesDetalleTallaID = GXutil.lval( dynDevolucionesDetalleTallaID.getValidValue(GXutil.trim( GXutil.str( A303DevolucionesDetalleTallaID, 11, 0)))) ;
      }
      /* End function init_web_controls */
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

   public void valid_Devolucionesid( )
   {
      n276DevolucionesTotal = false ;
      /* Using cursor T001824 */
      pr_default.execute(18, new Object[] {Long.valueOf(A272DevolucionesID)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         A276DevolucionesTotal = T001824_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = T001824_n276DevolucionesTotal[0] ;
      }
      else
      {
         A276DevolucionesTotal = DecimalUtil.doubleToDec(0) ;
         n276DevolucionesTotal = false ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A276DevolucionesTotal", GXutil.ltrim( localUtil.ntoc( A276DevolucionesTotal, (byte)(17), (byte)(2), ".", "")));
   }

   public void valid_Ventasid( )
   {
      /* Using cursor T001825 */
      pr_default.execute(19, new Object[] {Long.valueOf(A19VentasId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Ventas", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "VENTASID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtVentasId_Internalname ;
      }
      A91VentasFecha = T001825_A91VentasFecha[0] ;
      A4ClienteId = T001825_A4ClienteId[0] ;
      A9TipoPagoId = T001825_A9TipoPagoId[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A91VentasFecha", localUtil.format(A91VentasFecha, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A4ClienteId", GXutil.ltrim( localUtil.ntoc( A4ClienteId, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A9TipoPagoId", GXutil.ltrim( localUtil.ntoc( A9TipoPagoId, (byte)(11), (byte)(0), ".", "")));
   }

   public void valid_Motivodevolucionid( )
   {
      /* Using cursor T001826 */
      pr_default.execute(20, new Object[] {Long.valueOf(A273MotivoDevolucionID)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Devolucion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MOTIVODEVOLUCIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMotivoDevolucionID_Internalname ;
      }
      A280MotivoDevolucionDescripcion = T001826_A280MotivoDevolucionDescripcion[0] ;
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A280MotivoDevolucionDescripcion", A280MotivoDevolucionDescripcion);
   }

   public void valid_Articuloid( )
   {
      /* Using cursor T001834 */
      pr_default.execute(28, new Object[] {Long.valueOf(A13ArticuloId)});
      if ( (pr_default.getStatus(28) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Articulo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ARTICULOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtArticuloId_Internalname ;
      }
      A76ArticuloNombre = T001834_A76ArticuloNombre[0] ;
      A78ArticuloPrecioVenta = T001834_A78ArticuloPrecioVenta[0] ;
      pr_default.close(28);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A76ArticuloNombre", GXutil.rtrim( A76ArticuloNombre));
      httpContext.ajax_rsp_assign_attri("", false, "A78ArticuloPrecioVenta", GXutil.ltrim( localUtil.ntoc( A78ArticuloPrecioVenta, (byte)(17), (byte)(2), ".", "")));
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7DevolucionesID',fld:'vDEVOLUCIONESID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7DevolucionesID',fld:'vDEVOLUCIONESID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A272DevolucionesID',fld:'DEVOLUCIONESID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12182',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A272DevolucionesID',fld:'DEVOLUCIONESID',pic:'ZZZZZZZZZ9'},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_DEVOLUCIONESID","{handler:'valid_Devolucionesid',iparms:[{av:'A272DevolucionesID',fld:'DEVOLUCIONESID',pic:'ZZZZZZZZZ9'},{av:'A276DevolucionesTotal',fld:'DEVOLUCIONESTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("VALID_DEVOLUCIONESID",",oparms:[{av:'A276DevolucionesTotal',fld:'DEVOLUCIONESTOTAL',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("VALID_DEVOLUCIONESFECHA","{handler:'valid_Devolucionesfecha',iparms:[]");
      setEventMetadata("VALID_DEVOLUCIONESFECHA",",oparms:[]}");
      setEventMetadata("VALID_VENTASID","{handler:'valid_Ventasid',iparms:[{av:'A19VentasId',fld:'VENTASID',pic:'ZZZZZZZZZZ9'},{av:'A91VentasFecha',fld:'VENTASFECHA',pic:''},{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'A9TipoPagoId',fld:'TIPOPAGOID',pic:'ZZZZZZZZZZ9'}]");
      setEventMetadata("VALID_VENTASID",",oparms:[{av:'A91VentasFecha',fld:'VENTASFECHA',pic:''},{av:'A4ClienteId',fld:'CLIENTEID',pic:'ZZZZZZZZZZ9'},{av:'A9TipoPagoId',fld:'TIPOPAGOID',pic:'ZZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_MOTIVODEVOLUCIONID","{handler:'valid_Motivodevolucionid',iparms:[{av:'A273MotivoDevolucionID',fld:'MOTIVODEVOLUCIONID',pic:'ZZZZZZZZZ9'},{av:'A280MotivoDevolucionDescripcion',fld:'MOTIVODEVOLUCIONDESCRIPCION',pic:''}]");
      setEventMetadata("VALID_MOTIVODEVOLUCIONID",",oparms:[{av:'A280MotivoDevolucionDescripcion',fld:'MOTIVODEVOLUCIONDESCRIPCION',pic:''}]}");
      setEventMetadata("VALID_DEVOLUCIONESDETALLEID","{handler:'valid_Devolucionesdetalleid',iparms:[]");
      setEventMetadata("VALID_DEVOLUCIONESDETALLEID",",oparms:[]}");
      setEventMetadata("VALID_ARTICULOID","{handler:'valid_Articuloid',iparms:[{av:'A13ArticuloId',fld:'ARTICULOID',pic:'ZZZZZZZZZZ9'},{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A78ArticuloPrecioVenta',fld:'ARTICULOPRECIOVENTA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]");
      setEventMetadata("VALID_ARTICULOID",",oparms:[{av:'A76ArticuloNombre',fld:'ARTICULONOMBRE',pic:''},{av:'A78ArticuloPrecioVenta',fld:'ARTICULOPRECIOVENTA',pic:'ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99'}]}");
      setEventMetadata("VALID_ARTICULOPRECIOVENTA","{handler:'valid_Articuloprecioventa',iparms:[]");
      setEventMetadata("VALID_ARTICULOPRECIOVENTA",",oparms:[]}");
      setEventMetadata("VALID_DEVOLUCIONESDETALLECANT","{handler:'valid_Devolucionesdetallecant',iparms:[]");
      setEventMetadata("VALID_DEVOLUCIONESDETALLECANT",",oparms:[]}");
      setEventMetadata("VALID_DEVOLUCIONESDETALLETOTAL","{handler:'valid_Devolucionesdetalletotal',iparms:[]");
      setEventMetadata("VALID_DEVOLUCIONESDETALLETOTAL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Devolucionesdetalletallaid',iparms:[]");
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
      return "devoluciones_Execute";
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
      pr_default.close(19);
      pr_default.close(20);
      pr_default.close(18);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z275DevolucionesFecha = GXutil.nullDate() ;
      O276DevolucionesTotal = DecimalUtil.ZERO ;
      O277DevolucionesDetalleTotal = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV16Pgmname = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A275DevolucionesFecha = GXutil.nullDate() ;
      imgprompt_19_gximage = "" ;
      sImgUrl = "" ;
      A91VentasFecha = GXutil.nullDate() ;
      imgprompt_273_gximage = "" ;
      A280MotivoDevolucionDescripcion = "" ;
      A279DevolucionesObservacion = "" ;
      A276DevolucionesTotal = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gridlevel_detalleContainer = new com.genexus.webpanels.GXWebGrid(context);
      B276DevolucionesTotal = DecimalUtil.ZERO ;
      sMode53 = "" ;
      sStyleString = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode52 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      s276DevolucionesTotal = DecimalUtil.ZERO ;
      GXCCtl = "" ;
      A76ArticuloNombre = "" ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A277DevolucionesDetalleTotal = DecimalUtil.ZERO ;
      T277DevolucionesDetalleTotal = DecimalUtil.ZERO ;
      AV8WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11TrnContext = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z279DevolucionesObservacion = "" ;
      Z276DevolucionesTotal = DecimalUtil.ZERO ;
      Z91VentasFecha = GXutil.nullDate() ;
      Z280MotivoDevolucionDescripcion = "" ;
      T001810_A276DevolucionesTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001810_n276DevolucionesTotal = new boolean[] {false} ;
      T00188_A280MotivoDevolucionDescripcion = new String[] {""} ;
      T00187_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00187_A4ClienteId = new long[1] ;
      T00187_A9TipoPagoId = new long[1] ;
      T001812_A272DevolucionesID = new long[1] ;
      T001812_A275DevolucionesFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T001812_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T001812_A280MotivoDevolucionDescripcion = new String[] {""} ;
      T001812_A279DevolucionesObservacion = new String[] {""} ;
      T001812_A19VentasId = new long[1] ;
      T001812_A273MotivoDevolucionID = new long[1] ;
      T001812_A4ClienteId = new long[1] ;
      T001812_A9TipoPagoId = new long[1] ;
      T001812_A276DevolucionesTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001812_n276DevolucionesTotal = new boolean[] {false} ;
      T001814_A276DevolucionesTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001814_n276DevolucionesTotal = new boolean[] {false} ;
      T001815_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T001815_A4ClienteId = new long[1] ;
      T001815_A9TipoPagoId = new long[1] ;
      T001816_A280MotivoDevolucionDescripcion = new String[] {""} ;
      T001817_A272DevolucionesID = new long[1] ;
      T00186_A272DevolucionesID = new long[1] ;
      T00186_A275DevolucionesFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00186_A279DevolucionesObservacion = new String[] {""} ;
      T00186_A19VentasId = new long[1] ;
      T00186_A273MotivoDevolucionID = new long[1] ;
      T001818_A272DevolucionesID = new long[1] ;
      T001819_A272DevolucionesID = new long[1] ;
      T00185_A272DevolucionesID = new long[1] ;
      T00185_A275DevolucionesFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00185_A279DevolucionesObservacion = new String[] {""} ;
      T00185_A19VentasId = new long[1] ;
      T00185_A273MotivoDevolucionID = new long[1] ;
      T001824_A276DevolucionesTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001824_n276DevolucionesTotal = new boolean[] {false} ;
      T001825_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T001825_A4ClienteId = new long[1] ;
      T001825_A9TipoPagoId = new long[1] ;
      T001826_A280MotivoDevolucionDescripcion = new String[] {""} ;
      T001827_A272DevolucionesID = new long[1] ;
      Z76ArticuloNombre = "" ;
      Z78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      T001828_A272DevolucionesID = new long[1] ;
      T001828_A274DevolucionesDetalleID = new long[1] ;
      T001828_A76ArticuloNombre = new String[] {""} ;
      T001828_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001828_A303DevolucionesDetalleTallaID = new long[1] ;
      T001828_A278DevolucionesDetalleCant = new int[1] ;
      T001828_A13ArticuloId = new long[1] ;
      T00184_A76ArticuloNombre = new String[] {""} ;
      T00184_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001829_A76ArticuloNombre = new String[] {""} ;
      T001829_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001830_A272DevolucionesID = new long[1] ;
      T001830_A274DevolucionesDetalleID = new long[1] ;
      T00183_A272DevolucionesID = new long[1] ;
      T00183_A274DevolucionesDetalleID = new long[1] ;
      T00183_A303DevolucionesDetalleTallaID = new long[1] ;
      T00183_A278DevolucionesDetalleCant = new int[1] ;
      T00183_A13ArticuloId = new long[1] ;
      T00182_A272DevolucionesID = new long[1] ;
      T00182_A274DevolucionesDetalleID = new long[1] ;
      T00182_A303DevolucionesDetalleTallaID = new long[1] ;
      T00182_A278DevolucionesDetalleCant = new int[1] ;
      T00182_A13ArticuloId = new long[1] ;
      T001834_A76ArticuloNombre = new String[] {""} ;
      T001834_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T001835_A272DevolucionesID = new long[1] ;
      T001835_A274DevolucionesDetalleID = new long[1] ;
      Gridlevel_detalleRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_detalle_Linesclass = "" ;
      ROClassString = "" ;
      imgprompt_13_gximage = "" ;
      T001836_A286TallaID = new long[1] ;
      T001836_A288TallaNumero = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_detalleColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int3 = new long[1] ;
      T001837_A286TallaID = new long[1] ;
      T001837_A288TallaNumero = new short[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.devoluciones__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.devoluciones__default(),
         new Object[] {
             new Object[] {
            T00182_A272DevolucionesID, T00182_A274DevolucionesDetalleID, T00182_A303DevolucionesDetalleTallaID, T00182_A278DevolucionesDetalleCant, T00182_A13ArticuloId
            }
            , new Object[] {
            T00183_A272DevolucionesID, T00183_A274DevolucionesDetalleID, T00183_A303DevolucionesDetalleTallaID, T00183_A278DevolucionesDetalleCant, T00183_A13ArticuloId
            }
            , new Object[] {
            T00184_A76ArticuloNombre, T00184_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T00185_A272DevolucionesID, T00185_A275DevolucionesFecha, T00185_A279DevolucionesObservacion, T00185_A19VentasId, T00185_A273MotivoDevolucionID
            }
            , new Object[] {
            T00186_A272DevolucionesID, T00186_A275DevolucionesFecha, T00186_A279DevolucionesObservacion, T00186_A19VentasId, T00186_A273MotivoDevolucionID
            }
            , new Object[] {
            T00187_A91VentasFecha, T00187_A4ClienteId, T00187_A9TipoPagoId
            }
            , new Object[] {
            T00188_A280MotivoDevolucionDescripcion
            }
            , new Object[] {
            T001810_A276DevolucionesTotal, T001810_n276DevolucionesTotal
            }
            , new Object[] {
            T001812_A272DevolucionesID, T001812_A275DevolucionesFecha, T001812_A91VentasFecha, T001812_A280MotivoDevolucionDescripcion, T001812_A279DevolucionesObservacion, T001812_A19VentasId, T001812_A273MotivoDevolucionID, T001812_A4ClienteId, T001812_A9TipoPagoId, T001812_A276DevolucionesTotal,
            T001812_n276DevolucionesTotal
            }
            , new Object[] {
            T001814_A276DevolucionesTotal, T001814_n276DevolucionesTotal
            }
            , new Object[] {
            T001815_A91VentasFecha, T001815_A4ClienteId, T001815_A9TipoPagoId
            }
            , new Object[] {
            T001816_A280MotivoDevolucionDescripcion
            }
            , new Object[] {
            T001817_A272DevolucionesID
            }
            , new Object[] {
            T001818_A272DevolucionesID
            }
            , new Object[] {
            T001819_A272DevolucionesID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001824_A276DevolucionesTotal, T001824_n276DevolucionesTotal
            }
            , new Object[] {
            T001825_A91VentasFecha, T001825_A4ClienteId, T001825_A9TipoPagoId
            }
            , new Object[] {
            T001826_A280MotivoDevolucionDescripcion
            }
            , new Object[] {
            T001827_A272DevolucionesID
            }
            , new Object[] {
            T001828_A272DevolucionesID, T001828_A274DevolucionesDetalleID, T001828_A76ArticuloNombre, T001828_A78ArticuloPrecioVenta, T001828_A303DevolucionesDetalleTallaID, T001828_A278DevolucionesDetalleCant, T001828_A13ArticuloId
            }
            , new Object[] {
            T001829_A76ArticuloNombre, T001829_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T001830_A272DevolucionesID, T001830_A274DevolucionesDetalleID
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001834_A76ArticuloNombre, T001834_A78ArticuloPrecioVenta
            }
            , new Object[] {
            T001835_A272DevolucionesID, T001835_A274DevolucionesDetalleID
            }
            , new Object[] {
            T001836_A286TallaID, T001836_A288TallaNumero
            }
            , new Object[] {
            T001837_A286TallaID, T001837_A288TallaNumero
            }
         }
      );
      AV16Pgmname = "Devoluciones" ;
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
   private short nIsMod_53 ;
   private short nRcdDeleted_53 ;
   private short nRcdExists_53 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount53 ;
   private short RcdFound53 ;
   private short nBlankRcdUsr53 ;
   private short RcdFound52 ;
   private short nIsDirty_52 ;
   private short nIsDirty_53 ;
   private int nRC_GXsfl_71 ;
   private int nGXsfl_71_idx=1 ;
   private int Z278DevolucionesDetalleCant ;
   private int trnEnded ;
   private int edtDevolucionesID_Enabled ;
   private int edtDevolucionesFecha_Enabled ;
   private int edtVentasId_Enabled ;
   private int imgprompt_19_Visible ;
   private int edtVentasFecha_Enabled ;
   private int edtClienteId_Enabled ;
   private int edtTipoPagoId_Enabled ;
   private int edtMotivoDevolucionID_Enabled ;
   private int imgprompt_273_Visible ;
   private int edtMotivoDevolucionDescripcion_Enabled ;
   private int edtDevolucionesObservacion_Enabled ;
   private int edtDevolucionesTotal_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtDevolucionesDetalleID_Enabled ;
   private int edtArticuloId_Enabled ;
   private int edtArticuloNombre_Enabled ;
   private int edtArticuloPrecioVenta_Enabled ;
   private int edtDevolucionesDetalleCant_Enabled ;
   private int edtDevolucionesDetalleTotal_Enabled ;
   private int fRowAdded ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int A278DevolucionesDetalleCant ;
   private int AV17GXV1 ;
   private int GX_JID ;
   private int subGridlevel_detalle_Backcolor ;
   private int subGridlevel_detalle_Allbackcolor ;
   private int imgprompt_13_Visible ;
   private int defedtDevolucionesDetalleID_Enabled ;
   private int idxLst ;
   private int subGridlevel_detalle_Selectedindex ;
   private int subGridlevel_detalle_Selectioncolor ;
   private int subGridlevel_detalle_Hoveringcolor ;
   private long wcpOAV7DevolucionesID ;
   private long Z272DevolucionesID ;
   private long Z19VentasId ;
   private long Z273MotivoDevolucionID ;
   private long N19VentasId ;
   private long N273MotivoDevolucionID ;
   private long Z274DevolucionesDetalleID ;
   private long Z303DevolucionesDetalleTallaID ;
   private long Z13ArticuloId ;
   private long AV7DevolucionesID ;
   private long A272DevolucionesID ;
   private long A19VentasId ;
   private long A273MotivoDevolucionID ;
   private long A13ArticuloId ;
   private long A4ClienteId ;
   private long A9TipoPagoId ;
   private long AV13Insert_VentasId ;
   private long AV14Insert_MotivoDevolucionID ;
   private long GRIDLEVEL_DETALLE_nFirstRecordOnPage ;
   private long A274DevolucionesDetalleID ;
   private long A303DevolucionesDetalleTallaID ;
   private long Z4ClienteId ;
   private long Z9TipoPagoId ;
   private long GXt_int2 ;
   private long GXv_int3[] ;
   private java.math.BigDecimal O276DevolucionesTotal ;
   private java.math.BigDecimal O277DevolucionesDetalleTotal ;
   private java.math.BigDecimal A276DevolucionesTotal ;
   private java.math.BigDecimal B276DevolucionesTotal ;
   private java.math.BigDecimal s276DevolucionesTotal ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A277DevolucionesDetalleTotal ;
   private java.math.BigDecimal T277DevolucionesDetalleTotal ;
   private java.math.BigDecimal Z276DevolucionesTotal ;
   private java.math.BigDecimal Z78ArticuloPrecioVenta ;
   private String sPrefix ;
   private String sGXsfl_71_idx="0001" ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV16Pgmname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtDevolucionesFecha_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
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
   private String edtDevolucionesID_Internalname ;
   private String edtDevolucionesID_Jsonclick ;
   private String TempTags ;
   private String edtDevolucionesFecha_Jsonclick ;
   private String edtVentasId_Internalname ;
   private String edtVentasId_Jsonclick ;
   private String imgprompt_19_gximage ;
   private String sImgUrl ;
   private String imgprompt_19_Internalname ;
   private String imgprompt_19_Link ;
   private String edtVentasFecha_Internalname ;
   private String edtVentasFecha_Jsonclick ;
   private String edtClienteId_Internalname ;
   private String edtClienteId_Jsonclick ;
   private String edtTipoPagoId_Internalname ;
   private String edtTipoPagoId_Jsonclick ;
   private String edtMotivoDevolucionID_Internalname ;
   private String edtMotivoDevolucionID_Jsonclick ;
   private String imgprompt_273_gximage ;
   private String imgprompt_273_Internalname ;
   private String imgprompt_273_Link ;
   private String edtMotivoDevolucionDescripcion_Internalname ;
   private String edtMotivoDevolucionDescripcion_Jsonclick ;
   private String edtDevolucionesObservacion_Internalname ;
   private String edtDevolucionesTotal_Internalname ;
   private String edtDevolucionesTotal_Jsonclick ;
   private String divTableleaflevel_detalle_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String sMode53 ;
   private String edtDevolucionesDetalleID_Internalname ;
   private String edtArticuloId_Internalname ;
   private String edtArticuloNombre_Internalname ;
   private String edtArticuloPrecioVenta_Internalname ;
   private String edtDevolucionesDetalleCant_Internalname ;
   private String edtDevolucionesDetalleTotal_Internalname ;
   private String sStyleString ;
   private String subGridlevel_detalle_Internalname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode52 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A76ArticuloNombre ;
   private String Z76ArticuloNombre ;
   private String imgprompt_13_Internalname ;
   private String sGXsfl_71_fel_idx="0001" ;
   private String subGridlevel_detalle_Class ;
   private String subGridlevel_detalle_Linesclass ;
   private String imgprompt_13_Link ;
   private String ROClassString ;
   private String edtDevolucionesDetalleID_Jsonclick ;
   private String edtArticuloId_Jsonclick ;
   private String imgprompt_13_gximage ;
   private String edtArticuloNombre_Jsonclick ;
   private String edtArticuloPrecioVenta_Jsonclick ;
   private String edtDevolucionesDetalleCant_Jsonclick ;
   private String edtDevolucionesDetalleTotal_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_detalle_Header ;
   private java.util.Date Z275DevolucionesFecha ;
   private java.util.Date A275DevolucionesFecha ;
   private java.util.Date A91VentasFecha ;
   private java.util.Date Z91VentasFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n276DevolucionesTotal ;
   private boolean bGXsfl_71_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private String A279DevolucionesObservacion ;
   private String Z279DevolucionesObservacion ;
   private String A280MotivoDevolucionDescripcion ;
   private String Z280MotivoDevolucionDescripcion ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_detalleContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_detalleRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_detalleColumn ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynDevolucionesDetalleTallaID ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] T001810_A276DevolucionesTotal ;
   private boolean[] T001810_n276DevolucionesTotal ;
   private String[] T00188_A280MotivoDevolucionDescripcion ;
   private java.util.Date[] T00187_A91VentasFecha ;
   private long[] T00187_A4ClienteId ;
   private long[] T00187_A9TipoPagoId ;
   private long[] T001812_A272DevolucionesID ;
   private java.util.Date[] T001812_A275DevolucionesFecha ;
   private java.util.Date[] T001812_A91VentasFecha ;
   private String[] T001812_A280MotivoDevolucionDescripcion ;
   private String[] T001812_A279DevolucionesObservacion ;
   private long[] T001812_A19VentasId ;
   private long[] T001812_A273MotivoDevolucionID ;
   private long[] T001812_A4ClienteId ;
   private long[] T001812_A9TipoPagoId ;
   private java.math.BigDecimal[] T001812_A276DevolucionesTotal ;
   private boolean[] T001812_n276DevolucionesTotal ;
   private java.math.BigDecimal[] T001814_A276DevolucionesTotal ;
   private boolean[] T001814_n276DevolucionesTotal ;
   private java.util.Date[] T001815_A91VentasFecha ;
   private long[] T001815_A4ClienteId ;
   private long[] T001815_A9TipoPagoId ;
   private String[] T001816_A280MotivoDevolucionDescripcion ;
   private long[] T001817_A272DevolucionesID ;
   private long[] T00186_A272DevolucionesID ;
   private java.util.Date[] T00186_A275DevolucionesFecha ;
   private String[] T00186_A279DevolucionesObservacion ;
   private long[] T00186_A19VentasId ;
   private long[] T00186_A273MotivoDevolucionID ;
   private long[] T001818_A272DevolucionesID ;
   private long[] T001819_A272DevolucionesID ;
   private long[] T00185_A272DevolucionesID ;
   private java.util.Date[] T00185_A275DevolucionesFecha ;
   private String[] T00185_A279DevolucionesObservacion ;
   private long[] T00185_A19VentasId ;
   private long[] T00185_A273MotivoDevolucionID ;
   private java.math.BigDecimal[] T001824_A276DevolucionesTotal ;
   private boolean[] T001824_n276DevolucionesTotal ;
   private java.util.Date[] T001825_A91VentasFecha ;
   private long[] T001825_A4ClienteId ;
   private long[] T001825_A9TipoPagoId ;
   private String[] T001826_A280MotivoDevolucionDescripcion ;
   private long[] T001827_A272DevolucionesID ;
   private long[] T001828_A272DevolucionesID ;
   private long[] T001828_A274DevolucionesDetalleID ;
   private String[] T001828_A76ArticuloNombre ;
   private java.math.BigDecimal[] T001828_A78ArticuloPrecioVenta ;
   private long[] T001828_A303DevolucionesDetalleTallaID ;
   private int[] T001828_A278DevolucionesDetalleCant ;
   private long[] T001828_A13ArticuloId ;
   private String[] T00184_A76ArticuloNombre ;
   private java.math.BigDecimal[] T00184_A78ArticuloPrecioVenta ;
   private String[] T001829_A76ArticuloNombre ;
   private java.math.BigDecimal[] T001829_A78ArticuloPrecioVenta ;
   private long[] T001830_A272DevolucionesID ;
   private long[] T001830_A274DevolucionesDetalleID ;
   private long[] T00183_A272DevolucionesID ;
   private long[] T00183_A274DevolucionesDetalleID ;
   private long[] T00183_A303DevolucionesDetalleTallaID ;
   private int[] T00183_A278DevolucionesDetalleCant ;
   private long[] T00183_A13ArticuloId ;
   private long[] T00182_A272DevolucionesID ;
   private long[] T00182_A274DevolucionesDetalleID ;
   private long[] T00182_A303DevolucionesDetalleTallaID ;
   private int[] T00182_A278DevolucionesDetalleCant ;
   private long[] T00182_A13ArticuloId ;
   private String[] T001834_A76ArticuloNombre ;
   private java.math.BigDecimal[] T001834_A78ArticuloPrecioVenta ;
   private long[] T001835_A272DevolucionesID ;
   private long[] T001835_A274DevolucionesDetalleID ;
   private long[] T001836_A286TallaID ;
   private short[] T001836_A288TallaNumero ;
   private long[] T001837_A286TallaID ;
   private short[] T001837_A288TallaNumero ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
}

final  class devoluciones__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class devoluciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00182", "SELECT [DevolucionesID], [DevolucionesDetalleID], [DevolucionesDetalleTallaID], [DevolucionesDetalleCant], [ArticuloId] FROM [DevolucionesDetalle] WITH (UPDLOCK) WHERE [DevolucionesID] = ? AND [DevolucionesDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00183", "SELECT [DevolucionesID], [DevolucionesDetalleID], [DevolucionesDetalleTallaID], [DevolucionesDetalleCant], [ArticuloId] FROM [DevolucionesDetalle] WHERE [DevolucionesID] = ? AND [DevolucionesDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00184", "SELECT [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00185", "SELECT [DevolucionesID], [DevolucionesFecha], [DevolucionesObservacion], [VentasId], [MotivoDevolucionID] FROM [Devoluciones] WITH (UPDLOCK) WHERE [DevolucionesID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00186", "SELECT [DevolucionesID], [DevolucionesFecha], [DevolucionesObservacion], [VentasId], [MotivoDevolucionID] FROM [Devoluciones] WHERE [DevolucionesID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00187", "SELECT [VentasFecha], [ClienteId], [TipoPagoId] FROM [Ventas] WHERE [VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00188", "SELECT [MotivoDevolucionDescripcion] FROM [MotivoDevolucion] WHERE [MotivoDevolucionID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001810", "SELECT COALESCE( T1.[DevolucionesTotal], 0) AS DevolucionesTotal FROM (SELECT SUM(T3.[ArticuloPrecioVenta] * CAST(T2.[DevolucionesDetalleCant] AS decimal( 27, 10))) AS DevolucionesTotal, T2.[DevolucionesID] FROM ([DevolucionesDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) GROUP BY T2.[DevolucionesID] ) T1 WHERE T1.[DevolucionesID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001812", "SELECT TM1.[DevolucionesID], TM1.[DevolucionesFecha], T3.[VentasFecha], T4.[MotivoDevolucionDescripcion], TM1.[DevolucionesObservacion], TM1.[VentasId], TM1.[MotivoDevolucionID], T3.[ClienteId], T3.[TipoPagoId], COALESCE( T2.[DevolucionesTotal], 0) AS DevolucionesTotal FROM ((([Devoluciones] TM1 LEFT JOIN (SELECT SUM(T6.[ArticuloPrecioVenta] * CAST(T5.[DevolucionesDetalleCant] AS decimal( 27, 10))) AS DevolucionesTotal, T5.[DevolucionesID] FROM ([DevolucionesDetalle] T5 INNER JOIN [Articulo] T6 ON T6.[ArticuloId] = T5.[ArticuloId]) GROUP BY T5.[DevolucionesID] ) T2 ON T2.[DevolucionesID] = TM1.[DevolucionesID]) INNER JOIN [Ventas] T3 ON T3.[VentasId] = TM1.[VentasId]) INNER JOIN [MotivoDevolucion] T4 ON T4.[MotivoDevolucionID] = TM1.[MotivoDevolucionID]) WHERE TM1.[DevolucionesID] = ? ORDER BY TM1.[DevolucionesID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001814", "SELECT COALESCE( T1.[DevolucionesTotal], 0) AS DevolucionesTotal FROM (SELECT SUM(T3.[ArticuloPrecioVenta] * CAST(T2.[DevolucionesDetalleCant] AS decimal( 27, 10))) AS DevolucionesTotal, T2.[DevolucionesID] FROM ([DevolucionesDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) GROUP BY T2.[DevolucionesID] ) T1 WHERE T1.[DevolucionesID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001815", "SELECT [VentasFecha], [ClienteId], [TipoPagoId] FROM [Ventas] WHERE [VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001816", "SELECT [MotivoDevolucionDescripcion] FROM [MotivoDevolucion] WHERE [MotivoDevolucionID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001817", "SELECT [DevolucionesID] FROM [Devoluciones] WHERE [DevolucionesID] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001818", "SELECT TOP 1 [DevolucionesID] FROM [Devoluciones] WHERE ( [DevolucionesID] > ?) ORDER BY [DevolucionesID]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001819", "SELECT TOP 1 [DevolucionesID] FROM [Devoluciones] WHERE ( [DevolucionesID] < ?) ORDER BY [DevolucionesID] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001820", "INSERT INTO [Devoluciones]([DevolucionesID], [DevolucionesFecha], [DevolucionesObservacion], [VentasId], [MotivoDevolucionID]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001821", "UPDATE [Devoluciones] SET [DevolucionesFecha]=?, [DevolucionesObservacion]=?, [VentasId]=?, [MotivoDevolucionID]=?  WHERE [DevolucionesID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001822", "DELETE FROM [Devoluciones]  WHERE [DevolucionesID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001824", "SELECT COALESCE( T1.[DevolucionesTotal], 0) AS DevolucionesTotal FROM (SELECT SUM(T3.[ArticuloPrecioVenta] * CAST(T2.[DevolucionesDetalleCant] AS decimal( 27, 10))) AS DevolucionesTotal, T2.[DevolucionesID] FROM ([DevolucionesDetalle] T2 WITH (UPDLOCK) INNER JOIN [Articulo] T3 ON T3.[ArticuloId] = T2.[ArticuloId]) GROUP BY T2.[DevolucionesID] ) T1 WHERE T1.[DevolucionesID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001825", "SELECT [VentasFecha], [ClienteId], [TipoPagoId] FROM [Ventas] WHERE [VentasId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001826", "SELECT [MotivoDevolucionDescripcion] FROM [MotivoDevolucion] WHERE [MotivoDevolucionID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001827", "SELECT [DevolucionesID] FROM [Devoluciones] ORDER BY [DevolucionesID]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001828", "SELECT T1.[DevolucionesID], T1.[DevolucionesDetalleID], T2.[ArticuloNombre], T2.[ArticuloPrecioVenta], T1.[DevolucionesDetalleTallaID], T1.[DevolucionesDetalleCant], T1.[ArticuloId] FROM ([DevolucionesDetalle] T1 INNER JOIN [Articulo] T2 ON T2.[ArticuloId] = T1.[ArticuloId]) WHERE T1.[DevolucionesID] = ? and T1.[DevolucionesDetalleID] = ? ORDER BY T1.[DevolucionesID], T1.[DevolucionesDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001829", "SELECT [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001830", "SELECT [DevolucionesID], [DevolucionesDetalleID] FROM [DevolucionesDetalle] WHERE [DevolucionesID] = ? AND [DevolucionesDetalleID] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001831", "INSERT INTO [DevolucionesDetalle]([DevolucionesID], [DevolucionesDetalleID], [DevolucionesDetalleTallaID], [DevolucionesDetalleCant], [ArticuloId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T001832", "UPDATE [DevolucionesDetalle] SET [DevolucionesDetalleTallaID]=?, [DevolucionesDetalleCant]=?, [ArticuloId]=?  WHERE [DevolucionesID] = ? AND [DevolucionesDetalleID] = ?", GX_NOMASK)
         ,new UpdateCursor("T001833", "DELETE FROM [DevolucionesDetalle]  WHERE [DevolucionesID] = ? AND [DevolucionesDetalleID] = ?", GX_NOMASK)
         ,new ForEachCursor("T001834", "SELECT [ArticuloNombre], [ArticuloPrecioVenta] FROM [Articulo] WHERE [ArticuloId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001835", "SELECT [DevolucionesID], [DevolucionesDetalleID] FROM [DevolucionesDetalle] WHERE [DevolucionesID] = ? ORDER BY [DevolucionesID], [DevolucionesDetalleID] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001836", "SELECT [TallaID], [TallaNumero] FROM [Talla] ORDER BY [TallaNumero] ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001837", "SELECT [TallaID], [TallaNumero] FROM [Talla] ORDER BY [TallaNumero] ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               return;
            case 5 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((long[]) buf[8])[0] = rslt.getLong(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               return;
            case 9 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 10 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 18 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 19 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 22 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 80);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               return;
            case 24 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getString(1, 80);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               return;
            case 29 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 31 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 16 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 18 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 19 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 20 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 22 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 23 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 24 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 25 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 26 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               return;
            case 27 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 28 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 29 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

