package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ciudadwwexport extends GXProcedure
{
   public ciudadwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ciudadwwexport.class ), "" );
   }

   public ciudadwwexport( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      ciudadwwexport.this.aP1 = new String[] {""};
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
      ciudadwwexport.this.aP0 = aP0;
      ciudadwwexport.this.aP1 = aP1;
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
      AV12Filename = "CiudadWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         ciudadwwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         ciudadwwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Nombre", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Ciudadwwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Ciudadwwds_1_filterfulltext ,
                                           Long.valueOf(A7CiudadId) ,
                                           A62CiudadNombre ,
                                           Long.valueOf(A6DepartamentoId) ,
                                           A61DepartamentoNombre ,
                                           A60PaisNombre ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV27Ciudadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ciudadwwds_1_filterfulltext), "%", "") ;
      lV27Ciudadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ciudadwwds_1_filterfulltext), "%", "") ;
      lV27Ciudadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ciudadwwds_1_filterfulltext), "%", "") ;
      lV27Ciudadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ciudadwwds_1_filterfulltext), "%", "") ;
      lV27Ciudadwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Ciudadwwds_1_filterfulltext), "%", "") ;
      /* Using cursor P003W2 */
      pr_default.execute(0, new Object[] {lV27Ciudadwwds_1_filterfulltext, lV27Ciudadwwds_1_filterfulltext, lV27Ciudadwwds_1_filterfulltext, lV27Ciudadwwds_1_filterfulltext, lV27Ciudadwwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A5PaisId = P003W2_A5PaisId[0] ;
         A6DepartamentoId = P003W2_A6DepartamentoId[0] ;
         A7CiudadId = P003W2_A7CiudadId[0] ;
         A60PaisNombre = P003W2_A60PaisNombre[0] ;
         A61DepartamentoNombre = P003W2_A61DepartamentoNombre[0] ;
         A62CiudadNombre = P003W2_A62CiudadNombre[0] ;
         A5PaisId = P003W2_A5PaisId[0] ;
         A61DepartamentoNombre = P003W2_A61DepartamentoNombre[0] ;
         A60PaisNombre = P003W2_A60PaisNombre[0] ;
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
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A7CiudadId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A62CiudadNombre, GXv_char5) ;
         ciudadwwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setNumber( A6DepartamentoId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A61DepartamentoNombre, GXv_char5) ;
         ciudadwwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A60PaisNombre, GXv_char5) ;
         ciudadwwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( GXt_char4 );
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
      if ( GXutil.strcmp(AV20Session.getValue("CiudadWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "CiudadWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("CiudadWWGridState"), null, null);
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
      this.aP0[0] = ciudadwwexport.this.AV12Filename;
      this.aP1[0] = ciudadwwexport.this.AV13ErrorMessage;
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
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A60PaisNombre = "" ;
      AV27Ciudadwwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Ciudadwwds_1_filterfulltext = "" ;
      P003W2_A5PaisId = new long[1] ;
      P003W2_A6DepartamentoId = new long[1] ;
      P003W2_A7CiudadId = new long[1] ;
      P003W2_A60PaisNombre = new String[] {""} ;
      P003W2_A61DepartamentoNombre = new String[] {""} ;
      P003W2_A62CiudadNombre = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.ciudadwwexport__default(),
         new Object[] {
             new Object[] {
            P003W2_A5PaisId, P003W2_A6DepartamentoId, P003W2_A7CiudadId, P003W2_A60PaisNombre, P003W2_A61DepartamentoNombre, P003W2_A62CiudadNombre
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
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private long A5PaisId ;
   private String A62CiudadNombre ;
   private String A61DepartamentoNombre ;
   private String A60PaisNombre ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV27Ciudadwwds_1_filterfulltext ;
   private String lV27Ciudadwwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P003W2_A5PaisId ;
   private long[] P003W2_A6DepartamentoId ;
   private long[] P003W2_A7CiudadId ;
   private String[] P003W2_A60PaisNombre ;
   private String[] P003W2_A61DepartamentoNombre ;
   private String[] P003W2_A62CiudadNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class ciudadwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P003W2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Ciudadwwds_1_filterfulltext ,
                                          long A7CiudadId ,
                                          String A62CiudadNombre ,
                                          long A6DepartamentoId ,
                                          String A61DepartamentoNombre ,
                                          String A60PaisNombre ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[5];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T2.[PaisId], T1.[DepartamentoId], T1.[CiudadId], T3.[PaisNombre], T2.[DepartamentoNombre], T1.[CiudadNombre] FROM (([Ciudad] T1 INNER JOIN [Departamento]" ;
      scmdbuf += " T2 ON T2.[DepartamentoId] = T1.[DepartamentoId]) INNER JOIN [Pais] T3 ON T3.[PaisId] = T2.[PaisId])" ;
      if ( ! (GXutil.strcmp("", AV27Ciudadwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[CiudadId] AS decimal(11,0))) like '%' + ?) or ( T1.[CiudadNombre] like '%' + ?) or ( CONVERT( char(11), CAST(T1.[DepartamentoId] AS decimal(11,0))) like '%' + ?) or ( T2.[DepartamentoNombre] like '%' + ?) or ( T3.[PaisNombre] like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
         GXv_int6[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CiudadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CiudadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[CiudadId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[CiudadId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[DepartamentoId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[DepartamentoId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[DepartamentoNombre]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[DepartamentoNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[PaisNombre]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[PaisNombre] DESC" ;
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
                  return conditional_P003W2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).longValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Boolean) dynConstraints[7]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003W2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 80);
               ((String[]) buf[4])[0] = rslt.getString(5, 80);
               ((String[]) buf[5])[0] = rslt.getString(6, 80);
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
                  stmt.setVarchar(sIdx, (String)parms[5], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               return;
      }
   }

}

