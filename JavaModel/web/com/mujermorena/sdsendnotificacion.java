package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sdsendnotificacion extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      sdsendnotificacion pgm = new sdsendnotificacion (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public sdsendnotificacion( )
   {
      super( -1 , new ModelContext( sdsendnotificacion.class ), "" );
      Application.init(com.mujermorena.GXcfg.class);
   }

   public sdsendnotificacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sdsendnotificacion.class ), "" );
   }

   public sdsendnotificacion( int remoteHandle ,
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
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.mujermorena.asdsendnotificacion(remoteHandle, context).execute(  );
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

