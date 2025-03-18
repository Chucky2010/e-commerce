package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWizardAuxiliarData_WizardAuxiliarDataItem implements Cloneable, java.io.Serializable
{
   public StructSdtWizardAuxiliarData_WizardAuxiliarDataItem( )
   {
      this( -1, new ModelContext( StructSdtWizardAuxiliarData_WizardAuxiliarDataItem.class ));
   }

   public StructSdtWizardAuxiliarData_WizardAuxiliarDataItem( int remoteHandle ,
                                                              ModelContext context )
   {
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key = "" ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value = "" ;
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

   public String getKey( )
   {
      return gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key ;
   }

   public void setKey( String value )
   {
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N = (byte)(0) ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value ;
   }

   public void setValue( String value )
   {
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N = (byte)(0) ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value = value ;
   }

   protected byte gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N ;
   protected String gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value ;
   protected String gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key ;
}

