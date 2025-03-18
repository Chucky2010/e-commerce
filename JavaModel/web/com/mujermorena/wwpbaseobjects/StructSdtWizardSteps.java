package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

@jakarta.xml.bind.annotation.XmlType(name = "WizardSteps", namespace ="Mujer_Morena")
public final  class StructSdtWizardSteps implements Cloneable, java.io.Serializable
{
   public StructSdtWizardSteps( )
   {
      this( -1, new ModelContext( StructSdtWizardSteps.class ));
   }

   public StructSdtWizardSteps( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtWizardSteps( java.util.Vector<StructSdtWizardSteps_WizardStepsItem> value )
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

   @jakarta.xml.bind.annotation.XmlElement(name="WizardStepsItem",namespace="Mujer_Morena")
   public java.util.Vector<StructSdtWizardSteps_WizardStepsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWizardSteps_WizardStepsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWizardSteps_WizardStepsItem> item = new java.util.Vector<>();
}

