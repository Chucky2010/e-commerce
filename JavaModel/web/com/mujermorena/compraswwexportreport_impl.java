package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class compraswwexportreport_impl extends GXWebReport
{
   public compraswwexportreport_impl( com.genexus.internet.HttpContext context )
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
         new com.mujermorena.wwpbaseobjects.secgamisauthbyfunctionalitykey(remoteHandle, context).execute( "comprasww_Execute", GXv_boolean2) ;
         compraswwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
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
            AV28Title = httpContext.getMessage( "Lista de Compras", "") ;
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
         h4D0( true, 0) ;
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
         h4D0( false, 20) ;
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
      h4D0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 128, 128, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      h4D0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 128, 128, 0, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Compras Id", ""), 30, Gx_line+10, 89, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Fecha", ""), 93, Gx_line+10, 152, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Proveedor Id", ""), 156, Gx_line+10, 215, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Timbrado", ""), 219, Gx_line+10, 278, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Numero Factura", ""), 282, Gx_line+10, 341, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Exento", ""), 345, Gx_line+10, 404, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Iva5", ""), 408, Gx_line+10, 467, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Iva10", ""), 471, Gx_line+10, 531, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total", ""), 535, Gx_line+10, 595, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total5", ""), 599, Gx_line+10, 659, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total10", ""), 663, Gx_line+10, 723, Gx_line+27, 2, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Total Iva", ""), 727, Gx_line+10, 787, Gx_line+27, 2, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV35Compraswwds_1_filterfulltext = AV13FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV11OrderedBy) ,
                                           Boolean.valueOf(AV12OrderedDsc) ,
                                           AV35Compraswwds_1_filterfulltext ,
                                           Long.valueOf(A11ComprasId) ,
                                           Long.valueOf(A10ProveedorId) ,
                                           Long.valueOf(A226ComprasTimbrado) ,
                                           Long.valueOf(A227ComprasNumeroFactura) ,
                                           A90ComprasTotalExento ,
                                           A87ComprasTotalIva5 ,
                                           A89ComprasTotalIva10 ,
                                           A229ComprasTotal ,
                                           A86ComprasTotal5 ,
                                           A88ComprasTotal10 ,
                                           A225ComprasTotalIva } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN
                                           }
      });
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      lV35Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV35Compraswwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004D7 */
      pr_default.execute(0, new Object[] {AV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext, lV35Compraswwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A88ComprasTotal10 = P004D7_A88ComprasTotal10[0] ;
         A86ComprasTotal5 = P004D7_A86ComprasTotal5[0] ;
         A227ComprasNumeroFactura = P004D7_A227ComprasNumeroFactura[0] ;
         A226ComprasTimbrado = P004D7_A226ComprasTimbrado[0] ;
         A10ProveedorId = P004D7_A10ProveedorId[0] ;
         A11ComprasId = P004D7_A11ComprasId[0] ;
         A74ComprasFecha = P004D7_A74ComprasFecha[0] ;
         A225ComprasTotalIva = P004D7_A225ComprasTotalIva[0] ;
         n225ComprasTotalIva = P004D7_n225ComprasTotalIva[0] ;
         A89ComprasTotalIva10 = P004D7_A89ComprasTotalIva10[0] ;
         A87ComprasTotalIva5 = P004D7_A87ComprasTotalIva5[0] ;
         A229ComprasTotal = P004D7_A229ComprasTotal[0] ;
         n229ComprasTotal = P004D7_n229ComprasTotal[0] ;
         A90ComprasTotalExento = P004D7_A90ComprasTotalExento[0] ;
         A88ComprasTotal10 = P004D7_A88ComprasTotal10[0] ;
         A86ComprasTotal5 = P004D7_A86ComprasTotal5[0] ;
         A225ComprasTotalIva = P004D7_A225ComprasTotalIva[0] ;
         n225ComprasTotalIva = P004D7_n225ComprasTotalIva[0] ;
         A229ComprasTotal = P004D7_A229ComprasTotal[0] ;
         n229ComprasTotal = P004D7_n229ComprasTotal[0] ;
         A89ComprasTotalIva10 = P004D7_A89ComprasTotalIva10[0] ;
         A87ComprasTotalIva5 = P004D7_A87ComprasTotalIva5[0] ;
         A90ComprasTotalExento = P004D7_A90ComprasTotalExento[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
         h4D0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A11ComprasId), "ZZZZZZZZZZ9")), 30, Gx_line+10, 89, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(localUtil.format( A74ComprasFecha, "99/99/99"), 93, Gx_line+10, 152, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A10ProveedorId), "ZZZZZZZZZZ9")), 156, Gx_line+10, 215, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A226ComprasTimbrado), "ZZZZZZZZZZZZZZ9")), 219, Gx_line+10, 278, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A227ComprasNumeroFactura), "ZZZZZZZZZZZZZZ9")), 282, Gx_line+10, 341, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A90ComprasTotalExento, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 345, Gx_line+10, 404, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A87ComprasTotalIva5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 408, Gx_line+10, 467, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A89ComprasTotalIva10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 471, Gx_line+10, 531, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A229ComprasTotal, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 535, Gx_line+10, 595, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A86ComprasTotal5, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 599, Gx_line+10, 659, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A88ComprasTotal10, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 663, Gx_line+10, 723, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.ltrim( localUtil.format( A225ComprasTotalIva, "ZZ,ZZZ,ZZZ,ZZZ,ZZ9.99")), 727, Gx_line+10, 787, Gx_line+25, 2, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+36) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
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
      if ( GXutil.strcmp(AV14Session.getValue("ComprasWWGridState"), "") == 0 )
      {
         AV16GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ComprasWWGridState"), null, null);
      }
      else
      {
         AV16GridState.fromxml(AV14Session.getValue("ComprasWWGridState"), null, null);
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

   public void h4D0( boolean bFoot ,
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
      A74ComprasFecha = GXutil.nullDate() ;
      A90ComprasTotalExento = DecimalUtil.ZERO ;
      A87ComprasTotalIva5 = DecimalUtil.ZERO ;
      A89ComprasTotalIva10 = DecimalUtil.ZERO ;
      A229ComprasTotal = DecimalUtil.ZERO ;
      A86ComprasTotal5 = DecimalUtil.ZERO ;
      A88ComprasTotal10 = DecimalUtil.ZERO ;
      A225ComprasTotalIva = DecimalUtil.ZERO ;
      AV35Compraswwds_1_filterfulltext = "" ;
      lV35Compraswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      P004D7_A88ComprasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004D7_A86ComprasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004D7_A227ComprasNumeroFactura = new long[1] ;
      P004D7_A226ComprasTimbrado = new long[1] ;
      P004D7_A10ProveedorId = new long[1] ;
      P004D7_A11ComprasId = new long[1] ;
      P004D7_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004D7_A225ComprasTotalIva = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004D7_n225ComprasTotalIva = new boolean[] {false} ;
      P004D7_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004D7_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004D7_A229ComprasTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004D7_n229ComprasTotal = new boolean[] {false} ;
      P004D7_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
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
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.compraswwexportreport__default(),
         new Object[] {
             new Object[] {
            P004D7_A88ComprasTotal10, P004D7_A86ComprasTotal5, P004D7_A227ComprasNumeroFactura, P004D7_A226ComprasTimbrado, P004D7_A10ProveedorId, P004D7_A11ComprasId, P004D7_A74ComprasFecha, P004D7_A225ComprasTotalIva, P004D7_n225ComprasTotalIva, P004D7_A89ComprasTotalIva10,
            P004D7_A87ComprasTotalIva5, P004D7_A229ComprasTotal, P004D7_n229ComprasTotal, P004D7_A90ComprasTotalExento
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
   private long A11ComprasId ;
   private long A10ProveedorId ;
   private long A226ComprasTimbrado ;
   private long A227ComprasNumeroFactura ;
   private java.math.BigDecimal A90ComprasTotalExento ;
   private java.math.BigDecimal A87ComprasTotalIva5 ;
   private java.math.BigDecimal A89ComprasTotalIva10 ;
   private java.math.BigDecimal A229ComprasTotal ;
   private java.math.BigDecimal A86ComprasTotal5 ;
   private java.math.BigDecimal A88ComprasTotal10 ;
   private java.math.BigDecimal A225ComprasTotalIva ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private java.util.Date A74ComprasFecha ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV12OrderedDsc ;
   private boolean n225ComprasTotalIva ;
   private boolean n229ComprasTotal ;
   private String AV28Title ;
   private String AV13FilterFullText ;
   private String AV35Compraswwds_1_filterfulltext ;
   private String lV35Compraswwds_1_filterfulltext ;
   private String AV26PageInfo ;
   private String AV23DateInfo ;
   private String AV21AppName ;
   private String AV27Phone ;
   private String AV25Mail ;
   private String AV29Website ;
   private String AV18AddressLine1 ;
   private String AV19AddressLine2 ;
   private String AV20AddressLine3 ;
   private com.genexus.webpanels.WebSession AV14Session ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P004D7_A88ComprasTotal10 ;
   private java.math.BigDecimal[] P004D7_A86ComprasTotal5 ;
   private long[] P004D7_A227ComprasNumeroFactura ;
   private long[] P004D7_A226ComprasTimbrado ;
   private long[] P004D7_A10ProveedorId ;
   private long[] P004D7_A11ComprasId ;
   private java.util.Date[] P004D7_A74ComprasFecha ;
   private java.math.BigDecimal[] P004D7_A225ComprasTotalIva ;
   private boolean[] P004D7_n225ComprasTotalIva ;
   private java.math.BigDecimal[] P004D7_A89ComprasTotalIva10 ;
   private java.math.BigDecimal[] P004D7_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] P004D7_A229ComprasTotal ;
   private boolean[] P004D7_n229ComprasTotal ;
   private java.math.BigDecimal[] P004D7_A90ComprasTotalExento ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV16GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV17GridStateFilterValue ;
}

final  class compraswwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004D7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV11OrderedBy ,
                                          boolean AV12OrderedDsc ,
                                          String AV35Compraswwds_1_filterfulltext ,
                                          long A11ComprasId ,
                                          long A10ProveedorId ,
                                          long A226ComprasTimbrado ,
                                          long A227ComprasNumeroFactura ,
                                          java.math.BigDecimal A90ComprasTotalExento ,
                                          java.math.BigDecimal A87ComprasTotalIva5 ,
                                          java.math.BigDecimal A89ComprasTotalIva10 ,
                                          java.math.BigDecimal A229ComprasTotal ,
                                          java.math.BigDecimal A86ComprasTotal5 ,
                                          java.math.BigDecimal A88ComprasTotal10 ,
                                          java.math.BigDecimal A225ComprasTotalIva )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[12];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ROUND(CAST(COALESCE( T2.[ComprasTotalIva10], 0) AS decimal( 27, 10)) / 11, 0) AS ComprasTotal10, ROUND(CAST(COALESCE( T2.[ComprasTotalIva5], 0) AS decimal(" ;
      scmdbuf += " 27, 10)) / 21, 0) AS ComprasTotal5, T1.[ComprasNumeroFactura], T1.[ComprasTimbrado], T1.[ProveedorId], T1.[ComprasId], T1.[ComprasFecha], COALESCE( T3.[ComprasTotalIva]," ;
      scmdbuf += " 0) AS ComprasTotalIva, COALESCE( T4.[ComprasTotalIva10], 0) AS ComprasTotalIva10, COALESCE( T4.[ComprasTotalIva5], 0) AS ComprasTotalIva5, COALESCE( T3.[ComprasTotal]," ;
      scmdbuf += " 0) AS ComprasTotal, COALESCE( T4.[ComprasTotalExento], 0) AS ComprasTotalExento FROM ((([Compras] T1 LEFT JOIN (SELECT SUM(CASE  WHEN T7.[ImpuestoPorcentaje] =" ;
      scmdbuf += " 5 THEN T5.[ComprasCantidad] * CAST(T5.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, T5.[ComprasId], SUM(CASE  WHEN T7.[ImpuestoPorcentaje]" ;
      scmdbuf += " = 10 THEN T5.[ComprasCantidad] * CAST(T5.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T5 INNER JOIN [Articulo]" ;
      scmdbuf += " T6 ON T6.[ArticuloId] = T5.[ArticuloId]) INNER JOIN [Impuesto] T7 ON T7.[ImpuestoId] = T6.[ImpuestoId]) GROUP BY T5.[ComprasId] ) T2 ON T2.[ComprasId] = T1.[ComprasId])" ;
      scmdbuf += " INNER JOIN (SELECT COALESCE( T6.[ComprasTotalExento], 0) + COALESCE( COALESCE( T6.[ComprasTotalIva5], 0), 0) + COALESCE( COALESCE( T6.[ComprasTotalIva10], 0), 0)" ;
      scmdbuf += " AS ComprasTotal, T5.[ComprasId], COALESCE( T7.[ComprasTotalIva5], 0) + COALESCE( T7.[ComprasTotalIva10], 0) AS ComprasTotalIva FROM (([Compras] T5 LEFT JOIN (SELECT" ;
      scmdbuf += " T8.[ComprasId], SUM(CASE  WHEN T10.[ImpuestoPorcentaje] = 10 THEN T8.[ComprasCantidad] * CAST(T8.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10," ;
      scmdbuf += " SUM(CASE  WHEN T10.[ImpuestoPorcentaje] = 5 THEN T8.[ComprasCantidad] * CAST(T8.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE" ;
      scmdbuf += "  WHEN T10.[ImpuestoPorcentaje] = 0 THEN T8.[ComprasCantidad] * CAST(T8.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento FROM (([ComprasDetalle]" ;
      scmdbuf += " T8 INNER JOIN [Articulo] T9 ON T9.[ArticuloId] = T8.[ArticuloId]) INNER JOIN [Impuesto] T10 ON T10.[ImpuestoId] = T9.[ImpuestoId]) GROUP BY T8.[ComprasId] ) T6" ;
      scmdbuf += " ON T6.[ComprasId] = T5.[ComprasId]) LEFT JOIN (SELECT SUM(CASE  WHEN T10.[ImpuestoPorcentaje] = 5 THEN T8.[ComprasCantidad] * CAST(T8.[ComprasDetallePrecioCompra]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS ComprasTotalIva5, T8.[ComprasId], SUM(CASE  WHEN T10.[ImpuestoPorcentaje] = 10 THEN T8.[ComprasCantidad] * CAST(T8.[ComprasDetallePrecioCompra]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS ComprasTotalIva10 FROM (([ComprasDetalle] T8 INNER JOIN [Articulo] T9 ON T9.[ArticuloId] = T8.[ArticuloId]) INNER JOIN [Impuesto] T10" ;
      scmdbuf += " ON T10.[ImpuestoId] = T9.[ImpuestoId]) GROUP BY T8.[ComprasId] ) T7 ON T7.[ComprasId] = T5.[ComprasId]) ) T3 ON T3.[ComprasId] = T1.[ComprasId]) LEFT JOIN (SELECT" ;
      scmdbuf += " T5.[ComprasId], SUM(CASE  WHEN T7.[ImpuestoPorcentaje] = 10 THEN T5.[ComprasCantidad] * CAST(T5.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva10," ;
      scmdbuf += " SUM(CASE  WHEN T7.[ImpuestoPorcentaje] = 5 THEN T5.[ComprasCantidad] * CAST(T5.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalIva5, SUM(CASE" ;
      scmdbuf += "  WHEN T7.[ImpuestoPorcentaje] = 0 THEN T5.[ComprasCantidad] * CAST(T5.[ComprasDetallePrecioCompra] AS decimal( 27, 10)) END) AS ComprasTotalExento FROM (([ComprasDetalle]" ;
      scmdbuf += " T5 INNER JOIN [Articulo] T6 ON T6.[ArticuloId] = T5.[ArticuloId]) INNER JOIN [Impuesto] T7 ON T7.[ImpuestoId] = T6.[ImpuestoId]) GROUP BY T5.[ComprasId] ) T4 ON" ;
      scmdbuf += " T4.[ComprasId] = T1.[ComprasId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(11), CAST(T1.[ComprasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ProveedorId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(15), CAST(T1.[ComprasTimbrado] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(15), CAST(T1.[ComprasNumeroFactura] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T4.[ComprasTotalExento], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T4.[ComprasTotalIva5], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T4.[ComprasTotalIva10], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T3.[ComprasTotal], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T2.[ComprasTotalIva5], 0) AS decimal( 27, 10)) / 21, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T2.[ComprasTotalIva10], 0) AS decimal( 27, 10)) / 11, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T3.[ComprasTotalIva], 0) AS decimal(17,2))) like '%' + ?)))");
      scmdbuf += sWhereString ;
      if ( ( AV11OrderedBy == 1 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasId]" ;
      }
      else if ( ( AV11OrderedBy == 1 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasFecha]" ;
      }
      else if ( ( AV11OrderedBy == 2 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasFecha] DESC" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProveedorId]" ;
      }
      else if ( ( AV11OrderedBy == 3 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProveedorId] DESC" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasTimbrado]" ;
      }
      else if ( ( AV11OrderedBy == 4 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasTimbrado] DESC" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ! AV12OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasNumeroFactura]" ;
      }
      else if ( ( AV11OrderedBy == 5 ) && ( AV12OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasNumeroFactura] DESC" ;
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
                  return conditional_P004D7(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).longValue() , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004D7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(12,2);
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

