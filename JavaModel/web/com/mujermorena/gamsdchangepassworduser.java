package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gamsdchangepassworduser extends GXProcedure
{
   public gamsdchangepassworduser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gamsdchangepassworduser.class ), "" );
   }

   public gamsdchangepassworduser( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( boolean aP0 ,
                                                                        String aP1 ,
                                                                        String aP2 ,
                                                                        String aP3 ,
                                                                        String aP4 )
   {
      gamsdchangepassworduser.this.aP5 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( boolean aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( boolean aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 )
   {
      gamsdchangepassworduser.this.AV10isPasswordExpires = aP0;
      gamsdchangepassworduser.this.AV13UserName = aP1;
      gamsdchangepassworduser.this.AV14UserPassword = aP2;
      gamsdchangepassworduser.this.AV15UserPasswordNew = aP3;
      gamsdchangepassworduser.this.AV16UserPasswordNewConf = aP4;
      gamsdchangepassworduser.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV15UserPasswordNew, AV16UserPasswordNewConf) == 0 )
      {
         if ( AV10isPasswordExpires )
         {
            GXv_objcol_SdtGAMError1[0] = AV8Errors ;
            AV9isOK = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).updateusertochangepassword(AV14UserPassword, AV15UserPasswordNew, GXv_objcol_SdtGAMError1) ;
            AV8Errors = GXv_objcol_SdtGAMError1[0] ;
         }
         else
         {
            GXv_objcol_SdtGAMError1[0] = AV8Errors ;
            AV9isOK = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).changeyourpassword(AV14UserPassword, AV15UserPasswordNew, GXv_objcol_SdtGAMError1) ;
            AV8Errors = GXv_objcol_SdtGAMError1[0] ;
         }
         if ( AV9isOK )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "gamsdchangepassworduser");
         }
         else
         {
            GXt_objcol_SdtMessages_Message2 = AV12Messages ;
            GXv_objcol_SdtMessages_Message3[0] = GXt_objcol_SdtMessages_Message2 ;
            new com.mujermorena.gamconverterrorstomessages(remoteHandle, context).execute( AV8Errors, GXv_objcol_SdtMessages_Message3) ;
            GXt_objcol_SdtMessages_Message2 = GXv_objcol_SdtMessages_Message3[0] ;
            AV12Messages = GXt_objcol_SdtMessages_Message2 ;
         }
      }
      else
      {
         AV11Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV11Message.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "The new password and confirmation do not match.", "") );
         AV12Messages.add(AV11Message, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = gamsdchangepassworduser.this.AV12Messages;
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
      AV8Errors = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      GXt_objcol_SdtMessages_Message2 = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message3 = new GXBaseCollection[1] ;
      AV11Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamsdchangepassworduser__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.gamsdchangepassworduser__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV14UserPassword ;
   private String AV15UserPasswordNew ;
   private String AV16UserPasswordNewConf ;
   private boolean AV10isPasswordExpires ;
   private boolean AV9isOK ;
   private String AV13UserName ;
   private com.genexus.SdtMessages_Message AV11Message ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV8Errors ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV12Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXt_objcol_SdtMessages_Message2 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message3[] ;
}

final  class gamsdchangepassworduser__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
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

final  class gamsdchangepassworduser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

