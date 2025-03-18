package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap_RoutePoint implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap_RoutePoint( )
   {
      this( -1, new ModelContext( StructSdtGxMap_RoutePoint.class ));
   }

   public StructSdtGxMap_RoutePoint( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtGxMap_RoutePoint_Latitude = "" ;
      gxTv_SdtGxMap_RoutePoint_Longitude = "" ;
      gxTv_SdtGxMap_RoutePoint_Pin = "" ;
      gxTv_SdtGxMap_RoutePoint_Description = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getLatitude( )
   {
      return gxTv_SdtGxMap_RoutePoint_Latitude ;
   }

   public void setLatitude( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Latitude = value ;
   }

   public String getLongitude( )
   {
      return gxTv_SdtGxMap_RoutePoint_Longitude ;
   }

   public void setLongitude( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Longitude = value ;
   }

   public String getPin( )
   {
      return gxTv_SdtGxMap_RoutePoint_Pin ;
   }

   public void setPin( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Pin = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtGxMap_RoutePoint_Description ;
   }

   public void setDescription( String value )
   {
      gxTv_SdtGxMap_RoutePoint_N = (byte)(0) ;
      gxTv_SdtGxMap_RoutePoint_Description = value ;
   }

   protected byte gxTv_SdtGxMap_RoutePoint_N ;
   protected String gxTv_SdtGxMap_RoutePoint_Latitude ;
   protected String gxTv_SdtGxMap_RoutePoint_Longitude ;
   protected String gxTv_SdtGxMap_RoutePoint_Pin ;
   protected String gxTv_SdtGxMap_RoutePoint_Description ;
}

