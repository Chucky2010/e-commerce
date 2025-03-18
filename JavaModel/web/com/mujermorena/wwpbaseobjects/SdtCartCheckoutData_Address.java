package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCartCheckoutData_Address extends GxUserType
{
   public SdtCartCheckoutData_Address( )
   {
      this(  new ModelContext(SdtCartCheckoutData_Address.class));
   }

   public SdtCartCheckoutData_Address( ModelContext context )
   {
      super( context, "SdtCartCheckoutData_Address");
   }

   public SdtCartCheckoutData_Address( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtCartCheckoutData_Address");
   }

   public SdtCartCheckoutData_Address( StructSdtCartCheckoutData_Address struct )
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
               gxTv_SdtCartCheckoutData_Address_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Phone") )
            {
               gxTv_SdtCartCheckoutData_Address_Phone = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Country") )
            {
               gxTv_SdtCartCheckoutData_Address_Country = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Department") )
            {
               gxTv_SdtCartCheckoutData_Address_Department = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Address") )
            {
               gxTv_SdtCartCheckoutData_Address_Address = oReader.getValue() ;
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
         sName = "CartCheckoutData.Address" ;
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
      oWriter.writeElement("Name", gxTv_SdtCartCheckoutData_Address_Name);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Phone", gxTv_SdtCartCheckoutData_Address_Phone);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Country", gxTv_SdtCartCheckoutData_Address_Country);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Department", gxTv_SdtCartCheckoutData_Address_Department);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Address", gxTv_SdtCartCheckoutData_Address_Address);
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
      AddObjectProperty("Name", gxTv_SdtCartCheckoutData_Address_Name, false, false);
      AddObjectProperty("Phone", gxTv_SdtCartCheckoutData_Address_Phone, false, false);
      AddObjectProperty("Country", gxTv_SdtCartCheckoutData_Address_Country, false, false);
      AddObjectProperty("Department", gxTv_SdtCartCheckoutData_Address_Department, false, false);
      AddObjectProperty("Address", gxTv_SdtCartCheckoutData_Address_Address, false, false);
   }

   public String getgxTv_SdtCartCheckoutData_Address_Name( )
   {
      return gxTv_SdtCartCheckoutData_Address_Name ;
   }

   public void setgxTv_SdtCartCheckoutData_Address_Name( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Name = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Address_Phone( )
   {
      return gxTv_SdtCartCheckoutData_Address_Phone ;
   }

   public void setgxTv_SdtCartCheckoutData_Address_Phone( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Phone = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Address_Country( )
   {
      return gxTv_SdtCartCheckoutData_Address_Country ;
   }

   public void setgxTv_SdtCartCheckoutData_Address_Country( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Country = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Address_Department( )
   {
      return gxTv_SdtCartCheckoutData_Address_Department ;
   }

   public void setgxTv_SdtCartCheckoutData_Address_Department( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Department = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Address_Address( )
   {
      return gxTv_SdtCartCheckoutData_Address_Address ;
   }

   public void setgxTv_SdtCartCheckoutData_Address_Address( String value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address_Address = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCartCheckoutData_Address_Name = "" ;
      gxTv_SdtCartCheckoutData_Address_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Address_Phone = "" ;
      gxTv_SdtCartCheckoutData_Address_Country = "" ;
      gxTv_SdtCartCheckoutData_Address_Department = "" ;
      gxTv_SdtCartCheckoutData_Address_Address = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCartCheckoutData_Address_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address struct )
   {
      setgxTv_SdtCartCheckoutData_Address_Name(struct.getName());
      setgxTv_SdtCartCheckoutData_Address_Phone(struct.getPhone());
      setgxTv_SdtCartCheckoutData_Address_Country(struct.getCountry());
      setgxTv_SdtCartCheckoutData_Address_Department(struct.getDepartment());
      setgxTv_SdtCartCheckoutData_Address_Address(struct.getAddress());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address struct = new com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Address ();
      struct.setName(getgxTv_SdtCartCheckoutData_Address_Name());
      struct.setPhone(getgxTv_SdtCartCheckoutData_Address_Phone());
      struct.setCountry(getgxTv_SdtCartCheckoutData_Address_Country());
      struct.setDepartment(getgxTv_SdtCartCheckoutData_Address_Department());
      struct.setAddress(getgxTv_SdtCartCheckoutData_Address_Address());
      return struct ;
   }

   protected byte gxTv_SdtCartCheckoutData_Address_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtCartCheckoutData_Address_Name ;
   protected String gxTv_SdtCartCheckoutData_Address_Phone ;
   protected String gxTv_SdtCartCheckoutData_Address_Country ;
   protected String gxTv_SdtCartCheckoutData_Address_Department ;
   protected String gxTv_SdtCartCheckoutData_Address_Address ;
}

