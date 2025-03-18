package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamsdupdateregisteruser extends GXProcedure
{
   public gamsdupdateregisteruser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsdupdateregisteruser.class ), "" );
   }

   public gamsdupdateregisteruser( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 ,
                                                                        String aP1 ,
                                                                        String aP2 ,
                                                                        String aP3 ,
                                                                        String aP4 )
   {
      gamsdupdateregisteruser.this.aP5 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 )
   {
      gamsdupdateregisteruser.this.AV19UserGUID = aP0;
      gamsdupdateregisteruser.this.AV18UserName = aP1;
      gamsdupdateregisteruser.this.AV10Email = aP2;
      gamsdupdateregisteruser.this.AV12FirstName = aP3;
      gamsdupdateregisteruser.this.AV14LastName = aP4;
      gamsdupdateregisteruser.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV11Errors = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getlasterrors() ;
      if ( AV11Errors.size() == 0 )
      {
         AV17User.setgxTv_SdtGAMUser_Name( AV18UserName );
         AV17User.setgxTv_SdtGAMUser_Email( AV10Email );
         AV17User.setgxTv_SdtGAMUser_Firstname( AV12FirstName );
         AV17User.setgxTv_SdtGAMUser_Lastname( AV14LastName );
         GXv_objcol_SdtGAMError1[0] = AV11Errors ;
         AV13isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).updateuserbykeytocompleteuserdata(AV17User, GXv_objcol_SdtGAMError1) ;
         AV11Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( ! AV13isOK )
         {
            GXt_objcol_SdtMessages_Message2 = AV8Messages ;
            GXv_objcol_SdtMessages_Message3[0] = GXt_objcol_SdtMessages_Message2 ;
            new com.mujermorena.gamconverterrorstomessages(remoteHandle, context).execute( AV11Errors, GXv_objcol_SdtMessages_Message3) ;
            GXt_objcol_SdtMessages_Message2 = GXv_objcol_SdtMessages_Message3[0] ;
            AV8Messages = GXt_objcol_SdtMessages_Message2 ;
         }
      }
      else
      {
         GXt_objcol_SdtMessages_Message2 = AV8Messages ;
         GXv_objcol_SdtMessages_Message3[0] = GXt_objcol_SdtMessages_Message2 ;
         new com.mujermorena.gamconverterrorstomessages(remoteHandle, context).execute( AV11Errors, GXv_objcol_SdtMessages_Message3) ;
         GXt_objcol_SdtMessages_Message2 = GXv_objcol_SdtMessages_Message3[0] ;
         AV8Messages = GXt_objcol_SdtMessages_Message2 ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = gamsdupdateregisteruser.this.AV8Messages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV17User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV11Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      GXt_objcol_SdtMessages_Message2 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV19UserGUID ;
   private String AV12FirstName ;
   private String AV14LastName ;
   private boolean AV13isOK ;
   private String AV18UserName ;
   private String AV10Email ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV8Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXt_objcol_SdtMessages_Message2 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV11Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV17User ;
}

