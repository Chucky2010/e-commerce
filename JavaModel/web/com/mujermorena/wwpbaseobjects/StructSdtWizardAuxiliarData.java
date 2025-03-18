package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "WizardAuxiliarData", namespace ="Mujer_Morena")
public final  class StructSdtWizardAuxiliarData implements Cloneable, java.io.Serializable
{
   public StructSdtWizardAuxiliarData( )
   {
      this( -1, new ModelContext( StructSdtWizardAuxiliarData.class ));
   }

   public StructSdtWizardAuxiliarData( int remoteHandle ,
                                       ModelContext context )
   {
   }

   public  StructSdtWizardAuxiliarData( java.util.Vector<StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WizardAuxiliarDataItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> item = new java.util.Vector<>();
}

