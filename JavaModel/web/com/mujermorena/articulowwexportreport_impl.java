package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class articulowwexportreport_impl extends GXWebReport
{
   public articulowwexportreport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("WorkWithPlusDS");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 1, 15840, 12240, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "articuloww_Execute", GXv_boolean2) ;
         articulowwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV9WWPContext;
            new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV9WWPContext = GXv_SdtWWPContext3[0] ;
            /* Execute user subroutine: 'LOADGRIDSTATE' */
            S151 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV28Title = httpContext.getMessage( "Lista de Articulo", "") ;
            /* Execute user subroutine: 'PRINTFILTERS' */
            S111 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTCOLUMNTITLES' */
            S121 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTDATA' */
            S131 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTFOOTER' */
            S171 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         h490( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( ) throws ProcessInterruptedException
   {
      /* 'PRINTFILTERS' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13FilterFullText)==0) )
      {
         h490( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "WWP_FullTextFilterDescription", ""), 25, Gx_line+0, 99, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV13FilterFullText, "")), 99, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      h490( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h490( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 30, Gx_line+10, 84, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Nombre", ""), 88, Gx_line+10, 142, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Descripcion Corta", ""), 146, Gx_line+10, 200, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Descripcion Larga", ""), 204, Gx_line+10, 258, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Precio Compra", ""), 262, Gx_line+10, 316, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Precio Venta", ""), 320, Gx_line+10, 374, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Precio Promedio", ""), 378, Gx_line+10, 432, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Stock", ""), 436, Gx_line+10, 491, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Articulo Id", ""), 495, Gx_line+10, 550, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Articulo Nombre", ""), 554, Gx_line+10, 610, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Id", ""), 614, Gx_line+10, 669, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Porcentaje", ""), 673, Gx_line+10, 728, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Imagen", ""), 732, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Articulowwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV35Articulowwds_1_filterfulltext ,
                                           Long.valueOf(A13ArticuloId) ,
                                           A76ArticuloNombre ,
                                           A214ArticuloDescripcionCorta ,
                                           A215ArticuloDescripcionLarga ,
                                           A77ArticuloPrecioCompra ,
                                           A78ArticuloPrecioVenta ,
                                           A222ArticuloPrecioPromedio ,
                                           Long.valueOf(A79ArticuloStock) ,
                                           A103TipoArticuloNombre ,
                                           Long.valueOf(A18ImpuestoId) ,
                                           A83ImpuestoPorcentaje ,
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.LONG, TypeConstants.STRING,
                                           TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      lV35Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Articulowwds_1_filterfulltext), "%", "") ;
      /* Using cursor P00492 */
      pr_default.execute(0, new Object[] {lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext, lV35Articulowwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A83ImpuestoPorcentaje = P00492_A83ImpuestoPorcentaje[0] ;
         A18ImpuestoId = P00492_A18ImpuestoId[0] ;
         A17TipoArticuloId = P00492_A17TipoArticuloId[0] ;
         A79ArticuloStock = P00492_A79ArticuloStock[0] ;
         A222ArticuloPrecioPromedio = P00492_A222ArticuloPrecioPromedio[0] ;
         A78ArticuloPrecioVenta = P00492_A78ArticuloPrecioVenta[0] ;
         A77ArticuloPrecioCompra = P00492_A77ArticuloPrecioCompra[0] ;
         A13ArticuloId = P00492_A13ArticuloId[0] ;
         A103TipoArticuloNombre = P00492_A103TipoArticuloNombre[0] ;
         A215ArticuloDescripcionLarga = P00492_A215ArticuloDescripcionLarga[0] ;
         A214ArticuloDescripcionCorta = P00492_A214ArticuloDescripcionCorta[0] ;
         A76ArticuloNombre = P00492_A76ArticuloNombre[0] ;
         A40000ArticuloImagen_GXI = P00492_A40000ArticuloImagen_GXI[0] ;
         A231ArticuloImagen = P00492_A231ArticuloImagen[0] ;
         A83ImpuestoPorcentaje = P00492_A83ImpuestoPorcentaje[0] ;
         A103TipoArticuloNombre = P00492_A103TipoArticuloNombre[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         h490( false, 66) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A13ArticuloId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 84, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A76ArticuloNombre, "")), 88, Gx_line+10, 142, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A214ArticuloDescripcionCorta, "")), 146, Gx_line+10, 200, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(A215ArticuloDescripcionLarga, 204, Gx_line+10, 258, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A77ArticuloPrecioCompra, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 262, Gx_line+10, 316, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A78ArticuloPrecioVenta, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 320, Gx_line+10, 374, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A222ArticuloPrecioPromedio, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 378, Gx_line+10, 432, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A79ArticuloStock), "ZZZZZZZZZ9")), 436, Gx_line+10, 491, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A17TipoArticuloId), "ZZZZZZZZZZ9")), 495, Gx_line+10, 550, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A103TipoArticuloNombre, "")), 554, Gx_line+10, 610, Gx_line+55, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A18ImpuestoId), "ZZZZZZZZZZ9")), 614, Gx_line+10, 669, Gx_line+55, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A83ImpuestoPorcentaje, "ZZZZZ9.99")), 673, Gx_line+10, 728, Gx_line+55, 2, 0, 0, 0) ;
         sImgUrl = ((GXutil.strcmp("", A231ArticuloImagen)==0) ? A40000ArticuloImagen_GXI : A231ArticuloImagen) ;
         getPrinter().GxDrawBitMap(sImgUrl, 732, Gx_line+10, 787, Gx_line+55) ;
         getPrinter().GxDrawLine(28, Gx_line+65, 789, Gx_line+65, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+66) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV14Session.getValue("ArticuloWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ArticuloWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("ArticuloWWGridState"), null, null);
      }
      AV11OrderedBy = AV16GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV12OrderedDsc = AV16GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV36GXV1 = 1 ;
      while ( AV36GXV1 <= AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV17GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV16GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV36GXV1));
         if ( GXutil.strcmp(AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV13FilterFullText = AV17GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV36GXV1 = (int)(AV36GXV1+1) ;
      }
   }

   public void S144( ) throws ProcessInterruptedException
   {
      /* 'BEFOREPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S161( ) throws ProcessInterruptedException
   {
      /* 'AFTERPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S171( ) throws ProcessInterruptedException
   {
      /* 'PRINTFOOTER' Routine */
      returnInSub = false ;
   }

   public void h490( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               AV26PageInfo = httpContext.getMessage( "Page: ", "") + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV23DateInfo = httpContext.getMessage( "Date: ", "") + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 128, 128, 0, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV26PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV23DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+40) ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            AV21AppName = httpContext.getMessage( "DVelop Software Solutions", "") ;
            AV27Phone = "+1 550 8923" ;
            AV25Mail = "info@mail.com" ;
            AV29Website = "http://www.web.com" ;
            AV18AddressLine1 = "French Boulevard 2859" ;
            AV19AddressLine2 = "Downtown" ;
            AV20AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 128, 128, 0, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV21AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV28Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV27Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV25Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV18AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV19AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV20AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+128) ;
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
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
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Title = "" ;
      AV13FilterFullText = "" ;
      A76ArticuloNombre = "" ;
      A214ArticuloDescripcionCorta = "" ;
      A215ArticuloDescripcionLarga = "" ;
      A77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      A103TipoArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      A231ArticuloImagen = "" ;
      A40000ArticuloImagen_GXI = "" ;
      AV35Articulowwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV35Articulowwds_1_filterfulltext = "" ;
      P00492_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00492_A18ImpuestoId = new long[1] ;
      P00492_A17TipoArticuloId = new long[1] ;
      P00492_A79ArticuloStock = new long[1] ;
      P00492_A222ArticuloPrecioPromedio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00492_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00492_A77ArticuloPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00492_A13ArticuloId = new long[1] ;
      P00492_A103TipoArticuloNombre = new String[] {""} ;
      P00492_A215ArticuloDescripcionLarga = new String[] {""} ;
      P00492_A214ArticuloDescripcionCorta = new String[] {""} ;
      P00492_A76ArticuloNombre = new String[] {""} ;
      P00492_A40000ArticuloImagen_GXI = new String[] {""} ;
      P00492_A231ArticuloImagen = new String[] {""} ;
      sImgUrl = "" ;
      AV14Session = httpContext.getWebSession();
      AV16GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV17GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV26PageInfo = "" ;
      AV23DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV21AppName = "" ;
      AV27Phone = "" ;
      AV25Mail = "" ;
      AV29Website = "" ;
      AV18AddressLine1 = "" ;
      AV19AddressLine2 = "" ;
      AV20AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articulowwexportreport__default(),
         new Object[] {
             new Object[] {
            P00492_A83ImpuestoPorcentaje, P00492_A18ImpuestoId, P00492_A17TipoArticuloId, P00492_A79ArticuloStock, P00492_A222ArticuloPrecioPromedio, P00492_A78ArticuloPrecioVenta, P00492_A77ArticuloPrecioCompra, P00492_A13ArticuloId, P00492_A103TipoArticuloNombre, P00492_A215ArticuloDescripcionLarga,
            P00492_A214ArticuloDescripcionCorta, P00492_A76ArticuloNombre, P00492_A40000ArticuloImagen_GXI, P00492_A231ArticuloImagen
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV11OrderedBy ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV36GXV1 ;
   private long A13ArticuloId ;
   private long A79ArticuloStock ;
   private long A17TipoArticuloId ;
   private long A18ImpuestoId ;
   private java.math.BigDecimal A77ArticuloPrecioCompra ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String A76ArticuloNombre ;
   private String A103TipoArticuloNombre ;
   private String scmdbuf ;
   private String sImgUrl ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private String A215ArticuloDescripcionLarga ;
   private String AV28Title ;
   private String AV13FilterFullText ;
   private String A214ArticuloDescripcionCorta ;
   private String A40000ArticuloImagen_GXI ;
   private String AV35Articulowwds_1_filterfulltext ;
   private String lV35Articulowwds_1_filterfulltext ;
   private String AV26PageInfo ;
   private String AV23DateInfo ;
   private String AV21AppName ;
   private String AV27Phone ;
   private String AV25Mail ;
   private String AV29Website ;
   private String AV18AddressLine1 ;
   private String AV19AddressLine2 ;
   private String AV20AddressLine3 ;
   private String A231ArticuloImagen ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00492_A83ImpuestoPorcentaje ;
   private long[] P00492_A18ImpuestoId ;
   private long[] P00492_A17TipoArticuloId ;
   private long[] P00492_A79ArticuloStock ;
   private java.math.BigDecimal[] P00492_A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal[] P00492_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] P00492_A77ArticuloPrecioCompra ;
   private long[] P00492_A13ArticuloId ;
   private String[] P00492_A103TipoArticuloNombre ;
   private String[] P00492_A215ArticuloDescripcionLarga ;
   private String[] P00492_A214ArticuloDescripcionCorta ;
   private String[] P00492_A76ArticuloNombre ;
   private String[] P00492_A40000ArticuloImagen_GXI ;
   private String[] P00492_A231ArticuloImagen ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class articulowwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00492( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV35Articulowwds_1_filterfulltext ,
                                          long A13ArticuloId ,
                                          String A76ArticuloNombre ,
                                          String A214ArticuloDescripcionCorta ,
                                          String A215ArticuloDescripcionLarga ,
                                          java.math.BigDecimal A77ArticuloPrecioCompra ,
                                          java.math.BigDecimal A78ArticuloPrecioVenta ,
                                          java.math.BigDecimal A222ArticuloPrecioPromedio ,
                                          long A79ArticuloStock ,
                                          String A103TipoArticuloNombre ,
                                          long A18ImpuestoId ,
                                          java.math.BigDecimal A83ImpuestoPorcentaje ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[12];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.[ImpuestoPorcentaje], T1.[ImpuestoId], T1.[TipoArticuloId], T1.[ArticuloStock], T1.[ArticuloPrecioPromedio], T1.[ArticuloPrecioVenta], T1.[ArticuloPrecioCompra]," ;
      scmdbuf += " T1.[ArticuloId], T3.[TipoArticuloNombre], T1.[ArticuloDescripcionLarga], T1.[ArticuloDescripcionCorta], T1.[ArticuloNombre], T1.[ArticuloImagen_GXI], T1.[ArticuloImagen]" ;
      scmdbuf += " FROM (([Articulo] T1 INNER JOIN [Impuesto] T2 ON T2.[ImpuestoId] = T1.[ImpuestoId]) INNER JOIN [TipoArticulo] T3 ON T3.[TipoArticuloId] = T1.[TipoArticuloId])" ;
      if ( ! (GXutil.strcmp("", AV35Articulowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[ArticuloId] AS decimal(11,0))) like '%' + ?) or ( T1.[ArticuloNombre] like '%' + ?) or ( T1.[ArticuloDescripcionCorta] like '%' + ?) or ( T1.[ArticuloDescripcionLarga] like '%' + ?) or ( CONVERT( char(17), CAST(T1.[ArticuloPrecioCompra] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[ArticuloPrecioVenta] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[ArticuloPrecioPromedio] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(10), CAST(T1.[ArticuloStock] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoArticuloId] AS decimal(11,0))) like '%' + ?) or ( T3.[TipoArticuloNombre] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ImpuestoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(9), CAST(T2.[ImpuestoPorcentaje] AS decimal(9,2))) like '%' + ?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
         GXv_int4[1] = (byte)(1) ;
         GXv_int4[2] = (byte)(1) ;
         GXv_int4[3] = (byte)(1) ;
         GXv_int4[4] = (byte)(1) ;
         GXv_int4[5] = (byte)(1) ;
         GXv_int4[6] = (byte)(1) ;
         GXv_int4[7] = (byte)(1) ;
         GXv_int4[8] = (byte)(1) ;
         GXv_int4[9] = (byte)(1) ;
         GXv_int4[10] = (byte)(1) ;
         GXv_int4[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloNombre]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionCorta]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionCorta] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionLarga]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionLarga] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioCompra]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioCompra] DESC" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioVenta]" ;
      }
      else if ( ( AV11OrderedBy == 6 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioVenta] DESC" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioPromedio]" ;
      }
      else if ( ( AV11OrderedBy == 7 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioPromedio] DESC" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloStock]" ;
      }
      else if ( ( AV11OrderedBy == 8 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloStock] DESC" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TipoArticuloId]" ;
      }
      else if ( ( AV11OrderedBy == 9 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TipoArticuloId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[TipoArticuloNombre]" ;
      }
      else if ( ( AV11OrderedBy == 10 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[TipoArticuloNombre] DESC" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ImpuestoId]" ;
      }
      else if ( ( AV11OrderedBy == 11 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ImpuestoId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ImpuestoPorcentaje]" ;
      }
      else if ( ( AV11OrderedBy == 12 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ImpuestoPorcentaje] DESC" ;
      }
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00492(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).longValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , (java.math.BigDecimal)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00492", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((long[]) buf[7])[0] = rslt.getLong(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
               ((String[]) buf[12])[0] = rslt.getMultimediaUri(13);
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(13));
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               return;
      }
   }

}

