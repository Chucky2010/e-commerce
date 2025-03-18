package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dvmessagegetdesktopnotificationmsg extends GXProcedure
{
   public dvmessagegetdesktopnotificationmsg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dvmessagegetdesktopnotificationmsg.class ), "" );
   }

   public dvmessagegetdesktopnotificationmsg( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      dvmessagegetdesktopnotificationmsg.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      dvmessagegetdesktopnotificationmsg.this.AV12Title = aP0;
      dvmessagegetdesktopnotificationmsg.this.AV11Text = aP1;
      dvmessagegetdesktopnotificationmsg.this.AV9DesktopNotificationIconUrl = aP2;
      dvmessagegetdesktopnotificationmsg.this.AV8ClickRedirectURL = aP3;
      dvmessagegetdesktopnotificationmsg.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV10Parms ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.wwpbaseobjects.dvmessagegetadvancednotificationmsg(remoteHandle, context).execute( AV12Title, AV11Text, AV13Type, "", "na", "true", AV9DesktopNotificationIconUrl, AV8ClickRedirectURL, GXv_char2) ;
      dvmessagegetdesktopnotificationmsg.this.GXt_char1 = GXv_char2[0] ;
      AV10Parms = GXt_char1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = dvmessagegetdesktopnotificationmsg.this.AV10Parms;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10Parms = "" ;
      GXt_char1 = "" ;
      AV13Type = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV12Title ;
   private String AV11Text ;
   private String GXt_char1 ;
   private String AV13Type ;
   private String GXv_char2[] ;
   private String AV9DesktopNotificationIconUrl ;
   private String AV8ClickRedirectURL ;
   private String AV10Parms ;
   private String[] aP4 ;
}

