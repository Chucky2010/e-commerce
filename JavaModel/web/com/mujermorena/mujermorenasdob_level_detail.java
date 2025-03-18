package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenasdob_level_detail extends GXProcedure
{
   public mujermorenasdob_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenasdob_level_detail.class ), "" );
   }

   public mujermorenasdob_level_detail( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt executeUdp( int aP0 )
   {
      mujermorenasdob_level_detail.this.aP1 = new com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt[] {new com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt[] aP1 )
   {
      mujermorenasdob_level_detail.this.AV8gxid = aP0;
      mujermorenasdob_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV8gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Progressbar\",\"Currentprogressbarvalue\",\"" + "100" + "\"]" ;
         Gxdynpropparms = new GXSimpleCollection<String>(String.class, "internal", "") ;
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Step1animationview\",\"play\"," + Gxdynpropparms.toJSonString(false) + "]" ;
         Gxwebsession.setValue(Gxids, "true");
      }
      AV13GXM1MujerMorenaSDOB_Level_DetailSdt.setgxTv_SdtMujerMorenaSDOB_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = mujermorenasdob_level_detail.this.AV13GXM1MujerMorenaSDOB_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13GXM1MujerMorenaSDOB_Level_DetailSdt = new com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      Gxdynprop = "" ;
      Gxdynpropparms = new GXSimpleCollection<String>(String.class, "internal", "");
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8gxid ;
   private String Gxids ;
   private String Gxdynprop ;
   private com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXSimpleCollection<String> Gxdynpropparms ;
   private com.mujermorena.SdtMujerMorenaSDOB_Level_DetailSdt AV13GXM1MujerMorenaSDOB_Level_DetailSdt ;
}

