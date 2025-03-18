package com.mujermorena ;
import com.genexus.*;

public final  class StructSdtGxMap_Line implements Cloneable, java.io.Serializable
{
   public StructSdtGxMap_Line( )
   {
      this( -1, new ModelContext( StructSdtGxMap_Line.class ));
   }

   public StructSdtGxMap_Line( int remoteHandle ,
                               ModelContext context )
   {
      gxTv_SdtGxMap_Line_Linestrokecolor = "" ;
      gxTv_SdtGxMap_Line_Linestrokeopacity = new java.math.BigDecimal(0) ;
      gxTv_SdtGxMap_Line_Points_N = (byte)(1) ;
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

   public String getLinestrokecolor( )
   {
      return gxTv_SdtGxMap_Line_Linestrokecolor ;
   }

   public void setLinestrokecolor( String value )
   {
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Linestrokecolor = value ;
   }

   public java.math.BigDecimal getLinestrokeopacity( )
   {
      return gxTv_SdtGxMap_Line_Linestrokeopacity ;
   }

   public void setLinestrokeopacity( java.math.BigDecimal value )
   {
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Linestrokeopacity = value ;
   }

   public short getLinestrokeweight( )
   {
      return gxTv_SdtGxMap_Line_Linestrokeweight ;
   }

   public void setLinestrokeweight( short value )
   {
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Linestrokeweight = value ;
   }

   public java.util.Vector<com.mujermorena.StructSdtGxMap_Line_Point> getPoints( )
   {
      return gxTv_SdtGxMap_Line_Points ;
   }

   public void setPoints( java.util.Vector<com.mujermorena.StructSdtGxMap_Line_Point> value )
   {
      gxTv_SdtGxMap_Line_Points_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_N = (byte)(0) ;
      gxTv_SdtGxMap_Line_Points = value ;
   }

   protected byte gxTv_SdtGxMap_Line_Points_N ;
   protected byte gxTv_SdtGxMap_Line_N ;
   protected short gxTv_SdtGxMap_Line_Linestrokeweight ;
   protected String gxTv_SdtGxMap_Line_Linestrokecolor ;
   protected java.math.BigDecimal gxTv_SdtGxMap_Line_Linestrokeopacity ;
   protected java.util.Vector<com.mujermorena.StructSdtGxMap_Line_Point> gxTv_SdtGxMap_Line_Points=null ;
}

