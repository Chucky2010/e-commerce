package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtDynamicField implements Cloneable, java.io.Serializable
{
   public StructSdtDynamicField( )
   {
      this( -1, new ModelContext( StructSdtDynamicField.class ));
   }

   public StructSdtDynamicField( int remoteHandle ,
                                 ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtDynamicField_Mdfdynamicfieldname = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescription = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvalue = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal = new java.math.BigDecimal(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate = cal.getTime() ;
      gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldenabled = true ;
      gxTv_SdtDynamicField_Mdfdynamicfieldclass = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N = (byte)(1) ;
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

   public int getMdfdynamicfieldid( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldid ;
   }

   public void setMdfdynamicfieldid( int value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldid = value ;
   }

   public String getMdfdynamicfieldname( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldname ;
   }

   public void setMdfdynamicfieldname( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldname = value ;
   }

   public String getMdfdynamicfielddescription( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfielddescription ;
   }

   public void setMdfdynamicfielddescription( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescription = value ;
   }

   public String getMdfdynamicfieldvalue( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvalue ;
   }

   public void setMdfdynamicfieldvalue( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvalue = value ;
   }

   public int getMdfdynamicfieldvaluenumeric( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric ;
   }

   public void setMdfdynamicfieldvaluenumeric( int value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric = value ;
   }

   public java.math.BigDecimal getMdfdynamicfieldvaluedecimal( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal ;
   }

   public void setMdfdynamicfieldvaluedecimal( java.math.BigDecimal value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal = value ;
   }

   public boolean getMdfdynamicfieldvaluecheck( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck ;
   }

   public void setMdfdynamicfieldvaluecheck( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck = value ;
   }

   public java.util.Date getMdfdynamicfieldvaluedate( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate ;
   }

   public void setMdfdynamicfieldvaluedate( java.util.Date value )
   {
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N = (byte)(0) ;
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate = value ;
   }

   public byte getMdfdynamicfieldtype( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldtype ;
   }

   public void setMdfdynamicfieldtype( byte value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldtype = value ;
   }

   public String getMdfdynamicfieldcombovalues( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues ;
   }

   public void setMdfdynamicfieldcombovalues( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues = value ;
   }

   public boolean getMdfdynamicfieldenabled( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldenabled ;
   }

   public void setMdfdynamicfieldenabled( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldenabled = value ;
   }

   public boolean getMdfdynamicfieldrequired( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldrequired ;
   }

   public void setMdfdynamicfieldrequired( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldrequired = value ;
   }

   public String getMdfdynamicfieldclass( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldclass ;
   }

   public void setMdfdynamicfieldclass( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldclass = value ;
   }

   public String getMdfdynamicfielddescriptionclass( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass ;
   }

   public void setMdfdynamicfielddescriptionclass( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass = value ;
   }

   public boolean getMdfdynamicfieldsingleline( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldsingleline ;
   }

   public void setMdfdynamicfieldsingleline( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldsingleline = value ;
   }

   protected byte gxTv_SdtDynamicField_Mdfdynamicfieldtype ;
   protected byte gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N ;
   protected byte gxTv_SdtDynamicField_N ;
   protected int gxTv_SdtDynamicField_Mdfdynamicfieldid ;
   protected int gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldname ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfielddescription ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldvalue ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldclass ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldenabled ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldrequired ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldsingleline ;
   protected java.math.BigDecimal gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal ;
   protected java.util.Date gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate ;
}

