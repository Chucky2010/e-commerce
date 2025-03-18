package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getloggeduserroles extends GXProcedure
{
   public wwp_getloggeduserroles( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getloggeduserroles.class ), "" );
   }

   public wwp_getloggeduserroles( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( )
   {
      wwp_getloggeduserroles.this.aP0 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXSimpleCollection<String>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXSimpleCollection<String>[] aP0 )
   {
      wwp_getloggeduserroles.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      GXv_objcol_SdtGAMError1[0] = AV11GAMErrorCollection ;
      AV9GAMRoleCollection = AV8GAMUser.getroles(GXv_objcol_SdtGAMError1) ;
      AV11GAMErrorCollection = GXv_objcol_SdtGAMError1[0] ;
      AV12WWPSubscriptionRoleIdCollection.clear();
      AV15GXV1 = 1 ;
      while ( AV15GXV1 <= AV9GAMRoleCollection.size() )
      {
         AV10GAMRole = (genexus.security.api.genexussecurity.SdtGAMRole)((genexus.security.api.genexussecurity.SdtGAMRole)AV9GAMRoleCollection.elementAt(-1+AV15GXV1));
         AV12WWPSubscriptionRoleIdCollection.add(AV10GAMRole.getgxTv_SdtGAMRole_Guid(), 0);
         AV15GXV1 = (int)(AV15GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = wwp_getloggeduserroles.this.AV12WWPSubscriptionRoleIdCollection;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12WWPSubscriptionRoleIdCollection = new GXSimpleCollection<String>(String.class, "internal", "");
      AV8GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV9GAMRoleCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRole>(genexus.security.api.genexussecurity.SdtGAMRole.class, "GAMRole", "http://tempuri.org/", remoteHandle);
      AV11GAMErrorCollection = new GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError>(genexus.security.api.genexussecurity.SdtGAMError.class, "GAMError", "http://tempuri.org/", remoteHandle);
      GXv_objcol_SdtGAMError1 = new GXExternalCollection[1] ;
      AV10GAMRole = new genexus.security.api.genexussecurity.SdtGAMRole(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV15GXV1 ;
   private GXSimpleCollection<String>[] aP0 ;
   private GXSimpleCollection<String> AV12WWPSubscriptionRoleIdCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> AV11GAMErrorCollection ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMError> GXv_objcol_SdtGAMError1[] ;
   private GXExternalCollection<genexus.security.api.genexussecurity.SdtGAMRole> AV9GAMRoleCollection ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV8GAMUser ;
   private genexus.security.api.genexussecurity.SdtGAMRole AV10GAMRole ;
}

