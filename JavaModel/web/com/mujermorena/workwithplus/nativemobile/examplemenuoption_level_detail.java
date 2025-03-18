package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class examplemenuoption_level_detail extends GXProcedure
{
   public examplemenuoption_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( examplemenuoption_level_detail.class ), "" );
   }

   public examplemenuoption_level_detail( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt executeUdp( short aP0 ,
                                                                                                     int aP1 )
   {
      examplemenuoption_level_detail.this.aP2 = new com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt[] {new com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt[] aP2 )
   {
      examplemenuoption_level_detail.this.AV5OptionNumber = aP0;
      examplemenuoption_level_detail.this.AV6gxid = aP1;
      examplemenuoption_level_detail.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV6gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         Gxdynprop1 = GXutil.format( "Menu Option Number %1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5OptionNumber), 4, 0), "", "", "", "", "", "", "", "") ;
         Gxdynprop += ((GXutil.strcmp(Gxdynprop, "")==0) ? "" : ", ") + "[\"Form\",\"Caption\",\"" + GXutil.encodeJSON( Gxdynprop1) + "\"]" ;
         Gxwebsession.setValue(Gxids, "true");
      }
      AV11GXM2ExampleMenuOption_Level_DetailSdt.setgxTv_SdtExampleMenuOption_Level_DetailSdt_Gxdynprop( "[ "+Gxdynprop+" ]" );
      Gxdynprop = "" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = examplemenuoption_level_detail.this.AV11GXM2ExampleMenuOption_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11GXM2ExampleMenuOption_Level_DetailSdt = new com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      Gxdynprop1 = "" ;
      Gxdynprop = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV5OptionNumber ;
   private short Gx_err ;
   private int AV6gxid ;
   private String Gxids ;
   private String Gxdynprop1 ;
   private String Gxdynprop ;
   private com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt[] aP2 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private com.mujermorena.workwithplus.nativemobile.SdtExampleMenuOption_Level_DetailSdt AV11GXM2ExampleMenuOption_Level_DetailSdt ;
}

