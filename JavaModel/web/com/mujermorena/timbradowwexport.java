package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class timbradowwexport extends GXProcedure
{
   public timbradowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( timbradowwexport.class ), "" );
   }

   public timbradowwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      timbradowwexport.this.aP1 = new String[] {""};
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
      timbradowwexport.this.aP0 = aP0;
      timbradowwexport.this.aP1 = aP1;
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
      AV12Filename = "TimbradoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         timbradowwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         timbradowwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Numero", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Inicio Vigencia", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Fin Vigencia", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Nro Factura", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Factura Inicial", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Factura Final", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "Factura Serie1", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( httpContext.getMessage( "Factura Serie2", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( httpContext.getMessage( "Estado", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Timbradowwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Timbradowwds_1_filterfulltext ,
                                           Long.valueOf(A29TimbradoId) ,
                                           Long.valueOf(A125TimbradoNumero) ,
                                           Long.valueOf(A128TimbradoNroFactura) ,
                                           Long.valueOf(A304TimbradoNroFacturaInicial) ,
                                           Long.valueOf(A305TimbradoNroFacturaFinal) ,
                                           Short.valueOf(A306TimbradoNroFacturaSerie1) ,
                                           Short.valueOf(A307TimbradoNroFacturaSerie2) ,
                                           A308TimbradoEstado ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN
                                           }
      });
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      lV27Timbradowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Timbradowwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004W2 */
      pr_default.execute(0, new Object[] {lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext, lV27Timbradowwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A307TimbradoNroFacturaSerie2 = P004W2_A307TimbradoNroFacturaSerie2[0] ;
         A306TimbradoNroFacturaSerie1 = P004W2_A306TimbradoNroFacturaSerie1[0] ;
         A305TimbradoNroFacturaFinal = P004W2_A305TimbradoNroFacturaFinal[0] ;
         A304TimbradoNroFacturaInicial = P004W2_A304TimbradoNroFacturaInicial[0] ;
         A128TimbradoNroFactura = P004W2_A128TimbradoNroFactura[0] ;
         A125TimbradoNumero = P004W2_A125TimbradoNumero[0] ;
         A29TimbradoId = P004W2_A29TimbradoId[0] ;
         A308TimbradoEstado = P004W2_A308TimbradoEstado[0] ;
         A127TimbradoFinVigencia = P004W2_A127TimbradoFinVigencia[0] ;
         A126TimbradoInicioVigencia = P004W2_A126TimbradoInicioVigencia[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A29TimbradoId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( A125TimbradoNumero );
         GXt_dtime6 = GXutil.resetTime( A126TimbradoInicioVigencia );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setDate( GXt_dtime6 );
         GXt_dtime6 = GXutil.resetTime( A127TimbradoFinVigencia );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( GXt_dtime6 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setNumber( A128TimbradoNroFactura );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setNumber( A304TimbradoNroFacturaInicial );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setNumber( A305TimbradoNroFacturaFinal );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setNumber( A306TimbradoNroFacturaSerie1 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setNumber( A307TimbradoNroFacturaSerie2 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A308TimbradoEstado, GXv_char5) ;
         timbradowwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( GXt_char4 );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
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
      if ( GXutil.strcmp(AV20Session.getValue("TimbradoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TimbradoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("TimbradoWWGridState"), null, null);
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
      this.aP0[0] = timbradowwexport.this.AV12Filename;
      this.aP1[0] = timbradowwexport.this.AV13ErrorMessage;
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
      A126TimbradoInicioVigencia = GXutil.nullDate() ;
      A127TimbradoFinVigencia = GXutil.nullDate() ;
      A308TimbradoEstado = "" ;
      AV27Timbradowwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Timbradowwds_1_filterfulltext = "" ;
      P004W2_A307TimbradoNroFacturaSerie2 = new short[1] ;
      P004W2_A306TimbradoNroFacturaSerie1 = new short[1] ;
      P004W2_A305TimbradoNroFacturaFinal = new long[1] ;
      P004W2_A304TimbradoNroFacturaInicial = new long[1] ;
      P004W2_A128TimbradoNroFactura = new long[1] ;
      P004W2_A125TimbradoNumero = new long[1] ;
      P004W2_A29TimbradoId = new long[1] ;
      P004W2_A308TimbradoEstado = new String[] {""} ;
      P004W2_A127TimbradoFinVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P004W2_A126TimbradoInicioVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.timbradowwexport__default(),
         new Object[] {
             new Object[] {
            P004W2_A307TimbradoNroFacturaSerie2, P004W2_A306TimbradoNroFacturaSerie1, P004W2_A305TimbradoNroFacturaFinal, P004W2_A304TimbradoNroFacturaInicial, P004W2_A128TimbradoNroFactura, P004W2_A125TimbradoNumero, P004W2_A29TimbradoId, P004W2_A308TimbradoEstado, P004W2_A127TimbradoFinVigencia, P004W2_A126TimbradoInicioVigencia
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXv_int3[] ;
   private short A306TimbradoNroFacturaSerie1 ;
   private short A307TimbradoNroFacturaSerie2 ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV28GXV1 ;
   private long A29TimbradoId ;
   private long A125TimbradoNumero ;
   private long A128TimbradoNroFactura ;
   private long A304TimbradoNroFacturaInicial ;
   private long A305TimbradoNroFacturaFinal ;
   private String A308TimbradoEstado ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date A126TimbradoInicioVigencia ;
   private java.util.Date A127TimbradoFinVigencia ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV27Timbradowwds_1_filterfulltext ;
   private String lV27Timbradowwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P004W2_A307TimbradoNroFacturaSerie2 ;
   private short[] P004W2_A306TimbradoNroFacturaSerie1 ;
   private long[] P004W2_A305TimbradoNroFacturaFinal ;
   private long[] P004W2_A304TimbradoNroFacturaInicial ;
   private long[] P004W2_A128TimbradoNroFactura ;
   private long[] P004W2_A125TimbradoNumero ;
   private long[] P004W2_A29TimbradoId ;
   private String[] P004W2_A308TimbradoEstado ;
   private java.util.Date[] P004W2_A127TimbradoFinVigencia ;
   private java.util.Date[] P004W2_A126TimbradoInicioVigencia ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class timbradowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Timbradowwds_1_filterfulltext ,
                                          long A29TimbradoId ,
                                          long A125TimbradoNumero ,
                                          long A128TimbradoNroFactura ,
                                          long A304TimbradoNroFacturaInicial ,
                                          long A305TimbradoNroFacturaFinal ,
                                          short A306TimbradoNroFacturaSerie1 ,
                                          short A307TimbradoNroFacturaSerie2 ,
                                          String A308TimbradoEstado ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[8];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT [TimbradoNroFacturaSerie2], [TimbradoNroFacturaSerie1], [TimbradoNroFacturaFinal], [TimbradoNroFacturaInicial], [TimbradoNroFactura], [TimbradoNumero], [TimbradoId]," ;
      scmdbuf += " [TimbradoEstado], [TimbradoFinVigencia], [TimbradoInicioVigencia] FROM [Timbrado]" ;
      if ( ! (GXutil.strcmp("", AV27Timbradowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST([TimbradoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST([TimbradoNumero] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(15), CAST([TimbradoNroFactura] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(15), CAST([TimbradoNroFacturaInicial] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(15), CAST([TimbradoNroFacturaFinal] AS decimal(15,0))) like '%' + ?) or ( CONVERT( char(3), CAST([TimbradoNroFacturaSerie1] AS decimal(3,0))) like '%' + ?) or ( CONVERT( char(3), CAST([TimbradoNroFacturaSerie2] AS decimal(3,0))) like '%' + ?) or ( [TimbradoEstado] like '%' + ?))");
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
         scmdbuf += " ORDER BY [TimbradoId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoNumero]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoNumero] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoInicioVigencia]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoInicioVigencia] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoFinVigencia]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoFinVigencia] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoNroFactura]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoNroFactura] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaInicial]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaInicial] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaFinal]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaFinal] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaSerie1]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaSerie1] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaSerie2]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoNroFacturaSerie2] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [TimbradoEstado]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [TimbradoEstado] DESC" ;
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
                  return conditional_P004W2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).longValue() , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , ((Boolean) dynConstraints[10]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
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

