package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPGridState_FilterValue extends GxUserType
{
   public SdtWWPGridState_FilterValue( )
   {
      this(  new ModelContext(SdtWWPGridState_FilterValue.class));
   }

   public SdtWWPGridState_FilterValue( ModelContext context )
   {
      super( context, "SdtWWPGridState_FilterValue");
   }

   public SdtWWPGridState_FilterValue( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPGridState_FilterValue");
   }

   public SdtWWPGridState_FilterValue( StructSdtWWPGridState_FilterValue struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtWWPGridState_FilterValue_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Dsc") )
            {
               gxTv_SdtWWPGridState_FilterValue_Dsc = oReader.getValue() ;
               gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtWWPGridState_FilterValue_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Operator") )
            {
               gxTv_SdtWWPGridState_FilterValue_Operator = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValueTo") )
            {
               gxTv_SdtWWPGridState_FilterValue_Valueto = oReader.getValue() ;
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
         sName = "WWPGridState.FilterValue" ;
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
      oWriter.writeElement("Name", gxTv_SdtWWPGridState_FilterValue_Name);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_FilterValue_Dsc)==0) || ( gxTv_SdtWWPGridState_FilterValue_Dsc_N != 1 ) )
      {
         oWriter.writeElement("Dsc", gxTv_SdtWWPGridState_FilterValue_Dsc);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
      }
      oWriter.writeElement("Value", gxTv_SdtWWPGridState_FilterValue_Value);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Operator", GXutil.trim( GXutil.str( gxTv_SdtWWPGridState_FilterValue_Operator, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ValueTo", gxTv_SdtWWPGridState_FilterValue_Valueto);
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
      AddObjectProperty("Name", gxTv_SdtWWPGridState_FilterValue_Name, false, false);
      AddObjectProperty("Dsc", gxTv_SdtWWPGridState_FilterValue_Dsc, false, false);
      AddObjectProperty("Value", gxTv_SdtWWPGridState_FilterValue_Value, false, false);
      AddObjectProperty("Operator", gxTv_SdtWWPGridState_FilterValue_Operator, false, false);
      AddObjectProperty("ValueTo", gxTv_SdtWWPGridState_FilterValue_Valueto, false, false);
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Name( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Name ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Name( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Name = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Dsc( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Dsc ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Dsc( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Dsc = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Value( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Value ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Value( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Value = value ;
   }

   public short getgxTv_SdtWWPGridState_FilterValue_Operator( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Operator ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Operator( short value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Operator = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Valueto( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Valueto ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Valueto( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Valueto = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPGridState_FilterValue_Name = "" ;
      gxTv_SdtWWPGridState_FilterValue_N = (byte)(1) ;
      gxTv_SdtWWPGridState_FilterValue_Dsc = "" ;
      gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(1) ;
      gxTv_SdtWWPGridState_FilterValue_Value = "" ;
      gxTv_SdtWWPGridState_FilterValue_Valueto = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPGridState_FilterValue_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_FilterValue struct )
   {
      setgxTv_SdtWWPGridState_FilterValue_Name(struct.getName());
      if ( struct.gxTv_SdtWWPGridState_FilterValue_Dsc_N == 0 )
      {
         setgxTv_SdtWWPGridState_FilterValue_Dsc(struct.getDsc());
      }
      setgxTv_SdtWWPGridState_FilterValue_Value(struct.getValue());
      setgxTv_SdtWWPGridState_FilterValue_Operator(struct.getOperator());
      setgxTv_SdtWWPGridState_FilterValue_Valueto(struct.getValueto());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_FilterValue getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_FilterValue struct = new com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_FilterValue ();
      struct.setName(getgxTv_SdtWWPGridState_FilterValue_Name());
      if ( gxTv_SdtWWPGridState_FilterValue_Dsc_N == 0 )
      {
         struct.setDsc(getgxTv_SdtWWPGridState_FilterValue_Dsc());
      }
      struct.setValue(getgxTv_SdtWWPGridState_FilterValue_Value());
      struct.setOperator(getgxTv_SdtWWPGridState_FilterValue_Operator());
      struct.setValueto(getgxTv_SdtWWPGridState_FilterValue_Valueto());
      return struct ;
   }

   protected byte gxTv_SdtWWPGridState_FilterValue_N ;
   protected byte gxTv_SdtWWPGridState_FilterValue_Dsc_N ;
   protected short gxTv_SdtWWPGridState_FilterValue_Operator ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPGridState_FilterValue_Name ;
   protected String gxTv_SdtWWPGridState_FilterValue_Dsc ;
   protected String gxTv_SdtWWPGridState_FilterValue_Value ;
   protected String gxTv_SdtWWPGridState_FilterValue_Valueto ;
}

