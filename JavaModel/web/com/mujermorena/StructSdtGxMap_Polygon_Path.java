package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap_Polygon_Path implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap_Polygon_Path( )
   {
      this( -1, new ModelContext( StructSdtGxMap_Polygon_Path.class ));
   }

   public StructSdtGxMap_Polygon_Path( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtGxMap_Polygon_Path_Pathlat = "" ;
      gxTv_SdtGxMap_Polygon_Path_Pathlong = "" ;
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

   public String getPathlat( )
   {
      return gxTv_SdtGxMap_Polygon_Path_Pathlat ;
   }

   public void setPathlat( String value )
   {
      gxTv_SdtGxMap_Polygon_Path_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Path_Pathlat = value ;
   }

   public String getPathlong( )
   {
      return gxTv_SdtGxMap_Polygon_Path_Pathlong ;
   }

   public void setPathlong( String value )
   {
      gxTv_SdtGxMap_Polygon_Path_N = (byte)(0) ;
      gxTv_SdtGxMap_Polygon_Path_Pathlong = value ;
   }

   protected byte gxTv_SdtGxMap_Polygon_Path_N ;
   protected String gxTv_SdtGxMap_Polygon_Path_Pathlat ;
   protected String gxTv_SdtGxMap_Polygon_Path_Pathlong ;
}

