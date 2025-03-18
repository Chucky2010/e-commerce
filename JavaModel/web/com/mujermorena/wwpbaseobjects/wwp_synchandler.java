package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_synchandler extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      wwp_synchandler pgm = new wwp_synchandler (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String aP0 = "";
      String aP1 = "";
      String[] aP2 = new String[] {""};

      try
      {
         aP0 = (String) args[0];
         aP1 = (String) args[1];
         aP2[0] = (String) args[2];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1, aP2);
   }

   public wwp_synchandler( )
   {
      super( -1 , new ModelContext( wwp_synchandler.class ), "" );
      Application.init(com.mujermorena.GXcfg.class);
   }

   public wwp_synchandler( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_synchandler.class ), "" );
   }

   public wwp_synchandler( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      String[] aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.mujermorena.wwpbaseobjects.awwp_synchandler(remoteHandle, context).execute( aP0, aP1, aP2 );
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
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

   private short Gx_err ;
}

