package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDynamicField extends GxUserType
{
   public SdtDynamicField( )
   {
      this(  new ModelContext(SdtDynamicField.class));
   }

   public SdtDynamicField( ModelContext context )
   {
      super( context, "SdtDynamicField");
   }

   public SdtDynamicField( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtDynamicField");
   }

   public SdtDynamicField( StructSdtDynamicField struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldId") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldid = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldName") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldDescription") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfielddescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldValue") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldvalue = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldValueNumeric") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldValueDecimal") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldValueCheck") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldValueDate") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate = GXutil.nullDate() ;
                  gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N = (byte)(0) ;
                  gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldType") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldtype = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldComboValues") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldEnabled") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldenabled = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldRequired") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldrequired = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldClass") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldDescriptionClass") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MDFDynamicFieldSingleLine") )
            {
               gxTv_SdtDynamicField_Mdfdynamicfieldsingleline = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "DynamicField" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "Mujer_Morena" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("MDFDynamicFieldId", GXutil.trim( GXutil.str( gxTv_SdtDynamicField_Mdfdynamicfieldid, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldName", gxTv_SdtDynamicField_Mdfdynamicfieldname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldDescription", gxTv_SdtDynamicField_Mdfdynamicfielddescription);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldValue", gxTv_SdtDynamicField_Mdfdynamicfieldvalue);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldValueNumeric", GXutil.trim( GXutil.str( gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric, 7, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldValueDecimal", GXutil.trim( GXutil.strNoRound( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal, 9, 2)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldValueCheck", GXutil.booltostr( gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate)) && ( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N == 1 ) )
      {
         oWriter.writeElement("MDFDynamicFieldValueDate", "");
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("MDFDynamicFieldValueDate", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
      }
      oWriter.writeElement("MDFDynamicFieldType", GXutil.trim( GXutil.str( gxTv_SdtDynamicField_Mdfdynamicfieldtype, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldComboValues", gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldEnabled", GXutil.booltostr( gxTv_SdtDynamicField_Mdfdynamicfieldenabled));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldRequired", GXutil.booltostr( gxTv_SdtDynamicField_Mdfdynamicfieldrequired));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldClass", gxTv_SdtDynamicField_Mdfdynamicfieldclass);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldDescriptionClass", gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("MDFDynamicFieldSingleLine", GXutil.booltostr( gxTv_SdtDynamicField_Mdfdynamicfieldsingleline));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("MDFDynamicFieldId", gxTv_SdtDynamicField_Mdfdynamicfieldid, false, false);
      AddObjectProperty("MDFDynamicFieldName", gxTv_SdtDynamicField_Mdfdynamicfieldname, false, false);
      AddObjectProperty("MDFDynamicFieldDescription", gxTv_SdtDynamicField_Mdfdynamicfielddescription, false, false);
      AddObjectProperty("MDFDynamicFieldValue", gxTv_SdtDynamicField_Mdfdynamicfieldvalue, false, false);
      AddObjectProperty("MDFDynamicFieldValueNumeric", gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric, false, false);
      AddObjectProperty("MDFDynamicFieldValueDecimal", gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal, false, false);
      AddObjectProperty("MDFDynamicFieldValueCheck", gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("MDFDynamicFieldValueDate", sDateCnv, false, false);
      AddObjectProperty("MDFDynamicFieldType", gxTv_SdtDynamicField_Mdfdynamicfieldtype, false, false);
      AddObjectProperty("MDFDynamicFieldComboValues", gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues, false, false);
      AddObjectProperty("MDFDynamicFieldEnabled", gxTv_SdtDynamicField_Mdfdynamicfieldenabled, false, false);
      AddObjectProperty("MDFDynamicFieldRequired", gxTv_SdtDynamicField_Mdfdynamicfieldrequired, false, false);
      AddObjectProperty("MDFDynamicFieldClass", gxTv_SdtDynamicField_Mdfdynamicfieldclass, false, false);
      AddObjectProperty("MDFDynamicFieldDescriptionClass", gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass, false, false);
      AddObjectProperty("MDFDynamicFieldSingleLine", gxTv_SdtDynamicField_Mdfdynamicfieldsingleline, false, false);
   }

   public int getgxTv_SdtDynamicField_Mdfdynamicfieldid( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldid ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldid( int value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldid = value ;
   }

   public String getgxTv_SdtDynamicField_Mdfdynamicfieldname( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldname ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldname( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldname = value ;
   }

   public String getgxTv_SdtDynamicField_Mdfdynamicfielddescription( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfielddescription ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfielddescription( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescription = value ;
   }

   public String getgxTv_SdtDynamicField_Mdfdynamicfieldvalue( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvalue ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvalue( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvalue = value ;
   }

   public int getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric( int value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric = value ;
   }

   public java.math.BigDecimal getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal( java.math.BigDecimal value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal = value ;
   }

   public boolean getgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck = value ;
   }

   public java.util.Date getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate( java.util.Date value )
   {
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N = (byte)(0) ;
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate = value ;
   }

   public byte getgxTv_SdtDynamicField_Mdfdynamicfieldtype( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldtype ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldtype( byte value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldtype = value ;
   }

   public String getgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues = value ;
   }

   public boolean getgxTv_SdtDynamicField_Mdfdynamicfieldenabled( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldenabled ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldenabled( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldenabled = value ;
   }

   public boolean getgxTv_SdtDynamicField_Mdfdynamicfieldrequired( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldrequired ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldrequired( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldrequired = value ;
   }

   public String getgxTv_SdtDynamicField_Mdfdynamicfieldclass( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldclass ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldclass( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldclass = value ;
   }

   public String getgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass( String value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass = value ;
   }

   public boolean getgxTv_SdtDynamicField_Mdfdynamicfieldsingleline( )
   {
      return gxTv_SdtDynamicField_Mdfdynamicfieldsingleline ;
   }

   public void setgxTv_SdtDynamicField_Mdfdynamicfieldsingleline( boolean value )
   {
      gxTv_SdtDynamicField_N = (byte)(0) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldsingleline = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDynamicField_N = (byte)(1) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldname = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescription = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvalue = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal = DecimalUtil.ZERO ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate = GXutil.nullDate() ;
      gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N = (byte)(1) ;
      gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfieldenabled = true ;
      gxTv_SdtDynamicField_Mdfdynamicfieldclass = "" ;
      gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtDynamicField_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtDynamicField Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtDynamicField)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtDynamicField struct )
   {
      setgxTv_SdtDynamicField_Mdfdynamicfieldid(struct.getMdfdynamicfieldid());
      setgxTv_SdtDynamicField_Mdfdynamicfieldname(struct.getMdfdynamicfieldname());
      setgxTv_SdtDynamicField_Mdfdynamicfielddescription(struct.getMdfdynamicfielddescription());
      setgxTv_SdtDynamicField_Mdfdynamicfieldvalue(struct.getMdfdynamicfieldvalue());
      setgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric(struct.getMdfdynamicfieldvaluenumeric());
      setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal(struct.getMdfdynamicfieldvaluedecimal());
      setgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck(struct.getMdfdynamicfieldvaluecheck());
      if ( struct.gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N == 0 )
      {
         setgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate(struct.getMdfdynamicfieldvaluedate());
      }
      setgxTv_SdtDynamicField_Mdfdynamicfieldtype(struct.getMdfdynamicfieldtype());
      setgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues(struct.getMdfdynamicfieldcombovalues());
      setgxTv_SdtDynamicField_Mdfdynamicfieldenabled(struct.getMdfdynamicfieldenabled());
      setgxTv_SdtDynamicField_Mdfdynamicfieldrequired(struct.getMdfdynamicfieldrequired());
      setgxTv_SdtDynamicField_Mdfdynamicfieldclass(struct.getMdfdynamicfieldclass());
      setgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass(struct.getMdfdynamicfielddescriptionclass());
      setgxTv_SdtDynamicField_Mdfdynamicfieldsingleline(struct.getMdfdynamicfieldsingleline());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtDynamicField getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtDynamicField struct = new com.mujermorena.workwithplus.nativemobile.StructSdtDynamicField ();
      struct.setMdfdynamicfieldid(getgxTv_SdtDynamicField_Mdfdynamicfieldid());
      struct.setMdfdynamicfieldname(getgxTv_SdtDynamicField_Mdfdynamicfieldname());
      struct.setMdfdynamicfielddescription(getgxTv_SdtDynamicField_Mdfdynamicfielddescription());
      struct.setMdfdynamicfieldvalue(getgxTv_SdtDynamicField_Mdfdynamicfieldvalue());
      struct.setMdfdynamicfieldvaluenumeric(getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric());
      struct.setMdfdynamicfieldvaluedecimal(getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal());
      struct.setMdfdynamicfieldvaluecheck(getgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck());
      if ( gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N == 0 )
      {
         struct.setMdfdynamicfieldvaluedate(getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate());
      }
      struct.setMdfdynamicfieldtype(getgxTv_SdtDynamicField_Mdfdynamicfieldtype());
      struct.setMdfdynamicfieldcombovalues(getgxTv_SdtDynamicField_Mdfdynamicfieldcombovalues());
      struct.setMdfdynamicfieldenabled(getgxTv_SdtDynamicField_Mdfdynamicfieldenabled());
      struct.setMdfdynamicfieldrequired(getgxTv_SdtDynamicField_Mdfdynamicfieldrequired());
      struct.setMdfdynamicfieldclass(getgxTv_SdtDynamicField_Mdfdynamicfieldclass());
      struct.setMdfdynamicfielddescriptionclass(getgxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass());
      struct.setMdfdynamicfieldsingleline(getgxTv_SdtDynamicField_Mdfdynamicfieldsingleline());
      return struct ;
   }

   protected byte gxTv_SdtDynamicField_N ;
   protected byte gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate_N ;
   protected byte gxTv_SdtDynamicField_Mdfdynamicfieldtype ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtDynamicField_Mdfdynamicfieldid ;
   protected int gxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric ;
   protected java.math.BigDecimal gxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldname ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfielddescription ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldvalue ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldcombovalues ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfieldclass ;
   protected String gxTv_SdtDynamicField_Mdfdynamicfielddescriptionclass ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtDynamicField_Mdfdynamicfieldvaluedate ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldenabled ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldrequired ;
   protected boolean gxTv_SdtDynamicField_Mdfdynamicfieldsingleline ;
   protected boolean readElement ;
   protected boolean formatError ;
}

