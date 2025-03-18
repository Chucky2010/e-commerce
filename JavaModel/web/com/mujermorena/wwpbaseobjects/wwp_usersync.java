package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_usersync extends GXProcedure
{
   public wwp_usersync( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_usersync.class ), "" );
   }

   public wwp_usersync( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 ,
                                                                        genexus.security.api.genexussecurity.SdtGAMUser aP1 )
   {
      wwp_usersync.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        genexus.security.api.genexussecurity.SdtGAMUser aP1 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             genexus.security.api.genexussecurity.SdtGAMUser aP1 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 )
   {
      wwp_usersync.this.AV10TrnMode = aP0;
      wwp_usersync.this.AV8GAMUser = aP1;
      wwp_usersync.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_debug( GXutil.format( "TrnMode: %1 - %2, GAMUser: %3", AV10TrnMode, com.genexuscore.genexus.gxdomaintrnmode.getDescription(httpContext,(String)AV10TrnMode), AV8GAMUser.tojsonstring(), "", "", "", "", "", ""), AV16Pgmname) ;
      if ( GXutil.strcmp(AV10TrnMode, "INS") == 0 )
      {
         AV11WWP_UserExtended = (com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended)new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended( remoteHandle, context);
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid( AV8GAMUser.getgxTv_SdtGAMUser_Guid() );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedname( GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Name()) );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname( GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Firstname())+((GXutil.strcmp("", GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Firstname()))==0)||(GXutil.strcmp("", GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Lastname()))==0) ? "" : " ")+GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Lastname()) );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail( ((GXutil.strcmp(GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Email()), httpContext.getMessage( "admin", ""))!=0) ? GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Email()) : "") );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone( GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Phone()) );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddesktopnotif( true );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemainotif( true );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedsmsnotif( true );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedmobilenotif( true );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted( AV8GAMUser.getgxTv_SdtGAMUser_Isdeleted() );
         if ( AV8GAMUser.getgxTv_SdtGAMUser_Isdeleted() )
         {
            AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin( GXutil.serverNow( context, remoteHandle, pr_default) );
         }
         else
         {
            AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin_SetNull();
         }
         AV11WWP_UserExtended.Save();
         if ( ! AV11WWP_UserExtended.Success() )
         {
            AV9Messages = AV11WWP_UserExtended.GetMessages() ;
         }
      }
      else if ( GXutil.strcmp(AV10TrnMode, "UPD") == 0 )
      {
         AV11WWP_UserExtended.Load(AV8GAMUser.getgxTv_SdtGAMUser_Guid());
         if ( AV11WWP_UserExtended.Fail() )
         {
            AV11WWP_UserExtended = (com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended)new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended( remoteHandle, context);
            AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedid( AV8GAMUser.getgxTv_SdtGAMUser_Guid() );
         }
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedname( GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Name()) );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedfullname( GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Firstname())+((GXutil.strcmp("", GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Firstname()))==0)||(GXutil.strcmp("", GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Lastname()))==0) ? "" : " ")+GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Lastname()) );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedemail( ((GXutil.strcmp(GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Email()), httpContext.getMessage( "admin", ""))!=0) ? GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Email()) : "") );
         AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendedphone( GXutil.rtrim( AV8GAMUser.getgxTv_SdtGAMUser_Phone()) );
         AV11WWP_UserExtended.Save();
         if ( ! AV11WWP_UserExtended.Success() )
         {
            AV9Messages = AV11WWP_UserExtended.GetMessages() ;
         }
      }
      else if ( GXutil.strcmp(AV10TrnMode, "DLT") == 0 )
      {
         AV11WWP_UserExtended.Load(AV8GAMUser.getgxTv_SdtGAMUser_Guid());
         if ( AV11WWP_UserExtended.Success() )
         {
            AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeleted( true );
            AV11WWP_UserExtended.setgxTv_SdtWWP_UserExtended_Wwpuserextendeddeletedin( GXutil.serverNow( context, remoteHandle, pr_default) );
            AV11WWP_UserExtended.Save();
            if ( ! AV11WWP_UserExtended.Success() )
            {
               AV9Messages = AV11WWP_UserExtended.GetMessages() ;
            }
         }
         else
         {
            AV9Messages = AV11WWP_UserExtended.GetMessages() ;
         }
      }
      if ( AV9Messages.size() > 0 )
      {
         new com.mujermorena.wwpbaseobjects.wwp_logger(remoteHandle, context).gxep_error( GXutil.format( "TrnMode: %1 - %2, GAMUser: %3, Messages %4", AV10TrnMode, com.genexuscore.genexus.gxdomaintrnmode.getDescription(httpContext,(String)AV10TrnMode), AV8GAMUser.tojsonstring(), AV9Messages.toJSonString(false), "", "", "", "", ""), AV16Pgmname) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = wwp_usersync.this.AV9Messages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV16Pgmname = "" ;
      AV11WWP_UserExtended = new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended(remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.wwp_usersync__default(),
         new Object[] {
         }
      );
      AV16Pgmname = "WWPBaseObjects.WWP_UserSync" ;
      /* GeneXus formulas. */
      AV16Pgmname = "WWPBaseObjects.WWP_UserSync" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10TrnMode ;
   private String AV16Pgmname ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV9Messages ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV8GAMUser ;
   private com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended AV11WWP_UserExtended ;
}

final  class wwp_usersync__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

