package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class articulowwexport extends GXProcedure
{
   public articulowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( articulowwexport.class ), "" );
   }

   public articulowwexport( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      articulowwexport.this.aP1 = new String[] {""};
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
      articulowwexport.this.aP0 = aP0;
      articulowwexport.this.aP1 = aP1;
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
      AV12Filename = "ArticuloWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         articulowwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         articulowwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Descripcion Corta", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Descripcion Larga", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Precio Compra", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Precio Venta", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Precio Promedio", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "Stock", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setText( httpContext.getMessage( "Articulo Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( httpContext.getMessage( "Articulo Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setText( httpContext.getMessage( "Porcentaje", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setText( httpContext.getMessage( "Imagen", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Articulowwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Articulowwds_1_filterfulltext ,
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
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.LONG, TypeConstants.STRING,
                                           TypeConstants.LONG, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      lV27Articulowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Articulowwds_1_filterfulltext), "%", "") ;
      /* Using cursor P00482 */
      pr_default.execute(0, new Object[] {lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext, lV27Articulowwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A83ImpuestoPorcentaje = P00482_A83ImpuestoPorcentaje[0] ;
         A18ImpuestoId = P00482_A18ImpuestoId[0] ;
         A17TipoArticuloId = P00482_A17TipoArticuloId[0] ;
         A79ArticuloStock = P00482_A79ArticuloStock[0] ;
         A222ArticuloPrecioPromedio = P00482_A222ArticuloPrecioPromedio[0] ;
         A78ArticuloPrecioVenta = P00482_A78ArticuloPrecioVenta[0] ;
         A77ArticuloPrecioCompra = P00482_A77ArticuloPrecioCompra[0] ;
         A13ArticuloId = P00482_A13ArticuloId[0] ;
         A103TipoArticuloNombre = P00482_A103TipoArticuloNombre[0] ;
         A215ArticuloDescripcionLarga = P00482_A215ArticuloDescripcionLarga[0] ;
         A214ArticuloDescripcionCorta = P00482_A214ArticuloDescripcionCorta[0] ;
         A76ArticuloNombre = P00482_A76ArticuloNombre[0] ;
         A83ImpuestoPorcentaje = P00482_A83ImpuestoPorcentaje[0] ;
         A103TipoArticuloNombre = P00482_A103TipoArticuloNombre[0] ;
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
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A13ArticuloId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A76ArticuloNombre, GXv_char5) ;
         articulowwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A214ArticuloDescripcionCorta, GXv_char5) ;
         articulowwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( GXutil.substring( A215ArticuloDescripcionLarga, 1, 1000), GXv_char5) ;
         articulowwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A77ArticuloPrecioCompra)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A78ArticuloPrecioVenta)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A222ArticuloPrecioPromedio)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setNumber( A79ArticuloStock );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+8, 1, 1).setNumber( A17TipoArticuloId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A103TipoArticuloNombre, GXv_char5) ;
         articulowwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+9, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+10, 1, 1).setNumber( A18ImpuestoId );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+11, 1, 1).setNumber( (double)(DecimalUtil.decToDouble(A83ImpuestoPorcentaje)) );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+12, 1, 1).setText( "" );
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
      if ( GXutil.strcmp(AV20Session.getValue("ArticuloWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ArticuloWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ArticuloWWGridState"), null, null);
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
      this.aP0[0] = articulowwexport.this.AV12Filename;
      this.aP1[0] = articulowwexport.this.AV13ErrorMessage;
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
      A76ArticuloNombre = "" ;
      A214ArticuloDescripcionCorta = "" ;
      A215ArticuloDescripcionLarga = "" ;
      A77ArticuloPrecioCompra = DecimalUtil.ZERO ;
      A78ArticuloPrecioVenta = DecimalUtil.ZERO ;
      A222ArticuloPrecioPromedio = DecimalUtil.ZERO ;
      A103TipoArticuloNombre = "" ;
      A83ImpuestoPorcentaje = DecimalUtil.ZERO ;
      AV27Articulowwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Articulowwds_1_filterfulltext = "" ;
      P00482_A83ImpuestoPorcentaje = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00482_A18ImpuestoId = new long[1] ;
      P00482_A17TipoArticuloId = new long[1] ;
      P00482_A79ArticuloStock = new long[1] ;
      P00482_A222ArticuloPrecioPromedio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00482_A78ArticuloPrecioVenta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00482_A77ArticuloPrecioCompra = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00482_A13ArticuloId = new long[1] ;
      P00482_A103TipoArticuloNombre = new String[] {""} ;
      P00482_A215ArticuloDescripcionLarga = new String[] {""} ;
      P00482_A214ArticuloDescripcionCorta = new String[] {""} ;
      P00482_A76ArticuloNombre = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.articulowwexport__default(),
         new Object[] {
             new Object[] {
            P00482_A83ImpuestoPorcentaje, P00482_A18ImpuestoId, P00482_A17TipoArticuloId, P00482_A79ArticuloStock, P00482_A222ArticuloPrecioPromedio, P00482_A78ArticuloPrecioVenta, P00482_A77ArticuloPrecioCompra, P00482_A13ArticuloId, P00482_A103TipoArticuloNombre, P00482_A215ArticuloDescripcionLarga,
            P00482_A214ArticuloDescripcionCorta, P00482_A76ArticuloNombre
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
   private long A13ArticuloId ;
   private long A79ArticuloStock ;
   private long A17TipoArticuloId ;
   private long A18ImpuestoId ;
   private java.math.BigDecimal A77ArticuloPrecioCompra ;
   private java.math.BigDecimal A78ArticuloPrecioVenta ;
   private java.math.BigDecimal A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal A83ImpuestoPorcentaje ;
   private String A76ArticuloNombre ;
   private String A103TipoArticuloNombre ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String A215ArticuloDescripcionLarga ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String A214ArticuloDescripcionCorta ;
   private String AV27Articulowwds_1_filterfulltext ;
   private String lV27Articulowwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P00482_A83ImpuestoPorcentaje ;
   private long[] P00482_A18ImpuestoId ;
   private long[] P00482_A17TipoArticuloId ;
   private long[] P00482_A79ArticuloStock ;
   private java.math.BigDecimal[] P00482_A222ArticuloPrecioPromedio ;
   private java.math.BigDecimal[] P00482_A78ArticuloPrecioVenta ;
   private java.math.BigDecimal[] P00482_A77ArticuloPrecioCompra ;
   private long[] P00482_A13ArticuloId ;
   private String[] P00482_A103TipoArticuloNombre ;
   private String[] P00482_A215ArticuloDescripcionLarga ;
   private String[] P00482_A214ArticuloDescripcionCorta ;
   private String[] P00482_A76ArticuloNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class articulowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00482( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Articulowwds_1_filterfulltext ,
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
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[12];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T2.[ImpuestoPorcentaje], T1.[ImpuestoId], T1.[TipoArticuloId], T1.[ArticuloStock], T1.[ArticuloPrecioPromedio], T1.[ArticuloPrecioVenta], T1.[ArticuloPrecioCompra]," ;
      scmdbuf += " T1.[ArticuloId], T3.[TipoArticuloNombre], T1.[ArticuloDescripcionLarga], T1.[ArticuloDescripcionCorta], T1.[ArticuloNombre] FROM (([Articulo] T1 INNER JOIN [Impuesto]" ;
      scmdbuf += " T2 ON T2.[ImpuestoId] = T1.[ImpuestoId]) INNER JOIN [TipoArticulo] T3 ON T3.[TipoArticuloId] = T1.[TipoArticuloId])" ;
      if ( ! (GXutil.strcmp("", AV27Articulowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[ArticuloId] AS decimal(11,0))) like '%' + ?) or ( T1.[ArticuloNombre] like '%' + ?) or ( T1.[ArticuloDescripcionCorta] like '%' + ?) or ( T1.[ArticuloDescripcionLarga] like '%' + ?) or ( CONVERT( char(17), CAST(T1.[ArticuloPrecioCompra] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[ArticuloPrecioVenta] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(17), CAST(T1.[ArticuloPrecioPromedio] AS decimal(17,2))) like '%' + ?) or ( CONVERT( char(10), CAST(T1.[ArticuloStock] AS decimal(10,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T1.[TipoArticuloId] AS decimal(11,0))) like '%' + ?) or ( T3.[TipoArticuloNombre] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[ImpuestoId] AS decimal(11,0))) like '%' + ?) or ( CONVERT( char(9), CAST(T2.[ImpuestoPorcentaje] AS decimal(9,2))) like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
         GXv_int6[4] = (byte)(1) ;
         GXv_int6[5] = (byte)(1) ;
         GXv_int6[6] = (byte)(1) ;
         GXv_int6[7] = (byte)(1) ;
         GXv_int6[8] = (byte)(1) ;
         GXv_int6[9] = (byte)(1) ;
         GXv_int6[10] = (byte)(1) ;
         GXv_int6[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloNombre]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionCorta]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionCorta] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionLarga]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloDescripcionLarga] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioCompra]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioCompra] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioVenta]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioVenta] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioPromedio]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloPrecioPromedio] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ArticuloStock]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ArticuloStock] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[TipoArticuloId]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[TipoArticuloId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[TipoArticuloNombre]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[TipoArticuloNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ImpuestoId]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ImpuestoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ImpuestoPorcentaje]" ;
      }
      else if ( ( AV17OrderedBy == 12 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ImpuestoPorcentaje] DESC" ;
      }
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P00482(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).longValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).longValue() , (java.math.BigDecimal)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Boolean) dynConstraints[13]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00482", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

