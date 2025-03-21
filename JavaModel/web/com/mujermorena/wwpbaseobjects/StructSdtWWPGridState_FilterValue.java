package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPGridState_FilterValue implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState_FilterValue( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState_FilterValue.class ));
   }

   public StructSdtWWPGridState_FilterValue( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtWWPGridState_FilterValue_Name = "" ;
      gxTv_SdtWWPGridState_FilterValue_Dsc = "" ;
      gxTv_SdtWWPGridState_FilterValue_Value = "" ;
      gxTv_SdtWWPGridState_FilterValue_Valueto = "" ;
      gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(1) ;
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

   public String getName( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Name ;
   }

   public void setName( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Name = value ;
   }

   public String getDsc( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Dsc ;
   }

   public void setDsc( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Dsc = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Value = value ;
   }

   public short getOperator( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Operator ;
   }

   public void setOperator( short value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Operator = value ;
   }

   public String getValueto( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Valueto ;
   }

   public void setValueto( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Valueto = value ;
   }

   protected byte gxTv_SdtWWPGridState_FilterValue_Dsc_N ;
   protected byte gxTv_SdtWWPGridState_FilterValue_N ;
   protected short gxTv_SdtWWPGridState_FilterValue_Operator ;
   protected String gxTv_SdtWWPGridState_FilterValue_Name ;
   protected String gxTv_SdtWWPGridState_FilterValue_Dsc ;
   protected String gxTv_SdtWWPGridState_FilterValue_Value ;
   protected String gxTv_SdtWWPGridState_FilterValue_Valueto ;
}

