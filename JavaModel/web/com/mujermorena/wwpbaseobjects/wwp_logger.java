package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_logger extends GXProcedure
{
   public wwp_logger( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_logger.class ), "" );
   }

   public wwp_logger( int remoteHandle ,
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
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   public void gxep_debug( String in_AV10Topic ,
                           String in_AV9Message )
   {
      wwp_logger.this.AV10Topic = in_AV10Topic;
      wwp_logger.this.AV9Message = in_AV9Message;
      initialize();
      initialized = (short)(1) ;
      /* Debug Constructor */
      /* Execute user subroutine: 'FORMATMESSAGE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new com.genexuscore.genexus.common.SdtLog(remoteHandle, context).debug(AV8FormattedMessage, GXutil.trim( AV10Topic)) ;
      privateExecute();
      cleanup();
   }

   public void gxep_info( String in_AV10Topic ,
                          String in_AV9Message )
   {
      wwp_logger.this.AV10Topic = in_AV10Topic;
      wwp_logger.this.AV9Message = in_AV9Message;
      initialize();
      initialized = (short)(1) ;
      /* Info Constructor */
      /* Execute user subroutine: 'FORMATMESSAGE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new com.genexuscore.genexus.common.SdtLog(remoteHandle, context).info(AV8FormattedMessage, GXutil.trim( AV10Topic)) ;
      privateExecute();
      cleanup();
   }

   public void gxep_warning( String in_AV10Topic ,
                             String in_AV9Message )
   {
      wwp_logger.this.AV10Topic = in_AV10Topic;
      wwp_logger.this.AV9Message = in_AV9Message;
      initialize();
      initialized = (short)(1) ;
      /* Warning Constructor */
      /* Execute user subroutine: 'FORMATMESSAGE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new com.genexuscore.genexus.common.SdtLog(remoteHandle, context).warning(AV8FormattedMessage, GXutil.trim( AV10Topic)) ;
      privateExecute();
      cleanup();
   }

   public void gxep_error( String in_AV10Topic ,
                           String in_AV9Message )
   {
      wwp_logger.this.AV10Topic = in_AV10Topic;
      wwp_logger.this.AV9Message = in_AV9Message;
      initialize();
      initialized = (short)(1) ;
      /* Error Constructor */
      /* Execute user subroutine: 'FORMATMESSAGE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      new com.genexuscore.genexus.common.SdtLog(remoteHandle, context).error(AV8FormattedMessage, GXutil.trim( AV10Topic)) ;
      privateExecute();
      cleanup();
   }

   public void S111( )
   {
      /* 'FORMATMESSAGE' Routine */
      returnInSub = false ;
      AV8FormattedMessage = "" ;
      GXt_char1 = AV11WWPUserExtendedId ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.wwpbaseobjects.wwp_getloggeduserid(remoteHandle, context).execute( GXv_char2) ;
      wwp_logger.this.GXt_char1 = GXv_char2[0] ;
      AV11WWPUserExtendedId = GXt_char1 ;
      if ( ! (GXutil.strcmp("", AV11WWPUserExtendedId)==0) )
      {
         AV8FormattedMessage += GXutil.format( "[UserGUID: %1] ", GXutil.trim( AV11WWPUserExtendedId), "", "", "", "", "", "", "", "") ;
      }
      else
      {
         AV8FormattedMessage += GXutil.format( "[UserGUID: %1] ", "N/A", "", "", "", "", "", "", "", "") ;
      }
      if ( ! (GXutil.strcmp("", AV11WWPUserExtendedId)==0) )
      {
         AV8FormattedMessage += GXutil.format( "[UserName: %1] ", GXutil.trim( AV11WWPUserExtendedId), "", "", "", "", "", "", "", "") ;
      }
      else
      {
         AV8FormattedMessage += GXutil.format( "[UserName: %1] ", "N/A", "", "", "", "", "", "", "", "") ;
      }
      AV8FormattedMessage += GXutil.trim( AV9Message) ;
   }

   protected void cleanup( )
   {
      if ( initialized != 1 )
      {
      }
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8FormattedMessage = "" ;
      AV11WWPUserExtendedId = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short initialized ;
   private short Gx_err ;
   private String AV11WWPUserExtendedId ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean returnInSub ;
   private String AV10Topic ;
   private String AV9Message ;
   private String AV8FormattedMessage ;
}

