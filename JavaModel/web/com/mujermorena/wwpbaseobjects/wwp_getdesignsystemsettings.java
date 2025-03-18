package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getdesignsystemsettings extends GXProcedure
{
   public wwp_getdesignsystemsettings( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getdesignsystemsettings.class ), "" );
   }

   public wwp_getdesignsystemsettings( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings executeUdp( )
   {
      wwp_getdesignsystemsettings.this.aP0 = new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings[] {new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings[] aP0 )
   {
      wwp_getdesignsystemsettings.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9WWP_DesignSystemSettingsJSON ;
      GXv_char2[0] = GXt_char1 ;
      new com.mujermorena.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", GXv_char2) ;
      wwp_getdesignsystemsettings.this.GXt_char1 = GXv_char2[0] ;
      AV9WWP_DesignSystemSettingsJSON = GXt_char1 ;
      if ( GXutil.strcmp(AV9WWP_DesignSystemSettingsJSON, "") != 0 )
      {
         AV8WWP_DesignSystemSettings.fromJSonString(AV9WWP_DesignSystemSettingsJSON, null);
      }
      else
      {
         AV8WWP_DesignSystemSettings = (com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings)new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
         AV8WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Basecolor( "Custom" );
         AV8WWP_DesignSystemSettings.setgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle( "Light" );
         new com.mujermorena.wwpbaseobjects.saveuserkeyvalue(remoteHandle, context).execute( "DesignSystemSettings", AV8WWP_DesignSystemSettings.toJSonString(false, true)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_getdesignsystemsettings.this.AV8WWP_DesignSystemSettings;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8WWP_DesignSystemSettings = new com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings(remoteHandle, context);
      AV9WWP_DesignSystemSettingsJSON = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV9WWP_DesignSystemSettingsJSON ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings[] aP0 ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_DesignSystemSettings AV8WWP_DesignSystemSettings ;
}

