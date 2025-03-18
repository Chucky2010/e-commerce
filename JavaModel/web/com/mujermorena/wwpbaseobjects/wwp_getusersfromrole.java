package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getusersfromrole extends GXProcedure
{
   public wwp_getusersfromrole( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getusersfromrole.class ), "" );
   }

   public wwp_getusersfromrole( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( String aP0 )
   {
      wwp_getusersfromrole.this.aP1 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXSimpleCollection<String>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXSimpleCollection<String>[] aP1 )
   {
      wwp_getusersfromrole.this.AV10WWPSubscriptionRoleId = aP0;
      wwp_getusersfromrole.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_SdtGAMError1[0] = AV13GAMErrorCollection ;
      AV12GAMRole = new genexus.security.api.genexussecurity.SdtGAMRepository(remoteHandle, context).getrolebyguid(AV10WWPSubscriptionRoleId, GXv_objcol_SdtGAMError1);
      AV13GAMErrorCollection = GXv_objcol_SdtGAMError1[0] ;
      GXv_objcol_SdtGAMError1[0] = AV13GAMErrorCollection ;
      AV14GAMUserCollection = AV12GAMRole.getusers(GXv_objcol_SdtGAMError1) ;
      AV13GAMErrorCollection = GXv_objcol_SdtGAMError1[0] ;
      AV9WWPUserExtendedIdCollection.clear();
      AV17GXV1 = 1 ;
      while ( AV17GXV1 <= AV14GAMUserCollection.size() )
      {
         AV11GAMUser = (genexus.security.api.genexussecurity.SdtGAMUser)((genexus.security.api.genexussecurity.SdtGAMUser)AV14GAMUserCollection.elementAt(-1+AV17GXV1));
         AV9WWPUserExtendedIdCollection.add(AV11GAMUser.getgxTv_SdtGAMUser_Guid(), 0);
         AV17GXV1 = (int)(AV17GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_getusersfromrole.this.AV9WWPUserExtendedIdCollection;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9WWPUserExtendedIdCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12GAMRole = new genexus.security.api.genexussecurity.SdtGAMRole(remoteHandle, context);
      AV13GAMErrorCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      AV14GAMUserCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMUser>(genexus.security.api.genexussecurity.SdtGAMUser.class, "GAMUser", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV11GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17GXV1 ;
   private String AV10WWPSubscriptionRoleId ;
   private GXSimpleCollection<String>[] aP1 ;
   private GXSimpleCollection<String> AV9WWPUserExtendedIdCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMUser> AV14GAMUserCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV13GAMErrorCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV11GAMUser ;
   private genexus.security.api.genexussecurity.SdtGAMRole AV12GAMRole ;
}

