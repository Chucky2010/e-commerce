package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWizardAuxiliarData_WizardAuxiliarDataItem extends GxUserType
{
   public SdtWizardAuxiliarData_WizardAuxiliarDataItem( )
   {
      this(  new ModelContext(SdtWizardAuxiliarData_WizardAuxiliarDataItem.class));
   }

   public SdtWizardAuxiliarData_WizardAuxiliarDataItem( ModelContext context )
   {
      super( context, "SdtWizardAuxiliarData_WizardAuxiliarDataItem");
   }

   public SdtWizardAuxiliarData_WizardAuxiliarDataItem( int remoteHandle ,
                                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtWizardAuxiliarData_WizardAuxiliarDataItem");
   }

   public SdtWizardAuxiliarData_WizardAuxiliarDataItem( StructSdtWizardAuxiliarData_WizardAuxiliarDataItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Key") )
            {
               gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value = oReader.getValue() ;
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
         sName = "WizardAuxiliarData.WizardAuxiliarDataItem" ;
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
      oWriter.writeElement("Key", gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Value", gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("Key", gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key, false, false);
      AddObjectProperty("Value", gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value, false, false);
   }

   public String getgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key( )
   {
      return gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key ;
   }

   public void setgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key( String value )
   {
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N = (byte)(0) ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key = value ;
   }

   public String getgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value( )
   {
      return gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value ;
   }

   public void setgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value( String value )
   {
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N = (byte)(0) ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key = "" ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N = (byte)(1) ;
      gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem struct )
   {
      setgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key(struct.getKey());
      setgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value(struct.getValue());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem struct = new com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem ();
      struct.setKey(getgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key());
      struct.setValue(getgxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value());
      return struct ;
   }

   protected byte gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Value ;
   protected String gxTv_SdtWizardAuxiliarData_WizardAuxiliarDataItem_Key ;
}

