package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class compraswwexport extends GXProcedure
{
   public compraswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( compraswwexport.class ), "" );
   }

   public compraswwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      compraswwexport.this.aP1 = new String[] {""};
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
      compraswwexport.this.aP0 = aP0;
      compraswwexport.this.aP1 = aP1;
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
      AV12Filename = "ComprasWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         compraswwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         compraswwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Compras Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Fecha", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Proveedor Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Timbrado", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Numero Factura", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Total Exento", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Total Iva5", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "Total Iva10", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( httpContext.getMessage( "Total", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( httpContext.getMessage( "Total5", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setText( httpContext.getMessage( "Total10", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setText( httpContext.getMessage( "Total Iva", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Compraswwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           AV27Compraswwds_1_filterfulltext ,
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
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      lV27Compraswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Compraswwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004C7 */
      pr_default.execute(0, new Object[] {AV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext, lV27Compraswwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A88ComprasTotal10 = P004C7_A88ComprasTotal10[0] ;
         A86ComprasTotal5 = P004C7_A86ComprasTotal5[0] ;
         A227ComprasNumeroFactura = P004C7_A227ComprasNumeroFactura[0] ;
         A226ComprasTimbrado = P004C7_A226ComprasTimbrado[0] ;
         A10ProveedorId = P004C7_A10ProveedorId[0] ;
         A11ComprasId = P004C7_A11ComprasId[0] ;
         A74ComprasFecha = P004C7_A74ComprasFecha[0] ;
         A225ComprasTotalIva = P004C7_A225ComprasTotalIva[0] ;
         n225ComprasTotalIva = P004C7_n225ComprasTotalIva[0] ;
         A89ComprasTotalIva10 = P004C7_A89ComprasTotalIva10[0] ;
         A87ComprasTotalIva5 = P004C7_A87ComprasTotalIva5[0] ;
         A229ComprasTotal = P004C7_A229ComprasTotal[0] ;
         n229ComprasTotal = P004C7_n229ComprasTotal[0] ;
         A90ComprasTotalExento = P004C7_A90ComprasTotalExento[0] ;
         A88ComprasTotal10 = P004C7_A88ComprasTotal10[0] ;
         A86ComprasTotal5 = P004C7_A86ComprasTotal5[0] ;
         A225ComprasTotalIva = P004C7_A225ComprasTotalIva[0] ;
         n225ComprasTotalIva = P004C7_n225ComprasTotalIva[0] ;
         A229ComprasTotal = P004C7_A229ComprasTotal[0] ;
         n229ComprasTotal = P004C7_n229ComprasTotal[0] ;
         A89ComprasTotalIva10 = P004C7_A89ComprasTotalIva10[0] ;
         A87ComprasTotalIva5 = P004C7_A87ComprasTotalIva5[0] ;
         A90ComprasTotalExento = P004C7_A90ComprasTotalExento[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A11ComprasId );
         GXt_dtime6 = GXutil.resetTime( A74ComprasFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setNumber( A10ProveedorId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( A226ComprasTimbrado );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setNumber( A227ComprasNumeroFactura );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A90ComprasTotalExento)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A87ComprasTotalIva5)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A89ComprasTotalIva10)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A229ComprasTotal)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A86ComprasTotal5)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A88ComprasTotal10)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A225ComprasTotalIva)) );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
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
      if ( GXutil.strcmp(AV20Session.getValue("ComprasWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ComprasWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ComprasWWGridState"), null, null);
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
      this.aP0[0] = compraswwexport.this.AV12Filename;
      this.aP1[0] = compraswwexport.this.AV13ErrorMessage;
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
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      A74ComprasFecha = GXutil.nullDate() ;
      A90ComprasTotalExento = DecimalUtil.ZERO ;
      A87ComprasTotalIva5 = DecimalUtil.ZERO ;
      A89ComprasTotalIva10 = DecimalUtil.ZERO ;
      A229ComprasTotal = DecimalUtil.ZERO ;
      A86ComprasTotal5 = DecimalUtil.ZERO ;
      A88ComprasTotal10 = DecimalUtil.ZERO ;
      A225ComprasTotalIva = DecimalUtil.ZERO ;
      AV27Compraswwds_1_filterfulltext = "" ;
      lV27Compraswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      P004C7_A88ComprasTotal10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004C7_A86ComprasTotal5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004C7_A227ComprasNumeroFactura = new long[1] ;
      P004C7_A226ComprasTimbrado = new long[1] ;
      P004C7_A10ProveedorId = new long[1] ;
      P004C7_A11ComprasId = new long[1] ;
      P004C7_A74ComprasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004C7_A225ComprasTotalIva = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004C7_n225ComprasTotalIva = new boolean[] {false} ;
      P004C7_A89ComprasTotalIva10 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004C7_A87ComprasTotalIva5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004C7_A229ComprasTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004C7_n229ComprasTotal = new boolean[] {false} ;
      P004C7_A90ComprasTotalExento = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.compraswwexport__default(),
         new Object[] {
             new Object[] {
            P004C7_A88ComprasTotal10, P004C7_A86ComprasTotal5, P004C7_A227ComprasNumeroFactura, P004C7_A226ComprasTimbrado, P004C7_A10ProveedorId, P004C7_A11ComprasId, P004C7_A74ComprasFecha, P004C7_A225ComprasTotalIva, P004C7_n225ComprasTotalIva, P004C7_A89ComprasTotalIva10,
            P004C7_A87ComprasTotalIva5, P004C7_A229ComprasTotal, P004C7_n229ComprasTotal, P004C7_A90ComprasTotalExento
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXv_int3[] ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV28GXV1 ;
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
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String scmdbuf ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date A74ComprasFecha ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n225ComprasTotalIva ;
   private boolean n229ComprasTotal ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV27Compraswwds_1_filterfulltext ;
   private String lV27Compraswwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P004C7_A88ComprasTotal10 ;
   private java.math.BigDecimal[] P004C7_A86ComprasTotal5 ;
   private long[] P004C7_A227ComprasNumeroFactura ;
   private long[] P004C7_A226ComprasTimbrado ;
   private long[] P004C7_A10ProveedorId ;
   private long[] P004C7_A11ComprasId ;
   private java.util.Date[] P004C7_A74ComprasFecha ;
   private java.math.BigDecimal[] P004C7_A225ComprasTotalIva ;
   private boolean[] P004C7_n225ComprasTotalIva ;
   private java.math.BigDecimal[] P004C7_A89ComprasTotalIva10 ;
   private java.math.BigDecimal[] P004C7_A87ComprasTotalIva5 ;
   private java.math.BigDecimal[] P004C7_A229ComprasTotal ;
   private boolean[] P004C7_n229ComprasTotal ;
   private java.math.BigDecimal[] P004C7_A90ComprasTotalExento ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class compraswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004C7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          String AV27Compraswwds_1_filterfulltext ,
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
      byte[] GXv_int7 = new byte[12];
      Object[] GXv_Object8 = new Object[2];
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
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasFecha]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ProveedorId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ProveedorId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasTimbrado]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasTimbrado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ComprasNumeroFactura]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ComprasNumeroFactura] DESC" ;
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
                  return conditional_P004C7(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).longValue() , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004C7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

