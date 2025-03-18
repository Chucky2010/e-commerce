package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCartCheckoutData_PlaceOrder extends GxUserType
{
   public SdtCartCheckoutData_PlaceOrder( )
   {
      this(  new ModelContext(SdtCartCheckoutData_PlaceOrder.class));
   }

   public SdtCartCheckoutData_PlaceOrder( ModelContext context )
   {
      super( context, "SdtCartCheckoutData_PlaceOrder");
   }

   public SdtCartCheckoutData_PlaceOrder( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtCartCheckoutData_PlaceOrder");
   }

   public SdtCartCheckoutData_PlaceOrder( StructSdtCartCheckoutData_PlaceOrder struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DVelop_ECommerceCart") )
            {
               if ( gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart == null )
               {
                  gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart.readxml(oReader, "DVelop_ECommerceCart") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "DVelop_ECommerceCart") )
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
         sName = "CartCheckoutData.PlaceOrder" ;
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
      if ( gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart != null )
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
         gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart.writexml(oWriter, "DVelop_ECommerceCart", sNameSpace1, sIncludeState);
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
      if ( gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart != null )
      {
         AddObjectProperty("DVelop_ECommerceCart", gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart, false, false);
      }
   }

   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> getgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart( )
   {
      if ( gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart == null )
      {
         gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_N = (byte)(0) ;
      return gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart ;
   }

   public void setgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> value )
   {
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_N = (byte)(0) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart = value ;
   }

   public void setgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_SetNull( )
   {
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart = null ;
   }

   public boolean getgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_IsNull( )
   {
      if ( gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N( )
   {
      return gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N = (byte)(1) ;
      gxTv_SdtCartCheckoutData_PlaceOrder_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCartCheckoutData_PlaceOrder_N ;
   }

   public com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder Clone( )
   {
      return (com.mujermorena.wwpbaseobjects.SdtCartCheckoutData_PlaceOrder)(clone()) ;
   }

   public void setStruct( com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder struct )
   {
      GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item>(com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item.class, "Item", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.wwpbaseobjects.StructSdtDVelop_ECommerceCart_Item> gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux1 = struct.getDvelop_ecommercecart();
      if (gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux1.size(); i++)
         {
            gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux.add(new com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item(gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart(gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder getStruct( )
   {
      com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder struct = new com.mujermorena.wwpbaseobjects.StructSdtCartCheckoutData_PlaceOrder ();
      struct.setDvelop_ecommercecart(getgxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_N ;
   protected byte gxTv_SdtCartCheckoutData_PlaceOrder_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart_aux ;
   protected GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtDVelop_ECommerceCart_Item> gxTv_SdtCartCheckoutData_PlaceOrder_Dvelop_ecommercecart=null ;
}

