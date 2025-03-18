package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ventaswwexport extends GXProcedure
{
   public ventaswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ventaswwexport.class ), "" );
   }

   public ventaswwexport( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      ventaswwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      ventaswwexport.this.aP0 = aP0;
      ventaswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'OPENDOCUMENT' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14CellRow = 1 ;
      AV15FirstColumn = 1 ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S191 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'WRITEFILTERS' */
      S131 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'WRITECOLUMNTITLES' */
      S141 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'WRITEDATA' */
      S151 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'CLOSEDOCUMENT' */
      S181 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "VentasWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV19FilterFullText)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.mujermorena.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "WWP_FullTextFilterDescription", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         ventaswwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         ventaswwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Fecha", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Pedido", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Timbrado Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Timbrado Numero", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Serie1", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "Serie2", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( httpContext.getMessage( "Nro Factura", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( httpContext.getMessage( "Tipo Pago Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setText( httpContext.getMessage( "Tipo Pago Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setText( httpContext.getMessage( "Serial", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setText( httpContext.getMessage( "Total Exento", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+13, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+13, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+13, 1, 1).setText( httpContext.getMessage( "Total5", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+14, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+14, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+14, 1, 1).setText( httpContext.getMessage( "Total10", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+15, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+15, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+15, 1, 1).setText( httpContext.getMessage( "Total", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+16, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+16, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+16, 1, 1).setText( httpContext.getMessage( "Total Iva5", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+17, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+17, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+17, 1, 1).setText( httpContext.getMessage( "Total Iva10", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+18, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+18, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+18, 1, 1).setText( httpContext.getMessage( "Total IVA", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Ventaswwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           AV27Ventaswwds_1_filterfulltext ,
                                           Long.valueOf(A19VentasId) ,
                                           Long.valueOf(A4ClienteId) ,
                                           Long.valueOf(A251VentasPedido) ,
                                           Long.valueOf(A29TimbradoId) ,
                                           Long.valueOf(A125TimbradoNumero) ,
                                           Short.valueOf(A309VentasSerie1) ,
                                           Short.valueOf(A310VentasSerie2) ,
                                           Long.valueOf(A311VentasNroFactura) ,
                                           Long.valueOf(A9TipoPagoId) ,
                                           A71TipoPagoNombre ,
                                           Long.valueOf(A242VentasSerial) ,
                                           A239VentasTotalExento ,
                                           A236VentasTotal5 ,
                                           A238VentasTotal10 ,
                                           A240VentasTotal ,
                                           A235VentasTotalIva5 ,
                                           A237VentasTotalIva10 ,
                                           A241VentasTotalIVA } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN,
                                           TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN
                                           }
      });
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      lV27Ventaswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ventaswwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004E8 */
      pr_default.execute(0, new Object[] {AV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext, lV27Ventaswwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A237VentasTotalIva10 = P004E8_A237VentasTotalIva10[0] ;
         n237VentasTotalIva10 = P004E8_n237VentasTotalIva10[0] ;
         A235VentasTotalIva5 = P004E8_A235VentasTotalIva5[0] ;
         n235VentasTotalIva5 = P004E8_n235VentasTotalIva5[0] ;
         A242VentasSerial = P004E8_A242VentasSerial[0] ;
         A9TipoPagoId = P004E8_A9TipoPagoId[0] ;
         A311VentasNroFactura = P004E8_A311VentasNroFactura[0] ;
         A310VentasSerie2 = P004E8_A310VentasSerie2[0] ;
         A309VentasSerie1 = P004E8_A309VentasSerie1[0] ;
         A125TimbradoNumero = P004E8_A125TimbradoNumero[0] ;
         A29TimbradoId = P004E8_A29TimbradoId[0] ;
         A251VentasPedido = P004E8_A251VentasPedido[0] ;
         A4ClienteId = P004E8_A4ClienteId[0] ;
         A19VentasId = P004E8_A19VentasId[0] ;
         A71TipoPagoNombre = P004E8_A71TipoPagoNombre[0] ;
         A91VentasFecha = P004E8_A91VentasFecha[0] ;
         A241VentasTotalIVA = P004E8_A241VentasTotalIVA[0] ;
         n241VentasTotalIVA = P004E8_n241VentasTotalIVA[0] ;
         A238VentasTotal10 = P004E8_A238VentasTotal10[0] ;
         n238VentasTotal10 = P004E8_n238VentasTotal10[0] ;
         A236VentasTotal5 = P004E8_A236VentasTotal5[0] ;
         n236VentasTotal5 = P004E8_n236VentasTotal5[0] ;
         A240VentasTotal = P004E8_A240VentasTotal[0] ;
         n240VentasTotal = P004E8_n240VentasTotal[0] ;
         A239VentasTotalExento = P004E8_A239VentasTotalExento[0] ;
         n239VentasTotalExento = P004E8_n239VentasTotalExento[0] ;
         A71TipoPagoNombre = P004E8_A71TipoPagoNombre[0] ;
         A125TimbradoNumero = P004E8_A125TimbradoNumero[0] ;
         A237VentasTotalIva10 = P004E8_A237VentasTotalIva10[0] ;
         n237VentasTotalIva10 = P004E8_n237VentasTotalIva10[0] ;
         A235VentasTotalIva5 = P004E8_A235VentasTotalIva5[0] ;
         n235VentasTotalIva5 = P004E8_n235VentasTotalIva5[0] ;
         A238VentasTotal10 = P004E8_A238VentasTotal10[0] ;
         n238VentasTotal10 = P004E8_n238VentasTotal10[0] ;
         A236VentasTotal5 = P004E8_A236VentasTotal5[0] ;
         n236VentasTotal5 = P004E8_n236VentasTotal5[0] ;
         A239VentasTotalExento = P004E8_A239VentasTotalExento[0] ;
         n239VentasTotalExento = P004E8_n239VentasTotalExento[0] ;
         A241VentasTotalIVA = P004E8_A241VentasTotalIVA[0] ;
         n241VentasTotalIVA = P004E8_n241VentasTotalIVA[0] ;
         A240VentasTotal = P004E8_A240VentasTotal[0] ;
         n240VentasTotal = P004E8_n240VentasTotal[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A19VentasId );
         GXt_dtime6 = GXutil.resetTime( A91VentasFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setNumber( A4ClienteId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( A251VentasPedido );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setNumber( A29TimbradoId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setNumber( A125TimbradoNumero );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setNumber( A309VentasSerie1 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setNumber( A310VentasSerie2 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setNumber( A311VentasNroFactura );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setNumber( A9TipoPagoId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A71TipoPagoNombre, GXv_char5) ;
         ventaswwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setNumber( A242VentasSerial );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A239VentasTotalExento)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+13, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A236VentasTotal5)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+14, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A238VentasTotal10)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+15, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A240VentasTotal)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+16, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A235VentasTotalIva5)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+17, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A237VentasTotalIva10)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+18, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A241VentasTotalIVA)) );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S181( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S191( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("VentasWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "VentasWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("VentasWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV28GXV1 = 1 ;
      while ( AV28GXV1 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV28GXV1));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV28GXV1 = (int)(AV28GXV1+1) ;
      }
   }

   public void S162( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S172( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = ventaswwexport.this.AV12Filename;
      this.aP1[0] = ventaswwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      AV9WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      GXv_exceldoc2 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int3 = new short[1] ;
      A91VentasFecha = GXutil.nullDate() ;
      A71TipoPagoNombre = "" ;
      A239VentasTotalExento = DecimalUtil.ZERO ;
      A236VentasTotal5 = DecimalUtil.ZERO ;
      A238VentasTotal10 = DecimalUtil.ZERO ;
      A240VentasTotal = DecimalUtil.ZERO ;
      A235VentasTotalIva5 = DecimalUtil.ZERO ;
      A237VentasTotalIva10 = DecimalUtil.ZERO ;
      A241VentasTotalIVA = DecimalUtil.ZERO ;
      AV27Ventaswwds_1_filterfulltext = "" ;
      lV27Ventaswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      P004E8_A237VentasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n237VentasTotalIva10 = new boolean[] {false} ;
      P004E8_A235VentasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n235VentasTotalIva5 = new boolean[] {false} ;
      P004E8_A242VentasSerial = new long[1] ;
      P004E8_A9TipoPagoId = new long[1] ;
      P004E8_A311VentasNroFactura = new long[1] ;
      P004E8_A310VentasSerie2 = new short[1] ;
      P004E8_A309VentasSerie1 = new short[1] ;
      P004E8_A125TimbradoNumero = new long[1] ;
      P004E8_A29TimbradoId = new long[1] ;
      P004E8_A251VentasPedido = new long[1] ;
      P004E8_A4ClienteId = new long[1] ;
      P004E8_A19VentasId = new long[1] ;
      P004E8_A71TipoPagoNombre = new String[] {""} ;
      P004E8_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004E8_A241VentasTotalIVA = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n241VentasTotalIVA = new boolean[] {false} ;
      P004E8_A238VentasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n238VentasTotal10 = new boolean[] {false} ;
      P004E8_A236VentasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n236VentasTotal5 = new boolean[] {false} ;
      P004E8_A240VentasTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n240VentasTotal = new boolean[] {false} ;
      P004E8_A239VentasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004E8_n239VentasTotalExento = new boolean[] {false} ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ventaswwexport__default(),
         new Object[] {
             new Object[] {
            P004E8_A237VentasTotalIva10, P004E8_n237VentasTotalIva10, P004E8_A235VentasTotalIva5, P004E8_n235VentasTotalIva5, P004E8_A242VentasSerial, P004E8_A9TipoPagoId, P004E8_A311VentasNroFactura, P004E8_A310VentasSerie2, P004E8_A309VentasSerie1, P004E8_A125TimbradoNumero,
            P004E8_A29TimbradoId, P004E8_A251VentasPedido, P004E8_A4ClienteId, P004E8_A19VentasId, P004E8_A71TipoPagoNombre, P004E8_A91VentasFecha, P004E8_A241VentasTotalIVA, P004E8_n241VentasTotalIVA, P004E8_A238VentasTotal10, P004E8_n238VentasTotal10,
            P004E8_A236VentasTotal5, P004E8_n236VentasTotal5, P004E8_A240VentasTotal, P004E8_n240VentasTotal, P004E8_A239VentasTotalExento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXv_int3[] ;
   private short A309VentasSerie1 ;
   private short A310VentasSerie2 ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV28GXV1 ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A251VentasPedido ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A311VentasNroFactura ;
   private long A9TipoPagoId ;
   private long A242VentasSerial ;
   private java.math.BigDecimal A239VentasTotalExento ;
   private java.math.BigDecimal A236VentasTotal5 ;
   private java.math.BigDecimal A238VentasTotal10 ;
   private java.math.BigDecimal A240VentasTotal ;
   private java.math.BigDecimal A235VentasTotalIva5 ;
   private java.math.BigDecimal A237VentasTotalIva10 ;
   private java.math.BigDecimal A241VentasTotalIVA ;
   private String A71TipoPagoNombre ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date A91VentasFecha ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n237VentasTotalIva10 ;
   private boolean n235VentasTotalIva5 ;
   private boolean n241VentasTotalIVA ;
   private boolean n238VentasTotal10 ;
   private boolean n236VentasTotal5 ;
   private boolean n240VentasTotal ;
   private boolean n239VentasTotalExento ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV27Ventaswwds_1_filterfulltext ;
   private String lV27Ventaswwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P004E8_A237VentasTotalIva10 ;
   private boolean[] P004E8_n237VentasTotalIva10 ;
   private java.math.BigDecimal[] P004E8_A235VentasTotalIva5 ;
   private boolean[] P004E8_n235VentasTotalIva5 ;
   private long[] P004E8_A242VentasSerial ;
   private long[] P004E8_A9TipoPagoId ;
   private long[] P004E8_A311VentasNroFactura ;
   private short[] P004E8_A310VentasSerie2 ;
   private short[] P004E8_A309VentasSerie1 ;
   private long[] P004E8_A125TimbradoNumero ;
   private long[] P004E8_A29TimbradoId ;
   private long[] P004E8_A251VentasPedido ;
   private long[] P004E8_A4ClienteId ;
   private long[] P004E8_A19VentasId ;
   private String[] P004E8_A71TipoPagoNombre ;
   private java.util.Date[] P004E8_A91VentasFecha ;
   private java.math.BigDecimal[] P004E8_A241VentasTotalIVA ;
   private boolean[] P004E8_n241VentasTotalIVA ;
   private java.math.BigDecimal[] P004E8_A238VentasTotal10 ;
   private boolean[] P004E8_n238VentasTotal10 ;
   private java.math.BigDecimal[] P004E8_A236VentasTotal5 ;
   private boolean[] P004E8_n236VentasTotal5 ;
   private java.math.BigDecimal[] P004E8_A240VentasTotal ;
   private boolean[] P004E8_n240VentasTotal ;
   private java.math.BigDecimal[] P004E8_A239VentasTotalExento ;
   private boolean[] P004E8_n239VentasTotalExento ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class ventaswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004E8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          String AV27Ventaswwds_1_filterfulltext ,
                                          long A19VentasId ,
                                          long A4ClienteId ,
                                          long A251VentasPedido ,
                                          long A29TimbradoId ,
                                          long A125TimbradoNumero ,
                                          short A309VentasSerie1 ,
                                          short A310VentasSerie2 ,
                                          long A311VentasNroFactura ,
                                          long A9TipoPagoId ,
                                          String A71TipoPagoNombre ,
                                          long A242VentasSerial ,
                                          java.math.BigDecimal A239VentasTotalExento ,
                                          java.math.BigDecimal A236VentasTotal5 ,
                                          java.math.BigDecimal A238VentasTotal10 ,
                                          java.math.BigDecimal A240VentasTotal ,
                                          java.math.BigDecimal A235VentasTotalIva5 ,
                                          java.math.BigDecimal A237VentasTotalIva10 ,
                                          java.math.BigDecimal A241VentasTotalIVA )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[19];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIva10, ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27," ;
      scmdbuf += " 10)) / 21, 0) AS VentasTotalIva5, T1.[VentasSerial], T1.[TipoPagoId], T1.[VentasNroFactura], T1.[VentasSerie2], T1.[VentasSerie1], T3.[TimbradoNumero], T1.[TimbradoId]," ;
      scmdbuf += " T1.[VentasPedido], T1.[ClienteId], T1.[VentasId], T2.[TipoPagoNombre], T1.[VentasFecha], COALESCE( T6.[VentasTotalIVA], 0) AS VentasTotalIVA, COALESCE( T5.[VentasTotal10]," ;
      scmdbuf += " 0) AS VentasTotal10, COALESCE( T5.[VentasTotal5], 0) AS VentasTotal5, COALESCE( T6.[VentasTotal], 0) AS VentasTotal, COALESCE( T5.[VentasTotalExento], 0) AS VentasTotalExento" ;
      scmdbuf += " FROM ((((([Ventas] T1 INNER JOIN [TipoPago] T2 ON T2.[TipoPagoId] = T1.[TipoPagoId]) INNER JOIN [Timbrado] T3 ON T3.[TimbradoId] = T1.[TimbradoId]) LEFT JOIN (SELECT" ;
      scmdbuf += " SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T7.[VentasId]" ;
      scmdbuf += " FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId] = T8.[ImpuestoId]) GROUP BY" ;
      scmdbuf += " T7.[VentasId] ) T4 ON T4.[VentasId] = T1.[VentasId]) LEFT JOIN (SELECT T7.[VentasId], SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 10 THEN T7.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T8.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 5 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T9.[ImpuestoPorcentaje] = 0 THEN T7.[VentasDetalleCantidad] * CAST(T8.[ArticuloPrecioVenta] AS decimal(" ;
      scmdbuf += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T7 INNER JOIN [Articulo] T8 ON T8.[ArticuloId] = T7.[ArticuloId]) INNER JOIN [Impuesto] T9 ON T9.[ImpuestoId]" ;
      scmdbuf += " = T8.[ImpuestoId]) GROUP BY T7.[VentasId] ) T5 ON T5.[VentasId] = T1.[VentasId]) INNER JOIN (SELECT COALESCE( T8.[VentasTotalExento], 0) + COALESCE( COALESCE( T9.[VentasTotal5]," ;
      scmdbuf += " 0), 0) + COALESCE( COALESCE( T10.[VentasTotal10], 0), 0) AS VentasTotal, T7.[VentasId], ROUND(CAST(( ( COALESCE( T9.[VentasTotal5], 0))) AS decimal( 27, 10)) /" ;
      scmdbuf += " 21, 0) + ROUND(CAST(( ( COALESCE( T10.[VentasTotal10], 0))) AS decimal( 27, 10)) / 11, 0) AS VentasTotalIVA FROM ((([Ventas] T7 LEFT JOIN (SELECT SUM(CASE  WHEN" ;
      scmdbuf += " T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotalExento, T11.[VentasId] FROM" ;
      scmdbuf += " (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP" ;
      scmdbuf += " BY T11.[VentasId] ) T8 ON T8.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT T11.[VentasId], SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 5 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta]" ;
      scmdbuf += " AS decimal( 27, 10)) END) AS VentasTotal5, SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 0 THEN T11.[VentasDetalleCantidad] * CAST(T12.[ArticuloPrecioVenta] AS decimal(" ;
      scmdbuf += " 27, 10)) END) AS VentasTotalExento FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId] = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId]" ;
      scmdbuf += " = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T9 ON T9.[VentasId] = T7.[VentasId]) LEFT JOIN (SELECT SUM(CASE  WHEN T13.[ImpuestoPorcentaje] = 10 THEN T11.[VentasDetalleCantidad]" ;
      scmdbuf += " * CAST(T12.[ArticuloPrecioVenta] AS decimal( 27, 10)) END) AS VentasTotal10, T11.[VentasId] FROM (([VentasDetalle] T11 INNER JOIN [Articulo] T12 ON T12.[ArticuloId]" ;
      scmdbuf += " = T11.[ArticuloId]) INNER JOIN [Impuesto] T13 ON T13.[ImpuestoId] = T12.[ImpuestoId]) GROUP BY T11.[VentasId] ) T10 ON T10.[VentasId] = T7.[VentasId]) ) T6 ON T6.[VentasId]" ;
      scmdbuf += " = T1.[VentasId])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(11), CAST(T1.[VentasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[VentasPedido] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TimbradoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T3.[TimbradoNumero] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie1] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(3), CAST(T1.[VentasSerie2] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(15), CAST(T1.[VentasNroFactura] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoPagoId] AS decimal(11,0))) like '%' + ?) or ( T2.[TipoPagoNombre] like '%' + ?) or ( CONVERT( char(10), CAST(T1.[VentasSerial] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotalExento], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T5.[VentasTotal10], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotal], 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T5.[VentasTotal5], 0) AS decimal( 27, 10)) / 21, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(ROUND(CAST(COALESCE( T4.[VentasTotal10], 0) AS decimal( 27, 10)) / 11, 0) AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T6.[VentasTotalIVA], 0) AS decimal(17,2))) like '%' + ?)))");
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasFecha]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClienteId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClienteId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasPedido]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasPedido] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TimbradoId]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TimbradoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[TimbradoNumero]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[TimbradoNumero] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie1]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie1] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie2]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasSerie2] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasNroFactura]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasNroFactura] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TipoPagoId]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TipoPagoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[TipoPagoNombre]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[TipoPagoNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasSerial]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasSerial] DESC" ;
      }
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P004E8(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).longValue() , ((Number) dynConstraints[7]).longValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).longValue() , ((Number) dynConstraints[11]).longValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).longValue() , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004E8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(3);
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((long[]) buf[9])[0] = rslt.getLong(8);
               ((long[]) buf[10])[0] = rslt.getLong(9);
               ((long[]) buf[11])[0] = rslt.getLong(10);
               ((long[]) buf[12])[0] = rslt.getLong(11);
               ((long[]) buf[13])[0] = rslt.getLong(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 80);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(14);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(15,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(16,2);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(17,2);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(18,2);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(19,2);
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
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[36], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[37], 100);
               }
               return;
      }
   }

}

