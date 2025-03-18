package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap_Circle implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap_Circle( )
   {
      this( -1, new ModelContext( StructSdtGxMap_Circle.class ));
   }

   public StructSdtGxMap_Circle( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtGxMap_Circle_Latitude = "" ;
      gxTv_SdtGxMap_Circle_Longitude = "" ;
      gxTv_SdtGxMap_Circle_Circlefill = "" ;
      gxTv_SdtGxMap_Circle_Circlefillopacity = new java.math.BigDecimal(0) ;
      gxTv_SdtGxMap_Circle_Circlestroke = "" ;
      gxTv_SdtGxMap_Circle_Circlestrokeopacity = new java.math.BigDecimal(0) ;
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
      return gxTv_SdtGxMap_Circle_Latitude ;
   }

   public void setLatitude( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Latitude = value ;
   }

   public String getLongitude( )
   {
      return gxTv_SdtGxMap_Circle_Longitude ;
   }

   public void setLongitude( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Longitude = value ;
   }

   public long getRadius( )
   {
      return gxTv_SdtGxMap_Circle_Radius ;
   }

   public void setRadius( long value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Radius = value ;
   }

   public String getCirclefill( )
   {
      return gxTv_SdtGxMap_Circle_Circlefill ;
   }

   public void setCirclefill( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlefill = value ;
   }

   public java.math.BigDecimal getCirclefillopacity( )
   {
      return gxTv_SdtGxMap_Circle_Circlefillopacity ;
   }

   public void setCirclefillopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlefillopacity = value ;
   }

   public String getCirclestroke( )
   {
      return gxTv_SdtGxMap_Circle_Circlestroke ;
   }

   public void setCirclestroke( String value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlestroke = value ;
   }

   public java.math.BigDecimal getCirclestrokeopacity( )
   {
      return gxTv_SdtGxMap_Circle_Circlestrokeopacity ;
   }

   public void setCirclestrokeopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlestrokeopacity = value ;
   }

   public short getCirclestrokeweight( )
   {
      return gxTv_SdtGxMap_Circle_Circlestrokeweight ;
   }

   public void setCirclestrokeweight( short value )
   {
      gxTv_SdtGxMap_Circle_N = (byte)(0) ;
      gxTv_SdtGxMap_Circle_Circlestrokeweight = value ;
   }

   protected byte gxTv_SdtGxMap_Circle_N ;
   protected short gxTv_SdtGxMap_Circle_Circlestrokeweight ;
   protected long gxTv_SdtGxMap_Circle_Radius ;
   protected String gxTv_SdtGxMap_Circle_Latitude ;
   protected String gxTv_SdtGxMap_Circle_Longitude ;
   protected String gxTv_SdtGxMap_Circle_Circlefill ;
   protected String gxTv_SdtGxMap_Circle_Circlestroke ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Circle_Circlefillopacity ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Circle_Circlestrokeopacity ;
}

