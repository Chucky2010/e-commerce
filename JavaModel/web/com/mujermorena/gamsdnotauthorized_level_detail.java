package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamsdnotauthorized_level_detail extends GXProcedure
{
   public gamsdnotauthorized_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsdnotauthorized_level_detail.class ), "" );
   }

   public gamsdnotauthorized_level_detail( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt executeUdp( int aP0 )
   {
      gamsdnotauthorized_level_detail.this.aP1 = new com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt[] {new com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt[] aP1 )
   {
      gamsdnotauthorized_level_detail.this.AV11gxid = aP0;
      gamsdnotauthorized_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV11gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxwebsession.setValue(Gxids, "true");
      }
      AV14GXM1GAMSDNotAuthorized_Level_DetailSdt.setgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User( AV10User );
      AV14GXM1GAMSDNotAuthorized_Level_DetailSdt.setgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password( AV9Password );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamsdnotauthorized_level_detail.this.AV14GXM1GAMSDNotAuthorized_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14GXM1GAMSDNotAuthorized_Level_DetailSdt = new com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV10User = "" ;
      AV9Password = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11gxid ;
   private String Gxids ;
   private String AV9Password ;
   private String AV10User ;
   private com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt AV14GXM1GAMSDNotAuthorized_Level_DetailSdt ;
}

