package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class awwp_synchandler extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.mujermorena.GXcfg.class);
      awwp_synchandler pgm = new awwp_synchandler (-1);
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

   public awwp_synchandler( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( awwp_synchandler.class ), "" );
   }

   public awwp_synchandler( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      awwp_synchandler.this.aP2 = new String[] {""};
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
      awwp_synchandler.this.AV8GAMEvents = aP0;
      awwp_synchandler.this.AV13inJson = aP1;
      awwp_synchandler.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( GXutil.format( "GAMEvents: %1 - %2, inJson: %3", AV8GAMEvents, genexus.security.api.genexussecuritycommon.gxdomaingamevents.getDescription(httpContext,(String)AV8GAMEvents), AV13inJson, "", "", "", "", "", ""), AV18Pgmname) ;
      if ( GXutil.strcmp(AV8GAMEvents, "user-insert") == 0 )
      {
         AV10GAMUser.fromjsonstring(AV13inJson);
         GXt_objcol_SdtMessages_Message1 = AV14Messages ;
         GXv_objcol_SdtMessages_Message2[0] = GXt_objcol_SdtMessages_Message1 ;
         new com.mujermorena.wwpbaseobjects.wwp_usersync(remoteHandle, context).execute( "INS", AV10GAMUser, GXv_objcol_SdtMessages_Message2) ;
         GXt_objcol_SdtMessages_Message1 = GXv_objcol_SdtMessages_Message2[0] ;
         AV14Messages = GXt_objcol_SdtMessages_Message1 ;
      }
      else if ( GXutil.strcmp(AV8GAMEvents, "user-update") == 0 )
      {
         AV10GAMUser.fromjsonstring(AV13inJson);
         GXt_objcol_SdtMessages_Message1 = AV14Messages ;
         GXv_objcol_SdtMessages_Message2[0] = GXt_objcol_SdtMessages_Message1 ;
         new com.mujermorena.wwpbaseobjects.wwp_usersync(remoteHandle, context).execute( "UPD", AV10GAMUser, GXv_objcol_SdtMessages_Message2) ;
         GXt_objcol_SdtMessages_Message1 = GXv_objcol_SdtMessages_Message2[0] ;
         AV14Messages = GXt_objcol_SdtMessages_Message1 ;
      }
      else if ( GXutil.strcmp(AV8GAMEvents, "user-delete") == 0 )
      {
         AV10GAMUser.fromjsonstring(AV13inJson);
         GXt_objcol_SdtMessages_Message1 = AV14Messages ;
         GXv_objcol_SdtMessages_Message2[0] = GXt_objcol_SdtMessages_Message1 ;
         new com.mujermorena.wwpbaseobjects.wwp_usersync(remoteHandle, context).execute( "DLT", AV10GAMUser, GXv_objcol_SdtMessages_Message2) ;
         GXt_objcol_SdtMessages_Message1 = GXv_objcol_SdtMessages_Message2[0] ;
         AV14Messages = GXt_objcol_SdtMessages_Message1 ;
      }
      else
      {
         new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( GXutil.format( "GAMEvents: %1 - %2, inJson: %3, Not Implemented", AV8GAMEvents, genexus.security.api.genexussecuritycommon.gxdomaingamevents.getDescription(httpContext,(String)AV8GAMEvents), AV13inJson, "", "", "", "", "", ""), AV18Pgmname) ;
      }
      AV15outJson = AV14Messages.toJSonString(false) ;
      new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( GXutil.format( "GAMEvents: %1 - %2, outJson: %3", AV8GAMEvents, genexus.security.api.genexussecuritycommon.gxdomaingamevents.getDescription(httpContext,(String)AV8GAMEvents), AV15outJson, "", "", "", "", "", ""), AV18Pgmname) ;
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(wwp_synchandler.class);
      return new com.mujermorena.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP2[0] = awwp_synchandler.this.AV15outJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15outJson = "" ;
      AV18Pgmname = "" ;
      AV10GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV14Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXt_objcol_SdtMessages_Message1 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      AV18Pgmname = "WWPBaseObjects.AWWP_SyncHandler" ;
      /* GeneXus formulas. */
      AV18Pgmname = "WWPBaseObjects.AWWP_SyncHandler" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8GAMEvents ;
   private String AV18Pgmname ;
   private String AV13inJson ;
   private String AV15outJson ;
   private String[] aP2 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV14Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXt_objcol_SdtMessages_Message1 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV10GAMUser ;
}

