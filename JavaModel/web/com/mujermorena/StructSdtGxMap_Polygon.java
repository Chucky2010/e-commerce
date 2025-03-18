package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap_Polygon implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap_Polygon( )
   {
      this( -1, new ModelContext( StructSdtGxMap_Polygon.class ));
   }

   public StructSdtGxMap_Polygon( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtGxMap_Polygon_Polygonfill = "" ;
      gxTv_SdtGxMap_Polygon_Polygonfillopacity = new java.math.BigDecimal(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstroke = "" ;
      gxTv_SdtGxMap_Polygon_Polygonstrokeopacity = new java.math.BigDecimal(0) ;
      gxTv_SdtGxMap_Polygon_Polygoninfowinhtml = "" ;
      gxTv_SdtGxMap_Polygon_Paths_N = (byte)(1) ;
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

   public String getPolygonfill( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonfill ;
   }

   public void setPolygonfill( String value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonfill = value ;
   }

   public java.math.BigDecimal getPolygonfillopacity( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonfillopacity ;
   }

   public void setPolygonfillopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonfillopacity = value ;
   }

   public String getPolygonstroke( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonstroke ;
   }

   public void setPolygonstroke( String value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstroke = value ;
   }

   public java.math.BigDecimal getPolygonstrokeopacity( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonstrokeopacity ;
   }

   public void setPolygonstrokeopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstrokeopacity = value ;
   }

   public short getPolygonstrokeweight( )
   {
      return gxTv_SdtGxMap_Polygon_Polygonstrokeweight ;
   }

   public void setPolygonstrokeweight( short value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygonstrokeweight = value ;
   }

   public String getPolygoninfowinhtml( )
   {
      return gxTv_SdtGxMap_Polygon_Polygoninfowinhtml ;
   }

   public void setPolygoninfowinhtml( String value )
   {
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Polygoninfowinhtml = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_Polygon_Path> getPaths( )
   {
      return gxTv_SdtGxMap_Polygon_Paths ;
   }

   public void setPaths( java.util.Vector<com.mujermorena.StructSdtGxMap_Polygon_Path> value )
   {
      gxTv_SdtGxMap_Polygon_Paths_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Paths = value ;
   }

   protected byte gxTv_SdtGxMap_Polygon_Paths_N ;
   protected byte gxTv_SdtGxMap_Polygon_N ;
   protected short gxTv_SdtGxMap_Polygon_Polygonstrokeweight ;
   protected String gxTv_SdtGxMap_Polygon_Polygonfill ;
   protected String gxTv_SdtGxMap_Polygon_Polygonstroke ;
   protected String gxTv_SdtGxMap_Polygon_Polygoninfowinhtml ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Polygon_Polygonfillopacity ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Polygon_Polygonstrokeopacity ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_Polygon_Path> gxTv_SdtGxMap_Polygon_Paths=null ;
}

