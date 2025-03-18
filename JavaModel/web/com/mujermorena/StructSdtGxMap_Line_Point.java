package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap_Line_Point implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap_Line_Point( )
   {
      this( -1, new ModelContext( StructSdtGxMap_Line_Point.class ));
   }

   public StructSdtGxMap_Line_Point( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtGxMap_Line_Point_Pointlat = "" ;
      gxTv_SdtGxMap_Line_Point_Pointlong = "" ;
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

   public String getPointlat( )
   {
      return gxTv_SdtGxMap_Line_Point_Pointlat ;
   }

   public void setPointlat( String value )
   {
      gxTv_SdtGxMap_Line_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Point_Pointlat = value ;
   }

   public String getPointlong( )
   {
      return gxTv_SdtGxMap_Line_Point_Pointlong ;
   }

   public void setPointlong( String value )
   {
      gxTv_SdtGxMap_Line_Point_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Point_Pointlong = value ;
   }

   protected byte gxTv_SdtGxMap_Line_Point_N ;
   protected String gxTv_SdtGxMap_Line_Point_Pointlat ;
   protected String gxTv_SdtGxMap_Line_Point_Pointlong ;
}

