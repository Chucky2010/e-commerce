package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mujermorenasdhome_level_detail extends GXProcedure
{
   public mujermorenasdhome_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mujermorenasdhome_level_detail.class ), "" );
   }

   public mujermorenasdhome_level_detail( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt executeUdp( int aP0 )
   {
      mujermorenasdhome_level_detail.this.aP1 = new com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt[] {new com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt[] aP1 )
   {
      mujermorenasdhome_level_detail.this.AV9gxid = aP0;
      mujermorenasdhome_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV9gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxwebsession.setValue(Gxids, "true");
      }
      /* Execute user subroutine: 'SETCARTBADGES' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14GXM2MujerMorenaSDHome_Level_DetailSdt.setgxTv_SdtMujerMorenaSDHome_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      cleanup();
   }

   public void S111( )
   {
      /* 'SETCARTBADGES' Routine */
      returnInSub = false ;
      GXt_int1 = AV8ProductsInCartCount ;
      GXv_int2[0] = GXt_int1 ;
      new com.mujermorena.nmcartproductscount(remoteHandle, context).execute( GXv_int2) ;
      mujermorenasdhome_level_detail.this.GXt_int1 = GXv_int2[0] ;
      AV8ProductsInCartCount = GXt_int1 ;
      Gxdynprop1 = GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV8ProductsInCartCount), "ZZZ9")) ;
      Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Btncartcheckout\",\"Badgetext\",\"" + GXutil.encodeJSON( Gxdynprop1) + "\"]" ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = mujermorenasdhome_level_detail.this.AV14GXM2MujerMorenaSDHome_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14GXM2MujerMorenaSDHome_Level_DetailSdt = new com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      Gxdynprop = "" ;
      GXv_int2 = new short[1] ;
      Gxdynprop1 = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8ProductsInCartCount ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV9gxid ;
   private String Gxids ;
   private String Gxdynprop1 ;
   private boolean returnInSub ;
   private String Gxdynprop ;
   private com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private com.mujermorena.SdtMujerMorenaSDHome_Level_DetailSdt AV14GXM2MujerMorenaSDHome_Level_DetailSdt ;
}

