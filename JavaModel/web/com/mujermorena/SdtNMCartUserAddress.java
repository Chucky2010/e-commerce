package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtNMCartUserAddress extends GxUserType
{
   public SdtNMCartUserAddress( )
   {
      this(  new ModelContext(SdtNMCartUserAddress.class));
   }

   public SdtNMCartUserAddress( ModelContext context )
   {
      super( context, "SdtNMCartUserAddress");
   }

   public SdtNMCartUserAddress( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtNMCartUserAddress");
   }

   public SdtNMCartUserAddress( StructSdtNMCartUserAddress struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PersonName") )
            {
               gxTv_SdtNMCartUserAddress_Personname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AddressLine1") )
            {
               gxTv_SdtNMCartUserAddress_Addressline1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AddressLine2") )
            {
               gxTv_SdtNMCartUserAddress_Addressline2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryName") )
            {
               gxTv_SdtNMCartUserAddress_Countryname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "StateName") )
            {
               gxTv_SdtNMCartUserAddress_Statename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PhoneNumber") )
            {
               gxTv_SdtNMCartUserAddress_Phonenumber = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Ubicacion") )
            {
               gxTv_SdtNMCartUserAddress_Ubicacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtNMCartUserAddress_Id = oReader.getValue() ;
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
         sName = "NMCartUserAddress" ;
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
      oWriter.writeElement("PersonName", gxTv_SdtNMCartUserAddress_Personname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("AddressLine1", gxTv_SdtNMCartUserAddress_Addressline1);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("AddressLine2", gxTv_SdtNMCartUserAddress_Addressline2);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("CountryName", gxTv_SdtNMCartUserAddress_Countryname);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("StateName", gxTv_SdtNMCartUserAddress_Statename);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PhoneNumber", gxTv_SdtNMCartUserAddress_Phonenumber);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Ubicacion", gxTv_SdtNMCartUserAddress_Ubicacion);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Id", gxTv_SdtNMCartUserAddress_Id);
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
      AddObjectProperty("PersonName", gxTv_SdtNMCartUserAddress_Personname, false, false);
      AddObjectProperty("AddressLine1", gxTv_SdtNMCartUserAddress_Addressline1, false, false);
      AddObjectProperty("AddressLine2", gxTv_SdtNMCartUserAddress_Addressline2, false, false);
      AddObjectProperty("CountryName", gxTv_SdtNMCartUserAddress_Countryname, false, false);
      AddObjectProperty("StateName", gxTv_SdtNMCartUserAddress_Statename, false, false);
      AddObjectProperty("PhoneNumber", gxTv_SdtNMCartUserAddress_Phonenumber, false, false);
      AddObjectProperty("Ubicacion", gxTv_SdtNMCartUserAddress_Ubicacion, false, false);
      AddObjectProperty("Id", gxTv_SdtNMCartUserAddress_Id, false, false);
   }

   public String getgxTv_SdtNMCartUserAddress_Personname( )
   {
      return gxTv_SdtNMCartUserAddress_Personname ;
   }

   public void setgxTv_SdtNMCartUserAddress_Personname( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Personname = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Addressline1( )
   {
      return gxTv_SdtNMCartUserAddress_Addressline1 ;
   }

   public void setgxTv_SdtNMCartUserAddress_Addressline1( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Addressline1 = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Addressline2( )
   {
      return gxTv_SdtNMCartUserAddress_Addressline2 ;
   }

   public void setgxTv_SdtNMCartUserAddress_Addressline2( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Addressline2 = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Countryname( )
   {
      return gxTv_SdtNMCartUserAddress_Countryname ;
   }

   public void setgxTv_SdtNMCartUserAddress_Countryname( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Countryname = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Statename( )
   {
      return gxTv_SdtNMCartUserAddress_Statename ;
   }

   public void setgxTv_SdtNMCartUserAddress_Statename( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Statename = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Phonenumber( )
   {
      return gxTv_SdtNMCartUserAddress_Phonenumber ;
   }

   public void setgxTv_SdtNMCartUserAddress_Phonenumber( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Phonenumber = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Ubicacion( )
   {
      return gxTv_SdtNMCartUserAddress_Ubicacion ;
   }

   public void setgxTv_SdtNMCartUserAddress_Ubicacion( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Ubicacion = value ;
   }

   public String getgxTv_SdtNMCartUserAddress_Id( )
   {
      return gxTv_SdtNMCartUserAddress_Id ;
   }

   public void setgxTv_SdtNMCartUserAddress_Id( String value )
   {
      gxTv_SdtNMCartUserAddress_N = (byte)(0) ;
      gxTv_SdtNMCartUserAddress_Id = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtNMCartUserAddress_Personname = "" ;
      gxTv_SdtNMCartUserAddress_N = (byte)(1) ;
      gxTv_SdtNMCartUserAddress_Addressline1 = "" ;
      gxTv_SdtNMCartUserAddress_Addressline2 = "" ;
      gxTv_SdtNMCartUserAddress_Countryname = "" ;
      gxTv_SdtNMCartUserAddress_Statename = "" ;
      gxTv_SdtNMCartUserAddress_Phonenumber = "" ;
      gxTv_SdtNMCartUserAddress_Ubicacion = "" ;
      gxTv_SdtNMCartUserAddress_Id = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtNMCartUserAddress_N ;
   }

   public com.mujermorena.SdtNMCartUserAddress Clone( )
   {
      return (com.mujermorena.SdtNMCartUserAddress)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtNMCartUserAddress struct )
   {
      setgxTv_SdtNMCartUserAddress_Personname(struct.getPersonname());
      setgxTv_SdtNMCartUserAddress_Addressline1(struct.getAddressline1());
      setgxTv_SdtNMCartUserAddress_Addressline2(struct.getAddressline2());
      setgxTv_SdtNMCartUserAddress_Countryname(struct.getCountryname());
      setgxTv_SdtNMCartUserAddress_Statename(struct.getStatename());
      setgxTv_SdtNMCartUserAddress_Phonenumber(struct.getPhonenumber());
      setgxTv_SdtNMCartUserAddress_Ubicacion(struct.getUbicacion());
      setgxTv_SdtNMCartUserAddress_Id(struct.getId());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtNMCartUserAddress getStruct( )
   {
      com.mujermorena.StructSdtNMCartUserAddress struct = new com.mujermorena.StructSdtNMCartUserAddress ();
      struct.setPersonname(getgxTv_SdtNMCartUserAddress_Personname());
      struct.setAddressline1(getgxTv_SdtNMCartUserAddress_Addressline1());
      struct.setAddressline2(getgxTv_SdtNMCartUserAddress_Addressline2());
      struct.setCountryname(getgxTv_SdtNMCartUserAddress_Countryname());
      struct.setStatename(getgxTv_SdtNMCartUserAddress_Statename());
      struct.setPhonenumber(getgxTv_SdtNMCartUserAddress_Phonenumber());
      struct.setUbicacion(getgxTv_SdtNMCartUserAddress_Ubicacion());
      struct.setId(getgxTv_SdtNMCartUserAddress_Id());
      return struct ;
   }

   protected byte gxTv_SdtNMCartUserAddress_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtNMCartUserAddress_Phonenumber ;
   protected String gxTv_SdtNMCartUserAddress_Ubicacion ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtNMCartUserAddress_Personname ;
   protected String gxTv_SdtNMCartUserAddress_Addressline1 ;
   protected String gxTv_SdtNMCartUserAddress_Addressline2 ;
   protected String gxTv_SdtNMCartUserAddress_Countryname ;
   protected String gxTv_SdtNMCartUserAddress_Statename ;
   protected String gxTv_SdtNMCartUserAddress_Id ;
}

