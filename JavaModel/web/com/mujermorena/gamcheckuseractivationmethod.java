package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamcheckuseractivationmethod extends GXProcedure
{
   public gamcheckuseractivationmethod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamcheckuseractivationmethod.class ), "" );
   }

   public gamcheckuseractivationmethod( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 ,
                                                                        String aP1 )
   {
      gamcheckuseractivationmethod.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      gamcheckuseractivationmethod.this.AV15UserGUID = aP0;
      gamcheckuseractivationmethod.this.AV8LinkURL = aP1;
      gamcheckuseractivationmethod.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).get();
      if ( GXutil.strcmp(AV13Repository.getgxTv_SdtGAMRepository_Useractivationmethod(), "U") == 0 )
      {
         AV14User.load(AV15UserGUID);
         GXv_objcol_SdtGAMError1[0] = AV10Errors ;
         AV14User.sendemailtoactivateaccount(AV9Application, AV8LinkURL, GXv_objcol_SdtGAMError1);
         AV10Errors = GXv_objcol_SdtGAMError1[0] ;
         if ( AV10Errors.size() == 0 )
         {
            AV11Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
            AV11Message.setgxTv_SdtMessages_Message_Type( (byte)(0) );
            AV11Message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "The account was created successfully, an email was sent with instructions to activate your account!", "") );
            AV12Messages.add(AV11Message, 0);
         }
         else
         {
            GXv_objcol_SdtMessages_Message2[0] = AV12Messages ;
            new com.mujermorena.gamconverterrorstomessages(remoteHandle, context).execute( AV10Errors, GXv_objcol_SdtMessages_Message2) ;
            AV12Messages = GXv_objcol_SdtMessages_Message2[0] ;
         }
      }
      else if ( GXutil.strcmp(AV13Repository.getgxTv_SdtGAMRepository_Useractivationmethod(), "D") == 0 )
      {
         AV11Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
         AV11Message.setgxTv_SdtMessages_Message_Type( (byte)(0) );
         AV11Message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "The user was created successfully!!, you must wait for confirmation from the administrator.", "") );
         AV12Messages.add(AV11Message, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gamcheckuseractivationmethod.this.AV12Messages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV13Repository = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context);
      AV14User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV9Application = new genexus.security.api.genexussecurity.SdtGAMApplication(remoteHandle, context);
      AV10Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV11Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV15UserGUID ;
   private String AV8LinkURL ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV10Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV12Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private com.genexus.SdtMessages_Message AV11Message ;
   private genexus.security.api.genexussecurity.SdtGAMApplication AV9Application ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV14User ;
   private genexus.security.api.genexussecurity.SdtGAMRepository AV13Repository ;
}

