package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_exportwritefilter extends GXProcedure
{
   public wwp_exportwritefilter( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_exportwritefilter.class ), "" );
   }

   public wwp_exportwritefilter( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( com.genexus.gxoffice.ExcelDoc[] aP0 ,
                        boolean aP1 ,
                        short[] aP2 ,
                        short aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( com.genexus.gxoffice.ExcelDoc[] aP0 ,
                             boolean aP1 ,
                             short[] aP2 ,
                             short aP3 ,
                             String aP4 )
   {
      wwp_exportwritefilter.this.AV10ExcelDocument = aP0[0];
      this.aP0 = aP0;
      wwp_exportwritefilter.this.AV8AddRow = aP1;
      wwp_exportwritefilter.this.AV9CellRow = aP2[0];
      this.aP2 = aP2;
      wwp_exportwritefilter.this.AV12FirstColumn = aP3;
      wwp_exportwritefilter.this.AV11FilterDsc = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8AddRow )
      {
         AV9CellRow = (short)(AV9CellRow+1) ;
      }
      AV10ExcelDocument.Cells(AV9CellRow, AV12FirstColumn, 1, 1).setBold( (short)(1) );
      AV10ExcelDocument.Cells(AV9CellRow, AV12FirstColumn, 1, 1).setColor( 3 );
      AV10ExcelDocument.Cells(AV9CellRow, AV12FirstColumn, 1, 1).setText( AV11FilterDsc );
      AV10ExcelDocument.Cells(AV9CellRow, AV12FirstColumn+1, 1, 1).setItalic( (short)(1) );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_exportwritefilter.this.AV10ExcelDocument;
      this.aP2[0] = wwp_exportwritefilter.this.AV9CellRow;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9CellRow ;
   private short AV12FirstColumn ;
   private short Gx_err ;
   private boolean AV8AddRow ;
   private String AV11FilterDsc ;
   private com.genexus.gxoffice.ExcelDoc[] aP0 ;
   private short[] aP2 ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
}

