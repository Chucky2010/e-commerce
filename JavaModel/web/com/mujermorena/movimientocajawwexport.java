package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class movimientocajawwexport extends GXProcedure
{
   public movimientocajawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( movimientocajawwexport.class ), "" );
   }

   public movimientocajawwexport( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      movimientocajawwexport.this.aP1 = new String[] {""};
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
      movimientocajawwexport.this.aP0 = aP0;
      movimientocajawwexport.this.aP1 = aP1;
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
      AV12Filename = "MovimientoCajaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         movimientocajawwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         movimientocajawwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Caja Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Caja Hora", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Caja Ingreso", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Caja Egreso", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Caja Saldo", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Caja Fecha", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Informacion", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( httpContext.getMessage( "Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setText( httpContext.getMessage( "Numero", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setText( httpContext.getMessage( "Caja Asignacion", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setText( httpContext.getMessage( "Caja Estado", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Movimientocajawwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Movimientocajawwds_1_filterfulltext ,
                                           Long.valueOf(A27MovimientoCajaId) ,
                                           A117MovimientoCajaIngreso ,
                                           A118MovimientoCajaEgreso ,
                                           A119MovimientoCajaSaldo ,
                                           A266MovimientoCajaDocum ,
                                           Long.valueOf(A26CajeroId) ,
                                           A112CajeroNombre ,
                                           Long.valueOf(A25CajaId) ,
                                           Long.valueOf(A110CajaNumero) ,
                                           A256MovimientoCajaAsignacion ,
                                           A267MovimientoCajaEstado ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      lV27Movimientocajawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Movimientocajawwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004S2 */
      pr_default.execute(0, new Object[] {lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext, lV27Movimientocajawwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A110CajaNumero = P004S2_A110CajaNumero[0] ;
         A25CajaId = P004S2_A25CajaId[0] ;
         A26CajeroId = P004S2_A26CajeroId[0] ;
         A119MovimientoCajaSaldo = P004S2_A119MovimientoCajaSaldo[0] ;
         A118MovimientoCajaEgreso = P004S2_A118MovimientoCajaEgreso[0] ;
         A117MovimientoCajaIngreso = P004S2_A117MovimientoCajaIngreso[0] ;
         A27MovimientoCajaId = P004S2_A27MovimientoCajaId[0] ;
         A267MovimientoCajaEstado = P004S2_A267MovimientoCajaEstado[0] ;
         A256MovimientoCajaAsignacion = P004S2_A256MovimientoCajaAsignacion[0] ;
         A112CajeroNombre = P004S2_A112CajeroNombre[0] ;
         A266MovimientoCajaDocum = P004S2_A266MovimientoCajaDocum[0] ;
         A120MovimientoCajaFecha = P004S2_A120MovimientoCajaFecha[0] ;
         A116MovimientoCajaHora = P004S2_A116MovimientoCajaHora[0] ;
         A110CajaNumero = P004S2_A110CajaNumero[0] ;
         A112CajeroNombre = P004S2_A112CajeroNombre[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A27MovimientoCajaId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( localUtil.format( A116MovimientoCajaHora, "99:99") );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A117MovimientoCajaIngreso)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A118MovimientoCajaEgreso)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A119MovimientoCajaSaldo)) );
         GXt_dtime6 = GXutil.resetTime( A120MovimientoCajaFecha );
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setDate( GXt_dtime6 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A266MovimientoCajaDocum, GXv_char5) ;
         movimientocajawwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setNumber( A26CajeroId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A112CajeroNombre, GXv_char5) ;
         movimientocajawwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setNumber( A25CajaId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setNumber( A110CajaNumero );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A256MovimientoCajaAsignacion, GXv_char5) ;
         movimientocajawwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A267MovimientoCajaEstado, GXv_char5) ;
         movimientocajawwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setText( GXt_char4 );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
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
      if ( GXutil.strcmp(AV20Session.getValue("MovimientoCajaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MovimientoCajaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("MovimientoCajaWWGridState"), null, null);
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
      this.aP0[0] = movimientocajawwexport.this.AV12Filename;
      this.aP1[0] = movimientocajawwexport.this.AV13ErrorMessage;
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
      A116MovimientoCajaHora = GXutil.resetTime( GXutil.nullDate() );
      A117MovimientoCajaIngreso = DecimalUtil.ZERO ;
      A118MovimientoCajaEgreso = DecimalUtil.ZERO ;
      A119MovimientoCajaSaldo = DecimalUtil.ZERO ;
      A120MovimientoCajaFecha = GXutil.nullDate() ;
      A266MovimientoCajaDocum = "" ;
      A112CajeroNombre = "" ;
      A256MovimientoCajaAsignacion = "" ;
      A267MovimientoCajaEstado = "" ;
      AV27Movimientocajawwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Movimientocajawwds_1_filterfulltext = "" ;
      P004S2_A110CajaNumero = new long[1] ;
      P004S2_A25CajaId = new long[1] ;
      P004S2_A26CajeroId = new long[1] ;
      P004S2_A119MovimientoCajaSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004S2_A118MovimientoCajaEgreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004S2_A117MovimientoCajaIngreso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004S2_A27MovimientoCajaId = new long[1] ;
      P004S2_A267MovimientoCajaEstado = new String[] {""} ;
      P004S2_A256MovimientoCajaAsignacion = new String[] {""} ;
      P004S2_A112CajeroNombre = new String[] {""} ;
      P004S2_A266MovimientoCajaDocum = new String[] {""} ;
      P004S2_A120MovimientoCajaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P004S2_A116MovimientoCajaHora = new java.util.Date[] {GXutil.nullDate()} ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.movimientocajawwexport__default(),
         new Object[] {
             new Object[] {
            P004S2_A110CajaNumero, P004S2_A25CajaId, P004S2_A26CajeroId, P004S2_A119MovimientoCajaSaldo, P004S2_A118MovimientoCajaEgreso, P004S2_A117MovimientoCajaIngreso, P004S2_A27MovimientoCajaId, P004S2_A267MovimientoCajaEstado, P004S2_A256MovimientoCajaAsignacion, P004S2_A112CajeroNombre,
            P004S2_A266MovimientoCajaDocum, P004S2_A120MovimientoCajaFecha, P004S2_A116MovimientoCajaHora
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
   private long A27MovimientoCajaId ;
   private long A26CajeroId ;
   private long A25CajaId ;
   private long A110CajaNumero ;
   private java.math.BigDecimal A117MovimientoCajaIngreso ;
   private java.math.BigDecimal A118MovimientoCajaEgreso ;
   private java.math.BigDecimal A119MovimientoCajaSaldo ;
   private String A112CajeroNombre ;
   private String A256MovimientoCajaAsignacion ;
   private String A267MovimientoCajaEstado ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private java.util.Date A116MovimientoCajaHora ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date A120MovimientoCajaFecha ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String A266MovimientoCajaDocum ;
   private String AV27Movimientocajawwds_1_filterfulltext ;
   private String lV27Movimientocajawwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P004S2_A110CajaNumero ;
   private long[] P004S2_A25CajaId ;
   private long[] P004S2_A26CajeroId ;
   private java.math.BigDecimal[] P004S2_A119MovimientoCajaSaldo ;
   private java.math.BigDecimal[] P004S2_A118MovimientoCajaEgreso ;
   private java.math.BigDecimal[] P004S2_A117MovimientoCajaIngreso ;
   private long[] P004S2_A27MovimientoCajaId ;
   private String[] P004S2_A267MovimientoCajaEstado ;
   private String[] P004S2_A256MovimientoCajaAsignacion ;
   private String[] P004S2_A112CajeroNombre ;
   private String[] P004S2_A266MovimientoCajaDocum ;
   private java.util.Date[] P004S2_A120MovimientoCajaFecha ;
   private java.util.Date[] P004S2_A116MovimientoCajaHora ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class movimientocajawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004S2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Movimientocajawwds_1_filterfulltext ,
                                          long A27MovimientoCajaId ,
                                          java.math.BigDecimal A117MovimientoCajaIngreso ,
                                          java.math.BigDecimal A118MovimientoCajaEgreso ,
                                          java.math.BigDecimal A119MovimientoCajaSaldo ,
                                          String A266MovimientoCajaDocum ,
                                          long A26CajeroId ,
                                          String A112CajeroNombre ,
                                          long A25CajaId ,
                                          long A110CajaNumero ,
                                          String A256MovimientoCajaAsignacion ,
                                          String A267MovimientoCajaEstado ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[11];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T2.[CajaNumero], T1.[CajaId], T1.[CajeroId], T1.[MovimientoCajaSaldo], T1.[MovimientoCajaEgreso], T1.[MovimientoCajaIngreso], T1.[MovimientoCajaId], T1.[MovimientoCajaEstado]," ;
      scmdbuf += " T1.[MovimientoCajaAsignacion], T3.[CajeroNombre], T1.[MovimientoCajaDocum], T1.[MovimientoCajaFecha], T1.[MovimientoCajaHora] FROM (([MovimientoCaja] T1 INNER JOIN" ;
      scmdbuf += " [Caja] T2 ON T2.[CajaId] = T1.[CajaId]) INNER JOIN [Cajero] T3 ON T3.[CajeroId] = T1.[CajeroId])" ;
      if ( ! (GXutil.strcmp("", AV27Movimientocajawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[MovimientoCajaId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[MovimientoCajaIngreso] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[MovimientoCajaEgreso] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[MovimientoCajaSaldo] AS decimal(17,2))) like '%' + ?) or ( T1.[MovimientoCajaDocum] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[CajeroId] AS decimal(11,0))) like '%' + ?) or ( T3.[CajeroNombre] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[CajaId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(10), CAST(T2.[CajaNumero] AS decimal(10,0))) like '%' + ?) or ( T1.[MovimientoCajaAsignacion] like '%' + ?) or ( T1.[MovimientoCajaEstado] like '%' + ?))");
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
         GXv_int7[8] = (byte)(1) ;
         GXv_int7[9] = (byte)(1) ;
         GXv_int7[10] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaHora]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaHora] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaIngreso]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaIngreso] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEgreso]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEgreso] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaSaldo]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaSaldo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaFecha]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaFecha] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaDocum]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaDocum] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CajeroId]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CajeroId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[CajeroNombre]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[CajeroNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CajaId]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CajaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[CajaNumero]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[CajaNumero] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaAsignacion]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaAsignacion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEstado]" ;
      }
      else if ( ( AV17OrderedBy == 13 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[MovimientoCajaEstado] DESC" ;
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
                  return conditional_P004S2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (java.math.BigDecimal)dynConstraints[2] , (java.math.BigDecimal)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).longValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).longValue() , ((Number) dynConstraints[9]).longValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004S2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getString(10, 80);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((java.util.Date[]) buf[11])[0] = rslt.getGXDate(12);
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(13));
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
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 100);
               }
               return;
      }
   }

}

