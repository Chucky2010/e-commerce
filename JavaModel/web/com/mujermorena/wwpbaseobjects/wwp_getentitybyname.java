package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getentitybyname extends GXProcedure
{
   public wwp_getentitybyname( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getentitybyname.class ), "" );
   }

   public wwp_getentitybyname( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( String aP0 )
   {
      wwp_getentitybyname.this.aP1 = new long[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        long[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             long[] aP1 )
   {
      wwp_getentitybyname.this.AV8WWPEntityName = aP0;
      wwp_getentitybyname.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13GXLvl1 = (byte)(0) ;
      /* Using cursor P002O2 */
      pr_default.execute(0, new Object[] {AV8WWPEntityName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A150WWPEntityName = P002O2_A150WWPEntityName[0] ;
         A33WWPEntityId = P002O2_A33WWPEntityId[0] ;
         AV13GXLvl1 = (byte)(1) ;
         AV9WWPEntityId = A33WWPEntityId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV13GXLvl1 == 0 )
      {
         AV10WWP_Entity = (com.mujermorena.wwpbaseobjects.SdtWWP_Entity)new com.mujermorena.wwpbaseobjects.SdtWWP_Entity( remoteHandle, context);
         AV10WWP_Entity.setgxTv_SdtWWP_Entity_Wwpentityname( AV8WWPEntityName );
         AV10WWP_Entity.Save();
         if ( AV10WWP_Entity.Success() )
         {
            AV9WWPEntityId = AV10WWP_Entity.getgxTv_SdtWWP_Entity_Wwpentityid() ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_getentitybyname.this.AV9WWPEntityId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P002O2_A150WWPEntityName = new String[] {""} ;
      P002O2_A33WWPEntityId = new long[1] ;
      A150WWPEntityName = "" ;
      AV10WWP_Entity = new com.mujermorena.wwpbaseobjects.SdtWWP_Entity(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_getentitybyname__default(),
         new Object[] {
             new Object[] {
            P002O2_A150WWPEntityName, P002O2_A33WWPEntityId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl1 ;
   private short Gx_err ;
   private long AV9WWPEntityId ;
   private long A33WWPEntityId ;
   private String scmdbuf ;
   private String AV8WWPEntityName ;
   private String A150WWPEntityName ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P002O2_A150WWPEntityName ;
   private long[] P002O2_A33WWPEntityId ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_Entity AV10WWP_Entity ;
}

final  class wwp_getentitybyname__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002O2", "SELECT TOP 1 [WWPEntityName], [WWPEntityId] FROM [WWP_Entity] WHERE [WWPEntityName] = ? ORDER BY [WWPEntityId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

