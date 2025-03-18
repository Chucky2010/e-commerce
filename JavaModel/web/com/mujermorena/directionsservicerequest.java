package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class directionsservicerequest extends GXProcedure
{
   public directionsservicerequest( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( directionsservicerequest.class ), "" );
   }

   public directionsservicerequest( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.genexus.SdtMessages_Message> executeUdp( String aP0 ,
                                                                        com.genexuscore.genexus.common.SdtDirectionsRequestParameters aP1 ,
                                                                        GXBaseCollection<com.genexuscore.genexus.common.SdtRoute>[] aP2 )
   {
      directionsservicerequest.this.aP3 = new GXBaseCollection[] {new GXBaseCollection<com.genexus.SdtMessages_Message>()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        com.genexuscore.genexus.common.SdtDirectionsRequestParameters aP1 ,
                        GXBaseCollection<com.genexuscore.genexus.common.SdtRoute>[] aP2 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             com.genexuscore.genexus.common.SdtDirectionsRequestParameters aP1 ,
                             GXBaseCollection<com.genexuscore.genexus.common.SdtRoute>[] aP2 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP3 )
   {
      directionsservicerequest.this.AV9DirectionsServiceProvider = aP0;
      directionsservicerequest.this.AV8DirectionsRequestParameters = aP1;
      directionsservicerequest.this.aP2 = aP2;
      directionsservicerequest.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV9DirectionsServiceProvider, "Google") == 0 )
      {
         GXv_objcol_SdtRoute1[0] = AV12Routes ;
         GXv_objcol_SdtMessages_Message2[0] = AV11errorMessages ;
         new com.genexuscore.genexus.common.googledirectionsservicerequest(remoteHandle, context).execute( AV8DirectionsRequestParameters, GXv_objcol_SdtRoute1, GXv_objcol_SdtMessages_Message2) ;
         AV12Routes = GXv_objcol_SdtRoute1[0] ;
         AV11errorMessages = GXv_objcol_SdtMessages_Message2[0] ;
      }
      else
      {
         AV10errorMessage.setgxTv_SdtMessages_Message_Description( httpContext.getMessage( "Unknown Error", "") );
         AV10errorMessage.setgxTv_SdtMessages_Message_Type( (byte)(1) );
         AV11errorMessages.add(AV10errorMessage, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = directionsservicerequest.this.AV12Routes;
      this.aP3[0] = directionsservicerequest.this.AV11errorMessages;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Routes = new GXBaseCollection<com.genexuscore.genexus.common.SdtRoute>(com.genexuscore.genexus.common.SdtRoute.class, "Route", "GeneXus", remoteHandle);
      AV11errorMessages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtRoute1 = new GXBaseCollection[1] ;
      GXv_objcol_SdtMessages_Message2 = new GXBaseCollection[1] ;
      AV10errorMessage = new com.genexus.SdtMessages_Message(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9DirectionsServiceProvider ;
   private com.genexus.SdtMessages_Message AV10errorMessage ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP3 ;
   private GXBaseCollection<com.genexuscore.genexus.common.SdtRoute>[] aP2 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11errorMessages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message2[] ;
   private GXBaseCollection<com.genexuscore.genexus.common.SdtRoute> AV12Routes ;
   private GXBaseCollection<com.genexuscore.genexus.common.SdtRoute> GXv_objcol_SdtRoute1[] ;
   private com.genexuscore.genexus.common.SdtDirectionsRequestParameters AV8DirectionsRequestParameters ;
}

