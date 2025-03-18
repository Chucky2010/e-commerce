package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap( )
   {
      this( -1, new ModelContext( StructSdtGxMap.class ));
   }

   public StructSdtGxMap( int remoteHandle ,
                          ModelContext context )
   {
      gxTv_SdtGxMap_Maptype = "" ;
      gxTv_SdtGxMap_Maplatitude = "" ;
      gxTv_SdtGxMap_Maplongitude = "" ;
      gxTv_SdtGxMap_Circles_N = (byte)(1) ;
      gxTv_SdtGxMap_Points_N = (byte)(1) ;
      gxTv_SdtGxMap_Polygons_N = (byte)(1) ;
      gxTv_SdtGxMap_Lines_N = (byte)(1) ;
      gxTv_SdtGxMap_Routing_N = (byte)(1) ;
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

   public String getMaptype( )
   {
      return gxTv_SdtGxMap_Maptype ;
   }

   public void setMaptype( String value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Maptype = value ;
   }

   public short getMapzoom( )
   {
      return gxTv_SdtGxMap_Mapzoom ;
   }

   public void setMapzoom( short value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Mapzoom = value ;
   }

   public String getMaplatitude( )
   {
      return gxTv_SdtGxMap_Maplatitude ;
   }

   public void setMaplatitude( String value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Maplatitude = value ;
   }

   public String getMaplongitude( )
   {
      return gxTv_SdtGxMap_Maplongitude ;
   }

   public void setMaplongitude( String value )
   {
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Maplongitude = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_Circle> getCircles( )
   {
      return gxTv_SdtGxMap_Circles ;
   }

   public void setCircles( java.util.Vector<com.mujermorena.StructSdtGxMap_Circle> value )
   {
      gxTv_SdtGxMap_Circles_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Circles = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_Point> getPoints( )
   {
      return gxTv_SdtGxMap_Points ;
   }

   public void setPoints( java.util.Vector<com.mujermorena.StructSdtGxMap_Point> value )
   {
      gxTv_SdtGxMap_Points_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Points = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_Polygon> getPolygons( )
   {
      return gxTv_SdtGxMap_Polygons ;
   }

   public void setPolygons( java.util.Vector<com.mujermorena.StructSdtGxMap_Polygon> value )
   {
      gxTv_SdtGxMap_Polygons_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygons = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_Line> getLines( )
   {
      return gxTv_SdtGxMap_Lines ;
   }

   public void setLines( java.util.Vector<com.mujermorena.StructSdtGxMap_Line> value )
   {
      gxTv_SdtGxMap_Lines_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Lines = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_RoutePoint> getRouting( )
   {
      return gxTv_SdtGxMap_Routing ;
   }

   public void setRouting( java.util.Vector<com.mujermorena.StructSdtGxMap_RoutePoint> value )
   {
      gxTv_SdtGxMap_Routing_N = (byte)(0) ;
      gxTv_SdtGxMap_N = (byte)(0) ;
      gxTv_SdtGxMap_Routing = value ;
   }

   protected byte gxTv_SdtGxMap_Circles_N ;
   protected byte gxTv_SdtGxMap_Points_N ;
   protected byte gxTv_SdtGxMap_Polygons_N ;
   protected byte gxTv_SdtGxMap_Lines_N ;
   protected byte gxTv_SdtGxMap_Routing_N ;
   protected byte gxTv_SdtGxMap_N ;
   protected short gxTv_SdtGxMap_Mapzoom ;
   protected String gxTv_SdtGxMap_Maptype ;
   protected String gxTv_SdtGxMap_Maplatitude ;
   protected String gxTv_SdtGxMap_Maplongitude ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_Circle> gxTv_SdtGxMap_Circles=null ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_Point> gxTv_SdtGxMap_Points=null ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_Polygon> gxTv_SdtGxMap_Polygons=null ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_Line> gxTv_SdtGxMap_Lines=null ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_RoutePoint> gxTv_SdtGxMap_Routing=null ;
}

