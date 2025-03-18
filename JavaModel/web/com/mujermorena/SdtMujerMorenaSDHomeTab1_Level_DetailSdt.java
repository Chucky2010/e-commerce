package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMujerMorenaSDHomeTab1_Level_DetailSdt extends GxUserType
{
   public SdtMujerMorenaSDHomeTab1_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMujerMorenaSDHomeTab1_Level_DetailSdt.class));
   }

   public SdtMujerMorenaSDHomeTab1_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMujerMorenaSDHomeTab1_Level_DetailSdt");
   }

   public SdtMujerMorenaSDHomeTab1_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtMujerMorenaSDHomeTab1_Level_DetailSdt");
   }

   public SdtMujerMorenaSDHomeTab1_Level_DetailSdt( StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Banner_items") )
            {
               if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items == null )
               {
                  gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListDataItem", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items.readxml(oReader, "Banner_items") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Banner_items") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Banner_chronometer") )
            {
               gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Products") )
            {
               if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products == null )
               {
                  gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products.readxml(oReader, "Products") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Products") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "A") )
            {
               gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Banner_count") )
            {
               gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
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
         sName = "MujerMorenaSDHomeTab1_Level_DetailSdt" ;
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
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "http://tempuri.org/" ;
         }
         else
         {
            sNameSpace1 = "http://tempuri.org/" ;
         }
         gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items.writexml(oWriter, "Banner_items", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("Banner_chronometer", GXutil.trim( GXutil.str( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "http://tempuri.org/" ;
         }
         else
         {
            sNameSpace1 = "http://tempuri.org/" ;
         }
         gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products.writexml(oWriter, "Products", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("A", GXutil.trim( GXutil.str( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Banner_count", GXutil.trim( GXutil.str( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
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
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items != null )
      {
         AddObjectProperty("Banner_items", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items, false, false);
      }
      AddObjectProperty("Banner_chronometer", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer, false, false);
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products != null )
      {
         AddObjectProperty("Products", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products, false, false);
      }
      AddObjectProperty("A", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A, false, false);
      AddObjectProperty("Banner_count", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count, false, false);
      AddObjectProperty("Gxdynprop", gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop, false, false);
   }

   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items( )
   {
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items == null )
      {
         gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListDataItem", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items = value ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_SetNull( )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items = null ;
   }

   public boolean getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_IsNull( )
   {
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items == null )
      {
         return true ;
      }
      return false ;
   }

   public short getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer( short value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer = value ;
   }

   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products( )
   {
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products == null )
      {
         gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products = value ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_SetNull( )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products = null ;
   }

   public boolean getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_IsNull( )
   {
      if ( gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products == null )
      {
         return true ;
      }
      return false ;
   }

   public short getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A( short value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A = value ;
   }

   public short getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count( short value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count = value ;
   }

   public String getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMujerMorenaSDHomeTab1_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt struct )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem>(com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem.class, "SimpleListDataItem", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.workwithplus.nativemobile.StructSdtSimpleListData_SimpleListDataItem> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux1 = struct.getBanner_items();
      if (gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux1.size(); i++)
         {
            gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux.add(new com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem(gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items(gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux);
      setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer(struct.getBanner_chronometer());
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData>(com.mujermorena.workwithplus.nativemobile.SdtWWPProductData.class, "WWPProductData", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.workwithplus.nativemobile.StructSdtWWPProductData> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux1 = struct.getProducts();
      if (gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux1.size(); i++)
         {
            gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux.add(new com.mujermorena.workwithplus.nativemobile.SdtWWPProductData(gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products(gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux);
      setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A(struct.getA());
      setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count(struct.getBanner_count());
      setgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt struct = new com.mujermorena.StructSdtMujerMorenaSDHomeTab1_Level_DetailSdt ();
      struct.setBanner_items(getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items().getStruct());
      struct.setBanner_chronometer(getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer());
      struct.setProducts(getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products().getStruct());
      struct.setA(getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A());
      struct.setBanner_count(getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count());
      struct.setGxdynprop(getgxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop());
      return struct ;
   }

   protected byte gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_N ;
   protected short gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_chronometer ;
   protected short gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_A ;
   protected short gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_count ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items_aux ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products_aux ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtSimpleListData_SimpleListDataItem> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Banner_items=null ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtWWPProductData> gxTv_SdtMujerMorenaSDHomeTab1_Level_DetailSdt_Products=null ;
}

