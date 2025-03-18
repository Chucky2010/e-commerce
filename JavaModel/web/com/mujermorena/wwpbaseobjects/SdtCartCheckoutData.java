package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCartCheckoutData extends GxUserType
{
   public SdtCartCheckoutData( )
   {
      this(  new ModelContext(SdtCartCheckoutData.class));
   }

   public SdtCartCheckoutData( ModelContext context )
   {
      super( context, "SdtCartCheckoutData");
   }

   public SdtCartCheckoutData( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtCartCheckoutData");
   }

   public SdtCartCheckoutData( StructSdtCartCheckoutData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Address") )
            {
               if ( gxTv_SdtCartCheckoutData_Address == null )
               {
                  gxTv_SdtCartCheckoutData_Address = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtCartCheckoutData_Address.readxml(oReader, "Address") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Payment") )
            {
               if ( gxTv_SdtCartCheckoutData_Payment == null )
               {
                  gxTv_SdtCartCheckoutData_Payment = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtCartCheckoutData_Payment.readxml(oReader, "Payment") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PlaceOrder") )
            {
               if ( gxTv_SdtCartCheckoutData_Placeorder == null )
               {
                  gxTv_SdtCartCheckoutData_Placeorder = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtCartCheckoutData_Placeorder.readxml(oReader, "PlaceOrder") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Completed") )
            {
               if ( gxTv_SdtCartCheckoutData_Completed == null )
               {
                  gxTv_SdtCartCheckoutData_Completed = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtCartCheckoutData_Completed.readxml(oReader, "Completed") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AuxiliarData") )
            {
               if ( gxTv_SdtCartCheckoutData_Auxiliardata == null )
               {
                  gxTv_SdtCartCheckoutData_Auxiliardata = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtCartCheckoutData_Auxiliardata.readxml(oReader, "AuxiliarData") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "AuxiliarData") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "CartCheckoutData" ;
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
      if ( gxTv_SdtCartCheckoutData_Address != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtCartCheckoutData_Address.writexml(oWriter, "Address", sNameSpace1);
      }
      if ( gxTv_SdtCartCheckoutData_Payment != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtCartCheckoutData_Payment.writexml(oWriter, "Payment", sNameSpace1);
      }
      if ( gxTv_SdtCartCheckoutData_Placeorder != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtCartCheckoutData_Placeorder.writexml(oWriter, "PlaceOrder", sNameSpace1);
      }
      if ( gxTv_SdtCartCheckoutData_Completed != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtCartCheckoutData_Completed.writexml(oWriter, "Completed", sNameSpace1);
      }
      if ( gxTv_SdtCartCheckoutData_Auxiliardata != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Mujer_Morena" ;
         }
         else
         {
            sNameSpace1 = "Mujer_Morena" ;
         }
         gxTv_SdtCartCheckoutData_Auxiliardata.writexml(oWriter, "AuxiliarData", sNameSpace1, sIncludeState);
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
      if ( gxTv_SdtCartCheckoutData_Address != null )
      {
         AddObjectProperty("Address", gxTv_SdtCartCheckoutData_Address, false, false);
      }
      if ( gxTv_SdtCartCheckoutData_Payment != null )
      {
         AddObjectProperty("Payment", gxTv_SdtCartCheckoutData_Payment, false, false);
      }
      if ( gxTv_SdtCartCheckoutData_Placeorder != null )
      {
         AddObjectProperty("PlaceOrder", gxTv_SdtCartCheckoutData_Placeorder, false, false);
      }
      if ( gxTv_SdtCartCheckoutData_Completed != null )
      {
         AddObjectProperty("Completed", gxTv_SdtCartCheckoutData_Completed, false, false);
      }
      if ( gxTv_SdtCartCheckoutData_Auxiliardata != null )
      {
         AddObjectProperty("AuxiliarData", gxTv_SdtCartCheckoutData_Auxiliardata, false, false);
      }
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address getgxTv_SdtCartCheckoutData_Address( )
   {
      if ( gxTv_SdtCartCheckoutData_Address == null )
      {
         gxTv_SdtCartCheckoutData_Address = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address(remoteHandle, context);
      }
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      return gxTv_SdtCartCheckoutData_Address ;
   }

   public void setgxTv_SdtCartCheckoutData_Address( com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address value )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Address = value;
   }

   public void setgxTv_SdtCartCheckoutData_Address_SetNull( )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Address = (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address)null;
   }

   public boolean getgxTv_SdtCartCheckoutData_Address_IsNull( )
   {
      if ( gxTv_SdtCartCheckoutData_Address == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtCartCheckoutData_Address_N( )
   {
      return gxTv_SdtCartCheckoutData_Address_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment getgxTv_SdtCartCheckoutData_Payment( )
   {
      if ( gxTv_SdtCartCheckoutData_Payment == null )
      {
         gxTv_SdtCartCheckoutData_Payment = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment(remoteHandle, context);
      }
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      return gxTv_SdtCartCheckoutData_Payment ;
   }

   public void setgxTv_SdtCartCheckoutData_Payment( com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment value )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Payment = value;
   }

   public void setgxTv_SdtCartCheckoutData_Payment_SetNull( )
   {
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Payment = (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment)null;
   }

   public boolean getgxTv_SdtCartCheckoutData_Payment_IsNull( )
   {
      if ( gxTv_SdtCartCheckoutData_Payment == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtCartCheckoutData_Payment_N( )
   {
      return gxTv_SdtCartCheckoutData_Payment_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder getgxTv_SdtCartCheckoutData_Placeorder( )
   {
      if ( gxTv_SdtCartCheckoutData_Placeorder == null )
      {
         gxTv_SdtCartCheckoutData_Placeorder = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder(remoteHandle, context);
      }
      gxTv_SdtCartCheckoutData_Placeorder_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      return gxTv_SdtCartCheckoutData_Placeorder ;
   }

   public void setgxTv_SdtCartCheckoutData_Placeorder( com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder value )
   {
      gxTv_SdtCartCheckoutData_Placeorder_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Placeorder = value;
   }

   public void setgxTv_SdtCartCheckoutData_Placeorder_SetNull( )
   {
      gxTv_SdtCartCheckoutData_Placeorder_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Placeorder = (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder)null;
   }

   public boolean getgxTv_SdtCartCheckoutData_Placeorder_IsNull( )
   {
      if ( gxTv_SdtCartCheckoutData_Placeorder == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtCartCheckoutData_Placeorder_N( )
   {
      return gxTv_SdtCartCheckoutData_Placeorder_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed getgxTv_SdtCartCheckoutData_Completed( )
   {
      if ( gxTv_SdtCartCheckoutData_Completed == null )
      {
         gxTv_SdtCartCheckoutData_Completed = new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed(remoteHandle, context);
      }
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      return gxTv_SdtCartCheckoutData_Completed ;
   }

   public void setgxTv_SdtCartCheckoutData_Completed( com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed value )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Completed = value;
   }

   public void setgxTv_SdtCartCheckoutData_Completed_SetNull( )
   {
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Completed = (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed)null;
   }

   public boolean getgxTv_SdtCartCheckoutData_Completed_IsNull( )
   {
      if ( gxTv_SdtCartCheckoutData_Completed == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtCartCheckoutData_Completed_N( )
   {
      return gxTv_SdtCartCheckoutData_Completed_N ;
   }

   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> getgxTv_SdtCartCheckoutData_Auxiliardata( )
   {
      if ( gxTv_SdtCartCheckoutData_Auxiliardata == null )
      {
         gxTv_SdtCartCheckoutData_Auxiliardata = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtCartCheckoutData_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      return gxTv_SdtCartCheckoutData_Auxiliardata ;
   }

   public void setgxTv_SdtCartCheckoutData_Auxiliardata( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      gxTv_SdtCartCheckoutData_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_Auxiliardata = value ;
   }

   public void setgxTv_SdtCartCheckoutData_Auxiliardata_SetNull( )
   {
      gxTv_SdtCartCheckoutData_Auxiliardata_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Auxiliardata = null ;
   }

   public boolean getgxTv_SdtCartCheckoutData_Auxiliardata_IsNull( )
   {
      if ( gxTv_SdtCartCheckoutData_Auxiliardata == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtCartCheckoutData_Auxiliardata_N( )
   {
      return gxTv_SdtCartCheckoutData_Auxiliardata_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCartCheckoutData_Address_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Payment_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Placeorder_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Completed_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_Auxiliardata_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCartCheckoutData_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData struct )
   {
      setgxTv_SdtCartCheckoutData_Address(new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address(struct.getAddress()));
      setgxTv_SdtCartCheckoutData_Payment(new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment(struct.getPayment()));
      setgxTv_SdtCartCheckoutData_Placeorder(new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder(struct.getPlaceorder()));
      setgxTv_SdtCartCheckoutData_Completed(new com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed(struct.getCompleted()));
      GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtCartCheckoutData_Auxiliardata_aux = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtCartCheckoutData_Auxiliardata_aux1 = struct.getAuxiliardata();
      if (gxTv_SdtCartCheckoutData_Auxiliardata_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtCartCheckoutData_Auxiliardata_aux1.size(); i++)
         {
            gxTv_SdtCartCheckoutData_Auxiliardata_aux.add(new com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem(gxTv_SdtCartCheckoutData_Auxiliardata_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtCartCheckoutData_Auxiliardata(gxTv_SdtCartCheckoutData_Auxiliardata_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData struct = new com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData ();
      struct.setAddress(getgxTv_SdtCartCheckoutData_Address().getStruct());
      struct.setPayment(getgxTv_SdtCartCheckoutData_Payment().getStruct());
      struct.setPlaceorder(getgxTv_SdtCartCheckoutData_Placeorder().getStruct());
      struct.setCompleted(getgxTv_SdtCartCheckoutData_Completed().getStruct());
      struct.setAuxiliardata(getgxTv_SdtCartCheckoutData_Auxiliardata().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtCartCheckoutData_Address_N ;
   protected byte gxTv_SdtCartCheckoutData_N ;
   protected byte gxTv_SdtCartCheckoutData_Payment_N ;
   protected byte gxTv_SdtCartCheckoutData_Placeorder_N ;
   protected byte gxTv_SdtCartCheckoutData_Completed_N ;
   protected byte gxTv_SdtCartCheckoutData_Auxiliardata_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtCartCheckoutData_Auxiliardata_aux ;
   protected GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtCartCheckoutData_Auxiliardata=null ;
   protected com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Address gxTv_SdtCartCheckoutData_Address=null ;
   protected com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Payment gxTv_SdtCartCheckoutData_Payment=null ;
   protected com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder gxTv_SdtCartCheckoutData_Placeorder=null ;
   protected com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_Completed gxTv_SdtCartCheckoutData_Completed=null ;
}

