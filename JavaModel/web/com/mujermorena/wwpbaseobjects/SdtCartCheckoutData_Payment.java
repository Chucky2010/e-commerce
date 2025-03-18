package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCartCheckoutData_Payment extends GxUserType
{
   public SdtCartCheckoutData_Payment( )
   {
      this(  new ModelContext(SdtCartCheckoutData_Payment.class));
   }

   public SdtCartCheckoutData_Payment( ModelContext context )
   {
      super( context, "SdtCartCheckoutData_Payment");
   }

   public SdtCartCheckoutData_Payment( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtCartCheckoutData_Payment");
   }

   public SdtCartCheckoutData_Payment( StructSdtCartCheckoutData_Payment struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaymentData_Description") )
            {
               gxTv_SdtCartCheckoutData_Payment_Paymentdata_description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaymentData") )
            {
               gxTv_SdtCartCheckoutData_Payment_Paymentdata = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaymentData2_Description") )
            {
               gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaymentData2") )
            {
               gxTv_SdtCartCheckoutData_Payment_Paymentdata2 = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaymentData3") )
            {
               gxTv_SdtCartCheckoutData_Payment_Paymentdata3 = oReader.getValue() ;
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
         sName = "CartCheckoutData.Payment" ;
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
      oWriter.writeElement("PaymentData_Description", gxTv_SdtCartCheckoutData_Payment_Paymentdata_description);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PaymentData", gxTv_SdtCartCheckoutData_Payment_Paymentdata);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PaymentData2_Description", gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PaymentData2", GXutil.trim( GXutil.str( gxTv_SdtCartCheckoutData_Payment_Paymentdata2, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("PaymentData3", gxTv_SdtCartCheckoutData_Payment_Paymentdata3);
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
      AddObjectProperty("PaymentData_Description", gxTv_SdtCartCheckoutData_Payment_Paymentdata_description, false, false);
      AddObjectProperty("PaymentData", gxTv_SdtCartCheckoutData_Payment_Paymentdata, false, false);
      AddObjectProperty("PaymentData2_Description", gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description, false, false);
      AddObjectProperty("PaymentData2", gxTv_SdtCartCheckoutData_Payment_Paymentdata2, false, false);
      AddObjectProperty("PaymentData3", gxTv_SdtCartCheckoutData_Payment_Paymentdata3, false, false);
   }

   public String getgxTv_SdtCartCheckoutData_Payment_Paymentdata_description( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata_description ;
   }

   public void setgxTv_SdtCartCheckoutData_Payment_Paymentdata_description( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata_description = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Payment_Paymentdata( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata ;
   }

   public void setgxTv_SdtCartCheckoutData_Payment_Paymentdata( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description ;
   }

   public void setgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description = value ;
   }

   public short getgxTv_SdtCartCheckoutData_Payment_Paymentdata2( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata2 ;
   }

   public void setgxTv_SdtCartCheckoutData_Payment_Paymentdata2( short value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata2 = value ;
   }

   public String getgxTv_SdtCartCheckoutData_Payment_Paymentdata3( )
   {
      return gxTv_SdtCartCheckoutData_Payment_Paymentdata3 ;
   }

   public void setgxTv_SdtCartCheckoutData_Payment_Paymentdata3( String value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata3 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCartCheckoutData_Payment_Paymentdata_description = "" ;
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata = "" ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description = "" ;
      gxTv_SdtCartCheckoutData_Payment_Paymentdata3 = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCartCheckoutData_Payment_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment struct )
   {
      setgxTv_SdtCartCheckoutData_Payment_Paymentdata_description(struct.getPaymentdata_description());
      setgxTv_SdtCartCheckoutData_Payment_Paymentdata(struct.getPaymentdata());
      setgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description(struct.getPaymentdata2_description());
      setgxTv_SdtCartCheckoutData_Payment_Paymentdata2(struct.getPaymentdata2());
      setgxTv_SdtCartCheckoutData_Payment_Paymentdata3(struct.getPaymentdata3());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment struct = new com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_Payment ();
      struct.setPaymentdata_description(getgxTv_SdtCartCheckoutData_Payment_Paymentdata_description());
      struct.setPaymentdata(getgxTv_SdtCartCheckoutData_Payment_Paymentdata());
      struct.setPaymentdata2_description(getgxTv_SdtCartCheckoutData_Payment_Paymentdata2_description());
      struct.setPaymentdata2(getgxTv_SdtCartCheckoutData_Payment_Paymentdata2());
      struct.setPaymentdata3(getgxTv_SdtCartCheckoutData_Payment_Paymentdata3());
      return struct ;
   }

   protected byte gxTv_SdtCartCheckoutData_Payment_N ;
   protected short gxTv_SdtCartCheckoutData_Payment_Paymentdata2 ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata3 ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata_description ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata ;
   protected String gxTv_SdtCartCheckoutData_Payment_Paymentdata2_description ;
}

