package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class notificationsregistrationhandler extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      notificationsregistrationhandler pgm = new notificationsregistrationhandler (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      byte aP0 = 0;
      String aP1 = "";
      String aP2 = "";
      String aP3 = "";

      try
      {
         aP0 = (byte) GXutil.lval( args[0]);
         aP1 = (String) args[1];
         aP2 = (String) args[2];
         aP3 = (String) args[3];
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1, aP2, aP3);
   }

   public notificationsregistrationhandler( )
   {
      super( -1 , new ModelContext( notificationsregistrationhandler.class ), "" );
      Application.init(com.mujermorena.GXcfg.class);
   }

   public notificationsregistrationhandler( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( notificationsregistrationhandler.class ), "" );
   }

   public notificationsregistrationhandler( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( byte aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.mujermorena.anotificationsregistrationhandler(remoteHandle, context).execute( aP0, aP1, aP2, aP3 );
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

