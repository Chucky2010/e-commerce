package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPGridState_DynamicFilter extends GxUserType
{
   public SdtWWPGridState_DynamicFilter( )
   {
      this(  new ModelContext(SdtWWPGridState_DynamicFilter.class));
   }

   public SdtWWPGridState_DynamicFilter( ModelContext context )
   {
      super( context, "SdtWWPGridState_DynamicFilter");
   }

   public SdtWWPGridState_DynamicFilter( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPGridState_DynamicFilter");
   }

   public SdtWWPGridState_DynamicFilter( StructSdtWWPGridState_DynamicFilter struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
      mapper.put( "d" ,  "Dsc" );
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Selected") )
            {
               gxTv_SdtWWPGridState_DynamicFilter_Selected = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Dsc") )
            {
               gxTv_SdtWWPGridState_DynamicFilter_Dsc = oReader.getValue() ;
               gxTv_SdtWWPGridState_DynamicFilter_Dsc_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtWWPGridState_DynamicFilter_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Operator") )
            {
               gxTv_SdtWWPGridState_DynamicFilter_Operator = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValueTo") )
            {
               gxTv_SdtWWPGridState_DynamicFilter_Valueto = oReader.getValue() ;
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
         sName = "WWPGridState.DynamicFilter" ;
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
      oWriter.writeElement("Selected", gxTv_SdtWWPGridState_DynamicFilter_Selected);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_DynamicFilter_Dsc)==0) || ( gxTv_SdtWWPGridState_DynamicFilter_Dsc_N != 1 ) )
      {
         oWriter.writeElement("Dsc", gxTv_SdtWWPGridState_DynamicFilter_Dsc);
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
      }
      oWriter.writeElement("Value", gxTv_SdtWWPGridState_DynamicFilter_Value);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Operator", GXutil.trim( GXutil.str( gxTv_SdtWWPGridState_DynamicFilter_Operator, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ValueTo", gxTv_SdtWWPGridState_DynamicFilter_Valueto);
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
      AddObjectProperty("Selected", gxTv_SdtWWPGridState_DynamicFilter_Selected, false, false);
      AddObjectProperty("d", gxTv_SdtWWPGridState_DynamicFilter_Dsc, false, false);
      AddObjectProperty("Value", gxTv_SdtWWPGridState_DynamicFilter_Value, false, false);
      AddObjectProperty("Operator", gxTv_SdtWWPGridState_DynamicFilter_Operator, false, false);
      AddObjectProperty("ValueTo", gxTv_SdtWWPGridState_DynamicFilter_Valueto, false, false);
   }

   public String getgxTv_SdtWWPGridState_DynamicFilter_Selected( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Selected ;
   }

   public void setgxTv_SdtWWPGridState_DynamicFilter_Selected( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Selected = value ;
   }

   public String getgxTv_SdtWWPGridState_DynamicFilter_Dsc( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Dsc ;
   }

   public void setgxTv_SdtWWPGridState_DynamicFilter_Dsc( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Dsc_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Dsc = value ;
   }

   public String getgxTv_SdtWWPGridState_DynamicFilter_Value( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Value ;
   }

   public void setgxTv_SdtWWPGridState_DynamicFilter_Value( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Value = value ;
   }

   public short getgxTv_SdtWWPGridState_DynamicFilter_Operator( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Operator ;
   }

   public void setgxTv_SdtWWPGridState_DynamicFilter_Operator( short value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Operator = value ;
   }

   public String getgxTv_SdtWWPGridState_DynamicFilter_Valueto( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Valueto ;
   }

   public void setgxTv_SdtWWPGridState_DynamicFilter_Valueto( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valueto = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Selected = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_N = (byte)(1) ;
      gxTv_SdtWWPGridState_DynamicFilter_Dsc = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Dsc_N = (byte)(1) ;
      gxTv_SdtWWPGridState_DynamicFilter_Value = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Valueto = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtWWPGridState_DynamicFilter Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtWWPGridState_DynamicFilter)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter struct )
   {
      setgxTv_SdtWWPGridState_DynamicFilter_Selected(struct.getSelected());
      if ( struct.gxTv_SdtWWPGridState_DynamicFilter_Dsc_N == 0 )
      {
         setgxTv_SdtWWPGridState_DynamicFilter_Dsc(struct.getDsc());
      }
      setgxTv_SdtWWPGridState_DynamicFilter_Value(struct.getValue());
      setgxTv_SdtWWPGridState_DynamicFilter_Operator(struct.getOperator());
      setgxTv_SdtWWPGridState_DynamicFilter_Valueto(struct.getValueto());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter struct = new com.mujermorena.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter ();
      struct.setSelected(getgxTv_SdtWWPGridState_DynamicFilter_Selected());
      if ( gxTv_SdtWWPGridState_DynamicFilter_Dsc_N == 0 )
      {
         struct.setDsc(getgxTv_SdtWWPGridState_DynamicFilter_Dsc());
      }
      struct.setValue(getgxTv_SdtWWPGridState_DynamicFilter_Value());
      struct.setOperator(getgxTv_SdtWWPGridState_DynamicFilter_Operator());
      struct.setValueto(getgxTv_SdtWWPGridState_DynamicFilter_Valueto());
      return struct ;
   }

   protected byte gxTv_SdtWWPGridState_DynamicFilter_N ;
   protected byte gxTv_SdtWWPGridState_DynamicFilter_Dsc_N ;
   protected short gxTv_SdtWWPGridState_DynamicFilter_Operator ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Selected ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Dsc ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Value ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Valueto ;
}

