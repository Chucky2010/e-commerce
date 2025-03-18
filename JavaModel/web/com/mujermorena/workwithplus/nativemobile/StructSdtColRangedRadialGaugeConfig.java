package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "ColRangedRadialGaugeConfig", namespace ="Mujer_Morena")
public final  class StructSdtColRangedRadialGaugeConfig implements Cloneable, java.io.Serializable
{
   public StructSdtColRangedRadialGaugeConfig( )
   {
      this( -1, new ModelContext( StructSdtColRangedRadialGaugeConfig.class ));
   }

   public StructSdtColRangedRadialGaugeConfig( int remoteHandle ,
                                               ModelContext context )
   {
   }

   public  StructSdtColRangedRadialGaugeConfig( java.util.Vector<StructSdtRangedRadialGaugeConfig> value )
   {
      item = value;
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

   @jakarta.xml.bind.annotation.XmlElement(name="RangedRadialGaugeConfig",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtRangedRadialGaugeConfig> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtRangedRadialGaugeConfig> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtRangedRadialGaugeConfig> item = new java.util.Vector<>();
}

