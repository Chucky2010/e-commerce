package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class sdsvc_myproductsproductdetail_level_detail extends GXProcedure
{
   public sdsvc_myproductsproductdetail_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sdsvc_myproductsproductdetail_level_detail.class ), "" );
   }

   public sdsvc_myproductsproductdetail_level_detail( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   public GxJsonArray talledl( )
   {
      initialize();
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "Selecionar Talla", ""));
      /* Using cursor SDSVC_MYPR2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( SDSVC_MYPR2_A286TallaID[0], (byte)(11), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(GXutil.ltrim( localUtil.ntoc( SDSVC_MYPR2_A288TallaNumero[0], (byte)(4), (byte)(0), ".", "")));
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
      return GXutil.stringCollectionsToJsonObj( gxdynajaxctrlcodr, gxdynajaxctrldescr) ;
      /* End function talledl */
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      scmdbuf = "" ;
      SDSVC_MYPR2_A286TallaID = new long[1] ;
      SDSVC_MYPR2_A288TallaNumero = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.sdsvc_myproductsproductdetail_level_detail__default(),
         new Object[] {
             new Object[] {
            SDSVC_MYPR2_A286TallaID, SDSVC_MYPR2_A288TallaNumero
            }
         }
      );
      /* GeneXus formulas. */
   }

   protected int AV18Talle ;
   protected String scmdbuf ;
   protected com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   protected com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   protected IDataStoreProvider pr_default ;
   protected long[] SDSVC_MYPR2_A286TallaID ;
   protected short[] SDSVC_MYPR2_A288TallaNumero ;
}

final  class sdsvc_myproductsproductdetail_level_detail__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("SDSVC_MYPR2", "SELECT [TallaID], [TallaNumero] FROM [Talla] ORDER BY [TallaNumero] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

