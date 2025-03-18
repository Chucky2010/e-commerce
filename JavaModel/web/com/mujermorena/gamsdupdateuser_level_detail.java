package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamsdupdateuser_level_detail extends GXProcedure
{
   public gamsdupdateuser_level_detail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsdupdateuser_level_detail.class ), "" );
   }

   public gamsdupdateuser_level_detail( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt executeUdp( int aP0 )
   {
      gamsdupdateuser_level_detail.this.aP1 = new com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt[] {new com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt[] aP1 )
   {
      gamsdupdateuser_level_detail.this.AV16gxid = aP0;
      gamsdupdateuser_level_detail.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      Gxids = "gxid_" + GXutil.str( AV16gxid, 8, 0) ;
      if ( GXutil.strcmp(Gxwebsession.getValue(Gxids), "") == 0 )
      {
         GXv_objcol_SdtGAMError1[0] = AV7Errors ;
         AV13User = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getuserbykeytocompleteuserdata(GXv_objcol_SdtGAMError1);
         AV7Errors = GXv_objcol_SdtGAMError1[0] ;
         AV15UserGUID = AV13User.getgxTv_SdtGAMUser_Guid() ;
         AV12UserName = AV13User.getgxTv_SdtGAMUser_Name() ;
         AV6Email = AV13User.getgxTv_SdtGAMUser_Email() ;
         AV8FirstName = AV13User.getgxTv_SdtGAMUser_Firstname() ;
         AV9LastName = AV13User.getgxTv_SdtGAMUser_Lastname() ;
         Gxwebsession.setValue(Gxids+"gxvar_Username", AV12UserName);
         Gxwebsession.setValue(Gxids+"gxvar_Email", AV6Email);
         Gxwebsession.setValue(Gxids+"gxvar_Firstname", AV8FirstName);
         Gxwebsession.setValue(Gxids+"gxvar_Lastname", AV9LastName);
         Gxwebsession.setValue(Gxids+"gxvar_Userguid", AV15UserGUID);
         Gxwebsession.setValue(Gxids, "true");
      }
      else
      {
         AV15UserGUID = Gxwebsession.getValue(Gxids+"gxvar_Userguid") ;
         AV12UserName = Gxwebsession.getValue(Gxids+"gxvar_Username") ;
         AV6Email = Gxwebsession.getValue(Gxids+"gxvar_Email") ;
         AV8FirstName = Gxwebsession.getValue(Gxids+"gxvar_Firstname") ;
         AV9LastName = Gxwebsession.getValue(Gxids+"gxvar_Lastname") ;
      }
      AV19GXM1GAMSDUpdateUser_Level_DetailSdt.setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username( AV12UserName );
      AV19GXM1GAMSDUpdateUser_Level_DetailSdt.setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email( AV6Email );
      AV19GXM1GAMSDUpdateUser_Level_DetailSdt.setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname( AV8FirstName );
      AV19GXM1GAMSDUpdateUser_Level_DetailSdt.setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname( AV9LastName );
      AV19GXM1GAMSDUpdateUser_Level_DetailSdt.setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid( AV15UserGUID );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gamsdupdateuser_level_detail.this.AV19GXM1GAMSDUpdateUser_Level_DetailSdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19GXM1GAMSDUpdateUser_Level_DetailSdt = new com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt(remoteHandle, context);
      Gxids = "" ;
      Gxwebsession = httpContext.getWebSession();
      AV13User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV7Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV15UserGUID = "" ;
      AV12UserName = "" ;
      AV6Email = "" ;
      AV8FirstName = "" ;
      AV9LastName = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV16gxid ;
   private String Gxids ;
   private String AV15UserGUID ;
   private String AV8FirstName ;
   private String AV9LastName ;
   private String AV12UserName ;
   private String AV6Email ;
   private com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt[] aP1 ;
   private com.genexus.webpanels.WebSession Gxwebsession ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV7Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV13User ;
   private com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt AV19GXM1GAMSDUpdateUser_Level_DetailSdt ;
}

