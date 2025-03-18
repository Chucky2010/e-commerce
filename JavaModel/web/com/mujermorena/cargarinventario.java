package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cargarinventario extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      cargarinventario pgm = new cargarinventario (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      String[] aP0 = new String[] {""};
      String[] aP1 = new String[] {""};

      try
      {
         aP0[0] = (String) args[0];
         aP1[0] = (String) args[1];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1);
   }

   public cargarinventario( )
   {
      super( -1 , new ModelContext( cargarinventario.class ), "" );
      Application.init(com.mujermorena.GXcfg.class);
   }

   public cargarinventario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cargarinventario.class ), "" );
   }

   public cargarinventario( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      String[] aP1 = new String[] {""};
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
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.mujermorena.acargarinventario(remoteHandle, context).execute( aP0, aP1 );
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

