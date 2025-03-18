package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "DynamicField", namespace ="Mujer_Morena")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtDynamicField_RESTInterface extends GxGenericCollectionItem<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>
{
   public SdtDynamicField_RESTInterface( )
   {
      super(new com.mujermorena.workwithplus.nativemobile.SdtDynamicField ());
   }

   public SdtDynamicField_RESTInterface( com.mujermorena.workwithplus.nativemobile.SdtDynamicField psdt )
   {
      super(psdt);
   }

   @JsonProperty("MDFDynamicFieldId")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldid( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtDynamicField_Mdfdynamicfieldid(), 8, 0)) ;
   }

   @JsonProperty("MDFDynamicFieldId")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldid(  String Value )
   {
      sdt.setgxTv_SdtDynamicField_Mdfdynamicfieldid( (int)(GXutil.lval( Value)) );
   }


   @JsonProperty("MDFDynamicFieldName")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldname( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldname()) ;
   }

   @JsonProperty("MDFDynamicFieldName")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldname(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldname(Value);
   }


   @JsonProperty("MDFDynamicFieldDescription")
   public String getgxTv_SdtDynamicField_Mdfdynamicfielddescription( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfielddescription()) ;
   }

   @JsonProperty("MDFDynamicFieldDescription")
   public void setgxTv_SdtDynamicField_Mdfdynamicfielddescription(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfielddescription(Value);
   }


   @JsonProperty("MDFDynamicFieldValue")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldvalue( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldvalue()) ;
   }

   @JsonProperty("MDFDynamicFieldValue")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvalue(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldvalue(Value);
   }


   @JsonProperty("MDFDynamicFieldValueNumeric")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric( )
   {
      return GXutil.ltrim( GXutil.str( sdt.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric(), 7, 0)) ;
   }

   @JsonProperty("MDFDynamicFieldValueNumeric")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric(  String Value )
   {
      sdt.setgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric( (int)(GXutil.lval( Value)) );
   }


   @JsonProperty("MDFDynamicFieldValueDecimal")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal( )
   {
      return GXutil.ltrim( GXutil.strNoRound( sdt.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal(), 9, 2)) ;
   }

   @JsonProperty("MDFDynamicFieldValueDecimal")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal(  String Value )
   {
      sdt.setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal( DecimalUtil.stringToDec( Value) );
   }


   @JsonProperty("MDFDynamicFieldValueCheck")
   public Boolean getgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck() ;
   }

   @JsonProperty("MDFDynamicFieldValueCheck")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck(  Boolean Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck(Value);
   }


   @JsonProperty("MDFDynamicFieldValueDate")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate( )
   {
      return GXutil.dateToCharREST( sdt.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate()) ;
   }

   @JsonProperty("MDFDynamicFieldValueDate")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate(  String Value )
   {
      sdt.setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate( GXutil.charToDateREST( Value) );
   }


   @JsonProperty("MDFDynamicFieldType")
   public Byte getgxTv_SdtDynamicField_Mdfdynamicfieldtype( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldtype() ;
   }

   @JsonProperty("MDFDynamicFieldType")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldtype(  Byte Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldtype(Value);
   }


   @JsonProperty("MDFDynamicFieldComboValues")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues()) ;
   }

   @JsonProperty("MDFDynamicFieldComboValues")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues(Value);
   }


   @JsonProperty("MDFDynamicFieldEnabled")
   public Boolean getgxTv_SdtDynamicField_Mdfdynamicfieldenabled( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldenabled() ;
   }

   @JsonProperty("MDFDynamicFieldEnabled")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldenabled(  Boolean Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldenabled(Value);
   }


   @JsonProperty("MDFDynamicFieldRequired")
   public Boolean getgxTv_SdtDynamicField_Mdfdynamicfieldrequired( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldrequired() ;
   }

   @JsonProperty("MDFDynamicFieldRequired")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldrequired(  Boolean Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldrequired(Value);
   }


   @JsonProperty("MDFDynamicFieldClass")
   public String getgxTv_SdtDynamicField_Mdfdynamicfieldclass( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldclass()) ;
   }

   @JsonProperty("MDFDynamicFieldClass")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldclass(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldclass(Value);
   }


   @JsonProperty("MDFDynamicFieldDescriptionClass")
   public String getgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass( )
   {
      return GXutil.rtrim(((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass()) ;
   }

   @JsonProperty("MDFDynamicFieldDescriptionClass")
   public void setgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass(  String Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass(Value);
   }


   @JsonProperty("MDFDynamicFieldSingleLine")
   public Boolean getgxTv_SdtDynamicField_Mdfdynamicfieldsingleline( )
   {
      return ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).getgxTv_SdtDynamicField_Mdfdynamicfieldsingleline() ;
   }

   @JsonProperty("MDFDynamicFieldSingleLine")
   public void setgxTv_SdtDynamicField_Mdfdynamicfieldsingleline(  Boolean Value )
   {
      ((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)getSdt()).setgxTv_SdtDynamicField_Mdfdynamicfieldsingleline(Value);
   }


   int remoteHandle = -1;
}

