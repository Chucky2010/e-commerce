package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_existsuserextended extends GXProcedure
{
   public wwp_existsuserextended( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_existsuserextended.class ), "" );
   }

   public wwp_existsuserextended( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      wwp_existsuserextended.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      wwp_existsuserextended.this.AV9WWPUserExtendedId = aP0;
      wwp_existsuserextended.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Exists = false ;
      /* Using cursor P001G2 */
      pr_default.execute(0, new Object[] {AV9WWPUserExtendedId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32WWPUserExtendedId = P001G2_A32WWPUserExtendedId[0] ;
         AV8Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_existsuserextended.this.AV8Exists;
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
      P001G2_A32WWPUserExtendedId = new String[] {""} ;
      A32WWPUserExtendedId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_existsuserextended__default(),
         new Object[] {
             new Object[] {
            P001G2_A32WWPUserExtendedId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9WWPUserExtendedId ;
   private String scmdbuf ;
   private String A32WWPUserExtendedId ;
   private boolean AV8Exists ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P001G2_A32WWPUserExtendedId ;
}

final  class wwp_existsuserextended__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001G2", "SELECT [WWPUserExtendedId] FROM [WWP_UserExtended] WHERE [WWPUserExtendedId] = ? ORDER BY [WWPUserExtendedId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
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
               stmt.setString(1, (String)parms[0], 40);
               return;
      }
   }

}

