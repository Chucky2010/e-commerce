package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devolucioneswwexport extends GXProcedure
{
   public devolucioneswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devolucioneswwexport.class ), "" );
   }

   public devolucioneswwexport( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      devolucioneswwexport.this.aP1 = new String[] {""};
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
      devolucioneswwexport.this.aP0 = aP0;
      devolucioneswwexport.this.aP1 = aP1;
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
      AV12Filename = "DevolucionesWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         devolucioneswwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         devolucioneswwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( httpContext.getMessage( "ID", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Fecha", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Fecha", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Pago Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Devolucion ID", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "Devolucion Descripcion", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( httpContext.getMessage( "Observacion", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( httpContext.getMessage( "Total", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Devolucioneswwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Devolucioneswwds_1_filterfulltext ,
                                           Long.valueOf(A272DevolucionesID) ,
                                           Long.valueOf(A19VentasId) ,
                                           Long.valueOf(A4ClienteId) ,
                                           Long.valueOf(A9TipoPagoId) ,
                                           Long.valueOf(A273MotivoDevolucionID) ,
                                           A280MotivoDevolucionDescripcion ,
                                           A279DevolucionesObservacion ,
                                           A276DevolucionesTotal ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      lV27Devolucioneswwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Devolucioneswwds_1_filterfulltext), "%", "") ;
      /* Using cursor P006S3 */
      pr_default.execute(0, new Object[] {lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext, lV27Devolucioneswwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A273MotivoDevolucionID = P006S3_A273MotivoDevolucionID[0] ;
         A9TipoPagoId = P006S3_A9TipoPagoId[0] ;
         A4ClienteId = P006S3_A4ClienteId[0] ;
         A19VentasId = P006S3_A19VentasId[0] ;
         A272DevolucionesID = P006S3_A272DevolucionesID[0] ;
         A279DevolucionesObservacion = P006S3_A279DevolucionesObservacion[0] ;
         A280MotivoDevolucionDescripcion = P006S3_A280MotivoDevolucionDescripcion[0] ;
         A91VentasFecha = P006S3_A91VentasFecha[0] ;
         A275DevolucionesFecha = P006S3_A275DevolucionesFecha[0] ;
         A276DevolucionesTotal = P006S3_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = P006S3_n276DevolucionesTotal[0] ;
         A280MotivoDevolucionDescripcion = P006S3_A280MotivoDevolucionDescripcion[0] ;
         A9TipoPagoId = P006S3_A9TipoPagoId[0] ;
         A4ClienteId = P006S3_A4ClienteId[0] ;
         A91VentasFecha = P006S3_A91VentasFecha[0] ;
         A276DevolucionesTotal = P006S3_A276DevolucionesTotal[0] ;
         n276DevolucionesTotal = P006S3_n276DevolucionesTotal[0] ;
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
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A272DevolucionesID );
         GXt_dtime6 = GXutil.resetTime( A275DevolucionesFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( GXt_dtime6 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setNumber( A19VentasId );
         GXt_dtime6 = GXutil.resetTime( A91VentasFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setNumber( A4ClienteId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setNumber( A9TipoPagoId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setNumber( A273MotivoDevolucionID );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A280MotivoDevolucionDescripcion, GXv_char5) ;
         devolucioneswwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A279DevolucionesObservacion, 1, 1000), GXv_char5) ;
         devolucioneswwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A276DevolucionesTotal)) );
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
      if ( GXutil.strcmp(AV20Session.getValue("DevolucionesWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DevolucionesWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("DevolucionesWWGridState"), null, null);
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
      this.aP0[0] = devolucioneswwexport.this.AV12Filename;
      this.aP1[0] = devolucioneswwexport.this.AV13ErrorMessage;
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
      A275DevolucionesFecha = GXutil.nullDate() ;
      A91VentasFecha = GXutil.nullDate() ;
      A280MotivoDevolucionDescripcion = "" ;
      A279DevolucionesObservacion = "" ;
      A276DevolucionesTotal = DecimalUtil.ZERO ;
      AV27Devolucioneswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Devolucioneswwds_1_filterfulltext = "" ;
      P006S3_A273MotivoDevolucionID = new long[1] ;
      P006S3_A9TipoPagoId = new long[1] ;
      P006S3_A4ClienteId = new long[1] ;
      P006S3_A19VentasId = new long[1] ;
      P006S3_A272DevolucionesID = new long[1] ;
      P006S3_A279DevolucionesObservacion = new String[] {""} ;
      P006S3_A280MotivoDevolucionDescripcion = new String[] {""} ;
      P006S3_A91VentasFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006S3_A275DevolucionesFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006S3_A276DevolucionesTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006S3_n276DevolucionesTotal = new boolean[] {false} ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.devolucioneswwexport__default(),
         new Object[] {
             new Object[] {
            P006S3_A273MotivoDevolucionID, P006S3_A9TipoPagoId, P006S3_A4ClienteId, P006S3_A19VentasId, P006S3_A272DevolucionesID, P006S3_A279DevolucionesObservacion, P006S3_A280MotivoDevolucionDescripcion, P006S3_A91VentasFecha, P006S3_A275DevolucionesFecha, P006S3_A276DevolucionesTotal,
            P006S3_n276DevolucionesTotal
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
   private long A272DevolucionesID ;
   private long A19VentasId ;
   private long A4ClienteId ;
   private long A9TipoPagoId ;
   private long A273MotivoDevolucionID ;
   private java.math.BigDecimal A276DevolucionesTotal ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date A275DevolucionesFecha ;
   private java.util.Date A91VentasFecha ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private boolean n276DevolucionesTotal ;
   private String A279DevolucionesObservacion ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String A280MotivoDevolucionDescripcion ;
   private String AV27Devolucioneswwds_1_filterfulltext ;
   private String lV27Devolucioneswwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P006S3_A273MotivoDevolucionID ;
   private long[] P006S3_A9TipoPagoId ;
   private long[] P006S3_A4ClienteId ;
   private long[] P006S3_A19VentasId ;
   private long[] P006S3_A272DevolucionesID ;
   private String[] P006S3_A279DevolucionesObservacion ;
   private String[] P006S3_A280MotivoDevolucionDescripcion ;
   private java.util.Date[] P006S3_A91VentasFecha ;
   private java.util.Date[] P006S3_A275DevolucionesFecha ;
   private java.math.BigDecimal[] P006S3_A276DevolucionesTotal ;
   private boolean[] P006S3_n276DevolucionesTotal ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class devolucioneswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006S3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Devolucioneswwds_1_filterfulltext ,
                                          long A272DevolucionesID ,
                                          long A19VentasId ,
                                          long A4ClienteId ,
                                          long A9TipoPagoId ,
                                          long A273MotivoDevolucionID ,
                                          String A280MotivoDevolucionDescripcion ,
                                          String A279DevolucionesObservacion ,
                                          java.math.BigDecimal A276DevolucionesTotal ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[8];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.[MotivoDevolucionID], T3.[TipoPagoId], T3.[ClienteId], T1.[VentasId], T1.[DevolucionesID], T1.[DevolucionesObservacion], T2.[MotivoDevolucionDescripcion]," ;
      scmdbuf += " T3.[VentasFecha], T1.[DevolucionesFecha], COALESCE( T4.[DevolucionesTotal], 0) AS DevolucionesTotal FROM ((([Devoluciones] T1 INNER JOIN [MotivoDevolucion] T2 ON" ;
      scmdbuf += " T2.[MotivoDevolucionID] = T1.[MotivoDevolucionID]) INNER JOIN [Ventas] T3 ON T3.[VentasId] = T1.[VentasId]) LEFT JOIN (SELECT SUM(T6.[ArticuloPrecioVenta] * CAST(T5.[DevolucionesDetalleCant]" ;
      scmdbuf += " AS decimal( 27, 10))) AS DevolucionesTotal, T5.[DevolucionesID] FROM ([DevolucionesDetalle] T5 INNER JOIN [Articulo] T6 ON T6.[ArticuloId] = T5.[ArticuloId]) GROUP" ;
      scmdbuf += " BY T5.[DevolucionesID] ) T4 ON T4.[DevolucionesID] = T1.[DevolucionesID])" ;
      if ( ! (GXutil.strcmp("", AV27Devolucioneswwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(10), CAST(T1.[DevolucionesID] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[VentasId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T3.[TipoPagoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T1.[MotivoDevolucionID] AS decimal(10,0))) like '%' + ?) or ( T2.[MotivoDevolucionDescripcion] like '%' + ?) or ( T1.[DevolucionesObservacion] like '%' + ?) or ( CONVERT( char(17), CAST(COALESCE( T4.[DevolucionesTotal], 0) AS decimal(17,2))) like '%' + ?))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
         GXv_int7[1] = (byte)(1) ;
         GXv_int7[2] = (byte)(1) ;
         GXv_int7[3] = (byte)(1) ;
         GXv_int7[4] = (byte)(1) ;
         GXv_int7[5] = (byte)(1) ;
         GXv_int7[6] = (byte)(1) ;
         GXv_int7[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesID]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesID] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesFecha]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[VentasId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[VentasId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[VentasFecha]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[VentasFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[ClienteId]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[ClienteId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[TipoPagoId]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[TipoPagoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MotivoDevolucionID]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MotivoDevolucionID] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[MotivoDevolucionDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[MotivoDevolucionDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesObservacion]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DevolucionesObservacion] DESC" ;
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
                  return conditional_P006S3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Boolean) dynConstraints[10]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006S3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               return;
      }
   }

}

