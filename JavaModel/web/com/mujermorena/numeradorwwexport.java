package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class numeradorwwexport extends GXProcedure
{
   public numeradorwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( numeradorwwexport.class ), "" );
   }

   public numeradorwwexport( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      numeradorwwexport.this.aP1 = new String[] {""};
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
      numeradorwwexport.this.aP0 = aP0;
      numeradorwwexport.this.aP1 = aP1;
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
      AV12Filename = "NumeradorWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         numeradorwwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         numeradorwwexport.this.GXt_char4 = GXv_char5[0] ;
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
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Ultimo NRO", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Numeradorwwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Numeradorwwds_1_filterfulltext ,
                                           A49NumeradorID ,
                                           Long.valueOf(A232NumeradorUltimoNRO) ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV27Numeradorwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Numeradorwwds_1_filterfulltext), "%", "") ;
      lV27Numeradorwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Numeradorwwds_1_filterfulltext), "%", "") ;
      /* Using cursor P004M2 */
      pr_default.execute(0, new Object[] {lV27Numeradorwwds_1_filterfulltext, lV27Numeradorwwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A232NumeradorUltimoNRO = P004M2_A232NumeradorUltimoNRO[0] ;
         A49NumeradorID = P004M2_A49NumeradorID[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A49NumeradorID, GXv_char5) ;
         numeradorwwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( GXt_char4 );
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( A232NumeradorUltimoNRO );
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
      if ( GXutil.strcmp(AV20Session.getValue("NumeradorWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "NumeradorWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("NumeradorWWGridState"), null, null);
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
      this.aP0[0] = numeradorwwexport.this.AV12Filename;
      this.aP1[0] = numeradorwwexport.this.AV13ErrorMessage;
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
      A49NumeradorID = "" ;
      AV27Numeradorwwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Numeradorwwds_1_filterfulltext = "" ;
      P004M2_A232NumeradorUltimoNRO = new long[1] ;
      P004M2_A49NumeradorID = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.numeradorwwexport__default(),
         new Object[] {
             new Object[] {
            P004M2_A232NumeradorUltimoNRO, P004M2_A49NumeradorID
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
   private long A232NumeradorUltimoNRO ;
   private String A49NumeradorID ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV27Numeradorwwds_1_filterfulltext ;
   private String lV27Numeradorwwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P004M2_A232NumeradorUltimoNRO ;
   private String[] P004M2_A49NumeradorID ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class numeradorwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004M2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Numeradorwwds_1_filterfulltext ,
                                          String A49NumeradorID ,
                                          long A232NumeradorUltimoNRO ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[2];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT [NumeradorUltimoNRO], [NumeradorID] FROM [Numerador]" ;
      if ( ! (GXutil.strcmp("", AV27Numeradorwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [NumeradorID] like '%' + ?) or ( CONVERT( char(10), CAST([NumeradorUltimoNRO] AS decimal(10,0))) like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [NumeradorID]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [NumeradorID] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [NumeradorUltimoNRO]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [NumeradorUltimoNRO] DESC" ;
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
                  return conditional_P004M2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).shortValue() , ((Boolean) dynConstraints[4]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004M2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 56);
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
                  stmt.setVarchar(sIdx, (String)parms[2], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 100);
               }
               return;
      }
   }

}

