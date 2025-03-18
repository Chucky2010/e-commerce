package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamsdregisteruser extends GXProcedure
{
   public gamsdregisteruser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsdregisteruser.class ), "" );
   }

   public gamsdregisteruser( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 ,
                                                                        String aP1 ,
                                                                        String aP2 ,
                                                                        String aP3 ,
                                                                        String aP4 ,
                                                                        String aP5 )
   {
      gamsdregisteruser.this.aP6 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP6 )
   {
      gamsdregisteruser.this.AV18UserName = aP0;
      gamsdregisteruser.this.AV9Email = aP1;
      gamsdregisteruser.this.AV11FirstName = aP2;
      gamsdregisteruser.this.AV12LastName = aP3;
      gamsdregisteruser.this.AV16Password = aP4;
      gamsdregisteruser.this.AV8ConfirmPassword = aP5;
      gamsdregisteruser.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV18UserName)==0) )
      {
         AV14Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV14Message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "Se debe ingresar el nombre de usuario.", "") );
         AV15Messages.add(AV14Message, 0);
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(AV16Password, AV8ConfirmPassword) != 0 )
      {
         AV14Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV14Message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "Las contraseñas no coinciden.", "") );
         AV15Messages.add(AV14Message, 0);
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV17User.setgxTv_SdtGAMUser_Name( AV18UserName );
      AV17User.setgxTv_SdtGAMUser_Email( AV9Email );
      AV17User.setgxTv_SdtGAMUser_Firstname( AV11FirstName );
      AV17User.setgxTv_SdtGAMUser_Lastname( AV12LastName );
      AV17User.setgxTv_SdtGAMUser_Password( AV16Password );
      AV17User.save();
      if ( AV17User.success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamsdregisteruser");
         AV13LinkURL = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).applicationgetaccountactivationurl("") ;
         GXv_objcol_SdtMessages_Message1[0] = AV15Messages ;
         new com.mujermorena.gamcheckuseractivationmethod(remoteHandle, context).execute( AV17User.getgxTv_SdtGAMUser_Guid(), AV13LinkURL, GXv_objcol_SdtMessages_Message1) ;
         AV15Messages = GXv_objcol_SdtMessages_Message1[0] ;
         /* Execute user subroutine: 'ADD ROLE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         AV10Errors = AV17User.geterrors() ;
         GXt_objcol_SdtMessages_Message2 = AV15Messages ;
         GXv_objcol_SdtMessages_Message1[0] = GXt_objcol_SdtMessages_Message2 ;
         new com.mujermorena.gamconverterrorstomessages(remoteHandle, context).execute( AV10Errors, GXv_objcol_SdtMessages_Message1) ;
         GXt_objcol_SdtMessages_Message2 = GXv_objcol_SdtMessages_Message1[0] ;
         AV15Messages = GXt_objcol_SdtMessages_Message2 ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADD ROLE' Routine */
      returnInSub = false ;
      AV19GAMUserRol.load(AV17User.getgxTv_SdtGAMUser_Guid());
      AV20IDRol = 4 ;
      GXv_objcol_SdtGAMError3[0] = AV21RolErrors ;
      AV22isOK = AV19GAMUserRol.addrolebyid(AV20IDRol, GXv_objcol_SdtGAMError3) ;
      AV21RolErrors = GXv_objcol_SdtGAMError3[0] ;
      if ( AV22isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamsdregisteruser");
      }
      GXv_objcol_SdtGAMError3[0] = AV10Errors ;
      AV22isOK = AV19GAMUserRol.setmainrolebyid(AV20IDRol, GXv_objcol_SdtGAMError3) ;
      AV10Errors = GXv_objcol_SdtGAMError3[0] ;
      if ( AV22isOK )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "gamsdregisteruser");
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = gamsdregisteruser.this.AV15Messages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV14Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV17User = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV13LinkURL = "" ;
      AV10Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXt_objcol_SdtMessages_Message2 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message1 = new GXBaseCollection[1] ;
      AV19GAMUserRol = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV21RolErrors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError3 = new GXExternalCollection[1] ;
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamsdregisteruser__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamsdregisteruser__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long AV20IDRol ;
   private String AV11FirstName ;
   private String AV12LastName ;
   private String AV16Password ;
   private String AV8ConfirmPassword ;
   private boolean returnInSub ;
   private boolean AV22isOK ;
   private String AV18UserName ;
   private String AV9Email ;
   private String AV13LinkURL ;
   private com.genexus.SdtMessages_Message AV14Message ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV17User ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP6 ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV10Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV21RolErrors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError3[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV15Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXt_objcol_SdtMessages_Message2 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message1[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV19GAMUserRol ;
}

final  class gamsdregisteruser__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public String getDataStoreName( )
   {
      return "GAM";
   }

}

final  class gamsdregisteruser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

